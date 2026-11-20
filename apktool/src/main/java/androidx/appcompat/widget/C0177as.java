package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.AbstractC0069a;
import androidx.appcompat.view.C0089a;
import androidx.appcompat.widget.C0169ak;

/* compiled from: ScrollingTabContainerView.java */
/* renamed from: androidx.appcompat.widget.as */
/* loaded from: classes.dex */
public class C0177as extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f1531j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f1532a;

    /* renamed from: b */
    C0169ak f1533b;

    /* renamed from: c */
    int f1534c;

    /* renamed from: d */
    int f1535d;

    /* renamed from: e */
    private b f1536e;

    /* renamed from: f */
    private Spinner f1537f;

    /* renamed from: g */
    private boolean f1538g;

    /* renamed from: h */
    private int f1539h;

    /* renamed from: i */
    private int f1540i;

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1533b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f1534c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1534c = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1534c = Math.min(this.f1534c, this.f1535d);
        } else {
            this.f1534c = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1539h, 1073741824);
        if (!z && this.f1538g) {
            this.f1533b.measure(0, makeMeasureSpec);
            if (this.f1533b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m1388b();
            } else {
                m1389c();
            }
        } else {
            m1389c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1540i);
        }
    }

    /* renamed from: a */
    private boolean m1387a() {
        return this.f1537f != null && this.f1537f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f1538g = z;
    }

    /* renamed from: b */
    private void m1388b() {
        if (!m1387a()) {
            if (this.f1537f == null) {
                this.f1537f = m1390d();
            }
            removeView(this.f1533b);
            addView(this.f1537f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1537f.getAdapter() == null) {
                this.f1537f.setAdapter((SpinnerAdapter) new a());
            }
            if (this.f1532a != null) {
                removeCallbacks(this.f1532a);
                this.f1532a = null;
            }
            this.f1537f.setSelection(this.f1540i);
        }
    }

    /* renamed from: c */
    private boolean m1389c() {
        if (m1387a()) {
            removeView(this.f1537f);
            addView(this.f1533b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1537f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f1540i = i;
        int childCount = this.f1533b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1533b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m1392a(i);
            }
            i2++;
        }
        if (this.f1537f != null && i >= 0) {
            this.f1537f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f1539h = i;
        requestLayout();
    }

    /* renamed from: d */
    private Spinner m1390d() {
        C0215y c0215y = new C0215y(getContext(), null, C0059a.a.actionDropDownStyle);
        c0215y.setLayoutParams(new C0169ak.a(-2, -1));
        c0215y.setOnItemSelectedListener(this);
        return c0215y;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0089a m738a = C0089a.m738a(getContext());
        setContentHeight(m738a.m743e());
        this.f1535d = m738a.m745g();
    }

    /* renamed from: a */
    public void m1392a(int i) {
        final View childAt = this.f1533b.getChildAt(i);
        if (this.f1532a != null) {
            removeCallbacks(this.f1532a);
        }
        this.f1532a = new Runnable() { // from class: androidx.appcompat.widget.as.1
            @Override // java.lang.Runnable
            public void run() {
                C0177as.this.smoothScrollTo(childAt.getLeft() - ((C0177as.this.getWidth() - childAt.getWidth()) / 2), 0);
                C0177as.this.f1532a = null;
            }
        };
        post(this.f1532a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1532a != null) {
            post(this.f1532a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1532a != null) {
            removeCallbacks(this.f1532a);
        }
    }

    /* renamed from: a */
    c m1391a(AbstractC0069a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1539h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1536e == null) {
                this.f1536e = new b();
            }
            cVar2.setOnClickListener(this.f1536e);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).m1395b().m411d();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.as$c */
    private class c extends LinearLayout {

        /* renamed from: b */
        private final int[] f1546b;

        /* renamed from: c */
        private AbstractC0069a.c f1547c;

        /* renamed from: d */
        private TextView f1548d;

        /* renamed from: e */
        private ImageView f1549e;

        /* renamed from: f */
        private View f1550f;

        public c(Context context, AbstractC0069a.c cVar, boolean z) {
            super(context, null, C0059a.a.actionBarTabStyle);
            this.f1546b = new int[]{C0012R.attr.background};
            this.f1547c = cVar;
            C0184az m1432a = C0184az.m1432a(context, null, this.f1546b, C0059a.a.actionBarTabStyle, 0);
            if (m1432a.m1451g(0)) {
                setBackgroundDrawable(m1432a.m1437a(0));
            }
            m1432a.m1441b();
            if (z) {
                setGravity(8388627);
            }
            m1393a();
        }

        /* renamed from: a */
        public void m1394a(AbstractC0069a.c cVar) {
            this.f1547c = cVar;
            m1393a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C0177as.this.f1534c > 0 && getMeasuredWidth() > C0177as.this.f1534c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(C0177as.this.f1534c, 1073741824), i2);
            }
        }

        /* renamed from: a */
        public void m1393a() {
            AbstractC0069a.c cVar = this.f1547c;
            View m410c = cVar.m410c();
            if (m410c != null) {
                ViewParent parent = m410c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(m410c);
                    }
                    addView(m410c);
                }
                this.f1550f = m410c;
                if (this.f1548d != null) {
                    this.f1548d.setVisibility(8);
                }
                if (this.f1549e != null) {
                    this.f1549e.setVisibility(8);
                    this.f1549e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1550f != null) {
                removeView(this.f1550f);
                this.f1550f = null;
            }
            Drawable m408a = cVar.m408a();
            CharSequence m409b = cVar.m409b();
            if (m408a != null) {
                if (this.f1549e == null) {
                    C0206p c0206p = new C0206p(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    c0206p.setLayoutParams(layoutParams);
                    addView(c0206p, 0);
                    this.f1549e = c0206p;
                }
                this.f1549e.setImageDrawable(m408a);
                this.f1549e.setVisibility(0);
            } else if (this.f1549e != null) {
                this.f1549e.setVisibility(8);
                this.f1549e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(m409b);
            if (z) {
                if (this.f1548d == null) {
                    C0160ab c0160ab = new C0160ab(getContext(), null, C0059a.a.actionBarTabTextStyle);
                    c0160ab.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    c0160ab.setLayoutParams(layoutParams2);
                    addView(c0160ab);
                    this.f1548d = c0160ab;
                }
                this.f1548d.setText(m409b);
                this.f1548d.setVisibility(0);
            } else if (this.f1548d != null) {
                this.f1548d.setVisibility(8);
                this.f1548d.setText((CharSequence) null);
            }
            if (this.f1549e != null) {
                this.f1549e.setContentDescription(cVar.m412e());
            }
            C0187bb.m1463a(this, z ? null : cVar.m412e());
        }

        /* renamed from: b */
        public AbstractC0069a.c m1395b() {
            return this.f1547c;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.as$a */
    private class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return C0177as.this.f1533b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) C0177as.this.f1533b.getChildAt(i)).m1395b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C0177as.this.m1391a((AbstractC0069a.c) getItem(i), true);
            }
            ((c) view).m1394a((AbstractC0069a.c) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.as$b */
    private class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).m1395b().m411d();
            int childCount = C0177as.this.f1533b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C0177as.this.f1533b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
