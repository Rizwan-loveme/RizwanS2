package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.InterfaceC0091c;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;
import androidx.core.p031f.AbstractC0283b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS.java */
/* renamed from: androidx.appcompat.view.menu.j */
/* loaded from: classes.dex */
public class MenuItemC0109j extends AbstractC0102c implements MenuItem {

    /* renamed from: b */
    private final InterfaceMenuItemC0227b f1059b;

    /* renamed from: c */
    private Method f1060c;

    public MenuItemC0109j(Context context, InterfaceMenuItemC0227b interfaceMenuItemC0227b) {
        super(context);
        if (interfaceMenuItemC0227b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1059b = interfaceMenuItemC0227b;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1059b.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1059b.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1059b.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1059b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f1059b.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1059b.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1059b.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1059b.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1059b.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1059b.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1059b.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1059b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1059b.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1059b.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f1059b.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f1059b.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f1059b.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1059b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1059b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f1059b.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f1059b.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1059b.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1059b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f1059b.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1059b.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f1059b.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1059b.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f1059b.setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1059b.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1059b.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1059b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1059b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m824a(this.f1059b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1059b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1059b.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f1059b.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f1059b.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f1059b.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f1059b.setActionView(i);
        View actionView = this.f1059b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1059b.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1059b.getActionView();
        if (actionView instanceof c) {
            return ((c) actionView).m954c();
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        AbstractC0283b aVar;
        if (Build.VERSION.SDK_INT >= 16) {
            aVar = new b(this.f939a, actionProvider);
        } else {
            aVar = new a(this.f939a, actionProvider);
        }
        InterfaceMenuItemC0227b interfaceMenuItemC0227b = this.f1059b;
        if (actionProvider == null) {
            aVar = null;
        }
        interfaceMenuItemC0227b.mo801a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0283b mo803a = this.f1059b.mo803a();
        if (mo803a instanceof a) {
            return ((a) mo803a).f1061a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1059b.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1059b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1059b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1059b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1059b.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1059b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1059b.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1059b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1059b.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1059b.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1059b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1059b.getIconTintMode();
    }

    /* renamed from: a */
    public void m945a(boolean z) {
        try {
            if (this.f1060c == null) {
                this.f1060c = this.f1059b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1060c.invoke(this.f1059b, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.m191w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.j$e */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b */
        private final MenuItem.OnMenuItemClickListener f1069b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1069b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1069b.onMenuItemClick(MenuItemC0109j.this.m823a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.j$d */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b */
        private final MenuItem.OnActionExpandListener f1067b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1067b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1067b.onMenuItemActionExpand(MenuItemC0109j.this.m823a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1067b.onMenuItemActionCollapse(MenuItemC0109j.this.m823a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.j$a */
    private class a extends AbstractC0283b {

        /* renamed from: a */
        final ActionProvider f1061a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1061a = actionProvider;
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: a */
        public View mo946a() {
            return this.f1061a.onCreateActionView();
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: b */
        public boolean mo948b() {
            return this.f1061a.onPerformDefaultAction();
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: c */
        public boolean mo949c() {
            return this.f1061a.hasSubMenu();
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: a */
        public void mo947a(SubMenu subMenu) {
            this.f1061a.onPrepareSubMenu(MenuItemC0109j.this.m824a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.j$b */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d */
        private AbstractC0283b.b f1064d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: a */
        public View mo950a(MenuItem menuItem) {
            return this.f1061a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: d */
        public boolean mo952d() {
            return this.f1061a.overridesItemVisibility();
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: e */
        public boolean mo953e() {
            return this.f1061a.isVisible();
        }

        @Override // androidx.core.p031f.AbstractC0283b
        /* renamed from: a */
        public void mo951a(AbstractC0283b.b bVar) {
            this.f1064d = bVar;
            ActionProvider actionProvider = this.f1061a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1064d != null) {
                this.f1064d.mo944a(z);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.j$c */
    static class c extends FrameLayout implements InterfaceC0091c {

        /* renamed from: a */
        final CollapsibleActionView f1065a;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f1065a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.InterfaceC0091c
        /* renamed from: a */
        public void mo749a() {
            this.f1065a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.InterfaceC0091c
        /* renamed from: b */
        public void mo750b() {
            this.f1065a.onActionViewCollapsed();
        }

        /* renamed from: c */
        View m954c() {
            return (View) this.f1065a;
        }
    }
}
