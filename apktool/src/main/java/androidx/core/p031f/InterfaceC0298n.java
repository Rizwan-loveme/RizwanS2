package androidx.core.p031f;

import android.view.View;

/* compiled from: NestedScrollingParent.java */
/* renamed from: androidx.core.f.n */
/* loaded from: classes.dex */
public interface InterfaceC0298n {
    boolean onNestedFling(View view, float f2, float f3, boolean z);

    boolean onNestedPreFling(View view, float f2, float f3);

    void onNestedPreScroll(View view, int i, int i2, int[] iArr);

    void onNestedScroll(View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(View view, View view2, int i);

    boolean onStartNestedScroll(View view, View view2, int i);

    void onStopNestedScroll(View view);
}
