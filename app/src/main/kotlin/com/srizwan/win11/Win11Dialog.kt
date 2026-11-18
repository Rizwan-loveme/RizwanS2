package com.srizwan.win11

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import java.util.Locale

// =====================================================================
// DIALOG FONT (follows the language of the text being shown)
// =====================================================================
//
// The font is picked from the script of the dialog's own text (Bengali text →
// Bengali font, Arabic → Arabic font, …). To ship your own font, drop a file in
//   app/src/main/assets/fonts/<code>.ttf   (or .otf)
// with <code> one of: bn, ar, hi, ta, te, ur, th, ko, ja, zh, ru, el
// If no file exists the system font for that script is used (Android already
// carries Noto fonts for these scripts), so nothing breaks without assets.

object DialogFont {

    private val cache = HashMap<String, Typeface?>()

    private fun scriptCode(text: CharSequence): String? {
        var i = 0
        while (i < text.length) {
            val cp = Character.codePointAt(text, i)
            i += Character.charCount(cp)
            if (cp < 0x80 || !Character.isLetter(cp)) continue
            val code = when (Character.UnicodeScript.of(cp)) {
                Character.UnicodeScript.BENGALI -> "bn"
                Character.UnicodeScript.ARABIC -> "ar"
                Character.UnicodeScript.DEVANAGARI -> "hi"
                Character.UnicodeScript.TAMIL -> "ta"
                Character.UnicodeScript.TELUGU -> "te"
                Character.UnicodeScript.THAI -> "th"
                Character.UnicodeScript.HANGUL -> "ko"
                Character.UnicodeScript.HIRAGANA, Character.UnicodeScript.KATAKANA -> "ja"
                Character.UnicodeScript.HAN -> "zh"
                Character.UnicodeScript.CYRILLIC -> "ru"
                Character.UnicodeScript.GREEK -> "el"
                else -> null
            }
            if (code != null) return code
        }
        return null
    }

    /** Language code for a set of strings: the first non-Latin script found, else null. */
    fun languageOf(vararg texts: CharSequence?): String? {
        for (t in texts) {
            if (t.isNullOrEmpty()) continue
            scriptCode(t)?.let { return it }
        }
        return null
    }

    private fun fromAssets(ctx: Context, code: String): Typeface? {
        synchronized(cache) {
            if (cache.containsKey(code)) return cache[code]
            var tf: Typeface? = null
            for (ext in arrayOf("ttf", "otf")) {
                try {
                    tf = Typeface.createFromAsset(ctx.assets, "fonts/$code.$ext")
                    break
                } catch (e: Exception) { }
            }
            cache[code] = tf
            return tf
        }
    }

    /** Typeface for [lang] (null = Latin/default) in the requested weight. */
    fun typeface(ctx: Context, lang: String?, bold: Boolean): Typeface {
        val style = if (bold) Typeface.BOLD else Typeface.NORMAL
        if (lang != null) {
            fromAssets(ctx, lang)?.let { return Typeface.create(it, style) }
            // System fallback: the default sans family already maps these scripts
            // to the right Noto font on Android.
            return Typeface.create("sans-serif", style)
        }
        return Typeface.create(if (bold) "sans-serif-medium" else "sans-serif", Typeface.NORMAL)
    }
}

// =====================================================================
// WIN11 DIALOG (drop-in replacement for AlertDialog.Builder)
// =====================================================================

class W11Dialog private constructor(private val ctx: Context) : Dialog(ctx) {

    private var title: CharSequence? = null
    private var message: CharSequence? = null
    private var customView: View? = null
    private var items: Array<out CharSequence>? = null
    private var itemsListener: DialogInterface.OnClickListener? = null
    private var checkedItem = -1
    private var singleChoice = false
    private var posText: CharSequence? = null
    private var posListener: DialogInterface.OnClickListener? = null
    private var negText: CharSequence? = null
    private var negListener: DialogInterface.OnClickListener? = null

    private var messageView: TextView? = null
    private var built = false

