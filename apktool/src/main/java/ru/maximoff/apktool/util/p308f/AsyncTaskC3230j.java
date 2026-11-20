package ru.maximoff.apktool.util.p308f;

import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: MergeTask.java */
/* renamed from: ru.maximoff.apktool.util.f.j */
/* loaded from: classes.dex */
public class AsyncTaskC3230j extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19367a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19368b;

    /* renamed from: c */
    private String f19369c;

    /* renamed from: d */
    private String f19370d;

    /* renamed from: e */
    private List<C3236p> f19371e = new ArrayList();

    @Override // android.p008os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19350a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19351a(str);
    }

    public AsyncTaskC3230j(TranslateActivity translateActivity, String str, String str2) {
        this.f19367a = translateActivity;
        this.f19369c = str;
        this.f19370d = str2;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19367a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19368b = new DialogInterfaceC0070b.a(this.f19367a).m435b(inflate).m429a(false).m438b();
        this.f19368b.show();
    }

    /* renamed from: a */
    protected String m19350a(String[] strArr) {
        List<C3236p> m19427b = C3239s.m19427b(this.f19369c);
        List<C3236p> m19427b2 = C3239s.m19427b(this.f19370d);
        for (C3236p c3236p : m19427b) {
            Iterator<C3236p> it = m19427b2.iterator();
            while (true) {
                if (it.hasNext()) {
                    C3236p next = it.next();
                    if (c3236p.m19381e().equals(next.m19381e())) {
                        this.f19371e.add(new C3236p(c3236p.m19381e(), c3236p.m19386g(), next.m19386g()));
                        break;
                    }
                }
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    protected void m19351a(String str) {
        if (this.f19368b != null && this.f19368b.isShowing()) {
            try {
                this.f19368b.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f19371e.isEmpty()) {
            C3112bn.m19023b(this.f19367a, this.f19367a.getString(R.string.not_found));
        } else {
            this.f19367a.m16844a(false, this.f19371e);
        }
    }
}
