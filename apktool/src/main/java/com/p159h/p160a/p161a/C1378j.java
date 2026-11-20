package com.p159h.p160a.p161a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1397s;

/* compiled from: YoyoNavigationMethod.java */
/* renamed from: com.h.a.a.j */
/* loaded from: classes.dex */
public class C1378j extends C1376h {

    /* renamed from: e */
    private final a f8975e;

    /* renamed from: f */
    private final a f8976f;

    /* renamed from: g */
    private final a f8977g;

    /* renamed from: h */
    private boolean f8978h;

    /* renamed from: i */
    private boolean f8979i;

    /* renamed from: j */
    private boolean f8980j;

    /* renamed from: k */
    private boolean f8981k;

    /* renamed from: l */
    private int f8982l;

    public C1378j(C1371c c1371c) {
        super(c1371c);
        this.f8978h = false;
        this.f8979i = false;
        this.f8980j = false;
        this.f8981k = false;
        this.f8982l = (int) TypedValue.applyDimension(2, (float) (C1371c.f8854q * 1.5d), c1371c.getContext().getResources().getDisplayMetrics());
        this.f8975e = new a(this);
        this.f8976f = new a(this);
        this.f8977g = new a(this);
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        super.onDown(motionEvent);
        if (!this.f8966b) {
            int x = ((int) motionEvent.getX()) + this.f8965a.getScrollX();
            int y = ((int) motionEvent.getY()) + this.f8965a.getScrollY();
            this.f8980j = this.f8975e.m11003e(x, y);
            this.f8978h = this.f8976f.m11003e(x, y);
            this.f8979i = this.f8977g.m11003e(x, y);
            if (this.f8980j) {
                this.f8981k = true;
                this.f8975e.m11001d(x, y);
                this.f8975e.m10996b();
            } else if (this.f8978h) {
                this.f8976f.m11001d(x, y);
                this.f8965a.m10855B();
                this.f8976f.m10996b();
            } else if (this.f8979i) {
                this.f8977g.m11001d(x, y);
                this.f8965a.m10856C();
                this.f8977g.m10996b();
            }
        }
        return true;
    }

