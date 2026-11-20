package p046b.p047a.p050c.p051a.p052a;

import p046b.p047a.p048a.C0460e;
import p046b.p047a.p050c.p051a.C0468a;
import p046b.p047a.p050c.p051a.C0491b;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.C0496g;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p047a.p050c.p053b.C0501a;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResReferenceValue.java */
/* renamed from: b.a.c.a.a.q */
/* loaded from: classes.dex */
public class C0485q extends C0483o {

    /* renamed from: b */
    private final C0492c f3402b;

    /* renamed from: e */
    private final boolean f3403e;

    public C0485q(C0492c c0492c, int i, String str) {
        this(c0492c, i, str, false);
    }

    public C0485q(C0492c c0492c, int i, String str, boolean z) {
        super(i, str, "reference");
        this.f3402b = c0492c;
        this.f3403e = z;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0483o, p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: a */
    protected String mo3632a() {
        if (m3646e()) {
            return "@null";
        }
        C0493d m3645c = m3645c();
        if (m3645c == null) {
            if (this.f3402b.m3666a()) {
                return String.format("@unktype/APKTOOL_DUMMY_%08x", new Integer(((C0483o) this).f3398a));
            }
            return "@null";
        }
        return new StringBuffer().append(new StringBuffer().append(this.f3403e ? '?' : '@').append(m3645c.m3691c() && (m3645c.m3689b().m3701d() instanceof C0481m) ? "+" : "").toString()).append(m3645c.m3683a(this.f3402b, this.f3403e && m3645c.m3695g().m3740a().equals(C0497h.f3457a))).toString();
    }

    /* renamed from: c */
    public C0493d m3645c() {
        try {
            return this.f3402b.m3677f().m3704a(m3643b());
        } catch (C0460e e2) {
            return m3644m();
        }
    }

    /* renamed from: e */
    public boolean m3646e() {
        return ((C0483o) this).f3398a == 0;
    }

    /* renamed from: f */
    public boolean m3647f() {
        return m3645c() == null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0099 -> B:6:0x000f). Please report as a decompilation issue!!! */
    /* renamed from: m */
    private C0493d m3644m() {
        C0493d c0493d;
        if (!this.f3402b.m3668a("id")) {
            c0493d = (C0493d) null;
        } else {
            C0491b c0491b = new C0491b(((C0483o) this).f3398a);
            C0497h m3670b = this.f3402b.m3670b("id");
            if (m3670b.m3742b() == c0491b.f3414b && this.f3402b.m3678g() > 1 && this.f3402b.m3678g() == c0491b.f3413a) {
                InterfaceC0541f m3681j = this.f3402b.m3681j();
                c0493d = new C0493d(c0491b, String.format("id_%08x", new Integer(((C0483o) this).f3398a)), 2, this.f3402b, C0501a.m3758a(), m3670b, this.f3402b.m3677f().m3702a(), m3681j, true);
                C0496g m3661a = this.f3402b.m3661a(new C0468a(m3681j));
                this.f3402b.m3672b(c0493d);
                m3670b.m3743b(c0493d);
                C0494e c0494e = new C0494e(m3661a, c0493d, this.f3402b.m3680i().m3658a(((C0483o) this).f3398a, (String) null));
                m3661a.m3737a(c0494e);
                c0493d.m3686a(c0494e);
            }
            c0493d = (C0493d) null;
        }
        return c0493d;
    }
}
