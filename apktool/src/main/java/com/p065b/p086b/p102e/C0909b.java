package com.p065b.p086b.p102e;

import com.p065b.p086b.p095c.C0825c;
import com.p065b.p086b.p100d.C0874a;
import com.p065b.p086b.p100d.C0894b;
import com.p065b.p086b.p100d.C0895c;
import com.p065b.p086b.p100d.C0896d;
import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p100d.C0899g;
import com.p065b.p086b.p100d.C0902j;
import com.p065b.p086b.p100d.C0904l;
import com.p065b.p086b.p100d.C0907o;
import com.p065b.p086b.p110h.C1018i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: DexMerger.java */
/* renamed from: com.b.b.e.b */
/* loaded from: classes.dex */
public final class C0909b {

    /* renamed from: a */
    private final C0898f f5762a;

    /* renamed from: b */
    private final C0898f f5763b;

    /* renamed from: c */
    private final EnumC0908a f5764c;

    /* renamed from: d */
    private final b f5765d;

    /* renamed from: e */
    private final C0898f f5766e;

    /* renamed from: f */
    private final C0898f.a f5767f;

    /* renamed from: g */
    private final C0898f.a f5768g;

    /* renamed from: h */
    private final C0898f.a f5769h;

    /* renamed from: i */
    private final C0898f.a f5770i;

    /* renamed from: j */
    private final C0898f.a f5771j;

    /* renamed from: k */
    private final C0898f.a f5772k;

    /* renamed from: l */
    private final C0898f.a f5773l;

    /* renamed from: m */
    private final C0898f.a f5774m;

    /* renamed from: n */
    private final C0898f.a f5775n;

    /* renamed from: o */
    private final C0898f.a f5776o;

    /* renamed from: p */
    private final C0898f.a f5777p;

    /* renamed from: q */
    private final C0898f.a f5778q;

    /* renamed from: r */
    private final C0898f.a f5779r;

    /* renamed from: s */
    private final C0825c f5780s;

    /* renamed from: t */
    private final C0910c f5781t;

    /* renamed from: u */
    private final C0910c f5782u;

    /* renamed from: v */
    private final C0911d f5783v;

    /* renamed from: w */
    private final C0911d f5784w;

    /* renamed from: x */
    private int f5785x;

    public C0909b(C0898f c0898f, C0898f c0898f2, EnumC0908a enumC0908a) {
        this(c0898f, c0898f2, enumC0908a, new b(c0898f, c0898f2));
    }

