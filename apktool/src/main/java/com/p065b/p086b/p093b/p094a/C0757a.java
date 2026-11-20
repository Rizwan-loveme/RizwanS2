package com.p065b.p086b.p093b.p094a;

import android.content.Context;
import android.hardware.Camera;
import android.icu.text.DateFormat;
import com.p065b.p086b.p087a.p089b.C0725u;
import com.p065b.p086b.p087a.p091d.C0733d;
import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p093b.C0756a;
import com.p065b.p086b.p093b.C0758b;
import com.p065b.p086b.p095c.C0765b;
import com.p065b.p086b.p095c.p096a.C0761b;
import com.p065b.p086b.p095c.p096a.C0762c;
import com.p065b.p086b.p095c.p096a.C0763d;
import com.p065b.p086b.p095c.p099c.C0855h;
import com.p065b.p086b.p095c.p099c.C0860m;
import com.p065b.p086b.p095c.p099c.C0864q;
import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p102e.C0909b;
import com.p065b.p086b.p102e.EnumC0908a;
import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1020k;
import java.p209io.ByteArrayInputStream;
import java.p209io.ByteArrayOutputStream;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.OutputStream;
import java.p209io.OutputStreamWriter;
import java.p209io.PrintWriter;
import java.p209io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import javax.xml.XMLConstants;

/* compiled from: Main.java */
/* renamed from: com.b.b.b.a.a */
/* loaded from: classes.dex */
public class C0757a {

    /* renamed from: e */
    private static a f4675e;

    /* renamed from: f */
    private static C0860m f4676f;

    /* renamed from: g */
    private static TreeMap<String, byte[]> f4677g;

    /* renamed from: i */
    private static ExecutorService f4679i;

    /* renamed from: j */
    private static boolean f4680j;

    /* renamed from: a */
    private static final Attributes.Name f4671a = new Attributes.Name("Created-By");

    /* renamed from: b */
    private static final String[] f4672b = {Context.ACCESSIBILITY_SERVICE, "crypto", "imageio", "management", "naming", "net", Context.PRINT_SERVICE, "rmi", "security", "sip", "sound", "sql", "swing", "transaction", XMLConstants.XML_NS_PREFIX};

    /* renamed from: c */
    private static int f4673c = 0;

    /* renamed from: d */
    private static int f4674d = 0;

    /* renamed from: h */
    private static final List<byte[]> f4678h = new ArrayList();

    /* renamed from: k */
    private static long f4681k = 0;

    /* renamed from: c */
    static /* synthetic */ int m6921c() {
        int i = f4674d;
        f4674d = i + 1;
        return i;
    }

    /* renamed from: a */
    public static int m6907a(a aVar) {
        File file;
        byte[] bArr;
        f4673c = 0;
        f4674d = 0;
        f4675e = aVar;
        f4675e.m6927a();
        if (!f4675e.f4697p) {
            file = null;
        } else {
            if (f4675e.f4688g == null) {
                System.err.println("error: no incremental output name specified");
                return -1;
            }
            file = new File(f4675e.f4688g);
            if (file.exists()) {
                f4681k = file.lastModified();
            }
        }
        if (!m6924d()) {
            return 1;
        }
        if (f4675e.f4697p && !f4680j) {
            return 0;
        }
        if (f4676f.m7395a()) {
            bArr = null;
        } else {
            bArr = m6925e();
            if (bArr == null) {
                return 2;
            }
        }
        if (f4675e.f4697p) {
            bArr = m6916a(bArr, file);
        }
        byte[] m6915a = m6915a(bArr);
        if (f4675e.f4692k) {
            f4676f = null;
            if (!m6920b(f4675e.f4688g, m6915a)) {
                return 3;
            }
        } else if (m6915a != null && f4675e.f4688g != null) {
            OutputStream m6922c = m6922c(f4675e.f4688g);
            m6922c.write(m6915a);
            m6910a(m6922c);
        }
        return 0;
    }

