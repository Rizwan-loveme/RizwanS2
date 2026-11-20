package ru.maximoff.apktool.util;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaCodec;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AsyncTaskC2915aq;

/* compiled from: KillerSettings.java */
/* renamed from: ru.maximoff.apktool.util.af */
/* loaded from: classes.dex */
public class C3074af {

    /* renamed from: a */
    public static final String f17349a = C3257q.m19520b("U1BcGl5EGkZfVV9YRkFBVRp+X15dXEB1Q0BYXFVTRVBdWg==", String.valueOf(1924304562));

    /* renamed from: a */
    public static void m18463a(Context context, InterfaceC2995n interfaceC2995n, File file) {
        if (C3102bd.m18925a(context, "kill_sign_extended", false)) {
            m18465c(context, interfaceC2995n, file);
        } else {
            m18464b(context, interfaceC2995n, file);
        }
    }

    /* renamed from: b */
    public static void m18464b(Context context, InterfaceC2995n interfaceC2995n, File file) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.killer_dialog, (ViewGroup) null);
        String[] strArr = {file.getAbsolutePath()};
        String[] stringArray = context.getResources().getStringArray(R.array.keys);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.killerdialogSpinner1);
        int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
        boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
        String[] strArr2 = new String[m18925a ? 3 : 2];
        strArr2[0] = context.getString(R.string.not_sign);
        strArr2[1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
        if (m18925a) {
            strArr2[2] = context.getString(R.string.custom_signature_file);
        } else if (m18905a > 1) {
            m18905a = 1;
        }
        C3102bd.f18317ay = (boolean[]) null;
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr2));
        spinner.setSelection(m18905a);
        spinner.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner, strArr2) { // from class: ru.maximoff.apktool.util.af.1

            /* renamed from: a */
            private final String[] f17350a;

            /* renamed from: b */
            private final Context f17351b;

            /* renamed from: c */
            private final Spinner f17352c;

            /* renamed from: d */
            private final String[] f17353d;

            {
                this.f17350a = stringArray;
                this.f17351b = context;
                this.f17352c = spinner;
                this.f17353d = strArr2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f17350a.length) {
                        i = -1;
                        break;
                    }
                    if (this.f17350a[i2].equals(C3102bd.f18324g)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                new DialogInterfaceC0070b.a(this.f17351b).m418a(R.string.default_key).m430a(this.f17350a, i, new DialogInterface.OnClickListener(this, this.f17351b, this.f17350a, this.f17352c, this.f17353d) { // from class: ru.maximoff.apktool.util.af.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f17354a;

                    /* renamed from: b */
                    private final Context f17355b;

                    /* renamed from: c */
                    private final String[] f17356c;

                    /* renamed from: d */
                    private final Spinner f17357d;

                    /* renamed from: e */
                    private final String[] f17358e;

                    {
                        this.f17354a = this;
                        this.f17355b = r2;
                        this.f17356c = r3;
                        this.f17357d = r4;
                        this.f17358e = r5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        C3102bd.m18937b(this.f17355b, "default_key", this.f17356c[i3]);
                        C3102bd.f18324g = this.f17356c[i3];
                        try {
                            C3102bd.m18919a(this.f17355b.getAssets(), this.f17355b.getFilesDir());
                            String string = this.f17355b.getString(R.string.default_signature_file);
                            int selectedItemPosition = this.f17357d.getSelectedItemPosition();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= this.f17358e.length) {
                                    i4 = selectedItemPosition;
                                    break;
                                } else if (!this.f17358e[i4].startsWith(string)) {
                                    i4++;
                                } else {
                                    this.f17358e[i4] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                    break;
                                }
                            }
                            this.f17357d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f17355b, C0012R.layout.simple_spinner_dropdown_item, this.f17358e));
                            this.f17357d.setSelection(i4);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f17355b, R.string.error);
                        }
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                return true;
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.killerdialogImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_settings_light);
        } else {
            imageView.setImageResource(R.drawable.ic_settings_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.af.2

            /* renamed from: a */
            private final Context f17449a;

            {
                this.f17449a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3080al.m18598f(this.f17449a);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.killerdialogTextView3);
        C3112bn.m19009a(textView, context.getString(R.string.kill_sign_ex_mode));
        TextView textView2 = (TextView) inflate.findViewById(R.id.killerdialogTextView1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.killerdialogTextView2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox0);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox1);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox2);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox3);
        CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox4);
        CheckBox checkBox6 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox5);
        CheckBox checkBox7 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox6);
        CheckBox checkBox8 = (CheckBox) inflate.findViewById(R.id.killerdialogCheckBox7);
        EditText editText = (EditText) inflate.findViewById(R.id.killerdialogEditText1);
        checkBox.setChecked(true);
        checkBox.setEnabled(false);
        checkBox2.setChecked(C3102bd.m18925a(context, "kill_sign_advanced", false));
        checkBox3.setEnabled(checkBox2.isChecked());
        checkBox3.setChecked(C3102bd.m18925a(context, "kill_sign_orig", false));
        textView2.setText(context.getString(R.string.originalf, ""));
        textView2.setEnabled(checkBox2.isChecked() && checkBox3.isChecked());
        textView3.setEnabled(checkBox2.isChecked() && checkBox3.isChecked());
        checkBox6.setChecked(C3102bd.m18925a(context, "kill_sign_rand", false));
        checkBox6.setEnabled(!checkBox3.isChecked());
        checkBox7.setChecked(C3102bd.m18925a(context, "kill_sign_installer", true));
        checkBox8.setChecked(C3102bd.m18925a(context, "kill_sign_rand_apk", true));
        checkBox8.setEnabled(checkBox2.isChecked() && checkBox3.isChecked());
        editText.setText(C3102bd.m18910a(context, "kill_sign_installer_name", "com.android.vending"));
        editText.setHint("com.android.vending");
        editText.setEnabled(checkBox7.isChecked());
        if (checkBox2.isChecked() && checkBox3.isChecked()) {
            C3112bn.m19009a(textView3, file.getName());
        } else {
            textView3.setText(file.getName());
        }
        textView3.setOnClickListener(new View.OnClickListener(checkBox2, checkBox3, checkBox4, checkBox5, context, strArr, textView3) { // from class: ru.maximoff.apktool.util.af.3

            /* renamed from: a */
            private final CheckBox f17545a;

            /* renamed from: b */
            private final CheckBox f17546b;

            /* renamed from: c */
            private final CheckBox f17547c;

            /* renamed from: d */
            private final CheckBox f17548d;

            /* renamed from: e */
            private final Context f17549e;

            /* renamed from: f */
            private final String[] f17550f;

            /* renamed from: g */
            private final TextView f17551g;

            {
                this.f17545a = checkBox2;
                this.f17546b = checkBox3;
                this.f17547c = checkBox4;
                this.f17548d = checkBox5;
                this.f17549e = context;
                this.f17550f = strArr;
                this.f17551g = textView3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((this.f17545a.isChecked() && this.f17546b.isChecked()) || this.f17547c.isChecked() || this.f17548d.isChecked()) {
                    C3261t c3261t = new C3261t(this.f17549e);
                    Runnable runnable = new Runnable(this, c3261t, this.f17550f, this.f17551g) { // from class: ru.maximoff.apktool.util.af.3.1

                        /* renamed from: a */
                        private final AnonymousClass3 f17552a;

                        /* renamed from: b */
                        private final C3261t f17553b;

                        /* renamed from: c */
                        private final String[] f17554c;

                        /* renamed from: d */
                        private final TextView f17555d;

                        {
                            this.f17552a = this;
                            this.f17553b = c3261t;
                            this.f17554c = r3;
                            this.f17555d = r4;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            File file2 = new File(this.f17553b.getPath());
                            this.f17554c[0] = file2.getAbsolutePath();
                            C3112bn.m19009a(this.f17555d, file2.getName());
                        }
                    };
                    c3261t.m19545a("_killer");
                    c3261t.setCallback(runnable);
                    c3261t.setFilter(new String[]{"apk", "apks", "apkm", "xapk", "zip"});
                    c3261t.m19546a(true);
                    c3261t.m19550e();
                    DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f17549e);
                    aVar.m427a(c3261t.m19548c());
                    aVar.m435b(c3261t);
                    aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
                    aVar.m437b("/...", (DialogInterface.OnClickListener) null);
                    aVar.m429a(false);
                    aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.af.3.2

                        /* renamed from: a */
                        private final AnonymousClass3 f17556a;

                        /* renamed from: b */
                        private final C3261t f17557b;

                        {
                            this.f17556a = this;
                            this.f17557b = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            boolean m19551f = this.f17557b.m19551f();
                            if (!m19551f) {
                                dialogInterface.dismiss();
                                return m19551f;
                            }
                            return m19551f;
                        }
                    });
                    DialogInterfaceC0070b m438b = aVar.m438b();
                    m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f17549e, c3261t) { // from class: ru.maximoff.apktool.util.af.3.3

                        /* renamed from: a */
                        private final AnonymousClass3 f17558a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f17559b;

                        /* renamed from: c */
                        private final Context f17560c;

                        /* renamed from: d */
                        private final C3261t f17561d;

                        {
                            this.f17558a = this;
                            this.f17559b = m438b;
                            this.f17560c = r3;
                            this.f17561d = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            Button m414a = this.f17559b.m414a(-3);
                            m414a.setOnClickListener(new View.OnClickListener(this, this.f17560c, this.f17561d) { // from class: ru.maximoff.apktool.util.af.3.3.1

                                /* renamed from: a */
                                private final DialogInterfaceOnShowListenerC34293 f17562a;

                                /* renamed from: b */
                                private final Context f17563b;

                                /* renamed from: c */
                                private final C3261t f17564c;

                                {
                                    this.f17562a = this;
                                    this.f17563b = r2;
                                    this.f17564c = r3;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    int i;
                                    String[] m19640b = C3262u.m19640b(this.f17563b);
                                    if (m19640b != null) {
                                        C0173ao c0173ao = new C0173ao(this.f17563b, view2);
                                        if (C3102bd.m18910a(this.f17563b, "menu_position", "1").equals("0")) {
                                            i = 3;
                                        } else {
                                            i = 5;
                                        }
                                        c0173ao.m1340a(i);
                                        for (int i2 = 0; i2 < m19640b.length; i2++) {
                                            c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17564c) { // from class: ru.maximoff.apktool.util.af.3.3.1.1

                                                /* renamed from: a */
                                                private final AnonymousClass1 f17565a;

                                                /* renamed from: b */
                                                private final C3261t f17566b;

                                                {
                                                    this.f17565a = this;
                                                    this.f17566b = r2;
                                                }

                                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                                public boolean onMenuItemClick(MenuItem menuItem) {
                                                    this.f17566b.m19544a(new File(menuItem.getTitle().toString()));
                                                    return true;
                                                }
                                            });
                                        }
                                        c0173ao.m1344c();
                                    }
                                }
                            });
                            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f17561d, this.f17560c) { // from class: ru.maximoff.apktool.util.af.3.3.2

                                /* renamed from: a */
                                private final DialogInterfaceOnShowListenerC34293 f17567a;

                                /* renamed from: b */
                                private final C3261t f17568b;

                                /* renamed from: c */
                                private final Context f17569c;

                                {
                                    this.f17567a = this;
                                    this.f17568b = r2;
                                    this.f17569c = r3;
                                }

                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view2) {
                                    int i;
                                    List<String> m19205b = this.f17568b.m19549d().m19205b();
                                    if (m19205b.isEmpty()) {
                                        return false;
                                    }
                                    C0173ao c0173ao = new C0173ao(this.f17569c, view2);
                                    if (C3102bd.m18910a(this.f17569c, "menu_position", "1").equals("0")) {
                                        i = 3;
                                    } else {
                                        i = 5;
                                    }
                                    c0173ao.m1340a(i);
                                    Iterator<String> it = m19205b.iterator();
                                    while (it.hasNext()) {
                                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17568b) { // from class: ru.maximoff.apktool.util.af.3.3.2.1

                                            /* renamed from: a */
                                            private final AnonymousClass2 f17570a;

                                            /* renamed from: b */
                                            private final C3261t f17571b;

                                            {
                                                this.f17570a = this;
                                                this.f17571b = r2;
                                            }

                                            @Override // android.view.MenuItem.OnMenuItemClickListener
                                            public boolean onMenuItemClick(MenuItem menuItem) {
                                                this.f17571b.m19544a(new File(menuItem.getTitle().toString()));
                                                return true;
                                            }
                                        });
                                    }
                                    c0173ao.m1344c();
                                    return true;
                                }
                            });
                        }
                    });
                    c3261t.setDialog(m438b);
                    m438b.show();
                }
            }
        });
        textView3.setOnLongClickListener(new View.OnLongClickListener(checkBox2, checkBox3, checkBox4, checkBox5, strArr, file, textView3) { // from class: ru.maximoff.apktool.util.af.4

            /* renamed from: a */
            private final CheckBox f17572a;

            /* renamed from: b */
            private final CheckBox f17573b;

            /* renamed from: c */
            private final CheckBox f17574c;

            /* renamed from: d */
            private final CheckBox f17575d;

            /* renamed from: e */
            private final String[] f17576e;

            /* renamed from: f */
            private final File f17577f;

            /* renamed from: g */
            private final TextView f17578g;

            {
                this.f17572a = checkBox2;
                this.f17573b = checkBox3;
                this.f17574c = checkBox4;
                this.f17575d = checkBox5;
                this.f17576e = strArr;
                this.f17577f = file;
                this.f17578g = textView3;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!((this.f17572a.isChecked() && this.f17573b.isChecked()) || this.f17574c.isChecked() || this.f17575d.isChecked())) {
                    return false;
                }
                this.f17576e[0] = this.f17577f.getAbsolutePath();
                C3112bn.m19009a(this.f17578g, this.f17577f.getName());
                return true;
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener(checkBox2, checkBox3, checkBox6, checkBox8, checkBox4, checkBox5, textView2, textView3, strArr, context) { // from class: ru.maximoff.apktool.util.af.5

            /* renamed from: a */
            private final CheckBox f17579a;

            /* renamed from: b */
            private final CheckBox f17580b;

            /* renamed from: c */
            private final CheckBox f17581c;

            /* renamed from: d */
            private final CheckBox f17582d;

            /* renamed from: e */
            private final CheckBox f17583e;

            /* renamed from: f */
            private final CheckBox f17584f;

            /* renamed from: g */
            private final TextView f17585g;

            /* renamed from: h */
            private final TextView f17586h;

            /* renamed from: i */
            private final String[] f17587i;

            /* renamed from: j */
            private final Context f17588j;

            {
                this.f17579a = checkBox2;
                this.f17580b = checkBox3;
                this.f17581c = checkBox6;
                this.f17582d = checkBox8;
                this.f17583e = checkBox4;
                this.f17584f = checkBox5;
                this.f17585g = textView2;
                this.f17586h = textView3;
                this.f17587i = strArr;
                this.f17588j = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = true;
                if (this.f17579a.isChecked()) {
                    this.f17580b.setEnabled(true);
                    this.f17581c.setEnabled(!this.f17580b.isChecked());
                    this.f17582d.setEnabled(this.f17580b.isChecked());
                } else {
                    this.f17580b.setEnabled(false);
                    this.f17581c.setEnabled(true);
                    this.f17582d.setEnabled(false);
                }
                if ((!this.f17579a.isChecked() || !this.f17580b.isChecked()) && !this.f17583e.isChecked() && !this.f17584f.isChecked()) {
                    z = false;
                }
                this.f17585g.setEnabled(z);
                this.f17586h.setEnabled(z);
                File file2 = new File(this.f17587i[0]);
                if (z) {
                    C3112bn.m19009a(this.f17586h, file2.getName());
                } else {
                    this.f17586h.setText(file2.getName());
                }
                if (!this.f17579a.isChecked() || Build.VERSION.SDK_INT >= 21 || C3102bd.m18925a(this.f17588j, "kill_sign_notice", false)) {
                    return;
                }
                new DialogInterfaceC0070b.a(this.f17588j).m418a(R.string.attention).m433b(R.string.kill_sign_notice).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.not_remind, new DialogInterface.OnClickListener(this, this.f17588j) { // from class: ru.maximoff.apktool.util.af.5.1

                    /* renamed from: a */
                    private final AnonymousClass5 f17589a;

                    /* renamed from: b */
                    private final Context f17590b;

                    {
                        this.f17589a = this;
                        this.f17590b = r2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18938b(this.f17590b, "kill_sign_notice", true);
                        dialogInterface.dismiss();
                    }
                }).m438b().show();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener(checkBox6, checkBox3, checkBox8, checkBox2, checkBox4, checkBox5, textView2, textView3, strArr) { // from class: ru.maximoff.apktool.util.af.6

            /* renamed from: a */
            private final CheckBox f17591a;

            /* renamed from: b */
            private final CheckBox f17592b;

            /* renamed from: c */
            private final CheckBox f17593c;

            /* renamed from: d */
            private final CheckBox f17594d;

            /* renamed from: e */
            private final CheckBox f17595e;

            /* renamed from: f */
            private final CheckBox f17596f;

            /* renamed from: g */
            private final TextView f17597g;

            /* renamed from: h */
            private final TextView f17598h;

            /* renamed from: i */
            private final String[] f17599i;

            {
                this.f17591a = checkBox6;
                this.f17592b = checkBox3;
                this.f17593c = checkBox8;
                this.f17594d = checkBox2;
                this.f17595e = checkBox4;
                this.f17596f = checkBox5;
                this.f17597g = textView2;
                this.f17598h = textView3;
                this.f17599i = strArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = true;
                this.f17591a.setEnabled(!this.f17592b.isChecked());
                this.f17593c.setEnabled(this.f17592b.isChecked());
                if ((!this.f17594d.isChecked() || !this.f17592b.isChecked()) && !this.f17595e.isChecked() && !this.f17596f.isChecked()) {
                    z = false;
                }
                this.f17597g.setEnabled(z);
                this.f17598h.setEnabled(z);
                File file2 = new File(this.f17599i[0]);
                if (z) {
                    C3112bn.m19009a(this.f17598h, file2.getName());
                } else {
                    this.f17598h.setText(file2.getName());
                }
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener(checkBox2, checkBox3, checkBox4, checkBox5, textView2, textView3, strArr) { // from class: ru.maximoff.apktool.util.af.7

            /* renamed from: a */
            private final CheckBox f17600a;

            /* renamed from: b */
            private final CheckBox f17601b;

            /* renamed from: c */
            private final CheckBox f17602c;

            /* renamed from: d */
            private final CheckBox f17603d;

            /* renamed from: e */
            private final TextView f17604e;

            /* renamed from: f */
            private final TextView f17605f;

            /* renamed from: g */
            private final String[] f17606g;

            {
                this.f17600a = checkBox2;
                this.f17601b = checkBox3;
                this.f17602c = checkBox4;
                this.f17603d = checkBox5;
                this.f17604e = textView2;
                this.f17605f = textView3;
                this.f17606g = strArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = (this.f17600a.isChecked() && this.f17601b.isChecked()) || this.f17602c.isChecked() || this.f17603d.isChecked();
                this.f17604e.setEnabled(z);
                this.f17605f.setEnabled(z);
                File file2 = new File(this.f17606g[0]);
                if (z) {
                    C3112bn.m19009a(this.f17605f, file2.getName());
                } else {
                    this.f17605f.setText(file2.getName());
                }
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener(checkBox, checkBox2, checkBox3, checkBox4, checkBox5, textView2, textView3, strArr) { // from class: ru.maximoff.apktool.util.af.8

            /* renamed from: a */
            private final CheckBox f17607a;

            /* renamed from: b */
            private final CheckBox f17608b;

            /* renamed from: c */
            private final CheckBox f17609c;

            /* renamed from: d */
            private final CheckBox f17610d;

            /* renamed from: e */
            private final CheckBox f17611e;

            /* renamed from: f */
            private final TextView f17612f;

            /* renamed from: g */
            private final TextView f17613g;

            /* renamed from: h */
            private final String[] f17614h;

            {
                this.f17607a = checkBox;
                this.f17608b = checkBox2;
                this.f17609c = checkBox3;
                this.f17610d = checkBox4;
                this.f17611e = checkBox5;
                this.f17612f = textView2;
                this.f17613g = textView3;
                this.f17614h = strArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = true;
                this.f17607a.setChecked(true);
                this.f17608b.setEnabled(true);
                this.f17609c.setEnabled(true);
                this.f17610d.setEnabled(true);
                this.f17607a.setEnabled(this.f17611e.isChecked());
                if ((!this.f17608b.isChecked() || !this.f17609c.isChecked()) && !this.f17610d.isChecked() && !this.f17611e.isChecked()) {
                    z = false;
                }
                this.f17612f.setEnabled(z);
                this.f17613g.setEnabled(z);
                File file2 = new File(this.f17614h[0]);
                if (z) {
                    C3112bn.m19009a(this.f17613g, file2.getName());
                } else {
                    this.f17613g.setText(file2.getName());
                }
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener(editText, checkBox7) { // from class: ru.maximoff.apktool.util.af.9

            /* renamed from: a */
            private final EditText f17615a;

            /* renamed from: b */
            private final CheckBox f17616b;

            {
                this.f17615a = editText;
                this.f17616b = checkBox7;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f17615a.setEnabled(this.f17616b.isChecked());
            }
        });
        checkBox7.setOnLongClickListener(new View.OnLongClickListener(editText) { // from class: ru.maximoff.apktool.util.af.10

            /* renamed from: a */
            private final EditText f17359a;

            {
                this.f17359a = editText;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f17359a.setText("com.android.vending");
                this.f17359a.setSelection(this.f17359a.getText().length());
                return true;
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener(checkBox, checkBox2, checkBox3, checkBox4, checkBox6, checkBox7, editText, checkBox8) { // from class: ru.maximoff.apktool.util.af.11

            /* renamed from: a */
            private final CheckBox f17360a;

            /* renamed from: b */
            private final CheckBox f17361b;

            /* renamed from: c */
            private final CheckBox f17362c;

            /* renamed from: d */
            private final CheckBox f17363d;

            /* renamed from: e */
            private final CheckBox f17364e;

            /* renamed from: f */
            private final CheckBox f17365f;

            /* renamed from: g */
            private final EditText f17366g;

            /* renamed from: h */
            private final CheckBox f17367h;

            {
                this.f17360a = checkBox;
                this.f17361b = checkBox2;
                this.f17362c = checkBox3;
                this.f17363d = checkBox4;
                this.f17364e = checkBox6;
                this.f17365f = checkBox7;
                this.f17366g = editText;
                this.f17367h = checkBox8;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean isChecked = this.f17360a.isChecked();
                this.f17361b.setEnabled(isChecked);
                this.f17362c.setEnabled(isChecked && this.f17361b.isChecked());
                this.f17363d.setEnabled(isChecked);
                this.f17364e.setEnabled(isChecked && !(this.f17362c.isEnabled() && this.f17362c.isChecked()));
                this.f17365f.setEnabled(isChecked);
                this.f17366g.setEnabled(isChecked && this.f17365f.isChecked());
                this.f17367h.setEnabled(isChecked && this.f17362c.isChecked() && this.f17362c.isEnabled());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.kill_sign).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(spinner, checkBox2, checkBox6, checkBox3, context, checkBox7, checkBox8, editText, interfaceC2995n, file, checkBox, checkBox5, strArr, checkBox4) { // from class: ru.maximoff.apktool.util.af.12

            /* renamed from: a */
            private final Spinner f17368a;

            /* renamed from: b */
            private final CheckBox f17369b;

            /* renamed from: c */
            private final CheckBox f17370c;

            /* renamed from: d */
            private final CheckBox f17371d;

            /* renamed from: e */
            private final Context f17372e;

            /* renamed from: f */
            private final CheckBox f17373f;

            /* renamed from: g */
            private final CheckBox f17374g;

            /* renamed from: h */
            private final EditText f17375h;

            /* renamed from: i */
            private final InterfaceC2995n f17376i;

            /* renamed from: j */
            private final File f17377j;

            /* renamed from: k */
            private final CheckBox f17378k;

            /* renamed from: l */
            private final CheckBox f17379l;

            /* renamed from: m */
            private final String[] f17380m;

            /* renamed from: n */
            private final CheckBox f17381n;

            {
                this.f17368a = spinner;
                this.f17369b = checkBox2;
                this.f17370c = checkBox6;
                this.f17371d = checkBox3;
                this.f17372e = context;
                this.f17373f = checkBox7;
                this.f17374g = checkBox8;
                this.f17375h = editText;
                this.f17376i = interfaceC2995n;
                this.f17377j = file;
                this.f17378k = checkBox;
                this.f17379l = checkBox5;
                this.f17380m = strArr;
                this.f17381n = checkBox4;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int selectedItemPosition = this.f17368a.getSelectedItemPosition();
                boolean isChecked = this.f17369b.isChecked();
                boolean z = this.f17370c.isChecked() && this.f17370c.isEnabled();
                boolean z2 = this.f17371d.isChecked() && isChecked;
                C3102bd.m18938b(this.f17372e, "kill_sign_advanced", isChecked);
                C3102bd.m18938b(this.f17372e, "kill_sign_orig", z2);
                C3102bd.m18935b(this.f17372e, "selected_signature", selectedItemPosition);
                C3102bd.m18938b(this.f17372e, "kill_sign_installer", this.f17373f.isChecked());
                if (this.f17370c.isEnabled()) {
                    C3102bd.m18938b(this.f17372e, "kill_sign_rand", z);
                }
                if (this.f17374g.isEnabled()) {
                    C3102bd.m18938b(this.f17372e, "kill_sign_rand_apk", this.f17374g.isChecked());
                }
                String str = (String) null;
                if (this.f17373f.isChecked() && this.f17373f.isEnabled()) {
                    str = this.f17375h.getText().toString();
                    if (C3112bn.m19040o(str)) {
                        str = "com.android.vending";
                    }
                    C3102bd.m18937b(this.f17372e, "kill_sign_installer_name", str);
                }
                AsyncTaskC2915aq asyncTaskC2915aq = new AsyncTaskC2915aq(this.f17372e, this.f17376i, new C3081am(this.f17377j));
                asyncTaskC2915aq.m17294i(this.f17378k.isChecked() || !this.f17378k.isEnabled());
                asyncTaskC2915aq.m17295j(isChecked);
                asyncTaskC2915aq.m17296k(z2);
                asyncTaskC2915aq.m17288a(selectedItemPosition);
                asyncTaskC2915aq.m17297l(this.f17379l.isChecked());
                asyncTaskC2915aq.m17289a(this.f17380m[0]);
                asyncTaskC2915aq.m17298m(this.f17381n.isChecked());
                asyncTaskC2915aq.m17292g(z);
                asyncTaskC2915aq.m17293h(this.f17374g.isChecked() && this.f17374g.isEnabled());
                asyncTaskC2915aq.m17291b(str);
                asyncTaskC2915aq.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f17377j);
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.threads, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(16);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context, textView, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.af.13

            /* renamed from: a */
            private final DialogInterfaceC0070b f17382a;

            /* renamed from: b */
            private final Context f17383b;

            /* renamed from: c */
            private final TextView f17384c;

            /* renamed from: d */
            private final InterfaceC2995n f17385d;

            /* renamed from: e */
            private final File f17386e;

            {
                this.f17382a = m438b;
                this.f17383b = context;
                this.f17384c = textView;
                this.f17385d = interfaceC2995n;
                this.f17386e = file;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17382a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17383b) { // from class: ru.maximoff.apktool.util.af.13.1

                    /* renamed from: a */
                    private final AnonymousClass13 f17387a;

                    /* renamed from: b */
                    private final Context f17388b;

                    {
                        this.f17387a = this;
                        this.f17388b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int availableProcessors = Runtime.getRuntime().availableProcessors();
                        if (availableProcessors <= 0) {
                            availableProcessors = 4;
                        }
                        C3080al.m18546a(this.f17388b, 1, availableProcessors, availableProcessors, "threads_others", R.string.others);
                    }
                });
                this.f17384c.setOnClickListener(new View.OnClickListener(this, this.f17383b, this.f17382a, this.f17385d, this.f17386e) { // from class: ru.maximoff.apktool.util.af.13.2

                    /* renamed from: a */
                    private final AnonymousClass13 f17389a;

                    /* renamed from: b */
                    private final Context f17390b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f17391c;

                    /* renamed from: d */
                    private final InterfaceC2995n f17392d;

                    /* renamed from: e */
                    private final File f17393e;

                    {
                        this.f17389a = this;
                        this.f17390b = r2;
                        this.f17391c = r3;
                        this.f17392d = r4;
                        this.f17393e = r5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3102bd.m18938b(this.f17390b, "kill_sign_extended", true);
                        this.f17391c.cancel();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f17390b, this.f17392d, this.f17393e) { // from class: ru.maximoff.apktool.util.af.13.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f17394a;

                            /* renamed from: b */
                            private final Context f17395b;

                            /* renamed from: c */
                            private final InterfaceC2995n f17396c;

                            /* renamed from: d */
                            private final File f17397d;

                            {
                                this.f17394a = this;
                                this.f17395b = r2;
                                this.f17396c = r3;
                                this.f17397d = r4;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C3074af.m18463a(this.f17395b, this.f17396c, this.f17397d);
                            }
                        }, 100L);
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: c */
    public static void m18465c(Context context, InterfaceC2995n interfaceC2995n, File file) {
        int i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.killer_dialog_ex, (ViewGroup) null);
        String[] strArr = {file.getAbsolutePath()};
        String[] stringArray = context.getResources().getStringArray(R.array.keys);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.killerdialogexSpinner1);
        int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
        boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
        String[] strArr2 = new String[m18925a ? 3 : 2];
        strArr2[0] = context.getString(R.string.not_sign);
        strArr2[1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
        if (m18925a) {
            strArr2[2] = context.getString(R.string.custom_signature_file);
        } else if (m18905a > 1) {
            m18905a = 1;
        }
        C3102bd.f18317ay = (boolean[]) null;
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr2));
        spinner.setSelection(m18905a);
        spinner.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner, strArr2) { // from class: ru.maximoff.apktool.util.af.14

            /* renamed from: a */
            private final String[] f17398a;

            /* renamed from: b */
            private final Context f17399b;

            /* renamed from: c */
            private final Spinner f17400c;

            /* renamed from: d */
            private final String[] f17401d;

            {
                this.f17398a = stringArray;
                this.f17399b = context;
                this.f17400c = spinner;
                this.f17401d = strArr2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i2;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f17398a.length) {
                        i2 = -1;
                        break;
                    }
                    if (this.f17398a[i3].equals(C3102bd.f18324g)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                new DialogInterfaceC0070b.a(this.f17399b).m418a(R.string.default_key).m430a(this.f17398a, i2, new DialogInterface.OnClickListener(this, this.f17399b, this.f17398a, this.f17400c, this.f17401d) { // from class: ru.maximoff.apktool.util.af.14.1

                    /* renamed from: a */
                    private final AnonymousClass14 f17402a;

                    /* renamed from: b */
                    private final Context f17403b;

                    /* renamed from: c */
                    private final String[] f17404c;

                    /* renamed from: d */
                    private final Spinner f17405d;

                    /* renamed from: e */
                    private final String[] f17406e;

                    {
                        this.f17402a = this;
                        this.f17403b = r2;
                        this.f17404c = r3;
                        this.f17405d = r4;
                        this.f17406e = r5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i4) {
                        C3102bd.m18937b(this.f17403b, "default_key", this.f17404c[i4]);
                        C3102bd.f18324g = this.f17404c[i4];
                        try {
                            C3102bd.m18919a(this.f17403b.getAssets(), this.f17403b.getFilesDir());
                            String string = this.f17403b.getString(R.string.default_signature_file);
                            int selectedItemPosition = this.f17405d.getSelectedItemPosition();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= this.f17406e.length) {
                                    i5 = selectedItemPosition;
                                    break;
                                } else if (!this.f17406e[i5].startsWith(string)) {
                                    i5++;
                                } else {
                                    this.f17406e[i5] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                    break;
                                }
                            }
                            this.f17405d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f17403b, C0012R.layout.simple_spinner_dropdown_item, this.f17406e));
                            this.f17405d.setSelection(i5);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f17403b, R.string.error);
                        }
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                return true;
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.killerdialogexImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_settings_light);
            i = R.drawable.ic_reload;
        } else {
            imageView.setImageResource(R.drawable.ic_settings_dark);
            i = R.drawable.ic_reload_dark;
        }
        imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.af.15

            /* renamed from: a */
            private final Context f17407a;

            {
                this.f17407a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3080al.m18598f(this.f17407a);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.killerdialogexTextView3);
        C3112bn.m19009a(textView, context.getString(R.string.kill_sign_old_mode));
        TextView textView2 = (TextView) inflate.findViewById(R.id.killerdialogexTextView1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.killerdialogexTextView2);
        TextView textView4 = (TextView) inflate.findViewById(R.id.killerdialogexTextView4);
        TextView textView5 = (TextView) inflate.findViewById(R.id.killerdialogexTextView5);
        TextView textView6 = (TextView) inflate.findViewById(R.id.killerdialogexTextView6);
        TextView textView7 = (TextView) inflate.findViewById(R.id.killerdialogexTextView7);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.killerdialogexImageView2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.killerdialogexImageView3);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.killerdialogexImageView4);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.killerdialogexImageView5);
        imageView2.setImageResource(i);
        imageView3.setImageResource(i);
        imageView4.setImageResource(i);
        imageView5.setImageResource(i);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.killerdialogexCheckBox0);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.killerdialogexCheckBox1);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.killerdialogexCheckBox2);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.killerdialogexCheckBox3);
        CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.killerdialogexCheckBox4);
        EditText editText = (EditText) inflate.findViewById(R.id.killerdialogexEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.killerdialogexEditText2);
        EditText editText3 = (EditText) inflate.findViewById(R.id.killerdialogexEditText3);
        EditText editText4 = (EditText) inflate.findViewById(R.id.killerdialogexEditText4);
        EditText editText5 = (EditText) inflate.findViewById(R.id.killerdialogexEditText5);
        checkBox.setChecked(true);
        checkBox.setEnabled(false);
        boolean m18925a2 = C3102bd.m18925a(context, "kill_sign_orig", false);
        checkBox2.setChecked(m18925a2);
        textView2.setText(context.getString(R.string.originalf, ""));
        textView2.setEnabled(m18925a2);
        textView3.setEnabled(m18925a2);
        checkBox3.setChecked(C3102bd.m18925a(context, "kill_sign_installer", true));
        editText5.setText(C3102bd.m18910a(context, "kill_sign_installer_name", "com.android.vending"));
        editText5.setHint("com.android.vending");
        editText5.setEnabled(checkBox3.isChecked());
        int m18520a = C3080al.m18520a(100, 999);
        editText.setText(C3102bd.m18910a(context, "kill_sign_app_name", new StringBuffer().append(f17349a).append(m18520a).toString()));
        editText.setHint(f17349a);
        editText2.setText(C3102bd.m18910a(context, "kill_sign_lib_name", new StringBuffer().append("SignatureKiller").append(m18520a).toString()));
        editText2.setHint("SignatureKiller");
        editText2.setEnabled(m18925a2);
        editText3.setText(C3102bd.m18910a(context, "kill_sign_inject_name", new StringBuffer().append(new StringBuffer().append("assets/origin").append(m18520a).toString()).append(".apk").toString()));
        editText3.setHint("assets/origin.apk");
        editText3.setEnabled(m18925a2);
        editText4.setText(C3102bd.m18910a(context, "kill_sign_extract_name", new StringBuffer().append(new StringBuffer().append("files/origin").append(m18520a).toString()).append(".apk").toString()));
        editText4.setHint("files/origin.apk");
        editText4.setEnabled(m18925a2);
        View.OnClickListener onClickListener = new View.OnClickListener(editText, editText2, editText3, editText4) { // from class: ru.maximoff.apktool.util.af.16

            /* renamed from: a */
            private final EditText f17408a;

            /* renamed from: b */
            private final EditText f17409b;

            /* renamed from: c */
            private final EditText f17410c;

            /* renamed from: d */
            private final EditText f17411d;

            {
                this.f17408a = editText;
                this.f17409b = editText2;
                this.f17410c = editText3;
                this.f17411d = editText4;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.killerdialogexImageView2 /* 2131689873 */:
                        this.f17408a.setText(C3112bn.m19042q(C3074af.f17349a));
                        this.f17408a.setSelection(this.f17408a.getText().length());
                        break;
                    case R.id.killerdialogexImageView3 /* 2131689877 */:
                        this.f17409b.setText(C3112bn.m18988a(15));
                        this.f17409b.setSelection(this.f17409b.getText().length());
                        break;
                    case R.id.killerdialogexImageView4 /* 2131689880 */:
                        this.f17410c.setText(new StringBuffer().append(new StringBuffer().append("assets/").append(C3112bn.m18988a(7)).toString()).append(".apk").toString());
                        this.f17410c.setSelection(this.f17410c.getText().length());
                        break;
                    case R.id.killerdialogexImageView5 /* 2131689883 */:
                        this.f17411d.setText(new StringBuffer().append(new StringBuffer().append("files/").append(C3112bn.m18988a(7)).toString()).append(".apk").toString());
                        this.f17411d.setSelection(this.f17411d.getText().length());
                        break;
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(editText, m18520a, editText2, editText3, editText4) { // from class: ru.maximoff.apktool.util.af.17

            /* renamed from: a */
            private final EditText f17412a;

            /* renamed from: b */
            private final int f17413b;

            /* renamed from: c */
            private final EditText f17414c;

            /* renamed from: d */
            private final EditText f17415d;

            /* renamed from: e */
            private final EditText f17416e;

            {
                this.f17412a = editText;
                this.f17413b = m18520a;
                this.f17414c = editText2;
                this.f17415d = editText3;
                this.f17416e = editText4;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                switch (view.getId()) {
                    case R.id.killerdialogexImageView2 /* 2131689873 */:
                        this.f17412a.setText(new StringBuffer().append(C3074af.f17349a).append(this.f17413b).toString());
                        this.f17412a.setSelection(this.f17412a.getText().length());
                        break;
                    case R.id.killerdialogexImageView3 /* 2131689877 */:
                        this.f17414c.setText(new StringBuffer().append("SignatureKiller").append(this.f17413b).toString());
                        this.f17414c.setSelection(this.f17414c.getText().length());
                        break;
                    case R.id.killerdialogexImageView4 /* 2131689880 */:
                        this.f17415d.setText(new StringBuffer().append(new StringBuffer().append("assets/origin").append(this.f17413b).toString()).append(".apk").toString());
                        this.f17415d.setSelection(this.f17415d.getText().length());
                        break;
                    case R.id.killerdialogexImageView5 /* 2131689883 */:
                        this.f17416e.setText(new StringBuffer().append(new StringBuffer().append("files/origin").append(this.f17413b).toString()).append(".apk").toString());
                        this.f17416e.setSelection(this.f17416e.getText().length());
                        break;
                }
                return true;
            }
        };
        imageView2.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        imageView5.setOnClickListener(onClickListener);
        imageView2.setOnLongClickListener(onLongClickListener);
        imageView3.setOnLongClickListener(onLongClickListener);
        imageView4.setOnLongClickListener(onLongClickListener);
        imageView5.setOnLongClickListener(onLongClickListener);
        textView5.setEnabled(m18925a2);
        textView6.setEnabled(m18925a2);
        textView7.setEnabled(m18925a2);
        if (checkBox2.isChecked()) {
            C3112bn.m19009a(textView3, file.getName());
        } else {
            textView3.setText(file.getName());
        }
        textView3.setOnClickListener(new View.OnClickListener(checkBox2, checkBox4, checkBox5, context, strArr, textView3) { // from class: ru.maximoff.apktool.util.af.18

            /* renamed from: a */
            private final CheckBox f17417a;

            /* renamed from: b */
            private final CheckBox f17418b;

            /* renamed from: c */
            private final CheckBox f17419c;

            /* renamed from: d */
            private final Context f17420d;

            /* renamed from: e */
            private final String[] f17421e;

            /* renamed from: f */
            private final TextView f17422f;

            {
                this.f17417a = checkBox2;
                this.f17418b = checkBox4;
                this.f17419c = checkBox5;
                this.f17420d = context;
                this.f17421e = strArr;
                this.f17422f = textView3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f17417a.isChecked() || this.f17418b.isChecked() || this.f17419c.isChecked()) {
                    C3261t c3261t = new C3261t(this.f17420d);
                    Runnable runnable = new Runnable(this, c3261t, this.f17421e, this.f17422f) { // from class: ru.maximoff.apktool.util.af.18.1

                        /* renamed from: a */
                        private final AnonymousClass18 f17423a;

                        /* renamed from: b */
                        private final C3261t f17424b;

                        /* renamed from: c */
                        private final String[] f17425c;

                        /* renamed from: d */
                        private final TextView f17426d;

                        {
                            this.f17423a = this;
                            this.f17424b = c3261t;
                            this.f17425c = r3;
                            this.f17426d = r4;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            File file2 = new File(this.f17424b.getPath());
                            this.f17425c[0] = file2.getAbsolutePath();
                            C3112bn.m19009a(this.f17426d, file2.getName());
                        }
                    };
                    c3261t.m19545a("_killer");
                    c3261t.setCallback(runnable);
                    c3261t.setFilter(new String[]{"apk", "apks", "apkm", "xapk", "zip"});
                    c3261t.m19546a(true);
                    c3261t.m19550e();
                    DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f17420d);
                    aVar.m427a(c3261t.m19548c());
                    aVar.m435b(c3261t);
                    aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
                    aVar.m437b("/...", (DialogInterface.OnClickListener) null);
                    aVar.m429a(false);
                    aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.af.18.2

                        /* renamed from: a */
                        private final AnonymousClass18 f17427a;

                        /* renamed from: b */
                        private final C3261t f17428b;

                        {
                            this.f17427a = this;
                            this.f17428b = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            boolean m19551f = this.f17428b.m19551f();
                            if (!m19551f) {
                                dialogInterface.dismiss();
                                return m19551f;
                            }
                            return m19551f;
                        }
                    });
                    DialogInterfaceC0070b m438b = aVar.m438b();
                    m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f17420d, c3261t) { // from class: ru.maximoff.apktool.util.af.18.3

                        /* renamed from: a */
                        private final AnonymousClass18 f17429a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f17430b;

                        /* renamed from: c */
                        private final Context f17431c;

                        /* renamed from: d */
                        private final C3261t f17432d;

                        {
                            this.f17429a = this;
                            this.f17430b = m438b;
                            this.f17431c = r3;
                            this.f17432d = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            Button m414a = this.f17430b.m414a(-3);
                            m414a.setOnClickListener(new View.OnClickListener(this, this.f17431c, this.f17432d) { // from class: ru.maximoff.apktool.util.af.18.3.1

                                /* renamed from: a */
                                private final AnonymousClass3 f17433a;

                                /* renamed from: b */
                                private final Context f17434b;

                                /* renamed from: c */
                                private final C3261t f17435c;

                                {
                                    this.f17433a = this;
                                    this.f17434b = r2;
                                    this.f17435c = r3;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    int i2;
                                    String[] m19640b = C3262u.m19640b(this.f17434b);
                                    if (m19640b != null) {
                                        C0173ao c0173ao = new C0173ao(this.f17434b, view2);
                                        if (C3102bd.m18910a(this.f17434b, "menu_position", "1").equals("0")) {
                                            i2 = 3;
                                        } else {
                                            i2 = 5;
                                        }
                                        c0173ao.m1340a(i2);
                                        for (int i3 = 0; i3 < m19640b.length; i3++) {
                                            c0173ao.m1339a().add(0, i3 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i3]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17435c) { // from class: ru.maximoff.apktool.util.af.18.3.1.1

                                                /* renamed from: a */
                                                private final AnonymousClass1 f17436a;

                                                /* renamed from: b */
                                                private final C3261t f17437b;

                                                {
                                                    this.f17436a = this;
                                                    this.f17437b = r2;
                                                }

                                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                                public boolean onMenuItemClick(MenuItem menuItem) {
                                                    this.f17437b.m19544a(new File(menuItem.getTitle().toString()));
                                                    return true;
                                                }
                                            });
                                        }
                                        c0173ao.m1344c();
                                    }
                                }
                            });
                            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f17432d, this.f17431c) { // from class: ru.maximoff.apktool.util.af.18.3.2

                                /* renamed from: a */
                                private final AnonymousClass3 f17438a;

                                /* renamed from: b */
                                private final C3261t f17439b;

                                /* renamed from: c */
                                private final Context f17440c;

                                {
                                    this.f17438a = this;
                                    this.f17439b = r2;
                                    this.f17440c = r3;
                                }

                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view2) {
                                    int i2;
                                    List<String> m19205b = this.f17439b.m19549d().m19205b();
                                    if (m19205b.isEmpty()) {
                                        return false;
                                    }
                                    C0173ao c0173ao = new C0173ao(this.f17440c, view2);
                                    if (C3102bd.m18910a(this.f17440c, "menu_position", "1").equals("0")) {
                                        i2 = 3;
                                    } else {
                                        i2 = 5;
                                    }
                                    c0173ao.m1340a(i2);
                                    Iterator<String> it = m19205b.iterator();
                                    while (it.hasNext()) {
                                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17439b) { // from class: ru.maximoff.apktool.util.af.18.3.2.1

                                            /* renamed from: a */
                                            private final AnonymousClass2 f17441a;

                                            /* renamed from: b */
                                            private final C3261t f17442b;

                                            {
                                                this.f17441a = this;
                                                this.f17442b = r2;
                                            }

                                            @Override // android.view.MenuItem.OnMenuItemClickListener
                                            public boolean onMenuItemClick(MenuItem menuItem) {
                                                this.f17442b.m19544a(new File(menuItem.getTitle().toString()));
                                                return true;
                                            }
                                        });
                                    }
                                    c0173ao.m1344c();
                                    return true;
                                }
                            });
                        }
                    });
                    c3261t.setDialog(m438b);
                    m438b.show();
                }
            }
        });
        textView3.setOnLongClickListener(new View.OnLongClickListener(checkBox2, checkBox4, checkBox5, strArr, file, textView3) { // from class: ru.maximoff.apktool.util.af.19

            /* renamed from: a */
            private final CheckBox f17443a;

            /* renamed from: b */
            private final CheckBox f17444b;

            /* renamed from: c */
            private final CheckBox f17445c;

            /* renamed from: d */
            private final String[] f17446d;

            /* renamed from: e */
            private final File f17447e;

            /* renamed from: f */
            private final TextView f17448f;

            {
                this.f17443a = checkBox2;
                this.f17444b = checkBox4;
                this.f17445c = checkBox5;
                this.f17446d = strArr;
                this.f17447e = file;
                this.f17448f = textView3;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!(this.f17443a.isChecked() || this.f17444b.isChecked() || this.f17445c.isChecked())) {
                    return false;
                }
                this.f17446d[0] = this.f17447e.getAbsolutePath();
                C3112bn.m19009a(this.f17448f, this.f17447e.getName());
                return true;
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener(checkBox2, checkBox4, checkBox5, textView2, textView3, strArr, textView5, textView6, textView7, editText2, editText3, editText4, imageView3, imageView4, imageView5) { // from class: ru.maximoff.apktool.util.af.20

            /* renamed from: a */
            private final CheckBox f17450a;

            /* renamed from: b */
            private final CheckBox f17451b;

            /* renamed from: c */
            private final CheckBox f17452c;

            /* renamed from: d */
            private final TextView f17453d;

            /* renamed from: e */
            private final TextView f17454e;

            /* renamed from: f */
            private final String[] f17455f;

            /* renamed from: g */
            private final TextView f17456g;

            /* renamed from: h */
            private final TextView f17457h;

            /* renamed from: i */
            private final TextView f17458i;

            /* renamed from: j */
            private final EditText f17459j;

            /* renamed from: k */
            private final EditText f17460k;

            /* renamed from: l */
            private final EditText f17461l;

            /* renamed from: m */
            private final ImageView f17462m;

            /* renamed from: n */
            private final ImageView f17463n;

            /* renamed from: o */
            private final ImageView f17464o;

            {
                this.f17450a = checkBox2;
                this.f17451b = checkBox4;
                this.f17452c = checkBox5;
                this.f17453d = textView2;
                this.f17454e = textView3;
                this.f17455f = strArr;
                this.f17456g = textView5;
                this.f17457h = textView6;
                this.f17458i = textView7;
                this.f17459j = editText2;
                this.f17460k = editText3;
                this.f17461l = editText4;
                this.f17462m = imageView3;
                this.f17463n = imageView4;
                this.f17464o = imageView5;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean isChecked = this.f17450a.isChecked();
                boolean z = isChecked || this.f17451b.isChecked() || this.f17452c.isChecked();
                this.f17453d.setEnabled(z);
                this.f17454e.setEnabled(z);
                File file2 = new File(this.f17455f[0]);
                if (z) {
                    C3112bn.m19009a(this.f17454e, file2.getName());
                } else {
                    this.f17454e.setText(file2.getName());
                }
                this.f17456g.setEnabled(isChecked);
                this.f17457h.setEnabled(isChecked);
                this.f17458i.setEnabled(isChecked);
                this.f17459j.setEnabled(isChecked);
                this.f17460k.setEnabled(isChecked);
                this.f17461l.setEnabled(isChecked);
                this.f17462m.setEnabled(isChecked);
                this.f17463n.setEnabled(isChecked);
                this.f17464o.setEnabled(isChecked);
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener(checkBox2, checkBox4, checkBox5, textView2, textView3, strArr) { // from class: ru.maximoff.apktool.util.af.21

            /* renamed from: a */
            private final CheckBox f17465a;

            /* renamed from: b */
            private final CheckBox f17466b;

            /* renamed from: c */
            private final CheckBox f17467c;

            /* renamed from: d */
            private final TextView f17468d;

            /* renamed from: e */
            private final TextView f17469e;

            /* renamed from: f */
            private final String[] f17470f;

            {
                this.f17465a = checkBox2;
                this.f17466b = checkBox4;
                this.f17467c = checkBox5;
                this.f17468d = textView2;
                this.f17469e = textView3;
                this.f17470f = strArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = this.f17465a.isChecked() || this.f17466b.isChecked() || this.f17467c.isChecked();
                this.f17468d.setEnabled(z);
                this.f17469e.setEnabled(z);
                File file2 = new File(this.f17470f[0]);
                if (z) {
                    C3112bn.m19009a(this.f17469e, file2.getName());
                } else {
                    this.f17469e.setText(file2.getName());
                }
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener(checkBox, checkBox2, checkBox4, checkBox5, textView2, textView3, strArr, checkBox3, editText5, textView4, textView5, textView6, textView7, editText, editText2, editText3, editText4, imageView2, imageView3, imageView4, imageView5) { // from class: ru.maximoff.apktool.util.af.22

            /* renamed from: a */
            private final CheckBox f17471a;

            /* renamed from: b */
            private final CheckBox f17472b;

            /* renamed from: c */
            private final CheckBox f17473c;

            /* renamed from: d */
            private final CheckBox f17474d;

            /* renamed from: e */
            private final TextView f17475e;

            /* renamed from: f */
            private final TextView f17476f;

            /* renamed from: g */
            private final String[] f17477g;

            /* renamed from: h */
            private final CheckBox f17478h;

            /* renamed from: i */
            private final EditText f17479i;

            /* renamed from: j */
            private final TextView f17480j;

            /* renamed from: k */
            private final TextView f17481k;

            /* renamed from: l */
            private final TextView f17482l;

            /* renamed from: m */
            private final TextView f17483m;

            /* renamed from: n */
            private final EditText f17484n;

            /* renamed from: o */
            private final EditText f17485o;

            /* renamed from: p */
            private final EditText f17486p;

            /* renamed from: q */
            private final EditText f17487q;

            /* renamed from: r */
            private final ImageView f17488r;

            /* renamed from: s */
            private final ImageView f17489s;

            /* renamed from: t */
            private final ImageView f17490t;

            /* renamed from: u */
            private final ImageView f17491u;

            {
                this.f17471a = checkBox;
                this.f17472b = checkBox2;
                this.f17473c = checkBox4;
                this.f17474d = checkBox5;
                this.f17475e = textView2;
                this.f17476f = textView3;
                this.f17477g = strArr;
                this.f17478h = checkBox3;
                this.f17479i = editText5;
                this.f17480j = textView4;
                this.f17481k = textView5;
                this.f17482l = textView6;
                this.f17483m = textView7;
                this.f17484n = editText;
                this.f17485o = editText2;
                this.f17486p = editText3;
                this.f17487q = editText4;
                this.f17488r = imageView2;
                this.f17489s = imageView3;
                this.f17490t = imageView4;
                this.f17491u = imageView5;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f17471a.setChecked(true);
                this.f17472b.setEnabled(true);
                this.f17473c.setEnabled(true);
                this.f17471a.setEnabled(this.f17474d.isChecked());
                boolean isChecked = this.f17472b.isChecked();
                boolean z = isChecked || this.f17473c.isChecked() || this.f17474d.isChecked();
                this.f17475e.setEnabled(z);
                this.f17476f.setEnabled(z);
                File file2 = new File(this.f17477g[0]);
                if (z) {
                    C3112bn.m19009a(this.f17476f, file2.getName());
                } else {
                    this.f17476f.setText(file2.getName());
                }
                this.f17478h.setEnabled(true);
                this.f17479i.setEnabled(this.f17478h.isChecked());
                this.f17480j.setEnabled(true);
                this.f17481k.setEnabled(isChecked);
                this.f17482l.setEnabled(isChecked);
                this.f17483m.setEnabled(isChecked);
                this.f17484n.setEnabled(true);
                this.f17485o.setEnabled(isChecked);
                this.f17486p.setEnabled(isChecked);
                this.f17487q.setEnabled(isChecked);
                this.f17488r.setEnabled(true);
                this.f17489s.setEnabled(isChecked);
                this.f17490t.setEnabled(isChecked);
                this.f17491u.setEnabled(isChecked);
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener(editText5, checkBox3) { // from class: ru.maximoff.apktool.util.af.23

            /* renamed from: a */
            private final EditText f17492a;

            /* renamed from: b */
            private final CheckBox f17493b;

            {
                this.f17492a = editText5;
                this.f17493b = checkBox3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f17492a.setEnabled(this.f17493b.isChecked());
            }
        });
        checkBox3.setOnLongClickListener(new View.OnLongClickListener(editText5) { // from class: ru.maximoff.apktool.util.af.24

            /* renamed from: a */
            private final EditText f17494a;

            {
                this.f17494a = editText5;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f17494a.setText("com.android.vending");
                this.f17494a.setSelection(this.f17494a.getText().length());
                return true;
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener(checkBox, checkBox2, checkBox4, checkBox3, editText5, textView4, textView5, textView6, textView7, editText, editText2, editText3, editText4, imageView2, imageView3, imageView4, imageView5) { // from class: ru.maximoff.apktool.util.af.25

            /* renamed from: a */
            private final CheckBox f17495a;

            /* renamed from: b */
            private final CheckBox f17496b;

            /* renamed from: c */
            private final CheckBox f17497c;

            /* renamed from: d */
            private final CheckBox f17498d;

            /* renamed from: e */
            private final EditText f17499e;

            /* renamed from: f */
            private final TextView f17500f;

            /* renamed from: g */
            private final TextView f17501g;

            /* renamed from: h */
            private final TextView f17502h;

            /* renamed from: i */
            private final TextView f17503i;

            /* renamed from: j */
            private final EditText f17504j;

            /* renamed from: k */
            private final EditText f17505k;

            /* renamed from: l */
            private final EditText f17506l;

            /* renamed from: m */
            private final EditText f17507m;

            /* renamed from: n */
            private final ImageView f17508n;

            /* renamed from: o */
            private final ImageView f17509o;

            /* renamed from: p */
            private final ImageView f17510p;

            /* renamed from: q */
            private final ImageView f17511q;

            {
                this.f17495a = checkBox;
                this.f17496b = checkBox2;
                this.f17497c = checkBox4;
                this.f17498d = checkBox3;
                this.f17499e = editText5;
                this.f17500f = textView4;
                this.f17501g = textView5;
                this.f17502h = textView6;
                this.f17503i = textView7;
                this.f17504j = editText;
                this.f17505k = editText2;
                this.f17506l = editText3;
                this.f17507m = editText4;
                this.f17508n = imageView2;
                this.f17509o = imageView3;
                this.f17510p = imageView4;
                this.f17511q = imageView5;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean isChecked = this.f17495a.isChecked();
                this.f17496b.setEnabled(isChecked);
                this.f17497c.setEnabled(isChecked);
                this.f17498d.setEnabled(isChecked);
                this.f17499e.setEnabled(isChecked && this.f17498d.isChecked());
                this.f17500f.setEnabled(isChecked);
                this.f17501g.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17502h.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17503i.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17504j.setEnabled(isChecked);
                this.f17505k.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17506l.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17507m.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17508n.setEnabled(isChecked);
                this.f17509o.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17510p.setEnabled(isChecked && this.f17496b.isChecked());
                this.f17511q.setEnabled(isChecked && this.f17496b.isChecked());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.kill_sign).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(spinner, checkBox2, context, checkBox3, editText, editText2, editText3, editText4, editText5, interfaceC2995n, file, checkBox, checkBox5, strArr, checkBox4) { // from class: ru.maximoff.apktool.util.af.26

            /* renamed from: a */
            private final Spinner f17512a;

            /* renamed from: b */
            private final CheckBox f17513b;

            /* renamed from: c */
            private final Context f17514c;

            /* renamed from: d */
            private final CheckBox f17515d;

            /* renamed from: e */
            private final EditText f17516e;

            /* renamed from: f */
            private final EditText f17517f;

            /* renamed from: g */
            private final EditText f17518g;

            /* renamed from: h */
            private final EditText f17519h;

            /* renamed from: i */
            private final EditText f17520i;

            /* renamed from: j */
            private final InterfaceC2995n f17521j;

            /* renamed from: k */
            private final File f17522k;

            /* renamed from: l */
            private final CheckBox f17523l;

            /* renamed from: m */
            private final CheckBox f17524m;

            /* renamed from: n */
            private final String[] f17525n;

            /* renamed from: o */
            private final CheckBox f17526o;

            {
                this.f17512a = spinner;
                this.f17513b = checkBox2;
                this.f17514c = context;
                this.f17515d = checkBox3;
                this.f17516e = editText;
                this.f17517f = editText2;
                this.f17518g = editText3;
                this.f17519h = editText4;
                this.f17520i = editText5;
                this.f17521j = interfaceC2995n;
                this.f17522k = file;
                this.f17523l = checkBox;
                this.f17524m = checkBox5;
                this.f17525n = strArr;
                this.f17526o = checkBox4;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                String str;
                int selectedItemPosition = this.f17512a.getSelectedItemPosition();
                boolean isChecked = this.f17513b.isChecked();
                C3102bd.m18938b(this.f17514c, "kill_sign_orig", isChecked);
                C3102bd.m18935b(this.f17514c, "selected_signature", selectedItemPosition);
                C3102bd.m18938b(this.f17514c, "kill_sign_installer", this.f17515d.isChecked());
                String editable = this.f17516e.getText().toString();
                if (!C3112bn.m19040o(editable.trim())) {
                    C3102bd.m18937b(this.f17514c, "kill_sign_app_name", editable);
                    str = editable;
                } else {
                    str = C3074af.f17349a;
                }
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (isChecked) {
                    str2 = this.f17517f.getText().toString();
                    str3 = this.f17518g.getText().toString();
                    str4 = this.f17519h.getText().toString();
                    C3102bd.m18937b(this.f17514c, "kill_sign_lib_name", str2);
                    C3102bd.m18937b(this.f17514c, "kill_sign_inject_name", str3);
                    C3102bd.m18937b(this.f17514c, "kill_sign_extract_name", str4);
                }
                String str5 = str4;
                String str6 = (String) null;
                if (this.f17515d.isChecked() && this.f17515d.isEnabled()) {
                    str6 = this.f17520i.getText().toString();
                    if (C3112bn.m19040o(str6)) {
                        str6 = "com.android.vending";
                    }
                    C3102bd.m18937b(this.f17514c, "kill_sign_installer_name", str6);
                }
                AsyncTaskC2915aq asyncTaskC2915aq = new AsyncTaskC2915aq(this.f17514c, this.f17521j, new C3081am(this.f17522k));
                asyncTaskC2915aq.m17295j(true);
                asyncTaskC2915aq.m17294i(this.f17523l.isChecked() || !this.f17523l.isEnabled());
                asyncTaskC2915aq.m17296k(isChecked);
                asyncTaskC2915aq.m17288a(selectedItemPosition);
                asyncTaskC2915aq.m17297l(this.f17524m.isChecked());
                asyncTaskC2915aq.m17289a(this.f17525n[0]);
                asyncTaskC2915aq.m17298m(this.f17526o.isChecked());
                asyncTaskC2915aq.m17290a(str, str2, str3, str5);
                asyncTaskC2915aq.m17291b(str6);
                asyncTaskC2915aq.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f17522k);
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.threads, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(16);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context, textView, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.af.27

            /* renamed from: a */
            private final DialogInterfaceC0070b f17527a;

            /* renamed from: b */
            private final Context f17528b;

            /* renamed from: c */
            private final TextView f17529c;

            /* renamed from: d */
            private final InterfaceC2995n f17530d;

            /* renamed from: e */
            private final File f17531e;

            {
                this.f17527a = m438b;
                this.f17528b = context;
                this.f17529c = textView;
                this.f17530d = interfaceC2995n;
                this.f17531e = file;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17527a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17528b) { // from class: ru.maximoff.apktool.util.af.27.1

                    /* renamed from: a */
                    private final AnonymousClass27 f17532a;

                    /* renamed from: b */
                    private final Context f17533b;

                    {
                        this.f17532a = this;
                        this.f17533b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int availableProcessors = Runtime.getRuntime().availableProcessors();
                        if (availableProcessors <= 0) {
                            availableProcessors = 4;
                        }
                        C3080al.m18546a(this.f17533b, 1, availableProcessors, availableProcessors, "threads_others", R.string.others);
                    }
                });
                this.f17529c.setOnClickListener(new View.OnClickListener(this, this.f17528b, this.f17527a, this.f17530d, this.f17531e) { // from class: ru.maximoff.apktool.util.af.27.2

                    /* renamed from: a */
                    private final AnonymousClass27 f17534a;

                    /* renamed from: b */
                    private final Context f17535b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f17536c;

                    /* renamed from: d */
                    private final InterfaceC2995n f17537d;

                    /* renamed from: e */
                    private final File f17538e;

                    {
                        this.f17534a = this;
                        this.f17535b = r2;
                        this.f17536c = r3;
                        this.f17537d = r4;
                        this.f17538e = r5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3102bd.m18938b(this.f17535b, "kill_sign_extended", false);
                        this.f17536c.cancel();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f17535b, this.f17537d, this.f17538e) { // from class: ru.maximoff.apktool.util.af.27.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f17539a;

                            /* renamed from: b */
                            private final Context f17540b;

                            /* renamed from: c */
                            private final InterfaceC2995n f17541c;

                            /* renamed from: d */
                            private final File f17542d;

                            {
                                this.f17539a = this;
                                this.f17540b = r2;
                                this.f17541c = r3;
                                this.f17542d = r4;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C3074af.m18463a(this.f17540b, this.f17541c, this.f17542d);
                            }
                        }, 100L);
                    }
                });
                if (Build.VERSION.SDK_INT >= 21 || C3102bd.m18925a(this.f17528b, "kill_sign_notice_ex", false)) {
                    return;
                }
                new DialogInterfaceC0070b.a(this.f17528b).m418a(R.string.attention).m433b(R.string.kill_sign_notice).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.not_remind, new DialogInterface.OnClickListener(this, this.f17528b) { // from class: ru.maximoff.apktool.util.af.27.3

                    /* renamed from: a */
                    private final AnonymousClass27 f17543a;

                    /* renamed from: b */
                    private final Context f17544b;

                    {
                        this.f17543a = this;
                        this.f17544b = r2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface2, int i2) {
                        C3102bd.m18938b(this.f17544b, "kill_sign_notice_ex", true);
                        dialogInterface2.dismiss();
                    }
                }).m438b().show();
            }
        });
        m438b.show();
    }
}
