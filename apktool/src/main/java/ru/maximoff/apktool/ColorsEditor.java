package ru.maximoff.apktool;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p304b.AsyncTaskC3098c;
import ru.maximoff.apktool.util.p304b.C3096a;
import ru.maximoff.apktool.util.p304b.C3097b;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.C3313o;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.color.C3321c;

/* loaded from: classes.dex */
public class ColorsEditor extends AbstractActivityC2894b {

    /* renamed from: B */
    private List<C3090av> f13780B;

    /* renamed from: h */
    public boolean f13782h;

    /* renamed from: i */
    private Context f13783i;

    /* renamed from: j */
    private C2691a f13784j;

    /* renamed from: k */
    private File f13785k;

    /* renamed from: l */
    private String[] f13786l;

    /* renamed from: m */
    private String f13787m;

    /* renamed from: n */
    private List<C3096a> f13788n;

    /* renamed from: o */
    private List<C3096a> f13789o;

    /* renamed from: p */
    private Comparator f13790p;

    /* renamed from: q */
    private LinearLayout f13791q;

    /* renamed from: r */
    private EditText f13792r;

    /* renamed from: s */
    private CheckBox f13793s;

    /* renamed from: t */
    private CheckBox f13794t;

    /* renamed from: u */
    private boolean f13795u;

    /* renamed from: v */
    private boolean f13796v;

    /* renamed from: w */
    private String f13797w;

    /* renamed from: x */
    private CustomListView f13798x;

    /* renamed from: y */
    private Spinner f13799y;

    /* renamed from: z */
    private boolean f13800z;

    /* renamed from: A */
    private int[] f13779A = {-1};

    /* renamed from: C */
    private long f13781C = 0;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
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
            this.f13785k = new File(intent.getStringExtra("data"));
            this.f13786l = C3097b.m18819b(this.f13785k.getAbsolutePath());
            if (this.f13786l == null || this.f13786l.length == 0) {
                throw new FileNotFoundException("Files not found!");
            }
            this.f13783i = this;
            this.f13782h = false;
            this.f13795u = false;
            this.f13796v = false;
            this.f13797w = "";
            this.f13787m = this.f13786l[0];
            ImageView imageView = (ImageView) findViewById(R.id.clearText1);
            if (C3102bd.f18291a) {
                imageView.setImageResource(R.drawable.ic_close);
            } else {
                imageView.setImageResource(R.drawable.ic_close_dark);
            }
            this.f13791q = (LinearLayout) findViewById(R.id.translateLinearLayout1);
            this.f13792r = (EditText) findViewById(R.id.translateEditText1);
            this.f13793s = (CheckBox) findViewById(R.id.translateCheckBox1);
            this.f13793s.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.1

                /* renamed from: a */
                private final ColorsEditor f13801a;

