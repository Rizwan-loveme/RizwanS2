package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.HashMap;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: PropTask.java */
/* renamed from: ru.maximoff.apktool.e.ai */
/* loaded from: classes.dex */
public class AsyncTaskC2907ai extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15109a;

    /* renamed from: d */
    private DialogInterfaceC0070b f15112d;

    /* renamed from: c */
    private String f15111c = "";

    /* renamed from: b */
    private HashMap<String, String> f15110b = new HashMap<>();

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17142a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17143a(bool);
    }

    public AsyncTaskC2907ai(Context context) {
        this.f15109a = context;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        View inflate = LayoutInflater.from(this.f15109a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15112d = new DialogInterfaceC0070b.a(this.f15109a).m435b(inflate).m429a(false).m438b();
        this.f15112d.show();
    }

    /* renamed from: a */
    protected Boolean m17142a(File[] fileArr) {
        long j = 0;
        int i = 0;
        int i2 = 0;
        for (File file : fileArr) {
            try {
                if (file.isDirectory()) {
                    i = i + 1 + C3262u.m19622b(this.f15109a, file, true, true);
                    i2 += C3262u.m19622b(this.f15109a, file, false, true);
                } else {
                    i2++;
                }
                j += C3262u.m19668i(this.f15109a, file);
            } catch (Error e2) {
                this.f15111c = e2.getMessage();
                return new Boolean(false);
            } catch (Exception e3) {
                this.f15111c = e3.getMessage();
                return new Boolean(false);
            }
        }
        this.f15110b.put("path", fileArr[0].getParent());
        this.f15110b.put("folders", String.valueOf(i));
        this.f15110b.put("files", String.valueOf(i2));
        this.f15110b.put("size", Long.toString(j));
        return new Boolean(true);
    }

    /* renamed from: a */
    protected void m17143a(Boolean bool) {
        if (this.f15112d != null && this.f15112d.isShowing()) {
            try {
                this.f15112d.cancel();
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            C3080al.m18555a(this.f15109a, this.f15110b);
        } else {
            C3112bn.m19023b(this.f15109a, this.f15109a.getString(R.string.errorf, this.f15111c));
        }
    }
}
