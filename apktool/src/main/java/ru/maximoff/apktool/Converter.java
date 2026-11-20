package ru.maximoff.apktool;

import android.C0012R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.p008os.Bundle;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3257q;
import ru.maximoff.color.C3321c;

/* loaded from: classes.dex */
public class Converter extends AbstractActivityC2894b {

    /* renamed from: i */
    private Context f13944i;

    /* renamed from: j */
    private Spinner f13945j;

    /* renamed from: k */
    private EditText f13946k;

    /* renamed from: l */
    private EditText f13947l;

    /* renamed from: m */
    private ImageView f13948m;

    /* renamed from: n */
    private ImageView f13949n;

    /* renamed from: o */
    private ImageView f13950o;

    /* renamed from: p */
    private ImageView f13951p;

    /* renamed from: t */
    private String f13955t;

    /* renamed from: h */
    private final String f13943h = "HH:mm:ss dd.MM.yyyy";

    /* renamed from: q */
    private long f13952q = 0;

    /* renamed from: r */
    private boolean f13953r = true;

    /* renamed from: s */
    private boolean f13954s = true;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.converter);
        this.f13944i = this;
        this.f13945j = (Spinner) findViewById(R.id.converterSpinner1);
        this.f13946k = (EditText) findViewById(R.id.converterEditText1);
        this.f13947l = (EditText) findViewById(R.id.converterEditText2);
        this.f13948m = (ImageView) findViewById(R.id.converterImageView1);
        this.f13949n = (ImageView) findViewById(R.id.converterImageView2);
        this.f13950o = (ImageView) findViewById(R.id.converterImageView3);
        this.f13951p = (ImageView) findViewById(R.id.converterImageView4);
        this.f13948m.setClickable(true);
        this.f13949n.setClickable(true);
        this.f13950o.setClickable(true);
        this.f13951p.setClickable(true);
        this.f13955t = C3102bd.m18910a(this, "converter_date_fmt", "HH:mm:ss dd.MM.yyyy");
        this.f13954s = C3102bd.m18925a(this.f13944i, "con4smali", true);
        if (C3102bd.f18291a) {
            this.f13948m.setImageResource(R.drawable.ic_copy);
            this.f13949n.setImageResource(R.drawable.ic_copy);
            this.f13950o.setImageResource(R.drawable.ic_paste_light);
            this.f13951p.setImageResource(R.drawable.ic_paste_light);
        } else {
            this.f13948m.setImageResource(R.drawable.ic_copy_dark);
            this.f13949n.setImageResource(R.drawable.ic_copy_dark);
            this.f13950o.setImageResource(R.drawable.ic_paste_dark);
            this.f13951p.setImageResource(R.drawable.ic_paste_dark);
        }
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ru.maximoff.apktool.Converter.1

            /* renamed from: a */
            private final Converter f13956a;

            {
                this.f13956a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f13956a.f13944i);
                switch (view.getId()) {
                    case R.id.converterImageView1 /* 2131689689 */:
                        String editable = this.f13956a.f13946k.getText().toString();
                        if (C3112bn.m19040o(editable)) {
                            C3112bn.m18999a(this.f13956a.f13944i, R.string.empty);
                            break;
                        } else {
                            C3112bn.m19002a(this.f13956a.f13944i, editable);
                            break;
                        }
                    case R.id.converterImageView3 /* 2131689690 */:
                        this.f13956a.f13946k.requestFocus();
                        if (m18991a != null) {
                            C3112bn.m19007a(this.f13956a.f13946k, (CharSequence) m18991a);
                            break;
                        } else {
                            C3112bn.m18999a(this.f13956a.f13944i, R.string.empty);
                            break;
                        }
                    case R.id.converterImageView2 /* 2131689693 */:
                        String editable2 = this.f13956a.f13947l.getText().toString();
                        if (C3112bn.m19040o(editable2)) {
                            C3112bn.m18999a(this.f13956a.f13944i, R.string.empty);
                            break;
                        } else {
                            C3112bn.m19002a(this.f13956a.f13944i, editable2);
                            break;
                        }
                    case R.id.converterImageView4 /* 2131689694 */:
                        this.f13956a.f13947l.requestFocus();
                        if (m18991a != null) {
                            C3112bn.m19007a(this.f13956a.f13947l, (CharSequence) m18991a);
                            break;
                        } else {
                            C3112bn.m18999a(this.f13956a.f13944i, R.string.empty);
                            break;
                        }
                }
            }
        };
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: ru.maximoff.apktool.Converter.2

            /* renamed from: a */
            private final Converter f13965a;

            {
                this.f13965a = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    switch (view.getId()) {
                        case R.id.converterEditText1 /* 2131689688 */:
                            this.f13965a.f13953r = true;
                            break;
                        case R.id.converterEditText2 /* 2131689692 */:
                            this.f13965a.f13953r = false;
                            break;
                    }
                }
            }
        };
        this.f13946k.setOnFocusChangeListener(onFocusChangeListener);
        this.f13947l.setOnFocusChangeListener(onFocusChangeListener);
        this.f13948m.setOnClickListener(onClickListener);
        this.f13949n.setOnClickListener(onClickListener);
        this.f13950o.setOnClickListener(onClickListener);
        this.f13951p.setOnClickListener(onClickListener);
        this.f13945j.setAdapter((SpinnerAdapter) new ArrayAdapter(this, C0012R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.converter_items)));
        this.f13945j.setSelection(C3102bd.m18905a(this.f13944i, "converter_select", 0));
        this.f13945j.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.Converter.3

            /* renamed from: a */
            private final Converter f13966a;

            {
                this.f13966a = this;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                C3102bd.m18935b(this.f13966a.f13944i, "converter_select", i);
                if (i < 3 || i > 8) {
                    this.f13966a.f13947l.setEnabled(true);
                    this.f13966a.f13951p.setVisibility(0);
                } else {
                    this.f13966a.f13947l.setEnabled(false);
                    this.f13966a.f13951p.setVisibility(8);
                }
                try {
                    C3112bn.m19004a(this.f13966a.f13946k.getText(), (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    try {
                        C3112bn.m19004a(this.f13966a.f13947l.getText(), (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                        if (this.f13966a.f13953r || !this.f13966a.f13947l.isEnabled()) {
                            this.f13966a.f13946k.requestFocus();
                        } else {
                            this.f13966a.f13947l.requestFocus();
                        }
                        this.f13966a.invalidateOptionsMenu();
                        this.f13966a.m16539o();
                    } catch (ClassNotFoundException e2) {
                        throw new NoClassDefFoundError(e2.getMessage());
                    }
                } catch (ClassNotFoundException e3) {
                    throw new NoClassDefFoundError(e3.getMessage());
                }
            }
        });
        this.f13945j.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.Converter.4

            /* renamed from: a */
            private final Converter f13967a;

            {
                this.f13967a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                String editable = this.f13967a.f13946k.getText().toString();
                String editable2 = this.f13967a.f13947l.getText().toString();
                int selectedItemPosition = this.f13967a.f13945j.getSelectedItemPosition();
                if (selectedItemPosition >= 3 && selectedItemPosition <= 8 && !C3112bn.m19040o(editable2)) {
                    this.f13967a.f13946k.requestFocus();
                    this.f13967a.f13946k.setText(editable2);
                    return true;
                }
                if (this.f13967a.f13946k.isFocused() && this.f13967a.f13947l.isEnabled() && !C3112bn.m19040o(editable)) {
                    this.f13967a.f13947l.requestFocus();
                    this.f13967a.f13947l.setText(editable);
                    return true;
                }
                if (this.f13967a.f13947l.isFocused() && !C3112bn.m19040o(editable2)) {
                    this.f13967a.f13946k.requestFocus();
                    this.f13967a.f13946k.setText(editable2);
                    return true;
                }
                return false;
            }
        });
        this.f13946k.addTextChangedListener(new TextWatcher(this) { // from class: ru.maximoff.apktool.Converter.5

            /* renamed from: a */
            private final Converter f13968a;

            {
                this.f13968a = this;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    C3112bn.m19004a(editable, (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    if (this.f13968a.f13946k.isFocused()) {
                        if (editable.length() > 0) {
                            this.f13968a.m16539o();
                        } else {
                            this.f13968a.f13947l.setText("");
                        }
                    }
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        });
        this.f13947l.addTextChangedListener(new TextWatcher(this) { // from class: ru.maximoff.apktool.Converter.6

            /* renamed from: a */
            private final Converter f13969a;

            {
                this.f13969a = this;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    C3112bn.m19004a(editable, (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    if (this.f13969a.f13947l.isFocused()) {
                        if (editable.length() > 0) {
                            this.f13969a.m16539o();
                        } else {
                            this.f13969a.f13946k.setText("");
                        }
                    }
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        });
        onNewIntent(getIntent());
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onNewIntent(Intent intent) {
        String stringExtra;
        if (Intent.ACTION_SEND.equals(intent.getAction()) && (stringExtra = intent.getStringExtra(Intent.EXTRA_TEXT)) != null && !stringExtra.trim().isEmpty()) {
            int m18905a = C3102bd.m18905a(this.f13944i, "converter_select", 0);
            if (m18905a >= 3 && m18905a <= 8) {
                this.f13946k.requestFocus();
                this.f13946k.setText(stringExtra);
            } else {
                AlertDialog create = new AlertDialog.Builder(this).setTitle(R.string.paste).setItems(new String[]{getString(R.string.data), getString(R.string.result)}, new DialogInterface.OnClickListener(this, stringExtra) { // from class: ru.maximoff.apktool.Converter.7

                    /* renamed from: a */
                    private final Converter f13970a;

                    /* renamed from: b */
                    private final String f13971b;

                    {
                        this.f13970a = this;
                        this.f13971b = stringExtra;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        switch (i) {
                            case 0:
                                this.f13970a.f13946k.requestFocus();
                                this.f13970a.f13946k.setText(this.f13971b);
                                break;
                            case 1:
                                this.f13970a.f13947l.requestFocus();
                                this.f13970a.f13947l.setText(this.f13971b);
                                break;
                        }
                    }
                }).setCancelable(false).create();
                create.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.Converter.8

                    /* renamed from: a */
                    private final Converter f13972a;

                    {
                        this.f13972a = this;
                    }

                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                            return false;
                        }
                        dialogInterface.cancel();
                        return true;
                    }
                });
                create.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m16539o() {
        String str;
        String stringBuffer;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        byte[] m19015a;
        String m18998a;
        byte[] m19015a2;
        String m18998a2;
        String m18998a3;
        byte[] m19015a3;
        String m18998a4;
        byte[] m19015a4;
        String m18998a5;
        byte[] m19015a5;
        byte[] m19015a6;
        String m18998a6;
        byte[] m19015a7;
        String m18998a7;
        boolean m18925a = C3102bd.m18925a((Context) this, "converter_hex", false);
        String editable = this.f13946k.getText().toString();
        String editable2 = this.f13947l.getText().toString();
        String str10 = "";
        switch (this.f13945j.getSelectedItemPosition()) {
            case 0:
                if (this.f13947l.isFocused()) {
                    String m19519b = C3257q.m19519b(editable2);
                    if (m19519b != null) {
                        this.f13946k.setText(m19519b);
                        return;
                    } else {
                        m16529a((Throwable) null);
                        return;
                    }
                }
                String m19517a = C3257q.m19517a(editable);
                if (m19517a != null) {
                    this.f13947l.setText(m19517a);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 1:
                if (this.f13947l.isFocused()) {
                    try {
                        this.f13946k.setText(C3112bn.m19038m(editable2));
                        return;
                    } catch (Exception e2) {
                        m16529a(e2);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(C3112bn.m19039n(editable));
                    return;
                } catch (Exception e3) {
                    m16529a(e3);
                    return;
                }
            case 2:
                if (this.f13947l.isFocused()) {
                    try {
                        this.f13946k.setText(C3112bn.m19018b(editable2));
                        return;
                    } catch (Exception e4) {
                        m16529a(e4);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(C3112bn.m18994a(editable));
                    return;
                } catch (Exception e5) {
                    m16529a(e5);
                    return;
                }
            case 3:
                String m19020b = C3112bn.m19020b(editable, KeyProperties.DIGEST_MD5);
                if (m19020b != null) {
                    this.f13947l.setText(m19020b);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 4:
                String m19020b2 = C3112bn.m19020b(editable, KeyProperties.DIGEST_SHA1);
                if (m19020b2 != null) {
                    this.f13947l.setText(m19020b2);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 5:
                String m19020b3 = C3112bn.m19020b(editable, KeyProperties.DIGEST_SHA224);
                if (m19020b3 != null) {
                    this.f13947l.setText(m19020b3);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 6:
                String m19020b4 = C3112bn.m19020b(editable, KeyProperties.DIGEST_SHA256);
                if (m19020b4 != null) {
                    this.f13947l.setText(m19020b4);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 7:
                String m19020b5 = C3112bn.m19020b(editable, KeyProperties.DIGEST_SHA384);
                if (m19020b5 != null) {
                    this.f13947l.setText(m19020b5);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 8:
                String m19020b6 = C3112bn.m19020b(editable, KeyProperties.DIGEST_SHA512);
                if (m19020b6 != null) {
                    this.f13947l.setText(m19020b6);
                    return;
                } else {
                    m16529a((Throwable) null);
                    return;
                }
            case 9:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a7 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a7 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a7, "UTF-8"));
                        return;
                    } catch (Exception e6) {
                        m16529a(e6);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a7 = C3112bn.m18997a(editable.getBytes("UTF-8")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a7 = C3112bn.m19021b(editable.getBytes("UTF-8"), "\n");
                    } else {
                        m18998a7 = C3112bn.m18998a(editable.getBytes("UTF-8"), "\n");
                    }
                    this.f13947l.setText(m18998a7);
                    return;
                } catch (Exception e7) {
                    m16529a(e7);
                    return;
                }
            case 10:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a6 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a6 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a6, "UTF-16"));
                        return;
                    } catch (Exception e8) {
                        m16529a(e8);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a6 = C3112bn.m18997a(editable.getBytes("UTF-16")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a6 = C3112bn.m19021b(editable.getBytes("UTF-16"), "\n");
                    } else {
                        m18998a6 = C3112bn.m18998a(editable.getBytes("UTF-16"), "\n");
                    }
                    this.f13947l.setText(m18998a6);
                    return;
                } catch (Exception e9) {
                    m16529a(e9);
                    return;
                }
            case 11:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a5 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a5 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a5, "UTF-16LE"));
                        return;
                    } catch (Exception e10) {
                        m16529a(e10);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a5 = C3112bn.m18997a(editable.getBytes("UTF-16LE")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a5 = C3112bn.m19021b(editable.getBytes("UTF-16LE"), "\n");
                    } else {
                        m18998a5 = C3112bn.m18998a(editable.getBytes("UTF-16LE"), "\n");
                    }
                    this.f13947l.setText(m18998a5);
                    return;
                } catch (Exception e11) {
                    m16529a(e11);
                    return;
                }
            case 12:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a4 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a4 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a4, "UTF-16BE"));
                        return;
                    } catch (Exception e12) {
                        m16529a(e12);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a4 = C3112bn.m18997a(editable.getBytes("UTF-16BE")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a4 = C3112bn.m19021b(editable.getBytes("UTF-16BE"), "\n");
                    } else {
                        m18998a4 = C3112bn.m18998a(editable.getBytes("UTF-16BE"), "\n");
                    }
                    this.f13947l.setText(m18998a4);
                    return;
                } catch (Exception e13) {
                    m16529a(e13);
                    return;
                }
            case 13:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a3 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a3 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a3, "US-ASCII"));
                        return;
                    } catch (Exception e14) {
                        m16529a(e14);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a3 = C3112bn.m18997a(editable.getBytes("US-ASCII")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a3 = C3112bn.m19021b(editable.getBytes("US-ASCII"), "\n");
                    } else {
                        m18998a3 = C3112bn.m18998a(editable.getBytes("US-ASCII"), "\n");
                    }
                    this.f13947l.setText(m18998a3);
                    return;
                } catch (Exception e15) {
                    m16529a(e15);
                    return;
                }
            case 14:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a2 = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a2 = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a2, "ISO-8859-1"));
                        return;
                    } catch (Exception e16) {
                        m16529a(e16);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a2 = C3112bn.m18997a(editable.getBytes("ISO-8859-1")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a2 = C3112bn.m19021b(editable.getBytes("ISO-8859-1"), "\n");
                    } else {
                        m18998a2 = C3112bn.m18998a(editable.getBytes("ISO-8859-1"), "\n");
                    }
                    this.f13947l.setText(m18998a2);
                    return;
                } catch (Exception e17) {
                    m16529a(e17);
                    return;
                }
            case 15:
                if (this.f13947l.isFocused()) {
                    try {
                        if (m18925a) {
                            m19015a = C3112bn.m19037l(editable2.replaceAll("[^A-Fa-f0-9]", ""));
                        } else {
                            m19015a = C3112bn.m19015a(editable2.split("\n"));
                        }
                        this.f13946k.setText(new String(m19015a, "CP1251"));
                        return;
                    } catch (Exception e18) {
                        m16529a(e18);
                        return;
                    }
                }
                try {
                    if (m18925a) {
                        m18998a = C3112bn.m18997a(editable.getBytes("CP1251")).replaceAll("..(?!$)", "$0 ");
                    } else if (this.f13954s) {
                        m18998a = C3112bn.m19021b(editable.getBytes("CP1251"), "\n");
                    } else {
                        m18998a = C3112bn.m18998a(editable.getBytes("CP1251"), "\n");
                    }
                    this.f13947l.setText(m18998a);
                    return;
                } catch (Exception e19) {
                    m16529a(e19);
                    return;
                }
            case 16:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            editable2 = editable2.substring(1);
                            str10 = "-";
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Long.parseLong(editable2, 2))).toString());
                        return;
                    } catch (Exception e20) {
                        m16529a(e20);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        editable = editable.substring(1);
                        str10 = "-";
                    }
                    this.f13947l.setText(new StringBuffer().append(str10).append(Long.toBinaryString(Long.parseLong(editable))).toString());
                    return;
                } catch (Exception e21) {
                    m16529a(e21);
                    return;
                }
            case 17:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            editable2 = editable2.substring(1);
                            str10 = "-";
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Long.parseLong(editable2, 8))).toString());
                        return;
                    } catch (Exception e22) {
                        m16529a(e22);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        editable = editable.substring(1);
                        str10 = "-";
                    }
                    this.f13947l.setText(new StringBuffer().append(str10).append(Long.toOctalString(Long.parseLong(editable))).toString());
                    return;
                } catch (Exception e23) {
                    m16529a(e23);
                    return;
                }
            case 18:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str9 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str9 = editable2;
                        }
                        if (str9.startsWith("0x")) {
                            str9 = str9.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Long.parseLong(str9, 16))).toString());
                        return;
                    } catch (Exception e24) {
                        m16529a(e24);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        editable = editable.substring(1);
                        str10 = "-";
                    }
                    this.f13947l.setText(new StringBuffer().append(str10).append(Long.toHexString(Long.parseLong(editable))).toString());
                    return;
                } catch (Exception e25) {
                    m16529a(e25);
                    return;
                }
            case 19:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str8 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str8 = editable2;
                        }
                        if (str8.startsWith("0x")) {
                            str8 = str8.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Long.parseLong(str8, 16))).toString());
                        return;
                    } catch (Exception e26) {
                        m16529a(e26);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        editable = editable.substring(1);
                        str10 = "-";
                    }
                    this.f13947l.setText(new StringBuffer().append(new StringBuffer().append(str10).append("0x").toString()).append(Long.toHexString(Long.parseLong(editable))).toString());
                    return;
                } catch (Exception e27) {
                    m16529a(e27);
                    return;
                }
            case 20:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str6 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str6 = editable2;
                        }
                        if (str6.startsWith("0x")) {
                            str6 = str6.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Long.parseLong(str6, 16))).toString());
                        return;
                    } catch (Exception e28) {
                        m16529a(e28);
                        return;
                    }
                }
                try {
                    if (!editable.startsWith("-")) {
                        str7 = "";
                    } else {
                        editable = editable.substring(1);
                        str7 = "-";
                    }
                    String hexString = Long.toHexString(Long.parseLong(editable));
                    for (int length = 8 - hexString.length(); length > 0; length--) {
                        hexString = new StringBuffer().append("0").append(hexString).toString();
                    }
                    this.f13947l.setText(new StringBuffer().append(new StringBuffer().append(str7).append("0x").toString()).append(hexString).toString());
                    return;
                } catch (Exception e29) {
                    m16529a(e29);
                    return;
                }
            case 21:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            editable2 = editable2.substring(1);
                            str10 = "-";
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Float.intBitsToFloat(new Long(Long.parseLong(editable2, 2)).intValue()))).toString());
                        return;
                    } catch (Exception e30) {
                        m16529a(e30);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        editable = editable.substring(1);
                        str10 = "-";
                    }
                    this.f13947l.setText(new StringBuffer().append(str10).append(Long.toBinaryString(Float.floatToIntBits(new Float(Float.parseFloat(editable)).floatValue()))).toString());
                    return;
                } catch (Exception e31) {
                    m16529a(e31);
                    return;
                }
            case 22:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            editable2 = editable2.substring(1);
                            str10 = "-";
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Float.intBitsToFloat(new Long(Long.parseLong(editable2, 8)).intValue()))).toString());
                        return;
                    } catch (Exception e32) {
                        m16529a(e32);
                        return;
                    }
                }
                try {
                    if (editable.startsWith("-")) {
                        str5 = editable.substring(1);
                        str10 = "-";
                    } else {
                        str5 = editable;
                    }
                    this.f13947l.setText(new StringBuffer().append(str10).append(Long.toOctalString(Float.floatToIntBits(new Float(Float.parseFloat(str5)).floatValue()))).toString());
                    return;
                } catch (Exception e33) {
                    m16529a(e33);
                    return;
                }
            case 23:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str4 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str4 = editable2;
                        }
                        if (str4.startsWith("0x")) {
                            str4 = str4.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Float.intBitsToFloat(new Long(Long.parseLong(str4, 16)).intValue()))).toString());
                        return;
                    } catch (Exception e34) {
                        m16529a(e34);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(String.format("%x", new Integer(Float.floatToIntBits(new Float(Float.parseFloat(editable)).floatValue()) & (-1))));
                    return;
                } catch (Exception e35) {
                    m16529a(e35);
                    return;
                }
            case 24:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str3 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str3 = editable2;
                        }
                        if (str3.startsWith("0x")) {
                            str3 = str3.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Float.intBitsToFloat(new Long(Long.parseLong(str3, 16)).intValue()))).toString());
                        return;
                    } catch (Exception e36) {
                        m16529a(e36);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(new StringBuffer().append("0x").append(String.format("%x", new Integer(Float.floatToIntBits(new Float(Float.parseFloat(editable)).floatValue()) & (-1)))).toString());
                    return;
                } catch (Exception e37) {
                    m16529a(e37);
                    return;
                }
            case 25:
                if (this.f13947l.isFocused()) {
                    try {
                        if (editable2.startsWith("-")) {
                            str2 = editable2.substring(1);
                            str10 = "-";
                        } else {
                            str2 = editable2;
                        }
                        if (str2.startsWith("0x")) {
                            str2 = str2.substring(2);
                        }
                        this.f13946k.setText(new StringBuffer().append(str10).append(String.valueOf(Float.intBitsToFloat(new Long(Long.parseLong(str2, 16)).intValue()))).toString());
                        return;
                    } catch (Exception e38) {
                        m16529a(e38);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(new StringBuffer().append("0x").append(String.format("%08x", new Integer(Float.floatToIntBits(new Float(Float.parseFloat(editable)).floatValue()) & (-1)))).toString());
                    return;
                } catch (Exception e39) {
                    m16529a(e39);
                    return;
                }
            case 26:
                if (this.f13947l.isFocused()) {
                    try {
                        this.f13946k.setText(C3080al.m18537a(editable2));
                        return;
                    } catch (Exception e40) {
                        m16529a(e40);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(C3080al.m18581b(editable));
                    return;
                } catch (Exception e41) {
                    m16529a(e41);
                    return;
                }
            case 27:
                if (this.f13947l.isFocused()) {
                    try {
                        this.f13946k.setText(String.format("#%08x", new Integer(Integer.parseInt(editable2) & (-1))));
                        return;
                    } catch (Exception e42) {
                        m16529a(e42);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(String.valueOf(Color.parseColor(new StringBuffer().append(!editable.startsWith("#") ? "#" : "").append(editable).toString())));
                    return;
                } catch (Exception e43) {
                    m16529a(e43);
                    return;
                }
            case 28:
                if (this.f13947l.isFocused()) {
                    try {
                        if (!C3112bn.m19035j(editable2)) {
                            throw new Exception();
                        }
                        this.f13946k.setText(String.format("#%08x", new Integer(C3112bn.m19036k(editable2) & (-1))));
                        return;
                    } catch (Exception e44) {
                        m16529a(e44);
                        return;
                    }
                }
                try {
                    int parseColor = Color.parseColor(new StringBuffer().append(!editable.startsWith("#") ? "#" : "").append(editable).toString());
                    this.f13947l.setText(String.format("%d,%d,%d,%d", new Integer(Color.alpha(parseColor)), new Integer(Color.red(parseColor)), new Integer(Color.green(parseColor)), new Integer(Color.blue(parseColor))));
                    return;
                } catch (Exception e45) {
                    m16529a(e45);
                    return;
                }
            case 29:
                if (this.f13947l.isFocused()) {
                    try {
                        this.f13946k.setText(C3112bn.m18990a(new Long(Long.parseLong(editable2)).longValue(), this.f13955t));
                        return;
                    } catch (Exception e46) {
                        m16529a(e46);
                        return;
                    }
                }
                try {
                    this.f13947l.setText(String.valueOf(C3112bn.m18986a(editable, this.f13955t)));
                    return;
                } catch (Exception e47) {
                    m16529a(e47);
                    return;
                }
            case 30:
                if (this.f13947l.isFocused()) {
                    try {
                        if (!editable2.startsWith("-")) {
                            str = "";
                        } else {
                            str = "-";
                            editable2 = editable2.substring(1);
                        }
                        this.f13946k.setText(C3112bn.m18990a(new Long(Long.parseLong(new StringBuffer().append(str).append(editable2.trim().toLowerCase().replace("0x", "").replaceAll("[^a-f0-9]", "")).toString(), 16)).longValue(), this.f13955t));
                        return;
                    } catch (Exception e48) {
                        m16529a(e48);
                        return;
                    }
                }
                try {
                    long m18986a = C3112bn.m18986a(editable, this.f13955t);
                    if (m18986a >= 0) {
                        stringBuffer = new StringBuffer().append(new StringBuffer().append("0x").append(Long.toHexString(m18986a)).toString()).append("L").toString();
                    } else {
                        stringBuffer = new StringBuffer().append(new StringBuffer().append("-0x").append(Long.toHexString(-m18986a)).toString()).append("L").toString();
                    }
                    this.f13947l.setText(stringBuffer);
                    return;
                } catch (Exception e49) {
                    m16529a(e49);
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m16529a(Throwable th) {
        Editable text = this.f13946k.getText();
        if (text.length() > 0) {
            text.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(), 33);
        }
        Editable text2 = this.f13947l.getText();
        if (text2.length() > 0) {
            text2.setSpan(new ForegroundColorSpan(Color.RED), 0, text2.length(), 33);
        }
    }

    /* renamed from: a */
    public void m16541a(String str) {
        int i = -16777216;
        int i2 = 1;
        if (str != null && !str.isEmpty()) {
            try {
                if (C3112bn.m19035j(str)) {
                    str = String.format("#%08x", new Integer(C3112bn.m19036k(str) & (-1)));
                } else if (!str.startsWith("#")) {
                    str = new StringBuffer().append("#").append(str).toString();
                }
                StringBuilder sb = new StringBuilder();
                if (str.length() == 5) {
                    sb.append("#");
                    while (i2 < 5) {
                        sb.append(str.charAt(i2)).append(str.charAt(i2));
                        i2++;
                    }
                } else if (str.length() == 4) {
                    sb.append("#");
                    while (i2 < 4) {
                        sb.append(str.charAt(i2)).append(str.charAt(i2));
                        i2++;
                    }
                } else {
                    sb.append(str);
                }
                i = Color.parseColor(sb.toString());
            } catch (Exception e2) {
            }
        }
        new C3321c(this).m20105a(i).m20108b(getString(R.string.select_color)).m20107a(new C3321c.a(this) { // from class: ru.maximoff.apktool.Converter.9

            /* renamed from: a */
            private final Converter f13973a;

            {
                this.f13973a = this;
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16419a() {
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16421a(String str2) {
                this.f13973a.f13946k.requestFocus();
                this.f13973a.f13946k.setText(str2);
                this.f13973a.f13946k.setSelection(str2.length());
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: a */
            public void mo16420a(int i3) {
                if (this.f13973a.f13945j.getSelectedItemPosition() == 27) {
                    this.f13973a.f13947l.setText(String.valueOf(i3));
                } else if (this.f13973a.f13945j.getSelectedItemPosition() == 28) {
                    this.f13973a.f13947l.setText(String.format("%d,%d,%d,%d", new Integer(Color.alpha(i3)), new Integer(Color.red(i3)), new Integer(Color.green(i3)), new Integer(Color.blue(i3))));
                }
            }

            @Override // ru.maximoff.color.C3321c.a
            /* renamed from: b */
            public void mo16422b(String str2) {
                if (this.f13973a.f13945j.getSelectedItemPosition() == 26) {
                    this.f13973a.f13947l.setText(str2);
                }
            }
        }).m20104a().m20109b();
    }

    /* renamed from: p */
    private void m16540p() {
        View inflate = getLayoutInflater().inflate(R.layout.rename_one, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setText(C3102bd.m18910a(this, "converter_date_fmt", "HH:mm:ss dd.MM.yyyy"));
        editText.setHint("HH:mm:ss dd.MM.yyyy");
        AlertDialog create = new AlertDialog.Builder(this).setTitle(R.string.date_format).setView(inflate).setPositiveButton(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.Converter.10

            /* renamed from: a */
            private final Converter f13957a;

            /* renamed from: b */
            private final EditText f13958b;

            {
                this.f13957a = this;
                this.f13958b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13957a.f13955t = this.f13958b.getText().toString();
                C3102bd.m18937b(this.f13957a, "converter_date_fmt", this.f13957a.f13955t);
                this.f13957a.m16539o();
                dialogInterface.dismiss();
            }
        }).setNeutralButton(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.Converter.11

            /* renamed from: a */
            private final Converter f13959a;

            {
                this.f13959a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13959a.f13955t = "HH:mm:ss dd.MM.yyyy";
                C3102bd.m18924a(this.f13959a, "converter_date_fmt");
                this.f13959a.m16539o();
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        create.getWindow().setSoftInputMode(4);
        create.setOnShowListener(new DialogInterface.OnShowListener(this, create, editText) { // from class: ru.maximoff.apktool.Converter.12

            /* renamed from: a */
            private final Converter f13960a;

            /* renamed from: b */
            private final AlertDialog f13961b;

            /* renamed from: c */
            private final EditText f13962c;

            {
                this.f13960a = this;
                this.f13961b = create;
                this.f13962c = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button button = this.f13961b.getButton(-1);
                button.setEnabled(this.f13962c.getText().length() > 0);
                this.f13962c.addTextChangedListener(new TextWatcher(this, button) { // from class: ru.maximoff.apktool.Converter.12.1

                    /* renamed from: a */
                    private final DialogInterfaceOnShowListenerC269612 f13963a;

                    /* renamed from: b */
                    private final Button f13964b;

                    {
                        this.f13963a = this;
                        this.f13964b = button;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        this.f13964b.setEnabled(editable.length() > 0);
                    }
                });
                this.f13962c.requestFocus();
                this.f13962c.selectAll();
            }
        });
        create.show();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        String str;
        int selectedItemPosition = this.f13945j.getSelectedItemPosition();
        if (selectedItemPosition >= 29 && selectedItemPosition <= 30) {
            try {
                str = C3112bn.m19032g(this.f13955t);
            } catch (Exception e2) {
                str = "00:00:00 01.01.1970";
            }
            menu.findItem(R.id.cur_date).setTitle(str);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        String str;
        boolean z = false;
        getMenuInflater().inflate(R.menu.converter, menu);
        boolean m18925a = C3102bd.m18925a((Context) this, "converter_hex", false);
        if (C3102bd.f18291a) {
            menu.findItem(R.id.reset).setIcon(R.drawable.ic_reload);
            menu.findItem(R.id.color_picker).setIcon(R.drawable.ic_palette_black);
            menu.findItem(R.id.hex).setIcon(m18925a ? R.drawable.ic_hexe : R.drawable.ic_hexd);
        } else {
            menu.findItem(R.id.reset).setIcon(R.drawable.ic_reload_dark);
            menu.findItem(R.id.color_picker).setIcon(R.drawable.ic_palette_white);
            menu.findItem(R.id.hex).setIcon(m18925a ? R.drawable.ic_hexe_dark : R.drawable.ic_hexd_dark);
        }
        int selectedItemPosition = this.f13945j.getSelectedItemPosition();
        menu.findItem(R.id.color_picker).setVisible(selectedItemPosition >= 26 && selectedItemPosition <= 28);
        menu.findItem(R.id.hex).setVisible(selectedItemPosition >= 9 && selectedItemPosition <= 15);
        MenuItem findItem = menu.findItem(R.id.smali);
        findItem.setVisible(selectedItemPosition >= 9 && selectedItemPosition <= 15);
        findItem.setChecked(this.f13954s);
        findItem.setEnabled(!m18925a);
        menu.findItem(R.id.date_fmt).setVisible(selectedItemPosition >= 29 && selectedItemPosition <= 30);
        MenuItem findItem2 = menu.findItem(R.id.cur_date);
        if (selectedItemPosition >= 29 && selectedItemPosition <= 30) {
            z = true;
        }
        findItem2.setVisible(z);
        try {
            str = C3112bn.m19032g(this.f13955t);
        } catch (Exception e2) {
            str = "00:00:00 01.01.1970";
        }
        findItem2.setTitle(str);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        return true;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.reset /* 2131690190 */:
                this.f13946k.setText("");
                this.f13947l.setText("");
                this.f13946k.requestFocus();
                break;
            case R.id.color_picker /* 2131690201 */:
                m16541a(this.f13946k.getText().toString());
                break;
            case R.id.hex /* 2131690202 */:
                C3102bd.m18938b(this, "converter_hex", C3102bd.m18925a((Context) this, "converter_hex", false) ? false : true);
                m16539o();
                invalidateOptionsMenu();
                break;
            case R.id.smali /* 2131690203 */:
                this.f13954s = menuItem.isChecked() ? false : true;
                C3102bd.m18938b(this, "con4smali", this.f13954s);
                m16539o();
                invalidateOptionsMenu();
                break;
            case R.id.date_fmt /* 2131690204 */:
                m16540p();
                break;
            case R.id.cur_date /* 2131690205 */:
                CharSequence title = menuItem.getTitle();
                this.f13946k.requestFocus();
                this.f13946k.setText(title);
                this.f13946k.setSelection(title.length());
                break;
        }
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f13952q > 2000) {
            C3112bn.m18999a(this.f13944i, R.string.click_once_more);
            this.f13952q = currentTimeMillis;
        } else {
            finish();
        }
    }
}
