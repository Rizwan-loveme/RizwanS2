package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.InterfaceC0343m;

/* compiled from: AppCompatImageView.java */
/* renamed from: androidx.appcompat.widget.p */
/* loaded from: classes.dex */
public class C0206p extends ImageView implements InterfaceC0307w, InterfaceC0343m {

    /* renamed from: a */
    private final C0196f f1730a;

    /* renamed from: b */
    private final C0205o f1731b;

    public C0206p(Context context) {
        this(context, null);
    }

    public C0206p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0206p(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1730a = new C0196f(this);
        this.f1730a.m1530a(attributeSet, i);
        this.f1731b = new C0205o(this);
        this.f1731b.m1566a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f1731b != null) {
            this.f1731b.m1563a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f1731b != null) {
            this.f1731b.m1570d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f1731b != null) {
            this.f1731b.m1570d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f1731b != null) {
            this.f1731b.m1570d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1730a != null) {
            this.f1730a.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1730a != null) {
            this.f1730a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1730a != null) {
            this.f1730a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1730a != null) {
            return this.f1730a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1730a != null) {
            this.f1730a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1730a != null) {
            return this.f1730a.m1531b();
        }
        return null;
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f1731b != null) {
            this.f1731b.m1564a(colorStateList);
        }
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public ColorStateList getSupportImageTintList() {
        if (this.f1731b != null) {
            return this.f1731b.m1568b();
        }
        return null;
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f1731b != null) {
            this.f1731b.m1565a(mode);
        }
    }

    @Override // androidx.core.widget.InterfaceC0343m
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f1731b != null) {
            return this.f1731b.m1569c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1730a != null) {
            this.f1730a.m1533c();
        }
        if (this.f1731b != null) {
            this.f1731b.m1570d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1731b.m1567a() && super.hasOverlappingRendering();
    }
}
