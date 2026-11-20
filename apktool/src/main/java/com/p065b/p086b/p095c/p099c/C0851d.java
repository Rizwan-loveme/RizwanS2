package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0918e;
import com.p065b.p086b.p103f.p104a.EnumC0915b;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0949c;
import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0961o;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import java.util.ArrayList;

/* compiled from: AnnotationUtils.java */
/* renamed from: com.b.b.c.c.d */
/* loaded from: classes.dex */
public final class C0851d {

    /* renamed from: a */
    private static final C0971y f5205a = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/AnnotationDefault;"));

    /* renamed from: b */
    private static final C0971y f5206b = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/EnclosingClass;"));

    /* renamed from: c */
    private static final C0971y f5207c = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/EnclosingMethod;"));

    /* renamed from: d */
    private static final C0971y f5208d = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/InnerClass;"));

    /* renamed from: e */
    private static final C0971y f5209e = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/MemberClasses;"));

    /* renamed from: f */
    private static final C0971y f5210f = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/Signature;"));

    /* renamed from: g */
    private static final C0971y f5211g = C0971y.m8089b(C0975c.m8118a("Ldalvik/annotation/Throws;"));

    /* renamed from: h */
    private static final C0970x f5212h = new C0970x("accessFlags");

    /* renamed from: i */
    private static final C0970x f5213i = new C0970x("name");

    /* renamed from: j */
    private static final C0970x f5214j = new C0970x("value");

    /* renamed from: a */
    public static C0914a m7299a(C0914a c0914a) {
        C0914a c0914a2 = new C0914a(f5205a, EnumC0915b.SYSTEM);
        c0914a2.m7817a(new C0918e(f5214j, new C0949c(c0914a)));
        c0914a2.mo6683e_();
        return c0914a2;
    }

    /* renamed from: a */
    public static C0914a m7303a(C0971y c0971y) {
        C0914a c0914a = new C0914a(f5206b, EnumC0915b.SYSTEM);
        c0914a.m7817a(new C0918e(f5214j, c0971y));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: a */
    public static C0914a m7300a(C0967u c0967u) {
        C0914a c0914a = new C0914a(f5207c, EnumC0915b.SYSTEM);
        c0914a.m7817a(new C0918e(f5214j, c0967u));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: a */
    public static C0914a m7302a(C0970x c0970x, int i) {
        C0914a c0914a = new C0914a(f5208d, EnumC0915b.SYSTEM);
        AbstractC0946aa abstractC0946aa = c0970x;
        if (c0970x == null) {
            abstractC0946aa = C0961o.f6158a;
        }
        c0914a.m7817a(new C0918e(f5213i, abstractC0946aa));
        c0914a.m7817a(new C0918e(f5212h, C0959m.m8060a(i)));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: a */
    public static C0914a m7304a(InterfaceC0977e interfaceC0977e) {
        C0950d m7306c = m7306c(interfaceC0977e);
        C0914a c0914a = new C0914a(f5209e, EnumC0915b.SYSTEM);
        c0914a.m7817a(new C0918e(f5214j, m7306c));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: a */
    public static C0914a m7301a(C0970x c0970x) {
        C0914a c0914a = new C0914a(f5210f, EnumC0915b.SYSTEM);
        String m8084j = c0970x.m8084j();
        int length = m8084j.length();
        ArrayList arrayList = new ArrayList(20);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (m8084j.charAt(i) == 'L') {
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    char charAt = m8084j.charAt(i2);
                    if (charAt == ';') {
                        i2++;
                        break;
                    }
                    if (charAt != '<') {
                        i2++;
                    }
                }
            } else {
                while (i2 < length && m8084j.charAt(i2) != 'L') {
                    i2++;
                }
            }
            arrayList.add(m8084j.substring(i, i2));
            i = i2;
        }
        int size = arrayList.size();
        C0950d.a aVar = new C0950d.a(size);
        for (int i3 = 0; i3 < size; i3++) {
            aVar.m8044a(i3, (AbstractC0945a) new C0970x((String) arrayList.get(i3)));
        }
        aVar.mo6683e_();
        c0914a.m7817a(new C0918e(f5214j, new C0950d(aVar)));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: b */
    public static C0914a m7305b(InterfaceC0977e interfaceC0977e) {
        C0950d m7306c = m7306c(interfaceC0977e);
        C0914a c0914a = new C0914a(f5211g, EnumC0915b.SYSTEM);
        c0914a.m7817a(new C0918e(f5214j, m7306c));
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: c */
    private static C0950d m7306c(InterfaceC0977e interfaceC0977e) {
        int mo6856f_ = interfaceC0977e.mo6856f_();
        C0950d.a aVar = new C0950d.a(mo6856f_);
        for (int i = 0; i < mo6856f_; i++) {
            aVar.m8044a(i, (AbstractC0945a) C0971y.m8089b(interfaceC0977e.mo6853a(i)));
        }
        aVar.mo6683e_();
        return new C0950d(aVar);
    }
}
