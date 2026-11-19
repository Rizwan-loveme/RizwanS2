package com.srizwan.win11

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView

// =====================================================================
// GLASS POPUP MENU (drop-in replacement for android.widget.PopupMenu)
// =====================================================================
//
// Same call shape as PopupMenu:
//   val m = GlassMenu(ctx, anchor)            // or GlassMenu(ctx, anchor, Gravity.END)
//   m.menu.add(0, id, order, "Title")
//   m.setOnMenuItemClickListener { item -> when (item.itemId) { ... }; true }
//   m.show()
// It draws a frosted, rounded, bordered card (same look as W11Dialog / Start menu)
// and closes when the user taps outside it.

class GlassMenu(
    private val ctx: Context,
    private val anchor: View,
    private val gravity: Int = Gravity.START
) {
    class Entry(val groupId: Int, val itemId: Int, val order: Int, val title: CharSequence)

    class Items {
        internal val list = ArrayList<Entry>()
        fun add(groupId: Int, itemId: Int, order: Int, title: CharSequence): Entry {
            val e = Entry(groupId, itemId, order, title)
            list.add(e)
            return e
        }
    }

    val menu = Items()
    private var listener: ((Entry) -> Boolean)? = null
    private var popup: PopupWindow? = null

    fun setOnMenuItemClickListener(l: (Entry) -> Boolean) { listener = l }

    fun dismiss() { try { popup?.dismiss() } catch (_: Throwable) {} }

    private fun dp(v: Int) = (v * ctx.resources.displayMetrics.density).toInt()

    fun show() {
        val entries = menu.list.sortedBy { it.order }
        if (entries.isEmpty()) return
        val lang = DialogFont.languageOf(*entries.map { it.title }.toTypedArray())
        val tf = DialogFont.typeface(ctx, lang, false)

        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(4), dp(6), dp(4), dp(6))
            background = GradientDrawable().apply {
                cornerRadius = dp(10).toFloat()
                setColor(Color.parseColor("#EE1E2230"))
                setStroke(dp(1), Color.parseColor("#40FFFFFF"))
            }
        }
        entries.forEach { e ->
            card.addView(TextView(ctx).apply {
                text = e.title
                typeface = tf
                textSize = 14f
                setTextColor(Color.WHITE)
                setPadding(dp(14), dp(11), dp(14), dp(11))
                minWidth = dp(168)
                background = GradientDrawable().apply { cornerRadius = dp(6).toFloat(); setColor(Color.TRANSPARENT) }
                setOnTouchListener { v, ev ->
                    when (ev.action) {
                        MotionEvent.ACTION_DOWN -> (v.background as? GradientDrawable)?.setColor(Color.parseColor("#33FFFFFF"))
                        MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL ->
                            (v.background as? GradientDrawable)?.setColor(Color.TRANSPARENT)
                    }
                    false
                }
                setOnClickListener {
                    dismiss()
                    try { listener?.invoke(e) } catch (t: Throwable) { AppLog.e("GlassMenu", "item failed", t) }
                }
            }, LinearLayout.LayoutParams(-1, -2))
        }

        val pw = PopupWindow(card, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        pw.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pw.isOutsideTouchable = true
        pw.elevation = dp(10).toFloat()
        popup = pw
        try {
            pw.showAsDropDown(anchor, 0, 0, gravity)
        } catch (t: Throwable) {
            AppLog.e("GlassMenu", "show failed", t)
        }
    }
}

// =====================================================================
// GLASS SEARCH FIELD + GLASS INPUT STYLE
// =====================================================================

/** Rounded translucent search pill: vector search icon, EditText, vector clear (X) button. */
class GlassSearch(ctx: Context, hintText: String, heightDp: Int = 40, onChange: ((String) -> Unit)? = null) {
    val root: LinearLayout
    val edit: EditText

