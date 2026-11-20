package com.p065b.p066a.p068b.p069a.p070a;

import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0591b;
import com.p065b.p066a.p068b.p069a.C0595c;
import com.p065b.p066a.p068b.p069a.C0602e;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0677b;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: V2SourceStampVerifier.java */
/* renamed from: com.b.a.b.a.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC0590d {
    private AbstractC0590d() {
    }

    /* renamed from: a */
    public static C0591b m5847a(InterfaceC0671c interfaceC0671c, C0677b c0677b, byte[] bArr, Map<Integer, Map<EnumC0607g, byte[]>> map, int i, int i2) {
        C0591b c0591b = new C0591b(0);
        m5849a(C0602e.m6028a(interfaceC0671c, c0677b, AbstractC0589c.V2_SOURCE_STAMP_BLOCK_ID).f4196e, bArr, map, i, i2, c0591b);
        return c0591b;
    }

    /* renamed from: a */
    private static void m5849a(ByteBuffer byteBuffer, byte[] bArr, Map<Integer, Map<EnumC0607g, byte[]>> map, int i, int i2, C0591b c0591b) {
        C0595c c0595c = new C0595c();
        c0591b.f4012a.add(c0595c);
        try {
            C0588b.m5832a(C0602e.m6035b(byteBuffer), CertificateFactory.getInstance("X.509"), c0595c, m5850b(map), bArr, i, i2);
            c0591b.f4014c = (c0591b.mo5855a() || c0591b.mo5856b()) ? false : true;
        } catch (C0579a e2) {
            c0595c.m5929a(20, new Object[0]);
        } catch (BufferUnderflowException e3) {
            c0595c.m5929a(20, new Object[0]);
        } catch (CertificateException e4) {
            throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    /* renamed from: b */
    private static Map<Integer, byte[]> m5850b(Map<Integer, Map<EnumC0607g, byte[]>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Map<EnumC0607g, byte[]>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), C0602e.m6034a(m5848a(entry.getValue())));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<C0652k<Integer, byte[]>> m5848a(Map<EnumC0607g, byte[]> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<EnumC0607g, byte[]> entry : map.entrySet()) {
            arrayList.add(C0652k.m6250a(Integer.valueOf(entry.getKey().m6076b()), entry.getValue()));
        }
        Collections.sort(arrayList, new Comparator<C0652k<Integer, byte[]>>() { // from class: com.b.a.b.a.a.d.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0652k<Integer, byte[]> c0652k, C0652k<Integer, byte[]> c0652k2) {
                return c0652k.m6251a().intValue() - c0652k2.m6251a().intValue();
            }
        });
        return arrayList;
    }
}
