package com.winlator.core;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/**
 * Win11 part 9: the Win11 "glass" card (dark translucent blue-grey, thin light border, round corners)
 * for Winlator's dialogs and progress screens. Built in code (no drawable files), same values as the
 * Win11 dialogs in :app (W11Dialog: fill #D91E2230, border #40FFFFFF, radius 12dp).
 * Only used with Winlator's dark theme (the default); the light theme keeps its own look.
 */
public abstract class GlassStyle {
    public static final int FILL = Color.parseColor("#D91E2230");
    public static final int BORDER = Color.parseColor("#40FFFFFF");

    public static GradientDrawable card(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(FILL);
        drawable.setStroke(Math.max(1, Math.round(density)), BORDER);
        drawable.setCornerRadius(12 * density);
        return drawable;
    }

    /** Puts the glass card behind [view] when Winlator uses its dark theme; does nothing otherwise. */
    public static void apply(Context context, View view) {
        if (view != null && AppUtils.isDarkTheme(context)) view.setBackground(card(context));
    }
}
