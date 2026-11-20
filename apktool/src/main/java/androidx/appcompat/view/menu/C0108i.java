package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.view.menu.InterfaceC0113n;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p024a.p025a.InterfaceMenuItemC0227b;
import androidx.core.p031f.AbstractC0283b;

/* compiled from: MenuItemImpl.java */
/* renamed from: androidx.appcompat.view.menu.i */
/* loaded from: classes.dex */
public final class C0108i implements InterfaceMenuItemC0227b {

    /* renamed from: A */
    private View f1027A;

    /* renamed from: B */
    private AbstractC0283b f1028B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f1029C;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f1031E;

    /* renamed from: a */
    C0106g f1032a;

    /* renamed from: b */
    private final int f1033b;

    /* renamed from: c */
    private final int f1034c;

    /* renamed from: d */
    private final int f1035d;

    /* renamed from: e */
    private final int f1036e;

    /* renamed from: f */
    private CharSequence f1037f;

    /* renamed from: g */
    private CharSequence f1038g;

    /* renamed from: h */
    private Intent f1039h;

    /* renamed from: i */
    private char f1040i;

    /* renamed from: k */
    private char f1042k;

    /* renamed from: m */
    private Drawable f1044m;

    /* renamed from: o */
    private SubMenuC0117r f1046o;

    /* renamed from: p */
    private Runnable f1047p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f1048q;

    /* renamed from: r */
    private CharSequence f1049r;

    /* renamed from: s */
    private CharSequence f1050s;

    /* renamed from: z */
    private int f1057z;

    /* renamed from: j */
    private int f1041j = 4096;

    /* renamed from: l */
    private int f1043l = 4096;

    /* renamed from: n */
    private int f1045n = 0;

    /* renamed from: t */
    private ColorStateList f1051t = null;

    /* renamed from: u */
    private PorterDuff.Mode f1052u = null;

    /* renamed from: v */
    private boolean f1053v = false;

    /* renamed from: w */
    private boolean f1054w = false;

    /* renamed from: x */
    private boolean f1055x = false;

    /* renamed from: y */
    private int f1056y = 16;

    /* renamed from: D */
    private boolean f1030D = false;

    C0108i(C0106g c0106g, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1057z = 0;
        this.f1032a = c0106g;
        this.f1033b = i2;
        this.f1034c = i;
        this.f1035d = i3;
        this.f1036e = i4;
        this.f1037f = charSequence;
        this.f1057z = i5;
    }

