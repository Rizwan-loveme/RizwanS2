package org.p271f.p272a;

/* compiled from: ClassVisitor.java */
/* renamed from: org.f.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC2515g {

    /* renamed from: a */
    protected final int f13095a;

    /* renamed from: b */
    protected AbstractC2515g f13096b;

    public AbstractC2515g(int i) {
        this(i, null);
    }

    public AbstractC2515g(int i, AbstractC2515g abstractC2515g) {
        if (i != 262144 && i != 327680) {
            throw new IllegalArgumentException();
        }
        this.f13095a = i;
        this.f13096b = abstractC2515g;
    }

    /* renamed from: a */
    public void mo15669a(int i, int i2, String str, String str2, String str3, String[] strArr) {
        if (this.f13096b != null) {
            this.f13096b.mo15669a(i, i2, str, str2, str3, strArr);
        }
    }

    /* renamed from: a */
    public void mo15798a(String str, String str2) {
        if (this.f13096b != null) {
            this.f13096b.mo15798a(str, str2);
        }
    }

    /* renamed from: a */
    public void mo15670a(String str, String str2, String str3) {
        if (this.f13096b != null) {
            this.f13096b.mo15670a(str, str2, str3);
        }
    }

    /* renamed from: a */
    public AbstractC2473a mo15663a(String str, boolean z) {
        if (this.f13096b != null) {
            return this.f13096b.mo15663a(str, z);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15662a(int i, C2530v c2530v, String str, boolean z) {
        if (this.f13095a < 327680) {
            throw new RuntimeException();
        }
        if (this.f13096b != null) {
            return this.f13096b.mo15662a(i, c2530v, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15799a(C2512d c2512d) {
        if (this.f13096b != null) {
            this.f13096b.mo15799a(c2512d);
        }
    }

    /* renamed from: a */
    public void mo15671a(String str, String str2, String str3, int i) {
        if (this.f13096b != null) {
            this.f13096b.mo15671a(str, str2, str3, i);
        }
    }

    /* renamed from: a */
    public AbstractC2519k mo15665a(int i, String str, String str2, String str3, Object obj) {
        if (this.f13096b != null) {
            return this.f13096b.mo15665a(i, str, str2, str3, obj);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2526r mo15667a(int i, String str, String str2, String str3, String[] strArr) {
        if (this.f13096b != null) {
            return this.f13096b.mo15667a(i, str, str2, str3, strArr);
        }
        return null;
    }

    /* renamed from: a */
    public void mo10327a() {
        if (this.f13096b != null) {
            this.f13096b.mo10327a();
        }
    }
}
