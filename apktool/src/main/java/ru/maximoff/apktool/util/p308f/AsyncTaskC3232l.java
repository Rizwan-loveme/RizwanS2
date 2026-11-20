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

/* compiled from: SaveSmali.java */
/* renamed from: ru.maximoff.apktool.util.f.l */
/* loaded from: classes.dex */
public class AsyncTaskC3232l extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19380a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19381b;

    /* renamed from: c */
    private List<C3236p> f19382c;

    /* renamed from: d */
    private boolean f19383d;

    /* renamed from: e */
    private int f19384e = 0;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19354a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19355a(str);
    }

    public AsyncTaskC3232l(TranslateActivity translateActivity, List<C3236p> list, boolean z) {
        this.f19380a = translateActivity;
        this.f19382c = list;
        this.f19383d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19380a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19381b = new DialogInterfaceC0070b.a(this.f19380a).m435b(inflate).m429a(false).m438b();
        this.f19381b.show();
    }

    /* renamed from: a */
    protected String m19354a(String[] strArr) {
        if (this.f19382c.isEmpty()) {
            return (String) null;
        }
        try {
            this.f19384e = C3239s.m19411a(this.f19382c);
            return (String) null;
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    /* renamed from: a */
    protected void m19355a(String str) {
        if (this.f19381b != null && this.f19381b.isShowing()) {
            try {
                this.f19381b.cancel();
            } catch (Exception e2) {
            }
        }
        if (str == null) {
            C3112bn.m18999a(this.f19380a, R.string.all_files_saved);
        } else {
            C3112bn.m19023b(this.f19380a, this.f19380a.getString(R.string.errorf, str));
        }
        if (this.f19383d) {
            this.f19380a.finish();
        } else {
            this.f19380a.recreate();
        }
    }
}
