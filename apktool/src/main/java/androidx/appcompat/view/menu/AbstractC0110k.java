package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.k */
/* loaded from: classes.dex */
public abstract class AbstractC0110k implements AdapterView.OnItemClickListener, InterfaceC0112m, InterfaceC0115p {

    /* renamed from: a */
    private Rect f1070a;

    /* renamed from: a */
    public abstract void mo835a(int i);

    /* renamed from: a */
    public abstract void mo836a(View view);

    /* renamed from: a */
    public abstract void mo837a(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo838a(C0106g c0106g);

    /* renamed from: b */
    public abstract void mo839b(int i);

    /* renamed from: b */
    public abstract void mo840b(boolean z);

    /* renamed from: c */
    public abstract void mo843c(int i);

    /* renamed from: c */
    public abstract void mo844c(boolean z);

    AbstractC0110k() {
    }

    /* renamed from: a */
    public void m958a(Rect rect) {
        this.f1070a = rect;
    }

    /* renamed from: g */
    public Rect m959g() {
        return this.f1070a;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo810a(Context context, C0106g c0106g) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo818a(C0106g c0106g, C0108i c0108i) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo822b(C0106g c0106g, C0108i c0108i) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m956a(listAdapter).f990a.m884a((MenuItem) listAdapter.getItem(i), this, mo847f() ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m955a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth < i) {
                if (measuredWidth <= i4) {
                    measuredWidth = i4;
                }
                i2++;
                i4 = measuredWidth;
            } else {
                return i;
            }
        }
        return i4;
    }

    /* renamed from: a */
    protected static C0105f m956a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0105f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0105f) listAdapter;
    }

    /* renamed from: b */
    protected static boolean m957b(C0106g c0106g) {
        int size = c0106g.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0106g.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    protected boolean mo847f() {
        return true;
    }
}
