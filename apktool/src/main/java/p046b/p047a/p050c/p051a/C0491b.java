package p046b.p047a.p050c.p051a;

/* compiled from: ResID.java */
/* renamed from: b.a.c.a.b */
/* loaded from: classes.dex */
public class C0491b {

    /* renamed from: a */
    public final int f3413a;

    /* renamed from: b */
    public final int f3414b;

    /* renamed from: c */
    public final int f3415c;

    /* renamed from: d */
    public final int f3416d;

    public C0491b(int i) {
        this((i >> 24) & 255, (i >> 16) & 255, 65535 & i, i);
    }

    public C0491b(int i, int i2, int i3, int i4) {
        this.f3413a = i == 0 ? 2 : i;
        this.f3414b = i2;
        this.f3415c = i3;
        this.f3416d = i4;
    }

    public String toString() {
        return String.format("0x%08x", new Integer(this.f3416d));
    }

    public int hashCode() {
        return this.f3416d + 527;
    }

    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f3416d == ((C0491b) obj).f3416d;
    }
}
