package com.p065b.p086b.p095c.p099c;

/* compiled from: IndexedItem.java */
/* renamed from: com.b.b.c.c.x */
/* loaded from: classes.dex */
public abstract class AbstractC0871x extends AbstractC0872y {

    /* renamed from: a */
    private int f5299a = -1;

    /* renamed from: h */
    public final boolean m7435h() {
        return this.f5299a >= 0;
    }

    /* renamed from: i */
    public final int m7436i() {
        if (this.f5299a < 0) {
            throw new RuntimeException("index not yet set");
        }
        return this.f5299a;
    }

    /* renamed from: a */
    public final void m7434a(int i) {
        if (this.f5299a != -1) {
            throw new RuntimeException("index already set");
        }
        this.f5299a = i;
    }

    /* renamed from: j */
    public final String m7437j() {
        return '[' + Integer.toHexString(this.f5299a) + ']';
    }
}
