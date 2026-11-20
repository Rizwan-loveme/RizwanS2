package org.p217b.p218a.p219a;

import java.io.Serializable;

/* compiled from: IOCase.java */
/* renamed from: org.b.a.a.d */
/* loaded from: classes.dex */
public final class C1886d implements Serializable {

    /* renamed from: a */
    public static final C1886d f11045a = new C1886d("Sensitive", true);

    /* renamed from: b */
    public static final C1886d f11046b = new C1886d("Insensitive", false);

    /* renamed from: c */
    public static final C1886d f11047c;

    /* renamed from: d */
    private final String f11048d;

    /* renamed from: e */
    private final transient boolean f11049e;

    static {
        f11047c = new C1886d("System", C1885c.m13952a() ? false : true);
    }

    private C1886d(String str, boolean z) {
        this.f11048d = str;
        this.f11049e = z;
    }

    /* renamed from: a */
    public boolean m13961a() {
        return this.f11049e;
    }

    public String toString() {
        return this.f11048d;
    }
}
