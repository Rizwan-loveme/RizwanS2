package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.C0059a;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p031f.C0308x;

/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: androidx.appcompat.widget.x */
/* loaded from: classes.dex */
class C0214x extends C0209s {

    /* renamed from: a */
    private final SeekBar f1746a;

    /* renamed from: b */
    private Drawable f1747b;

    /* renamed from: c */
    private ColorStateList f1748c;

    /* renamed from: d */
    private PorterDuff.Mode f1749d;

    /* renamed from: e */
    private boolean f1750e;

    /* renamed from: f */
    private boolean f1751f;

    C0214x(SeekBar seekBar) {
        super(seekBar);
        this.f1748c = null;
        this.f1749d = null;
        this.f1750e = false;
        this.f1751f = false;
        this.f1746a = seekBar;
    }

    @Override // androidx.appcompat.widget.C0209s
    /* renamed from: a */
    void mo1577a(AttributeSet attributeSet, int i) {
        super.mo1577a(attributeSet, i);
        C0184az m1432a = C0184az.m1432a(this.f1746a.getContext(), attributeSet, C0059a.j.AppCompatSeekBar, i, 0);
        C0308x.m2230a(this.f1746a, this.f1746a.getContext(), C0059a.j.AppCompatSeekBar, attributeSet, m1432a.m1435a(), i, 0);
        Drawable m1440b = m1432a.m1440b(C0059a.j.AppCompatSeekBar_android_thumb);
        if (m1440b != null) {
            this.f1746a.setThumb(m1440b);
        }
        m1587a(m1432a.m1437a(C0059a.j.AppCompatSeekBar_tickMark));
        if (m1432a.m1451g(C0059a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1749d = C0165ag.m1261a(m1432a.m1434a(C0059a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1749d);
            this.f1751f = true;
        }
        if (m1432a.m1451g(C0059a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f1748c = m1432a.m1447e(C0059a.j.AppCompatSeekBar_tickMarkTint);
            this.f1750e = true;
        }
        m1432a.m1441b();
        m1585d();
    }

    /* renamed from: a */
    void m1587a(Drawable drawable) {
        if (this.f1747b != null) {
            this.f1747b.setCallback(null);
        }
        this.f1747b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1746a);
            C0315a.m2365b(drawable, C0308x.m2257f(this.f1746a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1746a.getDrawableState());
            }
            m1585d();
        }
        this.f1746a.invalidate();
    }

    /* renamed from: d */
    private void m1585d() {
        if (this.f1747b != null) {
            if (this.f1750e || this.f1751f) {
                this.f1747b = C0315a.m2369f(this.f1747b.mutate());
                if (this.f1750e) {
                    C0315a.m2359a(this.f1747b, this.f1748c);
                }
                if (this.f1751f) {
                    C0315a.m2362a(this.f1747b, this.f1749d);
                }
                if (this.f1747b.isStateful()) {
                    this.f1747b.setState(this.f1746a.getDrawableState());
                }
            }
        }
    }

    /* renamed from: b */
    void m1588b() {
        if (this.f1747b != null) {
            this.f1747b.jumpToCurrentState();
        }
    }

    /* renamed from: c */
    void m1589c() {
        Drawable drawable = this.f1747b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1746a.getDrawableState())) {
            this.f1746a.invalidateDrawable(drawable);
        }
    }

    /* renamed from: a */
    void m1586a(Canvas canvas) {
        int max;
        if (this.f1747b != null && (max = this.f1746a.getMax()) > 1) {
            int intrinsicWidth = this.f1747b.getIntrinsicWidth();
            int intrinsicHeight = this.f1747b.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.f1747b.setBounds(-i, -i2, i, i2);
            float width = ((this.f1746a.getWidth() - this.f1746a.getPaddingLeft()) - this.f1746a.getPaddingRight()) / max;
            int save = canvas.save();
            canvas.translate(this.f1746a.getPaddingLeft(), this.f1746a.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.f1747b.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }
}
