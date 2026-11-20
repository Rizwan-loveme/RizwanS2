package ru.maximoff.apktool.util.p308f;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.List;
import java.util.Map;
import org.p217b.p218a.p222b.C1895d;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: DictionaryTask.java */
/* renamed from: ru.maximoff.apktool.util.f.d */
/* loaded from: classes.dex */
public class AsyncTaskC3224d extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19325a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19326b;

    /* renamed from: c */
    private List<C3236p> f19327c;

    /* renamed from: d */
    private boolean f19328d;

    /* renamed from: e */
    private boolean f19329e;

    /* renamed from: f */
    private int f19330f = 0;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19322a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19323a(str);
    }

    public AsyncTaskC3224d(TranslateActivity translateActivity, List<C3236p> list, boolean z, boolean z2) {
        this.f19325a = translateActivity;
        this.f19327c = list;
        this.f19328d = z2;
        this.f19329e = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19325a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19326b = new DialogInterfaceC0070b.a(this.f19325a).m435b(inflate).m429a(false).m438b();
        this.f19326b.show();
    }

    /* renamed from: a */
    protected String m19322a(String[] strArr) {
        int i = 0;
        if (this.f19327c.isEmpty()) {
            return (String) null;
        }
        Map<String, String> m19325a = C3225e.m19325a(strArr[0]);
        if (m19325a == null) {
            return this.f19325a.getString(R.string.error);
        }
        while (true) {
            int i2 = i;
            if (i2 < this.f19327c.size()) {
                C3236p c3236p = this.f19327c.get(i2);
                if (c3236p != null && ((!this.f19329e || c3236p.m19387h() == null) && (!this.f19328d || !this.f19325a.m16848c(c3236p.m19386g())))) {
                    String trim = c3236p.m19386g().trim();
                    for (Map.Entry<String, String> entry : m19325a.entrySet()) {
                        String key = entry.getKey();
                        String m14012a = C1895d.m14012a(entry.getValue());
                        if (trim.equalsIgnoreCase(key.trim()) || trim.equalsIgnoreCase(C1895d.m14012a(key).trim())) {
                            if (this.f19328d) {
                                m14012a = this.f19325a.m16845b(m14012a);
                            }
                            c3236p.m19370a(m14012a, true);
                            this.f19330f++;
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return (String) null;
            }
        }
    }

    /* renamed from: a */
    protected void m19323a(String str) {
        super.onPostExecute(str);
        this.f19326b.cancel();
        this.f19325a.m16843a(this.f19330f > 0);
        if (str == null) {
            C3112bn.m19023b(this.f19325a, this.f19325a.getString(R.string.mtr_success_count, new Integer(this.f19330f)));
        } else {
            C3112bn.m19023b(this.f19325a, this.f19325a.getString(R.string.errorf, str));
        }
    }
}
