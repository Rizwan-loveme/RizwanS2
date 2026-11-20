package ru.maximoff.apktool.util.p310h;

import java.io.File;

/* compiled from: MZipEntry.java */
/* renamed from: ru.maximoff.apktool.util.h.a */
/* loaded from: classes.dex */
public class C3247a {

    /* renamed from: a */
    private String f19519a;

    /* renamed from: b */
    private String f19520b;

    /* renamed from: g */
    private long f19525g;

    /* renamed from: h */
    private int f19526h;

    /* renamed from: i */
    private String f19527i;

    /* renamed from: c */
    private long f19521c = 0;

    /* renamed from: d */
    private long f19522d = 0;

    /* renamed from: f */
    private long f19524f = 0;

    /* renamed from: j */
    private File f19528j = (File) null;

    /* renamed from: e */
    private boolean f19523e = false;

    /* renamed from: k */
    private boolean f19529k = false;

    /* renamed from: l */
    private boolean f19530l = false;

    public C3247a(String str) {
        this.f19519a = str;
        this.f19520b = str;
        this.f19527i = str;
    }

    /* renamed from: a */
    public void m19475a(long j, long j2) {
        this.f19521c = j;
        this.f19522d = j2;
    }

    /* renamed from: b */
    public void m19481b(long j, long j2) {
        this.f19521c += j;
        this.f19522d += j2;
    }

    /* renamed from: a */
    public void m19473a(int i) {
        this.f19526h = i;
    }

    /* renamed from: a */
    public void m19474a(long j) {
        this.f19524f = j;
    }

    /* renamed from: b */
    public void m19480b(long j) {
        this.f19525g = j;
    }

    /* renamed from: a */
    public void m19478a(boolean z) {
        this.f19523e = z;
    }

    /* renamed from: a */
    public void m19477a(String str) {
        this.f19527i = str;
    }

    /* renamed from: b */
    public void m19482b(String str) {
        this.f19519a = str;
    }

    /* renamed from: a */
    public void m19476a(File file) {
        if (file == null || file.isFile()) {
            this.f19528j = file;
        }
    }

    /* renamed from: a */
    public long m19472a() {
        return this.f19521c;
    }

    /* renamed from: b */
    public long m19479b() {
        return this.f19522d;
    }

    /* renamed from: c */
    public long m19484c() {
        return this.f19524f;
    }

    /* renamed from: d */
    public long m19486d() {
        return this.f19525g;
    }

    /* renamed from: e */
    public int m19487e() {
        return this.f19526h;
    }

    /* renamed from: f */
    public File m19488f() {
        return this.f19528j;
    }

    /* renamed from: g */
    public boolean m19489g() {
        return this.f19523e;
    }

    /* renamed from: h */
    public boolean m19490h() {
        return this.f19530l;
    }

    /* renamed from: i */
    public String m19491i() {
        return this.f19519a;
    }

    /* renamed from: j */
    public String m19492j() {
        return this.f19520b;
    }

    /* renamed from: b */
    public void m19483b(boolean z) {
        this.f19529k = z;
    }

    /* renamed from: c */
    public void m19485c(boolean z) {
        this.f19530l = z;
    }

    /* renamed from: k */
    public boolean m19493k() {
        return this.f19529k;
    }

    /* renamed from: l */
    public String m19494l() {
        String str = this.f19519a;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf != -1) {
            if (!this.f19523e) {
                return str.substring(lastIndexOf + 1);
            }
            if (str.endsWith("/")) {
                str = str.substring(0, lastIndexOf);
            }
            return str.split("/")[r0.length - 1];
        }
        return str;
    }

    /* renamed from: m */
    public String m19495m() {
        String str = this.f19527i;
        if (str.endsWith("/")) {
            str = str.substring(0, str.lastIndexOf(47));
        }
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf + 1);
    }

    public int hashCode() {
        return this.f19519a.hashCode();
    }
}
