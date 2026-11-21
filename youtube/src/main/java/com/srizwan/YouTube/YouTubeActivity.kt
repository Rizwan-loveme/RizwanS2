package com.srizwan.YouTube

import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.srizwan.YouTube.player.PlayerActivity
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.VectorLabelDrawable

/**
 * Entry point of the built-in YouTube app. Opened by :app (Start menu, section = "youtube").
 * Until the feed / search screens exist it is a "paste a video link" screen that opens [PlayerActivity].
 * No text: the logo, the link icon, the paste icon and the play icon are vectors (the link you type is the only
 * text, and it is the user's own).
 */
class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()

        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        val logo = ImageView(this).apply {
            setImageResource(R.drawable.ic_yt_logo)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        val input = EditText(this).apply {
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            textSize = 15f
            inputType = InputType.TYPE_TEXT_VARIATION_URI
            imeOptions = EditorInfo.IME_ACTION_GO
            setSingleLine(true)
            setPadding(px(8), px(12), px(8), px(12))
        }
        fun play(link: String) {
            val url = link.trim()
            if (url.isNotEmpty()) PlayerActivity.start(this, url)
        }
        input.setOnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_GO) { play(input.text.toString()); true } else false
        }

        val linkIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_link, iconSizeDp = 22f))
        }
        val paste = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_paste, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_paste)
            setPadding(px(10), px(10), px(10), px(10))
            setOnClickListener {
                val clip = (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip
                val text = clip?.takeIf { it.itemCount > 0 }?.getItemAt(0)?.coerceToText(this@YouTubeActivity)?.toString()
                if (!text.isNullOrBlank()) {
                    input.setText(text)
                    play(text)
                }
            }
        }
        val field = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@YouTubeActivity, 28f, strong = true)
            setPadding(px(16), px(4), px(6), px(4))
            addView(linkIcon)
            addView(input, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(paste)
        }

        val go = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_play, iconSizeDp = 30f))
            contentDescription = getString(R.string.yt_cd_go)
            setPadding(px(14), px(14), px(14), px(14))
            setOnClickListener { play(input.text.toString()) }
        }
        // a round red button
        go.background = android.graphics.drawable.GradientDrawable().apply {
            shape = android.graphics.drawable.GradientDrawable.OVAL
            setColor(red)
        }

        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(bg)
            setPadding(px(24), px(24), px(24), px(24))
            addView(logo, LinearLayout.LayoutParams(px(88), px(88)))
            addView(field, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = px(32) })
            addView(go, LinearLayout.LayoutParams(px(64), px(64)).apply { topMargin = px(24) })
        })
    }
}