    private fun dp(v: Int): Int = (v * ctx.resources.displayMetrics.density).toInt()
    private fun dpf(v: Float): Float = v * ctx.resources.displayMetrics.density

    /** Live update used by progress-style dialogs. */
    fun setMessage(m: CharSequence?) {
        message = m
        messageView?.let {
            it.text = m
            it.typeface = DialogFont.typeface(ctx, DialogFont.languageOf(m, title), false)
        }
    }

    override fun show() {
        if (!built) { buildContent(); built = true }
        super.show()
        window?.setLayout(
            (ctx.resources.displayMetrics.widthPixels * 0.88f).toInt().coerceAtMost(dp(420)),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    private fun buildContent() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setDimAmount(0.55f)

        // One language for the whole dialog, decided from everything it shows.
        val lang = DialogFont.languageOf(
            title, message, posText, negText,
            *(items?.map { it }?.toTypedArray() ?: emptyArray())
        )
        val regular = DialogFont.typeface(ctx, lang, false)
        val strong = DialogFont.typeface(ctx, lang, true)

        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable().apply {
                cornerRadius = dpf(12f)
                setColor(Color.parseColor("#2B2B2B"))
                setStroke(dp(1), Color.parseColor("#3D3D3D"))
            }
            setPadding(dp(22), dp(20), dp(22), dp(16))
        }

        if (!title.isNullOrEmpty()) {
            card.addView(TextView(ctx).apply {
                text = title
                setTextColor(Color.WHITE)
                textSize = 18f
                typeface = strong
                maxLines = 3
                ellipsize = TextUtils.TruncateAt.END
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(10) }
            })
        }

        if (!message.isNullOrEmpty()) {
            val tv = TextView(ctx).apply {
                text = message
                setTextColor(Color.parseColor("#D0D0D0"))
                textSize = 14f
                typeface = regular
                setLineSpacing(0f, 1.15f)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(8) }
            }
            messageView = tv
            val sv = ScrollView(ctx).apply {
                isVerticalScrollBarEnabled = false
                addView(tv)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            card.addView(sv)
        }

