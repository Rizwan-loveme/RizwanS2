package org.p226d.p227a.p228a.p231c;

import org.p226d.p227a.C1950b;
import org.p226d.p227a.p228a.C1942j;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p269d.C2457k;

/* compiled from: OffsetInstructionFormatMethodItem.java */
/* renamed from: org.d.a.a.c.d */
/* loaded from: classes.dex */
public class C1932d extends C1930b<InterfaceC2222j> {

    /* renamed from: e */
    static final /* synthetic */ boolean f11304e;

    /* renamed from: d */
    protected C1942j f11305d;

    static {
        f11304e = !C1932d.class.desiredAssertionStatus();
    }

    public C1932d(C1950b c1950b, C1943k c1943k, int i, InterfaceC2222j interfaceC2222j) {
        super(c1943k, i, interfaceC2222j);
        this.f11305d = new C1942j(c1950b, interfaceC2222j.mo14507e() + i, m14119b());
        this.f11305d = c1943k.m14154a().m14160a(this.f11305d);
    }

    @Override // org.p226d.p227a.p228a.p231c.C1930b
    /* renamed from: c */
    protected void mo14103c(C2457k c2457k) {
        this.f11305d.mo14089a(c2457k);
    }

    /* renamed from: b */
    private String m14119b() {
        EnumC2272f a2 = ((InterfaceC2222j) this.f11284b).mo14416a();
        switch (a2.f12386ei) {
            case Format10t:
            case Format20t:
            case Format30t:
                return "goto_";
            case Format21t:
            case Format22t:
                return "cond_";
            case Format31t:
                if (a2 == EnumC2272f.FILL_ARRAY_DATA) {
                    return "array_";
                }
                if (a2 == EnumC2272f.PACKED_SWITCH) {
                    return "pswitch_data_";
                }
                return "sswitch_data_";
            default:
                if (f11304e) {
                    return null;
                }
                throw new AssertionError();
        }
    }
}
