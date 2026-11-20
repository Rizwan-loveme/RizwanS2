package p046b.p047a.p050c.p051a.p052a;

import android.util.C0035a;

/* compiled from: ResIntValue.java */
/* renamed from: b.a.c.a.a.o */
/* loaded from: classes.dex */
public class C0483o extends AbstractC0486r {

    /* renamed from: a */
    protected final int f3398a;

    /* renamed from: b */
    private int f3399b;

    public C0483o(int i, String str, int i2) {
        this(i, str, "integer");
        this.f3399b = i2;
    }

    public C0483o(int i, String str, String str2) {
        super(str2, i, str);
        this.f3398a = i;
    }

    /* renamed from: b */
    public int m3643b() {
        return this.f3398a;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: a */
    protected String mo3632a() {
        return C0035a.m199b(this.f3399b, this.f3398a);
    }
}
