package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.view.menu.C0100a;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0280ad;
import androidx.core.p031f.C0308x;

/* compiled from: ToolbarWidgetWrapper.java */
/* renamed from: androidx.appcompat.widget.ba */
/* loaded from: classes.dex */
public class C0186ba implements InterfaceC0164af {

    /* renamed from: a */
    Toolbar f1593a;

    /* renamed from: b */
    CharSequence f1594b;

    /* renamed from: c */
    Window.Callback f1595c;

    /* renamed from: d */
    boolean f1596d;

    /* renamed from: e */
    private int f1597e;

    /* renamed from: f */
    private View f1598f;

    /* renamed from: g */
    private View f1599g;

    /* renamed from: h */
    private Drawable f1600h;

    /* renamed from: i */
    private Drawable f1601i;

    /* renamed from: j */
    private Drawable f1602j;

    /* renamed from: k */
    private boolean f1603k;

    /* renamed from: l */
    private CharSequence f1604l;

    /* renamed from: m */
    private CharSequence f1605m;

    /* renamed from: n */
    private C0193c f1606n;

    /* renamed from: o */
    private int f1607o;

    /* renamed from: p */
    private int f1608p;

    /* renamed from: q */
    private Drawable f1609q;

    public C0186ba(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0059a.h.abc_action_bar_up_description, C0059a.e.abc_ic_ab_back_material);
    }

    public C0186ba(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1607o = 0;
        this.f1608p = 0;
        this.f1593a = toolbar;
        this.f1594b = toolbar.getTitle();
        this.f1604l = toolbar.getSubtitle();
        this.f1603k = this.f1594b != null;
        this.f1602j = toolbar.getNavigationIcon();
        C0184az m1432a = C0184az.m1432a(toolbar.getContext(), null, C0059a.j.ActionBar, C0059a.a.actionBarStyle, 0);
        this.f1609q = m1432a.m1437a(C0059a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence m1443c = m1432a.m1443c(C0059a.j.ActionBar_title);
            if (!TextUtils.isEmpty(m1443c)) {
                mo1241b(m1443c);
            }
            CharSequence m1443c2 = m1432a.m1443c(C0059a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(m1443c2)) {
                m1459c(m1443c2);
            }
            Drawable m1437a = m1432a.m1437a(C0059a.j.ActionBar_logo);
            if (m1437a != null) {
                m1457b(m1437a);
            }
            Drawable m1437a2 = m1432a.m1437a(C0059a.j.ActionBar_icon);
            if (m1437a2 != null) {
                mo1231a(m1437a2);
            }
            if (this.f1602j == null && this.f1609q != null) {
                m1458c(this.f1609q);
            }
            mo1243c(m1432a.m1434a(C0059a.j.ActionBar_displayOptions, 0));
            int m1450g = m1432a.m1450g(C0059a.j.ActionBar_customNavigationLayout, 0);
            if (m1450g != 0) {
                mo1233a(LayoutInflater.from(this.f1593a.getContext()).inflate(m1450g, (ViewGroup) this.f1593a, false));
                mo1243c(this.f1597e | 16);
            }
            int m1448f = m1432a.m1448f(C0059a.j.ActionBar_height, 0);
            if (m1448f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1593a.getLayoutParams();
                layoutParams.height = m1448f;
                this.f1593a.setLayoutParams(layoutParams);
            }
            int m1444d = m1432a.m1444d(C0059a.j.ActionBar_contentInsetStart, -1);
            int m1444d2 = m1432a.m1444d(C0059a.j.ActionBar_contentInsetEnd, -1);
            if (m1444d >= 0 || m1444d2 >= 0) {
                this.f1593a.m1131a(Math.max(m1444d, 0), Math.max(m1444d2, 0));
            }
            int m1450g2 = m1432a.m1450g(C0059a.j.ActionBar_titleTextStyle, 0);
            if (m1450g2 != 0) {
                this.f1593a.m1132a(this.f1593a.getContext(), m1450g2);
            }
            int m1450g3 = m1432a.m1450g(C0059a.j.ActionBar_subtitleTextStyle, 0);
            if (m1450g3 != 0) {
                this.f1593a.m1137b(this.f1593a.getContext(), m1450g3);
            }
            int m1450g4 = m1432a.m1450g(C0059a.j.ActionBar_popupTheme, 0);
            if (m1450g4 != 0) {
                this.f1593a.setPopupTheme(m1450g4);
            }
        } else {
            this.f1597e = m1453s();
        }
        m1432a.m1441b();
        m1461e(i);
        this.f1605m = this.f1593a.getNavigationContentDescription();
        this.f1593a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ba.1

            /* renamed from: a */
            final C0100a f1610a;

            {
                this.f1610a = new C0100a(C0186ba.this.f1593a.getContext(), 0, C0012R.id.home, 0, 0, C0186ba.this.f1594b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0186ba.this.f1595c != null && C0186ba.this.f1596d) {
                    C0186ba.this.f1595c.onMenuItemSelected(0, this.f1610a);
                }
            }
        });
    }

    /* renamed from: e */
    public void m1461e(int i) {
        if (i != this.f1608p) {
            this.f1608p = i;
            if (TextUtils.isEmpty(this.f1593a.getNavigationContentDescription())) {
                m1462f(this.f1608p);
            }
        }
    }

    /* renamed from: s */
    private int m1453s() {
        if (this.f1593a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1609q = this.f1593a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public ViewGroup mo1228a() {
        return this.f1593a;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: b */
    public Context mo1239b() {
        return this.f1593a.getContext();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: c */
    public boolean mo1244c() {
        return this.f1593a.m1143g();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: d */
    public void mo1245d() {
        this.f1593a.m1144h();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1234a(Window.Callback callback) {
        this.f1595c = callback;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1237a(CharSequence charSequence) {
        if (!this.f1603k) {
            m1452e(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: e */
    public CharSequence mo1247e() {
        return this.f1593a.getTitle();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: b */
    public void mo1241b(CharSequence charSequence) {
        this.f1603k = true;
        m1452e(charSequence);
    }

    /* renamed from: e */
    private void m1452e(CharSequence charSequence) {
        this.f1594b = charSequence;
        if ((this.f1597e & 8) != 0) {
            this.f1593a.setTitle(charSequence);
        }
    }

    /* renamed from: c */
    public void m1459c(CharSequence charSequence) {
        this.f1604l = charSequence;
        if ((this.f1597e & 8) != 0) {
            this.f1593a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: f */
    public void mo1248f() {
        Log.m186i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: g */
    public void mo1249g() {
        Log.m186i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1230a(int i) {
        mo1231a(i != 0 ? C0060a.m348b(mo1239b(), i) : null);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1231a(Drawable drawable) {
        this.f1600h = drawable;
        m1454t();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: b */
    public void mo1240b(int i) {
        m1457b(i != 0 ? C0060a.m348b(mo1239b(), i) : null);
    }

    /* renamed from: b */
    public void m1457b(Drawable drawable) {
        this.f1601i = drawable;
        m1454t();
    }

    /* renamed from: t */
    private void m1454t() {
        Drawable drawable = null;
        if ((this.f1597e & 2) != 0) {
            if ((this.f1597e & 1) != 0) {
                drawable = this.f1601i != null ? this.f1601i : this.f1600h;
            } else {
                drawable = this.f1600h;
            }
        }
        this.f1593a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: h */
    public boolean mo1250h() {
        return this.f1593a.m1135a();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: i */
    public boolean mo1251i() {
        return this.f1593a.m1138b();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: j */
    public boolean mo1252j() {
        return this.f1593a.m1139c();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: k */
    public boolean mo1253k() {
        return this.f1593a.m1140d();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: l */
    public boolean mo1254l() {
        return this.f1593a.m1141e();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: m */
    public void mo1255m() {
        this.f1596d = true;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1232a(Menu menu, InterfaceC0112m.a aVar) {
        if (this.f1606n == null) {
            this.f1606n = new C0193c(this.f1593a.getContext());
            this.f1606n.m809a(C0059a.f.action_menu_presenter);
        }
        this.f1606n.mo814a(aVar);
        this.f1593a.m1133a((C0106g) menu, this.f1606n);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: n */
    public void mo1256n() {
        this.f1593a.m1142f();
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: o */
    public int mo1257o() {
        return this.f1597e;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: c */
    public void mo1243c(int i) {
        int i2 = this.f1597e ^ i;
        this.f1597e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1456v();
                }
                m1455u();
            }
            if ((i2 & 3) != 0) {
                m1454t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1593a.setTitle(this.f1594b);
                    this.f1593a.setSubtitle(this.f1604l);
                } else {
                    this.f1593a.setTitle((CharSequence) null);
                    this.f1593a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f1599g != null) {
                if ((i & 16) != 0) {
                    this.f1593a.addView(this.f1599g);
                } else {
                    this.f1593a.removeView(this.f1599g);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1236a(C0177as c0177as) {
        if (this.f1598f != null && this.f1598f.getParent() == this.f1593a) {
            this.f1593a.removeView(this.f1598f);
        }
        this.f1598f = c0177as;
        if (c0177as != null && this.f1607o == 2) {
            this.f1593a.addView(this.f1598f, 0);
            Toolbar.C0154b c0154b = (Toolbar.C0154b) this.f1598f.getLayoutParams();
            c0154b.width = -2;
            c0154b.height = -2;
            c0154b.f544a = 8388691;
            c0177as.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1238a(boolean z) {
        this.f1593a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: b */
    public void mo1242b(boolean z) {
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: p */
    public int mo1258p() {
        return this.f1607o;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1233a(View view) {
        if (this.f1599g != null && (this.f1597e & 16) != 0) {
            this.f1593a.removeView(this.f1599g);
        }
        this.f1599g = view;
        if (view != null && (this.f1597e & 16) != 0) {
            this.f1593a.addView(this.f1599g);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: q */
    public View mo1259q() {
        return this.f1599g;
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public C0278ab mo1229a(final int i, long j) {
        return C0308x.m2263j(this.f1593a).m2058a(i == 0 ? 1.0f : 0.0f).m2059a(j).m2061a(new C0280ad() { // from class: androidx.appcompat.widget.ba.2

            /* renamed from: c */
            private boolean f1614c = false;

            @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
            /* renamed from: a */
            public void mo556a(View view) {
                C0186ba.this.f1593a.setVisibility(0);
            }

            @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
            /* renamed from: b */
            public void mo557b(View view) {
                if (!this.f1614c) {
                    C0186ba.this.f1593a.setVisibility(i);
                }
            }

            @Override // androidx.core.p031f.C0280ad, androidx.core.p031f.InterfaceC0279ac
            /* renamed from: c */
            public void mo1162c(View view) {
                this.f1614c = true;
            }
        });
    }

    /* renamed from: c */
    public void m1458c(Drawable drawable) {
        this.f1602j = drawable;
        m1455u();
    }

    /* renamed from: u */
    private void m1455u() {
        if ((this.f1597e & 4) != 0) {
            this.f1593a.setNavigationIcon(this.f1602j != null ? this.f1602j : this.f1609q);
        } else {
            this.f1593a.setNavigationIcon((Drawable) null);
        }
    }

    /* renamed from: d */
    public void m1460d(CharSequence charSequence) {
        this.f1605m = charSequence;
        m1456v();
    }

    /* renamed from: f */
    public void m1462f(int i) {
        m1460d(i == 0 ? null : mo1239b().getString(i));
    }

    /* renamed from: v */
    private void m1456v() {
        if ((this.f1597e & 4) != 0) {
            if (TextUtils.isEmpty(this.f1605m)) {
                this.f1593a.setNavigationContentDescription(this.f1608p);
            } else {
                this.f1593a.setNavigationContentDescription(this.f1605m);
            }
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: d */
    public void mo1246d(int i) {
        this.f1593a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: a */
    public void mo1235a(InterfaceC0112m.a aVar, C0106g.a aVar2) {
        this.f1593a.m1134a(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.InterfaceC0164af
    /* renamed from: r */
    public Menu mo1260r() {
        return this.f1593a.getMenu();
    }
}
