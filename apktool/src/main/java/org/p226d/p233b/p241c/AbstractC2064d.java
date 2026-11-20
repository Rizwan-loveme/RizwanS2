package org.p226d.p233b.p241c;

import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p269d.C2453g;

/* compiled from: BuilderOffsetInstruction.java */
/* renamed from: org.d.b.c.d */
/* loaded from: classes.dex */
public abstract class AbstractC2064d extends AbstractC2063c implements InterfaceC2222j {

    /* renamed from: c */
    protected final C2068h f11721c;

    public AbstractC2064d(EnumC2272f enumC2272f, C2068h c2068h) {
        super(enumC2272f);
        this.f11721c = c2068h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        int m14508f = m14508f();
        if (mo14417b() == 1) {
            if (m14508f < -128 || m14508f > 127) {
                throw new C2453g("Invalid instruction offset: %d. Offset must be in [-128, 127]", Integer.valueOf(m14508f));
            }
        } else if (mo14417b() == 2 && (m14508f < -32768 || m14508f > 32767)) {
            throw new C2453g("Invalid instruction offset: %d. Offset must be in [-32768, 32767]", Integer.valueOf(m14508f));
        }
        return m14508f;
    }

    /* renamed from: f */
    int m14508f() {
        return this.f11721c.m14519a() - m14505d().m14548b();
    }

    /* renamed from: g */
    public C2068h m14509g() {
        return this.f11721c;
    }
}
