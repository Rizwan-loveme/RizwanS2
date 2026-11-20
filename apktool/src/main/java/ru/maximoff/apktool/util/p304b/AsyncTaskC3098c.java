package ru.maximoff.apktool.util.p304b;

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
import ru.maximoff.apktool.ColorsEditor;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ReplaceTask.java */
/* renamed from: ru.maximoff.apktool.util.b.c */
/* loaded from: classes.dex */
public class AsyncTaskC3098c extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private ColorsEditor f18206a;

    /* renamed from: b */
    private List<C3096a> f18207b;

    /* renamed from: c */
    private String f18208c;

    /* renamed from: d */
    private String f18209d;

    /* renamed from: e */
    private boolean f18210e;

    /* renamed from: f */
    private boolean f18211f;

    /* renamed from: g */
    private int f18212g = 0;

    /* renamed from: h */
    private DialogInterfaceC0070b f18213h;

    @Override // android.os.AsyncTask
    protected Void doInBackground(Void[] voidArr) {
        return m18821a(voidArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Void r1) {
        m18822a(r1);
    }

    public AsyncTaskC3098c(ColorsEditor colorsEditor, List<C3096a> list, String str, String str2, boolean z, boolean z2) {
        this.f18206a = colorsEditor;
        this.f18207b = list;
        this.f18208c = str;
        this.f18209d = str2;
        this.f18210e = z;
        this.f18211f = z2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f18206a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f18213h = new DialogInterfaceC0070b.a(this.f18206a).m435b(inflate).m429a(false).m438b();
        this.f18213h.show();
    }

    /* renamed from: a */
    protected Void m18821a(Void[] voidArr) {
        String m18811c;
        String m18996a;
        for (int i = 0; i < this.f18207b.size(); i++) {
            C3096a c3096a = this.f18207b.get(i);
            if (c3096a.m18814f()) {
                m18811c = c3096a.m18812d();
            } else {
                m18811c = c3096a.m18811c();
            }
            if (this.f18210e) {
                int i2 = 8;
                if (!this.f18211f) {
                    i2 = 10;
                }
                try {
                    Matcher matcher = Pattern.compile(this.f18208c, i2).matcher(m18811c);
                    StringBuffer stringBuffer = new StringBuffer();
                    int i3 = 0;
                    while (matcher.find()) {
                        matcher.appendReplacement(stringBuffer, this.f18209d);
                        i3++;
                    }
                    if (i3 > 0) {
                        matcher.appendTail(stringBuffer);
                        c3096a.m18810b(stringBuffer.toString());
                        this.f18212g += i3;
                    }
                } catch (Exception e2) {
                }
            } else {
                if (this.f18211f) {
                    m18996a = m18811c.replace(this.f18208c, this.f18209d);
                } else {
                    m18996a = C3112bn.m18996a(m18811c, this.f18208c, this.f18209d);
                }
                if (!m18811c.equals(m18996a)) {
                    c3096a.m18810b(m18996a);
                    this.f18212g++;
                }
            }
        }
        return (Void) null;
    }

    /* renamed from: a */
    protected void m18822a(Void r8) {
        if (this.f18213h != null && this.f18213h.isShowing()) {
            try {
                this.f18213h.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f18212g > 0) {
            this.f18206a.m16499b(true);
            C3112bn.m19023b(this.f18206a, this.f18206a.getString(R.string.total_repl, new Integer(this.f18212g)));
        } else {
            this.f18206a.m16499b(false);
            C3112bn.m18999a(this.f18206a, R.string.not_found);
        }
    }
}
