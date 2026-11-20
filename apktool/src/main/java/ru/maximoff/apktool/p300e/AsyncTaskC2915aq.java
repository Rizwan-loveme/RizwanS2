package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.content.Context;
import android.p008os.Build;
import android.util.Base64;
import com.p065b.p066a.C0675d;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p111c.C1066c;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.ByteArrayOutputStream;
import java.p209io.DataOutputStream;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.FilenameFilter;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.p217b.p218a.p219a.C1887e;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.C2282b;
import org.p226d.p233b.p256f.C2320c;
import org.p226d.p233b.p256f.C2355g;
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
import ru.maximoff.apktool.util.C3074af;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3101bc;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3253m;
import ru.maximoff.apktool.util.C3257q;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p295a.C2608a;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: SignKiller.java */
/* renamed from: ru.maximoff.apktool.e.aq */
/* loaded from: classes.dex */
public class AsyncTaskC2915aq extends AbstractAsyncTaskC2898a {

    /* renamed from: A */
    private int f15316A;

    /* renamed from: B */
    private C3081am f15317B;

    /* renamed from: C */
    private List<String> f15318C;

    /* renamed from: D */
    private boolean f15319D;

    /* renamed from: E */
    private boolean f15320E;

    /* renamed from: F */
    private boolean f15321F;

    /* renamed from: G */
    private boolean f15322G;

    /* renamed from: H */
    private boolean f15323H;

    /* renamed from: I */
    private boolean f15324I;

    /* renamed from: J */
    private boolean f15325J;

    /* renamed from: K */
    private boolean f15326K;

    /* renamed from: L */
    private boolean f15327L;

    /* renamed from: M */
    private boolean f15328M;

    /* renamed from: N */
    private C3101bc f15329N;

    /* renamed from: a */
    private final List<String> f15330a;

    /* renamed from: b */
    private final String f15331b;

    /* renamed from: c */
    private final String f15332c;

    /* renamed from: d */
    private final String f15333d;

    /* renamed from: e */
    private final String f15334e;

    /* renamed from: f */
    private final int f15335f;

    /* renamed from: g */
    private final int f15336g;

    /* renamed from: h */
    private Context f15337h;

    /* renamed from: i */
    private ExecutorService f15338i;

    /* renamed from: j */
    private File f15339j;

    /* renamed from: k */
    private File f15340k;

    /* renamed from: l */
    private String f15341l;

    /* renamed from: m */
    private String f15342m;

    /* renamed from: n */
    private String f15343n;

    /* renamed from: o */
    private String f15344o;

    /* renamed from: p */
    private String f15345p;

    /* renamed from: q */
    private String f15346q;

    /* renamed from: r */
    private String f15347r;

    /* renamed from: s */
    private String f15348s;

    /* renamed from: t */
    private String f15349t;

    /* renamed from: u */
    private String f15350u;

    /* renamed from: v */
    private final String f15351v;

    /* renamed from: w */
    private int f15352w;

    /* renamed from: x */
    private int f15353x;

    /* renamed from: y */
    private int f15354y;

    /* renamed from: z */
    private int f15355z;

