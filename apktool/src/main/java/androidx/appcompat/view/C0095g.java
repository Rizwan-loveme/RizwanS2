package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0108i;
import androidx.appcompat.view.menu.MenuItemC0109j;
import androidx.appcompat.widget.C0165ag;
import androidx.appcompat.widget.C0184az;
import androidx.core.p024a.p025a.InterfaceMenuC0226a;
import androidx.core.p031f.AbstractC0283b;
import androidx.core.p031f.C0293i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.p209io.IOException;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* renamed from: androidx.appcompat.view.g */
/* loaded from: classes.dex */
public class C0095g extends MenuInflater {

    /* renamed from: a */
    static final Class<?>[] f826a = {Context.class};

    /* renamed from: b */
    static final Class<?>[] f827b = f826a;

    /* renamed from: c */
    final Object[] f828c;

    /* renamed from: d */
    final Object[] f829d;

    /* renamed from: e */
    Context f830e;

    /* renamed from: f */
    private Object f831f;

    public C0095g(Context context) {
        super(context);
        this.f830e = context;
        this.f828c = new Object[]{context};
        this.f829d = this.f828c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof InterfaceMenuC0226a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = this.f830e.getResources().getLayout(i);
                m759a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r4 = r10.next();
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        if (r6 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r4 = r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        if (r4.equals(android.net.wifi.WifiConfiguration.GroupCipher.varName) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        r8.m765a(r11);
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        if (r4.equals("item") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        r8.m767b(r11);
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if (r4.equals("menu") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        m759a(r10, r11, r8.m768c());
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        r0 = r1;
        r3 = r4;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        r0 = r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r6 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
    
        if (r0.equals(r3) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:
    
        r0 = r1;
        r3 = null;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        if (r0.equals(android.net.wifi.WifiConfiguration.GroupCipher.varName) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        r8.m764a();
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a9, code lost:
    
        if (r0.equals("item") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
    
        if (r8.m769d() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b3, code lost:
    
        if (r8.f841a == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        if (r8.f841a.mo949c() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
    
        r8.m768c();
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        r8.m766b();
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cf, code lost:
    
        if (r0.equals("menu") == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d1, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00dc, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r1 = false;
        r3 = null;
        r6 = false;
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (r1 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        switch(r4) {
            case 1: goto L58;
            case 2: goto L18;
            case 3: goto L30;
            default: goto L11;
        };
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m759a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    Object m760a() {
        if (this.f831f == null) {
            this.f831f = m758a(this.f830e);
        }
        return this.f831f;
    }

    /* renamed from: a */
    private Object m758a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m758a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: androidx.appcompat.view.g$a */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f832a = {MenuItem.class};

        /* renamed from: b */
        private Object f833b;

        /* renamed from: c */
        private Method f834c;

        public a(Object obj, String str) {
            this.f833b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f834c = cls.getMethod(str, f832a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f834c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f834c.invoke(this.f833b, menuItem)).booleanValue();
                }
                this.f834c.invoke(this.f833b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: androidx.appcompat.view.g$b */
    private class b {

        /* renamed from: A */
        private String f835A;

        /* renamed from: B */
        private String f836B;

        /* renamed from: C */
        private CharSequence f837C;

        /* renamed from: D */
        private CharSequence f838D;

        /* renamed from: E */
        private ColorStateList f839E = null;

        /* renamed from: F */
        private PorterDuff.Mode f840F = null;

        /* renamed from: a */
        AbstractC0283b f841a;

        /* renamed from: c */
        private Menu f843c;

        /* renamed from: d */
        private int f844d;

        /* renamed from: e */
        private int f845e;

        /* renamed from: f */
        private int f846f;

        /* renamed from: g */
        private int f847g;

        /* renamed from: h */
        private boolean f848h;

        /* renamed from: i */
        private boolean f849i;

        /* renamed from: j */
        private boolean f850j;

        /* renamed from: k */
        private int f851k;

        /* renamed from: l */
        private int f852l;

        /* renamed from: m */
        private CharSequence f853m;

        /* renamed from: n */
        private CharSequence f854n;

        /* renamed from: o */
        private int f855o;

        /* renamed from: p */
        private char f856p;

        /* renamed from: q */
        private int f857q;

        /* renamed from: r */
        private char f858r;

        /* renamed from: s */
        private int f859s;

        /* renamed from: t */
        private int f860t;

        /* renamed from: u */
        private boolean f861u;

        /* renamed from: v */
        private boolean f862v;

        /* renamed from: w */
        private boolean f863w;

        /* renamed from: x */
        private int f864x;

        /* renamed from: y */
        private int f865y;

        /* renamed from: z */
        private String f866z;

        public b(Menu menu) {
            this.f843c = menu;
            m764a();
        }

        /* renamed from: a */
        public void m764a() {
            this.f844d = 0;
            this.f845e = 0;
            this.f846f = 0;
            this.f847g = 0;
            this.f848h = true;
            this.f849i = true;
        }

        /* renamed from: a */
        public void m765a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0095g.this.f830e.obtainStyledAttributes(attributeSet, C0059a.j.MenuGroup);
            this.f844d = obtainStyledAttributes.getResourceId(C0059a.j.MenuGroup_android_id, 0);
            this.f845e = obtainStyledAttributes.getInt(C0059a.j.MenuGroup_android_menuCategory, 0);
            this.f846f = obtainStyledAttributes.getInt(C0059a.j.MenuGroup_android_orderInCategory, 0);
            this.f847g = obtainStyledAttributes.getInt(C0059a.j.MenuGroup_android_checkableBehavior, 0);
            this.f848h = obtainStyledAttributes.getBoolean(C0059a.j.MenuGroup_android_visible, true);
            this.f849i = obtainStyledAttributes.getBoolean(C0059a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void m767b(AttributeSet attributeSet) {
            C0184az m1431a = C0184az.m1431a(C0095g.this.f830e, attributeSet, C0059a.j.MenuItem);
            this.f851k = m1431a.m1450g(C0059a.j.MenuItem_android_id, 0);
            this.f852l = (m1431a.m1434a(C0059a.j.MenuItem_android_menuCategory, this.f845e) & Color.RED) | (m1431a.m1434a(C0059a.j.MenuItem_android_orderInCategory, this.f846f) & 65535);
            this.f853m = m1431a.m1443c(C0059a.j.MenuItem_android_title);
            this.f854n = m1431a.m1443c(C0059a.j.MenuItem_android_titleCondensed);
            this.f855o = m1431a.m1450g(C0059a.j.MenuItem_android_icon, 0);
            this.f856p = m761a(m1431a.m1445d(C0059a.j.MenuItem_android_alphabeticShortcut));
            this.f857q = m1431a.m1434a(C0059a.j.MenuItem_alphabeticModifiers, 4096);
            this.f858r = m761a(m1431a.m1445d(C0059a.j.MenuItem_android_numericShortcut));
            this.f859s = m1431a.m1434a(C0059a.j.MenuItem_numericModifiers, 4096);
            if (m1431a.m1451g(C0059a.j.MenuItem_android_checkable)) {
                this.f860t = m1431a.m1438a(C0059a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f860t = this.f847g;
            }
            this.f861u = m1431a.m1438a(C0059a.j.MenuItem_android_checked, false);
            this.f862v = m1431a.m1438a(C0059a.j.MenuItem_android_visible, this.f848h);
            this.f863w = m1431a.m1438a(C0059a.j.MenuItem_android_enabled, this.f849i);
            this.f864x = m1431a.m1434a(C0059a.j.MenuItem_showAsAction, -1);
            this.f836B = m1431a.m1445d(C0059a.j.MenuItem_android_onClick);
            this.f865y = m1431a.m1450g(C0059a.j.MenuItem_actionLayout, 0);
            this.f866z = m1431a.m1445d(C0059a.j.MenuItem_actionViewClass);
            this.f835A = m1431a.m1445d(C0059a.j.MenuItem_actionProviderClass);
            boolean z = this.f835A != null;
            if (z && this.f865y == 0 && this.f866z == null) {
                this.f841a = (AbstractC0283b) m762a(this.f835A, C0095g.f827b, C0095g.this.f829d);
            } else {
                if (z) {
                    Log.m190w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f841a = null;
            }
            this.f837C = m1431a.m1443c(C0059a.j.MenuItem_contentDescription);
            this.f838D = m1431a.m1443c(C0059a.j.MenuItem_tooltipText);
            if (m1431a.m1451g(C0059a.j.MenuItem_iconTintMode)) {
                this.f840F = C0165ag.m1261a(m1431a.m1434a(C0059a.j.MenuItem_iconTintMode, -1), this.f840F);
            } else {
                this.f840F = null;
            }
            if (m1431a.m1451g(C0059a.j.MenuItem_iconTint)) {
                this.f839E = m1431a.m1447e(C0059a.j.MenuItem_iconTint);
            } else {
                this.f839E = null;
            }
            m1431a.m1441b();
            this.f850j = false;
        }

        /* renamed from: a */
        private char m761a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private void m763a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f861u).setVisible(this.f862v).setEnabled(this.f863w).setCheckable(this.f860t >= 1).setTitleCondensed(this.f854n).setIcon(this.f855o);
            if (this.f864x >= 0) {
                menuItem.setShowAsAction(this.f864x);
            }
            if (this.f836B != null) {
                if (C0095g.this.f830e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C0095g.this.m760a(), this.f836B));
            }
            if (this.f860t >= 2) {
                if (menuItem instanceof C0108i) {
                    ((C0108i) menuItem).m925a(true);
                } else if (menuItem instanceof MenuItemC0109j) {
                    ((MenuItemC0109j) menuItem).m945a(true);
                }
            }
            if (this.f866z != null) {
                menuItem.setActionView((View) m762a(this.f866z, C0095g.f826a, C0095g.this.f828c));
            } else {
                z = false;
            }
            if (this.f865y > 0) {
                if (!z) {
                    menuItem.setActionView(this.f865y);
                } else {
                    Log.m190w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f841a != null) {
                C0293i.m2178a(menuItem, this.f841a);
            }
            C0293i.m2182a(menuItem, this.f837C);
            C0293i.m2184b(menuItem, this.f838D);
            C0293i.m2183b(menuItem, this.f856p, this.f857q);
            C0293i.m2179a(menuItem, this.f858r, this.f859s);
            if (this.f840F != null) {
                C0293i.m2181a(menuItem, this.f840F);
            }
            if (this.f839E != null) {
                C0293i.m2180a(menuItem, this.f839E);
            }
        }

        /* renamed from: b */
        public void m766b() {
            this.f850j = true;
            m763a(this.f843c.add(this.f844d, this.f851k, this.f852l, this.f853m));
        }

        /* renamed from: c */
        public SubMenu m768c() {
            this.f850j = true;
            SubMenu addSubMenu = this.f843c.addSubMenu(this.f844d, this.f851k, this.f852l, this.f853m);
            m763a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean m769d() {
            return this.f850j;
        }

        /* renamed from: a */
        private <T> T m762a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C0095g.this.f830e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.m191w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }
}