        customView?.let { v ->
            (v.parent as? ViewGroup)?.removeView(v)
            card.addView(v, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(8) })
        }

        items?.let { list ->
            val col = LinearLayout(ctx).apply { orientation = LinearLayout.VERTICAL }
            list.forEachIndexed { idx, label ->
                col.addView(itemRow(label, idx, regular))
            }
            val sv = ScrollView(ctx).apply {
                isVerticalScrollBarEnabled = false
                addView(col)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(6) }
            }
            card.addView(sv)
        }

        if (posText != null || negText != null) {
            val row = LinearLayout(ctx).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.END or Gravity.CENTER_VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { topMargin = dp(10) }
            }
            negText?.let { t ->
                row.addView(button(t, strong, primary = false) {
                    dismiss(); negListener?.onClick(this, DialogInterface.BUTTON_NEGATIVE)
                })
            }
            posText?.let { t ->
                row.addView(button(t, strong, primary = true) {
                    dismiss(); posListener?.onClick(this, DialogInterface.BUTTON_POSITIVE)
                })
            }
            card.addView(row)
        }

        val holder = FrameLayout(ctx)
        holder.addView(card, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ))
        setContentView(holder)
    }

    private fun button(text: CharSequence, tf: Typeface, primary: Boolean, onClick: () -> Unit): TextView =
        TextView(ctx).apply {
            this.text = text
            typeface = tf
            textSize = 14f
            gravity = Gravity.CENTER
            minWidth = dp(84)
            setTextColor(if (primary) Color.BLACK else Color.WHITE)
            setPadding(dp(18), dp(9), dp(18), dp(9))
            val base = if (primary) W11.ACCENT else Color.parseColor("#3A3A3A")
            val pressed = if (primary) Color.parseColor("#3AA6DB") else Color.parseColor("#4A4A4A")
            fun bg(c: Int) = GradientDrawable().apply { cornerRadius = dpf(6f); setColor(c) }
            background = bg(base)
            setOnTouchListener { v, ev ->
                when (ev.action) {
                    MotionEvent.ACTION_DOWN -> v.background = bg(pressed)
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.background = bg(base)
                }
                false
            }
            setOnClickListener { onClick() }
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { leftMargin = dp(8) }
        }

    private fun itemRow(label: CharSequence, index: Int, tf: Typeface): View {
        val row = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(10), dp(12), dp(10), dp(12))
            background = GradientDrawable().apply { cornerRadius = dpf(6f); setColor(Color.TRANSPARENT) }
            setOnTouchListener { v, ev ->
                when (ev.action) {
                    MotionEvent.ACTION_DOWN -> v.setBackgroundColor(Color.parseColor("#3A3A3A"))
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.setBackgroundColor(Color.TRANSPARENT)
                }
                false
            }
            setOnClickListener {
                dismiss()
                itemsListener?.onClick(this@W11Dialog, index)
            }
        }
        if (singleChoice) {
            val selected = index == checkedItem
            row.addView(object : View(ctx) {
                private val p = Paint(Paint.ANTI_ALIAS_FLAG)
                override fun onDraw(c: Canvas) {
                    val cx = width / 2f; val cy = height / 2f
                    val r = minOf(width, height) / 2f - dpf(2f)
                    p.style = Paint.Style.STROKE; p.strokeWidth = dpf(1.6f)
                    p.color = if (selected) W11.ACCENT else Color.parseColor("#9D9D9D")
                    c.drawCircle(cx, cy, r, p)
                    if (selected) {
                        p.style = Paint.Style.FILL
                        c.drawCircle(cx, cy, r * 0.5f, p)
                    }
                }
            }.apply {
                layoutParams = LinearLayout.LayoutParams(dp(20), dp(20)).apply { rightMargin = dp(12) }
            })
        }
        row.addView(TextView(ctx).apply {
            text = label
            typeface = tf
            textSize = 15f
            setTextColor(Color.WHITE)
        })
        return row
    }

    // ── Builder (same call shape as AlertDialog.Builder) ─────────────

    class Builder(private val ctx: Context) {
        private val d = W11Dialog(ctx)

        fun setTitle(t: CharSequence?): Builder { d.title = t; return this }
        fun setMessage(m: CharSequence?): Builder { d.message = m; return this }
        fun setView(v: View?): Builder { d.customView = v; return this }
        fun setCancelable(c: Boolean): Builder { d.setCancelable(c); return this }

        fun setItems(items: Array<out CharSequence>, l: DialogInterface.OnClickListener?): Builder {
            d.items = items; d.itemsListener = l; d.singleChoice = false; return this
        }

        fun setSingleChoiceItems(
            items: Array<out CharSequence>, checked: Int, l: DialogInterface.OnClickListener?
        ): Builder {
            d.items = items; d.itemsListener = l; d.checkedItem = checked; d.singleChoice = true
            return this
        }

        fun setPositiveButton(t: CharSequence, l: DialogInterface.OnClickListener?): Builder {
            d.posText = t; d.posListener = l; return this
        }

        fun setNegativeButton(t: CharSequence, l: DialogInterface.OnClickListener?): Builder {
            d.negText = t; d.negListener = l; return this
        }

        fun create(): W11Dialog = d

        fun show(): W11Dialog { d.show(); return d }
    }

    companion object {
        /**
         * Standard "are you sure?" box. Anything that closes, stops, cancels or
         * powers something down goes through this, so nothing is stopped
         * without the user's say-so.
         */
        fun confirm(
            ctx: Context, title: CharSequence, message: CharSequence,
            yes: CharSequence = "Yes", no: CharSequence = "Cancel", onYes: () -> Unit
        ) {
            Builder(ctx).setTitle(title).setMessage(message)
                .setPositiveButton(yes) { _, _ -> onYes() }
                .setNegativeButton(no, null)
                .show()
        }
    }
}
