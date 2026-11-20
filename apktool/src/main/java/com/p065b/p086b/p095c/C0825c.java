package com.p065b.p086b.p095c;

import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p110h.C1018i;
import java.util.Arrays;

/* compiled from: TableOfContents.java */
/* renamed from: com.b.b.c.c */
/* loaded from: classes.dex */
public final class C0825c {

    /* renamed from: t */
    public int f5135t;

    /* renamed from: v */
    public int f5137v;

    /* renamed from: w */
    public int f5138w;

    /* renamed from: x */
    public int f5139x;

    /* renamed from: y */
    public int f5140y;

    /* renamed from: z */
    public int f5141z;

    /* renamed from: a */
    public final a f5116a = new a(0);

    /* renamed from: b */
    public final a f5117b = new a(1);

    /* renamed from: c */
    public final a f5118c = new a(2);

    /* renamed from: d */
    public final a f5119d = new a(3);

    /* renamed from: e */
    public final a f5120e = new a(4);

    /* renamed from: f */
    public final a f5121f = new a(5);

    /* renamed from: g */
    public final a f5122g = new a(6);

    /* renamed from: h */
    public final a f5123h = new a(4096);

    /* renamed from: i */
    public final a f5124i = new a(4097);

    /* renamed from: j */
    public final a f5125j = new a(4098);

    /* renamed from: k */
    public final a f5126k = new a(4099);

    /* renamed from: l */
    public final a f5127l = new a(8192);

    /* renamed from: m */
    public final a f5128m = new a(8193);

    /* renamed from: n */
    public final a f5129n = new a(8194);

    /* renamed from: o */
    public final a f5130o = new a(8195);

    /* renamed from: p */
    public final a f5131p = new a(8196);

    /* renamed from: q */
    public final a f5132q = new a(8197);

    /* renamed from: r */
    public final a f5133r = new a(8198);

    /* renamed from: s */
    public final a[] f5134s = {this.f5116a, this.f5117b, this.f5118c, this.f5119d, this.f5120e, this.f5121f, this.f5122g, this.f5123h, this.f5124i, this.f5125j, this.f5126k, this.f5127l, this.f5128m, this.f5129n, this.f5130o, this.f5131p, this.f5132q, this.f5133r};

    /* renamed from: u */
    public byte[] f5136u = new byte[20];

    /* renamed from: a */
    public void m7192a(C0898f c0898f) {
        m7188c(c0898f.m7595a(0));
        m7189d(c0898f.m7595a(this.f5123h.f5144c));
        m7190a();
    }

    /* renamed from: c */
    private void m7188c(C0898f.a aVar) {
        byte[] m7627a = aVar.m7627a(8);
        if (C0759a.m6936a(m7627a) < 0) {
            throw new C1018i("Unexpected magic: " + Arrays.toString(m7627a));
        }
        this.f5135t = aVar.m7628b();
        this.f5136u = aVar.m7627a(20);
        this.f5137v = aVar.m7628b();
        int m7628b = aVar.m7628b();
        if (m7628b != 112) {
            throw new C1018i("Unexpected header: 0x" + Integer.toHexString(m7628b));
        }
        int m7628b2 = aVar.m7628b();
        if (m7628b2 != 305419896) {
            throw new C1018i("Unexpected endian tag: 0x" + Integer.toHexString(m7628b2));
        }
        this.f5138w = aVar.m7628b();
        this.f5139x = aVar.m7628b();
        this.f5123h.f5144c = aVar.m7628b();
        if (this.f5123h.f5144c == 0) {
            throw new C1018i("Cannot merge dex files that do not contain a map");
        }
        this.f5117b.f5143b = aVar.m7628b();
        this.f5117b.f5144c = aVar.m7628b();
        this.f5118c.f5143b = aVar.m7628b();
        this.f5118c.f5144c = aVar.m7628b();
        this.f5119d.f5143b = aVar.m7628b();
        this.f5119d.f5144c = aVar.m7628b();
        this.f5120e.f5143b = aVar.m7628b();
        this.f5120e.f5144c = aVar.m7628b();
        this.f5121f.f5143b = aVar.m7628b();
        this.f5121f.f5144c = aVar.m7628b();
        this.f5122g.f5143b = aVar.m7628b();
        this.f5122g.f5144c = aVar.m7628b();
        this.f5140y = aVar.m7628b();
        this.f5141z = aVar.m7628b();
    }

