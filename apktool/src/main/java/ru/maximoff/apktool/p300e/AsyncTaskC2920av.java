package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: SplitArch.java */
/* renamed from: ru.maximoff.apktool.e.av */
/* loaded from: classes.dex */
public class AsyncTaskC2920av extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15409a;

    /* renamed from: b */
    private InterfaceC2995n f15410b;

    /* renamed from: c */
    private List<String> f15411c;

    /* renamed from: d */
    private int f15412d;

    /* renamed from: e */
    private boolean f15413e;

    public AsyncTaskC2920av(Context context, InterfaceC2995n interfaceC2995n, List<String> list, int i) {
        super(context, interfaceC2995n);
        this.f15409a = context;
        this.f15410b = interfaceC2995n;
        this.f15411c = list;
        this.f15412d = i;
        this.f15413e = false;
    }

    /* renamed from: g */
    public void m17353g(boolean z) {
        this.f15413e = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.split_arch;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        int i;
        boolean z;
        boolean z2;
        File[] fileArr2 = new File[2];
        try {
            try {
                try {
                    int[] iArr = new int[1];
                    try {
                        iArr[0] = new C3081am(fileArr[0]).m18632h();
                    } catch (Exception e2) {
                        iArr[0] = 14;
                    }
                    InterfaceC0008c m18964a = (this.f15412d == 0 && C3102bd.m18925a(this.f15409a, "save_sign_data", true)) ? C3105bg.m18964a(fileArr[0]) : (InterfaceC0008c) null;
                    if (this.f15413e) {
                        File m17350a = m17350a(fileArr[0], (String) null, C3080al.m18538a(this.f15411c, ","));
                        if (m17350a == null) {
                            Boolean bool = new Boolean(false);
                            for (File file : fileArr2) {
                                if (file != null && file.exists()) {
                                    file.delete();
                                }
                            }
                            return bool;
                        }
                        mo3984d(R.string.mprocessing_file, m17350a.getName());
                        fileArr2[0] = new File(fileArr[0].getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".split_unsigned_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(fileArr[0].getName()).toString());
                        fileArr2[1] = new File(fileArr[0].getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".split_repacked_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(fileArr[0].getName()).toString());
                        try {
                            m17351a(fileArr[0].getAbsolutePath(), fileArr2[1].getAbsolutePath(), this.f15411c);
                            z2 = C3317a.m20052a(fileArr2[1].getAbsolutePath(), fileArr2[0].getAbsolutePath());
                        } catch (Exception e3) {
                            mo3979a(R.string.errorf, e3.getMessage());
                            z2 = false;
                        }
                        r8 = z2 ? 1 : 0;
                        if (fileArr2[1].exists()) {
                            fileArr2[1].delete();
                        }
                        C2917as.m17314a(this.f15409a, this.f15412d, new C2917as.a(this, fileArr2, m17350a, m18964a, iArr) { // from class: ru.maximoff.apktool.e.av.1

                            /* renamed from: a */
                            private final AsyncTaskC2920av f15414a;

                            /* renamed from: b */
                            private final File[] f15415b;

                            /* renamed from: c */
                            private final File f15416c;

                            /* renamed from: d */
                            private final InterfaceC0008c f15417d;

                            /* renamed from: e */
                            private final int[] f15418e;

                            {
                                this.f15414a = this;
                                this.f15415b = fileArr2;
                                this.f15416c = m17350a;
                                this.f15417d = m18964a;
                                this.f15418e = iArr;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2917as.a
                            /* renamed from: a */
                            public void mo16440a(C2917as c2917as, boolean z3) {
                                if (z3) {
                                    this.f15415b[0].renameTo(this.f15416c);
                                    if (this.f15417d != null) {
                                        try {
                                            C3105bg.m18967a(this.f15416c, this.f15417d);
                                            return;
                                        } catch (IOException e4) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                c2917as.m17320a(this.f15415b[0], this.f15416c, this.f15418e[0]);
                                this.f15415b[0].delete();
                            }
                        });
                        if (m17076j() == null) {
                            m17060b(m17350a.getParentFile());
                        }
                        i = r8;
                    } else {
                        for (String str : this.f15411c) {
                            File m17350a2 = m17350a(fileArr[0], (String) null, str);
                            if (m17350a2 == null) {
                                Boolean bool2 = new Boolean(false);
                                for (File file2 : fileArr2) {
                                    if (file2 != null && file2.exists()) {
                                        file2.delete();
                                    }
                                }
                                return bool2;
                            }
                            mo3984d(R.string.mprocessing_file, m17350a2.getName());
                            fileArr2[0] = new File(fileArr[0].getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".split_unsigned_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(fileArr[0].getName()).toString());
                            fileArr2[1] = new File(fileArr[0].getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".split_repacked_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(fileArr[0].getName()).toString());
                            try {
                                m17352c(fileArr[0].getAbsolutePath(), fileArr2[1].getAbsolutePath(), str);
                                z = C3317a.m20052a(fileArr2[1].getAbsolutePath(), fileArr2[0].getAbsolutePath());
                            } catch (Exception e4) {
                                mo3979a(R.string.errorf, e4.getMessage());
                                z = false;
                            }
                            if (z) {
                                r8++;
                            }
                            if (fileArr2[1].exists()) {
                                fileArr2[1].delete();
                            }
                            C2917as.m17314a(this.f15409a, this.f15412d, new C2917as.a(this, fileArr2, m17350a2, m18964a, iArr) { // from class: ru.maximoff.apktool.e.av.2

                                /* renamed from: a */
                                private final AsyncTaskC2920av f15419a;

                                /* renamed from: b */
                                private final File[] f15420b;

                                /* renamed from: c */
                                private final File f15421c;

                                /* renamed from: d */
                                private final InterfaceC0008c f15422d;

                                /* renamed from: e */
                                private final int[] f15423e;

                                {
                                    this.f15419a = this;
                                    this.f15420b = fileArr2;
                                    this.f15421c = m17350a2;
                                    this.f15422d = m18964a;
                                    this.f15423e = iArr;
                                }

                                @Override // ru.maximoff.apktool.p300e.C2917as.a
                                /* renamed from: a */
                                public void mo16440a(C2917as c2917as, boolean z3) {
                                    if (z3) {
                                        this.f15420b[0].renameTo(this.f15421c);
                                        if (this.f15422d != null) {
                                            try {
                                                C3105bg.m18967a(this.f15421c, this.f15422d);
                                                return;
                                            } catch (IOException e5) {
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    c2917as.m17320a(this.f15420b[0], this.f15421c, this.f15423e[0]);
                                    this.f15420b[0].delete();
                                }
                            });
                            if (m17076j() == null) {
                                m17060b(m17350a2.getParentFile());
                            }
                        }
                        i = r8;
                    }
                } catch (Error e5) {
                    i = 0;
                    mo3979a(R.string.errorf, e5.getMessage());
                }
            } catch (Exception e6) {
                i = 0;
                mo3979a(R.string.errorf, e6.getMessage());
            }
            for (File file3 : fileArr2) {
                if (file3 != null && file3.exists()) {
                    file3.delete();
                }
            }
            return new Boolean(i == 0);
        } catch (Throwable th) {
            for (File file4 : fileArr2) {
                if (file4 != null && file4.exists()) {
                    file4.delete();
                }
            }
            throw th;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: a */
    private File m17350a(File file, String str, String str2) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15409a, file)) || C3102bd.m18925a(this.f15409a, "all_to_out_dir", false)) {
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
        return new File(parent, C3262u.m19623b(this.f15409a, parent, str, new StringBuffer().append("_").append(str2).toString(), 0));
    }

    /* renamed from: c */
    private void m17352c(String str, String str2, String str3) {
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            if (!nextElement.getName().startsWith("lib/") || nextElement.getName().startsWith(new StringBuffer().append(new StringBuffer().append("lib/").append(str3).toString()).append("/").toString())) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                C2602u c2602u = new C2602u(nextElement.getName());
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                c2602u.setCrc(nextElement.getCrc());
                if (nextElement.getMethod() == 0 && size >= 0) {
                    c2602u.setMethod(0);
                    c2602u.setSize(size);
                    c2602u.setCompressedSize(size);
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
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private void m17351a(String str, String str2, List<String> list) {
        boolean z;
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            if (nextElement.getName().startsWith("lib/")) {
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (nextElement.getName().startsWith(new StringBuffer().append(new StringBuffer().append("lib/").append(it.next()).toString()).append("/").toString())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
            C2602u c2602u = new C2602u(nextElement.getName());
            c2602u.setTime(nextElement.getTime());
            long size = nextElement.getSize();
            c2602u.setCrc(nextElement.getCrc());
            if (nextElement.getMethod() == 0 && size >= 0) {
                c2602u.setMethod(0);
                c2602u.setSize(size);
                c2602u.setCompressedSize(size);
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
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }
}
