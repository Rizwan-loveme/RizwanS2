package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ru.maximoff.apktool.util.C3246h;

/* loaded from: classes.dex */
public class DiffTextView extends TextView {

    /* renamed from: A */
    private Scroller f20754A;

    /* renamed from: B */
    private boolean f20755B;

    /* renamed from: C */
    private float f20756C;

    /* renamed from: D */
    private float f20757D;

    /* renamed from: a */
    private Map<String, String> f20758a;

    /* renamed from: b */
    private Map<Integer, Boolean> f20759b;

    /* renamed from: c */
    private List<Integer> f20760c;

    /* renamed from: d */
    private int f20761d;

    /* renamed from: e */
    private int f20762e;

    /* renamed from: f */
    private int f20763f;

    /* renamed from: g */
    private int f20764g;

    /* renamed from: h */
    private int f20765h;

    /* renamed from: i */
    private int f20766i;

    /* renamed from: j */
    private int f20767j;

    /* renamed from: k */
    private int f20768k;

    /* renamed from: l */
    private int f20769l;

    /* renamed from: m */
    private int f20770m;

    /* renamed from: n */
    private int f20771n;

    /* renamed from: o */
    private int f20772o;

    /* renamed from: p */
    private int f20773p;

    /* renamed from: q */
    private int f20774q;

    /* renamed from: r */
    private boolean f20775r;

    /* renamed from: s */
    private boolean f20776s;

    /* renamed from: t */
    private boolean f20777t;

    /* renamed from: u */
    private boolean f20778u;

    /* renamed from: v */
    private float f20779v;

    /* renamed from: w */
    private float f20780w;

    /* renamed from: x */
    private boolean f20781x;

    /* renamed from: y */
    private Paint f20782y;

    /* renamed from: z */
    private GestureDetector f20783z;

