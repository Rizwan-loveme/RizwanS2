package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.InterfaceC0115p;

/* compiled from: ForwardingListener.java */
/* renamed from: androidx.appcompat.widget.aj */
/* loaded from: classes.dex */
public abstract class AbstractViewOnAttachStateChangeListenerC0168aj implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a */
    private final float f1430a;

    /* renamed from: b */
    private final int f1431b;

    /* renamed from: c */
    final View f1432c;

    /* renamed from: d */
    private final int f1433d;

    /* renamed from: e */
    private Runnable f1434e;

    /* renamed from: f */
    private Runnable f1435f;

    /* renamed from: g */
    private boolean f1436g;

    /* renamed from: h */
    private int f1437h;

    /* renamed from: i */
    private final int[] f1438i = new int[2];

    /* renamed from: a */
    public abstract InterfaceC0115p mo787a();

    public AbstractViewOnAttachStateChangeListenerC0168aj(View view) {
        this.f1432c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1430a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1431b = ViewConfiguration.getTapTimeout();
        this.f1433d = (this.f1431b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1436g;
        if (z2) {
            z = m1282b(motionEvent) || !mo1285c();
        } else {
            boolean z3 = m1279a(motionEvent) && mo788b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1432c.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.f1436g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1436g = false;
        this.f1437h = -1;
        if (this.f1434e != null) {
            this.f1432c.removeCallbacks(this.f1434e);
        }
    }

    /* renamed from: b */
    protected boolean mo788b() {
        InterfaceC0115p mo787a = mo787a();
        if (mo787a != null && !mo787a.mo845d()) {
            mo787a.mo841b_();
            return true;
        }
        return true;
    }

    /* renamed from: c */
    protected boolean mo1285c() {
        InterfaceC0115p mo787a = mo787a();
        if (mo787a != null && mo787a.mo845d()) {
            mo787a.mo842c();
            return true;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m1279a(MotionEvent motionEvent) {
        View view = this.f1432c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1437h = motionEvent.getPointerId(0);
                if (this.f1434e == null) {
                    this.f1434e = new a();
                }
                view.postDelayed(this.f1434e, this.f1431b);
                if (this.f1435f == null) {
                    this.f1435f = new b();
                }
                view.postDelayed(this.f1435f, this.f1433d);
                break;
            case 1:
            case 3:
                m1284e();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1437h);
                if (findPointerIndex >= 0 && !m1280a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1430a)) {
                    m1284e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: e */
    private void m1284e() {
        if (this.f1435f != null) {
            this.f1432c.removeCallbacks(this.f1435f);
        }
        if (this.f1434e != null) {
            this.f1432c.removeCallbacks(this.f1434e);
        }
    }

    /* renamed from: d */
    void m1286d() {
        m1284e();
        View view = this.f1432c;
        if (view.isEnabled() && !view.isLongClickable() && mo788b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1436g = true;
        }
    }

    /* renamed from: b */
    private boolean m1282b(MotionEvent motionEvent) {
        C0166ah c0166ah;
        View view = this.f1432c;
        InterfaceC0115p mo787a = mo787a();
        if (mo787a == null || !mo787a.mo845d() || (c0166ah = (C0166ah) mo787a.mo846e()) == null || !c0166ah.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1283b(view, obtainNoHistory);
        m1281a(c0166ah, obtainNoHistory);
        boolean mo1275a = c0166ah.mo1275a(obtainNoHistory, this.f1437h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return mo1275a && (actionMasked != 1 && actionMasked != 3);
    }

    /* renamed from: a */
    private static boolean m1280a(View view, float f2, float f3, float f4) {
        return f2 >= (-f4) && f3 >= (-f4) && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    /* renamed from: a */
    private boolean m1281a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1438i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    /* renamed from: b */
    private boolean m1283b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1438i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: androidx.appcompat.widget.aj$a */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnAttachStateChangeListenerC0168aj.this.f1432c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: androidx.appcompat.widget.aj$b */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnAttachStateChangeListenerC0168aj.this.m1286d();
        }
    }
}
