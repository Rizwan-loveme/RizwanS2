package com.p140g.p141a.p145d.p146a;

import com.p140g.p141a.C1292g;
import com.p140g.p141a.p145d.p147b.AbstractC1254a;
import com.p140g.p141a.p145d.p147b.AbstractC1258e;
import com.p140g.p141a.p145d.p147b.C1256c;
import com.p140g.p141a.p145d.p147b.C1259f;
import com.p140g.p141a.p145d.p147b.C1260g;
import com.p140g.p141a.p145d.p147b.C1261h;
import com.p140g.p141a.p145d.p147b.C1262i;
import com.p140g.p141a.p145d.p147b.C1266m;
import com.p140g.p141a.p145d.p147b.C1267n;
import com.p140g.p141a.p145d.p147b.C1269p;
import com.p140g.p141a.p145d.p147b.C1270q;
import com.p140g.p141a.p145d.p147b.C1271r;
import com.p140g.p141a.p145d.p147b.C1272s;
import com.p140g.p141a.p145d.p147b.C1273t;
import com.p140g.p141a.p148e.EnumC1286f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DvmFrame.java */
/* renamed from: com.g.a.d.a.a */
/* loaded from: classes.dex */
public class C1251a<V> {

    /* renamed from: a */
    public V[] f8094a;

    /* renamed from: b */
    public V f8095b;

    public C1251a(int i) {
        this.f8094a = (V[]) new Object[i];
    }

    /* renamed from: a */
    public void m10349a(int i, V v) {
        if (i > this.f8094a.length || i < 0) {
            return;
        }
        this.f8094a[i] = v;
    }

