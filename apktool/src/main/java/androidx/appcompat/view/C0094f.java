package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.menu.MenuC0114o;
import androidx.appcompat.view.menu.MenuItemC0109j;
import androidx.core.p024a.p025a.InterfaceMenuC0226a;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;
import androidx.p011a.C0042g;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* renamed from: androidx.appcompat.view.f */
/* loaded from: classes.dex */
public class C0094f extends ActionMode {

    /* renamed from: a */
    final Context f820a;

    /* renamed from: b */
    final AbstractC0090b f821b;

    public C0094f(Context context, AbstractC0090b abstractC0090b) {
        this.f820a = context;
        this.f821b = abstractC0090b;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f821b.m747j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f821b.m746a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f821b.mo659b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f821b.mo655a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f821b.mo661d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f821b.mo660c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC0114o(this.f820a, (InterfaceMenuC0226a) this.f821b.mo657b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f821b.mo663f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f821b.mo653a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f821b.mo664g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f821b.mo658b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f821b.mo666i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f821b.mo654a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f821b.mo652a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f821b.m748k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f821b.mo656a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f821b.mo665h();
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: androidx.appcompat.view.f$a */
    public static class a implements AbstractC0090b.a {

        /* renamed from: a */
        final ActionMode.Callback f822a;

        /* renamed from: b */
        final Context f823b;

        /* renamed from: c */
        final ArrayList<C0094f> f824c = new ArrayList<>();

        /* renamed from: d */
        final C0042g<Menu, Menu> f825d = new C0042g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f823b = context;
            this.f822a = callback;
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public boolean mo561a(AbstractC0090b abstractC0090b, Menu menu) {
            return this.f822a.onCreateActionMode(m757b(abstractC0090b), m756a(menu));
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: b */
        public boolean mo563b(AbstractC0090b abstractC0090b, Menu menu) {
            return this.f822a.onPrepareActionMode(m757b(abstractC0090b), m756a(menu));
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public boolean mo562a(AbstractC0090b abstractC0090b, MenuItem menuItem) {
            return this.f822a.onActionItemClicked(m757b(abstractC0090b), new MenuItemC0109j(this.f823b, (InterfaceMenuItemC0227b) menuItem));
        }

        @Override // androidx.appcompat.view.AbstractC0090b.a
        /* renamed from: a */
        public void mo560a(AbstractC0090b abstractC0090b) {
            this.f822a.onDestroyActionMode(m757b(abstractC0090b));
        }

        /* renamed from: a */
        private Menu m756a(Menu menu) {
            Menu menu2 = this.f825d.get(menu);
            if (menu2 == null) {
                MenuC0114o menuC0114o = new MenuC0114o(this.f823b, (InterfaceMenuC0226a) menu);
                this.f825d.put(menu, menuC0114o);
                return menuC0114o;
            }
            return menu2;
        }

        /* renamed from: b */
        public ActionMode m757b(AbstractC0090b abstractC0090b) {
            int size = this.f824c.size();
            for (int i = 0; i < size; i++) {
                C0094f c0094f = this.f824c.get(i);
                if (c0094f != null && c0094f.f821b == abstractC0090b) {
                    return c0094f;
                }
            }
            C0094f c0094f2 = new C0094f(this.f823b, abstractC0090b);
            this.f824c.add(c0094f2);
            return c0094f2;
        }
    }
}
