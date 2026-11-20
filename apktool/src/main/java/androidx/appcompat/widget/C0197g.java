package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.C0059a;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.C0339i;
import androidx.core.widget.InterfaceC0332b;
import androidx.core.widget.InterfaceC0342l;

/* compiled from: AppCompatButton.java */
/* renamed from: androidx.appcompat.widget.g */
/* loaded from: classes.dex */
public class C0197g extends Button implements InterfaceC0307w, InterfaceC0332b, InterfaceC0342l {

    /* renamed from: a */
    private final C0196f f1698a;

    /* renamed from: b */
    private final C0159aa f1699b;

    public C0197g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.buttonStyle);
    }

    public C0197g(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1698a = new C0196f(this);
        this.f1698a.m1530a(attributeSet, i);
        this.f1699b = new C0159aa(this);
        this.f1699b.m1176a(attributeSet, i);
        this.f1699b.m1182b();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1698a != null) {
            this.f1698a.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1698a != null) {
            this.f1698a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1698a != null) {
            this.f1698a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1698a != null) {
            return this.f1698a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1698a != null) {
            this.f1698a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1698a != null) {
            return this.f1698a.m1531b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1698a != null) {
            this.f1698a.m1533c();
        }
        if (this.f1699b != null) {
            this.f1699b.m1182b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1699b != null) {
            this.f1699b.m1173a(context, i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1699b != null) {
            this.f1699b.m1180a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        if (f2352d) {
            super.setTextSize(i, f2);
        } else if (this.f1699b != null) {
            this.f1699b.m1171a(i, f2);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f1699b != null && !f2352d && this.f1699b.m1184d()) {
            this.f1699b.m1183c();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f2352d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f1699b != null) {
            this.f1699b.m1170a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f2352d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f1699b != null) {
            this.f1699b.m1172a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f2352d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f1699b != null) {
            this.f1699b.m1181a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f2352d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f1699b != null) {
            return this.f1699b.m1185e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f2352d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f1699b != null) {
            return this.f1699b.m1186f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f2352d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f1699b != null) {
            return this.f1699b.m1187g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f2352d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f1699b != null) {
            return this.f1699b.m1188h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f2352d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f1699b != null) {
            return this.f1699b.m1189i();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1699b != null) {
            this.f1699b.m1179a(z);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0339i.m2512a(this, callback));
    }

    @Override // androidx.core.widget.InterfaceC0342l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1699b.m1174a(colorStateList);
        this.f1699b.m1182b();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1699b.m1190j();
    }

    @Override // androidx.core.widget.InterfaceC0342l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1699b.m1175a(mode);
        this.f1699b.m1182b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1699b.m1191k();
    }
}
