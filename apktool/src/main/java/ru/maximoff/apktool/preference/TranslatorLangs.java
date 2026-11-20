package ru.maximoff.apktool.preference;

import android.content.Context;
import android.util.AttributeSet;
import ru.maximoff.apktool.util.p308f.C3239s;

/* loaded from: classes.dex */
public class TranslatorLangs extends CustomPreference {
    public TranslatorLangs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        C3239s.m19428b(getContext());
    }
}
