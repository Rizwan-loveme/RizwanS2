package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Apkinfo.java */
/* renamed from: ru.maximoff.apktool.util.a */
/* loaded from: classes.dex */
public class C3060a {

    /* renamed from: A */
    private String f17186A;

    /* renamed from: B */
    private Resources f17187B;

    /* renamed from: C */
    private List<String> f17188C;

    /* renamed from: D */
    private List<String> f17189D;

    /* renamed from: E */
    private List<String> f17190E;

    /* renamed from: F */
    private List<String> f17191F;

    /* renamed from: G */
    private a f17192G;

    /* renamed from: a */
    private Context f17193a;

    /* renamed from: b */
    private File f17194b;

    /* renamed from: c */
    private Drawable f17195c;

    /* renamed from: d */
    private Bitmap f17196d;

    /* renamed from: e */
    private String f17197e;

    /* renamed from: f */
    private int f17198f;

    /* renamed from: g */
    private int f17199g;

    /* renamed from: h */
    private CharSequence f17200h;

    /* renamed from: i */
    private CharSequence f17201i;

    /* renamed from: j */
    private String f17202j;

    /* renamed from: k */
    private String f17203k;

    /* renamed from: l */
    private int f17204l;

    /* renamed from: m */
    private int f17205m;

    /* renamed from: n */
    private int f17206n;

    /* renamed from: o */
    private int f17207o;

    /* renamed from: p */
    private PackageManager f17208p;

    /* renamed from: q */
    private PackageInfo f17209q;

    /* renamed from: r */
    private C3081am f17210r;

    /* renamed from: s */
    private boolean f17211s;

    /* renamed from: t */
    private boolean f17212t;

    /* renamed from: u */
    private boolean f17213u;

    /* renamed from: v */
    private boolean f17214v;

    /* renamed from: w */
    private String f17215w;

    /* renamed from: x */
    private String f17216x;

    /* renamed from: y */
    private String f17217y;

    /* renamed from: z */
    private String f17218z;

    /* compiled from: Apkinfo.java */
    /* renamed from: ru.maximoff.apktool.util.a$a */
    public interface a {
        /* renamed from: a */
        void mo17840a();
    }

    public C3060a(Context context, File file) {
        this.f17193a = context;
        this.f17194b = file;
        this.f17208p = context.getPackageManager();
        this.f17209q = this.f17208p.getPackageArchiveInfo(this.f17194b.getAbsolutePath(), 0);
        m18246I();
    }

    public C3060a(Context context, String str) {
        this.f17193a = context;
        this.f17194b = new File(str);
        this.f17208p = context.getPackageManager();
        this.f17209q = this.f17208p.getPackageArchiveInfo(this.f17194b.getAbsolutePath(), 0);
        m18246I();
    }

    public C3060a(Context context, PackageManager packageManager, PackageInfo packageInfo, File file) {
        this.f17193a = context;
        this.f17194b = file;
        this.f17208p = packageManager;
        this.f17209q = packageInfo;
        m18246I();
    }

