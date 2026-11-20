package ru.maximoff.apktool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.text.DateFormat;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.util.C3075ag;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.DiffTextView;

/* loaded from: classes.dex */
public class DiffText extends AbstractActivityC2894b {

    /* renamed from: A */
    private boolean f14000A;

    /* renamed from: B */
    private boolean f14001B;

    /* renamed from: D */
    private int f14003D;

    /* renamed from: h */
    private DiffTextView f14004h;

    /* renamed from: i */
    private List<Integer> f14005i;

    /* renamed from: j */
    private TextView f14006j;

    /* renamed from: k */
    private TextView f14007k;

    /* renamed from: l */
    private TextView f14008l;

    /* renamed from: m */
    private ImageButton f14009m;

    /* renamed from: n */
    private LinearLayout f14010n;

    /* renamed from: o */
    private EditText f14011o;

    /* renamed from: p */
    private CheckBox f14012p;

    /* renamed from: q */
    private CheckBox f14013q;

    /* renamed from: s */
    private boolean f14015s;

    /* renamed from: t */
    private boolean f14016t;

    /* renamed from: u */
    private int f14017u;

    /* renamed from: v */
    private boolean f14018v;

    /* renamed from: w */
    private boolean f14019w;

    /* renamed from: x */
    private boolean f14020x;

    /* renamed from: y */
    private boolean f14021y;

    /* renamed from: z */
    private boolean f14022z;

    /* renamed from: r */
    private long f14014r = 0;

