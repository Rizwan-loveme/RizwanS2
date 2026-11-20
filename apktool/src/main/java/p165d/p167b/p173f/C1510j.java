package p165d.p167b.p173f;

import android.bluetooth.BluetoothHidDevice;
import java.lang.reflect.InvocationTargetException;
import java.p209io.IOException;
import java.p209io.OutputStream;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CRLExtensions.java */
/* renamed from: d.b.f.j */
/* loaded from: classes.dex */
public class C1510j {

    /* renamed from: a */
    private static final Class[] f9711a = {Boolean.class, Object.class};

    /* renamed from: b */
    private Map<String, C1463ah> f9712b = Collections.synchronizedMap(new TreeMap());

    /* renamed from: c */
    private boolean f9713c = false;

    public C1510j() {
    }

    public C1510j(C1448k c1448k) {
        m11652a(c1448k);
    }

    /* renamed from: a */
    private void m11652a(C1448k c1448k) {
        try {
            byte m11380l = (byte) c1448k.m11380l();
            if ((m11380l & BluetoothHidDevice.SUBCLASS1_COMBO) == 128 && (m11380l & 31) == 0) {
                c1448k = c1448k.m11371d().f9356b;
            }
            for (C1450m c1450m : c1448k.m11364a(5)) {
                m11653a(new C1463ah(c1450m));
            }
        } catch (IOException e2) {
            throw new CRLException("Parsing error: " + e2.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m11653a(C1463ah c1463ah) {
        try {
            Class<?> m11520a = C1478aw.m11520a(c1463ah.m11489c());
            if (m11520a == null) {
                if (c1463ah.m11491e()) {
                    this.f9713c = true;
                }
                if (this.f9712b.put(c1463ah.m11489c().toString(), c1463ah) != null) {
                    throw new CRLException("Duplicate extensions not allowed");
                }
                return;
            }
            InterfaceC1513m interfaceC1513m = (InterfaceC1513m) m11520a.getConstructor(f9711a).newInstance(Boolean.valueOf(c1463ah.m11491e()), c1463ah.m11490d());
            if (this.f9712b.put(interfaceC1513m.mo11473a(), (C1463ah) interfaceC1513m) != null) {
                throw new CRLException("Duplicate extensions not allowed");
            }
        } catch (InvocationTargetException e2) {
            throw new CRLException(e2.getTargetException().getMessage());
        } catch (Exception e3) {
            throw new CRLException(e3.toString());
        }
    }

    /* renamed from: a */
    public void m11656a(OutputStream outputStream, boolean z) {
        try {
            C1449l c1449l = new C1449l();
            Object[] array = this.f9712b.values().toArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] instanceof InterfaceC1513m) {
                    ((InterfaceC1513m) array[i]).mo11475a(c1449l);
                } else if (array[i] instanceof C1463ah) {
                    ((C1463ah) array[i]).m11488a(c1449l);
                } else {
                    throw new CRLException("Illegal extension object");
                }
            }
            C1449l c1449l2 = new C1449l();
            c1449l2.m11388a((byte) 48, c1449l);
            C1449l c1449l3 = new C1449l();
            if (z) {
                c1449l3.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l2);
            } else {
                c1449l3 = c1449l2;
            }
            outputStream.write(c1449l3.toByteArray());
        } catch (IOException e2) {
            throw new CRLException("Encoding error: " + e2.toString());
        } catch (CertificateException e3) {
            throw new CRLException("Encoding error: " + e3.toString());
        }
    }

    /* renamed from: a */
    public C1463ah m11654a(String str) {
        if (new C1497bo(str).m11568a().equalsIgnoreCase("x509")) {
            str = str.substring(str.lastIndexOf(".") + 1);
        }
        return this.f9712b.get(str);
    }

    /* renamed from: b */
    public Enumeration<C1463ah> m11657b() {
        return Collections.enumeration(this.f9712b.values());
    }

    /* renamed from: a */
    public Collection<C1463ah> m11655a() {
        return this.f9712b.values();
    }

    /* renamed from: c */
    public boolean m11658c() {
        return this.f9713c;
    }

    public boolean equals(Object obj) {
        Object[] array;
        int length;
        int i;
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1510j) && (length = (array = ((C1510j) obj).m11655a().toArray()).length) == this.f9712b.size()) {
            String str = null;
            for (0; i < length; i + 1) {
                if (array[i] instanceof InterfaceC1513m) {
                    str = ((InterfaceC1513m) array[i]).mo11473a();
                }
                C1463ah c1463ah = (C1463ah) array[i];
                if (str == null) {
                    str = c1463ah.m11489c().toString();
                }
                C1463ah c1463ah2 = this.f9712b.get(str);
                i = (c1463ah2 != null && c1463ah2.equals(c1463ah)) ? i + 1 : 0;
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f9712b.hashCode();
    }

    public String toString() {
        return this.f9712b.toString();
    }
}
