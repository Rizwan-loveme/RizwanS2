package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.InterfaceC0167ai;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements InterfaceC0167ai {

    /* renamed from: a */
    private InterfaceC0167ai.a f1225a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.InterfaceC0167ai
    public void setOnFitSystemWindowsListener(InterfaceC0167ai.a aVar) {
        this.f1225a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1225a != null) {
            this.f1225a.mo553a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
