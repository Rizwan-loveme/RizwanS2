package org.p226d.p233b.p234a;

import com.p129f.p130a.p133c.C1157aj;
import java.util.Map;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2264e;

/* compiled from: DexClassProvider.java */
/* renamed from: org.d.b.a.i */
/* loaded from: classes.dex */
public class C1974i implements InterfaceC1973h {

    /* renamed from: a */
    private final InterfaceC2264e f11498a;

    /* renamed from: b */
    private Map<String, InterfaceC2244d> f11499b = C1157aj.m9935c();

    public C1974i(InterfaceC2264e interfaceC2264e) {
        this.f11498a = interfaceC2264e;
        for (InterfaceC2244d interfaceC2244d : interfaceC2264e.mo14769c()) {
            this.f11499b.put(interfaceC2244d.mo14205l(), interfaceC2244d);
        }
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1973h
    /* renamed from: a */
    public InterfaceC2244d mo14331a(String str) {
        return this.f11499b.get(str);
    }
}
