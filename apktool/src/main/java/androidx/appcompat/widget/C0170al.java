package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.p008os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0115p;
import androidx.core.p031f.C0308x;
import androidx.core.widget.C0338h;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* renamed from: androidx.appcompat.widget.al */
/* loaded from: classes.dex */
public class C0170al implements InterfaceC0115p {

    /* renamed from: a */
    private static Method f1456a;

    /* renamed from: b */
    private static Method f1457b;

    /* renamed from: h */
    private static Method f1458h;

    /* renamed from: A */
    private AdapterView.OnItemClickListener f1459A;

    /* renamed from: B */
    private AdapterView.OnItemSelectedListener f1460B;

    /* renamed from: C */
    private final d f1461C;

    /* renamed from: D */
    private final c f1462D;

    /* renamed from: E */
    private final a f1463E;

    /* renamed from: F */
    private Runnable f1464F;

    /* renamed from: G */
    private final Rect f1465G;

    /* renamed from: H */
    private Rect f1466H;

    /* renamed from: I */
    private boolean f1467I;

    /* renamed from: c */
    C0166ah f1468c;

    /* renamed from: d */
    int f1469d;

    /* renamed from: e */
    final e f1470e;

    /* renamed from: f */
    final Handler f1471f;

    /* renamed from: g */
    PopupWindow f1472g;

    /* renamed from: i */
    private Context f1473i;

    /* renamed from: j */
    private ListAdapter f1474j;

    /* renamed from: k */
    private int f1475k;

    /* renamed from: l */
    private int f1476l;

    /* renamed from: m */
    private int f1477m;

    /* renamed from: n */
    private int f1478n;

    /* renamed from: o */
    private int f1479o;

    /* renamed from: p */
    private boolean f1480p;

    /* renamed from: q */
    private boolean f1481q;

    /* renamed from: r */
    private boolean f1482r;

    /* renamed from: s */
    private int f1483s;

    /* renamed from: t */
    private boolean f1484t;

    /* renamed from: u */
    private boolean f1485u;

    /* renamed from: v */
    private View f1486v;

    /* renamed from: w */
    private int f1487w;

    /* renamed from: x */
    private DataSetObserver f1488x;

    /* renamed from: y */
    private View f1489y;

