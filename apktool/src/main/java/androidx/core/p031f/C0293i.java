package androidx.core.p031f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;

/* compiled from: MenuItemCompat.java */
/* renamed from: androidx.core.f.i */
/* loaded from: classes.dex */
public final class C0293i {
    /* renamed from: a */
    public static MenuItem m2178a(MenuItem menuItem, AbstractC0283b abstractC0283b) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            return ((InterfaceMenuItemC0227b) menuItem).mo801a(abstractC0283b);
        }
        Log.m190w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: a */
    public static void m2182a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    /* renamed from: b */
    public static void m2184b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* renamed from: a */
    public static void m2179a(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setNumericShortcut(c2, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, i);
        }
    }

    /* renamed from: b */
    public static void m2183b(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setAlphabeticShortcut(c2, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, i);
        }
    }

    /* renamed from: a */
    public static void m2180a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2181a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof InterfaceMenuItemC0227b) {
            ((InterfaceMenuItemC0227b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
