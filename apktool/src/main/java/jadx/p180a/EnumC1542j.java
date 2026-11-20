package jadx.p180a;

import com.p065b.p066a.p067a.AbstractC0581c;

/* compiled from: ResourceType.java */
/* renamed from: jadx.a.j */
/* loaded from: classes.dex */
public enum EnumC1542j {
    CODE(".dex", ".jar", ".class"),
    MANIFEST(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME),
    XML(".xml"),
    ARSC(".arsc"),
    FONT(".ttf"),
    IMG(".png", ".gif", ".jpg"),
    LIB(".so"),
    UNKNOWN(new String[0]);


    /* renamed from: i */
    private final String[] f9896i;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1542j[] valuesCustom() {
        EnumC1542j[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1542j[] enumC1542jArr = new EnumC1542j[length];
        System.arraycopy(valuesCustom, 0, enumC1542jArr, 0, length);
        return enumC1542jArr;
    }

    EnumC1542j(String... strArr) {
        this.f9896i = strArr;
    }

    /* renamed from: a */
    public String[] m11823a() {
        return this.f9896i;
    }

    /* renamed from: a */
    public static EnumC1542j m11822a(String str) {
        for (EnumC1542j enumC1542j : valuesCustom()) {
            for (String str2 : enumC1542j.m11823a()) {
                if (str.endsWith(str2)) {
                    return enumC1542j;
                }
            }
        }
        return UNKNOWN;
    }
}
