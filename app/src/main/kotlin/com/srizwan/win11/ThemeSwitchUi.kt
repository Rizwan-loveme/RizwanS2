package com.srizwan.win11

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

// =====================================================================
// Two launcher themes (README.md, "Two launcher themes", step 10): the Win11 side of the switch.
// A glass W11Dialog with two cards: "Win11" (this shell) and "Terminal" (the :tui module, T-UI). The saved theme (ThemeManager.kt) has the
// accent border and a "Current" label; tapping the other card saves it and switches (ThemeManager.switchTo(): opens the target, closes the other).
// Opened from: Start menu > user menu > "Launcher theme" (Win11Shell.showUserMenu) and the deep link rizwans2://theme/choose.
// The terminal side of the switch is the `win11` command (:tui, commands/main/raw/win11.java, through TuiHost.Switcher).
// Step 12: show(ctx, firstRun = true) is the first-run choice (title "Choose your launcher", button "Keep Win11", MainActivity.maybeAskTheme()); closing it in any way counts as
// seen (ThemeManager.markChosen). The content is in a ScrollView and the two cards stack when the dialog is narrower than 300 dp, so a small screen (or a short one) still
// shows everything.
// Everything is drawn in code (no new resources): the two previews are small views, the terminal one uses the monospace font and the green on black of T-UI.
// =====================================================================

object ThemeSwitchUi {

    private const val LOGT = "ThemeSwitchUi"
    private val ACCENT = Color.parseColor("#60CDFF")
    private val BORDER = Color.parseColor("#40FFFFFF")
    private val TERM_GREEN = Color.parseColor("#00FF00")

