package com.p065b.p066a.p068b.p080f;

import com.p065b.p066a.p068b.p075b.EnumC0625i;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import java.nio.ByteBuffer;

/* compiled from: SignerIdentifier.java */
@InterfaceC0618b(m6143a = EnumC0626j.CHOICE)
/* renamed from: com.b.a.b.f.h */
/* loaded from: classes.dex */
public class C0640h {

    @InterfaceC0622f(m6183g = EnumC0626j.SEQUENCE)
    public C0637e issuerAndSerialNumber;

    @InterfaceC0622f(m6181e = 0, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.OCTET_STRING)
    public ByteBuffer subjectKeyIdentifier;

    public C0640h() {
    }

    public C0640h(C0637e c0637e) {
        this.issuerAndSerialNumber = c0637e;
    }
}
