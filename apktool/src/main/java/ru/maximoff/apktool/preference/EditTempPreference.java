package ru.maximoff.apktool.preference;

import android.content.Context;
import android.util.AttributeSet;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class EditTempPreference extends CustomPreference {
    public EditTempPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private boolean m18091a() {
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (!m18091a()) {
            return;
        }
        C3262u.m19575a(getContext());
    }
}
