package p000a.p002b.p003a.p004a;

import p000a.p001a.InterfaceC0004e;

/* compiled from: DataSources.java */
/* renamed from: a.b.a.a.d */
/* loaded from: classes.dex */
public class C0009d {
    /* renamed from: a */
    public static InterfaceC0008c m35a(InterfaceC0004e interfaceC0004e, long j, long j2) {
        return new C0010e(interfaceC0004e, j, j2);
    }

    /* renamed from: a */
    public static InterfaceC0008c m37a(byte[] bArr) {
        return m38a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static InterfaceC0008c m38a(byte[] bArr, int i, int i2) {
        return new C0006a(bArr, i, i2);
    }

    /* renamed from: a */
    public static InterfaceC0008c m36a(InterfaceC0008c interfaceC0008c, int i) {
        int mo29c = (int) (interfaceC0008c.mo29c() % i);
        return mo29c == 0 ? interfaceC0008c : m39a(interfaceC0008c, m37a(new byte[i - mo29c]));
    }

    /* renamed from: a */
    public static InterfaceC0008c m39a(InterfaceC0008c... interfaceC0008cArr) {
        return new C0007b(interfaceC0008cArr);
    }
}
