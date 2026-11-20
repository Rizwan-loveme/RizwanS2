package org.p226d.p233b;

import com.p129f.p130a.p133c.C1157aj;
import com.p129f.p130a.p133c.InterfaceC1168au;
import java.util.EnumMap;
import java.util.HashMap;

/* compiled from: Opcodes.java */
/* renamed from: org.d.b.g */
/* loaded from: classes.dex */
public class C2359g {

    /* renamed from: a */
    public final int f12635a;

    /* renamed from: b */
    public final int f12636b;

    /* renamed from: c */
    private final EnumC2272f[] f12637c = new EnumC2272f[256];

    /* renamed from: d */
    private final EnumMap<EnumC2272f, Short> f12638d;

    /* renamed from: e */
    private final HashMap<String, EnumC2272f> f12639e;

    /* renamed from: a */
    public static C2359g m15023a(int i) {
        return new C2359g(i, -1);
    }

    /* renamed from: b */
    public static C2359g m15024b(int i) {
        return new C2359g(-1, i);
    }

    /* renamed from: c */
    public static C2359g m15025c(int i) {
        int m15475a = C2445j.m15475a(i);
        if (m15475a == -1) {
            throw new RuntimeException("Unsupported dex version " + i);
        }
        return new C2359g(m15475a, -1);
    }

    /* renamed from: a */
    public static C2359g m15022a() {
        return m15023a(20);
    }

    private C2359g(int i, int i2) {
        int i3;
        InterfaceC1168au<Integer, Short> interfaceC1168au;
        if (i >= 21) {
            this.f12635a = i;
            this.f12636b = C2445j.m15478d(i);
        } else if (i2 >= 0 && i2 < 39) {
            this.f12635a = C2445j.m15477c(i2);
            this.f12636b = i2;
        } else {
            this.f12635a = i;
            this.f12636b = i2;
        }
        this.f12638d = new EnumMap<>(EnumC2272f.class);
        this.f12639e = C1157aj.m9935c();
        if (m15028b()) {
            i3 = this.f12636b;
        } else {
            i3 = this.f12635a;
        }
        for (EnumC2272f enumC2272f : EnumC2272f.values()) {
            if (m15028b()) {
                interfaceC1168au = enumC2272f.f12383ef;
            } else {
                interfaceC1168au = enumC2272f.f12382ee;
            }
            Short mo9982a = interfaceC1168au.mo9982a(Integer.valueOf(i3));
            if (mo9982a != null) {
                if (!enumC2272f.f12386ei.f11800M) {
                    this.f12637c[mo9982a.shortValue()] = enumC2272f;
                }
                this.f12638d.put((EnumMap<EnumC2272f, Short>) enumC2272f, (EnumC2272f) mo9982a);
                this.f12639e.put(enumC2272f.f12384eg.toLowerCase(), enumC2272f);
            }
        }
    }

    /* renamed from: a */
    public EnumC2272f m15027a(String str) {
        return this.f12639e.get(str.toLowerCase());
    }

    /* renamed from: d */
    public EnumC2272f m15029d(int i) {
        switch (i) {
            case 256:
                return EnumC2272f.PACKED_SWITCH_PAYLOAD;
            case 512:
                return EnumC2272f.SPARSE_SWITCH_PAYLOAD;
            case 768:
                return EnumC2272f.ARRAY_PAYLOAD;
            default:
                if (i >= 0 && i < this.f12637c.length) {
                    return this.f12637c[i];
                }
                return null;
        }
    }

    /* renamed from: a */
    public Short m15026a(EnumC2272f enumC2272f) {
        return this.f12638d.get(enumC2272f);
    }

    /* renamed from: b */
    public boolean m15028b() {
        return this.f12636b != -1;
    }
}
