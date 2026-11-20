package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.p008os.AsyncTask;
import android.provider.MediaStore;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.util.List;
import java.util.logging.Level;
import org.p226d.p227a.C1913a;
import org.p226d.p227a.C1950b;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.p234a.C1970e;
import org.p226d.p233b.p234a.C1971f;
import org.p226d.p233b.p244d.C2162p;
import org.p226d.p233b.p250e.InterfaceC2264e;
import p046b.p047a.C0455a;
import p046b.p047a.C0466c;
import p046b.p047a.C0518d;
import p046b.p058c.C0530e;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p303a.C3065e;

/* compiled from: DecodeTask.java */
/* renamed from: ru.maximoff.apktool.e.k */
/* loaded from: classes.dex */
public class AsyncTaskC2940k extends AbstractAsyncTaskC2898a {

    /* renamed from: b */
    private static Context f15667b;

    /* renamed from: c */
    private static boolean f15668c;

    /* renamed from: d */
    private static boolean f15669d;

    /* renamed from: f */
    private static File f15670f;

    /* renamed from: a */
    private final String f15671a;

    /* renamed from: e */
    private InterfaceC2995n f15672e;

    /* renamed from: g */
    private boolean f15673g;

    /* renamed from: h */
    private boolean f15674h;

    /* renamed from: i */
    private boolean f15675i;

    /* renamed from: j */
    private boolean f15676j;

    /* renamed from: k */
    private int f15677k;

    /* renamed from: l */
    private int f15678l;

    public AsyncTaskC2940k(Context context, InterfaceC2995n interfaceC2995n, String str) {
        super(context, interfaceC2995n);
        f15667b = context;
        this.f15672e = interfaceC2995n;
        this.f15671a = str != null ? C3112bn.m19033h(str).replaceAll("\\s", "_") : str;
        f15668c = false;
        f15669d = false;
        this.f15673g = true;
        this.f15674h = false;
        this.f15675i = false;
        this.f15676j = C3102bd.m18925a(context, "add_nomedia", true);
        if (C3102bd.m18925a(context, "try_merge_res", false)) {
            this.f15677k = 3;
        } else {
            this.f15677k = 0;
        }
        this.f15678l = 1;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (C3102bd.m18925a(f15667b, "ongoing_notification", true)) {
            m17054a(f15667b.getString(mo17065c()), "decompile_task");
        }
    }

    /* renamed from: g */
    public void m17508g(boolean z) {
        this.f15673g = z;
    }

    /* renamed from: h */
    public void m17509h(boolean z) {
        this.f15674h = z;
    }

    /* renamed from: i */
    public void m17510i(boolean z) {
        this.f15675i = z;
    }

    /* renamed from: a */
    public void m17506a(int i) {
        this.f15677k = i;
    }

    /* renamed from: j */
    public void m17511j(boolean z) {
        this.f15676j = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.decode_run_title;
    }

    /* renamed from: k */
    public void m17512k(boolean z) {
        f15668c = z;
    }

    /* renamed from: l */
    public void m17513l(boolean z) {
        f15669d = z;
    }