    init {
        fun dp(v: Int) = (v * ctx.resources.displayMetrics.density).toInt()
        root = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(14), 0, dp(6), 0)
            background = GradientDrawable().apply {
                cornerRadius = dp(20).toFloat()
                setColor(W11.START_SEARCH_BG)
                setStroke(1, W11.START_BORDER)
            }
            layoutParams = LinearLayout.LayoutParams(-1, dp(heightDp))
        }
        root.addView(VectorIconView(ctx, VectorIconView.SEARCH).apply {
            setIconColor(W11.TEXT_DIM)
            layoutParams = LinearLayout.LayoutParams(dp(16), dp(16))
        })
        val clear = ImageView(ctx).apply {
            setImageResource(R.drawable.ic_qs_close)
            setColorFilter(W11.TEXT_DIM)
            contentDescription = "Clear search"
            setPadding(dp(9), dp(9), dp(9), dp(9))
            visibility = View.GONE
            layoutParams = LinearLayout.LayoutParams(dp(34), dp(34))
        }
        edit = EditText(ctx).apply {
            hint = hintText
            setHintTextColor(W11.TEXT_DIM)
            setTextColor(W11.TEXT)
            textSize = 14f
            setSingleLine(true)
            background = null
            setPadding(dp(10), 0, dp(4), 0)
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            imeOptions = EditorInfo.IME_ACTION_SEARCH or EditorInfo.IME_FLAG_NO_EXTRACT_UI
            layoutParams = LinearLayout.LayoutParams(0, -1, 1f)
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
                override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    clear.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
                    onChange?.invoke(s?.toString() ?: "")
                }
            })
        }
        clear.setOnClickListener { edit.setText("") }
        root.addView(edit)
        root.addView(clear)
    }
}

/** Glass look for a plain EditText that sits inside a glass dialog (white text, frosted rounded field). */
fun EditText.glassStyle(): EditText {
    val d = resources.displayMetrics.density
    setTextColor(Color.WHITE)
    setHintTextColor(Color.parseColor("#80FFFFFF"))
    setPadding((12 * d).toInt(), (10 * d).toInt(), (12 * d).toInt(), (10 * d).toInt())
    background = GradientDrawable().apply {
        cornerRadius = 8 * d
        setColor(Color.parseColor("#26FFFFFF"))
        setStroke(1, Color.parseColor("#40FFFFFF"))
    }
    return this
}

// =====================================================================
// GLASS SLIDER (Windows 11 style: thin track, accent fill, round thumb)
// =====================================================================

class GlassSlider(ctx: Context) : View(ctx) {
    var max = 100
    var value = 0
        set(v) { field = v.coerceIn(0, max); invalidate() }
    /** Called with (value, fromUser). */
    var onChange: ((Int, Boolean) -> Unit)? = null
    /** Called when a drag finishes. */
    var onDone: (() -> Unit)? = null
    /** If it returns false the slider ignores the touch (e.g. permission missing). */
    var onGate: (() -> Boolean)? = null

    private val p = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rect = RectF()
    var dragging = false
        private set
    private val d = ctx.resources.displayMetrics.density

    init { isClickable = true; isFocusable = true }

    override fun onDraw(c: Canvas) {
        val pad = 12 * d
        val w = width - pad * 2
        val cy = height / 2f
        val frac = if (max == 0) 0f else value.toFloat() / max
        val x = pad + w * frac
        // track
        p.style = Paint.Style.FILL
        p.color = Color.argb(70, 255, 255, 255)
        rect.set(pad, cy - 2 * d, pad + w, cy + 2 * d)
        c.drawRoundRect(rect, 2 * d, 2 * d, p)
        // fill
        p.color = W11.ACCENT
        rect.set(pad, cy - 2 * d, x, cy + 2 * d)
        c.drawRoundRect(rect, 2 * d, 2 * d, p)
        // thumb (grows a little while dragging, like Win11)
        val r = if (dragging) 9 * d else 8 * d
        p.color = Color.argb(60, 0, 0, 0)
        c.drawCircle(x, cy + 1 * d, r + 1 * d, p)
        p.color = Color.WHITE
        c.drawCircle(x, cy, r, p)
        p.color = W11.ACCENT
        c.drawCircle(x, cy, if (dragging) 4.5f * d else 3.5f * d, p)
    }

    private fun valueAt(x: Float): Int {
        val pad = 12 * d
        val w = (width - pad * 2).coerceAtLeast(1f)
        return Math.round(((x - pad) / w).coerceIn(0f, 1f) * max)
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when (e.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                if (onGate?.invoke() == false) return false
                dragging = true
                parent?.requestDisallowInterceptTouchEvent(true)
                value = valueAt(e.x)
                onChange?.invoke(value, true)
            }
            MotionEvent.ACTION_MOVE -> if (dragging) {
                value = valueAt(e.x)
                onChange?.invoke(value, true)
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> if (dragging) {
                dragging = false
                invalidate()
                parent?.requestDisallowInterceptTouchEvent(false)
                onDone?.invoke()
                if (e.actionMasked == MotionEvent.ACTION_UP) performClick()
            }
        }
        return true
    }

    override fun performClick(): Boolean { super.performClick(); return true }
}
