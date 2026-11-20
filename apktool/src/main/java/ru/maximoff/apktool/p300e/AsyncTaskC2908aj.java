package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.usb.UsbManager;
import android.p008os.AsyncTask;
import android.provider.Settings;
import android.provider.Telephony;
import android.util.C0035a;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.ByteArrayInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.FilenameFilter;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p047a.p050c.p053b.C0501a;
import p046b.p059d.C0542g;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3073ae;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3094az;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3115bq;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3118c;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3256p;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: QuickEdit.java */
/* renamed from: ru.maximoff.apktool.e.aj */
/* loaded from: classes.dex */
public class AsyncTaskC2908aj extends AsyncTask<String, String, Boolean> {

    /* renamed from: A */
    private int f15113A;

    /* renamed from: N */
    private Resources f15126N;

    /* renamed from: c */
    private String f15129c;

    /* renamed from: d */
    private String f15130d;

    /* renamed from: e */
    private String f15131e;

    /* renamed from: f */
    private String f15132f;

    /* renamed from: g */
    private String f15133g;

    /* renamed from: h */
    private String f15134h;

    /* renamed from: p */
    private Context f15142p;

    /* renamed from: q */
    private InterfaceC2995n f15143q;

    /* renamed from: r */
    private DialogInterfaceC0070b f15144r;

    /* renamed from: s */
    private Bitmap f15145s;

    /* renamed from: t */
    private String f15146t;

    /* renamed from: v */
    private String f15148v;

    /* renamed from: w */
    private int f15149w;

    /* renamed from: y */
    private int f15151y;

    /* renamed from: z */
    private String f15152z;

    /* renamed from: a */
    private final String f15127a = "disabled_";

    /* renamed from: b */
    private final String f15128b = new StringBuffer().append(C3112bn.m18988a(7)).append("_").toString();

    /* renamed from: i */
    private int f15135i = 0;

    /* renamed from: j */
    private int f15136j = 0;

    /* renamed from: k */
    private int f15137k = 0;

    /* renamed from: l */
    private int f15138l = 0;

    /* renamed from: m */
    private int f15139m = 0;

    /* renamed from: x */
    private int f15150x = -1;

    /* renamed from: n */
    private boolean f15140n = false;

    /* renamed from: u */
    private boolean f15147u = false;

    /* renamed from: F */
    private boolean f15118F = false;

    /* renamed from: o */
    private boolean f15141o = false;

    /* renamed from: G */
    private boolean f15119G = false;

    /* renamed from: H */
    private boolean f15120H = false;

    /* renamed from: I */
    private boolean f15121I = false;

    /* renamed from: B */
    private boolean f15114B = true;

    /* renamed from: J */
    private boolean f15122J = true;

    /* renamed from: K */
    private boolean f15123K = false;

    /* renamed from: C */
    private boolean f15115C = false;

    /* renamed from: D */
    private int f15116D = 1;

    /* renamed from: E */
    private List<String> f15117E = new ArrayList();

    /* renamed from: L */
    private List<String> f15124L = new ArrayList();

