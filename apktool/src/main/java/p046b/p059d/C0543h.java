package p046b.p059d;

import java.p209io.File;
import java.util.Iterator;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: RenamedMap.java */
/* renamed from: b.d.h */
/* loaded from: classes.dex */
public class C0543h {

    /* renamed from: a */
    private final String f3639a = "original/";

    /* renamed from: b */
    private File f3640b;

    /* renamed from: c */
    private int f3641c;

    /* renamed from: d */
    private C2468c f3642d;

    public C0543h(File file) {
        this.f3641c = 0;
        this.f3640b = file;
        this.f3641c = file.getAbsolutePath().length() + 1;
        m3997a();
    }

    /* renamed from: a */
    public void m3997a() {
        File file = new File(this.f3640b, "renamed.json");
        if (file.exists() && file.isFile()) {
            try {
                this.f3642d = new C2468c(C3061a.m18332i(file));
                return;
            } catch (C2467b e2) {
                this.f3642d = new C2468c();
                return;
            }
        }
        this.f3642d = new C2468c();
    }

    /* renamed from: b */
    public void m4000b() {
        if (this.f3642d.m15614d() > 0) {
            try {
                C3061a.m18319b(new File(this.f3640b, "renamed.json"), this.f3642d.m15603a(2));
            } catch (C2467b e2) {
            }
        }
    }

    /* renamed from: a */
    public String m3995a(String str) {
        String m3999b = m3999b(str);
        String m3996a = m3996a(m3999b, 1);
        try {
            if (m3999b.startsWith("original/") && m3996a.startsWith("original/")) {
                this.f3642d.m15608a(m3999b.substring(this.f3639a.length()), (Object) m3996a.substring(this.f3639a.length()));
            } else {
                this.f3642d.m15608a(m3999b, (Object) m3996a);
            }
        } catch (C2467b e2) {
        }
        return new StringBuffer().append(new StringBuffer().append(this.f3640b.getAbsolutePath()).append(File.separator).toString()).append(m3996a).toString();
    }

    /* renamed from: a */
    public void m3998a(String str, String str2) {
        if (!str.equals(str2)) {
            try {
                if (str.startsWith("original/") && str2.startsWith("original/")) {
                    this.f3642d.m15608a(str.substring(this.f3639a.length()), (Object) str2.substring(this.f3639a.length()));
                } else {
                    this.f3642d.m15608a(str, (Object) str2);
                }
            } catch (C2467b e2) {
            }
        }
    }

    /* renamed from: b */
    public String m3999b(String str) {
        if (str.length() > this.f3641c) {
            return str.substring(this.f3641c);
        }
        return str;
    }

    /* renamed from: c */
    public String m4001c(String str) {
        try {
            return this.f3642d.m15617f(str);
        } catch (C2467b e2) {
            return (String) null;
        }
    }

    /* renamed from: d */
    public String m4002d(String str) {
        if (this.f3642d.m15614d() == 0) {
            return (String) null;
        }
        try {
            Iterator<String> m15605a = this.f3642d.m15605a();
            while (m15605a.hasNext()) {
                String next = m15605a.next();
                if (this.f3642d.m15617f(next).equalsIgnoreCase(str)) {
                    return m3994b(str, next);
                }
            }
        } catch (C2467b e2) {
        }
        return (String) null;
    }

    /* renamed from: a */
    public String m3996a(String str, int i) {
        String stringBuffer;
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 > lastIndexOf) {
            stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str.substring(0, lastIndexOf2)).append("_").toString()).append(i).toString()).append(str.substring(lastIndexOf2)).toString();
        } else {
            stringBuffer = new StringBuffer().append(new StringBuffer().append(str).append("_").toString()).append(i).toString();
        }
        if (new File(this.f3640b, stringBuffer).exists()) {
            return m3996a(str, i + 1);
        }
        return stringBuffer;
    }

    /* renamed from: e */
    public File m4003e(String str) {
        return new File(this.f3640b, str);
    }

    /* renamed from: b */
    private String m3994b(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            int lastIndexOf2 = str2.lastIndexOf(47);
            if (lastIndexOf2 <= 0 || !str.substring(lastIndexOf).equals(str2.substring(lastIndexOf2))) {
                return new StringBuffer().append(str.substring(0, lastIndexOf)).append(str2.substring(lastIndexOf)).toString();
            }
            return str2;
        }
        return str2;
    }
}
