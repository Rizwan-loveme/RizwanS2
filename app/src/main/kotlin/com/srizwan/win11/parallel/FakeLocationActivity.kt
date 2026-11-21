package com.srizwan.win11.parallel

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.srizwan.win11.Toast
import top.niunaijun.blackbox.entity.location.BLocation
import top.niunaijun.blackbox.fake.frameworks.BLocationManager
import top.niunaijun.blackbox.utils.Coordinates

/**
 * Fake location screen (part 24). Opened with the 📍 button of a clone.
 *
 * The engine already fakes the location of a clone ([BLocationManager]); this screen is the
 * way to set it. Three modes, the engine's own:
 *  - Off: the clone sees the real location.
 *  - This app only (OWN_MODE): the coordinates saved for this clone.
 *  - Global (GLOBAL_MODE): one shared coordinate for every clone that is in this mode.
 *
 * The coordinates are two fields, or a pasted "lat, lon" pair (from a map app), or one of a few
 * ready places. They are checked by [Coordinates] before anything is saved.
 */
class FakeLocationActivity : Activity() {

    companion object {
        const val EXTRA_PACKAGE = "pkg"
        const val EXTRA_USER = "user"
        const val EXTRA_LABEL = "label"
        private const val PREFS = "parallel_fake_location"
    }

    private data class Place(val name: String, val lat: Double, val lon: Double)

    private val places = listOf(
        Place("ঢাকা", 23.8103, 90.4125),
        Place("মক্কা", 21.4225, 39.8262),
        Place("মদিনা", 24.4672, 39.6111),
        Place("লন্ডন", 51.5074, -0.1278),
        Place("নিউ ইয়র্ক", 40.7128, -74.0060),
        Place("টোকিও", 35.6762, 139.6503)
    )

    private val ui = Handler(Looper.getMainLooper())
    private lateinit var pkg: String
    private var userId = 0
    private lateinit var label: String

    private var mode = BLocationManager.CLOSE_MODE
    private var ownLocation: BLocation? = null
    private var globalLocation: BLocation? = null

