package jadx.core.p183c.p188c;

/* compiled from: InvokeType.java */
/* renamed from: jadx.core.c.c.n */
/* loaded from: classes.dex */
public enum EnumC1623n {
    STATIC,
    DIRECT,
    VIRTUAL,
    INTERFACE,
    SUPER;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1623n[] valuesCustom() {
        EnumC1623n[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1623n[] enumC1623nArr = new EnumC1623n[length];
        System.arraycopy(valuesCustom, 0, enumC1623nArr, 0, length);
        return enumC1623nArr;
    }
}
