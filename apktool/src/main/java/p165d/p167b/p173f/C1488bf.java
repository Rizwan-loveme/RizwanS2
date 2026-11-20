package p165d.p167b.p173f;

import java.io.IOException;
import java.util.Locale;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: RFC822Name.java */
/* renamed from: d.b.f.bf */
/* loaded from: classes.dex */
public class C1488bf implements InterfaceC1466ak {

    /* renamed from: a */
    private String f9518a;

    public C1488bf(C1450m c1450m) {
        this.f9518a = c1450m.m11429j();
        m11539a(this.f9518a);
    }

    /* renamed from: a */
    public void m11539a(String str) {
        if (str == null || str.length() == 0) {
            throw new IOException("RFC822Name may not be null or empty");
        }
        String substring = str.substring(str.indexOf(64) + 1);
        if (substring.length() == 0) {
            throw new IOException("RFC822Name may not end with @");
        }
        if (substring.startsWith(".") && substring.length() == 1) {
            throw new IOException("RFC822Name domain may not be just .");
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 1;
    }

    /* renamed from: a */
    public String m11538a() {
        return this.f9518a;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        c1449l.m11403b(this.f9518a);
    }

    public String toString() {
        return "RFC822Name: " + this.f9518a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1488bf)) {
            return false;
        }
        return this.f9518a.equalsIgnoreCase(((C1488bf) obj).f9518a);
    }

    public int hashCode() {
        return this.f9518a.toUpperCase().hashCode();
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 1) {
            return -1;
        }
        String lowerCase = ((C1488bf) interfaceC1466ak).m11538a().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = this.f9518a.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals(lowerCase2)) {
            return 0;
        }
        if (lowerCase2.endsWith(lowerCase)) {
            if (lowerCase.indexOf(64) != -1) {
                return 3;
            }
            if (!lowerCase.startsWith(".") && lowerCase2.charAt(lowerCase2.lastIndexOf(lowerCase) - 1) != '@') {
                return 3;
            }
            return 2;
        }
        if (lowerCase.endsWith(lowerCase2) && lowerCase2.indexOf(64) == -1) {
            if (!lowerCase2.startsWith(".") && lowerCase.charAt(lowerCase.lastIndexOf(lowerCase2) - 1) != '@') {
                return 3;
            }
            return 1;
        }
        return 3;
    }
}
