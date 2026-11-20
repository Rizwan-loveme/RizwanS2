package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.security.KeyChain;
import android.util.Base64;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.C0578a;
import com.p065b.p111c.C1036a;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.logging.Level;
import org.p217b.p218a.p219a.C1887e;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: SignUtil.java */
/* renamed from: ru.maximoff.apktool.e.as */
/* loaded from: classes.dex */
public class C2917as {

    /* renamed from: a */
    private static Context f15381a;

    /* renamed from: b */
    private static boolean f15382b;

    /* renamed from: c */
    private static final String[] f15383c = {"JKS", KeyChain.EXTRA_PKCS12, "BKS"};

    /* renamed from: d */
    private static int f15384d = 0;

    /* renamed from: e */
    private static Object f15385e;

    /* renamed from: f */
    private PrivateKey f15386f;

    /* renamed from: g */
    private X509Certificate f15387g;

    /* compiled from: SignUtil.java */
    /* renamed from: ru.maximoff.apktool.e.as$a */
    public interface a {
        /* renamed from: a */
        void mo16440a(C2917as c2917as, boolean z);
    }

    /* renamed from: a */
    public static void m17314a(Context context, int i, a aVar) {
        boolean z;
        f15384d = 0;
        f15385e = (Object) null;
        f15382b = i == 0;
        f15381a = context;
        boolean z2 = i == 2;
        if (z2) {
            int m18905a = C3102bd.m18905a(context, "key_type", 0);
            String m18910a = C3102bd.m18910a(context, "key_path", "");
            String m18910a2 = C3102bd.m18910a(context, "cert_or_alias", "");
            String m18910a3 = C3102bd.m18910a(context, "store_pass", "");
            String m18910a4 = C3102bd.m18910a(context, "key_pass", "");
            try {
                if (m18905a == 3) {
                    z = m17319a(aVar, m18910a, m18910a2);
                } else {
                    z = m17317a(context, aVar, m18910a, m18905a, m18910a2, m18910a3, m18910a4);
                }
            } catch (Exception e2) {
                m17315a(context, m18910a);
                z = z2;
            }
        } else {
            z = z2;
        }
        if (z) {
            return;
        }
        try {
            if (m17319a(aVar, C3102bd.f18325h, C3102bd.f18326i)) {
            } else {
                throw new FileNotFoundException(new StringBuffer().append(C3102bd.f18325h).append(" not found!").toString());
            }
        } catch (Exception e3) {
            m17315a(context, C3102bd.f18325h);
        }
    }

