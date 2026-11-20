package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.p006pm.Signature;
import android.os.Build;
import com.p065b.p066a.C0675d;
import com.p065b.p111c.C1066c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.zip.CRC32;
import org.p217b.p218a.p219a.C1887e;
import p000a.p001a.C0003d;
import p000a.p001a.InterfaceC0004e;
import p000a.p002b.p003a.C0005a;
import p000a.p002b.p003a.C0011b;
import p000a.p002b.p003a.p004a.C0006a;
import p000a.p002b.p003a.p004a.C0009d;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: SignatureUtils.java */
/* renamed from: ru.maximoff.apktool.util.bg */
/* loaded from: classes.dex */
public class C3105bg {
    /* renamed from: a */
    public static Certificate[] m18970a(String str) {
        InputStream inputStream;
        ArrayList arrayList = new ArrayList();
        try {
            C2604w c2604w = new C2604w(str);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                C2602u nextElement = m16163b.nextElement();
                String name = nextElement.getName();
                if (!nextElement.isDirectory() && name.toUpperCase().matches("^META-INF/.+\\.(RSA|DSA|EC)$")) {
                    InputStream inputStream2 = (InputStream) null;
                    try {
                        inputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                    } catch (CertificateException e2) {
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                    }
                    try {
                        arrayList.add((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(C1887e.m13984b(inputStream))));
                    } catch (CertificateException e3) {
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        C1887e.m13970a(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C1887e.m13970a(inputStream);
                        throw th;
                    }
                    C1887e.m13970a(inputStream);
                }
            }
            c2604w.close();
        } catch (Error e4) {
        } catch (Exception e5) {
        }
        return (Certificate[]) arrayList.toArray(new Certificate[arrayList.size()]);
    }

