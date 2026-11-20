package ru.maximoff.apktool.util.p306d;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaCodec;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.EnumC2989h;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3086ar;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3215e;

/* compiled from: Search.java */
/* renamed from: ru.maximoff.apktool.util.d.a */
/* loaded from: classes.dex */
public class C3211a {

    /* renamed from: A */
    private boolean f18928A;

    /* renamed from: J */
    private String[] f18937J;

    /* renamed from: a */
    private Context f18938a;

    /* renamed from: b */
    private InterfaceC2995n f18939b;

    /* renamed from: d */
    private RadioButton f18941d;

    /* renamed from: e */
    private RadioButton f18942e;

    /* renamed from: f */
    private CheckBox f18943f;

    /* renamed from: g */
    private CheckBox f18944g;

    /* renamed from: h */
    private CheckBox f18945h;

    /* renamed from: i */
    private CheckBox f18946i;

    /* renamed from: j */
    private CheckBox f18947j;

    /* renamed from: k */
    private CheckBox f18948k;

    /* renamed from: l */
    private LayoutInflater f18949l;

    /* renamed from: n */
    private C3212b f18951n;

    /* renamed from: o */
    private C3212b f18952o;

    /* renamed from: q */
    private File f18954q;

    /* renamed from: s */
    private String f18956s;

    /* renamed from: t */
    private String f18957t;

    /* renamed from: u */
    private String f18958u;

    /* renamed from: v */
    private boolean f18959v;

    /* renamed from: w */
    private boolean f18960w;

    /* renamed from: x */
    private boolean f18961x;

    /* renamed from: y */
    private boolean f18962y;

    /* renamed from: z */
    private boolean f18963z;

    /* renamed from: E */
    private int f18932E = 0;

    /* renamed from: F */
    private long f18933F = 0;

    /* renamed from: G */
    private long f18934G = 0;

    /* renamed from: H */
    private long f18935H = 0;

    /* renamed from: I */
    private String f18936I = (String) null;

    /* renamed from: m */
    private boolean f18950m = false;

    /* renamed from: p */
    private int f18953p = 0;

    /* renamed from: B */
    private boolean f18929B = false;

    /* renamed from: C */
    private boolean f18930C = false;

    /* renamed from: D */
    private boolean f18931D = false;

    /* renamed from: c */
    private List<C3213c> f18940c = new ArrayList();

    /* renamed from: r */
    private String f18955r = "UTF-8";

    public C3211a(Context context, InterfaceC2995n interfaceC2995n) {
        this.f18938a = context;
        this.f18939b = interfaceC2995n;
        this.f18937J = C3262u.m19640b(this.f18938a);
        this.f18949l = LayoutInflater.from(this.f18938a);
        this.f18951n = new C3212b(this.f18938a);
        this.f18952o = new C3212b(this.f18938a, "global_replace");
    }