    /* renamed from: C */
    private boolean f14002C = false;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.diff);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("first");
        String stringExtra2 = intent.getStringExtra("second");
        if (stringExtra == null || stringExtra2 == null) {
            C3112bn.m19023b(this, getString(R.string.errorf, getString(R.string.no_data)));
            finish();
            return;
        }
        this.f14005i = new ArrayList();
        this.f14015s = false;
        this.f14016t = false;
        this.f14003D = 0;
        this.f14004h = (DiffTextView) findViewById(R.id.diffTextView1);
        this.f14006j = (TextView) findViewById(R.id.diffTextView2);
        this.f14007k = (TextView) findViewById(R.id.diffTextView3);
        this.f14008l = (TextView) findViewById(R.id.diffTextView4);
        this.f14009m = (ImageButton) findViewById(R.id.diffImageButton1);
        ImageView imageView = (ImageView) findViewById(R.id.clearText1);
        if (C3102bd.f18291a) {
            int m19470a = C3246h.m19470a(this, R.color.accent_material_light);
            imageView.setImageResource(R.drawable.ic_close);
            i = m19470a;
        } else {
            int m19470a2 = C3246h.m19470a(this, R.color.accent_material);
            imageView.setImageResource(R.drawable.ic_close_dark);
            i = m19470a2;
        }
        this.f14010n = (LinearLayout) findViewById(R.id.diffLinearLayout1);
        this.f14011o = (EditText) findViewById(R.id.diffEditText1);
        this.f14012p = (CheckBox) findViewById(R.id.diffCheckBox1);
        this.f14012p.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.DiffText.1

            /* renamed from: a */
            private final DiffText f14023a;

            {
                this.f14023a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14023a.f14015s = this.f14023a.f14012p.isChecked();
            }
        });
        this.f14013q = (CheckBox) findViewById(R.id.diffCheckBox2);
        this.f14013q.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.DiffText.2

            /* renamed from: a */
            private final DiffText f14036a;

            {
                this.f14036a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14036a.f14016t = this.f14036a.f14013q.isChecked();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.DiffText.3

            /* renamed from: a */
            private final DiffText f14037a;

            {
                this.f14037a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14037a.f14011o.requestFocus();
                this.f14037a.f14011o.setText("");
            }
        });
        if (this.f14011o.getText().length() == 0) {
            imageView.setVisibility(8);
        }
        C3112bn.m19006a(this.f14011o, 10000);
        this.f14011o.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.DiffText.4

            /* renamed from: a */
            private final DiffText f14038a;

            /* renamed from: b */
            private final ImageView f14039b;

            {
                this.f14038a = this;
                this.f14039b = imageView;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f14039b.setVisibility(8);
                } else {
                    this.f14039b.setVisibility(0);
                }
                this.f14038a.f14011o.requestFocus();
            }
        });
        C3212b c3212b = new C3212b(this, "diff_text");
        ImageView imageView2 = (ImageView) findViewById(R.id.diffImageView1);
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
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.DiffText.5

            /* renamed from: a */
            private final DiffText f14040a;

            /* renamed from: b */
            private final C3212b f14041b;

            /* renamed from: c */
            private final ImageView f14042c;

            {
                this.f14040a = this;
                this.f14041b = c3212b;
                this.f14042c = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14041b.m19201a(this.f14042c, this.f14040a.f14011o);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.DiffText.6

            /* renamed from: a */
            private final DiffText f14043a;

            /* renamed from: b */
            private final C3212b f14044b;

            /* renamed from: c */
            private final ImageView f14045c;

            {
                this.f14043a = this;
                this.f14044b = c3212b;
                this.f14045c = imageView2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f14043a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f14044b, this.f14045c) { // from class: ru.maximoff.apktool.DiffText.6.1

                    /* renamed from: a */
                    private final ViewOnLongClickListenerC27216 f14046a;

                    /* renamed from: b */
                    private final C3212b f14047b;

                    /* renamed from: c */
                    private final ImageView f14048c;

                    {
                        this.f14046a = this;
                        this.f14047b = r2;
                        this.f14048c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14047b.m19208d();
                        this.f14048c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        this.f14011o.setImeOptions(3);
        this.f14011o.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.DiffText.7

            /* renamed from: a */
            private final DiffText f14049a;

            /* renamed from: b */
            private final C3212b f14050b;

            /* renamed from: c */
            private final ImageView f14051c;

            {
                this.f14049a = this;
                this.f14050b = c3212b;
                this.f14051c = imageView2;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 3) {
                    return false;
                }
                this.f14049a.m16550a(this.f14049a.f14011o.getText().toString());
                if (this.f14050b.m19204a(this.f14049a.f14011o.getText().toString())) {
                    this.f14051c.setVisibility(0);
                }
                return true;
            }
        });
        this.f14017u = -1;
        this.f14019w = false;
        this.f14018v = false;
        this.f14020x = C3102bd.m18925a((Context) this, "compare_mono", true);
        this.f14021y = C3102bd.m18925a((Context) this, "compare_line_nums", true);
        this.f14022z = C3102bd.m18925a((Context) this, "compare_ign_ind", false);
        this.f14000A = C3102bd.m18925a((Context) this, "compare_wrap", false);
        this.f14001B = C3102bd.m18925a((Context) this, "compare_only_diff", false);
        this.f14006j.setTextSize(2, C3102bd.f18332o);
        this.f14007k.setTextSize(2, C3102bd.f18332o);
        this.f14008l.setTextSize(2, C3102bd.m18927b());
        File file = new File(stringExtra);
        File file2 = new File(stringExtra2);
        SpannableString spannableString = new SpannableString(file.getName());
        spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this, R.color.dark_green)), 0, file.getName().length(), 33);
        this.f14006j.setText(spannableString);
        this.f14006j.setTag(file.getAbsolutePath());
        SpannableString spannableString2 = new SpannableString(file2.getName());
        spannableString2.setSpan(new ForegroundColorSpan(C3246h.m19470a(this, R.color.dark_red)), 0, file2.getName().length(), 33);
        this.f14007k.setText(spannableString2);
        this.f14007k.setTag(file2.getAbsolutePath());
        if (C3102bd.f18291a) {
            this.f14009m.setImageResource(R.drawable.ic_sync);
        } else {
            this.f14009m.setImageResource(R.drawable.ic_sync_dark);
        }
        this.f14009m.setOnClickListener(new View.OnClickListener(this, file, file2) { // from class: ru.maximoff.apktool.DiffText.8

            /* renamed from: a */
            private final DiffText f14052a;

            /* renamed from: b */
            private final File f14053b;

            /* renamed from: c */
            private final File f14054c;

            {
                this.f14052a = this;
                this.f14053b = file;
                this.f14054c = file2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                File[] fileArr;
                String name;
                String name2;
                if (this.f14052a.f14019w) {
                    fileArr = new File[]{this.f14053b, this.f14054c};
                    name = this.f14053b.getName();
                    name2 = this.f14054c.getName();
                } else {
                    fileArr = new File[]{this.f14054c, this.f14053b};
                    name = this.f14054c.getName();
                    name2 = this.f14053b.getName();
                }
                SpannableString spannableString3 = new SpannableString(name);
                spannableString3.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f14052a, R.color.dark_green)), 0, name.length(), 33);
                this.f14052a.f14006j.setText(spannableString3);
                this.f14052a.f14006j.setTag(fileArr[0].getAbsolutePath());
                SpannableString spannableString4 = new SpannableString(name2);
                spannableString4.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f14052a, R.color.dark_red)), 0, name2.length(), 33);
                this.f14052a.f14007k.setText(spannableString4);
                this.f14052a.f14007k.setTag(fileArr[1].getAbsolutePath());
                this.f14052a.f14019w = !this.f14052a.f14019w;
                this.f14052a.f14004h.m19733e();
                this.f14052a.f14004h.setText(R.string.mplease_wait);
                this.f14052a.m16557a(fileArr);
            }
        });
        this.f14009m.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.DiffText.9

            /* renamed from: a */
            private final DiffText f14055a;

            {
                this.f14055a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f14055a.recreate();
                return true;
            }
        });
        ViewOnClickListenerC271110 viewOnClickListenerC271110 = new ViewOnClickListenerC271110(this, stringExtra2, stringExtra);
        this.f14006j.setOnClickListener(viewOnClickListenerC271110);
        this.f14007k.setOnClickListener(viewOnClickListenerC271110);
        if (this.f14020x) {
            this.f14004h.setTypeface(C3102bd.f18328k);
        } else {
            this.f14004h.setTypeface(Typeface.DEFAULT);
        }
        this.f14004h.setTextSize(2, C3102bd.f18329l);
        this.f14004h.m19728a(this.f14021y);
        this.f14004h.setSelectionMode(this.f14002C);
        this.f14004h.setSelectionColor(i);
        this.f14004h.setBorderSize(C3080al.m18574b(this, 4));
        this.f14004h.setText(R.string.mplease_wait);
        this.f14004h.setWrapTextEnabled(this.f14000A);
        m16564c(0);
        m16557a(file, file2);
    }

    /* renamed from: ru.maximoff.apktool.DiffText$10 */
    class ViewOnClickListenerC271110 implements View.OnClickListener {

        /* renamed from: a */
        private final DiffText f14024a;

        /* renamed from: b */
        private final String f14025b;

        /* renamed from: c */
        private final String f14026c;

        ViewOnClickListenerC271110(DiffText diffText, String str, String str2) {
            this.f14024a = diffText;
            this.f14025b = str;
            this.f14026c = str2;
        }

        /* renamed from: a */
        static DiffText m16576a(ViewOnClickListenerC271110 viewOnClickListenerC271110) {
            return viewOnClickListenerC271110.f14024a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            switch (view.getId()) {
                case R.id.diffTextView2 /* 2131689736 */:
                    if (this.f14024a.f14019w) {
                        str3 = this.f14025b;
                    } else {
                        str3 = this.f14026c;
                    }
                    str2 = str3;
                    break;
                case R.id.diffImageButton1 /* 2131689737 */:
                case R.id.diffTextView4 /* 2131689738 */:
                default:
                    return;
                case R.id.diffTextView3 /* 2131689739 */:
                    if (this.f14024a.f14019w) {
                        str = this.f14026c;
                    } else {
                        str = this.f14025b;
                    }
                    str2 = str;
                    break;
            }
            new DialogInterfaceC0070b.a(this.f14024a).m418a(R.string.path_app).m436b(str2).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.copy, new DialogInterface.OnClickListener(this, str2) { // from class: ru.maximoff.apktool.DiffText.10.1

                /* renamed from: a */
                private final ViewOnClickListenerC271110 f14027a;

                /* renamed from: b */
                private final String f14028b;

                {
                    this.f14027a = this;
                    this.f14028b = str2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C3112bn.m19002a(ViewOnClickListenerC271110.m16576a(this.f14027a), this.f14028b);
                    dialogInterface.cancel();
                }
            }).m438b().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16557a(File... fileArr) {
        C3075ag c3075ag = new C3075ag(this.f14022z);
        View inflate = getLayoutInflater().inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mprepare);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m435b(inflate).m429a(false).m438b();
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this, c3075ag) { // from class: ru.maximoff.apktool.DiffText.11

            /* renamed from: a */
            private final DiffText f14029a;

            /* renamed from: b */
            private final C3075ag f14030b;

            {
                this.f14029a = this;
                this.f14030b = c3075ag;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f14029a.f14014r > 2000) {
                    C3112bn.m18999a(this.f14029a, R.string.click_once_more2);
                    this.f14029a.f14014r = currentTimeMillis;
                    return false;
                }
                this.f14030b.m18475a();
                this.f14029a.f14014r = 0L;
                this.f14029a.f14004h.setText(R.string.cancel);
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.show();
        c3075ag.m18476a(fileArr[0], fileArr[1], new C3075ag.c(this, m438b) { // from class: ru.maximoff.apktool.DiffText.12

            /* renamed from: a */
            private final DiffText f14031a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14032b;

            {
                this.f14031a = this;
                this.f14032b = m438b;
            }

            @Override // ru.maximoff.apktool.util.C3075ag.c
            /* renamed from: a */
            public void mo16577a(List<C3075ag.b> list, int i, int i2, boolean z) {
                if (this.f14032b != null && this.f14032b.isShowing()) {
                    try {
                        this.f14032b.cancel();
                    } catch (Exception e2) {
                    }
                }
                if (z) {
                    return;
                }
                this.f14031a.f14004h.setFirstMaxNum(i);
                this.f14031a.f14004h.setSecondMaxNum(i2);
                new AsyncTaskC2726b(this.f14031a, this.f14031a, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        });
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14004h.setWrapTextEnabled(this.f14000A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16564c(int i) {
        this.f14017u = -1;
        for (int i2 = 0; i2 < this.f14005i.size() && i >= this.f14005i.get(i2).intValue(); i2++) {
            this.f14017u = i2;
        }
        this.f14008l.setText(String.format("[%d/%d]", new Integer(this.f14017u + 1), new Integer(this.f14005i.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16550a(String str) {
        if (str.isEmpty()) {
            this.f14004h.m19729a(0, 0);
            return;
        }
        if (this.f14015s) {
            try {
                m16560b(str);
                return;
            } catch (Exception e2) {
            }
        }
        String charSequence = this.f14004h.getText().toString();
        if (!this.f14016t) {
            charSequence = charSequence.toLowerCase();
            str = str.toLowerCase();
        }
        if (this.f14003D >= charSequence.length()) {
            this.f14003D = 0;
        }
        int indexOf = charSequence.indexOf(str, this.f14003D);
        if (indexOf >= 0) {
            this.f14003D = str.length() + indexOf;
            int[] m19729a = this.f14004h.m19729a(indexOf, this.f14003D);
            if (m19729a[0] >= 0 && m19729a[1] >= 0) {
                this.f14004h.scrollTo(m19729a[1], m19729a[0]);
                return;
            }
            return;
        }
        if (this.f14003D == 0) {
            this.f14004h.m19729a(0, 0);
            C3112bn.m18999a(this, R.string.not_found);
        } else {
            this.f14003D = 0;
            m16550a(str);
        }
    }

    /* renamed from: b */
    private void m16560b(String str) {
        if (str.isEmpty()) {
            this.f14004h.m19729a(0, 0);
            return;
        }
        String charSequence = this.f14004h.getText().toString();
        if (this.f14003D >= charSequence.length()) {
            this.f14003D = 0;
        }
        int[] m16558a = m16558a(charSequence, str);
        if (m16558a[0] >= 0) {
            this.f14003D = m16558a[1];
            int[] m19729a = this.f14004h.m19729a(m16558a[0], m16558a[1]);
            if (m19729a[0] >= 0 && m19729a[1] >= 0) {
                this.f14004h.scrollTo(m19729a[1], m19729a[0]);
                return;
            }
            return;
        }
        if (this.f14003D == 0) {
            this.f14004h.m19729a(0, 0);
            C3112bn.m18999a(this, R.string.not_found);
        } else {
            this.f14003D = 0;
            m16560b(str);
        }
    }

    /* renamed from: a */
    private int[] m16558a(String str, String str2) {
        int i = 8;
        if (!this.f14016t) {
            i = 10;
        }
        Matcher matcher = Pattern.compile(str2, i).matcher(str);
        int[] iArr = {-1, -1};
        while (matcher.find()) {
            if (matcher.start() >= this.f14003D) {
                return new int[]{matcher.start(), matcher.end()};
            }
        }
        return iArr;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.diff, menu);
        if (C3102bd.f18291a) {
            menu.findItem(R.id.previous).setIcon(R.drawable.ic_up);
            menu.findItem(R.id.next).setIcon(R.drawable.ic_down);
        } else {
            menu.findItem(R.id.previous).setIcon(R.drawable.ic_up_dark);
            menu.findItem(R.id.next).setIcon(R.drawable.ic_down_dark);
        }
        menu.findItem(R.id.previous).setVisible(this.f14018v);
        menu.findItem(R.id.next).setVisible(this.f14018v);
        menu.findItem(R.id.monospace).setChecked(this.f14020x);
        menu.findItem(R.id.line_nums).setChecked(this.f14021y);
        menu.findItem(R.id.ignore_indent).setChecked(this.f14022z);
        menu.findItem(R.id.wordwrap).setChecked(this.f14000A);
        menu.findItem(R.id.only_diff).setChecked(this.f14001B);
        menu.findItem(R.id.select_mode).setChecked(this.f14002C);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.save /* 2131690189 */:
                File m16563c = m16563c(new StringBuffer().append(new StringBuffer().append(C3112bn.m19033h(getString(R.string.compare_text))).append("_").toString()).append(C3112bn.m19032g("yyyyMMddHHmmss")).toString());
                if (m16563c != null) {
                    try {
                        C3061a.m18319b(m16563c, this.f14006j.getTag() + "\n" + this.f14007k.getTag() + "\n\n" + this.f14004h.toString());
                        C3112bn.m19000a(this, R.string.successf, m16563c.getAbsolutePath());
                        break;
                    } catch (Error | Exception e2) {
                        C3112bn.m19000a(this, R.string.errorf, e2.getMessage());
                        break;
                    }
                }
                break;
            case R.id.search /* 2131690191 */:
                if (this.f14010n.getVisibility() == 8) {
                    this.f14010n.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.DiffText.15

                        /* renamed from: a */
                        private final DiffText f14035a;

                        {
                            this.f14035a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f14035a.f14011o.requestFocus();
                            ((InputMethodManager) this.f14035a.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f14035a.f14011o, 1);
                            this.f14035a.f14011o.selectAll();
                        }
                    }, 100L);
                    break;
                } else {
                    this.f14010n.setVisibility(8);
                    this.f14004h.m19729a(0, 0);
                    break;
                }
            case R.id.exit /* 2131690197 */:
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAndRemoveTask();
                    break;
                } else {
                    finish();
                    break;
                }
            case R.id.previous /* 2131690211 */:
                this.f14017u--;
                if (this.f14017u < 0) {
                    this.f14017u = this.f14005i.size() - 1;
                }
                this.f14004h.scrollTo(0, Math.min(this.f14004h.m19731c(), this.f14005i.get(this.f14017u).intValue()));
                this.f14004h.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.DiffText.13

                    /* renamed from: a */
                    private final DiffText f14033a;

                    {
                        this.f14033a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14033a.f14008l.setText(String.format("[%d/%d]", new Integer(this.f14033a.f14017u + 1), new Integer(this.f14033a.f14005i.size())));
                    }
                }, 100L);
                break;
            case R.id.next /* 2131690212 */:
                this.f14017u++;
                if (this.f14017u >= this.f14005i.size()) {
                    this.f14017u = 0;
                }
                this.f14004h.scrollTo(0, Math.min(this.f14004h.m19731c(), this.f14005i.get(this.f14017u).intValue()));
                this.f14004h.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.DiffText.14

                    /* renamed from: a */
                    private final DiffText f14034a;

                    {
                        this.f14034a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14034a.f14008l.setText(String.format("[%d/%d]", new Integer(this.f14034a.f14017u + 1), new Integer(this.f14034a.f14005i.size())));
                    }
                }, 100L);
                break;
            case R.id.wordwrap /* 2131690213 */:
                this.f14000A = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "compare_wrap", this.f14000A);
                this.f14004h.setWrapTextEnabled(this.f14000A);
                invalidateOptionsMenu();
                break;
            case R.id.monospace /* 2131690214 */:
                this.f14020x = !menuItem.isChecked();
                C3102bd.m18938b(this, "compare_mono", this.f14020x);
                if (this.f14020x) {
                    this.f14004h.setTypeface(C3102bd.f18328k);
                } else {
                    this.f14004h.setTypeface(Typeface.DEFAULT);
                }
                this.f14004h.m19725a();
                invalidateOptionsMenu();
                break;
            case R.id.line_nums /* 2131690215 */:
                this.f14021y = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "compare_line_nums", this.f14021y);
                this.f14004h.m19728a(this.f14021y);
                this.f14004h.m19725a();
                invalidateOptionsMenu();
                break;
            case R.id.ignore_indent /* 2131690216 */:
                this.f14022z = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "compare_ign_ind", this.f14022z);
                recreate();
                break;
            case R.id.only_diff /* 2131690217 */:
                this.f14001B = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "compare_only_diff", this.f14001B);
                recreate();
                break;
            case R.id.select_mode /* 2131690218 */:
                this.f14002C = menuItem.isChecked() ? false : true;
                this.f14004h.setSelectionMode(this.f14002C);
                invalidateOptionsMenu();
                break;
        }
        return true;
    }

    /* renamed from: c */
    private File m16563c(String str) {
        String str2 = C3102bd.f18339v;
        if (str2 == null) {
            C3112bn.m18999a(this, R.string.output_directory_not_set);
            return (File) null;
        }
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            C3112bn.m19000a(this, R.string.output_directory_not_extsts, str2);
            return (File) null;
        }
        if (!file.isDirectory()) {
            C3112bn.m19000a(this, R.string.not_directory, str2);
            return (File) null;
        }
        return new File(str2, C3262u.m19566a(this, str2, str, ".txt", 0));
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (this.f14010n.getVisibility() == 0) {
            this.f14010n.setVisibility(8);
            this.f14004h.m19729a(0, 0);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f14014r > 2000) {
            C3112bn.m18999a(this, R.string.click_once_more2);
            this.f14014r = currentTimeMillis;
        } else if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, android.app.Activity
    public void recreate() {
        Intent intent = getIntent();
        intent.putExtra("first", (String) this.f14006j.getTag());
        intent.putExtra("second", (String) this.f14007k.getTag());
        finish();
        startActivity(intent);
    }

    /* renamed from: ru.maximoff.apktool.DiffText$a */
    private class C2725a {

        /* renamed from: a */
        public final String f14056a;

        /* renamed from: b */
        public final String f14057b;

        /* renamed from: c */
        public final String f14058c;

        /* renamed from: d */
        private final DiffText f14059d;

        public C2725a(DiffText diffText, String str, String str2, String str3) {
            this.f14059d = diffText;
            this.f14056a = str;
            this.f14057b = str2;
            this.f14058c = str3;
        }
    }

    /* renamed from: ru.maximoff.apktool.DiffText$b */
    private class AsyncTaskC2726b extends AsyncTask<Void, C2725a, Boolean> {

        /* renamed from: a */
        private final Context f14060a;

        /* renamed from: b */
        private final List<C3075ag.b> f14061b;

        /* renamed from: c */
        private DialogInterfaceC0070b f14062c;

        /* renamed from: d */
        private int f14063d;

        /* renamed from: e */
        private int f14064e;

        /* renamed from: f */
        private int f14065f;

        /* renamed from: g */
        private int f14066g;

        /* renamed from: i */
        private String f14068i;

        /* renamed from: l */
        private final DiffText f14071l;

        /* renamed from: h */
        private long f14067h = 0;

        /* renamed from: j */
        private boolean f14069j = false;

        /* renamed from: k */
        private final StringBuilder f14070k = new StringBuilder();

        /* renamed from: c */
        static DiffText m16583c(AsyncTaskC2726b asyncTaskC2726b) {
            return asyncTaskC2726b.f14071l;
        }

        @Override // android.p008os.AsyncTask
        protected Boolean doInBackground(Void[] voidArr) {
            return m16584a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m16585a(bool);
        }

        @Override // android.p008os.AsyncTask
        protected void onProgressUpdate(C2725a[] c2725aArr) {
            m16586a(c2725aArr);
        }

        public AsyncTaskC2726b(DiffText diffText, Context context, List<C3075ag.b> list) {
            this.f14071l = diffText;
            this.f14060a = context;
            this.f14061b = list;
            this.f14063d = C3246h.m19470a(context, R.color.dark_green);
            this.f14064e = C3246h.m19470a(context, R.color.dark_red);
            this.f14065f = C3246h.m19469a(this.f14063d, 70);
            this.f14066g = C3246h.m19469a(this.f14064e, 70);
            this.f14071l.f14004h.setFirstColor(this.f14063d);
            this.f14071l.f14004h.setSecondColor(this.f14064e);
            this.f14071l.f14004h.setFirstLnColor(this.f14065f);
            this.f14071l.f14004h.setSecondLnColor(this.f14066g);
            this.f14071l.f14004h.setDividerColor(Color.LTGRAY);
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f14060a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f14062c = new DialogInterfaceC0070b.a(this.f14060a).m435b(inflate).m429a(false).m438b();
            this.f14062c.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.DiffText.b.1

                /* renamed from: a */
                private final AsyncTaskC2726b f14072a;

                {
                    this.f14072a = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f14072a.f14067h > 2000) {
                        C3112bn.m18999a(AsyncTaskC2726b.m16583c(this.f14072a), R.string.click_once_more2);
                        this.f14072a.f14067h = currentTimeMillis;
                        return false;
                    }
                    this.f14072a.f14068i = AsyncTaskC2726b.m16583c(this.f14072a).getString(R.string.cancel);
                    this.f14072a.f14069j = true;
                    this.f14072a.cancel(true);
                    dialogInterface.cancel();
                    return true;
                }
            });
            this.f14062c.show();
            this.f14071l.f14004h.setText("");
        }

        /* renamed from: a */
        protected Boolean m16584a(Void[] voidArr) {
            boolean z;
            int i = 0;
            String str = "";
            boolean z2 = false;
            boolean z3 = true;
            while (i < this.f14061b.size() && !this.f14069j) {
                try {
                    if (i > 0) {
                        str = "\n";
                    }
                    C3075ag.b bVar = this.f14061b.get(i);
                    if (bVar.f17627c != null && bVar.f17628d != null) {
                        if (this.f14071l.f14001B) {
                            if (!z2) {
                                publishProgress(new C2725a(this.f14071l, new StringBuffer().append(DateFormat.ABBR_SPECIFIC_TZ).append(i).toString(), "...", new StringBuffer().append(str).append("...").toString()));
                                z = true;
                            }
                        } else {
                            publishProgress(new C2725a(this.f14071l, new StringBuffer().append(bVar.f17625a).append("").toString(), new StringBuffer().append(bVar.f17626b).append("").toString(), new StringBuffer().append(str).append(bVar.f17627c).toString()));
                        }
                        z = z2;
                    } else if (bVar.f17627c != null) {
                        publishProgress(new C2725a(this.f14071l, new StringBuffer().append(bVar.f17625a).append("").toString(), "", new StringBuffer().append(str).append(bVar.f17627c).toString()));
                        z = false;
                        z3 = false;
                    } else {
                        if (bVar.f17628d != null) {
                            publishProgress(new C2725a(this.f14071l, new StringBuffer().append("x").append(i).toString(), new StringBuffer().append(bVar.f17626b).append("").toString(), new StringBuffer().append(str).append(bVar.f17628d).toString()));
                            z = false;
                            z3 = false;
                        }
                        z = z2;
                    }
                    i++;
                    z2 = z;
                } catch (Error | Exception e2) {
                    this.f14068i = this.f14071l.getString(R.string.errorf, e2.toString());
                    return new Boolean(false);
                }
            }
            publishProgress((C2725a) null);
            if (this.f14069j) {
                this.f14068i = this.f14071l.getString(R.string.cancel);
                return new Boolean(false);
            }
            if (z3) {
                this.f14068i = this.f14071l.getString(R.string.files_identical);
                return new Boolean(false);
            }
            return new Boolean(true);
        }

        /* renamed from: a */
        protected void m16586a(C2725a... c2725aArr) {
            this.f14071l.runOnUiThread(new Runnable(this, c2725aArr) { // from class: ru.maximoff.apktool.DiffText.b.2

                /* renamed from: a */
                private final AsyncTaskC2726b f14073a;

                /* renamed from: b */
                private final C2725a[] f14074b;

                {
                    this.f14073a = this;
                    this.f14074b = c2725aArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f14074b[0] == null) {
                        if (this.f14073a.f14070k.length() > 0) {
                            AsyncTaskC2726b.m16583c(this.f14073a).f14004h.append(this.f14073a.f14070k);
                            this.f14073a.f14070k.setLength(0);
                            this.f14073a.f14070k.trimToSize();
                            return;
                        }
                        return;
                    }
                    this.f14073a.f14070k.append(this.f14074b[0].f14058c);
                    AsyncTaskC2726b.m16583c(this.f14073a).f14004h.m19727a(this.f14074b[0].f14056a, this.f14074b[0].f14057b);
                    if (this.f14073a.f14070k.length() >= 10000) {
                        AsyncTaskC2726b.m16583c(this.f14073a).f14004h.append(this.f14073a.f14070k);
                        this.f14073a.f14070k.setLength(0);
                        this.f14073a.f14070k.trimToSize();
                    }
                }
            });
        }

        @Override // android.p008os.AsyncTask
        protected void onCancelled() {
            this.f14071l.f14004h.m19733e();
            this.f14071l.f14004h.setText(this.f14068i);
        }

        /* renamed from: a */
        protected void m16585a(Boolean bool) {
            if (bool.booleanValue()) {
                this.f14071l.f14004h.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener(this) { // from class: ru.maximoff.apktool.DiffText.b.3

                    /* renamed from: a */
                    private final AsyncTaskC2726b f14075a;

                    {
                        this.f14075a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public void onScrollChanged() {
                        AsyncTaskC2726b.m16583c(this.f14075a).m16564c(AsyncTaskC2726b.m16583c(this.f14075a).f14004h.getScrollY());
                    }
                });
                this.f14071l.f14004h.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.DiffText.b.4

                    /* renamed from: a */
                    private final AsyncTaskC2726b f14076a;

                    {
                        this.f14076a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncTaskC2726b.m16583c(this.f14076a).f14005i = AsyncTaskC2726b.m16583c(this.f14076a).f14004h.m19734f();
                        AsyncTaskC2726b.m16583c(this.f14076a).f14018v = AsyncTaskC2726b.m16583c(this.f14076a).f14004h.m19735g();
                        AsyncTaskC2726b.m16583c(this.f14076a).f14004h.scrollTo(0, 0);
                        AsyncTaskC2726b.m16583c(this.f14076a).m16564c(0);
                        AsyncTaskC2726b.m16583c(this.f14076a).invalidateOptionsMenu();
                    }
                }, 300L);
            } else {
                this.f14071l.f14004h.m19733e();
                this.f14071l.f14004h.setText(this.f14068i);
            }
            if (this.f14062c == null || !this.f14062c.isShowing()) {
                return;
            }
            try {
                this.f14062c.cancel();
            } catch (Exception e2) {
            }
        }
    }
}
