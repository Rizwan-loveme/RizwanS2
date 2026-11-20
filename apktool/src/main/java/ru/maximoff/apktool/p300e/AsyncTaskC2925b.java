package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.res.AssetManager;
import android.p008os.AsyncTask;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileOutputStream;
import java.p209io.FilenameFilter;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2467b;
import org.p270e.C2468c;
import p046b.p047a.C0455a;
import p046b.p047a.C0518d;
import p046b.p047a.p049b.C0462a;
import p046b.p047a.p050c.C0467a;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p303a.C3062b;
import ru.maximoff.apktool.util.p303a.C3063c;
import ru.maximoff.apktool.util.p303a.C3064d;
import ru.maximoff.apktool.util.p303a.C3065e;
import ru.maximoff.apktool.util.p306d.C3215e;

/* compiled from: AntiSplit.java */
/* renamed from: ru.maximoff.apktool.e.b */
/* loaded from: classes.dex */
public class AsyncTaskC2925b extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final int f15475a;

    /* renamed from: b */
    private Context f15476b;

    /* renamed from: c */
    private File f15477c;

    /* renamed from: d */
    private InterfaceC2995n f15478d;

    /* renamed from: e */
    private int f15479e;

    /* renamed from: f */
    private boolean f15480f;

    /* renamed from: g */
    private boolean f15481g;

    /* renamed from: h */
    private boolean f15482h;

    /* renamed from: i */
    private String f15483i;

    /* renamed from: j */
    private int f15484j;

    /* renamed from: k */
    private List<C3090av> f15485k;

    /* renamed from: l */
    private Map<String, C3063c> f15486l;

    /* renamed from: m */
    private int f15487m;

    public AsyncTaskC2925b(Context context, InterfaceC2995n interfaceC2995n, int i) {
        super(context, interfaceC2995n);
        this.f15475a = 2;
        this.f15476b = context;
        this.f15478d = interfaceC2995n;
        this.f15479e = i;
        this.f15483i = "base";
        this.f15484j = 0;
        this.f15487m = 0;
        this.f15480f = false;
        this.f15481g = false;
        this.f15485k = new ArrayList();
        this.f15482h = C0518d.f3579w.f3585f;
        AbstractAsyncTaskC2898a.m17030c(true);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (C3102bd.m18925a(this.f15476b, "ongoing_notification", true)) {
            m17054a(this.f15476b.getString(mo17065c()), "antisplit_task");
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.mmerge;
    }

    /* renamed from: g */
    public void m17405g(boolean z) {
        this.f15480f = z;
    }

    /* renamed from: h */
    public void m17406h(boolean z) {
        this.f15481g = z;
    }

    /* renamed from: a */
    public void m17397a(int i) {
        this.f15487m = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        String str;
        Map<Long, Long> map;
        mo3984d(R.string.mplease_wait, (Object) null);
        try {
            try {
                boolean z = false;
                File[] listFiles = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.1

                    /* renamed from: a */
                    private final AsyncTaskC2925b f15488a;

                    {
                        this.f15488a = this;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file2) {
                        return file2.isDirectory();
                    }
                });
                ArrayList<File> arrayList = new ArrayList();
                int i = 0;
                File file2 = (File) null;
                while (i < listFiles.length) {
                    File file3 = listFiles[i];
                    File file4 = new File(new StringBuffer().append(file3.getAbsolutePath()).append("/res/values/public.xml").toString());
                    boolean m17404e = m17404e(file3);
                    if (z) {
                        m17404e = z;
                    }
                    if (m17403d(file3)) {
                        mo3984d(R.string.mbase_dir, file3.getName());
                    } else {
                        if (file4.exists()) {
                            arrayList.add(file3);
                        }
                        file3 = file2;
                    }
                    i++;
                    file2 = file3;
                    z = m17404e;
                }
                if (file2 == null) {
                    mo3979a(R.string.base_not_found, new Object[0]);
                    return false;
                }
                C3060a c3060a = new C3060a(this.f15476b, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file2.getParent()).append("/").toString()).append(file2.getName()).toString()).append(".apk").toString());
                this.f15477c = file2;
                File file5 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("/res/values/public.xml").toString());
                File file6 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("/AndroidManifest.xml").toString());
                m17400a(file2, listFiles);
                C3062b c3062b = new C3062b(new File(file2, "changed_ids.json"));
                for (File file7 : listFiles) {
                    m17398a(file2, file7);
                    if (this.f15487m == 3) {
                        c3062b.m18341b(new File(file7, "changed_ids.json"));
                    }
                }
                mo3984d(R.string.mprepare, (Object) null);
                this.f15485k.addAll(C3061a.m18326d(file5));
                for (File file8 : arrayList) {
                    if (this.f15487m == 3) {
                        map = new C3062b(new File(file8, "changed_ids.json")).m18343d();
                    } else {
                        map = (Map) null;
                    }
                    this.f15485k = C3061a.m18307a(this.f15485k, C3061a.m18326d(new File(new StringBuffer().append(file8.getAbsolutePath()).append("/res/values/public.xml").toString())), map, false);
                }
                this.f15486l = C3061a.m18318b(new File(new StringBuffer().append(file2.getAbsolutePath()).append("/res/values/attrs.xml").toString()));
                mo3984d(R.string.resources_found, new Integer(this.f15485k.size()));
                ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18300ah);
                m17401b(file2, newFixedThreadPool, true);
                Iterator<E> it = arrayList.iterator();
                while (it.hasNext()) {
                    m17401b((File) it.next(), newFixedThreadPool, false);
                }
                m17399a(file2, newFixedThreadPool, true);
                Iterator<E> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    m17399a((File) it2.next(), newFixedThreadPool, false);
                }
                newFixedThreadPool.shutdown();
                do {
                    try {
                    } catch (InterruptedException e2) {
                        mo3979a(R.string.errorf, e2.toString());
                        return false;
                    }
                } while (!newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
                mo3984d(R.string.mprocessed, new Integer(this.f15484j));
                String m18330g = C3061a.m18330g(file6);
                if (m18330g != null) {
                    new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file2.getAbsolutePath()).append("/res/xml/").toString()).append(m18330g).toString()).append(".xml").toString()).delete();
                }
                String m19033h = this.f15480f ? C3112bn.m19033h(C3102bd.m18910a(this.f15476b, "suffix_apk", "_src")) : "";
                String stringBuffer = new StringBuffer().append("out_").append(C3112bn.m19032g("yyyyMMddHHmmss")).toString();
                if (c3060a.m18255D()) {
                    String m18910a = C3102bd.m18910a(this.f15476b, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})");
                    List<String> m17391f = m17391f(file2);
                    for (File file9 : listFiles) {
                        C3112bn.m19011a(m17391f, m17391f(file9));
                    }
                    Context context = this.f15476b;
                    if (m17391f.isEmpty()) {
                        m17391f = (List) null;
                    }
                    str = C3112bn.m19033h(C3112bn.m18993a(context, c3060a, m18910a, m17391f));
                } else {
                    str = stringBuffer;
                }
                try {
                    File file10 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("/apktool.json").toString());
                    C2468c m18351a = C3064d.m18351a(file10);
                    C2468c c2468c = new C2468c();
                    m18351a.m15608a("apkFileName", (Object) new StringBuffer().append(new StringBuffer().append(str).append(m19033h).toString()).append(".apk").toString());
                    if (!m18351a.m15619h("unknownFiles")) {
                        c2468c = m18351a.m15616e("unknownFiles");
                    }
                    c2468c.m15608a("ANTISPLIT_BY_APKTOOL_M.txt", (Object) "8");
                    m18351a.m15608a("unknownFiles", c2468c);
                    AssetManager assets = this.f15476b.getAssets();
                    File file11 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("/unknown").toString());
                    if (!file11.exists()) {
                        file11.mkdir();
                    }
                    File file12 = new File(file11, "ANTISPLIT_BY_APKTOOL_M.txt");
                    InputStream open = assets.open("tpl/as.tpl");
                    FileOutputStream fileOutputStream = new FileOutputStream(file12);
                    C1887e.m13962a(open, fileOutputStream);
                    open.close();
                    fileOutputStream.close();
                    C3064d.m18353a(file10, m18351a, 2);
                } catch (Exception e3) {
                    mo3983c(R.string.text, e3.toString());
                }
                m17402b(file2, listFiles);
                String m17395a = m17395a(file6, z);
                if (m17395a != null) {
                    File file13 = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file2.getAbsolutePath()).append("/res/xml/").toString()).append(m17395a).toString()).append(".xml").toString());
                    if (file13.exists()) {
                        file13.delete();
                    }
                }
                C3061a.m18310a(file5, this.f15485k, false, m18330g, m17395a);
                if (this.f15487m == 3) {
                    C3065e.m18356a(file2, this);
                }
                boolean z2 = true;
                if (this.f15480f) {
                    z2 = m17385a(new StringBuffer().append(str).append("_src").toString());
                }
                if (z2 && this.f15481g) {
                    return m17394l();
                }
                return z2;
            } catch (Error e4) {
                mo3980a(Level.SEVERE, e4.getMessage(), e4);
                return false;
            }
        } catch (Exception e5) {
            mo3979a(R.string.errorf, e5.toString());
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return this.f15480f;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (this.f15480f) {
            if (C3102bd.m18925a(this.f15476b, "build_notification", true)) {
                m17072f(bool.booleanValue());
            }
        } else if (this.f15477c != null && !mo3981a()) {
            C2917as.m17314a(this.f15476b, this.f15479e, new C2917as.a(this, m17077k()) { // from class: ru.maximoff.apktool.e.b.2

                /* renamed from: a */
                private final AsyncTaskC2925b f15491a;

                /* renamed from: b */
                private final long f15492b;

                {
                    this.f15491a = this;
                    this.f15492b = r2;
                }

                @Override // ru.maximoff.apktool.p300e.C2917as.a
                /* renamed from: a */
                public void mo16440a(C2917as c2917as, boolean z) {
                    AsyncTaskC2934e asyncTaskC2934e = new AsyncTaskC2934e(this.f15491a.f15476b, this.f15491a.f15478d, c2917as, z);
                    asyncTaskC2934e.m17050a(this.f15492b);
                    asyncTaskC2934e.m17066c(this.f15491a.f15477c);
                    AbstractAsyncTaskC2898a.m17030c(true);
                    try {
                        asyncTaskC2934e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f15491a.f15477c);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f15491a.f15476b, R.string.error_try_again);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private List<String> m17391f(File file) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (file != null) {
            File file2 = new File(file, "lib");
            if (file2.isDirectory() && (listFiles = file2.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.3

                /* renamed from: a */
                private final AsyncTaskC2925b f15493a;

                {
                    this.f15493a = this;
                }

                @Override // java.p209io.FileFilter
                public boolean accept(File file3) {
                    return file3.isDirectory();
                }
            })) != null) {
                for (File file3 : listFiles) {
                    arrayList.add(file3.getName());
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: l */
    private boolean m17394l() {
        String stringBuffer;
        File j = m17076j();
        if (j == null || !j.isDirectory() || mo3981a()) {
            return false;
        }
        File[] listFiles = j.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.b.4

            /* renamed from: a */
            private final AsyncTaskC2925b f15494a;

            {
                this.f15494a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("classes") && str.endsWith(".dex");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return true;
        }
        C0455a c0455a = new C0455a(C0518d.f3579w, this);
        int m17393g = m17393g(j);
        for (File file : listFiles) {
            if (file.getName().equals("classes.dex")) {
                stringBuffer = "smali";
            } else {
                stringBuffer = new StringBuffer().append("smali_").append(file.getName().substring(0, file.getName().lastIndexOf("."))).toString();
            }
            File file2 = new File(j, stringBuffer);
            c0455a.m3495a(file, file2, C3102bd.m18925a(this.f15476b, "mBakdeb", true), m17393g);
            if (m17393g > 14) {
                int i = 0;
                while (true) {
                    if (i < C3080al.f17665b.length) {
                        if (C3080al.f17665b[i] != m17393g) {
                            i++;
                        } else {
                            try {
                                new File(file2, new StringBuffer().append(".").append(C3080al.f17664a[i].replaceAll("\\s", "")).toString()).createNewFile();
                                break;
                            } catch (Exception e2) {
                            }
                        }
                    }
                }
            }
            file.delete();
        }
        return true;
    }

    /* renamed from: g */
    private int m17393g(File file) {
        try {
            File file2 = new File(file, "apktool.json");
            C0467a c0467a = new C0467a(this);
            C0462a m3527b = C0462a.m3527b(file2);
            if (m3527b.f3285f != null && m3527b.f3285f.get("minSdkVersion") != null) {
                return c0467a.m3580a(m3527b, m3527b.f3285f.get("minSdkVersion"));
            }
        } catch (Exception e2) {
        }
        return 14;
    }

    /* renamed from: d */
    public boolean m17403d(File file) {
        File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/AndroidManifest.xml").toString());
        if (!file2.exists()) {
            return false;
        }
        String m18332i = C3061a.m18332i(file2);
        return (Pattern.compile("\\s+configForSplit=\"[^\"]+\"").matcher(m18332i).find() || Pattern.compile(new StringBuffer().append(new StringBuffer().append("\\s+").append(C3061a.m18298a(m18332i)).toString()).append(":isFeatureSplit=\"true\"").toString()).matcher(m18332i).find() || Pattern.compile("\\s+split=\"[^\"]+\"").matcher(m18332i).find()) ? false : true;
    }

    /* renamed from: e */
    public boolean m17404e(File file) {
        File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/AndroidManifest.xml").toString());
        if (!file2.exists()) {
            return false;
        }
        String m18332i = C3061a.m18332i(file2);
        if (!Pattern.compile(new StringBuffer().append(new StringBuffer().append("\\s+").append(C3061a.m18298a(m18332i)).toString()).append(":isFeatureSplit=\"true\"").toString()).matcher(m18332i).find()) {
            return false;
        }
        if (Pattern.compile("\\s+configForSplit=\"[^\"]+\"").matcher(m18332i).find()) {
            return true;
        }
        Matcher matcher = Pattern.compile("\\s+split=\"([^\"]+)\"").matcher(m18332i);
        if (!matcher.find()) {
            return false;
        }
        this.f15483i = new StringBuffer().append(this.f15483i).append(new StringBuffer().append(",").append(matcher.group(1)).toString()).toString();
        return true;
    }

    /* renamed from: a */
    public void m17399a(File file, ExecutorService executorService, boolean z) {
        File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/AndroidManifest.xml").toString());
        File file3 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/res").toString());
        mo3984d(R.string.mprocessing, file.getName());
        FileFilter fileFilter = new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.5

            /* renamed from: a */
            private final AsyncTaskC2925b f15495a;

            {
                this.f15495a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file4) {
                return file4.isDirectory();
            }
        };
        FilenameFilter filenameFilter = new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.b.6

            /* renamed from: a */
            private final AsyncTaskC2925b f15496a;

            {
                this.f15496a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file4, String str) {
                return str.endsWith(".xml");
            }
        };
        File[] listFiles = file3.listFiles(fileFilter);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listFiles.length) {
                break;
            }
            File[] listFiles2 = listFiles[i2].listFiles(filenameFilter);
            if (listFiles2 != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < listFiles2.length) {
                        executorService.submit(new a(this, listFiles2[i4], file, 1, z));
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
        if (file2.exists()) {
            executorService.submit(new a(this, file2, file, 2, z));
        }
    }

    /* renamed from: b */
    public void m17401b(File file, ExecutorService executorService, boolean z) {
        File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/res").toString());
        FileFilter fileFilter = new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.7

            /* renamed from: a */
            private final AsyncTaskC2925b f15497a;

            {
                this.f15497a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file3) {
                return file3.isDirectory();
            }
        };
        FilenameFilter filenameFilter = new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.b.8

            /* renamed from: a */
            private final AsyncTaskC2925b f15498a;

            {
                this.f15498a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file3, String str) {
                return str.endsWith(".xml");
            }
        };
        for (File file3 : file2.listFiles(fileFilter)) {
            File[] listFiles = file3.listFiles(filenameFilter);
            if (listFiles != null) {
                for (File file4 : listFiles) {
                    executorService.submit(new a(this, file4, file, 0, z));
                }
            }
        }
    }

    /* renamed from: a */
    public String m17395a(File file, boolean z) {
        mo3984d(R.string.mcleaning_manifest, (Object) null);
        String m18332i = C3061a.m18332i(file);
        String m18298a = C3061a.m18298a(m18332i);
        String m18299a = C3061a.m18299a(m18332i, m18298a);
        if (m18299a != null) {
            m18332i = C3061a.m18316b(m18332i, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+").append(m18298a).toString()).append(":localeConfig=\"@xml/").toString()).append(m18299a).toString()).append("\"").toString(), "");
        }
        String m18315b = C3061a.m18315b(m18332i, m18298a);
        if (z) {
            m18315b = C3061a.m18316b(C3061a.m18316b(m18315b, "</application>", new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<meta-data ").append(m18298a).toString()).append(":name=\"com.android.stamp.type\" ").toString()).append(m18298a).toString()).append(":value=\"STAMP_TYPE_STANDALONE_APK\" />\n\t</application>").toString()), "</application>", new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<meta-data ").append(m18298a).toString()).append(":name=\"com\\.android\\.dynamic\\.apk\\.fused\\.modules\" ").toString()).append(m18298a).toString()).append(":value=\"").toString()).append(this.f15483i).toString()).append("\" />\n\t</application>").toString());
        }
        String m18314b = C3061a.m18314b(m18315b);
        if (C3102bd.m18925a(this.f15476b, "remove_property", false)) {
            m18314b = C3061a.m18323c(m18314b, m18298a);
        }
        C3061a.m18319b(file, m18314b);
        return m18299a;
    }

    /* renamed from: a */
    public void m17400a(File file, File[] fileArr) {
        mo3984d(R.string.mmerge_json, (Object) null);
        File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append("/apktool.json").toString());
        File file3 = new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append("/").toString()).append("renamed.json").toString());
        C2468c m18351a = C3064d.m18351a(file2);
        C2468c m18351a2 = C3064d.m18351a(file3);
        for (File file4 : fileArr) {
            if (!file4.equals(file)) {
                File file5 = new File(new StringBuffer().append(file4.getAbsolutePath()).append("/apktool.json").toString());
                File file6 = new File(new StringBuffer().append(new StringBuffer().append(file4.getAbsolutePath()).append("/").toString()).append("renamed.json").toString());
                C2468c m18351a3 = C3064d.m18351a(file5);
                C2468c m18351a4 = C3064d.m18351a(file6);
                try {
                    m18351a = C3064d.m18352a(m18351a, m18351a3, new String[]{"PackageInfo", "sdkInfo", "sharedLibrary", "isFrameworkApk"});
                    m18351a2 = C3064d.m18352a(m18351a2, m18351a4, (String[]) null);
                } catch (C2467b e2) {
                }
            }
        }
        if (m18351a != null) {
            C3064d.m18353a(file2, m18351a, 2);
        }
        if (m18351a2 != null) {
            C3064d.m18353a(file3, m18351a2, 2);
        }
    }

    /* renamed from: a */
    public void m17398a(File file, File file2) {
        File[] listFiles;
        if (!file.equals(file2) && (listFiles = file2.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.e.b.9

            /* renamed from: a */
            private final AsyncTaskC2925b f15499a;

            {
                this.f15499a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file3, String str) {
                return str.startsWith("classes") && str.endsWith(".dex");
            }
        })) != null) {
            for (File file3 : listFiles) {
                File file4 = new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append("/").toString()).append(file3.getName()).toString());
                if (file4.exists()) {
                    file4 = new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append("/").toString()).append(m17396a(file.getAbsolutePath(), "classes", ".dex", 2)).toString());
                }
                C3262u.m19612a(file3, file4);
            }
        }
    }

    /* renamed from: a */
    public String m17396a(String str, String str2, String str3, int i) {
        String stringBuffer;
        if (i > 0) {
            try {
                stringBuffer = new StringBuffer().append(str2).append(i).toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return new StringBuffer().append(str2).append(str3).toString();
            }
        } else {
            stringBuffer = str2;
        }
        if (new File(str, new StringBuffer().append(stringBuffer).append(str3).toString()).exists()) {
            return m17396a(str, str2, str3, i + 1);
        }
        return new StringBuffer().append(stringBuffer).append(str3).toString();
    }

    /* renamed from: b */
    public void m17402b(File file, File[] fileArr) {
        File[] listFiles;
        FileFilter fileFilter;
        File[] listFiles2;
        File[] listFiles3;
        FileFilter fileFilter2 = new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.10

            /* renamed from: a */
            private final AsyncTaskC2925b f15489a;

            {
                this.f15489a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        };
        for (File file2 : fileArr) {
            if (!file2.equals(file) && (listFiles = file2.listFiles(fileFilter2)) != null) {
                for (File file3 : listFiles) {
                    if (!file3.getName().equals("original")) {
                        try {
                            File file4 = new File(file, file3.getName());
                            if (!file4.exists()) {
                                file4.mkdir();
                            }
                            C3262u.m19614a(file3, file4, false, true);
                        } catch (Exception e2) {
                        }
                    } else if (this.f15482h || this.f15480f) {
                        File file5 = new File(file, "original/META-INF");
                        File file6 = new File(file3, "META-INF");
                        if (file5.isDirectory() && file6.isDirectory() && (((listFiles2 = file5.listFiles((fileFilter = new FileFilter(this) { // from class: ru.maximoff.apktool.e.b.11

                            /* renamed from: a */
                            private final AsyncTaskC2925b f15490a;

                            {
                                this.f15490a = this;
                            }

                            @Override // java.p209io.FileFilter
                            public boolean accept(File file7) {
                                String upperCase = file7.getName().toUpperCase();
                                return file7.isFile() && (upperCase.endsWith(".RSA") || upperCase.endsWith(".DSA") || upperCase.endsWith(".EC"));
                            }
                        }))) == null || listFiles2.length == 0) && (listFiles3 = file6.listFiles(fileFilter)) != null && listFiles3.length > 0)) {
                            for (File file7 : listFiles3) {
                                C3262u.m19612a(file7, new File(file5, file7.getName()));
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m17385a(String str) {
        File m17389d = m17389d(this.f15477c.getParentFile().getParentFile().getAbsolutePath(), str);
        if (m17389d == null) {
            mo3979a(R.string.text, this.f15476b.getString(R.string.error));
            return false;
        }
        if (!m17389d.equals(this.f15477c) && !C3262u.m19613a(this.f15477c, m17389d, true) && !C3262u.m19612a(this.f15477c, m17389d)) {
            return false;
        }
        C0542g.m3987a(this.f15477c.getParentFile());
        AbstractAsyncTaskC2898a.m17030c(false);
        m17060b(m17389d);
        return true;
    }

    /* renamed from: d */
    private File m17389d(String str, String str2) {
        String str3;
        boolean m18925a = C3102bd.m18925a(this.f15476b, "all_to_out_dir", false);
        boolean z = !C3262u.m19664g(this.f15476b, new File(str));
        if (m18925a || z) {
            str3 = C3102bd.f18339v;
            if (str3 == null) {
                mo3983c(R.string.output_directory_not_set, new Object[0]);
                return (File) null;
            }
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                mo3983c(R.string.output_directory_not_extsts, str3);
                return (File) null;
            }
            if (!file.isDirectory()) {
                mo3983c(R.string.not_directory, str3);
                return (File) null;
            }
        } else {
            str3 = str;
        }
        return new File(str3, C3262u.m19568a(this.f15476b, str3, str2, "", 0, true));
    }

    /* compiled from: AntiSplit.java */
    /* renamed from: ru.maximoff.apktool.e.b$a */
    private class a implements Runnable {

        /* renamed from: a */
        private File f15500a;

        /* renamed from: b */
        private File f15501b;

        /* renamed from: c */
        private int f15502c;

        /* renamed from: d */
        private boolean f15503d;

        /* renamed from: e */
        private final AsyncTaskC2925b f15504e;

        public a(AsyncTaskC2925b asyncTaskC2925b, File file, File file2, int i, boolean z) {
            this.f15504e = asyncTaskC2925b;
            this.f15500a = file;
            this.f15501b = file2;
            this.f15502c = i;
            this.f15503d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3215e.m19248a(this.f15500a, "APKTOOL_DUMMY_", false, "UTF-8") >= 0) {
                String m18332i = C3061a.m18332i(this.f15500a);
                switch (this.f15502c) {
                    case 0:
                        C3061a.m18319b(this.f15500a, C3061a.m18322c(m18332i));
                        break;
                    case 1:
                        boolean z = m18332i.indexOf("APKTOOL_DUMMY_0x") >= 0;
                        for (C3090av c3090av : this.f15504e.f15485k) {
                            if (c3090av.m18729c() != null || z) {
                                if (!c3090av.m18731e() && this.f15501b.hashCode() != c3090av.hashCode()) {
                                    if (c3090av.m18729c() != null) {
                                        m18332i = C3061a.m18302a(m18332i, c3090av.m18724a(), c3090av.m18727b(), c3090av.m18729c());
                                    }
                                    if (z) {
                                        m18332i = C3061a.m18302a(m18332i, c3090av.m18724a(), c3090av.m18727b(), new StringBuffer().append("APKTOOL_DUMMY_").append(c3090av.m18730d()).toString());
                                    }
                                }
                            }
                        }
                        String m18325d = C3061a.m18325d(C3061a.m18303a(m18332i, (List<C3090av>) this.f15504e.f15485k));
                        if (!this.f15503d) {
                            if (this.f15500a.getParentFile().getName().startsWith("values")) {
                                if (this.f15500a.getName().equals("styles.xml")) {
                                    m18325d = C3061a.m18317b(m18325d, (Map<String, C3063c>) this.f15504e.f15486l);
                                }
                            } else {
                                m18325d = C3061a.m18304a(m18325d, (Map<String, C3063c>) this.f15504e.f15486l);
                            }
                        }
                        C3061a.m18319b(this.f15500a, m18325d);
                        this.f15504e.f15484j++;
                        break;
                    case 2:
                        for (C3090av c3090av2 : this.f15504e.f15485k) {
                            if (c3090av2.m18729c() != null) {
                                m18332i = C3061a.m18302a(m18332i, c3090av2.m18724a(), c3090av2.m18727b(), c3090av2.m18729c());
                            }
                        }
                        C3061a.m18319b(this.f15500a, C3061a.m18325d(C3061a.m18303a(m18332i, (List<C3090av>) this.f15504e.f15485k)));
                        this.f15504e.f15484j++;
                        break;
                }
            }
        }
    }
}
