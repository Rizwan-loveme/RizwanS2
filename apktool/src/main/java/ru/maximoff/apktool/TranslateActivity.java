package ru.maximoff.apktool;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0170al;
import androidx.appcompat.widget.C0173ao;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1386h;
import com.p159h.p160a.p162b.C1396r;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.XMLConstants;
import p046b.p047a.p050c.p051a.C0497h;
import ru.maximoff.apktool.p296a.C2892l;
import ru.maximoff.apktool.p296a.C2893m;
import ru.maximoff.apktool.service.C3055a;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3224d;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3230j;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3231k;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3232l;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3233m;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3234n;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3235o;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3238r;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3240t;
import ru.maximoff.apktool.util.p308f.C3225e;
import ru.maximoff.apktool.util.p308f.C3228h;
import ru.maximoff.apktool.util.p308f.C3236p;
import ru.maximoff.apktool.util.p308f.C3237q;
import ru.maximoff.apktool.util.p308f.C3239s;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.apktool.view.Editor;

/* loaded from: classes.dex */
public class TranslateActivity extends AbstractActivityC2894b {

    /* renamed from: j */
    private static TranslateActivity f14479j;

    /* renamed from: A */
    private boolean f14480A;

    /* renamed from: B */
    private boolean f14481B;

    /* renamed from: C */
    private boolean f14482C;

    /* renamed from: D */
    private boolean f14483D;

    /* renamed from: E */
    private LinearLayout f14484E;

    /* renamed from: F */
    private EditText f14485F;

    /* renamed from: G */
    private CheckBox f14486G;

    /* renamed from: H */
    private CheckBox f14487H;

    /* renamed from: I */
    private List<C3236p> f14488I;

    /* renamed from: J */
    private String f14489J;

    /* renamed from: K */
    private String f14490K;

    /* renamed from: L */
    private String f14491L;

    /* renamed from: M */
    private Comparator f14492M;

    /* renamed from: N */
    private List<C3090av> f14493N;

    /* renamed from: O */
    private long f14494O = 0;

    /* renamed from: P */
    private String[] f14495P;

    /* renamed from: Q */
    private String[] f14496Q;

    /* renamed from: h */
    public boolean f14497h;

    /* renamed from: i */
    public boolean f14498i;

    /* renamed from: k */
    private Context f14499k;

    /* renamed from: l */
    private CustomListView f14500l;

    /* renamed from: m */
    private Spinner f14501m;

    /* renamed from: n */
    private Spinner f14502n;

    /* renamed from: o */
    private C2878a f14503o;

    /* renamed from: p */
    private File f14504p;

    /* renamed from: q */
    private String[] f14505q;

    /* renamed from: r */
    private String[] f14506r;

    /* renamed from: s */
    private String f14507s;

    /* renamed from: t */
    private String f14508t;

    /* renamed from: u */
    private boolean f14509u;

    /* renamed from: v */
    private boolean f14510v;

    /* renamed from: w */
    private boolean f14511w;

    /* renamed from: x */
    private boolean f14512x;

    /* renamed from: y */
    private boolean f14513y;

