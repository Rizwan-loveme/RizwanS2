package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: TreeListAdapter.java */
/* renamed from: ru.maximoff.apktool.view.q */
/* loaded from: classes.dex */
public class C3315q<T> extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private final List<C3316r<T>> f21268a;

    /* renamed from: b */
    private final Context f21269b;

    /* renamed from: c */
    private InterfaceC3314p<T> f21270c;

    /* renamed from: d */
    private final C3316r<T> f21271d;

    /* renamed from: e */
    private final float f21272e;

    /* renamed from: f */
    private int f21273f = 0;

    /* renamed from: g */
    private Typeface f21274g;

    public C3315q(Context context) {
        this.f21269b = context;
        try {
            this.f21274g = Typeface.createFromAsset(context.getAssets(), "icofont.ttf");
        } catch (Exception e2) {
            this.f21274g = Typeface.DEFAULT;
        }
        this.f21272e = C3080al.m18574b(context, 32);
        this.f21268a = new LinkedList();
        this.f21271d = new C3316r<>(-1, this);
    }

    /* renamed from: a */
    public void m20043a(InterfaceC3314p<T> interfaceC3314p) {
        this.f21270c = interfaceC3314p;
        interfaceC3314p.mo17893a((BaseAdapter) this);
        this.f21271d.m20047a((C3316r<T>) interfaceC3314p.mo17900l(), (InterfaceC3314p<C3316r<T>>) interfaceC3314p);
        m20042a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f21268a.get(i).m20049a(this.f21270c, view);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.f21271d.m20047a((C3316r<T>) this.f21270c.mo17900l(), (InterfaceC3314p<C3316r<T>>) this.f21270c);
        m20042a();
    }

    /* renamed from: a */
    public void m20042a() {
        this.f21268a.clear();
        this.f21271d.m20048a((List) this.f21268a, (InterfaceC3314p) this.f21270c);
        int i = 0;
        Iterator<C3316r<T>> it = this.f21268a.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().m20050b());
        }
        this.f21273f = i;
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21268a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f21268a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        C3316r<T> c3316r = this.f21268a.get(i);
        T m20045a = c3316r.m20045a();
        if (view == null) {
            view = LayoutInflater.from(this.f21269b).inflate(R.layout.files_entry, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.f21277c = (TextView) view.findViewById(R.id.name);
            aVar2.f21278d = (TextView) view.findViewById(R.id.details);
            aVar2.f21276b = (ImageView) view.findViewById(R.id.icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f21275a = i;
        aVar.f21278d.setTypeface(this.f21274g);
        aVar.f21277c.setTextSize(2, C3102bd.f18332o);
        aVar.f21278d.setTextSize(2, C3102bd.m18927b());
        c3316r.m20046a(aVar.f21276b, this.f21270c, i);
        view.setPadding((int) (c3316r.m20050b() * this.f21272e), 0, 0, 0);
        this.f21270c.mo17894a(aVar.f21277c, aVar.f21278d, aVar.f21276b, m20045a);
        return view;
    }

    /* compiled from: TreeListAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.q$a */
    private class a {

        /* renamed from: a */
        public int f21275a;

        /* renamed from: b */
        public ImageView f21276b;

        /* renamed from: c */
        public TextView f21277c;

        /* renamed from: d */
        public TextView f21278d;

        /* renamed from: e */
        private final C3315q f21279e;

        public a(C3315q c3315q) {
            this.f21279e = c3315q;
        }
    }
}
