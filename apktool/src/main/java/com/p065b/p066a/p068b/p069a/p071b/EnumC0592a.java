package com.p065b.p066a.p068b.p069a.p071b;

import android.security.keystore.KeyProperties;
import java.util.Comparator;

/* compiled from: DigestAlgorithm.java */
/* renamed from: com.b.a.b.a.b.a */
/* loaded from: classes.dex */
public enum EnumC0592a {
    SHA1(KeyProperties.DIGEST_SHA1),
    SHA256(KeyProperties.DIGEST_SHA256);

    public static Comparator<EnumC0592a> BY_STRENGTH_COMPARATOR = new a(null);

    /* renamed from: a */
    private final String f4017a;

    EnumC0592a(String str) {
        this.f4017a = str;
    }

    /* renamed from: a */
    String m5859a() {
        return this.f4017a;
    }

    /* compiled from: DigestAlgorithm.java */
    /* renamed from: com.b.a.b.a.b.a$a */
    private static class a implements Comparator<EnumC0592a> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EnumC0592a enumC0592a, EnumC0592a enumC0592a2) {
            int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
            if (i == 1) {
                int i2 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a2.ordinal()];
                if (i2 == 1) {
                    return 0;
                }
                if (i2 == 2) {
                    return -1;
                }
                throw new RuntimeException("Unsupported algorithm: " + enumC0592a2);
            }
            if (i == 2) {
                int i3 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a2.ordinal()];
                if (i3 == 1) {
                    return 1;
                }
                if (i3 == 2) {
                    return 0;
                }
                throw new RuntimeException("Unsupported algorithm: " + enumC0592a2);
            }
            throw new RuntimeException("Unsupported algorithm: " + enumC0592a);
        }
    }

    /* compiled from: DigestAlgorithm.java */
    /* renamed from: com.b.a.b.a.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final int[] $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm;

        static {
            int[] iArr = new int[EnumC0592a.values().length];
            $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm = iArr;
            try {
                iArr[EnumC0592a.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[EnumC0592a.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
