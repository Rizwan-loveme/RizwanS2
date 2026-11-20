package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0962p;
import com.p065b.p086b.p103f.p106c.AbstractC0963q;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;

/* compiled from: ArrayData.java */
/* renamed from: com.b.b.c.b.a */
/* loaded from: classes.dex */
public final class C0766a extends AbstractC0798ad {

    /* renamed from: a */
    private final C0804f f4732a;

    /* renamed from: b */
    private final ArrayList<AbstractC0945a> f4733b;

    /* renamed from: c */
    private final AbstractC0945a f4734c;

    /* renamed from: d */
    private final int f4735d;

    /* renamed from: e */
    private final int f4736e;

    public C0766a(C0940v c0940v, C0804f c0804f, ArrayList<AbstractC0945a> arrayList, AbstractC0945a abstractC0945a) {
        super(c0940v, C0935q.f5906a);
        if (c0804f == null) {
            throw new NullPointerException("user == null");
        }
        if (arrayList == null) {
            throw new NullPointerException("values == null");
        }
        if (arrayList.size() <= 0) {
            throw new IllegalArgumentException("Illegal number of init values");
        }
        this.f4734c = abstractC0945a;
        if (abstractC0945a == C0971y.f6183l || abstractC0945a == C0971y.f6182k) {
            this.f4735d = 1;
        } else if (abstractC0945a == C0971y.f6189r || abstractC0945a == C0971y.f6184m) {
            this.f4735d = 2;
        } else if (abstractC0945a == C0971y.f6188q || abstractC0945a == C0971y.f6186o) {
            this.f4735d = 4;
        } else if (abstractC0945a == C0971y.f6187p || abstractC0945a == C0971y.f6185n) {
            this.f4735d = 8;
        } else {
            throw new IllegalArgumentException("Unexpected constant type");
        }
        this.f4732a = c0804f;
        this.f4733b = arrayList;
        this.f4736e = arrayList.size();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public int mo6964a() {
        return (((this.f4736e * this.f4735d) + 1) / 2) + 4;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public void mo6967a(InterfaceC1007a interfaceC1007a) {
        int size = this.f4733b.size();
        interfaceC1007a.mo8522b(768);
        interfaceC1007a.mo8522b(this.f4735d);
        interfaceC1007a.mo8523d(this.f4736e);
        switch (this.f4735d) {
            case 1:
                for (int i = 0; i < size; i++) {
                    interfaceC1007a.mo7631c((byte) ((AbstractC0962p) this.f4733b.get(i)).mo8064j());
                }
                break;
            case 2:
                for (int i2 = 0; i2 < size; i2++) {
                    interfaceC1007a.mo8522b((short) ((AbstractC0962p) this.f4733b.get(i2)).mo8064j());
                }
                break;
            case 4:
                for (int i3 = 0; i3 < size; i3++) {
                    interfaceC1007a.mo8523d(((AbstractC0962p) this.f4733b.get(i3)).mo8064j());
                }
                break;
            case 8:
                for (int i4 = 0; i4 < size; i4++) {
                    interfaceC1007a.mo8517a(((AbstractC0963q) this.f4733b.get(i4)).mo8065k());
                }
                break;
        }
        if (this.f4735d == 1 && size % 2 != 0) {
            interfaceC1007a.mo7631c(0);
        }
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0766a(m7042i(), this.f4732a, this.f4733b, this.f4734c);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.f4733b.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(this.f4733b.get(i).mo6681d());
        }
        return stringBuffer.toString();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        int g = this.f4732a.m7040g();
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.f4733b.size();
        stringBuffer.append("fill-array-data-payload // for fill-array-data @ ");
        stringBuffer.append(C1022m.m8557c(g));
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n  ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(this.f4733b.get(i).mo6681d());
        }
        return stringBuffer.toString();
    }
}
