package com.p065b.p066a.p068b.p080f;

import com.p065b.p066a.p068b.p075b.EnumC0625i;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import java.nio.ByteBuffer;

/* compiled from: EncapsulatedContentInfo.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.f.d */
/* loaded from: classes.dex */
public class C0636d {

    @InterfaceC0622f(m6179c = 1, m6180d = true, m6181e = 0, m6182f = EnumC0625i.EXPLICIT, m6183g = EnumC0626j.OCTET_STRING)
    public ByteBuffer content;

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.OBJECT_IDENTIFIER)
    public String contentType;

    public C0636d() {
    }

    public C0636d(String str) {
        this.contentType = str;
    }
}
