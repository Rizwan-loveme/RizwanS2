package ru.maximoff.apktool.fragment;

import android.os.Bundle;
import android.preference.Preference;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.preference.CheckBoxPreference;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class PreferenceEditorFragment extends AbstractFragmentC2996c {
    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preference_editor);
        ((CheckBoxPreference) findPreference("editor_rem_tabs")).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: ru.maximoff.apktool.fragment.PreferenceEditorFragment.1

            /* renamed from: a */
            private final PreferenceEditorFragment f15866a;

            {
                this.f15866a = this;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3102bd.f18336s = true;
                return true;
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.editor;
    }
}
