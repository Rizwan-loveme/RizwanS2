package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.InterfaceC0944z;
import com.p065b.p086b.p108g.p109a.C0984f;
import java.util.EnumSet;

/* compiled from: Optimizer.java */
/* renamed from: com.b.b.g.m */
/* loaded from: classes.dex */
public class C0996m {

    /* renamed from: a */
    private static boolean f6393a = true;

    /* renamed from: b */
    private static InterfaceC0944z f6394b;

    /* compiled from: Optimizer.java */
    /* renamed from: com.b.b.g.m$a */
    public enum a {
        MOVE_PARAM_COMBINER,
        SCCP,
        LITERAL_UPGRADE,
        CONST_COLLECTOR,
        ESCAPE_ANALYSIS
    }

    /* renamed from: a */
    public static boolean m8301a() {
        return f6393a;
    }

    /* renamed from: b */
    public static InterfaceC0944z m8302b() {
        return f6394b;
    }

    /* renamed from: a */
    public static C0938t m8298a(C0938t c0938t, int i, boolean z, boolean z2, InterfaceC0944z interfaceC0944z) {
        return m8299a(c0938t, i, z, z2, interfaceC0944z, EnumSet.allOf(a.class));
    }

    /* renamed from: a */
    public static C0938t m8299a(C0938t c0938t, int i, boolean z, boolean z2, InterfaceC0944z interfaceC0944z, EnumSet<a> enumSet) {
        f6393a = z2;
        f6394b = interfaceC0944z;
        C1005v m8376a = C1003t.m8376a(c0938t, i, z);
        m8300a(m8376a, enumSet);
        C0938t m8200a = C0984f.m8200a(m8376a, false);
        if (m8200a.m7977a().m7859e() > f6394b.mo7870a()) {
            return m8297a(c0938t, i, z, enumSet);
        }
        return m8200a;
    }

    /* renamed from: a */
    private static C0938t m8297a(C0938t c0938t, int i, boolean z, EnumSet<a> enumSet) {
        C1005v m8376a = C1003t.m8376a(c0938t, i, z);
        EnumSet<a> clone = enumSet.clone();
        clone.remove(a.CONST_COLLECTOR);
        m8300a(m8376a, clone);
        return C0984f.m8200a(m8376a, true);
    }

    /* renamed from: a */
    private static void m8300a(C1005v c1005v, EnumSet<a> enumSet) {
        boolean z = false;
        boolean z2 = true;
        if (enumSet.contains(a.MOVE_PARAM_COMBINER)) {
            C0994k.m8279a(c1005v);
        }
        if (enumSet.contains(a.SCCP)) {
            C1000q.m8323a(c1005v);
            C0986c.m8217a(c1005v);
            z2 = false;
        }
        if (enumSet.contains(a.LITERAL_UPGRADE)) {
            C0991h.m8261a(c1005v);
            C0986c.m8217a(c1005v);
            z2 = false;
        }
        enumSet.remove(a.ESCAPE_ANALYSIS);
        if (enumSet.contains(a.ESCAPE_ANALYSIS)) {
            C0989f.m8246a(c1005v);
            C0986c.m8217a(c1005v);
            z2 = false;
        }
        if (enumSet.contains(a.CONST_COLLECTOR)) {
            C0985b.m8212a(c1005v);
            C0986c.m8217a(c1005v);
        } else {
            z = z2;
        }
        if (z) {
            C0986c.m8217a(c1005v);
        }
        C0998o.m8313a(c1005v);
    }
}
