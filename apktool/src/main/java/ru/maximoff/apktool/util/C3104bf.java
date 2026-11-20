package ru.maximoff.apktool.util;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import com.p065b.p066a.C0675d;
import com.p065b.p111c.C1066c;
import com.srizwan.apktool.R;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;

/* compiled from: SignInfo.java */
/* renamed from: ru.maximoff.apktool.util.bf */
/* loaded from: classes.dex */
public class C3104bf {

    /* renamed from: a */
    private Context f18371a;

    /* renamed from: b */
    private String[] f18372b;

    /* renamed from: c */
    private String[] f18373c;

    /* renamed from: d */
    private List<String> f18374d = new ArrayList();

    /* renamed from: e */
    private boolean f18375e;

    /* renamed from: f */
    private boolean f18376f;

    /* renamed from: g */
    private boolean f18377g;

    public C3104bf(Context context) {
        this.f18371a = context;
        this.f18372b = context.getResources().getStringArray(R.array.keys);
        this.f18373c = context.getResources().getStringArray(R.array.keys_hash);
        if (this.f18372b == null || this.f18373c == null || this.f18372b.length != this.f18373c.length) {
            this.f18372b = new String[0];
            this.f18373c = new String[0];
        }
        this.f18375e = C3102bd.m18925a(context, "checksum_upper", false);
        this.f18376f = C3102bd.m18925a(context, "checksum_separate", false);
        this.f18377g = C3102bd.m18925a(context, "sign_priority", true);
    }

