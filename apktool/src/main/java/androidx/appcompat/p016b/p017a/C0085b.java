package androidx.appcompat.p016b.p017a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.C0315a;

/* compiled from: DrawableContainer.java */
/* renamed from: androidx.appcompat.b.a.b */
/* loaded from: classes.dex */
class C0085b extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private c f751a;

    /* renamed from: b */
    private Rect f752b;

    /* renamed from: c */
    private Drawable f753c;

    /* renamed from: d */
    private Drawable f754d;

    /* renamed from: f */
    private boolean f756f;

    /* renamed from: h */
    private boolean f758h;

    /* renamed from: i */
    private Runnable f759i;

    /* renamed from: j */
    private long f760j;

    /* renamed from: k */
    private long f761k;

    /* renamed from: l */
    private b f762l;

    /* renamed from: e */
    private int f755e = 255;

    /* renamed from: g */
    private int f757g = -1;

    C0085b() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f753c != null) {
            this.f753c.draw(canvas);
        }
        if (this.f754d != null) {
            this.f754d.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f751a.getChangingConfigurations();
    }

    /* renamed from: a */
    private boolean m696a() {
        return isAutoMirrored() && C0315a.m2370g(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect m720e = this.f751a.m720e();
        if (m720e != null) {
            rect.set(m720e);
            padding = (m720e.right | ((m720e.left | m720e.top) | m720e.bottom)) != 0;
        } else if (this.f753c != null) {
            padding = this.f753c.getPadding(rect);
        } else {
            padding = super.getPadding(rect);
        }
        if (m696a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f753c != null) {
            a.m702a(this.f753c, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (!this.f756f || this.f755e != i) {
            this.f756f = true;
            this.f755e = i;
            if (this.f753c != null) {
                if (this.f760j == 0) {
                    this.f753c.setAlpha(i);
                } else {
                    m698a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f755e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f751a.f799z != z) {
            this.f751a.f799z = z;
            if (this.f753c != null) {
                this.f753c.setDither(this.f751a.f799z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f751a.f771G = true;
        if (this.f751a.f770F != colorFilter) {
            this.f751a.f770F = colorFilter;
            if (this.f753c != null) {
                this.f753c.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f751a.f774J = true;
        if (this.f751a.f772H != colorStateList) {
            this.f751a.f772H = colorStateList;
            C0315a.m2359a(this.f753c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f751a.f775K = true;
        if (this.f751a.f773I != mode) {
            this.f751a.f773I = mode;
            C0315a.m2362a(this.f753c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f754d != null) {
            this.f754d.setBounds(rect);
        }
        if (this.f753c != null) {
            this.f753c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f751a.m729m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f751a.f769E != z) {
            this.f751a.f769E = z;
            if (this.f753c != null) {
                C0315a.m2363a(this.f753c, this.f751a.f769E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f751a.f769E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z = true;
        boolean z2 = false;
        if (this.f754d != null) {
            this.f754d.jumpToCurrentState();
            this.f754d = null;
            z2 = true;
        }
        if (this.f753c != null) {
            this.f753c.jumpToCurrentState();
            if (this.f756f) {
                this.f753c.setAlpha(this.f755e);
            }
        }
        if (this.f761k != 0) {
            this.f761k = 0L;
            z2 = true;
        }
        if (this.f760j != 0) {
            this.f760j = 0L;
        } else {
            z = z2;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        if (this.f753c != null) {
            C0315a.m2356a(this.f753c, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f752b == null) {
            this.f752b = new Rect(i, i2, i3, i4);
        } else {
            this.f752b.set(i, i2, i3, i4);
        }
        if (this.f753c != null) {
            C0315a.m2358a(this.f753c, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.f752b != null) {
            rect.set(this.f752b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f754d != null) {
            return this.f754d.setState(iArr);
        }
        if (this.f753c != null) {
            return this.f753c.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.f754d != null) {
            return this.f754d.setLevel(i);
        }
        if (this.f753c != null) {
            return this.f753c.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f751a.m719d(i, m700d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f751a.m722f()) {
            return this.f751a.m723g();
        }
        if (this.f753c != null) {
            return this.f753c.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f751a.m722f()) {
            return this.f751a.m724h();
        }
        if (this.f753c != null) {
            return this.f753c.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f751a.m722f()) {
            return this.f751a.m725i();
        }
        if (this.f753c != null) {
            return this.f753c.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f751a.m722f()) {
            return this.f751a.m726j();
        }
        if (this.f753c != null) {
            return this.f753c.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f751a != null) {
            this.f751a.m713b();
        }
        if (drawable == this.f753c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.f753c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f753c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f754d != null) {
            this.f754d.setVisible(z, z2);
        }
        if (this.f753c != null) {
            this.f753c.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f753c == null || !this.f753c.isVisible()) {
            return -2;
        }
        return this.f751a.m728l();
    }

    /* renamed from: d */
    int m700d() {
        return this.f757g;
    }

    /* renamed from: a */
    boolean m699a(int i) {
        if (i == this.f757g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f751a.f768D > 0) {
            if (this.f754d != null) {
                this.f754d.setVisible(false, false);
            }
            if (this.f753c != null) {
                this.f754d = this.f753c;
                this.f761k = this.f751a.f768D + uptimeMillis;
            } else {
                this.f754d = null;
                this.f761k = 0L;
            }
        } else if (this.f753c != null) {
            this.f753c.setVisible(false, false);
        }
        if (i >= 0 && i < this.f751a.f783j) {
            Drawable m712b = this.f751a.m712b(i);
            this.f753c = m712b;
            this.f757g = i;
            if (m712b != null) {
                if (this.f751a.f767C > 0) {
                    this.f760j = uptimeMillis + this.f751a.f767C;
                }
                m695a(m712b);
            }
        } else {
            this.f753c = null;
            this.f757g = -1;
        }
        if (this.f760j != 0 || this.f761k != 0) {
            if (this.f759i == null) {
                this.f759i = new Runnable() { // from class: androidx.appcompat.b.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0085b.this.m698a(true);
                        C0085b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.f759i);
            }
            m698a(true);
        }
        invalidateSelf();
        return true;
    }

    /* renamed from: a */
    private void m695a(Drawable drawable) {
        if (this.f762l == null) {
            this.f762l = new b();
        }
        drawable.setCallback(this.f762l.m705a(drawable.getCallback()));
        try {
            if (this.f751a.f767C <= 0 && this.f756f) {
                drawable.setAlpha(this.f755e);
            }
            if (this.f751a.f771G) {
                drawable.setColorFilter(this.f751a.f770F);
            } else {
                if (this.f751a.f774J) {
                    C0315a.m2359a(drawable, this.f751a.f772H);
                }
                if (this.f751a.f775K) {
                    C0315a.m2362a(drawable, this.f751a.f773I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f751a.f799z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                C0315a.m2365b(drawable, C0315a.m2370g(this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                C0315a.m2363a(drawable, this.f751a.f769E);
            }
            Rect rect = this.f752b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                C0315a.m2358a(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f762l.m704a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m698a(boolean z) {
        boolean z2;
        this.f756f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f753c == null) {
            this.f760j = 0L;
        } else if (this.f760j != 0) {
            if (this.f760j <= uptimeMillis) {
                this.f753c.setAlpha(this.f755e);
                this.f760j = 0L;
                z2 = false;
            } else {
                this.f753c.setAlpha(((255 - (((int) ((this.f760j - uptimeMillis) * 255)) / this.f751a.f767C)) * this.f755e) / 255);
                z2 = true;
            }
            if (this.f754d != null) {
                this.f761k = 0L;
            } else if (this.f761k != 0) {
                if (this.f761k <= uptimeMillis) {
                    this.f754d.setVisible(false, false);
                    this.f754d = null;
                    this.f761k = 0L;
                } else {
                    this.f754d.setAlpha(((((int) ((this.f761k - uptimeMillis) * 255)) / this.f751a.f768D) * this.f755e) / 255);
                    z2 = true;
                }
            }
            if (!z && z2) {
                scheduleSelf(this.f759i, 16 + uptimeMillis);
                return;
            }
        }
        z2 = false;
        if (this.f754d != null) {
        }
        if (!z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f753c;
    }

    /* renamed from: a */
    final void m697a(Resources resources) {
        this.f751a.m710a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f751a.m709a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f751a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f751a.m730n()) {
            return null;
        }
        this.f751a.f779f = getChangingConfigurations();
        return this.f751a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f758h && super.mutate() == this) {
            c mo678c = mo678c();
            mo678c.mo687a();
            mo675a(mo678c);
            this.f758h = true;
        }
        return this;
    }

    /* renamed from: c */
    c mo678c() {
        return this.f751a;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b.a.b$c */
    static abstract class c extends Drawable.ConstantState {

        /* renamed from: A */
        boolean f765A;

        /* renamed from: B */
        int f766B;

        /* renamed from: C */
        int f767C;

        /* renamed from: D */
        int f768D;

        /* renamed from: E */
        boolean f769E;

        /* renamed from: F */
        ColorFilter f770F;

        /* renamed from: G */
        boolean f771G;

        /* renamed from: H */
        ColorStateList f772H;

        /* renamed from: I */
        PorterDuff.Mode f773I;

        /* renamed from: J */
        boolean f774J;

        /* renamed from: K */
        boolean f775K;

        /* renamed from: c */
        final C0085b f776c;

        /* renamed from: d */
        Resources f777d;

        /* renamed from: e */
        int f778e;

        /* renamed from: f */
        int f779f;

        /* renamed from: g */
        int f780g;

        /* renamed from: h */
        SparseArray<Drawable.ConstantState> f781h;

        /* renamed from: i */
        Drawable[] f782i;

        /* renamed from: j */
        int f783j;

        /* renamed from: k */
        boolean f784k;

        /* renamed from: l */
        boolean f785l;

        /* renamed from: m */
        Rect f786m;

        /* renamed from: n */
        boolean f787n;

        /* renamed from: o */
        boolean f788o;

        /* renamed from: p */
        int f789p;

        /* renamed from: q */
        int f790q;

        /* renamed from: r */
        int f791r;

        /* renamed from: s */
        int f792s;

        /* renamed from: t */
        boolean f793t;

        /* renamed from: u */
        int f794u;

        /* renamed from: v */
        boolean f795v;

        /* renamed from: w */
        boolean f796w;

        /* renamed from: x */
        boolean f797x;

        /* renamed from: y */
        boolean f798y;

        /* renamed from: z */
        boolean f799z;

        c(c cVar, C0085b c0085b, Resources resources) {
            Resources resources2;
            this.f784k = false;
            this.f787n = false;
            this.f799z = true;
            this.f767C = 0;
            this.f768D = 0;
            this.f776c = c0085b;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f777d : null;
            }
            this.f777d = resources2;
            this.f778e = C0085b.m694a(resources, cVar != null ? cVar.f778e : 0);
            if (cVar != null) {
                this.f779f = cVar.f779f;
                this.f780g = cVar.f780g;
                this.f797x = true;
                this.f798y = true;
                this.f784k = cVar.f784k;
                this.f787n = cVar.f787n;
                this.f799z = cVar.f799z;
                this.f765A = cVar.f765A;
                this.f766B = cVar.f766B;
                this.f767C = cVar.f767C;
                this.f768D = cVar.f768D;
                this.f769E = cVar.f769E;
                this.f770F = cVar.f770F;
                this.f771G = cVar.f771G;
                this.f772H = cVar.f772H;
                this.f773I = cVar.f773I;
                this.f774J = cVar.f774J;
                this.f775K = cVar.f775K;
                if (cVar.f778e == this.f778e) {
                    if (cVar.f785l) {
                        this.f786m = cVar.f786m != null ? new Rect(cVar.f786m) : null;
                        this.f785l = true;
                    }
                    if (cVar.f788o) {
                        this.f789p = cVar.f789p;
                        this.f790q = cVar.f790q;
                        this.f791r = cVar.f791r;
                        this.f792s = cVar.f792s;
                        this.f788o = true;
                    }
                }
                if (cVar.f793t) {
                    this.f794u = cVar.f794u;
                    this.f793t = true;
                }
                if (cVar.f795v) {
                    this.f796w = cVar.f796w;
                    this.f795v = true;
                }
                Drawable[] drawableArr = cVar.f782i;
                this.f782i = new Drawable[drawableArr.length];
                this.f783j = cVar.f783j;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f781h;
                if (sparseArray != null) {
                    this.f781h = sparseArray.m20134clone();
                } else {
                    this.f781h = new SparseArray<>(this.f783j);
                }
                int i = this.f783j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f781h.put(i2, constantState);
                        } else {
                            this.f782i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f782i = new Drawable[10];
            this.f783j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f779f | this.f780g;
        }

        /* renamed from: a */
        public final int m708a(Drawable drawable) {
            int i = this.f783j;
            if (i >= this.f782i.length) {
                mo721e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f776c);
            this.f782i[i] = drawable;
            this.f783j++;
            this.f780g |= drawable.getChangingConfigurations();
            m713b();
            this.f786m = null;
            this.f785l = false;
            this.f788o = false;
            this.f797x = false;
            return i;
        }

        /* renamed from: b */
        void m713b() {
            this.f793t = false;
            this.f795v = false;
        }

        /* renamed from: c */
        final int m715c() {
            return this.f782i.length;
        }

        /* renamed from: o */
        private void m707o() {
            if (this.f781h != null) {
                int size = this.f781h.size();
                for (int i = 0; i < size; i++) {
                    this.f782i[this.f781h.keyAt(i)] = m706b(this.f781h.valueAt(i).newDrawable(this.f777d));
                }
                this.f781h = null;
            }
        }

        /* renamed from: b */
        private Drawable m706b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                C0315a.m2365b(drawable, this.f766B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f776c);
            return mutate;
        }

        /* renamed from: d */
        public final int m717d() {
            return this.f783j;
        }

        /* renamed from: b */
        public final Drawable m712b(int i) {
            int indexOfKey;
            Drawable drawable = this.f782i[i];
            if (drawable == null) {
                if (this.f781h == null || (indexOfKey = this.f781h.indexOfKey(i)) < 0) {
                    return null;
                }
                Drawable m706b = m706b(this.f781h.valueAt(indexOfKey).newDrawable(this.f777d));
                this.f782i[i] = m706b;
                this.f781h.removeAt(indexOfKey);
                if (this.f781h.size() == 0) {
                    this.f781h = null;
                    return m706b;
                }
                return m706b;
            }
            return drawable;
        }

        /* renamed from: d */
        final boolean m719d(int i, int i2) {
            boolean z;
            int i3 = this.f783j;
            Drawable[] drawableArr = this.f782i;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < i3) {
                if (drawableArr[i4] != null) {
                    z = Build.VERSION.SDK_INT >= 23 ? C0315a.m2365b(drawableArr[i4], i) : false;
                    if (i4 == i2) {
                        i4++;
                        z2 = z;
                    }
                }
                z = z2;
                i4++;
                z2 = z;
            }
            this.f766B = i;
            return z2;
        }

        /* renamed from: a */
        final void m710a(Resources resources) {
            if (resources != null) {
                this.f777d = resources;
                int m694a = C0085b.m694a(resources, this.f778e);
                int i = this.f778e;
                this.f778e = m694a;
                if (i != m694a) {
                    this.f788o = false;
                    this.f785l = false;
                }
            }
        }

        /* renamed from: a */
        final void m709a(Resources.Theme theme) {
            if (theme != null) {
                m707o();
                int i = this.f783j;
                Drawable[] drawableArr = this.f782i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && C0315a.m2367d(drawableArr[i2])) {
                        C0315a.m2360a(drawableArr[i2], theme);
                        this.f780g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                m710a(a.m701a(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (C0315a.m2367d(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f781h.get(i2);
                    if (constantState != null && a.m703a(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: a */
        void mo687a() {
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.f765A = true;
        }

        /* renamed from: a */
        public final void m711a(boolean z) {
            this.f784k = z;
        }

        /* renamed from: e */
        public final Rect m720e() {
            Rect rect = null;
            if (this.f784k) {
                return null;
            }
            if (this.f786m != null || this.f785l) {
                return this.f786m;
            }
            m707o();
            Rect rect2 = new Rect();
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect2)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    if (rect2.left > rect.left) {
                        rect.left = rect2.left;
                    }
                    if (rect2.top > rect.top) {
                        rect.top = rect2.top;
                    }
                    if (rect2.right > rect.right) {
                        rect.right = rect2.right;
                    }
                    if (rect2.bottom > rect.bottom) {
                        rect.bottom = rect2.bottom;
                    }
                }
            }
            this.f785l = true;
            this.f786m = rect;
            return rect;
        }

        /* renamed from: b */
        public final void m714b(boolean z) {
            this.f787n = z;
        }

        /* renamed from: f */
        public final boolean m722f() {
            return this.f787n;
        }

        /* renamed from: g */
        public final int m723g() {
            if (!this.f788o) {
                m727k();
            }
            return this.f789p;
        }

        /* renamed from: h */
        public final int m724h() {
            if (!this.f788o) {
                m727k();
            }
            return this.f790q;
        }

        /* renamed from: i */
        public final int m725i() {
            if (!this.f788o) {
                m727k();
            }
            return this.f791r;
        }

        /* renamed from: j */
        public final int m726j() {
            if (!this.f788o) {
                m727k();
            }
            return this.f792s;
        }

        /* renamed from: k */
        protected void m727k() {
            this.f788o = true;
            m707o();
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            this.f790q = -1;
            this.f789p = -1;
            this.f792s = 0;
            this.f791r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f789p) {
                    this.f789p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f790q) {
                    this.f790q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f791r) {
                    this.f791r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f792s) {
                    this.f792s = minimumHeight;
                }
            }
        }

        /* renamed from: c */
        public final void m716c(int i) {
            this.f767C = i;
        }

        /* renamed from: d */
        public final void m718d(int i) {
            this.f768D = i;
        }

        /* renamed from: l */
        public final int m728l() {
            if (this.f793t) {
                return this.f794u;
            }
            m707o();
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f794u = opacity;
            this.f793t = true;
            return opacity;
        }

        /* renamed from: m */
        public final boolean m729m() {
            boolean z = false;
            if (this.f795v) {
                return this.f796w;
            }
            m707o();
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.f796w = z;
            this.f795v = true;
            return z;
        }

        /* renamed from: e */
        public void mo721e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            if (this.f782i != null) {
                System.arraycopy(this.f782i, 0, drawableArr, 0, i);
            }
            this.f782i = drawableArr;
        }

        /* renamed from: n */
        public boolean m730n() {
            if (this.f797x) {
                return this.f798y;
            }
            m707o();
            this.f797x = true;
            int i = this.f783j;
            Drawable[] drawableArr = this.f782i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f798y = false;
                    return false;
                }
            }
            this.f798y = true;
            return true;
        }
    }

    /* renamed from: a */
    void mo675a(c cVar) {
        this.f751a = cVar;
        if (this.f757g >= 0) {
            this.f753c = cVar.m712b(this.f757g);
            if (this.f753c != null) {
                m695a(this.f753c);
            }
        }
        this.f754d = null;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b.a.b$b */
    static class b implements Drawable.Callback {

        /* renamed from: a */
        private Drawable.Callback f764a;

        b() {
        }

        /* renamed from: a */
        public b m705a(Drawable.Callback callback) {
            this.f764a = callback;
            return this;
        }

        /* renamed from: a */
        public Drawable.Callback m704a() {
            Drawable.Callback callback = this.f764a;
            this.f764a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.f764a != null) {
                this.f764a.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.f764a != null) {
                this.f764a.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: a */
    static int m694a(Resources resources, int i) {
        int i2 = resources == null ? i : resources.getDisplayMetrics().densityDpi;
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b.a.b$a */
    private static class a {
        /* renamed from: a */
        public static boolean m703a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        /* renamed from: a */
        public static Resources m701a(Resources.Theme theme) {
            return theme.getResources();
        }

        /* renamed from: a */
        public static void m702a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
