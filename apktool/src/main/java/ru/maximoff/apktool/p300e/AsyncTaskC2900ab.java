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

/* compiled from: MonoBitmap.java */
/* renamed from: ru.maximoff.apktool.e.ab */
/* loaded from: classes.dex */
public class AsyncTaskC2900ab extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15007a;

    /* renamed from: b */
    private InterfaceC2995n f15008b;

    /* renamed from: f */
    private boolean f15012f;

    /* renamed from: i */
    private DialogInterfaceC0070b f15015i;

    /* renamed from: e */
    private boolean f15011e = false;

    /* renamed from: c */
    private List<String> f15009c = new ArrayList();

    /* renamed from: d */
    private List<String> f15010d = new ArrayList();

    /* renamed from: g */
    private int f15013g = 0;

    /* renamed from: h */
    private int f15014h = 0;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17091a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17092a(bool);
    }

    public AsyncTaskC2900ab(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15007a = context;
        this.f15008b = interfaceC2995n;
        this.f15012f = C3102bd.m18925a(this.f15007a, "imgs_backup", false);
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15007a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15015i = new DialogInterfaceC0070b.a(this.f15007a).m435b(inflate).m429a(false).m438b();
        this.f15015i.show();
    }

    /* renamed from: a */
    protected Boolean m17091a(File[] fileArr) {
        try {
            boolean z = C3262u.m19664g(this.f15007a, fileArr[0]) ? false : true;
            if (z) {
                this.f15012f = false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            this.f15014h = fileArr.length;
            for (File file : fileArr) {
                String[] m19641b = C3262u.m19641b(file.getName());
                File m17089a = m17089a(file, m19641b[0], new StringBuffer().append(".").append(m19641b[1]).toString(), this.f15012f, z);
                if (m17089a == null) {
                    return new Boolean(false);
                }
                File createTempFile = File.createTempFile("APKTOOL_M", ".tmpmono", C3102bd.m18908a());
                if (C3067ab.m18384a(C3067ab.m18397d(BitmapFactory.decodeFile(file.getAbsolutePath(), options)), createTempFile, m19641b[1]) != null) {
                    if (this.f15012f) {
                        C3262u.m19612a(file, m17089a);
                        C3262u.m19612a(createTempFile, file);
                        this.f15009c.add(file.getAbsolutePath());
                    } else {
                        C3262u.m19612a(createTempFile, m17089a);
                        this.f15009c.add(m17089a.getAbsolutePath());
                    }
                    createTempFile.delete();
                    this.f15013g++;
                }
            }
            return new Boolean(true);
        } catch (Error | Exception e2) {
            this.f15010d.add(e2.toString());
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17092a(Boolean bool) {
        int i;
        if (this.f15015i != null && this.f15015i.isShowing()) {
            try {
                this.f15015i.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15008b != null) {
            this.f15008b.mo17929a();
            this.f15008b.mo17935a(this.f15009c);
        }
        C3112bn.m19023b(this.f15007a, this.f15007a.getString(R.string.success_of, new Integer(this.f15013g), new Integer(this.f15014h)));
        if (!this.f15010d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15010d, "\n\n");
            new C3078aj(this.f15007a).m18494a(R.string.error).m18496a(this.f15007a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.ab.1

                /* renamed from: a */
                private final AsyncTaskC2900ab f15016a;

                /* renamed from: b */
                private final String f15017b;

                {
                    this.f15016a = this;
                    this.f15017b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15016a.f15007a, this.f15017b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15011e) {
            if (this.f15012f) {
                i = R.string.complete_msg;
            } else {
                i = R.string.complete_msg2;
            }
            new C3078aj(this.f15007a).m18494a(R.string.complete).m18496a(this.f15007a.getString(i, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.ab.2

                /* renamed from: a */
                private final AsyncTaskC2900ab f15018a;

                {
                    this.f15018a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15018a.f15008b == null) {
                        return;
                    }
                    this.f15018a.f15008b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17089a(File file, String str, String str2, boolean z, boolean z2) {
        String parent = file.getParent();
        if (z2 || C3102bd.m18925a(this.f15007a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15010d.add(this.f15007a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15010d.add(this.f15007a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15010d.add(this.f15007a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15011e = !parent.equals(file.getParent());
        }
        String str3 = parent;
        if (!this.f15011e && !z) {
            return file;
        }
        String name = str == null ? file.getName() : str;
        if (z && !this.f15011e) {
            name = new StringBuffer().append(name).append("_orig").toString();
        }
        return new File(str3, C3262u.m19566a(this.f15007a, str3, name, str2, 0));
    }
}