    private C0909b(C0898f c0898f, C0898f c0898f2, EnumC0908a enumC0908a, b bVar) {
        this.f5766e = new C0898f();
        this.f5785x = 1048576;
        this.f5762a = c0898f;
        this.f5763b = c0898f2;
        this.f5764c = enumC0908a;
        this.f5765d = bVar;
        C0825c m7592a = c0898f.m7592a();
        C0825c m7592a2 = c0898f2.m7592a();
        this.f5781t = new C0910c(this.f5766e, m7592a);
        this.f5782u = new C0910c(this.f5766e, m7592a2);
        this.f5783v = new C0911d(this.f5781t);
        this.f5784w = new C0911d(this.f5782u);
        this.f5767f = this.f5766e.m7596a(bVar.f5801a, "header");
        this.f5768g = this.f5766e.m7596a(bVar.f5802b, "ids defs");
        this.f5780s = this.f5766e.m7592a();
        this.f5780s.f5141z = this.f5766e.m7600c();
        this.f5780s.f5123h.f5144c = this.f5766e.m7600c();
        this.f5780s.f5123h.f5143b = 1;
        this.f5769h = this.f5766e.m7596a(bVar.f5803c, "map list");
        this.f5780s.f5124i.f5144c = this.f5766e.m7600c();
        this.f5770i = this.f5766e.m7596a(bVar.f5804d, "type list");
        this.f5780s.f5125j.f5144c = this.f5766e.m7600c();
        this.f5778q = this.f5766e.m7596a(bVar.f5812l, "annotation set ref list");
        this.f5780s.f5126k.f5144c = this.f5766e.m7600c();
        this.f5777p = this.f5766e.m7596a(bVar.f5811k, "annotation sets");
        this.f5780s.f5127l.f5144c = this.f5766e.m7600c();
        this.f5771j = this.f5766e.m7596a(bVar.f5805e, "class data");
        this.f5780s.f5128m.f5144c = this.f5766e.m7600c();
        this.f5772k = this.f5766e.m7596a(bVar.f5806f, "code");
        this.f5780s.f5129n.f5144c = this.f5766e.m7600c();
        this.f5773l = this.f5766e.m7596a(bVar.f5807g, "string data");
        this.f5780s.f5130o.f5144c = this.f5766e.m7600c();
        this.f5774m = this.f5766e.m7596a(bVar.f5808h, "debug info");
        this.f5780s.f5131p.f5144c = this.f5766e.m7600c();
        this.f5779r = this.f5766e.m7596a(bVar.f5813m, "annotation");
        this.f5780s.f5132q.f5144c = this.f5766e.m7600c();
        this.f5775n = this.f5766e.m7596a(bVar.f5809i, "encoded array");
        this.f5780s.f5133r.f5144c = this.f5766e.m7600c();
        this.f5776o = this.f5766e.m7596a(bVar.f5810j, "annotations directory");
        this.f5766e.m7599b();
        this.f5780s.f5140y = this.f5766e.m7600c() - this.f5780s.f5141z;
    }

    /* renamed from: b */
    private C0898f m7715b() {
        m7719c();
        m7721d();
        m7723e();
        m7725f();
        m7727g();
        m7729h();
        m7731i();
        m7737l();
        m7733j();
        this.f5780s.f5116a.f5144c = 0;
        this.f5780s.f5116a.f5143b = 1;
        this.f5780s.f5137v = this.f5766e.m7600c();
        this.f5780s.m7190a();
        this.f5780s.m7191a(this.f5767f);
        this.f5780s.m7193b(this.f5769h);
        new C0899g().m7654c(this.f5766e);
        return this.f5766e;
    }

    /* renamed from: a */
    public C0898f m7744a() {
        long nanoTime = System.nanoTime();
        C0898f m7715b = m7715b();
        b clone = this.f5765d.clone();
        clone.m7775a(this);
        int m7776b = this.f5765d.m7776b() - clone.m7776b();
        if (m7776b > this.f5785x) {
            m7715b = new C0909b(this.f5766e, new C0898f(), EnumC0908a.FAIL, clone).m7715b();
            System.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", Float.valueOf(this.f5766e.m7600c() / 1024.0f), Float.valueOf(m7715b.m7600c() / 1024.0f), Float.valueOf(m7776b / 1024.0f));
        }
        System.out.printf("Merged dex A (%d defs/%.1fKiB) with dex B (%d defs/%.1fKiB). Result is %d defs/%.1fKiB. Took %.1fs%n", Integer.valueOf(this.f5762a.m7592a().f5122g.f5143b), Float.valueOf(this.f5762a.m7600c() / 1024.0f), Integer.valueOf(this.f5763b.m7592a().f5122g.f5143b), Float.valueOf(this.f5763b.m7600c() / 1024.0f), Integer.valueOf(m7715b.m7592a().f5122g.f5143b), Float.valueOf(m7715b.m7600c() / 1024.0f), Float.valueOf((System.nanoTime() - nanoTime) / 1.0E9f));
        return m7715b;
    }

    /* compiled from: DexMerger.java */
    /* renamed from: com.b.b.e.b$a */
    abstract class a<T extends Comparable<T>> {

        /* renamed from: a */
        private final C0898f.a f5793a;

