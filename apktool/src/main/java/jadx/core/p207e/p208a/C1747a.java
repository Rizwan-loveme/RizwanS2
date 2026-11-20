package jadx.core.p207e.p208a;

/* compiled from: EntryConfig.java */
/* renamed from: jadx.core.e.a.a */
/* loaded from: classes.dex */
public class C1747a {

    /* renamed from: a */
    private String f10609a;

    /* renamed from: b */
    private String f10610b;

    /* renamed from: c */
    private String f10611c;

    /* renamed from: d */
    private String f10612d;

    /* renamed from: e */
    private String f10613e;

    /* renamed from: f */
    private String f10614f;

    /* renamed from: g */
    private String f10615g;

    /* renamed from: h */
    private String f10616h;

    /* renamed from: i */
    private String f10617i;

    /* renamed from: j */
    private String f10618j;

    /* renamed from: a */
    public void m13322a(String str) {
        this.f10609a = str;
    }

    /* renamed from: b */
    public void m13323b(String str) {
        this.f10610b = str;
    }

    /* renamed from: a */
    public String m13321a() {
        StringBuilder sb = new StringBuilder();
        if (this.f10612d != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10612d);
        } else if (this.f10618j != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10618j);
        } else if (this.f10617i != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10617i);
        } else if (this.f10614f != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10614f);
        } else if (this.f10615g != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10615g);
        } else if (this.f10611c != null) {
            sb.append(this.f10611c);
        }
        if (this.f10609a != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10609a);
        }
        if (this.f10610b != null) {
            sb.append("-r").append(this.f10610b);
        }
        if (this.f10616h != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10616h);
        }
        if (this.f10613e != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(this.f10613e);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public void m13324c(String str) {
        this.f10611c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m13321a());
        if (sb.length() != 0) {
            sb.insert(0, " [");
            sb.append(']');
        }
        return sb.toString();
    }

    /* renamed from: d */
    public void m13325d(String str) {
        this.f10612d = str;
    }

    /* renamed from: e */
    public void m13326e(String str) {
        this.f10613e = str;
    }

    /* renamed from: f */
    public void m13327f(String str) {
        this.f10614f = str;
    }

    /* renamed from: g */
    public void m13328g(String str) {
        this.f10615g = str;
    }

    /* renamed from: h */
    public void m13329h(String str) {
        this.f10616h = str;
    }

    /* renamed from: i */
    public void m13330i(String str) {
        this.f10617i = str;
    }

    /* renamed from: j */
    public void m13331j(String str) {
        this.f10618j = str;
    }
}
