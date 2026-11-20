package ru.maximoff.apktool;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.p008os.AsyncTask;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.C0035a;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1386h;
import com.p159h.p160a.p162b.C1396r;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p046b.p047a.p050c.p051a.C0497h;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;
import p060c.p061a.p062a.C0550f;
import ru.maximoff.apktool.p296a.C2893m;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.service.C3055a;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3254n;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.apktool.view.Editor;
import ru.maximoff.color.C3321c;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* loaded from: classes.dex */
public class AxmlEdit extends AbstractActivityC2894b {

    /* renamed from: j */
    private File f13590j;

    /* renamed from: k */
    private String f13591k;

    /* renamed from: l */
    private String f13592l;

    /* renamed from: m */
    private boolean f13593m;

    /* renamed from: n */
    private boolean f13594n;

    /* renamed from: o */
    private String f13595o;

    /* renamed from: p */
    private CheckBox f13596p;

    /* renamed from: q */
    private EditText f13597q;

    /* renamed from: r */
    private LinearLayout f13598r;

    /* renamed from: s */
    private CheckBox f13599s;

    /* renamed from: t */
    private List<C2650b> f13600t;

    /* renamed from: u */
    private C2649a f13601u;

    /* renamed from: w */
    private boolean f13603w;

    /* renamed from: x */
    private boolean f13604x;

    /* renamed from: h */
    private final String f13588h = "http://schemas.android.com/apk/res/android";

    /* renamed from: i */
    private int f13589i = 0;

