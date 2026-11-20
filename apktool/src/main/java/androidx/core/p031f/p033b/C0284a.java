package androidx.core.p031f.p033b;

import android.p008os.Build;
import android.p008os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.p030e.C0270e;

/* compiled from: EditorInfoCompat.java */
/* renamed from: androidx.core.f.b.a */
/* loaded from: classes.dex */
public final class C0284a {

    /* renamed from: a */
    private static final String[] f2174a = new String[0];

    /* renamed from: a */
    public static void m2134a(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    /* renamed from: a */
    public static String[] m2137a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            if (strArr == null) {
                return f2174a;
            }
            return strArr;
        }
        if (editorInfo.extras == null) {
            return f2174a;
        }
        String[] stringArray = editorInfo.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray == null ? f2174a : stringArray;
    }

    /* renamed from: a */
    public static void m2131a(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.m2139a(editorInfo, charSequence, 0);
        } else {
            m2132a(editorInfo, charSequence, 0);
        }
    }

    /* renamed from: a */
    public static void m2132a(EditorInfo editorInfo, CharSequence charSequence, int i) {
        int i2;
        int i3;
        C0270e.m1960a(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.m2139a(editorInfo, charSequence, i);
            return;
        }
        if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
            i2 = editorInfo.initialSelEnd - i;
        } else {
            i2 = editorInfo.initialSelStart - i;
        }
        if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
            i3 = editorInfo.initialSelStart - i;
        } else {
            i3 = editorInfo.initialSelEnd - i;
        }
        int length = charSequence.length();
        if (i < 0 || i2 < 0 || i3 > length) {
            m2138b(editorInfo, null, 0, 0);
            return;
        }
        if (m2135a(editorInfo.inputType)) {
            m2138b(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            m2138b(editorInfo, charSequence, i2, i3);
        } else {
            m2133a(editorInfo, charSequence, i2, i3);
        }
    }

    /* renamed from: a */
    private static void m2133a(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        CharSequence subSequence;
        int i3 = i2 - i;
        int i4 = i3 > 1024 ? 0 : i3;
        int i5 = 2048 - i4;
        int min = Math.min(charSequence.length() - i2, i5 - Math.min(i, (int) (0.8d * i5)));
        int min2 = Math.min(i, i5 - min);
        int i6 = i - min2;
        if (m2136a(charSequence, i - min2, 0)) {
            i6++;
            min2--;
        }
        if (m2136a(charSequence, (i2 + min) - 1, 1)) {
            min--;
        }
        int i7 = min2 + i4 + min;
        if (i4 != i3) {
            subSequence = TextUtils.concat(charSequence.subSequence(i6, i6 + min2), charSequence.subSequence(i2, i2 + min));
        } else {
            subSequence = charSequence.subSequence(i6, i6 + i7);
        }
        int i8 = 0 + min2;
        m2138b(editorInfo, subSequence, i8, i4 + i8);
    }

    /* renamed from: a */
    private static boolean m2136a(CharSequence charSequence, int i, int i2) {
        switch (i2) {
            case 0:
                return Character.isLowSurrogate(charSequence.charAt(i));
            case 1:
                return Character.isHighSurrogate(charSequence.charAt(i));
            default:
                return false;
        }
    }

    /* renamed from: a */
    private static boolean m2135a(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    /* renamed from: b */
    private static void m2138b(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    /* compiled from: EditorInfoCompat.java */
    /* renamed from: androidx.core.f.b.a$a */
    private static class a {
        /* renamed from: a */
        static void m2139a(EditorInfo editorInfo, CharSequence charSequence, int i) {
            editorInfo.setInitialSurroundingSubText(charSequence, i);
        }
    }
}
