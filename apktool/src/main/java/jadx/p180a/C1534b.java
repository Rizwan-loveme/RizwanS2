package jadx.p180a;

import java.p209io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JadxArgs.java */
/* renamed from: jadx.a.b */
/* loaded from: classes.dex */
public class C1534b {

    /* renamed from: a */
    public static final int f9837a = Math.max(1, Runtime.getRuntime().availableProcessors() / 2);

    /* renamed from: c */
    private File f9839c;

    /* renamed from: d */
    private File f9840d;

    /* renamed from: e */
    private File f9841e;

    /* renamed from: b */
    private List<File> f9838b = new ArrayList(1);

    /* renamed from: f */
    private int f9842f = f9837a;

    /* renamed from: g */
    private boolean f9843g = false;

    /* renamed from: h */
    private boolean f9844h = false;

    /* renamed from: i */
    private boolean f9845i = false;

    /* renamed from: j */
    private boolean f9846j = false;

    /* renamed from: k */
    private boolean f9847k = true;

    /* renamed from: l */
    private boolean f9848l = false;

    /* renamed from: m */
    private boolean f9849m = false;

    /* renamed from: n */
    private boolean f9850n = false;

    /* renamed from: o */
    private boolean f9851o = false;

    /* renamed from: p */
    private boolean f9852p = false;

    /* renamed from: q */
    private int f9853q = 0;

    /* renamed from: r */
    private int f9854r = Integer.MAX_VALUE;

    /* renamed from: s */
    private boolean f9855s = false;

    /* renamed from: t */
    private boolean f9856t = true;

    /* renamed from: u */
    private boolean f9857u = false;

    /* renamed from: a */
    public List<File> m11756a() {
        return this.f9838b;
    }

    /* renamed from: a */
    public void m11759a(List<File> list) {
        this.f9838b = list;
    }

    /* renamed from: b */
    public File m11761b() {
        return this.f9839c;
    }

    /* renamed from: a */
    public void m11758a(File file) {
        this.f9839c = file;
    }

    /* renamed from: c */
    public File m11764c() {
        return this.f9840d;
    }

    /* renamed from: b */
    public void m11762b(File file) {
        this.f9840d = file;
    }

    /* renamed from: d */
    public File m11767d() {
        return this.f9841e;
    }

    /* renamed from: c */
    public void m11765c(File file) {
        this.f9841e = file;
    }

    /* renamed from: a */
    public void m11757a(int i) {
        this.f9842f = i;
    }

    /* renamed from: e */
    public boolean m11770e() {
        return this.f9843g;
    }

    /* renamed from: f */
    public boolean m11771f() {
        return this.f9844h;
    }

    /* renamed from: g */
    public boolean m11772g() {
        return this.f9845i;
    }

    /* renamed from: a */
    public void m11760a(boolean z) {
        this.f9845i = z;
    }

    /* renamed from: h */
    public boolean m11773h() {
        return this.f9846j;
    }

    /* renamed from: b */
    public void m11763b(boolean z) {
        this.f9846j = z;
    }

    /* renamed from: i */
    public boolean m11774i() {
        return this.f9847k;
    }

    /* renamed from: c */
    public void m11766c(boolean z) {
        this.f9848l = z;
    }

    /* renamed from: j */
    public boolean m11775j() {
        return this.f9849m;
    }

    /* renamed from: k */
    public boolean m11776k() {
        return this.f9850n;
    }

    /* renamed from: d */
    public void m11768d(boolean z) {
        this.f9850n = z;
    }

    /* renamed from: l */
    public boolean m11777l() {
        return this.f9851o;
    }

    /* renamed from: m */
    public boolean m11778m() {
        return this.f9852p;
    }

    /* renamed from: n */
    public int m11779n() {
        return this.f9853q;
    }

    /* renamed from: o */
    public int m11780o() {
        return this.f9854r;
    }

    /* renamed from: p */
    public boolean m11781p() {
        return this.f9855s;
    }

    /* renamed from: e */
    public void m11769e(boolean z) {
        this.f9855s = z;
    }

    /* renamed from: q */
    public boolean m11782q() {
        return this.f9856t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JadxArgs{");
        sb.append("inputFiles=").append(this.f9838b);
        sb.append(", outDir=").append(this.f9839c);
        sb.append(", outDirSrc=").append(this.f9840d);
        sb.append(", outDirRes=").append(this.f9841e);
        sb.append(", threadsCount=").append(this.f9842f);
        sb.append(", cfgOutput=").append(this.f9843g);
        sb.append(", rawCFGOutput=").append(this.f9844h);
        sb.append(", fallbackMode=").append(this.f9845i);
        sb.append(", showInconsistentCode=").append(this.f9846j);
        sb.append(", useImports=").append(this.f9847k);
        sb.append(", isSkipResources=").append(this.f9848l);
        sb.append(", isSkipSources=").append(this.f9849m);
        sb.append(", isDeobfuscationOn=").append(this.f9850n);
        sb.append(", isDeobfuscationForceSave=").append(this.f9851o);
        sb.append(", useSourceNameAsClassAlias=").append(this.f9852p);
        sb.append(", deobfuscationMinLength=").append(this.f9853q);
        sb.append(", deobfuscationMaxLength=").append(this.f9854r);
        sb.append(", escapeUnicode=").append(this.f9855s);
        sb.append(", replaceConsts=").append(this.f9856t);
        sb.append(", exportAsGradleProject=").append(this.f9857u);
        sb.append('}');
        return sb.toString();
    }
}
