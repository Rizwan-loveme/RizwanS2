package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3253m;
import ru.maximoff.apktool.util.C3262u;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: DexInfoTask.java */
/* renamed from: ru.maximoff.apktool.e.o */
/* loaded from: classes.dex */
public class AsyncTaskC2944o extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15692a;

    /* renamed from: b */
    private C3060a f15693b;

    /* renamed from: c */
    private Map<String, C3253m> f15694c;

    public AsyncTaskC2944o(Context context, C3060a c3060a) {
        super(context, (InterfaceC2995n) null);
        this.f15692a = context;
        this.f15693b = c3060a;
        this.f15694c = new LinkedHashMap();
        m17070e(false);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.dexs_info;
    }

    /* renamed from: a */
    public void m17521a(String str, C3253m c3253m) {
        this.f15694c.put(str, c3253m);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        if (file != null) {
            try {
                try {
                    this.f15694c.putAll(m17520d(file));
                } catch (Error e2) {
                    mo3979a(R.string.errorf, e2.toString());
                    return false;
                }
            } catch (Exception e3) {
                mo3979a(R.string.errorf, e3.toString());
                return false;
            }
        }
        if (!this.f15694c.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList(this.f15694c.keySet());
            Collections.sort(arrayList, new Comparator<String>(this) { // from class: ru.maximoff.apktool.e.o.1

                /* renamed from: a */
                private final AsyncTaskC2944o f15695a;

                {
                    this.f15695a = this;
                }

                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    return m17523a(str, str2);
                }

                /* renamed from: a */
                public int m17523a(String str, String str2) {
                    return m17522a(str) - m17522a(str2);
                }

                /* renamed from: a */
                private int m17522a(String str) {
                    String replaceAll = str.replaceAll("\\D", "");
                    if (replaceAll.isEmpty()) {
                        return 0;
                    }
                    return Integer.parseInt(replaceAll);
                }
            });
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            long j = 0;
            if (this.f15693b != null) {
                try {
                    m17069e(R.string.text, C3112bn.m18992a(this.f15692a, this.f15693b, C3102bd.m18910a(this.f15692a, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})")));
                    m17069e(R.string.text, "");
                } catch (Exception e4) {
                }
            }
            for (String str : arrayList) {
                if (i > 0) {
                    m17069e(R.string.text, "");
                }
                m17069e(R.string.text, str);
                C3253m c3253m = this.f15694c.get(str);
                i2 += c3253m.f19660f;
                i3 += c3253m.f19659e;
                i4 += c3253m.f19656b;
                i5 += c3253m.f19661g;
                i6 += c3253m.f19657c;
                i7 += c3253m.f19658d;
                j += c3253m.f19662h;
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.dex_version)).append(": ").toString()).append(c3253m.f19655a).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.methods_count)).append(": ").toString()).append(String.valueOf(c3253m.f19660f)).toString()).append(" (").toString()).append(C3080al.m18531a(65536, c3253m.f19660f, 2)).toString()).append(")").toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.fields_count)).append(": ").toString()).append(String.valueOf(c3253m.f19659e)).toString()).append(" (").toString()).append(C3080al.m18531a(65536, c3253m.f19659e, 2)).toString()).append(")").toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.strings_count)).append(": ").toString()).append(String.valueOf(c3253m.f19656b)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.class_count)).append(": ").toString()).append(String.valueOf(c3253m.f19661g)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.types_count)).append(": ").toString()).append(String.valueOf(c3253m.f19657c)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.protos_count)).append(": ").toString()).append(String.valueOf(c3253m.f19658d)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.size_label)).append(": ").toString()).append(C3106bh.m18975a(c3253m.f19662h, C3102bd.f18305am)).toString());
                i++;
            }
            if (this.f15694c.size() > 1) {
                int m17519a = m17519a(i2);
                int m17519a2 = m17519a(i3);
                String quantityString = this.f15692a.getResources().getQuantityString(R.plurals.need_dex, m17519a, new Integer(m17519a));
                String quantityString2 = this.f15692a.getResources().getQuantityString(R.plurals.need_dex, m17519a2, new Integer(m17519a2));
                m17069e(R.string.text, "");
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.total)).append(" (").toString()).append(String.valueOf(this.f15694c.size())).toString()).append(" dex)").toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.methods_count)).append(": ").toString()).append(String.valueOf(i2)).toString()).append(" (").toString()).append(quantityString).toString()).append(")").toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.fields_count)).append(": ").toString()).append(String.valueOf(i3)).toString()).append(" (").toString()).append(quantityString2).toString()).append(")").toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.strings_count)).append(": ").toString()).append(String.valueOf(i4)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.class_count)).append(": ").toString()).append(String.valueOf(i5)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.types_count)).append(": ").toString()).append(String.valueOf(i6)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.protos_count)).append(": ").toString()).append(String.valueOf(i7)).toString());
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15692a.getString(R.string.size_label)).append(": ").toString()).append(C3106bh.m18975a(j, C3102bd.f18305am)).toString());
            }
            m17069e(R.string.text, "");
            m17069e(R.string.dex_limit_info, new Integer(65536));
        } else {
            mo3983c(R.string.not_found, (Object) null);
        }
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: d */
    private Map<String, C3253m> m17520d(File file) {
        C3253m m19574a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C2604w c2604w = new C2604w(file);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            if (!nextElement.isDirectory() && nextElement.getName().matches("^classes(\\d+)?\\.dex$") && (m19574a = C3262u.m19574a(new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a()))) != null) {
                m19574a.f19662h = nextElement.getSize();
                linkedHashMap.put(nextElement.getName(), m19574a);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private int m17519a(int i) {
        int i2 = i / 65536;
        return i % 65536 > 0 ? i2 + 1 : i2;
    }
}
