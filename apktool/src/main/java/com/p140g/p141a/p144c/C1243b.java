package com.p140g.p141a.p144c;

import com.p140g.p141a.C1241c;
import com.p140g.p141a.C1249d;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1287f;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p143b.C1239a;
import com.p140g.p141a.p143b.C1240b;
import com.p140g.p141a.p145d.C1250a;
import com.p140g.p141a.p145d.C1253b;
import com.p140g.p141a.p145d.C1276e;
import com.p140g.p141a.p145d.C1277f;
import com.p140g.p141a.p145d.C1278g;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p156c.C1340a;
import com.p140g.p152b.p153a.p156c.C1347c;
import com.p140g.p152b.p153a.p156c.C1348d;
import com.p140g.p152b.p153a.p156c.C1349e;
import com.p140g.p152b.p153a.p156c.C1350f;
import com.p140g.p152b.p153a.p156c.C1351g;
import com.p140g.p152b.p153a.p156c.C1352h;
import com.p140g.p152b.p153a.p156c.C1353i;
import com.p140g.p152b.p153a.p156c.C1354j;
import com.p140g.p152b.p153a.p156c.C1355k;
import com.p140g.p152b.p153a.p156c.C1356l;
import com.p140g.p152b.p153a.p156c.C1358n;
import com.p140g.p152b.p153a.p156c.C1359o;
import com.p140g.p152b.p153a.p156c.C1361q;
import com.p140g.p152b.p153a.p156c.C1362r;
import com.p140g.p152b.p153a.p156c.p158b.C1346a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2515g;
import org.p271f.p272a.AbstractC2519k;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2522n;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.p275c.C2491f;

/* compiled from: Dex2Asm.java */
/* renamed from: com.g.a.c.b */
/* loaded from: classes.dex */
public class C1243b {

    /* renamed from: a */
    protected static final C1347c f8049a = new C1347c();

    /* renamed from: b */
    protected static final C1349e f8050b = new C1349e();

    /* renamed from: c */
    protected static final C1351g f8051c = new C1351g();

    /* renamed from: d */
    protected static final C1353i f8052d = new C1353i();

    /* renamed from: e */
    protected static final C1355k f8053e = new C1355k();

    /* renamed from: f */
    protected static final C1356l f8054f = new C1356l();

    /* renamed from: g */
    protected static final C1350f f8055g = new C1350f();

    /* renamed from: h */
    protected static final C1358n f8056h = new C1358n();

    /* renamed from: i */
    protected static final C1348d f8057i = new C1348d();

    /* renamed from: j */
    protected static final C1346a f8058j = new C1346a();

    /* renamed from: k */
    protected static final C1340a f8059k = new C1340a();

    /* renamed from: l */
    protected static final C1359o f8060l = new C1359o();

    /* renamed from: m */
    protected static final C1362r f8061m = new C1362r();

    /* renamed from: n */
    protected static final C1361q f8062n = new C1361q();

    /* renamed from: o */
    protected static final C1354j f8063o = new C1354j();

    /* renamed from: p */
    protected static final C1352h f8064p = new C1352h();

    /* renamed from: q */
    private static final Comparator<C2491f> f8065q = new Comparator<C2491f>() { // from class: com.g.a.c.b.1
        @Override // java.util.Comparator
        public int compare(C2491f c2491f, C2491f c2491f2) {
            return m10310a(c2491f, c2491f2);
        }

        /* renamed from: a */
        public int m10310a(C2491f c2491f, C2491f c2491f2) {
            return c2491f.f13010a.compareTo(c2491f2.f13010a);
        }
    };

    /* compiled from: Dex2Asm.java */
    /* renamed from: com.g.a.c.b$a */
    protected static class a {

        /* renamed from: a */
        public int f8066a;

        /* renamed from: b */
        public a f8067b;

        /* renamed from: c */
        public C1280e f8068c;

        /* renamed from: d */
        public String f8069d;

        /* renamed from: e */
        public Set<a> f8070e = (Set) null;

        /* renamed from: f */
        public final String f8071f;

        public a(String str) {
            this.f8071f = str;
        }

        /* renamed from: a */
        void m10311a(a aVar) {
            if (this.f8070e == null) {
                this.f8070e = new HashSet();
            }
            this.f8070e.add(aVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f8071f == null ? aVar.f8071f == null : this.f8071f.equals(aVar.f8071f);
            }
            return false;
        }

        public int hashCode() {
            return (this.f8071f == null ? 0 : this.f8071f.hashCode()) + 31;
        }

