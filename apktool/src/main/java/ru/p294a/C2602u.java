package ru.p294a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import ru.p294a.C2585d;

/* compiled from: ZipEntry.java */
/* renamed from: ru.a.u */
/* loaded from: classes.dex */
public class C2602u extends ZipEntry implements Cloneable {

    /* renamed from: a */
    private static final byte[] f13477a = new byte[0];

    /* renamed from: l */
    private static final InterfaceC2603v[] f13478l = new InterfaceC2603v[0];

    /* renamed from: b */
    private int f13479b;

    /* renamed from: c */
    private long f13480c;

    /* renamed from: d */
    private int f13481d;

    /* renamed from: e */
    private int f13482e;

    /* renamed from: f */
    private long f13483f;

    /* renamed from: g */
    private InterfaceC2603v[] f13484g;

    /* renamed from: h */
    private C2593l f13485h;

    /* renamed from: i */
    private String f13486i;

    /* renamed from: j */
    private byte[] f13487j;

    /* renamed from: k */
    private C2587f f13488k;

    public C2602u(String str) {
        super(str);
        this.f13479b = -1;
        this.f13480c = -1;
        this.f13481d = 0;
        this.f13482e = 0;
        this.f13483f = 0;
        this.f13485h = (C2593l) null;
        this.f13486i = (String) null;
        this.f13487j = (byte[]) null;
        this.f13488k = new C2587f();
        m16131a(str);
    }

    public C2602u(ZipEntry zipEntry) {
        super(zipEntry);
        this.f13479b = -1;
        this.f13480c = -1;
        this.f13481d = 0;
        this.f13482e = 0;
        this.f13483f = 0;
        this.f13485h = (C2593l) null;
        this.f13486i = (String) null;
        this.f13487j = (byte[]) null;
        this.f13488k = new C2587f();
        m16131a(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            m16137a(C2585d.m16074a(extra, true, C2585d.a.f13427c));
        } else {
            m16144d();
        }
        setMethod(zipEntry.getMethod());
        this.f13480c = zipEntry.getSize();
    }

