package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    private boolean f1213a;

    /* renamed from: b */
    private int f1214b;

    /* renamed from: c */
    private int f1215c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1214b = -1;
        this.f1215c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ButtonBarLayout);
        C0308x.m2230a(this, context, C0059a.j.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1213a = obtainStyledAttributes.getBoolean(C0059a.j.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f1213a != z) {
            this.f1213a = z;
            if (!this.f1213a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        if (this.f1213a) {
            if (size > this.f1214b && m1051a()) {
                setStacked(false);
            }
            this.f1214b = size;
        }
        if (m1051a() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f1213a && !m1051a()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int m1050a = m1050a(0);
        if (m1050a >= 0) {
            View childAt = getChildAt(m1050a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i4 = layoutParams.bottomMargin + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + 0;
            if (m1051a()) {
                int m1050a2 = m1050a(m1050a + 1);
                if (m1050a2 >= 0) {
                    i4 += getChildAt(m1050a2).getPaddingTop() + ((int) (16.0f * getResources().getDisplayMetrics().density));
                }
            } else {
                i4 += getPaddingBottom();
            }
        } else {
            i4 = 0;
        }
        if (C0308x.m2262i(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    /* renamed from: a */
    private int m1050a(int i) {
        int childCount = getChildCount();
        for (int i2 = i; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f1215c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? Gravity.END : 80);
        View findViewById = findViewById(C0059a.f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: a */
    private boolean m1051a() {
        return getOrientation() == 1;
    }
}
