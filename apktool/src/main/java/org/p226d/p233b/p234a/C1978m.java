package org.p226d.p233b.p234a;

import com.p129f.p130a.p133c.C1156ai;
import com.p129f.p130a.p133c.C1177bc;
import java.p209io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p234a.C1971f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2162p;
import org.p226d.p233b.p250e.InterfaceC2270k;

/* compiled from: PathEntryLoader.java */
/* renamed from: org.d.b.a.m */
/* loaded from: classes.dex */
public class C1978m {

    /* renamed from: a */
    C2359g f11536a;

    /* renamed from: b */
    final Set<File> f11537b = C1177bc.m10005a();

    /* renamed from: c */
    final List<InterfaceC1973h> f11538c = C1156ai.m9909a();

    /* renamed from: a */
    public List<InterfaceC1973h> m14407a() {
        return this.f11538c;
    }

    public C1978m(C2359g c2359g) {
        this.f11536a = c2359g;
    }

    /* renamed from: b */
    public List<InterfaceC1973h> m14409b() {
        return this.f11538c;
    }

    /* renamed from: a */
    public void m14408a(File file, boolean z) {
        if (!this.f11537b.contains(file)) {
            try {
                InterfaceC2270k<? extends C2153g> m14457b = C2016c.m14457b(file, this.f11536a);
                List<String> mo14511a = m14457b.mo14511a();
                if (mo14511a.isEmpty()) {
                    throw new a("%s contains no dex file", file);
                }
                this.f11537b.add(file);
                Iterator<String> it = mo14511a.iterator();
                while (it.hasNext()) {
                    this.f11538c.add(new C1974i(m14457b.mo14513b(it.next())));
                }
                if (z && (m14457b instanceof C2162p)) {
                    List<String> m14821d = ((C2162p) m14457b).m14821d();
                    if (!m14821d.isEmpty()) {
                        try {
                            m14406a(file.getParentFile(), m14821d);
                        } catch (C1971f.a e2) {
                            throw new C1971f.b(e2, "Error while loading oat file %s", file);
                        } catch (a e3) {
                            throw new C1971f.b(e3, "Error while loading dependencies for oat file %s", file);
                        }
                    }
                }
            } catch (C2016c.f e4) {
                throw new C1971f.b(e4);
            }
        }
    }

    /* renamed from: a */
    private void m14406a(File file, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String m14405a = m14405a(it.next());
            File file2 = new File(file, m14405a);
            if (!file2.exists()) {
                throw new C1971f.a("Cannot find dependency %s in %s", m14405a, file);
            }
            m14408a(file2, false);
        }
    }

    /* renamed from: a */
    private String m14405a(String str) {
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (substring.endsWith(".art")) {
            return substring.substring(0, substring.length() - 4) + ".oat";
        }
        return substring;
    }

    /* compiled from: PathEntryLoader.java */
    /* renamed from: org.d.b.a.m$a */
    static class a extends Exception {
        public a(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }
}
