package org.p226d.p233b.p256f.p259c;

import org.p226d.p233b.p238b.p239a.AbstractC1989c;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p269d.C2453g;

/* compiled from: ImmutableMethodHandleReference.java */
/* renamed from: org.d.b.f.c.c */
/* loaded from: classes.dex */
public class C2323c extends AbstractC1989c implements InterfaceC2326f {

    /* renamed from: a */
    protected final int f12566a;

    /* renamed from: b */
    protected final InterfaceC2326f f12567b;

    public C2323c(int i, InterfaceC2326f interfaceC2326f) {
        this.f12566a = i;
        this.f12567b = interfaceC2326f;
    }

    /* renamed from: b */
    public static C2323c m14960b(InterfaceC2238c interfaceC2238c) {
        InterfaceC2326f m14962b;
        if (interfaceC2238c instanceof C2323c) {
            return (C2323c) interfaceC2238c;
        }
        int mo14683a = interfaceC2238c.mo14683a();
        switch (mo14683a) {
            case 0:
            case 1:
            case 2:
            case 3:
                m14962b = C2322b.m14959b((InterfaceC2237b) interfaceC2238c.mo14684b());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                m14962b = C2325e.m14962b((InterfaceC2240e) interfaceC2238c.mo14684b());
                break;
            default:
                throw new C2453g("Invalid method handle type: %d", Integer.valueOf(mo14683a));
        }
        return new C2323c(mo14683a, m14962b);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    /* renamed from: a */
    public int mo14683a() {
        return this.f12566a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    /* renamed from: b */
    public InterfaceC2241f mo14684b() {
        return this.f12567b;
    }
}