    /* renamed from: a */
    public static Certificate[] m18969a(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        ArrayList arrayList = new ArrayList();
        try {
            for (Signature signature : context.getPackageManager().getPackageArchiveInfo(str, 64).signatures) {
                InputStream inputStream3 = (InputStream) null;
                try {
                    inputStream2 = new ByteArrayInputStream(signature.toByteArray());
                } catch (CertificateException e2) {
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream3;
                }
                try {
                    arrayList.add((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(inputStream2));
                } catch (CertificateException e3) {
                    inputStream3 = inputStream2;
                    inputStream2 = inputStream3;
                    C1887e.m13970a(inputStream2);
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    C1887e.m13970a(inputStream);
                    throw th;
                }
                C1887e.m13970a(inputStream2);
            }
        } catch (Error e4) {
        } catch (Exception e5) {
        }
        return (Certificate[]) arrayList.toArray(new Certificate[arrayList.size()]);
    }

    /* renamed from: b */
    public static HashSet<Long> m18972b(Context context, String str) {
        try {
            return m18973c(context, context.getPackageManager().getPackageInfo(str, 0).applicationInfo.sourceDir);
        } catch (Error | Exception e2) {
            return new HashSet<>();
        }
    }

    /* renamed from: c */
    public static HashSet<Long> m18973c(Context context, String str) {
        return m18965a(context, new File(str));
    }

    /* renamed from: a */
    public static HashSet<Long> m18965a(Context context, File file) {
        List<X509Certificate> m8938b;
        try {
            HashSet<Long> hashSet = new HashSet<>();
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
            if (certificateArr == null || certificateArr.length == 0) {
                certificateArr = m18969a(context, file.getAbsolutePath());
            }
            for (Certificate certificate : certificateArr) {
                long m18963a = m18963a(certificate.getEncoded());
                if (m18963a != 0 && !hashSet.contains(new Long(m18963a))) {
                    hashSet.add(new Long(m18963a));
                }
            }
            for (Certificate certificate2 : m18970a(file.getAbsolutePath())) {
                long m18963a2 = m18963a(certificate2.getEncoded());
                if (m18963a2 != 0 && !hashSet.contains(new Long(m18963a2))) {
                    hashSet.add(new Long(m18963a2));
                }
            }
            return hashSet;
        } catch (Error | Exception e2) {
            return new HashSet<>();
        }
    }

    /* renamed from: a */
    public static void m18966a(InterfaceC0008c interfaceC0008c, File file) {
        if (interfaceC0008c != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                interfaceC0008c.mo31e();
                interfaceC0008c.mo27a(fileOutputStream, interfaceC0008c.mo29c());
                C1887e.m13972a((OutputStream) fileOutputStream);
            } catch (Error e2) {
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC0008c m18964a(File file) {
        try {
            InterfaceC0004e m20a = C0003d.m20a(file, "r");
            C0011b c0011b = new C0011b(m20a);
            if (c0011b.m50i()) {
                long m46e = c0011b.m46e();
                return C0009d.m35a(m20a, m46e, c0011b.m47f() - m46e).mo28b();
            }
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return (InterfaceC0008c) null;
    }

    /* renamed from: b */
    public static InterfaceC0008c m18971b(File file) {
        try {
            return C0009d.m35a(C0003d.m20a(file, "r"), 0L, file.length()).mo28b();
        } catch (Error | Exception e2) {
            return (InterfaceC0008c) null;
        }
    }

    /* renamed from: a */
    public static void m18967a(File file, InterfaceC0008c interfaceC0008c) {
        InterfaceC0004e m20a = C0003d.m20a(file, "rw");
        C0011b c0011b = new C0011b(m20a);
        InterfaceC0008c mo25a = C0009d.m35a(m20a, 0, c0011b.m46e()).mo25a(4096);
        C0006a mo28b = C0009d.m35a(m20a, c0011b.m47f(), c0011b.m48g()).mo28b();
        long m49h = c0011b.m49h();
        C0006a mo28b2 = C0009d.m35a(m20a, m49h, c0011b.m41a() - m49h).mo28b();
        int m47f = (int) (c0011b.m47f() - mo25a.mo29c());
        if (m47f != 0) {
            byte[] m32f = mo28b2.m32f();
            int m33g = mo28b2.m33g() + 16;
            C0005a.m23a(C0005a.m21a(m32f, m33g) - m47f, m32f, m33g);
        }
        long m46e = c0011b.m46e();
        int m18962a = m18962a(m46e, 4096);
        m20a.mo7a(m46e);
        m20a.mo12b(m46e);
        if (m18962a > 0) {
            m46e += m18962a;
            m20a.mo8a(new byte[m18962a]);
            m20a.mo12b(m46e);
        }
        interfaceC0008c.mo31e();
        interfaceC0008c.mo26a(m20a, interfaceC0008c.mo29c());
        long mo29c = m46e + interfaceC0008c.mo29c();
        m20a.mo12b(mo29c);
        int mo13c = (int) m20a.mo13c();
        mo28b.mo31e();
        mo28b.mo26a(m20a, mo28b.mo29c());
        m20a.mo12b(mo29c + mo28b.mo29c());
        C0005a.m22a(mo13c, mo28b2.m32f(), mo28b2.m33g() + 16);
        mo28b2.mo31e();
        mo28b2.mo26a(m20a, mo28b2.mo29c());
        m20a.close();
    }

    /* renamed from: a */
    private static int m18962a(long j, int i) {
        int i2 = (int) (j % i);
        if (i2 == 0) {
            return 0;
        }
        return i - i2;
    }

    /* renamed from: a */
    public static long m18963a(byte[] bArr) {
        try {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr, 0, bArr.length);
            return crc32.getValue();
        } catch (Error e2) {
            return 0L;
        } catch (Exception e3) {
            return 0L;
        }
    }

    /* renamed from: a */
    public static boolean m18968a(HashSet<?> hashSet, HashSet<?> hashSet2) {
        return hashSet.size() > hashSet2.size() ? hashSet.containsAll(hashSet2) : hashSet2.containsAll(hashSet);
    }
}