    /* renamed from: a */
    public void m19174a(String str, String str2, String str3) {
        if (C3112bn.m19040o(str2)) {
            C3112bn.m18999a(this.f18938a, R.string.error);
            return;
        }
        this.f18954q = new File(str2);
        this.f18932E = str2.length() + 1;
        this.f18957t = "";
        this.f18956s = str;
        this.f18959v = str3 != null;
        this.f18960w = false;
        this.f18961x = false;
        this.f18962y = true;
        this.f18963z = false;
        this.f18928A = false;
        this.f18929B = true;
        this.f18936I = (String) null;
        this.f18934G = System.currentTimeMillis();
        b bVar = new b(this);
        bVar.m19193a(str3);
        try {
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str2);
        } catch (Exception e2) {
            C3112bn.m18999a(this.f18938a, R.string.error_try_again);
        }
    }

    /* renamed from: a */
    public void m19173a(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (C3112bn.m19040o(str)) {
            C3112bn.m18999a(this.f18938a, R.string.error);
            return;
        }
        this.f18954q = new File(str);
        this.f18932E = str.length() + 1;
        if (C3102bd.f18291a) {
            i = R.drawable.ic_close;
            i2 = R.drawable.ic_from_uni;
            i3 = R.drawable.ic_to_uni;
            i4 = R.drawable.ic_paste_light;
            i5 = R.drawable.ic_collapse;
        } else {
            i = R.drawable.ic_close_dark;
            i2 = R.drawable.ic_from_uni_dark;
            i3 = R.drawable.ic_to_uni_dark;
            i4 = R.drawable.ic_paste_dark;
            i5 = R.drawable.ic_collapse_dark;
        }
        View inflate = this.f18949l.inflate(R.layout.search, (ViewGroup) null);
        Button[] buttonArr = new Button[3];
        EditText editText = (EditText) inflate.findViewById(R.id.searchEditText1);
        C3112bn.m19006a(editText, 10000);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.searchImageView1);
        imageView.setImageResource(i5);
        List<String> m19205b = this.f18951n.m19205b();
        if (m19205b.isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            editText.setText(m19205b.get(m19205b.size() - 1));
        }
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.searchButton1);
        imageButton.setImageResource(i4);
        imageButton.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.util.d.a.1

            /* renamed from: a */
            private final C3211a f18964a;

            /* renamed from: b */
            private final EditText f18965b;

            {
                this.f18964a = this;
                this.f18965b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f18964a.f18938a);
                if (m18991a != null) {
                    C3112bn.m19007a(this.f18965b, (CharSequence) m18991a);
                } else {
                    C3112bn.m18999a(this.f18964a.f18938a, R.string.empty);
                }
            }
        });
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.searchButton2);
        ImageButton imageButton3 = (ImageButton) inflate.findViewById(R.id.searchButton3);
        imageButton2.setImageResource(i3);
        imageButton3.setImageResource(i2);
        imageButton2.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.util.d.a.2

            /* renamed from: a */
            private final C3211a f19012a;

            /* renamed from: b */
            private final EditText f19013b;

            {
                this.f19012a = this;
                this.f19013b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f19013b.setText(C3112bn.m19039n(this.f19013b.getText().toString()));
                    this.f19013b.requestFocus();
                    this.f19013b.selectAll();
                } catch (Exception e2) {
                }
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.util.d.a.3

            /* renamed from: a */
            private final C3211a f19071a;

            /* renamed from: b */
            private final EditText f19072b;

            {
                this.f19071a = this;
                this.f19072b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f19072b.setText(C3112bn.m19038m(this.f19072b.getText().toString()));
                    this.f19072b.requestFocus();
                    this.f19072b.selectAll();
                } catch (Exception e2) {
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.searchLinearLayout1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.searchEditText2);
        C3112bn.m19006a(editText2, 10000);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.searchImageView2);
        imageView2.setImageResource(i5);
        List<String> m19205b2 = this.f18952o.m19205b();
        if (m19205b2.isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            editText2.setText(m19205b2.get(m19205b2.size() - 1));
        }
        ImageButton imageButton4 = (ImageButton) inflate.findViewById(R.id.searchButton4);
        imageButton4.setImageResource(i4);
        imageButton4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.util.d.a.4

            /* renamed from: a */
            private final C3211a f19113a;

            /* renamed from: b */
            private final EditText f19114b;

            {
                this.f19113a = this;
                this.f19114b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f19113a.f18938a);
                if (m18991a != null) {
                    this.f19114b.setText(m18991a);
                    this.f19114b.setSelection(this.f19114b.getText().length());
                }
            }
        });
        ImageButton imageButton5 = (ImageButton) inflate.findViewById(R.id.searchButton5);
        ImageButton imageButton6 = (ImageButton) inflate.findViewById(R.id.searchButton6);
        imageButton5.setImageResource(i3);
        imageButton6.setImageResource(i2);
        imageButton5.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.util.d.a.5

            /* renamed from: a */
            private final C3211a f19115a;

            /* renamed from: b */
            private final EditText f19116b;

            {
                this.f19115a = this;
                this.f19116b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f19116b.setText(C3112bn.m19039n(this.f19116b.getText().toString()));
                    this.f19116b.requestFocus();
                    this.f19116b.selectAll();
                } catch (Exception e2) {
                }
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.util.d.a.6

            /* renamed from: a */
            private final C3211a f19117a;

            /* renamed from: b */
            private final EditText f19118b;

            {
                this.f19117a = this;
                this.f19118b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f19118b.setText(C3112bn.m19038m(this.f19118b.getText().toString()));
                    this.f19118b.requestFocus();
                    this.f19118b.selectAll();
                } catch (Exception e2) {
                }
            }
        });
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.clearText1);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.clearText2);
        imageView3.setImageResource(i);
        imageView4.setImageResource(i);
        if (editText.getText().length() == 0) {
            imageView3.setVisibility(8);
        }
        if (editText2.getText().length() == 0) {
            imageView4.setVisibility(8);
        }
        imageView3.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.util.d.a.7

            /* renamed from: a */
            private final C3211a f19119a;

            /* renamed from: b */
            private final EditText f19120b;

            {
                this.f19119a = this;
                this.f19120b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f19120b.requestFocus();
                this.f19120b.setText("");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener(this, editText2) { // from class: ru.maximoff.apktool.util.d.a.8

            /* renamed from: a */
            private final C3211a f19121a;

            /* renamed from: b */
            private final EditText f19122b;

            {
                this.f19121a = this;
                this.f19122b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f19122b.requestFocus();
                this.f19122b.setText("");
            }
        });
        editText.addTextChangedListener(new TextWatcher(this, imageView3) { // from class: ru.maximoff.apktool.util.d.a.9

            /* renamed from: a */
            private final C3211a f19123a;

            /* renamed from: b */
            private final ImageView f19124b;

            {
                this.f19123a = this;
                this.f19124b = imageView3;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f19124b.setVisibility(8);
                } else {
                    this.f19124b.setVisibility(0);
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this, imageView4) { // from class: ru.maximoff.apktool.util.d.a.10

            /* renamed from: a */
            private final C3211a f18966a;

            /* renamed from: b */
            private final ImageView f18967b;

            {
                this.f18966a = this;
                this.f18967b = imageView4;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f18967b.setVisibility(8);
                } else {
                    this.f18967b.setVisibility(0);
                }
            }
        });
        ImageButton imageButton7 = (ImageButton) inflate.findViewById(R.id.searchButton7);
        if (C3102bd.f18291a) {
            imageButton7.setImageResource(R.drawable.ic_tswap);
        } else {
            imageButton7.setImageResource(R.drawable.ic_tswap_dark);
        }
        imageButton7.setOnClickListener(new View.OnClickListener(this, editText, editText2) { // from class: ru.maximoff.apktool.util.d.a.11

            /* renamed from: a */
            private final C3211a f18968a;

            /* renamed from: b */
            private final EditText f18969b;

            /* renamed from: c */
            private final EditText f18970c;

            {
                this.f18968a = this;
                this.f18969b = editText;
                this.f18970c = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f18968a.f18947j.isChecked()) {
                    String editable = this.f18969b.getText().toString();
                    String editable2 = this.f18970c.getText().toString();
                    this.f18969b.setText(editable2);
                    this.f18970c.setText(editable);
                    if (this.f18969b.isFocused()) {
                        this.f18969b.requestFocus();
                        this.f18969b.setSelection(editable2.length());
                    } else if (this.f18970c.isFocused()) {
                        this.f18970c.requestFocus();
                        this.f18970c.setSelection(editable.length());
                    }
                }
            }
        });
        this.f18941d = (RadioButton) inflate.findViewById(R.id.searchRadioButton1);
        this.f18942e = (RadioButton) inflate.findViewById(R.id.searchRadioButton2);
        this.f18943f = (CheckBox) inflate.findViewById(R.id.searchCheckBox4);
        this.f18944g = (CheckBox) inflate.findViewById(R.id.searchCheckBox1);
        this.f18945h = (CheckBox) inflate.findViewById(R.id.searchCheckBox2);
        this.f18946i = (CheckBox) inflate.findViewById(R.id.searchCheckBox3);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.searchLinearLayout2);
        this.f18947j = (CheckBox) inflate.findViewById(R.id.searchCheckBox5);
        this.f18948k = (CheckBox) inflate.findViewById(R.id.searchCheckBox6);
        this.f18942e.setChecked(C3102bd.m18925a(this.f18938a, "search_rb2", false));
        this.f18943f.setChecked(C3102bd.m18925a(this.f18938a, "search_reg", false));
        this.f18944g.setChecked(C3102bd.m18925a(this.f18938a, "search_cb", false));
        this.f18945h.setChecked(C3102bd.m18925a(this.f18938a, "search_rec", true));
        this.f18948k.setChecked(this.f18958u != null);
        if (!m19178b()) {
            linearLayout2.setVisibility(0);
            ImageView imageView5 = (ImageView) inflate.findViewById(R.id.searchImageView3);
            if (C3102bd.f18291a) {
                imageView5.setImageResource(R.drawable.ic_help_light);
            } else {
                imageView5.setImageResource(R.drawable.ic_help_dark);
            }
            imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.12

                /* renamed from: a */
                private final C3211a f18971a;

                {
                    this.f18971a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f18971a.m19172a();
                }
            });
        } else {
            linearLayout2.setVisibility(8);
        }
        this.f18947j.setEnabled(this.f18942e.isChecked());
        this.f18947j.setText(this.f18938a.getString(R.string.replace).toLowerCase());
        this.f18943f.setText(this.f18938a.getString(R.string.search_regexp).toLowerCase());
        Spinner spinner = (Spinner) inflate.findViewById(R.id.searchSpinner1);
        String[] stringArray = this.f18938a.getResources().getStringArray(R.array.charsets);
        int i6 = 0;
        while (true) {
            if (i6 >= stringArray.length) {
                i6 = 0;
                break;
            } else if (stringArray[i6].equals(this.f18955r)) {
                break;
            } else {
                i6++;
            }
        }
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f18938a, C0012R.layout.simple_spinner_dropdown_item, stringArray));
        spinner.setSelection(i6);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, stringArray) { // from class: ru.maximoff.apktool.util.d.a.13

            /* renamed from: a */
            private final C3211a f18972a;

            /* renamed from: b */
            private final String[] f18973b;

            {
                this.f18972a = this;
                this.f18973b = stringArray;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j) {
                this.f18972a.f18955r = this.f18973b[i7];
            }
        });
        spinner.setEnabled(this.f18942e.isChecked());
        String string = this.f18938a.getString(R.string.search_info, C3080al.m18540a(C3249i.m19501b(), ", "));
        this.f18941d.setOnClickListener(new View.OnClickListener(this, spinner, linearLayout, editText, buttonArr) { // from class: ru.maximoff.apktool.util.d.a.14

            /* renamed from: a */
            private final C3211a f18974a;

            /* renamed from: b */
            private final Spinner f18975b;

            /* renamed from: c */
            private final LinearLayout f18976c;

            /* renamed from: d */
            private final EditText f18977d;

            /* renamed from: e */
            private final Button[] f18978e;

            {
                this.f18974a = this;
                this.f18975b = spinner;
                this.f18976c = linearLayout;
                this.f18977d = editText;
                this.f18978e = buttonArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f18974a.f18947j.setChecked(false);
                this.f18974a.f18947j.setEnabled(false);
                this.f18975b.setEnabled(false);
                this.f18976c.setVisibility(8);
                this.f18977d.requestFocus();
                this.f18977d.selectAll();
                if (this.f18978e[0] != null) {
                    this.f18978e[0].setText(R.string.find);
                }
            }
        });
        this.f18942e.setOnClickListener(new View.OnClickListener(this, spinner) { // from class: ru.maximoff.apktool.util.d.a.15

            /* renamed from: a */
            private final C3211a f18979a;

            /* renamed from: b */
            private final Spinner f18980b;

            {
                this.f18979a = this;
                this.f18980b = spinner;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f18979a.f18947j.setEnabled(true);
                this.f18980b.setEnabled(true);
            }
        });
        this.f18947j.setOnClickListener(new View.OnClickListener(this, linearLayout, editText2, buttonArr, editText) { // from class: ru.maximoff.apktool.util.d.a.16

            /* renamed from: a */
            private final C3211a f18981a;

            /* renamed from: b */
            private final LinearLayout f18982b;

            /* renamed from: c */
            private final EditText f18983c;

            /* renamed from: d */
            private final Button[] f18984d;

            /* renamed from: e */
            private final EditText f18985e;

            {
                this.f18981a = this;
                this.f18982b = linearLayout;
                this.f18983c = editText2;
                this.f18984d = buttonArr;
                this.f18985e = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f18981a.f18947j.isChecked()) {
                    this.f18982b.setVisibility(0);
                    this.f18983c.requestFocus();
                    this.f18983c.selectAll();
                    if (this.f18984d[0] != null) {
                        this.f18984d[0].setText(R.string.replace);
                        return;
                    }
                    return;
                }
                this.f18982b.setVisibility(8);
                this.f18985e.requestFocus();
                this.f18985e.selectAll();
                if (this.f18984d[0] != null) {
                    this.f18984d[0].setText(R.string.find);
                }
            }
        });
        this.f18948k.setText(this.f18938a.getString(R.string.file_filter).toLowerCase());
        this.f18948k.setOnClickListener(new AnonymousClass17(this, i5));
        imageView.setOnClickListener(new View.OnClickListener(this, imageView, editText) { // from class: ru.maximoff.apktool.util.d.a.18

            /* renamed from: a */
            private final C3211a f19005a;

            /* renamed from: b */
            private final ImageView f19006b;

            /* renamed from: c */
            private final EditText f19007c;

            {
                this.f19005a = this;
                this.f19006b = imageView;
                this.f19007c = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f19005a.f18951n.m19201a(this.f19006b, this.f19007c);
            }
        });
        imageView.setOnLongClickListener(new AnonymousClass19(this, imageView));
        imageView2.setOnClickListener(new View.OnClickListener(this, imageView2, editText2) { // from class: ru.maximoff.apktool.util.d.a.20

            /* renamed from: a */
            private final C3211a f19014a;

            /* renamed from: b */
            private final ImageView f19015b;

            /* renamed from: c */
            private final EditText f19016c;

            {
                this.f19014a = this;
                this.f19015b = imageView2;
                this.f19016c = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f19014a.f18952o.m19201a(this.f19015b, this.f19016c);
            }
        });
        imageView2.setOnLongClickListener(new AnonymousClass21(this, imageView2));
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(this, editText, editText2) { // from class: ru.maximoff.apktool.util.d.a.22

            /* renamed from: a */
            private final C3211a f19021a;

            /* renamed from: b */
            private final EditText f19022b;

            /* renamed from: c */
            private final EditText f19023c;

            {
                this.f19021a = this;
                this.f19022b = editText;
                this.f19023c = editText2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!this.f19021a.f18947j.isChecked()) {
                    return false;
                }
                String editable = this.f19022b.getText().toString();
                String editable2 = this.f19023c.getText().toString();
                this.f19022b.setText(editable2);
                this.f19023c.setText(editable);
                if (this.f19022b.isFocused()) {
                    this.f19022b.requestFocus();
                    this.f19022b.setSelection(editable2.length());
                } else if (this.f19023c.isFocused()) {
                    this.f19023c.requestFocus();
                    this.f19023c.setSelection(editable.length());
                }
                return true;
            }
        };
        imageButton.setOnLongClickListener(onLongClickListener);
        imageButton4.setOnLongClickListener(onLongClickListener);
        boolean[] zArr = {false};
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f18938a);
        aVar.m435b(inflate);
        aVar.m418a(R.string.search_files);
        aVar.m420a(R.string.find, new DialogInterface.OnClickListener(this, editText, editText2, zArr, str) { // from class: ru.maximoff.apktool.util.d.a.23

            /* renamed from: a */
            private final C3211a f19024a;

            /* renamed from: b */
            private final EditText f19025b;

            /* renamed from: c */
            private final EditText f19026c;

            /* renamed from: d */
            private final boolean[] f19027d;

            /* renamed from: e */
            private final String f19028e;

            {
                this.f19024a = this;
                this.f19025b = editText;
                this.f19026c = editText2;
                this.f19027d = zArr;
                this.f19028e = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                String editable = this.f19025b.getText().toString();
                if (!C3112bn.m19040o(editable)) {
                    this.f19024a.f18957t = this.f19026c.getText().toString();
                    this.f19024a.f18956s = editable;
                    this.f19024a.f18959v = this.f19024a.f18943f.isChecked();
                    this.f19024a.f18960w = !this.f19024a.f18944g.isChecked();
                    this.f19024a.f18961x = !this.f19024a.f18942e.isChecked();
                    this.f19024a.f18962y = this.f19024a.f18945h.isChecked();
                    this.f19024a.f18963z = this.f19024a.f18946i.isChecked();
                    this.f19024a.f18928A = this.f19024a.f18947j.isChecked();
                    C3102bd.m18938b(this.f19024a.f18938a, "search_reg", this.f19024a.f18959v);
                    C3102bd.m18938b(this.f19024a.f18938a, "search_cb", !this.f19024a.f18960w);
                    C3102bd.m18938b(this.f19024a.f18938a, "search_rec", this.f19024a.f18962y);
                    C3102bd.m18938b(this.f19024a.f18938a, "search_rb2", this.f19024a.f18961x ? false : true);
                    this.f19024a.f18951n.m19204a(this.f19024a.f18956s);
                    if (this.f19024a.f18928A) {
                        this.f19024a.f18952o.m19204a(this.f19024a.f18957t);
                    }
                    this.f19024a.f18957t = C3112bn.m19029d(this.f19024a.f18957t);
                    this.f19024a.f18929B = false;
                    this.f19024a.f18931D = this.f19027d[0];
                    this.f19024a.f18936I = (String) null;
                    this.f19024a.f18934G = System.currentTimeMillis();
                    try {
                        new b(this.f19024a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19028e);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f19024a.f18938a, R.string.error_try_again);
                    }
                }
            }
        });
        aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.24

            /* renamed from: a */
            private final C3211a f19029a;

            {
                this.f19029a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                dialogInterface.dismiss();
            }
        });
        aVar.m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.getWindow().setSoftInputMode(16);
        m438b.setOnShowListener(new AnonymousClass25(this, editText, buttonArr, m438b, zArr, string));
        m438b.show();
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$17, reason: invalid class name */
    class AnonymousClass17 implements View.OnClickListener {

        /* renamed from: a */
        private final C3211a f18986a;

        /* renamed from: b */
        private final int f18987b;

        AnonymousClass17(C3211a c3211a, int i) {
            this.f18986a = c3211a;
            this.f18987b = i;
        }

        /* renamed from: a */
        static C3211a m19180a(AnonymousClass17 anonymousClass17) {
            return anonymousClass17.f18986a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18986a.f18948k.setChecked(this.f18986a.f18958u != null);
            View inflate = this.f18986a.f18949l.inflate(R.layout.mdialog, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.mdialogEditText1);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.mdialogCheckBox1);
            checkBox.setVisibility(0);
            checkBox.setText(this.f18986a.f18938a.getString(R.string.exclude_path).toLowerCase());
            checkBox.setChecked(this.f18986a.f18930C);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.mdialogImageView1);
            imageView.setImageResource(this.f18987b);
            C3212b c3212b = new C3212b(this.f18986a.f18938a, "search_filter_files");
            String m18910a = C3102bd.m18910a(this.f18986a.f18938a, "search_files_filter", (String) null);
            if (m18910a != null) {
                c3212b.m19204a(m18910a);
                C3102bd.m18924a(this.f18986a.f18938a, "search_files_filter");
            }
            List<String> m19205b = c3212b.m19205b();
            if (m19205b.isEmpty()) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                editText.setText(m19205b.get(m19205b.size() - 1));
            }
            imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView, editText) { // from class: ru.maximoff.apktool.util.d.a.17.1

                /* renamed from: a */
                private final AnonymousClass17 f18988a;

                /* renamed from: b */
                private final C3212b f18989b;

                /* renamed from: c */
                private final ImageView f18990c;

                /* renamed from: d */
                private final EditText f18991d;

                {
                    this.f18988a = this;
                    this.f18989b = c3212b;
                    this.f18990c = imageView;
                    this.f18991d = editText;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    this.f18989b.m19201a(this.f18990c, this.f18991d);
                }
            });
            imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.util.d.a.17.2

                /* renamed from: a */
                private final AnonymousClass17 f18992a;

                /* renamed from: b */
                private final C3212b f18993b;

                /* renamed from: c */
                private final ImageView f18994c;

                {
                    this.f18992a = this;
                    this.f18993b = c3212b;
                    this.f18994c = imageView;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    new C3078aj(AnonymousClass17.m19180a(this.f18992a).f18938a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f18993b, this.f18994c) { // from class: ru.maximoff.apktool.util.d.a.17.2.1

                        /* renamed from: a */
                        private final AnonymousClass2 f18995a;

                        /* renamed from: b */
                        private final C3212b f18996b;

                        /* renamed from: c */
                        private final ImageView f18997c;

                        {
                            this.f18995a = this;
                            this.f18996b = r2;
                            this.f18997c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f18996b.m19208d();
                            this.f18997c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f18986a.f18938a).m418a(R.string.file_filter).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, checkBox, c3212b) { // from class: ru.maximoff.apktool.util.d.a.17.3

                /* renamed from: a */
                private final AnonymousClass17 f18998a;

                /* renamed from: b */
                private final EditText f18999b;

                /* renamed from: c */
                private final CheckBox f19000c;

                /* renamed from: d */
                private final C3212b f19001d;

                {
                    this.f18998a = this;
                    this.f18999b = editText;
                    this.f19000c = checkBox;
                    this.f19001d = c3212b;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    String editable = this.f18999b.getText().toString();
                    if (!editable.trim().isEmpty()) {
                        AnonymousClass17.m19180a(this.f18998a).f18930C = this.f19000c.isChecked();
                        AnonymousClass17.m19180a(this.f18998a).f18958u = editable;
                        this.f19001d.m19204a(AnonymousClass17.m19180a(this.f18998a).f18958u);
                        AnonymousClass17.m19180a(this.f18998a).f18948k.setChecked(true);
                    } else {
                        AnonymousClass17.m19180a(this.f18998a).f18958u = (String) null;
                        AnonymousClass17.m19180a(this.f18998a).f18948k.setChecked(false);
                    }
                    dialogInterface.dismiss();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.17.4

                /* renamed from: a */
                private final AnonymousClass17 f19002a;

                {
                    this.f19002a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AnonymousClass17.m19180a(this.f19002a).f18958u = (String) null;
                    AnonymousClass17.m19180a(this.f19002a).f18948k.setChecked(false);
                    dialogInterface.dismiss();
                }
            }).m438b();
            m438b.getWindow().setSoftInputMode(16);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.util.d.a.17.5

                /* renamed from: a */
                private final AnonymousClass17 f19003a;

                /* renamed from: b */
                private final EditText f19004b;

                {
                    this.f19003a = this;
                    this.f19004b = editText;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f19004b.requestFocus();
                    this.f19004b.selectAll();
                }
            });
            m438b.show();
        }
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$19, reason: invalid class name */
    class AnonymousClass19 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3211a f19008a;

        /* renamed from: b */
        private final ImageView f19009b;

        AnonymousClass19(C3211a c3211a, ImageView imageView) {
            this.f19008a = c3211a;
            this.f19009b = imageView;
        }

        /* renamed from: a */
        static C3211a m19181a(AnonymousClass19 anonymousClass19) {
            return anonymousClass19.f19008a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            new C3078aj(this.f19008a.f18938a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f19009b) { // from class: ru.maximoff.apktool.util.d.a.19.1

                /* renamed from: a */
                private final AnonymousClass19 f19010a;

                /* renamed from: b */
                private final ImageView f19011b;

                {
                    this.f19010a = this;
                    this.f19011b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass19.m19181a(this.f19010a).f18951n.m19208d();
                    this.f19011b.setVisibility(8);
                }
            }).m18508e(R.string.cancel).m18507d();
            return true;
        }
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$21, reason: invalid class name */
    class AnonymousClass21 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3211a f19017a;

        /* renamed from: b */
        private final ImageView f19018b;

        AnonymousClass21(C3211a c3211a, ImageView imageView) {
            this.f19017a = c3211a;
            this.f19018b = imageView;
        }

        /* renamed from: a */
        static C3211a m19182a(AnonymousClass21 anonymousClass21) {
            return anonymousClass21.f19017a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            new C3078aj(this.f19017a.f18938a).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f19018b) { // from class: ru.maximoff.apktool.util.d.a.21.1

                /* renamed from: a */
                private final AnonymousClass21 f19019a;

                /* renamed from: b */
                private final ImageView f19020b;

                {
                    this.f19019a = this;
                    this.f19020b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass21.m19182a(this.f19019a).f18952o.m19208d();
                    this.f19020b.setVisibility(8);
                }
            }).m18508e(R.string.cancel).m18507d();
            return true;
        }
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$25, reason: invalid class name */
    class AnonymousClass25 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3211a f19030a;

        /* renamed from: b */
        private final EditText f19031b;

        /* renamed from: c */
        private final Button[] f19032c;

        /* renamed from: d */
        private final DialogInterfaceC0070b f19033d;

        /* renamed from: e */
        private final boolean[] f19034e;

        /* renamed from: f */
        private final String f19035f;

        AnonymousClass25(C3211a c3211a, EditText editText, Button[] buttonArr, DialogInterfaceC0070b dialogInterfaceC0070b, boolean[] zArr, String str) {
            this.f19030a = c3211a;
            this.f19031b = editText;
            this.f19032c = buttonArr;
            this.f19033d = dialogInterfaceC0070b;
            this.f19034e = zArr;
            this.f19035f = str;
        }

        /* renamed from: a */
        static C3211a m19183a(AnonymousClass25 anonymousClass25) {
            return anonymousClass25.f19030a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f19031b.requestFocus();
            this.f19031b.selectAll();
            this.f19032c[0] = this.f19033d.m414a(-1);
            this.f19032c[0].setEnabled(this.f19031b.getText().length() > 0);
            this.f19031b.addTextChangedListener(new TextWatcher(this, this.f19032c) { // from class: ru.maximoff.apktool.util.d.a.25.1

                /* renamed from: a */
                private final AnonymousClass25 f19036a;

                /* renamed from: b */
                private final Button[] f19037b;

                {
                    this.f19036a = this;
                    this.f19037b = r2;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    this.f19037b[0].setEnabled(editable.length() > 0);
                }
            });
            this.f19032c[0].setOnLongClickListener(new View.OnLongClickListener(this, this.f19034e, this.f19032c) { // from class: ru.maximoff.apktool.util.d.a.25.2

                /* renamed from: a */
                private final AnonymousClass25 f19038a;

                /* renamed from: b */
                private final boolean[] f19039b;

                /* renamed from: c */
                private final Button[] f19040c;

                {
                    this.f19038a = this;
                    this.f19039b = r2;
                    this.f19040c = r3;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    this.f19039b[0] = true;
                    this.f19040c[0].performClick();
                    return true;
                }
            });
            this.f19032c[1] = this.f19033d.m414a(-2);
            this.f19032c[2] = this.f19033d.m414a(-3);
            this.f19032c[2].setOnClickListener(new AnonymousClass3(this, this.f19035f));
        }

        /* compiled from: Search.java */
        /* renamed from: ru.maximoff.apktool.util.d.a$25$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass25 f19041a;

            /* renamed from: b */
            private final String f19042b;

            AnonymousClass3(AnonymousClass25 anonymousClass25, String str) {
                this.f19041a = anonymousClass25;
                this.f19042b = str;
            }

            /* renamed from: a */
            static AnonymousClass25 m19184a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f19041a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(AnonymousClass25.m19183a(this.f19041a).f18938a, view);
                if (C3102bd.m18910a(AnonymousClass25.m19183a(this.f19041a).f18938a, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, Types.OTHER, 0, R.string.threads).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.25.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f19043a;

                    {
                        this.f19043a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int availableProcessors = Runtime.getRuntime().availableProcessors();
                        if (availableProcessors <= 0) {
                            availableProcessors = 4;
                        }
                        C3080al.m18546a(AnonymousClass25.m19183a(AnonymousClass3.m19184a(this.f19043a)).f18938a, 1, availableProcessors, availableProcessors, "threads_others", R.string.others);
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1211, 0, R.string.minfo).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19042b) { // from class: ru.maximoff.apktool.util.d.a.25.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f19044a;

                    /* renamed from: b */
                    private final String f19045b;

                    {
                        this.f19044a = this;
                        this.f19045b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        new C3078aj(AnonymousClass25.m19183a(AnonymousClass3.m19184a(this.f19044a)).f18938a).m18494a(R.string.minfo).m18496a(this.f19045b).m18506d(R.string.close_cur).m18507d();
                        return true;
                    }
                });
                c0173ao.m1344c();
            }
        }
    }

    /* renamed from: a */
    public void m19172a() {
        m19176a(this.f18940c, true);
    }

    /* renamed from: a */
    public void m19176a(List<C3213c> list, boolean z) {
        int size;
        if (list == null || list.isEmpty()) {
            this.f18931D = false;
            this.f18936I = (String) null;
            C3112bn.m18999a(this.f18938a, R.string.not_found);
            return;
        }
        this.f18935H = System.currentTimeMillis();
        boolean m18925a = C3102bd.m18925a(this.f18938a, "old_search_res", false);
        if (m18925a || this.f18961x || this.f18928A) {
            size = list.size();
        } else {
            Iterator<C3213c> it = list.iterator();
            size = 0;
            while (it.hasNext()) {
                size = it.next().m19215a() + size;
            }
        }
        C3214d c3214d = new C3214d(this.f18938a, this.f18939b, this.f18956s);
        c3214d.m19236a(C3102bd.m18925a(this.f18938a, "editor_auto_search", true) && !this.f18929B);
        c3214d.setType(this.f18961x);
        c3214d.m19238b(this.f18959v);
        c3214d.m19235a(list);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f18938a);
        aVar.m435b(c3214d);
        aVar.m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18938a.getString(R.string.search_result)).append(" (").toString()).append(size).toString()).append(")").toString());
        aVar.m420a(R.string.close_cur, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.26

            /* renamed from: a */
            private final C3211a f19046a;

            {
                this.f19046a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        aVar.m428a("<->", (DialogInterface.OnClickListener) null);
        aVar.m429a(false);
        if (size > 0) {
            if (!z) {
                this.f18940c.clear();
                this.f18940c.addAll(list);
            }
            aVar.m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null);
        }
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.util.d.a.27

            /* renamed from: a */
            private final C3211a f19047a;

            {
                this.f19047a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f19047a.f18933F > 2000) {
                    C3112bn.m18999a(this.f19047a.f18938a, R.string.click_once_more2);
                    this.f19047a.f18933F = currentTimeMillis;
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.setOnShowListener(new AnonymousClass28(this, size, m438b, m18925a, c3214d));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.util.d.a.29

            /* renamed from: a */
            private final C3211a f19070a;

            {
                this.f19070a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                MainActivity m16615o = MainActivity.m16615o();
                if (m16615o == null || m16615o.isFinishing() || m16615o.isDestroyed() || m16615o.m16634p()) {
                    return;
                }
                m16615o.m16621a((DialogInterfaceC0070b) null);
            }
        });
        c3214d.setDialog(m438b);
        m438b.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(m438b.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        m438b.getWindow().setAttributes(layoutParams);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, c3214d) { // from class: ru.maximoff.apktool.util.d.a.30

            /* renamed from: a */
            private final C3211a f19073a;

            /* renamed from: b */
            private final C3214d f19074b;

            {
                this.f19073a = this;
                this.f19074b = c3214d;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19074b.m19237b();
            }
        }, 100L);
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$28, reason: invalid class name */
    class AnonymousClass28 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3211a f19048a;

        /* renamed from: b */
        private final int f19049b;

        /* renamed from: c */
        private final DialogInterfaceC0070b f19050c;

        /* renamed from: d */
        private final boolean f19051d;

        /* renamed from: e */
        private final C3214d f19052e;

        AnonymousClass28(C3211a c3211a, int i, DialogInterfaceC0070b dialogInterfaceC0070b, boolean z, C3214d c3214d) {
            this.f19048a = c3211a;
            this.f19049b = i;
            this.f19050c = dialogInterfaceC0070b;
            this.f19051d = z;
            this.f19052e = c3214d;
        }

        /* renamed from: a */
        static C3211a m19185a(AnonymousClass28 anonymousClass28) {
            return anonymousClass28.f19048a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (this.f19049b > 0) {
                this.f19050c.m414a(-3).setOnClickListener(new AnonymousClass1(this, this.f19049b, this.f19051d, this.f19050c, this.f19052e));
            }
            Button m414a = this.f19050c.m414a(-2);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f19052e) { // from class: ru.maximoff.apktool.util.d.a.28.2

                /* renamed from: a */
                private final AnonymousClass28 f19068a;

                /* renamed from: b */
                private final C3214d f19069b;

                {
                    this.f19068a = this;
                    this.f19069b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f19069b.m19233a();
                }
            });
            if (this.f19049b == 0 || this.f19048a.f18961x || this.f19051d || this.f19048a.f18928A) {
                m414a.setVisibility(8);
            } else {
                try {
                    m414a.setTypeface(Typeface.createFromAsset(this.f19048a.f18938a.getAssets(), "icofont.ttf"));
                    m414a.setText(R.string.list_icon);
                } catch (Exception e2) {
                    m414a.setTypeface(Typeface.DEFAULT);
                    m414a.setText("<->");
                }
            }
            this.f19052e.m19239c();
        }

        /* compiled from: Search.java */
        /* renamed from: ru.maximoff.apktool.util.d.a$28$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass28 f19053a;

            /* renamed from: b */
            private final int f19054b;

            /* renamed from: c */
            private final boolean f19055c;

            /* renamed from: d */
            private final DialogInterfaceC0070b f19056d;

            /* renamed from: e */
            private final C3214d f19057e;

            AnonymousClass1(AnonymousClass28 anonymousClass28, int i, boolean z, DialogInterfaceC0070b dialogInterfaceC0070b, C3214d c3214d) {
                this.f19053a = anonymousClass28;
                this.f19054b = i;
                this.f19055c = z;
                this.f19056d = dialogInterfaceC0070b;
                this.f19057e = c3214d;
            }

            /* renamed from: a */
            static AnonymousClass28 m19186a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f19053a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(AnonymousClass28.m19185a(this.f19053a).f18938a, view);
                if (C3102bd.m18910a(AnonymousClass28.m19185a(this.f19053a).f18938a, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, Types.OTHER, 0, R.string.save_as).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19054b, this.f19055c, this.f19056d) { // from class: ru.maximoff.apktool.util.d.a.28.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f19058a;

                    /* renamed from: b */
                    private final int f19059b;

                    /* renamed from: c */
                    private final boolean f19060c;

                    /* renamed from: d */
                    private final DialogInterfaceC0070b f19061d;

                    {
                        this.f19058a = this;
                        this.f19059b = r2;
                        this.f19060c = r3;
                        this.f19061d = r4;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19058a)).m19175a(AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19058a)).f18940c, this.f19059b, (this.f19060c || AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19058a)).f18961x || AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19058a)).f18928A) ? false : true);
                        this.f19061d.cancel();
                        return true;
                    }
                });
                if (!this.f19055c && !AnonymousClass28.m19185a(this.f19053a).f18961x && !AnonymousClass28.m19185a(this.f19053a).f18928A) {
                    boolean m18925a = C3102bd.m18925a(AnonymousClass28.m19185a(this.f19053a).f18938a, "search_hlcolors", true);
                    MenuItem add = c0173ao.m1339a().add(0, 1121, 0, R.string.editor_colors);
                    add.setCheckable(true);
                    add.setChecked(m18925a);
                    add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m18925a, this.f19057e) { // from class: ru.maximoff.apktool.util.d.a.28.1.2

                        /* renamed from: a */
                        private final AnonymousClass1 f19062a;

                        /* renamed from: b */
                        private final boolean f19063b;

                        /* renamed from: c */
                        private final C3214d f19064c;

                        {
                            this.f19062a = this;
                            this.f19063b = m18925a;
                            this.f19064c = r3;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3102bd.m18938b(AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19062a)).f18938a, "search_hlcolors", !this.f19063b);
                            this.f19064c.m19234a(100L);
                            return true;
                        }
                    });
                }
                c0173ao.m1339a().add(0, 1122, 0, R.string.search_reset).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19056d) { // from class: ru.maximoff.apktool.util.d.a.28.1.3

                    /* renamed from: a */
                    private final AnonymousClass1 f19065a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f19066b;

                    {
                        this.f19065a = this;
                        this.f19066b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19065a)).f18940c.clear();
                        AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19065a)).f18931D = false;
                        AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19065a)).f18936I = (String) null;
                        this.f19066b.cancel();
                        return true;
                    }
                });
                if (AnonymousClass28.m19185a(this.f19053a).f18931D) {
                    if (AnonymousClass28.m19185a(this.f19053a).f18936I == null) {
                        AnonymousClass28.m19185a(this.f19053a).f18936I = AnonymousClass28.m19185a(this.f19053a).f18938a.getString(R.string.time_spent, C3080al.m18533a(AnonymousClass28.m19185a(this.f19053a).f18935H - AnonymousClass28.m19185a(this.f19053a).f18934G));
                    }
                    c0173ao.m1339a().add(0, 1123, 0, AnonymousClass28.m19185a(this.f19053a).f18936I).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.28.1.4

                        /* renamed from: a */
                        private final AnonymousClass1 f19067a;

                        {
                            this.f19067a = this;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3112bn.m19002a(AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19067a)).f18938a, AnonymousClass28.m19185a(AnonymousClass1.m19186a(this.f19067a)).f18936I);
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
            }
        }
    }

    /* renamed from: a */
    public void m19175a(List<C3213c> list, int i, boolean z) {
        String stringBuffer = new StringBuffer().append(this.f18938a.getString(R.string.search_result)).append(".txt").toString();
        View inflate = LayoutInflater.from(this.f18938a).inflate(R.layout.save_as, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.saveasLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.saveasEditText1);
        editText.setText(stringBuffer);
        editText.setHint(stringBuffer);
        EditText editText2 = (EditText) inflate.findViewById(R.id.saveasEditText2);
        File file = new File(this.f18954q, stringBuffer);
        if (C3262u.m19664g(this.f18938a, this.f18954q)) {
            editText2.setText(file.getParentFile().getAbsolutePath());
            editText2.setHint(file.getParentFile().getAbsolutePath());
        } else if (C3102bd.f18339v != null) {
            editText2.setText(C3102bd.f18339v);
            editText2.setHint(C3102bd.f18339v);
        } else {
            editText2.setText(Environment.getExternalStorageDirectory().getAbsolutePath());
            editText2.setHint(Environment.getExternalStorageDirectory().getAbsolutePath());
        }
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.saveasImageButton1);
        imageButton.setImageBitmap(new C3066aa(this.f18938a).m18363a(!C3102bd.f18291a ? -16777216 : Color.DKGRAY, R.drawable.ic_folder));
        imageButton.setOnClickListener(new AnonymousClass31(this, editText2, editText));
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.saveasCheckBox1);
        checkBox.setText(this.f18938a.getString(R.string.open_in_editor).toLowerCase());
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.saveasCheckBox2);
        checkBox2.setVisibility(0);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.saveasCheckBox3);
        checkBox3.setVisibility(0);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f18938a).m418a(R.string.save_as).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText2, editText, list, i, checkBox2, z, checkBox3, checkBox) { // from class: ru.maximoff.apktool.util.d.a.32

            /* renamed from: a */
            private final C3211a f19097a;

            /* renamed from: b */
            private final EditText f19098b;

            /* renamed from: c */
            private final EditText f19099c;

            /* renamed from: d */
            private final List f19100d;

            /* renamed from: e */
            private final int f19101e;

            /* renamed from: f */
            private final CheckBox f19102f;

            /* renamed from: g */
            private final boolean f19103g;

            /* renamed from: h */
            private final CheckBox f19104h;

            /* renamed from: i */
            private final CheckBox f19105i;

            {
                this.f19097a = this;
                this.f19098b = editText2;
                this.f19099c = editText;
                this.f19100d = list;
                this.f19101e = i;
                this.f19102f = checkBox2;
                this.f19103g = z;
                this.f19104h = checkBox3;
                this.f19105i = checkBox;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                try {
                    String editable = this.f19098b.getText().toString();
                    if (!editable.endsWith("/")) {
                        editable = new StringBuffer().append(editable).append("/").toString();
                    }
                    File file2 = new File(new StringBuffer().append(editable).append(C3112bn.m19033h(this.f19099c.getText().toString())).toString());
                    C3061a.m18319b(file2, this.f19097a.m19120a(this.f19100d, this.f19101e, this.f19102f.isChecked(), this.f19103g, this.f19104h.isChecked()));
                    C3112bn.m18999a(this.f19097a.f18938a, R.string.success);
                    MainActivity m16615o = MainActivity.m16615o();
                    m16615o.m16637s();
                    C2978b.f16135a.m17721k();
                    if (this.f19105i.isChecked()) {
                        m16615o.m16624a(file2, false);
                    }
                } catch (Exception e2) {
                    C3112bn.m19023b(this.f19097a.f18938a, this.f19097a.f18938a.getString(R.string.errorf, e2.getMessage()));
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText, stringBuffer) { // from class: ru.maximoff.apktool.util.d.a.33

            /* renamed from: a */
            private final C3211a f19106a;

            /* renamed from: b */
            private final EditText f19107b;

            /* renamed from: c */
            private final String f19108c;

            {
                this.f19106a = this;
                this.f19107b = editText;
                this.f19108c = stringBuffer;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f19107b.requestFocus();
                int lastIndexOf = this.f19108c.lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    this.f19107b.setSelection(lastIndexOf);
                } else {
                    this.f19107b.setSelection(this.f19108c.length());
                }
            }
        });
        m438b.show();
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$31, reason: invalid class name */
    class AnonymousClass31 implements View.OnClickListener {

        /* renamed from: a */
        private final C3211a f19075a;

        /* renamed from: b */
        private final EditText f19076b;

        /* renamed from: c */
        private final EditText f19077c;

        AnonymousClass31(C3211a c3211a, EditText editText, EditText editText2) {
            this.f19075a = c3211a;
            this.f19076b = editText;
            this.f19077c = editText2;
        }

        /* renamed from: a */
        static C3211a m19187a(AnonymousClass31 anonymousClass31) {
            return anonymousClass31.f19075a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3261t c3261t = new C3261t(this.f19075a.f18938a);
            Runnable runnable = new Runnable(this, c3261t, this.f19076b, this.f19077c) { // from class: ru.maximoff.apktool.util.d.a.31.1

                /* renamed from: a */
                private final AnonymousClass31 f19078a;

                /* renamed from: b */
                private final C3261t f19079b;

                /* renamed from: c */
                private final EditText f19080c;

                /* renamed from: d */
                private final EditText f19081d;

                {
                    this.f19078a = this;
                    this.f19079b = c3261t;
                    this.f19080c = r3;
                    this.f19081d = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(this.f19079b.getPath());
                    if (file.isDirectory()) {
                        this.f19080c.setText(this.f19079b.getPath());
                    } else if (file.isFile()) {
                        this.f19081d.setText(file.getName());
                        this.f19080c.setText(file.getParentFile().getAbsolutePath());
                    }
                }
            };
            c3261t.m19545a("_save_search");
            c3261t.m19547b();
            c3261t.setCallback(runnable);
            c3261t.setPath(this.f19076b.getText().toString());
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f19075a.f18938a);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.mselect, new DialogInterface.OnClickListener(this, runnable) { // from class: ru.maximoff.apktool.util.d.a.31.2

                /* renamed from: a */
                private final AnonymousClass31 f19082a;

                /* renamed from: b */
                private final Runnable f19083b;

                {
                    this.f19082a = this;
                    this.f19083b = runnable;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f19083b.run();
                    dialogInterface.dismiss();
                }
            });
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m437b("/...", (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.d.a.31.3

                /* renamed from: a */
                private final AnonymousClass31 f19084a;

                /* renamed from: b */
                private final C3261t f19085b;

                {
                    this.f19084a = this;
                    this.f19085b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f19085b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new AnonymousClass4(this, m438b, c3261t));
            c3261t.setDialog(m438b);
            m438b.show();
        }

        /* compiled from: Search.java */
        /* renamed from: ru.maximoff.apktool.util.d.a$31$4, reason: invalid class name */
        class AnonymousClass4 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final AnonymousClass31 f19086a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f19087b;

            /* renamed from: c */
            private final C3261t f19088c;

            AnonymousClass4(AnonymousClass31 anonymousClass31, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
                this.f19086a = anonymousClass31;
                this.f19087b = dialogInterfaceC0070b;
                this.f19088c = c3261t;
            }

            /* renamed from: a */
            static AnonymousClass31 m19188a(AnonymousClass4 anonymousClass4) {
                return anonymousClass4.f19086a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f19087b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f19088c) { // from class: ru.maximoff.apktool.util.d.a.31.4.1

                    /* renamed from: a */
                    private final AnonymousClass4 f19089a;

                    /* renamed from: b */
                    private final C3261t f19090b;

                    {
                        this.f19089a = this;
                        this.f19090b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        String[] m19640b = C3262u.m19640b(AnonymousClass31.m19187a(AnonymousClass4.m19188a(this.f19089a)).f18938a);
                        if (m19640b != null) {
                            C0173ao c0173ao = new C0173ao(AnonymousClass31.m19187a(AnonymousClass4.m19188a(this.f19089a)).f18938a, view);
                            if (C3102bd.m18910a(AnonymousClass31.m19187a(AnonymousClass4.m19188a(this.f19089a)).f18938a, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            for (int i2 = 0; i2 < m19640b.length; i2++) {
                                c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19090b) { // from class: ru.maximoff.apktool.util.d.a.31.4.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f19091a;

                                    /* renamed from: b */
                                    private final C3261t f19092b;

                                    {
                                        this.f19091a = this;
                                        this.f19092b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f19092b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f19088c) { // from class: ru.maximoff.apktool.util.d.a.31.4.2

                    /* renamed from: a */
                    private final AnonymousClass4 f19093a;

                    /* renamed from: b */
                    private final C3261t f19094b;

                    {
                        this.f19093a = this;
                        this.f19094b = r2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        List<String> m19205b = this.f19094b.m19549d().m19205b();
                        if (m19205b.isEmpty()) {
                            return false;
                        }
                        C0173ao c0173ao = new C0173ao(AnonymousClass31.m19187a(AnonymousClass4.m19188a(this.f19093a)).f18938a, view);
                        if (C3102bd.m18910a(AnonymousClass31.m19187a(AnonymousClass4.m19188a(this.f19093a)).f18938a, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        Iterator<String> it = m19205b.iterator();
                        while (it.hasNext()) {
                            c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19094b) { // from class: ru.maximoff.apktool.util.d.a.31.4.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f19095a;

                                /* renamed from: b */
                                private final C3261t f19096b;

                                {
                                    this.f19095a = this;
                                    this.f19096b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f19096b.m19544a(new File(menuItem.getTitle().toString()));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m19120a(List<C3213c> list, int i, boolean z, boolean z2, boolean z3) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18938a.getString(R.string.dirf, this.f18954q.getAbsolutePath())).append("\n");
        sb.append(new StringBuffer().append(new StringBuffer().append(this.f18938a.getString(R.string.find)).append(": ").toString()).append(this.f18956s).toString()).append("\n");
        if (this.f18928A) {
            sb.append(new StringBuffer().append(new StringBuffer().append(this.f18938a.getString(R.string.replace)).append(": ").toString()).append(this.f18957t).toString()).append("\n");
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f18961x) {
            sb2.append(this.f18938a.getString(R.string.search_name));
        } else {
            sb2.append(this.f18938a.getString(R.string.search_text));
        }
        if (this.f18959v) {
            sb2.append(", ").append(this.f18938a.getString(R.string.search_regexp));
        }
        if (!this.f18960w) {
            sb2.append(", ").append(this.f18938a.getString(R.string.search_sen));
        }
        if (this.f18962y) {
            sb2.append(", ").append(this.f18938a.getString(R.string.search_rec));
        }
        sb.append(this.f18938a.getString(R.string.parameters, sb2.toString().toLowerCase())).append("\n");
        sb.append(new StringBuffer().append(new StringBuffer().append(this.f18938a.getString(R.string.total)).append(": ").toString()).append(i).toString()).append("\n\n");
        for (C3213c c3213c : list) {
            String m19220c = c3213c.m19220c();
            if (c3213c.m19221d().isDirectory()) {
                i2 = R.string.dirf;
                if (z3) {
                    m19220c = new StringBuffer().append(m19220c).append("/").toString();
                }
            } else {
                i2 = R.string.filef;
            }
            if (z) {
                sb.append(this.f18938a.getString(i2, m19220c.substring(this.f18932E)));
            } else {
                sb.append(this.f18938a.getString(i2, m19220c));
            }
            sb.append("\n");
            if (z2) {
                for (C3215e.a aVar : c3213c.m19219b()) {
                    if (aVar.f19220e != -1) {
                        sb.append(new StringBuffer().append(this.f18938a.getString(R.string.linef, new Integer(aVar.f19220e))).append(": ").toString());
                    }
                    sb.append(aVar.f19221f).append("\n");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private File[] m19134b(List<C3213c> list, boolean z) {
        return m19126a(list, z, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x006b, code lost:
    
        r1.add(r3);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File[] m19126a(List<C3213c> list, boolean z, boolean z2) {
        if (list == null) {
            return (File[]) null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C3213c> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(it.next().m19220c());
            if (!this.f18929B && file.isFile() && this.f18948k.isChecked() && this.f18958u != null) {
                boolean matches = file.getAbsolutePath().substring(this.f18932E).matches(C3112bn.m19025c(this.f18958u));
                if (!matches || !this.f18930C) {
                    if (!matches && !this.f18930C) {
                    }
                }
            }
            if (!file.isFile() && z) {
                arrayList.add(file);
            } else if (file.isFile() && !z) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    private File[] m19129a(File[] fileArr, String str, boolean z, boolean z2) {
        if (fileArr == null) {
            return (File[]) null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            String name = file.getName();
            if (z2) {
                int i = 8;
                if (z) {
                    i = 10;
                }
                try {
                    if (Pattern.compile(str, i).matcher(name).find()) {
                        arrayList.add(file);
                    }
                } catch (Exception e2) {
                }
            } else if ((z && name.toLowerCase().indexOf(str.toLowerCase()) >= 0) || (!z && name.indexOf(str) >= 0)) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    public List<C3213c> m19171a(File file, b bVar) {
        if (this.f18961x) {
            return m19170a(file);
        }
        this.f18953p = 0;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18297ae);
        m19177a(newFixedThreadPool, file, bVar);
        newFixedThreadPool.shutdown();
        do {
        } while (!newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
        return (List) null;
    }

    /* renamed from: a */
    public void m19177a(ExecutorService executorService, File file, b bVar) {
        File[] m19128a;
        File[] listFiles;
        if (!this.f18950m) {
            if (this.f18963z) {
                m19128a = m19134b(m19179c(), false);
            } else {
                FilenameFilter filenameFilter = new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.d.a.34

                    /* renamed from: a */
                    private final C3211a f19109a;

                    {
                        this.f19109a = this;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        if (!C3102bd.f18269E && str.charAt(0) == '.') {
                            return false;
                        }
                        if (!this.f19109a.f18929B && this.f19109a.f18958u != null && this.f19109a.f18948k.isChecked()) {
                            boolean matches = new File(file2, str).getAbsolutePath().substring(this.f19109a.f18932E).matches(C3112bn.m19025c(this.f19109a.f18958u));
                            return this.f19109a.f18930C ? !matches : matches;
                        }
                        for (String str2 : C3249i.m19501b()) {
                            if (str.toLowerCase().endsWith(new StringBuffer().append(".").append(str2).toString())) {
                                return true;
                            }
                        }
                        return false;
                    }
                };
                File[] listFiles2 = file.listFiles(filenameFilter);
                m19128a = (!C3262u.m19649c(listFiles2) || C3262u.m19618a(this.f18937J, file)) ? listFiles2 : m19128a(C3086ar.m18671a(this.f18938a, file.getAbsolutePath(), C3102bd.f18269E), filenameFilter);
            }
            if (m19128a != null) {
                for (File file2 : m19128a) {
                    if (this.f18950m) {
                        break;
                    }
                    executorService.submit(new a(this, file2, bVar));
                }
            }
            if (this.f18962y) {
                if (this.f18963z) {
                    listFiles = m19134b(m19179c(), true);
                } else {
                    FileFilter fileFilter = new FileFilter(this) { // from class: ru.maximoff.apktool.util.d.a.35

                        /* renamed from: a */
                        private final C3211a f19110a;

                        {
                            this.f19110a = this;
                        }

                        @Override // java.io.FileFilter
                        public boolean accept(File file3) {
                            return (C3102bd.f18269E || file3.getName().charAt(0) != '.') && !file3.isFile();
                        }
                    };
                    listFiles = file.listFiles(fileFilter);
                    if (C3262u.m19649c(listFiles) && !C3262u.m19618a(this.f18937J, file)) {
                        listFiles = m19127a(C3086ar.m18671a(this.f18938a, file.getAbsolutePath(), C3102bd.f18269E), fileFilter);
                    }
                    if (C3262u.m19649c(listFiles)) {
                        int i = 0;
                        while (true) {
                            if (i >= this.f18937J.length) {
                                break;
                            }
                            if (!file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(this.f18937J[i]).append(C3249i.f19551k).toString())) {
                                i++;
                            } else {
                                listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18937J[i]).append(C3249i.f19551k).toString()).append("/").toString()).append(this.f18938a.getPackageName()).toString())};
                                break;
                            }
                        }
                    }
                    if (C3262u.m19649c(listFiles) && file.getAbsolutePath().equalsIgnoreCase(C3249i.f19550j)) {
                        listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(C3249i.f19550j).append("/").toString()).append(this.f18938a.getPackageName()).toString())};
                    }
                }
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        m19177a(executorService, file3, bVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public List<C3213c> m19170a(File file) {
        File[] fileArr;
        File[] fileArr2;
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (this.f18950m) {
            return arrayList;
        }
        if (this.f18963z) {
            try {
                fileArr = m19129a(m19126a(m19179c(), false, true), this.f18956s, this.f18960w, this.f18959v);
            } catch (Exception e2) {
                C3112bn.m18999a(this.f18938a, R.string.error);
                fileArr = (File[]) null;
            }
            fileArr2 = fileArr;
        } else {
            FilenameFilter filenameFilter = new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.d.a.36

                /* renamed from: a */
                private final C3211a f19111a;

                {
                    this.f19111a = this;
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    if (!C3102bd.f18269E && str.charAt(0) == '.') {
                        return false;
                    }
                    if (!this.f19111a.f18929B && this.f19111a.f18958u != null && this.f19111a.f18948k.isChecked()) {
                        boolean matches = new File(file2, str).getAbsolutePath().substring(this.f19111a.f18932E).matches(C3112bn.m19025c(this.f19111a.f18958u));
                        if (matches && this.f19111a.f18930C) {
                            return false;
                        }
                        if (!matches && !this.f19111a.f18930C) {
                            return false;
                        }
                    }
                    if (!this.f19111a.f18959v) {
                        return this.f19111a.f18960w ? str.toLowerCase().indexOf(this.f19111a.f18956s.toLowerCase()) >= 0 : str.indexOf(this.f19111a.f18956s) >= 0;
                    }
                    int i = 8;
                    try {
                        if (this.f19111a.f18960w) {
                            i = 10;
                        }
                        return Pattern.compile(this.f19111a.f18956s, i).matcher(str).find();
                    } catch (Exception e3) {
                        return false;
                    }
                }
            };
            File[] listFiles2 = file.listFiles(filenameFilter);
            fileArr2 = (!C3262u.m19649c(listFiles2) || C3262u.m19618a(this.f18937J, file)) ? listFiles2 : m19128a(C3086ar.m18671a(this.f18938a, file.getAbsolutePath(), C3102bd.f18269E), filenameFilter);
        }
        if (fileArr2 != null) {
            for (File file2 : fileArr2) {
                if (this.f18950m) {
                    break;
                }
                arrayList.add(new C3213c(file2, true));
            }
        }
        if (!this.f18962y) {
            return arrayList;
        }
        if (this.f18963z) {
            listFiles = m19134b(m19179c(), true);
        } else {
            FileFilter fileFilter = new FileFilter(this) { // from class: ru.maximoff.apktool.util.d.a.37

                /* renamed from: a */
                private final C3211a f19112a;

                {
                    this.f19112a = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    return (C3102bd.f18269E || file3.getName().charAt(0) != '.') && !file3.isFile();
                }
            };
            listFiles = file.listFiles(fileFilter);
            if (C3262u.m19649c(listFiles) && !C3262u.m19618a(this.f18937J, file)) {
                listFiles = m19127a(C3086ar.m18671a(this.f18938a, file.getAbsolutePath(), C3102bd.f18269E), fileFilter);
            }
            if (C3262u.m19649c(listFiles)) {
                int i = 0;
                while (true) {
                    if (i >= this.f18937J.length) {
                        break;
                    }
                    if (!file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(this.f18937J[i]).append(C3249i.f19551k).toString())) {
                        i++;
                    } else {
                        listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18937J[i]).append(C3249i.f19551k).toString()).append("/").toString()).append(this.f18938a.getPackageName()).toString())};
                        break;
                    }
                }
            }
            if (C3262u.m19649c(listFiles) && file.getAbsolutePath().equalsIgnoreCase(C3249i.f19550j)) {
                listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(C3249i.f19550j).append("/").toString()).append(this.f18938a.getPackageName()).toString())};
            }
        }
        if (listFiles != null) {
            for (File file3 : listFiles) {
                arrayList.addAll(m19170a(file3));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private File[] m19128a(File[] fileArr, FilenameFilter filenameFilter) {
        if (fileArr == null || filenameFilter == null) {
            return (File[]) null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (file != null && filenameFilter.accept(file.getParentFile(), file.getName())) {
                arrayList.add(file);
            }
        }
        if (arrayList.isEmpty()) {
            return (File[]) null;
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    private File[] m19127a(File[] fileArr, FileFilter fileFilter) {
        if (fileArr == null || fileFilter == null) {
            return (File[]) null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (file != null && fileFilter.accept(file)) {
                arrayList.add(file);
            }
        }
        if (arrayList.isEmpty()) {
            return (File[]) null;
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: b */
    public boolean m19178b() {
        return this.f18940c.size() == 0;
    }

    /* renamed from: c */
    public List<C3213c> m19179c() {
        return this.f18940c;
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$b */
    public class b extends AsyncTask<String, Integer, Boolean> {

        /* renamed from: a */
        private DialogInterfaceC0070b f19128a;

        /* renamed from: b */
        private List<C3213c> f19129b = Collections.synchronizedList(new ArrayList());

        /* renamed from: c */
        private long f19130c = 0;

        /* renamed from: d */
        private long f19131d = 0;

        /* renamed from: e */
        private String f19132e;

        /* renamed from: f */
        private String f19133f;

        /* renamed from: g */
        private final C3211a f19134g;

        /* renamed from: b */
        static C3211a m19190b(b bVar) {
            return bVar.f19134g;
        }

        @Override // android.os.AsyncTask
        protected Boolean doInBackground(String[] strArr) {
            return m19191a(strArr);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled(Boolean bool) {
            m19196b(bool);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m19192a(bool);
        }

        @Override // android.os.AsyncTask
        protected void onProgressUpdate(Integer[] numArr) {
            m19195a(numArr);
        }

        public b(C3211a c3211a) {
            this.f19134g = c3211a;
        }

        /* renamed from: a */
        public void m19193a(String str) {
            this.f19133f = str;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.f19130c = System.currentTimeMillis();
            this.f19134g.f18950m = false;
            View inflate = this.f19134g.f18949l.inflate(R.layout.search_progress, (ViewGroup) null);
            if (this.f19134g.f18928A) {
                ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.replace_in_files);
            }
            this.f19128a = new DialogInterfaceC0070b.a(this.f19134g.f18938a).m435b(inflate).m429a(false).m420a(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.d.a.b.1

                /* renamed from: a */
                private final b f19135a;

                {
                    this.f19135a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    b.m19190b(this.f19135a).f18950m = true;
                    this.f19135a.cancel(true);
                    dialogInterface.dismiss();
                }
            }).m438b();
            this.f19128a.show();
        }

        /* renamed from: a */
        protected Boolean m19191a(String... strArr) {
            this.f19132e = strArr[0];
            List<C3213c> m19171a = this.f19134g.m19171a(new File(this.f19132e), this);
            if (m19171a == null) {
                return new Boolean(false);
            }
            this.f19129b.addAll(m19171a);
            return new Boolean(true);
        }

        /* renamed from: a */
        protected void m19195a(Integer[] numArr) {
            super.onProgressUpdate(numArr);
        }

        /* renamed from: a */
        protected void m19192a(Boolean bool) {
            this.f19131d = System.currentTimeMillis();
            if (this.f19128a != null && this.f19128a.isShowing()) {
                try {
                    this.f19128a.cancel();
                } catch (Exception e2) {
                }
            }
            Collections.sort(this.f19129b, new c(this.f19134g));
            if (!C3112bn.m19040o(this.f19133f) && !this.f19129b.isEmpty()) {
                this.f19134g.f18956s = this.f19133f;
                this.f19134g.f18963z = true;
                this.f19134g.f18940c.clear();
                this.f19134g.f18940c.addAll(this.f19129b);
                b bVar = new b(this.f19134g);
                bVar.m19193a((String) null);
                try {
                    bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19132e);
                    return;
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f19134g.f18938a, R.string.error_try_again);
                    return;
                }
            }
            Runnable runnable = new Runnable(this) { // from class: ru.maximoff.apktool.util.d.a.b.2

                /* renamed from: a */
                private final b f19136a;

                {
                    this.f19136a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.m19190b(this.f19136a).m19176a(this.f19136a.f19129b, false);
                }
            };
            if (this.f19134g.f18928A) {
                new C3078aj(this.f19134g.f18938a).m18494a(R.string.replace_in_files).m18496a(new StringBuffer().append(this.f19134g.f18938a.getString(R.string.total_repl, new Integer(this.f19134g.f18953p))).append(new StringBuffer().append("\n\n").append(this.f19134g.f18938a.getString(R.string.time_spent, C3080al.m18533a(this.f19131d - this.f19130c))).toString()).toString()).m18506d(R.string.close_cur).m18505c(R.string.files, runnable).m18497a(true).m18507d();
            } else {
                runnable.run();
            }
            C2978b.f16135a.m17721k();
            this.f19134g.f18939b.mo17929a();
        }

        /* renamed from: b */
        protected void m19196b(Boolean bool) {
            super.onCancelled(bool);
            this.f19131d = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f19129b);
            Collections.sort(arrayList, new c(this.f19134g));
            Runnable runnable = new Runnable(this, arrayList) { // from class: ru.maximoff.apktool.util.d.a.b.3

                /* renamed from: a */
                private final b f19137a;

                /* renamed from: b */
                private final List f19138b;

                {
                    this.f19137a = this;
                    this.f19138b = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.m19190b(this.f19137a).m19176a(this.f19138b, false);
                }
            };
            if (this.f19134g.f18928A) {
                new C3078aj(this.f19134g.f18938a).m18494a(R.string.replace_in_files).m18496a(new StringBuffer().append(this.f19134g.f18938a.getString(R.string.total_repl, new Integer(this.f19134g.f18953p))).append(new StringBuffer().append("\n\n").append(this.f19134g.f18938a.getString(R.string.time_spent, C3080al.m18533a(this.f19131d - this.f19130c))).toString()).toString()).m18506d(R.string.close_cur).m18505c(R.string.files, runnable).m18497a(true).m18507d();
            } else {
                runnable.run();
            }
            C2978b.f16135a.m17721k();
            this.f19134g.f18939b.mo17929a();
        }

        /* renamed from: a */
        public void m19194a(C3213c c3213c) {
            this.f19129b.add(c3213c);
        }
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$a */
    private class a implements Runnable {

        /* renamed from: a */
        private File f19125a;

        /* renamed from: b */
        private b f19126b;

        /* renamed from: c */
        private final C3211a f19127c;

        public a(C3211a c3211a, File file, b bVar) {
            this.f19127c = c3211a;
            this.f19125a = file;
            this.f19126b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int m19247a;
            C3213c c3213c = new C3213c(this.f19125a, false);
            if (this.f19127c.f18959v) {
                C3215e.a m19254a = C3215e.m19254a(this.f19125a, this.f19127c.f18956s, this.f19127c.f18960w, this.f19127c.f18955r, 0);
                while (m19254a.f19216a >= 0) {
                    c3213c.m19217a(m19254a);
                    if (this.f19127c.f18928A) {
                        break;
                    } else {
                        m19254a = C3215e.m19254a(this.f19125a, this.f19127c.f18956s, this.f19127c.f18960w, this.f19127c.f18955r, m19254a.f19217b);
                    }
                }
            } else {
                C3215e.a m19258b = C3215e.m19258b(this.f19125a, this.f19127c.f18956s, this.f19127c.f18960w, this.f19127c.f18955r, 0);
                while (m19258b.f19216a >= 0) {
                    c3213c.m19217a(m19258b);
                    if (this.f19127c.f18928A) {
                        break;
                    } else {
                        m19258b = C3215e.m19258b(this.f19125a, this.f19127c.f18956s, this.f19127c.f18960w, this.f19127c.f18955r, m19258b.f19217b);
                    }
                }
            }
            if (c3213c.m19215a() > 0) {
                if (this.f19127c.f18928A) {
                    c3213c.m19218a(true);
                    if (this.f19127c.f18959v) {
                        m19247a = C3215e.m19257b(this.f19125a, this.f19127c.f18956s, this.f19127c.f18957t, this.f19127c.f18960w, this.f19127c.f18955r);
                    } else {
                        m19247a = C3215e.m19247a(this.f19125a, this.f19127c.f18956s, this.f19127c.f18957t, this.f19127c.f18960w, this.f19127c.f18955r);
                    }
                    if (m19247a > 0) {
                        this.f19126b.m19194a(c3213c);
                        C3211a c3211a = this.f19127c;
                        c3211a.f18953p = m19247a + c3211a.f18953p;
                        return;
                    }
                    return;
                }
                this.f19126b.m19194a(c3213c);
            }
        }
    }

    /* compiled from: Search.java */
    /* renamed from: ru.maximoff.apktool.util.d.a$c */
    private class c implements Comparator<C3213c> {

        /* renamed from: a */
        private final C3211a f19139a;

        @Override // java.util.Comparator
        public int compare(C3213c c3213c, C3213c c3213c2) {
            return m19197a(c3213c, c3213c2);
        }

        /* renamed from: a */
        public int m19197a(C3213c c3213c, C3213c c3213c2) {
            return EnumC2989h.m17906a(c3213c.m19221d().getName().toLowerCase(), c3213c2.m19221d().getName().toLowerCase());
        }

        public c(C3211a c3211a) {
            this.f19139a = c3211a;
        }
    }
}
