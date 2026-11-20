package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1334k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IrMethod.java */
/* renamed from: com.g.b.a.b */
/* loaded from: classes.dex */
public class C1323b {

    /* renamed from: a */
    public boolean f8622a;

    /* renamed from: b */
    public String[] f8623b;

    /* renamed from: d */
    public String f8625d;

    /* renamed from: e */
    public String f8626e;

    /* renamed from: f */
    public String f8627f;

    /* renamed from: j */
    public List<C1329f> f8631j;

    /* renamed from: c */
    public List<C1314l> f8624c = new ArrayList();

    /* renamed from: g */
    public C1334k f8628g = new C1334k();

    /* renamed from: h */
    public List<C1366g> f8629h = new ArrayList();

    /* renamed from: i */
    public List<C1363d> f8630i = new ArrayList();

    public Object clone() {
        return m10553a();
    }

    /* renamed from: a */
    public C1323b m10553a() {
        C1323b c1323b = new C1323b();
        C1339c c1339c = new C1339c();
        c1323b.f8625d = this.f8625d;
        c1323b.f8623b = this.f8623b;
        c1323b.f8622a = this.f8622a;
        c1323b.f8626e = this.f8626e;
        c1323b.f8627f = this.f8627f;
        c1323b.f8628g = this.f8628g.m10575a(c1339c);
        Iterator<C1366g> it = this.f8629h.iterator();
        while (it.hasNext()) {
            c1323b.f8629h.add(it.next().m10766a(c1339c));
        }
        Iterator<C1363d> it2 = this.f8630i.iterator();
        while (it2.hasNext()) {
            c1323b.f8630i.add(it2.next().m10763a(c1339c));
        }
        if (this.f8631j != null) {
            ArrayList arrayList = new ArrayList(this.f8631j.size());
            Iterator<C1329f> it3 = this.f8631j.iterator();
            while (it3.hasNext()) {
                arrayList.add(it3.next().m10557b(c1339c));
            }
            c1323b.f8631j = arrayList;
        }
        Iterator<C1314l> it4 = this.f8624c.iterator();
        while (it4.hasNext()) {
            c1323b.f8624c.add((C1314l) it4.next().mo10481a(c1339c));
        }
        return c1323b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("// ").append(this.f8626e).append("\n");
        if (this.f8622a) {
            sb.append(" static ");
        }
        sb.append(this.f8627f == null ? (String) null : C1368i.m10770a(this.f8627f)).append(' ').append(this.f8625d).append('(');
        if (this.f8623b != null) {
            boolean z = true;
            for (String str : this.f8623b) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(C1368i.m10770a(str));
            }
        }
        sb.append(") {\n\n").append(this.f8628g).append("\n");
        if (this.f8629h.size() > 0 || this.f8630i.size() > 0) {
            sb.append("=============\n");
            Iterator<C1366g> it = this.f8629h.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append('\n');
            }
            Iterator<C1363d> it2 = this.f8630i.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next()).append('\n');
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
