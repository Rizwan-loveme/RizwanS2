package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: ListAdapter.java */
/* renamed from: ru.maximoff.apktool.util.f.h */
/* loaded from: classes.dex */
public class C3228h extends BaseAdapter {

    /* renamed from: a */
    private Context f19347a;

    /* renamed from: b */
    private Button f19348b = (Button) null;

    /* renamed from: c */
    private List<C3236p> f19349c = new ArrayList();

    /* renamed from: d */
    private List<Integer> f19350d = new ArrayList();

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return m19341a(i);
    }

    public C3228h(Context context, List<C3236p> list) {
        this.f19347a = context;
        this.f19349c.clear();
        this.f19349c.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19349c.size();
    }

    /* renamed from: a */
    public C3236p m19341a(int i) {
        return this.f19349c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0;
    }

    /* renamed from: a */
    public void m19343a(Button button) {
        this.f19348b = button;
    }

    /* renamed from: b */
    public void m19345b(int i) {
        if (this.f19350d.contains(new Integer(i))) {
            this.f19350d.remove(new Integer(i));
        } else {
            this.f19350d.add(new Integer(i));
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m19342a() {
        for (int i = 0; i < this.f19349c.size(); i++) {
            m19345b(i);
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m19344b() {
        this.f19350d.clear();
        m19342a();
    }

    /* renamed from: c */
    public List<C3236p> m19346c() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f19350d.iterator();
        while (it.hasNext()) {
            arrayList.add(m19341a(it.next().intValue()));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (this.f19348b != null) {
            this.f19348b.setEnabled(!this.f19350d.isEmpty());
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        C3236p c3236p = this.f19349c.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f19347a).inflate(R.layout.cbx_item, (ViewGroup) null);
            a aVar2 = new a(this);
            aVar2.f19359a = i;
            aVar2.f19360b = (TextView) view.findViewById(R.id.header);
            aVar2.f19361c = (TextView) view.findViewById(R.id.subheader);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.f19350d.contains(new Integer(i))) {
            view.setBackgroundColor(C3246h.m19470a(this.f19347a, R.color.tvery_light_blue));
        } else {
            view.setBackgroundColor(0);
        }
        view.setMinimumHeight(0);
        aVar.f19360b.setTextSize(2, C3102bd.f18332o);
        aVar.f19361c.setTextSize(2, C3102bd.f18332o - 2);
        aVar.f19360b.setText(c3236p.m19381e());
        aVar.f19361c.setText(c3236p.m19386g());
        view.setOnClickListener(new View.OnClickListener(this, i) { // from class: ru.maximoff.apktool.util.f.h.1

            /* renamed from: a */
            private final C3228h f19351a;

            /* renamed from: b */
            private final int f19352b;

            {
                this.f19351a = this;
                this.f19352b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f19351a.m19345b(this.f19352b);
            }
        });
        view.setOnLongClickListener(new AnonymousClass2(this, c3236p));
        return view;
    }

    /* compiled from: ListAdapter.java */
    /* renamed from: ru.maximoff.apktool.util.f.h$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3228h f19353a;

        /* renamed from: b */
        private final C3236p f19354b;

        AnonymousClass2(C3228h c3228h, C3236p c3236p) {
            this.f19353a = c3228h;
            this.f19354b = c3236p;
        }

        /* renamed from: a */
        static C3228h m19347a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f19353a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int i;
            C0173ao c0173ao = new C0173ao(this.f19353a.f19347a, view);
            if (C3102bd.m18910a(this.f19353a.f19347a, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            c0173ao.m1339a().add(0, 1910, 0, this.f19353a.f19347a.getString(R.string.cp_name)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19354b) { // from class: ru.maximoff.apktool.util.f.h.2.1

                /* renamed from: a */
                private final AnonymousClass2 f19355a;

                /* renamed from: b */
                private final C3236p f19356b;

                {
                    this.f19355a = this;
                    this.f19356b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass2.m19347a(this.f19355a).f19347a, this.f19356b.m19381e());
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 1911, 0, this.f19353a.f19347a.getString(R.string.copy)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19354b) { // from class: ru.maximoff.apktool.util.f.h.2.2

                /* renamed from: a */
                private final AnonymousClass2 f19357a;

                /* renamed from: b */
                private final C3236p f19358b;

                {
                    this.f19357a = this;
                    this.f19358b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass2.m19347a(this.f19357a).f19347a, this.f19358b.m19386g());
                    return true;
                }
            });
            c0173ao.m1344c();
            return true;
        }
    }

    /* compiled from: ListAdapter.java */
    /* renamed from: ru.maximoff.apktool.util.f.h$a */
    private class a {

        /* renamed from: a */
        public int f19359a;

        /* renamed from: b */
        public TextView f19360b;

        /* renamed from: c */
        public TextView f19361c;

        /* renamed from: d */
        private final C3228h f19362d;

        public a(C3228h c3228h) {
            this.f19362d = c3228h;
        }
    }
}
