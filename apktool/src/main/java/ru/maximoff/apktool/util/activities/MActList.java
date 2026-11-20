package ru.maximoff.apktool.util.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.view.CustomListView;

/* loaded from: classes.dex */
public class MActList extends CustomListView {

    /* renamed from: a */
    private C3069a f17249a;

    /* renamed from: b */
    private List<C3071a> f17250b;

    /* renamed from: c */
    private List<C3071a> f17251c;

    /* renamed from: d */
    private Context f17252d;

    /* renamed from: e */
    private DialogInterfaceC0070b f17253e;

    /* renamed from: f */
    private Typeface f17254f;

    /* renamed from: g */
    private boolean f17255g;

    /* renamed from: h */
    private String f17256h;

    /* renamed from: i */
    private boolean f17257i;

    @Override // ru.maximoff.apktool.view.CustomListView
    /* renamed from: a */
    protected void mo18407a(Context context) {
        super.mo18407a(context);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        this.f17252d = context;
        this.f17256h = context.getString(R.string.lock_icon);
        try {
            this.f17254f = Typeface.createFromAsset(context.getAssets(), "icofont.ttf");
            this.f17255g = true;
        } catch (Exception e2) {
            this.f17254f = Typeface.DEFAULT;
            this.f17255g = false;
        }
        this.f17257i = false;
        this.f17250b = new ArrayList();
        this.f17251c = new ArrayList();
        this.f17249a = new C3069a(this);
        setAdapter((ListAdapter) this.f17249a);
    }

    public MActList(Context context) {
        super(context);
        this.f17249a = (C3069a) null;
        this.f17250b = (List) null;
        this.f17251c = (List) null;
        mo18407a(context);
    }

