package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p095c.C0765b;
import java.util.ArrayList;

/* compiled from: OutputCollector.java */
/* renamed from: com.b.b.c.b.u */
/* loaded from: classes.dex */
public final class C0819u {

    /* renamed from: a */
    private final C0820v f5084a;

    /* renamed from: b */
    private ArrayList<AbstractC0807i> f5085b;

    public C0819u(C0765b c0765b, int i, int i2, int i3) {
        this.f5084a = new C0820v(c0765b, i, i3);
        this.f5085b = new ArrayList<>(i2);
    }

    /* renamed from: a */
    public void m7130a(AbstractC0807i abstractC0807i) {
        this.f5084a.m7150a(abstractC0807i);
    }

    /* renamed from: a */
    public void m7129a(int i, C0804f c0804f) {
        this.f5084a.m7148a(i, c0804f);
    }

    /* renamed from: b */
    public void m7131b(AbstractC0807i abstractC0807i) {
        this.f5085b.add(abstractC0807i);
    }

    /* renamed from: a */
    public C0820v m7128a() {
        if (this.f5085b == null) {
            throw new UnsupportedOperationException("already processed");
        }
        m7127b();
        return this.f5084a;
    }

    /* renamed from: b */
    private void m7127b() {
        int size = this.f5085b.size();
        for (int i = 0; i < size; i++) {
            this.f5084a.m7150a(this.f5085b.get(i));
        }
        this.f5085b = null;
    }
}
