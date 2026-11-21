package com.srizwan.chooser.ui

import android.app.Activity
import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import com.srizwan.chooser.R

/**
 * A one-line text prompt as a glass sheet (the rename of step 8), built on [GlassSheet.showContent]: a vector title with
 * an icon, a glass field and a round check button. The field is the only real text of the sheet (like the search field
 * of the home screen). The keyboard opens at once; the check button or the keyboard's Done key confirms, tapping
 * outside or Back cancels.
 */
object GlassPrompt {

    /**
     * [initial] fills the field and its first [selectChars] characters are selected (the file name without its
     * extension), so typing replaces the name and keeps the extension. [onDone] gets the text as typed.
     */
    fun show(
        activity: Activity,
        @DrawableRes icon: Int,
        title: String,
        initial: String,
        selectChars: Int,
        onDone: (String) -> Unit
    ) {
        GlassSheet.showContent(activity, keyboard = true) { dismiss ->
            fun dp(v: Float) = GlassUi.dp(activity, v)

            val heading = ImageView(activity).apply {
                setImageDrawable(VectorLabelDrawable(activity, title, icon, textSizeDp = 16f, iconSizeDp = 22f))
            }

            val field = EditText(activity).apply {
                background = null
                setTextColor(Color.WHITE)
                setHintTextColor(0x80FFFFFF.toInt())
                contentDescription = title
                textSize = 16f
                setSingleLine()
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
                imeOptions = EditorInfo.IME_ACTION_DONE
                setPadding(dp(16f), 0, dp(8f), 0)
                setText(initial)
                setSelection(0, selectChars.coerceIn(0, initial.length))
            }
            fun confirm() {
                val text = field.text?.toString().orEmpty()
                dismiss()
                onDone(text)
            }
            field.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    confirm()
                    true
                } else false
            }
            val ok = GlassUi.iconButton(activity, R.drawable.ch_ic_check, R.string.ch_cd_confirm, sizeDp = 48f, glass = true) {
                confirm()
            }

            val fieldPill = LinearLayout(activity).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                background = GlassDrawable(activity, 24f)
                addView(field, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
            }
            val row = LinearLayout(activity).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                addView(fieldPill, LinearLayout.LayoutParams(0, dp(48f), 1f))
                addView(ok, LinearLayout.LayoutParams(dp(48f), dp(48f)).apply { marginStart = dp(8f) })
            }

            field.post { field.requestFocus() }
            LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(16f), dp(14f), dp(16f), dp(16f))
                addView(heading, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(30f)))
                addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(10f)
                })
            }
        }
    }
}
