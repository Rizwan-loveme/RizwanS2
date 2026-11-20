package org.p226d.p233b.p244d;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.p244d.p245a.AbstractC2091b;
import org.p226d.p233b.p244d.p248d.AbstractC2131b;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;
import org.p226d.p233b.p244d.p248d.AbstractC2139j;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p263h.AbstractC2381a;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedMethodImplementation.java */
/* renamed from: org.d.b.d.k */
/* loaded from: classes.dex */
public class C2157k implements InterfaceC2268i {

    /* renamed from: a */
    public final C2153g f12045a;

    /* renamed from: b */
    public final C2156j f12046b;

    /* renamed from: c */
    private final int f12047c;

    public C2157k(C2153g c2153g, C2156j c2156j, int i) {
        this.f12045a = c2153g;
        this.f12046b = c2156j;
        this.f12047c = i;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: d */
    public int mo14611d() {
        return this.f12045a.m14617c(this.f12047c);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: b */
    public Iterable<? extends InterfaceC2218f> mo14608b() {
        int a2 = this.f12045a.m14615a(this.f12047c + 12);
        final int i = this.f12047c + 16;
        final int i2 = (a2 * 2) + i;
        return new Iterable<InterfaceC2218f>() { // from class: org.d.b.d.k.1
            @Override // java.lang.Iterable
            public Iterator<InterfaceC2218f> iterator() {
                return new AbstractC2139j<InterfaceC2218f>(C2157k.this.f12045a, i) { // from class: org.d.b.d.k.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public InterfaceC2218f mo14714b(C2161o c2161o) {
                        if (c2161o.m14635a() >= i2) {
                            return m10002b();
                        }
                        InterfaceC2218f m14633a = AbstractC2091b.m14633a(c2161o);
                        int a3 = c2161o.m14635a();
                        if (a3 > i2 || a3 < 0) {
                            throw new C2453g("The last instruction in method %s is truncated", C2157k.this.f12046b);
                        }
                        return m14633a;
                    }
                };
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: e */
    public List<? extends C2159m> mo14612e() {
        final int c2 = this.f12045a.m14617c(this.f12047c + 6);
        if (c2 <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int m15070a = AbstractC2381a.m15070a((this.f12045a.m14615a(this.f12047c + 12) * 2) + this.f12047c + 16, 4);
        final int i = m15070a + (c2 * 8);
        return new AbstractC2133d<C2159m>() { // from class: org.d.b.d.k.2
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2159m mo14625b(int i2) {
                return new C2159m(C2157k.this.f12045a, m15070a + (i2 * 8), i);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return c2;
            }
        };
    }

    /* renamed from: c */
    private AbstractC2131b m14798c() {
        int g = this.f12045a.m14621g(this.f12047c + 8);
        if (g == -1 || g == 0) {
            return AbstractC2131b.m14708a(this.f12045a, 0, this);
        }
        if (g < 0) {
            System.err.println(String.format("%s: Invalid debug offset", this.f12046b));
            return AbstractC2131b.m14708a(this.f12045a, 0, this);
        }
        if (g >= this.f12045a.f11801a.length) {
            System.err.println(String.format("%s: Invalid debug offset", this.f12046b));
            return AbstractC2131b.m14708a(this.f12045a, 0, this);
        }
        return AbstractC2131b.m14708a(this.f12045a, g, this);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2268i
    /* renamed from: a */
    public Iterable<? extends InterfaceC2166a> mo14601a() {
        return m14798c();
    }

    /* renamed from: a */
    public Iterator<String> m14799a(C2161o c2161o) {
        return m14798c().mo14709a(c2161o);
    }
}
