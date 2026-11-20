package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: LabelStmt.java */
/* renamed from: com.g.b.a.b.f */
/* loaded from: classes.dex */
public class C1329f extends AbstractC1333j.a {

    /* renamed from: a */
    public String f8636a;

    /* renamed from: b */
    public int f8637b;

    /* renamed from: c */
    public List<C1324a> f8638c;

    /* renamed from: d */
    public Object f8639d;

    @Override // com.p140g.p152b.p153a.p155b.AbstractC1333j
    /* renamed from: a */
    public AbstractC1333j mo10554a(C1339c c1339c) {
        return m10557b(c1339c);
    }

    public C1329f() {
        super(AbstractC1333j.d.LABEL);
        this.f8637b = -1;
    }

    /* renamed from: b */
    public C1329f m10557b(C1339c c1339c) {
        C1329f mo10602a = c1339c.mo10602a(this);
        if (this.f8638c != null && mo10602a.f8638c == null) {
            mo10602a.f8638c = new ArrayList(this.f8638c.size());
            Iterator<C1324a> it = this.f8638c.iterator();
            while (it.hasNext()) {
                mo10602a.f8638c.add((C1324a) it.next().mo10554a(c1339c));
            }
        }
        return mo10602a;
    }

    /* renamed from: a */
    public String m10556a() {
        if (this.f8636a != null) {
            return this.f8636a;
        }
        return String.format("L%08x", new Integer(hashCode()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m10556a()).append(":");
        if (this.f8638c != null && this.f8638c.size() > 0) {
            sb.append(" // ").append(this.f8638c);
        }
        if (this.f8637b >= 0) {
            sb.append(" // line ").append(this.f8637b);
        }
        return sb.toString();
    }
}
