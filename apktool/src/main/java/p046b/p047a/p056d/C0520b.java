package p046b.p047a.p056d;

import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import org.p217b.p218a.p219a.C1887e;
import org.p226d.p227a.C1913a;
import org.p226d.p227a.C1950b;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p234a.AbstractC1975j;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2158l;
import p046b.p047a.C0461b;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: SmaliDecoder.java */
/* renamed from: b.a.d.b */
/* loaded from: classes.dex */
public class C0520b {

    /* renamed from: a */
    private final File f3610a;

    /* renamed from: b */
    private final File f3611b;

    /* renamed from: c */
    private final File f3612c;

    /* renamed from: d */
    private final String f3613d;

    /* renamed from: e */
    private final boolean f3614e;

    /* renamed from: f */
    private final int f3615f;

    /* renamed from: a */
    public static void m3898a(File file, File file2, String str, boolean z, int i) {
        new C0520b(file, file2, str, z, i).m3897a();
    }

    /* renamed from: a */
    public static void m3899a(File file, File file2, boolean z, int i) {
        new C0520b(file, file2, z, i).m3900b();
    }

    C0520b(File file, File file2, String str, boolean z, int i) {
        this.f3610a = file;
        this.f3611b = (File) null;
        this.f3612c = file2;
        this.f3613d = str;
        this.f3614e = z;
        this.f3615f = i;
    }

    C0520b(File file, File file2, boolean z, int i) {
        this.f3610a = (File) null;
        this.f3611b = file;
        this.f3612c = file2;
        this.f3613d = file.getName();
        this.f3614e = z;
        this.f3615f = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3897a() {
        ?? r3 = 1;
        File file = (File) null;
        try {
            try {
                C1950b c1950b = new C1950b();
                c1950b.f11363i = false;
                c1950b.f11364j = false;
                c1950b.f11356b = true;
                c1950b.f11357c = C3102bd.f18313au ? false : true;
                c1950b.f11358d = true;
                c1950b.f11359e = this.f3614e;
                c1950b.f11360f = false;
                c1950b.f11361g = false;
                c1950b.f11366l = 0;
                c1950b.f11368n = (AbstractC1975j) null;
                File m3901c = m3901c();
                try {
                    int m19672k = C3262u.m19672k(m3901c);
                    C2153g m14453a = C2016c.m14453a(m3901c, C2359g.m15023a(this.f3615f));
                    if (m14453a.mo14768b()) {
                        throw new C0461b("Warning: You are disassembling an odex file without deodexing it.");
                    }
                    if (m14453a instanceof C2158l) {
                        c1950b.f11368n = AbstractC1975j.m14332a(((C2158l) m14453a).m14804f());
                    }
                    C1913a.m14083a(m14453a, this.f3612c, C3102bd.f18299ag, c1950b);
                    if (m19672k > 0) {
                        try {
                            new File(this.f3612c, new StringBuffer().append(".").append(C3080al.f17664a[m19672k].replaceAll("\\s", "")).toString()).createNewFile();
                        } catch (Exception e2) {
                        }
                    }
                    if (m3901c != null) {
                        m3901c.delete();
                    }
                } catch (Exception e3) {
                    e = e3;
                    throw new C0461b(e);
                }
            } catch (Throwable th) {
                th = th;
                if (r3 != 0) {
                    throw th;
                }
                r3.delete();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
            r3 = file;
            if (r3 != 0) {
            }
        }
    }

    /* renamed from: b */
    private void m3900b() {
        try {
            C1950b c1950b = new C1950b();
            c1950b.f11363i = false;
            c1950b.f11364j = false;
            c1950b.f11356b = true;
            c1950b.f11357c = C3102bd.f18313au ? false : true;
            c1950b.f11358d = true;
            c1950b.f11359e = this.f3614e;
            c1950b.f11360f = false;
            c1950b.f11361g = false;
            c1950b.f11366l = 0;
            c1950b.f11368n = (AbstractC1975j) null;
            C2153g m14453a = C2016c.m14453a(this.f3611b, C2359g.m15023a(this.f3615f));
            if (m14453a.mo14768b()) {
                throw new C0461b("Warning: You are disassembling an odex file without deodexing it.");
            }
            if (m14453a instanceof C2158l) {
                c1950b.f11368n = AbstractC1975j.m14332a(((C2158l) m14453a).m14804f());
            }
            C1913a.m14083a(m14453a, this.f3612c, C3102bd.f18299ag, c1950b);
        } catch (IOException e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: c */
    private File m3901c() {
        C2604w c2604w = new C2604w(this.f3610a);
        C2602u m16162a = c2604w.m16162a(this.f3613d);
        File createTempFile = File.createTempFile("APKTOOL_M_", ".dex", C3102bd.m18908a());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a());
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        C1887e.m13962a(bufferedInputStream, fileOutputStream);
        bufferedInputStream.close();
        fileOutputStream.close();
        c2604w.close();
        return createTempFile;
    }
}
