package org.p226d.p233b.p263h;

import com.p129f.p130a.p131a.InterfaceC1121p;
import java.util.Collection;
import java.util.Iterator;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p269d.C2450d;

/* compiled from: MethodUtil.java */
/* renamed from: org.d.b.h.g */
/* loaded from: classes.dex */
public final class C2387g {

    /* renamed from: c */
    private static int f12743c = (EnumC1959a.STATIC.m14191a() | EnumC1959a.PRIVATE.m14191a()) | EnumC1959a.CONSTRUCTOR.m14191a();

    /* renamed from: a */
    public static InterfaceC1121p<InterfaceC2267h> f12741a = new InterfaceC1121p<InterfaceC2267h>() { // from class: org.d.b.h.g.1
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2267h interfaceC2267h) {
            return interfaceC2267h != null && C2387g.m15093a(interfaceC2267h);
        }
    };

    /* renamed from: b */
    public static InterfaceC1121p<InterfaceC2267h> f12742b = new InterfaceC1121p<InterfaceC2267h>() { // from class: org.d.b.h.g.2
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2267h interfaceC2267h) {
            return (interfaceC2267h == null || C2387g.m15093a(interfaceC2267h)) ? false : true;
        }
    };

    /* renamed from: a */
    public static boolean m15093a(InterfaceC2267h interfaceC2267h) {
        return (interfaceC2267h.mo14214f() & f12743c) != 0;
    }

    /* renamed from: b */
    public static boolean m15094b(InterfaceC2267h interfaceC2267h) {
        return EnumC1959a.STATIC.m14192a(interfaceC2267h.mo14214f());
    }

    /* renamed from: a */
    public static boolean m15091a(InterfaceC2240e interfaceC2240e) {
        return interfaceC2240e.mo14210b().equals("<init>");
    }

    /* renamed from: c */
    public static boolean m15095c(InterfaceC2267h interfaceC2267h) {
        return (interfaceC2267h.mo14214f() & ((EnumC1959a.PRIVATE.m14191a() | EnumC1959a.PROTECTED.m14191a()) | EnumC1959a.PUBLIC.m14191a())) == 0;
    }

    /* renamed from: d */
    public static int m15096d(InterfaceC2267h interfaceC2267h) {
        return m15089a(interfaceC2267h, m15094b(interfaceC2267h));
    }

    /* renamed from: a */
    public static int m15089a(InterfaceC2240e interfaceC2240e, boolean z) {
        return m15088a(interfaceC2240e.mo14211c(), z);
    }

    /* renamed from: a */
    public static int m15088a(Collection<? extends CharSequence> collection, boolean z) {
        int i;
        Iterator<? extends CharSequence> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            char charAt = it.next().charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i = i2 + 2;
            } else {
                i = i2 + 1;
            }
            i2 = i;
        }
        if (!z) {
            return i2 + 1;
        }
        return i2;
    }

    /* renamed from: a */
    private static char m15087a(CharSequence charSequence) {
        if (charSequence.length() > 1) {
            return 'L';
        }
        return charSequence.charAt(0);
    }

    /* renamed from: a */
    public static String m15090a(Collection<? extends CharSequence> collection, String str) {
        StringBuilder sb = new StringBuilder(collection.size() + 1);
        sb.append(m15087a(str));
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(m15087a(it.next()));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m15092a(InterfaceC2240e interfaceC2240e, InterfaceC2240e interfaceC2240e2) {
        return interfaceC2240e.mo14210b().equals(interfaceC2240e2.mo14210b()) && interfaceC2240e.mo14212d().equals(interfaceC2240e2.mo14212d()) && C2450d.m15489a(interfaceC2240e.mo14211c(), interfaceC2240e2.mo14211c());
    }
}
