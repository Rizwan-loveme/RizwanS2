package androidx.core.p029d;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.p030e.C0268c;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat.java */
/* renamed from: androidx.core.d.a */
/* loaded from: classes.dex */
public class C0265a implements Spannable {

    /* renamed from: a */
    private static final Object f2050a = new Object();

    /* renamed from: b */
    private static Executor f2051b = null;

    /* renamed from: c */
    private final Spannable f2052c;

    /* renamed from: d */
    private final a f2053d;

    /* renamed from: e */
    private final PrecomputedText f2054e;

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: androidx.core.d.a$a */
    public static final class a {

        /* renamed from: a */
        final PrecomputedText.Params f2055a;

        /* renamed from: b */
        private final TextPaint f2056b;

        /* renamed from: c */
        private final TextDirectionHeuristic f2057c;

        /* renamed from: d */
        private final int f2058d;

        /* renamed from: e */
        private final int f2059e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.d.a$a$a, reason: collision with other inner class name */
        public static class C3325a {

            /* renamed from: a */
            private final TextPaint f2060a;

            /* renamed from: b */
            private TextDirectionHeuristic f2061b;

            /* renamed from: c */
            private int f2062c;

            /* renamed from: d */
            private int f2063d;

            public C3325a(TextPaint textPaint) {
                this.f2060a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2062c = 1;
                    this.f2063d = 1;
                } else {
                    this.f2063d = 0;
                    this.f2062c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f2061b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2061b = null;
                }
            }

            /* renamed from: a */
            public C3325a m1947a(int i) {
                this.f2062c = i;
                return this;
            }

            /* renamed from: b */
            public C3325a m1950b(int i) {
                this.f2063d = i;
                return this;
            }

            /* renamed from: a */
            public C3325a m1948a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2061b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: a */
            public a m1949a() {
                return new a(this.f2060a, this.f2061b, this.f2062c, this.f2063d);
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2055a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2055a = null;
            }
            this.f2056b = textPaint;
            this.f2057c = textDirectionHeuristic;
            this.f2058d = i;
            this.f2059e = i2;
        }

        public a(PrecomputedText.Params params) {
            this.f2056b = params.getTextPaint();
            this.f2057c = params.getTextDirection();
            this.f2058d = params.getBreakStrategy();
            this.f2059e = params.getHyphenationFrequency();
            this.f2055a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        /* renamed from: a */
        public TextPaint m1942a() {
            return this.f2056b;
        }

        /* renamed from: b */
        public TextDirectionHeuristic m1944b() {
            return this.f2057c;
        }

        /* renamed from: c */
        public int m1945c() {
            return this.f2058d;
        }

        /* renamed from: d */
        public int m1946d() {
            return this.f2059e;
        }

        /* renamed from: a */
        public boolean m1943a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f2058d != aVar.m1945c() || this.f2059e != aVar.m1946d())) || this.f2056b.getTextSize() != aVar.m1942a().getTextSize() || this.f2056b.getTextScaleX() != aVar.m1942a().getTextScaleX() || this.f2056b.getTextSkewX() != aVar.m1942a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f2056b.getLetterSpacing() != aVar.m1942a().getLetterSpacing() || !TextUtils.equals(this.f2056b.getFontFeatureSettings(), aVar.m1942a().getFontFeatureSettings()))) || this.f2056b.getFlags() != aVar.m1942a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f2056b.getTextLocales().equals(aVar.m1942a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f2056b.getTextLocale().equals(aVar.m1942a().getTextLocale())) {
                return false;
            }
            if (this.f2056b.getTypeface() == null) {
                if (aVar.m1942a().getTypeface() != null) {
                    return false;
                }
            } else if (!this.f2056b.getTypeface().equals(aVar.m1942a().getTypeface())) {
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (m1943a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f2057c == aVar.m1944b();
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return C0268c.m1952a(Float.valueOf(this.f2056b.getTextSize()), Float.valueOf(this.f2056b.getTextScaleX()), Float.valueOf(this.f2056b.getTextSkewX()), Float.valueOf(this.f2056b.getLetterSpacing()), Integer.valueOf(this.f2056b.getFlags()), this.f2056b.getTextLocales(), this.f2056b.getTypeface(), Boolean.valueOf(this.f2056b.isElegantTextHeight()), this.f2057c, Integer.valueOf(this.f2058d), Integer.valueOf(this.f2059e));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return C0268c.m1952a(Float.valueOf(this.f2056b.getTextSize()), Float.valueOf(this.f2056b.getTextScaleX()), Float.valueOf(this.f2056b.getTextSkewX()), Float.valueOf(this.f2056b.getLetterSpacing()), Integer.valueOf(this.f2056b.getFlags()), this.f2056b.getTextLocale(), this.f2056b.getTypeface(), Boolean.valueOf(this.f2056b.isElegantTextHeight()), this.f2057c, Integer.valueOf(this.f2058d), Integer.valueOf(this.f2059e));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return C0268c.m1952a(Float.valueOf(this.f2056b.getTextSize()), Float.valueOf(this.f2056b.getTextScaleX()), Float.valueOf(this.f2056b.getTextSkewX()), Integer.valueOf(this.f2056b.getFlags()), this.f2056b.getTextLocale(), this.f2056b.getTypeface(), this.f2057c, Integer.valueOf(this.f2058d), Integer.valueOf(this.f2059e));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return C0268c.m1952a(Float.valueOf(this.f2056b.getTextSize()), Float.valueOf(this.f2056b.getTextScaleX()), Float.valueOf(this.f2056b.getTextSkewX()), Integer.valueOf(this.f2056b.getFlags()), this.f2056b.getTextLocale(), this.f2056b.getTypeface(), this.f2057c, Integer.valueOf(this.f2058d), Integer.valueOf(this.f2059e));
            }
            return C0268c.m1952a(Float.valueOf(this.f2056b.getTextSize()), Float.valueOf(this.f2056b.getTextScaleX()), Float.valueOf(this.f2056b.getTextSkewX()), Integer.valueOf(this.f2056b.getFlags()), this.f2056b.getTypeface(), this.f2057c, Integer.valueOf(this.f2058d), Integer.valueOf(this.f2059e));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2056b.getTextSize());
            sb.append(", textScaleX=" + this.f2056b.getTextScaleX());
            sb.append(", textSkewX=" + this.f2056b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f2056b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2056b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f2056b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f2056b.getTextLocale());
            }
            sb.append(", typeface=" + this.f2056b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f2056b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2057c);
            sb.append(", breakStrategy=" + this.f2058d);
            sb.append(", hyphenationFrequency=" + this.f2059e);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public PrecomputedText m1940a() {
        if (this.f2052c instanceof PrecomputedText) {
            return (PrecomputedText) this.f2052c;
        }
        return null;
    }

    /* renamed from: b */
    public a m1941b() {
        return this.f2053d;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2054e.setSpan(obj, i, i2, i3);
        } else {
            this.f2052c.setSpan(obj, i, i2, i3);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2054e.removeSpan(obj);
        } else {
            this.f2052c.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f2054e.getSpans(i, i2, cls) : (T[]) this.f2052c.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2052c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2052c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2052c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f2052c.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2052c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f2052c.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f2052c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2052c.toString();
    }
}
