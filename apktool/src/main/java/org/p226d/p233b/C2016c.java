package org.p226d.p233b;

import com.p129f.p130a.p131a.C1114i;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1156ai;
import com.p129f.p130a.p135e.C1213a;
import com.p129f.p130a.p135e.C1214b;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileNotFoundException;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2158l;
import org.p226d.p233b.p244d.C2162p;
import org.p226d.p233b.p244d.C2163q;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p233b.p250e.InterfaceC2270k;
import org.p226d.p233b.p264i.p266b.C2409i;
import org.p226d.p269d.C2453g;

/* compiled from: DexFileFactory.java */
/* renamed from: org.d.b.c */
/* loaded from: classes.dex */
public final class C2016c {
    /* renamed from: a */
    public static C2153g m14454a(String str, C2359g c2359g) {
        return m14453a(new File(str), c2359g);
    }

    /* renamed from: a */
    public static C2153g m14453a(File file, C2359g c2359g) {
        if (!file.exists()) {
            throw new b("%s does not exist", file.getName());
        }
        try {
            return new a(file.getPath(), new C2163q(file, c2359g)).m14462a("classes.dex", true);
        } catch (C2163q.a e2) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                return C2153g.m14765a(c2359g, bufferedInputStream);
            } catch (C2153g.b e3) {
                return C2158l.m14802b(c2359g, bufferedInputStream);
            } catch (C2158l.a e4) {
                C2162p c2162p = null;
                try {
                    c2162p = C2162p.m14809a(bufferedInputStream, new c(file));
                } catch (C2162p.d e5) {
                }
                if (c2162p == null) {
                    bufferedInputStream.close();
                    throw new f("%s is not an apk, dex, odex or oat file.", file.getPath());
                }
                if (c2162p.m14820c() == 0) {
                    throw new g(c2162p);
                }
                List<C2162p.e> m14822e = c2162p.m14822e();
                if (m14822e.size() == 0) {
                    throw new b("Oat file %s contains no dex files", file.getName());
                }
                return m14822e.get(0);
            } finally {
                bufferedInputStream.close();
            }
        }
    }

    /* renamed from: b */
    public static InterfaceC2270k<? extends C2153g> m14457b(File file, C2359g c2359g) {
        if (!file.exists()) {
            throw new b("%s does not exist", file.getName());
        }
        C2163q c2163q = new C2163q(file, c2359g);
        boolean m14856b = c2163q.m14856b();
        InterfaceC2270k interfaceC2270k = c2163q;
        if (!m14856b) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
            } catch (C2158l.a e2) {
                C2162p c2162p = null;
                try {
                    c2162p = C2162p.m14809a(bufferedInputStream, new c(file));
                } catch (C2162p.d e3) {
                }
                if (c2162p == null) {
                    bufferedInputStream.close();
                    throw new f("%s is not an apk, dex, odex or oat file.", file.getPath());
                }
                if (c2162p.m14820c() == 0) {
                    throw new g(c2162p);
                }
            } catch (C2153g.b e4) {
            } finally {
                bufferedInputStream.close();
            }
        }
        return interfaceC2270k;
    }

    /* renamed from: a */
    public static void m14455a(String str, InterfaceC2264e interfaceC2264e) {
        C2409i.m15246a(str, interfaceC2264e);
    }

    private C2016c() {
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$b */
    public static class b extends C2453g {
        public b(String str, Object... objArr) {
            super(str, objArr);
        }
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$g */
    public static class g extends C2453g {

        /* renamed from: a */
        public final C2162p f11729a;

        public g(C2162p c2162p) {
            super("Unsupported oat version: %d", Integer.valueOf(c2162p.m14819b()));
            this.f11729a = c2162p;
        }
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$d */
    public static class d extends C2453g {
        public d(String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$f */
    public static class f extends C2453g {
        public f(String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m14459c(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m14460d(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2)) {
            return false;
        }
        char charAt = str.charAt((str.length() - str2.length()) - 1);
        char charAt2 = str2.charAt(0);
        return charAt2 == ':' || charAt2 == '/' || charAt == ':' || charAt == '/';
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$a */
    protected static class a {

        /* renamed from: a */
        static final /* synthetic */ boolean f11572a;

        /* renamed from: b */
        private final String f11573b;

        /* renamed from: c */
        private final InterfaceC2270k<? extends C2153g> f11574c;

        static {
            f11572a = !C2016c.class.desiredAssertionStatus();
        }

        public a(String str, InterfaceC2270k<? extends C2153g> interfaceC2270k) {
            this.f11573b = str;
            this.f11574c = interfaceC2270k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public C2153g m14462a(String str, boolean z) {
            if (z) {
                try {
                    C2153g mo14513b = this.f11574c.mo14513b(str);
                    if (mo14513b == null) {
                        throw new b("Could not find entry %s in %s.", str, this.f11573b);
                    }
                    return mo14513b;
                } catch (C2153g.b e2) {
                    throw new f("Entry %s in %s is not a dex file", str, this.f11573b);
                }
            }
            ArrayList m9909a = C1156ai.m9909a();
            ArrayList m9909a2 = C1156ai.m9909a();
            ArrayList m9909a3 = C1156ai.m9909a();
            ArrayList m9909a4 = C1156ai.m9909a();
            for (String str2 : this.f11574c.mo14511a()) {
                if (!C2016c.m14459c(str2, str)) {
                    if (C2016c.m14460d(str2, str)) {
                        m9909a3.add(str2);
                        m9909a4.add(this.f11574c.mo14513b(str2));
                    }
                } else {
                    m9909a.add(str2);
                    m9909a2.add(this.f11574c.mo14513b(str2));
                }
            }
            if (m9909a2.size() == 1) {
                try {
                    C2153g c2153g = (C2153g) m9909a2.get(0);
                    if (f11572a || c2153g != null) {
                        return c2153g;
                    }
                    throw new AssertionError();
                } catch (C2153g.b e3) {
                    throw new f("Entry %s in %s is not a dex file", m9909a.get(0), this.f11573b);
                }
            }
            if (m9909a2.size() > 1) {
                throw new d(String.format("Multiple entries in %s match %s: %s", this.f11573b, str, C1114i.m9521a(", ").m9524a((Iterable<?>) m9909a)), new Object[0]);
            }
            if (m9909a4.size() == 0) {
                throw new b("Could not find a dex entry in %s matching %s", this.f11573b, str);
            }
            if (m9909a4.size() > 1) {
                throw new d(String.format("Multiple dex entries in %s match %s: %s", this.f11573b, str, C1114i.m9521a(", ").m9524a((Iterable<?>) m9909a3)), new Object[0]);
            }
            return (C2153g) m9909a4.get(0);
        }
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$e */
    private static class e implements InterfaceC2270k<C2153g> {

        /* renamed from: a */
        private final String f11723a;

        /* renamed from: b */
        private final C2153g f11724b;

        public e(String str, C2153g c2153g) {
            this.f11723a = str;
            this.f11724b = c2153g;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2270k
        /* renamed from: a */
        public List<String> mo14511a() {
            return AbstractC1208w.m10130a(this.f11723a);
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2270k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2153g mo14513b(String str) {
            if (str.equals(this.f11723a)) {
                return this.f11724b;
            }
            return null;
        }
    }

    /* compiled from: DexFileFactory.java */
    /* renamed from: org.d.b.c$c */
    public static class c implements C2162p.l {

        /* renamed from: a */
        private final File f11718a;

        /* renamed from: b */
        private byte[] f11719b = null;

        /* renamed from: c */
        private boolean f11720c = false;

        public c(File file) {
            this.f11718a = new File(file.getAbsoluteFile().getParentFile(), C1214b.m10167a(file.getAbsolutePath()) + ".vdex");
        }

        @Override // org.p226d.p233b.p244d.C2162p.l
        /* renamed from: a */
        public byte[] mo14506a() {
            if (!this.f11720c) {
                if (this.f11718a.exists()) {
                    try {
                        this.f11719b = C1213a.m10161a(new FileInputStream(this.f11718a));
                    } catch (FileNotFoundException e2) {
                        this.f11719b = null;
                    } catch (IOException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f11720c = true;
            }
            return this.f11719b;
        }
    }
}
