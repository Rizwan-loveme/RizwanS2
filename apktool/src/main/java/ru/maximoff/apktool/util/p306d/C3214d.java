package ru.maximoff.apktool.util.p306d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p296a.C2887g;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3068ac;
import ru.maximoff.apktool.util.C3072ad;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3082an;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3264w;
import ru.maximoff.apktool.util.C3267z;
import ru.maximoff.apktool.util.p306d.C3215e;
import ru.maximoff.apktool.view.C3299a;
import ru.maximoff.apktool.view.C3302d;

/* compiled from: SearchResultExp.java */
/* renamed from: ru.maximoff.apktool.util.d.d */
/* loaded from: classes.dex */
public class C3214d extends C3299a {

    /* renamed from: a */
    private b f19165a;

    /* renamed from: b */
    private List<C3213c> f19166b;

    /* renamed from: c */
    private Context f19167c;

    /* renamed from: d */
    private InterfaceC2995n f19168d;

    /* renamed from: e */
    private DialogInterfaceC0070b f19169e;

    /* renamed from: f */
    private boolean f19170f;

    /* renamed from: g */
    private String f19171g;

    /* renamed from: h */
    private C3066aa f19172h;

    /* renamed from: i */
    private C3264w f19173i;

    /* renamed from: j */
    private boolean f19174j;

    /* renamed from: k */
    private boolean f19175k;

    /* renamed from: l */
    private boolean f19176l;

    /* renamed from: m */
    private boolean f19177m;

    public C3214d(Context context, InterfaceC2995n interfaceC2995n, String str) {
        super(context);
        this.f19165a = (b) null;
        this.f19166b = (List) null;
        this.f19176l = false;
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        setGroupIndicator((Drawable) null);
        setChildIndicator((Drawable) null);
        this.f19167c = context;
        this.f19168d = interfaceC2995n;
        this.f19170f = true;
        this.f19171g = str;
        this.f19174j = true;
        this.f19175k = false;
        this.f19177m = C3102bd.m18925a(this.f19167c, "old_search_res", false);
        this.f19172h = new C3066aa(this.f19167c);
        this.f19173i = new C3264w(this.f19167c, interfaceC2995n);
        this.f19166b = new ArrayList();
        this.f19165a = new b(this, this.f19166b);
        setAdapter(this.f19165a);
    }

    @Override // android.widget.ExpandableListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    /* renamed from: a */
    public void m19236a(boolean z) {
        this.f19174j = z;
    }

    public void setType(boolean z) {
        this.f19170f = z;
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f19169e = dialogInterfaceC0070b;
    }

    /* renamed from: a */
    public void m19235a(List<C3213c> list) {
        this.f19165a.m19243a(list);
    }

    /* renamed from: b */
    public void m19238b(boolean z) {
        this.f19175k = z;
    }

    /* renamed from: a */
    public void m19233a() {
        if (!this.f19177m) {
            List<C3213c> m19242a = this.f19165a.m19242a();
            for (int i = 0; i < m19242a.size(); i++) {
                C3213c c3213c = m19242a.get(i);
                if (this.f19176l) {
                    c3213c.f19161a = false;
                    collapseGroup(i);
                } else {
                    c3213c.f19161a = true;
                    expandGroup(i);
                }
            }
            this.f19176l = this.f19176l ? false : true;
        }
    }

