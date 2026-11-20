package androidx.p041g.p042a.p043a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.p028a.C0262g;
import androidx.core.graphics.drawable.C0315a;
import androidx.p011a.C0036a;
import java.util.ArrayList;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* renamed from: androidx.g.a.a.c */
/* loaded from: classes.dex */
public class C0398c extends AbstractC0403h implements InterfaceC0397b {

    /* renamed from: a */
    ArrayList<Object> f2940a;

    /* renamed from: b */
    final Drawable.Callback f2941b;

    /* renamed from: d */
    private a f2942d;

    /* renamed from: e */
    private Context f2943e;

    /* renamed from: f */
    private ArgbEvaluator f2944f;

    /* renamed from: g */
    private Animator.AnimatorListener f2945g;

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C0398c() {
        this(null, null, null);
    }

    private C0398c(Context context) {
        this(context, null, null);
    }

    private C0398c(Context context, a aVar, Resources resources) {
        this.f2944f = null;
        this.f2945g = null;
        this.f2940a = null;
        this.f2941b = new Drawable.Callback() { // from class: androidx.g.a.a.c.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                C0398c.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                C0398c.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                C0398c.this.unscheduleSelf(runnable);
            }
        };
        this.f2943e = context;
        if (aVar != null) {
            this.f2942d = aVar;
        } else {
            this.f2942d = new a(context, aVar, this.f2941b, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f2957c != null) {
            this.f2957c.mutate();
        }
        return this;
    }

