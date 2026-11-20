package ru.maximoff.apktool.util.p303a;

import java.p209io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p270e.C2466a;
import org.p270e.C2468c;

/* compiled from: ChangedIDs.java */
/* renamed from: ru.maximoff.apktool.util.a.b */
/* loaded from: classes.dex */
public class C3062b {

    /* renamed from: a */
    private File f17219a;

    /* renamed from: b */
    private C2468c f17220b = m18336a();

    /* renamed from: c */
    private String f17221c;

    public C3062b(File file) {
        this.f17219a = file;
    }

    /* renamed from: a */
    public void m18338a(String str) {
        this.f17221c = str;
    }

    /* renamed from: a */
    public C2468c m18336a() {
        return m18337a(this.f17219a);
    }

    /* renamed from: a */
    public C2468c m18337a(File file) {
        if (file.isFile()) {
            try {
                return new C2468c(C3061a.m18332i(file));
            } catch (Exception e2) {
            }
        }
        return new C2468c();
    }

    /* renamed from: b */
    public boolean m18340b() {
        if (this.f17220b.m15614d() == 0) {
            return false;
        }
        try {
            C3061a.m18319b(this.f17219a, this.f17220b.m15603a(2));
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m18341b(File file) {
        C2466a c2466a;
        C2468c m18337a = m18337a(file);
        if (m18337a.m15614d() <= 0) {
            return false;
        }
        Iterator<String> m15605a = m18337a.m15605a();
        while (m15605a.hasNext()) {
            try {
                String next = m15605a.next();
                if (this.f17220b.m15618g(next)) {
                    c2466a = this.f17220b.m15615d(next);
                } else {
                    c2466a = new C2466a();
                }
                C2466a m15615d = m18337a.m15615d(next);
                for (int i = 0; i < m15615d.m15569a(); i++) {
                    String m15579f = m15615d.m15579f(i);
                    if (m18335a(c2466a, new StringBuffer().append(m15579f.split(" -> ")[0]).append(" -> ").toString()) == -1) {
                        c2466a.m15574a(m15579f);
                    }
                }
                if (c2466a.m15569a() > 0) {
                    this.f17220b.m15608a(next, c2466a);
                }
            } catch (Exception e2) {
            }
        }
        return m18340b();
    }

    /* renamed from: a */
    public boolean m18339a(int i, int i2) {
        C2466a c2466a;
        if (this.f17220b.m15618g(this.f17221c)) {
            try {
                c2466a = this.f17220b.m15615d(this.f17221c);
            } catch (Exception e2) {
                c2466a = new C2466a();
            }
        } else {
            c2466a = new C2466a();
        }
        try {
            String format = String.format("%08x -> %08x", new Integer(i), new Integer(i2));
            if (m18335a(c2466a, String.format("%08x -> ", new Integer(i))) == -1) {
                c2466a.m15574a(format);
                this.f17220b.m15608a(this.f17221c, c2466a);
                return true;
            }
        } catch (Exception e3) {
        }
        return false;
    }

    /* renamed from: c */
    public Map<Long, Long> m18342c() {
        HashMap hashMap = new HashMap();
        if (this.f17220b.m15614d() == 0) {
            return hashMap;
        }
        Iterator<String> m15605a = this.f17220b.m15605a();
        while (m15605a.hasNext()) {
            try {
                C2466a m15615d = this.f17220b.m15615d(m15605a.next());
                for (int i = 0; i < m15615d.m15569a(); i++) {
                    String[] split = m15615d.m15579f(i).split(" -> ");
                    hashMap.put(new Long(Long.parseLong(split[0].trim(), 16)), new Long(Long.parseLong(split[1].trim(), 16)));
                }
            } catch (Exception e2) {
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public Map<Long, Long> m18343d() {
        HashMap hashMap = new HashMap();
        if (this.f17220b.m15614d() == 0) {
            return hashMap;
        }
        Iterator<String> m15605a = this.f17220b.m15605a();
        while (m15605a.hasNext()) {
            try {
                C2466a m15615d = this.f17220b.m15615d(m15605a.next());
                for (int i = 0; i < m15615d.m15569a(); i++) {
                    String[] split = m15615d.m15579f(i).split(" -> ");
                    hashMap.put(new Long(Long.parseLong(split[1].trim(), 16)), new Long(Long.parseLong(split[0].trim(), 16)));
                }
            } catch (Exception e2) {
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private int m18335a(C2466a c2466a, String str) {
        for (int i = 0; i < c2466a.m15569a(); i++) {
            if (c2466a.m15579f(i).startsWith(str)) {
                return i;
            }
        }
        return -1;
    }
}
