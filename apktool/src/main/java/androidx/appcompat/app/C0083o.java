package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.AbstractC0069a;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.C0089a;
import androidx.appcompat.view.C0095g;
import androidx.appcompat.view.C0096h;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.C0177as;
import androidx.appcompat.widget.InterfaceC0164af;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0280ad;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0279ac;
import androidx.core.p031f.InterfaceC0281ae;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* renamed from: androidx.appcompat.app.o */
/* loaded from: classes.dex */
public class C0083o extends AbstractC0069a implements ActionBarOverlayLayout.InterfaceC0123a {

    /* renamed from: s */
    private static final Interpolator f696s = new AccelerateInterpolator();

    /* renamed from: t */
    private static final Interpolator f697t = new DecelerateInterpolator();

    /* renamed from: B */
    private boolean f699B;

    /* renamed from: D */
    private boolean f701D;

    /* renamed from: F */
    private boolean f703F;

    /* renamed from: a */
    Context f704a;

    /* renamed from: b */
    ActionBarOverlayLayout f705b;

    /* renamed from: c */
    ActionBarContainer f706c;

    /* renamed from: d */
    InterfaceC0164af f707d;

    /* renamed from: e */
    ActionBarContextView f708e;

    /* renamed from: f */
    View f709f;

    /* renamed from: g */
    C0177as f710g;

    /* renamed from: h */
    a f711h;

    /* renamed from: i */
    AbstractC0090b f712i;

    /* renamed from: j */
    AbstractC0090b.a f713j;

    /* renamed from: l */
    boolean f715l;

    /* renamed from: m */
    boolean f716m;

    /* renamed from: n */
    C0096h f717n;

    /* renamed from: o */
    boolean f718o;

    /* renamed from: u */
    private Context f722u;

    /* renamed from: v */
    private Activity f723v;

    /* renamed from: y */
    private boolean f726y;

    /* renamed from: z */
    private boolean f727z;

    /* renamed from: w */
    private ArrayList<Object> f724w = new ArrayList<>();

    /* renamed from: x */
    private int f725x = -1;

    /* renamed from: A */
    private ArrayList<AbstractC0069a.b> f698A = new ArrayList<>();

    /* renamed from: C */
    private int f700C = 0;

    /* renamed from: k */
    boolean f714k = true;

    /* renamed from: E */
    private boolean f702E = true;

    /* renamed from: p */
    final InterfaceC0279ac f719p = new C0280ad() { // from class: androidx.appcompat.app.o.1
        @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
        /* renamed from: b */
        public void mo557b(View view) {
            if (C0083o.this.f714k && C0083o.this.f709f != null) {
                C0083o.this.f709f.setTranslationY(0.0f);
                C0083o.this.f706c.setTranslationY(0.0f);
            }
            C0083o.this.f706c.setVisibility(8);
            C0083o.this.f706c.setTransitioning(false);
            C0083o.this.f717n = null;
            C0083o.this.m644j();
            if (C0083o.this.f705b != null) {
                C0308x.m2267n(C0083o.this.f705b);
            }
        }
    };

    /* renamed from: q */
    final InterfaceC0279ac f720q = new C0280ad() { // from class: androidx.appcompat.app.o.2
        @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
        /* renamed from: b */
        public void mo557b(View view) {
            C0083o.this.f717n = null;
            C0083o.this.f706c.requestLayout();
        }
    };

    /* renamed from: r */
    final InterfaceC0281ae f721r = new InterfaceC0281ae() { // from class: androidx.appcompat.app.o.3
        @Override // androidx.core.p031f.InterfaceC0281ae
        /* renamed from: a */
        public void mo651a(View view) {
            ((View) C0083o.this.f706c.getParent()).invalidate();
        }
    };

    public C0083o(Activity activity, boolean z) {
        this.f723v = activity;
        View decorView = activity.getWindow().getDecorView();
        m631b(decorView);
        if (!z) {
            this.f709f = decorView.findViewById(16908290);
        }
    }

    public C0083o(Dialog dialog) {
        m631b(dialog.getWindow().getDecorView());
    }

