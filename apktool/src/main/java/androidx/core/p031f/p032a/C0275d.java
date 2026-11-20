package androidx.core.p031f.p032a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: androidx.core.f.a.d */
/* loaded from: classes.dex */
public class C0275d {

    /* renamed from: a */
    private final AccessibilityRecord f2123a;

    /* renamed from: a */
    public static void m2045a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: b */
    public static void m2046b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        if (this.f2123a == null) {
            return 0;
        }
        return this.f2123a.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0275d)) {
            return false;
        }
        C0275d c0275d = (C0275d) obj;
        return this.f2123a == null ? c0275d.f2123a == null : this.f2123a.equals(c0275d.f2123a);
    }
}
