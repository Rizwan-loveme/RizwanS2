package com.srizwan.chooser.picker

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.text.format.DateFormat
import android.text.format.Formatter
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.chooser.R
import com.srizwan.chooser.ui.AppGrid
import com.srizwan.chooser.ui.GlassDrawable
import com.srizwan.chooser.ui.GlassUi
import com.srizwan.chooser.ui.VectorText
import java.util.Date

/**
 * The rows of the picker, as a list (one line per file: picture, name, size and date) or as a grid of tiles (picture over name).
 * Everything is drawn with the Chooser kit: vector icons, glyph-outline text, no TextView. The activity owns the data; this adapter only shows
 * [items], marks [selected] paths and reports taps.
 */
class PickerAdapter(
    private val activity: Activity,
    private val thumbs: PickerThumbs,
    private val onTap: (PickerEntry) -> Unit,
    private val onHold: (PickerEntry) -> Unit
) : RecyclerView.Adapter<PickerAdapter.Holder>() {

    var items: List<PickerEntry> = emptyList()
        private set
    var grid: Boolean = false
        private set

    /** Paths that are ticked (many-file mode). */
    var selected: Set<String> = emptySet()

    private val accent = ContextCompat.getColor(activity, R.color.ch_accent)
    private val dim = ContextCompat.getColor(activity, R.color.ch_text_dim)
    private val dateFormat = DateFormat.getMediumDateFormat(activity)

    fun submit(list: List<PickerEntry>) {
        items = list
        notifyDataSetChanged()
    }

    fun setGrid(value: Boolean) {
        if (grid == value) return
        grid = value
        notifyDataSetChanged()
    }

    /** Redraws one row after its tick changed. */
    fun changed(path: String) {
        val i = items.indexOfFirst { it.path == path }
        if (i >= 0) notifyItemChanged(i)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = if (grid) 1 else 0

    class Holder(
        itemView: View,
        val thumbBox: FrameLayout,
        val icon: ImageView,
        val name: VectorText,
        val meta: VectorText?,
        val check: ImageView
    ) : RecyclerView.ViewHolder(itemView) {
        var entry: PickerEntry? = null
    }

    /** A frame that is as tall as it is wide (the picture of a tile). */
    private class SquareFrame(context: android.content.Context) : FrameLayout(context) {
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) = super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    private fun dp(v: Float) = GlassUi.dp(activity, v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val tile = viewType == 1
        val icon = ImageView(activity).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val radius = dp(if (tile) 16f else 12f).toFloat()
        val thumbBox = FrameLayout(activity).apply {
            background = GlassDrawable(activity, if (tile) 16f else 12f)
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, radius)
                }
            }
            addView(icon, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        }
        val check = ImageView(activity).apply {
            setImageResource(R.drawable.ch_ic_check)
            contentDescription = activity.getString(R.string.ch_cd_selected)
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(accent)
            }
            val p = dp(4f)
            setPadding(p, p, p, p)
            imageTintList = ColorStateList.valueOf(Color.BLACK)
            visibility = View.GONE
        }
        val name = VectorText(activity).apply { importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO }

        val root: LinearLayout
        var meta: VectorText? = null
        if (tile) {
            val frame = SquareFrame(activity).apply {
                addView(thumbBox, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                addView(check, FrameLayout.LayoutParams(dp(22f), dp(22f), Gravity.TOP or Gravity.END).apply {
                    topMargin = dp(6f)
                    marginEnd = dp(6f)
                })
            }
            root = LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_HORIZONTAL
                setPadding(dp(6f), dp(6f), dp(6f), dp(6f))
                addView(frame, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(6f)
                })
            }
        } else {
            val metaView = VectorText(activity).apply { importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO }
            meta = metaView
            val column = LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                addView(metaView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(2f)
                })
            }
            root = LinearLayout(activity).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                minimumHeight = dp(64f)
                setPadding(dp(10f), dp(6f), dp(12f), dp(6f))
                addView(thumbBox, LinearLayout.LayoutParams(dp(48f), dp(48f)))
                addView(column, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                    marginStart = dp(12f)
                    marginEnd = dp(8f)
                })
                addView(check, LinearLayout.LayoutParams(dp(24f), dp(24f)))
            }
        }
        root.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        root.isClickable = true
        root.isFocusable = true
        val holder = Holder(root, thumbBox, icon, name, meta, check)
        root.setOnClickListener { holder.entry?.let(onTap) }
        root.setOnLongClickListener {
            val e = holder.entry ?: return@setOnLongClickListener false
            it.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
            onHold(e)
            true
        }
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val e = items[position]
        holder.entry = e
        holder.itemView.contentDescription = e.name
        if (grid) {
            holder.name.set(e.name, 12f, Color.WHITE, maxLines = 2, center = true)
        } else {
            holder.name.set(e.name, 15f, Color.WHITE, bold = e.kind != PickerEntry.Kind.FILE)
            holder.meta?.set(metaOf(e), 12f, dim)
        }
        bindIcon(holder, e)
        val isSelected = e.kind == PickerEntry.Kind.FILE && selected.contains(e.path)
        holder.check.visibility = if (isSelected) View.VISIBLE else View.GONE
        holder.itemView.background = if (isSelected) AppGrid.selectedBackground(activity) else AppGrid.ripple(activity)
    }

    private fun metaOf(e: PickerEntry): String {
        e.sub?.let { return it }
        val date = if (e.modified > 0) dateFormat.format(Date(e.modified)) else ""
        return when (e.kind) {
            PickerEntry.Kind.ROOT -> if (e.size >= 0) activity.getString(R.string.ch_picker_free, Formatter.formatShortFileSize(activity, e.size)) else ""
            PickerEntry.Kind.FOLDER -> date
            PickerEntry.Kind.FILE -> {
                val size = Formatter.formatShortFileSize(activity, e.size)
                if (date.isEmpty()) size else "$size  \u00B7  $date"
            }
        }
    }

    private fun iconFor(e: PickerEntry): Int = when {
        e.iconOverride != 0 -> e.iconOverride
        e.kind == PickerEntry.Kind.FOLDER -> R.drawable.ch_ic_folder
        e.mime.startsWith("image/") -> R.drawable.ch_ic_image
        e.mime.startsWith("video/") -> R.drawable.ch_ic_video
        e.mime.startsWith("audio/") -> R.drawable.ch_ic_audio
        else -> R.drawable.ch_ic_file
    }

    private fun bindIcon(h: Holder, e: PickerEntry) {
        val key = e.path + "|" + e.modified + "|" + (if (grid) "g" else "l")
        h.icon.tag = key
        // the file's own icon first (also what stays when no picture can be made)
        val pad = (if (grid) dp(34f) else dp(12f))
        h.icon.setPadding(pad, pad, pad, pad)
        h.icon.scaleType = ImageView.ScaleType.FIT_CENTER
        h.icon.imageTintList = ColorStateList.valueOf(if (e.isDir) accent else 0xD9FFFFFF.toInt())
        h.icon.setImageResource(iconFor(e))
        if (e.kind != PickerEntry.Kind.FILE || !PickerThumbs.isThumbnailType(e.mime)) return
        val sizePx = dp(if (grid) 120f else 56f)
        val video = e.mime.startsWith("video/")
        thumbs.load(e.file, key, sizePx, h.icon, video) { bmp -> showThumb(h.icon, bmp) }
    }

    private fun showThumb(icon: ImageView, bmp: Bitmap) {
        icon.setPadding(0, 0, 0, 0)
        icon.imageTintList = null
        icon.scaleType = ImageView.ScaleType.CENTER_CROP
        icon.setImageBitmap(bmp)
    }
}
