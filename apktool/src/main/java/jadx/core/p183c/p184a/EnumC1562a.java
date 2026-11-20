package jadx.core.p183c.p184a;

/* compiled from: AFlag.java */
/* renamed from: jadx.core.c.a.a */
/* loaded from: classes.dex */
public enum EnumC1562a {
    TRY_ENTER,
    TRY_LEAVE,
    LOOP_START,
    LOOP_END,
    SYNTHETIC,
    FINAL,
    RETURN,
    ORIG_RETURN,
    DECLARE_VAR,
    DONT_WRAP,
    DONT_SHRINK,
    DONT_INLINE,
    DONT_GENERATE,
    SKIP,
    REMOVE,
    SKIP_FIRST_ARG,
    SKIP_ARG,
    ANONYMOUS_CONSTRUCTOR,
    ANONYMOUS_CLASS,
    THIS,
    ELSE_IF_CHAIN,
    WRAPPED,
    ARITH_ONEARG,
    FALL_THROUGH,
    INCONSISTENT_CODE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1562a[] valuesCustom() {
        EnumC1562a[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1562a[] enumC1562aArr = new EnumC1562a[length];
        System.arraycopy(valuesCustom, 0, enumC1562aArr, 0, length);
        return enumC1562aArr;
    }
}