    public AsyncTaskC2915aq(Context context, InterfaceC2995n interfaceC2995n, C3081am c3081am) {
        super(context, interfaceC2995n);
        this.f15330a = new ArrayList(Arrays.asList("arm64-v8a", "armeabi-v7a", "x86", "x86_64"));
        this.f15331b = "Landroid/app/Application;";
        this.f15335f = 30;
        this.f15336g = 5;
        this.f15354y = 8;
        this.f15355z = 8;
        this.f15316A = 8;
        this.f15319D = false;
        this.f15320E = false;
        this.f15321F = false;
        this.f15322G = false;
        this.f15323H = false;
        this.f15324I = false;
        this.f15325J = true;
        this.f15326K = false;
        this.f15327L = false;
        this.f15328M = false;
        this.f15337h = context;
        this.f15317B = c3081am;
        this.f15351v = String.valueOf(1924304562);
        this.f15332c = new StringBuffer().append(new StringBuffer().append("L").append(C3074af.f17349a.replace(".", "/")).toString()).append(";").toString();
        this.f15333d = C3257q.m19520b("fUtHG15RTFxbXVdfHUdaV1pUQkdDXB18XF9fdEZCXVBRVUdZW1sN", this.f15351v);
        this.f15334e = C3257q.m19520b("UEpBUUdDG2ZfVV9YRkFBVX9cWl5USx1bQVlTXFgcUElZ", this.f15351v);
        this.f15341l = this.f15334e;
        this.f15347r = this.f15332c;
        String m18635k = this.f15317B.m18635k();
        if (m18635k != null) {
            if (!m18635k.contains(".")) {
                m18635k = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("L").append(this.f15317B.m18634j().replace(".", "/")).toString()).append("/").toString()).append(m18635k).toString()).append(";").toString();
            } else if (m18635k.startsWith(".")) {
                m18635k = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("L").append(this.f15317B.m18634j().replace(".", "/")).toString()).append(m18635k.replace(".", "/")).toString()).append(";").toString();
            } else {
                m18635k = new StringBuffer().append(new StringBuffer().append("L").append(m18635k.replace(".", "/")).toString()).append(";").toString();
            }
        }
        this.f15342m = m18635k;
        this.f15343n = m18635k;
        this.f15344o = this.f15317B.m18634j();
        this.f15353x = 0;
        this.f15352w = Math.max(this.f15317B.m18632h(), 14);
    }

    /* renamed from: a */
    public void m17290a(String str, String str2, String str3, String str4) {
        this.f15328M = true;
        this.f15347r = new StringBuffer().append(new StringBuffer().append("L").append(str.replace(".", "/")).toString()).append(";").toString();
        this.f15349t = str2;
        this.f15341l = str3;
        this.f15350u = str4;
    }

    /* renamed from: g */
    public void m17292g(boolean z) {
        String m19042q;
        if (z) {
            if (this.f15319D) {
                m19042q = C3112bn.m19042q(this.f15332c.substring(1, this.f15332c.length() - 1).replace("/", "."));
            } else {
                m19042q = C3112bn.m19042q(this.f15333d.substring(1, this.f15333d.length() - 1).replace("/", "."));
            }
            this.f15347r = new StringBuffer().append(new StringBuffer().append("L").append(m19042q.replace(".", "/")).toString()).append(";").toString();
        } else if (this.f15319D) {
            this.f15347r = this.f15332c;
        } else {
            this.f15347r = this.f15333d;
        }
        this.f15326K = z;
    }

    /* renamed from: h */
    public void m17293h(boolean z) {
        this.f15327L = z;
    }

    /* renamed from: i */
    public void m17294i(boolean z) {
        this.f15325J = z;
    }

    /* renamed from: j */
    public void m17295j(boolean z) {
        this.f15319D = z;
    }

    /* renamed from: k */
    public void m17296k(boolean z) {
        this.f15320E = z;
    }

    /* renamed from: l */
    public void m17297l(boolean z) {
        this.f15324I = z;
    }

    /* renamed from: a */
    public void m17288a(int i) {
        this.f15353x = i;
    }

    /* renamed from: a */
    public void m17289a(String str) {
        this.f15346q = str;
    }

    /* renamed from: m */
    public void m17298m(boolean z) {
        this.f15321F = z;
    }

    /* renamed from: b */
    public void m17291b(String str) {
        this.f15348s = str;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.kill_sign;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        mo3984d(R.string.mplease_wait, (Object) null);
        try {
            try {
                m17286l();
                this.f15318C = this.f15317B.m18646v();
                this.f15339j = m17263a(fileArr[0], (String) null);
                if (this.f15339j == null) {
                    Boolean bool = new Boolean(false);
                    C0542g.m3987a(this.f15340k);
                    if (this.f15329N == null) {
                        return bool;
                    }
                    this.f15329N.m18902a().delete();
                    return bool;
                }
                this.f15340k = new File(this.f15339j.getParentFile(), new StringBuffer().append(".AM_SignKiller_").append(System.currentTimeMillis()).toString());
                if (this.f15340k.exists()) {
                    C0542g.m3987a(this.f15340k);
                }
                this.f15340k.mkdirs();
                if (this.f15327L) {
                    this.f15341l = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("assets/").append(C3112bn.m18988a(C3080al.m18520a(7, 15))).toString()).append("/").toString()).append(C3112bn.m18988a(C3080al.m18520a(5, 10))).toString()).append(".apk").toString();
                }
                Boolean mo17049a = super.mo17049a(fileArr);
                C0542g.m3987a(this.f15340k);
                if (this.f15329N == null) {
                    return mo17049a;
                }
                this.f15329N.m18902a().delete();
                return mo17049a;
            } finally {
                C0542g.m3987a(this.f15340k);
                if (this.f15329N != null) {
                    this.f15329N.m18902a().delete();
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
        File file2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            try {
                if (!this.f15325J && !this.f15324I) {
                    mo3979a(R.string.error, new Object[0]);
                    return false;
                }
                if (this.f15342m != null && this.f15342m.equals(this.f15347r) && this.f15325J) {
                    mo3983c(R.string.kill_sign_exists, (Object) null);
                    return false;
                }
                if (this.f15345p == null && this.f15325J) {
                    if (!(this.f15321F ? m17280f(new File(this.f15346q)) : m17280f(file))) {
                        mo3983c(R.string.err_no_certs2, (Object) null);
                        C0542g.m3987a(this.f15340k);
                        return false;
                    }
                }
                if (this.f15343n != null && this.f15325J) {
                    mo3984d(R.string.search_class, this.f15343n);
                }
                if (this.f15325J) {
                    if (!this.f15317B.m18631g()) {
                        this.f15355z = 0;
                    }
                    this.f15338i = Executors.newFixedThreadPool(C3102bd.f18297ae);
                    byte[] bArr = new byte[C3249i.m19500a()];
                    C2604w c2604w = new C2604w(file);
                    Enumeration<C2602u> m16163b = c2604w.m16163b();
                    int i = 0;
                    while (m16163b.hasMoreElements()) {
                        C2602u nextElement = m16163b.nextElement();
                        if (!nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            if (name.matches("^classes(\\d+)?\\.dex$")) {
                                this.f15354y = nextElement.getMethod();
                                if (this.f15342m != null || !this.f15319D) {
                                    File file3 = new File(this.f15340k, name);
                                    if (!file3.exists()) {
                                        bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), bArr.length);
                                        while (true) {
                                            try {
                                                int read = bufferedInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } finally {
                                            }
                                        }
                                    }
                                    if (this.f15342m != null) {
                                        mo3984d(R.string.mprocessing_file, name);
                                        this.f15338i.submit(new a(this, file3.getAbsolutePath(), this.f15343n, nextElement.getTime()));
                                    }
                                }
                                i++;
                            } else if (name.equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                                this.f15316A = nextElement.getMethod();
                                if (this.f15342m == null || !this.f15319D) {
                                    File file4 = new File(this.f15340k, new StringBuffer().append(nextElement.getName()).append("_tmp").toString());
                                    if (file4.exists()) {
                                        file4.delete();
                                    }
                                    File file5 = new File(this.f15340k, nextElement.getName());
                                    if (file5.exists()) {
                                        continue;
                                    } else {
                                        bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file4), bArr.length);
                                        while (true) {
                                            try {
                                                int read2 = bufferedInputStream.read(bArr);
                                                if (read2 == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read2);
                                            } finally {
                                            }
                                        }
                                        bufferedInputStream.close();
                                        bufferedOutputStream.close();
                                        mo3984d(R.string.mprocessing_file, name);
                                        m17265a(file4, file5);
                                        C3262u.m19610a(file5, nextElement.getTime());
                                        file4.delete();
                                    }
                                }
                            } else if (name.startsWith("lib/") && name.endsWith(".so")) {
                                this.f15355z = nextElement.getMethod();
                            }
                        }
                    }
                    this.f15338i.shutdown();
                    do {
                    } while (!this.f15338i.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
                    if (this.f15322G) {
                        this.f15322G = false;
                        this.f15323H = false;
                        return mo17058a(file);
                    }
                    if (this.f15319D) {
                        m17270b(this.f15340k, i > 0 ? new StringBuffer().append(new StringBuffer().append("classes").append(i + 1).toString()).append(".dex").toString() : "classes.dex");
                    } else {
                        File m17287m = m17287m();
                        if (m17287m == null) {
                            mo3979a(R.string.errorf, "no suitable dex to embed a hook in");
                            C0542g.m3987a(this.f15340k);
                            return false;
                        }
                        m17278e(m17287m);
                    }
                }
                File file6 = new File(this.f15340k, new StringBuffer().append(file.getName()).append("_na").toString());
                File file7 = new File(this.f15340k, file.getName());
                m17266a(file.getAbsolutePath(), file6.getAbsolutePath(), this.f15340k.listFiles(new FileFilter(this, file7) { // from class: ru.maximoff.apktool.e.aq.1

                    /* renamed from: a */
                    private final AsyncTaskC2915aq f15356a;

                    /* renamed from: b */
                    private final File f15357b;

                    {
                        this.f15356a = this;
                        this.f15357b = file7;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file8) {
                        return !file8.equals(this.f15357b);
                    }
                }));
                C3317a.m20052a(file6.getAbsolutePath(), file7.getAbsolutePath());
                file6.delete();
                InterfaceC0008c m18964a = (this.f15353x == 0 && C3102bd.m18925a(this.f15337h, "save_sign_data", true)) ? C3105bg.m18964a(file) : (InterfaceC0008c) null;
                if (mo3981a()) {
                    C0542g.m3987a(this.f15340k);
                    return false;
                }
                C2917as.m17314a(this.f15337h, this.f15353x, new C2917as.a(this, file7, m18964a) { // from class: ru.maximoff.apktool.e.aq.2

                    /* renamed from: a */
                    private final AsyncTaskC2915aq f15358a;

                    /* renamed from: b */
                    private final File f15359b;

                    /* renamed from: c */
                    private final InterfaceC0008c f15360c;

                    {
                        this.f15358a = this;
                        this.f15359b = file7;
                        this.f15360c = m18964a;
                    }

                    @Override // ru.maximoff.apktool.p300e.C2917as.a
                    /* renamed from: a */
                    public void mo16440a(C2917as c2917as, boolean z) {
                        if (z) {
                            this.f15359b.renameTo(this.f15358a.f15339j);
                            if (this.f15360c != null) {
                                try {
                                    C3105bg.m18967a(this.f15358a.f15339j, this.f15360c);
                                    return;
                                } catch (IOException e2) {
                                    return;
                                }
                            }
                            return;
                        }
                        c2917as.m17320a(this.f15359b, this.f15358a.f15339j, this.f15358a.f15352w);
                        this.f15358a.mo3984d(R.string.sign_done, this.f15358a.f15339j.getAbsolutePath());
                        this.f15359b.delete();
                    }
                });
                m17060b(this.f15339j);
                return true;
            } finally {
                C0542g.m3987a(this.f15340k);
            }
        } catch (Error e2) {
            e = e2;
            mo3979a(R.string.errorf, e.toString());
            C0542g.m3987a(this.f15340k);
            return false;
        } catch (Exception e3) {
            e = e3;
            mo3979a(R.string.errorf, e.toString());
            C0542g.m3987a(this.f15340k);
            return false;
        }
    }

    /* renamed from: a */
    private File m17263a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15337h, file)) || C3102bd.m18925a(this.f15337h, "all_to_out_dir", false)) {
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
        return new File(parent, C3262u.m19623b(this.f15337h, parent, str, "_kill", 0));
    }

    /* renamed from: l */
    private void m17286l() {
        File createTempFile = File.createTempFile("killer_container", ".amdat", C3102bd.m18908a());
        InputStream open = this.f15337h.getAssets().open("killer.amdat");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        this.f15329N = new C3101bc(createTempFile);
    }

    /* renamed from: a */
    private void m17266a(String str, String str2, File[] fileArr) {
        C2604w c2604w;
        int i;
        C2602u m16162a;
        if (this.f15324I && this.f15346q != null) {
            C2604w c2604w2 = new C2604w(this.f15346q);
            mo3984d(R.string.checksums_original, new Object[0]);
            c2604w = c2604w2;
        } else {
            c2604w = (C2604w) null;
        }
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(c2604w != null || C3102bd.f18315aw);
        C2604w c2604w3 = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w3.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        List<File> m19061a = C3117bs.m19061a(fileArr);
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            long j = 0;
            if (c2604w != null && (m16162a = c2604w.m16162a(name)) != null) {
                j = m16162a.getCrc();
            }
            File file = new File(this.f15340k, name);
            if (file.isFile()) {
                if (m19061a.contains(file)) {
                    m19061a.remove(file);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), bArr.length);
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                if (j == 0) {
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
                if (j == 0) {
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
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c2604w3.m16160a(nextElement), bArr.length);
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
            int length = this.f15340k.getAbsolutePath().length() + 1;
            for (File file2 : m19061a) {
                if (!file2.isDirectory()) {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file2), bArr.length);
                    C2602u c2602u3 = new C2602u(file2.getAbsolutePath().substring(length));
                    c2602u3.setTime(file2.lastModified());
                    if (file2.getName().endsWith(".so")) {
                        i = this.f15355z;
                    } else if (file2.getName().endsWith(".xml")) {
                        i = this.f15316A;
                    } else {
                        i = this.f15354y;
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
        if (this.f15320E) {
            File file3 = new File(this.f15346q);
            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file3), bArr.length);
            C2602u c2602u4 = new C2602u(this.f15341l);
            c2602u4.setTime(file3.lastModified());
            c2602u4.setMethod(8);
            c2602u4.setCrc(C3117bs.m19057a(file3.getAbsolutePath()));
            c2602u4.setMethod(8);
            c2602u4.setCompressedSize(-1L);
            m19496a.mo16214a(c2602u4);
            while (true) {
                int read4 = bufferedInputStream4.read(bArr);
                if (read4 == -1) {
                    break;
                } else {
                    m19496a.write(bArr, 0, read4);
                }
            }
            bufferedInputStream4.close();
            m19496a.flush();
            m19496a.m16218b();
        }
        m19496a.flush();
        m19496a.close();
        c2604w3.close();
    }

    /* renamed from: b */
    private void m17270b(File file, String str) {
        String str2;
        File file2 = new File(file, str);
        InputStream m18903a = this.f15329N.m18903a(new StringBuffer().append(new StringBuffer().append("killer").append(this.f15328M ? "2" : "").toString()).append(".dex").toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        C1887e.m13962a(m18903a, fileOutputStream);
        m18903a.close();
        fileOutputStream.close();
        m17276d(file2);
        m17274c(file2.getAbsolutePath());
        if (this.f15320E) {
            if (this.f15318C.isEmpty()) {
                this.f15318C = this.f15330a;
            }
            for (String str3 : this.f15318C) {
                if (this.f15330a.contains(str3)) {
                    str2 = str3;
                } else if (str3.startsWith("arm")) {
                    str2 = "armeabi-v7a";
                }
                File file3 = new File(file, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("lib/").append(str3).toString()).append("/").toString()).append(this.f15328M ? new StringBuffer().append("lib").append(this.f15349t).toString() : "libSignatureKiller").toString()).append(".so").toString());
                file3.getParentFile().mkdirs();
                InputStream m18903a2 = this.f15329N.m18903a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str2).append("/libSignatureKiller").toString()).append(this.f15328M ? "2" : "").toString()).append(".so").toString());
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                C1887e.m13962a(m18903a2, fileOutputStream2);
                m18903a2.close();
                fileOutputStream2.close();
            }
        }
    }

    /* renamed from: d */
    private void m17276d(File file) {
        C2359g m15023a = C2359g.m15023a(this.f15352w);
        C2153g m14453a = C2016c.m14453a(file, m15023a);
        C2409i c2409i = new C2409i(m15023a);
        String replace = C3061a.m18312b(this.f15329N.m18903a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("KillerApplication").append(this.f15328M ? "Ex" : "").toString()).append(this.f15348s == null ? "" : "2").toString()).append(".smali").toString())).replace("### PACKAGE ###", this.f15344o).replace("### SIGNATURE ###", this.f15345p);
        if (this.f15348s != null) {
            replace = replace.replace("### INSTALLER ###", this.f15348s);
        }
        if (this.f15327L) {
            replace = replace.replace(new StringBuffer().append(new StringBuffer().append("\"").append(this.f15334e).toString()).append("\"").toString(), new StringBuffer().append(new StringBuffer().append("\"").append(this.f15341l).toString()).append("\"").toString()).replace("\"origin.apk\"", new StringBuffer().append(new StringBuffer().append("\"").append(this.f15341l.substring(this.f15341l.lastIndexOf(47) + 1)).toString()).append("\"").toString());
        }
        if (this.f15328M) {
            if (this.f15320E) {
                replace = replace.replace("### LIBNAME ###", this.f15349t).replace("### INJECTNAME ###", this.f15341l).replace("### EXTRACTNAME ###", this.f15350u);
            } else {
                replace = replace.replace("### LIBNAME ###", "").replace("### INJECTNAME ###", "").replace("### EXTRACTNAME ###", "");
            }
        }
        File file2 = new File(this.f15340k, "KillerApplication.smali");
        C3061a.m18319b(file2, replace);
        c2409i.m15249a(C2608a.m16251a(file2, m15023a));
        Iterator<? extends InterfaceC2244d> it = m14453a.mo14769c().iterator();
        while (it.hasNext()) {
            c2409i.m15249a(it.next());
        }
        c2409i.m15405a(new C2398d(file));
        file2.delete();
    }

    /* renamed from: a */
    private void m17265a(File file, File file2) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass3(this, c0548d));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: SignKiller.java */
    /* renamed from: ru.maximoff.apktool.e.aq$3, reason: invalid class name */
    class AnonymousClass3 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2915aq f15361a;

        AnonymousClass3(AsyncTaskC2915aq asyncTaskC2915aq, AbstractC0549e abstractC0549e) {
            super(abstractC0549e);
            this.f15361a = asyncTaskC2915aq;
        }

        /* renamed from: a */
        static AsyncTaskC2915aq m17299a(AnonymousClass3 anonymousClass3) {
            return anonymousClass3.f15361a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2));
        }

        /* compiled from: SignKiller.java */
        /* renamed from: ru.maximoff.apktool.e.aq$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass3 f15362a;

            AnonymousClass1(AnonymousClass3 anonymousClass3, AbstractC0549e abstractC0549e) {
                super(abstractC0549e);
                this.f15362a = anonymousClass3;
            }

            /* renamed from: a */
            static AnonymousClass3 m17300a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15362a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                return str2.equalsIgnoreCase("application") ? new AbstractC0549e(this, super.mo4019a(str, str2)) { // from class: ru.maximoff.apktool.e.aq.3.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f15363a;

                    {
                        this.f15363a = this;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                        super.mo4032a(str3, str4, i, i2, str4.equals("name") ? AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15347r.substring(1, AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15347r.length() - 1).replace("/", ".") : obj);
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4024a() {
                        if (AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15342m == null) {
                            int identifier = AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15337h.getResources().getIdentifier("name", C0497h.f3457a, "android");
                            if (identifier == 0) {
                                identifier = C0012R.attr.name;
                            }
                            super.mo4032a("http://schemas.android.com/apk/res/android", "name", identifier, 3, AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15347r.substring(1, AnonymousClass3.m17299a(AnonymousClass1.m17300a(this.f15363a)).f15347r.length() - 1).replace("/", "."));
                        }
                        super.mo4024a();
                    }
                } : super.mo4019a(str, str2);
            }
        }
    }

    /* renamed from: e */
    private void m17278e(File file) {
        mo3984d(R.string.mprocessing_file, file.getName());
        C2359g m15023a = C2359g.m15023a(this.f15352w);
        C2153g m14453a = C2016c.m14453a(file, m15023a);
        C2409i c2409i = new C2409i(m15023a);
        String replace = C3061a.m18312b(this.f15329N.m18903a(new StringBuffer().append(new StringBuffer().append("HookApplication").append(this.f15348s == null ? "" : "2").toString()).append(".smali").toString())).replace("### PACKAGE ###", this.f15344o).replace("### SIGNATURE ###", this.f15345p);
        if (this.f15348s != null) {
            replace = replace.replace("### INSTALLER ###", this.f15348s);
        }
        if (this.f15342m != null) {
            replace = replace.replace("Landroid/app/Application;", this.f15342m);
        }
        if (this.f15326K) {
            replace = replace.replace(this.f15333d, this.f15347r);
        }
        File file2 = new File(this.f15340k, "HookApplication.smali");
        C3061a.m18319b(file2, replace);
        c2409i.m15249a(C2608a.m16251a(file2, m15023a));
        Iterator<? extends InterfaceC2244d> it = m14453a.mo14769c().iterator();
        while (it.hasNext()) {
            c2409i.m15249a(it.next());
        }
        c2409i.m15405a(new C2398d(file));
        file2.delete();
    }

    /* renamed from: m */
    private File m17287m() {
        File[] listFiles = this.f15340k.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.aq.4

            /* renamed from: a */
            private final AsyncTaskC2915aq f15364a;

            {
                this.f15364a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".dex");
            }
        });
        if (listFiles != null) {
            for (File file : listFiles) {
                C3253m m19624b = C3262u.m19624b(file);
                if (65536 - m19624b.f19660f > 30 && 65536 - m19624b.f19659e > 5) {
                    return file;
                }
            }
        }
        return (File) null;
    }

    /* renamed from: c */
    private void m17274c(String str) {
        C2016c.m14455a(str, new C2364e(new AnonymousClass5(this)).m15031a(C2016c.m14454a(str, C2359g.m15023a(this.f15352w))));
    }

    /* compiled from: SignKiller.java */
    /* renamed from: ru.maximoff.apktool.e.aq$5, reason: invalid class name */
    class AnonymousClass5 extends C2375p {

        /* renamed from: a */
        private final AsyncTaskC2915aq f15365a;

        AnonymousClass5(AsyncTaskC2915aq asyncTaskC2915aq) {
            this.f15365a = asyncTaskC2915aq;
        }

        /* renamed from: a */
        static AsyncTaskC2915aq m17301a(AnonymousClass5 anonymousClass5) {
            return anonymousClass5.f15365a;
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: a */
        public InterfaceC2374o<InterfaceC2244d> mo15047a(InterfaceC2377r interfaceC2377r) {
            return new C2362c(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.aq.5.1

                /* renamed from: b */
                private final AnonymousClass5 f15366b;

                {
                    this.f15366b = this;
                }

                @Override // org.p226d.p233b.p262g.C2362c
                /* renamed from: a */
                public InterfaceC2244d mo15030a(InterfaceC2244d interfaceC2244d) {
                    if (!AnonymousClass5.m17301a(this.f15366b).f15326K && !AnonymousClass5.m17301a(this.f15366b).f15328M) {
                        return super.mo15030a(interfaceC2244d);
                    }
                    String mo14205l = interfaceC2244d.mo14205l();
                    if (mo14205l.equals(AnonymousClass5.m17301a(this.f15366b).f15332c)) {
                        return super.mo15030a((InterfaceC2244d) new C2320c(AnonymousClass5.m17301a(this.f15366b).f15347r, interfaceC2244d.mo14194a(), interfaceC2244d.mo14195b(), interfaceC2244d.mo14196c(), interfaceC2244d.mo14197d(), interfaceC2244d.mo14198e(), interfaceC2244d.mo14199f(), interfaceC2244d.mo14200g(), interfaceC2244d.mo14202i(), interfaceC2244d.mo14203j()));
                    }
                    if (mo14205l.startsWith(new StringBuffer().append(AnonymousClass5.m17301a(this.f15366b).f15332c.substring(0, AnonymousClass5.m17301a(this.f15366b).f15332c.length() - 1)).append("$").toString())) {
                        return super.mo15030a((InterfaceC2244d) new C2320c(new StringBuffer().append(new StringBuffer().append(AnonymousClass5.m17301a(this.f15366b).f15347r.substring(0, AnonymousClass5.m17301a(this.f15366b).f15347r.length() - 1)).append("$").toString()).append(mo14205l.substring(AnonymousClass5.m17301a(this.f15366b).f15332c.length())).toString(), interfaceC2244d.mo14194a(), interfaceC2244d.mo14195b(), interfaceC2244d.mo14196c(), interfaceC2244d.mo14197d(), interfaceC2244d.mo14198e(), interfaceC2244d.mo14199f(), interfaceC2244d.mo14200g(), interfaceC2244d.mo14202i(), interfaceC2244d.mo14203j()));
                    }
                    return interfaceC2244d;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: j */
        public InterfaceC2374o<String> mo15056j(InterfaceC2377r interfaceC2377r) {
            return new InterfaceC2374o<String>(this) { // from class: ru.maximoff.apktool.e.aq.5.2

                /* renamed from: a */
                private final AnonymousClass5 f15367a;

                {
                    this.f15367a = this;
                }

                @Override // org.p226d.p233b.p262g.InterfaceC2374o
                /* renamed from: a */
                public /* bridge */ String mo15030a(String str) {
                    return a2(str);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                public String a2(String str) {
                    if (AnonymousClass5.m17301a(this.f15367a).f15326K || AnonymousClass5.m17301a(this.f15367a).f15328M) {
                        if (str.equals(AnonymousClass5.m17301a(this.f15367a).f15332c)) {
                            return AnonymousClass5.m17301a(this.f15367a).f15347r;
                        }
                        if (str.startsWith(new StringBuffer().append(AnonymousClass5.m17301a(this.f15367a).f15332c.substring(0, AnonymousClass5.m17301a(this.f15367a).f15332c.length() - 1)).append("$").toString())) {
                            return new StringBuffer().append(new StringBuffer().append(AnonymousClass5.m17301a(this.f15367a).f15347r.substring(0, AnonymousClass5.m17301a(this.f15367a).f15347r.length() - 1)).append("$").toString()).append(str.substring(AnonymousClass5.m17301a(this.f15367a).f15332c.length())).toString();
                        }
                        return str;
                    }
                    return str;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: l */
        public InterfaceC2374o<InterfaceC2240e> mo15058l(InterfaceC2377r interfaceC2377r) {
            return new C2372m(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.aq.5.3

                /* renamed from: b */
                private final AnonymousClass5 f15368b;

                {
                    this.f15368b = this;
                }

                @Override // org.p226d.p233b.p262g.C2372m
                /* renamed from: a */
                public InterfaceC2240e mo15030a(InterfaceC2240e interfaceC2240e) {
                    if (AnonymousClass5.m17301a(this.f15368b).f15326K || AnonymousClass5.m17301a(this.f15368b).f15328M) {
                        String mo14209a = interfaceC2240e.mo14209a();
                        if (mo14209a.equals(AnonymousClass5.m17301a(this.f15368b).f15332c)) {
                            return super.mo15030a((InterfaceC2240e) new C2325e(AnonymousClass5.m17301a(this.f15368b).f15347r, interfaceC2240e.mo14210b(), interfaceC2240e.mo14211c(), interfaceC2240e.mo14212d()));
                        }
                        if (mo14209a.startsWith(new StringBuffer().append(AnonymousClass5.m17301a(this.f15368b).f15332c.substring(0, AnonymousClass5.m17301a(this.f15368b).f15332c.length() - 1)).append("$").toString())) {
                            return super.mo15030a((InterfaceC2240e) new C2325e(new StringBuffer().append(new StringBuffer().append(AnonymousClass5.m17301a(this.f15368b).f15347r.substring(0, AnonymousClass5.m17301a(this.f15368b).f15347r.length() - 1)).append("$").toString()).append(mo14209a.substring(AnonymousClass5.m17301a(this.f15368b).f15332c.length())).toString(), interfaceC2240e.mo14210b(), interfaceC2240e.mo14211c(), interfaceC2240e.mo14212d()));
                        }
                        return interfaceC2240e;
                    }
                    return interfaceC2240e;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: k */
        public InterfaceC2374o<InterfaceC2237b> mo15057k(InterfaceC2377r interfaceC2377r) {
            return new C2367h(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.aq.5.4

                /* renamed from: b */
                private final AnonymousClass5 f15369b;

                {
                    this.f15369b = this;
                }

                @Override // org.p226d.p233b.p262g.C2367h
                /* renamed from: a */
                public InterfaceC2237b mo15030a(InterfaceC2237b interfaceC2237b) {
                    if (AnonymousClass5.m17301a(this.f15369b).f15326K || AnonymousClass5.m17301a(this.f15369b).f15328M) {
                        String mo14225d = interfaceC2237b.mo14225d();
                        if (mo14225d.equals(AnonymousClass5.m17301a(this.f15369b).f15332c)) {
                            return super.mo15030a((InterfaceC2237b) new C2322b(AnonymousClass5.m17301a(this.f15369b).f15347r, interfaceC2237b.mo14226e(), interfaceC2237b.mo14227f()));
                        }
                        if (mo14225d.startsWith(new StringBuffer().append(AnonymousClass5.m17301a(this.f15369b).f15332c.substring(0, AnonymousClass5.m17301a(this.f15369b).f15332c.length() - 1)).append("$").toString())) {
                            return super.mo15030a((InterfaceC2237b) new C2322b(new StringBuffer().append(new StringBuffer().append(AnonymousClass5.m17301a(this.f15369b).f15347r.substring(0, AnonymousClass5.m17301a(this.f15369b).f15347r.length() - 1)).append("$").toString()).append(mo14225d.substring(AnonymousClass5.m17301a(this.f15369b).f15332c.length())).toString(), interfaceC2237b.mo14226e(), interfaceC2237b.mo14227f()));
                        }
                        return interfaceC2237b;
                    }
                    return interfaceC2237b;
                }
            };
        }

        @Override // org.p226d.p233b.p262g.C2375p
        /* renamed from: n */
        public InterfaceC2374o<InterfaceC2175b> mo15060n(InterfaceC2377r interfaceC2377r) {
            return new C2360a(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.aq.5.5

                /* renamed from: b */
                private final AnonymousClass5 f15370b;

                {
                    this.f15370b = this;
                }

                @Override // org.p226d.p233b.p262g.C2360a
                /* renamed from: a */
                public InterfaceC2175b mo15030a(InterfaceC2175b interfaceC2175b) {
                    if ((AnonymousClass5.m17301a(this.f15370b).f15326K || AnonymousClass5.m17301a(this.f15370b).f15328M) && interfaceC2175b.mo14692a().equals("value") && interfaceC2175b.mo14693b().mo14430a() == 26) {
                        C2325e mo14739b = ((C2347n) interfaceC2175b.mo14693b()).mo14739b();
                        String mo14209a = mo14739b.mo14209a();
                        if (mo14209a.equals(AnonymousClass5.m17301a(this.f15370b).f15332c)) {
                            return super.mo15030a((InterfaceC2175b) new C2282b(interfaceC2175b.mo14692a(), (InterfaceC2340g) new C2347n(new C2325e(AnonymousClass5.m17301a(this.f15370b).f15347r, mo14739b.mo14210b(), mo14739b.mo14211c(), mo14739b.mo14212d()))));
                        }
                        if (mo14209a.startsWith(new StringBuffer().append(AnonymousClass5.m17301a(this.f15370b).f15332c.substring(0, AnonymousClass5.m17301a(this.f15370b).f15332c.length() - 1)).append("$").toString())) {
                            return super.mo15030a((InterfaceC2175b) new C2282b(interfaceC2175b.mo14692a(), (InterfaceC2340g) new C2347n(new C2325e(new StringBuffer().append(new StringBuffer().append(AnonymousClass5.m17301a(this.f15370b).f15347r.substring(0, AnonymousClass5.m17301a(this.f15370b).f15347r.length() - 1)).append("$").toString()).append(mo14209a.substring(AnonymousClass5.m17301a(this.f15370b).f15332c.length())).toString(), mo14739b.mo14210b(), mo14739b.mo14211c(), mo14739b.mo14212d()))));
                        }
                        return interfaceC2175b;
                    }
                    return interfaceC2175b;
                }
            };
        }
    }

    /* renamed from: f */
    private boolean m17280f(File file) {
        List<X509Certificate> m8938b;
        if (Build.VERSION.SDK_INT >= 21) {
            C0675d.b bVar = new C0675d.b(file);
            bVar.m6363b(21);
            bVar.m6360a(Integer.MAX_VALUE);
            File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append(".idsig").toString());
            if (file2.isFile()) {
                bVar.m6361a(file2);
            }
            m8938b = bVar.m6362a().m6353a().m6380b();
        } else {
            C1066c.a aVar = new C1066c.a(file);
            aVar.m8920b(21);
            aVar.m8918a(Integer.MAX_VALUE);
            m8938b = aVar.m8919a().m8917a().m8938b();
        }
        Certificate[] certificateArr = (X509Certificate[]) m8938b.toArray(new X509Certificate[m8938b.size()]);
        Certificate[] m18970a = C3105bg.m18970a(file.getAbsolutePath());
        if (certificateArr == null || certificateArr.length == 0) {
            certificateArr = C3105bg.m18969a(this.f15337h, file.getAbsolutePath());
        }
        if (C3102bd.m18925a(this.f15337h, "sign_priority", true) && m18970a != null && m18970a.length > 0) {
            certificateArr = (Certificate[]) Arrays.copyOf(m18970a, m18970a.length);
        }
        Certificate[] certificateArr2 = ((certificateArr == null || certificateArr.length == 0) && m18970a != null && m18970a.length > 0) ? (Certificate[]) Arrays.copyOf(m18970a, m18970a.length) : certificateArr;
        if (certificateArr2 == null || certificateArr2.length <= 0) {
            return false;
        }
        if (this.f15319D) {
            this.f15345p = Base64.encodeToString(certificateArr2[0].getEncoded(), 2);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.write(certificateArr2.length);
            for (Certificate certificate : certificateArr2) {
                byte[] encoded = certificate.getEncoded();
                dataOutputStream.writeInt(encoded.length);
                dataOutputStream.write(encoded);
            }
            this.f15345p = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
        return true;
    }

    /* compiled from: SignKiller.java */
    /* renamed from: ru.maximoff.apktool.e.aq$a */
    private class a implements Runnable {

        /* renamed from: a */
        private String f15371a;

        /* renamed from: b */
        private String f15372b;

        /* renamed from: c */
        private long f15373c;

        /* renamed from: d */
        private final AsyncTaskC2915aq f15374d;

        /* renamed from: b */
        static AsyncTaskC2915aq m17307b(a aVar) {
            return aVar.f15374d;
        }

        public a(AsyncTaskC2915aq asyncTaskC2915aq, String str, String str2, long j) {
            this.f15374d = asyncTaskC2915aq;
            this.f15371a = str;
            this.f15372b = str2;
            this.f15373c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f15374d.f15323H && !this.f15374d.mo3981a()) {
                    C2016c.m14455a(this.f15371a, new C2364e(new AnonymousClass1(this)).m15031a(C2016c.m14454a(this.f15371a, C2359g.m15023a(this.f15374d.f15352w))));
                    C3262u.m19610a(new File(this.f15371a), this.f15373c);
                }
            } catch (Exception e2) {
            }
        }

        /* compiled from: SignKiller.java */
        /* renamed from: ru.maximoff.apktool.e.aq$a$1, reason: invalid class name */
        class AnonymousClass1 extends C2375p {

            /* renamed from: a */
            private final a f15375a;

            AnonymousClass1(a aVar) {
                this.f15375a = aVar;
            }

            /* renamed from: a */
            static a m17308a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15375a;
            }

            @Override // org.p226d.p233b.p262g.C2375p
            /* renamed from: a */
            public InterfaceC2374o<InterfaceC2244d> mo15047a(InterfaceC2377r interfaceC2377r) {
                return new C2362c(this, interfaceC2377r) { // from class: ru.maximoff.apktool.e.aq.a.1.1

                    /* renamed from: b */
                    private final AnonymousClass1 f15376b;

                    {
                        this.f15376b = this;
                    }

                    @Override // org.p226d.p233b.p262g.C2362c
                    /* renamed from: a */
                    public InterfaceC2244d mo15030a(InterfaceC2244d interfaceC2244d) {
                        int mo14194a;
                        String mo14195b;
                        int i;
                        if (interfaceC2244d.mo14205l().equals(AnonymousClass1.m17308a(this.f15376b).f15372b)) {
                            a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15323H = true;
                            if (interfaceC2244d.mo14195b().equals("Landroid/app/Application;") || !a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15319D) {
                                a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15322G = false;
                                if (a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15319D) {
                                    int mo14194a2 = interfaceC2244d.mo14194a();
                                    mo14195b = a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15347r;
                                    i = mo14194a2;
                                } else {
                                    if (a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15342m.equals(a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15343n)) {
                                        mo14194a = EnumC1959a.PUBLIC.m14191a();
                                    } else {
                                        mo14194a = interfaceC2244d.mo14194a();
                                    }
                                    mo14195b = interfaceC2244d.mo14195b();
                                    if (!mo14195b.equals("Landroid/app/Application;")) {
                                        a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15343n = interfaceC2244d.mo14195b();
                                        a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15322G = true;
                                    }
                                    i = mo14194a;
                                }
                                return super.mo15030a((InterfaceC2244d) new C2320c(interfaceC2244d.mo14205l(), i, mo14195b, interfaceC2244d.mo14196c(), interfaceC2244d.mo14197d(), interfaceC2244d.mo14198e(), interfaceC2244d.mo14199f(), interfaceC2244d.mo14200g(), interfaceC2244d.mo14202i(), interfaceC2244d.mo14203j()));
                            }
                            a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15342m = interfaceC2244d.mo14195b();
                            a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15343n = interfaceC2244d.mo14195b();
                            a.m17307b(AnonymousClass1.m17308a(this.f15376b)).f15322G = true;
                        }
                        return super.mo15030a(interfaceC2244d);
                    }
                };
            }

            @Override // org.p226d.p233b.p262g.C2375p
            /* renamed from: c */
            public InterfaceC2374o<InterfaceC2267h> mo15049c(InterfaceC2377r interfaceC2377r) {
                return new InterfaceC2374o<InterfaceC2267h>(this) { // from class: ru.maximoff.apktool.e.aq.a.1.2

                    /* renamed from: a */
                    private final AnonymousClass1 f15377a;

                    {
                        this.f15377a = this;
                    }

                    @Override // org.p226d.p233b.p262g.InterfaceC2374o
                    /* renamed from: a */
                    public /* bridge */ InterfaceC2267h mo15030a(InterfaceC2267h interfaceC2267h) {
                        return a2(interfaceC2267h);
                    }

                    /* renamed from: a, reason: avoid collision after fix types in other method */
                    public InterfaceC2267h a2(InterfaceC2267h interfaceC2267h) {
                        if (!a.m17307b(AnonymousClass1.m17308a(this.f15377a)).f15319D && interfaceC2267h.mo14209a().equals(AnonymousClass1.m17308a(this.f15377a).f15372b)) {
                            a.m17307b(AnonymousClass1.m17308a(this.f15377a)).f15323H = true;
                            if (interfaceC2267h.mo14210b().equals("attachBaseContext")) {
                                a.m17307b(AnonymousClass1.m17308a(this.f15377a)).f15322G = false;
                                return new C2355g(interfaceC2267h.mo14209a(), interfaceC2267h.mo14210b(), interfaceC2267h.mo14213e(), interfaceC2267h.mo14212d(), EnumC1959a.PROTECTED.m14191a(), interfaceC2267h.mo14215g(), interfaceC2267h.mo14216h());
                            }
                            return interfaceC2267h;
                        }
                        return interfaceC2267h;
                    }
                };
            }
        }
    }
}
