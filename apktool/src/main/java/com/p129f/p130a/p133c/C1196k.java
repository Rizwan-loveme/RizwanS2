package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ByFunctionOrdering.java */
/* renamed from: com.f.a.c.k */
/* loaded from: classes.dex */
final class C1196k<F, T> extends AbstractC1163ap<F> implements Serializable {

    /* renamed from: a */
    final InterfaceC1112g<F, ? extends T> f7914a;

    /* renamed from: b */
    final AbstractC1163ap<T> f7915b;

    C1196k(InterfaceC1112g<F, ? extends T> interfaceC1112g, AbstractC1163ap<T> abstractC1163ap) {
        this.f7914a = (InterfaceC1112g) C1120o.m9547a(interfaceC1112g);
        this.f7915b = (AbstractC1163ap) C1120o.m9547a(abstractC1163ap);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
    public int compare(F f2, F f3) {
        return this.f7915b.compare(this.f7914a.mo9517a(f2), this.f7914a.mo9517a(f3));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1196k)) {
            return false;
        }
        C1196k c1196k = (C1196k) obj;
        return this.f7914a.equals(c1196k.f7914a) && this.f7915b.equals(c1196k.f7915b);
    }

    public int hashCode() {
        return C1116k.m9537a(this.f7914a, this.f7915b);
    }

    public String toString() {
        return this.f7915b + ".onResultOf(" + this.f7914a + ")";
    }
}