    /* renamed from: b */
    public boolean m928b() {
        if ((this.f1048q != null && this.f1048q.onMenuItemClick(this)) || this.f1032a.mo885a(this.f1032a, this)) {
            return true;
        }
        if (this.f1047p != null) {
            this.f1047p.run();
            return true;
        }
        if (this.f1039h != null) {
            try {
                this.f1032a.m902f().startActivity(this.f1039h);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.m185e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        return this.f1028B != null && this.f1028B.mo948b();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1056y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1056y |= 16;
        } else {
            this.f1056y &= -17;
        }
        this.f1032a.m890b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1034c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1033b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1035d;
    }

    /* renamed from: c */
    public int m929c() {
        return this.f1036e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1039h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1039h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1042k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f1042k != c2) {
            this.f1042k = Character.toLowerCase(c2);
            this.f1032a.m890b(false);
        }
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.f1042k != c2 || this.f1043l != i) {
            this.f1042k = Character.toLowerCase(c2);
            this.f1043l = KeyEvent.normalizeMetaState(i);
            this.f1032a.m890b(false);
        }
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1043l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1040i;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1041j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f1040i != c2) {
            this.f1040i = c2;
            this.f1032a.m890b(false);
        }
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        if (this.f1040i != c2 || this.f1041j != i) {
            this.f1040i = c2;
            this.f1041j = KeyEvent.normalizeMetaState(i);
            this.f1032a.m890b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1040i = c2;
        this.f1042k = Character.toLowerCase(c3);
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f1040i = c2;
        this.f1041j = KeyEvent.normalizeMetaState(i);
        this.f1042k = Character.toLowerCase(c3);
        this.f1043l = KeyEvent.normalizeMetaState(i2);
        this.f1032a.m890b(false);
        return this;
    }

    /* renamed from: d */
    char m931d() {
        return this.f1032a.mo894c() ? this.f1042k : this.f1040i;
    }

    /* renamed from: e */
    String m933e() {
        char m931d = m931d();
        if (m931d == 0) {
            return "";
        }
        Resources resources = this.f1032a.m902f().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1032a.m902f()).hasPermanentMenuKey()) {
            sb.append(resources.getString(C0059a.h.abc_prepend_shortcut_label));
        }
        int i = this.f1032a.mo894c() ? this.f1043l : this.f1041j;
        m919a(sb, i, 65536, resources.getString(C0059a.h.abc_menu_meta_shortcut_label));
        m919a(sb, i, 4096, resources.getString(C0059a.h.abc_menu_ctrl_shortcut_label));
        m919a(sb, i, 2, resources.getString(C0059a.h.abc_menu_alt_shortcut_label));
        m919a(sb, i, 1, resources.getString(C0059a.h.abc_menu_shift_shortcut_label));
        m919a(sb, i, 4, resources.getString(C0059a.h.abc_menu_sym_shortcut_label));
        m919a(sb, i, 8, resources.getString(C0059a.h.abc_menu_function_shortcut_label));
        switch (m931d) {
            case '\b':
                sb.append(resources.getString(C0059a.h.abc_menu_delete_shortcut_label));
                break;
            case '\n':
                sb.append(resources.getString(C0059a.h.abc_menu_enter_shortcut_label));
                break;
            case ' ':
                sb.append(resources.getString(C0059a.h.abc_menu_space_shortcut_label));
                break;
            default:
                sb.append(m931d);
                break;
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m919a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: f */
    boolean m935f() {
        return this.f1032a.mo898d() && m931d() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1046o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1046o != null;
    }

    /* renamed from: a */
    public void m924a(SubMenuC0117r subMenuC0117r) {
        this.f1046o = subMenuC0117r;
        subMenuC0117r.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1037f;
    }

    /* renamed from: a */
    CharSequence m922a(InterfaceC0113n.a aVar) {
        if (aVar != null && aVar.mo783a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1037f = charSequence;
        this.f1032a.m890b(false);
        if (this.f1046o != null) {
            this.f1046o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f1032a.m902f().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1038g != null ? this.f1038g : this.f1037f;
        if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            return charSequence.toString();
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1038g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1037f;
        }
        this.f1032a.m890b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f1044m != null) {
            return m918a(this.f1044m);
        }
        if (this.f1045n != 0) {
            Drawable m348b = C0060a.m348b(this.f1032a.m902f(), this.f1045n);
            this.f1045n = 0;
            this.f1044m = m348b;
            return m918a(m348b);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1045n = 0;
        this.f1044m = drawable;
        this.f1055x = true;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1044m = null;
        this.f1045n = i;
        this.f1055x = true;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1051t = colorStateList;
        this.f1053v = true;
        this.f1055x = true;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1051t;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1052u = mode;
        this.f1054w = true;
        this.f1055x = true;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1052u;
    }

    /* renamed from: a */
    private Drawable m918a(Drawable drawable) {
        if (drawable != null && this.f1055x && (this.f1053v || this.f1054w)) {
            drawable = C0315a.m2369f(drawable).mutate();
            if (this.f1053v) {
                C0315a.m2359a(drawable, this.f1051t);
            }
            if (this.f1054w) {
                C0315a.m2362a(drawable, this.f1052u);
            }
            this.f1055x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1056y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f1056y;
        this.f1056y = (z ? 1 : 0) | (this.f1056y & (-2));
        if (i != this.f1056y) {
            this.f1032a.m890b(false);
        }
        return this;
    }

    /* renamed from: a */
    public void m925a(boolean z) {
        this.f1056y = (z ? 4 : 0) | (this.f1056y & (-5));
    }

    /* renamed from: g */
    public boolean m936g() {
        return (this.f1056y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1056y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f1056y & 4) != 0) {
            this.f1032a.m876a((MenuItem) this);
        } else {
            m927b(z);
        }
        return this;
    }

    /* renamed from: b */
    void m927b(boolean z) {
        int i = this.f1056y;
        this.f1056y = (z ? 2 : 0) | (this.f1056y & (-3));
        if (i != this.f1056y) {
            this.f1032a.m890b(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1028B == null || !this.f1028B.mo952d()) ? (this.f1056y & 8) == 0 : (this.f1056y & 8) == 0 && this.f1028B.mo953e();
    }

    /* renamed from: c */
    boolean m930c(boolean z) {
        int i = this.f1056y;
        this.f1056y = (z ? 0 : 8) | (this.f1056y & (-9));
        return i != this.f1056y;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m930c(z)) {
            this.f1032a.m878a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1048q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f1037f != null) {
            return this.f1037f.toString();
        }
        return null;
    }

    /* renamed from: a */
    void m923a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1031E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1031E;
    }

    /* renamed from: h */
    public void m937h() {
        this.f1032a.m888b(this);
    }

    /* renamed from: i */
    public boolean m938i() {
        return this.f1032a.m914r();
    }

    /* renamed from: j */
    public boolean m939j() {
        return (this.f1056y & 32) == 32;
    }

    /* renamed from: k */
    public boolean m940k() {
        return (this.f1057z & 1) == 1;
    }

    /* renamed from: l */
    public boolean m941l() {
        return (this.f1057z & 2) == 2;
    }

    /* renamed from: d */
    public void m932d(boolean z) {
        if (z) {
            this.f1056y |= 32;
        } else {
            this.f1056y &= -33;
        }
    }

    /* renamed from: m */
    public boolean m942m() {
        return (this.f1057z & 4) == 4;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1057z = i;
                this.f1032a.m888b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setActionView(View view) {
        this.f1027A = view;
        this.f1028B = null;
        if (view != null && view.getId() == -1 && this.f1033b > 0) {
            view.setId(this.f1033b);
        }
        this.f1032a.m888b(this);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setActionView(int i) {
        Context m902f = this.f1032a.m902f();
        setActionView(LayoutInflater.from(m902f).inflate(i, (ViewGroup) new LinearLayout(m902f), false));
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public View getActionView() {
        if (this.f1027A != null) {
            return this.f1027A;
        }
        if (this.f1028B != null) {
            this.f1027A = this.f1028B.mo950a(this);
            return this.f1027A;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b
    /* renamed from: a */
    public AbstractC0283b mo803a() {
        return this.f1028B;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b
    /* renamed from: a */
    public InterfaceMenuItemC0227b mo801a(AbstractC0283b abstractC0283b) {
        if (this.f1028B != null) {
            this.f1028B.m2130f();
        }
        this.f1027A = null;
        this.f1028B = abstractC0283b;
        this.f1032a.m890b(true);
        if (this.f1028B != null) {
            this.f1028B.mo951a(new AbstractC0283b.b() { // from class: androidx.appcompat.view.menu.i.1
                @Override // androidx.core.p031f.AbstractC0283b.b
                /* renamed from: a */
                public void mo944a(boolean z) {
                    C0108i.this.f1032a.m878a(C0108i.this);
                }
            });
        }
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean expandActionView() {
        if (!m943n()) {
            return false;
        }
        if (this.f1029C == null || this.f1029C.onMenuItemActionExpand(this)) {
            return this.f1032a.mo895c(this);
        }
        return false;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1057z & 8) == 0) {
            return false;
        }
        if (this.f1027A == null) {
            return true;
        }
        if (this.f1029C == null || this.f1029C.onMenuItemActionCollapse(this)) {
            return this.f1032a.mo899d(this);
        }
        return false;
    }

    /* renamed from: n */
    public boolean m943n() {
        if ((this.f1057z & 8) == 0) {
            return false;
        }
        if (this.f1027A == null && this.f1028B != null) {
            this.f1027A = this.f1028B.mo950a(this);
        }
        return this.f1027A != null;
    }

    /* renamed from: e */
    public void m934e(boolean z) {
        this.f1030D = z;
        this.f1032a.m890b(false);
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1030D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1029C = onActionExpandListener;
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setContentDescription(CharSequence charSequence) {
        this.f1049r = charSequence;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1049r;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0227b setTooltipText(CharSequence charSequence) {
        this.f1050s = charSequence;
        this.f1032a.m890b(false);
        return this;
    }

    @Override // androidx.core.p024a.p025a.InterfaceMenuItemC0227b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1050s;
    }
}
