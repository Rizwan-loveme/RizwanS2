package p165d.p167b.p173f;

import java.net.URI;
import java.net.URISyntaxException;
import java.p209io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: URIName.java */
/* renamed from: d.b.f.bk */
/* loaded from: classes.dex */
public class C1493bk implements InterfaceC1466ak {

    /* renamed from: a */
    private String f9524a;

    /* renamed from: b */
    private C1457ab f9525b;

    /* renamed from: c */
    private C1470ao f9526c;

    /* renamed from: d */
    private URI f9527d;

    public C1493bk(C1450m c1450m) {
        this(c1450m.m11429j());
    }

    public C1493bk(String str) {
        try {
            this.f9527d = new URI(str);
            if (this.f9527d.getScheme() == null) {
                throw new IOException("URI name must include scheme:" + str);
            }
            this.f9524a = this.f9527d.getHost();
            if (this.f9524a != null) {
                if (this.f9524a.charAt(0) == '[') {
                    try {
                        this.f9526c = new C1470ao(this.f9524a.substring(1, this.f9524a.length() - 1));
                    } catch (IOException e2) {
                        throw new IOException("invalid URI name (host portion is not a valid IPv6 address):" + str);
                    }
                } else {
                    try {
                        this.f9525b = new C1457ab(this.f9524a);
                    } catch (IOException e3) {
                        try {
                            this.f9526c = new C1470ao(this.f9524a);
                        } catch (Exception e4) {
                            throw new IOException("invalid URI name (host portion is not a valid DNS name, IPv4 address, or IPv6 address):" + str);
                        }
                    }
                }
            }
        } catch (URISyntaxException e5) {
            throw ((IOException) new IOException("invalid URI name:" + str).initCause(e5));
        }
    }

    /* renamed from: a */
    public static C1493bk m11548a(C1450m c1450m) {
        C1457ab c1457ab;
        String m11429j = c1450m.m11429j();
        try {
            URI uri = new URI(m11429j);
            if (uri.getScheme() == null) {
                String schemeSpecificPart = uri.getSchemeSpecificPart();
                try {
                    if (schemeSpecificPart.startsWith(".")) {
                        c1457ab = new C1457ab(schemeSpecificPart.substring(1));
                    } else {
                        c1457ab = new C1457ab(schemeSpecificPart);
                    }
                    return new C1493bk(uri, schemeSpecificPart, c1457ab);
                } catch (IOException e2) {
                    throw ((IOException) new IOException("invalid URI name constraint:" + m11429j).initCause(e2));
                }
            }
            throw new IOException("invalid URI name constraint (should not include scheme):" + m11429j);
        } catch (URISyntaxException e3) {
            throw ((IOException) new IOException("invalid URI name constraint:" + m11429j).initCause(e3));
        }
    }

    C1493bk(URI uri, String str, C1457ab c1457ab) {
        this.f9527d = uri;
        this.f9524a = str;
        this.f9525b = c1457ab;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 6;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        c1449l.m11403b(this.f9527d.toASCIIString());
    }

    public String toString() {
        return "URIName: " + this.f9527d.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1493bk)) {
            return false;
        }
        return this.f9527d.equals(((C1493bk) obj).m11552e());
    }

    /* renamed from: e */
    public URI m11552e() {
        return this.f9527d;
    }

    /* renamed from: d */
    public String m11551d() {
        return this.f9527d.toString();
    }

    /* renamed from: a */
    public String m11549a() {
        return this.f9524a;
    }

    /* renamed from: c */
    public Object m11550c() {
        return this.f9526c != null ? this.f9526c : this.f9525b;
    }

    public int hashCode() {
        return this.f9527d.hashCode();
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 6) {
            return -1;
        }
        String m11549a = ((C1493bk) interfaceC1466ak).m11549a();
        if (m11549a.equalsIgnoreCase(this.f9524a)) {
            return 0;
        }
        Object m11550c = ((C1493bk) interfaceC1466ak).m11550c();
        if (this.f9525b == null || !(m11550c instanceof C1457ab)) {
            return 3;
        }
        boolean z = this.f9524a.charAt(0) == '.';
        boolean z2 = m11549a.charAt(0) == '.';
        int mo11477a = this.f9525b.mo11477a((C1457ab) m11550c);
        if (!z && !z2 && (mo11477a == 2 || mo11477a == 1)) {
            mo11477a = 3;
        }
        if (z == z2 || mo11477a != 0) {
            return mo11477a;
        }
        return z ? 2 : 1;
    }
}
