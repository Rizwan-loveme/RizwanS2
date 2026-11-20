package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.InterfaceC0167ai;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements InterfaceC0167ai {

    /* renamed from: a */
    private InterfaceC0167ai.a f1224a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.InterfaceC0167ai
    public void setOnFitSystemWindowsListener(InterfaceC0167ai.a aVar) {
        this.f1224a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1224a != null) {
            this.f1224a.mo553a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
