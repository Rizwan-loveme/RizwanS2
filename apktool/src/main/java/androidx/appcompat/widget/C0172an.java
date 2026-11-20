package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0105f;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.C0108i;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* renamed from: androidx.appcompat.widget.an */
/* loaded from: classes.dex */
public class C0172an extends C0170al implements InterfaceC0171am {

    /* renamed from: a */
    private static Method f1498a;

    /* renamed from: b */
    private InterfaceC0171am f1499b;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1498a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException e2) {
            Log.m186i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C0172an(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.C0170al
    /* renamed from: a */
    C0166ah mo1309a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    /* renamed from: a */
    public void m1336a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1472g.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void m1337b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1472g.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: a */
    public void m1335a(InterfaceC0171am interfaceC0171am) {
        this.f1499b = interfaceC0171am;
    }

    /* renamed from: c */
    public void m1338c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            if (f1498a != null) {
                try {
                    f1498a.invoke(this.f1472g, Boolean.valueOf(z));
                    return;
                } catch (Exception e2) {
                    Log.m186i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.f1472g.setTouchModal(z);
    }

    @Override // androidx.appcompat.widget.InterfaceC0171am
    /* renamed from: b */
    public void mo849b(C0106g c0106g, MenuItem menuItem) {
        if (this.f1499b != null) {
            this.f1499b.mo849b(c0106g, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0171am
    /* renamed from: a */
    public void mo848a(C0106g c0106g, MenuItem menuItem) {
        if (this.f1499b != null) {
            this.f1499b.mo848a(c0106g, menuItem);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.an$a */
    public static class a extends C0166ah {

        /* renamed from: b */
        final int f1500b;

        /* renamed from: c */
        final int f1501c;

        /* renamed from: d */
        private InterfaceC0171am f1502d;

        /* renamed from: e */
        private MenuItem f1503e;

        @Override // androidx.appcompat.widget.C0166ah
        /* renamed from: a */
        public /* bridge */ /* synthetic */ int mo1274a(int i, int i2, int i3, int i4, int i5) {
            return super.mo1274a(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.C0166ah
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo1275a(MotionEvent motionEvent, int i) {
            return super.mo1275a(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.C0166ah, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.C0166ah, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.C0166ah, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.C0166ah, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.C0166ah, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.C0166ah, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f1500b = 21;
                this.f1501c = 22;
            } else {
                this.f1500b = 22;
                this.f1501c = 21;
            }
        }

        public void setHoverListener(InterfaceC0171am interfaceC0171am) {
            this.f1502d = interfaceC0171am;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            C0105f c0105f;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1500b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.f1501c) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    c0105f = (C0105f) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    c0105f = (C0105f) adapter;
                }
                c0105f.m855a().m882a(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // androidx.appcompat.widget.C0166ah, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            C0105f c0105f;
            C0108i c0108i;
            int pointToPosition;
            int i2;
            if (this.f1502d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    c0105f = (C0105f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    c0105f = (C0105f) adapter;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = pointToPosition - i) < 0 || i2 >= c0105f.getCount()) {
                    c0108i = null;
                } else {
                    c0108i = c0105f.getItem(i2);
                }
                MenuItem menuItem = this.f1503e;
                if (menuItem != c0108i) {
                    C0106g m855a = c0105f.m855a();
                    if (menuItem != null) {
                        this.f1502d.mo848a(m855a, menuItem);
                    }
                    this.f1503e = c0108i;
                    if (c0108i != null) {
                        this.f1502d.mo849b(m855a, c0108i);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
