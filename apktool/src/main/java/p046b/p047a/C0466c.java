package p046b.p047a;

import com.p065b.p066a.p067a.AbstractC0581c;
import com.p129f.p130a.p131a.C1126u;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p046b.p047a.p048a.C0458c;
import p046b.p047a.p048a.C0459d;
import p046b.p047a.p048a.C0460e;
import p046b.p047a.p049b.C0462a;
import p046b.p047a.p049b.C0463b;
import p046b.p047a.p049b.C0464c;
import p046b.p047a.p049b.C0465d;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p055d.C0517c;
import p046b.p058c.C0529d;
import p046b.p058c.C0530e;
import p046b.p059d.C0542g;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: ApkDecoder.java */
/* renamed from: b.a.c */
/* loaded from: classes.dex */
public class C0466c {

    /* renamed from: d */
    private static C0530e f3301d;

    /* renamed from: a */
    private String f3302a;

    /* renamed from: b */
    private final C0455a f3303b;

    /* renamed from: c */
    private final InterfaceC0541f f3304c;

    /* renamed from: e */
    private File f3305e;

    /* renamed from: f */
    private C0495f f3306f;

    /* renamed from: n */
    private Collection<String> f3314n;

    /* renamed from: g */
    private short f3307g = 1;

    /* renamed from: h */
    private short f3308h = 257;

    /* renamed from: i */
    private short f3309i = 0;

    /* renamed from: j */
    private short f3310j = 1;

    /* renamed from: k */
    private boolean f3311k = false;

    /* renamed from: l */
    private boolean f3312l = false;

    /* renamed from: m */
    private boolean f3313m = true;

    /* renamed from: o */
    private boolean f3315o = false;

    /* renamed from: p */
    private int f3316p = 0;

    /* renamed from: q */
    private int f3317q = 0;

    /* renamed from: r */
    private boolean f3318r = false;

    public C0466c(File file, C0455a c0455a, InterfaceC0541f interfaceC0541f) {
        this.f3303b = c0455a;
        m3556a(file);
        this.f3304c = interfaceC0541f;
    }

    /* renamed from: a */
    public void m3557a(String str) {
        this.f3302a = str;
    }

    /* renamed from: a */
    public void m3556a(File file) {
        if (f3301d != null) {
            try {
                f3301d.m3954b();
            } catch (IOException e2) {
            }
        }
        f3301d = new C0530e(file);
        this.f3306f = (C0495f) null;
    }

    /* renamed from: b */
    public void m3563b(File file) {
        this.f3305e = file;
    }

    /* renamed from: a */
    public void m3555a(int i) {
        this.f3316p = i;
    }

    /* renamed from: b */
    public void m3562b(int i) {
        this.f3317q = i;
    }

    /* renamed from: a */
    public void m3559a(boolean z) {
        this.f3318r = z;
    }

