package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.menu.C0106g;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0158a {

    /* renamed from: g */
    private CharSequence f1121g;

    /* renamed from: h */
    private CharSequence f1122h;

    /* renamed from: i */
    private View f1123i;

    /* renamed from: j */
    private View f1124j;

    /* renamed from: k */
    private View f1125k;

    /* renamed from: l */
    private LinearLayout f1126l;

    /* renamed from: m */
    private TextView f1127m;

    /* renamed from: n */
    private TextView f1128n;

    /* renamed from: o */
    private int f1129o;

    /* renamed from: p */
    private int f1130p;

    /* renamed from: q */
    private boolean f1131q;

    /* renamed from: r */
    private int f1132r;

    @Override // androidx.appcompat.widget.AbstractC0158a
    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0278ab mo979a(int i, long j) {
        return super.mo979a(i, j);
    }

    @Override // androidx.appcompat.widget.AbstractC0158a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0158a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.AbstractC0158a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0158a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0158a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.ActionMode, i, 0);
        C0308x.m2233a(this, m1432a.m1437a(C0059a.j.ActionMode_background));
        this.f1129o = m1432a.m1450g(C0059a.j.ActionMode_titleTextStyle, 0);
        this.f1130p = m1432a.m1450g(C0059a.j.ActionMode_subtitleTextStyle, 0);
        this.f1361e = m1432a.m1448f(C0059a.j.ActionMode_height, 0);
        this.f1132r = m1432a.m1450g(C0059a.j.ActionMode_closeItemLayout, C0059a.g.abc_action_mode_close_item_material);
        m1432a.m1441b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1360d != null) {
            this.f1360d.m1500e();
            this.f1360d.m1502g();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0158a
    public void setContentHeight(int i) {
        this.f1361e = i;
    }

    public void setCustomView(View view) {
        if (this.f1125k != null) {
            removeView(this.f1125k);
        }
        this.f1125k = view;
        if (view != null && this.f1126l != null) {
            removeView(this.f1126l);
            this.f1126l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1121g = charSequence;
        m978e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1122h = charSequence;
        m978e();
    }

    public CharSequence getTitle() {
        return this.f1121g;
    }

    public CharSequence getSubtitle() {
        return this.f1122h;
    }

    /* renamed from: e */
    private void m978e() {
        if (this.f1126l == null) {
            LayoutInflater.from(getContext()).inflate(C0059a.g.abc_action_bar_title_item, this);
            this.f1126l = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1127m = (TextView) this.f1126l.findViewById(C0059a.f.action_bar_title);
            this.f1128n = (TextView) this.f1126l.findViewById(C0059a.f.action_bar_subtitle);
            if (this.f1129o != 0) {
                this.f1127m.setTextAppearance(getContext(), this.f1129o);
            }
            if (this.f1130p != 0) {
                this.f1128n.setTextAppearance(getContext(), this.f1130p);
            }
        }
        this.f1127m.setText(this.f1121g);
        this.f1128n.setText(this.f1122h);
        boolean z = !TextUtils.isEmpty(this.f1121g);
        boolean z2 = TextUtils.isEmpty(this.f1122h) ? false : true;
        this.f1128n.setVisibility(z2 ? 0 : 8);
        this.f1126l.setVisibility((z || z2) ? 0 : 8);
        if (this.f1126l.getParent() == null) {
            addView(this.f1126l);
        }
    }

    /* renamed from: a */
    public void m980a(final AbstractC0090b abstractC0090b) {
        if (this.f1123i == null) {
            this.f1123i = LayoutInflater.from(getContext()).inflate(this.f1132r, (ViewGroup) this, false);
            addView(this.f1123i);
        } else if (this.f1123i.getParent() == null) {
            addView(this.f1123i);
        }
        this.f1124j = this.f1123i.findViewById(C0059a.f.action_mode_close_button);
        this.f1124j.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                abstractC0090b.mo660c();
            }
        });
        C0106g c0106g = (C0106g) abstractC0090b.mo657b();
        if (this.f1360d != null) {
            this.f1360d.m1501f();
        }
        this.f1360d = new C0193c(getContext());
        this.f1360d.m1495b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c0106g.m880a(this.f1360d, this.f1358b);
        this.f1359c = (ActionMenuView) this.f1360d.mo808a(this);
        C0308x.m2233a(this.f1359c, (Drawable) null);
        addView(this.f1359c, layoutParams);
    }

    /* renamed from: b */
    public void m982b() {
        if (this.f1123i == null) {
            m983c();
        }
    }

    /* renamed from: c */
    public void m983c() {
        removeAllViews();
        this.f1125k = null;
        this.f1359c = null;
        this.f1360d = null;
        if (this.f1124j != null) {
            this.f1124j.setOnClickListener(null);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0158a
    /* renamed from: a */
    public boolean mo981a() {
        if (this.f1360d != null) {
            return this.f1360d.m1499d();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f1361e > 0 ? this.f1361e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        if (this.f1123i != null) {
            int a2 = m1159a(this.f1123i, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1123i.getLayoutParams();
            paddingLeft = a2 - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
        }
        if (this.f1359c != null && this.f1359c.getParent() == this) {
            paddingLeft = m1159a(this.f1359c, paddingLeft, makeMeasureSpec, 0);
        }
        if (this.f1126l != null && this.f1125k == null) {
            if (this.f1131q) {
                this.f1126l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f1126l.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f1126l.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m1159a(this.f1126l, paddingLeft, makeMeasureSpec, 0);
            }
        }
        if (this.f1125k != null) {
            ViewGroup.LayoutParams layoutParams = this.f1125k.getLayoutParams();
            int i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            this.f1125k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i3) : i3, layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824));
        }
        if (this.f1361e <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            int i6 = 0;
            while (i5 < childCount) {
                int measuredHeight = getChildAt(i5).getMeasuredHeight() + paddingTop;
                if (measuredHeight <= i6) {
                    measuredHeight = i6;
                }
                i5++;
                i6 = measuredHeight;
            }
            setMeasuredDimension(size, i6);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean m1481a = C0191bf.m1481a(this);
        int paddingRight = m1481a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1123i == null || this.f1123i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1123i.getLayoutParams();
            int i6 = m1481a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = m1481a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m1156a(paddingRight, i6, m1481a);
            i5 = m1156a(m1160a(this.f1123i, a2, paddingTop, paddingTop2, m1481a) + a2, i7, m1481a);
        }
        if (this.f1126l != null && this.f1125k == null && this.f1126l.getVisibility() != 8) {
            i5 += m1160a(this.f1126l, i5, paddingTop, paddingTop2, m1481a);
        }
        if (this.f1125k != null) {
            int a3 = m1160a(this.f1125k, i5, paddingTop, paddingTop2, m1481a) + i5;
        }
        int paddingLeft = m1481a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f1359c != null) {
            int a4 = m1160a(this.f1359c, paddingLeft, paddingTop, paddingTop2, !m1481a) + paddingLeft;
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1121g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1131q) {
            requestLayout();
        }
        this.f1131q = z;
    }

    /* renamed from: d */
    public boolean m984d() {
        return this.f1131q;
    }
}
