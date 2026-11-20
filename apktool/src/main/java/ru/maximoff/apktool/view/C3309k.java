package ru.maximoff.apktool.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: PermAdapter.java */
/* renamed from: ru.maximoff.apktool.view.k */
/* loaded from: classes.dex */
public class C3309k extends BaseAdapter {

    /* renamed from: a */
    private final Context f21125a;

    /* renamed from: b */
    private final List<String> f21126b;

    /* renamed from: e */
    private final boolean f21129e;

    /* renamed from: f */
    private final String f21130f = "disabled_";

    /* renamed from: c */
    private List<String> f21127c = new ArrayList();

    /* renamed from: d */
    private List<Integer> f21128d = new ArrayList();

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return m19935a(i);
    }

    public C3309k(Context context, List<String> list, boolean z) {
        this.f21125a = context;
        this.f21126b = list;
        this.f21129e = z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (str.startsWith("disabled_")) {
                    str = str.substring(this.f21130f.length());
                }
                this.f21127c.add(C3080al.m18604i(this.f21125a, str));
                i = i2 + 1;
            } else {
                m19932c();
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f21128d != null) {
            return this.f21128d.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (i * 3) + 17;
    }

    /* renamed from: a */
    public String m19935a(int i) {
        if (this.f21128d == null) {
            return (String) null;
        }
        return this.f21126b != null ? this.f21126b.get(this.f21128d.get(i).intValue()) : (String) null;
    }

    /* renamed from: c */
    private void m19932c() {
        this.f21128d.clear();
        for (int i = 0; i < this.f21126b.size(); i++) {
            this.f21128d.add(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public void m19936a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f21128d.size()) {
                int intValue = this.f21128d.get(i2).intValue();
                String str = this.f21126b.get(intValue);
                if (str.startsWith("disabled_")) {
                    this.f21126b.set(intValue, str.substring(this.f21130f.length()));
                }
                i = i2 + 1;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: b */
    public void m19938b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f21128d.size()) {
                int intValue = this.f21128d.get(i2).intValue();
                String str = this.f21126b.get(intValue);
                if (str.startsWith("disabled_")) {
                    this.f21126b.set(intValue, str.substring(this.f21130f.length()));
                } else {
                    this.f21126b.set(intValue, new StringBuffer().append("disabled_").append(str).toString());
                }
                i = i2 + 1;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: a */
    public void m19937a(String str) {
        String lowerCase;
        if (C3112bn.m19040o(str.trim())) {
            m19932c();
        } else {
            this.f21128d.clear();
            String lowerCase2 = str.toLowerCase();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f21126b.size()) {
                    break;
                }
                String lowerCase3 = this.f21126b.get(i2).toLowerCase();
                String str2 = this.f21127c.get(i2);
                if (str2 == null) {
                    lowerCase = "";
                } else {
                    lowerCase = str2.toLowerCase();
                }
                if (lowerCase3.contains(lowerCase2) || lowerCase.contains(lowerCase2)) {
                    this.f21128d.add(Integer.valueOf(i2));
                }
                i = i2 + 1;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f21125a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.perm_entry, (ViewGroup) null);
            a aVar2 = new a(this);
            aVar2.f21144a = (CheckBox) view.findViewById(R.id.permentryCheckBox1);
            aVar2.f21145b = (TextView) view.findViewById(R.id.permentryTextView1);
            aVar2.f21146c = (TextView) view.findViewById(R.id.permentryTextView2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setMinimumHeight(0);
        int intValue = this.f21128d.get(i).intValue();
        String str = this.f21126b.get(intValue);
        if (str != null) {
            if (this.f21129e) {
                aVar.f21144a.setVisibility(0);
            } else {
                aVar.f21144a.setVisibility(8);
            }
            aVar.f21144a.setChecked(!str.startsWith("disabled_"));
            View.OnClickListener onClickListener = new View.OnClickListener(this, str, intValue) { // from class: ru.maximoff.apktool.view.k.1

                /* renamed from: a */
                private final C3309k f21131a;

                /* renamed from: b */
                private final String f21132b;

                /* renamed from: c */
                private final int f21133c;

                {
                    this.f21131a = this;
                    this.f21132b = str;
                    this.f21133c = intValue;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!this.f21131a.f21129e) {
                        view2.performLongClick();
                        return;
                    }
                    if (this.f21132b.startsWith("disabled_")) {
                        this.f21131a.f21126b.set(this.f21133c, this.f21132b.substring(this.f21131a.f21130f.length()));
                    } else {
                        this.f21131a.f21126b.set(this.f21133c, new StringBuffer().append("disabled_").append(this.f21132b).toString());
                    }
                    this.f21131a.notifyDataSetChanged();
                }
            };
            String str2 = this.f21127c.get(intValue);
            if (str.startsWith("disabled_")) {
                String substring = str.substring(this.f21130f.length());
                SpannableString spannableString = new SpannableString(substring);
                spannableString.setSpan(new StrikethroughSpan(), 0, substring.length(), 33);
                aVar.f21145b.setText(spannableString);
                if (str2 != null) {
                    aVar.f21146c.setVisibility(0);
                    SpannableString spannableString2 = new SpannableString(str2);
                    spannableString2.setSpan(new StrikethroughSpan(), 0, str2.length(), 33);
                    aVar.f21146c.setText(spannableString2);
                } else {
                    aVar.f21146c.setVisibility(8);
                }
            } else {
                aVar.f21145b.setText(str);
                if (str2 != null) {
                    aVar.f21146c.setVisibility(0);
                    aVar.f21146c.setText(str2);
                } else {
                    aVar.f21146c.setVisibility(8);
                }
            }
            aVar.f21145b.setTextSize(2, C3102bd.f18332o);
            aVar.f21146c.setTextSize(2, C3102bd.f18332o - 2);
            aVar.f21144a.setOnClickListener(onClickListener);
            view.setOnClickListener(onClickListener);
            view.setOnLongClickListener(new AnonymousClass2(this, str));
        }
        return view;
    }

    /* compiled from: PermAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.k$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3309k f21134a;

        /* renamed from: b */
        private final String f21135b;

        AnonymousClass2(C3309k c3309k, String str) {
            this.f21134a = c3309k;
            this.f21135b = str;
        }

        /* renamed from: a */
        static C3309k m19939a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f21134a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int i;
            String substring = this.f21135b.startsWith("disabled_") ? this.f21135b.substring(this.f21134a.f21130f.length()) : this.f21135b;
            C0173ao c0173ao = new C0173ao(this.f21134a.f21125a, view);
            if (C3102bd.m18910a(this.f21134a.f21125a, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            c0173ao.m1339a().add(0, 1001, 0, this.f21134a.f21125a.getString(R.string.copy)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, substring) { // from class: ru.maximoff.apktool.view.k.2.1

                /* renamed from: a */
                private final AnonymousClass2 f21136a;

                /* renamed from: b */
                private final String f21137b;

                {
                    this.f21136a = this;
                    this.f21137b = substring;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass2.m19939a(this.f21136a).f21125a, new StringBuffer().append(new StringBuffer().append("<uses-permission android:name=\"").append(this.f21137b).toString()).append("\" />").toString());
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 1002, 0, this.f21134a.f21125a.getString(R.string.cp_name)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, substring) { // from class: ru.maximoff.apktool.view.k.2.2

                /* renamed from: a */
                private final AnonymousClass2 f21138a;

                /* renamed from: b */
                private final String f21139b;

                {
                    this.f21138a = this;
                    this.f21139b = substring;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass2.m19939a(this.f21138a).f21125a, this.f21139b);
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 1003, 0, this.f21134a.f21125a.getString(R.string.mtr_yandex)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, substring) { // from class: ru.maximoff.apktool.view.k.2.3

                /* renamed from: a */
                private final AnonymousClass2 f21140a;

                /* renamed from: b */
                private final String f21141b;

                {
                    this.f21140a = this;
                    this.f21141b = substring;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    String str;
                    if (C3102bd.f18267C.equals("ru")) {
                        str = "ru";
                    } else {
                        str = "com";
                    }
                    C3080al.m18595e(AnonymousClass2.m19939a(this.f21140a).f21125a, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("https://yandex.").append(str).toString()).append("/search/?text=").toString()).append(this.f21141b).toString());
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 1004, 0, this.f21134a.f21125a.getString(R.string.mtr_google)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, substring) { // from class: ru.maximoff.apktool.view.k.2.4

                /* renamed from: a */
                private final AnonymousClass2 f21142a;

                /* renamed from: b */
                private final String f21143b;

                {
                    this.f21142a = this;
                    this.f21143b = substring;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3080al.m18595e(AnonymousClass2.m19939a(this.f21142a).f21125a, new StringBuffer().append("https://www.google.com/search?q=").append(this.f21143b).toString());
                    return true;
                }
            });
            c0173ao.m1344c();
            return true;
        }
    }

    /* compiled from: PermAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.k$a */
    private class a {

        /* renamed from: a */
        public CheckBox f21144a;

        /* renamed from: b */
        public TextView f21145b;

        /* renamed from: c */
        public TextView f21146c;

        /* renamed from: d */
        private final C3309k f21147d;

        public a(C3309k c3309k) {
            this.f21147d = c3309k;
        }
    }
}