                {
                    this.f13801a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13801a.f13795u = this.f13801a.f13793s.isChecked();
                    this.f13801a.m16468c(this.f13801a.f13797w);
                }
            });
            this.f13794t = (CheckBox) findViewById(R.id.translateCheckBox2);
            this.f13794t.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.2

                /* renamed from: a */
                private final ColorsEditor f13832a;

                {
                    this.f13832a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13832a.f13796v = this.f13832a.f13794t.isChecked();
                    this.f13832a.m16468c(this.f13832a.f13797w);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.3

                /* renamed from: a */
                private final ColorsEditor f13880a;

                {
                    this.f13880a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13880a.f13792r.requestFocus();
                    this.f13880a.f13792r.setText("");
                }
            });
            if (this.f13792r.getText().length() == 0) {
                imageView.setVisibility(8);
            }
            C3112bn.m19006a(this.f13792r, 10000);
            this.f13792r.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.ColorsEditor.4

                /* renamed from: a */
                private final ColorsEditor f13881a;

                /* renamed from: b */
                private final ImageView f13882b;

                {
                    this.f13881a = this;
                    this.f13882b = imageView;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (this.f13881a.f13784j != null) {
                        if (editable.length() == 0) {
                            this.f13882b.setVisibility(8);
                        } else {
                            this.f13882b.setVisibility(0);
                        }
                        this.f13881a.m16468c(editable.toString());
                        this.f13881a.f13792r.requestFocus();
                    }
                }
            });
            C3212b c3212b = new C3212b(this, "colors");
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
            imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.ColorsEditor.5

                /* renamed from: a */
                private final ColorsEditor f13883a;

                /* renamed from: b */
                private final C3212b f13884b;

                /* renamed from: c */
                private final ImageView f13885c;

                {
                    this.f13883a = this;
                    this.f13884b = c3212b;
                    this.f13885c = imageView2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13884b.m19201a(this.f13885c, this.f13883a.f13792r);
                }
            });
            imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.ColorsEditor.6

                /* renamed from: a */
                private final ColorsEditor f13886a;

                /* renamed from: b */
                private final C3212b f13887b;

                /* renamed from: c */
                private final ImageView f13888c;

                {
                    this.f13886a = this;
                    this.f13887b = c3212b;
                    this.f13888c = imageView2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    new C3078aj(this.f13886a.f13783i).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13887b, this.f13888c) { // from class: ru.maximoff.apktool.ColorsEditor.6.1

                        /* renamed from: a */
                        private final ViewOnLongClickListenerC26876 f13889a;

                        /* renamed from: b */
                        private final C3212b f13890b;

                        /* renamed from: c */
                        private final ImageView f13891c;

                        {
                            this.f13889a = this;
                            this.f13890b = r2;
                            this.f13891c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f13890b.m19208d();
                            this.f13891c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            this.f13792r.setImeOptions(3);
            this.f13792r.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.ColorsEditor.7

                /* renamed from: a */
                private final ColorsEditor f13892a;

                /* renamed from: b */
                private final C3212b f13893b;

                /* renamed from: c */
                private final ImageView f13894c;

                {
                    this.f13892a = this;
                    this.f13893b = c3212b;
                    this.f13894c = imageView2;
                }

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    this.f13892a.m16468c(this.f13892a.f13792r.getText().toString());
                    if (this.f13893b.m19204a(this.f13892a.f13792r.getText().toString())) {
                        this.f13894c.setVisibility(0);
                    }
                    return true;
                }
            });
            this.f13798x = (CustomListView) findViewById(R.id.translateListView1);
            this.f13798x.setFastScrollEnabled(C3102bd.f18314av);
            this.f13799y = (Spinner) findViewById(R.id.translateSpinner1);
            this.f13799y.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f13783i, C0012R.layout.simple_spinner_dropdown_item, this.f13786l));
            this.f13799y.setSelection(0);
            this.f13800z = true;
            this.f13799y.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.8

                /* renamed from: a */
                private final ColorsEditor f13895a;

                {
                    this.f13895a = this;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.f13895a.f13800z) {
                        this.f13895a.f13800z = false;
                        return;
                    }
                    if (this.f13895a.f13782h) {
                        this.f13895a.f13800z = true;
                        this.f13895a.m16470c(false);
                        int i2 = 0;
                        while (true) {
                            if (i2 < this.f13895a.f13786l.length) {
                                if (this.f13895a.f13786l[i2].equals(this.f13895a.f13787m)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            } else {
                                i2 = 0;
                                break;
                            }
                        }
                        this.f13895a.f13799y.setSelection(i2);
                        return;
                    }
                    this.f13895a.f13787m = this.f13895a.f13786l[i];
                    this.f13895a.f13788n = C3097b.m18816a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13895a.f13785k.getAbsolutePath()).append("/res/").toString()).append(this.f13895a.f13787m).toString()).append("/colors.xml").toString());
                    if (this.f13895a.f13787m.equals("values")) {
                        this.f13895a.f13789o = new ArrayList();
                    } else {
                        this.f13895a.f13789o = C3097b.m18816a(new StringBuffer().append(this.f13895a.f13785k.getAbsolutePath()).append("/res/values/colors.xml").toString());
                    }
                    this.f13895a.m16496a(this.f13895a.f13788n, false);
                }
            });
            this.f13790p = new Comparator<C3096a>(this) { // from class: ru.maximoff.apktool.ColorsEditor.9

                /* renamed from: a */
                private final ColorsEditor f13896a;

                {
                    this.f13896a = this;
                }

                @Override // java.util.Comparator
                public int compare(C3096a c3096a, C3096a c3096a2) {
                    return m16506a(c3096a, c3096a2);
                }

                /* renamed from: a */
                public int m16506a(C3096a c3096a, C3096a c3096a2) {
                    return c3096a.m18806a().toLowerCase().compareTo(c3096a2.m18806a().toLowerCase());
                }
            };
            File file = new File(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/values/public.xml").toString());
            if (file.isFile()) {
                this.f13780B = C3061a.m18326d(file);
            } else {
                this.f13780B = new ArrayList();
            }
            this.f13788n = C3097b.m18816a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/").toString()).append(this.f13787m).toString()).append("/colors.xml").toString());
            if (this.f13787m.equals("values")) {
                this.f13789o = new ArrayList();
            } else {
                this.f13789o = C3097b.m18816a(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/values/colors.xml").toString());
            }
            this.f13784j = new C2691a(this, new ArrayList());
            this.f13798x.setAdapter((ListAdapter) this.f13784j);
            m16496a(this.f13788n, this.f13782h);
        } catch (Exception e2) {
            C3112bn.m19023b(this, getString(R.string.errorf, e2.getMessage()));
            finish();
        }
    }

    /* renamed from: o */
    public void m16500o() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.ColorsEditor.10

            /* renamed from: a */
            private final ColorsEditor f13802a;

            {
                this.f13802a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                String name = this.f13802a.f13785k.getName();
                if (this.f13802a.f13782h) {
                    name = new StringBuffer().append("*").append(name).toString();
                }
                this.f13802a.m454f().mo390a(name);
            }
        }, 100L);
    }

    /* renamed from: a */
    public String m16495a(String str) {
        for (C3090av c3090av : this.f13780B) {
            if (c3090av.m18724a().equals("color") && str.equals(c3090av.m18727b())) {
                return c3090av.m18730d();
            }
        }
        return (String) null;
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f13785k != null) {
            bundle.putString("PROJECT_DIRECTORY", this.f13785k.getAbsolutePath());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("PROJECT_DIRECTORY", (String) null);
        if (string != null) {
            this.f13785k = new File(string);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.colors, menu);
        menu.findItem(R.id.reset).setVisible(this.f13782h);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.reset).setVisible(this.f13782h);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.add /* 2131689548 */:
                m16494s();
                break;
            case R.id.save /* 2131690189 */:
                try {
                    C3097b.m18817a(this.f13785k.getAbsolutePath(), this.f13787m, this.f13788n);
                    C3112bn.m18999a(this.f13783i, R.string.success);
                    this.f13788n = C3097b.m18816a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/").toString()).append(this.f13787m).toString()).append("/colors.xml").toString());
                    if (this.f13787m.equals("values")) {
                        this.f13789o = new ArrayList();
                    } else {
                        this.f13789o = C3097b.m18816a(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/values/colors.xml").toString());
                    }
                    m16496a(this.f13788n, false);
                    break;
                } catch (Exception e2) {
                    C3112bn.m19000a(this.f13783i, R.string.errorf, e2.getMessage());
                    break;
                }
            case R.id.reset /* 2131690190 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.search_reset).m433b(R.string.mtr_sure).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.12

                    /* renamed from: a */
                    private final ColorsEditor f13804a;

                    {
                        this.f13804a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int i2 = 0; i2 < this.f13804a.f13788n.size(); i2++) {
                            ((C3096a) this.f13804a.f13788n.get(i2)).m18810b((String) null);
                            ((C3096a) this.f13804a.f13788n.get(i2)).m18807a((String) null);
                        }
                        this.f13804a.f13782h = false;
                        this.f13804a.f13784j.notifyDataSetChanged();
                        this.f13804a.invalidateOptionsMenu();
                        dialogInterface.cancel();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.search /* 2131690191 */:
                if (this.f13791q.getVisibility() == 8) {
                    this.f13791q.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.ColorsEditor.11

                        /* renamed from: a */
                        private final ColorsEditor f13803a;

                        {
                            this.f13803a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f13803a.f13792r.requestFocus();
                            ((InputMethodManager) this.f13803a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f13803a.f13792r, 1);
                            this.f13803a.f13792r.selectAll();
                        }
                    }, 100L);
                    break;
                } else {
                    this.f13791q.setVisibility(8);
                    m16468c("");
                    break;
                }
            case R.id.replace /* 2131690192 */:
                m16493r();
                break;
            case R.id.prop /* 2131690195 */:
                m16501p();
                break;
            case R.id.exit /* 2131690197 */:
                m16497a(true);
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: r */
    private void m16493r() {
        List<C3096a> m16523j = this.f13784j.m16523j();
        this.f13784j.m16520g();
        if (m16523j.isEmpty()) {
            C3112bn.m18999a(this.f13783i, R.string.not_found);
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
        checkBox.setChecked(C3102bd.m18925a((Context) this, "colors_repl_regex", false));
        checkBox2.setChecked(C3102bd.m18925a((Context) this, "colors_repl_sens", false));
        C3212b c3212b = new C3212b(this, "colors");
        if (c3212b.m19205b().isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView, editText) { // from class: ru.maximoff.apktool.ColorsEditor.13

            /* renamed from: a */
            private final ColorsEditor f13805a;

            /* renamed from: b */
            private final C3212b f13806b;

            /* renamed from: c */
            private final ImageView f13807c;

            /* renamed from: d */
            private final EditText f13808d;

            {
                this.f13805a = this;
                this.f13806b = c3212b;
                this.f13807c = imageView;
                this.f13808d = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13806b.m19201a(this.f13807c, this.f13808d);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.ColorsEditor.14

            /* renamed from: a */
            private final ColorsEditor f13809a;

            /* renamed from: b */
            private final C3212b f13810b;

            /* renamed from: c */
            private final ImageView f13811c;

            {
                this.f13809a = this;
                this.f13810b = c3212b;
                this.f13811c = imageView;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f13809a.f13783i).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13810b, this.f13811c) { // from class: ru.maximoff.apktool.ColorsEditor.14.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC266814 f13812a;

                    /* renamed from: b */
                    private final C3212b f13813b;

                    /* renamed from: c */
                    private final ImageView f13814c;

                    {
                        this.f13812a = this;
                        this.f13813b = r2;
                        this.f13814c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f13813b.m19208d();
                        this.f13814c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        C3212b c3212b2 = new C3212b(this, "colors_repl");
        if (c3212b2.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.ColorsEditor.15

            /* renamed from: a */
            private final ColorsEditor f13815a;

            /* renamed from: b */
            private final C3212b f13816b;

            /* renamed from: c */
            private final ImageView f13817c;

            /* renamed from: d */
            private final EditText f13818d;

            {
                this.f13815a = this;
                this.f13816b = c3212b2;
                this.f13817c = imageView2;
                this.f13818d = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13816b.m19201a(this.f13817c, this.f13818d);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b2, imageView2) { // from class: ru.maximoff.apktool.ColorsEditor.16

            /* renamed from: a */
            private final ColorsEditor f13819a;

            /* renamed from: b */
            private final C3212b f13820b;

            /* renamed from: c */
            private final ImageView f13821c;

            {
                this.f13819a = this;
                this.f13820b = c3212b2;
                this.f13821c = imageView2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f13819a.f13783i).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f13820b, this.f13821c) { // from class: ru.maximoff.apktool.ColorsEditor.16.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC267016 f13822a;

                    /* renamed from: b */
                    private final C3212b f13823b;

                    /* renamed from: c */
                    private final ImageView f13824c;

                    {
                        this.f13822a = this;
                        this.f13823b = r2;
                        this.f13824c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f13823b.m19208d();
                        this.f13824c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.ColorsEditor.17

            /* renamed from: a */
            private final ColorsEditor f13825a;

            /* renamed from: b */
            private final EditText f13826b;

            {
                this.f13825a = this;
                this.f13826b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13826b.requestFocus();
                this.f13826b.setText("");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.ColorsEditor.18

            /* renamed from: a */
            private final ColorsEditor f13827a;

            /* renamed from: b */
            private final EditText f13828b;

            {
                this.f13827a = this;
                this.f13828b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13828b.requestFocus();
                this.f13828b.setText("");
            }
        });
        imageView3.setVisibility(8);
        imageView4.setVisibility(8);
        editText.addTextChangedListener(new TextWatcher(this, buttonArr, imageView3) { // from class: ru.maximoff.apktool.ColorsEditor.19

            /* renamed from: a */
            private final ColorsEditor f13829a;

            /* renamed from: b */
            private final Button[] f13830b;

            /* renamed from: c */
            private final ImageView f13831c;

            {
                this.f13829a = this;
                this.f13830b = buttonArr;
                this.f13831c = imageView3;
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
                    if (this.f13830b[0] != null) {
                        this.f13830b[0].setEnabled(false);
                    }
                    this.f13831c.setVisibility(8);
                } else {
                    if (this.f13830b[0] != null) {
                        this.f13830b[0].setEnabled(true);
                    }
                    this.f13831c.setVisibility(0);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this, imageView4) { // from class: ru.maximoff.apktool.ColorsEditor.20

            /* renamed from: a */
            private final ColorsEditor f13833a;

            /* renamed from: b */
            private final ImageView f13834b;

            {
                this.f13833a = this;
                this.f13834b = imageView4;
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
                    this.f13834b.setVisibility(8);
                } else {
                    this.f13834b.setVisibility(0);
                }
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.replace).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, editText2, checkBox, checkBox2, c3212b, c3212b2, m16523j) { // from class: ru.maximoff.apktool.ColorsEditor.21

            /* renamed from: a */
            private final ColorsEditor f13835a;

            /* renamed from: b */
            private final EditText f13836b;

            /* renamed from: c */
            private final EditText f13837c;

            /* renamed from: d */
            private final CheckBox f13838d;

            /* renamed from: e */
            private final CheckBox f13839e;

            /* renamed from: f */
            private final C3212b f13840f;

            /* renamed from: g */
            private final C3212b f13841g;

            /* renamed from: h */
            private final List f13842h;

            {
                this.f13835a = this;
                this.f13836b = editText;
                this.f13837c = editText2;
                this.f13838d = checkBox;
                this.f13839e = checkBox2;
                this.f13840f = c3212b;
                this.f13841g = c3212b2;
                this.f13842h = m16523j;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                String editable = this.f13836b.getText().toString();
                String editable2 = this.f13837c.getText().toString();
                boolean isChecked = this.f13838d.isChecked();
                boolean isChecked2 = this.f13839e.isChecked();
                this.f13840f.m19204a(editable);
                this.f13841g.m19204a(editable2);
                C3102bd.m18938b(this.f13835a.f13783i, "colors_repl_regex", isChecked);
                C3102bd.m18938b(this.f13835a.f13783i, "colors_repl_sens", isChecked2);
                new AsyncTaskC3098c(this.f13835a, this.f13842h, editable, editable2, isChecked, isChecked2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.ColorsEditor.22

            /* renamed from: a */
            private final ColorsEditor f13843a;

            /* renamed from: b */
            private final Button[] f13844b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f13845c;

            /* renamed from: d */
            private final EditText f13846d;

            {
                this.f13843a = this;
                this.f13844b = buttonArr;
                this.f13845c = m438b;
                this.f13846d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f13844b[0] = this.f13845c.m414a(-1);
                this.f13844b[0].setEnabled(false);
                this.f13846d.requestFocus();
                this.f13846d.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: s */
    private void m16494s() {
        View inflate = LayoutInflater.from(this.f13783i).inflate(R.layout.rename_one, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setHint(R.string.name);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f13783i).m435b(inflate).m429a(true).m418a(R.string.madd).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.madd, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC267823(this, editText, m438b));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.ColorsEditor$23 */
    class DialogInterfaceOnShowListenerC267823 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ColorsEditor f13847a;

        /* renamed from: b */
        private final EditText f13848b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f13849c;

        DialogInterfaceOnShowListenerC267823(ColorsEditor colorsEditor, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f13847a = colorsEditor;
            this.f13848b = editText;
            this.f13849c = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static ColorsEditor m16503a(DialogInterfaceOnShowListenerC267823 dialogInterfaceOnShowListenerC267823) {
            return dialogInterfaceOnShowListenerC267823.f13847a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f13848b.requestFocus();
            this.f13849c.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f13848b, this.f13849c) { // from class: ru.maximoff.apktool.ColorsEditor.23.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC267823 f13850a;

                /* renamed from: b */
                private final EditText f13851b;

                /* renamed from: c */
                private final DialogInterfaceC0070b f13852c;

                {
                    this.f13850a = this;
                    this.f13851b = r2;
                    this.f13852c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3096a c3096a = new C3096a(this.f13851b.getText().toString().replaceAll("[^\\d\\w\\$_]", "_"), "#ff000000", "#ff000000");
                    if (DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).m16465c(c3096a) == -1) {
                        DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).f13788n.add(c3096a);
                        DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).m16496a(DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).f13788n, true);
                        this.f13852c.cancel();
                        DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).f13779A[0] = DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).m16465c(c3096a);
                        DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).m16498b(c3096a.m18811c());
                        return;
                    }
                    C3112bn.m19023b(DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).f13783i, DialogInterfaceOnShowListenerC267823.m16503a(this.f13850a).getString(R.string.string_exists));
                    this.f13851b.requestFocus();
                    this.f13851b.selectAll();
                }
            });
            this.f13849c.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f13848b) { // from class: ru.maximoff.apktool.ColorsEditor.23.2

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC267823 f13853a;

                /* renamed from: b */
                private final EditText f13854b;

                {
                    this.f13853a = this;
                    this.f13854b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18991a = C3112bn.m18991a(DialogInterfaceOnShowListenerC267823.m16503a(this.f13853a).f13783i);
                    if (m18991a != null) {
                        C3112bn.m19007a(this.f13854b, (CharSequence) m18991a);
                    } else {
                        C3112bn.m18999a(DialogInterfaceOnShowListenerC267823.m16503a(this.f13853a).f13783i, R.string.empty);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16457a(C3096a c3096a) {
        String m18812d = c3096a.m18814f() ? c3096a.m18812d() : c3096a.m18811c();
        View inflate = LayoutInflater.from(this.f13783i).inflate(R.layout.rename_one, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setHint(m18812d);
        editText.setText(m18812d);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f13783i).m435b(inflate).m429a(true).m427a(c3096a.m18815g() ? c3096a.m18809b() : c3096a.m18806a()).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC267924(this, editText, m438b, c3096a));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.ColorsEditor$24 */
    class DialogInterfaceOnShowListenerC267924 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ColorsEditor f13855a;

        /* renamed from: b */
        private final EditText f13856b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f13857c;

        /* renamed from: d */
        private final C3096a f13858d;

        DialogInterfaceOnShowListenerC267924(ColorsEditor colorsEditor, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b, C3096a c3096a) {
            this.f13855a = colorsEditor;
            this.f13856b = editText;
            this.f13857c = dialogInterfaceC0070b;
            this.f13858d = c3096a;
        }

        /* renamed from: a */
        static ColorsEditor m16504a(DialogInterfaceOnShowListenerC267924 dialogInterfaceOnShowListenerC267924) {
            return dialogInterfaceOnShowListenerC267924.f13855a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f13856b.requestFocus();
            this.f13856b.selectAll();
            this.f13857c.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f13856b, this.f13858d, this.f13857c) { // from class: ru.maximoff.apktool.ColorsEditor.24.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC267924 f13859a;

                /* renamed from: b */
                private final EditText f13860b;

                /* renamed from: c */
                private final C3096a f13861c;

                /* renamed from: d */
                private final DialogInterfaceC0070b f13862d;

                {
                    this.f13859a = this;
                    this.f13860b = r2;
                    this.f13861c = r3;
                    this.f13862d = r4;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13861c.m18810b(this.f13860b.getText().toString());
                    DialogInterfaceOnShowListenerC267924.m16504a(this.f13859a).f13782h = true;
                    DialogInterfaceOnShowListenerC267924.m16504a(this.f13859a).f13784j.notifyDataSetChanged();
                    this.f13862d.cancel();
                }
            });
            this.f13857c.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f13856b) { // from class: ru.maximoff.apktool.ColorsEditor.24.2

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC267924 f13863a;

                /* renamed from: b */
                private final EditText f13864b;

                {
                    this.f13863a = this;
                    this.f13864b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18991a = C3112bn.m18991a(DialogInterfaceOnShowListenerC267924.m16504a(this.f13863a).f13783i);
                    if (m18991a != null) {
                        C3112bn.m19007a(this.f13864b, (CharSequence) m18991a);
                    } else {
                        C3112bn.m18999a(DialogInterfaceOnShowListenerC267924.m16504a(this.f13863a).f13783i, R.string.empty);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16463b(C3096a c3096a) {
        String m18809b = c3096a.m18815g() ? c3096a.m18809b() : c3096a.m18806a();
        View inflate = LayoutInflater.from(this.f13783i).inflate(R.layout.rename_one, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setHint(m18809b);
        editText.setText(m18809b);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f13783i).m435b(inflate).m429a(true).m418a(R.string.rename).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC268025(this, editText, m438b, c3096a));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.ColorsEditor$25 */
    class DialogInterfaceOnShowListenerC268025 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ColorsEditor f13865a;

        /* renamed from: b */
        private final EditText f13866b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f13867c;

        /* renamed from: d */
        private final C3096a f13868d;

        DialogInterfaceOnShowListenerC268025(ColorsEditor colorsEditor, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b, C3096a c3096a) {
            this.f13865a = colorsEditor;
            this.f13866b = editText;
            this.f13867c = dialogInterfaceC0070b;
            this.f13868d = c3096a;
        }

        /* renamed from: a */
        static ColorsEditor m16505a(DialogInterfaceOnShowListenerC268025 dialogInterfaceOnShowListenerC268025) {
            return dialogInterfaceOnShowListenerC268025.f13865a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f13866b.requestFocus();
            this.f13866b.selectAll();
            this.f13867c.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f13866b, this.f13868d, this.f13867c) { // from class: ru.maximoff.apktool.ColorsEditor.25.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC268025 f13869a;

                /* renamed from: b */
                private final EditText f13870b;

                /* renamed from: c */
                private final C3096a f13871c;

                /* renamed from: d */
                private final DialogInterfaceC0070b f13872d;

                {
                    this.f13869a = this;
                    this.f13870b = r2;
                    this.f13871c = r3;
                    this.f13872d = r4;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f13871c.m18807a(this.f13870b.getText().toString());
                    DialogInterfaceOnShowListenerC268025.m16505a(this.f13869a).f13782h = true;
                    DialogInterfaceOnShowListenerC268025.m16505a(this.f13869a).f13784j.notifyDataSetChanged();
                    this.f13872d.cancel();
                }
            });
            this.f13867c.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f13866b) { // from class: ru.maximoff.apktool.ColorsEditor.25.2

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC268025 f13873a;

                /* renamed from: b */
                private final EditText f13874b;

                {
                    this.f13873a = this;
                    this.f13874b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18991a = C3112bn.m18991a(DialogInterfaceOnShowListenerC268025.m16505a(this.f13873a).f13783i);
                    if (m18991a != null) {
                        C3112bn.m19007a(this.f13874b, (CharSequence) m18991a);
                    } else {
                        C3112bn.m18999a(DialogInterfaceOnShowListenerC268025.m16505a(this.f13873a).f13783i, R.string.empty);
                    }
                }
            });
        }
    }

    /* renamed from: p */
    public void m16501p() {
        File file = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13785k.getAbsolutePath()).append("/res/").toString()).append(this.f13787m).toString()).append("/colors.xml").toString());
        if (!file.exists()) {
            C3112bn.m19023b(this, getString(R.string.error));
            return;
        }
        int i = 0;
        for (C3096a c3096a : this.f13788n) {
            if (c3096a.m18814f() || c3096a.m18815g()) {
                i++;
            }
        }
        new DialogInterfaceC0070b.a(this.f13783i).m436b(getString(R.string.mcolor_properties, this.f13785k.getAbsolutePath(), this.f13787m, C3106bh.m18975a(file.length(), C3102bd.f18305am), String.valueOf(this.f13788n.size()), String.valueOf(i))).m429a(true).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16470c(boolean z) {
        new DialogInterfaceC0070b.a(this).m433b(R.string.save_file_msg).m420a(R.string.save, new DialogInterface.OnClickListener(this, z) { // from class: ru.maximoff.apktool.ColorsEditor.26

            /* renamed from: a */
            private final ColorsEditor f13875a;

            /* renamed from: b */
            private final boolean f13876b;

            {
                this.f13875a = this;
                this.f13876b = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    C3097b.m18817a(this.f13875a.f13785k.getAbsolutePath(), this.f13875a.f13787m, this.f13875a.f13788n);
                    C3112bn.m18999a(this.f13875a.f13783i, R.string.success);
                    this.f13875a.m16496a(this.f13875a.f13788n, false);
                } catch (Exception e2) {
                    C3112bn.m19000a(this.f13875a.f13783i, R.string.errorf, e2.getMessage());
                }
                dialogInterface.dismiss();
                if (this.f13876b) {
                    this.f13875a.finish();
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(z ? R.string.exit : R.string.search_reset, new DialogInterface.OnClickListener(this, z) { // from class: ru.maximoff.apktool.ColorsEditor.27

            /* renamed from: a */
            private final ColorsEditor f13877a;

            /* renamed from: b */
            private final boolean f13878b;

            {
                this.f13877a = this;
                this.f13878b = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.f13878b) {
                    this.f13877a.finish();
                    return;
                }
                this.f13877a.f13788n = C3097b.m18816a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f13877a.f13785k.getAbsolutePath()).append("/res/").toString()).append(this.f13877a.f13787m).toString()).append("/colors.xml").toString());
                if (this.f13877a.f13787m.equals("values")) {
                    this.f13877a.f13789o = new ArrayList();
                } else {
                    this.f13877a.f13789o = C3097b.m18816a(new StringBuffer().append(this.f13877a.f13785k.getAbsolutePath()).append("/res/values/colors.xml").toString());
                }
                this.f13877a.m16496a(this.f13877a.f13788n, false);
            }
        }).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16468c(String str) {
        String str2;
        String str3;
        this.f13797w = str;
        if (str.equals("")) {
            m16476d(this.f13782h);
            return;
        }
        if (!this.f13796v) {
            str = str.toLowerCase();
        }
        ArrayList arrayList = new ArrayList();
        for (C3096a c3096a : this.f13788n) {
            String m18806a = c3096a.m18806a();
            String m18811c = c3096a.m18811c();
            if (c3096a.m18814f()) {
                str2 = c3096a.m18812d();
            } else {
                str2 = "";
            }
            if (c3096a.m18815g()) {
                str3 = c3096a.m18809b();
            } else {
                str3 = "";
            }
            if (!this.f13796v) {
                m18811c = m18811c.toLowerCase();
                str2 = str2.toLowerCase();
                m18806a = m18806a.toLowerCase();
                str3 = str3.toLowerCase();
            }
            if (this.f13795u) {
                if (m18811c.equals(str) || str2.equals(str) || m18806a.equals(str) || str3.equals(str)) {
                    arrayList.add(c3096a);
                }
            } else if (m18811c.contains(str) || str2.contains(str) || m18806a.contains(str) || str3.contains(str)) {
                arrayList.add(c3096a);
            }
        }
        m16496a(arrayList, this.f13782h);
    }

    /* renamed from: d */
    private void m16476d(boolean z) {
        if (z) {
            for (C3096a c3096a : m16502q()) {
                int m16465c = m16465c(c3096a);
                if (m16465c >= 0) {
                    this.f13788n.set(m16465c, c3096a);
                }
            }
        }
        m16496a(this.f13788n, z);
    }

    /* renamed from: q */
    public List<C3096a> m16502q() {
        return this.f13784j.m16522i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m16465c(C3096a c3096a) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f13788n.size()) {
                if (this.f13788n.get(i2).m18806a().equals(c3096a.m18806a())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public C3096a m16474d(String str) {
        if (!this.f13788n.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f13788n.size()) {
                    break;
                }
                C3096a c3096a = this.f13788n.get(i2);
                if (c3096a.m18806a().equals(str)) {
                    return c3096a;
                }
                i = i2 + 1;
            }
        }
        return (C3096a) null;
    }

    /* renamed from: e */
    private C3096a m16479e(String str) {
        if (!this.f13789o.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f13789o.size()) {
                    break;
                }
                C3096a c3096a = this.f13789o.get(i2);
                if (c3096a.m18806a().equals(str)) {
                    return c3096a;
                }
                i = i2 + 1;
            }
        }
        return (C3096a) null;
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (this.f13784j.m16513b()) {
            this.f13784j.m16520g();
        } else if (this.f13791q.getVisibility() == 0) {
            this.f13791q.setVisibility(8);
            m16468c("");
        } else {
            m16497a(false);
        }
    }

    /* renamed from: a */
    public void m16497a(boolean z) {
        if (this.f13782h) {
            m16470c(true);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!z && currentTimeMillis - this.f13781C > 2000) {
            C3112bn.m18999a(this, R.string.click_once_more);
            this.f13781C = currentTimeMillis;
        } else {
            finish();
        }
    }

    /* renamed from: a */
    public void m16496a(List<C3096a> list, boolean z) {
        Collections.sort(list, this.f13790p);
        this.f13784j.m16509a();
        this.f13784j.m16510a(list);
        this.f13782h = z;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m16473d(C3096a c3096a) {
        return m16451a(c3096a, false);
    }

    /* renamed from: a */
    private String m16451a(C3096a c3096a, boolean z) {
        int identifier;
        C3096a m16474d;
        int identifier2;
        C3096a m16474d2;
        if (c3096a.m18814f()) {
            String m18812d = c3096a.m18812d();
            if (m18812d.startsWith("@color/")) {
                String[] split = m18812d.split("/", 2);
                if (z) {
                    m16474d2 = m16479e(split[1]);
                } else {
                    m16474d2 = m16474d(split[1]);
                    if (m16474d2 == null) {
                        m16474d2 = m16479e(split[1]);
                        z = true;
                    }
                }
                if (m16474d2 != null) {
                    return m16451a(m16474d2, z);
                }
                return m18812d;
            }
            if (m18812d.startsWith("@android:color/") && (identifier2 = getResources().getIdentifier(m18812d.split("/", 2)[1], "color", "android")) > 0) {
                return String.format("#%08x", new Integer(C3246h.m19470a(this, identifier2) & (-1)));
            }
            return m18812d;
        }
        if (c3096a.m18813e() != null) {
            String m18813e = c3096a.m18813e();
            if (m18813e.startsWith("@color/")) {
                String[] split2 = m18813e.split("/", 2);
                if (z) {
                    m16474d = m16479e(split2[1]);
                } else {
                    m16474d = m16474d(split2[1]);
                    if (m16474d == null) {
                        m16474d = m16479e(split2[1]);
                        z = true;
                    }
                }
                if (m16474d != null) {
                    return m16451a(m16474d, z);
                }
            } else if (m18813e.startsWith("@android:color/") && (identifier = getResources().getIdentifier(m18813e.split("/", 2)[1], "color", "android")) > 0) {
                return String.format("#%08x", new Integer(C3246h.m19470a(this, identifier) & (-1)));
            }
        }
        return c3096a.m18811c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized C3313o m16481e(C3096a c3096a) {
        int i;
        String str;
        C3313o mo20032a;
        int i2 = 1;
        synchronized (this) {
            try {
                String m16473d = m16473d(c3096a);
                StringBuilder sb = new StringBuilder();
                if (m16473d.length() == 5) {
                    sb.append("#");
                    while (i2 < 5) {
                        sb.append(m16473d.charAt(i2)).append(m16473d.charAt(i2));
                        i2++;
                    }
                } else if (m16473d.length() == 4) {
                    sb.append("#");
                    while (i2 < 4) {
                        sb.append(m16473d.charAt(i2)).append(m16473d.charAt(i2));
                        i2++;
                    }
                } else {
                    sb.append(m16473d);
                }
                i = Color.parseColor(sb.toString());
                str = "";
            } catch (Exception e2) {
                i = -16777216;
                str = "?";
            }
            Typeface typeface = Typeface.DEFAULT;
            int m18522a = C3080al.m18522a((Context) this, 24);
            mo20032a = C3313o.m20017a().mo20029a().mo20031a(typeface).mo20040d(2).mo20030a(m18522a).mo20033b(m18522a).mo20041e(m18522a / 2).mo20037c(Color.LTGRAY).mo20034b().mo20032a(str, i);
        }
        return mo20032a;
    }

    /* renamed from: b */
    public void m16498b(String str) {
        int i = 1;
        int i2 = -16777216;
        if (str != null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (str.length() == 5) {
                    sb.append("#");
                    while (i < 5) {
                        sb.append(str.charAt(i)).append(str.charAt(i));
                        i++;
                    }
                } else if (str.length() == 4) {
                    sb.append("#");
                    while (i < 4) {
                        sb.append(str.charAt(i)).append(str.charAt(i));
                        i++;
                    }
                } else {
                    sb.append(str);
                }
                i2 = Color.parseColor(sb.toString());
            } catch (Exception e2) {
            }
        }
        new C3321c(this).m20105a(i2).m20108b(getString(R.string.select_color)).m20107a(new C3321c.a(this) { // from class: ru.maximoff.apktool.ColorsEditor.28

            /* renamed from: a */
            private final ColorsEditor f13879a;

            {
                this.f13879a = this;
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16420a(int i3) {
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: b */
            public void mo16422b(String str2) {
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16421a(String str2) {
                if (this.f13879a.f13779A[0] >= 0) {
                    for (int i3 : this.f13879a.f13779A) {
                        ((C3096a) this.f13879a.f13788n.get(i3)).m18810b(str2);
                    }
                    this.f13879a.f13782h = true;
                    if (this.f13879a.f13797w.equals("")) {
                        this.f13879a.m16496a(this.f13879a.f13788n, this.f13879a.f13782h);
                    } else {
                        this.f13879a.m16468c(this.f13879a.f13797w);
                    }
                    this.f13879a.f13779A = new int[]{-1};
                }
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16419a() {
                this.f13879a.f13779A = new int[]{-1};
            }
        }).m20109b();
    }

    /* renamed from: b */
    public void m16499b(boolean z) {
        this.f13782h = z;
        this.f13784j.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m16482f(String str) {
        int parseColor = Color.parseColor(str);
        return String.format("#%08x", new Integer(Color.argb(Color.alpha(parseColor), 255 - Color.red(parseColor), 255 - Color.green(parseColor), 255 - Color.blue(parseColor)) & (-1)));
    }

    /* renamed from: ru.maximoff.apktool.ColorsEditor$a */
    private class C2691a extends BaseAdapter {

        /* renamed from: a */
        private List<C3096a> f13897a;

        /* renamed from: b */
        private List<Integer> f13898b;

        /* renamed from: c */
        private int f13899c = 0;

        /* renamed from: d */
        private final ColorsEditor f13900d;

        /* renamed from: a */
        static ColorsEditor m16507a(C2691a c2691a) {
            return c2691a.f13900d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m16508a(i);
        }

        public C2691a(ColorsEditor colorsEditor, List<C3096a> list) {
            this.f13900d = colorsEditor;
            this.f13897a = (List) null;
            this.f13898b = (List) null;
            this.f13897a = list;
            this.f13898b = new ArrayList();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f13897a != null) {
                return this.f13897a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i * 8;
        }

        /* renamed from: a */
        public C3096a m16508a(int i) {
            return (this.f13897a == null || i >= this.f13897a.size()) ? (C3096a) null : this.f13897a.get(i);
        }

        /* renamed from: a */
        public void m16510a(List<C3096a> list) {
            this.f13897a.addAll(list);
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void m16509a() {
            this.f13898b.clear();
            this.f13897a.clear();
        }

        /* renamed from: b */
        public void m16512b(int i) {
            C3096a m16508a = m16508a(i);
            if (m16508a != null) {
                int m16465c = this.f13900d.m16465c(m16508a);
                this.f13897a.remove(i);
                if (m16465c >= 0) {
                    this.f13900d.f13788n.remove(m16465c);
                }
                this.f13900d.f13782h = true;
            }
            notifyDataSetChanged();
        }

        /* renamed from: b */
        public boolean m16513b() {
            return !this.f13898b.isEmpty();
        }

        /* renamed from: c */
        public void m16515c(int i) {
            if (this.f13898b.contains(new Integer(i))) {
                this.f13898b.remove(new Integer(i));
            } else {
                this.f13898b.add(new Integer(i));
            }
            notifyDataSetChanged();
        }

        /* renamed from: c */
        public void m16514c() {
            this.f13898b.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f13897a.size()) {
                    if (this.f13897a.get(i2).m18814f() || this.f13897a.get(i2).m18815g()) {
                        m16515c(i2);
                    }
                    i = i2 + 1;
                } else {
                    notifyDataSetChanged();
                    return;
                }
            }
        }

        /* renamed from: a */
        public void m16511a(boolean z) {
            if (!z) {
                this.f13898b.clear();
            }
            for (int i = 0; i < this.f13897a.size(); i++) {
                m16515c(i);
            }
            notifyDataSetChanged();
        }

        /* renamed from: d */
        public void m16517d(int i) {
            if (m16513b()) {
                Collections.sort(this.f13898b);
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f13898b.size()) {
                        break;
                    }
                    int intValue = this.f13898b.get(i3).intValue();
                    if (i3 == 0 && i < intValue) {
                        while (i < intValue) {
                            m16515c(i);
                            i++;
                        }
                    } else {
                        if (intValue >= i) {
                            break;
                        }
                        i3++;
                        i2 = intValue;
                    }
                }
                if (i2 >= 0) {
                    while (i2 < i) {
                        i2++;
                        m16515c(i2);
                    }
                }
                notifyDataSetChanged();
            }
        }

        /* renamed from: d */
        public void m16516d() {
            if (m16513b()) {
                Collections.sort(this.f13898b);
                for (int size = this.f13898b.size(); size > 0; size--) {
                    m16512b(this.f13898b.get(size - 1).intValue());
                }
                m16520g();
            }
        }

        /* renamed from: e */
        public void m16518e() {
            if (m16513b()) {
                int i = 0;
                for (Integer num : this.f13898b) {
                    C3096a c3096a = this.f13897a.get(num.intValue());
                    if (c3096a.m18814f() || c3096a.m18815g()) {
                        this.f13897a.get(num.intValue()).m18810b((String) null);
                        this.f13897a.get(num.intValue()).m18807a((String) null);
                        i++;
                    }
                }
                if (!this.f13900d.f13782h) {
                    this.f13900d.f13782h = i > 0;
                }
                m16520g();
            }
        }

        /* renamed from: f */
        public void m16519f() {
            if (m16513b()) {
                Iterator<Integer> it = this.f13898b.iterator();
                int i = 0;
                while (it.hasNext()) {
                    C3096a c3096a = this.f13897a.get(it.next().intValue());
                    try {
                        c3096a.m18810b(this.f13900d.m16482f(this.f13900d.m16473d(c3096a)));
                        i++;
                    } catch (Exception e2) {
                    }
                }
                if (!this.f13900d.f13782h) {
                    this.f13900d.f13782h = i > 0;
                }
                m16520g();
            }
        }

        /* renamed from: g */
        public void m16520g() {
            this.f13898b.clear();
            notifyDataSetChanged();
        }

        /* renamed from: h */
        public int[] m16521h() {
            int[] iArr = new int[this.f13898b.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f13898b.size()) {
                    iArr[i2] = this.f13900d.m16465c(this.f13897a.get(this.f13898b.get(i2).intValue()));
                    i = i2 + 1;
                } else {
                    return iArr;
                }
            }
        }

        /* renamed from: i */
        public List<C3096a> m16522i() {
            return this.f13897a;
        }

        /* renamed from: j */
        public List<C3096a> m16523j() {
            if (m16513b()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = this.f13898b.iterator();
                while (it.hasNext()) {
                    C3096a m16508a = m16508a(it.next().intValue());
                    if (m16508a != null) {
                        arrayList.add(m16508a);
                    }
                }
                return arrayList;
            }
            return this.f13897a;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            this.f13899c = 0;
            this.f13900d.m16500o();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C2692b c2692b;
            C3096a c3096a = this.f13897a.get(i);
            if (view == null) {
                view = ((LayoutInflater) this.f13900d.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                C2692b c2692b2 = new C2692b(this.f13900d);
                c2692b2.f13939a = (ImageView) view.findViewById(R.id.icon);
                c2692b2.f13940b = (TextView) view.findViewById(R.id.name);
                c2692b2.f13941c = (TextView) view.findViewById(R.id.details);
                view.setTag(c2692b2);
                c2692b = c2692b2;
            } else {
                c2692b = (C2692b) view.getTag();
            }
            boolean contains = this.f13898b.contains(new Integer(i));
            if (contains) {
                view.setBackgroundColor(C3246h.m19470a(this.f13900d.f13783i, R.color.tvery_light_blue));
            } else if (c3096a.m18814f() || c3096a.m18815g()) {
                view.setBackgroundColor(C3246h.m19470a(this.f13900d.f13783i, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
            } else {
                view.setBackgroundColor(0);
            }
            c2692b.f13939a.setImageDrawable(this.f13900d.m16481e(c3096a));
            c2692b.f13939a.setBackgroundResource(R.drawable.alpha);
            c2692b.f13940b.setText(c3096a.m18814f() ? c3096a.m18812d() : c3096a.m18811c());
            c2692b.f13940b.setTextSize(2, C3102bd.f18332o);
            c2692b.f13941c.setText(c3096a.m18815g() ? c3096a.m18809b() : c3096a.m18806a());
            c2692b.f13941c.setTextSize(2, C3102bd.f18332o - 2);
            view.setOnClickListener(new View.OnClickListener(this, i, c3096a) { // from class: ru.maximoff.apktool.ColorsEditor.a.1

                /* renamed from: a */
                private final C2691a f13901a;

                /* renamed from: b */
                private final int f13902b;

                /* renamed from: c */
                private final C3096a f13903c;

                {
                    this.f13901a = this;
                    this.f13902b = i;
                    this.f13903c = c3096a;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (this.f13901a.m16513b()) {
                        this.f13901a.m16515c(this.f13902b);
                    } else {
                        C2691a.m16507a(this.f13901a).f13779A[0] = C2691a.m16507a(this.f13901a).m16465c(this.f13903c);
                        C2691a.m16507a(this.f13901a).m16498b(C2691a.m16507a(this.f13901a).m16473d(this.f13903c));
                    }
                }
            });
            view.setOnLongClickListener(new AnonymousClass2(this, contains, i, c3096a));
            return view;
        }

        /* renamed from: ru.maximoff.apktool.ColorsEditor$a$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final C2691a f13904a;

            /* renamed from: b */
            private final boolean f13905b;

            /* renamed from: c */
            private final int f13906c;

            /* renamed from: d */
            private final C3096a f13907d;

            AnonymousClass2(C2691a c2691a, boolean z, int i, C3096a c3096a) {
                this.f13904a = c2691a;
                this.f13905b = z;
                this.f13906c = i;
                this.f13907d = c3096a;
            }

            /* renamed from: a */
            static C2691a m16524a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f13904a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                C0173ao c0173ao = new C0173ao(C2691a.m16507a(this.f13904a).f13783i, view);
                if (C3102bd.m18910a(C2691a.m16507a(this.f13904a).f13783i, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                if (!this.f13904a.m16513b()) {
                    i2 = 1900;
                } else {
                    if (!this.f13905b) {
                        c0173ao.m1339a().add(0, 1900, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.mselect_to)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13906c) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f13908a;

                            /* renamed from: b */
                            private final int f13909b;

                            {
                                this.f13908a = this;
                                this.f13909b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                AnonymousClass2.m16524a(this.f13908a).m16517d(this.f13909b);
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                        return true;
                    }
                    i2 = 1901;
                    c0173ao.m1339a().add(0, 1900, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.edit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.2

                        /* renamed from: a */
                        private final AnonymousClass2 f13921a;

                        /* renamed from: b */
                        private final C3096a f13922b;

                        {
                            this.f13921a = this;
                            this.f13922b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13921a)).f13779A = AnonymousClass2.m16524a(this.f13921a).m16521h();
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13921a)).m16498b(C2691a.m16507a(AnonymousClass2.m16524a(this.f13921a)).m16473d(this.f13922b));
                            return true;
                        }
                    });
                }
                int i6 = i2 + 1;
                c0173ao.m1339a().add(0, i2, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.invert_color)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.3

                    /* renamed from: a */
                    private final AnonymousClass2 f13923a;

                    /* renamed from: b */
                    private final C3096a f13924b;

                    {
                        this.f13923a = this;
                        this.f13924b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (AnonymousClass2.m16524a(this.f13923a).m16513b()) {
                            AnonymousClass2.m16524a(this.f13923a).m16519f();
                        } else {
                            try {
                                this.f13924b.m18810b(C2691a.m16507a(AnonymousClass2.m16524a(this.f13923a)).m16482f(C2691a.m16507a(AnonymousClass2.m16524a(this.f13923a)).m16473d(this.f13924b)));
                                C2691a.m16507a(AnonymousClass2.m16524a(this.f13923a)).f13782h = true;
                            } catch (Exception e2) {
                                C3112bn.m18999a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13923a)).f13783i, R.string.error);
                            }
                            AnonymousClass2.m16524a(this.f13923a).notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                int i7 = i6 + 1;
                c0173ao.m1339a().add(0, i6, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.delete)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13906c) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.4

                    /* renamed from: a */
                    private final AnonymousClass2 f13925a;

                    /* renamed from: b */
                    private final int f13926b;

                    {
                        this.f13925a = this;
                        this.f13926b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (AnonymousClass2.m16524a(this.f13925a).m16513b()) {
                            AnonymousClass2.m16524a(this.f13925a).m16516d();
                            return true;
                        }
                        AnonymousClass2.m16524a(this.f13925a).m16512b(this.f13926b);
                        return true;
                    }
                });
                if (this.f13907d.m18814f() || this.f13907d.m18815g() || this.f13904a.m16513b()) {
                    c0173ao.m1339a().add(0, i7, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.5

                        /* renamed from: a */
                        private final AnonymousClass2 f13927a;

                        /* renamed from: b */
                        private final C3096a f13928b;

                        {
                            this.f13927a = this;
                            this.f13928b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (AnonymousClass2.m16524a(this.f13927a).m16513b()) {
                                AnonymousClass2.m16524a(this.f13927a).m16518e();
                                return true;
                            }
                            this.f13928b.m18810b((String) null);
                            this.f13928b.m18807a((String) null);
                            AnonymousClass2.m16524a(this.f13927a).notifyDataSetChanged();
                            return true;
                        }
                    });
                    i7++;
                }
                if (!this.f13904a.m16513b()) {
                    int i8 = i7 + 1;
                    c0173ao.m1339a().add(0, i7, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.enter_man)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.6

                        /* renamed from: a */
                        private final AnonymousClass2 f13929a;

                        /* renamed from: b */
                        private final C3096a f13930b;

                        {
                            this.f13929a = this;
                            this.f13930b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13929a)).m16457a(this.f13930b);
                            return true;
                        }
                    });
                    int i9 = i8 + 1;
                    c0173ao.m1339a().add(0, i8, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.rename)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.7

                        /* renamed from: a */
                        private final AnonymousClass2 f13931a;

                        /* renamed from: b */
                        private final C3096a f13932b;

                        {
                            this.f13931a = this;
                            this.f13932b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13931a)).m16463b(this.f13932b);
                            return true;
                        }
                    });
                    if (this.f13907d.m18813e() == null || !this.f13907d.m18813e().startsWith("@color/")) {
                        i5 = i9;
                    } else {
                        i5 = i9 + 1;
                        c0173ao.m1339a().add(0, i9, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.show_orig)).setOnMenuItemClickListener(new AnonymousClass8(this, this.f13907d));
                    }
                    int i10 = i5 + 1;
                    c0173ao.m1339a().add(0, i5, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.cp_name)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13907d) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.9

                        /* renamed from: a */
                        private final AnonymousClass2 f13937a;

                        /* renamed from: b */
                        private final C3096a f13938b;

                        {
                            this.f13937a = this;
                            this.f13938b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3112bn.m19002a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13937a)).f13783i, this.f13938b.m18815g() ? this.f13938b.m18809b() : this.f13938b.m18806a());
                            return true;
                        }
                    });
                    int i11 = i10 + 1;
                    c0173ao.m1339a().add(0, i10, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.copy_value)).setOnMenuItemClickListener(new AnonymousClass10(this, this.f13907d));
                    int i12 = i11 + 1;
                    c0173ao.m1339a().add(0, i11, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.mselect)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f13906c) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.11

                        /* renamed from: a */
                        private final AnonymousClass2 f13914a;

                        /* renamed from: b */
                        private final int f13915b;

                        {
                            this.f13914a = this;
                            this.f13915b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass2.m16524a(this.f13914a).m16515c(this.f13915b);
                            return true;
                        }
                    });
                    if (C2691a.m16507a(this.f13904a).f13782h) {
                        i4 = i12 + 1;
                        c0173ao.m1339a().add(0, i12, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.select_mod)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.12

                            /* renamed from: a */
                            private final AnonymousClass2 f13916a;

                            {
                                this.f13916a = this;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                AnonymousClass2.m16524a(this.f13916a).m16514c();
                                return true;
                            }
                        });
                    } else {
                        i4 = i12;
                    }
                    String m16495a = C2691a.m16507a(this.f13904a).m16495a(this.f13907d.m18806a());
                    if (m16495a != null) {
                        i3 = i4 + 1;
                        c0173ao.m1339a().add(0, i4, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.copy_id)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m16495a) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.13

                            /* renamed from: a */
                            private final AnonymousClass2 f13917a;

                            /* renamed from: b */
                            private final String f13918b;

                            {
                                this.f13917a = this;
                                this.f13918b = m16495a;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3112bn.m19002a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13917a)).f13783i, this.f13918b);
                                return true;
                            }
                        });
                    }
                    int i13 = i4 + 1;
                    c0173ao.m1339a().add(0, i4, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.mselect_all)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.15

                        /* renamed from: a */
                        private final AnonymousClass2 f13920a;

                        {
                            this.f13920a = this;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass2.m16524a(this.f13920a).m16511a(false);
                            return true;
                        }
                    });
                    c0173ao.m1344c();
                    return true;
                }
                i3 = i7 + 1;
                c0173ao.m1339a().add(0, i7, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.mselect_inv)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.14

                    /* renamed from: a */
                    private final AnonymousClass2 f13919a;

                    {
                        this.f13919a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass2.m16524a(this.f13919a).m16511a(true);
                        return true;
                    }
                });
                i4 = i3;
                int i132 = i4 + 1;
                c0173ao.m1339a().add(0, i4, 0, C2691a.m16507a(this.f13904a).f13783i.getString(R.string.mselect_all)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.15

                    /* renamed from: a */
                    private final AnonymousClass2 f13920a;

                    {
                        this.f13920a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass2.m16524a(this.f13920a).m16511a(false);
                        return true;
                    }
                });
                c0173ao.m1344c();
                return true;
            }

            /* renamed from: ru.maximoff.apktool.ColorsEditor$a$2$8, reason: invalid class name */
            class AnonymousClass8 implements MenuItem.OnMenuItemClickListener {

                /* renamed from: a */
                private final AnonymousClass2 f13933a;

                /* renamed from: b */
                private final C3096a f13934b;

                AnonymousClass8(AnonymousClass2 anonymousClass2, C3096a c3096a) {
                    this.f13933a = anonymousClass2;
                    this.f13934b = c3096a;
                }

                /* renamed from: a */
                static AnonymousClass2 m16526a(AnonymousClass8 anonymousClass8) {
                    return anonymousClass8.f13933a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    int m16465c;
                    C3096a m16474d = C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).m16474d(this.f13934b.m18813e().split("/", 2)[1]);
                    if (m16474d != null && (m16465c = C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).m16465c(m16474d)) >= 0) {
                        if (C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).f13791q.getVisibility() == 0) {
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).f13791q.setVisibility(8);
                            C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).m16468c("");
                        }
                        AnonymousClass2.m16524a(this.f13933a).m16515c(m16465c);
                        C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).f13798x.setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, m16465c) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.8.1

                            /* renamed from: a */
                            private final AnonymousClass8 f13935a;

                            /* renamed from: b */
                            private final int f13936b;

                            {
                                this.f13935a = this;
                                this.f13936b = m16465c;
                            }

                            @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
                            /* renamed from: a */
                            public void mo16527a() {
                                C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass8.m16526a(this.f13935a))).f13798x.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    View childAt = C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass8.m16526a(this.f13935a))).f13798x.getChildAt(0);
                                    C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass8.m16526a(this.f13935a))).f13798x.setSelectionFromTop(this.f13936b, childAt == null ? 0 : childAt.getTop() - C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass8.m16526a(this.f13935a))).f13798x.getPaddingTop());
                                } else {
                                    C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass8.m16526a(this.f13935a))).f13798x.setSelection(this.f13936b);
                                }
                            }
                        });
                        AnonymousClass2.m16524a(this.f13933a).notifyDataSetChanged();
                    } else {
                        C3112bn.m18999a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13933a)).f13783i, R.string.error);
                    }
                    return true;
                }
            }

            /* renamed from: ru.maximoff.apktool.ColorsEditor$a$2$10, reason: invalid class name */
            class AnonymousClass10 implements MenuItem.OnMenuItemClickListener {

                /* renamed from: a */
                private final AnonymousClass2 f13910a;

                /* renamed from: b */
                private final C3096a f13911b;

                AnonymousClass10(AnonymousClass2 anonymousClass2, C3096a c3096a) {
                    this.f13910a = anonymousClass2;
                    this.f13911b = c3096a;
                }

                /* renamed from: a */
                static AnonymousClass2 m16525a(AnonymousClass10 anonymousClass10) {
                    return anonymousClass10.f13910a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (!this.f13911b.m18814f() || this.f13911b.m18812d().startsWith("@android:color/") || this.f13911b.m18812d().startsWith("@color/")) {
                        String m16473d = C2691a.m16507a(AnonymousClass2.m16524a(this.f13910a)).m16473d(this.f13911b);
                        String m18812d = this.f13911b.m18814f() ? this.f13911b.m18812d() : this.f13911b.m18811c();
                        if (!m16473d.equalsIgnoreCase(m18812d)) {
                            String[] strArr = {m16473d, m18812d};
                            new DialogInterfaceC0070b.a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13910a)).f13783i).m431a(strArr, new DialogInterface.OnClickListener(this, strArr) { // from class: ru.maximoff.apktool.ColorsEditor.a.2.10.1

                                /* renamed from: a */
                                private final AnonymousClass10 f13912a;

                                /* renamed from: b */
                                private final String[] f13913b;

                                {
                                    this.f13912a = this;
                                    this.f13913b = strArr;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    C3112bn.m19002a(C2691a.m16507a(AnonymousClass2.m16524a(AnonymousClass10.m16525a(this.f13912a))).f13783i, this.f13913b[i]);
                                    dialogInterface.dismiss();
                                }
                            }).m438b().show();
                        } else {
                            C3112bn.m19002a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13910a)).f13783i, m18812d);
                        }
                    } else {
                        C3112bn.m19002a(C2691a.m16507a(AnonymousClass2.m16524a(this.f13910a)).f13783i, this.f13911b.m18812d());
                    }
                    return true;
                }
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.ColorsEditor$b */
    private class C2692b {

        /* renamed from: a */
        public ImageView f13939a;

        /* renamed from: b */
        public TextView f13940b;

        /* renamed from: c */
        public TextView f13941c;

        /* renamed from: d */
        private final ColorsEditor f13942d;

        public C2692b(ColorsEditor colorsEditor) {
            this.f13942d = colorsEditor;
        }
    }
}
