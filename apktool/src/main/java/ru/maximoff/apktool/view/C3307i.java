package ru.maximoff.apktool.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.icu.text.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1386h;
import com.p159h.p160a.p162b.C1396r;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.p226d.p233b.C2359g;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.p296a.C2884d;
import ru.maximoff.apktool.p296a.C2892l;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3084ap;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3107bi;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.p295a.C2608a;

/* compiled from: MethodsAdapter.java */
/* renamed from: ru.maximoff.apktool.view.i */
/* loaded from: classes.dex */
public class C3307i extends BaseAdapter {

    /* renamed from: a */
    private Context f21067a;

    /* renamed from: b */
    private Editor f21068b;

    /* renamed from: c */
    private List<C3084ap> f21069c;

    /* renamed from: d */
    private List<C3084ap> f21070d;

    /* renamed from: e */
    private List<C3084ap> f21071e;

    /* renamed from: f */
    private List<C3084ap> f21072f;

    /* renamed from: h */
    private C3313o f21074h;

    /* renamed from: i */
    private C3313o f21075i;

    /* renamed from: j */
    private C3313o f21076j;

    /* renamed from: k */
    private C3313o f21077k;

    /* renamed from: o */
    private int f21081o;

    /* renamed from: g */
    private DialogInterfaceC0070b f21073g = (DialogInterfaceC0070b) null;

    /* renamed from: l */
    private boolean f21078l = false;

    /* renamed from: m */
    private int f21079m = 0;

