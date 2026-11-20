package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.widget.C0339i;

/* compiled from: AppCompatAutoCompleteTextView.java */
/* renamed from: androidx.appcompat.widget.e */
/* loaded from: classes.dex */
public class C0195e extends AutoCompleteTextView implements InterfaceC0307w {

    /* renamed from: a */
    private static final int[] f1689a = {C0012R.attr.popupBackground};

    /* renamed from: b */
    private final C0196f f1690b;

    /* renamed from: c */
    private final C0159aa f1691c;

    public C0195e(Context context) {
        this(context, null);
    }

    public C0195e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.autoCompleteTextViewStyle);
    }

    public C0195e(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        C0184az m1432a = C0184az.m1432a(getContext(), attributeSet, f1689a, i, 0);
        if (m1432a.m1451g(0)) {
            setDropDownBackgroundDrawable(m1432a.m1437a(0));
        }
        m1432a.m1441b();
        this.f1690b = new C0196f(this);
        this.f1690b.m1530a(attributeSet, i);
        this.f1691c = new C0159aa(this);
        this.f1691c.m1176a(attributeSet, i);
        this.f1691c.m1182b();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0060a.m348b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1690b != null) {
            this.f1690b.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1690b != null) {
            this.f1690b.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1690b != null) {
            this.f1690b.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1690b != null) {
            return this.f1690b.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1690b != null) {
            this.f1690b.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1690b != null) {
            return this.f1690b.m1531b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1690b != null) {
            this.f1690b.m1533c();
        }
        if (this.f1691c != null) {
            this.f1691c.m1182b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1691c != null) {
            this.f1691c.m1173a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0203m.m1560a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0339i.m2512a(this, callback));
    }
}
