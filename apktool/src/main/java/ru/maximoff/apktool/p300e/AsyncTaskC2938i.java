package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: CopySign.java */
/* renamed from: ru.maximoff.apktool.e.i */
/* loaded from: classes.dex */
public class AsyncTaskC2938i extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final String f15652a;

    /* renamed from: b */
    private final Pattern f15653b;

    /* renamed from: c */
    private Context f15654c;

    /* renamed from: d */
    private File f15655d;

    /* renamed from: e */
    private String f15656e;

    public AsyncTaskC2938i(Context context, File file, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15652a = "META-INF/MANIFEST.MF";
        this.f15653b = Pattern.compile("^META-INF/.+\\.(SF|RSA|DSA|EC)$");
        this.f15654c = context;
        this.f15655d = file;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.copy_sign;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.File] */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean mo17058a(File file) {
        File file2 = null;
        mo3984d(R.string.mplease_wait, new Object[0]);
        try {
            file2 = C3262u.m19564a();
            File m17494a = m17494a(file, (String) null);
            if (m17494a == null) {
                throw new IOException("failed to create an output file");
            }
            File m17492a = m17492a(this.f15655d, file2);
            InterfaceC0008c m18964a = C3105bg.m18964a(this.f15655d);
            if (m17492a == null && m18964a == null) {
                throw new IOException("signature not found");
            }
            if (m17492a != null) {
                m17493a(this.f15655d, file2, "META-INF/MANIFEST.MF");
                m17493a(this.f15655d, file2, String.format("META-INF/%s.SF", this.f15656e));
            }
            m17495a(file.getAbsolutePath(), m17494a.getAbsolutePath(), file2);
            if (m18964a != null) {
                C3105bg.m18967a(m17494a, m18964a);
            }
            mo3984d(R.string.successf, m17494a.getAbsolutePath());
            m17060b(m17494a.getParentFile());
            return true;
        } catch (Error e) {
            mo3979a(R.string.errorf, e.getMessage());
            return false;
        } catch (Exception e2) {
            mo3979a(R.string.errorf, e2.getMessage());
            return false;
        } finally {
            if (file2 != null) {
                C0542g.m3987a(file2);
            }
        }
    }

    /* renamed from: a */
    private File m17492a(File file, File file2) {
        try {
            C2604w c2604w = new C2604w(file);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                C2602u nextElement = m16163b.nextElement();
                String name = nextElement.getName();
                if (!nextElement.isDirectory() && name.toUpperCase().matches("^META-INF/.+\\.(RSA|DSA|EC)$")) {
                    String[] m19641b = C3262u.m19641b(name.substring(name.lastIndexOf(47) + 1));
                    this.f15656e = m19641b[0];
                    File file3 = new File(file2, new StringBuffer().append(new StringBuffer().append(m19641b[0]).append(".").toString()).append(m19641b[1]).toString());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                    byte[] m13984b = C1887e.m13984b(bufferedInputStream);
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    fileOutputStream.write(m13984b);
                    C1887e.m13970a((InputStream) bufferedInputStream);
                    C1887e.m13972a((OutputStream) fileOutputStream);
                    C1887e.m13969a(c2604w);
                    return file3;
                }
            }
            c2604w.close();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return (File) null;
    }

    /* renamed from: a */
    private File m17493a(File file, File file2, String str) {
        C2604w c2604w;
        C2602u m16162a;
        try {
            c2604w = new C2604w(file);
            m16162a = c2604w.m16162a(str);
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        if (m16162a != null) {
            File file3 = new File(file2, str.substring(str.lastIndexOf(47) + 1));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a());
            byte[] m13984b = C1887e.m13984b(bufferedInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(m13984b);
            C1887e.m13970a((InputStream) bufferedInputStream);
            C1887e.m13972a((OutputStream) fileOutputStream);
            C1887e.m13969a(c2604w);
            return file3;
        }
        c2604w.close();
        return (File) null;
    }

    /* renamed from: a */
    private void m17495a(String str, String str2, File file) {
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (!nextElement.isDirectory() && !C3112bn.m19040o(name) && !name.toUpperCase().equals("META-INF/MANIFEST.MF") && !this.f15653b.matcher(name.toUpperCase()).matches()) {
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                long crc = nextElement.getCrc();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                if (nextElement.getMethod() == 0 && crc >= 0 && size >= 0) {
                    c2602u.setMethod(0);
                    c2602u.setSize(size);
                    c2602u.setCompressedSize(size);
                    c2602u.setCrc(crc);
                } else {
                    c2602u.setMethod(8);
                    c2602u.setCrc(crc);
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
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                C2602u c2602u2 = new C2602u(String.format("META-INF/%s", file2.getName()));
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                c2602u2.setMethod(8);
                c2602u2.setCompressedSize(-1L);
                m19496a.mo16214a(c2602u2);
                while (true) {
                    int read2 = bufferedInputStream2.read(bArr);
                    if (read2 == -1) {
                        break;
                    } else {
                        m19496a.write(bArr, 0, read2);
                    }
                }
                bufferedInputStream2.close();
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private File m17494a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15654c, file)) || C3102bd.m18925a(this.f15654c, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                mo3979a(R.string.output_directory_not_set, new Object[0]);
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
        return new File(parent, C3262u.m19623b(this.f15654c, parent, str, "_cs", 0));
    }
}
