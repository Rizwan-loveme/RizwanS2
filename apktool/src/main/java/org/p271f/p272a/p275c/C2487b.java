package org.p271f.p272a.p275c;

import java.util.ArrayList;
import java.util.List;
import org.p271f.p272a.AbstractC2473a;

/* compiled from: AnnotationNode.java */
/* renamed from: org.f.a.c.b */
/* loaded from: classes.dex */
public class C2487b extends AbstractC2473a {

    /* renamed from: c */
    public String f13000c;

    /* renamed from: d */
    public List<Object> f13001d;

    public C2487b(String str) {
        this(327680, str);
        if (getClass() != C2487b.class) {
            throw new IllegalStateException();
        }
    }

    public C2487b(int i, String str) {
        super(i);
        this.f13000c = str;
    }

    C2487b(List<Object> list) {
        super(327680);
        this.f13001d = list;
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15638a(String str, Object obj) {
        if (this.f13001d == null) {
            this.f13001d = new ArrayList(this.f13000c != null ? 2 : 1);
        }
        if (this.f13000c != null) {
            this.f13001d.add(str);
        }
        this.f13001d.add(obj);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15639a(String str, String str2, String str3) {
        if (this.f13001d == null) {
            this.f13001d = new ArrayList(this.f13000c != null ? 2 : 1);
        }
        if (this.f13000c != null) {
            this.f13001d.add(str);
        }
        this.f13001d.add(new String[]{str2, str3});
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15636a(String str, String str2) {
        if (this.f13001d == null) {
            this.f13001d = new ArrayList(this.f13000c != null ? 2 : 1);
        }
        if (this.f13000c != null) {
            this.f13001d.add(str);
        }
        C2487b c2487b = new C2487b(str2);
        this.f13001d.add(c2487b);
        return c2487b;
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15635a(String str) {
        if (this.f13001d == null) {
            this.f13001d = new ArrayList(this.f13000c != null ? 2 : 1);
        }
        if (this.f13000c != null) {
            this.f13001d.add(str);
        }
        ArrayList arrayList = new ArrayList();
        this.f13001d.add(arrayList);
        return new C2487b(arrayList);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15637a() {
    }

    /* renamed from: a */
    public void m15723a(AbstractC2473a abstractC2473a) {
        if (abstractC2473a != null) {
            if (this.f13001d != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f13001d.size()) {
                        break;
                    }
                    m15722a(abstractC2473a, (String) this.f13001d.get(i2), this.f13001d.get(i2 + 1));
                    i = i2 + 2;
                }
            }
            abstractC2473a.mo15637a();
        }
    }

    /* renamed from: a */
    static void m15722a(AbstractC2473a abstractC2473a, String str, Object obj) {
        if (abstractC2473a != null) {
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                abstractC2473a.mo15639a(str, strArr[0], strArr[1]);
                return;
            }
            if (obj instanceof C2487b) {
                C2487b c2487b = (C2487b) obj;
                c2487b.m15723a(abstractC2473a.mo15636a(str, c2487b.f13000c));
            } else {
                if (obj instanceof List) {
                    AbstractC2473a mo15635a = abstractC2473a.mo15635a(str);
                    List list = (List) obj;
                    for (int i = 0; i < list.size(); i++) {
                        m15722a(mo15635a, (String) null, list.get(i));
                    }
                    mo15635a.mo15637a();
                    return;
                }
                abstractC2473a.mo15638a(str, obj);
            }
        }
    }
}
