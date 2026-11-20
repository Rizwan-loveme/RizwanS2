package ru.maximoff.apktool.util.p306d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.C0170al;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: SearchHistory.java */
/* renamed from: ru.maximoff.apktool.util.d.b */
/* loaded from: classes.dex */
public class C3212b {

    /* renamed from: a */
    private Context f19140a;

    /* renamed from: b */
    private int f19141b;

    /* renamed from: c */
    private ImageView f19142c;

    /* renamed from: d */
    private InputMethodManager f19143d;

    /* renamed from: e */
    private SharedPreferences f19144e;

    /* renamed from: f */
    private SharedPreferences.Editor f19145f;

    public C3212b(Context context) {
        this(context, "search_history_", Logger.GLOBAL_LOGGER_NAME);
    }

    public C3212b(Context context, String str) {
        this(context, "search_history_", str);
    }

    public C3212b(Context context, String str, String str2) {
        this.f19141b = 70;
        this.f19140a = context;
        this.f19143d = (InputMethodManager) this.f19140a.getSystemService(Context.INPUT_METHOD_SERVICE);
        this.f19144e = context.getSharedPreferences(new StringBuffer().append(str).append(str2).toString(), 0);
        this.f19145f = this.f19144e.edit();
    }

    /* renamed from: a */
    public boolean m19202a() {
        Map<String, ?> all = this.f19144e.getAll();
        return all == null || all.isEmpty();
    }

