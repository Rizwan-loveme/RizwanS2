package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.p008os.AsyncTask;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: FileSizeTask.java */
/* renamed from: ru.maximoff.apktool.e.w */
/* loaded from: classes.dex */
public class AsyncTaskC2952w extends AsyncTask<File, Integer, String> {

    /* renamed from: a */
    private TextView f15809a;

    /* renamed from: b */
    private Context f15810b;

    /* renamed from: c */
    private boolean f15811c;

    /* renamed from: d */
    private Object f15812d;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(File[] fileArr) {
        return m17587a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onCancelled(String str) {
        m17589b(str);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m17588a(str);
    }

    public AsyncTaskC2952w(Context context, TextView textView, boolean z) {
        this.f15810b = context;
        this.f15809a = textView;
        this.f15812d = textView.getTag();
        if (this.f15812d == null) {
            this.f15812d = new Object();
        }
        this.f15809a.setText("...");
        this.f15811c = z;
    }

    /* renamed from: a */
    protected String m17587a(File[] fileArr) {
        int i;
        int i2 = 1;
        File file = fileArr[0];
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        ArrayList arrayList = new ArrayList();
        if (C3102bd.f18302aj.equals("0")) {
            arrayList.add(0, C3112bn.m18989a(lastModified));
            if (!(C3102bd.f18271G && isDirectory) && isDirectory) {
                i = 1;
            } else {
                i = 2;
                arrayList.add(1, C3106bh.m18975a(C3262u.m19668i(this.f15810b, file), C3102bd.f18305am));
            }
        } else {
            if (!(C3102bd.f18271G && isDirectory) && isDirectory) {
                i2 = 0;
            } else {
                arrayList.add(0, C3106bh.m18975a(C3262u.m19668i(this.f15810b, file), C3102bd.f18305am));
            }
            i = i2 + 1;
            arrayList.add(i2, C3112bn.m18989a(lastModified));
        }
        if (file.getName().endsWith(".apk")) {
            C3060a c3060a = new C3060a(this.f15810b, file);
            if (c3060a.m18255D()) {
                arrayList.add(i, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("v").append(c3060a.m18277o()).toString()).append("(").toString()).append(c3060a.m18278p()).toString()).append(")").toString());
                i++;
            }
        }
        if (isDirectory) {
            int i3 = i + 1;
            try {
                arrayList.add(i, new StringBuffer().append(new StringBuffer().append(this.f15810b.getString(R.string.foldersc)).append(" ").toString()).append(C3262u.m19621b(this.f15810b, file, true)).toString());
                int i4 = i3 + 1;
                arrayList.add(i3, new StringBuffer().append(new StringBuffer().append(this.f15810b.getString(R.string.filesc)).append(" ").toString()).append(C3262u.m19621b(this.f15810b, file, false)).toString());
            } catch (Exception e2) {
            }
        }
        return C3080al.m18538a(arrayList, ", ");
    }

    /* renamed from: a */
    protected void m17588a(String str) {
        C2918at.m17333d();
        if (this.f15812d.equals(this.f15809a.getTag())) {
            this.f15809a.setContentDescription(str);
            if (this.f15811c) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f15810b, R.color.dark_green)), 0, str.length(), 33);
                spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
                this.f15809a.setText(spannableString);
            } else {
                this.f15809a.setText(str);
            }
            this.f15809a.setVisibility(0);
        }
    }

    @Override // android.p008os.AsyncTask
    protected void onCancelled() {
        C2918at.m17333d();
    }

    /* renamed from: b */
    protected void m17589b(String str) {
        C2918at.m17333d();
    }
}
