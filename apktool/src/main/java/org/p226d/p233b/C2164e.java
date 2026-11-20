package org.p226d.p233b;

import com.p129f.p130a.p133c.AbstractC1205t;
import com.p129f.p130a.p133c.InterfaceC1195j;
import org.p226d.p269d.C2453g;

/* compiled from: MethodHandleType.java */
/* renamed from: org.d.b.e */
/* loaded from: classes.dex */
public class C2164e {

    /* renamed from: a */
    private static final InterfaceC1195j<Integer, String> f12115a = new AbstractC1205t.a().mo10126b(0, "static-put").mo10126b(1, "static-get").mo10126b(2, "instance-put").mo10126b(3, "instance-get").mo10126b(4, "invoke-static").mo10126b(5, "invoke-instance").mo10126b(6, "invoke-constructor").mo10126b(7, "invoke-direct").mo10126b(8, "invoke-interface").m10125a();

    /* renamed from: a */
    public static String m14859a(int i) {
        String str = f12115a.get(Integer.valueOf(i));
        if (str == null) {
            throw new a(i);
        }
        return str;
    }

    /* renamed from: a */
    public static int m14858a(String str) {
        Integer num = f12115a.mo9984a().get(str);
        if (num == null) {
            throw new C2453g("Invalid method handle type: %s", str);
        }
        return num.intValue();
    }

    /* compiled from: MethodHandleType.java */
    /* renamed from: org.d.b.e$a */
    public static class a extends C2453g {

        /* renamed from: a */
        private final int f12116a;

        public a(int i) {
            super("Invalid method handle type: %d", Integer.valueOf(i));
            this.f12116a = i;
        }
    }
}
