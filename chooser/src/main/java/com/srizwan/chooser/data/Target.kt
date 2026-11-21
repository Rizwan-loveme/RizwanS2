package com.srizwan.chooser.data

import android.content.ComponentName
import android.graphics.drawable.Drawable

/** What the sheets are asked for: open a file ([VIEW], `ACTION_VIEW`) or hand it over ([SEND], `ACTION_SEND` / `ACTION_SEND_MULTIPLE`). */
enum class ChooserKind { VIEW, SEND }

/**
 * One app (one activity) that can handle an intent: what the Open with / Share sheets show (name + icon) and what is started when it
 * is chosen (the [component], as an explicit intent, so no system chooser is involved).
 *
 * @property isSelf true for an activity of this app itself (for example the Gallery viewer when a picture is opened).
 */
class Target(
    val label: String,
    val component: ComponentName,
    val icon: Drawable,
    val isSelf: Boolean
) {
    val packageName: String get() = component.packageName

    /** Stable text form of the component (`package/class`), the key used by [ChooserPrefs]. */
    val key: String get() = component.flattenToString()
}
