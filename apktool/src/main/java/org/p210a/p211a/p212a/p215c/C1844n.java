package org.p210a.p211a.p212a.p215c;

import java.util.Iterator;

/* compiled from: Utils.java */
/* renamed from: org.a.a.a.c.n */
/* loaded from: classes.dex */
public class C1844n {
    /* renamed from: a */
    public static <T> String m13777a(Iterator<T> it, String str) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static <T> String m13778a(T[] tArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tArr.length; i++) {
            sb.append(tArr[i]);
            if (i < tArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m13776a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            if (c2 == ' ' && z) {
                sb.append((char) 183);
            } else if (c2 == '\t') {
                sb.append("\\t");
            } else if (c2 == '\n') {
                sb.append("\\n");
            } else if (c2 == '\r') {
                sb.append("\\r");
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }
}
