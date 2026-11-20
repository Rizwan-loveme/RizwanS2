package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: AnnotationsDirectoryItem.java */
/* renamed from: com.b.b.c.c.e */
/* loaded from: classes.dex */
public final class C0852e extends AbstractC0834ah {

    /* renamed from: a */
    private C0849b f5215a;

    /* renamed from: b */
    private ArrayList<C0865r> f5216b;

    /* renamed from: c */
    private ArrayList<C0830ad> f5217c;

    /* renamed from: d */
    private ArrayList<C0835ai> f5218d;

    public C0852e() {
        super(4, -1);
        this.f5215a = null;
        this.f5216b = null;
        this.f5217c = null;
        this.f5218d = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_ANNOTATIONS_DIRECTORY_ITEM;
    }

    /* renamed from: c */
    public boolean m7314c() {
        return this.f5215a == null && this.f5216b == null && this.f5217c == null && this.f5218d == null;
    }

    /* renamed from: d */
    public boolean m7315d() {
        return this.f5215a != null && this.f5216b == null && this.f5217c == null && this.f5218d == null;
    }

    public int hashCode() {
        if (this.f5215a == null) {
            return 0;
        }
        return this.f5215a.hashCode();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    public int mo7198a(AbstractC0834ah abstractC0834ah) {
        if (!m7315d()) {
            throw new UnsupportedOperationException("uninternable instance");
        }
        return this.f5215a.compareTo(((C0852e) abstractC0834ah).f5215a);
    }

    /* renamed from: a */
    public void m7309a(C0916c c0916c) {
        if (c0916c == null) {
            throw new NullPointerException("annotations == null");
        }
        if (this.f5215a != null) {
            throw new UnsupportedOperationException("class annotations already set");
        }
        this.f5215a = new C0849b(c0916c);
    }

    /* renamed from: a */
    public void m7310a(C0957k c0957k, C0916c c0916c) {
        if (this.f5216b == null) {
            this.f5216b = new ArrayList<>();
        }
        this.f5216b.add(new C0865r(c0957k, new C0849b(c0916c)));
    }

    /* renamed from: a */
    public void m7311a(C0967u c0967u, C0916c c0916c) {
        if (this.f5217c == null) {
            this.f5217c = new ArrayList<>();
        }
        this.f5217c.add(new C0830ad(c0967u, new C0849b(c0916c)));
    }

    /* renamed from: a */
    public void m7312a(C0967u c0967u, C0917d c0917d) {
        if (this.f5218d == null) {
            this.f5218d = new ArrayList<>();
        }
        this.f5218d.add(new C0835ai(c0967u, c0917d));
    }

    /* renamed from: a */
    public C0916c m7308a(C0967u c0967u) {
        if (this.f5217c == null) {
            return null;
        }
        Iterator<C0830ad> it = this.f5217c.iterator();
        while (it.hasNext()) {
            C0830ad next = it.next();
            if (next.m7214a().equals(c0967u)) {
                return next.m7217b();
            }
        }
        return null;
    }

    /* renamed from: b */
    public C0917d m7313b(C0967u c0967u) {
        if (this.f5218d == null) {
            return null;
        }
        Iterator<C0835ai> it = this.f5218d.iterator();
        while (it.hasNext()) {
            C0835ai next = it.next();
            if (next.m7241a().equals(c0967u)) {
                return next.m7244b();
            }
        }
        return null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0833ag m7401e = c0860m.m7401e();
        if (this.f5215a != null) {
            this.f5215a = (C0849b) m7401e.m7228b((C0833ag) this.f5215a);
        }
        if (this.f5216b != null) {
            Iterator<C0865r> it = this.f5216b.iterator();
            while (it.hasNext()) {
                it.next().m7426a(c0860m);
            }
        }
        if (this.f5217c != null) {
            Iterator<C0830ad> it2 = this.f5217c.iterator();
            while (it2.hasNext()) {
                it2.next().m7215a(c0860m);
            }
        }
        if (this.f5218d != null) {
            Iterator<C0835ai> it3 = this.f5218d.iterator();
            while (it3.hasNext()) {
                it3.next().m7242a(c0860m);
            }
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        throw new RuntimeException("unsupported");
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        m7234a(((m7307a(this.f5216b) + m7307a(this.f5217c) + m7307a(this.f5218d)) * 8) + 16);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        int m7233b = AbstractC0834ah.m7233b(this.f5215a);
        int m7307a = m7307a(this.f5216b);
        int m7307a2 = m7307a(this.f5217c);
        int m7307a3 = m7307a(this.f5218d);
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7239h() + " annotations directory");
            interfaceC1007a.mo8458a(4, "  class_annotations_off: " + C1022m.m8552a(m7233b));
            interfaceC1007a.mo8458a(4, "  fields_size:           " + C1022m.m8552a(m7307a));
            interfaceC1007a.mo8458a(4, "  methods_size:          " + C1022m.m8552a(m7307a2));
            interfaceC1007a.mo8458a(4, "  parameters_size:       " + C1022m.m8552a(m7307a3));
        }
        interfaceC1007a.mo8523d(m7233b);
        interfaceC1007a.mo8523d(m7307a);
        interfaceC1007a.mo8523d(m7307a2);
        interfaceC1007a.mo8523d(m7307a3);
        if (m7307a != 0) {
            Collections.sort(this.f5216b);
            if (mo8460a) {
                interfaceC1007a.mo8458a(0, "  fields:");
            }
            Iterator<C0865r> it = this.f5216b.iterator();
            while (it.hasNext()) {
                it.next().m7427a(c0860m, interfaceC1007a);
            }
        }
        if (m7307a2 != 0) {
            Collections.sort(this.f5217c);
            if (mo8460a) {
                interfaceC1007a.mo8458a(0, "  methods:");
            }
            Iterator<C0830ad> it2 = this.f5217c.iterator();
            while (it2.hasNext()) {
                it2.next().m7216a(c0860m, interfaceC1007a);
            }
        }
        if (m7307a3 != 0) {
            Collections.sort(this.f5218d);
            if (mo8460a) {
                interfaceC1007a.mo8458a(0, "  parameters:");
            }
            Iterator<C0835ai> it3 = this.f5218d.iterator();
            while (it3.hasNext()) {
                it3.next().m7243a(c0860m, interfaceC1007a);
            }
        }
    }

    /* renamed from: a */
    private static int m7307a(ArrayList<?> arrayList) {
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
