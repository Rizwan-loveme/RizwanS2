package ru.p294a;

/* compiled from: Zip64Mode.java */
/* renamed from: ru.a.p */
/* loaded from: classes.dex */
public enum EnumC2597p {
    Always,
    Never,
    AsNeeded;

    public static EnumC2597p valueOf(String str) {
        for (EnumC2597p enumC2597p : values()) {
            if (enumC2597p.name().equals(str)) {
                return enumC2597p;
            }
        }
        throw new IllegalArgumentException();
    }
}
