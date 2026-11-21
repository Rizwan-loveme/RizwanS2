package com.srizwan.chooser.settings

import android.content.ComponentName
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.srizwan.chooser.R
import com.srizwan.chooser.data.ChooserKind
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.data.MimeTypes
import com.srizwan.chooser.ui.GlassBar
import com.srizwan.chooser.ui.GlassButtons
import com.srizwan.chooser.ui.GlassConfirm
import com.srizwan.chooser.ui.GlassDrawable
import com.srizwan.chooser.ui.GlassSwitch
import com.srizwan.chooser.ui.GlassTabs
import com.srizwan.chooser.ui.GlassToast
import com.srizwan.chooser.ui.GlassUi
import com.srizwan.chooser.ui.VectorLabelDrawable
import com.srizwan.chooser.ui.VectorText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * The settings of the Chooser (step 11), a glass screen like the file picker: a floating bar on top and cards that scroll under it.
 *
 *  - **Open with and Share**: the style of the app list (grid or list) and the apps per row (auto, 3 to 6; only for the grid).
 *  - **Recent apps**: the switch "Remember recent apps" (off hides the Recent row and the ordering by last choice), how many apps are
 *    remembered, and a button that clears them.
 *  - **Saved apps**: every app saved with "Always", with its file type and a remove button each, and "Clear all saved apps".
 *  - **File picker**: forget the last folder, sort order, hidden files and list / grid choice.
 *
 * Every change is saved at once ([ChooserPrefs]); the sheets read it the next time they are built (an open sheet reads it again when
 * it gets the focus back). Text is drawn as vector outlines like everywhere in the Chooser (no TextView); the screen keeps its
 * state through rotation (`configChanges` in the manifest) and the content is at most 640 dp wide on a tablet.
 */
