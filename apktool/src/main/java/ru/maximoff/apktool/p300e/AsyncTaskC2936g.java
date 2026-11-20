package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: CompareApk.java */
/* renamed from: ru.maximoff.apktool.e.g */
/* loaded from: classes.dex */
public class AsyncTaskC2936g extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15636a;

    /* renamed from: b */
    private InterfaceC2995n f15637b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15638c;

    /* renamed from: d */
    private File f15639d;

    /* renamed from: e */
    private boolean f15640e = false;

    /* renamed from: f */
    private final String f15641f = "==============================";

    /* renamed from: g */
    private final Set<String> f15642g = new TreeSet();

    /* renamed from: h */
    private final Set<String> f15643h = new TreeSet();

    /* renamed from: i */
    private final Set<String> f15644i = new TreeSet();

    /* renamed from: j */
    private final Set<String> f15645j = new TreeSet();

    /* renamed from: k */
    private final Set<String> f15646k = new TreeSet();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17488a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17489a(bool);
    }

    public AsyncTaskC2936g(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15636a = context;
        this.f15637b = interfaceC2995n;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15636a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15638c = new DialogInterfaceC0070b.a(this.f15636a).m435b(inflate).m429a(false).m438b();
        this.f15638c.show();
    }

    /* renamed from: a */
    protected Boolean m17488a(File[] fileArr) {
        Boolean bool;
        try {
            this.f15639d = m17485a(fileArr[0]);
            m17486a(fileArr[0], fileArr[1]);
            if (this.f15644i.isEmpty() && this.f15645j.isEmpty() && this.f15642g.isEmpty()) {
                this.f15640e = true;
                bool = new Boolean(true);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(fileArr[0].getAbsolutePath()).append("\n");
                sb.append(fileArr[1].getAbsolutePath()).append("\n");
                m17487a(sb, this.f15642g, R.string.compare_apk_mod);
                m17487a(sb, this.f15646k, R.string.compare_apk_mov);
                m17487a(sb, this.f15644i, R.string.compare_apk_add);
                m17487a(sb, this.f15645j, R.string.compare_apk_del);
                m17487a(sb, this.f15643h, R.string.compare_apk_unmod);
                C3061a.m18319b(this.f15639d, sb.toString());
                bool = new Boolean(true);
            }
            return bool;
        } catch (Error | Exception e2) {
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    private void m17487a(StringBuilder sb, Set<String> set, int i) {
        if (!set.isEmpty()) {
            sb.append("\n").append(this.f15636a.getString(i)).append("\n").append("==============================").append("\n");
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append("\n");
            }
        }
    }

    /* renamed from: a */
    private void m17486a(File file, File file2) {
        ArrayList<C2602u> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C2604w c2604w = new C2604w(file);
        C2604w c2604w2 = new C2604w(file2);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            C2602u m16162a = c2604w2.m16162a(nextElement.getName());
            if (m16162a == null) {
                arrayList.add(nextElement);
            } else if (nextElement.getCrc() == m16162a.getCrc() && nextElement.getSize() == m16162a.getSize()) {
                this.f15643h.add(nextElement.getName());
            } else {
                this.f15642g.add(nextElement.getName());
            }
        }
        Enumeration<C2602u> m16163b2 = c2604w2.m16163b();
        while (m16163b2.hasMoreElements()) {
            C2602u nextElement2 = m16163b2.nextElement();
            if (c2604w.m16162a(nextElement2.getName()) == null) {
                arrayList2.add(nextElement2);
            }
        }
        for (C2602u c2602u : arrayList) {
            int m17484a = m17484a(arrayList2, c2602u);
            if (m17484a != -1) {
                this.f15646k.add(new StringBuffer().append(new StringBuffer().append(c2602u.getName()).append(" -> ").toString()).append(arrayList2.get(m17484a).getName()).toString());
                arrayList2.remove(m17484a);
            } else {
                this.f15645j.add(c2602u.getName());
            }
        }
        Iterator<E> it = arrayList2.iterator();
        while (it.hasNext()) {
            this.f15644i.add(((C2602u) it.next()).getName());
        }
        c2604w.close();
        c2604w2.close();
    }

    /* renamed from: a */
    private int m17484a(List<C2602u> list, C2602u c2602u) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C2602u c2602u2 = list.get(i2);
                if (c2602u2 != null && c2602u2.getCrc() == c2602u.getCrc() && c2602u2.getSize() == c2602u.getSize()) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: a */
    protected void m17489a(Boolean bool) {
        if (this.f15638c != null && this.f15638c.isShowing()) {
            try {
                this.f15638c.cancel();
            } catch (Exception e2) {
            }
        }
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
            if (this.f15637b != null) {
                this.f15637b.mo17929a();
            }
            if (bool.booleanValue()) {
                if (this.f15640e) {
                    C3112bn.m18999a(this.f15636a, R.string.files_identical);
                    return;
                }
                if (this.f15639d != null) {
                    C3112bn.m19023b(this.f15636a, this.f15636a.getString(R.string.complete_msg2, this.f15639d.getAbsolutePath()));
                    if (m16615o.m16617B() != null) {
                        m16615o.m16617B().m17636a(this.f15639d);
                        return;
                    }
                    return;
                }
                C3112bn.m18999a(this.f15636a, R.string.error);
                return;
            }
            if (this.f15639d != null && this.f15639d.exists()) {
                this.f15639d.delete();
            }
            C3112bn.m18999a(this.f15636a, R.string.error);
        }
    }

    /* renamed from: a */
    private File m17485a(File file) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15636a, file)) || C3102bd.m18925a(this.f15636a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                return (File) null;
            }
            if (!file2.isDirectory()) {
                return (File) null;
            }
        }
        String str = parent;
        return new File(str, C3262u.m19566a(this.f15636a, str, C3112bn.m19033h(new StringBuffer().append(new StringBuffer().append(this.f15636a.getString(R.string.compare_apk)).append("_").toString()).append(C3112bn.m19032g("yyyyMMddHHmmss")).toString()), ".txt", 0));
    }
}
