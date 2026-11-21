package com.srizwan.video.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.video.R
import com.srizwan.video.player.VideoEngine
import com.srizwan.video.player.VideoPlayerActivity
import com.srizwan.video.player.VideoPrefs
import com.srizwan.video.ui.GlassDrawable
import com.srizwan.video.ui.VectorLabelDrawable
import com.srizwan.video.ui.VectorText
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.Executors

/**
 * The built-in Video app (Start menu and Home screen icon): a glass list of the videos on the device, newest
 * first. Each row shows a frame of the video, its length, its resolution ("4K", "1080p" ...), a clock badge when
 * there is a saved position to continue from, the file name and size / date. A tap opens [VideoPlayerActivity].
 * Like the rest of the app it has no text views: names and numbers are glyph outlines ([VectorText]).
 */
class VideoHomeActivity : AppCompatActivity() {

    /** One video of the device. */
    private class Item(
        val path: String,
        val name: String,
        val durationMs: Long,
        val size: Long,
        val dateSec: Long,
        val width: Int,
        val height: Int
    )

    private val io = Executors.newSingleThreadExecutor()
    private val main = Handler(Looper.getMainLooper())
    private val adapter = Adapter()
    private lateinit var list: RecyclerView
    private lateinit var stateBox: ImageView
    private var loading = false
    private var items: List<Item> = emptyList()

    private val permission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { load() }

