package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3242g;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: HashTask.java */
/* renamed from: ru.maximoff.apktool.e.x */
/* loaded from: classes.dex */
public class AsyncTaskC2953x extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15813a;

    /* renamed from: b */
    private InterfaceC2995n f15814b;

    /* renamed from: d */
    private File f15816d;

    /* renamed from: f */
    private DialogInterfaceC0070b f15818f;

    /* renamed from: e */
    private String f15817e = "";

    /* renamed from: c */
    private HashMap<String, String> f15815c = new HashMap<>();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17590a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17591a(bool);
    }

    public AsyncTaskC2953x(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15813a = context;
        this.f15814b = interfaceC2995n;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        View inflate = LayoutInflater.from(this.f15813a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15818f = new DialogInterfaceC0070b.a(this.f15813a).m435b(inflate).m429a(false).m438b();
        this.f15818f.show();
    }

    /* renamed from: a */
    protected Boolean m17590a(File[] fileArr) {
        String name;
        try {
            this.f15816d = fileArr[0];
            C3242g c3242g = new C3242g(this.f15816d);
            if (c3242g.m19453a()) {
                this.f15815c.put("chmod", new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(c3242g.m19456d()).append(" (").toString()).append(c3242g.m19457e()).toString()).append(")").toString());
                this.f15815c.put("owner", c3242g.m19454b());
                this.f15815c.put(WifiConfiguration.GroupCipher.varName, c3242g.m19455c());
            }
            if (this.f15816d.isDirectory()) {
                this.f15815c.put("folders", String.valueOf(C3262u.m19622b(this.f15813a, this.f15816d, true, true)));
                this.f15815c.put("files", String.valueOf(C3262u.m19622b(this.f15813a, this.f15816d, false, true)));
            } else {
                this.f15815c.putAll(C3262u.m19573a(this.f15813a, this.f15816d.getAbsolutePath()));
                if (this.f15814b != null && this.f15814b.mo17952g() != null && this.f15816d.getAbsolutePath().startsWith(new StringBuffer().append(this.f15814b.mo17952g().getAbsolutePath()).append("/res/").toString())) {
                    File file = new File(new StringBuffer().append(this.f15814b.mo17952g().getAbsolutePath()).append("/res/values/public.xml").toString());
                    if (file.isFile()) {
                        int indexOf = this.f15816d.getName().indexOf(46);
                        if (indexOf > 0) {
                            name = this.f15816d.getName().substring(0, indexOf);
                        } else {
                            name = this.f15816d.getName();
                        }
                        String name2 = this.f15816d.getParentFile().getName();
                        Iterator<C3090av> it = C3061a.m18326d(file).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            C3090av next = it.next();
                            if (name2.startsWith(next.m18724a()) && name.equals(next.m18727b())) {
                                this.f15815c.put("public_id", next.m18730d());
                                break;
                            }
                        }
                    }
                }
            }
            this.f15815c.put("size", Long.toString(C3262u.m19668i(this.f15813a, this.f15816d)));
            return new Boolean(true);
        } catch (Error e2) {
            this.f15817e = e2.getMessage();
            return new Boolean(false);
        } catch (Exception e3) {
            this.f15817e = e3.getMessage();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17591a(Boolean bool) {
        if (this.f15818f != null && this.f15818f.isShowing()) {
            try {
                this.f15818f.cancel();
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            C3080al.m18552a(this.f15813a, this.f15816d, this.f15815c, this.f15814b);
        } else {
            C3112bn.m19023b(this.f15813a, this.f15813a.getString(R.string.errorf, this.f15817e));
        }
    }
}