        public String toString() {
            return new StringBuffer().append("").append(this.f8071f).toString();
        }
    }

    /* renamed from: a */
    private static int m10280a(boolean z, int i) {
        if ((i & 512) == 0) {
            i |= 32;
        }
        int i2 = i & (-11);
        if (z && (i2 & 4) != 0) {
            i2 = (i2 & (-5)) | 1;
        }
        return i2 & (-131073);
    }

    /* renamed from: a */
    private static int m10279a(int i) {
        int i2 = i & (-33);
        if ((i2 & 2) != 0) {
            return i2 & (-6);
        }
        if ((i2 & 4) != 0) {
            return i2 & (-2);
        }
        return i2;
    }

    /* renamed from: a */
    protected static String m10284a(C1241c c1241c) {
        return m10285a(c1241c.f8048a);
    }

    /* renamed from: a */
    protected static String m10285a(String str) {
        return C2529u.m15888a(str).m15900d();
    }

    /* renamed from: a */
    public static void m10291a(C1250a c1250a, AbstractC2515g abstractC2515g) {
        AbstractC2473a mo15663a = abstractC2515g.mo15663a(c1250a.f8090b, c1250a.f8091c != EnumC1301h.BUILD);
        if (mo15663a != null) {
            m10294a(c1250a.f8089a, mo15663a);
            mo15663a.mo15637a();
        }
    }

