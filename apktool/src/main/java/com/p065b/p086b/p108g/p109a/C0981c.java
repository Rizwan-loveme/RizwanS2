package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p108g.C1001r;
import com.p065b.p086b.p110h.InterfaceC1026q;
import java.util.ArrayList;

/* compiled from: InterferenceGraph.java */
/* renamed from: com.b.b.g.a.c */
/* loaded from: classes.dex */
public class C0981c {

    /* renamed from: a */
    private final ArrayList<InterfaceC1026q> f6298a;

    public C0981c(int i) {
        this.f6298a = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f6298a.add(C1001r.m8331b(i));
        }
    }

    /* renamed from: a */
    public void m8187a(int i, int i2) {
        m8186a(Math.max(i, i2) + 1);
        this.f6298a.get(i).mo8477a(i2);
        this.f6298a.get(i2).mo8477a(i);
    }

    /* renamed from: a */
    public void m8188a(int i, InterfaceC1026q interfaceC1026q) {
        if (i < this.f6298a.size()) {
            interfaceC1026q.mo8478a(this.f6298a.get(i));
        }
    }

    /* renamed from: a */
    private void m8186a(int i) {
        this.f6298a.ensureCapacity(i);
        for (int size = this.f6298a.size(); size < i; size++) {
            this.f6298a.add(C1001r.m8331b(i));
        }
    }
}
