package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.p024a.p025a.InterfaceSubMenuC0228c;

/* compiled from: SubMenuWrapperICS.java */
/* renamed from: androidx.appcompat.view.menu.s */
/* loaded from: classes.dex */
class SubMenuC0118s extends MenuC0114o implements SubMenu {

    /* renamed from: b */
    private final InterfaceSubMenuC0228c f1110b;

    SubMenuC0118s(Context context, InterfaceSubMenuC0228c interfaceSubMenuC0228c) {
        super(context, interfaceSubMenuC0228c);
        this.f1110b = interfaceSubMenuC0228c;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        this.f1110b.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1110b.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        this.f1110b.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1110b.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1110b.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1110b.clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f1110b.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1110b.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m823a(this.f1110b.getItem());
    }
}
