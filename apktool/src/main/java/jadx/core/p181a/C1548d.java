package jadx.core.p181a;

import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p203d.C1744m;
import jadx.core.p203d.p206c.C1731a;
import jadx.core.p203d.p206c.C1734d;
import jadx.p180a.C1533a;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: CodeWriter.java */
/* renamed from: jadx.core.a.d */
/* loaded from: classes.dex */
public class C1548d {

    /* renamed from: e */
    private String f9915e;

    /* renamed from: b */
    private static final InterfaceC2558b f9912b = C2568c.m15995a((Class<?>) C1548d.class);

    /* renamed from: a */
    public static final String f9911a = System.getProperty("line.separator");

    /* renamed from: c */
    private static final String[] f9913c = {"", "    ", "        ", "            ", "                ", "                    "};

    /* renamed from: d */
    private StringBuilder f9914d = new StringBuilder();

    /* renamed from: h */
    private int f9918h = 1;

    /* renamed from: i */
    private int f9919i = 0;

    /* renamed from: j */
    private Map<C1533a, Object> f9920j = Collections.emptyMap();

    /* renamed from: k */
    private Map<Integer, Integer> f9921k = Collections.emptyMap();

    /* renamed from: g */
    private int f9917g = 0;

    /* renamed from: f */
    private String f9916f = "";

    /* renamed from: a */
    public C1548d m11882a() {
        m11878k();
        m11879l();
        return this;
    }

    /* renamed from: a */
    public C1548d m11883a(char c2) {
        m11878k();
        m11879l();
        m11893b(c2);
        return this;
    }

    /* renamed from: a */
    public C1548d m11886a(String str) {
        m11878k();
        m11879l();
        m11897c(str);
        return this;
    }

    /* renamed from: a */
    public C1548d m11884a(int i) {
        if (i == 0) {
            m11882a();
        } else {
            m11882a();
            m11902e(i);
        }
        return this;
    }

    /* renamed from: b */
    public C1548d m11894b(String str) {
        this.f9914d.append(str);
        if (str.contains(f9911a)) {
            this.f9918h += C1744m.m13303a(str, f9911a);
            this.f9919i = 0;
        }
        return this;
    }

    /* renamed from: c */
    public C1548d m11897c(String str) {
        this.f9914d.append(str);
        this.f9919i += str.length();
        return this;
    }

    /* renamed from: b */
    public C1548d m11893b(char c2) {
        this.f9914d.append(c2);
        this.f9919i++;
        return this;
    }

    /* renamed from: a */
    C1548d m11885a(C1548d c1548d) {
        this.f9918h--;
        for (Map.Entry<C1533a, Object> entry : c1548d.f9920j.entrySet()) {
            C1533a key = entry.getKey();
            m11876a(entry.getValue(), new C1533a(this.f9918h + key.m11754a(), key.m11755b()));
        }
        for (Map.Entry<Integer, Integer> entry2 : c1548d.f9921k.entrySet()) {
            m11877a(entry2.getKey().intValue() + this.f9918h, entry2.getValue().intValue());
        }
        this.f9918h += c1548d.f9918h;
        this.f9919i = c1548d.f9919i;
        this.f9914d.append((CharSequence) c1548d.f9914d);
        return this;
    }

    /* renamed from: b */
    public C1548d m11892b() {
        m11878k();
        return this;
    }

    /* renamed from: c */
    public C1548d m11896c() {
        m11897c("    ");
        return this;
    }

    /* renamed from: k */
    private void m11878k() {
        this.f9914d.append(f9911a);
        this.f9918h++;
        this.f9919i = 0;
    }

    /* renamed from: l */
    private C1548d m11879l() {
        this.f9914d.append(this.f9916f);
        this.f9919i += this.f9916f.length();
        return this;
    }

    /* renamed from: m */
    private void m11880m() {
        int i = this.f9917g;
        if (i < f9913c.length) {
            this.f9916f = f9913c[i];
            return;
        }
        StringBuilder sb = new StringBuilder("    ".length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("    ");
        }
        this.f9916f = sb.toString();
    }

