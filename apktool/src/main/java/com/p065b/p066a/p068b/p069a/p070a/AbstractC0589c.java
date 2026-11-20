package com.p065b.p066a.p068b.p069a.p070a;

import com.p065b.p066a.C0680g;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p081g.C0652k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: V2SourceStampSigner.java */
/* renamed from: com.b.a.b.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0589c {
    public static final int V2_SOURCE_STAMP_BLOCK_ID = 1845461005;

    private AbstractC0589c() {
    }

    /* renamed from: a */
    public static C0652k<byte[], Integer> m5840a(C0598d.g gVar, Map<Integer, Map<EnumC0607g, byte[]>> map) {
        if (gVar.f4149a.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        ArrayList arrayList = new ArrayList();
        m5842a(3, map, gVar, arrayList);
        m5842a(2, map, gVar, arrayList);
        m5842a(1, map, gVar, arrayList);
        Collections.sort(arrayList, new Comparator<C0652k>() { // from class: com.b.a.b.a.a.c.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0652k c0652k, C0652k c0652k2) {
                return ((Integer) c0652k.m6251a()).compareTo((Integer) c0652k2.m6251a());
            }
        });
        a aVar = new a();
        try {
            aVar.f4006d = gVar.f4149a.get(0).getEncoded();
            aVar.f4003a = arrayList;
            aVar.f4005c = m5843a(m5841a(gVar.f4150b));
            aVar.f4004b = C0598d.m5950a(gVar, aVar.f4005c);
            return C0652k.m6250a(C0598d.m5962a(C0598d.m5964a(new byte[][]{aVar.f4006d, C0598d.m5970b(aVar.f4003a), aVar.f4005c, C0598d.m5970b(aVar.f4004b)})), Integer.valueOf(V2_SOURCE_STAMP_BLOCK_ID));
        } catch (CertificateEncodingException e2) {
            throw new SignatureException("Retrieving the encoded form of the stamp certificate failed", e2);
        }
    }

    /* renamed from: a */
    private static void m5842a(int i, Map<Integer, Map<EnumC0607g, byte[]>> map, C0598d.g gVar, List<C0652k<Integer, byte[]>> list) {
        if (map.containsKey(Integer.valueOf(i))) {
            Map<EnumC0607g, byte[]> map2 = map.get(Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<EnumC0607g, byte[]> entry : map2.entrySet()) {
                arrayList.add(C0652k.m6250a(Integer.valueOf(entry.getKey().m6076b()), entry.getValue()));
            }
            Collections.sort(arrayList, new Comparator<C0652k>() { // from class: com.b.a.b.a.a.c.2
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(C0652k c0652k, C0652k c0652k2) {
                    return ((Integer) c0652k.m6251a()).compareTo((Integer) c0652k2.m6251a());
                }
            });
            list.add(C0652k.m6250a(Integer.valueOf(i), C0598d.m5970b(C0598d.m5950a(gVar, C0598d.m5970b(arrayList)))));
        }
    }

    /* renamed from: a */
    private static byte[] m5843a(Map<Integer, byte[]> map) {
        int i;
        Iterator<byte[]> it = map.values().iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = it.next().length + 8 + i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + 4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
            allocate.putInt(entry.getValue().length + 4);
            allocate.putInt(entry.getKey().intValue());
            allocate.put(entry.getValue());
        }
        return allocate.array();
    }

    /* renamed from: a */
    private static Map<Integer, byte[]> m5841a(C0680g c0680g) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > 0) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putLong(currentTimeMillis);
            hashMap.put(-465807034, allocate.array());
            if (c0680g != null) {
                hashMap.put(-1654455305, c0680g.m6491a());
            }
            return hashMap;
        }
        throw new IllegalStateException("Received an invalid value from Instant#getTimestamp: " + currentTimeMillis);
    }

    /* compiled from: V2SourceStampSigner.java */
    /* renamed from: com.b.a.b.a.a.c$a */
    private static final class a {

        /* renamed from: a */
        public List<C0652k<Integer, byte[]>> f4003a;

        /* renamed from: b */
        public List<C0652k<Integer, byte[]>> f4004b;

        /* renamed from: c */
        public byte[] f4005c;

        /* renamed from: d */
        public byte[] f4006d;

        private a() {
        }
    }
}
