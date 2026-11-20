package jadx.core.p183c.p196f;

import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p203d.C1739h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExceptionHandler.java */
/* renamed from: jadx.core.c.f.c */
/* loaded from: classes.dex */
public class C1666c {

    /* renamed from: a */
    private final C1590b f10466a;

    /* renamed from: b */
    private final int f10467b;

    /* renamed from: c */
    private C1628a f10468c;

    /* renamed from: d */
    private final List<C1628a> f10469d = new ArrayList();

    /* renamed from: e */
    private InterfaceC1642h f10470e;

    /* renamed from: f */
    private AbstractC1598c f10471f;

    /* renamed from: g */
    private C1668e f10472g;

    /* renamed from: h */
    private boolean f10473h;

    public C1666c(int i, C1590b c1590b) {
        this.f10467b = i;
        this.f10466a = c1590b;
    }

    /* renamed from: a */
    public C1590b m12750a() {
        return this.f10466a;
    }

    /* renamed from: b */
    public boolean m12757b() {
        return this.f10466a == null || this.f10466a.m12202d().equals("java.lang.Throwable");
    }

    /* renamed from: c */
    public int m12758c() {
        return this.f10467b;
    }

    /* renamed from: d */
    public C1628a m12759d() {
        return this.f10468c;
    }

    /* renamed from: a */
    public void m12752a(C1628a c1628a) {
        this.f10468c = c1628a;
    }

    /* renamed from: e */
    public List<C1628a> m12760e() {
        return this.f10469d;
    }

    /* renamed from: b */
    public void m12756b(C1628a c1628a) {
        this.f10469d.add(c1628a);
    }

    /* renamed from: f */
    public InterfaceC1642h m12761f() {
        return this.f10470e;
    }

    /* renamed from: a */
    public void m12753a(InterfaceC1642h interfaceC1642h) {
        this.f10470e = interfaceC1642h;
    }

    /* renamed from: g */
    public AbstractC1598c m12762g() {
        return this.f10471f;
    }

    /* renamed from: a */
    public void m12751a(AbstractC1598c abstractC1598c) {
        this.f10471f = abstractC1598c;
    }

    /* renamed from: a */
    public void m12754a(C1668e c1668e) {
        this.f10472g = c1668e;
    }

    /* renamed from: h */
    public C1668e m12763h() {
        return this.f10472g;
    }

    /* renamed from: i */
    public boolean m12764i() {
        return this.f10473h;
    }

    /* renamed from: a */
    public void m12755a(boolean z) {
        this.f10473h = z;
    }

    public int hashCode() {
        return (this.f10466a == null ? 0 : this.f10466a.hashCode() * 31) + this.f10467b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C1666c c1666c = (C1666c) obj;
            if (this.f10466a == null) {
                if (c1666c.f10466a != null) {
                    return false;
                }
            } else if (!this.f10466a.equals(c1666c.f10466a)) {
                return false;
            }
            return this.f10467b == c1666c.f10467b;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(this.f10466a == null ? "all" : this.f10466a.m12203e()) + " -> " + C1739h.m13270a(this.f10467b);
    }
}
