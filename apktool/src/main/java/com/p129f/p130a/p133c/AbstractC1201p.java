package com.p129f.p130a.p133c;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ComparisonChain.java */
/* renamed from: com.f.a.c.p */
/* loaded from: classes.dex */
public abstract class AbstractC1201p {

    /* renamed from: a */
    private static final AbstractC1201p f7941a = new AbstractC1201p() { // from class: com.f.a.c.p.1
        @Override // com.p129f.p130a.p133c.AbstractC1201p
        /* renamed from: a */
        public AbstractC1201p mo10095a(Comparable comparable, Comparable comparable2) {
            return m10097a(comparable.compareTo(comparable2));
        }

        /* renamed from: a */
        AbstractC1201p m10097a(int i) {
            if (i < 0) {
                return AbstractC1201p.f7942b;
            }
            return i > 0 ? AbstractC1201p.f7943c : AbstractC1201p.f7941a;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1201p
        /* renamed from: b */
        public int mo10096b() {
            return 0;
        }
    };

    /* renamed from: b */
    private static final AbstractC1201p f7942b = new a(-1);

    /* renamed from: c */
    private static final AbstractC1201p f7943c = new a(1);

    /* renamed from: a */
    public abstract AbstractC1201p mo10095a(Comparable<?> comparable, Comparable<?> comparable2);

    /* renamed from: b */
    public abstract int mo10096b();

    private AbstractC1201p() {
    }

    /* renamed from: a */
    public static AbstractC1201p m10091a() {
        return f7941a;
    }

    /* compiled from: ComparisonChain.java */
    /* renamed from: com.f.a.c.p$a */
    private static final class a extends AbstractC1201p {

        /* renamed from: a */
        final int f7944a;

        a(int i) {
            super();
            this.f7944a = i;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1201p
        /* renamed from: a */
        public AbstractC1201p mo10095a(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1201p
        /* renamed from: b */
        public int mo10096b() {
            return this.f7944a;
        }
    }
}
