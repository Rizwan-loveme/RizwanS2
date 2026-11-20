package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.C0108i;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.appcompat.widget.C0169ak;

/* loaded from: classes.dex */
public class ActionMenuView extends C0169ak implements C0106g.b, InterfaceC0113n {

    /* renamed from: a */
    C0106g.a f1170a;

    /* renamed from: b */
    InterfaceC0129e f1171b;

    /* renamed from: c */
    private C0106g f1172c;

    /* renamed from: d */
    private Context f1173d;

    /* renamed from: e */
    private int f1174e;

    /* renamed from: f */
    private boolean f1175f;

    /* renamed from: g */
    private C0193c f1176g;

    /* renamed from: h */
    private InterfaceC0112m.a f1177h;

    /* renamed from: i */
    private boolean f1178i;

    /* renamed from: j */
    private int f1179j;

    /* renamed from: k */
    private int f1180k;

    /* renamed from: l */
    private int f1181l;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    public interface InterfaceC0125a {
        /* renamed from: c */
        boolean mo785c();

        /* renamed from: d */
        boolean mo786d();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$e */
    public interface InterfaceC0129e {
        /* renamed from: a */
        boolean mo1031a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1180k = (int) (56.0f * f2);
        this.f1181l = (int) (f2 * 4.0f);
        this.f1173d = context;
        this.f1174e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1174e != i) {
            this.f1174e = i;
            if (i == 0) {
                this.f1173d = getContext();
            } else {
                this.f1173d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1174e;
    }

    public void setPresenter(C0193c c0193c) {
        this.f1176g = c0193c;
        this.f1176g.m1494a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1176g != null) {
            this.f1176g.mo815a(false);
            if (this.f1176g.m1503h()) {
                this.f1176g.m1500e();
                this.f1176g.m1499d();
            }
        }
    }

    public void setOnMenuItemClickListener(InterfaceC0129e interfaceC0129e) {
        this.f1171b = interfaceC0129e;
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.f1178i;
        this.f1178i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1178i) {
            this.f1179j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f1178i && this.f1172c != null && size != this.f1179j) {
            this.f1179j = size;
            this.f1172c.m890b(true);
        }
        int childCount = getChildCount();
        if (this.f1178i && childCount > 0) {
            m1014c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C0127c c0127c = (C0127c) getChildAt(i3).getLayoutParams();
            c0127c.rightMargin = 0;
            c0127c.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0262  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1014c(int i, int i2) {
        long j;
        boolean z;
        float f2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = i8 / this.f1180k;
        int i10 = i8 % this.f1180k;
        if (i9 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i11 = this.f1180k + (i10 / i9);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z4 = false;
        long j2 = 0;
        int childCount = getChildCount();
        int i16 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                z3 = z4;
                i6 = i15;
                i7 = i9;
            } else {
                boolean z5 = childAt instanceof ActionMenuItemView;
                i6 = i15 + 1;
                if (z5) {
                    childAt.setPadding(this.f1181l, 0, this.f1181l, 0);
                }
                C0127c c0127c = (C0127c) childAt.getLayoutParams();
                c0127c.f1187f = false;
                c0127c.f1184c = 0;
                c0127c.f1183b = 0;
                c0127c.f1185d = false;
                c0127c.leftMargin = 0;
                c0127c.rightMargin = 0;
                c0127c.f1186e = z5 && ((ActionMenuItemView) childAt).m784b();
                int m1013a = m1013a(childAt, i11, c0127c.f1182a ? 1 : i9, childMeasureSpec, paddingTop);
                i13 = Math.max(i13, m1013a);
                int i17 = c0127c.f1185d ? i14 + 1 : i14;
                z3 = c0127c.f1182a ? true : z4;
                i7 = i9 - m1013a;
                int max = Math.max(i12, childAt.getMeasuredHeight());
                if (m1013a == 1) {
                    j2 = (1 << i16) | j2;
                    i14 = i17;
                    i12 = max;
                } else {
                    i14 = i17;
                    i12 = max;
                }
            }
            i16++;
            z4 = z3;
            i15 = i6;
            i9 = i7;
        }
        boolean z6 = z4 && i15 == 2;
        boolean z7 = false;
        long j3 = j2;
        int i18 = i9;
        while (i14 > 0 && i18 > 0) {
            int i19 = Integer.MAX_VALUE;
            long j4 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < childCount) {
                C0127c c0127c2 = (C0127c) getChildAt(i21).getLayoutParams();
                if (!c0127c2.f1185d) {
                    i5 = i20;
                } else if (c0127c2.f1183b < i19) {
                    int i22 = c0127c2.f1183b;
                    j4 = 1 << i21;
                    i5 = 1;
                    i19 = i22;
                } else if (c0127c2.f1183b == i19) {
                    j4 |= 1 << i21;
                    i5 = i20 + 1;
                } else {
                    i5 = i20;
                }
                i21++;
                i20 = i5;
            }
            j3 |= j4;
            if (i20 > i18) {
                j = j3;
                break;
            }
            int i23 = i19 + 1;
            int i24 = 0;
            int i25 = i18;
            while (i24 < childCount) {
                View childAt2 = getChildAt(i24);
                C0127c c0127c3 = (C0127c) childAt2.getLayoutParams();
                if (((1 << i24) & j4) == 0) {
                    if (c0127c3.f1183b == i23) {
                        j3 |= 1 << i24;
                        i4 = i25;
                    } else {
                        i4 = i25;
                    }
                } else {
                    if (z6 && c0127c3.f1186e && i25 == 1) {
                        childAt2.setPadding(this.f1181l + i11, 0, this.f1181l, 0);
                    }
                    c0127c3.f1183b++;
                    c0127c3.f1187f = true;
                    i4 = i25 - 1;
                }
                i24++;
                i25 = i4;
            }
            z7 = true;
            i18 = i25;
        }
        j = j3;
        boolean z8 = !z4 && i15 == 1;
        if (i18 <= 0 || j == 0 || (i18 >= i15 - 1 && !z8 && i13 <= 1)) {
            z = z7;
        } else {
            float bitCount = Long.bitCount(j);
            if (!z8) {
                if ((1 & j) != 0 && !((C0127c) getChildAt(0).getLayoutParams()).f1186e) {
                    bitCount -= 0.5f;
                }
                if (((1 << (childCount - 1)) & j) != 0 && !((C0127c) getChildAt(childCount - 1).getLayoutParams()).f1186e) {
                    f2 = bitCount - 0.5f;
                    int i26 = f2 <= 0.0f ? (int) ((i18 * i11) / f2) : 0;
                    i3 = 0;
                    z = z7;
                    while (i3 < childCount) {
                        if (((1 << i3) & j) == 0) {
                            z2 = z;
                        } else {
                            View childAt3 = getChildAt(i3);
                            C0127c c0127c4 = (C0127c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0127c4.f1184c = i26;
                                c0127c4.f1187f = true;
                                if (i3 == 0 && !c0127c4.f1186e) {
                                    c0127c4.leftMargin = (-i26) / 2;
                                }
                                z2 = true;
                            } else if (c0127c4.f1182a) {
                                c0127c4.f1184c = i26;
                                c0127c4.f1187f = true;
                                c0127c4.rightMargin = (-i26) / 2;
                                z2 = true;
                            } else {
                                if (i3 != 0) {
                                    c0127c4.leftMargin = i26 / 2;
                                }
                                if (i3 != childCount - 1) {
                                    c0127c4.rightMargin = i26 / 2;
                                }
                                z2 = z;
                            }
                        }
                        i3++;
                        z = z2;
                    }
                }
            }
            f2 = bitCount;
            if (f2 <= 0.0f) {
            }
            i3 = 0;
            z = z7;
            while (i3 < childCount) {
            }
        }
        if (z) {
            int i27 = 0;
            while (true) {
                int i28 = i27;
                if (i28 >= childCount) {
                    break;
                }
                View childAt4 = getChildAt(i28);
                C0127c c0127c5 = (C0127c) childAt4.getLayoutParams();
                if (c0127c5.f1187f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec(c0127c5.f1184c + (c0127c5.f1183b * i11), 1073741824), childMeasureSpec);
                }
                i27 = i28 + 1;
            }
        }
        if (mode == 1073741824) {
            i12 = size2;
        }
        setMeasuredDimension(i8, i12);
    }

    /* renamed from: a */
    static int m1013a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0127c c0127c = (C0127c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m784b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!c0127c.f1182a && z2) {
            z = true;
        }
        c0127c.f1185d = z;
        c0127c.f1183b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int measuredWidth;
        boolean z2;
        int width;
        int i7;
        if (!this.f1178i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z3 = false;
        boolean m1481a = C0191bf.m1481a(this);
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                z2 = z3;
                measuredWidth = paddingRight;
            } else {
                C0127c c0127c = (C0127c) childAt.getLayoutParams();
                if (c0127c.f1182a) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (m1019a(i10)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m1481a) {
                        i7 = c0127c.leftMargin + getPaddingLeft();
                        width = i7 + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - c0127c.rightMargin;
                        i7 = width - measuredWidth2;
                    }
                    int i11 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i11, width, measuredHeight + i11);
                    z2 = true;
                    measuredWidth = paddingRight - measuredWidth2;
                } else {
                    measuredWidth = paddingRight - (c0127c.rightMargin + (childAt.getMeasuredWidth() + c0127c.leftMargin));
                    if (m1019a(i10)) {
                    }
                    z2 = z3;
                    i9++;
                }
            }
            i10++;
            z3 = z2;
            paddingRight = measuredWidth;
        }
        if (childCount == 1 && !z3) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = ((i3 - i) / 2) - (measuredWidth3 / 2);
            int i13 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth3 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (z3 ? 0 : 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (m1481a) {
            int width2 = getWidth() - getPaddingRight();
            int i15 = 0;
            while (i15 < childCount) {
                View childAt3 = getChildAt(i15);
                C0127c c0127c2 = (C0127c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    i6 = width2;
                } else if (c0127c2.f1182a) {
                    i6 = width2;
                } else {
                    int i16 = width2 - c0127c2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    i6 = i16 - ((c0127c2.leftMargin + measuredWidth4) + max);
                }
                i15++;
                width2 = i6;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt4 = getChildAt(i18);
            C0127c c0127c3 = (C0127c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() == 8) {
                i5 = paddingLeft;
            } else if (c0127c3.f1182a) {
                i5 = paddingLeft;
            } else {
                int i19 = paddingLeft + c0127c3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth5, measuredHeight4 + i20);
                i5 = c0127c3.rightMargin + measuredWidth5 + max + i19;
            }
            i18++;
            paddingLeft = i5;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1029i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1176g.m1493a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1176g.m1496c();
    }

    /* renamed from: a */
    public boolean m1018a() {
        return this.f1175f;
    }

    public void setOverflowReserved(boolean z) {
        this.f1175f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.C0169ak
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0127c generateDefaultLayoutParams() {
        C0127c c0127c = new C0127c(-2, -2);
        c0127c.gravity = 16;
        return c0127c;
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0127c generateLayoutParams(AttributeSet attributeSet) {
        return new C0127c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0127c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C0127c c0127c;
        if (layoutParams != null) {
            if (layoutParams instanceof C0127c) {
                c0127c = new C0127c((C0127c) layoutParams);
            } else {
                c0127c = new C0127c(layoutParams);
            }
            if (c0127c.gravity <= 0) {
                c0127c.gravity = 16;
                return c0127c;
            }
            return c0127c;
        }
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0127c;
    }

    /* renamed from: c */
    public C0127c m1023c() {
        C0127c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f1182a = true;
        return generateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.C0106g.b
    /* renamed from: a */
    public boolean mo791a(C0108i c0108i) {
        return this.f1172c.m883a(c0108i, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n
    /* renamed from: a */
    public void mo790a(C0106g c0106g) {
        this.f1172c = c0106g;
    }

    public Menu getMenu() {
        if (this.f1172c == null) {
            Context context = getContext();
            this.f1172c = new C0106g(context);
            this.f1172c.mo877a(new C0128d());
            this.f1176g = new C0193c(context);
            this.f1176g.m1495b(true);
            this.f1176g.mo814a(this.f1177h != null ? this.f1177h : new C0126b());
            this.f1172c.m880a(this.f1176g, this.f1173d);
            this.f1176g.m1494a(this);
        }
        return this.f1172c;
    }

    /* renamed from: a */
    public void m1017a(InterfaceC0112m.a aVar, C0106g.a aVar2) {
        this.f1177h = aVar;
        this.f1170a = aVar2;
    }

    /* renamed from: d */
    public C0106g m1024d() {
        return this.f1172c;
    }

    /* renamed from: e */
    public boolean m1025e() {
        return this.f1176g != null && this.f1176g.m1499d();
    }

    /* renamed from: f */
    public boolean m1026f() {
        return this.f1176g != null && this.f1176g.m1500e();
    }

    /* renamed from: g */
    public boolean m1027g() {
        return this.f1176g != null && this.f1176g.m1503h();
    }

    /* renamed from: h */
    public boolean m1028h() {
        return this.f1176g != null && this.f1176g.m1504i();
    }

    /* renamed from: i */
    public void m1029i() {
        if (this.f1176g != null) {
            this.f1176g.m1501f();
        }
    }

    /* renamed from: a */
    protected boolean m1019a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0125a)) {
            z = false | ((InterfaceC0125a) childAt).mo786d();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0125a)) ? z : ((InterfaceC0125a) childAt2).mo785c() | z;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1176g.m1497c(z);
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    private class C0128d implements C0106g.a {
        C0128d() {
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
            return ActionMenuView.this.f1171b != null && ActionMenuView.this.f1171b.mo1031a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public void mo529a(C0106g c0106g) {
            if (ActionMenuView.this.f1170a != null) {
                ActionMenuView.this.f1170a.mo529a(c0106g);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    private static class C0126b implements InterfaceC0112m.a {
        C0126b() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public void mo558a(C0106g c0106g, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public boolean mo559a(C0106g c0106g) {
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    public static class C0127c extends C0169ak.a {

        /* renamed from: a */
        @ViewDebug.ExportedProperty
        public boolean f1182a;

        /* renamed from: b */
        @ViewDebug.ExportedProperty
        public int f1183b;

        /* renamed from: c */
        @ViewDebug.ExportedProperty
        public int f1184c;

        /* renamed from: d */
        @ViewDebug.ExportedProperty
        public boolean f1185d;

        /* renamed from: e */
        @ViewDebug.ExportedProperty
        public boolean f1186e;

        /* renamed from: f */
        boolean f1187f;

        public C0127c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0127c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0127c(C0127c c0127c) {
            super(c0127c);
            this.f1182a = c0127c.f1182a;
        }

        public C0127c(int i, int i2) {
            super(i, i2);
            this.f1182a = false;
        }
    }
}
