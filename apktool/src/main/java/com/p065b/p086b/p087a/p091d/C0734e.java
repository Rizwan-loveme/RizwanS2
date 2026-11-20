package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p089b.C0710f;
import com.p065b.p086b.p087a.p089b.C0711g;
import com.p065b.p086b.p087a.p089b.C0727w;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0961o;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import java.util.ArrayList;

/* compiled from: CodeObserver.java */
/* renamed from: com.b.b.a.d.e */
/* loaded from: classes.dex */
public class C0734e implements C0711g.c {

    /* renamed from: a */
    private final C1013d f4637a;

    /* renamed from: b */
    private final InterfaceC0749j f4638b;

    public C0734e(C1013d c1013d, InterfaceC0749j interfaceC0749j) {
        if (c1013d == null) {
            throw new NullPointerException("bytes == null");
        }
        if (interfaceC0749j == null) {
            throw new NullPointerException("observer == null");
        }
        this.f4637a = c1013d;
        this.f4638b = interfaceC0749j;
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6561a(int i, int i2, int i3) {
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2));
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6566a(int i, int i2, int i3, C0975c c0975c) {
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2));
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5) {
        String m8559e = i3 <= 3 ? C1022m.m8559e(i4) : C1022m.m8557c(i4);
        boolean z = i3 == 1;
        String str = "";
        if (i == 132) {
            str = ", #" + (i3 <= 3 ? C1022m.m8563i(i5) : C1022m.m8562h(i5));
        }
        String str2 = "";
        if (c0975c.m8129l()) {
            str2 = (z ? "," : " //") + " category-2";
        }
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + (z ? " // " : " ") + m8559e + str + str2);
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4) {
        if (abstractC0945a instanceof C0961o) {
            mo6566a(i, i2, i3, (C0975c) null);
            return;
        }
        if (abstractC0945a instanceof C0959m) {
            m6828b(i, i2, i3, i4);
            return;
        }
        if (abstractC0945a instanceof C0965s) {
            m6826a(i, i2, i3, ((C0965s) abstractC0945a).m8069n());
            return;
        }
        if (abstractC0945a instanceof C0958l) {
            m6830c(i, i2, i3, ((C0958l) abstractC0945a).mo8064j());
            return;
        }
        if (abstractC0945a instanceof C0955i) {
            m6829b(i, i2, i3, ((C0955i) abstractC0945a).mo8065k());
            return;
        }
        String str = "";
        if (i4 != 0) {
            str = i == 197 ? ", " + C1022m.m8559e(i4) : ", " + C1022m.m8557c(i4);
        }
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + " " + abstractC0945a + str);
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6562a(int i, int i2, int i3, int i4) {
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + " " + (i3 <= 3 ? C1022m.m8557c(i4) : C1022m.m8552a(i4)));
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4) {
        int m6779a = c0727w.m6779a();
        StringBuffer stringBuffer = new StringBuffer((m6779a * 20) + 100);
        stringBuffer.append(m6827b(i2));
        if (i4 != 0) {
            stringBuffer.append(" // padding: " + C1022m.m8552a(i4));
        }
        stringBuffer.append('\n');
        for (int i5 = 0; i5 < m6779a; i5++) {
            stringBuffer.append("  ");
            stringBuffer.append(C1022m.m8561g(c0727w.m6780a(i5)));
            stringBuffer.append(": ");
            stringBuffer.append(C1022m.m8557c(c0727w.m6783b(i5)));
            stringBuffer.append('\n');
        }
        stringBuffer.append("  default: ");
        stringBuffer.append(C1022m.m8557c(c0727w.m6782b()));
        this.f4638b.m6900a(this.f4637a, i2, i3, stringBuffer.toString());
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList) {
        this.f4638b.m6900a(this.f4637a, i, i2, m6827b(i) + (i2 == 1 ? " // " : " ") + c0971y.m8090i().m8138u().mo6681d());
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public void mo6560a(int i) {
    }

    @Override // com.p065b.p086b.p087a.p089b.C0711g.c
    /* renamed from: a */
    public int mo6559a() {
        return -1;
    }

    /* renamed from: b */
    private String m6827b(int i) {
        int m8511e = this.f4637a.m8511e(i);
        String m6589a = C0710f.m6589a(m8511e);
        if (m8511e == 196) {
            m6589a = m6589a + " " + C0710f.m6589a(this.f4637a.m8511e(i + 1));
        }
        return C1022m.m8557c(i) + ": " + m6589a;
    }

    /* renamed from: b */
    private void m6828b(int i, int i2, int i3, int i4) {
        String str;
        String str2 = i3 == 1 ? " // " : " ";
        int m8511e = this.f4637a.m8511e(i2);
        if (i3 == 1 || m8511e == 16) {
            str = "#" + C1022m.m8563i(i4);
        } else if (m8511e == 17) {
            str = "#" + C1022m.m8562h(i4);
        } else {
            str = "#" + C1022m.m8561g(i4);
        }
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + str2 + str);
    }

    /* renamed from: a */
    private void m6826a(int i, int i2, int i3, long j) {
        String m8556b;
        String str = i3 == 1 ? " // " : " #";
        if (i3 == 1) {
            m8556b = C1022m.m8563i((int) j);
        } else {
            m8556b = C1022m.m8556b(j);
        }
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + str + m8556b);
    }

    /* renamed from: c */
    private void m6830c(int i, int i2, int i3, int i4) {
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + (i3 != 1 ? " #" + C1022m.m8552a(i4) : "") + " // " + Float.intBitsToFloat(i4));
    }

    /* renamed from: b */
    private void m6829b(int i, int i2, int i3, long j) {
        this.f4638b.m6900a(this.f4637a, i2, i3, m6827b(i2) + (i3 != 1 ? " #" + C1022m.m8553a(j) : "") + " // " + Double.longBitsToDouble(j));
    }
}