    /* renamed from: a */
    public C1251a<V> m10346a(C1251a<? extends V> c1251a) {
        this.f8095b = c1251a.f8095b;
        System.arraycopy(c1251a.f8094a, 0, this.f8094a, 0, this.f8094a.length);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m10350a(AbstractC1258e abstractC1258e, AbstractC1252b<V> abstractC1252b) {
        boolean z;
        ArrayList arrayList;
        int i = 1;
        if (abstractC1258e.f8114c != null) {
            EnumC1286f enumC1286f = abstractC1258e.f8114c;
            if (enumC1286f == EnumC1286f.f8477u || enumC1286f == EnumC1286f.f8475s || enumC1286f == EnumC1286f.f8476t || enumC1286f == EnumC1286f.f8478v || enumC1286f == EnumC1286f.f8481y || enumC1286f == EnumC1286f.f8479w || enumC1286f == EnumC1286f.f8480x || enumC1286f == EnumC1286f.f8482z || enumC1286f == EnumC1286f.f8258A || enumC1286f == EnumC1286f.f8259B || enumC1286f == EnumC1286f.f8260C) {
                m10349a(((C1256c) abstractC1258e).f8111a, (int) abstractC1252b.mo10257b(abstractC1258e));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8297aM || enumC1286f == EnumC1286f.f8300aP || enumC1286f == EnumC1286f.f8301aQ || enumC1286f == EnumC1286f.f8302aR || enumC1286f == EnumC1286f.f8299aO || enumC1286f == EnumC1286f.f8303aS || enumC1286f == EnumC1286f.f8298aN) {
                m10349a(((C1259f) abstractC1258e).f8116a, (int) abstractC1252b.mo10257b(abstractC1258e));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8266I) {
                m10349a(((C1273t) abstractC1258e).f8144a, (int) abstractC1252b.mo10257b(abstractC1258e));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8337b || enumC1286f == EnumC1286f.f8443d || enumC1286f == EnumC1286f.f8390c || enumC1286f == EnumC1286f.f8464h || enumC1286f == EnumC1286f.f8466j || enumC1286f == EnumC1286f.f8465i || enumC1286f == EnumC1286f.f8461e || enumC1286f == EnumC1286f.f8462f || enumC1286f == EnumC1286f.f8463g) {
                C1271r c1271r = (C1271r) abstractC1258e;
                m10349a(c1271r.f8139a, (int) abstractC1252b.mo10254a(abstractC1258e, m10348a(c1271r.f8140b)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8467k || enumC1286f == EnumC1286f.f8468l || enumC1286f == EnumC1286f.f8469m || enumC1286f == EnumC1286f.f8470n) {
                m10349a(((C1269p) abstractC1258e).f8135a, (int) abstractC1252b.mo10254a(abstractC1258e, m10347a()));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8375bl || enumC1286f == EnumC1286f.f8377bn || enumC1286f == EnumC1286f.f8379bp || enumC1286f == EnumC1286f.f8378bo || enumC1286f == EnumC1286f.f8374bk || enumC1286f == EnumC1286f.f8376bm || enumC1286f == EnumC1286f.f8340bC || enumC1286f == EnumC1286f.f8341bD || enumC1286f == EnumC1286f.f8382bs || enumC1286f == EnumC1286f.f8381br || enumC1286f == EnumC1286f.f8380bq || enumC1286f == EnumC1286f.f8342bE || enumC1286f == EnumC1286f.f8388by || enumC1286f == EnumC1286f.f8386bw || enumC1286f == EnumC1286f.f8387bx || enumC1286f == EnumC1286f.f8339bB || enumC1286f == EnumC1286f.f8389bz || enumC1286f == EnumC1286f.f8338bA || enumC1286f == EnumC1286f.f8385bv || enumC1286f == EnumC1286f.f8384bu || enumC1286f == EnumC1286f.f8383bt || enumC1286f == EnumC1286f.f8265H) {
                C1271r c1271r2 = (C1271r) abstractC1258e;
                m10349a(c1271r2.f8139a, (int) abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(c1271r2.f8140b)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8315ae || enumC1286f == EnumC1286f.f8318ah || enumC1286f == EnumC1286f.f8319ai || enumC1286f == EnumC1286f.f8320aj || enumC1286f == EnumC1286f.f8317ag || enumC1286f == EnumC1286f.f8316af) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1262i) abstractC1258e).f8123a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8276S) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1267n) abstractC1258e).f8109a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8275R) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1266m) abstractC1258e).f8109a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8304aT || enumC1286f == EnumC1286f.f8307aW || enumC1286f == EnumC1286f.f8308aX || enumC1286f == EnumC1286f.f8309aY || enumC1286f == EnumC1286f.f8306aV || enumC1286f == EnumC1286f.f8310aZ || enumC1286f == EnumC1286f.f8305aU) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1259f) abstractC1258e).f8116a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8335ay || enumC1286f == EnumC1286f.f8286aB || enumC1286f == EnumC1286f.f8287aC || enumC1286f == EnumC1286f.f8288aD || enumC1286f == EnumC1286f.f8285aA || enumC1286f == EnumC1286f.f8289aE || enumC1286f == EnumC1286f.f8336az) {
                C1259f c1259f = (C1259f) abstractC1258e;
                m10349a(c1259f.f8116a, (int) abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(c1259f.f8117b)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8267J || enumC1286f == EnumC1286f.f8264G) {
                C1273t c1273t = (C1273t) abstractC1258e;
                m10349a(c1273t.f8144a, (int) abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(c1273t.f8145b)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8263F) {
                C1273t c1273t2 = (C1273t) abstractC1258e;
                m10349a(c1273t2.f8144a, (int) abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(c1273t2.f8144a)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8261D || enumC1286f == EnumC1286f.f8262E || enumC1286f == EnumC1286f.f8271N) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1269p) abstractC1258e).f8135a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8472p || enumC1286f == EnumC1286f.f8473q || enumC1286f == EnumC1286f.f8474r) {
                abstractC1252b.mo10261c(abstractC1258e, m10348a(((C1269p) abstractC1258e).f8135a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8321ak || enumC1286f == EnumC1286f.f8324an || enumC1286f == EnumC1286f.f8325ao || enumC1286f == EnumC1286f.f8326ap || enumC1286f == EnumC1286f.f8323am || enumC1286f == EnumC1286f.f8327aq || enumC1286f == EnumC1286f.f8322al || enumC1286f == EnumC1286f.f8281X || enumC1286f == EnumC1286f.f8280W || enumC1286f == EnumC1286f.f8278U || enumC1286f == EnumC1286f.f8279V || enumC1286f == EnumC1286f.f8277T || enumC1286f == EnumC1286f.f8423cg || enumC1286f == EnumC1286f.f8418cb || enumC1286f == EnumC1286f.f8343bF || enumC1286f == EnumC1286f.f8354bQ || enumC1286f == EnumC1286f.f8424ch || enumC1286f == EnumC1286f.f8419cc || enumC1286f == EnumC1286f.f8344bG || enumC1286f == EnumC1286f.f8355bR || enumC1286f == EnumC1286f.f8425ci || enumC1286f == EnumC1286f.f8420cd || enumC1286f == EnumC1286f.f8345bH || enumC1286f == EnumC1286f.f8356bS || enumC1286f == EnumC1286f.f8426cj || enumC1286f == EnumC1286f.f8421ce || enumC1286f == EnumC1286f.f8346bI || enumC1286f == EnumC1286f.f8357bT || enumC1286f == EnumC1286f.f8427ck || enumC1286f == EnumC1286f.f8422cf || enumC1286f == EnumC1286f.f8347bJ || enumC1286f == EnumC1286f.f8358bU || enumC1286f == EnumC1286f.f8348bK || enumC1286f == EnumC1286f.f8359bV || enumC1286f == EnumC1286f.f8349bL || enumC1286f == EnumC1286f.f8360bW || enumC1286f == EnumC1286f.f8350bM || enumC1286f == EnumC1286f.f8361bX || enumC1286f == EnumC1286f.f8351bN || enumC1286f == EnumC1286f.f8362bY || enumC1286f == EnumC1286f.f8352bO || enumC1286f == EnumC1286f.f8363bZ || enumC1286f == EnumC1286f.f8353bP || enumC1286f == EnumC1286f.f8417ca) {
                C1272s c1272s = (C1272s) abstractC1258e;
                m10349a(c1272s.f8141a, (int) abstractC1252b.mo10255a(abstractC1258e, m10348a(c1272s.f8142b), m10348a(c1272s.f8143e)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8282Y || enumC1286f == EnumC1286f.f8312ab || enumC1286f == EnumC1286f.f8313ac || enumC1286f == EnumC1286f.f8314ad || enumC1286f == EnumC1286f.f8311aa || enumC1286f == EnumC1286f.f8283Z) {
                C1262i c1262i = (C1262i) abstractC1258e;
                abstractC1252b.mo10255a(abstractC1258e, m10348a(c1262i.f8123a), m10348a(c1262i.f8124b));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8290aF || enumC1286f == EnumC1286f.f8293aI || enumC1286f == EnumC1286f.f8294aJ || enumC1286f == EnumC1286f.f8295aK || enumC1286f == EnumC1286f.f8292aH || enumC1286f == EnumC1286f.f8296aL || enumC1286f == EnumC1286f.f8291aG) {
                C1259f c1259f2 = (C1259f) abstractC1258e;
                abstractC1252b.mo10255a(abstractC1258e, m10348a(c1259f2.f8117b), m10348a(c1259f2.f8116a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8328ar || enumC1286f == EnumC1286f.f8331au || enumC1286f == EnumC1286f.f8332av || enumC1286f == EnumC1286f.f8333aw || enumC1286f == EnumC1286f.f8330at || enumC1286f == EnumC1286f.f8334ax || enumC1286f == EnumC1286f.f8329as) {
                C1272s c1272s2 = (C1272s) abstractC1258e;
                abstractC1252b.mo10256a(abstractC1258e, m10348a(c1272s2.f8142b), m10348a(c1272s2.f8143e), m10348a(c1272s2.f8141a));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8369bf || enumC1286f == EnumC1286f.f8364ba || enumC1286f == EnumC1286f.f8370bg || enumC1286f == EnumC1286f.f8371bh || enumC1286f == EnumC1286f.f8365bb || enumC1286f == EnumC1286f.f8366bc || enumC1286f == EnumC1286f.f8372bi || enumC1286f == EnumC1286f.f8367bd || enumC1286f == EnumC1286f.f8373bj || enumC1286f == EnumC1286f.f8368be || enumC1286f == EnumC1286f.f8456dm || enumC1286f == EnumC1286f.f8457dn || enumC1286f == EnumC1286f.f8454dk || enumC1286f == EnumC1286f.f8455dl) {
                AbstractC1254a abstractC1254a = (AbstractC1254a) abstractC1258e;
                C1292g mo10357a = abstractC1254a.mo10357a();
                if (abstractC1258e.f8114c == EnumC1286f.f8367bd || abstractC1258e.f8114c == EnumC1286f.f8372bi) {
                    z = true;
                } else {
                    z = abstractC1258e.f8114c == EnumC1286f.f8456dm || abstractC1258e.f8114c == EnumC1286f.f8457dn;
                }
                if (z) {
                    arrayList = new ArrayList(mo10357a.m10470a().length);
                    i = 0;
                } else {
                    arrayList = new ArrayList(mo10357a.m10470a().length + 1);
                    arrayList.add(m10348a(abstractC1254a.f8108a[0]));
                }
                String[] m10470a = mo10357a.m10470a();
                for (String str : m10470a) {
                    arrayList.add(m10348a(abstractC1254a.f8108a[i]));
                    char charAt = str.charAt(0);
                    i = (charAt == 'J' || charAt == 'D') ? i + 2 : i + 1;
                }
                m10351a((C1251a<V>) abstractC1252b.mo10259b(abstractC1258e, (List) arrayList));
                return;
            }
            if (enumC1286f == EnumC1286f.f8268K || enumC1286f == EnumC1286f.f8269L) {
                C1261h c1261h = (C1261h) abstractC1258e;
                ArrayList arrayList2 = new ArrayList(c1261h.f8121a.length);
                for (int i2 = 0; i2 < c1261h.f8121a.length; i2++) {
                    arrayList2.add(m10348a(c1261h.f8121a[i2]));
                }
                m10351a((C1251a<V>) abstractC1252b.mo10259b(abstractC1258e, (List) arrayList2));
                return;
            }
            if (enumC1286f == EnumC1286f.f8403cM || enumC1286f == EnumC1286f.f8398cH || enumC1286f == EnumC1286f.f8428cl || enumC1286f == EnumC1286f.f8439cw || enumC1286f == EnumC1286f.f8404cN || enumC1286f == EnumC1286f.f8399cI || enumC1286f == EnumC1286f.f8429cm || enumC1286f == EnumC1286f.f8440cx || enumC1286f == EnumC1286f.f8405cO || enumC1286f == EnumC1286f.f8400cJ || enumC1286f == EnumC1286f.f8430cn || enumC1286f == EnumC1286f.f8441cy || enumC1286f == EnumC1286f.f8406cP || enumC1286f == EnumC1286f.f8401cK || enumC1286f == EnumC1286f.f8431co || enumC1286f == EnumC1286f.f8442cz || enumC1286f == EnumC1286f.f8407cQ || enumC1286f == EnumC1286f.f8402cL || enumC1286f == EnumC1286f.f8432cp || enumC1286f == EnumC1286f.f8391cA || enumC1286f == EnumC1286f.f8433cq || enumC1286f == EnumC1286f.f8392cB || enumC1286f == EnumC1286f.f8434cr || enumC1286f == EnumC1286f.f8393cC || enumC1286f == EnumC1286f.f8435cs || enumC1286f == EnumC1286f.f8394cD || enumC1286f == EnumC1286f.f8436ct || enumC1286f == EnumC1286f.f8395cE || enumC1286f == EnumC1286f.f8437cu || enumC1286f == EnumC1286f.f8396cF || enumC1286f == EnumC1286f.f8438cv || enumC1286f == EnumC1286f.f8397cG) {
                C1271r c1271r3 = (C1271r) abstractC1258e;
                m10349a(c1271r3.f8139a, (int) abstractC1252b.mo10255a(abstractC1258e, m10348a(c1271r3.f8139a), m10348a(c1271r3.f8140b)));
                m10351a((C1251a<V>) null);
                return;
            }
            if (enumC1286f == EnumC1286f.f8408cR || enumC1286f == EnumC1286f.f8416cZ || enumC1286f == EnumC1286f.f8444da || enumC1286f == EnumC1286f.f8409cS || enumC1286f == EnumC1286f.f8445db || enumC1286f == EnumC1286f.f8410cT || enumC1286f == EnumC1286f.f8411cU || enumC1286f == EnumC1286f.f8446dc || enumC1286f == EnumC1286f.f8412cV || enumC1286f == EnumC1286f.f8447dd || enumC1286f == EnumC1286f.f8413cW || enumC1286f == EnumC1286f.f8448de || enumC1286f == EnumC1286f.f8414cX || enumC1286f == EnumC1286f.f8449df || enumC1286f == EnumC1286f.f8415cY || enumC1286f == EnumC1286f.f8450dg || enumC1286f == EnumC1286f.f8451dh || enumC1286f == EnumC1286f.f8452di || enumC1286f == EnumC1286f.f8453dj) {
                C1270q c1270q = (C1270q) abstractC1258e;
                m10349a(c1270q.f8136a, (int) abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(c1270q.f8137b)));
                m10351a((C1251a<V>) null);
            } else if (enumC1286f == EnumC1286f.f8270M) {
                abstractC1252b.mo10258b(abstractC1258e, (AbstractC1258e) m10348a(((C1260g) abstractC1258e).f8119a));
                m10351a((C1251a<V>) null);
            } else {
                if (enumC1286f == EnumC1286f.f8272O || enumC1286f == EnumC1286f.f8273P || enumC1286f == EnumC1286f.f8274Q || enumC1286f == EnumC1286f.f8471o || enumC1286f == EnumC1286f.f8458do) {
                    m10351a((C1251a<V>) null);
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    /* renamed from: a */
    public V m10347a() {
        return this.f8095b;
    }

    /* renamed from: a */
    public void m10351a(V v) {
        this.f8095b = v;
    }

    /* renamed from: a */
    public V m10348a(int i) {
        return (i > this.f8094a.length || i < 0) ? (V) ((Object) null) : this.f8094a[i];
    }

    /* renamed from: b */
    public int m10352b() {
        return this.f8094a.length;
    }
}
