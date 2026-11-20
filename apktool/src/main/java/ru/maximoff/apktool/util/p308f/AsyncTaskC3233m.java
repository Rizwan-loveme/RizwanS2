package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.List;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: SaveToDict.java */
/* renamed from: ru.maximoff.apktool.util.f.m */
/* loaded from: classes.dex */
public class AsyncTaskC3233m extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19385a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19386b;

    /* renamed from: c */
    private List<C3236p> f19387c;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19356a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19357a(str);
    }

    public AsyncTaskC3233m(Context context, List<C3236p> list) {
        this.f19385a = context;
        this.f19387c = list;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f19385a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19386b = new DialogInterfaceC0070b.a(this.f19385a).m435b(inflate).m429a(false).m438b();
        this.f19386b.show();
    }

    /* renamed from: a */
    protected String m19356a(String[] strArr) {
        try {
            C3225e.m19327a(this.f19385a, strArr[0], this.f19387c);
            return (String) null;
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    /* renamed from: a */
    protected void m19357a(String str) {
        if (this.f19386b != null && this.f19386b.isShowing()) {
            try {
                this.f19386b.cancel();
            } catch (Exception e2) {
            }
        }
        if (str == null) {
            C3112bn.m19023b(this.f19385a, this.f19385a.getString(R.string.success));
        } else {
            C3112bn.m19023b(this.f19385a, this.f19385a.getString(R.string.errorf, str));
        }
    }
}
