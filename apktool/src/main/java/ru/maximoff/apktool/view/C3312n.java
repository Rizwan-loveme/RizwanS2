package ru.maximoff.apktool.view;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3110bl;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: StoragesList.java */
/* renamed from: ru.maximoff.apktool.view.n */
/* loaded from: classes.dex */
public class C3312n extends CustomListView {

    /* renamed from: a */
    private Context f21229a;

    /* renamed from: b */
    private String f21230b;

    /* renamed from: c */
    private InterfaceC2995n f21231c;

    /* renamed from: d */
    private a f21232d;

    /* renamed from: e */
    private DialogInterfaceC0070b f21233e;

    public C3312n(Context context, InterfaceC2995n interfaceC2995n, String[] strArr, String str) {
        super(context);
        this.f21229a = context;
        this.f21231c = interfaceC2995n;
        this.f21230b = str;
        this.f21232d = new a(this, m20010a(strArr));
        setAdapter((ListAdapter) this.f21232d);
    }

    /* renamed from: a */
    private String[] m20010a(String[] strArr) {
        String[] strArr2 = {Environment.getRootDirectory().getAbsolutePath(), Environment.getDataDirectory().getAbsolutePath()};
        if (strArr != null) {
            strArr2 = C3080al.m18573a(strArr2, strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr2) {
            try {
                if (C3110bl.m18984a(str) > 0) {
                    arrayList.add(str);
                }
            } catch (Error e2) {
            } catch (Exception e3) {
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public void m20014a() {
        this.f21232d.notifyDataSetChanged();
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f21233e = dialogInterfaceC0070b;
    }

    /* compiled from: StoragesList.java */
    /* renamed from: ru.maximoff.apktool.view.n$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private String[] f21234a;

        /* renamed from: b */
        private final C3312n f21235b;

        /* renamed from: a */
        static C3312n m20015a(a aVar) {
            return aVar.f21235b;
        }

        public a(C3312n c3312n, String[] strArr) {
            this.f21235b = c3312n;
            this.f21234a = strArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f21234a == null) {
                return 0;
            }
            return this.f21234a.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return (this.f21234a == null || this.f21234a.length <= i) ? (Object) null : this.f21234a[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (i * 17) + 31;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2;
            String string;
            if (view == null) {
                view = LayoutInflater.from(this.f21235b.f21229a).inflate(R.layout.storage_item, (ViewGroup) null);
                b bVar2 = new b(this.f21235b);
                bVar2.f21241a = (TextView) view.findViewById(R.id.storageitemTextView1);
                bVar2.f21242b = (TextView) view.findViewById(R.id.storageitemTextView2);
                bVar2.f21243c = (TextView) view.findViewById(R.id.storageitemTextView3);
                bVar2.f21244d = (ProgressBar) view.findViewById(R.id.storageitemProgressBar1);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            String str = this.f21234a[i];
            try {
                long m18984a = C3110bl.m18984a(str);
                long m18985b = C3110bl.m18985b(str);
                long j = m18984a - m18985b;
                i2 = (int) (j / (m18984a / 100));
                string = this.f21235b.f21229a.getString(R.string.storage_info, C3106bh.m18975a(m18984a, C3102bd.f18305am), C3106bh.m18975a(j, C3102bd.f18305am), C3106bh.m18975a(m18985b, C3102bd.f18305am));
            } catch (Error | Exception e2) {
                i2 = 0;
                string = this.f21235b.f21229a.getString(R.string.errorf, e2.getMessage());
            }
            bVar.f21243c.setTextSize(2, C3102bd.m18927b());
            bVar.f21242b.setTextSize(2, C3102bd.m18927b());
            bVar.f21241a.setTextSize(2, C3102bd.f18332o);
            bVar.f21241a.setText(str);
            bVar.f21244d.setMax(100);
            bVar.f21244d.setProgress(i2);
            bVar.f21242b.setText(new StringBuffer().append(i2).append("%").toString());
            bVar.f21243c.setText(string);
            if (this.f21235b.f21230b.startsWith(str)) {
                view.setBackgroundColor(C3246h.m19470a(this.f21235b.f21229a, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
            } else {
                view.setBackgroundColor(0);
            }
            view.setOnClickListener(new View.OnClickListener(this, str) { // from class: ru.maximoff.apktool.view.n.a.1

                /* renamed from: a */
                private final a f21236a;

                /* renamed from: b */
                private final String f21237b;

                {
                    this.f21236a = this;
                    this.f21237b = str;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.m20015a(this.f21236a).f21233e != null) {
                        a.m20015a(this.f21236a).f21233e.cancel();
                    }
                    a.m20015a(this.f21236a).f21231c.mo17934a(new File(this.f21237b));
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(this, str, string) { // from class: ru.maximoff.apktool.view.n.a.2

                /* renamed from: a */
                private final a f21238a;

                /* renamed from: b */
                private final String f21239b;

                /* renamed from: c */
                private final String f21240c;

                {
                    this.f21238a = this;
                    this.f21239b = str;
                    this.f21240c = string;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    C3112bn.m19002a(a.m20015a(this.f21238a).f21229a, new StringBuffer().append(new StringBuffer().append(this.f21239b).append("\n").toString()).append(this.f21240c).toString());
                    return true;
                }
            });
            return view;
        }
    }

    /* compiled from: StoragesList.java */
    /* renamed from: ru.maximoff.apktool.view.n$b */
    private class b {

        /* renamed from: a */
        public TextView f21241a;

        /* renamed from: b */
        public TextView f21242b;

        /* renamed from: c */
        public TextView f21243c;

        /* renamed from: d */
        public ProgressBar f21244d;

        /* renamed from: e */
        private final C3312n f21245e;

        public b(C3312n c3312n) {
            this.f21245e = c3312n;
        }
    }
}
