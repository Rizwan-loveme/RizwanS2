package ru.maximoff.apktool.view;

import android.C0012R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.SectionIndexer;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: FastScroller.java */
/* renamed from: ru.maximoff.apktool.view.c */
/* loaded from: classes.dex */
public class C3301c {

    /* renamed from: a */
    private static int f20944a = 2;

    /* renamed from: b */
    private static long f20945b = 1500;

    /* renamed from: c */
    private Drawable f20946c;

    /* renamed from: d */
    private int f20947d;

    /* renamed from: e */
    private int f20948e;

    /* renamed from: f */
    private int f20949f;

    /* renamed from: g */
    private Editor f20950g;

    /* renamed from: h */
    private int f20951h;

    /* renamed from: i */
    private Paint f20952i;

    /* renamed from: k */
    private boolean f20954k;

    /* renamed from: l */
    private Object[] f20955l;

    /* renamed from: m */
    private a f20956m;

    /* renamed from: n */
    private int f20957n;

    /* renamed from: p */
    private SectionIndexer f20959p;

    /* renamed from: q */
    private boolean f20960q;

    /* renamed from: j */
    private int f20953j = -1;

    /* renamed from: o */
    private Handler f20958o = new Handler(Looper.getMainLooper());

    public C3301c(Context context, Editor editor) {
        this.f20950g = editor;
        m19835a(context);
    }

    /* renamed from: a */
    public void m19842a(int i) {
        switch (i) {
            case 0:
                this.f20958o.removeCallbacks(this.f20956m);
                this.f20950g.m10897g();
                break;
            case 1:
                this.f20958o.removeCallbacks(this.f20956m);
                if (this.f20957n != 1) {
                    m19838c();
                    break;
                }
                break;
            case 2:
                this.f20958o.removeCallbacks(this.f20956m);
                m19838c();
                break;
            case 3:
                int width = this.f20950g.getWidth();
                this.f20950g.invalidate(width - this.f20948e, this.f20949f, width, this.f20949f + this.f20947d);
                break;
        }
        this.f20957n = i;
    }

    /* renamed from: a */
    public int m19841a() {
        return this.f20957n;
    }

    /* renamed from: c */
    private void m19838c() {
        int width = this.f20950g.getWidth();
        this.f20946c.setBounds(width - this.f20948e, 0, width, this.f20947d);
        this.f20946c.setAlpha(200);
    }

    /* renamed from: a */
    private void m19836a(Context context, Drawable drawable) {
        this.f20946c = drawable;
        this.f20948e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f20947d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f20960q = true;
    }

