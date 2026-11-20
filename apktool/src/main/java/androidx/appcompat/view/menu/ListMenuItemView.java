package androidx.appcompat.view.menu;

import android.C0012R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.appcompat.widget.C0184az;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, InterfaceC0113n.a {

    /* renamed from: a */
    private C0108i f892a;

    /* renamed from: b */
    private ImageView f893b;

    /* renamed from: c */
    private RadioButton f894c;

    /* renamed from: d */
    private TextView f895d;

    /* renamed from: e */
    private CheckBox f896e;

    /* renamed from: f */
    private TextView f897f;

    /* renamed from: g */
    private ImageView f898g;

    /* renamed from: h */
    private ImageView f899h;

    /* renamed from: i */
    private LinearLayout f900i;

    /* renamed from: j */
    private Drawable f901j;

    /* renamed from: k */
    private int f902k;

    /* renamed from: l */
    private Context f903l;

    /* renamed from: m */
    private boolean f904m;

    /* renamed from: n */
    private Drawable f905n;

    /* renamed from: o */
    private boolean f906o;

    /* renamed from: p */
    private LayoutInflater f907p;

    /* renamed from: q */
    private boolean f908q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0184az m1432a = C0184az.m1432a(getContext(), attributeSet, C0059a.j.MenuView, i, 0);
        this.f901j = m1432a.m1437a(C0059a.j.MenuView_android_itemBackground);
        this.f902k = m1432a.m1450g(C0059a.j.MenuView_android_itemTextAppearance, -1);
        this.f904m = m1432a.m1438a(C0059a.j.MenuView_preserveIconSpacing, false);
        this.f903l = context;
        this.f905n = m1432a.m1437a(C0059a.j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{C0012R.attr.divider}, C0059a.a.dropDownListViewStyle, 0);
        this.f906o = obtainStyledAttributes.hasValue(0);
        m1432a.m1441b();
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        C0308x.m2233a(this, this.f901j);
        this.f895d = (TextView) findViewById(C0059a.f.title);
        if (this.f902k != -1) {
            this.f895d.setTextAppearance(this.f903l, this.f902k);
        }
        this.f897f = (TextView) findViewById(C0059a.f.shortcut);
        this.f898g = (ImageView) findViewById(C0059a.f.submenuarrow);
        if (this.f898g != null) {
            this.f898g.setImageDrawable(this.f905n);
        }
        this.f899h = (ImageView) findViewById(C0059a.f.group_divider);
        this.f900i = (LinearLayout) findViewById(C0059a.f.content);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    /* renamed from: a */
    public void mo782a(C0108i c0108i, int i) {
        this.f892a = c0108i;
        setVisibility(c0108i.isVisible() ? 0 : 8);
        setTitle(c0108i.m922a((InterfaceC0113n.a) this));
        setCheckable(c0108i.isCheckable());
        m797a(c0108i.m935f(), c0108i.m931d());
        setIcon(c0108i.getIcon());
        setEnabled(c0108i.isEnabled());
        setSubMenuArrowVisible(c0108i.hasSubMenu());
        setContentDescription(c0108i.getContentDescription());
    }

    /* renamed from: a */
    private void m792a(View view) {
        m793a(view, -1);
    }

    /* renamed from: a */
    private void m793a(View view, int i) {
        if (this.f900i != null) {
            this.f900i.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f908q = z;
        this.f904m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f895d.setText(charSequence);
            if (this.f895d.getVisibility() != 0) {
                this.f895d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f895d.getVisibility() != 8) {
            this.f895d.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    public C0108i getItemData() {
        return this.f892a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (z || this.f894c != null || this.f896e != null) {
            if (this.f892a.m936g()) {
                if (this.f894c == null) {
                    m795c();
                }
                compoundButton = this.f894c;
                view = this.f896e;
            } else {
                if (this.f896e == null) {
                    m796d();
                }
                compoundButton = this.f896e;
                view = this.f894c;
            }
            if (z) {
                compoundButton.setChecked(this.f892a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f896e != null) {
                this.f896e.setVisibility(8);
            }
            if (this.f894c != null) {
                this.f894c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        Checkable checkable;
        if (this.f892a.m936g()) {
            if (this.f894c == null) {
                m795c();
            }
            checkable = this.f894c;
        } else {
            if (this.f896e == null) {
                m796d();
            }
            checkable = this.f896e;
        }
        checkable.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f898g != null) {
            this.f898g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void m797a(boolean z, char c2) {
        int i = (z && this.f892a.m935f()) ? 0 : 8;
        if (i == 0) {
            this.f897f.setText(this.f892a.m933e());
        }
        if (this.f897f.getVisibility() != i) {
            this.f897f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f892a.m938i() || this.f908q;
        if (z || this.f904m) {
            if (this.f893b != null || drawable != null || this.f904m) {
                if (this.f893b == null) {
                    m794b();
                }
                if (drawable != null || this.f904m) {
                    ImageView imageView = this.f893b;
                    if (!z) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.f893b.getVisibility() != 0) {
                        this.f893b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f893b.setVisibility(8);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f893b != null && this.f904m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f893b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: b */
    private void m794b() {
        this.f893b = (ImageView) getInflater().inflate(C0059a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        m793a(this.f893b, 0);
    }

    /* renamed from: c */
    private void m795c() {
        this.f894c = (RadioButton) getInflater().inflate(C0059a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        m792a(this.f894c);
    }

    /* renamed from: d */
    private void m796d() {
        this.f896e = (CheckBox) getInflater().inflate(C0059a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        m792a(this.f896e);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0113n.a
    /* renamed from: a */
    public boolean mo783a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f907p == null) {
            this.f907p = LayoutInflater.from(getContext());
        }
        return this.f907p;
    }

    public void setGroupDividerEnabled(boolean z) {
        if (this.f899h != null) {
            this.f899h.setVisibility((this.f906o || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.f899h != null && this.f899h.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f899h.getLayoutParams();
            rect.top = layoutParams.bottomMargin + this.f899h.getHeight() + layoutParams.topMargin + rect.top;
        }
    }
}
