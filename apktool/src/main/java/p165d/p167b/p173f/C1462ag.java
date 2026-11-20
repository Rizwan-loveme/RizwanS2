package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: ExtendedKeyUsageExtension.java */
/* renamed from: d.b.f.ag */
/* loaded from: classes.dex */
public class C1462ag extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: o */
    private Vector<C1454q> f9409o;

    /* renamed from: l */
    private static final Map<C1454q, String> f9406l = new HashMap();

    /* renamed from: e */
    private static final int[] f9399e = {2, 5, 29, 37, 0};

    /* renamed from: m */
    private static final int[] f9407m = {1, 3, 6, 1, 5, 5, 7, 3, 1};

    /* renamed from: f */
    private static final int[] f9400f = {1, 3, 6, 1, 5, 5, 7, 3, 2};

    /* renamed from: g */
    private static final int[] f9401g = {1, 3, 6, 1, 5, 5, 7, 3, 3};

    /* renamed from: h */
    private static final int[] f9402h = {1, 3, 6, 1, 5, 5, 7, 3, 4};

    /* renamed from: i */
    private static final int[] f9403i = {1, 3, 6, 1, 5, 5, 7, 3, 5};

    /* renamed from: j */
    private static final int[] f9404j = {1, 3, 6, 1, 5, 5, 7, 3, 6};

    /* renamed from: k */
    private static final int[] f9405k = {1, 3, 6, 1, 5, 5, 7, 3, 7};

    /* renamed from: n */
    private static final int[] f9408n = {1, 3, 6, 1, 5, 5, 7, 3, 8};

    /* renamed from: d */
    private static final int[] f9398d = {1, 3, 6, 1, 5, 5, 7, 3, 9};

    static {
        f9406l.put(C1454q.m11454a(f9399e), "anyExtendedKeyUsage");
        f9406l.put(C1454q.m11454a(f9407m), "serverAuth");
        f9406l.put(C1454q.m11454a(f9400f), "clientAuth");
        f9406l.put(C1454q.m11454a(f9401g), "codeSigning");
        f9406l.put(C1454q.m11454a(f9402h), "emailProtection");
        f9406l.put(C1454q.m11454a(f9403i), "ipsecEndSystem");
        f9406l.put(C1454q.m11454a(f9404j), "ipsecTunnel");
        f9406l.put(C1454q.m11454a(f9405k), "ipsecUser");
        f9406l.put(C1454q.m11454a(f9408n), "timeStamping");
        f9406l.put(C1454q.m11454a(f9398d), "OCSPSigning");
    }

    /* renamed from: f */
    private void m11486f() {
        if (this.f9409o == null || this.f9409o.isEmpty()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f9409o.size()) {
                c1449l2.m11394a(this.f9409o.elementAt(i2));
                i = i2 + 1;
            } else {
                c1449l.m11388a((byte) 48, c1449l2);
                this.f9412c = c1449l.toByteArray();
                return;
            }
        }
    }

    public C1462ag(Vector<C1454q> vector) {
        this(Boolean.FALSE, vector);
    }

    public C1462ag(Boolean bool, Vector<C1454q> vector) {
        this.f9409o = vector;
        this.f9411b = C1481az.f9490i;
        this.f9410a = bool.booleanValue();
        m11486f();
    }

    public C1462ag(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9490i;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for ExtendedKeyUsageExtension.");
        }
        this.f9409o = new Vector<>();
        while (c1450m.f9356b.m11362a() != 0) {
            this.f9409o.addElement(c1450m.f9356b.m11371d().m11431l());
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str;
        if (this.f9409o == null) {
            return "";
        }
        String str2 = "  ";
        Iterator<C1454q> it = this.f9409o.iterator();
        boolean z = true;
        while (it.hasNext()) {
            C1454q next = it.next();
            if (!z) {
                str2 = String.valueOf(str2) + "\n  ";
            }
            String str3 = f9406l.get(next);
            if (str3 != null) {
                str = String.valueOf(str2) + str3;
            } else {
                str = String.valueOf(str2) + next.toString();
            }
            z = false;
            str2 = str;
        }
        return String.valueOf(super.toString()) + "ExtendedKeyUsages [\n" + str2 + "\n]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9490i;
            this.f9410a = false;
            m11486f();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "ExtendedKeyUsage";
    }

    /* renamed from: b */
    public List<String> m11487b() {
        ArrayList arrayList = new ArrayList(this.f9409o.size());
        Iterator<C1454q> it = this.f9409o.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }
}
