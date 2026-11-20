package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0089a;
import androidx.appcompat.view.menu.AbstractC0101b;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.C0108i;
import androidx.appcompat.view.menu.C0111l;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.appcompat.view.menu.InterfaceC0115p;
import androidx.appcompat.view.menu.SubMenuC0117r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p031f.AbstractC0283b;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter.java */
/* renamed from: androidx.appcompat.widget.c */
/* loaded from: classes.dex */
class C0193c extends AbstractC0101b implements AbstractC0283b.a {

    /* renamed from: g */
    d f1638g;

    /* renamed from: h */
    e f1639h;

    /* renamed from: i */
    a f1640i;

    /* renamed from: j */
    c f1641j;

    /* renamed from: k */
    final f f1642k;

    /* renamed from: l */
    int f1643l;

    /* renamed from: m */
    private Drawable f1644m;

    /* renamed from: n */
    private boolean f1645n;

    /* renamed from: o */
    private boolean f1646o;

    /* renamed from: p */
    private boolean f1647p;

    /* renamed from: q */
    private int f1648q;

    /* renamed from: r */
    private int f1649r;

    /* renamed from: s */
    private int f1650s;

    /* renamed from: t */
    private boolean f1651t;

    /* renamed from: u */
    private boolean f1652u;

    /* renamed from: v */
    private boolean f1653v;

    /* renamed from: w */
    private boolean f1654w;

    /* renamed from: x */
    private int f1655x;

    /* renamed from: y */
    private final SparseBooleanArray f1656y;

    /* renamed from: z */
    private b f1657z;

