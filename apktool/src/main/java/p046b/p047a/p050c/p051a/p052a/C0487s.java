package p046b.p047a.p050c.p051a.p052a;

import java.util.regex.Pattern;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.C0516b;

/* compiled from: ResStringValue.java */
/* renamed from: b.a.c.a.a.s */
/* loaded from: classes.dex */
public class C0487s extends AbstractC0486r {

    /* renamed from: a */
    private static final Pattern f3406a = Pattern.compile("\\d{9,}");

    public C0487s(String str, int i) {
        this(str, i, "string");
    }

    public C0487s(String str, int i, String str2) {
        super(str2, i, str);
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: g */
    public String mo3649g() {
        return m3655a(C0516b.m3872b(this.f3405d));
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: h */
    public String mo3650h() {
        return C0516b.m3875e(C0516b.m3873c(this.f3405d));
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: i */
    public String mo3651i() {
        return C0516b.m3873c(this.f3405d);
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: a */
    protected String mo3632a() {
        throw new UnsupportedOperationException();
    }

    @Override // p046b.p047a.p050c.p051a.p052a.AbstractC0486r
    /* renamed from: b */
    protected void mo3648b(XmlSerializer xmlSerializer, C0494e c0494e) {
        if (C0516b.m3874d(this.f3405d)) {
            xmlSerializer.attribute((String) null, "formatted", "false");
        }
    }

    /* renamed from: a */
    private String m3655a(String str) {
        return (str == null || str.isEmpty() || !f3406a.matcher(str).matches()) ? str : new StringBuffer().append("\\ ").append(str).toString();
    }
}
