package com.p126e.p127a.p128a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.C0206p;

/* compiled from: PhotoView.java */
/* renamed from: com.e.a.a.k */
/* loaded from: classes.dex */
public class C1103k extends C0206p {

    /* renamed from: a */
    private ViewOnLayoutChangeListenerC1104l f7459a;

    /* renamed from: b */
    private ImageView.ScaleType f7460b;

    public C1103k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9422a();
    }

    /* renamed from: a */
    private void m9422a() {
        this.f7459a = new ViewOnLayoutChangeListenerC1104l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.f7460b != null) {
            setScaleType(this.f7460b);
            this.f7460b = null;
        }
    }

    public ViewOnLayoutChangeListenerC1104l getAttacher() {
        return this.f7459a;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f7459a.m9486f();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f7459a.m9489h();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f7459a.m9467a(onLongClickListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f7459a.m9466a(onClickListener);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.f7459a == null) {
            this.f7460b = scaleType;
        } else {
            this.f7459a.m9468a(scaleType);
        }
    }

    @Override // androidx.appcompat.widget.C0206p, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f7459a != null) {
            this.f7459a.m9488g();
        }
    }

    @Override // androidx.appcompat.widget.C0206p, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.f7459a != null) {
            this.f7459a.m9488g();
        }
    }

    @Override // androidx.appcompat.widget.C0206p, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f7459a != null) {
            this.f7459a.m9488g();
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f7459a.m9488g();
        }
        return frame;
    }

    public void setRotationTo(float f2) {
        this.f7459a.m9461a(f2);
    }

    public void setRotationBy(float f2) {
        this.f7459a.m9478b(f2);
    }

    public void setZoomable(boolean z) {
        this.f7459a.m9479b(z);
    }

    public RectF getDisplayRect() {
        return this.f7459a.m9460a();
    }

    public float getMinimumScale() {
        return this.f7459a.m9477b();
    }

    public float getMediumScale() {
        return this.f7459a.m9480c();
    }

    public float getMaximumScale() {
        return this.f7459a.m9482d();
    }

    public float getScale() {
        return this.f7459a.m9484e();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f7459a.m9476a(z);
    }

    public void setMinimumScale(float f2) {
        this.f7459a.m9481c(f2);
    }

    public void setMediumScale(float f2) {
        this.f7459a.m9483d(f2);
    }

    public void setMaximumScale(float f2) {
        this.f7459a.m9485e(f2);
    }

    public void setOnMatrixChangeListener(InterfaceC1096d interfaceC1096d) {
        this.f7459a.m9469a(interfaceC1096d);
    }

    public void setOnPhotoTapListener(InterfaceC1098f interfaceC1098f) {
        this.f7459a.m9471a(interfaceC1098f);
    }

    public void setOnOutsidePhotoTapListener(InterfaceC1097e interfaceC1097e) {
        this.f7459a.m9470a(interfaceC1097e);
    }

    public void setOnViewTapListener(InterfaceC1102j interfaceC1102j) {
        this.f7459a.m9475a(interfaceC1102j);
    }

    public void setOnViewDragListener(InterfaceC1101i interfaceC1101i) {
        this.f7459a.m9474a(interfaceC1101i);
    }

    public void setScale(float f2) {
        this.f7459a.m9487f(f2);
    }

    public void setZoomTransitionDuration(int i) {
        this.f7459a.m9464a(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f7459a.m9465a(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(InterfaceC1099g interfaceC1099g) {
        this.f7459a.m9472a(interfaceC1099g);
    }

    public void setOnSingleFlingListener(InterfaceC1100h interfaceC1100h) {
        this.f7459a.m9473a(interfaceC1100h);
    }
}
