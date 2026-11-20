package org.p226d.p233b;

import com.p129f.p130a.p133c.C1157aj;
import java.util.HashMap;
import org.p226d.p269d.C2453g;

/* compiled from: VerificationError.java */
/* renamed from: org.d.b.i */
/* loaded from: classes.dex */
public class C2393i {

    /* renamed from: a */
    private static final HashMap<String, Integer> f12759a = C1157aj.m9935c();

    static {
        f12759a.put("generic-error", 1);
        f12759a.put("no-such-class", 2);
        f12759a.put("no-such-field", 3);
        f12759a.put("no-such-method", 4);
        f12759a.put("illegal-class-access", 5);
        f12759a.put("illegal-field-access", 6);
        f12759a.put("illegal-method-access", 7);
        f12759a.put("class-change-error", 8);
        f12759a.put("instantiation-error", 9);
    }

    /* renamed from: a */
    public static String m15152a(int i) {
        switch (i) {
            case 1:
                return "generic-error";
            case 2:
                return "no-such-class";
            case 3:
                return "no-such-field";
            case 4:
                return "no-such-method";
            case 5:
                return "illegal-class-access";
            case 6:
                return "illegal-field-access";
            case 7:
                return "illegal-method-access";
            case 8:
                return "class-change-error";
            case 9:
                return "instantiation-error";
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static int m15151a(String str) {
        Integer num = f12759a.get(str);
        if (num == null) {
            throw new C2453g("Invalid verification error: %s", str);
        }
        return num.intValue();
    }

    /* renamed from: b */
    public static boolean m15153b(int i) {
        return i > 0 && i < 10;
    }
}
