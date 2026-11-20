package com.p159h.p160a.p161a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1386h;

/* compiled from: TouchNavigationMethod.java */
/* renamed from: com.h.a.a.h */
/* loaded from: classes.dex */
public class C1376h extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    protected C1371c f8965a;

    /* renamed from: b */
    protected boolean f8966b = false;

    /* renamed from: e */
    private GestureDetector f8967e;

    /* renamed from: f */
    private float f8968f;

    /* renamed from: g */
    private int f8969g;

    /* renamed from: c */
    protected static int f8962c = 10;

    /* renamed from: h */
    private static final Rect f8964h = new Rect(0, 0, 0, 0);

    /* renamed from: d */
    protected static int f8963d = 12;

    /* renamed from: a */
    public void mo10978a(Canvas canvas) {
    }

    /* renamed from: a */
    public void mo10979a(AbstractC1381c abstractC1381c) {
    }

    /* renamed from: a */
    public void m10980a(boolean z) {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public C1376h(C1371c c1371c) {
        this.f8965a = c1371c;
        this.f8967e = new GestureDetector(c1371c.getContext(), this);
        this.f8967e.setIsLongpressEnabled(true);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f8965a.getParent().requestDisallowInterceptTouchEvent(motionEvent.getX() > ((float) 10));
        int m10976a = m10976a((int) motionEvent.getX());
        int m10984b = m10984b((int) motionEvent.getY());
        this.f8966b = m10981a(m10976a, m10984b, this.f8965a.getCaretPosition());
        if (this.f8965a.m10908m()) {
            this.f8965a.m10909n();
        } else if (this.f8965a.m10920y()) {
            if (m10981a(m10976a, m10984b, this.f8965a.getSelectionStart())) {
                this.f8965a.m10855B();
                this.f8965a.performHapticFeedback(0);
                this.f8966b = true;
            } else if (m10981a(m10976a, m10984b, this.f8965a.getSelectionEnd())) {
                this.f8965a.m10856C();
                this.f8965a.performHapticFeedback(0);
                this.f8966b = true;
            }
        }
        if (this.f8966b) {
            this.f8965a.performHapticFeedback(0);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int m10976a = m10976a((int) motionEvent.getX());
        int m10984b = m10984b((int) motionEvent.getY());
        int m10866a = this.f8965a.m10866a(m10976a, m10984b);
        if (this.f8965a.m10920y()) {
            if (!this.f8965a.m10905j(this.f8965a.m10878b(m10976a, m10984b)) && !m10981a(m10976a, m10984b, this.f8965a.getSelectionStart()) && !m10981a(m10976a, m10984b, this.f8965a.getSelectionEnd())) {
                this.f8965a.m10895f(false);
                if (m10866a >= 0) {
                    this.f8965a.m10901h(m10866a);
                }
            }
        } else if (m10866a >= 0) {
            this.f8965a.m10901h(m10866a);
        }
        this.f8965a.mo10898g(true);
        return true;
    }

    /* renamed from: a */
    public boolean mo10983a(MotionEvent motionEvent) {
        this.f8965a.m10910o();
        this.f8966b = false;
        this.f8968f = 0;
        this.f8969g = 0;
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (this.f8966b) {
            m10975c(motionEvent2);
        } else if (motionEvent2.getPointerCount() == 1) {
            if (this.f8969g == 0) {
                if (Math.abs(f2) > Math.abs(f3)) {
                    if ((f2 > 0 && this.f8965a.getScrollX() >= this.f8965a.getMaxScrollX()) || (f2 <= 0 && this.f8965a.getScrollX() <= 0)) {
                        this.f8965a.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    this.f8969g = 1;
                } else {
                    this.f8969g = -1;
                }
            }
            if (this.f8969g == 1) {
                f3 = 0;
            } else if (this.f8969g == -1) {
                f2 = 0;
            }
            m10973a(f2, f3);
        }
        if ((motionEvent2.getAction() & 255) == 1) {
            mo10983a(motionEvent2);
        }
        return true;
    }

    /* renamed from: c */
    private void m10975c(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f8965a.m10920y() && m10974b()) {
            this.f8965a.m10895f(true);
        }
        int x = ((int) motionEvent.getX()) - this.f8965a.getPaddingLeft();
        int y = ((int) motionEvent.getY()) - this.f8965a.getPaddingTop();
        if (x < f8962c) {
            z = this.f8965a.m10899g(2);
        } else if (x >= this.f8965a.getContentWidth() - f8962c) {
            z = this.f8965a.m10899g(3);
        } else if (y < f8962c) {
            z = this.f8965a.m10899g(0);
        } else if (y >= this.f8965a.getContentHeight() - f8962c) {
            z = this.f8965a.m10899g(1);
        }
        if (z) {
            return;
        }
        this.f8965a.m10910o();
        int m10866a = this.f8965a.m10866a(m10976a((int) motionEvent.getX()), m10984b((int) motionEvent.getY()));
        if (m10866a >= 0) {
            this.f8965a.m10901h(m10866a);
        }
    }

    /* renamed from: a */
    private void m10973a(float f2, float f3) {
        int i = 0;
        int scrollX = this.f8965a.getScrollX() + ((int) f2);
        int scrollY = this.f8965a.getScrollY() + ((int) f3);
        int max = Math.max(this.f8965a.getMaxScrollX(), this.f8965a.getScrollX());
        if (scrollX <= max) {
            max = scrollX < 0 ? 0 : scrollX;
        }
        int max2 = Math.max(this.f8965a.getMaxScrollY(), this.f8965a.getScrollY());
        if (scrollY > max2) {
            i = max2;
        } else if (scrollY >= 0) {
            i = scrollY;
        }
        this.f8965a.scrollTo(max, i);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.f8966b) {
            if (this.f8969g == 1) {
                f3 = 0;
            } else if (this.f8969g == -1) {
                f2 = 0;
            }
            this.f8965a.m10884c((int) (-f2), (int) (-f3));
        }
        mo10983a(motionEvent2);
        return true;
    }

    /* renamed from: b */
    public boolean m10986b(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f8967e.onTouchEvent(motionEvent);
        if (!onTouchEvent && (motionEvent.getAction() & 255) == 1) {
            return mo10983a(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f8966b = true;
        int m10866a = this.f8965a.m10866a(m10976a((int) motionEvent.getX()), m10984b((int) motionEvent.getY()));
        if (m10866a >= 0) {
            this.f8965a.m10901h(m10866a);
            C1386h m10890e = this.f8965a.m10890e();
            int i = m10866a;
            while (i >= 0 && Character.isJavaIdentifierPart(m10890e.charAt(i))) {
                i--;
            }
            if (i != m10866a) {
                i++;
            }
            while (m10866a >= 0 && Character.isJavaIdentifierPart(m10890e.charAt(m10866a))) {
                m10866a++;
            }
            this.f8965a.m10895f(true);
            this.f8965a.m10892e(i, m10866a - i);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m10982a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public boolean m10985b(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public Rect mo10977a() {
        return f8964h;
    }

    /* renamed from: a */
    protected final int m10976a(int i) {
        return (i - this.f8965a.getPaddingLeft()) + this.f8965a.getScrollX();
    }

    /* renamed from: b */
    protected final int m10984b(int i) {
        return (i - this.f8965a.getPaddingTop()) + this.f8965a.getScrollY();
    }

    /* renamed from: b */
    private final boolean m10974b() {
        return false;
    }

    /* renamed from: a */
    public boolean m10981a(int i, int i2, int i3) {
        Rect m10894f = this.f8965a.m10894f(i3);
        return i2 >= m10894f.top - f8963d && i2 < m10894f.bottom + f8963d && i >= m10894f.left - f8963d && i < m10894f.right + f8963d;
    }

    C1376h() {
    }
}
