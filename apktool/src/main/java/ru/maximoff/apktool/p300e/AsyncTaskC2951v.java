package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: FileDummy.java */
/* renamed from: ru.maximoff.apktool.e.v */
/* loaded from: classes.dex */
public class AsyncTaskC2951v extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15798a;

    /* renamed from: b */
    private InterfaceC2995n f15799b;

    /* renamed from: h */
    private DialogInterfaceC0070b f15805h;

    /* renamed from: g */
    private boolean f15804g = false;

    /* renamed from: c */
    private List<String> f15800c = new ArrayList();

    /* renamed from: d */
    private List<String> f15801d = new ArrayList();

    /* renamed from: e */
    private int f15802e = 0;

    /* renamed from: f */
    private int f15803f = 0;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17585a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17586a(bool);
    }

    public AsyncTaskC2951v(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15798a = context;
        this.f15799b = interfaceC2995n;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15798a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15805h = new DialogInterfaceC0070b.a(this.f15798a).m435b(inflate).m429a(false).m438b();
        this.f15805h.show();
    }

    /* renamed from: a */
    protected Boolean m17585a(File[] fileArr) {
        String stringBuffer;
        try {
            this.f15803f = fileArr.length;
            boolean m18925a = C3102bd.m18925a(this.f15798a, "imgs_backup", false);
            for (File file : fileArr) {
                String lowerCase = file.getName().toLowerCase();
                String[] m19641b = C3262u.m19641b(lowerCase);
                if (lowerCase.endsWith(".9.png")) {
                    stringBuffer = new StringBuffer().append("dummy/dummy.").append("9.png").toString();
                } else {
                    stringBuffer = m19641b[1].equals("jpeg") ? new StringBuffer().append("dummy/dummy.").append("jpg").toString() : new StringBuffer().append("dummy/dummy.").append(m19641b[1]).toString();
                }
                if (m18925a) {
                    String str = m19641b[0];
                    String stringBuffer2 = new StringBuffer().append(".").append(m19641b[1]).toString();
                    if (lowerCase.endsWith(".9.png")) {
                        str = str.substring(0, str.length() - 2);
                        stringBuffer2 = ".9.png";
                    }
                    File m17583a = m17583a(file, str, stringBuffer2);
                    if (m17583a == null) {
                        return new Boolean(false);
                    }
                    C3262u.m19612a(file, m17583a);
                }
                InputStream open = this.f15798a.getAssets().open(stringBuffer);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                C1887e.m13962a(open, fileOutputStream);
                open.close();
                fileOutputStream.close();
                this.f15800c.add(file.getAbsolutePath());
                this.f15802e++;
            }
            return new Boolean(true);
        } catch (Error e2) {
            this.f15801d.add(e2.toString());
            return new Boolean(false);
        } catch (Exception e3) {
            this.f15801d.add(e3.toString());
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17586a(Boolean bool) {
        if (this.f15805h != null && this.f15805h.isShowing()) {
            try {
                this.f15805h.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15799b != null) {
            this.f15799b.mo17929a();
            this.f15799b.mo17935a(this.f15800c);
        }
        C3112bn.m19023b(this.f15798a, this.f15798a.getString(R.string.success_of, new Integer(this.f15802e), new Integer(this.f15803f)));
        if (!this.f15801d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15801d, "\n\n");
            new C3078aj(this.f15798a).m18494a(R.string.error).m18496a(this.f15798a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.v.1

                /* renamed from: a */
                private final AsyncTaskC2951v f15806a;

                /* renamed from: b */
                private final String f15807b;

                {
                    this.f15806a = this;
                    this.f15807b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15806a.f15798a, this.f15807b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15804g) {
            new C3078aj(this.f15798a).m18494a(R.string.complete).m18496a(this.f15798a.getString(R.string.complete_msg, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.v.2

                /* renamed from: a */
                private final AsyncTaskC2951v f15808a;

                {
                    this.f15808a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15808a.f15799b == null) {
                        return;
                    }
                    this.f15808a.f15799b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17583a(File file, String str, String str2) {
        String parent = file.getParent();
        if (C3102bd.m18925a(this.f15798a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15801d.add(this.f15798a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15801d.add(this.f15798a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15801d.add(this.f15798a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15804g = !parent.equals(file.getParent());
        }
        String str3 = parent;
        if (str == null) {
            str = file.getName();
        }
        if (!this.f15804g) {
            str = new StringBuffer().append(str).append("_orig").toString();
        }
        return new File(str3, C3262u.m19566a(this.f15798a, str3, str, str2, 0));
    }
}
