package jadx.p180a;

import jadx.core.p203d.p205b.C1726c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: JadxArgsValidator.java */
/* renamed from: jadx.a.c */
/* loaded from: classes.dex */
public class C1535c {

    /* renamed from: a */
    private static final InterfaceC2558b f9858a = C2568c.m15995a((Class<?>) C1535c.class);

    /* renamed from: a */
    public static void m11783a(C1534b c1534b) {
        m11785b(c1534b);
        m11787c(c1534b);
        if (f9858a.mo15940b()) {
            f9858a.mo15931a("Effective jadx args: {}", c1534b);
        }
    }

    /* renamed from: b */
    private static void m11785b(C1534b c1534b) {
        List<File> m11756a = c1534b.m11756a();
        if (m11756a.isEmpty()) {
            throw new C1726c("Please specify input file");
        }
        if (m11756a.size() > 1) {
            Iterator<File> it = m11756a.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                if (name.startsWith("--")) {
                    throw new C1726c("Unknown argument: " + name);
                }
            }
            throw new C1726c("Only one input file supported");
        }
        Iterator<File> it2 = m11756a.iterator();
        while (it2.hasNext()) {
            m11784a(it2.next());
        }
    }

    /* renamed from: c */
    private static void m11787c(C1534b c1534b) {
        File m11761b = c1534b.m11761b();
        File m11764c = c1534b.m11764c();
        File m11767d = c1534b.m11767d();
        if (m11761b != null) {
            m11764c = m11761b;
        } else if (m11764c == null) {
            m11764c = m11767d != null ? m11767d : m11788d(c1534b);
        }
        c1534b.m11758a(m11764c);
        m11789e(c1534b);
        m11786b(c1534b.m11761b());
        m11786b(c1534b.m11764c());
        m11786b(c1534b.m11767d());
    }

    /* renamed from: d */
    private static File m11788d(C1534b c1534b) {
        String str;
        String name = c1534b.m11756a().get(0).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str = name.substring(0, lastIndexOf);
        } else {
            str = String.valueOf(name) + "-jadx-output";
        }
        f9858a.mo15936b("output directory: {}", str);
        return new File(str);
    }

    /* renamed from: e */
    private static void m11789e(C1534b c1534b) {
        if (c1534b.m11764c() == null) {
            c1534b.m11762b(new File(c1534b.m11761b(), "sources"));
        }
        if (c1534b.m11767d() == null) {
            c1534b.m11765c(new File(c1534b.m11761b(), "resources"));
        }
    }

    /* renamed from: a */
    private static void m11784a(File file) {
        if (!file.exists()) {
            throw new C1726c("File not found " + file.getAbsolutePath());
        }
        if (file.isDirectory()) {
            throw new C1726c("Expected file but found directory instead: " + file.getAbsolutePath());
        }
    }

    /* renamed from: b */
    private static void m11786b(File file) {
        if (file != null && file.exists() && !file.isDirectory()) {
            throw new C1726c("Output directory exists as file " + file);
        }
    }

    private C1535c() {
    }
}
