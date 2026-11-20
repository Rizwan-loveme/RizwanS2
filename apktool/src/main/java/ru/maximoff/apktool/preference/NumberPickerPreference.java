package ru.maximoff.apktool.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;

/* loaded from: classes.dex */
public class NumberPickerPreference extends CustomPreference {

    /* renamed from: a */
    private int f17016a;

    /* renamed from: b */
    private int f17017b;

    /* renamed from: c */
    private int f17018c;

    /* renamed from: d */
    private int f17019d;

    public NumberPickerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17016a = 8;
        this.f17017b = 40;
    }

    /* renamed from: a */
    private boolean m18124a() {
        String key = getKey();
        if (key.equals("napp_fontsz")) {
            this.f17018c = R.string.app_fontsz;
            this.f17019d = 16;
            return true;
        }
        if (key.equals("nfont_size")) {
            this.f17018c = R.string.font_size;
            this.f17019d = 14;
            return true;
        }
        if (key.equals("update_freq")) {
            this.f17018c = R.string.update_freq;
            this.f17019d = 1;
            this.f17016a = 1;
            this.f17017b = 30;
            return true;
        }
        if (key.equals("buffer_size")) {
            this.f17018c = R.string.buffer_size;
            this.f17019d = 10;
            this.f17016a = 1;
            this.f17017b = 30;
            return true;
        }
        if (key.equals("clear_preview")) {
            this.f17018c = R.string.clear_preview;
            this.f17019d = 7;
            this.f17016a = 1;
            this.f17017b = 30;
            return true;
        }
        if (key.equals("aicon_size")) {
            this.f17018c = R.string.aicon_size;
            this.f17019d = 108;
            this.f17016a = 50;
            this.f17017b = 250;
            return true;
        }
        if (key.equals("editor_indent")) {
            this.f17018c = R.string.editor_indent;
            this.f17019d = 4;
            this.f17016a = 1;
            this.f17017b = 8;
            return true;
        }
        return false;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (!m18124a()) {
            return;
        }
        C3080al.m18546a(getContext(), this.f17016a, this.f17017b, this.f17019d, getKey(), this.f17018c);
    }
}
