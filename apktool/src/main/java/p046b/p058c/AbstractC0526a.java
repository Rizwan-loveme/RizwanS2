package p046b.p058c;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p046b.p059d.C0543h;

/* compiled from: AbstractDirectory.java */
/* renamed from: b.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0526a implements InterfaceC0528c {

    /* renamed from: a */
    protected Set<String> f3617a;

    /* renamed from: b */
    protected Set<String> f3618b;

    /* renamed from: c */
    protected Map<String, AbstractC0526a> f3619c;

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: d */
    public void mo3924d() {
    }

    /* renamed from: e */
    protected abstract void mo3926e();

    /* renamed from: f */
    protected abstract void mo3928f();

    /* renamed from: i */
    protected abstract InputStream mo3931i(String str);

    /* renamed from: j */
    protected abstract OutputStream mo3932j(String str);

    /* renamed from: k */
    protected abstract AbstractC0526a mo3933k(String str);

    /* renamed from: l */
    protected abstract void mo3934l(String str);

    /* renamed from: m */
    protected abstract File mo3935m(String str);

    /* renamed from: a */
    public Set<String> m3907a() {
        return mo3908a(false);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public Set<String> mo3908a(boolean z) {
        if (this.f3617a == null) {
            mo3926e();
        }
        if (!z) {
            return this.f3617a;
        }
        if (this.f3618b == null) {
            this.f3618b = new LinkedHashSet(this.f3617a);
            for (Map.Entry<String, AbstractC0526a> entry : m3921c().entrySet()) {
                Iterator<String> it = entry.getValue().mo3908a(true).iterator();
                while (it.hasNext()) {
                    this.f3618b.add(new StringBuffer().append(new StringBuffer().append(entry.getKey()).append('/').toString()).append(it.next()).toString());
                }
            }
        }
        return this.f3618b;
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public boolean mo3916a(String str) {
        try {
            b m3905r = m3905r(str);
            if (m3905r.f3623a != null) {
                return m3905r.f3623a.mo3916a(m3905r.f3624b);
            }
            return m3907a().contains(m3905r.f3624b);
        } catch (C0533h e2) {
            return false;
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: b */
    public boolean mo3919b(String str) {
        try {
            b m3905r = m3905r(str);
            if (m3905r.f3623a != null) {
                return m3905r.f3623a.mo3919b(m3905r.f3624b);
            }
            return m3921c().containsKey(m3905r.f3624b);
        } catch (C0533h e2) {
            return false;
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: b */
    public Map<String, InterfaceC0528c> mo3917b() {
        return m3918b(false);
    }

    /* renamed from: b */
    public Map<String, InterfaceC0528c> m3918b(boolean z) {
        return new LinkedHashMap(m3922c(z));
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: c */
    public InputStream mo3920c(String str) {
        b m3905r = m3905r(str);
        if (m3905r.f3623a != null) {
            return m3905r.f3623a.mo3920c(m3905r.f3624b);
        }
        if (!m3907a().contains(m3905r.f3624b)) {
            throw new C0533h(str);
        }
        return mo3931i(m3905r.f3624b);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: d */
    public OutputStream mo3923d(String str) {
        AbstractC0526a abstractC0526a;
        a m3906s = m3906s(str);
        if (m3906s.f3620a == null) {
            m3907a().add(m3906s.f3621b);
            return mo3932j(m3906s.f3621b);
        }
        try {
            abstractC0526a = mo3927f(m3906s.f3620a);
        } catch (C0532g e2) {
            abstractC0526a = m3921c().get(m3906s.f3620a);
        }
        return abstractC0526a.mo3923d(m3906s.f3621b);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: e */
    public InterfaceC0528c mo3925e(String str) {
        b m3905r = m3905r(str);
        if (m3905r.f3623a != null) {
            return m3905r.f3623a.mo3925e(m3905r.f3624b);
        }
        if (!m3921c().containsKey(m3905r.f3624b)) {
            throw new C0533h(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append(", ").toString()).append(String.valueOf(m3905r.f3623a)).toString()).append(", ").toString()).append(String.valueOf(m3905r.f3624b)).toString());
        }
        return m3921c().get(m3905r.f3624b);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: f */
    public InterfaceC0528c mo3927f(String str) {
        AbstractC0526a mo3933k;
        a m3906s = m3906s(str);
        if (m3906s.f3620a == null) {
            if (m3921c().containsKey(m3906s.f3621b)) {
                throw new C0532g(str);
            }
            AbstractC0526a mo3933k2 = mo3933k(m3906s.f3621b);
            m3921c().put(m3906s.f3621b, mo3933k2);
            return mo3933k2;
        }
        if (m3921c().containsKey(m3906s.f3620a)) {
            mo3933k = m3921c().get(m3906s.f3620a);
        } else {
            mo3933k = mo3933k(m3906s.f3620a);
            m3921c().put(m3906s.f3620a, mo3933k);
        }
        return mo3933k.mo3927f(m3906s.f3621b);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: g */
    public boolean mo3929g(String str) {
        try {
            b m3905r = m3905r(str);
            if (m3905r.f3623a != null) {
                return m3905r.f3623a.mo3929g(m3905r.f3624b);
            }
            if (!m3907a().contains(m3905r.f3624b)) {
                return false;
            }
            mo3934l(m3905r.f3624b);
            m3907a().remove(m3905r.f3624b);
            return true;
        } catch (C0533h e2) {
            return false;
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3909a(InterfaceC0528c interfaceC0528c) {
        C0527b.m3938a(this, interfaceC0528c);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3910a(File file) {
        C0527b.m3940a(this, file);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3914a(File file, String[] strArr) {
        C0527b.m3944a(this, file, strArr);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3912a(File file, String str) {
        C0527b.m3942a(this, file, str);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3911a(File file, C0543h c0543h) {
        C0527b.m3941a(this, file, c0543h);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3915a(File file, String[] strArr, C0543h c0543h) {
        C0527b.m3945a(this, file, strArr, c0543h);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: a */
    public void mo3913a(File file, String str, C0543h c0543h) {
        C0527b.m3943a(this, file, str, c0543h);
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: h */
    public int mo3930h(String str) {
        return -1;
    }

    /* renamed from: c */
    protected Map<String, AbstractC0526a> m3921c() {
        return m3922c(false);
    }

    /* renamed from: c */
    protected Map<String, AbstractC0526a> m3922c(boolean z) {
        if (this.f3619c == null) {
            mo3928f();
        }
        if (!z) {
            return this.f3619c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f3619c);
        for (Map.Entry<String, AbstractC0526a> entry : m3921c().entrySet()) {
            for (Map.Entry<String, AbstractC0526a> entry2 : entry.getValue().m3922c(true).entrySet()) {
                linkedHashMap.put(new StringBuffer().append(new StringBuffer().append(entry.getKey()).append('/').toString()).append(entry2.getKey()).toString(), entry2.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: r */
    private b m3905r(String str) {
        a m3906s = m3906s(str);
        if (m3906s.f3620a == null) {
            return new b(this, (AbstractC0526a) null, m3906s.f3621b);
        }
        if (!m3921c().containsKey(m3906s.f3620a)) {
            throw new C0533h(str);
        }
        return new b(this, m3921c().get(m3906s.f3620a), m3906s.f3621b);
    }

    /* renamed from: s */
    private a m3906s(String str) {
        int indexOf = str.indexOf(47);
        return indexOf == -1 ? new a(this, (String) null, str) : new a(this, str.substring(0, indexOf), str.substring(indexOf + 1));
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: n */
    public File mo3936n(String str) {
        return mo3935m(str);
    }

    /* compiled from: AbstractDirectory.java */
    /* renamed from: b.c.a$a */
    private class a {

        /* renamed from: a */
        public String f3620a;

        /* renamed from: b */
        public String f3621b;

        /* renamed from: c */
        private final AbstractC0526a f3622c;

        public a(AbstractC0526a abstractC0526a, String str, String str2) {
            this.f3622c = abstractC0526a;
            this.f3620a = str;
            this.f3621b = str2;
        }
    }

    /* compiled from: AbstractDirectory.java */
    /* renamed from: b.c.a$b */
    private class b {

        /* renamed from: a */
        public AbstractC0526a f3623a;

        /* renamed from: b */
        public String f3624b;

        /* renamed from: c */
        private final AbstractC0526a f3625c;

        public b(AbstractC0526a abstractC0526a, AbstractC0526a abstractC0526a2, String str) {
            this.f3625c = abstractC0526a;
            this.f3623a = abstractC0526a2;
            this.f3624b = str;
        }
    }
}
