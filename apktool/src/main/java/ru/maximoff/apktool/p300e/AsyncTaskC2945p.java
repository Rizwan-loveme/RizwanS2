package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p264i.p265a.C2398d;
import org.p226d.p233b.p264i.p266b.C2409i;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: DexUtils.java */
/* renamed from: ru.maximoff.apktool.e.p */
/* loaded from: classes.dex */
public class AsyncTaskC2945p extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final String f15696a;

    /* renamed from: b */
    private Context f15697b;

    /* renamed from: c */
    private InterfaceC2995n f15698c;

    /* renamed from: d */
    private String f15699d;

    /* renamed from: e */
    private int f15700e;

    /* renamed from: f */
    private int f15701f;

    /* renamed from: g */
    private int f15702g;

    /* renamed from: h */
    private boolean f15703h;

    /* renamed from: i */
    private boolean f15704i;

    /* renamed from: j */
    private boolean f15705j;

    /* renamed from: k */
    private int f15706k;

    public AsyncTaskC2945p(Context context, InterfaceC2995n interfaceC2995n, boolean z) {
        super(context, interfaceC2995n);
        this.f15696a = "classes";
        this.f15700e = 0;
        this.f15701f = 0;
        this.f15702g = 8;
        this.f15704i = false;
        this.f15705j = false;
        this.f15697b = context;
        this.f15698c = interfaceC2995n;
        this.f15699d = new StringBuffer().append(C3249i.f19547g).append(".dex").toString();
        this.f15703h = z;
    }

    /* renamed from: g */
    public void m17537g(boolean z) {
        this.f15704i = z;
    }

    /* renamed from: h */
    public void m17538h(boolean z) {
        this.f15705j = z;
    }

    /* renamed from: a */
    public void m17533a(int i) {
        this.f15706k = i;
    }

    /* renamed from: a */
    public void m17534a(String str) {
        if (str.trim().isEmpty()) {
            return;
        }
        this.f15699d = C3112bn.m19033h(str);
    }

    /* renamed from: b */
    public void m17535b(int i) {
        this.f15700e = i;
    }

    /* renamed from: c */
    public void m17536c(int i) {
        this.f15701f = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        if (this.f15705j) {
            return R.string.redistribute_dex;
        }
        if (this.f15703h) {
            return R.string.merge_dex;
        }
        return R.string.split_dex;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03ac A[Catch: Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, TryCatch #16 {Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, blocks: (B:220:0x039f, B:223:0x03a5, B:227:0x03a8, B:229:0x03ac, B:230:0x03b3, B:233:0x03bf, B:238:0x043a, B:241:0x0441, B:243:0x0444, B:245:0x0455, B:250:0x0411, B:225:0x03f7), top: B:219:0x039f }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03bf A[Catch: Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, TRY_LEAVE, TryCatch #16 {Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, blocks: (B:220:0x039f, B:223:0x03a5, B:227:0x03a8, B:229:0x03ac, B:230:0x03b3, B:233:0x03bf, B:238:0x043a, B:241:0x0441, B:243:0x0444, B:245:0x0455, B:250:0x0411, B:225:0x03f7), top: B:219:0x039f }] */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0444 A[Catch: Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, TryCatch #16 {Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, blocks: (B:220:0x039f, B:223:0x03a5, B:227:0x03a8, B:229:0x03ac, B:230:0x03b3, B:233:0x03bf, B:238:0x043a, B:241:0x0441, B:243:0x0444, B:245:0x0455, B:250:0x0411, B:225:0x03f7), top: B:219:0x039f }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0411 A[Catch: Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, TRY_LEAVE, TryCatch #16 {Error -> 0x03c4, Exception -> 0x0419, all -> 0x049a, blocks: (B:220:0x039f, B:223:0x03a5, B:227:0x03a8, B:229:0x03ac, B:230:0x03b3, B:233:0x03bf, B:238:0x043a, B:241:0x0441, B:243:0x0444, B:245:0x0455, B:250:0x0411, B:225:0x03f7), top: B:219:0x039f }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0144  */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v109 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Boolean mo17049a(File[] fileArr) {
        Object[] objArr = {(Object) null};
        mo3984d(R.string.mplease_wait, objArr);
        if (this.f15705j) {
            File file11 = null;
            File m19564a = null;
            try {
                File file10 = fileArr[0];
                int[] iArr = new int[1];
                try {
                    iArr[0] = new C3081am(file10).m18632h();
                } catch (Exception e4) {
                    iArr[0] = 14;
                }
                InterfaceC0008c m18964a = (this.f15706k == 0 && C3102bd.m18925a(this.f15697b, "save_sign_data", true)) ? C3105bg.m18964a(file10) : (InterfaceC0008c) null;
                m19564a = C3262u.m19564a();
                File[] m17531a = m17531a(file10, m19564a);
                if (this.f15701f > 0) {
                    m17532b(m17531a, m19564a, this.f15701f, true, "classes", 0, true);
                } else {
                    m17528a(m17531a, m19564a, this.f15700e, true, "classes", 0, true);
                }
                File m17524a = m17524a(file10, (String) null);
                File[] listFiles7 = m19564a.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.p.1

                    /* renamed from: a */
                    private final AsyncTaskC2945p f15707a;

                    {
                        this.f15707a = this;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file14, String str) {
                        return str.startsWith("classes") && str.endsWith(".dex");
                    }
                });
                file11 = new File(m17524a.getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".").append(m17524a.getName()).toString()).append("_").toString()).append(System.currentTimeMillis()).toString());
                File file14 = new File(new StringBuffer().append(new StringBuffer().append(file11.getAbsolutePath()).append("_").toString()).append(C3080al.m18520a(1000, 9999)).toString());
                m17527a(file10.getAbsolutePath(), file11.getAbsolutePath(), m19564a, listFiles7);
                C3317a.m20052a(file11.getAbsolutePath(), file14.getAbsolutePath());
                file11.delete();
                C2917as.m17314a(this.f15697b, this.f15706k, new C2917as.a(this, file14, m17524a, m18964a, iArr) { // from class: ru.maximoff.apktool.e.p.2

                    /* renamed from: a */
                    private final AsyncTaskC2945p f15708a;

                    /* renamed from: b */
                    private final File f15709b;

                    /* renamed from: c */
                    private final File f15710c;

                    /* renamed from: d */
                    private final InterfaceC0008c f15711d;

                    /* renamed from: e */
                    private final int[] f15712e;

                    {
                        this.f15708a = this;
                        this.f15709b = file14;
                        this.f15710c = m17524a;
                        this.f15711d = m18964a;
                        this.f15712e = iArr;
                    }

                    @Override // ru.maximoff.apktool.p300e.C2917as.a
                    /* renamed from: a */
                    public void mo16440a(C2917as c2917as, boolean z) {
                        if (z) {
                            this.f15709b.renameTo(this.f15710c);
                            if (this.f15711d != null) {
                                try {
                                    C3105bg.m18967a(this.f15710c, this.f15711d);
                                } catch (IOException e9) {
                                }
                            }
                            this.f15708a.mo3984d(R.string.successf, this.f15710c.getAbsolutePath());
                            return;
                        }
                        c2917as.m17320a(this.f15709b, this.f15710c, this.f15712e[0]);
                        this.f15708a.mo3984d(R.string.sign_done, this.f15710c.getAbsolutePath());
                        this.f15709b.delete();
                    }
                });
                m17060b(m17524a);
                return new Boolean(true);
            } catch (Error e) {
                mo3979a(R.string.errorf, e.getMessage());
                return new Boolean(false);
            } catch (Exception e2) {
                mo3979a(R.string.errorf, e2.getMessage());
                return new Boolean(false);
            } finally {
                if (m19564a != null) {
                    C0542g.m3987a(m19564a);
                }
                if (file11 != null && file11.isFile()) {
                    file11.delete();
                }
            }
        }
        if (this.f15703h) {
            File file15 = fileArr[0];
            File parentFile = file15.getParentFile();
            File file4 = null;
            try {
                boolean m19664g = C3262u.m19664g(this.f15697b, parentFile);
                file4 = (m19664g && this.f15704i) ? C3262u.m19564a() : (File) null;
                int i3 = 0;
                for (int i2 = 0; i2 < fileArr.length; i2++) {
                    int m19672k = C3262u.m19672k(fileArr[i2]);
                    if (m19672k > i3) {
                        i3 = m19672k;
                    }
                }
                C2409i c2409i = new C2409i(C2359g.m15023a(C3080al.f17665b[i3]));
                for (File file21 : fileArr) {
                    File file5;
                    if (file4 != null) {
                        file5 = new File(file4, file21.getName());
                        C3262u.m19613a(file21, file5, true);
                    } else {
                        file5 = file21;
                    }
                    Iterator<? extends InterfaceC2244d> it = C2016c.m14453a(file5, C2359g.m15023a(C3080al.f17665b[C3262u.m19672k(file5)])).mo14769c().iterator();
                    while (it.hasNext()) {
                        c2409i.m15249a(it.next());
                        if (c2409i.m15408b()) {
                            throw new Exception(this.f15697b.getString(R.string.merge_dex_error));
                        }
                    }
                }
                String[] m19641b = C3262u.m19641b(this.f15699d);
                if (!m19641b[1].isEmpty()) {
                    m19641b[1] = new StringBuffer().append(".").append(m19641b[1]).toString();
                }
                File m17525a = m17525a(parentFile, m19641b[0], m19641b[1], m19664g, false);
                c2409i.m15405a(new C2398d(m17525a));
                mo3984d(R.string.successf, m17525a.getAbsolutePath());
                m17060b(parentFile);
                return new Boolean(true);
            } catch (Error e11) {
                mo3979a(R.string.errorf, e11.getMessage());
                return new Boolean(false);
            } catch (Exception e12) {
                mo3979a(R.string.errorf, e12.getMessage());
                return new Boolean(false);
            } finally {
                if (!this.f15704i && file4 != null) {
                    File[] listFiles6 = file4.listFiles();
                    if (listFiles6 != null) {
                        for (File file22 : listFiles6) {
                            File file23 = new File(parentFile, file22.getName());
                            if (!file23.isFile()) {
                                C3262u.m19613a(file22, file23, true);
                            }
                        }
                    }
                }
                if (file4 != null) {
                    C0542g.m3987a(file4);
                }
            }
        }
        File file24 = fileArr[0];
        File parentFile2 = file24.getParentFile();
        String[] m19641b2 = C3262u.m19641b(file24.getName());
        boolean m19664g2 = C3262u.m19664g(this.f15697b, parentFile2);
        if (this.f15700e == 1) {
            mo3984d(R.string.successf, file24.getAbsolutePath());
            return new Boolean(true);
        }
        String str = m19641b2[0];
        int i = 0;
        Matcher matcher = Pattern.compile("^(.*?)?(\\d+)$").matcher(str);
        if (matcher.find()) {
            try {
                i = Integer.parseInt(matcher.group(2));
                if (i > 0) {
                    i--;
                }
                str = str.substring(0, str.length() - String.valueOf(i).length());
            } catch (Exception e15) {
                str = m19641b2[0];
                i = 0;
            }
        }
        File file = null;
        try {
            if (m19664g2 && this.f15704i) {
                file = C3262u.m19564a();
            }
            File[] fileArr2 = new File[fileArr.length];
            if (file != null) {
                for (int i4 = 0; i4 < fileArr.length; i4++) {
                    fileArr2[i4] = new File(file, fileArr[i4].getName());
                    C3262u.m19613a(fileArr[i4], fileArr2[i4], true);
                }
            } else {
                fileArr2 = fileArr;
            }
            if (this.f15701f > 0) {
                m17532b(fileArr2, parentFile2, this.f15701f, m19664g2, str, i, false);
            } else {
                m17528a(fileArr2, parentFile2, this.f15700e, m19664g2, str, i, false);
            }
            return new Boolean(true);
        } catch (Error e16) {
            mo3979a(R.string.errorf, e16.getMessage());
            return new Boolean(false);
        } catch (Exception e17) {
            mo3979a(R.string.errorf, e17.getMessage());
            return new Boolean(false);
        } finally {
            if (!this.f15704i && file != null) {
                File[] listFiles3 = file.listFiles();
                if (listFiles3 != null) {
                    for (File file26 : listFiles3) {
                        File file27 = new File(parentFile2, file26.getName());
                        if (!file27.isFile()) {
                            C3262u.m19613a(file26, file27, true);
                        }
                    }
                }
            }
            if (file != null) {
                C0542g.m3987a(file);
            }
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: a */
    private void m17527a(String str, String str2, File file, File[] fileArr) {
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        List<File> m19061a = C3117bs.m19061a(fileArr);
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            File file2 = new File(file, name);
            if (file2.isFile()) {
                if (m19061a.contains(file2)) {
                    m19061a.remove(file2);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2), bArr.length);
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                c2602u.setCrc(C3117bs.m19057a(file2.getAbsolutePath()));
                if (nextElement.getMethod() == 0) {
                    c2602u.setMethod(0);
                    c2602u.setSize(file2.length());
                    c2602u.setCompressedSize(file2.length());
                } else {
                    c2602u.setMethod(8);
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
            } else if (!name.matches("^classes(\\d+)?\\.dex$")) {
                C2602u c2602u2 = new C2602u(name);
                c2602u2.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                c2602u2.setCrc(nextElement.getCrc());
                if (nextElement.getMethod() == 0 && size >= 0) {
                    c2602u2.setMethod(0);
                    c2602u2.setSize(size);
                    c2602u2.setCompressedSize(size);
                } else {
                    c2602u2.setMethod(8);
                    c2602u2.setCompressedSize(-1L);
                }
                m19496a.mo16214a(c2602u2);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                while (true) {
                    int read2 = bufferedInputStream2.read(bArr);
                    if (read2 == -1) {
                        break;
                    } else {
                        m19496a.write(bArr, 0, read2);
                    }
                }
                bufferedInputStream2.close();
                m19496a.flush();
                m19496a.m16218b();
            }
        }
        if (!m19061a.isEmpty()) {
            for (File file3 : m19061a) {
                if (!file3.isDirectory()) {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3), bArr.length);
                    C2602u c2602u3 = new C2602u(file3.getName());
                    c2602u3.setTime(file3.lastModified());
                    c2602u3.setMethod(this.f15702g);
                    c2602u3.setCrc(C3117bs.m19057a(file3.getAbsolutePath()));
                    if (this.f15702g == 0) {
                        c2602u3.setMethod(0);
                        c2602u3.setSize(file3.length());
                        c2602u3.setCompressedSize(file3.length());
                    } else {
                        c2602u3.setMethod(8);
                        c2602u3.setCompressedSize(-1L);
                    }
                    m19496a.mo16214a(c2602u3);
                    while (true) {
                        int read3 = bufferedInputStream3.read(bArr);
                        if (read3 == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read3);
                        }
                    }
                    bufferedInputStream3.close();
                    m19496a.flush();
                    m19496a.m16218b();
                }
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private File[] m17531a(File file, File file2) {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[C3249i.m19500a()];
        C2604w c2604w = new C2604w(file);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            if (!nextElement.isDirectory()) {
                String name = nextElement.getName();
                if (name.matches("^classes(\\d+)?\\.dex$")) {
                    this.f15702g = nextElement.getMethod();
                    File file3 = new File(file2, new StringBuffer().append("_").append(name).toString());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), bArr.length);
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        } catch (Throwable th) {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            throw th;
                        }
                    }
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    arrayList.add(file3);
                } else {
                    continue;
                }
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    private boolean m17529a(List<C2409i> list, InterfaceC2244d interfaceC2244d) {
        return m17530a(list, interfaceC2244d, 65536);
    }

    /* renamed from: a */
    private boolean m17530a(List<C2409i> list, InterfaceC2244d interfaceC2244d, int i) {
        for (C2409i c2409i : list) {
            c2409i.m15251c();
            c2409i.m15249a(interfaceC2244d);
            if (!c2409i.m15407a(i)) {
                return true;
            }
            c2409i.m15252d();
        }
        return false;
    }

    /* renamed from: a */
    private void m17528a(File[] fileArr, File file, int i, boolean z, String str, int i2, boolean z2) {
        int i3 = 0;
        for (File file2 : fileArr) {
            int m19672k = C3262u.m19672k(file2);
            if (m19672k > i3) {
                i3 = m19672k;
            }
        }
        C2359g m15023a = C2359g.m15023a(C3080al.f17665b[i3]);
        ArrayList arrayList = new ArrayList(i);
        for (int i4 = 0; i4 < i; i4++) {
            arrayList.add(new C2409i(m15023a));
        }
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        while (i5 < fileArr.length) {
            boolean z4 = z3;
            for (InterfaceC2244d interfaceC2244d : C2016c.m14453a(fileArr[i5], m15023a).mo14769c()) {
                if (z4) {
                    if (!m17529a(arrayList, interfaceC2244d)) {
                        throw new Exception(this.f15697b.getString(R.string.merge_dex_error));
                    }
                } else {
                    C2409i c2409i = arrayList.get(i6);
                    c2409i.m15251c();
                    c2409i.m15249a(interfaceC2244d);
                    if (c2409i.m15408b()) {
                        c2409i.m15252d();
                        z4 = true;
                        if (!m17529a(arrayList, interfaceC2244d)) {
                            throw new Exception(this.f15697b.getString(R.string.merge_dex_error));
                        }
                    } else {
                        i6++;
                        if (i6 >= i) {
                            i6 = 0;
                        }
                    }
                }
            }
            i5++;
            z3 = z4;
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = i7 + i2;
            File m17526a = m17526a(file, new StringBuffer().append(str).append((i8 > 0 || !str.equals("classes")) ? String.valueOf(i8 + 1) : "").toString(), z, z2);
            arrayList.get(i7).m15405a(new C2398d(m17526a));
            mo3984d(R.string.successf, m17526a.getName());
        }
    }

    /* renamed from: b */
    private void m17532b(File[] fileArr, File file, int i, boolean z, String str, int i2, boolean z2) {
        int i3 = 0;
        for (File file2 : fileArr) {
            int m19672k = C3262u.m19672k(file2);
            if (m19672k > i3) {
                i3 = m19672k;
            }
        }
        C2359g m15023a = C2359g.m15023a(C3080al.f17665b[i3]);
        int i4 = i2 + 1;
        C2409i c2409i = new C2409i(m15023a);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= fileArr.length) {
                break;
            }
            for (InterfaceC2244d interfaceC2244d : C2016c.m14453a(fileArr[i6], m15023a).mo14769c()) {
                c2409i.m15251c();
                c2409i.m15249a(interfaceC2244d);
                if (c2409i.m15407a(i)) {
                    c2409i.m15252d();
                    File m17526a = m17526a(file, new StringBuffer().append(str).append((i4 > 1 || !str.equals("classes")) ? String.valueOf(i4) : "").toString(), z, z2);
                    c2409i.m15405a(new C2398d(m17526a));
                    mo3984d(R.string.successf, m17526a.getName());
                    c2409i = new C2409i(m15023a);
                    c2409i.m15249a(interfaceC2244d);
                    i4++;
                }
            }
            i5 = i6 + 1;
        }
        File m17526a2 = m17526a(file, new StringBuffer().append(str).append((i4 > 1 || !str.equals("classes")) ? String.valueOf(i4) : "").toString(), z, z2);
        c2409i.m15405a(new C2398d(m17526a2));
        mo3984d(R.string.successf, m17526a2.getName());
    }

    /* renamed from: a */
    private File m17526a(File file, String str, boolean z, boolean z2) {
        return m17525a(file, str, ".dex", z, z2);
    }

    /* renamed from: a */
    private File m17525a(File file, String str, String str2, boolean z, boolean z2) {
        String absolutePath = file.getAbsolutePath();
        if ((!z || C3102bd.m18925a(this.f15697b, "all_to_out_dir", false)) && !z2) {
            absolutePath = C3102bd.f18339v;
            if (absolutePath == null) {
                mo3979a(R.string.output_directory_not_set, (Object) null);
                return (File) null;
            }
            File file2 = new File(absolutePath);
            if (!file2.exists() && !file2.mkdirs()) {
                mo3979a(R.string.output_directory_not_extsts, absolutePath);
                return (File) null;
            }
            if (!file2.isDirectory()) {
                mo3979a(R.string.not_directory, absolutePath);
                return (File) null;
            }
        }
        return new File(absolutePath, C3262u.m19566a(this.f15697b, absolutePath, str, str2, 0));
    }

    /* renamed from: a */
    private File m17524a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15697b, file)) || C3102bd.m18925a(this.f15697b, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                mo3979a(R.string.output_directory_not_set, (Object) null);
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
        return new File(parent, C3262u.m19623b(this.f15697b, parent, str, "_rd", 0));
    }
}