    /* renamed from: I */
    private void m18246I() {
        this.f17211s = false;
        this.f17215w = "";
        this.f17190E = new ArrayList();
        this.f17191F = new ArrayList();
        try {
            this.f17210r = new C3081am(this.f17194b);
            this.f17206n = this.f17210r.m18632h();
            this.f17207o = this.f17210r.m18633i();
            this.f17212t = this.f17210r.m18628d();
            this.f17213u = this.f17210r.m18629e();
            this.f17217y = this.f17210r.m18642r();
            this.f17218z = this.f17210r.m18643s();
            this.f17214v = this.f17210r.m18630f();
            this.f17204l = this.f17210r.m18637m();
            this.f17189D = this.f17210r.m18627c();
            if (this.f17209q != null) {
                this.f17209q.applicationInfo.sourceDir = this.f17194b.getAbsolutePath();
                this.f17209q.applicationInfo.publicSourceDir = this.f17194b.getAbsolutePath();
                this.f17195c = this.f17209q.applicationInfo.loadIcon(this.f17208p);
                this.f17200h = this.f17209q.applicationInfo.loadLabel(this.f17208p);
                this.f17198f = this.f17209q.applicationInfo.icon;
                this.f17199g = this.f17210r.m18645u();
                this.f17202j = this.f17209q.packageName;
                this.f17203k = this.f17209q.versionName;
                this.f17205m = this.f17209q.versionCode;
                this.f17186A = this.f17209q.sharedUserId;
                if (this.f17186A == null) {
                    this.f17186A = this.f17210r.m18639o();
                }
                this.f17187B = this.f17208p.getResourcesForApplication(this.f17209q.applicationInfo);
                this.f17210r.m18625a(this.f17187B);
                m18250b(this.f17187B);
                if (this.f17198f != 0 && this.f17198f != -1) {
                    this.f17196d = C3067ab.m18366a(this.f17187B, this.f17193a.getResources().getDisplayMetrics().densityDpi, this.f17198f);
                } else {
                    this.f17196d = (Bitmap) null;
                }
                Configuration configuration = new Configuration();
                if (Build.VERSION.SDK_INT >= 17) {
                    configuration.setLocale(Locale.ROOT);
                } else {
                    configuration.locale = Locale.ROOT;
                }
                this.f17187B.updateConfiguration(configuration, this.f17187B.getDisplayMetrics());
                try {
                    if (this.f17209q.applicationInfo.labelRes != 0 && this.f17209q.applicationInfo.labelRes != -1) {
                        this.f17201i = this.f17187B.getString(this.f17209q.applicationInfo.labelRes);
                    } else {
                        this.f17201i = this.f17209q.applicationInfo.nonLocalizedLabel;
                        if (this.f17201i == null) {
                            this.f17201i = this.f17200h;
                        }
                    }
                } catch (Exception e2) {
                    this.f17201i = this.f17200h;
                }
                this.f17211s = true;
                return;
            }
            this.f17200h = this.f17210r.m18641q();
            this.f17201i = this.f17210r.m18641q();
            this.f17202j = this.f17210r.m18634j();
            this.f17203k = this.f17210r.m18638n();
            this.f17205m = this.f17210r.m18640p();
            this.f17198f = this.f17210r.m18644t();
            this.f17199g = this.f17210r.m18645u();
            this.f17186A = this.f17210r.m18639o();
        } catch (Exception e3) {
            this.f17215w = Log.getStackTraceString(e3);
        }
    }

    /* renamed from: b */
    private void m18250b(Resources resources) {
        try {
            if (this.f17198f != 0 && this.f17198f != -1) {
                this.f17197e = resources.getResourceName(this.f17198f);
            }
            if (this.f17199g != 0 && this.f17199g != -1) {
                this.f17216x = resources.getResourceName(this.f17199g);
            }
        } catch (Exception e2) {
            this.f17215w = Log.getStackTraceString(e2);
        }
    }

