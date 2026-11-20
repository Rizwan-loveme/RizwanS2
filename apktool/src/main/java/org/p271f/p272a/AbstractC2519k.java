package org.p271f.p272a;

/* compiled from: FieldVisitor.java */
/* renamed from: org.f.a.k */
/* loaded from: classes.dex */
public abstract class AbstractC2519k {

    /* renamed from: a */
    protected final int f13160a;

    /* renamed from: b */
    protected AbstractC2519k f13161b;

    public AbstractC2519k(int i) {
        this(i, null);
    }

    public AbstractC2519k(int i, AbstractC2519k abstractC2519k) {
        if (i != 262144 && i != 327680) {
            throw new IllegalArgumentException();
        }
        this.f13160a = i;
        this.f13161b = abstractC2519k;
    }

    /* renamed from: a */
    public AbstractC2473a mo15673a(String str, boolean z) {
        if (this.f13161b != null) {
            return this.f13161b.mo15673a(str, z);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15672a(int i, C2530v c2530v, String str, boolean z) {
        if (this.f13160a < 327680) {
            throw new RuntimeException();
        }
        if (this.f13161b != null) {
            return this.f13161b.mo15672a(i, c2530v, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15831a(C2512d c2512d) {
        if (this.f13161b != null) {
            this.f13161b.mo15831a(c2512d);
        }
    }

    /* renamed from: a */
    public void mo15830a() {
        if (this.f13161b != null) {
            this.f13161b.mo15830a();
        }
    }
}