class ChooserSettingsActivity : AppCompatActivity() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private lateinit var root: FrameLayout
    private lateinit var bar: GlassBar
    private lateinit var scroll: ScrollView
    private lateinit var columnsBlock: View
    private lateinit var recentBox: LinearLayout
    private lateinit var alwaysBox: LinearLayout
    private var navBottom = 0
    private var alwaysJob: Job? = null

    private fun dp(v: Float) = GlassUi.dp(this, v)
    private val dim: Int get() = ContextCompat.getColor(this, R.color.ch_text_dim)

    // ── lifecycle ────────────────────────────────────────────────────────

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        edgeToEdge()
        buildUi()
        // the lists are filled in onResume, which always follows
    }

    override fun onStart() {
        super.onStart()
        GlassToast.host = this
    }

    override fun onStop() {
        super.onStop()
        if (GlassToast.host === this) GlassToast.host = null
    }

    override fun onResume() {
        super.onResume()
        // the saved apps or the recent lists may have changed while another screen was on top
        if (::alwaysBox.isInitialized) {
            refreshRecent()
            refreshAlways()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    // ── window and views ─────────────────────────────────────────────────

    private fun edgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= 29) window.isNavigationBarContrastEnforced = false
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
    }

    private fun buildUi() {
        bar = GlassBar(this).apply {
            setTitle(getString(R.string.ch_set_title))
            setBackVisible(true) { finish() }
        }

        val column = MaxWidthColumn(this, dp(640f)).apply { orientation = LinearLayout.VERTICAL }
        fun add(card: View) {
            column.addView(card, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(12f)
            })
        }
        add(sheetsCard())
        add(recentCard())
        add(alwaysCard())
        add(pickerCard())

        val holder = FrameLayout(this).apply {
            addView(column, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL))
        }
        scroll = ScrollView(this).apply {
            clipToPadding = false
            isVerticalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            addView(holder, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
        root = FrameLayout(this).apply {
            addView(scroll, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            addView(bar, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))
        }
        bar.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ -> updatePadding() }
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            navBottom = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()).bottom
            updatePadding()
            insets
        }
        setContentView(root)
        updatePadding()
    }

    /** The cards scroll under the floating bar: padding = the height of the bar, so the first card can be reached. */
    private fun updatePadding() {
        if (!::scroll.isInitialized) return
        val top = (if (bar.bottom > 0) bar.bottom else dp(84f)) + dp(4f)
        val bottom = navBottom + dp(20f)
        if (scroll.paddingTop != top || scroll.paddingBottom != bottom) scroll.setPadding(dp(12f), top, dp(12f), bottom)
    }

    /** A column that is never wider than [maxPx]: on a tablet the cards stay readable (the holder around it centres it). */
    private class MaxWidthColumn(context: Context, private val maxPx: Int) : LinearLayout(context) {
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            val size = MeasureSpec.getSize(widthMeasureSpec)
            val spec = if (size > maxPx) MeasureSpec.makeMeasureSpec(maxPx, MeasureSpec.EXACTLY) else widthMeasureSpec
            super.onMeasure(spec, heightMeasureSpec)
        }
    }

    // ── small pieces ─────────────────────────────────────────────────────

    private fun card(): LinearLayout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        background = GlassDrawable(this@ChooserSettingsActivity, 20f)
        setPadding(dp(16f), dp(14f), dp(16f), dp(14f))
    }

    private fun sectionTitle(text: String, @DrawableRes icon: Int): View = ImageView(this).apply {
        setImageDrawable(VectorLabelDrawable(this@ChooserSettingsActivity, text, icon, textSizeDp = 16f, iconSizeDp = 22f))
        contentDescription = text
        layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(28f))
    }

    private fun textLine(text: String, sizeDp: Float, color: Int, bold: Boolean = false, maxLines: Int = 1): VectorText =
        VectorText(this).apply { set(text, sizeDp, color, bold = bold, maxLines = maxLines) }

    private fun LinearLayout.addBlock(view: View, topDp: Float = 0f, height: Int = ViewGroup.LayoutParams.WRAP_CONTENT) {
        addView(view, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height).apply { topMargin = dp(topDp) })
    }

    /** A title (and a dim line under it) on the left, a control on the right. */
    private fun row(title: String, hint: String?, trailing: View): LinearLayout {
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addBlock(textLine(title, 15f, Color.WHITE, bold = true))
            if (hint != null) addBlock(textLine(hint, 12f, dim, maxLines = 2), 2f)
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            addView(texts, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(trailing, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                marginStart = dp(12f)
            })
        }
    }

    // ── card: Open with and Share ────────────────────────────────────────

    private fun sheetsCard(): View {
        val card = card()
        card.addView(sectionTitle(getString(R.string.ch_set_sheets), R.drawable.ch_ic_open_with))

        val listStyle = ChooserPrefs.sheetList(this)
        val styleTabs = GlassTabs(this).apply {
            setTabs(listOf(getString(R.string.ch_set_style_grid), getString(R.string.ch_set_style_list)), if (listStyle) 1 else 0) { index ->
                ChooserPrefs.setSheetList(this@ChooserSettingsActivity, index == 1)
                columnsBlock.visibility = if (index == 1) View.GONE else View.VISIBLE
            }
        }
        card.addBlock(row(getString(R.string.ch_set_style), null, styleTabs), 12f)

        // apps per row: its own block under the style (five tabs are too wide for a row), only for the grid
        val wanted = ChooserPrefs.sheetColumns(this)
        val columnTabs = GlassTabs(this).apply {
            val labels = listOf(getString(R.string.ch_set_columns_auto), "3", "4", "5", "6")
            setTabs(labels, if (wanted == 0) 0 else wanted - 2) { index ->
                ChooserPrefs.setSheetColumns(this@ChooserSettingsActivity, if (index == 0) 0 else index + 2)
            }
        }
        columnsBlock = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addBlock(textLine(getString(R.string.ch_set_columns), 15f, Color.WHITE, bold = true), 16f)
            addBlock(textLine(getString(R.string.ch_set_columns_hint), 12f, dim, maxLines = 2), 2f)
            addView(columnTabs, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(8f)
            })
            visibility = if (listStyle) View.GONE else View.VISIBLE
        }
        card.addBlock(columnsBlock)
        return card
    }

    // ── card: recent apps ────────────────────────────────────────────────

    private fun recentCard(): View {
        val card = card()
        card.addView(sectionTitle(getString(R.string.ch_set_recent_section), R.drawable.ch_ic_history))

        val switch = GlassSwitch(this)
        switch.setOn(ChooserPrefs.recentEnabled(this), notify = false, animate = false)
        switch.onChange = { on ->
            ChooserPrefs.setRecentEnabled(this, on)
            refreshRecent()
        }
        val switchRow = row(getString(R.string.ch_set_recent), getString(R.string.ch_set_recent_hint), switch).apply {
            isClickable = true
            isFocusable = true
            contentDescription = getString(R.string.ch_set_recent)
            setOnClickListener { switch.toggle() }
        }
        card.addBlock(switchRow, 12f)

        recentBox = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        card.addBlock(recentBox, 6f)
        return card
    }

    /** How many apps are remembered, and the clear button (greyed out when there is nothing to clear). */
    private fun refreshRecent() {
        if (!::recentBox.isInitialized) return
        recentBox.removeAllViews()
        val count = ChooserPrefs.recentCount(this)
        val status = if (count == 0) getString(R.string.ch_set_recent_none) else getString(R.string.ch_set_recent_count, count)
        recentBox.addBlock(textLine(status, 13f, dim), 6f)
        val clear = GlassButtons.pill(this, getString(R.string.ch_set_clear_recent), primary = false, icon = R.drawable.ch_ic_delete) {
            ChooserPrefs.clearAllRecent(this)
            GlassToast.showOn(this, R.drawable.ch_ic_check, getString(R.string.ch_toast_cleared))
            refreshRecent()
        }
        GlassButtons.setEnabled(clear, count > 0)
        recentBox.addBlock(clear, 10f, dp(48f))
    }

    // ── card: saved apps ("Always") ──────────────────────────────────────

    private fun alwaysCard(): View {
        val card = card()
        card.addView(sectionTitle(getString(R.string.ch_set_always), R.drawable.ch_ic_lock))
        card.addBlock(textLine(getString(R.string.ch_set_always_hint), 12f, dim, maxLines = 2), 4f)
        alwaysBox = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        card.addBlock(alwaysBox, 8f)
        return card
    }

    /** One saved choice with the app's name and icon as the package manager knows them now (null = the app is gone). */
    private class AlwaysRow(val entry: ChooserPrefs.AlwaysEntry, val label: String?, val icon: Drawable?)

    private suspend fun loadAlways(): List<AlwaysRow> = withContext(Dispatchers.IO) {
        val pm = packageManager
        ChooserPrefs.alwaysEntries(this@ChooserSettingsActivity).map { entry ->
            var label: String? = null
            var icon: Drawable? = null
            val component = ComponentName.unflattenFromString(entry.key)
            if (component != null) {
                try {
                    val info = pm.getActivityInfo(component, 0)
                    label = info.loadLabel(pm).toString().trim().ifEmpty { component.packageName }
                    icon = info.loadIcon(pm)
                } catch (ex: Exception) {
                    // not installed (any more), or not visible: shown as "not installed"
                }
            }
            AlwaysRow(entry, label, icon)
        }
    }

    private fun refreshAlways() {
        if (!::alwaysBox.isInitialized) return
        alwaysJob?.cancel()
        alwaysJob = scope.launch {
            val rows = loadAlways()
            alwaysBox.removeAllViews()
            if (rows.isEmpty()) {
                alwaysBox.addBlock(textLine(getString(R.string.ch_set_always_empty), 13f, dim, maxLines = 4), 4f)
                return@launch
            }
            rows.forEach { alwaysBox.addBlock(alwaysRow(it)) }
            val clear = GlassButtons.pill(this@ChooserSettingsActivity, getString(R.string.ch_set_clear_always), primary = false, icon = R.drawable.ch_ic_delete) {
                GlassConfirm.show(
                    this@ChooserSettingsActivity, R.drawable.ch_ic_delete,
                    getString(R.string.ch_set_clear_always), getString(R.string.ch_set_cancel)
                ) {
                    ChooserPrefs.clearAllAlways(this@ChooserSettingsActivity)
                    GlassToast.showOn(this@ChooserSettingsActivity, R.drawable.ch_ic_check, getString(R.string.ch_toast_cleared))
                    refreshAlways()
                }
            }
            alwaysBox.addBlock(clear, 10f, dp(48f))
        }
    }

    private fun alwaysRow(r: AlwaysRow): View {
        val gone = r.label == null
        val icon = ImageView(this).apply {
            scaleType = ImageView.ScaleType.FIT_CENTER
            if (r.icon != null) setImageDrawable(r.icon)
            else setImageDrawable(VectorLabelDrawable(this@ChooserSettingsActivity, null, R.drawable.ch_ic_apps, iconSizeDp = 26f, tint = dim))
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val kind = getString(if (r.entry.kind == ChooserKind.SEND) R.string.ch_kind_send else R.string.ch_kind_view)
        val type = if (r.entry.mime == MimeTypes.ANY) getString(R.string.ch_set_any_file) else r.entry.mime
        val name = r.label ?: getString(R.string.ch_set_always_gone)
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addBlock(textLine(name, 15f, if (gone) dim else Color.WHITE, bold = true))
            addBlock(textLine("$kind \u00B7 $type", 12f, dim), 2f)
        }
        val remove = GlassUi.iconButton(this, R.drawable.ch_ic_delete, R.string.ch_cd_remove, sizeDp = 40f) {
            ChooserPrefs.clearAlways(this, r.entry.kind, r.entry.mime)
            GlassToast.showOn(this, R.drawable.ch_ic_check, getString(R.string.ch_toast_removed))
            refreshAlways()
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            minimumHeight = dp(52f)
            contentDescription = "$name, $kind, $type"
            addView(icon, LinearLayout.LayoutParams(dp(36f), dp(36f)))
            addView(texts, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                marginStart = dp(12f)
                marginEnd = dp(8f)
            })
            addView(remove, LinearLayout.LayoutParams(dp(40f), dp(40f)))
        }
    }

    // ── card: file picker ────────────────────────────────────────────────

    private fun pickerCard(): View {
        val card = card()
        card.addView(sectionTitle(getString(R.string.ch_set_picker), R.drawable.ch_ic_folder))
        card.addBlock(textLine(getString(R.string.ch_set_picker_hint), 12f, dim, maxLines = 3), 4f)
        val reset = GlassButtons.pill(this, getString(R.string.ch_set_reset_picker), primary = false, icon = R.drawable.ch_ic_history) {
            ChooserPrefs.resetPicker(this)
            GlassToast.showOn(this, R.drawable.ch_ic_check, getString(R.string.ch_toast_reset))
        }
        card.addBlock(reset, 12f, dp(48f))
        return card
    }
}
