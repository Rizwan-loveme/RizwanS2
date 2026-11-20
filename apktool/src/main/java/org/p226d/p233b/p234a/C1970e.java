package org.p226d.p233b.p234a;

import com.p129f.p130a.p131a.C1128w;
import com.p129f.p130a.p131a.InterfaceC1127v;
import com.p129f.p130a.p132b.AbstractC1134d;
import com.p129f.p130a.p132b.C1133c;
import com.p129f.p130a.p132b.InterfaceC1136f;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.C1156ai;
import java.p209io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p234a.p235a.C1961a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p256f.C2330d;

/* compiled from: ClassPath.java */
/* renamed from: org.d.b.a.e */
/* loaded from: classes.dex */
public class C1970e {

    /* renamed from: a */
    public final int f11456a;

    /* renamed from: c */
    private List<InterfaceC1973h> f11458c;

    /* renamed from: d */
    private final boolean f11459d;

    /* renamed from: e */
    private final AbstractC1134d<String, InterfaceC1981p> f11460e = new AbstractC1134d<String, InterfaceC1981p>() { // from class: org.d.b.a.e.1
        @Override // com.p129f.p130a.p132b.AbstractC1134d
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC1981p mo9629a(String str) {
            return str.charAt(0) == '[' ? new C1969d(C1970e.this, str) : new C1972g(C1970e.this, str);
        }
    };

    /* renamed from: f */
    private InterfaceC1136f<String, InterfaceC1981p> f11461f = C1133c.m9608a().m9611a(this.f11460e);

    /* renamed from: g */
    private final InterfaceC1127v<C1977l> f11462g = C1128w.m9593a((InterfaceC1127v) new InterfaceC1127v<C1977l>() { // from class: org.d.b.a.e.2
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1977l mo9592a() {
            return new C1977l(C1970e.this.m14275a());
        }
    });

    /* renamed from: b */
    private final InterfaceC1981p f11457b = new C1982q(this);

    public C1970e(Iterable<? extends InterfaceC1973h> iterable, boolean z, int i) {
        this.f11461f.mo9607a(this.f11457b.mo14265b(), this.f11457b);
        this.f11459d = z;
        this.f11456a = i;
        m14271b("Z");
        m14271b("B");
        m14271b("S");
        m14271b("C");
        m14271b("I");
        m14271b("J");
        m14271b("F");
        m14271b("D");
        m14271b("L");
        this.f11458c = C1156ai.m9910a(iterable);
        this.f11458c.add(m14272e());
    }

    /* renamed from: b */
    private void m14271b(String str) {
        this.f11461f.mo9607a(str, new C1979n(this, str));
    }

    /* renamed from: e */
    private static InterfaceC1973h m14272e() {
        return new C1974i(new C2330d(C2359g.m15022a(), AbstractC1148aa.m9797a(new C1961a(Class.class), new C1961a(Cloneable.class), new C1961a(Object.class), new C1961a(Serializable.class), new C1961a(String.class), new C1961a(Throwable.class), new C1961a[0])));
    }

    /* renamed from: a */
    public boolean m14275a() {
        return this.f11456a != -1;
    }

    /* renamed from: a */
    public InterfaceC1981p m14273a(CharSequence charSequence) {
        return this.f11461f.mo9630b(charSequence.toString());
    }

    /* renamed from: a */
    public InterfaceC2244d m14274a(String str) {
        Iterator<InterfaceC1973h> it = this.f11458c.iterator();
        while (it.hasNext()) {
            InterfaceC2244d mo14331a = it.next().mo14331a(str);
            if (mo14331a != null) {
                return mo14331a;
            }
        }
        throw new C1983r("Could not resolve class %s", str);
    }

    /* renamed from: b */
    public InterfaceC1981p m14276b() {
        return this.f11457b;
    }

    /* renamed from: c */
    public boolean m14277c() {
        return this.f11459d;
    }

    /* renamed from: d */
    public C1977l m14278d() {
        return this.f11462g.mo9592a();
    }
}
