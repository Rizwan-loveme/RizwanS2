package com.p065b.p066a.p068b.p078d;

import com.p065b.p066a.C0681h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.jar.Attributes;

/* compiled from: ManifestParser.java */
/* renamed from: com.b.a.b.d.a */
/* loaded from: classes.dex */
public class C0629a {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /* renamed from: a */
    private byte[] f4226a;

    /* renamed from: b */
    private int f4227b;

    /* renamed from: c */
    private final byte[] f4228c;

    /* renamed from: d */
    private int f4229d;

    public C0629a(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C0629a(byte[] bArr, int i, int i2) {
        this.f4228c = bArr;
        this.f4229d = i;
        this.f4227b = i + i2;
    }

    /* renamed from: a */
    public List<b> m6205a() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            b m6206b = m6206b();
            if (m6206b == null) {
                return arrayList;
            }
            arrayList.add(m6206b);
        }
    }

    /* renamed from: b */
    public b m6206b() {
        int i;
        String m6202c;
        do {
            i = this.f4229d;
            m6202c = m6202c();
            if (m6202c == null) {
                return null;
            }
        } while (m6202c.length() == 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m6200a(m6202c));
        while (true) {
            String m6202c2 = m6202c();
            if (m6202c2 == null || m6202c2.length() == 0) {
                break;
            }
            arrayList.add(m6200a(m6202c2));
        }
        return new b(i, this.f4229d - i, arrayList);
    }

    /* renamed from: a */
    private static a m6200a(String str) {
        int indexOf = str.indexOf(": ");
        if (indexOf == -1) {
            return new a(str, "");
        }
        return new a(str.substring(0, indexOf), str.substring(indexOf + 2));
    }

    /* renamed from: c */
    private String m6202c() {
        byte[] m6203d = m6203d();
        if (m6203d == null) {
            return null;
        }
        return m6203d.length == 0 ? "" : new String(m6203d, C0681h.UTF_8);
    }

    /* renamed from: d */
    private byte[] m6203d() {
        byte[] bArr = this.f4226a;
        if (bArr != null && bArr.length == 0) {
            this.f4226a = null;
            return EMPTY_BYTE_ARRAY;
        }
        byte[] m6204e = m6204e();
        if (m6204e == null) {
            byte[] bArr2 = this.f4226a;
            if (bArr2 == null) {
                return null;
            }
            this.f4226a = null;
            return bArr2;
        }
        if (m6204e.length == 0) {
            byte[] bArr3 = this.f4226a;
            if (bArr3 != null) {
                this.f4226a = EMPTY_BYTE_ARRAY;
                return bArr3;
            }
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr4 = this.f4226a;
        if (bArr4 != null) {
            if (m6204e.length == 0 || m6204e[0] != 32) {
                this.f4226a = m6204e;
                return bArr4;
            }
            this.f4226a = null;
            m6204e = m6201a(bArr4, m6204e, 1, m6204e.length - 1);
        }
        while (true) {
            byte[] m6204e2 = m6204e();
            if (m6204e2 != null) {
                if (m6204e2.length == 0) {
                    this.f4226a = EMPTY_BYTE_ARRAY;
                    return m6204e;
                }
                if (m6204e2[0] == 32) {
                    m6204e = m6201a(m6204e, m6204e2, 1, m6204e2.length - 1);
                } else {
                    this.f4226a = m6204e2;
                    return m6204e;
                }
            } else {
                return m6204e;
            }
        }
    }

    /* renamed from: a */
    private static byte[] m6201a(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] bArr3 = new byte[bArr.length + i2];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, i, bArr3, bArr.length, i2);
        return bArr3;
    }

    /* renamed from: e */
    private byte[] m6204e() {
        int i;
        int i2;
        int i3 = this.f4229d;
        if (i3 >= this.f4227b) {
            return null;
        }
        int i4 = i3;
        while (true) {
            i = this.f4227b;
            if (i4 >= i) {
                i4 = -1;
                i2 = -1;
                break;
            }
            byte[] bArr = this.f4228c;
            byte b2 = bArr[i4];
            if (b2 == 13) {
                i2 = i4 + 1;
                if (i2 < i && bArr[i2] == 10) {
                    i2++;
                }
            } else {
                if (b2 == 10) {
                    i2 = i4 + 1;
                    break;
                }
                i4++;
            }
        }
        if (i4 == -1) {
            i4 = i;
            i2 = i;
        }
        this.f4229d = i2;
        if (i4 == i3) {
            return EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(this.f4228c, i3, i4);
    }

    /* compiled from: ManifestParser.java */
    /* renamed from: com.b.a.b.d.a$a */
    public static class a {

        /* renamed from: a */
        private final String f4230a;

        /* renamed from: b */
        private final String f4231b;

        public a(String str, String str2) {
            this.f4230a = str;
            this.f4231b = str2;
        }

        /* renamed from: a */
        public String m6207a() {
            return this.f4230a;
        }

        /* renamed from: b */
        public String m6208b() {
            return this.f4231b;
        }
    }

    /* compiled from: ManifestParser.java */
    /* renamed from: com.b.a.b.d.a$b */
    public static class b {

        /* renamed from: a */
        private final List<a> f4232a;

        /* renamed from: b */
        private final String f4233b;

        /* renamed from: c */
        private final int f4234c;

        /* renamed from: d */
        private final int f4235d;

        public b(int i, int i2, List<a> list) {
            String str;
            this.f4235d = i;
            this.f4234c = i2;
            if (!list.isEmpty()) {
                a aVar = list.get(0);
                if ("Name".equalsIgnoreCase(aVar.m6207a())) {
                    str = aVar.m6208b();
                    this.f4233b = str;
                    this.f4232a = Collections.unmodifiableList(new ArrayList(list));
                }
            }
            str = null;
            this.f4233b = str;
            this.f4232a = Collections.unmodifiableList(new ArrayList(list));
        }

        /* renamed from: a */
        public String m6209a() {
            return this.f4233b;
        }

        /* renamed from: c */
        public int m6213c() {
            return this.f4235d;
        }

        /* renamed from: b */
        public int m6212b() {
            return this.f4234c;
        }

        /* renamed from: a */
        public String m6211a(Attributes.Name name) {
            return m6210a(name.toString());
        }

        /* renamed from: a */
        public String m6210a(String str) {
            for (a aVar : this.f4232a) {
                if (aVar.m6207a().equalsIgnoreCase(str)) {
                    return aVar.m6208b();
                }
            }
            return null;
        }
    }
}