    /* renamed from: b */
    public void m19237b() {
        if (!this.f19177m) {
            List<C3213c> m19242a = this.f19165a.m19242a();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < m19242a.size(); i3++) {
                if (m19242a.get(i3).f19161a) {
                    expandGroup(i3);
                    i2++;
                } else {
                    collapseGroup(i3);
                    i++;
                }
            }
            this.f19176l = i2 > i;
        }
    }

    /* renamed from: c */
    public void m19239c() {
        this.f19165a.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m19234a(long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.util.d.d.1

            /* renamed from: a */
            private final C3214d f19178a;

            {
                this.f19178a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19178a.f19165a.notifyDataSetChanged();
            }
        }, j);
    }

    /* compiled from: SearchResultExp.java */
    /* renamed from: ru.maximoff.apktool.util.d.d$b */
    private class b extends BaseExpandableListAdapter implements AbsListView.OnScrollListener, SectionIndexer {

        /* renamed from: a */
        private MainActivity f19181a = MainActivity.m16615o();

        /* renamed from: b */
        private List<C3213c> f19182b;

        /* renamed from: c */
        private int f19183c;

        /* renamed from: d */
        private int f19184d;

        /* renamed from: e */
        private int f19185e;

        /* renamed from: f */
        private int f19186f;

        /* renamed from: g */
        private int f19187g;

        /* renamed from: h */
        private boolean f19188h;

        /* renamed from: i */
        private boolean f19189i;

        /* renamed from: j */
        private final C3214d f19190j;

        /* renamed from: b */
        static C3214d m19241b(b bVar) {
            return bVar.f19190j;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public b(C3214d c3214d, List<C3213c> list) {
            this.f19190j = c3214d;
            this.f19182b = new ArrayList();
            this.f19183c = C3246h.m19470a(this.f19190j.f19167c, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
            this.f19184d = C3246h.m19470a(this.f19190j.f19167c, C3102bd.f18291a ? R.color.accent_material_light : R.color.accent_material);
            this.f19185e = C3246h.m19470a(this.f19190j.f19167c, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey);
            this.f19186f = C3102bd.f18291a ? R.drawable.border : R.drawable.border_dark;
            this.f19182b = list;
            this.f19187g = C3080al.m18574b(this.f19190j.f19167c, 10);
            this.f19189i = C3102bd.m18925a(this.f19190j.f19167c, "search_hlcolors", true);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f19188h = i == 1;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int i) {
            return this.f19188h ? i : this.f19190j.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i));
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int i) {
            return ExpandableListView.getPackedPositionGroup(this.f19190j.getExpandableListPosition(i));
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return (Object[]) null;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return this.f19182b.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i) {
            return this.f19182b.get(i).m19215a();
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i) {
            return this.f19182b.get(i);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i, int i2) {
            return this.f19182b.get(i).m19216a(i2);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i) {
            return i * 17;
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i, int i2) {
            return i2 * 17;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        /* renamed from: a */
        public void m19243a(List<C3213c> list) {
            this.f19182b.addAll(list);
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public List<C3213c> m19242a() {
            return this.f19182b;
        }

        @Override // android.widget.BaseExpandableListAdapter
        public void notifyDataSetChanged() {
            this.f19189i = C3102bd.m18925a(this.f19190j.f19167c, "search_hlcolors", true);
            super.notifyDataSetChanged();
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            C3302d c3302d;
            if (view == null) {
                view = ((LayoutInflater) this.f19190j.f19167c.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                C3302d c3302d2 = new C3302d();
                c3302d2.f20965b = view.findViewById(R.id.border);
                c3302d2.f20967d = (ImageView) view.findViewById(R.id.icon);
                c3302d2.f20966c = (ProgressBar) view.findViewById(R.id.progress);
                c3302d2.f20968e = (TextView) view.findViewById(R.id.name);
                c3302d2.f20969f = (TextView) view.findViewById(R.id.details);
                view.setTag(c3302d2);
                c3302d = c3302d2;
            } else {
                c3302d = (C3302d) view.getTag();
            }
            c3302d.f20964a = i;
            c3302d.f20967d.setVisibility(0);
            c3302d.f20966c.setVisibility(8);
            C3213c c3213c = this.f19182b.get(i);
            if (c3213c != null && !C3112bn.m19040o(c3213c.m19220c())) {
                File file = new File(c3213c.m19220c());
                if (C2978b.f16135a.m17697a(file)) {
                    view.setBackgroundColor(this.f19185e);
                } else {
                    view.setBackgroundColor(0);
                }
                if (C3082an.f18011a.m18649b(file.getAbsolutePath())) {
                    c3302d.f20965b.setVisibility(0);
                } else {
                    c3302d.f20965b.setVisibility(8);
                }
                c3302d.f20969f.setTextSize(2, C3102bd.m18927b());
                c3302d.f20968e.setTextSize(2, C3102bd.f18332o);
                c3302d.f20967d.setTag(c3213c);
                if (file.exists()) {
                    c3302d.f20968e.setText(file.getName());
                    c3302d.f20969f.setText(file.getParent());
                } else {
                    SpannableString spannableString = new SpannableString(file.getParent());
                    spannableString.setSpan(new StrikethroughSpan(), 0, file.getParent().length(), 33);
                    c3302d.f20969f.setText(spannableString);
                    SpannableString spannableString2 = new SpannableString(file.getName());
                    spannableString2.setSpan(new StrikethroughSpan(), 0, file.getName().length(), 33);
                    c3302d.f20968e.setText(spannableString2);
                }
                if (file.isDirectory()) {
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f19190j.f19172h, this.f19183c, R.drawable.ic_folder));
                } else {
                    String lowerCase = file.getName().toLowerCase();
                    int[] m18400a = C3068ac.m18400a(this.f19190j.f19167c, lowerCase);
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f19190j.f19172h, m18400a[1], m18400a[0]));
                    if (C3072ad.m18430a(lowerCase) || m18400a[0] == R.drawable.ic_image) {
                        C2919au.m17340a(file, new C2919au.a(this, new AsyncTaskC2954y(this.f19190j.f19167c, c3302d.f20967d, this.f19190j.f19168d)) { // from class: ru.maximoff.apktool.util.d.d.b.1

                            /* renamed from: a */
                            private final b f19191a;

                            /* renamed from: b */
                            private final AsyncTaskC2954y f19192b;

                            {
                                this.f19191a = this;
                                this.f19192b = r2;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2919au.a
                            /* renamed from: a */
                            public AsyncTaskC2954y mo17349a() {
                                return this.f19192b;
                            }
                        });
                    }
                }
                view.setOnClickListener(new AnonymousClass2(this, c3213c, file, z, i));
                view.setOnLongClickListener(new View.OnLongClickListener(this, file) { // from class: ru.maximoff.apktool.util.d.d.b.3

                    /* renamed from: a */
                    private final b f19203a;

                    /* renamed from: b */
                    private final File f19204b;

                    {
                        this.f19203a = this;
                        this.f19204b = file;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        b.m19241b(this.f19203a).f19168d.mo17934a(this.f19204b.getParentFile());
                        b.m19241b(this.f19203a).f19168d.mo17938a(this.f19204b.getAbsolutePath());
                        b.m19241b(this.f19203a).f19168d.mo17944c(this.f19204b.getAbsolutePath());
                        b.m19241b(this.f19203a).f19169e.cancel();
                        return true;
                    }
                });
            }
            return view;
        }

        /* compiled from: SearchResultExp.java */
        /* renamed from: ru.maximoff.apktool.util.d.d$b$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final b f19193a;

            /* renamed from: b */
            private final C3213c f19194b;

            /* renamed from: c */
            private final File f19195c;

            /* renamed from: d */
            private final boolean f19196d;

            /* renamed from: e */
            private final int f19197e;

            AnonymousClass2(b bVar, C3213c c3213c, File file, boolean z, int i) {
                this.f19193a = bVar;
                this.f19194b = c3213c;
                this.f19195c = file;
                this.f19196d = z;
                this.f19197e = i;
            }

            /* renamed from: a */
            static b m19244a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f19193a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.m19241b(this.f19193a).f19177m || this.f19194b.m19222e()) {
                    if (this.f19195c.isDirectory()) {
                        b.m19241b(this.f19193a).f19168d.mo17934a(this.f19195c);
                        b.m19241b(this.f19193a).f19169e.cancel();
                        return;
                    }
                    b.m19241b(this.f19193a).f19173i.m19685a(this.f19195c);
                    String str = C3262u.m19641b(this.f19195c.getName())[1];
                    if ((C3262u.m19673k(b.m19241b(this.f19193a).f19167c, this.f19195c) || C2887g.m16904a(str) || str.equals("mtd") || str.equals("amd")) && !C3102bd.m18925a(b.m19241b(this.f19193a).f19167c, "ext_editor", false)) {
                        if (!this.f19194b.m19222e()) {
                            if (this.f19193a.f19181a != null) {
                                b.m19241b(this.f19193a).f19169e.hide();
                                this.f19193a.f19181a.m16621a(b.m19241b(this.f19193a).f19169e);
                            } else {
                                b.m19241b(this.f19193a).f19169e.cancel();
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f19194b, this.f19195c) { // from class: ru.maximoff.apktool.util.d.d.b.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f19198a;

                                /* renamed from: b */
                                private final C3213c f19199b;

                                /* renamed from: c */
                                private final File f19200c;

                                {
                                    this.f19198a = this;
                                    this.f19199b = r2;
                                    this.f19200c = r3;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    b.m19241b(AnonymousClass2.m19244a(this.f19198a)).f19168d.mo17940b().m17822a(this.f19200c, this.f19199b.m19216a(0).f19216a, r0.f19217b - 1);
                                    if (b.m19241b(AnonymousClass2.m19244a(this.f19198a)).f19174j) {
                                        C2978b.f16135a.m17707d().m17641a((CharSequence) b.m19241b(AnonymousClass2.m19244a(this.f19198a)).f19171g, false, b.m19241b(AnonymousClass2.m19244a(this.f19198a)).f19175k);
                                    }
                                    b.m19241b(AnonymousClass2.m19244a(this.f19198a)).f19168d.mo17929a();
                                    AnonymousClass2.m19244a(this.f19198a).notifyDataSetChanged();
                                }
                            }, 100L);
                            return;
                        }
                        if (this.f19193a.f19181a != null) {
                            b.m19241b(this.f19193a).f19169e.hide();
                            this.f19193a.f19181a.m16621a(b.m19241b(this.f19193a).f19169e);
                        } else {
                            b.m19241b(this.f19193a).f19169e.cancel();
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f19195c) { // from class: ru.maximoff.apktool.util.d.d.b.2.2

                            /* renamed from: a */
                            private final AnonymousClass2 f19201a;

                            /* renamed from: b */
                            private final File f19202b;

                            {
                                this.f19201a = this;
                                this.f19202b = r2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                b.m19241b(AnonymousClass2.m19244a(this.f19201a)).f19168d.mo17940b().m17821a(this.f19202b);
                                b.m19241b(AnonymousClass2.m19244a(this.f19201a)).f19168d.mo17929a();
                                AnonymousClass2.m19244a(this.f19201a).notifyDataSetChanged();
                            }
                        }, 100L);
                        return;
                    }
                    C3262u.m19608a(this.f19195c, view, b.m19241b(this.f19193a).f19168d);
                    return;
                }
                if (this.f19196d) {
                    this.f19194b.f19161a = false;
                    b.m19241b(this.f19193a).collapseGroup(this.f19197e);
                } else {
                    this.f19194b.f19161a = true;
                    b.m19241b(this.f19193a).expandGroup(this.f19197e);
                }
            }
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.f19190j.f19167c.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.search_child, (ViewGroup) null);
                aVar = new a(this.f19190j);
                aVar.f19179a = (TextView) view.findViewById(R.id.childText);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f19179a.setTextSize(2, C3102bd.f18332o - 2);
            aVar.f19179a.setBackgroundResource(this.f19186f);
            C3213c c3213c = this.f19182b.get(i);
            File file = new File(c3213c.m19220c());
            C3215e.a m19216a = c3213c.m19216a(i2);
            String str = "";
            if (m19216a.f19220e != -1) {
                str = new StringBuffer().append(String.valueOf(m19216a.f19220e)).append(". ").toString();
            }
            SpannableString spannableString = new SpannableString(new StringBuffer().append(str).append(m19216a.f19221f).toString());
            if (this.f19189i) {
                spannableString = C3112bn.m18987a(spannableString);
            }
            spannableString.setSpan(new BackgroundColorSpan(this.f19184d), m19216a.f19218c + str.length(), m19216a.f19218c + m19216a.f19219d + str.length(), 33);
            if (m19216a.f19220e != -1) {
                spannableString.setSpan(new StyleSpan(1), 0, str.length() - 1, 33);
            }
            if (!file.exists()) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            aVar.f19179a.setText(spannableString);
            if (m19216a.f19222g) {
                view.setBackgroundColor(this.f19185e);
            } else {
                view.setBackgroundColor(0);
            }
            view.setOnClickListener(new AnonymousClass4(this, file, m19216a, c3213c));
            return view;
        }

        /* compiled from: SearchResultExp.java */
        /* renamed from: ru.maximoff.apktool.util.d.d$b$4, reason: invalid class name */
        class AnonymousClass4 implements View.OnClickListener {

            /* renamed from: a */
            private final b f19205a;

            /* renamed from: b */
            private final File f19206b;

            /* renamed from: c */
            private final C3215e.a f19207c;

            /* renamed from: d */
            private final C3213c f19208d;

            AnonymousClass4(b bVar, File file, C3215e.a aVar, C3213c c3213c) {
                this.f19205a = bVar;
                this.f19206b = file;
                this.f19207c = aVar;
                this.f19208d = c3213c;
            }

            /* renamed from: a */
            static b m19245a(AnonymousClass4 anonymousClass4) {
                return anonymousClass4.f19205a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.m19241b(this.f19205a).f19173i.m19685a(this.f19206b);
                this.f19207c.f19222g = true;
                String str = C3262u.m19641b(this.f19206b.getName())[1];
                if ((C3262u.m19673k(b.m19241b(this.f19205a).f19167c, this.f19206b) || C2887g.m16904a(str) || str.equals("mtd") || str.equals("amd")) && !C3102bd.m18925a(b.m19241b(this.f19205a).f19167c, "ext_editor", false)) {
                    if (!this.f19208d.m19222e()) {
                        if (this.f19205a.f19181a != null) {
                            b.m19241b(this.f19205a).f19169e.hide();
                            this.f19205a.f19181a.m16621a(b.m19241b(this.f19205a).f19169e);
                        } else {
                            b.m19241b(this.f19205a).f19169e.cancel();
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f19206b, this.f19207c) { // from class: ru.maximoff.apktool.util.d.d.b.4.1

                            /* renamed from: a */
                            private final AnonymousClass4 f19209a;

                            /* renamed from: b */
                            private final File f19210b;

                            /* renamed from: c */
                            private final C3215e.a f19211c;

                            {
                                this.f19209a = this;
                                this.f19210b = r2;
                                this.f19211c = r3;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                b.m19241b(AnonymousClass4.m19245a(this.f19209a)).f19168d.mo17940b().m17822a(this.f19210b, this.f19211c.f19216a, this.f19211c.f19217b - 1);
                                if (b.m19241b(AnonymousClass4.m19245a(this.f19209a)).f19174j) {
                                    C2978b.f16135a.m17707d().m17641a((CharSequence) b.m19241b(AnonymousClass4.m19245a(this.f19209a)).f19171g, false, b.m19241b(AnonymousClass4.m19245a(this.f19209a)).f19175k);
                                }
                                b.m19241b(AnonymousClass4.m19245a(this.f19209a)).f19168d.mo17929a();
                                AnonymousClass4.m19245a(this.f19209a).notifyDataSetChanged();
                            }
                        }, 100L);
                        return;
                    }
                    if (this.f19205a.f19181a != null) {
                        b.m19241b(this.f19205a).f19169e.hide();
                        this.f19205a.f19181a.m16621a(b.m19241b(this.f19205a).f19169e);
                    } else {
                        b.m19241b(this.f19205a).f19169e.cancel();
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f19206b) { // from class: ru.maximoff.apktool.util.d.d.b.4.2

                        /* renamed from: a */
                        private final AnonymousClass4 f19212a;

                        /* renamed from: b */
                        private final File f19213b;

                        {
                            this.f19212a = this;
                            this.f19213b = r2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            b.m19241b(AnonymousClass4.m19245a(this.f19212a)).f19168d.mo17940b().m17821a(this.f19213b);
                            b.m19241b(AnonymousClass4.m19245a(this.f19212a)).f19168d.mo17929a();
                            AnonymousClass4.m19245a(this.f19212a).notifyDataSetChanged();
                        }
                    }, 100L);
                    return;
                }
                C3262u.m19608a(this.f19206b, view, b.m19241b(this.f19205a).f19168d);
            }
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i, int i2) {
            return true;
        }
    }

    /* compiled from: SearchResultExp.java */
    /* renamed from: ru.maximoff.apktool.util.d.d$a */
    private class a {

        /* renamed from: a */
        public TextView f19179a;

        /* renamed from: b */
        private final C3214d f19180b;

        public a(C3214d c3214d) {
            this.f19180b = c3214d;
        }
    }
}
