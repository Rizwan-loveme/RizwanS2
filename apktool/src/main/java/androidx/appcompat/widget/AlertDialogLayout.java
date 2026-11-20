package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.widget.C0169ak;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class AlertDialogLayout extends C0169ak {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!m1048c(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: c */
    private boolean m1048c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int makeMeasureSpec;
        View view = null;
        View view2 = null;
        View view3 = null;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0059a.f.topPanel) {
                    view = childAt;
                } else if (id == C0059a.f.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != C0059a.f.contentPanel && id != C0059a.f.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int i9 = 0;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            paddingBottom += view.getMeasuredHeight();
            i9 = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        int i10 = 0;
        if (view2 == null) {
            i3 = 0;
        } else {
            view2.measure(i, 0);
            i10 = m1047c(view2);
            int measuredHeight = view2.getMeasuredHeight() - i10;
            paddingBottom += i10;
            i9 = View.combineMeasuredStates(i9, view2.getMeasuredState());
            i3 = measuredHeight;
        }
        if (view3 == null) {
            i4 = 0;
        } else {
            if (mode == 0) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode);
            }
            view3.measure(i, makeMeasureSpec);
            int measuredHeight2 = view3.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            i9 = View.combineMeasuredStates(i9, view3.getMeasuredState());
            i4 = measuredHeight2;
        }
        int i11 = size - paddingBottom;
        if (view2 != null) {
            int i12 = paddingBottom - i10;
            int min = Math.min(i11, i3);
            if (min > 0) {
                i11 -= min;
                i10 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
            int measuredHeight3 = i12 + view2.getMeasuredHeight();
            i6 = View.combineMeasuredStates(i9, view2.getMeasuredState());
            i5 = measuredHeight3;
        } else {
            i5 = paddingBottom;
            i6 = i9;
        }
        if (view3 == null || i11 <= 0) {
            i7 = i5;
        } else {
            int i13 = i11 - i11;
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i11 + i4, mode));
            int measuredHeight4 = view3.getMeasuredHeight() + (i5 - i4);
            int combineMeasuredStates = View.combineMeasuredStates(i6, view3.getMeasuredState());
            i7 = measuredHeight4;
            i6 = combineMeasuredStates;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                i14 = Math.max(i14, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i14 + getPaddingLeft() + getPaddingRight(), i, i6), View.resolveSizeAndState(i7, i2, 0));
        if (mode2 != 1073741824) {
            m1049d(childCount, i2);
        }
        return true;
    }

    /* renamed from: d */
    private void m1049d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0169ak.a aVar = (C0169ak.a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* renamed from: c */
    private static int m1047c(View view) {
        int m2262i = C0308x.m2262i(view);
        if (m2262i <= 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() == 1) {
                    return m1047c(viewGroup.getChildAt(0));
                }
            }
            return 0;
        }
        return m2262i;
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 112;
        int i8 = gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i7) {
            case 16:
                paddingTop = (((i4 - i2) - measuredHeight) / 2) + getPaddingTop();
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - measuredHeight;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i9 = paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                C0169ak.a aVar = (C0169ak.a) childAt.getLayoutParams();
                int i11 = aVar.gravity;
                if (i11 < 0) {
                    i11 = i8;
                }
                switch (C0289e.m2167a(i11, C0308x.m2257f(this)) & 7) {
                    case 1:
                        i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i5 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i5 = paddingLeft + aVar.leftMargin;
                        break;
                }
                int i12 = aVar.topMargin + (m1303c(i10) ? i9 + intrinsicHeight : i9);
                m1046a(childAt, i5, i12, measuredWidth, measuredHeight2);
                i9 = i12 + aVar.bottomMargin + measuredHeight2;
            }
        }
    }

    /* renamed from: a */
    private void m1046a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }
}
