package jadx.core.p182b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/* compiled from: PackageNode.java */
/* renamed from: jadx.core.b.f */
/* loaded from: classes.dex */
public class C1561f {

    /* renamed from: c */
    private final String f9987c;

    /* renamed from: d */
    private String f9988d;

    /* renamed from: e */
    private String f9989e;

    /* renamed from: f */
    private String f9990f;

    /* renamed from: b */
    private List<C1561f> f9986b = Collections.emptyList();

    /* renamed from: a */
    private C1561f f9985a = this;

    public C1561f(String str) {
        this.f9987c = str;
    }

    /* renamed from: a */
    public String m12069a() {
        return this.f9987c;
    }

    /* renamed from: b */
    public String m12073b() {
        if (this.f9989e == null) {
            Deque<C1561f> m12068h = m12068h();
            StringBuilder sb = new StringBuilder();
            sb.append(m12068h.pop().m12069a());
            while (!m12068h.isEmpty()) {
                sb.append('.');
                sb.append(m12068h.pop().m12069a());
            }
            this.f9989e = sb.toString();
        }
        return this.f9989e;
    }

    /* renamed from: c */
    public String m12074c() {
        return this.f9988d != null ? this.f9988d : this.f9987c;
    }

    /* renamed from: a */
    public void m12071a(String str) {
        this.f9988d = str;
    }

    /* renamed from: d */
    public boolean m12075d() {
        return this.f9988d != null;
    }

    /* renamed from: e */
    public String m12076e() {
        if (this.f9990f == null) {
            Deque<C1561f> m12068h = m12068h();
            StringBuilder sb = new StringBuilder();
            if (!m12068h.isEmpty()) {
                sb.append(m12068h.pop().m12074c());
                while (!m12068h.isEmpty()) {
                    sb.append('.');
                    sb.append(m12068h.pop().m12074c());
                }
            } else {
                sb.append(m12074c());
            }
            this.f9990f = sb.toString();
        }
        return this.f9990f;
    }

    /* renamed from: f */
    public C1561f m12077f() {
        return this.f9985a;
    }

    /* renamed from: g */
    public List<C1561f> m12078g() {
        return this.f9986b;
    }

    /* renamed from: a */
    public void m12070a(C1561f c1561f) {
        if (this.f9986b.isEmpty()) {
            this.f9986b = new ArrayList();
        }
        this.f9986b.add(c1561f);
        c1561f.f9985a = this;
    }

    /* renamed from: b */
    public C1561f m12072b(String str) {
        for (C1561f c1561f : this.f9986b) {
            if (c1561f.m12069a().equals(str)) {
                return c1561f;
            }
        }
        return null;
    }

    /* renamed from: h */
    private Deque<C1561f> m12068h() {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (C1561f m12077f = m12077f(); this != m12077f; m12077f = m12077f.m12077f()) {
            arrayDeque.push(this);
            this = m12077f;
        }
        return arrayDeque;
    }
}
