package androidx.appcompat.app;

import android.C0012R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.LocaleList;
import android.p008os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.C0092d;
import androidx.appcompat.view.C0093e;
import androidx.appcompat.view.C0094f;
import androidx.appcompat.view.C0095g;
import androidx.appcompat.view.WindowCallbackC0097i;
import androidx.appcompat.view.menu.C0104e;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0184az;
import androidx.appcompat.widget.C0190be;
import androidx.appcompat.widget.C0191bf;
import androidx.appcompat.widget.C0201k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC0163ae;
import androidx.appcompat.widget.InterfaceC0167ai;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.app.C0230a;
import androidx.core.app.C0235f;
import androidx.core.content.C0255a;
import androidx.core.content.p028a.C0261f;
import androidx.core.p030e.C0268c;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0280ad;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.C0290f;
import androidx.core.p031f.C0291g;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0279ac;
import androidx.core.p031f.InterfaceC0302r;
import androidx.core.widget.C0338h;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.p011a.C0042g;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: androidx.appcompat.app.f */
/* loaded from: classes.dex */
class LayoutInflaterFactory2C0074f extends AbstractC0073e implements LayoutInflater.Factory2, C0106g.a {

    /* renamed from: u */
    private static final C0042g<String, Integer> f555u = new C0042g<>();

    /* renamed from: v */
    private static final boolean f556v;

    /* renamed from: w */
    private static final int[] f557w;

    /* renamed from: x */
    private static final boolean f558x;

    /* renamed from: y */
    private static final boolean f559y;

    /* renamed from: z */
    private static boolean f560z;

    /* renamed from: A */
    private g f561A;

    /* renamed from: B */
    private CharSequence f562B;

    /* renamed from: C */
    private InterfaceC0163ae f563C;

    /* renamed from: D */
    private a f564D;

    /* renamed from: E */
    private n f565E;

    /* renamed from: F */
    private boolean f566F;

    /* renamed from: G */
    private boolean f567G;

    /* renamed from: H */
    private TextView f568H;

    /* renamed from: I */
    private View f569I;

    /* renamed from: J */
    private boolean f570J;

    /* renamed from: K */
    private boolean f571K;

    /* renamed from: L */
    private boolean f572L;

    /* renamed from: M */
    private m[] f573M;

    /* renamed from: N */
    private m f574N;

    /* renamed from: O */
    private boolean f575O;

    /* renamed from: P */
    private boolean f576P;

    /* renamed from: Q */
    private boolean f577Q;

    /* renamed from: R */
    private boolean f578R;

    /* renamed from: S */
    private int f579S;

    /* renamed from: T */
    private int f580T;

    /* renamed from: U */
    private boolean f581U;

    /* renamed from: V */
    private boolean f582V;

    /* renamed from: W */
    private i f583W;

    /* renamed from: X */
    private i f584X;

    /* renamed from: Y */
    private final Runnable f585Y;

    /* renamed from: Z */
    private boolean f586Z;

    /* renamed from: a */
    final Object f587a;

    /* renamed from: aa */
    private Rect f588aa;

    /* renamed from: ab */
    private Rect f589ab;

    /* renamed from: ac */
    private C0077i f590ac;

    /* renamed from: ad */
    private C0078j f591ad;

    /* renamed from: b */
    final Context f592b;

    /* renamed from: c */
    Window f593c;

    /* renamed from: d */
    final InterfaceC0072d f594d;

    /* renamed from: e */
    AbstractC0069a f595e;

    /* renamed from: f */
    MenuInflater f596f;

    /* renamed from: g */
    AbstractC0090b f597g;

    /* renamed from: h */
    ActionBarContextView f598h;

    /* renamed from: i */
    PopupWindow f599i;

    /* renamed from: j */
    Runnable f600j;

    /* renamed from: k */
    C0278ab f601k;

    /* renamed from: l */
    ViewGroup f602l;

    /* renamed from: m */
    boolean f603m;

    /* renamed from: n */
    boolean f604n;

    /* renamed from: o */
    boolean f605o;

    /* renamed from: p */
    boolean f606p;

    /* renamed from: q */
    boolean f607q;

    /* renamed from: r */
    boolean f608r;

    /* renamed from: s */
    boolean f609s;

    /* renamed from: t */
    int f610t;

    static {
        f556v = Build.VERSION.SDK_INT < 21;
        f557w = new int[]{C0012R.attr.windowBackground};
        f558x = !"robolectric".equals(Build.FINGERPRINT);
        f559y = Build.VERSION.SDK_INT >= 17;
        if (f556v && !f560z) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.f.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (m551a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        Thread.UncaughtExceptionHandler.this.uncaughtException(thread, notFoundException);
                        return;
                    }
                    Thread.UncaughtExceptionHandler.this.uncaughtException(thread, th);
                }

