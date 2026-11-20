package org.p285i.p287b;

import java.util.HashMap;
import java.util.Map;

/* compiled from: MessageFormatter.java */
/* renamed from: org.i.b.c */
/* loaded from: classes.dex */
public final class C2561c {
    /* renamed from: a */
    static final Throwable m15959a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    /* renamed from: a */
    public static final C2559a m15960a(String str, Object[] objArr) {
        Throwable m15959a = m15959a(objArr);
        if (m15959a != null) {
            objArr = m15975b(objArr);
        }
        return m15961a(str, objArr, m15959a);
    }

    /* renamed from: b */
    private static Object[] m15975b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    /* renamed from: a */
    public static final C2559a m15961a(String str, Object[] objArr, Throwable th) {
        int i = 0;
        if (str == null) {
            return new C2559a(null, objArr, th);
        }
        if (objArr == null) {
            return new C2559a(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < objArr.length) {
                int indexOf = str.indexOf("{}", i3);
                if (indexOf == -1) {
                    if (i3 == 0) {
                        return new C2559a(str, objArr, th);
                    }
                    sb.append((CharSequence) str, i3, str.length());
                    return new C2559a(sb.toString(), objArr, th);
                }
                if (m15973a(str, indexOf)) {
                    if (!m15974b(str, indexOf)) {
                        i2--;
                        sb.append((CharSequence) str, i3, indexOf - 1);
                        sb.append('{');
                        i = indexOf + 1;
                    } else {
                        sb.append((CharSequence) str, i3, indexOf - 1);
                        m15963a(sb, objArr[i2], new HashMap());
                        i = indexOf + 2;
                    }
                } else {
                    sb.append((CharSequence) str, i3, indexOf);
                    m15963a(sb, objArr[i2], new HashMap());
                    i = indexOf + 2;
                }
                i2++;
            } else {
                sb.append((CharSequence) str, i3, str.length());
                return new C2559a(sb.toString(), objArr, th);
            }
        }
    }

    /* renamed from: a */
    static final boolean m15973a(String str, int i) {
        return i != 0 && str.charAt(i + (-1)) == '\\';
    }

    /* renamed from: b */
    static final boolean m15974b(String str, int i) {
        return i >= 2 && str.charAt(i + (-2)) == '\\';
    }

    /* renamed from: a */
    private static void m15963a(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            m15962a(sb, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            m15972a(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            m15964a(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            m15965a(sb, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            m15971a(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            m15968a(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            m15969a(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            m15967a(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            m15966a(sb, (double[]) obj);
        } else {
            m15970a(sb, (Object[]) obj, map);
        }
    }

    /* renamed from: a */
    private static void m15962a(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            C2567i.m15989a("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    /* renamed from: a */
    private static void m15970a(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m15963a(sb, objArr[i], map);
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15972a(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(zArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15964a(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) bArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15965a(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(cArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15971a(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) sArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15968a(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15969a(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(jArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15967a(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(fArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: a */
    private static void m15966a(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(dArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }
}
