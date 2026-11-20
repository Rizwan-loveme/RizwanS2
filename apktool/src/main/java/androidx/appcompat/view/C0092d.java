package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.p008os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.C0059a;

/* compiled from: ContextThemeWrapper.java */
/* renamed from: androidx.appcompat.view.d */
/* loaded from: classes.dex */
public class C0092d extends ContextWrapper {

    /* renamed from: a */
    private int f808a;

    /* renamed from: b */
    private Resources.Theme f809b;

    /* renamed from: c */
    private LayoutInflater f810c;

    /* renamed from: d */
    private Configuration f811d;

    /* renamed from: e */
    private Resources f812e;

    public C0092d() {
        super(null);
    }

    public C0092d(Context context, int i) {
        super(context);
        this.f808a = i;
    }

    public C0092d(Context context, Resources.Theme theme) {
        super(context);
        this.f809b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: a */
    public void m754a(Configuration configuration) {
        if (this.f812e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f811d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f811d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m751b();
    }

    /* renamed from: b */
    private Resources m751b() {
        if (this.f812e == null) {
            if (this.f811d == null) {
                this.f812e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f812e = createConfigurationContext(this.f811d).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.f811d);
                this.f812e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.f812e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f808a != i) {
            this.f808a = i;
            m752c();
        }
    }

    /* renamed from: a */
    public int m753a() {
        return this.f808a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.f809b != null) {
            return this.f809b;
        }
        if (this.f808a == 0) {
            this.f808a = C0059a.i.Theme_AppCompat_Light;
        }
        m752c();
        return this.f809b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!Context.LAYOUT_INFLATER_SERVICE.equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f810c == null) {
            this.f810c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f810c;
    }

    /* renamed from: a */
    protected void m755a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* renamed from: c */
    private void m752c() {
        boolean z = this.f809b == null;
        if (z) {
            this.f809b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f809b.setTo(theme);
            }
        }
        m755a(this.f809b, this.f808a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