    /* renamed from: a */
    public static void m10295a(List<C1250a> list, AbstractC2515g abstractC2515g) {
        if (list != null) {
            for (C1250a c1250a : list) {
                if (c1250a.f8091c != EnumC1301h.SYSTEM) {
                    m10291a(c1250a, abstractC2515g);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10296a(List<C1250a> list, AbstractC2519k abstractC2519k) {
        if (list != null) {
            for (C1250a c1250a : list) {
                if (c1250a.f8091c != EnumC1301h.SYSTEM) {
                    m10292a(c1250a, abstractC2519k);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10297a(List<C1250a> list, AbstractC2526r abstractC2526r) {
        if (list != null) {
            for (C1250a c1250a : list) {
                if (c1250a.f8091c != EnumC1301h.SYSTEM) {
                    m10293a(c1250a, abstractC2526r);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10293a(C1250a c1250a, AbstractC2526r abstractC2526r) {
        AbstractC2473a mo15679a = abstractC2526r.mo15679a(c1250a.f8090b, c1250a.f8091c != EnumC1301h.BUILD);
        if (mo15679a != null) {
            m10294a(c1250a.f8089a, mo15679a);
            mo15679a.mo15637a();
        }
    }

    /* renamed from: a */
    public static void m10290a(C1250a c1250a, int i, AbstractC2526r abstractC2526r) {
        AbstractC2473a mo15677a = abstractC2526r.mo15677a(i, c1250a.f8090b, c1250a.f8091c != EnumC1301h.BUILD);
        if (mo15677a != null) {
            m10294a(c1250a.f8089a, mo15677a);
            mo15677a.mo15637a();
        }
    }

    /* renamed from: a */
    public static void m10292a(C1250a c1250a, AbstractC2519k abstractC2519k) {
        AbstractC2473a mo15673a = abstractC2519k.mo15673a(c1250a.f8090b, c1250a.f8091c != EnumC1301h.BUILD);
        if (mo15673a != null) {
            m10294a(c1250a.f8089a, mo15673a);
            mo15673a.mo15637a();
        }
    }

    /* renamed from: a */
    public static void m10294a(List<C1250a.b> list, AbstractC2473a abstractC2473a) {
        for (C1250a.b bVar : list) {
            m10298a(abstractC2473a, bVar.f8098a, bVar.f8099b);
        }
    }

    /* renamed from: a */
    private static void m10298a(AbstractC2473a abstractC2473a, String str, Object obj) {
        if (obj instanceof Object[]) {
            AbstractC2473a mo15635a = abstractC2473a.mo15635a(str);
            if (mo15635a != null) {
                Object[] objArr = (Object[]) obj;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        m10298a(mo15635a, (String) null, objArr[i2]);
                        i = i2 + 1;
                    } else {
                        mo15635a.mo15637a();
                        return;
                    }
                }
            }
        } else {
            if (obj instanceof C1250a) {
                C1250a c1250a = (C1250a) obj;
                AbstractC2473a mo15636a = abstractC2473a.mo15636a(str, c1250a.f8090b);
                if (mo15636a != null) {
                    for (C1250a.b bVar : c1250a.f8089a) {
                        m10298a(mo15636a, bVar.f8098a, bVar.f8099b);
                    }
                    mo15636a.mo15637a();
                    return;
                }
                return;
            }
            if (obj instanceof C1249d) {
                C1249d c1249d = (C1249d) obj;
                abstractC2473a.mo15639a(str, c1249d.m10338c(), c1249d.m10336a());
            } else {
                if (obj instanceof C1241c) {
                    abstractC2473a.mo15638a(str, C2529u.m15888a(((C1241c) obj).f8048a));
                    return;
                }
                if (obj instanceof C1280e) {
                    System.err.println("WARN: ignored method annotation value");
                } else if (obj == null) {
                    System.err.println("WARN: ignored null annotation value");
                } else {
                    abstractC2473a.mo15638a(str, obj);
                }
            }
        }
    }

    /* renamed from: a */
    private static AbstractC2526r m10287a(C1278g c1278g, AbstractC2515g abstractC2515g) {
        String str;
        String[] strArr;
        String[] strArr2;
        String str2;
        String[] strArr3 = (String[]) null;
        String str3 = (String) null;
        if (c1278g.f8169b != null) {
            String str4 = str3;
            String[] strArr4 = strArr3;
            for (C1250a c1250a : c1278g.f8169b) {
                if (c1250a.f8091c == EnumC1301h.SYSTEM) {
                    String str5 = c1250a.f8090b;
                    if (str5.equals("Ldalvik/annotation/Throws;")) {
                        Object[] objArr = (Object[]) m10282a(c1250a, "value");
                        if (objArr != null) {
                            String[] strArr5 = new String[objArr.length];
                            for (int i = 0; i < objArr.length; i++) {
                                strArr5[i] = m10284a((C1241c) objArr[i]);
                            }
                            strArr2 = strArr5;
                        } else {
                            strArr2 = strArr4;
                        }
                        strArr4 = strArr2;
                    } else if (str5.equals("Ldalvik/annotation/Signature;")) {
                        Object[] objArr2 = (Object[]) m10282a(c1250a, "value");
                        if (objArr2 != null) {
                            StringBuilder sb = new StringBuilder();
                            for (Object obj : objArr2) {
                                sb.append(obj);
                            }
                            str2 = sb.toString();
                        } else {
                            str2 = str4;
                        }
                        str4 = str2;
                    }
                }
            }
            str = str4;
            strArr = strArr4;
        } else {
            str = str3;
            strArr = strArr3;
        }
        return abstractC2515g.mo15667a((-196609) & c1278g.f8168a, c1278g.f8171d.m10398c(), c1278g.f8171d.m10397b(), str, strArr);
    }

    /* renamed from: a */
    protected static Map<String, a> m10286a(C1277f c1277f) {
        HashMap hashMap = new HashMap();
        for (C1253b c1253b : c1277f.f8166a) {
            a m10281a = m10281a(hashMap, c1253b.f8102c);
            m10281a.f8066a = (m10281a.f8066a & (-1537)) | c1253b.f8100a;
            if (c1253b.f8101b != null) {
                for (C1250a c1250a : c1253b.f8101b) {
                    if (c1250a.f8091c == EnumC1301h.SYSTEM) {
                        String str = c1250a.f8090b;
                        if (str.equals("Ldalvik/annotation/EnclosingClass;")) {
                            a m10281a2 = m10281a(hashMap, ((C1241c) m10282a(c1250a, "value")).f8048a);
                            m10281a.f8067b = m10281a2;
                            m10281a2.m10311a(m10281a);
                        } else if (str.equals("Ldalvik/annotation/EnclosingMethod;")) {
                            C1280e c1280e = (C1280e) m10282a(c1250a, "value");
                            a m10281a3 = m10281a(hashMap, c1280e.m10399d());
                            m10281a.f8067b = m10281a3;
                            m10281a.f8068c = c1280e;
                            m10281a3.m10311a(m10281a);
                        } else if (str.equals("Ldalvik/annotation/InnerClass;")) {
                            for (C1250a.b bVar : c1250a.f8089a) {
                                if ("accessFlags".equals(bVar.f8098a)) {
                                    m10281a.f8066a = (((Integer) bVar.f8099b).intValue() & (-1537)) | m10281a.f8066a;
                                } else if ("name".equals(bVar.f8098a)) {
                                    m10281a.f8069d = (String) bVar.f8099b;
                                }
                            }
                        } else if (str.equals("Ldalvik/annotation/MemberClasses;")) {
                            Object[] objArr = (Object[]) m10282a(c1250a, "value");
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < objArr.length) {
                                    a m10281a4 = m10281a(hashMap, ((C1241c) objArr[i2]).f8048a);
                                    m10281a.m10311a(m10281a4);
                                    m10281a4.f8067b = m10281a;
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static boolean m10300b(String str) {
        if (str.length() >= 1 && Character.isJavaIdentifierStart(str.charAt(0))) {
            for (int i = 1; i < str.length(); i++) {
                if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m10306a(C1277f c1277f, C1253b c1253b, InterfaceC1242a interfaceC1242a, Map<String, a> map) {
        m10302a(c1277f.f8167b, c1253b, interfaceC1242a, map);
    }

    /* renamed from: a */
    public void m10302a(int i, C1253b c1253b, InterfaceC1242a interfaceC1242a, Map<String, a> map) {
        String str;
        String[] strArr;
        boolean z;
        String str2;
        AbstractC2515g mo10278a = interfaceC1242a.mo10278a(m10285a(c1253b.f8102c));
        if (mo10278a != null) {
            C1246e.m10331a(c1253b);
            String str3 = (String) null;
            if (c1253b.f8101b != null) {
                String str4 = str3;
                for (C1250a c1250a : c1253b.f8101b) {
                    if (c1250a.f8091c == EnumC1301h.SYSTEM && c1250a.f8090b.equals("Ldalvik/annotation/Signature;")) {
                        Object[] objArr = (Object[]) m10282a(c1250a, "value");
                        if (objArr != null) {
                            StringBuilder sb = new StringBuilder();
                            for (Object obj : objArr) {
                                sb.append(obj);
                            }
                            str2 = sb.toString();
                        } else {
                            str2 = str4;
                        }
                        str4 = str2;
                    }
                }
                str = str4;
            } else {
                str = str3;
            }
            String[] strArr2 = (String[]) null;
            if (c1253b.f8104e != null) {
                strArr = new String[c1253b.f8104e.length];
                for (int i2 = 0; i2 < c1253b.f8104e.length; i2++) {
                    strArr[i2] = m10285a(c1253b.f8104e[i2]);
                }
            } else {
                strArr = strArr2;
            }
            a aVar = map.get(c1253b.f8102c);
            int i3 = c1253b.f8100a;
            if (aVar != null) {
                z = (aVar.f8067b == null && aVar.f8068c == null) ? false : true;
            } else {
                z = false;
            }
            mo10278a.mo15669a(i >= 3158839 ? 52 : 50, m10280a(z, i3), m10285a(c1253b.f8102c), str, c1253b.f8107h == null ? (String) null : m10285a(c1253b.f8107h), strArr);
            ArrayList<C2491f> arrayList = new ArrayList(5);
            if (aVar != null) {
                m10289a(aVar, arrayList, c1253b.f8102c);
            }
            if (z) {
                if (aVar.f8069d == null) {
                    C1280e c1280e = aVar.f8068c;
                    if (c1280e != null) {
                        mo10278a.mo15670a(m10285a(c1280e.m10399d()), c1280e.m10398c(), c1280e.m10397b());
                    } else {
                        mo10278a.mo15670a(m10285a(aVar.f8067b.f8071f), (String) null, (String) null);
                    }
                }
                m10288a(aVar, arrayList);
            }
            Collections.sort(arrayList, f8065q);
            for (C2491f c2491f : arrayList) {
                if (c2491f.f13012c != null && !m10300b(c2491f.f13012c)) {
                    System.err.println(new StringBuffer().append("WARN: ignored invalid inner class name ").append(", treat as anonymous inner class.").toString());
                    c2491f.f13012c = (String) null;
                    c2491f.f13011b = (String) null;
                }
                c2491f.m15726a(mo10278a);
            }
            m10295a(c1253b.f8101b, mo10278a);
            if (c1253b.f8103d != null) {
                Iterator<C1276e> it = c1253b.f8103d.iterator();
                while (it.hasNext()) {
                    m10303a(c1253b, it.next(), mo10278a);
                }
            }
            if (c1253b.f8105f != null) {
                Iterator<C1278g> it2 = c1253b.f8105f.iterator();
                while (it2.hasNext()) {
                    m10304a(c1253b, it2.next(), mo10278a);
                }
            }
            mo10278a.mo10327a();
        }
    }

    /* renamed from: a */
    public void mo10307a(C1278g c1278g, AbstractC2526r abstractC2526r) {
        C1323b m10301a = m10301a(c1278g);
        mo10308a(m10301a);
        mo10309a(m10301a, abstractC2526r);
    }

    /* renamed from: a */
    public void m10305a(C1277f c1277f, InterfaceC1242a interfaceC1242a) {
        if (c1277f.f8166a != null) {
            Map<String, a> m10286a = m10286a(c1277f);
            Iterator<C1253b> it = c1277f.f8166a.iterator();
            while (it.hasNext()) {
                m10306a(c1277f, it.next(), interfaceC1242a, m10286a);
            }
        }
    }

    /* renamed from: a */
    public void m10303a(C1253b c1253b, C1276e c1276e, AbstractC2515g abstractC2515g) {
        String str;
        String str2;
        String str3 = (String) null;
        if (c1276e.f8163b != null) {
            String str4 = str3;
            for (C1250a c1250a : c1276e.f8163b) {
                if (c1250a.f8091c == EnumC1301h.SYSTEM && c1250a.f8090b.equals("Ldalvik/annotation/Signature;")) {
                    Object[] objArr = (Object[]) m10282a(c1250a, "value");
                    if (objArr != null) {
                        StringBuilder sb = new StringBuilder();
                        for (Object obj : objArr) {
                            sb.append(obj);
                        }
                        str2 = sb.toString();
                    } else {
                        str2 = str4;
                    }
                    str4 = str2;
                }
            }
            str = str4;
        } else {
            str = str3;
        }
        AbstractC2519k mo15665a = abstractC2515g.mo15665a((-131073) & c1276e.f8162a, c1276e.f8165d.m10336a(), c1276e.f8165d.m10338c(), str, m10283a(c1276e.f8164c));
        if (mo15665a != null) {
            m10296a(c1276e.f8163b, mo15665a);
            mo15665a.mo15830a();
        }
    }

    /* renamed from: a */
    public static Object[] m10299a(Object[] objArr) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        for (int i = 0; i < copyOf.length; i++) {
            copyOf[i] = m10283a(copyOf[i]);
        }
        return copyOf;
    }

    /* renamed from: a */
    public static Object m10283a(Object obj) {
        if (obj instanceof C1241c) {
            return C2529u.m15888a(((C1241c) obj).f8048a);
        }
        if (!(obj instanceof C1287f)) {
            return obj;
        }
        C2522n c2522n = (C2522n) null;
        C1287f c1287f = (C1287f) obj;
        switch (c1287f.m10457a()) {
            case 0:
                return new C2522n(3, m10285a(c1287f.m10458b().m10337b()), c1287f.m10458b().m10336a(), c1287f.m10458b().m10338c());
            case 1:
                return new C2522n(1, m10285a(c1287f.m10458b().m10337b()), c1287f.m10458b().m10336a(), c1287f.m10458b().m10338c());
            case 2:
                return new C2522n(3, m10285a(c1287f.m10458b().m10337b()), c1287f.m10458b().m10336a(), c1287f.m10458b().m10338c());
            case 3:
                return new C2522n(1, m10285a(c1287f.m10458b().m10337b()), c1287f.m10458b().m10336a(), c1287f.m10458b().m10338c());
            case 4:
                return new C2522n(6, m10285a(c1287f.m10459c().m10399d()), c1287f.m10459c().m10398c(), c1287f.m10459c().m10397b());
            case 5:
                return new C2522n(5, m10285a(c1287f.m10459c().m10399d()), c1287f.m10459c().m10398c(), c1287f.m10459c().m10397b());
            default:
                return c2522n;
        }
    }

    /* renamed from: a */
    public void m10304a(C1253b c1253b, C1278g c1278g, AbstractC2515g abstractC2515g) {
        AbstractC2473a mo15676a;
        AbstractC2526r m10287a = m10287a(c1278g, abstractC2515g);
        if (m10287a != null) {
            if ((c1253b.f8100a & 8192) != 0) {
                Object obj = (Object) null;
                if (c1253b.f8101b != null) {
                    Iterator<C1250a> it = c1253b.f8101b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1250a next = it.next();
                        if (next.f8091c == EnumC1301h.SYSTEM && next.f8090b.equals("Ldalvik/annotation/AnnotationDefault;")) {
                            C1250a c1250a = (C1250a) m10282a(next, "value");
                            if (c1250a != null) {
                                obj = m10282a(c1250a, c1278g.f8171d.m10398c());
                            }
                        }
                    }
                }
                if (obj != null && (mo15676a = m10287a.mo15676a()) != null) {
                    m10298a(mo15676a, (String) null, obj);
                    mo15676a.mo15637a();
                }
            }
            m10297a(c1278g.f8169b, m10287a);
            if (c1278g.f8172e != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c1278g.f8172e.length) {
                        break;
                    }
                    List<C1250a> list = c1278g.f8172e[i2];
                    if (list != null) {
                        for (C1250a c1250a2 : list) {
                            if (c1250a2.f8091c != EnumC1301h.SYSTEM) {
                                m10290a(c1250a2, i2, m10287a);
                            }
                        }
                    }
                    i = i2 + 1;
                }
            }
            if ((c1278g.f8168a & 9472) == 0 && c1278g.f8170c != null) {
                m10287a.mo15751b();
                mo10307a(c1278g, m10287a);
            }
            m10287a.mo15753c();
        }
    }

    /* renamed from: a */
    public C1323b m10301a(C1278g c1278g) {
        return new C1239a().m10247a((c1278g.f8168a & 8) != 0, c1278g.f8171d, c1278g.f8170c);
    }

    /* renamed from: a */
    protected static Object m10282a(C1250a c1250a, String str) {
        for (C1250a.b bVar : c1250a.f8089a) {
            if (bVar.f8098a.equals(str)) {
                return bVar.f8099b;
            }
        }
        return (Object) null;
    }

    /* renamed from: a */
    private static a m10281a(Map<String, a> map, String str) {
        a aVar = map.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            map.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo10309a(C1323b c1323b, AbstractC2526r abstractC2526r) {
        new C1240b(false).m10277a(c1323b, abstractC2526r);
        abstractC2526r.mo15650d(-1, -1);
    }

    /* renamed from: a */
    public void mo10308a(C1323b c1323b) {
        f8049a.m10668a(c1323b);
        f8057i.m10669a(c1323b);
        f8054f.mo10706b(c1323b);
        f8053e.mo10706b(c1323b);
        f8061m.mo10706b(c1323b);
        if (f8063o.mo10610a(c1323b)) {
            f8057i.m10669a(c1323b);
            f8054f.mo10706b(c1323b);
            f8053e.mo10706b(c1323b);
        }
        f8052d.m10680a(c1323b);
        f8058j.mo10706b(c1323b);
        f8059k.mo10706b(c1323b);
        f8064p.mo10706b(c1323b);
        f8062n.mo10706b(c1323b);
        f8056h.m10708a(c1323b);
        f8060l.m10755a(c1323b);
        f8055g.m10670a(c1323b);
        f8051c.m10676a(c1323b);
    }

    /* renamed from: a */
    private static void m10288a(a aVar, List<C2491f> list) {
        HashSet hashSet = new HashSet();
        for (a aVar2 = aVar; aVar2 != null && hashSet.add(aVar2); aVar2 = aVar2.f8067b) {
            a aVar3 = aVar2.f8067b;
            if (aVar3 == null || aVar3 == aVar) {
                return;
            }
            int m10279a = m10279a(aVar2.f8066a);
            if (aVar2.f8069d != null) {
                list.add(new C2491f(m10285a(aVar2.f8071f), m10285a(aVar3.f8071f), aVar2.f8069d, m10279a));
            } else {
                list.add(new C2491f(m10285a(aVar2.f8071f), (String) null, (String) null, m10279a));
            }
        }
    }

    /* renamed from: a */
    private static void m10289a(a aVar, List<C2491f> list, String str) {
        HashSet hashSet = new HashSet();
        Stack stack = new Stack();
        stack.push(aVar);
        while (!stack.empty()) {
            a aVar2 = (a) stack.pop();
            if (!hashSet.contains(aVar2)) {
                hashSet.add(aVar2);
                if (aVar2.f8070e != null) {
                    for (a aVar3 : aVar2.f8070e) {
                        if (aVar3.f8069d == null) {
                            list.add(new C2491f(m10285a(aVar3.f8071f), (String) null, (String) null, m10279a(aVar3.f8066a)));
                        } else {
                            list.add(new C2491f(m10285a(aVar3.f8071f), m10285a(str), aVar3.f8069d, m10279a(aVar3.f8066a)));
                        }
                        stack.push(aVar3);
                    }
                }
            }
        }
    }
}
