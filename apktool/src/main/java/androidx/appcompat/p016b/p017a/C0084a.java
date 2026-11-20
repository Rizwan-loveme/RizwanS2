package androidx.appcompat.p016b.p017a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p016b.p017a.C0085b;
import androidx.appcompat.p016b.p017a.C0087d;
import androidx.appcompat.p018c.C0088a;
import androidx.appcompat.widget.C0174ap;
import androidx.core.content.p028a.C0262g;
import androidx.core.graphics.drawable.InterfaceC0316b;
import androidx.p011a.C0039d;
import androidx.p011a.C0043h;
import androidx.p041g.p042a.p043a.C0398c;
import androidx.p041g.p042a.p043a.C0404i;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.a */
/* loaded from: classes.dex */
public class C0084a extends C0087d implements InterfaceC0316b {

    /* renamed from: a */
    private static final String f736a = C0084a.class.getSimpleName();

    /* renamed from: b */
    private b f737b;

    /* renamed from: c */
    private f f738c;

    /* renamed from: d */
    private int f739d;

    /* renamed from: e */
    private int f740e;

    /* renamed from: f */
    private boolean f741f;

    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public C0084a() {
        this(null, null);
    }

    C0084a(b bVar, Resources resources) {
        super(null);
        this.f739d = -1;
        this.f740e = -1;
        mo675a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: a */
    public static C0084a m667a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        C0084a c0084a = new C0084a();
        c0084a.mo677b(context, resources, xmlPullParser, attributeSet, theme);
        return c0084a;
    }

