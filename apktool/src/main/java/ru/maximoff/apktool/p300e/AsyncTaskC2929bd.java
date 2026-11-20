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
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.p311b.C3317a;

/* compiled from: ZipAlign.java */
/* renamed from: ru.maximoff.apktool.e.bd */
/* loaded from: classes.dex */
public class AsyncTaskC2929bd extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15575a;

    /* renamed from: b */
    private InterfaceC2995n f15576b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15577c;

    /* renamed from: f */
    private int f15580f;

    /* renamed from: d */
    private List<String> f15578d = new ArrayList();

    /* renamed from: e */
    private boolean f15579e = false;

    /* renamed from: g */
    private boolean f15581g = false;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17452a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17454a(bool);
    }

    public AsyncTaskC2929bd(Context context, InterfaceC2995n interfaceC2995n, int i) {
        this.f15575a = context;
        this.f15576b = interfaceC2995n;
        this.f15580f = i;
    }

    /* renamed from: a */
    public void m17453a() {
        this.f15581g = true;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15575a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15577c = new DialogInterfaceC0070b.a(this.f15575a).m435b(inflate).m429a(false).m438b();
        this.f15577c.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00da A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Boolean m17452a(File[] fileArr) {
        int i;
        int i2 = 0;
        for (File file : fileArr) {
            File file2 = new File(file.getParentFile(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".za_unsigned_").append(System.currentTimeMillis()).toString()).append("_").toString()).append(file.getName()).toString());
            try {
                try {
                    try {
                    } catch (Error e2) {
                        e = e2;
                        i = i2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    i = i2;
                }
                if (this.f15581g) {
                    String m17450a = m17450a(file);
                    if (m17450a == null) {
                        i = i2 + 1;
                        try {
                            if (file2.exists()) {
                                file2.delete();
                            }
                        } catch (Error e4) {
                            e = e4;
                            this.f15578d.add(Log.getStackTraceString(e));
                            i2 = i;
                        } catch (Exception e5) {
                            e = e5;
                            this.f15578d.add(Log.getStackTraceString(e));
                            i2 = i;
                        }
                    } else {
                        i = C3317a.m20052a(file.getAbsolutePath(), m17450a) ? i2 + 1 : i2;
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                } else {
                    int[] iArr = new int[1];
                    try {
                        iArr[0] = new C3081am(file).m18632h();
                    } catch (Exception e6) {
                        iArr[0] = 14;
                    }
                    InterfaceC0008c m18964a = (this.f15580f == 0 && C3102bd.m18925a(this.f15575a, "save_sign_data", true)) ? C3105bg.m18964a(file) : (InterfaceC0008c) null;
                    File m17449a = m17449a(file, (String) null);
                    if (m17449a == null) {
                        i = i2 + 1;
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } else {
                        int i3 = C3317a.m20052a(file.getAbsolutePath(), file2.getAbsolutePath()) ? i2 + 1 : i2;
                        try {
                            C2917as.m17314a(this.f15575a, this.f15580f, new C2917as.a(this, file2, m17449a, m18964a, iArr) { // from class: ru.maximoff.apktool.e.bd.1

                                /* renamed from: a */
                                private final AsyncTaskC2929bd f15582a;

                                /* renamed from: b */
                                private final File f15583b;

                                /* renamed from: c */
                                private final File f15584c;

                                /* renamed from: d */
                                private final InterfaceC0008c f15585d;

                                /* renamed from: e */
                                private final int[] f15586e;

                                {
                                    this.f15582a = this;
                                    this.f15583b = file2;
                                    this.f15584c = m17449a;
                                    this.f15585d = m18964a;
                                    this.f15586e = iArr;
                                }

                                @Override // ru.maximoff.apktool.p300e.C2917as.a
                                /* renamed from: a */
                                public void mo16440a(C2917as c2917as, boolean z) {
                                    if (z) {
                                        this.f15583b.renameTo(this.f15584c);
                                        if (this.f15585d != null) {
                                            try {
                                                C3105bg.m18967a(this.f15584c, this.f15585d);
                                                return;
                                            } catch (IOException e7) {
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    c2917as.m17320a(this.f15583b, this.f15584c, this.f15586e[0]);
                                    this.f15583b.delete();
                                }
                            });
                            i = i3;
                        } catch (Error e7) {
                            e = e7;
                            i = i3;
                            this.f15578d.add(Log.getStackTraceString(e));
                            i2 = i;
                        } catch (Exception e8) {
                            e = e8;
                            i = i3;
                            this.f15578d.add(Log.getStackTraceString(e));
                            i2 = i;
                        }
                    }
                }
                i2 = i;
            } finally {
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        return new Boolean(i2 == 0);
    }

    /* renamed from: a */
    protected void m17454a(Boolean bool) {
        if (this.f15577c != null && this.f15577c.isShowing()) {
            try {
                this.f15577c.cancel();
            } catch (Exception e2) {
            }
        }
        this.f15576b.mo17929a();
        if (!this.f15578d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15578d, "\n\n");
            new C3078aj(this.f15575a).m18494a(R.string.error).m18496a(this.f15575a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.bd.2

                /* renamed from: a */
                private final AsyncTaskC2929bd f15587a;

                /* renamed from: b */
                private final String f15588b;

                {
                    this.f15587a = this;
                    this.f15588b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15587a.f15575a, this.f15588b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15579e) {
            new C3078aj(this.f15575a).m18494a(R.string.complete).m18496a(this.f15575a.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.bd.3

                /* renamed from: a */
                private final AsyncTaskC2929bd f15589a;

                {
                    this.f15589a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f15589a.f15576b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private String m17450a(File file) {
        String str;
        boolean z = !C3262u.m19664g(this.f15575a, file);
        String parent = file.getParent();
        if (z) {
            String str2 = C3102bd.f18339v;
            if (str2 == null) {
                this.f15578d.add(this.f15575a.getString(R.string.output_directory_not_set));
                return (String) null;
            }
            File file2 = new File(str2);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15578d.add(this.f15575a.getString(R.string.output_directory_not_extsts, str2));
                return (String) null;
            }
            if (!file2.isDirectory()) {
                this.f15578d.add(this.f15575a.getString(R.string.not_directory, str2));
                return (String) null;
            }
            this.f15579e = !str2.equals(file.getParent());
            str = str2;
        } else {
            str = parent;
        }
        String[] m19641b = C3262u.m19641b(file.getName());
        return new StringBuffer().append(new StringBuffer().append(str).append("/").toString()).append(C3262u.m19566a(this.f15575a, str, new StringBuffer().append(m19641b[0]).append("_aligned").toString(), new StringBuffer().append(".").append(m19641b[1]).toString(), 0)).toString();
    }

    /* renamed from: a */
    private File m17449a(File file, String str) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15575a, file)) || C3102bd.m18925a(this.f15575a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15578d.add(this.f15575a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15578d.add(this.f15575a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15578d.add(this.f15575a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15579e = !parent.equals(file.getParent());
        }
        String str2 = parent;
        if (str == null) {
            str = file.getName();
        }
        return new File(str2, C3262u.m19623b(this.f15575a, str2, str, "_aligned", 0));
    }
}