    /* renamed from: a */
    private void m19835a(Context context) {
        m19836a(context, context.getResources().getDrawable(R.drawable.scrollbar_handle));
        m19839d();
        this.f20956m = new a(this);
        this.f20952i = new Paint();
        this.f20952i.setAntiAlias(true);
        this.f20952i.setTextAlign(Paint.Align.CENTER);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{C0012R.attr.textColorPrimary});
        this.f20952i.setColor(obtainStyledAttributes.getColorStateList(obtainStyledAttributes.getIndex(0)).getDefaultColor());
        this.f20952i.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f20957n = 0;
    }

    /* renamed from: b */
    void m19847b() {
        m19842a(0);
    }

    /* renamed from: a */
    public void m19844a(Canvas canvas) {
        if (this.f20957n != 0) {
            int scrollY = this.f20950g.getScrollY() + this.f20949f;
            int width = this.f20950g.getWidth();
            a aVar = this.f20956m;
            int scrollX = this.f20950g.getScrollX();
            int i = -1;
            if (this.f20957n == 3) {
                i = aVar.m19850b();
                if (i < 100) {
                    this.f20946c.setAlpha(i * 2);
                }
                this.f20946c.setBounds(width - ((this.f20948e * i) / 200), 0, width, this.f20947d);
                this.f20960q = true;
            }
            canvas.translate(scrollX, scrollY);
            this.f20946c.draw(canvas);
            canvas.translate(-scrollX, -scrollY);
            if (i == 0) {
                m19842a(0);
            } else {
                this.f20950g.invalidate(width - this.f20948e, scrollY, width, this.f20947d + scrollY);
            }
        }
    }

    /* renamed from: a */
    void m19843a(int i, int i2, int i3) {
        if (this.f20953j != i3 && i2 > 0) {
            this.f20953j = i3;
            this.f20954k = this.f20953j / i2 >= f20944a;
        }
        if (!this.f20954k) {
            if (this.f20957n != 0) {
                m19842a(0);
                return;
            }
            return;
        }
        if (this.f20957n != 0 || Math.abs(this.f20951h - i) >= C3102bd.f18330m) {
            try {
                int round = Math.round(i / (i3 / i2));
                int round2 = Math.round(round / (i2 / this.f20947d));
                int paddingTop = this.f20950g.getPaddingTop();
                this.f20949f = Math.max(paddingTop, ((round - round2) + paddingTop) - (paddingTop > 0 ? Math.round(round / (i2 / paddingTop)) : 0));
                if (this.f20949f + this.f20947d >= i2) {
                    this.f20949f = i2 - this.f20947d;
                }
                if (this.f20960q) {
                    m19838c();
                    this.f20960q = false;
                }
                this.f20951h = i;
                if (this.f20957n != 2) {
                    m19842a(1);
                    this.f20958o.postDelayed(this.f20956m, f20945b);
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: d */
    private void m19839d() {
        this.f20959p = (SectionIndexer) null;
        this.f20955l = new String[]{" "};
    }

    /* renamed from: b */
    private void m19837b(int i) {
        m19843a(i, this.f20950g.getHeight(), this.f20950g.getMaxScrollY());
        this.f20950g.scrollTo(this.f20950g.getScrollX(), Math.min(this.f20953j, i));
    }

    /* renamed from: e */
    private void m19840e() {
        MotionEvent obtain = MotionEvent.obtain(0, 0, 3, 0, 0, 0);
        this.f20950g.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: a */
    boolean m19846a(MotionEvent motionEvent) {
        if (this.f20957n <= 0 || motionEvent.getAction() != 0 || !m19845a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m19842a(2);
        return true;
    }

    /* renamed from: b */
    boolean m19848b(MotionEvent motionEvent) {
        if (this.f20957n == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m19845a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m19842a(2);
            if (this.f20955l == null) {
                m19839d();
            }
            m19840e();
            return true;
        }
        if (action == 1) {
            if (this.f20957n != 2) {
                return false;
            }
            m19842a(1);
            this.f20958o.postDelayed(this.f20956m, f20945b);
            return true;
        }
        if (action != 2 || this.f20957n != 2) {
            return false;
        }
        m19837b(((int) Math.max(0, motionEvent.getY())) * (this.f20953j / this.f20950g.getHeight()));
        return true;
    }

    /* renamed from: a */
    boolean m19845a(float f2, float f3) {
        return f2 > ((float) (this.f20950g.getWidth() - this.f20948e)) && f3 >= ((float) this.f20949f) && f3 <= ((float) (this.f20949f + this.f20947d));
    }

    /* compiled from: FastScroller.java */
    /* renamed from: ru.maximoff.apktool.view.c$a */
    public class a implements Runnable {

        /* renamed from: a */
        long f20961a;

        /* renamed from: b */
        long f20962b;

        /* renamed from: c */
        private final C3301c f20963c;

        /* renamed from: a */
        void m19849a() {
            this.f20962b = 250L;
            this.f20961a = SystemClock.uptimeMillis();
            this.f20963c.m19842a(3);
        }

        /* renamed from: b */
        int m19850b() {
            if (this.f20963c.m19841a() != 3) {
                return 200;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > this.f20961a + this.f20962b) {
                return 0;
            }
            return (int) (200 - ((200 * (uptimeMillis - this.f20961a)) / this.f20962b));
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20963c.m19841a() != 3) {
                m19849a();
            } else if (m19850b() > 0) {
                this.f20963c.f20950g.m10897g();
            } else {
                this.f20963c.m19842a(0);
            }
        }

        public a(C3301c c3301c) {
            this.f20963c = c3301c;
        }
    }
}
