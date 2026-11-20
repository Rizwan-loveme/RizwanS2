package p176f.p177a.p178a;

/* compiled from: ResourceHelper.java */
/* renamed from: f.a.a.c */
/* loaded from: classes.dex */
public class C1532c implements Comparable<C1532c> {

    /* renamed from: a */
    public String f9830a;

    /* renamed from: b */
    public String f9831b;

    /* renamed from: c */
    public String f9832c;

    /* renamed from: d */
    public int f9833d;

    @Override // java.lang.Comparable
    public int compareTo(C1532c c1532c) {
        return m11753a(c1532c);
    }

    /* renamed from: a */
    public int m11753a(C1532c c1532c) {
        return this.f9833d - c1532c.f9833d;
    }

    public boolean equals(Object obj) {
        return this.f9830a.equals(((C1532c) obj).f9830a) && this.f9832c.equals(((C1532c) obj).f9832c);
    }
}
