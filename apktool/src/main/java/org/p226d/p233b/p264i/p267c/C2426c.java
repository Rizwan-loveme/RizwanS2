package org.p226d.p233b.p264i.p267c;

import com.p129f.p130a.p133c.C1156ai;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.p226d.p233b.p238b.AbstractC2015e;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p269d.C2453g;

/* compiled from: TryListBuilder.java */
/* renamed from: org.d.b.i.c.c */
/* loaded from: classes.dex */
public class C2426c<EH extends InterfaceC2265f> {

    /* renamed from: a */
    private final b<EH> f12807a = new b<>(0, 0);

    /* renamed from: b */
    private final b<EH> f12808b = new b<>(0, 0);

    public C2426c() {
        this.f12807a.f12812b = this.f12808b;
        this.f12808b.f12811a = this.f12807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <EH extends InterfaceC2265f> List<InterfaceC2271l<EH>> m15327a(List<? extends InterfaceC2271l<? extends EH>> list) {
        C2426c c2426c = new C2426c();
        for (InterfaceC2271l<? extends EH> interfaceC2271l : list) {
            int mo14514a = interfaceC2271l.mo14514a();
            int mo14515b = interfaceC2271l.mo14515b() + mo14514a;
            Iterator<? extends Object> it = interfaceC2271l.mo14516c().iterator();
            while (it.hasNext()) {
                c2426c.m15332a(mo14514a, mo14515b, (InterfaceC2265f) it.next());
            }
        }
        return c2426c.m15331a();
    }

    /* compiled from: TryListBuilder.java */
    /* renamed from: org.d.b.i.c.c$c */
    private static class c<EH extends InterfaceC2265f> {

        /* renamed from: a */
        public final b<EH> f12816a;

        /* renamed from: b */
        public final b<EH> f12817b;

        public c(b<EH> bVar, b<EH> bVar2) {
            this.f12816a = bVar;
            this.f12817b = bVar2;
        }
    }

    /* compiled from: TryListBuilder.java */
    /* renamed from: org.d.b.i.c.c$a */
    public static class a extends C2453g {
        public a(String str, Object... objArr) {
            super(str, objArr);
        }
    }

    /* compiled from: TryListBuilder.java */
    /* renamed from: org.d.b.i.c.c$b */
    private static class b<EH extends InterfaceC2265f> extends AbstractC2015e<EH> {

        /* renamed from: a */
        public b<EH> f12811a;

        /* renamed from: b */
        public b<EH> f12812b;

        /* renamed from: c */
        public int f12813c;

        /* renamed from: d */
        public int f12814d;

        /* renamed from: e */
        public List<EH> f12815e;

        public b(int i, int i2) {
            this.f12811a = null;
            this.f12812b = null;
            this.f12815e = C1156ai.m9909a();
            this.f12813c = i;
            this.f12814d = i2;
        }

        public b(int i, int i2, List<EH> list) {
            this.f12811a = null;
            this.f12812b = null;
            this.f12815e = C1156ai.m9909a();
            this.f12813c = i;
            this.f12814d = i2;
            this.f12815e = C1156ai.m9910a((Iterable) list);
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: a */
        public int mo14514a() {
            return this.f12813c;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: b */
        public int mo14515b() {
            return this.f12814d - this.f12813c;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: c */
        public List<EH> mo14516c() {
            return this.f12815e;
        }

        /* renamed from: a */
        public b<EH> m15335a(int i) {
            b<EH> bVar = new b<>(i, this.f12814d, this.f12815e);
            this.f12814d = i;
            m15337a(bVar);
            return bVar;
        }

        /* renamed from: d */
        public void m15339d() {
            this.f12812b.f12811a = this.f12811a;
            this.f12811a.f12812b = this.f12812b;
        }

        /* renamed from: e */
        public void m15340e() {
            this.f12814d = this.f12812b.f12814d;
            this.f12812b.m15339d();
        }

        /* renamed from: a */
        public void m15337a(b<EH> bVar) {
            this.f12812b.f12811a = bVar;
            bVar.f12812b = this.f12812b;
            bVar.f12811a = this;
            this.f12812b = bVar;
        }

        /* renamed from: b */
        public void m15338b(b<EH> bVar) {
            this.f12811a.f12812b = bVar;
            bVar.f12811a = this.f12811a;
            bVar.f12812b = this;
            this.f12811a = bVar;
        }

        /* renamed from: a */
        public void m15336a(EH eh) {
            for (EH eh2 : this.f12815e) {
                String mo14476b = eh2.mo14476b();
                String mo14476b2 = eh.mo14476b();
                if (mo14476b == null) {
                    if (mo14476b2 == null) {
                        if (eh2.mo14477c() != eh.mo14477c()) {
                            throw new a("Multiple overlapping catch all handlers with different handlers", new Object[0]);
                        }
                        return;
                    }
                } else if (mo14476b.equals(mo14476b2)) {
                    return;
                }
            }
            this.f12815e.add(eh);
        }
    }

    /* renamed from: a */
    private c<EH> m15329a(int i, int i2) {
        b<EH> bVar = null;
        b<EH> bVar2 = this.f12807a.f12812b;
        while (true) {
            if (bVar2 == this.f12808b) {
                break;
            }
            int i3 = bVar2.f12813c;
            int i4 = bVar2.f12814d;
            if (i == i3) {
                bVar = bVar2;
                break;
            }
            if (i > i3 && i < i4) {
                bVar = bVar2.m15335a(i);
                break;
            }
            if (i < i3) {
                if (i2 <= i3) {
                    b<EH> bVar3 = new b<>(i, i2);
                    bVar2.m15338b(bVar3);
                    return new c<>(bVar3, bVar3);
                }
                bVar = new b<>(i, i3);
                bVar2.m15338b(bVar);
            } else {
                bVar2 = bVar2.f12812b;
            }
        }
        if (bVar == null) {
            b<EH> bVar4 = new b<>(i, i2);
            this.f12808b.m15338b(bVar4);
            return new c<>(bVar4, bVar4);
        }
        for (b<EH> bVar5 = bVar; bVar5 != this.f12808b; bVar5 = bVar5.f12812b) {
            int i5 = bVar5.f12813c;
            int i6 = bVar5.f12814d;
            if (i2 == i6) {
                return new c<>(bVar, bVar5);
            }
            if (i2 > i5 && i2 < i6) {
                bVar5.m15335a(i2);
                return new c<>(bVar, bVar5);
            }
            if (i2 <= i5) {
                b<EH> bVar6 = new b<>(bVar5.f12811a.f12814d, i2);
                bVar5.m15338b(bVar6);
                return new c<>(bVar, bVar6);
            }
        }
        b<EH> bVar7 = new b<>(this.f12808b.f12811a.f12814d, i2);
        this.f12808b.m15338b(bVar7);
        return new c<>(bVar, bVar7);
    }

    /* renamed from: a */
    public void m15332a(int i, int i2, EH eh) {
        c<EH> m15329a = m15329a(i, i2);
        b<EH> bVar = m15329a.f12816a;
        b<EH> bVar2 = m15329a.f12817b;
        do {
            if (bVar.f12813c > i) {
                b<EH> bVar3 = new b<>(i, bVar.f12813c);
                bVar.m15338b(bVar3);
                bVar = bVar3;
            }
            bVar.m15336a((b<EH>) eh);
            i = bVar.f12814d;
            bVar = bVar.f12812b;
        } while (bVar.f12811a != bVar2);
    }

    /* renamed from: a */
    public List<InterfaceC2271l<EH>> m15331a() {
        return C1156ai.m9911a(new Iterator<InterfaceC2271l<EH>>() { // from class: org.d.b.i.c.c.1

            /* renamed from: b */
            private b<EH> f12810b;

            {
                this.f12810b = C2426c.this.f12807a;
                this.f12810b = m15333a();
            }

            /* renamed from: a */
            protected b<EH> m15333a() {
                b<EH> bVar = this.f12810b.f12812b;
                if (bVar != C2426c.this.f12808b) {
                    while (bVar.f12812b != C2426c.this.f12808b && bVar.f12814d == bVar.f12812b.f12813c && bVar.mo14516c().equals(bVar.f12812b.mo14516c())) {
                        bVar.m15340e();
                    }
                    return bVar;
                }
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12810b != null;
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InterfaceC2271l<EH> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                b<EH> bVar = this.f12810b;
                this.f12810b = m15333a();
                return bVar;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }
}
