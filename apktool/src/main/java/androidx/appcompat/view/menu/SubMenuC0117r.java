package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.C0106g;

/* compiled from: SubMenuBuilder.java */
/* renamed from: androidx.appcompat.view.menu.r */
/* loaded from: classes.dex */
public class SubMenuC0117r extends C0106g implements SubMenu {

    /* renamed from: d */
    private C0106g f1108d;

    /* renamed from: e */
    private C0108i f1109e;

    public SubMenuC0117r(Context context, C0106g c0106g, C0108i c0108i) {
        super(context);
        this.f1108d = c0106g;
        this.f1109e = c0108i;
    }

    @Override // androidx.appcompat.view.menu.C0106g, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1108d.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: c */
    public boolean mo894c() {
        return this.f1108d.mo894c();
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: d */
    public boolean mo898d() {
        return this.f1108d.mo898d();
    }

    /* renamed from: t */
    public Menu m975t() {
        return this.f1108d;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f1109e;
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: a */
    public void mo877a(C0106g.a aVar) {
        this.f1108d.mo877a(aVar);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: q */
    public C0106g mo913q() {
        return this.f1108d.mo913q();
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: a */
    boolean mo885a(C0106g c0106g, MenuItem menuItem) {
        return super.mo885a(c0106g, menuItem) || this.f1108d.mo885a(c0106g, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1109e.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f1109e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m870a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m901e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m872a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m896d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m871a(view);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: c */
    public boolean mo895c(C0108i c0108i) {
        return this.f1108d.mo895c(c0108i);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: d */
    public boolean mo899d(C0108i c0108i) {
        return this.f1108d.mo899d(c0108i);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: a */
    public String mo874a() {
        int itemId = this.f1109e != null ? this.f1109e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo874a() + ":" + itemId;
    }

    @Override // androidx.appcompat.view.menu.C0106g, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f1108d.setGroupDividerEnabled(z);
    }

    @Override // androidx.appcompat.view.menu.C0106g
    /* renamed from: b */
    public boolean mo891b() {
        return this.f1108d.mo891b();
    }
}
