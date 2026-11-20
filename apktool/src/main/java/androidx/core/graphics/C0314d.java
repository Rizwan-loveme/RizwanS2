package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.p028a.C0258c;
import androidx.core.content.p028a.C0261f;
import androidx.core.p027c.C0251f;
import androidx.p011a.C0040e;

/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* renamed from: androidx.core.graphics.d */
/* loaded from: classes.dex */
public class C0314d {

    /* renamed from: a */
    private static final C0326j f2244a;

    /* renamed from: b */
    private static final C0040e<String, Typeface> f2245b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2244a = new C0325i();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f2244a = new C0324h();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f2244a = new C0323g();
        } else if (Build.VERSION.SDK_INT >= 24 && C0322f.m2387a()) {
            f2244a = new C0322f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2244a = new C0321e();
        } else {
            f2244a = new C0326j();
        }
        f2245b = new C0040e<>(16);
    }

    /* renamed from: a */
    public static Typeface m2335a(Resources resources, int i, int i2) {
        return f2245b.m245a((C0040e<String, Typeface>) m2338b(resources, i, i2));
    }

    /* renamed from: b */
    private static String m2338b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* renamed from: a */
    private static Typeface m2336a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }

    /* renamed from: a */
    public static Typeface m2334a(Context context, C0258c.a aVar, Resources resources, int i, int i2, C0261f.c cVar, Handler handler, boolean z) {
        Typeface mo2385a;
        boolean z2 = true;
        if (aVar instanceof C0258c.d) {
            C0258c.d dVar = (C0258c.d) aVar;
            mo2385a = m2336a(dVar.m1899d());
            if (mo2385a != null) {
                if (cVar != null) {
                    cVar.m1920a(mo2385a, handler);
                }
                return mo2385a;
            }
            if (z) {
                if (dVar.m1897b() != 0) {
                    z2 = false;
                }
            } else if (cVar != null) {
                z2 = false;
            }
            mo2385a = C0251f.m1822a(context, dVar.m1896a(), i2, z2, z ? dVar.m1898c() : -1, C0261f.c.m1918a(handler), new a(cVar));
        } else {
            mo2385a = f2244a.mo2385a(context, (C0258c.b) aVar, resources, i2);
            if (cVar != null) {
                if (mo2385a != null) {
                    cVar.m1920a(mo2385a, handler);
                } else {
                    cVar.m1919a(-3, handler);
                }
            }
        }
        if (mo2385a != null) {
            f2245b.m246a(m2338b(resources, i, i2), mo2385a);
        }
        return mo2385a;
    }

    /* renamed from: a */
    public static Typeface m2331a(Context context, Resources resources, int i, String str, int i2) {
        Typeface mo2396a = f2244a.mo2396a(context, resources, i, str, i2);
        if (mo2396a != null) {
            f2245b.m246a(m2338b(resources, i, i2), mo2396a);
        }
        return mo2396a;
    }

    /* renamed from: a */
    public static Typeface m2333a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        return f2244a.mo2384a(context, cancellationSignal, bVarArr, i);
    }

    /* renamed from: b */
    private static Typeface m2337b(Context context, Typeface typeface, int i) {
        C0258c.b m2411a = f2244a.m2411a(typeface);
        if (m2411a == null) {
            return null;
        }
        return f2244a.mo2385a(context, m2411a, context.getResources(), i);
    }

    /* renamed from: a */
    public static Typeface m2332a(Context context, Typeface typeface, int i) {
        Typeface m2337b;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        return (Build.VERSION.SDK_INT >= 21 || (m2337b = m2337b(context, typeface, i)) == null) ? Typeface.create(typeface, i) : m2337b;
    }

    /* compiled from: TypefaceCompat.java */
    /* renamed from: androidx.core.graphics.d$a */
    public static class a extends C0251f.c {

        /* renamed from: a */
        private C0261f.c f2246a;

        public a(C0261f.c cVar) {
            this.f2246a = cVar;
        }

        @Override // androidx.core.p027c.C0251f.c
        /* renamed from: a */
        public void mo1833a(Typeface typeface) {
            if (this.f2246a != null) {
                this.f2246a.mo1193a(typeface);
            }
        }

        @Override // androidx.core.p027c.C0251f.c
        /* renamed from: a */
        public void mo1832a(int i) {
            if (this.f2246a != null) {
                this.f2246a.mo1192a(i);
            }
        }
    }
}
