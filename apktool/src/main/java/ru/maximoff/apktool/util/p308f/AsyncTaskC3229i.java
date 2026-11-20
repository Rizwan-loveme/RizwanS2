package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.Map;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: MergeDicts.java */
/* renamed from: ru.maximoff.apktool.util.f.i */
/* loaded from: classes.dex */
public class AsyncTaskC3229i extends AsyncTask<File, String, String> {

    /* renamed from: a */
    private Context f19363a;

    /* renamed from: b */
    private InterfaceC2995n f19364b;

    /* renamed from: c */
    private DialogInterfaceC0070b f19365c;

    /* renamed from: d */
    private String f19366d;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(File[] fileArr) {
        return m19348a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19349a(str);
    }

    public AsyncTaskC3229i(Context context, InterfaceC2995n interfaceC2995n, String str) {
        this.f19363a = context;
        this.f19364b = interfaceC2995n;
        this.f19366d = str;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19363a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19365c = new DialogInterfaceC0070b.a(this.f19363a).m435b(inflate).m429a(false).m438b();
        this.f19365c.show();
    }

    /* renamed from: a */
    protected String m19348a(File[] fileArr) {
        for (File file : fileArr) {
            try {
                Map<String, String> m19324a = C3225e.m19324a(file, false);
                if (m19324a != null) {
                    C3225e.m19328a(this.f19363a, this.f19366d, m19324a);
                }
            } catch (Exception e2) {
                return e2.getMessage();
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    protected void m19349a(String str) {
        if (this.f19365c != null && this.f19365c.isShowing()) {
            try {
                this.f19365c.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f19364b != null) {
            this.f19364b.mo17929a();
        }
        if (str == null) {
            C3112bn.m19023b(this.f19363a, this.f19363a.getString(R.string.successf, new File(C3102bd.f18339v, new StringBuffer().append("dictionary/").append(this.f19366d).toString()).getAbsolutePath()));
        } else {
            C3112bn.m19023b(this.f19363a, this.f19363a.getString(R.string.errorf, str));
        }
    }
}
