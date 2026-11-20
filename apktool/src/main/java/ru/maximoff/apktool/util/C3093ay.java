package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;

/* compiled from: QuickPanelUtils.java */
/* renamed from: ru.maximoff.apktool.util.ay */
/* loaded from: classes.dex */
public class C3093ay {

    /* renamed from: a */
    private final String f18180a = "quick_panel_symbols";

    /* renamed from: b */
    private final int f18181b = 300;

    /* renamed from: c */
    private Context f18182c;

    /* renamed from: d */
    private List<String> f18183d;

    /* renamed from: e */
    private SharedPreferences f18184e;

    /* renamed from: f */
    private SharedPreferences.Editor f18185f;

    public C3093ay(Context context) {
        this.f18182c = context;
        this.f18184e = context.getSharedPreferences("quick_panel_symbols", 0);
        this.f18185f = this.f18184e.edit();
        m18782b();
    }

    /* renamed from: a */
    public String m18776a() {
        return "quick_panel_symbols";
    }

    /* renamed from: b */
    public List<String> m18782b() {
        this.f18183d = m18785d();
        return this.f18183d;
    }

    /* renamed from: c */
    public boolean m18784c() {
        return this.f18183d.isEmpty();
    }

    /* renamed from: d */
    public synchronized List<String> m18785d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 300) {
                String string = this.f18184e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    arrayList.add(string);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public synchronized List<a> m18786e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 300) {
                String string = this.f18184e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    arrayList.add(m18774c(string));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public synchronized Map<Integer, String> m18787f() {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 300) {
                String string = this.f18184e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    linkedHashMap.put(new Integer(i2), string);
                }
                i = i2 + 1;
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public void m18777a(String str, String str2) {
        m18781a(m18773a(new a(str, str2)));
    }

    /* renamed from: a */
    public synchronized boolean m18781a(String str) {
        boolean z = false;
        synchronized (this) {
            if (!C3112bn.m19040o(str)) {
                List<String> m18785d = m18785d();
                int size = m18785d.size();
                if (m18785d.contains(str)) {
                    boolean z2 = false;
                    for (int i = 0; i < size - 1; i++) {
                        if (m18785d.get(i).equals(str)) {
                            z2 = true;
                        }
                        if (z2) {
                            this.f18185f.putString(new StringBuffer().append("item_").append(i).toString(), m18785d.get(i + 1));
                        }
                    }
                    this.f18185f.putString(new StringBuffer().append("item_").append(size - 1).toString(), str);
                    z = this.f18185f.commit();
                } else if (size < 300) {
                    this.f18185f.putString(new StringBuffer().append("item_").append(size).toString(), str);
                    z = this.f18185f.commit();
                } else {
                    this.f18185f.putString(new StringBuffer().append("item_").append(299).toString(), str);
                    for (int i2 = 0; i2 < 299; i2++) {
                        this.f18185f.putString(new StringBuffer().append("item_").append(i2).toString(), m18785d.get(i2 + 1));
                    }
                    z = this.f18185f.commit();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m18779a(int i, int i2) {
        String string;
        String string2;
        string = this.f18184e.getString(new StringBuffer().append("item_").append(i).toString(), (String) null);
        string2 = this.f18184e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
        return (string == null || string2 == null) ? false : this.f18185f.putString(new StringBuffer().append("item_").append(i).toString(), string2).putString(new StringBuffer().append("item_").append(i2).toString(), string).commit();
    }

    /* renamed from: b */
    public synchronized boolean m18783b(String str) {
        boolean z = false;
        int i = 0;
        z = false;
        synchronized (this) {
            List<String> m18785d = m18785d();
            if (!m18785d.isEmpty() && m18785d.contains(str)) {
                m18785d.remove(str);
                this.f18185f.clear();
                while (true) {
                    int i2 = i;
                    if (i2 >= m18785d.size()) {
                        break;
                    }
                    this.f18185f.putString(new StringBuffer().append("item_").append(i2).toString(), m18785d.get(i2));
                    i = i2 + 1;
                }
                z = this.f18185f.commit();
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m18780a(int i, String str) {
        this.f18185f.putString(new StringBuffer().append("item_").append(i).toString(), str);
        return this.f18185f.commit();
    }

    /* renamed from: g */
    public boolean m18788g() {
        return this.f18185f.clear().commit();
    }

    /* renamed from: h */
    public void m18789h() {
        m18788g();
        for (String str : C3249i.f19542b) {
            m18777a(str, str);
        }
        m18782b();
    }

    /* renamed from: a */
    public void m18778a(C2466a c2466a) {
        m18788g();
        for (int i = 0; i < c2466a.m15569a(); i++) {
            try {
                String m15579f = c2466a.m15579f(i);
                m18777a(m15579f, m15579f);
            } catch (C2467b e2) {
            }
        }
        m18782b();
    }

    /* renamed from: c */
    public static a m18774c(String str) {
        if (str == null || str.isEmpty()) {
            return (a) null;
        }
        if (m18775d(str)) {
            try {
                C2468c c2468c = new C2468c(str);
                String m15617f = c2468c.m15617f("n");
                return new a(m15617f, c2468c.m15604a("v", m15617f));
            } catch (C2467b e2) {
                return new a(str, str);
            }
        }
        return new a(str, str);
    }

    /* renamed from: a */
    public static String m18773a(a aVar) {
        try {
            C2468c c2468c = new C2468c();
            c2468c.m15608a("n", (Object) aVar.m18790a());
            c2468c.m15608a("v", (Object) aVar.m18791b());
            return c2468c.toString();
        } catch (C2467b e2) {
            return (String) null;
        }
    }

    /* renamed from: d */
    private static boolean m18775d(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return trim.startsWith("{") && trim.endsWith("}");
    }

    /* compiled from: QuickPanelUtils.java */
    /* renamed from: ru.maximoff.apktool.util.ay$a */
    public static class a {

        /* renamed from: a */
        private final String f18186a;

        /* renamed from: b */
        private final String f18187b;

        public a(String str, String str2) {
            this.f18186a = str;
            this.f18187b = str2;
        }

        /* renamed from: a */
        public String m18790a() {
            return this.f18186a;
        }

        /* renamed from: b */
        public String m18791b() {
            return this.f18187b;
        }
    }
}
