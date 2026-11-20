package ru.maximoff.apktool.util.p308f;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.List;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: SaveXml.java */
/* renamed from: ru.maximoff.apktool.util.f.n */
/* loaded from: classes.dex */
public class AsyncTaskC3234n extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19388a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19389b;

    /* renamed from: c */
    private List<C3236p> f19390c;

    /* renamed from: d */
    private boolean f19391d;

    /* renamed from: e */
    private int f19392e = 0;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19358a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19359a(str);
    }

    public AsyncTaskC3234n(TranslateActivity translateActivity, List<C3236p> list, boolean z) {
        this.f19388a = translateActivity;
        this.f19390c = list;
        this.f19391d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19388a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19389b = new DialogInterfaceC0070b.a(this.f19388a).m435b(inflate).m429a(false).m438b();
        this.f19389b.show();
    }

    /* renamed from: a */
    protected String m19358a(String[] strArr) {
        if (this.f19390c.isEmpty()) {
            return (String) null;
        }
        try {
            this.f19392e = C3239s.m19425b(this.f19390c);
            return (String) null;
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    /* renamed from: a */
    protected void m19359a(String str) {
        if (this.f19389b != null && this.f19389b.isShowing()) {
            try {
                this.f19389b.cancel();
            } catch (Exception e2) {
            }
        }
        if (str == null) {
            C3112bn.m18999a(this.f19388a, R.string.all_files_saved);
        } else {
            C3112bn.m19023b(this.f19388a, this.f19388a.getString(R.string.errorf, str));
        }
        if (this.f19391d) {
            this.f19388a.finish();
        } else {
            this.f19388a.recreate();
        }
    }
}