    /* renamed from: z */
    private Drawable f1490z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1456a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e2) {
                Log.m186i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f1458h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException e3) {
                Log.m186i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f1457b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException e4) {
                Log.m186i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public C0170al(Context context) {
        this(context, null, C0059a.a.listPopupWindowStyle);
    }

    public C0170al(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C0170al(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1475k = -2;
        this.f1476l = -2;
        this.f1479o = 1002;
        this.f1483s = 0;
        this.f1484t = false;
        this.f1485u = false;
        this.f1469d = Integer.MAX_VALUE;
        this.f1487w = 0;
        this.f1470e = new e();
        this.f1461C = new d();
        this.f1462D = new c();
        this.f1463E = new a();
        this.f1465G = new Rect();
        this.f1473i = context;
        this.f1471f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ListPopupWindow, i, i2);
        this.f1477m = obtainStyledAttributes.getDimensionPixelOffset(C0059a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1478n = obtainStyledAttributes.getDimensionPixelOffset(C0059a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1478n != 0) {
            this.f1480p = true;
        }
        obtainStyledAttributes.recycle();
        this.f1472g = new C0208r(context, attributeSet, i, i2);
        this.f1472g.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo1314a(ListAdapter listAdapter) {
        if (this.f1488x == null) {
            this.f1488x = new b();
        } else if (this.f1474j != null) {
            this.f1474j.unregisterDataSetObserver(this.f1488x);
        }
        this.f1474j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1488x);
        }
        if (this.f1468c != null) {
            this.f1468c.setAdapter(this.f1474j);
        }
    }

    /* renamed from: d */
    public void m1322d(int i) {
        this.f1487w = i;
    }

    /* renamed from: a */
    public void m1316a(boolean z) {
        this.f1467I = z;
        this.f1472g.setFocusable(z);
    }

    /* renamed from: i */
    public boolean m1329i() {
        return this.f1467I;
    }

    /* renamed from: b */
    public Drawable m1318b() {
        return this.f1472g.getBackground();
    }

    /* renamed from: a */
    public void m1312a(Drawable drawable) {
        this.f1472g.setBackgroundDrawable(drawable);
    }

    /* renamed from: e */
    public void m1323e(int i) {
        this.f1472g.setAnimationStyle(i);
    }

    /* renamed from: j */
    public View m1330j() {
        return this.f1489y;
    }

    /* renamed from: b */
    public void m1320b(View view) {
        this.f1489y = view;
    }

    /* renamed from: f */
    public int m1324f() {
        return this.f1477m;
    }

    /* renamed from: b */
    public void m1319b(int i) {
        this.f1477m = i;
    }

    /* renamed from: a_ */
    public int m1317a_() {
        if (this.f1480p) {
            return this.f1478n;
        }
        return 0;
    }

    /* renamed from: a */
    public void m1310a(int i) {
        this.f1478n = i;
        this.f1480p = true;
    }

    /* renamed from: a */
    public void m1311a(Rect rect) {
        this.f1466H = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: f */
    public void m1325f(int i) {
        this.f1483s = i;
    }

    /* renamed from: k */
    public int m1332k() {
        return this.f1476l;
    }

    /* renamed from: g */
    public void m1326g(int i) {
        this.f1476l = i;
    }

    /* renamed from: h */
    public void m1327h(int i) {
        Drawable background = this.f1472g.getBackground();
        if (background != null) {
            background.getPadding(this.f1465G);
            this.f1476l = this.f1465G.left + this.f1465G.right + i;
        } else {
            m1326g(i);
        }
    }

    /* renamed from: a */
    public void m1313a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1459A = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: b_ */
    public void mo841b_() {
        int i;
        int i2;
        int i3;
        boolean z = false;
        int m1308h = m1308h();
        boolean m1334m = m1334m();
        C0338h.m2506a(this.f1472g, this.f1479o);
        if (this.f1472g.isShowing()) {
            if (C0308x.m2276w(m1330j())) {
                if (this.f1476l == -1) {
                    i2 = -1;
                } else if (this.f1476l == -2) {
                    i2 = m1330j().getWidth();
                } else {
                    i2 = this.f1476l;
                }
                if (this.f1475k == -1) {
                    if (!m1334m) {
                        m1308h = -1;
                    }
                    if (m1334m) {
                        this.f1472g.setWidth(this.f1476l == -1 ? -1 : 0);
                        this.f1472g.setHeight(0);
                        i3 = m1308h;
                    } else {
                        this.f1472g.setWidth(this.f1476l == -1 ? -1 : 0);
                        this.f1472g.setHeight(-1);
                        i3 = m1308h;
                    }
                } else {
                    i3 = this.f1475k == -2 ? m1308h : this.f1475k;
                }
                PopupWindow popupWindow = this.f1472g;
                if (!this.f1485u && !this.f1484t) {
                    z = true;
                }
                popupWindow.setOutsideTouchable(z);
                PopupWindow popupWindow2 = this.f1472g;
                View m1330j = m1330j();
                int i4 = this.f1477m;
                int i5 = this.f1478n;
                if (i2 < 0) {
                    i2 = -1;
                }
                popupWindow2.update(m1330j, i4, i5, i2, i3 >= 0 ? i3 : -1);
                return;
            }
            return;
        }
        if (this.f1476l == -1) {
            i = -1;
        } else if (this.f1476l == -2) {
            i = m1330j().getWidth();
        } else {
            i = this.f1476l;
        }
        if (this.f1475k == -1) {
            m1308h = -1;
        } else if (this.f1475k != -2) {
            m1308h = this.f1475k;
        }
        this.f1472g.setWidth(i);
        this.f1472g.setHeight(m1308h);
        m1306c(true);
        this.f1472g.setOutsideTouchable((this.f1485u || this.f1484t) ? false : true);
        this.f1472g.setTouchInterceptor(this.f1461C);
        if (this.f1482r) {
            C0338h.m2508a(this.f1472g, this.f1481q);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (f1458h != null) {
                try {
                    f1458h.invoke(this.f1472g, this.f1466H);
                } catch (Exception e2) {
                    Log.m185e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.f1472g.setEpicenterBounds(this.f1466H);
        }
        C0338h.m2507a(this.f1472g, m1330j(), this.f1477m, this.f1478n, this.f1483s);
        this.f1468c.setSelection(-1);
        if (!this.f1467I || this.f1468c.isInTouchMode()) {
            m1333l();
        }
        if (!this.f1467I) {
            this.f1471f.post(this.f1463E);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: c */
    public void mo842c() {
        this.f1472g.dismiss();
        m1307g();
        this.f1472g.setContentView(null);
        this.f1468c = null;
        this.f1471f.removeCallbacks(this.f1470e);
    }

    /* renamed from: a */
    public void m1315a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1472g.setOnDismissListener(onDismissListener);
    }

    /* renamed from: g */
    private void m1307g() {
        if (this.f1486v != null) {
            ViewParent parent = this.f1486v.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1486v);
            }
        }
    }

    /* renamed from: i */
    public void m1328i(int i) {
        this.f1472g.setInputMethodMode(i);
    }

    /* renamed from: j */
    public void m1331j(int i) {
        C0166ah c0166ah = this.f1468c;
        if (mo845d() && c0166ah != null) {
            c0166ah.setListSelectionHidden(false);
            c0166ah.setSelection(i);
            if (c0166ah.getChoiceMode() != 0) {
                c0166ah.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: l */
    public void m1333l() {
        C0166ah c0166ah = this.f1468c;
        if (c0166ah != null) {
            c0166ah.setListSelectionHidden(true);
            c0166ah.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: d */
    public boolean mo845d() {
        return this.f1472g.isShowing();
    }

    /* renamed from: m */
    public boolean m1334m() {
        return this.f1472g.getInputMethodMode() == 2;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: e */
    public ListView mo846e() {
        return this.f1468c;
    }

    /* renamed from: a */
    C0166ah mo1309a(Context context, boolean z) {
        return new C0166ah(context, z);
    }

    /* renamed from: h */
    private int m1308h() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        int i4;
        int i5;
        if (this.f1468c == null) {
            Context context = this.f1473i;
            this.f1464F = new Runnable() { // from class: androidx.appcompat.widget.al.1
                @Override // java.lang.Runnable
                public void run() {
                    View m1330j = C0170al.this.m1330j();
                    if (m1330j != null && m1330j.getWindowToken() != null) {
                        C0170al.this.mo841b_();
                    }
                }
            };
            this.f1468c = mo1309a(context, !this.f1467I);
            if (this.f1490z != null) {
                this.f1468c.setSelector(this.f1490z);
            }
            this.f1468c.setAdapter(this.f1474j);
            this.f1468c.setOnItemClickListener(this.f1459A);
            this.f1468c.setFocusable(true);
            this.f1468c.setFocusableInTouchMode(true);
            this.f1468c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.al.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j) {
                    C0166ah c0166ah;
                    if (i6 != -1 && (c0166ah = C0170al.this.f1468c) != null) {
                        c0166ah.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f1468c.setOnScrollListener(this.f1462D);
            if (this.f1460B != null) {
                this.f1468c.setOnItemSelectedListener(this.f1460B);
            }
            View view = this.f1468c;
            View view2 = this.f1486v;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f1487w) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.m184e("ListPopupWindow", "Invalid hint position " + this.f1487w);
                        break;
                }
                if (this.f1476l >= 0) {
                    i5 = this.f1476l;
                    i4 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i3 = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                i3 = 0;
            }
            this.f1472g.setContentView(view);
            i = i3;
        } else {
            View view3 = this.f1486v;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f1472g.getBackground();
        if (background != null) {
            background.getPadding(this.f1465G);
            int i6 = this.f1465G.top + this.f1465G.bottom;
            if (this.f1480p) {
                i2 = i6;
            } else {
                this.f1478n = -this.f1465G.top;
                i2 = i6;
            }
        } else {
            this.f1465G.setEmpty();
            i2 = 0;
        }
        int m1305a = m1305a(m1330j(), this.f1478n, this.f1472g.getInputMethodMode() == 2);
        if (this.f1484t || this.f1475k == -1) {
            return m1305a + i2;
        }
        switch (this.f1476l) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1473i.getResources().getDisplayMetrics().widthPixels - (this.f1465G.left + this.f1465G.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1473i.getResources().getDisplayMetrics().widthPixels - (this.f1465G.left + this.f1465G.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1476l, 1073741824);
                break;
        }
        int mo1274a = this.f1468c.mo1274a(makeMeasureSpec, 0, -1, m1305a - i, -1);
        if (mo1274a > 0) {
            i += this.f1468c.getPaddingTop() + this.f1468c.getPaddingBottom() + i2;
        }
        return mo1274a + i;
    }

    /* renamed from: b */
    public void m1321b(boolean z) {
        this.f1482r = true;
        this.f1481q = z;
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.al$b */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (C0170al.this.mo845d()) {
                C0170al.this.mo841b_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            C0170al.this.mo842c();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.al$a */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0170al.this.m1333l();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.al$e */
    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0170al.this.f1468c != null && C0308x.m2276w(C0170al.this.f1468c) && C0170al.this.f1468c.getCount() > C0170al.this.f1468c.getChildCount() && C0170al.this.f1468c.getChildCount() <= C0170al.this.f1469d) {
                C0170al.this.f1472g.setInputMethodMode(2);
                C0170al.this.mo841b_();
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.al$d */
    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && C0170al.this.f1472g != null && C0170al.this.f1472g.isShowing() && x >= 0 && x < C0170al.this.f1472g.getWidth() && y >= 0 && y < C0170al.this.f1472g.getHeight()) {
                C0170al.this.f1471f.postDelayed(C0170al.this.f1470e, 250L);
                return false;
            }
            if (action == 1) {
                C0170al.this.f1471f.removeCallbacks(C0170al.this.f1470e);
                return false;
            }
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: androidx.appcompat.widget.al$c */
    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !C0170al.this.m1334m() && C0170al.this.f1472g.getContentView() != null) {
                C0170al.this.f1471f.removeCallbacks(C0170al.this.f1470e);
                C0170al.this.f1470e.run();
            }
        }
    }

    /* renamed from: c */
    private void m1306c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            if (f1456a != null) {
                try {
                    f1456a.invoke(this.f1472g, Boolean.valueOf(z));
                    return;
                } catch (Exception e2) {
                    Log.m186i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.f1472g.setIsClippedToScreen(z);
    }

    /* renamed from: a */
    private int m1305a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            if (f1457b != null) {
                try {
                    return ((Integer) f1457b.invoke(this.f1472g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception e2) {
                    Log.m186i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.f1472g.getMaxAvailableHeight(view, i);
        }
        return this.f1472g.getMaxAvailableHeight(view, i, z);
    }
}
