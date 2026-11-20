package jadx.core.p183c.p184a.p186b;

import jadx.core.p203d.C1739h;

/* compiled from: JumpInfo.java */
/* renamed from: jadx.core.c.a.b.j */
/* loaded from: classes.dex */
public class C1576j {

    /* renamed from: a */
    private final int f10071a;

    /* renamed from: b */
    private final int f10072b;

    public C1576j(int i, int i2) {
        this.f10071a = i;
        this.f10072b = i2;
    }

    /* renamed from: a */
    public int m12116a() {
        return this.f10071a;
    }

    /* renamed from: b */
    public int m12117b() {
        return this.f10072b;
    }

    public int hashCode() {
        return (this.f10072b * 31) + this.f10071a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C1576j c1576j = (C1576j) obj;
            return this.f10072b == c1576j.f10072b && this.f10071a == c1576j.f10071a;
        }
        return false;
    }

    public String toString() {
        return "JUMP: " + C1739h.m13270a(this.f10071a) + " -> " + C1739h.m13270a(this.f10072b);
    }
}