    /* renamed from: b */
    public synchronized List<String> m19205b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f19141b) {
                String string = this.f19144e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    arrayList.add(string);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized Map<Integer, String> m19207c() {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f19141b) {
                String string = this.f19144e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
                if (string != null) {
                    linkedHashMap.put(new Integer(i2), string);
                }
                i = i2 + 1;
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public synchronized boolean m19204a(String str) {
        boolean z = false;
        int i = 0;
        synchronized (this) {
            if (!C3112bn.m19040o(str)) {
                List<String> m19205b = m19205b();
                int size = m19205b.size();
                if (m19205b.contains(str)) {
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 < size - 1) {
                        boolean z3 = z2;
                        if (m19205b.get(i2).equals(str)) {
                            z3 = true;
                        }
                        if (z3) {
                            this.f19145f.putString(new StringBuffer().append("item_").append(i2).toString(), m19205b.get(i2 + 1));
                        }
                        i2++;
                        z2 = z3;
                    }
                    this.f19145f.putString(new StringBuffer().append("item_").append(size - 1).toString(), str);
                    z = this.f19145f.commit();
                } else if (size < this.f19141b) {
                    this.f19145f.putString(new StringBuffer().append("item_").append(size).toString(), str);
                    z = this.f19145f.commit();
                } else {
                    this.f19145f.putString(new StringBuffer().append("item_").append(this.f19141b - 1).toString(), str);
                    while (true) {
                        int i3 = i;
                        if (i3 >= this.f19141b - 1) {
                            break;
                        }
                        this.f19145f.putString(new StringBuffer().append("item_").append(i3).toString(), m19205b.get(i3 + 1));
                        i = i3 + 1;
                    }
                    z = this.f19145f.commit();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m19203a(int i, int i2) {
        String string;
        String string2;
        string = this.f19144e.getString(new StringBuffer().append("item_").append(i).toString(), (String) null);
        string2 = this.f19144e.getString(new StringBuffer().append("item_").append(i2).toString(), (String) null);
        return (string == null || string2 == null) ? false : this.f19145f.putString(new StringBuffer().append("item_").append(i).toString(), string2).putString(new StringBuffer().append("item_").append(i2).toString(), string).commit();
    }

    /* renamed from: b */
    public synchronized boolean m19206b(String str) {
        boolean z = false;
        int i = 0;
        z = false;
        synchronized (this) {
            List<String> m19205b = m19205b();
            if (!m19205b.isEmpty() && m19205b.contains(str)) {
                m19205b.remove(str);
                this.f19145f.clear();
                while (true) {
                    int i2 = i;
                    if (i2 >= m19205b.size()) {
                        break;
                    }
                    this.f19145f.putString(new StringBuffer().append("item_").append(i2).toString(), m19205b.get(i2));
                    i = i2 + 1;
                }
                z = this.f19145f.commit();
            }
        }
        return z;
    }

    /* renamed from: d */
    public boolean m19208d() {
        return this.f19145f.clear().commit();
    }

    /* renamed from: a */
    public void m19201a(ImageView imageView, EditText editText) {
        this.f19142c = imageView;
        List<String> m19205b = m19205b();
        if (!m19205b.isEmpty()) {
            Collections.reverse(m19205b);
            C0170al c0170al = new C0170al(this.f19140a);
            c0170al.mo1314a(new a(this, c0170al, m19205b, editText));
            c0170al.m1320b(editText);
            c0170al.m1316a(true);
            c0170al.mo841b_();
        }
    }

    /* compiled from: SearchHistory.java */
    /* renamed from: ru.maximoff.apktool.util.d.b$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private C0170al f19146a;

        /* renamed from: b */
        private List<String> f19147b;

        /* renamed from: c */
        private EditText f19148c;

        /* renamed from: d */
        private final C3212b f19149d;

        /* renamed from: d */
        static C3212b m19212d(a aVar) {
            return aVar.f19149d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m19213a(i);
        }

        public a(C3212b c3212b, C0170al c0170al, List<String> list, EditText editText) {
            this.f19149d = c3212b;
            this.f19147b = (List) null;
            this.f19146a = c0170al;
            this.f19147b = list;
            this.f19148c = editText;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f19147b != null) {
                return this.f19147b.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m19213a(int i) {
            return this.f19147b != null ? this.f19147b.get(i) : (String) null;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = ((LayoutInflater) this.f19149d.f19140a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.history_item, (ViewGroup) null);
                bVar = new b(this.f19149d);
                bVar.f19158b = (TextView) view.findViewById(R.id.historyitemTextView1);
                bVar.f19159c = (TextView) view.findViewById(R.id.historyitemTextView2);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f19157a = i;
            String str = this.f19147b.get(i);
            if (str != null) {
                bVar.f19158b.setText(str);
                bVar.f19158b.setOnClickListener(new AnonymousClass1(this, str));
                bVar.f19158b.setOnLongClickListener(new View.OnLongClickListener(this, str) { // from class: ru.maximoff.apktool.util.d.b.a.2

                    /* renamed from: a */
                    private final a f19153a;

                    /* renamed from: b */
                    private final String f19154b;

                    {
                        this.f19153a = this;
                        this.f19154b = str;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        C3112bn.m19002a(a.m19212d(this.f19153a).f19140a, this.f19154b);
                        return true;
                    }
                });
                bVar.f19159c.setOnClickListener(new View.OnClickListener(this, str) { // from class: ru.maximoff.apktool.util.d.b.a.3

                    /* renamed from: a */
                    private final a f19155a;

                    /* renamed from: b */
                    private final String f19156b;

                    {
                        this.f19155a = this;
                        this.f19156b = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.m19212d(this.f19155a).m19206b(this.f19156b);
                        this.f19155a.f19147b.remove(this.f19156b);
                        if (this.f19155a.f19147b.isEmpty()) {
                            this.f19155a.f19146a.mo842c();
                            a.m19212d(this.f19155a).f19142c.setVisibility(8);
                        } else {
                            this.f19155a.notifyDataSetChanged();
                        }
                    }
                });
            }
            return view;
        }

        /* compiled from: SearchHistory.java */
        /* renamed from: ru.maximoff.apktool.util.d.b$a$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {

            /* renamed from: a */
            private final a f19150a;

            /* renamed from: b */
            private final String f19151b;

            AnonymousClass1(a aVar, String str) {
                this.f19150a = aVar;
                this.f19151b = str;
            }

            /* renamed from: a */
            static a m19214a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f19150a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f19150a.f19146a.mo842c();
                this.f19150a.f19148c.setText(this.f19151b);
                this.f19150a.f19148c.requestFocus();
                this.f19150a.f19148c.setSelection(this.f19151b.length());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.util.d.b.a.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f19152a;

                    {
                        this.f19152a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.m19212d(AnonymousClass1.m19214a(this.f19152a)).f19143d.showSoftInput(AnonymousClass1.m19214a(this.f19152a).f19148c, 1);
                    }
                }, 100L);
            }
        }
    }

    /* compiled from: SearchHistory.java */
    /* renamed from: ru.maximoff.apktool.util.d.b$b */
    private class b {

        /* renamed from: a */
        public int f19157a;

        /* renamed from: b */
        public TextView f19158b;

        /* renamed from: c */
        public TextView f19159c;

        /* renamed from: d */
        private final C3212b f19160d;

        public b(C3212b c3212b) {
            this.f19160d = c3212b;
        }
    }
}
