package com.p140g.p152b.p153a.p154a;

import com.p140g.p141a.C1241c;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1287f;
import com.p140g.p141a.C1292g;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;

/* compiled from: Exprs.java */
/* renamed from: com.g.b.a.a.f */
/* loaded from: classes.dex */
public final class C1308f {
    /* renamed from: a */
    public static C1307e m10488a(C1241c c1241c) {
        return new C1307e(c1241c);
    }

    /* renamed from: a */
    public static C1307e m10486a(int i) {
        return new C1307e(new Integer(i));
    }

    /* renamed from: a */
    public static C1307e m10487a(long j) {
        return new C1307e(new Long(j));
    }

    /* renamed from: a */
    public static C1307e m10490a(String str) {
        return new C1307e(str);
    }

    /* renamed from: a */
    public static C1305c m10484a(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.ADD, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: b */
    public static C1305c m10505b(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.AND, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: c */
    public static C1304b m10511c(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1304b(abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: a */
    public static C1307e m10489a(Object obj) {
        return new C1307e(obj);
    }

    /* renamed from: a */
    public static C1306d m10485a(AbstractC1322t abstractC1322t, String str, String str2) {
        return new C1306d(abstractC1322t, str, str2);
    }

    /* renamed from: a */
    public static C1320r m10501a(AbstractC1322t abstractC1322t, String str) {
        return new C1320r(AbstractC1322t.e.CHECK_CAST, abstractC1322t, str);
    }

    /* renamed from: a */
    public static C1305c m10483a(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        return new C1305c(AbstractC1322t.e.DCMPG, abstractC1322t, abstractC1322t2, "D");
    }

    /* renamed from: b */
    public static C1305c m10504b(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        return new C1305c(AbstractC1322t.e.DCMPL, abstractC1322t, abstractC1322t2, "D");
    }

    /* renamed from: d */
    public static C1305c m10517d(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        if (str.equals("I")) {
            return new C1305c(AbstractC1322t.e.IDIV, abstractC1322t, abstractC1322t2, str);
        }
        if (str.equals("J")) {
            return new C1305c(AbstractC1322t.e.LDIV, abstractC1322t, abstractC1322t2, str);
        }
        if (str.equals("F")) {
            return new C1305c(AbstractC1322t.e.FDIV, abstractC1322t, abstractC1322t2, str);
        }
        if (str.equals("D")) {
            return new C1305c(AbstractC1322t.e.DDIV, abstractC1322t, abstractC1322t2, str);
        }
        throw new RuntimeException("type must set to one of I/J/F/D");
    }

    /* renamed from: e */
    public static C1305c m10522e(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.EQ, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: b */
    public static C1318p m10509b(String str) {
        return new C1318p(AbstractC1322t.e.EXCEPTION_REF, str, -1);
    }

    /* renamed from: c */
    public static C1305c m10512c(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        return new C1305c(AbstractC1322t.e.FCMPG, abstractC1322t, abstractC1322t2, "F");
    }

    /* renamed from: d */
    public static C1305c m10516d(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        return new C1305c(AbstractC1322t.e.FCMPL, abstractC1322t, abstractC1322t2, "F");
    }

    /* renamed from: a */
    public static C1309g m10491a(AbstractC1322t abstractC1322t, String str, String str2, String str3) {
        return new C1309g(abstractC1322t, str, str2, str3);
    }

    /* renamed from: f */
    public static C1305c m10523f(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.GE, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: g */
    public static C1305c m10524g(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.GT, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: b */
    public static C1320r m10510b(AbstractC1322t abstractC1322t, String str) {
        return new C1320r(AbstractC1322t.e.INSTANCE_OF, abstractC1322t, str);
    }

    /* renamed from: a */
    public static C1312j m10494a(AbstractC1322t[] abstractC1322tArr, String str, String str2, String[] strArr, String str3) {
        return new C1312j(AbstractC1322t.e.INVOKE_INTERFACE, abstractC1322tArr, str, str2, strArr, str3);
    }

    /* renamed from: a */
    public static C1312j m10495a(AbstractC1322t[] abstractC1322tArr, String[] strArr, String str) {
        return new C1312j(AbstractC1322t.e.INVOKE_NEW, abstractC1322tArr, str, "<init>", strArr, str);
    }

    /* renamed from: b */
    public static C1312j m10507b(AbstractC1322t[] abstractC1322tArr, String str, String str2, String[] strArr, String str3) {
        return new C1312j(AbstractC1322t.e.INVOKE_SPECIAL, abstractC1322tArr, str, str2, strArr, str3);
    }

    /* renamed from: c */
    public static C1312j m10513c(AbstractC1322t[] abstractC1322tArr, String str, String str2, String[] strArr, String str3) {
        return new C1312j(AbstractC1322t.e.INVOKE_STATIC, abstractC1322tArr, str, str2, strArr, str3);
    }

    /* renamed from: d */
    public static C1312j m10518d(AbstractC1322t[] abstractC1322tArr, String str, String str2, String[] strArr, String str3) {
        return new C1312j(AbstractC1322t.e.INVOKE_VIRTUAL, abstractC1322tArr, str, str2, strArr, str3);
    }

    /* renamed from: a */
    public static C1311i m10493a(AbstractC1322t[] abstractC1322tArr, String str, C1292g c1292g, C1287f c1287f, Object[] objArr) {
        return new C1311i(AbstractC1322t.e.INVOKE_CUSTOM, abstractC1322tArr, str, c1292g, c1287f, objArr);
    }

    /* renamed from: a */
    public static C1313k m10496a(AbstractC1322t[] abstractC1322tArr, C1292g c1292g, C1280e c1280e) {
        return new C1313k(AbstractC1322t.e.INVOKE_POLYMORPHIC, abstractC1322tArr, c1292g, c1280e);
    }

    /* renamed from: e */
    public static C1305c m10521e(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2) {
        return new C1305c(AbstractC1322t.e.LCMP, abstractC1322t, abstractC1322t2, "J");
    }

    /* renamed from: h */
    public static C1305c m10525h(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.LE, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: a */
    public static C1321s m10503a(AbstractC1322t abstractC1322t) {
        return new C1321s(AbstractC1322t.e.LENGTH, abstractC1322t, (String) null);
    }

    /* renamed from: b */
    public static C1314l m10508b(int i) {
        return new C1314l(i);
    }

    /* renamed from: i */
    public static C1305c m10526i(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.LT, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: j */
    public static C1305c m10527j(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.MUL, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: k */
    public static C1305c m10528k(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.NE, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: c */
    public static C1321s m10515c(AbstractC1322t abstractC1322t, String str) {
        return new C1321s(AbstractC1322t.e.NEG, abstractC1322t, str);
    }

    /* renamed from: c */
    public static C1315m m10514c(String str) {
        return new C1315m(str);
    }

    /* renamed from: a */
    public static C1320r m10502a(String str, AbstractC1322t abstractC1322t) {
        return new C1320r(AbstractC1322t.e.NEW_ARRAY, abstractC1322t, str);
    }

    /* renamed from: a */
    public static C1310h m10492a(String str, AbstractC1322t[] abstractC1322tArr) {
        return new C1310h(abstractC1322tArr, str);
    }

    /* renamed from: a */
    public static C1316n m10497a(String str, int i, AbstractC1322t[] abstractC1322tArr) {
        return new C1316n(str, i, abstractC1322tArr);
    }

    /* renamed from: d */
    public static C1321s m10520d(AbstractC1322t abstractC1322t, String str) {
        return new C1321s(AbstractC1322t.e.NOT, abstractC1322t, str);
    }

    /* renamed from: l */
    public static C1305c m10529l(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.OR, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: a */
    public static C1318p m10499a(String str, int i) {
        return new C1318p(AbstractC1322t.e.PARAMETER_REF, str, i);
    }

    /* renamed from: m */
    public static C1305c m10530m(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.REM, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: n */
    public static C1305c m10531n(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.SHL, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: o */
    public static C1305c m10532o(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.SHR, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: a */
    public static C1319q m10500a(String str, String str2, String str3) {
        return new C1319q(str, str2, str3);
    }

    /* renamed from: p */
    public static C1305c m10533p(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.SUB, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: d */
    public static C1318p m10519d(String str) {
        return new C1318p(AbstractC1322t.e.THIS_REF, str, -1);
    }

    /* renamed from: q */
    public static C1305c m10534q(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.USHR, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: r */
    public static C1305c m10535r(AbstractC1322t abstractC1322t, AbstractC1322t abstractC1322t2, String str) {
        return new C1305c(AbstractC1322t.e.XOR, abstractC1322t, abstractC1322t2, str);
    }

    /* renamed from: a */
    public static C1317o m10498a(AbstractC1322t... abstractC1322tArr) {
        return new C1317o(abstractC1322tArr);
    }

    /* renamed from: b */
    public static C1307e m10506b(Object obj) {
        return new C1307e(obj);
    }
}
