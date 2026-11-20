package ru.p294a;

import java.nio.ByteBuffer;

/* compiled from: FallbackZipEncoding.java */
/* renamed from: ru.a.e */
/* loaded from: classes.dex */
class C2586e implements InterfaceC2600s {

    /* renamed from: a */
    private final String f13429a;

    public C2586e() {
        this.f13429a = (String) null;
    }

    public C2586e(String str) {
        this.f13429a = str;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public boolean mo16078a(String str) {
        return true;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: b */
    public ByteBuffer mo16079b(String str) {
        return this.f13429a == null ? ByteBuffer.wrap(str.getBytes()) : ByteBuffer.wrap(str.getBytes(this.f13429a));
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public String mo16077a(byte[] bArr) {
        return this.f13429a == null ? new String(bArr) : new String(bArr, this.f13429a);
    }
}
