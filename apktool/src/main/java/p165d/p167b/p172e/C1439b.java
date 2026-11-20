package p165d.p167b.p172e;

import android.security.keystore.KeyProperties;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: AlgorithmDecomposer.java */
/* renamed from: d.b.e.b */
/* loaded from: classes.dex */
public class C1439b {

    /* renamed from: b */
    private static final Pattern f9323b = Pattern.compile("/");

    /* renamed from: a */
    private static final Pattern f9322a = Pattern.compile("with|and", 2);

    /* renamed from: c */
    private static Set<String> m11315c(String str) {
        String[] split = f9323b.split(str);
        HashSet hashSet = new HashSet();
        for (String str2 : split) {
            if (str2 != null && str2.length() != 0) {
                String[] split2 = f9322a.split(str2);
                for (String str3 : split2) {
                    if (str3 != null && str3.length() != 0) {
                        hashSet.add(str3);
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public Set<String> m11316b(String str) {
        if (str == null || str.length() == 0) {
            return new HashSet();
        }
        Set<String> m11315c = m11315c(str);
        if (m11315c.contains("SHA1") && !m11315c.contains(KeyProperties.DIGEST_SHA1)) {
            m11315c.add(KeyProperties.DIGEST_SHA1);
        }
        if (m11315c.contains(KeyProperties.DIGEST_SHA1) && !m11315c.contains("SHA1")) {
            m11315c.add("SHA1");
        }
        if (m11315c.contains("SHA224") && !m11315c.contains(KeyProperties.DIGEST_SHA224)) {
            m11315c.add(KeyProperties.DIGEST_SHA224);
        }
        if (m11315c.contains(KeyProperties.DIGEST_SHA224) && !m11315c.contains("SHA224")) {
            m11315c.add("SHA224");
        }
        if (m11315c.contains("SHA256") && !m11315c.contains(KeyProperties.DIGEST_SHA256)) {
            m11315c.add(KeyProperties.DIGEST_SHA256);
        }
        if (m11315c.contains(KeyProperties.DIGEST_SHA256) && !m11315c.contains("SHA256")) {
            m11315c.add("SHA256");
        }
        if (m11315c.contains("SHA384") && !m11315c.contains(KeyProperties.DIGEST_SHA384)) {
            m11315c.add(KeyProperties.DIGEST_SHA384);
        }
        if (m11315c.contains(KeyProperties.DIGEST_SHA384) && !m11315c.contains("SHA384")) {
            m11315c.add("SHA384");
        }
        if (m11315c.contains("SHA512") && !m11315c.contains(KeyProperties.DIGEST_SHA512)) {
            m11315c.add(KeyProperties.DIGEST_SHA512);
        }
        if (m11315c.contains(KeyProperties.DIGEST_SHA512) && !m11315c.contains("SHA512")) {
            m11315c.add("SHA512");
            return m11315c;
        }
        return m11315c;
    }

    /* renamed from: a */
    public static String m11314a(String str) {
        return str.replace("-", "");
    }
}
