package ru.maximoff.apktool.fragment;

import android.p008os.Bundle;
import com.srizwan.apktool.R;

/* loaded from: classes.dex */
public class PreferenceCompilerFragment extends AbstractFragmentC2996c {
    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preference_compiler);
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.build_and_decode;
    }
}
