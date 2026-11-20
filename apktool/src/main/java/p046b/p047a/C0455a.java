package p046b.p047a;

import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.p270e.C2466a;
import org.p270e.C2467b;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.p049b.C0462a;
import p046b.p047a.p049b.C0464c;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p051a.C0498i;
import p046b.p047a.p050c.p055d.C0517c;
import p046b.p047a.p056d.C0519a;
import p046b.p047a.p056d.C0520b;
import p046b.p057b.C0522a;
import p046b.p058c.C0529d;
import p046b.p058c.C0530e;
import p046b.p058c.InterfaceC0528c;
import p046b.p059d.C0536a;
import p046b.p059d.C0542g;
import p046b.p059d.C0543h;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: Androlib.java */
/* renamed from: b.a.a */
/* loaded from: classes.dex */
public class C0455a {

    /* renamed from: i */
    private static final String f3264i = "unknown";

    /* renamed from: j */
    private static final String[] f3265j = {"resources.arsc", AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, "res", "r", "R"};

    /* renamed from: k */
    private static final String[] f3266k = {"resources.arsc", AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME};

    /* renamed from: l */
    private static final String[] f3267l = {AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, "res"};

    /* renamed from: m */
    private static final String[] f3268m = {AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME};

    /* renamed from: n */
    private static final String[] f3269n = {"classes.dex", AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, "resources.arsc", "res", "r", "R", "lib", "libs", "assets", "META-INF", "kotlin", AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME};

    /* renamed from: o */
    private static final Pattern f3270o = Pattern.compile(new StringBuffer().append(new StringBuffer().append("(").append("jpg|jpeg|png|gif|webp|wav|mp2|mp3|ogg|aac|mpg|mpeg|mid|midi|smf|jet|rtttl|imy|xmf|mp4|").toString()).append("m4a|m4v|3gp|3gpp|3g2|3gpp2|amr|awb|wma|wmv|webm|mkv)$").toString());

    /* renamed from: b */
    public C0518d f3272b;

    /* renamed from: c */
    private final C0467a f3273c;

    /* renamed from: d */
    private boolean f3274d;

    /* renamed from: f */
    private final InterfaceC0541f f3276f;

    /* renamed from: g */
    private boolean f3277g;

    /* renamed from: a */
    protected final C0498i f3271a = new C0498i();

    /* renamed from: e */
    private int f3275e = 0;

    /* renamed from: h */
    private boolean f3278h = false;

    public C0455a(C0518d c0518d, InterfaceC0541f interfaceC0541f) {
        this.f3276f = interfaceC0541f;
        this.f3273c = new C0467a(interfaceC0541f);
        this.f3272b = c0518d;
        this.f3273c.f3322a = c0518d;
        this.f3274d = true;
        this.f3277g = false;
    }

    /* renamed from: a */
    public void m3496a(boolean z) {
        this.f3273c.m3609c(z);
    }

    /* renamed from: b */
    public void m3508b(boolean z) {
        this.f3273c.m3612d(z);
    }

    /* renamed from: a */
    public void m3482a(int i) {
        this.f3273c.m3585a(i);
    }

    /* renamed from: c */
    public void m3514c(boolean z) {
        this.f3274d = z;
    }

    /* renamed from: d */
    public void m3517d(boolean z) {
        this.f3277g = z;
        this.f3273c.m3614e(z);
    }

    /* renamed from: a */
    public boolean m3497a() {
        return this.f3277g;
    }

    /* renamed from: a */
    public C0495f m3480a(C0530e c0530e) {
        return this.f3273c.m3583a(c0530e, true);
    }

    /* renamed from: a */
    public C0495f m3481a(C0530e c0530e, boolean z) {
        return this.f3273c.m3583a(c0530e, z);
    }

