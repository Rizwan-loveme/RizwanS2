package com.p140g.p141a.p148e;

/* compiled from: InstructionFormat.java */
/* renamed from: com.g.a.e.c */
/* loaded from: classes.dex */
public enum EnumC1283c {
    kFmt10x(1),
    kFmt12x(1),
    kFmt11n(1),
    kFmt11x(1),
    kFmt10t(1),
    kFmt20t(2),
    kFmt22x(2),
    kFmt21t(2),
    kFmt21s(2),
    kFmt21h(2),
    kFmt21c(2),
    kFmt23x(2),
    kFmt22b(2),
    kFmt22t(2),
    kFmt22s(2),
    kFmt22c(2),
    kFmt30t(3),
    kFmt32x(3),
    kFmt31i(3),
    kFmt31t(3),
    kFmt31c(3),
    kFmt35c(3),
    kFmt3rc(3),
    kFmt45cc(4),
    kFmt4rcc(4),
    kFmt51l(5);


    /* renamed from: A */
    public int f8239A;

    public static EnumC1283c valueOf(String str) {
        for (EnumC1283c enumC1283c : values()) {
            if (enumC1283c.name().equals(str)) {
                return enumC1283c;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC1283c(int i) {
        this.f8239A = i;
    }
}
