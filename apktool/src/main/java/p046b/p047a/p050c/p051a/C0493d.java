package p046b.p047a.p050c.p051a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ResResSpec.java */
/* renamed from: b.a.c.a.d */
/* loaded from: classes.dex */
public class C0493d {

    /* renamed from: a */
    private final C0491b f3427a;

    /* renamed from: b */
    private final C0492c f3428b;

    /* renamed from: c */
    private final C0497h f3429c;

    /* renamed from: d */
    private final int f3430d;

    /* renamed from: e */
    private final int f3431e;

    /* renamed from: f */
    private final Map<C0468a, C0494e> f3432f;

    /* renamed from: g */
    private final InterfaceC0541f f3433g;

    /* renamed from: h */
    private final Set<String> f3434h;

    /* renamed from: i */
    private String f3435i;

    public C0493d(C0491b c0491b, String str, int i, C0492c c0492c, int i2, C0497h c0497h, int i3, InterfaceC0541f interfaceC0541f) {
        this(c0491b, str, i, c0492c, i2, c0497h, i3, interfaceC0541f, false);
    }

    public C0493d(C0491b c0491b, String str, int i, C0492c c0492c, int i2, C0497h c0497h, int i3, InterfaceC0541f interfaceC0541f, boolean z) {
        String stringBuffer;
        Pattern compile;
        this.f3432f = new LinkedHashMap();
        this.f3434h = new HashSet(Arrays.asList("0_resource_name_obfuscated", "(name removed)"));
        this.f3433g = interfaceC0541f;
        this.f3427a = c0491b;
        this.f3430d = i;
        this.f3431e = i3;
        C0493d m3739a = c0497h.m3739a(str);
        String c0497h2 = c0497h.toString();
        String format = String.format("%s_%s", c0497h2.replaceAll("[^a-zA-Z0-9]", ""), c0491b.toString().substring(2));
        if (m3739a != null || C3112bn.m19040o(str) || this.f3434h.contains(str)) {
            str = format;
        } else if (!m3690b(str)) {
            if (c0497h2.equals(C0497h.f3457a) || c0497h2.equals("^attr-private")) {
                compile = Pattern.compile("[^A-Za-z0-9_-]");
            } else if (c0497h.m3746d()) {
                compile = Pattern.compile("[^A-Za-z0-9_\\$\\.]");
            } else {
                compile = Pattern.compile("[^A-Za-z0-9_\\$\\.-]");
            }
            if (compile.matcher(str).find() || ((c0497h2.equals(C0497h.f3457a) || c0497h2.equals("^attr-private")) && !C3112bn.m19012a(str.charAt(0)))) {
                str = format;
            }
        }
        String stringBuffer2 = (m3690b(str) || str.equals(format) || i2 <= 1 || !(i3 == 1 || i3 == 3) || c0491b.f3413a == 127 || c0491b.f3413a <= 1 || c0492c.m3679h().equals("android")) ? str : new StringBuffer().append(str).append(new StringBuffer().append("_").append(c0491b.toString().substring(2)).toString()).toString();
        if ((z || c0497h.m3746d()) && c0497h.m3744b(stringBuffer2)) {
            int i4 = 1;
            stringBuffer = new StringBuffer().append(new StringBuffer().append(stringBuffer2).append("_").toString()).append(1).toString();
            while (c0497h.m3744b(stringBuffer)) {
                i4++;
                stringBuffer = new StringBuffer().append(new StringBuffer().append(stringBuffer2).append("_").toString()).append(i4).toString();
            }
        } else {
            stringBuffer = stringBuffer2;
        }
        this.f3435i = stringBuffer;
        this.f3428b = c0492c;
        this.f3429c = c0497h;
    }

    /* renamed from: a */
    public Set<C0494e> m3685a() {
        return new LinkedHashSet(this.f3432f.values());
    }

    /* renamed from: a */
    public C0494e m3682a(C0468a c0468a) {
        C0494e c0494e = this.f3432f.get(c0468a);
        if (c0494e == null) {
            throw new C0460e(String.format("resource: spec=%s, config=%s", this, c0468a));
        }
        return c0494e;
    }

    /* renamed from: b */
    public C0494e m3689b() {
        return m3682a(new C0468a(this.f3433g));
    }

    /* renamed from: c */
    public boolean m3691c() {
        return this.f3432f.containsKey(new C0468a(this.f3433g));
    }

    /* renamed from: a */
    public String m3684a(boolean z, boolean z2) {
        return new StringBuffer().append(new StringBuffer().append((z || this.f3431e == 3) ? "" : new StringBuffer().append(m3694f().m3679h()).append(":").toString()).append(z2 ? "" : new StringBuffer().append(m3695g().m3740a()).append("/").toString()).toString()).append(m3693e()).toString();
    }

    /* renamed from: a */
    public String m3683a(C0492c c0492c, boolean z) {
        return m3684a(m3694f().equals(c0492c), z);
    }

    /* renamed from: d */
    public C0491b m3692d() {
        return this.f3427a;
    }

    /* renamed from: e */
    public String m3693e() {
        return C0500k.m3753a(this.f3435i, "\"", "q");
    }

    /* renamed from: a */
    public void m3688a(String str) {
        this.f3435i = str;
    }

    /* renamed from: f */
    public C0492c m3694f() {
        return this.f3428b;
    }

    /* renamed from: g */
    public C0497h m3695g() {
        return this.f3429c;
    }

    /* renamed from: h */
    public boolean m3696h() {
        return m3690b(m3693e());
    }

    /* renamed from: b */
    public boolean m3690b(String str) {
        return str.startsWith("APKTOOL_DUMMY_");
    }

    /* renamed from: a */
    public void m3686a(C0494e c0494e) {
        m3687a(c0494e, false);
    }

    /* renamed from: a */
    public void m3687a(C0494e c0494e, boolean z) {
        C0468a m3735a = c0494e.m3699b().m3735a();
        if (this.f3432f.put(m3735a, c0494e) != null && !z) {
            throw new C0461b(String.format("Multiple resources: spec=%s, config=%s", this, m3735a));
        }
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f3427a.toString()).append(" ").toString()).append(this.f3429c.toString()).toString()).append("/").toString()).append(this.f3435i).toString();
    }
}
