package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0160ab;
import androidx.appcompat.widget.C0187bb;

/* loaded from: classes.dex */
public class ActionMenuItemView extends C0160ab implements View.OnClickListener, InterfaceC0113n.a, ActionMenuView.InterfaceC0125a {

    /* renamed from: a */
    C0108i f877a;

    /* renamed from: b */
    C0106g.b f878b;

    /* renamed from: c */
    AbstractC0099b f879c;

    /* renamed from: e */
    private CharSequence f880e;

    /* renamed from: f */
    private Drawable f881f;

    /* renamed from: g */
    private AbstractViewOnAttachStateChangeListenerC0168aj f882g;

    /* renamed from: h */
    private boolean f883h;

    /* renamed from: i */
    private boolean f884i;

    /* renamed from: j */
    private int f885j;

    /* renamed from: k */
    private int f886k;

    /* renamed from: l */
    private int f887l;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    public static abstract class AbstractC0099b {
        /* renamed from: a */
        public abstract InterfaceC0115p mo789a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f883h = m780e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ActionMenuItemView, i, 0);
        this.f885j = obtainStyledAttributes.getDimensionPixelSize(C0059a.j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f887l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f886k = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f883h = m780e();
        m781f();
    }

    /* renamed from: e */
    private boolean m780e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f886k = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    public C0108i getItemData() {
        return this.f877a;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    /* renamed from: a */
    public void mo782a(C0108i c0108i, int i) {
        this.f877a = c0108i;
        setIcon(c0108i.getIcon());
        setTitle(c0108i.m922a((InterfaceC0113n.a) this));
        setId(c0108i.getItemId());
        setVisibility(c0108i.isVisible() ? 0 : 8);
        setEnabled(c0108i.isEnabled());
        if (c0108i.hasSubMenu() && this.f882g == null) {
            this.f882g = new C0098a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f877a.hasSubMenu() && this.f882g != null && this.f882g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f878b != null) {
            this.f878b.mo791a(this.f877a);
        }
    }

    public void setItemInvoker(C0106g.b bVar) {
        this.f878b = bVar;
    }

    public void setPopupCallback(AbstractC0099b abstractC0099b) {
        this.f879c = abstractC0099b;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    /* renamed from: a */
    public boolean mo783a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f884i != z) {
            this.f884i = z;
            if (this.f877a != null) {
                this.f877a.m937h();
            }
        }
    }

    /* renamed from: f */
    private void m781f() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f880e);
        if (this.f881f == null || (this.f877a.m942m() && (this.f883h || this.f884i))) {
            z = true;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f880e : null);
        CharSequence contentDescription = this.f877a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f877a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f877a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            C0187bb.m1463a(this, z3 ? null : this.f877a.getTitle());
        } else {
            C0187bb.m1463a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f881f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f887l) {
                float f2 = this.f887l / intrinsicWidth;
                intrinsicWidth = this.f887l;
                intrinsicHeight = (int) (intrinsicHeight * f2);
            }
            if (intrinsicHeight > this.f887l) {
                float f3 = this.f887l / intrinsicHeight;
                intrinsicHeight = this.f887l;
                intrinsicWidth = (int) (intrinsicWidth * f3);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m781f();
    }

    /* renamed from: b */
    public boolean m784b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f880e = charSequence;
        m781f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0125a
    /* renamed from: c */
    public boolean mo785c() {
        return m784b() && this.f877a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0125a
    /* renamed from: d */
    public boolean mo786d() {
        return m784b();
    }

    @Override // androidx.appcompat.widget.C0160ab, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean m784b = m784b();
        if (m784b && this.f886k >= 0) {
            super.setPadding(this.f886k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f885j) : this.f885j;
        if (mode != 1073741824 && this.f885j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!m784b && this.f881f != null) {
            super.setPadding((getMeasuredWidth() - this.f881f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    private class C0098a extends AbstractViewOnAttachStateChangeListenerC0168aj {
        public C0098a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
        /* renamed from: a */
        public InterfaceC0115p mo787a() {
            if (ActionMenuItemView.this.f879c != null) {
                return ActionMenuItemView.this.f879c.mo789a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
        /* renamed from: b */
        protected boolean mo788b() {
            InterfaceC0115p mo787a;
            return ActionMenuItemView.this.f878b != null && ActionMenuItemView.this.f878b.mo791a(ActionMenuItemView.this.f877a) && (mo787a = mo787a()) != null && mo787a.mo845d();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
