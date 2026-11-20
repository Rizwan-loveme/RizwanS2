package com.p159h.p160a.p161a;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Handler;
import android.p008os.Looper;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.method.CharacterPickerDialog;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1379a;
import com.p159h.p160a.p162b.C1380b;
import com.p159h.p160a.p162b.C1384f;
import com.p159h.p160a.p162b.C1385g;
import com.p159h.p160a.p162b.C1386h;
import com.p159h.p160a.p162b.C1388j;
import com.p159h.p160a.p162b.C1392n;
import com.p159h.p160a.p162b.C1396r;
import com.p159h.p160a.p162b.C1397s;
import com.p159h.p160a.p162b.C1401w;
import com.p159h.p160a.p162b.InterfaceC1398t;
import com.srizwan.apktool.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import ru.maximoff.apktool.p296a.C2892l;
import ru.maximoff.apktool.p296a.C2893m;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.p304b.C3097b;

/* compiled from: FreeScrollingTextField.java */
/* renamed from: com.h.a.a.c */
/* loaded from: classes.dex */
public class C1371c extends View implements C1385g.a {

    /* renamed from: A */
    private int f8856A;

    /* renamed from: B */
    private int f8857B;

    /* renamed from: C */
    private boolean f8858C;

    /* renamed from: D */
    private boolean f8859D;

    /* renamed from: E */
    private C1370b f8860E;

    /* renamed from: F */
    private ClipboardManager f8861F;

    /* renamed from: G */
    private float f8862G;

    /* renamed from: H */
    private int f8863H;

    /* renamed from: I */
    private int f8864I;

    /* renamed from: J */
    private InterfaceC1374f f8865J;

    /* renamed from: K */
    private int f8866K;

    /* renamed from: L */
    private Typeface f8867L;

    /* renamed from: M */
    private Typeface f8868M;

    /* renamed from: N */
    private Typeface f8869N;

    /* renamed from: O */
    private C1397s<AbstractC1381c.a> f8870O;

    /* renamed from: P */
    private char f8871P;

    /* renamed from: Q */
    private boolean f8872Q;

    /* renamed from: R */
    private Paint f8873R;

    /* renamed from: S */
    private Paint f8874S;

    /* renamed from: T */
    private int f8875T;

    /* renamed from: U */
    private int f8876U;

    /* renamed from: V */
    private int f8877V;

    /* renamed from: W */
    private int f8878W;

    /* renamed from: a */
    protected boolean f8879a;

    /* renamed from: aA */
    private final Runnable f8880aA;

    /* renamed from: aa */
    private boolean f8881aa;

    /* renamed from: ab */
    private InputMethodManager f8882ab;

    /* renamed from: ac */
    private String f8883ac;

    /* renamed from: ad */
    private boolean f8884ad;

    /* renamed from: ae */
    private float f8885ae;

    /* renamed from: af */
    private int f8886af;

    /* renamed from: ag */
    private boolean f8887ag;

    /* renamed from: ah */
    private int f8888ah;

    /* renamed from: ai */
    private int f8889ai;

    /* renamed from: aj */
    private int f8890aj;

    /* renamed from: ak */
    private int f8891ak;

    /* renamed from: al */
    private float f8892al;

    /* renamed from: am */
    private float f8893am;

    /* renamed from: an */
    private float f8894an;

    /* renamed from: ao */
    private int f8895ao;

    /* renamed from: ap */
    private boolean f8896ap;

    /* renamed from: aq */
    private int f8897aq;

    /* renamed from: ar */
    private int f8898ar;

    /* renamed from: as */
    private boolean f8899as;

    /* renamed from: at */
    private boolean f8900at;

    /* renamed from: au */
    private boolean f8901au;

    /* renamed from: av */
    private Rect f8902av;

    /* renamed from: aw */
    private AbstractRunnableC1391m f8903aw;

    /* renamed from: ax */
    private final Runnable f8904ax;

    /* renamed from: ay */
    private final Runnable f8905ay;

    /* renamed from: az */
    private final Runnable f8906az;

    /* renamed from: b */
    protected C1376h f8907b;

    /* renamed from: c */
    protected C1386h f8908c;

    /* renamed from: d */
    protected int f8909d;

    /* renamed from: e */
    protected int f8910e;

    /* renamed from: f */
    protected int f8911f;

    /* renamed from: g */
    protected int f8912g;

    /* renamed from: h */
    protected AbstractC1381c f8913h;

    /* renamed from: i */
    protected boolean f8914i;

    /* renamed from: j */
    protected boolean f8915j;

    /* renamed from: k */
    protected boolean f8916k;

    /* renamed from: l */
    protected int f8917l;

    /* renamed from: m */
    protected boolean f8918m;

    /* renamed from: r */
    protected C1369a f8919r;

    /* renamed from: t */
    private a f8920t;

    /* renamed from: u */
    private C1375g f8921u;

    /* renamed from: v */
    private final Scroller f8922v;

    /* renamed from: w */
    private InterfaceC1398t f8923w;

    /* renamed from: x */
    private InterfaceC1373e f8924x;

    /* renamed from: y */
    private int f8925y;

    /* renamed from: z */
    private Paint f8926z;

    /* renamed from: n */
    protected static float f8851n = 0.75f;

    /* renamed from: o */
    protected static float f8852o = 0.5f;

    /* renamed from: p */
    protected static int f8853p = 4;

    /* renamed from: q */
    protected static int f8854q = 16;

    /* renamed from: s */
    protected static long f8855s = 250;

    /* renamed from: aB */
    private static SparseArray<String> f8850aB = new SparseArray<>();

    public C1371c(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public C1371c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1371c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8879a = false;
        this.f8909d = 0;
        this.f8925y = 0;
        this.f8910e = -1;
        this.f8911f = -1;
        this.f8856A = 0;
        this.f8912g = f8853p;
        this.f8913h = new C1384f();
        this.f8914i = false;
        this.f8915j = false;
        this.f8916k = true;
        this.f8917l = 4;
        this.f8918m = false;
        this.f8857B = 0;
        this.f8858C = true;
        this.f8859D = false;
        this.f8862G = 1.0f;
        this.f8867L = Typeface.DEFAULT;
        this.f8868M = Typeface.DEFAULT_BOLD;
        this.f8869N = Typeface.create(Typeface.DEFAULT, 2);
        this.f8870O = new C1397s<>(0, AbstractC1381c.a.f8995a);
        this.f8877V = 0;
        this.f8878W = 0;
        this.f8881aa = true;
        this.f8884ad = true;
        this.f8885ae = 0.8f;
        this.f8886af = 0;
        this.f8887ag = true;
        this.f8896ap = false;
        this.f8897aq = 0;
        this.f8898ar = 0;
        this.f8899as = false;
        this.f8900at = false;
        this.f8901au = false;
        this.f8902av = new Rect();
        this.f8904ax = new Runnable(this) { // from class: com.h.a.a.c.6

            /* renamed from: a */
            private final C1371c f8935a;

            {
                this.f8935a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8935a.f8920t.m10956f();
                if (this.f8935a.m10918w()) {
                    return;
                }
                this.f8935a.postDelayed(this.f8935a.f8904ax, C1371c.f8855s);
            }
        };
        this.f8905ay = new Runnable(this) { // from class: com.h.a.a.c.7

            /* renamed from: a */
            private final C1371c f8936a;

            {
                this.f8936a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8936a.f8920t.m10957g();
                if (this.f8936a.m10917v()) {
                    return;
                }
                this.f8936a.postDelayed(this.f8936a.f8905ay, C1371c.f8855s);
            }
        };
        this.f8906az = new Runnable(this) { // from class: com.h.a.a.c.8

            /* renamed from: a */
            private final C1371c f8937a;

            {
                this.f8937a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8937a.f8920t.m10946b(false);
                if (this.f8937a.f8909d <= 0 || this.f8937a.f8925y != this.f8937a.f8908c.m11044b(this.f8937a.f8909d - 1)) {
                    return;
                }
                this.f8937a.postDelayed(this.f8937a.f8906az, C1371c.f8855s);
            }
        };
        this.f8880aA = new Runnable(this) { // from class: com.h.a.a.c.9

            /* renamed from: a */
            private final C1371c f8938a;

            {
                this.f8938a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8938a.f8920t.m10942a(false);
                if (this.f8938a.m10919x() || this.f8938a.f8925y != this.f8938a.f8908c.m11044b(this.f8938a.f8909d + 1)) {
                    return;
                }
                this.f8938a.postDelayed(this.f8938a.f8880aA, C1371c.f8855s);
            }
        };
        this.f8908c = new C1386h(this);
        this.f8907b = new C1376h(this);
        this.f8922v = new Scroller(context);
        m10872a(context);
    }

    public void setLexTask(AbstractRunnableC1391m abstractRunnableC1391m) {
        this.f8903aw = abstractRunnableC1391m;
        this.f8919r.m10787a(abstractRunnableC1391m.m11093e());
        this.f8920t.f8940b.m11096a(getLexTask());
        this.f8920t.m10931a();
    }

    public AbstractRunnableC1391m getLexTask() {
        return this.f8903aw;
    }

    /* renamed from: a */
    public boolean m10876a() {
        return this.f8903aw.mo11092d();
    }

    public int getTopOffset() {
        return this.f8866K;
    }

    public void setAutoIndentWidth(int i) {
        this.f8917l = i;
    }

    public int getAutoIndentWidth() {
        return this.f8917l;
    }

    public int getCaretY() {
        return this.f8864I;
    }

    public int getCaretX() {
        return this.f8863H;
    }

    public void setShowLineNumbers(boolean z) {
        this.f8858C = z;
    }

    public void setFixLineNumbers(boolean z) {
        this.f8859D = z;
    }

    /* renamed from: a */
    public void m10874a(boolean z) {
        this.f8901au = z;
    }

    public int getLeftOffset() {
        return this.f8857B;
    }

    public float getTextSize() {
        return this.f8926z.getTextSize();
    }

    public Editable getEditable() {
        return (SpannableStringBuilder) Editable.Factory.getInstance().newEditable(m10890e());
    }

    /* renamed from: a */
    public void m10869a(int i, int i2, String str) {
        this.f8908c.m11048d();
        this.f8920t.m10935a(i, i2, str);
        this.f8920t.m10949c(true);
        this.f8908c.m11050e();
    }

