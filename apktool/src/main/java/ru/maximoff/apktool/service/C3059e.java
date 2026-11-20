package ru.maximoff.apktool.service;

import android.graphics.Color;
import com.p063a.p064a.C0567p;
import com.p063a.p064a.C0569r;
import com.p129f.p130a.p133c.AbstractC1208w;
import jadx.core.p203d.C1741j;
import jadx.core.p203d.InterfaceC1736e;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.p210a.p211a.p212a.AbstractC1877y;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.C1876x;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.p215c.C1843m;
import org.p210a.p211a.p212a.p216d.InterfaceC1852g;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p263h.C2387g;
import org.p226d.p268c.C2446a;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.p296a.C2890j;
import ru.maximoff.p295a.C2608a;

/* compiled from: ReferenceFinder.java */
/* renamed from: ru.maximoff.apktool.service.e */
/* loaded from: classes.dex */
public class C3059e extends C0567p<Object> {

    /* renamed from: a */
    private static final ResourceBundle f17173a;

    /* renamed from: b */
    private static final ThreadLocal<C3059e> f17174b = new ThreadLocal<>();

    /* renamed from: c */
    private C3055a f17175c;

    /* renamed from: d */
    private int f17176d;

    /* renamed from: e */
    private int f17177e;

    /* renamed from: f */
    private C1864l f17178f;

    /* renamed from: g */
    private boolean f17179g;

