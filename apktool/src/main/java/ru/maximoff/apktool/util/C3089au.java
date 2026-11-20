package ru.maximoff.apktool.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.C0170al;
import androidx.appcompat.widget.C0173ao;
import androidx.p044h.p045a.AbstractC0405a;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.fragment.p301a.C2978b;

/* compiled from: PopupUtils.java */
/* renamed from: ru.maximoff.apktool.util.au */
/* loaded from: classes.dex */
public class C3089au {

    /* compiled from: PopupUtils.java */
    /* renamed from: ru.maximoff.apktool.util.au$a */
    public interface a {
        /* renamed from: a */
        void mo17670a(Context context, int i);
    }

    /* compiled from: PopupUtils.java */
    /* renamed from: ru.maximoff.apktool.util.au$c */
    private static class c {

        /* renamed from: a */
        public int f18116a;

        /* renamed from: b */
        public TextView f18117b;

        /* renamed from: c */
        public TextView f18118c;

        /* renamed from: d */
        public TextView f18119d;
    }

    /* renamed from: a */
    public static Menu m18715a(View view, int i, a aVar) {
        Context context = view.getContext();
        C0173ao c0173ao = new C0173ao(context, view);
        c0173ao.m1343b(i);
        return m18716a(c0173ao, context, aVar);
    }

