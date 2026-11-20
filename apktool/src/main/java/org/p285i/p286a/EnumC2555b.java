package org.p285i.p286a;

/* compiled from: Level.java */
/* renamed from: org.i.a.b */
/* loaded from: classes.dex */
public enum EnumC2555b {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");


    /* renamed from: f */
    private int f13324f;

    /* renamed from: g */
    private String f13325g;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC2555b[] valuesCustom() {
        EnumC2555b[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC2555b[] enumC2555bArr = new EnumC2555b[length];
        System.arraycopy(valuesCustom, 0, enumC2555bArr, 0, length);
        return enumC2555bArr;
    }

    EnumC2555b(int i, String str) {
        this.f13324f = i;
        this.f13325g = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f13325g;
    }
}
