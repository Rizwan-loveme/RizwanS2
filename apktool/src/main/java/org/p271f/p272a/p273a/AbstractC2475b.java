package org.p271f.p272a.p273a;

import org.p271f.p272a.C2522n;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.p274b.AbstractC2483b;
import org.p271f.p272a.p274b.C2482a;
import org.p271f.p272a.p274b.C2484c;

/* compiled from: Remapper.java */
/* renamed from: org.f.a.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC2475b {
    /* renamed from: b */
    public String m15658b(String str) {
        C2529u m15888a = C2529u.m15888a(str);
        switch (m15888a.m15896a()) {
            case 9:
                String m15658b = m15658b(m15888a.m15899c().m15901e());
                for (int i = 0; i < m15888a.m15898b(); i++) {
                    m15658b = '[' + m15658b;
                }
                return m15658b;
            case 10:
                String m15661d = m15661d(m15888a.m15900d());
                if (m15661d != null) {
                    return 'L' + m15661d + ';';
                }
                break;
        }
        return str;
    }

    /* renamed from: a */
    private C2529u m15651a(C2529u c2529u) {
        switch (c2529u.m15896a()) {
            case 9:
                String m15658b = m15658b(c2529u.m15899c().m15901e());
                for (int i = 0; i < c2529u.m15898b(); i++) {
                    m15658b = '[' + m15658b;
                }
                return C2529u.m15888a(m15658b);
            case 10:
                String m15661d = m15661d(c2529u.m15900d());
                return m15661d != null ? C2529u.m15891b(m15661d) : c2529u;
            case 11:
                return C2529u.m15892c(m15660c(c2529u.m15901e()));
            default:
                return c2529u;
        }
    }

    /* renamed from: a */
    public String mo10335a(String str) {
        if (str == null) {
            return null;
        }
        return m15651a(C2529u.m15891b(str)).m15900d();
    }

    /* renamed from: a */
    public String[] m15657a(String[] strArr) {
        boolean z = false;
        String[] strArr2 = null;
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            String m15661d = m15661d(str);
            if (m15661d != null && strArr2 == null) {
                strArr2 = new String[strArr.length];
                if (i > 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, i);
                }
                z = true;
            }
            if (z) {
                if (m15661d != null) {
                    str = m15661d;
                }
                strArr2[i] = str;
            }
        }
        return z ? strArr2 : strArr;
    }

    /* renamed from: c */
    public String m15660c(String str) {
        if (!"()V".equals(str)) {
            C2529u[] m15893d = C2529u.m15893d(str);
            StringBuilder sb = new StringBuilder("(");
            for (C2529u c2529u : m15893d) {
                sb.append(m15658b(c2529u.m15901e()));
            }
            C2529u m15894e = C2529u.m15894e(str);
            if (m15894e == C2529u.f13273a) {
                sb.append(")V");
                return sb.toString();
            }
            sb.append(')').append(m15658b(m15894e.m15901e()));
            return sb.toString();
        }
        return str;
    }

    /* renamed from: a */
    public Object m15652a(Object obj) {
        if (obj instanceof C2529u) {
            return m15651a((C2529u) obj);
        }
        if (obj instanceof C2522n) {
            C2522n c2522n = (C2522n) obj;
            return new C2522n(c2522n.m15848a(), mo10335a(c2522n.m15849b()), m15654a(c2522n.m15849b(), c2522n.m15850c(), c2522n.m15851d()), m15660c(c2522n.m15851d()));
        }
        return obj;
    }

    /* renamed from: a */
    public String m15655a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        C2482a c2482a = new C2482a(str);
        C2484c c2484c = new C2484c();
        AbstractC2483b m15656a = m15656a((AbstractC2483b) c2484c);
        if (z) {
            c2482a.m15711b(m15656a);
        } else {
            c2482a.m15710a(m15656a);
        }
        return c2484c.toString();
    }

    /* renamed from: a */
    protected AbstractC2483b m15656a(AbstractC2483b abstractC2483b) {
        return new C2480g(abstractC2483b, this);
    }

    /* renamed from: a */
    public String m15654a(String str, String str2, String str3) {
        return str2;
    }

    /* renamed from: a */
    public String m15653a(String str, String str2) {
        return str;
    }

    /* renamed from: b */
    public String m15659b(String str, String str2, String str3) {
        return str2;
    }

    /* renamed from: d */
    public String m15661d(String str) {
        return str;
    }
}