    /* renamed from: a */
    public static void m18717a(View view, AbstractC0405a abstractC0405a, a aVar, a aVar2) {
        if (abstractC0405a.mo3270a() != 0) {
            Context context = view.getContext();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < abstractC0405a.mo3270a(); i++) {
                arrayList.add(abstractC0405a.mo3272a(i).toString());
            }
            int currentItem = C2978b.f16135a.m17709e().getCurrentItem();
            C0170al c0170al = new C0170al(context);
            b bVar = new b(context, c0170al, arrayList, view, abstractC0405a, aVar, aVar2);
            c0170al.m1320b(view);
            c0170al.m1325f(3);
            c0170al.mo1314a(bVar);
            c0170al.m1327h(-1);
            c0170al.m1326g(-1);
            c0170al.m1316a(true);
            c0170al.mo841b_();
            c0170al.mo846e().post(new Runnable(c0170al, currentItem) { // from class: ru.maximoff.apktool.util.au.1

                /* renamed from: a */
                private final C0170al f18096a;

                /* renamed from: b */
                private final int f18097b;

                {
                    this.f18096a = c0170al;
                    this.f18097b = currentItem;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f18096a.mo846e().setSelection(this.f18097b);
                }
            });
        }
    }

    /* renamed from: a */
    private static Menu m18716a(C0173ao c0173ao, Context context, a aVar) {
        int i;
        if (C3102bd.m18910a(context, "menu_position", "1").equals("0")) {
            i = 3;
        } else {
            i = 5;
        }
        c0173ao.m1340a(i);
        c0173ao.m1341a(new C0173ao.b(aVar, context) { // from class: ru.maximoff.apktool.util.au.2

            /* renamed from: a */
            private final a f18098a;

            /* renamed from: b */
            private final Context f18099b;

            {
                this.f18098a = aVar;
                this.f18099b = context;
            }

            @Override // androidx.appcompat.widget.C0173ao.b
            /* renamed from: a */
            public boolean mo1346a(MenuItem menuItem) {
                this.f18098a.mo17670a(this.f18099b, menuItem.getItemId());
                return true;
            }
        });
        c0173ao.m1344c();
        return c0173ao.m1339a();
    }

    /* compiled from: PopupUtils.java */
    /* renamed from: ru.maximoff.apktool.util.au$b */
    private static class b extends BaseAdapter {

        /* renamed from: a */
        private Context f18100a;

        /* renamed from: b */
        private C0170al f18101b;

        /* renamed from: c */
        private List<String> f18102c = new ArrayList();

        /* renamed from: d */
        private List<String> f18103d = new ArrayList();

        /* renamed from: e */
        private View f18104e;

        /* renamed from: f */
        private AbstractC0405a f18105f;

        /* renamed from: g */
        private a f18106g;

        /* renamed from: h */
        private a f18107h;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m18722a(i);
        }

        public b(Context context, C0170al c0170al, List<String> list, View view, AbstractC0405a abstractC0405a, a aVar, a aVar2) {
            this.f18100a = context;
            this.f18101b = c0170al;
            this.f18102c.clear();
            this.f18102c.addAll(list);
            this.f18103d.clear();
            this.f18103d.addAll(m18723a());
            this.f18104e = view;
            this.f18105f = abstractC0405a;
            this.f18106g = aVar;
            this.f18107h = aVar2;
        }

        /* renamed from: a */
        public List<String> m18723a() {
            String uri;
            if (this.f18102c.isEmpty()) {
                return (List) null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f18102c.size()) {
                    return arrayList;
                }
                Uri m17731q = C2978b.f16135a.m17731q(i2);
                if (m17731q == null) {
                    arrayList.add((String) null);
                } else {
                    if (m17731q.getScheme().equals(ContentResolver.SCHEME_FILE)) {
                        uri = new File(m17731q.getPath()).getParentFile().getAbsolutePath();
                    } else {
                        uri = m17731q.toString();
                    }
                    arrayList.add(uri);
                }
                i = i2 + 1;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f18102c != null) {
                return this.f18102c.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m18722a(int i) {
            return this.f18102c != null ? this.f18102c.get(i) : (String) null;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = ((LayoutInflater) this.f18100a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.history_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.f18117b = (TextView) view.findViewById(R.id.historyitemTextView1);
                cVar2.f18118c = (TextView) view.findViewById(R.id.historyitemTextView3);
                cVar2.f18119d = (TextView) view.findViewById(R.id.historyitemTextView2);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f18116a = i;
            String str = this.f18102c.get(i);
            if (str != null) {
                if (i == C2978b.f16135a.m17709e().getCurrentItem()) {
                    view.setBackgroundColor(C3246h.m19470a(this.f18100a, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
                } else {
                    view.setBackgroundColor(0);
                }
                View.OnClickListener onClickListener = new View.OnClickListener(this, i) { // from class: ru.maximoff.apktool.util.au.b.1

                    /* renamed from: a */
                    private final b f18108a;

                    /* renamed from: b */
                    private final int f18109b;

                    {
                        this.f18108a = this;
                        this.f18109b = i;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18108a.f18101b.mo842c();
                        this.f18108a.f18106g.mo17670a(this.f18108a.f18100a, this.f18109b);
                    }
                };
                String str2 = this.f18103d.get(i);
                if (str2 != null) {
                    cVar.f18118c.setVisibility(0);
                    cVar.f18118c.setTextSize(2, C3102bd.m18927b());
                    cVar.f18118c.setText(str2);
                    cVar.f18118c.setOnClickListener(onClickListener);
                    cVar.f18118c.setOnLongClickListener(new View.OnLongClickListener(this, str2) { // from class: ru.maximoff.apktool.util.au.b.2

                        /* renamed from: a */
                        private final b f18110a;

                        /* renamed from: b */
                        private final String f18111b;

                        {
                            this.f18110a = this;
                            this.f18111b = str2;
                        }

                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view2) {
                            C3112bn.m19002a(this.f18110a.f18100a, this.f18111b);
                            return true;
                        }
                    });
                } else {
                    cVar.f18118c.setVisibility(8);
                }
                cVar.f18117b.setTextSize(2, C3102bd.f18332o);
                cVar.f18117b.setText(str);
                cVar.f18119d.setTextSize(2, C3102bd.f18332o);
                cVar.f18117b.setOnClickListener(onClickListener);
                cVar.f18117b.setOnLongClickListener(new View.OnLongClickListener(this, str) { // from class: ru.maximoff.apktool.util.au.b.3

                    /* renamed from: a */
                    private final b f18112a;

                    /* renamed from: b */
                    private final String f18113b;

                    {
                        this.f18112a = this;
                        this.f18113b = str;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        if (C3102bd.m18925a(this.f18112a.f18100a, "copy_with_ext", false)) {
                            String[] m19641b = C3262u.m19641b(this.f18113b);
                            if (this.f18113b.toLowerCase().endsWith(".9.png")) {
                                C3112bn.m19002a(this.f18112a.f18100a, m19641b[0].substring(0, m19641b[0].length() - 2));
                                return true;
                            }
                            C3112bn.m19002a(this.f18112a.f18100a, m19641b[0]);
                            return true;
                        }
                        C3112bn.m19002a(this.f18112a.f18100a, this.f18113b);
                        return true;
                    }
                });
                cVar.f18119d.setOnClickListener(new View.OnClickListener(this, i) { // from class: ru.maximoff.apktool.util.au.b.4

                    /* renamed from: a */
                    private final b f18114a;

                    /* renamed from: b */
                    private final int f18115b;

                    {
                        this.f18114a = this;
                        this.f18115b = i;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18114a.f18101b.mo842c();
                        this.f18114a.f18107h.mo17670a(this.f18114a.f18100a, this.f18115b);
                    }
                });
            }
            return view;
        }
    }
}
