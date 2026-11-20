package ru.maximoff.apktool;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FilenameFilter;
import ru.maximoff.apktool.util.C3085aq;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3114bp;

/* loaded from: classes.dex */
public class CrashActivity extends AbstractActivityC2894b {
    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crash);
        C3114bp c3114bp = new C3114bp(this);
        String m19044a = c3114bp.m19044a();
        if (m19044a == null) {
            C3112bn.m18999a(this, R.string.empty);
            finish();
            return;
        }
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "monospace.ttf");
        TextView textView = (TextView) findViewById(R.id.crashTextView1);
        Button button = (Button) findViewById(R.id.crashButton1);
        Button button2 = (Button) findViewById(R.id.crashButton2);
        Button button3 = (Button) findViewById(R.id.crashButton3);
        if (C3085aq.m18667a() && !C3085aq.m18669c()) {
            button3.setEnabled(false);
        } else {
            button3.setEnabled(m19044a.indexOf("java.lang.OutOfMemoryError") == -1);
        }
        textView.setTypeface(createFromAsset);
        textView.setText(m19044a);
        button.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.CrashActivity.1

            /* renamed from: a */
            private final CrashActivity f13974a;

            {
                this.f13974a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                File[] listFiles = this.f13974a.getExternalFilesDir((String) null).listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.CrashActivity.1.1

                    /* renamed from: a */
                    private final ViewOnClickListenerC27051 f13975a;

                    {
                        this.f13975a = this;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        return str.endsWith(".txt");
                    }
                });
                if (listFiles != null) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
                this.f13974a.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(this, m19044a) { // from class: ru.maximoff.apktool.CrashActivity.2

            /* renamed from: a */
            private final CrashActivity f13976a;

            /* renamed from: b */
            private final String f13977b;

            {
                this.f13976a = this;
                this.f13977b = m19044a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3112bn.m19002a(this.f13976a, this.f13977b);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(this, c3114bp) { // from class: ru.maximoff.apktool.CrashActivity.3

            /* renamed from: a */
            private final CrashActivity f13978a;

            /* renamed from: b */
            private final C3114bp f13979b;

            {
                this.f13978a = this;
                this.f13979b = c3114bp;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Button[] buttonArr = new Button[1];
                View inflate = this.f13978a.getLayoutInflater().inflate(R.layout.report, (ViewGroup) null);
                EditText editText = (EditText) inflate.findViewById(R.id.reportEditText1);
                editText.addTextChangedListener(new TextWatcher(this, buttonArr) { // from class: ru.maximoff.apktool.CrashActivity.3.1

                    /* renamed from: a */
                    private final ViewOnClickListenerC27073 f13980a;

                    /* renamed from: b */
                    private final Button[] f13981b;

                    {
                        this.f13980a = this;
                        this.f13981b = buttonArr;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (this.f13981b[0] != null) {
                            this.f13981b[0].setEnabled(editable.length() > 0);
                        }
                    }
                });
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f13978a).m418a(R.string.send_log).m435b(inflate).m420a(R.string.send, new DialogInterface.OnClickListener(this, this.f13979b, editText) { // from class: ru.maximoff.apktool.CrashActivity.3.2

                    /* renamed from: a */
                    private final ViewOnClickListenerC27073 f13982a;

                    /* renamed from: b */
                    private final C3114bp f13983b;

                    /* renamed from: c */
                    private final EditText f13984c;

                    {
                        this.f13982a = this;
                        this.f13983b = r2;
                        this.f13984c = editText;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f13983b.m19045a(this.f13984c.getText().toString());
                        dialogInterface.dismiss();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                m438b.getWindow().setSoftInputMode(4);
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.CrashActivity.3.3

                    /* renamed from: a */
                    private final ViewOnClickListenerC27073 f13985a;

                    /* renamed from: b */
                    private final Button[] f13986b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f13987c;

                    /* renamed from: d */
                    private final EditText f13988d;

                    {
                        this.f13985a = this;
                        this.f13986b = buttonArr;
                        this.f13987c = m438b;
                        this.f13988d = editText;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        this.f13986b[0] = this.f13987c.m414a(-1);
                        this.f13986b[0].setEnabled(false);
                        this.f13988d.requestFocus();
                    }
                });
                m438b.show();
            }
        });
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
    }
}
