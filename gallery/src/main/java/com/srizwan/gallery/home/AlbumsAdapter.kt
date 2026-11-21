package com.srizwan.gallery.home

import android.graphics.Outline
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryAlbum
import com.srizwan.gallery.loader.ImageLoader
import com.srizwan.gallery.ui.GlassUi
import com.srizwan.gallery.ui.VectorText
import kotlin.math.max

/**
 * The Albums tab: one card per folder with a rounded cover thumbnail (the newest picture), the folder name and the
 * number of pictures. [columns] and [viewWidthPx] decide the cover size that is asked for.
 */
internal class AlbumsAdapter(
    private val onOpen: (GalleryAlbum) -> Unit
) : RecyclerView.Adapter<AlbumsAdapter.AlbumHolder>() {

    private var albums: List<GalleryAlbum> = emptyList()

    var columns: Int = 2
    var viewWidthPx: Int = 0

    val isEmpty: Boolean get() = albums.isEmpty()

    fun submit(list: List<GalleryAlbum>) {
        albums = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = albums.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val ctx = parent.context
        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            val p = GlassUi.dp(ctx, 6f)
            setPadding(p, p, p, p)
            layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            isClickable = true
            isFocusable = true
        }
        val corner = GlassUi.dp(ctx, 16f).toFloat()
        val cover = SquareFrame(ctx).apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, corner)
                }
            }
            clipToOutline = true
        }
        val image = ImageView(ctx).apply { scaleType = ImageView.ScaleType.CENTER_CROP }
        cover.addView(image, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        card.addView(cover, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        val name = VectorText(ctx).apply { setPadding(GlassUi.dp(ctx, 4f), 0, GlassUi.dp(ctx, 4f), 0) }
        card.addView(
            name,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply { topMargin = GlassUi.dp(ctx, 8f) }
        )
        val count = VectorText(ctx).apply { setPadding(GlassUi.dp(ctx, 4f), 0, GlassUi.dp(ctx, 4f), 0) }
        card.addView(
            count,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply { topMargin = GlassUi.dp(ctx, 2f) }
        )
        val holder = AlbumHolder(card, image, name, count)
        card.setOnClickListener { holder.album?.let(onOpen) }
        return holder
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        val album = albums[position]
        holder.album = album
        val ctx = holder.itemView.context
        holder.image.contentDescription = album.name
        holder.name.set(album.name, 14f, 0xFFFFFFFF.toInt(), bold = true)
        holder.count.set(
            ctx.resources.getQuantityString(R.plurals.gl_n_photos, album.count, album.count),
            12f, 0xB3FFFFFF.toInt()
        )
        val width = if (viewWidthPx > 0) viewWidthPx else ctx.resources.displayMetrics.widthPixels
        ImageLoader.load(holder.image, album.cover, max(1, width / columns))
    }

    override fun onViewRecycled(holder: AlbumHolder) {
        holder.album = null
        ImageLoader.cancel(holder.image)
    }

    class AlbumHolder(
        card: View,
        val image: ImageView,
        val name: VectorText,
        val count: VectorText
    ) : RecyclerView.ViewHolder(card) {
        var album: GalleryAlbum? = null
    }
}
