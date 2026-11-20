package p165d.p167b.p172e;

/* compiled from: CryptoPrimitive.java */
/* renamed from: d.b.e.f */
/* loaded from: classes.dex */
public enum EnumC1443f {
    MESSAGE_DIGEST,
    SECURE_RANDOM,
    BLOCK_CIPHER,
    STREAM_CIPHER,
    MAC,
    KEY_WRAP,
    PUBLIC_KEY_ENCRYPTION,
    SIGNATURE,
    KEY_ENCAPSULATION,
    KEY_AGREEMENT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1443f[] valuesCustom() {
        EnumC1443f[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1443f[] enumC1443fArr = new EnumC1443f[length];
        System.arraycopy(valuesCustom, 0, enumC1443fArr, 0, length);
        return enumC1443fArr;
    }
}
