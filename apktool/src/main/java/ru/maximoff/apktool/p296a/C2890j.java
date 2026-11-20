package ru.maximoff.apktool.p296a;

import android.content.res.AssetManager;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.p217b.p218a.p219a.C1887e;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p270e.C2466a;
import org.p270e.C2468c;

/* compiled from: Packages.java */
/* renamed from: ru.maximoff.apktool.a.j */
/* loaded from: classes.dex */
public class C2890j {

    /* renamed from: a */
    private static final Map<String, a> f14845a = new LinkedHashMap();

    /* renamed from: b */
    private static final Map<String, a> f14846b = new LinkedHashMap();

    /* renamed from: c */
    private static final Map<String, a> f14847c = new LinkedHashMap();

    /* renamed from: d */
    private static Comparator<String> f14848d = new Comparator<String>() { // from class: ru.maximoff.apktool.a.j.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return m16922a(str, str2);
        }

        /* renamed from: a */
        public int m16922a(String str, String str2) {
            if (str.contains(":") && str2.contains("(")) {
                return -1;
            }
            if (str.contains("(") && str2.contains(":")) {
                return 1;
            }
            return str.toLowerCase().compareTo(str2.toLowerCase());
        }
    };

    /* renamed from: e */
    private static final List<String> f14849e = new ArrayList(0);

    /* renamed from: a */
    public static boolean m16916a(File file, String str) {
        File file2 = new File(file, String.format("%d.json", new Integer(str.hashCode())));
        if (file2.exists()) {
            try {
                C2468c c2468c = new C2468c(C1887e.m13985c(new FileInputStream(file2)));
                Iterator<String> m15605a = c2468c.m15605a();
                while (m15605a.hasNext()) {
                    String next = m15605a.next();
                    f14846b.put(next, new a(c2468c.m15616e(next)));
                }
                m16920c();
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m16919b(File file, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, String.format("%d.json", new Integer(str.hashCode()))));
            C2468c c2468c = new C2468c();
            for (Map.Entry<String, a> entry : f14846b.entrySet()) {
                c2468c.m15608a(entry.getKey(), entry.getValue().m16923a());
            }
            C1887e.m13973a(c2468c.m15603a(1), fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static synchronized void m16910a(AssetManager assetManager) {
        synchronized (C2890j.class) {
            m16914a(new C2153g(C2359g.m15023a(14), C1887e.m13984b(assetManager.open("android.dex"))));
        }
    }

    /* renamed from: a */
    public static synchronized void m16912a(String str, a aVar, boolean z) {
        synchronized (C2890j.class) {
            if (z) {
                f14847c.put(str, aVar);
            } else {
                f14846b.put(str, aVar);
            }
        }
    }

    /* renamed from: a */
    private static void m16913a(InterfaceC2244d interfaceC2244d, Map<String, a> map) {
        String mo14205l = interfaceC2244d.mo14205l();
        LinkedList linkedList = new LinkedList();
        int m14191a = EnumC1959a.PRIVATE.m14191a();
        StringBuilder sb = new StringBuilder(100);
        for (InterfaceC2266g interfaceC2266g : interfaceC2244d.mo14207n()) {
            if ((interfaceC2266g.mo14222a() & m14191a) <= 0) {
                sb.append(interfaceC2266g.mo14226e());
                sb.append(':');
                sb.append(interfaceC2266g.mo14227f());
                linkedList.add(sb.toString());
                sb.setLength(0);
            }
        }
        for (InterfaceC2267h interfaceC2267h : interfaceC2244d.mo14206m()) {
            if ((interfaceC2267h.mo14214f() & m14191a) <= 0 && !interfaceC2267h.mo14210b().equals("<clinit>")) {
                sb.append(interfaceC2267h.mo14210b());
                sb.append('(');
                Iterator<? extends CharSequence> it = interfaceC2267h.mo14211c().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                sb.append(')');
                sb.append(interfaceC2267h.mo14212d());
                linkedList.add(sb.toString());
                sb.setLength(0);
            }
        }
        a aVar = new a();
        aVar.f14850a = interfaceC2244d.mo14195b();
        aVar.f14852c = interfaceC2244d.mo14196c();
        aVar.f14851b = linkedList;
        map.put(mo14205l, aVar);
    }

    /* renamed from: a */
    public static void m16914a(InterfaceC2264e interfaceC2264e) {
        f14845a.clear();
        Iterator<? extends InterfaceC2244d> it = interfaceC2264e.mo14769c().iterator();
        while (it.hasNext()) {
            m16913a(it.next(), f14845a);
        }
    }

    /* renamed from: a */
    public static void m16909a() {
        f14846b.clear();
        f14847c.clear();
    }

    /* renamed from: a */
    private static void m16915a(a aVar, Map<String, a> map, List<String> list) {
        m16911a(aVar.f14850a, list, map);
        Iterator<String> it = aVar.f14852c.iterator();
        while (it.hasNext()) {
            m16911a(it.next(), list, map);
        }
        Collections.sort(list, f14848d);
    }

    /* renamed from: a */
    private static void m16911a(String str, List<String> list, Map<String, a> map) {
        a m16918b;
        if (str != null && (m16918b = m16918b(str)) != null) {
            m16915a(m16918b, map, list);
            for (String str2 : m16918b.f14851b) {
                if (!list.contains(str2) && !str2.startsWith("<init>(")) {
                    list.add(str2);
                }
            }
        }
    }

    /* renamed from: b */
    public static Iterable<String> m16917b() {
        return f14847c.keySet();
    }

    /* renamed from: a */
    public static List<String> m16908a(String str) {
        List<String> arrayList;
        if (str.startsWith("[")) {
            str = "Ljava/lang/Object;";
        }
        synchronized (f14847c) {
            a m16918b = m16918b(str);
            if (m16918b == null) {
                arrayList = f14849e;
            } else {
                arrayList = new ArrayList<>(m16918b.f14851b);
                m16915a(m16918b, f14846b, arrayList);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static void m16920c() {
        Map<String, a> map = f14847c;
        synchronized (map) {
            map.clear();
            map.putAll(f14845a);
            map.putAll(f14846b);
        }
    }

    /* renamed from: b */
    private static a m16918b(String str) {
        return f14847c.get(str);
    }

    /* renamed from: d */
    public static boolean m16921d() {
        return f14847c.size() <= 1;
    }

    /* renamed from: a */
    protected static String m16907a(C2468c c2468c, String str) {
        return c2468c.m15619h(str) ? (String) null : c2468c.m15617f(str);
    }

    /* compiled from: Packages.java */
    /* renamed from: ru.maximoff.apktool.a.j$a */
    public static class a {

        /* renamed from: a */
        public String f14850a;

        /* renamed from: b */
        public List<String> f14851b;

        /* renamed from: c */
        public List<String> f14852c;

        public a() {
        }

        public a(C2468c c2468c) {
            this.f14850a = C2890j.m16907a(c2468c, "super");
            C2466a m15615d = c2468c.m15615d("members");
            this.f14851b = new LinkedList();
            for (int i = 0; i < m15615d.m15569a(); i++) {
                this.f14851b.add(m15615d.m15579f(i));
            }
            C2466a m15615d2 = c2468c.m15615d("impls");
            this.f14852c = new LinkedList();
            for (int i2 = 0; i2 < m15615d2.m15569a(); i2++) {
                this.f14852c.add(m15615d2.m15579f(i2));
            }
        }

        /* renamed from: a */
        public C2468c m16923a() {
            C2468c c2468c = new C2468c();
            c2468c.m15608a("super", (Object) this.f14850a);
            c2468c.m15608a("members", new C2466a((Collection<?>) this.f14851b));
            c2468c.m15608a("impls", new C2466a((Collection<?>) this.f14852c));
            return c2468c;
        }
    }
}