    /* renamed from: a */
    public void m18261a(Resources resources) {
        if (resources != null) {
            int[] iArr = {120, 160, 240, 320, DisplayMetrics.DENSITY_XXHIGH, DisplayMetrics.DENSITY_XXXHIGH};
            try {
                if (this.f17198f != 0 && this.f17198f != -1) {
                    for (int i : iArr) {
                        TypedValue typedValue = new TypedValue();
                        resources.getValueForDensity(this.f17198f, i, typedValue, false);
                        CharSequence charSequence = typedValue.string;
                        if (charSequence != null && !this.f17190E.contains(charSequence)) {
                            this.f17190E.add(charSequence.toString());
                        }
                    }
                }
                if (this.f17199g != 0 && this.f17199g != -1) {
                    for (int i2 : iArr) {
                        TypedValue typedValue2 = new TypedValue();
                        resources.getValueForDensity(this.f17199g, i2, typedValue2, false);
                        CharSequence charSequence2 = typedValue2.string;
                        if (charSequence2 != null && !this.f17191F.contains(charSequence2.toString())) {
                            this.f17191F.add(charSequence2.toString());
                        }
                    }
                }
            } catch (Exception e2) {
                this.f17215w = Log.getStackTraceString(e2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        r7 = java.util.regex.Pattern.compile("^\\s+\\(.*?\\) \\(file\\) ([^\\s]+)").matcher(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c4, code lost:
    
        if (r7.find() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e1, code lost:
    
        r7 = java.util.regex.Pattern.compile("^\\s+\\(.*?\\) \"([^\\s]+)\"").matcher(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ef, code lost:
    
        if (r7.find() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0113, code lost:
    
        if (java.util.regex.Pattern.compile("^\\s+\\(.*?\\) @[^\\s]+").matcher(r6).find() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f1, code lost:
    
        r6 = r7.group(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
    
        if (r13.f17190E.contains(r6) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fe, code lost:
    
        r13.f17190E.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c6, code lost:
    
        r6 = r7.group(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d1, code lost:
    
        if (r13.f17190E.contains(r6) != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d3, code lost:
    
        r13.f17190E.add(r6);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m18260a() {
        try {
            Process start = new ProcessBuilder(C3102bd.f18278N, "dump", "resources", this.f17194b.getAbsolutePath()).start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            boolean z = false;
            boolean z2 = false;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (this.f17198f != 0 && this.f17198f != -1 && readLine.contains(String.format("0x%08x", new Integer(this.f17198f)))) {
                    z = false;
                    z2 = true;
                } else if (this.f17199g != 0 && this.f17199g != -1 && readLine.contains(String.format("0x%08x", new Integer(this.f17199g)))) {
                    z = true;
                    z2 = false;
                } else if (z) {
                    Matcher matcher = Pattern.compile("^\\s+\\(.*?\\) \\(file\\) ([^\\s]+)").matcher(readLine);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (!this.f17191F.contains(group)) {
                            this.f17191F.add(group);
                        }
                    } else {
                        Matcher matcher2 = Pattern.compile("^\\s+\\(.*?\\) \"([^\\s]+)\"").matcher(readLine);
                        if (matcher2.find()) {
                            String group2 = matcher2.group(1);
                            if (!this.f17191F.contains(group2)) {
                                this.f17191F.add(group2);
                            }
                        } else if (!Pattern.compile("^\\s+\\(.*?\\) @[^\\s]+").matcher(readLine).find()) {
                            z = false;
                        }
                    }
                }
            }
            bufferedReader.close();
            if (start.waitFor() != 0 || ((this.f17198f != 0 && this.f17198f != -1 && this.f17190E.isEmpty()) || (this.f17199g != 0 && this.f17199g != -1 && this.f17191F.isEmpty()))) {
                m18261a(this.f17187B);
            }
        } catch (Exception e2) {
            m18261a(this.f17187B);
        }
    }

    /* renamed from: b */
    public File m18264b() {
        return this.f17194b;
    }

    /* renamed from: c */
    public List<String> m18265c() {
        return this.f17189D;
    }

    /* renamed from: d */
    public Bitmap m18266d() {
        return this.f17196d != null ? this.f17196d : C3067ab.m18372a(this.f17195c);
    }

    /* renamed from: e */
    public String m18267e() {
        return this.f17197e;
    }

    /* renamed from: f */
    public String m18268f() {
        return this.f17216x;
    }

    /* renamed from: g */
    public int m18269g() {
        return this.f17198f;
    }

    /* renamed from: h */
    public int m18270h() {
        return this.f17199g;
    }

    /* renamed from: i */
    public String m18271i() {
        return this.f17200h.toString();
    }

    /* renamed from: j */
    public String m18272j() {
        return this.f17217y;
    }

    /* renamed from: k */
    public String m18273k() {
        return this.f17218z;
    }

    /* renamed from: l */
    public String m18274l() {
        return this.f17186A;
    }

    /* renamed from: m */
    public String m18275m() {
        return this.f17201i.toString();
    }

    /* renamed from: n */
    public String m18276n() {
        return this.f17202j;
    }

    /* renamed from: o */
    public String m18277o() {
        return C3112bn.m19017b((CharSequence) this.f17203k);
    }

    /* renamed from: p */
    public int m18278p() {
        return this.f17205m;
    }

    /* renamed from: q */
    public String m18279q() {
        return String.valueOf(this.f17205m);
    }

    /* renamed from: r */
    public int m18280r() {
        return this.f17204l;
    }

    /* renamed from: s */
    public int m18281s() {
        return this.f17206n;
    }

    /* renamed from: t */
    public String m18282t() {
        return String.valueOf(this.f17206n);
    }

    /* renamed from: u */
    public int m18283u() {
        return this.f17207o;
    }

    /* renamed from: v */
    public String m18284v() {
        return String.valueOf(this.f17207o);
    }

    /* renamed from: w */
    public String m18285w() {
        String m18576b = C3080al.m18576b(this.f17206n);
        if (m18576b == null) {
            return "";
        }
        return m18576b;
    }

    /* renamed from: x */
    public String m18286x() {
        String m18576b = C3080al.m18576b(this.f17207o);
        if (m18576b == null) {
            return "";
        }
        return m18576b;
    }

    /* renamed from: y */
    public PackageManager m18287y() {
        return this.f17208p;
    }

    /* renamed from: z */
    public PackageInfo m18288z() {
        return this.f17209q;
    }

    /* renamed from: A */
    public boolean m18252A() {
        return this.f17212t;
    }

    /* renamed from: B */
    public boolean m18253B() {
        return this.f17213u;
    }

    /* renamed from: C */
    public boolean m18254C() {
        return this.f17214v;
    }

    /* renamed from: D */
    public boolean m18255D() {
        return this.f17211s;
    }

    /* renamed from: E */
    public List<String> m18256E() {
        return this.f17190E;
    }

    /* renamed from: F */
    public List<String> m18257F() {
        return this.f17191F;
    }

    /* renamed from: a */
    public void m18262a(List<String> list) {
        this.f17188C = list;
    }

    /* renamed from: G */
    public Resources m18258G() {
        return this.f17187B;
    }

    /* renamed from: a */
    public void m18263a(a aVar) {
        this.f17192G = aVar;
        if (C3102bd.m18910a(this.f17193a, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})").indexOf("{ARCH") >= 0) {
            new b(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else if (this.f17192G != null) {
            this.f17192G.mo17840a();
        }
    }

    /* renamed from: H */
    public List<String> m18259H() {
        if (this.f17188C == null) {
            if (this.f17210r == null) {
                this.f17188C = new ArrayList();
            } else {
                this.f17188C = this.f17210r.m18646v();
            }
        }
        return this.f17188C;
    }

    public int hashCode() {
        return this.f17194b.hashCode();
    }

    /* compiled from: Apkinfo.java */
    /* renamed from: ru.maximoff.apktool.util.a$b */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final C3060a f17222a;

        @Override // android.p008os.AsyncTask
        protected Void doInBackground(Void[] voidArr) {
            return m18344a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Void r1) {
            m18345a(r1);
        }

        /* renamed from: a */
        protected Void m18344a(Void... voidArr) {
            if (this.f17222a.f17188C == null) {
                if (this.f17222a.f17210r == null) {
                    this.f17222a.f17188C = new ArrayList();
                } else {
                    this.f17222a.f17188C = this.f17222a.f17210r.m18646v();
                }
            }
            return (Void) null;
        }

        /* renamed from: a */
        protected void m18345a(Void r2) {
            if (this.f17222a.f17192G != null) {
                this.f17222a.f17192G.mo17840a();
            }
        }

        public b(C3060a c3060a) {
            this.f17222a = c3060a;
        }
    }
}
