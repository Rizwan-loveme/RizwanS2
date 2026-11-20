package org.p226d.p233b.p263h;

import com.p129f.p130a.p131a.InterfaceC1121p;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p250e.InterfaceC2266g;

/* compiled from: FieldUtil.java */
/* renamed from: org.d.b.h.d */
/* loaded from: classes.dex */
public final class C2384d {

    /* renamed from: a */
    public static InterfaceC1121p<InterfaceC2266g> f12736a = new InterfaceC1121p<InterfaceC2266g>() { // from class: org.d.b.h.d.1
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2266g interfaceC2266g) {
            return interfaceC2266g != null && C2384d.m15081a(interfaceC2266g);
        }
    };

    /* renamed from: b */
    public static InterfaceC1121p<InterfaceC2266g> f12737b = new InterfaceC1121p<InterfaceC2266g>() { // from class: org.d.b.h.d.2
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2266g interfaceC2266g) {
            return (interfaceC2266g == null || C2384d.m15081a(interfaceC2266g)) ? false : true;
        }
    };

    /* renamed from: a */
    public static boolean m15081a(InterfaceC2266g interfaceC2266g) {
        return EnumC1959a.STATIC.m14192a(interfaceC2266g.mo14222a());
    }
}