    @Override // com.p159h.p160a.p161a.C1376h
    /* renamed from: a */
    public boolean mo10983a(MotionEvent motionEvent) {
        this.f8980j = false;
        this.f8978h = false;
        this.f8979i = false;
        this.f8975e.m10999c();
        this.f8976f.m10999c();
        this.f8977g.m10999c();
        this.f8965a.m10875a(false, 0, 0);
        super.mo10983a(motionEvent);
        return true;
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (this.f8980j) {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo10983a(motionEvent2);
                return true;
            }
            this.f8981k = true;
            m10990a(this.f8975e, motionEvent2);
            return true;
        }
        if (this.f8978h) {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo10983a(motionEvent2);
                return true;
            }
            m10990a(this.f8976f, motionEvent2);
            return true;
        }
        if (this.f8979i) {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo10983a(motionEvent2);
                return true;
            }
            m10990a(this.f8977g, motionEvent2);
            return true;
        }
        return super.onScroll(motionEvent, motionEvent2, f2, f3);
    }

    /* renamed from: a */
    private void m10990a(a aVar, MotionEvent motionEvent) {
        this.f8965a.m10875a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
        int m11130a = aVar.m10998c((int) motionEvent.getX(), (int) motionEvent.getY()).m11130a();
        if (m11130a >= 0) {
            this.f8965a.m10871a(m11130a, false);
            Rect m10894f = this.f8965a.m10894f(m11130a);
            aVar.m10994a(m10894f.left + this.f8965a.getPaddingLeft(), m10894f.bottom + this.f8965a.getPaddingTop());
        }
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) + this.f8965a.getScrollX();
        int y = ((int) motionEvent.getY()) + this.f8965a.getScrollY();
        if (this.f8975e.m11003e(x, y) || this.f8976f.m11003e(x, y) || this.f8977g.m11003e(x, y)) {
            return true;
        }
        this.f8981k = true;
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) + this.f8965a.getScrollX();
        int y = ((int) motionEvent.getY()) + this.f8965a.getScrollY();
        if (this.f8975e.m11003e(x, y)) {
            this.f8965a.m10895f(true);
            return true;
        }
        if (this.f8976f.m11003e(x, y)) {
            return true;
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        onDoubleTap(motionEvent);
    }

    @Override // com.p159h.p160a.p161a.C1376h, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.f8980j && !this.f8978h && !this.f8979i) {
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }
        mo10983a(motionEvent2);
        return true;
    }

    @Override // com.p159h.p160a.p161a.C1376h
    /* renamed from: a */
    public void mo10978a(Canvas canvas) {
        if (!this.f8965a.m10921z()) {
            this.f8975e.m11000d();
            this.f8976f.m11002e();
            this.f8977g.m11002e();
            if (!this.f8980j) {
                Rect m10894f = this.f8965a.m10894f(this.f8965a.getCaretPosition());
                this.f8975e.m10997b(m10894f.left + this.f8965a.getPaddingLeft(), m10894f.bottom + this.f8965a.getPaddingTop());
            }
            if (this.f8981k) {
                this.f8975e.m10995a(canvas, this.f8980j);
            }
            this.f8981k = false;
            return;
        }
        this.f8975e.m11002e();
        this.f8976f.m11000d();
        this.f8977g.m11000d();
        if (!this.f8978h || !this.f8979i) {
            Rect m10894f2 = this.f8965a.m10894f(this.f8965a.getSelectionStart());
            this.f8976f.m10997b(m10894f2.left + this.f8965a.getPaddingLeft(), m10894f2.bottom + this.f8965a.getPaddingTop());
            Rect m10894f3 = this.f8965a.m10894f(this.f8965a.getSelectionEnd());
            this.f8977g.m10997b(m10894f3.left + this.f8965a.getPaddingLeft(), m10894f3.bottom + this.f8965a.getPaddingTop());
        }
        this.f8976f.m10995a(canvas, this.f8978h);
        this.f8977g.m10995a(canvas, this.f8978h);
    }

    @Override // com.p159h.p160a.p161a.C1376h
    /* renamed from: a */
    public Rect mo10977a() {
        return this.f8975e.f8983a;
    }

    @Override // com.p159h.p160a.p161a.C1376h
    /* renamed from: a */
    public void mo10979a(AbstractC1381c abstractC1381c) {
        this.f8975e.m10993a(abstractC1381c.m11009a(AbstractC1381c.a.f8999e));
    }

    /* compiled from: YoyoNavigationMethod.java */
    /* renamed from: com.h.a.a.j$a */
    private class a {

        /* renamed from: a */
        public final Rect f8983a;

        /* renamed from: b */
        private final int f8984b;

        /* renamed from: c */
        private final Rect f8985c;

        /* renamed from: d */
        private int f8986d = 0;

        /* renamed from: e */
        private int f8987e = 0;

        /* renamed from: f */
        private int f8988f = 0;

        /* renamed from: g */
        private int f8989g = 0;

        /* renamed from: h */
        private int f8990h = 0;

        /* renamed from: i */
        private int f8991i = 0;

        /* renamed from: j */
        private final Paint f8992j = new Paint();

        /* renamed from: k */
        private boolean f8993k;

        /* renamed from: l */
        private final C1378j f8994l;

        public a(C1378j c1378j) {
            this.f8994l = c1378j;
            this.f8984b = this.f8994l.f8982l / 3;
            this.f8985c = new Rect(0, 0, this.f8994l.f8982l, this.f8994l.f8982l);
            this.f8983a = new Rect(m10992a(), 0, 0, this.f8985c.bottom + this.f8984b);
            this.f8992j.setColor(this.f8994l.f8965a.getColorScheme().m11009a(AbstractC1381c.a.f8999e));
            this.f8992j.setAntiAlias(true);
        }

        /* renamed from: a */
        public void m10993a(int i) {
            this.f8992j.setColor(i);
        }

        /* renamed from: a */
        public void m10995a(Canvas canvas, boolean z) {
            int m10992a = m10992a();
            canvas.drawLine(this.f8986d, this.f8987e, this.f8988f + m10992a, this.f8989g + m10992a, this.f8992j);
            canvas.drawArc(new RectF(this.f8986d - m10992a, (this.f8987e - (m10992a / 2)) - this.f8984b, this.f8988f + (m10992a * 2), this.f8989g + (m10992a / 2)), 60, 60, true, this.f8992j);
            canvas.drawOval(new RectF(this.f8988f, this.f8989g, this.f8988f + this.f8985c.right, this.f8989g + this.f8985c.bottom), this.f8992j);
        }

        /* renamed from: a */
        public final int m10992a() {
            return this.f8985c.right / 2;
        }

        /* renamed from: a */
        public void m10994a(int i, int i2) {
            m10991f();
            m10997b(i, i2);
            m10991f();
        }

        /* renamed from: b */
        public void m10997b(int i, int i2) {
            this.f8986d = i;
            this.f8987e = i2;
            this.f8988f = i - m10992a();
            this.f8989g = this.f8984b + i2;
        }

        /* renamed from: f */
        private void m10991f() {
            int i;
            int i2;
            int i3;
            int i4;
            int m10992a = this.f8988f + m10992a();
            if (m10992a >= this.f8986d) {
                i2 = this.f8986d;
                i = m10992a + 1;
            } else {
                i = this.f8986d + 1;
                i2 = m10992a;
            }
            if (this.f8989g >= this.f8987e) {
                i3 = this.f8987e;
                i4 = this.f8989g;
            } else {
                i3 = this.f8989g;
                i4 = this.f8987e;
            }
            this.f8994l.f8965a.invalidate(i2, i3, i, i4);
            m10996b();
        }

        /* renamed from: b */
        public void m10996b() {
            this.f8994l.f8965a.invalidate(new Rect(this.f8988f, this.f8989g, this.f8988f + this.f8985c.right, this.f8989g + this.f8985c.bottom));
        }

        /* renamed from: c */
        public C1397s m10998c(int i, int i2) {
            int a2 = (this.f8994l.m10976a(i) - this.f8990h) + m10992a();
            int b2 = ((this.f8994l.m10984b(i2) - this.f8991i) - this.f8984b) - 2;
            return new C1397s(this.f8994l.f8965a.m10866a(a2, b2), new Integer(this.f8994l.f8965a.m10878b(a2, b2)));
        }

        /* renamed from: d */
        public void m11001d(int i, int i2) {
            this.f8990h = i - this.f8988f;
            this.f8991i = i2 - this.f8989g;
        }

        /* renamed from: c */
        public void m10999c() {
            this.f8990h = 0;
            this.f8991i = 0;
        }

        /* renamed from: d */
        public void m11000d() {
            this.f8993k = true;
        }

        /* renamed from: e */
        public void m11002e() {
            this.f8993k = false;
        }

        /* renamed from: e */
        public boolean m11003e(int i, int i2) {
            return this.f8993k && i >= this.f8988f && i < this.f8988f + this.f8985c.right && i2 >= this.f8989g && i2 < this.f8989g + this.f8985c.bottom;
        }
    }
}
