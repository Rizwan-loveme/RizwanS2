package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p099c.AbstractC0834ah;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Iterator;
import java.util.List;

/* compiled from: UniformListItem.java */
/* renamed from: com.b.b.c.c.au */
/* loaded from: classes.dex */
public final class C0847au<T extends AbstractC0834ah> extends AbstractC0834ah {

    /* renamed from: a */
    private final EnumC0873z f5198a;

    /* renamed from: b */
    private final List<T> f5199b;

    public C0847au(EnumC0873z enumC0873z, List<T> list) {
        super(m7283a((List<? extends AbstractC0834ah>) list), m7284b((List<? extends AbstractC0834ah>) list));
        if (enumC0873z == null) {
            throw new NullPointerException("itemType == null");
        }
        this.f5199b = list;
        this.f5198a = enumC0873z;
    }

    /* renamed from: a */
    private static int m7283a(List<? extends AbstractC0834ah> list) {
        try {
            return Math.max(4, list.get(0).m7238g());
        } catch (IndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException e3) {
            throw new NullPointerException("items == null");
        }
    }

    /* renamed from: b */
    private static int m7284b(List<? extends AbstractC0834ah> list) {
        AbstractC0834ah abstractC0834ah = list.get(0);
        return (abstractC0834ah.mo7211g_() * list.size()) + m7283a(list);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return this.f5198a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(this.f5199b);
        return stringBuffer.toString();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        Iterator<T> it = this.f5199b.iterator();
        while (it.hasNext()) {
            it.next().mo7201a(c0860m);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public final String mo7204b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("{");
        boolean z = true;
        for (T t : this.f5199b) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(t.mo7204b());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public final List<T> m7286c() {
        return this.f5199b;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        int m7285d = i + m7285d();
        boolean z = true;
        int i2 = -1;
        int i3 = -1;
        for (T t : this.f5199b) {
            int mo7211g_ = t.mo7211g_();
            if (z) {
                i2 = t.m7238g();
                z = false;
                i3 = mo7211g_;
            } else {
                if (mo7211g_ != i3) {
                    throw new UnsupportedOperationException("item size mismatch");
                }
                if (t.m7238g() != i2) {
                    throw new UnsupportedOperationException("item alignment mismatch");
                }
            }
            m7285d = t.m7235b(abstractC0838al, m7285d) + mo7211g_;
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int size = this.f5199b.size();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7239h() + " " + m7438k());
            interfaceC1007a.mo8458a(4, "  size: " + C1022m.m8552a(size));
        }
        interfaceC1007a.mo8523d(size);
        Iterator<T> it = this.f5199b.iterator();
        while (it.hasNext()) {
            it.next().mo7207a(c0860m, interfaceC1007a);
        }
    }

    /* renamed from: d */
    private int m7285d() {
        return m7238g();
    }
}