    /** Opens the two theme cards. [ctx] should be MainActivity (the Win11 screen): switching to TERMINAL finishes it, a plain Context only starts the terminal. */
    fun show(ctx: Context, firstRun: Boolean = false) {
        try {
            val current = ThemeManager.get(ctx)
            lateinit var dialog: W11Dialog

            fun choose(theme: LauncherTheme) {
                dialog.dismiss()
                if (theme == current) return
                ThemeManager.switchTo(ctx, theme)
                if (theme == LauncherTheme.TERMINAL) {
                    Toast.makeText(ctx.applicationContext, "Terminal theme is on. Type  win11  to switch back.", Toast.LENGTH_LONG).show()
                }
            }

            // W11Dialog is 88 % of the screen width, at most 420 dp, with 22 dp padding on each side; under 300 dp of content the cards go one below the other.
            val dm = ctx.resources.displayMetrics
            val dialogDp = (dm.widthPixels * 0.88f).coerceAtMost(420f * dm.density) / dm.density
            val stacked = dialogDp - 44f < 300f

            val row = LinearLayout(ctx).apply {
                orientation = if (stacked) LinearLayout.VERTICAL else LinearLayout.HORIZONTAL
                weightSum = 2f
            }
            row.addView(card(ctx, "Win11", "Start menu, taskbar and apps", LauncherTheme.WIN11 == current, win11Preview(ctx)) { choose(LauncherTheme.WIN11) },
                cardParams(ctx, first = true, stacked = stacked))
            row.addView(card(ctx, "Terminal", "T-UI, commands and a text screen", LauncherTheme.TERMINAL == current, terminalPreview(ctx)) { choose(LauncherTheme.TERMINAL) },
                cardParams(ctx, first = false, stacked = stacked))

            val col = LinearLayout(ctx).apply { orientation = LinearLayout.VERTICAL }
            col.addView(row)
            col.addView(TextView(ctx).apply {
                text = "The chosen theme answers the Home button, the launcher icon and the start after a restart. " +
                    "Back to Win11 from the terminal: type  win11."
                setTextColor(Color.parseColor("#A0A0A0"))
                textSize = 12f
                setLineSpacing(0f, 1.15f)
                setPadding(0, dp(ctx, 12), 0, 0)
            })

            // short screens (landscape phones): the cards scroll instead of running off the dialog
            val scroll = ScrollView(ctx).apply {
                isVerticalScrollBarEnabled = false
                addView(col)
            }

            dialog = W11Dialog.Builder(ctx)
                .setTitle(if (firstRun) "Choose your launcher" else "Launcher theme")
                .setView(scroll)
                .setNegativeButton(if (firstRun) "Keep Win11" else "Close", null)
                .create()
            // every way of closing it counts as "seen": the first-run choice is not asked again (a card tap saves the theme through switchTo())
            dialog.setOnDismissListener { ThemeManager.markChosen(ctx) }
            dialog.show()
        } catch (e: Throwable) {
            AppLog.e(LOGT, "cannot show the theme cards", e)
            Toast.makeText(ctx, "Theme error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun dp(ctx: Context, v: Int): Int = (v * ctx.resources.displayMetrics.density).toInt()

    private fun cardParams(ctx: Context, first: Boolean, stacked: Boolean) =
        if (stacked) {
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                if (first) bottomMargin = dp(ctx, 8)
            }
        } else {
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                if (first) marginEnd = dp(ctx, 6) else marginStart = dp(ctx, 6)
            }
        }

    private fun card(ctx: Context, title: String, subtitle: String, selected: Boolean, preview: View, onClick: () -> Unit): View {
        val box = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(ctx, 10), dp(ctx, 10), dp(ctx, 10), dp(ctx, 10))
            background = GradientDrawable().apply {
                cornerRadius = dp(ctx, 10).toFloat()
                setColor(if (selected) Color.parseColor("#26FFFFFF") else Color.parseColor("#14FFFFFF"))
                setStroke(dp(ctx, if (selected) 2 else 1), if (selected) ACCENT else BORDER)
            }
            isClickable = true
            isFocusable = true
            setOnClickListener { onClick() }
        }
        box.addView(preview, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(ctx, 84)))
        box.addView(TextView(ctx).apply {
            text = title
            setTextColor(Color.WHITE)
            textSize = 15f
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, dp(ctx, 10), 0, 0)
        })
        box.addView(TextView(ctx).apply {
            text = subtitle
            setTextColor(Color.parseColor("#B0B0B0"))
            textSize = 11f
            minLines = 2
            setLineSpacing(0f, 1.1f)
            setPadding(0, dp(ctx, 2), 0, 0)
        })
        box.addView(TextView(ctx).apply {
            text = if (selected) "✓ Current" else "Tap to switch"
            setTextColor(if (selected) ACCENT else Color.parseColor("#808080"))
            textSize = 12f
            typeface = if (selected) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
            setPadding(0, dp(ctx, 6), 0, 0)
        })
        return box
    }

    /** Mini Win11 screen: blue wallpaper, a Start-style panel and the taskbar with its four icons. */
    private fun win11Preview(ctx: Context): View {
        val f = FrameLayout(ctx).apply {
            background = GradientDrawable(GradientDrawable.Orientation.TL_BR, intArrayOf(Color.parseColor("#1B6FD1"), Color.parseColor("#0A2A66"))).apply {
                cornerRadius = dp(ctx, 6).toFloat()
            }
        }
        f.addView(View(ctx).apply {
            background = GradientDrawable().apply { cornerRadius = dp(ctx, 4).toFloat(); setColor(Color.parseColor("#B3FFFFFF")) }
        }, FrameLayout.LayoutParams(dp(ctx, 54), dp(ctx, 38), Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM).apply { bottomMargin = dp(ctx, 16) })
        val bar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#CC101826"))
        }
        repeat(4) {
            bar.addView(View(ctx).apply {
                background = GradientDrawable().apply { cornerRadius = dp(ctx, 2).toFloat(); setColor(if (it == 0) ACCENT else Color.parseColor("#E6FFFFFF")) }
            }, LinearLayout.LayoutParams(dp(ctx, 7), dp(ctx, 7)).apply { marginStart = dp(ctx, 3); marginEnd = dp(ctx, 3) })
        }
        f.addView(bar, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(ctx, 12), Gravity.BOTTOM))
        return f
    }

    /** Mini terminal: black screen, green monospace prompt lines (T-UI style). */
    private fun terminalPreview(ctx: Context): View {
        return TextView(ctx).apply {
            text = "$ apps\nfirefox  maps\n$ win11\n$ _"
            setTextColor(TERM_GREEN)
            typeface = Typeface.MONOSPACE
            textSize = 10f
            setLineSpacing(0f, 1.05f)
            setPadding(dp(ctx, 8), dp(ctx, 6), dp(ctx, 6), dp(ctx, 4))
            gravity = Gravity.TOP or Gravity.START
            background = GradientDrawable().apply {
                cornerRadius = dp(ctx, 6).toFloat()
                setColor(Color.BLACK)
                setStroke(dp(ctx, 1), Color.parseColor("#33FFFFFF"))
            }
        }
    }
}
