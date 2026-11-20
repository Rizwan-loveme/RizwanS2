package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.content.Context;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2466a;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.p050c.p051a.C0497h;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: OptimizationTask.java */
/* renamed from: ru.maximoff.apktool.e.ad */
/* loaded from: classes.dex */
public class AsyncTaskC2902ad extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15030a;

    /* renamed from: b */
    private InterfaceC2995n f15031b;

    /* renamed from: c */
    private boolean f15032c;

    /* renamed from: d */
    private int f15033d;

    /* renamed from: e */
    private List<String> f15034e;

    /* renamed from: f */
    private boolean f15035f;

    /* renamed from: g */
    private boolean f15036g;

    /* renamed from: h */
    private int f15037h;

    public AsyncTaskC2902ad(Context context, InterfaceC2995n interfaceC2995n, int i) {
        super(context, interfaceC2995n);
        this.f15030a = context;
        this.f15031b = interfaceC2995n;
        this.f15033d = i;
        this.f15032c = false;
        this.f15037h = C3102bd.m18905a(context, "optimization_senl", 0);
        this.f15034e = m17109l();
        this.f15035f = C3102bd.m18925a(context, "optimization_over", false);
        this.f15036g = C3102bd.m18925a(context, "optimization_za", true);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.moptimize;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01cd A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0042 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x006e  */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean mo17058a(File file) {
        boolean z;
        int[] iArr;
        InterfaceC0008c m18964a;
        File m17104a;
        boolean z2;
        mo3984d(R.string.moptimize_file, file.getAbsolutePath());
        File[] fileArr = new File[2];
        try {
            try {
                try {
                    iArr = new int[1];
                    try {
                        iArr[0] = new C3081am(file).m18632h();
                    } catch (Exception e2) {
                        iArr[0] = 14;
                    }
                    m18964a = (this.f15033d == 0 && C3102bd.m18925a(this.f15030a, "save_sign_data", true)) ? C3105bg.m18964a(file) : (InterfaceC0008c) null;
                    m17104a = m17104a(file, (String) null);
                } finally {
                    for (File file2 : fileArr) {
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            } catch (Error e3) {
                e = e3;
                z = false;
            }
        } catch (Exception e4) {
            e = e4;
            z = false;
        }
        if (m17104a == null) {
            for (File file3 : fileArr) {
                if (file3 != null && file3.exists()) {
                    file3.delete();
                }
            }
            return false;
        }
        fileArr[0] = new File(file.getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".opt_unsigned_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(file.getName()).toString());
        fileArr[1] = new File(file.getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".opt_repacked_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(file.getName()).toString());
        try {
            if (this.f15036g) {
                m17108d(file.getAbsolutePath(), fileArr[1].getAbsolutePath());
                mo3984d(R.string.mzipalign, new Object[0]);
                z2 = C3317a.m20052a(fileArr[1].getAbsolutePath(), fileArr[0].getAbsolutePath());
            } else {
                m17108d(file.getAbsolutePath(), fileArr[0].getAbsolutePath());
                z2 = true;
            }
        } catch (Exception e5) {
            mo3979a(R.string.errorf, e5.getMessage());
            z2 = false;
        }
        boolean z3 = z2;
        try {
            if (fileArr[1].exists()) {
                fileArr[1].delete();
            }
            C2917as.m17314a(this.f15030a, this.f15033d, new C2917as.a(this, fileArr, m17104a, m18964a, iArr) { // from class: ru.maximoff.apktool.e.ad.1

                /* renamed from: a */
                private final AsyncTaskC2902ad f15038a;

                /* renamed from: b */
                private final File[] f15039b;

                /* renamed from: c */
                private final File f15040c;

                /* renamed from: d */
                private final InterfaceC0008c f15041d;

                /* renamed from: e */
                private final int[] f15042e;

                {
                    this.f15038a = this;
                    this.f15039b = fileArr;
                    this.f15040c = m17104a;
                    this.f15041d = m18964a;
                    this.f15042e = iArr;
                }

                @Override // ru.maximoff.apktool.p300e.C2917as.a
                /* renamed from: a */
                public void mo16440a(C2917as c2917as, boolean z4) {
                    if (z4) {
                        this.f15039b[0].renameTo(this.f15040c);
                        if (this.f15041d != null) {
                            try {
                                C3105bg.m18967a(this.f15040c, this.f15041d);
                                return;
                            } catch (IOException e6) {
                                return;
                            }
                        }
                        return;
                    }
                    c2917as.m17320a(this.f15039b[0], this.f15040c, this.f15042e[0]);
                    this.f15039b[0].delete();
                }
            });
            if (m17076j() == null) {
                m17060b(m17104a);
            } else {
                m17060b(m17104a.getParentFile());
            }
            z = z3;
        } catch (Error e6) {
            e = e6;
            z = z3;
            mo3979a(R.string.errorf, e.getMessage());
            m17069e(R.string.text, "");
            if (!z) {
            }
        } catch (Exception e7) {
            e = e7;
            z = z3;
            mo3979a(R.string.errorf, e.getMessage());
            m17069e(R.string.text, "");
            if (!z) {
            }
        }
        m17069e(R.string.text, "");
        return !z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: a */
    private File m17104a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15030a, file)) || C3102bd.m18925a(this.f15030a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                mo3979a(R.string.output_directory_not_set, new Object[0]);
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                mo3979a(R.string.output_directory_not_extsts, parent);
                return (File) null;
            }
            if (!file2.isDirectory()) {
                mo3979a(R.string.not_directory, parent);
                return (File) null;
            }
            this.f15032c = !parent.equals(file.getParent());
        }
        String str2 = parent;
        if (str == null) {
            str = file.getName();
        }
        return new File(str2, C3262u.m19623b(this.f15030a, str2, str, "_opti", 0));
    }

    /* renamed from: d */
    private void m17108d(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        File file;
        long m19055a;
        File file2;
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        File file3 = (File) null;
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (name != null && !C3112bn.m19040o(name)) {
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                long crc = nextElement.getCrc();
                if (this.f15037h > 0 && AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(name)) {
                    File createTempFile = File.createTempFile("unchanged", ".xml", C3102bd.m18908a());
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile), bArr.length);
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream2.close();
                    File createTempFile2 = File.createTempFile("changed", ".xml", C3102bd.m18908a());
                    try {
                        m17105a(createTempFile, createTempFile2);
                        mo3984d(R.string.text, new StringBuffer().append("Removed \"android:extractNativeLibs\" in ").append(name).toString());
                        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(createTempFile2), bArr.length);
                        C2602u c2602u2 = new C2602u(name);
                        c2602u2.setCrc(C3117bs.m19055a(createTempFile2));
                        if (m17106a(name) || (nextElement.getMethod() == 0 && !this.f15035f)) {
                            mo3984d(R.string.text, new StringBuffer().append("STORED: ").append(name).toString());
                            long length = createTempFile2.length();
                            c2602u2.setMethod(0);
                            c2602u2.setSize(length);
                            c2602u2.setCompressedSize(length);
                        } else {
                            c2602u2.setCompressedSize(-1L);
                            c2602u2.setMethod(8);
                        }
                        m19496a.mo16214a(c2602u2);
                        while (true) {
                            int read2 = bufferedInputStream3.read(bArr);
                            if (read2 == -1) {
                                break;
                            } else {
                                m19496a.write(bArr, 0, read2);
                            }
                        }
                        bufferedInputStream3.close();
                        m19496a.flush();
                        m19496a.m16218b();
                        createTempFile.delete();
                        createTempFile2.delete();
                    } catch (Exception e2) {
                        mo3979a(R.string.text, new StringBuffer().append("Failed to removed \"android:extractNativeLibs\" in ").append(name).toString());
                    }
                } else {
                    if (m17106a(name)) {
                        mo3984d(R.string.text, new StringBuffer().append("STORED: ").append(name).toString());
                        if (size < 0 || crc < 0) {
                            File createTempFile3 = File.createTempFile("APKTOOLM", ".optimize", C3102bd.m18908a());
                            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(createTempFile3), bArr.length);
                            while (true) {
                                try {
                                    int read3 = bufferedInputStream4.read(bArr);
                                    if (read3 == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream2.write(bArr, 0, read3);
                                    }
                                } catch (Throwable th) {
                                    bufferedInputStream4.close();
                                    bufferedOutputStream2.close();
                                    throw th;
                                }
                            }
                            bufferedInputStream4.close();
                            bufferedOutputStream2.close();
                            long length2 = createTempFile3.length();
                            m19055a = C3117bs.m19055a(createTempFile3);
                            size = length2;
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(createTempFile3), bArr.length);
                            file2 = createTempFile3;
                        } else {
                            BufferedInputStream bufferedInputStream5 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                            m19055a = crc;
                            bufferedInputStream = bufferedInputStream5;
                            file2 = file3;
                        }
                        c2602u.setMethod(0);
                        c2602u.setSize(size);
                        c2602u.setCompressedSize(size);
                        c2602u.setCrc(m19055a);
                        file = file2;
                    } else if (nextElement.getMethod() == 0 && !this.f15035f) {
                        mo3984d(R.string.text, new StringBuffer().append("STORED: ").append(name).toString());
                        c2602u.setMethod(0);
                        c2602u.setSize(size);
                        c2602u.setCompressedSize(size);
                        c2602u.setCrc(crc);
                        bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                        file = file3;
                    } else {
                        c2602u.setCrc(crc);
                        c2602u.setCompressedSize(-1L);
                        c2602u.setMethod(8);
                        bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                        file = file3;
                    }
                    m19496a.mo16214a(c2602u);
                    while (true) {
                        int read4 = bufferedInputStream.read(bArr);
                        if (read4 == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read4);
                        }
                    }
                    bufferedInputStream.close();
                    m19496a.flush();
                    m19496a.m16218b();
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    file3 = file;
                }
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private boolean m17106a(String str) {
        if (this.f15034e.isEmpty()) {
            return false;
        }
        Iterator<String> it = this.f15034e.iterator();
        while (it.hasNext()) {
            if (Pattern.compile(it.next(), 2).matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    private List<String> m17109l() {
        C2466a c2466a;
        ArrayList arrayList = new ArrayList();
        String m18910a = C3102bd.m18910a(this.f15030a, "optimization_rules", (String) null);
        try {
            if (m18910a == null) {
                c2466a = new C2466a(C3249i.f19548h);
            } else {
                c2466a = new C2466a(m18910a);
            }
            for (int i = 0; i < c2466a.m15569a(); i++) {
                arrayList.add(C3112bn.m19025c(c2466a.m15579f(i)));
            }
        } catch (Exception e2) {
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m17105a(File file, File file2) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass2(this, c0548d, new boolean[]{false}));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: OptimizationTask.java */
    /* renamed from: ru.maximoff.apktool.e.ad$2, reason: invalid class name */
    class AnonymousClass2 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2902ad f15043a;

        /* renamed from: b */
        private final boolean[] f15044b;

        AnonymousClass2(AsyncTaskC2902ad asyncTaskC2902ad, AbstractC0549e abstractC0549e, boolean[] zArr) {
            super(abstractC0549e);
            this.f15043a = asyncTaskC2902ad;
            this.f15044b = zArr;
        }

        /* renamed from: a */
        static AsyncTaskC2902ad m17110a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f15043a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2), this.f15044b);
        }

        /* compiled from: OptimizationTask.java */
        /* renamed from: ru.maximoff.apktool.e.ad$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass2 f15045a;

            /* renamed from: b */
            private final boolean[] f15046b;

            AnonymousClass1(AnonymousClass2 anonymousClass2, AbstractC0549e abstractC0549e, boolean[] zArr) {
                super(abstractC0549e);
                this.f15045a = anonymousClass2;
                this.f15046b = zArr;
            }

            /* renamed from: a */
            static AnonymousClass2 m17111a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15045a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                return str2.equalsIgnoreCase("application") ? new AbstractC0549e(this, super.mo4019a(str, str2), this.f15046b) { // from class: ru.maximoff.apktool.e.ad.2.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f15047a;

                    /* renamed from: b */
                    private final boolean[] f15048b;

                    {
                        this.f15047a = this;
                        this.f15048b = r3;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                        Object obj2;
                        Boolean bool;
                        if (str4.equalsIgnoreCase("extractNativeLibs")) {
                            if (AnonymousClass2.m17110a(AnonymousClass1.m17111a(this.f15047a)).f15037h == 1) {
                                bool = new Boolean(true);
                            } else {
                                bool = new Boolean(false);
                            }
                            this.f15048b[0] = true;
                            obj2 = bool;
                        } else {
                            obj2 = obj;
                        }
                        super.mo4032a(str3, str4, i, i2, obj2);
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4024a() {
                        if (!this.f15048b[0]) {
                            int identifier = AnonymousClass2.m17110a(AnonymousClass1.m17111a(this.f15047a)).f15030a.getResources().getIdentifier("extractNativeLibs", C0497h.f3457a, "android");
                            if (identifier == 0) {
                                identifier = C0012R.attr.extractNativeLibs;
                            }
                            super.mo4032a("http://schemas.android.com/apk/res/android", "extractNativeLibs", identifier, 18, new Integer(AnonymousClass2.m17110a(AnonymousClass1.m17111a(this.f15047a)).f15037h != 2 ? 1 : 0));
                        }
                        super.mo4024a();
                    }
                } : super.mo4019a(str, str2);
            }
        }
    }
}
