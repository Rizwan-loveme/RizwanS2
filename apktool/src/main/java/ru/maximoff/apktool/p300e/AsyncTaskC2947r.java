package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.Manifest;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.provider.DocumentsContract;
import android.provider.Settings;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.C2282b;
import org.p226d.p233b.p256f.C2320c;
import org.p226d.p233b.p256f.p259c.C2322b;
import org.p226d.p233b.p256f.p259c.C2325e;
import org.p226d.p233b.p256f.p261e.C2347n;
import org.p226d.p233b.p256f.p261e.InterfaceC2340g;
import org.p226d.p233b.p262g.C2360a;
import org.p226d.p233b.p262g.C2362c;
import org.p226d.p233b.p262g.C2364e;
import org.p226d.p233b.p262g.C2367h;
import org.p226d.p233b.p262g.C2372m;
import org.p226d.p233b.p262g.C2375p;
import org.p226d.p233b.p262g.InterfaceC2374o;
import org.p226d.p233b.p262g.InterfaceC2377r;
import org.p226d.p233b.p264i.p265a.C2398d;
import org.p226d.p233b.p264i.p266b.C2409i;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p059d.C0542g;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3101bc;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p295a.C2608a;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: EmbedProvider.java */
/* renamed from: ru.maximoff.apktool.e.r */
/* loaded from: classes.dex */
public class AsyncTaskC2947r extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final String f15728a;

    /* renamed from: b */
    private Context f15729b;

    /* renamed from: c */
    private File f15730c;

    /* renamed from: d */
    private File f15731d;

    /* renamed from: e */
    private String f15732e;

    /* renamed from: f */
    private String f15733f;

    /* renamed from: g */
    private int f15734g;

    /* renamed from: h */
    private int f15735h;

    /* renamed from: i */
    private int f15736i;

    /* renamed from: j */
    private int f15737j;

    /* renamed from: k */
    private C3081am f15738k;

    /* renamed from: l */
    private boolean f15739l;

    /* renamed from: m */
    private C3101bc f15740m;

    public AsyncTaskC2947r(Context context, InterfaceC2995n interfaceC2995n, C3081am c3081am) {
        super(context, interfaceC2995n);
        this.f15728a = "Lbin/mt/file/content/MTDataFilesProvider;";
        this.f15736i = 8;
        this.f15737j = 8;
        this.f15739l = false;
        this.f15729b = context;
        this.f15738k = c3081am;
        this.f15733f = "Lbin/mt/file/content/MTDataFilesProvider;";
        this.f15732e = this.f15738k.m18634j();
        this.f15735h = 0;
        this.f15734g = Math.max(this.f15738k.m18632h(), 14);
    }

    /* renamed from: g */
    public void m17566g(boolean z) {
        if (z) {
            this.f15733f = new StringBuffer().append(new StringBuffer().append("L").append(C3112bn.m19042q(this.f15728a.substring(1, this.f15728a.length() - 1).replace("/", ".")).replace(".", "/")).toString()).append(";").toString();
        } else {
            this.f15733f = "Lbin/mt/file/content/MTDataFilesProvider;";
        }
        this.f15739l = z;
    }

    /* renamed from: a */
    public void m17565a(int i) {
        this.f15735h = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.embed_dp;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        mo3984d(R.string.mplease_wait, (Object) null);
        try {
            try {
                m17564l();
                this.f15730c = m17553a(fileArr[0], (String) null);
                if (this.f15730c == null) {
                    Boolean bool = new Boolean(false);
                    C0542g.m3987a(this.f15731d);
                    if (this.f15740m == null) {
                        return bool;
                    }
                    this.f15740m.m18902a().delete();
                    return bool;
                }
                this.f15731d = new File(this.f15730c.getParentFile(), new StringBuffer().append(".AM_EmbedProvider_").append(System.currentTimeMillis()).toString());
                if (this.f15731d.exists()) {
                    C0542g.m3987a(this.f15731d);
                }
                this.f15731d.mkdirs();
                Boolean mo17049a = super.mo17049a(fileArr);
                C0542g.m3987a(this.f15731d);
                if (this.f15740m == null) {
                    return mo17049a;
                }
                this.f15740m.m18902a().delete();
                return mo17049a;
            } finally {
                C0542g.m3987a(this.f15731d);
                if (this.f15740m != null) {
                    this.f15740m.m18902a().delete();
                }
            }
        } catch (Error | Exception e2) {
            mo3979a(R.string.errorf, e2.toString());
            return new Boolean(false);
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        try {
            try {
                byte[] bArr = new byte[C3249i.m19500a()];
                C2604w c2604w = new C2604w(file);
                Enumeration<C2602u> m16163b = c2604w.m16163b();
                int i = 0;
                while (m16163b.hasMoreElements()) {
                    C2602u nextElement = m16163b.nextElement();
                    if (!nextElement.isDirectory()) {
                        String name = nextElement.getName();
                        if (name.matches("^classes(\\d+)?\\.dex$")) {
                            this.f15736i = nextElement.getMethod();
                            i++;
                        } else if (name.equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                            this.f15737j = nextElement.getMethod();
                            File file2 = new File(this.f15731d, new StringBuffer().append(nextElement.getName()).append("_tmp").toString());
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(this.f15731d, nextElement.getName());
                            if (file3.exists()) {
                                continue;
                            } else {
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), bArr.length);
                                while (true) {
                                    try {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th) {
                                        bufferedInputStream.close();
                                        bufferedOutputStream.close();
                                        throw th;
                                    }
                                }
                                bufferedInputStream.close();
                                bufferedOutputStream.close();
                                mo3984d(R.string.mprocessing_file, name);
                                m17554a(file2, file3);
                                C3262u.m19610a(file3, nextElement.getTime());
                                file2.delete();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                m17558b(this.f15731d, i > 0 ? new StringBuffer().append(new StringBuffer().append("classes").append(i + 1).toString()).append(".dex").toString() : "classes.dex");
                File file4 = new File(this.f15731d, new StringBuffer().append(file.getName()).append("_na").toString());
                File file5 = new File(this.f15731d, file.getName());
                m17556a(file.getAbsolutePath(), file4.getAbsolutePath(), this.f15731d.listFiles(new FileFilter(this, file5) { // from class: ru.maximoff.apktool.e.r.1

                    /* renamed from: a */
                    private final AsyncTaskC2947r f15741a;

                    /* renamed from: b */
                    private final File f15742b;

                    {
                        this.f15741a = this;
                        this.f15742b = file5;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file6) {
                        return !file6.equals(this.f15742b);
                    }
                }));
                C3317a.m20052a(file4.getAbsolutePath(), file5.getAbsolutePath());
                file4.delete();
                C2917as.m17314a(this.f15729b, this.f15735h, new C2917as.a(this, file5, (this.f15735h == 0 && C3102bd.m18925a(this.f15729b, "save_sign_data", true)) ? C3105bg.m18964a(file) : (InterfaceC0008c) null) { // from class: ru.maximoff.apktool.e.r.2

                    /* renamed from: a */
                    private final AsyncTaskC2947r f15743a;

                    /* renamed from: b */
                    private final File f15744b;

                    /* renamed from: c */
                    private final InterfaceC0008c f15745c;

                    {
                        this.f15743a = this;
                        this.f15744b = file5;
                        this.f15745c = r3;
                    }

                    @Override // ru.maximoff.apktool.p300e.C2917as.a
                    /* renamed from: a */
                    public void mo16440a(C2917as c2917as, boolean z) {
                        if (z) {
                            this.f15744b.renameTo(this.f15743a.f15730c);
                            if (this.f15745c != null) {
                                try {
                                    C3105bg.m18967a(this.f15743a.f15730c, this.f15745c);
                                    return;
                                } catch (IOException e2) {
                                    return;
                                }
                            }
                            return;
                        }
                        c2917as.m17320a(this.f15744b, this.f15743a.f15730c, this.f15743a.f15734g);
                        this.f15743a.mo3984d(R.string.sign_done, this.f15743a.f15730c.getAbsolutePath());
                        this.f15744b.delete();
                    }
                });
                m17060b(this.f15730c);
                return true;
            } finally {
                C0542g.m3987a(this.f15731d);
            }
        } catch (Error e2) {
            e = e2;
            mo3979a(R.string.errorf, e.toString());
            return false;
        } catch (Exception e3) {
            e = e3;
            mo3979a(R.string.errorf, e.toString());
            return false;
        }
    }

    /* renamed from: l */
    private void m17564l() {
        File createTempFile = File.createTempFile("dp_container", ".amdat", C3102bd.m18908a());
        InputStream open = this.f15729b.getAssets().open("dp.amdat");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        this.f15740m = new C3101bc(createTempFile);
    }

    /* renamed from: a */
    private File m17553a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15729b, file)) || C3102bd.m18925a(this.f15729b, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                mo3979a(R.string.output_directory_not_set, (Object) null);
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
        }
        if (str == null) {
            str = file.getName();
        }
        return new File(parent, C3262u.m19623b(this.f15729b, parent, str, "_dp", 0));
    }

    /* renamed from: a */
    private void m17556a(String str, String str2, File[] fileArr) {
        int i;
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        List<File> m19061a = C3117bs.m19061a(fileArr);
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            long j = 0;
            File file = new File(this.f15731d, name);
            if (file.isFile()) {
                if (m19061a.contains(file)) {
                    m19061a.remove(file);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), bArr.length);
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                if (0 == 0) {
                    j = C3117bs.m19057a(file.getAbsolutePath());
                }
                c2602u.setCrc(j);
                if (nextElement.getMethod() == 0) {
                    c2602u.setMethod(0);
                    c2602u.setSize(file.length());
                    c2602u.setCompressedSize(file.length());
                } else {
                    c2602u.setMethod(8);
                    c2602u.setCompressedSize(-1L);
                }
                m19496a.mo16214a(c2602u);
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        m19496a.write(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
                m19496a.flush();
                m19496a.m16218b();
            } else {
                C2602u c2602u2 = new C2602u(name);
                c2602u2.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                if (0 == 0) {
                    j = nextElement.getCrc();
                }
                c2602u2.setCrc(j);
                if (nextElement.getMethod() == 0 && j >= 0 && size >= 0) {
                    c2602u2.setMethod(0);
                    c2602u2.setSize(size);
                    c2602u2.setCompressedSize(size);
                } else {
                    c2602u2.setMethod(8);
                    c2602u2.setCompressedSize(-1L);
                }
                m19496a.mo16214a(c2602u2);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                while (true) {
                    int read2 = bufferedInputStream2.read(bArr);
                    if (read2 == -1) {
                        break;
                    } else {
                        m19496a.write(bArr, 0, read2);
                    }
                }
                bufferedInputStream2.close();
                m19496a.flush();
                m19496a.m16218b();
            }
        }
        if (!m19061a.isEmpty()) {
            int length = this.f15731d.getAbsolutePath().length() + 1;
            for (File file2 : m19061a) {
                if (!file2.isDirectory()) {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file2), bArr.length);
                    C2602u c2602u3 = new C2602u(file2.getAbsolutePath().substring(length));
                    c2602u3.setTime(file2.lastModified());
                    if (file2.getName().endsWith(".xml")) {
                        i = this.f15737j;
                    } else {
                        i = this.f15736i;
                    }
                    c2602u3.setMethod(i);
                    c2602u3.setCrc(C3117bs.m19057a(file2.getAbsolutePath()));
                    if (i == 0) {
                        c2602u3.setMethod(0);
                        c2602u3.setSize(file2.length());
                        c2602u3.setCompressedSize(file2.length());
                    } else {
                        c2602u3.setMethod(8);
                        c2602u3.setCompressedSize(-1L);
                    }
                    m19496a.mo16214a(c2602u3);
                    while (true) {
                        int read3 = bufferedInputStream3.read(bArr);
                        if (read3 == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read3);
                        }
                    }
                    bufferedInputStream3.close();
                    m19496a.flush();
                    m19496a.m16218b();
                }
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: b */
    private void m17558b(File file, String str) {
        File file2 = new File(file, str);
        InputStream m18903a = this.f15740m.m18903a("dp.dex");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        C1887e.m13962a(m18903a, fileOutputStream);
        m18903a.close();
        fileOutputStream.close();
        mo3984d(R.string.mprocessing_file, file2.getName());
        if (this.f15739l) {
            m17555a(file2.getAbsolutePath());
        } else {
            m17561d(file2);
        }
    }

    /* renamed from: a */
    private void m17554a(File file, File file2) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass3(this, c0548d));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: EmbedProvider.java */
    /* renamed from: ru.maximoff.apktool.e.r$3, reason: invalid class name */
    class AnonymousClass3 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2947r f15746a;

        AnonymousClass3(AsyncTaskC2947r asyncTaskC2947r, AbstractC0549e abstractC0549e) {
            super(abstractC0549e);
            this.f15746a = asyncTaskC2947r;
        }

        /* renamed from: a */
        static AsyncTaskC2947r m17567a(AnonymousClass3 anonymousClass3) {
            return anonymousClass3.f15746a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2));
        }

        /* compiled from: EmbedProvider.java */
        /* renamed from: ru.maximoff.apktool.e.r$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass3 f15747a;

            AnonymousClass1(AnonymousClass3 anonymousClass3, AbstractC0549e abstractC0549e) {
                super(abstractC0549e);
                this.f15747a = anonymousClass3;
            }

            /* renamed from: a */
            static AnonymousClass3 m17568a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15747a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                return str2.equalsIgnoreCase("application") ? new AbstractC0549e(this, super.mo4019a(str, str2), str) { // from class: ru.maximoff.apktool.e.r.3.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f15748a;

                    /* renamed from: b */
                    private final String f15749b;

                    {
                        this.f15748a = this;
                        this.f15749b = str;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                        super.mo4032a(str3, str4, i, i2, obj);
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4024a() {
                        int identifier = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("name", C0497h.f3457a, "android");
                        if (identifier == 0) {
                            identifier = C0012R.attr.name;
                        }
                        int identifier2 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier(UsbManager.EXTRA_PERMISSION_GRANTED, C0497h.f3457a, "android");
                        int i = identifier2 == 0 ? 16842758 : identifier2;
                        int identifier3 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("exported", C0497h.f3457a, "android");
                        if (identifier3 == 0) {
                            identifier3 = C0012R.attr.exported;
                        }
                        int identifier4 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier(Settings.EXTRA_AUTHORITIES, C0497h.f3457a, "android");
                        int i2 = identifier4 == 0 ? 16842776 : identifier4;
                        int identifier5 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("grantUriPermissions", C0497h.f3457a, "android");
                        int i3 = identifier5 == 0 ? 16842779 : identifier5;
                        if (!AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15739l) {
                            int identifier6 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("taskAffinity", C0497h.f3457a, "android");
                            if (identifier6 == 0) {
                                identifier6 = C0012R.attr.taskAffinity;
                            }
                            int identifier7 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("excludeFromRecents", C0497h.f3457a, "android");
                            int i4 = identifier7 == 0 ? 16842775 : identifier7;
                            int identifier8 = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15729b.getResources().getIdentifier("noHistory", C0497h.f3457a, "android");
                            int i5 = identifier8 == 0 ? 16843309 : identifier8;
                            AbstractC0549e a2 = mo4019a(this.f15749b, Context.ACTIVITY_SERVICE);
                            a2.mo4032a("http://schemas.android.com/apk/res/android", "name", identifier, 3, "bin.mt.file.content.MTDataFilesWakeUpActivity");
                            a2.mo4032a("http://schemas.android.com/apk/res/android", "exported", identifier3, 18, new Integer(1));
                            a2.mo4032a("http://schemas.android.com/apk/res/android", "taskAffinity", identifier6, 3, new StringBuffer().append(AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15732e).append(".MTDataFilesWakeUp").toString());
                            a2.mo4032a("http://schemas.android.com/apk/res/android", "excludeFromRecents", i4, 18, new Integer(1));
                            a2.mo4032a("http://schemas.android.com/apk/res/android", "noHistory", i5, 18, new Integer(1));
                            a2.mo4024a();
                        }
                        String replace = AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15733f.substring(1, AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15733f.length() - 1).replace("/", ".");
                        AbstractC0549e a3 = mo4019a(this.f15749b, "provider");
                        a3.mo4032a("http://schemas.android.com/apk/res/android", "name", identifier, 3, replace);
                        a3.mo4032a("http://schemas.android.com/apk/res/android", UsbManager.EXTRA_PERMISSION_GRANTED, i, 3, Manifest.permission.MANAGE_DOCUMENTS);
                        a3.mo4032a("http://schemas.android.com/apk/res/android", "exported", identifier3, 18, new Integer(1));
                        a3.mo4032a("http://schemas.android.com/apk/res/android", Settings.EXTRA_AUTHORITIES, i2, 3, new StringBuffer().append(AnonymousClass3.m17567a(AnonymousClass1.m17568a(this.f15748a)).f15732e).append(replace.substring(replace.lastIndexOf(46))).toString());
                        a3.mo4032a("http://schemas.android.com/apk/res/android", "grantUriPermissions", i3, 18, new Integer(1));
                        AbstractC0549e mo4019a = a3.mo4019a(this.f15749b, "intent-filter");
                        AbstractC0549e mo4019a2 = mo4019a.mo4019a(this.f15749b, "action");
                        mo4019a2.mo4032a("http://schemas.android.com/apk/res/android", "name", identifier, 3, DocumentsContract.PROVIDER_INTERFACE);
                        mo4019a2.mo4024a();
                        mo4019a.mo4024a();
                        a3.mo4024a();
                        super.mo4024a();
                    }
                } : super.mo4019a(str, str2);
            }
        }
    }

    /* renamed from: a */
    private void m17555a(String str) {
        C2016c.m14455a(str, new C2364e(new AnonymousClass4(this)).m15031a(C2016c.m14454a(str, C2359g.m15023a(this.f15734g))));
    }

    /* compiled from: EmbedProvider.java */
    /* renamed from: ru.maximoff.apktool.e.r$4, reason: invalid class name */
    class AnonymousClass4 extends C2375p {

        /* renamed from: a */
        private final AsyncTaskC2947r f15750a;

        AnonymousClass4(AsyncTaskC2947r asyncTaskC2947r) {
            this.f15750a = asyncTaskC2947r;
        }

        /* renamed from: a */
        static AsyncTaskC2947r m17569a(AnonymousClass4 anonymousClass4) {
            return anonymousClass4.f15750a;
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: a */
        public InterfaceC2374o<InterfaceC2244d> mo15047a(InterfaceC2377r interfaceC2377r) {
            return new C2362c(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.r.4.1

                /* renamed from: b */
                private final AnonymousClass4 f15751b;

                {
                    this.f15751b = this;
                }

                @Override // org.p226d.p233b.p262g.C2362c
                /* renamed from: a */
                public InterfaceC2244d mo15030a(InterfaceC2244d interfaceC2244d) {
                    if (interfaceC2244d.mo14205l().equals("Lbin/mt/file/content/MTDataFilesProvider;")) {
                        return super.mo15030a((InterfaceC2244d) new C2320c(AnonymousClass4.m17569a(this.f15751b).f15733f, interfaceC2244d.mo14194a(), interfaceC2244d.mo14195b(), interfaceC2244d.mo14196c(), interfaceC2244d.mo14197d(), interfaceC2244d.mo14198e(), interfaceC2244d.mo14199f(), interfaceC2244d.mo14200g(), interfaceC2244d.mo14202i(), interfaceC2244d.mo14203j()));
                    }
                    return interfaceC2244d;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: j */
        public InterfaceC2374o<String> mo15056j(InterfaceC2377r interfaceC2377r) {
            return new InterfaceC2374o<String>(this) { // from class: ru.maximoff.apktool.e.r.4.2

                /* renamed from: a */
                private final AnonymousClass4 f15752a;

                {
                    this.f15752a = this;
                }

                @Override // org.p226d.p233b.p262g.InterfaceC2374o
                /* renamed from: a */
                public /* bridge */ String mo15030a(String str) {
                    return a2(str);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                public String a2(String str) {
                    if (str.equals("Lbin/mt/file/content/MTDataFilesProvider;")) {
                        return AnonymousClass4.m17569a(this.f15752a).f15733f;
                    }
                    return str;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: l */
        public InterfaceC2374o<InterfaceC2240e> mo15058l(InterfaceC2377r interfaceC2377r) {
            return new C2372m(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.r.4.3

                /* renamed from: b */
                private final AnonymousClass4 f15753b;

                {
                    this.f15753b = this;
                }

                @Override // org.p226d.p233b.p262g.C2372m
                /* renamed from: a */
                public InterfaceC2240e mo15030a(InterfaceC2240e interfaceC2240e) {
                    if (interfaceC2240e.mo14209a().equals("Lbin/mt/file/content/MTDataFilesProvider;")) {
                        return super.mo15030a((InterfaceC2240e) new C2325e(AnonymousClass4.m17569a(this.f15753b).f15733f, interfaceC2240e.mo14210b(), interfaceC2240e.mo14211c(), interfaceC2240e.mo14212d()));
                    }
                    return interfaceC2240e;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: k */
        public InterfaceC2374o<InterfaceC2237b> mo15057k(InterfaceC2377r interfaceC2377r) {
            return new C2367h(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.r.4.4

                /* renamed from: b */
                private final AnonymousClass4 f15754b;

                {
                    this.f15754b = this;
                }

                @Override // org.p226d.p233b.p262g.C2367h
                /* renamed from: a */
                public InterfaceC2237b mo15030a(InterfaceC2237b interfaceC2237b) {
                    if (interfaceC2237b.mo14225d().equals("Lbin/mt/file/content/MTDataFilesProvider;")) {
                        return super.mo15030a((InterfaceC2237b) new C2322b(AnonymousClass4.m17569a(this.f15754b).f15733f, interfaceC2237b.mo14226e(), interfaceC2237b.mo14227f()));
                    }
                    return interfaceC2237b;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: n */
        public InterfaceC2374o<InterfaceC2175b> mo15060n(InterfaceC2377r interfaceC2377r) {
            return new C2360a(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.r.4.5

                /* renamed from: b */
                private final AnonymousClass4 f15755b;

                {
                    this.f15755b = this;
                }

                @Override // org.p226d.p233b.p262g.C2360a
                /* renamed from: a */
                public InterfaceC2175b mo15030a(InterfaceC2175b interfaceC2175b) {
                    if (interfaceC2175b.mo14692a().equals("value") && interfaceC2175b.mo14693b().mo14430a() == 26) {
                        C2325e mo14739b = ((C2347n) interfaceC2175b.mo14693b()).mo14739b();
                        if (mo14739b.mo14209a().equals("Lbin/mt/file/content/MTDataFilesProvider;")) {
                            return super.mo15030a((InterfaceC2175b) new C2282b(interfaceC2175b.mo14692a(), (InterfaceC2340g) new C2347n(new C2325e(AnonymousClass4.m17569a(this.f15755b).f15733f, mo14739b.mo14210b(), mo14739b.mo14211c(), mo14739b.mo14212d()))));
                        }
                        return interfaceC2175b;
                    }
                    return interfaceC2175b;
                }
            };
        }
    }

    /* renamed from: d */
    private void m17561d(File file) {
        C2359g m15023a = C2359g.m15023a(this.f15734g);
        C2153g m14453a = C2016c.m14453a(file, m15023a);
        C2409i c2409i = new C2409i(m15023a);
        c2409i.m15249a(C2608a.m16252a(this.f15740m.m18903a("MTDataFilesWakeUpActivity.smali"), m15023a));
        Iterator<? extends InterfaceC2244d> it = m14453a.mo14769c().iterator();
        while (it.hasNext()) {
            c2409i.m15249a(it.next());
        }
        c2409i.m15405a(new C2398d(file));
    }
}
