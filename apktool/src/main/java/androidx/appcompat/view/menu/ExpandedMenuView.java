package androidx.appcompat.view.menu;

import android.C0012R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.widget.C0184az;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, C0106g.b, InterfaceC0113n {

    /* renamed from: a */
    private static final int[] f889a = {C0012R.attr.background, C0012R.attr.divider};

    /* renamed from: b */
    private C0106g f890b;

    /* renamed from: c */
    private int f891c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0012R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0184az m1432a = C0184az.m1432a(context, attributeSet, f889a, i, 0);
        if (m1432a.m1451g(0)) {
            setBackgroundDrawable(m1432a.m1437a(0));
        }
        if (m1432a.m1451g(1)) {
            setDivider(m1432a.m1437a(1));
        }
        m1432a.m1441b();
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n
    /* renamed from: a */
    public void mo790a(C0106g c0106g) {
        this.f890b = c0106g;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.C0106g.b
    /* renamed from: a */
    public boolean mo791a(C0108i c0108i) {
        return this.f890b.m883a(c0108i, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo791a((C0108i) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f891c;
    }
}
