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
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
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
import java.p209io.BufferedInputStream;
import java.p209io.ByteArrayInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import p176f.p177a.p178a.C1528a;
import p176f.p177a.p178a.C1532c;
import p176f.p177a.p178a.InterfaceC1531b;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3257q;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.p311b.C3317a;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* loaded from: classes.dex */
public class SoEditor extends AbstractActivityC2894b {

    /* renamed from: A */
    private Map<String, C1532c> f14315A;

    /* renamed from: B */
    private boolean f14316B;

    /* renamed from: C */
    private boolean f14317C;

    /* renamed from: D */
    private int f14318D;

    /* renamed from: E */
    private int f14319E;

    /* renamed from: F */
    private String f14320F;

    /* renamed from: G */
    private String f14321G;

    /* renamed from: l */
    public boolean f14327l;

    /* renamed from: m */
    private Context f14328m;

    /* renamed from: n */
    private File f14329n;

    /* renamed from: o */
    private boolean f14330o;

    /* renamed from: p */
    private boolean f14331p;

    /* renamed from: q */
    private String f14332q;

    /* renamed from: r */
    private CheckBox f14333r;

    /* renamed from: s */
    private EditText f14334s;

    /* renamed from: t */
    private LinearLayout f14335t;

    /* renamed from: u */
    private CheckBox f14336u;

    /* renamed from: v */
    private Spinner f14337v;

    /* renamed from: w */
    private CustomListView f14338w;

    /* renamed from: x */
    private C2814f f14339x;

    /* renamed from: y */
    private boolean f14340y;

    /* renamed from: z */
    private C1528a f14341z;

    /* renamed from: h */
    public List<String> f14323h = new ArrayList();

    /* renamed from: i */
    public List<String> f14324i = new ArrayList();

    /* renamed from: j */
    public List<String> f14325j = new ArrayList();

    /* renamed from: k */
    public List<Integer> f14326k = new ArrayList();

