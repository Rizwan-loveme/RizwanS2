package com.p129f.p130a.p131a;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Strings.java */
/* renamed from: com.f.a.a.u */
/* loaded from: classes.dex */
public final class C1126u {
    /* renamed from: a */
    public static boolean m9591a(@NullableDecl String str) {
        return C1119n.m9543a(str);
    }

    /* renamed from: a */
    public static String m9589a(String str, int i) {
        C1120o.m9547a(str);
        if (i <= 1) {
            C1120o.m9552a(i >= 0, "invalid count: %s", i);
            return i == 0 ? "" : str;
        }
        int length = str.length();
        long j = length * i;
        int i2 = (int) j;
        if (i2 != j) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
        }
        char[] cArr = new char[i2];
        str.getChars(0, length, cArr, 0);
        while (length < i2 - length) {
            System.arraycopy(cArr, 0, cArr, length, length);
            length <<= 1;
        }
        System.arraycopy(cArr, 0, cArr, length, i2 - length);
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m9590a(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = m9588a(objArr[i]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i2]);
            i3 = indexOf + 2;
            i2++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i2 < objArr.length) {
            sb.append(" [");
            int i4 = i2 + 1;
            sb.append(objArr[i2]);
            while (true) {
                int i5 = i4;
                if (i5 >= objArr.length) {
                    break;
                }
                sb.append(", ");
                i4 = i5 + 1;
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m9588a(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e2) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e2);
            return "<" + str + " threw " + e2.getClass().getName() + ">";
        }
    }
}
