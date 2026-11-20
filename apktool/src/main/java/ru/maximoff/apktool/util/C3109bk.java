package ru.maximoff.apktool.util;

import android.icu.text.DateFormat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SpanFormatter.java */
/* renamed from: ru.maximoff.apktool.util.bk */
/* loaded from: classes.dex */
public class C3109bk {

    /* renamed from: a */
    public static final Pattern f18379a = Pattern.compile("%([0-9]+\\$|<?)([^a-zA-z%]*)([[a-zA-Z%]&&[^tT]]|[tT][a-zA-Z])");

    /* renamed from: a */
    public static SpannedString m18982a(CharSequence charSequence, Object... objArr) {
        return m18983a(Locale.getDefault(), charSequence, objArr);
    }

    /* renamed from: a */
    public static SpannedString m18983a(Locale locale, CharSequence charSequence, Object... objArr) {
        int parseInt;
        int i;
        CharSequence format;
        int i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i3 = -1;
        int i4 = 0;
        while (i4 < spannableStringBuilder.length()) {
            Matcher matcher = f18379a.matcher(spannableStringBuilder);
            if (!matcher.find(i4)) {
                break;
            }
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            if (group3.equals("%")) {
                format = "%";
                i2 = i3;
            } else if (group3.equals("n")) {
                format = "\n";
                i2 = i3;
            } else {
                if (group.equals("")) {
                    int i5 = i3 + 1;
                    parseInt = i5;
                    i = i5;
                } else if (group.equals("<")) {
                    parseInt = i3;
                    i = i3;
                } else {
                    parseInt = Integer.parseInt(group.substring(0, group.length() - 1)) - 1;
                    i = i3;
                }
                Object obj = objArr[parseInt];
                if (group3.equals(DateFormat.SECOND) && (obj instanceof Spanned)) {
                    format = (Spanned) obj;
                    i2 = i;
                } else {
                    format = String.format(locale, new StringBuffer().append(new StringBuffer().append("%").append(group2).toString()).append(group3).toString(), obj);
                    i2 = i;
                }
            }
            spannableStringBuilder.replace(start, end, format);
            i4 = start + format.length();
            i3 = i2;
        }
        return new SpannedString(spannableStringBuilder);
    }
}
