package jadx.core.p183c.p191d;

/* compiled from: ProcessState.java */
/* renamed from: jadx.core.c.d.o */
/* loaded from: classes.dex */
public enum EnumC1649o {
    NOT_LOADED,
    STARTED,
    PROCESSED,
    GENERATED,
    UNLOADED;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1649o[] valuesCustom() {
        EnumC1649o[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1649o[] enumC1649oArr = new EnumC1649o[length];
        System.arraycopy(valuesCustom, 0, enumC1649oArr, 0, length);
        return enumC1649oArr;
    }
}
