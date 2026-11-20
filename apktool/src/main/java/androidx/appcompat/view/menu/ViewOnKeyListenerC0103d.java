package androidx.appcompat.view.menu;

import android.C0012R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.widget.C0172an;
import androidx.appcompat.widget.InterfaceC0171am;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CascadingMenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.d */
/* loaded from: classes.dex */
final class ViewOnKeyListenerC0103d extends AbstractC0110k implements View.OnKeyListener, PopupWindow.OnDismissListener, InterfaceC0112m {

    /* renamed from: g */
    private static final int f942g = C0059a.g.abc_cascading_menu_item_layout;

    /* renamed from: A */
    private PopupWindow.OnDismissListener f943A;

    /* renamed from: a */
    final Handler f944a;

    /* renamed from: d */
    View f947d;

    /* renamed from: e */
    ViewTreeObserver f948e;

    /* renamed from: f */
    boolean f949f;

    /* renamed from: h */
    private final Context f950h;

    /* renamed from: i */
    private final int f951i;

    /* renamed from: j */
    private final int f952j;

    /* renamed from: k */
    private final int f953k;

    /* renamed from: l */
    private final boolean f954l;

    /* renamed from: r */
    private View f960r;

    /* renamed from: t */
    private boolean f962t;

    /* renamed from: u */
    private boolean f963u;

    /* renamed from: v */
    private int f964v;

    /* renamed from: w */
    private int f965w;

    /* renamed from: y */
    private boolean f967y;

    /* renamed from: z */
    private InterfaceC0112m.a f968z;

    /* renamed from: m */
    private final List<C0106g> f955m = new ArrayList();

    /* renamed from: b */
    final List<a> f945b = new ArrayList();