    private fun dp(v: Float) = (v * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ContextCompat.getColor(context, R.color.vp_bg))
        }

        // top bar: back, title, refresh
        val bar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(12f), dp(10f), dp(12f), dp(6f))
        }
        val back = roundButton(R.drawable.vp_ic_back, R.string.vp_cd_back) { finish() }
        val title = VectorText(this).apply {
            set("Video", 22f, Color.WHITE, bold = true)
            setPadding(dp(14f), 0, 0, 0)
        }
        val refresh = roundButton(R.drawable.vp_ic_retry, R.string.vp_cd_refresh) { load() }
        bar.addView(back, LinearLayout.LayoutParams(dp(44f), dp(44f)))
        bar.addView(title, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        bar.addView(refresh, LinearLayout.LayoutParams(dp(44f), dp(44f)))
        root.addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        // list + the empty / permission state on top of it
        val frame = FrameLayout(this)
        list = RecyclerView(this).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@VideoHomeActivity.adapter
            clipToPadding = false
            setPadding(dp(12f), dp(4f), dp(12f), dp(16f))
            setHasFixedSize(true)
        }
        stateBox = ImageView(this).apply {
            visibility = View.GONE
            setPadding(dp(24f), dp(24f), dp(24f), dp(24f))
        }
        frame.addView(list, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        frame.addView(
            stateBox,
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER)
        )
        root.addView(frame, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))
        setContentView(root)
    }

    override fun onResume() {
        super.onResume()
        // also refreshes the "continue" badges after coming back from the player
        load()
    }

    override fun onDestroy() {
        io.shutdown()
        super.onDestroy()
    }

    /** A glass round icon button for the top bar. */
    private fun roundButton(icon: Int, cd: Int, onClick: () -> Unit): ImageView = ImageView(this).apply {
        setImageDrawable(VectorLabelDrawable(context, null, icon, iconSizeDp = 22f))
        scaleType = ImageView.ScaleType.CENTER
        background = GlassDrawable(context, 22f)
        contentDescription = context.getString(cd)
        isClickable = true
        isFocusable = true
        setOnClickListener { onClick() }
    }

    // ---------------------------------------------------------------------------------------------
    // Data
    // ---------------------------------------------------------------------------------------------

    private fun hasPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= 30 && Environment.isExternalStorageManager()) return true
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED
    }

    private fun load() {
        if (!hasPermission()) {
            showState(R.drawable.vp_ic_lock, R.string.vp_cd_lock) { permission.launch(Manifest.permission.READ_EXTERNAL_STORAGE) }
            adapter.submit(emptyList())
            return
        }
        if (loading) return
        loading = true
        val app = applicationContext
        io.execute {
            val result = try { query(app) } catch (e: Throwable) { emptyList() }
            main.post {
                loading = false
                if (isDestroyed) return@post
                items = result
                adapter.submit(result)
                if (result.isEmpty()) showState(R.drawable.vp_ic_play, R.string.vp_cd_empty) { load() } else stateBox.visibility = View.GONE
            }
        }
    }

    /** All videos of the device from MediaStore, newest first. */
    private fun query(context: Context): List<Item> {
        val out = ArrayList<Item>()
        val cols = arrayOf(
            MediaStore.Video.Media.DATA, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.SIZE, MediaStore.Video.Media.DATE_ADDED,
            MediaStore.Video.Media.WIDTH, MediaStore.Video.Media.HEIGHT
        )
        context.contentResolver.query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI, cols, null, null,
            MediaStore.Video.Media.DATE_ADDED + " DESC"
        )?.use { c ->
            while (c.moveToNext()) {
                val path = c.getString(0) ?: continue
                out.add(
                    Item(
                        path, c.getString(1) ?: path.substringAfterLast('/'), c.getLong(2),
                        c.getLong(3), c.getLong(4), c.getInt(5), c.getInt(6)
                    )
                )
            }
        }
        return out
    }

    /** Empty / permission state: a big dim icon in the middle; tapping it does the action. */
    private fun showState(icon: Int, cd: Int, action: () -> Unit) {
        stateBox.setImageDrawable(VectorLabelDrawable(this, null, icon, iconSizeDp = 56f, tint = 0x80FFFFFF.toInt()))
        stateBox.contentDescription = getString(cd)
        stateBox.isClickable = true
        stateBox.setOnClickListener { action() }
        stateBox.visibility = View.VISIBLE
    }

    // ---------------------------------------------------------------------------------------------
    // List
    // ---------------------------------------------------------------------------------------------

    private class Holder(
        val root: LinearLayout,
        val thumb: ImageView,
        val duration: ImageView,
        val resolution: ImageView,
        val resume: ImageView,
        val name: VectorText,
        val meta: VectorText
    ) : RecyclerView.ViewHolder(root)

    private inner class Adapter : RecyclerView.Adapter<Holder>() {
        private var data: List<Item> = emptyList()

        fun submit(newItems: List<Item>) {
            data = newItems
            notifyDataSetChanged()
        }

        override fun getItemCount() = data.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val ctx = parent.context
            val row = LinearLayout(ctx).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(8f), dp(8f), dp(12f), dp(8f))
                background = GlassDrawable(ctx, 16f)
                isClickable = true
                isFocusable = true
                layoutParams = RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { setMargins(0, dp(5f), 0, dp(5f)) }
            }
            val thumbFrame = FrameLayout(ctx).apply {
                setBackgroundColor(0xFF1B1F24.toInt())
                clipToOutline = true
                outlineProvider = object : ViewOutlineProvider() {
                    override fun getOutline(view: View, outline: Outline) {
                        outline.setRoundRect(0, 0, view.width, view.height, dp(12f).toFloat())
                    }
                }
            }
            val thumb = ImageView(ctx).apply { scaleType = ImageView.ScaleType.CENTER_CROP }
            val duration = badge(ctx)
            val resolution = badge(ctx)
            val resume = badge(ctx).apply {
                setImageDrawable(VectorLabelDrawable(ctx, null, R.drawable.vp_ic_resume, iconSizeDp = 14f))
                visibility = View.GONE
            }
            thumbFrame.addView(thumb, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            thumbFrame.addView(duration, badgeParams(Gravity.BOTTOM or Gravity.END))
            thumbFrame.addView(resolution, badgeParams(Gravity.BOTTOM or Gravity.START))
            thumbFrame.addView(resume, badgeParams(Gravity.TOP or Gravity.START))
            row.addView(thumbFrame, LinearLayout.LayoutParams(dp(136f), dp(77f)))

            val col = LinearLayout(ctx).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(12f), 0, 0, 0)
            }
            val name = VectorText(ctx)
            val meta = VectorText(ctx).apply { setPadding(0, dp(4f), 0, 0) }
            col.addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            col.addView(meta, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            row.addView(col, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            return Holder(row, thumb, duration, resolution, resume, name, meta)
        }

        override fun onBindViewHolder(h: Holder, position: Int) {
            val it = data[position]
            val ctx = h.root.context
            VideoThumbLoader.load(h.thumb, it.path)
            h.name.set(it.name, 14f, Color.WHITE, bold = true, maxLines = 2)
            h.meta.set(metaOf(it), 12f, 0xB3FFFFFF.toInt(), maxLines = 1)
            h.duration.setImageDrawable(VectorLabelDrawable(ctx, formatDuration(it.durationMs), 0, textSizeDp = 11f))
            if (it.width > 0 && it.height > 0) {
                h.resolution.visibility = View.VISIBLE
                h.resolution.setImageDrawable(
                    VectorLabelDrawable(ctx, VideoEngine.resolutionLabel(it.width, it.height), 0, textSizeDp = 11f, tint = 0xFF4CC2FF.toInt())
                )
            } else {
                h.resolution.visibility = View.GONE
            }
            h.resume.visibility =
                if (VideoPrefs.hasResume(ctx, VideoEngine.keyOf(it.path))) View.VISIBLE else View.GONE
            h.root.contentDescription = it.name
            h.root.setOnClickListener { _ -> VideoPlayerActivity.start(ctx, it.path, it.name, data.map { v -> v.path }) }
        }

        private fun badge(ctx: Context) = ImageView(ctx).apply {
            background = GlassDrawable(ctx, 8f, strong = true)
            setPadding(dp(6f), dp(3f), dp(6f), dp(3f))
        }

        private fun badgeParams(gravity: Int) = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, gravity
        ).apply { setMargins(dp(5f), dp(5f), dp(5f), dp(5f)) }
    }

    // ---------------------------------------------------------------------------------------------
    // Formatting
    // ---------------------------------------------------------------------------------------------

    private fun metaOf(it: Item): String {
        val date = SimpleDateFormat("d MMM yyyy", Locale.US).format(Date(it.dateSec * 1000L))
        return "${formatSize(it.size)} | $date"
    }

    private fun formatSize(bytes: Long): String {
        val kb = 1024.0
        return when {
            bytes >= kb * kb * kb -> String.format(Locale.US, "%.1f GB", bytes / (kb * kb * kb))
            bytes >= kb * kb -> String.format(Locale.US, "%.0f MB", bytes / (kb * kb))
            else -> String.format(Locale.US, "%.0f KB", bytes / kb)
        }
    }

    /** 754000 -> "12:34", 3723000 -> "1:02:03" */
    private fun formatDuration(ms: Long): String {
        val total = ms / 1000
        val h = total / 3600
        val m = (total % 3600) / 60
        val s = total % 60
        return if (h > 0) String.format(Locale.US, "%d:%02d:%02d", h, m, s)
        else String.format(Locale.US, "%d:%02d", m, s)
    }
}
