package ru.maximoff.apktool.util;

import android.content.Context;
import com.p129f.p130a.p133c.AbstractC1208w;
import jadx.p180a.C1534b;
import jadx.p180a.C1536d;
import jadx.p180a.C1537e;
import java.p209io.File;
import java.p209io.FileFilter;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p264i.p265a.C2398d;
import org.p226d.p233b.p264i.p266b.C2409i;
import ru.maximoff.p295a.C2608a;

/* compiled from: Smali2Java.java */
/* renamed from: ru.maximoff.apktool.util.bi */
/* loaded from: classes.dex */
public class C3107bi {
    /* renamed from: a */
    public static C1537e m18978a(Context context, InterfaceC2244d interfaceC2244d, File file, C2359g c2359g) {
        File createTempFile = File.createTempFile("Apktool_M", ".dex", C3102bd.m18908a());
        try {
            C2409i c2409i = new C2409i(c2359g);
            m18979a(c2409i, file, c2359g);
            c2409i.m15249a(interfaceC2244d);
            c2409i.m15405a(new C2398d(createTempFile));
            C1534b c1534b = new C1534b();
            c1534b.m11757a(C3102bd.f18297ae);
            c1534b.m11760a(C3102bd.m18925a(context, "jadx_fallback", false));
            c1534b.m11768d(C3102bd.m18925a(context, "jadx_deobfuscation", false));
            c1534b.m11769e(C3102bd.m18925a(context, "jadx_unicode", false));
            c1534b.m11763b(C3102bd.m18925a(context, "jadx_inconsistent", true));
            c1534b.m11766c(true);
            c1534b.m11759a(AbstractC1208w.m10130a(createTempFile));
            C1536d c1536d = new C1536d(c1534b);
            c1536d.m11793a();
            C1537e next = c1536d.m11797e().iterator().next();
            next.m11805b();
            return next;
        } finally {
            createTempFile.delete();
        }
    }

    /* renamed from: a */
    private static void m18979a(C2409i c2409i, File file, C2359g c2359g) {
        String name;
        int lastIndexOf;
        File[] listFiles;
        if (file != null && (lastIndexOf = (name = file.getName()).lastIndexOf(46)) != -1 && (listFiles = file.getParentFile().listFiles(new FileFilter() { // from class: ru.maximoff.apktool.util.bi.1
            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isFile();
            }
        })) != null) {
            for (File file2 : listFiles) {
                String name2 = file2.getName();
                if (name2.startsWith(new StringBuffer().append(name.substring(0, lastIndexOf)).append("$").toString()) && name2.endsWith(".smali")) {
                    c2409i.m15249a(C2608a.m16251a(file2, c2359g));
                }
            }
        }
    }
}
