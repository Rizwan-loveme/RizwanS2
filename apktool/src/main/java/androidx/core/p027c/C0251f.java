package androidx.core.p027c;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.core.p030e.C0270e;
import java.util.concurrent.Executor;

/* compiled from: FontsContractCompat.java */
/* renamed from: androidx.core.c.f */
/* loaded from: classes.dex */
public class C0251f {
    /* renamed from: a */
    public static Typeface m1822a(Context context, C0249d c0249d, int i, boolean z, int i2, Handler handler, c cVar) {
        C0246a c0246a = new C0246a(cVar, handler);
        return z ? C0250e.m1815a(context, c0249d, c0246a, i, i2) : C0250e.m1814a(context, c0249d, i, (Executor) null, c0246a);
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.c.f$b */
    public static class b {

        /* renamed from: a */
        private final Uri f1994a;

        /* renamed from: b */
        private final int f1995b;

        /* renamed from: c */
        private final int f1996c;

        /* renamed from: d */
        private final boolean f1997d;

        /* renamed from: e */
        private final int f1998e;

        @Deprecated
        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f1994a = (Uri) C0270e.m1960a(uri);
            this.f1995b = i;
            this.f1996c = i2;
            this.f1997d = z;
            this.f1998e = i3;
        }

        /* renamed from: a */
        static b m1826a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        /* renamed from: a */
        public Uri m1827a() {
            return this.f1994a;
        }

        /* renamed from: b */
        public int m1828b() {
            return this.f1995b;
        }

        /* renamed from: c */
        public int m1829c() {
            return this.f1996c;
        }

        /* renamed from: d */
        public boolean m1830d() {
            return this.f1997d;
        }

        /* renamed from: e */
        public int m1831e() {
            return this.f1998e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.c.f$a */
    public static class a {

        /* renamed from: a */
        private final int f1992a;

        /* renamed from: b */
        private final b[] f1993b;

        @Deprecated
        public a(int i, b[] bVarArr) {
            this.f1992a = i;
            this.f1993b = bVarArr;
        }

        /* renamed from: a */
        public int m1824a() {
            return this.f1992a;
        }

        /* renamed from: b */
        public b[] m1825b() {
            return this.f1993b;
        }

        /* renamed from: a */
        static a m1823a(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.c.f$c */
    public static class c {
        /* renamed from: a */
        public void mo1833a(Typeface typeface) {
        }

        /* renamed from: a */
        public void mo1832a(int i) {
        }
    }
}