    protected C2602u() {
        this("");
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        C2602u c2602u = (C2602u) super.clone();
        c2602u.m16129a(m16128a());
        c2602u.m16130a(m16139b());
        c2602u.m16137a(m16127m());
        return c2602u;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.f13479b;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("ZIP compression method can not be negative: ").append(i).toString());
        }
        this.f13479b = i;
    }

    /* renamed from: a */
    public int m16128a() {
        return this.f13481d;
    }

    /* renamed from: a */
    public void m16129a(int i) {
        this.f13481d = i;
    }

    /* renamed from: b */
    public long m16139b() {
        return this.f13483f;
    }

    /* renamed from: a */
    public void m16130a(long j) {
        this.f13483f = j;
    }

    /* renamed from: c */
    public int m16143c() {
        return this.f13482e;
    }

    /* renamed from: b */
    protected void m16141b(int i) {
        this.f13482e = i;
    }

    /* renamed from: a */
    public void m16137a(InterfaceC2603v[] interfaceC2603vArr) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2603v interfaceC2603v : interfaceC2603vArr) {
            if (interfaceC2603v instanceof C2593l) {
                this.f13485h = (C2593l) interfaceC2603v;
            } else {
                arrayList.add(interfaceC2603v);
            }
        }
        this.f13484g = (InterfaceC2603v[]) arrayList.toArray(new InterfaceC2603v[0]);
        m16144d();
    }

    /* renamed from: a */
    public InterfaceC2603v[] m16138a(boolean z) {
        return z ? m16126l() : m16123i();
    }

    /* renamed from: h */
    private InterfaceC2603v[] m16122h() {
        return this.f13484g == null ? f13478l : this.f13484g;
    }

    /* renamed from: i */
    private InterfaceC2603v[] m16123i() {
        InterfaceC2603v[] m16122h = m16122h();
        return m16122h == this.f13484g ? m16121b(m16122h) : m16122h;
    }

    /* renamed from: b */
    private InterfaceC2603v[] m16121b(InterfaceC2603v[] interfaceC2603vArr) {
        return m16120a(interfaceC2603vArr, interfaceC2603vArr.length);
    }

    /* renamed from: a */
    private InterfaceC2603v[] m16120a(InterfaceC2603v[] interfaceC2603vArr, int i) {
        InterfaceC2603v[] interfaceC2603vArr2 = new InterfaceC2603v[i];
        System.arraycopy(interfaceC2603vArr, 0, interfaceC2603vArr2, 0, Math.min(interfaceC2603vArr.length, i));
        return interfaceC2603vArr2;
    }

    /* renamed from: j */
    private InterfaceC2603v[] m16124j() {
        InterfaceC2603v[] m16120a = m16120a(this.f13484g, this.f13484g.length + 1);
        m16120a[this.f13484g.length] = this.f13485h;
        return m16120a;
    }

    /* renamed from: k */
    private InterfaceC2603v[] m16125k() {
        return this.f13485h == null ? f13478l : new InterfaceC2603v[]{this.f13485h};
    }

    /* renamed from: l */
    private InterfaceC2603v[] m16126l() {
        InterfaceC2603v[] m16127m = m16127m();
        return m16127m == this.f13484g ? m16121b(m16127m) : m16127m;
    }

    /* renamed from: m */
    private InterfaceC2603v[] m16127m() {
        if (this.f13484g == null) {
            return m16125k();
        }
        return this.f13485h != null ? m16124j() : this.f13484g;
    }

    /* renamed from: a */
    public void m16134a(InterfaceC2603v interfaceC2603v) {
        if (interfaceC2603v instanceof C2593l) {
            this.f13485h = (C2593l) interfaceC2603v;
        } else if (this.f13484g == null) {
            this.f13484g = new InterfaceC2603v[]{interfaceC2603v};
        } else {
            if (m16140b(interfaceC2603v.mo16060a()) != null) {
                m16135a(interfaceC2603v.mo16060a());
            }
            InterfaceC2603v[] m16120a = m16120a(this.f13484g, this.f13484g.length + 1);
            m16120a[this.f13484g.length] = interfaceC2603v;
            this.f13484g = m16120a;
        }
        m16144d();
    }

    /* renamed from: b */
    public void m16142b(InterfaceC2603v interfaceC2603v) {
        if (interfaceC2603v instanceof C2593l) {
            this.f13485h = (C2593l) interfaceC2603v;
        } else {
            if (m16140b(interfaceC2603v.mo16060a()) != null) {
                m16135a(interfaceC2603v.mo16060a());
            }
            InterfaceC2603v[] interfaceC2603vArr = this.f13484g;
            this.f13484g = new InterfaceC2603v[this.f13484g != null ? this.f13484g.length + 1 : 1];
            this.f13484g[0] = interfaceC2603v;
            if (interfaceC2603vArr != null) {
                System.arraycopy(interfaceC2603vArr, 0, this.f13484g, 1, this.f13484g.length - 1);
            }
        }
        m16144d();
    }

    /* renamed from: a */
    public void m16135a(C2607z c2607z) {
        if (this.f13484g == null) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2603v interfaceC2603v : this.f13484g) {
            if (!c2607z.equals(interfaceC2603v.mo16060a())) {
                arrayList.add(interfaceC2603v);
            }
        }
        if (this.f13484g.length == arrayList.size()) {
            throw new NoSuchElementException();
        }
        this.f13484g = (InterfaceC2603v[]) arrayList.toArray(new InterfaceC2603v[0]);
        m16144d();
    }

    /* renamed from: b */
    public InterfaceC2603v m16140b(C2607z c2607z) {
        if (this.f13484g != null) {
            for (InterfaceC2603v interfaceC2603v : this.f13484g) {
                if (c2607z.equals(interfaceC2603v.mo16060a())) {
                    return interfaceC2603v;
                }
            }
        }
        return (InterfaceC2603v) null;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) {
        try {
            m16119a(C2585d.m16074a(bArr, true, C2585d.a.f13427c), true);
        } catch (ZipException e2) {
            throw new RuntimeException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Error parsing extra fields for entry: ").append(getName()).toString()).append(" - ").toString()).append(e2.getMessage()).toString(), e2);
        }
    }

    /* renamed from: d */
    protected void m16144d() {
        super.setExtra(C2585d.m16073a(m16138a(true)));
    }

    /* renamed from: a */
    public void m16136a(byte[] bArr) {
        try {
            m16119a(C2585d.m16074a(bArr, false, C2585d.a.f13427c), false);
        } catch (ZipException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    /* renamed from: e */
    public byte[] m16145e() {
        byte[] extra = getExtra();
        return extra != null ? extra : f13477a;
    }

    /* renamed from: f */
    public byte[] m16146f() {
        return C2585d.m16075b(m16138a(true));
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        return this.f13486i == null ? super.getName() : this.f13486i;
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    /* renamed from: a */
    protected void m16131a(String str) {
        if (str == null) {
            str = "";
        }
        if (m16143c() == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.f13486i = str;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.f13480c;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid entry size");
        }
        this.f13480c = j;
    }

    /* renamed from: a */
    protected void m16132a(String str, byte[] bArr) {
        m16131a(str);
        this.f13487j = bArr;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    /* renamed from: g */
    public C2587f m16147g() {
        return this.f13488k;
    }

    /* renamed from: a */
    public void m16133a(C2587f c2587f) {
        this.f13488k = c2587f;
    }

    /* renamed from: a */
    private void m16119a(InterfaceC2603v[] interfaceC2603vArr, boolean z) {
        InterfaceC2603v m16140b;
        if (this.f13484g == null) {
            m16137a(interfaceC2603vArr);
            return;
        }
        for (InterfaceC2603v interfaceC2603v : interfaceC2603vArr) {
            if (interfaceC2603v instanceof C2593l) {
                m16140b = this.f13485h;
            } else {
                m16140b = m16140b(interfaceC2603v.mo16060a());
            }
            if (m16140b == null) {
                m16134a(interfaceC2603v);
            } else if (z || !(m16140b instanceof InterfaceC2584c)) {
                byte[] mo16049e = interfaceC2603v.mo16049e();
                m16140b.mo16045a(mo16049e, 0, mo16049e.length);
            } else {
                byte[] mo16047c = interfaceC2603v.mo16047c();
                ((InterfaceC2584c) m16140b).mo16070b(mo16047c, 0, mo16047c.length);
            }
        }
        m16144d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2602u c2602u = (C2602u) obj;
        String name = getName();
        String name2 = c2602u.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        String comment = getComment();
        String comment2 = c2602u.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return getTime() == c2602u.getTime() && comment.equals(comment2) && m16128a() == c2602u.m16128a() && m16143c() == c2602u.m16143c() && m16139b() == c2602u.m16139b() && getMethod() == c2602u.getMethod() && getSize() == c2602u.getSize() && getCrc() == c2602u.getCrc() && getCompressedSize() == c2602u.getCompressedSize() && Arrays.equals(m16146f(), c2602u.m16146f()) && Arrays.equals(m16145e(), c2602u.m16145e()) && this.f13488k.equals(c2602u.f13488k);
    }
}
