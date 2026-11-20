package com.p140g.p141a.p143b;

import com.p140g.p141a.C1241c;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1292g;
import com.p140g.p141a.p142a.C1237a;
import com.p140g.p141a.p144c.C1243b;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1366g;
import com.p140g.p152b.p153a.EnumC1302a;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1304b;
import com.p140g.p152b.p153a.p154a.C1306d;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1309g;
import com.p140g.p152b.p153a.p154a.C1310h;
import com.p140g.p152b.p153a.p154a.C1311i;
import com.p140g.p152b.p153a.p154a.C1312j;
import com.p140g.p152b.p153a.p154a.C1313k;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p154a.C1315m;
import com.p140g.p152b.p153a.p154a.C1316n;
import com.p140g.p152b.p153a.p154a.C1319q;
import com.p140g.p152b.p153a.p154a.C1320r;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1326c;
import com.p140g.p152b.p153a.p155b.C1327d;
import com.p140g.p152b.p153a.p155b.C1329f;
import com.p140g.p152b.p153a.p155b.C1330g;
import com.p140g.p152b.p153a.p155b.C1336m;
import com.p140g.p152b.p153a.p155b.C1337n;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2522n;
import org.p271f.p272a.C2525q;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.InterfaceC2528t;

/* compiled from: IR2JConverter.java */
@SuppressWarnings("incomplete-switch")
/* renamed from: com.g.a.b.b */
/* loaded from: classes.dex */
public class C1240b implements InterfaceC2528t {

    /* renamed from: h */
    private boolean f8047h;

    public C1240b() {
        this.f8047h = false;
    }

    public C1240b(boolean z) {
        this.f8047h = false;
        this.f8047h = z;
    }

    /* renamed from: a */
    public void m10277a(C1323b c1323b, AbstractC2526r abstractC2526r) {
        m10270a(c1323b);
        m10276c(c1323b, abstractC2526r);
        m10273b(c1323b, abstractC2526r);
    }

