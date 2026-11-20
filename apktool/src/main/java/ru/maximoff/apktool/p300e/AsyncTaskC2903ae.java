package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.view.C3302d;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: ParseLibs.java */
/* renamed from: ru.maximoff.apktool.e.ae */
/* loaded from: classes.dex */
public class AsyncTaskC2903ae extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15049a;

    /* renamed from: b */
    private View f15050b;

    /* renamed from: c */
    private InterfaceC2995n f15051c;

    /* renamed from: d */
    private File f15052d;

    /* renamed from: e */
    private String f15053e;

    /* renamed from: f */
    private int f15054f = 0;

    /* renamed from: g */
    private List<String> f15055g;

    /* renamed from: h */
    private List<String> f15056h;

    /* renamed from: i */
    private C3302d f15057i;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17114a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled(Boolean bool) {
        m17116b(bool);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17115a(bool);
    }

    public AsyncTaskC2903ae(Context context, View view, InterfaceC2995n interfaceC2995n) {
        this.f15049a = context;
        this.f15050b = view;
        this.f15051c = interfaceC2995n;
        if (view.getTag() != null && (view.getTag() instanceof C3302d)) {
            this.f15057i = (C3302d) view.getTag();
        } else {
            this.f15057i = (C3302d) null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (this.f15057i != null) {
            this.f15057i.f20967d.setVisibility(8);
            this.f15057i.f20966c.setVisibility(0);
        }
    }

    /* renamed from: a */
    protected Boolean m17114a(File[] fileArr) {
        try {
            this.f15052d = fileArr[0];
            this.f15056h = m17113a(this.f15052d);
            this.f15055g = m17112a();
            return new Boolean(true);
        } catch (Error e2) {
            this.f15053e = e2.toString();
            return new Boolean(false);
        } catch (Exception e3) {
            this.f15053e = e3.toString();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17115a(Boolean bool) {
        if (this.f15057i != null) {
            this.f15057i.f20967d.setVisibility(0);
            this.f15057i.f20966c.setVisibility(8);
        }
        if (bool.booleanValue()) {
            C3262u.m19609a(this.f15052d, this.f15050b, this.f15051c, this.f15055g, this.f15056h, this.f15054f);
        } else {
            C3112bn.m19023b(this.f15049a, this.f15049a.getString(R.string.errorf, this.f15053e));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f15057i != null) {
            this.f15057i.f20967d.setVisibility(0);
            this.f15057i.f20966c.setVisibility(8);
        }
    }

    /* renamed from: b */
    protected void m17116b(Boolean bool) {
        if (this.f15057i != null) {
            this.f15057i.f20967d.setVisibility(0);
            this.f15057i.f20966c.setVisibility(8);
        }
    }

    /* renamed from: a */
    private List<String> m17112a() {
        ArrayList arrayList = new ArrayList();
        if (!this.f15056h.isEmpty()) {
            Iterator<String> it = this.f15056h.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(";", 2);
                String substring = split[1].substring(0, split[1].lastIndexOf(47));
                if (!arrayList.contains(substring)) {
                    arrayList.add(substring);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m17113a(File file) {
        ArrayList arrayList = new ArrayList();
        try {
            C2604w c2604w = new C2604w(file);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                C2602u nextElement = m16163b.nextElement();
                String name = nextElement.getName();
                if (!nextElement.isDirectory() && name.matches("^classes(\\d+)?\\.dex$")) {
                    this.f15054f++;
                }
                if (!nextElement.isDirectory() && name.startsWith("lib/")) {
                    String substring = name.substring(4);
                    if (substring.indexOf(47) != -1) {
                        String stringBuffer = new StringBuffer().append(new StringBuffer().append(nextElement.getSize()).append(";").toString()).append(substring).toString();
                        if (!arrayList.contains(stringBuffer)) {
                            arrayList.add(stringBuffer);
                        }
                    }
                }
            }
            c2604w.close();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        Collections.sort(arrayList, new Comparator<String>(this) { // from class: ru.maximoff.apktool.e.ae.1

            /* renamed from: a */
            private final AsyncTaskC2903ae f15058a;

            {
                this.f15058a = this;
            }

            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return m17117a(str, str2);
            }

            /* renamed from: a */
            public int m17117a(String str, String str2) {
                return str.split(";", 2)[1].compareTo(str2.split(";", 2)[1]);
            }
        });
        return arrayList;
    }
}
