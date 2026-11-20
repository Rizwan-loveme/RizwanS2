package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.InterfaceC0341k;

/* compiled from: AppCompatRadioButton.java */
/* renamed from: androidx.appcompat.widget.t */
/* loaded from: classes.dex */
public class C0210t extends RadioButton implements InterfaceC0307w, InterfaceC0341k {

    /* renamed from: a */
    private final C0200j f1740a;

    /* renamed from: b */
    private final C0196f f1741b;

    /* renamed from: c */
    private final C0159aa f1742c;

    public C0210t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.radioButtonStyle);
    }

    public C0210t(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1740a = new C0200j(this);
        this.f1740a.m1538a(attributeSet, i);
        this.f1741b = new C0196f(this);
        this.f1741b.m1530a(attributeSet, i);
        this.f1742c = new C0159aa(this);
        this.f1742c.m1176a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1740a != null) {
            this.f1740a.m1540c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(C0060a.m348b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (this.f1740a == null) {
            return compoundPaddingLeft;
        }
        return this.f1740a.m1534a(compoundPaddingLeft);
    }

    @Override // androidx.core.widget.InterfaceC0341k
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1740a != null) {
            this.f1740a.m1536a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1740a != null) {
            return this.f1740a.m1535a();
        }
        return null;
    }

    @Override // androidx.core.widget.InterfaceC0341k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1740a != null) {
            this.f1740a.m1537a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1740a != null) {
            return this.f1740a.m1539b();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1741b != null) {
            this.f1741b.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1741b != null) {
            return this.f1741b.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1741b != null) {
            this.f1741b.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1741b != null) {
            return this.f1741b.m1531b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1741b != null) {
            this.f1741b.m1529a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1741b != null) {
            this.f1741b.m1526a(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1741b != null) {
            this.f1741b.m1533c();
        }
        if (this.f1742c != null) {
            this.f1742c.m1182b();
        }
    }
}
