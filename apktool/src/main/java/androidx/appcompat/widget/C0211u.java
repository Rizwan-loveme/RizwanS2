package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.C0059a;

/* compiled from: AppCompatRatingBar.java */
/* renamed from: androidx.appcompat.widget.u */
/* loaded from: classes.dex */
public class C0211u extends RatingBar {

    /* renamed from: a */
    private final C0209s f1743a;

    public C0211u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.ratingBarStyle);
    }

    public C0211u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1743a = new C0209s(this);
        this.f1743a.mo1577a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap m1576a = this.f1743a.m1576a();
        if (m1576a != null) {
            setMeasuredDimension(View.resolveSizeAndState(m1576a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
