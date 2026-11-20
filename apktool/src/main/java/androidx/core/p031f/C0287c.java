package androidx.core.p031f;

import android.app.slice.Slice;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.p030e.C0270e;

/* compiled from: ContentInfoCompat.java */
/* renamed from: androidx.core.f.c */
/* loaded from: classes.dex */
public final class C0287c {

    /* renamed from: a */
    final ClipData f2182a;

    /* renamed from: b */
    final int f2183b;

    /* renamed from: c */
    final int f2184c;

    /* renamed from: d */
    final Uri f2185d;

    /* renamed from: e */
    final Bundle f2186e;

    /* renamed from: a */
    static String m2153a(int i) {
        switch (i) {
            case 0:
                return "SOURCE_APP";
            case 1:
                return "SOURCE_CLIPBOARD";
            case 2:
                return "SOURCE_INPUT_METHOD";
            case 3:
                return "SOURCE_DRAG_AND_DROP";
            default:
                return String.valueOf(i);
        }
    }

    /* renamed from: b */
    static String m2154b(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    C0287c(a aVar) {
        this.f2182a = (ClipData) C0270e.m1960a(aVar.f2187a);
        this.f2183b = C0270e.m1959a(aVar.f2188b, 0, 3, Slice.SUBTYPE_SOURCE);
        this.f2184c = C0270e.m1958a(aVar.f2189c, 1);
        this.f2185d = aVar.f2190d;
        this.f2186e = aVar.f2191e;
    }

    public String toString() {
        return "ContentInfoCompat{clip=" + this.f2182a.getDescription() + ", source=" + m2153a(this.f2183b) + ", flags=" + m2154b(this.f2184c) + (this.f2185d == null ? "" : ", hasLinkUri(" + this.f2185d.toString().length() + ")") + (this.f2186e == null ? "" : ", hasExtras") + "}";
    }

    /* renamed from: a */
    public ClipData m2155a() {
        return this.f2182a;
    }

    /* renamed from: b */
    public int m2156b() {
        return this.f2183b;
    }

    /* renamed from: c */
    public int m2157c() {
        return this.f2184c;
    }

    /* compiled from: ContentInfoCompat.java */
    /* renamed from: androidx.core.f.c$a */
    public static final class a {

        /* renamed from: a */
        ClipData f2187a;

        /* renamed from: b */
        int f2188b;

        /* renamed from: c */
        int f2189c;

        /* renamed from: d */
        Uri f2190d;

        /* renamed from: e */
        Bundle f2191e;

        public a(ClipData clipData, int i) {
            this.f2187a = clipData;
            this.f2188b = i;
        }

        /* renamed from: a */
        public a m2158a(int i) {
            this.f2189c = i;
            return this;
        }

        /* renamed from: a */
        public a m2159a(Uri uri) {
            this.f2190d = uri;
            return this;
        }

        /* renamed from: a */
        public a m2160a(Bundle bundle) {
            this.f2191e = bundle;
            return this;
        }

        /* renamed from: a */
        public C0287c m2161a() {
            return new C0287c(this);
        }
    }
}
