package com.p065b.p066a.p068b.p075b;

import android.p008os.Build;
import com.p065b.p066a.p068b.p075b.p076a.AbstractC0616d;
import com.p065b.p066a.p068b.p075b.p076a.C0613a;
import com.p065b.p066a.p068b.p075b.p076a.C0614b;
import com.p065b.p066a.p068b.p075b.p076a.C0617e;
import com.p065b.p066a.p068b.p075b.p076a.InterfaceC0615c;
import com.p065b.p066a.p068b.p077c.C0627a;
import com.p065b.p066a.p068b.p081g.C0644c;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: Asn1BerParser.java */
/* renamed from: com.b.a.b.b.a */
/* loaded from: classes.dex */
public final class C0612a {
    private C0612a() {
    }

    /* renamed from: a */
    public static <T> T m6091a(ByteBuffer byteBuffer, Class<T> cls) {
        try {
            C0613a mo6123a = new C0617e(byteBuffer).mo6123a();
            if (mo6123a == null) {
                throw new C0619c("Empty input");
            }
            return (T) m6101d(mo6123a, cls);
        } catch (C0614b e2) {
            throw new C0619c("Failed to decode top-level data value", e2);
        }
    }

    /* renamed from: b */
    public static <T> List<T> m6098b(ByteBuffer byteBuffer, Class<T> cls) {
        try {
            C0613a mo6123a = new C0617e(byteBuffer).mo6123a();
            if (mo6123a == null) {
                throw new C0619c("Empty input");
            }
            return m6108g(mo6123a, cls);
        } catch (C0614b e2) {
            throw new C0619c("Failed to decode top-level data value", e2);
        }
    }

