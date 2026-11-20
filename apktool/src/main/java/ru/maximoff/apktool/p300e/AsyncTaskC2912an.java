package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: ResizeBitmap.java */
/* renamed from: ru.maximoff.apktool.e.an */
/* loaded from: classes.dex */
public class AsyncTaskC2912an extends AsyncTask<String, String, Boolean> {

    /* renamed from: a */
    private Context f15281a;

    /* renamed from: b */
    private File f15282b;

    /* renamed from: c */
    private String f15283c;

    /* renamed from: d */
    private DialogInterfaceC0070b f15284d;

    /* renamed from: e */
    private Drawable f15285e;

    /* renamed from: f */
    private int f15286f;

    /* renamed from: g */
    private int f15287g;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m17243a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17245a(bool);
    }

    public AsyncTaskC2912an(Context context, File file, int i, int i2) {
        this.f15281a = context;
        this.f15282b = file;
        this.f15286f = i;
        this.f15287g = i2;
    }

    /* renamed from: a */
    public void m17244a(Drawable drawable) {
        this.f15285e = drawable;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15281a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15284d = new DialogInterfaceC0070b.a(this.f15281a).m435b(inflate).m429a(false).m438b();
        this.f15284d.show();
    }

    /* renamed from: a */
    protected Boolean m17243a(String[] strArr) {
        Bitmap m18378a;
        try {
            if (strArr[0] == null) {
                m18378a = C3067ab.m18373a(this.f15285e, this.f15286f, this.f15287g);
            } else {
                m18378a = C3067ab.m18378a(strArr[0], this.f15286f, this.f15287g);
            }
            return new Boolean(m17242a(m18378a));
        } catch (Error | Exception e2) {
            this.f15283c = e2.getMessage();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17245a(Boolean bool) {
        if (this.f15284d != null && this.f15284d.isShowing()) {
            try {
                this.f15284d.cancel();
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            C3112bn.m19023b(this.f15281a, this.f15283c);
        } else {
            C3112bn.m19023b(this.f15281a, this.f15281a.getString(R.string.errorf, this.f15283c));
        }
        MainActivity.m16615o().m16644z();
    }

    /* renamed from: a */
    private boolean m17242a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            this.f15283c = "bitmap is null";
            return false;
        }
        int lastIndexOf = this.f15282b.getName().lastIndexOf(46);
        String name = this.f15282b.getName();
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        if (!C3262u.m19664g(this.f15281a, this.f15282b.getParentFile()) || C3102bd.m18925a(this.f15281a, "all_to_out_dir", false)) {
            str = C3102bd.f18339v;
            if (str == null) {
                this.f15283c = this.f15281a.getString(R.string.output_directory_not_set);
                return false;
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                this.f15283c = this.f15281a.getString(R.string.output_directory_not_extsts, str);
                return false;
            }
            if (!file.isDirectory()) {
                this.f15283c = this.f15281a.getString(R.string.not_directory, str);
                return false;
            }
        } else {
            str = this.f15282b.getParent();
        }
        File file2 = new File(str, C3262u.m19566a(this.f15281a, str, name, ".png", 0));
        C3067ab.m18383a(bitmap, file2);
        this.f15283c = this.f15281a.getString(R.string.extraction, file2.getAbsolutePath());
        return true;
    }
}
