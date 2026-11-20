package androidx.core.p031f;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* renamed from: androidx.core.f.b */
/* loaded from: classes.dex */
public abstract class AbstractC0283b {

    /* renamed from: a */
    private final Context f2171a;

    /* renamed from: b */
    private a f2172b;

    /* renamed from: c */
    private b f2173c;

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.f.b$a */
    public interface a {
        /* renamed from: d */
        void mo1498d(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.f.b$b */
    public interface b {
        /* renamed from: a */
        void mo944a(boolean z);
    }

    /* renamed from: a */
    public abstract View mo946a();

    public AbstractC0283b(Context context) {
        this.f2171a = context;
    }

    /* renamed from: a */
    public View mo950a(MenuItem menuItem) {
        return mo946a();
    }

    /* renamed from: d */
    public boolean mo952d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo953e() {
        return true;
    }

    /* renamed from: b */
    public boolean mo948b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo949c() {
        return false;
    }

    /* renamed from: a */
    public void mo947a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public void m2129a(boolean z) {
        if (this.f2172b != null) {
            this.f2172b.mo1498d(z);
        }
    }

    /* renamed from: a */
    public void m2128a(a aVar) {
        this.f2172b = aVar;
    }

    /* renamed from: a */
    public void mo951a(b bVar) {
        if (this.f2173c != null && bVar != null) {
            Log.m190w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2173c = bVar;
    }

    /* renamed from: f */
    public void m2130f() {
        this.f2173c = null;
        this.f2172b = null;
    }
}
