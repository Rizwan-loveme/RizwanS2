package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3078aj;
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

/* compiled from: UltraZip.java */
/* renamed from: ru.maximoff.apktool.e.ax */
/* loaded from: classes.dex */
public class AsyncTaskC2922ax extends AsyncTask<File, String, Boolean> {

    /* renamed from: c */
    private Context f15437c;

    /* renamed from: d */
    private InterfaceC2995n f15438d;

    /* renamed from: e */
    private DialogInterfaceC0070b f15439e;

    /* renamed from: h */
    private boolean f15442h;

    /* renamed from: i */
    private int f15443i;

    /* renamed from: a */
    private final String[] f15435a = {"assets/dexopt/", "assets/ugc", "assets/yandexnavi/fonts/tiles", "res/raw/netdisk", "assets/yandexnavi/fonts/", "res/raw/langid.data", "res/raw/joda", "assets/adp", "assets/js-modules/UNBUNDLE", "res/raw/estool", "res/raw/feature", "res/raw/irlocaldata", "assets/sound-strings/", "res/raw/selection", "res/raw/sb", "res/raw/guides", "res/raw/metadata.json", "res/raw/sm", "assets/cuisine-strings/", "res/raw/fill", "res/raw/transform", "assets/metadata.json", "res/raw/copic", "res/raw/layers", "res/raw/dav", "res/raw/test", "res/raw/timelapse", "res/raw/pulsar", "res/raw/cuscs", "res/raw/gtm", "res/raw/megviifacepp", "assets/countries-strings/", "assets/services/", "res/raw/ep", "assets/ABBYY.license", "res/raw/bnbp", "res/raw/tw", "res/raw/bear.tiff", "res/raw/yvideo", "res/raw/spki"};

    /* renamed from: b */
    private final String[] f15436b = {".jpg", ".jpeg", ".png", ".gif", ".wav", ".mp2", ".mp3", ".ogg", ".aac", ".mpg", ".mpeg", ".mid", ".midi", ".smf", ".jet", ".rtttl", ".imy", ".xmf", ".mp4", ".m4a", ".m4v", ".3gp", ".3gpp", ".3g2", ".3gpp2", ".amr", ".awb", ".wma", ".wmv", ".avc", ".der", ".pfx", ".kml", ".pic", ".bc", ".key", ".glsl", ".plugin", ".p12", ".dat", ".cer", ".pb", ".bks", ".woff2", ".res", "/thumbnail", ".binarypb", ".bin", ".dict", ".zip", ".pk8", ".mov", ".crt"};

    /* renamed from: f */
    private List<String> f15440f = new ArrayList();

    /* renamed from: g */
    private boolean f15441g = false;

