package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0287c;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0304t;
import androidx.core.p031f.InterfaceC0307w;
import androidx.core.p031f.p033b.C0284a;
import androidx.core.p031f.p033b.C0285b;
import androidx.core.widget.C0339i;
import androidx.core.widget.C0340j;

/* compiled from: AppCompatEditText.java */
/* renamed from: androidx.appcompat.widget.l */
/* loaded from: classes.dex */
public class C0202l extends EditText implements InterfaceC0304t, InterfaceC0307w {

    /* renamed from: a */
    private final C0196f f1720a;

    /* renamed from: b */
    private final C0159aa f1721b;

    /* renamed from: c */
    private final C0216z f1722c;

    /* renamed from: d */
    private final C0340j f1723d;

    public C0202l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.editTextStyle);
    }

    public C0202l(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1720a = new C0196f(this);
        this.f1720a.m1530a(attributeSet, i);
        this.f1721b = new C0159aa(this);
        this.f1721b.m1176a(attributeSet, i);
        this.f1721b.m1182b();
        this.f1722c = new C0216z(this);
        this.f1723d = new C0340j();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1720a != null) {
            this.f1720a.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1720a != null) {
            this.f1720a.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1720a != null) {
            this.f1720a.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1720a != null) {
            return this.f1720a.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1720a != null) {
            this.f1720a.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1720a != null) {
            return this.f1720a.m1531b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1720a != null) {
            this.f1720a.m1533c();
        }
        if (this.f1721b != null) {
            this.f1721b.m1182b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1721b != null) {
            this.f1721b.m1173a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1721b.m1177a(this, onCreateInputConnection, editorInfo);
        InputConnection m1560a = C0203m.m1560a(onCreateInputConnection, editorInfo, this);
        String[] m2270q = C0308x.m2270q(this);
        if (m1560a != null && m2270q != null) {
            C0284a.m2134a(editorInfo, m2270q);
            return C0285b.m2140a(m1560a, editorInfo, C0212v.m1581b(this));
        }
        return m1560a;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0339i.m2512a(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT >= 28 || this.f1722c == null) {
            super.setTextClassifier(textClassifier);
        } else {
            this.f1722c.m1611a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return (Build.VERSION.SDK_INT >= 28 || this.f1722c == null) ? super.getTextClassifier() : this.f1722c.m1610a();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (C0212v.m1579a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (C0212v.m1580a(this, i)) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // androidx.core.p031f.InterfaceC0304t
    /* renamed from: a */
    public C0287c mo1559a(C0287c c0287c) {
        return this.f1723d.mo2208a(this, c0287c);
    }
}
