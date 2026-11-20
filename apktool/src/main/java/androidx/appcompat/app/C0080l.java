package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AbstractC0069a;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.widget.InterfaceC0164af;
import androidx.core.p031f.C0308x;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* renamed from: androidx.appcompat.app.l */
/* loaded from: classes.dex */
class C0080l extends AbstractC0069a {

    /* renamed from: a */
    InterfaceC0164af f673a;

    /* renamed from: b */
    Window.Callback f674b;

    /* renamed from: c */
    private boolean f675c;

    /* renamed from: d */
    private boolean f676d;

    /* renamed from: e */
    private ArrayList<AbstractC0069a.b> f677e;

    /* renamed from: f */
    private final Runnable f678f;

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo389a(View view) {
        m621a(view, new AbstractC0069a.a(-2, -2));
    }

    /* renamed from: a */
    public void m621a(View view, AbstractC0069a.a aVar) {
        if (view != null) {
            view.setLayoutParams(aVar);
        }
        this.f673a.mo1233a(view);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo391a(boolean z) {
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo386a(float f2) {
        C0308x.m2226a(this.f673a.mo1228a(), f2);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: d */
    public Context mo399d() {
        return this.f673a.mo1239b();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: c */
    public void mo398c(boolean z) {
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: d */
    public void mo400d(boolean z) {
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo388a(Configuration configuration) {
        super.mo388a(configuration);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public void mo390a(CharSequence charSequence) {
        this.f673a.mo1241b(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: b */
    public void mo395b(CharSequence charSequence) {
        this.f673a.mo1237a(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public void mo387a(int i) {
        m620a(i, -1);
    }

    /* renamed from: a */
    public void m620a(int i, int i2) {
        this.f673a.mo1243c((this.f673a.mo1257o() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public View mo384a() {
        return this.f673a.mo1259q();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: b */
    public int mo394b() {
        return this.f673a.mo1257o();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: c */
    public void mo397c() {
        this.f673a.mo1246d(8);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: e */
    public boolean mo402e() {
        return this.f673a.mo1253k();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: f */
    public boolean mo403f() {
        return this.f673a.mo1254l();
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: g */
    public boolean mo404g() {
        this.f673a.mo1228a().removeCallbacks(this.f678f);
        C0308x.m2239a(this.f673a.mo1228a(), this.f678f);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: h */
    public boolean mo405h() {
        if (!this.f673a.mo1244c()) {
            return false;
        }
        this.f673a.mo1245d();
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public boolean mo393a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo402e();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: a */
    public boolean mo392a(int i, KeyEvent keyEvent) {
        Menu m619j = m619j();
        if (m619j == null) {
            return false;
        }
        m619j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return m619j.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: i */
    void mo406i() {
        this.f673a.mo1228a().removeCallbacks(this.f678f);
    }

    @Override // androidx.appcompat.app.AbstractC0069a
    /* renamed from: e */
    public void mo401e(boolean z) {
        if (z != this.f676d) {
            this.f676d = z;
            int size = this.f677e.size();
            for (int i = 0; i < size; i++) {
                this.f677e.get(i).m407a(z);
            }
        }
    }

    /* renamed from: j */
    private Menu m619j() {
        if (!this.f675c) {
            this.f673a.mo1235a(new a(), new b());
            this.f675c = true;
        }
        return this.f673a.mo1260r();
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: androidx.appcompat.app.l$a */
    private final class a implements InterfaceC0112m.a {

        /* renamed from: b */
        private boolean f680b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public boolean mo559a(C0106g c0106g) {
            if (C0080l.this.f674b == null) {
                return false;
            }
            C0080l.this.f674b.onMenuOpened(108, c0106g);
            return true;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
        /* renamed from: a */
        public void mo558a(C0106g c0106g, boolean z) {
            if (!this.f680b) {
                this.f680b = true;
                C0080l.this.f673a.mo1256n();
                if (C0080l.this.f674b != null) {
                    C0080l.this.f674b.onPanelClosed(108, c0106g);
                }
                this.f680b = false;
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: androidx.appcompat.app.l$b */
    private final class b implements C0106g.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.C0106g.a
        /* renamed from: a */
        public void mo529a(C0106g c0106g) {
            if (C0080l.this.f674b != null) {
                if (C0080l.this.f673a.mo1251i()) {
                    C0080l.this.f674b.onPanelClosed(108, c0106g);
                } else if (C0080l.this.f674b.onPreparePanel(0, null, c0106g)) {
                    C0080l.this.f674b.onMenuOpened(108, c0106g);
                }
            }
        }
    }
}
