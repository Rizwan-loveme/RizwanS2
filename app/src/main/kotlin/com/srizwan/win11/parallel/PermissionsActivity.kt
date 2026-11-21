package com.srizwan.win11.parallel

import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.srizwan.win11.Toast
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.core.system.permission.PermissionCatalog
import top.niunaijun.blackbox.fake.frameworks.BPermissionManager

/**
 * Per-clone permission screen (part 16). Opened with the ⚙️ button of a clone.
 *
 * Every permission group (camera, microphone, ...) has a three-way selector: Allow / Ask / Deny.
 * Choosing one writes the mode for every permission of that group into the permission store,
 * so the hooks from parts 14 and 15 change the real behaviour of the clone at once.
 * A global default (for clones without their own setting) and "Reset" are at the top / bottom.
 */
class PermissionsActivity : Activity() {

    companion object {
        const val EXTRA_PACKAGE = "pkg"
        const val EXTRA_USER = "user"
        const val EXTRA_LABEL = "label"
    }

    private data class GroupState(val id: String, val mode: Int, val inherited: Boolean)

    private val ui = Handler(Looper.getMainLooper())
    private lateinit var pkg: String
    private var userId = 0
    private lateinit var label: String

    private lateinit var content: LinearLayout

    private val groupTitles = mapOf(
        PermissionCatalog.CAMERA to "📷 ক্যামেরা",
        PermissionCatalog.MICROPHONE to "🎤 মাইক্রোফোন",
        PermissionCatalog.LOCATION to "📍 লোকেশন",
        PermissionCatalog.CONTACTS to "👥 কন্টাক্ট",
        PermissionCatalog.CALENDAR to "📅 ক্যালেন্ডার",
        PermissionCatalog.PHONE to "📞 ফোন",
        PermissionCatalog.SMS to "💬 এসএমএস",
        PermissionCatalog.STORAGE to "📁 স্টোরেজ ও মিডিয়া",
        PermissionCatalog.NOTIFICATIONS to "🔔 নোটিফিকেশন",
        PermissionCatalog.SENSORS to "❤️ বডি সেন্সর",
        PermissionCatalog.ACTIVITY to "🏃 শারীরিক কার্যকলাপ",
        PermissionCatalog.NEARBY to "📡 কাছের ডিভাইস"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pkg = intent.getStringExtra(EXTRA_PACKAGE) ?: run { finish(); return }
        userId = intent.getIntExtra(EXTRA_USER, 0)
        label = intent.getStringExtra(EXTRA_LABEL) ?: pkg
        window.statusBarColor = Palette.PRIMARY_DARK
        setContentView(buildFrame())
        load()
    }

    // ------------------------------------------------------------------ frame

    private fun buildFrame(): View {
        val root = FrameLayout(this).apply { setBackgroundColor(Palette.BG) }
        val column = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }

