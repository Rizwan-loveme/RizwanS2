package ru.maximoff.apktool.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: SmaliHelpAdapter.java */
/* renamed from: ru.maximoff.apktool.view.m */
/* loaded from: classes.dex */
public class C3311m extends BaseAdapter {

    /* renamed from: a */
    private final Context f21216a;

    /* renamed from: b */
    private final int f21217b;

    /* renamed from: c */
    private final String[] f21218c;

    /* renamed from: d */
    private final String[] f21219d;

    /* renamed from: e */
    private String[] f21220e;

    /* renamed from: f */
    private String[] f21221f;

    public C3311m(Context context) {
        this.f21216a = context;
        this.f21217b = C3102bd.f18291a ? C3246h.m19470a(this.f21216a, R.color.accent_material_light) : C3246h.m19470a(this.f21216a, R.color.accent_material);
        this.f21218c = C3080al.m18573a(this.f21216a.getResources().getStringArray(R.array.smali_help_names), this.f21216a.getResources().getStringArray(R.array.smali_help_common_names));
        this.f21219d = this.f21216a.getResources().getStringArray(R.array.smali_help_values);
        if (this.f21218c.length != this.f21219d.length) {
            throw new Exception("resources read error");
        }
        m20008a((String) null);
    }

    /* renamed from: a */
    public void m20008a(String str) {
        if (!C3112bn.m19040o(str)) {
            str = str.trim();
        }
        if (C3112bn.m19040o(str)) {
            this.f21220e = this.f21218c;
            this.f21221f = this.f21219d;
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.f21218c.length; i++) {
                if (this.f21218c[i].toLowerCase().indexOf(str.toLowerCase()) >= 0) {
                    arrayList.add(this.f21218c[i]);
                    arrayList2.add(this.f21219d[i]);
                }
            }
            this.f21220e = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.f21221f = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21220e.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return i >= getCount() ? (Object) null : this.f21220e[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (this.f21220e.length * i) + 17;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f21216a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.perm_entry, (ViewGroup) null);
            a aVar2 = new a(this);
            aVar2.f21225a = (CheckBox) view.findViewById(R.id.permentryCheckBox1);
            aVar2.f21226b = (TextView) view.findViewById(R.id.permentryTextView1);
            aVar2.f21227c = (TextView) view.findViewById(R.id.permentryTextView2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setMinimumHeight(0);
        String str = this.f21220e[i];
        String str2 = this.f21221f[i];
        aVar.f21225a.setVisibility(8);
        aVar.f21226b.setTextSize(2, C3102bd.f18332o);
        aVar.f21227c.setTextSize(2, C3102bd.f18332o - 2);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.f21217b), 0, str.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        aVar.f21226b.setText(spannableString);
        aVar.f21227c.setText(str2);
        view.setOnLongClickListener(new View.OnLongClickListener(this, str, str2) { // from class: ru.maximoff.apktool.view.m.1

            /* renamed from: a */
            private final C3311m f21222a;

            /* renamed from: b */
            private final String f21223b;

            /* renamed from: c */
            private final String f21224c;

            {
                this.f21222a = this;
                this.f21223b = str;
                this.f21224c = str2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                C3112bn.m19002a(this.f21222a.f21216a, new StringBuffer().append(new StringBuffer().append(this.f21223b).append("\n").toString()).append(this.f21224c).toString());
                return true;
            }
        });
        return view;
    }

    /* compiled from: SmaliHelpAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.m$a */
    private class a {

        /* renamed from: a */
        public CheckBox f21225a;

        /* renamed from: b */
        public TextView f21226b;

        /* renamed from: c */
        public TextView f21227c;

        /* renamed from: d */
        private final C3311m f21228d;

        public a(C3311m c3311m) {
            this.f21228d = c3311m;
        }
    }
}