    /* compiled from: Asn1BerParser.java */
    /* renamed from: com.b.a.b.b.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type;

        static {
            int[] iArr = new int[EnumC0626j.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = iArr;
            try {
                iArr[EnumC0626j.CHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.UNENCODED_CONTAINER.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SET_OF.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE_OF.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.INTEGER.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.OBJECT_IDENTIFIER.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.UTC_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.GENERALIZED_TIME.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.BOOLEAN.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* renamed from: d */
    private static <T> T m6101d(C0613a c0613a, Class<T> cls) {
        if (c0613a == null) {
            throw new NullPointerException("container == null");
        }
        if (cls == null) {
            throw new NullPointerException("containerClass == null");
        }
        EnumC0626j m6095b = m6095b((Class<?>) cls);
        int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[m6095b.ordinal()];
        if (i == 1) {
            return (T) m6104e(c0613a, cls);
        }
        if (i != 2) {
            if (i == 3) {
                return (T) m6090a(c0613a, cls, true);
            }
            throw new C0619c("Parsing container " + m6095b + " not supported");
        }
        int m6129a = AbstractC0616d.m6129a(m6095b);
        if (c0613a.m6115d() != 0 || c0613a.m6116e() != m6129a) {
            throw new b("Unexpected data value read as " + cls.getName() + ". Expected " + AbstractC0616d.m6131a(0, m6129a) + ", but read: " + AbstractC0616d.m6131a(c0613a.m6115d(), c0613a.m6116e()));
        }
        return (T) m6105f(c0613a, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static <T> T m6104e(C0613a c0613a, Class<T> cls) {
        List<a> m6093a = m6093a((Class<?>) cls);
        if (m6093a.isEmpty()) {
            throw new C0619c("No fields annotated with " + InterfaceC0622f.class.getName() + " in CHOICE class " + cls.getName());
        }
        int i = 0;
        while (i < m6093a.size() - 1) {
            a aVar = m6093a.get(i);
            int m6120c = aVar.m6120c();
            int m6119b = aVar.m6119b();
            int i2 = i + 1;
            for (int i3 = i2; i3 < m6093a.size(); i3++) {
                a aVar2 = m6093a.get(i3);
                int m6120c2 = aVar2.m6120c();
                int m6119b2 = aVar2.m6119b();
                if (m6120c == m6120c2 && m6119b == m6119b2) {
                    throw new C0619c("CHOICE fields are indistinguishable because they have the same tag class and number: " + cls.getName() + "." + aVar.m6121d().getName() + " and ." + aVar2.m6121d().getName());
                }
            }
            i = i2;
        }
        try {
            T newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Iterator<a> it = m6093a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().m6118a(c0613a, newInstance);
                    return newInstance;
                } catch (b e2) {
                }
            }
            throw new C0619c("No options of CHOICE " + cls.getName() + " matched");
        } catch (IllegalArgumentException | ReflectiveOperationException e3) {
            throw new C0619c("Failed to instantiate " + cls.getName(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static <T> T m6105f(C0613a c0613a, Class<T> cls) {
        return (T) m6090a(c0613a, cls, false);
    }

    /* renamed from: a */
    private static <T> T m6090a(C0613a c0613a, Class<T> cls, boolean z) {
        C0613a mo6123a;
        List<a> m6093a = m6093a((Class<?>) cls);
        Collections.sort(m6093a, new Comparator<a>() { // from class: com.b.a.b.b.a.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                return aVar.m6117a().m6179c() - aVar2.m6117a().m6179c();
            }
        });
        if (m6093a.size() > 1) {
            a aVar = null;
            Iterator<a> it = m6093a.iterator();
            while (true) {
                a aVar2 = aVar;
                if (!it.hasNext()) {
                    break;
                }
                aVar = it.next();
                if (aVar2 != null && aVar2.m6117a().m6179c() == aVar.m6117a().m6179c()) {
                    throw new C0619c("Fields have the same index: " + cls.getName() + "." + aVar2.m6121d().getName() + " and ." + aVar.m6121d().getName());
                }
            }
        }
        try {
            T newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            InterfaceC0615c m6112a = c0613a.m6112a();
            int i = 0;
            while (i < m6093a.size()) {
                if (z && i == 0) {
                    mo6123a = c0613a;
                } else {
                    try {
                        mo6123a = m6112a.mo6123a();
                    } catch (C0614b e2) {
                        throw new C0619c("Malformed data value", e2);
                    }
                }
                if (mo6123a == null) {
                    break;
                }
                for (int i2 = i; i2 < m6093a.size(); i2++) {
                    a aVar3 = m6093a.get(i2);
                    try {
                        if (aVar3.m6122e()) {
                            try {
                                aVar3.m6118a(mo6123a, newInstance);
                            } catch (b e3) {
                            }
                        } else {
                            aVar3.m6118a(mo6123a, newInstance);
                        }
                        i = i2 + 1;
                        break;
                    } catch (C0619c e4) {
                        throw new C0619c("Failed to parse " + cls.getName() + "." + aVar3.m6121d().getName(), e4);
                    }
                }
            }
            return newInstance;
        } catch (IllegalArgumentException | ReflectiveOperationException e5) {
            throw new C0619c("Failed to instantiate " + cls.getName(), e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static <T> List<T> m6108g(C0613a c0613a, Class<T> cls) {
        Object m6101d;
        ArrayList arrayList = new ArrayList();
        InterfaceC0615c m6112a = c0613a.m6112a();
        while (true) {
            try {
                C0613a mo6123a = m6112a.mo6123a();
                if (mo6123a == null) {
                    return arrayList;
                }
                if (ByteBuffer.class.equals(cls)) {
                    m6101d = mo6123a.m6114c();
                } else if (C0623g.class.equals(cls)) {
                    m6101d = new C0623g(mo6123a.m6113b());
                } else {
                    m6101d = m6101d(mo6123a, cls);
                }
                arrayList.add(m6101d);
            } catch (C0614b e2) {
                throw new C0619c("Malformed data value", e2);
            }
        }
    }

    /* renamed from: b */
    private static EnumC0626j m6095b(Class<?> cls) {
        InterfaceC0618b interfaceC0618b = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
        if (interfaceC0618b == null) {
            throw new C0619c(cls.getName() + " is not annotated with " + InterfaceC0618b.class.getName());
        }
        int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[interfaceC0618b.m6143a().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return interfaceC0618b.m6143a();
        }
        throw new C0619c("Unsupported ASN.1 container annotation type: " + interfaceC0618b.m6143a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Class<?> m6096b(Field field) {
        String obj;
        if (Build.VERSION.SDK_INT >= 28) {
            obj = field.getGenericType().toString();
        } else {
            obj = field.getGenericType().toString();
        }
        int indexOf = obj.indexOf(60);
        if (indexOf == -1) {
            throw new C0619c("Not a container type: " + field.getGenericType());
        }
        int i = indexOf + 1;
        int indexOf2 = obj.indexOf(62, i);
        if (indexOf2 == -1) {
            throw new C0619c("Not a container type: " + field.getGenericType());
        }
        return Class.forName(obj.substring(i, indexOf2));
    }

    /* compiled from: Asn1BerParser.java */
    /* renamed from: com.b.a.b.b.a$a */
    private static final class a {

        /* renamed from: a */
        private final InterfaceC0622f f4202a;

        /* renamed from: b */
        private final int f4203b;

        /* renamed from: c */
        private final int f4204c;

        /* renamed from: d */
        private final EnumC0626j f4205d;

        /* renamed from: e */
        private final Field f4206e;

        /* renamed from: f */
        private final boolean f4207f;

        /* renamed from: g */
        private final EnumC0624h f4208g;

        /* renamed from: h */
        private final EnumC0625i f4209h;

        public a(Field field, InterfaceC0622f interfaceC0622f) {
            int m6129a;
            this.f4206e = field;
            this.f4202a = interfaceC0622f;
            EnumC0626j m6183g = interfaceC0622f.m6183g();
            this.f4205d = m6183g;
            EnumC0624h m6177a = interfaceC0622f.m6177a();
            if (m6177a == EnumC0624h.AUTOMATIC) {
                if (interfaceC0622f.m6181e() != -1) {
                    m6177a = EnumC0624h.CONTEXT_SPECIFIC;
                } else {
                    m6177a = EnumC0624h.UNIVERSAL;
                }
            }
            this.f4208g = m6177a;
            this.f4203b = AbstractC0616d.m6128a(m6177a);
            if (interfaceC0622f.m6181e() != -1) {
                m6129a = interfaceC0622f.m6181e();
            } else {
                m6129a = (m6183g == EnumC0626j.CHOICE || m6183g == EnumC0626j.ANY) ? -1 : AbstractC0616d.m6129a(m6183g);
            }
            this.f4204c = m6129a;
            EnumC0625i m6182f = interfaceC0622f.m6182f();
            this.f4209h = m6182f;
            if ((m6182f == EnumC0625i.EXPLICIT || m6182f == EnumC0625i.IMPLICIT) && interfaceC0622f.m6181e() == -1) {
                throw new C0619c("Tag number must be specified when tagging mode is " + m6182f);
            }
            this.f4207f = interfaceC0622f.m6180d();
        }

        /* renamed from: d */
        public Field m6121d() {
            return this.f4206e;
        }

        /* renamed from: a */
        public InterfaceC0622f m6117a() {
            return this.f4202a;
        }

        /* renamed from: e */
        public boolean m6122e() {
            return this.f4207f;
        }

        /* renamed from: b */
        public int m6119b() {
            return this.f4203b;
        }

        /* renamed from: c */
        public int m6120c() {
            return this.f4204c;
        }

        /* renamed from: a */
        public void m6118a(C0613a c0613a, Object obj) {
            int m6115d = c0613a.m6115d();
            if (this.f4204c != -1) {
                int m6116e = c0613a.m6116e();
                if (m6115d != this.f4203b || m6116e != this.f4204c) {
                    throw new b("Tag mismatch. Expected: " + AbstractC0616d.m6131a(this.f4203b, this.f4204c) + ", but found " + AbstractC0616d.m6131a(m6115d, m6116e));
                }
            } else if (m6115d != this.f4203b) {
                throw new b("Tag mismatch. Expected class: " + AbstractC0616d.m6130a(this.f4203b) + ", but found " + AbstractC0616d.m6130a(m6115d));
            }
            if (this.f4209h == EnumC0625i.EXPLICIT) {
                try {
                    c0613a = c0613a.m6112a().mo6123a();
                } catch (C0614b e2) {
                    throw new C0619c("Failed to read contents of EXPLICIT data value", e2);
                }
            }
            c.m6125a(obj, this.f4206e, this.f4205d, c0613a);
        }
    }

    /* compiled from: Asn1BerParser.java */
    /* renamed from: com.b.a.b.b.a$b */
    private static class b extends C0619c {
        private static final long serialVersionUID = 1;

        public b(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static String m6110i(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new C0619c("Empty OBJECT IDENTIFIER");
        }
        long m6103e = m6103e(byteBuffer);
        int min = (int) Math.min(m6103e / 40, 2L);
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(min));
        sb.append('.');
        sb.append(Long.toString(m6103e - (min * 40)));
        while (byteBuffer.hasRemaining()) {
            long m6103e2 = m6103e(byteBuffer);
            sb.append('.');
            sb.append(Long.toString(m6103e2));
        }
        return sb.toString();
    }

    /* renamed from: e */
    private static long m6103e(ByteBuffer byteBuffer) {
        long j = 0;
        if (byteBuffer.hasRemaining()) {
            while (byteBuffer.hasRemaining()) {
                if (j > 72057594037927935L) {
                    throw new C0619c("Base-128 number too large");
                }
                j = (j << 7) | (r2 & 127);
                if ((byteBuffer.get() & 255 & 128) == 0) {
                }
            }
            throw new C0619c("Truncated base-128 encoded input: missing terminating byte, with highest bit not set");
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static BigInteger m6106f(ByteBuffer byteBuffer) {
        return !byteBuffer.hasRemaining() ? BigInteger.ZERO : new BigInteger(C0644c.m6241a(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static int m6107g(ByteBuffer byteBuffer) {
        BigInteger m6106f = m6106f(byteBuffer);
        if (m6106f.compareTo(BigInteger.valueOf(-2147483648L)) < 0 || m6106f.compareTo(BigInteger.valueOf(2147483647L)) > 0) {
            throw new C0619c(String.format("INTEGER cannot be represented as int: %1$d (0x%1$x)", m6106f));
        }
        return m6106f.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static long m6109h(ByteBuffer byteBuffer) {
        BigInteger m6106f = m6106f(byteBuffer);
        if (m6106f.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0 || m6106f.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            throw new C0619c(String.format("INTEGER cannot be represented as long: %1$d (0x%1$x)", m6106f));
        }
        return m6106f.longValue();
    }

    /* renamed from: a */
    private static List<a> m6093a(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            InterfaceC0622f interfaceC0622f = (InterfaceC0622f) field.getAnnotation(InterfaceC0622f.class);
            if (interfaceC0622f != null) {
                if (Modifier.isStatic(field.getModifiers())) {
                    throw new C0619c(InterfaceC0622f.class.getName() + " used on a static field: " + cls.getName() + "." + field.getName());
                }
                try {
                    arrayList.add(new a(field, interfaceC0622f));
                } catch (C0619c e2) {
                    throw new C0619c("Invalid ASN.1 annotation on " + cls.getName() + "." + field.getName(), e2);
                }
            }
        }
        return arrayList;
    }

    /* compiled from: Asn1BerParser.java */
    /* renamed from: com.b.a.b.b.a$c */
    private static final class c {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

        private c() {
        }

        /* renamed from: a */
        public static void m6125a(Object obj, Field field, EnumC0626j enumC0626j, C0613a c0613a) {
            try {
                int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[enumC0626j.ordinal()];
                if (i == 4 || i == 5) {
                    if (!C0623g.class.equals(field.getType())) {
                        field.set(obj, C0612a.m6108g(c0613a, C0612a.m6096b(field)));
                        return;
                    } else {
                        field.set(obj, m6124a(enumC0626j, c0613a, field.getType()));
                        return;
                    }
                }
                field.set(obj, m6124a(enumC0626j, c0613a, field.getType()));
            } catch (ReflectiveOperationException e2) {
                throw new C0619c("Failed to set value of " + obj.getClass().getName() + "." + field.getName(), e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v42, types: [T, byte[]] */
        /* renamed from: a */
        public static <T> T m6124a(EnumC0626j enumC0626j, C0613a c0613a, Class<T> cls) {
            if (ByteBuffer.class.equals(cls)) {
                return (T) c0613a.m6114c();
            }
            if (byte[].class.equals(cls)) {
                ByteBuffer m6114c = c0613a.m6114c();
                if (!m6114c.hasRemaining()) {
                    return (T) EMPTY_BYTE_ARRAY;
                }
                ?? r0 = (T) new byte[m6114c.remaining()];
                m6114c.get((byte[]) r0);
                return r0;
            }
            if (C0623g.class.equals(cls)) {
                return (T) new C0623g(c0613a.m6113b());
            }
            ByteBuffer m6114c2 = c0613a.m6114c();
            int i = AnonymousClass2.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[enumC0626j.ordinal()];
            if (i == 1) {
                InterfaceC0618b interfaceC0618b = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
                if (interfaceC0618b != null && interfaceC0618b.m6143a() == EnumC0626j.CHOICE) {
                    return (T) C0612a.m6104e(c0613a, cls);
                }
            } else if (i != 2) {
                switch (i) {
                    case 6:
                        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls)) {
                            return (T) Integer.valueOf(C0612a.m6107g(m6114c2));
                        }
                        if (Long.TYPE.equals(cls) || Long.class.equals(cls)) {
                            return (T) Long.valueOf(C0612a.m6109h(m6114c2));
                        }
                        if (BigInteger.class.equals(cls)) {
                            return (T) C0612a.m6106f(m6114c2);
                        }
                        break;
                    case 7:
                        if (String.class.equals(cls)) {
                            return (T) C0612a.m6110i(m6114c2);
                        }
                        break;
                    case 8:
                    case 9:
                        if (String.class.equals(cls)) {
                            return (T) new String(C0644c.m6241a(m6114c2));
                        }
                        break;
                    case 10:
                        if (Boolean.TYPE.equals(cls)) {
                            if (m6114c2.remaining() != 1) {
                                throw new C0619c("Incorrect encoded size of boolean value: " + m6114c2.remaining());
                            }
                            return (T) Boolean.valueOf(m6114c2.get() != 0);
                        }
                        break;
                }
            } else {
                InterfaceC0618b interfaceC0618b2 = (InterfaceC0618b) C0627a.m6191a(cls, InterfaceC0618b.class);
                if (interfaceC0618b2 != null && interfaceC0618b2.m6143a() == EnumC0626j.SEQUENCE) {
                    return (T) C0612a.m6105f(c0613a, cls);
                }
            }
            throw new C0619c("Unsupported conversion: ASN.1 " + enumC0626j + " to " + cls.getName());
        }
    }
}