    /* renamed from: b */
    public void m17507b(int i) {
        this.f15678l = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        return super.mo17049a(fileArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9 A[Catch: Error -> 0x0144, Exception -> 0x0175, TryCatch #4 {Error -> 0x0144, Exception -> 0x0175, blocks: (B:37:0x00d1, B:39:0x00da, B:41:0x00de, B:43:0x00e9, B:44:0x00ff, B:46:0x010a, B:47:0x0120, B:49:0x012d, B:51:0x0131, B:52:0x0134, B:54:0x013a, B:56:0x013f), top: B:36:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010a A[Catch: Error -> 0x0144, Exception -> 0x0175, TryCatch #4 {Error -> 0x0144, Exception -> 0x0175, blocks: (B:37:0x00d1, B:39:0x00da, B:41:0x00de, B:43:0x00e9, B:44:0x00ff, B:46:0x010a, B:47:0x0120, B:49:0x012d, B:51:0x0131, B:52:0x0134, B:54:0x013a, B:56:0x013f), top: B:36:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156  */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean mo17058a(File file) {
        int i;
        int i2;
        C0466c c0466c;
        C0530e m17498a = m17498a(file, this.f15671a, this);
        if (m17498a == null) {
            return false;
        }
        mo3984d(R.string.mplease_wait, (Object) null);
        try {
            C3081am c3081am = new C3081am(file);
            i = c3081am.m18633i();
            try {
                i2 = c3081am.m18632h();
            } catch (Exception e2) {
                i2 = 14;
                if (i < 1) {
                }
                if (i2 < 1) {
                }
                C0542g.m3987a(m17498a);
                m17498a.mkdirs();
                m17060b(m17498a);
                if (this.f15676j) {
                    m17505d(m17498a);
                }
                C0530e c0530e = new C0530e(file);
                C0455a c0455a = new C0455a(C0518d.f3579w, this);
                c0455a.m3508b(!AbstractAsyncTaskC2898a.m17036f() ? true : C3102bd.m18925a(f15667b, "add_dummy", false));
                c0455a.m3517d(AbstractAsyncTaskC2898a.m17036f());
                c0455a.m3482a(this.f15677k);
                c0455a.m3496a(C3102bd.m18925a(f15667b, "keep_structure", false));
                c0455a.m3514c(C3102bd.m18925a(f15667b, "perm_description", true));
                c0466c = new C0466c(c0530e, c0455a, this);
                c0466c.m3559a(this.f15675i);
                c0466c.m3557a(m17504c(this.f15671a != null ? file.getName() : this.f15671a));
                c0466c.m3565b(C3102bd.m18925a(f15667b, "mBakdeb", true));
                c0466c.m3569d((short) 1);
                if (!this.f15673g) {
                }
                if (!this.f15673g) {
                }
                if (!this.f15674h) {
                }
                c0466c.m3563b(m17498a);
                c0466c.m3562b(i2);
                c0466c.m3555a(i);
                c0466c.m3568c(true);
                c0466c.m3570d(C3102bd.m18925a(f15667b, "keep_broken_res", false));
                c0466c.m3554a();
                if (!AbstractAsyncTaskC2898a.m17036f()) {
                    if (C3102bd.m18925a(f15667b, "clear_split", false)) {
                    }
                    if (C3102bd.m18925a(f15667b, "remove_property", false)) {
                    }
                }
                if (!new File(m17498a, "smali").exists()) {
                    m17501a(file, m17498a);
                }
                return AbstractAsyncTaskC2898a.m17036f() ? true : true;
            }
        } catch (Exception e3) {
            i = 14;
        }
        if (i < 1) {
            i = 14;
        }
        if (i2 < 1) {
            i2 = 14;
        }
        C0542g.m3987a(m17498a);
        m17498a.mkdirs();
        m17060b(m17498a);
        if (this.f15676j && m17498a.exists()) {
            m17505d(m17498a);
        }
        C0530e c0530e2 = new C0530e(file);
        C0455a c0455a2 = new C0455a(C0518d.f3579w, this);
        c0455a2.m3508b(!AbstractAsyncTaskC2898a.m17036f() ? true : C3102bd.m18925a(f15667b, "add_dummy", false));
        c0455a2.m3517d(AbstractAsyncTaskC2898a.m17036f());
        c0455a2.m3482a(this.f15677k);
        c0455a2.m3496a(C3102bd.m18925a(f15667b, "keep_structure", false));
        c0455a2.m3514c(C3102bd.m18925a(f15667b, "perm_description", true));
        c0466c = new C0466c(c0530e2, c0455a2, this);
        c0466c.m3559a(this.f15675i);
        c0466c.m3557a(m17504c(this.f15671a != null ? file.getName() : this.f15671a));
        c0466c.m3565b(C3102bd.m18925a(f15667b, "mBakdeb", true));
        c0466c.m3569d((short) 1);
        if (!this.f15673g) {
            c0466c.m3567c((short) 1);
        } else {
            c0466c.m3567c((short) 0);
        }
        if (!this.f15673g) {
            c0466c.m3564b((short) 257);
        } else {
            c0466c.m3564b((short) 256);
        }
        if (!this.f15674h) {
            c0466c.m3558a((short) 1);
        } else {
            c0466c.m3558a((short) 0);
        }
        c0466c.m3563b(m17498a);
        c0466c.m3562b(i2);
        c0466c.m3555a(i);
        c0466c.m3568c(true);
        c0466c.m3570d(C3102bd.m18925a(f15667b, "keep_broken_res", false));
        try {
            c0466c.m3554a();
            if (!AbstractAsyncTaskC2898a.m17036f() && this.f15673g) {
                if (C3102bd.m18925a(f15667b, "clear_split", false)) {
                    mo3984d(R.string.clear_split, (Object) null);
                    m17502a(m17498a.getAbsolutePath());
                }
                if (C3102bd.m18925a(f15667b, "remove_property", false)) {
                    mo3984d(R.string.remove_property, (Object) null);
                    m17503b(m17498a.getAbsolutePath());
                }
            }
            if (!new File(m17498a, "smali").exists() && this.f15674h) {
                m17501a(file, m17498a);
            }
            if (AbstractAsyncTaskC2898a.m17036f() && this.f15677k == 3) {
                C3065e.m18356a(m17498a, this);
                return true;
            }
        } catch (Error e4) {
            mo3980a(Level.SEVERE, e4.getMessage(), e4);
            return false;
        } catch (Exception e5) {
            mo3980a(Level.WARNING, e5.getMessage(), e5);
            return false;
        }
    }

    /* renamed from: a */
    private void m17502a(String str) {
        File file = new File(new StringBuffer().append(str).append("/res/values/public.xml").toString());
        File file2 = new File(new StringBuffer().append(str).append("/AndroidManifest.xml").toString());
        if (file2.isFile()) {
            String m18330g = C3061a.m18330g(file2);
            if (m18330g != null) {
                new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append("/res/xml/").toString()).append(m18330g).toString()).append(".xml").toString()).delete();
            }
            String m18332i = C3061a.m18332i(file2);
            C3061a.m18319b(file2, C3061a.m18314b(C3061a.m18315b(m18332i, C3061a.m18298a(m18332i))));
            if (file.isFile()) {
                C3061a.m18309a(file, m18330g, (String) null);
            }
        }
    }

    /* renamed from: b */
    private void m17503b(String str) {
        File file = new File(new StringBuffer().append(str).append("/AndroidManifest.xml").toString());
        if (file.isFile()) {
            String m18332i = C3061a.m18332i(file);
            C3061a.m18319b(file, C3061a.m18323c(m18332i, C3061a.m18298a(m18332i)));
        }
    }

    /* renamed from: c */
    private String m17504c(String str) {
        String m19033h = C3112bn.m19033h(C3102bd.m18910a(f15667b, "suffix_apk", "_src"));
        if (C3112bn.m19040o(str)) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("out_").append(System.currentTimeMillis()).toString()).append(m19033h).toString()).append(".apk").toString();
        }
        if (str.toLowerCase().endsWith(".apk")) {
            String[] m19641b = C3262u.m19641b(str);
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m19641b[0]).append(m19033h).toString()).append(".").toString()).append(m19641b[1]).toString();
        }
        return new StringBuffer().append(new StringBuffer().append(str).append(m19033h).toString()).append(".apk").toString();
    }

    /* renamed from: d */
    private boolean m17505d(File file) {
        try {
            File file2 = new File(file, MediaStore.MEDIA_IGNORE_FILENAME);
            if (!file2.isFile()) {
                file2.createNewFile();
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    private void m17501a(File file, File file2) {
        File file3;
        mo3984d(R.string.text, "Find odex file...");
        File m17499a = m17499a(file.getParentFile(), ".odex");
        if (m17499a == null) {
            mo3983c(R.string.text, "Odex file not found");
            return;
        }
        mo3984d(R.string.text, m17499a);
        FileInputStream fileInputStream = new FileInputStream(m17499a);
        C2162p m14809a = C2162p.m14809a(new BufferedInputStream(fileInputStream), new C2016c.c(m17499a));
        fileInputStream.close();
        List<String> mo14511a = m14809a.mo14511a();
        C1950b c1950b = new C1950b();
        c1950b.f11357c = !C3102bd.f18313au;
        c1950b.f11358d = true;
        c1950b.f11362h = true;
        c1950b.f11364j = true;
        c1950b.f11363i = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= mo14511a.size()) {
                return;
            }
            String str = mo14511a.get(i2);
            C2162p.e mo14513b = m14809a.mo14513b(str);
            c1950b.f11369o = m17500a(m17499a, mo14513b, m14809a.m14819b());
            if (c1950b.f11369o != null) {
                if (i2 == 0) {
                    file3 = new File(file2, "smali");
                } else {
                    file3 = new File(file2, String.format("smali_classes%d", new Integer(i2 + 1)));
                }
                file3.mkdirs();
                mo3984d(R.string.text, String.format("Decode %s to %s", str, file3));
                C1913a.m14083a(mo14513b, file3, C3102bd.f18299ag, c1950b);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private static C1970e m17500a(File file, InterfaceC2264e interfaceC2264e, int i) {
        String stringBuffer = new StringBuffer().append("/system/framework/").append(file.getParentFile().getName()).toString();
        AbstractC1208w m10130a = AbstractC1208w.m10130a(stringBuffer);
        AbstractC1208w.a aVar = new AbstractC1208w.a();
        File[] listFiles = new File(stringBuffer).listFiles();
        if (listFiles == null) {
            return (C1970e) null;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (name.endsWith(".oat")) {
                aVar.mo9809a(name);
            }
        }
        return new C1970e(new C1971f(m10130a, aVar.m10144a(), AbstractC1208w.m10138g(), interfaceC2264e).m14286a(), true, i);
    }

    /* renamed from: a */
    private File m17499a(File file, String str) {
        if (file.isDirectory()) {
            if (file.listFiles() == null) {
                return (File) null;
            }
            for (File file2 : file.listFiles()) {
                File m17499a = m17499a(file2, str);
                if (m17499a != null) {
                    return m17499a;
                }
            }
        } else if (file.getName().endsWith(str)) {
            return file;
        }
        return (File) null;
    }

    /* renamed from: a */
    public static C0530e m17498a(File file, String str, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String stringBuffer;
        String parent = file.getParent();
        if (str == null) {
            stringBuffer = file.getName();
        } else {
            stringBuffer = new StringBuffer().append(str).append(new StringBuffer().append("_").append(file.getName()).toString()).toString();
        }
        int lastIndexOf = stringBuffer.lastIndexOf(46);
        if (lastIndexOf > 0) {
            stringBuffer = stringBuffer.substring(0, lastIndexOf);
        }
        boolean m18925a = C3102bd.m18925a(f15667b, "overwrite_apk", false);
        boolean m18925a2 = C3102bd.m18925a(f15667b, "all_to_out_dir", false);
        boolean m19670j = C3262u.m19670j(f15667b, file);
        boolean z = !C3262u.m19664g(f15667b, file);
        if ((m18925a2 || m19670j || z) && !AbstractAsyncTaskC2898a.m17036f()) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_set, new Object[0]);
                return (C0530e) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_extsts, parent);
                return (C0530e) null;
            }
            if (!file2.isDirectory()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.not_directory, parent);
                return (C0530e) null;
            }
        }
        String str2 = parent;
        f15670f = file.getParentFile();
        String stringBuffer2 = new StringBuffer().append(stringBuffer).append(AbstractAsyncTaskC2898a.m17036f() ? "" : "_src").toString();
        if (!m18925a) {
            stringBuffer2 = C3262u.m19566a(f15667b, str2, stringBuffer2, "", 0);
        }
        return new C0530e(str2, stringBuffer2);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return !AbstractAsyncTaskC2898a.m17036f();
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (AbstractAsyncTaskC2898a.m17036f() && !mo3981a()) {
            long k = m17077k();
            AsyncTaskC2925b asyncTaskC2925b = new AsyncTaskC2925b(f15667b, this.f15672e, this.f15678l);
            asyncTaskC2925b.m17050a(k);
            asyncTaskC2925b.m17397a(this.f15677k);
            asyncTaskC2925b.m17405g(f15668c);
            asyncTaskC2925b.m17406h(f15669d);
            try {
                asyncTaskC2925b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, f15670f);
                return;
            } catch (Exception e2) {
                C3112bn.m18999a(f15667b, R.string.error_try_again);
                return;
            }
        }
        if (C3102bd.m18925a(f15667b, "build_notification", true)) {
            m17072f(bool.booleanValue());
        }
    }
}
