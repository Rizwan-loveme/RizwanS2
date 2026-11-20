package p046b.p047a.p050c;

import android.bluetooth.BluetoothHidDevice;
import android.icu.text.DateFormat;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import javax.xml.XMLConstants;
import org.p217b.p218a.p219a.C1887e;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.C0461b;
import p046b.p047a.C0518d;
import p046b.p047a.p048a.C0457b;
import p046b.p047a.p049b.C0462a;
import p046b.p047a.p049b.C0463b;
import p046b.p047a.p049b.C0465d;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p051a.C0499j;
import p046b.p047a.p050c.p053b.C0501a;
import p046b.p047a.p050c.p053b.C0503c;
import p046b.p047a.p050c.p053b.C0504d;
import p046b.p047a.p050c.p053b.C0505e;
import p046b.p047a.p050c.p053b.C0506f;
import p046b.p047a.p050c.p053b.C0507g;
import p046b.p047a.p050c.p053b.C0509i;
import p046b.p047a.p050c.p053b.C0512l;
import p046b.p047a.p050c.p053b.XmlResourceParserC0502b;
import p046b.p047a.p050c.p054c.C0513a;
import p046b.p047a.p050c.p054c.InterfaceC0514b;
import p046b.p047a.p050c.p055d.C0517c;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p057b.C0522a;
import p046b.p058c.C0529d;
import p046b.p058c.C0530e;
import p046b.p058c.C0531f;
import p046b.p058c.C0535j;
import p046b.p058c.InterfaceC0528c;
import p046b.p059d.C0538c;
import p046b.p059d.C0542g;
import p046b.p059d.C0543h;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p303a.C3062b;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: AndrolibResources.java */
/* renamed from: b.a.c.a */
/* loaded from: classes.dex */
public final class C0467a {

    /* renamed from: b */
    public static boolean f3319b = false;

    /* renamed from: t */
    private static final String[] f3320t = {"android", "com.htc", "miui", "com.lge", "com.lge.internal", "yi", "com.miui.core", "flyme", "air.com.adobe.appentry", "FFFFFFFFFFFFFFFFFFFFFF"};

    /* renamed from: u */
    private static final String[] f3321u = {"com.miui"};

    /* renamed from: a */
    public C0518d f3322a;

    /* renamed from: c */
    private final InterfaceC0541f f3323c;

    /* renamed from: d */
    private File f3324d = (File) null;

    /* renamed from: e */
    private C0530e f3325e = (C0530e) null;

    /* renamed from: f */
    private String f3326f = (String) null;

    /* renamed from: g */
    private String f3327g = (String) null;

    /* renamed from: h */
    private String f3328h = (String) null;

    /* renamed from: i */
    private String f3329i = (String) null;

    /* renamed from: j */
    private String f3330j = (String) null;

    /* renamed from: k */
    private String f3331k = (String) null;

    /* renamed from: l */
    private String f3332l = (String) null;

    /* renamed from: m */
    private boolean f3333m = false;

    /* renamed from: n */
    private boolean f3334n = false;

    /* renamed from: o */
    private boolean f3335o = true;

    /* renamed from: p */
    private boolean f3336p = false;

    /* renamed from: q */
    private boolean f3337q = false;

    /* renamed from: r */
    private int f3338r = 0;

    /* renamed from: s */
    private int f3339s = 127;

    /* renamed from: v */
    private final List<String> f3340v = new ArrayList();

    /* renamed from: w */
    private final Map<String, String> f3341w = new LinkedHashMap();

    /* renamed from: x */
    private InterfaceC0528c f3342x;

    /* renamed from: a */
    public C0495f m3583a(C0530e c0530e, boolean z) {
        C0495f c0495f = new C0495f(this);
        if (z) {
            m3588a(c0495f, c0530e);
        }
        return c0495f;
    }

    /* renamed from: a */
    public void m3588a(C0495f c0495f, C0530e c0530e) {
        this.f3323c.mo3984d(R.string.text, "Loading resource table...");
        C0492c[] m3602a = m3602a(c0530e, c0495f, f3319b, false);
        C0492c m3582a = m3582a(m3602a);
        if (m3582a == null) {
            this.f3323c.mo3983c(R.string.text, "arsc files with zero packages or no arsc file found.");
            m3582a = new C0492c(c0495f, 0, (String) null, this.f3335o, this.f3323c);
        }
        c0495f.m3706a(m3582a, true);
        this.f3339s = m3582a.m3678g();
        c0495f.m3722e(this.f3339s);
        if (m3602a == null || this.f3338r <= 0) {
            return;
        }
        for (C0492c c0492c : m3602a) {
            if (!c0495f.m3710b().contains(c0492c)) {
                c0495f.m3706a(c0492c, true);
            }
        }
    }

