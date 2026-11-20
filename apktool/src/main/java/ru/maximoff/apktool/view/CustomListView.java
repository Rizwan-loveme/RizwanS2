package ru.maximoff.apktool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class CustomListView extends ListView {

    /* renamed from: a */
    private InterfaceC3268a f20753a;

    /* renamed from: ru.maximoff.apktool.view.CustomListView$a */
    public interface InterfaceC3268a {
        /* renamed from: a */
        void mo16527a();
    }

    public CustomListView(Context context) {
        super(context);
        mo18407a(context);
    }

    public CustomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo18407a(context);
    }

    public CustomListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo18407a(context);
    }

    /* renamed from: a */
    protected void mo18407a(Context context) {
        if (C3102bd.f18273I) {
            setVerticalScrollbarPosition(1);
        } else {
            setVerticalScrollbarPosition(2);
        }
    }

    @Override // android.widget.AbsListView
    protected void handleDataChanged() {
        super.handleDataChanged();
        if (this.f20753a != null) {
            this.f20753a.mo16527a();
        }
    }

    public void setHandleDataChangedListener(InterfaceC3268a interfaceC3268a) {
        this.f20753a = interfaceC3268a;
    }
}
