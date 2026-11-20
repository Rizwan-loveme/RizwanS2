package jadx.core.p207e;

import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ResContainer.java */
/* renamed from: jadx.core.e.e */
/* loaded from: classes.dex */
public class C1754e implements Comparable<C1754e> {

    /* renamed from: a */
    private static final InterfaceC2558b f10650a = C2568c.m15995a((Class<?>) C1754e.class);

    /* renamed from: b */
    private final String f10651b;

    /* renamed from: c */
    private final List<C1754e> f10652c;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1754e c1754e) {
        return this.f10651b.compareTo(c1754e.f10651b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1754e)) {
            return false;
        }
        return this.f10651b.equals(((C1754e) obj).f10651b);
    }

    public int hashCode() {
        return this.f10651b.hashCode();
    }

    public String toString() {
        return "Res{" + this.f10651b + ", subFiles=" + this.f10652c + "}";
    }
}
