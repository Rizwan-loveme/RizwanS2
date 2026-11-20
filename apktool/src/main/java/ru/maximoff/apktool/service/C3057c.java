package ru.maximoff.apktool.service;

import com.p063a.p064a.C0567p;
import com.p063a.p064a.C0568q;
import com.p063a.p064a.C0569r;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.p210a.p211a.p212a.C1830c;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import ru.maximoff.apktool.p296a.C2890j;

/* compiled from: Parser.java */
/* renamed from: ru.maximoff.apktool.service.c */
/* loaded from: classes.dex */
public class C3057c {

    /* renamed from: a */
    private static ThreadLocal<C0568q> f17152a = new ThreadLocal<>();

    /* renamed from: b */
    private static ThreadLocal<C0569r> f17153b = new ThreadLocal<>();

    /* renamed from: c */
    private static ThreadLocal<a> f17154c = new ThreadLocal<>();

    /* renamed from: a */
    public static void m18204a(C3055a c3055a, int i, boolean z) {
        if (c3055a != null) {
            C1830c c1830c = new C1830c(new FileInputStream(c3055a.m18183j()));
            c3055a.mo17859b();
            C0568q c0568q = f17152a.get();
            C0569r c0569r = f17153b.get();
            if (c0568q == null) {
                C0568q c0568q2 = new C0568q((InterfaceC1858f) null);
                f17152a.set(c0568q2);
                c0568q = c0568q2;
            }
            if (c0569r == null) {
                c0569r = new C0569r((InterfaceC1822af) null);
                f17153b.set(c0569r);
            }
            c0568q.m13927cD();
            c0569r.m13927cD();
            c0568q.m13925a(c3055a);
            c0569r.m13925a(c3055a);
            c0568q.m13860a(c1830c);
            C1864l c1864l = new C1864l(c0568q);
            c0569r.m13881a((InterfaceC1822af) c1864l);
            C0569r.gb m5233e = c0569r.m5233e();
            if (c0569r.m13898cr() == 0) {
                if (i == 0) {
                    m18203a(m5233e, c1864l, false);
                } else {
                    C3059e.m18234c().m18239a(c3055a, m5233e, c1864l, true, z);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m18203a(C0569r.gb gbVar, C1864l c1864l, boolean z) {
        a aVar = f17154c.get();
        if (aVar == null) {
            aVar = new a();
            f17154c.set(aVar);
        }
        aVar.f17160f = z;
        aVar.f17159e = c1864l;
        gbVar.mo4289a(aVar);
    }

    /* compiled from: Parser.java */
    /* renamed from: ru.maximoff.apktool.service.c$a */
    private static class a extends C0567p<Object> {

        /* renamed from: a */
        String f17155a = (String) null;

        /* renamed from: b */
        String f17156b = (String) null;

        /* renamed from: c */
        List<String> f17157c = new ArrayList();

        /* renamed from: d */
        List<String> f17158d = new ArrayList();

        /* renamed from: e */
        C1864l f17159e;

        /* renamed from: f */
        boolean f17160f;

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo5105a(C0569r.gb gbVar) {
            this.f17155a = (String) null;
            this.f17156b = (String) null;
            this.f17157c.clear();
            this.f17158d.clear();
            try {
                Object mo5105a = super.mo5105a(gbVar);
                if (this.f17155a != null) {
                    C2890j.a aVar = new C2890j.a();
                    aVar.f14850a = this.f17156b;
                    aVar.f14851b = new ArrayList(this.f17157c);
                    aVar.f14852c = new ArrayList(this.f17158d);
                    C2890j.m16912a(this.f17155a, aVar, this.f17160f);
                }
                return mo5105a;
            } catch (Throwable th) {
                if (this.f17155a != null) {
                    C2890j.a aVar2 = new C2890j.a();
                    aVar2.f14850a = this.f17156b;
                    aVar2.f14851b = new ArrayList(this.f17157c);
                    aVar2.f14852c = new ArrayList(this.f17158d);
                    C2890j.m16912a(this.f17155a, aVar2, this.f17160f);
                }
                throw th;
            }
        }

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo4954a(C0569r.aj ajVar) {
            this.f17158d.add(ajVar.m5279b().mo13787n());
            return (Object) null;
        }

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo5131a(C0569r.q qVar) {
            this.f17155a = qVar.m5520c().mo13787n();
            return (Object) null;
        }

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo5114a(C0569r.gl glVar) {
            this.f17156b = glVar.m5500b().mo13787n();
            return (Object) null;
        }

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo5140a(C0569r.z zVar) {
            if (zVar.m5528c().mo13787n().equals("<clinit>")) {
                return (Object) null;
            }
            this.f17157c.add(m18205a(zVar.m5528c().f11000f, zVar.m5529d().f11001g));
            return (Object) null;
        }

        @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
        /* renamed from: a */
        public Object mo5078a(C0569r.fa faVar) {
            this.f17157c.add(m18205a(faVar.m5462c().f11000f, faVar.m5463d().f11001g));
            return (Object) null;
        }

        /* renamed from: a */
        protected String m18205a(InterfaceC1819ac interfaceC1819ac, InterfaceC1819ac interfaceC1819ac2) {
            return this.f17159e.mo13686a(interfaceC1819ac, interfaceC1819ac2);
        }
    }
}