    @Override // androidx.appcompat.p016b.p017a.C0087d
    /* renamed from: b */
    public void mo677b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0088a.b.AnimatedStateListDrawableCompat);
        setVisible(m1928a.getBoolean(C0088a.b.AnimatedStateListDrawableCompat_android_visible, true), true);
        m668a(m1928a);
        m697a(resources);
        m1928a.recycle();
        m670c(context, resources, xmlPullParser, attributeSet, theme);
        m673e();
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f738c != null && (visible || z2)) {
            if (z) {
                this.f738c.mo679a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.f738c != null) {
            this.f738c.mo680b();
            this.f738c = null;
            m699a(this.f739d);
            this.f739d = -1;
            this.f740e = -1;
        }
    }

    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int m685a = this.f737b.m685a(iArr);
        boolean z = m685a != m700d() && (m669b(m685a) || m699a(m685a));
        Drawable current = getCurrent();
        if (current != null) {
            return z | current.setState(iArr);
        }
        return z;
    }

    /* renamed from: b */
    private boolean m669b(int i) {
        int d2;
        f aVar;
        f fVar = this.f738c;
        if (fVar != null) {
            if (i == this.f739d) {
                return true;
            }
            if (i == this.f740e && fVar.mo690c()) {
                fVar.mo691d();
                this.f739d = this.f740e;
                this.f740e = i;
                return true;
            }
            int i2 = this.f739d;
            fVar.mo680b();
            d2 = i2;
        } else {
            d2 = m700d();
        }
        this.f738c = null;
        this.f740e = -1;
        this.f739d = -1;
        b bVar = this.f737b;
        int m682a = bVar.m682a(d2);
        int m682a2 = bVar.m682a(i);
        if (m682a2 == 0 || m682a == 0) {
            return false;
        }
        int m683a = bVar.m683a(m682a, m682a2);
        if (m683a < 0) {
            return false;
        }
        boolean m689c = bVar.m689c(m682a, m682a2);
        m699a(m683a);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new d((AnimationDrawable) current, bVar.m688b(m682a, m682a2), m689c);
        } else if (current instanceof C0398c) {
            aVar = new c((C0398c) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            aVar = new a((Animatable) current);
        }
        aVar.mo679a();
        this.f738c = aVar;
        this.f740e = d2;
        this.f739d = i;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$f */
    private static abstract class f {
        /* renamed from: a */
        public abstract void mo679a();

        /* renamed from: b */
        public abstract void mo680b();

        private f() {
        }

        /* renamed from: d */
        public void mo691d() {
        }

        /* renamed from: c */
        public boolean mo690c() {
            return false;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$a */
    private static class a extends f {

        /* renamed from: a */
        private final Animatable f742a;

        a(Animatable animatable) {
            super();
            this.f742a = animatable;
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: a */
        public void mo679a() {
            this.f742a.start();
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: b */
        public void mo680b() {
            this.f742a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$d */
    private static class d extends f {

        /* renamed from: a */
        private final ObjectAnimator f746a;

        /* renamed from: b */
        private final boolean f747b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(eVar.m692a());
            ofInt.setInterpolator(eVar);
            this.f747b = z2;
            this.f746a = ofInt;
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: c */
        public boolean mo690c() {
            return this.f747b;
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: a */
        public void mo679a() {
            this.f746a.start();
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: d */
        public void mo691d() {
            this.f746a.reverse();
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: b */
        public void mo680b() {
            this.f746a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$c */
    private static class c extends f {

        /* renamed from: a */
        private final C0398c f745a;

        c(C0398c c0398c) {
            super();
            this.f745a = c0398c;
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: a */
        public void mo679a() {
            this.f745a.start();
        }

        @Override // androidx.appcompat.p016b.p017a.C0084a.f
        /* renamed from: b */
        public void mo680b() {
            this.f745a.stop();
        }
    }

    /* renamed from: a */
    private void m668a(TypedArray typedArray) {
        b bVar = this.f737b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f779f |= typedArray.getChangingConfigurations();
        }
        bVar.m711a(typedArray.getBoolean(C0088a.b.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f784k));
        bVar.m714b(typedArray.getBoolean(C0088a.b.AnimatedStateListDrawableCompat_android_constantSize, bVar.f787n));
        bVar.m716c(typedArray.getInt(C0088a.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.f767C));
        bVar.m718d(typedArray.getInt(C0088a.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.f768D));
        setDither(typedArray.getBoolean(C0088a.b.AnimatedStateListDrawableCompat_android_dither, bVar.f799z));
    }

    /* renamed from: e */
    private void m673e() {
        onStateChange(getState());
    }

    /* renamed from: c */
    private void m670c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth) {
                        if (xmlPullParser.getName().equals("item")) {
                            m672e(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals("transition")) {
                            m671d(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private int m671d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0088a.b.AnimatedStateListDrawableTransition);
        int resourceId = m1928a.getResourceId(C0088a.b.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = m1928a.getResourceId(C0088a.b.AnimatedStateListDrawableTransition_android_toId, -1);
        Drawable drawable = null;
        int resourceId3 = m1928a.getResourceId(C0088a.b.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = C0174ap.m1352a().m1364a(context, resourceId3);
        }
        boolean z = m1928a.getBoolean(C0088a.b.AnimatedStateListDrawableTransition_android_reversible, false);
        m1928a.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = C0398c.m3199a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        return this.f737b.m684a(resourceId, resourceId2, drawable, z);
    }

    /* renamed from: e */
    private int m672e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0088a.b.AnimatedStateListDrawableItem);
        int resourceId = m1928a.getResourceId(C0088a.b.AnimatedStateListDrawableItem_android_id, 0);
        Drawable drawable = null;
        int resourceId2 = m1928a.getResourceId(C0088a.b.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = C0174ap.m1352a().m1364a(context, resourceId2);
        }
        m1928a.recycle();
        int[] a2 = m735a(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawable = C0404i.m3233a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.f737b.m686a(a2, drawable, resourceId);
    }

    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f741f && super.mutate() == this) {
            this.f737b.mo687a();
            this.f741f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b mo678c() {
        return new b(this.f737b, this, null);
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$b */
    static class b extends C0087d.a {

        /* renamed from: a */
        C0039d<Long> f743a;

        /* renamed from: b */
        C0043h<Integer> f744b;

        b(b bVar, C0084a c0084a, Resources resources) {
            super(bVar, c0084a, resources);
            if (bVar != null) {
                this.f743a = bVar.f743a;
                this.f744b = bVar.f744b;
            } else {
                this.f743a = new C0039d<>();
                this.f744b = new C0043h<>();
            }
        }

        @Override // androidx.appcompat.p016b.p017a.C0087d.a, androidx.appcompat.p016b.p017a.C0085b.c
        /* renamed from: a */
        void mo687a() {
            this.f743a = this.f743a.clone();
            this.f744b = this.f744b.clone();
        }

        /* renamed from: a */
        int m684a(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.m708a(drawable);
            long m681f = m681f(i, i2);
            long j = 0;
            if (z) {
                j = 8589934592L;
            }
            this.f743a.m243c(m681f, Long.valueOf(a2 | j));
            if (z) {
                this.f743a.m243c(m681f(i2, i), Long.valueOf(j | a2 | 4294967296L));
            }
            return a2;
        }

        /* renamed from: a */
        int m686a(int[] iArr, Drawable drawable, int i) {
            int m736a = super.m736a(iArr, drawable);
            this.f744b.m280b(m736a, Integer.valueOf(i));
            return m736a;
        }

        /* renamed from: a */
        int m685a(int[] iArr) {
            int m737b = super.m737b(iArr);
            return m737b >= 0 ? m737b : super.m737b(StateSet.WILD_CARD);
        }

        /* renamed from: a */
        int m682a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f744b.m277a(i, 0).intValue();
        }

        /* renamed from: a */
        int m683a(int i, int i2) {
            return (int) this.f743a.m237a(m681f(i, i2), -1L).longValue();
        }

        /* renamed from: b */
        boolean m688b(int i, int i2) {
            return (this.f743a.m237a(m681f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* renamed from: c */
        boolean m689c(int i, int i2) {
            return (this.f743a.m237a(m681f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.p016b.p017a.C0087d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0084a(this, null);
        }

        @Override // androidx.appcompat.p016b.p017a.C0087d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0084a(this, resources);
        }

        /* renamed from: f */
        private static long m681f(int i, int i2) {
            return (i << 32) | i2;
        }
    }

    @Override // androidx.appcompat.p016b.p017a.C0087d, androidx.appcompat.p016b.p017a.C0085b
    /* renamed from: a */
    void mo675a(C0085b.c cVar) {
        super.mo675a(cVar);
        if (cVar instanceof b) {
            this.f737b = (b) cVar;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$e */
    private static class e implements TimeInterpolator {

        /* renamed from: a */
        private int[] f748a;

        /* renamed from: b */
        private int f749b;

        /* renamed from: c */
        private int f750c;

        e(AnimationDrawable animationDrawable, boolean z) {
            m693a(animationDrawable, z);
        }

        /* renamed from: a */
        int m693a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f749b = numberOfFrames;
            if (this.f748a == null || this.f748a.length < numberOfFrames) {
                this.f748a = new int[numberOfFrames];
            }
            int[] iArr = this.f748a;
            int i = 0;
            int i2 = 0;
            while (i < numberOfFrames) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i) - 1 : i);
                iArr[i] = duration;
                i++;
                i2 = duration + i2;
            }
            this.f750c = i2;
            return i2;
        }

        /* renamed from: a */
        int m692a() {
            return this.f750c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3;
            int i = (int) ((this.f750c * f2) + 0.5f);
            int i2 = this.f749b;
            int[] iArr = this.f748a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            if (i3 < i2) {
                f3 = i / this.f750c;
            } else {
                f3 = 0.0f;
            }
            return f3 + (i3 / i2);
        }
    }
}
