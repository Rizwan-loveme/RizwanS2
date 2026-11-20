package org.p271f.p272a;

/* compiled from: AnnotationVisitor.java */
/* renamed from: org.f.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2473a {

    /* renamed from: a */
    protected final int f12964a;

    /* renamed from: b */
    protected AbstractC2473a f12965b;

    public AbstractC2473a(int i) {
        this(i, null);
    }

    public AbstractC2473a(int i, AbstractC2473a abstractC2473a) {
        if (i != 262144 && i != 327680) {
            throw new IllegalArgumentException();
        }
        this.f12964a = i;
        this.f12965b = abstractC2473a;
    }

    /* renamed from: a */
    public void mo15638a(String str, Object obj) {
        if (this.f12965b != null) {
            this.f12965b.mo15638a(str, obj);
        }
    }

    /* renamed from: a */
    public void mo15639a(String str, String str2, String str3) {
        if (this.f12965b != null) {
            this.f12965b.mo15639a(str, str2, str3);
        }
    }

    /* renamed from: a */
    public AbstractC2473a mo15636a(String str, String str2) {
        if (this.f12965b != null) {
            return this.f12965b.mo15636a(str, str2);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15635a(String str) {
        if (this.f12965b != null) {
            return this.f12965b.mo15635a(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15637a() {
        if (this.f12965b != null) {
            this.f12965b.mo15637a();
        }
    }
}