    /* renamed from: a */
    private static byte[] m6916a(byte[] bArr, File file) {
        C0898f c0898f = bArr != null ? new C0898f(bArr) : null;
        C0898f c0898f2 = file.exists() ? new C0898f(file) : null;
        if (c0898f == null && c0898f2 == null) {
            return null;
        }
        if (c0898f == null) {
            c0898f = c0898f2;
        } else if (c0898f2 != null) {
            c0898f = new C0909b(c0898f, c0898f2, EnumC0908a.KEEP_FIRST).m7744a();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c0898f.m7597a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    private static byte[] m6915a(byte[] bArr) {
        for (byte[] bArr2 : f4678h) {
            bArr = bArr == null ? bArr2 : new C0909b(new C0898f(bArr), new C0898f(bArr2), EnumC0908a.FAIL).m7744a().m7601d();
        }
        return bArr;
    }

    /* renamed from: d */
    private static boolean m6924d() {
        f4676f = new C0860m(f4675e.f4704w);
        if (f4675e.f4692k) {
            f4677g = new TreeMap<>();
        }
        if (f4675e.f4687f != 0) {
            f4676f.m7392a(f4675e.f4687f);
        }
        f4680j = false;
        String[] strArr = f4675e.f4698q;
        if (f4675e.f4705x > 1) {
            f4679i = Executors.newFixedThreadPool(f4675e.f4705x);
        }
        for (String str : strArr) {
            try {
                if (m6911a(str)) {
                    f4680j = true;
                }
            } catch (c e2) {
            }
        }
        if (f4675e.f4705x > 1) {
            try {
                f4679i.shutdown();
                f4679i.awaitTermination(600L, TimeUnit.SECONDS);
            } catch (InterruptedException e3) {
                throw new RuntimeException("Timed out waiting for threads.");
            }
        }
        if (f4673c != 0) {
            C0756a.f4670b.println(f4673c + " warning" + (f4673c == 1 ? "" : DateFormat.SECOND));
        }
        if (f4674d != 0) {
            C0756a.f4670b.println(f4674d + " error" + (f4674d == 1 ? "" : DateFormat.SECOND) + "; aborting");
            return false;
        }
        if (f4675e.f4697p && !f4680j) {
            return true;
        }
        if (!f4680j && !f4675e.f4691j) {
            C0756a.f4670b.println("no classfiles specified");
            return false;
        }
        if (f4675e.f4699r && f4675e.f4702u) {
            C0763d.m6958a(C0756a.f4669a);
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m6911a(String str) {
        return new C0733d(str, false, new C0733d.a() { // from class: com.b.b.b.a.a.1
            @Override // com.p065b.p086b.p087a.p091d.C0733d.a
            /* renamed from: a */
            public boolean mo6825a(String str2, long j, byte[] bArr) {
                if (C0757a.f4675e.f4705x > 1) {
                    C0757a.f4679i.execute(new b(str2, j, bArr));
                    return false;
                }
                return C0757a.m6919b(str2, j, bArr);
            }

            @Override // com.p065b.p086b.p087a.p091d.C0733d.a
            /* renamed from: a */
            public void mo6824a(Exception exc) {
                if (exc instanceof c) {
                    throw ((c) exc);
                }
                if (exc instanceof C0725u) {
                    C0756a.f4670b.println("\nEXCEPTION FROM SIMULATION:");
                    C0756a.f4670b.println(exc.getMessage() + "\n");
                    C0756a.f4670b.println(((C0725u) exc).m8538a());
                } else {
                    C0756a.f4670b.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
                    exc.printStackTrace(C0756a.f4670b);
                }
                C0757a.m6921c();
            }

            @Override // com.p065b.p086b.p087a.p091d.C0733d.a
            /* renamed from: a */
            public void mo6823a(File file) {
                if (C0757a.f4675e.f4683b) {
                    C0756a.f4669a.println("processing archive " + file + "...");
                }
            }
        }).m6820a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m6919b(String str, long j, byte[] bArr) {
        boolean endsWith = str.endsWith(".class");
        boolean equals = str.equals("classes.dex");
        boolean z = f4677g != null;
        if (!endsWith && !equals && !z) {
            if (!f4675e.f4683b) {
                return false;
            }
            C0756a.f4669a.println("ignored resource " + str);
            return false;
        }
        if (f4675e.f4683b) {
            C0756a.f4669a.println("processing " + str + "...");
        }
        String m6923d = m6923d(str);
        if (endsWith) {
            if (z && f4675e.f4693l) {
                synchronized (f4677g) {
                    f4677g.put(m6923d, bArr);
                }
            }
            if (j < f4681k) {
                return true;
            }
            return m6913a(m6923d, bArr);
        }
        if (equals) {
            synchronized (f4678h) {
                f4678h.add(bArr);
            }
            return true;
        }
        synchronized (f4677g) {
            f4677g.put(m6923d, bArr);
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m6913a(String str, byte[] bArr) {
        if (!f4675e.f4685d) {
            m6918b(str);
        }
        try {
            C0855h m6948a = C0762c.m6948a(str, bArr, f4675e.f4703v, f4675e.f4704w);
            synchronized (f4676f) {
                f4676f.m7393a(m6948a);
            }
            return true;
        } catch (C0748i e2) {
            C0756a.f4670b.println("\ntrouble processing:");
            if (f4675e.f4682a) {
                e2.printStackTrace(C0756a.f4670b);
            } else {
                e2.m8539a(C0756a.f4670b);
            }
            f4673c++;
            return false;
        }
    }

    /* renamed from: b */
    private static void m6918b(String str) {
        boolean z = true;
        if (!str.startsWith("java/")) {
            if (str.startsWith("javax/")) {
                int indexOf = str.indexOf(47, 6);
                if (indexOf != -1) {
                    if (Arrays.binarySearch(f4672b, str.substring(6, indexOf)) < 0) {
                        z = false;
                    }
                }
            } else {
                z = false;
            }
        }
        if (!z) {
            return;
        }
        C0756a.f4670b.println("\ntrouble processing \"" + str + "\":\n\nIll-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n");
        f4674d++;
        throw new c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: Exception -> 0x0060, TRY_ENTER, TryCatch #0 {Exception -> 0x0060, blocks: (B:18:0x0042, B:19:0x0045, B:25:0x0059, B:26:0x005c, B:27:0x005f), top: B:2:0x0001 }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] m6925e() {
        OutputStreamWriter outputStreamWriter;
        OutputStream outputStream;
        byte[] m7396a;
        try {
            try {
                if (f4675e.f4689h != null) {
                    outputStream = m6922c(f4675e.f4689h);
                    try {
                        outputStreamWriter = new OutputStreamWriter(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = null;
                        if (outputStreamWriter != null) {
                            outputStreamWriter.flush();
                        }
                        m6910a(outputStream);
                        throw th;
                    }
                } else {
                    outputStreamWriter = null;
                    outputStream = null;
                }
            } catch (Exception e2) {
                if (f4675e.f4682a) {
                    C0756a.f4670b.println("\ntrouble writing output:");
                    e2.printStackTrace(C0756a.f4670b);
                } else {
                    C0756a.f4670b.println("\ntrouble writing output: " + e2.getMessage());
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
            outputStream = null;
        }
        try {
            if (f4675e.f4686e != null) {
                f4676f.m7396a((Writer) null, false);
                m6909a(f4676f, f4675e.f4686e, outputStreamWriter);
                m7396a = null;
            } else {
                m7396a = f4676f.m7396a(outputStreamWriter, f4675e.f4684c);
            }
            if (f4675e.f4702u) {
                C0756a.f4669a.println(f4676f.m7414r().m7261a());
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.flush();
            }
            m6910a(outputStream);
            return m7396a;
        } catch (Throwable th3) {
            th = th3;
            if (outputStreamWriter != null) {
            }
            m6910a(outputStream);
            throw th;
        }
    }

    /* renamed from: b */
    private static boolean m6920b(String str, byte[] bArr) {
        try {
            Manifest m6926f = m6926f();
            OutputStream m6922c = m6922c(str);
            JarOutputStream jarOutputStream = new JarOutputStream(m6922c, m6926f);
            if (bArr != null) {
                f4677g.put("classes.dex", bArr);
            }
            try {
                for (Map.Entry<String, byte[]> entry : f4677g.entrySet()) {
                    String key = entry.getKey();
                    byte[] value = entry.getValue();
                    JarEntry jarEntry = new JarEntry(key);
                    if (f4675e.f4683b) {
                        C0756a.f4669a.println("writing " + key + "; size " + value.length + "...");
                    }
                    jarEntry.setSize(value.length);
                    jarOutputStream.putNextEntry(jarEntry);
                    jarOutputStream.write(value);
                    jarOutputStream.closeEntry();
                }
                return true;
            } finally {
                jarOutputStream.finish();
                jarOutputStream.flush();
                m6910a(m6922c);
            }
        } catch (Exception e2) {
            if (f4675e.f4682a) {
                C0756a.f4670b.println("\ntrouble writing output:");
                e2.printStackTrace(C0756a.f4670b);
            } else {
                C0756a.f4670b.println("\ntrouble writing output: " + e2.getMessage());
            }
            return false;
        }
    }

    /* renamed from: f */
    private static Manifest m6926f() {
        Manifest manifest;
        Attributes mainAttributes;
        String str;
        byte[] bArr = f4677g.get("META-INF/MANIFEST.MF");
        if (bArr == null) {
            manifest = new Manifest();
            mainAttributes = manifest.getMainAttributes();
            mainAttributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        } else {
            manifest = new Manifest(new ByteArrayInputStream(bArr));
            mainAttributes = manifest.getMainAttributes();
            f4677g.remove("META-INF/MANIFEST.MF");
        }
        String value = mainAttributes.getValue(f4671a);
        if (value == null) {
            str = "";
        } else {
            str = value + " + ";
        }
        mainAttributes.put(f4671a, str + "dx 1.7");
        mainAttributes.putValue("Dex-Location", "classes.dex");
        return manifest;
    }

    /* renamed from: c */
    private static OutputStream m6922c(String str) {
        return (str.equals("-") || str.startsWith("-.")) ? System.out : new FileOutputStream(str);
    }

    /* renamed from: a */
    private static void m6910a(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.flush();
            if (outputStream != System.out) {
                outputStream.close();
            }
        }
    }

    /* renamed from: d */
    private static String m6923d(String str) {
        if (File.separatorChar == '\\') {
            str = str.replace('\\', '/');
        }
        int lastIndexOf = str.lastIndexOf("/./");
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 3);
        }
        if (str.startsWith("./")) {
            return str.substring(2);
        }
        return str;
    }

    /* renamed from: a */
    private static void m6909a(C0860m c0860m, String str, OutputStreamWriter outputStreamWriter) {
        boolean endsWith = str.endsWith("*");
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            C0756a.f4670b.println("bogus fully-qualified method name: " + str);
            return;
        }
        String replace = str.substring(0, lastIndexOf).replace('.', '/');
        String substring = str.substring(lastIndexOf + 1);
        C0855h m7391a = c0860m.m7391a(replace);
        if (m7391a == null) {
            C0756a.f4670b.println("no such class: " + replace);
            return;
        }
        String substring2 = endsWith ? substring.substring(0, substring.length() - 1) : substring;
        ArrayList<C0864q> m7349g = m7391a.m7349g();
        TreeMap treeMap = new TreeMap();
        Iterator<C0864q> it = m7349g.iterator();
        while (it.hasNext()) {
            C0864q next = it.next();
            String m8084j = next.m7421a().m8084j();
            if ((endsWith && m8084j.startsWith(substring2)) || (!endsWith && m8084j.equals(substring2))) {
                treeMap.put(next.m7424c().m8071n(), next);
            }
        }
        if (treeMap.size() == 0) {
            C0756a.f4670b.println("no such method: " + str);
            return;
        }
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);
        for (C0864q c0864q : treeMap.values()) {
            c0864q.m7423a(printWriter, f4675e.f4684c);
            C0970x m7348f = m7391a.m7348f();
            if (m7348f != null) {
                printWriter.println("  source file: " + m7348f.m8083i());
            }
            C0916c m7335a = m7391a.m7335a(c0864q.m7424c());
            C0917d m7343b = m7391a.m7343b(c0864q.m7424c());
            if (m7335a != null) {
                printWriter.println("  method annotations:");
                Iterator<C0914a> it2 = m7335a.m7828d().iterator();
                while (it2.hasNext()) {
                    printWriter.println("    " + it2.next());
                }
            }
            if (m7343b != null) {
                printWriter.println("  parameter annotations:");
                int f_ = m7343b.m8550f_();
                for (int i = 0; i < f_; i++) {
                    printWriter.println("    parameter " + i);
                    Iterator<C0914a> it3 = m7343b.m7830a(i).m7828d().iterator();
                    while (it3.hasNext()) {
                        printWriter.println("      " + it3.next());
                    }
                }
            }
        }
        printWriter.flush();
    }

    /* compiled from: Main.java */
    /* renamed from: com.b.b.b.a.a$c */
    private static class c extends RuntimeException {
        private c() {
        }
    }

    /* compiled from: Main.java */
    /* renamed from: com.b.b.b.a.a$a */
    public static class a {

        /* renamed from: q */
        public String[] f4698q;

        /* renamed from: u */
        public boolean f4702u;

        /* renamed from: v */
        public C0761b f4703v;

        /* renamed from: w */
        public C0765b f4704w;

        /* renamed from: a */
        public boolean f4682a = false;

        /* renamed from: b */
        public boolean f4683b = false;

        /* renamed from: c */
        public boolean f4684c = false;

        /* renamed from: d */
        public boolean f4685d = false;

        /* renamed from: e */
        public String f4686e = null;

        /* renamed from: f */
        public int f4687f = 0;

        /* renamed from: g */
        public String f4688g = null;

        /* renamed from: h */
        public String f4689h = null;

        /* renamed from: i */
        public boolean f4690i = true;

        /* renamed from: j */
        public boolean f4691j = false;

        /* renamed from: k */
        public boolean f4692k = false;

        /* renamed from: l */
        public boolean f4693l = false;

        /* renamed from: m */
        public int f4694m = 13;

        /* renamed from: n */
        public int f4695n = 2;

        /* renamed from: o */
        public boolean f4696o = true;

        /* renamed from: p */
        public boolean f4697p = false;

        /* renamed from: r */
        public boolean f4699r = true;

        /* renamed from: s */
        public String f4700s = null;

        /* renamed from: t */
        public String f4701t = null;

        /* renamed from: x */
        public int f4705x = 1;

        /* compiled from: Main.java */
        /* renamed from: com.b.b.b.a.a$a$a, reason: collision with other inner class name */
        private static class C3332a {

            /* renamed from: a */
            private final String[] f4706a;

            /* renamed from: b */
            private int f4707b = 0;

            /* renamed from: c */
            private String f4708c;

            /* renamed from: d */
            private String f4709d;

            public C3332a(String[] strArr) {
                this.f4706a = strArr;
            }

            /* renamed from: a */
            public String m6931a() {
                return this.f4708c;
            }

            /* renamed from: b */
            public String m6933b() {
                return this.f4709d;
            }

            /* renamed from: c */
            public boolean m6934c() {
                if (this.f4707b >= this.f4706a.length) {
                    return false;
                }
                this.f4708c = this.f4706a[this.f4707b];
                if (this.f4708c.equals("--") || !this.f4708c.startsWith("--")) {
                    return false;
                }
                this.f4707b++;
                return true;
            }

            /* renamed from: e */
            private boolean m6930e() {
                if (this.f4707b >= this.f4706a.length) {
                    return false;
                }
                this.f4708c = this.f4706a[this.f4707b];
                this.f4707b++;
                return true;
            }

            /* renamed from: d */
            public String[] m6935d() {
                int length = this.f4706a.length - this.f4707b;
                String[] strArr = new String[length];
                if (length > 0) {
                    System.arraycopy(this.f4706a, this.f4707b, strArr, 0, length);
                }
                return strArr;
            }

            /* renamed from: a */
            public boolean m6932a(String str) {
                int length = str.length();
                if (length > 0 && str.charAt(length - 1) == '=') {
                    if (this.f4708c.startsWith(str)) {
                        this.f4709d = this.f4708c.substring(length);
                        return true;
                    }
                    String substring = str.substring(0, length - 1);
                    if (!this.f4708c.equals(substring)) {
                        return false;
                    }
                    if (m6930e()) {
                        this.f4709d = this.f4708c;
                        return true;
                    }
                    System.err.println("Missing value after parameter " + substring);
                    throw new C0758b();
                }
                return this.f4708c.equals(str);
            }
        }

        /* renamed from: a */
        public void m6929a(String[] strArr) {
            C3332a c3332a = new C3332a(strArr);
            while (c3332a.m6934c()) {
                if (c3332a.m6932a("--debug")) {
                    this.f4682a = true;
                } else if (c3332a.m6932a("--verbose")) {
                    this.f4683b = true;
                } else if (c3332a.m6932a("--verbose-dump")) {
                    this.f4684c = true;
                } else if (c3332a.m6932a("--no-files")) {
                    this.f4691j = true;
                } else if (c3332a.m6932a("--no-optimize")) {
                    this.f4699r = false;
                } else if (c3332a.m6932a("--no-strict")) {
                    this.f4690i = false;
                } else if (c3332a.m6932a("--core-library")) {
                    this.f4685d = true;
                } else if (c3332a.m6932a("--statistics")) {
                    this.f4702u = true;
                } else if (c3332a.m6932a("--optimize-list=")) {
                    if (this.f4701t != null) {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        throw new C0758b();
                    }
                    this.f4699r = true;
                    this.f4700s = c3332a.m6933b();
                } else if (c3332a.m6932a("--no-optimize-list=")) {
                    if (this.f4701t != null) {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        throw new C0758b();
                    }
                    this.f4699r = true;
                    this.f4701t = c3332a.m6933b();
                } else if (c3332a.m6932a("--keep-classes")) {
                    this.f4693l = true;
                } else if (c3332a.m6932a("--output=")) {
                    this.f4688g = c3332a.m6933b();
                    if (C1020k.m8541a(this.f4688g)) {
                        this.f4692k = true;
                    } else if (this.f4688g.endsWith(".dex") || this.f4688g.equals("-")) {
                        this.f4692k = false;
                    } else {
                        System.err.println("unknown output extension: " + this.f4688g);
                        throw new C0758b();
                    }
                } else if (c3332a.m6932a("--dump-to=")) {
                    this.f4689h = c3332a.m6933b();
                } else if (c3332a.m6932a("--dump-width=")) {
                    this.f4687f = Integer.parseInt(c3332a.m6933b());
                } else if (c3332a.m6932a("--dump-method=")) {
                    this.f4686e = c3332a.m6933b();
                    this.f4692k = false;
                } else if (c3332a.m6932a("--positions=")) {
                    String intern = c3332a.m6933b().intern();
                    if (intern == Camera.Parameters.EFFECT_NONE) {
                        this.f4695n = 1;
                    } else if (intern == "important") {
                        this.f4695n = 3;
                    } else if (intern == "lines") {
                        this.f4695n = 2;
                    } else {
                        System.err.println("unknown positions option: " + intern);
                        throw new C0758b();
                    }
                } else if (c3332a.m6932a("--no-locals")) {
                    this.f4696o = false;
                } else if (c3332a.m6932a("--num-threads=")) {
                    this.f4705x = Integer.parseInt(c3332a.m6933b());
                } else if (c3332a.m6932a("--incremental")) {
                    this.f4697p = true;
                } else {
                    System.err.println("unknown option: " + c3332a.m6931a());
                    throw new C0758b();
                }
            }
            this.f4698q = c3332a.m6935d();
            if (this.f4698q.length == 0) {
                if (!this.f4691j) {
                    System.err.println("no input files specified");
                    throw new C0758b();
                }
            } else if (this.f4691j) {
                System.out.println("ignoring input files");
            }
            if (this.f4689h == null && this.f4686e != null) {
                this.f4689h = "-";
            }
            m6927a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m6927a() {
            this.f4703v = new C0761b();
            this.f4703v.f4713a = this.f4695n;
            this.f4703v.f4714b = this.f4696o;
            this.f4703v.f4715c = this.f4690i;
            this.f4703v.f4716d = this.f4699r;
            this.f4703v.f4717e = this.f4700s;
            this.f4703v.f4718f = this.f4701t;
            this.f4703v.f4719g = this.f4702u;
            this.f4703v.f4720h = C0756a.f4670b;
            this.f4704w = new C0765b();
            this.f4704w.f4731a = this.f4694m;
        }
    }

    /* compiled from: Main.java */
    /* renamed from: com.b.b.b.a.a$b */
    private static class b implements Runnable {

        /* renamed from: a */
        String f4710a;

        /* renamed from: b */
        long f4711b;

        /* renamed from: c */
        byte[] f4712c;

        private b(String str, long j, byte[] bArr) {
            this.f4710a = str;
            this.f4711b = j;
            this.f4712c = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0757a.m6919b(this.f4710a, this.f4711b, this.f4712c)) {
                boolean unused = C0757a.f4680j = true;
            }
        }
    }
}