    /* renamed from: a */
    private void m10270a(C1323b c1323b) {
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            if (abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
                ((C1329f) abstractC1333j).f8639d = new C2525q();
            }
        }
    }

    /* renamed from: b */
    private void m10273b(C1323b c1323b, AbstractC2526r abstractC2526r) {
        boolean z;
        for (C1366g c1366g : c1323b.f8629h) {
            for (AbstractC1333j b2 = c1366g.f8802a.m10559b(); b2 != null && b2 != c1366g.f8803b; b2 = b2.m10559b()) {
                if (b2.f8650n != AbstractC1333j.d.LABEL) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                for (int i = 0; i < c1366g.f8804c.length; i++) {
                    String str = c1366g.f8805d[i];
                    abstractC2526r.mo15684a((C2525q) c1366g.f8802a.f8639d, (C2525q) c1366g.f8803b.f8639d, (C2525q) c1366g.f8804c[i].f8639d, str == null ? (String) null : m10264a(str));
                }
            }
        }
    }

    /* renamed from: a */
    static String m10264a(String str) {
        return C2529u.m15888a(str).m15900d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private void m10276c(C1323b c1323b, AbstractC2526r abstractC2526r) {
        int i;
        int intValue;
        boolean z;
        String str;
        String str2;
        int i2;
        String stringBuffer;
        int i3;
        int i4;
        String stringBuffer2;
        C1237a c1237a = new C1237a(abstractC2526r);
        int i5 = 0;
        Iterator<C1314l> it = c1323b.f8624c.iterator();
        while (it.hasNext()) {
            i5 = Math.max(i5, it.next().f8546a);
        }
        HashMap hashMap = new HashMap();
        int i6 = i5;
        for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
            AbstractC1333j.d dVar = abstractC1333j.f8650n;
            if (dVar == AbstractC1333j.d.LABEL) {
                C1329f c1329f = (C1329f) abstractC1333j;
                C2525q c2525q = (C2525q) c1329f.f8639d;
                c1237a.mo15747a(c2525q);
                if (c1329f.f8637b >= 0) {
                    c1237a.mo15752b(c1329f.f8637b, c2525q);
                }
            } else if (dVar == AbstractC1333j.d.ASSIGN) {
                AbstractC1333j.c cVar = (AbstractC1333j.c) abstractC1333j;
                AbstractC1322t abstractC1322t = cVar.f8652a;
                AbstractC1322t abstractC1322t2 = cVar.f8653b;
                AbstractC1322t.e eVar = abstractC1322t.f8563h;
                if (eVar == AbstractC1322t.e.LOCAL) {
                    int i7 = ((C1314l) abstractC1322t).f8546a;
                    boolean z2 = false;
                    if (abstractC1322t2.f8563h == AbstractC1322t.e.LOCAL && i7 == ((C1314l) abstractC1322t2).f8546a) {
                        z2 = true;
                    } else if (abstractC1322t.f8561f.charAt(0) == 'I') {
                        if (abstractC1322t2.f8563h == AbstractC1322t.e.ADD) {
                            if (m10275b(abstractC1322t2.mo10545h(), i7) && abstractC1322t2.mo10546i().f8563h == AbstractC1322t.e.CONSTANT) {
                                int intValue2 = ((Integer) ((C1307e) abstractC1322t2.mo10546i()).f8534b).intValue();
                                if (intValue2 < -32768 || intValue2 > 32767) {
                                    z = false;
                                } else {
                                    c1237a.mo15649c(i7, intValue2);
                                    z = true;
                                }
                                z2 = z;
                            } else if (m10275b(abstractC1322t2.mo10546i(), i7) && abstractC1322t2.mo10545h().f8563h == AbstractC1322t.e.CONSTANT && (intValue = ((Integer) ((C1307e) abstractC1322t2.mo10545h()).f8534b).intValue()) >= -32768 && intValue <= 32767) {
                                c1237a.mo15649c(i7, intValue);
                                z2 = true;
                            }
                        } else if (abstractC1322t2.f8563h == AbstractC1322t.e.SUB && m10275b(abstractC1322t2.mo10545h(), i7) && abstractC1322t2.mo10546i().f8563h == AbstractC1322t.e.CONSTANT && (i = -((Integer) ((C1307e) abstractC1322t2.mo10546i()).f8534b).intValue()) >= -32768 && i <= 32767) {
                            c1237a.mo15649c(i7, i);
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        m10268a(abstractC1322t2, c1237a);
                        if (i7 >= 0) {
                            c1237a.mo15648b(m10262a(abstractC1322t, 54), i7);
                        } else if (!abstractC1322t.f8561f.equals("V")) {
                            switch (abstractC1322t.f8561f.charAt(0)) {
                                case 'D':
                                case 'J':
                                    c1237a.mo15740a(88);
                                    break;
                                default:
                                    c1237a.mo15740a(87);
                                    break;
                            }
                        }
                    }
                } else if (eVar == AbstractC1322t.e.STATIC_FIELD) {
                    C1319q c1319q = (C1319q) abstractC1322t;
                    m10268a(abstractC1322t2, c1237a);
                    m10271a(abstractC1322t2.f8561f, c1319q.f8556c, c1237a);
                    c1237a.mo15681a(179, m10264a(c1319q.f8555b), c1319q.f8554a, c1319q.f8556c);
                } else if (eVar == AbstractC1322t.e.FIELD) {
                    C1309g c1309g = (C1309g) abstractC1322t;
                    m10268a(c1309g.f8564d, c1237a);
                    m10268a(abstractC1322t2, c1237a);
                    m10271a(abstractC1322t2.f8561f, c1309g.f8537c, c1237a);
                    c1237a.mo15681a(181, m10264a(c1309g.f8536b), c1309g.f8535a, c1309g.f8537c);
                } else if (eVar == AbstractC1322t.e.ARRAY) {
                    C1304b c1304b = (C1304b) abstractC1322t;
                    m10268a(c1304b.f8565b, c1237a);
                    m10268a(c1304b.f8566c, c1237a);
                    m10268a(abstractC1322t2, c1237a);
                    String str3 = c1304b.f8565b.f8561f;
                    String str4 = c1304b.f8561f;
                    if (str3.charAt(0) == '[') {
                        String substring = str3.substring(1);
                        m10271a(abstractC1322t2.f8561f, substring, c1237a);
                        c1237a.mo15740a(m10263a(substring, 79));
                    } else {
                        c1237a.mo15740a(m10263a(str4, 79));
                    }
                }
            } else if (dVar == AbstractC1333j.d.IDENTITY) {
                AbstractC1333j.c cVar2 = (AbstractC1333j.c) abstractC1333j;
                if (cVar2.f8653b.f8563h == AbstractC1322t.e.EXCEPTION_REF) {
                    int i8 = ((C1314l) cVar2.f8652a).f8546a;
                    if (i8 >= 0) {
                        c1237a.mo15648b(58, i8);
                    } else {
                        c1237a.mo15740a(87);
                    }
                }
            } else if (dVar == AbstractC1333j.d.FILL_ARRAY_DATA) {
                AbstractC1333j.c cVar3 = (AbstractC1333j.c) abstractC1333j;
                if (cVar3.mo10564e().f8563h == AbstractC1322t.e.CONSTANT) {
                    Object obj = ((C1307e) cVar3.mo10564e()).f8534b;
                    int length = Array.getLength(obj);
                    String str5 = cVar3.mo10563d().f8561f;
                    if (str5.charAt(0) == '[') {
                        str = str5.substring(1);
                    } else {
                        str = "I";
                    }
                    int m10263a = m10263a(str, 79);
                    m10268a(cVar3.mo10563d(), c1237a);
                    for (int i9 = 0; i9 < length; i9++) {
                        c1237a.mo15740a(89);
                        c1237a.mo10229a(new Integer(i9));
                        c1237a.mo10229a(Array.get(obj, i9));
                        c1237a.mo15740a(m10263a);
                    }
                    c1237a.mo15740a(87);
                } else {
                    C1310h c1310h = (C1310h) cVar3.mo10564e();
                    int length2 = c1310h.f8567i.length;
                    String str6 = cVar3.mo10563d().f8561f;
                    if (str6.charAt(0) == '[') {
                        str2 = str6.substring(1);
                    } else {
                        str2 = "I";
                    }
                    int m10263a2 = m10263a(str2, 79);
                    m10268a(cVar3.mo10563d(), c1237a);
                    for (int i10 = 0; i10 < length2; i10++) {
                        c1237a.mo15740a(89);
                        c1237a.mo10229a(new Integer(i10));
                        m10268a(c1310h.f8567i[i10], c1237a);
                        c1237a.mo15740a(m10263a2);
                    }
                    c1237a.mo15740a(87);
                }
            } else if (dVar == AbstractC1333j.d.GOTO) {
                c1237a.mo15743a(167, (C2525q) ((C1326c) abstractC1333j).f8634a.f8639d);
            } else if (dVar == AbstractC1333j.d.IF) {
                m10269a((C1327d) abstractC1333j, c1237a);
            } else if (dVar == AbstractC1333j.d.LOCK) {
                AbstractC1322t abstractC1322t3 = ((C1337n) abstractC1333j).f8651d;
                m10268a(abstractC1322t3, c1237a);
                if (this.f8047h) {
                    AbstractC1322t.e eVar2 = abstractC1322t3.f8563h;
                    if (eVar2 == AbstractC1322t.e.LOCAL || eVar2 == AbstractC1322t.e.CONSTANT) {
                        if (abstractC1322t3.f8563h == AbstractC1322t.e.LOCAL) {
                            stringBuffer = new StringBuffer().append("L").append(((C1314l) abstractC1322t3).f8546a).toString();
                        } else {
                            stringBuffer = new StringBuffer().append("C").append(((C1307e) abstractC1322t3).f8534b).toString();
                        }
                        Integer num = (Integer) hashMap.get(stringBuffer);
                        if (num != null) {
                            i3 = num.intValue();
                            i4 = i6;
                        } else {
                            int i11 = i6 + 1;
                            i3 = i11;
                            i4 = i11;
                        }
                        c1237a.mo15740a(89);
                        c1237a.mo15648b(m10262a(abstractC1322t3, 54), i3);
                        hashMap.put(stringBuffer, new Integer(i3));
                        i2 = i4;
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    i2 = i6;
                }
                c1237a.mo15740a(194);
                i6 = i2;
            } else if (dVar == AbstractC1333j.d.UNLOCK) {
                AbstractC1322t abstractC1322t4 = ((C1337n) abstractC1333j).f8651d;
                if (this.f8047h) {
                    AbstractC1322t.e eVar3 = abstractC1322t4.f8563h;
                    if (eVar3 == AbstractC1322t.e.LOCAL || eVar3 == AbstractC1322t.e.CONSTANT) {
                        if (abstractC1322t4.f8563h == AbstractC1322t.e.LOCAL) {
                            stringBuffer2 = new StringBuffer().append("L").append(((C1314l) abstractC1322t4).f8546a).toString();
                        } else {
                            stringBuffer2 = new StringBuffer().append("C").append(((C1307e) abstractC1322t4).f8534b).toString();
                        }
                        Integer num2 = (Integer) hashMap.get(stringBuffer2);
                        if (num2 != null) {
                            c1237a.mo15648b(m10262a(abstractC1322t4, 21), num2.intValue());
                        } else {
                            m10268a(abstractC1322t4, c1237a);
                        }
                    } else {
                        m10268a(abstractC1322t4, c1237a);
                    }
                } else {
                    m10268a(abstractC1322t4, c1237a);
                }
                c1237a.mo15740a(195);
            } else if (dVar == AbstractC1333j.d.NOP) {
                continue;
            } else if (dVar == AbstractC1333j.d.RETURN) {
                AbstractC1322t abstractC1322t5 = ((C1337n) abstractC1333j).f8651d;
                m10268a(abstractC1322t5, c1237a);
                m10271a(abstractC1322t5.f8561f, c1323b.f8627f, c1237a);
                c1237a.mo15740a(m10262a(abstractC1322t5, 172));
            } else if (dVar == AbstractC1333j.d.RETURN_VOID) {
                c1237a.mo15740a(177);
            } else if (dVar == AbstractC1333j.d.LOOKUP_SWITCH) {
                C1330g c1330g = (C1330g) abstractC1333j;
                m10268a(c1330g.f8651d, c1237a);
                C2525q[] c2525qArr = new C2525q[c1330g.f8632a.length];
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < c2525qArr.length) {
                        c2525qArr[i13] = (C2525q) c1330g.f8632a[i13].f8639d;
                        i12 = i13 + 1;
                    } else {
                        c1237a.mo15748a((C2525q) c1330g.f8633b.f8639d, c1330g.f8640c, c2525qArr);
                    }
                }
            } else if (dVar == AbstractC1333j.d.TABLE_SWITCH) {
                C1336m c1336m = (C1336m) abstractC1333j;
                m10268a(c1336m.f8651d, c1237a);
                C2525q[] c2525qArr2 = new C2525q[c1336m.f8632a.length];
                int i14 = 0;
                while (true) {
                    int i15 = i14;
                    if (i15 < c2525qArr2.length) {
                        c2525qArr2[i15] = (C2525q) c1336m.f8632a[i15].f8639d;
                        i14 = i15 + 1;
                    } else {
                        c1237a.mo15742a(c1336m.f8680c, (c1336m.f8680c + c2525qArr2.length) - 1, (C2525q) c1336m.f8633b.f8639d, c2525qArr2);
                    }
                }
            } else if (dVar == AbstractC1333j.d.THROW) {
                m10268a(((C1337n) abstractC1333j).f8651d, c1237a);
                c1237a.mo15740a(191);
            } else if (dVar == AbstractC1333j.d.VOID_INVOKE) {
                AbstractC1322t mo10561c = abstractC1333j.mo10561c();
                m10268a(mo10561c, c1237a);
                String str7 = mo10561c.f8561f;
                if (mo10561c.f8563h == AbstractC1322t.e.INVOKE_NEW) {
                    c1237a.mo15740a(87);
                } else if (!"V".equals(str7)) {
                    switch (str7.charAt(0)) {
                        case 'D':
                        case 'J':
                            c1237a.mo15740a(88);
                            break;
                        default:
                            c1237a.mo15740a(87);
                            break;
                    }
                }
            } else {
                throw new RuntimeException(new StringBuffer().append("not support st: ").append(abstractC1333j.f8650n).toString());
            }
        }
    }

    /* renamed from: b */
    private static boolean m10275b(AbstractC1322t abstractC1322t, int i) {
        return abstractC1322t.f8563h == AbstractC1322t.e.LOCAL && ((C1314l) abstractC1322t).f8546a == i;
    }

    /* renamed from: a */
    private static void m10271a(String str, String str2, AbstractC2526r abstractC2526r) {
        switch (str2.charAt(0)) {
            case 'B':
                switch (str.charAt(0)) {
                    case 'C':
                    case 'I':
                    case 'S':
                        abstractC2526r.mo15740a(145);
                        break;
                }
            case 'C':
                switch (str.charAt(0)) {
                    case 'I':
                        abstractC2526r.mo15740a(146);
                        break;
                }
            case 'S':
                switch (str.charAt(0)) {
                    case 'C':
                    case 'I':
                        abstractC2526r.mo15740a(147);
                        break;
                }
        }
    }

    /* renamed from: a */
    static boolean m10272a(AbstractC1322t abstractC1322t) {
        if (abstractC1322t.f8563h != AbstractC1322t.e.CONSTANT) {
            return false;
        }
        Object obj = ((C1307e) abstractC1322t).f8534b;
        Integer num = 0;
        return num.equals(obj) || C1307e.f8533a.equals(obj);
    }

    /* renamed from: a */
    private void m10269a(C1327d c1327d, AbstractC2526r abstractC2526r) {
        C2525q c2525q = (C2525q) c1327d.f8635a.f8639d;
        AbstractC1322t abstractC1322t = c1327d.f8651d;
        AbstractC1322t mo10545h = abstractC1322t.mo10545h();
        AbstractC1322t mo10546i = abstractC1322t.mo10546i();
        switch (mo10545h.f8561f.charAt(0)) {
            case 'L':
            case '[':
                if (m10272a(mo10545h) || m10272a(mo10546i)) {
                    if (m10272a(mo10546i)) {
                        m10268a(mo10545h, abstractC2526r);
                    } else {
                        m10268a(mo10546i, abstractC2526r);
                    }
                    abstractC2526r.mo15743a(abstractC1322t.f8563h == AbstractC1322t.e.EQ ? 198 : 199, c2525q);
                    break;
                } else {
                    m10268a(mo10545h, abstractC2526r);
                    m10268a(mo10546i, abstractC2526r);
                    abstractC2526r.mo15743a(abstractC1322t.f8563h == AbstractC1322t.e.EQ ? 165 : 166, c2525q);
                    break;
                }
            default:
                if (m10272a(mo10545h) || m10272a(mo10546i)) {
                    if (m10272a(mo10546i)) {
                        m10268a(mo10545h, abstractC2526r);
                    } else {
                        m10268a(mo10546i, abstractC2526r);
                    }
                    AbstractC1322t.e eVar = abstractC1322t.f8563h;
                    if (eVar == AbstractC1322t.e.NE) {
                        abstractC2526r.mo15743a(154, c2525q);
                        break;
                    } else if (eVar == AbstractC1322t.e.EQ) {
                        abstractC2526r.mo15743a(153, c2525q);
                        break;
                    } else if (eVar == AbstractC1322t.e.GE) {
                        abstractC2526r.mo15743a(156, c2525q);
                        break;
                    } else if (eVar == AbstractC1322t.e.GT) {
                        abstractC2526r.mo15743a(157, c2525q);
                        break;
                    } else if (eVar == AbstractC1322t.e.LE) {
                        abstractC2526r.mo15743a(158, c2525q);
                        break;
                    } else if (eVar == AbstractC1322t.e.LT) {
                        abstractC2526r.mo15743a(155, c2525q);
                        break;
                    }
                } else {
                    m10268a(mo10545h, abstractC2526r);
                    m10268a(mo10546i, abstractC2526r);
                    AbstractC1322t.e eVar2 = abstractC1322t.f8563h;
                    if (eVar2 == AbstractC1322t.e.NE) {
                        abstractC2526r.mo15743a(160, c2525q);
                        break;
                    } else if (eVar2 == AbstractC1322t.e.EQ) {
                        abstractC2526r.mo15743a(159, c2525q);
                        break;
                    } else if (eVar2 == AbstractC1322t.e.GE) {
                        abstractC2526r.mo15743a(162, c2525q);
                        break;
                    } else if (eVar2 == AbstractC1322t.e.GT) {
                        abstractC2526r.mo15743a(163, c2525q);
                        break;
                    } else if (eVar2 == AbstractC1322t.e.LE) {
                        abstractC2526r.mo15743a(164, c2525q);
                        break;
                    } else if (eVar2 == AbstractC1322t.e.LT) {
                        abstractC2526r.mo15743a(161, c2525q);
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: a */
    static int m10262a(AbstractC1322t abstractC1322t, int i) {
        return m10263a(abstractC1322t.f8561f, i);
    }

    /* renamed from: a */
    static int m10263a(String str, int i) {
        switch (str.charAt(0)) {
            case 'B':
                return C2529u.f13276d.m15897a(i);
            case 'C':
                return C2529u.f13275c.m15897a(i);
            case 'D':
                return C2529u.f13281i.m15897a(i);
            case 'F':
                return C2529u.f13279g.m15897a(i);
            case 'I':
                return C2529u.f13278f.m15897a(i);
            case 'J':
                return C2529u.f13280h.m15897a(i);
            case 'L':
            case '[':
                return C2529u.m15888a("La;").m15897a(i);
            case 'S':
                return C2529u.f13277e.m15897a(i);
            case 'Z':
                return C2529u.f13274b.m15897a(i);
            default:
                return C2529u.f13278f.m15897a(i);
        }
    }

    /* renamed from: a */
    private static void m10268a(AbstractC1322t abstractC1322t, AbstractC2526r abstractC2526r) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a == EnumC1302a.E0) {
            AbstractC1322t.e eVar = abstractC1322t.f8563h;
            if (eVar == AbstractC1322t.e.LOCAL) {
                abstractC2526r.mo15648b(m10262a(abstractC1322t, 21), ((C1314l) abstractC1322t).f8546a);
                return;
            }
            if (eVar == AbstractC1322t.e.CONSTANT) {
                C1307e c1307e = (C1307e) abstractC1322t;
                if (c1307e.f8534b.equals(C1307e.f8533a)) {
                    abstractC2526r.mo15740a(1);
                    return;
                } else if (c1307e.f8534b instanceof C1241c) {
                    abstractC2526r.mo10229a(C2529u.m15888a(((C1241c) c1307e.f8534b).f8048a));
                    return;
                } else {
                    abstractC2526r.mo10229a(c1307e.f8534b);
                    return;
                }
            }
            if (eVar == AbstractC1322t.e.NEW) {
                abstractC2526r.mo15680a(187, m10264a(((C1315m) abstractC1322t).f8549a));
                return;
            } else {
                if (eVar == AbstractC1322t.e.STATIC_FIELD) {
                    C1319q c1319q = (C1319q) abstractC1322t;
                    abstractC2526r.mo15681a(178, m10264a(c1319q.f8555b), c1319q.f8554a, c1319q.f8556c);
                    return;
                }
                return;
            }
        }
        if (enumC1302a == EnumC1302a.E1) {
            m10265a((AbstractC1322t.b) abstractC1322t, abstractC2526r);
        } else if (enumC1302a == EnumC1302a.E2) {
            m10266a((AbstractC1322t.c) abstractC1322t, abstractC2526r);
        } else if (enumC1302a == EnumC1302a.En) {
            m10267a((AbstractC1322t.d) abstractC1322t, abstractC2526r);
        }
    }

    /* renamed from: a */
    private static void m10267a(AbstractC1322t.d dVar, AbstractC2526r abstractC2526r) {
        int i;
        int i2;
        int i3 = 79;
        int i4 = 1;
        int i5 = 0;
        if (dVar.f8563h == AbstractC1322t.e.FILLED_ARRAY) {
            C1310h c1310h = (C1310h) dVar;
            m10265a((AbstractC1322t.b) C1308f.m10502a(c1310h.f8538a, C1308f.m10486a(c1310h.f8567i.length)), abstractC2526r);
            String str = c1310h.f8561f;
            String str2 = (String) null;
            if (str.charAt(0) == '[') {
                str2 = str.substring(1);
                i3 = m10263a(str2, 79);
            }
            while (i5 < c1310h.f8567i.length) {
                if (c1310h.f8567i[i5] != null) {
                    abstractC2526r.mo15740a(89);
                    abstractC2526r.mo10229a(new Integer(i5));
                    m10268a(c1310h.f8567i[i5], abstractC2526r);
                    String str3 = c1310h.f8567i[i5].f8561f;
                    if (str2 != null) {
                        m10271a(str3, str2, abstractC2526r);
                    }
                    abstractC2526r.mo15740a(i3);
                }
                i5++;
            }
            return;
        }
        AbstractC1322t.e eVar = dVar.f8563h;
        if (eVar == AbstractC1322t.e.NEW_MUTI_ARRAY) {
            for (AbstractC1322t abstractC1322t : dVar.f8567i) {
                m10268a(abstractC1322t, abstractC2526r);
            }
            C1316n c1316n = (C1316n) dVar;
            StringBuilder sb = new StringBuilder();
            while (i5 < c1316n.f8551b) {
                sb.append('[');
                i5++;
            }
            sb.append(c1316n.f8550a);
            abstractC2526r.mo15687b(sb.toString(), dVar.f8567i.length);
            return;
        }
        if (eVar == AbstractC1322t.e.INVOKE_NEW) {
            abstractC2526r.mo15680a(187, m10264a(((C1312j) dVar).m10536c()));
            abstractC2526r.mo15740a(89);
        } else if (eVar != AbstractC1322t.e.INVOKE_INTERFACE && eVar != AbstractC1322t.e.INVOKE_SPECIAL && eVar != AbstractC1322t.e.INVOKE_STATIC && eVar != AbstractC1322t.e.INVOKE_VIRTUAL) {
            if (eVar == AbstractC1322t.e.INVOKE_CUSTOM) {
                C1311i c1311i = (C1311i) dVar;
                String[] m10470a = c1311i.mo10479l_().m10470a();
                AbstractC1322t[] j = c1311i.mo10547j();
                if (m10470a.length == j.length) {
                    while (i5 < j.length) {
                        AbstractC1322t abstractC1322t2 = j[i5];
                        m10268a(abstractC1322t2, abstractC2526r);
                        m10271a(abstractC1322t2.f8561f, m10470a[i5], abstractC2526r);
                        i5++;
                    }
                } else if (m10470a.length + 1 == j.length) {
                    m10268a(j[0], abstractC2526r);
                    while (i4 < j.length) {
                        AbstractC1322t abstractC1322t3 = j[i4];
                        m10268a(abstractC1322t3, abstractC2526r);
                        m10271a(abstractC1322t3.f8561f, m10470a[i4 - 1], abstractC2526r);
                        i4++;
                    }
                } else {
                    throw new RuntimeException();
                }
                abstractC2526r.mo15683a(c1311i.f8539a, c1311i.f8540b.m10472c(), (C2522n) C1243b.m10283a(c1311i.f8541c), C1243b.m10299a(c1311i.f8542d));
                return;
            }
            if (eVar == AbstractC1322t.e.INVOKE_POLYMORPHIC) {
                C1313k c1313k = (C1313k) dVar;
                C1280e c1280e = c1313k.f8545b;
                String[] m10470a2 = c1313k.mo10479l_().m10470a();
                AbstractC1322t[] j2 = c1313k.mo10547j();
                m10268a(j2[0], abstractC2526r);
                while (i4 < j2.length) {
                    AbstractC1322t abstractC1322t4 = j2[i4];
                    m10268a(abstractC1322t4, abstractC2526r);
                    m10271a(abstractC1322t4.f8561f, m10470a2[i4 - 1], abstractC2526r);
                    i4++;
                }
                abstractC2526r.mo15682a(182, m10264a(c1280e.m10399d()), c1280e.m10398c(), c1313k.mo10479l_().m10472c(), false);
                return;
            }
            return;
        }
        C1312j c1312j = (C1312j) dVar;
        if (dVar.f8563h == AbstractC1322t.e.INVOKE_STATIC || dVar.f8563h == AbstractC1322t.e.INVOKE_NEW) {
            i = 0;
        } else {
            m10268a(dVar.f8567i[0], abstractC2526r);
            i = 1;
        }
        while (i < dVar.f8567i.length) {
            AbstractC1322t abstractC1322t5 = dVar.f8567i[i];
            m10268a(abstractC1322t5, abstractC2526r);
            m10271a(abstractC1322t5.f8561f, c1312j.m10539f()[i5], abstractC2526r);
            i++;
            i5++;
        }
        AbstractC1322t.e eVar2 = dVar.f8563h;
        if (eVar2 == AbstractC1322t.e.INVOKE_VIRTUAL) {
            i2 = 182;
        } else if (eVar2 == AbstractC1322t.e.INVOKE_INTERFACE) {
            i2 = 185;
        } else if (eVar2 == AbstractC1322t.e.INVOKE_NEW || eVar2 == AbstractC1322t.e.INVOKE_SPECIAL) {
            i2 = 183;
        } else if (eVar2 == AbstractC1322t.e.INVOKE_STATIC) {
            i2 = 184;
        } else {
            i2 = -1;
        }
        C1292g mo10479l_ = c1312j.mo10479l_();
        abstractC2526r.mo15686b(i2, m10264a(c1312j.m10536c()), c1312j.m10538e(), (c1312j.f8563h == AbstractC1322t.e.INVOKE_NEW ? new C1292g(mo10479l_.m10470a(), "V") : mo10479l_).m10472c());
    }

    /* renamed from: a */
    private static void m10265a(AbstractC1322t.b bVar, AbstractC2526r abstractC2526r) {
        m10268a(bVar.mo10544g(), abstractC2526r);
        AbstractC1322t.e eVar = bVar.f8563h;
        if (eVar == AbstractC1322t.e.STATIC_FIELD) {
            C1309g c1309g = (C1309g) bVar;
            abstractC2526r.mo15681a(178, m10264a(c1309g.f8536b), c1309g.f8535a, c1309g.f8537c);
            return;
        }
        if (eVar == AbstractC1322t.e.FIELD) {
            C1309g c1309g2 = (C1309g) bVar;
            abstractC2526r.mo15681a(180, m10264a(c1309g2.f8536b), c1309g2.f8535a, c1309g2.f8537c);
            return;
        }
        if (eVar == AbstractC1322t.e.NEW_ARRAY) {
            C1320r c1320r = (C1320r) bVar;
            switch (c1320r.f8557a.charAt(0)) {
                case 'B':
                    abstractC2526r.mo15741a(188, 8);
                    break;
                case 'C':
                    abstractC2526r.mo15741a(188, 5);
                    break;
                case 'D':
                    abstractC2526r.mo15741a(188, 7);
                    break;
                case 'F':
                    abstractC2526r.mo15741a(188, 6);
                    break;
                case 'I':
                    abstractC2526r.mo15741a(188, 10);
                    break;
                case 'J':
                    abstractC2526r.mo15741a(188, 11);
                    break;
                case 'L':
                case '[':
                    abstractC2526r.mo15680a(189, m10264a(c1320r.f8557a));
                    break;
                case 'S':
                    abstractC2526r.mo15741a(188, 9);
                    break;
                case 'Z':
                    abstractC2526r.mo15741a(188, 4);
                    break;
            }
            return;
        }
        if (eVar == AbstractC1322t.e.CHECK_CAST || eVar == AbstractC1322t.e.INSTANCE_OF) {
            abstractC2526r.mo15680a(bVar.f8563h == AbstractC1322t.e.CHECK_CAST ? 192 : 193, m10264a(((C1320r) bVar).f8557a));
        } else if (eVar == AbstractC1322t.e.CAST) {
            m10274b(bVar.f8564d.f8561f, ((C1306d) bVar).f8532b, abstractC2526r);
        } else if (eVar == AbstractC1322t.e.LENGTH) {
            abstractC2526r.mo15740a(190);
        } else if (eVar == AbstractC1322t.e.NEG) {
            abstractC2526r.mo15740a(m10262a(bVar, 116));
        }
    }

    /* renamed from: a */
    private static void m10266a(AbstractC1322t.c cVar, AbstractC2526r abstractC2526r) {
        String str = cVar.f8566c.f8561f;
        m10268a(cVar.f8565b, abstractC2526r);
        if ((cVar.f8563h == AbstractC1322t.e.ADD || cVar.f8563h == AbstractC1322t.e.SUB) && cVar.f8566c.f8563h == AbstractC1322t.e.CONSTANT) {
            C1307e c1307e = (C1307e) cVar.f8566c;
            switch (c1307e.f8561f.charAt(0)) {
                case 'B':
                case 'I':
                case 'S':
                    int intValue = ((Integer) c1307e.f8534b).intValue();
                    if (intValue < 0) {
                        abstractC2526r.mo10229a(new Integer(-intValue));
                        abstractC2526r.mo15740a(m10263a(str, cVar.f8563h == AbstractC1322t.e.ADD ? 100 : 96));
                        return;
                    }
                    break;
                case 'D':
                    double doubleValue = ((Double) c1307e.f8534b).doubleValue();
                    if (doubleValue < 0) {
                        abstractC2526r.mo10229a(new Double(-doubleValue));
                        abstractC2526r.mo15740a(m10263a(str, cVar.f8563h != AbstractC1322t.e.ADD ? 96 : 100));
                        return;
                    }
                    break;
                case 'F':
                    float floatValue = ((Float) c1307e.f8534b).floatValue();
                    if (floatValue < 0) {
                        abstractC2526r.mo10229a(new Float(-floatValue));
                        abstractC2526r.mo15740a(m10263a(str, cVar.f8563h != AbstractC1322t.e.ADD ? 96 : 100));
                        return;
                    }
                    break;
                case 'J':
                    long longValue = ((Long) c1307e.f8534b).longValue();
                    if (longValue < 0) {
                        abstractC2526r.mo10229a(new Long(-longValue));
                        abstractC2526r.mo15740a(m10263a(str, cVar.f8563h != AbstractC1322t.e.ADD ? 96 : 100));
                        return;
                    }
                    break;
            }
        }
        m10268a(cVar.f8566c, abstractC2526r);
        String str2 = cVar.f8565b.f8561f;
        AbstractC1322t.e eVar = cVar.f8563h;
        if (eVar == AbstractC1322t.e.ARRAY) {
            String str3 = cVar.f8561f;
            if (str2.charAt(0) == '[') {
                abstractC2526r.mo15740a(m10263a(str2.substring(1), 46));
                return;
            } else {
                abstractC2526r.mo15740a(m10263a(str3, 46));
                return;
            }
        }
        if (eVar == AbstractC1322t.e.ADD) {
            abstractC2526r.mo15740a(m10263a(str, 96));
            return;
        }
        if (eVar == AbstractC1322t.e.SUB) {
            abstractC2526r.mo15740a(m10263a(str, 100));
            return;
        }
        if (eVar == AbstractC1322t.e.IDIV || eVar == AbstractC1322t.e.LDIV || eVar == AbstractC1322t.e.FDIV || eVar == AbstractC1322t.e.DDIV) {
            abstractC2526r.mo15740a(m10263a(str, 108));
            return;
        }
        if (eVar == AbstractC1322t.e.MUL) {
            abstractC2526r.mo15740a(m10263a(str, 104));
            return;
        }
        if (eVar == AbstractC1322t.e.REM) {
            abstractC2526r.mo15740a(m10263a(str, 112));
            return;
        }
        if (eVar == AbstractC1322t.e.AND) {
            abstractC2526r.mo15740a(m10263a(str, 126));
            return;
        }
        if (eVar == AbstractC1322t.e.OR) {
            abstractC2526r.mo15740a(m10263a(str, 128));
            return;
        }
        if (eVar == AbstractC1322t.e.XOR) {
            abstractC2526r.mo15740a(m10263a(str, 130));
            return;
        }
        if (eVar == AbstractC1322t.e.SHL) {
            abstractC2526r.mo15740a(m10263a(str2, 120));
            return;
        }
        if (eVar == AbstractC1322t.e.SHR) {
            abstractC2526r.mo15740a(m10263a(str2, 122));
            return;
        }
        if (eVar == AbstractC1322t.e.USHR) {
            abstractC2526r.mo15740a(m10263a(str2, 124));
            return;
        }
        if (eVar == AbstractC1322t.e.LCMP) {
            abstractC2526r.mo15740a(148);
            return;
        }
        if (eVar == AbstractC1322t.e.FCMPG) {
            abstractC2526r.mo15740a(150);
            return;
        }
        if (eVar == AbstractC1322t.e.DCMPG) {
            abstractC2526r.mo15740a(152);
        } else if (eVar == AbstractC1322t.e.FCMPL) {
            abstractC2526r.mo15740a(149);
        } else if (eVar == AbstractC1322t.e.DCMPL) {
            abstractC2526r.mo15740a(151);
        }
    }

    /* renamed from: b */
    private static void m10274b(String str, String str2, AbstractC2526r abstractC2526r) {
        if (!str.equals(str2)) {
            switch (str.charAt(0)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    switch (str2.charAt(0)) {
                        case 'B':
                            abstractC2526r.mo15740a(145);
                            break;
                        case 'C':
                            abstractC2526r.mo15740a(146);
                            break;
                        case 'D':
                            abstractC2526r.mo15740a(135);
                            break;
                        case 'F':
                            abstractC2526r.mo15740a(134);
                            break;
                        case 'J':
                            abstractC2526r.mo15740a(133);
                            break;
                        case 'S':
                            abstractC2526r.mo15740a(147);
                            break;
                    }
                case 'D':
                    switch (str2.charAt(0)) {
                        case 'F':
                            abstractC2526r.mo15740a(144);
                            break;
                        case 'I':
                            abstractC2526r.mo15740a(142);
                            break;
                        case 'J':
                            abstractC2526r.mo15740a(143);
                            break;
                    }
                case 'F':
                    switch (str2.charAt(0)) {
                        case 'D':
                            abstractC2526r.mo15740a(141);
                            break;
                        case 'I':
                            abstractC2526r.mo15740a(139);
                            break;
                        case 'J':
                            abstractC2526r.mo15740a(140);
                            break;
                    }
                case 'J':
                    switch (str2.charAt(0)) {
                        case 'D':
                            abstractC2526r.mo15740a(138);
                            break;
                        case 'F':
                            abstractC2526r.mo15740a(137);
                            break;
                        case 'I':
                            abstractC2526r.mo15740a(136);
                            break;
                    }
            }
        }
    }
}
