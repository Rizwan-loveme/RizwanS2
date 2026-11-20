package com.p140g.p152b.p153a;

/* compiled from: ET.java */
/* renamed from: com.g.b.a.a */
/* loaded from: classes.dex */
public enum EnumC1302a {
    E0,
    E1,
    E2,
    En;

    public static EnumC1302a valueOf(String str) {
        for (EnumC1302a enumC1302a : values()) {
            if (enumC1302a.name().equals(str)) {
                return enumC1302a;
            }
        }
        throw new IllegalArgumentException();
    }
}
