package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC1998d;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;

/* compiled from: ImmutableByteEncodedValue.java */
/* renamed from: org.d.b.f.e.d */
/* loaded from: classes.dex */
public class C2337d extends AbstractC1998d implements InterfaceC2340g {

    /* renamed from: a */
    protected final byte f12592a;

    public C2337d(byte b2) {
        this.f12592a = b2;
    }

    /* renamed from: a */
    public static C2337d m14981a(InterfaceC2248d interfaceC2248d) {
        return interfaceC2248d instanceof C2337d ? (C2337d) interfaceC2248d : new C2337d(interfaceC2248d.mo14861b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2248d
    /* renamed from: b */
    public byte mo14861b() {
        return this.f12592a;
    }
}
