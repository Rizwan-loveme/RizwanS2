package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;

/* compiled from: LinearLayoutCompat.java */
/* renamed from: androidx.appcompat.widget.ak */
/* loaded from: classes.dex */
public class C0169ak extends ViewGroup {

    /* renamed from: a */
    private boolean f1441a;

    /* renamed from: b */
    private int f1442b;

    /* renamed from: c */
    private int f1443c;

    /* renamed from: d */
    private int f1444d;

    /* renamed from: e */
    private int f1445e;

    /* renamed from: f */
    private int f1446f;

    /* renamed from: g */
    private float f1447g;

    /* renamed from: h */
    private boolean f1448h;

    /* renamed from: i */
    private int[] f1449i;

    /* renamed from: j */
    private int[] f1450j;

    /* renamed from: k */
    private Drawable f1451k;

    /* renamed from: l */
    private int f1452l;

    /* renamed from: m */
    private int f1453m;

    /* renamed from: n */
    private int f1454n;

    /* renamed from: o */
    private int f1455o;

    public C0169ak(Context context) {
        this(context, null);
    }

    public C0169ak(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0169ak(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1441a = true;
        this.f1442b = -1;
        this.f1443c = 0;
        this.f1445e = 8388659;
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.LinearLayoutCompat, i, 0);
        C0308x.m2230a(this, context, C0059a.j.LinearLayoutCompat, attributeSet, m1432a.m1435a(), i, 0);
        int m1434a = m1432a.m1434a(C0059a.j.LinearLayoutCompat_android_orientation, -1);
        if (m1434a >= 0) {
            setOrientation(m1434a);
        }
        int m1434a2 = m1432a.m1434a(C0059a.j.LinearLayoutCompat_android_gravity, -1);
        if (m1434a2 >= 0) {
            setGravity(m1434a2);
        }
        boolean m1438a = m1432a.m1438a(C0059a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!m1438a) {
            setBaselineAligned(m1438a);
        }
        this.f1447g = m1432a.m1433a(C0059a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1442b = m1432a.m1434a(C0059a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1448h = m1432a.m1438a(C0059a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(m1432a.m1437a(C0059a.j.LinearLayoutCompat_divider));
        this.f1454n = m1432a.m1434a(C0059a.j.LinearLayoutCompat_showDividers, 0);
        this.f1455o = m1432a.m1446e(C0059a.j.LinearLayoutCompat_dividerPadding, 0);
        m1432a.m1441b();
    }

    public void setShowDividers(int i) {
        if (i != this.f1454n) {
            requestLayout();
        }
        this.f1454n = i;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f1454n;
    }

    public Drawable getDividerDrawable() {
        return this.f1451k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f1451k) {
            this.f1451k = drawable;
            if (drawable != null) {
                this.f1452l = drawable.getIntrinsicWidth();
                this.f1453m = drawable.getIntrinsicHeight();
            } else {
                this.f1452l = 0;
                this.f1453m = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1455o = i;
    }

    public int getDividerPadding() {
        return this.f1455o;
    }

    public int getDividerWidth() {
        return this.f1452l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1451k != null) {
            if (this.f1444d == 1) {
                m1294a(canvas);
            } else {
                m1301b(canvas);
            }
        }
    }

    /* renamed from: a */
    void m1294a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View m1298b = m1298b(i);
            if (m1298b != null && m1298b.getVisibility() != 8 && m1303c(i)) {
                m1295a(canvas, (m1298b.getTop() - ((a) m1298b.getLayoutParams()).topMargin) - this.f1453m);
            }
        }
        if (m1303c(virtualChildCount)) {
            View m1298b2 = m1298b(virtualChildCount - 1);
            if (m1298b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f1453m;
            } else {
                bottom = ((a) m1298b2.getLayoutParams()).bottomMargin + m1298b2.getBottom();
            }
            m1295a(canvas, bottom);
        }
    }

    /* renamed from: b */
    void m1301b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean m1481a = C0191bf.m1481a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View m1298b = m1298b(i);
            if (m1298b != null && m1298b.getVisibility() != 8 && m1303c(i)) {
                a aVar = (a) m1298b.getLayoutParams();
                if (m1481a) {
                    left = aVar.rightMargin + m1298b.getRight();
                } else {
                    left = (m1298b.getLeft() - aVar.leftMargin) - this.f1452l;
                }
                m1302b(canvas, left);
            }
        }
        if (m1303c(virtualChildCount)) {
            View m1298b2 = m1298b(virtualChildCount - 1);
            if (m1298b2 == null) {
                if (m1481a) {
                    right = getPaddingLeft();
                } else {
                    right = (getWidth() - getPaddingRight()) - this.f1452l;
                }
            } else {
                a aVar2 = (a) m1298b2.getLayoutParams();
                if (m1481a) {
                    right = (m1298b2.getLeft() - aVar2.leftMargin) - this.f1452l;
                } else {
                    right = aVar2.rightMargin + m1298b2.getRight();
                }
            }
            m1302b(canvas, right);
        }
    }

    /* renamed from: a */
    void m1295a(Canvas canvas, int i) {
        this.f1451k.setBounds(getPaddingLeft() + this.f1455o, i, (getWidth() - getPaddingRight()) - this.f1455o, this.f1453m + i);
        this.f1451k.draw(canvas);
    }

    /* renamed from: b */
    void m1302b(Canvas canvas, int i) {
        this.f1451k.setBounds(i, getPaddingTop() + this.f1455o, this.f1452l + i, (getHeight() - getPaddingBottom()) - this.f1455o);
        this.f1451k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f1441a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1448h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        int i2;
        if (this.f1442b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1442b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1442b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1442b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i3 = this.f1443c;
        if (this.f1444d == 1 && (i2 = this.f1445e & 112) != 48) {
            switch (i2) {
                case 16:
                    i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1446f) / 2);
                    break;
                case 80:
                    i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1446f;
                    break;
            }
            return ((a) childAt.getLayoutParams()).topMargin + i + baseline;
        }
        i = i3;
        return ((a) childAt.getLayoutParams()).topMargin + i + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1442b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1442b = i;
    }

    /* renamed from: b */
    View m1298b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1447g;
    }

    public void setWeightSum(float f2) {
        this.f1447g = Math.max(0.0f, f2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1444d == 1) {
            m1292a(i, i2);
        } else {
            m1299b(i, i2);
        }
    }

    /* renamed from: c */
    protected boolean m1303c(int i) {
        if (i == 0) {
            return (this.f1454n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f1454n & 4) != 0;
        }
        if ((this.f1454n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m1292a(int i, int i2) {
        int i3;
        int i4;
        float f2;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        boolean z3;
        int max;
        int i7;
        int i8;
        boolean z4;
        float f3;
        this.f1446f = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z5 = true;
        float f4 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i13 = this.f1442b;
        boolean z8 = this.f1448h;
        int i14 = 0;
        int i15 = 0;
        while (i15 < virtualChildCount) {
            View m1298b = m1298b(i15);
            if (m1298b == null) {
                this.f1446f += m1304d(i15);
                i8 = i14;
                z4 = z7;
                f3 = f4;
                z3 = z5;
            } else if (m1298b.getVisibility() == 8) {
                i15 += m1291a(m1298b, i15);
                i8 = i14;
                z4 = z7;
                f3 = f4;
                z3 = z5;
            } else {
                if (m1303c(i15)) {
                    this.f1446f += this.f1453m;
                }
                a aVar = (a) m1298b.getLayoutParams();
                float f5 = f4 + aVar.weight;
                if (mode2 == 1073741824 && aVar.height == 0 && aVar.weight > 0.0f) {
                    int i16 = this.f1446f;
                    this.f1446f = Math.max(i16, aVar.topMargin + i16 + aVar.bottomMargin);
                    z7 = true;
                } else {
                    int i17 = Integer.MIN_VALUE;
                    if (aVar.height == 0 && aVar.weight > 0.0f) {
                        i17 = 0;
                        aVar.height = -2;
                    }
                    int i18 = i17;
                    m1296a(m1298b, i15, i, 0, i2, f5 == 0.0f ? this.f1446f : 0);
                    if (i18 != Integer.MIN_VALUE) {
                        aVar.height = i18;
                    }
                    int measuredHeight = m1298b.getMeasuredHeight();
                    int i19 = this.f1446f;
                    this.f1446f = Math.max(i19, i19 + measuredHeight + aVar.topMargin + aVar.bottomMargin + m1297b(m1298b));
                    if (z8) {
                        i14 = Math.max(measuredHeight, i14);
                    }
                }
                if (i13 >= 0 && i13 == i15 + 1) {
                    this.f1443c = this.f1446f;
                }
                if (i15 < i13 && aVar.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean z9 = false;
                if (mode == 1073741824 || aVar.width != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z9 = true;
                }
                int i20 = aVar.rightMargin + aVar.leftMargin;
                int measuredWidth = m1298b.getMeasuredWidth() + i20;
                i9 = Math.max(i9, measuredWidth);
                i10 = View.combineMeasuredStates(i10, m1298b.getMeasuredState());
                z3 = z5 && aVar.width == -1;
                if (aVar.weight > 0.0f) {
                    i7 = Math.max(i12, z9 ? i20 : measuredWidth);
                    max = i11;
                } else {
                    if (!z9) {
                        i20 = measuredWidth;
                    }
                    max = Math.max(i11, i20);
                    i7 = i12;
                }
                i15 += m1291a(m1298b, i15);
                i8 = i14;
                z4 = z7;
                z6 = z2;
                f3 = f5;
                i12 = i7;
                i11 = max;
            }
            i15++;
            i14 = i8;
            z7 = z4;
            f4 = f3;
            z5 = z3;
        }
        if (this.f1446f > 0 && m1303c(virtualChildCount)) {
            this.f1446f += this.f1453m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1446f = 0;
            int i21 = 0;
            while (i21 < virtualChildCount) {
                View m1298b2 = m1298b(i21);
                if (m1298b2 == null) {
                    this.f1446f += m1304d(i21);
                    i6 = i21;
                } else if (m1298b2.getVisibility() == 8) {
                    i6 = m1291a(m1298b2, i21) + i21;
                } else {
                    a aVar2 = (a) m1298b2.getLayoutParams();
                    int i22 = this.f1446f;
                    this.f1446f = Math.max(i22, aVar2.bottomMargin + i22 + i14 + aVar2.topMargin + m1297b(m1298b2));
                    i6 = i21;
                }
                i21 = i6 + 1;
            }
        }
        this.f1446f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f1446f, getSuggestedMinimumHeight()), i2, 0);
        int i23 = (16777215 & resolveSizeAndState) - this.f1446f;
        if (z7 || (i23 != 0 && f4 > 0.0f)) {
            if (this.f1447g > 0.0f) {
                f4 = this.f1447g;
            }
            this.f1446f = 0;
            int i24 = 0;
            float f6 = f4;
            boolean z10 = z5;
            int i25 = i11;
            int i26 = i10;
            int i27 = i9;
            while (i24 < virtualChildCount) {
                View m1298b3 = m1298b(i24);
                if (m1298b3.getVisibility() == 8) {
                    f2 = f6;
                    z = z10;
                } else {
                    a aVar3 = (a) m1298b3.getLayoutParams();
                    float f7 = aVar3.weight;
                    if (f7 > 0.0f) {
                        int i28 = (int) ((i23 * f7) / f6);
                        float f8 = f6 - f7;
                        i5 = i23 - i28;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + aVar3.leftMargin + aVar3.rightMargin, aVar3.width);
                        if (aVar3.height != 0 || mode2 != 1073741824) {
                            int measuredHeight2 = i28 + m1298b3.getMeasuredHeight();
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            m1298b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        } else {
                            if (i28 <= 0) {
                                i28 = 0;
                            }
                            m1298b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i28, 1073741824));
                        }
                        f2 = f8;
                        i26 = View.combineMeasuredStates(i26, m1298b3.getMeasuredState() & (-256));
                    } else {
                        f2 = f6;
                        i5 = i23;
                    }
                    int i29 = aVar3.leftMargin + aVar3.rightMargin;
                    int measuredWidth2 = m1298b3.getMeasuredWidth() + i29;
                    i27 = Math.max(i27, measuredWidth2);
                    if (!(mode != 1073741824 && aVar3.width == -1)) {
                        i29 = measuredWidth2;
                    }
                    i25 = Math.max(i25, i29);
                    boolean z11 = z10 && aVar3.width == -1;
                    int i30 = this.f1446f;
                    this.f1446f = Math.max(i30, aVar3.bottomMargin + m1298b3.getMeasuredHeight() + i30 + aVar3.topMargin + m1297b(m1298b3));
                    i23 = i5;
                    z = z11;
                }
                i24++;
                f6 = f2;
                z10 = z;
            }
            this.f1446f += getPaddingTop() + getPaddingBottom();
            z5 = z10;
            i3 = i25;
            i10 = i26;
            i4 = i27;
        } else {
            int max2 = Math.max(i11, i12);
            if (z8 && mode2 != 1073741824) {
                int i31 = 0;
                while (true) {
                    int i32 = i31;
                    if (i32 >= virtualChildCount) {
                        break;
                    }
                    View m1298b4 = m1298b(i32);
                    if (m1298b4 != null && m1298b4.getVisibility() != 8 && ((a) m1298b4.getLayoutParams()).weight > 0.0f) {
                        m1298b4.measure(View.MeasureSpec.makeMeasureSpec(m1298b4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
                    }
                    i31 = i32 + 1;
                }
            }
            i3 = max2;
            i4 = i9;
        }
        if (z5 || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i10), resolveSizeAndState);
        if (z6) {
            m1288c(virtualChildCount, i2);
        }
    }

    /* renamed from: c */
    private void m1288c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View m1298b = m1298b(i3);
            if (m1298b.getVisibility() != 8) {
                a aVar = (a) m1298b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = m1298b.getMeasuredHeight();
                    measureChildWithMargins(m1298b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* renamed from: b */
    void m1299b(int i, int i2) {
        int i3;
        int i4;
        float f2;
        int i5;
        boolean z;
        int i6;
        float f3;
        int baseline;
        int i7;
        boolean z2;
        boolean z3;
        int max;
        int i8;
        int i9;
        boolean z4;
        float f4;
        int baseline2;
        this.f1446f = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z5 = true;
        float f5 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.f1449i == null || this.f1450j == null) {
            this.f1449i = new int[4];
            this.f1450j = new int[4];
        }
        int[] iArr = this.f1449i;
        int[] iArr2 = this.f1450j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.f1441a;
        boolean z9 = this.f1448h;
        boolean z10 = mode == 1073741824;
        int i14 = 0;
        int i15 = 0;
        while (i15 < virtualChildCount) {
            View m1298b = m1298b(i15);
            if (m1298b == null) {
                this.f1446f += m1304d(i15);
                i9 = i14;
                z4 = z7;
                f4 = f5;
                z3 = z5;
            } else if (m1298b.getVisibility() == 8) {
                i15 += m1291a(m1298b, i15);
                i9 = i14;
                z4 = z7;
                f4 = f5;
                z3 = z5;
            } else {
                if (m1303c(i15)) {
                    this.f1446f += this.f1452l;
                }
                a aVar = (a) m1298b.getLayoutParams();
                float f6 = f5 + aVar.weight;
                if (mode == 1073741824 && aVar.width == 0 && aVar.weight > 0.0f) {
                    if (z10) {
                        this.f1446f += aVar.leftMargin + aVar.rightMargin;
                    } else {
                        int i16 = this.f1446f;
                        this.f1446f = Math.max(i16, aVar.leftMargin + i16 + aVar.rightMargin);
                    }
                    if (z8) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        m1298b.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z7 = true;
                    }
                } else {
                    int i17 = Integer.MIN_VALUE;
                    if (aVar.width == 0 && aVar.weight > 0.0f) {
                        i17 = 0;
                        aVar.width = -2;
                    }
                    int i18 = i17;
                    m1296a(m1298b, i15, i, f6 == 0.0f ? this.f1446f : 0, i2, 0);
                    if (i18 != Integer.MIN_VALUE) {
                        aVar.width = i18;
                    }
                    int measuredWidth = m1298b.getMeasuredWidth();
                    if (z10) {
                        this.f1446f += aVar.leftMargin + measuredWidth + aVar.rightMargin + m1297b(m1298b);
                    } else {
                        int i19 = this.f1446f;
                        this.f1446f = Math.max(i19, i19 + measuredWidth + aVar.leftMargin + aVar.rightMargin + m1297b(m1298b));
                    }
                    if (z9) {
                        i14 = Math.max(measuredWidth, i14);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || aVar.height != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z11 = true;
                }
                int i20 = aVar.bottomMargin + aVar.topMargin;
                int measuredHeight = m1298b.getMeasuredHeight() + i20;
                i11 = View.combineMeasuredStates(i11, m1298b.getMeasuredState());
                if (z8 && (baseline2 = m1298b.getBaseline()) != -1) {
                    int i21 = ((((aVar.gravity < 0 ? this.f1445e : aVar.gravity) & 112) >> 4) & (-2)) >> 1;
                    iArr[i21] = Math.max(iArr[i21], baseline2);
                    iArr2[i21] = Math.max(iArr2[i21], measuredHeight - baseline2);
                }
                i10 = Math.max(i10, measuredHeight);
                z3 = z5 && aVar.height == -1;
                if (aVar.weight > 0.0f) {
                    i8 = Math.max(i13, z11 ? i20 : measuredHeight);
                    max = i12;
                } else {
                    if (!z11) {
                        i20 = measuredHeight;
                    }
                    max = Math.max(i12, i20);
                    i8 = i13;
                }
                i15 += m1291a(m1298b, i15);
                i9 = i14;
                z4 = z7;
                z6 = z2;
                f4 = f6;
                i13 = i8;
                i12 = max;
            }
            i15++;
            i14 = i9;
            z7 = z4;
            f5 = f4;
            z5 = z3;
        }
        if (this.f1446f > 0 && m1303c(virtualChildCount)) {
            this.f1446f += this.f1452l;
        }
        int max2 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i10 : Math.max(i10, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1446f = 0;
            int i22 = 0;
            while (i22 < virtualChildCount) {
                View m1298b2 = m1298b(i22);
                if (m1298b2 == null) {
                    this.f1446f += m1304d(i22);
                    i7 = i22;
                } else if (m1298b2.getVisibility() == 8) {
                    i7 = m1291a(m1298b2, i22) + i22;
                } else {
                    a aVar2 = (a) m1298b2.getLayoutParams();
                    if (z10) {
                        this.f1446f = aVar2.rightMargin + aVar2.leftMargin + i14 + m1297b(m1298b2) + this.f1446f;
                        i7 = i22;
                    } else {
                        int i23 = this.f1446f;
                        this.f1446f = Math.max(i23, aVar2.rightMargin + i23 + i14 + aVar2.leftMargin + m1297b(m1298b2));
                        i7 = i22;
                    }
                }
                i22 = i7 + 1;
            }
        }
        this.f1446f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f1446f, getSuggestedMinimumWidth()), i, 0);
        int i24 = (16777215 & resolveSizeAndState) - this.f1446f;
        if (z7 || (i24 != 0 && f5 > 0.0f)) {
            if (this.f1447g > 0.0f) {
                f5 = this.f1447g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            int i25 = -1;
            this.f1446f = 0;
            int i26 = 0;
            float f7 = f5;
            boolean z12 = z5;
            int i27 = i12;
            int i28 = i11;
            while (i26 < virtualChildCount) {
                View m1298b3 = m1298b(i26);
                if (m1298b3 == null) {
                    f2 = f7;
                    i5 = i24;
                    z = z12;
                    i6 = i25;
                } else if (m1298b3.getVisibility() == 8) {
                    f2 = f7;
                    i5 = i24;
                    z = z12;
                    i6 = i25;
                } else {
                    a aVar3 = (a) m1298b3.getLayoutParams();
                    float f8 = aVar3.weight;
                    if (f8 > 0.0f) {
                        int i29 = (int) ((i24 * f8) / f7);
                        f3 = f7 - f8;
                        i24 -= i29;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin, aVar3.height);
                        if (aVar3.width != 0 || mode != 1073741824) {
                            int measuredWidth2 = i29 + m1298b3.getMeasuredWidth();
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            m1298b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        } else {
                            if (i29 <= 0) {
                                i29 = 0;
                            }
                            m1298b3.measure(View.MeasureSpec.makeMeasureSpec(i29, 1073741824), childMeasureSpec);
                        }
                        i28 = View.combineMeasuredStates(i28, m1298b3.getMeasuredState() & (-16777216));
                    } else {
                        f3 = f7;
                    }
                    if (z10) {
                        this.f1446f += m1298b3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin + m1297b(m1298b3);
                    } else {
                        int i30 = this.f1446f;
                        this.f1446f = Math.max(i30, m1298b3.getMeasuredWidth() + i30 + aVar3.leftMargin + aVar3.rightMargin + m1297b(m1298b3));
                    }
                    boolean z13 = mode2 != 1073741824 && aVar3.height == -1;
                    int i31 = aVar3.topMargin + aVar3.bottomMargin;
                    int measuredHeight2 = m1298b3.getMeasuredHeight() + i31;
                    i6 = Math.max(i25, measuredHeight2);
                    i27 = Math.max(i27, z13 ? i31 : measuredHeight2);
                    boolean z14 = z12 && aVar3.height == -1;
                    if (z8 && (baseline = m1298b3.getBaseline()) != -1) {
                        int i32 = ((((aVar3.gravity < 0 ? this.f1445e : aVar3.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr[i32] = Math.max(iArr[i32], baseline);
                        iArr2[i32] = Math.max(iArr2[i32], measuredHeight2 - baseline);
                    }
                    f2 = f3;
                    i5 = i24;
                    z = z14;
                }
                i26++;
                f7 = f2;
                i24 = i5;
                z12 = z;
                i25 = i6;
            }
            this.f1446f += getPaddingLeft() + getPaddingRight();
            if (iArr[1] != -1 || iArr[0] != -1 || iArr[2] != -1 || iArr[3] != -1) {
                i25 = Math.max(i25, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z12;
            i3 = i27;
            i11 = i28;
            i4 = i25;
        } else {
            int max3 = Math.max(i12, i13);
            if (z9 && mode != 1073741824) {
                int i33 = 0;
                while (true) {
                    int i34 = i33;
                    if (i34 >= virtualChildCount) {
                        break;
                    }
                    View m1298b4 = m1298b(i34);
                    if (m1298b4 != null && m1298b4.getVisibility() != 8 && ((a) m1298b4.getLayoutParams()).weight > 0.0f) {
                        m1298b4.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), View.MeasureSpec.makeMeasureSpec(m1298b4.getMeasuredHeight(), 1073741824));
                    }
                    i33 = i34 + 1;
                }
            }
            i3 = max3;
            i4 = max2;
        }
        if (z5 || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(((-16777216) & i11) | resolveSizeAndState, View.resolveSizeAndState(Math.max(i3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i11 << 16));
        if (z6) {
            m1289d(virtualChildCount, i);
        }
    }

    /* renamed from: d */
    private void m1289d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View m1298b = m1298b(i3);
            if (m1298b.getVisibility() != 8) {
                a aVar = (a) m1298b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = m1298b.getMeasuredWidth();
                    measureChildWithMargins(m1298b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    /* renamed from: a */
    int m1291a(View view, int i) {
        return 0;
    }

    /* renamed from: d */
    int m1304d(int i) {
        return 0;
    }

    /* renamed from: a */
    void m1296a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* renamed from: a */
    int m1290a(View view) {
        return 0;
    }

    /* renamed from: b */
    int m1297b(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1444d == 1) {
            m1293a(i, i2, i3, i4);
        } else {
            m1300b(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    void m1293a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.f1445e & 112;
        int i9 = this.f1445e & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i8) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f1446f) / 2);
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f1446f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < virtualChildCount) {
            View m1298b = m1298b(i10);
            if (m1298b == null) {
                i11 += m1304d(i10);
                i5 = i10;
            } else if (m1298b.getVisibility() != 8) {
                int measuredWidth = m1298b.getMeasuredWidth();
                int measuredHeight = m1298b.getMeasuredHeight();
                a aVar = (a) m1298b.getLayoutParams();
                int i12 = aVar.gravity;
                if (i12 < 0) {
                    i12 = i9;
                }
                switch (C0289e.m2167a(i12, C0308x.m2257f(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i6 = paddingLeft + aVar.leftMargin;
                        break;
                }
                int i13 = (m1303c(i10) ? this.f1453m + i11 : i11) + aVar.topMargin;
                m1287a(m1298b, i6, i13 + m1290a(m1298b), measuredWidth, measuredHeight);
                i11 = i13 + aVar.bottomMargin + measuredHeight + m1297b(m1298b);
                i5 = m1291a(m1298b, i10) + i10;
            } else {
                i5 = i10;
            }
            i10 = i5 + 1;
        }
    }

    /* renamed from: b */
    void m1300b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean m1481a = C0191bf.m1481a(this);
        int paddingTop = getPaddingTop();
        int i10 = i4 - i2;
        int paddingBottom = i10 - getPaddingBottom();
        int paddingBottom2 = (i10 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i11 = this.f1445e & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i12 = this.f1445e & 112;
        boolean z = this.f1441a;
        int[] iArr = this.f1449i;
        int[] iArr2 = this.f1450j;
        switch (C0289e.m2167a(i11, C0308x.m2257f(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1446f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1446f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (!m1481a) {
            i5 = 1;
            i6 = 0;
        } else {
            i5 = -1;
            i6 = virtualChildCount - 1;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            int i14 = i6 + (i5 * i13);
            View m1298b = m1298b(i14);
            if (m1298b == null) {
                paddingLeft += m1304d(i14);
                i7 = i13;
            } else if (m1298b.getVisibility() != 8) {
                int measuredWidth = m1298b.getMeasuredWidth();
                int measuredHeight = m1298b.getMeasuredHeight();
                a aVar = (a) m1298b.getLayoutParams();
                if (!z || aVar.height == -1) {
                    i8 = -1;
                } else {
                    i8 = m1298b.getBaseline();
                }
                int i15 = aVar.gravity;
                if (i15 < 0) {
                    i15 = i12;
                }
                switch (i15 & 112) {
                    case 16:
                        i9 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        break;
                    case 48:
                        i9 = paddingTop + aVar.topMargin;
                        if (i8 != -1) {
                            i9 += iArr[1] - i8;
                            break;
                        }
                        break;
                    case 80:
                        i9 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                        if (i8 != -1) {
                            i9 -= iArr2[2] - (m1298b.getMeasuredHeight() - i8);
                            break;
                        }
                        break;
                    default:
                        i9 = paddingTop;
                        break;
                }
                int i16 = (m1303c(i14) ? this.f1452l + paddingLeft : paddingLeft) + aVar.leftMargin;
                m1287a(m1298b, i16 + m1290a(m1298b), i9, measuredWidth, measuredHeight);
                paddingLeft = i16 + aVar.rightMargin + measuredWidth + m1297b(m1298b);
                i7 = m1291a(m1298b, i14) + i13;
            } else {
                i7 = i13;
            }
            i13 = i7 + 1;
        }
    }

    /* renamed from: a */
    private void m1287a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f1444d != i) {
            this.f1444d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f1444d;
    }

    public void setGravity(int i) {
        if (this.f1445e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1445e = i2;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f1445e;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.f1445e & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.f1445e = i2 | (this.f1445e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1445e & 112) != i2) {
            this.f1445e = i2 | (this.f1445e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        if (this.f1444d == 0) {
            return new a(-2, -2);
        }
        if (this.f1444d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* compiled from: LinearLayoutCompat.java */
    /* renamed from: androidx.appcompat.widget.ak$a */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
