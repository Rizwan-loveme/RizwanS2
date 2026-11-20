package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.p031f.InterfaceC0307w;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* renamed from: androidx.appcompat.widget.q */
/* loaded from: classes.dex */
public class C0207q extends MultiAutoCompleteTextView implements InterfaceC0307w {

    /* renamed from: a */
    private static final int[] f1732a = {C0012R.attr.popupBackground};

    /* renamed from: b */
    private final C0196f f1733b;

    /* renamed from: c */
    private final C0159aa f1734c;

    public C0207q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.autoCompleteTextViewStyle);
    }

    public C0207q(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        C0184az m1432a = C0184az.m1432a(getContext(), attributeSet, f1732a, i, 0);
        if (m1432a.m1451g(0)) {
            setDropDownBackgroundDrawable(m1432a.m1437a(0));
        }
        m1432a.m1441b();
        this.f1733b = new C0196f(this);
        this.f1733b.m1530a(attributeSet, i);
        this.f1734c = new C0159aa(this);
        this.f1734c.m1176a(attributeSet, i);
        this.f1734c.m1182b();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0060a.m348b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1733b != null) {
            this.f1733b.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1733b != null) {
            this.f1733b.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1733b != null) {
            this.f1733b.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1733b != null) {
            return this.f1733b.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1733b != null) {
            this.f1733b.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1733b != null) {
            return this.f1733b.m1531b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1733b != null) {
            this.f1733b.m1533c();
        }
        if (this.f1734c != null) {
            this.f1734c.m1182b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1734c != null) {
            this.f1734c.m1173a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0203m.m1560a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
