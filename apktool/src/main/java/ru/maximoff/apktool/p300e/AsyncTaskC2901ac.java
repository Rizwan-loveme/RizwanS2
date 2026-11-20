package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.p008os.AsyncTask;
import android.security.keystore.KeyProperties;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3247a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: OpenZip.java */
/* renamed from: ru.maximoff.apktool.e.ac */
/* loaded from: classes.dex */
public class AsyncTaskC2901ac extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a */
    private Context f15019a;

    /* renamed from: b */
    private File f15020b;

    /* renamed from: c */
    private InterfaceC2995n f15021c;

    /* renamed from: d */
    private DialogInterfaceC0070b f15022d;

    /* renamed from: e */
    private List<C3247a> f15023e;

    /* renamed from: g */
    private String f15025g;

    /* renamed from: j */
    private Thread f15028j;

    /* renamed from: i */
    private long f15027i = 0;

    /* renamed from: f */
    private String f15024f = "";

    /* renamed from: h */
    private String f15026h = "";

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m17100a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17101a(bool);
    }

    public AsyncTaskC2901ac(Context context, File file, InterfaceC2995n interfaceC2995n) {
        this.f15019a = context;
        this.f15020b = file;
        this.f15021c = interfaceC2995n;
    }

    /* renamed from: a */
    public void m17102a(String str) {
        this.f15024f = str;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15019a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15022d = new DialogInterfaceC0070b.a(this.f15019a).m435b(inflate).m429a(false).m438b();
        this.f15022d.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.e.ac.1

            /* renamed from: a */
            private final AsyncTaskC2901ac f15029a;

            {
                this.f15029a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f15029a.f15027i > 2000) {
                    C3112bn.m18999a(this.f15029a.f15019a, R.string.click_once_more2);
                    this.f15029a.f15027i = currentTimeMillis;
                    return false;
                }
                this.f15029a.cancel(true);
                if (this.f15029a.f15028j != null) {
                    this.f15029a.f15028j.interrupt();
                }
                dialogInterface.cancel();
                return true;
            }
        });
        this.f15022d.show();
    }

    /* renamed from: a */
    protected Boolean m17100a(String[] strArr) {
        this.f15028j = Thread.currentThread();
        try {
            this.f15025g = C3262u.m19572a(this.f15020b.getAbsolutePath(), KeyProperties.DIGEST_SHA1);
            this.f15023e = m17095a(new C2604w(this.f15020b));
            return new Boolean(true);
        } catch (Error | Exception e2) {
            this.f15026h = e2.getMessage();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17101a(Boolean bool) {
        if (!isCancelled()) {
            if (this.f15022d != null && this.f15022d.isShowing()) {
                try {
                    this.f15022d.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                C3262u.m19588a(this.f15019a, this.f15020b, this.f15021c, this.f15023e, this.f15024f, this.f15025g);
            } else {
                C3112bn.m19023b(this.f15019a, this.f15019a.getString(R.string.errorf, this.f15026h));
            }
        }
    }

    /* renamed from: a */
    private List<C3247a> m17095a(C2604w c2604w) {
        ArrayList arrayList = new ArrayList();
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            boolean z = false;
            if (nextElement.getName().toLowerCase().endsWith(".xml")) {
                z = C3262u.m19655d(new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a()));
            }
            C3247a c3247a = new C3247a(nextElement.getName());
            c3247a.m19473a(nextElement.getMethod());
            c3247a.m19475a(nextElement.getCompressedSize(), nextElement.getSize());
            c3247a.m19478a(nextElement.isDirectory());
            c3247a.m19474a(nextElement.getTime());
            c3247a.m19480b(nextElement.getCrc());
            c3247a.m19485c(z);
            arrayList.add(c3247a);
        }
        return m17094a(arrayList);
    }

    /* renamed from: a */
    private List<C3247a> m17094a(List<C3247a> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (C3247a c3247a : list) {
            String m19491i = c3247a.m19491i();
            int lastIndexOf = m19491i.lastIndexOf(47);
            if (lastIndexOf != -1) {
                String substring = m19491i.substring(0, lastIndexOf);
                if (substring.lastIndexOf(47) == -1) {
                    C3247a m17096a = m17096a(arrayList, new StringBuffer().append(substring).append("/").toString());
                    if (m17096a != null) {
                        m17096a.m19481b(c3247a.m19472a(), c3247a.m19479b());
                    } else {
                        C3247a c3247a2 = new C3247a(new StringBuffer().append(substring).append("/").toString());
                        c3247a2.m19478a(true);
                        c3247a2.m19474a(c3247a.m19484c());
                        c3247a2.m19475a(c3247a.m19472a(), c3247a.m19479b());
                        arrayList.add(c3247a2);
                    }
                } else {
                    String[] split = substring.split("/");
                    String str = "";
                    for (String str2 : split) {
                        str = new StringBuffer().append(str).append(new StringBuffer().append(str2).append("/").toString()).toString();
                        C3247a m17096a2 = m17096a(arrayList, str);
                        if (m17096a2 != null) {
                            m17096a2.m19481b(c3247a.m19472a(), c3247a.m19479b());
                        } else {
                            C3247a c3247a3 = new C3247a(str);
                            c3247a3.m19478a(true);
                            c3247a3.m19474a(c3247a.m19484c());
                            c3247a3.m19475a(c3247a.m19472a(), c3247a.m19479b());
                            arrayList.add(c3247a3);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private C3247a m17096a(List<C3247a> list, String str) {
        for (C3247a c3247a : list) {
            if (c3247a.m19491i().equals(str) && c3247a.m19489g()) {
                return c3247a;
            }
        }
        return (C3247a) null;
    }
}