        val header = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(26), dp(22), dp(22))
            val r = dp(26).toFloat()
            background = GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                intArrayOf(Palette.PRIMARY_DARK, Palette.PRIMARY)
            ).apply { cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, r, r, r, r) }
        }
        header.addView(tv("🔐 অনুমতি", 26f, Color.WHITE, bold = true))
        header.addView(tv("$label · স্পেস ${userId + 1}", 14f, Color.parseColor("#E0DDFF")).apply { oneLine() })
        column.addView(header, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))

        content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(14), dp(16), dp(40))
        }
        column.addView(ScrollView(this).apply { addView(content) }, LinearLayout.LayoutParams(MATCH_PARENT, 0, 1f))
        root.addView(column, FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        root.setOnApplyWindowInsetsListener { _, ins ->
            @Suppress("DEPRECATION")
            val top = ins.systemWindowInsetTop
            @Suppress("DEPRECATION")
            val bottom = ins.systemWindowInsetBottom
            header.setPadding(dp(22), dp(26) + top, dp(22), dp(22))
            content.setPadding(dp(16), dp(14), dp(16), dp(40) + bottom)
            ins
        }
        return root
    }

    // ------------------------------------------------------------------ data

    /** Reads everything on the engine thread (binder calls), then draws on the main thread. */
    private fun load() {
        Engine.io.execute {
            val pm = BPermissionManager.get()
            val requested: Set<String> = try {
                BlackBoxCore.getBPackageManager()
                    .getPackageInfo(pkg, PackageManager.GET_PERMISSIONS, userId)
                    ?.requestedPermissions?.toSet() ?: emptySet()
            } catch (e: Throwable) {
                emptySet()
            }

            val global = pm.globalDefault
            val states = ArrayList<GroupState>()
            var anyRequested = false
            for (id in PermissionCatalog.getGroupIds()) {
                val all = PermissionCatalog.getPermissions(id)
                val asked = all.filter { it in requested }
                if (asked.isNotEmpty()) anyRequested = true
                // only groups the app asks for; the full list is shown if nothing could be read
                if (requested.isNotEmpty() && asked.isEmpty()) continue
                val scope = if (asked.isEmpty()) all else asked
                val modes = scope.map { pm.getMode(userId, pkg, it) }.toSet()
                val inherited = scope.all { pm.getRawMode(userId, pkg, it) == BPermissionManager.MODE_DEFAULT }
                states.add(GroupState(id, if (modes.size == 1) modes.first() else 0, inherited))
            }
            ui.post { if (!isFinishing && !isDestroyed) render(global, states, anyRequested || requested.isEmpty()) }
        }
    }

    private fun setGroup(groupId: String, mode: Int) {
        Engine.io.execute {
            val pm = BPermissionManager.get()
            for (p in PermissionCatalog.getPermissions(groupId)) pm.setMode(userId, pkg, p, mode)
        }
    }

    // ------------------------------------------------------------------ drawing

    private fun render(global: Int, states: List<GroupState>, showList: Boolean) {
        content.removeAllViews()

        // ---- global default
        val globalCard = card()
        globalCard.addView(tv("🌐 সব ক্লোনের ডিফল্ট", 15f, Palette.TEXT, bold = true))
        globalCard.addView(tv("যে অ্যাপের নিজস্ব সেটিং নেই, তার জন্য প্রযোজ্য", 12f, Palette.MUTED).apply {
            setPadding(0, dp(2), 0, dp(10))
        })
        globalCard.addView(segmented(global) { mode ->
            Engine.io.execute { BPermissionManager.get().setGlobalDefault(mode); ui.post { load() } }
        })
        content.addView(globalCard)

        // ---- this clone
        content.addView(tv("$label এর অনুমতি", 14f, Palette.MUTED, bold = true).apply {
            setPadding(dp(4), dp(8), 0, dp(8))
        })
        if (!showList || states.isEmpty()) {
            content.addView(tv("এই অ্যাপ কোনো নিয়ন্ত্রণযোগ্য অনুমতি চায় না", 13f, Palette.MUTED).apply {
                gravity = Gravity.CENTER
                setPadding(0, dp(20), 0, dp(20))
            })
        }
        for (s in states) content.addView(groupCard(s))

        content.addView(tv(
            "✅ দিন: অ্যাপ অনুমতি পাবে\n❓ জিজ্ঞাসা: অ্যাপ অনুমতি চাইলে ডায়ালগ আসবে (সবসময় দিন / শুধু এবার / এবার না / কখনো না)\n⛔ বন্ধ: অ্যাপ অনুমতি পাবে না\n\nক্যামেরা, মাইক্রোফোন, লোকেশন ইত্যাদির জন্য এই (হোস্ট) অ্যাপেরও ফোনের অনুমতি লাগে। ক্লোনকে দেওয়ার সময় তা না থাকলে আগে ফোনের অনুমতি চাওয়া হবে; ফোন \"আর জিজ্ঞেস করবে না\" বললে সেটিংসে নিয়ে যাওয়া হবে।\n\nপরিবর্তন সঙ্গে সঙ্গে সেভ হয়। চালু অ্যাপে প্রভাব পেতে অ্যাপটি আবার খুলতে হতে পারে।",
            12f, Palette.MUTED
        ).apply { setPadding(dp(4), dp(8), dp(4), dp(8)) })

        // ---- reset
        content.addView(button("🔄 এই ক্লোনের সব রিসেট", Palette.AMBER) {
            confirm("🔄 রিসেট করবেন?", "$label এর সব অনুমতি সেটিং মুছে ডিফল্টে ফিরবে।") {
                Engine.io.execute {
                    BPermissionManager.get().resetPackage(userId, pkg)
                    ui.post { toast("✅ রিসেট হয়েছে"); load() }
                }
            }
        })
        content.addView(button("♻️ সব ক্লোনের সব রিসেট", Palette.RED) {
            confirm("♻️ সব রিসেট?", "সব ক্লোনের অনুমতি সেটিং মুছে যাবে এবং ডিফল্ট \"দিন\" হয়ে যাবে।") {
                Engine.io.execute {
                    BPermissionManager.get().resetAll()
                    ui.post { toast("✅ সব রিসেট হয়েছে"); load() }
                }
            }
        })
    }

    private fun groupCard(s: GroupState): View {
        val card = card()
        val top = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        top.addView(tv(groupTitles[s.id] ?: s.id, 15f, Palette.TEXT, bold = true), LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f))
        val note = when {
            s.mode == 0 -> "মিশ্র সেটিং"
            s.inherited -> "ডিফল্ট থেকে"
            else -> ""
        }
        if (note.isNotEmpty()) top.addView(tv(note, 11f, Palette.MUTED))
        card.addView(top)
        card.addView(segmented(s.mode) { mode -> setGroup(s.id, mode) }.apply {
            (layoutParams as LinearLayout.LayoutParams).topMargin = dp(10)
        })
        return card
    }

    private fun card(): LinearLayout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        background = roundBg(Palette.CARD, 18)
        setPadding(dp(16), dp(14), dp(16), dp(14))
        elevation = dp(2).toFloat()
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { bottomMargin = dp(10) }
    }

    private fun colorFor(mode: Int): Int = when (mode) {
        BPermissionManager.MODE_ALLOW -> Color.parseColor("#BFEBCB")
        BPermissionManager.MODE_ASK -> Color.parseColor("#FFE2A8")
        else -> Color.parseColor("#F9BDBD")
    }

    /** Allow / Ask / Deny selector. [current] 0 = nothing highlighted (mixed). */
    private fun segmented(current: Int, onPick: (Int) -> Unit): LinearLayout {
        val box = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            background = roundBg(Color.parseColor("#EEF0F7"), 14)
            setPadding(dp(3), dp(3), dp(3), dp(3))
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }
        val cells = ArrayList<Pair<Int, TextView>>()
        fun paint(selected: Int) {
            for ((mode, t) in cells) {
                if (mode == selected) {
                    t.background = roundBg(colorFor(mode), 11)
                    t.setTextColor(Palette.TEXT)
                    t.setTypeface(null, Typeface.BOLD)
                } else {
                    t.background = null
                    t.setTextColor(Palette.MUTED)
                    t.setTypeface(null, Typeface.NORMAL)
                }
            }
        }
        val labels = listOf(
            BPermissionManager.MODE_ALLOW to "✅ দিন",
            BPermissionManager.MODE_ASK to "❓ জিজ্ঞাসা",
            BPermissionManager.MODE_DENY to "⛔ বন্ধ"
        )
        for ((mode, text) in labels) {
            val t = tv(text, 12f, Palette.MUTED).apply {
                gravity = Gravity.CENTER
                setPadding(dp(6), dp(9), dp(6), dp(9))
                setOnClickListener { paint(mode); onPick(mode) }
            }
            cells.add(mode to t)
            box.addView(t, LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f))
        }
        paint(current)
        return box
    }

    private fun button(text: String, bg: Int, onClick: () -> Unit): TextView =
        tv(text, 14f, Palette.TEXT, bold = true).apply {
            gravity = Gravity.CENTER
            background = roundBg(bg, 14)
            setPadding(dp(14), dp(13), dp(14), dp(13))
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(10) }
            setOnClickListener { onClick() }
        }

    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    private fun confirm(title: String, message: String, onYes: () -> Unit) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("হ্যাঁ") { _, _ -> onYes() }
            .setNegativeButton("না", null)
            .show()
    }
}
