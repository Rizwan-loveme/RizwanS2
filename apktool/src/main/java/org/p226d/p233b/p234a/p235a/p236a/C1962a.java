package org.p226d.p233b.p234a.p235a.p236a;

import android.app.slice.SliceItem;
import com.p129f.p130a.p133c.AbstractC1205t;

/* compiled from: ReflectionUtils.java */
/* renamed from: org.d.b.a.a.a.a */
/* loaded from: classes.dex */
public class C1962a {

    /* renamed from: a */
    private static AbstractC1205t<String, String> f11419a = AbstractC1205t.m10121c().mo10126b("boolean", "Z").mo10126b(SliceItem.FORMAT_INT, "I").mo10126b(SliceItem.FORMAT_LONG, "J").mo10126b("double", "D").mo10126b("void", "V").mo10126b("float", "F").mo10126b("char", "C").mo10126b("short", "S").mo10126b("byte", "B").m10125a();

    /* renamed from: a */
    public static String m14208a(String str) {
        if (str.charAt(0) == '[') {
            return str.replace('.', '/');
        }
        if (f11419a.containsKey(str)) {
            return f11419a.get(str);
        }
        return 'L' + str.replace('.', '/') + ';';
    }
}
