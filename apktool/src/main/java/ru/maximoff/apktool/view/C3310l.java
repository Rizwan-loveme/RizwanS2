package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.p008os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import java.util.Locale;
import ru.maximoff.apktool.service.ColorPipetteTileService;
import ru.maximoff.apktool.util.C3100bb;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ScreenColorPickerOverlay.java */
/* renamed from: ru.maximoff.apktool.view.l */
/* loaded from: classes.dex */
public class C3310l {

    /* renamed from: g */
    private static C3310l f21148g;

    /* renamed from: A */
    private float f21149A;

    /* renamed from: B */
    private float f21150B;

    /* renamed from: C */
    private boolean f21151C;

    /* renamed from: D */
    private boolean f21152D;

    /* renamed from: E */
    private boolean f21153E;

    /* renamed from: F */
    private boolean f21154F;

    /* renamed from: G */
    private float f21155G;

    /* renamed from: H */
    private float f21156H;

    /* renamed from: I */
    private final float f21157I;

    /* renamed from: J */
    private final float f21158J;

    /* renamed from: K */
    private final float f21159K;

    /* renamed from: a */
    private final Context f21160a;

    /* renamed from: b */
    private final WindowManager f21161b;

    /* renamed from: c */
    private final b f21162c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f21163d;

    /* renamed from: f */
    private final int f21165f;

    /* renamed from: h */
    private C3100bb f21166h;

    /* renamed from: n */
    private final int f21172n;

    /* renamed from: o */
    private final int f21173o;

    /* renamed from: p */
    private Bitmap f21174p;

    /* renamed from: r */
    private int[] f21176r;

    /* renamed from: s */
    private a f21177s;

    /* renamed from: t */
    private c f21178t;

    /* renamed from: u */
    private float f21179u;

    /* renamed from: v */
    private float f21180v;

    /* renamed from: w */
    private int f21181w;

    /* renamed from: x */
    private int f21182x;

    /* renamed from: y */
    private float f21183y;

    /* renamed from: z */
    private float f21184z;

    /* renamed from: i */
    private int f21167i = 0;

    /* renamed from: j */
    private int f21168j = 0;

    /* renamed from: k */
    private int f21169k = 0;

    /* renamed from: l */
    private int f21170l = 0;

    /* renamed from: m */
    private int f21171m = 0;

    /* renamed from: q */
    private int f21175q = 0;

    /* renamed from: e */
    private final DisplayMetrics f21164e = new DisplayMetrics();

    /* compiled from: ScreenColorPickerOverlay.java */
    /* renamed from: ru.maximoff.apktool.view.l$a */
    public interface a {
        /* renamed from: a */
        void m19987a();

        /* renamed from: a */
        void m19988a(int i);

        /* renamed from: b */
        void m19989b(int i);
    }

    /* compiled from: ScreenColorPickerOverlay.java */
    /* renamed from: ru.maximoff.apktool.view.l$c */
    public interface c {
        /* renamed from: a */
        void mo16448a();
    }

    /* renamed from: a */
    public static C3310l m19941a(Context context) {
        if (f21148g == null) {
            f21148g = new C3310l(context.getApplicationContext());
        }
        return f21148g;
    }

    /* renamed from: a */
    public static boolean m19944a() {
        return f21148g != null && f21148g.f21151C;
    }

    C3310l(Context context) {
        this.f21160a = context;
        this.f21165f = Math.round(this.f21160a.getResources().getDisplayMetrics().density);
        this.f21172n = this.f21165f * 2;
        this.f21173o = this.f21165f * 4;
        this.f21157I = this.f21165f * 90;
        this.f21158J = this.f21165f * 18;
        this.f21159K = this.f21165f * 20;
        int i = (int) ((this.f21157I * 2) + (this.f21158J * 2) + (this.f21165f * 8));
        int i2 = (int) ((this.f21157I * 2) + (this.f21159K * 2) + (this.f21158J * 2) + (this.f21165f * 24));
        this.f21161b = (WindowManager) this.f21160a.getSystemService(Context.WINDOW_SERVICE);
        this.f21162c = new b(this, this.f21160a);
        this.f21163d = new WindowManager.LayoutParams(i, i2, Build.VERSION.SDK_INT >= 26 ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY : 2002, 8, -3);
        this.f21163d.gravity = 51;
    }

