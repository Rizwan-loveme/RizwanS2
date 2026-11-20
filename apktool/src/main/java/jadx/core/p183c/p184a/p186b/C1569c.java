package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1648n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EnumClassAttr.java */
/* renamed from: jadx.core.c.a.b.c */
/* loaded from: classes.dex */
public class C1569c implements InterfaceC1587g<C1569c> {

    /* renamed from: a */
    private final List<a> f10053a;

    /* renamed from: b */
    private C1648n f10054b;

    /* compiled from: EnumClassAttr.java */
    /* renamed from: jadx.core.c.a.b.c$a */
    public static class a {

        /* renamed from: a */
        private final C1592d f10055a;

        /* renamed from: b */
        private final C1610a f10056b;

        /* renamed from: c */
        private final int f10057c;

        /* renamed from: d */
        private C1636b f10058d;

        public a(C1592d c1592d, C1610a c1610a, int i) {
            this.f10055a = c1592d;
            this.f10056b = c1610a;
            this.f10057c = i;
        }

        /* renamed from: a */
        public C1592d m12097a() {
            return this.f10055a;
        }

        /* renamed from: b */
        public C1610a m12099b() {
            return this.f10056b;
        }

        /* renamed from: c */
        public int m12100c() {
            return this.f10057c;
        }

        /* renamed from: d */
        public C1636b m12101d() {
            return this.f10058d;
        }

        /* renamed from: a */
        public void m12098a(C1636b c1636b) {
            this.f10058d = c1636b;
        }

        public String toString() {
            return this.f10055a + "(" + this.f10056b + ") " + this.f10058d;
        }
    }

    public C1569c(int i) {
        this.f10053a = new ArrayList(i);
    }

    /* renamed from: a */
    public List<a> m12094a() {
        return this.f10053a;
    }

    /* renamed from: c */
    public C1648n m12096c() {
        return this.f10054b;
    }

    /* renamed from: a */
    public void m12095a(C1648n c1648n) {
        this.f10054b = c1648n;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1569c> mo12085b() {
        return C1566b.f10040n;
    }

    public String toString() {
        return "Enum fields: " + this.f10053a;
    }
}
