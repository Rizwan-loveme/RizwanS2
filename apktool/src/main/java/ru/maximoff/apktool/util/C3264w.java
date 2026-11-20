package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;

/* compiled from: FilesHistoryUtils.java */
/* renamed from: ru.maximoff.apktool.util.w */
/* loaded from: classes.dex */
public class C3264w {

    /* renamed from: a */
    private final String f20715a = "files_history";

    /* renamed from: b */
    private final int f20716b = 50;

    /* renamed from: c */
    private InterfaceC2995n f20717c;

    /* renamed from: d */
    private Context f20718d;

    /* renamed from: e */
    private List<String> f20719e;

    /* renamed from: f */
    private SharedPreferences f20720f;

    /* renamed from: g */
    private SharedPreferences.Editor f20721g;

    public C3264w(Context context, InterfaceC2995n interfaceC2995n) {
        this.f20718d = context;
        this.f20717c = interfaceC2995n;
        this.f20720f = context.getSharedPreferences("files_history", 0);
        this.f20721g = this.f20720f.edit();
        m19687b();
    }

    /* renamed from: a */
    public void m19684a() {
        C3263v c3263v = new C3263v(this.f20718d, this.f20717c, m19687b());
        c3263v.setUtils(this);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f20718d).m418a(R.string.recent_files).m435b(c3263v).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.w.1

            /* renamed from: a */
            private final C3264w f20722a;

            {
                this.f20722a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f20722a.m19691e();
                dialogInterface.dismiss();
            }
        }).m438b();
        m438b.show();
        c3263v.setDialog(m438b);
    }

    /* renamed from: b */
    public List<String> m19687b() {
        this.f20719e = m19690d();
        return this.f20719e;
    }

    /* renamed from: c */
    public boolean m19689c() {
        return this.f20719e.isEmpty();
    }

    /* renamed from: d */
    public synchronized List<String> m19690d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 50) {
                String string = this.f20720f.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    arrayList.add(string);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m19685a(File file) {
        return m19686a(file.getAbsolutePath());
    }

    /* renamed from: a */
    public synchronized boolean m19686a(String str) {
        boolean z = false;
        synchronized (this) {
            if (!C3112bn.m19040o(str)) {
                List<String> m19690d = m19690d();
                int size = m19690d.size();
                if (m19690d.contains(str)) {
                    boolean z2 = false;
                    for (int i = 0; i < size - 1; i++) {
                        if (m19690d.get(i).equals(str)) {
                            z2 = true;
                        }
                        if (z2) {
                            this.f20721g.putString(new StringBuffer().append("item_").append(i).toString(), m19690d.get(i + 1));
                        }
                    }
                    this.f20721g.putString(new StringBuffer().append("item_").append(size - 1).toString(), str);
                    z = this.f20721g.commit();
                } else if (size < 50) {
                    this.f20721g.putString(new StringBuffer().append("item_").append(size).toString(), str);
                    z = this.f20721g.commit();
                } else {
                    this.f20721g.putString(new StringBuffer().append("item_").append(49).toString(), str);
                    for (int i2 = 0; i2 < 49; i2++) {
                        this.f20721g.putString(new StringBuffer().append("item_").append(i2).toString(), m19690d.get(i2 + 1));
                    }
                    z = this.f20721g.commit();
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m19688b(String str) {
        boolean z = false;
        int i = 0;
        z = false;
        synchronized (this) {
            List<String> m19690d = m19690d();
            if (!m19690d.isEmpty() && m19690d.contains(str)) {
                m19690d.remove(str);
                this.f20721g.clear();
                while (true) {
                    int i2 = i;
                    if (i2 >= m19690d.size()) {
                        break;
                    }
                    this.f20721g.putString(new StringBuffer().append("item_").append(i2).toString(), m19690d.get(i2));
                    i = i2 + 1;
                }
                z = this.f20721g.commit();
            }
        }
        return z;
    }

    /* renamed from: e */
    public boolean m19691e() {
        return this.f20721g.clear().commit();
    }
}
