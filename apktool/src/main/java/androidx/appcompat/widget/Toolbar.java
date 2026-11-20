package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.AbstractC0069a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.view.C0095g;
import androidx.appcompat.view.InterfaceC0091c;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.C0108i;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.SubMenuC0117r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0292h;
import androidx.core.p031f.C0308x;
import androidx.p021c.p022a.AbstractC0223a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private ColorStateList f1302A;

    /* renamed from: B */
    private ColorStateList f1303B;

    /* renamed from: C */
    private boolean f1304C;

    /* renamed from: D */
    private boolean f1305D;

    /* renamed from: E */
    private final ArrayList<View> f1306E;

    /* renamed from: F */
    private final ArrayList<View> f1307F;

    /* renamed from: G */
    private final int[] f1308G;

    /* renamed from: H */
    private final ActionMenuView.InterfaceC0129e f1309H;

    /* renamed from: I */
    private C0186ba f1310I;

    /* renamed from: J */
    private C0193c f1311J;

    /* renamed from: K */
    private C0153a f1312K;

    /* renamed from: L */
    private InterfaceC0112m.a f1313L;

    /* renamed from: M */
    private C0106g.a f1314M;

    /* renamed from: N */
    private boolean f1315N;

    /* renamed from: O */
    private final Runnable f1316O;

    /* renamed from: a */
    ImageButton f1317a;

    /* renamed from: b */
    View f1318b;

    /* renamed from: c */
    int f1319c;

    /* renamed from: d */
    InterfaceC0155c f1320d;

    /* renamed from: e */
    private ActionMenuView f1321e;

    /* renamed from: f */
    private TextView f1322f;

    /* renamed from: g */
    private TextView f1323g;

    /* renamed from: h */
    private ImageButton f1324h;

    /* renamed from: i */
    private ImageView f1325i;

    /* renamed from: j */
    private Drawable f1326j;

    /* renamed from: k */
    private CharSequence f1327k;

    /* renamed from: l */
    private Context f1328l;

    /* renamed from: m */
    private int f1329m;

    /* renamed from: n */
    private int f1330n;

    /* renamed from: o */
    private int f1331o;

    /* renamed from: p */
    private int f1332p;

    /* renamed from: q */
    private int f1333q;

    /* renamed from: r */
    private int f1334r;

    /* renamed from: s */
    private int f1335s;

    /* renamed from: t */
    private int f1336t;

    /* renamed from: u */
    private C0176ar f1337u;

    /* renamed from: v */
    private int f1338v;

    /* renamed from: w */
    private int f1339w;

    /* renamed from: x */
    private int f1340x;

    /* renamed from: y */
    private CharSequence f1341y;

    /* renamed from: z */
    private CharSequence f1342z;

    /* renamed from: androidx.appcompat.widget.Toolbar$c */
    public interface InterfaceC0155c {
        /* renamed from: a */
        boolean mo1150a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1340x = 8388627;
        this.f1306E = new ArrayList<>();
        this.f1307F = new ArrayList<>();
        this.f1308G = new int[2];
        this.f1309H = new ActionMenuView.InterfaceC0129e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0129e
            /* renamed from: a */
            public boolean mo1031a(MenuItem menuItem) {
                if (Toolbar.this.f1320d != null) {
                    return Toolbar.this.f1320d.mo1150a(menuItem);
                }
                return false;
            }
        };
        this.f1316O = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.m1140d();
            }
        };
        C0184az m1432a = C0184az.m1432a(getContext(), attributeSet, C0059a.j.Toolbar, i, 0);
        C0308x.m2230a(this, context, C0059a.j.Toolbar, attributeSet, m1432a.m1435a(), i, 0);
        this.f1330n = m1432a.m1450g(C0059a.j.Toolbar_titleTextAppearance, 0);
        this.f1331o = m1432a.m1450g(C0059a.j.Toolbar_subtitleTextAppearance, 0);
        this.f1340x = m1432a.m1442c(C0059a.j.Toolbar_android_gravity, this.f1340x);
        this.f1319c = m1432a.m1442c(C0059a.j.Toolbar_buttonGravity, 48);
        int m1444d = m1432a.m1444d(C0059a.j.Toolbar_titleMargin, 0);
        m1444d = m1432a.m1451g(C0059a.j.Toolbar_titleMargins) ? m1432a.m1444d(C0059a.j.Toolbar_titleMargins, m1444d) : m1444d;
        this.f1336t = m1444d;
        this.f1335s = m1444d;
        this.f1334r = m1444d;
        this.f1333q = m1444d;
        int m1444d2 = m1432a.m1444d(C0059a.j.Toolbar_titleMarginStart, -1);
        if (m1444d2 >= 0) {
            this.f1333q = m1444d2;
        }
        int m1444d3 = m1432a.m1444d(C0059a.j.Toolbar_titleMarginEnd, -1);
        if (m1444d3 >= 0) {
            this.f1334r = m1444d3;
        }
        int m1444d4 = m1432a.m1444d(C0059a.j.Toolbar_titleMarginTop, -1);
        if (m1444d4 >= 0) {
            this.f1335s = m1444d4;
        }
        int m1444d5 = m1432a.m1444d(C0059a.j.Toolbar_titleMarginBottom, -1);
        if (m1444d5 >= 0) {
            this.f1336t = m1444d5;
        }
        this.f1332p = m1432a.m1446e(C0059a.j.Toolbar_maxButtonHeight, -1);
        int m1444d6 = m1432a.m1444d(C0059a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int m1444d7 = m1432a.m1444d(C0059a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int m1446e = m1432a.m1446e(C0059a.j.Toolbar_contentInsetLeft, 0);
        int m1446e2 = m1432a.m1446e(C0059a.j.Toolbar_contentInsetRight, 0);
        m1127s();
        this.f1337u.m1384b(m1446e, m1446e2);
        if (m1444d6 != Integer.MIN_VALUE || m1444d7 != Integer.MIN_VALUE) {
            this.f1337u.m1381a(m1444d6, m1444d7);
        }
        this.f1338v = m1432a.m1444d(C0059a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1339w = m1432a.m1444d(C0059a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1326j = m1432a.m1437a(C0059a.j.Toolbar_collapseIcon);
        this.f1327k = m1432a.m1443c(C0059a.j.Toolbar_collapseContentDescription);
        CharSequence m1443c = m1432a.m1443c(C0059a.j.Toolbar_title);
        if (!TextUtils.isEmpty(m1443c)) {
            setTitle(m1443c);
        }
        CharSequence m1443c2 = m1432a.m1443c(C0059a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(m1443c2)) {
            setSubtitle(m1443c2);
        }
        this.f1328l = getContext();
        setPopupTheme(m1432a.m1450g(C0059a.j.Toolbar_popupTheme, 0));
        Drawable m1437a = m1432a.m1437a(C0059a.j.Toolbar_navigationIcon);
        if (m1437a != null) {
            setNavigationIcon(m1437a);
        }
        CharSequence m1443c3 = m1432a.m1443c(C0059a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(m1443c3)) {
            setNavigationContentDescription(m1443c3);
        }
        Drawable m1437a2 = m1432a.m1437a(C0059a.j.Toolbar_logo);
        if (m1437a2 != null) {
            setLogo(m1437a2);
        }
        CharSequence m1443c4 = m1432a.m1443c(C0059a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(m1443c4)) {
            setLogoDescription(m1443c4);
        }
        if (m1432a.m1451g(C0059a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(m1432a.m1447e(C0059a.j.Toolbar_titleTextColor));
        }
        if (m1432a.m1451g(C0059a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(m1432a.m1447e(C0059a.j.Toolbar_subtitleTextColor));
        }
        if (m1432a.m1451g(C0059a.j.Toolbar_menu)) {
            m1130a(m1432a.m1450g(C0059a.j.Toolbar_menu, 0));
        }
        m1432a.m1441b();
    }

    public void setPopupTheme(int i) {
        if (this.f1329m != i) {
            this.f1329m = i;
            if (i == 0) {
                this.f1328l = getContext();
            } else {
                this.f1328l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1329m;
    }

    public int getTitleMarginStart() {
        return this.f1333q;
    }

    public void setTitleMarginStart(int i) {
        this.f1333q = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f1335s;
    }

    public void setTitleMarginTop(int i) {
        this.f1335s = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f1334r;
    }

    public void setTitleMarginEnd(int i) {
        this.f1334r = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f1336t;
    }

    public void setTitleMarginBottom(int i) {
        this.f1336t = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m1127s();
        this.f1337u.m1382a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(C0060a.m348b(getContext(), i));
    }

    /* renamed from: a */
    public boolean m1135a() {
        return getVisibility() == 0 && this.f1321e != null && this.f1321e.m1018a();
    }

    /* renamed from: b */
    public boolean m1138b() {
        return this.f1321e != null && this.f1321e.m1027g();
    }

    /* renamed from: c */
    public boolean m1139c() {
        return this.f1321e != null && this.f1321e.m1028h();
    }

    /* renamed from: d */
    public boolean m1140d() {
        return this.f1321e != null && this.f1321e.m1025e();
    }

    /* renamed from: e */
    public boolean m1141e() {
        return this.f1321e != null && this.f1321e.m1026f();
    }

    /* renamed from: a */
    public void m1133a(C0106g c0106g, C0193c c0193c) {
        if (c0106g != null || this.f1321e != null) {
            m1123o();
            C0106g m1024d = this.f1321e.m1024d();
            if (m1024d != c0106g) {
                if (m1024d != null) {
                    m1024d.m889b(this.f1311J);
                    m1024d.m889b(this.f1312K);
                }
                if (this.f1312K == null) {
                    this.f1312K = new C0153a();
                }
                c0193c.m1497c(true);
                if (c0106g != null) {
                    c0106g.m880a(c0193c, this.f1328l);
                    c0106g.m880a(this.f1312K, this.f1328l);
                } else {
                    c0193c.mo810a(this.f1328l, (C0106g) null);
                    this.f1312K.mo810a(this.f1328l, (C0106g) null);
                    c0193c.mo815a(true);
                    this.f1312K.mo815a(true);
                }
                this.f1321e.setPopupTheme(this.f1329m);
                this.f1321e.setPresenter(c0193c);
                this.f1311J = c0193c;
            }
        }
    }

    /* renamed from: f */
    public void m1142f() {
        if (this.f1321e != null) {
            this.f1321e.m1029i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m1121m();
            if (!m1120d(this.f1325i)) {
                m1112a((View) this.f1325i, true);
            }
        } else if (this.f1325i != null && m1120d(this.f1325i)) {
            removeView(this.f1325i);
            this.f1307F.remove(this.f1325i);
        }
        if (this.f1325i != null) {
            this.f1325i.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.f1325i != null) {
            return this.f1325i.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1121m();
        }
        if (this.f1325i != null) {
            this.f1325i.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.f1325i != null) {
            return this.f1325i.getContentDescription();
        }
        return null;
    }

    /* renamed from: m */
    private void m1121m() {
        if (this.f1325i == null) {
            this.f1325i = new C0206p(getContext());
        }
    }

    /* renamed from: g */
    public boolean m1143g() {
        return (this.f1312K == null || this.f1312K.f1347b == null) ? false : true;
    }

    /* renamed from: h */
    public void m1144h() {
        C0108i c0108i = this.f1312K == null ? null : this.f1312K.f1347b;
        if (c0108i != null) {
            c0108i.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f1341y;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1322f == null) {
                Context context = getContext();
                this.f1322f = new C0160ab(context);
                this.f1322f.setSingleLine();
                this.f1322f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1330n != 0) {
                    this.f1322f.setTextAppearance(context, this.f1330n);
                }
                if (this.f1302A != null) {
                    this.f1322f.setTextColor(this.f1302A);
                }
            }
            if (!m1120d(this.f1322f)) {
                m1112a((View) this.f1322f, true);
            }
        } else if (this.f1322f != null && m1120d(this.f1322f)) {
            removeView(this.f1322f);
            this.f1307F.remove(this.f1322f);
        }
        if (this.f1322f != null) {
            this.f1322f.setText(charSequence);
        }
        this.f1341y = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f1342z;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1323g == null) {
                Context context = getContext();
                this.f1323g = new C0160ab(context);
                this.f1323g.setSingleLine();
                this.f1323g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1331o != 0) {
                    this.f1323g.setTextAppearance(context, this.f1331o);
                }
                if (this.f1303B != null) {
                    this.f1323g.setTextColor(this.f1303B);
                }
            }
            if (!m1120d(this.f1323g)) {
                m1112a((View) this.f1323g, true);
            }
        } else if (this.f1323g != null && m1120d(this.f1323g)) {
            removeView(this.f1323g);
            this.f1307F.remove(this.f1323g);
        }
        if (this.f1323g != null) {
            this.f1323g.setText(charSequence);
        }
        this.f1342z = charSequence;
    }

    /* renamed from: a */
    public void m1132a(Context context, int i) {
        this.f1330n = i;
        if (this.f1322f != null) {
            this.f1322f.setTextAppearance(context, i);
        }
    }

    /* renamed from: b */
    public void m1137b(Context context, int i) {
        this.f1331o = i;
        if (this.f1323g != null) {
            this.f1323g.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1302A = colorStateList;
        if (this.f1322f != null) {
            this.f1322f.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f1303B = colorStateList;
        if (this.f1323g != null) {
            this.f1323g.setTextColor(colorStateList);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f1324h != null) {
            return this.f1324h.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1124p();
        }
        if (this.f1324h != null) {
            this.f1324h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0060a.m348b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m1124p();
            if (!m1120d(this.f1324h)) {
                m1112a((View) this.f1324h, true);
            }
        } else if (this.f1324h != null && m1120d(this.f1324h)) {
            removeView(this.f1324h);
            this.f1307F.remove(this.f1324h);
        }
        if (this.f1324h != null) {
            this.f1324h.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.f1324h != null) {
            return this.f1324h.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m1124p();
        this.f1324h.setOnClickListener(onClickListener);
    }

    public CharSequence getCollapseContentDescription() {
        if (this.f1317a != null) {
            return this.f1317a.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1145i();
        }
        if (this.f1317a != null) {
            this.f1317a.setContentDescription(charSequence);
        }
    }

    public Drawable getCollapseIcon() {
        if (this.f1317a != null) {
            return this.f1317a.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(C0060a.m348b(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            m1145i();
            this.f1317a.setImageDrawable(drawable);
        } else if (this.f1317a != null) {
            this.f1317a.setImageDrawable(this.f1326j);
        }
    }

    public Menu getMenu() {
        m1122n();
        return this.f1321e.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m1122n();
        this.f1321e.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m1122n();
        return this.f1321e.getOverflowIcon();
    }

    /* renamed from: n */
    private void m1122n() {
        m1123o();
        if (this.f1321e.m1024d() == null) {
            C0106g c0106g = (C0106g) this.f1321e.getMenu();
            if (this.f1312K == null) {
                this.f1312K = new C0153a();
            }
            this.f1321e.setExpandedActionViewsExclusive(true);
            c0106g.m880a(this.f1312K, this.f1328l);
        }
    }

    /* renamed from: o */
    private void m1123o() {
        if (this.f1321e == null) {
            this.f1321e = new ActionMenuView(getContext());
            this.f1321e.setPopupTheme(this.f1329m);
            this.f1321e.setOnMenuItemClickListener(this.f1309H);
            this.f1321e.m1017a(this.f1313L, this.f1314M);
            C0154b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f544a = 8388613 | (this.f1319c & 112);
            this.f1321e.setLayoutParams(generateDefaultLayoutParams);
            m1112a((View) this.f1321e, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0095g(getContext());
    }

    /* renamed from: a */
    public void m1130a(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(InterfaceC0155c interfaceC0155c) {
        this.f1320d = interfaceC0155c;
    }

    /* renamed from: a */
    public void m1131a(int i, int i2) {
        m1127s();
        this.f1337u.m1381a(i, i2);
    }

    public int getContentInsetStart() {
        if (this.f1337u != null) {
            return this.f1337u.m1385c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        if (this.f1337u != null) {
            return this.f1337u.m1386d();
        }
        return 0;
    }

    /* renamed from: b */
    public void m1136b(int i, int i2) {
        m1127s();
        this.f1337u.m1384b(i, i2);
    }

    public int getContentInsetLeft() {
        if (this.f1337u != null) {
            return this.f1337u.m1380a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.f1337u != null) {
            return this.f1337u.m1383b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.f1338v != Integer.MIN_VALUE) {
            return this.f1338v;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1338v) {
            this.f1338v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.f1339w != Integer.MIN_VALUE) {
            return this.f1339w;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1339w) {
            this.f1339w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1338v, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z;
        if (this.f1321e != null) {
            C0106g m1024d = this.f1321e.m1024d();
            z = m1024d != null && m1024d.hasVisibleItems();
        } else {
            z = false;
        }
        if (z) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1339w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (C0308x.m2257f(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (C0308x.m2257f(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    /* renamed from: p */
    private void m1124p() {
        if (this.f1324h == null) {
            this.f1324h = new C0204n(getContext(), null, C0059a.a.toolbarNavigationButtonStyle);
            C0154b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f544a = 8388611 | (this.f1319c & 112);
            this.f1324h.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* renamed from: i */
    void m1145i() {
        if (this.f1317a == null) {
            this.f1317a = new C0204n(getContext(), null, C0059a.a.toolbarNavigationButtonStyle);
            this.f1317a.setImageDrawable(this.f1326j);
            this.f1317a.setContentDescription(this.f1327k);
            C0154b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f544a = 8388611 | (this.f1319c & 112);
            generateDefaultLayoutParams.f1349b = 2;
            this.f1317a.setLayoutParams(generateDefaultLayoutParams);
            this.f1317a.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.m1144h();
                }
            });
        }
    }

    /* renamed from: a */
    private void m1112a(View view, boolean z) {
        C0154b c0154b;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c0154b = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            c0154b = generateLayoutParams(layoutParams);
        } else {
            c0154b = (C0154b) layoutParams;
        }
        c0154b.f1349b = 1;
        if (z && this.f1318b != null) {
            view.setLayoutParams(c0154b);
            this.f1307F.add(view);
        } else {
            addView(view, c0154b);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0156d c0156d = new C0156d(super.onSaveInstanceState());
        if (this.f1312K != null && this.f1312K.f1347b != null) {
            c0156d.f1350a = this.f1312K.f1347b.getItemId();
        }
        c0156d.f1351b = m1138b();
        return c0156d;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof C0156d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0156d c0156d = (C0156d) parcelable;
        super.onRestoreInstanceState(c0156d.m1617a());
        C0106g m1024d = this.f1321e != null ? this.f1321e.m1024d() : null;
        if (c0156d.f1350a != 0 && this.f1312K != null && m1024d != null && (findItem = m1024d.findItem(c0156d.f1350a)) != null) {
            findItem.expandActionView();
        }
        if (c0156d.f1351b) {
            m1125q();
        }
    }

    /* renamed from: q */
    private void m1125q() {
        removeCallbacks(this.f1316O);
        post(this.f1316O);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1316O);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1304C = false;
        }
        if (!this.f1304C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1304C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1304C = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1305D = false;
        }
        if (!this.f1305D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1305D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1305D = false;
        }
        return true;
    }

    /* renamed from: a */
    private void m1111a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private int m1108a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: r */
    private boolean m1126r() {
        if (!this.f1315N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1114a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1308G;
        if (C0191bf.m1481a(this)) {
            c2 = 0;
            c3 = 1;
        } else {
            c2 = 1;
            c3 = 0;
        }
        int i7 = 0;
        if (m1114a(this.f1324h)) {
            m1111a(this.f1324h, i, 0, i2, 0, this.f1332p);
            i7 = this.f1324h.getMeasuredWidth() + m1116b(this.f1324h);
            int max = Math.max(0, this.f1324h.getMeasuredHeight() + m1119c(this.f1324h));
            i6 = View.combineMeasuredStates(0, this.f1324h.getMeasuredState());
            i5 = max;
        }
        if (m1114a(this.f1317a)) {
            m1111a(this.f1317a, i, 0, i2, 0, this.f1332p);
            i7 = this.f1317a.getMeasuredWidth() + m1116b(this.f1317a);
            i5 = Math.max(i5, this.f1317a.getMeasuredHeight() + m1119c(this.f1317a));
            i6 = View.combineMeasuredStates(i6, this.f1317a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[c3] = Math.max(0, currentContentInsetStart - i7);
        int i8 = 0;
        if (m1114a(this.f1321e)) {
            m1111a(this.f1321e, i, max2, i2, 0, this.f1332p);
            i8 = this.f1321e.getMeasuredWidth() + m1116b(this.f1321e);
            i5 = Math.max(i5, this.f1321e.getMeasuredHeight() + m1119c(this.f1321e));
            i6 = View.combineMeasuredStates(i6, this.f1321e.getMeasuredState());
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max2 + Math.max(currentContentInsetEnd, i8);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i8);
        if (m1114a(this.f1318b)) {
            max3 += m1108a(this.f1318b, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f1318b.getMeasuredHeight() + m1119c(this.f1318b));
            i6 = View.combineMeasuredStates(i6, this.f1318b.getMeasuredState());
        }
        if (m1114a(this.f1325i)) {
            max3 += m1108a(this.f1325i, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f1325i.getMeasuredHeight() + m1119c(this.f1325i));
            i6 = View.combineMeasuredStates(i6, this.f1325i.getMeasuredState());
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((C0154b) childAt.getLayoutParams()).f1349b != 0) {
                i3 = i10;
                i4 = i5;
            } else if (m1114a(childAt)) {
                max3 += m1108a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i5, childAt.getMeasuredHeight() + m1119c(childAt));
                i3 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
                i4 = max4;
            } else {
                i3 = i10;
                i4 = i5;
            }
            i9++;
            i10 = i3;
            i5 = i4;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = this.f1335s + this.f1336t;
        int i14 = this.f1333q + this.f1334r;
        if (m1114a(this.f1322f)) {
            m1108a(this.f1322f, i, max3 + i14, i2, i13, iArr);
            i11 = m1116b(this.f1322f) + this.f1322f.getMeasuredWidth();
            i12 = this.f1322f.getMeasuredHeight() + m1119c(this.f1322f);
            i10 = View.combineMeasuredStates(i10, this.f1322f.getMeasuredState());
        }
        if (m1114a(this.f1323g)) {
            i11 = Math.max(i11, m1108a(this.f1323g, i, max3 + i14, i2, i13 + i12, iArr));
            i12 += this.f1323g.getMeasuredHeight() + m1119c(this.f1323g);
            i10 = View.combineMeasuredStates(i10, this.f1323g.getMeasuredState());
        }
        int max5 = Math.max(i5, i12);
        int paddingLeft = i11 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i10 << 16);
        if (m1126r()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int max;
        boolean z2 = C0308x.m2257f(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.f1308G;
        iArr[1] = 0;
        iArr[0] = 0;
        int m2262i = C0308x.m2262i(this);
        int min = m2262i >= 0 ? Math.min(m2262i, i4 - i2) : 0;
        if (!m1114a(this.f1324h)) {
            i5 = i15;
            i6 = paddingLeft;
        } else if (z2) {
            i5 = m1117b(this.f1324h, i15, iArr, min);
            i6 = paddingLeft;
        } else {
            i6 = m1109a(this.f1324h, paddingLeft, iArr, min);
            i5 = i15;
        }
        if (m1114a(this.f1317a)) {
            if (z2) {
                i5 = m1117b(this.f1317a, i5, iArr, min);
            } else {
                i6 = m1109a(this.f1317a, i6, iArr, min);
            }
        }
        if (m1114a(this.f1321e)) {
            if (z2) {
                i6 = m1109a(this.f1321e, i6, iArr, min);
            } else {
                i5 = m1117b(this.f1321e, i5, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i6);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i5));
        int max2 = Math.max(i6, currentContentInsetLeft);
        int min2 = Math.min(i5, (width - paddingRight) - currentContentInsetRight);
        if (m1114a(this.f1318b)) {
            if (z2) {
                min2 = m1117b(this.f1318b, min2, iArr, min);
            } else {
                max2 = m1109a(this.f1318b, max2, iArr, min);
            }
        }
        if (!m1114a(this.f1325i)) {
            i7 = min2;
            i8 = max2;
        } else if (z2) {
            i7 = m1117b(this.f1325i, min2, iArr, min);
            i8 = max2;
        } else {
            i7 = min2;
            i8 = m1109a(this.f1325i, max2, iArr, min);
        }
        boolean m1114a = m1114a(this.f1322f);
        boolean m1114a2 = m1114a(this.f1323g);
        int i16 = 0;
        if (m1114a) {
            C0154b c0154b = (C0154b) this.f1322f.getLayoutParams();
            i16 = 0 + c0154b.bottomMargin + c0154b.topMargin + this.f1322f.getMeasuredHeight();
        }
        if (m1114a2) {
            C0154b c0154b2 = (C0154b) this.f1323g.getLayoutParams();
            i9 = c0154b2.bottomMargin + c0154b2.topMargin + this.f1323g.getMeasuredHeight() + i16;
        } else {
            i9 = i16;
        }
        if (m1114a || m1114a2) {
            TextView textView = m1114a ? this.f1322f : this.f1323g;
            TextView textView2 = m1114a2 ? this.f1323g : this.f1322f;
            C0154b c0154b3 = (C0154b) textView.getLayoutParams();
            C0154b c0154b4 = (C0154b) textView2.getLayoutParams();
            boolean z3 = (m1114a && this.f1322f.getMeasuredWidth() > 0) || (m1114a2 && this.f1323g.getMeasuredWidth() > 0);
            switch (this.f1340x & 112) {
                case 48:
                    i10 = c0154b3.topMargin + getPaddingTop() + this.f1335s;
                    break;
                case 80:
                    i10 = (((height - paddingBottom) - c0154b4.bottomMargin) - this.f1336t) - i9;
                    break;
                default:
                    int i17 = (((height - paddingTop) - paddingBottom) - i9) / 2;
                    if (i17 < c0154b3.topMargin + this.f1335s) {
                        max = c0154b3.topMargin + this.f1335s;
                    } else {
                        int i18 = (((height - paddingBottom) - i9) - i17) - paddingTop;
                        max = i18 < c0154b3.bottomMargin + this.f1336t ? Math.max(0, i17 - ((c0154b4.bottomMargin + this.f1336t) - i18)) : i17;
                    }
                    i10 = paddingTop + max;
                    break;
            }
            if (z2) {
                int i19 = (z3 ? this.f1333q : 0) - iArr[1];
                int max3 = i7 - Math.max(0, i19);
                iArr[1] = Math.max(0, -i19);
                if (m1114a) {
                    C0154b c0154b5 = (C0154b) this.f1322f.getLayoutParams();
                    int measuredWidth = max3 - this.f1322f.getMeasuredWidth();
                    int measuredHeight = this.f1322f.getMeasuredHeight() + i10;
                    this.f1322f.layout(measuredWidth, i10, max3, measuredHeight);
                    int i20 = measuredWidth - this.f1334r;
                    i10 = measuredHeight + c0154b5.bottomMargin;
                    i13 = i20;
                } else {
                    i13 = max3;
                }
                if (m1114a2) {
                    C0154b c0154b6 = (C0154b) this.f1323g.getLayoutParams();
                    int i21 = c0154b6.topMargin + i10;
                    int measuredWidth2 = max3 - this.f1323g.getMeasuredWidth();
                    int measuredHeight2 = this.f1323g.getMeasuredHeight() + i21;
                    this.f1323g.layout(measuredWidth2, i21, max3, measuredHeight2);
                    int i22 = max3 - this.f1334r;
                    int i23 = c0154b6.bottomMargin + measuredHeight2;
                    i14 = i22;
                } else {
                    i14 = max3;
                }
                i7 = z3 ? Math.min(i13, i14) : max3;
            } else {
                int i24 = (z3 ? this.f1333q : 0) - iArr[0];
                i8 += Math.max(0, i24);
                iArr[0] = Math.max(0, -i24);
                if (m1114a) {
                    C0154b c0154b7 = (C0154b) this.f1322f.getLayoutParams();
                    int measuredWidth3 = this.f1322f.getMeasuredWidth() + i8;
                    int measuredHeight3 = this.f1322f.getMeasuredHeight() + i10;
                    this.f1322f.layout(i8, i10, measuredWidth3, measuredHeight3);
                    int i25 = measuredWidth3 + this.f1334r;
                    int i26 = c0154b7.bottomMargin + measuredHeight3;
                    i11 = i25;
                    i10 = i26;
                } else {
                    i11 = i8;
                }
                if (m1114a2) {
                    C0154b c0154b8 = (C0154b) this.f1323g.getLayoutParams();
                    int i27 = c0154b8.topMargin + i10;
                    int measuredWidth4 = this.f1323g.getMeasuredWidth() + i8;
                    int measuredHeight4 = this.f1323g.getMeasuredHeight() + i27;
                    this.f1323g.layout(i8, i27, measuredWidth4, measuredHeight4);
                    int i28 = this.f1334r + measuredWidth4;
                    int i29 = c0154b8.bottomMargin + measuredHeight4;
                    i12 = i28;
                } else {
                    i12 = i8;
                }
                if (z3) {
                    i8 = Math.max(i11, i12);
                }
            }
        }
        m1113a(this.f1306E, 3);
        int size = this.f1306E.size();
        int i30 = i8;
        for (int i31 = 0; i31 < size; i31++) {
            i30 = m1109a(this.f1306E.get(i31), i30, iArr, min);
        }
        m1113a(this.f1306E, 5);
        int size2 = this.f1306E.size();
        for (int i32 = 0; i32 < size2; i32++) {
            i7 = m1117b(this.f1306E.get(i32), i7, iArr, min);
        }
        m1113a(this.f1306E, 1);
        int m1110a = m1110a(this.f1306E, iArr);
        int i33 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (m1110a / 2);
        int i34 = m1110a + i33;
        if (i33 < i30) {
            i33 = i30;
        } else if (i34 > i7) {
            i33 -= i34 - i7;
        }
        int size3 = this.f1306E.size();
        int i35 = i33;
        for (int i36 = 0; i36 < size3; i36++) {
            i35 = m1109a(this.f1306E.get(i36), i35, iArr, min);
        }
        this.f1306E.clear();
    }

    /* renamed from: a */
    private int m1110a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = list.get(i3);
            C0154b c0154b = (C0154b) view.getLayoutParams();
            int i7 = c0154b.leftMargin - i6;
            int i8 = c0154b.rightMargin - i5;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            i6 = Math.max(0, -i7);
            i5 = Math.max(0, -i8);
            i3++;
            i4 += view.getMeasuredWidth() + max + max2;
        }
        return i4;
    }

    /* renamed from: a */
    private int m1109a(View view, int i, int[] iArr, int i2) {
        C0154b c0154b = (C0154b) view.getLayoutParams();
        int i3 = c0154b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int m1107a = m1107a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, m1107a, max + measuredWidth, view.getMeasuredHeight() + m1107a);
        return c0154b.rightMargin + measuredWidth + max;
    }

    /* renamed from: b */
    private int m1117b(View view, int i, int[] iArr, int i2) {
        C0154b c0154b = (C0154b) view.getLayoutParams();
        int i3 = c0154b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int m1107a = m1107a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, m1107a, max, view.getMeasuredHeight() + m1107a);
        return max - (c0154b.leftMargin + measuredWidth);
    }

    /* renamed from: a */
    private int m1107a(View view, int i) {
        int max;
        C0154b c0154b = (C0154b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m1115b(c0154b.f544a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0154b.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < c0154b.topMargin) {
                    max = c0154b.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    max = i4 < c0154b.bottomMargin ? Math.max(0, i3 - (c0154b.bottomMargin - i4)) : i3;
                }
                return max + paddingTop;
        }
    }

    /* renamed from: b */
    private int m1115b(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f1340x & 112;
        }
    }

    /* renamed from: a */
    private void m1113a(List<View> list, int i) {
        boolean z = C0308x.m2257f(this) == 1;
        int childCount = getChildCount();
        int m2167a = C0289e.m2167a(i, C0308x.m2257f(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                C0154b c0154b = (C0154b) childAt.getLayoutParams();
                if (c0154b.f1349b == 0 && m1114a(childAt) && m1118c(c0154b.f544a) == m2167a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C0154b c0154b2 = (C0154b) childAt2.getLayoutParams();
            if (c0154b2.f1349b == 0 && m1114a(childAt2) && m1118c(c0154b2.f544a) == m2167a) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: c */
    private int m1118c(int i) {
        int m2257f = C0308x.m2257f(this);
        int m2167a = C0289e.m2167a(i, m2257f) & 7;
        switch (m2167a) {
            case 1:
            case 3:
            case 5:
                return m2167a;
            case 2:
            case 4:
            default:
                return m2257f == 1 ? 5 : 3;
        }
    }

    /* renamed from: a */
    private boolean m1114a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: b */
    private int m1116b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0292h.m2177b(marginLayoutParams) + C0292h.m2176a(marginLayoutParams);
    }

    /* renamed from: c */
    private int m1119c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0154b generateLayoutParams(AttributeSet attributeSet) {
        return new C0154b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0154b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0154b) {
            return new C0154b((C0154b) layoutParams);
        }
        if (layoutParams instanceof AbstractC0069a.a) {
            return new C0154b((AbstractC0069a.a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0154b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0154b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0154b generateDefaultLayoutParams() {
        return new C0154b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0154b);
    }

    public InterfaceC0164af getWrapper() {
        if (this.f1310I == null) {
            this.f1310I = new C0186ba(this, true);
        }
        return this.f1310I;
    }

    /* renamed from: k */
    void m1147k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((C0154b) childAt.getLayoutParams()).f1349b != 2 && childAt != this.f1321e) {
                removeViewAt(childCount);
                this.f1307F.add(childAt);
            }
        }
    }

    /* renamed from: l */
    void m1148l() {
        for (int size = this.f1307F.size() - 1; size >= 0; size--) {
            addView(this.f1307F.get(size));
        }
        this.f1307F.clear();
    }

    /* renamed from: d */
    private boolean m1120d(View view) {
        return view.getParent() == this || this.f1307F.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f1315N = z;
        requestLayout();
    }

    /* renamed from: a */
    public void m1134a(InterfaceC0112m.a aVar, C0106g.a aVar2) {
        this.f1313L = aVar;
        this.f1314M = aVar2;
        if (this.f1321e != null) {
            this.f1321e.m1017a(aVar, aVar2);
        }
    }

    /* renamed from: s */
    private void m1127s() {
        if (this.f1337u == null) {
            this.f1337u = new C0176ar();
        }
    }

    final TextView getTitleTextView() {
        return this.f1322f;
    }

    final TextView getSubtitleTextView() {
        return this.f1323g;
    }

    C0193c getOuterActionMenuPresenter() {
        return this.f1311J;
    }

    Context getPopupContext() {
        return this.f1328l;
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$b */
    public static class C0154b extends AbstractC0069a.a {

        /* renamed from: b */
        int f1349b;

        public C0154b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1349b = 0;
        }

        public C0154b(int i, int i2) {
            super(i, i2);
            this.f1349b = 0;
            this.f544a = 8388627;
        }

        public C0154b(C0154b c0154b) {
            super((AbstractC0069a.a) c0154b);
            this.f1349b = 0;
            this.f1349b = c0154b.f1349b;
        }

        public C0154b(AbstractC0069a.a aVar) {
            super(aVar);
            this.f1349b = 0;
        }

        public C0154b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1349b = 0;
            m1149a(marginLayoutParams);
        }

        public C0154b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1349b = 0;
        }

        /* renamed from: a */
        void m1149a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$d */
    public static class C0156d extends AbstractC0223a {
        public static final Parcelable.Creator<C0156d> CREATOR = new Parcelable.ClassLoaderCreator<C0156d>() { // from class: androidx.appcompat.widget.Toolbar.d.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0156d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0156d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0156d createFromParcel(Parcel parcel) {
                return new C0156d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0156d[] newArray(int i) {
                return new C0156d[i];
            }
        };

        /* renamed from: a */
        int f1350a;

        /* renamed from: b */
        boolean f1351b;

        public C0156d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1350a = parcel.readInt();
            this.f1351b = parcel.readInt() != 0;
        }

        public C0156d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.p021c.p022a.AbstractC0223a, android.p008os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1350a);
            parcel.writeInt(this.f1351b ? 1 : 0);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$a */
    private class C0153a implements InterfaceC0112m {

        /* renamed from: a */
        C0106g f1346a;

        /* renamed from: b */
        C0108i f1347b;

        C0153a() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public void mo810a(Context context, C0106g c0106g) {
            if (this.f1346a != null && this.f1347b != null) {
                this.f1346a.mo899d(this.f1347b);
            }
            this.f1346a = c0106g;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public void mo815a(boolean z) {
            boolean z2 = false;
            if (this.f1347b != null) {
                if (this.f1346a != null) {
                    int size = this.f1346a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f1346a.getItem(i) != this.f1347b) {
                            i++;
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (!z2) {
                    mo822b(this.f1346a, this.f1347b);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public void mo814a(InterfaceC0112m.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public boolean mo819a(SubMenuC0117r subMenuC0117r) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public void mo812a(C0106g c0106g, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: b */
        public boolean mo821b() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: a */
        public boolean mo818a(C0106g c0106g, C0108i c0108i) {
            Toolbar.this.m1145i();
            ViewParent parent = Toolbar.this.f1317a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.f1317a);
                }
                Toolbar.this.addView(Toolbar.this.f1317a);
            }
            Toolbar.this.f1318b = c0108i.getActionView();
            this.f1347b = c0108i;
            ViewParent parent2 = Toolbar.this.f1318b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.f1318b);
                }
                C0154b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f544a = 8388611 | (Toolbar.this.f1319c & 112);
                generateDefaultLayoutParams.f1349b = 2;
                Toolbar.this.f1318b.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f1318b);
            }
            Toolbar.this.m1147k();
            Toolbar.this.requestLayout();
            c0108i.m934e(true);
            if (Toolbar.this.f1318b instanceof InterfaceC0091c) {
                ((InterfaceC0091c) Toolbar.this.f1318b).mo749a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0112m
        /* renamed from: b */
        public boolean mo822b(C0106g c0106g, C0108i c0108i) {
            if (Toolbar.this.f1318b instanceof InterfaceC0091c) {
                ((InterfaceC0091c) Toolbar.this.f1318b).mo750b();
            }
            Toolbar.this.removeView(Toolbar.this.f1318b);
            Toolbar.this.removeView(Toolbar.this.f1317a);
            Toolbar.this.f1318b = null;
            Toolbar.this.m1148l();
            this.f1347b = null;
            Toolbar.this.requestLayout();
            c0108i.m934e(false);
            return true;
        }
    }
}
