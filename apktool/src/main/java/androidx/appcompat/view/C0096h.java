package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0280ad;
import androidx.core.p031f.InterfaceC0279ac;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: androidx.appcompat.view.h */
/* loaded from: classes.dex */
public class C0096h {

    /* renamed from: b */
    InterfaceC0279ac f868b;

    /* renamed from: d */
    private Interpolator f870d;

    /* renamed from: e */
    private boolean f871e;

    /* renamed from: c */
    private long f869c = -1;

    /* renamed from: f */
    private final C0280ad f872f = new C0280ad() { // from class: androidx.appcompat.view.h.1

        /* renamed from: b */
        private boolean f874b = false;

        /* renamed from: c */
        private int f875c = 0;

        @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
        /* renamed from: a */
        public void mo556a(View view) {
            if (!this.f874b) {
                this.f874b = true;
                if (C0096h.this.f868b != null) {
                    C0096h.this.f868b.mo556a(null);
                }
            }
        }

        /* renamed from: a */
        void m778a() {
            this.f875c = 0;
            this.f874b = false;
            C0096h.this.m776b();
        }

        @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
        /* renamed from: b */
        public void mo557b(View view) {
            int i = this.f875c + 1;
            this.f875c = i;
            if (i == C0096h.this.f867a.size()) {
                if (C0096h.this.f868b != null) {
                    C0096h.this.f868b.mo557b(null);
                }
                m778a();
            }
        }
    };

    /* renamed from: a */
    final ArrayList<C0278ab> f867a = new ArrayList<>();

    /* renamed from: a */
    public C0096h m772a(C0278ab c0278ab) {
        if (!this.f871e) {
            this.f867a.add(c0278ab);
        }
        return this;
    }

    /* renamed from: a */
    public C0096h m773a(C0278ab c0278ab, C0278ab c0278ab2) {
        this.f867a.add(c0278ab);
        c0278ab2.m2064b(c0278ab.m2057a());
        this.f867a.add(c0278ab2);
        return this;
    }

    /* renamed from: a */
    public void m775a() {
        if (!this.f871e) {
            Iterator<C0278ab> it = this.f867a.iterator();
            while (it.hasNext()) {
                C0278ab next = it.next();
                if (this.f869c >= 0) {
                    next.m2059a(this.f869c);
                }
                if (this.f870d != null) {
                    next.m2060a(this.f870d);
                }
                if (this.f868b != null) {
                    next.m2061a(this.f872f);
                }
                next.m2066c();
            }
            this.f871e = true;
        }
    }

    /* renamed from: b */
    void m776b() {
        this.f871e = false;
    }

    /* renamed from: c */
    public void m777c() {
        if (this.f871e) {
            Iterator<C0278ab> it = this.f867a.iterator();
            while (it.hasNext()) {
                it.next().m2065b();
            }
            this.f871e = false;
        }
    }

    /* renamed from: a */
    public C0096h m770a(long j) {
        if (!this.f871e) {
            this.f869c = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0096h m771a(Interpolator interpolator) {
        if (!this.f871e) {
            this.f870d = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C0096h m774a(InterfaceC0279ac interfaceC0279ac) {
        if (!this.f871e) {
            this.f868b = interfaceC0279ac;
        }
        return this;
    }
}
