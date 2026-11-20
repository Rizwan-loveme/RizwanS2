package com.p140g.p141a;

/* compiled from: DexException.java */
/* renamed from: com.g.a.a */
/* loaded from: classes.dex */
public class C1236a extends RuntimeException {
    public C1236a() {
    }

    public C1236a(String str) {
        super(str);
    }

    public C1236a(String str, Throwable th) {
        super(str, th);
    }

    public C1236a(Throwable th, String str, Object... objArr) {
        this(String.format(str, objArr), th);
    }
}