    /* renamed from: c */
    private void m3476c(File file, String str) {
        C2466a c2466a;
        try {
            File file2 = new File(file, "additional_dex.json");
            if (file2.isFile()) {
                c2466a = new C2466a(C3061a.m18332i(file2));
            } else {
                c2466a = new C2466a();
            }
            c2466a.m15574a(str);
            C3061a.m18319b(file2, c2466a.m15583j(2));
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public void m3487a(C0530e c0530e, File file, String str) {
        if (!this.f3276f.mo3981a()) {
            try {
                C0543h c0543h = new C0543h(file);
                this.f3276f.mo3984d(R.string.build_copy_file, str);
                c0530e.m3953a().mo3913a(file, str, c0543h);
                c0543h.m4000b();
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: a */
    public void m3494a(File file, File file2, String str, boolean z, int i) {
        File file3;
        if (!this.f3276f.mo3981a()) {
            try {
                String substring = str.substring(0, str.lastIndexOf(46));
                if (str.equalsIgnoreCase("classes.dex")) {
                    file3 = new File(file2, "smali");
                } else if (str.matches("^classes\\d+\\.dex$")) {
                    file3 = new File(file2, new StringBuffer().append(new StringBuffer().append("smali").append("_").toString()).append(substring).toString());
                } else {
                    int indexOf = substring.indexOf(47);
                    file3 = new File(file2, new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(substring).toString());
                    if (indexOf > 0) {
                        if (new File(file2, new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(substring.substring(0, indexOf)).toString()).exists()) {
                            C0543h c0543h = new C0543h(file2);
                            int i2 = 1;
                            File file4 = new File(file2, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(substring.substring(0, indexOf)).toString()).append("_").toString()).append(1).toString());
                            while (file4.exists()) {
                                i2++;
                                file4 = new File(file2, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(substring.substring(0, indexOf)).toString()).append("_").toString()).append(i2).toString());
                            }
                            String stringBuffer = new StringBuffer().append(file4.getName()).append(substring.substring(indexOf)).toString();
                            file3 = new File(file2, new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(stringBuffer).toString());
                            c0543h.m3998a(str, new StringBuffer().append(stringBuffer).append(".dex").toString());
                            c0543h.m4000b();
                            m3476c(file2, new StringBuffer().append(stringBuffer).append(".dex").toString());
                        } else {
                            m3476c(file2, str);
                        }
                    } else {
                        m3476c(file2, str);
                    }
                }
                C0542g.m3987a(file3);
                file3.mkdirs();
                this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Baksmaling ").append(str).toString()).append("...").toString());
                C0520b.m3898a(file, file3, str, z, i);
            } catch (C0522a e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: a */
    public void m3495a(File file, File file2, boolean z, int i) {
        try {
            C0542g.m3987a(file2);
            file2.mkdirs();
            this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Baksmaling ").append(file.getName()).toString()).append(" into ").toString()).append(file2.getAbsolutePath()).toString()).append("...").toString());
            C0520b.m3899a(file, file2, z, i);
        } catch (C0522a e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public void m3484a(C0530e c0530e, File file) {
        try {
            C0543h c0543h = new C0543h(file);
            this.f3276f.mo3984d(R.string.text, "Copying raw manifest...");
            c0530e.m3953a().mo3915a(file, f3268m, c0543h);
            c0543h.m4000b();
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public void m3485a(C0530e c0530e, File file, C0495f c0495f) {
        this.f3273c.m3589a(c0495f, c0530e, file);
    }

    /* renamed from: b */
    public void m3504b(C0530e c0530e, File file) {
        if (!this.f3276f.mo3981a()) {
            try {
                C0543h c0543h = new C0543h(file);
                this.f3276f.mo3984d(R.string.text, "Copying raw resources...");
                c0530e.m3953a().mo3915a(file, f3265j, c0543h);
                c0543h.m4000b();
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: b */
    public void m3505b(C0530e c0530e, File file, C0495f c0495f) {
        this.f3273c.m3606b(c0495f, c0530e, file);
    }

    /* renamed from: c */
    public void m3512c(C0530e c0530e, File file, C0495f c0495f) {
        this.f3273c.m3590a(c0495f, c0530e, file, this.f3274d);
    }

    /* renamed from: a */
    public void m3488a(C0530e c0530e, File file, short s) {
        if (!this.f3276f.mo3981a()) {
            this.f3276f.mo3984d(R.string.text, "Copying assets and libs...");
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                C0543h c0543h = new C0543h(file);
                if (s == 1 && m3953a.mo3919b("assets")) {
                    m3465a(m3953a, file, "assets", c0543h);
                }
                if (m3953a.mo3919b("lib")) {
                    m3465a(m3953a, file, "lib", c0543h);
                }
                if (m3953a.mo3919b("libs")) {
                    m3465a(m3953a, file, "libs", c0543h);
                }
                if (m3953a.mo3919b("kotlin")) {
                    m3465a(m3953a, file, "kotlin", c0543h);
                }
                c0543h.m4000b();
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: a */
    public void m3489a(C0530e c0530e, Collection<String> collection) {
        if (!this.f3276f.mo3981a()) {
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                for (String str : m3953a.mo3908a(true)) {
                    if (m3475b(str) && m3953a.mo3930h(str) == 0 && m3953a.mo3951p(str) != 0) {
                        String m3464a = m3464a(str);
                        String str2 = C3262u.m19641b(m3464a)[1];
                        if (str2.isEmpty() || !f3270o.matcher(str2).find()) {
                            str2 = m3464a;
                        }
                        if (!collection.contains(str2)) {
                            collection.add(str2);
                        }
                    }
                }
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: e */
    public void m3519e(boolean z) {
        this.f3278h = z;
    }

    /* renamed from: a */
    private String m3464a(String str) {
        String m3604b = this.f3273c.m3604b(str);
        return m3604b != null ? m3604b : str;
    }

    /* renamed from: a */
    private boolean m3469a(InterfaceC0528c interfaceC0528c, String str) {
        return (str.toLowerCase().startsWith("AndroidManifest.xml/".toLowerCase()) || str.toLowerCase().matches("^classes(\\d+)?\\.dex/.*$") || str.toLowerCase().startsWith("resources.arsc/")) && !this.f3273c.m3611d().contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m3475b(String str) {
        for (String str2 : f3269n) {
            if (str2.equals(str) || str.startsWith(new StringBuffer().append(str2).append("/").toString())) {
                if (m3477c(str)) {
                    return false;
                }
                if (this.f3278h || (!str.startsWith("res/") && !str.startsWith("r/") && !str.startsWith("R/"))) {
                    return true;
                }
                if (str.matches("^classes(\\d+)?\\.dex$")) {
                    return this.f3273c.m3611d().contains(str);
                }
                return true;
            }
        }
        if (str.matches("^classes(\\d+)?\\.dex$")) {
        }
    }

    /* renamed from: c */
    private boolean m3477c(String str) {
        return (!str.startsWith("META-INF/") || str.startsWith("META-INF/services/") || str.equalsIgnoreCase("META-INF/MANIFEST.MF") || str.toUpperCase().matches("^META-INF/[^/]+\\.RSA$") || str.toUpperCase().matches("^META-INF/[^/]+\\.DSA$") || str.toUpperCase().matches("^META-INF/[^/]+\\.EC$") || str.toUpperCase().matches("^META-INF/[^/]+\\.SF$")) ? false : true;
    }

    /* renamed from: a */
    public void m3486a(C0530e c0530e, File file, C0495f c0495f, boolean z) {
        if (!this.f3276f.mo3981a()) {
            this.f3276f.mo3984d(R.string.text, "Copying unknown files...");
            File file2 = new File(file, "unknown");
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                C0543h c0543h = new C0543h(file);
                for (String str : m3953a.mo3908a(true)) {
                    if ((!m3475b(str) && (!str.endsWith(".dex") || (!z && str.indexOf("/") != -1))) || m3469a(m3953a, str)) {
                        m3953a.mo3913a(file2, str, c0543h);
                        String m4001c = c0543h.m4001c(new StringBuffer().append(new StringBuffer().append("unknown").append(File.separator).toString()).append(str).toString());
                        this.f3271a.m3748a(m4001c != null ? m4001c.substring(f3264i.length() + 1) : str, String.valueOf(m3953a.mo3930h(str)));
                    }
                }
                c0543h.m4000b();
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: c */
    public void m3511c(C0530e c0530e, File file) {
        if (!this.f3276f.mo3981a()) {
            this.f3276f.mo3984d(R.string.text, "Copying original files...");
            File file2 = new File(file, "original");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            try {
                InterfaceC0528c m3953a = c0530e.m3953a();
                C0543h c0543h = new C0543h(file);
                if (m3953a.mo3916a(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                    m3953a.mo3913a(file2, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, c0543h);
                }
                if (m3953a.mo3916a(AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME)) {
                    m3953a.mo3912a(file2, AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME);
                }
                if (m3953a.mo3919b("META-INF")) {
                    m3465a(m3953a, file2, "META-INF", c0543h);
                    if (m3953a.mo3919b("META-INF/services")) {
                        this.f3276f.mo3984d(R.string.text, "Copying META-INF/services directory");
                        m3465a(m3953a, file, "META-INF/services", c0543h);
                    }
                }
                c0543h.m4000b();
                InterfaceC0008c m18964a = C3105bg.m18964a(c0530e);
                if (m18964a != null) {
                    C3105bg.m18966a(m18964a, new File(file2, "signature.data"));
                }
            } catch (C0529d e2) {
                throw new C0461b(e2);
            }
        }
    }

    /* renamed from: a */
    private void m3465a(InterfaceC0528c interfaceC0528c, File file, String str, C0543h c0543h) {
        if (interfaceC0528c.mo3919b(str)) {
            InterfaceC0528c mo3925e = interfaceC0528c.mo3925e(str);
            for (String str2 : mo3925e.mo3908a(true)) {
                if (this.f3273c.m3604b(new StringBuffer().append(mo3925e.mo3949g()).append(str2).toString()) == null) {
                    interfaceC0528c.mo3913a(file, new StringBuffer().append(mo3925e.mo3949g()).append(str2).toString(), c0543h);
                }
            }
        }
    }

    /* renamed from: a */
    public void m3491a(File file, C0462a c0462a) {
        try {
            c0462a.m3533a(new File(file, "apktool.json"));
        } catch (IOException | C2467b e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: b */
    public C0462a m3503b(C0530e c0530e) {
        try {
            InputStream mo3920c = c0530e.m3953a().mo3920c("apktool.json");
            C0462a m3521a = C0462a.m3521a(mo3920c);
            mo3920c.close();
            return m3521a;
        } catch (C0529d | IOException | C2467b e2) {
            throw new C0461b("Bad \"apktool.json\" file!", e2);
        }
    }

    /* renamed from: a */
    public C0462a m3479a(File file, File file2) {
        return m3515d(new C0530e(file), file2);
    }

    /* renamed from: d */
    public C0462a m3515d(C0530e c0530e, File file) {
        this.f3276f.mo3984d(R.string.using_apktool, C3102bd.f18294ab, c0530e.getName());
        C0462a m3503b = m3503b(c0530e);
        this.f3272b.f3589j = m3503b.f3283d;
        this.f3272b.f3590k = m3503b.f3291l;
        this.f3272b.f3591l = m3503b.f3288i;
        this.f3272b.f3596q = m3503b.f3294o;
        this.f3272b.f3597r = m3503b.f3293n;
        this.f3273c.m3598a(m3503b.f3285f);
        this.f3273c.m3605b(m3503b.f3286g);
        this.f3273c.m3586a(m3503b.f3286g);
        this.f3273c.m3587a(m3503b.f3287h);
        this.f3273c.m3599a(m3503b.f3289j);
        this.f3273c.m3607b(m3503b.f3290k);
        if (m3503b.f3285f != null && m3503b.f3285f.get("minSdkVersion") != null) {
            this.f3275e = this.f3273c.m3580a(m3503b, m3503b.f3285f.get("minSdkVersion"));
        }
        if (file == null) {
            String str = m3503b.f3281b;
            if (str == null) {
                str = "out.apk";
            }
            file = new File(c0530e, str);
        }
        new File(c0530e, "build/apk").mkdirs();
        File file2 = new File(c0530e, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        File file3 = new File(c0530e, "AndroidManifest.xml.orig");
        m3490a((File) c0530e);
        m3510c(c0530e);
        m3506b((File) c0530e);
        m3466a(c0530e, file2, file3);
        m3483a(c0530e, m3503b.f3284e);
        m3513c((File) c0530e);
        m3516d((File) c0530e);
        C0543h c0543h = (C0543h) null;
        File file4 = new File(c0530e, "renamed.json");
        if (file4.exists() && file4.isFile()) {
            c0543h = new C0543h(c0530e);
            this.f3276f.mo3984d(R.string.text, "Reading map of renamed files...");
        }
        m3493a(c0530e, file, c0543h);
        m3492a(c0530e, file, m3503b, c0543h);
        if (file2.isFile() && file2.exists() && file3.isFile()) {
            try {
                if (new File(c0530e, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).delete()) {
                    long lastModified = file3.lastModified();
                    C3262u.m19637b(file3, file2);
                    C3262u.m19610a(file2, lastModified);
                }
            } catch (Exception e2) {
                throw new C0461b(e2.getMessage());
            }
        }
        this.f3276f.mo3984d(R.string.text, "Built apk...");
        return m3503b;
    }

    /* renamed from: a */
    private void m3466a(File file, File file2, File file3) {
        if (!new File(file, "resources.arsc").exists() && !this.f3276f.mo3981a() && file2.isFile() && file2.exists()) {
            try {
                if (file3.exists()) {
                    file3.delete();
                }
                long lastModified = file2.lastModified();
                C3262u.m19612a(file2, file3);
                C3262u.m19610a(file3, lastModified);
                C0517c.m3879a(file2, this.f3276f);
                C3262u.m19610a(file2, lastModified);
            } catch (Exception e2) {
                throw new C0461b(e2.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void m3490a(File file) {
        if (m3500a(file, "classes.dex") || m3502a(file, "smali", "classes.dex")) {
            return;
        }
        this.f3276f.mo3983c(R.string.text, "Could not find sources");
    }

    /* renamed from: c */
    public void m3510c(C0530e c0530e) {
        try {
            Iterator<Map.Entry<String, InterfaceC0528c>> it = c0530e.m3953a().mo3917b().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.startsWith("smali_")) {
                    String stringBuffer = new StringBuffer().append(key.substring(key.indexOf("_") + 1)).append(".dex").toString();
                    if (!m3500a(c0530e, stringBuffer) && !m3502a(c0530e, key, stringBuffer)) {
                        this.f3276f.mo3983c(R.string.text, "Could not find sources");
                    }
                }
            }
            File[] listFiles = c0530e.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.getName().endsWith(".dex") && !file.getName().equalsIgnoreCase("classes.dex")) {
                        m3500a(c0530e, file.getName());
                    }
                }
            }
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: b */
    public void m3506b(File file) {
        try {
            File file2 = new File(file, "additional_dex.json");
            File file3 = new File(file, "additional_dex");
            if (file2.isFile() && file3.isDirectory()) {
                C2466a c2466a = new C2466a(C3061a.m18332i(file2));
                for (int i = 0; i < c2466a.m15569a(); i++) {
                    String m15579f = c2466a.m15579f(i);
                    m3502a(file, new StringBuffer().append(new StringBuffer().append("additional_dex").append("/").toString()).append(m15579f.substring(0, m15579f.lastIndexOf(46))).toString(), m15579f);
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public boolean m3500a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists() || this.f3276f.mo3981a()) {
            return false;
        }
        File file3 = new File(file, new StringBuffer().append(new StringBuffer().append("build/apk").append("/").toString()).append(str).toString());
        if (!this.f3272b.f3581b && !m3474b(file2, file3)) {
            return true;
        }
        this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Copying ").append(file.toString()).toString()).append(" ").toString()).append(str).toString()).append(" file...").toString());
        try {
            C0536a.m3968a(new FileInputStream(file2), new FileOutputStream(file3));
            C3262u.m19610a(file3, file2.lastModified());
            return true;
        } catch (IOException e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public boolean m3502a(File file, String str, String str2) {
        C0530e c0530e = new C0530e(file, str);
        if (!c0530e.exists()) {
            return false;
        }
        File file2 = new File(file, new StringBuffer().append(new StringBuffer().append("build/apk").append("/").toString()).append(str2).toString());
        file2.getParentFile().mkdirs();
        if (!this.f3272b.f3581b) {
            this.f3276f.mo3984d(R.string.text, "Checking whether sources has changed...");
        }
        if (this.f3272b.f3581b || m3474b((File) c0530e, file2)) {
            this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Smaling ").append(str).toString()).append(" folder into ").toString()).append(str2).toString()).append("...").toString());
            file2.delete();
            C0519a.m3893a(c0530e, file2, this.f3275e, this.f3276f);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3501a(File file, String str, File file2, int i) {
        C0530e c0530e = new C0530e(file, str);
        if (!c0530e.exists()) {
            return false;
        }
        this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Smaling ").append(str).toString()).append(" folder into ").toString()).append(file2.getAbsolutePath()).toString()).append("...").toString());
        file2.delete();
        C0519a.m3893a(c0530e, file2, i, this.f3276f);
        return true;
    }

    /* renamed from: a */
    public void m3483a(C0530e c0530e, C0464c c0464c) {
        if (m3518d(c0530e) || m3499a((File) c0530e, c0464c) || m3509b(c0530e, c0464c)) {
            return;
        }
        this.f3276f.mo3983c(R.string.text, "Could not find resources");
    }

    /* renamed from: d */
    public boolean m3518d(C0530e c0530e) {
        try {
            if (!new File(c0530e, "resources.arsc").exists() || this.f3276f.mo3981a()) {
                return false;
            }
            File file = new File(c0530e, "build/apk");
            if (!this.f3272b.f3581b) {
                this.f3276f.mo3984d(R.string.text, "Checking whether resources has changed...");
            }
            if (!this.f3272b.f3581b && !m3470a(m3472a(f3265j, c0530e), m3472a(f3265j, file))) {
                return true;
            }
            this.f3276f.mo3984d(R.string.text, "Copying raw resources...");
            c0530e.m3953a().mo3914a(file, f3265j);
            return true;
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public boolean m3499a(File file, C0464c c0464c) {
        String str;
        boolean z;
        boolean z2 = false;
        try {
            if (!new File(file, "res").exists() || this.f3276f.mo3981a()) {
                return false;
            }
            if (!this.f3272b.f3581b) {
                this.f3276f.mo3984d(R.string.text, "Checking whether resources has changed...");
            }
            File file2 = new File(file, "build/apk");
            File file3 = new File(file2.getParent(), "resources.zip");
            if (this.f3272b.f3581b || m3470a(m3472a(f3267l, file), m3472a(f3265j, file2)) || (this.f3272b.m3888a() && !m3478e(file3))) {
                this.f3276f.mo3984d(R.string.text, "Building resources...");
                if (this.f3272b.f3583d) {
                    this.f3276f.mo3984d(R.string.text, "Setting \"android:debuggable\" attribute to \"true\" in AndroidManifest.xml");
                    if (this.f3272b.m3888a()) {
                        C0517c.m3881a(new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), "true", false);
                    } else {
                        C0517c.m3881a(new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), (String) null, true);
                    }
                }
                if (this.f3272b.f3594o) {
                    String m3876a = C0517c.m3876a(new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
                    if (m3876a == null) {
                        str = "network_security_config";
                        z = false;
                    } else {
                        str = m3876a;
                        z = true;
                    }
                    File file4 = new File(file, new StringBuffer().append(new StringBuffer().append("res/xml/").append(str).toString()).append(".xml").toString());
                    boolean exists = file4.exists();
                    if (exists && !this.f3272b.f3595p) {
                        this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Replacing existing Network Security Configuration: ").append(str).toString()).append(".xml!").toString());
                        file4.delete();
                        z2 = exists;
                    } else if (!exists || z) {
                        z2 = exists;
                    } else {
                        file4.delete();
                    }
                    if (!z2 || !this.f3272b.f3595p) {
                        C0462a m3503b = m3503b(new C0530e(file));
                        if (m3503b.f3285f != null && m3503b.f3285f.get("targetSdkVersion") != null && Integer.parseInt(m3503b.f3285f.get("targetSdkVersion")) < 24) {
                            this.f3276f.mo3983c(R.string.text, "Target SDK version is lower than 24! Network Security Configuration might be ignored!");
                        }
                        try {
                            C0517c.m3883b(file4);
                            C0517c.m3880a(new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), str);
                            this.f3276f.mo3984d(R.string.text, "Added permissive network security config in manifest");
                        } catch (Exception e2) {
                            this.f3276f.mo3979a(R.string.text, "Error adding permissive network security config in manifest");
                        }
                    }
                }
                File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                createTempFile.delete();
                file3.delete();
                File file5 = new File(file, "9patch");
                if (!file5.exists()) {
                    file5 = (File) null;
                }
                this.f3273c.m3594a(createTempFile, new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), new File(file, "res"), file5, (File) null, m3471a(c0464c));
                InterfaceC0528c m3953a = new C0530e(createTempFile).m3953a();
                try {
                    m3953a.mo3914a(file2, m3953a.mo3919b("res") ? f3265j : f3266k);
                } catch (C0529d e3) {
                    this.f3276f.mo3983c(R.string.text, e3.getMessage());
                }
                createTempFile.delete();
            }
            return true;
        } catch (C0522a e4) {
            e = e4;
            throw new C0461b(e);
        } catch (IOException e5) {
            e = e5;
            throw new C0461b(e);
        }
    }

    /* renamed from: e */
    public boolean m3520e(C0530e c0530e) {
        if (this.f3276f.mo3981a()) {
            return false;
        }
        try {
            File file = new File(c0530e, "build/apk");
            this.f3276f.mo3984d(R.string.text, "Copying raw AndroidManifest.xml...");
            c0530e.m3953a().mo3914a(file, f3268m);
            return true;
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: b */
    public boolean m3509b(C0530e c0530e, C0464c c0464c) {
        try {
            if (!new File(c0530e, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).exists() || this.f3276f.mo3981a()) {
                return false;
            }
            if (!this.f3272b.f3581b) {
                this.f3276f.mo3984d(R.string.text, "Checking whether resources has changed...");
            }
            File file = new File(c0530e, "build/apk");
            if (this.f3272b.f3581b || m3470a(m3472a(f3268m, c0530e), m3472a(f3268m, file))) {
                this.f3276f.mo3984d(R.string.text, "Building AndroidManifest.xml...");
                File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                createTempFile.delete();
                File file2 = new File(c0530e, "9patch");
                if (!file2.exists()) {
                    file2 = (File) null;
                }
                this.f3273c.m3594a(createTempFile, new File(c0530e, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME), (File) null, file2, (File) null, m3471a(c0464c));
                new C0530e(createTempFile).m3953a().mo3914a(file, f3268m);
                createTempFile.delete();
            }
            return true;
        } catch (C0461b e2) {
            this.f3276f.mo3979a(R.string.text, "Parse AndroidManifest.xml failed, treat it as raw file.");
            return m3520e(c0530e);
        } catch (C0529d e3) {
            e = e3;
            throw new C0461b(e);
        } catch (IOException e4) {
            e = e4;
            throw new C0461b(e);
        }
    }

    /* renamed from: c */
    public void m3513c(File file) {
        m3507b(file, "lib");
        m3507b(file, "libs");
        m3507b(file, "kotlin");
        m3507b(file, "META-INF/services");
    }

    /* renamed from: b */
    public void m3507b(File file, String str) {
        File file2 = new File(file, str);
        if (file2.exists() && !this.f3276f.mo3981a()) {
            File file3 = new File(file, new StringBuffer().append(new StringBuffer().append("build/apk").append("/").toString()).append(str).toString());
            if (this.f3272b.f3581b || m3474b(file2, file3)) {
                this.f3276f.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Copying libs... (/").append(str).toString()).append(")").toString());
                try {
                    C0542g.m3987a(file3);
                    C0542g.m3991a(file2, file3);
                } catch (C0522a e2) {
                    throw new C0461b(e2);
                }
            }
        }
    }

    /* renamed from: d */
    public void m3516d(File file) {
        if (this.f3272b.f3585f && !this.f3276f.mo3981a()) {
            File file2 = new File(file, "original");
            if (file2.exists()) {
                if (this.f3272b.f3587h || this.f3272b.f3586g || this.f3277g) {
                    try {
                        this.f3276f.mo3984d(R.string.text, "Copy original files...");
                        InterfaceC0528c m3953a = new C0530e(file2).m3953a();
                        if (m3953a.mo3916a(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME) && this.f3272b.f3587h && !this.f3277g) {
                            this.f3276f.mo3984d(R.string.text, "Copy AndroidManifest.xml...");
                            m3953a.mo3912a(new File(file, "build/apk"), AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                        }
                        if (m3953a.mo3916a(AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME) && (this.f3272b.f3586g || this.f3277g)) {
                            this.f3276f.mo3984d(R.string.text, "Copy stamp-cert-sha256...");
                            m3953a.mo3912a(new File(file, "build/apk"), AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME);
                        }
                        if (m3953a.mo3919b("META-INF")) {
                            if (this.f3272b.f3586g || this.f3277g) {
                                this.f3276f.mo3984d(R.string.text, "Copy META-INF...");
                                m3953a.mo3912a(new File(file, "build/apk"), "META-INF");
                            }
                        }
                    } catch (C0529d e2) {
                        throw new C0461b(e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m3492a(File file, File file2, C0462a c0462a, C0543h c0543h) {
        if (c0462a.f3292m == null || this.f3276f.mo3981a()) {
            return;
        }
        this.f3276f.mo3984d(R.string.text, "Copying unknown files/dir...");
        File file3 = new File(file2.getParent(), new StringBuffer().append(file2.getName()).append(".apktool_temp").toString());
        try {
            if (!file2.renameTo(file3)) {
                throw new C0461b("Unable to rename temporary file");
            }
            try {
                C2604w c2604w = new C2604w(file3);
                C3248b m19496a = C3248b.m19496a(new FileOutputStream(file2));
                m19496a.m16215a(C3102bd.f18315aw);
                m3468a(c2604w, m19496a);
                m3467a(file, m19496a, c0462a.f3292m, c0543h);
                c2604w.close();
                m19496a.close();
            } catch (C0522a | IOException e2) {
                throw new C0461b(e2);
            }
        } finally {
            file3.delete();
        }
    }

    /* renamed from: a */
    private void m3468a(C2604w c2604w, C3248b c3248b) {
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            C2602u c2602u = new C2602u(nextElement.getName());
            c2602u.setTime(nextElement.getTime());
            c2602u.setCrc(nextElement.getCrc());
            if (nextElement.getMethod() == 0) {
                c2602u.setMethod(0);
                c2602u.setSize(nextElement.getSize());
                c2602u.setCompressedSize(nextElement.getSize());
            } else {
                c2602u.setMethod(8);
                c2602u.setCompressedSize(-1L);
            }
            c3248b.mo16214a(c2602u);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    c3248b.write(bArr, 0, read);
                }
            }
            bufferedInputStream.close();
            c3248b.flush();
            c3248b.m16218b();
        }
    }

    /* renamed from: a */
    private void m3467a(File file, C3248b c3248b, Map<String, String> map, C0543h c0543h) {
        String str;
        File file2 = new File(file, "unknown");
        File file3 = new File(file, "build/apk");
        byte[] bArr = new byte[C3249i.m19500a()];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            File file4 = new File(file2, C0536a.m3966a(file2, entry.getKey()));
            if (file4.isFile()) {
                String key = entry.getKey();
                if (c0543h != null) {
                    str = c0543h.m4002d(new StringBuffer().append(new StringBuffer().append("unknown").append(File.separator).toString()).append(key).toString());
                } else {
                    str = (String) null;
                }
                String substring = str != null ? str.substring(f3264i.length() + 1) : key;
                if (C3262u.m19615a(new File(file3, key), key)) {
                    this.f3276f.mo3984d(R.string.text, new StringBuffer().append("Skipping a duplicate entry: ").append(substring).toString());
                } else {
                    C2602u c2602u = new C2602u(substring);
                    c2602u.setTime(file4.lastModified());
                    c2602u.setCrc(C3117bs.m19055a(file4));
                    if (Integer.parseInt(entry.getValue()) == 0) {
                        c2602u.setMethod(0);
                        c2602u.setSize(file4.length());
                        c2602u.setCompressedSize(file4.length());
                    } else {
                        c2602u.setMethod(8);
                        c2602u.setCompressedSize(-1L);
                    }
                    c3248b.mo16214a(c2602u);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file4), bArr.length);
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            c3248b.write(bArr, 0, read);
                        }
                    }
                    bufferedInputStream.close();
                    c3248b.flush();
                    c3248b.m16218b();
                }
            }
        }
    }

    /* renamed from: a */
    public void m3493a(File file, File file2, C0543h c0543h) {
        if (!this.f3276f.mo3981a()) {
            this.f3276f.mo3984d(R.string.text, "Building apk file...");
            if (file2.exists()) {
                file2.delete();
            } else {
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
            }
            File file3 = new File(file, "assets");
            if (!file3.exists()) {
                file3 = (File) null;
            }
            this.f3273c.m3593a(file2, new File(file, "build/apk"), file3, c0543h);
        }
    }

    /* renamed from: a */
    public boolean m3498a(C0495f c0495f) {
        for (C0492c c0492c : c0495f.m3710b()) {
            if (c0492c.m3678g() > 0 && c0492c.m3678g() < 64) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m3473b() {
        return C0521e.m3902a("application.version");
    }

    /* renamed from: a */
    private File[] m3471a(C0464c c0464c) {
        if (c0464c == null) {
            return (File[]) null;
        }
        List<Integer> list = c0464c.f3297a;
        if (list == null || list.isEmpty()) {
            return (File[]) null;
        }
        String str = c0464c.f3298b;
        File[] fileArr = new File[list.size()];
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            fileArr[i] = this.f3273c.m3584a(it.next().intValue(), str);
            i++;
        }
        return fileArr;
    }

    /* renamed from: b */
    private boolean m3474b(File file, File file2) {
        return !file2.exists() || C0536a.m3964a(file) > C0536a.m3964a(file2);
    }

    /* renamed from: e */
    private boolean m3478e(File file) {
        return file.exists();
    }

    /* renamed from: a */
    private boolean m3470a(File[] fileArr, File[] fileArr2) {
        for (File file : fileArr2) {
            if (!file.exists()) {
                return true;
            }
        }
        return C0536a.m3965a(fileArr) > C0536a.m3965a(fileArr2);
    }

    /* renamed from: a */
    private File[] m3472a(String[] strArr, File file) {
        File[] fileArr = new File[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fileArr[i] = new File(file, strArr[i]);
        }
        return fileArr;
    }
}
