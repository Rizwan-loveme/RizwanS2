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
import java.util.ArrayList;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: aapt2utils.java */
/* renamed from: ru.maximoff.apktool.e.bf */
/* loaded from: classes.dex */
public class AsyncTaskC2931bf extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15597a;

    /* renamed from: b */
    private InterfaceC2995n f15598b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15599c;

    /* renamed from: d */
    private File f15600d;

    /* renamed from: e */
    private String f15601e;

    /* renamed from: f */
    private boolean f15602f = false;

    /* renamed from: g */
    private boolean f15603g = false;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17462a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17463a(bool);
    }

    public AsyncTaskC2931bf(Context context, InterfaceC2995n interfaceC2995n, String str) {
        this.f15597a = context;
        this.f15598b = interfaceC2995n;
        this.f15601e = str;
    }

    /* renamed from: a */
    public void m17464a(boolean z) {
        this.f15602f = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15597a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15599c = new DialogInterfaceC0070b.a(this.f15597a).m435b(inflate).m429a(false).m438b();
        this.f15599c.show();
    }

    /* renamed from: a */
    protected Boolean m17462a(File[] fileArr) {
        String stringBuffer;
        String m17459a;
        try {
            this.f15600d = m17461b(fileArr[0]);
            if (this.f15602f) {
                stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(fileArr[0].getAbsolutePath()).append(" -> ").toString()).append(fileArr[1].getAbsolutePath()).toString()).append("\n\n").toString();
                m17459a = m17460a(fileArr[0], fileArr[1]);
            } else {
                stringBuffer = new StringBuffer().append(fileArr[0].getAbsolutePath()).append("\n\n").toString();
                m17459a = m17459a(fileArr[0]);
            }
            if (C3112bn.m19040o(m17459a)) {
                this.f15603g = true;
                return new Boolean(true);
            }
            C3061a.m18319b(this.f15600d, new StringBuffer().append(stringBuffer).append(m17459a).toString());
            return new Boolean(true);
        } catch (Error | Exception e2) {
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17463a(Boolean bool) {
        if (this.f15599c != null && this.f15599c.isShowing()) {
            try {
                this.f15599c.cancel();
            } catch (Exception e2) {
            }
        }
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
            if (this.f15598b != null) {
                this.f15598b.mo17929a();
            }
            if (bool.booleanValue()) {
                if (this.f15603g) {
                    if (this.f15602f) {
                        C3112bn.m18999a(this.f15597a, R.string.files_identical);
                        return;
                    } else {
                        C3112bn.m18999a(this.f15597a, R.string.not_found);
                        return;
                    }
                }
                if (this.f15600d != null) {
                    C3112bn.m19023b(this.f15597a, this.f15597a.getString(R.string.complete_msg2, this.f15600d.getAbsolutePath()));
                    if (m16615o.m16617B() != null) {
                        m16615o.m16617B().m17636a(this.f15600d);
                        return;
                    }
                    return;
                }
                C3112bn.m18999a(this.f15597a, R.string.error);
                return;
            }
            if (this.f15600d != null && this.f15600d.exists()) {
                this.f15600d.delete();
            }
            C3112bn.m18999a(this.f15597a, R.string.error);
        }
    }

    /* renamed from: a */
    private String m17459a(File file) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3102bd.f18278N);
        arrayList.add("dump");
        arrayList.add(this.f15601e);
        arrayList.add(file.getAbsolutePath());
        return C0542g.m3986a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* renamed from: a */
    private String m17460a(File file, File file2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3102bd.f18278N);
        arrayList.add("diff");
        arrayList.add(file.getAbsolutePath());
        arrayList.add(file2.getAbsolutePath());
        return C0542g.m3986a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* renamed from: b */
    private File m17461b(File file) {
        String stringBuffer;
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15597a, file)) || C3102bd.m18925a(this.f15597a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                return (File) null;
            }
            if (!file2.isDirectory()) {
                return (File) null;
            }
        }
        String str = parent;
        if (this.f15602f) {
            stringBuffer = "diff_resources";
        } else {
            stringBuffer = new StringBuffer().append("dump_").append(this.f15601e).toString();
        }
        return new File(str, C3262u.m19566a(this.f15597a, str, new StringBuffer().append(new StringBuffer().append(stringBuffer).append("_").toString()).append(C3112bn.m19032g("yyyyMMddHHmmss")).toString(), ".txt", 0));
    }
}