    /* renamed from: a */
    public boolean m18961a(File file, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String m18957a;
        List<X509Certificate> m8938b;
        String lowerCase;
        String lowerCase2;
        if (!file.exists() || !file.canRead()) {
            abstractAsyncTaskC2898a.m17069e(R.string.err_not_exists, file.getAbsolutePath());
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            C0675d.b bVar = new C0675d.b(file);
            bVar.m6363b(21);
            bVar.m6360a(Integer.MAX_VALUE);
            File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append(".idsig").toString());
            if (file2.isFile()) {
                bVar.m6361a(file2);
            }
            C0675d.f m6353a = bVar.m6362a().m6353a();
            if (m6353a.m6379a()) {
                Iterator<C0675d.f.b> it = m6353a.m6383d().iterator();
                while (it.hasNext()) {
                    Iterator<C0675d.e> it2 = it.next().m6401c().iterator();
                    while (it2.hasNext()) {
                        abstractAsyncTaskC2898a.mo3983c(R.string.text, new StringBuffer().append("V1 - ").append(it2.next().toString()).toString());
                    }
                }
                Iterator<C0675d.f.c> it3 = m6353a.m6384e().iterator();
                while (it3.hasNext()) {
                    Iterator<C0675d.e> it4 = it3.next().m6410d().iterator();
                    while (it4.hasNext()) {
                        abstractAsyncTaskC2898a.mo3983c(R.string.text, new StringBuffer().append("V2 - ").append(it4.next().toString()).toString());
                    }
                }
                Iterator<C0675d.f.d> it5 = m6353a.m6386g().iterator();
                while (it5.hasNext()) {
                    Iterator<C0675d.e> it6 = it5.next().m6417d().iterator();
                    while (it6.hasNext()) {
                        abstractAsyncTaskC2898a.mo3983c(R.string.text, new StringBuffer().append("V3 - ").append(it6.next().toString()).toString());
                    }
                }
                Iterator<C0675d.f.d> it7 = m6353a.m6385f().iterator();
                while (it7.hasNext()) {
                    Iterator<C0675d.e> it8 = it7.next().m6417d().iterator();
                    while (it8.hasNext()) {
                        abstractAsyncTaskC2898a.mo3983c(R.string.text, new StringBuffer().append("V3.1 - ").append(it8.next().toString()).toString());
                    }
                }
                Iterator<C0675d.f.e> it9 = m6353a.m6387h().iterator();
                while (it9.hasNext()) {
                    Iterator<C0675d.e> it10 = it9.next().m6421b().iterator();
                    while (it10.hasNext()) {
                        abstractAsyncTaskC2898a.mo3983c(R.string.text, new StringBuffer().append("V4 - ").append(it10.next().toString()).toString());
                    }
                }
            }
            m18957a = m18956a(m6353a);
            m8938b = m6353a.m6380b();
        } else {
            C1066c.a aVar = new C1066c.a(file);
            aVar.m8920b(21);
            aVar.m8918a(Integer.MAX_VALUE);
            C1066c.e m8917a = aVar.m8919a().m8917a();
            m18957a = m18957a(m8917a);
            m8938b = m8917a.m8938b();
        }
        String absolutePath = file.getAbsolutePath();
        try {
            Certificate[] certificateArr = (X509Certificate[]) m8938b.toArray(new X509Certificate[m8938b.size()]);
            Certificate[] m18970a = C3105bg.m18970a(absolutePath);
            if (certificateArr == null || certificateArr.length == 0) {
                certificateArr = C3105bg.m18969a(this.f18371a, absolutePath);
            }
            if (m18970a != null && m18970a.length > 0) {
                if (m18957a == null || m18957a.isEmpty()) {
                    m18957a = "V1";
                } else if (m18957a.startsWith("V") && !m18957a.startsWith("V1")) {
                    m18957a = new StringBuffer().append("V1 + ").append(m18957a).toString();
                }
                if (this.f18377g) {
                    certificateArr = (Certificate[]) Arrays.copyOf(m18970a, m18970a.length);
                }
            }
            Certificate[] certificateArr2 = ((certificateArr == null || certificateArr.length == 0) && m18970a != null && m18970a.length > 0) ? (Certificate[]) Arrays.copyOf(m18970a, m18970a.length) : certificateArr;
            if (certificateArr2 != null && certificateArr2.length > 0) {
                if (m18957a != null) {
                    abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    abstractAsyncTaskC2898a.m17069e(R.string.signature_scheme, m18957a);
                }
                DateFormat dateInstance = DateFormat.getDateInstance(2, Locale.getDefault());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.write(certificateArr2.length);
                for (int i = 0; i < certificateArr2.length; i++) {
                    Certificate certificate = certificateArr2[i];
                    byte[] encoded = certificate.getEncoded();
                    dataOutputStream.writeInt(encoded.length);
                    dataOutputStream.write(encoded);
                    long m18963a = C3105bg.m18963a(encoded);
                    int i2 = i + 1;
                    String type = certificate.getType();
                    String str = "";
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f18373c.length) {
                            break;
                        }
                        if (String.valueOf(m18963a).equals(this.f18373c[i3])) {
                            str = new StringBuffer().append("").append(new StringBuffer().append(new StringBuffer().append(" (").append(this.f18372b[i3]).toString()).append(")").toString()).toString();
                            break;
                        }
                        i3++;
                    }
                    if (str.isEmpty()) {
                        if (m18963a == 1102846014) {
                            str = new StringBuffer().append(str).append(" (Maximoff)").toString();
                        } else if (m18963a == 2991616040L) {
                            str = new StringBuffer().append(str).append(" (Идите Лесом)").toString();
                        } else if (m18963a == 1771785738) {
                            str = new StringBuffer().append(str).append(" (GhostRider)").toString();
                        } else if (m18963a == 1500617967) {
                            str = new StringBuffer().append(str).append(" (RBMods)").toString();
                        } else if (m18963a == 1497745553) {
                            str = new StringBuffer().append(str).append(" (Kirlif')").toString();
                        } else if (m18963a == 2183944091L) {
                            str = new StringBuffer().append(str).append(" (Balatan)").toString();
                        } else if (m18963a == 820088916) {
                            str = new StringBuffer().append(str).append(" (Alex.Strannik)").toString();
                        } else if (m18963a == 1786796535) {
                            str = new StringBuffer().append(str).append(" (dhwh)").toString();
                        } else if (m18963a == 3806942848L) {
                            str = new StringBuffer().append(str).append(" (ThIsLinked)").toString();
                        }
                    }
                    if (i > 0) {
                        abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                        abstractAsyncTaskC2898a.m17069e(R.string.text, "------------------------------");
                    }
                    abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    abstractAsyncTaskC2898a.m17069e(R.string.cert_no, new Integer(i2), str);
                    abstractAsyncTaskC2898a.m17069e(R.string.cert_type, type);
                    if (type.equals("X.509")) {
                        X509Certificate x509Certificate = (X509Certificate) certificate;
                        abstractAsyncTaskC2898a.m17069e(R.string.cert_version, new Integer(x509Certificate.getVersion()));
                        abstractAsyncTaskC2898a.m17069e(R.string.cert_sn, String.valueOf(x509Certificate.getSerialNumber()));
                        Object name = x509Certificate.getSubjectDN().getName();
                        String name2 = x509Certificate.getIssuerDN().getName();
                        abstractAsyncTaskC2898a.m17069e(R.string.cert_owner, name);
                        if (name2.equals(name)) {
                            name2 = abstractAsyncTaskC2898a.m17075i().getString(R.string.cert_by_owner);
                        }
                        abstractAsyncTaskC2898a.m17069e(R.string.cert_issuer, name2);
                        abstractAsyncTaskC2898a.m17069e(R.string.cert_validity, dateInstance.format(x509Certificate.getNotBefore()), dateInstance.format(x509Certificate.getNotAfter()));
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_algorithm, x509Certificate.getSigAlgName());
                        abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    }
                    String hexString = Integer.toHexString(certificate.hashCode());
                    if (this.f18375e) {
                        lowerCase = hexString.toUpperCase();
                    } else {
                        lowerCase = hexString.toLowerCase();
                    }
                    String valueOf = String.valueOf(certificate.hashCode());
                    abstractAsyncTaskC2898a.m17069e(R.string.hash_code, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(lowerCase).append(" (").toString()).append(valueOf).toString()).append(")").toString());
                    this.f18374d.add(new StringBuffer().append("0x").append(lowerCase).toString());
                    this.f18374d.add(valueOf);
                    String hexString2 = Long.toHexString(m18963a);
                    if (this.f18375e) {
                        lowerCase2 = hexString2.toUpperCase();
                    } else {
                        lowerCase2 = hexString2.toLowerCase();
                    }
                    String m19017b = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_MD5));
                    String m19017b2 = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_SHA1));
                    String m19017b3 = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_SHA224));
                    String m19017b4 = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_SHA256));
                    String m19017b5 = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_SHA384));
                    String m19017b6 = C3112bn.m19017b((CharSequence) m18958a(encoded, KeyProperties.DIGEST_SHA512));
                    this.f18374d.add(lowerCase2);
                    this.f18374d.add(m19017b);
                    this.f18374d.add(m19017b2);
                    this.f18374d.add(m19017b3);
                    this.f18374d.add(m19017b4);
                    this.f18374d.add(m19017b5);
                    this.f18374d.add(m19017b6);
                    Object str2 = new String(m18959a(encoded));
                    abstractAsyncTaskC2898a.m17069e(R.string.sign_crc32, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(lowerCase2).append(" (").toString()).append(m18963a).toString()).append(")").toString());
                    if (!m19017b.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_md5, m19017b);
                    }
                    if (!m19017b2.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_sha1, m19017b2);
                    }
                    if (!m19017b3.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_sha224, m19017b3);
                    }
                    if (!m19017b4.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_sha256, m19017b4);
                    }
                    if (!m19017b5.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_sha384, m19017b5);
                    }
                    if (!m19017b6.isEmpty()) {
                        abstractAsyncTaskC2898a.m17069e(R.string.sign_sha512, m19017b6);
                    }
                    abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    abstractAsyncTaskC2898a.m17069e(R.string.base64_cert, Base64.encodeToString(encoded, 2));
                    abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    abstractAsyncTaskC2898a.m17069e(R.string.sign_bits, str2);
                    abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                    abstractAsyncTaskC2898a.m17069e(R.string.public_key, certificate.getPublicKey().toString());
                }
                abstractAsyncTaskC2898a.m17069e(R.string.text, "");
                abstractAsyncTaskC2898a.m17069e(R.string.base64_sign, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                try {
                    dataOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            }
            abstractAsyncTaskC2898a.mo3979a(R.string.err_no_certs2, (Object) null);
            return false;
        } catch (Exception e3) {
            abstractAsyncTaskC2898a.mo3979a(R.string.err_encex, e3.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public List<String> m18960a() {
        return this.f18374d;
    }

    /* renamed from: a */
    private char[] m18959a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            int i2 = (b2 >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i3 = b2 & 15;
            cArr[(i * 2) + 1] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
        }
        return cArr;
    }

    /* renamed from: a */
    private String m18958a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            String str2 = new String(m18959a(messageDigest.digest()));
            if (this.f18376f) {
                str2 = str2.replaceAll("..(?!$)", "$0:");
            }
            if (this.f18375e) {
                return str2.toUpperCase();
            }
            return str2.toLowerCase();
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: a */
    private String m18956a(C0675d.f fVar) {
        try {
            ArrayList arrayList = new ArrayList();
            if (fVar.m6388i()) {
                arrayList.add("V1");
            }
            if (fVar.m6389j()) {
                arrayList.add("V2");
            }
            if (fVar.m6391l()) {
                arrayList.add("V3");
            }
            if (fVar.m6390k()) {
                arrayList.add("V3.1");
            }
            if (fVar.m6392m()) {
                arrayList.add("V4");
            }
            if (!arrayList.isEmpty()) {
                return C3080al.m18538a(arrayList, " + ");
            }
        } catch (Exception e2) {
        }
        return this.f18371a.getString(R.string.verify_fail).toLowerCase();
    }

    /* renamed from: a */
    private String m18957a(C1066c.e eVar) {
        try {
            ArrayList arrayList = new ArrayList();
            if (eVar.m8941e()) {
                arrayList.add("V1");
            }
            if (eVar.m8942f()) {
                arrayList.add("V2");
            }
            if (!arrayList.isEmpty()) {
                return C3080al.m18538a(arrayList, " + ");
            }
        } catch (Exception e2) {
        }
        return this.f18371a.getString(R.string.verify_fail).toLowerCase();
    }
}
