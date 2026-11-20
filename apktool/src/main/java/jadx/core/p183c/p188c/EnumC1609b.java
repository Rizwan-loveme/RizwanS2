package jadx.core.p183c.p188c;

/* compiled from: ArithOp.java */
/* renamed from: jadx.core.c.c.b */
/* loaded from: classes.dex */
public enum EnumC1609b {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    REM("%"),
    AND("&"),
    OR("|"),
    XOR("^"),
    SHL("<<"),
    SHR(">>"),
    USHR(">>>");


    /* renamed from: l */
    private final String f10205l;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1609b[] valuesCustom() {
        EnumC1609b[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1609b[] enumC1609bArr = new EnumC1609b[length];
        System.arraycopy(valuesCustom, 0, enumC1609bArr, 0, length);
        return enumC1609bArr;
    }

    EnumC1609b(String str) {
        this.f10205l = str;
    }

    /* renamed from: a */
    public String m12362a() {
        return this.f10205l;
    }
}
