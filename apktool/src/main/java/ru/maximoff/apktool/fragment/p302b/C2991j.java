package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.fragment.app.ActivityC0375f;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p270e.C2466a;
import org.p270e.C2468c;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.p300e.C2918at;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3086ar;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3103be;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3264w;
import ru.maximoff.apktool.view.C3302d;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: FilesAdapter.java */
/* renamed from: ru.maximoff.apktool.fragment.b.j */
/* loaded from: classes.dex */
public class C2991j extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC2995n {

    /* renamed from: b */
    private C2981b f16481b;

    /* renamed from: c */
    private ViewOnClickListenerC2992k f16482c;

    /* renamed from: d */
    private List<InterfaceC2994m> f16483d;

    /* renamed from: e */
    private TextView f16484e;

    /* renamed from: f */
    private C2985d f16485f;

    /* renamed from: g */
    private File f16486g;

    /* renamed from: h */
    private String[] f16487h;

    /* renamed from: i */
    private List<String> f16488i;

    /* renamed from: j */
    private CustomListView f16489j;

    /* renamed from: k */
    private Map<String, Integer> f16490k;

    /* renamed from: l */
    private FilenameFilter f16491l;

    /* renamed from: m */
    private ImageView f16492m;

    /* renamed from: n */
    private boolean f16493n;

    /* renamed from: o */
    private int f16494o;

    /* renamed from: p */
    private int f16495p;

    /* renamed from: q */
    private List<String> f16496q;

    /* renamed from: r */
    private boolean f16497r;

    /* renamed from: s */
    private InterfaceC2995n f16498s;

    /* renamed from: t */
    private a f16499t;

    /* renamed from: v */
    private List<String> f16501v;

    /* renamed from: w */
    private C3264w f16502w;

    /* renamed from: a */
    private final File f16480a = Environment.getExternalStorageDirectory();

    /* renamed from: u */
    private String f16500u = "";

    /* renamed from: x */
    private int f16503x = 0;

    /* renamed from: y */
    private int f16504y = 0;

    public C2991j(C2981b c2981b, TextView textView, ViewOnClickListenerC2992k viewOnClickListenerC2992k) {
        Context n = c2981b.m2876n();
        this.f16498s = this;
        this.f16481b = c2981b;
        this.f16484e = textView;
        this.f16482c = viewOnClickListenerC2992k;
        this.f16491l = new FilenameFilter(this) { // from class: ru.maximoff.apktool.fragment.b.j.1

            /* renamed from: a */
            private final C2991j f16505a;

            {
                this.f16505a = this;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return this.f16505a.m17945c() || str.charAt(0) != '.';
            }
        };
        this.f16492m = (ImageView) null;
        this.f16487h = C3262u.m19640b(n);
        this.f16490k = new HashMap();
        this.f16483d = new ArrayList();
        this.f16501v = new ArrayList();
        this.f16488i = new ArrayList();
        this.f16493n = false;
        this.f16494o = 0;
        this.f16495p = 0;
        this.f16496q = new ArrayList();
        this.f16497r = false;
        this.f16502w = new C3264w(n, this);
        this.f16499t = new a(this);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17929a() {
        mo17947d(this.f16486g.getAbsolutePath());
        mo17934a(this.f16486g);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: b */
    public C2981b mo17940b() {
        return this.f16481b;
    }

    /* renamed from: c */
    public boolean m17945c() {
        return C3102bd.f18269E;
    }

    /* renamed from: j */
    private int m17926j(String str) {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f16481b.m2879p(), "customCompator", "{}"));
        return c2468c.m15618g(str) ? c2468c.m15612c(str) : C3102bd.m18905a((Context) this.f16481b.m2879p(), "defaultCompator", 0);
    }

