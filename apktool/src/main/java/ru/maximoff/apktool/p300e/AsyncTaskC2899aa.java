package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: InvertBitmap.java */
/* renamed from: ru.maximoff.apktool.e.aa */
/* loaded from: classes.dex */
public class AsyncTaskC2899aa extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f14995a;

    /* renamed from: b */
    private InterfaceC2995n f14996b;

    /* renamed from: f */
    private boolean f15000f;

    /* renamed from: i */
    private DialogInterfaceC0070b f15003i;

    /* renamed from: e */
    private boolean f14999e = false;

    /* renamed from: c */
    private List<String> f14997c = new ArrayList();

    /* renamed from: d */
    private List<String> f14998d = new ArrayList();

    /* renamed from: g */
    private int f15001g = 0;

    /* renamed from: h */
    private int f15002h = 0;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17086a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17087a(bool);
    }

    public AsyncTaskC2899aa(Context context, InterfaceC2995n interfaceC2995n) {
        this.f14995a = context;
        this.f14996b = interfaceC2995n;
        this.f15000f = C3102bd.m18925a(this.f14995a, "imgs_backup", false);
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f14995a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15003i = new DialogInterfaceC0070b.a(this.f14995a).m435b(inflate).m429a(false).m438b();
        this.f15003i.show();
    }

    /* renamed from: a */
    protected Boolean m17086a(File[] fileArr) {
        try {
            boolean z = C3262u.m19664g(this.f14995a, fileArr[0]) ? false : true;
            if (z) {
                this.f15000f = false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            this.f15002h = fileArr.length;
            for (File file : fileArr) {
                String[] m19641b = C3262u.m19641b(file.getName());
                File m17084a = m17084a(file, m19641b[0], new StringBuffer().append(".").append(m19641b[1]).toString(), this.f15000f, z);
                if (m17084a == null) {
                    return new Boolean(false);
                }
                File createTempFile = File.createTempFile("APKTOOL_M", ".tmpinverse", C3102bd.m18908a());
                if (C3067ab.m18384a(C3067ab.m18395c(BitmapFactory.decodeFile(file.getAbsolutePath(), options)), createTempFile, m19641b[1]) != null) {
                    if (this.f15000f) {
                        C3262u.m19612a(file, m17084a);
                        C3262u.m19612a(createTempFile, file);
                        this.f14997c.add(file.getAbsolutePath());
                    } else {
                        C3262u.m19612a(createTempFile, m17084a);
                        this.f14997c.add(m17084a.getAbsolutePath());
                    }
                    createTempFile.delete();
                    this.f15001g++;
                }
            }
            return new Boolean(true);
        } catch (Error e2) {
            this.f14998d.add(e2.toString());
            return new Boolean(false);
        } catch (Exception e3) {
            this.f14998d.add(e3.toString());
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17087a(Boolean bool) {
        int i;
        if (this.f15003i != null && this.f15003i.isShowing()) {
            try {
                this.f15003i.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f14996b != null) {
            this.f14996b.mo17929a();
            this.f14996b.mo17935a(this.f14997c);
        }
        C3112bn.m19023b(this.f14995a, this.f14995a.getString(R.string.success_of, new Integer(this.f15001g), new Integer(this.f15002h)));
        if (!this.f14998d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f14998d, "\n\n");
            new C3078aj(this.f14995a).m18494a(R.string.error).m18496a(this.f14995a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.aa.1

                /* renamed from: a */
                private final AsyncTaskC2899aa f15004a;

                /* renamed from: b */
                private final String f15005b;

                {
                    this.f15004a = this;
                    this.f15005b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15004a.f14995a, this.f15005b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f14999e) {
            if (this.f15000f) {
                i = R.string.complete_msg;
            } else {
                i = R.string.complete_msg2;
            }
            new C3078aj(this.f14995a).m18494a(R.string.complete).m18496a(this.f14995a.getString(i, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.aa.2

                /* renamed from: a */
                private final AsyncTaskC2899aa f15006a;

                {
                    this.f15006a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15006a.f14996b == null) {
                        return;
                    }
                    this.f15006a.f14996b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17084a(File file, String str, String str2, boolean z, boolean z2) {
        String parent = file.getParent();
        if (z2 || C3102bd.m18925a(this.f14995a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f14998d.add(this.f14995a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f14998d.add(this.f14995a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f14998d.add(this.f14995a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f14999e = !parent.equals(file.getParent());
        }
        String str3 = parent;
        if (!this.f14999e && !z) {
            return file;
        }
        String name = str == null ? file.getName() : str;
        if (z && !this.f14999e) {
            name = new StringBuffer().append(name).append("_orig").toString();
        }
        return new File(str3, C3262u.m19566a(this.f14995a, str3, name, str2, 0));
    }
}
