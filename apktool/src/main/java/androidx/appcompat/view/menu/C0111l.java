package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.p008os.Build;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;

/* compiled from: MenuPopupHelper.java */
/* renamed from: androidx.appcompat.view.menu.l */
/* loaded from: classes.dex */
public class C0111l {

    /* renamed from: a */
    private final Context f1071a;

    /* renamed from: b */
    private final C0106g f1072b;

    /* renamed from: c */
    private final boolean f1073c;

    /* renamed from: d */
    private final int f1074d;

    /* renamed from: e */
    private final int f1075e;

    /* renamed from: f */
    private View f1076f;

    /* renamed from: g */
    private int f1077g;

    /* renamed from: h */
    private boolean f1078h;

    /* renamed from: i */
    private InterfaceC0112m.a f1079i;

    /* renamed from: j */
    private AbstractC0110k f1080j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f1081k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f1082l;

    public C0111l(Context context, C0106g c0106g, View view, boolean z, int i) {
        this(context, c0106g, view, z, i, 0);
    }

    public C0111l(Context context, C0106g c0106g, View view, boolean z, int i, int i2) {
        this.f1077g = Gravity.START;
        this.f1082l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.l.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                C0111l.this.mo972e();
            }
        };
        this.f1071a = context;
        this.f1072b = c0106g;
        this.f1076f = view;
        this.f1073c = z;
        this.f1074d = i;
        this.f1075e = i2;
    }

    /* renamed from: a */
    public void m965a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1081k = onDismissListener;
    }

    /* renamed from: a */
    public void m964a(View view) {
        this.f1076f = view;
    }

    /* renamed from: a */
    public void m967a(boolean z) {
        this.f1078h = z;
        if (this.f1080j != null) {
            this.f1080j.mo840b(z);
        }
    }

    /* renamed from: a */
    public void m963a(int i) {
        this.f1077g = i;
    }

    /* renamed from: a */
    public void m962a() {
        if (!m970c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: b */
    public AbstractC0110k m969b() {
        if (this.f1080j == null) {
            this.f1080j = m961g();
        }
        return this.f1080j;
    }

    /* renamed from: c */
    public boolean m970c() {
        if (m973f()) {
            return true;
        }
        if (this.f1076f == null) {
            return false;
        }
        m960a(0, 0, false, false);
        return true;
    }

    /* renamed from: a */
    public boolean m968a(int i, int i2) {
        if (m973f()) {
            return true;
        }
        if (this.f1076f == null) {
            return false;
        }
        m960a(i, i2, true, true);
        return true;
    }

    /* renamed from: g */
    private AbstractC0110k m961g() {
        AbstractC0110k viewOnKeyListenerC0116q;
        Display defaultDisplay = ((WindowManager) this.f1071a.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.f60x, point.f61y) >= this.f1071a.getResources().getDimensionPixelSize(C0059a.d.abc_cascading_menus_min_smallest_width)) {
            viewOnKeyListenerC0116q = new ViewOnKeyListenerC0103d(this.f1071a, this.f1076f, this.f1074d, this.f1075e, this.f1073c);
        } else {
            viewOnKeyListenerC0116q = new ViewOnKeyListenerC0116q(this.f1071a, this.f1072b, this.f1076f, this.f1074d, this.f1075e, this.f1073c);
        }
        viewOnKeyListenerC0116q.mo838a(this.f1072b);
        viewOnKeyListenerC0116q.mo837a(this.f1082l);
        viewOnKeyListenerC0116q.mo836a(this.f1076f);
        viewOnKeyListenerC0116q.mo814a(this.f1079i);
        viewOnKeyListenerC0116q.mo840b(this.f1078h);
        viewOnKeyListenerC0116q.mo835a(this.f1077g);
        return viewOnKeyListenerC0116q;
    }

    /* renamed from: a */
    private void m960a(int i, int i2, boolean z, boolean z2) {
        AbstractC0110k m969b = m969b();
        m969b.mo844c(z2);
        if (z) {
            if ((C0289e.m2167a(this.f1077g, C0308x.m2257f(this.f1076f)) & 7) == 5) {
                i -= this.f1076f.getWidth();
            }
            m969b.mo839b(i);
            m969b.mo843c(i2);
            int i3 = (int) ((this.f1071a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            m969b.m958a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        m969b.mo841b_();
    }

    /* renamed from: d */
    public void m971d() {
        if (m973f()) {
            this.f1080j.mo842c();
        }
    }

    /* renamed from: e */
    protected void mo972e() {
        this.f1080j = null;
        if (this.f1081k != null) {
            this.f1081k.onDismiss();
        }
    }

    /* renamed from: f */
    public boolean m973f() {
        return this.f1080j != null && this.f1080j.mo845d();
    }

    /* renamed from: a */
    public void m966a(InterfaceC0112m.a aVar) {
        this.f1079i = aVar;
        if (this.f1080j != null) {
            this.f1080j.mo814a(aVar);
        }
    }
}
