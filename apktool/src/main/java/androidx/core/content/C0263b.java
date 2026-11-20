package androidx.core.content;

import android.content.LocusId;

/* compiled from: LocusIdCompat.java */
/* renamed from: androidx.core.content.b */
/* loaded from: classes.dex */
public final class C0263b {

    /* renamed from: a */
    private final String f2048a;

    /* renamed from: b */
    private final LocusId f2049b;

    public int hashCode() {
        return (this.f2048a == null ? 0 : this.f2048a.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0263b c0263b = (C0263b) obj;
            if (this.f2048a == null) {
                return c0263b.f2048a == null;
            }
            return this.f2048a.equals(c0263b.f2048a);
        }
        return false;
    }

    public String toString() {
        return "LocusIdCompat[" + m1936b() + "]";
    }

    /* renamed from: a */
    public LocusId m1937a() {
        return this.f2049b;
    }

    /* renamed from: b */
    private String m1936b() {
        return this.f2048a.length() + "_chars";
    }
}
