package com.p126e.p127a.p128a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* renamed from: com.e.a.a.l */
/* loaded from: classes.dex */
public class ViewOnLayoutChangeListenerC1104l implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a */
    private static float f7461a = 3.0f;

    /* renamed from: b */
    private static float f7462b = 1.75f;

    /* renamed from: c */
    private static float f7463c = 1.0f;

    /* renamed from: d */
    private static int f7464d = 200;

    /* renamed from: e */
    private static int f7465e = 1;

    /* renamed from: A */
    private InterfaceC1099g f7466A;

    /* renamed from: B */
    private InterfaceC1100h f7467B;

    /* renamed from: C */
    private InterfaceC1101i f7468C;

    /* renamed from: D */
    private b f7469D;

    /* renamed from: G */
    private float f7472G;

    /* renamed from: m */
    private ImageView f7483m;

    /* renamed from: n */
    private GestureDetector f7484n;

    /* renamed from: o */
    private C1094b f7485o;

    /* renamed from: u */
    private InterfaceC1096d f7491u;

    /* renamed from: v */
    private InterfaceC1098f f7492v;

    /* renamed from: w */
    private InterfaceC1097e f7493w;

    /* renamed from: x */
    private InterfaceC1102j f7494x;

    /* renamed from: y */
    private View.OnClickListener f7495y;

    /* renamed from: z */
    private View.OnLongClickListener f7496z;

    /* renamed from: f */
    private Interpolator f7476f = new AccelerateDecelerateInterpolator();

    /* renamed from: g */
    private int f7477g = f7464d;

    /* renamed from: h */
    private float f7478h = f7463c;

    /* renamed from: i */
    private float f7479i = f7462b;

    /* renamed from: j */
    private float f7480j = f7461a;

    /* renamed from: k */
    private boolean f7481k = true;

    /* renamed from: l */
    private boolean f7482l = false;

    /* renamed from: p */
    private final Matrix f7486p = new Matrix();

    /* renamed from: q */
    private final Matrix f7487q = new Matrix();

    /* renamed from: r */
    private final Matrix f7488r = new Matrix();

    /* renamed from: s */
    private final RectF f7489s = new RectF();

    /* renamed from: t */
    private final float[] f7490t = new float[9];

    /* renamed from: E */
    private int f7470E = 2;

    /* renamed from: F */
    private int f7471F = 2;

    /* renamed from: H */
    private boolean f7473H = true;

    /* renamed from: I */
    private ImageView.ScaleType f7474I = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: J */
    private InterfaceC1095c f7475J = new InterfaceC1095c() { // from class: com.e.a.a.l.1
        @Override // com.p126e.p127a.p128a.InterfaceC1095c
        /* renamed from: a */
        public void mo9412a(float f2, float f3) {
            if (!ViewOnLayoutChangeListenerC1104l.this.f7485o.m9409a()) {
                if (ViewOnLayoutChangeListenerC1104l.this.f7468C != null) {
                    ViewOnLayoutChangeListenerC1104l.this.f7468C.m9420a(f2, f3);
                }
                ViewOnLayoutChangeListenerC1104l.this.f7488r.postTranslate(f2, f3);
                ViewOnLayoutChangeListenerC1104l.this.m9449m();
                ViewParent parent = ViewOnLayoutChangeListenerC1104l.this.f7483m.getParent();
                if (ViewOnLayoutChangeListenerC1104l.this.f7481k && !ViewOnLayoutChangeListenerC1104l.this.f7485o.m9409a() && !ViewOnLayoutChangeListenerC1104l.this.f7482l) {
                    if ((ViewOnLayoutChangeListenerC1104l.this.f7470E == 2 || ((ViewOnLayoutChangeListenerC1104l.this.f7470E == 0 && f2 >= 1.0f) || ((ViewOnLayoutChangeListenerC1104l.this.f7470E == 1 && f2 <= -1.0f) || ((ViewOnLayoutChangeListenerC1104l.this.f7471F == 0 && f3 >= 1.0f) || (ViewOnLayoutChangeListenerC1104l.this.f7471F == 1 && f3 <= -1.0f))))) && parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    return;
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }

        @Override // com.p126e.p127a.p128a.InterfaceC1095c
        /* renamed from: a */
        public void mo9414a(float f2, float f3, float f4, float f5) {
            ViewOnLayoutChangeListenerC1104l.this.f7469D = ViewOnLayoutChangeListenerC1104l.this.new b(ViewOnLayoutChangeListenerC1104l.this.f7483m.getContext());
            ViewOnLayoutChangeListenerC1104l.this.f7469D.m9492a(ViewOnLayoutChangeListenerC1104l.this.m9424a(ViewOnLayoutChangeListenerC1104l.this.f7483m), ViewOnLayoutChangeListenerC1104l.this.m9430b(ViewOnLayoutChangeListenerC1104l.this.f7483m), (int) f4, (int) f5);
            ViewOnLayoutChangeListenerC1104l.this.f7483m.post(ViewOnLayoutChangeListenerC1104l.this.f7469D);
        }

        @Override // com.p126e.p127a.p128a.InterfaceC1095c
        /* renamed from: a */
        public void mo9413a(float f2, float f3, float f4) {
            if (ViewOnLayoutChangeListenerC1104l.this.m9484e() < ViewOnLayoutChangeListenerC1104l.this.f7480j || f2 < 1.0f) {
                if (ViewOnLayoutChangeListenerC1104l.this.f7466A != null) {
                    ViewOnLayoutChangeListenerC1104l.this.f7466A.m9418a(f2, f3, f4);
                }
                ViewOnLayoutChangeListenerC1104l.this.f7488r.postScale(f2, f2, f3, f4);
                ViewOnLayoutChangeListenerC1104l.this.m9449m();
            }
        }
    };

    public ViewOnLayoutChangeListenerC1104l(ImageView imageView) {
        this.f7483m = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.f7472G = 0.0f;
            this.f7485o = new C1094b(imageView.getContext(), this.f7475J);
            this.f7484n = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.e.a.a.l.2
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (ViewOnLayoutChangeListenerC1104l.this.f7496z != null) {
                        ViewOnLayoutChangeListenerC1104l.this.f7496z.onLongClick(ViewOnLayoutChangeListenerC1104l.this.f7483m);
                    }
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    if (ViewOnLayoutChangeListenerC1104l.this.f7467B == null || ViewOnLayoutChangeListenerC1104l.this.m9484e() > ViewOnLayoutChangeListenerC1104l.f7463c || motionEvent.getPointerCount() > ViewOnLayoutChangeListenerC1104l.f7465e || motionEvent2.getPointerCount() > ViewOnLayoutChangeListenerC1104l.f7465e) {
                        return false;
                    }
                    return ViewOnLayoutChangeListenerC1104l.this.f7467B.m9419a(motionEvent, motionEvent2, f2, f3);
                }
            });
            this.f7484n.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.e.a.a.l.3
                @Override // android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (ViewOnLayoutChangeListenerC1104l.this.f7495y != null) {
                        ViewOnLayoutChangeListenerC1104l.this.f7495y.onClick(ViewOnLayoutChangeListenerC1104l.this.f7483m);
                    }
                    RectF m9460a = ViewOnLayoutChangeListenerC1104l.this.m9460a();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (ViewOnLayoutChangeListenerC1104l.this.f7494x != null) {
                        ViewOnLayoutChangeListenerC1104l.this.f7494x.m9421a(ViewOnLayoutChangeListenerC1104l.this.f7483m, x, y);
                    }
                    if (m9460a != null) {
                        if (!m9460a.contains(x, y)) {
                            if (ViewOnLayoutChangeListenerC1104l.this.f7493w != null) {
                                ViewOnLayoutChangeListenerC1104l.this.f7493w.m9416a(ViewOnLayoutChangeListenerC1104l.this.f7483m);
                            }
                        } else {
                            float width = (x - m9460a.left) / m9460a.width();
                            float height = (y - m9460a.top) / m9460a.height();
                            if (ViewOnLayoutChangeListenerC1104l.this.f7492v != null) {
                                ViewOnLayoutChangeListenerC1104l.this.f7492v.m9417a(ViewOnLayoutChangeListenerC1104l.this.f7483m, width, height);
                            }
                            return true;
                        }
                    }
                    return false;
                }

                @Override // android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float m9484e = ViewOnLayoutChangeListenerC1104l.this.m9484e();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (m9484e < ViewOnLayoutChangeListenerC1104l.this.m9480c()) {
                            ViewOnLayoutChangeListenerC1104l.this.m9462a(ViewOnLayoutChangeListenerC1104l.this.m9480c(), x, y, true);
                        } else if (m9484e >= ViewOnLayoutChangeListenerC1104l.this.m9480c() && m9484e < ViewOnLayoutChangeListenerC1104l.this.m9482d()) {
                            ViewOnLayoutChangeListenerC1104l.this.m9462a(ViewOnLayoutChangeListenerC1104l.this.m9482d(), x, y, true);
                        } else {
                            ViewOnLayoutChangeListenerC1104l.this.m9462a(ViewOnLayoutChangeListenerC1104l.this.m9477b(), x, y, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException e2) {
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }
            });
        }
    }

    /* renamed from: a */
    public void m9465a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f7484n.setOnDoubleTapListener(onDoubleTapListener);
    }

    /* renamed from: a */
    public void m9472a(InterfaceC1099g interfaceC1099g) {
        this.f7466A = interfaceC1099g;
    }

    /* renamed from: a */
    public void m9473a(InterfaceC1100h interfaceC1100h) {
        this.f7467B = interfaceC1100h;
    }

    /* renamed from: a */
    public RectF m9460a() {
        m9451n();
        return m9432b(m9445k());
    }

    /* renamed from: a */
    public void m9461a(float f2) {
        this.f7488r.setRotate(f2 % 360.0f);
        m9449m();
    }

    /* renamed from: b */
    public void m9478b(float f2) {
        this.f7488r.postRotate(f2 % 360.0f);
        m9449m();
    }

    /* renamed from: b */
    public float m9477b() {
        return this.f7478h;
    }

    /* renamed from: c */
    public float m9480c() {
        return this.f7479i;
    }

    /* renamed from: d */
    public float m9482d() {
        return this.f7480j;
    }

    /* renamed from: e */
    public float m9484e() {
        return (float) Math.sqrt(((float) Math.pow(m9423a(this.f7488r, 0), 2.0d)) + ((float) Math.pow(m9423a(this.f7488r, 3), 2.0d)));
    }

    /* renamed from: f */
    public ImageView.ScaleType m9486f() {
        return this.f7474I;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            m9429a(this.f7483m.getDrawable());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF m9460a;
        boolean z;
        boolean z2 = false;
        if (!this.f7473H || !C1105m.m9496a((ImageView) view)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                m9453o();
                z = false;
                break;
            case 1:
            case 3:
                if (m9484e() < this.f7478h) {
                    RectF m9460a2 = m9460a();
                    if (m9460a2 != null) {
                        view.post(new a(m9484e(), this.f7478h, m9460a2.centerX(), m9460a2.centerY()));
                        z = true;
                        break;
                    }
                } else if (m9484e() > this.f7480j && (m9460a = m9460a()) != null) {
                    view.post(new a(m9484e(), this.f7480j, m9460a.centerX(), m9460a.centerY()));
                    z = true;
                    break;
                }
                break;
            case 2:
            default:
                z = false;
                break;
        }
        if (this.f7485o != null) {
            boolean m9409a = this.f7485o.m9409a();
            boolean m9411b = this.f7485o.m9411b();
            z = this.f7485o.m9410a(motionEvent);
            boolean z3 = (m9409a || this.f7485o.m9409a()) ? false : true;
            boolean z4 = (m9411b || this.f7485o.m9411b()) ? false : true;
            if (z3 && z4) {
                z2 = true;
            }
            this.f7482l = z2;
        }
        if (this.f7484n == null || !this.f7484n.onTouchEvent(motionEvent)) {
            return z;
        }
        return true;
    }

    /* renamed from: a */
    public void m9476a(boolean z) {
        this.f7481k = z;
    }

    /* renamed from: c */
    public void m9481c(float f2) {
        C1105m.m9494a(f2, this.f7479i, this.f7480j);
        this.f7478h = f2;
    }

    /* renamed from: d */
    public void m9483d(float f2) {
        C1105m.m9494a(this.f7478h, f2, this.f7480j);
        this.f7479i = f2;
    }

    /* renamed from: e */
    public void m9485e(float f2) {
        C1105m.m9494a(this.f7478h, this.f7479i, f2);
        this.f7480j = f2;
    }

    /* renamed from: a */
    public void m9467a(View.OnLongClickListener onLongClickListener) {
        this.f7496z = onLongClickListener;
    }

    /* renamed from: a */
    public void m9466a(View.OnClickListener onClickListener) {
        this.f7495y = onClickListener;
    }

    /* renamed from: a */
    public void m9469a(InterfaceC1096d interfaceC1096d) {
        this.f7491u = interfaceC1096d;
    }

    /* renamed from: a */
    public void m9471a(InterfaceC1098f interfaceC1098f) {
        this.f7492v = interfaceC1098f;
    }

    /* renamed from: a */
    public void m9470a(InterfaceC1097e interfaceC1097e) {
        this.f7493w = interfaceC1097e;
    }

    /* renamed from: a */
    public void m9475a(InterfaceC1102j interfaceC1102j) {
        this.f7494x = interfaceC1102j;
    }

    /* renamed from: a */
    public void m9474a(InterfaceC1101i interfaceC1101i) {
        this.f7468C = interfaceC1101i;
    }

    /* renamed from: f */
    public void m9487f(float f2) {
        m9463a(f2, false);
    }

    /* renamed from: a */
    public void m9463a(float f2, boolean z) {
        m9462a(f2, this.f7483m.getRight() / 2, this.f7483m.getBottom() / 2, z);
    }

    /* renamed from: a */
    public void m9462a(float f2, float f3, float f4, boolean z) {
        if (f2 < this.f7478h || f2 > this.f7480j) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.f7483m.post(new a(m9484e(), f2, f3, f4));
        } else {
            this.f7488r.setScale(f2, f2, f3, f4);
            m9449m();
        }
    }

    /* renamed from: a */
    public void m9468a(ImageView.ScaleType scaleType) {
        if (C1105m.m9495a(scaleType) && scaleType != this.f7474I) {
            this.f7474I = scaleType;
            m9488g();
        }
    }

    /* renamed from: b */
    public void m9479b(boolean z) {
        this.f7473H = z;
        m9488g();
    }

    /* renamed from: g */
    public void m9488g() {
        if (this.f7473H) {
            m9429a(this.f7483m.getDrawable());
        } else {
            m9447l();
        }
    }

    /* renamed from: k */
    private Matrix m9445k() {
        this.f7487q.set(this.f7486p);
        this.f7487q.postConcat(this.f7488r);
        return this.f7487q;
    }

    /* renamed from: h */
    public Matrix m9489h() {
        return this.f7487q;
    }

    /* renamed from: a */
    public void m9464a(int i) {
        this.f7477g = i;
    }

    /* renamed from: a */
    private float m9423a(Matrix matrix, int i) {
        matrix.getValues(this.f7490t);
        return this.f7490t[i];
    }

    /* renamed from: l */
    private void m9447l() {
        this.f7488r.reset();
        m9478b(this.f7472G);
        m9428a(m9445k());
        m9451n();
    }

    /* renamed from: a */
    private void m9428a(Matrix matrix) {
        RectF m9432b;
        this.f7483m.setImageMatrix(matrix);
        if (this.f7491u != null && (m9432b = m9432b(matrix)) != null) {
            this.f7491u.m9415a(m9432b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m9449m() {
        if (m9451n()) {
            m9428a(m9445k());
        }
    }

    /* renamed from: b */
    private RectF m9432b(Matrix matrix) {
        if (this.f7483m.getDrawable() == null) {
            return null;
        }
        this.f7489s.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f7489s);
        return this.f7489s;
    }

    /* renamed from: a */
    private void m9429a(Drawable drawable) {
        if (drawable != null) {
            float m9424a = m9424a(this.f7483m);
            float m9430b = m9430b(this.f7483m);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f7486p.reset();
            float f2 = m9424a / intrinsicWidth;
            float f3 = m9430b / intrinsicHeight;
            if (this.f7474I == ImageView.ScaleType.CENTER) {
                this.f7486p.postTranslate((m9424a - intrinsicWidth) / 2.0f, (m9430b - intrinsicHeight) / 2.0f);
            } else if (this.f7474I == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.f7486p.postScale(max, max);
                this.f7486p.postTranslate((m9424a - (intrinsicWidth * max)) / 2.0f, (m9430b - (max * intrinsicHeight)) / 2.0f);
            } else if (this.f7474I == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.f7486p.postScale(min, min);
                this.f7486p.postTranslate((m9424a - (intrinsicWidth * min)) / 2.0f, (m9430b - (min * intrinsicHeight)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, m9424a, m9430b);
                if (((int) this.f7472G) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, intrinsicHeight, intrinsicWidth);
                }
                switch (this.f7474I) {
                    case FIT_CENTER:
                        this.f7486p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case FIT_START:
                        this.f7486p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case FIT_END:
                        this.f7486p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case FIT_XY:
                        this.f7486p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            m9447l();
        }
    }

    /* renamed from: n */
    private boolean m9451n() {
        float f2;
        float f3 = 0.0f;
        RectF m9432b = m9432b(m9445k());
        if (m9432b == null) {
            return false;
        }
        float height = m9432b.height();
        float width = m9432b.width();
        int m9430b = m9430b(this.f7483m);
        if (height <= m9430b) {
            switch (this.f7474I) {
                case FIT_START:
                    f2 = -m9432b.top;
                    break;
                case FIT_END:
                    f2 = (m9430b - height) - m9432b.top;
                    break;
                default:
                    f2 = ((m9430b - height) / 2.0f) - m9432b.top;
                    break;
            }
            this.f7471F = 2;
        } else if (m9432b.top > 0.0f) {
            this.f7471F = 0;
            f2 = -m9432b.top;
        } else if (m9432b.bottom < m9430b) {
            this.f7471F = 1;
            f2 = m9430b - m9432b.bottom;
        } else {
            this.f7471F = -1;
            f2 = 0.0f;
        }
        int m9424a = m9424a(this.f7483m);
        if (width <= m9424a) {
            switch (this.f7474I) {
                case FIT_START:
                    f3 = -m9432b.left;
                    break;
                case FIT_END:
                    f3 = (m9424a - width) - m9432b.left;
                    break;
                default:
                    f3 = ((m9424a - width) / 2.0f) - m9432b.left;
                    break;
            }
            this.f7470E = 2;
        } else if (m9432b.left > 0.0f) {
            this.f7470E = 0;
            f3 = -m9432b.left;
        } else if (m9432b.right < m9424a) {
            f3 = m9424a - m9432b.right;
            this.f7470E = 1;
        } else {
            this.f7470E = -1;
        }
        this.f7488r.postTranslate(f3, f2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m9424a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m9430b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* renamed from: o */
    private void m9453o() {
        if (this.f7469D != null) {
            this.f7469D.m9491a();
            this.f7469D = null;
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.e.a.a.l$a */
    private class a implements Runnable {

        /* renamed from: b */
        private final float f7502b;

        /* renamed from: c */
        private final float f7503c;

        /* renamed from: d */
        private final long f7504d = System.currentTimeMillis();

        /* renamed from: e */
        private final float f7505e;

        /* renamed from: f */
        private final float f7506f;

        public a(float f2, float f3, float f4, float f5) {
            this.f7502b = f4;
            this.f7503c = f5;
            this.f7505e = f2;
            this.f7506f = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            float m9490a = m9490a();
            ViewOnLayoutChangeListenerC1104l.this.f7475J.mo9413a((this.f7505e + ((this.f7506f - this.f7505e) * m9490a)) / ViewOnLayoutChangeListenerC1104l.this.m9484e(), this.f7502b, this.f7503c);
            if (m9490a < 1.0f) {
                C1093a.m9403a(ViewOnLayoutChangeListenerC1104l.this.f7483m, this);
            }
        }

        /* renamed from: a */
        private float m9490a() {
            return ViewOnLayoutChangeListenerC1104l.this.f7476f.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f7504d) * 1.0f) / ViewOnLayoutChangeListenerC1104l.this.f7477g));
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.e.a.a.l$b */
    private class b implements Runnable {

        /* renamed from: b */
        private final OverScroller f7508b;

        /* renamed from: c */
        private int f7509c;

        /* renamed from: d */
        private int f7510d;

        public b(Context context) {
            this.f7508b = new OverScroller(context);
        }

        /* renamed from: a */
        public void m9491a() {
            this.f7508b.forceFinished(true);
        }

        /* renamed from: a */
        public void m9492a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF m9460a = ViewOnLayoutChangeListenerC1104l.this.m9460a();
            if (m9460a != null) {
                int round = Math.round(-m9460a.left);
                if (i < m9460a.width()) {
                    i5 = Math.round(m9460a.width() - i);
                    i6 = 0;
                } else {
                    i5 = round;
                    i6 = round;
                }
                int round2 = Math.round(-m9460a.top);
                if (i2 < m9460a.height()) {
                    i7 = Math.round(m9460a.height() - i2);
                    i8 = 0;
                } else {
                    i7 = round2;
                    i8 = round2;
                }
                this.f7509c = round;
                this.f7510d = round2;
                if (round != i5 || round2 != i7) {
                    this.f7508b.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f7508b.isFinished() && this.f7508b.computeScrollOffset()) {
                int currX = this.f7508b.getCurrX();
                int currY = this.f7508b.getCurrY();
                ViewOnLayoutChangeListenerC1104l.this.f7488r.postTranslate(this.f7509c - currX, this.f7510d - currY);
                ViewOnLayoutChangeListenerC1104l.this.m9449m();
                this.f7509c = currX;
                this.f7510d = currY;
                C1093a.m9403a(ViewOnLayoutChangeListenerC1104l.this.f7483m, this);
            }
        }
    }
}
