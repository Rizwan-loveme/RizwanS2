package jadx.core.p182b;

import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import java.p209io.File;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p217b.p218a.p219a.C1882b;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: DeobfPresets.java */
/* renamed from: jadx.core.b.b */
/* loaded from: classes.dex */
class C1557b {

    /* renamed from: a */
    private static final InterfaceC2558b f9956a = C2568c.m15995a((Class<?>) C1557b.class);

    /* renamed from: b */
    private final C1558c f9957b;

    /* renamed from: c */
    private final File f9958c;

    /* renamed from: d */
    private final Map<String, String> f9959d = new HashMap();

    /* renamed from: e */
    private final Map<String, String> f9960e = new HashMap();

    /* renamed from: f */
    private final Map<String, String> f9961f = new HashMap();

    public C1557b(C1558c c1558c, File file) {
        this.f9957b = c1558c;
        this.f9958c = file;
    }

    /* renamed from: a */
    public void m12021a() {
        if (this.f9958c.exists()) {
            f9956a.mo15936b("Loading obfuscation map from: {}", this.f9958c.getAbsoluteFile());
            try {
                Iterator<String> it = C1882b.m13944a(this.f9958c, "UTF-8").iterator();
                while (it.hasNext()) {
                    String trim = it.next().trim();
                    if (!trim.isEmpty() && !trim.startsWith("#")) {
                        String[] m12016a = m12016a(trim);
                        if (m12016a.length == 2) {
                            String str = m12016a[0];
                            String str2 = m12016a[1];
                            if (trim.startsWith("p ")) {
                                this.f9957b.m12054a(str, str2);
                            } else if (trim.startsWith("c ")) {
                                this.f9959d.put(str, str2);
                            } else if (trim.startsWith("f ")) {
                                this.f9960e.put(str, str2);
                            } else if (trim.startsWith("m ")) {
                                this.f9961f.put(str, str2);
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                f9956a.mo15943c("Failed to load deobfuscation map file '{}'", this.f9958c.getAbsolutePath(), e2);
            }
        }
    }

    /* renamed from: a */
    private static String[] m12016a(String str) {
        String[] split = str.substring(2).split("=");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return split;
    }

    /* renamed from: a */
    public void m12022a(boolean z) {
        try {
            if (this.f9958c.exists()) {
                if (z) {
                    m12017f();
                } else {
                    f9956a.mo15942c("Deobfuscation map file '{}' exists. Use command line option '--deobf-rewrite-cfg' to rewrite it", this.f9958c.getAbsolutePath());
                }
            } else {
                m12017f();
            }
        } catch (IOException e2) {
            f9956a.mo15943c("Failed to load deobfuscation map file '{}'", this.f9958c.getAbsolutePath(), e2);
        }
    }

    /* renamed from: f */
    private void m12017f() {
        ArrayList arrayList = new ArrayList();
        for (C1561f c1561f : this.f9957b.m12061f().m12078g()) {
            Iterator<C1561f> it = c1561f.m12078g().iterator();
            while (it.hasNext()) {
                m12015a(arrayList, c1561f.m12069a(), it.next());
            }
            if (c1561f.m12075d()) {
                arrayList.add(String.format("p %s = %s", c1561f.m12069a(), c1561f.m12074c()));
            }
        }
        for (C1556a c1556a : this.f9957b.m12058c().values()) {
            if (c1556a.m12014d() != null) {
                arrayList.add(String.format("c %s = %s", c1556a.m12013c().m12544x().m12202d(), c1556a.m12014d()));
            }
        }
        for (C1592d c1592d : this.f9957b.m12059d().keySet()) {
            arrayList.add(String.format("f %s = %s", c1592d.m12230e(), c1592d.m12229d()));
        }
        for (C1594f c1594f : this.f9957b.m12060e().keySet()) {
            arrayList.add(String.format("m %s = %s", c1594f.m12242b(), c1594f.m12251j()));
        }
        Collections.sort(arrayList);
        C1882b.m13946a(this.f9958c, "UTF-8", arrayList);
        arrayList.clear();
    }

    /* renamed from: a */
    private static void m12015a(List<String> list, String str, C1561f c1561f) {
        Iterator<C1561f> it = c1561f.m12078g().iterator();
        while (it.hasNext()) {
            m12015a(list, String.valueOf(str) + '.' + c1561f.m12069a(), it.next());
        }
        if (c1561f.m12075d()) {
            list.add(String.format("p %s.%s = %s", str, c1561f.m12069a(), c1561f.m12074c()));
        }
    }

    /* renamed from: a */
    public String m12018a(C1590b c1590b) {
        return this.f9959d.get(c1590b.m12202d());
    }

    /* renamed from: a */
    public String m12019a(C1592d c1592d) {
        return this.f9960e.get(c1592d.m12230e());
    }

    /* renamed from: a */
    public String m12020a(C1594f c1594f) {
        return this.f9961f.get(c1594f.m12242b());
    }

    /* renamed from: b */
    public void m12023b() {
        this.f9959d.clear();
        this.f9960e.clear();
        this.f9961f.clear();
    }

    /* renamed from: c */
    public Map<String, String> m12024c() {
        return this.f9959d;
    }

    /* renamed from: d */
    public Map<String, String> m12025d() {
        return this.f9960e;
    }

    /* renamed from: e */
    public Map<String, String> m12026e() {
        return this.f9961f;
    }
}
