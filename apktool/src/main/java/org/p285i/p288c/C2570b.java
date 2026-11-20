package org.p285i.p288c;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.p285i.InterfaceC2553a;
import org.p285i.InterfaceC2558b;

/* compiled from: AndroidLoggerFactory.java */
/* renamed from: org.i.c.b */
/* loaded from: classes.dex */
class C2570b implements InterfaceC2553a {

    /* renamed from: a */
    private final ConcurrentMap<String, InterfaceC2558b> f13359a = new ConcurrentHashMap();

    C2570b() {
    }

    @Override // org.p285i.InterfaceC2553a
    /* renamed from: a */
    public InterfaceC2558b mo15926a(String str) {
        String m16018b = m16018b(str);
        InterfaceC2558b interfaceC2558b = this.f13359a.get(m16018b);
        if (interfaceC2558b == null) {
            C2569a c2569a = new C2569a(m16018b);
            InterfaceC2558b putIfAbsent = this.f13359a.putIfAbsent(m16018b, c2569a);
            return putIfAbsent == null ? c2569a : putIfAbsent;
        }
        return interfaceC2558b;
    }

    /* renamed from: b */
    static String m16018b(String str) {
        int i = 0;
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length > 23) {
            StringBuilder sb = new StringBuilder(26);
            int i2 = 0;
            do {
                int i3 = i;
                int indexOf = str.indexOf(46, i2);
                if (indexOf != -1) {
                    sb.append(str.charAt(i2));
                    if (indexOf - i2 > 1) {
                        sb.append('*');
                    }
                    sb.append('.');
                    i2 = indexOf + 1;
                    i = sb.length();
                } else {
                    int i4 = length - i2;
                    if (i3 == 0 || i4 + i3 > 23) {
                        return m16019c(str);
                    }
                    sb.append((CharSequence) str, i2, length);
                    return sb.toString();
                }
            } while (i <= 23);
            return m16019c(str);
        }
        return str;
    }

    /* renamed from: c */
    private static String m16019c(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1 && length - (lastIndexOf + 1) <= 23) {
            return str.substring(lastIndexOf + 1);
        }
        return String.valueOf('*') + str.substring((length - 23) + 1);
    }
}
