package com.p126e.p127a.p128a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CustomGestureDetector.java */
/* renamed from: com.e.a.a.b */
/* loaded from: classes.dex */
class C1094b {

    /* renamed from: a */
    private int f7448a = -1;

    /* renamed from: b */
    private int f7449b = 0;

    /* renamed from: c */
    private final ScaleGestureDetector f7450c;

    /* renamed from: d */
    private VelocityTracker f7451d;

    /* renamed from: e */
    private boolean f7452e;

    /* renamed from: f */
    private float f7453f;

    /* renamed from: g */
    private float f7454g;

    /* renamed from: h */
    private final float f7455h;

    /* renamed from: i */
    private final float f7456i;

    /* renamed from: j */
    private InterfaceC1095c f7457j;

    C1094b(Context context, InterfaceC1095c interfaceC1095c) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7456i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7455h = viewConfiguration.getScaledTouchSlop();
        this.f7457j = interfaceC1095c;
        this.f7450c = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.e.a.a.b.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                if (scaleFactor >= 0.0f) {
                    C1094b.this.f7457j.mo9413a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    /* renamed from: b */
    private float m9406b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f7449b);
        } catch (Exception e2) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m9407c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f7449b);
        } catch (Exception e2) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean m9409a() {
        return this.f7450c.isInProgress();
    }

    /* renamed from: b */
    public boolean m9411b() {
        return this.f7452e;
    }

    /* renamed from: a */
    public boolean m9410a(MotionEvent motionEvent) {
        try {
            this.f7450c.onTouchEvent(motionEvent);
            return m9408d(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m9408d(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f7448a = motionEvent.getPointerId(0);
                this.f7451d = VelocityTracker.obtain();
                if (this.f7451d != null) {
                    this.f7451d.addMovement(motionEvent);
                }
                this.f7453f = m9406b(motionEvent);
                this.f7454g = m9407c(motionEvent);
                this.f7452e = false;
                break;
            case 1:
                this.f7448a = -1;
                if (this.f7452e && this.f7451d != null) {
                    this.f7453f = m9406b(motionEvent);
                    this.f7454g = m9407c(motionEvent);
                    this.f7451d.addMovement(motionEvent);
                    this.f7451d.computeCurrentVelocity(1000);
                    float xVelocity = this.f7451d.getXVelocity();
                    float yVelocity = this.f7451d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f7456i) {
                        this.f7457j.mo9414a(this.f7453f, this.f7454g, -xVelocity, -yVelocity);
                    }
                }
                if (this.f7451d != null) {
                    this.f7451d.recycle();
                    this.f7451d = null;
                    break;
                }
                break;
            case 2:
                float m9406b = m9406b(motionEvent);
                float m9407c = m9407c(motionEvent);
                float f2 = m9406b - this.f7453f;
                float f3 = m9407c - this.f7454g;
                if (!this.f7452e) {
                    this.f7452e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f7455h);
                }
                if (this.f7452e) {
                    this.f7457j.mo9412a(f2, f3);
                    this.f7453f = m9406b;
                    this.f7454g = m9407c;
                    if (this.f7451d != null) {
                        this.f7451d.addMovement(motionEvent);
                        break;
                    }
                }
                break;
            case 3:
                this.f7448a = -1;
                if (this.f7451d != null) {
                    this.f7451d.recycle();
                    this.f7451d = null;
                    break;
                }
                break;
            case 6:
                int m9493a = C1105m.m9493a(motionEvent.getAction());
                if (motionEvent.getPointerId(m9493a) == this.f7448a) {
                    int i = m9493a == 0 ? 1 : 0;
                    this.f7448a = motionEvent.getPointerId(i);
                    this.f7453f = motionEvent.getX(i);
                    this.f7454g = motionEvent.getY(i);
                    break;
                }
                break;
        }
        this.f7449b = motionEvent.findPointerIndex(this.f7448a != -1 ? this.f7448a : 0);
        return true;
    }
}
