package org.p217b.p218a.p222b.p223a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.p217b.p218a.p222b.C1888a;
import org.p217b.p218a.p222b.C1897f;

/* compiled from: ExceptionUtils.java */
/* renamed from: org.b.a.b.a.a */
/* loaded from: classes.dex */
public class C1889a {

    /* renamed from: a */
    static Class f11071a;

    /* renamed from: b */
    private static final Object f11072b = new Object();

    /* renamed from: c */
    private static String[] f11073c = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    /* renamed from: d */
    private static final Method f11074d;

    /* renamed from: e */
    private static final Method f11075e;

    static {
        Method method;
        Class cls;
        Class<?> cls2;
        Class cls3;
        Method method2 = null;
        try {
            if (f11071a == null) {
                cls3 = m13993b("java.lang.Throwable");
                f11071a = cls3;
            } else {
                cls3 = f11071a;
            }
            method = cls3.getMethod("getCause", null);
        } catch (Exception e2) {
            method = null;
        }
        f11074d = method;
        try {
            if (f11071a == null) {
                Class m13993b = m13993b("java.lang.Throwable");
                f11071a = m13993b;
                cls = m13993b;
            } else {
                cls = f11071a;
            }
            Class<?>[] clsArr = new Class[1];
            if (f11071a == null) {
                cls2 = m13993b("java.lang.Throwable");
                f11071a = cls2;
            } else {
                cls2 = f11071a;
            }
            clsArr[0] = cls2;
            method2 = cls.getMethod("initCause", clsArr);
        } catch (Exception e3) {
        }
        f11075e = method2;
    }

    /* renamed from: b */
    static Class m13993b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: a */
    private static String[] m13992a(List list) {
        return (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public static Throwable m13986a(Throwable th) {
        Throwable m13988a;
        synchronized (f11072b) {
            m13988a = m13988a(th, f11073c);
        }
        return m13988a;
    }

    /* renamed from: a */
    public static Throwable m13988a(Throwable th, String[] strArr) {
        String str;
        if (th == null) {
            return null;
        }
        Throwable m13994b = m13994b(th);
        if (m13994b == null) {
            if (strArr == null) {
                synchronized (f11072b) {
                    strArr = f11073c;
                }
            }
            for (int i = 0; i < strArr.length && ((str = strArr[i]) == null || (m13994b = m13987a(th, str)) == null); i++) {
            }
            if (m13994b == null) {
                return m13995b(th, "detail");
            }
            return m13994b;
        }
        return m13994b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private static Throwable m13994b(Throwable th) {
        if (th instanceof InterfaceC1890b) {
            return ((InterfaceC1890b) th).getCause();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        return null;
    }

    /* renamed from: a */
    private static Throwable m13987a(Throwable th, String str) {
        Method method;
        Class cls;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException e2) {
            method = null;
        } catch (SecurityException e3) {
            method = null;
        }
        if (method != null) {
            if (f11071a == null) {
                cls = m13993b("java.lang.Throwable");
                f11071a = cls;
            } else {
                cls = f11071a;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, C1888a.f11052a);
                } catch (IllegalAccessException e4) {
                } catch (IllegalArgumentException e5) {
                } catch (InvocationTargetException e6) {
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Throwable m13995b(Throwable th, String str) {
        Field field;
        Class cls;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException e2) {
            field = null;
        } catch (SecurityException e3) {
            field = null;
        }
        if (field != null) {
            if (f11071a == null) {
                cls = m13993b("java.lang.Throwable");
                f11071a = cls;
            } else {
                cls = f11071a;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException e4) {
                } catch (IllegalArgumentException e5) {
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m13990a() {
        return f11074d != null;
    }

    /* renamed from: a */
    public static void m13989a(List list, List list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        for (int i = size; i >= 0 && size2 >= 0; i--) {
            if (((String) list.get(i)).equals((String) list2.get(size2))) {
                list.remove(i);
            }
            size2--;
        }
    }

    /* renamed from: a */
    static String[] m13991a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, C1897f.f11107F);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return m13992a(arrayList);
    }
}