    public MActList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17249a = (C3069a) null;
        this.f17250b = (List) null;
        this.f17251c = (List) null;
        mo18407a(context);
    }

    public MActList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17249a = (C3069a) null;
        this.f17250b = (List) null;
        this.f17251c = (List) null;
        mo18407a(context);
    }

    public void setFilter(String str) {
        List<C3071a> m18406a = m18406a(str);
        if (this.f17253e != null && this.f17253e.isShowing()) {
            try {
                ((TextView) this.f17253e.findViewById(R.id.alertTitle)).setText(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f17252d.getString(R.string.act_list)).append(" (").toString()).append(m18406a.size()).toString()).append(")").toString());
            } catch (Exception e2) {
            }
        }
        this.f17249a.m18415b(m18406a);
    }

    public void setPackage(String str) {
        try {
            this.f17251c = C3080al.m18606j(this.f17252d, str);
        } catch (Exception e2) {
            this.f17251c = new ArrayList();
        }
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f17253e = dialogInterfaceC0070b;
    }

    /* renamed from: a */
    public void m18409a(boolean z) {
        this.f17257i = z;
    }

    /* renamed from: a */
    public void m18408a(List<C3071a> list) {
        this.f17250b.addAll(list);
        this.f17249a.m18414a(list);
    }

    public List<C3071a> getArray() {
        return this.f17249a.m18412a();
    }

    /* renamed from: a */
    public List<C3071a> m18406a(String str) {
        if (str == null || str.length() == 0) {
            return this.f17250b;
        }
        ArrayList arrayList = new ArrayList();
        for (C3071a c3071a : this.f17250b) {
            if (c3071a.m18426e().toLowerCase().contains(str.toLowerCase()) || c3071a.m18425d().toLowerCase().contains(str.toLowerCase()) || c3071a.m18424c().toLowerCase().contains(str.toLowerCase()) || c3071a.m18427f().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(c3071a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m18410a(C3071a c3071a) {
        Iterator<C3071a> it = this.f17251c.iterator();
        while (it.hasNext()) {
            if (it.next().m18424c().equals(c3071a.m18424c())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ru.maximoff.apktool.util.activities.MActList$a */
    private class C3069a extends BaseAdapter {

        /* renamed from: a */
        private List<C3071a> f17258a = new ArrayList();

        /* renamed from: b */
        private final MActList f17259b;

        /* renamed from: a */
        static MActList m18411a(C3069a c3069a) {
            return c3069a.f17259b;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m18413a(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f17258a != null) {
                return this.f17258a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public C3071a m18413a(int i) {
            return this.f17258a != null ? this.f17258a.get(i) : (C3071a) null;
        }

        /* renamed from: a */
        public void m18414a(List<C3071a> list) {
            this.f17258a.addAll(list);
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public List<C3071a> m18412a() {
            return this.f17258a;
        }

        /* renamed from: b */
        public void m18415b(List<C3071a> list) {
            this.f17258a.clear();
            this.f17258a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C3070b c3070b;
            String m18427f;
            if (view == null) {
                view = ((LayoutInflater) this.f17259b.f17252d.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                c3070b = new C3070b(this.f17259b);
                c3070b.f17323b = (ImageView) view.findViewById(R.id.icon);
                c3070b.f17324c = (TextView) view.findViewById(R.id.name);
                c3070b.f17325d = (TextView) view.findViewById(R.id.details);
                view.setTag(c3070b);
            } else {
                c3070b = (C3070b) view.getTag();
            }
            c3070b.f17322a = i;
            C3071a c3071a = this.f17258a.get(i);
            if (c3071a != null) {
                c3070b.f17325d.setTextSize(2, C3102bd.m18927b());
                c3070b.f17324c.setTextSize(2, C3102bd.f18332o);
                c3070b.f17324c.setTypeface(this.f17259b.f17254f);
                c3070b.f17325d.setTypeface(this.f17259b.f17254f);
                c3070b.f17323b.setImageDrawable(c3071a.m18428g());
                if (c3071a.m18429h() && this.f17259b.f17255g) {
                    m18427f = new StringBuffer().append(new StringBuffer().append(this.f17259b.f17256h).append(" ").toString()).append(c3071a.m18427f()).toString();
                } else {
                    m18427f = c3071a.m18427f();
                }
                if (this.f17259b.m18410a(c3071a)) {
                    SpannableString spannableString = new SpannableString(m18427f);
                    spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f17259b.f17252d, R.color.dark_green)), 0, m18427f.length(), 33);
                    spannableString.setSpan(new StyleSpan(1), 0, m18427f.length(), 33);
                    c3070b.f17324c.setText(spannableString);
                    SpannableString spannableString2 = new SpannableString(c3071a.m18424c());
                    spannableString2.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f17259b.f17252d, R.color.dark_green)), 0, c3071a.m18424c().length(), 33);
                    spannableString2.setSpan(new StyleSpan(1), 0, c3071a.m18424c().length(), 33);
                    c3070b.f17325d.setText(spannableString2);
                } else if (c3071a.m18422a()) {
                    SpannableString spannableString3 = new SpannableString(m18427f);
                    spannableString3.setSpan(new ForegroundColorSpan(Color.GRAY), 0, m18427f.length(), 33);
                    spannableString3.setSpan(new StyleSpan(2), 0, m18427f.length(), 33);
                    c3070b.f17324c.setText(spannableString3);
                    SpannableString spannableString4 = new SpannableString(c3071a.m18424c());
                    spannableString4.setSpan(new ForegroundColorSpan(Color.GRAY), 0, c3071a.m18424c().length(), 33);
                    spannableString4.setSpan(new StyleSpan(2), 0, c3071a.m18424c().length(), 33);
                    c3070b.f17325d.setText(spannableString4);
                } else {
                    c3070b.f17324c.setText(m18427f);
                    c3070b.f17325d.setText(c3071a.m18424c());
                }
                view.setOnClickListener(new View.OnClickListener(this, c3071a) { // from class: ru.maximoff.apktool.util.activities.MActList.a.1

                    /* renamed from: a */
                    private final C3069a f17260a;

                    /* renamed from: b */
                    private final C3071a f17261b;

                    {
                        this.f17260a = this;
                        this.f17261b = c3071a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        try {
                            this.f17261b.m18421a(C3069a.m18411a(this.f17260a).f17252d);
                        } catch (Exception e2) {
                            C3112bn.m18999a(C3069a.m18411a(this.f17260a).f17252d, R.string.launch_fail);
                        }
                    }
                });
                view.setOnLongClickListener(new AnonymousClass2(this, c3071a));
            }
            return view;
        }

        /* renamed from: ru.maximoff.apktool.util.activities.MActList$a$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final C3069a f17262a;

            /* renamed from: b */
            private final C3071a f17263b;

            AnonymousClass2(C3069a c3069a, C3071a c3071a) {
                this.f17262a = c3069a;
                this.f17263b = c3071a;
            }

            /* renamed from: a */
            static C3069a m18416a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f17262a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(C3069a.m18411a(this.f17262a).f17252d, view);
                if (C3102bd.m18910a(C3069a.m18411a(this.f17262a).f17252d, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.copy).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17263b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f17264a;

                    /* renamed from: b */
                    private final C3071a f17265b;

                    {
                        this.f17264a = this;
                        this.f17265b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17264a)).f17252d, this.f17265b.m18426e());
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, R.string.cp_name).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17263b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.2

                    /* renamed from: a */
                    private final AnonymousClass2 f17266a;

                    /* renamed from: b */
                    private final C3071a f17267b;

                    {
                        this.f17266a = this;
                        this.f17267b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17266a)).f17252d, this.f17267b.m18427f());
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, PointerIcon.TYPE_NO_DROP, 0, R.string.copy_path).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17263b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.3

                    /* renamed from: a */
                    private final AnonymousClass2 f17268a;

                    /* renamed from: b */
                    private final C3071a f17269b;

                    {
                        this.f17268a = this;
                        this.f17269b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17268a)).f17252d, this.f17269b.m18424c());
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, PointerIcon.TYPE_ALL_SCROLL, 0, R.string.create_shortcut).setOnMenuItemClickListener(new AnonymousClass4(this, this.f17263b));
                c0173ao.m1339a().add(0, PointerIcon.TYPE_HORIZONTAL_DOUBLE_ARROW, 0, C3069a.m18411a(this.f17262a).f17252d.getString(R.string.extract_icon)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17263b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.5

                    /* renamed from: a */
                    private final AnonymousClass2 f17318a;

                    /* renamed from: b */
                    private final C3071a f17319b;

                    {
                        this.f17318a = this;
                        this.f17319b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        try {
                            String str = C3102bd.f18339v;
                            if (str == null) {
                                C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, R.string.output_directory_not_set);
                            } else {
                                File file = new File(str);
                                if (!file.exists() && !file.mkdirs()) {
                                    C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d.getString(R.string.output_directory_not_extsts, str));
                                } else if (!file.isDirectory()) {
                                    C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d.getString(R.string.not_directory, str));
                                } else {
                                    C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d.getString(R.string.extraction, C3067ab.m18383a(C3067ab.m18372a(this.f17319b.m18428g()), new File(str, C3262u.m19566a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, str, C3112bn.m19033h(new StringBuffer().append(new StringBuffer().append(this.f17319b.m18427f()).append("_").toString()).append(this.f17319b.m18423b()).toString()).replaceAll("\\s", "_"), ".png", 0))).getAbsolutePath()));
                                    MainActivity m16615o = MainActivity.m16615o();
                                    if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                                        m16615o.m16644z();
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17318a)).f17252d, R.string.error);
                        }
                        return true;
                    }
                });
                if (C3069a.m18411a(this.f17262a).f17257i) {
                    c0173ao.m1339a().add(0, PointerIcon.TYPE_VERTICAL_DOUBLE_ARROW, 0, R.string.about).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17263b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.6

                        /* renamed from: a */
                        private final AnonymousClass2 f17320a;

                        /* renamed from: b */
                        private final C3071a f17321b;

                        {
                            this.f17320a = this;
                            this.f17321b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3080al.m18588c(C3069a.m18411a(AnonymousClass2.m18416a(this.f17320a)).f17252d, this.f17321b.m18423b());
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
                return true;
            }

            /* renamed from: ru.maximoff.apktool.util.activities.MActList$a$2$4, reason: invalid class name */
            class AnonymousClass4 implements MenuItem.OnMenuItemClickListener {

                /* renamed from: a */
                private final AnonymousClass2 f17270a;

                /* renamed from: b */
                private final C3071a f17271b;

                AnonymousClass4(AnonymousClass2 anonymousClass2, C3071a c3071a) {
                    this.f17270a = anonymousClass2;
                    this.f17271b = c3071a;
                }

                /* renamed from: a */
                static AnonymousClass2 m18417a(AnonymousClass4 anonymousClass4) {
                    return anonymousClass4.f17270a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    View inflate = LayoutInflater.from(C3069a.m18411a(AnonymousClass2.m18416a(this.f17270a)).f17252d).inflate(R.layout.act_short, (ViewGroup) null);
                    Drawable[] drawableArr = {this.f17271b.m18428g()};
                    EditText editText = (EditText) inflate.findViewById(R.id.actshortEditText1);
                    editText.setText(this.f17271b.m18427f());
                    editText.setHint(this.f17271b.m18427f());
                    ((TextView) inflate.findViewById(R.id.actshortTextView1)).setText(this.f17271b.m18425d());
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.actshortImageView1);
                    imageView.setImageDrawable(this.f17271b.m18428g());
                    imageView.setClickable(true);
                    imageView.setOnClickListener(new AnonymousClass1(this, imageView, drawableArr));
                    imageView.setOnLongClickListener(new ViewOnLongClickListenerC34232(this, this.f17271b, drawableArr, imageView));
                    DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(C3069a.m18411a(AnonymousClass2.m18416a(this.f17270a)).f17252d).m418a(R.string.create_shortcut).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, drawableArr, this.f17271b, editText) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.3

                        /* renamed from: a */
                        private final AnonymousClass4 f17309a;

                        /* renamed from: b */
                        private final Drawable[] f17310b;

                        /* renamed from: c */
                        private final C3071a f17311c;

                        /* renamed from: d */
                        private final EditText f17312d;

                        {
                            this.f17309a = this;
                            this.f17310b = drawableArr;
                            this.f17311c = r3;
                            this.f17312d = editText;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                Bitmap m18372a = C3067ab.m18372a(this.f17310b[0]);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                m18372a.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                try {
                                    Intent intent = new Intent(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17309a))).f17252d, Class.forName("ru.maximoff.apktool.CreateShortcut"));
                                    intent.putExtra("shortcutIcon", byteArrayOutputStream.toByteArray());
                                    intent.putExtra("shortcutPackage", this.f17311c.m18423b());
                                    intent.putExtra("shortcutClass", this.f17311c.m18424c());
                                    intent.putExtra("shortcutName", this.f17312d.getText().toString());
                                    C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17309a))).f17252d.startActivity(intent);
                                } catch (ClassNotFoundException e2) {
                                    throw new NoClassDefFoundError(e2.getMessage());
                                }
                            } catch (Exception e3) {
                                C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17309a))).f17252d, R.string.error);
                            }
                            dialogInterface.dismiss();
                        }
                    }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                    m438b.getWindow().setSoftInputMode(4);
                    m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, editText) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.4

                        /* renamed from: a */
                        private final AnonymousClass4 f17313a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f17314b;

                        /* renamed from: c */
                        private final EditText f17315c;

                        {
                            this.f17313a = this;
                            this.f17314b = m438b;
                            this.f17315c = editText;
                        }

                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            Button m414a = this.f17314b.m414a(-1);
                            m414a.setEnabled(this.f17315c.getText().length() > 0);
                            this.f17315c.requestFocus();
                            this.f17315c.selectAll();
                            this.f17315c.addTextChangedListener(new TextWatcher(this, m414a) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.4.1

                                /* renamed from: a */
                                private final DialogInterfaceOnShowListenerC34264 f17316a;

                                /* renamed from: b */
                                private final Button f17317b;

                                {
                                    this.f17316a = this;
                                    this.f17317b = m414a;
                                }

                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    this.f17317b.setEnabled(editable.length() > 0);
                                }
                            });
                        }
                    });
                    m438b.show();
                    return true;
                }

                /* renamed from: ru.maximoff.apktool.util.activities.MActList$a$2$4$1, reason: invalid class name */
                class AnonymousClass1 implements View.OnClickListener {

                    /* renamed from: a */
                    private final AnonymousClass4 f17272a;

                    /* renamed from: b */
                    private final ImageView f17273b;

                    /* renamed from: c */
                    private final Drawable[] f17274c;

                    AnonymousClass1(AnonymousClass4 anonymousClass4, ImageView imageView, Drawable[] drawableArr) {
                        this.f17272a = anonymousClass4;
                        this.f17273b = imageView;
                        this.f17274c = drawableArr;
                    }

                    /* renamed from: a */
                    static AnonymousClass4 m18418a(AnonymousClass1 anonymousClass1) {
                        return anonymousClass1.f17272a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3261t c3261t = new C3261t(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17272a))).f17252d);
                        Runnable runnable = new Runnable(this, c3261t, this.f17273b, this.f17274c) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f17275a;

                            /* renamed from: b */
                            private final C3261t f17276b;

                            /* renamed from: c */
                            private final ImageView f17277c;

                            /* renamed from: d */
                            private final Drawable[] f17278d;

                            {
                                this.f17275a = this;
                                this.f17276b = c3261t;
                                this.f17277c = r3;
                                this.f17278d = r4;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(this.f17275a)))).f17252d.getResources(), C3067ab.m18377a(this.f17276b.getPath(), 192));
                                    this.f17277c.setImageDrawable(bitmapDrawable);
                                    this.f17278d[0] = bitmapDrawable;
                                } catch (Exception e2) {
                                    C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(this.f17275a)))).f17252d, R.string.error);
                                }
                            }
                        };
                        c3261t.m19545a("_shortcut");
                        c3261t.setCallback(runnable);
                        c3261t.setFilter(new String[]{"gif", "png", "jpg", "jpeg", "bmp", "webp"});
                        c3261t.m19550e();
                        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17272a))).f17252d);
                        aVar.m427a(c3261t.m19548c());
                        aVar.m435b(c3261t);
                        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
                        aVar.m437b("/...", (DialogInterface.OnClickListener) null);
                        aVar.m429a(false);
                        aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f17279a;

                            /* renamed from: b */
                            private final C3261t f17280b;

                            {
                                this.f17279a = this;
                                this.f17280b = c3261t;
                            }

                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                    return false;
                                }
                                boolean m19551f = this.f17280b.m19551f();
                                if (!m19551f) {
                                    dialogInterface.dismiss();
                                    return m19551f;
                                }
                                return m19551f;
                            }
                        });
                        DialogInterfaceC0070b m438b = aVar.m438b();
                        m438b.setOnShowListener(new AnonymousClass3(this, m438b, c3261t));
                        c3261t.setDialog(m438b);
                        m438b.show();
                    }

                    /* renamed from: ru.maximoff.apktool.util.activities.MActList$a$2$4$1$3, reason: invalid class name */
                    class AnonymousClass3 implements DialogInterface.OnShowListener {

                        /* renamed from: a */
                        private final AnonymousClass1 f17281a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f17282b;

                        /* renamed from: c */
                        private final C3261t f17283c;

                        AnonymousClass3(AnonymousClass1 anonymousClass1, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
                            this.f17281a = anonymousClass1;
                            this.f17282b = dialogInterfaceC0070b;
                            this.f17283c = c3261t;
                        }

                        /* renamed from: a */
                        static AnonymousClass1 m18419a(AnonymousClass3 anonymousClass3) {
                            return anonymousClass3.f17281a;
                        }

                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            Button m414a = this.f17282b.m414a(-3);
                            m414a.setOnClickListener(new View.OnClickListener(this, this.f17283c) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.3.1

                                /* renamed from: a */
                                private final AnonymousClass3 f17284a;

                                /* renamed from: b */
                                private final C3261t f17285b;

                                {
                                    this.f17284a = this;
                                    this.f17285b = r2;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    int i;
                                    String[] m19640b = C3262u.m19640b(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(AnonymousClass3.m18419a(this.f17284a))))).f17252d);
                                    if (m19640b != null) {
                                        C0173ao c0173ao = new C0173ao(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(AnonymousClass3.m18419a(this.f17284a))))).f17252d, view);
                                        if (C3102bd.m18910a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(AnonymousClass3.m18419a(this.f17284a))))).f17252d, "menu_position", "1").equals("0")) {
                                            i = 3;
                                        } else {
                                            i = 5;
                                        }
                                        c0173ao.m1340a(i);
                                        for (int i2 = 0; i2 < m19640b.length; i2++) {
                                            c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17285b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.3.1.1

                                                /* renamed from: a */
                                                private final ViewOnClickListenerC34191 f17286a;

                                                /* renamed from: b */
                                                private final C3261t f17287b;

                                                {
                                                    this.f17286a = this;
                                                    this.f17287b = r2;
                                                }

                                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                                public boolean onMenuItemClick(MenuItem menuItem) {
                                                    this.f17287b.m19544a(new File(menuItem.getTitle().toString()));
                                                    return true;
                                                }
                                            });
                                        }
                                        c0173ao.m1344c();
                                    }
                                }
                            });
                            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f17283c) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.3.2

                                /* renamed from: a */
                                private final AnonymousClass3 f17288a;

                                /* renamed from: b */
                                private final C3261t f17289b;

                                {
                                    this.f17288a = this;
                                    this.f17289b = r2;
                                }

                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view) {
                                    int i;
                                    List<String> m19205b = this.f17289b.m19549d().m19205b();
                                    if (m19205b.isEmpty()) {
                                        return false;
                                    }
                                    C0173ao c0173ao = new C0173ao(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(AnonymousClass3.m18419a(this.f17288a))))).f17252d, view);
                                    if (C3102bd.m18910a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(AnonymousClass1.m18418a(AnonymousClass3.m18419a(this.f17288a))))).f17252d, "menu_position", "1").equals("0")) {
                                        i = 3;
                                    } else {
                                        i = 5;
                                    }
                                    c0173ao.m1340a(i);
                                    Iterator<String> it = m19205b.iterator();
                                    while (it.hasNext()) {
                                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17289b) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.1.3.2.1

                                            /* renamed from: a */
                                            private final ViewOnLongClickListenerC34212 f17290a;

                                            /* renamed from: b */
                                            private final C3261t f17291b;

                                            {
                                                this.f17290a = this;
                                                this.f17291b = r2;
                                            }

                                            @Override // android.view.MenuItem.OnMenuItemClickListener
                                            public boolean onMenuItemClick(MenuItem menuItem) {
                                                this.f17291b.m19544a(new File(menuItem.getTitle().toString()));
                                                return true;
                                            }
                                        });
                                    }
                                    c0173ao.m1344c();
                                    return true;
                                }
                            });
                        }
                    }
                }

                /* renamed from: ru.maximoff.apktool.util.activities.MActList$a$2$4$2, reason: invalid class name and collision with other inner class name */
                class ViewOnLongClickListenerC34232 implements View.OnLongClickListener {

                    /* renamed from: a */
                    private final AnonymousClass4 f17292a;

                    /* renamed from: b */
                    private final C3071a f17293b;

                    /* renamed from: c */
                    private final Drawable[] f17294c;

                    /* renamed from: d */
                    private final ImageView f17295d;

                    ViewOnLongClickListenerC34232(AnonymousClass4 anonymousClass4, C3071a c3071a, Drawable[] drawableArr, ImageView imageView) {
                        this.f17292a = anonymousClass4;
                        this.f17293b = c3071a;
                        this.f17294c = drawableArr;
                        this.f17295d = imageView;
                    }

                    /* renamed from: a */
                    static AnonymousClass4 m18420a(ViewOnLongClickListenerC34232 viewOnLongClickListenerC34232) {
                        return viewOnLongClickListenerC34232.f17292a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        C0173ao c0173ao = new C0173ao(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d, view);
                        if (C3102bd.m18910a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        c0173ao.m1339a().add(0, 1400, 0, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d.getString(R.string.save)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17293b, this.f17294c) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.2.1

                            /* renamed from: a */
                            private final ViewOnLongClickListenerC34232 f17296a;

                            /* renamed from: b */
                            private final C3071a f17297b;

                            /* renamed from: c */
                            private final Drawable[] f17298c;

                            {
                                this.f17296a = this;
                                this.f17297b = r2;
                                this.f17298c = r3;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                try {
                                    String str = C3102bd.f18339v;
                                    if (str == null) {
                                        C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, R.string.output_directory_not_set);
                                    } else {
                                        File file = new File(str);
                                        if (!file.exists() && !file.mkdirs()) {
                                            C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d.getString(R.string.output_directory_not_extsts, str));
                                        } else if (!file.isDirectory()) {
                                            C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d.getString(R.string.not_directory, str));
                                        } else {
                                            C3112bn.m19023b(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d.getString(R.string.extraction, C3067ab.m18383a(C3067ab.m18372a(this.f17298c[0]), new File(str, C3262u.m19566a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, str, C3112bn.m19033h(new StringBuffer().append(new StringBuffer().append(this.f17297b.m18427f()).append("_").toString()).append(this.f17297b.m18423b()).toString()).replaceAll("\\s", "_"), ".png", 0))).getAbsolutePath()));
                                            MainActivity m16615o = MainActivity.m16615o();
                                            if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                                                m16615o.m16644z();
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17296a)))).f17252d, R.string.error);
                                }
                                return true;
                            }
                        });
                        c0173ao.m1339a().add(0, 1401, 0, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d.getString(R.string.invert_color)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17294c, this.f17295d) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.2.2

                            /* renamed from: a */
                            private final ViewOnLongClickListenerC34232 f17299a;

                            /* renamed from: b */
                            private final Drawable[] f17300b;

                            /* renamed from: c */
                            private final ImageView f17301c;

                            {
                                this.f17299a = this;
                                this.f17300b = r2;
                                this.f17301c = r3;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                try {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17299a)))).f17252d.getResources(), C3067ab.m18395c(C3067ab.m18372a(this.f17300b[0])));
                                    this.f17301c.setImageDrawable(bitmapDrawable);
                                    this.f17300b[0] = bitmapDrawable;
                                    return true;
                                } catch (Exception e2) {
                                    C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17299a)))).f17252d, R.string.error);
                                    return true;
                                }
                            }
                        });
                        c0173ao.m1339a().add(0, 1402, 0, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d.getString(R.string.monochrome)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17294c, this.f17295d) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.2.3

                            /* renamed from: a */
                            private final ViewOnLongClickListenerC34232 f17302a;

                            /* renamed from: b */
                            private final Drawable[] f17303b;

                            /* renamed from: c */
                            private final ImageView f17304c;

                            {
                                this.f17302a = this;
                                this.f17303b = r2;
                                this.f17304c = r3;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                try {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17302a)))).f17252d.getResources(), C3067ab.m18397d(C3067ab.m18372a(this.f17303b[0])));
                                    this.f17304c.setImageDrawable(bitmapDrawable);
                                    this.f17303b[0] = bitmapDrawable;
                                    return true;
                                } catch (Exception e2) {
                                    C3112bn.m18999a(C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(ViewOnLongClickListenerC34232.m18420a(this.f17302a)))).f17252d, R.string.error);
                                    return true;
                                }
                            }
                        });
                        c0173ao.m1339a().add(0, 1403, 0, C3069a.m18411a(AnonymousClass2.m18416a(AnonymousClass4.m18417a(this.f17292a))).f17252d.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17295d, this.f17293b, this.f17294c) { // from class: ru.maximoff.apktool.util.activities.MActList.a.2.4.2.4

                            /* renamed from: a */
                            private final ViewOnLongClickListenerC34232 f17305a;

                            /* renamed from: b */
                            private final ImageView f17306b;

                            /* renamed from: c */
                            private final C3071a f17307c;

                            /* renamed from: d */
                            private final Drawable[] f17308d;

                            {
                                this.f17305a = this;
                                this.f17306b = r2;
                                this.f17307c = r3;
                                this.f17308d = r4;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                this.f17306b.setImageDrawable(this.f17307c.m18428g());
                                this.f17308d[0] = this.f17307c.m18428g();
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                        return true;
                    }
                }
            }
        }

        public C3069a(MActList mActList) {
            this.f17259b = mActList;
        }
    }

    /* renamed from: ru.maximoff.apktool.util.activities.MActList$b */
    private class C3070b {

        /* renamed from: a */
        public int f17322a;

        /* renamed from: b */
        public ImageView f17323b;

        /* renamed from: c */
        public TextView f17324c;

        /* renamed from: d */
        public TextView f17325d;

        /* renamed from: e */
        private final MActList f17326e;

        public C3070b(MActList mActList) {
            this.f17326e = mActList;
        }
    }
}
