package com.p140g.p141a.p144c;

import org.p271f.p272a.AbstractC2515g;
import org.p271f.p272a.p273a.AbstractC2475b;
import org.p271f.p272a.p273a.C2477d;

/* compiled from: LambadaNameSafeClassAdapter.java */
/* renamed from: com.g.a.c.g */
/* loaded from: classes.dex */
public class C1248g extends C2477d {
    /* renamed from: b */
    public String m10334b() {
        return this.f12973c.mo10335a(this.f12974d);
    }

    public C1248g(AbstractC2515g abstractC2515g) {
        super(abstractC2515g, new AbstractC2475b() { // from class: com.g.a.c.g.1
            @Override // org.p271f.p272a.p273a.AbstractC2475b
            /* renamed from: a */
            public String mo10335a(String str) {
                return str == null ? (String) null : str.replace('-', '_');
            }
        });
    }
}
