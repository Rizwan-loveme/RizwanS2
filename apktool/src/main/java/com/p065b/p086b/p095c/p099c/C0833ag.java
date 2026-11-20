package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: MixedItemSection.java */
/* renamed from: com.b.b.c.c.ag */
/* loaded from: classes.dex */
public final class C0833ag extends AbstractC0838al {

    /* renamed from: a */
    private static final Comparator<AbstractC0834ah> f5160a = new Comparator<AbstractC0834ah>() { // from class: com.b.b.c.c.ag.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC0834ah abstractC0834ah, AbstractC0834ah abstractC0834ah2) {
            return abstractC0834ah.mo7199a().compareTo(abstractC0834ah2.mo7199a());
        }
    };

    /* renamed from: b */
    private final ArrayList<AbstractC0834ah> f5161b;

    /* renamed from: c */
    private final HashMap<AbstractC0834ah, AbstractC0834ah> f5162c;

    /* renamed from: d */
    private final a f5163d;

    /* renamed from: e */
    private int f5164e;

    /* compiled from: MixedItemSection.java */
    /* renamed from: com.b.b.c.c.ag$a */
    enum a {
        NONE,
        TYPE,
        INSTANCE
    }

    public C0833ag(String str, C0860m c0860m, int i, a aVar) {
        super(str, c0860m, i);
        this.f5161b = new ArrayList<>(100);
        this.f5162c = new HashMap<>(100);
        this.f5163d = aVar;
        this.f5164e = -1;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5161b;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: h_ */
    public int mo7231h_() {
        m7259i();
        return this.f5164e;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public int mo7224a(AbstractC0872y abstractC0872y) {
        return ((AbstractC0834ah) abstractC0872y).m7237f();
    }

    /* renamed from: a */
    public void m7225a(AbstractC0834ah abstractC0834ah) {
        m7260j();
        try {
            if (abstractC0834ah.m7238g() > m7256f()) {
                throw new IllegalArgumentException("incompatible item alignment");
            }
            this.f5161b.add(abstractC0834ah);
        } catch (NullPointerException e2) {
            throw new NullPointerException("item == null");
        }
    }

    /* renamed from: b */
    public <T extends AbstractC0834ah> T m7228b(T t) {
        m7260j();
        T t2 = (T) this.f5162c.get(t);
        if (t2 == null) {
            m7225a((AbstractC0834ah) t);
            this.f5162c.put(t, t);
            return t;
        }
        return t2;
    }

    /* renamed from: a */
    public void m7226a(InterfaceC1007a interfaceC1007a, EnumC0873z enumC0873z, String str) {
        m7259i();
        TreeMap treeMap = new TreeMap();
        Iterator<AbstractC0834ah> it = this.f5161b.iterator();
        while (it.hasNext()) {
            AbstractC0834ah next = it.next();
            if (next.mo7199a() == enumC0873z) {
                treeMap.put(next.mo7204b(), next);
            }
        }
        if (treeMap.size() != 0) {
            interfaceC1007a.mo8458a(0, str);
            for (Map.Entry entry : treeMap.entrySet()) {
                interfaceC1007a.mo8458a(0, ((AbstractC0834ah) entry.getValue()).m7239h() + ' ' + ((String) entry.getKey()) + '\n');
            }
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: c */
    protected void mo7229c() {
        C0860m e2 = m7255e();
        int i = 0;
        while (true) {
            int size = this.f5161b.size();
            if (i < size) {
                int i2 = i;
                while (i2 < size) {
                    this.f5161b.get(i2).mo7201a(e2);
                    i2++;
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public void m7230d() {
        m7259i();
        switch (this.f5163d) {
            case INSTANCE:
                Collections.sort(this.f5161b);
                break;
            case TYPE:
                Collections.sort(this.f5161b, f5160a);
                break;
        }
        int size = this.f5161b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0834ah abstractC0834ah = this.f5161b.get(i2);
            try {
                int m7235b = abstractC0834ah.m7235b(this, i);
                if (m7235b < i) {
                    throw new RuntimeException("bogus place() result for " + abstractC0834ah);
                }
                i = m7235b + abstractC0834ah.mo7211g_();
            } catch (RuntimeException e2) {
                throw C1019j.m8537a(e2, "...while placing " + abstractC0834ah);
            }
        }
        this.f5164e = i;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a_ */
    protected void mo7227a_(InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        C0860m e2 = m7255e();
        Iterator<AbstractC0834ah> it = this.f5161b.iterator();
        int i = 0;
        boolean z = true;
        while (it.hasNext()) {
            AbstractC0834ah next = it.next();
            if (mo8460a) {
                if (z) {
                    z = false;
                } else {
                    interfaceC1007a.mo8458a(0, "\n");
                }
            }
            int m7238g = next.m7238g() - 1;
            int i2 = (m7238g ^ (-1)) & (i + m7238g);
            if (i != i2) {
                interfaceC1007a.mo8529g(i2 - i);
                i = i2;
            }
            next.mo7207a(e2, interfaceC1007a);
            i = next.mo7211g_() + i;
        }
        if (i != this.f5164e) {
            throw new RuntimeException("output size mismatch");
        }
    }
}
