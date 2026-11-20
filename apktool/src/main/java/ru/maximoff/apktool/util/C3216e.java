package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p296a.C2887g;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3220f;
import ru.maximoff.apktool.view.C3302d;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: Bookmarks.java */
/* renamed from: ru.maximoff.apktool.util.e */
/* loaded from: classes.dex */
public class C3216e extends CustomListView {

    /* renamed from: a */
    private a f19223a;

    /* renamed from: b */
    private C3220f f19224b;

    /* renamed from: c */
    private InterfaceC2995n f19225c;

    /* renamed from: d */
    private DialogInterfaceC0070b f19226d;

    /* renamed from: e */
    private C3066aa f19227e;

    /* renamed from: f */
    private C3264w f19228f;

    /* renamed from: g */
    private Context f19229g;

    public C3216e(Context context, InterfaceC2995n interfaceC2995n, C3220f c3220f) {
        super(context);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        this.f19229g = context;
        this.f19225c = interfaceC2995n;
        this.f19224b = c3220f;
        this.f19227e = new C3066aa(this.f19229g);
        this.f19228f = new C3264w(context, interfaceC2995n);
        this.f19223a = new a(this);
        setAdapter((ListAdapter) this.f19223a);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f19226d = dialogInterfaceC0070b;
        this.f19223a.notifyDataSetChanged();
    }

    /* compiled from: Bookmarks.java */
    /* renamed from: ru.maximoff.apktool.util.e$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private List<Integer> f19230a = new ArrayList();

        /* renamed from: b */
        private Map<Integer, String> f19231b = new LinkedHashMap();

        /* renamed from: c */
        private int f19232c;

        /* renamed from: d */
        private final C3216e f19233d;

        /* renamed from: c */
        static C3216e m19272c(a aVar) {
            return aVar.f19233d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m19273a(i);
        }