    /* renamed from: b */
    private void m631b(View view) {
        this.f705b = (ActionBarOverlayLayout) view.findViewById(C0059a.f.decor_content_parent);
        if (this.f705b != null) {
            this.f705b.setActionBarVisibilityCallback(this);
        }
        this.f707d = m632c(view.findViewById(C0059a.f.action_bar));
        this.f708e = (ActionBarContextView) view.findViewById(C0059a.f.action_context_bar);
        this.f706c = (ActionBarContainer) view.findViewById(C0059a.f.action_bar_container);
        if (this.f707d == null || this.f708e == null || this.f706c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f704a = this.f707d.mo1239b();
        boolean z = (this.f707d.mo1257o() & 4) != 0;
        if (z) {
            this.f726y = true;
        }
        C0089a m738a = C0089a.m738a(this.f704a);
        mo391a(m738a.m744f() || z);
        m633k(m738a.m742d());
        TypedArray obtainStyledAttributes = this.f704a.obtainStyledAttributes(null, C0059a.j.ActionBar, C0059a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0059a.j.ActionBar_hideOnContentScroll, false)) {
            mo396b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0059a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo386a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private InterfaceC0164af m632c(View view) {
        if (view instanceof InterfaceC0164af) {
            return (InterfaceC0164af) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + (view != 0 ? view.getClass().getSimpleName() : "null"));
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo386a(float f2) {
        C0308x.m2226a(this.f706c, f2);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo388a(Configuration configuration) {
        m633k(C0089a.m738a(this.f704a).m742d());
    }

    /* renamed from: k */
    private void m633k(boolean z) {
        this.f699B = z;
        if (!this.f699B) {
            this.f707d.mo1236a((C0177as) null);
            this.f706c.setTabContainer(this.f710g);
        } else {
            this.f706c.setTabContainer(null);
            this.f707d.mo1236a(this.f710g);
        }
        boolean z2 = m646k() == 2;
        if (this.f710g != null) {
            if (z2) {
                this.f710g.setVisibility(0);
                if (this.f705b != null) {
                    C0308x.m2267n(this.f705b);
                }
            } else {
                this.f710g.setVisibility(8);
            }
        }
        this.f707d.mo1238a(!this.f699B && z2);
        this.f705b.setHasNonEmbeddedTabs(!this.f699B && z2);
    }

    /* renamed from: j */
    void m644j() {
        if (this.f713j != null) {
            this.f713j.mo560a(this.f712i);
            this.f712i = null;
            this.f713j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: b */
    public void mo639b(int i) {
        this.f700C = i;
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: d */
    public void mo400d(boolean z) {
        this.f703F = z;
        if (!z && this.f717n != null) {
            this.f717n.m777c();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: e */
    public void mo401e(boolean z) {
        if (z != this.f727z) {
            this.f727z = z;
            int size = this.f698A.size();
            for (int i = 0; i < size; i++) {
                this.f698A.get(i).m407a(z);
            }
        }
    }

    /* renamed from: f */
    public void m640f(boolean z) {
        m638a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo391a(boolean z) {
        this.f707d.mo1242b(z);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo390a(CharSequence charSequence) {
        this.f707d.mo1241b(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: b */
    public void mo395b(CharSequence charSequence) {
        this.f707d.mo1237a(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo387a(int i) {
        if ((i & 4) != 0) {
            this.f726y = true;
        }
        this.f707d.mo1243c(i);
    }

    /* renamed from: a */
    public void m638a(int i, int i2) {
        int mo1257o = this.f707d.mo1257o();
        if ((i2 & 4) != 0) {
            this.f726y = true;
        }
        this.f707d.mo1243c((mo1257o & (i2 ^ (-1))) | (i & i2));
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public View mo384a() {
        return this.f707d.mo1259q();
    }

    /* renamed from: k */
    public int m646k() {
        return this.f707d.mo1258p();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: b */
    public int mo394b() {
        return this.f707d.mo1257o();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public AbstractC0090b mo385a(AbstractC0090b.a aVar) {
        if (this.f711h != null) {
            this.f711h.mo660c();
        }
        this.f705b.setHideOnContentScrollEnabled(false);
        this.f708e.m983c();
        a aVar2 = new a(this.f708e.getContext(), aVar);
        if (!aVar2.m662e()) {
            return null;
        }
        this.f711h = aVar2;
        aVar2.mo661d();
        this.f708e.m980a(aVar2);
        m645j(true);
        this.f708e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: g */
    public void mo641g(boolean z) {
        this.f714k = z;
    }

    /* renamed from: p */
    private void m635p() {
        if (!this.f701D) {
            this.f701D = true;
            if (this.f705b != null) {
                this.f705b.setShowingForActionMode(true);
            }
            m634l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: l */
    public void mo647l() {
        if (this.f716m) {
            this.f716m = false;
            m634l(true);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: c */
    public void mo397c() {
        if (!this.f715l) {
            this.f715l = true;
            m634l(false);
        }
    }

    /* renamed from: q */
    private void m636q() {
        if (this.f701D) {
            this.f701D = false;
            if (this.f705b != null) {
                this.f705b.setShowingForActionMode(false);
            }
            m634l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: m */
    public void mo648m() {
        if (!this.f716m) {
            this.f716m = true;
            m634l(true);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: b */
    public void mo396b(boolean z) {
        if (z && !this.f705b.m1000a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f718o = z;
        this.f705b.setHideOnContentScrollEnabled(z);
    }

    /* renamed from: a */
    static boolean m630a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* renamed from: l */
    private void m634l(boolean z) {
        if (m630a(this.f715l, this.f716m, this.f701D)) {
            if (!this.f702E) {
                this.f702E = true;
                m642h(z);
                return;
            }
            return;
        }
        if (this.f702E) {
            this.f702E = false;
            m643i(z);
        }
    }

    /* renamed from: h */
    public void m642h(boolean z) {
        if (this.f717n != null) {
            this.f717n.m777c();
        }
        this.f706c.setVisibility(0);
        if (this.f700C == 0 && (this.f703F || z)) {
            this.f706c.setTranslationY(0.0f);
            float f2 = -this.f706c.getHeight();
            if (z) {
                this.f706c.getLocationInWindow(new int[]{0, 0});
                f2 -= r1[1];
            }
            this.f706c.setTranslationY(f2);
            C0096h c0096h = new C0096h();
            C0278ab m2063b = C0308x.m2263j(this.f706c).m2063b(0.0f);
            m2063b.m2062a(this.f721r);
            c0096h.m772a(m2063b);
            if (this.f714k && this.f709f != null) {
                this.f709f.setTranslationY(f2);
                c0096h.m772a(C0308x.m2263j(this.f709f).m2063b(0.0f));
            }
            c0096h.m771a(f697t);
            c0096h.m770a(250L);
            c0096h.m774a(this.f720q);
            this.f717n = c0096h;
            c0096h.m775a();
        } else {
            this.f706c.setAlpha(1.0f);
            this.f706c.setTranslationY(0.0f);
            if (this.f714k && this.f709f != null) {
                this.f709f.setTranslationY(0.0f);
            }
            this.f720q.mo557b(null);
        }
        if (this.f705b != null) {
            C0308x.m2267n(this.f705b);
        }
    }

    /* renamed from: i */
    public void m643i(boolean z) {
        if (this.f717n != null) {
            this.f717n.m777c();
        }
        if (this.f700C == 0 && (this.f703F || z)) {
            this.f706c.setAlpha(1.0f);
            this.f706c.setTransitioning(true);
            C0096h c0096h = new C0096h();
            float f2 = -this.f706c.getHeight();
            if (z) {
                this.f706c.getLocationInWindow(new int[]{0, 0});
                f2 -= r2[1];
            }
            C0278ab m2063b = C0308x.m2263j(this.f706c).m2063b(f2);
            m2063b.m2062a(this.f721r);
            c0096h.m772a(m2063b);
            if (this.f714k && this.f709f != null) {
                c0096h.m772a(C0308x.m2263j(this.f709f).m2063b(f2));
            }
            c0096h.m771a(f696s);
            c0096h.m770a(250L);
            c0096h.m774a(this.f719p);
            this.f717n = c0096h;
            c0096h.m775a();
            return;
        }
        this.f719p.mo557b(null);
    }

    /* renamed from: j */
    public void m645j(boolean z) {
        C0278ab mo1229a;
        C0278ab mo979a;
        if (z) {
            m635p();
        } else {
            m636q();
        }
        if (m637r()) {
            if (z) {
                mo979a = this.f707d.mo1229a(4, 100L);
                mo1229a = this.f708e.mo979a(0, 200L);
            } else {
                mo1229a = this.f707d.mo1229a(0, 200L);
                mo979a = this.f708e.mo979a(8, 100L);
            }
            C0096h c0096h = new C0096h();
            c0096h.m773a(mo979a, mo1229a);
            c0096h.m775a();
            return;
        }
        if (z) {
            this.f707d.mo1246d(4);
            this.f708e.setVisibility(0);
        } else {
            this.f707d.mo1246d(0);
            this.f708e.setVisibility(8);
        }
    }

    /* renamed from: r */
    private boolean m637r() {
        return C0308x.m2275v(this.f706c);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: d */
    public Context mo399d() {
        if (this.f722u == null) {
            TypedValue typedValue = new TypedValue();
            this.f704a.getTheme().resolveAttribute(C0059a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f722u = new ContextThemeWrapper(this.f704a, i);
            } else {
                this.f722u = this.f704a;
            }
        }
        return this.f722u;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: n */
    public void mo649n() {
        if (this.f717n != null) {
            this.f717n.m777c();
            this.f717n = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0123a
    /* renamed from: o */
    public void mo650o() {
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: h */
    public boolean mo405h() {
        if (this.f707d == null || !this.f707d.mo1244c()) {
            return false;
        }
        this.f707d.mo1245d();
        return true;
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: androidx.appcompat.app.o$a */
    public class a extends AbstractC0090b implements C0106g.a {

        /* renamed from: b */
        private final Context f732b;

        /* renamed from: c */
        private final C0106g f733c;

        /* renamed from: d */
        private AbstractC0090b.a f734d;

        /* renamed from: e */
        private WeakReference<View> f735e;

        public a(Context context, AbstractC0090b.a aVar) {
            this.f732b = context;
            this.f734d = aVar;
            this.f733c = new C0106g(context).m869a(1);
            this.f733c.mo877a(this);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: a */
        public MenuInflater mo652a() {
            return new C0095g(this.f732b);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: b */
        public Menu mo657b() {
            return this.f733c;
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: c */
        public void mo660c() {
            if (C0083o.this.f711h == this) {
                if (!C0083o.m630a(C0083o.this.f715l, C0083o.this.f716m, false)) {
                    C0083o.this.f712i = this;
                    C0083o.this.f713j = this.f734d;
                } else {
                    this.f734d.mo560a(this);
                }
                this.f734d = null;
                C0083o.this.m645j(false);
                C0083o.this.f708e.m982b();
                C0083o.this.f707d.mo1228a().sendAccessibilityEvent(32);
                C0083o.this.f705b.setHideOnContentScrollEnabled(C0083o.this.f718o);
                C0083o.this.f711h = null;
            }
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: d */
        public void mo661d() {
            if (C0083o.this.f711h == this) {
                this.f733c.m904h();
                try {
                    this.f734d.mo563b(this, this.f733c);
                } finally {
                    this.f733c.m905i();
                }
            }
        }

        /* renamed from: e */
        public boolean m662e() {
            this.f733c.m904h();
            try {
                return this.f734d.mo561a(this, this.f733c);
            } finally {
                this.f733c.m905i();
            }
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: a */
        public void mo654a(View view) {
            C0083o.this.f708e.setCustomView(view);
            this.f735e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: a */
        public void mo655a(CharSequence charSequence) {
            C0083o.this.f708e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: b */
        public void mo659b(CharSequence charSequence) {
            C0083o.this.f708e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: a */
        public void mo653a(int i) {
            mo659b(C0083o.this.f704a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: b */
        public void mo658b(int i) {
            mo655a((CharSequence) C0083o.this.f704a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: f */
        public CharSequence mo663f() {
            return C0083o.this.f708e.getTitle();
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: g */
        public CharSequence mo664g() {
            return C0083o.this.f708e.getSubtitle();
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: a */
        public void mo656a(boolean z) {
            super.mo656a(z);
            C0083o.this.f708e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: h */
        public boolean mo665h() {
            return C0083o.this.f708e.m984d();
        }

        @Override // androidx.appcompat.view.AbstractC0090b
        /* renamed from: i */
        public View mo666i() {
            if (this.f735e != null) {
                return this.f735e.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
            if (this.f734d != null) {
                return this.f734d.mo562a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public void mo529a(C0106g c0106g) {
            if (this.f734d != null) {
                mo661d();
                C0083o.this.f708e.mo981a();
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo389a(View view) {
        this.f707d.mo1233a(view);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: c */
    public void mo398c(boolean z) {
        if (!this.f726y) {
            m640f(z);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public boolean mo392a(int i, KeyEvent keyEvent) {
        Menu mo657b;
        if (this.f711h == null || (mo657b = this.f711h.mo657b()) == null) {
            return false;
        }
        mo657b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return mo657b.performShortcut(i, keyEvent, 0);
    }
}
