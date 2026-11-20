package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.C0455a;
import p046b.p047a.C0518d;
import p046b.p047a.p049b.C0462a;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: BuildTask.java */
/* renamed from: ru.maximoff.apktool.e.e */
/* loaded from: classes.dex */
public class AsyncTaskC2934e extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final C2917as f15609a;

    /* renamed from: b */
    private Context f15610b;

    /* renamed from: c */
    private File f15611c;

    /* renamed from: d */
    private InterfaceC2995n f15612d;

    /* renamed from: e */
    private boolean f15613e;

    /* renamed from: f */
    private boolean f15614f;

    public AsyncTaskC2934e(Context context, InterfaceC2995n interfaceC2995n, C2917as c2917as, boolean z) {
        super(context, interfaceC2995n);
        this.f15609a = c2917as;
        this.f15613e = z;
        this.f15614f = C3102bd.m18925a(context, "build_checksums", false);
        this.f15610b = context;
        this.f15612d = interfaceC2995n;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (C3102bd.m18925a(this.f15610b, "ongoing_notification", true)) {
            m17054a(this.f15610b.getString(mo17065c()), "build_task");
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.build_run_title;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4 A[Catch: all -> 0x01be, TryCatch #3 {all -> 0x01be, blocks: (B:5:0x0037, B:7:0x0041, B:8:0x005f, B:10:0x0063, B:12:0x0067, B:14:0x0074, B:16:0x0081, B:17:0x0093, B:19:0x00a4, B:20:0x00a7, B:22:0x00ad, B:24:0x00b3, B:28:0x015d, B:30:0x0166, B:32:0x019a, B:34:0x019e, B:36:0x01aa, B:37:0x01b8, B:38:0x018b, B:45:0x016a, B:47:0x0171, B:49:0x0175, B:51:0x0182, B:53:0x0188, B:56:0x014a, B:58:0x00b8, B:60:0x00c3, B:62:0x00c7, B:64:0x00d6, B:67:0x00db, B:69:0x00e6, B:71:0x00ec, B:73:0x00fe, B:76:0x0103, B:78:0x0109, B:80:0x011b, B:83:0x0120, B:84:0x0134), top: B:4:0x0037, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad A[Catch: all -> 0x01be, TryCatch #3 {all -> 0x01be, blocks: (B:5:0x0037, B:7:0x0041, B:8:0x005f, B:10:0x0063, B:12:0x0067, B:14:0x0074, B:16:0x0081, B:17:0x0093, B:19:0x00a4, B:20:0x00a7, B:22:0x00ad, B:24:0x00b3, B:28:0x015d, B:30:0x0166, B:32:0x019a, B:34:0x019e, B:36:0x01aa, B:37:0x01b8, B:38:0x018b, B:45:0x016a, B:47:0x0171, B:49:0x0175, B:51:0x0182, B:53:0x0188, B:56:0x014a, B:58:0x00b8, B:60:0x00c3, B:62:0x00c7, B:64:0x00d6, B:67:0x00db, B:69:0x00e6, B:71:0x00ec, B:73:0x00fe, B:76:0x0103, B:78:0x0109, B:80:0x011b, B:83:0x0120, B:84:0x0134), top: B:4:0x0037, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015d A[Catch: all -> 0x01be, TryCatch #3 {all -> 0x01be, blocks: (B:5:0x0037, B:7:0x0041, B:8:0x005f, B:10:0x0063, B:12:0x0067, B:14:0x0074, B:16:0x0081, B:17:0x0093, B:19:0x00a4, B:20:0x00a7, B:22:0x00ad, B:24:0x00b3, B:28:0x015d, B:30:0x0166, B:32:0x019a, B:34:0x019e, B:36:0x01aa, B:37:0x01b8, B:38:0x018b, B:45:0x016a, B:47:0x0171, B:49:0x0175, B:51:0x0182, B:53:0x0188, B:56:0x014a, B:58:0x00b8, B:60:0x00c3, B:62:0x00c7, B:64:0x00d6, B:67:0x00db, B:69:0x00e6, B:71:0x00ec, B:73:0x00fe, B:76:0x0103, B:78:0x0109, B:80:0x011b, B:83:0x0120, B:84:0x0134), top: B:4:0x0037, inners: #0 }] */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean mo17058a(File file) {
        String str;
        File file2;
        File file3;
        InterfaceC0008c m18971b;
        mo3984d(R.string.mplease_wait, (Object) null);
        C0518d c0518d = C0518d.f3579w;
        C0455a c0455a = new C0455a(c0518d, this);
        c0455a.m3517d(AbstractAsyncTaskC2898a.m17036f());
        try {
            File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
            File createTempFile2 = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
            try {
                C0462a m3479a = c0455a.m3479a(file, createTempFile);
                if (AbstractAsyncTaskC2898a.m17036f()) {
                    file2 = file.getParentFile().getParentFile();
                    String m19623b = C3262u.m19623b(this.f15610b, file2.getAbsolutePath(), m3479a.f3281b, "_antisplit", 0);
                    this.f15611c = file.getParentFile();
                    str = m19623b;
                } else if (C3102bd.m18925a(this.f15610b, "build_toout", false)) {
                    String str2 = C3102bd.f18339v;
                    if (str2 == null) {
                        mo3983c(R.string.output_directory_not_set, new Object[0]);
                        if (createTempFile2.exists()) {
                            createTempFile2.delete();
                        }
                        return false;
                    }
                    file2 = new File(str2);
                    if (!file2.exists() && !file2.mkdirs()) {
                        mo3983c(R.string.output_directory_not_extsts, str2);
                        if (createTempFile2.exists()) {
                            createTempFile2.delete();
                        }
                        return false;
                    }
                    if (!file2.isDirectory()) {
                        mo3983c(R.string.not_directory, str2);
                        if (createTempFile2.exists()) {
                            createTempFile2.delete();
                        }
                        return false;
                    }
                    String m19623b2 = C3262u.m19623b(this.f15610b, file2.getAbsolutePath(), m3479a.f3281b, "", 0);
                    this.f15611c = file;
                    str = m19623b2;
                } else {
                    String m19623b3 = C3262u.m19623b(this.f15610b, file.getAbsolutePath(), m3479a.f3281b, "", 0);
                    this.f15611c = file;
                    str = m19623b3;
                    file2 = file;
                }
                if (this.f15614f && m3479a.f3282c != null) {
                    File file4 = new File(m3479a.f3282c);
                    if (file4.isFile()) {
                        file3 = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                        try {
                            m17466c(createTempFile.getAbsolutePath(), file3.getAbsolutePath(), file4.getAbsolutePath());
                            createTempFile.delete();
                        } catch (Exception e2) {
                            mo3979a(R.string.errorf, e2.getMessage());
                            file3 = createTempFile;
                        }
                        C3317a.m20052a(file3.getAbsolutePath(), createTempFile2.getAbsolutePath());
                        if (file3.exists()) {
                            file3.delete();
                        }
                        if (!mo3981a()) {
                            if (createTempFile2.exists()) {
                                createTempFile2.delete();
                            }
                            return false;
                        }
                        File file5 = new File(file2, str);
                        if (this.f15613e || c0518d.f3585f) {
                            C3262u.m19612a(createTempFile2, file5);
                            if (c0518d.f3585f && c0518d.f3586g) {
                                File file6 = new File(file, "original/signature.data");
                                if (file6.isFile() && (m18971b = C3105bg.m18971b(file6)) != null) {
                                    C3105bg.m18967a(file5, m18971b);
                                }
                            }
                        } else {
                            this.f15609a.m17321a(createTempFile2, file5, (m3479a.f3285f == null || m3479a.f3285f.get("minSdkVersion") == null) ? 14 : Integer.parseInt(m3479a.f3285f.get("minSdkVersion")), this);
                        }
                        m17060b(file5);
                        return true;
                    }
                }
                file3 = createTempFile;
                C3317a.m20052a(file3.getAbsolutePath(), createTempFile2.getAbsolutePath());
                if (file3.exists()) {
                }
                if (!mo3981a()) {
                }
            } finally {
                if (createTempFile2.exists()) {
                    createTempFile2.delete();
                }
            }
        } catch (Error e3) {
            mo3980a(Level.SEVERE, e3.getMessage(), e3);
            return false;
        } catch (Exception e4) {
            mo3980a(Level.WARNING, e4.getMessage(), e4);
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        boolean booleanValue = super.mo17049a(fileArr).booleanValue();
        if (booleanValue) {
            if (AbstractAsyncTaskC2898a.m17036f()) {
                mo3984d(R.string.deletion, this.f15611c.getAbsolutePath());
                C0542g.m3987a(this.f15611c);
            } else if (C3102bd.m18925a(this.f15610b, "delete_build", true)) {
                File file = new File(this.f15611c, "build");
                if (file.exists() && file.isDirectory()) {
                    mo3984d(R.string.deletion, file.getAbsolutePath());
                    C0542g.m3987a(file);
                }
            }
        }
        return new Boolean(booleanValue);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        AbstractAsyncTaskC2898a.m17030c(false);
        super.mo17061b(bool);
        if (C3102bd.m18925a(this.f15610b, "build_notification", true)) {
            m17072f(bool.booleanValue());
        }
        C3080al.m18565a(this.f15610b, bool.booleanValue());
    }

    /* renamed from: c */
    private void m17466c(String str, String str2, String str3) {
        long crc;
        mo3984d(R.string.checksums_original, new Object[0]);
        C2604w c2604w = new C2604w(str3);
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(true);
        C2604w c2604w2 = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w2.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            C2602u m16162a = c2604w.m16162a(name);
            if (m16162a != null) {
                crc = m16162a.getCrc();
            } else {
                crc = nextElement.getCrc();
            }
            C2602u c2602u = new C2602u(name);
            c2602u.setTime(nextElement.getTime());
            long size = nextElement.getSize();
            c2602u.setCrc(crc);
            if (nextElement.getMethod() == 0 && crc >= 0 && size >= 0) {
                c2602u.setMethod(0);
                c2602u.setSize(size);
                c2602u.setCompressedSize(size);
            } else {
                c2602u.setMethod(8);
                c2602u.setCompressedSize(-1L);
            }
            m19496a.mo16214a(c2602u);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w2.m16160a(nextElement), bArr.length);
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
        c2604w2.close();
    }
}
