package com.srizwan.win11

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.TextViewCompat
import java.math.BigDecimal
import java.math.MathContext

/**
 * Built-in Calculator (Win11 glass style, programmatic UI, vector icons only).
 * Standard calculator: + - x / %, +/-, backspace, clear, live result preview.
 * Opened from Start (built-in "Calculator" app) or rizwans2://calculator.
 */
class CalculatorActivity : AppCompatActivity() {

    private lateinit var exprView: TextView     // big line: the expression being typed / the result
    private lateinit var previewView: TextView  // small line: live preview or "previous expression ="

    // Internal operators are + - * / (display converts them to the proper symbols).
    private val expr = StringBuilder()
    private var justEvaluated = false
    private var errorMsg: String? = null
    private var glassBlur = false

    private fun dp(v: Int): Int = (v * resources.displayMetrics.density).toInt()

    // =====================================================================
    // LIFECYCLE / UI
    // =====================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try { supportActionBar?.hide() } catch (e: Exception) { }
        try {
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.TRANSPARENT
            @Suppress("DEPRECATION")
            window.navigationBarColor = Color.TRANSPARENT
            if (android.os.Build.VERSION.SDK_INT >= 31) {
                val wm = getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager
                if (wm.isCrossWindowBlurEnabled) {
                    window.setBackgroundBlurRadius(dp(40))
                    glassBlur = true
                }
            }
        } catch (e: Exception) { }
        try {
            setContentView(buildScreen())
            androidx.core.view.WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
            refresh()
        } catch (e: Throwable) {
            AppLog.e("Calc", "calculator UI failed", e)
            finish()
        }
    }

    private fun buildScreen(): View {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(if (glassBlur) Color.argb(150, 24, 27, 34) else Color.argb(228, 24, 27, 34))
        root.layoutParams = ViewGroup.LayoutParams(mp, mp)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }

        // ── Title bar: back + calculator icon + title ──
        val titleBar = LinearLayout(this)
        titleBar.orientation = LinearLayout.HORIZONTAL
        titleBar.gravity = Gravity.CENTER_VERTICAL
        titleBar.setPadding(dp(6), 0, dp(14), 0)
        titleBar.layoutParams = LinearLayout.LayoutParams(mp, dp(52))
        titleBar.addView(backButton())
        val ic = TextView(this)
        ic.iconOnly(R.drawable.ic_w_calculator, 18, W11.TEXT)
        ic.layoutParams = LinearLayout.LayoutParams(dp(18), dp(18)).apply { leftMargin = dp(6) }
        titleBar.addView(ic)
        val title = TextView(this)
        title.text = "Calculator"
        title.setTextColor(W11.TEXT)
        title.textSize = 17f
        title.typeface = Typeface.DEFAULT_BOLD
        title.setPadding(dp(10), 0, 0, 0)
        titleBar.addView(title)
        root.addView(titleBar)

        // ── Display ──
        val display = LinearLayout(this)
        display.orientation = LinearLayout.VERTICAL
        display.gravity = Gravity.BOTTOM or Gravity.END
        display.setPadding(dp(20), dp(8), dp(20), dp(14))
        display.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)

        previewView = TextView(this).apply {
            setTextColor(W11.TEXT_DIM)
            textSize = 17f
            gravity = Gravity.END
            maxLines = 1
            layoutParams = LinearLayout.LayoutParams(mp, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        exprView = TextView(this).apply {
            setTextColor(W11.TEXT)
            typeface = Typeface.create("sans-serif-light", Typeface.NORMAL)
            gravity = Gravity.END or Gravity.CENTER_VERTICAL
            maxLines = 1
            textSize = 52f
            layoutParams = LinearLayout.LayoutParams(mp, dp(76))
        }
        try {
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                exprView, 26, 56, 2, TypedValue.COMPLEX_UNIT_SP
            )
        } catch (e: Throwable) { }
        display.addView(previewView)
        display.addView(exprView)
        root.addView(display)

        // ── Keypad (5 rows x 4) ──
        val pad = LinearLayout(this)
        pad.orientation = LinearLayout.VERTICAL
        pad.setPadding(dp(8), dp(4), dp(8), dp(10))
        pad.layoutParams = LinearLayout.LayoutParams(mp, 0, 2.5f)

        pad.addView(row(
            textKey("C", FUNC) { clearAll() },
            iconKey(R.drawable.ic_w_backspace, FUNC, { back() }, { clearAll() }),
            iconKey(R.drawable.ic_calc_percent, FUNC, { percent() }),
            iconKey(R.drawable.ic_calc_divide, FUNC, { op('/') })
        ))
        pad.addView(row(
            textKey("7", DIGIT) { digit('7') }, textKey("8", DIGIT) { digit('8') },
            textKey("9", DIGIT) { digit('9') },
            iconKey(R.drawable.ic_calc_multiply, FUNC, { op('*') })
        ))
        pad.addView(row(
            textKey("4", DIGIT) { digit('4') }, textKey("5", DIGIT) { digit('5') },
            textKey("6", DIGIT) { digit('6') },
            iconKey(R.drawable.ic_calc_minus, FUNC, { op('-') })
        ))
        pad.addView(row(
            textKey("1", DIGIT) { digit('1') }, textKey("2", DIGIT) { digit('2') },
            textKey("3", DIGIT) { digit('3') },
            iconKey(R.drawable.ic_calc_plus, FUNC, { op('+') })
        ))
        pad.addView(row(
            iconKey(R.drawable.ic_calc_plusminus, DIGIT, { negate() }),
            textKey("0", DIGIT) { digit('0') },
            textKey(".", DIGIT) { dot() },
            iconKey(R.drawable.ic_calc_equals, EQUALS, { equalsPressed() })
        ))
        root.addView(pad)
        return root
    }

    private fun backButton(): FrameLayout {
        val box = FrameLayout(this)
        box.layoutParams = LinearLayout.LayoutParams(dp(40), dp(40))
        val ic = VectorIconView(this, VectorIconView.BACK)
        ic.setIconColor(Color.WHITE)
        ic.layoutParams = FrameLayout.LayoutParams(dp(20), dp(20), Gravity.CENTER)
        box.addView(ic)
        box.isClickable = true
        box.contentDescription = "Back"
        box.setOnClickListener { finish() }
        return box
    }

    // ── key factories ──────────────────────────────────────────────────

    private companion object {
        const val DIGIT = 0
        const val FUNC = 1
        const val EQUALS = 2
        const val MAX_LEN = 40
    }

    private fun row(vararg keys: View): LinearLayout {
        val r = LinearLayout(this)
        r.orientation = LinearLayout.HORIZONTAL
        r.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        keys.forEach { r.addView(it) }
        return r
    }

    private fun keyBase(kind: Int): TextView {
        val t = TextView(this)
        val fill = when (kind) {
            EQUALS -> W11.ACCENT
            FUNC -> Color.argb(46, 255, 255, 255)
            else -> Color.argb(84, 255, 255, 255)
        }
        val shape = GradientDrawable().apply {
            setColor(fill)
            cornerRadius = dp(8).toFloat()
            setStroke(dp(1), Color.argb(28, 255, 255, 255))
        }
        val mask = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = dp(8).toFloat()
        }
        t.background = RippleDrawable(ColorStateList.valueOf(Color.argb(70, 255, 255, 255)), shape, mask)
        t.gravity = Gravity.CENTER
        t.isClickable = true
        t.layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            .apply { setMargins(dp(3), dp(3), dp(3), dp(3)) }
        return t
    }

    private fun textKey(label: String, kind: Int, onClick: () -> Unit): TextView {
        val t = keyBase(kind)
        t.text = label
        t.textSize = 22f
        t.setTextColor(if (kind == EQUALS) Color.parseColor("#0B1A24") else W11.TEXT)
        t.setOnClickListener { onClick() }
        return t
    }

    private fun iconKey(res: Int, kind: Int, onClick: () -> Unit, onLong: (() -> Unit)? = null): TextView {
        val t = keyBase(kind)
        t.iconOnly(res, 22, if (kind == EQUALS) Color.parseColor("#0B1A24") else W11.TEXT)
        t.setOnClickListener { onClick() }
        if (onLong != null) t.setOnLongClickListener { onLong(); true }
        return t
    }

    // =====================================================================
    // KEY ACTIONS
    // =====================================================================

    private fun isOp(c: Char) = c == '+' || c == '-' || c == '*' || c == '/'

    /** The number (digits and dot) at the end of the expression, or "". */
    private fun currentNumber(): String {
        var i = expr.length
        while (i > 0 && (expr[i - 1].isDigit() || expr[i - 1] == '.')) i--
        return expr.substring(i)
    }

    private fun resetIfNeeded() {
        if (errorMsg != null || justEvaluated) {
            expr.clear(); errorMsg = null; justEvaluated = false
            previewView.text = ""
        }
    }

    private fun digit(c: Char) {
        resetIfNeeded()
        if (expr.isNotEmpty() && expr.last() == '%') return
        if (expr.length >= MAX_LEN) return
        if (currentNumber() == "0") expr.setLength(expr.length - 1)
        expr.append(c)
        refresh()
    }

    private fun dot() {
        resetIfNeeded()
        if (expr.isNotEmpty() && expr.last() == '%') return
        if (expr.length >= MAX_LEN) return
        val cur = currentNumber()
        if (cur.contains('.')) return
        if (cur.isEmpty()) expr.append('0')
        expr.append('.')
        refresh()
    }

    private fun op(c: Char) {
        if (errorMsg != null) { expr.clear(); errorMsg = null }
        justEvaluated = false
        if (expr.isEmpty()) {
            if (c == '-') expr.append('-') else expr.append('0').append(c)
        } else {
            val last = expr.last()
            when {
                isOp(last) -> {
                    if (expr.length == 1) return // lone "-" at the start
                    expr.setLength(expr.length - 1); expr.append(c)
                }
                last == '.' -> { expr.setLength(expr.length - 1); expr.append(c) }
                else -> { if (expr.length >= MAX_LEN) return; expr.append(c) }
            }
        }
        refresh()
    }

    private fun percent() {
        if (errorMsg != null || expr.isEmpty()) return
        justEvaluated = false
        if (expr.last().isDigit() && expr.length < MAX_LEN) { expr.append('%'); refresh() }
    }

    private fun negate() {
        if (errorMsg != null) return
        if (expr.isEmpty()) { expr.append('-'); refresh(); return }
        if (!expr.last().isDigit() && expr.last() != '.') return
        justEvaluated = false
        var start = expr.length
        while (start > 0 && (expr[start - 1].isDigit() || expr[start - 1] == '.')) start--
        val unaryMinus = start > 0 && expr[start - 1] == '-' &&
            (start - 1 == 0 || isOp(expr[start - 2]))
        if (unaryMinus) expr.deleteCharAt(start - 1) else expr.insert(start, '-')
        refresh()
    }

    private fun back() {
        if (errorMsg != null) { clearAll(); return }
        if (justEvaluated) { justEvaluated = false; previewView.text = "" }
        if (expr.isNotEmpty()) expr.setLength(expr.length - 1)
        refresh()
    }

    private fun clearAll() {
        expr.clear(); errorMsg = null; justEvaluated = false
        previewView.text = ""
        refresh()
    }

    private fun equalsPressed() {
        if (errorMsg != null || expr.isEmpty() || justEvaluated) return
        // drop a dangling operator / dot
        while (expr.isNotEmpty() && (isOp(expr.last()) || expr.last() == '.')) expr.setLength(expr.length - 1)
        if (expr.isEmpty()) { refresh(); return }
        val prev = expr.toString()
        try {
            val text = format(Calc(prev).parse())
            previewView.text = pretty(prev) + " ="
            expr.clear(); expr.append(text)
            justEvaluated = true
        } catch (e: ArithmeticException) {
            errorMsg = e.message ?: "Cannot divide by zero"
        } catch (e: Throwable) {
            errorMsg = "Invalid input"
        }
        refresh(skipPreview = true)
    }

    // =====================================================================
    // DISPLAY
    // =====================================================================

    private fun pretty(s: String): String =
        s.replace('*', '\u00D7').replace('/', '\u00F7').replace('-', '\u2212')

    private fun refresh(skipPreview: Boolean = false) {
        exprView.text = errorMsg ?: if (expr.isEmpty()) "0" else pretty(expr.toString())
        if (skipPreview) return
        // live preview of the running result
        var p = expr.toString()
        while (p.isNotEmpty() && (isOp(p.last()) || p.last() == '.')) p = p.dropLast(1)
        val hasOp = p.length > 1 && p.drop(1).any { isOp(it) || it == '%' }
        previewView.text = if (!justEvaluated && errorMsg == null && hasOp) {
            try { "= " + format(Calc(p).parse()) } catch (e: Throwable) { "" }
        } else if (justEvaluated) previewView.text else ""
    }

    private fun format(v: Double): String {
        if (v.isNaN() || v.isInfinite() || Math.abs(v) >= 1e15) throw ArithmeticException("Result too large")
        if (Math.abs(v) < 1e-15) return "0"
        val bd = BigDecimal(v).round(MathContext(12)).stripTrailingZeros()
        val s = bd.toPlainString()
        return if (s == "-0") "0" else s
    }

    // =====================================================================
    // HARDWARE KEYBOARD
    // =====================================================================

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_NUMPAD_ENTER -> { equalsPressed(); return true }
            KeyEvent.KEYCODE_DEL -> { back(); return true }
            KeyEvent.KEYCODE_FORWARD_DEL, KeyEvent.KEYCODE_ESCAPE -> { clearAll(); return true }
        }
        val ch = event.unicodeChar
        if (ch != 0) {
            when (val c = ch.toChar()) {
                in '0'..'9' -> { digit(c); return true }
                '.', ',' -> { dot(); return true }
                '+', '-', '*', '/' -> { op(c); return true }
                '%' -> { percent(); return true }
                '=' -> { equalsPressed(); return true }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    // =====================================================================
    // EXPRESSION PARSER:  expr = term (('+'|'-') term)*,  term = factor (('*'|'/') factor)*,
    // factor = ('-'|'+') factor | number '%'*      ("200+10%" = 220, like a phone calculator)
    // =====================================================================

    private class Calc(private val s: String) {
        private var i = 0
        private var termIsPurePercent = false

        fun parse(): Double {
            val v = expr()
            if (i != s.length) throw IllegalArgumentException("bad expression")
            return v
        }

        private fun expr(): Double {
            var v = term()
            while (i < s.length && (s[i] == '+' || s[i] == '-')) {
                val o = s[i++]
                var t = term()
                if (termIsPurePercent) t *= v // "200 + 10%" -> 200 + 20
                v = if (o == '+') v + t else v - t
            }
            return v
        }

        private fun term(): Double {
            val startPercentCount = percentCount
            var v = factor()
            var pure = percentCount > startPercentCount
            while (i < s.length && (s[i] == '*' || s[i] == '/')) {
                pure = false
                val o = s[i++]
                val f = factor()
                if (o == '*') v *= f
                else {
                    if (f == 0.0) throw ArithmeticException("Cannot divide by zero")
                    v /= f
                }
            }
            termIsPurePercent = pure
            return v
        }

        private var percentCount = 0

        private fun factor(): Double {
            if (i < s.length && s[i] == '-') { i++; return -factor() }
            if (i < s.length && s[i] == '+') { i++; return factor() }
            val st = i
            while (i < s.length && (s[i].isDigit() || s[i] == '.')) i++
            if (st == i) throw IllegalArgumentException("number expected")
            var v = s.substring(st, i).toDouble()
            while (i < s.length && s[i] == '%') { i++; v /= 100.0; percentCount++ }
            return v
        }
    }
}