    /* renamed from: v */
    private long f13602v = 0;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f13590j != null) {
            bundle.putString("PROJECT_FILE", this.f13590j.getAbsolutePath());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("PROJECT_FILE", (String) null);
        if (string != null) {
            this.f13590j = new File(string);
        }
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.translate);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("data")) {
            C3112bn.m19023b(this, getString(R.string.errorf, getString(R.string.no_data)));
            finish();
            return;
        }
        try {
            if (intent.hasExtra("apk_path")) {
                this.f13591k = intent.getStringExtra("apk_path");
                this.f13592l = intent.getStringExtra("data");
                C2604w c2604w = new C2604w(this.f13591k);
                C2602u m16162a = c2604w.m16162a(this.f13592l);
                this.f13590j = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                C1887e.m13962a(new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a()), new FileOutputStream(this.f13590j));
            } else {
                this.f13591k = (String) null;
                this.f13592l = (String) null;
                this.f13590j = new File(intent.getStringExtra("data"));
            }
            findViewById(R.id.translateLinearLayout2).setVisibility(8);
            findViewById(R.id.translateView1).setVisibility(8);
            this.f13600t = new ArrayList();
            try {
                m16407p();
                if (this.f13600t.isEmpty()) {
                    C3112bn.m18999a(this, R.string.not_found);
                    finish();
                    return;
                }
                this.f13603w = C3102bd.m18925a((Context) this, "axml_line_num", true);
                this.f13604x = C3102bd.m18925a((Context) this, "axml_backup", true);
                this.f13595o = "";
                this.f13593m = false;
                this.f13594n = false;
                ImageView imageView = (ImageView) findViewById(R.id.clearText1);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_close);
                } else {
                    imageView.setImageResource(R.drawable.ic_close_dark);
                }
                this.f13598r = (LinearLayout) findViewById(R.id.translateLinearLayout1);
                this.f13597q = (EditText) findViewById(R.id.translateEditText1);
                this.f13596p = (CheckBox) findViewById(R.id.translateCheckBox1);
                this.f13596p.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.1

                    /* renamed from: a */
                    private final AxmlEdit f13605a;

                    {
                        this.f13605a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f13605a.f13593m = this.f13605a.f13596p.isChecked();
                        this.f13605a.m16377a(this.f13605a.f13595o);
                    }
                });
                this.f13599s = (CheckBox) findViewById(R.id.translateCheckBox2);
                this.f13599s.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.2

                    /* renamed from: a */
                    private final AxmlEdit f13635a;

                    {
                        this.f13635a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f13635a.f13594n = this.f13635a.f13599s.isChecked();
                        this.f13635a.m16377a(this.f13635a.f13595o);
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.3

                    /* renamed from: a */
                    private final AxmlEdit f13673a;

                    {
                        this.f13673a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f13673a.f13597q.requestFocus();
                        this.f13673a.f13597q.setText("");
                    }
                });
                if (this.f13597q.getText().length() == 0) {
                    imageView.setVisibility(8);
                }
                C3112bn.m19006a(this.f13597q, 10000);
                this.f13597q.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.AxmlEdit.4

                    /* renamed from: a */
                    private final AxmlEdit f13684a;

                    /* renamed from: b */
                    private final ImageView f13685b;

                    {
                        this.f13684a = this;
                        this.f13685b = imageView;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (this.f13684a.f13601u != null) {
                            if (editable.length() == 0) {
                                this.f13685b.setVisibility(8);
                            } else {
                                this.f13685b.setVisibility(0);
                            }
                            this.f13684a.m16377a(editable.toString());
                            this.f13684a.f13597q.requestFocus();
                        }
                    }
                });
                C3212b c3212b = new C3212b(this, "axml_editor");
                ImageView imageView2 = (ImageView) findViewById(R.id.translateImageView1);
                if (C3102bd.f18291a) {
                    imageView2.setImageResource(R.drawable.ic_collapse);
                } else {
                    imageView2.setImageResource(R.drawable.ic_collapse_dark);
                }
                if (c3212b.m19205b().isEmpty()) {
                    imageView2.setVisibility(8);
                } else {
                    imageView2.setVisibility(0);
                }
                imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.AxmlEdit.5

                    /* renamed from: a */
                    private final AxmlEdit f13686a;

                    /* renamed from: b */
                    private final C3212b f13687b;

                    /* renamed from: c */
                    private final ImageView f13688c;

                    {
                        this.f13686a = this;
                        this.f13687b = c3212b;
                        this.f13688c = imageView2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f13687b.m19201a(this.f13688c, this.f13686a.f13597q);
                    }
                });
                imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.AxmlEdit.6

                    /* renamed from: a */
                    private final AxmlEdit f13689a;

                    /* renamed from: b */
                    private final C3212b f13690b;

                    /* renamed from: c */
                    private final ImageView f13691c;

                    {
                        this.f13689a = this;
                        this.f13690b = c3212b;
                        this.f13691c = imageView2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        new C3078aj(this.f13689a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13690b, this.f13691c) { // from class: ru.maximoff.apktool.AxmlEdit.6.1

                            /* renamed from: a */
                            private final ViewOnLongClickListenerC26456 f13692a;

                            /* renamed from: b */
                            private final C3212b f13693b;

                            /* renamed from: c */
                            private final ImageView f13694c;

                            {
                                this.f13692a = this;
                                this.f13693b = r2;
                                this.f13694c = r3;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f13693b.m19208d();
                                this.f13694c.setVisibility(8);
                            }
                        }).m18508e(R.string.cancel).m18507d();
                        return true;
                    }
                });
                this.f13597q.setImeOptions(3);
                this.f13597q.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.AxmlEdit.7

                    /* renamed from: a */
                    private final AxmlEdit f13695a;

                    /* renamed from: b */
                    private final C3212b f13696b;

                    /* renamed from: c */
                    private final ImageView f13697c;

                    {
                        this.f13695a = this;
                        this.f13696b = c3212b;
                        this.f13697c = imageView2;
                    }

                    @Override // android.widget.TextView.OnEditorActionListener
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i != 3) {
                            return false;
                        }
                        if (this.f13696b.m19204a(this.f13695a.f13597q.getText().toString())) {
                            this.f13697c.setVisibility(0);
                        }
                        return true;
                    }
                });
                CustomListView customListView = (CustomListView) findViewById(R.id.translateListView1);
                customListView.setFastScrollEnabled(C3102bd.f18314av);
                this.f13601u = new C2649a(this, this);
                this.f13601u.m16427a(this.f13600t);
                customListView.setAdapter((ListAdapter) this.f13601u);
            } catch (Exception e2) {
                C3112bn.m19023b(this, getString(R.string.errorf, e2.getMessage()));
                finish();
            }
        } catch (Exception e3) {
            C3112bn.m19023b(this, getString(R.string.errorf, e3.getMessage()));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m16407p() {
        this.f13589i = 0;
        this.f13600t.clear();
        new C0546b(C1887e.m13984b(new FileInputStream(this.f13590j))).m4018a(new C2655g(this, this, new C0547c(), false, new HashMap(), (String) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m16373a(File file) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        c0546b.m4018a(new C3254n(new C0547c(), getResources(), 0, new HashMap(), new ArrayList(), sb, (String) null));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16376a(File file, boolean z) {
        this.f13589i = 0;
        FileInputStream fileInputStream = new FileInputStream(this.f13590j);
        C0548d c0548d = new C0548d();
        new C0546b(C1887e.m13984b(fileInputStream)).m4018a(new C2655g(this, this, new C0547c(c0548d), true));
        if (z && this.f13591k == null) {
            File file2 = new File(new StringBuffer().append(this.f13590j.getAbsolutePath()).append(".bak").toString());
            if (file2.isFile()) {
                file2.delete();
            }
            C3262u.m19613a(this.f13590j, file2, true);
        }
        byte[] m4026b = c0548d.m4026b();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(m4026b);
        fileOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16378a(String str, File file) {
        AbstractRunnableC1391m c2893m;
        boolean[] zArr = {C3102bd.m18925a((Context) this, "preview_word_wrap", false)};
        C1386h c1386h = new C1386h();
        Editor editor = new Editor(this);
        if (C3102bd.f18287W) {
            c2893m = C1396r.f9139c;
        } else {
            c2893m = new C2893m((C3055a) null);
        }
        editor.setLexTask(c2893m);
        editor.setDocumentProvider(c1386h);
        editor.m19756h(false);
        editor.setCharset("UTF-8");
        editor.setEditable(false);
        editor.setWordWrap(zArr[0]);
        editor.m10868a(2);
        c1386h.m11038a(str);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.preview).m435b(editor).m420a(R.string.close_cur, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.8

            /* renamed from: a */
            private final AxmlEdit f13698a;

            {
                this.f13698a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).m440c(R.string.editor_wordwrap, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC26489(this, m438b, zArr, editor));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this, file) { // from class: ru.maximoff.apktool.AxmlEdit.10

            /* renamed from: a */
            private final AxmlEdit f13606a;

            /* renamed from: b */
            private final File f13607b;

            {
                this.f13606a = this;
                this.f13607b = file;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f13607b.delete();
            }
        });
        m438b.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(m438b.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        m438b.getWindow().setAttributes(layoutParams);
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$9 */
    class DialogInterfaceOnShowListenerC26489 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AxmlEdit f13699a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f13700b;

        /* renamed from: c */
        private final boolean[] f13701c;

        /* renamed from: d */
        private final Editor f13702d;

        DialogInterfaceOnShowListenerC26489(AxmlEdit axmlEdit, DialogInterfaceC0070b dialogInterfaceC0070b, boolean[] zArr, Editor editor) {
            this.f13699a = axmlEdit;
            this.f13700b = dialogInterfaceC0070b;
            this.f13701c = zArr;
            this.f13702d = editor;
        }

        /* renamed from: a */
        static AxmlEdit m16423a(DialogInterfaceOnShowListenerC26489 dialogInterfaceOnShowListenerC26489) {
            return dialogInterfaceOnShowListenerC26489.f13699a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f13700b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f13701c, this.f13702d) { // from class: ru.maximoff.apktool.AxmlEdit.9.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC26489 f13703a;

                /* renamed from: b */
                private final boolean[] f13704b;

                /* renamed from: c */
                private final Editor f13705c;

                {
                    this.f13703a = this;
                    this.f13704b = r2;
                    this.f13705c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13704b[0] = !this.f13704b[0];
                    C3102bd.m18938b(DialogInterfaceOnShowListenerC26489.m16423a(this.f13703a), "preview_word_wrap", this.f13704b[0]);
                    int caretPosition = this.f13705c.getCaretPosition();
                    this.f13705c.setWordWrap(this.f13704b[0]);
                    this.f13705c.m10883c();
                    this.f13705c.m10860G();
                    this.f13705c.m10897g();
                    this.f13705c.requestFocus();
                    this.f13705c.postDelayed(new Runnable(this, this.f13705c, caretPosition) { // from class: ru.maximoff.apktool.AxmlEdit.9.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f13706a;

                        /* renamed from: b */
                        private final Editor f13707b;

                        /* renamed from: c */
                        private final int f13708c;

                        {
                            this.f13706a = this;
                            this.f13707b = r2;
                            this.f13708c = caretPosition;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f13707b.m10874a(true);
                            this.f13707b.m10901h(this.f13708c);
                        }
                    }, 100L);
                }
            });
            this.f13702d.m10883c();
            this.f13702d.m10860G();
            this.f13702d.m10897g();
            this.f13702d.requestFocus();
        }
    }

    /* renamed from: o */
    public void m16418o() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.AxmlEdit.11

            /* renamed from: a */
            private final AxmlEdit f13608a;

            {
                this.f13608a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                String name;
                if (this.f13608a.f13591k != null) {
                    int lastIndexOf = this.f13608a.f13592l.lastIndexOf(47);
                    if (lastIndexOf == -1) {
                        name = this.f13608a.f13592l;
                    } else {
                        name = this.f13608a.f13592l.substring(lastIndexOf + 1);
                    }
                } else {
                    name = this.f13608a.f13590j.getName();
                }
                if (this.f13608a.m16410s()) {
                    name = new StringBuffer().append("*").append(name).toString();
                }
                this.f13608a.m454f().mo390a(name);
            }
        }, 100L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.axml_editor, menu);
        menu.findItem(R.id.line_num).setChecked(this.f13603w);
        menu.findItem(R.id.backup).setChecked(this.f13604x);
        menu.findItem(R.id.save).setEnabled(this.f13590j.canWrite());
        menu.findItem(R.id.reset).setVisible(m16410s());
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.reset).setVisible(m16410s());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.save /* 2131690189 */:
                m16391b(false);
                break;
            case R.id.reset /* 2131690190 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.search_reset).m433b(R.string.mtr_sure).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.13

                    /* renamed from: a */
                    private final AxmlEdit f13610a;

                    {
                        this.f13610a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < this.f13610a.f13600t.size()) {
                                ((C2650b) this.f13610a.f13600t.get(i3)).m16429a();
                                i2 = i3 + 1;
                            } else {
                                this.f13610a.m16377a(this.f13610a.f13595o);
                                this.f13610a.invalidateOptionsMenu();
                                dialogInterface.cancel();
                                return;
                            }
                        }
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.search /* 2131690191 */:
                if (this.f13598r.getVisibility() == 8) {
                    this.f13598r.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.AxmlEdit.12

                        /* renamed from: a */
                        private final AxmlEdit f13609a;

                        {
                            this.f13609a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f13609a.f13597q.requestFocus();
                            ((InputMethodManager) this.f13609a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f13609a.f13597q, 1);
                            this.f13609a.f13597q.selectAll();
                        }
                    }, 100L);
                    break;
                } else {
                    this.f13598r.setVisibility(8);
                    m16377a("");
                    break;
                }
            case R.id.replace /* 2131690192 */:
                m16408q();
                break;
            case R.id.line_num /* 2131690193 */:
                this.f13603w = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "axml_line_num", this.f13603w);
                invalidateOptionsMenu();
                this.f13601u.notifyDataSetChanged();
                break;
            case R.id.backup /* 2131690194 */:
                this.f13604x = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "axml_backup", this.f13604x);
                invalidateOptionsMenu();
                break;
            case R.id.prop /* 2131690195 */:
                m16409r();
                break;
            case R.id.dump /* 2131690196 */:
                try {
                    new AsyncTaskC2651c(this, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, File.createTempFile("AXMLE", ".xml", C3102bd.m18908a()));
                    break;
                } catch (Exception e2) {
                    C3112bn.m18999a(this, R.string.error);
                    break;
                }
            case R.id.exit /* 2131690197 */:
                m16414a(true);
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: q */
    private void m16408q() {
        if (this.f13600t.isEmpty()) {
            C3112bn.m18999a(this, R.string.not_found);
            return;
        }
        Button[] buttonArr = new Button[1];
        View inflate = getLayoutInflater().inflate(R.layout.translate_replace, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.translatereplaceEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.translatereplaceEditText2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.translatereplaceCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.translatereplaceCheckBox2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.translatereplaceImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.translatereplaceImageView2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.clearText1);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.clearText2);
        C3112bn.m19006a(editText, 10000);
        C3112bn.m19006a(editText2, 10000);
        if (C3102bd.f18291a) {
            imageView3.setImageResource(R.drawable.ic_close);
            imageView4.setImageResource(R.drawable.ic_close);
            imageView.setImageResource(R.drawable.ic_collapse);
            imageView2.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView3.setImageResource(R.drawable.ic_close_dark);
            imageView4.setImageResource(R.drawable.ic_close_dark);
            imageView.setImageResource(R.drawable.ic_collapse_dark);
            imageView2.setImageResource(R.drawable.ic_collapse_dark);
        }
        checkBox.setChecked(C3102bd.m18925a((Context) this, "axml_repl_regex", false));
        checkBox2.setChecked(C3102bd.m18925a((Context) this, "axml_repl_sens", false));
        C3212b c3212b = new C3212b(this, "axml_editor");
        if (c3212b.m19205b().isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView, editText) { // from class: ru.maximoff.apktool.AxmlEdit.14

            /* renamed from: a */
            private final AxmlEdit f13611a;

            /* renamed from: b */
            private final C3212b f13612b;

            /* renamed from: c */
            private final ImageView f13613c;

            /* renamed from: d */
            private final EditText f13614d;

            {
                this.f13611a = this;
                this.f13612b = c3212b;
                this.f13613c = imageView;
                this.f13614d = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13612b.m19201a(this.f13613c, this.f13614d);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.AxmlEdit.15

            /* renamed from: a */
            private final AxmlEdit f13615a;

            /* renamed from: b */
            private final C3212b f13616b;

            /* renamed from: c */
            private final ImageView f13617c;

            {
                this.f13615a = this;
                this.f13616b = c3212b;
                this.f13617c = imageView;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f13615a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13616b, this.f13617c) { // from class: ru.maximoff.apktool.AxmlEdit.15.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC262115 f13618a;

                    /* renamed from: b */
                    private final C3212b f13619b;

                    /* renamed from: c */
                    private final ImageView f13620c;

                    {
                        this.f13618a = this;
                        this.f13619b = r2;
                        this.f13620c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f13619b.m19208d();
                        this.f13620c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        C3212b c3212b2 = new C3212b(this, "axml_editor_repl");
        if (c3212b2.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.AxmlEdit.16

            /* renamed from: a */
            private final AxmlEdit f13621a;

            /* renamed from: b */
            private final C3212b f13622b;

            /* renamed from: c */
            private final ImageView f13623c;

            /* renamed from: d */
            private final EditText f13624d;

            {
                this.f13621a = this;
                this.f13622b = c3212b2;
                this.f13623c = imageView2;
                this.f13624d = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13622b.m19201a(this.f13623c, this.f13624d);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b2, imageView2) { // from class: ru.maximoff.apktool.AxmlEdit.17

            /* renamed from: a */
            private final AxmlEdit f13625a;

            /* renamed from: b */
            private final C3212b f13626b;

            /* renamed from: c */
            private final ImageView f13627c;

            {
                this.f13625a = this;
                this.f13626b = c3212b2;
                this.f13627c = imageView2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f13625a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13626b, this.f13627c) { // from class: ru.maximoff.apktool.AxmlEdit.17.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC262317 f13628a;

                    /* renamed from: b */
                    private final C3212b f13629b;

                    /* renamed from: c */
                    private final ImageView f13630c;

                    {
                        this.f13628a = this;
                        this.f13629b = r2;
                        this.f13630c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f13629b.m19208d();
                        this.f13630c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.AxmlEdit.18

            /* renamed from: a */
            private final AxmlEdit f13631a;

            /* renamed from: b */
            private final EditText f13632b;

            {
                this.f13631a = this;
                this.f13632b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13632b.requestFocus();
                this.f13632b.setText("");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.AxmlEdit.19

            /* renamed from: a */
            private final AxmlEdit f13633a;

            /* renamed from: b */
            private final EditText f13634b;

            {
                this.f13633a = this;
                this.f13634b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13634b.requestFocus();
                this.f13634b.setText("");
            }
        });
        imageView3.setVisibility(8);
        imageView4.setVisibility(8);
        editText.addTextChangedListener(new TextWatcher(this, buttonArr, imageView3) { // from class: ru.maximoff.apktool.AxmlEdit.20

            /* renamed from: a */
            private final AxmlEdit f13636a;

            /* renamed from: b */
            private final Button[] f13637b;

            /* renamed from: c */
            private final ImageView f13638c;

            {
                this.f13636a = this;
                this.f13637b = buttonArr;
                this.f13638c = imageView3;
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
                    if (this.f13637b[0] != null) {
                        this.f13637b[0].setEnabled(false);
                    }
                    this.f13638c.setVisibility(8);
                } else {
                    if (this.f13637b[0] != null) {
                        this.f13637b[0].setEnabled(true);
                    }
                    this.f13638c.setVisibility(0);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this, imageView4) { // from class: ru.maximoff.apktool.AxmlEdit.21

            /* renamed from: a */
            private final AxmlEdit f13639a;

            /* renamed from: b */
            private final ImageView f13640b;

            {
                this.f13639a = this;
                this.f13640b = imageView4;
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
                    this.f13640b.setVisibility(8);
                } else {
                    this.f13640b.setVisibility(0);
                }
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.replace).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, editText2, checkBox, checkBox2, c3212b, c3212b2) { // from class: ru.maximoff.apktool.AxmlEdit.22

            /* renamed from: a */
            private final AxmlEdit f13641a;

            /* renamed from: b */
            private final EditText f13642b;

            /* renamed from: c */
            private final EditText f13643c;

            /* renamed from: d */
            private final CheckBox f13644d;

            /* renamed from: e */
            private final CheckBox f13645e;

            /* renamed from: f */
            private final C3212b f13646f;

            /* renamed from: g */
            private final C3212b f13647g;

            {
                this.f13641a = this;
                this.f13642b = editText;
                this.f13643c = editText2;
                this.f13644d = checkBox;
                this.f13645e = checkBox2;
                this.f13646f = c3212b;
                this.f13647g = c3212b2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                String editable = this.f13642b.getText().toString();
                String editable2 = this.f13643c.getText().toString();
                boolean isChecked = this.f13644d.isChecked();
                boolean isChecked2 = this.f13645e.isChecked();
                this.f13646f.m19204a(editable);
                this.f13647g.m19204a(editable2);
                C3102bd.m18938b(this.f13641a, "axml_repl_regex", isChecked);
                C3102bd.m18938b(this.f13641a, "axml_repl_sens", isChecked2);
                new AsyncTaskC2652d(this.f13641a, editable, editable2, isChecked, isChecked2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.AxmlEdit.23

            /* renamed from: a */
            private final AxmlEdit f13648a;

            /* renamed from: b */
            private final Button[] f13649b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f13650c;

            /* renamed from: d */
            private final EditText f13651d;

            {
                this.f13648a = this;
                this.f13649b = buttonArr;
                this.f13650c = m438b;
                this.f13651d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f13649b[0] = this.f13650c.m414a(-1);
                this.f13649b[0].setEnabled(false);
                this.f13651d.requestFocus();
                this.f13651d.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: r */
    private void m16409r() {
        String absolutePath;
        if (this.f13591k != null) {
            absolutePath = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13591k).append(" (").toString()).append(this.f13592l).toString()).append(")").toString();
        } else {
            absolutePath = this.f13590j.getAbsolutePath();
        }
        new DialogInterfaceC0070b.a(this).m418a(R.string.properties).m436b(getString(R.string.axml_prop, absolutePath, C3106bh.m18975a(this.f13590j.length(), C3102bd.f18305am), String.valueOf(this.f13600t.size()), String.valueOf(m16411t()))).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16377a(String str) {
        this.f13595o = str;
        if (C3112bn.m19040o(str)) {
            this.f13601u.m16427a(this.f13600t);
            return;
        }
        if (!this.f13594n) {
            str = str.toLowerCase();
        }
        ArrayList arrayList = new ArrayList();
        for (C2650b c2650b : this.f13600t) {
            String str2 = c2650b.f13731g;
            String str3 = c2650b.f13732h;
            String m19017b = C3112bn.m19017b((CharSequence) c2650b.toString());
            if (!this.f13594n) {
                str2 = str2.toLowerCase();
                str3 = str3.toLowerCase();
                m19017b = m19017b.toLowerCase();
            }
            if (this.f13593m) {
                if (str2.equals(str) || m19017b.equals(str) || str3.equals(str)) {
                    arrayList.add(c2650b);
                }
            } else if (str2.contains(str) || m19017b.contains(str)) {
                arrayList.add(c2650b);
            }
        }
        this.f13601u.m16427a(arrayList);
    }

    /* renamed from: a */
    public boolean m16415a(C2650b c2650b) {
        return c2650b.f13732h.matches("^android:(text|value|title|label|summary|contentDescription|candidatesTextStyleSpans|autofillHints|knownCerts|knownActivityEmbeddingCerts|versionName)$") && (c2650b.f13727c == 1 || c2650b.f13727c == 3);
    }

    /* renamed from: b */
    public boolean m16416b(C2650b c2650b) {
        if (c2650b.f13727c != 5 && c2650b.f13727c != 16) {
            return false;
        }
        int identifier = getResources().getIdentifier("layout_width", C0497h.f3457a, "android");
        if (identifier == 0) {
            identifier = C0012R.attr.layout_width;
        }
        int identifier2 = getResources().getIdentifier("layout_height", C0497h.f3457a, "android");
        if (identifier2 == 0) {
            identifier2 = C0012R.attr.layout_height;
        }
        return c2650b.f13726b == identifier || c2650b.f13726b == identifier2;
    }

    /* renamed from: c */
    public boolean m16417c(C2650b c2650b) {
        if (c2650b.f13727c != 16) {
            return false;
        }
        int identifier = getResources().getIdentifier(MediaStore.MediaColumns.ORIENTATION, C0497h.f3457a, "android");
        if (identifier == 0) {
            identifier = C0012R.attr.orientation;
        }
        return c2650b.f13726b == identifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public boolean m16410s() {
        for (C2650b c2650b : this.f13600t) {
            if (c2650b.f13734j != null || c2650b.f13729e || c2650b.f13727c != c2650b.f13728d) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16375a(int i, String str, boolean z, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f13600t.size()) {
                break;
            }
            C2650b c2650b = this.f13600t.get(i4);
            if (c2650b.f13725a != i) {
                i3 = i4 + 1;
            } else {
                c2650b.m16431a(str);
                c2650b.m16430a(i2);
                c2650b.m16432a(z);
                break;
            }
        }
        m16377a(this.f13595o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public C2650b m16393c(int i) {
        for (C2650b c2650b : this.f13600t) {
            if (c2650b.f13725a == i) {
                return c2650b;
            }
        }
        return (C2650b) null;
    }

    /* renamed from: t */
    private int m16411t() {
        int i = 0;
        for (C2650b c2650b : this.f13600t) {
            if (c2650b.f13734j != null || c2650b.f13729e) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16396d(C2650b c2650b) {
        View inflate;
        TextView textView;
        String[] strArr;
        Spinner spinner;
        Spinner spinner2;
        EditText editText;
        int[] iArr = {c2650b.f13727c};
        if (c2650b.f13727c == 18) {
            View inflate2 = getLayoutInflater().inflate(R.layout.spinner_layout, (ViewGroup) null);
            EditText editText2 = (EditText) null;
            Spinner spinner3 = (Spinner) null;
            textView = (TextView) inflate2.findViewById(R.id.spinnerlayoutTextView1);
            textView.setVisibility(0);
            spinner2 = (Spinner) inflate2.findViewById(R.id.spinnerlayoutSpinner1);
            spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, new String[]{"false", "true"}));
            spinner2.setSelection(Boolean.valueOf(c2650b.toString()).booleanValue() ? 1 : 0);
            spinner = spinner3;
            editText = editText2;
            inflate = inflate2;
        } else {
            inflate = getLayoutInflater().inflate(R.layout.axml_dialog, (ViewGroup) null);
            EditText editText3 = (EditText) inflate.findViewById(R.id.axmldialogEditText1);
            Spinner spinner4 = (Spinner) inflate.findViewById(R.id.axmldialogSpinner1);
            Spinner spinner5 = (Spinner) inflate.findViewById(R.id.axmldialogSpinner2);
            ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.axmldialogImageButton1);
            textView = (TextView) inflate.findViewById(R.id.axmldialogTextView1);
            TextView textView2 = (TextView) inflate.findViewById(R.id.axmldialogTextView2);
            Spinner spinner6 = (Spinner) null;
            if (c2650b.f13727c == 3) {
                editText3.setInputType(1);
                editText3.setSingleLine(false);
                editText3.setHorizontallyScrolling(false);
                editText3.setGravity(48);
            } else {
                if ((c2650b.f13727c >= 28 && c2650b.f13727c <= 31) || c2650b.f13727c == 17 || c2650b.f13727c == 1 || c2650b.f13727c == 2) {
                    editText3.setInputType(1);
                    textView2.setVisibility(0);
                    if (c2650b.f13727c == 1 || c2650b.f13727c == 2) {
                        textView2.setText(R.string.axml_info_ref);
                    } else {
                        textView2.setText(R.string.axml_info_hex);
                    }
                } else {
                    editText3.setInputType(12290);
                    textView2.setVisibility(8);
                }
                editText3.setSingleLine(true);
                editText3.setMaxLines(1);
            }
            if (c2650b.f13727c == 5) {
                String f2 = Float.toString(C0035a.m194a(c2650b.m16433b()));
                editText3.setText(f2);
                editText3.setHint(f2);
            } else if (c2650b.f13727c == 6) {
                String f3 = Float.toString(C0035a.m194a(c2650b.m16433b()) * 100);
                editText3.setText(f3);
                editText3.setHint(f3);
            } else {
                editText3.setText(c2650b.toString());
                editText3.setHint(c2650b.toString());
            }
            if (c2650b.f13727c >= 28 && c2650b.f13727c <= 31) {
                imageButton.setVisibility(0);
                if (C3102bd.f18291a) {
                    imageButton.setImageResource(R.drawable.ic_palette_dark);
                } else {
                    imageButton.setImageResource(R.drawable.ic_palette_white);
                }
                imageButton.setOnClickListener(new View.OnClickListener(this, editText3) { // from class: ru.maximoff.apktool.AxmlEdit.24

                    /* renamed from: a */
                    private final AxmlEdit f13652a;

                    /* renamed from: b */
                    private final EditText f13653b;

                    {
                        this.f13652a = this;
                        this.f13653b = editText3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3321c c3321c = new C3321c(this.f13652a);
                        c3321c.m20106a(this.f13653b.getText().toString());
                        c3321c.m20107a(new C3321c.a(this, this.f13653b) { // from class: ru.maximoff.apktool.AxmlEdit.24.1

                            /* renamed from: a */
                            private final ViewOnClickListenerC263124 f13654a;

                            /* renamed from: b */
                            private final EditText f13655b;

                            {
                                this.f13654a = this;
                                this.f13655b = r2;
                            }

                            @Override // ru.maximoff.color.C3321c.a
                            /* renamed from: a */
                            public void mo16419a() {
                            }

                            @Override // ru.maximoff.color.C3321c.a
                            /* renamed from: a */
                            public void mo16420a(int i) {
                            }

                            @Override // ru.maximoff.color.C3321c.a
                            /* renamed from: b */
                            public void mo16422b(String str) {
                            }

                            @Override // ru.maximoff.color.C3321c.a
                            /* renamed from: a */
                            public void mo16421a(String str) {
                                this.f13655b.setText(str);
                                this.f13655b.requestFocus();
                                this.f13655b.setSelection(str.length());
                            }
                        });
                        c3321c.m20109b();
                    }
                });
            } else if (c2650b.f13727c == 5 || c2650b.f13727c == 6) {
                spinner4.setVisibility(0);
                if (c2650b.f13727c == 5) {
                    strArr = C0035a.f274a;
                } else {
                    strArr = C0035a.f275b;
                }
                spinner4.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, strArr));
                spinner4.setSelection(C0035a.m198b(c2650b.m16433b()));
            } else if (m16415a(c2650b)) {
                textView2.setText(R.string.axml_info_ref);
                spinner4.setVisibility(0);
                spinner4.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, new String[]{"STR", "REF"}));
                spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, iArr, textView2, editText3) { // from class: ru.maximoff.apktool.AxmlEdit.25

                    /* renamed from: a */
                    private final AxmlEdit f13656a;

                    /* renamed from: b */
                    private final int[] f13657b;

                    /* renamed from: c */
                    private final TextView f13658c;

                    /* renamed from: d */
                    private final EditText f13659d;

                    {
                        this.f13656a = this;
                        this.f13657b = iArr;
                        this.f13658c = textView2;
                        this.f13659d = editText3;
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        switch (i) {
                            case 0:
                                this.f13657b[0] = 3;
                                this.f13658c.setVisibility(8);
                                this.f13659d.setSingleLine(false);
                                this.f13659d.setHorizontallyScrolling(false);
                                break;
                            case 1:
                                this.f13657b[0] = 1;
                                this.f13658c.setVisibility(0);
                                this.f13659d.setSingleLine(true);
                                this.f13659d.setHorizontallyScrolling(true);
                                break;
                        }
                    }
                });
                spinner4.setSelection(c2650b.f13727c == 3 ? 0 : 1);
            }
            if (m16416b(c2650b)) {
                textView2.setText(String.format("\"match_parent\", \"fill_parent\": %d\n\"wrap_content\": %d", new Integer(-1), new Integer(-2)));
                textView2.setTextColor(C3246h.m19470a(this, R.color.dark_green));
                if (c2650b.f13727c != 5) {
                    textView2.setVisibility(0);
                    spinner4.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, C0035a.f274a));
                    spinner4.setSelection(0);
                } else {
                    textView2.setVisibility(8);
                }
                spinner5.setVisibility(0);
                spinner5.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, new String[]{"INT", "DIM"}));
                spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, textView2, iArr, spinner4) { // from class: ru.maximoff.apktool.AxmlEdit.26

                    /* renamed from: a */
                    private final AxmlEdit f13660a;

                    /* renamed from: b */
                    private final TextView f13661b;

                    /* renamed from: c */
                    private final int[] f13662c;

                    /* renamed from: d */
                    private final Spinner f13663d;

                    {
                        this.f13660a = this;
                        this.f13661b = textView2;
                        this.f13662c = iArr;
                        this.f13663d = spinner4;
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        switch (i) {
                            case 0:
                                this.f13661b.setVisibility(0);
                                this.f13662c[0] = 16;
                                this.f13663d.setVisibility(8);
                                break;
                            case 1:
                                this.f13661b.setVisibility(8);
                                this.f13662c[0] = 5;
                                this.f13663d.setVisibility(0);
                                break;
                        }
                    }
                });
                spinner5.setSelection(c2650b.f13727c == 5 ? 1 : 0);
                spinner = spinner4;
                spinner2 = spinner6;
                editText = editText3;
            } else {
                if (m16417c(c2650b)) {
                    textView2.setText(String.format("\"horizontal\": %d\n\"vertical\": %d", new Integer(0), new Integer(1)));
                    textView2.setTextColor(C3246h.m19470a(this, R.color.dark_green));
                    textView2.setVisibility(0);
                }
                spinner = spinner4;
                spinner2 = spinner6;
                editText = editText3;
            }
        }
        textView.setText(getString(R.string.type, C0035a.m202d(c2650b.f13727c)));
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m435b(inflate).m427a(c2650b.f13732h).m420a(R.string.save, new DialogInterface.OnClickListener(this, iArr, spinner2, editText, spinner, c2650b) { // from class: ru.maximoff.apktool.AxmlEdit.27

            /* renamed from: a */
            private final AxmlEdit f13664a;

            /* renamed from: b */
            private final int[] f13665b;

            /* renamed from: c */
            private final Spinner f13666c;

            /* renamed from: d */
            private final EditText f13667d;

            /* renamed from: e */
            private final Spinner f13668e;

            /* renamed from: f */
            private final C2650b f13669f;

            {
                this.f13664a = this;
                this.f13665b = iArr;
                this.f13666c = spinner2;
                this.f13667d = editText;
                this.f13668e = spinner;
                this.f13669f = c2650b;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String editable;
                dialogInterface.cancel();
                try {
                    if (this.f13665b[0] == 18) {
                        editable = Boolean.valueOf(this.f13666c.getSelectedItemPosition() == 1).toString();
                    } else {
                        editable = this.f13667d.getText().toString();
                        if (this.f13665b[0] != 3) {
                            if (this.f13665b[0] == 5) {
                                editable = Integer.toString(C0035a.m196a(Float.parseFloat(editable.replaceAll("[^0-9\\.-]", "")), this.f13668e.getSelectedItemPosition()));
                            } else if (this.f13665b[0] == 6) {
                                editable = Integer.toString(C0035a.m196a(Float.parseFloat(editable.replaceAll("[^0-9\\.-]", "")) / 100, this.f13668e.getSelectedItemPosition()));
                            } else if (this.f13665b[0] >= 28 && this.f13665b[0] <= 31) {
                                String replaceAll = editable.replaceAll("[^0-9a-fA-F#]", "");
                                if (!replaceAll.startsWith("#")) {
                                    replaceAll = new StringBuffer().append("#").append(replaceAll).toString();
                                }
                                editable = Integer.toString(Color.parseColor(replaceAll));
                            } else if (this.f13665b[0] >= 16 && this.f13665b[0] <= 31) {
                                editable = Integer.toString(Integer.parseInt(editable.replaceAll("[^0-9\\.-]", "")));
                            } else if (this.f13665b[0] == 17) {
                                String replaceAll2 = editable.replaceAll("[^0-9a-fA-Fx]", "");
                                if (replaceAll2.startsWith("0x")) {
                                    replaceAll2 = replaceAll2.substring(2);
                                }
                                editable = Integer.toString(Integer.parseInt(replaceAll2, 16));
                            } else if (this.f13665b[0] == 4) {
                                editable = Integer.toString(Float.floatToIntBits(Float.parseFloat(editable.replaceAll("[^0-9\\.-]", ""))));
                            } else if (this.f13665b[0] == 1) {
                                String replaceAll3 = editable.replaceAll("[^0-9a-fA-Fx]", "");
                                if (replaceAll3.startsWith("0x")) {
                                    replaceAll3 = replaceAll3.substring(2);
                                }
                                editable = Integer.toString(Integer.parseInt(replaceAll3, 16));
                            } else if (this.f13665b[0] == 2) {
                                String replaceAll4 = editable.replaceAll("[^0-9a-fA-Fx]", "");
                                if (replaceAll4.startsWith("0x")) {
                                    replaceAll4 = replaceAll4.substring(2);
                                }
                                editable = Integer.toString(Integer.parseInt(replaceAll4, 16));
                            }
                        }
                    }
                    this.f13664a.m16375a(this.f13669f.f13725a, editable, this.f13669f.f13729e, this.f13665b[0]);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f13664a, R.string.error);
                }
            }
        }).m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.28

            /* renamed from: a */
            private final AxmlEdit f13670a;

            {
                this.f13670a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, c2650b) { // from class: ru.maximoff.apktool.AxmlEdit.29

            /* renamed from: a */
            private final AxmlEdit f13671a;

            /* renamed from: b */
            private final C2650b f13672b;

            {
                this.f13671a = this;
                this.f13672b = c2650b;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f13671a.m16375a(this.f13672b.f13725a, (String) null, false, -1);
            }
        }).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, c2650b, editText) { // from class: ru.maximoff.apktool.AxmlEdit.30

            /* renamed from: a */
            private final AxmlEdit f13674a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f13675b;

            /* renamed from: c */
            private final C2650b f13676c;

            /* renamed from: d */
            private final EditText f13677d;

            {
                this.f13674a = this;
                this.f13675b = m438b;
                this.f13676c = c2650b;
                this.f13677d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f13675b.m414a(-3).setEnabled((this.f13676c.f13734j == null && !this.f13676c.f13729e && this.f13676c.f13727c == this.f13676c.f13728d) ? false : true);
                if (this.f13677d != null) {
                    this.f13677d.requestFocus();
                    this.f13677d.selectAll();
                }
            }
        });
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.31

            /* renamed from: a */
            private final AxmlEdit f13678a;

            {
                this.f13678a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        m438b.show();
    }

    /* renamed from: u */
    private void m16412u() {
        new DialogInterfaceC0070b.a(this).m433b(R.string.file_changed).m420a(R.string.save, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.32

            /* renamed from: a */
            private final AxmlEdit f13679a;

            {
                this.f13679a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f13679a.m16391b(true);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.exit, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.AxmlEdit.33

            /* renamed from: a */
            private final AxmlEdit f13680a;

            {
                this.f13680a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f13680a.finish();
            }
        }).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16391b(boolean z) {
        if (this.f13591k == null) {
            try {
                m16376a(this.f13590j, this.f13604x);
                C3112bn.m18999a(this, R.string.success);
            } catch (Exception e2) {
                C3112bn.m18999a(this, R.string.error);
            }
            if (z) {
                finish();
                return;
            }
            try {
                m16407p();
                m16377a(this.f13595o);
                return;
            } catch (Exception e3) {
                C3112bn.m18999a(this, R.string.error);
                return;
            }
        }
        int[] iArr = {1, 3, 0};
        C3262u.m19599a(this, iArr, new Runnable(this, iArr, z) { // from class: ru.maximoff.apktool.AxmlEdit.34

            /* renamed from: a */
            private final AxmlEdit f13681a;

            /* renamed from: b */
            private final int[] f13682b;

            /* renamed from: c */
            private final boolean f13683c;

            {
                this.f13681a = this;
                this.f13682b = iArr;
                this.f13683c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new AsyncTaskC2653e(this.f13681a, this.f13681a, this.f13682b[0], this.f13683c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File[0]);
                } catch (Exception e4) {
                    C3112bn.m18999a(this.f13681a, R.string.error_try_again);
                }
            }
        }, (Runnable) null);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (this.f13598r.getVisibility() == 0) {
            this.f13598r.setVisibility(8);
            m16377a("");
        } else {
            m16414a(false);
        }
    }

    /* renamed from: a */
    public void m16414a(boolean z) {
        if (m16410s()) {
            m16412u();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!z && currentTimeMillis - this.f13602v > 2000) {
            C3112bn.m18999a(this, R.string.click_once_more);
            this.f13602v = currentTimeMillis;
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f13591k != null) {
            this.f13590j.delete();
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16379a(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        C2604w c2604w = new C2604w(str);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(C3102bd.f18315aw);
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (name != null && !C3112bn.m19040o(name)) {
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                if (name.equals(this.f13592l)) {
                    FileInputStream fileInputStream = new FileInputStream(this.f13590j);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    if (nextElement.getMethod() == 0) {
                        c2602u.setMethod(0);
                        c2602u.setSize(this.f13590j.length());
                        c2602u.setCompressedSize(this.f13590j.length());
                        c2602u.setCrc(C3117bs.m19055a(this.f13590j));
                    } else {
                        c2602u.setMethod(8);
                        c2602u.setCrc(nextElement.getCrc());
                        c2602u.setCompressedSize(-1L);
                    }
                    m19496a.mo16214a(c2602u);
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read);
                        }
                    }
                    fileInputStream.close();
                } else {
                    bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                    c2602u.setCrc(nextElement.getCrc());
                    if (nextElement.getMethod() == 0 && size >= 0) {
                        c2602u.setMethod(0);
                        c2602u.setSize(size);
                        c2602u.setCompressedSize(size);
                    } else {
                        c2602u.setMethod(8);
                        c2602u.setCompressedSize(-1L);
                    }
                    m19496a.mo16214a(c2602u);
                    while (true) {
                        int read2 = bufferedInputStream.read(bArr);
                        if (read2 == -1) {
                            break;
                        } else {
                            m19496a.write(bArr, 0, read2);
                        }
                    }
                }
                bufferedInputStream.close();
                m19496a.flush();
                m19496a.m16218b();
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$a */
    private class C2649a extends BaseAdapter {

        /* renamed from: b */
        private Context f13710b;

        /* renamed from: d */
        private final AxmlEdit f13712d;

        /* renamed from: a */
        private List<C2650b> f13709a = new ArrayList();

        /* renamed from: c */
        private int f13711c = 0;

        /* renamed from: b */
        static AxmlEdit m16426b(C2649a c2649a) {
            return c2649a.f13712d;
        }

        public C2649a(AxmlEdit axmlEdit, Context context) {
            this.f13712d = axmlEdit;
            this.f13710b = context;
        }

        /* renamed from: a */
        public void m16427a(List<C2650b> list) {
            this.f13709a.clear();
            this.f13709a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f13709a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return i < this.f13709a.size() ? this.f13709a.get(i) : (Object) null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (i + 1) * 17;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            this.f13711c = 0;
            this.f13712d.m16418o();
            super.notifyDataSetChanged();
        }

        /* renamed from: a */
        private int m16424a() {
            int i = 0;
            for (C2650b c2650b : this.f13709a) {
                if (c2650b.f13725a > i) {
                    i = c2650b.f13725a;
                }
            }
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C2654f c2654f;
            C2650b c2650b = this.f13709a.get(i);
            if (view == null) {
                view = ((LayoutInflater) this.f13712d.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.translate_item, (ViewGroup) null);
                C2654f c2654f2 = new C2654f(this.f13712d);
                c2654f2.f13757a = i;
                c2654f2.f13761e = (TextView) view.findViewById(R.id.itemValue);
                c2654f2.f13759c = (TextView) view.findViewById(R.id.itemNumber);
                c2654f2.f13760d = (TextView) view.findViewById(R.id.itemName);
                c2654f2.f13758b = (LinearLayout) null;
                c2654f2.f13762f = (TextView) null;
                view.setTag(c2654f2);
                c2654f = c2654f2;
            } else {
                c2654f = (C2654f) view.getTag();
            }
            if (this.f13712d.f13603w) {
                c2654f.f13759c.setTextSize(2, C3102bd.f18332o);
                c2654f.f13759c.setVisibility(0);
                if (this.f13711c == 0) {
                    this.f13711c = (int) ((c2654f.f13759c.getPaint().measureText(String.valueOf(m16424a() + 1)) + 6) * this.f13712d.getResources().getDisplayMetrics().density * 0.5f);
                }
                c2654f.f13759c.setMinimumWidth(this.f13711c);
                c2654f.f13759c.setText(String.valueOf(c2650b.f13725a + 1));
            } else {
                c2654f.f13759c.setVisibility(8);
                c2654f.f13759c.setText("0");
            }
            view.setMinimumHeight(0);
            c2654f.f13761e.setTextSize(2, C3102bd.f18332o);
            c2654f.f13760d.setTextSize(2, C3102bd.f18332o - 2);
            c2654f.f13760d.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            if (C3102bd.f18291a) {
                c2654f.f13761e.setBackgroundResource(R.drawable.border);
            } else {
                c2654f.f13761e.setBackgroundResource(R.drawable.border_dark);
            }
            c2654f.f13760d.setText(c2650b.f13731g);
            if (c2650b.f13729e) {
                view.setBackgroundColor(C3246h.m19470a(this.f13710b, R.color.tvery_light_red));
            } else if (c2650b.f13734j == null && c2650b.f13727c == c2650b.f13728d) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(C3246h.m19470a(this.f13710b, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
            }
            c2654f.f13761e.setText(c2650b.toString());
            view.setOnClickListener(new View.OnClickListener(this, c2650b) { // from class: ru.maximoff.apktool.AxmlEdit.a.1

                /* renamed from: a */
                private final C2649a f13713a;

                /* renamed from: b */
                private final C2650b f13714b;

                {
                    this.f13713a = this;
                    this.f13714b = c2650b;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        C2649a.m16426b(this.f13713a).m16396d(this.f13714b);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f13713a.f13710b, R.string.error);
                    }
                }
            });
            view.setOnLongClickListener(new AnonymousClass2(this, c2650b));
            return view;
        }

        /* renamed from: ru.maximoff.apktool.AxmlEdit$a$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final C2649a f13715a;

            /* renamed from: b */
            private final C2650b f13716b;

            AnonymousClass2(C2649a c2649a, C2650b c2650b) {
                this.f13715a = c2649a;
                this.f13716b = c2650b;
            }

            /* renamed from: a */
            static C2649a m16428a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f13715a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(this.f13715a.f13710b, view);
                if (C3102bd.m18910a(this.f13715a.f13710b, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1707, 0, this.f13715a.f13710b.getString(R.string.delete)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13716b) { // from class: ru.maximoff.apktool.AxmlEdit.a.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f13717a;

                    /* renamed from: b */
                    private final C2650b f13718b;

                    {
                        this.f13717a = this;
                        this.f13718b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C2649a.m16426b(AnonymousClass2.m16428a(this.f13717a)).m16375a(this.f13718b.f13725a, this.f13718b.f13734j, !this.f13718b.f13729e, this.f13718b.f13727c);
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1708, 0, this.f13715a.f13710b.getString(R.string.copy_value)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13716b) { // from class: ru.maximoff.apktool.AxmlEdit.a.2.2

                    /* renamed from: a */
                    private final AnonymousClass2 f13719a;

                    /* renamed from: b */
                    private final C2650b f13720b;

                    {
                        this.f13719a = this;
                        this.f13720b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(AnonymousClass2.m16428a(this.f13719a).f13710b, this.f13720b.toString());
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1709, 0, this.f13715a.f13710b.getString(R.string.cp_name)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13716b) { // from class: ru.maximoff.apktool.AxmlEdit.a.2.3

                    /* renamed from: a */
                    private final AnonymousClass2 f13721a;

                    /* renamed from: b */
                    private final C2650b f13722b;

                    {
                        this.f13721a = this;
                        this.f13722b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(AnonymousClass2.m16428a(this.f13721a).f13710b, this.f13722b.f13732h);
                        return true;
                    }
                });
                if (this.f13716b.f13734j != null || this.f13716b.f13729e || this.f13716b.f13727c != this.f13716b.f13728d) {
                    c0173ao.m1339a().add(0, 1710, 0, this.f13715a.f13710b.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13716b) { // from class: ru.maximoff.apktool.AxmlEdit.a.2.4

                        /* renamed from: a */
                        private final AnonymousClass2 f13723a;

                        /* renamed from: b */
                        private final C2650b f13724b;

                        {
                            this.f13723a = this;
                            this.f13724b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C2649a.m16426b(AnonymousClass2.m16428a(this.f13723a)).m16375a(this.f13724b.f13725a, (String) null, false, -1);
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
                return true;
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$f */
    private class C2654f {

        /* renamed from: a */
        public int f13757a;

        /* renamed from: b */
        public LinearLayout f13758b;

        /* renamed from: c */
        public TextView f13759c;

        /* renamed from: d */
        public TextView f13760d;

        /* renamed from: e */
        public TextView f13761e;

        /* renamed from: f */
        public TextView f13762f;

        /* renamed from: g */
        private final AxmlEdit f13763g;

        public C2654f(AxmlEdit axmlEdit) {
            this.f13763g = axmlEdit;
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$b */
    private class C2650b {

        /* renamed from: a */
        public int f13725a;

        /* renamed from: b */
        public int f13726b;

        /* renamed from: c */
        public int f13727c;

        /* renamed from: d */
        public int f13728d;

        /* renamed from: e */
        public boolean f13729e;

        /* renamed from: f */
        public String f13730f;

        /* renamed from: g */
        public String f13731g;

        /* renamed from: h */
        public String f13732h;

        /* renamed from: i */
        public String f13733i;

        /* renamed from: j */
        public String f13734j;

        /* renamed from: k */
        private final AxmlEdit f13735k;

        public C2650b(AxmlEdit axmlEdit, int i, int i2, int i3, String str, String str2, String str3) {
            this.f13735k = axmlEdit;
            this.f13725a = i;
            this.f13726b = i2;
            this.f13727c = i3;
            this.f13728d = i3;
            this.f13730f = str;
            this.f13731g = str2;
            if (str2.indexOf(" -> ") != -1) {
                this.f13732h = str2.split(" -> ", 2)[1];
            } else {
                this.f13732h = str2;
            }
            this.f13733i = str3;
            this.f13734j = (String) null;
            this.f13729e = false;
        }

        /* renamed from: a */
        public void m16431a(String str) {
            this.f13734j = str;
        }

        /* renamed from: a */
        public void m16430a(int i) {
            if (i < 0) {
                this.f13727c = this.f13728d;
            } else {
                this.f13727c = i;
            }
        }

        /* renamed from: a */
        public void m16432a(boolean z) {
            this.f13729e = z;
        }

        /* renamed from: a */
        public void m16429a() {
            this.f13727c = this.f13728d;
            this.f13734j = (String) null;
            this.f13729e = false;
        }

        /* renamed from: b */
        public int m16433b() {
            String str = this.f13734j == null ? this.f13733i : this.f13734j;
            if (this.f13727c == 18) {
                return new Boolean(str).booleanValue() ? 1 : 0;
            }
            if (this.f13727c == 3) {
                return 0;
            }
            return Integer.parseInt(str);
        }

        public String toString() {
            String str = this.f13734j == null ? this.f13733i : this.f13734j;
            if (this.f13727c == 18) {
                return new Boolean(str).toString();
            }
            if (this.f13727c != 3) {
                if (this.f13727c == 1) {
                    try {
                        return String.format("@0x%08x", new Integer(Integer.parseInt(str)));
                    } catch (Exception e2) {
                    }
                } else if (this.f13727c == 2) {
                    try {
                        return String.format("?0x%08x", new Integer(Integer.parseInt(str)));
                    } catch (Exception e3) {
                    }
                }
                try {
                    return C0035a.m199b(this.f13727c, Integer.parseInt(str));
                } catch (Exception e4) {
                    return str;
                }
            }
            return str;
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$g */
    private class C2655g extends C0547c {

        /* renamed from: a */
        private Context f13764a;

        /* renamed from: b */
        private boolean f13765b;

        /* renamed from: c */
        private String f13766c;

        /* renamed from: e */
        private Map<String, String> f13767e;

        /* renamed from: f */
        private final AxmlEdit f13768f;

        public C2655g(AxmlEdit axmlEdit, Context context, AbstractC0549e abstractC0549e, boolean z) {
            this(axmlEdit, context, abstractC0549e, z, (Map) null, (String) null);
        }

        public C2655g(AxmlEdit axmlEdit, Context context, AbstractC0549e abstractC0549e, boolean z, Map<String, String> map, String str) {
            super(abstractC0549e);
            this.f13768f = axmlEdit;
            this.f13764a = context;
            this.f13765b = z;
            this.f13767e = map;
            this.f13766c = str;
        }

        /* renamed from: a */
        private String m16441a(String str) {
            String str2;
            if (this.f13767e == null || (str2 = this.f13767e.get(str)) == null) {
                if (str.equals("http://schemas.android.com/apk/res/android")) {
                    if (this.f13767e != null) {
                        this.f13767e.put(str, "android");
                        return "android";
                    }
                    return "android";
                }
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) {
                    return str;
                }
                String substring = str.substring(lastIndexOf + 1);
                if (this.f13767e != null) {
                    this.f13767e.put(str, substring);
                    return substring;
                }
                return substring;
            }
            return str2;
        }

        @Override // p060c.p061a.p062a.C0547c
        /* renamed from: a */
        public void mo4020a(String str, String str2, int i) {
            super.mo4020a(str, str2, i);
            if (this.f13767e != null) {
                this.f13767e.put(str2, str);
            }
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            String str3;
            if (str2 != null) {
                str3 = (this.f13767e == null || str == null) ? str2 : new StringBuffer().append(new StringBuffer().append(m16441a(str)).append(":").toString()).append(str2).toString();
            } else {
                str3 = (String) null;
            }
            return new C2655g(this.f13768f, this.f13764a, super.mo4019a(str, str2), this.f13765b, this.f13767e, str3);
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4032a(String str, String str2, int i, int i2, Object obj) {
            String bool;
            String valueOf;
            Object valueOf2;
            if (i2 == 3 || i2 == 18 || i2 == 5 || i2 == 6 || i2 == 17 || i2 == 1 || i2 == 2 || ((i2 >= 28 && i2 <= 31) || ((i2 >= 16 && i2 <= 31) || i2 == 4))) {
                if (this.f13765b) {
                    C2650b m16393c = this.f13768f.m16393c(this.f13768f.f13589i);
                    if (m16393c != null && m16393c.f13729e) {
                        this.f13768f.f13589i++;
                        return;
                    } else if (m16393c != null && m16393c.f13734j != null) {
                        switch (m16393c.f13727c) {
                            case 3:
                                valueOf2 = String.valueOf(m16393c.f13734j);
                                break;
                            case 18:
                                valueOf2 = Boolean.valueOf(m16393c.f13734j);
                                break;
                            default:
                                valueOf2 = new Integer(Integer.parseInt(m16393c.f13734j));
                                break;
                        }
                        i2 = m16393c.f13727c;
                        obj = valueOf2;
                    }
                } else {
                    if (obj == null) {
                        bool = "";
                    } else {
                        switch (i2) {
                            case 18:
                                bool = new Boolean(((Boolean) obj).booleanValue()).toString();
                                break;
                            default:
                                if (obj instanceof C0550f) {
                                    valueOf = String.valueOf(((C0550f) obj).f3695c);
                                } else {
                                    valueOf = String.valueOf(obj);
                                }
                                bool = valueOf;
                                break;
                        }
                    }
                    String stringBuffer = this.f13766c != null ? new StringBuffer().append("").append(new StringBuffer().append(this.f13766c).append(" -> ").toString()).toString() : "";
                    this.f13768f.f13600t.add(this.f13768f.f13589i, new C2650b(this.f13768f, this.f13768f.f13589i, i, i2, str, new StringBuffer().append((this.f13767e == null || str == null) ? stringBuffer : new StringBuffer().append(stringBuffer).append(new StringBuffer().append(m16441a(str)).append(":").toString()).toString()).append(str2).toString(), bool));
                }
                this.f13768f.f13589i++;
            }
            super.mo4032a(str, str2, i, i2, obj);
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$e */
    private class AsyncTaskC2653e extends AsyncTask<File, Void, Boolean> {

        /* renamed from: a */
        private Context f13747a;

        /* renamed from: b */
        private boolean f13748b;

        /* renamed from: c */
        private DialogInterfaceC0070b f13749c;

        /* renamed from: d */
        private int f13750d;

        /* renamed from: e */
        private final AxmlEdit f13751e;

        @Override // android.p008os.AsyncTask
        protected Boolean doInBackground(File[] fileArr) {
            return m16438a(fileArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m16439a(bool);
        }

        public AsyncTaskC2653e(AxmlEdit axmlEdit, Context context, int i, boolean z) {
            this.f13751e = axmlEdit;
            this.f13747a = context;
            this.f13750d = i;
            this.f13748b = z;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f13747a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f13749c = new DialogInterfaceC0070b.a(this.f13747a).m435b(inflate).m429a(false).m438b();
            this.f13749c.show();
        }

        /* renamed from: a */
        protected Boolean m16438a(File[] fileArr) {
            InterfaceC0008c interfaceC0008c;
            try {
                try {
                    this.f13751e.m16376a(this.f13751e.f13590j, this.f13751e.f13604x);
                    File file = new File(this.f13751e.f13591k);
                    int[] iArr = new int[1];
                    try {
                        iArr[0] = new C3081am(file).m18632h();
                    } catch (Exception e2) {
                        iArr[0] = 14;
                    }
                    if (this.f13750d == 0 && C3102bd.m18925a(this.f13747a, "save_sign_data", true)) {
                        interfaceC0008c = C3105bg.m18964a(file);
                    } else {
                        interfaceC0008c = (InterfaceC0008c) null;
                    }
                    File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                    if (this.f13751e.f13604x) {
                        C3262u.m19612a(file, new File(new StringBuffer().append(this.f13751e.f13591k).append(".bak").toString()));
                    }
                    File createTempFile2 = File.createTempFile("APKTOOL_M", ".unalign", C3102bd.m18908a());
                    this.f13751e.m16379a(file.getAbsolutePath(), createTempFile2.getAbsolutePath());
                    C3317a.m20052a(createTempFile2.getAbsolutePath(), createTempFile.getAbsolutePath());
                    createTempFile2.delete();
                    C2917as.m17314a(this.f13747a, this.f13750d, new C2917as.a(this, createTempFile, file, interfaceC0008c, iArr) { // from class: ru.maximoff.apktool.AxmlEdit.e.1

                        /* renamed from: a */
                        private final AsyncTaskC2653e f13752a;

                        /* renamed from: b */
                        private final File f13753b;

                        /* renamed from: c */
                        private final File f13754c;

                        /* renamed from: d */
                        private final InterfaceC0008c f13755d;

                        /* renamed from: e */
                        private final int[] f13756e;

                        {
                            this.f13752a = this;
                            this.f13753b = createTempFile;
                            this.f13754c = file;
                            this.f13755d = interfaceC0008c;
                            this.f13756e = iArr;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                C3262u.m19612a(this.f13753b, this.f13754c);
                                if (this.f13755d != null) {
                                    try {
                                        C3105bg.m18967a(this.f13754c, this.f13755d);
                                    } catch (IOException e3) {
                                    }
                                }
                            } else {
                                c2917as.m17320a(this.f13753b, this.f13754c, this.f13756e[0]);
                            }
                            if (this.f13753b.exists()) {
                                this.f13753b.delete();
                            }
                        }
                    });
                    return new Boolean(true);
                } catch (Error e3) {
                    return new Boolean(false);
                }
            } catch (Exception e4) {
                return new Boolean(false);
            }
        }

        /* renamed from: a */
        protected void m16439a(Boolean bool) {
            if (this.f13749c != null && this.f13749c.isShowing()) {
                try {
                    this.f13749c.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                C3112bn.m18999a(this.f13747a, R.string.success);
            } else {
                C3112bn.m18999a(this.f13747a, R.string.error);
            }
            if (this.f13748b) {
                this.f13751e.finish();
                return;
            }
            try {
                this.f13751e.m16407p();
                this.f13751e.m16377a(this.f13751e.f13595o);
            } catch (Exception e3) {
                C3112bn.m18999a(this.f13747a, R.string.error);
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$c */
    private class AsyncTaskC2651c extends AsyncTask<File, Void, String> {

        /* renamed from: a */
        private Context f13736a;

        /* renamed from: b */
        private DialogInterfaceC0070b f13737b;

        /* renamed from: c */
        private File f13738c;

        /* renamed from: d */
        private final AxmlEdit f13739d;

        @Override // android.p008os.AsyncTask
        protected String doInBackground(File[] fileArr) {
            return m16434a(fileArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(String str) {
            m16435a(str);
        }

        public AsyncTaskC2651c(AxmlEdit axmlEdit, Context context) {
            this.f13739d = axmlEdit;
            this.f13736a = context;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f13736a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f13737b = new DialogInterfaceC0070b.a(this.f13736a).m435b(inflate).m429a(false).m438b();
            this.f13737b.show();
        }

        /* renamed from: a */
        protected String m16434a(File[] fileArr) {
            try {
                this.f13738c = fileArr[0];
                this.f13739d.m16376a(this.f13738c, false);
                return this.f13739d.m16373a(this.f13738c);
            } catch (Error | Exception e2) {
                return (String) null;
            }
        }

        /* renamed from: a */
        protected void m16435a(String str) {
            if (this.f13737b != null && this.f13737b.isShowing()) {
                try {
                    this.f13737b.cancel();
                } catch (Exception e2) {
                }
            }
            if (str != null) {
                try {
                    this.f13739d.m16378a(str, this.f13738c);
                    return;
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f13736a, R.string.error);
                    return;
                }
            }
            C3112bn.m18999a(this.f13736a, R.string.error);
        }
    }

    /* renamed from: ru.maximoff.apktool.AxmlEdit$d */
    private class AsyncTaskC2652d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private String f13740a;

        /* renamed from: b */
        private String f13741b;

        /* renamed from: c */
        private boolean f13742c;

        /* renamed from: d */
        private boolean f13743d;

        /* renamed from: e */
        private int f13744e = 0;

        /* renamed from: f */
        private DialogInterfaceC0070b f13745f;

        /* renamed from: g */
        private final AxmlEdit f13746g;

        @Override // android.p008os.AsyncTask
        protected Void doInBackground(Void[] voidArr) {
            return m16436a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Void r1) {
            m16437a(r1);
        }

        public AsyncTaskC2652d(AxmlEdit axmlEdit, String str, String str2, boolean z, boolean z2) {
            this.f13746g = axmlEdit;
            this.f13740a = str;
            this.f13741b = str2;
            this.f13742c = z;
            this.f13743d = z2;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f13746g).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f13745f = new DialogInterfaceC0070b.a(this.f13746g).m435b(inflate).m429a(false).m438b();
            this.f13745f.show();
        }

        /* renamed from: a */
        protected Void m16436a(Void[] voidArr) {
            String str;
            String m18996a;
            for (int i = 0; i < this.f13746g.f13600t.size(); i++) {
                C2650b c2650b = (C2650b) this.f13746g.f13600t.get(i);
                if (!c2650b.f13729e && c2650b.f13727c == 3) {
                    if (c2650b.f13734j == null) {
                        str = c2650b.f13733i;
                    } else {
                        str = c2650b.f13734j;
                    }
                    if (this.f13742c) {
                        int i2 = 8;
                        if (!this.f13743d) {
                            i2 = 10;
                        }
                        try {
                            Matcher matcher = Pattern.compile(this.f13740a, i2).matcher(str);
                            StringBuffer stringBuffer = new StringBuffer();
                            int i3 = 0;
                            while (matcher.find()) {
                                matcher.appendReplacement(stringBuffer, this.f13741b);
                                i3++;
                            }
                            if (i3 > 0) {
                                matcher.appendTail(stringBuffer);
                                c2650b.m16431a(stringBuffer.toString());
                                this.f13744e += i3;
                            }
                        } catch (Exception e2) {
                        }
                    } else {
                        if (this.f13743d) {
                            m18996a = str.replace(this.f13740a, this.f13741b);
                        } else {
                            m18996a = C3112bn.m18996a(str, this.f13740a, this.f13741b);
                        }
                        if (!str.equals(m18996a)) {
                            c2650b.m16431a(m18996a);
                            this.f13744e++;
                        }
                    }
                }
            }
            return (Void) null;
        }

        /* renamed from: a */
        protected void m16437a(Void r8) {
            if (this.f13745f != null && this.f13745f.isShowing()) {
                try {
                    this.f13745f.cancel();
                } catch (Exception e2) {
                }
            }
            if (this.f13744e > 0) {
                C3112bn.m19023b(this.f13746g, this.f13746g.getString(R.string.total_repl, new Integer(this.f13744e)));
            } else {
                C3112bn.m18999a(this.f13746g, R.string.not_found);
            }
            this.f13746g.m16377a(this.f13746g.f13595o);
        }
    }
}
