package p000a.p002b.p003a;

import android.widget.ExpandableListView;
import java.p209io.EOFException;
import java.p209io.IOException;
import p000a.p001a.InterfaceC0004e;

/* compiled from: ZipBuffer.java */
/* renamed from: a.b.a.b */
/* loaded from: classes.dex */
public class C0011b {

    /* renamed from: a */
    private final long f33a;

    /* renamed from: b */
    private final long f34b;

    /* renamed from: c */
    private final long f35c;

    /* renamed from: d */
    private final long f36d;

    /* renamed from: e */
    private final long f37e;

    /* renamed from: f */
    private final boolean f38f;

    /* renamed from: g */
    private final InterfaceC0004e f39g;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
    
        if (m44c() == r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0011b(InterfaceC0004e interfaceC0004e) {
        long j;
        boolean z;
        long j2;
        long j3;
        boolean z2 = true;
        this.f39g = interfaceC0004e;
        long m41a = m41a();
        long j4 = m41a - 22;
        long max = Math.max(0L, m41a - 65557);
        while (true) {
            j = j4;
            if (j < max) {
                z = false;
                break;
            }
            m42a(j);
            if (m43b() == 101010256) {
                z = true;
                break;
            }
            j4 = (-1) + j;
        }
        if (!z) {
            throw new IOException("Archive is not a ZIP archive");
        }
        this.f36d = j;
        m42a(12 + j);
        this.f35c = m45d();
        this.f34b = m45d();
        long j5 = this.f34b;
        try {
            if (this.f34b >= 32) {
                m42a(this.f34b - 16);
                if (m44c() == 2334950737559900225L && m44c() == 3617552046287187010L) {
                    m42a(this.f34b - 24);
                    j2 = m44c();
                    j3 = (this.f34b - j2) - 8;
                    m42a(j3);
                }
            }
            j2 = 0;
            z2 = false;
            j3 = j5;
        } catch (Exception e2) {
            e2.printStackTrace();
            j2 = 0;
            z2 = false;
            j3 = j5;
        }
        this.f37e = j2;
        this.f33a = j3;
        this.f38f = z2;
    }

    /* renamed from: a */
    public long m41a() {
        return this.f39g.mo11b();
    }

    /* renamed from: a */
    public void m42a(long j) {
        this.f39g.mo12b(j);
    }

    /* renamed from: b */
    public int m43b() {
        int mo5a = this.f39g.mo5a();
        int mo5a2 = this.f39g.mo5a();
        int mo5a3 = this.f39g.mo5a();
        int mo5a4 = this.f39g.mo5a();
        if ((mo5a | mo5a2 | mo5a3 | mo5a4) < 0) {
            throw new EOFException();
        }
        return mo5a | (mo5a2 << 8) | (mo5a3 << 16) | (mo5a4 << 24);
    }

    /* renamed from: c */
    public long m44c() {
        long mo5a = this.f39g.mo5a();
        long mo5a2 = this.f39g.mo5a();
        long mo5a3 = this.f39g.mo5a();
        long mo5a4 = this.f39g.mo5a();
        long mo5a5 = this.f39g.mo5a();
        long mo5a6 = this.f39g.mo5a();
        long mo5a7 = this.f39g.mo5a();
        long mo5a8 = this.f39g.mo5a();
        if ((mo5a | mo5a2 | mo5a3 | mo5a4) < 0) {
            throw new EOFException();
        }
        return mo5a | (mo5a2 << 8) | (mo5a3 << 16) | (mo5a4 << 24) | (mo5a5 << 32) | (mo5a6 << 40) | (mo5a7 << 48) | (mo5a8 << 56);
    }

    /* renamed from: d */
    public long m45d() {
        return m43b() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: e */
    public long m46e() {
        return this.f33a;
    }

    /* renamed from: f */
    public long m47f() {
        return this.f34b;
    }

    /* renamed from: g */
    public long m48g() {
        return this.f35c;
    }

    /* renamed from: h */
    public long m49h() {
        return this.f36d;
    }

    /* renamed from: i */
    public boolean m50i() {
        return this.f38f;
    }
}