    private lateinit var latField: EditText
    private lateinit var lonField: EditText
    private lateinit var modeHint: TextView
    private val modeRows = ArrayList<Pair<Int, LinearLayout>>()

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
        header.addView(tv("📍 ফেক লোকেশন", 26f, Color.WHITE, bold = true))
        header.addView(tv("$label · স্পেস ${userId + 1}", 14f, Color.parseColor("#E0DDFF")).apply { oneLine() })
        column.addView(header, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(14), dp(16), dp(40))
        }
        column.addView(ScrollView(this).apply { addView(content) }, LinearLayout.LayoutParams(MATCH_PARENT, 0, 1f))
        root.addView(column, FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        // mode card
        content.addView(tv("কোন লোকেশন দেখাবে?", 14f, Palette.MUTED, bold = true).apply { setPadding(dp(4), 0, 0, dp(8)) })
        addModeRow(content, BLocationManager.CLOSE_MODE, "⛔", "বন্ধ", "আসল লোকেশন দেখাবে")
        addModeRow(content, BLocationManager.OWN_MODE, "📍", "শুধু এই অ্যাপ", "এই ক্লোনের জন্য আলাদা স্থান")
        addModeRow(content, BLocationManager.GLOBAL_MODE, "🌐", "সব ক্লোনের জন্য", "গ্লোবাল মোডের সব ক্লোন একই স্থান দেখবে")

        // coordinates card
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundBg(Palette.CARD, 18)
            setPadding(dp(14), dp(12), dp(14), dp(14))
            elevation = dp(2).toFloat()
        }
        card.addView(tv("স্থানাঙ্ক", 14f, Palette.MUTED, bold = true))
        latField = field("অক্ষাংশ (Latitude), যেমন 23.8103")
        lonField = field("দ্রাঘিমাংশ (Longitude), যেমন 90.4125")
        card.addView(latField, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(8) })
        card.addView(lonField, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(8) })
        card.addView(tv("📋  ক্লিপবোর্ড থেকে পেস্ট (23.8103, 90.4125)", 13f, Palette.PRIMARY, bold = true).apply {
            background = roundBg(Palette.LILAC, 12)
            gravity = Gravity.CENTER
            setPadding(dp(12), dp(10), dp(12), dp(10))
            setOnClickListener { pasteFromClipboard() }
        }, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(10) })

        card.addView(tv("দ্রুত স্থান", 12f, Palette.MUTED).apply { setPadding(0, dp(12), 0, dp(6)) })
        val chips = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        for (p in places) {
            chips.addView(tv(p.name, 13f, Palette.TEXT, bold = true).apply {
                background = roundBg(Palette.AMBER, 14)
                gravity = Gravity.CENTER
                setPadding(dp(14), dp(8), dp(14), dp(8))
                setOnClickListener { fill(p.lat, p.lon) }
            }, LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply { rightMargin = dp(8) })
        }
        card.addView(HorizontalScrollView(this).apply {
            isHorizontalScrollBarEnabled = false
            addView(chips)
        })
        content.addView(card, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(12) })

        modeHint = tv("", 12f, Palette.MUTED).apply { setPadding(dp(4), dp(10), dp(4), 0) }
        content.addView(modeHint)

        content.addView(tv("💾  সংরক্ষণ", 16f, Color.WHITE, bold = true).apply {
            gravity = Gravity.CENTER
            background = roundBg(Palette.PRIMARY, 30)
            setPadding(dp(22), dp(16), dp(22), dp(16))
            setOnClickListener { save() }
        }, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { topMargin = dp(16) })

        content.addView(tv(
            "চালু অ্যাপে কিছুক্ষণের মধ্যে নতুন স্থান কার্যকর হয়। না হলে অ্যাপটি বন্ধ করে আবার খুলুন।",
            11f, Palette.MUTED
        ).apply { setPadding(dp(4), dp(10), dp(4), 0) })

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

    private fun field(hintText: String): EditText = EditText(this).apply {
        hint = hintText
        setHintTextColor(Palette.MUTED)
        setTextColor(Palette.TEXT)
        textSize = 15f
        inputType = InputType.TYPE_CLASS_TEXT
        setSingleLine()
        background = roundBg(Color.parseColor("#F1F2F8"), 12)
        setPadding(dp(14), dp(12), dp(14), dp(12))
    }

    private fun addModeRow(parent: LinearLayout, value: Int, emoji: String, title: String, note: String) {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(14), dp(12), dp(14), dp(12))
            elevation = dp(2).toFloat()
            setOnClickListener { selectMode(value) }
        }
        row.addView(tv(emoji, 22f).apply { setPadding(0, 0, dp(12), 0) })
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
        }
        texts.addView(tv(title, 15f, Palette.TEXT, bold = true))
        texts.addView(tv(note, 11f, Palette.MUTED))
        row.addView(texts)
        parent.addView(row, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { bottomMargin = dp(8) })
        modeRows.add(value to row)
    }

    // ------------------------------------------------------------------ data

    private fun prefs() = getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    private fun ownKey() = "own:$userId:$pkg"

    private fun saveOwnMemory(lat: Double, lon: Double) {
        prefs().edit().putString(ownKey(), "$lat,$lon").apply()
    }

    private fun readOwnMemory(): BLocation? {
        val r = Coordinates.parsePair(prefs().getString(ownKey(), null))
        return if (r.ok()) BLocation(r.latitude, r.longitude) else null
    }

    /** Reads the current state from the engine (binder calls), then draws. */
    private fun load() {
        Engine.io.execute {
            val m = BLocationManager.get()
            val pattern = try { m.getPattern(userId, pkg) } catch (e: Throwable) { BLocationManager.CLOSE_MODE }
            // the engine only returns this clone's own coordinates while the mode is "own";
            // in the other modes the last saved ones come from this screen's own memory
            val own = (if (pattern == BLocationManager.OWN_MODE) try { m.getLocation(userId, pkg) } catch (e: Throwable) { null } else null)
                ?: readOwnMemory()
            val global = try { m.globalLocation } catch (e: Throwable) { null }
            ui.post {
                if (isFinishing) return@post
                mode = pattern
                ownLocation = own
                globalLocation = global
                selectMode(mode)
            }
        }
    }

    private fun selectMode(value: Int) {
        // keep what was typed for the mode we leave
        rememberTyped()
        mode = value
        for ((v, row) in modeRows) {
            row.background = roundBg(if (v == mode) Palette.LILAC else Palette.CARD, 16)
        }
        val shown = when (mode) {
            BLocationManager.OWN_MODE -> ownLocation
            BLocationManager.GLOBAL_MODE -> globalLocation
            else -> ownLocation ?: globalLocation
        }
        if (shown != null && !shown.isEmpty) fill(shown.latitude, shown.longitude) else { latField.setText(""); lonField.setText("") }
        val enabled = mode != BLocationManager.CLOSE_MODE
        latField.isEnabled = enabled
        lonField.isEnabled = enabled
        latField.alpha = if (enabled) 1f else 0.45f
        lonField.alpha = if (enabled) 1f else 0.45f
        modeHint.text = when (mode) {
            BLocationManager.OWN_MODE -> "এই ক্লোনের জন্য আলাদা স্থান সংরক্ষিত থাকবে।"
            BLocationManager.GLOBAL_MODE -> "এই স্থান গ্লোবাল মোডের সব ক্লোন দেখবে।"
            else -> "বন্ধ থাকলে ক্লোন আসল লোকেশন দেখে। সংরক্ষণ চাপলে মোড বন্ধ হবে।"
        }
    }

    /** Remembers valid typed numbers for the mode that is being left, so a switch does not lose them. */
    private fun rememberTyped() {
        if (!::latField.isInitialized) return
        val r = Coordinates.parse(latField.text.toString(), lonField.text.toString())
        if (!r.ok()) return
        when (mode) {
            BLocationManager.OWN_MODE -> ownLocation = BLocation(r.latitude, r.longitude)
            BLocationManager.GLOBAL_MODE -> globalLocation = BLocation(r.latitude, r.longitude)
            else -> {}
        }
    }

    private fun fill(lat: Double, lon: Double) {
        latField.setText(Coordinates.format(lat))
        lonField.setText(Coordinates.format(lon))
    }

    private fun pasteFromClipboard() {
        val text = try {
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.primaryClip?.getItemAt(0)?.coerceToText(this)?.toString()
        } catch (e: Throwable) { null }
        val r = Coordinates.parsePair(text)
        if (r.ok()) fill(r.latitude, r.longitude) else toast("❌ ক্লিপবোর্ডে সঠিক স্থানাঙ্ক নেই (যেমন 23.8103, 90.4125)")
    }

    private fun errorText(e: Coordinates.Error): String = when (e) {
        Coordinates.Error.EMPTY -> "অক্ষাংশ ও দ্রাঘিমাংশ দুটোই লিখুন"
        Coordinates.Error.NOT_A_NUMBER -> "শুধু সংখ্যা লিখুন, দশমিকের জন্য ডট (.) ব্যবহার করুন"
        Coordinates.Error.LAT_RANGE -> "অক্ষাংশ -90 থেকে 90 এর মধ্যে হতে হবে"
        Coordinates.Error.LON_RANGE -> "দ্রাঘিমাংশ -180 থেকে 180 এর মধ্যে হতে হবে"
        Coordinates.Error.NULL_ISLAND -> "0, 0 দেওয়া যাবে না (ইঞ্জিন এটাকে \"কোনো লোকেশন নেই\" ধরে)"
        else -> ""
    }

    private fun save() {
        val chosen = mode
        if (chosen == BLocationManager.CLOSE_MODE) {
            Engine.io.execute {
                BLocationManager.get().setPattern(userId, pkg, BLocationManager.CLOSE_MODE)
                ui.post { toast("⛔ ফেক লোকেশন বন্ধ হয়েছে"); finish() }
            }
            return
        }
        var latText = latField.text.toString()
        var lonText = lonField.text.toString()
        // a pair pasted into the first field is accepted too
        if (lonText.isBlank() && latText.isNotBlank()) {
            val pair = Coordinates.parsePair(latText)
            if (pair.ok()) { fill(pair.latitude, pair.longitude); latText = latField.text.toString(); lonText = lonField.text.toString() }
        }
        val r = Coordinates.parse(latText, lonText)
        if (!r.ok()) {
            toast("❌ " + errorText(r.error))
            return
        }
        val loc = BLocation(r.latitude, r.longitude)
        Engine.io.execute {
            val m = BLocationManager.get()
            if (chosen == BLocationManager.OWN_MODE) {
                m.setLocation(userId, pkg, loc)
                saveOwnMemory(r.latitude, r.longitude)
            } else {
                m.setGlobalLocation(loc)
            }
            m.setPattern(userId, pkg, chosen)
            ui.post {
                toast("✅ ${Coordinates.format(r.latitude)}, ${Coordinates.format(r.longitude)} সংরক্ষিত")
                finish()
            }
        }
    }

    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
