package p165d.p167b.p173f;

import android.provider.Contacts;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificateExtensions.java */
/* renamed from: d.b.f.o */
/* loaded from: classes.dex */
public class C1515o implements InterfaceC1513m<C1463ah> {

    /* renamed from: d */
    private Map<String, C1463ah> f9722d;

    /* renamed from: b */
    private static final C1444g f9720b = C1444g.m11327a("x509");

    /* renamed from: a */
    private static Class[] f9719a = {Boolean.class, Object.class};

    /* renamed from: c */
    private Map<String, C1463ah> f9721c = Collections.synchronizedMap(new TreeMap());

    /* renamed from: e */
    private boolean f9723e = false;

    public C1515o() {
    }

    public C1515o(C1448k c1448k) {
        m11664a(c1448k);
    }

    /* renamed from: a */
    private void m11664a(C1448k c1448k) {
        for (C1450m c1450m : c1448k.m11364a(5)) {
            m11665a(new C1463ah(c1450m));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m11665a(C1463ah c1463ah) {
        try {
            Class<?> m11520a = C1478aw.m11520a(c1463ah.m11489c());
            if (m11520a == null) {
                if (c1463ah.m11491e()) {
                    this.f9723e = true;
                }
                if (this.f9721c.put(c1463ah.m11489c().toString(), c1463ah) != null) {
                    throw new IOException("Duplicate extensions not allowed");
                }
                return;
            }
            InterfaceC1513m interfaceC1513m = (InterfaceC1513m) m11520a.getConstructor(f9719a).newInstance(Boolean.valueOf(c1463ah.m11491e()), c1463ah.m11490d());
            if (this.f9721c.put(interfaceC1513m.mo11473a(), (C1463ah) interfaceC1513m) != null) {
                throw new IOException("Duplicate extensions not allowed");
            }
        } catch (IOException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            Throwable targetException = e3.getTargetException();
            if (!c1463ah.m11491e()) {
                if (this.f9722d == null) {
                    this.f9722d = new TreeMap();
                }
                this.f9722d.put(c1463ah.m11489c().toString(), new C1495bm(c1463ah, targetException));
                if (f9720b != null) {
                    f9720b.m11333c("Error parsing extension: " + c1463ah);
                    targetException.printStackTrace();
                    System.err.println(new C1420b().m11234b(c1463ah.m11490d()));
                    return;
                }
                return;
            }
            if (targetException instanceof IOException) {
                throw ((IOException) targetException);
            }
            throw new IOException(targetException);
        } catch (Exception e4) {
            throw new IOException(e4);
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        m11667a(outputStream, false);
    }

    /* renamed from: a */
    public void m11667a(OutputStream outputStream, boolean z) {
        C1449l c1449l;
        C1449l c1449l2 = new C1449l();
        Object[] array = this.f9721c.values().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < array.length) {
                if (array[i2] instanceof InterfaceC1513m) {
                    ((InterfaceC1513m) array[i2]).mo11475a(c1449l2);
                } else if (array[i2] instanceof C1463ah) {
                    ((C1463ah) array[i2]).m11488a(c1449l2);
                } else {
                    throw new CertificateException("Illegal extension object");
                }
                i = i2 + 1;
            } else {
                C1449l c1449l3 = new C1449l();
                c1449l3.m11388a((byte) 48, c1449l2);
                if (z) {
                    c1449l = c1449l3;
                } else {
                    c1449l = new C1449l();
                    c1449l.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 3), c1449l3);
                }
                outputStream.write(c1449l.toByteArray());
                return;
            }
        }
    }

    /* renamed from: a */
    public void m11668a(String str, Object obj) {
        if (obj instanceof C1463ah) {
            this.f9721c.put(str, (C1463ah) obj);
            return;
        }
        throw new IOException("Unknown extension type.");
    }

    /* renamed from: a */
    public C1463ah m11666a(String str) {
        C1463ah c1463ah = this.f9721c.get(str);
        if (c1463ah == null) {
            throw new IOException("No extension found with name " + str);
        }
        return c1463ah;
    }

    /* renamed from: b */
    C1463ah m11669b(String str) {
        return this.f9721c.get(str);
    }

    /* renamed from: b */
    public Collection<C1463ah> m11670b() {
        return this.f9721c.values();
    }

    /* renamed from: c */
    public Map<String, C1463ah> m11671c() {
        return this.f9722d == null ? Collections.emptyMap() : this.f9722d;
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return Contacts.People.Extensions.CONTENT_DIRECTORY;
    }

    /* renamed from: d */
    public boolean m11672d() {
        return this.f9723e;
    }

    public boolean equals(Object obj) {
        Object[] array;
        int length;
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1515o) && (length = (array = ((C1515o) obj).m11670b().toArray()).length) == this.f9721c.size()) {
            String str = null;
            for (int i = 0; i < length; i++) {
                if (array[i] instanceof InterfaceC1513m) {
                    str = ((InterfaceC1513m) array[i]).mo11473a();
                }
                C1463ah c1463ah = (C1463ah) array[i];
                if (str == null) {
                    str = c1463ah.m11489c().toString();
                }
                C1463ah c1463ah2 = this.f9721c.get(str);
                if (c1463ah2 == null || !c1463ah2.equals(c1463ah)) {
                    return false;
                }
            }
            return m11671c().equals(((C1515o) obj).m11671c());
        }
        return false;
    }

    public int hashCode() {
        return this.f9721c.hashCode() + m11671c().hashCode();
    }

    public String toString() {
        return this.f9721c.toString();
    }
}
