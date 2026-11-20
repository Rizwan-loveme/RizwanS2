package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.C0309y;

/* compiled from: TooltipCompatHandler.java */
/* renamed from: androidx.appcompat.widget.bc */
/* loaded from: classes.dex */
class ViewOnAttachStateChangeListenerC0188bc implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* renamed from: j */
    private static ViewOnAttachStateChangeListenerC0188bc f1615j;

    /* renamed from: k */
    private static ViewOnAttachStateChangeListenerC0188bc f1616k;

    /* renamed from: a */
    private final View f1617a;

    /* renamed from: b */
    private final CharSequence f1618b;

    /* renamed from: c */
    private final int f1619c;

    /* renamed from: d */
    private final Runnable f1620d = new Runnable() { // from class: androidx.appcompat.widget.bc.1
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC0188bc.this.m1471a(false);
        }
    };

    /* renamed from: e */
    private final Runnable f1621e = new Runnable() { // from class: androidx.appcompat.widget.bc.2
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC0188bc.this.m1470a();
        }
    };

    /* renamed from: f */
    private int f1622f;

    /* renamed from: g */
    private int f1623g;

    /* renamed from: h */
    private C0189bd f1624h;

    /* renamed from: i */
    private boolean f1625i;

    /* renamed from: a */
    public static void m1464a(View view, CharSequence charSequence) {
        if (f1615j != null && f1615j.f1617a == view) {
            m1465a((ViewOnAttachStateChangeListenerC0188bc) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f1616k != null && f1616k.f1617a == view) {
                f1616k.m1470a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ViewOnAttachStateChangeListenerC0188bc(view, charSequence);
    }

    private ViewOnAttachStateChangeListenerC0188bc(View view, CharSequence charSequence) {
        this.f1617a = view;
        this.f1618b = charSequence;
        this.f1619c = C0309y.m2304a(ViewConfiguration.get(this.f1617a.getContext()));
        m1469d();
        this.f1617a.setOnLongClickListener(this);
        this.f1617a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1622f = view.getWidth() / 2;
        this.f1623g = view.getHeight() / 2;
        m1471a(true);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1624h == null || !this.f1625i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1617a.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.f1617a.isEnabled() && this.f1624h == null && m1466a(motionEvent)) {
                            m1465a(this);
                            break;
                        }
                        break;
                    case 10:
                        m1469d();
                        m1470a();
                        break;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m1470a();
    }

    /* renamed from: a */
    void m1471a(boolean z) {
        long longPressTimeout;
        if (C0308x.m2276w(this.f1617a)) {
            m1465a((ViewOnAttachStateChangeListenerC0188bc) null);
            if (f1616k != null) {
                f1616k.m1470a();
            }
            f1616k = this;
            this.f1625i = z;
            this.f1624h = new C0189bd(this.f1617a.getContext());
            this.f1624h.m1475a(this.f1617a, this.f1622f, this.f1623g, this.f1625i, this.f1618b);
            this.f1617a.addOnAttachStateChangeListener(this);
            if (this.f1625i) {
                longPressTimeout = 2500;
            } else if ((C0308x.m2266m(this.f1617a) & 1) == 1) {
                longPressTimeout = 3000 - ViewConfiguration.getLongPressTimeout();
            } else {
                longPressTimeout = 15000 - ViewConfiguration.getLongPressTimeout();
            }
            this.f1617a.removeCallbacks(this.f1621e);
            this.f1617a.postDelayed(this.f1621e, longPressTimeout);
        }
    }

    /* renamed from: a */
    void m1470a() {
        if (f1616k == this) {
            f1616k = null;
            if (this.f1624h != null) {
                this.f1624h.m1474a();
                this.f1624h = null;
                m1469d();
                this.f1617a.removeOnAttachStateChangeListener(this);
            } else {
                Log.m184e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1615j == this) {
            m1465a((ViewOnAttachStateChangeListenerC0188bc) null);
        }
        this.f1617a.removeCallbacks(this.f1621e);
    }

    /* renamed from: a */
    private static void m1465a(ViewOnAttachStateChangeListenerC0188bc viewOnAttachStateChangeListenerC0188bc) {
        if (f1615j != null) {
            f1615j.m1468c();
        }
        f1615j = viewOnAttachStateChangeListenerC0188bc;
        if (f1615j != null) {
            f1615j.m1467b();
        }
    }

    /* renamed from: b */
    private void m1467b() {
        this.f1617a.postDelayed(this.f1620d, ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: c */
    private void m1468c() {
        this.f1617a.removeCallbacks(this.f1620d);
    }

    /* renamed from: a */
    private boolean m1466a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1622f) <= this.f1619c && Math.abs(y - this.f1623g) <= this.f1619c) {
            return false;
        }
        this.f1622f = x;
        this.f1623g = y;
        return true;
    }

    /* renamed from: d */
    private void m1469d() {
        this.f1622f = Integer.MAX_VALUE;
        this.f1623g = Integer.MAX_VALUE;
    }
}