    /* renamed from: h */
    private final Map<String, List<a>> f17180h = new LinkedHashMap();

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4944a(C0569r.a aVar) {
        return m18240b(aVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4949a(C0569r.ae aeVar) {
        return m18241b(aeVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4950a(C0569r.af afVar) {
        return m18242b(afVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5065a(C0569r.em emVar) {
        return m18243b(emVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5085a(C0569r.fh fhVar) {
        return m18244b(fhVar);
    }

    /* renamed from: a */
    private static String m18220a(String str, Object... objArr) {
        return MessageFormat.format(f17173a.getString(str), objArr);
    }

    C3059e() {
    }

    /* renamed from: b */
    public void m18245b() {
        this.f17179g = true;
    }

    /* renamed from: a */
    public void m18239a(C3055a c3055a, C0569r.gb gbVar, C1864l c1864l, boolean z, boolean z2) {
        if (C2890j.m16921d()) {
            return;
        }
        this.f17175c = c3055a;
        this.f17178f = c1864l;
        this.f17179g = false;
        this.f17180h.clear();
        gbVar.mo4289a(this);
        if (z2) {
            for (Map.Entry<String, List<a>> entry : this.f17180h.entrySet()) {
                String key = entry.getKey();
                List<String> m16908a = C2890j.m16908a(key);
                if (m16908a.size() == 0) {
                    Iterator<a> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        Iterator<Object> it2 = it.next().f17183b.iterator();
                        while (it2.hasNext()) {
                            c3055a.mo13480a((AbstractC1877y<?, ?>) null, it2.next(), 0, 0, m18220a("1", entry.getKey()), (C1876x) null);
                        }
                    }
                } else {
                    for (a aVar : entry.getValue()) {
                        String str = aVar.f17182a;
                        if (str != null && !m16908a.contains(str)) {
                            String str2 = str.indexOf(58) > 0 ? "2" : "3";
                            Iterator<C1843m<Integer, Integer>> it3 = aVar.f17184c.iterator();
                            while (it3.hasNext()) {
                                c3055a.mo13480a((AbstractC1877y<?, ?>) null, it3.next(), 0, 0, m18220a(str2, str, key), (C1876x) null);
                            }
                        }
                    }
                }
            }
        }
        if (c3055a.m17889g() <= 0 || !z) {
            return;
        }
        C2978b.f16135a.m17713g();
    }

    /* renamed from: c */
    public static C3059e m18234c() {
        C3059e c3059e = f17174b.get();
        if (c3059e == null) {
            C3059e c3059e2 = new C3059e();
            f17174b.set(c3059e2);
            return c3059e2;
        }
        return c3059e;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4948a(C0569r.ad adVar) {
        if (this.f17179g) {
            return (Object) null;
        }
        String str = adVar.f3816a;
        a m18222a = m18222a(m18221a(str), this.f17178f.mo13686a(adVar.m5259b().f11000f, adVar.m5260c().f11001g).replace(" ", ""));
        m18222a.f17183b.add(str);
        m18222a.f17184c.add(new C1843m<>(new Integer(adVar.m5259b().f11000f.mo13677f()), new Integer(adVar.f11001g.mo13678g())));
        return (Object) null;
    }

    /* renamed from: a */
    private a m18222a(List<a> list, String str) {
        for (a aVar : list) {
            if (aVar.f17182a != null || str != null) {
                if (str != null && aVar.f17182a != null && aVar.f17182a.equals(str)) {
                    return aVar;
                }
            } else {
                return aVar;
            }
        }
        a aVar2 = new a(this, str);
        list.add(aVar2);
        return aVar2;
    }

    /* renamed from: a */
    private List<a> m18221a(String str) {
        return (List) C1741j.m13285a(this.f17180h, str, new InterfaceC1736e<String, List<a>>(this) { // from class: ru.maximoff.apktool.service.e.1

            /* renamed from: a */
            private final C3059e f17181a;

            {
                this.f17181a = this;
            }

            @Override // jadx.core.p203d.InterfaceC1736e
            /* renamed from: a */
            public /* bridge */ List<a> mo12561a(String str2) {
                return a2(str2);
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public List<a> a2(String str2) {
                return new LinkedList();
            }
        });
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5087a(C0569r.fj fjVar) {
        if (this.f17179g) {
            return (Object) null;
        }
        String str = fjVar.f3850a;
        a m18222a = m18222a(m18221a(str), this.f17178f.mo13686a(fjVar.m5475b().f11000f, fjVar.m5476c().f11001g).replace(" ", ""));
        m18222a.f17183b.add(str);
        m18222a.f17184c.add(new C1843m<>(new Integer(fjVar.m5475b().f11000f.mo13677f()), new Integer(fjVar.f11001g.mo13678g())));
        return (Object) null;
    }

    @Override // org.p210a.p211a.p212a.p216d.AbstractC1846a, org.p210a.p211a.p212a.p216d.InterfaceC1851f
    /* renamed from: a */
    public Object mo13782a(InterfaceC1852g interfaceC1852g) {
        return this.f17179g ? (Object) null : super.mo13782a(interfaceC1852g);
    }

    /* compiled from: ReferenceFinder.java */
    /* renamed from: ru.maximoff.apktool.service.e$a */
    private class a {

        /* renamed from: a */
        String f17182a;

        /* renamed from: b */
        List<Object> f17183b = new LinkedList();

        /* renamed from: c */
        List<C1843m<Integer, Integer>> f17184c = new LinkedList();

        /* renamed from: d */
        private final C3059e f17185d;

        public a(C3059e c3059e, String str) {
            this.f17185d = c3059e;
            this.f17182a = str;
        }
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5114a(C0569r.gl glVar) {
        return m18229b(glVar.m5500b());
    }

    /* renamed from: b */
    private Object m18229b(InterfaceC1854i interfaceC1854i) {
        m18222a(m18221a(interfaceC1854i.mo13787n()), (String) null).f17183b.add(interfaceC1854i.mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4954a(C0569r.aj ajVar) {
        return m18229b(ajVar.m5279b());
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4959a(C0569r.ao aoVar) {
        C0569r.em m5287d = aoVar.m5287d();
        int intValue = m18243b(m5287d).intValue();
        m18227a(aoVar.m5286c().mo13792a());
        m18223a(intValue, (C1874v) m5287d);
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4960a(C0569r.ap apVar) {
        m18233b(apVar.m5289c().mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4961a(C0569r.aq aqVar) {
        Iterator<InterfaceC1854i> it = aqVar.m5291c().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4966a(C0569r.av avVar) {
        m18233b(avVar.m5303c().mo13792a());
        mo5082a(avVar.m5304d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4964a(C0569r.at atVar) {
        m18233b(atVar.m5298c().mo13792a());
        mo4948a(atVar.m5299d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4965a(C0569r.au auVar) {
        m18233b(auVar.m5300b().mo13792a());
        mo4948a(auVar.m5301c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4967a(C0569r.aw awVar) {
        m18233b(awVar.m5306c().mo13792a());
        m18244b(awVar.m5307d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4968a(C0569r.ax axVar) {
        m18233b(axVar.m5309c().mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4969a(C0569r.ay ayVar) {
        m18233b(ayVar.m5312c().mo13792a());
        m18228a((C1874v) ayVar.m5313d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4970a(C0569r.az azVar) {
        C0569r.ae m5316d = azVar.m5316d();
        m18233b(azVar.m5315c().mo13792a());
        m18238d(m18241b(m5316d).intValue(), m5316d);
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4972a(C0569r.ba baVar) {
        C0569r.af m5322d = baVar.m5322d();
        m18224a(m18242b(m5322d).longValue(), m5322d);
        m18233b(baVar.m5321c().mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4973a(C0569r.bb bbVar) {
        C0569r.em m5325d = bbVar.m5325d();
        m18235c(m18243b(m5325d).intValue(), m5325d);
        m18233b(bbVar.m5324c().mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4976a(C0569r.be beVar) {
        Iterator<InterfaceC1854i> it = beVar.m5334d().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        mo4948a(beVar.m5333c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4978a(C0569r.bg bgVar) {
        Iterator<InterfaceC1854i> it = bgVar.m5339d().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        m18228a((C1874v) bgVar.m5338c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4977a(C0569r.bf bfVar) {
        Iterator<InterfaceC1854i> it = bfVar.m5336c().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        mo4948a(bfVar.m5335b());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4979a(C0569r.bh bhVar) {
        Iterator<InterfaceC1854i> it = bhVar.m5340b().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4980a(C0569r.bi biVar) {
        C0569r.em m5342c = biVar.m5342c();
        m18235c(m18243b(m5342c).intValue(), m5342c);
        Iterator<InterfaceC1854i> it = biVar.m5343d().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4981a(C0569r.bj bjVar) {
        Iterator<InterfaceC1854i> it = bjVar.m5346d().iterator();
        while (it.hasNext()) {
            m18227a(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4975a(C0569r.bd bdVar) {
        C0569r.em m5330c = bdVar.m5330c();
        m18230b(m18243b(m5330c).intValue(), m5330c);
        Iterator<InterfaceC1854i> it = bdVar.m5331d().iterator();
        while (it.hasNext()) {
            m18233b(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4982a(C0569r.bk bkVar) {
        m18233b(bkVar.m5347a(0).mo13792a());
        m18236c(bkVar.m5347a(1).mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4983a(C0569r.bl blVar) {
        Iterator<InterfaceC1854i> it = blVar.m5350c().iterator();
        while (it.hasNext()) {
            m18233b(it.next().mo13792a());
        }
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4985a(C0569r.bn bnVar) {
        m18233b(bnVar.m5354c().mo13792a());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4986a(C0569r.bo boVar) {
        m18233b(boVar.m5357c().mo13792a());
        return super.mo4986a(boVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4987a(C0569r.bp bpVar) {
        m18233b(bpVar.m5360c().mo13792a());
        return super.mo4987a(bpVar);
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4988a(C0569r.bq bqVar) {
        Iterator<InterfaceC1854i> it = bqVar.m5363c().iterator();
        while (it.hasNext()) {
            m18236c(it.next().mo13792a());
        }
        return super.mo4988a(bqVar);
    }

    /* renamed from: b */
    public Number m18242b(C0569r.af afVar) {
        Number d2;
        Integer num = new Integer(0);
        if (afVar != null) {
            try {
                if (afVar.m5270c() != null) {
                    d2 = new Long(C2446a.m15482d(afVar.m5270c().mo13787n()));
                } else if (afVar.m5271d() != null) {
                    d2 = new Short(C2446a.m15480b(afVar.m5271d().mo13787n()));
                } else if (afVar.m5272e() != null) {
                    d2 = new Byte(C2446a.m15479a(afVar.m5272e().mo13787n()));
                } else if (afVar.m5269b() != null) {
                    d2 = new Integer(C2446a.m15481c(afVar.m5269b().mo13787n()));
                } else if (afVar.m5275h() != null) {
                    d2 = new Integer(C2608a.m16311b(afVar.m5275h()).charAt(0));
                } else if (afVar.m5273f() != null) {
                    d2 = new Float(C2446a.m15483e(afVar.m5273f().mo13787n()));
                } else {
                    d2 = afVar.m5274g() != null ? new Double(C2446a.m15484f(afVar.m5274g().mo13787n())) : num;
                }
                return d2;
            } catch (Error e2) {
                return num;
            } catch (Exception e3) {
                return num;
            }
        }
        return num;
    }

    /* renamed from: b */
    public Number m18241b(C0569r.ae aeVar) {
        Number f2;
        Integer num = new Integer(0);
        if (aeVar != null) {
            try {
                if (aeVar.m5262b() != null) {
                    f2 = new Long(C2446a.m15482d(aeVar.m5262b().mo13787n()));
                } else if (aeVar.m5264d() != null) {
                    f2 = new Short(C2446a.m15480b(aeVar.m5264d().mo13787n()));
                } else if (aeVar.m5265e() != null) {
                    f2 = new Byte(C2446a.m15479a(aeVar.m5265e().mo13787n()));
                } else if (aeVar.m5263c() != null) {
                    f2 = new Integer(C2446a.m15481c(aeVar.m5263c().mo13787n()));
                } else if (aeVar.m5267g() != null) {
                    f2 = new Integer(C2608a.m16311b(aeVar.m5267g()).charAt(0));
                } else {
                    f2 = aeVar.m5266f() != null ? new Float(C2446a.m15483e(aeVar.m5266f().mo13787n())) : num;
                }
                return f2;
            } catch (Error e2) {
                return num;
            } catch (Exception e3) {
                return num;
            }
        }
        return num;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4990a(C0569r.bs bsVar) {
        m18231b(bsVar.m5369d());
        mo5087a(bsVar.m5368c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4992a(C0569r.bu buVar) {
        m18231b(buVar.m5372d());
        m18228a((C1874v) buVar.m5371c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4989a(C0569r.br brVar) {
        m18231b(brVar.m5366d());
        mo5123a(brVar.m5365c());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4993a(C0569r.bv bvVar) {
        m18231b(bvVar.m5373b());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4994a(C0569r.bw bwVar) {
        m18231b(bwVar.m5374b());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4999a(C0569r.ca caVar) {
        m18232b(caVar.m5384c());
        m18228a((C1874v) caVar.m5385d());
        return (Object) null;
    }

    /* renamed from: b */
    private void m18232b(C0569r.fv fvVar) {
        if (fvVar != null && fvVar.f3857a != null && fvVar.f3858b != null) {
            int m18237d = (m18237d(fvVar.f3858b) - m18237d(fvVar.f3857a)) + 1;
            m18236c(fvVar.f3857a);
            if ((m18237d & (-256)) != 0) {
                this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, fvVar, 0, 0, m18220a("14", new Integer(m18237d)), (C1876x) null);
            }
        }
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4995a(C0569r.bx bxVar) {
        m18232b(bxVar.m5376c());
        mo5123a(bxVar.m5377d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo4996a(C0569r.by byVar) {
        m18232b(byVar.m5379c());
        mo5087a(byVar.m5380d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5000a(C0569r.cb cbVar) {
        m18232b(cbVar.m5386b());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5001a(C0569r.cc ccVar) {
        m18232b(ccVar.m5387b());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5002a(C0569r.cd cdVar) {
        m18231b(cdVar.m5391e());
        mo5087a(cdVar.m5389c());
        m18244b(cdVar.m5390d());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5003a(C0569r.ce ceVar) {
        m18232b(ceVar.m5393c());
        mo5087a(ceVar.m5394d());
        m18244b(ceVar.m5395e());
        return (Object) null;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5004a(C0569r.cf cfVar) {
        m18233b(cfVar.m5397c().mo13792a());
        return (Object) null;
    }

    /* renamed from: b */
    public Number m18243b(C0569r.em emVar) {
        long j = 0;
        if (emVar != null) {
            if (emVar.m5445b() != null) {
                j = C2446a.m15482d(emVar.m5445b().mo13787n());
            } else if (emVar.m5447d() != null) {
                j = C2446a.m15480b(emVar.m5447d().mo13787n());
            } else if (emVar.m5449f() != null) {
                j = C2446a.m15479a(emVar.m5449f().mo13787n());
            } else if (emVar.m5446c() != null) {
                j = C2446a.m15481c(emVar.m5446c().mo13787n());
            } else if (emVar.m5448e() != null) {
                j = C2608a.m16311b(emVar.m5448e()).charAt(0);
            }
        }
        return Long.valueOf(j);
    }

    /* renamed from: b */
    public List<CharSequence> m18244b(C0569r.fh fhVar) {
        AbstractC1208w.a aVar = new AbstractC1208w.a();
        C0569r.fn m5472b = fhVar.m5472b();
        if (m5472b != null) {
            String n = fhVar.m5472b().mo13787n();
            int length = n.length();
            boolean z = false;
            int i = -1;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = n.charAt(i2);
                switch (charAt) {
                    case ';':
                        aVar.mo9809a(n.substring(i, i2 + 1));
                        z = false;
                        i = -1;
                        continue;
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'F':
                    case 'I':
                    case 'J':
                    case 'S':
                    case 'Z':
                        if (i == -1) {
                            aVar.mo9809a(String.valueOf(charAt));
                            continue;
                        } else if (z) {
                            break;
                        } else {
                            aVar.mo9809a(n.substring(i, i2 + 1));
                            z = false;
                            i = -1;
                            break;
                        }
                    case 'L':
                        z = true;
                        break;
                    case '[':
                        break;
                }
                if (i == -1) {
                    i = i2;
                }
            }
        }
        AbstractC1208w m10144a = aVar.m10144a();
        Iterator<E> it = m10144a.iterator();
        while (it.hasNext()) {
            m18225a(((CharSequence) it.next()).toString(), (C1874v) m5472b);
        }
        m18228a((C1874v) fhVar.m5473c());
        return m10144a;
    }

    @Override // com.p063a.p064a.C0567p, com.p063a.p064a.InterfaceC0570s
    /* renamed from: a */
    public Object mo5078a(C0569r.fa faVar) {
        C0569r.fh m5463d = faVar.m5463d();
        List<CharSequence> m18244b = m18244b(m5463d);
        int intValue = m18240b(faVar.m5461b()).intValue();
        int m15088a = C2387g.m15088a(m18244b, (EnumC1959a.STATIC.m14191a() & intValue) > 0);
        List<C0569r.gg> m5464e = faVar.m5464e();
        if ((intValue & (EnumC1959a.ABSTRACT.m14191a() | EnumC1959a.NATIVE.m14191a())) == 0) {
            m18226a(m5464e, m15088a, faVar.m5462c().f11000f.mo13677f(), m5463d.f11001g.mo13678g());
        }
        Iterator<C0569r.gg> it = m5464e.iterator();
        while (it.hasNext()) {
            it.next().mo4289a(this);
        }
        return (Object) null;
    }

    /* renamed from: a */
    private void m18226a(List<C0569r.gg> list, int i, int i2, int i3) {
        int i4;
        Iterator<C0569r.gg> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            C0569r.gg next = it.next();
            if (next instanceof C0569r.ft) {
                i4 = m18219a((C0569r.ft) next, i);
                break;
            }
        }
        if (i4 == -1) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, new C1843m(new Integer(i2), new Integer(i3)), 0, 0, m18220a("9", new Object[0]), (C1876x) null);
            i4 = 65535;
        }
        this.f17176d = i4;
        this.f17177e = (i4 + i) - 1;
    }

    /* renamed from: a */
    private int m18219a(C0569r.ft ftVar, int i) {
        C0569r.fw m5483b = ftVar.m5483b();
        C0569r.em emVar = m5483b.f3860b;
        boolean z = m5483b.f3859a;
        long longValue = m18243b(emVar).longValue();
        long j = z ? longValue + i : longValue;
        if ((j < ((long) (-32768))) | (j > ((long) 65535))) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, emVar, 0, 0, m18220a("8", this.f17178f.m13796a(emVar)), (C1876x) null);
            return 0;
        }
        return (short) (j - i);
    }

    /* renamed from: b */
    public Integer m18240b(C0569r.a aVar) {
        int i = 0;
        Iterator<InterfaceC1854i> it = aVar.m5255b().iterator();
        while (it.hasNext()) {
            i = EnumC1959a.m14184a(it.next().mo13787n()).m14191a() | i;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    private void m18228a(C1874v c1874v) {
        m18225a(this.f17178f.m13796a(c1874v), c1874v);
    }

    /* renamed from: b */
    private void m18231b(C0569r.fu fuVar) {
        if (fuVar != null) {
            Iterator<InterfaceC1854i> it = fuVar.m5484b().iterator();
            while (it.hasNext()) {
                m18227a(it.next().mo13792a());
            }
        }
    }

    /* renamed from: a */
    private void m18227a(InterfaceC1819ac interfaceC1819ac) {
        if ((m18237d(interfaceC1819ac) & (-16)) != 0) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, interfaceC1819ac, 0, 0, m18220a("10", interfaceC1819ac.mo13673b()), (C1876x) null);
        }
    }

    /* renamed from: b */
    private void m18233b(InterfaceC1819ac interfaceC1819ac) {
        if ((m18237d(interfaceC1819ac) & (-256)) != 0) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, interfaceC1819ac, 0, 0, m18220a("11", interfaceC1819ac.mo13673b()), (C1876x) null);
        }
    }

    /* renamed from: c */
    private void m18236c(InterfaceC1819ac interfaceC1819ac) {
        if ((m18237d(interfaceC1819ac) & Color.RED) != 0) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, interfaceC1819ac, 0, 0, m18220a("12", interfaceC1819ac.mo13673b()), (C1876x) null);
        }
    }

    /* renamed from: a */
    private void m18223a(int i, C1874v c1874v) {
        if (i < -8 || i > 7) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, c1874v, 0, 0, m18220a("4", this.f17178f.m13796a(c1874v)), (C1876x) null);
        }
    }

    /* renamed from: b */
    private void m18230b(int i, C1874v c1874v) {
        if (i < -128 || i > 127) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, c1874v, 0, 0, m18220a("13", this.f17178f.m13796a(c1874v)), (C1876x) null);
        }
    }

    /* renamed from: c */
    private void m18235c(int i, C1874v c1874v) {
        if (i < -32768 || i > 32767) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, c1874v, 0, 0, m18220a("7", this.f17178f.m13796a(c1874v)), (C1876x) null);
        }
    }

    /* renamed from: d */
    private void m18238d(int i, C1874v c1874v) {
        if ((65535 & i) != 0) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, c1874v, 0, 0, m18220a("5", this.f17178f.m13796a(c1874v)), (C1876x) null);
        }
    }

    /* renamed from: a */
    private void m18224a(long j, C1874v c1874v) {
        if ((281474976710655L & j) != 0) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, c1874v, 0, 0, m18220a("6", this.f17178f.m13796a(c1874v)), (C1876x) null);
        }
    }

    /* renamed from: d */
    private int m18237d(InterfaceC1819ac interfaceC1819ac) {
        String mo13673b = interfaceC1819ac.mo13673b();
        int parseInt = Integer.parseInt(mo13673b.substring(1));
        int i = mo13673b.charAt(0) == 'p' ? parseInt + this.f17176d : parseInt;
        if (i > this.f17177e) {
            this.f17175c.mo13480a((AbstractC1877y<?, ?>) null, interfaceC1819ac, 0, 0, m18220a("15", new Integer(i), new Integer(this.f17177e)), (C1876x) null);
        }
        return i;
    }

    /* renamed from: a */
    private void m18225a(String str, C1874v c1874v) {
        if (str.matches("[BCDFIJSVZ]")) {
            return;
        }
        m18222a(m18221a(str), (String) null).f17183b.add(c1874v);
    }

    static {
        try {
            f17173a = ResourceBundle.getBundle(Class.forName("ru.maximoff.apktool.service.Messages").getName());
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }
}
