package ru.p294a;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* compiled from: ExtraFieldUtils.java */
/* renamed from: ru.a.d */
/* loaded from: classes.dex */
public class C2585d {

    /* renamed from: a */
    private static final Map<C2607z, Class<?>> f13424a = new ConcurrentHashMap();

    static {
        try {
            m16072a(Class.forName("ru.a.b"));
            try {
                m16072a(Class.forName("ru.a.g"));
                try {
                    m16072a(Class.forName("ru.a.k"));
                    try {
                        m16072a(Class.forName("ru.a.j"));
                        try {
                            m16072a(Class.forName("ru.a.o"));
                        } catch (ClassNotFoundException e2) {
                            throw new NoClassDefFoundError(e2.getMessage());
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new NoClassDefFoundError(e3.getMessage());
                    }
                } catch (ClassNotFoundException e4) {
                    throw new NoClassDefFoundError(e4.getMessage());
                }
            } catch (ClassNotFoundException e5) {
                throw new NoClassDefFoundError(e5.getMessage());
            }
        } catch (ClassNotFoundException e6) {
            throw new NoClassDefFoundError(e6.getMessage());
        }
    }

    /* renamed from: a */
    public static void m16072a(Class<?> cls) {
        try {
            f13424a.put(((InterfaceC2603v) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).mo16060a(), cls);
        } catch (ClassCastException e2) {
            throw new RuntimeException(new StringBuffer().append(cls).append(" doesn't implement ZipExtraField").toString());
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(new StringBuffer().append(cls).append("'s no-arg constructor is not public").toString());
        } catch (InstantiationException e4) {
            throw new RuntimeException(new StringBuffer().append(cls).append(" is not a concrete class").toString());
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(new StringBuffer().append(cls).append("'s no-arg constructor not found").toString());
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(new StringBuffer().append(new StringBuffer().append(cls).append("'s no-arg constructor threw an exception:").toString()).append(e6.getMessage()).toString());
        }
    }

    /* renamed from: a */
    public static InterfaceC2603v m16071a(C2607z c2607z) {
        Class<?> cls = f13424a.get(c2607z);
        if (cls != null) {
            try {
                return (InterfaceC2603v) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (NoSuchMethodException e2) {
                throw ((InstantiationException) new InstantiationException().initCause(e2));
            } catch (InvocationTargetException e3) {
                throw ((InstantiationException) new InstantiationException().initCause(e3.getTargetException()));
            }
        }
        C2594m c2594m = new C2594m();
        c2594m.m16093a(c2607z);
        return c2594m;
    }

    /* renamed from: a */
    public static InterfaceC2603v[] m16074a(byte[] bArr, boolean z, a aVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            C2607z c2607z = new C2607z(bArr, i);
            int m16242b = new C2607z(bArr, i + 2).m16242b();
            if (i + 4 + m16242b > bArr.length) {
                switch (aVar.m16076a()) {
                    case 0:
                        throw new ZipException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("bad extra field starting at ").append(i).toString()).append(".  Block length of ").toString()).append(m16242b).toString()).append(" bytes exceeds remaining data of ").toString()).append((bArr.length - i) - 4).toString()).append(" bytes.").toString());
                    case 1:
                        break;
                    case 2:
                        C2593l c2593l = new C2593l();
                        if (z) {
                            c2593l.mo16045a(bArr, i, bArr.length - i);
                        } else {
                            c2593l.mo16070b(bArr, i, bArr.length - i);
                        }
                        arrayList.add(c2593l);
                        break;
                    default:
                        throw new ZipException(new StringBuffer().append("unknown UnparseableExtraField key: ").append(aVar.m16076a()).toString());
                }
            } else {
                try {
                    InterfaceC2603v m16071a = m16071a(c2607z);
                    if (z || !(m16071a instanceof InterfaceC2584c)) {
                        m16071a.mo16045a(bArr, i + 4, m16242b);
                    } else {
                        ((InterfaceC2584c) m16071a).mo16070b(bArr, i + 4, m16242b);
                    }
                    arrayList.add(m16071a);
                    i = m16242b + 4 + i;
                } catch (IllegalAccessException | InstantiationException e2) {
                    throw new ZipException(e2.getMessage());
                }
            }
        }
        return (InterfaceC2603v[]) arrayList.toArray(new InterfaceC2603v[arrayList.size()]);
    }

    /* renamed from: a */
    public static byte[] m16073a(InterfaceC2603v[] interfaceC2603vArr) {
        boolean z = interfaceC2603vArr.length > 0 && (interfaceC2603vArr[interfaceC2603vArr.length + (-1)] instanceof C2593l);
        int length = z ? interfaceC2603vArr.length - 1 : interfaceC2603vArr.length;
        int i = length * 4;
        for (InterfaceC2603v interfaceC2603v : interfaceC2603vArr) {
            i += interfaceC2603v.mo16050f().m16242b();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(interfaceC2603vArr[i3].mo16060a().m16241a(), 0, bArr, i2, 2);
            System.arraycopy(interfaceC2603vArr[i3].mo16050f().m16241a(), 0, bArr, i2 + 2, 2);
            byte[] mo16049e = interfaceC2603vArr[i3].mo16049e();
            System.arraycopy(mo16049e, 0, bArr, i2 + 4, mo16049e.length);
            i2 += mo16049e.length + 4;
        }
        if (z) {
            byte[] mo16049e2 = interfaceC2603vArr[interfaceC2603vArr.length - 1].mo16049e();
            System.arraycopy(mo16049e2, 0, bArr, i2, mo16049e2.length);
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m16075b(InterfaceC2603v[] interfaceC2603vArr) {
        boolean z = interfaceC2603vArr.length > 0 && (interfaceC2603vArr[interfaceC2603vArr.length + (-1)] instanceof C2593l);
        int length = z ? interfaceC2603vArr.length - 1 : interfaceC2603vArr.length;
        int i = length * 4;
        for (InterfaceC2603v interfaceC2603v : interfaceC2603vArr) {
            i += interfaceC2603v.mo16048d().m16242b();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(interfaceC2603vArr[i3].mo16060a().m16241a(), 0, bArr, i2, 2);
            System.arraycopy(interfaceC2603vArr[i3].mo16048d().m16241a(), 0, bArr, i2 + 2, 2);
            byte[] mo16047c = interfaceC2603vArr[i3].mo16047c();
            System.arraycopy(mo16047c, 0, bArr, i2 + 4, mo16047c.length);
            i2 += mo16047c.length + 4;
        }
        if (z) {
            byte[] mo16047c2 = interfaceC2603vArr[interfaceC2603vArr.length - 1].mo16047c();
            System.arraycopy(mo16047c2, 0, bArr, i2, mo16047c2.length);
        }
        return bArr;
    }

    /* compiled from: ExtraFieldUtils.java */
    /* renamed from: ru.a.d$a */
    public static final class a {

        /* renamed from: a */
        public static final a f13425a = new a(0);

        /* renamed from: b */
        public static final a f13426b = new a(1);

        /* renamed from: c */
        public static final a f13427c = new a(2);

        /* renamed from: d */
        private final int f13428d;

        a(int i) {
            this.f13428d = i;
        }

        /* renamed from: a */
        public int m16076a() {
            return this.f13428d;
        }
    }
}
