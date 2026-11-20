package p046b.p047a.p050c.p051a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.XMLConstants;
import p046b.p047a.C0461b;

/* compiled from: ResTypeSpec.java */
/* renamed from: b.a.c.a.h */
/* loaded from: classes.dex */
public final class C0497h {

    /* renamed from: a */
    public static final String f3457a = "attr";

    /* renamed from: c */
    private final String f3459c;

    /* renamed from: e */
    private final C0495f f3461e;

    /* renamed from: f */
    private final C0492c f3462f;

    /* renamed from: g */
    private final int f3463g;

    /* renamed from: h */
    private final int f3464h;

    /* renamed from: b */
    private final String[] f3458b = {"^attr-private", "anim", "animator", "array", f3457a, "bool", "color", "dimen", "drawable", "fraction", "id", "integer", "interpolator", "layout", "menu", "mipmap", "plurals", "raw", "string", "style", "transition", XMLConstants.XML_NS_PREFIX};

    /* renamed from: d */
    private final Map<String, C0493d> f3460d = new LinkedHashMap();

    public C0497h(String str, C0495f c0495f, C0492c c0492c, int i, int i2) {
        this.f3459c = str;
        this.f3461e = c0495f;
        this.f3462f = c0492c;
        this.f3463g = i;
        this.f3464h = i2;
    }

    /* renamed from: a */
    public String m3740a() {
        return this.f3459c;
    }

    /* renamed from: b */
    public int m3742b() {
        return this.f3463g;
    }

    /* renamed from: c */
    public boolean m3745c() {
        return this.f3459c.equalsIgnoreCase("string");
    }

    /* renamed from: d */
    public boolean m3746d() {
        return (this.f3459c.equalsIgnoreCase("string") || this.f3459c.equalsIgnoreCase("array") || this.f3459c.equalsIgnoreCase("plurals") || this.f3459c.equalsIgnoreCase("style") || this.f3459c.equalsIgnoreCase("dimen") || this.f3459c.equalsIgnoreCase("bool") || this.f3459c.equalsIgnoreCase("integer") || this.f3459c.equalsIgnoreCase("fraction") || this.f3459c.equalsIgnoreCase(f3457a) || this.f3459c.equalsIgnoreCase("^attr-private") || this.f3459c.equalsIgnoreCase("id")) ? false : true;
    }

    /* renamed from: a */
    public C0493d m3739a(String str) {
        return this.f3460d.get(str);
    }

    /* renamed from: a */
    public void m3741a(C0493d c0493d) {
        this.f3460d.remove(c0493d.m3693e());
    }

    /* renamed from: b */
    public void m3743b(C0493d c0493d) {
        if (this.f3460d.put(c0493d.m3693e(), c0493d) != null) {
            throw new C0461b(String.format("Multiple res specs: %s/%s", m3740a(), c0493d.m3693e()));
        }
    }

    /* renamed from: b */
    public boolean m3744b(String str) {
        Iterator<String> it = this.f3460d.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f3459c;
    }
}