    /* renamed from: a */
    public void m19980a(C3100bb c3100bb) {
        this.f21166h = c3100bb;
    }

    /* renamed from: a */
    public void m19981a(c cVar) {
        this.f21178t = cVar;
    }

    /* renamed from: a */
    public void m19979a(Bitmap bitmap, int[] iArr) {
        if (iArr != null) {
            this.f21174p = bitmap;
            this.f21176r = iArr;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f21169k = bitmap.getWidth();
                this.f21170l = bitmap.getHeight();
            } else {
                this.f21170l = 0;
                this.f21169k = 0;
            }
            this.f21175q = m19984d();
            this.f21162c.invalidate();
        }
    }

    /* renamed from: b */
    public void m19982b() {
        try {
            m19957h();
            this.f21171m = m19954g();
            this.f21161b.addView(this.f21162c, this.f21163d);
            this.f21151C = true;
            this.f21183y = this.f21167i * 0.5f;
            this.f21184z = this.f21168j * 0.5f;
            m19978a((int) this.f21183y, (int) this.f21184z);
            if (this.f21178t != null) {
                this.f21178t.mo16448a();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                ColorPipetteTileService.m18157a(this.f21160a);
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: c */
    public void m19983c() {
        try {
            this.f21161b.removeView(this.f21162c);
            this.f21151C = false;
            if (this.f21166h != null) {
                this.f21166h.m18894b();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                ColorPipetteTileService.m18157a(this.f21160a);
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: g */
    private int m19954g() {
        int identifier = this.f21160a.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f21160a.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: h */
    private void m19957h() {
        this.f21161b.getDefaultDisplay().getMetrics(this.f21164e);
        this.f21167i = this.f21164e.widthPixels;
        this.f21168j = this.f21164e.heightPixels;
    }

    /* renamed from: a */
    public void m19978a(int i, int i2) {
        this.f21181w = i;
        this.f21182x = this.f21171m + i2;
        this.f21154F = ((float) i2) >= (((float) this.f21163d.height) - m19960j()) - ((float) (this.f21165f * 4));
        float f2 = this.f21163d.width / 2;
        float f3 = i;
        if (f3 >= f2) {
            f2 = f3 > ((float) this.f21167i) - f2 ? this.f21167i - f2 : f3;
        }
        this.f21163d.f283x = Math.round(f2 - (this.f21163d.width * 0.5f));
        this.f21179u = i - this.f21163d.f283x;
        float f4 = this.f21163d.width * 0.5f;
        float f5 = this.f21158J + (this.f21165f * 2);
        if (i < this.f21163d.width / 2) {
            this.f21180v = f4 - Math.min(f5, (this.f21163d.width / 2) - i);
        } else if (i > this.f21167i - (this.f21163d.width / 2)) {
            this.f21180v = f4 + Math.min(f5, i - (this.f21167i - (this.f21163d.width / 2)));
        } else {
            this.f21180v = f4;
        }
        if (this.f21154F) {
            this.f21156H = (this.f21163d.height - m19960j()) - this.f21165f;
            this.f21155G = m19958i() + this.f21165f;
        } else {
            this.f21156H = m19960j() + this.f21165f;
            this.f21155G = (this.f21163d.height - m19958i()) - this.f21165f;
        }
        int i3 = i2 - ((int) this.f21156H);
        if (i3 < 0) {
            this.f21163d.f284y = 0;
            this.f21156H = i2;
        } else if (i3 > this.f21168j - this.f21163d.height) {
            this.f21163d.f284y = this.f21168j - this.f21163d.height;
            this.f21156H = i2 - this.f21163d.f284y;
        } else {
            this.f21163d.f284y = i3;
        }
        this.f21161b.updateViewLayout(this.f21162c, this.f21163d);
        this.f21175q = m19984d();
        if (this.f21177s != null) {
            this.f21177s.m19988a(this.f21175q);
        }
        this.f21162c.invalidate();
    }

    /* renamed from: i */
    private float m19958i() {
        return this.f21157I + ((this.f21158J + this.f21173o) * 0.5f);
    }

    /* renamed from: j */
    private float m19960j() {
        return this.f21159K + (this.f21173o * 0.5f);
    }

    /* renamed from: d */
    public int m19984d() {
        if (this.f21176r != null && this.f21181w >= 0 && this.f21182x >= 0 && this.f21181w < this.f21169k && this.f21182x < this.f21170l) {
            return this.f21176r[(this.f21182x * this.f21169k) + this.f21181w];
        }
        return 0;
    }

    /* renamed from: e */
    public void m19985e() {
        if (this.f21177s != null) {
            this.f21177s.m19989b(m19984d());
        }
    }

    /* renamed from: f */
    public void m19986f() {
        if (this.f21177s != null) {
            this.f21177s.m19987a();
        }
    }

    /* compiled from: ScreenColorPickerOverlay.java */
    /* renamed from: ru.maximoff.apktool.view.l$b */
    private class b extends View {

        /* renamed from: A */
        private boolean f21185A;

        /* renamed from: B */
        private Runnable f21186B;

        /* renamed from: C */
        private String f21187C;

        /* renamed from: D */
        private final C3310l f21188D;

        /* renamed from: a */
        private final Paint f21189a;

        /* renamed from: b */
        private final Paint f21190b;

        /* renamed from: c */
        private final Paint f21191c;

        /* renamed from: d */
        private final Paint f21192d;

        /* renamed from: e */
        private final Paint f21193e;

        /* renamed from: f */
        private final Paint f21194f;

        /* renamed from: g */
        private final Paint f21195g;

        /* renamed from: h */
        private final Paint f21196h;

        /* renamed from: i */
        private final Rect f21197i;

        /* renamed from: j */
        private final RectF f21198j;

        /* renamed from: k */
        private final RectF f21199k;

        /* renamed from: l */
        private final Path f21200l;

        /* renamed from: m */
        private final Path f21201m;

        /* renamed from: n */
        private final int f21202n;

        /* renamed from: o */
        private final int f21203o;

        /* renamed from: p */
        private final int f21204p;

        /* renamed from: q */
        private final int f21205q;

        /* renamed from: r */
        private float f21206r;

        /* renamed from: s */
        private float f21207s;

        /* renamed from: t */
        private float f21208t;

        /* renamed from: u */
        private boolean f21209u;

        /* renamed from: v */
        private boolean f21210v;

        /* renamed from: w */
        private boolean f21211w;

        /* renamed from: x */
        private boolean f21212x;

        /* renamed from: y */
        private boolean f21213y;

        /* renamed from: z */
        private boolean f21214z;

        public b(C3310l c3310l, Context context) {
            super(context);
            this.f21188D = c3310l;
            this.f21189a = new Paint(2);
            this.f21190b = new Paint(1);
            this.f21191c = new Paint(1);
            this.f21192d = new Paint(1);
            this.f21193e = new Paint(1);
            this.f21194f = new Paint(1);
            this.f21195g = new Paint(1);
            this.f21196h = new Paint(1);
            this.f21197i = new Rect();
            this.f21198j = new RectF();
            this.f21199k = new RectF();
            this.f21200l = new Path();
            this.f21201m = new Path();
            this.f21202n = 1073741824;
            this.f21203o = 1090519039;
            this.f21204p = Integer.MIN_VALUE;
            this.f21205q = -2130706433;
            this.f21206r = 10.0f;
            this.f21210v = true;
            this.f21211w = true;
            setLayerType(1, (Paint) null);
            this.f21189a.setFilterBitmap(false);
            this.f21192d.setStyle(Paint.Style.STROKE);
            this.f21192d.setStrokeWidth(this.f21188D.f21165f);
            this.f21193e.setStyle(Paint.Style.STROKE);
            this.f21193e.setStrokeWidth(this.f21188D.f21165f);
            this.f21193e.setColor(-1);
            this.f21190b.setStyle(Paint.Style.STROKE);
            this.f21191c.setFakeBoldText(true);
            this.f21191c.setTextAlign(Paint.Align.CENTER);
            this.f21191c.setTextSize(this.f21188D.f21165f * 12);
            this.f21194f.setColor(-1);
            this.f21195g.setStyle(Paint.Style.STROKE);
            this.f21195g.setColor(-1);
            this.f21196h.setColor(-16777216);
            this.f21196h.setStyle(Paint.Style.FILL);
            this.f21212x = C3102bd.m18925a(context, "pipette_hex_format", true);
            this.f21206r = C3102bd.m18904a(context, "pipette_zoom", 10.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19992a() {
            performHapticFeedback(0);
            this.f21212x = this.f21212x ? false : true;
            C3102bd.m18938b(this.f21188D.f21160a, "pipette_hex_format", this.f21212x);
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m20000b() {
            performHapticFeedback(0);
            this.f21206r = 10.0f;
            C3102bd.m18934b(this.f21188D.f21160a, "pipette_zoom", this.f21206r);
            invalidate();
        }

        /* renamed from: a */
        private void m19996a(String str) {
            this.f21188D.m19985e();
            C3112bn.m19002a(this.f21188D.f21160a, str);
        }

        /* renamed from: c */
        private void m20003c() {
            this.f21188D.m19986f();
            this.f21188D.m19983c();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f21213y = false;
                    float f2 = this.f21188D.f21179u;
                    float height = this.f21188D.f21154F ? (getHeight() - this.f21188D.f21159K) - (this.f21188D.f21165f * 8) : this.f21188D.f21159K + (this.f21188D.f21165f * 8);
                    float x = motionEvent.getX() - f2;
                    float y = motionEvent.getY() - height;
                    this.f21188D.f21152D = (y * y) + (x * x) <= this.f21188D.f21159K * this.f21188D.f21159K;
                    this.f21188D.f21153E = false;
                    if (!this.f21188D.f21152D) {
                        if (m20002b(motionEvent.getX(), motionEvent.getY())) {
                            this.f21188D.f21153E = true;
                            this.f21188D.f21149A = motionEvent.getRawX();
                            this.f21188D.f21150B = motionEvent.getRawY();
                            return true;
                        }
                        if (!m20005c(motionEvent.getX(), motionEvent.getY()) && !m20006d(motionEvent.getX(), motionEvent.getY())) {
                            return false;
                        }
                        this.f21185A = false;
                        this.f21214z = m20006d(motionEvent.getX(), motionEvent.getY());
                        this.f21186B = new Runnable(this) { // from class: ru.maximoff.apktool.view.l.b.1

                            /* renamed from: a */
                            private final b f21215a;

                            {
                                this.f21215a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f21215a.f21185A = true;
                                if (this.f21215a.f21214z) {
                                    this.f21215a.m20000b();
                                } else {
                                    this.f21215a.m19992a();
                                }
                            }
                        };
                        postDelayed(this.f21186B, ViewConfiguration.getLongPressTimeout());
                        return true;
                    }
                    this.f21188D.f21149A = motionEvent.getRawX();
                    this.f21188D.f21150B = motionEvent.getRawY();
                    return true;
                case 1:
                    if (this.f21186B != null) {
                        removeCallbacks(this.f21186B);
                        this.f21186B = (Runnable) null;
                        if (!this.f21185A) {
                            if (this.f21214z && m20006d(motionEvent.getX(), motionEvent.getY())) {
                                m20003c();
                            } else if (!this.f21214z && m20005c(motionEvent.getX(), motionEvent.getY())) {
                                m19996a(this.f21187C);
                            }
                        }
                    }
                    this.f21188D.f21152D = false;
                    this.f21188D.f21153E = false;
                    this.f21209u = false;
                    return true;
                case 2:
                    if (this.f21213y) {
                        return true;
                    }
                    if (this.f21186B != null) {
                        if (!(this.f21214z ? m20006d(motionEvent.getX(), motionEvent.getY()) : m20005c(motionEvent.getX(), motionEvent.getY()))) {
                            removeCallbacks(this.f21186B);
                            this.f21186B = (Runnable) null;
                        }
                    }
                    if (this.f21209u) {
                        if (motionEvent.getPointerCount() < 2) {
                            return false;
                        }
                        this.f21206r = (m19990a(motionEvent) / this.f21207s) * this.f21208t;
                        if (this.f21206r < 4.0f) {
                            this.f21206r = 4.0f;
                        } else if (this.f21206r > 30.0f) {
                            this.f21206r = 30.0f;
                        }
                        C3102bd.m18934b(this.f21188D.f21160a, "pipette_zoom", this.f21206r);
                        invalidate();
                        return true;
                    }
                    if (this.f21188D.f21153E) {
                        float rawX = motionEvent.getRawX() - this.f21188D.f21149A;
                        float rawY = motionEvent.getRawY() - this.f21188D.f21150B;
                        this.f21188D.f21149A = motionEvent.getRawX();
                        this.f21188D.f21150B = motionEvent.getRawY();
                        C3310l c3310l = this.f21188D;
                        c3310l.f21183y = (rawX * 0.1f) + c3310l.f21183y;
                        C3310l c3310l2 = this.f21188D;
                        c3310l2.f21184z = (rawY * 0.1f) + c3310l2.f21184z;
                        if (this.f21188D.f21183y < 0) {
                            this.f21188D.f21183y = 0;
                        } else if (this.f21188D.f21183y >= this.f21188D.f21167i) {
                            this.f21188D.f21183y = this.f21188D.f21167i - 1;
                        }
                        if (this.f21188D.f21184z < 0) {
                            this.f21188D.f21184z = 0;
                        } else if (this.f21188D.f21184z >= this.f21188D.f21168j) {
                            this.f21188D.f21184z = this.f21188D.f21168j - 1;
                        }
                        this.f21188D.m19978a(Math.round(this.f21188D.f21183y), Math.round(this.f21188D.f21184z));
                        return true;
                    }
                    if (!this.f21188D.f21152D) {
                        return false;
                    }
                    float rawX2 = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    this.f21188D.f21183y += rawX2 - this.f21188D.f21149A;
                    this.f21188D.f21184z += rawY2 - this.f21188D.f21150B;
                    this.f21188D.f21149A = rawX2;
                    this.f21188D.f21150B = rawY2;
                    if (this.f21188D.f21183y < 0) {
                        this.f21188D.f21183y = 0;
                    } else if (this.f21188D.f21183y >= this.f21188D.f21167i) {
                        this.f21188D.f21183y = this.f21188D.f21167i - 1;
                    }
                    if (this.f21188D.f21184z < 0) {
                        this.f21188D.f21184z = 0;
                    } else if (this.f21188D.f21184z >= this.f21188D.f21168j) {
                        this.f21188D.f21184z = this.f21188D.f21168j - 1;
                    }
                    this.f21188D.m19978a((int) this.f21188D.f21183y, (int) this.f21188D.f21184z);
                    return true;
                case 3:
                    if (this.f21186B != null) {
                        removeCallbacks(this.f21186B);
                        this.f21186B = (Runnable) null;
                    }
                    this.f21188D.f21152D = false;
                    this.f21188D.f21153E = false;
                    this.f21209u = false;
                    return true;
                case 4:
                default:
                    return false;
                case 5:
                    if (motionEvent.getPointerCount() != 2 || !m20002b(motionEvent.getX(0), motionEvent.getY(0)) || !m20002b(motionEvent.getX(1), motionEvent.getY(1))) {
                        return false;
                    }
                    this.f21209u = true;
                    this.f21188D.f21152D = false;
                    this.f21188D.f21153E = false;
                    this.f21207s = m19990a(motionEvent);
                    this.f21208t = this.f21206r;
                    return true;
                case 6:
                    this.f21209u = false;
                    this.f21188D.f21152D = false;
                    this.f21188D.f21153E = false;
                    this.f21213y = true;
                    return true;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            String stringBuffer;
            int i;
            int i2;
            super.onDraw(canvas);
            float f2 = this.f21188D.f21180v;
            float f3 = this.f21188D.f21179u;
            this.f21198j.set(f2 - this.f21188D.f21157I, this.f21188D.f21155G - this.f21188D.f21157I, this.f21188D.f21157I + f2, this.f21188D.f21155G + this.f21188D.f21157I);
            int m19991a = m19991a(this.f21188D.f21175q);
            if (this.f21188D.f21174p != null && !this.f21188D.f21174p.isRecycled()) {
                int max = Math.max(3, Math.round(this.f21188D.f21157I / this.f21206r));
                if ((max & 1) == 0) {
                    max++;
                }
                int i3 = max / 2;
                int i4 = this.f21188D.f21181w - i3;
                int i5 = this.f21188D.f21182x - i3;
                int i6 = i4 + max;
                int i7 = i5 + max;
                if (i4 < (-this.f21188D.f21159K)) {
                    i = (int) (i6 - (i4 + this.f21188D.f21159K));
                    i4 = -((int) this.f21188D.f21159K);
                } else {
                    i = i6;
                }
                if (i5 < (-this.f21188D.f21159K)) {
                    i2 = (int) (i7 - (i5 + this.f21188D.f21159K));
                    i5 = -((int) this.f21188D.f21159K);
                } else {
                    i2 = i7;
                }
                if (i > this.f21188D.f21169k + this.f21188D.f21159K) {
                    i4 = (int) (i4 - ((i - this.f21188D.f21169k) + this.f21188D.f21159K));
                    i = (int) (this.f21188D.f21169k + this.f21188D.f21159K);
                }
                if (i2 > this.f21188D.f21170l + this.f21188D.f21159K) {
                    i5 = (int) (i5 - ((i2 - this.f21188D.f21170l) + this.f21188D.f21159K));
                    i2 = (int) (this.f21188D.f21170l + this.f21188D.f21159K);
                }
                this.f21197i.set(i4, i5, i, i2);
                this.f21200l.reset();
                this.f21200l.addCircle(f2, this.f21188D.f21155G, this.f21188D.f21157I, Path.Direction.CW);
                canvas.save();
                canvas.clipPath(this.f21200l);
                canvas.drawCircle(f2, this.f21188D.f21155G, this.f21188D.f21157I, this.f21196h);
                canvas.drawBitmap(this.f21188D.f21174p, this.f21197i, this.f21198j, this.f21189a);
                float width = this.f21198j.width() / this.f21197i.width();
                if (this.f21210v) {
                    m19993a(canvas, width);
                }
                if (this.f21211w) {
                    this.f21193e.setColor(m19991a);
                    float f4 = this.f21198j.left + (((this.f21188D.f21181w - this.f21197i.left) + 0.5f) * width);
                    float f5 = this.f21198j.top + (((this.f21188D.f21182x - this.f21197i.top) + 0.5f) * width);
                    canvas.drawRect(f4 - (0.5f * width), f5 - (0.5f * width), f4 + (0.5f * width), f5 + (width * 0.5f), this.f21193e);
                }
                canvas.restore();
            }
            if (this.f21188D.f21154F) {
                m19994a(canvas, 0, f2, this.f21188D.f21155G + this.f21188D.f21157I, f3, this.f21188D.f21156H - this.f21188D.f21159K, this.f21194f);
            } else {
                m19994a(canvas, 0, f2, this.f21188D.f21155G - this.f21188D.f21157I, f3, this.f21188D.f21156H + this.f21188D.f21159K, this.f21194f);
            }
            float f6 = this.f21188D.f21157I - (this.f21188D.f21158J * 0.5f);
            m19995a(canvas, this.f21188D.f21158J, f2, this.f21188D.f21155G, f6, this.f21190b);
            this.f21190b.setStrokeWidth(this.f21188D.f21158J);
            this.f21190b.setColor(-16777216);
            canvas.drawCircle(f2, this.f21188D.f21155G, f6, this.f21190b);
            this.f21190b.setColor(this.f21188D.f21175q);
            canvas.drawCircle(f2, this.f21188D.f21155G, f6, this.f21190b);
            if (this.f21212x) {
                this.f21187C = String.format(Locale.f10688US, "#%08X", new Integer(this.f21188D.f21175q));
                stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f21187C).append(" (").toString()).append(this.f21188D.f21181w).toString()).append(",").toString()).append(this.f21188D.f21182x).toString()).append(")").toString();
            } else {
                String format = String.format(Locale.f10688US, "A,R,G,B: %d,%d,%d,%d", new Integer(Color.alpha(this.f21188D.f21175q)), new Integer(Color.red(this.f21188D.f21175q)), new Integer(Color.green(this.f21188D.f21175q)), new Integer(Color.blue(this.f21188D.f21175q)));
                this.f21187C = format.substring(9);
                stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(format).append(" (").toString()).append(this.f21188D.f21181w).toString()).append(",").toString()).append(this.f21188D.f21182x).toString()).append(")").toString();
            }
            this.f21191c.setColor(m19991a);
            float f7 = this.f21188D.f21157I - (this.f21188D.f21158J * 0.5f);
            this.f21199k.set(f2 - f7, this.f21188D.f21155G - f7, f2 + f7, f7 + this.f21188D.f21155G);
            this.f21201m.reset();
            this.f21201m.addArc(this.f21199k, 180, 180);
            Paint.FontMetrics fontMetrics = this.f21191c.getFontMetrics();
            canvas.drawTextOnPath(stringBuffer, this.f21201m, 0, (-(fontMetrics.ascent + fontMetrics.descent)) * 0.5f, this.f21191c);
            canvas.drawText("×", f2, ((this.f21188D.f21155G + this.f21188D.f21157I) - (this.f21188D.f21158J / 2)) - ((fontMetrics.ascent + fontMetrics.descent) * 0.5f), this.f21191c);
            m19995a(canvas, 0, f3, this.f21188D.f21156H, this.f21188D.f21159K, this.f21195g);
        }

        /* renamed from: a */
        private void m19993a(Canvas canvas, float f2) {
            this.f21192d.setColor(1090519039);
            for (int i = 1; i < this.f21197i.width(); i++) {
                float f3 = (i * f2) + this.f21198j.left;
                canvas.drawLine(f3, this.f21198j.top, f3, this.f21198j.bottom, this.f21192d);
            }
            for (int i2 = 1; i2 < this.f21197i.height(); i2++) {
                float f4 = this.f21198j.top + (i2 * f2);
                canvas.drawLine(this.f21198j.left, f4, this.f21198j.right, f4, this.f21192d);
            }
            this.f21192d.setColor(1073741824);
            for (int i3 = 1; i3 < this.f21197i.width(); i3++) {
                float f5 = (this.f21188D.f21165f * 0.5f) + this.f21198j.left + (i3 * f2);
                canvas.drawLine(f5, this.f21198j.top, f5, this.f21198j.bottom, this.f21192d);
            }
            for (int i4 = 1; i4 < this.f21197i.height(); i4++) {
                float f6 = this.f21198j.top + (i4 * f2) + (this.f21188D.f21165f * 0.5f);
                canvas.drawLine(this.f21198j.left, f6, this.f21198j.right, f6, this.f21192d);
            }
        }

        /* renamed from: a */
        private void m19995a(Canvas canvas, float f2, float f3, float f4, float f5, Paint paint) {
            paint.setColor(-2130706433);
            paint.setStrokeWidth(this.f21188D.f21173o + f2);
            canvas.drawCircle(f3, f4, f5, paint);
            paint.setColor(Integer.MIN_VALUE);
            paint.setStrokeWidth(this.f21188D.f21172n + f2);
            canvas.drawCircle(f3, f4, f5, paint);
        }

        /* renamed from: a */
        private void m19994a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, Paint paint) {
            paint.setColor(-2130706433);
            paint.setStrokeWidth(this.f21188D.f21173o + f2);
            canvas.drawLine(f3, f4, f5, f6, paint);
            paint.setColor(Integer.MIN_VALUE);
            paint.setStrokeWidth(this.f21188D.f21172n + f2);
            canvas.drawLine(f3, f4, f5, f6, paint);
        }

        /* renamed from: a */
        private int m19991a(int i) {
            return ((((Color.red(i) * 77) + (Color.green(i) * 150)) + (Color.blue(i) * 29)) >> 8) >= 128 ? -16777216 : -1;
        }

        /* renamed from: a */
        private boolean m19998a(float f2, float f3) {
            float f4 = f2 - this.f21188D.f21180v;
            float f5 = f3 - this.f21188D.f21155G;
            float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
            return sqrt >= this.f21188D.f21157I - this.f21188D.f21158J && sqrt <= this.f21188D.f21157I;
        }

        /* renamed from: b */
        private boolean m20002b(float f2, float f3) {
            float f4 = f2 - this.f21188D.f21180v;
            float f5 = f3 - this.f21188D.f21155G;
            return (f4 * f4) + (f5 * f5) <= (this.f21188D.f21157I - this.f21188D.f21158J) * (this.f21188D.f21157I - this.f21188D.f21158J);
        }

        /* renamed from: c */
        private boolean m20005c(float f2, float f3) {
            return m19998a(f2, f3) && f3 < this.f21188D.f21155G;
        }

        /* renamed from: d */
        private boolean m20006d(float f2, float f3) {
            return m19998a(f2, f3) && f3 > this.f21188D.f21155G;
        }

        /* renamed from: a */
        private float m19990a(MotionEvent motionEvent) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
    }
}
