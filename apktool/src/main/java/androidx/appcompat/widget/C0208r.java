package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.core.widget.C0338h;

/* compiled from: AppCompatPopupWindow.java */
/* renamed from: androidx.appcompat.widget.r */
/* loaded from: classes.dex */
class C0208r extends PopupWindow {

    /* renamed from: a */
    private static final boolean f1735a;

    /* renamed from: b */
    private boolean f1736b;

    static {
        f1735a = Build.VERSION.SDK_INT < 21;
    }

    public C0208r(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1571a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m1571a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.PopupWindow, i, i2);
        if (m1432a.m1451g(C0059a.j.PopupWindow_overlapAnchor)) {
            m1572a(m1432a.m1438a(C0059a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(m1432a.m1437a(C0059a.j.PopupWindow_android_popupBackground));
        m1432a.m1441b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f1735a && this.f1736b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1735a && this.f1736b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (f1735a && this.f1736b) ? i2 - view.getHeight() : i2, i3, i4);
    }

    /* renamed from: a */
    private void m1572a(boolean z) {
        if (f1735a) {
            this.f1736b = z;
        } else {
            C0338h.m2508a(this, z);
        }
    }
}