    /* renamed from: b */
    public void m10880b() {
        boolean z;
        m10895f(false);
        if (this.f8903aw instanceof C2893m) {
            try {
                new AsyncTaskC1377i(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            } catch (RejectedExecutionException e2) {
                C3112bn.m18999a(getContext(), R.string.error_try_again);
                return;
            }
        }
        try {
            String c1386h = this.f8908c.toString();
            C1388j c1388j = new C1388j(c1386h.length());
            this.f8909d = this.f8903aw.mo11084a(c1388j, c1386h, this.f8917l, this.f8909d);
            this.f8908c.m11048d();
            this.f8908c.m11035a(0, this.f8908c.m11055h() - 1, System.nanoTime());
            this.f8908c.m11041a(c1388j.toString().toCharArray(), 0, System.nanoTime());
            this.f8908c.m11050e();
            this.f8909d = Math.min(this.f8909d, c1388j.length());
            z = true;
        } catch (Error | Exception e3) {
            C3112bn.m19000a(getContext(), R.string.errorf, e3.getMessage());
            z = false;
        }
        if (z) {
            setEdited(true);
        }
        m10860G();
        m10897g();
        m10907l();
    }

    public int getLength() {
        return this.f8908c.m11055h();
    }

    /* renamed from: a */
    protected void m10872a(Context context) {
        this.f8882ab = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        this.f8903aw = C1396r.f9139c;
        this.f8920t = new a(this);
        this.f8861F = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        this.f8926z = new Paint();
        this.f8926z.setDither(true);
        this.f8926z.setAntiAlias(true);
        this.f8926z.setTextSize(f8854q);
        this.f8873R = new Paint();
        this.f8873R.setDither(true);
        this.f8873R.setAntiAlias(true);
        this.f8873R.setTextSize(f8854q);
        this.f8874S = new Paint();
        this.f8874S.setDither(true);
        this.f8874S.setAntiAlias(true);
        this.f8874S.setStyle(Paint.Style.FILL);
        this.f8888ah = context.getResources().getDimensionPixelSize(R.dimen.magnifier_width);
        this.f8889ai = context.getResources().getDimensionPixelSize(R.dimen.magnifier_height);
        this.f8890aj = context.getResources().getDimensionPixelSize(R.dimen.magnifier_dist);
        this.f8891ak = context.getResources().getDimensionPixelSize(R.dimen.caret_width);
        this.f8892al = m10802a(context, R.dimen.magnifier_scale);
        this.f8893am = m10802a(context, R.dimen.scrollbar_width);
        this.f8894an = m10802a(context, R.dimen.scrollbar_margin);
        this.f8895ao = C3246h.m19470a(context, R.color.editor_scrollbar);
        setLongClickable(true);
        setFocusableInTouchMode(true);
        setHapticFeedbackEnabled(true);
        this.f8883ac = "";
        this.f8923w = new InterfaceC1398t(this) { // from class: com.h.a.a.c.1

            /* renamed from: a */
            private final C1371c f8927a;

            {
                this.f8927a = this;
            }

            @Override // com.p159h.p160a.p162b.InterfaceC1398t
            /* renamed from: a */
            public void mo10922a(int i) {
            }
        };
        this.f8924x = new InterfaceC1373e(this) { // from class: com.h.a.a.c.2

            /* renamed from: a */
            private final C1371c f8931a;

            {
                this.f8931a = this;
            }

            @Override // com.p159h.p160a.p161a.InterfaceC1373e
            /* renamed from: a */
            public void mo10923a(boolean z, int i, int i2) {
                if (z) {
                    this.f8931a.f8860E.m10799a(this.f8931a.f8878W, this.f8931a.f8903aw instanceof C2892l);
                } else {
                    this.f8931a.f8860E.m10798a();
                }
            }
        };
        this.f8865J = new InterfaceC1374f(this) { // from class: com.h.a.a.c.3

            /* renamed from: a */
            private final C1371c f8932a;

            {
                this.f8932a = this;
            }

            @Override // com.p159h.p160a.p161a.InterfaceC1374f
            /* renamed from: a */
            public void mo10925a(String str, int i, int i2) {
                this.f8932a.f8870O.m11132a(this.f8932a.f8870O.m11130a() + 1);
                this.f8932a.f8919r.m10789b();
            }

            @Override // com.p159h.p160a.p161a.InterfaceC1374f
            /* renamed from: a */
            public void mo10924a(CharSequence charSequence, int i, int i2) {
                if (i2 <= this.f8932a.f8870O.m11130a()) {
                    this.f8932a.f8870O.m11132a(this.f8932a.f8870O.m11130a() - 1);
                }
                this.f8932a.f8919r.m10789b();
            }

            @Override // com.p159h.p160a.p161a.InterfaceC1374f
            /* renamed from: b */
            public void mo10926b(CharSequence charSequence, int i, int i2) {
                this.f8932a.f8870O.m11132a(this.f8932a.f8870O.m11130a() + i2);
                int i3 = this.f8932a.f8909d;
                while (i3 >= 0) {
                    char charAt = this.f8932a.f8908c.charAt(i3 - 1);
                    if ((this.f8932a.f8903aw instanceof C2893m) && charAt == '\"') {
                        if (charAt == '\"' && this.f8932a.f8908c.charAt(i3) == '@') {
                            break;
                        }
                        if (charAt == ':' && i3 > 7 && this.f8932a.f8908c.subSequence(i3 - 8, 8).toString().equals("android:")) {
                            this.f8932a.f8919r.m10788a(this.f8932a.f8908c.subSequence(i3 - 8, (this.f8932a.f8909d - i3) + 8));
                            return;
                        }
                    }
                    if (charAt == ' ' || charAt == '\t' || charAt == '\n') {
                        break;
                    } else {
                        i3--;
                    }
                }
                if (this.f8932a.f8909d - i3 > 0) {
                    this.f8932a.f8919r.m10788a(this.f8932a.f8908c.subSequence(i3, this.f8932a.f8909d - i3));
                } else {
                    this.f8932a.f8919r.m10789b();
                }
            }
        };
        setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.h.a.a.c.4

            /* renamed from: a */
            private final C1371c f8933a;

            {
                this.f8933a = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    return;
                }
                this.f8933a.f8919r.m10789b();
            }
        });
        m10883c();
        this.f8860E = new C1370b(this);
        this.f8919r = new C1369a(this);
        this.f8919r.m10787a(getLexTask().m11093e());
        m10897g();
    }

    /* renamed from: c */
    public void m10883c() {
        this.f8909d = 0;
        this.f8925y = 0;
        this.f8856A = 0;
        this.f8920t.m10953d(false);
        this.f8920t.m10949c(true);
        this.f8908c.m11056i();
        m10887d();
        if (getContentWidth() > 0) {
            this.f8908c.m11059l();
        }
        this.f8923w.mo10922a(0);
        scrollTo(0, 0);
    }

    /* renamed from: a */
    private float m10802a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    public void setDocumentProvider(C1386h c1386h) {
        c1386h.m11037a(this);
        this.f8908c = c1386h;
        m10883c();
        this.f8920t.m10943b();
        this.f8920t.m10931a();
        m10897g();
    }

    /* renamed from: d */
    public void m10887d() {
        m10862I();
        int measureText = ((int) this.f8926z.measureText(String.valueOf(this.f8908c.m11053g()))) + this.f8876U;
        if (this.f8858C) {
            this.f8857B = measureText + (this.f8876U / 2);
        } else {
            this.f8857B = 0;
        }
    }

    /* renamed from: e */
    public C1386h m10890e() {
        return new C1386h(this.f8908c);
    }

    public C1386h getDocumentProvider() {
        return this.f8908c;
    }

    public a getFieldController() {
        return this.f8920t;
    }

    /* renamed from: a */
    public void m10868a(int i) {
        this.f8878W = i;
    }

    public void setRowListener(InterfaceC1398t interfaceC1398t) {
        this.f8923w = interfaceC1398t;
    }

    public void setOnSelectionChangedListener(InterfaceC1373e interfaceC1373e) {
        this.f8924x = interfaceC1373e;
    }

    public void setCaretPosition(int i) {
        this.f8909d = i;
    }

    public void setNavigationMethod(C1376h c1376h) {
        this.f8907b = c1376h;
    }

    public void setChirality(boolean z) {
        this.f8907b.m10980a(z);
    }

    public void setEdited(boolean z) {
        this.f8879a = z;
    }

    /* renamed from: b */
    public void m10881b(boolean z) {
        this.f8881aa = z;
    }

    /* renamed from: c */
    public void m10885c(boolean z) {
        this.f8884ad = z;
    }

    /* renamed from: d */
    public void m10889d(boolean z) {
        this.f8887ag = z;
    }

    public void setCharset(String str) {
        this.f8883ac = str;
        m10897g();
    }

    /* renamed from: a */
    public void m10875a(boolean z, int i, int i2) {
        this.f8896ap = z;
        this.f8897aq = i;
        this.f8898ar = i2;
    }

    /* renamed from: e */
    public void m10893e(boolean z) {
        if (!z) {
            this.f8877V = 0;
        } else {
            this.f8877V = 131073;
        }
    }

    /* renamed from: f */
    public boolean m10896f() {
        return this.f8879a;
    }

    /* renamed from: g */
    public void m10897g() {
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(16);
        }
    }

    protected void setFastScrollEnabled(boolean z) {
        this.f8900at = z;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = this.f8877V;
        editorInfo.imeOptions = 1342177286;
        editorInfo.initialSelEnd = getSelectionEnd();
        editorInfo.initialSelStart = getSelectionStart();
        if (this.f8921u == null) {
            this.f8921u = new C1375g(this);
        } else {
            this.f8921u.m10971a();
        }
        return this.f8921u;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public boolean isSaveEnabled() {
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m10842k(i), m10842k(i2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.f8866K = (rect.height() + rect.top) - getHeight();
            if (!this.f8872Q) {
                m10860G();
            }
            this.f8872Q = i3 > 0;
            m10897g();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f8908c.m11058k() && i3 != i) {
            this.f8908c.m11059l();
        }
        this.f8920t.m10958h();
        if (i2 < i4) {
            m10849n(this.f8909d);
        }
        this.f8902av.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    }

    /* renamed from: k */
    private int m10842k(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            C1401w.m11173a("MeasureSpec cannot be UNSPECIFIED. Setting dimensions to max.");
            return Integer.MAX_VALUE;
        }
        return size;
    }

    /* renamed from: a */
    public void m10870a(int i, int i2, boolean z) {
        int m11049e;
        int m11049e2;
        int m11049e3;
        if (i < 1) {
            i = 1;
        } else if (i > getLineCount()) {
            i = getLineCount();
        }
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > getLineCount()) {
            i2 = getLineCount();
        }
        if (i == i2) {
            int m11049e4 = this.f8908c.m11049e(i - 1);
            if (i2 == getLineCount()) {
                m11049e3 = (getLength() - m11049e4) - 1;
            } else {
                m11049e3 = this.f8908c.m11049e(i2) - m11049e4;
            }
            m10892e(m11049e4, m11049e3);
        } else if (i < i2) {
            int m11049e5 = this.f8908c.m11049e(i - 1);
            if (i2 == getLineCount()) {
                m11049e2 = (getLength() - m11049e5) - 1;
            } else {
                m11049e2 = this.f8908c.m11049e(i2) - m11049e5;
            }
            m10892e(m11049e5, m11049e2);
        } else {
            int m11049e6 = this.f8908c.m11049e(i2 - 1);
            if (i == getLineCount()) {
                m11049e = (getLength() - m11049e6) - 1;
            } else {
                m11049e = this.f8908c.m11049e(i) - m11049e6;
            }
            m10892e(m11049e6, m11049e);
        }
        if (z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.h.a.a.c.5

                /* renamed from: a */
                private final C1371c f8934a;

                {
                    this.f8934a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f8934a.f8920t.m10962l();
                }
            }, 100L);
        }
    }

    public String getLineText() {
        return m10879b(getLineNumber() + 1);
    }

    /* renamed from: b */
    public String m10879b(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > getLineCount()) {
            i = getLineCount();
        }
        int m11049e = this.f8908c.m11049e(i - 1);
        int length = i == getLineCount() ? (getLength() - m11049e) - 1 : this.f8908c.m11049e(i) - m11049e;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(this.f8908c.charAt(m11049e + i2));
        }
        return sb.toString();
    }

    protected int getNumVisibleRows() {
        return (int) Math.ceil(getContentHeight() / m10900h());
    }

    /* renamed from: h */
    protected int m10900h() {
        Paint.FontMetricsInt fontMetricsInt = this.f8926z.getFontMetricsInt();
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }

    /* renamed from: i */
    protected int m10902i() {
        float textSize = this.f8873R.getTextSize();
        this.f8873R.setTextSize(this.f8885ae * textSize);
        Paint.FontMetricsInt fontMetricsInt = this.f8926z.getFontMetricsInt();
        int i = fontMetricsInt.descent - fontMetricsInt.ascent;
        this.f8873R.setTextSize(textSize);
        return i;
    }

    public int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        int paddingTop = super.getPaddingTop();
        if (this.f8884ad) {
            return paddingTop + m10902i();
        }
        return paddingTop;
    }

    public int getRealPaddingTop() {
        return super.getPaddingTop();
    }

    /* renamed from: a */
    private int m10803a(Canvas canvas) {
        return canvas.getClipBounds().top / m10900h();
    }

    /* renamed from: b */
    private int m10818b(Canvas canvas) {
        return (canvas.getClipBounds().bottom - 1) / m10900h();
    }

    /* renamed from: c */
    public int m10882c(int i) {
        return ((i + 1) * m10900h()) - this.f8926z.getFontMetricsInt().descent;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getRealPaddingTop());
        canvas.clipRect(getScrollX() + getPaddingLeft(), getScrollY() + getRealPaddingTop(), (getScrollX() + getWidth()) - getPaddingRight(), (getScrollY() + getHeight()) - getPaddingBottom());
        m10812a(canvas, false);
        canvas.restore();
        this.f8907b.mo10978a(canvas);
    }

    /* renamed from: a */
    private void m10812a(Canvas canvas, boolean z) {
        int m11130a;
        C1397s<AbstractC1381c.a> m10807a;
        boolean z2;
        int i;
        boolean z3;
        AbstractC1381c.a aVar;
        int i2;
        C1397s<AbstractC1381c.a> c1397s;
        int i3;
        int i4;
        int m10865a;
        int m10825c;
        int m11009a;
        boolean z4;
        int m10803a = m10803a(canvas);
        int m11047d = this.f8908c.m11047d(m10803a);
        if (m11047d >= 0) {
            int measureText = ((int) this.f8926z.measureText(String.valueOf(this.f8908c.m11053g()))) + this.f8876U;
            int m11045c = m10861H() ? this.f8908c.m11045c(m11047d) + 1 : m10803a + 1;
            int i5 = 0;
            if (this.f8858C) {
                this.f8857B = (this.f8876U / 2) + measureText;
            } else {
                this.f8857B = 0;
            }
            if (this.f8859D) {
                this.f8886af = measureText - this.f8876U;
            } else {
                this.f8886af = 0;
            }
            int m10818b = m10818b(canvas);
            int m10882c = m10882c(m10803a);
            int m10902i = (!this.f8884ad || z) ? m10882c : m10882c + m10902i();
            Iterator<C1397s<AbstractC1381c.a>> it = this.f8908c.m11057j().iterator();
            C1401w.m11174a(!it.hasNext(), "No spans to paint in TextWarrior.paint()");
            C1397s<AbstractC1381c.a> m10807a2 = m10807a(it);
            while (true) {
                m11130a = m10807a2.m11130a();
                m10807a = m10807a(it);
                if (m10807a == null || m11130a >= m11047d) {
                    break;
                } else {
                    m10807a2 = m10807a;
                }
            }
            AbstractC1381c.a m11134b = m10807a2.m11134b();
            if (m11134b.equals(AbstractC1381c.a.f9004j)) {
                this.f8926z.setTypeface(this.f8868M);
                z2 = false;
            } else if (m11134b.equals(AbstractC1381c.a.f9003i)) {
                this.f8926z.setTypeface(this.f8869N);
                z2 = false;
            } else if (m11134b.equals(AbstractC1381c.a.f9013s)) {
                this.f8926z.setTypeface(this.f8867L);
                z2 = true;
            } else {
                this.f8926z.setTypeface(this.f8867L);
                z2 = false;
            }
            this.f8926z.setColor(this.f8913h.m11009a(m10807a2.m11134b()));
            int m11051f = this.f8908c.m11051f();
            m10823b(canvas, z);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i6 = -1;
            int i7 = -1;
            boolean z5 = z2;
            AbstractC1381c.a aVar2 = m11134b;
            C1397s<AbstractC1381c.a> c1397s2 = m10807a2;
            C1397s<AbstractC1381c.a> c1397s3 = m10807a;
            int i8 = m10902i;
            int i9 = m11045c;
            for (int i10 = m10803a; i10 <= m10818b && i10 <= m11051f; i10++) {
                int m11054g = this.f8908c.m11054g(i10);
                int i11 = this.f8857B;
                int i12 = 0;
                AbstractC1381c.a aVar3 = aVar2;
                int i13 = m11130a;
                while (i12 < m11054g) {
                    if (c1397s3 == null || m11047d <= i13) {
                        z3 = z5;
                        aVar = aVar3;
                        i2 = i13;
                        c1397s = c1397s3;
                    } else {
                        i2 = c1397s3.m11130a();
                        AbstractC1381c.a m11134b2 = c1397s3.m11134b();
                        if (aVar3 != m11134b2) {
                            if (m11134b2.equals(AbstractC1381c.a.f9004j)) {
                                this.f8926z.setTypeface(this.f8868M);
                                z4 = false;
                            } else if (m11134b2.equals(AbstractC1381c.a.f9003i)) {
                                this.f8926z.setTypeface(this.f8869N);
                                z4 = false;
                            } else if (m11134b2.equals(AbstractC1381c.a.f9013s)) {
                                this.f8926z.setTypeface(this.f8867L);
                                z4 = true;
                            } else {
                                this.f8926z.setTypeface(this.f8867L);
                                z4 = false;
                            }
                            this.f8926z.setColor(this.f8913h.m11009a(c1397s3.m11134b()));
                        } else {
                            z4 = z5;
                        }
                        z3 = z4;
                        aVar = m11134b2;
                        c1397s2 = c1397s3;
                        c1397s = m10807a(it);
                    }
                    char charAt = this.f8908c.charAt(m11047d);
                    if (this.f8881aa && charAt == '#') {
                        int[] m10845l = m10845l(m11047d);
                        i4 = m10845l[0];
                        i3 = m10845l[1];
                    } else {
                        i3 = i7;
                        i4 = i6;
                    }
                    if (i11 < getScrollX() - this.f8876U || i11 > getScrollX() + getWidth() + this.f8876U) {
                        if (m11047d + 1 == this.f8909d) {
                            this.f8870O = c1397s2;
                        } else if (m11047d == this.f8909d) {
                            this.f8863H = i11;
                            this.f8864I = i8;
                        }
                        m10865a = m10865a(charAt, i11) + i11;
                        if (m10828c(charAt)) {
                            this.f8871P = charAt;
                        } else {
                            this.f8871P = (char) 0;
                        }
                        if (i3 >= 0) {
                            i3--;
                        }
                    } else {
                        if (this.f8920t.m10947b(m11047d)) {
                            m10825c = m10819b(canvas, charAt, i11, i8);
                        } else if (z3 || this.f8903aw.mo11089a(m11047d)) {
                            m10825c = m10825c(canvas, charAt, i11, i8);
                        } else if (i3 >= 0) {
                            Typeface typeface = this.f8926z.getTypeface();
                            this.f8926z.setTypeface(this.f8867L);
                            m10825c = m10805a(canvas, i4, charAt, i11, i8);
                            this.f8926z.setTypeface(typeface);
                        } else {
                            m10825c = m10804a(canvas, charAt, i11, i8);
                        }
                        if (m11047d + 1 == this.f8909d) {
                            this.f8870O = c1397s2;
                        } else if (m11047d == this.f8909d) {
                            if (i3 >= 0) {
                                if (Color.alpha(i4) > 70) {
                                    m11009a = this.f8913h.m11010a(AbstractC1381c.a.f9014t, C3097b.m18818a(i4) ? 1 : 0);
                                } else {
                                    m11009a = this.f8913h.m11009a(AbstractC1381c.a.f9014t);
                                }
                            } else {
                                m11009a = this.f8913h.m11009a(AbstractC1381c.a.f9000f);
                            }
                            m10821b(canvas, i11, i8, m11009a);
                        }
                        m10865a = m10825c + i11;
                        if (i3 >= 0) {
                            i3--;
                        }
                    }
                    i7 = i3;
                    i11 = m10865a;
                    m11047d++;
                    i12++;
                    i6 = i4;
                    z5 = z3;
                    aVar3 = aVar;
                    i13 = i2;
                    c1397s3 = c1397s;
                }
                int i14 = this.f8908c.charAt(m11047d + (-1)) == '\n' ? i9 + 1 : i9;
                if (!this.f8858C || i9 == i5) {
                    i = i5;
                } else {
                    linkedHashMap.put(String.valueOf(i9), new Integer(i8));
                    i = i9;
                }
                i8 += m10900h();
                if (i11 > this.f8856A) {
                    this.f8856A = i11;
                }
                aVar2 = aVar3;
                m11130a = i13;
                i5 = i;
                i9 = i14;
            }
            if (this.f8858C && (this.f8859D || getScrollX() < measureText + 1)) {
                int scrollX = this.f8859D ? getScrollX() : 0;
                int m10900h = m10900h();
                m10810a(canvas, scrollX, m10902i - m10900h, measureText, getHeight() + (m10900h * 2));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    m10811a(canvas, (String) entry.getKey(), scrollX, ((Integer) entry.getValue()).intValue());
                }
            }
            if (this.f8884ad && !z) {
                m10822b(canvas, getScrollX(), getScrollY(), getContentWidth(), m10902i());
            }
            m10827c(canvas);
            if (!this.f8887ag || !this.f8896ap || z) {
                return;
            }
            m10832d(canvas);
        }
    }

    /* renamed from: c */
    private void m10827c(Canvas canvas) {
        if (this.f8893am > 0) {
            if (this.f8894an < 0) {
                this.f8894an = 0.0f;
            }
            int color = this.f8873R.getColor();
            this.f8873R.setColor(Color.GRAY);
            int width = getWidth();
            int height = getHeight();
            int maxScrollX = getMaxScrollX();
            int maxScrollY = getMaxScrollY();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (maxScrollY > height) {
                float max = Math.max((height / (height + maxScrollY)) * height, this.f8893am);
                float f2 = (scrollY / maxScrollY) * (height - max);
                canvas.drawRect(((scrollX + width) - this.f8893am) - this.f8894an, scrollY + f2, (scrollX + width) - this.f8894an, max + f2 + scrollY, this.f8873R);
            }
            if (maxScrollX > width) {
                float max2 = Math.max((width / (width + maxScrollX)) * width, this.f8893am);
                float f3 = (scrollX / maxScrollX) * (width - max2);
                canvas.drawRect(scrollX + f3, ((scrollY + height) - this.f8893am) - this.f8894an, f3 + scrollX + max2, (scrollY + height) - this.f8894an, this.f8873R);
            }
            this.f8873R.setColor(color);
        }
    }

    public String getState() {
        return m10920y() ? getContext().getString(R.string.editor_state_str2, new Integer(getLineNumber() + 1), new Integer(getLineCount()), new Integer(this.f8909d), new Integer(this.f8909d - this.f8908c.m11047d(this.f8925y)), new Integer(getSelectionRange()), new Integer(getSelectionStart()), new Integer(getSelectionEnd()), this.f8883ac) : getContext().getString(R.string.editor_state_str, new Integer(getLineNumber() + 1), new Integer(getLineCount()), new Integer(this.f8909d), new Integer(this.f8909d - this.f8908c.m11047d(this.f8925y)), this.f8883ac);
    }

    /* renamed from: a */
    private C1397s<AbstractC1381c.a> m10807a(Iterator<C1397s<AbstractC1381c.a>> it) {
        return it.hasNext() ? it.next() : (C1397s) null;
    }

    public Bitmap getScreenBitmap() {
        return m10867a(0, 0, getWidth(), getHeight());
    }

    /* renamed from: a */
    public Bitmap m10867a(int i, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        int scrollX = getScrollX() + i + getPaddingLeft();
        int scrollY = getScrollY() + i2 + getRealPaddingTop();
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-scrollX, -scrollY);
        canvas.clipRect(scrollX, scrollY, scrollX + i3, scrollY + i4);
        m10812a(canvas, true);
        return createBitmap;
    }

    /* renamed from: d */
    private void m10832d(Canvas canvas) {
        int i;
        int i2;
        int i3;
        if (((getScrollY() + this.f8898ar) - (getContentHeight() / 2)) - this.f8907b.mo10977a().bottom < getMaxScrollY()) {
            int round = Math.round(this.f8888ah * this.f8892al);
            int round2 = Math.round(this.f8889ai * this.f8892al);
            if (this.f8898ar < this.f8890aj + round2 + getPaddingTop()) {
                i2 = getPaddingTop();
                if (this.f8897aq < getWidth() / 2) {
                    i3 = this.f8897aq + this.f8890aj;
                } else {
                    i3 = (this.f8897aq - this.f8890aj) - round;
                }
                i = i3;
            } else {
                int paddingTop = ((this.f8898ar - this.f8890aj) - round2) - getPaddingTop();
                i = this.f8897aq - (round / 2);
                i2 = paddingTop;
            }
            int max = Math.max(getScrollX() + 1, Math.min((i + getScrollX()) - 1, ((getScrollX() + getWidth()) - round) - 2));
            int max2 = Math.max(getScrollY() + getPaddingTop() + 1, Math.min((i2 + getScrollY()) - 1, (getScrollY() + getHeight()) - round2));
            this.f8874S.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8995a));
            canvas.drawRect(max - 1, max2 - 1, max + round + 1, max2 + round2 + 1, this.f8874S);
            this.f8874S.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8996b));
            canvas.drawRect(max, max2, max + round, max2 + round2, this.f8874S);
            Bitmap m10867a = m10867a(Math.min(getWidth() - this.f8888ah, Math.max(0, this.f8897aq - (this.f8888ah / 2))), Math.min(getHeight() - this.f8889ai, Math.max(0, (this.f8898ar - getPaddingTop()) - this.f8889ai)), this.f8888ah, this.f8889ai);
            canvas.drawBitmap(m10867a, new Rect(0, 0, this.f8888ah - 1, this.f8889ai - 1), new Rect(max, max2, max + round, max2 + round2), (Paint) null);
            m10867a.recycle();
        }
    }

    /* renamed from: b */
    private void m10823b(Canvas canvas, boolean z) {
        if (this.f8914i) {
            int m10882c = m10882c(this.f8908c.m11044b(this.f8909d));
            if (this.f8884ad && !z) {
                m10882c += m10902i();
            }
            int color = this.f8926z.getColor();
            this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9001g));
            m10809a(canvas, Math.max(0, getScrollX() - this.f8876U), m10882c, getContentWidth() + this.f8876U);
            this.f8926z.setColor(color);
        }
    }

    /* renamed from: a */
    private int m10804a(Canvas canvas, char c2, int i, int i2) {
        int m10865a = m10865a(c2, i);
        if (i >= getScrollX() - this.f8876U || i <= getScrollX() + getWidth() + this.f8876U) {
            int color = this.f8926z.getColor();
            switch (c2) {
                case '\t':
                    if (this.f8915j) {
                        this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9002h));
                        canvas.drawText("»", 0, 1, i, i2, this.f8926z);
                        this.f8926z.setColor(color);
                        break;
                    }
                    break;
                case '\n':
                case 65535:
                    if (this.f8915j) {
                        this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9002h));
                        canvas.drawText(AbstractC1389k.f9028a, 0, 1, i, i2, this.f8926z);
                        this.f8926z.setColor(color);
                        break;
                    }
                    break;
                case ' ':
                    if (this.f8915j) {
                        this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9002h));
                        canvas.drawText(AbstractC1389k.f9029b, 0, 1, i, i2, this.f8926z);
                        this.f8926z.setColor(color);
                        break;
                    } else {
                        canvas.drawText(" ", 0, 1, i, i2, this.f8926z);
                        break;
                    }
                case 55356:
                case 55357:
                case 55358:
                    this.f8871P = c2;
                    break;
                default:
                    if (this.f8871P != 0) {
                        canvas.drawText(new char[]{this.f8871P, c2}, 0, 2, i, i2, this.f8926z);
                        this.f8871P = (char) 0;
                        break;
                    } else {
                        canvas.drawText(new char[]{c2}, 0, 1, i, i2, this.f8926z);
                        break;
                    }
            }
        }
        return m10865a;
    }

    /* renamed from: a */
    private void m10809a(Canvas canvas, int i, int i2, int i3) {
        Paint.FontMetricsInt fontMetricsInt = this.f8926z.getFontMetricsInt();
        canvas.drawRect(i, fontMetricsInt.ascent + i2, i + i3, fontMetricsInt.descent + i2, this.f8926z);
    }

    /* renamed from: a */
    private void m10810a(Canvas canvas, int i, int i2, int i3, int i4) {
        int color = this.f8873R.getColor();
        this.f8873R.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9012r));
        canvas.drawLine(i + i3 + 1, i2, i + i3 + 1, i2 + i4, this.f8873R);
        this.f8873R.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9011q));
        canvas.drawRect(i, i2, i + i3, i2 + i4, this.f8873R);
        this.f8873R.setColor(color);
    }

    /* renamed from: b */
    private void m10822b(Canvas canvas, int i, int i2, int i3, int i4) {
        String state = getState();
        int color = this.f8873R.getColor();
        float textSize = this.f8873R.getTextSize();
        float f2 = textSize * this.f8885ae;
        this.f8873R.setTextSize(f2);
        int measureText = ((int) this.f8873R.measureText(state)) + (this.f8876U / 2);
        while (measureText > i3) {
            f2 -= 0.1f;
            this.f8873R.setTextSize(f2);
            measureText = ((int) this.f8873R.measureText(state)) + (this.f8876U / 2);
        }
        Paint.FontMetricsInt fontMetricsInt = this.f8873R.getFontMetricsInt();
        float f3 = ((i4 / 2) + i2) - ((fontMetricsInt.ascent + fontMetricsInt.descent) / 2);
        this.f8873R.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9011q));
        canvas.drawRect(i, i2, i + i3, i2 + i4, this.f8873R);
        this.f8873R.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8995a));
        canvas.drawLine(i, i2 + i4, i + i3, i2 + i4, this.f8873R);
        canvas.drawText(state, (i + i3) - measureText, f3, this.f8873R);
        this.f8873R.setTextSize(textSize);
        this.f8873R.setColor(color);
    }

    /* renamed from: a */
    private void m10811a(Canvas canvas, String str, int i, int i2) {
        int color = this.f8873R.getColor();
        float measureText = (((int) this.f8873R.measureText(String.valueOf(this.f8908c.m11053g()))) - ((int) this.f8873R.measureText(str))) + (this.f8876U / 2);
        this.f8873R.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9012r));
        canvas.drawText(str, measureText + i, i2, this.f8873R);
        this.f8873R.setColor(color);
    }

    /* renamed from: b */
    private int m10819b(Canvas canvas, char c2, int i, int i2) {
        int mo10864a = mo10864a(c2);
        if (i >= getScrollX() - this.f8876U || i <= getScrollX() + getWidth() + this.f8876U) {
            int color = this.f8926z.getColor();
            this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8998d));
            m10809a(canvas, i, i2, mo10864a);
            this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8997c));
            m10804a(canvas, c2, i, i2);
            this.f8926z.setColor(color);
        }
        return mo10864a;
    }

    /* renamed from: c */
    private int m10825c(Canvas canvas, char c2, int i, int i2) {
        int mo10864a = mo10864a(c2);
        if (i >= getScrollX() - this.f8876U || i <= getScrollX() + getWidth() + this.f8876U) {
            int color = this.f8926z.getColor();
            this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9013s));
            m10809a(canvas, i, i2, mo10864a);
            this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f8997c));
            m10804a(canvas, c2, i, i2);
            this.f8926z.setColor(color);
        }
        return mo10864a;
    }

    /* renamed from: a */
    private int m10805a(Canvas canvas, int i, char c2, int i2, int i3) {
        int mo10864a = mo10864a(c2);
        if (i2 >= getScrollX() - this.f8876U || i2 <= getScrollX() + getWidth() + this.f8876U) {
            int color = this.f8926z.getColor();
            this.f8926z.setColor(i);
            m10809a(canvas, i2, i3, mo10864a);
            if (Color.alpha(i) > 70) {
                this.f8926z.setColor(this.f8913h.m11010a(AbstractC1381c.a.f9014t, C3097b.m18818a(i) ? 1 : 0));
            } else {
                this.f8926z.setColor(this.f8913h.m11009a(AbstractC1381c.a.f9014t));
            }
            m10804a(canvas, c2, i2, i3);
            this.f8926z.setColor(color);
        }
        return mo10864a;
    }

    /* renamed from: l */
    private int[] m10845l(int i) {
        int i2;
        int i3;
        int i4 = 1;
        try {
            String charSequence = this.f8908c.subSequence(i, 9).toString();
            if (!charSequence.matches("^#[0-9a-fA-F]+$")) {
                if (!charSequence.substring(0, 7).matches("^#[0-9a-fA-F]+$")) {
                    if (!charSequence.substring(0, 5).matches("^#[0-9a-fA-F]+$")) {
                        if (charSequence.substring(0, 4).matches("^#[0-9a-fA-F]+$")) {
                            StringBuilder sb = new StringBuilder();
                            while (i4 < 4) {
                                sb.append(charSequence.charAt(i4)).append(charSequence.charAt(i4));
                                i4++;
                            }
                            i2 = 3;
                            i3 = Color.parseColor(new StringBuffer().append("#").append(sb.toString()).toString());
                        } else {
                            i2 = -1;
                            i3 = -1;
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        while (i4 < 5) {
                            sb2.append(charSequence.charAt(i4)).append(charSequence.charAt(i4));
                            i4++;
                        }
                        i2 = 4;
                        i3 = Color.parseColor(new StringBuffer().append("#").append(sb2.toString()).toString());
                    }
                } else {
                    i2 = 6;
                    i3 = Color.parseColor(charSequence.substring(0, 7));
                }
            } else {
                i2 = 8;
                i3 = Color.parseColor(charSequence.toString());
            }
            return new int[]{i3, i2};
        } catch (Exception e2) {
            return new int[]{-1, -1};
        }
    }

    /* renamed from: b */
    private void m10821b(Canvas canvas, int i, int i2, int i3) {
        int color = this.f8926z.getColor();
        this.f8863H = i;
        this.f8864I = i2;
        this.f8926z.setColor(i3);
        m10809a(canvas, i - (this.f8891ak / 2), i2, this.f8891ak);
        this.f8926z.setColor(color);
    }

    /* renamed from: c */
    private boolean m10828c(char c2) {
        return c2 == 55356 || c2 == 55357 || c2 == 55358;
    }

    public int getLineCount() {
        return this.f8908c.m11053g();
    }

    @Override // com.p159h.p160a.p162b.C1385g.a
    public final int getRowWidth() {
        return (getContentWidth() - this.f8857B) - this.f8876U;
    }

    public int getLineHeight() {
        return m10900h();
    }

    @Override // com.p159h.p160a.p162b.C1385g.a
    /* renamed from: a */
    public int mo10864a(char c2) {
        switch (c2) {
            case '\t':
                return getTabAdvance();
            case '\n':
            case 65535:
                return getEOLAdvance();
            case ' ':
                return getSpaceAdvance();
            case 55356:
            case 55357:
            case 55358:
                return 0;
            default:
                if (this.f8871P != 0) {
                    return (int) this.f8926z.measureText(new char[]{this.f8871P, c2}, 0, 2);
                }
                return (int) this.f8926z.measureText(new char[]{c2}, 0, 1);
        }
    }

    /* renamed from: a */
    public int m10865a(char c2, int i) {
        switch (c2) {
            case '\t':
                return m10886d(i);
            case '\n':
            case 65535:
                return getEOLAdvance();
            case ' ':
                return getSpaceAdvance();
            case 55356:
            case 55357:
            case 55358:
                return 0;
            default:
                if (this.f8871P != 0) {
                    return (int) this.f8926z.measureText(new char[]{this.f8871P, c2}, 0, 2);
                }
                return (int) this.f8926z.measureText(new char[]{c2}, 0, 1);
        }
    }

    /* renamed from: b */
    public int m10877b(char c2) {
        return (int) this.f8926z.measureText(new char[]{c2}, 0, 1);
    }

    protected int getSpaceAdvance() {
        return this.f8915j ? (int) this.f8926z.measureText(AbstractC1389k.f9029b, 0, AbstractC1389k.f9029b.length()) : this.f8876U;
    }

    protected int getEOLAdvance() {
        return this.f8915j ? (int) this.f8926z.measureText(AbstractC1389k.f9028a, 0, AbstractC1389k.f9028a.length()) : (int) (f8851n * this.f8926z.measureText(" ", 0, 1));
    }

    protected int getTabAdvance() {
        return this.f8915j ? this.f8912g * ((int) this.f8926z.measureText(AbstractC1389k.f9029b, 0, AbstractC1389k.f9029b.length())) : this.f8912g * this.f8876U;
    }

    /* renamed from: d */
    protected int m10886d(int i) {
        int i2 = 0;
        if (this.f8915j) {
            return ((int) this.f8926z.measureText(AbstractC1389k.f9029b, 0, AbstractC1389k.f9029b.length())) * this.f8912g;
        }
        try {
            i2 = ((i - this.f8857B) / this.f8876U) % this.f8912g;
        } catch (Exception e2) {
        }
        return (this.f8912g - i2) * this.f8876U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m10836f(int i, int i2) {
        C1401w.m11174a(i <= i2 && i >= 0, "Invalid startRow and/or endRow");
        Rect mo10977a = this.f8907b.mo10977a();
        super.invalidate(0, Math.max(0, ((m10900h() * i) + getPaddingTop()) - Math.max(mo10977a.top, this.f8926z.getFontMetricsInt().descent)), getScrollX() + getWidth(), mo10977a.bottom + (m10900h() * i2) + getPaddingTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10847m(int i) {
        C1401w.m11174a(i >= 0, "Invalid startRow");
        super.invalidate(0, Math.max(0, ((m10900h() * i) + getPaddingTop()) - Math.max(this.f8907b.mo10977a().top, this.f8926z.getFontMetricsInt().descent)), getScrollX() + getWidth(), getScrollY() + getHeight());
    }

    /* renamed from: j */
    public void m10904j() {
        m10836f(this.f8925y, this.f8925y + 1);
    }

    /* renamed from: k */
    public void m10906k() {
        m10836f(this.f8908c.m11044b(this.f8910e), this.f8908c.m11044b(this.f8911f) + 1);
    }

    /* renamed from: l */
    public boolean m10907l() {
        return m10849n(this.f8909d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public boolean m10849n(int i) {
        C1401w.m11174a(i >= 0 && i < this.f8908c.m11055h(), "Invalid charOffset given");
        int m10852p = m10852p(i);
        int m10853q = m10861H() ? 0 : m10853q(i);
        if (m10852p == 0 && m10853q == 0) {
            return false;
        }
        scrollBy(m10853q, m10852p);
        return true;
    }

    /* renamed from: o */
    private int m10850o(int i) {
        int i2 = 0;
        this.f8901au = false;
        int m11044b = this.f8908c.m11044b(i) * m10900h();
        int m10900h = m10900h() + m11044b;
        int scrollY = getScrollY() + (getContentHeight() / 2);
        if (m11044b < scrollY) {
            i2 = m11044b - scrollY;
        } else if (m10900h > m10900h() + scrollY) {
            i2 = (m10900h - scrollY) - m10900h();
        }
        if (i2 < 0) {
            return Math.max(-getScrollY(), i2);
        }
        return i2;
    }

    /* renamed from: p */
    private int m10852p(int i) {
        if (this.f8901au) {
            return m10850o(i);
        }
        int m11044b = this.f8908c.m11044b(i) * m10900h();
        int m10900h = m10900h() + m11044b;
        if (m11044b < getScrollY()) {
            return m11044b - getScrollY();
        }
        if (m10900h <= getScrollY() + getContentHeight()) {
            return 0;
        }
        return (m10900h - getScrollY()) - getContentHeight();
    }

    /* renamed from: q */
    private int m10853q(int i) {
        int i2;
        C1397s<Integer> m10891e = m10891e(i);
        int m11130a = m10891e.m11130a();
        int intValue = m10891e.m11134b().intValue();
        if (intValue <= ((getScrollX() + getContentWidth()) - this.f8886af) - this.f8875T) {
            i2 = 0;
        } else {
            i2 = ((intValue - getScrollX()) - getContentWidth()) + this.f8886af + this.f8875T;
        }
        if (m11130a < getScrollX() + this.f8875T + this.f8886af) {
            return ((m11130a - getScrollX()) - this.f8875T) - this.f8886af;
        }
        return i2;
    }

    /* renamed from: e */
    protected C1397s<Integer> m10891e(int i) {
        int m11130a;
        C1397s<AbstractC1381c.a> m10807a;
        AbstractC1381c.a aVar;
        int i2;
        int m10886d;
        boolean z;
        int m11044b = this.f8908c.m11044b(i);
        int m11047d = this.f8908c.m11047d(m11044b);
        int i3 = this.f8857B;
        int i4 = this.f8857B;
        boolean z2 = false;
        String m11033a = this.f8908c.m11033a(m11044b);
        int length = m11033a.length();
        Iterator<C1397s<AbstractC1381c.a>> it = this.f8908c.m11057j().iterator();
        C1401w.m11174a(!it.hasNext(), "No spans to paint in TextWarrior.paint()");
        C1397s<AbstractC1381c.a> m10807a2 = m10807a(it);
        while (true) {
            m11130a = m10807a2.m11130a();
            m10807a = m10807a(it);
            if (m10807a == null || m11130a >= m11047d) {
                break;
            }
            m10807a2 = m10807a;
        }
        AbstractC1381c.a m11134b = m10807a2.m11134b();
        C1397s<AbstractC1381c.a> c1397s = m10807a;
        int i5 = 0;
        while (m11047d + i5 <= i && i5 < length) {
            if (c1397s == null || m11047d + i5 <= m11130a) {
                aVar = m11134b;
                i2 = m11130a;
            } else {
                i2 = c1397s.m11130a();
                aVar = c1397s.m11134b();
                if (m11134b != aVar) {
                    if (aVar.equals(AbstractC1381c.a.f9004j)) {
                        this.f8926z.setTypeface(this.f8868M);
                    } else if (aVar.equals(AbstractC1381c.a.f9003i)) {
                        this.f8926z.setTypeface(this.f8869N);
                    } else {
                        this.f8926z.setTypeface(this.f8867L);
                    }
                }
                c1397s = m10807a(it);
            }
            char charAt = m11033a.charAt(i5);
            switch (charAt) {
                case '\t':
                    m10886d = i4 + m10886d(i4);
                    break;
                case '\n':
                case 65535:
                    m10886d = i4 + getEOLAdvance();
                    break;
                case ' ':
                    m10886d = i4 + getSpaceAdvance();
                    break;
                case 55356:
                case 55357:
                case 55358:
                    z2 = true;
                    m10886d = i4 + ((int) this.f8926z.measureText(new char[]{charAt, m11033a.charAt(i5 + 1)}, 0, 2));
                    break;
                default:
                    if (z2) {
                        z = false;
                        m10886d = i4;
                    } else {
                        m10886d = i4 + m10877b(charAt);
                        z = z2;
                    }
                    z2 = z;
                    break;
            }
            int i6 = m10886d;
            i5++;
            m11134b = aVar;
            m11130a = i2;
            i3 = i4;
            i4 = i6;
        }
        return new C1397s<>(i3, new Integer(i4));
    }

    /* renamed from: f */
    public Rect m10894f(int i) {
        if (i < 0 || i >= this.f8908c.m11055h()) {
            return new Rect(-1, -1, -1, -1);
        }
        int m10900h = m10900h() * this.f8908c.m11044b(i);
        int m10900h2 = m10900h + m10900h();
        C1397s<Integer> m10891e = m10891e(i);
        return new Rect(m10891e.m11130a(), m10900h, m10891e.m11134b().intValue(), m10900h2);
    }

    public AbstractC1381c getColorScheme() {
        return this.f8913h;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int m10866a(int i, int i2) {
        int m10900h = i2 / m10900h();
        if (m10900h > this.f8908c.m11051f()) {
            return this.f8908c.m11055h() - 1;
        }
        int m11047d = this.f8908c.m11047d(m10900h);
        if (m11047d < 0) {
            return -1;
        }
        if (i >= 0) {
            String m11033a = this.f8908c.m11033a(m10900h);
            int i3 = this.f8857B;
            int length = m11033a.length();
            boolean z = false;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = m11033a.charAt(i4);
                switch (charAt) {
                    case '\t':
                        i3 += m10886d(i3);
                        break;
                    case '\n':
                    case 65535:
                        i3 += getEOLAdvance();
                        break;
                    case ' ':
                        i3 += getSpaceAdvance();
                        break;
                    case 55356:
                    case 55357:
                    case 55358:
                        i3 += (int) this.f8926z.measureText(new char[]{charAt, m11033a.charAt(i4 + 1)}, 0, 2);
                        z = true;
                        break;
                    default:
                        if (z) {
                            z = false;
                            break;
                        } else {
                            i3 += m10877b(charAt);
                            break;
                        }
                }
                if (i3 >= i) {
                    if (i4 >= m11033a.length()) {
                        return m11047d + i4;
                    }
                    return (m11047d + i4) - 1;
                }
            }
            if (i4 >= m11033a.length()) {
            }
        } else {
            return m11047d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int m10878b(int i, int i2) {
        int m10900h = i2 / m10900h();
        int m11047d = this.f8908c.m11047d(m10900h);
        if (m11047d < 0 || i < 0) {
            return -1;
        }
        String m11033a = this.f8908c.m11033a(m10900h);
        int length = m11033a.length();
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = m11033a.charAt(i4);
            switch (charAt) {
                case '\t':
                    i3 += m10886d(i3);
                    break;
                case '\n':
                case 65535:
                    i3 += getEOLAdvance();
                    break;
                case ' ':
                    i3 += getSpaceAdvance();
                    break;
                case 55356:
                case 55357:
                case 55358:
                    i3 += (int) this.f8926z.measureText(new char[]{charAt, m11033a.charAt(i4 + 1)}, 0, 2);
                    z = true;
                    break;
                default:
                    if (z) {
                        z = false;
                        break;
                    } else {
                        i3 += m10877b(charAt);
                        break;
                    }
            }
            if (i3 >= i) {
                if (i4 >= m11033a.length()) {
                    return m11047d + i4;
                }
                return -1;
            }
        }
        if (i4 >= m11033a.length()) {
        }
    }

    public int getMaxScrollX() {
        if (m10861H()) {
            return 0;
        }
        return Math.max(0, (this.f8856A - getContentWidth()) + this.f8907b.mo10977a().right + this.f8875T);
    }

    public int getMaxScrollY() {
        return Math.max(0, ((this.f8908c.m11051f() * m10900h()) - (getContentHeight() / 2)) + this.f8907b.mo10977a().bottom);
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return Math.max(0, getScrollY());
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (this.f8908c.m11051f() * m10900h()) + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return this.f8902av.height();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return Math.max(0, getScrollX());
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return Math.max(this.f8856A, getContentWidth());
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        return this.f8902av.width();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f8922v.computeScrollOffset()) {
            scrollTo(this.f8922v.getCurrX(), this.f8922v.getCurrY());
            m10897g();
        }
    }

    /* renamed from: c */
    void m10884c(int i, int i2) {
        this.f8922v.fling(getScrollX(), getScrollY(), i, i2, 0, getMaxScrollX(), 0, getMaxScrollY());
        m10897g();
    }

    /* renamed from: m */
    public boolean m10908m() {
        return !this.f8922v.isFinished();
    }

    /* renamed from: n */
    public void m10909n() {
        this.f8922v.forceFinished(true);
    }

    /* renamed from: g */
    boolean m10899g(int i) {
        boolean z = true;
        switch (i) {
            case 0:
                removeCallbacks(this.f8905ay);
                if (m10917v()) {
                    z = false;
                } else {
                    post(this.f8905ay);
                }
                return z;
            case 1:
                removeCallbacks(this.f8904ax);
                if (m10918w()) {
                    z = false;
                } else {
                    post(this.f8904ax);
                }
                return z;
            case 2:
                removeCallbacks(this.f8906az);
                if (this.f8909d <= 0 || this.f8925y != this.f8908c.m11044b(this.f8909d - 1)) {
                    return false;
                }
                post(this.f8906az);
                return true;
            case 3:
                removeCallbacks(this.f8880aA);
                if (m10919x() || this.f8925y != this.f8908c.m11044b(this.f8909d + 1)) {
                    return false;
                }
                post(this.f8880aA);
                return true;
            default:
                C1401w.m11173a("Invalid scroll direction");
                return false;
        }
    }

    /* renamed from: o */
    void m10910o() {
        removeCallbacks(this.f8904ax);
        removeCallbacks(this.f8905ay);
        removeCallbacks(this.f8906az);
        removeCallbacks(this.f8880aA);
    }

    public int getLineNumber() {
        return this.f8908c.m11045c(this.f8909d);
    }

    public int getCaretRow() {
        return this.f8925y;
    }

    public int getCaretPosition() {
        return this.f8909d;
    }

    /* renamed from: h */
    public void m10901h(int i) {
        this.f8920t.m10933a(i);
    }

    /* renamed from: a */
    public void m10871a(int i, boolean z) {
        this.f8920t.m10938a(i, z);
    }

    /* renamed from: p */
    public void m10911p() {
        this.f8920t.m10946b(false);
    }

    /* renamed from: q */
    public void m10912q() {
        this.f8920t.m10942a(false);
    }

    /* renamed from: r */
    public void m10913r() {
        this.f8920t.m10956f();
    }

    /* renamed from: s */
    public void m10914s() {
        this.f8920t.m10957g();
    }

    /* renamed from: t */
    public void m10915t() {
        this.f8920t.m10952d();
    }

    /* renamed from: u */
    public void m10916u() {
        this.f8920t.m10954e();
    }

    /* renamed from: i */
    protected int m10903i(int i) {
        int m11044b = this.f8908c.m11044b(i);
        C1401w.m11174a(m11044b >= 0, "Invalid char offset given to getColumn");
        return i - this.f8908c.m11047d(m11044b);
    }

    /* renamed from: v */
    protected boolean m10917v() {
        return this.f8925y == 0;
    }

    /* renamed from: w */
    protected boolean m10918w() {
        return this.f8925y == this.f8908c.m11051f() + (-1);
    }

    /* renamed from: x */
    protected boolean m10919x() {
        return this.f8909d == this.f8908c.m11055h() + (-1);
    }

    /* renamed from: y */
    public final boolean m10920y() {
        return this.f8920t.m10959i();
    }

    /* renamed from: z */
    public final boolean m10921z() {
        return this.f8920t.m10960j();
    }

    /* renamed from: f */
    public void m10895f(boolean z) {
        if (this.f8920t.m10959i() && !z) {
            m10906k();
            this.f8920t.m10953d(false);
        } else if (!this.f8920t.m10959i() && z) {
            m10904j();
            this.f8920t.m10953d(true);
        }
        this.f8920t.m10949c(false);
    }

    /* renamed from: A */
    public void m10854A() {
        try {
            AbstractRunnableC1391m.a mo11085a = getLexTask().mo11085a(this.f8908c.toString(), getSelectionStart(), getSelectionEnd());
            this.f8920t.m10936a(mo11085a.f9040a, mo11085a.f9041b, false, true);
        } catch (Exception e2) {
            this.f8920t.m10936a(0, this.f8908c.toString().length(), false, true);
        }
    }

    /* renamed from: d */
    public void m10888d(int i, int i2) {
        this.f8920t.m10936a(i, i2, true, false);
    }

    /* renamed from: e */
    public void m10892e(int i, int i2) {
        this.f8920t.m10936a(i, i2, true, true);
    }

    /* renamed from: j */
    public boolean m10905j(int i) {
        return this.f8920t.m10947b(i);
    }

    public int getSelectionStart() {
        return this.f8910e < 0 ? this.f8909d : this.f8910e;
    }

    public int getSelectionEnd() {
        return this.f8911f < 0 ? this.f8909d : this.f8911f;
    }

    public int getSelectionRange() {
        return Math.abs(getSelectionEnd() - getSelectionStart());
    }

    public CharSequence getSelection() {
        return this.f8920t.m10961k();
    }

    /* renamed from: B */
    public void m10855B() {
        this.f8920t.m10955e(true);
    }

    /* renamed from: C */
    public void m10856C() {
        this.f8920t.m10955e(false);
    }

    /* renamed from: D */
    public void m10857D() {
        if (this.f8910e != this.f8911f) {
            this.f8920t.m10939a(this.f8861F);
        }
    }

    /* renamed from: E */
    public void m10858E() {
        if (this.f8910e != this.f8911f) {
            this.f8920t.m10945b(this.f8861F);
        }
        m10895f(false);
    }

    /* renamed from: F */
    public void m10859F() {
        CharSequence m11006a = C1380b.m11006a(this.f8861F, getContext());
        if (m11006a != null) {
            this.f8920t.m10940a(m11006a.toString());
        }
    }

    /* renamed from: a */
    public void m10873a(String str) {
        this.f8920t.m10940a(str);
    }

    /* renamed from: G */
    public void m10860G() {
        this.f8920t.m10931a();
    }

    public void setTypeface(Typeface typeface) {
        this.f8867L = typeface;
        this.f8868M = Typeface.create(typeface, 1);
        this.f8869N = Typeface.create(typeface, 2);
        this.f8926z.setTypeface(typeface);
        this.f8873R.setTypeface(typeface);
        m10887d();
        if (this.f8908c.m11058k()) {
            this.f8908c.m11059l();
        }
        this.f8920t.m10958h();
        if (m10849n(this.f8909d)) {
            return;
        }
        m10897g();
    }

    public void setItalicTypeface(Typeface typeface) {
        this.f8869N = typeface;
    }

    public void setBoldTypeface(Typeface typeface) {
        this.f8868M = typeface;
    }

    public void setWordWrap(boolean z) {
        this.f8908c.m11040a(z);
        if (z) {
            this.f8856A = 0;
            scrollTo(0, 0);
        }
        this.f8920t.m10958h();
        if (m10849n(this.f8909d)) {
            return;
        }
        m10897g();
    }

    /* renamed from: H */
    public boolean m10861H() {
        return this.f8908c.m11058k();
    }

    public void setZoom(float f2) {
        if (f2 >= 0.5d && f2 <= 5.0d && f2 != this.f8862G) {
            double m10900h = m10900h();
            double mo10864a = mo10864a('a');
            this.f8862G = f2;
            int i = (int) (f8854q * f2);
            this.f8926z.setTextSize(i);
            this.f8873R.setTextSize(i);
            m10887d();
            if (this.f8908c.m11058k()) {
                this.f8908c.m11059l();
            }
            this.f8920t.m10958h();
            this.f8875T = (int) this.f8926z.measureText("a");
            scrollTo((int) ((mo10864a('a') / mo10864a) * getScrollX()), (int) ((m10900h() / m10900h) * getScrollY()));
            this.f8856A = 0;
            m10897g();
        }
    }

    public float getZoom() {
        return this.f8862G;
    }

    public void setTextSize(int i) {
        if (i != this.f8926z.getTextSize()) {
            double m10900h = m10900h();
            double mo10864a = mo10864a('a');
            this.f8862G = i / f8854q;
            this.f8926z.setTextSize(i);
            this.f8873R.setTextSize(i);
            m10887d();
            if (this.f8908c.m11058k()) {
                this.f8908c.m11059l();
            }
            this.f8920t.m10958h();
            scrollTo((int) ((mo10864a('a') / mo10864a) * getScrollX()), (int) ((m10900h() / m10900h) * getScrollY()));
            this.f8856A = 0;
            m10897g();
        }
    }

    /* renamed from: I */
    public void m10862I() {
        this.f8875T = (int) this.f8926z.measureText("a");
        this.f8876U = (int) this.f8926z.measureText(" ");
    }

    public void setTabSpaces(int i) {
        if (i >= 0) {
            this.f8912g = i;
            if (this.f8908c.m11058k()) {
                this.f8908c.m11059l();
            }
            this.f8920t.m10958h();
            if (!m10849n(this.f8909d)) {
                m10897g();
            }
        }
    }

    public void setAutoIndent(boolean z) {
        this.f8916k = z;
    }

    /* renamed from: J */
    public boolean m10863J() {
        return this.f8916k;
    }

    public void setColorScheme(AbstractC1381c abstractC1381c) {
        this.f8913h = abstractC1381c;
        this.f8907b.mo10979a(abstractC1381c);
        setBackgroundColor(abstractC1381c.m11009a(AbstractC1381c.a.f8996b));
    }

    public void setLongPressCaps(boolean z) {
        this.f8918m = z;
    }

    public void setHighlightCurrentRow(boolean z) {
        this.f8914i = z;
        m10904j();
    }

    public void setNonPrintingCharVisibility(boolean z) {
        if (this.f8915j ^ z) {
            this.f8915j = z;
            if (this.f8908c.m11058k()) {
                this.f8908c.m11059l();
            }
            this.f8920t.m10958h();
            if (m10849n(this.f8909d)) {
                return;
            }
            m10897g();
        }
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (this.f8918m && keyEvent.getRepeatCount() == 1 && keyEvent.getAction() == 0) {
            char m10965a = C1372d.m10965a(keyEvent);
            if (Character.isLowerCase(m10965a) && m10965a == Character.toLowerCase(this.f8908c.charAt(this.f8909d - 1))) {
                this.f8920t.m10932a('\b');
                this.f8920t.m10932a(Character.toUpperCase(m10965a));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f8907b.m10982a(i, keyEvent)) {
            return true;
        }
        if (C1372d.m10966b(keyEvent)) {
            m10808a(i, keyEvent);
            return true;
        }
        if (i == 63 || i == 61185) {
            m10817a(f8850aB.get(61185), false);
            return true;
        }
        char m10965a = C1372d.m10965a(keyEvent);
        if (m10965a == 0) {
            return false;
        }
        int repeatCount = keyEvent.getRepeatCount();
        if (repeatCount == 1) {
            if (this.f8918m) {
                m10831d(m10965a);
            } else {
                m10834e(m10965a);
            }
        } else if (repeatCount == 0 || ((this.f8918m && !Character.isLowerCase(m10965a)) || (!this.f8918m && f8850aB.get(m10965a) == null))) {
            this.f8920t.m10932a(m10965a);
        }
        return true;
    }

    /* renamed from: a */
    private void m10808a(int i, KeyEvent keyEvent) {
        if (keyEvent.isShiftPressed() && !m10920y()) {
            m10904j();
            this.f8920t.m10953d(true);
        } else if (!keyEvent.isShiftPressed() && m10920y()) {
            m10906k();
            this.f8920t.m10953d(false);
        }
        switch (i) {
            case 19:
                this.f8920t.m10957g();
                break;
            case 20:
                this.f8920t.m10956f();
                break;
            case 21:
                this.f8920t.m10946b(false);
                break;
            case 22:
                this.f8920t.m10942a(false);
                break;
            case 122:
                m10915t();
                break;
            case 123:
                m10916u();
                break;
        }
    }

    /* renamed from: d */
    private void m10831d(char c2) {
        if (Character.isLowerCase(c2) && c2 == this.f8908c.charAt(this.f8909d - 1)) {
            this.f8920t.m10932a('\b');
            this.f8920t.m10932a(Character.toUpperCase(c2));
        } else {
            this.f8920t.m10932a(c2);
        }
    }

    /* renamed from: e */
    private void m10834e(char c2) {
        String str = f8850aB.get(Character.isUpperCase(this.f8908c.charAt(this.f8909d + (-1))) ? Character.toUpperCase(c2) : c2);
        if (str != null) {
            this.f8920t.m10949c(true);
            m10817a(str, true);
        } else {
            this.f8920t.m10932a(c2);
        }
    }

    /* renamed from: a */
    private void m10817a(String str, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Selection.setSelection(spannableStringBuilder, 0);
        CharacterPickerDialog characterPickerDialog = new CharacterPickerDialog(getContext(), this, spannableStringBuilder, str, true);
        characterPickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this, spannableStringBuilder, z) { // from class: com.h.a.a.c.10

            /* renamed from: a */
            private final C1371c f8928a;

            /* renamed from: b */
            private final SpannableStringBuilder f8929b;

            /* renamed from: c */
            private final boolean f8930c;

            {
                this.f8928a = this;
                this.f8929b = spannableStringBuilder;
                this.f8930c = z;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (this.f8929b.length() > 0) {
                    if (this.f8930c) {
                        this.f8928a.f8920t.m10932a('\b');
                    }
                    this.f8928a.f8920t.m10932a(this.f8929b.charAt(0));
                }
            }
        });
        characterPickerDialog.show();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f8907b.m10985b(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        int round = Math.round(motionEvent.getX());
        int round2 = Math.round(motionEvent.getY());
        while (round > 0) {
            this.f8920t.m10942a(false);
            round--;
        }
        while (round < 0) {
            this.f8920t.m10946b(false);
            round++;
        }
        while (round2 > 0) {
            this.f8920t.m10956f();
            round2--;
        }
        while (round2 < 0) {
            this.f8920t.m10957g();
            round2++;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        return true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isFocused()) {
            if (motionEvent.getPointerCount() > 1) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            this.f8907b.m10986b(motionEvent);
        } else if ((motionEvent.getAction() & 255) == 1 && m10838g((int) motionEvent.getX(), (int) motionEvent.getY())) {
            requestFocus();
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f8899as = true;
                break;
            case 1:
                m10875a(false, 0, 0);
                this.f8920t.m10949c(true);
                m10897g();
                this.f8899as = false;
                break;
        }
    }

    /* renamed from: g */
    private final boolean m10838g(int i, int i2) {
        return i >= 0 && i < getWidth() && i2 >= 0 && i2 < getHeight();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        m10904j();
    }

    /* renamed from: g */
    protected void mo10898g(boolean z) {
        if (z) {
            this.f8882ab.showSoftInput(this, 0);
        } else {
            this.f8882ab.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public Parcelable getUiState() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FreeScrollingTextField.java */
    /* renamed from: com.h.a.a.c$a */
    class a implements C1392n.a {

        /* renamed from: a */
        private boolean f8939a = false;

        /* renamed from: b */
        private final C1392n f8940b;

        /* renamed from: c */
        private boolean f8941c;

        /* renamed from: d */
        private final C1371c f8942d;

        /* renamed from: b */
        static C1371c m10928b(a aVar) {
            return aVar.f8942d;
        }

        /* renamed from: a */
        public void m10931a() {
            try {
                this.f8940b.m11095a(this.f8942d.f8908c);
            } catch (Error e2) {
            } catch (Exception e3) {
            }
        }

        /* renamed from: b */
        public void m10943b() {
            this.f8940b.m11094a();
        }

        @Override // com.p159h.p160a.p162b.C1392n.a
        /* renamed from: a */
        public void mo10941a(List<C1397s<AbstractC1381c.a>> list) {
            this.f8942d.post(new Runnable(this, list) { // from class: com.h.a.a.c.a.1

                /* renamed from: a */
                private final a f8943a;

                /* renamed from: b */
                private final List f8944b;

                {
                    this.f8943a = this;
                    this.f8944b = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.m10928b(this.f8943a).f8908c.m11039a(this.f8944b);
                    a.m10928b(this.f8943a).m10897g();
                }
            });
        }

        /* renamed from: a */
        public void m10932a(char c2) {
            boolean z = false;
            if (this.f8939a) {
                m10962l();
                z = true;
            }
            int i = this.f8942d.f8925y;
            int m11047d = this.f8942d.f8908c.m11047d(i);
            switch (c2) {
                case '\b':
                    if (!z && this.f8942d.f8909d > 0) {
                        this.f8942d.f8908c.m11036a(this.f8942d.f8909d - 1, System.nanoTime());
                        if (this.f8942d.f8908c.charAt(this.f8942d.f8909d - 2) == 55357 || this.f8942d.f8908c.charAt(this.f8942d.f8909d - 2) == 55356) {
                            this.f8942d.f8908c.m11036a(this.f8942d.f8909d - 2, System.nanoTime());
                            m10946b(true);
                        }
                        this.f8942d.f8865J.mo10924a((CharSequence) new StringBuffer().append(c2).append("").toString(), this.f8942d.f8909d, 1);
                        m10946b(true);
                        if (this.f8942d.f8925y < i) {
                            this.f8942d.m10847m(this.f8942d.f8925y);
                            break;
                        } else if (this.f8942d.f8908c.m11058k()) {
                            this.f8942d.m10847m(m11047d != this.f8942d.f8908c.m11047d(i) ? i - 1 : i);
                            break;
                        }
                    }
                    break;
                case '\t':
                default:
                    this.f8942d.f8908c.m11034a(c2, this.f8942d.f8909d, System.nanoTime());
                    m10942a(true);
                    this.f8942d.f8865J.mo10926b(new StringBuffer().append(c2).append("").toString(), this.f8942d.f8909d, 1);
                    if (this.f8942d.f8908c.m11058k()) {
                        if (m11047d != this.f8942d.f8908c.m11047d(i)) {
                            i--;
                        }
                        this.f8942d.m10847m(i);
                        break;
                    }
                    break;
                case '\n':
                    if (this.f8942d.f8916k) {
                        char[] m10950c = m10950c();
                        this.f8942d.f8908c.m11041a(m10950c, this.f8942d.f8909d, System.nanoTime());
                        m10933a(m10950c.length + this.f8942d.f8909d);
                    } else {
                        this.f8942d.f8908c.m11034a(c2, this.f8942d.f8909d, System.nanoTime());
                        m10942a(true);
                    }
                    if (this.f8942d.f8908c.m11058k() && m11047d != this.f8942d.f8908c.m11047d(i)) {
                        i--;
                    }
                    this.f8942d.f8865J.mo10925a(new StringBuffer().append(c2).append("").toString(), this.f8942d.f8909d, 1);
                    this.f8942d.m10847m(i);
                    break;
            }
            this.f8942d.setEdited(true);
            m10931a();
        }

        /* renamed from: c */
        public char[] m10950c() {
            char m11043b;
            int m11049e = this.f8942d.f8908c.m11049e(this.f8942d.f8908c.m11045c(this.f8942d.f8909d));
            this.f8942d.f8908c.m11052f(m11049e);
            int i = 0;
            while (this.f8942d.f8908c.m11042a() && (((m11043b = this.f8942d.f8908c.m11043b()) == ' ' || m11043b == '\t') && m11049e + i < this.f8942d.f8909d)) {
                i++;
            }
            int m11005a = (this.f8942d.f8917l * C1379a.m11005a(this.f8942d.f8908c.subSequence(m11049e, this.f8942d.f8909d - m11049e))) + i;
            if (m11005a < 0) {
                return new char[]{'\n'};
            }
            char[] cArr = new char[m11005a + 1];
            cArr[0] = '\n';
            this.f8942d.f8908c.m11052f(m11049e);
            for (int i2 = 0; i2 < m11005a; i2++) {
                cArr[i2 + 1] = ' ';
            }
            return cArr;
        }

        /* renamed from: d */
        public void m10952d() {
            m10933a(0);
        }

        /* renamed from: e */
        public void m10954e() {
            m10933a(Math.max(0, this.f8942d.f8908c.length() - 1));
        }

        /* renamed from: f */
        public void m10956f() {
            if (this.f8942d.m10918w()) {
                return;
            }
            int i = this.f8942d.f8909d;
            int i2 = this.f8942d.f8925y;
            int i3 = i2 + 1;
            int m10903i = this.f8942d.m10903i(i);
            int m11054g = this.f8942d.f8908c.m11054g(i2);
            if (m10903i < this.f8942d.f8908c.m11054g(i3)) {
                C1371c c1371c = this.f8942d;
                c1371c.f8909d = m11054g + c1371c.f8909d;
            } else {
                C1371c c1371c2 = this.f8942d;
                c1371c2.f8909d = (((m11054g - m10903i) + r5) - 1) + c1371c2.f8909d;
            }
            this.f8942d.f8925y++;
            m10929b(i, this.f8942d.f8909d);
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                this.f8942d.m10836f(i2, i3 + 1);
            }
            this.f8942d.f8923w.mo10922a(i3);
            m10949c(false);
        }

        /* renamed from: g */
        public void m10957g() {
            if (this.f8942d.m10917v()) {
                return;
            }
            int i = this.f8942d.f8909d;
            int i2 = this.f8942d.f8925y;
            int i3 = i2 - 1;
            int m10903i = this.f8942d.m10903i(i);
            int m11054g = this.f8942d.f8908c.m11054g(i3);
            if (m10903i < m11054g) {
                this.f8942d.f8909d -= m11054g;
            } else {
                this.f8942d.f8909d -= m10903i + 1;
            }
            C1371c c1371c = this.f8942d;
            c1371c.f8925y--;
            m10929b(i, this.f8942d.f8909d);
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                this.f8942d.m10836f(i3, i2 + 1);
            }
            this.f8942d.f8923w.mo10922a(i3);
            m10949c(false);
        }

        /* renamed from: a */
        public void m10942a(boolean z) {
            if (this.f8942d.m10919x()) {
                return;
            }
            int i = this.f8942d.f8925y;
            this.f8942d.f8909d++;
            m10958h();
            m10929b(this.f8942d.f8909d - 1, this.f8942d.f8909d);
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                this.f8942d.m10836f(i, this.f8942d.f8925y + 1);
            }
            if (z) {
                return;
            }
            m10949c(false);
        }

        /* renamed from: b */
        public void m10946b(boolean z) {
            if (this.f8942d.f8909d > 0) {
                int i = this.f8942d.f8925y;
                C1371c c1371c = this.f8942d;
                c1371c.f8909d--;
                m10958h();
                m10929b(this.f8942d.f8909d + 1, this.f8942d.f8909d);
                if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                    this.f8942d.m10836f(this.f8942d.f8925y, i + 1);
                }
                if (z) {
                    return;
                }
                m10949c(false);
            }
        }

        /* renamed from: a */
        public void m10933a(int i) {
            m10938a(i, true);
        }

        /* renamed from: a */
        public void m10938a(int i, boolean z) {
            if (i < 0 || i >= this.f8942d.f8908c.m11055h()) {
                C1401w.m11173a("Invalid caret position");
                return;
            }
            m10929b(this.f8942d.f8909d, i);
            this.f8942d.f8909d = i;
            m10930f(z);
        }

        /* renamed from: f */
        private void m10930f(boolean z) {
            int i = this.f8942d.f8925y;
            m10958h();
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                this.f8942d.m10836f(i, i + 1);
                this.f8942d.m10904j();
            }
            m10949c(z);
        }

        /* renamed from: h */
        public void m10958h() {
            int m11044b = this.f8942d.f8908c.m11044b(this.f8942d.f8909d);
            if (this.f8942d.f8925y != m11044b) {
                this.f8942d.f8925y = m11044b;
                this.f8942d.f8923w.mo10922a(m11044b);
            }
        }

        /* renamed from: c */
        public void m10949c(boolean z) {
            int i;
            int i2;
            int i3;
            int i4;
            if (this.f8942d.f8882ab == null) {
                this.f8942d.f8882ab = (InputMethodManager) this.f8942d.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            }
            if (this.f8942d.f8921u != null && this.f8942d.f8921u.m10972b() == 0) {
                if (m10959i()) {
                    i4 = this.f8942d.getSelectionStart();
                    i3 = this.f8942d.getSelectionEnd();
                    i = -1;
                    i2 = -1;
                } else {
                    int caretPosition = this.f8942d.getCaretPosition();
                    i = caretPosition;
                    i2 = caretPosition;
                    i3 = caretPosition;
                    i4 = caretPosition;
                }
                this.f8942d.f8882ab.updateSelection(this.f8942d, i4, i3, i2, i);
            }
            if (this.f8942d.f8921u == null) {
                this.f8942d.f8921u = new C1375g(this.f8942d);
            } else {
                this.f8942d.f8921u.m10971a();
            }
            if (z) {
                this.f8942d.f8882ab.restartInput(this.f8942d);
            }
        }

        /* renamed from: i */
        public final boolean m10959i() {
            return this.f8939a;
        }

        /* renamed from: j */
        public final boolean m10960j() {
            return this.f8941c;
        }

        /* renamed from: d */
        public void m10953d(boolean z) {
            if (this.f8939a ^ z) {
                if (z) {
                    this.f8942d.f8910e = this.f8942d.f8909d;
                    this.f8942d.f8911f = this.f8942d.f8909d;
                } else {
                    this.f8942d.f8910e = -1;
                    this.f8942d.f8911f = -1;
                }
                this.f8939a = z;
                this.f8941c = z;
                this.f8942d.f8924x.mo10923a(z, this.f8942d.getSelectionStart(), this.f8942d.getSelectionEnd());
            }
        }

        /* renamed from: b */
        public boolean m10947b(int i) {
            return this.f8942d.f8910e >= 0 && this.f8942d.f8910e <= i && i < this.f8942d.f8911f;
        }

        /* renamed from: a */
        public void m10936a(int i, int i2, boolean z, boolean z2) {
            m10937a(i, i2, z, z2, true);
        }

        /* renamed from: a */
        public void m10937a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int i3 = 0;
            int length = this.f8942d.f8908c.length();
            C1401w.m11174a(i >= 0 && i2 <= length + (-1) && i2 >= 0, "Invalid range to select");
            if (i < 0) {
                i = 0;
            } else if (i >= length) {
                i = length - 1;
            }
            if (i2 >= 0) {
                i3 = i2 >= length - i ? Math.max(0, (length - i) - 1) : i2;
            }
            if (this.f8939a) {
                this.f8942d.m10906k();
            } else {
                this.f8942d.m10904j();
                if (z2) {
                    m10953d(true);
                } else {
                    this.f8939a = true;
                }
            }
            this.f8942d.f8910e = i;
            this.f8942d.f8911f = this.f8942d.f8910e + i3;
            this.f8942d.f8909d = this.f8942d.f8911f;
            m10949c(z3);
            m10958h();
            if (z2) {
                this.f8942d.f8924x.mo10923a(m10959i(), this.f8942d.f8910e, this.f8942d.f8911f);
            }
            boolean m10849n = this.f8942d.m10849n(this.f8942d.f8911f);
            if (z) {
                m10849n = this.f8942d.m10849n(this.f8942d.f8910e);
            }
            if (m10849n) {
                return;
            }
            this.f8942d.m10906k();
        }

        /* renamed from: e */
        public void m10955e(boolean z) {
            if (this.f8939a) {
                if (z && this.f8942d.f8909d != this.f8942d.f8910e) {
                    this.f8942d.f8909d = this.f8942d.f8910e;
                    m10930f(false);
                } else if (!z && this.f8942d.f8909d != this.f8942d.f8911f) {
                    this.f8942d.f8909d = this.f8942d.f8911f;
                    m10930f(false);
                }
            }
        }

        /* renamed from: b */
        private void m10929b(int i, int i2) {
            if (this.f8939a) {
                if (i < this.f8942d.f8911f) {
                    if (i2 > this.f8942d.f8911f) {
                        this.f8942d.f8910e = this.f8942d.f8911f;
                        this.f8942d.f8911f = i2;
                        return;
                    }
                    this.f8942d.f8910e = i2;
                    return;
                }
                if (i2 < this.f8942d.f8910e) {
                    this.f8942d.f8911f = this.f8942d.f8910e;
                    this.f8942d.f8910e = i2;
                    return;
                }
                this.f8942d.f8911f = i2;
            }
        }

        /* renamed from: a */
        public void m10939a(ClipboardManager clipboardManager) {
            m10945b(clipboardManager);
            m10962l();
        }

        /* renamed from: b */
        public void m10945b(ClipboardManager clipboardManager) {
            if (!this.f8939a || this.f8942d.f8910e >= this.f8942d.f8911f) {
                return;
            }
            C1380b.m11007a(clipboardManager, this.f8942d.f8908c.subSequence(this.f8942d.f8910e, this.f8942d.f8911f - this.f8942d.f8910e));
        }

        /* renamed from: k */
        public CharSequence m10961k() {
            return (!this.f8939a || this.f8942d.f8910e >= this.f8942d.f8911f) ? "" : this.f8942d.f8908c.subSequence(this.f8942d.f8910e, this.f8942d.f8911f - this.f8942d.f8910e);
        }

        /* renamed from: a */
        public void m10940a(String str) {
            if (str != null) {
                this.f8942d.f8908c.m11048d();
                m10962l();
                int i = this.f8942d.f8925y;
                int m11047d = this.f8942d.f8908c.m11047d(i);
                this.f8942d.f8908c.m11041a(str.toCharArray(), this.f8942d.f8909d, System.nanoTime());
                this.f8942d.f8909d += str.length();
                this.f8942d.f8865J.mo10926b(str, this.f8942d.f8909d, str.length());
                this.f8942d.f8908c.m11050e();
                m10958h();
                this.f8942d.setEdited(true);
                m10931a();
                m10949c(true);
                if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                    int i2 = (!this.f8942d.f8908c.m11058k() || m11047d == this.f8942d.f8908c.m11047d(i)) ? i : i - 1;
                    if (i == this.f8942d.f8925y && !this.f8942d.f8908c.m11058k()) {
                        this.f8942d.m10836f(i2, i2 + 1);
                    } else {
                        this.f8942d.m10847m(i2);
                    }
                }
            }
        }

        /* renamed from: l */
        public void m10962l() {
            if (this.f8939a) {
                int i = this.f8942d.f8911f - this.f8942d.f8910e;
                if (i > 0) {
                    int m11044b = this.f8942d.f8908c.m11044b(this.f8942d.f8910e);
                    int m11047d = this.f8942d.f8908c.m11047d(m11044b);
                    boolean z = this.f8942d.f8908c.m11044b(this.f8942d.f8911f) == m11044b;
                    this.f8942d.f8908c.m11035a(this.f8942d.f8910e, i, System.nanoTime());
                    this.f8942d.f8865J.mo10924a((CharSequence) "", this.f8942d.f8909d, i);
                    this.f8942d.f8909d = this.f8942d.f8910e;
                    m10958h();
                    this.f8942d.setEdited(true);
                    m10931a();
                    m10953d(false);
                    m10949c(true);
                    if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                        int i2 = (!this.f8942d.f8908c.m11058k() || m11047d == this.f8942d.f8908c.m11047d(m11044b)) ? m11044b : m11044b - 1;
                        if (z && !this.f8942d.f8908c.m11058k()) {
                            this.f8942d.m10836f(i2, i2 + 1);
                            return;
                        } else {
                            this.f8942d.m10847m(i2);
                            return;
                        }
                    }
                    return;
                }
                m10953d(false);
                this.f8942d.m10904j();
            }
        }

        /* renamed from: a */
        void m10935a(int i, int i2, String str) {
            int i3;
            int m11047d;
            boolean z;
            boolean z2;
            int i4;
            boolean z3;
            int i5;
            boolean z4;
            boolean z5;
            if (this.f8939a) {
                i3 = this.f8942d.f8908c.m11044b(this.f8942d.f8910e);
                m11047d = this.f8942d.f8908c.m11047d(i3);
                int i6 = this.f8942d.f8911f - this.f8942d.f8910e;
                if (i6 > 0) {
                    this.f8942d.f8909d = this.f8942d.f8910e;
                    this.f8942d.f8908c.m11035a(this.f8942d.f8910e, i6, System.nanoTime());
                    z5 = i3 == this.f8942d.f8925y;
                    z4 = true;
                } else {
                    z4 = false;
                    z5 = true;
                }
                m10953d(false);
                z = z4;
                z2 = z5;
            } else {
                i3 = this.f8942d.f8925y;
                m11047d = this.f8942d.f8908c.m11047d(this.f8942d.f8925y);
                z = false;
                z2 = true;
            }
            if (i2 > 0) {
                int m11044b = this.f8942d.f8908c.m11044b(i);
                if (m11044b < i3) {
                    i4 = this.f8942d.f8908c.m11047d(m11044b);
                } else {
                    i4 = m11047d;
                    m11044b = i3;
                }
                boolean z6 = m11044b != this.f8942d.f8925y ? false : z2;
                this.f8942d.f8909d = i;
                this.f8942d.f8908c.m11035a(i, i2, System.nanoTime());
                z = true;
                z2 = z6;
                i3 = m11044b;
            } else {
                i4 = m11047d;
            }
            if (str == null || str.length() <= 0) {
                z3 = z;
                i5 = i3;
            } else {
                i5 = this.f8942d.f8908c.m11044b(i);
                if (i5 < i3) {
                    i4 = this.f8942d.f8908c.m11047d(i5);
                } else {
                    i5 = i3;
                }
                this.f8942d.f8908c.m11041a(str.toCharArray(), this.f8942d.f8909d, System.nanoTime());
                this.f8942d.f8909d += str.length();
                z3 = true;
            }
            if (z3) {
                this.f8942d.setEdited(true);
                m10931a();
            }
            int i7 = this.f8942d.f8925y;
            m10958h();
            boolean z7 = i7 == this.f8942d.f8925y ? z2 : false;
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                int i8 = (!this.f8942d.f8908c.m11058k() || i4 == this.f8942d.f8908c.m11047d(i5)) ? i5 : i5 - 1;
                if (z7 && !this.f8942d.f8908c.m11058k()) {
                    this.f8942d.m10836f(this.f8942d.f8925y, this.f8942d.f8925y + 1);
                } else {
                    this.f8942d.m10847m(i8);
                }
            }
        }

        /* renamed from: b */
        void m10944b(int i, int i2, String str) {
            int i3;
            int m11047d;
            boolean z;
            boolean z2;
            int i4;
            boolean z3;
            boolean z4;
            boolean z5;
            if (this.f8939a) {
                i3 = this.f8942d.f8908c.m11044b(this.f8942d.f8910e);
                m11047d = this.f8942d.f8908c.m11047d(i3);
                int i5 = this.f8942d.f8911f - this.f8942d.f8910e;
                if (i5 > 0) {
                    this.f8942d.f8909d = this.f8942d.f8910e;
                    this.f8942d.f8908c.m11035a(this.f8942d.f8910e, i5, System.nanoTime());
                    z5 = i3 == this.f8942d.f8925y;
                    z4 = true;
                } else {
                    z4 = false;
                    z5 = true;
                }
                m10953d(false);
                z = z4;
                z2 = z5;
            } else {
                i3 = this.f8942d.f8925y;
                m11047d = this.f8942d.f8908c.m11047d(this.f8942d.f8925y);
                z = false;
                z2 = true;
            }
            if (i2 > 0) {
                int m11044b = this.f8942d.f8908c.m11044b(i);
                if (m11044b < i3) {
                    i4 = this.f8942d.f8908c.m11047d(m11044b);
                } else {
                    i4 = m11047d;
                    m11044b = i3;
                }
                boolean z6 = m11044b != this.f8942d.f8925y ? false : z2;
                this.f8942d.f8909d = i;
                this.f8942d.f8908c.m11035a(i, i2, System.nanoTime());
                z = true;
                z2 = z6;
                i3 = m11044b;
            } else {
                i4 = m11047d;
            }
            if (str == null || str.length() <= 0) {
                z3 = z;
            } else {
                int m11044b2 = this.f8942d.f8908c.m11044b(i);
                if (m11044b2 < i3) {
                    i4 = this.f8942d.f8908c.m11047d(m11044b2);
                } else {
                    m11044b2 = i3;
                }
                this.f8942d.f8908c.m11041a(str.toCharArray(), this.f8942d.f8909d, System.nanoTime());
                this.f8942d.f8909d += str.length();
                z3 = true;
                i3 = m11044b2;
            }
            this.f8942d.f8865J.mo10926b(str, this.f8942d.f8909d, str.length() - i2);
            if (z3) {
                this.f8942d.setEdited(true);
                m10931a();
            }
            int i6 = this.f8942d.f8925y;
            m10958h();
            boolean z7 = i6 == this.f8942d.f8925y ? z2 : false;
            if (!this.f8942d.m10849n(this.f8942d.f8909d)) {
                if (this.f8942d.f8908c.m11058k() && i4 != this.f8942d.f8908c.m11047d(i3)) {
                    i3--;
                }
                if (z7 && !this.f8942d.f8908c.m11058k()) {
                    this.f8942d.m10836f(this.f8942d.f8925y, this.f8942d.f8925y + 1);
                } else {
                    this.f8942d.m10847m(i3);
                }
            }
        }

        /* renamed from: a */
        void m10934a(int i, int i2) {
            if (m10959i()) {
                m10962l();
                return;
            }
            int i3 = this.f8942d.f8909d - i;
            if (i3 < 0) {
                i3 = 0;
            }
            int i4 = this.f8942d.f8909d + i2;
            int m11055h = this.f8942d.f8908c.m11055h();
            if (i4 > m11055h - 1) {
                i4 = m11055h - 1;
            }
            m10944b(i3, i4 - i3, "");
        }

        /* renamed from: c */
        String m10948c(int i) {
            int i2;
            if (m10959i()) {
                i2 = this.f8942d.getSelectionEnd();
            } else {
                i2 = this.f8942d.f8909d;
            }
            if (i2 + i > this.f8942d.f8908c.m11055h() - 1) {
                return this.f8942d.f8908c.subSequence(i2, (r1 - i2) - 1).toString();
            }
            return this.f8942d.f8908c.subSequence(i2, i).toString();
        }

        /* renamed from: d */
        String m10951d(int i) {
            int i2;
            if (m10959i()) {
                i2 = this.f8942d.getSelectionStart();
            } else {
                i2 = this.f8942d.f8909d;
            }
            int i3 = i2 - i;
            if (i3 < 0) {
                i3 = 0;
            }
            return this.f8942d.f8908c.subSequence(i3, i2 - i3).toString();
        }

        public a(C1371c c1371c) {
            this.f8942d = c1371c;
            this.f8940b = new C1392n(this, this.f8942d.getLexTask());
        }
    }

    /* compiled from: FreeScrollingTextField.java */
    /* renamed from: com.h.a.a.c$b */
    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.h.a.a.c.b.1
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return m10963a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return m10964a(i);
            }

            /* renamed from: a */
            public b m10963a(Parcel parcel) {
                return new b(parcel);
            }

            /* renamed from: a */
            public b[] m10964a(int i) {
                return new b[i];
            }
        };

        /* renamed from: a */
        final int f8945a;

        /* renamed from: b */
        final int f8946b;

        /* renamed from: c */
        final int f8947c;

        /* renamed from: d */
        final boolean f8948d;

        /* renamed from: e */
        final int f8949e;

        /* renamed from: f */
        final int f8950f;

        @Override // android.p008os.Parcelable
        public int describeContents() {
            return 0;
        }

        public b(C1371c c1371c) {
            this.f8945a = c1371c.getCaretPosition();
            this.f8946b = c1371c.getScrollX();
            this.f8947c = c1371c.getScrollY();
            this.f8948d = c1371c.m10920y();
            this.f8949e = c1371c.getSelectionStart();
            this.f8950f = c1371c.getSelectionEnd();
        }

        b(Parcel parcel) {
            this.f8945a = parcel.readInt();
            this.f8946b = parcel.readInt();
            this.f8947c = parcel.readInt();
            this.f8948d = parcel.readInt() != 0;
            this.f8949e = parcel.readInt();
            this.f8950f = parcel.readInt();
        }

        @Override // android.p008os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f8945a);
            parcel.writeInt(this.f8946b);
            parcel.writeInt(this.f8947c);
            parcel.writeInt(this.f8948d ? 1 : 0);
            parcel.writeInt(this.f8949e);
            parcel.writeInt(this.f8950f);
        }
    }

    static {
        f8850aB.put(65, "ÀÁÂÄÆÃÅĄĀ");
        f8850aB.put(67, "ÇĆČ");
        f8850aB.put(68, "Ď");
        f8850aB.put(69, "ÈÉÊËĘĚĒ");
        f8850aB.put(71, "Ğ");
        f8850aB.put(76, "Ł");
        f8850aB.put(73, "ÌÍÎÏĪİ");
        f8850aB.put(78, "ÑŃŇ");
        f8850aB.put(79, "ØŒÕÒÓÔÖŌ");
        f8850aB.put(82, "Ř");
        f8850aB.put(83, "ŚŠŞ");
        f8850aB.put(84, "Ť");
        f8850aB.put(85, "ÙÚÛÜŮŪ");
        f8850aB.put(89, "ÝŸ");
        f8850aB.put(90, "ŹŻŽ");
        f8850aB.put(97, "àáâäæãåąā");
        f8850aB.put(99, "çćč");
        f8850aB.put(100, "ď");
        f8850aB.put(101, "èéêëęěē");
        f8850aB.put(103, "ğ");
        f8850aB.put(105, "ìíîïīı");
        f8850aB.put(108, "ł");
        f8850aB.put(110, "ñńň");
        f8850aB.put(111, "øœõòóôöō");
        f8850aB.put(114, "ř");
        f8850aB.put(115, "§ßśšş");
        f8850aB.put(116, "ť");
        f8850aB.put(117, "ùúûüůū");
        f8850aB.put(121, "ýÿ");
        f8850aB.put(122, "źżž");
        f8850aB.put(61185, "…¥•®©±[]{}\\|");
        f8850aB.put(47, "\\");
        f8850aB.put(49, "¹½⅓¼⅛");
        f8850aB.put(50, "²⅔");
        f8850aB.put(51, "³¾⅜");
        f8850aB.put(52, "⁴");
        f8850aB.put(53, "⅝");
        f8850aB.put(55, "⅞");
        f8850aB.put(48, "ⁿ∅");
        f8850aB.put(36, "¢£€¥₣₤₱");
        f8850aB.put(37, "‰");
        f8850aB.put(42, "†‡");
        f8850aB.put(45, "–—");
        f8850aB.put(43, "±");
        f8850aB.put(40, "[{<");
        f8850aB.put(41, "]}>");
        f8850aB.put(33, "¡");
        f8850aB.put(34, "“”«»˝");
        f8850aB.put(63, "¿");
        f8850aB.put(44, "‚„");
        f8850aB.put(61, "≠≈∞");
        f8850aB.put(60, "≤«‹");
        f8850aB.put(62, "≥»›");
    }
}
