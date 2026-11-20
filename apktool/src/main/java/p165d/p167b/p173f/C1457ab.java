package p165d.p167b.p173f;

import java.io.IOException;
import java.util.Locale;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: DNSName.java */
/* renamed from: d.b.f.ab */
/* loaded from: classes.dex */
public class C1457ab implements InterfaceC1466ak {

    /* renamed from: a */
    private String f9385a;

    public C1457ab(C1450m c1450m) {
        this.f9385a = c1450m.m11429j();
    }

    public C1457ab(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            throw new IOException("DNS name must not be null");
        }
        if (str.indexOf(32) != -1) {
            throw new IOException("DNS names or NameConstraints with blank components are not permitted");
        }
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') {
            throw new IOException("DNS names or NameConstraints may not begin or end with a .");
        }
        while (i < str.length()) {
            int indexOf = str.indexOf(46, i);
            indexOf = indexOf < 0 ? str.length() : indexOf;
            if (indexOf - i < 1) {
                throw new IOException("DNSName SubjectAltNames with empty components are not permitted");
            }
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(str.charAt(i)) < 0) {
                throw new IOException("DNSName components must begin with a letter");
            }
            for (int i2 = i + 1; i2 < indexOf; i2++) {
                if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-".indexOf(str.charAt(i2)) < 0) {
                    throw new IOException("DNSName components must consist of letters, digits, and hyphens");
                }
            }
            i = indexOf + 1;
        }
        this.f9385a = str;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 2;
    }

    /* renamed from: a */
    public String m11478a() {
        return this.f9385a;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        c1449l.m11403b(this.f9385a);
    }

    public String toString() {
        return "DNSName: " + this.f9385a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1457ab)) {
            return false;
        }
        return this.f9385a.equalsIgnoreCase(((C1457ab) obj).f9385a);
    }

    public int hashCode() {
        return this.f9385a.toUpperCase().hashCode();
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 2) {
            return -1;
        }
        String lowerCase = ((C1457ab) interfaceC1466ak).m11478a().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = this.f9385a.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals(lowerCase2)) {
            return 0;
        }
        return lowerCase2.endsWith(lowerCase) ? lowerCase2.charAt(lowerCase2.lastIndexOf(lowerCase) + (-1)) == '.' ? 2 : 3 : (lowerCase.endsWith(lowerCase2) && lowerCase.charAt(lowerCase.lastIndexOf(lowerCase2) + (-1)) == '.') ? 1 : 3;
    }
}