    /* renamed from: c */
    final ViewTreeObserver.OnGlobalLayoutListener f946c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.d.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ViewOnKeyListenerC0103d.this.mo845d() && ViewOnKeyListenerC0103d.this.f945b.size() > 0 && !ViewOnKeyListenerC0103d.this.f945b.get(0).f976a.m1329i()) {
                View view = ViewOnKeyListenerC0103d.this.f947d;
                if (view == null || !view.isShown()) {
                    ViewOnKeyListenerC0103d.this.mo842c();
                    return;
                }
                Iterator<a> it = ViewOnKeyListenerC0103d.this.f945b.iterator();
                while (it.hasNext()) {
                    it.next().f976a.mo841b_();
                }
            }
        }
    };

    /* renamed from: n */
    private final View.OnAttachStateChangeListener f956n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.d.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC0103d.this.f948e != null) {
                if (!ViewOnKeyListenerC0103d.this.f948e.isAlive()) {
                    ViewOnKeyListenerC0103d.this.f948e = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0103d.this.f948e.removeGlobalOnLayoutListener(ViewOnKeyListenerC0103d.this.f946c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: o */
    private final InterfaceC0171am f957o = new InterfaceC0171am() { // from class: androidx.appcompat.view.menu.d.3
        @Override // androidx.appcompat.widget.InterfaceC0171am
        /* renamed from: a */
        public void mo848a(C0106g c0106g, MenuItem menuItem) {
            ViewOnKeyListenerC0103d.this.f944a.removeCallbacksAndMessages(c0106g);
        }

        @Override // androidx.appcompat.widget.InterfaceC0171am
        /* renamed from: b */
        public void mo849b(final C0106g c0106g, final MenuItem menuItem) {
            int i;
            ViewOnKeyListenerC0103d.this.f944a.removeCallbacksAndMessages(null);
            int i2 = 0;
            int size = ViewOnKeyListenerC0103d.this.f945b.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                } else {
                    if (c0106g == ViewOnKeyListenerC0103d.this.f945b.get(i2).f977b) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i != -1) {
                int i3 = i + 1;
                final a aVar = i3 < ViewOnKeyListenerC0103d.this.f945b.size() ? ViewOnKeyListenerC0103d.this.f945b.get(i3) : null;
                ViewOnKeyListenerC0103d.this.f944a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            ViewOnKeyListenerC0103d.this.f949f = true;
                            aVar.f977b.m882a(false);
                            ViewOnKeyListenerC0103d.this.f949f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            c0106g.m883a(menuItem, 4);
                        }
                    }
                }, c0106g, SystemClock.uptimeMillis() + 200);
            }
        }
    };

    /* renamed from: p */
    private int f958p = 0;

    /* renamed from: q */
    private int f959q = 0;

    /* renamed from: x */
    private boolean f966x = false;

    /* renamed from: s */
    private int f961s = m834i();

    public ViewOnKeyListenerC0103d(Context context, View view, int i, int i2, boolean z) {
        this.f950h = context;
        this.f960r = view;
        this.f952j = i;
        this.f953k = i2;
        this.f954l = z;
        Resources resources = context.getResources();
        this.f951i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0059a.d.abc_config_prefDialogWidth));
        this.f944a = new Handler();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: b */
    public void mo840b(boolean z) {
        this.f966x = z;
    }

    /* renamed from: h */
    private C0172an m833h() {
        C0172an c0172an = new C0172an(this.f950h, null, this.f952j, this.f953k);
        c0172an.m1335a(this.f957o);
        c0172an.m1313a((AdapterView.OnItemClickListener) this);
        c0172an.m1315a((PopupWindow.OnDismissListener) this);
        c0172an.m1320b(this.f960r);
        c0172an.m1325f(this.f959q);
        c0172an.m1316a(true);
        c0172an.m1328i(2);
        return c0172an;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: b_ */
    public void mo841b_() {
        if (!mo845d()) {
            Iterator<C0106g> it = this.f955m.iterator();
            while (it.hasNext()) {
                m830c(it.next());
            }
            this.f955m.clear();
            this.f947d = this.f960r;
            if (this.f947d != null) {
                boolean z = this.f948e == null;
                this.f948e = this.f947d.getViewTreeObserver();
                if (z) {
                    this.f948e.addOnGlobalLayoutListener(this.f946c);
                }
                this.f947d.addOnAttachStateChangeListener(this.f956n);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: c */
    public void mo842c() {
        int size = this.f945b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f945b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f976a.mo845d()) {
                    aVar.f976a.mo842c();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo842c();
        return true;
    }

    /* renamed from: i */
    private int m834i() {
        return C0308x.m2257f(this.f960r) == 1 ? 0 : 1;
    }

    /* renamed from: d */
    private int m831d(int i) {
        ListView m850a = this.f945b.get(this.f945b.size() - 1).m850a();
        int[] iArr = new int[2];
        m850a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f947d.getWindowVisibleDisplayFrame(rect);
        if (this.f961s == 1) {
            return (m850a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo838a(C0106g c0106g) {
        c0106g.m880a(this, this.f950h);
        if (mo845d()) {
            m830c(c0106g);
        } else {
            this.f955m.add(c0106g);
        }
    }

    /* renamed from: c */
    private void m830c(C0106g c0106g) {
        View view;
        a aVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f950h);
        C0105f c0105f = new C0105f(c0106g, from, this.f954l, f942g);
        if (!mo845d() && this.f966x) {
            c0105f.m857a(true);
        } else if (mo845d()) {
            c0105f.m857a(AbstractC0110k.m957b(c0106g));
        }
        int a2 = m955a(c0105f, null, this.f950h, this.f951i);
        C0172an m833h = m833h();
        m833h.mo1314a((ListAdapter) c0105f);
        m833h.m1327h(a2);
        m833h.m1325f(this.f959q);
        if (this.f945b.size() > 0) {
            a aVar2 = this.f945b.get(this.f945b.size() - 1);
            view = m829a(aVar2, c0106g);
            aVar = aVar2;
        } else {
            view = null;
            aVar = null;
        }
        if (view != null) {
            m833h.m1338c(false);
            m833h.m1336a((Object) null);
            int m831d = m831d(a2);
            boolean z = m831d == 1;
            this.f961s = m831d;
            if (Build.VERSION.SDK_INT >= 26) {
                m833h.m1320b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f960r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f959q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f960r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f959q & 5) == 5) {
                if (z) {
                    i3 = i + a2;
                } else {
                    i3 = i - view.getWidth();
                }
            } else if (z) {
                i3 = view.getWidth() + i;
            } else {
                i3 = i - a2;
            }
            m833h.m1319b(i3);
            m833h.m1321b(true);
            m833h.m1310a(i2);
        } else {
            if (this.f962t) {
                m833h.m1319b(this.f964v);
            }
            if (this.f963u) {
                m833h.m1310a(this.f965w);
            }
            m833h.m1311a(m959g());
        }
        this.f945b.add(new a(m833h, c0106g, this.f961s));
        m833h.mo841b_();
        ListView e2 = m833h.mo846e();
        e2.setOnKeyListener(this);
        if (aVar == null && this.f967y && c0106g.m910n() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0059a.g.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(C0012R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(c0106g.m910n());
            e2.addHeaderView(frameLayout, null, false);
            m833h.mo841b_();
        }
    }

    /* renamed from: a */
    private MenuItem m828a(C0106g c0106g, C0106g c0106g2) {
        int size = c0106g.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0106g.getItem(i);
            if (item.hasSubMenu() && c0106g2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m829a(a aVar, C0106g c0106g) {
        C0105f c0105f;
        int i;
        int i2;
        int i3 = 0;
        MenuItem m828a = m828a(aVar.f977b, c0106g);
        if (m828a == null) {
            return null;
        }
        ListView m850a = aVar.m850a();
        ListAdapter adapter = m850a.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            c0105f = (C0105f) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0105f = (C0105f) adapter;
            i = 0;
        }
        int count = c0105f.getCount();
        while (true) {
            if (i3 >= count) {
                i2 = -1;
                break;
            }
            if (m828a == c0105f.getItem(i3)) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 == -1) {
            return null;
        }
        int firstVisiblePosition = (i2 + i) - m850a.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= m850a.getChildCount()) {
            return null;
        }
        return m850a.getChildAt(firstVisiblePosition);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: d */
    public boolean mo845d() {
        return this.f945b.size() > 0 && this.f945b.get(0).f976a.mo845d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.f945b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f945b.get(i);
            if (!aVar.f976a.mo845d()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.f977b.m882a(false);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo815a(boolean z) {
        Iterator<a> it = this.f945b.iterator();
        while (it.hasNext()) {
            m956a(it.next().m850a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo814a(InterfaceC0112m.a aVar) {
        this.f968z = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo819a(SubMenuC0117r subMenuC0117r) {
        for (a aVar : this.f945b) {
            if (subMenuC0117r == aVar.f977b) {
                aVar.m850a().requestFocus();
                return true;
            }
        }
        if (subMenuC0117r.hasVisibleItems()) {
            mo838a((C0106g) subMenuC0117r);
            if (this.f968z != null) {
                this.f968z.mo559a(subMenuC0117r);
            }
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private int m832d(C0106g c0106g) {
        int size = this.f945b.size();
        for (int i = 0; i < size; i++) {
            if (c0106g == this.f945b.get(i).f977b) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo812a(C0106g c0106g, boolean z) {
        int m832d = m832d(c0106g);
        if (m832d >= 0) {
            int i = m832d + 1;
            if (i < this.f945b.size()) {
                this.f945b.get(i).f977b.m882a(false);
            }
            a remove = this.f945b.remove(m832d);
            remove.f977b.m889b(this);
            if (this.f949f) {
                remove.f976a.m1337b((Object) null);
                remove.f976a.m1323e(0);
            }
            remove.f976a.mo842c();
            int size = this.f945b.size();
            if (size > 0) {
                this.f961s = this.f945b.get(size - 1).f978c;
            } else {
                this.f961s = m834i();
            }
            if (size == 0) {
                mo842c();
                if (this.f968z != null) {
                    this.f968z.mo558a(c0106g, true);
                }
                if (this.f948e != null) {
                    if (this.f948e.isAlive()) {
                        this.f948e.removeGlobalOnLayoutListener(this.f946c);
                    }
                    this.f948e = null;
                }
                this.f947d.removeOnAttachStateChangeListener(this.f956n);
                this.f943A.onDismiss();
                return;
            }
            if (z) {
                this.f945b.get(0).f977b.m882a(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo821b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo835a(int i) {
        if (this.f958p != i) {
            this.f958p = i;
            this.f959q = C0289e.m2167a(i, C0308x.m2257f(this.f960r));
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo836a(View view) {
        if (this.f960r != view) {
            this.f960r = view;
            this.f959q = C0289e.m2167a(this.f958p, C0308x.m2257f(this.f960r));
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: a */
    public void mo837a(PopupWindow.OnDismissListener onDismissListener) {
        this.f943A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0115p
    /* renamed from: e */
    public ListView mo846e() {
        if (this.f945b.isEmpty()) {
            return null;
        }
        return this.f945b.get(this.f945b.size() - 1).m850a();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: b */
    public void mo839b(int i) {
        this.f962t = true;
        this.f964v = i;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: c */
    public void mo843c(int i) {
        this.f963u = true;
        this.f965w = i;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: c */
    public void mo844c(boolean z) {
        this.f967y = z;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0110k
    /* renamed from: f */
    protected boolean mo847f() {
        return false;
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.d$a */
    private static class a {

        /* renamed from: a */
        public final C0172an f976a;

        /* renamed from: b */
        public final C0106g f977b;

        /* renamed from: c */
        public final int f978c;

        public a(C0172an c0172an, C0106g c0106g, int i) {
            this.f976a = c0172an;
            this.f977b = c0106g;
            this.f978c = i;
        }

        /* renamed from: a */
        public ListView m850a() {
            return this.f976a.mo846e();
        }
    }
}
