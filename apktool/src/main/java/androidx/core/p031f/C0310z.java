package androidx.core.p031f;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.C0225a;

/* compiled from: ViewGroupCompat.java */
/* renamed from: androidx.core.f.z */
/* loaded from: classes.dex */
public final class C0310z {
    /* renamed from: a */
    public static boolean m2306a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(C0225a.c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0308x.m2265l(viewGroup) == null) ? false : true;
    }
}
