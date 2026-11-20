package com.p065b.p066a.p068b.p080f;

import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import java.math.BigInteger;

/* compiled from: IssuerAndSerialNumber.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.f.e */
/* loaded from: classes.dex */
public class C0637e {

    @InterfaceC0622f(m6179c = 1, m6183g = EnumC0626j.INTEGER)
    public BigInteger certificateSerialNumber;

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.ANY)
    public C0623g issuer;

    public C0637e() {
    }

    public C0637e(C0623g c0623g, BigInteger bigInteger) {
        this.issuer = c0623g;
        this.certificateSerialNumber = bigInteger;
    }
}
