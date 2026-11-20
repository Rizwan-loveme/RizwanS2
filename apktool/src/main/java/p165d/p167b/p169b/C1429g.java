package p165d.p167b.p169b;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.Hashtable;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.InterfaceC1445h;

/* compiled from: PKCS9Attributes.java */
/* renamed from: d.b.b.g */
/* loaded from: classes.dex */
public class C1429g {

    /* renamed from: a */
    private final Hashtable<C1454q, C1428f> f9257a;

    /* renamed from: b */
    private final byte[] f9258b;

    /* renamed from: c */
    private boolean f9259c;

    /* renamed from: d */
    private final Hashtable<C1454q, C1454q> f9260d;

    public C1429g(C1448k c1448k) {
        this(c1448k, false);
    }

    public C1429g(C1448k c1448k, boolean z) {
        this.f9257a = new Hashtable<>(3);
        this.f9259c = false;
        this.f9259c = z;
        this.f9258b = m11275a(c1448k);
        this.f9260d = null;
    }

    /* renamed from: a */
    private byte[] m11275a(C1448k c1448k) {
        C1428f c1428f;
        C1454q m11273b;
        boolean z = true;
        byte[] m11440u = c1448k.m11371d().m11440u();
        m11440u[0] = 49;
        for (C1450m c1450m : new C1448k(m11440u).m11365a(3, true)) {
            try {
                c1428f = new C1428f(c1450m);
                m11273b = c1428f.m11273b();
            } catch (C1430h e2) {
                if (!this.f9259c) {
                    throw e2;
                }
                z = false;
            }
            if (this.f9257a.get(m11273b) != null) {
                throw new IOException("Duplicate PKCS9 attribute: " + m11273b);
            }
            if (this.f9260d != null && !this.f9260d.containsKey(m11273b)) {
                throw new IOException("Attribute " + m11273b + " not permitted in this attribute set");
            }
            this.f9257a.put(m11273b, c1428f);
        }
        return z ? m11440u : m11277b();
    }

    /* renamed from: a */
    public void m11279a(byte b2, OutputStream outputStream) {
        outputStream.write(b2);
        outputStream.write(this.f9258b, 1, this.f9258b.length - 1);
    }

    /* renamed from: b */
    private byte[] m11277b() {
        C1449l c1449l = new C1449l();
        c1449l.m11390a((byte) 49, m11276a(this.f9257a.values().toArray()));
        return c1449l.toByteArray();
    }

    /* renamed from: a */
    public byte[] m11280a() {
        return (byte[]) this.f9258b.clone();
    }

    /* renamed from: a */
    public C1428f m11278a(C1454q c1454q) {
        return this.f9257a.get(c1454q);
    }

    /* renamed from: b */
    public Object m11281b(C1454q c1454q) {
        try {
            return m11278a(c1454q).m11274c();
        } catch (NullPointerException e2) {
            throw new IOException("No value found for attribute " + c1454q);
        }
    }

    public String toString() {
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PKCS9 Attributes: [\n\t");
        int i = 1;
        while (true) {
            boolean z2 = z;
            if (i < C1428f.f9242i.length) {
                C1428f m11278a = m11278a(C1428f.f9242i[i]);
                if (m11278a == null) {
                    z = z2;
                } else {
                    if (z2) {
                        z = false;
                    } else {
                        stringBuffer.append(";\n\t");
                        z = z2;
                    }
                    stringBuffer.append(m11278a.toString());
                }
                i++;
            } else {
                stringBuffer.append("\n\t] (end PKCS9 Attributes)");
                return stringBuffer.toString();
            }
        }
    }

    /* renamed from: a */
    static InterfaceC1445h[] m11276a(Object[] objArr) {
        InterfaceC1445h[] interfaceC1445hArr = new InterfaceC1445h[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < interfaceC1445hArr.length) {
                interfaceC1445hArr[i2] = (InterfaceC1445h) objArr[i2];
                i = i2 + 1;
            } else {
                return interfaceC1445hArr;
            }
        }
    }
}
