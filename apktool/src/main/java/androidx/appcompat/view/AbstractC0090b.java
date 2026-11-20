package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* renamed from: androidx.appcompat.view.b */
/* loaded from: classes.dex */
public abstract class AbstractC0090b {

    /* renamed from: a */
    private Object f806a;

    /* renamed from: b */
    private boolean f807b;

    /* compiled from: ActionMode.java */
    /* renamed from: androidx.appcompat.view.b$a */
    public interface a {
        /* renamed from: a */
        void mo560a(AbstractC0090b abstractC0090b);

        /* renamed from: a */
        boolean mo561a(AbstractC0090b abstractC0090b, Menu menu);

        /* renamed from: a */
        boolean mo562a(AbstractC0090b abstractC0090b, MenuItem menuItem);

        /* renamed from: b */
        boolean mo563b(AbstractC0090b abstractC0090b, Menu menu);
    }

    /* renamed from: a */
    public abstract MenuInflater mo652a();

    /* renamed from: a */
    public abstract void mo653a(int i);

    /* renamed from: a */
    public abstract void mo654a(View view);

    /* renamed from: a */
    public abstract void mo655a(CharSequence charSequence);

    /* renamed from: b */
    public abstract Menu mo657b();

    /* renamed from: b */
    public abstract void mo658b(int i);

    /* renamed from: b */
    public abstract void mo659b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo660c();

    /* renamed from: d */
    public abstract void mo661d();

    /* renamed from: f */
    public abstract CharSequence mo663f();

    /* renamed from: g */
    public abstract CharSequence mo664g();

    /* renamed from: i */
    public abstract View mo666i();

    /* renamed from: a */
    public void m746a(Object obj) {
        this.f806a = obj;
    }

    /* renamed from: j */
    public Object m747j() {
        return this.f806a;
    }

    /* renamed from: a */
    public void mo656a(boolean z) {
        this.f807b = z;
    }

    /* renamed from: k */
    public boolean m748k() {
        return this.f807b;
    }

    /* renamed from: h */
    public boolean mo665h() {
        return false;
    }
}
