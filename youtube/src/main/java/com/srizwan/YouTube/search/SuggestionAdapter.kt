package com.srizwan.YouTube.search

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.YouTube.R
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText

/**
 * The suggestion list under the search field. A row is either a past search (clock icon, with a cross that
 * removes it from the history) or a suggestion from YouTube (magnifier icon). Every row has an arrow that puts
 * its text into the field without searching (to edit it); a tap on the row itself searches.
 * When the field is empty and there is history, a last row with a bin icon clears the whole search history.
 */
class SuggestionAdapter(
    private val onPick: (String) -> Unit,
    private val onFill: (String) -> Unit,
    private val onRemove: (String) -> Unit,
    private val onClearAll: () -> Unit,
    /** false hides the arrow (the history screen has no search field to copy the text into) */
    private val showFill: Boolean = true
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    data class Row(val text: String, val fromHistory: Boolean)

    private val rows = ArrayList<Row>()
    private var clearAll = false

    class RowVH(
        val row: LinearLayout,
        val lead: ImageView,
        val text: VectorText,
        val remove: ImageView,
        val fill: ImageView
    ) : RecyclerView.ViewHolder(row)

    class ClearVH(val row: LinearLayout, val icon: ImageView) : RecyclerView.ViewHolder(row)

    fun set(list: List<Row>, showClearAll: Boolean) {
        rows.clear()
        rows.addAll(list)
        clearAll = showClearAll
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = rows.size + if (clearAll) 1 else 0

    override fun getItemViewType(position: Int): Int = if (position >= rows.size) 1 else 0

    private fun pressed(): StateListDrawable = StateListDrawable().apply {
        addState(intArrayOf(android.R.attr.state_pressed), ColorDrawable(0x26FFFFFF))
        addState(intArrayOf(), ColorDrawable(Color.TRANSPARENT))
    }

    private fun icon(parent: ViewGroup, res: Int, sizeDp: Float, tint: Int): ImageView =
        ImageView(parent.context).apply {
            setImageDrawable(VectorLabelDrawable(parent.context, null, res, iconSizeDp = sizeDp, tint = tint))
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val d = parent.resources.displayMetrics.density
        fun dp(v: Int) = (v * d).toInt()
        val dim = 0xFFAAAAAA.toInt()

        if (viewType == 1) {
            val ic = icon(parent, R.drawable.ic_delete, 22f, dim).apply {
                contentDescription = parent.context.getString(R.string.yt_cd_clear_history)
            }
            val row = LinearLayout(parent.context).apply {
                gravity = Gravity.CENTER
                background = pressed()
                isClickable = true
                addView(ic, LinearLayout.LayoutParams(dp(22), dp(22)))
                layoutParams = RecyclerView.LayoutParams(-1, dp(46))
                setOnClickListener { onClearAll() }
            }
            return ClearVH(row, ic)
        }

        val lead = icon(parent, R.drawable.ic_history, 22f, dim)
        val text = VectorText(parent.context)
        val remove = icon(parent, R.drawable.ic_close, 20f, dim).apply {
            contentDescription = parent.context.getString(R.string.yt_cd_remove_history)
            setPadding(dp(8), dp(8), dp(8), dp(8))
        }
        val fill = icon(parent, R.drawable.ic_fill_query, 22f, dim).apply {
            contentDescription = parent.context.getString(R.string.yt_cd_fill_query)
            setPadding(dp(7), dp(7), dp(7), dp(7))
        }
        val row = LinearLayout(parent.context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = pressed()
            isClickable = true
            setPadding(dp(16), 0, dp(6), 0)
            addView(lead, LinearLayout.LayoutParams(dp(22), dp(22)))
            addView(text, LinearLayout.LayoutParams(0, -2, 1f).apply { marginStart = dp(14); marginEnd = dp(6) })
            addView(remove, LinearLayout.LayoutParams(dp(38), dp(38)))
            addView(fill, LinearLayout.LayoutParams(dp(38), dp(38)))
            layoutParams = RecyclerView.LayoutParams(-1, dp(50))
        }
        return RowVH(row, lead, text, remove, fill)
    }

    override fun onBindViewHolder(h: RecyclerView.ViewHolder, position: Int) {
        if (h !is RowVH) return
        val r = rows[position]
        val ctx = h.row.context
        h.lead.setImageDrawable(
            VectorLabelDrawable(
                ctx, null, if (r.fromHistory) R.drawable.ic_history else R.drawable.ic_search,
                iconSizeDp = 22f, tint = 0xFFAAAAAA.toInt()
            )
        )
        h.text.set(r.text, 15f, Color.WHITE, maxLines = 1)
        h.remove.visibility = if (r.fromHistory) View.VISIBLE else View.GONE
        h.remove.setOnClickListener { onRemove(r.text) }
        h.fill.visibility = if (showFill) View.VISIBLE else View.GONE
        h.fill.setOnClickListener { onFill(r.text) }
        h.row.setOnClickListener { onPick(r.text) }
    }
}
