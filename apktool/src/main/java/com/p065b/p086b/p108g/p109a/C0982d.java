package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C0997n;
import com.p065b.p086b.p108g.C1002s;
import com.p065b.p086b.p108g.C1005v;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: LivenessAnalyzer.java */
/* renamed from: com.b.b.g.a.d */
/* loaded from: classes.dex */
public class C0982d {

    /* renamed from: a */
    private final BitSet f6299a;

    /* renamed from: b */
    private final BitSet f6300b;

    /* renamed from: c */
    private final int f6301c;

    /* renamed from: d */
    private final C1005v f6302d;

    /* renamed from: e */
    private final C0981c f6303e;

    /* renamed from: f */
    private C1002s f6304f;

    /* renamed from: g */
    private int f6305g;

    /* renamed from: h */
    private a f6306h;

    /* compiled from: LivenessAnalyzer.java */
    /* renamed from: com.b.b.g.a.d$a */
    private enum a {
        LIVE_IN_AT_STATEMENT,
        LIVE_OUT_AT_STATEMENT,
        LIVE_OUT_AT_BLOCK,
        DONE
    }

    /* renamed from: a */
    public static C0981c m8189a(C1005v c1005v) {
        int m8424g = c1005v.m8424g();
        C0981c c0981c = new C0981c(m8424g);
        for (int i = 0; i < m8424g; i++) {
            new C0982d(c1005v, i, c0981c).m8195a();
        }
        m8190a(c1005v, c0981c);
        return c0981c;
    }

    private C0982d(C1005v c1005v, int i, C0981c c0981c) {
        int size = c1005v.m8427j().size();
        this.f6302d = c1005v;
        this.f6301c = i;
        this.f6299a = new BitSet(size);
        this.f6300b = new BitSet(size);
        this.f6303e = c0981c;
    }

    /* renamed from: b */
    private void m8191b() {
        while (this.f6306h != a.DONE) {
            switch (this.f6306h) {
                case LIVE_IN_AT_STATEMENT:
                    this.f6306h = a.DONE;
                    m8193d();
                    break;
                case LIVE_OUT_AT_STATEMENT:
                    this.f6306h = a.DONE;
                    m8194e();
                    break;
                case LIVE_OUT_AT_BLOCK:
                    this.f6306h = a.DONE;
                    m8192c();
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m8195a() {
        for (AbstractC1004u abstractC1004u : this.f6302d.m8420d(this.f6301c)) {
            this.f6306h = a.DONE;
            if (abstractC1004u instanceof C0997n) {
                Iterator<C1002s> it = ((C0997n) abstractC1004u).m8306a(this.f6301c, this.f6302d).iterator();
                while (it.hasNext()) {
                    this.f6304f = it.next();
                    this.f6306h = a.LIVE_OUT_AT_BLOCK;
                    m8191b();
                }
            } else {
                this.f6304f = abstractC1004u.m8392p();
                this.f6305g = this.f6304f.m8353c().indexOf(abstractC1004u);
                if (this.f6305g < 0) {
                    throw new RuntimeException("insn not found in it's own block");
                }
                this.f6306h = a.LIVE_IN_AT_STATEMENT;
                m8191b();
            }
        }
        while (true) {
            int nextSetBit = this.f6300b.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.f6304f = this.f6302d.m8427j().get(nextSetBit);
                this.f6300b.clear(nextSetBit);
                this.f6306h = a.LIVE_OUT_AT_BLOCK;
                m8191b();
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private void m8192c() {
        if (!this.f6299a.get(this.f6304f.m8358e())) {
            this.f6299a.set(this.f6304f.m8358e());
            this.f6304f.m8354c(this.f6301c);
            this.f6305g = this.f6304f.m8353c().size() - 1;
            this.f6306h = a.LIVE_OUT_AT_STATEMENT;
        }
    }

    /* renamed from: d */
    private void m8193d() {
        if (this.f6305g == 0) {
            this.f6304f.m8357d(this.f6301c);
            this.f6300b.mo13226or(this.f6304f.m8362h());
        } else {
            this.f6305g--;
            this.f6306h = a.LIVE_OUT_AT_STATEMENT;
        }
    }

    /* renamed from: e */
    private void m8194e() {
        AbstractC1004u abstractC1004u = this.f6304f.m8353c().get(this.f6305g);
        C0934p m8391o = abstractC1004u.m8391o();
        if (!abstractC1004u.m8389b(this.f6301c)) {
            if (m8391o != null) {
                this.f6303e.m8187a(this.f6301c, m8391o.m7931g());
            }
            this.f6306h = a.LIVE_IN_AT_STATEMENT;
        }
    }

    /* renamed from: a */
    private static void m8190a(C1005v c1005v, C0981c c0981c) {
        Iterator<C1002s> it = c1005v.m8427j().iterator();
        while (it.hasNext()) {
            List<AbstractC1004u> m8356d = it.next().m8356d();
            int size = m8356d.size();
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (i != i2) {
                        c0981c.m8187a(m8356d.get(i).m8391o().m7931g(), m8356d.get(i2).m8391o().m7931g());
                    }
                }
            }
        }
    }
}
