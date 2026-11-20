package p046b.p047a.p050c.p053b;

import com.p129f.p130a.p131a.C1124s;
import com.p129f.p130a.p133c.C1154ag;
import com.p129f.p130a.p133c.InterfaceC1164aq;
import com.srizwan.apktool.R;
import java.util.List;
import java.util.Map;
import p046b.p047a.p050c.p055d.C0516b;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3249i;

/* compiled from: StyledString.java */
/* renamed from: b.a.c.b.k */
/* loaded from: classes.dex */
public class C0511k {

    /* renamed from: c */
    private static InterfaceC0541f f3559c;

    /* renamed from: a */
    private final String f3560a;

    /* renamed from: b */
    private final List<b> f3561b;

    public C0511k(String str, List<b> list, InterfaceC0541f interfaceC0541f) {
        this.f3560a = str;
        this.f3561b = list;
        f3559c = interfaceC0541f;
    }

    /* renamed from: b */
    String m3852b() {
        return this.f3560a;
    }

    /* renamed from: c */
    List<b> m3853c() {
        return this.f3561b;
    }

    public String toString() {
        return new a().m3855a(this);
    }

    /* compiled from: StyledString.java */
    /* renamed from: b.a.c.b.k$b */
    public static class b implements Comparable<b> {

        /* renamed from: a */
        private static final C1124s.a f3565a = C1124s.m9565a(';').m9573a().m9572a(C1124s.m9565a('=').m9574a(2));

        /* renamed from: b */
        private final String f3566b;

        /* renamed from: c */
        private final int f3567c;

        /* renamed from: d */
        private final int f3568d;

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            return m3857a(bVar);
        }

        public b(String str, int i, int i2) {
            this.f3566b = str;
            this.f3567c = i;
            this.f3568d = i2;
        }

        /* renamed from: a */
        public int m3856a() {
            return this.f3567c;
        }

        /* renamed from: b */
        public int m3858b() {
            return this.f3568d;
        }

        /* renamed from: c */
        public String m3859c() {
            int indexOf = this.f3566b.indexOf(59);
            return indexOf == -1 ? this.f3566b : this.f3566b.substring(0, indexOf);
        }

        /* renamed from: d */
        public Map<String, String> m3860d() {
            int indexOf = this.f3566b.indexOf(59);
            if (indexOf == -1) {
                return (Map) null;
            }
            return f3565a.m9580a(this.f3566b.substring(indexOf + 1, this.f3566b.endsWith(";") ? this.f3566b.length() - 1 : this.f3566b.length()));
        }

        /* renamed from: a */
        public int m3857a(b bVar) {
            int compare = Integer.compare(this.f3567c, bVar.f3567c);
            if (compare == 0) {
                int compare2 = Integer.compare(this.f3568d, bVar.f3568d);
                if (compare2 != 0) {
                    return -compare2;
                }
                return -this.f3566b.compareTo(bVar.f3566b);
            }
            return compare;
        }
    }

    /* compiled from: StyledString.java */
    /* renamed from: b.a.c.b.k$a */
    private static class a {

        /* renamed from: a */
        private String f3562a;

        /* renamed from: b */
        private StringBuilder f3563b;

        /* renamed from: c */
        private int f3564c;

        /* renamed from: a */
        String m3855a(C0511k c0511k) {
            this.f3562a = c0511k.m3852b();
            this.f3563b = new StringBuilder(this.f3562a.length() * 2);
            this.f3564c = 0;
            InterfaceC1164aq<b> m9901e = C1154ag.m9901e(c0511k.m3853c().iterator());
            while (m9901e.hasNext()) {
                m3854a(m9901e);
            }
            if (this.f3564c < this.f3562a.length()) {
                this.f3563b.append(C0516b.m3870a(this.f3562a.substring(this.f3564c)));
            }
            return this.f3563b.toString();
        }

        /* renamed from: a */
        private void m3854a(InterfaceC1164aq<b> interfaceC1164aq) {
            b next = interfaceC1164aq.next();
            String m3859c = next.m3859c();
            Map<String, String> m3860d = next.m3860d();
            int m3856a = next.m3856a();
            int m3858b = next.m3858b() + 1;
            int length = m3858b > this.f3562a.length() ? this.f3562a.length() : m3858b;
            if (m3856a > this.f3564c) {
                this.f3563b.append(C0516b.m3870a(this.f3562a.substring(this.f3564c, m3856a)));
            }
            this.f3564c = m3856a;
            if (C3080al.m18585b(C3249i.f19543c, m3859c)) {
                this.f3563b.append('<').append(m3859c);
                if (m3860d != null) {
                    for (Map.Entry<String, String> entry : m3860d.entrySet()) {
                        this.f3563b.append(' ').append(entry.getKey()).append("=\"").append(C0516b.m3870a(entry.getValue())).append('\"');
                    }
                }
                if (m3856a == length) {
                    this.f3563b.append("/>");
                    return;
                }
                this.f3563b.append('>');
                while (interfaceC1164aq.hasNext() && interfaceC1164aq.mo9907a().m3856a() < length) {
                    m3854a(interfaceC1164aq);
                }
                if (length > this.f3564c && this.f3562a.length() >= length) {
                    this.f3563b.append(C0516b.m3870a(this.f3562a.substring(this.f3564c, length)));
                } else if (this.f3562a.length() >= this.f3564c && this.f3562a.length() < length) {
                    C0511k.f3559c.mo3983c(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Span (").append(m3859c).toString()).append(") exceeds text length ").toString()).append(this.f3562a.length()).toString());
                    this.f3563b.append(C0516b.m3870a(this.f3562a.substring(this.f3564c)));
                }
                this.f3564c = length;
                this.f3563b.append("</").append(m3859c).append('>');
            }
        }
    }
}
