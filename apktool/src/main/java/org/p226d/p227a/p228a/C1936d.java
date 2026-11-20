package org.p226d.p227a.p228a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.p226d.p227a.C1950b;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p244d.C2152f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2196i;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2457k;
import org.p226d.p269d.C2464r;

/* compiled from: ClassDefinition.java */
/* renamed from: org.d.a.a.d */
/* loaded from: classes.dex */
public class C1936d {

    /* renamed from: a */
    public final C1950b f11317a;

    /* renamed from: b */
    public final InterfaceC2244d f11318b;

    /* renamed from: c */
    private final HashSet<String> f11319c;

    public C1936d(C1950b c1950b, InterfaceC2244d interfaceC2244d) {
        this.f11317a = c1950b;
        this.f11318b = interfaceC2244d;
        this.f11319c = m14124a(interfaceC2244d);
    }

    /* renamed from: a */
    private static HashSet<String> m14124a(InterfaceC2244d interfaceC2244d) {
        InterfaceC2268i mo14216h;
        InterfaceC2237b interfaceC2237b;
        HashSet<String> hashSet = new HashSet<>();
        for (InterfaceC2267h interfaceC2267h : interfaceC2244d.mo14202i()) {
            if (interfaceC2267h.mo14210b().equals("<clinit>") && (mo14216h = interfaceC2267h.mo14216h()) != null) {
                for (InterfaceC2218f interfaceC2218f : mo14216h.mo14608b()) {
                    switch (interfaceC2218f.mo14416a()) {
                        case SPUT:
                        case SPUT_BOOLEAN:
                        case SPUT_BYTE:
                        case SPUT_CHAR:
                        case SPUT_OBJECT:
                        case SPUT_SHORT:
                        case SPUT_WIDE:
                            try {
                                interfaceC2237b = (InterfaceC2237b) ((InterfaceC2196i) interfaceC2218f).mo14489f();
                            } catch (C2153g.a e2) {
                                interfaceC2237b = null;
                            }
                            if (interfaceC2237b != null && interfaceC2237b.mo14225d().equals(interfaceC2244d.mo14205l())) {
                                hashSet.add(C2389i.m15131b(interfaceC2237b));
                                break;
                            }
                            break;
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public void m14135a(C2457k c2457k) {
        m14126b(c2457k);
        m14129d(c2457k);
        m14130e(c2457k);
        m14131f(c2457k);
        m14132g(c2457k);
        m14125a(c2457k, m14133h(c2457k));
        m14127b(c2457k, m14134i(c2457k));
    }

    /* renamed from: b */
    private void m14126b(C2457k c2457k) {
        c2457k.write(".class ");
        m14128c(c2457k);
        c2457k.write(this.f11318b.mo14205l());
        c2457k.write(10);
    }

    /* renamed from: c */
    private void m14128c(C2457k c2457k) {
        for (EnumC1959a enumC1959a : EnumC1959a.m14185b(this.f11318b.mo14194a())) {
            c2457k.write(enumC1959a.toString());
            c2457k.write(32);
        }
    }

    /* renamed from: d */
    private void m14129d(C2457k c2457k) {
        String mo14195b = this.f11318b.mo14195b();
        if (mo14195b != null) {
            c2457k.write(".super ");
            c2457k.write(mo14195b);
            c2457k.write(10);
        }
    }

    /* renamed from: e */
    private void m14130e(C2457k c2457k) {
        String mo14197d = this.f11318b.mo14197d();
        if (mo14197d != null) {
            c2457k.write(".source \"");
            C2464r.m15561a(c2457k, mo14197d);
            c2457k.write("\"\n");
        }
    }

    /* renamed from: f */
    private void m14131f(C2457k c2457k) {
        List<String> mo14196c = this.f11318b.mo14196c();
        if (mo14196c.size() != 0) {
            c2457k.write(10);
            c2457k.write("# interfaces\n");
            for (String str : mo14196c) {
                c2457k.write(".implements ");
                c2457k.write(str);
                c2457k.write(10);
            }
        }
    }

    /* renamed from: g */
    private void m14132g(C2457k c2457k) {
        Set<? extends InterfaceC2165a> mo14198e = this.f11318b.mo14198e();
        if (mo14198e.size() != 0) {
            c2457k.write("\n\n");
            c2457k.write("# annotations\n");
            String str = null;
            if (this.f11317a.f11364j) {
                str = this.f11318b.mo14205l();
            }
            C1914a.m14087a(c2457k, mo14198e, str);
        }
    }

    /* renamed from: h */
    private Set<String> m14133h(C2457k c2457k) {
        Iterable<? extends InterfaceC2266g> mo14199f;
        boolean contains;
        C2457k c2457k2;
        HashSet hashSet = new HashSet();
        if (this.f11318b instanceof C2152f) {
            mo14199f = ((C2152f) this.f11318b).m14755a(false);
        } else {
            mo14199f = this.f11318b.mo14199f();
        }
        boolean z = false;
        for (InterfaceC2266g interfaceC2266g : mo14199f) {
            if (!z) {
                c2457k.write("\n\n");
                c2457k.write("# static fields");
                z = true;
            }
            c2457k.write(10);
            String m15131b = C2389i.m15131b(interfaceC2266g);
            if (!hashSet.add(m15131b)) {
                c2457k.write("# duplicate field ignored\n");
                c2457k2 = new C1939g(c2457k);
                System.err.println(String.format("Ignoring duplicate field: %s->%s", this.f11318b.mo14205l(), m15131b));
                contains = false;
            } else {
                contains = this.f11319c.contains(m15131b);
                c2457k2 = c2457k;
            }
            C1941i.m14138a(this.f11317a, c2457k2, interfaceC2266g, contains);
        }
        return hashSet;
    }

    /* renamed from: a */
    private void m14125a(C2457k c2457k, Set<String> set) {
        Iterable<? extends InterfaceC2266g> mo14200g;
        C2457k c2457k2;
        HashSet hashSet = new HashSet();
        if (this.f11318b instanceof C2152f) {
            mo14200g = ((C2152f) this.f11318b).m14756b(false);
        } else {
            mo14200g = this.f11318b.mo14200g();
        }
        boolean z = false;
        for (InterfaceC2266g interfaceC2266g : mo14200g) {
            if (!z) {
                c2457k.write("\n\n");
                c2457k.write("# instance fields");
                z = true;
            }
            c2457k.write(10);
            String m15131b = C2389i.m15131b(interfaceC2266g);
            if (!hashSet.add(m15131b)) {
                c2457k.write("# duplicate field ignored\n");
                c2457k2 = new C1939g(c2457k);
                System.err.println(String.format("Ignoring duplicate field: %s->%s", this.f11318b.mo14205l(), m15131b));
            } else {
                if (set.contains(m15131b)) {
                    System.err.println(String.format("Duplicate static+instance field found: %s->%s", this.f11318b.mo14205l(), m15131b));
                    System.err.println("You will need to rename one of these fields, including all references.");
                    c2457k.write("# There is both a static and instance field with this signature.\n# You will need to rename one of these fields, including all references.\n");
                }
                c2457k2 = c2457k;
            }
            C1941i.m14138a(this.f11317a, c2457k2, interfaceC2266g, false);
        }
    }

    /* renamed from: i */
    private Set<String> m14134i(C2457k c2457k) {
        Iterable<? extends InterfaceC2267h> mo14202i;
        C2457k c2457k2;
        boolean z = false;
        HashSet hashSet = new HashSet();
        if (this.f11318b instanceof C2152f) {
            mo14202i = ((C2152f) this.f11318b).m14757c(false);
        } else {
            mo14202i = this.f11318b.mo14202i();
        }
        for (InterfaceC2267h interfaceC2267h : mo14202i) {
            if (!z) {
                c2457k.write("\n\n");
                c2457k.write("# direct methods");
                z = true;
            }
            c2457k.write(10);
            if (hashSet.add(C2389i.m15121a((InterfaceC2240e) interfaceC2267h, true))) {
                c2457k2 = c2457k;
            } else {
                c2457k.write("# duplicate method ignored\n");
                c2457k2 = new C1939g(c2457k);
            }
            InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
            if (mo14216h == null) {
                C1943k.m14146a(c2457k2, interfaceC2267h, this.f11317a);
            } else {
                new C1943k(this, interfaceC2267h, mo14216h).m14156a(c2457k2);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    private void m14127b(C2457k c2457k, Set<String> set) {
        Iterable<? extends InterfaceC2267h> mo14203j;
        C2457k c2457k2;
        HashSet hashSet = new HashSet();
        if (this.f11318b instanceof C2152f) {
            mo14203j = ((C2152f) this.f11318b).m14758d(false);
        } else {
            mo14203j = this.f11318b.mo14203j();
        }
        boolean z = false;
        for (InterfaceC2267h interfaceC2267h : mo14203j) {
            if (!z) {
                c2457k.write("\n\n");
                c2457k.write("# virtual methods");
                z = true;
            }
            c2457k.write(10);
            String m15121a = C2389i.m15121a((InterfaceC2240e) interfaceC2267h, true);
            if (!hashSet.add(m15121a)) {
                c2457k.write("# duplicate method ignored\n");
                c2457k2 = new C1939g(c2457k);
            } else {
                if (set.contains(m15121a)) {
                    c2457k.write("# There is both a direct and virtual method with this signature.\n# You will need to rename one of these methods, including all references.\n");
                    System.err.println(String.format("Duplicate direct+virtual method found: %s->%s", this.f11318b.mo14205l(), m15121a));
                    System.err.println("You will need to rename one of these methods, including all references.");
                }
                c2457k2 = c2457k;
            }
            InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
            if (mo14216h == null) {
                C1943k.m14146a(c2457k2, interfaceC2267h, this.f11317a);
            } else {
                new C1943k(this, interfaceC2267h, mo14216h).m14156a(c2457k2);
            }
        }
    }
}
