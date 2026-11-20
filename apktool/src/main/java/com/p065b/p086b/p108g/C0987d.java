package com.p065b.p086b.p108g;

import com.p065b.p086b.p110h.InterfaceC1026q;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* compiled from: DomFront.java */
/* renamed from: com.b.b.g.d */
/* loaded from: classes.dex */
public class C0987d {

    /* renamed from: a */
    private static boolean f6334a = false;

    /* renamed from: b */
    private final C1005v f6335b;

    /* renamed from: c */
    private final ArrayList<C1002s> f6336c;

    /* renamed from: d */
    private final a[] f6337d;

    /* compiled from: DomFront.java */
    /* renamed from: com.b.b.g.d$a */
    public static class a {

        /* renamed from: a */
        public InterfaceC1026q f6338a;

        /* renamed from: b */
        public int f6339b = -1;
    }

    public C0987d(C1005v c1005v) {
        this.f6335b = c1005v;
        this.f6336c = c1005v.m8427j();
        int size = this.f6336c.size();
        this.f6337d = new a[size];
        for (int i = 0; i < size; i++) {
            this.f6337d[i] = new a();
        }
    }

    /* renamed from: a */
    public a[] m8225a() {
        int size = this.f6336c.size();
        if (f6334a) {
            for (int i = 0; i < size; i++) {
                System.out.println("pred[" + i + "]: " + this.f6336c.get(i).m8362h());
            }
        }
        C0988e.m8226a(this.f6335b, this.f6337d, false);
        if (f6334a) {
            for (int i2 = 0; i2 < size; i2++) {
                System.out.println("idom[" + i2 + "]: " + this.f6337d[i2].f6339b);
            }
        }
        m8223c();
        if (f6334a) {
            m8222b();
        }
        for (int i3 = 0; i3 < size; i3++) {
            this.f6337d[i3].f6338a = C1001r.m8330a(size);
        }
        m8224d();
        if (f6334a) {
            for (int i4 = 0; i4 < size; i4++) {
                System.out.println("df[" + i4 + "]: " + this.f6337d[i4].f6338a);
            }
        }
        return this.f6337d;
    }

    /* renamed from: b */
    private void m8222b() {
        int size = this.f6336c.size();
        for (int i = 0; i < size; i++) {
            C1002s c1002s = this.f6336c.get(i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('{');
            Iterator<C1002s> it = c1002s.m8339a().iterator();
            boolean z = false;
            while (it.hasNext()) {
                C1002s next = it.next();
                if (z) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(next);
                z = true;
            }
            stringBuffer.append('}');
            System.out.println("domChildren[" + c1002s + "]: " + ((Object) stringBuffer));
        }
    }

    /* renamed from: c */
    private void m8223c() {
        int size = this.f6336c.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f6337d[i];
            if (aVar.f6339b != -1) {
                this.f6336c.get(aVar.f6339b).m8346a(this.f6336c.get(i));
            }
        }
    }

    /* renamed from: d */
    private void m8224d() {
        int size = this.f6336c.size();
        for (int i = 0; i < size; i++) {
            C1002s c1002s = this.f6336c.get(i);
            a aVar = this.f6337d[i];
            BitSet m8362h = c1002s.m8362h();
            if (m8362h.cardinality() > 1) {
                for (int nextSetBit = m8362h.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8362h.nextSetBit(nextSetBit + 1)) {
                    int i2 = nextSetBit;
                    while (i2 != aVar.f6339b && i2 != -1) {
                        a aVar2 = this.f6337d[i2];
                        if (!aVar2.f6338a.mo8480b(i)) {
                            aVar2.f6338a.mo8477a(i);
                            i2 = aVar2.f6339b;
                        }
                    }
                }
            }
        }
    }
}
