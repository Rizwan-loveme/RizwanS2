package com.p065b.p066a.p068b.p080f;

import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0625i;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: SignedData.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.f.g */
/* loaded from: classes.dex */
public class C0639g {

    @InterfaceC0622f(m6179c = 3, m6180d = true, m6181e = 0, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.SET_OF)
    public List<C0623g> certificates;

    @InterfaceC0622f(m6179c = 4, m6180d = true, m6181e = 1, m6182f = EnumC0625i.IMPLICIT, m6183g = EnumC0626j.SET_OF)
    public List<ByteBuffer> crls;

    @InterfaceC0622f(m6179c = 1, m6183g = EnumC0626j.SET_OF)
    public List<C0633a> digestAlgorithms;

    @InterfaceC0622f(m6179c = 2, m6183g = EnumC0626j.SEQUENCE)
    public C0636d encapContentInfo;

    @InterfaceC0622f(m6179c = 5, m6183g = EnumC0626j.SET_OF)
    public List<C0641i> signerInfos;

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.INTEGER)
    public int version;
}
