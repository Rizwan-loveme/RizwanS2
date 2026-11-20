package androidx.core.p031f.p033b;

import android.content.ClipDescription;
import android.net.Uri;
import android.p008os.Build;
import android.view.inputmethod.InputContentInfo;

/* compiled from: InputContentInfoCompat.java */
/* renamed from: androidx.core.f.b.c */
/* loaded from: classes.dex */
public final class C0286c {

    /* renamed from: a */
    private final c f2177a;

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: androidx.core.f.b.c$c */
    private interface c {
        /* renamed from: a */
        Uri mo2148a();

        /* renamed from: b */
        ClipDescription mo2149b();

        /* renamed from: c */
        Uri mo2150c();

        /* renamed from: d */
        Object mo2151d();

        /* renamed from: e */
        void mo2152e();
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: androidx.core.f.b.c$b */
    private static final class b implements c {

        /* renamed from: a */
        private final Uri f2179a;

        /* renamed from: b */
        private final ClipDescription f2180b;

        /* renamed from: c */
        private final Uri f2181c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2179a = uri;
            this.f2180b = clipDescription;
            this.f2181c = uri2;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: a */
        public Uri mo2148a() {
            return this.f2179a;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: b */
        public ClipDescription mo2149b() {
            return this.f2180b;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: c */
        public Uri mo2150c() {
            return this.f2181c;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: d */
        public Object mo2151d() {
            return null;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: e */
        public void mo2152e() {
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: androidx.core.f.b.c$a */
    private static final class a implements c {

        /* renamed from: a */
        final InputContentInfo f2178a;

        a(Object obj) {
            this.f2178a = (InputContentInfo) obj;
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2178a = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: a */
        public Uri mo2148a() {
            return this.f2178a.getContentUri();
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: b */
        public ClipDescription mo2149b() {
            return this.f2178a.getDescription();
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: c */
        public Uri mo2150c() {
            return this.f2178a.getLinkUri();
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: d */
        public Object mo2151d() {
            return this.f2178a;
        }

        @Override // androidx.core.p031f.p033b.C0286c.c
        /* renamed from: e */
        public void mo2152e() {
            this.f2178a.requestPermission();
        }
    }

    public C0286c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f2177a = new a(uri, clipDescription, uri2);
        } else {
            this.f2177a = new b(uri, clipDescription, uri2);
        }
    }

    private C0286c(c cVar) {
        this.f2177a = cVar;
    }

    /* renamed from: a */
    public Uri m2143a() {
        return this.f2177a.mo2148a();
    }

    /* renamed from: b */
    public ClipDescription m2144b() {
        return this.f2177a.mo2149b();
    }

    /* renamed from: c */
    public Uri m2145c() {
        return this.f2177a.mo2150c();
    }

    /* renamed from: a */
    public static C0286c m2142a(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new C0286c(new a(obj));
        }
        return null;
    }

    /* renamed from: d */
    public Object m2146d() {
        return this.f2177a.mo2151d();
    }

    /* renamed from: e */
    public void m2147e() {
        this.f2177a.mo2152e();
    }
}
