package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.C0059a;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.InterfaceC0343m;

/* compiled from: AppCompatImageButton.java */
/* renamed from: androidx.appcompat.widget.n */
/* loaded from: classes.dex */
public class C0204n extends ImageButton implements InterfaceC0307w, InterfaceC0343m {

    /* renamed from: a */
    private final C0196f f1724a;

    /* renamed from: b */
    private final C0205o f1725b;

    public C0204n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.imageButtonStyle);
    }

    public C0204n(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1724a = new C0196f(this);
        this.f1724a.m1530a(attributeSet, i);
        this.f1725b = new C0205o(this);
        this.f1725b.m1566a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f1725b.m1563a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f1725b != null) {
            this.f1725b.m1570d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f1725b != null) {
            this.f1725b.m1570d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f1725b != null) {
            this.f1725b.m1570d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1724a != null) {
            this.f1724a.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1724a != null) {
            this.f1724a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1724a != null) {
            this.f1724a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1724a != null) {
            return this.f1724a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1724a != null) {
            this.f1724a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1724a != null) {
            return this.f1724a.m1531b();
        }
        return null;
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f1725b != null) {
            this.f1725b.m1564a(colorStateList);
        }
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public ColorStateList getSupportImageTintList() {
        if (this.f1725b != null) {
            return this.f1725b.m1568b();
        }
        return null;
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f1725b != null) {
            this.f1725b.m1565a(mode);
        }
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f1725b != null) {
            return this.f1725b.m1569c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1724a != null) {
            this.f1724a.m1533c();
        }
        if (this.f1725b != null) {
            this.f1725b.m1570d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1725b.m1567a() && super.hasOverlappingRendering();
    }
}
