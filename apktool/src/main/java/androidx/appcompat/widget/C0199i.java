package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.widget.C0339i;

/* compiled from: AppCompatCheckedTextView.java */
/* renamed from: androidx.appcompat.widget.i */
/* loaded from: classes.dex */
public class C0199i extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f1703a = {C0012R.attr.checkMark};

    /* renamed from: b */
    private final C0159aa f1704b;

    public C0199i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0012R.attr.checkedTextViewStyle);
    }

    public C0199i(Context context, AttributeSet attributeSet, int i) {
        super(C0181aw.m1427a(context), attributeSet, i);
        C0179au.m1422a(this, getContext());
        this.f1704b = new C0159aa(this);
        this.f1704b.m1176a(attributeSet, i);
        this.f1704b.m1182b();
        C0184az m1432a = C0184az.m1432a(getContext(), attributeSet, f1703a, i, 0);
        setCheckMarkDrawable(m1432a.m1437a(0));
        m1432a.m1441b();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0060a.m348b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1704b != null) {
            this.f1704b.m1173a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1704b != null) {
            this.f1704b.m1182b();
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
