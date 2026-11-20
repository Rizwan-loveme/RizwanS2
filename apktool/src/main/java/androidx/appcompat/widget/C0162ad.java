package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.p031f.InterfaceC0307w;

/* compiled from: AppCompatToggleButton.java */
/* renamed from: androidx.appcompat.widget.ad */
/* loaded from: classes.dex */
public class C0162ad extends ToggleButton implements InterfaceC0307w {

    /* renamed from: a */
    private final C0196f f1408a;

    /* renamed from: b */
    private final C0159aa f1409b;

    public C0162ad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0012R.attr.buttonStyleToggle);
    }

    public C0162ad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1408a = new C0196f(this);
        this.f1408a.m1530a(attributeSet, i);
        this.f1409b = new C0159aa(this);
        this.f1409b.m1176a(attributeSet, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1408a != null) {
            this.f1408a.m1526a(i);
        }
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1408a != null) {
            this.f1408a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1408a != null) {
            this.f1408a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1408a != null) {
            return this.f1408a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1408a != null) {
            this.f1408a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1408a != null) {
            return this.f1408a.m1531b();
        }
        return null;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1408a != null) {
            this.f1408a.m1533c();
        }
        if (this.f1409b != null) {
            this.f1409b.m1182b();
        }
    }
}