    /* renamed from: a */
    public void m3554a() {
        try {
            try {
                File m3550h = m3550h();
                C0467a.f3319b = this.f3312l;
                if (!this.f3311k && m3550h.exists()) {
                    throw new C0459d();
                }
                if (!f3301d.isFile() || !f3301d.canRead()) {
                    throw new C0458c();
                }
                if (!m3550h.isDirectory()) {
                    C0542g.m3987a(m3550h);
                    m3550h.mkdirs();
                }
                this.f3304c.mo3984d(R.string.using_apktool, C3102bd.f18294ab, f3301d.getName());
                if (m3574g()) {
                    switch (this.f3308h) {
                        case 256:
                            this.f3303b.m3519e(true);
                            this.f3303b.m3504b(f3301d, m3550h);
                            if (this.f3309i == 1) {
                                m3561b();
                                m3560a(this.f3315o, true);
                                if (m3573f()) {
                                    this.f3303b.m3512c(f3301d, m3550h, m3566c());
                                    break;
                                }
                            }
                            break;
                        case 257:
                            this.f3303b.m3519e(false);
                            m3561b();
                            m3560a(this.f3315o, true);
                            if (m3573f()) {
                                this.f3303b.m3512c(f3301d, m3550h, m3566c());
                            }
                            this.f3303b.m3505b(f3301d, m3550h, m3566c());
                            break;
                    }
                } else if (m3573f()) {
                    if (this.f3308h == 257 || this.f3309i == 1) {
                        this.f3303b.m3485a(f3301d, m3550h, m3566c());
                    } else {
                        this.f3303b.m3484a(f3301d, m3550h);
                    }
                }
                if (m3571d()) {
                    switch (this.f3307g) {
                        case 0:
                            this.f3303b.m3487a(f3301d, m3550h, "classes.dex");
                            break;
                        case 1:
                            this.f3303b.m3494a(f3301d, m3550h, "classes.dex", this.f3313m, this.f3317q);
                            break;
                    }
                }
                if (m3572e() || this.f3318r) {
                    for (String str : f3301d.m3953a().mo3908a(this.f3318r)) {
                        if (str.endsWith(".dex") && (this.f3318r || str.indexOf(47) == -1)) {
                            if (!str.equalsIgnoreCase("classes.dex")) {
                                switch (this.f3307g) {
                                    case 0:
                                        this.f3303b.m3487a(f3301d, m3550h, str);
                                        break;
                                    case 1:
                                        this.f3303b.m3494a(f3301d, m3550h, str, this.f3313m, this.f3317q);
                                        break;
                                }
                            }
                        }
                    }
                }
                this.f3303b.m3488a(f3301d, m3550h, this.f3310j);
                this.f3303b.m3486a(f3301d, m3550h, this.f3306f, this.f3318r);
                this.f3314n = new ArrayList();
                this.f3303b.m3489a(f3301d, this.f3314n);
                this.f3303b.m3511c(f3301d, m3550h);
                m3552i();
            } finally {
                try {
                    f3301d.m3954b();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            throw new C0461b(e3);
        }
    }

    /* renamed from: a */
    public void m3558a(short s) {
        this.f3307g = s;
    }

    /* renamed from: b */
    public void m3564b(short s) {
        this.f3308h = s;
    }

    /* renamed from: c */
    public void m3567c(short s) {
        this.f3309i = s;
    }

    /* renamed from: d */
    public void m3569d(short s) {
        this.f3310j = s;
    }

    /* renamed from: a */
    public void m3560a(boolean z, boolean z2) {
        this.f3315o = z;
        if (z2) {
            if (this.f3306f == null) {
                this.f3306f = m3566c();
            }
            this.f3306f.m3708a(z);
        }
    }

    /* renamed from: b */
    public void m3561b() {
        if (this.f3306f == null) {
            this.f3306f = this.f3303b.m3480a(f3301d);
        }
        Map<String, String> m3727i = this.f3306f.m3727i();
        if (m3727i.get("targetSdkVersion") != null) {
            this.f3316p = Integer.parseInt(m3727i.get("targetSdkVersion"));
        }
    }

    /* renamed from: b */
    public void m3565b(boolean z) {
        this.f3313m = z;
    }

    /* renamed from: c */
    public void m3568c(boolean z) {
        this.f3311k = z;
    }

    /* renamed from: d */
    public void m3570d(boolean z) {
        this.f3312l = z;
    }

    /* renamed from: c */
    public C0495f m3566c() {
        if (this.f3306f == null) {
            boolean m3574g = m3574g();
            if (!m3573f() && !m3574g) {
                throw new C0461b("Apk doesn't contain either AndroidManifest.xml file or resources.arsc file");
            }
            this.f3306f = this.f3303b.m3481a(f3301d, m3574g);
        }
        return this.f3306f;
    }

    /* renamed from: d */
    public boolean m3571d() {
        try {
            return f3301d.m3953a().mo3916a("classes.dex");
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: e */
    public boolean m3572e() {
        try {
            for (String str : f3301d.m3953a().mo3908a(false)) {
                if (str.endsWith(".dex") && str.indexOf(47) == -1 && !str.equalsIgnoreCase("classes.dex")) {
                    return true;
                }
            }
            return false;
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: f */
    public boolean m3573f() {
        try {
            return f3301d.m3953a().mo3916a(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: g */
    public boolean m3574g() {
        try {
            return f3301d.m3953a().mo3916a("resources.arsc");
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: h */
    private File m3550h() {
        if (this.f3305e == null) {
            throw new C0461b("Out dir not set");
        }
        return this.f3305e;
    }

    /* renamed from: i */
    private void m3552i() {
        if (!this.f3304c.mo3981a()) {
            C0462a c0462a = new C0462a();
            c0462a.f3280a = C0455a.m3473b();
            String str = this.f3302a;
            if (str == null) {
                str = f3301d.getName();
            }
            c0462a.f3281b = str;
            if (!this.f3303b.m3497a()) {
                c0462a.f3282c = f3301d.getAbsolutePath();
            }
            if (this.f3308h != 256 && (m3573f() || m3574g())) {
                c0462a.f3283d = this.f3303b.m3498a(m3566c());
                m3543a(c0462a);
                m3544b(c0462a);
                m3545c(c0462a);
                m3546d(c0462a);
                m3553i(c0462a);
                m3549g(c0462a);
                m3551h(c0462a);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (this.f3317q > 0) {
                    linkedHashMap.put("minSdkVersion", String.valueOf(this.f3317q));
                }
                if (this.f3316p > 0) {
                    linkedHashMap.put("targetSdkVersion", String.valueOf(this.f3316p));
                }
                if (linkedHashMap.size() > 0) {
                    c0462a.f3285f = linkedHashMap;
                }
            }
            m3547e(c0462a);
            m3548f(c0462a);
            List<String> m3882b = C0517c.m3882b(new File(this.f3305e, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), this.f3304c);
            if (m3882b != null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator<String> it = m3882b.iterator();
                while (it.hasNext()) {
                    linkedHashMap2.put(it.next(), new Boolean(true));
                }
                c0462a.f3293n = linkedHashMap2;
            }
            this.f3303b.m3491a(this.f3305e, c0462a);
        }
    }

    /* renamed from: a */
    private void m3543a(C0462a c0462a) {
        Set<C0492c> m3713c = m3566c().m3713c();
        if (!m3713c.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (C0492c c0492c : m3713c) {
                if (c0492c.m3678g() != 23 || !"bin.mt.plus.TranslationData".equals(c0492c.m3679h())) {
                    arrayList.add(new Integer(c0492c.m3678g()));
                }
            }
            Collections.sort(arrayList);
            c0462a.f3284e = new C0464c();
            c0462a.f3284e.f3297a = arrayList;
            if (this.f3303b.f3272b.f3599t != null) {
                c0462a.f3284e.f3298b = this.f3303b.f3272b.f3599t;
            }
        }
    }

    /* renamed from: b */
    private void m3544b(C0462a c0462a) {
        Map<String, String> m3727i = m3566c().m3727i();
        if (m3727i.size() > 0) {
            c0462a.f3285f = m3727i;
        }
    }

    /* renamed from: c */
    private void m3545c(C0462a c0462a) {
        String m3729k = m3566c().m3729k();
        String m3730l = m3566c().m3730l();
        int m3731m = m3566c().m3731m();
        try {
            m3731m = m3566c().m3703a(m3729k).m3678g();
        } catch (C0460e e2) {
        }
        if (!C1126u.m9591a(m3730l)) {
            c0462a.f3286g = new C0463b();
            if (!m3729k.equalsIgnoreCase(m3730l)) {
                c0462a.f3286g.f3296b = m3729k;
            }
            c0462a.f3286g.f3295a = String.valueOf(m3731m);
        }
    }

    /* renamed from: d */
    private void m3546d(C0462a c0462a) {
        C0465d m3726h = m3566c().m3726h();
        String m3877a = C0517c.m3877a(this.f3305e, m3726h.f3300b, this.f3304c);
        if (m3877a != null) {
            m3726h.f3300b = m3877a;
        }
        c0462a.f3287h = m3726h;
    }

    /* renamed from: e */
    private void m3547e(C0462a c0462a) {
        c0462a.f3292m = this.f3303b.f3271a.m3747a();
    }

    /* renamed from: f */
    private void m3548f(C0462a c0462a) {
        if (this.f3314n == null || this.f3314n.isEmpty()) {
            return;
        }
        c0462a.f3294o = this.f3314n;
    }

    /* renamed from: g */
    private void m3549g(C0462a c0462a) {
        c0462a.f3290k = this.f3306f.m3733o();
    }

    /* renamed from: h */
    private void m3551h(C0462a c0462a) {
        c0462a.f3291l = this.f3306f.m3734p();
    }

    /* renamed from: i */
    private void m3553i(C0462a c0462a) {
        c0462a.f3289j = this.f3306f.m3732n();
    }
}