    /* renamed from: d */
    public void m17946d() {
        ActivityC0375f p = this.f16481b.m2879p();
        View inflate = LayoutInflater.from(p).inflate(R.layout.rename_one, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setText(this.f16486g.getAbsolutePath());
        editText.setHint(R.string.enter_path);
        TextView textView = (TextView) inflate.findViewById(R.id.renameoneTextView1);
        C3112bn.m19009a(textView, this.f16486g.getAbsolutePath());
        textView.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.fragment.b.j.2

            /* renamed from: a */
            private final C2991j f16527a;

            /* renamed from: b */
            private final EditText f16528b;

            {
                this.f16527a = this;
                this.f16528b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3112bn.m19007a(this.f16528b, (CharSequence) this.f16527a.f16486g.getAbsolutePath());
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener(this, p) { // from class: ru.maximoff.apktool.fragment.b.j.3

            /* renamed from: a */
            private final C2991j f16529a;

            /* renamed from: b */
            private final ActivityC0375f f16530b;

            {
                this.f16529a = this;
                this.f16530b = p;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f16530b, this.f16529a.f16486g.getAbsolutePath());
                return true;
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(p).m435b(inflate).m418a(R.string.enter_path).m420a(R.string.go_to, new DialogInterface.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.fragment.b.j.4

            /* renamed from: a */
            private final C2991j f16531a;

            /* renamed from: b */
            private final EditText f16532b;

            {
                this.f16531a = this;
                this.f16532b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f16531a.mo17934a(new File(this.f16532b.getText().toString()));
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, p, editText) { // from class: ru.maximoff.apktool.fragment.b.j.5

            /* renamed from: a */
            private final C2991j f16533a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16534b;

            /* renamed from: c */
            private final ActivityC0375f f16535c;

            /* renamed from: d */
            private final EditText f16536d;

            {
                this.f16533a = this;
                this.f16534b = m438b;
                this.f16535c = p;
                this.f16536d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16534b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f16535c, this.f16536d) { // from class: ru.maximoff.apktool.fragment.b.j.5.1

                    /* renamed from: a */
                    private final AnonymousClass5 f16537a;

                    /* renamed from: b */
                    private final ActivityC0375f f16538b;

                    /* renamed from: c */
                    private final EditText f16539c;

                    {
                        this.f16537a = this;
                        this.f16538b = r2;
                        this.f16539c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String m18991a = C3112bn.m18991a(this.f16538b);
                        if (m18991a != null) {
                            C3112bn.m19007a(this.f16539c, (CharSequence) m18991a);
                        } else {
                            C3112bn.m18999a(this.f16538b, R.string.empty);
                        }
                    }
                });
                this.f16536d.requestFocus();
                this.f16536d.selectAll();
            }
        });
        m438b.show();
        editText.addTextChangedListener(new TextWatcher(this, m438b.m414a(-1)) { // from class: ru.maximoff.apktool.fragment.b.j.6

            /* renamed from: a */
            private final C2991j f16540a;

            /* renamed from: b */
            private final Button f16541b;

            {
                this.f16540a = this;
                this.f16541b = r2;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16541b.setEnabled(false);
                } else if (!new File(editable.toString()).exists()) {
                    this.f16541b.setEnabled(false);
                } else {
                    this.f16541b.setEnabled(true);
                }
            }
        });
    }

