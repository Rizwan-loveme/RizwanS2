package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p016b.p017a.C0086c;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p031f.C0278ab;
import androidx.core.widget.C0336f;
import java.lang.reflect.Field;

/* compiled from: DropDownListView.java */
/* renamed from: androidx.appcompat.widget.ah */
/* loaded from: classes.dex */
class C0166ah extends ListView {

    /* renamed from: a */
    b f1414a;

    /* renamed from: b */
    private final Rect f1415b;

    /* renamed from: c */
    private int f1416c;

    /* renamed from: d */
    private int f1417d;

    /* renamed from: e */
    private int f1418e;

    /* renamed from: f */
    private int f1419f;

    /* renamed from: g */
    private int f1420g;

    /* renamed from: h */
    private Field f1421h;

    /* renamed from: i */
    private a f1422i;

    /* renamed from: j */
    private boolean f1423j;

    /* renamed from: k */
    private boolean f1424k;

    /* renamed from: l */
    private boolean f1425l;

    /* renamed from: m */
    private C0278ab f1426m;

    /* renamed from: n */
    private C0336f f1427n;

    C0166ah(Context context, boolean z) {
        super(context, null, C0059a.a.dropDownListViewStyle);
        this.f1415b = new Rect();
        this.f1416c = 0;
        this.f1417d = 0;
        this.f1418e = 0;
        this.f1419f = 0;
        this.f1424k = z;
        setCacheColorHint(0);
        try {
            this.f1421h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1421h.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1424k && this.f1423j) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1424k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1424k || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1424k || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f1422i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.f1422i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1416c = rect.left;
        this.f1417d = rect.top;
        this.f1418e = rect.right;
        this.f1419f = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1414a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m1265a();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m1268a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f1420g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f1414a != null) {
            this.f1414a.m1277a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public int mo1274a(int i, int i2, int i3, int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i7 = 0;
        View view = null;
        int i8 = 0;
        int count = adapter.getCount();
        int i9 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            int measuredHeight = (i9 > 0 ? i6 + dividerHeight : i6) + view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i9 <= i5 || i7 <= 0 || measuredHeight == i4) ? i4 : i7;
            }
            if (i5 >= 0 && i9 >= i5) {
                i7 = measuredHeight;
            }
            i9++;
            i6 = measuredHeight;
        }
        return i6;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f1422i != null) {
            this.f1422i.m1276a(z);
        }
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: androidx.appcompat.widget.ah$a */
    private static class a extends C0086c {

        /* renamed from: a */
        private boolean f1428a;

        a(Drawable drawable) {
            super(drawable);
            this.f1428a = true;
        }

        /* renamed from: a */
        void m1276a(boolean z) {
            this.f1428a = z;
        }

        @Override // androidx.appcompat.p016b.p017a.C0086c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1428a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.p016b.p017a.C0086c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1428a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.p016b.p017a.C0086c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f1428a) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // androidx.appcompat.p016b.p017a.C0086c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1428a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.p016b.p017a.C0086c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1428a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1414a == null) {
            this.f1414a = new b();
            this.f1414a.m1278b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m1265a();
                return onHoverEvent;
            }
            return onHoverEvent;
        }
        setSelection(-1);
        return onHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1414a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo1275a(MotionEvent motionEvent, int i) {
        boolean z;
        int findPointerIndex;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                findPointerIndex = motionEvent.findPointerIndex(i);
                if (findPointerIndex < 0) {
                    int x = (int) motionEvent.getX(findPointerIndex);
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                        m1270a(childAt, pointToPosition, x, y);
                        if (actionMasked == 1) {
                            m1269a(childAt, pointToPosition);
                        }
                        z2 = false;
                        z = true;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    z = false;
                    break;
                }
            case 2:
                z = true;
                findPointerIndex = motionEvent.findPointerIndex(i);
                if (findPointerIndex < 0) {
                }
                break;
            case 3:
                z2 = false;
                z = false;
                break;
            default:
                z2 = false;
                z = true;
                break;
        }
        if (!z || z2) {
            m1271b();
        }
        if (z) {
            if (this.f1427n == null) {
                this.f1427n = new C0336f(this);
            }
            this.f1427n.m2470a(true);
            this.f1427n.onTouch(this, motionEvent);
        } else if (this.f1427n != null) {
            this.f1427n.m2470a(false);
        }
        return z;
    }

    /* renamed from: a */
    private void m1269a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.f1423j = z;
    }

    /* renamed from: a */
    private void m1265a() {
        Drawable selector = getSelector();
        if (selector != null && m1273c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m1268a(Canvas canvas) {
        Drawable selector;
        if (!this.f1415b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1415b);
            selector.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m1267a(int i, View view, float f2, float f3) {
        m1266a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0315a.m2356a(selector, f2, f3);
        }
    }

    /* renamed from: a */
    private void m1266a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m1272b(i, view);
        if (z) {
            Rect rect = this.f1415b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            C0315a.m2356a(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: b */
    private void m1272b(int i, View view) {
        Rect rect = this.f1415b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1416c;
        rect.top -= this.f1417d;
        rect.right += this.f1418e;
        rect.bottom += this.f1419f;
        try {
            boolean z = this.f1421h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1421h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m1271b() {
        this.f1425l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1420g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f1426m != null) {
            this.f1426m.m2065b();
            this.f1426m = null;
        }
    }

    /* renamed from: a */
    private void m1270a(View view, int i, float f2, float f3) {
        View childAt;
        this.f1425l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f1420g != -1 && (childAt = getChildAt(this.f1420g - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1420g = i;
        float left = f2 - view.getLeft();
        float top = f3 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1267a(i, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: c */
    private boolean m1273c() {
        return this.f1425l;
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: androidx.appcompat.widget.ah$b */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0166ah.this.f1414a = null;
            C0166ah.this.drawableStateChanged();
        }

        /* renamed from: a */
        public void m1277a() {
            C0166ah.this.f1414a = null;
            C0166ah.this.removeCallbacks(this);
        }

        /* renamed from: b */
        public void m1278b() {
            C0166ah.this.post(this);
        }
    }
}