    /* renamed from: d */
    private void m7189d(C0898f.a aVar) {
        int m7628b = aVar.m7628b();
        a aVar2 = null;
        int i = 0;
        while (i < m7628b) {
            short m7630c = aVar.m7630c();
            aVar.m7630c();
            a m7187a = m7187a(m7630c);
            int m7628b2 = aVar.m7628b();
            int m7628b3 = aVar.m7628b();
            if ((m7187a.f5143b != 0 && m7187a.f5143b != m7628b2) || (m7187a.f5144c != -1 && m7187a.f5144c != m7628b3)) {
                throw new C1018i("Unexpected map value for 0x" + Integer.toHexString(m7630c));
            }
            m7187a.f5143b = m7628b2;
            m7187a.f5144c = m7628b3;
            if (aVar2 == null || aVar2.f5144c <= m7187a.f5144c) {
                i++;
                aVar2 = m7187a;
            } else {
                throw new C1018i("Map is unsorted at " + aVar2 + ", " + m7187a);
            }
        }
        Arrays.sort(this.f5134s);
    }

    /* renamed from: a */
    public void m7190a() {
        int i = this.f5141z + this.f5140y;
        for (int length = this.f5134s.length - 1; length >= 0; length--) {
            a aVar = this.f5134s[length];
            if (aVar.f5144c != -1) {
                if (aVar.f5144c > i) {
                    throw new C1018i("Map is unsorted at " + aVar);
                }
                aVar.f5145d = i - aVar.f5144c;
                i = aVar.f5144c;
            }
        }
    }

    /* renamed from: a */
    private a m7187a(short s) {
        for (a aVar : this.f5134s) {
            if (aVar.f5142a == s) {
                return aVar;
            }
        }
        throw new IllegalArgumentException("No such map item: " + ((int) s));
    }

    /* renamed from: a */
    public void m7191a(C0898f.a aVar) {
        aVar.m7625a(C0759a.m6937a(14).getBytes("UTF-8"));
        aVar.m7635e(this.f5135t);
        aVar.m7625a(this.f5136u);
        aVar.m7635e(this.f5137v);
        aVar.m7635e(112);
        aVar.m7635e(305419896);
        aVar.m7635e(this.f5138w);
        aVar.m7635e(this.f5139x);
        aVar.m7635e(this.f5123h.f5144c);
        aVar.m7635e(this.f5117b.f5143b);
        aVar.m7635e(this.f5117b.f5144c);
        aVar.m7635e(this.f5118c.f5143b);
        aVar.m7635e(this.f5118c.f5144c);
        aVar.m7635e(this.f5119d.f5143b);
        aVar.m7635e(this.f5119d.f5144c);
        aVar.m7635e(this.f5120e.f5143b);
        aVar.m7635e(this.f5120e.f5144c);
        aVar.m7635e(this.f5121f.f5143b);
        aVar.m7635e(this.f5121f.f5144c);
        aVar.m7635e(this.f5122g.f5143b);
        aVar.m7635e(this.f5122g.f5144c);
        aVar.m7635e(this.f5140y);
        aVar.m7635e(this.f5141z);
    }

    /* renamed from: b */
    public void m7193b(C0898f.a aVar) {
        int i = 0;
        for (a aVar2 : this.f5134s) {
            if (aVar2.m7195a()) {
                i++;
            }
        }
        aVar.m7635e(i);
        for (a aVar3 : this.f5134s) {
            if (aVar3.m7195a()) {
                aVar.m7624a(aVar3.f5142a);
                aVar.m7624a((short) 0);
                aVar.m7635e(aVar3.f5143b);
                aVar.m7635e(aVar3.f5144c);
            }
        }
    }

    /* compiled from: TableOfContents.java */
    /* renamed from: com.b.b.c.c$a */
    public static class a implements Comparable<a> {

        /* renamed from: a */
        public final short f5142a;

        /* renamed from: b */
        public int f5143b = 0;

        /* renamed from: c */
        public int f5144c = -1;

        /* renamed from: d */
        public int f5145d = 0;

        public a(int i) {
            this.f5142a = (short) i;
        }

        /* renamed from: a */
        public boolean m7195a() {
            return this.f5143b > 0;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (this.f5144c != aVar.f5144c) {
                return this.f5144c < aVar.f5144c ? -1 : 1;
            }
            return 0;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.f5142a), Integer.valueOf(this.f5144c), Integer.valueOf(this.f5143b));
        }
    }
}
