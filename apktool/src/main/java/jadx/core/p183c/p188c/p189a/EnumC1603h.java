package jadx.core.p183c.p188c.p189a;

import android.app.slice.SliceItem;

/* compiled from: PrimitiveType.java */
/* renamed from: jadx.core.c.c.a.h */
/* loaded from: classes.dex */
public enum EnumC1603h {
    BOOLEAN("Z", "boolean"),
    CHAR("C", "char"),
    BYTE("B", "byte"),
    SHORT("S", "short"),
    INT("I", SliceItem.FORMAT_INT),
    FLOAT("F", "float"),
    LONG("J", SliceItem.FORMAT_LONG),
    DOUBLE("D", "double"),
    OBJECT("L", "OBJECT"),
    ARRAY("[", "ARRAY"),
    VOID("V", "void");


    /* renamed from: l */
    private final String f10177l;

    /* renamed from: m */
    private final String f10178m;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1603h[] valuesCustom() {
        EnumC1603h[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1603h[] enumC1603hArr = new EnumC1603h[length];
        System.arraycopy(valuesCustom, 0, enumC1603hArr, 0, length);
        return enumC1603hArr;
    }

    EnumC1603h(String str, String str2) {
        this.f10177l = str;
        this.f10178m = str2;
    }

    /* renamed from: a */
    public String m12322a() {
        return this.f10177l;
    }

    /* renamed from: b */
    public String m12323b() {
        return this.f10178m;
    }

    /* renamed from: a */
    public static EnumC1603h m12321a(EnumC1603h enumC1603h, EnumC1603h enumC1603h2) {
        return enumC1603h.ordinal() < enumC1603h2.ordinal() ? enumC1603h : enumC1603h2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f10178m;
    }
}
