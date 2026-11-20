package com.p140g.p141a;

/* compiled from: Visibility.java */
/* renamed from: com.g.a.h */
/* loaded from: classes.dex */
public enum EnumC1301h {
    BUILD(0),
    RUNTIME(1),
    SYSTEM(2);


    /* renamed from: d */
    public int f8523d;

    public static EnumC1301h valueOf(String str) {
        for (EnumC1301h enumC1301h : values()) {
            if (enumC1301h.name().equals(str)) {
                return enumC1301h;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC1301h(int i) {
        this.f8523d = i;
    }
}
