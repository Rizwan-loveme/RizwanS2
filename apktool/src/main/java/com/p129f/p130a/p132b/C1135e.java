package com.p129f.p130a.p132b;

import com.p129f.p130a.p131a.C1115j;
import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: CacheStats.java */
/* renamed from: com.f.a.b.e */
/* loaded from: classes.dex */
public final class C1135e {

    /* renamed from: a */
    private final long f7606a;

    /* renamed from: b */
    private final long f7607b;

    /* renamed from: c */
    private final long f7608c;

    /* renamed from: d */
    private final long f7609d;

    /* renamed from: e */
    private final long f7610e;

    /* renamed from: f */
    private final long f7611f;

    public C1135e(long j, long j2, long j3, long j4, long j5, long j6) {
        C1120o.m9550a(j >= 0);
        C1120o.m9550a(j2 >= 0);
        C1120o.m9550a(j3 >= 0);
        C1120o.m9550a(j4 >= 0);
        C1120o.m9550a(j5 >= 0);
        C1120o.m9550a(j6 >= 0);
        this.f7606a = j;
        this.f7607b = j2;
        this.f7608c = j3;
        this.f7609d = j4;
        this.f7610e = j5;
        this.f7611f = j6;
    }

    public int hashCode() {
        return C1116k.m9537a(Long.valueOf(this.f7606a), Long.valueOf(this.f7607b), Long.valueOf(this.f7608c), Long.valueOf(this.f7609d), Long.valueOf(this.f7610e), Long.valueOf(this.f7611f));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof C1135e)) {
            return false;
        }
        C1135e c1135e = (C1135e) obj;
        return this.f7606a == c1135e.f7606a && this.f7607b == c1135e.f7607b && this.f7608c == c1135e.f7608c && this.f7609d == c1135e.f7609d && this.f7610e == c1135e.f7610e && this.f7611f == c1135e.f7611f;
    }

    public String toString() {
        return C1115j.m9528a(this).m9535a("hitCount", this.f7606a).m9535a("missCount", this.f7607b).m9535a("loadSuccessCount", this.f7608c).m9535a("loadExceptionCount", this.f7609d).m9535a("totalLoadTime", this.f7610e).m9535a("evictionCount", this.f7611f).toString();
    }
}
