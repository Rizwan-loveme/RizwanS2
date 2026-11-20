package p165d.p167b.p173f;

/* compiled from: X509AttributeName.java */
/* renamed from: d.b.f.bo */
/* loaded from: classes.dex */
public class C1497bo {

    /* renamed from: a */
    private String f9571a;

    /* renamed from: b */
    private String f9572b;

    public C1497bo(String str) {
        this.f9571a = null;
        this.f9572b = null;
        int indexOf = str.indexOf(46);
        if (indexOf < 0) {
            this.f9571a = str;
        } else {
            this.f9571a = str.substring(0, indexOf);
            this.f9572b = str.substring(indexOf + 1);
        }
    }

    /* renamed from: a */
    public String m11568a() {
        return this.f9571a;
    }

    /* renamed from: b */
    public String m11569b() {
        return this.f9572b;
    }
}
