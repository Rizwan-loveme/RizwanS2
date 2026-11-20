package androidx.appcompat.view.menu;

import android.C0012R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.widget.C0172an;
import androidx.core.p031f.C0308x;

/* compiled from: StandardMenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.q */
/* loaded from: classes.dex */
final class ViewOnKeyListenerC0116q extends AbstractC0110k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, InterfaceC0112m {

    /* renamed from: e */
    private static final int f1085e = C0059a.g.abc_popup_menu_item_layout;

    /* renamed from: a */
    final C0172an f1086a;

    /* renamed from: c */
    View f1088c;

    /* renamed from: d */
    ViewTreeObserver f1089d;

    /* renamed from: f */
    private final Context f1090f;

    /* renamed from: g */
    private final C0106g f1091g;

    /* renamed from: h */
    private final C0105f f1092h;

    /* renamed from: i */
    private final boolean f1093i;

    /* renamed from: j */
    private final int f1094j;

    /* renamed from: k */
    private final int f1095k;

    /* renamed from: l */
    private final int f1096l;

    /* renamed from: n */
    private PopupWindow.OnDismissListener f1098n;

    /* renamed from: o */
    private View f1099o;

    /* renamed from: p */
    private InterfaceC0112m.a f1100p;

    /* renamed from: q */
    private boolean f1101q;

    /* renamed from: r */
    private boolean f1102r;

    /* renamed from: s */
    private int f1103s;

    /* renamed from: u */
    private boolean f1105u;

    /* renamed from: b */
    final ViewTreeObserver.OnGlobalLayoutListener f1087b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.q.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ViewOnKeyListenerC0116q.this.mo845d() && !ViewOnKeyListenerC0116q.this.f1086a.m1329i()) {
                View view = ViewOnKeyListenerC0116q.this.f1088c;
                if (view == null || !view.isShown()) {
                    ViewOnKeyListenerC0116q.this.mo842c();
                } else {
                    ViewOnKeyListenerC0116q.this.f1086a.mo841b_();
                }
            }
        }
    };

    /* renamed from: m */
    private final View.OnAttachStateChangeListener f1097m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.q.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC0116q.this.f1089d != null) {
                if (!ViewOnKeyListenerC0116q.this.f1089d.isAlive()) {
                    ViewOnKeyListenerC0116q.this.f1089d = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0116q.this.f1089d.removeGlobalOnLayoutListener(ViewOnKeyListenerC0116q.this.f1087b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: t */
    private int f1104t = 0;

    public ViewOnKeyListenerC0116q(Context context, C0106g c0106g, View view, int i, int i2, boolean z) {
        this.f1090f = context;
        this.f1091g = c0106g;
        this.f1093i = z;
        this.f1092h = new C0105f(c0106g, LayoutInflater.from(context), this.f1093i, f1085e);
        this.f1095k = i;
        this.f1096l = i2;
        Resources resources = context.getResources();
        this.f1094j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0059a.d.abc_config_prefDialogWidth));
        this.f1099o = view;
        this.f1086a = new C0172an(this.f1090f, null, this.f1095k, this.f1096l);
        c0106g.m880a(this, context);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: b */
    public void mo840b(boolean z) {
        this.f1092h.m857a(z);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo835a(int i) {
        this.f1104t = i;
    }

    /* renamed from: h */
    private boolean m974h() {
        if (mo845d()) {
            return true;
        }
        if (this.f1101q || this.f1099o == null) {
            return false;
        }
        this.f1088c = this.f1099o;
        this.f1086a.m1315a((PopupWindow.OnDismissListener) this);
        this.f1086a.m1313a((AdapterView.OnItemClickListener) this);
        this.f1086a.m1316a(true);
        View view = this.f1088c;
        boolean z = this.f1089d == null;
        this.f1089d = view.getViewTreeObserver();
        if (z) {
            this.f1089d.addOnGlobalLayoutListener(this.f1087b);
        }
        view.addOnAttachStateChangeListener(this.f1097m);
        this.f1086a.m1320b(view);
        this.f1086a.m1325f(this.f1104t);
        if (!this.f1102r) {
            this.f1103s = m955a(this.f1092h, null, this.f1090f, this.f1094j);
            this.f1102r = true;
        }
        this.f1086a.m1327h(this.f1103s);
        this.f1086a.m1328i(2);
        this.f1086a.m1311a(m959g());
        this.f1086a.mo841b_();
        ListView e2 = this.f1086a.mo846e();
        e2.setOnKeyListener(this);
        if (this.f1105u && this.f1091g.m910n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1090f).inflate(C0059a.g.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(C0012R.id.title);
            if (textView != null) {
                textView.setText(this.f1091g.m910n());
            }
            frameLayout.setEnabled(false);
            e2.addHeaderView(frameLayout, null, false);
        }
        this.f1086a.mo1314a((ListAdapter) this.f1092h);
        this.f1086a.mo841b_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: b_ */
    public void mo841b_() {
        if (!m974h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: c */
    public void mo842c() {
        if (mo845d()) {
            this.f1086a.mo842c();
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo838a(C0106g c0106g) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: d */
    public boolean mo845d() {
        return !this.f1101q && this.f1086a.mo845d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1101q = true;
        this.f1091g.close();
        if (this.f1089d != null) {
            if (!this.f1089d.isAlive()) {
                this.f1089d = this.f1088c.getViewTreeObserver();
            }
            this.f1089d.removeGlobalOnLayoutListener(this.f1087b);
            this.f1089d = null;
        }
        this.f1088c.removeOnAttachStateChangeListener(this.f1097m);
        if (this.f1098n != null) {
            this.f1098n.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo815a(boolean z) {
        this.f1102r = false;
        if (this.f1092h != null) {
            this.f1092h.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo814a(InterfaceC0112m.a aVar) {
        this.f1100p = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo819a(SubMenuC0117r subMenuC0117r) {
        if (subMenuC0117r.hasVisibleItems()) {
            C0111l c0111l = new C0111l(this.f1090f, subMenuC0117r, this.f1088c, this.f1093i, this.f1095k, this.f1096l);
            c0111l.m966a(this.f1100p);
            c0111l.m967a(AbstractC0110k.m957b(subMenuC0117r));
            c0111l.m965a(this.f1098n);
            this.f1098n = null;
            this.f1091g.m882a(false);
            int f2 = this.f1086a.m1324f();
            int a_ = this.f1086a.m1317a_();
            if ((Gravity.getAbsoluteGravity(this.f1104t, C0308x.m2257f(this.f1099o)) & 7) == 5) {
                f2 += this.f1099o.getWidth();
            }
            if (c0111l.m968a(f2, a_)) {
                if (this.f1100p != null) {
                    this.f1100p.mo559a(subMenuC0117r);
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo812a(C0106g c0106g, boolean z) {
        if (c0106g == this.f1091g) {
            mo842c();
            if (this.f1100p != null) {
                this.f1100p.mo558a(c0106g, z);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo821b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo836a(View view) {
        this.f1099o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo842c();
        return true;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo837a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1098n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: e */
    public ListView mo846e() {
        return this.f1086a.mo846e();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: b */
    public void mo839b(int i) {
        this.f1086a.m1319b(i);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: c */
    public void mo843c(int i) {
        this.f1086a.m1310a(i);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: c */
    public void mo844c(boolean z) {
        this.f1105u = z;
    }
}
