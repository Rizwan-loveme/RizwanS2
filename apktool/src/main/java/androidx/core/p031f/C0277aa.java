package androidx.core.p031f;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat.java */
/* renamed from: androidx.core.f.aa */
/* loaded from: classes.dex */
public final class C0277aa {
    /* renamed from: a */
    public static boolean m2054a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC0299o) {
            return ((InterfaceC0299o) viewParent).mo1001a(view, view2, i, i2);
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i);
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
                }
            } else if (viewParent instanceof InterfaceC0298n) {
                return ((InterfaceC0298n) viewParent).onStartNestedScroll(view, view2, i);
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m2055b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC0299o) {
            ((InterfaceC0299o) viewParent).mo1003b(view, view2, i, i2);
            return;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
                    return;
                }
            }
            if (viewParent instanceof InterfaceC0298n) {
                ((InterfaceC0298n) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    /* renamed from: a */
    public static void m2049a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof InterfaceC0299o) {
            ((InterfaceC0299o) viewParent).mo996a(view, i);
            return;
        }
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof InterfaceC0298n) {
                ((InterfaceC0298n) viewParent).onStopNestedScroll(view);
            }
        }
    }

    /* renamed from: a */
    public static void m2050a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (viewParent instanceof InterfaceC0300p) {
            ((InterfaceC0300p) viewParent).mo998a(view, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof InterfaceC0299o) {
            ((InterfaceC0299o) viewParent).mo997a(view, i, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof InterfaceC0298n) {
                ((InterfaceC0298n) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }
    }

    /* renamed from: a */
    public static void m2051a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof InterfaceC0299o) {
            ((InterfaceC0299o) viewParent).mo999a(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof InterfaceC0298n) {
                ((InterfaceC0298n) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }
    }

    /* renamed from: a */
    public static boolean m2053a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
            }
        } else if (viewParent instanceof InterfaceC0298n) {
            return ((InterfaceC0298n) viewParent).onNestedFling(view, f2, f3, z);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2052a(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.m185e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
            }
        } else if (viewParent instanceof InterfaceC0298n) {
            return ((InterfaceC0298n) viewParent).onNestedPreFling(view, f2, f3);
        }
        return false;
    }
}
