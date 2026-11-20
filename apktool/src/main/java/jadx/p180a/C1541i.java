package jadx.p180a;

import jadx.core.p203d.p206c.C1734d;
import java.p209io.File;

/* compiled from: ResourceFile.java */
/* renamed from: jadx.a.i */
/* loaded from: classes.dex */
public class C1541i {

    /* renamed from: a */
    private final C1536d f9881a;

    /* renamed from: b */
    private final String f9882b;

    /* renamed from: c */
    private final EnumC1542j f9883c;

    /* renamed from: d */
    private a f9884d;

    /* compiled from: ResourceFile.java */
    /* renamed from: jadx.a.i$a */
    public static final class a {

        /* renamed from: a */
        private final File f9885a;

        /* renamed from: b */
        private final String f9886b;

        public a(File file, String str) {
            this.f9885a = file;
            this.f9886b = str;
        }

        /* renamed from: a */
        public File m11820a() {
            return this.f9885a;
        }

        /* renamed from: b */
        public String m11821b() {
            return this.f9886b;
        }

        public String toString() {
            return "ZipRef{" + this.f9885a + ", '" + this.f9886b + "'}";
        }
    }

    protected C1541i(C1536d c1536d, String str, EnumC1542j enumC1542j) {
        this.f9881a = c1536d;
        this.f9882b = str;
        this.f9883c = enumC1542j;
    }

    /* renamed from: a */
    public String m11816a() {
        return this.f9882b;
    }

    /* renamed from: b */
    public EnumC1542j m11818b() {
        return this.f9883c;
    }

    /* renamed from: a */
    void m11817a(a aVar) {
        this.f9884d = aVar;
    }

    /* renamed from: c */
    public a m11819c() {
        return this.f9884d;
    }

    public String toString() {
        return "ResourceFile{name='" + this.f9882b + "', type=" + this.f9883c + "}";
    }

    /* renamed from: a */
    public static C1541i m11815a(C1536d c1536d, String str, EnumC1542j enumC1542j) {
        if (C1734d.m13251a(str)) {
            return new C1541i(c1536d, str, enumC1542j);
        }
        return null;
    }
}
