package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.nicdahlquist.pngquant.LibPngQuant;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3073ae;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3118c;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: ToVectorTask.java */
/* renamed from: ru.maximoff.apktool.e.aw */
/* loaded from: classes.dex */
public class AsyncTaskC2921aw extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15424a;

    /* renamed from: b */
    private InterfaceC2995n f15425b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15426c;

    /* renamed from: e */
    private TextView f15428e;

    /* renamed from: d */
    private List<String> f15427d = new ArrayList();

    /* renamed from: f */
    private boolean f15429f = false;

    /* renamed from: g */
    private boolean f15430g = false;

    /* renamed from: h */
    private boolean f15431h = false;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17357a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17358a(bool);
    }

    @Override // android.os.AsyncTask
    protected void onProgressUpdate(String[] strArr) {
        m17360a(strArr);
    }

    public AsyncTaskC2921aw(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15424a = context;
        this.f15425b = interfaceC2995n;
    }

    /* renamed from: a */
    public void m17359a(boolean z) {
        this.f15431h = z;
    }

    /* renamed from: b */
    public void m17361b(boolean z) {
        this.f15430g = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15424a).inflate(R.layout.search_progress, (ViewGroup) null);
        this.f15428e = (TextView) inflate.findViewById(R.id.searchprogressTextView1);
        this.f15428e.setText(R.string.mplease_wait);
        this.f15426c = new DialogInterfaceC0070b.a(this.f15424a).m435b(inflate).m429a(false).m438b();
        this.f15426c.show();
    }

    /* renamed from: a */
    protected Boolean m17357a(File[] fileArr) {
        String absolutePath;
        Bitmap m18377a;
        int i = 0;
        for (File file : fileArr) {
            try {
                if (file.getName().toLowerCase().endsWith(".png") && C3262u.m19663f(file)) {
                    try {
                        File createTempFile = File.createTempFile("APKTOOL_M", ".tmpquant", C3102bd.m18908a());
                        if (new LibPngQuant().m11224a(file, createTempFile)) {
                            absolutePath = createTempFile.getAbsolutePath();
                        } else {
                            absolutePath = file.getAbsolutePath();
                        }
                    } catch (IOException e2) {
                        absolutePath = file.getAbsolutePath();
                    }
                } else {
                    absolutePath = file.getAbsolutePath();
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(absolutePath, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                if (i2 > 512 || i3 > 512) {
                    m18377a = C3067ab.m18377a(file.getAbsolutePath(), 512);
                    publishProgress(this.f15424a.getString(R.string.reduceimg, new Integer(m18377a.getWidth()), new Integer(m18377a.getHeight())));
                } else {
                    m18377a = BitmapFactory.decodeFile(absolutePath);
                }
                File m17355a = m17355a(file, new StringBuffer().append(C3262u.m19641b(file.getName())[0]).append("_vector").toString());
                if (this.f15430g) {
                    C3118c c3118c = new C3118c(m18377a);
                    if (this.f15431h) {
                        c3118c.m19081b(m17355a);
                    } else {
                        c3118c.m19079a(m17355a);
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("numberofcolors", new Float(255.0f));
                    C3073ae.m18451a(m18377a, (HashMap<String, Float>) hashMap, C3073ae.m18455a(255), m17355a);
                }
            } catch (Error e3) {
                i++;
                this.f15427d.add(e3.getMessage());
            } catch (Exception e4) {
                i++;
                this.f15427d.add(e4.getMessage());
            }
        }
        return new Boolean(i == 0);
    }

    /* renamed from: a */
    protected void m17358a(Boolean bool) {
        if (this.f15426c != null && this.f15426c.isShowing()) {
            try {
                this.f15426c.cancel();
            } catch (Exception e2) {
            }
        }
        this.f15425b.mo17929a();
        if (!this.f15427d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15427d, "\n\n");
            new C3078aj(this.f15424a).m18494a(R.string.error).m18496a(this.f15424a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.aw.1

                /* renamed from: a */
                private final AsyncTaskC2921aw f15432a;

                /* renamed from: b */
                private final String f15433b;

                {
                    this.f15432a = this;
                    this.f15433b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15432a.f15424a, this.f15433b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15429f) {
            new C3078aj(this.f15424a).m18494a(R.string.complete).m18496a(this.f15424a.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.aw.2

                /* renamed from: a */
                private final AsyncTaskC2921aw f15434a;

                {
                    this.f15434a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f15434a.f15425b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    protected void m17360a(String[] strArr) {
        if (this.f15428e != null) {
            this.f15428e.setText(strArr[0]);
        }
    }

    /* renamed from: a */
    private File m17355a(File file, String str) {
        String str2;
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15424a, file)) || C3102bd.m18925a(this.f15424a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15427d.add(this.f15424a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15427d.add(this.f15424a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15427d.add(this.f15424a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15429f = !parent.equals(file.getParent());
        }
        String str3 = parent;
        if (str == null) {
            str = file.getName();
        }
        if (this.f15431h) {
            str2 = ".svg";
        } else {
            str2 = ".xml";
        }
        return new File(str3, C3262u.m19566a(this.f15424a, str3, str, str2, 0));
    }
}
