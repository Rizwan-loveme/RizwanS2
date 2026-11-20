package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;

/* compiled from: BookmarksUtils.java */
/* renamed from: ru.maximoff.apktool.util.f */
/* loaded from: classes.dex */
public class C3220f {

    /* renamed from: a */
    private final String f19289a = "bookmarks";

    /* renamed from: b */
    private final int f19290b = 300;

    /* renamed from: c */
    private InterfaceC2995n f19291c;

    /* renamed from: d */
    private Context f19292d;

    /* renamed from: e */
    private List<String> f19293e;

    /* renamed from: f */
    private SharedPreferences f19294f;

    /* renamed from: g */
    private SharedPreferences.Editor f19295g;

    public C3220f(Context context, InterfaceC2995n interfaceC2995n) {
        this.f19292d = context;
        this.f19291c = interfaceC2995n;
        this.f19294f = context.getSharedPreferences("bookmarks", 0);
        this.f19295g = this.f19294f.edit();
        m19295c();
    }

    /* renamed from: a */
    public String m19287a() {
        return "bookmarks";
    }

    /* renamed from: b */
    public void m19292b() {
        C3216e c3216e = new C3216e(this.f19292d, this.f19291c, this);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f19292d).m418a(R.string.bookmarks).m435b(c3216e).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
        m438b.show();
        c3216e.setDialog(m438b);
    }

    /* renamed from: c */
    public List<String> m19295c() {
        this.f19293e = m19299e();
        return this.f19293e;
    }

    /* renamed from: a */
    public boolean m19290a(File file) {
        return this.f19293e.contains(file.getAbsolutePath());
    }

    /* renamed from: a */
    public boolean m19291a(String str) {
        return this.f19293e.contains(str);
    }

    /* renamed from: d */
    public boolean m19298d() {
        return this.f19293e.isEmpty();
    }

    /* renamed from: e */
    public synchronized List<String> m19299e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 300) {
                String string = this.f19294f.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    arrayList.add(string);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public synchronized Map<Integer, String> m19300f() {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 300) {
                String string = this.f19294f.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    linkedHashMap.put(new Integer(i2), string);
                }
                i = i2 + 1;
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    public boolean m19293b(File file) {
        return m19294b(file.getAbsolutePath());
    }

    /* renamed from: b */
    public synchronized boolean m19294b(String str) {
        boolean z = false;
        synchronized (this) {
            if (!C3112bn.m19040o(str)) {
                List<String> m19299e = m19299e();
                int size = m19299e.size();
                if (m19299e.contains(str)) {
                    boolean z2 = false;
                    for (int i = 0; i < size - 1; i++) {
                        if (m19299e.get(i).equals(str)) {
                            z2 = true;
                        }
                        if (z2) {
                            this.f19295g.putString(new StringBuffer().append("item_").append(i).toString(), m19299e.get(i + 1));
                        }
                    }
                    this.f19295g.putString(new StringBuffer().append("item_").append(size - 1).toString(), str);
                    z = this.f19295g.commit();
                } else if (size < 300) {
                    this.f19295g.putString(new StringBuffer().append("item_").append(size).toString(), str);
                    z = this.f19295g.commit();
                } else {
                    this.f19295g.putString(new StringBuffer().append("item_").append(299).toString(), str);
                    for (int i2 = 0; i2 < 299; i2++) {
                        this.f19295g.putString(new StringBuffer().append("item_").append(i2).toString(), m19299e.get(i2 + 1));
                    }
                    z = this.f19295g.commit();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m19288a(int i, int i2) {
        String string;
        String string2;
        string = this.f19294f.getString(new StringBuffer().append("item_").append(i).toString(), (String) null);
        string2 = this.f19294f.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
        return (string == null || string2 == null) ? false : this.f19295g.putString(new StringBuffer().append("item_").append(i).toString(), string2).putString(new StringBuffer().append("item_").append(i2).toString(), string).commit();
    }

    /* renamed from: c */
    public boolean m19296c(File file) {
        return m19297c(file.getAbsolutePath());
    }

    /* renamed from: c */
    public synchronized boolean m19297c(String str) {
        boolean z = false;
        int i = 0;
        z = false;
        synchronized (this) {
            List<String> m19299e = m19299e();
            if (!m19299e.isEmpty() && m19299e.contains(str)) {
                m19299e.remove(str);
                this.f19295g.clear();
                while (true) {
                    int i2 = i;
                    if (i2 >= m19299e.size()) {
                        break;
                    }
                    this.f19295g.putString(new StringBuffer().append("item_").append(i2).toString(), m19299e.get(i2));
                    i = i2 + 1;
                }
                z = this.f19295g.commit();
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m19289a(int i, String str) {
        this.f19295g.putString(new StringBuffer().append("item_").append(i).toString(), str);
        return this.f19295g.commit();
    }

    /* renamed from: d */
    public static a m19285d(String str) {
        if (str == null || str.isEmpty()) {
            return (a) null;
        }
        if (m19286e(str)) {
            try {
                C2468c c2468c = new C2468c(str);
                String m15617f = c2468c.m15617f("p");
                return new a(c2468c.m15604a("n", new File(m15617f).getName()), m15617f);
            } catch (C2467b e2) {
                return new a(new File(str).getName(), str);
            }
        }
        return new a(new File(str).getName(), str);
    }

    /* renamed from: a */
    public static String m19284a(a aVar) {
        try {
            C2468c c2468c = new C2468c();
            c2468c.m15608a("p", (Object) aVar.m19302b());
            c2468c.m15608a("n", (Object) aVar.m19301a());
            return c2468c.toString();
        } catch (C2467b e2) {
            return (String) null;
        }
    }

    /* renamed from: e */
    private static boolean m19286e(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return trim.startsWith("{") && trim.endsWith("}");
    }

    /* compiled from: BookmarksUtils.java */
    /* renamed from: ru.maximoff.apktool.util.f$a */
    public static class a {

        /* renamed from: a */
        private final String f19296a;

        /* renamed from: b */
        private final String f19297b;

        public a(String str, String str2) {
            this.f19296a = str;
            this.f19297b = str2;
        }

        /* renamed from: a */
        public String m19301a() {
            return this.f19296a;
        }

        /* renamed from: b */
        public String m19302b() {
            return this.f19297b;
        }
    }
}
