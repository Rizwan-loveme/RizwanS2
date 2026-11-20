package org.p226d.p233b.p241c;

import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2228p;

/* compiled from: BuilderSwitchPayload.java */
/* renamed from: org.d.b.c.e */
/* loaded from: classes.dex */
public abstract class AbstractC2065e extends AbstractC2063c implements InterfaceC2228p {

    /* renamed from: c */
    C2073m f11722c;

    protected AbstractC2065e(EnumC2272f enumC2272f) {
        super(enumC2272f);
    }

    /* renamed from: e */
    public C2073m m14510e() {
        if (this.f11722c == null) {
            throw new IllegalStateException("The referrer has not been set yet");
        }
        return this.f11722c;
    }
}
