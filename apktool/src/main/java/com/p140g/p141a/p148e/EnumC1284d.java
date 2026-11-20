package com.p140g.p141a.p148e;

/* compiled from: InstructionIndexType.java */
/* renamed from: com.g.a.e.d */
/* loaded from: classes.dex */
enum EnumC1284d {
    kIndexUnknown,
    kIndexNone,
    kIndexVaries,
    kIndexTypeRef,
    kIndexStringRef,
    kIndexMethodRef,
    kIndexFieldRef,
    kIndexInlineMethod,
    kIndexVtableOffset,
    kIndexFieldOffset,
    kIndexMethodAndProtoRef,
    kIndexCallSiteRef;

    public static EnumC1284d valueOf(String str) {
        for (EnumC1284d enumC1284d : values()) {
            if (enumC1284d.name().equals(str)) {
                return enumC1284d;
            }
        }
        throw new IllegalArgumentException();
    }
}
