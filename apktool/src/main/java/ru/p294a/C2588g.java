package ru.p294a;

import java.util.zip.ZipException;

/* compiled from: JarMarker.java */
/* renamed from: ru.a.g */
/* loaded from: classes.dex */
public final class C2588g implements InterfaceC2603v {

    /* renamed from: a */
    private static final C2607z f13434a = new C2607z(51966);

    /* renamed from: b */
    private static final C2607z f13435b = new C2607z(0);

    /* renamed from: c */
    private static final byte[] f13436c = new byte[0];

    /* renamed from: d */
    private static final C2588g f13437d = new C2588g();

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public C2607z mo16060a() {
        return f13434a;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return f13435b;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        return f13435b;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        return f13436c;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        return f13436c;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
