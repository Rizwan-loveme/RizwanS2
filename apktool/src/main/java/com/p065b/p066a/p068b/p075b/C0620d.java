package com.p065b.p066a.p068b.p075b;

import com.p065b.p066a.p068b.p075b.p076a.AbstractC0616d;
import com.p065b.p066a.p068b.p077c.C0627a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: Asn1DerEncoder.java */
/* renamed from: com.b.a.b.b.d */
/* loaded from: classes.dex */
public final class C0620d {
    public static final C0623g ASN1_DER_NULL = new C0623g(new byte[]{5, 0});

    private C0620d() {
    }

    /* renamed from: c */
    public static byte[] m6164c(Object obj) {
        Class<?> cls = obj.getClass();
        InterfaceC0618b interfaceC0618b = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
        if (interfaceC0618b == null) {
            throw new C0621e(cls.getName() + " not annotated with " + InterfaceC0618b.class.getName());
        }
        EnumC0626j m6143a = interfaceC0618b.m6143a();
        int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[m6143a.ordinal()];
        if (i == 1) {
            return m6168e(obj);
        }
        if (i == 2) {
            return m6169f(obj);
        }
        if (i == 3) {
            return m6149a(obj, true);
        }
        throw new C0621e("Unsupported container type: " + m6143a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static byte[] m6168e(Object obj) {
        Class<?> cls = obj.getClass();
        List<a> m6166d = m6166d(obj);
        if (m6166d.isEmpty()) {
            throw new C0621e("No fields annotated with " + InterfaceC0622f.class.getName() + " in CHOICE class " + cls.getName());
        }
        a aVar = null;
        for (a aVar2 : m6166d) {
            if (m6155b(obj, aVar2.m6172b()) != null) {
                if (aVar != null) {
                    throw new C0621e("Multiple non-null fields in CHOICE class " + cls.getName() + ": " + aVar.m6172b().getName() + ", " + aVar2.m6172b().getName());
                }
                aVar = aVar2;
            }
        }
        if (aVar == null) {
            throw new C0621e("No non-null fields in CHOICE class " + cls.getName());
        }
        return aVar.m6173c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static byte[] m6169f(Object obj) {
        return m6149a(obj, false);
    }

    /* renamed from: a */
    private static byte[] m6149a(Object obj, boolean z) {
        Class<?> cls = obj.getClass();
        List<a> m6166d = m6166d(obj);
        Collections.sort(m6166d, new Comparator<a>() { // from class: com.b.a.b.b.d.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                return aVar.m6171a().m6179c() - aVar2.m6171a().m6179c();
            }
        });
        if (m6166d.size() > 1) {
            a aVar = null;
            Iterator<a> it = m6166d.iterator();
            while (true) {
                a aVar2 = aVar;
                if (!it.hasNext()) {
                    break;
                }
                aVar = it.next();
                if (aVar2 != null && aVar2.m6171a().m6179c() == aVar.m6171a().m6179c()) {
                    throw new C0621e("Fields have the same index: " + cls.getName() + "." + aVar2.m6172b().getName() + " and ." + aVar.m6172b().getName());
                }
            }
        }
        ArrayList<byte[]> arrayList = new ArrayList(m6166d.size());
        int i = 0;
        for (a aVar3 : m6166d) {
            try {
                byte[] m6173c = aVar3.m6173c();
                if (m6173c != null) {
                    arrayList.add(m6173c);
                    i = m6173c.length + i;
                }
            } catch (C0621e e2) {
                throw new C0621e("Failed to encode " + cls.getName() + "." + aVar3.m6172b().getName(), e2);
            }
        }
        if (z) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (byte[] bArr2 : arrayList) {
                System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                i2 = bArr2.length + i2;
            }
            return bArr;
        }
        return m6157b(0, true, 16, (byte[][]) arrayList.toArray(new byte[0][]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m6167d(Collection<?> collection, EnumC0626j enumC0626j) {
        return m6153a(collection, enumC0626j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static byte[] m6165c(Collection<?> collection, EnumC0626j enumC0626j) {
        return m6153a(collection, enumC0626j, false);
    }

    /* renamed from: a */
    private static byte[] m6153a(Collection<?> collection, EnumC0626j enumC0626j, boolean z) {
        int i;
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(c.m6176a(it.next(), enumC0626j, null));
        }
        if (z) {
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, b.INSTANCE);
            }
            i = 17;
        } else {
            i = 16;
        }
        return m6157b(0, true, i, (byte[][]) arrayList.toArray(new byte[0][]));
    }

    /* compiled from: Asn1DerEncoder.java */
    /* renamed from: com.b.a.b.b.d$b */
    private static class b implements Comparator<byte[]> {
        private static final b INSTANCE = new b();

        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int i2 = (bArr[i] & 255) - (bArr2[i] & 255);
                if (i2 != 0) {
                    return i2;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    /* renamed from: d */
    private static List<a> m6166d(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            InterfaceC0622f interfaceC0622f = (InterfaceC0622f) field.getAnnotation(InterfaceC0622f.class);
            if (interfaceC0622f != null) {
                if (Modifier.isStatic(field.getModifiers())) {
                    throw new C0621e(InterfaceC0622f.class.getName() + " used on a static field: " + cls.getName() + "." + field.getName());
                }
                try {
                    arrayList.add(new a(obj, field, interfaceC0622f));
                } catch (C0621e e2) {
                    throw new C0621e("Invalid ASN.1 annotation on " + cls.getName() + "." + field.getName(), e2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6156b(int i) {
        return m6158b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6158b(long j) {
        return m6161b(BigInteger.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6161b(BigInteger bigInteger) {
        return m6157b(0, false, 2, bigInteger.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6163b(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        } else {
            bArr[0] = 0;
        }
        return m6157b(0, false, 1, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6160b(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String[] split = str.split("\\.");
        if (split.length < 2) {
            throw new C0621e("OBJECT IDENTIFIER must contain at least two nodes: " + str);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt > 6 || parseInt < 0) {
                throw new C0621e("Invalid value for node #1: " + parseInt);
            }
            try {
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt2 >= 40 || parseInt2 < 0) {
                    throw new C0621e("Invalid value for node #2: " + parseInt2);
                }
                int i = (parseInt * 40) + parseInt2;
                if (i > 255) {
                    throw new C0621e("First two nodes out of range: " + parseInt + "." + parseInt2);
                }
                byteArrayOutputStream.write(i);
                for (int i2 = 2; i2 < split.length; i2++) {
                    String str2 = split[i2];
                    try {
                        int parseInt3 = Integer.parseInt(str2);
                        if (parseInt3 < 0) {
                            throw new C0621e("Invalid value for node #" + (i2 + 1) + ": " + parseInt3);
                        }
                        if (parseInt3 <= 127) {
                            byteArrayOutputStream.write(parseInt3);
                        } else if (parseInt3 < 16384) {
                            byteArrayOutputStream.write((parseInt3 >> 7) | 128);
                            byteArrayOutputStream.write(parseInt3 & 127);
                        } else {
                            if (parseInt3 >= 2097152) {
                                throw new C0621e("Node #" + (i2 + 1) + " too large: " + parseInt3);
                            }
                            byteArrayOutputStream.write((parseInt3 >> 14) | 128);
                            byteArrayOutputStream.write(((parseInt3 >> 7) & 127) | 128);
                            byteArrayOutputStream.write(parseInt3 & 127);
                        }
                    } catch (NumberFormatException e2) {
                        throw new C0621e("Node #" + (i2 + 1) + " not numeric: " + str2);
                    }
                }
                return m6157b(0, false, 6, byteArrayOutputStream.toByteArray());
            } catch (NumberFormatException e3) {
                throw new C0621e("Node #2 not numeric: " + split[1]);
            }
        } catch (NumberFormatException e4) {
            throw new C0621e("Node #1 not numeric: " + split[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Object m6155b(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (ReflectiveOperationException e2) {
            throw new C0621e("Failed to read " + obj.getClass().getName() + "." + field.getName(), e2);
        }
    }

    /* compiled from: Asn1DerEncoder.java */
    /* renamed from: com.b.a.b.b.d$a */
    private static final class a {

        /* renamed from: a */
        private final InterfaceC0622f f4211a;

        /* renamed from: b */
        private final EnumC0626j f4212b;

        /* renamed from: c */
        private final int f4213c;

        /* renamed from: d */
        private final int f4214d;

        /* renamed from: e */
        private final EnumC0626j f4215e;

        /* renamed from: f */
        private final Field f4216f;

        /* renamed from: g */
        private final Object f4217g;

        /* renamed from: h */
        private final boolean f4218h;

        /* renamed from: i */
        private final EnumC0624h f4219i;

        /* renamed from: j */
        private final EnumC0625i f4220j;

        public a(Object obj, Field field, InterfaceC0622f interfaceC0622f) {
            int m6129a;
            this.f4217g = obj;
            this.f4216f = field;
            this.f4211a = interfaceC0622f;
            EnumC0626j m6183g = interfaceC0622f.m6183g();
            this.f4212b = m6183g;
            this.f4215e = interfaceC0622f.m6178b();
            EnumC0624h m6177a = interfaceC0622f.m6177a();
            if (m6177a == EnumC0624h.AUTOMATIC) {
                if (interfaceC0622f.m6181e() != -1) {
                    m6177a = EnumC0624h.CONTEXT_SPECIFIC;
                } else {
                    m6177a = EnumC0624h.UNIVERSAL;
                }
            }
            this.f4219i = m6177a;
            this.f4213c = AbstractC0616d.m6128a(m6177a);
            if (interfaceC0622f.m6181e() != -1) {
                m6129a = interfaceC0622f.m6181e();
            } else {
                m6129a = (m6183g == EnumC0626j.CHOICE || m6183g == EnumC0626j.ANY) ? -1 : AbstractC0616d.m6129a(m6183g);
            }
            this.f4214d = m6129a;
            EnumC0625i m6182f = interfaceC0622f.m6182f();
            this.f4220j = m6182f;
            if ((m6182f == EnumC0625i.EXPLICIT || m6182f == EnumC0625i.IMPLICIT) && interfaceC0622f.m6181e() == -1) {
                throw new C0621e("Tag number must be specified when tagging mode is " + m6182f);
            }
            this.f4218h = interfaceC0622f.m6180d();
        }

        /* renamed from: b */
        public Field m6172b() {
            return this.f4216f;
        }

        /* renamed from: a */
        public InterfaceC0622f m6171a() {
            return this.f4211a;
        }

        /* renamed from: c */
        public byte[] m6173c() {
            Object m6155b = C0620d.m6155b(this.f4217g, this.f4216f);
            if (m6155b == null) {
                if (this.f4218h) {
                    return null;
                }
                throw new C0621e("Required field not set");
            }
            byte[] m6176a = c.m6176a(m6155b, this.f4212b, this.f4215e);
            int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[this.f4220j.ordinal()];
            if (i == 1) {
                return m6176a;
            }
            if (i == 2) {
                return C0620d.m6157b(this.f4213c, true, this.f4214d, m6176a);
            }
            if (i == 3) {
                if (AbstractC0616d.m6133b(m6176a[0]) == 31) {
                    throw new C0621e("High-tag-number form not supported");
                }
                int i2 = this.f4214d;
                if (i2 >= 31) {
                    throw new C0621e("Unsupported high tag number: " + this.f4214d);
                }
                byte m6132b = AbstractC0616d.m6132b(m6176a[0], i2);
                m6176a[0] = m6132b;
                m6176a[0] = AbstractC0616d.m6126a(m6132b, this.f4213c);
                return m6176a;
            }
            throw new RuntimeException("Unknown tagging mode: " + this.f4220j);
        }
    }

    /* compiled from: Asn1DerEncoder.java */
    /* renamed from: com.b.a.b.b.d$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging;
        static final int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type;

        static {
            int[] iArr = new int[EnumC0625i.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging = iArr;
            try {
                iArr[EnumC0625i.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[EnumC0625i.EXPLICIT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Tagging[EnumC0625i.IMPLICIT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[EnumC0626j.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = iArr2;
            try {
                iArr2[EnumC0626j.CHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.UNENCODED_CONTAINER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.OCTET_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.BIT_STRING.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.INTEGER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.BOOLEAN.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.UTC_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.GENERALIZED_TIME.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.OBJECT_IDENTIFIER.ordinal()] = 10;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SET_OF.ordinal()] = 11;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE_OF.ordinal()] = 12;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6157b(int i, boolean z, int i2, byte[]... bArr) {
        byte[] bArr2;
        int i3 = 3;
        if (i2 >= 31) {
            throw new IllegalArgumentException("High tag numbers not supported: " + i2);
        }
        byte b2 = (byte) ((z ? 32 : 0) | (i << 6) | i2);
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            int length2 = bArr[i5].length + i4;
            i5++;
            i4 = length2;
        }
        if (i4 < 128) {
            bArr2 = new byte[i4 + 2];
            bArr2[0] = b2;
            bArr2[1] = (byte) i4;
            i3 = 2;
        } else {
            if (i4 <= 255) {
                bArr2 = new byte[i4 + 3];
                bArr2[1] = -127;
                bArr2[2] = (byte) i4;
            } else if (i4 <= 65535) {
                bArr2 = new byte[i4 + 4];
                bArr2[1] = -126;
                bArr2[2] = (byte) (i4 >> 8);
                bArr2[3] = (byte) (i4 & 255);
                i3 = 4;
            } else if (i4 <= 16777215) {
                bArr2 = new byte[i4 + 5];
                bArr2[1] = -125;
                bArr2[2] = (byte) (i4 >> 16);
                bArr2[3] = (byte) ((i4 >> 8) & 255);
                bArr2[4] = (byte) (i4 & 255);
                i3 = 5;
            } else {
                bArr2 = new byte[i4 + 6];
                bArr2[1] = -124;
                bArr2[2] = (byte) (i4 >> 24);
                bArr2[3] = (byte) ((i4 >> 16) & 255);
                bArr2[4] = (byte) ((i4 >> 8) & 255);
                bArr2[5] = (byte) (i4 & 255);
                i3 = 6;
            }
            bArr2[0] = b2;
        }
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
            i3 += bArr3.length;
        }
        return bArr2;
    }

    /* compiled from: Asn1DerEncoder.java */
    /* renamed from: com.b.a.b.b.d$c */
    private static final class c {
        private c() {
        }

        /* renamed from: a */
        public static byte[] m6176a(Object obj, EnumC0626j enumC0626j, EnumC0626j enumC0626j2) {
            byte[] bArr;
            Class<?> cls = obj.getClass();
            if (C0623g.class.equals(cls)) {
                ByteBuffer m6184a = ((C0623g) obj).m6184a();
                byte[] bArr2 = new byte[m6184a.remaining()];
                m6184a.get(bArr2);
                return bArr2;
            }
            if (enumC0626j == null || enumC0626j == EnumC0626j.ANY) {
                return C0620d.m6164c(obj);
            }
            switch (AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[enumC0626j.ordinal()]) {
                case 1:
                    InterfaceC0618b interfaceC0618b = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
                    if (interfaceC0618b != null && interfaceC0618b.m6143a() == EnumC0626j.CHOICE) {
                        return C0620d.m6168e(obj);
                    }
                    break;
                case 2:
                    InterfaceC0618b interfaceC0618b2 = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
                    if (interfaceC0618b2 != null && interfaceC0618b2.m6143a() == EnumC0626j.SEQUENCE) {
                        return C0620d.m6169f(obj);
                    }
                    break;
                case 4:
                case 5:
                    if (obj instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) obj;
                        byte[] bArr3 = new byte[byteBuffer.remaining()];
                        byteBuffer.slice().get(bArr3);
                        bArr = bArr3;
                    } else {
                        bArr = obj instanceof byte[] ? (byte[]) obj : null;
                    }
                    if (bArr != null) {
                        return C0620d.m6157b(0, false, AbstractC0616d.m6129a(enumC0626j), bArr);
                    }
                    break;
                case 6:
                    if (obj instanceof Integer) {
                        return C0620d.m6156b(((Integer) obj).intValue());
                    }
                    if (obj instanceof Long) {
                        return C0620d.m6158b(((Long) obj).longValue());
                    }
                    if (obj instanceof BigInteger) {
                        return C0620d.m6161b((BigInteger) obj);
                    }
                    break;
                case 7:
                    if (obj instanceof Boolean) {
                        return C0620d.m6163b(((Boolean) obj).booleanValue());
                    }
                    break;
                case 8:
                case 9:
                    if (obj instanceof String) {
                        return C0620d.m6157b(0, false, AbstractC0616d.m6129a(enumC0626j), ((String) obj).getBytes());
                    }
                    break;
                case 10:
                    if (obj instanceof String) {
                        return C0620d.m6160b((String) obj);
                    }
                    break;
                case 11:
                    return C0620d.m6167d((Collection) obj, enumC0626j2);
                case 12:
                    return C0620d.m6165c((Collection) obj, enumC0626j2);
            }
            throw new C0621e("Unsupported conversion: " + cls.getName() + " to ASN.1 " + enumC0626j);
        }
    }
}
