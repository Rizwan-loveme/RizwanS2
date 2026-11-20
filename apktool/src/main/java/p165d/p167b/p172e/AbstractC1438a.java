package p165d.p167b.p172e;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Iterator;
import java.util.Set;

/* compiled from: AbstractAlgorithmConstraints.java */
/* renamed from: d.b.e.a */
/* loaded from: classes.dex */
public abstract class AbstractC1438a {

    /* renamed from: a */
    protected final C1439b f9320a;

    protected AbstractC1438a(C1439b c1439b) {
        this.f9320a = c1439b;
    }

    /* renamed from: a */
    static String[] m11312a(String str) {
        String[] strArr;
        String str2 = (String) AccessController.doPrivileged(new PrivilegedAction<String>(str) { // from class: d.b.e.a.1

            /* renamed from: a */
            private final String f9321a;

            {
                this.f9321a = str;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String run() {
                return Security.getProperty(this.f9321a);
            }
        });
        if (str2 == null || str2.isEmpty()) {
            strArr = null;
        } else {
            if (str2.length() >= 2 && str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                str2 = str2.substring(1, str2.length() - 1);
            }
            String[] split = str2.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            strArr = split;
        }
        if (strArr == null) {
            return new String[0];
        }
        return strArr;
    }

    /* renamed from: a */
    static boolean m11311a(String[] strArr, String str, C1439b c1439b) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("No algorithm name specified");
        }
        Set<String> set = null;
        for (String str2 : strArr) {
            if (str2 != null && !str2.isEmpty()) {
                if (str2.equalsIgnoreCase(str)) {
                    return false;
                }
                Set<String> m11316b = set == null ? c1439b.m11316b(str) : set;
                Iterator<String> it = m11316b.iterator();
                while (it.hasNext()) {
                    if (str2.equalsIgnoreCase(it.next())) {
                        return false;
                    }
                }
                set = m11316b;
            }
        }
        return true;
    }
}
