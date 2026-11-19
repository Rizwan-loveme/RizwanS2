package com.srizwan.win11

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/** On-device log viewer: Refresh / Copy / Share / Clear. */
class DebugLogActivity : AppCompatActivity() {

    private lateinit var logText: TextView
    private lateinit var scroll: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try { supportActionBar?.hide() } catch (_: Throwable) {}
        AppLog.i("DebugLog", "opened")

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(24, 24, 24))
        }

        val heading = TextView(this).apply {
            text = "Debug log"
            setTextColor(Color.WHITE)
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dp(14), dp(12), dp(14), dp(2))
        }
        val path = TextView(this).apply {
            text = AppLog.logPath()
            setTextColor(Color.GRAY)
            textSize = 10f
            setPadding(dp(14), 0, dp(14), dp(6))
        }
        root.addView(heading)
        root.addView(path)

        val bar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(6), 0, dp(6), dp(6))
        }
        fun btn(label: String, action: () -> Unit) {
            bar.addView(Button(this).apply {
                text = label
                textSize = 12f
                setOnClickListener { try { action() } catch (t: Throwable) { AppLog.e("DebugLog", "button $label failed", t) } }
            }, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        }
        btn("Refresh") { refresh() }
        btn("Copy") { copy() }
        btn("Share") { share() }
        btn("Clear") { AppLog.clear(); refresh() }
        btn("Close") { finish() }
        root.addView(bar)

        scroll = ScrollView(this)
        logText = TextView(this).apply {
            setTextColor(Color.rgb(200, 255, 200))
            typeface = Typeface.MONOSPACE
            textSize = 10.5f
            setTextIsSelectable(true)
            setPadding(dp(10), dp(6), dp(10), dp(10))
        }
        scroll.addView(logText)
        root.addView(scroll, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))

        setContentView(root)

        // Edge-to-edge safe (Android 15+ draws under the system bars).
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            WindowInsetsCompat.CONSUMED
        }
        ViewCompat.requestApplyInsets(root)
        refresh()
    }

    private fun fullText(): String {
        val sb = StringBuilder()
        sb.append(AppLog.deviceInfo()).append("\n")
        sb.append("Log file: ").append(AppLog.logPath()).append("\n")
        sb.append("------------------------------------------------\n")
        val log = AppLog.readAll()
        sb.append(if (log.isBlank()) "(log is empty)" else log)
        return sb.toString()
    }

    private fun refresh() {
        logText.text = fullText()
        scroll.post { scroll.fullScroll(android.view.View.FOCUS_DOWN) }
    }

    private fun copy() {
        val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText("Win11 log", fullText().takeLast(200_000)))
        Toast.makeText(this, "Log copied", Toast.LENGTH_SHORT).show()
    }

    private fun share() {
        val send = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Win11 debug log")
            putExtra(Intent.EXTRA_TEXT, fullText().takeLast(100_000))
        }
        startActivity(Intent.createChooser(send, "Share log"))
    }

    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()
}
