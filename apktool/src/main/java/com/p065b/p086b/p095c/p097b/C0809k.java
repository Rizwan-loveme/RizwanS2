package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p100d.C0905m;
import com.p065b.p086b.p100d.C0906n;

/* compiled from: Dop.java */
/* renamed from: com.b.b.c.b.k */
/* loaded from: classes.dex */
public final class C0809k {

    /* renamed from: a */
    private final int f4798a;

    /* renamed from: b */
    private final int f4799b;

    /* renamed from: c */
    private final int f4800c;

    /* renamed from: d */
    private final AbstractC0813o f4801d;

    /* renamed from: e */
    private final boolean f4802e;

    public C0809k(int i, int i2, int i3, AbstractC0813o abstractC0813o, boolean z) {
        if (!C0906n.m7693a(i)) {
            throw new IllegalArgumentException("bogus opcode");
        }
        if (!C0906n.m7693a(i2)) {
            throw new IllegalArgumentException("bogus family");
        }
        if (!C0906n.m7693a(i3)) {
            throw new IllegalArgumentException("bogus nextOpcode");
        }
        if (abstractC0813o == null) {
            throw new NullPointerException("format == null");
        }
        this.f4798a = i;
        this.f4799b = i2;
        this.f4800c = i3;
        this.f4801d = abstractC0813o;
        this.f4802e = z;
    }

    public String toString() {
        return m7060e();
    }

    /* renamed from: a */
    public int m7056a() {
        return this.f4798a;
    }

    /* renamed from: b */
    public int m7057b() {
        return this.f4799b;
    }

    /* renamed from: c */
    public AbstractC0813o m7058c() {
        return this.f4801d;
    }

    /* renamed from: d */
    public boolean m7059d() {
        return this.f4802e;
    }

    /* renamed from: e */
    public String m7060e() {
        return C0905m.m7686b(this.f4798a);
    }

    /* renamed from: f */
    public int m7061f() {
        return this.f4800c;
    }

    /* renamed from: g */
    public C0809k m7062g() {
        switch (this.f4798a) {
            case 50:
                return C0810l.f4856aa;
            case 51:
                return C0810l.f4828Z;
            case 52:
                return C0810l.f4858ac;
            case 53:
                return C0810l.f4857ab;
            case 54:
                return C0810l.f4860ae;
            case 55:
                return C0810l.f4859ad;
            case 56:
                return C0810l.f4862ag;
            case 57:
                return C0810l.f4861af;
            case 58:
                return C0810l.f4864ai;
            case 59:
                return C0810l.f4863ah;
            case 60:
                return C0810l.f4866ak;
            case 61:
                return C0810l.f4865aj;
            default:
                throw new IllegalArgumentException("bogus opcode: " + this);
        }
    }
}
