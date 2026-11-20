package com.p065b.p111c.p113b.p117b;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.jar.Attributes;

/* compiled from: ManifestParser.java */
/* renamed from: com.b.c.b.b.a */
/* loaded from: classes.dex */
public class C1050a {

    /* renamed from: a */
    private static final byte[] f6680a = new byte[0];

    /* renamed from: b */
    private byte[] f6681b;

    /* renamed from: c */
    private int f6682c;

    /* renamed from: d */
    private final byte[] f6683d;

    /* renamed from: e */
    private int f6684e;

    public C1050a(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C1050a(byte[] bArr, int i, int i2) {
        this.f6683d = bArr;
        this.f6684e = i;
        this.f6682c = i + i2;
    }

    /* renamed from: a */
    public List<b> m8817a() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            b m8818b = m8818b();
            if (m8818b != null) {
                arrayList.add(m8818b);
            } else {
                return arrayList;
            }
        }
    }

    /* renamed from: b */
    public b m8818b() {
        int i;
        String m8814c;
        do {
            i = this.f6684e;
            m8814c = m8814c();
            if (m8814c == null) {
                return null;
            }
        } while (m8814c.length() == 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m8812a(m8814c));
        while (true) {
            String m8814c2 = m8814c();
            if (m8814c2 == null || m8814c2.length() == 0) {
                break;
            }
            arrayList.add(m8812a(m8814c2));
        }
        return new b(i, this.f6684e - i, arrayList);
    }

    /* renamed from: a */
    private static a m8812a(String str) {
        int indexOf = str.indexOf(": ");
        if (indexOf == -1) {
            return new a(str, "");
        }
        return new a(str.substring(0, indexOf), str.substring(indexOf + ": ".length()));
    }

    /* renamed from: c */
    private String m8814c() {
        byte[] m8815d = m8815d();
        if (m8815d == null) {
            return null;
        }
        if (m8815d.length == 0) {
            return "";
        }
        return new String(m8815d, StandardCharsets.UTF_8);
    }

    /* renamed from: d */
    private byte[] m8815d() {
        byte[] m8813a;
        if (this.f6681b != null && this.f6681b.length == 0) {
            this.f6681b = null;
            return f6680a;
        }
        byte[] m8816e = m8816e();
        if (m8816e == null) {
            if (this.f6681b == null) {
                return null;
            }
            byte[] bArr = this.f6681b;
            this.f6681b = null;
            return bArr;
        }
        if (m8816e.length == 0) {
            if (this.f6681b != null) {
                byte[] bArr2 = this.f6681b;
                this.f6681b = f6680a;
                return bArr2;
            }
            return f6680a;
        }
        if (this.f6681b == null) {
            m8813a = m8816e;
        } else {
            if (m8816e.length == 0 || m8816e[0] != 32) {
                byte[] bArr3 = this.f6681b;
                this.f6681b = m8816e;
                return bArr3;
            }
            byte[] bArr4 = this.f6681b;
            this.f6681b = null;
            m8813a = m8813a(bArr4, m8816e, 1, m8816e.length - 1);
        }
        while (true) {
            byte[] m8816e2 = m8816e();
            if (m8816e2 != null) {
                if (m8816e2.length == 0) {
                    this.f6681b = f6680a;
                    return m8813a;
                }
                if (m8816e2[0] == 32) {
                    m8813a = m8813a(m8813a, m8816e2, 1, m8816e2.length - 1);
                } else {
                    this.f6681b = m8816e2;
                    return m8813a;
                }
            } else {
                return m8813a;
            }
        }
    }

    /* renamed from: a */
    private static byte[] m8813a(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] bArr3 = new byte[bArr.length + i2];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, i, bArr3, bArr.length, i2);
        return bArr3;
    }

    /* renamed from: e */
    private byte[] m8816e() {
        int i;
        int i2;
        int i3;
        if (this.f6684e >= this.f6682c) {
            return null;
        }
        int i4 = this.f6684e;
        int i5 = i4;
        while (true) {
            if (i5 >= this.f6682c) {
                i = -1;
                i2 = -1;
                break;
            }
            byte b2 = this.f6683d[i5];
            if (b2 == 13) {
                i2 = i5 + 1;
                if (i2 >= this.f6682c || this.f6683d[i2] != 10) {
                    i = i5;
                } else {
                    i2++;
                    i = i5;
                }
            } else if (b2 != 10) {
                i5++;
            } else {
                i2 = i5 + 1;
                i = i5;
                break;
            }
        }
        if (i == -1) {
            int i6 = this.f6682c;
            i3 = this.f6682c;
            i = i6;
        } else {
            i3 = i2;
        }
        this.f6684e = i3;
        if (i == i4) {
            return f6680a;
        }
        return Arrays.copyOfRange(this.f6683d, i4, i);
    }

    /* compiled from: ManifestParser.java */
    /* renamed from: com.b.c.b.b.a$a */
    public static class a {

        /* renamed from: a */
        private final String f6685a;

        /* renamed from: b */
        private final String f6686b;

        public a(String str, String str2) {
            this.f6685a = str;
            this.f6686b = str2;
        }

        /* renamed from: a */
        public String m8819a() {
            return this.f6685a;
        }

        /* renamed from: b */
        public String m8820b() {
            return this.f6686b;
        }
    }

    /* compiled from: ManifestParser.java */
    /* renamed from: com.b.c.b.b.a$b */
    public static class b {

        /* renamed from: a */
        private final List<a> f6687a;

        /* renamed from: b */
        private final String f6688b;

        /* renamed from: c */
        private final int f6689c;

        /* renamed from: d */
        private final int f6690d;

        public b(int i, int i2, List<a> list) {
            String str;
            this.f6690d = i;
            this.f6689c = i2;
            if (!list.isEmpty()) {
                a aVar = list.get(0);
                if ("Name".equalsIgnoreCase(aVar.m8819a())) {
                    str = aVar.m8820b();
                    this.f6688b = str;
                    this.f6687a = Collections.unmodifiableList(new ArrayList(list));
                }
            }
            str = null;
            this.f6688b = str;
            this.f6687a = Collections.unmodifiableList(new ArrayList(list));
        }

        /* renamed from: a */
        public String m8821a() {
            return this.f6688b;
        }

        /* renamed from: c */
        public int m8825c() {
            return this.f6690d;
        }

        /* renamed from: b */
        public int m8824b() {
            return this.f6689c;
        }

        /* renamed from: a */
        public String m8823a(Attributes.Name name) {
            return m8822a(name.toString());
        }

        /* renamed from: a */
        public String m8822a(String str) {
            for (a aVar : this.f6687a) {
                if (aVar.m8819a().equalsIgnoreCase(str)) {
                    return aVar.m8820b();
                }
            }
            return null;
        }
    }
}
