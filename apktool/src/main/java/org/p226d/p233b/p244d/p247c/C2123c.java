package org.p226d.p233b.p244d.p247c;

import org.p226d.p233b.p238b.p239a.AbstractC1989c;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedMethodHandleReference.java */
/* renamed from: org.d.b.d.c.c */
/* loaded from: classes.dex */
public class C2123c extends AbstractC1989c {

    /* renamed from: a */
    public final C2153g f11847a;

    /* renamed from: b */
    public final int f11848b;

    /* renamed from: c */
    public final int f11849c;

    public C2123c(C2153g c2153g, int i) {
        this.f11847a = c2153g;
        this.f11848b = i;
        this.f11849c = c2153g.m14778q(i);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    /* renamed from: a */
    public int mo14683a() {
        return this.f11847a.m14617c(this.f11849c + 0);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    /* renamed from: b */
    public InterfaceC2241f mo14684b() {
        int c2 = this.f11847a.m14617c(this.f11849c + 4);
        switch (mo14683a()) {
            case 0:
            case 1:
            case 2:
            case 3:
                return new C2122b(this.f11847a, c2);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return new C2125e(this.f11847a, c2);
            default:
                throw new C2453g("Invalid method handle type: %d", Integer.valueOf(mo14683a()));
        }
    }
}