    /* renamed from: a */
    public static C0398c m3199a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0398c c0398c = new C0398c(context);
        c0398c.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0398c;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2957c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f2957c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f2957c != null ? this.f2957c.getChangingConfigurations() : super.getChangingConfigurations() | this.f2942d.f2947a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2957c != null) {
            this.f2957c.draw(canvas);
            return;
        }
        this.f2942d.f2948b.draw(canvas);
        if (this.f2942d.f2949c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f2957c != null) {
            this.f2957c.setBounds(rect);
        } else {
            this.f2942d.f2948b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.f2957c != null ? this.f2957c.setState(iArr) : this.f2942d.f2948b.setState(iArr);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f2957c != null ? this.f2957c.setLevel(i) : this.f2942d.f2948b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2957c != null ? C0315a.m2366c(this.f2957c) : this.f2942d.f2948b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2957c != null) {
            this.f2957c.setAlpha(i);
        } else {
            this.f2942d.f2948b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2957c != null) {
            this.f2957c.setColorFilter(colorFilter);
        } else {
            this.f2942d.f2948b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2957c != null ? C0315a.m2368e(this.f2957c) : this.f2942d.f2948b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        if (this.f2957c != null) {
            C0315a.m2357a(this.f2957c, i);
        } else {
            this.f2942d.f2948b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2957c != null) {
            C0315a.m2359a(this.f2957c, colorStateList);
        } else {
            this.f2942d.f2948b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2957c != null) {
            C0315a.m2362a(this.f2957c, mode);
        } else {
            this.f2942d.f2948b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2957c != null) {
            return this.f2957c.setVisible(z, z2);
        }
        this.f2942d.f2948b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f2957c != null ? this.f2957c.isStateful() : this.f2942d.f2948b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2957c != null ? this.f2957c.getOpacity() : this.f2942d.f2948b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2957c != null ? this.f2957c.getIntrinsicWidth() : this.f2942d.f2948b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2957c != null ? this.f2957c.getIntrinsicHeight() : this.f2942d.f2948b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f2957c != null ? C0315a.m2364b(this.f2957c) : this.f2942d.f2948b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f2957c != null) {
            C0315a.m2363a(this.f2957c, z);
        } else {
            this.f2942d.f2948b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f2957c != null) {
            C0315a.m2361a(this.f2957c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2932e);
                    int resourceId = m1928a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0404i m3232a = C0404i.m3232a(resources, resourceId, theme);
                        m3232a.m3239a(false);
                        m3232a.setCallback(this.f2941b);
                        if (this.f2942d.f2948b != null) {
                            this.f2942d.f2948b.setCallback(null);
                        }
                        this.f2942d.f2948b = m3232a;
                    }
                    m1928a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0396a.f2933f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f2943e != null) {
                            m3201a(string, C0400e.m3207a(this.f2943e, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2942d.m3202a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f2957c != null) {
            C0315a.m2360a(this.f2957c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f2957c != null) {
            return C0315a.m2367d(this.f2957c);
        }
        return false;
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.c$b */
    private static class b extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f2952a;

        public b(Drawable.ConstantState constantState) {
            this.f2952a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C0398c c0398c = new C0398c();
            c0398c.f2957c = this.f2952a.newDrawable();
            c0398c.f2957c.setCallback(c0398c.f2941b);
            return c0398c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C0398c c0398c = new C0398c();
            c0398c.f2957c = this.f2952a.newDrawable(resources);
            c0398c.f2957c.setCallback(c0398c.f2941b);
            return c0398c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0398c c0398c = new C0398c();
            c0398c.f2957c = this.f2952a.newDrawable(resources, theme);
            c0398c.f2957c.setCallback(c0398c.f2941b);
            return c0398c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2952a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2952a.getChangingConfigurations();
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.c$a */
    private static class a extends Drawable.ConstantState {

        /* renamed from: a */
        int f2947a;

        /* renamed from: b */
        C0404i f2948b;

        /* renamed from: c */
        AnimatorSet f2949c;

        /* renamed from: d */
        ArrayList<Animator> f2950d;

        /* renamed from: e */
        C0036a<Animator, String> f2951e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2947a = aVar.f2947a;
                if (aVar.f2948b != null) {
                    Drawable.ConstantState constantState = aVar.f2948b.getConstantState();
                    if (resources != null) {
                        this.f2948b = (C0404i) constantState.newDrawable(resources);
                    } else {
                        this.f2948b = (C0404i) constantState.newDrawable();
                    }
                    this.f2948b = (C0404i) this.f2948b.mutate();
                    this.f2948b.setCallback(callback);
                    this.f2948b.setBounds(aVar.f2948b.getBounds());
                    this.f2948b.m3239a(false);
                }
                if (aVar.f2950d != null) {
                    int size = aVar.f2950d.size();
                    this.f2950d = new ArrayList<>(size);
                    this.f2951e = new C0036a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f2950d.get(i);
                        Animator mo20118clone = animator.mo20118clone();
                        String str = aVar.f2951e.get(animator);
                        mo20118clone.setTarget(this.f2948b.m3238a(str));
                        this.f2950d.add(mo20118clone);
                        this.f2951e.put(mo20118clone, str);
                    }
                    m3202a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2947a;
        }

        /* renamed from: a */
        public void m3202a() {
            if (this.f2949c == null) {
                this.f2949c = new AnimatorSet();
            }
            this.f2949c.playTogether(this.f2950d);
        }
    }

    /* renamed from: a */
    private void m3200a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                m3200a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2944f == null) {
                    this.f2944f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2944f);
            }
        }
    }

    /* renamed from: a */
    private void m3201a(String str, Animator animator) {
        animator.setTarget(this.f2942d.f2948b.m3238a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m3200a(animator);
        }
        if (this.f2942d.f2950d == null) {
            this.f2942d.f2950d = new ArrayList<>();
            this.f2942d.f2951e = new C0036a<>();
        }
        this.f2942d.f2950d.add(animator);
        this.f2942d.f2951e.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2957c != null ? ((AnimatedVectorDrawable) this.f2957c).isRunning() : this.f2942d.f2949c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f2957c != null) {
            ((AnimatedVectorDrawable) this.f2957c).start();
        } else if (!this.f2942d.f2949c.isStarted()) {
            this.f2942d.f2949c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f2957c != null) {
            ((AnimatedVectorDrawable) this.f2957c).stop();
        } else {
            this.f2942d.f2949c.end();
        }
    }
}
