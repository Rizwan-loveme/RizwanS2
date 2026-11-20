package ru.maximoff.apktool.fragment;

import android.p008os.Build;
import android.p008os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.preference.CheckBoxPreference;

/* loaded from: classes.dex */
public class PreferenceSignatureFragment extends AbstractFragmentC2996c implements Preference.OnPreferenceChangeListener {
    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preference_signature);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("use_v1_sign");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("use_v2_sign");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("use_v3_sign");
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) findPreference("use_v4_sign");
        Preference.OnPreferenceClickListener onPreferenceClickListener = new Preference.OnPreferenceClickListener(this, checkBoxPreference, checkBoxPreference2, checkBoxPreference3, checkBoxPreference4) { // from class: ru.maximoff.apktool.fragment.PreferenceSignatureFragment.1

            /* renamed from: a */
            private final PreferenceSignatureFragment f15867a;

            /* renamed from: b */
            private final CheckBoxPreference f15868b;

            /* renamed from: c */
            private final CheckBoxPreference f15869c;

            /* renamed from: d */
            private final CheckBoxPreference f15870d;

            /* renamed from: e */
            private final CheckBoxPreference f15871e;

            {
                this.f15867a = this;
                this.f15868b = checkBoxPreference;
                this.f15869c = checkBoxPreference2;
                this.f15870d = checkBoxPreference3;
                this.f15871e = checkBoxPreference4;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (Build.VERSION.SDK_INT < 21) {
                    if (!this.f15868b.isChecked() && !this.f15869c.isChecked()) {
                        if (preference.getKey().equals("use_v1_sign")) {
                            this.f15869c.setChecked(true);
                        } else {
                            this.f15868b.setChecked(true);
                        }
                    }
                } else if (!this.f15868b.isChecked() && !this.f15869c.isChecked() && !this.f15870d.isChecked()) {
                    if (preference.getKey().equals("use_v2_sign")) {
                        if (this.f15871e.isChecked()) {
                            this.f15870d.setChecked(true);
                        } else {
                            this.f15868b.setChecked(true);
                        }
                    } else {
                        this.f15869c.setChecked(true);
                    }
                } else if (this.f15868b.isChecked() && !this.f15869c.isChecked() && !this.f15870d.isChecked() && this.f15871e.isChecked()) {
                    if (preference.getKey().equals("use_v3_sign")) {
                        this.f15869c.setChecked(true);
                    } else {
                        this.f15870d.setChecked(true);
                    }
                }
                return false;
            }
        };
        checkBoxPreference.setOnPreferenceClickListener(onPreferenceClickListener);
        checkBoxPreference2.setOnPreferenceClickListener(onPreferenceClickListener);
        checkBoxPreference3.setOnPreferenceClickListener(onPreferenceClickListener);
        checkBoxPreference4.setOnPreferenceClickListener(onPreferenceClickListener);
        if (Build.VERSION.SDK_INT < 21) {
            getPreferenceScreen().removePreference(checkBoxPreference3);
            getPreferenceScreen().removePreference(checkBoxPreference4);
        }
        m17615b();
    }

    /* renamed from: b */
    private void m17615b() {
        boolean z = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("custom_signature_file", false);
        findPreference("keystore").setEnabled(z);
        findPreference("gen_key").setEnabled(z);
        findPreference("custom_signature_file").setOnPreferenceChangeListener(this);
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        findPreference("keystore").setEnabled(booleanValue);
        findPreference("gen_key").setEnabled(booleanValue);
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.signature;
    }
}
