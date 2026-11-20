package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.nicdahlquist.pngquant.LibPngQuant;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: PngQuant.java */
/* renamed from: ru.maximoff.apktool.e.af */
/* loaded from: classes.dex */
public class AsyncTaskC2904af extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15059a;

    /* renamed from: b */
    private InterfaceC2995n f15060b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15061c;

    /* renamed from: f */
    private boolean f15064f;

    /* renamed from: d */
    private List<String> f15062d = new ArrayList();

    /* renamed from: e */
    private boolean f15063e = false;

    /* renamed from: g */
    private int f15065g = 0;

    /* renamed from: h */
    private int f15066h = 0;

    /* renamed from: i */
    private List<String> f15067i = new ArrayList();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17121a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17122a(bool);
    }

    public AsyncTaskC2904af(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15059a = context;
        this.f15060b = interfaceC2995n;
        this.f15064f = C3102bd.m18925a(this.f15059a, "imgs_backup", false);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15059a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15061c = new DialogInterfaceC0070b.a(this.f15059a).m435b(inflate).m429a(false).m438b();
        this.f15061c.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* renamed from: a */
    protected Boolean m17121a(File[] fileArr) {
        this.f15065g = fileArr.length;
        boolean z = !C3262u.m19664g(this.f15059a, fileArr[0]);
        if (z) {
            this.f15064f = false;
        }
        int r0 = 0;
        int i = 0;
        while (r0 < fileArr.length) {
            File file = fileArr[r0];
            try {
                if (C3262u.m19663f(file)) {
                    File m17119a = m17119a(file, C3262u.m19641b(file.getName())[0], this.f15064f, z);
                    if (m17119a == null) {
                        return new Boolean(false);
                    }
                    File createTempFile = File.createTempFile("APKTOOL_M", ".tmpquant", C3102bd.m18908a());
                    if (new LibPngQuant().m11224a(file, createTempFile)) {
                        if (this.f15064f) {
                            C3262u.m19612a(file, m17119a);
                            C3262u.m19612a(createTempFile, file);
                            this.f15067i.add(file.getAbsolutePath());
                        } else {
                            C3262u.m19612a(createTempFile, m17119a);
                            this.f15067i.add(m17119a.getAbsolutePath());
                        }
                        createTempFile.delete();
                        this.f15066h++;
                    }
                } else {
                    continue;
                }
            } catch (Error e2) {
                i++;
                this.f15062d.add(e2.getMessage());
            } catch (Exception e3) {
                i++;
                this.f15062d.add(e3.getMessage());
            }
            r0++;
        }
        return new Boolean(i == 0);
    }

    /* renamed from: a */
    protected void m17122a(Boolean bool) {
        int i;
        if (this.f15061c != null && this.f15061c.isShowing()) {
            try {
                this.f15061c.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15060b != null) {
            this.f15060b.mo17929a();
            this.f15060b.mo17935a(this.f15067i);
        }
        C3112bn.m19023b(this.f15059a, this.f15059a.getString(R.string.success_of, new Integer(this.f15066h), new Integer(this.f15065g)));
        if (!this.f15062d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15062d, "\n\n");
            new C3078aj(this.f15059a).m18494a(R.string.error).m18496a(this.f15059a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.af.1

                /* renamed from: a */
                private final AsyncTaskC2904af f15068a;

                /* renamed from: b */
                private final String f15069b;

                {
                    this.f15068a = this;
                    this.f15069b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15068a.f15059a, this.f15069b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15063e) {
            if (this.f15064f) {
                i = R.string.complete_msg;
            } else {
                i = R.string.complete_msg2;
            }
            new C3078aj(this.f15059a).m18494a(R.string.complete).m18496a(this.f15059a.getString(i, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.af.2

                /* renamed from: a */
                private final AsyncTaskC2904af f15070a;

                {
                    this.f15070a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15070a.f15060b == null) {
                        return;
                    }
                    this.f15070a.f15060b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17119a(File file, String str, boolean z, boolean z2) {
        String parent = file.getParent();
        if (z2 || C3102bd.m18925a(this.f15059a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15062d.add(this.f15059a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15062d.add(this.f15059a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15062d.add(this.f15059a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15063e = !parent.equals(file.getParent());
        }
        String str2 = parent;
        if (!this.f15063e && !z) {
            return file;
        }
        String name = str == null ? file.getName() : str;
        if (z && !this.f15063e) {
            name = new StringBuffer().append(name).append("_orig").toString();
        }
        return new File(str2, C3262u.m19566a(this.f15059a, str2, name, ".png", 0));
    }
}
