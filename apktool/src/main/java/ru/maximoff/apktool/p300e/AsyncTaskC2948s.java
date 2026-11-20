package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.content.Context;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.C0518d;
import p046b.p047a.p050c.p051a.C0497h;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3111bm;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3257q;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: EncRes.java */
/* renamed from: ru.maximoff.apktool.e.s */
/* loaded from: classes.dex */
public class AsyncTaskC2948s extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final String[] f15756a;

    /* renamed from: b */
    private final String[] f15757b;

    /* renamed from: c */
    private Context f15758c;

    /* renamed from: d */
    private int f15759d;

    /* renamed from: e */
    private String f15760e;

    /* renamed from: f */
    private boolean f15761f;

    /* renamed from: g */
    private String f15762g;

    /* renamed from: h */
    private int f15763h;

    /* renamed from: i */
    private int f15764i;

    /* renamed from: j */
    private int f15765j;

    /* renamed from: k */
    private boolean f15766k;

    /* renamed from: l */
    private String[] f15767l;

    public AsyncTaskC2948s(Context context, boolean z, int i) {
        super(context, (InterfaceC2995n) null);
        this.f15756a = new String[]{"XklGXV5ZTlA=", "HE8=", "HBRRW19cVUVFVxxLV0dcRUZWUx9fWF9RQA==", "HBRBXFxCQFBYH0NcQVtGQldQG0JQTVpH"};
        this.f15757b = new String[]{"HBRGVUFXUUEbVlRXQV1HWVFG", "HFo=", "HFY="};
        this.f15765j = 0;
        this.f15758c = context;
        this.f15761f = z;
        this.f15759d = i;
        this.f15760e = C3080al.m18529a();
        if (this.f15761f) {
            this.f15762g = "";
        } else {
            this.f15762g = "enc_";
        }
        this.f15763h = C3102bd.m18905a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_minSdk").toString(), 0);
        this.f15764i = C3102bd.m18905a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_targetSdk").toString(), 0);
        this.f15766k = C3102bd.m18925a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_libs_enable").toString(), false);
        String m18910a = C3102bd.m18910a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_libs_include").toString(), "");
        if (!m18910a.isEmpty()) {
            this.f15767l = m18910a.split(",");
        } else {
            this.f15767l = (String[]) null;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        mo3984d(R.string.mplease_wait, (Object) null);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return this.f15761f ? R.string.moptimize2 : R.string.enc_res;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        InterfaceC0008c interfaceC0008c;
        try {
            try {
                int[] iArr = new int[1];
                try {
                    C3081am c3081am = new C3081am(file);
                    iArr[0] = c3081am.m18632h();
                    this.f15765j = c3081am.m18633i();
                } catch (Exception e2) {
                    iArr[0] = 14;
                }
                if (this.f15759d == 0 && C3102bd.m18925a(this.f15758c, "save_sign_data", true)) {
                    interfaceC0008c = C3105bg.m18964a(file);
                } else {
                    interfaceC0008c = (InterfaceC0008c) null;
                }
                File m17572a = m17572a(file, (String) null);
                File createTempFile = File.createTempFile("APKTOOL_M", ".rep", C3102bd.m18908a());
                if ((this.f15766k && this.f15767l != null) || this.f15763h > 0 || this.f15764i > 0) {
                    if (this.f15766k && this.f15767l != null) {
                        mo3984d(R.string.label_libs, C3080al.m18540a(this.f15767l, ", "));
                    }
                    File createTempFile2 = File.createTempFile("APKTOOL_M", ".repack", C3102bd.m18908a());
                    m17574b(file, createTempFile2);
                    C3317a.m20052a(createTempFile2.getAbsolutePath(), createTempFile.getAbsolutePath());
                    if (createTempFile2.exists()) {
                        createTempFile2.delete();
                    }
                } else {
                    C3262u.m19612a(file, createTempFile);
                }
                File createTempFile3 = File.createTempFile("APKTOOL_M", ".opt", C3102bd.m18908a());
                int m17570a = m17570a(createTempFile, createTempFile3);
                if (createTempFile.exists()) {
                    createTempFile.delete();
                }
                if (m17570a == 0) {
                    File createTempFile4 = File.createTempFile("APKTOOL_M", ".align", C3102bd.m18908a());
                    C3317a.m20052a(createTempFile3.getAbsolutePath(), createTempFile4.getAbsolutePath());
                    if (createTempFile3.exists()) {
                        createTempFile3.delete();
                    }
                    C2917as.m17314a(this.f15758c, this.f15759d, new C2917as.a(this, createTempFile4, m17572a, interfaceC0008c, iArr) { // from class: ru.maximoff.apktool.e.s.1

                        /* renamed from: a */
                        private final AsyncTaskC2948s f15768a;

                        /* renamed from: b */
                        private final File f15769b;

                        /* renamed from: c */
                        private final File f15770c;

                        /* renamed from: d */
                        private final InterfaceC0008c f15771d;

                        /* renamed from: e */
                        private final int[] f15772e;

                        {
                            this.f15768a = this;
                            this.f15769b = createTempFile4;
                            this.f15770c = m17572a;
                            this.f15771d = interfaceC0008c;
                            this.f15772e = iArr;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                C3262u.m19612a(this.f15769b, this.f15770c);
                                if (this.f15771d != null) {
                                    try {
                                        C3105bg.m18967a(this.f15770c, this.f15771d);
                                    } catch (IOException e3) {
                                    }
                                }
                            } else {
                                c2917as.m17320a(this.f15769b, this.f15770c, this.f15772e[0]);
                            }
                            if (this.f15769b.exists()) {
                                this.f15769b.delete();
                            }
                        }
                    });
                    m17060b(m17572a);
                    if (this.f15761f) {
                        mo3984d(R.string.moptimize_file, m17572a.getAbsolutePath());
                    } else {
                        mo3984d(R.string.enc_success, m17572a.getAbsolutePath());
                    }
                    return true;
                }
                if (createTempFile3.exists()) {
                    createTempFile3.delete();
                }
                mo3979a(R.string.errorf, new StringBuffer().append("code=").append(m17570a).toString());
                return false;
            } catch (Exception e3) {
                mo3979a(R.string.errorf, e3.getMessage());
                return false;
            }
        } catch (Error e4) {
            mo3979a(R.string.errorf, e4.getMessage());
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        MainActivity.m16615o().m16644z();
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: a */
    private File m17572a(File file, String str) {
        String str2;
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15758c, file)) || C3102bd.m18925a(this.f15758c, "all_to_out_dir", false)) {
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
        if (this.f15761f) {
            str2 = "_opt";
        } else {
            str2 = "_obf";
        }
        return new File(parent, C3262u.m19623b(this.f15758c, parent, str, str2, 0));
    }

    /* renamed from: a */
    private int m17570a(File file, File file2) {
        C0518d c0518d = C0518d.f3579w;
        String m18910a = C3102bd.m18910a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_target_densities").toString(), "");
        String m18910a2 = C3102bd.m18910a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_configurations_include").toString(), "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3102bd.f18278N);
        for (int i = 0; i < this.f15756a.length; i++) {
            if (i != 1 || c0518d.f3584e) {
                if (this.f15761f && i > 1) {
                    break;
                }
                arrayList.add(C3257q.m19520b(this.f15756a[i], this.f15760e));
            }
        }
        if (C3102bd.m18925a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_densities_enable").toString(), false) && !m18910a.isEmpty()) {
            arrayList.add(C3257q.m19520b(this.f15757b[0], this.f15760e));
            arrayList.add(m18910a);
            mo3984d(R.string.label_den, m18910a);
        }
        if (C3102bd.m18925a(this.f15758c, new StringBuffer().append(this.f15762g).append("aapt2_configurations_enable").toString(), false) && !m18910a2.isEmpty()) {
            arrayList.add(C3257q.m19520b(this.f15757b[1], this.f15760e));
            arrayList.add(m18910a2);
            mo3984d(R.string.label_config, m18910a2);
        }
        arrayList.add(C3257q.m19520b(this.f15757b[2], this.f15760e));
        arrayList.add(file2.getAbsolutePath());
        arrayList.add(file.getAbsolutePath());
        Process start = new ProcessBuilder(arrayList).start();
        new C3111bm(start.getErrorStream(), 2, this).start();
        new C3111bm(start.getInputStream(), 1, this).start();
        return start.waitFor();
    }

    /* renamed from: b */
    private void m17574b(File file, File file2) {
        boolean z;
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(file2));
        m19496a.m16215a(C3102bd.f18315aw);
        C2604w c2604w = new C2604w(file);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (!nextElement.isDirectory() && name.startsWith("lib/") && this.f15766k && this.f15767l != null) {
                String[] strArr = this.f15767l;
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        z = false;
                        break;
                    }
                    if (name.startsWith(new StringBuffer().append(new StringBuffer().append("lib/").append(strArr[i]).toString()).append("/").toString())) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                }
            }
            if (this.f15759d == 0 || (!name.toUpperCase().matches("^META-INF/.+\\.(RSA|DSA|EC|SF)$") && !name.equalsIgnoreCase("META-INF/MANIFEST.MF") && !name.equals(AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME))) {
                if (AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(name) && (this.f15763h > 0 || this.f15764i > 0)) {
                    File createTempFile = File.createTempFile("unchanged", ".xml", C3102bd.m18908a());
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile), bArr.length);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    File createTempFile2 = File.createTempFile("changed", ".xml", C3102bd.m18908a());
                    try {
                        m17576c(createTempFile, createTempFile2);
                    } catch (Exception e2) {
                    }
                    C2602u c2602u = new C2602u(name);
                    c2602u.setCrc(C3117bs.m19055a(createTempFile2));
                    c2602u.setTime(nextElement.getTime());
                    c2602u.setMethod(8);
                    c2602u.setCompressedSize(-1L);
                    m19496a.mo16214a(c2602u);
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(createTempFile2), bArr.length);
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
                    createTempFile.delete();
                    createTempFile2.delete();
                } else {
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
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
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

    /* renamed from: c */
    private void m17576c(File file, File file2) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass2(this, c0548d, new boolean[]{false}, new boolean[]{false, false}));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: EncRes.java */
    /* renamed from: ru.maximoff.apktool.e.s$2, reason: invalid class name */
    class AnonymousClass2 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2948s f15773a;

        /* renamed from: b */
        private final boolean[] f15774b;

        /* renamed from: c */
        private final boolean[] f15775c;

        AnonymousClass2(AsyncTaskC2948s asyncTaskC2948s, AbstractC0549e abstractC0549e, boolean[] zArr, boolean[] zArr2) {
            super(abstractC0549e);
            this.f15773a = asyncTaskC2948s;
            this.f15774b = zArr;
            this.f15775c = zArr2;
        }

        /* renamed from: a */
        static AsyncTaskC2948s m17578a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f15773a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2), this.f15774b, this.f15775c, str);
        }

        /* compiled from: EncRes.java */
        /* renamed from: ru.maximoff.apktool.e.s$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass2 f15776a;

            /* renamed from: b */
            private final boolean[] f15777b;

            /* renamed from: c */
            private final boolean[] f15778c;

            /* renamed from: e */
            private final String f15779e;

            AnonymousClass1(AnonymousClass2 anonymousClass2, AbstractC0549e abstractC0549e, boolean[] zArr, boolean[] zArr2, String str) {
                super(abstractC0549e);
                this.f15776a = anonymousClass2;
                this.f15777b = zArr;
                this.f15778c = zArr2;
                this.f15779e = str;
            }

            /* renamed from: a */
            static AnonymousClass2 m17579a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15776a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equalsIgnoreCase("application")) {
                    return new C33941(this, super.mo4019a(str, str2));
                }
                if (str2.equalsIgnoreCase("uses-sdk")) {
                    this.f15777b[0] = true;
                    return new AbstractC0549e(this, super.mo4019a(str, str2), this.f15778c) { // from class: ru.maximoff.apktool.e.s.2.1.2

                        /* renamed from: a */
                        private final AnonymousClass1 f15783a;

                        /* renamed from: b */
                        private final boolean[] f15784b;

                        {
                            this.f15783a = this;
                            this.f15784b = r3;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            Object obj2;
                            int i3 = 16;
                            if (str4.equalsIgnoreCase("minSdkVersion") && AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15763h > 0) {
                                Integer num = new Integer(AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15763h);
                                this.f15784b[0] = true;
                                obj2 = num;
                            } else if (!str4.equalsIgnoreCase("targetSdkVersion") || AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15764i <= 0) {
                                obj2 = obj;
                                i3 = i2;
                            } else {
                                Integer num2 = new Integer(AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15764i);
                                this.f15784b[1] = true;
                                obj2 = num2;
                            }
                            super.mo4032a(str3, str4, i, i3, obj2);
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4024a() {
                            if (AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15763h > 0 && !this.f15784b[0]) {
                                int identifier = AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15758c.getResources().getIdentifier("minSdkVersion", C0497h.f3457a, "android");
                                if (identifier == 0) {
                                    identifier = C0012R.attr.minSdkVersion;
                                }
                                super.mo4032a("http://schemas.android.com/apk/res/android", "minSdkVersion", identifier, 16, new Integer(AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15763h));
                                this.f15784b[0] = true;
                            }
                            if (AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15764i > 0 && !this.f15784b[1]) {
                                int identifier2 = AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15758c.getResources().getIdentifier("targetSdkVersion", C0497h.f3457a, "android");
                                if (identifier2 == 0) {
                                    identifier2 = C0012R.attr.targetSdkVersion;
                                }
                                super.mo4032a("http://schemas.android.com/apk/res/android", "targetSdkVersion", identifier2, 16, new Integer(AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15783a)).f15764i));
                                this.f15784b[1] = true;
                            }
                            super.mo4024a();
                        }
                    };
                }
                return super.mo4019a(str, str2);
            }

            /* compiled from: EncRes.java */
            /* renamed from: ru.maximoff.apktool.e.s$2$1$1, reason: invalid class name and collision with other inner class name */
            class C33941 extends AbstractC0549e {

                /* renamed from: a */
                private final AnonymousClass1 f15780a;

                C33941(AnonymousClass1 anonymousClass1, AbstractC0549e abstractC0549e) {
                    super(abstractC0549e);
                    this.f15780a = anonymousClass1;
                }

                /* renamed from: a */
                static AnonymousClass1 m17580a(C33941 c33941) {
                    return c33941.f15780a;
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public void mo4032a(String str, String str2, int i, int i2, Object obj) {
                    super.mo4032a(str, str2, i, i2, obj);
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public AbstractC0549e mo4019a(String str, String str2) {
                    if (AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15780a)).f15764i < 31 || AnonymousClass2.m17578a(AnonymousClass1.m17579a(this.f15780a)).f15765j >= 31) {
                        return super.mo4019a(str, str2);
                    }
                    for (String str3 : C3249i.f19544d) {
                        if (str2.equals(str3)) {
                            return new AbstractC0549e(this, super.mo4019a(str, str2), new boolean[]{false}) { // from class: ru.maximoff.apktool.e.s.2.1.1.1

                                /* renamed from: a */
                                private final C33941 f15781a;

                                /* renamed from: b */
                                private final boolean[] f15782b;

                                {
                                    this.f15781a = this;
                                    this.f15782b = r3;
                                }

                                @Override // p060c.p061a.p062a.AbstractC0549e
                                /* renamed from: a */
                                public void mo4032a(String str4, String str5, int i, int i2, Object obj) {
                                    if (str5.equals("exported") && i2 == 18) {
                                        this.f15782b[0] = true;
                                    }
                                    super.mo4032a(str4, str5, i, i2, obj);
                                }

                                @Override // p060c.p061a.p062a.AbstractC0549e
                                /* renamed from: a */
                                public void mo4024a() {
                                    if (!this.f15782b[0]) {
                                        int identifier = AnonymousClass2.m17578a(AnonymousClass1.m17579a(C33941.m17580a(this.f15781a))).f15758c.getResources().getIdentifier("exported", C0497h.f3457a, "android");
                                        if (identifier == 0) {
                                            identifier = C0012R.attr.exported;
                                        }
                                        super.mo4032a("http://schemas.android.com/apk/res/android", "exported", identifier, 18, new Integer(1));
                                    }
                                    this.f15782b[0] = false;
                                    super.mo4024a();
                                }
                            };
                        }
                    }
                    return super.mo4019a(str, str2);
                }
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public void mo4024a() {
                if ((AnonymousClass2.m17578a(this.f15776a).f15763h > 0 || AnonymousClass2.m17578a(this.f15776a).f15764i > 0) && !this.f15777b[0]) {
                    AbstractC0549e mo4019a = mo4019a(this.f15779e, "uses-sdk");
                    if (AnonymousClass2.m17578a(this.f15776a).f15763h > 0) {
                        int identifier = AnonymousClass2.m17578a(this.f15776a).f15758c.getResources().getIdentifier("minSdkVersion", C0497h.f3457a, "android");
                        if (identifier == 0) {
                            identifier = C0012R.attr.minSdkVersion;
                        }
                        mo4019a.mo4032a("http://schemas.android.com/apk/res/android", "minSdkVersion", identifier, 16, new Integer(AnonymousClass2.m17578a(this.f15776a).f15763h));
                        this.f15778c[0] = true;
                    }
                    if (AnonymousClass2.m17578a(this.f15776a).f15764i > 0) {
                        int identifier2 = AnonymousClass2.m17578a(this.f15776a).f15758c.getResources().getIdentifier("targetSdkVersion", C0497h.f3457a, "android");
                        if (identifier2 == 0) {
                            identifier2 = C0012R.attr.targetSdkVersion;
                        }
                        mo4019a.mo4032a("http://schemas.android.com/apk/res/android", "targetSdkVersion", identifier2, 16, new Integer(AnonymousClass2.m17578a(this.f15776a).f15764i));
                        this.f15778c[1] = true;
                    }
                    mo4019a.mo4024a();
                    this.f15777b[0] = true;
                }
                super.mo4024a();
            }
        }
    }
}
