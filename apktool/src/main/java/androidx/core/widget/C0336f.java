package androidx.core.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper.java */
/* renamed from: androidx.core.widget.f */
/* loaded from: classes.dex */
public class C0336f extends AbstractViewOnTouchListenerC0331a {

    /* renamed from: f */
    private final ListView f2355f;

    public C0336f(ListView listView) {
        super(listView);
        this.f2355f = listView;
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0331a
    /* renamed from: a */
    public void mo2471a(int i, int i2) {
        C0337g.m2504a(this.f2355f, i2);
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0331a
    /* renamed from: e */
    public boolean mo2481e(int i) {
        return false;
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0331a
    /* renamed from: f */
    public boolean mo2482f(int i) {
        ListView listView = this.f2355f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