    /* renamed from: M */
    private List<String> f15125M = new ArrayList();

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m17184a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17188a(bool);
    }

    public AsyncTaskC2908aj(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15142p = context;
        this.f15143q = interfaceC2995n;
        this.f15151y = C3102bd.m18905a(context, "aicon_size", 108);
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15142p).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15144r = new DialogInterfaceC0070b.a(this.f15142p).m435b(inflate).m429a(false).m438b();
        this.f15144r.show();
    }

    /* renamed from: a */
    protected Boolean m17184a(String[] strArr) {
        File parentFile;
        String str;
        String str2;
        String name;
        InterfaceC0008c interfaceC0008c;
        String name2;
        File file = new File(strArr[0]);
        File file2 = new File(strArr[1]);
        File parentFile2 = file2.getParentFile();
        File file3 = new File(parentFile2, new StringBuffer().append("unzip_files_").append(System.currentTimeMillis()).toString());
        try {
            try {
                try {
                    file3.mkdirs();
                    C3060a c3060a = new C3060a(this.f15142p, file);
                    c3060a.m18260a();
                    this.f15124L.addAll(c3060a.m18256E());
                    this.f15125M.addAll(c3060a.m18257F());
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                    hashMap.put(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME, this.f15128b);
                    if (this.f15133g != null) {
                        arrayList.add("resources.arsc");
                        hashMap.put("resources.arsc", this.f15128b);
                    }
                    String str3 = (String) null;
                    String str4 = (String) null;
                    String str5 = (String) null;
                    String str6 = (String) null;
                    if (this.f15145s != null) {
                        if (this.f15146t != null && this.f15149w != 0 && this.f15149w != -1) {
                            String[] split = this.f15146t.split("/");
                            str3 = split[0];
                            str4 = split[1];
                            arrayList.addAll(this.f15124L);
                            arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str4).toString()).append(".png").toString());
                            arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str4).toString()).append(".webp").toString());
                            if (this.f15114B) {
                                arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str4).toString()).append(".xml").toString());
                            }
                        }
                        str = str4;
                        str2 = str3;
                        if (this.f15152z != null && this.f15113A != 0 && this.f15113A != -1 && this.f15149w != this.f15113A) {
                            String[] split2 = this.f15152z.split("/");
                            str5 = split2[0];
                            str6 = split2[1];
                            arrayList.addAll(this.f15125M);
                            arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str6).toString()).append(".png").toString());
                            arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str6).toString()).append(".webp").toString());
                            if (this.f15114B) {
                                arrayList.add(new StringBuffer().append(new StringBuffer().append(File.separator).append(str6).toString()).append(".xml").toString());
                            }
                        }
                        C3067ab.m18386a(file2.getParent(), this.f15145s, new StringBuffer().append(new StringBuffer().append(String.valueOf(str)).append("_").toString()).append(this.f15149w).toString(), new StringBuffer().append(new StringBuffer().append(String.valueOf(str6)).append("_").toString()).append(this.f15113A).toString(), "png");
                        C3067ab.m18386a(file2.getParent(), this.f15145s, new StringBuffer().append(new StringBuffer().append(String.valueOf(str)).append("_").toString()).append(this.f15149w).toString(), new StringBuffer().append(new StringBuffer().append(String.valueOf(str6)).append("_").toString()).append(this.f15113A).toString(), "webp");
                    } else {
                        str = str4;
                        str2 = str3;
                    }
                    C3117bs.m19063a(this.f15142p, file, file3, (List<String>) arrayList, false, (Map<String, String>) hashMap);
                    m17152a(file3, file, file2, str2, str, str5, str6);
                    if (this.f15123K) {
                        try {
                            name2 = new StringBuffer().append(C3112bn.m18992a(this.f15142p, new C3060a(this.f15142p, file2), C3102bd.m18910a(this.f15142p, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})"))).append(".apk").toString();
                        } catch (Exception e2) {
                            name2 = file2.getName();
                        }
                        name = name2;
                    } else {
                        name = file2.getName();
                    }
                    if (this.f15116D == 0 && C3102bd.m18925a(this.f15142p, "save_sign_data", true)) {
                        interfaceC0008c = C3105bg.m18964a(file);
                    } else {
                        interfaceC0008c = (InterfaceC0008c) null;
                    }
                    C2917as.m17314a(this.f15142p, this.f15116D, new C2917as.a(this, file2, m17144a(file2, name), interfaceC0008c) { // from class: ru.maximoff.apktool.e.aj.1

                        /* renamed from: a */
                        private final AsyncTaskC2908aj f15153a;

                        /* renamed from: b */
                        private final File f15154b;

                        /* renamed from: c */
                        private final File f15155c;

                        /* renamed from: d */
                        private final InterfaceC0008c f15156d;

                        {
                            this.f15153a = this;
                            this.f15154b = file2;
                            this.f15155c = r3;
                            this.f15156d = interfaceC0008c;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                this.f15154b.renameTo(this.f15155c);
                                if (this.f15156d != null) {
                                    try {
                                        C3105bg.m18967a(this.f15155c, this.f15156d);
                                        return;
                                    } catch (IOException e3) {
                                        return;
                                    }
                                }
                                return;
                            }
                            c2917as.m17320a(this.f15154b, this.f15155c, this.f15153a.f15136j > 0 ? this.f15153a.f15136j : this.f15153a.f15138l);
                        }
                    });
                    this.f15147u = !file.getParent().equals(parentFile2.getParent());
                    return new Boolean(true);
                } finally {
                    C0542g.m3987a(file2.getParentFile());
                }
            } catch (Exception e3) {
                e = e3;
                this.f15148v = Log.getStackTraceString(e);
                return new Boolean(false);
            }
        } catch (Error e4) {
            e = e4;
            this.f15148v = Log.getStackTraceString(e);
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17188a(Boolean bool) {
        if (this.f15144r != null && this.f15144r.isShowing()) {
            try {
                this.f15144r.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15143q == null) {
            MainActivity.m16615o().m16644z();
        } else {
            this.f15143q.mo17929a();
        }
        if (!bool.booleanValue()) {
            new C3078aj(this.f15142p).m18494a(R.string.error).m18496a(this.f15142p.getString(R.string.errorf, this.f15148v)).m18501b(R.string.copy, new Runnable(this) { // from class: ru.maximoff.apktool.e.aj.3

                /* renamed from: a */
                private final AsyncTaskC2908aj f15158a;

                {
                    this.f15158a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15158a.f15142p, this.f15158a.f15148v);
                }
            }).m18506d(R.string.close_cur).m18507d();
        } else if (this.f15147u) {
            new C3078aj(this.f15142p).m18494a(R.string.complete).m18496a(this.f15142p.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.aj.2

                /* renamed from: a */
                private final AsyncTaskC2908aj f15157a;

                {
                    this.f15157a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15157a.f15143q == null) {
                        MainActivity.m16615o().m16622a(new File(C3102bd.f18339v));
                    } else {
                        this.f15157a.f15143q.mo17934a(new File(C3102bd.f18339v));
                    }
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
        super.onPostExecute(bool);
    }

    /* renamed from: a */
    private void m17152a(File file, File file2, File file3, String str, String str2, String str3, String str4) {
        File[] m17156a;
        File[] m17156a2;
        File file4 = new File(file, new StringBuffer().append(this.f15128b).append(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME).toString());
        if (!file4.exists()) {
            throw new Exception("AndroidManifest.xml not found, break");
        }
        File file5 = new File(new StringBuffer().append(file4.getAbsolutePath()).append("_tmp").toString());
        file4.renameTo(file5);
        m17151a(file5, file4);
        file5.delete();
        if (this.f15145s != null) {
            Bitmap m18368a = C3067ab.m18368a(this.f15145s, this.f15151y);
            int m18398e = C3067ab.m18398e(m18368a);
            if (str != null && str2 != null) {
                Bitmap m18371a = C3067ab.m18371a(m18368a, false);
                m17147a(file, str, str2, new StringBuffer().append("_").append(this.f15149w).toString());
                m17158b(file, str, str2, new StringBuffer().append("_").append(this.f15149w).toString());
                if (this.f15114B && (m17156a2 = m17156a(file, str, str2)) != null) {
                    for (File file6 : m17156a2) {
                        m17149a(m18371a, m18398e, file, file6);
                    }
                }
                m17150a(m18371a, m18398e, file, str2, str, new StringBuffer().append("_").append(this.f15149w).toString(), this.f15124L, this.f15114B);
            }
            if (str3 != null && str4 != null) {
                Bitmap m18371a2 = C3067ab.m18371a(m18368a, true);
                m17147a(file, str3, str4, new StringBuffer().append("_").append(this.f15113A).toString());
                m17158b(file, str3, str4, new StringBuffer().append("_").append(this.f15113A).toString());
                if (this.f15114B && (m17156a = m17156a(file, str3, str4)) != null) {
                    for (File file7 : m17156a) {
                        m17149a(m18371a2, m18398e, file, file7);
                    }
                }
                m17150a(m18371a2, m18398e, file, str4, str3, new StringBuffer().append("_").append(this.f15113A).toString(), this.f15125M, this.f15114B);
            }
        }
        File file8 = new File(new StringBuffer().append(file3.getAbsolutePath()).append("_tmp").toString());
        m17153a(file2.getAbsolutePath(), file8.getAbsolutePath(), file.getAbsolutePath());
        C3317a.m20052a(file8.getAbsolutePath(), file3.getAbsolutePath());
        file8.delete();
    }

    /* renamed from: a */
    private void m17150a(Bitmap bitmap, int i, File file, String str, String str2, String str3, List<String> list, boolean z) {
        String str4;
        for (String str5 : list) {
            if (!str5.matches(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("^res/").append(str2).toString()).append(".*/").toString()).append(str).toString()).append("\\..*$").toString())) {
                File file2 = new File(file, str5);
                if (file2.exists()) {
                    if (C3262u.m19660e(file2)) {
                        boolean m19665g = C3262u.m19665g(file2);
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(file2.getAbsolutePath(), options);
                            str4 = C3067ab.m18385a(Math.max(options.outWidth, options.outHeight));
                        } catch (Error | Exception e2) {
                            str4 = "xxhdpi";
                        }
                        file2.delete();
                        if (m19665g) {
                            C3262u.m19612a(new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file.getParent()).append(File.separator).toString()).append(str4).toString()).append(File.separator).toString()).append(str).toString()).append(str3).toString()).append(".webp").toString()), file2);
                        } else {
                            C3262u.m19612a(new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file.getParent()).append(File.separator).toString()).append(str4).toString()).append(File.separator).toString()).append(str).toString()).append(str3).toString()).append(".png").toString()), file2);
                        }
                    } else if (z && C3262u.m19671j(file2)) {
                        m17149a(bitmap, i, file, file2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m17149a(Bitmap bitmap, int i, File file, File file2) {
        boolean m17155a = m17155a(file2);
        File m17145a = m17145a(file2, m17155a);
        File file3 = new File(new StringBuffer().append(m17145a.getAbsolutePath()).append("_tmp").toString());
        m17145a.renameTo(file3);
        if (m17155a) {
            m17162c(C3067ab.m18389b(bitmap, this.f15151y, this.f15151y), i, file3, m17145a);
        } else {
            m17159b(bitmap, i, file3, m17145a);
        }
        file3.delete();
    }

    /* renamed from: a */
    private File[] m17156a(File file, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        File file2 = new File(file, "res");
        if (!file2.exists() || !file2.isDirectory()) {
            return (File[]) null;
        }
        File[] listFiles = file2.listFiles(new FilenameFilter(this, str) { // from class: ru.maximoff.apktool.e.aj.4

            /* renamed from: a */
            private final AsyncTaskC2908aj f15159a;

            /* renamed from: b */
            private final String f15160b;

            {
                this.f15159a = this;
                this.f15160b = str;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file3, String str3) {
                return str3.startsWith(this.f15160b);
            }
        });
        if (listFiles == null) {
            return (File[]) null;
        }
        for (File file3 : listFiles) {
            File file4 = new File(file3, new StringBuffer().append(str2).append(".xml").toString());
            if (file4.exists()) {
                arrayList.add(file4);
            }
        }
        if (arrayList.isEmpty()) {
            return (File[]) null;
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    private List<String> m17147a(File file, String str, String str2, String str3) {
        return m17148a(file, str, str2, "png", str3);
    }

    /* renamed from: b */
    private List<String> m17158b(File file, String str, String str2, String str3) {
        return m17148a(file, str, str2, "webp", str3);
    }

    /* renamed from: a */
    private List<String> m17148a(File file, String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        File file2 = new File(file, "res");
        if (!file2.exists() || !file2.isDirectory()) {
            return arrayList;
        }
        File[] listFiles = file2.listFiles(new FilenameFilter(this, str) { // from class: ru.maximoff.apktool.e.aj.5

            /* renamed from: a */
            private final AsyncTaskC2908aj f15161a;

            /* renamed from: b */
            private final String f15162b;

            {
                this.f15161a = this;
                this.f15162b = str;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file3, String str5) {
                return str5.startsWith(this.f15162b);
            }
        });
        if (listFiles == null) {
            return arrayList;
        }
        String str5 = "xxhdpi";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listFiles.length) {
                return arrayList;
            }
            File file3 = listFiles[i2];
            File file4 = new File(file3, new StringBuffer().append(new StringBuffer().append(str2).append(".").toString()).append(str3).toString());
            if (file4.exists()) {
                arrayList.add(new StringBuffer().append(new StringBuffer().append(file4.getAbsolutePath().split(File.separator)[r7.length - 2]).append(File.separator).toString()).append(str2).toString());
                file4.delete();
                String[] strArr = C3067ab.f17243b;
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    str5 = strArr[i3];
                    if (file3.getName().matches(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("^").append(str).toString()).append("(-.+)?-").toString()).append(str5).toString()).append("(-.+)?$").toString())) {
                        break;
                    }
                }
                C3262u.m19612a(new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file.getParent()).append(File.separator).toString()).append(str5).toString()).append(File.separator).toString()).append(str2).toString()).append(str4).toString()).append(".").toString()).append(str3).toString()), new File(file3, new StringBuffer().append(new StringBuffer().append(str2).append(".").toString()).append(str3).toString()));
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    private void m17159b(Bitmap bitmap, int i, File file, File file2) {
        List<C3115bq> m18445a;
        if (this.f15122J) {
            m18445a = new C3118c(bitmap).m19080b();
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("numberofcolors", new Float(255.0f));
            m18445a = C3073ae.m18445a(bitmap, (HashMap<String, Float>) hashMap, C3073ae.m18455a(255));
        }
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass6(this, c0548d, i, bitmap, m18445a));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: QuickEdit.java */
    /* renamed from: ru.maximoff.apktool.e.aj$6, reason: invalid class name */
    class AnonymousClass6 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2908aj f15163a;

        /* renamed from: b */
        private final int f15164b;

        /* renamed from: c */
        private final Bitmap f15165c;

        /* renamed from: e */
        private final List f15166e;

        AnonymousClass6(AsyncTaskC2908aj asyncTaskC2908aj, AbstractC0549e abstractC0549e, int i, Bitmap bitmap, List list) {
            super(abstractC0549e);
            this.f15163a = asyncTaskC2908aj;
            this.f15164b = i;
            this.f15165c = bitmap;
            this.f15166e = list;
        }

        /* renamed from: a */
        static AsyncTaskC2908aj m17214a(AnonymousClass6 anonymousClass6) {
            return anonymousClass6.f15163a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2), this.f15164b, this.f15165c, this.f15166e);
        }

        /* compiled from: QuickEdit.java */
        /* renamed from: ru.maximoff.apktool.e.aj$6$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass6 f15167a;

            /* renamed from: b */
            private final int f15168b;

            /* renamed from: c */
            private final Bitmap f15169c;

            /* renamed from: e */
            private final List f15170e;

            AnonymousClass1(AnonymousClass6 anonymousClass6, AbstractC0549e abstractC0549e, int i, Bitmap bitmap, List list) {
                super(abstractC0549e);
                this.f15167a = anonymousClass6;
                this.f15168b = i;
                this.f15169c = bitmap;
                this.f15170e = list;
            }

            /* renamed from: a */
            static AnonymousClass6 m17215a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15167a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equals("background")) {
                    return new AbstractC0549e(this, super.mo4019a(str, str2), this.f15168b, this.f15169c) { // from class: ru.maximoff.apktool.e.aj.6.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f15171a;

                        /* renamed from: b */
                        private final int f15172b;

                        /* renamed from: c */
                        private final Bitmap f15173c;

                        {
                            this.f15171a = this;
                            this.f15172b = r3;
                            this.f15173c = r4;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public AbstractC0549e mo4019a(String str3, String str4) {
                            return str4.equals("shape") ? new AbstractC0549e(this, super.mo4019a(str3, str4), this.f15172b, this.f15173c) { // from class: ru.maximoff.apktool.e.aj.6.1.1.1

                                /* renamed from: a */
                                private final C33731 f15174a;

                                /* renamed from: b */
                                private final int f15175b;

                                /* renamed from: c */
                                private final Bitmap f15176c;

                                {
                                    this.f15174a = this;
                                    this.f15175b = r3;
                                    this.f15176c = r4;
                                }

                                @Override // p060c.p061a.p062a.AbstractC0549e
                                /* renamed from: a */
                                public AbstractC0549e mo4019a(String str5, String str6) {
                                    return str6.equals("solid") ? new AbstractC0549e(this, super.mo4019a(str5, str6), this.f15175b) { // from class: ru.maximoff.apktool.e.aj.6.1.1.1.1

                                        /* renamed from: a */
                                        private final C33741 f15177a;

                                        /* renamed from: b */
                                        private final int f15178b;

                                        {
                                            this.f15177a = this;
                                            this.f15178b = r3;
                                        }

                                        @Override // p060c.p061a.p062a.AbstractC0549e
                                        /* renamed from: a */
                                        public void mo4032a(String str7, String str8, int i, int i2, Object obj) {
                                            Object obj2;
                                            int i3;
                                            if (str8.equals("color")) {
                                                obj2 = new Integer(this.f15178b);
                                                i3 = 28;
                                            } else {
                                                obj2 = obj;
                                                i3 = i2;
                                            }
                                            super.mo4032a(str7, str8, i, i3, obj2);
                                        }
                                    } : super.mo4019a(str5, str6);
                                }

                                @Override // p060c.p061a.p062a.AbstractC0549e
                                /* renamed from: a */
                                public void mo4032a(String str5, String str6, int i, int i2, Object obj) {
                                    Object obj2;
                                    int i3 = 5;
                                    if (str6.equals("width")) {
                                        obj2 = new Integer(C0035a.m197a(this.f15176c.getWidth(), 1));
                                    } else if (str6.equals("height")) {
                                        obj2 = new Integer(C0035a.m197a(this.f15176c.getHeight(), 1));
                                    } else {
                                        obj2 = obj;
                                        i3 = i2;
                                    }
                                    super.mo4032a(str5, str6, i, i3, obj2);
                                }
                            } : super.mo4019a(str3, str4);
                        }
                    };
                }
                if (str2.equals("foreground")) {
                    return new AnonymousClass2(this, super.mo4019a(str, str2), this.f15169c, this.f15170e);
                }
                return super.mo4019a(str, str2);
            }

            /* compiled from: QuickEdit.java */
            /* renamed from: ru.maximoff.apktool.e.aj$6$1$2, reason: invalid class name */
            class AnonymousClass2 extends AbstractC0549e {

                /* renamed from: a */
                private final AnonymousClass1 f15179a;

                /* renamed from: b */
                private final Bitmap f15180b;

                /* renamed from: c */
                private final List f15181c;

                AnonymousClass2(AnonymousClass1 anonymousClass1, AbstractC0549e abstractC0549e, Bitmap bitmap, List list) {
                    super(abstractC0549e);
                    this.f15179a = anonymousClass1;
                    this.f15180b = bitmap;
                    this.f15181c = list;
                }

                /* renamed from: a */
                static AnonymousClass1 m17216a(AnonymousClass2 anonymousClass2) {
                    return anonymousClass2.f15179a;
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public AbstractC0549e mo4019a(String str, String str2) {
                    return str2.equals("vector") ? new AbstractC0549e(this, super.mo4019a(str, str2), this.f15180b, this.f15181c, str) { // from class: ru.maximoff.apktool.e.aj.6.1.2.1

                        /* renamed from: a */
                        private final AnonymousClass2 f15182a;

                        /* renamed from: b */
                        private final Bitmap f15183b;

                        /* renamed from: c */
                        private final List f15184c;

                        /* renamed from: e */
                        private final String f15185e;

                        {
                            this.f15182a = this;
                            this.f15183b = r3;
                            this.f15184c = r4;
                            this.f15185e = str;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            Object obj2;
                            int i3 = 5;
                            if (str4.equals("width")) {
                                obj2 = new Integer(C0035a.m197a(this.f15183b.getWidth(), 1));
                            } else if (str4.equals("height")) {
                                obj2 = new Integer(C0035a.m197a(this.f15183b.getHeight(), 1));
                            } else if (str4.equals("viewportWidth")) {
                                obj2 = new Float(this.f15183b.getWidth());
                                i3 = 4;
                            } else if (str4.equals("viewportHeight")) {
                                obj2 = new Float(this.f15183b.getHeight());
                                i3 = 4;
                            } else {
                                obj2 = obj;
                                i3 = i2;
                            }
                            super.mo4032a(str3, str4, i, i3, obj2);
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4024a() {
                            int identifier = AnonymousClass6.m17214a(AnonymousClass1.m17215a(AnonymousClass2.m17216a(this.f15182a))).f15142p.getResources().getIdentifier("fillColor", C0497h.f3457a, "android");
                            if (identifier == 0) {
                                identifier = C0012R.attr.fillColor;
                            }
                            int identifier2 = AnonymousClass6.m17214a(AnonymousClass1.m17215a(AnonymousClass2.m17216a(this.f15182a))).f15142p.getResources().getIdentifier("pathData", C0497h.f3457a, "android");
                            if (identifier2 == 0) {
                                identifier2 = C0012R.attr.pathData;
                            }
                            for (C3115bq c3115bq : this.f15184c) {
                                long parseLong = Long.parseLong(c3115bq.m19046a(), 16);
                                AbstractC0549e a2 = mo4019a(this.f15185e, "path");
                                a2.mo4032a("http://schemas.android.com/apk/res/android", "pathData", identifier2, 3, c3115bq.m19047b());
                                a2.mo4032a("http://schemas.android.com/apk/res/android", "fillColor", identifier, 28, new Integer((int) parseLong));
                                a2.mo4024a();
                            }
                            super.mo4024a();
                        }
                    } : super.mo4019a(str, str2);
                }
            }
        }
    }

    /* renamed from: c */
    private void m17162c(Bitmap bitmap, int i, File file, File file2) {
        List<C3115bq> m18445a;
        if (this.f15122J) {
            m18445a = new C3118c(bitmap).m19080b();
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("numberofcolors", new Float(255.0f));
            m18445a = C3073ae.m18445a(bitmap, (HashMap<String, Float>) hashMap, C3073ae.m18455a(255));
        }
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass7(this, c0548d, bitmap, m18445a));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: QuickEdit.java */
    /* renamed from: ru.maximoff.apktool.e.aj$7, reason: invalid class name */
    class AnonymousClass7 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2908aj f15186a;

        /* renamed from: b */
        private final Bitmap f15187b;

        /* renamed from: c */
        private final List f15188c;

        AnonymousClass7(AsyncTaskC2908aj asyncTaskC2908aj, AbstractC0549e abstractC0549e, Bitmap bitmap, List list) {
            super(abstractC0549e);
            this.f15186a = asyncTaskC2908aj;
            this.f15187b = bitmap;
            this.f15188c = list;
        }

        /* renamed from: a */
        static AsyncTaskC2908aj m17217a(AnonymousClass7 anonymousClass7) {
            return anonymousClass7.f15186a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return str2.equals("vector") ? new AbstractC0549e(this, super.mo4019a(str, str2), this.f15187b, this.f15188c, str) { // from class: ru.maximoff.apktool.e.aj.7.1

                /* renamed from: a */
                private final AnonymousClass7 f15189a;

                /* renamed from: b */
                private final Bitmap f15190b;

                /* renamed from: c */
                private final List f15191c;

                /* renamed from: e */
                private final String f15192e;

                {
                    this.f15189a = this;
                    this.f15190b = r3;
                    this.f15191c = r4;
                    this.f15192e = str;
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                    Object obj2;
                    int i3 = 5;
                    if (str4.equals("width")) {
                        obj2 = new Integer(C0035a.m197a(this.f15190b.getWidth(), 1));
                    } else if (str4.equals("height")) {
                        obj2 = new Integer(C0035a.m197a(this.f15190b.getHeight(), 1));
                    } else if (str4.equals("viewportWidth")) {
                        obj2 = new Float(this.f15190b.getWidth());
                        i3 = 4;
                    } else if (str4.equals("viewportHeight")) {
                        obj2 = new Float(this.f15190b.getHeight());
                        i3 = 4;
                    } else {
                        obj2 = obj;
                        i3 = i2;
                    }
                    super.mo4032a(str3, str4, i, i3, obj2);
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public void mo4024a() {
                    int identifier = AnonymousClass7.m17217a(this.f15189a).f15142p.getResources().getIdentifier("fillColor", C0497h.f3457a, "android");
                    if (identifier == 0) {
                        identifier = C0012R.attr.fillColor;
                    }
                    int identifier2 = AnonymousClass7.m17217a(this.f15189a).f15142p.getResources().getIdentifier("pathData", C0497h.f3457a, "android");
                    if (identifier2 == 0) {
                        identifier2 = C0012R.attr.pathData;
                    }
                    for (C3115bq c3115bq : this.f15191c) {
                        long parseLong = Long.parseLong(c3115bq.m19046a(), 16);
                        AbstractC0549e a2 = mo4019a(this.f15192e, "path");
                        a2.mo4032a("http://schemas.android.com/apk/res/android", "pathData", identifier2, 3, c3115bq.m19047b());
                        a2.mo4032a("http://schemas.android.com/apk/res/android", "fillColor", identifier, 28, new Integer((int) parseLong));
                        a2.mo4024a();
                    }
                    super.mo4024a();
                }
            } : super.mo4019a(str, str2);
        }
    }

    /* renamed from: a */
    private boolean m17155a(File file) {
        if (!C3262u.m19671j(file)) {
            return !file.getParentFile().getName().equals("mipmap-anydpi-v26");
        }
        boolean[] zArr = {false};
        new C0546b(C1887e.m13984b(new FileInputStream(file))).m4018a(new C0547c(this, new C0548d(), zArr) { // from class: ru.maximoff.apktool.e.aj.8

            /* renamed from: a */
            private final AsyncTaskC2908aj f15193a;

            /* renamed from: b */
            private final boolean[] f15194b;

            {
                this.f15193a = this;
                this.f15194b = zArr;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equals("vector")) {
                    this.f15194b[0] = true;
                }
                return super.mo4019a(str, str2);
            }
        });
        return zArr[0];
    }

    /* renamed from: a */
    private File m17145a(File file, boolean z) {
        InputStream open = this.f15142p.getAssets().open(new StringBuffer().append("tpl/").append(z ? "vi.tpl" : "ai.tpl").toString());
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        return file;
    }

    /* renamed from: a */
    private void m17151a(File file, File file2) {
        boolean[] zArr = {false};
        boolean[] zArr2 = {false};
        boolean[] zArr3 = {false};
        boolean[] zArr4 = {false};
        boolean[] zArr5 = {false};
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass9(this, c0548d, zArr5, new boolean[]{false, false}, zArr3, zArr4, zArr2, zArr, new int[]{0}, new boolean[]{false}, file, new boolean[]{false}));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: QuickEdit.java */
    /* renamed from: ru.maximoff.apktool.e.aj$9, reason: invalid class name */
    class AnonymousClass9 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2908aj f15195a;

        /* renamed from: b */
        private final boolean[] f15196b;

        /* renamed from: c */
        private final boolean[] f15197c;

        /* renamed from: e */
        private final boolean[] f15198e;

        /* renamed from: f */
        private final boolean[] f15199f;

        /* renamed from: g */
        private final boolean[] f15200g;

        /* renamed from: h */
        private final boolean[] f15201h;

        /* renamed from: i */
        private final int[] f15202i;

        /* renamed from: j */
        private final boolean[] f15203j;

        /* renamed from: k */
        private final File f15204k;

        /* renamed from: l */
        private final boolean[] f15205l;

        AnonymousClass9(AsyncTaskC2908aj asyncTaskC2908aj, AbstractC0549e abstractC0549e, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, boolean[] zArr4, boolean[] zArr5, boolean[] zArr6, int[] iArr, boolean[] zArr7, File file, boolean[] zArr8) {
            super(abstractC0549e);
            this.f15195a = asyncTaskC2908aj;
            this.f15196b = zArr;
            this.f15197c = zArr2;
            this.f15198e = zArr3;
            this.f15199f = zArr4;
            this.f15200g = zArr5;
            this.f15201h = zArr6;
            this.f15202i = iArr;
            this.f15203j = zArr7;
            this.f15204k = file;
            this.f15205l = zArr8;
        }

        /* renamed from: a */
        static AsyncTaskC2908aj m17218a(AnonymousClass9 anonymousClass9) {
            return anonymousClass9.f15195a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2), this.f15196b, this.f15197c, this.f15198e, this.f15199f, this.f15200g, this.f15201h, this.f15202i, this.f15203j, this.f15204k, this.f15205l, str);
        }

        /* compiled from: QuickEdit.java */
        /* renamed from: ru.maximoff.apktool.e.aj$9$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass9 f15206a;

            /* renamed from: b */
            private final boolean[] f15207b;

            /* renamed from: c */
            private final boolean[] f15208c;

            /* renamed from: e */
            private final boolean[] f15209e;

            /* renamed from: f */
            private final boolean[] f15210f;

            /* renamed from: g */
            private final boolean[] f15211g;

            /* renamed from: h */
            private final boolean[] f15212h;

            /* renamed from: i */
            private final int[] f15213i;

            /* renamed from: j */
            private final boolean[] f15214j;

            /* renamed from: k */
            private final File f15215k;

            /* renamed from: l */
            private final boolean[] f15216l;

            /* renamed from: m */
            private final String f15217m;

            AnonymousClass1(AnonymousClass9 anonymousClass9, AbstractC0549e abstractC0549e, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, boolean[] zArr4, boolean[] zArr5, boolean[] zArr6, int[] iArr, boolean[] zArr7, File file, boolean[] zArr8, String str) {
                super(abstractC0549e);
                this.f15206a = anonymousClass9;
                this.f15207b = zArr;
                this.f15208c = zArr2;
                this.f15209e = zArr3;
                this.f15210f = zArr4;
                this.f15211g = zArr5;
                this.f15212h = zArr6;
                this.f15213i = iArr;
                this.f15214j = zArr7;
                this.f15215k = file;
                this.f15216l = zArr8;
                this.f15217m = str;
            }

            /* renamed from: a */
            static AnonymousClass9 m17219a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15206a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equals("uses-sdk")) {
                    this.f15207b[0] = true;
                    return new AbstractC0549e(this, super.mo4019a(str, str2), this.f15208c) { // from class: ru.maximoff.apktool.e.aj.9.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f15218a;

                        /* renamed from: b */
                        private final boolean[] f15219b;

                        {
                            this.f15218a = this;
                            this.f15219b = r3;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            Object obj2;
                            int i3 = 16;
                            if (str4.equals("minSdkVersion") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15136j > 0) {
                                Integer num = new Integer(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15136j);
                                this.f15219b[0] = true;
                                obj2 = num;
                            } else if (!str4.equals("targetSdkVersion") || AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15137k <= 0) {
                                obj2 = obj;
                                i3 = i2;
                            } else {
                                Integer num2 = new Integer(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15137k);
                                this.f15219b[1] = true;
                                obj2 = num2;
                            }
                            super.mo4032a(str3, str4, i, i3, obj2);
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4024a() {
                            if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15136j > 0 && !this.f15219b[0]) {
                                int identifier = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15142p.getResources().getIdentifier("minSdkVersion", C0497h.f3457a, "android");
                                if (identifier == 0) {
                                    identifier = C0012R.attr.minSdkVersion;
                                }
                                super.mo4032a("http://schemas.android.com/apk/res/android", "minSdkVersion", identifier, 16, new Integer(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15136j));
                                this.f15219b[0] = true;
                            }
                            if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15137k > 0 && !this.f15219b[1]) {
                                int identifier2 = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15142p.getResources().getIdentifier("targetSdkVersion", C0497h.f3457a, "android");
                                if (identifier2 == 0) {
                                    identifier2 = C0012R.attr.targetSdkVersion;
                                }
                                super.mo4032a("http://schemas.android.com/apk/res/android", "targetSdkVersion", identifier2, 16, new Integer(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15218a)).f15137k));
                                this.f15219b[1] = true;
                            }
                            super.mo4024a();
                        }
                    };
                }
                if (str2.startsWith(UsbManager.EXTRA_PERMISSION_GRANTED) || str2.startsWith("uses-permission")) {
                    return new AbstractC0549e(this, super.mo4019a(str, str2), str2) { // from class: ru.maximoff.apktool.e.aj.9.1.2

                        /* renamed from: a */
                        private final AnonymousClass1 f15220a;

                        /* renamed from: b */
                        private final String f15221b;

                        {
                            this.f15220a = this;
                            this.f15221b = str2;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            Object obj2;
                            String str5;
                            boolean z;
                            boolean z2 = true;
                            if (str4.equals("name") && i2 == 3) {
                                String valueOf = String.valueOf(obj);
                                if (valueOf.startsWith("disabled_")) {
                                    str5 = valueOf.substring(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15127a.length());
                                    z = true;
                                } else {
                                    str5 = valueOf;
                                    z = false;
                                }
                                if (!AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15117E.isEmpty() && this.f15221b.startsWith("uses-permission")) {
                                    Iterator<E> it = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15117E.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        String str6 = (String) it.next();
                                        if (str6.startsWith("disabled_") && str6.equals(new StringBuffer().append("disabled_").append(str5).toString())) {
                                            z = true;
                                            obj = str6;
                                            break;
                                        } else if (str6.equals(str5)) {
                                            z = false;
                                            obj = str6;
                                            break;
                                        }
                                    }
                                }
                                if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15133g != null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15129c != null) {
                                    String[] strArr = C3249i.f19545e;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < strArr.length) {
                                            if (str5.startsWith(strArr[i3])) {
                                                break;
                                            } else {
                                                i3++;
                                            }
                                        } else {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                    if (!z2) {
                                        if (str5.startsWith(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15129c)) {
                                            obj2 = new StringBuffer().append(new StringBuffer().append(z ? "disabled_" : "").append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15133g).toString()).append(str5.substring(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15129c.length())).toString();
                                        } else {
                                            obj2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(z ? "disabled_" : "").append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15220a)).f15133g).toString()).append("_").toString()).append(str5).toString();
                                        }
                                        super.mo4032a(str3, str4, i, i2, obj2);
                                    }
                                }
                            }
                            obj2 = obj;
                            super.mo4032a(str3, str4, i, i2, obj2);
                        }
                    };
                }
                if (str2.equals("application")) {
                    return new AnonymousClass3(this, super.mo4019a(str, str2), this.f15209e, this.f15210f, str, this.f15211g, this.f15212h, this.f15213i, this.f15214j);
                }
                return super.mo4019a(str, str2);
            }

            /* compiled from: QuickEdit.java */
            /* renamed from: ru.maximoff.apktool.e.aj$9$1$3, reason: invalid class name */
            class AnonymousClass3 extends AbstractC0549e {

                /* renamed from: a */
                private final AnonymousClass1 f15222a;

                /* renamed from: b */
                private final boolean[] f15223b;

                /* renamed from: c */
                private final boolean[] f15224c;

                /* renamed from: e */
                private final String f15225e;

                /* renamed from: f */
                private final boolean[] f15226f;

                /* renamed from: g */
                private final boolean[] f15227g;

                /* renamed from: h */
                private final int[] f15228h;

                /* renamed from: i */
                private final boolean[] f15229i;

                AnonymousClass3(AnonymousClass1 anonymousClass1, AbstractC0549e abstractC0549e, boolean[] zArr, boolean[] zArr2, String str, boolean[] zArr3, boolean[] zArr4, int[] iArr, boolean[] zArr5) {
                    super(abstractC0549e);
                    this.f15222a = anonymousClass1;
                    this.f15223b = zArr;
                    this.f15224c = zArr2;
                    this.f15225e = str;
                    this.f15226f = zArr3;
                    this.f15227g = zArr4;
                    this.f15228h = iArr;
                    this.f15229i = zArr5;
                }

                /* renamed from: a */
                static AnonymousClass1 m17220a(AnonymousClass3 anonymousClass3) {
                    return anonymousClass3.f15222a;
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public AbstractC0549e mo4019a(String str, String str2) {
                    if (!AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15140n && ((AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15133g == null || AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15129c == null) && ((AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15130d == null || (AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15131e == null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15132f == null)) && (AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15137k < 31 || AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15139m >= 31)))) {
                        return super.mo4019a(str, str2);
                    }
                    for (String str3 : C3249i.f19544d) {
                        if (str2.equals(str3)) {
                            boolean[] zArr = new boolean[1];
                            zArr[0] = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15137k < 31 || AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15139m >= 31;
                            return new C33781(this, super.mo4019a(str, str2), str2, this.f15223b, this.f15224c, this.f15225e, this.f15226f, zArr);
                        }
                    }
                    return super.mo4019a(str, str2);
                }

                /* compiled from: QuickEdit.java */
                /* renamed from: ru.maximoff.apktool.e.aj$9$1$3$1, reason: invalid class name and collision with other inner class name */
                class C33781 extends AbstractC0549e {

                    /* renamed from: a */
                    private final AnonymousClass3 f15230a;

                    /* renamed from: b */
                    private final String f15231b;

                    /* renamed from: c */
                    private final boolean[] f15232c;

                    /* renamed from: e */
                    private final boolean[] f15233e;

                    /* renamed from: f */
                    private final String f15234f;

                    /* renamed from: g */
                    private final boolean[] f15235g;

                    /* renamed from: h */
                    private final boolean[] f15236h;

                    C33781(AnonymousClass3 anonymousClass3, AbstractC0549e abstractC0549e, String str, boolean[] zArr, boolean[] zArr2, String str2, boolean[] zArr3, boolean[] zArr4) {
                        super(abstractC0549e);
                        this.f15230a = anonymousClass3;
                        this.f15231b = str;
                        this.f15232c = zArr;
                        this.f15233e = zArr2;
                        this.f15234f = str2;
                        this.f15235g = zArr3;
                        this.f15236h = zArr4;
                    }

                    /* renamed from: a */
                    static AnonymousClass3 m17221a(C33781 c33781) {
                        return c33781.f15230a;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public AbstractC0549e mo4019a(String str, String str2) {
                        return ((this.f15231b.equals(C3249i.f19544d[0]) || this.f15231b.equals(C3249i.f19544d[1])) && str2.equals("intent-filter")) ? new AbstractC0549e(this, super.mo4019a(str, str2), this.f15232c, this.f15233e, this.f15234f) { // from class: ru.maximoff.apktool.e.aj.9.1.3.1.1

                            /* renamed from: a */
                            private final C33781 f15237a;

                            /* renamed from: b */
                            private final boolean[] f15238b;

                            /* renamed from: c */
                            private final boolean[] f15239c;

                            /* renamed from: e */
                            private final String f15240e;

                            {
                                this.f15237a = this;
                                this.f15238b = r3;
                                this.f15239c = r4;
                                this.f15240e = r5;
                            }

                            @Override // p060c.p061a.p062a.AbstractC0549e
                            /* renamed from: a */
                            public AbstractC0549e mo4019a(String str3, String str4) {
                                return str4.equals("category") ? new AbstractC0549e(this, super.mo4019a(str3, str4), this.f15238b, this.f15239c) { // from class: ru.maximoff.apktool.e.aj.9.1.3.1.1.1

                                    /* renamed from: a */
                                    private final C33791 f15241a;

                                    /* renamed from: b */
                                    private final boolean[] f15242b;

                                    /* renamed from: c */
                                    private final boolean[] f15243c;

                                    {
                                        this.f15241a = this;
                                        this.f15242b = r3;
                                        this.f15243c = r4;
                                    }

                                    @Override // p060c.p061a.p062a.AbstractC0549e
                                    /* renamed from: a */
                                    public void mo4032a(String str5, String str6, int i, int i2, Object obj) {
                                        if (str6.equals("name")) {
                                            if (obj.equals(Intent.CATEGORY_LAUNCHER)) {
                                                this.f15242b[0] = true;
                                            } else if (obj.equals(Intent.CATEGORY_LEANBACK_LAUNCHER)) {
                                                this.f15243c[0] = true;
                                            }
                                        }
                                        super.mo4032a(str5, str6, i, i2, obj);
                                    }
                                } : super.mo4019a(str3, str4);
                            }

                            @Override // p060c.p061a.p062a.AbstractC0549e
                            /* renamed from: a */
                            public void mo4024a() {
                                if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(C33781.m17221a(this.f15237a)))).f15140n && this.f15238b[0] && !this.f15239c[0]) {
                                    int identifier = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(C33781.m17221a(this.f15237a)))).f15142p.getResources().getIdentifier("name", C0497h.f3457a, "android");
                                    if (identifier == 0) {
                                        identifier = C0012R.attr.name;
                                    }
                                    AbstractC0549e mo4019a = mo4019a(this.f15240e, "category");
                                    mo4019a.mo4032a("http://schemas.android.com/apk/res/android", "name", identifier, 3, Intent.CATEGORY_LEANBACK_LAUNCHER);
                                    mo4019a.mo4024a();
                                }
                                this.f15238b[0] = false;
                                this.f15239c[0] = false;
                                super.mo4024a();
                            }
                        } : super.mo4019a(str, str2);
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4032a(String str, String str2, int i, int i2, Object obj) {
                        Object obj2;
                        int i3;
                        Object obj3;
                        String valueOf;
                        Object obj4;
                        String stringBuffer;
                        String valueOf2;
                        if (str2.equals("name") && (obj instanceof String) && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g != null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c != null) {
                            int indexOf = ((String) obj).indexOf(".");
                            if (indexOf < 0) {
                                obj = new StringBuffer().append(new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c).append(".").toString()).append(obj).toString();
                            } else if (indexOf == 0) {
                                obj = new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c).append(obj).toString();
                            }
                            obj2 = obj;
                            i3 = 3;
                        } else if (str2.equals(Settings.EXTRA_AUTHORITIES) && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g != null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c != null) {
                            if (i2 == 1) {
                                if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15126N != null) {
                                    valueOf2 = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15126N.getString(((Integer) obj).intValue());
                                } else {
                                    valueOf2 = String.valueOf(obj);
                                }
                                obj4 = String.valueOf(valueOf2);
                            } else {
                                obj4 = obj;
                            }
                            String[] split = ((String) obj4).split(";");
                            StringBuilder sb = new StringBuilder();
                            for (int i4 = 0; i4 < split.length; i4++) {
                                String str3 = split[i4];
                                if (str3.startsWith(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c)) {
                                    stringBuffer = new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g).append(str3.substring(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c.length())).toString();
                                } else {
                                    int indexOf2 = str3.indexOf(".");
                                    if (indexOf2 < 0) {
                                        stringBuffer = new StringBuffer().append(new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g).append(".").toString()).append(str3).toString();
                                    } else if (indexOf2 == 0) {
                                        stringBuffer = new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g).append(str3).toString();
                                    } else {
                                        stringBuffer = new StringBuffer().append(new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g).append("_").toString()).append(str3).toString();
                                    }
                                }
                                if (i4 > 0) {
                                    sb.append(";");
                                }
                                sb.append(stringBuffer);
                            }
                            obj2 = sb.toString();
                            i3 = 3;
                        } else if (str2.equals("process") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g != null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c != null) {
                            if (i2 == 1) {
                                if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15126N != null) {
                                    valueOf = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15126N.getString(((Integer) obj).intValue());
                                } else {
                                    valueOf = String.valueOf(obj);
                                }
                                obj3 = String.valueOf(valueOf);
                            } else {
                                obj3 = obj;
                            }
                            if (((String) obj3).startsWith(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c)) {
                                obj3 = new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15133g).append(((String) obj3).substring(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15129c.length())).toString();
                            }
                            obj2 = obj3;
                            i3 = 3;
                        } else if (str2.equals("label") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15130d != null && (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15131e != null || AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15132f != null)) {
                            String valueOf3 = String.valueOf(obj);
                            if (i2 == 1) {
                                valueOf3 = new StringBuffer().append("@").append(valueOf3).toString();
                            }
                            if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15131e != null && valueOf3.equals(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15131e)) {
                                obj = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15130d;
                                this.f15235g[0] = true;
                                i2 = 3;
                            } else if (AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15132f != null && valueOf3.equals(AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15132f)) {
                                obj = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15130d;
                                this.f15235g[0] = true;
                                i2 = 3;
                            }
                            obj2 = obj;
                            i3 = i2;
                        } else {
                            if (str2.equals("exported") && i2 == 18) {
                                this.f15236h[0] = true;
                            }
                            obj2 = obj;
                            i3 = i2;
                        }
                        super.mo4032a(str, str2, i, i3, obj2);
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4024a() {
                        if (!this.f15236h[0]) {
                            int identifier = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15142p.getResources().getIdentifier("exported", C0497h.f3457a, "android");
                            if (identifier == 0) {
                                identifier = C0012R.attr.exported;
                            }
                            super.mo4032a("http://schemas.android.com/apk/res/android", "exported", identifier, 18, new Integer(1));
                        }
                        this.f15236h[0] = AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15137k < 31 || AnonymousClass9.m17218a(AnonymousClass1.m17219a(AnonymousClass3.m17220a(this.f15230a))).f15139m >= 31;
                        super.mo4024a();
                    }
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public void mo4032a(String str, String str2, int i, int i2, Object obj) {
                    Object obj2;
                    int i3 = 3;
                    if (str2.equals("name") && (obj instanceof String) && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15133g != null && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15129c != null) {
                        int indexOf = ((String) obj).indexOf(".");
                        if (indexOf < 0) {
                            obj = new StringBuffer().append(new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15129c).append(".").toString()).append(obj).toString();
                        } else if (indexOf == 0) {
                            obj = new StringBuffer().append(AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15129c).append(obj).toString();
                        }
                        obj2 = obj;
                    } else if (str2.equals("label") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15130d != null) {
                        obj2 = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15130d;
                    } else {
                        if (str2.equals("isSplitRequired") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15141o) {
                            return;
                        }
                        if (str2.equals("debuggable")) {
                            this.f15227g[0] = true;
                            if (!AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15119G) {
                                return;
                            }
                            obj2 = new Integer(1);
                            i3 = i2;
                        } else {
                            if (str2.equals("testOnly") && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15120H) {
                                return;
                            }
                            if (str2.equals("extractNativeLibs")) {
                                obj2 = obj;
                                i3 = i2;
                            } else if (str2.equals("banner") && this.f15228h[0] > 0 && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15140n) {
                                Integer num = new Integer(this.f15228h[0]);
                                this.f15229i[0] = true;
                                obj2 = num;
                                i3 = i2;
                            } else {
                                if (str2.equals("icon") && i2 == 1) {
                                    this.f15228h[0] = ((Integer) obj).intValue();
                                }
                                obj2 = obj;
                                i3 = i2;
                            }
                        }
                    }
                    super.mo4032a(str, str2, i, i3, obj2);
                }

                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public void mo4024a() {
                    if (!this.f15229i[0] && this.f15228h[0] > 0 && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15140n) {
                        int identifier = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15142p.getResources().getIdentifier("banner", C0497h.f3457a, "android");
                        if (identifier == 0) {
                            identifier = C0012R.attr.banner;
                        }
                        super.mo4032a("http://schemas.android.com/apk/res/android", "banner", identifier, 1, new Integer(this.f15228h[0]));
                    }
                    if (!this.f15226f[0] && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15130d != null) {
                        int identifier2 = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15142p.getResources().getIdentifier("label", C0497h.f3457a, "android");
                        if (identifier2 == 0) {
                            identifier2 = C0012R.attr.label;
                        }
                        super.mo4032a("http://schemas.android.com/apk/res/android", "label", identifier2, 3, AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15130d);
                    }
                    if (!this.f15227g[0] && AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15119G) {
                        int identifier3 = AnonymousClass9.m17218a(AnonymousClass1.m17219a(this.f15222a)).f15142p.getResources().getIdentifier("debuggable", C0497h.f3457a, "android");
                        if (identifier3 == 0) {
                            identifier3 = C0012R.attr.debuggable;
                        }
                        super.mo4032a("http://schemas.android.com/apk/res/android", "debuggable", identifier3, 18, new Integer(1));
                    }
                    super.mo4024a();
                }
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public void mo4032a(String str, String str2, int i, int i2, Object obj) {
                Object obj2;
                int i3 = 16;
                if (str2.equals(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME) && AnonymousClass9.m17218a(this.f15206a).f15133g != null) {
                    String str3 = AnonymousClass9.m17218a(this.f15206a).f15133g;
                    File file = new File(this.f15215k.getParentFile(), new StringBuffer().append(AnonymousClass9.m17218a(this.f15206a).f15128b).append("resources.arsc").toString());
                    if (file.exists() && file.isFile()) {
                        try {
                            AnonymousClass9.m17218a(this.f15206a).m17160b(file, C0501a.m3761a(new FileInputStream(file), true, true, false, 0, (C0467a) null, new C3256p()).m3786c().m3679h(), AnonymousClass9.m17218a(this.f15206a).f15133g.length() <= 127 ? AnonymousClass9.m17218a(this.f15206a).f15133g : AnonymousClass9.m17218a(this.f15206a).f15133g.substring(0, 127));
                        } catch (Exception e2) {
                            throw new RuntimeException(new StringBuffer().append("Replacer: ").append(e2.toString()).toString());
                        }
                    }
                    obj2 = str3;
                    i3 = 3;
                } else if (str2.equals("versionName") && AnonymousClass9.m17218a(this.f15206a).f15134h != null) {
                    obj2 = AnonymousClass9.m17218a(this.f15206a).f15134h;
                    i3 = 3;
                } else if (str2.equals("versionCode") && AnonymousClass9.m17218a(this.f15206a).f15135i > 0) {
                    obj2 = new Integer(AnonymousClass9.m17218a(this.f15206a).f15135i);
                } else if (str2.equals("installLocation")) {
                    if (AnonymousClass9.m17218a(this.f15206a).f15150x < 0) {
                        return;
                    }
                    Integer num = new Integer(AnonymousClass9.m17218a(this.f15206a).f15150x);
                    this.f15216l[0] = true;
                    obj2 = num;
                } else {
                    if ((str2.equals("sharedUserId") || str2.equals("sharedUserLabel") || str2.equals("sharedUserMaxSdkVersion")) && AnonymousClass9.m17218a(this.f15206a).f15121I) {
                        return;
                    }
                    obj2 = obj;
                    i3 = i2;
                }
                super.mo4032a(str, str2, i, i3, obj2);
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public void mo4024a() {
                if ((AnonymousClass9.m17218a(this.f15206a).f15136j > 0 || AnonymousClass9.m17218a(this.f15206a).f15137k > 0) && !this.f15207b[0]) {
                    AbstractC0549e mo4019a = mo4019a(this.f15217m, "uses-sdk");
                    if (AnonymousClass9.m17218a(this.f15206a).f15136j > 0) {
                        int identifier = AnonymousClass9.m17218a(this.f15206a).f15142p.getResources().getIdentifier("minSdkVersion", C0497h.f3457a, "android");
                        if (identifier == 0) {
                            identifier = C0012R.attr.minSdkVersion;
                        }
                        mo4019a.mo4032a("http://schemas.android.com/apk/res/android", "minSdkVersion", identifier, 16, new Integer(AnonymousClass9.m17218a(this.f15206a).f15136j));
                        this.f15208c[0] = true;
                    }
                    if (AnonymousClass9.m17218a(this.f15206a).f15137k > 0) {
                        int identifier2 = AnonymousClass9.m17218a(this.f15206a).f15142p.getResources().getIdentifier("targetSdkVersion", C0497h.f3457a, "android");
                        if (identifier2 == 0) {
                            identifier2 = C0012R.attr.targetSdkVersion;
                        }
                        mo4019a.mo4032a("http://schemas.android.com/apk/res/android", "targetSdkVersion", identifier2, 16, new Integer(AnonymousClass9.m17218a(this.f15206a).f15137k));
                        this.f15208c[1] = true;
                    }
                    mo4019a.mo4024a();
                    this.f15207b[0] = true;
                }
                if (!this.f15216l[0] && AnonymousClass9.m17218a(this.f15206a).f15150x >= 0) {
                    int identifier3 = AnonymousClass9.m17218a(this.f15206a).f15142p.getResources().getIdentifier("installLocation", C0497h.f3457a, "android");
                    if (identifier3 == 0) {
                        identifier3 = C0012R.attr.installLocation;
                    }
                    super.mo4032a("http://schemas.android.com/apk/res/android", "installLocation", identifier3, 16, new Integer(AnonymousClass9.m17218a(this.f15206a).f15150x));
                }
                super.mo4024a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17160b(File file, String str, String str2) {
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bytes2 = str2.getBytes("UTF-8");
        byte[] bArr = new byte[256];
        byte[] bArr2 = new byte[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i < bytes.length && i2 % 2 == 0) {
                bArr[i2] = bytes[i];
                i++;
            } else {
                bArr[i2] = (byte) 0;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            if (i3 < bytes2.length && i4 % 2 == 0) {
                bArr2[i4] = bytes2[i3];
                i3++;
            } else {
                bArr2[i4] = (byte) 0;
            }
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C1887e.m13984b(fileInputStream));
        C3094az c3094az = new C3094az(byteArrayInputStream, bArr, bArr2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr3 = new byte[C3249i.m19500a()];
        while (true) {
            int read = c3094az.read(bArr3);
            if (read != -1) {
                fileOutputStream.write(bArr3, 0, read);
            } else {
                byteArrayInputStream.close();
                fileInputStream.close();
                c3094az.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    /* renamed from: a */
    private File m17144a(File file, String str) {
        String parent = file.getParentFile().getParent();
        if (str == null) {
            str = file.getName();
        }
        return new File(parent, C3262u.m19623b(this.f15142p, parent, C3112bn.m19033h(str), "_mod", 0));
    }

    /* renamed from: a */
    private void m17153a(String str, String str2, String str3) {
        BufferedInputStream bufferedInputStream;
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (!C3112bn.m19040o(name)) {
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                long crc = nextElement.getCrc();
                String stringBuffer = (name.equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME) || name.equals("resources.arsc")) ? new StringBuffer().append(this.f15128b).append(name).toString() : name;
                File file = new File(new StringBuffer().append(new StringBuffer().append(str3).append(File.separator).toString()).append(stringBuffer).toString());
                if (C3262u.m19615a(file, stringBuffer) && file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    if (nextElement.getMethod() == 0 || (name.equals("resources.arsc") && this.f15137k > 29)) {
                        c2602u.setMethod(0);
                        c2602u.setSize(file.length());
                        c2602u.setCompressedSize(file.length());
                        c2602u.setCrc(C3117bs.m19055a(file));
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
                    fileInputStream.close();
                    file.delete();
                } else {
                    bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                    if (nextElement.getMethod() == 0 && crc >= 0 && size >= 0) {
                        c2602u.setMethod(0);
                        c2602u.setSize(size);
                        c2602u.setCompressedSize(size);
                        c2602u.setCrc(crc);
                    } else if (name.equals("resources.arsc") && this.f15137k > 29) {
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
                        int read2 = bufferedInputStream.read(bArr);
                        if (read2 == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read2);
                        }
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
    public void m17190a(List<String> list) {
        this.f15117E = list;
    }

    /* renamed from: a */
    public void m17189a(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.f15146t = str;
    }

    /* renamed from: a */
    public void m17185a(int i) {
        this.f15149w = i;
    }

    /* renamed from: b */
    public void m17193b(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.f15152z = str;
    }

    /* renamed from: b */
    public void m17192b(int i) {
        this.f15113A = i;
    }

    /* renamed from: c */
    public void m17196c(String str) {
        this.f15130d = str;
    }

    /* renamed from: d */
    public void m17199d(String str) {
        this.f15131e = str;
    }

    /* renamed from: e */
    public void m17202e(String str) {
        this.f15132f = str;
    }

    /* renamed from: f */
    public void m17205f(String str) {
        this.f15133g = str;
    }

    /* renamed from: g */
    public void m17208g(String str) {
        this.f15129c = str;
    }

    /* renamed from: h */
    public void m17211h(String str) {
        this.f15134h = str;
    }

    /* renamed from: c */
    public void m17195c(int i) {
        this.f15135i = i;
    }

    /* renamed from: d */
    public void m17198d(int i) {
        this.f15136j = i;
    }

    /* renamed from: e */
    public void m17201e(int i) {
        this.f15137k = i;
    }

    /* renamed from: f */
    public void m17204f(int i) {
        this.f15138l = i;
    }

    /* renamed from: g */
    public void m17207g(int i) {
        this.f15139m = i;
    }

    /* renamed from: a */
    public void m17191a(boolean z) {
        this.f15141o = z;
    }

    /* renamed from: b */
    public void m17194b(boolean z) {
        this.f15119G = z;
    }

    /* renamed from: a */
    public void m17186a(Resources resources) {
        this.f15126N = resources;
    }

    /* renamed from: c */
    public void m17197c(boolean z) {
        this.f15120H = z;
    }

    /* renamed from: d */
    public void m17200d(boolean z) {
        this.f15121I = z;
    }

    /* renamed from: a */
    public void m17187a(Bitmap bitmap) {
        this.f15145s = bitmap;
    }

    /* renamed from: e */
    public void m17203e(boolean z) {
        this.f15114B = z;
    }

    /* renamed from: f */
    public void m17206f(boolean z) {
        this.f15122J = z;
    }

    /* renamed from: h */
    public void m17210h(int i) {
        this.f15116D = i;
    }

    /* renamed from: i */
    public void m17213i(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.f15150x = i - 1;
    }

    /* renamed from: g */
    public void m17209g(boolean z) {
        this.f15140n = z;
    }

    /* renamed from: h */
    public void m17212h(boolean z) {
        this.f15123K = z;
    }
}
