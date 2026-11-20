package ru.maximoff.apktool.p300e;

import android.app.ProgressDialog;
import android.content.Context;
import android.p008os.AsyncTask;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: RenameTask.java */
/* renamed from: ru.maximoff.apktool.e.al */
/* loaded from: classes.dex */
public class AsyncTaskC2910al extends AsyncTask<File, Integer, Boolean> {

    /* renamed from: a */
    private Context f15261a;

    /* renamed from: b */
    private InterfaceC2995n f15262b;

    /* renamed from: c */
    private HashMap<String, String> f15263c;

    /* renamed from: d */
    private int f15264d = 0;

    /* renamed from: e */
    private List<String> f15265e = new ArrayList();

    /* renamed from: f */
    private ProgressDialog f15266f;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17234a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17235a(bool);
    }

    public AsyncTaskC2910al(Context context, InterfaceC2995n interfaceC2995n, HashMap<String, String> hashMap) {
        this.f15261a = context;
        this.f15262b = interfaceC2995n;
        this.f15263c = hashMap;
        this.f15266f = new ProgressDialog(context);
        this.f15266f.setCancelable(false);
        this.f15266f.setMessage(context.getString(R.string.mplease_wait));
        this.f15266f.show();
    }

    /* renamed from: a */
    protected Boolean m17234a(File[] fileArr) {
        boolean renameTo;
        for (Map.Entry<String, String> entry : this.f15263c.entrySet()) {
            File file = new File(entry.getKey());
            File file2 = new File(entry.getValue());
            if (!file.getName().equals(file2.getName())) {
                if (file2.exists()) {
                    File file3 = new File(file.getParentFile(), new StringBuffer().append(".").append(C3112bn.m18988a(7)).toString());
                    while (file3.exists()) {
                        file3 = new File(file.getParentFile(), new StringBuffer().append(".").append(C3112bn.m18988a(7)).toString());
                    }
                    if (file.renameTo(file3)) {
                        renameTo = file3.renameTo(file2);
                    } else {
                        renameTo = false;
                    }
                } else {
                    renameTo = file.renameTo(file2);
                }
                if (renameTo) {
                    this.f15264d++;
                    this.f15265e.add(file2.getAbsolutePath());
                }
            }
        }
        return (Boolean) null;
    }

    /* renamed from: a */
    protected void m17235a(Boolean bool) {
        if (this.f15266f != null && this.f15266f.isShowing()) {
            try {
                this.f15266f.cancel();
            } catch (Exception e2) {
            }
        }
        C3112bn.m19000a(this.f15261a, R.string.success_of, new Integer(this.f15264d), new Integer(this.f15263c.size()));
        if (this.f15262b != null) {
            this.f15262b.mo17929a();
            this.f15262b.mo17935a(this.f15265e);
        }
        C2978b.f16135a.m17711f();
    }
}