    /* renamed from: z */
    private boolean f14514z;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f14504p != null) {
            bundle.putString("PROJECT_DIRECTORY", this.f14504p.getAbsolutePath());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("PROJECT_DIRECTORY", (String) null);
        if (string != null) {
            this.f14504p = new File(string);
        }
    }

    /* renamed from: o */
    public static TranslateActivity m16820o() {
        return f14479j;
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
            this.f14514z = intent.getBooleanExtra("smali", false);
            this.f14480A = intent.getBooleanExtra(XMLConstants.XML_NS_PREFIX, false);
            if (intent.hasExtra("smali_dirs")) {
                this.f14496Q = intent.getStringArrayExtra("smali_dirs");
            } else {
                this.f14496Q = (String[]) null;
            }
            this.f14504p = new File(intent.getStringExtra("data"));
            if (this.f14514z || this.f14480A) {
                findViewById(R.id.translateLinearLayout2).setVisibility(8);
                findViewById(R.id.translateView1).setVisibility(8);
                this.f14505q = new String[]{""};
            } else {
                this.f14505q = C3239s.m19433e(this.f14504p.getAbsolutePath());
                if (this.f14505q == null || this.f14505q.length == 0) {
                    throw new FileNotFoundException(getString(R.string.not_found));
                }
            }
            this.f14499k = this;
            f14479j = this;
            this.f14497h = false;
            this.f14498i = false;
            this.f14481B = false;
            this.f14482C = false;
            this.f14491L = "";
            this.f14495P = getResources().getStringArray(R.array.date_variants);
            this.f14490K = C3080al.m18600g(this);
            this.f14507s = this.f14505q[0];
            if (this.f14507s.contains("-")) {
                this.f14489J = this.f14507s.split("-", 2)[1];
            } else {
                this.f14489J = "";
            }
            ImageView imageView = (ImageView) findViewById(R.id.clearText1);
            if (C3102bd.f18291a) {
                imageView.setImageResource(R.drawable.ic_close);
            } else {
                imageView.setImageResource(R.drawable.ic_close_dark);
            }
            this.f14484E = (LinearLayout) findViewById(R.id.translateLinearLayout1);
            this.f14485F = (EditText) findViewById(R.id.translateEditText1);
            this.f14486G = (CheckBox) findViewById(R.id.translateCheckBox1);
            this.f14486G.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.1

                /* renamed from: a */
                private final TranslateActivity f14515a;

                {
                    this.f14515a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14515a.f14481B = this.f14515a.f14486G.isChecked();
                    this.f14515a.m16798d(this.f14515a.f14491L);
                }
            });
            this.f14487H = (CheckBox) findViewById(R.id.translateCheckBox2);
            this.f14487H.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.2

                /* renamed from: a */
                private final TranslateActivity f14545a;

                {
                    this.f14545a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14545a.f14482C = this.f14545a.f14487H.isChecked();
                    this.f14545a.m16798d(this.f14545a.f14491L);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.3

                /* renamed from: a */
                private final TranslateActivity f14581a;

                {
                    this.f14581a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14581a.f14485F.requestFocus();
                    this.f14581a.f14485F.setText("");
                }
            });
            if (this.f14485F.getText().length() == 0) {
                imageView.setVisibility(8);
            }
            C3112bn.m19006a(this.f14485F, 10000);
            this.f14485F.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.TranslateActivity.4

                /* renamed from: a */
                private final TranslateActivity f14639a;

                /* renamed from: b */
                private final ImageView f14640b;

                {
                    this.f14639a = this;
                    this.f14640b = imageView;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (this.f14639a.f14503o != null) {
                        if (editable.length() == 0) {
                            this.f14640b.setVisibility(8);
                        } else {
                            this.f14640b.setVisibility(0);
                        }
                        this.f14639a.m16798d(editable.toString());
                        this.f14639a.f14485F.requestFocus();
                    }
                }
            });
            C3212b c3212b = new C3212b(this, "translate");
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
            imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.TranslateActivity.5

                /* renamed from: a */
                private final TranslateActivity f14688a;

                /* renamed from: b */
                private final C3212b f14689b;

                /* renamed from: c */
                private final ImageView f14690c;

                {
                    this.f14688a = this;
                    this.f14689b = c3212b;
                    this.f14690c = imageView2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14689b.m19201a(this.f14690c, this.f14688a.f14485F);
                }
            });
            imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.TranslateActivity.6

                /* renamed from: a */
                private final TranslateActivity f14742a;

                /* renamed from: b */
                private final C3212b f14743b;

                /* renamed from: c */
                private final ImageView f14744c;

                {
                    this.f14742a = this;
                    this.f14743b = c3212b;
                    this.f14744c = imageView2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    new C3078aj(this.f14742a.f14499k).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14743b, this.f14744c) { // from class: ru.maximoff.apktool.TranslateActivity.6.1

                        /* renamed from: a */
                        private final ViewOnLongClickListenerC28716 f14745a;

                        /* renamed from: b */
                        private final C3212b f14746b;

                        /* renamed from: c */
                        private final ImageView f14747c;

                        {
                            this.f14745a = this;
                            this.f14746b = r2;
                            this.f14747c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14746b.m19208d();
                            this.f14747c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            this.f14485F.setImeOptions(3);
            this.f14485F.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.TranslateActivity.7

                /* renamed from: a */
                private final TranslateActivity f14781a;

                /* renamed from: b */
                private final C3212b f14782b;

                /* renamed from: c */
                private final ImageView f14783c;

                {
                    this.f14781a = this;
                    this.f14782b = c3212b;
                    this.f14783c = imageView2;
                }

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    this.f14781a.m16798d(this.f14781a.f14485F.getText().toString());
                    if (this.f14782b.m19204a(this.f14781a.f14485F.getText().toString())) {
                        this.f14783c.setVisibility(0);
                    }
                    return true;
                }
            });
            this.f14500l = (CustomListView) findViewById(R.id.translateListView1);
            this.f14500l.setFastScrollEnabled(C3102bd.f18314av);
            this.f14501m = (Spinner) findViewById(R.id.translateSpinner1);
            this.f14502n = (Spinner) findViewById(R.id.translateSpinner2);
            this.f14502n.setVisibility(0);
            if (this.f14514z || this.f14480A) {
                this.f14506r = new String[]{""};
            } else {
                this.f14506r = C3239s.m19424a(new File(this.f14504p, new StringBuffer().append("/res/").append(this.f14507s).toString()));
            }
            this.f14508t = this.f14506r[0];
            this.f14509u = true;
            this.f14501m.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14505q));
            this.f14509u = true;
            this.f14501m.setSelection(0);
            this.f14509u = true;
            this.f14502n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14506r));
            this.f14509u = true;
            this.f14502n.setSelection(0);
            this.f14501m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.8

                /* renamed from: a */
                private final TranslateActivity f14784a;

                {
                    this.f14784a = this;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.f14784a.f14509u) {
                        this.f14784a.f14509u = false;
                        return;
                    }
                    if (this.f14784a.f14498i) {
                        this.f14784a.f14509u = true;
                        this.f14784a.m16806e(false);
                        int i2 = 0;
                        while (true) {
                            if (i2 < this.f14784a.f14505q.length) {
                                if (this.f14784a.f14505q[i2].equals(this.f14784a.f14507s)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            } else {
                                i2 = 0;
                                break;
                            }
                        }
                        this.f14784a.f14501m.setSelection(i2);
                        return;
                    }
                    this.f14784a.f14507s = this.f14784a.f14505q[i];
                    if (this.f14784a.f14507s.contains("-")) {
                        this.f14784a.f14489J = this.f14784a.f14507s.split("-", 2)[1];
                    } else {
                        this.f14784a.f14489J = "";
                    }
                    this.f14784a.f14506r = C3239s.m19424a(new File(this.f14784a.f14504p, new StringBuffer().append("/res/").append(this.f14784a.f14507s).toString()));
                    this.f14784a.f14508t = this.f14784a.f14506r[0];
                    this.f14784a.f14502n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14784a.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14784a.f14506r));
                    this.f14784a.f14502n.setSelection(0);
                    this.f14784a.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14784a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14784a.f14507s).toString()).append("/").toString()).append(this.f14784a.f14508t).toString()).append(".xml").toString());
                    this.f14784a.m16842a(this.f14784a.f14488I, false);
                }
            });
            this.f14502n.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.9

                /* renamed from: a */
                private final TranslateActivity f14785a;

                {
                    this.f14785a = this;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.f14785a.f14509u) {
                        this.f14785a.f14509u = false;
                        return;
                    }
                    if (this.f14785a.f14498i) {
                        this.f14785a.f14509u = true;
                        this.f14785a.m16806e(false);
                        int i2 = 0;
                        while (true) {
                            if (i2 < this.f14785a.f14506r.length) {
                                if (this.f14785a.f14506r[i2].equals(this.f14785a.f14508t)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            } else {
                                i2 = 0;
                                break;
                            }
                        }
                        this.f14785a.f14502n.setSelection(i2);
                        return;
                    }
                    this.f14785a.f14508t = this.f14785a.f14506r[i];
                    this.f14785a.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14785a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14785a.f14507s).toString()).append("/").toString()).append(this.f14785a.f14508t).toString()).append(".xml").toString());
                    this.f14785a.m16842a(this.f14785a.f14488I, false);
                }
            });
            this.f14510v = C3102bd.m18925a((Context) this, "mtr_line_num", true);
            this.f14511w = C3102bd.m18925a((Context) this, "mtr_sort_strings", true);
            this.f14512x = C3102bd.m18925a((Context) this, "mtr_first_notrans", false);
            this.f14513y = C3102bd.m18925a((Context) this, "mtr_old_layout", false);
            this.f14483D = C3102bd.m18925a((Context) this, "mtr_hide_trans", false);
            this.f14492M = new Comparator<C3236p>(this) { // from class: ru.maximoff.apktool.TranslateActivity.10

                /* renamed from: a */
                private final TranslateActivity f14516a;

                {
                    this.f14516a = this;
                }

                @Override // java.util.Comparator
                public int compare(C3236p c3236p, C3236p c3236p2) {
                    return m16852a(c3236p, c3236p2);
                }

                /* renamed from: a */
                public int m16852a(C3236p c3236p, C3236p c3236p2) {
                    if (this.f14516a.f14512x && !this.f14516a.f14483D && this.f14516a.f14508t.equals("strings")) {
                        if (c3236p.m19390k() && !c3236p2.m19390k()) {
                            return 1;
                        }
                        if (!c3236p.m19390k() && c3236p2.m19390k()) {
                            return -1;
                        }
                    }
                    return c3236p.m19381e().compareTo(c3236p2.m19381e());
                }
            };
            if (this.f14514z || this.f14480A) {
                this.f14493N = new ArrayList();
                try {
                    if (this.f14514z) {
                        new AsyncTaskC3235o(this, this.f14504p, this.f14496Q).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) null);
                    } else {
                        new AsyncTaskC3240t(this, this.f14504p).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) null);
                    }
                    return;
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f14499k, R.string.error_try_again);
                    return;
                }
            }
            File file = new File(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/values/public.xml").toString());
            if (file.isFile()) {
                this.f14493N = C3061a.m18326d(file);
            } else {
                this.f14493N = new ArrayList();
            }
            this.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14507s).toString()).append("/").toString()).append(this.f14508t).toString()).append(".xml").toString());
            this.f14503o = new C2878a(this, new ArrayList());
            this.f14500l.setAdapter((ListAdapter) this.f14503o);
            m16842a(this.f14488I, this.f14498i);
        } catch (Exception e3) {
            C3112bn.m19023b(this, getString(R.string.errorf, e3.getMessage()));
            finish();
        }
    }

    /* renamed from: p */
    public void m16849p() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.TranslateActivity.11

            /* renamed from: a */
            private final TranslateActivity f14517a;

            {
                this.f14517a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                String name = this.f14517a.f14504p.getName();
                if (this.f14517a.f14498i) {
                    name = new StringBuffer().append("*").append(name).toString();
                }
                this.f14517a.m454f().mo390a(name);
            }
        }, 100L);
    }

    /* renamed from: a */
    public String m16840a(String str) {
        if (this.f14514z || this.f14480A) {
            return (String) null;
        }
        String substring = this.f14508t.substring(0, this.f14508t.length() - 1);
        for (C3090av c3090av : this.f14493N) {
            if (c3090av.m18724a().equals(substring) && str.equals(c3090av.m18727b())) {
                return c3090av.m18730d();
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    public void m16841a(List<C3236p> list) {
        if (list.isEmpty()) {
            C3112bn.m18999a(this, R.string.not_found);
            finish();
            return;
        }
        this.f14488I = new ArrayList();
        this.f14488I.addAll(list);
        this.f14503o = new C2878a(this, new ArrayList());
        this.f14500l.setAdapter((ListAdapter) this.f14503o);
        m16842a(this.f14488I, this.f14498i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16777a(File file, int i) {
        AbstractRunnableC1391m c2893m;
        if (C3102bd.f18287W) {
            c2893m = C1396r.f9139c;
        } else if (this.f14514z) {
            c2893m = new C2892l((C3055a) null);
        } else {
            c2893m = new C2893m((C3055a) null);
        }
        boolean[] zArr = {C3102bd.m18925a((Context) this, "preview_word_wrap", false)};
        C1386h c1386h = new C1386h();
        String m18332i = C3061a.m18332i(file);
        Editor editor = new Editor(this);
        editor.setLexTask(c2893m);
        editor.setDocumentProvider(c1386h);
        editor.m19756h(false);
        editor.setCharset("UTF-8");
        editor.setEditable(false);
        editor.setWordWrap(zArr[0]);
        editor.m10868a(2);
        c1386h.m11038a(m18332i);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m427a(file.getName()).m435b(editor).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.editor_wordwrap, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC281912(this, m438b, zArr, editor, i));
        m438b.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(m438b.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        m438b.getWindow().setAttributes(layoutParams);
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$12 */
    class DialogInterfaceOnShowListenerC281912 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final TranslateActivity f14518a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f14519b;

        /* renamed from: c */
        private final boolean[] f14520c;

        /* renamed from: d */
        private final Editor f14521d;

        /* renamed from: e */
        private final int f14522e;

        DialogInterfaceOnShowListenerC281912(TranslateActivity translateActivity, DialogInterfaceC0070b dialogInterfaceC0070b, boolean[] zArr, Editor editor, int i) {
            this.f14518a = translateActivity;
            this.f14519b = dialogInterfaceC0070b;
            this.f14520c = zArr;
            this.f14521d = editor;
            this.f14522e = i;
        }

        /* renamed from: a */
        static TranslateActivity m16853a(DialogInterfaceOnShowListenerC281912 dialogInterfaceOnShowListenerC281912) {
            return dialogInterfaceOnShowListenerC281912.f14518a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f14519b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f14520c, this.f14521d) { // from class: ru.maximoff.apktool.TranslateActivity.12.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC281912 f14523a;

                /* renamed from: b */
                private final boolean[] f14524b;

                /* renamed from: c */
                private final Editor f14525c;

                {
                    this.f14523a = this;
                    this.f14524b = r2;
                    this.f14525c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14524b[0] = !this.f14524b[0];
                    C3102bd.m18938b(DialogInterfaceOnShowListenerC281912.m16853a(this.f14523a), "preview_word_wrap", this.f14524b[0]);
                    int caretPosition = this.f14525c.getCaretPosition();
                    this.f14525c.setWordWrap(this.f14524b[0]);
                    this.f14525c.m10883c();
                    this.f14525c.m10860G();
                    this.f14525c.m10897g();
                    this.f14525c.requestFocus();
                    this.f14525c.postDelayed(new Runnable(this, this.f14525c, caretPosition) { // from class: ru.maximoff.apktool.TranslateActivity.12.1.1

                        /* renamed from: a */
                        private final AnonymousClass1 f14526a;

                        /* renamed from: b */
                        private final Editor f14527b;

                        /* renamed from: c */
                        private final int f14528c;

                        {
                            this.f14526a = this;
                            this.f14527b = r2;
                            this.f14528c = caretPosition;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14527b.m10874a(true);
                            this.f14527b.m10901h(this.f14528c);
                        }
                    }, 100L);
                }
            });
            this.f14521d.m10883c();
            this.f14521d.m10860G();
            this.f14521d.m10897g();
            this.f14521d.m19757k(this.f14522e);
            this.f14521d.requestFocus();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z = false;
        getMenuInflater().inflate(R.menu.translate, menu);
        boolean equals = this.f14508t.equals("strings");
        menu.findItem(R.id.line_num).setChecked(this.f14510v);
        menu.findItem(R.id.sorting).setChecked(this.f14511w);
        menu.findItem(R.id.sorting).setVisible(equals);
        menu.findItem(R.id.first_notrans).setChecked(this.f14512x);
        menu.findItem(R.id.first_notrans).setEnabled(this.f14511w);
        menu.findItem(R.id.first_notrans).setVisible(equals);
        menu.findItem(R.id.add).setVisible((this.f14514z || this.f14480A) ? false : true);
        menu.findItem(R.id.delete).setVisible((this.f14514z || this.f14480A) ? false : true);
        menu.findItem(R.id.hide_trans).setChecked(this.f14483D);
        menu.findItem(R.id.delete_array).setVisible((equals || this.f14514z || this.f14480A) ? false : true);
        menu.findItem(R.id.old_layout).setChecked(this.f14513y);
        menu.findItem(R.id.save).setEnabled(!(this.f14514z || this.f14480A) || this.f14498i);
        menu.findItem(R.id.save_to_dict).setEnabled(this.f14498i);
        MenuItem findItem = menu.findItem(R.id.create_dict);
        if (this.f14505q.length > 1 && equals) {
            z = true;
        }
        findItem.setVisible(z);
        menu.findItem(R.id.reset).setVisible(this.f14498i);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.reset).setVisible(this.f14498i);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.add /* 2131689548 */:
                m16837y();
                break;
            case R.id.save /* 2131690189 */:
                m16806e(false);
                break;
            case R.id.reset /* 2131690190 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.search_reset).m433b(R.string.mtr_sure).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.17

                    /* renamed from: a */
                    private final TranslateActivity f14534a;

                    {
                        this.f14534a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        if (this.f14534a.f14514z || this.f14534a.f14480A) {
                            this.f14534a.f14493N = new ArrayList();
                            try {
                                if (this.f14534a.f14514z) {
                                    new AsyncTaskC3235o(this.f14534a, this.f14534a.f14504p, this.f14534a.f14496Q).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) null);
                                } else {
                                    new AsyncTaskC3240t(this.f14534a, this.f14534a.f14504p).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String) null);
                                }
                                this.f14534a.f14498i = false;
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f14534a.f14499k, R.string.error_try_again);
                            }
                        } else {
                            this.f14534a.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14534a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14534a.f14507s).toString()).append("/").toString()).append(this.f14534a.f14508t).toString()).append(".xml").toString());
                            this.f14534a.m16842a(this.f14534a.f14488I, false);
                        }
                        this.f14534a.invalidateOptionsMenu();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.search /* 2131690191 */:
                if (this.f14484E.getVisibility() == 8) {
                    this.f14484E.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.TranslateActivity.16

                        /* renamed from: a */
                        private final TranslateActivity f14533a;

                        {
                            this.f14533a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14533a.f14485F.requestFocus();
                            ((InputMethodManager) this.f14533a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f14533a.f14485F, 1);
                            this.f14533a.f14485F.selectAll();
                        }
                    }, 100L);
                    break;
                } else {
                    this.f14484E.setVisibility(8);
                    m16798d("");
                    break;
                }
            case R.id.replace /* 2131690192 */:
                m16826s();
                break;
            case R.id.line_num /* 2131690193 */:
                this.f14510v = !menuItem.isChecked();
                C3102bd.m18938b(this, "mtr_line_num", this.f14510v);
                invalidateOptionsMenu();
                this.f14503o.notifyDataSetChanged();
                break;
            case R.id.prop /* 2131690195 */:
                m16850q();
                break;
            case R.id.exit /* 2131690197 */:
                m16847b(true);
                break;
            case R.id.delete /* 2131690255 */:
                m16834w();
                break;
            case R.id.delete_array /* 2131690310 */:
                m16835x();
                break;
            case R.id.save_to_dict /* 2131690311 */:
                m16844a(false, this.f14488I);
                break;
            case R.id.create_dict /* 2131690312 */:
                if (this.f14498i) {
                    new DialogInterfaceC0070b.a(this).m433b(R.string.save_file_msg).m420a(R.string.yes, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.13

                        /* renamed from: a */
                        private final TranslateActivity f14529a;

                        {
                            this.f14529a = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.f14529a.m16806e(false);
                        }
                    }).m434b(R.string.f21469no, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.14

                        /* renamed from: a */
                        private final TranslateActivity f14530a;

                        {
                            this.f14530a = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.f14530a.m16828t();
                        }
                    }).m440c(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                    break;
                } else {
                    m16828t();
                    break;
                }
            case R.id.auto_trans /* 2131690313 */:
                m16830u();
                break;
            case R.id.hide_trans /* 2131690314 */:
                this.f14483D = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "mtr_hide_trans", this.f14483D);
                invalidateOptionsMenu();
                this.f14503o.notifyDataSetChanged();
                break;
            case R.id.sorting /* 2131690315 */:
                this.f14511w = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "mtr_sort_strings", this.f14511w);
                m16801d(this.f14511w);
                break;
            case R.id.first_notrans /* 2131690316 */:
                this.f14512x = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "mtr_first_notrans", this.f14512x);
                m16801d(this.f14511w);
                break;
            case R.id.old_layout /* 2131690317 */:
                if (this.f14498i) {
                    new DialogInterfaceC0070b.a(this).m433b(R.string.mtr_sure_continue).m420a(R.string.yes, new DialogInterface.OnClickListener(this, menuItem) { // from class: ru.maximoff.apktool.TranslateActivity.15

                        /* renamed from: a */
                        private final TranslateActivity f14531a;

                        /* renamed from: b */
                        private final MenuItem f14532b;

                        {
                            this.f14531a = this;
                            this.f14532b = menuItem;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            C3102bd.m18938b(this.f14531a, "mtr_old_layout", !this.f14532b.isChecked());
                            this.f14531a.recreate();
                        }
                    }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
                    break;
                } else {
                    C3102bd.m18938b(this, "mtr_old_layout", menuItem.isChecked() ? false : true);
                    recreate();
                    break;
                }
            case R.id.trlangs_settings /* 2131690318 */:
                C3239s.m19428b(this);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, android.app.Activity
    public void recreate() {
        finish();
        startActivity(getIntent());
    }

    /* renamed from: q */
    public void m16850q() {
        String string;
        Iterator<C3236p> it = this.f14488I.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().m19390k()) {
                i++;
            }
        }
        if (this.f14514z) {
            StringBuilder sb = new StringBuilder();
            sb.append("smali");
            if (this.f14496Q != null) {
                sb.append(" (");
                for (int i2 = 0; i2 < this.f14496Q.length; i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    if (this.f14496Q[i2].equals("smali")) {
                        sb.append("classes.dex");
                    } else {
                        sb.append(new StringBuffer().append(this.f14496Q[i2].substring(6)).append(".dex").toString());
                    }
                }
                sb.append(")");
            }
            string = getString(R.string.mtr_properties, this.f14504p.getAbsolutePath(), "-", sb.toString(), "-", String.valueOf(this.f14488I.size()), String.valueOf(i));
        } else if (this.f14480A) {
            string = getString(R.string.mtr_properties, this.f14504p.getAbsolutePath(), "-", XMLConstants.XML_NS_PREFIX, "-", String.valueOf(this.f14488I.size()), String.valueOf(i));
        } else {
            File file = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14507s).toString()).append("/").toString()).append(this.f14508t).toString()).append(".xml").toString());
            if (!file.exists()) {
                C3112bn.m19023b(this, getString(R.string.error));
                return;
            }
            string = getString(R.string.mtr_properties, this.f14504p.getAbsolutePath(), String.valueOf(this.f14505q.length), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14507s).append(" (").toString()).append(this.f14508t).toString()).append(".xml)").toString(), C3106bh.m18975a(file.length(), C3102bd.f18305am), String.valueOf(this.f14488I.size()), String.valueOf(i));
        }
        new DialogInterfaceC0070b.a(this.f14499k).m436b(string).m429a(true).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: a */
    private int m16775a(String[] strArr, String str) {
        if (str == null || str == "") {
            return 0;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].startsWith(new StringBuffer().append("values-").append(str).toString())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: s */
    private void m16826s() {
        List<C3236p> m16881i = this.f14503o.m16881i();
        this.f14503o.m16879g();
        if (m16881i.isEmpty()) {
            C3112bn.m18999a(this.f14499k, R.string.not_found);
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
        checkBox.setChecked(C3102bd.m18925a((Context) this, "trans_repl_regex", false));
        checkBox2.setChecked(C3102bd.m18925a((Context) this, "trans_repl_sens", false));
        C3212b c3212b = new C3212b(this, "translate");
        if (c3212b.m19205b().isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView, editText) { // from class: ru.maximoff.apktool.TranslateActivity.18

            /* renamed from: a */
            private final TranslateActivity f14535a;

            /* renamed from: b */
            private final C3212b f14536b;

            /* renamed from: c */
            private final ImageView f14537c;

            /* renamed from: d */
            private final EditText f14538d;

            {
                this.f14535a = this;
                this.f14536b = c3212b;
                this.f14537c = imageView;
                this.f14538d = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14536b.m19201a(this.f14537c, this.f14538d);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.TranslateActivity.19

            /* renamed from: a */
            private final TranslateActivity f14539a;

            /* renamed from: b */
            private final C3212b f14540b;

            /* renamed from: c */
            private final ImageView f14541c;

            {
                this.f14539a = this;
                this.f14540b = c3212b;
                this.f14541c = imageView;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f14539a.f14499k).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14540b, this.f14541c) { // from class: ru.maximoff.apktool.TranslateActivity.19.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC282619 f14542a;

                    /* renamed from: b */
                    private final C3212b f14543b;

                    /* renamed from: c */
                    private final ImageView f14544c;

                    {
                        this.f14542a = this;
                        this.f14543b = r2;
                        this.f14544c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14543b.m19208d();
                        this.f14544c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        C3212b c3212b2 = new C3212b(this, "translate_repl");
        if (c3212b2.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.TranslateActivity.20

            /* renamed from: a */
            private final TranslateActivity f14546a;

            /* renamed from: b */
            private final C3212b f14547b;

            /* renamed from: c */
            private final ImageView f14548c;

            /* renamed from: d */
            private final EditText f14549d;

            {
                this.f14546a = this;
                this.f14547b = c3212b2;
                this.f14548c = imageView2;
                this.f14549d = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14547b.m19201a(this.f14548c, this.f14549d);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b2, imageView2) { // from class: ru.maximoff.apktool.TranslateActivity.21

            /* renamed from: a */
            private final TranslateActivity f14550a;

            /* renamed from: b */
            private final C3212b f14551b;

            /* renamed from: c */
            private final ImageView f14552c;

            {
                this.f14550a = this;
                this.f14551b = c3212b2;
                this.f14552c = imageView2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f14550a.f14499k).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14551b, this.f14552c) { // from class: ru.maximoff.apktool.TranslateActivity.21.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC282921 f14553a;

                    /* renamed from: b */
                    private final C3212b f14554b;

                    /* renamed from: c */
                    private final ImageView f14555c;

                    {
                        this.f14553a = this;
                        this.f14554b = r2;
                        this.f14555c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14554b.m19208d();
                        this.f14555c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.TranslateActivity.22

            /* renamed from: a */
            private final TranslateActivity f14556a;

            /* renamed from: b */
            private final EditText f14557b;

            {
                this.f14556a = this;
                this.f14557b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14557b.requestFocus();
                this.f14557b.setText("");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.TranslateActivity.23

            /* renamed from: a */
            private final TranslateActivity f14558a;

            /* renamed from: b */
            private final EditText f14559b;

            {
                this.f14558a = this;
                this.f14559b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14559b.requestFocus();
                this.f14559b.setText("");
            }
        });
        imageView3.setVisibility(8);
        imageView4.setVisibility(8);
        editText.addTextChangedListener(new TextWatcher(this, buttonArr, imageView3) { // from class: ru.maximoff.apktool.TranslateActivity.24

            /* renamed from: a */
            private final TranslateActivity f14560a;

            /* renamed from: b */
            private final Button[] f14561b;

            /* renamed from: c */
            private final ImageView f14562c;

            {
                this.f14560a = this;
                this.f14561b = buttonArr;
                this.f14562c = imageView3;
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
                    if (this.f14561b[0] != null) {
                        this.f14561b[0].setEnabled(false);
                    }
                    this.f14562c.setVisibility(8);
                } else {
                    if (this.f14561b[0] != null) {
                        this.f14561b[0].setEnabled(true);
                    }
                    this.f14562c.setVisibility(0);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this, imageView4) { // from class: ru.maximoff.apktool.TranslateActivity.25

            /* renamed from: a */
            private final TranslateActivity f14563a;

            /* renamed from: b */
            private final ImageView f14564b;

            {
                this.f14563a = this;
                this.f14564b = imageView4;
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
                    this.f14564b.setVisibility(8);
                } else {
                    this.f14564b.setVisibility(0);
                }
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.replace).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, editText2, checkBox, checkBox2, c3212b, c3212b2, m16881i) { // from class: ru.maximoff.apktool.TranslateActivity.26

            /* renamed from: a */
            private final TranslateActivity f14565a;

            /* renamed from: b */
            private final EditText f14566b;

            /* renamed from: c */
            private final EditText f14567c;

            /* renamed from: d */
            private final CheckBox f14568d;

            /* renamed from: e */
            private final CheckBox f14569e;

            /* renamed from: f */
            private final C3212b f14570f;

            /* renamed from: g */
            private final C3212b f14571g;

            /* renamed from: h */
            private final List f14572h;

            {
                this.f14565a = this;
                this.f14566b = editText;
                this.f14567c = editText2;
                this.f14568d = checkBox;
                this.f14569e = checkBox2;
                this.f14570f = c3212b;
                this.f14571g = c3212b2;
                this.f14572h = m16881i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                String editable = this.f14566b.getText().toString();
                String editable2 = this.f14567c.getText().toString();
                boolean isChecked = this.f14568d.isChecked();
                boolean isChecked2 = this.f14569e.isChecked();
                this.f14570f.m19204a(editable);
                this.f14571g.m19204a(editable2);
                C3102bd.m18938b(this.f14565a.f14499k, "trans_repl_regex", isChecked);
                C3102bd.m18938b(this.f14565a.f14499k, "trans_repl_sens", isChecked2);
                new AsyncTaskC3231k(this.f14565a, this.f14572h, editable, editable2, isChecked, isChecked2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.TranslateActivity.27

            /* renamed from: a */
            private final TranslateActivity f14573a;

            /* renamed from: b */
            private final Button[] f14574b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f14575c;

            /* renamed from: d */
            private final EditText f14576d;

            {
                this.f14573a = this;
                this.f14574b = buttonArr;
                this.f14575c = m438b;
                this.f14576d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14574b[0] = this.f14575c.m414a(-1);
                this.f14574b[0].setEnabled(false);
                this.f14576d.requestFocus();
                this.f14576d.selectAll();
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m16828t() {
        String m18910a = C3102bd.m18910a(this.f14499k, "dict_language_src", (String) null);
        String m18910a2 = C3102bd.m18910a(this.f14499k, "dict_language_target", this.f14490K);
        int max = Math.max(0, m16775a(this.f14505q, m18910a));
        int max2 = Math.max(1, m16775a(this.f14505q, m18910a2));
        View inflate = getLayoutInflater().inflate(R.layout.create_dict, (ViewGroup) null);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14505q);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.createdictSpinner1);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.createdictSpinner2);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(max);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(max2);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.28

            /* renamed from: a */
            private final TranslateActivity f14577a;

            {
                this.f14577a = this;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String str;
                String[] split = this.f14577a.f14505q[i].split("-");
                if (split.length > 1) {
                    str = split[1];
                } else {
                    str = "";
                }
                switch (adapterView.getId()) {
                    case R.id.createdictSpinner1 /* 2131689699 */:
                        C3102bd.m18937b(this.f14577a.f14499k, "dict_language_src", str);
                        break;
                    case R.id.createdictSpinner2 /* 2131689700 */:
                        C3102bd.m18937b(this.f14577a.f14499k, "dict_language_target", str);
                        break;
                }
            }
        };
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        spinner2.setOnItemSelectedListener(onItemSelectedListener);
        new DialogInterfaceC0070b.a(this.f14499k).m429a(true).m435b(inflate).m418a(R.string.mtr_create_dict).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.mtr_create, new DialogInterface.OnClickListener(this, spinner, spinner2) { // from class: ru.maximoff.apktool.TranslateActivity.29

            /* renamed from: a */
            private final TranslateActivity f14578a;

            /* renamed from: b */
            private final Spinner f14579b;

            /* renamed from: c */
            private final Spinner f14580c;

            {
                this.f14578a = this;
                this.f14579b = spinner;
                this.f14580c = spinner2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    new AsyncTaskC3230j(this.f14578a, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14578a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14578a.f14505q[this.f14579b.getSelectedItemPosition()]).toString()).append("/strings.xml").toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14578a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14578a.f14505q[this.f14580c.getSelectedItemPosition()]).toString()).append("/strings.xml").toString()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f14578a.f14499k, R.string.error_try_again);
                }
                dialogInterface.dismiss();
            }
        }).m438b().show();
    }

    /* renamed from: a */
    public void m16844a(boolean z, List<C3236p> list) {
        String[] m19330b = C3225e.m19330b();
        if (!z && m19330b != null) {
            String[] strArr = {m19330b[0]};
            new DialogInterfaceC0070b.a(this.f14499k).m430a(m19330b, 0, new DialogInterface.OnClickListener(this, strArr, m19330b) { // from class: ru.maximoff.apktool.TranslateActivity.30

                /* renamed from: a */
                private final TranslateActivity f14582a;

                /* renamed from: b */
                private final String[] f14583b;

                /* renamed from: c */
                private final String[] f14584c;

                {
                    this.f14582a = this;
                    this.f14583b = strArr;
                    this.f14584c = m19330b;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14583b[0] = this.f14584c[i];
                }
            }).m429a(true).m418a(R.string.mtr_save_to_dict).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.mtr_create, new DialogInterface.OnClickListener(this, list) { // from class: ru.maximoff.apktool.TranslateActivity.31

                /* renamed from: a */
                private final TranslateActivity f14585a;

                /* renamed from: b */
                private final List f14586b;

                {
                    this.f14585a = this;
                    this.f14586b = list;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14585a.m16844a(true, this.f14586b);
                    dialogInterface.dismiss();
                }
            }).m420a(R.string.save, new DialogInterface.OnClickListener(this, list, strArr) { // from class: ru.maximoff.apktool.TranslateActivity.32

                /* renamed from: a */
                private final TranslateActivity f14587a;

                /* renamed from: b */
                private final List f14588b;

                /* renamed from: c */
                private final String[] f14589c;

                {
                    this.f14587a = this;
                    this.f14588b = list;
                    this.f14589c = strArr;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        new AsyncTaskC3233m(this.f14587a.f14499k, this.f14588b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14589c);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f14587a.f14499k, R.string.error_try_again);
                    }
                    dialogInterface.dismiss();
                }
            }).m438b().show();
            return;
        }
        String string = getString(R.string.new_dict);
        String[] strArr2 = {".amd", ".mtd"};
        View inflate = getLayoutInflater().inflate(R.layout.dictionary, (ViewGroup) null);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, strArr2);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.dictionarySpinner1);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(0);
        EditText editText = (EditText) inflate.findViewById(R.id.dictionaryEditText1);
        editText.setHint(string);
        editText.setText(string);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.mtr_create_dict).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, list, editText, strArr2, spinner) { // from class: ru.maximoff.apktool.TranslateActivity.33

            /* renamed from: a */
            private final TranslateActivity f14590a;

            /* renamed from: b */
            private final List f14591b;

            /* renamed from: c */
            private final EditText f14592c;

            /* renamed from: d */
            private final String[] f14593d;

            /* renamed from: e */
            private final Spinner f14594e;

            {
                this.f14590a = this;
                this.f14591b = list;
                this.f14592c = editText;
                this.f14593d = strArr2;
                this.f14594e = spinner;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    new AsyncTaskC3233m(this.f14590a.f14499k, this.f14591b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new StringBuffer().append(this.f14592c.getText().toString()).append(this.f14593d[this.f14594e.getSelectedItemPosition()]).toString());
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f14590a.f14499k, R.string.error_try_again);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.TranslateActivity.34

            /* renamed from: a */
            private final TranslateActivity f14595a;

            /* renamed from: b */
            private final EditText f14596b;

            {
                this.f14595a = this;
                this.f14596b = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14596b.requestFocus();
                this.f14596b.selectAll();
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m16830u() {
        int i;
        String[] m19330b = C3225e.m19330b();
        int i2 = 5;
        if (m19330b == null) {
            i = 0;
        } else {
            i = m19330b.length;
        }
        String[] m19423a = C3239s.m19423a(this.f14499k, 0, false);
        String[] m19423a2 = C3239s.m19423a(this.f14499k, 0, true);
        String[] m19423a3 = C3239s.m19423a(this.f14499k, 1, false);
        String[] m19423a4 = C3239s.m19423a(this.f14499k, 1, true);
        String[] m19423a5 = C3239s.m19423a(this.f14499k, 2, false);
        String[] m19423a6 = C3239s.m19423a(this.f14499k, 2, true);
        String[] m19423a7 = C3239s.m19423a(this.f14499k, 3, false);
        String[] m19423a8 = C3239s.m19423a(this.f14499k, 3, true);
        String[] m19423a9 = C3239s.m19423a(this.f14499k, 4, false);
        String[] m19423a10 = C3239s.m19423a(this.f14499k, 4, true);
        if (m19423a.length != m19423a2.length || m19423a3.length != m19423a4.length || m19423a5.length != m19423a6.length) {
            C3112bn.m19023b(this.f14499k, getString(R.string.error));
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.translate_auto, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.translateautoLinearLayout1);
        int m18905a = C3102bd.m18905a(this.f14499k, "auto_translate_service", 0);
        if (m18905a < 0 || m18905a > i + 4) {
            m18905a = 0;
        }
        int i3 = m18905a > 4 ? 0 : m18905a;
        boolean[] zArr = new boolean[1];
        zArr[0] = m18905a > 4;
        if (zArr[0]) {
            linearLayout.setVisibility(8);
        }
        String[] strArr = new String[i + 5];
        strArr[0] = this.f14499k.getString(R.string.mtr_yandex);
        strArr[1] = this.f14499k.getString(R.string.mtr_bing);
        strArr[2] = this.f14499k.getString(R.string.mtr_google);
        strArr[3] = this.f14499k.getString(R.string.mtr_google_web);
        strArr[4] = this.f14499k.getString(R.string.mtr_deepl);
        for (int i4 = 5; i4 < i + 5; i4++) {
            strArr[i4] = new StringBuffer().append("#").append(m19330b[i4 - 5]).toString();
        }
        Spinner spinner = (Spinner) inflate.findViewById(R.id.translateautoSpinner0);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, strArr));
        spinner.setSelection(m18905a);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.translateautoSpinner1);
        Spinner spinner3 = (Spinner) inflate.findViewById(R.id.translateautoSpinner2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.translateautoCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.translateautoCheckBox2);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.translateautoCheckBox3);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.translateautoCheckBox4);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.translateautoImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_help_light);
        } else {
            imageView.setImageResource(R.drawable.ic_help_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.35

            /* renamed from: a */
            private final TranslateActivity f14597a;

            {
                this.f14597a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new DialogInterfaceC0070b.a(this.f14597a.f14499k).m418a(R.string.minfo).m433b(R.string.mtr_check_source_info).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m438b().show();
            }
        });
        checkBox.setChecked(C3102bd.m18925a(this.f14499k, "auto_translate_skip_transl", true));
        checkBox2.setChecked(C3102bd.m18925a(this.f14499k, "auto_translate_fix_transl", true));
        checkBox3.setChecked(C3102bd.m18925a(this.f14499k, "auto_translate_check_source", false));
        checkBox4.setChecked(C3102bd.m18925a(this.f14499k, "auto_translate_mark_all", true));
        checkBox4.setEnabled(checkBox3.isChecked());
        checkBox3.setOnClickListener(new View.OnClickListener(this, checkBox4, checkBox3) { // from class: ru.maximoff.apktool.TranslateActivity.36

            /* renamed from: a */
            private final TranslateActivity f14598a;

            /* renamed from: b */
            private final CheckBox f14599b;

            /* renamed from: c */
            private final CheckBox f14600c;

            {
                this.f14598a = this;
                this.f14599b = checkBox4;
                this.f14600c = checkBox3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14599b.setEnabled(this.f14600c.isEnabled() && this.f14600c.isChecked());
            }
        });
        String m18910a = C3102bd.m18910a(this.f14499k, "auto_translate_ysource_code", "auto");
        String m18910a2 = C3102bd.m18910a(this.f14499k, "auto_translate_ytarget_code", this.f14490K);
        String m18910a3 = C3102bd.m18910a(this.f14499k, "auto_translate_bsource_code", "auto");
        String m18910a4 = C3102bd.m18910a(this.f14499k, "auto_translate_btarget_code", this.f14490K);
        String m18910a5 = C3102bd.m18910a(this.f14499k, "auto_translate_gsource_code", "auto");
        String m18910a6 = C3102bd.m18910a(this.f14499k, "auto_translate_gtarget_code", this.f14490K);
        String m18910a7 = C3102bd.m18910a(this.f14499k, "auto_translate_gwsource_code", "auto");
        String m18910a8 = C3102bd.m18910a(this.f14499k, "auto_translate_gwtarget_code", this.f14490K);
        String m18910a9 = C3102bd.m18910a(this.f14499k, "auto_translate_dsource_code", "auto");
        String m18910a10 = C3102bd.m18910a(this.f14499k, "auto_translate_dtarget_code", this.f14490K);
        int[] iArr = {0, 0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0, 0};
        for (int i5 = 1; i5 < m19423a.length; i5++) {
            if (m19423a[i5].equals(m18910a2)) {
                iArr2[0] = i5 - 1;
            } else if (m19423a[i5].equals(m18910a)) {
                iArr[0] = i5;
            }
        }
        for (int i6 = 1; i6 < m19423a3.length; i6++) {
            if (m19423a3[i6].equals(m18910a4)) {
                iArr2[1] = i6 - 1;
            } else if (m19423a3[i6].equals(m18910a3)) {
                iArr[1] = i6;
            }
        }
        for (int i7 = 1; i7 < m19423a5.length; i7++) {
            if (m19423a5[i7].equals(m18910a6)) {
                iArr2[2] = i7 - 1;
            } else if (m19423a5[i7].equals(m18910a5)) {
                iArr[2] = i7;
            }
        }
        for (int i8 = 1; i8 < m19423a7.length; i8++) {
            if (m19423a7[i8].equals(m18910a8)) {
                iArr2[3] = i8 - 1;
            } else if (m19423a7[i8].equals(m18910a7)) {
                iArr[3] = i8;
            }
        }
        for (int i9 = 1; i9 < m19423a9.length; i9++) {
            if (m19423a9[i9].equals(m18910a10)) {
                iArr2[4] = i9 - 1;
            } else if (m19423a9[i9].equals(m18910a9)) {
                iArr[4] = i9;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, m19423a2);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a2, 1, m19423a2.length));
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, m19423a4);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a4, 1, m19423a4.length));
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, m19423a6);
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a6, 1, m19423a6.length));
        ArrayAdapter arrayAdapter7 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, m19423a8);
        ArrayAdapter arrayAdapter8 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a8, 1, m19423a8.length));
        ArrayAdapter arrayAdapter9 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, m19423a10);
        ArrayAdapter arrayAdapter10 = new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a10, 1, m19423a10.length));
        switch (i3) {
            case 0:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter2);
                break;
            case 1:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter3);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter4);
                break;
            case 2:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter5);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter6);
                break;
            case 3:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter7);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter8);
                break;
            case 4:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter9);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter10);
                break;
        }
        spinner2.setSelection(iArr[i3]);
        spinner3.setSelection(iArr2[i3]);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, checkBox3, i2, checkBox4, linearLayout, zArr, spinner2, arrayAdapter, spinner3, arrayAdapter2, arrayAdapter3, arrayAdapter4, arrayAdapter5, arrayAdapter6, arrayAdapter7, arrayAdapter8, arrayAdapter9, arrayAdapter10, iArr, iArr2) { // from class: ru.maximoff.apktool.TranslateActivity.37

            /* renamed from: a */
            private final TranslateActivity f14601a;

            /* renamed from: b */
            private final CheckBox f14602b;

            /* renamed from: c */
            private final int f14603c;

            /* renamed from: d */
            private final CheckBox f14604d;

            /* renamed from: e */
            private final LinearLayout f14605e;

            /* renamed from: f */
            private final boolean[] f14606f;

            /* renamed from: g */
            private final Spinner f14607g;

            /* renamed from: h */
            private final ArrayAdapter f14608h;

            /* renamed from: i */
            private final Spinner f14609i;

            /* renamed from: j */
            private final ArrayAdapter f14610j;

            /* renamed from: k */
            private final ArrayAdapter f14611k;

            /* renamed from: l */
            private final ArrayAdapter f14612l;

            /* renamed from: m */
            private final ArrayAdapter f14613m;

            /* renamed from: n */
            private final ArrayAdapter f14614n;

            /* renamed from: o */
            private final ArrayAdapter f14615o;

            /* renamed from: p */
            private final ArrayAdapter f14616p;

            /* renamed from: q */
            private final ArrayAdapter f14617q;

            /* renamed from: r */
            private final ArrayAdapter f14618r;

            /* renamed from: s */
            private final int[] f14619s;

            /* renamed from: t */
            private final int[] f14620t;

            {
                this.f14601a = this;
                this.f14602b = checkBox3;
                this.f14603c = i2;
                this.f14604d = checkBox4;
                this.f14605e = linearLayout;
                this.f14606f = zArr;
                this.f14607g = spinner2;
                this.f14608h = arrayAdapter;
                this.f14609i = spinner3;
                this.f14610j = arrayAdapter2;
                this.f14611k = arrayAdapter3;
                this.f14612l = arrayAdapter4;
                this.f14613m = arrayAdapter5;
                this.f14614n = arrayAdapter6;
                this.f14615o = arrayAdapter7;
                this.f14616p = arrayAdapter8;
                this.f14617q = arrayAdapter9;
                this.f14618r = arrayAdapter10;
                this.f14619s = iArr;
                this.f14620t = iArr2;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j) {
                C3102bd.m18935b(this.f14601a.f14499k, "auto_translate_service", i10);
                this.f14602b.setEnabled(i10 < 5);
                this.f14604d.setEnabled(this.f14602b.isEnabled() && this.f14602b.isChecked());
                if (i10 >= 5) {
                    this.f14605e.setVisibility(8);
                    this.f14606f[0] = true;
                    return;
                }
                this.f14605e.setVisibility(0);
                this.f14606f[0] = false;
                switch (i10) {
                    case 0:
                        this.f14607g.setAdapter((SpinnerAdapter) this.f14608h);
                        this.f14609i.setAdapter((SpinnerAdapter) this.f14610j);
                        break;
                    case 1:
                        this.f14607g.setAdapter((SpinnerAdapter) this.f14611k);
                        this.f14609i.setAdapter((SpinnerAdapter) this.f14612l);
                        break;
                    case 2:
                        this.f14607g.setAdapter((SpinnerAdapter) this.f14613m);
                        this.f14609i.setAdapter((SpinnerAdapter) this.f14614n);
                        break;
                    case 3:
                        this.f14607g.setAdapter((SpinnerAdapter) this.f14615o);
                        this.f14609i.setAdapter((SpinnerAdapter) this.f14616p);
                        break;
                    case 4:
                        this.f14607g.setAdapter((SpinnerAdapter) this.f14617q);
                        this.f14609i.setAdapter((SpinnerAdapter) this.f14618r);
                        break;
                }
                this.f14607g.setSelection(this.f14619s[i10]);
                this.f14609i.setSelection(this.f14620t[i10]);
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, checkBox3, checkBox4) { // from class: ru.maximoff.apktool.TranslateActivity.38

            /* renamed from: a */
            private final TranslateActivity f14621a;

            /* renamed from: b */
            private final CheckBox f14622b;

            /* renamed from: c */
            private final CheckBox f14623c;

            {
                this.f14621a = this;
                this.f14622b = checkBox3;
                this.f14623c = checkBox4;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j) {
                this.f14622b.setEnabled(i10 > 0);
                this.f14623c.setEnabled(this.f14622b.isEnabled() && this.f14622b.isChecked());
            }
        });
        new DialogInterfaceC0070b.a(this.f14499k).m435b(inflate).m429a(true).m418a(R.string.mtr_auto).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.translate, new DialogInterface.OnClickListener(this, checkBox, checkBox2, checkBox3, checkBox4, zArr, strArr, spinner, m19423a, spinner2, spinner3, m19423a3, m19423a5, m19423a7, m19423a9) { // from class: ru.maximoff.apktool.TranslateActivity.39

            /* renamed from: a */
            private final TranslateActivity f14624a;

            /* renamed from: b */
            private final CheckBox f14625b;

            /* renamed from: c */
            private final CheckBox f14626c;

            /* renamed from: d */
            private final CheckBox f14627d;

            /* renamed from: e */
            private final CheckBox f14628e;

            /* renamed from: f */
            private final boolean[] f14629f;

            /* renamed from: g */
            private final String[] f14630g;

            /* renamed from: h */
            private final Spinner f14631h;

            /* renamed from: i */
            private final String[] f14632i;

            /* renamed from: j */
            private final Spinner f14633j;

            /* renamed from: k */
            private final Spinner f14634k;

            /* renamed from: l */
            private final String[] f14635l;

            /* renamed from: m */
            private final String[] f14636m;

            /* renamed from: n */
            private final String[] f14637n;

            /* renamed from: o */
            private final String[] f14638o;

            {
                this.f14624a = this;
                this.f14625b = checkBox;
                this.f14626c = checkBox2;
                this.f14627d = checkBox3;
                this.f14628e = checkBox4;
                this.f14629f = zArr;
                this.f14630g = strArr;
                this.f14631h = spinner;
                this.f14632i = m19423a;
                this.f14633j = spinner2;
                this.f14634k = spinner3;
                this.f14635l = m19423a3;
                this.f14636m = m19423a5;
                this.f14637n = m19423a7;
                this.f14638o = m19423a9;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                boolean z;
                boolean z2;
                String str;
                String str2;
                C3102bd.m18938b(this.f14624a.f14499k, "auto_translate_skip_transl", this.f14625b.isChecked());
                C3102bd.m18938b(this.f14624a.f14499k, "auto_translate_fix_transl", this.f14626c.isChecked());
                if (this.f14627d.isEnabled()) {
                    z2 = this.f14627d.isChecked();
                    C3102bd.m18938b(this.f14624a.f14499k, "auto_translate_check_source", z2);
                    if (z2) {
                        z = this.f14628e.isChecked();
                        C3102bd.m18938b(this.f14624a.f14499k, "auto_translate_mark_all", z);
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (this.f14629f[0]) {
                    try {
                        new AsyncTaskC3224d(this.f14624a, this.f14624a.f14503o.m16881i(), this.f14625b.isChecked(), this.f14626c.isChecked()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14630g[this.f14631h.getSelectedItemPosition()].substring(1));
                        this.f14624a.f14503o.m16879g();
                        return;
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f14624a.f14499k, R.string.error_try_again);
                        return;
                    }
                }
                switch (this.f14631h.getSelectedItemPosition()) {
                    case 1:
                        str = this.f14635l[this.f14633j.getSelectedItemPosition()];
                        str2 = this.f14635l[this.f14634k.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_bsource_code", str);
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_btarget_code", str2);
                        break;
                    case 2:
                        str = this.f14636m[this.f14633j.getSelectedItemPosition()];
                        str2 = this.f14636m[this.f14634k.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_gsource_code", str);
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_gtarget_code", str2);
                        break;
                    case 3:
                        str = this.f14637n[this.f14633j.getSelectedItemPosition()];
                        str2 = this.f14637n[this.f14634k.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_gwsource_code", str);
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_gwtarget_code", str2);
                        break;
                    case 4:
                        str = this.f14638o[this.f14633j.getSelectedItemPosition()];
                        str2 = this.f14638o[this.f14634k.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_dsource_code", str);
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_dtarget_code", str2);
                        break;
                    default:
                        str = this.f14632i[this.f14633j.getSelectedItemPosition()];
                        str2 = this.f14632i[this.f14634k.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_ysource_code", str);
                        C3102bd.m18937b(this.f14624a.f14499k, "auto_translate_ytarget_code", str2);
                        break;
                }
                this.f14624a.f14489J = str2.contains("-") ? str2.split("-")[0] : str2;
                this.f14624a.m16778a(str, str2, this.f14625b.isChecked(), this.f14626c.isChecked(), z2, z, this.f14631h.getSelectedItemPosition());
            }
        }).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16778a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        if (!C3080al.m18605i(this.f14499k)) {
            C3112bn.m19023b(this.f14499k, getString(R.string.errorf, getString(R.string.mtr_net_err)));
            return;
        }
        List<C3236p> m16881i = this.f14503o.m16881i();
        this.f14503o.m16879g();
        if (m16881i.isEmpty()) {
            C3112bn.m18999a(this.f14499k, R.string.not_found);
            return;
        }
        this.f14497h = false;
        View inflate = LayoutInflater.from(this.f14499k).inflate(R.layout.search_progress, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.searchprogressTextView1);
        textView.setText(R.string.mplease_wait);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f14499k).m435b(inflate).m429a(false).m420a(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.40

            /* renamed from: a */
            private final TranslateActivity f14641a;

            {
                this.f14641a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                this.f14641a.f14497h = true;
            }
        }).m438b();
        m438b.show();
        String m18910a = C3102bd.m18910a(this.f14499k, "deepl_api_key", "");
        AsyncTaskC3238r asyncTaskC3238r = new AsyncTaskC3238r(this, C3102bd.f18289Y);
        asyncTaskC3238r.m19407a(i);
        asyncTaskC3238r.m19409a(new C285141(this, m438b, m16881i, z, z2, str, str2, z3, i, m18910a, z4, textView));
        try {
            asyncTaskC3238r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } catch (Exception e2) {
            C3112bn.m18999a(this.f14499k, R.string.error_try_again);
        }
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$41 */
    class C285141 implements AsyncTaskC3238r.a {

        /* renamed from: a */
        private final TranslateActivity f14642a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f14643b;

        /* renamed from: c */
        private final List f14644c;

        /* renamed from: d */
        private final boolean f14645d;

        /* renamed from: e */
        private final boolean f14646e;

        /* renamed from: f */
        private final String f14647f;

        /* renamed from: g */
        private final String f14648g;

        /* renamed from: h */
        private final boolean f14649h;

        /* renamed from: i */
        private final int f14650i;

        /* renamed from: j */
        private final String f14651j;

        /* renamed from: k */
        private final boolean f14652k;

        /* renamed from: l */
        private final TextView f14653l;

        C285141(TranslateActivity translateActivity, DialogInterfaceC0070b dialogInterfaceC0070b, List list, boolean z, boolean z2, String str, String str2, boolean z3, int i, String str3, boolean z4, TextView textView) {
            this.f14642a = translateActivity;
            this.f14643b = dialogInterfaceC0070b;
            this.f14644c = list;
            this.f14645d = z;
            this.f14646e = z2;
            this.f14647f = str;
            this.f14648g = str2;
            this.f14649h = z3;
            this.f14650i = i;
            this.f14651j = str3;
            this.f14652k = z4;
            this.f14653l = textView;
        }

        /* renamed from: a */
        static TranslateActivity m16854a(C285141 c285141) {
            return c285141.f14642a;
        }

        @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
        /* renamed from: a */
        public void mo16855a() {
            if (this.f14643b == null || !this.f14643b.isShowing()) {
                return;
            }
            try {
                this.f14643b.cancel();
            } catch (Exception e2) {
            }
        }

        @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
        /* renamed from: a */
        public void mo16857a(Map<String, String> map) {
            int[] iArr = {0, 0};
            for (int i = 0; i < this.f14644c.size(); i++) {
                if (this.f14642a.f14497h) {
                    if (this.f14643b == null || !this.f14643b.isShowing()) {
                        return;
                    }
                    try {
                        this.f14643b.cancel();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                C3236p c3236p = (C3236p) this.f14644c.get(i);
                if (this.f14645d && c3236p.m19387h() != null) {
                    iArr[0] = iArr[0] + 1;
                    if (iArr[0] >= this.f14644c.size()) {
                        C3112bn.m19023b(this.f14642a.f14499k, this.f14642a.getString(R.string.mtr_success_count, new Integer(iArr[1])));
                        if (this.f14643b != null && this.f14643b.isShowing()) {
                            try {
                                this.f14643b.cancel();
                            } catch (Exception e3) {
                            }
                        }
                    }
                } else if (this.f14646e && (!c3236p.m19377c() || this.f14642a.m16848c(c3236p.m19386g()))) {
                    iArr[0] = iArr[0] + 1;
                    if (iArr[0] >= this.f14644c.size()) {
                        C3112bn.m19023b(this.f14642a.f14499k, this.f14642a.getString(R.string.mtr_success_count, new Integer(iArr[1])));
                        if (this.f14643b != null && this.f14643b.isShowing()) {
                            try {
                                this.f14643b.cancel();
                            } catch (Exception e4) {
                            }
                        }
                    }
                } else {
                    C3237q c3237q = new C3237q(this.f14642a, this.f14647f, this.f14648g, c3236p.m19386g());
                    c3237q.m19398a(C3102bd.f18289Y);
                    c3237q.m19401a(this.f14649h);
                    c3237q.m19402b(iArr[1] + 1);
                    c3237q.m19399a(map);
                    c3237q.m19397a(this.f14650i);
                    c3237q.m19403b(this.f14651j);
                    c3237q.m19400a(new C3237q.a(this, this.f14643b, this.f14652k, c3236p, iArr, this.f14653l, this.f14644c, this.f14646e) { // from class: ru.maximoff.apktool.TranslateActivity.41.1

                        /* renamed from: a */
                        private final C285141 f14654a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f14655b;

                        /* renamed from: c */
                        private final boolean f14656c;

                        /* renamed from: d */
                        private final C3236p f14657d;

                        /* renamed from: e */
                        private final int[] f14658e;

                        /* renamed from: f */
                        private final TextView f14659f;

                        /* renamed from: g */
                        private final List f14660g;

                        /* renamed from: h */
                        private final boolean f14661h;

                        {
                            this.f14654a = this;
                            this.f14655b = r2;
                            this.f14656c = r3;
                            this.f14657d = c3236p;
                            this.f14658e = iArr;
                            this.f14659f = r6;
                            this.f14660g = r7;
                            this.f14661h = r8;
                        }

                        @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                        /* renamed from: a */
                        public void mo16858a() {
                            C285141.m16854a(this.f14654a).f14497h = true;
                            if (this.f14655b == null || !this.f14655b.isShowing()) {
                                return;
                            }
                            try {
                                this.f14655b.cancel();
                            } catch (Exception e5) {
                            }
                        }

                        @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                        /* renamed from: b */
                        public void mo16860b() {
                            if (this.f14656c && !this.f14657d.m19390k()) {
                                this.f14657d.m19366a();
                                C285141.m16854a(this.f14654a).f14503o.notifyDataSetChanged();
                                if (!C285141.m16854a(this.f14654a).f14498i) {
                                    C285141.m16854a(this.f14654a).f14498i = true;
                                    C285141.m16854a(this.f14654a).invalidateOptionsMenu();
                                }
                            }
                            if (C285141.m16854a(this.f14654a).f14497h) {
                                return;
                            }
                            int[] iArr2 = this.f14658e;
                            iArr2[0] = iArr2[0] + 1;
                            this.f14659f.setText(C285141.m16854a(this.f14654a).getString(R.string.mtr_translating, new Integer(this.f14658e[0]), new Integer(this.f14660g.size())));
                            if (this.f14658e[0] >= this.f14660g.size()) {
                                C3112bn.m19023b(C285141.m16854a(this.f14654a).f14499k, C285141.m16854a(this.f14654a).getString(R.string.mtr_success_count, new Integer(this.f14658e[1])));
                                if (this.f14655b == null || !this.f14655b.isShowing()) {
                                    return;
                                }
                                try {
                                    this.f14655b.cancel();
                                } catch (Exception e5) {
                                }
                            }
                        }

                        @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                        /* renamed from: a */
                        public void mo16859a(String str) {
                            if (this.f14661h) {
                                str = C285141.m16854a(this.f14654a).m16845b(str);
                            }
                            if (this.f14657d.m19391l()) {
                                this.f14657d.m19383e(C3239s.m19439k(str));
                            }
                            this.f14657d.m19375c(str);
                            C285141.m16854a(this.f14654a).f14503o.notifyDataSetChanged();
                            if (!C285141.m16854a(this.f14654a).f14498i) {
                                C285141.m16854a(this.f14654a).f14498i = true;
                                C285141.m16854a(this.f14654a).invalidateOptionsMenu();
                            }
                            if (C285141.m16854a(this.f14654a).f14497h) {
                                return;
                            }
                            int[] iArr2 = this.f14658e;
                            iArr2[0] = iArr2[0] + 1;
                            int[] iArr3 = this.f14658e;
                            iArr3[1] = iArr3[1] + 1;
                            this.f14659f.setText(C285141.m16854a(this.f14654a).getString(R.string.mtr_translating, new Integer(this.f14658e[0]), new Integer(this.f14660g.size())));
                            if (this.f14658e[0] >= this.f14660g.size()) {
                                C3112bn.m19023b(C285141.m16854a(this.f14654a).f14499k, C285141.m16854a(this.f14654a).getString(R.string.mtr_success_count, new Integer(this.f14658e[1])));
                                if (this.f14655b == null || !this.f14655b.isShowing()) {
                                    return;
                                }
                                try {
                                    this.f14655b.cancel();
                                } catch (Exception e5) {
                                }
                            }
                        }

                        @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                        /* renamed from: b */
                        public void mo16861b(String str) {
                            C3112bn.m19023b(C285141.m16854a(this.f14654a).f14499k, C285141.m16854a(this.f14654a).f14499k.getString(R.string.errorf, str));
                            if (C285141.m16854a(this.f14654a).f14497h) {
                                return;
                            }
                            int[] iArr2 = this.f14658e;
                            iArr2[0] = iArr2[0] + 1;
                            this.f14659f.setText(C285141.m16854a(this.f14654a).getString(R.string.mtr_translating, new Integer(this.f14658e[0]), new Integer(this.f14660g.size())));
                            if (this.f14658e[0] >= this.f14660g.size()) {
                                C3112bn.m19023b(C285141.m16854a(this.f14654a).f14499k, C285141.m16854a(this.f14654a).getString(R.string.mtr_success_count, new Integer(this.f14658e[1])));
                                if (this.f14655b == null || !this.f14655b.isShowing()) {
                                    return;
                                }
                                try {
                                    this.f14655b.cancel();
                                } catch (Exception e5) {
                                }
                            }
                        }
                    });
                    c3237q.m19396a();
                }
            }
        }

        @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
        /* renamed from: a */
        public void mo16856a(String str) {
            C3112bn.m19023b(this.f14642a.f14499k, this.f14642a.f14499k.getString(R.string.errorf, str));
            if (this.f14643b == null || !this.f14643b.isShowing()) {
                return;
            }
            try {
                this.f14643b.cancel();
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public void m16843a(boolean z) {
        if (!this.f14498i) {
            this.f14498i = z;
        }
        this.f14503o.notifyDataSetChanged();
        invalidateOptionsMenu();
    }

    /* renamed from: b */
    public String m16845b(String str) {
        if (str == null) {
            return (String) null;
        }
        String replaceAll = str.replaceAll("\\\\\\s{1,2}\"", "\\\\\"").replaceAll("\\\\\\s{1,2}'", "\\\\'");
        if (replaceAll.contains("%") || replaceAll.contains("$")) {
            replaceAll = replaceAll.replaceAll("%\\s{0,2}(\\d)\\s{0,2}\\$\\s{0,2}([dDsSдДсС])", "%$1\\$$2").replaceAll("%\\s{0,2}(\\d)\\s{0,2}\\$\\s{0,2}(\\d+)([dDsSдДсС])", "%$1\\$$2$3").replaceAll("%\\s{0,2}(\\d|\\w)", "%$1").replaceAll("%\\s{0,2}([dDдД])", "%d").replaceAll("%\\s{0,2}([sSсС])", "%s").replaceAll("\\$\\s{0,2}([dDдД])", "\\$d").replaceAll("\\$\\s{0,2}(\\d+)([dDдД])", "\\$$1d").replaceAll("\\$\\s{0,2}([sSсС])", "\\$s").replaceAll("%\\s{0,2}(\\d)\\$(ов|ы)", "%$1\\$s").replaceAll("%(\\d)\\$s\\sв$", "%$1\\$s").replaceAll("([a-zA-Zа-яА-Я:/.,])%(\\d|\\w)", "$1 %$2").replaceAll("%d\\s{1,2}%%", "%d%% ");
        }
        if (replaceAll.contains("...")) {
            return replaceAll.replaceAll("\\s\\.{3}$", "...");
        }
        return replaceAll;
    }

    /* renamed from: c */
    public boolean m16848c(String str) {
        if (str.trim().isEmpty() || str.matches(new StringBuffer().append(new StringBuffer().append("^").append(Patterns.WEB_URL.pattern()).toString()).append("$").toString()) || str.matches(new StringBuffer().append(new StringBuffer().append("^").append(Patterns.EMAIL_ADDRESS.pattern()).toString()).append("$").toString()) || str.matches("^\\d+\\+?$") || str.matches("^>\\d+$") || str.matches("^\\d+:\\d+$") || str.matches("^[^\\s]+_[^\\s]+$") || str.matches("^[Mm]\\s?[\\d\\.]+,[\\d\\.]+.*$") || str.matches("^(translateX|translateY|translateZ|translate|translate3d|rotateX|rotateY|rotateZ|rotate|rotate3d|scaleX|scaleY|scaleZ|scale|scale3d|skewX|skewY|skew|matrix|matrix3d|perspective|calc|min|max|clamp|round|mod|rem|sin|cos|tan|asin|acos|atan|atan2|pow|sqrt|hypot|log|exp|abs|sign|blur|brightness|contrast|drop-shadow|grayscale|hue-rotate|invert|opacity|saturate|sepia|rgb|hsl|hwb|lch|oklch|lab|oklab|color|color-mix|color-contrast|device-cmyk|light-dark|linear-gradient|radial-gradient|conic-gradient|repeating-linear-gradient|repeating-radial-gradient|repeating-conic-gradient|image|url|image-set|cross-fade|element|paint|counter|counters|symbols|circle|ellipse|inset|rect|xywh|polygon|path|attr|env|url|var|fit-content|minmax|repeat|stylistic|styleset|character-variant|swash|ornaments|annotation|linear|cubic-bezier|steps|scroll|view)\\([^\\)]+\\)$")) {
            return true;
        }
        if (!str.matches("^.*\\s.*$")) {
            for (String str2 : new String[]{"com.google.android.", "androidx."}) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
        }
        for (String str3 : new String[]{"anim", "animator", "array", C0497h.f3457a, "bool", "color", "dimen", "drawable", "fraction", "id", "integer", "interpolator", "layout", "menu", "mipmap", "plurals", "raw", "string", "style", "transition", XMLConstants.XML_NS_PREFIX}) {
            if (str.startsWith(new StringBuffer().append(new StringBuffer().append("@android:").append(str3).toString()).append("/").toString()) || str.startsWith(new StringBuffer().append(new StringBuffer().append("@").append(str3).toString()).append("/").toString())) {
                return true;
            }
        }
        for (String str4 : new String[]{":", "true", "false", "null", "%s", "%d", "%1$s", "%1$d", "%1$s – %2$s", "%1$d%2$s", "%1$s, %2$s", "%1$d/%2$d", "%1$d P", "sans-serif", "sans-serif-light", "sans-serif-condensed", "sans-serif-black", "sans-serif-thin", "sans-serif-medium"}) {
            if (str.equals(str4)) {
                return true;
            }
        }
        for (String str5 : C3080al.m18573a(this.f14495P, new String[]{"%b %-e, %Y, %-l:%M:%S %p", "%1$d P", "MMMM d", "ccc, dd MMM yyyy", "MM/dd HH:mm:ss", "yy/MM/dd HH:mm:ss"})) {
            if (str.equals(str5)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16798d(String str) {
        String str2;
        this.f14491L = str;
        if (C3112bn.m19040o(str)) {
            m16796c(this.f14498i);
            return;
        }
        if (!this.f14482C) {
            str = str.toLowerCase();
        }
        ArrayList arrayList = new ArrayList();
        for (C3236p c3236p : this.f14488I) {
            String m19381e = c3236p.m19381e();
            String m19386g = c3236p.m19386g();
            if (c3236p.m19387h() != null) {
                str2 = c3236p.m19387h();
            } else {
                str2 = "";
            }
            if (!this.f14482C) {
                m19386g = m19386g.toLowerCase();
                str2 = str2.toLowerCase();
                m19381e = m19381e.toLowerCase();
            }
            if (this.f14481B) {
                if (m19386g.equals(str) || str2.equals(str) || m19381e.equals(str)) {
                    arrayList.add(c3236p);
                }
            } else if (m19386g.contains(str) || str2.contains(str) || m19381e.contains(str)) {
                arrayList.add(c3236p);
            }
        }
        m16842a(arrayList, this.f14498i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16796c(boolean z) {
        if (z) {
            for (C3236p c3236p : m16851r()) {
                int m16774a = m16774a(c3236p);
                if (m16774a >= 0) {
                    this.f14488I.set(m16774a, c3236p);
                }
            }
        }
        m16842a(this.f14488I, this.f14498i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16803e(String str) {
        ArrayList arrayList = new ArrayList();
        List<C3236p> m19427b = C3239s.m19427b(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(str).toString()).append("/strings.xml").toString());
        for (int i = 0; i < m19427b.size(); i++) {
            C3236p c3236p = m19427b.get(i);
            if (m16774a(c3236p) == -1) {
                c3236p.m19375c(c3236p.m19386g());
                arrayList.add(c3236p);
            }
        }
        if (arrayList.isEmpty()) {
            C3112bn.m18999a(this.f14499k, R.string.not_found);
            return;
        }
        CustomListView customListView = new CustomListView(this);
        customListView.setFastScrollEnabled(C3102bd.f18314av);
        customListView.setDivider((Drawable) null);
        customListView.setDividerHeight(0);
        C3228h c3228h = new C3228h(this, arrayList);
        customListView.setAdapter((ListAdapter) c3228h);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m435b(customListView).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(getString(R.string.madd)).append(" (").toString()).append(str).toString()).append(")").toString()).m420a(R.string.madd, new DialogInterface.OnClickListener(this, c3228h) { // from class: ru.maximoff.apktool.TranslateActivity.42

            /* renamed from: a */
            private final TranslateActivity f14662a;

            /* renamed from: b */
            private final C3228h f14663b;

            {
                this.f14662a = this;
                this.f14663b = c3228h;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                List<C3236p> m19346c = this.f14663b.m19346c();
                this.f14662a.f14488I.addAll(m19346c);
                this.f14662a.m16842a(this.f14662a.f14488I, m19346c.size() > 0);
                C3112bn.m19023b(this.f14662a.f14499k, this.f14662a.getString(R.string.mtr_added, new Integer(m19346c.size())));
                dialogInterface.dismiss();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, c3228h) { // from class: ru.maximoff.apktool.TranslateActivity.43

            /* renamed from: a */
            private final TranslateActivity f14664a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14665b;

            /* renamed from: c */
            private final C3228h f14666c;

            {
                this.f14664a = this;
                this.f14665b = m438b;
                this.f14666c = c3228h;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f14665b.m414a(-1);
                m414a.setEnabled(false);
                this.f14666c.m19343a(m414a);
                Button m414a2 = this.f14665b.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, this.f14666c) { // from class: ru.maximoff.apktool.TranslateActivity.43.1

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC285343 f14667a;

                    /* renamed from: b */
                    private final C3228h f14668b;

                    {
                        this.f14667a = this;
                        this.f14668b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f14668b.m19342a();
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, this.f14666c) { // from class: ru.maximoff.apktool.TranslateActivity.43.2

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC285343 f14669a;

                    /* renamed from: b */
                    private final C3228h f14670b;

                    {
                        this.f14669a = this;
                        this.f14670b = r2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        this.f14670b.m19344b();
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16801d(boolean z) {
        if (z) {
            if (!this.f14491L.equals("")) {
                m16798d(this.f14491L);
                return;
            } else {
                m16842a(this.f14488I, this.f14498i);
                return;
            }
        }
        List<C3236p> m19415a = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14507s).toString()).append("/").toString()).append(this.f14508t).toString()).append(".xml").toString());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m19415a.size()) {
                break;
            }
            C3236p c3236p = m19415a.get(i2);
            int m16774a = m16774a(c3236p);
            if (m16774a >= 0) {
                c3236p.m19375c(this.f14488I.get(m16774a).m19387h());
                this.f14488I.remove(m16774a);
            } else {
                arrayList.add(c3236p);
            }
            i = i2 + 1;
        }
        m19415a.removeAll(arrayList);
        m19415a.addAll(this.f14488I);
        this.f14488I.clear();
        this.f14488I.addAll(m19415a);
        if (!this.f14491L.equals("")) {
            m16798d(this.f14491L);
        } else {
            m16842a(this.f14488I, this.f14498i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m16774a(C3236p c3236p) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f14488I.size()) {
                C3236p c3236p2 = this.f14488I.get(i2);
                if (c3236p2.m19381e().equals(c3236p.m19381e()) && (this.f14508t.equals("strings") || c3236p2.m19386g().equals(c3236p.m19386g()))) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m16807f(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f14488I.size()) {
                if (this.f14488I.get(i2).m19381e().equals(str)) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16806e(boolean z) {
        if (this.f14514z || this.f14480A) {
            m16810f(z);
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.translate_save, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.translatesaveEditText1);
        String stringBuffer = new StringBuffer().append("values").append(this.f14489J.equals("") ? "" : new StringBuffer().append("-").append(C3239s.m19438j(this.f14489J)).toString()).toString();
        editText.setText(stringBuffer);
        editText.setHint(stringBuffer);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.translatesaveImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView.setImageResource(R.drawable.ic_collapse_dark);
        }
        imageView.setOnClickListener(new ViewOnClickListenerC285444(this, editText));
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.translatesaveCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.translatesaveCheckBox2);
        if (!this.f14508t.equals("strings")) {
            checkBox2.setVisibility(8);
        }
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14499k).m435b(inflate).m429a(false).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(getString(R.string.save)).append(" (").toString()).append(this.f14508t).toString()).append(".xml)").toString()).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, checkBox, checkBox2, z) { // from class: ru.maximoff.apktool.TranslateActivity.45

            /* renamed from: a */
            private final TranslateActivity f14676a;

            /* renamed from: b */
            private final EditText f14677b;

            /* renamed from: c */
            private final CheckBox f14678c;

            /* renamed from: d */
            private final CheckBox f14679d;

            /* renamed from: e */
            private final boolean f14680e;

            {
                this.f14676a = this;
                this.f14677b = editText;
                this.f14678c = checkBox;
                this.f14679d = checkBox2;
                this.f14680e = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String editable = this.f14677b.getText().toString();
                if (!editable.startsWith("values")) {
                    C3112bn.m19023b(this.f14676a.f14499k, this.f14676a.getString(R.string.error));
                    return;
                }
                if (this.f14676a.f14503o.getCount() < this.f14676a.f14488I.size()) {
                    this.f14676a.m16796c(true);
                }
                try {
                    if (this.f14676a.f14508t.equals("arrays")) {
                        C3239s.m19420a(this.f14676a.f14504p.getAbsolutePath(), editable, this.f14676a.f14488I, !this.f14678c.isChecked());
                    } else if (this.f14676a.f14508t.equals("plurals")) {
                        C3239s.m19429b(this.f14676a.f14504p.getAbsolutePath(), editable, this.f14676a.f14488I, !this.f14678c.isChecked());
                    } else {
                        C3239s.m19421a(this.f14676a.f14504p.getAbsolutePath(), editable, this.f14676a.f14488I, !this.f14678c.isChecked(), this.f14679d.isChecked());
                    }
                    C3112bn.m19023b(this.f14676a.f14499k, this.f14676a.getString(R.string.success));
                } catch (Exception e2) {
                    C3112bn.m19023b(this.f14676a.f14499k, this.f14676a.getString(R.string.errorf, e2.getMessage()));
                }
                if (this.f14680e) {
                    this.f14676a.finish();
                } else {
                    this.f14676a.m16832v();
                }
            }
        });
        if (z) {
            m420a.m440c(R.string.exit, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.46

                /* renamed from: a */
                private final TranslateActivity f14681a;

                {
                    this.f14681a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14681a.finish();
                }
            });
        } else {
            m420a.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.47

                /* renamed from: a */
                private final TranslateActivity f14682a;

                {
                    this.f14682a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14682a.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14682a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14682a.f14507s).toString()).append("/").toString()).append(this.f14682a.f14508t).toString()).append(".xml").toString());
                    this.f14682a.m16842a(this.f14682a.f14488I, false);
                }
            });
        }
        DialogInterfaceC0070b m438b = m420a.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, stringBuffer, editText) { // from class: ru.maximoff.apktool.TranslateActivity.48

            /* renamed from: a */
            private final TranslateActivity f14683a;

            /* renamed from: b */
            private final String f14684b;

            /* renamed from: c */
            private final EditText f14685c;

            {
                this.f14683a = this;
                this.f14684b = stringBuffer;
                this.f14685c = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                int indexOf = this.f14684b.indexOf(45);
                this.f14685c.requestFocus();
                if (indexOf > 0) {
                    this.f14685c.setSelection(indexOf + 1, this.f14684b.length());
                } else {
                    this.f14685c.setSelection(this.f14684b.length());
                }
            }
        });
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$44 */
    class ViewOnClickListenerC285444 implements View.OnClickListener {

        /* renamed from: a */
        private final TranslateActivity f14671a;

        /* renamed from: b */
        private final EditText f14672b;

        ViewOnClickListenerC285444(TranslateActivity translateActivity, EditText editText) {
            this.f14671a = translateActivity;
            this.f14672b = editText;
        }

        /* renamed from: a */
        static TranslateActivity m16862a(ViewOnClickListenerC285444 viewOnClickListenerC285444) {
            return viewOnClickListenerC285444.f14671a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0170al c0170al = new C0170al(this.f14671a.f14499k);
            c0170al.mo1314a(new ArrayAdapter(this.f14671a.f14499k, C0012R.layout.simple_list_item_1, this.f14671a.f14505q));
            c0170al.m1320b(this.f14672b);
            c0170al.m1313a(new AdapterView.OnItemClickListener(this, c0170al, this.f14672b) { // from class: ru.maximoff.apktool.TranslateActivity.44.1

                /* renamed from: a */
                private final ViewOnClickListenerC285444 f14673a;

                /* renamed from: b */
                private final C0170al f14674b;

                /* renamed from: c */
                private final EditText f14675c;

                {
                    this.f14673a = this;
                    this.f14674b = c0170al;
                    this.f14675c = r3;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    this.f14674b.mo842c();
                    String str = ViewOnClickListenerC285444.m16862a(this.f14673a).f14505q[i];
                    this.f14675c.setText(str);
                    this.f14675c.requestFocus();
                    this.f14675c.setSelection(str.length());
                }
            });
            c0170al.mo841b_();
        }
    }

    /* renamed from: f */
    private void m16810f(boolean z) {
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14499k).m433b(R.string.save_file_msg).m429a(false).m418a(R.string.save).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, new DialogInterface.OnClickListener(this, z) { // from class: ru.maximoff.apktool.TranslateActivity.49

            /* renamed from: a */
            private final TranslateActivity f14686a;

            /* renamed from: b */
            private final boolean f14687b;

            {
                this.f14686a = this;
                this.f14687b = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                try {
                    if (this.f14686a.f14514z) {
                        new AsyncTaskC3232l(this.f14686a, this.f14686a.f14488I, this.f14687b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    } else {
                        new AsyncTaskC3234n(this.f14686a, this.f14686a.f14488I, this.f14687b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    }
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f14686a.f14499k, R.string.error_try_again);
                }
            }
        });
        if (z) {
            m420a.m440c(R.string.exit, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.50

                /* renamed from: a */
                private final TranslateActivity f14691a;

                {
                    this.f14691a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f14691a.finish();
                }
            });
        } else {
            m420a.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.51

                /* renamed from: a */
                private final TranslateActivity f14692a;

                {
                    this.f14692a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f14692a.recreate();
                }
            });
        }
        m420a.m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m16832v() {
        try {
            this.f14505q = C3239s.m19433e(this.f14504p.getAbsolutePath());
            if (this.f14505q == null || this.f14505q.length == 0) {
                throw new FileNotFoundException("Files not found!");
            }
            int i = 0;
            while (true) {
                if (i < this.f14505q.length) {
                    if (this.f14505q[i].equals(this.f14507s)) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = 0;
                    break;
                }
            }
            this.f14507s = this.f14505q[i];
            this.f14506r = C3239s.m19424a(new File(this.f14504p, new StringBuffer().append("/res/").append(this.f14507s).toString()));
            int i2 = 0;
            while (true) {
                if (i2 < this.f14506r.length) {
                    if (this.f14506r[i2].equals(this.f14508t)) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    i2 = 0;
                    break;
                }
            }
            this.f14508t = this.f14506r[i2];
            this.f14509u = true;
            this.f14501m.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14505q));
            this.f14509u = true;
            this.f14501m.setSelection(i);
            this.f14509u = true;
            this.f14502n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, this.f14506r));
            this.f14509u = true;
            this.f14502n.setSelection(i2);
            this.f14488I = C3239s.m19415a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14507s).toString()).append("/").toString()).append(this.f14508t).toString()).append(".xml").toString());
            m16842a(this.f14488I, false);
        } catch (Exception e2) {
            C3112bn.m19023b(this.f14499k, getString(R.string.errorf, e2.getMessage()));
            finish();
        }
    }

    /* renamed from: w */
    private void m16834w() {
        new DialogInterfaceC0070b.a(this.f14499k).m429a(true).m418a(R.string.confirmation).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.delete, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.52

            /* renamed from: a */
            private final TranslateActivity f14693a;

            {
                this.f14693a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                File file = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14693a.f14504p.getAbsolutePath()).append("/res/").toString()).append(this.f14693a.f14507s).toString()).append("/").toString()).append(this.f14693a.f14508t).toString()).append(".xml").toString());
                if (file.exists() && file.isFile() && file.delete()) {
                    C3112bn.m19023b(this.f14693a.f14499k, this.f14693a.getString(R.string.success));
                } else {
                    C3112bn.m19023b(this.f14693a.f14499k, this.f14693a.getString(R.string.error));
                }
                this.f14693a.m16832v();
            }
        }).m436b(getString(R.string.mtr_confirmation, this.f14507s, this.f14508t)).m438b().show();
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (this.f14503o.m16872b()) {
            this.f14503o.m16879g();
        } else if (this.f14484E.getVisibility() == 8) {
            m16847b(false);
        } else {
            this.f14484E.setVisibility(8);
            m16798d("");
        }
    }

    /* renamed from: b */
    public void m16847b(boolean z) {
        if (this.f14498i) {
            m16806e(true);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!z && currentTimeMillis - this.f14494O > 2000) {
            C3112bn.m18999a(this, R.string.click_once_more);
            this.f14494O = currentTimeMillis;
        } else {
            finish();
        }
    }

    /* renamed from: a */
    public void m16842a(List<C3236p> list, boolean z) {
        this.f14503o.m16868a();
        this.f14503o.m16869a(list);
        this.f14498i = z;
        invalidateOptionsMenu();
    }

    /* renamed from: b */
    public List<C3236p> m16846b(List<C3236p> list) {
        if (this.f14483D) {
            ArrayList arrayList = new ArrayList();
            for (C3236p c3236p : list) {
                if (!c3236p.m19390k()) {
                    arrayList.add(c3236p);
                }
            }
            return arrayList;
        }
        return list;
    }

    /* renamed from: r */
    public List<C3236p> m16851r() {
        return this.f14503o.m16880h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16792b(C3236p c3236p) {
        String trim;
        boolean equals = this.f14508t.equals("strings");
        View inflate = getLayoutInflater().inflate(R.layout.translate_dialog, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.translatedialogLinearLayout1);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.translatedialogLinearLayout2);
        TextView textView = (TextView) inflate.findViewById(R.id.translatedialogTextView3);
        TextView textView2 = (TextView) inflate.findViewById(R.id.translatedialogTextView4);
        if (equals && !c3236p.m19377c()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.translatedialogCheckBox2);
        if (equals) {
            checkBox.setVisibility(0);
            checkBox.setChecked(c3236p.m19391l());
        } else {
            checkBox.setVisibility(8);
        }
        Spinner spinner = (Spinner) inflate.findViewById(R.id.translatedialogSpinner1);
        linearLayout.setVisibility(0);
        EditText editText = (EditText) inflate.findViewById(R.id.translatedialogEditText3);
        editText.setSingleLine(true);
        editText.setText(c3236p.m19381e());
        EditText editText2 = (EditText) inflate.findViewById(R.id.translatedialogEditText1);
        editText2.setText(c3236p.m19386g());
        EditText editText3 = (EditText) inflate.findViewById(R.id.translatedialogEditText2);
        editText3.setText(c3236p.m19387h() == null ? c3236p.m19386g() : c3236p.m19387h());
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.translatedialogCheckBox1);
        checkBox2.setChecked(!c3236p.m19374b());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.translatedialogImageView2);
        String[] stringArray = getResources().getStringArray(R.array.quantity_items);
        if (!equals && !this.f14514z && !this.f14480A) {
            checkBox2.setVisibility(8);
            List<String> m19431c = C3239s.m19431c(this.f14488I);
            if (!m19431c.isEmpty()) {
                imageView.setVisibility(0);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_collapse);
                } else {
                    imageView.setImageResource(R.drawable.ic_collapse_dark);
                }
                imageView.setOnClickListener(new View.OnClickListener(this, (String[]) m19431c.toArray(new String[m19431c.size()]), editText) { // from class: ru.maximoff.apktool.TranslateActivity.53

                    /* renamed from: a */
                    private final TranslateActivity f14694a;

                    /* renamed from: b */
                    private final String[] f14695b;

                    /* renamed from: c */
                    private final EditText f14696c;

                    {
                        this.f14694a = this;
                        this.f14695b = r2;
                        this.f14696c = editText;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0170al c0170al = new C0170al(this.f14694a.f14499k);
                        c0170al.mo1314a(new ArrayAdapter(this.f14694a.f14499k, C0012R.layout.simple_list_item_1, this.f14695b));
                        c0170al.m1320b(this.f14696c);
                        c0170al.m1313a(new AdapterView.OnItemClickListener(this, c0170al, this.f14695b, this.f14696c) { // from class: ru.maximoff.apktool.TranslateActivity.53.1

                            /* renamed from: a */
                            private final ViewOnClickListenerC286453 f14697a;

                            /* renamed from: b */
                            private final C0170al f14698b;

                            /* renamed from: c */
                            private final String[] f14699c;

                            /* renamed from: d */
                            private final EditText f14700d;

                            {
                                this.f14697a = this;
                                this.f14698b = c0170al;
                                this.f14699c = r3;
                                this.f14700d = r4;
                            }

                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                                this.f14698b.mo842c();
                                String str = this.f14699c[i];
                                this.f14700d.setText(str);
                                this.f14700d.requestFocus();
                                this.f14700d.setSelection(str.length());
                            }
                        });
                        c0170al.mo841b_();
                    }
                });
            }
            if (c3236p.m19388i() != null) {
                linearLayout2.setVisibility(0);
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, stringArray));
                int i = 0;
                while (true) {
                    if (i >= stringArray.length) {
                        i = 0;
                        break;
                    } else if (stringArray[i].equals(c3236p.m19388i())) {
                        break;
                    } else {
                        i++;
                    }
                }
                spinner.setSelection(i);
            }
        }
        if (this.f14514z || this.f14480A) {
            checkBox2.setVisibility(8);
            editText.setVisibility(8);
            C3112bn.m19009a(textView, getString(R.string.filef, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(c3236p.m19393n().getAbsolutePath().substring(this.f14504p.getAbsolutePath().length())).append(" (").toString()).append(String.valueOf(c3236p.m19394o() + 1)).toString()).append(")").toString()));
            textView.setOnClickListener(new View.OnClickListener(this, c3236p) { // from class: ru.maximoff.apktool.TranslateActivity.54

                /* renamed from: a */
                private final TranslateActivity f14701a;

                /* renamed from: b */
                private final C3236p f14702b;

                {
                    this.f14701a = this;
                    this.f14702b = c3236p;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        this.f14701a.m16777a(this.f14702b.m19393n(), this.f14702b.m19394o() + 1);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f14701a, R.string.error);
                    }
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener(this, c3236p) { // from class: ru.maximoff.apktool.TranslateActivity.55

                /* renamed from: a */
                private final TranslateActivity f14703a;

                /* renamed from: b */
                private final C3236p f14704b;

                {
                    this.f14703a = this;
                    this.f14704b = c3236p;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    C3112bn.m19002a(this.f14703a, this.f14704b.m19393n().getAbsolutePath());
                    return true;
                }
            });
        }
        if (this.f14514z || this.f14480A) {
            trim = c3236p.m19381e().trim();
        } else {
            trim = c3236p.m19381e();
        }
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14499k).m435b(inflate).m429a(true).m427a(new StringBuffer().append(trim).append((this.f14514z || this.f14480A) ? "" : new StringBuffer().append(new StringBuffer().append(" (").append(this.f14508t).toString()).append(".xml)").toString()).toString()).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, (DialogInterface.OnClickListener) null);
        if (c3236p.m19390k()) {
            m420a.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, c3236p, equals) { // from class: ru.maximoff.apktool.TranslateActivity.56

                /* renamed from: a */
                private final TranslateActivity f14705a;

                /* renamed from: b */
                private final C3236p f14706b;

                /* renamed from: c */
                private final boolean f14707c;

                {
                    this.f14705a = this;
                    this.f14706b = c3236p;
                    this.f14707c = equals;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    this.f14706b.m19375c((String) null);
                    if (this.f14707c) {
                        this.f14706b.m19395p();
                    }
                    if (!this.f14705a.f14514z && !this.f14705a.f14480A) {
                        this.f14706b.m19378d(this.f14706b.m19389j());
                        this.f14706b.m19371a(this.f14706b.m19380d());
                    }
                    this.f14705a.f14503o.notifyDataSetChanged();
                }
            });
        }
        DialogInterfaceC0070b m438b = m420a.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC286857(this, editText3, m438b, c3236p, editText2, editText, equals, checkBox2, stringArray, spinner, checkBox));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$57 */
    class DialogInterfaceOnShowListenerC286857 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final TranslateActivity f14708a;

        /* renamed from: b */
        private final EditText f14709b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f14710c;

        /* renamed from: d */
        private final C3236p f14711d;

        /* renamed from: e */
        private final EditText f14712e;

        /* renamed from: f */
        private final EditText f14713f;

        /* renamed from: g */
        private final boolean f14714g;

        /* renamed from: h */
        private final CheckBox f14715h;

        /* renamed from: i */
        private final String[] f14716i;

        /* renamed from: j */
        private final Spinner f14717j;

        /* renamed from: k */
        private final CheckBox f14718k;

        DialogInterfaceOnShowListenerC286857(TranslateActivity translateActivity, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b, C3236p c3236p, EditText editText2, EditText editText3, boolean z, CheckBox checkBox, String[] strArr, Spinner spinner, CheckBox checkBox2) {
            this.f14708a = translateActivity;
            this.f14709b = editText;
            this.f14710c = dialogInterfaceC0070b;
            this.f14711d = c3236p;
            this.f14712e = editText2;
            this.f14713f = editText3;
            this.f14714g = z;
            this.f14715h = checkBox;
            this.f14716i = strArr;
            this.f14717j = spinner;
            this.f14718k = checkBox2;
        }

        /* renamed from: a */
        static TranslateActivity m16863a(DialogInterfaceOnShowListenerC286857 dialogInterfaceOnShowListenerC286857) {
            return dialogInterfaceOnShowListenerC286857.f14708a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f14709b.requestFocus();
            this.f14709b.selectAll();
            this.f14710c.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f14711d, this.f14712e, this.f14709b, this.f14710c, this.f14713f, this.f14714g, this.f14715h, this.f14716i, this.f14717j, this.f14718k) { // from class: ru.maximoff.apktool.TranslateActivity.57.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC286857 f14719a;

                /* renamed from: b */
                private final C3236p f14720b;

                /* renamed from: c */
                private final EditText f14721c;

                /* renamed from: d */
                private final EditText f14722d;

                /* renamed from: e */
                private final DialogInterfaceC0070b f14723e;

                /* renamed from: f */
                private final EditText f14724f;

                /* renamed from: g */
                private final boolean f14725g;

                /* renamed from: h */
                private final CheckBox f14726h;

                /* renamed from: i */
                private final String[] f14727i;

                /* renamed from: j */
                private final Spinner f14728j;

                /* renamed from: k */
                private final CheckBox f14729k;

                {
                    this.f14719a = this;
                    this.f14720b = r2;
                    this.f14721c = r3;
                    this.f14722d = r4;
                    this.f14723e = r5;
                    this.f14724f = r6;
                    this.f14725g = r7;
                    this.f14726h = r8;
                    this.f14727i = r9;
                    this.f14728j = r10;
                    this.f14729k = r11;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14514z || DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14480A) {
                        this.f14720b.m19372b(this.f14721c.getText().toString());
                        this.f14720b.m19375c(this.f14722d.getText().toString());
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14503o.notifyDataSetChanged();
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14498i = true;
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).invalidateOptionsMenu();
                        this.f14723e.cancel();
                        return;
                    }
                    String replaceAll = this.f14724f.getText().toString().replaceAll("[^\\d\\w\\$_]", "_");
                    if (this.f14720b.m19381e().equals(replaceAll) || DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).m16807f(replaceAll) == -1 || !this.f14725g) {
                        this.f14720b.m19369a(replaceAll);
                        this.f14720b.m19372b(this.f14721c.getText().toString());
                        this.f14720b.m19375c(this.f14722d.getText().toString());
                        this.f14720b.m19371a(!this.f14726h.isChecked());
                        if (this.f14720b.m19388i() != null) {
                            this.f14720b.m19378d(this.f14727i[this.f14728j.getSelectedItemPosition()]);
                        }
                        if (this.f14725g) {
                            this.f14720b.m19383e(this.f14729k.isChecked());
                        }
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14503o.notifyDataSetChanged();
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14498i = true;
                        DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).invalidateOptionsMenu();
                        this.f14723e.cancel();
                        return;
                    }
                    C3112bn.m19023b(DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).f14499k, DialogInterfaceOnShowListenerC286857.m16863a(this.f14719a).getString(R.string.string_exists));
                    this.f14724f.requestFocus();
                    this.f14724f.selectAll();
                }
            });
        }
    }

    /* renamed from: x */
    private void m16835x() {
        if (this.f14508t.equals("strings")) {
            invalidateOptionsMenu();
            return;
        }
        List<String> m19431c = C3239s.m19431c(this.f14488I);
        if (m19431c.isEmpty()) {
            C3112bn.m18999a(this, R.string.empty);
            return;
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.mtr_del_array).m432a((String[]) m19431c.toArray(new String[m19431c.size()]), (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null).m420a(R.string.delete, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.58

            /* renamed from: a */
            private final TranslateActivity f14730a;

            {
                this.f14730a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= m415a.getCount()) {
                        break;
                    }
                    if (m415a.isItemChecked(i3)) {
                        arrayList.add((String) m415a.getItemAtPosition(i3));
                    }
                    i2 = i3 + 1;
                }
                if (arrayList.isEmpty()) {
                    dialogInterface.dismiss();
                    return;
                }
                this.f14730a.f14488I = C3239s.m19417a((List<C3236p>) this.f14730a.f14488I, arrayList);
                this.f14730a.f14498i = true;
                this.f14730a.m16801d(this.f14730a.f14511w);
                dialogInterface.dismiss();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b) { // from class: ru.maximoff.apktool.TranslateActivity.59

            /* renamed from: a */
            private final TranslateActivity f14731a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14732b;

            {
                this.f14731a = this;
                this.f14732b = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f14732b.m414a(-1);
                m414a.setEnabled(false);
                ListView m415a = this.f14732b.m415a();
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.TranslateActivity.59.1

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC287059 f14733a;

                    /* renamed from: b */
                    private final ListView f14734b;

                    /* renamed from: c */
                    private final Button f14735c;

                    {
                        this.f14733a = this;
                        this.f14734b = m415a;
                        this.f14735c = m414a;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        for (int i2 = 0; i2 < this.f14734b.getCount(); i2++) {
                            if (this.f14734b.isItemChecked(i2)) {
                                this.f14735c.setEnabled(true);
                                return;
                            }
                        }
                        this.f14735c.setEnabled(false);
                    }
                });
                Button m414a2 = this.f14732b.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.TranslateActivity.59.2

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC287059 f14736a;

                    /* renamed from: b */
                    private final ListView f14737b;

                    /* renamed from: c */
                    private final Button f14738c;

                    {
                        this.f14736a = this;
                        this.f14737b = m415a;
                        this.f14738c = m414a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z = false;
                        for (int i = 0; i < this.f14737b.getCount(); i++) {
                            boolean z2 = !this.f14737b.isItemChecked(i);
                            if (z2 && !z) {
                                z = true;
                            }
                            this.f14737b.setItemChecked(i, z2);
                        }
                        this.f14738c.setEnabled(z);
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.TranslateActivity.59.3

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC287059 f14739a;

                    /* renamed from: b */
                    private final ListView f14740b;

                    /* renamed from: c */
                    private final Button f14741c;

                    {
                        this.f14739a = this;
                        this.f14740b = m415a;
                        this.f14741c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i = 0; i < this.f14740b.getCount(); i++) {
                            this.f14740b.setItemChecked(i, true);
                        }
                        this.f14741c.setEnabled(true);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: y */
    private void m16837y() {
        boolean equals = this.f14508t.equals("strings");
        View inflate = getLayoutInflater().inflate(R.layout.translate_dialog, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.translatedialogLinearLayout2);
        ((TextView) inflate.findViewById(R.id.translatedialogTextView1)).setText(R.string.name);
        ((TextView) inflate.findViewById(R.id.translatedialogTextView2)).setText(R.string.value);
        EditText editText = (EditText) inflate.findViewById(R.id.translatedialogEditText1);
        editText.setSingleLine(true);
        EditText editText2 = (EditText) inflate.findViewById(R.id.translatedialogEditText2);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.translatedialogSpinner1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.translatedialogImageView1);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.translatedialogCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.translatedialogCheckBox2);
        if (equals) {
            checkBox2.setVisibility(0);
        } else {
            checkBox2.setVisibility(8);
        }
        String[] stringArray = getResources().getStringArray(R.array.quantity_items);
        if (!equals) {
            checkBox.setVisibility(8);
            List<String> m19431c = C3239s.m19431c(this.f14488I);
            if (!m19431c.isEmpty()) {
                imageView.setVisibility(0);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_collapse);
                } else {
                    imageView.setImageResource(R.drawable.ic_collapse_dark);
                }
                imageView.setOnClickListener(new View.OnClickListener(this, (String[]) m19431c.toArray(new String[m19431c.size()]), editText) { // from class: ru.maximoff.apktool.TranslateActivity.60

                    /* renamed from: a */
                    private final TranslateActivity f14748a;

                    /* renamed from: b */
                    private final String[] f14749b;

                    /* renamed from: c */
                    private final EditText f14750c;

                    {
                        this.f14748a = this;
                        this.f14749b = r2;
                        this.f14750c = editText;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0170al c0170al = new C0170al(this.f14748a.f14499k);
                        c0170al.mo1314a(new ArrayAdapter(this.f14748a.f14499k, C0012R.layout.simple_list_item_1, this.f14749b));
                        c0170al.m1320b(this.f14750c);
                        c0170al.m1313a(new AdapterView.OnItemClickListener(this, c0170al, this.f14749b, this.f14750c) { // from class: ru.maximoff.apktool.TranslateActivity.60.1

                            /* renamed from: a */
                            private final ViewOnClickListenerC287260 f14751a;

                            /* renamed from: b */
                            private final C0170al f14752b;

                            /* renamed from: c */
                            private final String[] f14753c;

                            /* renamed from: d */
                            private final EditText f14754d;

                            {
                                this.f14751a = this;
                                this.f14752b = c0170al;
                                this.f14753c = r3;
                                this.f14754d = r4;
                            }

                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                                this.f14752b.mo842c();
                                String str = this.f14753c[i];
                                this.f14754d.setText(str);
                                this.f14754d.requestFocus();
                                this.f14754d.setSelection(str.length());
                            }
                        });
                        c0170al.mo841b_();
                    }
                });
            }
            if (this.f14508t.equals("plurals")) {
                linearLayout.setVisibility(0);
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14499k, C0012R.layout.simple_spinner_dropdown_item, stringArray));
                spinner.setSelection(0);
            }
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f14499k).m435b(inflate).m429a(true).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(getString(R.string.madd)).append(" (").toString()).append(this.f14508t).toString()).append(".xml)").toString()).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.madd, (DialogInterface.OnClickListener) null).m440c(R.string.add_from, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC287361(this, editText, m438b, editText2, equals, stringArray, spinner, checkBox, checkBox2));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$61 */
    class DialogInterfaceOnShowListenerC287361 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final TranslateActivity f14755a;

        /* renamed from: b */
        private final EditText f14756b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f14757c;

        /* renamed from: d */
        private final EditText f14758d;

        /* renamed from: e */
        private final boolean f14759e;

        /* renamed from: f */
        private final String[] f14760f;

        /* renamed from: g */
        private final Spinner f14761g;

        /* renamed from: h */
        private final CheckBox f14762h;

        /* renamed from: i */
        private final CheckBox f14763i;

        DialogInterfaceOnShowListenerC287361(TranslateActivity translateActivity, EditText editText, DialogInterfaceC0070b dialogInterfaceC0070b, EditText editText2, boolean z, String[] strArr, Spinner spinner, CheckBox checkBox, CheckBox checkBox2) {
            this.f14755a = translateActivity;
            this.f14756b = editText;
            this.f14757c = dialogInterfaceC0070b;
            this.f14758d = editText2;
            this.f14759e = z;
            this.f14760f = strArr;
            this.f14761g = spinner;
            this.f14762h = checkBox;
            this.f14763i = checkBox2;
        }

        /* renamed from: a */
        static TranslateActivity m16864a(DialogInterfaceOnShowListenerC287361 dialogInterfaceOnShowListenerC287361) {
            return dialogInterfaceOnShowListenerC287361.f14755a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f14756b.requestFocus();
            this.f14757c.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f14756b, this.f14758d, this.f14759e, this.f14760f, this.f14761g, this.f14762h, this.f14763i, this.f14757c) { // from class: ru.maximoff.apktool.TranslateActivity.61.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC287361 f14764a;

                /* renamed from: b */
                private final EditText f14765b;

                /* renamed from: c */
                private final EditText f14766c;

                /* renamed from: d */
                private final boolean f14767d;

                /* renamed from: e */
                private final String[] f14768e;

                /* renamed from: f */
                private final Spinner f14769f;

                /* renamed from: g */
                private final CheckBox f14770g;

                /* renamed from: h */
                private final CheckBox f14771h;

                /* renamed from: i */
                private final DialogInterfaceC0070b f14772i;

                {
                    this.f14764a = this;
                    this.f14765b = r2;
                    this.f14766c = r3;
                    this.f14767d = r4;
                    this.f14768e = r5;
                    this.f14769f = r6;
                    this.f14770g = r7;
                    this.f14771h = r8;
                    this.f14772i = r9;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3236p c3236p = new C3236p(this.f14765b.getText().toString().replaceAll("[^\\d\\w\\$_]", "_"), this.f14766c.getText().toString(), this.f14766c.getText().toString());
                    if (DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).m16774a(c3236p) == -1 || !this.f14767d) {
                        if (DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).f14508t.equals("plurals")) {
                            c3236p.m19378d(this.f14768e[this.f14769f.getSelectedItemPosition()]);
                        }
                        c3236p.m19371a(!this.f14770g.isChecked());
                        if (this.f14767d) {
                            c3236p.m19383e(this.f14771h.isChecked());
                        }
                        DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).f14488I.add(c3236p);
                        DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).f14498i = true;
                        DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).m16801d(DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).f14511w);
                        this.f14772i.cancel();
                        return;
                    }
                    C3112bn.m19023b(DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).f14499k, DialogInterfaceOnShowListenerC287361.m16864a(this.f14764a).getString(R.string.string_exists));
                    this.f14765b.requestFocus();
                    this.f14765b.selectAll();
                }
            });
            Button m414a = this.f14757c.m414a(-3);
            m414a.setEnabled(this.f14755a.f14505q.length > 1 && this.f14759e);
            m414a.setOnClickListener(new AnonymousClass2(this, this.f14757c));
        }

        /* renamed from: ru.maximoff.apktool.TranslateActivity$61$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final DialogInterfaceOnShowListenerC287361 f14773a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14774b;

            AnonymousClass2(DialogInterfaceOnShowListenerC287361 dialogInterfaceOnShowListenerC287361, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f14773a = dialogInterfaceOnShowListenerC287361;
                this.f14774b = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static DialogInterfaceOnShowListenerC287361 m16865a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f14773a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                for (String str : DialogInterfaceOnShowListenerC287361.m16864a(this.f14773a).f14505q) {
                    if (!str.equals(DialogInterfaceOnShowListenerC287361.m16864a(this.f14773a).f14507s)) {
                        arrayList.add(str);
                    }
                }
                new DialogInterfaceC0070b.a(DialogInterfaceOnShowListenerC287361.m16864a(this.f14773a).f14499k).m429a(true).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, arrayList, this.f14774b) { // from class: ru.maximoff.apktool.TranslateActivity.61.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f14775a;

                    /* renamed from: b */
                    private final List f14776b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f14777c;

                    {
                        this.f14775a = this;
                        this.f14776b = arrayList;
                        this.f14777c = r3;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogInterfaceOnShowListenerC287361.m16864a(AnonymousClass2.m16865a(this.f14775a)).m16803e((String) this.f14776b.get(i));
                        dialogInterface.dismiss();
                        this.f14777c.cancel();
                    }
                }).m438b().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16779a(String str, C3236p c3236p) {
        List<C3236p> m19427b = C3239s.m19427b(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14504p.getAbsolutePath()).append("/res/").toString()).append(str).toString()).append("/strings.xml").toString());
        int m19412a = C3239s.m19412a(m19427b, c3236p);
        if (m19412a == -1) {
            C3112bn.m18999a(this.f14499k, R.string.not_found);
            return;
        }
        C3236p c3236p2 = m19427b.get(m19412a);
        View inflate = getLayoutInflater().inflate(R.layout.translate_comp, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.translateCompTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.translateCompTextView2);
        Object[] objArr = new Object[2];
        objArr[0] = this.f14507s;
        objArr[1] = c3236p.m19387h() == null ? c3236p.m19386g() : c3236p.m19387h();
        textView.setText(String.format("%s: %s", objArr));
        textView2.setText(String.format("%s: %s", str, c3236p2.m19386g()));
        new DialogInterfaceC0070b.a(this.f14499k).m418a(R.string.compare_text).m435b(inflate).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m440c(R.string.paste, new DialogInterface.OnClickListener(this, c3236p, c3236p2) { // from class: ru.maximoff.apktool.TranslateActivity.62

            /* renamed from: a */
            private final TranslateActivity f14778a;

            /* renamed from: b */
            private final C3236p f14779b;

            /* renamed from: c */
            private final C3236p f14780c;

            {
                this.f14778a = this;
                this.f14779b = c3236p;
                this.f14780c = c3236p2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f14779b.m19375c(this.f14780c.m19386g());
                this.f14778a.f14503o.notifyDataSetChanged();
                this.f14778a.f14498i = true;
                this.f14778a.invalidateOptionsMenu();
                dialogInterface.cancel();
            }
        }).m438b().show();
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$a */
    private class C2878a extends BaseAdapter {

        /* renamed from: a */
        private List<C3236p> f14786a;

        /* renamed from: b */
        private List<C3236p> f14787b;

        /* renamed from: c */
        private List<Integer> f14788c;

        /* renamed from: d */
        private boolean f14789d;

        /* renamed from: e */
        private int f14790e = 0;

        /* renamed from: f */
        private final TranslateActivity f14791f;

        /* renamed from: a */
        static TranslateActivity m16866a(C2878a c2878a) {
            return c2878a.f14791f;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m16867a(i);
        }

        public C2878a(TranslateActivity translateActivity, List<C3236p> list) {
            this.f14791f = translateActivity;
            this.f14786a = (List) null;
            this.f14787b = (List) null;
            this.f14788c = (List) null;
            this.f14786a = this.f14791f.m16846b(list);
            this.f14787b = list;
            this.f14789d = this.f14791f.f14483D;
            this.f14788c = new ArrayList();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f14786a != null) {
                return this.f14786a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i * 7;
        }

        /* renamed from: a */
        public C3236p m16867a(int i) {
            return (this.f14786a == null || i >= this.f14786a.size()) ? (C3236p) null : this.f14786a.get(i);
        }

        /* renamed from: a */
        public void m16869a(List<C3236p> list) {
            this.f14787b.addAll(list);
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void m16868a() {
            this.f14788c.clear();
            this.f14786a.clear();
            this.f14787b.clear();
        }

        /* renamed from: b */
        public void m16871b(int i) {
            C3236p m16867a = m16867a(i);
            if (m16867a != null) {
                int m16774a = this.f14791f.m16774a(m16867a);
                this.f14787b.remove(i);
                if (m16774a >= 0) {
                    this.f14791f.f14488I.remove(m16774a);
                }
                this.f14791f.f14498i = (this.f14791f.f14514z || this.f14791f.f14480A) ? false : true;
            }
            notifyDataSetChanged();
        }

        /* renamed from: b */
        public boolean m16872b() {
            return !this.f14788c.isEmpty();
        }

        /* renamed from: c */
        public void m16874c(int i) {
            if (this.f14788c.contains(new Integer(i))) {
                this.f14788c.remove(new Integer(i));
            } else {
                this.f14788c.add(new Integer(i));
            }
            notifyDataSetChanged();
        }

        /* renamed from: c */
        public void m16873c() {
            this.f14788c.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f14786a.size()) {
                    if (this.f14786a.get(i2).m19390k()) {
                        m16874c(i2);
                    }
                    i = i2 + 1;
                } else {
                    notifyDataSetChanged();
                    return;
                }
            }
        }

        /* renamed from: a */
        public void m16870a(boolean z) {
            if (!z) {
                this.f14788c.clear();
            }
            for (int i = 0; i < this.f14786a.size(); i++) {
                m16874c(i);
            }
            notifyDataSetChanged();
        }

        /* renamed from: d */
        public void m16876d(int i) {
            if (m16872b()) {
                Collections.sort(this.f14788c);
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f14788c.size()) {
                        break;
                    }
                    int intValue = this.f14788c.get(i3).intValue();
                    if (i3 == 0 && i < intValue) {
                        while (i < intValue) {
                            m16874c(i);
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
                        m16874c(i2);
                    }
                }
                notifyDataSetChanged();
            }
        }

        /* renamed from: d */
        public void m16875d() {
            if (m16872b()) {
                Collections.sort(this.f14788c);
                for (int size = this.f14788c.size(); size > 0; size--) {
                    m16871b(this.f14788c.get(size - 1).intValue());
                }
                m16879g();
            }
        }

        /* renamed from: e */
        public void m16877e() {
            if (m16872b()) {
                int i = 0;
                for (Integer num : this.f14788c) {
                    if (num.intValue() < this.f14786a.size()) {
                        C3236p c3236p = this.f14786a.get(num.intValue());
                        if (c3236p.m19390k()) {
                            c3236p.m19375c((String) null);
                            c3236p.m19371a(c3236p.m19380d());
                            i++;
                        }
                    }
                }
                if (!this.f14791f.f14498i) {
                    this.f14791f.f14498i = i > 0;
                }
                m16879g();
            }
        }

        /* renamed from: f */
        public void m16878f() {
            if (m16872b()) {
                int i = 0;
                for (Integer num : this.f14788c) {
                    if (num.intValue() < this.f14786a.size()) {
                        C3236p c3236p = this.f14786a.get(num.intValue());
                        if (!c3236p.m19390k()) {
                            c3236p.m19366a();
                            i++;
                        }
                    }
                }
                if (!this.f14791f.f14498i) {
                    this.f14791f.f14498i = i > 0;
                }
                m16879g();
            }
        }

        /* renamed from: g */
        public void m16879g() {
            this.f14788c.clear();
            notifyDataSetChanged();
        }

        /* renamed from: h */
        public List<C3236p> m16880h() {
            return this.f14787b;
        }

        /* renamed from: i */
        public List<C3236p> m16881i() {
            if (m16872b()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = this.f14788c.iterator();
                while (it.hasNext()) {
                    C3236p m16867a = m16867a(it.next().intValue());
                    if (m16867a != null) {
                        arrayList.add(m16867a);
                    }
                }
                return arrayList;
            }
            return this.f14786a;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            this.f14790e = 0;
            if (this.f14789d ? !this.f14791f.f14483D : this.f14791f.f14483D) {
                this.f14789d = this.f14791f.f14483D;
                m16879g();
                return;
            }
            if (this.f14791f.f14511w && this.f14791f.f14508t.equals("strings")) {
                Collections.sort(this.f14787b, this.f14791f.f14492M);
            }
            this.f14786a = this.f14791f.m16846b(this.f14787b);
            this.f14791f.m16849p();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C2879b c2879b;
            View view2;
            C3236p c3236p = this.f14786a.get(i);
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.f14791f.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (this.f14791f.f14513y) {
                    view2 = layoutInflater.inflate(R.layout.translate_item_old, (ViewGroup) null);
                } else {
                    view2 = layoutInflater.inflate(R.layout.translate_item, (ViewGroup) null);
                }
                C2879b c2879b2 = new C2879b(this.f14791f);
                c2879b2.f14823a = i;
                c2879b2.f14827e = (TextView) view2.findViewById(R.id.itemValue);
                c2879b2.f14825c = (TextView) view2.findViewById(R.id.itemNumber);
                if (this.f14791f.f14513y) {
                    c2879b2.f14826d = (TextView) null;
                    c2879b2.f14824b = (LinearLayout) view2.findViewById(R.id.itemNumberWrap);
                    c2879b2.f14828f = (TextView) view2.findViewById(R.id.itemValueTrans);
                } else {
                    c2879b2.f14826d = (TextView) view2.findViewById(R.id.itemName);
                    c2879b2.f14824b = (LinearLayout) null;
                    c2879b2.f14828f = (TextView) null;
                }
                view2.setTag(c2879b2);
                c2879b = c2879b2;
            } else {
                c2879b = (C2879b) view.getTag();
                view2 = view;
            }
            if (this.f14791f.f14510v) {
                c2879b.f14825c.setTextSize(2, C3102bd.f18332o);
                if (this.f14791f.f14513y) {
                    c2879b.f14824b.setVisibility(0);
                } else {
                    c2879b.f14825c.setVisibility(0);
                }
                if (this.f14790e == 0) {
                    this.f14790e = (int) ((c2879b.f14825c.getPaint().measureText(String.valueOf(this.f14786a.size())) + 6) * this.f14791f.f14499k.getResources().getDisplayMetrics().density * 0.5f);
                }
                c2879b.f14825c.setMinimumWidth(this.f14790e);
                c2879b.f14825c.setText(String.valueOf(i + 1));
            } else {
                if (this.f14791f.f14513y) {
                    c2879b.f14824b.setVisibility(8);
                } else {
                    c2879b.f14825c.setVisibility(8);
                }
                c2879b.f14825c.setText("0");
            }
            boolean contains = this.f14788c.contains(new Integer(i));
            if (contains) {
                view2.setBackgroundColor(C3246h.m19470a(this.f14791f.f14499k, R.color.tvery_light_blue));
            } else if (c3236p.m19390k()) {
                view2.setBackgroundColor(C3246h.m19470a(this.f14791f.f14499k, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
            } else {
                view2.setBackgroundColor(0);
            }
            view2.setMinimumHeight(0);
            c2879b.f14827e.setTextSize(2, C3102bd.f18332o);
            if (this.f14791f.f14513y) {
                c2879b.f14827e.setText(c3236p.m19386g());
                c2879b.f14828f.setTextSize(2, C3102bd.f18332o);
                if (c3236p.m19387h() != null) {
                    c2879b.f14828f.setText(c3236p.m19387h());
                } else {
                    c2879b.f14828f.setText("");
                }
            } else {
                if (this.f14791f.f14514z || this.f14791f.f14480A) {
                    c2879b.f14826d.setText(c3236p.m19381e().trim());
                } else {
                    c2879b.f14826d.setText(c3236p.m19381e());
                }
                c2879b.f14826d.setTextSize(2, C3102bd.f18332o - 2);
                if (C3102bd.f18291a) {
                    c2879b.f14827e.setBackgroundResource(R.drawable.border);
                } else {
                    c2879b.f14827e.setBackgroundResource(R.drawable.border_dark);
                }
                if (c3236p.m19387h() != null) {
                    c2879b.f14827e.setText(c3236p.m19387h());
                } else {
                    c2879b.f14827e.setText(c3236p.m19386g());
                }
            }
            view2.setOnClickListener(new View.OnClickListener(this, i, c3236p) { // from class: ru.maximoff.apktool.TranslateActivity.a.1

                /* renamed from: a */
                private final C2878a f14792a;

                /* renamed from: b */
                private final int f14793b;

                /* renamed from: c */
                private final C3236p f14794c;

                {
                    this.f14792a = this;
                    this.f14793b = i;
                    this.f14794c = c3236p;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (this.f14792a.m16872b()) {
                        this.f14792a.m16874c(this.f14793b);
                    } else {
                        C2878a.m16866a(this.f14792a).m16792b(this.f14794c);
                    }
                }
            });
            view2.setOnLongClickListener(new AnonymousClass2(this, contains, i, c3236p));
            return view2;
        }

        /* renamed from: ru.maximoff.apktool.TranslateActivity$a$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final C2878a f14795a;

            /* renamed from: b */
            private final boolean f14796b;

            /* renamed from: c */
            private final int f14797c;

            /* renamed from: d */
            private final C3236p f14798d;

            AnonymousClass2(C2878a c2878a, boolean z, int i, C3236p c3236p) {
                this.f14795a = c2878a;
                this.f14796b = z;
                this.f14797c = i;
                this.f14798d = c3236p;
            }

            /* renamed from: a */
            static C2878a m16882a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f14795a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                C0173ao c0173ao = new C0173ao(C2878a.m16866a(this.f14795a).f14499k, view);
                if (C3102bd.m18910a(C2878a.m16866a(this.f14795a).f14499k, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                if (this.f14795a.m16872b() && !this.f14796b) {
                    c0173ao.m1339a().add(0, 1900, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mselect_to)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14797c) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.1

                        /* renamed from: a */
                        private final AnonymousClass2 f14799a;

                        /* renamed from: b */
                        private final int f14800b;

                        {
                            this.f14799a = this;
                            this.f14800b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass2.m16882a(this.f14799a).m16876d(this.f14800b);
                            return true;
                        }
                    });
                    c0173ao.m1344c();
                } else {
                    c0173ao.m1339a().add(0, 1900, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mtr_auto)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14797c) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.2

                        /* renamed from: a */
                        private final AnonymousClass2 f14805a;

                        /* renamed from: b */
                        private final int f14806b;

                        {
                            this.f14805a = this;
                            this.f14806b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (!AnonymousClass2.m16882a(this.f14805a).m16872b()) {
                                AnonymousClass2.m16882a(this.f14805a).m16874c(this.f14806b);
                            }
                            C2878a.m16866a(AnonymousClass2.m16882a(this.f14805a)).m16830u();
                            return true;
                        }
                    });
                    if (C2878a.m16866a(this.f14795a).f14514z || C2878a.m16866a(this.f14795a).f14480A) {
                        i2 = 1901;
                    } else {
                        i2 = 1902;
                        c0173ao.m1339a().add(0, 1901, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.delete)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14797c) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.3

                            /* renamed from: a */
                            private final AnonymousClass2 f14807a;

                            /* renamed from: b */
                            private final int f14808b;

                            {
                                this.f14807a = this;
                                this.f14808b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                if (AnonymousClass2.m16882a(this.f14807a).m16872b()) {
                                    AnonymousClass2.m16882a(this.f14807a).m16875d();
                                    return true;
                                }
                                AnonymousClass2.m16882a(this.f14807a).m16871b(this.f14808b);
                                return true;
                            }
                        });
                    }
                    if (this.f14798d.m19390k() || this.f14795a.m16872b()) {
                        c0173ao.m1339a().add(0, i2, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14798d) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.4

                            /* renamed from: a */
                            private final AnonymousClass2 f14809a;

                            /* renamed from: b */
                            private final C3236p f14810b;

                            {
                                this.f14809a = this;
                                this.f14810b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                if (AnonymousClass2.m16882a(this.f14809a).m16872b()) {
                                    AnonymousClass2.m16882a(this.f14809a).m16877e();
                                    return true;
                                }
                                this.f14810b.m19375c((String) null);
                                if (C2878a.m16866a(AnonymousClass2.m16882a(this.f14809a)).f14508t.equals("strings")) {
                                    this.f14810b.m19395p();
                                }
                                this.f14810b.m19371a(this.f14810b.m19380d());
                                AnonymousClass2.m16882a(this.f14809a).notifyDataSetChanged();
                                return true;
                            }
                        });
                        i2++;
                    }
                    if (!this.f14798d.m19390k() || this.f14795a.m16872b()) {
                        c0173ao.m1339a().add(0, i2, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mtr_mark_trans)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14798d) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.5

                            /* renamed from: a */
                            private final AnonymousClass2 f14811a;

                            /* renamed from: b */
                            private final C3236p f14812b;

                            {
                                this.f14811a = this;
                                this.f14812b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                if (AnonymousClass2.m16882a(this.f14811a).m16872b()) {
                                    AnonymousClass2.m16882a(this.f14811a).m16878f();
                                    return true;
                                }
                                this.f14812b.m19366a();
                                AnonymousClass2.m16882a(this.f14811a).notifyDataSetChanged();
                                return true;
                            }
                        });
                        i2++;
                    }
                    if (!this.f14795a.m16872b()) {
                        int i6 = i2 + 1;
                        c0173ao.m1339a().add(0, i2, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.cp_name)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14798d) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.6

                            /* renamed from: a */
                            private final AnonymousClass2 f14813a;

                            /* renamed from: b */
                            private final C3236p f14814b;

                            {
                                this.f14813a = this;
                                this.f14814b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3112bn.m19002a(C2878a.m16866a(AnonymousClass2.m16882a(this.f14813a)).f14499k, this.f14814b.m19381e());
                                return true;
                            }
                        });
                        if (!C2878a.m16866a(this.f14795a).f14508t.equals("strings") || C2878a.m16866a(this.f14795a).f14505q.length <= 1) {
                            i5 = i6;
                        } else {
                            i5 = i6 + 1;
                            c0173ao.m1339a().add(0, i6, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.compare_text)).setOnMenuItemClickListener(new AnonymousClass7(this, this.f14798d));
                        }
                        int i7 = i5 + 1;
                        c0173ao.m1339a().add(0, i5, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mselect)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14797c) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.8

                            /* renamed from: a */
                            private final AnonymousClass2 f14820a;

                            /* renamed from: b */
                            private final int f14821b;

                            {
                                this.f14820a = this;
                                this.f14821b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                AnonymousClass2.m16882a(this.f14820a).m16874c(this.f14821b);
                                return true;
                            }
                        });
                        if (C2878a.m16866a(this.f14795a).f14498i) {
                            i4 = i7 + 1;
                            c0173ao.m1339a().add(0, i7, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.select_mod)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.9

                                /* renamed from: a */
                                private final AnonymousClass2 f14822a;

                                {
                                    this.f14822a = this;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    AnonymousClass2.m16882a(this.f14822a).m16873c();
                                    return true;
                                }
                            });
                        } else {
                            i4 = i7;
                        }
                        String m16840a = C2878a.m16866a(this.f14795a).m16840a(this.f14798d.m19381e());
                        if (m16840a != null) {
                            i3 = i4 + 1;
                            c0173ao.m1339a().add(0, i4, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.copy_id)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m16840a) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.10

                                /* renamed from: a */
                                private final AnonymousClass2 f14801a;

                                /* renamed from: b */
                                private final String f14802b;

                                {
                                    this.f14801a = this;
                                    this.f14802b = m16840a;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    C3112bn.m19002a(C2878a.m16866a(AnonymousClass2.m16882a(this.f14801a)).f14499k, this.f14802b);
                                    return true;
                                }
                            });
                        }
                        int i8 = i4 + 1;
                        c0173ao.m1339a().add(0, i4, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mselect_all)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.12

                            /* renamed from: a */
                            private final AnonymousClass2 f14804a;

                            {
                                this.f14804a = this;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                AnonymousClass2.m16882a(this.f14804a).m16870a(false);
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                    } else {
                        i3 = i2 + 1;
                        c0173ao.m1339a().add(0, i2, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mselect_inv)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.11

                            /* renamed from: a */
                            private final AnonymousClass2 f14803a;

                            {
                                this.f14803a = this;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                AnonymousClass2.m16882a(this.f14803a).m16870a(true);
                                return true;
                            }
                        });
                    }
                    i4 = i3;
                    int i82 = i4 + 1;
                    c0173ao.m1339a().add(0, i4, 0, C2878a.m16866a(this.f14795a).f14499k.getString(R.string.mselect_all)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.12

                        /* renamed from: a */
                        private final AnonymousClass2 f14804a;

                        {
                            this.f14804a = this;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass2.m16882a(this.f14804a).m16870a(false);
                            return true;
                        }
                    });
                    c0173ao.m1344c();
                }
                return true;
            }

            /* renamed from: ru.maximoff.apktool.TranslateActivity$a$2$7, reason: invalid class name */
            class AnonymousClass7 implements MenuItem.OnMenuItemClickListener {

                /* renamed from: a */
                private final AnonymousClass2 f14815a;

                /* renamed from: b */
                private final C3236p f14816b;

                AnonymousClass7(AnonymousClass2 anonymousClass2, C3236p c3236p) {
                    this.f14815a = anonymousClass2;
                    this.f14816b = c3236p;
                }

                /* renamed from: a */
                static AnonymousClass2 m16883a(AnonymousClass7 anonymousClass7) {
                    return anonymousClass7.f14815a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : C2878a.m16866a(AnonymousClass2.m16882a(this.f14815a)).f14505q) {
                        if (!str.equals(C2878a.m16866a(AnonymousClass2.m16882a(this.f14815a)).f14507s)) {
                            arrayList.add(str);
                        }
                    }
                    new DialogInterfaceC0070b.a(C2878a.m16866a(AnonymousClass2.m16882a(this.f14815a)).f14499k).m429a(true).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, arrayList, this.f14816b) { // from class: ru.maximoff.apktool.TranslateActivity.a.2.7.1

                        /* renamed from: a */
                        private final AnonymousClass7 f14817a;

                        /* renamed from: b */
                        private final List f14818b;

                        /* renamed from: c */
                        private final C3236p f14819c;

                        {
                            this.f14817a = this;
                            this.f14818b = arrayList;
                            this.f14819c = r3;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C2878a.m16866a(AnonymousClass2.m16882a(AnonymousClass7.m16883a(this.f14817a))).m16779a((String) this.f14818b.get(i), this.f14819c);
                            dialogInterface.dismiss();
                        }
                    }).m438b().show();
                    return true;
                }
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.TranslateActivity$b */
    private class C2879b {

        /* renamed from: a */
        public int f14823a;

        /* renamed from: b */
        public LinearLayout f14824b;

        /* renamed from: c */
        public TextView f14825c;

        /* renamed from: d */
        public TextView f14826d;

        /* renamed from: e */
        public TextView f14827e;

        /* renamed from: f */
        public TextView f14828f;

        /* renamed from: g */
        private final TranslateActivity f14829g;

        public C2879b(TranslateActivity translateActivity) {
            this.f14829g = translateActivity;
        }
    }
}