                /* renamed from: a */
                private boolean m551a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }
            });
            f560z = true;
        }
    }

    LayoutInflaterFactory2C0074f(Activity activity, InterfaceC0072d interfaceC0072d) {
        this(activity, null, interfaceC0072d, activity);
    }

    LayoutInflaterFactory2C0074f(Dialog dialog, InterfaceC0072d interfaceC0072d) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0072d, dialog);
    }

    private LayoutInflaterFactory2C0074f(Context context, Window window, InterfaceC0072d interfaceC0072d, Object obj) {
        Integer num;
        ActivityC0071c m490A;
        this.f601k = null;
        this.f566F = true;
        this.f579S = -100;
        this.f585Y = new Runnable() { // from class: androidx.appcompat.app.f.2
            @Override // java.lang.Runnable
            public void run() {
                if ((LayoutInflaterFactory2C0074f.this.f610t & 1) != 0) {
                    LayoutInflaterFactory2C0074f.this.m540h(0);
                }
                if ((LayoutInflaterFactory2C0074f.this.f610t & 4096) != 0) {
                    LayoutInflaterFactory2C0074f.this.m540h(108);
                }
                LayoutInflaterFactory2C0074f.this.f609s = false;
                LayoutInflaterFactory2C0074f.this.f610t = 0;
            }
        };
        this.f592b = context;
        this.f594d = interfaceC0072d;
        this.f587a = obj;
        if (this.f579S == -100 && (this.f587a instanceof Dialog) && (m490A = m490A()) != null) {
            this.f579S = m490A.m459k().mo489i();
        }
        if (this.f579S == -100 && (num = f555u.get(this.f587a.getClass().getName())) != null) {
            this.f579S = num.intValue();
            f555u.remove(this.f587a.getClass().getName());
        }
        if (window != null) {
            m497a(window);
        }
        C0201k.m1543a();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:24|(2:26|(8:28|29|30|31|(1:33)(1:38)|(1:35)|36|37))|42|29|30|31|(0)(0)|(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Context mo475b(Context context) {
        Configuration configuration;
        boolean z;
        this.f576P = true;
        int m521a = m521a(context, m492C());
        if (f559y && (context instanceof ContextThemeWrapper)) {
            try {
                k.m575a((ContextThemeWrapper) context, m494a(context, m521a, (Configuration) null));
                return context;
            } catch (IllegalStateException e2) {
            }
        }
        if (context instanceof C0092d) {
            try {
                ((C0092d) context).m754a(m494a(context, m521a, (Configuration) null));
                return context;
            } catch (IllegalStateException e3) {
            }
        }
        if (!f558x) {
            return super.mo475b(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = c.m564a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = m495a(configuration3, configuration4);
                Configuration m494a = m494a(context, m521a, configuration);
                C0092d c0092d = new C0092d(context, C0059a.i.Theme_AppCompat_Empty);
                c0092d.m754a(m494a);
                z = context.getTheme() == null;
                if (z) {
                    C0261f.d.m1921a(c0092d.getTheme());
                }
                return super.mo475b(c0092d);
            }
        }
        configuration = null;
        Configuration m494a2 = m494a(context, m521a, configuration);
        C0092d c0092d2 = new C0092d(context, C0059a.i.Theme_AppCompat_Empty);
        c0092d2.m754a(m494a2);
        if (context.getTheme() == null) {
        }
        if (z) {
        }
        return super.mo475b(c0092d2);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$k */
    private static class k {
        /* renamed from: a */
        static void m575a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public void mo471a(Bundle bundle) {
        String str;
        this.f576P = true;
        m507b(false);
        m517w();
        if (this.f587a instanceof Activity) {
            try {
                str = C0235f.m1702b((Activity) this.f587a);
            } catch (IllegalArgumentException e2) {
                str = null;
            }
            if (str != null) {
                AbstractC0069a m541k = m541k();
                if (m541k == null) {
                    this.f586Z = true;
                } else {
                    m541k.mo398c(true);
                }
            }
            m462a(this);
        }
        this.f577Q = true;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: b */
    public void mo478b(Bundle bundle) {
        m518x();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public AbstractC0069a mo466a() {
        m515u();
        return this.f595e;
    }

    /* renamed from: k */
    final AbstractC0069a m541k() {
        return this.f595e;
    }

    /* renamed from: l */
    final Window.Callback m542l() {
        return this.f593c.getCallback();
    }

    /* renamed from: u */
    private void m515u() {
        m518x();
        if (this.f603m && this.f595e == null) {
            if (this.f587a instanceof Activity) {
                this.f595e = new C0083o((Activity) this.f587a, this.f604n);
            } else if (this.f587a instanceof Dialog) {
                this.f595e = new C0083o((Dialog) this.f587a);
            }
            if (this.f595e != null) {
                this.f595e.mo398c(this.f586Z);
            }
        }
    }

    /* renamed from: m */
    final Context m543m() {
        Context context = null;
        AbstractC0069a mo466a = mo466a();
        if (mo466a != null) {
            context = mo466a.mo399d();
        }
        if (context == null) {
            return this.f592b;
        }
        return context;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: b */
    public MenuInflater mo476b() {
        if (this.f596f == null) {
            m515u();
            this.f596f = new C0095g(this.f595e != null ? this.f595e.mo399d() : this.f592b);
        }
        return this.f596f;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: b */
    public <T extends View> T mo477b(int i2) {
        m518x();
        return (T) this.f593c.findViewById(i2);
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public void mo470a(Configuration configuration) {
        AbstractC0069a mo466a;
        if (this.f603m && this.f567G && (mo466a = mo466a()) != null) {
            mo466a.mo388a(configuration);
        }
        C0201k.m1545b().m1549a(this.f592b);
        m507b(false);
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: c */
    public void mo480c() {
        this.f578R = true;
        m550t();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: d */
    public void mo483d() {
        this.f578R = false;
        AbstractC0069a mo466a = mo466a();
        if (mo466a != null) {
            mo466a.mo400d(false);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: e */
    public void mo485e() {
        AbstractC0069a mo466a = mo466a();
        if (mo466a != null) {
            mo466a.mo400d(true);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public void mo472a(View view) {
        m518x();
        ViewGroup viewGroup = (ViewGroup) this.f602l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f561A.m779a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: c */
    public void mo481c(int i2) {
        m518x();
        ViewGroup viewGroup = (ViewGroup) this.f602l.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f592b).inflate(i2, viewGroup);
        this.f561A.m779a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public void mo473a(View view, ViewGroup.LayoutParams layoutParams) {
        m518x();
        ViewGroup viewGroup = (ViewGroup) this.f602l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f561A.m779a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: b */
    public void mo479b(View view, ViewGroup.LayoutParams layoutParams) {
        m518x();
        ((ViewGroup) this.f602l.findViewById(16908290)).addView(view, layoutParams);
        this.f561A.m779a().onContentChanged();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: c */
    public void mo482c(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: g */
    public void mo487g() {
        if (this.f587a instanceof Activity) {
            m463b(this);
        }
        if (this.f609s) {
            this.f593c.getDecorView().removeCallbacks(this.f585Y);
        }
        this.f578R = false;
        this.f608r = true;
        if (this.f579S != -100 && (this.f587a instanceof Activity) && ((Activity) this.f587a).isChangingConfigurations()) {
            f555u.put(this.f587a.getClass().getName(), Integer.valueOf(this.f579S));
        } else {
            f555u.remove(this.f587a.getClass().getName());
        }
        if (this.f595e != null) {
            this.f595e.mo406i();
        }
        m516v();
    }

    /* renamed from: v */
    private void m516v() {
        if (this.f583W != null) {
            this.f583W.m574e();
        }
        if (this.f584X != null) {
            this.f584X.m574e();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public void mo468a(int i2) {
        this.f580T = i2;
    }

    /* renamed from: w */
    private void m517w() {
        if (this.f593c == null && (this.f587a instanceof Activity)) {
            m497a(((Activity) this.f587a).getWindow());
        }
        if (this.f593c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* renamed from: a */
    private void m497a(Window window) {
        if (this.f593c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof g) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f561A = new g(callback);
        window.setCallback(this.f561A);
        C0184az m1431a = C0184az.m1431a(this.f592b, (AttributeSet) null, f557w);
        Drawable m1440b = m1431a.m1440b(0);
        if (m1440b != null) {
            window.setBackgroundDrawable(m1440b);
        }
        m1431a.m1441b();
        this.f593c = window;
    }

    /* renamed from: x */
    private void m518x() {
        if (!this.f567G) {
            this.f602l = m519y();
            CharSequence m544n = m544n();
            if (!TextUtils.isEmpty(m544n)) {
                if (this.f563C != null) {
                    this.f563C.setWindowTitle(m544n);
                } else if (m541k() != null) {
                    m541k().mo395b(m544n);
                } else if (this.f568H != null) {
                    this.f568H.setText(m544n);
                }
            }
            m520z();
            m527a(this.f602l);
            this.f567G = true;
            m m524a = m524a(0, false);
            if (this.f608r) {
                return;
            }
            if (m524a == null || m524a.f641j == null) {
                m513i(108);
            }
        }
    }

    /* renamed from: y */
    private ViewGroup m519y() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f592b.obtainStyledAttributes(C0059a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(C0059a.j.AppCompatTheme_windowNoTitle, false)) {
            mo484d(1);
        } else if (obtainStyledAttributes.getBoolean(C0059a.j.AppCompatTheme_windowActionBar, false)) {
            mo484d(108);
        }
        if (obtainStyledAttributes.getBoolean(C0059a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            mo484d(109);
        }
        if (obtainStyledAttributes.getBoolean(C0059a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            mo484d(10);
        }
        this.f606p = obtainStyledAttributes.getBoolean(C0059a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        m517w();
        this.f593c.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f592b);
        if (!this.f607q) {
            if (this.f606p) {
                ViewGroup viewGroup2 = (ViewGroup) from.inflate(C0059a.g.abc_dialog_title_material, (ViewGroup) null);
                this.f604n = false;
                this.f603m = false;
                viewGroup = viewGroup2;
            } else if (this.f603m) {
                TypedValue typedValue = new TypedValue();
                this.f592b.getTheme().resolveAttribute(C0059a.a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new C0092d(this.f592b, typedValue.resourceId);
                } else {
                    context = this.f592b;
                }
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(C0059a.g.abc_screen_toolbar, (ViewGroup) null);
                this.f563C = (InterfaceC0163ae) viewGroup3.findViewById(C0059a.f.decor_content_parent);
                this.f563C.setWindowCallback(m542l());
                if (this.f604n) {
                    this.f563C.mo994a(109);
                }
                if (this.f570J) {
                    this.f563C.mo994a(2);
                }
                if (this.f571K) {
                    this.f563C.mo994a(5);
                }
                viewGroup = viewGroup3;
            } else {
                viewGroup = null;
            }
        } else if (this.f605o) {
            viewGroup = (ViewGroup) from.inflate(C0059a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
        } else {
            viewGroup = (ViewGroup) from.inflate(C0059a.g.abc_screen_simple, (ViewGroup) null);
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f603m + ", windowActionBarOverlay: " + this.f604n + ", android:windowIsFloating: " + this.f606p + ", windowActionModeOverlay: " + this.f605o + ", windowNoTitle: " + this.f607q + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            C0308x.m2237a(viewGroup, new InterfaceC0302r() { // from class: androidx.appcompat.app.f.3
                @Override // androidx.core.p031f.InterfaceC0302r
                /* renamed from: a */
                public C0282af mo552a(View view, C0282af c0282af) {
                    int m2077b = c0282af.m2077b();
                    int m522a = LayoutInflaterFactory2C0074f.this.m522a(c0282af, (Rect) null);
                    if (m2077b != m522a) {
                        c0282af = c0282af.m2071a(c0282af.m2070a(), m522a, c0282af.m2080c(), c0282af.m2081d());
                    }
                    return C0308x.m2222a(view, c0282af);
                }
            });
        } else if (viewGroup instanceof InterfaceC0167ai) {
            ((InterfaceC0167ai) viewGroup).setOnFitSystemWindowsListener(new InterfaceC0167ai.a() { // from class: androidx.appcompat.app.f.4
                @Override // androidx.appcompat.widget.InterfaceC0167ai.a
                /* renamed from: a */
                public void mo553a(Rect rect) {
                    rect.top = LayoutInflaterFactory2C0074f.this.m522a((C0282af) null, rect);
                }
            });
        }
        if (this.f563C == null) {
            this.f568H = (TextView) viewGroup.findViewById(C0059a.f.title);
        }
        C0191bf.m1482b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0059a.f.action_bar_activity_content);
        ViewGroup viewGroup4 = (ViewGroup) this.f593c.findViewById(16908290);
        if (viewGroup4 != null) {
            while (viewGroup4.getChildCount() > 0) {
                View childAt = viewGroup4.getChildAt(0);
                viewGroup4.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup4.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup4 instanceof FrameLayout) {
                ((FrameLayout) viewGroup4).setForeground(null);
            }
        }
        this.f593c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.InterfaceC0132a() { // from class: androidx.appcompat.app.f.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0132a
            /* renamed from: a */
            public void mo554a() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0132a
            /* renamed from: b */
            public void mo555b() {
                LayoutInflaterFactory2C0074f.this.m549s();
            }
        });
        return viewGroup;
    }

    /* renamed from: a */
    void m527a(ViewGroup viewGroup) {
    }

    /* renamed from: z */
    private void m520z() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f602l.findViewById(16908290);
        View decorView = this.f593c.getDecorView();
        contentFrameLayout.m1052a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f592b.obtainStyledAttributes(C0059a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0059a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: d */
    public boolean mo484d(int i2) {
        int m514j = m514j(i2);
        if (this.f607q && m514j == 108) {
            return false;
        }
        if (this.f603m && m514j == 1) {
            this.f603m = false;
        }
        switch (m514j) {
            case 1:
                m491B();
                this.f607q = true;
                return true;
            case 2:
                m491B();
                this.f570J = true;
                return true;
            case 5:
                m491B();
                this.f571K = true;
                return true;
            case 10:
                m491B();
                this.f605o = true;
                return true;
            case 108:
                m491B();
                this.f603m = true;
                return true;
            case 109:
                m491B();
                this.f604n = true;
                return true;
            default:
                return this.f593c.requestFeature(m514j);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public final void mo474a(CharSequence charSequence) {
        this.f562B = charSequence;
        if (this.f563C != null) {
            this.f563C.setWindowTitle(charSequence);
        } else if (m541k() != null) {
            m541k().mo395b(charSequence);
        } else if (this.f568H != null) {
            this.f568H.setText(charSequence);
        }
    }

    /* renamed from: n */
    final CharSequence m544n() {
        return this.f587a instanceof Activity ? ((Activity) this.f587a).getTitle() : this.f562B;
    }

    /* renamed from: e */
    void m537e(int i2) {
        if (i2 == 108) {
            AbstractC0069a mo466a = mo466a();
            if (mo466a != null) {
                mo466a.mo401e(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            m m524a = m524a(i2, true);
            if (m524a.f646o) {
                m528a(m524a, false);
            }
        }
    }

    /* renamed from: f */
    void m538f(int i2) {
        AbstractC0069a mo466a;
        if (i2 == 108 && (mo466a = mo466a()) != null) {
            mo466a.mo401e(true);
        }
    }

    @Override // androidx.appcompat.view.menu.C0106g.a
    /* renamed from: a */
    public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
        m m525a;
        Window.Callback m542l = m542l();
        if (m542l == null || this.f608r || (m525a = m525a((Menu) c0106g.mo913q())) == null) {
            return false;
        }
        return m542l.onMenuItemSelected(m525a.f632a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.C0106g.a
    /* renamed from: a */
    public void mo529a(C0106g c0106g) {
        m499a(true);
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: a */
    public AbstractC0090b mo467a(AbstractC0090b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f597g != null) {
            this.f597g.mo660c();
        }
        b bVar = new b(aVar);
        AbstractC0069a mo466a = mo466a();
        if (mo466a != null) {
            this.f597g = mo466a.mo385a(bVar);
            if (this.f597g != null && this.f594d != null) {
                this.f594d.mo446a(this.f597g);
            }
        }
        if (this.f597g == null) {
            this.f597g = m533b(bVar);
        }
        return this.f597g;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: f */
    public void mo486f() {
        AbstractC0069a mo466a = mo466a();
        if (mo466a == null || !mo466a.mo404g()) {
            m513i(0);
        }
    }

    /* renamed from: b */
    AbstractC0090b m533b(AbstractC0090b.a aVar) {
        AbstractC0090b abstractC0090b;
        Context context;
        m547q();
        if (this.f597g != null) {
            this.f597g.mo660c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (this.f594d == null || this.f608r) {
            abstractC0090b = null;
        } else {
            try {
                abstractC0090b = this.f594d.mo445a(aVar);
            } catch (AbstractMethodError e2) {
                abstractC0090b = null;
            }
        }
        if (abstractC0090b != null) {
            this.f597g = abstractC0090b;
        } else {
            if (this.f598h == null) {
                if (this.f606p) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f592b.getTheme();
                    theme.resolveAttribute(C0059a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.f592b.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        context = new C0092d(this.f592b, 0);
                        context.getTheme().setTo(newTheme);
                    } else {
                        context = this.f592b;
                    }
                    this.f598h = new ActionBarContextView(context);
                    this.f599i = new PopupWindow(context, (AttributeSet) null, C0059a.a.actionModePopupWindowStyle);
                    C0338h.m2506a(this.f599i, 2);
                    this.f599i.setContentView(this.f598h);
                    this.f599i.setWidth(-1);
                    context.getTheme().resolveAttribute(C0059a.a.actionBarSize, typedValue, true);
                    this.f598h.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.f599i.setHeight(-2);
                    this.f600j = new Runnable() { // from class: androidx.appcompat.app.f.6
                        @Override // java.lang.Runnable
                        public void run() {
                            LayoutInflaterFactory2C0074f.this.f599i.showAtLocation(LayoutInflaterFactory2C0074f.this.f598h, 55, 0, 0);
                            LayoutInflaterFactory2C0074f.this.m547q();
                            if (LayoutInflaterFactory2C0074f.this.m545o()) {
                                LayoutInflaterFactory2C0074f.this.f598h.setAlpha(0.0f);
                                LayoutInflaterFactory2C0074f.this.f601k = C0308x.m2263j(LayoutInflaterFactory2C0074f.this.f598h).m2058a(1.0f);
                                LayoutInflaterFactory2C0074f.this.f601k.m2061a(new C0280ad() { // from class: androidx.appcompat.app.f.6.1
                                    @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
                                    /* renamed from: a */
                                    public void mo556a(View view) {
                                        LayoutInflaterFactory2C0074f.this.f598h.setVisibility(0);
                                    }

                                    @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
                                    /* renamed from: b */
                                    public void mo557b(View view) {
                                        LayoutInflaterFactory2C0074f.this.f598h.setAlpha(1.0f);
                                        LayoutInflaterFactory2C0074f.this.f601k.m2061a((InterfaceC0279ac) null);
                                        LayoutInflaterFactory2C0074f.this.f601k = null;
                                    }
                                });
                                return;
                            }
                            LayoutInflaterFactory2C0074f.this.f598h.setAlpha(1.0f);
                            LayoutInflaterFactory2C0074f.this.f598h.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f602l.findViewById(C0059a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m543m()));
                        this.f598h = (ActionBarContextView) viewStubCompat.m1154a();
                    }
                }
            }
            if (this.f598h != null) {
                m547q();
                this.f598h.m983c();
                C0093e c0093e = new C0093e(this.f598h.getContext(), this.f598h, aVar, this.f599i == null);
                if (aVar.mo561a(c0093e, c0093e.mo657b())) {
                    c0093e.mo661d();
                    this.f598h.m980a(c0093e);
                    this.f597g = c0093e;
                    if (m545o()) {
                        this.f598h.setAlpha(0.0f);
                        this.f601k = C0308x.m2263j(this.f598h).m2058a(1.0f);
                        this.f601k.m2061a(new C0280ad() { // from class: androidx.appcompat.app.f.7
                            @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
                            /* renamed from: a */
                            public void mo556a(View view) {
                                LayoutInflaterFactory2C0074f.this.f598h.setVisibility(0);
                                LayoutInflaterFactory2C0074f.this.f598h.sendAccessibilityEvent(32);
                                if (LayoutInflaterFactory2C0074f.this.f598h.getParent() instanceof View) {
                                    C0308x.m2267n((View) LayoutInflaterFactory2C0074f.this.f598h.getParent());
                                }
                            }

                            @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
                            /* renamed from: b */
                            public void mo557b(View view) {
                                LayoutInflaterFactory2C0074f.this.f598h.setAlpha(1.0f);
                                LayoutInflaterFactory2C0074f.this.f601k.m2061a((InterfaceC0279ac) null);
                                LayoutInflaterFactory2C0074f.this.f601k = null;
                            }
                        });
                    } else {
                        this.f598h.setAlpha(1.0f);
                        this.f598h.setVisibility(0);
                        this.f598h.sendAccessibilityEvent(32);
                        if (this.f598h.getParent() instanceof View) {
                            C0308x.m2267n((View) this.f598h.getParent());
                        }
                    }
                    if (this.f599i != null) {
                        this.f593c.getDecorView().post(this.f600j);
                    }
                } else {
                    this.f597g = null;
                }
            }
        }
        if (this.f597g != null && this.f594d != null) {
            this.f594d.mo446a(this.f597g);
        }
        return this.f597g;
    }

    /* renamed from: o */
    final boolean m545o() {
        return this.f567G && this.f602l != null && C0308x.m2275v(this.f602l);
    }

    /* renamed from: p */
    public boolean m546p() {
        return this.f566F;
    }

    /* renamed from: q */
    void m547q() {
        if (this.f601k != null) {
            this.f601k.m2065b();
        }
    }

    /* renamed from: r */
    boolean m548r() {
        if (this.f597g != null) {
            this.f597g.mo660c();
            return true;
        }
        AbstractC0069a mo466a = mo466a();
        return mo466a != null && mo466a.mo405h();
    }

    /* renamed from: a */
    boolean m530a(int i2, KeyEvent keyEvent) {
        AbstractC0069a mo466a = mo466a();
        if (mo466a != null && mo466a.mo392a(i2, keyEvent)) {
            return true;
        }
        if (this.f574N != null && m502a(this.f574N, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f574N == null) {
                return true;
            }
            this.f574N.f645n = true;
            return true;
        }
        if (this.f574N == null) {
            m m524a = m524a(0, true);
            m506b(m524a, keyEvent);
            boolean m502a = m502a(m524a, keyEvent.getKeyCode(), keyEvent, 1);
            m524a.f644m = false;
            if (m502a) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    boolean m531a(KeyEvent keyEvent) {
        View decorView;
        if (((this.f587a instanceof C0290f.a) || (this.f587a instanceof DialogC0075g)) && (decorView = this.f593c.getDecorView()) != null && C0290f.m2172a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f561A.m779a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m536c(keyCode, keyEvent) : m535b(keyCode, keyEvent);
    }

    /* renamed from: b */
    boolean m535b(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 4:
                boolean z = this.f575O;
                this.f575O = false;
                m m524a = m524a(0, false);
                if (m524a != null && m524a.f646o) {
                    if (z) {
                        return true;
                    }
                    m528a(m524a, true);
                    return true;
                }
                if (m548r()) {
                    return true;
                }
                break;
            case 82:
                m512e(0, keyEvent);
                return true;
        }
        return false;
    }

    /* renamed from: c */
    boolean m536c(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 4:
                this.f575O = (keyEvent.getFlags() & 128) != 0;
                break;
            case 82:
                m511d(0, keyEvent);
                return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public View m523a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean m500a;
        if (this.f590ac == null) {
            String string = this.f592b.obtainStyledAttributes(C0059a.j.AppCompatTheme).getString(C0059a.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f590ac = new C0077i();
            } else {
                try {
                    this.f590ac = (C0077i) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.m187i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f590ac = new C0077i();
                }
            }
        }
        if (f556v) {
            if (this.f591ad == null) {
                this.f591ad = new C0078j();
            }
            if (this.f591ad.m613a(attributeSet)) {
                z = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    m500a = ((XmlPullParser) attributeSet).getDepth() > 1;
                } else {
                    m500a = m500a((ViewParent) view);
                }
                z = m500a;
            }
        } else {
            z = false;
        }
        return this.f590ac.m594a(view, str, context, attributeSet, z, f556v, true, C0190be.m1477a());
    }

    /* renamed from: a */
    private boolean m500a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f593c.getDecorView();
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || C0308x.m2276w((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: h */
    public void mo488h() {
        LayoutInflater from = LayoutInflater.from(this.f592b);
        if (from.getFactory() == null) {
            C0291g.m2174a(from, this);
        } else if (!(from.getFactory2() instanceof LayoutInflaterFactory2C0074f)) {
            Log.m186i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m523a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* renamed from: A */
    private ActivityC0071c m490A() {
        for (Context context = this.f592b; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof ActivityC0071c) {
                return (ActivityC0071c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m498a(m mVar, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i2 = -1;
        if (!mVar.f646o && !this.f608r) {
            if (mVar.f632a == 0) {
                if ((this.f592b.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback m542l = m542l();
            if (m542l != null && !m542l.onMenuOpened(mVar.f632a, mVar.f641j)) {
                m528a(mVar, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.f592b.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null && m506b(mVar, keyEvent)) {
                if (mVar.f638g == null || mVar.f648q) {
                    if (mVar.f638g == null) {
                        if (!m501a(mVar) || mVar.f638g == null) {
                            return;
                        }
                    } else if (mVar.f648q && mVar.f638g.getChildCount() > 0) {
                        mVar.f638g.removeAllViews();
                    }
                    if (!m509c(mVar) || !mVar.m580a()) {
                        mVar.f648q = true;
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams2 = mVar.f639h.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                    mVar.f638g.setBackgroundResource(mVar.f633b);
                    ViewParent parent = mVar.f639h.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(mVar.f639h);
                    }
                    mVar.f638g.addView(mVar.f639h, layoutParams3);
                    if (!mVar.f639h.hasFocus()) {
                        mVar.f639h.requestFocus();
                    }
                    i2 = -2;
                } else if (mVar.f640i == null || (layoutParams = mVar.f640i.getLayoutParams()) == null || layoutParams.width != -1) {
                    i2 = -2;
                }
                mVar.f645n = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i2, -2, mVar.f635d, mVar.f636e, 1002, 8519680, -3);
                layoutParams4.gravity = mVar.f634c;
                layoutParams4.windowAnimations = mVar.f637f;
                windowManager.addView(mVar.f638g, layoutParams4);
                mVar.f646o = true;
            }
        }
    }

    /* renamed from: a */
    private boolean m501a(m mVar) {
        mVar.m578a(m543m());
        mVar.f638g = new l(mVar.f643l);
        mVar.f634c = 81;
        return true;
    }

    /* renamed from: a */
    private void m499a(boolean z) {
        if (this.f563C != null && this.f563C.mo1006e() && (!ViewConfiguration.get(this.f592b).hasPermanentMenuKey() || this.f563C.mo1008g())) {
            Window.Callback m542l = m542l();
            if (!this.f563C.mo1007f() || !z) {
                if (m542l != null && !this.f608r) {
                    if (this.f609s && (this.f610t & 1) != 0) {
                        this.f593c.getDecorView().removeCallbacks(this.f585Y);
                        this.f585Y.run();
                    }
                    m m524a = m524a(0, true);
                    if (m524a.f641j != null && !m524a.f649r && m542l.onPreparePanel(0, m524a.f640i, m524a.f641j)) {
                        m542l.onMenuOpened(108, m524a.f641j);
                        this.f563C.mo1009h();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f563C.mo1010i();
            if (!this.f608r) {
                m542l.onPanelClosed(108, m524a(0, true).f641j);
                return;
            }
            return;
        }
        m m524a2 = m524a(0, true);
        m524a2.f648q = true;
        m528a(m524a2, false);
        m498a(m524a2, (KeyEvent) null);
    }

    /* renamed from: b */
    private boolean m505b(m mVar) {
        Context c0092d;
        Context context = this.f592b;
        if ((mVar.f632a == 0 || mVar.f632a == 108) && this.f563C != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0059a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0059a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0059a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme3 = theme2;
            if (theme3 != null) {
                c0092d = new C0092d(context, 0);
                c0092d.getTheme().setTo(theme3);
                C0106g c0106g = new C0106g(c0092d);
                c0106g.mo877a(this);
                mVar.m579a(c0106g);
                return true;
            }
        }
        c0092d = context;
        C0106g c0106g2 = new C0106g(c0092d);
        c0106g2.mo877a(this);
        mVar.m579a(c0106g2);
        return true;
    }

    /* renamed from: c */
    private boolean m509c(m mVar) {
        if (mVar.f640i != null) {
            mVar.f639h = mVar.f640i;
            return true;
        }
        if (mVar.f641j == null) {
            return false;
        }
        if (this.f565E == null) {
            this.f565E = new n();
        }
        mVar.f639h = (View) mVar.m577a(this.f565E);
        return mVar.f639h != null;
    }

    /* renamed from: b */
    private boolean m506b(m mVar, KeyEvent keyEvent) {
        if (this.f608r) {
            return false;
        }
        if (mVar.f644m) {
            return true;
        }
        if (this.f574N != null && this.f574N != mVar) {
            m528a(this.f574N, false);
        }
        Window.Callback m542l = m542l();
        if (m542l != null) {
            mVar.f640i = m542l.onCreatePanelView(mVar.f632a);
        }
        boolean z = mVar.f632a == 0 || mVar.f632a == 108;
        if (z && this.f563C != null) {
            this.f563C.mo1011j();
        }
        if (mVar.f640i == null && (!z || !(m541k() instanceof C0080l))) {
            if (mVar.f641j == null || mVar.f649r) {
                if (mVar.f641j == null && (!m505b(mVar) || mVar.f641j == null)) {
                    return false;
                }
                if (z && this.f563C != null) {
                    if (this.f564D == null) {
                        this.f564D = new a();
                    }
                    this.f563C.mo995a(mVar.f641j, this.f564D);
                }
                mVar.f641j.m904h();
                if (!m542l.onCreatePanelMenu(mVar.f632a, mVar.f641j)) {
                    mVar.m579a((C0106g) null);
                    if (!z || this.f563C == null) {
                        return false;
                    }
                    this.f563C.mo995a(null, this.f564D);
                    return false;
                }
                mVar.f649r = false;
            }
            mVar.f641j.m904h();
            if (mVar.f650s != null) {
                mVar.f641j.m887b(mVar.f650s);
                mVar.f650s = null;
            }
            if (!m542l.onPreparePanel(0, mVar.f640i, mVar.f641j)) {
                if (z && this.f563C != null) {
                    this.f563C.mo995a(null, this.f564D);
                }
                mVar.f641j.m905i();
                return false;
            }
            mVar.f647p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            mVar.f641j.setQwertyMode(mVar.f647p);
            mVar.f641j.m905i();
        }
        mVar.f644m = true;
        mVar.f645n = false;
        this.f574N = mVar;
        return true;
    }

    /* renamed from: b */
    void m534b(C0106g c0106g) {
        if (!this.f572L) {
            this.f572L = true;
            this.f563C.mo1012k();
            Window.Callback m542l = m542l();
            if (m542l != null && !this.f608r) {
                m542l.onPanelClosed(108, c0106g);
            }
            this.f572L = false;
        }
    }

    /* renamed from: g */
    void m539g(int i2) {
        m528a(m524a(i2, true), true);
    }

    /* renamed from: a */
    void m528a(m mVar, boolean z) {
        if (z && mVar.f632a == 0 && this.f563C != null && this.f563C.mo1007f()) {
            m534b(mVar.f641j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f592b.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null && mVar.f646o && mVar.f638g != null) {
            windowManager.removeView(mVar.f638g);
            if (z) {
                m526a(mVar.f632a, mVar, (Menu) null);
            }
        }
        mVar.f644m = false;
        mVar.f645n = false;
        mVar.f646o = false;
        mVar.f639h = null;
        mVar.f648q = true;
        if (this.f574N == mVar) {
            this.f574N = null;
        }
    }

    /* renamed from: d */
    private boolean m511d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            m m524a = m524a(i2, true);
            if (!m524a.f646o) {
                return m506b(m524a, keyEvent);
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m512e(int i2, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.f597g != null) {
            return false;
        }
        m m524a = m524a(i2, true);
        if (i2 == 0 && this.f563C != null && this.f563C.mo1006e() && !ViewConfiguration.get(this.f592b).hasPermanentMenuKey()) {
            if (!this.f563C.mo1007f()) {
                if (!this.f608r && m506b(m524a, keyEvent)) {
                    z2 = this.f563C.mo1009h();
                }
                z2 = false;
            } else {
                z2 = this.f563C.mo1010i();
            }
        } else if (m524a.f646o || m524a.f645n) {
            boolean z3 = m524a.f646o;
            m528a(m524a, true);
            z2 = z3;
        } else {
            if (m524a.f644m) {
                if (m524a.f649r) {
                    m524a.f644m = false;
                    z = m506b(m524a, keyEvent);
                } else {
                    z = true;
                }
                if (z) {
                    m498a(m524a, keyEvent);
                }
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f592b.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.m190w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    /* renamed from: a */
    void m526a(int i2, m mVar, Menu menu) {
        if (menu == null) {
            if (mVar == null && i2 >= 0 && i2 < this.f573M.length) {
                mVar = this.f573M[i2];
            }
            if (mVar != null) {
                menu = mVar.f641j;
            }
        }
        if ((mVar == null || mVar.f646o) && !this.f608r) {
            this.f561A.m779a().onPanelClosed(i2, menu);
        }
    }

    /* renamed from: a */
    m m525a(Menu menu) {
        m[] mVarArr = this.f573M;
        int length = mVarArr != null ? mVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            m mVar = mVarArr[i2];
            if (mVar != null && mVar.f641j == menu) {
                return mVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    protected m m524a(int i2, boolean z) {
        m[] mVarArr = this.f573M;
        if (mVarArr == null || mVarArr.length <= i2) {
            m[] mVarArr2 = new m[i2 + 1];
            if (mVarArr != null) {
                System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            }
            this.f573M = mVarArr2;
            mVarArr = mVarArr2;
        }
        m mVar = mVarArr[i2];
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(i2);
        mVarArr[i2] = mVar2;
        return mVar2;
    }

    /* renamed from: a */
    private boolean m502a(m mVar, int i2, KeyEvent keyEvent, int i3) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((mVar.f644m || m506b(mVar, keyEvent)) && mVar.f641j != null) {
                z = mVar.f641j.performShortcut(i2, keyEvent, i3);
            }
            if (z && (i3 & 1) == 0 && this.f563C == null) {
                m528a(mVar, true);
            }
        }
        return z;
    }

    /* renamed from: i */
    private void m513i(int i2) {
        this.f610t |= 1 << i2;
        if (!this.f609s) {
            C0308x.m2239a(this.f593c.getDecorView(), this.f585Y);
            this.f609s = true;
        }
    }

    /* renamed from: h */
    void m540h(int i2) {
        m m524a;
        m m524a2 = m524a(i2, true);
        if (m524a2.f641j != null) {
            Bundle bundle = new Bundle();
            m524a2.f641j.m875a(bundle);
            if (bundle.size() > 0) {
                m524a2.f650s = bundle;
            }
            m524a2.f641j.m904h();
            m524a2.f641j.clear();
        }
        m524a2.f649r = true;
        m524a2.f648q = true;
        if ((i2 == 108 || i2 == 0) && this.f563C != null && (m524a = m524a(0, false)) != null) {
            m524a.f644m = false;
            m506b(m524a, (KeyEvent) null);
        }
    }

    /* renamed from: a */
    final int m522a(C0282af c0282af, Rect rect) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (c0282af != null) {
            i2 = c0282af.m2077b();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        if (this.f598h == null || !(this.f598h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f598h.getLayoutParams();
            if (this.f598h.isShown()) {
                if (this.f588aa == null) {
                    this.f588aa = new Rect();
                    this.f589ab = new Rect();
                }
                Rect rect2 = this.f588aa;
                Rect rect3 = this.f589ab;
                if (c0282af == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c0282af.m2070a(), c0282af.m2077b(), c0282af.m2080c(), c0282af.m2081d());
                }
                C0191bf.m1480a(this.f602l, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                C0282af m2269p = C0308x.m2269p(this.f602l);
                int m2070a = m2269p == null ? 0 : m2269p.m2070a();
                int m2080c = m2269p == null ? 0 : m2269p.m2080c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z4 = true;
                }
                if (i3 > 0 && this.f569I == null) {
                    this.f569I = new View(this.f592b);
                    this.f569I.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = m2070a;
                    layoutParams.rightMargin = m2080c;
                    this.f602l.addView(this.f569I, -1, layoutParams);
                } else if (this.f569I != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f569I.getLayoutParams();
                    if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != m2070a || marginLayoutParams2.rightMargin != m2080c) {
                        marginLayoutParams2.height = marginLayoutParams.topMargin;
                        marginLayoutParams2.leftMargin = m2070a;
                        marginLayoutParams2.rightMargin = m2080c;
                        this.f569I.setLayoutParams(marginLayoutParams2);
                    }
                }
                z3 = this.f569I != null;
                if (z3 && this.f569I.getVisibility() != 0) {
                    m503b(this.f569I);
                }
                if (!this.f605o && z3) {
                    i2 = 0;
                }
                z2 = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (z2) {
                this.f598h.setLayoutParams(marginLayoutParams);
            }
            z = z3;
        }
        if (this.f569I != null) {
            this.f569I.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    /* renamed from: b */
    private void m503b(View view) {
        int m1855c;
        if ((C0308x.m2266m(view) & 8192) != 0) {
            m1855c = C0255a.m1855c(this.f592b, C0059a.c.abc_decor_view_status_guard_light);
        } else {
            m1855c = C0255a.m1855c(this.f592b, C0059a.c.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(m1855c);
    }

    /* renamed from: B */
    private void m491B() {
        if (this.f567G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: j */
    private int m514j(int i2) {
        if (i2 == 8) {
            Log.m186i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 == 9) {
            Log.m186i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return i2;
    }

    /* renamed from: s */
    void m549s() {
        if (this.f563C != null) {
            this.f563C.mo1012k();
        }
        if (this.f599i != null) {
            this.f593c.getDecorView().removeCallbacks(this.f600j);
            if (this.f599i.isShowing()) {
                try {
                    this.f599i.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.f599i = null;
        }
        m547q();
        m m524a = m524a(0, false);
        if (m524a != null && m524a.f641j != null) {
            m524a.f641j.close();
        }
    }

    /* renamed from: t */
    public boolean m550t() {
        return m507b(true);
    }

    /* renamed from: b */
    private boolean m507b(boolean z) {
        if (this.f608r) {
            return false;
        }
        int m492C = m492C();
        boolean m504b = m504b(m521a(this.f592b, m492C), z);
        if (m492C == 0) {
            m508c(this.f592b).m573d();
        } else if (this.f583W != null) {
            this.f583W.m574e();
        }
        if (m492C == 3) {
            m510d(this.f592b).m573d();
            return m504b;
        }
        if (this.f584X != null) {
            this.f584X.m574e();
            return m504b;
        }
        return m504b;
    }

    @Override // androidx.appcompat.app.AbstractC0073e
    /* renamed from: i */
    public int mo489i() {
        return this.f579S;
    }

    /* renamed from: a */
    int m521a(Context context, int i2) {
        switch (i2) {
            case AudioManager.ADJUST_MUTE /* -100 */:
                return -1;
            case -1:
            case 1:
            case 2:
                return i2;
            case 0:
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(Context.UI_MODE_SERVICE)).getNightMode() != 0) {
                    return m508c(context).mo570a();
                }
                return -1;
            case 3:
                return m510d(context).mo570a();
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
    }

    /* renamed from: C */
    private int m492C() {
        return this.f579S != -100 ? this.f579S : m465j();
    }

    /* renamed from: a */
    private Configuration m494a(Context context, int i2, Configuration configuration) {
        int i3;
        switch (i2) {
            case 1:
                i3 = 16;
                break;
            case 2:
                i3 = 32;
                break;
            default:
                i3 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                break;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    /* renamed from: b */
    private boolean m504b(int i2, boolean z) {
        boolean z2;
        boolean z3 = true;
        Configuration m494a = m494a(this.f592b, i2, (Configuration) null);
        boolean m493D = m493D();
        int i3 = this.f592b.getResources().getConfiguration().uiMode & 48;
        int i4 = m494a.uiMode & 48;
        if (i3 == i4 || !z || m493D || !this.f576P || ((!f558x && !this.f577Q) || !(this.f587a instanceof Activity) || ((Activity) this.f587a).isChild())) {
            z2 = false;
        } else {
            C0230a.m1684b((Activity) this.f587a);
            z2 = true;
        }
        if (z2 || i3 == i4) {
            z3 = z2;
        } else {
            m496a(i4, m493D, (Configuration) null);
        }
        if (z3 && (this.f587a instanceof ActivityC0071c)) {
            ((ActivityC0071c) this.f587a).m453b_(i2);
        }
        return z3;
    }

    /* renamed from: a */
    private void m496a(int i2, boolean z, Configuration configuration) {
        Resources resources = this.f592b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i2;
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            C0079k.m614a(resources);
        }
        if (this.f580T != 0) {
            this.f592b.setTheme(this.f580T);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f592b.getTheme().applyStyle(this.f580T, true);
            }
        }
        if (z && (this.f587a instanceof Activity)) {
            ComponentCallbacks2 componentCallbacks2 = (Activity) this.f587a;
            if (componentCallbacks2 instanceof LifecycleOwner) {
                if (((LifecycleOwner) componentCallbacks2).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    componentCallbacks2.onConfigurationChanged(configuration2);
                }
            } else if (this.f578R) {
                componentCallbacks2.onConfigurationChanged(configuration2);
            }
        }
    }

    /* renamed from: c */
    private i m508c(Context context) {
        if (this.f583W == null) {
            this.f583W = new j(C0082n.m625a(context));
        }
        return this.f583W;
    }

    /* renamed from: d */
    private i m510d(Context context) {
        if (this.f584X == null) {
            this.f584X = new h(context);
        }
        return this.f584X;
    }

    /* renamed from: D */
    private boolean m493D() {
        int i2;
        if (!this.f582V && (this.f587a instanceof Activity)) {
            PackageManager packageManager = this.f592b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f592b, this.f587a.getClass()), i2);
                this.f581U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.m183d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.f581U = false;
            }
        }
        this.f582V = true;
        return this.f581U;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$b */
    class b implements AbstractC0090b.a {

        /* renamed from: b */
        private AbstractC0090b.a f621b;

        public b(AbstractC0090b.a aVar) {
            this.f621b = aVar;
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public boolean mo561a(AbstractC0090b abstractC0090b, Menu menu) {
            return this.f621b.mo561a(abstractC0090b, menu);
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: b */
        public boolean mo563b(AbstractC0090b abstractC0090b, Menu menu) {
            C0308x.m2267n(LayoutInflaterFactory2C0074f.this.f602l);
            return this.f621b.mo563b(abstractC0090b, menu);
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public boolean mo562a(AbstractC0090b abstractC0090b, MenuItem menuItem) {
            return this.f621b.mo562a(abstractC0090b, menuItem);
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public void mo560a(AbstractC0090b abstractC0090b) {
            this.f621b.mo560a(abstractC0090b);
            if (LayoutInflaterFactory2C0074f.this.f599i != null) {
                LayoutInflaterFactory2C0074f.this.f593c.getDecorView().removeCallbacks(LayoutInflaterFactory2C0074f.this.f600j);
            }
            if (LayoutInflaterFactory2C0074f.this.f598h != null) {
                LayoutInflaterFactory2C0074f.this.m547q();
                LayoutInflaterFactory2C0074f.this.f601k = C0308x.m2263j(LayoutInflaterFactory2C0074f.this.f598h).m2058a(0.0f);
                LayoutInflaterFactory2C0074f.this.f601k.m2061a(new C0280ad() { // from class: androidx.appcompat.app.f.b.1
                    @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
                    /* renamed from: b */
                    public void mo557b(View view) {
                        LayoutInflaterFactory2C0074f.this.f598h.setVisibility(8);
                        if (LayoutInflaterFactory2C0074f.this.f599i != null) {
                            LayoutInflaterFactory2C0074f.this.f599i.dismiss();
                        } else if (LayoutInflaterFactory2C0074f.this.f598h.getParent() instanceof View) {
                            C0308x.m2267n((View) LayoutInflaterFactory2C0074f.this.f598h.getParent());
                        }
                        LayoutInflaterFactory2C0074f.this.f598h.m983c();
                        LayoutInflaterFactory2C0074f.this.f601k.m2061a((InterfaceC0279ac) null);
                        LayoutInflaterFactory2C0074f.this.f601k = null;
                        C0308x.m2267n(LayoutInflaterFactory2C0074f.this.f602l);
                    }
                });
            }
            if (LayoutInflaterFactory2C0074f.this.f594d != null) {
                LayoutInflaterFactory2C0074f.this.f594d.mo451b(LayoutInflaterFactory2C0074f.this.f597g);
            }
            LayoutInflaterFactory2C0074f.this.f597g = null;
            C0308x.m2267n(LayoutInflaterFactory2C0074f.this.f602l);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$n */
    private final class n implements InterfaceC0112m.a {
        n() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public void mo558a(C0106g c0106g, boolean z) {
            C0106g mo913q = c0106g.mo913q();
            boolean z2 = mo913q != c0106g;
            LayoutInflaterFactory2C0074f layoutInflaterFactory2C0074f = LayoutInflaterFactory2C0074f.this;
            if (z2) {
                c0106g = mo913q;
            }
            m m525a = layoutInflaterFactory2C0074f.m525a((Menu) c0106g);
            if (m525a != null) {
                if (z2) {
                    LayoutInflaterFactory2C0074f.this.m526a(m525a.f632a, m525a, mo913q);
                    LayoutInflaterFactory2C0074f.this.m528a(m525a, true);
                } else {
                    LayoutInflaterFactory2C0074f.this.m528a(m525a, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public boolean mo559a(C0106g c0106g) {
            Window.Callback m542l;
            if (c0106g == c0106g.mo913q() && LayoutInflaterFactory2C0074f.this.f603m && (m542l = LayoutInflaterFactory2C0074f.this.m542l()) != null && !LayoutInflaterFactory2C0074f.this.f608r) {
                m542l.onMenuOpened(108, c0106g);
                return true;
            }
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$a */
    private final class a implements InterfaceC0112m.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public boolean mo559a(C0106g c0106g) {
            Window.Callback m542l = LayoutInflaterFactory2C0074f.this.m542l();
            if (m542l != null) {
                m542l.onMenuOpened(108, c0106g);
                return true;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public void mo558a(C0106g c0106g, boolean z) {
            LayoutInflaterFactory2C0074f.this.m534b(c0106g);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$m */
    protected static final class m {

        /* renamed from: a */
        int f632a;

        /* renamed from: b */
        int f633b;

        /* renamed from: c */
        int f634c;

        /* renamed from: d */
        int f635d;

        /* renamed from: e */
        int f636e;

        /* renamed from: f */
        int f637f;

        /* renamed from: g */
        ViewGroup f638g;

        /* renamed from: h */
        View f639h;

        /* renamed from: i */
        View f640i;

        /* renamed from: j */
        C0106g f641j;

        /* renamed from: k */
        C0104e f642k;

        /* renamed from: l */
        Context f643l;

        /* renamed from: m */
        boolean f644m;

        /* renamed from: n */
        boolean f645n;

        /* renamed from: o */
        boolean f646o;

        /* renamed from: p */
        public boolean f647p;

        /* renamed from: q */
        boolean f648q = false;

        /* renamed from: r */
        boolean f649r;

        /* renamed from: s */
        Bundle f650s;

        m(int i) {
            this.f632a = i;
        }

        /* renamed from: a */
        public boolean m580a() {
            if (this.f639h == null) {
                return false;
            }
            return this.f640i != null || this.f642k.m851a().getCount() > 0;
        }

        /* renamed from: a */
        void m578a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0059a.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0059a.a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0059a.i.Theme_AppCompat_CompactMenu, true);
            }
            C0092d c0092d = new C0092d(context, 0);
            c0092d.getTheme().setTo(newTheme);
            this.f643l = c0092d;
            TypedArray obtainStyledAttributes = c0092d.obtainStyledAttributes(C0059a.j.AppCompatTheme);
            this.f633b = obtainStyledAttributes.getResourceId(C0059a.j.AppCompatTheme_panelBackground, 0);
            this.f637f = obtainStyledAttributes.getResourceId(C0059a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        void m579a(C0106g c0106g) {
            if (c0106g != this.f641j) {
                if (this.f641j != null) {
                    this.f641j.m889b(this.f642k);
                }
                this.f641j = c0106g;
                if (c0106g == null || this.f642k == null) {
                    return;
                }
                c0106g.m879a(this.f642k);
            }
        }

        /* renamed from: a */
        InterfaceC0113n m577a(InterfaceC0112m.a aVar) {
            if (this.f641j == null) {
                return null;
            }
            if (this.f642k == null) {
                this.f642k = new C0104e(this.f643l, C0059a.g.abc_list_menu_item_layout);
                this.f642k.mo814a(aVar);
                this.f641j.m879a(this.f642k);
            }
            return this.f642k.m852a(this.f638g);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$l */
    private class l extends ContentFrameLayout {
        public l(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflaterFactory2C0074f.this.m531a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m576a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            LayoutInflaterFactory2C0074f.this.m539g(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0060a.m348b(getContext(), i));
        }

        /* renamed from: a */
        private boolean m576a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$g */
    class g extends WindowCallbackC0097i {
        g(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflaterFactory2C0074f.this.m531a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || LayoutInflaterFactory2C0074f.this.m530a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0106g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0106g c0106g = menu instanceof C0106g ? (C0106g) menu : null;
            if (i == 0 && c0106g == null) {
                return false;
            }
            if (c0106g != null) {
                c0106g.m897d(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0106g != null) {
                c0106g.m897d(false);
                return onPreparePanel;
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            LayoutInflaterFactory2C0074f.this.m538f(i);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            LayoutInflaterFactory2C0074f.this.m537e(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (LayoutInflaterFactory2C0074f.this.m546p()) {
                return m569a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* renamed from: a */
        final ActionMode m569a(ActionMode.Callback callback) {
            C0094f.a aVar = new C0094f.a(LayoutInflaterFactory2C0074f.this.f592b, callback);
            AbstractC0090b mo467a = LayoutInflaterFactory2C0074f.this.mo467a(aVar);
            if (mo467a != null) {
                return aVar.m757b(mo467a);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (LayoutInflaterFactory2C0074f.this.m546p()) {
                switch (i) {
                    case 0:
                        return m569a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.WindowCallbackC0097i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            m m524a = LayoutInflaterFactory2C0074f.this.m524a(0, true);
            if (m524a != null && m524a.f641j != null) {
                super.onProvideKeyboardShortcuts(list, m524a.f641j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$i */
    abstract class i {

        /* renamed from: a */
        private BroadcastReceiver f626a;

        /* renamed from: a */
        abstract int mo570a();

        /* renamed from: b */
        abstract void mo571b();

        /* renamed from: c */
        abstract IntentFilter mo572c();

        i() {
        }

        /* renamed from: d */
        void m573d() {
            m574e();
            IntentFilter mo572c = mo572c();
            if (mo572c != null && mo572c.countActions() != 0) {
                if (this.f626a == null) {
                    this.f626a = new BroadcastReceiver() { // from class: androidx.appcompat.app.f.i.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            i.this.mo571b();
                        }
                    };
                }
                LayoutInflaterFactory2C0074f.this.f592b.registerReceiver(this.f626a, mo572c);
            }
        }

        /* renamed from: e */
        void m574e() {
            if (this.f626a != null) {
                try {
                    LayoutInflaterFactory2C0074f.this.f592b.unregisterReceiver(this.f626a);
                } catch (IllegalArgumentException e2) {
                }
                this.f626a = null;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$j */
    private class j extends i {

        /* renamed from: c */
        private final C0082n f630c;

        j(C0082n c0082n) {
            super();
            this.f630c = c0082n;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: a */
        public int mo570a() {
            return this.f630c.m629a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: b */
        public void mo571b() {
            LayoutInflaterFactory2C0074f.this.m550t();
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: c */
        IntentFilter mo572c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_TIME_CHANGED);
            intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
            intentFilter.addAction(Intent.ACTION_TIME_TICK);
            return intentFilter;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$h */
    private class h extends i {

        /* renamed from: c */
        private final PowerManager f625c;

        h(Context context) {
            super();
            this.f625c = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: a */
        public int mo570a() {
            return (Build.VERSION.SDK_INT < 21 || !d.m566a(this.f625c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: b */
        public void mo571b() {
            LayoutInflaterFactory2C0074f.this.m550t();
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0074f.i
        /* renamed from: c */
        IntentFilter mo572c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PowerManager.ACTION_POWER_SAVE_MODE_CHANGED);
            return intentFilter;
        }
    }

    /* renamed from: a */
    private static Configuration m495a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            if (configuration.fontScale != configuration2.fontScale) {
                configuration3.fontScale = configuration2.fontScale;
            }
            if (configuration.mcc != configuration2.mcc) {
                configuration3.mcc = configuration2.mcc;
            }
            if (configuration.mnc != configuration2.mnc) {
                configuration3.mnc = configuration2.mnc;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                e.m567a(configuration, configuration2, configuration3);
            } else if (!C0268c.m1953a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            if (configuration.touchscreen != configuration2.touchscreen) {
                configuration3.touchscreen = configuration2.touchscreen;
            }
            if (configuration.keyboard != configuration2.keyboard) {
                configuration3.keyboard = configuration2.keyboard;
            }
            if (configuration.keyboardHidden != configuration2.keyboardHidden) {
                configuration3.keyboardHidden = configuration2.keyboardHidden;
            }
            if (configuration.navigation != configuration2.navigation) {
                configuration3.navigation = configuration2.navigation;
            }
            if (configuration.navigationHidden != configuration2.navigationHidden) {
                configuration3.navigationHidden = configuration2.navigationHidden;
            }
            if (configuration.orientation != configuration2.orientation) {
                configuration3.orientation = configuration2.orientation;
            }
            if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
                configuration3.screenLayout |= configuration2.screenLayout & 15;
            }
            if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
                configuration3.screenLayout |= configuration2.screenLayout & 192;
            }
            if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
                configuration3.screenLayout |= configuration2.screenLayout & 48;
            }
            if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
                configuration3.screenLayout |= configuration2.screenLayout & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                f.m568a(configuration, configuration2, configuration3);
            }
            if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
                configuration3.uiMode |= configuration2.uiMode & 15;
            }
            if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
                configuration3.uiMode |= configuration2.uiMode & 48;
            }
            if (configuration.screenWidthDp != configuration2.screenWidthDp) {
                configuration3.screenWidthDp = configuration2.screenWidthDp;
            }
            if (configuration.screenHeightDp != configuration2.screenHeightDp) {
                configuration3.screenHeightDp = configuration2.screenHeightDp;
            }
            if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
                configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                c.m565a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$c */
    static class c {
        /* renamed from: a */
        static void m565a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }

        /* renamed from: a */
        static Context m564a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$d */
    static class d {
        /* renamed from: a */
        static boolean m566a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$e */
    static class e {
        /* renamed from: a */
        static void m567a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$f */
    static class f {
        /* renamed from: a */
        static void m568a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }
}
