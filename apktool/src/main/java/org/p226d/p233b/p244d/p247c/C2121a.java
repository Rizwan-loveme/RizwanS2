package org.p226d.p233b.p244d.p247c;

import com.p129f.p130a.p133c.C1156ai;
import java.util.ArrayList;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1987a;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p248d.AbstractC2132c;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedCallSiteReference.java */
/* renamed from: org.d.b.d.c.a */
/* loaded from: classes.dex */
public class C2121a extends AbstractC1987a {

    /* renamed from: d */
    static final /* synthetic */ boolean f11840d;

    /* renamed from: a */
    public final C2153g f11841a;

    /* renamed from: b */
    public final int f11842b;

    /* renamed from: c */
    public final int f11843c;

    /* renamed from: e */
    private int f11844e = -1;

    static {
        f11840d = !C2121a.class.desiredAssertionStatus();
    }

    public C2121a(C2153g c2153g, int i) {
        this.f11841a = c2153g;
        this.f11842b = i;
        this.f11843c = c2153g.m14777p(i);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: a */
    public String mo14678a() {
        return String.format("call_site_%d", Integer.valueOf(this.f11842b));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: b */
    public InterfaceC2238c mo14679b() {
        if (m14676f().mo14721d() < 3) {
            throw new C2453g("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        InterfaceC2251g mo14718a = m14676f().mo14718a();
        if (!f11840d && mo14718a == null) {
            throw new AssertionError();
        }
        if (mo14718a.mo14430a() != 22) {
            throw new C2453g("Invalid encoded value type (%d) for the first item in call site %d", Integer.valueOf(mo14718a.mo14430a()), Integer.valueOf(this.f11842b));
        }
        return ((InterfaceC2258n) mo14718a).mo14740b();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: c */
    public String mo14680c() {
        AbstractC2132c m14676f = m14676f();
        if (m14676f.mo14721d() < 3) {
            throw new C2453g("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        m14676f.mo14719b();
        InterfaceC2251g mo14718a = m14676f.mo14718a();
        if (!f11840d && mo14718a == null) {
            throw new AssertionError();
        }
        if (mo14718a.mo14430a() != 23) {
            throw new C2453g("Invalid encoded value type (%d) for the second item in call site %d", Integer.valueOf(mo14718a.mo14430a()), Integer.valueOf(this.f11842b));
        }
        return ((InterfaceC2262r) mo14718a).mo14742b();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: d */
    public InterfaceC2239d mo14681d() {
        AbstractC2132c m14676f = m14676f();
        if (m14676f.mo14721d() < 3) {
            throw new C2453g("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        m14676f.mo14719b();
        m14676f.mo14719b();
        InterfaceC2251g mo14718a = m14676f.mo14718a();
        if (!f11840d && mo14718a == null) {
            throw new AssertionError();
        }
        if (mo14718a.mo14430a() != 21) {
            throw new C2453g("Invalid encoded value type (%d) for the second item in call site %d", Integer.valueOf(mo14718a.mo14430a()), Integer.valueOf(this.f11842b));
        }
        return ((InterfaceC2259o) mo14718a).mo14741b();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2236a
    /* renamed from: e */
    public List<? extends InterfaceC2251g> mo14682e() {
        ArrayList m9909a = C1156ai.m9909a();
        AbstractC2132c m14676f = m14676f();
        if (m14676f.mo14721d() < 3) {
            throw new C2453g("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        if (m14676f.mo14721d() != 3) {
            m14676f.mo14719b();
            m14676f.mo14719b();
            m14676f.mo14719b();
            for (InterfaceC2251g mo14718a = m14676f.mo14718a(); mo14718a != null; mo14718a = m14676f.mo14718a()) {
                m9909a.add(mo14718a);
            }
        }
        return m9909a;
    }

    /* renamed from: f */
    private AbstractC2132c m14676f() {
        return AbstractC2132c.m14717a(this.f11841a, m14677g());
    }

    /* renamed from: g */
    private int m14677g() {
        if (this.f11844e < 0) {
            this.f11844e = this.f11841a.m14615a(this.f11843c);
        }
        return this.f11844e;
    }
}
