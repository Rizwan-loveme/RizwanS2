package org.p226d.p233b.p244d.p248d;

import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p244d.p249e.AbstractC2144c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: EncodedArrayItemIterator.java */
/* renamed from: org.d.b.d.d.c */
/* loaded from: classes.dex */
public abstract class AbstractC2132c {

    /* renamed from: a */
    public static final AbstractC2132c f11895a = new AbstractC2132c() { // from class: org.d.b.d.d.c.1
        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: a */
        public InterfaceC2251g mo14718a() {
            return null;
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: b */
        public void mo14719b() {
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: c */
        public int mo14720c() {
            return 0;
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: d */
        public int mo14721d() {
            return 0;
        }
    };

    /* renamed from: a */
    public abstract InterfaceC2251g mo14718a();

    /* renamed from: b */
    public abstract void mo14719b();

    /* renamed from: c */
    public abstract int mo14720c();

    /* renamed from: d */
    public abstract int mo14721d();

    /* renamed from: a */
    public static AbstractC2132c m14717a(C2153g c2153g, int i) {
        return i == 0 ? f11895a : new a(c2153g, i);
    }

    /* compiled from: EncodedArrayItemIterator.java */
    /* renamed from: org.d.b.d.d.c$a */
    private static class a extends AbstractC2132c {

        /* renamed from: b */
        private final C2161o f11896b;

        /* renamed from: c */
        private final int f11897c;

        /* renamed from: d */
        private int f11898d = 0;

        public a(C2153g c2153g, int i) {
            this.f11896b = c2153g.m14783v(i);
            this.f11897c = this.f11896b.m14639c();
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: a */
        public InterfaceC2251g mo14718a() {
            if (this.f11898d >= this.f11897c) {
                return null;
            }
            this.f11898d++;
            return AbstractC2144c.m14735a(this.f11896b);
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: b */
        public void mo14719b() {
            if (this.f11898d < this.f11897c) {
                this.f11898d++;
                AbstractC2144c.m14736b(this.f11896b);
            }
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: c */
        public int mo14720c() {
            return this.f11896b.m14635a();
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2132c
        /* renamed from: d */
        public int mo14721d() {
            return this.f11897c;
        }
    }
}
