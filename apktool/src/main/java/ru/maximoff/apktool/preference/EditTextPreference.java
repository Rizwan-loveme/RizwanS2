package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.security.KeyChain;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import org.p270e.C2466a;
import ru.maximoff.apktool.util.C3249i;

/* loaded from: classes.dex */
public class EditTextPreference extends CustomPreference {

    /* renamed from: a */
    private boolean f16890a;

    /* renamed from: b */
    private boolean f16891b;

    /* renamed from: c */
    private int f16892c;

    /* renamed from: d */
    private int f16893d;

    /* renamed from: e */
    private C2466a f16894e;

    /* renamed from: f */
    private String f16895f;

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16890a = true;
        this.f16891b = false;
        this.f16892c = 1;
        this.f16893d = 0;
    }

    /* renamed from: a */
    private boolean m18092a() {
        String key = getKey();
        if (key.equals("quick_panel_symbols")) {
            this.f16891b = false;
            this.f16893d = R.string.quick_panel_sym;
            this.f16894e = new C2466a();
            for (String str : C3249i.f19542b) {
                this.f16894e.m15574a(str);
            }
            this.f16890a = false;
            this.f16892c = 7;
            return true;
        }
        if (key.equals("v1_cert_name")) {
            this.f16891b = true;
            this.f16893d = R.string.v1_cert_name;
            this.f16895f = KeyChain.EXTRA_CERTIFICATE;
            this.f16890a = true;
            this.f16892c = 1;
            return true;
        }
        if (key.equals("created_cert_name")) {
            this.f16891b = true;
            this.f16893d = R.string.created_cert_name;
            this.f16895f = "Apktool M";
            this.f16890a = true;
            this.f16892c = 1;
            return true;
        }
        if (key.equals("suffix_apk")) {
            this.f16891b = true;
            this.f16893d = R.string.suffix;
            this.f16895f = "_src";
            this.f16890a = true;
            this.f16892c = 1;
            return true;
        }
        if (key.equals("custom_exts")) {
            this.f16891b = true;
            this.f16893d = R.string.custom_exts;
            this.f16895f = "";
            this.f16890a = true;
            this.f16892c = 1;
            return true;
        }
        if (key.equals("shell_cmd")) {
            this.f16891b = true;
            this.f16893d = R.string.shell_cmd;
            this.f16895f = "sh";
            this.f16890a = true;
            this.f16892c = 1;
            return true;
        }
        if (!key.equals("shell_cmd_root")) {
            return false;
        }
        this.f16891b = true;
        this.f16893d = R.string.shell_cmd_root;
        this.f16895f = "su -c";
        this.f16890a = true;
        this.f16892c = 1;
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (m18092a()) {
            Context context = getContext();
            String key = getKey();
            View inflate = LayoutInflater.from(context).inflate(R.layout.mdialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.mdialogTextView1);
            EditText editText = (EditText) inflate.findViewById(R.id.mdialogEditText1);
            editText.setSingleLine(this.f16890a);
            editText.setMinLines(this.f16892c);
            editText.setMaxLines(this.f16892c);
            editText.setHint(this.f16893d);
            if (key.equals("v1_cert_name")) {
                textView.setText(R.string.v1_cert_name_info);
            } else if (key.equals("custom_exts")) {
                textView.setText(R.string.custom_exts_info);
            } else {
                textView.setVisibility(8);
            }
            if (this.f16891b) {
                editText.setText(getSharedPreferences().getString(key, this.f16895f));
            } else {
                String string = getSharedPreferences().getString(key, this.f16894e.toString());
                if (string.equals("")) {
                    SharedPreferences.Editor edit = getSharedPreferences().edit();
                    edit.putString(key, this.f16894e.toString());
                    edit.commit();
                    string = this.f16894e.toString();
                }
                try {
                    C2466a c2466a = new C2466a(string);
                    String str = "";
                    for (int i = 0; i < c2466a.m15569a(); i++) {
                        if (i > 0) {
                            str = new StringBuffer().append(str).append("\n").toString();
                        }
                        str = new StringBuffer().append(str).append(c2466a.m15571a(i)).toString();
                    }
                    editText.setText(str);
                } catch (Exception e2) {
                    editText.setText("");
                }
            }
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
            aVar.m435b(inflate);
            aVar.m418a(this.f16893d);
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, key) { // from class: ru.maximoff.apktool.preference.EditTextPreference.1

                /* renamed from: a */
                private final EditTextPreference f16896a;

                /* renamed from: b */
                private final EditText f16897b;

                /* renamed from: c */
                private final String f16898c;

                {
                    this.f16896a = this;
                    this.f16897b = editText;
                    this.f16898c = key;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    String editable = this.f16897b.getText().toString();
                    if (this.f16896a.f16891b) {
                        if (this.f16898c.equals("v1_cert_name")) {
                            editable = editable.toUpperCase().replaceAll("[^A-Z0-9-_]", "_");
                        }
                    } else {
                        C2466a c2466a2 = new C2466a();
                        String[] split = editable.split("\n");
                        for (String str2 : split) {
                            c2466a2.m15574a(str2);
                        }
                        editable = c2466a2.toString();
                    }
                    SharedPreferences.Editor edit2 = this.f16896a.getSharedPreferences().edit();
                    edit2.putString(this.f16898c, editable);
                    edit2.commit();
                }
            });
            aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, key) { // from class: ru.maximoff.apktool.preference.EditTextPreference.2

                /* renamed from: a */
                private final EditTextPreference f16899a;

                /* renamed from: b */
                private final String f16900b;

                {
                    this.f16899a = this;
                    this.f16900b = key;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SharedPreferences.Editor edit2 = this.f16899a.getSharedPreferences().edit();
                    edit2.remove(this.f16900b);
                    edit2.commit();
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.getWindow().setSoftInputMode(16);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.preference.EditTextPreference.3

                /* renamed from: a */
                private final EditTextPreference f16901a;

                /* renamed from: b */
                private final EditText f16902b;

                {
                    this.f16901a = this;
                    this.f16902b = editText;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f16902b.requestFocus();
                    this.f16902b.setSelection(this.f16902b.getText().length());
                }
            });
            m438b.show();
        }
    }
}