    /* renamed from: a */
    private static void m17315a(Context context, String str) {
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o == null) {
            return;
        }
        m16615o.runOnUiThread(new Runnable(context, str) { // from class: ru.maximoff.apktool.e.as.1

            /* renamed from: a */
            private final Context f15388a;

            /* renamed from: b */
            private final String f15389b;

            {
                this.f15388a = context;
                this.f15389b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                new DialogInterfaceC0070b.a(this.f15388a).m427a(this.f15388a.getString(R.string.error)).m436b(this.f15388a.getString(R.string.load_signature_file_fail, this.f15389b)).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m438b().show();
            }
        });
    }

    /* renamed from: a */
    private static void m17313a(int i, Object obj) {
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o == null) {
            return;
        }
        m16615o.runOnUiThread(new Runnable(m16615o, i, obj) { // from class: ru.maximoff.apktool.e.as.2

            /* renamed from: a */
            private final MainActivity f15390a;

            /* renamed from: b */
            private final int f15391b;

            /* renamed from: c */
            private final Object f15392c;

            {
                this.f15390a = m16615o;
                this.f15391b = i;
                this.f15392c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19000a(this.f15390a, this.f15391b, this.f15392c);
            }
        });
    }

    /* renamed from: a */
    private static boolean m17317a(Context context, a aVar, String str, int i, String str2, String str3, String str4) {
        if (!m17318a(str)) {
            return false;
        }
        KeyStore keyStore = KeyStore.getInstance(f15383c[i]);
        if (str3.isEmpty()) {
            f15384d = R.string.text;
            f15385e = context.getString(R.string.signature_pass_not_set);
            if (!m17319a(aVar, C3102bd.f18325h, C3102bd.f18326i)) {
                throw new FileNotFoundException(new StringBuffer().append(C3102bd.f18325h).append(" not found!").toString());
            }
        } else {
            char[] charArray = str3.toCharArray();
            m17316a(aVar, keyStore, str, str2, charArray, str4.isEmpty() ? charArray : str4.toCharArray());
        }
        return true;
    }

    /* renamed from: a */
    private static void m17316a(a aVar, KeyStore keyStore, String str, String str2, char[] cArr, char[] cArr2) {
        keyStore.load(new FileInputStream(str), cArr);
        if (str2.isEmpty() || !keyStore.containsAlias(str2)) {
            str2 = keyStore.aliases().nextElement();
        }
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(str2, cArr2);
        X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
        C2917as c2917as = new C2917as();
        c2917as.f15386f = privateKey;
        c2917as.f15387g = x509Certificate;
        aVar.mo16440a(c2917as, f15382b);
    }

    /* renamed from: a */
    private static boolean m17319a(a aVar, String str, String str2) {
        if (!m17318a(str) || !m17318a(str2)) {
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        byte[] m13984b = C1887e.m13984b(fileInputStream);
        fileInputStream.close();
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(fileInputStream2);
        fileInputStream2.close();
        PrivateKey generatePrivate = KeyFactory.getInstance(x509Certificate.getPublicKey().getAlgorithm()).generatePrivate(new PKCS8EncodedKeySpec(m13984b));
        C2917as c2917as = new C2917as();
        c2917as.f15386f = generatePrivate;
        c2917as.f15387g = x509Certificate;
        aVar.mo16440a(c2917as, f15382b);
        return true;
    }

    /* renamed from: a */
    private static boolean m17318a(String str) {
        if (new File(str).exists()) {
            return true;
        }
        f15384d = R.string.signature_file_missing;
        f15385e = str;
        return false;
    }

    C2917as() {
    }

    /* renamed from: a */
    public boolean m17321a(File file, File file2, int i, InterfaceC0541f interfaceC0541f) {
        if (interfaceC0541f.mo3981a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return m17323b(file, file2, i, interfaceC0541f);
        }
        return m17325c(file, file2, i, interfaceC0541f);
    }

    /* renamed from: a */
    public boolean m17320a(File file, File file2, int i) {
        return Build.VERSION.SDK_INT >= 21 ? m17322b(file, file2, i) : m17324c(file, file2, i);
    }

    /* renamed from: b */
    public boolean m17323b(File file, File file2, int i, InterfaceC0541f interfaceC0541f) {
        boolean m18925a;
        boolean m18925a2;
        boolean m18925a3;
        boolean m18925a4;
        if (f15384d > 0) {
            interfaceC0541f.mo3983c(f15384d, f15385e);
        }
        if (C3102bd.f18317ay != null && C3102bd.f18317ay.length == 4) {
            m18925a = C3102bd.f18317ay[0];
            m18925a2 = C3102bd.f18317ay[1];
            m18925a3 = C3102bd.f18317ay[2];
            m18925a4 = C3102bd.f18317ay[3];
        } else {
            m18925a = C3102bd.m18925a(f15381a, "use_v1_sign", true);
            m18925a2 = C3102bd.m18925a(f15381a, "use_v2_sign", true);
            m18925a3 = C3102bd.m18925a(f15381a, "use_v3_sign", false);
            m18925a4 = C3102bd.m18925a(f15381a, "use_v4_sign", false);
        }
        ArrayList arrayList = new ArrayList();
        if (!m18925a && !m18925a2 && !m18925a3) {
            C3102bd.m18938b(f15381a, "use_v1_sign", true);
            C3102bd.m18938b(f15381a, "use_v2_sign", true);
            m18925a2 = true;
            m18925a = true;
        }
        if (m18925a) {
            arrayList.add("V1");
        }
        if (m18925a2) {
            arrayList.add("V2");
        }
        if (m18925a3) {
            arrayList.add("V3");
        }
        if (m18925a4) {
            arrayList.add("V4");
        }
        String m18538a = C3080al.m18538a(arrayList, " + ");
        try {
            C0578a.a aVar = new C0578a.a(AbstractC1208w.m10130a(new C0578a.c.a(C3102bd.m18910a(f15381a, "v1_cert_name", KeyChain.EXTRA_CERTIFICATE), this.f15386f, AbstractC1208w.m10130a(this.f15387g)).m5781a()));
            aVar.m5759a(file);
            aVar.m5763b(file2);
            aVar.m5760a(C3102bd.m18910a(f15381a, "created_cert_name", "Apktool M"));
            if (m18925a) {
                i = Math.min(14, i);
            }
            aVar.m5758a(i);
            aVar.m5761a(m18925a);
            aVar.m5764b(m18925a2);
            aVar.m5766c(m18925a3);
            aVar.m5767d(m18925a4);
            if (m18925a4) {
                File file3 = new File(new StringBuffer().append(file2.getAbsolutePath()).append(".idsig").toString());
                if (file3.isFile()) {
                    file3.delete();
                }
                aVar.m5765c(file3);
            }
            C0578a m5762a = aVar.m5762a();
            interfaceC0541f.mo3984d(R.string.text, String.format(new StringBuffer().append(new StringBuffer().append("Sign File (").append(m18538a).toString()).append("): %s").toString(), file));
            m5762a.m5756a();
            interfaceC0541f.mo3984d(R.string.sign_done, file2);
            return true;
        } catch (Exception e2) {
            interfaceC0541f.mo3980a(Level.WARNING, new StringBuffer().append(new StringBuffer().append("Signature (").append(m18538a).toString()).append(") failed! ").toString(), e2);
            return false;
        }
    }

    /* renamed from: b */
    public boolean m17322b(File file, File file2, int i) {
        boolean m18925a;
        boolean m18925a2;
        boolean m18925a3;
        boolean m18925a4;
        if (f15384d > 0) {
            m17313a(f15384d, f15385e);
        }
        if (C3102bd.f18317ay != null && C3102bd.f18317ay.length == 4) {
            m18925a = C3102bd.f18317ay[0];
            m18925a2 = C3102bd.f18317ay[1];
            m18925a3 = C3102bd.f18317ay[2];
            m18925a4 = C3102bd.f18317ay[3];
        } else {
            m18925a = C3102bd.m18925a(f15381a, "use_v1_sign", true);
            m18925a2 = C3102bd.m18925a(f15381a, "use_v2_sign", true);
            m18925a3 = C3102bd.m18925a(f15381a, "use_v3_sign", false);
            m18925a4 = C3102bd.m18925a(f15381a, "use_v4_sign", false);
        }
        if (!m18925a && !m18925a2 && !m18925a3) {
            C3102bd.m18938b(f15381a, "use_v1_sign", true);
            C3102bd.m18938b(f15381a, "use_v2_sign", true);
            m18925a2 = true;
            m18925a = true;
        }
        C0578a.a aVar = new C0578a.a(AbstractC1208w.m10130a(new C0578a.c.a(C3102bd.m18910a(f15381a, "v1_cert_name", KeyChain.EXTRA_CERTIFICATE), this.f15386f, AbstractC1208w.m10130a(this.f15387g)).m5781a()));
        aVar.m5759a(file);
        aVar.m5763b(file2);
        aVar.m5760a(C3102bd.m18910a(f15381a, "created_cert_name", "Apktool M"));
        if (m18925a) {
            i = Math.min(14, i);
        }
        aVar.m5758a(i);
        aVar.m5761a(m18925a);
        aVar.m5764b(m18925a2);
        aVar.m5766c(m18925a3);
        aVar.m5767d(m18925a4);
        if (m18925a4) {
            File file3 = new File(new StringBuffer().append(file2.getAbsolutePath()).append(".idsig").toString());
            if (file3.isFile()) {
                file3.delete();
            }
            aVar.m5765c(file3);
        }
        try {
            aVar.m5762a().m5756a();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    public boolean m17325c(File file, File file2, int i, InterfaceC0541f interfaceC0541f) {
        boolean m18925a;
        boolean m18925a2;
        if (f15384d > 0) {
            interfaceC0541f.mo3983c(f15384d, f15385e);
        }
        if (C3102bd.f18317ay != null && C3102bd.f18317ay.length == 2) {
            m18925a = C3102bd.f18317ay[0];
            m18925a2 = C3102bd.f18317ay[1];
        } else {
            m18925a = C3102bd.m18925a(f15381a, "use_v1_sign", true);
            m18925a2 = C3102bd.m18925a(f15381a, "use_v2_sign", true);
        }
        ArrayList arrayList = new ArrayList();
        if (!m18925a && !m18925a2) {
            C3102bd.m18938b(f15381a, "use_v1_sign", true);
            C3102bd.m18938b(f15381a, "use_v2_sign", true);
            m18925a2 = true;
            m18925a = true;
        }
        if (m18925a) {
            arrayList.add("V1");
        }
        if (m18925a2) {
            arrayList.add("V2");
        }
        String m18538a = C3080al.m18538a(arrayList, " + ");
        try {
            C1036a.a aVar = new C1036a.a(AbstractC1208w.m10130a(new C1036a.c(C3102bd.m18910a(f15381a, "v1_cert_name", KeyChain.EXTRA_CERTIFICATE), this.f15386f, AbstractC1208w.m10130a(this.f15387g)).m8634a()));
            aVar.m8614a(file);
            aVar.m8618b(file2);
            aVar.m8615a(C3102bd.m18910a(f15381a, "created_cert_name", "Apktool M"));
            if (m18925a) {
                i = Math.min(14, i);
            }
            aVar.m8613a(i);
            aVar.m8616a(m18925a);
            aVar.m8619b(m18925a2);
            C1036a m8617a = aVar.m8617a();
            interfaceC0541f.mo3984d(R.string.text, String.format(new StringBuffer().append(new StringBuffer().append("Sign File (").append(m18538a).toString()).append("): %s").toString(), file));
            m8617a.m8611b();
            interfaceC0541f.mo3984d(R.string.sign_done, file2);
            return true;
        } catch (Exception e2) {
            interfaceC0541f.mo3980a(Level.WARNING, new StringBuffer().append(new StringBuffer().append("Signature (").append(m18538a).toString()).append(") failed! ").toString(), e2);
            return false;
        }
    }

    /* renamed from: c */
    public boolean m17324c(File file, File file2, int i) {
        boolean m18925a;
        boolean m18925a2;
        if (f15384d > 0) {
            m17313a(f15384d, f15385e);
        }
        if (C3102bd.f18317ay != null && C3102bd.f18317ay.length == 2) {
            m18925a = C3102bd.f18317ay[0];
            m18925a2 = C3102bd.f18317ay[1];
        } else {
            m18925a = C3102bd.m18925a(f15381a, "use_v1_sign", true);
            m18925a2 = C3102bd.m18925a(f15381a, "use_v2_sign", true);
        }
        if (!m18925a && !m18925a2) {
            C3102bd.m18938b(f15381a, "use_v1_sign", true);
            C3102bd.m18938b(f15381a, "use_v2_sign", true);
            m18925a2 = true;
            m18925a = true;
        }
        C1036a.a aVar = new C1036a.a(AbstractC1208w.m10130a(new C1036a.c(C3102bd.m18910a(f15381a, "v1_cert_name", KeyChain.EXTRA_CERTIFICATE), this.f15386f, AbstractC1208w.m10130a(this.f15387g)).m8634a()));
        aVar.m8614a(file);
        aVar.m8618b(file2);
        aVar.m8615a(C3102bd.m18910a(f15381a, "created_cert_name", "Apktool M"));
        if (m18925a) {
            i = Math.min(14, i);
        }
        aVar.m8613a(i);
        aVar.m8616a(m18925a);
        aVar.m8619b(m18925a2);
        try {
            aVar.m8617a().m8611b();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static File m17310a(Context context, File file, String str, String str2, String str3, int i) {
        f15381a = context;
        String[] m19641b = C3262u.m19641b(file.getName());
        File m17311a = m17311a(file, new StringBuffer().append(new StringBuffer().append(m19641b[0]).append(".").toString()).append(str).toString(), ".pk8");
        File m17311a2 = m17311a(file, new StringBuffer().append(new StringBuffer().append(m19641b[0]).append(".").toString()).append(str).toString(), ".x509.pem");
        if (m17311a == null || m17311a2 == null) {
            throw new Exception("Failed to create files!");
        }
        KeyStore keyStore = KeyStore.getInstance(f15383c[i]);
        keyStore.load(new FileInputStream(file), str2.toCharArray());
        FileOutputStream fileOutputStream = new FileOutputStream(m17311a);
        fileOutputStream.write(keyStore.getKey(str, str3.toCharArray()).getEncoded());
        fileOutputStream.flush();
        fileOutputStream.close();
        C3061a.m18319b(m17311a2, "-----BEGIN CERTIFICATE-----\n" + m17312a(keyStore.getCertificate(str).getEncoded()) + "-----END CERTIFICATE-----\n");
        return m17311a.getParentFile();
    }

    /* renamed from: a */
    private static String m17312a(byte[] bArr) {
        String replaceAll = Base64.encodeToString(bArr, 2).replaceAll("(.{64})", "$1\n");
        if (!replaceAll.endsWith("\n")) {
            return new StringBuffer().append(replaceAll).append("\n").toString();
        }
        return replaceAll;
    }

    /* renamed from: a */
    private static File m17311a(File file, String str, String str2) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(f15381a, file)) || C3102bd.m18925a(f15381a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                return (File) null;
            }
            if (!file2.isDirectory()) {
                return (File) null;
            }
        }
        if (str == null) {
            str = file.getName();
        }
        return new File(parent, C3262u.m19566a(f15381a, parent, str, str2, 0));
    }
}
