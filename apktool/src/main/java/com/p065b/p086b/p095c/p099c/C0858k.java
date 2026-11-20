package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p097b.C0815q;
import com.p065b.p086b.p095c.p097b.C0821w;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: DebugInfoEncoder.java */
/* renamed from: com.b.b.c.c.k */
/* loaded from: classes.dex */
public final class C0858k {

    /* renamed from: a */
    private final C0821w f5250a;

    /* renamed from: b */
    private final C0815q f5251b;

    /* renamed from: d */
    private final C0860m f5253d;

    /* renamed from: e */
    private final int f5254e;

    /* renamed from: f */
    private final int f5255f;

    /* renamed from: g */
    private final C0973a f5256g;

    /* renamed from: h */
    private final boolean f5257h;

    /* renamed from: k */
    private InterfaceC1007a f5260k;

    /* renamed from: l */
    private PrintWriter f5261l;

    /* renamed from: m */
    private String f5262m;

    /* renamed from: n */
    private boolean f5263n;

    /* renamed from: o */
    private final C0815q.b[] f5264o;

    /* renamed from: i */
    private int f5258i = 0;

    /* renamed from: j */
    private int f5259j = 1;

    /* renamed from: c */
    private final C1014e f5252c = new C1014e();

    public C0858k(C0821w c0821w, C0815q c0815q, C0860m c0860m, int i, int i2, boolean z, C0967u c0967u) {
        this.f5250a = c0821w;
        this.f5251b = c0815q;
        this.f5253d = c0860m;
        this.f5256g = c0967u.m8047i();
        this.f5257h = z;
        this.f5254e = i;
        this.f5255f = i2;
        this.f5264o = new C0815q.b[i2];
    }

    /* renamed from: a */
    private void m7363a(int i, String str) {
        if (this.f5262m != null) {
            str = this.f5262m + str;
        }
        if (this.f5260k != null) {
            InterfaceC1007a interfaceC1007a = this.f5260k;
            if (!this.f5263n) {
                i = 0;
            }
            interfaceC1007a.mo8458a(i, str);
        }
        if (this.f5261l != null) {
            this.f5261l.println(str);
        }
    }

    /* renamed from: a */
    public byte[] m7380a() {
        try {
            return m7370b();
        } catch (IOException e2) {
            throw C1019j.m8537a(e2, "...while encoding debug info");
        }
    }

    /* renamed from: a */
    public byte[] m7381a(String str, PrintWriter printWriter, InterfaceC1007a interfaceC1007a, boolean z) {
        this.f5262m = str;
        this.f5261l = printWriter;
        this.f5260k = interfaceC1007a;
        this.f5263n = z;
        return m7380a();
    }

