package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.p008os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;

/* compiled from: UnApkmTask.java */
/* renamed from: ru.maximoff.apktool.e.ay */
/* loaded from: classes.dex */
public class AsyncTaskC2923ay extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15457a;

    /* renamed from: b */
    private InterfaceC2995n f15458b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15459c;

    /* renamed from: d */
    private List<String> f15460d;

    /* renamed from: e */
    private boolean f15461e;

    /* renamed from: f */
    private String f15462f;

    /* renamed from: g */
    private boolean f15463g;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17376a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17377a(bool);
    }

    public AsyncTaskC2923ay(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15457a = context;
        this.f15458b = interfaceC2995n;
        this.f15460d = new ArrayList();
        this.f15461e = false;
        this.f15462f = (String) null;
        this.f15463g = false;
    }

    public AsyncTaskC2923ay(Context context, String str, boolean z) {
        this.f15457a = context;
        this.f15458b = (InterfaceC2995n) null;
        this.f15460d = new ArrayList();
        this.f15461e = false;
        this.f15462f = str;
        this.f15463g = z;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15457a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15459c = new DialogInterfaceC0070b.a(this.f15457a).m435b(inflate).m429a(false).m438b();
        this.f15459c.show();
    }

    /* renamed from: a */
    protected Boolean m17376a(File[] fileArr) {
        for (File file : fileArr) {
            try {
                try {
                    if (this.f15462f == null) {
                        this.f15462f = m17374a(file);
                    } else {
                        this.f15462f = m17375a(this.f15462f);
                    }
                } catch (Exception e2) {
                    this.f15460d.add(Log.getStackTraceString(e2));
                }
                if (C3262u.m19654d(file)) {
                    C3117bs.m19065a(file.getAbsolutePath(), this.f15462f, C3117bs.m19060a(file.getAbsolutePath(), ".apk"));
                    if (this.f15463g) {
                        file.delete();
                    }
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Context m18592d = C3080al.m18592d(this.f15457a, new StringBuffer().append(this.f15457a.getPackageName()).append(".unapkm").toString());
                    if (m18592d == null) {
                        throw new Exception("Failed load UnApkm plugin context, break");
                    }
                    Class<?> loadClass = m18592d.getClassLoader().loadClass(new StringBuffer().append(this.f15457a.getPackageName()).append(".unapkm.UnApkm").toString());
                    Class<?>[] clsArr = new Class[1];
                    try {
                        clsArr[0] = Class.forName("java.io.InputStream");
                        InputStream inputStream = (InputStream) loadClass.getDeclaredMethod("decryptStream", clsArr).invoke((Object) null, fileInputStream);
                        C3248b m19496a = C3248b.m19496a(new FileOutputStream(this.f15462f));
                        m19496a.m16215a(C3102bd.f18315aw);
                        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                        byte[] bArr = new byte[C3249i.m19500a()];
                        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                            C2602u c2602u = new C2602u(nextEntry);
                            c2602u.setCompressedSize(-1L);
                            m19496a.mo16214a(c2602u);
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                m19496a.write(bArr, 0, read);
                            }
                            m19496a.flush();
                            m19496a.m16218b();
                            zipInputStream.closeEntry();
                        }
                        zipInputStream.close();
                        m19496a.close();
                        if (this.f15463g) {
                            file.delete();
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new NoClassDefFoundError(e3.getMessage());
                    }
                }
            } catch (Throwable th) {
                if (this.f15463g) {
                    file.delete();
                }
                throw th;
            }
        }
        return new Boolean(true);
    }

    /* renamed from: a */
    protected void m17377a(Boolean bool) {
        if (this.f15459c != null && this.f15459c.isShowing()) {
            try {
                this.f15459c.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15458b != null) {
            this.f15458b.mo17929a();
        }
        if (!this.f15460d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15460d, "\n\n");
            new C3078aj(this.f15457a).m18494a(R.string.error).m18496a(this.f15457a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.ay.1

                /* renamed from: a */
                private final AsyncTaskC2923ay f15464a;

                /* renamed from: b */
                private final String f15465b;

                {
                    this.f15464a = this;
                    this.f15465b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15464a.f15457a, this.f15465b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15461e) {
            new C3078aj(this.f15457a).m18494a(R.string.complete).m18496a(this.f15457a.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.ay.2

                /* renamed from: a */
                private final AsyncTaskC2923ay f15466a;

                {
                    this.f15466a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.m16615o().m16622a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
        try {
            if (!new File(this.f15462f).exists()) {
                C3112bn.m19023b(this.f15457a, this.f15457a.getString(R.string.errorf, "failed to convert!"));
            }
        } catch (Exception e3) {
            C3112bn.m19023b(this.f15457a, this.f15457a.getString(R.string.errorf, e3.getMessage()));
        }
    }

    /* renamed from: a */
    private String m17375a(String str) {
        String str2 = C3102bd.f18339v;
        if (str2 == null) {
            this.f15460d.add(this.f15457a.getString(R.string.output_directory_not_set));
            return (String) null;
        }
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            this.f15460d.add(this.f15457a.getString(R.string.output_directory_not_extsts, str2));
            return (String) null;
        }
        if (!file.isDirectory()) {
            this.f15460d.add(this.f15457a.getString(R.string.not_directory, str2));
            return (String) null;
        }
        this.f15461e = true;
        return new StringBuffer().append(new StringBuffer().append(str2).append(File.separator).toString()).append(C3262u.m19566a(this.f15457a, str2, C3262u.m19641b(str)[0], ".apks", 0)).toString();
    }

    /* renamed from: a */
    private String m17374a(File file) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15457a, file)) || C3102bd.m18925a(this.f15457a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15460d.add(this.f15457a.getString(R.string.output_directory_not_set));
                return (String) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15460d.add(this.f15457a.getString(R.string.output_directory_not_extsts, parent));
                return (String) null;
            }
            if (!file2.isDirectory()) {
                this.f15460d.add(this.f15457a.getString(R.string.not_directory, parent));
                return (String) null;
            }
            this.f15461e = !parent.equals(file.getParent());
        }
        String str = parent;
        return new StringBuffer().append(new StringBuffer().append(str).append(File.separator).toString()).append(C3262u.m19566a(this.f15457a, str, C3262u.m19641b(file.getName())[0], ".apks", 0)).toString();
    }
}
