package com.p065b.p066a.p068b.p069a;

import com.p065b.p066a.C0668c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApkSigResult.java */
/* renamed from: com.b.a.b.a.b */
/* loaded from: classes.dex */
public class C0591b {

    /* renamed from: b */
    public final int f4013b;

    /* renamed from: c */
    public boolean f4014c;

    /* renamed from: a */
    public final List<C0595c> f4012a = new ArrayList();

    /* renamed from: e */
    private final List<C0668c> f4016e = new ArrayList();

    /* renamed from: d */
    private final List<C0668c> f4015d = new ArrayList();

    public C0591b(int i) {
        this.f4013b = i;
    }

    /* renamed from: a */
    public boolean mo5855a() {
        if (!this.f4015d.isEmpty()) {
            return true;
        }
        if (!this.f4012a.isEmpty()) {
            Iterator<C0595c> it = this.f4012a.iterator();
            while (it.hasNext()) {
                if (it.next().mo5930a()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo5856b() {
        if (!this.f4016e.isEmpty()) {
            return true;
        }
        if (!this.f4012a.isEmpty()) {
            Iterator<C0595c> it = this.f4012a.iterator();
            while (it.hasNext()) {
                if (it.next().mo5931b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public List<? extends C0668c> mo5857c() {
        return this.f4015d;
    }
}
