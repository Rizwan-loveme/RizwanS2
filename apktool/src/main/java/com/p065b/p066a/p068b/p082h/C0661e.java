package com.p065b.p066a.p068b.p082h;

import com.p065b.p066a.p068b.p075b.EnumC0625i;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import com.p065b.p066a.p068b.p080f.C0633a;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TBSCertificate.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.h.e */
/* loaded from: classes.dex */
public class C0661e {

    @InterfaceC0622f(m6179c = 9, m6180d = true, m6181e = 3, m6182f = EnumC0625i.EXPLICIT, m6183g = EnumC0626j.SEQUENCE_OF)
    public List<Object> extensions;

    @InterfaceC0622f(m6179c = 3, m6183g = EnumC0626j.CHOICE)
    public C0658b issuer;

    @InterfaceC0622f(m6179c = 7, m6180d = true, m6181e = 1, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.BIT_STRING)
    public ByteBuffer issuerUniqueID;

    @InterfaceC0622f(m6179c = 1, m6183g = EnumC0626j.INTEGER)
    public BigInteger serialNumber;

    @InterfaceC0622f(m6179c = 2, m6183g = EnumC0626j.SEQUENCE)
    public C0633a signatureAlgorithm;

    @InterfaceC0622f(m6179c = 5, m6183g = EnumC0626j.CHOICE)
    public C0658b subject;

    @InterfaceC0622f(m6179c = 6, m6183g = EnumC0626j.SEQUENCE)
    public C0660d subjectPublicKeyInfo;

    @InterfaceC0622f(m6179c = 8, m6180d = true, m6181e = 2, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.BIT_STRING)
    public ByteBuffer subjectUniqueID;

    @InterfaceC0622f(m6179c = 4, m6183g = EnumC0626j.SEQUENCE)
    public C0663g validity;

    @InterfaceC0622f(m6179c = 0, m6181e = 0, m6182f = EnumC0625i.EXPLICIT, m6183g = EnumC0626j.INTEGER)
    public int version;
}
