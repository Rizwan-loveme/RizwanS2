package com.srizwan.YouTube

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.srizwan.YouTube.player.PlayerActivity

/**
 * Entry point of the built-in YouTube app. Opened by :app (Start menu, section = "youtube").
 * Until the feed / search screens exist it is a simple "paste a video link" screen that opens
 * [PlayerActivity]. A link on the clipboard-free path: type or paste, tap Play (or the keyboard's Go key).
 */
class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()

        val bg = ContextCompat.getColor(this, R.color.yt_bg)
        val surface = ContextCompat.getColor(this, R.color.yt_surface)
        val dim = ContextCompat.getColor(this, R.color.yt_text_dim)
        val red = ContextCompat.getColor(this, R.color.yt_red)

        val title = TextView(this).apply {
            text = "YouTube"
            setTextColor(Color.WHITE)
            textSize = 24f
            typeface = Typeface.DEFAULT_BOLD
        }
        val hint = TextView(this).apply {
            text = "Paste a YouTube video link to play it."
            setTextColor(dim)
            textSize = 14f
            setPadding(0, px(6), 0, px(16))
        }
        val input = EditText(this).apply {
            setHint("https://www.youtube.com/watch?v=...")
            setHintTextColor(dim)
            setTextColor(Color.WHITE)
            setBackgroundColor(surface)
            setPadding(px(14), px(12), px(14), px(12))
            inputType = InputType.TYPE_TEXT_VARIATION_URI
            imeOptions = EditorInfo.IME_ACTION_GO
            setSingleLine(true)
        }
        fun play() {
            val url = input.text.toString().trim()
            if (url.isNotEmpty()) PlayerActivity.start(this, url)
        }
        input.setOnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_GO) { play(); true } else false
        }
        val button = Button(this).apply {
            text = "Play"
            setTextColor(Color.WHITE)
            setBackgroundColor(red)
            setOnClickListener { play() }
        }

        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(bg)
            setPadding(px(20), px(20), px(20), px(20))
            addView(title)
            addView(hint)
            addView(input)
            addView(button, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = px(12) })
        })
    }
}
