package com.p065b.p086b.p102e;

import com.p065b.p086b.p100d.C0895c;
import com.p065b.p086b.p100d.C0898f;
import java.util.Comparator;

/* compiled from: SortableType.java */
/* renamed from: com.b.b.e.e */
/* loaded from: classes.dex */
final class C0912e {

    /* renamed from: a */
    public static final Comparator<C0912e> f5835a = new Comparator<C0912e>() { // from class: com.b.b.e.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0912e c0912e, C0912e c0912e2) {
            if (c0912e == c0912e2) {
                return 0;
            }
            if (c0912e2 == null) {
                return -1;
            }
            if (c0912e != null) {
                if (c0912e.f5838d != c0912e2.f5838d) {
                    return c0912e.f5838d - c0912e2.f5838d;
                }
                return c0912e.m7811c() - c0912e2.m7811c();
            }
            return 1;
        }
    };

    /* renamed from: b */
    private final C0898f f5836b;

    /* renamed from: c */
    private C0895c f5837c;

    /* renamed from: d */
    private int f5838d = -1;

    public C0912e(C0898f c0898f, C0895c c0895c) {
        this.f5836b = c0898f;
        this.f5837c = c0895c;
    }

    /* renamed from: a */
    public C0898f m7808a() {
        return this.f5836b;
    }

    /* renamed from: b */
    public C0895c m7810b() {
        return this.f5837c;
    }

    /* renamed from: c */
    public int m7811c() {
        return this.f5837c.m7554b();
    }

    /* renamed from: a */
    public boolean m7809a(C0912e[] c0912eArr) {
        int i;
        if (this.f5837c.m7555c() == -1) {
            i = 0;
        } else {
            C0912e c0912e = c0912eArr[this.f5837c.m7555c()];
            if (c0912e == null) {
                i = 1;
            } else {
                if (c0912e.f5838d == -1) {
                    return false;
                }
                i = c0912e.f5838d;
            }
        }
        for (short s : this.f5837c.m7557e()) {
            C0912e c0912e2 = c0912eArr[s];
            if (c0912e2 == null) {
                i = Math.max(i, 1);
            } else {
                if (c0912e2.f5838d == -1) {
                    return false;
                }
                i = Math.max(i, c0912e2.f5838d);
            }
        }
        this.f5838d = i + 1;
        return true;
    }

    /* renamed from: d */
    public boolean m7812d() {
        return this.f5838d != -1;
    }
}