    /* renamed from: e */
    public void m17948e() {
        ActivityC0375f p = this.f16481b.m2879p();
        View inflate = LayoutInflater.from(p).inflate(R.layout.rename_one, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setHint(R.string.name);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.renameoneImageView2);
        imageView.setVisibility(0);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_paste_light);
        } else {
            imageView.setImageResource(R.drawable.ic_paste_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, p, editText) { // from class: ru.maximoff.apktool.fragment.b.j.7

            /* renamed from: a */
            private final C2991j f16542a;

            /* renamed from: b */
            private final ActivityC0375f f16543b;

            /* renamed from: c */
            private final EditText f16544c;

            {
                this.f16542a = this;
                this.f16543b = p;
                this.f16544c = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f16543b);
                if (m18991a != null) {
                    C3112bn.m19007a(this.f16544c, (CharSequence) m18991a);
                } else {
                    C3112bn.m18999a(this.f16543b, R.string.empty);
                }
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, p, editText) { // from class: ru.maximoff.apktool.fragment.b.j.8

            /* renamed from: a */
            private final C2991j f16545a;

            /* renamed from: b */
            private final ActivityC0375f f16546b;

            /* renamed from: c */
            private final EditText f16547c;

            {
                this.f16545a = this;
                this.f16546b = p;
                this.f16547c = editText;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                String m18991a = C3112bn.m18991a(this.f16546b);
                if (m18991a == null) {
                    return false;
                }
                this.f16547c.setText(m18991a);
                this.f16547c.requestFocus();
                this.f16547c.setSelection(m18991a.length());
                return true;
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(p).m418a(R.string.madd).m435b(inflate).m420a(R.string.dir, new DialogInterface.OnClickListener(this, editText, p) { // from class: ru.maximoff.apktool.fragment.b.j.9

            /* renamed from: a */
            private final C2991j f16548a;

            /* renamed from: b */
            private final EditText f16549b;

            /* renamed from: c */
            private final ActivityC0375f f16550c;

            {
                this.f16548a = this;
                this.f16549b = editText;
                this.f16550c = p;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                File file;
                File file2 = new File(this.f16548a.f16486g, this.f16549b.getText().toString());
                if (file2.mkdirs()) {
                    file = file2.getParentFile();
                } else {
                    C3112bn.m18999a(this.f16550c, R.string.error);
                    file = this.f16548a.f16486g;
                }
                this.f16548a.mo17934a(file);
                this.f16548a.mo17937a(file2);
                this.f16548a.mo17944c(file2.getAbsolutePath());
            }
        }).m434b(R.string.file, new DialogInterface.OnClickListener(this, editText, p) { // from class: ru.maximoff.apktool.fragment.b.j.10

            /* renamed from: a */
            private final C2991j f16506a;

            /* renamed from: b */
            private final EditText f16507b;

            /* renamed from: c */
            private final ActivityC0375f f16508c;

            {
                this.f16506a = this;
                this.f16507b = editText;
                this.f16508c = p;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                File file;
                File file2 = new File(this.f16506a.f16486g, this.f16507b.getText().toString());
                try {
                    file2.getParentFile().mkdirs();
                    file2.createNewFile();
                    file = file2.getParentFile();
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f16508c, R.string.error);
                    file = this.f16506a.f16486g;
                }
                this.f16506a.mo17934a(file);
                this.f16506a.mo17937a(file2);
                this.f16506a.mo17944c(file2.getAbsolutePath());
            }
        }).m440c(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.fragment.b.j.11

            /* renamed from: a */
            private final C2991j f16509a;

            /* renamed from: b */
            private final EditText f16510b;

            {
                this.f16509a = this;
                this.f16510b = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16510b.requestFocus();
            }
        });
        m438b.show();
        Button m414a = m438b.m414a(-1);
        Button m414a2 = m438b.m414a(-2);
        editText.addTextChangedListener(new TextWatcher(this, m414a, m414a2) { // from class: ru.maximoff.apktool.fragment.b.j.12

            /* renamed from: a */
            private final C2991j f16511a;

            /* renamed from: b */
            private final Button f16512b;

            /* renamed from: c */
            private final Button f16513c;

            {
                this.f16511a = this;
                this.f16512b = m414a;
                this.f16513c = m414a2;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16512b.setEnabled(false);
                    this.f16513c.setEnabled(false);
                } else if (new File(this.f16511a.f16486g, editable.toString()).exists()) {
                    this.f16512b.setEnabled(false);
                    this.f16513c.setEnabled(false);
                } else {
                    this.f16512b.setEnabled(true);
                    this.f16513c.setEnabled(true);
                }
            }
        });
        m414a.setEnabled(false);
        m414a2.setEnabled(false);
    }

    /* renamed from: f */
    public void m17950f() {
        String m17978d = this.f16499t.m17978d(this.f16486g.getAbsolutePath());
        ActivityC0375f p = this.f16481b.m2879p();
        View inflate = LayoutInflater.from(p).inflate(R.layout.name_filter, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.namefilterEditText1);
        if (m17978d != null) {
            editText.setText(m17978d);
        }
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.namefilterCheckBox1);
        checkBox.setChecked(this.f16499t.m17975a());
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(p).m418a(R.string.name_filter).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, checkBox) { // from class: ru.maximoff.apktool.fragment.b.j.13

            /* renamed from: a */
            private final C2991j f16514a;

            /* renamed from: b */
            private final EditText f16515b;

            /* renamed from: c */
            private final CheckBox f16516c;

            {
                this.f16514a = this;
                this.f16515b = editText;
                this.f16516c = checkBox;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f16514a.f16499t.m17976b(this.f16515b.getText().toString());
                this.f16514a.f16499t.m17973a(this.f16514a.f16486g.getAbsolutePath());
                this.f16514a.f16499t.m17974a(this.f16516c.isChecked());
                dialogInterface.dismiss();
                this.f16514a.mo17929a();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new AnonymousClass14(this, editText, m438b, m17978d));
        m438b.show();
    }

    /* compiled from: FilesAdapter.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.j$14, reason: invalid class name */
    class AnonymousClass14 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C2991j f16517a;

        /* renamed from: b */
        private final EditText f16518b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f16519c;

        /* renamed from: d */
        private final String f16520d;

        AnonymousClass14(C2991j c2991j, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b, String str) {
            this.f16517a = c2991j;
            this.f16518b = editText;
            this.f16519c = dialogInterfaceC0070b;
            this.f16520d = str;
        }

        /* renamed from: a */
        static C2991j m17972a(AnonymousClass14 anonymousClass14) {
            return anonymousClass14.f16517a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f16518b.requestFocus();
            this.f16518b.selectAll();
            Button m414a = this.f16519c.m414a(-3);
            m414a.setEnabled(this.f16520d != null);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f16519c) { // from class: ru.maximoff.apktool.fragment.b.j.14.1

                /* renamed from: a */
                private final AnonymousClass14 f16521a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f16522b;

                {
                    this.f16521a = this;
                    this.f16522b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AnonymousClass14.m17972a(this.f16521a).f16499t.m17976b((String) null);
                    AnonymousClass14.m17972a(this.f16521a).f16499t.m17973a((String) null);
                    AnonymousClass14.m17972a(this.f16521a).f16499t.m17974a(false);
                    this.f16522b.cancel();
                    AnonymousClass14.m17972a(this.f16521a).mo17929a();
                }
            });
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17934a(File file) {
        String lowerCase;
        C2985d c2985d;
        int intValue;
        String lowerCase2;
        int i = 0;
        if (file == null) {
            file = this.f16486g;
        }
        if (file.isFile()) {
            mo17934a(file.getParentFile());
            mo17938a(file.getAbsolutePath());
            mo17944c(file.getAbsolutePath());
            return;
        }
        try {
            EnumC2989h.m17910a(m17926j(file.getAbsolutePath()));
        } catch (Exception e2) {
        }
        try {
            if (!this.f16496q.isEmpty()) {
                this.f16496q.clear();
            }
            this.f16486g = file;
            m17956i();
            C2985d c2985d2 = this.f16485f;
            if (c2985d2 != null && !c2985d2.m17878a(file)) {
                c2985d2 = (C2985d) null;
            }
            this.f16484e.setText(file.getAbsolutePath());
            m17927x();
            ActivityC0375f p = this.f16481b.m2879p();
            if (this.f16487h != null) {
                boolean z = !file.getAbsolutePath().equals("/");
                for (int i2 = 0; i2 < this.f16487h.length; i2++) {
                    if (this.f16486g.getAbsolutePath().equals(this.f16487h[i2])) {
                        z = false;
                    }
                }
                if (z) {
                    this.f16483d.add(new C2984c(p, file));
                }
            }
            this.f16503x = 0;
            this.f16504y = 0;
            File[] listFiles = file.listFiles(this.f16491l);
            File[] m18671a = (listFiles != null || C3262u.m19618a(this.f16487h, file)) ? listFiles : C3086ar.m18671a(p, file.getAbsolutePath(), m17945c());
            String m17977c = this.f16499t.m17977c(file.getAbsolutePath());
            if (m18671a != null && m18671a.length > 0) {
                c2985d = c2985d2;
                for (File file2 : m18671a) {
                    if (file2.isFile() || file2.isDirectory()) {
                        if (m17977c != null) {
                            if (this.f16499t.m17975a()) {
                                lowerCase2 = file2.getName();
                            } else {
                                lowerCase2 = file2.getName().toLowerCase();
                            }
                            if (lowerCase2.indexOf(m17977c) == -1 && !lowerCase2.matches(C3112bn.m19025c(m17977c))) {
                            }
                        }
                        if (file2.isDirectory()) {
                            this.f16503x++;
                        } else {
                            this.f16504y++;
                        }
                        this.f16483d.add(new C2990i(file2, p, this.f16500u.equals(file2.getAbsolutePath()), this.f16502w));
                        if (file2.isFile() && ((file2.getName().equals("apktool.json") || file2.getName().equals("apktool.yml")) && file.canWrite())) {
                            c2985d = new C2985d(file);
                        }
                    }
                }
            } else {
                if (this.f16499t.m17975a()) {
                    lowerCase = p.getPackageName();
                } else {
                    lowerCase = p.getPackageName().toLowerCase();
                }
                if (m17977c == null || lowerCase.indexOf(m17977c) != -1 || lowerCase.matches(C3112bn.m19025c(m17977c))) {
                    for (int i3 = 0; i3 < this.f16487h.length; i3++) {
                        if (this.f16486g.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(this.f16487h[i3]).append(C3249i.f19551k).toString())) {
                            File file3 = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f16487h[i3]).append(C3249i.f19551k).toString()).append("/").toString()).append(p.getPackageName()).toString());
                            this.f16483d.add(new C2990i(file3, p, this.f16500u.equals(file3.getAbsolutePath()), this.f16502w));
                            this.f16503x++;
                        }
                    }
                    if (this.f16486g.getAbsolutePath().equalsIgnoreCase(C3249i.f19550j)) {
                        File file4 = new File(new StringBuffer().append(new StringBuffer().append(C3249i.f19550j).append("/").toString()).append(p.getPackageName()).toString());
                        this.f16483d.add(new C2990i(file4, p, this.f16500u.equals(file4.getAbsolutePath()), this.f16502w));
                        this.f16503x++;
                    }
                    c2985d = c2985d2;
                } else {
                    c2985d = c2985d2;
                }
            }
            this.f16499t.m17973a(file.getAbsolutePath());
            this.f16499t.m17976b(m17977c);
            if (c2985d != null) {
                this.f16483d.add(c2985d);
            }
            this.f16485f = c2985d;
            Collections.sort(this.f16483d);
            m17969u();
            m17954h();
            if (C3102bd.m18925a((Context) p, "remember_path", false)) {
                C3102bd.m18937b(p, new StringBuffer().append("home_dir").append(this.f16495p > 0 ? new StringBuffer().append("_").append(this.f16495p).toString() : "").toString(), file.getAbsolutePath());
                if (Build.VERSION.SDK_INT >= 25) {
                    try {
                        new C3103be(p).m18955a();
                    } catch (Exception e3) {
                    }
                }
            }
            this.f16497r = false;
            if (this.f16489j != null) {
                if (!this.f16490k.isEmpty() && this.f16490k.containsKey(this.f16486g.getAbsolutePath()) && (intValue = this.f16490k.get(this.f16486g.getAbsolutePath()).intValue()) < this.f16483d.size()) {
                    i = intValue;
                }
                if (this.f16486g.getName().isEmpty()) {
                    this.f16482c.m18019a((CharSequence) this.f16486g.getAbsolutePath());
                } else {
                    this.f16482c.m18019a((CharSequence) this.f16486g.getName());
                }
                this.f16489j.setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, i) { // from class: ru.maximoff.apktool.fragment.b.j.15

                    /* renamed from: a */
                    private final C2991j f16523a;

                    /* renamed from: b */
                    private final int f16524b;

                    {
                        this.f16523a = this;
                        this.f16524b = i;
                    }

                    @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
                    /* renamed from: a */
                    public void mo16527a() {
                        this.f16523a.f16489j.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                        if (Build.VERSION.SDK_INT >= 21) {
                            View childAt = this.f16523a.f16489j.getChildAt(0);
                            this.f16523a.f16489j.setSelectionFromTop(this.f16524b, childAt == null ? 0 : childAt.getTop() - this.f16523a.f16489j.getPaddingTop());
                        } else {
                            this.f16523a.f16489j.setSelection(this.f16524b);
                        }
                    }
                });
                this.f16500u = file.getAbsolutePath();
                notifyDataSetChanged();
            }
        } catch (Exception e4) {
            try {
                C3112bn.m19023b(this.f16481b.m2879p(), this.f16481b.m2879p().getString(R.string.failed_open, file.getAbsolutePath()));
            } catch (Exception e5) {
            }
            if (!this.f16497r) {
                this.f16497r = true;
                mo17934a(this.f16480a);
            }
        }
    }

    /* renamed from: x */
    private void m17927x() {
        Iterator<InterfaceC2994m> it = this.f16483d.iterator();
        while (it.hasNext()) {
            it.next().mo17868b();
        }
        this.f16483d.clear();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: g */
    public File mo17952g() {
        return this.f16485f == null ? (File) null : this.f16485f.m17879f();
    }

    /* renamed from: a */
    public String m17928a(Context context) {
        String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.foldersc)).append(" ").toString()).append(this.f16503x).toString()).append(", ").toString()).append(context.getString(R.string.filesc)).toString()).append(" ").toString()).append(this.f16504y).toString();
        if (mo17970v()) {
            return new StringBuffer().append(stringBuffer).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(", ").append(context.getString(R.string.selected)).toString()).append(" ").toString()).append(this.f16488i.size()).toString()).toString();
        }
        return stringBuffer;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17937a(File... fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                this.f16496q.add(file.getAbsolutePath());
            }
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17935a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f16496q.add(it.next());
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17938a(String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                this.f16496q.add(str);
            }
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public boolean mo17939a(String str) {
        if (str != null) {
            return this.f16496q.contains(str);
        }
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: b */
    public boolean mo17943b(String str) {
        if (str != null) {
            return this.f16501v.contains(str);
        }
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: c */
    public void mo17944c(String str) {
        this.f16489j.setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, str) { // from class: ru.maximoff.apktool.fragment.b.j.16

            /* renamed from: a */
            private final C2991j f16525a;

            /* renamed from: b */
            private final String f16526b;

            {
                this.f16525a = this;
                this.f16526b = str;
            }

            @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
            /* renamed from: a */
            public void mo16527a() {
                this.f16525a.f16489j.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                for (int i = 0; i < this.f16525a.f16483d.size(); i++) {
                    String mo17871d = ((InterfaceC2994m) this.f16525a.f16483d.get(i)).mo17871d();
                    if (mo17871d != null && mo17871d.equals(this.f16526b)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            View childAt = this.f16525a.f16489j.getChildAt(0);
                            this.f16525a.f16489j.setSelectionFromTop(i, childAt != null ? childAt.getTop() - this.f16525a.f16489j.getPaddingTop() : 0);
                            return;
                        } else {
                            this.f16525a.f16489j.setSelection(i);
                            return;
                        }
                    }
                }
            }
        });
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16483d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return i > this.f16483d.size() + (-1) ? (Object) null : this.f16483d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i > this.f16483d.size() + (-1) ? 0 : this.f16483d.get(i).hashCode();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: d */
    public void mo17947d(String str) {
        if (this.f16489j != null) {
            Iterator<Map.Entry<String, Integer>> it = this.f16490k.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.length() > str.length() && key.startsWith(str)) {
                    it.remove();
                }
            }
            this.f16490k.put(str, new Integer(this.f16489j.getFirstVisiblePosition()));
        }
    }

    /* renamed from: a */
    public void m17932a(ImageView imageView) {
        this.f16492m = imageView;
    }

    /* renamed from: a */
    public void m17930a(int i) {
        this.f16495p = i;
    }

    /* renamed from: h */
    public void m17954h() {
        if (this.f16482c == null) {
            return;
        }
        this.f16482c.m18023a(mo17970v());
    }

    /* renamed from: i */
    public void m17956i() {
        this.f16501v.clear();
        if (this.f16492m == null) {
            return;
        }
        String m18910a = C3102bd.m18910a(this.f16481b.m2879p(), "copy_file_path", (String) null);
        if (m18910a == null) {
            this.f16492m.setVisibility(8);
            return;
        }
        this.f16492m.setVisibility(0);
        if (!C3262u.m19664g(this.f16481b.m2879p(), this.f16486g)) {
            this.f16492m.setImageResource(R.drawable.ic_paste_disable);
        } else if (C3102bd.f18291a) {
            this.f16492m.setImageResource(R.drawable.ic_paste_light);
        } else {
            this.f16492m.setImageResource(R.drawable.ic_paste_dark);
        }
        try {
            C2466a c2466a = new C2466a(m18910a);
            String m15579f = c2466a.m15579f(0);
            for (int i = 1; i < c2466a.m15569a(); i++) {
                this.f16501v.add(new StringBuffer().append(new StringBuffer().append(m15579f).append(File.separator).toString()).append(c2466a.m15579f(i)).toString());
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: j */
    public boolean m17958j() {
        if (this.f16493n) {
            m17969u();
            return true;
        }
        if (this.f16486g.getAbsolutePath().equals("/")) {
            return false;
        }
        if (this.f16487h != null) {
            for (int i = 0; i < this.f16487h.length; i++) {
                if (this.f16486g.getAbsolutePath().equals(this.f16487h[i])) {
                    return false;
                }
            }
        }
        if (this.f16486g.equals(this.f16480a)) {
            return false;
        }
        mo17934a(this.f16486g.getParentFile());
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: e */
    public void mo17949e(String str) {
        if (str != null) {
            if (mo17957i(str)) {
                this.f16488i.remove(str);
            } else {
                this.f16488i.add(str);
            }
            if (this.f16488i.isEmpty()) {
                m17969u();
                return;
            }
            this.f16493n = true;
            m17954h();
            notifyDataSetChanged();
        }
    }

    /* renamed from: f */
    public void m17951f(String str) {
        if (str != null) {
            if (mo17957i(str)) {
                this.f16488i.remove(str);
            } else {
                this.f16488i.add(str);
            }
            if (this.f16488i.isEmpty()) {
                m17969u();
            } else {
                this.f16493n = true;
            }
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: g */
    public void mo17953g(String str) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (!mo17970v()) {
            mo17949e(str);
            return;
        }
        int i5 = 0;
        while (true) {
            if (i5 < this.f16483d.size()) {
                String mo17871d = this.f16483d.get(i5).mo17871d();
                if (mo17871d != null && mo17871d.equals(str)) {
                    i = i5;
                    break;
                }
                i5++;
            } else {
                i = -1;
                break;
            }
        }
        if (i >= 0) {
            int i6 = -1;
            while (true) {
                if (i4 >= this.f16483d.size()) {
                    i2 = i;
                    break;
                }
                if (!mo17957i(this.f16483d.get(i4).mo17871d())) {
                    i3 = i6;
                } else if (i4 < i) {
                    i3 = i4;
                } else if (i6 < 0) {
                    int i7 = i;
                    while (i7 < i4) {
                        m17951f(this.f16483d.get(i7).mo17871d());
                        i7++;
                    }
                    i2 = i7;
                } else {
                    i2 = i;
                }
                i4++;
                i6 = i3;
            }
            if (i2 >= 0 && i6 >= 0) {
                while (i2 > i6) {
                    i6++;
                    m17951f(this.f16483d.get(i6).mo17871d());
                }
            }
            m17954h();
            notifyDataSetChanged();
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: k */
    public List<String> mo17959k() {
        return this.f16488i;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: l */
    public File[] mo17960l() {
        File[] fileArr = new File[this.f16488i.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16488i.size()) {
                fileArr[i2] = new File(this.f16488i.get(i2));
                i = i2 + 1;
            } else {
                return fileArr;
            }
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: m */
    public boolean mo17961m() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".apk")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: n */
    public boolean mo17962n() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".dex")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: o */
    public boolean mo17963o() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".jar")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: p */
    public boolean mo17964p() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".xml")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: q */
    public boolean mo17965q() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".svg")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: r */
    public boolean mo17966r() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".png")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: s */
    public boolean mo17967s() {
        if (this.f16488i.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f16488i.size(); i++) {
            if (!this.f16488i.get(i).toLowerCase().endsWith(".smali")) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: t */
    public boolean mo17968t() {
        boolean z;
        if (this.f16488i.isEmpty()) {
            return false;
        }
        String[] strArr = {"gif", "png", "jpg", "jpeg", "bmp", "webp"};
        for (int i = 0; i < this.f16488i.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z = false;
                    break;
                }
                if (this.f16488i.get(i).toLowerCase().endsWith(new StringBuffer().append(".").append(strArr[i2]).toString())) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: a */
    public void mo17936a(boolean z) {
        if (!z) {
            this.f16488i.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16483d.size()) {
                m17951f(this.f16483d.get(i2).mo17871d());
                i = i2 + 1;
            } else {
                m17954h();
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: h */
    public void m17955h(String str) {
        if (str == null || str.isEmpty()) {
            mo17936a(true);
            return;
        }
        this.f16488i.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16483d.size()) {
                String mo17871d = this.f16483d.get(i2).mo17871d();
                if (mo17871d != null && mo17871d.toLowerCase().endsWith(new StringBuffer().append(".").append(str.toLowerCase()).toString())) {
                    m17951f(mo17871d);
                }
                i = i2 + 1;
            } else {
                m17954h();
                notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: u */
    public void m17969u() {
        this.f16493n = false;
        if (this.f16494o == 0) {
            this.f16488i.clear();
        }
        m17954h();
        notifyDataSetChanged();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: i */
    public boolean mo17957i(String str) {
        if (str == null || this.f16488i.isEmpty()) {
            return false;
        }
        return this.f16488i.contains(str);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2995n
    /* renamed from: v */
    public boolean mo17970v() {
        return this.f16493n;
    }

    /* renamed from: w */
    public void m17971w() {
        m17954h();
        m17956i();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16483d.size()) {
                String mo17871d = this.f16483d.get(i2).mo17871d();
                if (mo17871d != null && !new File(mo17871d).exists()) {
                    this.f16483d.remove(i2);
                    if (mo17957i(mo17871d)) {
                        this.f16488i.remove(mo17871d);
                    }
                }
                i = i2 + 1;
            } else {
                C2918at.m17334e();
                C2919au.m17346e();
                super.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3302d c3302d;
        View view2;
        if (view == null) {
            view2 = this.f16481b.m2775B().inflate(R.layout.files_entry, viewGroup, false);
            C3302d c3302d2 = new C3302d();
            c3302d2.f20968e = (TextView) view2.findViewById(R.id.name);
            c3302d2.f20969f = (TextView) view2.findViewById(R.id.details);
            c3302d2.f20967d = (ImageView) view2.findViewById(R.id.icon);
            c3302d2.f20966c = (ProgressBar) view2.findViewById(R.id.progress);
            view2.setTag(c3302d2);
            c3302d = c3302d2;
        } else {
            c3302d = (C3302d) view.getTag();
            view2 = view;
        }
        c3302d.f20964a = i;
        c3302d.f20968e.setTextSize(2, C3102bd.f18332o);
        c3302d.f20969f.setTextSize(2, C3102bd.m18927b());
        c3302d.f20967d.setVisibility(0);
        c3302d.f20966c.setVisibility(8);
        InterfaceC2994m interfaceC2994m = this.f16483d.get(i);
        interfaceC2994m.mo17864a(view2, c3302d.f20967d, c3302d.f20968e, c3302d.f20969f, this);
        if (interfaceC2994m.mo17870c()) {
            interfaceC2994m.mo17863a();
        }
        return view2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        InterfaceC2994m interfaceC2994m = this.f16483d.get(i);
        interfaceC2994m.mo17868b();
        if ((mo17970v() || !interfaceC2994m.mo17867a(this.f16481b)) && !interfaceC2994m.mo17866a(view, this)) {
            interfaceC2994m.mo17865a(this);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        InterfaceC2994m interfaceC2994m = this.f16483d.get(i);
        interfaceC2994m.mo17868b();
        return interfaceC2994m.mo17869b(view, this);
    }

    /* renamed from: a */
    public void m17931a(Bundle bundle) {
        if (this.f16486g == null || bundle == null) {
            return;
        }
        bundle.putString(new StringBuffer().append("CUR_DIR_PATH").append(this.f16495p > 0 ? new StringBuffer().append("_").append(this.f16495p).toString() : "").toString(), this.f16486g.getAbsolutePath());
    }

    /* renamed from: b */
    public void m17942b(String[] strArr) {
        this.f16487h = strArr;
    }

    /* renamed from: b */
    public void m17941b(Bundle bundle) {
        File file = new File(C3102bd.m18909a(this.f16481b.m2879p(), this.f16495p, this.f16487h));
        File file2 = (file.exists() && file.isDirectory()) ? file : this.f16480a;
        if (bundle != null) {
            mo17934a(new File(bundle.getString(new StringBuffer().append("CUR_DIR_PATH").append(this.f16495p > 0 ? new StringBuffer().append("_").append(this.f16495p).toString() : "").toString(), file2.getAbsolutePath())));
            return;
        }
        File file3 = new File(C3102bd.f18337t);
        if (this.f16495p == 0 && file3.exists() && file3.isDirectory()) {
            mo17934a(file3);
        } else {
            mo17934a(file2);
        }
    }

    /* renamed from: a */
    public void m17933a(ListView listView) {
        this.f16489j = (CustomListView) listView;
        listView.setAdapter((ListAdapter) this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    /* compiled from: FilesAdapter.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.j$a */
    private class a {

        /* renamed from: a */
        private String f16551a;

        /* renamed from: b */
        private String f16552b;

        /* renamed from: c */
        private boolean f16553c = false;

        /* renamed from: d */
        private final C2991j f16554d;

        public a(C2991j c2991j) {
            this.f16554d = c2991j;
        }

        /* renamed from: a */
        public void m17973a(String str) {
            this.f16551a = str;
        }

        /* renamed from: b */
        public void m17976b(String str) {
            this.f16552b = str;
        }

        /* renamed from: a */
        public void m17974a(boolean z) {
            this.f16553c = z;
        }

        /* renamed from: c */
        public String m17977c(String str) {
            if (this.f16551a == null || str == null || this.f16552b == null || !this.f16551a.equals(str)) {
                return (String) null;
            }
            return this.f16553c ? this.f16552b : this.f16552b.toLowerCase();
        }

        /* renamed from: d */
        public String m17978d(String str) {
            return (this.f16551a == null || str == null || !this.f16551a.equals(str)) ? (String) null : this.f16552b;
        }

        /* renamed from: a */
        public boolean m17975a() {
            return this.f16553c;
        }
    }
}