    public C0193c(Context context) {
        super(context, C0059a.g.abc_action_menu_layout, C0059a.g.abc_action_menu_item_layout);
        this.f1656y = new SparseBooleanArray();
        this.f1642k = new f();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b, androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo810a(Context context, C0106g c0106g) {
        super.mo810a(context, c0106g);
        Resources resources = context.getResources();
        C0089a m738a = C0089a.m738a(context);
        if (!this.f1647p) {
            this.f1646o = m738a.m740b();
        }
        if (!this.f1653v) {
            this.f1648q = m738a.m741c();
        }
        if (!this.f1651t) {
            this.f1650s = m738a.m739a();
        }
        int i = this.f1648q;
        if (this.f1646o) {
            if (this.f1638g == null) {
                this.f1638g = new d(this.f929a);
                if (this.f1645n) {
                    this.f1638g.setImageDrawable(this.f1644m);
                    this.f1644m = null;
                    this.f1645n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1638g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1638g.getMeasuredWidth();
        } else {
            this.f1638g = null;
        }
        this.f1649r = i;
        this.f1655x = (int) (56.0f * resources.getDisplayMetrics().density);
    }

    /* renamed from: a */
    public void m1492a(Configuration configuration) {
        if (!this.f1651t) {
            this.f1650s = C0089a.m738a(this.f930b).m739a();
        }
        if (this.f931c != null) {
            this.f931c.m890b(true);
        }
    }

    /* renamed from: b */
    public void m1495b(boolean z) {
        this.f1646o = z;
        this.f1647p = true;
    }

    /* renamed from: c */
    public void m1497c(boolean z) {
        this.f1654w = z;
    }

    /* renamed from: a */
    public void m1493a(Drawable drawable) {
        if (this.f1638g != null) {
            this.f1638g.setImageDrawable(drawable);
        } else {
            this.f1645n = true;
            this.f1644m = drawable;
        }
    }

    /* renamed from: c */
    public Drawable m1496c() {
        if (this.f1638g != null) {
            return this.f1638g.getDrawable();
        }
        if (this.f1645n) {
            return this.f1644m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b
    /* renamed from: a */
    public InterfaceC0113n mo808a(ViewGroup viewGroup) {
        InterfaceC0113n interfaceC0113n = this.f934f;
        InterfaceC0113n mo808a = super.mo808a(viewGroup);
        if (interfaceC0113n != mo808a) {
            ((ActionMenuView) mo808a).setPresenter(this);
        }
        return mo808a;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b
    /* renamed from: a */
    public View mo806a(C0108i c0108i, View view, ViewGroup viewGroup) {
        View actionView = c0108i.getActionView();
        if (actionView == null || c0108i.m943n()) {
            actionView = super.mo806a(c0108i, view, viewGroup);
        }
        actionView.setVisibility(c0108i.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b
    /* renamed from: a */
    public void mo813a(C0108i c0108i, InterfaceC0113n.a aVar) {
        aVar.mo782a(c0108i, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f934f);
        if (this.f1657z == null) {
            this.f1657z = new b();
        }
        actionMenuItemView.setPopupCallback(this.f1657z);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b
    /* renamed from: a */
    public boolean mo816a(int i, C0108i c0108i) {
        return c0108i.m939j();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b, androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo815a(boolean z) {
        boolean z2 = false;
        super.mo815a(z);
        ((View) this.f934f).requestLayout();
        if (this.f931c != null) {
            ArrayList<C0108i> m908l = this.f931c.m908l();
            int size = m908l.size();
            for (int i = 0; i < size; i++) {
                AbstractC0283b mo803a = m908l.get(i).mo803a();
                if (mo803a != null) {
                    mo803a.m2128a(this);
                }
            }
        }
        ArrayList<C0108i> m909m = this.f931c != null ? this.f931c.m909m() : null;
        if (this.f1646o && m909m != null) {
            int size2 = m909m.size();
            if (size2 == 1) {
                z2 = !m909m.get(0).isActionViewExpanded();
            } else {
                z2 = size2 > 0;
            }
        }
        if (z2) {
            if (this.f1638g == null) {
                this.f1638g = new d(this.f929a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1638g.getParent();
            if (viewGroup != this.f934f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1638g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f934f;
                actionMenuView.addView(this.f1638g, actionMenuView.m1023c());
            }
        } else if (this.f1638g != null && this.f1638g.getParent() == this.f934f) {
            ((ViewGroup) this.f934f).removeView(this.f1638g);
        }
        ((ActionMenuView) this.f934f).setOverflowReserved(this.f1646o);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b
    /* renamed from: a */
    public boolean mo817a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1638g) {
            return false;
        }
        return super.mo817a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b, androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo819a(SubMenuC0117r subMenuC0117r) {
        boolean z;
        if (!subMenuC0117r.hasVisibleItems()) {
            return false;
        }
        SubMenuC0117r subMenuC0117r2 = subMenuC0117r;
        while (subMenuC0117r2.m975t() != this.f931c) {
            subMenuC0117r2 = (SubMenuC0117r) subMenuC0117r2.m975t();
        }
        View m1484a = m1484a(subMenuC0117r2.getItem());
        if (m1484a == null) {
            return false;
        }
        this.f1643l = subMenuC0117r.getItem().getItemId();
        int size = subMenuC0117r.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            MenuItem item = subMenuC0117r.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f1640i = new a(this.f930b, subMenuC0117r, m1484a);
        this.f1640i.m967a(z);
        this.f1640i.m962a();
        super.mo819a(subMenuC0117r);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private View m1484a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f934f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof InterfaceC0113n.a) && ((InterfaceC0113n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    public boolean m1499d() {
        if (!this.f1646o || m1503h() || this.f931c == null || this.f934f == null || this.f1641j != null || this.f931c.m909m().isEmpty()) {
            return false;
        }
        this.f1641j = new c(new e(this.f930b, this.f931c, this.f1638g, true));
        ((View) this.f934f).post(this.f1641j);
        return true;
    }

    /* renamed from: e */
    public boolean m1500e() {
        if (this.f1641j != null && this.f934f != null) {
            ((View) this.f934f).removeCallbacks(this.f1641j);
            this.f1641j = null;
            return true;
        }
        e eVar = this.f1639h;
        if (eVar != null) {
            eVar.m971d();
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m1501f() {
        return m1500e() | m1502g();
    }

    /* renamed from: g */
    public boolean m1502g() {
        if (this.f1640i == null) {
            return false;
        }
        this.f1640i.m971d();
        return true;
    }

    /* renamed from: h */
    public boolean m1503h() {
        return this.f1639h != null && this.f1639h.m973f();
    }

    /* renamed from: i */
    public boolean m1504i() {
        return this.f1641j != null || m1503h();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b, androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo821b() {
        int i;
        ArrayList<C0108i> arrayList;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        if (this.f931c != null) {
            ArrayList<C0108i> m906j = this.f931c.m906j();
            i = m906j.size();
            arrayList = m906j;
        } else {
            i = 0;
            arrayList = null;
        }
        int i7 = this.f1650s;
        int i8 = this.f1649r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f934f;
        int i9 = 0;
        int i10 = 0;
        boolean z2 = false;
        int i11 = 0;
        while (i11 < i) {
            C0108i c0108i = arrayList.get(i11);
            if (c0108i.m941l()) {
                i9++;
            } else if (c0108i.m940k()) {
                i10++;
            } else {
                z2 = true;
            }
            i11++;
            i7 = (this.f1654w && c0108i.isActionViewExpanded()) ? 0 : i7;
        }
        if (this.f1646o && (z2 || i9 + i10 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = this.f1656y;
        sparseBooleanArray.clear();
        int i13 = 0;
        if (!this.f1652u) {
            i2 = 0;
        } else {
            i13 = i8 / this.f1655x;
            i2 = ((i8 % this.f1655x) / i13) + this.f1655x;
        }
        int i14 = 0;
        int i15 = i13;
        int i16 = 0;
        while (i14 < i) {
            C0108i c0108i2 = arrayList.get(i14);
            if (c0108i2.m941l()) {
                View mo806a = mo806a(c0108i2, null, viewGroup);
                if (this.f1652u) {
                    i15 -= ActionMenuView.m1013a(mo806a, i2, i15, makeMeasureSpec, 0);
                } else {
                    mo806a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = mo806a.getMeasuredWidth();
                int i17 = i8 - i4;
                if (i16 != 0) {
                    i4 = i16;
                }
                int groupId = c0108i2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                c0108i2.m932d(true);
                i3 = i15;
                i8 = i17;
            } else if (c0108i2.m940k()) {
                int groupId2 = c0108i2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i8 > 0 && (!this.f1652u || i15 > 0);
                if (z4) {
                    View mo806a2 = mo806a(c0108i2, null, viewGroup);
                    if (this.f1652u) {
                        int m1013a = ActionMenuView.m1013a(mo806a2, i2, i15, makeMeasureSpec, 0);
                        i5 = i15 - m1013a;
                        z4 = m1013a == 0 ? false : z4;
                    } else {
                        mo806a2.measure(makeMeasureSpec, makeMeasureSpec);
                        i5 = i15;
                    }
                    int measuredWidth = mo806a2.getMeasuredWidth();
                    i8 -= measuredWidth;
                    if (i16 == 0) {
                        i16 = measuredWidth;
                    }
                    if (this.f1652u) {
                        z = z4 & (i8 >= 0);
                    } else {
                        z = z4 & (i8 + i16 > 0);
                    }
                } else {
                    z = z4;
                    i5 = i15;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i6 = i12;
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i18 = i12;
                    for (int i19 = 0; i19 < i14; i19++) {
                        C0108i c0108i3 = arrayList.get(i19);
                        if (c0108i3.getGroupId() == groupId2) {
                            if (c0108i3.m939j()) {
                                i18++;
                            }
                            c0108i3.m932d(false);
                        }
                    }
                    i6 = i18;
                } else {
                    i6 = i12;
                }
                if (z) {
                    i6--;
                }
                c0108i2.m932d(z);
                i3 = i5;
                i4 = i16;
                i12 = i6;
            } else {
                c0108i2.m932d(false);
                i3 = i15;
                i4 = i16;
            }
            i14++;
            i15 = i3;
            i16 = i4;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0101b, androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo812a(C0106g c0106g, boolean z) {
        m1501f();
        super.mo812a(c0106g, z);
    }

    @Override // androidx.core.p031f.AbstractC0283b.a
    /* renamed from: d */
    public void mo1498d(boolean z) {
        if (z) {
            super.mo819a((SubMenuC0117r) null);
        } else if (this.f931c != null) {
            this.f931c.m882a(false);
        }
    }

    /* renamed from: a */
    public void m1494a(ActionMenuView actionMenuView) {
        this.f934f = actionMenuView;
        actionMenuView.mo790a(this.f931c);
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$d */
    private class d extends C0206p implements ActionMenuView.InterfaceC0125a {
        public d(Context context) {
            super(context, null, C0059a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0187bb.m1463a(this, getContentDescription());
            setOnTouchListener(new AbstractViewOnAttachStateChangeListenerC0168aj(this) { // from class: androidx.appcompat.widget.c.d.1
                @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
                /* renamed from: a */
                public InterfaceC0115p mo787a() {
                    if (C0193c.this.f1639h == null) {
                        return null;
                    }
                    return C0193c.this.f1639h.m969b();
                }

                @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
                /* renamed from: b */
                public boolean mo788b() {
                    C0193c.this.m1499d();
                    return true;
                }

                @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
                /* renamed from: c */
                public boolean mo1285c() {
                    if (C0193c.this.f1641j != null) {
                        return false;
                    }
                    C0193c.this.m1500e();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                C0193c.this.m1499d();
            }
            return true;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0125a
        /* renamed from: c */
        public boolean mo785c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0125a
        /* renamed from: d */
        public boolean mo786d() {
            return false;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0315a.m2358a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$e */
    private class e extends C0111l {
        public e(Context context, C0106g c0106g, View view, boolean z) {
            super(context, c0106g, view, z, C0059a.a.actionOverflowMenuStyle);
            m963a(Gravity.END);
            m966a(C0193c.this.f1642k);
        }

        @Override // androidx.appcompat.view.menu.C0111l
        /* renamed from: e */
        protected void mo972e() {
            if (C0193c.this.f931c != null) {
                C0193c.this.f931c.close();
            }
            C0193c.this.f1639h = null;
            super.mo972e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$a */
    private class a extends C0111l {
        public a(Context context, SubMenuC0117r subMenuC0117r, View view) {
            super(context, subMenuC0117r, view, false, C0059a.a.actionOverflowMenuStyle);
            View view2;
            if (!((C0108i) subMenuC0117r.getItem()).m939j()) {
                if (C0193c.this.f1638g == null) {
                    view2 = (View) C0193c.this.f934f;
                } else {
                    view2 = C0193c.this.f1638g;
                }
                m964a(view2);
            }
            m966a(C0193c.this.f1642k);
        }

        @Override // androidx.appcompat.view.menu.C0111l
        /* renamed from: e */
        protected void mo972e() {
            C0193c.this.f1640i = null;
            C0193c.this.f1643l = 0;
            super.mo972e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$f */
    private class f implements InterfaceC0112m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public boolean mo559a(C0106g c0106g) {
            if (c0106g == C0193c.this.f931c) {
                return false;
            }
            C0193c.this.f1643l = ((SubMenuC0117r) c0106g).getItem().getItemId();
            InterfaceC0112m.a a2 = C0193c.this.m807a();
            return a2 != null ? a2.mo559a(c0106g) : false;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public void mo558a(C0106g c0106g, boolean z) {
            if (c0106g instanceof SubMenuC0117r) {
                c0106g.mo913q().m882a(false);
            }
            InterfaceC0112m.a a2 = C0193c.this.m807a();
            if (a2 != null) {
                a2.mo558a(c0106g, z);
            }
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c */
    private class c implements Runnable {

        /* renamed from: b */
        private e f1661b;

        public c(e eVar) {
            this.f1661b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0193c.this.f931c != null) {
                C0193c.this.f931c.m903g();
            }
            View view = (View) C0193c.this.f934f;
            if (view != null && view.getWindowToken() != null && this.f1661b.m970c()) {
                C0193c.this.f1639h = this.f1661b;
            }
            C0193c.this.f1641j = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.AbstractC0099b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.AbstractC0099b
        /* renamed from: a */
        public InterfaceC0115p mo789a() {
            if (C0193c.this.f1640i != null) {
                return C0193c.this.f1640i.m969b();
            }
            return null;
        }
    }
}