        public a(C3216e c3216e) {
            this.f19233d = c3216e;
            this.f19232c = C3246h.m19470a(this.f19233d.f19229g, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
            m19268a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19268a() {
            this.f19230a.clear();
            this.f19231b.clear();
            this.f19233d.f19224b.m19295c();
            this.f19231b.putAll(this.f19233d.f19224b.m19300f());
            Iterator<Integer> it = this.f19231b.keySet().iterator();
            while (it.hasNext()) {
                this.f19230a.add(it.next());
            }
            Collections.sort(this.f19230a);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f19230a != null) {
                return this.f19230a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m19273a(int i) {
            return this.f19231b != null ? this.f19231b.get(new Integer(i)) : (String) null;
        }

        /* renamed from: b */
        public void m19274b(int i) {
            this.f19233d.f19224b.m19297c(this.f19231b.get(new Integer(i)));
            m19268a();
            notifyDataSetChanged();
            if (this.f19230a.isEmpty() && this.f19233d.f19226d != null && this.f19233d.f19226d.isShowing()) {
                try {
                    this.f19233d.f19226d.cancel();
                } catch (Exception e2) {
                }
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C3302d c3302d;
            int intValue = this.f19230a.get(i).intValue();
            if (view == null) {
                view = ((LayoutInflater) this.f19233d.f19229g.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
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
            c3302d.f20964a = intValue;
            c3302d.f20967d.setVisibility(0);
            c3302d.f20966c.setVisibility(8);
            C3220f.a m19285d = C3220f.m19285d(this.f19231b.get(new Integer(intValue)));
            if (m19285d != null) {
                File file = new File(m19285d.m19302b());
                if (C2978b.f16135a.m17697a(file)) {
                    view.setBackgroundColor(C3246h.m19470a(this.f19233d.f19229g, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
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
                c3302d.f20967d.setTag(m19285d.m19302b());
                if (file.exists()) {
                    c3302d.f20968e.setText(m19285d.m19301a());
                    c3302d.f20969f.setText(m19285d.m19302b());
                } else {
                    SpannableString spannableString = new SpannableString(m19285d.m19302b());
                    spannableString.setSpan(new StrikethroughSpan(), 0, m19285d.m19302b().length(), 33);
                    c3302d.f20969f.setText(spannableString);
                    SpannableString spannableString2 = new SpannableString(m19285d.m19301a());
                    spannableString2.setSpan(new StrikethroughSpan(), 0, m19285d.m19301a().length(), 33);
                    c3302d.f20968e.setText(spannableString2);
                }
                if (file.isDirectory()) {
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f19233d.f19227e, this.f19232c, R.drawable.ic_folder));
                } else {
                    String lowerCase = file.getName().toLowerCase();
                    int[] m18400a = C3068ac.m18400a(this.f19233d.f19229g, lowerCase);
                    c3302d.f20967d.setImageBitmap(C3267z.m19713a().m19714a(this.f19233d.f19227e, m18400a[1], m18400a[0]));
                    if (C3072ad.m18430a(lowerCase) || m18400a[0] == R.drawable.ic_image) {
                        C2919au.m17340a(file, new C2919au.a(this, new AsyncTaskC2954y(this.f19233d.f19229g, c3302d.f20967d, this.f19233d.f19225c)) { // from class: ru.maximoff.apktool.util.e.a.1

                            /* renamed from: a */
                            private final a f19239a;

                            /* renamed from: b */
                            private final AsyncTaskC2954y f19240b;

                            {
                                this.f19239a = this;
                                this.f19240b = r2;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2919au.a
                            /* renamed from: a */
                            public AsyncTaskC2954y mo17349a() {
                                return this.f19240b;
                            }
                        });
                    }
                }
                view.setOnClickListener(new View.OnClickListener(this, file) { // from class: ru.maximoff.apktool.util.e.a.2

                    /* renamed from: a */
                    private final a f19241a;

                    /* renamed from: b */
                    private final File f19242b;

                    {
                        this.f19241a = this;
                        this.f19242b = file;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (this.f19242b.isDirectory()) {
                            a.m19272c(this.f19241a).f19225c.mo17934a(this.f19242b);
                            a.m19272c(this.f19241a).f19226d.cancel();
                            return;
                        }
                        a.m19272c(this.f19241a).f19228f.m19685a(this.f19242b);
                        String str = C3262u.m19641b(this.f19242b.getName())[1];
                        if ((C3262u.m19673k(a.m19272c(this.f19241a).f19229g, this.f19242b) || C2887g.m16904a(str) || str.equals("mtd") || str.equals("amd")) && !C3102bd.m18925a(a.m19272c(this.f19241a).f19229g, "ext_editor", false)) {
                            a.m19272c(this.f19241a).f19225c.mo17940b().m17821a(this.f19242b);
                            a.m19272c(this.f19241a).f19226d.cancel();
                        } else {
                            C3262u.m19608a(this.f19242b, view2, a.m19272c(this.f19241a).f19225c);
                        }
                    }
                });
                view.setOnLongClickListener(new AnonymousClass3(this, file, intValue, m19285d));
            }
            return view;
        }

        /* compiled from: Bookmarks.java */
        /* renamed from: ru.maximoff.apktool.util.e$a$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnLongClickListener {

            /* renamed from: a */
            private final a f19243a;

            /* renamed from: b */
            private final File f19244b;

            /* renamed from: c */
            private final int f19245c;

            /* renamed from: d */
            private final C3220f.a f19246d;

            AnonymousClass3(a aVar, File file, int i, C3220f.a aVar2) {
                this.f19243a = aVar;
                this.f19244b = file;
                this.f19245c = i;
                this.f19246d = aVar2;
            }

            /* renamed from: a */
            static a m19275a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f19243a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                int i2;
                C0173ao c0173ao = new C0173ao(a.m19272c(this.f19243a).f19229g, view);
                if (C3102bd.m18910a(a.m19272c(this.f19243a).f19229g, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1000, 0, R.string.show).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19244b) { // from class: ru.maximoff.apktool.util.e.a.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f19247a;

                    /* renamed from: b */
                    private final File f19248b;

                    {
                        this.f19247a = this;
                        this.f19248b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        a.m19272c(AnonymousClass3.m19275a(this.f19247a)).f19225c.mo17934a(this.f19248b.getParentFile());
                        a.m19272c(AnonymousClass3.m19275a(this.f19247a)).f19225c.mo17938a(this.f19248b.getAbsolutePath());
                        a.m19272c(AnonymousClass3.m19275a(this.f19247a)).f19225c.mo17944c(this.f19248b.getAbsolutePath());
                        a.m19272c(AnonymousClass3.m19275a(this.f19247a)).f19226d.cancel();
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1001, 0, R.string.edit).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19245c, this.f19246d) { // from class: ru.maximoff.apktool.util.e.a.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f19249a;

                    /* renamed from: b */
                    private final int f19250b;

                    /* renamed from: c */
                    private final C3220f.a f19251c;

                    {
                        this.f19249a = this;
                        this.f19250b = r2;
                        this.f19251c = r3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass3.m19275a(this.f19249a).m19269a(this.f19250b, this.f19251c);
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1001, 0, R.string.bookmark_remove).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19245c) { // from class: ru.maximoff.apktool.util.e.a.3.3

                    /* renamed from: a */
                    private final AnonymousClass3 f19252a;

                    /* renamed from: b */
                    private final int f19253b;

                    {
                        this.f19252a = this;
                        this.f19253b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass3.m19275a(this.f19252a).m19274b(this.f19253b);
                        a.m19272c(AnonymousClass3.m19275a(this.f19252a)).f19225c.mo17929a();
                        return true;
                    }
                });
                if (this.f19245c > 0) {
                    i2 = 1003;
                    c0173ao.m1339a().add(0, 1002, 0, a.m19272c(this.f19243a).f19229g.getString(R.string.f21471up)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19245c) { // from class: ru.maximoff.apktool.util.e.a.3.4

                        /* renamed from: a */
                        private final AnonymousClass3 f19254a;

                        /* renamed from: b */
                        private final int f19255b;

                        {
                            this.f19254a = this;
                            this.f19255b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            a.m19272c(AnonymousClass3.m19275a(this.f19254a)).f19224b.m19288a(this.f19255b, this.f19255b - 1);
                            AnonymousClass3.m19275a(this.f19254a).m19268a();
                            AnonymousClass3.m19275a(this.f19254a).notifyDataSetChanged();
                            return true;
                        }
                    });
                } else {
                    i2 = 1002;
                }
                if (this.f19245c < this.f19243a.f19230a.size() - 1) {
                    int i3 = i2 + 1;
                    c0173ao.m1339a().add(0, i2, 0, a.m19272c(this.f19243a).f19229g.getString(R.string.down)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19245c) { // from class: ru.maximoff.apktool.util.e.a.3.5

                        /* renamed from: a */
                        private final AnonymousClass3 f19256a;

                        /* renamed from: b */
                        private final int f19257b;

                        {
                            this.f19256a = this;
                            this.f19257b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            a.m19272c(AnonymousClass3.m19275a(this.f19256a)).f19224b.m19288a(this.f19257b, this.f19257b + 1);
                            AnonymousClass3.m19275a(this.f19256a).m19268a();
                            AnonymousClass3.m19275a(this.f19256a).notifyDataSetChanged();
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19269a(int i, C3220f.a aVar) {
            View inflate = LayoutInflater.from(this.f19233d.f19229g).inflate(R.layout.bm_edit, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.bmeditEditText1);
            EditText editText2 = (EditText) inflate.findViewById(R.id.bmeditEditText2);
            editText.setText(aVar.m19301a());
            editText2.setText(aVar.m19302b());
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f19233d.f19229g).m418a(R.string.edit).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, editText2, i) { // from class: ru.maximoff.apktool.util.e.a.4

                /* renamed from: a */
                private final a f19258a;

                /* renamed from: b */
                private final EditText f19259b;

                /* renamed from: c */
                private final EditText f19260c;

                /* renamed from: d */
                private final int f19261d;

                {
                    this.f19258a = this;
                    this.f19259b = editText;
                    this.f19260c = editText2;
                    this.f19261d = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    a.m19272c(this.f19258a).f19224b.m19289a(this.f19261d, C3220f.m19284a(new C3220f.a(this.f19259b.getText().toString(), this.f19260c.getText().toString())));
                    this.f19258a.m19268a();
                    this.f19258a.notifyDataSetChanged();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, editText, editText2) { // from class: ru.maximoff.apktool.util.e.a.5

                /* renamed from: a */
                private final a f19262a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f19263b;

                /* renamed from: c */
                private final EditText f19264c;

                /* renamed from: d */
                private final EditText f19265d;

                {
                    this.f19262a = this;
                    this.f19263b = m438b;
                    this.f19264c = editText;
                    this.f19265d = editText2;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Button m414a = this.f19263b.m414a(-1);
                    this.f19264c.addTextChangedListener(new TextWatcher(this, m414a, this.f19265d) { // from class: ru.maximoff.apktool.util.e.a.5.1

                        /* renamed from: a */
                        private final AnonymousClass5 f19266a;

                        /* renamed from: b */
                        private final Button f19267b;

                        /* renamed from: c */
                        private final EditText f19268c;

                        {
                            this.f19266a = this;
                            this.f19267b = m414a;
                            this.f19268c = r3;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            this.f19267b.setEnabled(editable.length() > 0 && this.f19268c.getText().length() > 0);
                        }
                    });
                    this.f19265d.addTextChangedListener(new TextWatcher(this, m414a, this.f19264c) { // from class: ru.maximoff.apktool.util.e.a.5.2

                        /* renamed from: a */
                        private final AnonymousClass5 f19269a;

                        /* renamed from: b */
                        private final Button f19270b;

                        /* renamed from: c */
                        private final EditText f19271c;

                        {
                            this.f19269a = this;
                            this.f19270b = m414a;
                            this.f19271c = r3;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            this.f19270b.setEnabled(editable.length() > 0 && this.f19271c.getText().length() > 0);
                        }
                    });
                    this.f19264c.requestFocus();
                    this.f19264c.selectAll();
                }
            });
            m438b.show();
        }
    }
}