    /* renamed from: b */
    private byte[] m7370b() {
        ArrayList<C0821w.a> m7371c = m7371c();
        m7367a(m7371c, m7377e());
        this.f5252c.mo7631c(7);
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(1, String.format("%04x: prologue end", Integer.valueOf(this.f5258i)));
        }
        int size = m7371c.size();
        int f_ = this.f5251b.m8550f_();
        int i = 0;
        int i2 = 0;
        while (true) {
            int m7359a = m7359a(i);
            int m7361a = m7361a(i2, m7371c);
            int m7102a = m7359a < f_ ? this.f5251b.m7100a(m7359a).m7102a() : Integer.MAX_VALUE;
            int m7158a = m7361a < size ? m7371c.get(m7361a).m7158a() : Integer.MAX_VALUE;
            int min = Math.min(m7158a, m7102a);
            if (min != Integer.MAX_VALUE && (min != this.f5254e || m7102a != Integer.MAX_VALUE || m7158a != Integer.MAX_VALUE)) {
                if (min == m7158a) {
                    i2 = m7361a + 1;
                    m7364a(m7371c.get(m7361a));
                } else {
                    m7372c(min - this.f5258i);
                    i2 = m7361a;
                }
                i = m7359a;
            }
        }
        m7379f();
        return this.f5252c.m8527f();
    }

    /* renamed from: a */
    private int m7359a(int i) {
        int f_ = this.f5251b.m8550f_();
        while (i < f_ && this.f5251b.m7100a(i).m7102a() == this.f5258i) {
            int i2 = i + 1;
            C0815q.b m7100a = this.f5251b.m7100a(i);
            int m7112g = m7100a.m7112g();
            C0815q.b bVar = this.f5264o[m7112g];
            if (m7100a == bVar) {
                i = i2;
            } else {
                this.f5264o[m7112g] = m7100a;
                if (m7100a.m7108c()) {
                    if (bVar != null && m7100a.m7107b(bVar)) {
                        if (bVar.m7108c()) {
                            throw new RuntimeException("shouldn't happen");
                        }
                        m7369b(m7100a);
                    } else {
                        m7373c(m7100a);
                    }
                } else if (m7100a.m7106b() != C0815q.a.END_REPLACED) {
                    m7378e(m7100a);
                }
                i = i2;
            }
        }
        return i;
    }

    /* renamed from: a */
    private int m7361a(int i, ArrayList<C0821w.a> arrayList) {
        int size = arrayList.size();
        while (i < size && arrayList.get(i).m7158a() == this.f5258i) {
            m7364a(arrayList.get(i));
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private void m7367a(ArrayList<C0821w.a> arrayList, ArrayList<C0815q.b> arrayList2) {
        int i;
        C0815q.b bVar;
        boolean z = (this.f5260k == null && this.f5261l == null) ? false : true;
        int mo8528g = this.f5252c.mo8528g();
        if (arrayList.size() > 0) {
            this.f5259j = arrayList.get(0).m7159b().m8028a();
        }
        this.f5252c.mo8524e(this.f5259j);
        if (z) {
            m7363a(this.f5252c.mo8528g() - mo8528g, "line_start: " + this.f5259j);
        }
        int m7374d = m7374d();
        C0974b m8104c = this.f5256g.m8104c();
        int f_ = m8104c.m8550f_();
        if (this.f5257h) {
            i = m7374d;
        } else {
            Iterator<C0815q.b> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0815q.b next = it.next();
                if (m7374d == next.m7112g()) {
                    this.f5264o[m7374d] = next;
                    break;
                }
            }
            i = m7374d + 1;
        }
        int mo8528g2 = this.f5252c.mo8528g();
        this.f5252c.mo8524e(f_);
        if (z) {
            m7363a(this.f5252c.mo8528g() - mo8528g2, String.format("parameters_size: %04x", Integer.valueOf(f_)));
        }
        int i2 = i;
        for (int i3 = 0; i3 < f_; i3++) {
            C0975c m8115b = m8104c.m8115b(i3);
            int mo8528g3 = this.f5252c.mo8528g();
            Iterator<C0815q.b> it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it2.next();
                if (i2 == bVar.m7112g()) {
                    if (bVar.m7110e() != null) {
                        m7365a((C0970x) null);
                    } else {
                        m7365a(bVar.m7109d());
                    }
                    this.f5264o[i2] = bVar;
                }
            }
            if (bVar == null) {
                m7365a((C0970x) null);
            }
            if (z) {
                m7363a(this.f5252c.mo8528g() - mo8528g3, "parameter " + ((bVar == null || bVar.m7110e() != null) ? "<unnamed>" : bVar.m7109d().mo6681d()) + " v" + i2);
            }
            i2 += m8115b.m8127j();
        }
        for (C0815q.b bVar2 : this.f5264o) {
            if (bVar2 != null && bVar2.m7110e() != null) {
                m7376d(bVar2);
            }
        }
    }

    /* renamed from: c */
    private ArrayList<C0821w.a> m7371c() {
        int f_ = this.f5250a == null ? 0 : this.f5250a.m8550f_();
        ArrayList<C0821w.a> arrayList = new ArrayList<>(f_);
        for (int i = 0; i < f_; i++) {
            arrayList.add(this.f5250a.m7156a(i));
        }
        Collections.sort(arrayList, new Comparator<C0821w.a>() { // from class: com.b.b.c.c.k.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0821w.a aVar, C0821w.a aVar2) {
                return aVar.m7158a() - aVar2.m7158a();
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return obj == this;
            }
        });
        return arrayList;
    }

    /* renamed from: d */
    private int m7374d() {
        return (this.f5255f - this.f5256g.m8104c().m8117e()) - (this.f5257h ? 0 : 1);
    }

    /* renamed from: e */
    private ArrayList<C0815q.b> m7377e() {
        ArrayList<C0815q.b> arrayList = new ArrayList<>(this.f5256g.m8104c().m8550f_());
        int m7374d = m7374d();
        BitSet bitSet = new BitSet(this.f5255f - m7374d);
        int f_ = this.f5251b.m8550f_();
        for (int i = 0; i < f_; i++) {
            C0815q.b m7100a = this.f5251b.m7100a(i);
            int m7112g = m7100a.m7112g();
            if (m7112g >= m7374d && !bitSet.get(m7112g - m7374d)) {
                bitSet.set(m7112g - m7374d);
                arrayList.add(m7100a);
            }
        }
        Collections.sort(arrayList, new Comparator<C0815q.b>() { // from class: com.b.b.c.c.k.2
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0815q.b bVar, C0815q.b bVar2) {
                return bVar.m7112g() - bVar2.m7112g();
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return obj == this;
            }
        });
        return arrayList;
    }

    /* renamed from: a */
    private String m7362a(C0815q.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        sb.append(bVar.m7112g());
        sb.append(' ');
        C0970x m7109d = bVar.m7109d();
        if (m7109d == null) {
            sb.append("null");
        } else {
            sb.append(m7109d.mo6681d());
        }
        sb.append(' ');
        C0971y m7111f = bVar.m7111f();
        if (m7111f == null) {
            sb.append("null");
        } else {
            sb.append(m7111f.mo6681d());
        }
        C0970x m7110e = bVar.m7110e();
        if (m7110e != null) {
            sb.append(' ');
            sb.append(m7110e.mo6681d());
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m7369b(C0815q.b bVar) {
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(6);
        m7375d(bVar.m7112g());
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("%04x: +local restart %s", Integer.valueOf(this.f5258i), m7362a(bVar)));
        }
    }

    /* renamed from: a */
    private void m7365a(C0970x c0970x) {
        if (c0970x == null || this.f5253d == null) {
            this.f5252c.mo8524e(0);
        } else {
            this.f5252c.mo8524e(this.f5253d.m7404h().m7274b(c0970x) + 1);
        }
    }

    /* renamed from: a */
    private void m7366a(C0971y c0971y) {
        if (c0971y == null || this.f5253d == null) {
            this.f5252c.mo8524e(0);
        } else {
            this.f5252c.mo8524e(this.f5253d.m7407k().m7279b(c0971y) + 1);
        }
    }

    /* renamed from: c */
    private void m7373c(C0815q.b bVar) {
        if (bVar.m7110e() != null) {
            m7376d(bVar);
            return;
        }
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(3);
        m7375d(bVar.m7112g());
        m7365a(bVar.m7109d());
        m7366a(bVar.m7111f());
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("%04x: +local %s", Integer.valueOf(this.f5258i), m7362a(bVar)));
        }
    }

    /* renamed from: d */
    private void m7376d(C0815q.b bVar) {
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(4);
        m7375d(bVar.m7112g());
        m7365a(bVar.m7109d());
        m7366a(bVar.m7111f());
        m7365a(bVar.m7110e());
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("%04x: +localx %s", Integer.valueOf(this.f5258i), m7362a(bVar)));
        }
    }

    /* renamed from: e */
    private void m7378e(C0815q.b bVar) {
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(5);
        this.f5252c.mo8524e(bVar.m7112g());
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("%04x: -local %s", Integer.valueOf(this.f5258i), m7362a(bVar)));
        }
    }

    /* renamed from: a */
    private void m7364a(C0821w.a aVar) {
        int m8028a = aVar.m7159b().m8028a();
        int m7158a = aVar.m7158a();
        int i = m8028a - this.f5259j;
        int i2 = m7158a - this.f5258i;
        if (i2 < 0) {
            throw new RuntimeException("Position entries must be in ascending address order");
        }
        if (i < -4 || i > 10) {
            m7368b(i);
            i = 0;
        }
        int m7360a = m7360a(i, i2);
        if ((m7360a & (-256)) > 0) {
            m7372c(i2);
            m7360a = m7360a(i, 0);
            if ((m7360a & (-256)) > 0) {
                m7368b(i);
                m7360a = m7360a(0, 0);
                i2 = 0;
                i = 0;
            } else {
                i2 = 0;
            }
        }
        this.f5252c.mo7631c(m7360a);
        this.f5259j = i + this.f5259j;
        this.f5258i += i2;
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(1, String.format("%04x: line %d", Integer.valueOf(this.f5258i), Integer.valueOf(this.f5259j)));
        }
    }

    /* renamed from: a */
    private static int m7360a(int i, int i2) {
        if (i < -4 || i > 10) {
            throw new RuntimeException("Parameter out of range");
        }
        return i + 4 + (i2 * 15) + 10;
    }

    /* renamed from: b */
    private void m7368b(int i) {
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(2);
        this.f5252c.m8526f(i);
        this.f5259j += i;
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("line = %d", Integer.valueOf(this.f5259j)));
        }
    }

    /* renamed from: c */
    private void m7372c(int i) {
        int mo8528g = this.f5252c.mo8528g();
        this.f5252c.mo7631c(1);
        this.f5252c.mo8524e(i);
        this.f5258i += i;
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(this.f5252c.mo8528g() - mo8528g, String.format("%04x: advance pc", Integer.valueOf(this.f5258i)));
        }
    }

    /* renamed from: d */
    private void m7375d(int i) {
        if (i < 0) {
            throw new RuntimeException("Signed value where unsigned required: " + i);
        }
        this.f5252c.mo8524e(i);
    }

    /* renamed from: f */
    private void m7379f() {
        this.f5252c.mo7631c(0);
        if (this.f5260k != null || this.f5261l != null) {
            m7363a(1, "end sequence");
        }
    }
}
