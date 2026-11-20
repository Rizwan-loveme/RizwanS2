package org.p226d.p233b;

import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p269d.C2453g;

/* compiled from: ReferenceType.java */
/* renamed from: org.d.b.h */
/* loaded from: classes.dex */
public final class C2380h {
    /* renamed from: a */
    public static String m15068a(int i) {
        switch (i) {
            case 0:
                return "string";
            case 1:
                return "type";
            case 2:
                return "field";
            case 3:
                return "method";
            case 4:
                return "method_proto";
            case 5:
                return "call_site";
            case 6:
                return "method_handle";
            default:
                throw new a(i);
        }
    }

    /* renamed from: a */
    public static int m15067a(InterfaceC2241f interfaceC2241f) {
        if (interfaceC2241f instanceof InterfaceC2242g) {
            return 0;
        }
        if (interfaceC2241f instanceof InterfaceC2243h) {
            return 1;
        }
        if (interfaceC2241f instanceof InterfaceC2237b) {
            return 2;
        }
        if (interfaceC2241f instanceof InterfaceC2240e) {
            return 3;
        }
        if (interfaceC2241f instanceof InterfaceC2239d) {
            return 4;
        }
        if (interfaceC2241f instanceof InterfaceC2236a) {
            return 5;
        }
        if (interfaceC2241f instanceof InterfaceC2238c) {
            return 6;
        }
        throw new IllegalStateException("Invalid reference");
    }

    /* renamed from: b */
    public static void m15069b(int i) {
        if (i < 0 || i > 4) {
            throw new a(i);
        }
    }

    /* compiled from: ReferenceType.java */
    /* renamed from: org.d.b.h$a */
    public static class a extends C2453g {

        /* renamed from: a */
        private final int f12735a;

        public a(int i) {
            super("Invalid reference type: %d", Integer.valueOf(i));
            this.f12735a = i;
        }

        /* renamed from: a */
        public int m15072a() {
            return this.f12735a;
        }
    }
}
