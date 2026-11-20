package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    private TypedValue f1216a;

    /* renamed from: b */
    private TypedValue f1217b;

    /* renamed from: c */
    private TypedValue f1218c;

    /* renamed from: d */
    private TypedValue f1219d;

    /* renamed from: e */
    private TypedValue f1220e;

    /* renamed from: f */
    private TypedValue f1221f;

    /* renamed from: g */
    private final Rect f1222g;

    /* renamed from: h */
    private InterfaceC0132a f1223h;

    /* renamed from: androidx.appcompat.widget.ContentFrameLayout$a */
    public interface InterfaceC0132a {
        /* renamed from: a */
        void mo554a();

        /* renamed from: b */
        void mo555b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1222g = new Rect();
    }

    /* renamed from: a */
    public void m1053a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(InterfaceC0132a interfaceC0132a) {
        this.f1223h = interfaceC0132a;
    }

    /* renamed from: a */
    public void m1052a(int i, int i2, int i3, int i4) {
        this.f1222g.set(i, i2, i3, i4);
        if (C0308x.m2275v(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        boolean z;
        int measuredWidth;
        int i3;
        TypedValue typedValue;
        int fraction;
        int fraction2;
        int fraction3;
        boolean z2 = false;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f1219d : this.f1218c;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction3 = (int) typedValue2.getDimension(displayMetrics);
                } else {
                    fraction3 = typedValue2.type == 6 ? (int) typedValue2.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                }
                if (fraction3 > 0) {
                    i = View.MeasureSpec.makeMeasureSpec(Math.min(fraction3 - (this.f1222g.left + this.f1222g.right), View.MeasureSpec.getSize(i)), 1073741824);
                    z = true;
                    if (mode2 == Integer.MIN_VALUE) {
                        TypedValue typedValue3 = z3 ? this.f1220e : this.f1221f;
                        if (typedValue3 != null && typedValue3.type != 0) {
                            if (typedValue3.type == 5) {
                                fraction2 = (int) typedValue3.getDimension(displayMetrics);
                            } else {
                                fraction2 = typedValue3.type == 6 ? (int) typedValue3.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels) : 0;
                            }
                            if (fraction2 > 0) {
                                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(fraction2 - (this.f1222g.top + this.f1222g.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    measuredWidth = getMeasuredWidth();
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                    if (!z && mode == Integer.MIN_VALUE) {
                        typedValue = !z3 ? this.f1217b : this.f1216a;
                        if (typedValue != null && typedValue.type != 0) {
                            if (typedValue.type != 5) {
                                fraction = (int) typedValue.getDimension(displayMetrics);
                            } else {
                                fraction = typedValue.type == 6 ? (int) typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                            }
                            if (fraction > 0) {
                                fraction -= this.f1222g.left + this.f1222g.right;
                            }
                            if (measuredWidth < fraction) {
                                i3 = View.MeasureSpec.makeMeasureSpec(fraction, 1073741824);
                                z2 = true;
                                if (z2) {
                                    super.onMeasure(i3, i2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    i3 = makeMeasureSpec;
                    if (z2) {
                    }
                }
            }
        }
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i, i2);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z) {
            if (!z3) {
            }
            if (typedValue != null) {
                if (typedValue.type != 5) {
                }
                if (fraction > 0) {
                }
                if (measuredWidth < fraction) {
                }
            }
        }
        i3 = makeMeasureSpec2;
        if (z2) {
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1216a == null) {
            this.f1216a = new TypedValue();
        }
        return this.f1216a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1217b == null) {
            this.f1217b = new TypedValue();
        }
        return this.f1217b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1218c == null) {
            this.f1218c = new TypedValue();
        }
        return this.f1218c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1219d == null) {
            this.f1219d = new TypedValue();
        }
        return this.f1219d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1220e == null) {
            this.f1220e = new TypedValue();
        }
        return this.f1220e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1221f == null) {
            this.f1221f = new TypedValue();
        }
        return this.f1221f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1223h != null) {
            this.f1223h.mo554a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1223h != null) {
            this.f1223h.mo555b();
        }
    }
}