    public DiffTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20766i = 0;
        this.f20767j = 0;
        this.f20768k = 0;
        this.f20769l = 0;
        this.f20770m = 0;
        this.f20771n = 0;
        this.f20772o = 0;
        this.f20773p = 0;
        this.f20774q = 0;
        this.f20775r = true;
        this.f20776s = true;
        this.f20777t = false;
        this.f20778u = false;
        this.f20779v = 0;
        this.f20780w = 0;
        this.f20781x = false;
        this.f20755B = false;
        this.f20756C = 0;
        this.f20757D = 0;
        m19726a(context);
    }

    public DiffTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20766i = 0;
        this.f20767j = 0;
        this.f20768k = 0;
        this.f20769l = 0;
        this.f20770m = 0;
        this.f20771n = 0;
        this.f20772o = 0;
        this.f20773p = 0;
        this.f20774q = 0;
        this.f20775r = true;
        this.f20776s = true;
        this.f20777t = false;
        this.f20778u = false;
        this.f20779v = 0;
        this.f20780w = 0;
        this.f20781x = false;
        this.f20755B = false;
        this.f20756C = 0;
        this.f20757D = 0;
        m19726a(context);
    }

    public DiffTextView(Context context) {
        super(context);
        this.f20766i = 0;
        this.f20767j = 0;
        this.f20768k = 0;
        this.f20769l = 0;
        this.f20770m = 0;
        this.f20771n = 0;
        this.f20772o = 0;
        this.f20773p = 0;
        this.f20774q = 0;
        this.f20775r = true;
        this.f20776s = true;
        this.f20777t = false;
        this.f20778u = false;
        this.f20779v = 0;
        this.f20780w = 0;
        this.f20781x = false;
        this.f20755B = false;
        this.f20756C = 0;
        this.f20757D = 0;
        m19726a(context);
    }

    /* renamed from: a */
    public void m19726a(Context context) {
        setMaxLines(Integer.MAX_VALUE);
        setEllipsize((TextUtils.TruncateAt) null);
        setSingleLine(false);
        setTextIsSelectable(true);
        this.f20756C = m19716a(context, R.dimen.scrollbar_width);
        this.f20757D = m19716a(context, R.dimen.scrollbar_margin);
        this.f20782y = new Paint();
        this.f20758a = new LinkedHashMap();
        this.f20759b = new LinkedHashMap();
        this.f20760c = new ArrayList();
        this.f20782y.setAntiAlias(true);
        this.f20782y.setStyle(Paint.Style.FILL);
        this.f20754A = new Scroller(context);
        this.f20783z = new GestureDetector(context, new C3269a(this));
        setHorizontallyScrolling(true);
    }

    public void setWrapTextEnabled(boolean z) {
        if (this.f20759b != null) {
            this.f20759b.clear();
        }
        this.f20755B = z;
        setHorizontallyScrolling(!z);
        requestLayout();
        m19732d();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f20779v = motionEvent.getX();
                this.f20780w = motionEvent.getY();
                this.f20781x = false;
                break;
            case 1:
                this.f20781x = false;
                break;
            case 2:
                if (!this.f20781x) {
                    float abs = Math.abs(motionEvent.getX() - this.f20779v);
                    float abs2 = Math.abs(motionEvent.getY() - this.f20780w);
                    if (abs > 10 || abs2 > 10) {
                        this.f20781x = true;
                        break;
                    }
                }
                break;
        }
        this.f20783z.onTouchEvent(motionEvent);
        if (!this.f20778u || this.f20781x) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        if (this.f20754A.computeScrollOffset()) {
            scrollTo(this.f20754A.getCurrX(), this.f20754A.getCurrY());
            postInvalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        if (this.f20782y != null) {
            this.f20782y.setTypeface(typeface);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        super.setTextSize(i, f2);
        if (this.f20782y != null) {
            this.f20782y.setTextSize(getTextSize());
        }
    }

    public void setSelectionMode(boolean z) {
        this.f20778u = z;
    }

    public void setLayoutFrozen(boolean z) {
        this.f20777t = z;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f20777t) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setSelectionColor(int i) {
        this.f20768k = i;
    }

    public void setFirstColor(int i) {
        this.f20761d = i;
    }

    public void setSecondColor(int i) {
        this.f20762e = i;
    }

    public void setFirstLnColor(int i) {
        this.f20763f = i;
    }

    public void setSecondLnColor(int i) {
        this.f20764g = i;
    }

    public void setBorderSize(int i) {
        this.f20773p = i;
    }

    public void setDividerColor(int i) {
        this.f20765h = i;
    }

    /* renamed from: a */
    public int[] m19729a(int i, int i2) {
        int i3;
        int i4;
        int min;
        int min2;
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) getText();
        try {
            for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Class.forName("android.text.style.BackgroundColorSpan"))) {
                spannableStringBuilder.removeSpan(backgroundColorSpan);
            }
            if (i > 0 || i2 > 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f20768k), i, i2, 33);
                Layout layout = getLayout();
                int i5 = 0;
                while (true) {
                    if (i5 >= getLineCount()) {
                        i3 = -1;
                        i4 = -1;
                        break;
                    }
                    int lineStart = layout.getLineStart(i5);
                    int lineEnd = layout.getLineEnd(i5);
                    if (i < lineStart || i >= lineEnd) {
                        i5++;
                    } else {
                        int lineTop = layout.getLineTop(i5);
                        CharSequence subSequence = spannableStringBuilder.subSequence(lineStart, i);
                        i3 = subSequence.length() > 0 ? (int) this.f20782y.measureText(subSequence.toString()) : 0;
                        i4 = lineTop;
                    }
                }
                min = Math.min(i4, m19731c());
                min2 = Math.min(i3, m19730b());
            } else {
                min2 = -1;
                min = -1;
            }
            return new int[]{min, min2};
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: a */
    public void m19725a() {
        if (this.f20759b != null) {
            this.f20759b.clear();
        }
        this.f20772o = (int) this.f20782y.measureText(" ");
        if (this.f20775r) {
            this.f20770m = (int) this.f20782y.measureText(new StringBuffer().append(String.valueOf(this.f20766i)).append(" ").toString());
            this.f20771n = (int) this.f20782y.measureText(new StringBuffer().append(String.valueOf(this.f20767j)).append(" ").toString());
            this.f20769l = Math.max(0, (this.f20770m + this.f20771n) - getScrollX());
            setPadding(this.f20769l + (this.f20772o / 2), 0, 0, 0);
        } else {
            this.f20769l = 0;
            this.f20770m = 0;
            this.f20771n = 0;
            setPadding(0, 0, 0, 0);
        }
        requestLayout();
        m19732d();
    }

    /* renamed from: a */
    private boolean m19724a(CharSequence charSequence, Layout layout, int i) {
        Boolean bool = this.f20759b.get(new Integer(i));
        if (bool == null) {
            bool = Boolean.valueOf(charSequence.charAt(layout.getLineStart(i) + (-1)) == '\n');
            this.f20759b.put(new Integer(i), bool);
        }
        return bool.booleanValue();
    }

    private int getContentWidth() {
        if (getLayout() == null) {
            return 0;
        }
        if (this.f20755B) {
            return getWidth();
        }
        return this.f20774q + getPaddingRight() + getPaddingLeft();
    }

    private int getContentHeight() {
        Layout layout = getLayout();
        if (layout == null) {
            return 0;
        }
        return layout.getHeight() + getPaddingTop() + getPaddingBottom();
    }

    /* renamed from: b */
    public int m19730b() {
        return Math.max(0, getContentWidth() - getWidth());
    }

    /* renamed from: c */
    public int m19731c() {
        return Math.max(0, getContentHeight() - getHeight());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f20777t) {
            this.f20760c.clear();
            Layout layout = getLayout();
            if (layout == null || this.f20758a == null || this.f20758a.isEmpty()) {
                super.onDraw(canvas);
                return;
            }
            int scrollY = getScrollY();
            int scrollX = getScrollX();
            int width = getWidth();
            int height = getHeight();
            int lineCount = getLineCount();
            int lineHeight = getLineHeight();
            float f2 = height / (lineCount * lineHeight);
            this.f20776s = layout.getHeight() / height >= 2;
            canvas.save();
            m19721a(canvas, scrollX, scrollY, width, height, this.f20776s);
            m19723a(canvas, layout, scrollX, scrollY, width, height, lineCount, lineHeight, f2, this.f20776s);
            m19719a(canvas);
            canvas.restore();
            super.onDraw(canvas);
        }
    }

    /* renamed from: a */
    private void m19721a(Canvas canvas, int i, int i2, int i3, int i4, boolean z) {
        if (this.f20775r) {
            this.f20782y.setColor(this.f20763f);
            canvas.drawRect(i, i2, this.f20770m + i, i2 + i4, this.f20782y);
            this.f20782y.setColor(this.f20764g);
            canvas.drawRect(this.f20770m + i, i2, this.f20769l + i, i2 + i4, this.f20782y);
        }
        if (z) {
            this.f20782y.setColor(C3246h.m19469a(this.f20765h, 70));
            canvas.drawRect((i + i3) - this.f20773p, i2, i + i3, i2 + i4, this.f20782y);
        }
    }

    /* renamed from: a */
    private void m19723a(Canvas canvas, Layout layout, int i, int i2, int i3, int i4, int i5, int i6, float f2, boolean z) {
        boolean z2;
        Map.Entry<String, String> next;
        boolean z3;
        int lineWidth;
        CharSequence text = getText();
        Iterator<Map.Entry<String, String>> it = this.f20758a.entrySet().iterator();
        Map.Entry<String, String> entry = (Map.Entry) null;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        while (i7 < i5) {
            if (i7 == 0 || m19724a(text, layout, i7)) {
                z2 = true;
                next = it.next();
            } else {
                z2 = z5;
                next = entry;
            }
            int lineTop = layout.getLineTop(i7);
            int lineBottom = layout.getLineBottom(i7);
            int lineBaseline = layout.getLineBaseline(i7);
            boolean z6 = lineTop + i6 >= i2 && lineBottom - i6 <= i2 + i4;
            if (z6 && !this.f20755B && (lineWidth = (int) layout.getLineWidth(i7)) > this.f20774q) {
                this.f20774q = lineWidth;
            }
            String key = next.getKey();
            String value = next.getValue();
            char charAt = key.charAt(0);
            int i8 = 0;
            int i9 = 0;
            if (charAt == 'x') {
                i8 = this.f20762e;
                i9 = this.f20764g;
            } else if (value.isEmpty()) {
                i8 = this.f20761d;
                i9 = this.f20763f;
            }
            if (i9 != 0) {
                if (!z4) {
                    this.f20760c.add(new Integer(lineTop));
                    z4 = true;
                }
                if (z6) {
                    m19720a(canvas, i, lineTop, lineBottom, i3, i8, i9);
                }
                if (z && i8 != 0) {
                    this.f20782y.setColor(i8);
                    canvas.drawRect((i + i3) - this.f20773p, ((int) (lineTop * f2)) + i2, i + i3, r4 + Math.max(1, (int) (i6 * f2)), this.f20782y);
                }
                z3 = z4;
            } else {
                z3 = false;
            }
            if (this.f20775r && z6 && z2) {
                z2 = false;
                m19722a(canvas, i, lineBaseline, key, value, charAt);
            }
            i7++;
            z5 = z2;
            z4 = z3;
            entry = next;
        }
        if (this.f20775r) {
            this.f20782y.setColor(this.f20765h);
            canvas.drawLine(this.f20769l + i, i2, this.f20769l + i, i2 + i4, this.f20782y);
        }
    }

    /* renamed from: a */
    private void m19720a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f20775r && i5 != 0) {
            this.f20782y.setColor(i5);
            canvas.drawRect(i, i2, this.f20769l + i, i3, this.f20782y);
        }
        this.f20782y.setColor(i6);
        canvas.drawRect(this.f20769l + i, i2, i + i4, i3, this.f20782y);
    }

    /* renamed from: a */
    private void m19722a(Canvas canvas, int i, int i2, String str, String str2, char c2) {
        this.f20782y.setColor(getCurrentTextColor());
        if (c2 == 'x') {
            str = "";
        } else if (c2 == 'z') {
            str2 = "";
            str = "";
        }
        int measureText = (int) this.f20782y.measureText(str2);
        canvas.drawText(str, (this.f20772o / 2) + i, i2, this.f20782y);
        canvas.drawText(str2, ((this.f20769l + i) - measureText) - (this.f20772o / 2), i2, this.f20782y);
    }

    /* renamed from: a */
    private void m19719a(Canvas canvas) {
        if (this.f20756C > 0) {
            if (this.f20757D < 0) {
                this.f20757D = 0.0f;
            }
            int color = this.f20782y.getColor();
            this.f20782y.setColor(Color.GRAY);
            int width = getWidth();
            int height = getHeight();
            int m19730b = m19730b();
            int m19731c = m19731c();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (m19731c > height) {
                float max = Math.max((height / (height + m19731c)) * height, this.f20756C);
                float f2 = (scrollY / m19731c) * (height - max);
                canvas.drawRect((((scrollX + width) - this.f20756C) - this.f20757D) - this.f20773p, scrollY + f2, ((scrollX + width) - this.f20757D) - this.f20773p, max + f2 + scrollY, this.f20782y);
            }
            if (m19730b > width) {
                float max2 = Math.max((width / (width + m19730b)) * width, this.f20756C);
                float f3 = (scrollX / m19730b) * (width - max2);
                canvas.drawRect(scrollX + f3, ((scrollY + height) - this.f20756C) - this.f20757D, f3 + scrollX + max2, (scrollY + height) - this.f20757D, this.f20782y);
            }
            this.f20782y.setColor(color);
        }
    }

    /* renamed from: a */
    public void m19727a(String str, String str2) {
        if (this.f20758a.isEmpty()) {
            m19725a();
        }
        this.f20758a.put(str, str2);
    }

    public void setFirstMaxNum(int i) {
        this.f20766i = i;
    }

    public void setSecondMaxNum(int i) {
        this.f20767j = i;
    }

    /* renamed from: a */
    public void m19728a(boolean z) {
        this.f20775r = z;
    }

    /* renamed from: d */
    public void m19732d() {
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(16L);
        }
    }

    /* renamed from: e */
    public void m19733e() {
        if (this.f20758a != null) {
            this.f20758a.clear();
        }
        if (this.f20759b != null) {
            this.f20759b.clear();
        }
        this.f20769l = 0;
        this.f20770m = 0;
        this.f20771n = 0;
        setText("");
        setPadding(0, 0, 0, 0);
        m19732d();
    }

    /* renamed from: f */
    public List<Integer> m19734f() {
        return this.f20760c;
    }

    /* renamed from: g */
    public boolean m19735g() {
        return this.f20776s;
    }

    @Override // android.view.View
    public String toString() {
        String str;
        String charSequence = getText().toString();
        String[] split = charSequence.split("\n");
        if (this.f20758a != null && split.length == this.f20758a.size()) {
            int length = String.valueOf(this.f20766i).length();
            int length2 = String.valueOf(this.f20767j).length();
            Iterator<Map.Entry<String, String>> it = this.f20758a.entrySet().iterator();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < split.length) {
                    String str2 = split[i2];
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    char charAt = key.charAt(0);
                    if (this.f20775r) {
                        sb.append((charAt == 'x' || charAt == 'z') ? m19718a(length) : String.format(Locale.f10688US, new StringBuffer().append(new StringBuffer().append("%0").append(length).toString()).append(DateFormat.DAY).toString(), new Integer(Integer.parseInt(key)))).append("|").append((value.isEmpty() || charAt == 'z') ? m19718a(length2) : String.format(Locale.f10688US, new StringBuffer().append(new StringBuffer().append("%0").append(length2).toString()).append(DateFormat.DAY).toString(), new Integer(Integer.parseInt(value)))).append("|");
                    }
                    if (charAt == 'x') {
                        str = "-";
                    } else {
                        str = value.isEmpty() ? "+" : "=";
                    }
                    sb.append(str).append("|").append(str2).append("\n");
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        } else {
            return charSequence;
        }
    }

    /* renamed from: a */
    private String m19718a(int i) {
        return String.format(Locale.f10688US, new StringBuffer().append(new StringBuffer().append("%1$").append(i).toString()).append(DateFormat.SECOND).toString(), "");
    }

    /* renamed from: a */
    private float m19716a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* renamed from: ru.maximoff.apktool.view.DiffTextView$a */
    private class C3269a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a */
        private final DiffTextView f20784a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            this.f20784a.scrollTo(Math.max(0, Math.min(this.f20784a.getScrollX() + ((int) f2), this.f20784a.m19730b())), Math.max(0, Math.min(this.f20784a.getScrollY() + ((int) f3), this.f20784a.m19731c())));
            this.f20784a.m19732d();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            this.f20784a.f20754A.fling(this.f20784a.getScrollX(), this.f20784a.getScrollY(), (int) (-f2), (int) (-f3), 0, this.f20784a.m19730b(), 0, this.f20784a.m19731c());
            this.f20784a.m19732d();
            return true;
        }

        public C3269a(DiffTextView diffTextView) {
            this.f20784a = diffTextView;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        C3270b c3270b = new C3270b(super.onSaveInstanceState());
        c3270b.f20785a = getScrollX();
        c3270b.f20786b = getScrollY();
        return c3270b;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C3270b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3270b c3270b = (C3270b) parcelable;
        super.onRestoreInstanceState(c3270b.getSuperState());
        scrollTo(c3270b.f20785a, c3270b.f20786b);
    }

    /* renamed from: ru.maximoff.apktool.view.DiffTextView$b */
    private static class C3270b extends View.BaseSavedState {
        public static final Parcelable.Creator<C3270b> CREATOR = new Parcelable.Creator<C3270b>() { // from class: ru.maximoff.apktool.view.DiffTextView.b.1
            @Override // android.os.Parcelable.Creator
            public C3270b createFromParcel(Parcel parcel) {
                return m19736a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public C3270b[] newArray(int i) {
                return m19737a(i);
            }

            /* renamed from: a */
            public C3270b m19736a(Parcel parcel) {
                return new C3270b(parcel);
            }

            /* renamed from: a */
            public C3270b[] m19737a(int i) {
                return new C3270b[i];
            }
        };

        /* renamed from: a */
        int f20785a;

        /* renamed from: b */
        int f20786b;

        C3270b(Parcelable parcelable) {
            super(parcelable);
        }

        C3270b(Parcel parcel) {
            super(parcel);
            this.f20785a = parcel.readInt();
            this.f20786b = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f20785a);
            parcel.writeInt(this.f20786b);
        }
    }
}