    /* renamed from: j */
    private int f15444j = 0;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17369a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17370a(bool);
    }

    public AsyncTaskC2922ax(Context context, InterfaceC2995n interfaceC2995n, int i, boolean z) {
        this.f15437c = context;
        this.f15438d = interfaceC2995n;
        this.f15443i = i;
        this.f15442h = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15437c).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15439e = new DialogInterfaceC0070b.a(this.f15437c).m435b(inflate).m429a(false).m438b();
        this.f15439e.show();
    }

    /* renamed from: a */
    protected Boolean m17369a(File[] fileArr) {
        int i;
        InterfaceC0008c interfaceC0008c;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = i2;
            if (i4 >= fileArr.length) {
                break;
            }
            File file = fileArr[i4];
            int[] iArr = new int[1];
            try {
                C3081am c3081am = new C3081am(file);
                iArr[0] = c3081am.m18632h();
                this.f15444j = c3081am.m18633i();
            } catch (Exception e2) {
                iArr[0] = 14;
                this.f15444j = 0;
            }
            if (this.f15443i == 0 && C3102bd.m18925a(this.f15437c, "save_sign_data", true)) {
                interfaceC0008c = C3105bg.m18964a(file);
            } else {
                interfaceC0008c = (InterfaceC0008c) null;
            }
            File m17363a = m17363a(file, (String) null);
            if (m17363a == null) {
                i2 = i + 1;
            } else {
                File file2 = new File(m17363a.getParentFile(), new StringBuffer().append(new StringBuffer().append(System.currentTimeMillis()).append("_unsign_").toString()).append(m17363a.getName()).toString());
                try {
                    File createTempFile = File.createTempFile("APKTOOL_M", ".ultra", C3102bd.m18908a());
                    m17365a(file.getAbsolutePath(), createTempFile.getAbsolutePath());
                    C3317a.m20052a(createTempFile.getAbsolutePath(), file2.getAbsolutePath());
                    if (createTempFile.exists()) {
                        createTempFile.delete();
                    }
                    C2917as.m17314a(this.f15437c, this.f15443i, new C2917as.a(this, file2, m17363a, interfaceC0008c, iArr) { // from class: ru.maximoff.apktool.e.ax.1

                        /* renamed from: a */
                        private final AsyncTaskC2922ax f15445a;

                        /* renamed from: b */
                        private final File f15446b;

                        /* renamed from: c */
                        private final File f15447c;

                        /* renamed from: d */
                        private final InterfaceC0008c f15448d;

                        /* renamed from: e */
                        private final int[] f15449e;

                        {
                            this.f15445a = this;
                            this.f15446b = file2;
                            this.f15447c = m17363a;
                            this.f15448d = interfaceC0008c;
                            this.f15449e = iArr;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                this.f15446b.renameTo(this.f15447c);
                                if (this.f15448d != null) {
                                    try {
                                        C3105bg.m18967a(this.f15447c, this.f15448d);
                                        return;
                                    } catch (IOException e3) {
                                        return;
                                    }
                                }
                                return;
                            }
                            c2917as.m17320a(this.f15446b, this.f15447c, this.f15449e[0]);
                            this.f15446b.delete();
                        }
                    });
                    i2 = i;
                } catch (Exception e3) {
                    this.f15440f.add(e3.getMessage());
                    i2 = i + 1;
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }
            i3 = i4 + 1;
        }
        return new Boolean(i == 0);
    }

    /* renamed from: a */
    protected void m17370a(Boolean bool) {
        if (this.f15439e != null && this.f15439e.isShowing()) {
            try {
                this.f15439e.cancel();
            } catch (Exception e2) {
            }
        }
        this.f15438d.mo17929a();
        if (!this.f15440f.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15440f, "\n\n");
            new C3078aj(this.f15437c).m18494a(R.string.error).m18496a(this.f15437c.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.ax.2

                /* renamed from: a */
                private final AsyncTaskC2922ax f15450a;

                /* renamed from: b */
                private final String f15451b;

                {
                    this.f15450a = this;
                    this.f15451b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15450a.f15437c, this.f15451b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15441g) {
            new C3078aj(this.f15437c).m18494a(R.string.complete).m18496a(this.f15437c.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.ax.3

                /* renamed from: a */
                private final AsyncTaskC2922ax f15452a;

                {
                    this.f15452a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f15452a.f15438d.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17363a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15437c, file)) || C3102bd.m18925a(this.f15437c, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15440f.add(this.f15437c.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15440f.add(this.f15437c.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15440f.add(this.f15437c.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15441g = !parent.equals(file.getParent());
        }
        String str2 = parent;
        if (str == null) {
            str = file.getName();
        }
        return new File(str2, C3262u.m19623b(this.f15437c, str2, str, "_ultra", 0));
    }

    /* renamed from: a */
    private void m17365a(String str, String str2) {
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        m19496a.m16212a(9);
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(name)) {
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
                    m17364a(createTempFile, createTempFile2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(createTempFile2), bArr.length);
                C2602u c2602u = new C2602u(name);
                c2602u.setCrc(C3117bs.m19055a(createTempFile2));
                c2602u.setTime(nextElement.getTime());
                c2602u.setCompressedSize(-1L);
                m19496a.mo16214a(c2602u);
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
                if (m17366a(name) && size >= 0) {
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
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private void m17364a(File file, File file2) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new AnonymousClass4(this, c0548d));
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* compiled from: UltraZip.java */
    /* renamed from: ru.maximoff.apktool.e.ax$4, reason: invalid class name */
    class AnonymousClass4 extends C0547c {

        /* renamed from: a */
        private final AsyncTaskC2922ax f15453a;

        AnonymousClass4(AsyncTaskC2922ax asyncTaskC2922ax, AbstractC0549e abstractC0549e) {
            super(abstractC0549e);
            this.f15453a = asyncTaskC2922ax;
        }

        /* renamed from: a */
        static AsyncTaskC2922ax m17371a(AnonymousClass4 anonymousClass4) {
            return anonymousClass4.f15453a;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new AnonymousClass1(this, super.mo4019a(str, str2));
        }

        /* compiled from: UltraZip.java */
        /* renamed from: ru.maximoff.apktool.e.ax$4$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0549e {

            /* renamed from: a */
            private final AnonymousClass4 f15454a;

            AnonymousClass1(AnonymousClass4 anonymousClass4, AbstractC0549e abstractC0549e) {
                super(abstractC0549e);
                this.f15454a = anonymousClass4;
            }

            /* renamed from: a */
            static AnonymousClass4 m17372a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f15454a;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equalsIgnoreCase("application")) {
                    return new AbstractC0549e(this, super.mo4019a(str, str2)) { // from class: ru.maximoff.apktool.e.ax.4.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f15455a;

                        {
                            this.f15455a = this;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            if (str4.equalsIgnoreCase("extractNativeLibs")) {
                                return;
                            }
                            super.mo4032a(str3, str4, i, i2, obj);
                        }
                    };
                }
                if (str2.equalsIgnoreCase("uses-sdk")) {
                    return new AbstractC0549e(this, super.mo4019a(str, str2)) { // from class: ru.maximoff.apktool.e.ax.4.1.2

                        /* renamed from: a */
                        private final AnonymousClass1 f15456a;

                        {
                            this.f15456a = this;
                        }

                        @Override // p060c.p061a.p062a.AbstractC0549e
                        /* renamed from: a */
                        public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                            super.mo4032a(str3, str4, i, i2, (AnonymousClass4.m17371a(AnonymousClass1.m17372a(this.f15456a)).f15442h && str4.equalsIgnoreCase("targetSdkVersion") && ((Integer) obj).intValue() > 29) ? new Integer(29) : obj);
                        }
                    };
                }
                return super.mo4019a(str, str2);
            }
        }
    }

    /* renamed from: a */
    private boolean m17366a(String str) {
        if (str.equals("resources.arsc") && this.f15444j > 29 && !this.f15442h) {
            return true;
        }
        for (String str2 : this.f15435a) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        if (!str.startsWith("res/") && !str.toLowerCase().startsWith("r/") && !str.startsWith("assets/")) {
            return false;
        }
        for (String str3 : this.f15436b) {
            if (str.endsWith(str3)) {
                return true;
            }
        }
        return false;
    }
}