        /* renamed from: a */
        abstract C0825c.a mo7745a(C0825c c0825c);

        /* renamed from: a */
        abstract void mo7747a(int i, C0910c c0910c, int i2, int i3);

        /* renamed from: a */
        abstract void mo7748a(T t);

        /* renamed from: b */
        abstract T mo7749b(C0898f.a aVar, C0910c c0910c, int i);

        protected a(C0898f.a aVar) {
            this.f5793a = aVar;
        }

        /* renamed from: a */
        public final void m7757a() {
            C0898f.a aVar;
            C0898f.a aVar2;
            T t;
            T t2;
            boolean z;
            boolean z2;
            T t3;
            C0825c.a mo7745a = mo7745a(C0909b.this.f5762a.m7592a());
            C0825c.a mo7745a2 = mo7745a(C0909b.this.f5763b.m7592a());
            mo7745a(C0909b.this.f5780s).f5144c = this.f5793a.m7621a();
            if (mo7745a.m7195a()) {
                aVar = C0909b.this.f5762a.m7595a(mo7745a.f5144c);
            } else {
                aVar = null;
            }
            if (mo7745a2.m7195a()) {
                aVar2 = C0909b.this.f5763b.m7595a(mo7745a2.f5144c);
            } else {
                aVar2 = null;
            }
            int i = -1;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            T t4 = null;
            T t5 = null;
            while (true) {
                if (t4 != null || i3 >= mo7745a.f5143b) {
                    t = t4;
                } else {
                    i = aVar.m7621a();
                    t = mo7749b(aVar, C0909b.this.f5781t, i3);
                }
                if (t5 != null || i4 >= mo7745a2.f5143b) {
                    t2 = t5;
                } else {
                    i2 = aVar2.m7621a();
                    t2 = mo7749b(aVar2, C0909b.this.f5782u, i4);
                }
                if (t != null && t2 != null) {
                    int compareTo = t.compareTo(t2);
                    boolean z3 = compareTo <= 0;
                    z = compareTo >= 0;
                    z2 = z3;
                } else {
                    boolean z4 = t != null;
                    z = t2 != null;
                    z2 = z4;
                }
                T t6 = null;
                if (z2) {
                    mo7747a(i, C0909b.this.f5781t, i3, i5);
                    t4 = null;
                    i = -1;
                    t6 = t;
                    i3++;
                } else {
                    t4 = t;
                }
                if (z) {
                    mo7747a(i2, C0909b.this.f5782u, i4, i5);
                    t3 = null;
                    i2 = -1;
                    t6 = t2;
                    i4++;
                } else {
                    t3 = t2;
                }
                if (t6 == null) {
                    mo7745a(C0909b.this.f5780s).f5143b = i5;
                    return;
                } else {
                    mo7748a((a<T>) t6);
                    i5++;
                    t5 = t3;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        public final void m7758b() {
            int i = 0;
            mo7745a(C0909b.this.f5780s).f5144c = this.f5793a.m7621a();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(m7756a(C0909b.this.f5762a, C0909b.this.f5781t));
            arrayList.addAll(m7756a(C0909b.this.f5763b, C0909b.this.f5782u));
            Collections.sort(arrayList);
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 >= arrayList.size()) {
                    mo7745a(C0909b.this.f5780s).f5143b = i3;
                    return;
                }
                int i4 = i2 + 1;
                C3333a c3333a = (C3333a) arrayList.get(i2);
                mo7747a(c3333a.f5799e, C0909b.this.m7702a(c3333a.f5795a), c3333a.f5798d, i3 - 1);
                while (i4 < arrayList.size() && c3333a.compareTo((C3333a) arrayList.get(i4)) == 0) {
                    C3333a c3333a2 = (C3333a) arrayList.get(i4);
                    mo7747a(c3333a2.f5799e, C0909b.this.m7702a(c3333a2.f5795a), c3333a2.f5798d, i3 - 1);
                    i4++;
                }
                mo7748a((a<T>) c3333a.f5797c);
                i = i3 + 1;
                i2 = i4;
            }
        }

        /* renamed from: a */
        private List<a<T>.C3333a> m7756a(C0898f c0898f, C0910c c0910c) {
            C0825c.a mo7745a = mo7745a(c0898f.m7592a());
            if (!mo7745a.m7195a()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            C0898f.a m7595a = c0898f.m7595a(mo7745a.f5144c);
            for (int i = 0; i < mo7745a.f5143b; i++) {
                arrayList.add(new C3333a(c0898f, c0910c, mo7749b(m7595a, c0910c, 0), i, m7595a.m7621a()));
            }
            return arrayList;
        }

        /* compiled from: DexMerger.java */
        /* renamed from: com.b.b.e.b$a$a, reason: collision with other inner class name */
        class C3333a implements Comparable<a<T>.C3333a> {

            /* renamed from: a */
            final C0898f f5795a;

            /* renamed from: b */
            final C0910c f5796b;

            /* renamed from: c */
            final T f5797c;

            /* renamed from: d */
            final int f5798d;

            /* renamed from: e */
            final int f5799e;

            C3333a(C0898f c0898f, C0910c c0910c, T t, int i, int i2) {
                this.f5795a = c0898f;
                this.f5796b = c0910c;
                this.f5797c = t;
                this.f5798d = i;
                this.f5799e = i2;
            }

            @Override // java.lang.Comparable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compareTo(a<T>.C3333a c3333a) {
                return this.f5797c.compareTo(c3333a.f5797c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0910c m7702a(C0898f c0898f) {
        if (c0898f == this.f5762a) {
            return this.f5781t;
        }
        if (c0898f == this.f5763b) {
            return this.f5782u;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    private void m7719c() {
        new a<String>(this.f5768g) { // from class: com.b.b.e.b.1
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5117b;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return aVar.m7641i();
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.f5814a[i2] = i3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(String str) {
                C0909b.this.f5780s.f5129n.f5143b++;
                C0909b.this.f5768g.m7635e(C0909b.this.f5773l.m7621a());
                C0909b.this.f5773l.m7623a(str);
            }
        }.m7757a();
    }

    /* renamed from: d */
    private void m7721d() {
        new a<Integer>(this.f5768g) { // from class: com.b.b.e.b.2
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5118c;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return Integer.valueOf(c0910c.m7777a(aVar.m7628b()));
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.f5815b[i2] = (short) i3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(Integer num) {
                C0909b.this.f5768g.m7635e(num.intValue());
            }
        }.m7757a();
    }

    /* renamed from: e */
    private void m7723e() {
        new a<C0913f>(this.f5770i) { // from class: com.b.b.e.b.3
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5124i;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0913f mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return c0910c.m7785a(aVar.m7640h());
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.m7786a(i, C0909b.this.f5770i.m7621a());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(C0913f c0913f) {
                C0909b.this.f5770i.m7622a(c0913f);
            }
        }.m7758b();
    }

    /* renamed from: f */
    private void m7725f() {
        new a<C0907o>(this.f5768g) { // from class: com.b.b.e.b.4
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5119d;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0907o mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return c0910c.m7783a(aVar.m7644l());
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.f5816c[i2] = (short) i3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(C0907o c0907o) {
                c0907o.m7698a(C0909b.this.f5768g);
            }
        }.m7757a();
    }

    /* renamed from: g */
    private void m7727g() {
        new a<C0902j>(this.f5768g) { // from class: com.b.b.e.b.5
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5120e;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0902j mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return c0910c.m7781a(aVar.m7642j());
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.f5817d[i2] = (short) i3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(C0902j c0902j) {
                c0902j.m7676a(C0909b.this.f5768g);
            }
        }.m7757a();
    }

    /* renamed from: h */
    private void m7729h() {
        new a<C0904l>(this.f5768g) { // from class: com.b.b.e.b.6
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5121f;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0904l mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return c0910c.m7782a(aVar.m7643k());
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.f5818e[i2] = (short) i3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(C0904l c0904l) {
                c0904l.m7681a(C0909b.this.f5768g);
            }
        }.m7757a();
    }

    /* renamed from: i */
    private void m7731i() {
        new a<C0874a>(this.f5779r) { // from class: com.b.b.e.b.7
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            C0825c.a mo7745a(C0825c c0825c) {
                return c0825c.f5131p;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0874a mo7749b(C0898f.a aVar, C0910c c0910c, int i) {
                return c0910c.m7778a(aVar.m7646n());
            }

            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a */
            void mo7747a(int i, C0910c c0910c, int i2, int i3) {
                c0910c.m7789b(i, C0909b.this.f5779r.m7621a());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.p065b.p086b.p102e.C0909b.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo7748a(C0874a c0874a) {
                c0874a.m7443a(C0909b.this.f5779r);
            }
        }.m7758b();
    }

    /* renamed from: j */
    private void m7733j() {
        C0912e[] m7735k = m7735k();
        this.f5780s.f5122g.f5144c = this.f5768g.m7621a();
        this.f5780s.f5122g.f5143b = m7735k.length;
        for (C0912e c0912e : m7735k) {
            C0898f m7808a = c0912e.m7808a();
            m7707a(m7808a, c0912e.m7810b(), m7808a == this.f5762a ? this.f5781t : this.f5782u);
        }
    }

    /* renamed from: k */
    private C0912e[] m7735k() {
        boolean z;
        C0912e[] c0912eArr = new C0912e[this.f5780s.f5118c.f5143b];
        m7714a(c0912eArr, this.f5762a, this.f5781t);
        m7714a(c0912eArr, this.f5763b, this.f5782u);
        do {
            z = true;
            for (C0912e c0912e : c0912eArr) {
                if (c0912e != null && !c0912e.m7812d()) {
                    z &= c0912e.m7809a(c0912eArr);
                }
            }
        } while (!z);
        Arrays.sort(c0912eArr, C0912e.f5835a);
        int indexOf = Arrays.asList(c0912eArr).indexOf(null);
        return indexOf != -1 ? (C0912e[]) Arrays.copyOfRange(c0912eArr, 0, indexOf) : c0912eArr;
    }

    /* renamed from: a */
    private void m7714a(C0912e[] c0912eArr, C0898f c0898f, C0910c c0910c) {
        for (C0895c c0895c : c0898f.m7605h()) {
            C0912e m7784a = c0910c.m7784a(new C0912e(c0898f, c0895c));
            int m7811c = m7784a.m7811c();
            if (c0912eArr[m7811c] == null) {
                c0912eArr[m7811c] = m7784a;
            } else if (this.f5764c != EnumC0908a.KEEP_FIRST) {
                throw new C1018i("Multiple dex files define " + c0898f.m7603f().get(c0895c.m7554b()));
            }
        }
    }

    /* renamed from: l */
    private void m7737l() {
        m7710a(this.f5762a, this.f5781t);
        m7710a(this.f5763b, this.f5782u);
        m7717b(this.f5762a, this.f5781t);
        m7717b(this.f5763b, this.f5782u);
    }

    /* renamed from: a */
    private void m7710a(C0898f c0898f, C0910c c0910c) {
        C0825c.a aVar = c0898f.m7592a().f5126k;
        if (aVar.m7195a()) {
            C0898f.a m7595a = c0898f.m7595a(aVar.f5144c);
            for (int i = 0; i < aVar.f5143b; i++) {
                m7712a(c0910c, m7595a);
            }
        }
    }

    /* renamed from: b */
    private void m7717b(C0898f c0898f, C0910c c0910c) {
        C0825c.a aVar = c0898f.m7592a().f5133r;
        if (aVar.m7195a()) {
            C0898f.a m7595a = c0898f.m7595a(aVar.f5144c);
            for (int i = 0; i < aVar.f5143b; i++) {
                m7709a(c0898f, m7595a, c0910c);
            }
        }
    }

    /* renamed from: a */
    private void m7707a(C0898f c0898f, C0895c c0895c, C0910c c0910c) {
        this.f5768g.m7650r();
        this.f5768g.m7635e(c0895c.m7554b());
        this.f5768g.m7635e(c0895c.m7558f());
        this.f5768g.m7635e(c0895c.m7555c());
        this.f5768g.m7635e(c0895c.m7556d());
        this.f5768g.m7635e(c0910c.m7777a(c0895c.m7559g()));
        this.f5768g.m7635e(c0910c.m7798i(c0895c.m7560h()));
        if (c0895c.m7561i() == 0) {
            this.f5768g.m7635e(0);
        } else {
            this.f5768g.m7635e(this.f5771j.m7621a());
            m7706a(c0898f, c0898f.m7593a(c0895c), c0910c);
        }
        int m7562j = c0895c.m7562j();
        if (m7562j == 0) {
            this.f5768g.m7635e(0);
            return;
        }
        C0898f.a m7595a = c0898f.m7595a(m7562j);
        this.f5768g.m7635e(this.f5775n.m7621a());
        m7705a(m7595a, c0910c);
    }

    /* renamed from: a */
    private void m7709a(C0898f c0898f, C0898f.a aVar, C0910c c0910c) {
        this.f5780s.f5133r.f5143b++;
        this.f5776o.m7650r();
        c0910c.m7793d(aVar.m7621a(), this.f5776o.m7621a());
        this.f5776o.m7635e(c0910c.m7797h(aVar.m7628b()));
        int m7628b = aVar.m7628b();
        this.f5776o.m7635e(m7628b);
        int m7628b2 = aVar.m7628b();
        this.f5776o.m7635e(m7628b2);
        int m7628b3 = aVar.m7628b();
        this.f5776o.m7635e(m7628b3);
        for (int i = 0; i < m7628b; i++) {
            this.f5776o.m7635e(c0910c.m7792d(aVar.m7628b()));
            this.f5776o.m7635e(c0910c.m7797h(aVar.m7628b()));
        }
        for (int i2 = 0; i2 < m7628b2; i2++) {
            this.f5776o.m7635e(c0910c.m7794e(aVar.m7628b()));
            this.f5776o.m7635e(c0910c.m7797h(aVar.m7628b()));
        }
        for (int i3 = 0; i3 < m7628b3; i3++) {
            this.f5780s.f5125j.f5143b++;
            this.f5778q.m7650r();
            this.f5776o.m7635e(c0910c.m7794e(aVar.m7628b()));
            this.f5776o.m7635e(this.f5778q.m7621a());
            C0898f.a m7595a = c0898f.m7595a(aVar.m7628b());
            int m7628b4 = m7595a.m7628b();
            this.f5778q.m7635e(m7628b4);
            for (int i4 = 0; i4 < m7628b4; i4++) {
                this.f5778q.m7635e(c0910c.m7797h(m7595a.m7628b()));
            }
        }
    }

    /* renamed from: a */
    private void m7712a(C0910c c0910c, C0898f.a aVar) {
        this.f5780s.f5126k.f5143b++;
        this.f5777p.m7650r();
        c0910c.m7791c(aVar.m7621a(), this.f5777p.m7621a());
        int m7628b = aVar.m7628b();
        this.f5777p.m7635e(m7628b);
        for (int i = 0; i < m7628b; i++) {
            this.f5777p.m7635e(c0910c.m7796g(aVar.m7628b()));
        }
    }

    /* renamed from: a */
    private void m7706a(C0898f c0898f, C0894b c0894b, C0910c c0910c) {
        this.f5780s.f5127l.f5143b++;
        C0894b.a[] m7544a = c0894b.m7544a();
        C0894b.a[] m7545b = c0894b.m7545b();
        C0894b.b[] m7546c = c0894b.m7546c();
        C0894b.b[] m7547d = c0894b.m7547d();
        this.f5771j.m7637f(m7544a.length);
        this.f5771j.m7637f(m7545b.length);
        this.f5771j.m7637f(m7546c.length);
        this.f5771j.m7637f(m7547d.length);
        m7713a(c0910c, m7544a);
        m7713a(c0910c, m7545b);
        m7711a(c0898f, c0910c, m7546c);
        m7711a(c0898f, c0910c, m7547d);
    }

    /* renamed from: a */
    private void m7713a(C0910c c0910c, C0894b.a[] aVarArr) {
        int length = aVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C0894b.a aVar = aVarArr[i];
            int m7792d = c0910c.m7792d(aVar.m7548a());
            this.f5771j.m7637f(m7792d - i2);
            this.f5771j.m7637f(aVar.m7549b());
            i++;
            i2 = m7792d;
        }
    }

    /* renamed from: a */
    private void m7711a(C0898f c0898f, C0910c c0910c, C0894b.b[] bVarArr) {
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C0894b.b bVar = bVarArr[i];
            int m7794e = c0910c.m7794e(bVar.m7550a());
            this.f5771j.m7637f(m7794e - i2);
            this.f5771j.m7637f(bVar.m7551b());
            if (bVar.m7552c() == 0) {
                this.f5771j.m7637f(0);
            } else {
                this.f5772k.m7649q();
                this.f5771j.m7637f(this.f5772k.m7621a());
                m7708a(c0898f, c0898f.m7594a(bVar), c0910c);
            }
            i++;
            i2 = m7794e;
        }
    }

    /* renamed from: a */
    private void m7708a(C0898f c0898f, C0896d c0896d, C0910c c0910c) {
        this.f5780s.f5128m.f5143b++;
        this.f5772k.m7650r();
        this.f5772k.m7633d(c0896d.m7563a());
        this.f5772k.m7633d(c0896d.m7564b());
        this.f5772k.m7633d(c0896d.m7565c());
        C0896d.b[] m7567e = c0896d.m7567e();
        this.f5772k.m7633d(m7567e.length);
        this.f5772k.m7635e(0);
        short[] m7806a = (c0898f == this.f5762a ? this.f5783v : this.f5784w).m7806a(c0896d.m7566d());
        this.f5772k.m7635e(m7806a.length);
        this.f5772k.m7626a(m7806a);
        if (m7567e.length > 0) {
            if (m7806a.length % 2 == 1) {
                this.f5772k.m7624a((short) 0);
            }
            for (C0896d.b bVar : m7567e) {
                this.f5772k.m7635e(bVar.m7572a());
                this.f5772k.m7633d(bVar.m7573b());
                this.f5772k.m7633d(bVar.m7574c());
            }
            C0896d.a[] m7568f = c0896d.m7568f();
            this.f5772k.m7637f(m7568f.length);
            for (C0896d.a aVar : m7568f) {
                m7704a(aVar, c0910c);
            }
        }
    }

    /* renamed from: a */
    private void m7704a(C0896d.a aVar, C0910c c0910c) {
        int m7571c = aVar.m7571c();
        int[] m7569a = aVar.m7569a();
        int[] m7570b = aVar.m7570b();
        if (m7571c != -1) {
            this.f5772k.m7639g(-m7569a.length);
        } else {
            this.f5772k.m7639g(m7569a.length);
        }
        for (int i = 0; i < m7569a.length; i++) {
            this.f5772k.m7637f(c0910c.m7787b(m7569a[i]));
            this.f5772k.m7637f(m7570b[i]);
        }
        if (m7571c != -1) {
            this.f5772k.m7637f(m7571c);
        }
    }

    /* renamed from: a */
    private void m7705a(C0898f.a aVar, C0910c c0910c) {
        this.f5780s.f5132q.f5143b++;
        c0910c.m7788b(aVar.m7648p()).m7657a(this.f5775n);
    }

    /* compiled from: DexMerger.java */
    /* renamed from: com.b.b.e.b$b */
    private static class b implements Cloneable {

        /* renamed from: a */
        private int f5801a = 112;

        /* renamed from: b */
        private int f5802b;

        /* renamed from: c */
        private int f5803c;

        /* renamed from: d */
        private int f5804d;

        /* renamed from: e */
        private int f5805e;

        /* renamed from: f */
        private int f5806f;

        /* renamed from: g */
        private int f5807g;

        /* renamed from: h */
        private int f5808h;

        /* renamed from: i */
        private int f5809i;

        /* renamed from: j */
        private int f5810j;

        /* renamed from: k */
        private int f5811k;

        /* renamed from: l */
        private int f5812l;

        /* renamed from: m */
        private int f5813m;

        public b(C0898f c0898f, C0898f c0898f2) {
            m7774a(c0898f.m7592a(), false);
            m7774a(c0898f2.m7592a(), false);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public void m7774a(C0825c c0825c, boolean z) {
            this.f5802b += (c0825c.f5117b.f5143b * 4) + (c0825c.f5118c.f5143b * 4) + (c0825c.f5119d.f5143b * 12) + (c0825c.f5120e.f5143b * 8) + (c0825c.f5121f.f5143b * 8) + (c0825c.f5122g.f5143b * 32);
            this.f5803c = (c0825c.f5134s.length * 12) + 4;
            this.f5804d += c0825c.f5124i.f5145d;
            this.f5807g += c0825c.f5129n.f5145d;
            this.f5808h += c0825c.f5130o.f5145d;
            this.f5810j += c0825c.f5133r.f5145d;
            this.f5811k += c0825c.f5126k.f5145d;
            this.f5812l += c0825c.f5125j.f5145d;
            if (z) {
                this.f5806f += c0825c.f5128m.f5145d;
                this.f5805e += c0825c.f5127l.f5145d;
                this.f5809i += c0825c.f5132q.f5145d;
                this.f5813m += c0825c.f5131p.f5145d;
                return;
            }
            this.f5806f += (int) Math.ceil(c0825c.f5128m.f5145d * 1.25d);
            this.f5805e += (int) Math.ceil(c0825c.f5127l.f5145d * 1.34d);
            this.f5809i += c0825c.f5132q.f5145d * 2;
            this.f5813m += (int) Math.ceil(c0825c.f5131p.f5145d * 1.34d);
        }

        /* renamed from: a */
        public void m7775a(C0909b c0909b) {
            this.f5801a -= c0909b.f5767f.m7651s();
            this.f5802b -= c0909b.f5768g.m7651s();
            this.f5803c -= c0909b.f5769h.m7651s();
            this.f5804d -= c0909b.f5770i.m7651s();
            this.f5805e -= c0909b.f5771j.m7651s();
            this.f5806f -= c0909b.f5772k.m7651s();
            this.f5807g -= c0909b.f5773l.m7651s();
            this.f5808h -= c0909b.f5774m.m7651s();
            this.f5809i -= c0909b.f5775n.m7651s();
            this.f5810j -= c0909b.f5776o.m7651s();
            this.f5811k -= c0909b.f5777p.m7651s();
            this.f5812l -= c0909b.f5778q.m7651s();
            this.f5813m -= c0909b.f5779r.m7651s();
        }

        /* renamed from: b */
        public int m7776b() {
            return this.f5801a + this.f5802b + this.f5803c + this.f5804d + this.f5805e + this.f5806f + this.f5807g + this.f5808h + this.f5809i + this.f5810j + this.f5811k + this.f5812l + this.f5813m;
        }
    }
}