    /* renamed from: H */
    private long f14322H = 0;

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
            if (intent.hasExtra("apk_path")) {
                this.f14320F = intent.getStringExtra("apk_path");
                this.f14321G = intent.getStringExtra("data");
                C2604w c2604w = new C2604w(this.f14320F);
                C2602u m16162a = c2604w.m16162a(this.f14321G);
                this.f14329n = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                C1887e.m13962a(new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a()), new FileOutputStream(this.f14329n));
            } else {
                this.f14320F = (String) null;
                this.f14321G = (String) null;
                this.f14329n = new File(intent.getStringExtra("data"));
            }
            this.f14328m = this;
            this.f14327l = false;
            this.f14330o = false;
            this.f14331p = false;
            this.f14316B = false;
            this.f14332q = "";
            this.f14319E = 0;
            this.f14318D = intent.getIntExtra("type", 0);
            this.f14340y = C3102bd.m18925a((Context) this, "soed_line_num", true);
            this.f14317C = C3102bd.m18925a((Context) this, "soed_backup", true);
            ((TextView) findViewById(R.id.translateTextView1)).setVisibility(this.f14320F == null ? this.f14329n.canWrite() : new File(this.f14320F).canWrite() ? 8 : 0);
            ImageView imageView = (ImageView) findViewById(R.id.clearText1);
            if (C3102bd.f18291a) {
                imageView.setImageResource(R.drawable.ic_close);
            } else {
                imageView.setImageResource(R.drawable.ic_close_dark);
            }
            this.f14335t = (LinearLayout) findViewById(R.id.translateLinearLayout1);
            this.f14334s = (EditText) findViewById(R.id.translateEditText1);
            this.f14333r = (CheckBox) findViewById(R.id.translateCheckBox1);
            this.f14333r.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.SoEditor.1

                /* renamed from: a */
                private final SoEditor f14342a;

                {
                    this.f14342a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14342a.f14330o = this.f14342a.f14333r.isChecked();
                    this.f14342a.m16715b(this.f14342a.f14332q);
                }
            });
            this.f14336u = (CheckBox) findViewById(R.id.translateCheckBox2);
            this.f14336u.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.SoEditor.2

                /* renamed from: a */
                private final SoEditor f14383a;

                {
                    this.f14383a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14383a.f14331p = this.f14383a.f14336u.isChecked();
                    this.f14383a.m16715b(this.f14383a.f14332q);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.SoEditor.3

                /* renamed from: a */
                private final SoEditor f14404a;

                {
                    this.f14404a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14404a.f14334s.requestFocus();
                    this.f14404a.f14334s.setText("");
                }
            });
            if (this.f14334s.getText().length() == 0) {
                imageView.setVisibility(8);
            }
            C3112bn.m19006a(this.f14334s, 10000);
            this.f14334s.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.SoEditor.4

                /* renamed from: a */
                private final SoEditor f14407a;

                /* renamed from: b */
                private final ImageView f14408b;

                {
                    this.f14407a = this;
                    this.f14408b = imageView;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (this.f14407a.f14339x != null) {
                        if (editable.length() == 0) {
                            this.f14408b.setVisibility(8);
                        } else {
                            this.f14408b.setVisibility(0);
                        }
                        this.f14407a.m16715b(editable.toString());
                        this.f14407a.f14334s.requestFocus();
                    }
                }
            });
            C3212b c3212b = new C3212b(this, "soeditor");
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
            imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.SoEditor.5

                /* renamed from: a */
                private final SoEditor f14409a;

                /* renamed from: b */
                private final C3212b f14410b;

                /* renamed from: c */
                private final ImageView f14411c;

                {
                    this.f14409a = this;
                    this.f14410b = c3212b;
                    this.f14411c = imageView2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14410b.m19201a(this.f14411c, this.f14409a.f14334s);
                }
            });
            imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.SoEditor.6

                /* renamed from: a */
                private final SoEditor f14412a;

                /* renamed from: b */
                private final C3212b f14413b;

                /* renamed from: c */
                private final ImageView f14414c;

                {
                    this.f14412a = this;
                    this.f14413b = c3212b;
                    this.f14414c = imageView2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    new C3078aj(this.f14412a.f14328m).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14413b, this.f14414c) { // from class: ru.maximoff.apktool.SoEditor.6.1

                        /* renamed from: a */
                        private final ViewOnLongClickListenerC28056 f14415a;

                        /* renamed from: b */
                        private final C3212b f14416b;

                        /* renamed from: c */
                        private final ImageView f14417c;

                        {
                            this.f14415a = this;
                            this.f14416b = r2;
                            this.f14417c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14416b.m19208d();
                            this.f14417c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            this.f14334s.setImeOptions(3);
            this.f14334s.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.SoEditor.7

                /* renamed from: a */
                private final SoEditor f14418a;

                /* renamed from: b */
                private final C3212b f14419b;

                /* renamed from: c */
                private final ImageView f14420c;

                {
                    this.f14418a = this;
                    this.f14419b = c3212b;
                    this.f14420c = imageView2;
                }

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 3) {
                        return false;
                    }
                    if (this.f14419b.m19204a(this.f14418a.f14334s.getText().toString())) {
                        this.f14420c.setVisibility(0);
                    }
                    if (this.f14418a.f14319E + 1 < this.f14418a.f14326k.size()) {
                        this.f14418a.f14319E++;
                    } else {
                        this.f14418a.f14319E = 0;
                    }
                    this.f14418a.m16706a(this.f14418a.f14319E, true);
                    return true;
                }
            });
            this.f14338w = (CustomListView) findViewById(R.id.translateListView1);
            this.f14338w.setFastScrollEnabled(C3102bd.f18314av);
            this.f14337v = (Spinner) findViewById(R.id.translateSpinner1);
            this.f14337v.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.SoEditor.8

                /* renamed from: a */
                private final SoEditor f14421a;

                {
                    this.f14421a = this;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.f14421a.f14316B) {
                        this.f14421a.f14318D = i;
                        new AsyncTaskC2809a(this.f14421a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14421a.m16741q());
                    }
                }
            });
            this.f14339x = new C2814f(this, this);
            this.f14338w.setAdapter((ListAdapter) this.f14339x);
            try {
                new AsyncTaskC2810b(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new FileInputStream(this.f14329n));
            } catch (Error e2) {
                C3112bn.m19023b(this, getString(R.string.errorf, e2.getMessage()));
            } catch (Exception e3) {
                C3112bn.m19023b(this, getString(R.string.errorf, e3.getMessage()));
            }
        } catch (Exception e4) {
            C3112bn.m19023b(this, getString(R.string.errorf, e4.getMessage()));
            finish();
        }
    }

    /* renamed from: o */
    public void m16752o() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.SoEditor.9

            /* renamed from: a */
            private final SoEditor f14422a;

            {
                this.f14422a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                String name;
                if (this.f14422a.f14320F != null) {
                    int lastIndexOf = this.f14422a.f14321G.lastIndexOf(47);
                    if (lastIndexOf == -1) {
                        name = this.f14422a.f14321G;
                    } else {
                        name = this.f14422a.f14321G.substring(lastIndexOf + 1);
                    }
                } else {
                    name = this.f14422a.f14329n.getName();
                }
                if (this.f14422a.f14327l || this.f14422a.m16744r()) {
                    name = new StringBuffer().append("*").append(name).toString();
                }
                this.f14422a.m454f().mo390a(name);
            }
        }, 100L);
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f14329n != null) {
            bundle.putString("PROJECT_FILE", this.f14329n.getAbsolutePath());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("PROJECT_FILE", (String) null);
        if (string != null) {
            this.f14329n = new File(string);
        }
    }

    /* renamed from: p */
    private void m16740p() {
        if (this.f14324i.isEmpty()) {
            C3112bn.m18999a(this.f14328m, R.string.not_found);
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
        checkBox.setChecked(C3102bd.m18925a((Context) this, "soed_repl_regex", false));
        checkBox2.setChecked(C3102bd.m18925a((Context) this, "soed_repl_sens", false));
        C3212b c3212b = new C3212b(this, "soeditor");
        if (c3212b.m19205b().isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView, editText) { // from class: ru.maximoff.apktool.SoEditor.10

            /* renamed from: a */
            private final SoEditor f14343a;

            /* renamed from: b */
            private final C3212b f14344b;

            /* renamed from: c */
            private final ImageView f14345c;

            /* renamed from: d */
            private final EditText f14346d;

            {
                this.f14343a = this;
                this.f14344b = c3212b;
                this.f14345c = imageView;
                this.f14346d = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14344b.m19201a(this.f14345c, this.f14346d);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.SoEditor.11

            /* renamed from: a */
            private final SoEditor f14347a;

            /* renamed from: b */
            private final C3212b f14348b;

            /* renamed from: c */
            private final ImageView f14349c;

            {
                this.f14347a = this;
                this.f14348b = c3212b;
                this.f14349c = imageView;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f14347a.f14328m).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14348b, this.f14349c) { // from class: ru.maximoff.apktool.SoEditor.11.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC278111 f14350a;

                    /* renamed from: b */
                    private final C3212b f14351b;

                    /* renamed from: c */
                    private final ImageView f14352c;

                    {
                        this.f14350a = this;
                        this.f14351b = r2;
                        this.f14352c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14351b.m19208d();
                        this.f14352c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        C3212b c3212b2 = new C3212b(this, "soeditor_repl");
        if (c3212b2.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.SoEditor.12

            /* renamed from: a */
            private final SoEditor f14353a;

            /* renamed from: b */
            private final C3212b f14354b;

            /* renamed from: c */
            private final ImageView f14355c;

            /* renamed from: d */
            private final EditText f14356d;

            {
                this.f14353a = this;
                this.f14354b = c3212b2;
                this.f14355c = imageView2;
                this.f14356d = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14354b.m19201a(this.f14355c, this.f14356d);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b2, imageView2) { // from class: ru.maximoff.apktool.SoEditor.13

            /* renamed from: a */
            private final SoEditor f14357a;

            /* renamed from: b */
            private final C3212b f14358b;

            /* renamed from: c */
            private final ImageView f14359c;

            {
                this.f14357a = this;
                this.f14358b = c3212b2;
                this.f14359c = imageView2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f14357a.f14328m).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14358b, this.f14359c) { // from class: ru.maximoff.apktool.SoEditor.13.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC278313 f14360a;

                    /* renamed from: b */
                    private final C3212b f14361b;

                    /* renamed from: c */
                    private final ImageView f14362c;

                    {
                        this.f14360a = this;
                        this.f14361b = r2;
                        this.f14362c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14361b.m19208d();
                        this.f14362c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.SoEditor.14

            /* renamed from: a */
            private final SoEditor f14363a;

            /* renamed from: b */
            private final EditText f14364b;

            {
                this.f14363a = this;
                this.f14364b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14364b.requestFocus();
                this.f14364b.setText("");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.SoEditor.15

            /* renamed from: a */
            private final SoEditor f14365a;

            /* renamed from: b */
            private final EditText f14366b;

            {
                this.f14365a = this;
                this.f14366b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14366b.requestFocus();
                this.f14366b.setText("");
            }
        });
        imageView3.setVisibility(8);
        imageView4.setVisibility(8);
        editText.addTextChangedListener(new TextWatcher(this, buttonArr, imageView3) { // from class: ru.maximoff.apktool.SoEditor.16

            /* renamed from: a */
            private final SoEditor f14367a;

            /* renamed from: b */
            private final Button[] f14368b;

            /* renamed from: c */
            private final ImageView f14369c;

            {
                this.f14367a = this;
                this.f14368b = buttonArr;
                this.f14369c = imageView3;
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
                    if (this.f14368b[0] != null) {
                        this.f14368b[0].setEnabled(false);
                    }
                    this.f14369c.setVisibility(8);
                } else {
                    if (this.f14368b[0] != null) {
                        this.f14368b[0].setEnabled(true);
                    }
                    this.f14369c.setVisibility(0);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this, imageView4) { // from class: ru.maximoff.apktool.SoEditor.17

            /* renamed from: a */
            private final SoEditor f14370a;

            /* renamed from: b */
            private final ImageView f14371b;

            {
                this.f14370a = this;
                this.f14371b = imageView4;
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
                    this.f14371b.setVisibility(8);
                } else {
                    this.f14371b.setVisibility(0);
                }
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.replace).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, editText2, checkBox, checkBox2, c3212b, c3212b2) { // from class: ru.maximoff.apktool.SoEditor.18

            /* renamed from: a */
            private final SoEditor f14372a;

            /* renamed from: b */
            private final EditText f14373b;

            /* renamed from: c */
            private final EditText f14374c;

            /* renamed from: d */
            private final CheckBox f14375d;

            /* renamed from: e */
            private final CheckBox f14376e;

            /* renamed from: f */
            private final C3212b f14377f;

            /* renamed from: g */
            private final C3212b f14378g;

            {
                this.f14372a = this;
                this.f14373b = editText;
                this.f14374c = editText2;
                this.f14375d = checkBox;
                this.f14376e = checkBox2;
                this.f14377f = c3212b;
                this.f14378g = c3212b2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                String editable = this.f14373b.getText().toString();
                String editable2 = this.f14374c.getText().toString();
                boolean isChecked = this.f14375d.isChecked();
                boolean isChecked2 = this.f14376e.isChecked();
                this.f14377f.m19204a(editable);
                this.f14378g.m19204a(editable2);
                C3102bd.m18938b(this.f14372a.f14328m, "soed_repl_regex", isChecked);
                C3102bd.m18938b(this.f14372a.f14328m, "soed_repl_sens", isChecked2);
                new AsyncTaskC2811c(this.f14372a, editable, editable2, isChecked, isChecked2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.SoEditor.19

            /* renamed from: a */
            private final SoEditor f14379a;

            /* renamed from: b */
            private final Button[] f14380b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f14381c;

            /* renamed from: d */
            private final EditText f14382d;

            {
                this.f14379a = this;
                this.f14380b = buttonArr;
                this.f14381c = m438b;
                this.f14382d = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14380b[0] = this.f14381c.m414a(-1);
                this.f14380b[0].setEnabled(false);
                this.f14382d.requestFocus();
                this.f14382d.selectAll();
            }
        });
        m438b.show();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        getMenuInflater().inflate(R.menu.soeditor, menu);
        boolean canWrite = this.f14320F == null ? this.f14329n.canWrite() : new File(this.f14320F).canWrite();
        menu.findItem(R.id.line_num).setChecked(this.f14340y);
        menu.findItem(R.id.backup).setChecked(this.f14317C);
        menu.findItem(R.id.save).setEnabled(canWrite);
        menu.findItem(R.id.reset).setVisible(this.f14327l || m16744r());
        if (C3102bd.f18291a) {
            i = R.drawable.ic_help_light;
        } else {
            i = R.drawable.ic_help_dark;
        }
        menu.findItem(R.id.info).setIcon(i);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.reset).setVisible(this.f14327l || m16744r());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.info /* 2131689924 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.minfo).m433b(R.string.so_info).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.save /* 2131690189 */:
                m16723c(false);
                break;
            case R.id.reset /* 2131690190 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.search_reset).m433b(R.string.mtr_sure).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.SoEditor.21

                    /* renamed from: a */
                    private final SoEditor f14385a;

                    {
                        this.f14385a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int i2 = 0; i2 < this.f14385a.f14325j.size(); i2++) {
                            this.f14385a.f14325j.set(i2, "");
                        }
                        this.f14385a.f14339x.m16767a(this.f14385a.f14324i, this.f14385a.f14325j, this.f14385a.f14326k);
                        this.f14385a.invalidateOptionsMenu();
                        dialogInterface.cancel();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.search /* 2131690191 */:
                if (this.f14335t.getVisibility() == 8) {
                    this.f14335t.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.SoEditor.20

                        /* renamed from: a */
                        private final SoEditor f14384a;

                        {
                            this.f14384a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14384a.f14334s.requestFocus();
                            ((InputMethodManager) this.f14384a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f14384a.f14334s, 1);
                            this.f14384a.f14334s.selectAll();
                        }
                    }, 100L);
                    break;
                } else {
                    this.f14335t.setVisibility(8);
                    m16715b("");
                    break;
                }
            case R.id.replace /* 2131690192 */:
                m16740p();
                break;
            case R.id.line_num /* 2131690193 */:
                this.f14340y = !menuItem.isChecked();
                C3102bd.m18938b(this, "soed_line_num", this.f14340y);
                invalidateOptionsMenu();
                this.f14339x.m16767a(this.f14324i, this.f14325j, this.f14326k);
                break;
            case R.id.backup /* 2131690194 */:
                this.f14317C = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "soed_backup", this.f14317C);
                invalidateOptionsMenu();
                break;
            case R.id.prop /* 2131690195 */:
                m16746s();
                break;
            case R.id.exit /* 2131690197 */:
                m16751a(true);
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m16749a(InterfaceC1531b interfaceC1531b, InputStream inputStream) {
        this.f14341z = new C1528a(new ByteArrayInputStream(C1887e.m13984b(inputStream)), interfaceC1531b);
    }

    /* renamed from: a */
    public void m16750a(String str) {
        if (m16741q().equals("rodata")) {
            this.f14341z.m11721a(this.f14324i, this.f14325j, this.f14341z.f9750c);
        } else {
            this.f14341z.m11721a(this.f14324i, this.f14325j, this.f14341z.f9749b);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        this.f14341z.m11720a(fileOutputStream);
        fileOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public String m16741q() {
        return this.f14323h.get(this.f14318D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m16744r() {
        Iterator<String> it = this.f14325j.iterator();
        while (it.hasNext()) {
            if (!it.next().equals("")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: s */
    private void m16746s() {
        String absolutePath;
        if (this.f14320F != null) {
            absolutePath = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14320F).append(" (").toString()).append(this.f14321G).toString()).append(")").toString();
        } else {
            absolutePath = this.f14329n.getAbsolutePath();
        }
        new DialogInterfaceC0070b.a(this).m418a(R.string.properties).m436b(getString(R.string.so_prop, absolutePath, C3106bh.m18975a(this.f14329n.length(), C3102bd.f18305am), m16741q(), String.valueOf(this.f14324i.size()), String.valueOf(m16747t()))).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: t */
    private int m16747t() {
        int i = 0;
        Iterator<String> it = this.f14325j.iterator();
        while (it.hasNext()) {
            if (!it.next().equals("")) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16715b(String str) {
        int i = 0;
        this.f14332q = str;
        this.f14326k.clear();
        this.f14319E = 0;
        if (str.equals("")) {
            this.f14339x.m16767a(this.f14324i, this.f14325j, this.f14326k);
            return;
        }
        if (!this.f14331p) {
            str = str.toLowerCase();
        }
        while (true) {
            int i2 = i;
            if (i2 < this.f14324i.size()) {
                String str2 = this.f14324i.get(i2);
                String str3 = this.f14325j.get(i2);
                if (!this.f14331p) {
                    str2 = str2.toLowerCase();
                    str3 = str3.toLowerCase();
                }
                if (this.f14330o) {
                    if (str2.equals(str) || str3.equals(str)) {
                        this.f14326k.add(new Integer(i2));
                    }
                } else if (str2.contains(str) || str3.contains(str)) {
                    this.f14326k.add(new Integer(i2));
                }
                i = i2 + 1;
            } else {
                this.f14339x.m16767a(this.f14324i, this.f14325j, this.f14326k);
                m16706a(this.f14319E, true);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16706a(int i, boolean z) {
        if (this.f14326k.isEmpty()) {
            C3112bn.m18999a(this, R.string.not_found);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, i, z) { // from class: ru.maximoff.apktool.SoEditor.22

                /* renamed from: a */
                private final SoEditor f14386a;

                /* renamed from: b */
                private final int f14387b;

                /* renamed from: c */
                private final boolean f14388c;

                {
                    this.f14386a = this;
                    this.f14387b = i;
                    this.f14388c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f14387b < this.f14386a.f14326k.size()) {
                        this.f14386a.f14338w.setSelection(this.f14386a.f14326k.get(this.f14387b).intValue());
                        if (this.f14388c) {
                            this.f14386a.f14334s.requestFocus();
                            this.f14386a.f14334s.setSelection(this.f14386a.f14334s.getText().length());
                        }
                    }
                }
            }, 100L);
        }
    }

    /* renamed from: b */
    private void m16718b(boolean z) {
        DialogInterfaceC0070b.a m434b = new DialogInterfaceC0070b.a(this).m418a(R.string.save).m433b(R.string.file_changed).m420a(R.string.save, new DialogInterface.OnClickListener(this, z) { // from class: ru.maximoff.apktool.SoEditor.23

            /* renamed from: a */
            private final SoEditor f14389a;

            /* renamed from: b */
            private final boolean f14390b;

            {
                this.f14389a = this;
                this.f14390b = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f14389a.m16723c(this.f14390b);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (z) {
            m434b.m440c(R.string.exit, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.SoEditor.24

                /* renamed from: a */
                private final SoEditor f14391a;

                {
                    this.f14391a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f14391a.finish();
                }
            });
        }
        m434b.m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16723c(boolean z) {
        if (this.f14320F == null) {
            try {
                new AsyncTaskC2813e(this, z).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14329n.getAbsolutePath());
            } catch (Exception e2) {
                C3112bn.m18999a(this, R.string.error_try_again);
            }
        } else {
            int[] iArr = {1, 3, 0};
            C3262u.m19599a(this, iArr, new Runnable(this, iArr, z) { // from class: ru.maximoff.apktool.SoEditor.25

                /* renamed from: a */
                private final SoEditor f14392a;

                /* renamed from: b */
                private final int[] f14393b;

                /* renamed from: c */
                private final boolean f14394c;

                {
                    this.f14392a = this;
                    this.f14393b = iArr;
                    this.f14394c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new AsyncTaskC2812d(this.f14392a, this.f14392a, this.f14393b[0], this.f14394c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File[0]);
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f14392a, R.string.error_try_again);
                    }
                }
            }, (Runnable) null);
        }
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$a */
    private class AsyncTaskC2809a extends AsyncTask<String, Void, Void> {

        /* renamed from: a */
        private DialogInterfaceC0070b f14423a;

        /* renamed from: b */
        private final SoEditor f14424b;

        @Override // android.p008os.AsyncTask
        protected Void doInBackground(String[] strArr) {
            return m16753a(strArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Void r1) {
            m16754a(r1);
        }

        /* renamed from: a */
        protected Void m16753a(String... strArr) {
            if (this.f14424b.f14315A != null) {
                if (this.f14424b.m16744r()) {
                    if (this.f14424b.m16741q().equals("dynstr")) {
                        this.f14424b.f14341z.m11721a(this.f14424b.f14324i, this.f14424b.f14325j, this.f14424b.f14341z.f9750c);
                    } else {
                        this.f14424b.f14341z.m11721a(this.f14424b.f14324i, this.f14424b.f14325j, this.f14424b.f14341z.f9749b);
                    }
                    this.f14424b.f14327l = true;
                }
                this.f14424b.f14324i.clear();
                this.f14424b.f14325j.clear();
                for (C1532c c1532c : this.f14424b.f14315A.values()) {
                    String str = c1532c.f9832c;
                    if (c1532c.f9831b.equals(strArr[0])) {
                        this.f14424b.f14324i.add(str);
                        this.f14424b.f14325j.add("");
                    }
                }
            }
            return (Void) null;
        }

        /* renamed from: a */
        protected void m16754a(Void r5) {
            if (this.f14423a != null && this.f14423a.isShowing()) {
                try {
                    this.f14423a.cancel();
                } catch (Exception e2) {
                }
            }
            this.f14424b.f14316B = true;
            this.f14424b.f14339x.m16767a(this.f14424b.f14324i, this.f14424b.f14325j, this.f14424b.f14326k);
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14424b.f14328m).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14423a = new DialogInterfaceC0070b.a(this.f14424b.f14328m).m435b(inflate).m429a(false).m438b();
            this.f14423a.show();
        }

        public AsyncTaskC2809a(SoEditor soEditor) {
            this.f14424b = soEditor;
        }
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$b */
    private class AsyncTaskC2810b extends AsyncTask<InputStream, Integer, String> {

        /* renamed from: a */
        private DialogInterfaceC0070b f14425a;

        /* renamed from: b */
        private InterfaceC1531b f14426b;

        /* renamed from: c */
        private final SoEditor f14427c;

        /* renamed from: a */
        static SoEditor m16755a(AsyncTaskC2810b asyncTaskC2810b) {
            return asyncTaskC2810b.f14427c;
        }

        @Override // android.p008os.AsyncTask
        protected String doInBackground(InputStream[] inputStreamArr) {
            return m16756a(inputStreamArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(String str) {
            m16757a(str);
        }

        @Override // android.p008os.AsyncTask
        protected void onProgressUpdate(Integer[] numArr) {
            m16758a(numArr);
        }

        /* renamed from: a */
        protected String m16756a(InputStream... inputStreamArr) {
            try {
                this.f14427c.m16749a(this.f14426b, inputStreamArr[0]);
                return (String) null;
            } catch (Exception e2) {
                return e2.getMessage();
            }
        }

        /* renamed from: a */
        protected void m16757a(String str) {
            if (this.f14425a != null && this.f14425a.isShowing()) {
                try {
                    this.f14425a.cancel();
                } catch (Exception e2) {
                }
            }
            if (str != null) {
                C3112bn.m19023b(this.f14427c, this.f14427c.getString(R.string.errorf, str));
                this.f14427c.finish();
            } else if (this.f14427c.f14323h.isEmpty()) {
                C3112bn.m19023b(this.f14427c, this.f14427c.getString(R.string.errorf, "parsing error"));
                this.f14427c.finish();
            } else {
                Collections.sort(this.f14427c.f14323h);
                this.f14427c.f14337v.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f14427c.f14328m, C0012R.layout.simple_spinner_dropdown_item, (String[]) this.f14427c.f14323h.toArray(new String[this.f14427c.f14323h.size()])));
                this.f14427c.f14337v.setSelection(this.f14427c.f14318D);
                new AsyncTaskC2809a(this.f14427c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14427c.m16741q());
            }
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14427c.f14328m).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14425a = new DialogInterfaceC0070b.a(this.f14427c).m435b(inflate).m429a(false).m438b();
            this.f14425a.show();
            this.f14427c.f14323h.clear();
            this.f14426b = new InterfaceC1531b(this) { // from class: ru.maximoff.apktool.SoEditor.b.1

                /* renamed from: a */
                private final AsyncTaskC2810b f14428a;

                {
                    this.f14428a = this;
                }

                @Override // p176f.p177a.p178a.InterfaceC1531b
                /* renamed from: a */
                public void mo11752a(C1532c c1532c) {
                    if (AsyncTaskC2810b.m16755a(this.f14428a).f14315A == null) {
                        AsyncTaskC2810b.m16755a(this.f14428a).f14315A = new LinkedHashMap();
                    }
                    AsyncTaskC2810b.m16755a(this.f14428a).f14315A.put(c1532c.f9832c, c1532c);
                    if (AsyncTaskC2810b.m16755a(this.f14428a).f14323h.contains(c1532c.f9831b)) {
                        return;
                    }
                    AsyncTaskC2810b.m16755a(this.f14428a).f14323h.add(c1532c.f9831b);
                }
            };
        }

        /* renamed from: a */
        protected void m16758a(Integer... numArr) {
            this.f14425a.m416a(String.valueOf(numArr[0]));
        }

        public AsyncTaskC2810b(SoEditor soEditor) {
            this.f14427c = soEditor;
        }
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$e */
    private class AsyncTaskC2813e extends AsyncTask<String, String, String> {

        /* renamed from: a */
        private DialogInterfaceC0070b f14446a;

        /* renamed from: b */
        private File f14447b;

        /* renamed from: c */
        private boolean f14448c;

        /* renamed from: d */
        private final SoEditor f14449d;

        @Override // android.p008os.AsyncTask
        protected String doInBackground(String[] strArr) {
            return m16763a(strArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(String str) {
            m16764a(str);
        }

        public AsyncTaskC2813e(SoEditor soEditor, boolean z) {
            this.f14449d = soEditor;
            this.f14448c = z;
        }

        /* renamed from: a */
        protected String m16763a(String... strArr) {
            try {
                File file = new File(new StringBuffer().append(strArr[0]).append(".bak").toString());
                if (this.f14449d.f14317C && !file.isFile()) {
                    C3262u.m19612a(this.f14449d.f14329n, file);
                }
                this.f14447b = File.createTempFile("APKTOOL_M", ".sobak", C3102bd.m18908a());
                C3262u.m19612a(this.f14449d.f14329n, this.f14447b);
                this.f14449d.m16750a(strArr[0]);
                return (String) null;
            } catch (Exception e2) {
                return e2.getMessage();
            }
        }

        /* renamed from: a */
        protected void m16764a(String str) {
            if (this.f14446a != null && this.f14446a.isShowing()) {
                try {
                    this.f14446a.cancel();
                } catch (Exception e2) {
                }
            }
            if (str != null) {
                C3262u.m19612a(this.f14447b, this.f14449d.f14329n);
                this.f14447b.delete();
                C3112bn.m19023b(this.f14449d, this.f14449d.getString(R.string.errorf, str));
                return;
            }
            this.f14447b.delete();
            this.f14449d.f14327l = false;
            C3112bn.m18999a(this.f14449d, R.string.success);
            if (this.f14448c) {
                this.f14449d.finish();
            } else {
                this.f14449d.recreate();
            }
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14449d.f14328m).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14446a = new DialogInterfaceC0070b.a(this.f14449d.f14328m).m435b(inflate).m429a(false).m438b();
            this.f14446a.show();
        }
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, android.app.Activity
    public void recreate() {
        finish();
        startActivity(getIntent().putExtra("type", this.f14318D));
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (this.f14335t.getVisibility() == 0) {
            this.f14335t.setVisibility(8);
            m16715b("");
        } else {
            m16751a(false);
        }
    }

    /* renamed from: a */
    public void m16751a(boolean z) {
        if ((this.f14320F == null ? this.f14329n.canWrite() : new File(this.f14320F).canWrite()) && (this.f14327l || m16744r())) {
            m16718b(true);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!z && currentTimeMillis - this.f14322H > 2000) {
            C3112bn.m18999a(this, R.string.click_once_more);
            this.f14322H = currentTimeMillis;
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16720c(int i) {
        String str = this.f14324i.get(i);
        String str2 = this.f14325j.get(i);
        View inflate = getLayoutInflater().inflate(R.layout.translate_dialog, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.translatedialogLinearLayout2)).setVisibility(8);
        ((EditText) inflate.findViewById(R.id.translatedialogEditText3)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.translatedialogEditText1);
        editText.setText(str);
        editText.setFilters(new InputFilter[]{new InputFilter(this) { // from class: ru.maximoff.apktool.SoEditor.26

            /* renamed from: a */
            private final SoEditor f14395a;

            {
                this.f14395a = this;
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                return spanned.subSequence(i4, i5);
            }
        }});
        EditText editText2 = (EditText) inflate.findViewById(R.id.translatedialogEditText2);
        editText2.setText(str2.equals("") ? str : str2);
        editText2.setFilters(new InputFilter[]{new InputFilter(this, str) { // from class: ru.maximoff.apktool.SoEditor.27

            /* renamed from: a */
            private final SoEditor f14396a;

            /* renamed from: b */
            private final String f14397b;

            {
                this.f14396a = this;
                this.f14397b = str;
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                boolean z;
                do {
                    z = new SpannableStringBuilder(spanned).replace(i4, i5, charSequence.subSequence(i2, i3)).toString().getBytes().length > this.f14397b.getBytes().length;
                    if (z) {
                        i3--;
                        charSequence = charSequence.subSequence(i2, i3);
                    }
                } while (z);
                return charSequence;
            }
        }});
        ((CheckBox) inflate.findViewById(R.id.translatedialogCheckBox1)).setVisibility(8);
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14328m).m435b(inflate).m429a(true).m418a(R.string.edit).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText2, str, i) { // from class: ru.maximoff.apktool.SoEditor.28

            /* renamed from: a */
            private final SoEditor f14398a;

            /* renamed from: b */
            private final EditText f14399b;

            /* renamed from: c */
            private final String f14400c;

            /* renamed from: d */
            private final int f14401d;

            {
                this.f14398a = this;
                this.f14399b = editText2;
                this.f14400c = str;
                this.f14401d = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                String editable = this.f14399b.getText().toString();
                if (!this.f14400c.equals(editable)) {
                    this.f14398a.f14325j.set(this.f14401d, editable);
                }
                this.f14398a.f14339x.m16767a(this.f14398a.f14324i, this.f14398a.f14325j, this.f14398a.f14326k);
                dialogInterface.cancel();
            }
        });
        if (!str2.equals("")) {
            m420a.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, i) { // from class: ru.maximoff.apktool.SoEditor.29

                /* renamed from: a */
                private final SoEditor f14402a;

                /* renamed from: b */
                private final int f14403b;

                {
                    this.f14402a = this;
                    this.f14403b = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    this.f14402a.m16725d(this.f14403b);
                    dialogInterface.cancel();
                }
            });
        }
        DialogInterfaceC0070b m438b = m420a.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText2) { // from class: ru.maximoff.apktool.SoEditor.30

            /* renamed from: a */
            private final SoEditor f14405a;

            /* renamed from: b */
            private final EditText f14406b;

            {
                this.f14405a = this;
                this.f14406b = editText2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14406b.requestFocus();
                this.f14406b.selectAll();
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16725d(int i) {
        this.f14325j.set(i, "");
        this.f14339x.m16767a(this.f14324i, this.f14325j, this.f14326k);
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$f */
    private class C2814f extends BaseAdapter {

        /* renamed from: d */
        private Context f14453d;

        /* renamed from: f */
        private final SoEditor f14455f;

        /* renamed from: a */
        public List<String> f14450a = new ArrayList();

        /* renamed from: b */
        public List<String> f14451b = new ArrayList();

        /* renamed from: c */
        public List<Integer> f14452c = new ArrayList();

        /* renamed from: e */
        private int f14454e = 0;

        /* renamed from: b */
        static SoEditor m16766b(C2814f c2814f) {
            return c2814f.f14455f;
        }

        public C2814f(SoEditor soEditor, Context context) {
            this.f14455f = soEditor;
            this.f14453d = context;
        }

        /* renamed from: a */
        public void m16767a(List<String> list, List<String> list2, List<Integer> list3) {
            this.f14450a.clear();
            this.f14450a.addAll(list);
            this.f14451b.clear();
            this.f14451b.addAll(list2);
            this.f14452c.clear();
            this.f14452c.addAll(list3);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f14450a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return i >= this.f14450a.size() ? (Object) null : this.f14450a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i * 17;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            this.f14454e = 0;
            this.f14455f.m16752o();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C2815g c2815g;
            if (view == null) {
                view = ((LayoutInflater) this.f14455f.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.translate_item_old, (ViewGroup) null);
                C2815g c2815g2 = new C2815g(this.f14455f);
                c2815g2.f14470a = i;
                c2815g2.f14473d = (TextView) view.findViewById(R.id.itemValue);
                c2815g2.f14472c = (TextView) view.findViewById(R.id.itemNumber);
                c2815g2.f14471b = (LinearLayout) view.findViewById(R.id.itemNumberWrap);
                c2815g2.f14474e = (TextView) view.findViewById(R.id.itemValueTrans);
                view.setTag(c2815g2);
                c2815g = c2815g2;
            } else {
                c2815g = (C2815g) view.getTag();
            }
            c2815g.f14472c.setTextSize(2, C3102bd.f18332o);
            c2815g.f14473d.setTextSize(2, C3102bd.f18332o);
            c2815g.f14474e.setTextSize(2, C3102bd.f18332o);
            if (this.f14455f.f14340y) {
                c2815g.f14471b.setVisibility(0);
                if (this.f14454e == 0) {
                    this.f14454e = (int) ((c2815g.f14472c.getPaint().measureText(String.valueOf(this.f14450a.size())) + 6) * this.f14453d.getResources().getDisplayMetrics().density * 0.5f);
                }
                c2815g.f14472c.setMinimumWidth(this.f14454e);
                c2815g.f14472c.setText(String.valueOf(i + 1));
            } else {
                c2815g.f14471b.setVisibility(8);
                c2815g.f14472c.setText("0");
            }
            String str = this.f14450a.get(i);
            String str2 = this.f14451b.get(i);
            c2815g.f14473d.setText(str);
            if (!str2.equals("") && str.getBytes().length != str2.getBytes().length) {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, str2.length(), 33);
                c2815g.f14474e.setText(spannableString);
            } else {
                c2815g.f14474e.setText(str2);
            }
            if (this.f14452c.contains(new Integer(i))) {
                view.setBackgroundColor(C3246h.m19470a(this.f14453d, R.color.tvery_light_blue));
            } else if (str2.equals("")) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(C3246h.m19470a(this.f14453d, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
            }
            view.setOnClickListener(new View.OnClickListener(this, i) { // from class: ru.maximoff.apktool.SoEditor.f.1

                /* renamed from: a */
                private final C2814f f14456a;

                /* renamed from: b */
                private final int f14457b;

                {
                    this.f14456a = this;
                    this.f14457b = i;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    C2814f.m16766b(this.f14456a).m16720c(this.f14457b);
                }
            });
            view.setOnLongClickListener(new AnonymousClass2(this, str, str2, i));
            return view;
        }

        /* renamed from: ru.maximoff.apktool.SoEditor$f$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final C2814f f14458a;

            /* renamed from: b */
            private final String f14459b;

            /* renamed from: c */
            private final String f14460c;

            /* renamed from: d */
            private final int f14461d;

            AnonymousClass2(C2814f c2814f, String str, String str2, int i) {
                this.f14458a = c2814f;
                this.f14459b = str;
                this.f14460c = str2;
                this.f14461d = i;
            }

            /* renamed from: a */
            static C2814f m16768a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f14458a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(this.f14458a.f14453d, view);
                if (C3102bd.m18910a(this.f14458a.f14453d, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1700, 0, this.f14458a.f14453d.getString(R.string.copy)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14459b) { // from class: ru.maximoff.apktool.SoEditor.f.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f14462a;

                    /* renamed from: b */
                    private final String f14463b;

                    {
                        this.f14462a = this;
                        this.f14463b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(AnonymousClass2.m16768a(this.f14462a).f14453d, this.f14463b);
                        return true;
                    }
                });
                if (C3112bn.m19030e(this.f14459b)) {
                    c0173ao.m1339a().add(0, 1700, 0, this.f14458a.f14453d.getString(R.string.base64_decode)).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC33622(this, this.f14459b));
                }
                if (!this.f14460c.equals("")) {
                    c0173ao.m1339a().add(0, 1700, 0, this.f14458a.f14453d.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14461d) { // from class: ru.maximoff.apktool.SoEditor.f.2.3

                        /* renamed from: a */
                        private final AnonymousClass2 f14468a;

                        /* renamed from: b */
                        private final int f14469b;

                        {
                            this.f14468a = this;
                            this.f14469b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C2814f.m16766b(AnonymousClass2.m16768a(this.f14468a)).m16725d(this.f14469b);
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
                return true;
            }

            /* renamed from: ru.maximoff.apktool.SoEditor$f$2$2, reason: invalid class name and collision with other inner class name */
            class MenuItemOnMenuItemClickListenerC33622 implements MenuItem.OnMenuItemClickListener {

                /* renamed from: a */
                private final AnonymousClass2 f14464a;

                /* renamed from: b */
                private final String f14465b;

                MenuItemOnMenuItemClickListenerC33622(AnonymousClass2 anonymousClass2, String str) {
                    this.f14464a = anonymousClass2;
                    this.f14465b = str;
                }

                /* renamed from: a */
                static AnonymousClass2 m16769a(MenuItemOnMenuItemClickListenerC33622 menuItemOnMenuItemClickListenerC33622) {
                    return menuItemOnMenuItemClickListenerC33622.f14464a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    String m19519b = C3257q.m19519b(this.f14465b);
                    if (m19519b != null) {
                        new DialogInterfaceC0070b.a(AnonymousClass2.m16768a(this.f14464a).f14453d).m418a(R.string.base64_decode).m436b(m19519b).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.copy, new DialogInterface.OnClickListener(this, m19519b) { // from class: ru.maximoff.apktool.SoEditor.f.2.2.1

                            /* renamed from: a */
                            private final MenuItemOnMenuItemClickListenerC33622 f14466a;

                            /* renamed from: b */
                            private final String f14467b;

                            {
                                this.f14466a = this;
                                this.f14467b = m19519b;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C3112bn.m19002a(AnonymousClass2.m16768a(MenuItemOnMenuItemClickListenerC33622.m16769a(this.f14466a)).f14453d, this.f14467b);
                                dialogInterface.cancel();
                            }
                        }).m438b().show();
                        return true;
                    }
                    C3112bn.m18999a(AnonymousClass2.m16768a(this.f14464a).f14453d, R.string.error);
                    return true;
                }
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$g */
    private class C2815g {

        /* renamed from: a */
        public int f14470a;

        /* renamed from: b */
        public LinearLayout f14471b;

        /* renamed from: c */
        public TextView f14472c;

        /* renamed from: d */
        public TextView f14473d;

        /* renamed from: e */
        public TextView f14474e;

        /* renamed from: f */
        private final SoEditor f14475f;

        public C2815g(SoEditor soEditor) {
            this.f14475f = soEditor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16707a(String str, String str2) {
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
                if (name.equals(this.f14321G)) {
                    FileInputStream fileInputStream = new FileInputStream(this.f14329n);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    if (nextElement.getMethod() == 0) {
                        c2602u.setMethod(0);
                        c2602u.setSize(this.f14329n.length());
                        c2602u.setCompressedSize(this.f14329n.length());
                        c2602u.setCrc(C3117bs.m19055a(this.f14329n));
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

    /* renamed from: ru.maximoff.apktool.SoEditor$d */
    private class AsyncTaskC2812d extends AsyncTask<File, Void, Boolean> {

        /* renamed from: a */
        private Context f14436a;

        /* renamed from: b */
        private boolean f14437b;

        /* renamed from: c */
        private DialogInterfaceC0070b f14438c;

        /* renamed from: d */
        private int f14439d;

        /* renamed from: e */
        private final SoEditor f14440e;

        @Override // android.p008os.AsyncTask
        protected Boolean doInBackground(File[] fileArr) {
            return m16761a(fileArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m16762a(bool);
        }

        public AsyncTaskC2812d(SoEditor soEditor, Context context, int i, boolean z) {
            this.f14440e = soEditor;
            this.f14436a = context;
            this.f14439d = i;
            this.f14437b = z;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14436a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14438c = new DialogInterfaceC0070b.a(this.f14436a).m435b(inflate).m429a(false).m438b();
            this.f14438c.show();
        }

        /* renamed from: a */
        protected Boolean m16761a(File[] fileArr) {
            InterfaceC0008c interfaceC0008c;
            try {
                try {
                    this.f14440e.m16750a(this.f14440e.f14329n.getAbsolutePath());
                    File file = new File(this.f14440e.f14320F);
                    int[] iArr = new int[1];
                    try {
                        iArr[0] = new C3081am(file).m18632h();
                    } catch (Exception e2) {
                        iArr[0] = 14;
                    }
                    if (this.f14439d == 0 && C3102bd.m18925a(this.f14436a, "save_sign_data", true)) {
                        interfaceC0008c = C3105bg.m18964a(file);
                    } else {
                        interfaceC0008c = (InterfaceC0008c) null;
                    }
                    File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                    if (this.f14440e.f14317C) {
                        C3262u.m19612a(file, new File(new StringBuffer().append(this.f14440e.f14320F).append(".bak").toString()));
                    }
                    File createTempFile2 = File.createTempFile("APKTOOL_M", ".unalign", C3102bd.m18908a());
                    this.f14440e.m16707a(file.getAbsolutePath(), createTempFile2.getAbsolutePath());
                    C3317a.m20052a(createTempFile2.getAbsolutePath(), createTempFile.getAbsolutePath());
                    createTempFile2.delete();
                    C2917as.m17314a(this.f14436a, this.f14439d, new C2917as.a(this, createTempFile, file, interfaceC0008c, iArr) { // from class: ru.maximoff.apktool.SoEditor.d.1

                        /* renamed from: a */
                        private final AsyncTaskC2812d f14441a;

                        /* renamed from: b */
                        private final File f14442b;

                        /* renamed from: c */
                        private final File f14443c;

                        /* renamed from: d */
                        private final InterfaceC0008c f14444d;

                        /* renamed from: e */
                        private final int[] f14445e;

                        {
                            this.f14441a = this;
                            this.f14442b = createTempFile;
                            this.f14443c = file;
                            this.f14444d = interfaceC0008c;
                            this.f14445e = iArr;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                C3262u.m19612a(this.f14442b, this.f14443c);
                                if (this.f14444d != null) {
                                    try {
                                        C3105bg.m18967a(this.f14443c, this.f14444d);
                                    } catch (IOException e3) {
                                    }
                                }
                            } else {
                                c2917as.m17320a(this.f14442b, this.f14443c, this.f14445e[0]);
                            }
                            if (this.f14442b.exists()) {
                                this.f14442b.delete();
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
        protected void m16762a(Boolean bool) {
            if (this.f14438c != null && this.f14438c.isShowing()) {
                try {
                    this.f14438c.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                C3112bn.m18999a(this.f14436a, R.string.success);
            } else {
                C3112bn.m18999a(this.f14436a, R.string.error);
            }
            this.f14440e.f14327l = false;
            if (this.f14437b) {
                this.f14440e.finish();
            } else {
                this.f14440e.recreate();
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.SoEditor$c */
    private class AsyncTaskC2811c extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private String f14429a;

        /* renamed from: b */
        private String f14430b;

        /* renamed from: c */
        private boolean f14431c;

        /* renamed from: d */
        private boolean f14432d;

        /* renamed from: e */
        private int f14433e = 0;

        /* renamed from: f */
        private DialogInterfaceC0070b f14434f;

        /* renamed from: g */
        private final SoEditor f14435g;

        @Override // android.p008os.AsyncTask
        protected Void doInBackground(Void[] voidArr) {
            return m16759a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Void r1) {
            m16760a(r1);
        }

        public AsyncTaskC2811c(SoEditor soEditor, String str, String str2, boolean z, boolean z2) {
            this.f14435g = soEditor;
            this.f14429a = str;
            this.f14430b = str2;
            this.f14431c = z;
            this.f14432d = z2;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14435g).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14434f = new DialogInterfaceC0070b.a(this.f14435g).m435b(inflate).m429a(false).m438b();
            this.f14434f.show();
        }

        /* renamed from: a */
        protected Void m16759a(Void[] voidArr) {
            String m18996a;
            for (int i = 0; i < this.f14435g.f14324i.size(); i++) {
                String str = this.f14435g.f14325j.get(i);
                if (str == null || str.equals("")) {
                    str = this.f14435g.f14324i.get(i);
                }
                int length = str.getBytes().length;
                if (this.f14431c) {
                    int i2 = 8;
                    if (!this.f14432d) {
                        i2 = 10;
                    }
                    try {
                        Matcher matcher = Pattern.compile(this.f14429a, i2).matcher(str);
                        StringBuffer stringBuffer = new StringBuffer();
                        int i3 = 0;
                        while (matcher.find()) {
                            matcher.appendReplacement(stringBuffer, this.f14430b);
                            i3++;
                        }
                        if (i3 > 0) {
                            matcher.appendTail(stringBuffer);
                            this.f14435g.f14325j.set(i, C3112bn.m19026c(stringBuffer.toString(), length));
                            this.f14433e = i3 + this.f14433e;
                        }
                    } catch (Exception e2) {
                    }
                } else {
                    if (this.f14432d) {
                        m18996a = str.replace(this.f14429a, this.f14430b);
                    } else {
                        m18996a = C3112bn.m18996a(str, this.f14429a, this.f14430b);
                    }
                    if (!str.equals(m18996a)) {
                        this.f14435g.f14325j.set(i, C3112bn.m19026c(m18996a, length));
                        this.f14433e++;
                    }
                }
            }
            return (Void) null;
        }

        /* renamed from: a */
        protected void m16760a(Void r8) {
            if (this.f14434f != null && this.f14434f.isShowing()) {
                try {
                    this.f14434f.cancel();
                } catch (Exception e2) {
                }
            }
            if (this.f14433e > 0) {
                C3112bn.m19023b(this.f14435g, this.f14435g.getString(R.string.total_repl, new Integer(this.f14433e)));
            } else {
                C3112bn.m18999a(this.f14435g, R.string.not_found);
            }
            this.f14435g.f14339x.m16767a(this.f14435g.f14324i, this.f14435g.f14325j, this.f14435g.f14326k);
        }
    }
}