    /* renamed from: n */
    private int f21080n = 0;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return m19921a(i);
    }

    public C3307i(Context context, Editor editor, List<C3084ap> list) {
        Collections.sort(list, new a(this));
        this.f21067a = context;
        this.f21068b = editor;
        this.f21069c = new ArrayList();
        this.f21070d = new ArrayList();
        this.f21071e = new ArrayList();
        this.f21072f = new ArrayList();
        this.f21081o = C3080al.m18574b(context, 5);
        m19914a(list);
        Typeface typeface = Typeface.DEFAULT;
        int m18522a = C3080al.m18522a(context, 24);
        int i = m18522a / 2;
        this.f21074h = C3313o.m20017a().mo20029a().mo20031a(typeface).mo20030a(m18522a).mo20033b(m18522a).mo20041e(i).mo20040d(2).mo20037c(-1).mo20034b().mo20035b(DateFormat.NUM_MONTH, C3246h.m19470a(this.f21067a, R.color.method_color));
        this.f21075i = C3313o.m20017a().mo20029a().mo20031a(typeface).mo20030a(m18522a).mo20033b(m18522a).mo20041e(i).mo20040d(2).mo20037c(-1).mo20034b().mo20035b("F", C3246h.m19470a(this.f21067a, R.color.field_color));
        this.f21076j = C3313o.m20017a().mo20029a().mo20031a(typeface).mo20030a(m18522a).mo20033b(m18522a).mo20041e(i).mo20040d(2).mo20037c(-1).mo20034b().mo20035b("S", C3246h.m19470a(this.f21067a, R.color.string_color));
        this.f21077k = C3313o.m20017a().mo20029a().mo20031a(typeface).mo20030a(m18522a).mo20033b(m18522a).mo20041e(i).mo20040d(2).mo20037c(-1).mo20034b().mo20035b("C", C3246h.m19470a(this.f21067a, R.color.class_color));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f21070d != null) {
            return this.f21070d.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    public C3084ap m19921a(int i) {
        return this.f21070d != null ? this.f21070d.get(i) : (C3084ap) null;
    }

    /* renamed from: b */
    public void m19926b(int i) {
        this.f21079m = i;
        this.f21080n = m19918c();
    }

    /* renamed from: a */
    public void m19922a(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f21073g = dialogInterfaceC0070b;
        if (this.f21071e.isEmpty() || this.f21072f.isEmpty()) {
            dialogInterfaceC0070b.m414a(-3).setEnabled(false);
        }
    }

    /* renamed from: a */
    public boolean m19924a() {
        boolean z = true;
        this.f21078l = !this.f21078l;
        this.f21070d.clear();
        this.f21069c.clear();
        if (this.f21078l) {
            this.f21070d.addAll(this.f21072f);
            this.f21069c.addAll(this.f21072f);
        } else {
            this.f21070d.addAll(this.f21071e);
            this.f21069c.addAll(this.f21071e);
            z = false;
        }
        notifyDataSetChanged();
        return z;
    }

    /* renamed from: a */
    private void m19914a(List<C3084ap> list) {
        this.f21069c.clear();
        this.f21070d.clear();
        this.f21072f.clear();
        this.f21071e.clear();
        for (C3084ap c3084ap : list) {
            switch (c3084ap.m18656b()) {
                case 3:
                    this.f21072f.add(c3084ap);
                    break;
                default:
                    this.f21071e.add(c3084ap);
                    break;
            }
        }
        if (this.f21071e.isEmpty()) {
            this.f21078l = true;
            this.f21070d.addAll(this.f21072f);
            this.f21069c.addAll(this.f21072f);
        } else {
            this.f21078l = false;
            this.f21070d.addAll(this.f21071e);
            this.f21069c.addAll(this.f21071e);
        }
    }

    /* renamed from: a */
    public void m19923a(String str) {
        this.f21070d.clear();
        if (C3112bn.m19040o(str)) {
            this.f21070d.addAll(this.f21069c);
        } else {
            for (C3084ap c3084ap : this.f21069c) {
                if (c3084ap.toString().toLowerCase().contains(str.toLowerCase())) {
                    this.f21070d.add(c3084ap);
                }
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public int m19925b() {
        return this.f21080n;
    }

    /* renamed from: a */
    private String m19913a(C3084ap c3084ap) {
        int m18657c = c3084ap.m18657c();
        int m19919c = m19919c(m18657c);
        StringBuilder sb = new StringBuilder();
        sb.append(c3084ap.m18663i()).append("\n");
        sb.append(new StringBuffer().append(".super ").append(c3084ap.m18664j()).toString()).append("\n\n");
        while (m18657c <= m19919c) {
            sb.append(this.f21068b.m10879b(m18657c));
            m18657c++;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19915a(C3084ap c3084ap, C2359g c2359g) {
        File file;
        String stringBuffer;
        AbstractRunnableC1391m c2884d;
        try {
            String m19913a = m19913a(c3084ap);
            file = File.createTempFile("Apktool_M", ".tsmali", C3102bd.m18908a());
            C3061a.m18319b(file, m19913a);
            stringBuffer = C3107bi.m18978a(this.f21067a, C2608a.m16251a(file, c2359g), file, c2359g).m11804a();
        } catch (Error e2) {
            file = (File) null;
            stringBuffer = new StringBuffer().append("// Error: ").append(e2.toString().replaceAll("\n", "\n//")).toString();
        } catch (Exception e3) {
            file = (File) null;
            stringBuffer = new StringBuffer().append("// Translate to java failed: ").append(e3.toString().replaceAll("\n", "\n//")).toString();
        }
        boolean[] zArr = {C3102bd.m18925a(this.f21067a, "preview_word_wrap", false)};
        C1386h c1386h = new C1386h();
        Editor editor = new Editor(this.f21067a);
        if (C3102bd.f18287W) {
            c2884d = C1396r.f9139c;
        } else {
            c2884d = new C2884d();
        }
        editor.setLexTask(c2884d);
        editor.setDocumentProvider(c1386h);
        editor.m19756h(false);
        editor.setCharset("UTF-8");
        editor.setEditable(false);
        editor.setWordWrap(zArr[0]);
        editor.m10868a(2);
        c1386h.m11038a(stringBuffer);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f21067a).m418a(R.string.preview).m435b(editor).m420a(R.string.close_cur, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.view.i.1

            /* renamed from: a */
            private final C3307i f21082a;

            {
                this.f21082a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).m440c(R.string.editor_wordwrap, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new AnonymousClass2(this, m438b, zArr, editor));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this, file) { // from class: ru.maximoff.apktool.view.i.3

            /* renamed from: a */
            private final C3307i f21093a;

            /* renamed from: b */
            private final File f21094b;

            {
                this.f21093a = this;
                this.f21094b = file;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f21094b != null) {
                    this.f21094b.delete();
                }
            }
        });
        m438b.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(m438b.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        m438b.getWindow().setAttributes(layoutParams);
    }

    /* compiled from: MethodsAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.i$2, reason: invalid class name */
    class AnonymousClass2 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3307i f21083a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f21084b;

        /* renamed from: c */
        private final boolean[] f21085c;

        /* renamed from: d */
        private final Editor f21086d;

        AnonymousClass2(C3307i c3307i, DialogInterfaceC0070b dialogInterfaceC0070b, boolean[] zArr, Editor editor) {
            this.f21083a = c3307i;
            this.f21084b = dialogInterfaceC0070b;
            this.f21085c = zArr;
            this.f21086d = editor;
        }

        /* renamed from: a */
        static C3307i m19927a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f21083a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f21084b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f21085c, this.f21086d) { // from class: ru.maximoff.apktool.view.i.2.1

                /* renamed from: a */
                private final AnonymousClass2 f21087a;

                /* renamed from: b */
                private final boolean[] f21088b;

                /* renamed from: c */
                private final Editor f21089c;

                {
                    this.f21087a = this;
                    this.f21088b = r2;
                    this.f21089c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f21088b[0] = !this.f21088b[0];
                    C3102bd.m18938b(AnonymousClass2.m19927a(this.f21087a).f21067a, "preview_word_wrap", this.f21088b[0]);
                    int caretPosition = this.f21089c.getCaretPosition();
                    this.f21089c.setWordWrap(this.f21088b[0]);
                    this.f21089c.m10883c();
                    this.f21089c.m10860G();
                    this.f21089c.m10897g();
                    this.f21089c.requestFocus();
                    this.f21089c.postDelayed(new Runnable(this, this.f21089c, caretPosition) { // from class: ru.maximoff.apktool.view.i.2.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f21090a;

                        /* renamed from: b */
                        private final Editor f21091b;

                        /* renamed from: c */
                        private final int f21092c;

                        {
                            this.f21090a = this;
                            this.f21091b = r2;
                            this.f21092c = caretPosition;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f21091b.m10874a(true);
                            this.f21091b.m10901h(this.f21092c);
                        }
                    }, 100L);
                }
            });
            this.f21086d.m10883c();
            this.f21086d.m10860G();
            this.f21086d.m10897g();
            this.f21086d.requestFocus();
        }
    }

    /* renamed from: c */
    private int m19918c() {
        List<C3084ap> list = this.f21078l ? this.f21072f : this.f21071e;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < list.size()) {
                C3084ap c3084ap = list.get(i4);
                int m18657c = this.f21079m - c3084ap.m18657c();
                if (m18657c >= 0 && m18657c < i2) {
                    if (m18657c == 0 && (c3084ap.m18656b() == 1 || c3084ap.m18656b() == 3)) {
                        i2 = m18657c;
                        i = i4;
                    } else if (c3084ap.m18656b() == 2) {
                        i2 = m18657c;
                        i = i4;
                    } else {
                        i2 = m18657c;
                    }
                }
                i3 = i4 + 1;
            } else {
                return i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m19919c(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f21071e.size()) {
                int m18657c = this.f21071e.get(i3).m18657c();
                if (m18657c <= i) {
                    i2 = i3 + 1;
                } else {
                    int i4 = m18657c - 1;
                    String trim = this.f21068b.m10879b(i4).trim();
                    while (true) {
                        if ((!trim.isEmpty() && !trim.startsWith("#")) || i4 <= i) {
                            return i4;
                        }
                        i4--;
                        trim = this.f21068b.m10879b(i4).trim();
                    }
                }
            } else {
                return this.f21068b.getLineCount();
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.f21080n = m19918c();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = ((LayoutInflater) this.f21067a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
            bVar = new b(this);
            bVar.f21120a = (ImageView) view.findViewById(R.id.icon);
            bVar.f21121b = (TextView) view.findViewById(R.id.name);
            bVar.f21122c = (TextView) view.findViewById(R.id.details);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        C3084ap c3084ap = this.f21070d.get(i);
        view.setMinimumHeight(0);
        bVar.f21121b.setTextSize(2, C3102bd.f18332o);
        bVar.f21122c.setTextSize(2, C3102bd.f18332o - 2);
        bVar.f21121b.setText(c3084ap.m18658d());
        if (c3084ap.m18659e() == null) {
            bVar.f21122c.setVisibility(8);
        } else {
            bVar.f21122c.setVisibility(0);
            bVar.f21122c.setText(c3084ap.m18659e());
        }
        bVar.f21120a.setPadding(this.f21081o, this.f21081o, this.f21081o, this.f21081o);
        switch (c3084ap.m18656b()) {
            case 0:
                bVar.f21120a.setImageDrawable(this.f21077k);
                break;
            case 1:
                bVar.f21120a.setImageDrawable(this.f21075i);
                break;
            case 2:
                bVar.f21120a.setImageDrawable(this.f21074h);
                break;
            case 3:
                bVar.f21120a.setImageDrawable(this.f21076j);
                break;
        }
        if (i == this.f21080n) {
            view.setBackgroundColor(C3246h.m19470a(this.f21067a, R.color.tvery_light_blue));
        } else {
            view.setBackgroundColor(0);
        }
        view.setOnClickListener(new View.OnClickListener(this, c3084ap) { // from class: ru.maximoff.apktool.view.i.4

            /* renamed from: a */
            private final C3307i f21095a;

            /* renamed from: b */
            private final C3084ap f21096b;

            {
                this.f21095a = this;
                this.f21096b = c3084ap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f21095a.f21068b.m19757k(this.f21096b.m18657c());
                if (this.f21095a.f21073g != null) {
                    this.f21095a.f21073g.cancel();
                }
            }
        });
        view.setOnLongClickListener(new AnonymousClass5(this, c3084ap));
        return view;
    }

    /* compiled from: MethodsAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.i$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3307i f21097a;

        /* renamed from: b */
        private final C3084ap f21098b;

        AnonymousClass5(C3307i c3307i, C3084ap c3084ap) {
            this.f21097a = c3307i;
            this.f21098b = c3084ap;
        }

        /* renamed from: a */
        static C3307i m19928a(AnonymousClass5 anonymousClass5) {
            return anonymousClass5.f21097a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.f21098b.m18655a()) {
                return false;
            }
            boolean[] zArr = {false};
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (this.f21098b.m18660f() != null) {
                if (this.f21098b.m18656b() != 3) {
                    if (this.f21098b.m18661g() != null && this.f21098b.m18656b() == 2) {
                        zArr[0] = true;
                        String str = "";
                        if (this.f21098b.m18662h() != null) {
                            for (String str2 : this.f21098b.m18662h()) {
                                str = new StringBuffer().append(str).append(new StringBuffer().append(C3112bn.m19024c((CharSequence) str2)).append("|").toString()).toString();
                            }
                        }
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("(").append(str).toString()).append(C3112bn.m19024c((CharSequence) this.f21098b.m18661g())).toString()).append("|").toString()).append(C3112bn.m19024c((CharSequence) this.f21098b.m18660f())).toString()).append(")").toString()).append(C3112bn.m19024c((CharSequence) this.f21098b.m18658d()));
                        sb.append(C3112bn.m19024c((CharSequence) this.f21098b.m18659e()));
                        sb2.append(this.f21098b.m18660f()).append(this.f21098b.m18658d()).append(this.f21098b.m18659e());
                    } else {
                        sb.append(this.f21098b.m18660f()).append(this.f21098b.m18658d());
                        if (this.f21098b.m18656b() == 1) {
                            sb.append(":");
                            int indexOf = this.f21098b.m18659e().indexOf(" = ");
                            if (indexOf > 0) {
                                sb.append(this.f21098b.m18659e().substring(0, indexOf));
                            } else {
                                sb.append(this.f21098b.m18659e());
                            }
                        } else {
                            sb.append(this.f21098b.m18659e());
                        }
                    }
                } else {
                    sb.append(this.f21098b.m18658d());
                }
            } else {
                sb.append(this.f21098b.m18658d());
                if (this.f21098b.m18656b() == 1) {
                    sb.append(":");
                    int indexOf2 = this.f21098b.m18659e().indexOf(" = ");
                    if (indexOf2 > 0) {
                        sb.append(this.f21098b.m18659e().substring(0, indexOf2));
                    } else {
                        sb.append(this.f21098b.m18659e());
                    }
                } else if (this.f21098b.m18656b() == 2) {
                    sb.append(this.f21098b.m18659e());
                }
            }
            String sb3 = sb.toString();
            String sb4 = zArr[0] ? sb2.toString() : sb3;
            C0173ao c0173ao = new C0173ao(this.f21097a.f21067a, view);
            c0173ao.m1340a(C3102bd.m18910a(this.f21097a.f21067a, "menu_position", "1").equals("0") ? 3 : 5);
            c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.copy).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, sb4) { // from class: ru.maximoff.apktool.view.i.5.1

                /* renamed from: a */
                private final AnonymousClass5 f21099a;

                /* renamed from: b */
                private final String f21100b;

                {
                    this.f21099a = this;
                    this.f21100b = sb4;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass5.m19928a(this.f21099a).f21067a, this.f21100b);
                    return true;
                }
            });
            Menu m1339a = c0173ao.m1339a();
            int i = PointerIcon.TYPE_NO_DROP;
            m1339a.add(0, PointerIcon.TYPE_COPY, 0, R.string.search_call).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21098b, sb3, zArr) { // from class: ru.maximoff.apktool.view.i.5.2

                /* renamed from: a */
                private final AnonymousClass5 f21101a;

                /* renamed from: b */
                private final C3084ap f21102b;

                /* renamed from: c */
                private final String f21103c;

                /* renamed from: d */
                private final boolean[] f21104d;

                {
                    this.f21101a = this;
                    this.f21102b = r2;
                    this.f21103c = sb3;
                    this.f21104d = zArr;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    AnonymousClass5.m19928a(this.f21101a).f21073g.cancel();
                    try {
                        if (this.f21102b.m18656b() == 3) {
                            MainActivity.m16615o().m16626a(this.f21102b.m18658d().substring(1, this.f21102b.m18658d().length() - 1), (String) null);
                        } else {
                            MainActivity.m16615o().m16626a(this.f21103c, this.f21104d[0] ? "" : (String) null);
                        }
                    } catch (Exception e2) {
                        C3112bn.m18999a(AnonymousClass5.m19928a(this.f21101a).f21067a, R.string.error);
                    }
                    return true;
                }
            });
            if (this.f21098b.m18656b() == 1) {
                c0173ao.m1339a().add(0, PointerIcon.TYPE_NO_DROP, 0, R.string.search_call_get).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, sb3) { // from class: ru.maximoff.apktool.view.i.5.3

                    /* renamed from: a */
                    private final AnonymousClass5 f21105a;

                    /* renamed from: b */
                    private final String f21106b;

                    {
                        this.f21105a = this;
                        this.f21106b = sb3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21105a).f21073g.cancel();
                        try {
                            MainActivity.m16615o().m16626a(new StringBuffer().append(new StringBuffer().append("(?<=\\s)(i|s)get(-|\\s).+?, ").append(C3112bn.m19024c((CharSequence) this.f21106b)).toString()).append("$").toString(), "");
                            return true;
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass5.m19928a(this.f21105a).f21067a, R.string.error);
                            return true;
                        }
                    }
                });
                Menu m1339a2 = c0173ao.m1339a();
                i = PointerIcon.TYPE_HORIZONTAL_DOUBLE_ARROW;
                m1339a2.add(0, PointerIcon.TYPE_ALL_SCROLL, 0, R.string.search_call_put).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, sb3) { // from class: ru.maximoff.apktool.view.i.5.4

                    /* renamed from: a */
                    private final AnonymousClass5 f21107a;

                    /* renamed from: b */
                    private final String f21108b;

                    {
                        this.f21107a = this;
                        this.f21108b = sb3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21107a).f21073g.cancel();
                        try {
                            MainActivity.m16615o().m16626a(new StringBuffer().append(new StringBuffer().append("(?<=\\s)(i|s)put(-|\\s).+?, ").append(C3112bn.m19024c((CharSequence) this.f21108b)).toString()).append("$").toString(), "");
                            return true;
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass5.m19928a(this.f21107a).f21067a, R.string.error);
                            return true;
                        }
                    }
                });
            }
            if (this.f21098b.m18656b() == 2 || this.f21098b.m18656b() == 0) {
                c0173ao.m1339a().add(0, i, 0, R.string.search_over).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21098b, sb3) { // from class: ru.maximoff.apktool.view.i.5.5

                    /* renamed from: a */
                    private final AnonymousClass5 f21109a;

                    /* renamed from: b */
                    private final C3084ap f21110b;

                    /* renamed from: c */
                    private final String f21111c;

                    {
                        this.f21109a = this;
                        this.f21110b = r2;
                        this.f21111c = sb3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21109a).f21073g.cancel();
                        try {
                            switch (this.f21110b.m18656b()) {
                                case 0:
                                    MainActivity.m16615o().m16626a(new StringBuffer().append(".super ").append(this.f21111c).toString(), (String) null);
                                    break;
                                case 2:
                                    MainActivity.m16615o().m16626a(new StringBuffer().append(new StringBuffer().append("^\\.(super|implements) ").append(C3112bn.m19024c((CharSequence) this.f21110b.m18660f().substring(0, this.f21110b.m18660f().length() - 2))).toString()).append("$").toString(), new StringBuffer().append(new StringBuffer().append("^\\.method.+? ").append(C3112bn.m19024c((CharSequence) new StringBuffer().append(this.f21110b.m18658d()).append(this.f21110b.m18659e()).toString())).toString()).append("$").toString());
                                    break;
                            }
                            return true;
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass5.m19928a(this.f21109a).f21067a, R.string.error);
                            return true;
                        }
                    }
                });
                i++;
            }
            if (this.f21098b.m18656b() == 2 || this.f21098b.m18656b() == 1 || this.f21098b.m18656b() == 3) {
                int i2 = i + 1;
                c0173ao.m1339a().add(0, i, 0, R.string.mselect).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21098b) { // from class: ru.maximoff.apktool.view.i.5.6

                    /* renamed from: a */
                    private final AnonymousClass5 f21112a;

                    /* renamed from: b */
                    private final C3084ap f21113b;

                    {
                        this.f21112a = this;
                        this.f21113b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21112a).f21073g.cancel();
                        try {
                            switch (this.f21113b.m18656b()) {
                                case 1:
                                case 3:
                                    AnonymousClass5.m19928a(this.f21112a).f21068b.m10870a(this.f21113b.m18657c(), this.f21113b.m18657c(), false);
                                    break;
                                case 2:
                                    AnonymousClass5.m19928a(this.f21112a).f21068b.m10870a(this.f21113b.m18657c(), AnonymousClass5.m19928a(this.f21112a).m19919c(this.f21113b.m18657c()), false);
                                    break;
                            }
                            return true;
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass5.m19928a(this.f21112a).f21067a, R.string.error);
                            return true;
                        }
                    }
                });
                i = i2 + 1;
                c0173ao.m1339a().add(0, i2, 0, R.string.delete).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21098b) { // from class: ru.maximoff.apktool.view.i.5.7

                    /* renamed from: a */
                    private final AnonymousClass5 f21114a;

                    /* renamed from: b */
                    private final C3084ap f21115b;

                    {
                        this.f21114a = this;
                        this.f21115b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21114a).f21073g.cancel();
                        try {
                            switch (this.f21115b.m18656b()) {
                                case 1:
                                case 3:
                                    AnonymousClass5.m19928a(this.f21114a).f21068b.m10870a(this.f21115b.m18657c(), this.f21115b.m18657c(), true);
                                    break;
                                case 2:
                                    AnonymousClass5.m19928a(this.f21114a).f21068b.m10870a(this.f21115b.m18657c(), AnonymousClass5.m19928a(this.f21114a).m19919c(this.f21115b.m18657c()), true);
                                    break;
                            }
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass5.m19928a(this.f21114a).f21067a, R.string.error);
                        }
                        return true;
                    }
                });
            }
            AbstractRunnableC1391m lexTask = this.f21097a.f21068b.getLexTask();
            if ((lexTask instanceof C2892l) && this.f21098b.m18656b() == 2 && this.f21098b.m18663i() != null && this.f21098b.m18661g() != null) {
                int i3 = i + 1;
                c0173ao.m1339a().add(0, i, 0, R.string.translate_java).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21098b, lexTask) { // from class: ru.maximoff.apktool.view.i.5.8

                    /* renamed from: a */
                    private final AnonymousClass5 f21116a;

                    /* renamed from: b */
                    private final C3084ap f21117b;

                    /* renamed from: c */
                    private final AbstractRunnableC1391m f21118c;

                    {
                        this.f21116a = this;
                        this.f21117b = r2;
                        this.f21118c = lexTask;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass5.m19928a(this.f21116a).m19915a(this.f21117b, ((C2892l) this.f21118c).m16929k());
                        return true;
                    }
                });
            }
            c0173ao.m1344c();
            return true;
        }
    }

    /* compiled from: MethodsAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.i$b */
    private class b {

        /* renamed from: a */
        public ImageView f21120a;

        /* renamed from: b */
        public TextView f21121b;

        /* renamed from: c */
        public TextView f21122c;

        /* renamed from: d */
        private final C3307i f21123d;

        public b(C3307i c3307i) {
            this.f21123d = c3307i;
        }
    }

    /* compiled from: MethodsAdapter.java */
    /* renamed from: ru.maximoff.apktool.view.i$a */
    private class a implements Comparator<C3084ap> {

        /* renamed from: a */
        private final C3307i f21119a;

        @Override // java.util.Comparator
        public int compare(C3084ap c3084ap, C3084ap c3084ap2) {
            return m19929a(c3084ap, c3084ap2);
        }

        /* renamed from: a */
        public int m19929a(C3084ap c3084ap, C3084ap c3084ap2) {
            return Integer.compare(c3084ap.m18656b(), c3084ap2.m18656b());
        }

        public a(C3307i c3307i) {
            this.f21119a = c3307i;
        }
    }
}
