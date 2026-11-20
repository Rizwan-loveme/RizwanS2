package com.p065b.p111c.p113b.p114a.p115a;

import android.security.keystore.KeyProperties;
import java.util.Comparator;

/* compiled from: DigestAlgorithm.java */
/* renamed from: com.b.c.b.a.a.a */
/* loaded from: classes.dex */
public enum EnumC1043a {
    SHA1(KeyProperties.DIGEST_SHA1),
    SHA256(KeyProperties.DIGEST_SHA256);


    /* renamed from: a */
    public static Comparator<EnumC1043a> f6568a = new a(null);

    /* renamed from: e */
    private final String f6572e;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1043a[] valuesCustom() {
        EnumC1043a[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1043a[] enumC1043aArr = new EnumC1043a[length];
        System.arraycopy(valuesCustom, 0, enumC1043aArr, 0, length);
        return enumC1043aArr;
    }

    EnumC1043a(String str) {
        this.f6572e = str;
    }

    /* renamed from: a */
    String m8671a() {
        return this.f6572e;
    }

    /* compiled from: DigestAlgorithm.java */
    /* renamed from: com.b.c.b.a.a.a$a */
    private static class a implements Comparator<EnumC1043a> {

        /* renamed from: a */
        private static int[] f6573a;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* renamed from: a */
        static /* synthetic */ int[] m8672a() {
            int[] iArr = f6573a;
            if (iArr == null) {
                iArr = new int[EnumC1043a.valuesCustom().length];
                try {
                    iArr[EnumC1043a.SHA1.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[EnumC1043a.SHA256.ordinal()] = 2;
                } catch (NoSuchFieldError e3) {
                }
                f6573a = iArr;
            }
            return iArr;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EnumC1043a enumC1043a, EnumC1043a enumC1043a2) {
            switch (m8672a()[enumC1043a.ordinal()]) {
                case 1:
                    switch (m8672a()[enumC1043a2.ordinal()]) {
                        case 1:
                            return 0;
                        case 2:
                            return -1;
                        default:
                            throw new RuntimeException("Unsupported algorithm: " + enumC1043a2);
                    }
                case 2:
                    switch (m8672a()[enumC1043a2.ordinal()]) {
                        case 1:
                            return 1;
                        case 2:
                            return 0;
                        default:
                            throw new RuntimeException("Unsupported algorithm: " + enumC1043a2);
                    }
                default:
                    throw new RuntimeException("Unsupported algorithm: " + enumC1043a);
            }
        }
    }
}
