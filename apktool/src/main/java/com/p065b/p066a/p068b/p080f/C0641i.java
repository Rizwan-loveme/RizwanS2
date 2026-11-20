package com.p065b.p066a.p068b.p080f;

import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0625i;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: SignerInfo.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.f.i */
/* loaded from: classes.dex */
public class C0641i {

    @InterfaceC0622f(m6179c = 2, m6183g = EnumC0626j.SEQUENCE)
    public C0633a digestAlgorithm;

    @InterfaceC0622f(m6179c = 1, m6183g = EnumC0626j.CHOICE)
    public C0640h sid;

    @InterfaceC0622f(m6179c = 5, m6183g = EnumC0626j.OCTET_STRING)
    public ByteBuffer signature;

    @InterfaceC0622f(m6179c = 4, m6183g = EnumC0626j.SEQUENCE)
    public C0633a signatureAlgorithm;

    @InterfaceC0622f(m6179c = 3, m6180d = true, m6181e = 0, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.SET_OF)
    public C0623g signedAttrs;

    @InterfaceC0622f(m6179c = 6, m6180d = true, m6181e = 1, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.SET_OF)
    public List<C0634b> unsignedAttrs;

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.INTEGER)
    public int version;
}
