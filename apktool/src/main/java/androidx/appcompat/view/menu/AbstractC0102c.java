package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;
import androidx.core.p024a.p025a.InterfaceSubMenuC0228c;
import androidx.p011a.C0042g;

/* compiled from: BaseMenuWrapper.java */
/* renamed from: androidx.appcompat.view.menu.c */
/* loaded from: classes.dex */
abstract class AbstractC0102c {

    /* renamed from: a */
    final Context f939a;

    /* renamed from: b */
    private C0042g<InterfaceMenuItemC0227b, MenuItem> f940b;

    /* renamed from: c */
    private C0042g<InterfaceSubMenuC0228c, SubMenu> f941c;

    AbstractC0102c(Context context) {
        this.f939a = context;
    }

    /* renamed from: a */
    final MenuItem m823a(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC0227b)) {
            return menuItem;
        }
        InterfaceMenuItemC0227b interfaceMenuItemC0227b = (InterfaceMenuItemC0227b) menuItem;
        if (this.f940b == null) {
            this.f940b = new C0042g<>();
        }
        MenuItem menuItem2 = this.f940b.get(menuItem);
        if (menuItem2 == null) {
            MenuItemC0109j menuItemC0109j = new MenuItemC0109j(this.f939a, interfaceMenuItemC0227b);
            this.f940b.put(interfaceMenuItemC0227b, menuItemC0109j);
            return menuItemC0109j;
        }
        return menuItem2;
    }

    /* renamed from: a */
    final SubMenu m824a(SubMenu subMenu) {
        if (!(subMenu instanceof InterfaceSubMenuC0228c)) {
            return subMenu;
        }
        InterfaceSubMenuC0228c interfaceSubMenuC0228c = (InterfaceSubMenuC0228c) subMenu;
        if (this.f941c == null) {
            this.f941c = new C0042g<>();
        }
        SubMenu subMenu2 = this.f941c.get(interfaceSubMenuC0228c);
        if (subMenu2 == null) {
            SubMenuC0118s subMenuC0118s = new SubMenuC0118s(this.f939a, interfaceSubMenuC0228c);
            this.f941c.put(interfaceSubMenuC0228c, subMenuC0118s);
            return subMenuC0118s;
        }
        return subMenu2;
    }

    /* renamed from: a */
    final void m825a() {
        if (this.f940b != null) {
            this.f940b.clear();
        }
        if (this.f941c != null) {
            this.f941c.clear();
        }
    }

    /* renamed from: a */
    final void m826a(int i) {
        if (this.f940b != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.f940b.size()) {
                    if (this.f940b.m271b(i3).getGroupId() == i) {
                        this.f940b.m273d(i3);
                        i3--;
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    final void m827b(int i) {
        if (this.f940b != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.f940b.size()) {
                    if (this.f940b.m271b(i3).getItemId() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.f940b.m273d(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
