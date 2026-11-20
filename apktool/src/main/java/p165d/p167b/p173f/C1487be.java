package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: RDN.java */
/* renamed from: d.b.f.be */
/* loaded from: classes.dex */
public class C1487be {

    /* renamed from: a */
    final C1455a[] f9516a;

    /* renamed from: b */
    private volatile String f9517b;

    public C1487be(String str, Map<String, String> map) {
        ArrayList arrayList = new ArrayList(3);
        int indexOf = str.indexOf(43);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (indexOf >= 0) {
            int m11555a = C1496bn.m11555a(str, i2, indexOf) + i3;
            if (indexOf > 0 && str.charAt(indexOf - 1) != '\\' && m11555a != 1) {
                String substring = str.substring(i, indexOf);
                if (substring.length() == 0) {
                    throw new IOException("empty AVA in RDN \"" + str + "\"");
                }
                arrayList.add(new C1455a(new StringReader(substring), map));
                i = indexOf + 1;
                m11555a = 0;
            }
            i2 = indexOf + 1;
            indexOf = str.indexOf(43, i2);
            i3 = m11555a;
        }
        String substring2 = str.substring(i);
        if (substring2.length() == 0) {
            throw new IOException("empty AVA in RDN \"" + str + "\"");
        }
        arrayList.add(new C1455a(new StringReader(substring2), map));
        this.f9516a = (C1455a[]) arrayList.toArray(new C1455a[arrayList.size()]);
    }

    C1487be(C1450m c1450m) {
        if (c1450m.f9357c != 49) {
            throw new IOException("X500 RDN");
        }
        C1450m[] m11368b = new C1448k(c1450m.m11440u()).m11368b(5);
        this.f9516a = new C1455a[m11368b.length];
        for (int i = 0; i < m11368b.length; i++) {
            this.f9516a[i] = new C1455a(m11368b[i]);
        }
    }

    C1487be(int i) {
        this.f9516a = new C1455a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1487be)) {
            return false;
        }
        C1487be c1487be = (C1487be) obj;
        if (this.f9516a.length == c1487be.f9516a.length) {
            return m11536a(true).equals(c1487be.m11536a(true));
        }
        return false;
    }

    public int hashCode() {
        return m11536a(true).hashCode();
    }

    /* renamed from: a */
    void m11537a(C1449l c1449l) {
        c1449l.m11390a((byte) 49, this.f9516a);
    }

    public String toString() {
        if (this.f9516a.length == 1) {
            return this.f9516a[0].toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f9516a.length; i++) {
            if (i != 0) {
                sb.append(" + ");
            }
            sb.append(this.f9516a[i].toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m11535a(Map<String, String> map) {
        return m11534a(false, map);
    }

    /* renamed from: a */
    public String m11536a(boolean z) {
        if (!z) {
            return m11534a(false, Collections.emptyMap());
        }
        String str = this.f9517b;
        if (str == null) {
            String m11534a = m11534a(true, Collections.emptyMap());
            this.f9517b = m11534a;
            return m11534a;
        }
        return str;
    }

    /* renamed from: a */
    private String m11534a(boolean z, Map<String, String> map) {
        if (this.f9516a.length == 1) {
            return z ? this.f9516a[0].m11472b() : this.f9516a[0].m11470a(map);
        }
        C1455a[] c1455aArr = this.f9516a;
        if (z) {
            c1455aArr = (C1455a[]) this.f9516a.clone();
            Arrays.sort(c1455aArr, C1482b.m11526a());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c1455aArr.length; i++) {
            if (i > 0) {
                sb.append("+");
            }
            sb.append(z ? c1455aArr[i].m11472b() : c1455aArr[i].m11470a(map));
        }
        return sb.toString();
    }
}
