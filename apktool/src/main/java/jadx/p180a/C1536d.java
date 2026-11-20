package jadx.p180a;

import jadx.core.C1544a;
import jadx.core.C1555b;
import jadx.core.p181a.C1547c;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.C1650p;
import jadx.core.p183c.p197g.InterfaceC1712l;
import jadx.core.p203d.p205b.C1729f;
import jadx.core.p203d.p206c.C1732b;
import jadx.core.p207e.C1746a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: JadxDecompiler.java */
/* renamed from: jadx.a.d */
/* loaded from: classes.dex */
public final class C1536d {

    /* renamed from: a */
    private static final InterfaceC2558b f9859a = C2568c.m15995a((Class<?>) C1536d.class);

    /* renamed from: b */
    private C1534b f9860b;

    /* renamed from: c */
    private final List<C1732b> f9861c;

    /* renamed from: d */
    private C1650p f9862d;

    /* renamed from: e */
    private List<InterfaceC1712l> f9863e;

    /* renamed from: f */
    private C1547c f9864f;

    /* renamed from: g */
    private List<C1537e> f9865g;

    /* renamed from: h */
    private List<C1541i> f9866h;

    /* renamed from: i */
    private C1746a f9867i;

    /* renamed from: j */
    private Map<C1636b, C1537e> f9868j;

    /* renamed from: k */
    private Map<C1648n, C1539g> f9869k;

    /* renamed from: l */
    private Map<C1639e, C1538f> f9870l;

    public C1536d() {
        this(new C1534b());
    }

    public C1536d(C1534b c1534b) {
        this.f9861c = new ArrayList();
        this.f9868j = new ConcurrentHashMap();
        this.f9869k = new ConcurrentHashMap();
        this.f9870l = new ConcurrentHashMap();
        this.f9860b = c1534b;
    }

    /* renamed from: a */
    public void m11793a() {
        m11796c();
        C1535c.m11783a(this.f9860b);
        m11795b();
        f9859a.mo15935b("loading ...");
        m11790a(this.f9860b.m11756a());
        this.f9862d = new C1650p(this.f9860b);
        this.f9862d.m12657a(this.f9861c);
        this.f9862d.m12655a();
        this.f9862d.m12660b(m11798f());
        m11792j();
    }

    /* renamed from: b */
    void m11795b() {
        this.f9863e = C1544a.m11831a(this.f9860b);
        this.f9864f = new C1547c();
    }

    /* renamed from: c */
    void m11796c() {
        this.f9865g = null;
        this.f9866h = null;
        this.f9867i = null;
        this.f9862d = null;
        this.f9863e = null;
        this.f9864f = null;
    }

    /* renamed from: d */
    public static String m11791d() {
        return C1544a.m11830a();
    }

    /* renamed from: a */
    private void m11790a(List<File> list) {
        if (list.isEmpty()) {
            throw new C1729f("Empty file list");
        }
        this.f9861c.clear();
        for (File file : list) {
            try {
                C1732b.m13241a(file, this.f9861c, this.f9860b.m11775j());
            } catch (Exception e2) {
                throw new C1729f("Error load file: " + file, e2);
            }
        }
    }

    /* renamed from: e */
    public List<C1537e> m11797e() {
        if (this.f9862d == null) {
            return Collections.emptyList();
        }
        if (this.f9865g == null) {
            List<C1636b> m12654a = this.f9862d.m12654a(false);
            ArrayList arrayList = new ArrayList(m12654a.size());
            this.f9868j.clear();
            for (C1636b c1636b : m12654a) {
                C1537e c1537e = new C1537e(c1636b, this);
                arrayList.add(c1537e);
                this.f9868j.put(c1636b, c1537e);
            }
            this.f9865g = Collections.unmodifiableList(arrayList);
        }
        return this.f9865g;
    }

    /* renamed from: f */
    public List<C1541i> m11798f() {
        if (this.f9866h == null) {
            if (this.f9862d == null) {
                return Collections.emptyList();
            }
            this.f9866h = new C1543k(this).m11828a(this.f9861c);
        }
        return this.f9866h;
    }

    /* renamed from: j */
    private void m11792j() {
        for (InterfaceC1712l interfaceC1712l : this.f9863e) {
            try {
                interfaceC1712l.mo12780a(this.f9862d);
            } catch (Exception e2) {
                f9859a.mo15943c("Visitor init failed: {}", interfaceC1712l.getClass().getSimpleName(), e2);
            }
        }
    }

    /* renamed from: a */
    void m11794a(C1636b c1636b) {
        C1555b.m12010a(c1636b, this.f9863e, this.f9864f);
    }

    /* renamed from: g */
    Map<C1636b, C1537e> m11799g() {
        return this.f9868j;
    }

    /* renamed from: h */
    Map<C1648n, C1539g> m11800h() {
        return this.f9869k;
    }

    /* renamed from: i */
    Map<C1639e, C1538f> m11801i() {
        return this.f9870l;
    }

    public String toString() {
        return "jadx decompiler " + m11791d();
    }
}
