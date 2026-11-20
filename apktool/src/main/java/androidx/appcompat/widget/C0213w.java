package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.C0059a;

/* compiled from: AppCompatSeekBar.java */
/* renamed from: androidx.appcompat.widget.w */
/* loaded from: classes.dex */
public class C0213w extends SeekBar {

    /* renamed from: a */
    private final C0214x f1745a;

    public C0213w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.seekBarStyle);
    }

    public C0213w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1745a = new C0214x(this);
        this.f1745a.mo1577a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1745a.m1586a(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1745a.m1589c();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1745a.m1588b();
    }
}
