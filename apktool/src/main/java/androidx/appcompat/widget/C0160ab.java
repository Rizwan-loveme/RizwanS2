package androidx.appcompat.widget;

import android.C0012R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.graphics.C0314d;
import androidx.core.p029d.C0265a;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.C0339i;
import androidx.core.widget.InterfaceC0332b;
import androidx.core.widget.InterfaceC0342l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AppCompatTextView.java */
/* renamed from: androidx.appcompat.widget.ab */
/* loaded from: classes.dex */
public class C0160ab extends TextView implements InterfaceC0307w, InterfaceC0332b, InterfaceC0342l {

    /* renamed from: a */
    private final C0196f f1389a;

    /* renamed from: b */
    private final C0159aa f1390b;

    /* renamed from: c */
    private final C0216z f1391c;

    /* renamed from: e */
    private boolean f1392e;

    /* renamed from: f */
    private Future<C0265a> f1393f;

    public C0160ab(Context context) {
        this(context, null);
    }

    public C0160ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0012R.attr.textViewStyle);
    }

    public C0160ab(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        this.f1392e = false;
        C0179au.m1422a(this, getContext());
        this.f1389a = new C0196f(this);
        this.f1389a.m1530a(attributeSet, i);
        this.f1390b = new C0159aa(this);
        this.f1390b.m1176a(attributeSet, i);
        this.f1390b.m1182b();
        this.f1391c = new C0216z(this);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1389a != null) {
            this.f1389a.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1389a != null) {
            this.f1389a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1389a != null) {
            this.f1389a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1389a != null) {
            return this.f1389a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1389a != null) {
            this.f1389a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1389a != null) {
            return this.f1389a.m1531b();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1390b != null) {
            this.f1390b.m1173a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1389a != null) {
            this.f1389a.m1533c();
        }
        if (this.f1390b != null) {
            this.f1390b.m1182b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1390b != null) {
            this.f1390b.m1180a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        if (f2352d) {
            super.setTextSize(i, f2);
        } else if (this.f1390b != null) {
            this.f1390b.m1171a(i, f2);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f1390b != null && !f2352d && this.f1390b.m1184d()) {
            this.f1390b.m1183c();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f2352d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f1390b != null) {
            this.f1390b.m1170a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f2352d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f1390b != null) {
            this.f1390b.m1172a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f2352d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f1390b != null) {
            this.f1390b.m1181a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f2352d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f1390b != null) {
            return this.f1390b.m1185e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f2352d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f1390b != null) {
            return this.f1390b.m1186f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f2352d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f1390b != null) {
            return this.f1390b.m1187g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f2352d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f1390b != null) {
            return this.f1390b.m1188h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f2352d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f1390b != null) {
            return this.f1390b.m1189i();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1390b.m1177a(this, onCreateInputConnection, editorInfo);
        return C0203m.m1560a(onCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            C0339i.m2520b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            C0339i.m2522c(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return C0339i.m2519b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return C0339i.m2521c(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        C0339i.m2524d(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0339i.m2512a(this, callback));
    }

    public C0265a.a getTextMetricsParamsCompat() {
        return C0339i.m2523d(this);
    }

    public void setTextMetricsParamsCompat(C0265a.a aVar) {
        C0339i.m2517a(this, aVar);
    }

    public void setPrecomputedText(C0265a c0265a) {
        C0339i.m2518a(this, c0265a);
    }

    /* renamed from: a */
    private void m1194a() {
        if (this.f1393f != null) {
            try {
                Future<C0265a> future = this.f1393f;
                this.f1393f = null;
                C0339i.m2518a(this, future.get());
            } catch (InterruptedException e2) {
            } catch (ExecutionException e3) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m1194a();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT >= 28 || this.f1391c == null) {
            super.setTextClassifier(textClassifier);
        } else {
            this.f1391c.m1611a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return (Build.VERSION.SDK_INT >= 28 || this.f1391c == null) ? super.getTextClassifier() : this.f1391c.m1610a();
    }

    public void setTextFuture(Future<C0265a> future) {
        this.f1393f = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        m1194a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? C0060a.m348b(context, i) : null, i2 != 0 ? C0060a.m348b(context, i2) : null, i3 != 0 ? C0060a.m348b(context, i3) : null, i4 != 0 ? C0060a.m348b(context, i4) : null);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? C0060a.m348b(context, i) : null, i2 != 0 ? C0060a.m348b(context, i2) : null, i3 != 0 ? C0060a.m348b(context, i3) : null, i4 != 0 ? C0060a.m348b(context, i4) : null);
        if (this.f1390b != null) {
            this.f1390b.m1169a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1390b.m1190j();
    }

    @Override // androidx.core.widget.InterfaceC0342l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1390b.m1174a(colorStateList);
        this.f1390b.m1182b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1390b.m1191k();
    }

    @Override // androidx.core.widget.InterfaceC0342l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1390b.m1175a(mode);
        this.f1390b.m1182b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        if (!this.f1392e) {
            Typeface typeface2 = null;
            if (typeface != null && i > 0) {
                typeface2 = C0314d.m2332a(getContext(), typeface, i);
            }
            this.f1392e = true;
            if (typeface2 == null) {
                typeface2 = typeface;
            }
            try {
                super.setTypeface(typeface2, i);
            } finally {
                this.f1392e = false;
            }
        }
    }
}
