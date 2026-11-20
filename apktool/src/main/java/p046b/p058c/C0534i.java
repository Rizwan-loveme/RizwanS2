package p046b.p058c;

import java.p209io.BufferedInputStream;
import java.p209io.ByteArrayInputStream;
import java.p209io.File;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.util.C3249i;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: ZipRODirectory.java */
/* renamed from: b.c.i */
/* loaded from: classes.dex */
public class C0534i extends AbstractC0526a {

    /* renamed from: d */
    private C2604w f3628d;

    /* renamed from: e */
    private String f3629e;

    public C0534i(File file) {
        this(file, "");
    }

    public C0534i(File file, String str) {
        try {
            this.f3628d = new C2604w(file);
            this.f3629e = str;
        } catch (IOException e2) {
            throw new C0529d(e2);
        }
    }

    public C0534i(C2604w c2604w, String str) {
        this.f3628d = c2604w;
        this.f3629e = str;
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: m */
    protected File mo3935m(String str) {
        return (File) null;
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: k */
    protected AbstractC0526a mo3933k(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: i */
    protected InputStream mo3931i(String str) {
        InputStream inputStream;
        InputStream inputStream2 = (InputStream) null;
        try {
            try {
                C2604w m3959i = m3959i();
                C2602u m16162a = m3959i.m16162a(new StringBuffer().append(mo3949g()).append(str).toString());
                long size = m16162a.getSize();
                inputStream = new BufferedInputStream(m3959i.m16160a(m16162a), C3249i.m19500a());
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(size > ((long) 0) ? C1887e.m13979a(inputStream, size) : C1887e.m13984b(inputStream));
                    C1887e.m13970a(inputStream);
                    return byteArrayInputStream;
                } catch (IOException e2) {
                    e = e2;
                    throw new C0533h(str, e);
                }
            } catch (Throwable th) {
                th = th;
                C1887e.m13970a(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = inputStream2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
            C1887e.m13970a(inputStream);
            throw th;
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: o */
    public InputStream mo3950o(String str) {
        try {
            C2604w m3959i = m3959i();
            return new BufferedInputStream(m3959i.m16160a(m3959i.m16162a(new StringBuffer().append(mo3949g()).append(str).toString())), C3249i.m19500a());
        } catch (IOException e2) {
            throw new C0533h(str, e2);
        }
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: j */
    protected OutputStream mo3932j(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: f */
    protected void mo3928f() {
        m3958h();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: e */
    protected void mo3926e() {
        m3958h();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: l */
    protected void mo3934l(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: p */
    public long mo3951p(String str) {
        return m3960r(str).getSize();
    }

    @Override // p046b.p058c.AbstractC0526a, p046b.p058c.InterfaceC0528c
    /* renamed from: h */
    public int mo3930h(String str) {
        return m3960r(str).getMethod();
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: q */
    public long mo3952q(String str) {
        return this.f3628d.m16162a(new StringBuffer().append(this.f3629e).append(str).toString()).getTime();
    }

    /* renamed from: r */
    private C2602u m3960r(String str) {
        C2602u m16162a = this.f3628d.m16162a(str);
        if (m16162a == null) {
            throw new C0533h(new StringBuffer().append("Entry not found: ").append(str).toString());
        }
        return m16162a;
    }

    /* renamed from: h */
    private void m3958h() {
        String substring;
        this.f3617a = new LinkedHashSet();
        this.f3619c = new LinkedHashMap();
        int length = mo3949g().length();
        Enumeration<C2602u> m16163b = m3959i().m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (!name.equals(mo3949g()) && name.startsWith(mo3949g()) && !name.contains(new StringBuffer().append("..").append('/').toString())) {
                String substring2 = name.substring(length);
                int indexOf = substring2.indexOf(47);
                if (indexOf == -1) {
                    if (nextElement.isDirectory()) {
                        substring = substring2;
                    } else {
                        this.f3617a.add(substring2);
                    }
                } else {
                    substring = substring2.substring(0, indexOf);
                }
                if (!this.f3619c.containsKey(substring)) {
                    this.f3619c.put(substring, new C0534i(m3959i(), new StringBuffer().append(new StringBuffer().append(mo3949g()).append(substring).toString()).append('/').toString()));
                }
            }
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: g */
    public String mo3949g() {
        return this.f3629e;
    }

    /* renamed from: i */
    private C2604w m3959i() {
        return this.f3628d;
    }

    @Override // p046b.p058c.AbstractC0526a, p046b.p058c.InterfaceC0528c
    /* renamed from: d */
    public void mo3924d() {
        this.f3628d.close();
    }
}
