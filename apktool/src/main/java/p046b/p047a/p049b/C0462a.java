package p046b.p047a.p049b;

import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;

/* compiled from: MetaInfo.java */
/* renamed from: b.a.b.a */
/* loaded from: classes.dex */
public class C0462a {

    /* renamed from: a */
    public String f3280a;

    /* renamed from: b */
    public String f3281b;

    /* renamed from: c */
    public String f3282c;

    /* renamed from: d */
    public boolean f3283d;

    /* renamed from: e */
    public C0464c f3284e;

    /* renamed from: f */
    public Map<String, String> f3285f;

    /* renamed from: g */
    public C0463b f3286g;

    /* renamed from: h */
    public C0465d f3287h;

    /* renamed from: i */
    public boolean f3288i;

    /* renamed from: j */
    public boolean f3289j;

    /* renamed from: k */
    public boolean f3290k;

    /* renamed from: l */
    public boolean f3291l;

    /* renamed from: m */
    public Map<String, String> f3292m;

    /* renamed from: n */
    public Map<String, Boolean> f3293n;

    /* renamed from: o */
    public Collection<String> f3294o;

    /* renamed from: a */
    public void m3534a(Writer writer) {
        C2468c c2468c = new C2468c();
        m3524a(c2468c, "version", this.f3280a);
        m3524a(c2468c, "apkFileName", this.f3281b);
        m3524a(c2468c, "apkFilePath", this.f3282c);
        c2468c.m15609a("isFrameworkApk", this.f3283d);
        c2468c.m15609a("compressionType", this.f3288i);
        c2468c.m15609a("sharedLibrary", this.f3289j);
        c2468c.m15609a("sparseResources", this.f3290k);
        c2468c.m15609a("compactEntries", this.f3291l);
        m3526a(c2468c, this.f3285f, "sdkInfo");
        m3526a(c2468c, this.f3292m, "unknownFiles");
        if (this.f3293n != null && !this.f3293n.isEmpty()) {
            m3529b(c2468c, this.f3293n, "featureFlags");
        }
        m3525a(c2468c, this.f3294o, "doNotCompress");
        C0464c.m3538a(c2468c, this.f3284e);
        if (this.f3286g == null) {
            c2468c.m15608a("PackageInfo", C2468c.f12954b);
        } else {
            this.f3286g.m3536b(c2468c);
        }
        C0465d.m3541a(c2468c, this.f3287h);
        writer.write(c2468c.m15603a(2));
    }

    /* renamed from: a */
    public static void m3524a(C2468c c2468c, String str, String str2) {
        Object obj = str2;
        if (str2 == null) {
            obj = C2468c.f12954b;
        }
        c2468c.m15608a(str, obj);
    }

    /* renamed from: a */
    public static String m3522a(C2468c c2468c, String str) {
        return c2468c.m15619h(str) ? (String) null : c2468c.m15617f(str);
    }

    /* renamed from: a */
    private void m3523a(C2468c c2468c) {
        this.f3280a = m3522a(c2468c, "version");
        this.f3281b = m3522a(c2468c, "apkFileName");
        this.f3282c = m3522a(c2468c, "apkFilePath");
        this.f3283d = m3531d(c2468c, "isFrameworkApk");
        this.f3288i = m3531d(c2468c, "compressionType");
        this.f3290k = m3531d(c2468c, "sparseResources");
        this.f3291l = m3531d(c2468c, "compactEntries");
        this.f3285f = m3528b(c2468c, "sdkInfo");
        this.f3292m = m3528b(c2468c, "unknownFiles");
        this.f3293n = m3530c(c2468c, "featureFlags");
        this.f3294o = m3532e(c2468c, "doNotCompress");
        this.f3284e = C0464c.m3537a(c2468c);
        this.f3286g = C0463b.m3535a(c2468c);
        this.f3287h = C0465d.m3540a(c2468c);
    }

    /* renamed from: d */
    private boolean m3531d(C2468c c2468c, String str) {
        try {
            return c2468c.m15611b(str);
        } catch (C2467b e2) {
            return false;
        }
    }

    /* renamed from: e */
    private List<String> m3532e(C2468c c2468c, String str) {
        if (c2468c.m15619h(str)) {
            return (List) null;
        }
        C2466a m15615d = c2468c.m15615d(str);
        LinkedList linkedList = new LinkedList();
        int m15569a = m15615d.m15569a();
        for (int i = 0; i < m15569a; i++) {
            linkedList.add(m15615d.m15579f(i));
        }
        return linkedList;
    }

    /* renamed from: b */
    public static Map<String, String> m3528b(C2468c c2468c, String str) {
        if (c2468c.m15619h(str)) {
            return (Map) null;
        }
        C2468c m15616e = c2468c.m15616e(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> m15605a = m15616e.m15605a();
        while (m15605a.hasNext()) {
            String next = m15605a.next();
            if (m15616e.m15619h(next)) {
                linkedHashMap.put(next, (String) null);
            } else {
                linkedHashMap.put(next, m15616e.m15617f(next));
            }
        }
        return linkedHashMap;
    }

    /* renamed from: c */
    public static Map<String, Boolean> m3530c(C2468c c2468c, String str) {
        if (c2468c.m15619h(str)) {
            return (Map) null;
        }
        C2468c m15616e = c2468c.m15616e(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> m15605a = m15616e.m15605a();
        while (m15605a.hasNext()) {
            String next = m15605a.next();
            if (m15616e.m15619h(next)) {
                linkedHashMap.put(next, (Boolean) null);
            } else {
                linkedHashMap.put(next, new Boolean(m15616e.m15611b(next)));
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static void m3525a(C2468c c2468c, Collection collection, String str) {
        if (collection == null) {
            c2468c.m15608a(str, C2468c.f12954b);
        } else {
            c2468c.m15608a(str, new C2466a((Collection<?>) collection));
        }
    }

    /* renamed from: a */
    private static void m3526a(C2468c c2468c, Map<String, String> map, String str) {
        if (map == null) {
            c2468c.m15608a(str, C2468c.f12954b);
        } else {
            c2468c.m15608a(str, new C2468c((Map<?, ?>) map));
        }
    }

    /* renamed from: b */
    private static void m3529b(C2468c c2468c, Map<String, Boolean> map, String str) {
        if (map == null) {
            c2468c.m15608a(str, C2468c.f12954b);
        } else {
            c2468c.m15608a(str, new C2468c((Map<?, ?>) map));
        }
    }

    /* renamed from: a */
    public void m3533a(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        m3534a(bufferedWriter);
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /* renamed from: a */
    public static C0462a m3521a(InputStream inputStream) {
        C2468c c2468c = new C2468c(C1887e.m13985c(inputStream));
        C0462a c0462a = new C0462a();
        c0462a.m3523a(c2468c);
        return c0462a;
    }

    /* renamed from: b */
    public static C0462a m3527b(File file) {
        return m3521a(new FileInputStream(file));
    }
}
