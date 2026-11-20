package com.p065b.p086b.p108g;

import com.p065b.p086b.p108g.C0987d;
import com.p065b.p086b.p108g.C1002s;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

/* compiled from: Dominators.java */
/* renamed from: com.b.b.g.e */
/* loaded from: classes.dex */
public final class C0988e {

    /* renamed from: a */
    private final boolean f6340a;

    /* renamed from: b */
    private final C1005v f6341b;

    /* renamed from: c */
    private final ArrayList<C1002s> f6342c;

    /* renamed from: d */
    private final a[] f6343d;

    /* renamed from: e */
    private final ArrayList<C1002s> f6344e = new ArrayList<>();

    /* renamed from: f */
    private final C0987d.a[] f6345f;

    /* compiled from: Dominators.java */
    /* renamed from: com.b.b.g.e$a */
    private static final class a {

        /* renamed from: a */
        public int f6346a;

        /* renamed from: b */
        public C1002s f6347b;

        /* renamed from: c */
        public C1002s f6348c;

        /* renamed from: d */
        public C1002s f6349d;

        /* renamed from: e */
        public ArrayList<C1002s> f6350e = new ArrayList<>();
    }

    private C0988e(C1005v c1005v, C0987d.a[] aVarArr, boolean z) {
        this.f6341b = c1005v;
        this.f6345f = aVarArr;
        this.f6340a = z;
        this.f6342c = c1005v.m8427j();
        this.f6343d = new a[this.f6342c.size() + 2];
    }

    /* renamed from: a */
    public static C0988e m8226a(C1005v c1005v, C0987d.a[] aVarArr, boolean z) {
        C0988e c0988e = new C0988e(c1005v, aVarArr, z);
        c0988e.m8229a();
        return c0988e;
    }

    /* renamed from: a */
    private BitSet m8228a(C1002s c1002s) {
        return this.f6340a ? c1002s.m8363i() : c1002s.m8362h();
    }

    /* renamed from: b */
    private void m8230b(C1002s c1002s) {
        if (this.f6343d[this.f6343d[c1002s.m8358e()].f6349d.m8358e()].f6349d != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            arrayList.add(c1002s);
            while (!arrayList.isEmpty()) {
                int size = arrayList.size();
                a aVar = this.f6343d[((C1002s) arrayList.get(size - 1)).m8358e()];
                C1002s c1002s2 = aVar.f6349d;
                a aVar2 = this.f6343d[c1002s2.m8358e()];
                if (hashSet.add(c1002s2) && aVar2.f6349d != null) {
                    arrayList.add(c1002s2);
                } else {
                    arrayList.remove(size - 1);
                    if (aVar2.f6349d != null) {
                        C1002s c1002s3 = aVar2.f6348c;
                        if (this.f6343d[c1002s3.m8358e()].f6346a < this.f6343d[aVar.f6348c.m8358e()].f6346a) {
                            aVar.f6348c = c1002s3;
                        }
                        aVar.f6349d = aVar2.f6349d;
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private C1002s m8232c(C1002s c1002s) {
        a aVar = this.f6343d[c1002s.m8358e()];
        if (aVar.f6349d != null) {
            m8230b(c1002s);
            return aVar.f6348c;
        }
        return c1002s;
    }

    /* renamed from: a */
    private void m8229a() {
        int i;
        C1002s m8423f = this.f6340a ? this.f6341b.m8423f() : this.f6341b.m8419d();
        if (m8423f != null) {
            this.f6344e.add(m8423f);
            this.f6345f[m8423f.m8358e()].f6339b = m8423f.m8358e();
        }
        this.f6341b.m8412a(this.f6340a, new b());
        int size = this.f6344e.size() - 1;
        for (int i2 = size; i2 >= 2; i2--) {
            C1002s c1002s = this.f6344e.get(i2);
            a aVar = this.f6343d[c1002s.m8358e()];
            BitSet m8228a = m8228a(c1002s);
            for (int nextSetBit = m8228a.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8228a.nextSetBit(nextSetBit + 1)) {
                C1002s c1002s2 = this.f6342c.get(nextSetBit);
                if (this.f6343d[c1002s2.m8358e()] != null && (i = this.f6343d[m8232c(c1002s2).m8358e()].f6346a) < aVar.f6346a) {
                    aVar.f6346a = i;
                }
            }
            this.f6343d[this.f6344e.get(aVar.f6346a).m8358e()].f6350e.add(c1002s);
            aVar.f6349d = aVar.f6347b;
            ArrayList<C1002s> arrayList = this.f6343d[aVar.f6347b.m8358e()].f6350e;
            while (!arrayList.isEmpty()) {
                C1002s remove = arrayList.remove(arrayList.size() - 1);
                C1002s m8232c = m8232c(remove);
                if (this.f6343d[m8232c.m8358e()].f6346a < this.f6343d[remove.m8358e()].f6346a) {
                    this.f6345f[remove.m8358e()].f6339b = m8232c.m8358e();
                } else {
                    this.f6345f[remove.m8358e()].f6339b = aVar.f6347b.m8358e();
                }
            }
        }
        for (int i3 = 2; i3 <= size; i3++) {
            C1002s c1002s3 = this.f6344e.get(i3);
            if (this.f6345f[c1002s3.m8358e()].f6339b != this.f6344e.get(this.f6343d[c1002s3.m8358e()].f6346a).m8358e()) {
                this.f6345f[c1002s3.m8358e()].f6339b = this.f6345f[this.f6345f[c1002s3.m8358e()].f6339b].f6339b;
            }
        }
    }

    /* compiled from: Dominators.java */
    /* renamed from: com.b.b.g.e$b */
    private class b implements C1002s.b {

        /* renamed from: b */
        private int f6352b;

        private b() {
            this.f6352b = 0;
        }

        @Override // com.p065b.p086b.p108g.C1002s.b
        /* renamed from: a */
        public void mo8207a(C1002s c1002s, C1002s c1002s2) {
            a aVar = new a();
            int i = this.f6352b + 1;
            this.f6352b = i;
            aVar.f6346a = i;
            aVar.f6348c = c1002s;
            aVar.f6347b = c1002s2;
            C0988e.this.f6344e.add(c1002s);
            C0988e.this.f6343d[c1002s.m8358e()] = aVar;
        }
    }
}