    /* renamed from: a */
    public C0492c m3582a(C0492c[] c0492cArr) {
        if (c0492cArr == null || c0492cArr.length == 0) {
            return (C0492c) null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < c0492cArr.length; i4++) {
            C0492c c0492c = c0492cArr[i4];
            if (c0492c.m3673c() > i2 && !c0492c.m3679h().equalsIgnoreCase("android")) {
                i2 = c0492c.m3673c();
                i3 = c0492c.m3678g();
                i = i4;
            }
        }
        return i3 == 0 ? c0492cArr[0] : c0492cArr[i];
    }

    /* renamed from: a */
    public C0492c m3581a(C0495f c0495f, int i, String str) {
        C0492c c0492c;
        File m3584a = m3584a(i, str);
        this.f3323c.mo3984d(R.string.text, new StringBuffer().append("Loading resource table from file: ").append(m3584a).toString());
        this.f3325e = new C0530e(m3584a);
        C0492c[] m3602a = m3602a(this.f3325e, c0495f, true, true);
        if (m3602a.length > 1) {
            c0492c = m3582a(m3602a);
        } else {
            if (m3602a.length == 0) {
                throw new C0461b("Arsc files with zero or multiple packages");
            }
            c0492c = m3602a[0];
        }
        if (c0492c.m3678g() != i) {
            throw new C0461b(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Expected pkg of id: ").append(String.valueOf(i)).toString()).append(", got: ").toString()).append(c0492c.m3678g()).toString());
        }
        c0495f.m3706a(c0492c, false);
        return c0492c;
    }

    /* renamed from: a */
    public void m3589a(C0495f c0495f, C0530e c0530e, File file) {
        if (!this.f3323c.mo3981a()) {
            C0538c<C0506f, XmlResourceParserC0502b> m3617g = m3617g();
            C0506f c0506f = m3617g.f3632a;
            m3617g.f3633b.m3799a(new C0505e());
            m3617g.f3633b.m3801b().m3828a(c0495f);
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                C0531f c0531f = new C0531f(file);
                this.f3323c.mo3984d(R.string.text, "Decoding AndroidManifest.xml with only framework resources...");
                c0506f.m3834a(m3953a, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, c0531f, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: a */
    public void m3591a(C0495f c0495f, String str) {
        C0492c m3724f = c0495f.m3724f();
        String m3679h = m3724f.m3679h();
        this.f3331k = c0495f.m3729k();
        c0495f.m3717d(m3724f.m3678g());
        c0495f.m3714c(m3679h);
        if (m3679h == null || m3679h.equalsIgnoreCase(this.f3331k) || (Arrays.asList(f3320t).contains(m3679h) && !Arrays.asList(f3321u).contains(this.f3331k))) {
            this.f3323c.mo3984d(R.string.text, "Regular manifest package...");
        } else {
            this.f3323c.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Renamed manifest package found! Replacing ").append(this.f3331k).toString()).append(" with ").toString()).append(m3679h).toString());
            C0517c.m3884b(new File(str), m3679h);
        }
    }

    /* renamed from: a */
    public void m3590a(C0495f c0495f, C0530e c0530e, File file, boolean z) {
        if (!this.f3323c.mo3981a()) {
            C0538c<C0506f, XmlResourceParserC0502b> m3615f = m3615f(true);
            C0506f c0506f = m3615f.f3632a;
            m3615f.f3633b.m3801b().m3828a(c0495f);
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                C0531f c0531f = new C0531f(file);
                this.f3323c.mo3984d(R.string.text, "Decoding AndroidManifest.xml with resources...");
                c0506f.m3834a(m3953a, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, c0531f, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                if (!c0495f.m3728j()) {
                    m3591a(c0495f, new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).toString());
                    C0517c.m3886c(new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).toString()));
                    this.f3332l = String.valueOf(c0495f.m3731m());
                }
                if (z) {
                    try {
                        C0517c.m3887d(new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).toString()));
                    } catch (Exception e2) {
                    }
                }
            } catch (C0529d e3) {
                throw new C0461b(e3);
            }
        }
    }

    /* renamed from: b */
    public void m3606b(C0495f c0495f, C0530e c0530e, File file) {
        InterfaceC0528c interfaceC0528c;
        C0538c<C0506f, XmlResourceParserC0502b> m3615f = m3615f(false);
        C0506f c0506f = m3615f.f3632a;
        C0505e m3801b = m3615f.f3633b.m3801b();
        m3801b.m3828a(c0495f);
        try {
            C0531f c0531f = new C0531f(file);
            InterfaceC0528c m3953a = c0530e.m3953a();
            InterfaceC0528c mo3927f = c0531f.mo3927f("res");
            C0513a m3618h = m3618h();
            m3801b.m3828a(c0495f);
            for (C0492c c0492c : c0495f.m3710b()) {
                if (this.f3338r != 2 || c0492c.m3678g() == this.f3339s) {
                    interfaceC0528c = mo3927f;
                } else {
                    try {
                        interfaceC0528c = new C0531f(file).mo3927f(new StringBuffer().append("res_").append(c0492c.m3679h()).toString());
                    } catch (C0529d e2) {
                    }
                }
                this.f3323c.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Decoding file-resources (pkgId: ").append(c0492c.m3678g()).toString()).append(")...").toString());
                Iterator<C0494e> it = c0492c.m3675d().iterator();
                while (it.hasNext()) {
                    c0506f.m3832a(it.next(), m3953a, interfaceC0528c, this);
                }
                this.f3323c.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Decoding values */* XMLs (pkgId: ").append(c0492c.m3678g()).toString()).append(")...").toString());
                Iterator<C0499j> it2 = c0492c.m3676e().iterator();
                while (it2.hasNext()) {
                    m3576a(it2.next(), interfaceC0528c, m3618h);
                }
                m3575a(c0492c, interfaceC0528c, m3618h);
            }
            C0461b m3798a = m3615f.f3633b.m3798a();
            if (m3798a != null) {
                throw m3798a;
            }
        } catch (C0529d e3) {
            throw new C0461b(e3);
        }
    }

    /* renamed from: a */
    public void m3598a(Map<String, String> map) {
        if (map != null) {
            this.f3326f = map.get("minSdkVersion");
            this.f3328h = map.get("targetSdkVersion");
            this.f3327g = map.get("maxSdkVersion");
        }
    }

    /* renamed from: a */
    public void m3587a(C0465d c0465d) {
        if (c0465d != null) {
            this.f3329i = c0465d.f3299a;
            this.f3330j = c0465d.f3300b;
        }
    }

    /* renamed from: a */
    public void m3586a(C0463b c0463b) {
        if (c0463b != null) {
            this.f3331k = c0463b.f3296b;
        }
    }

    /* renamed from: b */
    public void m3605b(C0463b c0463b) {
        if (c0463b != null) {
            this.f3332l = c0463b.f3295a;
        }
    }

    /* renamed from: a */
    public void m3599a(boolean z) {
        this.f3333m = z;
    }

    /* renamed from: b */
    public void m3607b(boolean z) {
        this.f3334n = z;
    }

    /* renamed from: c */
    public void m3609c(boolean z) {
        this.f3337q = z;
    }

    /* renamed from: a */
    public boolean m3601a() {
        return this.f3337q;
    }

    /* renamed from: d */
    public void m3612d(boolean z) {
        this.f3335o = z;
    }

    /* renamed from: a */
    public void m3585a(int i) {
        this.f3338r = i;
    }

    /* renamed from: b */
    public int m3603b() {
        return this.f3338r;
    }

    /* renamed from: e */
    public void m3614e(boolean z) {
        this.f3336p = z;
    }

    /* renamed from: c */
    public boolean m3610c() {
        return this.f3336p;
    }

    /* renamed from: d */
    public List<String> m3611d() {
        return this.f3340v;
    }

    /* renamed from: a */
    public void m3596a(String str) {
        if (this.f3340v.contains(str)) {
            return;
        }
        this.f3340v.add(str);
    }

    /* renamed from: b */
    public String m3604b(String str) {
        return this.f3341w.get(str);
    }

    /* renamed from: a */
    public void m3597a(String str, String str2) {
        this.f3341w.put(str, str2);
    }

    /* renamed from: c */
    public void m3608c(String str) {
        if (this.f3341w.get(str) != null) {
            this.f3341w.remove(str);
        }
    }

    /* renamed from: e */
    public InterfaceC0528c m3613e() {
        return this.f3342x;
    }

    /* renamed from: f */
    public String m3616f() {
        int m3579d = m3579d(this.f3328h);
        return Integer.toString(Math.max(this.f3326f != null ? m3579d(this.f3326f) : 0, Math.min(this.f3327g != null ? m3579d(this.f3327g) : m3579d, m3579d)));
    }

    /* renamed from: a */
    private void m3577a(File file, File file2, File file3, File file4, File file5, File[] fileArr, List<String> list, boolean z) {
        list.add("p");
        if (this.f3322a.f3584e) {
            list.add("-v");
        }
        if (this.f3322a.f3588i) {
            list.add("-u");
        }
        if (this.f3322a.f3583d) {
            list.add("--debug-mode");
        }
        if (this.f3333m) {
            list.add("--shared-lib");
        }
        if (this.f3326f != null) {
            list.add("--min-sdk-version");
            list.add(this.f3326f);
        }
        if (this.f3328h != null) {
            list.add("--target-sdk-version");
            list.add(m3616f());
        }
        if (this.f3327g != null) {
            list.add("--max-sdk-version");
            list.add(this.f3327g);
            list.add("--max-res-version");
            list.add(this.f3327g);
        }
        if (this.f3331k != null) {
            list.add("--rename-manifest-package");
            list.add(this.f3331k);
        }
        if (this.f3329i != null) {
            list.add("--version-code");
            list.add(this.f3329i);
        }
        if (this.f3330j != null) {
            list.add("--version-name");
            list.add(this.f3330j);
        }
        list.add("--no-version-vectors");
        list.add("-F");
        list.add(file.getAbsolutePath());
        if (this.f3322a.f3589j) {
            list.add("-x");
        }
        if (fileArr != null) {
            for (File file6 : fileArr) {
                list.add("-I");
                list.add(file6.getPath());
            }
        }
        if (file3 != null) {
            list.add("-S");
            list.add(file3.getAbsolutePath());
        }
        if (file2 != null) {
            list.add("-M");
            list.add(file2.getAbsolutePath());
        }
        if (file5 != null) {
            list.add("-A");
            list.add(file5.getAbsolutePath());
        }
        if (file4 != null) {
            list.add(file4.getAbsolutePath());
        }
        try {
            C0542g.m3990a(list, this.f3323c);
            this.f3323c.mo3982b(R.string.text, "command ran: ");
            this.f3323c.mo3982b(R.string.text, list.toString());
        } catch (C0522a e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: b */
    private void m3578b(File file, File file2, File file3, File file4, File file5, File[] fileArr, List<String> list, boolean z) {
        File file6;
        File file7 = (File) null;
        if (file3 != null) {
            file7 = new File(new File(file3.getParent(), "build"), "resources.zip");
        }
        if (file3 == null || file7.exists()) {
            file6 = file7;
        } else {
            ArrayList arrayList = new ArrayList(list);
            arrayList.add("compile");
            arrayList.add("--dir");
            arrayList.add(file3.getAbsolutePath());
            arrayList.add("--legacy");
            File file8 = new File(new File(file3.getParent(), "build"), "resources.zip");
            arrayList.add("-o");
            arrayList.add(file8.getAbsolutePath());
            if (this.f3322a.f3584e) {
                arrayList.add("-v");
            }
            if (this.f3322a.f3593n) {
                arrayList.add("--no-crunch");
            }
            try {
                C0542g.m3990a(arrayList, this.f3323c);
                this.f3323c.mo3982b(R.string.text, "aapt2 compile command ran: ");
                this.f3323c.mo3982b(R.string.text, arrayList.toString());
                file6 = file8;
            } catch (C0522a e2) {
                throw new C0461b(e2);
            }
        }
        if (file2 != null) {
            list.add("link");
            list.add("-o");
            list.add(file.getAbsolutePath());
            if (this.f3332l != null && !this.f3333m) {
                list.add("--package-id");
                list.add(this.f3332l);
            }
            if (this.f3333m) {
                list.add("--shared-lib");
            }
            if (this.f3326f != null) {
                list.add("--min-sdk-version");
                list.add(this.f3326f);
            }
            if (this.f3328h != null) {
                list.add("--target-sdk-version");
                list.add(this.f3328h);
            }
            if (this.f3331k != null) {
                list.add("--rename-manifest-package");
                list.add(this.f3331k);
                list.add("--rename-instrumentation-target-package");
                list.add(this.f3331k);
            }
            if (this.f3329i != null) {
                list.add("--version-code");
                list.add(this.f3329i);
            }
            if (this.f3330j != null) {
                list.add("--version-name");
                list.add(this.f3330j);
            }
            list.add("--no-auto-version");
            list.add("--no-version-vectors");
            list.add("--no-version-transitions");
            list.add("--no-resource-deduping");
            if (this.f3334n) {
                list.add("--enable-sparse-encoding");
            }
            if (this.f3322a.f3580a && this.f3322a.f3590k) {
                list.add("--enable-compact-entries");
            }
            if (this.f3322a.f3589j) {
                list.add("-x");
            }
            if (this.f3322a.f3580a && this.f3322a.f3597r != null && !this.f3322a.f3597r.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, Boolean> entry : this.f3322a.f3597r.entrySet()) {
                    arrayList2.add(new StringBuffer().append(new StringBuffer().append(entry.getKey()).append("=").toString()).append(entry.getValue()).toString());
                }
                list.add("--feature-flags");
                list.add(C3080al.m18538a(arrayList2, ","));
            }
            if (fileArr != null) {
                for (File file9 : fileArr) {
                    list.add("-I");
                    list.add(file9.getPath());
                }
            }
            list.add("--manifest");
            list.add(file2.getAbsolutePath());
            if (file5 != null) {
                list.add("-A");
                list.add(file5.getAbsolutePath());
            }
            if (file4 != null) {
                list.add("-R");
                list.add(file4.getAbsolutePath());
            }
            if (this.f3322a.f3584e) {
                list.add("-v");
            }
            if (file6 != null) {
                list.add(file6.getAbsolutePath());
            }
            try {
                C0542g.m3990a(list, this.f3323c);
                this.f3323c.mo3982b(R.string.text, "aapt2 link command ran: ");
                this.f3323c.mo3982b(R.string.text, list.toString());
            } catch (C0522a e3) {
                throw new C0461b(e3);
            }
        }
    }

    /* renamed from: a */
    public void m3594a(File file, File file2, File file3, File file4, File file5, File[] fileArr) {
        String str;
        String str2;
        if (!this.f3323c.mo3981a()) {
            String str3 = this.f3322a.f3600u;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str3);
            boolean endsWith = str3.endsWith("_usr");
            if (this.f3322a.m3888a()) {
                InterfaceC0541f interfaceC0541f = this.f3323c;
                Object[] objArr = new Object[1];
                StringBuffer append = new StringBuffer().append("Using aapt2");
                if (endsWith) {
                    str2 = " (custom)";
                } else {
                    str2 = str3.endsWith("_64") ? " (64bit)" : "";
                }
                objArr[0] = append.append(str2).toString();
                interfaceC0541f.mo3984d(R.string.text, objArr);
                m3578b(file, file2, file3, file4, file5, fileArr, arrayList, true);
                return;
            }
            InterfaceC0541f interfaceC0541f2 = this.f3323c;
            Object[] objArr2 = new Object[1];
            StringBuffer append2 = new StringBuffer().append("Using aapt");
            if (endsWith) {
                str = " (custom)";
            } else {
                str = str3.endsWith("_64") ? " (64bit)" : "";
            }
            objArr2[0] = append2.append(str).toString();
            interfaceC0541f2.mo3984d(R.string.text, objArr2);
            m3577a(file, file2, file3, file4, file5, fileArr, arrayList, true);
        }
    }

    /* renamed from: a */
    public void m3593a(File file, File file2, File file3, C0543h c0543h) {
        try {
            C0535j.m3961a(file2, file, file3, this.f3322a.f3596q, c0543h);
        } catch (C0522a | IOException e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public int m3580a(C0462a c0462a, String str) {
        int m3579d = m3579d(str);
        if (m3579d == 1) {
            return Integer.parseInt(c0462a.f3285f.get("minSdkVersion"));
        }
        return m3579d;
    }

    /* renamed from: d */
    private int m3579d(String str) {
        String upperCase = str.toUpperCase();
        if (upperCase.equals(DateFormat.NUM_MONTH)) {
            return 23;
        }
        if (upperCase.equals("N")) {
            return 24;
        }
        if (upperCase.equals("O")) {
            return 26;
        }
        if (upperCase.equals("P")) {
            return 28;
        }
        if (upperCase.equals("Q")) {
            return 29;
        }
        if (upperCase.equals("R")) {
            return 30;
        }
        if (upperCase.equals("S")) {
            return 31;
        }
        if (upperCase.equals("SV2")) {
            return 32;
        }
        if (!upperCase.equals("T") && !upperCase.equals("TIRAMISU")) {
            if (!upperCase.equals("UPSIDEDOWNCAKE") && !upperCase.equals("UPSIDE_DOWN_CAKE")) {
                if (!upperCase.equals("VANILLAICECREAM") && !upperCase.equals("VANILLA_ICE_CREAM")) {
                    if (upperCase.equals("BAKLAVA")) {
                        return 36;
                    }
                    if (!upperCase.equals("CINNAMONBUN") && !upperCase.equals("CINNAMON_BUN")) {
                        if (upperCase.equals("SDK_CUR_DEVELOPMENT")) {
                            return 10000;
                        }
                        return Integer.parseInt(str);
                    }
                    return 37;
                }
                return 35;
            }
            return 34;
        }
        return 33;
    }

    /* renamed from: f */
    public C0538c<C0506f, XmlResourceParserC0502b> m3615f(boolean z) {
        XmlResourceParserC0502b xmlResourceParserC0502b;
        C0509i c0509i = new C0509i();
        c0509i.m3838a("raw", new C0507g());
        c0509i.m3838a("9patch", new C0504d());
        if (z) {
            xmlResourceParserC0502b = new C0503c(this.f3323c);
        } else {
            xmlResourceParserC0502b = new XmlResourceParserC0502b(this.f3323c);
        }
        xmlResourceParserC0502b.m3799a(new C0505e());
        c0509i.m3838a(XMLConstants.XML_NS_PREFIX, new C0512l(xmlResourceParserC0502b, m3618h(), this.f3323c));
        return new C0538c<>(new C0506f(c0509i, this.f3323c), xmlResourceParserC0502b);
    }

    /* renamed from: g */
    public C0538c<C0506f, XmlResourceParserC0502b> m3617g() {
        C0509i c0509i = new C0509i();
        C0503c c0503c = new C0503c(this.f3323c);
        c0509i.m3838a(XMLConstants.XML_NS_PREFIX, new C0512l(c0503c, m3618h(), this.f3323c));
        return new C0538c<>(new C0506f(c0509i, this.f3323c), c0503c);
    }

    /* renamed from: h */
    public C0513a m3618h() {
        C0513a c0513a = new C0513a();
        c0513a.setProperty("http://xmlpull.org/v1/doc/properties.html#serializer-indentation", "    ");
        c0513a.setProperty("http://xmlpull.org/v1/doc/properties.html#serializer-line-separator", System.getProperty("line.separator"));
        c0513a.setProperty(InterfaceC0514b.f3578a_, "utf-8");
        c0513a.m3867a(true);
        return c0513a;
    }

    /* renamed from: a */
    private void m3576a(C0499j c0499j, InterfaceC0528c interfaceC0528c, InterfaceC0514b interfaceC0514b) {
        if (!this.f3323c.mo3981a()) {
            try {
                String m3749a = c0499j.m3749a();
                boolean mo3916a = interfaceC0528c.mo3916a(m3749a);
                OutputStream mo3923d = interfaceC0528c.mo3923d(new StringBuffer().append(m3749a).append(mo3916a ? ".temp" : "").toString());
                interfaceC0514b.setOutput(mo3923d, (String) null);
                interfaceC0514b.startDocument((String) null, (Boolean) null);
                interfaceC0514b.startTag((String) null, "resources");
                for (C0494e c0494e : c0499j.m3751b()) {
                    if (!c0499j.m3750a(c0494e)) {
                        ((InterfaceC0515a) c0494e.m3701d()).mo3626a(interfaceC0514b, c0494e);
                    }
                }
                interfaceC0514b.endTag((String) null, "resources");
                interfaceC0514b.mo3865a();
                interfaceC0514b.endDocument();
                interfaceC0514b.flush();
                mo3923d.close();
                if (mo3916a) {
                    File mo3936n = interfaceC0528c.mo3936n(m3749a);
                    File mo3936n2 = interfaceC0528c.mo3936n(new StringBuffer().append(m3749a).append(".temp").toString());
                    if (mo3936n != null && mo3936n2 != null) {
                        C3061a.m18308a(mo3936n, mo3936n2, true);
                    }
                    interfaceC0528c.mo3929g(new StringBuffer().append(m3749a).append(".temp").toString());
                }
            } catch (C0529d | IOException e2) {
                throw new C0461b(new StringBuffer().append("Could not generate: ").append(c0499j.m3749a()).toString(), e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m3575a(C0492c c0492c, InterfaceC0528c interfaceC0528c, XmlSerializer xmlSerializer) {
        C3062b c3062b;
        List<C3090av> list;
        boolean z;
        if (!this.f3323c.mo3981a()) {
            boolean z2 = false;
            try {
                boolean mo3916a = interfaceC0528c.mo3916a("values/public.xml");
                File parentFile = new File(interfaceC0528c.mo3949g()).getParentFile();
                HashMap hashMap = new HashMap();
                if (mo3916a && this.f3338r == 3) {
                    List<C3090av> m18326d = C3061a.m18326d(interfaceC0528c.mo3936n("values/public.xml"));
                    C3062b c3062b2 = new C3062b(new File(parentFile, "changed_ids.json"));
                    c3062b2.m18338a(c0492c.m3679h());
                    c3062b = c3062b2;
                    list = m18326d;
                } else {
                    c3062b = (C3062b) null;
                    list = (List) null;
                }
                OutputStream mo3923d = interfaceC0528c.mo3923d(new StringBuffer().append("values/public.xml").append(mo3916a ? ".temp" : "").toString());
                xmlSerializer.setOutput(mo3923d, (String) null);
                xmlSerializer.startDocument((String) null, (Boolean) null);
                xmlSerializer.startTag((String) null, "resources");
                for (C0493d c0493d : c0492c.m3671b()) {
                    if ((c0492c.m3678g() == this.f3339s || this.f3338r == 2) && c0493d.m3692d().f3413a == c0492c.m3678g()) {
                        xmlSerializer.startTag((String) null, "public");
                        xmlSerializer.attribute((String) null, "type", c0493d.m3695g().m3740a());
                        xmlSerializer.attribute((String) null, "name", c0493d.m3693e());
                        xmlSerializer.attribute((String) null, "id", String.format("0x%08x", new Integer(c0493d.m3692d().f3416d)));
                        xmlSerializer.endTag((String) null, "public");
                    } else if (this.f3338r == 1) {
                        if (z2) {
                            z = z2;
                        } else {
                            xmlSerializer.text("\n");
                            z = true;
                        }
                        xmlSerializer.text("\t");
                        xmlSerializer.comment(String.format(" <public type=\"%s\" name=\"%s\" id=\"%s\" /> ", c0493d.m3695g().m3740a(), c0493d.m3693e(), String.format("0x%08x", new Integer(c0493d.m3692d().f3416d))));
                        xmlSerializer.text("\n");
                        z2 = z;
                    } else if (this.f3338r == 3 && list != null) {
                        String m3740a = c0493d.m3695g().m3740a();
                        int[] m18311a = C3061a.m18311a(list, m3740a);
                        if (m18311a[0] > 0 && m18311a[1] > 0) {
                            Integer num = (Integer) hashMap.get(m3740a);
                            Integer num2 = num == null ? new Integer(1) : num;
                            int intValue = ((m18311a[1] & 255) << 16) + ((m18311a[0] & 255) << 24) + ((num2.intValue() + m18311a[2]) & 65535);
                            xmlSerializer.startTag((String) null, "public");
                            xmlSerializer.attribute((String) null, "type", m3740a);
                            xmlSerializer.attribute((String) null, "name", c0493d.m3693e());
                            xmlSerializer.attribute((String) null, "id", String.format("0x%08x", new Integer(intValue)));
                            xmlSerializer.endTag((String) null, "public");
                            hashMap.put(m3740a, new Integer(new Integer(num2.intValue() + 1).intValue()));
                            c3062b.m18339a(c0493d.m3692d().f3416d, intValue);
                        }
                    }
                }
                xmlSerializer.endTag((String) null, "resources");
                xmlSerializer.endDocument();
                xmlSerializer.flush();
                mo3923d.close();
                if (mo3916a) {
                    File mo3936n = interfaceC0528c.mo3936n("values/public.xml");
                    File mo3936n2 = interfaceC0528c.mo3936n(new StringBuffer().append("values/public.xml").append(".temp").toString());
                    if (mo3936n != null && mo3936n2 != null) {
                        C3061a.m18308a(mo3936n, mo3936n2, true);
                    }
                    interfaceC0528c.mo3929g(new StringBuffer().append("values/public.xml").append(".temp").toString());
                    if (c3062b != null) {
                        c3062b.m18340b();
                    }
                }
            } catch (C0529d e2) {
                e = e2;
                throw new C0461b("Could not generate public.xml file", e);
            } catch (IOException e3) {
                e = e3;
                throw new C0461b("Could not generate public.xml file", e);
            }
        }
    }

    /* renamed from: a */
    public C0492c[] m3602a(C0530e c0530e, C0495f c0495f, boolean z, boolean z2) {
        try {
            InterfaceC0528c m3953a = c0530e.m3953a();
            this.f3342x = m3953a;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(m3953a.mo3920c("resources.arsc"));
            try {
                if (z2) {
                    return C0501a.m3760a(bufferedInputStream, false, z, false, 0, c0495f, (C0467a) null, this.f3323c).m3785b();
                }
                C0492c[] m3785b = C0501a.m3760a(bufferedInputStream, false, z, this.f3335o, this.f3338r, c0495f, this, this.f3323c).m3785b();
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                }
                return m3785b;
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (C0529d e4) {
            throw new C0461b(new StringBuffer().append("Could not load resources.arsc from file: ").append(c0530e).toString(), e4);
        }
    }

    /* renamed from: a */
    public File m3584a(int i, String str) {
        File m3619i = m3619i();
        if (str != null) {
            File file = new File(m3619i, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(String.valueOf(i)).append('-').toString()).append(str).toString()).append(".apk").toString());
            if (file.exists()) {
                return file;
            }
        }
        File file2 = new File(m3619i, new StringBuffer().append(String.valueOf(i)).append(".apk").toString());
        if (!file2.exists()) {
            if (i == 1 && C3102bd.m18949e()) {
                return new File(C3102bd.f18322e, "1.apk");
            }
            InterfaceC0541f interfaceC0541f = this.f3323c;
            Object[] objArr = new Object[1];
            objArr[0] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("No framework with ID:").append(i).toString()).append(" found!").toString()).append(i == 23 ? " (MT Manager translation package?!)" : "").toString();
            interfaceC0541f.mo3983c(R.string.text, objArr);
            throw new C0457b(i);
        }
        return file2;
    }

    /* renamed from: a */
    public void m3592a(File file) {
        m3595a(file, this.f3322a.f3599t);
    }

    /* renamed from: a */
    public void m3595a(File file, String str) {
        C2604w c2604w;
        InputStream inputStream;
        C2604w c2604w2;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4 = (InputStream) null;
        C3248b c3248b = (C3248b) null;
        C2604w c2604w3 = (C2604w) null;
        try {
            c2604w = new C2604w(file);
            try {
                C2602u m16162a = c2604w.m16162a("resources.arsc");
                if (m16162a == null) {
                    throw new C0461b("Can't find resources.arsc file");
                }
                inputStream = new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a());
                try {
                    byte[] m13984b = C1887e.m13984b(inputStream);
                    C0501a.a m3761a = C0501a.m3761a(new ByteArrayInputStream(m13984b), true, true, false, 0, (C0467a) null, this.f3323c);
                    m3600a(m13984b, m3761a.m3784a());
                    File file2 = new File(C3102bd.f18323f);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    File file3 = new File(file2, new StringBuffer().append(new StringBuffer().append(String.valueOf(m3761a.m3786c().m3678g())).append(str == null ? "" : new StringBuffer().append('-').append(str).toString()).toString()).append(".apk").toString());
                    c3248b = C3248b.m19496a(new FileOutputStream(file3));
                    c3248b.m16215a(C3102bd.f18315aw);
                    c3248b.m16219b(0);
                    CRC32 crc32 = new CRC32();
                    crc32.update(m13984b);
                    C2602u c2602u = new C2602u("resources.arsc");
                    c2602u.setSize(m13984b.length);
                    c2602u.setMethod(0);
                    c2602u.setCrc(crc32.getValue());
                    c3248b.mo16214a(c2602u);
                    c3248b.write(m13984b);
                    c3248b.flush();
                    c3248b.m16218b();
                    C2602u m16162a2 = c2604w.m16162a(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                    if (m16162a2 != null) {
                        inputStream3 = new BufferedInputStream(c2604w.m16160a(m16162a2), C3249i.m19500a());
                        try {
                            byte[] m13984b2 = C1887e.m13984b(inputStream3);
                            CRC32 crc322 = new CRC32();
                            crc322.update(m13984b2);
                            m16162a2.setSize(m13984b2.length);
                            m16162a2.setCompressedSize(-1);
                            m16162a2.setCrc(crc322.getValue());
                            c3248b.mo16214a(m16162a2);
                            c3248b.write(m13984b2);
                            c3248b.flush();
                            c3248b.m16218b();
                        } catch (IOException e2) {
                            e = e2;
                            c2604w2 = c2604w;
                            inputStream2 = inputStream3;
                            try {
                                throw new C0461b(e);
                            } catch (Throwable th) {
                                th = th;
                                c2604w = c2604w2;
                                inputStream = inputStream2;
                                C1887e.m13970a(inputStream);
                                C1887e.m13972a((OutputStream) c3248b);
                                C1887e.m13969a(c2604w);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream3;
                            C1887e.m13970a(inputStream);
                            C1887e.m13972a((OutputStream) c3248b);
                            C1887e.m13969a(c2604w);
                            throw th;
                        }
                    } else {
                        inputStream3 = inputStream;
                    }
                    try {
                        this.f3323c.mo3984d(R.string.text, new StringBuffer().append("Framework installed to: ").append(file3).toString());
                        C1887e.m13970a(inputStream3);
                        C1887e.m13972a((OutputStream) c3248b);
                        C1887e.m13969a(c2604w);
                    } catch (IOException e3) {
                        e = e3;
                        c2604w2 = c2604w;
                        inputStream2 = inputStream3;
                        throw new C0461b(e);
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream3;
                        C1887e.m13970a(inputStream);
                        C1887e.m13972a((OutputStream) c3248b);
                        C1887e.m13969a(c2604w);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    c2604w2 = c2604w;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e5) {
                e = e5;
                c2604w2 = c2604w;
                inputStream2 = inputStream4;
            } catch (Throwable th5) {
                th = th5;
                inputStream = inputStream4;
            }
        } catch (IOException e6) {
            e = e6;
            c2604w2 = c2604w3;
            inputStream2 = inputStream4;
        } catch (Throwable th6) {
            th = th6;
            c2604w = c2604w3;
            inputStream = inputStream4;
        }
    }

    /* renamed from: a */
    public void m3600a(byte[] bArr, C0501a.c[] cVarArr) {
        for (C0501a.c cVar : cVarArr) {
            int i = cVar.f3498a + 3;
            int i2 = (cVar.f3499b * 4) + i;
            while (i < i2) {
                bArr[i] = (byte) (bArr[i] | BluetoothHidDevice.SUBCLASS1_KEYBOARD);
                i += 4;
            }
        }
    }

    /* renamed from: i */
    public File m3619i() {
        if (this.f3324d != null) {
            return this.f3324d;
        }
        File file = new File(this.f3322a.f3598s);
        this.f3324d = file;
        return file;
    }

    public C0467a(InterfaceC0541f interfaceC0541f) {
        this.f3323c = interfaceC0541f;
    }
}
