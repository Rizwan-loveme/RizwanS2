package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;

/* compiled from: MapItem.java */
/* renamed from: com.b.b.c.c.aa */
/* loaded from: classes.dex */
public final class C0827aa extends AbstractC0834ah {

    /* renamed from: a */
    private final EnumC0873z f5151a;

    /* renamed from: b */
    private final AbstractC0838al f5152b;

    /* renamed from: c */
    private final AbstractC0872y f5153c;

    /* renamed from: d */
    private final AbstractC0872y f5154d;

    /* renamed from: e */
    private final int f5155e;

    /* renamed from: a */
    public static void m7206a(AbstractC0838al[] abstractC0838alArr, C0833ag c0833ag) {
        if (abstractC0838alArr == null) {
            throw new NullPointerException("sections == null");
        }
        if (c0833ag.mo7221a().size() != 0) {
            throw new IllegalArgumentException("mapSection.items().size() != 0");
        }
        ArrayList arrayList = new ArrayList(50);
        for (AbstractC0838al abstractC0838al : abstractC0838alArr) {
            int i = 0;
            AbstractC0872y abstractC0872y = null;
            AbstractC0872y abstractC0872y2 = null;
            EnumC0873z enumC0873z = null;
            for (AbstractC0872y abstractC0872y3 : abstractC0838al.mo7221a()) {
                EnumC0873z mo7199a = abstractC0872y3.mo7199a();
                if (mo7199a != enumC0873z) {
                    if (i != 0) {
                        arrayList.add(new C0827aa(enumC0873z, abstractC0838al, abstractC0872y2, abstractC0872y, i));
                    }
                    i = 0;
                    abstractC0872y2 = abstractC0872y3;
                    enumC0873z = mo7199a;
                }
                i++;
                abstractC0872y = abstractC0872y3;
            }
            if (i != 0) {
                arrayList.add(new C0827aa(enumC0873z, abstractC0838al, abstractC0872y2, abstractC0872y, i));
            } else if (abstractC0838al == c0833ag) {
                arrayList.add(new C0827aa(c0833ag));
            }
        }
        c0833ag.m7225a((AbstractC0834ah) new C0847au(EnumC0873z.TYPE_MAP_LIST, arrayList));
    }

    private C0827aa(EnumC0873z enumC0873z, AbstractC0838al abstractC0838al, AbstractC0872y abstractC0872y, AbstractC0872y abstractC0872y2, int i) {
        super(4, 12);
        if (enumC0873z == null) {
            throw new NullPointerException("type == null");
        }
        if (abstractC0838al == null) {
            throw new NullPointerException("section == null");
        }
        if (abstractC0872y == null) {
            throw new NullPointerException("firstItem == null");
        }
        if (abstractC0872y2 == null) {
            throw new NullPointerException("lastItem == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("itemCount <= 0");
        }
        this.f5151a = enumC0873z;
        this.f5152b = abstractC0838al;
        this.f5153c = abstractC0872y;
        this.f5154d = abstractC0872y2;
        this.f5155e = i;
    }

    private C0827aa(AbstractC0838al abstractC0838al) {
        super(4, 12);
        if (abstractC0838al == null) {
            throw new NullPointerException("section == null");
        }
        this.f5151a = EnumC0873z.TYPE_MAP_LIST;
        this.f5152b = abstractC0838al;
        this.f5153c = null;
        this.f5154d = null;
        this.f5155e = 1;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_MAP_ITEM;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.f5152b.toString());
        stringBuffer.append(' ');
        stringBuffer.append(this.f5151a.mo6681d());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public final String mo7204b() {
        return toString();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int mo7224a;
        int m7439a = this.f5151a.m7439a();
        if (this.f5153c == null) {
            mo7224a = this.f5152b.m7257g();
        } else {
            mo7224a = this.f5152b.mo7224a(this.f5153c);
        }
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7239h() + ' ' + this.f5151a.m7440b() + " map");
            interfaceC1007a.mo8458a(2, "  type:   " + C1022m.m8557c(m7439a) + " // " + this.f5151a.toString());
            interfaceC1007a.mo8458a(2, "  unused: 0");
            interfaceC1007a.mo8458a(4, "  size:   " + C1022m.m8552a(this.f5155e));
            interfaceC1007a.mo8458a(4, "  offset: " + C1022m.m8552a(mo7224a));
        }
        interfaceC1007a.mo8522b(m7439a);
        interfaceC1007a.mo8522b(0);
        interfaceC1007a.mo8523d(this.f5155e);
        interfaceC1007a.mo8523d(mo7224a);
    }
}
