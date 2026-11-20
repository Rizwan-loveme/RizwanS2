package ru.maximoff.apktool.util.p308f;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ReplaceTask.java */
/* renamed from: ru.maximoff.apktool.util.f.k */
/* loaded from: classes.dex */
public class AsyncTaskC3231k extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private TranslateActivity f19372a;

    /* renamed from: b */
    private List<C3236p> f19373b;

    /* renamed from: c */
    private String f19374c;

    /* renamed from: d */
    private String f19375d;

    /* renamed from: e */
    private boolean f19376e;

    /* renamed from: f */
    private boolean f19377f;

    /* renamed from: g */
    private int f19378g = 0;

    /* renamed from: h */
    private DialogInterfaceC0070b f19379h;

    @Override // android.os.AsyncTask
    protected Void doInBackground(Void[] voidArr) {
        return m19352a(voidArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Void r1) {
        m19353a(r1);
    }

    public AsyncTaskC3231k(TranslateActivity translateActivity, List<C3236p> list, String str, String str2, boolean z, boolean z2) {
        this.f19372a = translateActivity;
        this.f19373b = list;
        this.f19374c = str;
        this.f19375d = str2;
        this.f19376e = z;
        this.f19377f = z2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19372a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19379h = new DialogInterfaceC0070b.a(this.f19372a).m435b(inflate).m429a(false).m438b();
        this.f19379h.show();
    }

    /* renamed from: a */
    protected Void m19352a(Void[] voidArr) {
        String m19386g;
        String m18996a;
        for (int i = 0; i < this.f19373b.size(); i++) {
            C3236p c3236p = this.f19373b.get(i);
            if (c3236p.m19390k()) {
                m19386g = c3236p.m19387h();
            } else {
                m19386g = c3236p.m19386g();
            }
            if (this.f19376e) {
                int i2 = 8;
                if (!this.f19377f) {
                    i2 = 10;
                }
                try {
                    Matcher matcher = Pattern.compile(this.f19374c, i2).matcher(m19386g);
                    StringBuffer stringBuffer = new StringBuffer();
                    int i3 = 0;
                    while (matcher.find()) {
                        matcher.appendReplacement(stringBuffer, this.f19375d);
                        i3++;
                    }
                    if (i3 > 0) {
                        matcher.appendTail(stringBuffer);
                        c3236p.m19375c(stringBuffer.toString());
                        this.f19378g += i3;
                    }
                } catch (Exception e2) {
                }
            } else {
                if (this.f19377f) {
                    m18996a = m19386g.replace(this.f19374c, this.f19375d);
                } else {
                    m18996a = C3112bn.m18996a(m19386g, this.f19374c, this.f19375d);
                }
                if (!m19386g.equals(m18996a)) {
                    c3236p.m19375c(m18996a);
                    this.f19378g++;
                }
            }
        }
        return (Void) null;
    }

    /* renamed from: a */
    protected void m19353a(Void r8) {
        if (this.f19379h != null && this.f19379h.isShowing()) {
            try {
                this.f19379h.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f19378g > 0) {
            this.f19372a.m16843a(true);
            C3112bn.m19023b(this.f19372a, this.f19372a.getString(R.string.total_repl, new Integer(this.f19378g)));
        } else {
            this.f19372a.m16843a(false);
            C3112bn.m18999a(this.f19372a, R.string.not_found);
        }
    }
}
