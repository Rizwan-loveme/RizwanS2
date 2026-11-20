package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.Collections;
import java.util.List;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p296a.C2887g;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.view.C3302d;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: FilesHistory.java */
/* renamed from: ru.maximoff.apktool.util.v */
/* loaded from: classes.dex */
public class C3263v extends CustomListView {

    /* renamed from: a */
    private a f20695a;

    /* renamed from: b */
    private C3264w f20696b;

    /* renamed from: c */
    private InterfaceC2995n f20697c;

    /* renamed from: d */
    private DialogInterfaceC0070b f20698d;

    /* renamed from: e */
    private C3066aa f20699e;

    /* renamed from: f */
    private Context f20700f;

    public C3263v(Context context, InterfaceC2995n interfaceC2995n, List<String> list) {
        super(context);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        Collections.reverse(list);
        this.f20700f = context;
        this.f20697c = interfaceC2995n;
        this.f20699e = new C3066aa(this.f20700f);
        this.f20695a = new a(this, list);
        setAdapter((ListAdapter) this.f20695a);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f20698d = dialogInterfaceC0070b;
        this.f20695a.notifyDataSetChanged();
    }

    public void setUtils(C3264w c3264w) {
        this.f20696b = c3264w;
    }

    /* compiled from: FilesHistory.java */
    /* renamed from: ru.maximoff.apktool.util.v$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private List<String> f20701a;

        /* renamed from: b */
        private int f20702b;

        /* renamed from: c */
        private final C3263v f20703c;

        /* renamed from: a */
        static C3263v m19680a(a aVar) {
            return aVar.f20703c;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m19681a(i);
        }

