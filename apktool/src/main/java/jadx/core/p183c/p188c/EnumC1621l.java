package jadx.core.p183c.p188c;

/* compiled from: InsnType.java */
/* renamed from: jadx.core.c.c.l */
/* loaded from: classes.dex */
public enum EnumC1621l {
    CONST,
    CONST_STR,
    CONST_CLASS,
    ARITH,
    NEG,
    NOT,
    MOVE,
    CAST,
    RETURN,
    GOTO,
    THROW,
    MOVE_EXCEPTION,
    CMP_L,
    CMP_G,
    IF,
    SWITCH,
    MONITOR_ENTER,
    MONITOR_EXIT,
    CHECK_CAST,
    INSTANCE_OF,
    ARRAY_LENGTH,
    FILL_ARRAY,
    FILLED_NEW_ARRAY,
    AGET,
    APUT,
    NEW_ARRAY,
    NEW_INSTANCE,
    IGET,
    IPUT,
    SGET,
    SPUT,
    INVOKE,
    NOP,
    TERNARY,
    CONSTRUCTOR,
    BREAK,
    CONTINUE,
    STR_CONCAT,
    ONE_ARG,
    PHI,
    MERGE,
    NEW_MULTIDIM_ARRAY;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1621l[] valuesCustom() {
        EnumC1621l[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1621l[] enumC1621lArr = new EnumC1621l[length];
        System.arraycopy(valuesCustom, 0, enumC1621lArr, 0, length);
        return enumC1621lArr;
    }
}
