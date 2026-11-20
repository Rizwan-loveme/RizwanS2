package p046b.p047a.p050c.p051a.p052a;

/* compiled from: ResEmptyValue.java */
/* renamed from: b.a.c.a.a.g */
/* loaded from: classes.dex */
public class C0475g extends AbstractC0486r {

    /* renamed from: a */
    protected final int f3384a;

    /* renamed from: b */
    protected int f3385b;

    public C0475g(int i, String str, int i2) {
        this(i, str, "integer");
        this.f3385b = i2;
    }

    public C0475g(int i, String str, String str2) {
        super(str2, i, str);
        if (i != 1) {
            throw new UnsupportedOperationException();
        }
        this.f3384a = i;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: a */
    protected String mo3632a() {
        return "@empty";
    }
}