        public a(C3263v c3263v, List<String> list) {
            this.f20703c = c3263v;
            this.f20701a = (List) null;
            this.f20702b = C3246h.m19470a(this.f20703c.f20700f, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
            this.f20701a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f20701a != null) {
                return this.f20701a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m19681a(int i) {
            return this.f20701a != null ? this.f20701a.get(i) : (String) null;
        }

        /* renamed from: b */
        public void m19682b(int i) {
            this.f20703c.f20696b.m19688b(this.f20701a.get(i));
            this.f20701a.clear();
            List<String> m19687b = this.f20703c.f20696b.m19687b();
            Collections.reverse(m19687b);
            this.f20701a.addAll(m19687b);
            notifyDataSetChanged();
            if (this.f20701a.isEmpty() && this.f20703c.f20698d != null && this.f20703c.f20698d.isShowing()) {
                try {
                    this.f20703c.f20698d.cancel();
                } catch (Exception e2) {
                }
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C3302d c3302d;
            if (view == null) {
                view = ((LayoutInflater) this.f20703c.f20700f.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                c3302d = new C3302d();
                c3302d.f20965b = view.findViewById(R.id.border);
                c3302d.f20967d = (ImageView) view.findViewById(R.id.icon);
                c3302d.f20966c = (ProgressBar) view.findViewById(R.id.progress);
                c3302d.f20968e = (TextView) view.findViewById(R.id.name);
                c3302d.f20969f = (TextView) view.findViewById(R.id.details);
                view.setTag(c3302d);
            } else {
                c3302d = (C3302d) view.getTag();
            }
            c3302d.f20964a = i;
            c3302d.f20967d.setVisibility(0);
            c3302d.f20966c.setVisibility(8);
            String str = this.f20701a.get(i);
            if (str != null && !C3112bn.m19040o(str)) {
                File file = new File(str);
                if (C2978b.f16135a.m17697a(file)) {
                    view.setBackgroundColor(C3246h.m19470a(this.f20703c.f20700f, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
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
                c3302d.f20967d.setTag(str);
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
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f20703c.f20699e, this.f20702b, R.drawable.ic_folder));
                } else {
                    String lowerCase = str.toLowerCase();
                    int[] m18400a = C3068ac.m18400a(this.f20703c.f20700f, lowerCase);
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f20703c.f20699e, m18400a[1], m18400a[0]));
                    if (C3072ad.m18430a(lowerCase) || m18400a[0] == R.drawable.ic_image) {
                        C2919au.m17340a(file, new C2919au.a(this, new AsyncTaskC2954y(this.f20703c.f20700f, c3302d.f20967d, this.f20703c.f20697c)) { // from class: ru.maximoff.apktool.util.v.a.1

                            /* renamed from: a */
                            private final a f20704a;

                            /* renamed from: b */
                            private final AsyncTaskC2954y f20705b;

                            {
                                this.f20704a = this;
                                this.f20705b = r2;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2919au.a
                            /* renamed from: a */
                            public AsyncTaskC2954y mo17349a() {
                                return this.f20705b;
                            }
                        });
                    }
                }
                view.setOnClickListener(new View.OnClickListener(this, file) { // from class: ru.maximoff.apktool.util.v.a.2

                    /* renamed from: a */
                    private final a f20706a;

                    /* renamed from: b */
                    private final File f20707b;

                    {
                        this.f20706a = this;
                        this.f20707b = file;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!this.f20707b.exists()) {
                            C3112bn.m18999a(a.m19680a(this.f20706a).f20700f, R.string.not_found);
                            return;
                        }
                        if (this.f20707b.isDirectory()) {
                            a.m19680a(this.f20706a).f20697c.mo17934a(this.f20707b);
                            a.m19680a(this.f20706a).f20698d.cancel();
                            return;
                        }
                        a.m19680a(this.f20706a).f20696b.m19685a(this.f20707b);
                        String str2 = C3262u.m19641b(this.f20707b.getName())[1];
                        if ((C3262u.m19673k(a.m19680a(this.f20706a).f20700f, this.f20707b) || C2887g.m16904a(str2) || str2.equals("mtd") || str2.equals("amd")) && !C3102bd.m18925a(a.m19680a(this.f20706a).f20700f, "ext_editor", false)) {
                            a.m19680a(this.f20706a).f20697c.mo17940b().m17821a(this.f20707b);
                            a.m19680a(this.f20706a).f20698d.cancel();
                        } else {
                            C3262u.m19608a(this.f20707b, view2, a.m19680a(this.f20706a).f20697c);
                        }
                    }
                });
                view.setOnLongClickListener(new AnonymousClass3(this, file, i));
            }
            return view;
        }

        /* compiled from: FilesHistory.java */
        /* renamed from: ru.maximoff.apktool.util.v$a$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnLongClickListener {

            /* renamed from: a */
            private final a f20708a;

            /* renamed from: b */
            private final File f20709b;

            /* renamed from: c */
            private final int f20710c;

            AnonymousClass3(a aVar, File file, int i) {
                this.f20708a = aVar;
                this.f20709b = file;
                this.f20710c = i;
            }

            /* renamed from: a */
            static a m19683a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f20708a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(a.m19680a(this.f20708a).f20700f, view);
                if (C3102bd.m18910a(a.m19680a(this.f20708a).f20700f, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.show).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20709b) { // from class: ru.maximoff.apktool.util.v.a.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f20711a;

                    /* renamed from: b */
                    private final File f20712b;

                    {
                        this.f20711a = this;
                        this.f20712b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        a.m19680a(AnonymousClass3.m19683a(this.f20711a)).f20697c.mo17934a(this.f20712b.getParentFile());
                        a.m19680a(AnonymousClass3.m19683a(this.f20711a)).f20697c.mo17938a(this.f20712b.getAbsolutePath());
                        a.m19680a(AnonymousClass3.m19683a(this.f20711a)).f20697c.mo17944c(this.f20712b.getAbsolutePath());
                        a.m19680a(AnonymousClass3.m19683a(this.f20711a)).f20698d.cancel();
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, R.string.delete).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20710c) { // from class: ru.maximoff.apktool.util.v.a.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f20713a;

                    /* renamed from: b */
                    private final int f20714b;

                    {
                        this.f20713a = this;
                        this.f20714b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass3.m19683a(this.f20713a).m19682b(this.f20714b);
                        a.m19680a(AnonymousClass3.m19683a(this.f20713a)).f20697c.mo17929a();
                        return true;
                    }
                });
                c0173ao.m1344c();
                return true;
            }
        }
    }
}
