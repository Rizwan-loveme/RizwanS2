package org.p226d.p233b.p244d.p248d;

import com.p129f.p130a.p133c.AbstractC1174b;
import java.util.Iterator;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;

/* compiled from: VariableSizeLookaheadIterator.java */
/* renamed from: org.d.b.d.d.j */
/* loaded from: classes.dex */
public abstract class AbstractC2139j<T> extends AbstractC1174b<T> implements Iterator<T> {

    /* renamed from: a */
    private final C2161o f11919a;

    /* renamed from: b */
    protected abstract T mo14714b(C2161o c2161o);

    protected AbstractC2139j(C2153g c2153g, int i) {
        this.f11919a = c2153g.m14783v(i);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1174b
    /* renamed from: a */
    protected T mo9903a() {
        return mo14714b(this.f11919a);
    }
}
