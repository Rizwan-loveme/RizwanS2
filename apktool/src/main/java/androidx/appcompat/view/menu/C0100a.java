package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.C0255a;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;
import androidx.core.p031f.AbstractC0283b;

/* compiled from: ActionMenuItem.java */
/* renamed from: androidx.appcompat.view.menu.a */
/* loaded from: classes.dex */
public class C0100a implements InterfaceMenuItemC0227b {

    /* renamed from: a */
    private final int f909a;

    /* renamed from: b */
    private final int f910b;

    /* renamed from: c */
    private final int f911c;

    /* renamed from: d */
    private CharSequence f912d;

    /* renamed from: e */
    private CharSequence f913e;

    /* renamed from: f */
    private Intent f914f;

    /* renamed from: g */
    private char f915g;

    /* renamed from: i */
    private char f917i;

    /* renamed from: k */
    private Drawable f919k;

    /* renamed from: l */
    private Context f920l;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f921m;

    /* renamed from: n */
    private CharSequence f922n;

    /* renamed from: o */
    private CharSequence f923o;

    /* renamed from: h */
    private int f916h = 4096;

    /* renamed from: j */
    private int f918j = 4096;

    /* renamed from: p */
    private ColorStateList f924p = null;

    /* renamed from: q */
    private PorterDuff.Mode f925q = null;

    /* renamed from: r */
    private boolean f926r = false;

    /* renamed from: s */
    private boolean f927s = false;

    /* renamed from: t */
    private int f928t = 16;

    public C0100a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f920l = context;
        this.f909a = i2;
        this.f910b = i;
        this.f911c = i4;
        this.f912d = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f917i;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f918j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f910b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f919k;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f914f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f909a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f915g;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f916h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f911c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f912d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f913e != null ? this.f913e : this.f912d;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f928t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f928t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f928t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f928t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f917i = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f917i = Character.toLowerCase(c2);
        this.f918j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f928t = (z ? 1 : 0) | (this.f928t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f928t = (z ? 2 : 0) | (this.f928t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f928t = (z ? 16 : 0) | (this.f928t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f919k = drawable;
        m798b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f919k = C0255a.m1847a(this.f920l, i);
        m798b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f914f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f915g = c2;
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f915g = c2;
        this.f916h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f921m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f915g = c2;
        this.f917i = Character.toLowerCase(c3);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f915g = c2;
        this.f916h = KeyEvent.normalizeMetaState(i);
        this.f917i = Character.toLowerCase(c3);
        this.f918j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f912d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f912d = this.f920l.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f913e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f928t = (z ? 0 : 8) | (this.f928t & 8);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b
    /* renamed from: a */
    public AbstractC0283b mo803a() {
        return null;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b
    /* renamed from: a */
    public InterfaceMenuItemC0227b mo801a(AbstractC0283b abstractC0283b) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a */
    public InterfaceMenuItemC0227b setContentDescription(CharSequence charSequence) {
        this.f922n = charSequence;
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f922n;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: b */
    public InterfaceMenuItemC0227b setTooltipText(CharSequence charSequence) {
        this.f923o = charSequence;
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f923o;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f924p = colorStateList;
        this.f926r = true;
        m798b();
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f924p;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f925q = mode;
        this.f927s = true;
        m798b();
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f925q;
    }

    /* renamed from: b */
    private void m798b() {
        if (this.f919k != null) {
            if (this.f926r || this.f927s) {
                this.f919k = C0315a.m2369f(this.f919k);
                this.f919k = this.f919k.mutate();
                if (this.f926r) {
                    C0315a.m2359a(this.f919k, this.f924p);
                }
                if (this.f927s) {
                    C0315a.m2362a(this.f919k, this.f925q);
                }
            }
        }
    }
}
