package p046b.p047a.p050c.p051a.p052a;

/* compiled from: ResFileValue.java */
/* renamed from: b.a.c.a.a.i */
/* loaded from: classes.dex */
public class C0477i extends C0482n {

    /* renamed from: a */
    private final String f3388a;

    public C0477i(String str, int i) {
        super(i);
        this.f3388a = str;
    }

    /* renamed from: a */
    public String m3634a() {
        return this.f3388a;
    }

    /* renamed from: b */
    public String m3635b() {
        int indexOf = this.f3388a.indexOf(47);
        return indexOf >= 0 ? this.f3388a.substring(indexOf + 1) : this.f3388a;
    }

    /* renamed from: c */
    public String m3636c() {
        int indexOf = this.f3388a.indexOf(47);
        return indexOf > 0 ? this.f3388a.substring(0, indexOf) : "";
    }

    public String toString() {
        return this.f3388a;
    }
}