    /* renamed from: d */
    public void m11899d() {
        m11895b(1);
    }

    /* renamed from: e */
    public void m11901e() {
        m11898c(1);
    }

    /* renamed from: b */
    public void m11895b(int i) {
        this.f9917g += i;
        m11880m();
    }

    /* renamed from: c */
    public void m11898c(int i) {
        this.f9917g -= i;
        if (this.f9917g < 0) {
            f9912b.mo15941c("Indent < 0");
            this.f9917g = 0;
        }
        m11880m();
    }

    /* renamed from: f */
    public int m11903f() {
        return this.f9917g;
    }

    /* renamed from: d */
    public void m11900d(int i) {
        this.f9917g = i;
        m11880m();
    }

    /* renamed from: g */
    public int m11904g() {
        return this.f9918h;
    }

    /* compiled from: CodeWriter.java */
    /* renamed from: jadx.core.a.d$a */
    private static class a {

        /* renamed from: a */
        private final AbstractC1577k f9922a;

        private a(AbstractC1577k abstractC1577k) {
            this.f9922a = abstractC1577k;
        }

        /* synthetic */ a(AbstractC1577k abstractC1577k, a aVar) {
            this(abstractC1577k);
        }

        /* renamed from: a */
        public AbstractC1577k m11908a() {
            return this.f9922a;
        }
    }

    /* renamed from: a */
    public void m11887a(AbstractC1577k abstractC1577k) {
        m11891a((Object) abstractC1577k);
        m11876a(new a(abstractC1577k, null), new C1533a(this.f9918h, this.f9919i));
    }

    /* renamed from: a */
    public void m11891a(Object obj) {
        m11876a(obj, new C1533a(this.f9918h, this.f9919i + 1));
    }

    /* renamed from: a */
    private Object m11876a(Object obj, C1533a c1533a) {
        if (this.f9920j.isEmpty()) {
            this.f9920j = new HashMap();
        }
        return this.f9920j.put(c1533a, obj);
    }

    /* renamed from: e */
    public void m11902e(int i) {
        if (i != 0) {
            m11877a(this.f9918h, i);
        }
    }

    /* renamed from: a */
    private void m11877a(int i, int i2) {
        if (this.f9921k.isEmpty()) {
            this.f9921k = new TreeMap();
        }
        this.f9921k.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: h */
    public void m11905h() {
        m11881n();
        this.f9914d.trimToSize();
        this.f9915e = this.f9914d.toString();
        this.f9914d = null;
        Iterator<Map.Entry<C1533a, Object>> it = this.f9920j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<C1533a, Object> next = it.next();
            Object value = next.getValue();
            if (value instanceof a) {
                ((a) value).m11908a().m12121b(next.getKey().m11754a());
                it.remove();
            }
        }
    }

    /* renamed from: n */
    private void m11881n() {
        int length = f9911a.length();
        if (this.f9914d.substring(0, length).equals(f9911a)) {
            this.f9914d.delete(0, length);
        }
    }

    /* renamed from: i */
    public int m11906i() {
        return this.f9914d.length();
    }

    /* renamed from: j */
    public String m11907j() {
        return this.f9915e;
    }

    public String toString() {
        return this.f9914d == null ? this.f9915e : this.f9914d.toString();
    }

    /* renamed from: a */
    public void m11890a(File file, String str, String str2) {
        if (C1734d.m13251a(str) && C1734d.m13251a(str2)) {
            m11889a(file, new File(str, str2).getPath());
        }
    }

    /* renamed from: a */
    public void m11889a(File file, String str) {
        if (C1734d.m13251a(str)) {
            m11888a(new File(file, str));
        }
    }

    /* renamed from: a */
    public void m11888a(File file) {
        if (this.f9915e == null) {
            m11905h();
        }
        try {
            PrintWriter printWriter = new PrintWriter(C1731a.m13231c(file), "UTF-8");
            printWriter.println(this.f9915e);
            printWriter.close();
        } catch (Exception e2) {
            f9912b.mo15938b("Save file error", (Throwable) e2);
        }
    }
}
