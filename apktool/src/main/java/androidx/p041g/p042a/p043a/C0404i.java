package androidx.p041g.p042a.p043a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.wifi.WifiConfiguration;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.p028a.C0257b;
import androidx.core.content.p028a.C0261f;
import androidx.core.content.p028a.C0262g;
import androidx.core.graphics.C0313c;
import androidx.core.graphics.drawable.C0315a;
import androidx.p011a.C0036a;
import java.p209io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* renamed from: androidx.g.a.a.i */
/* loaded from: classes.dex */
public class C0404i extends AbstractC0403h {

    /* renamed from: a */
    static final PorterDuff.Mode f2958a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private g f2959b;

    /* renamed from: d */
    private PorterDuffColorFilter f2960d;

    /* renamed from: e */
    private ColorFilter f2961e;

    /* renamed from: f */
    private boolean f2962f;

    /* renamed from: g */
    private boolean f2963g;

    /* renamed from: h */
    private Drawable.ConstantState f2964h;

    /* renamed from: i */
    private final float[] f2965i;

    /* renamed from: j */
    private final Matrix f2966j;

    /* renamed from: k */
    private final Rect f2967k;

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

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

    C0404i() {
        this.f2963g = true;
        this.f2965i = new float[9];
        this.f2966j = new Matrix();
        this.f2967k = new Rect();
        this.f2959b = new g();
    }

    C0404i(g gVar) {
        this.f2963g = true;
        this.f2965i = new float[9];
        this.f2966j = new Matrix();
        this.f2967k = new Rect();
        this.f2959b = gVar;
        this.f2960d = m3237a(this.f2960d, gVar.f3016c, gVar.f3017d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f2957c != null) {
            this.f2957c.mutate();
        } else if (!this.f2962f && super.mutate() == this) {
            this.f2959b = new g(this.f2959b);
            this.f2962f = true;
        }
        return this;
    }

    /* renamed from: a */
    Object m3238a(String str) {
        return this.f2959b.f3015b.f3008k.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2957c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f2957c.getConstantState());
        }
        this.f2959b.f3014a = getChangingConfigurations();
        return this.f2959b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2957c != null) {
            this.f2957c.draw(canvas);
            return;
        }
        copyBounds(this.f2967k);
        if (this.f2967k.width() > 0 && this.f2967k.height() > 0) {
            ColorFilter colorFilter = this.f2961e == null ? this.f2960d : this.f2961e;
            canvas.getMatrix(this.f2966j);
            this.f2966j.getValues(this.f2965i);
            float abs = Math.abs(this.f2965i[0]);
            float abs2 = Math.abs(this.f2965i[4]);
            float abs3 = Math.abs(this.f2965i[1]);
            float abs4 = Math.abs(this.f2965i[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int min = Math.min(2048, (int) (abs * this.f2967k.width()));
            int min2 = Math.min(2048, (int) (abs2 * this.f2967k.height()));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(this.f2967k.left, this.f2967k.top);
                if (m3235a()) {
                    canvas.translate(this.f2967k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2967k.offsetTo(0, 0);
                this.f2959b.m3265b(min, min2);
                if (!this.f2963g) {
                    this.f2959b.m3261a(min, min2);
                } else if (!this.f2959b.m3266b()) {
                    this.f2959b.m3261a(min, min2);
                    this.f2959b.m3267c();
                }
                this.f2959b.m3262a(canvas, colorFilter, this.f2967k);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2957c != null ? C0315a.m2366c(this.f2957c) : this.f2959b.f3015b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2957c != null) {
            this.f2957c.setAlpha(i);
        } else if (this.f2959b.f3015b.getRootAlpha() != i) {
            this.f2959b.f3015b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2957c != null) {
            this.f2957c.setColorFilter(colorFilter);
        } else {
            this.f2961e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2957c != null ? C0315a.m2368e(this.f2957c) : this.f2961e;
    }

    /* renamed from: a */
    PorterDuffColorFilter m3237a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        if (this.f2957c != null) {
            C0315a.m2357a(this.f2957c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2957c != null) {
            C0315a.m2359a(this.f2957c, colorStateList);
            return;
        }
        g gVar = this.f2959b;
        if (gVar.f3016c != colorStateList) {
            gVar.f3016c = colorStateList;
            this.f2960d = m3237a(this.f2960d, colorStateList, gVar.f3017d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2957c != null) {
            C0315a.m2362a(this.f2957c, mode);
            return;
        }
        g gVar = this.f2959b;
        if (gVar.f3017d != mode) {
            gVar.f3017d = mode;
            this.f2960d = m3237a(this.f2960d, gVar.f3016c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f2957c != null) {
            return this.f2957c.isStateful();
        }
        return super.isStateful() || (this.f2959b != null && (this.f2959b.m3269d() || (this.f2959b.f3016c != null && this.f2959b.f3016c.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f2957c != null) {
            return this.f2957c.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f2959b;
        if (gVar.f3016c != null && gVar.f3017d != null) {
            this.f2960d = m3237a(this.f2960d, gVar.f3016c, gVar.f3017d);
            invalidateSelf();
            z = true;
        }
        if (gVar.m3269d() && gVar.m3264a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f2957c != null) {
            return this.f2957c.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2957c != null ? this.f2957c.getIntrinsicWidth() : (int) this.f2959b.f3015b.f3001d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2957c != null ? this.f2957c.getIntrinsicHeight() : (int) this.f2959b.f3015b.f3002e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f2957c != null) {
            C0315a.m2367d(this.f2957c);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f2957c != null ? C0315a.m2364b(this.f2957c) : this.f2959b.f3018e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f2957c != null) {
            C0315a.m2363a(this.f2957c, z);
        } else {
            this.f2959b.f3018e = z;
        }
    }

    /* renamed from: a */
    public static C0404i m3232a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            C0404i c0404i = new C0404i();
            c0404i.f2957c = C0261f.m1912a(resources, i, theme);
            c0404i.f2964h = new h(c0404i.f2957c.getConstantState());
            return c0404i;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return m3233a(resources, xml, asAttributeSet, theme);
        } catch (IOException e2) {
            Log.m185e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.m185e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    /* renamed from: a */
    public static C0404i m3233a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0404i c0404i = new C0404i();
        c0404i.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0404i;
    }

    /* renamed from: a */
    static int m3230a(int i, float f2) {
        return (((int) (Color.alpha(i) * f2)) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f2957c != null) {
            this.f2957c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f2957c != null) {
            C0315a.m2361a(this.f2957c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f2959b;
        gVar.f3015b = new f();
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2928a);
        m3234a(m1928a, xmlPullParser, theme);
        m1928a.recycle();
        gVar.f3014a = getChangingConfigurations();
        gVar.f3024k = true;
        m3236b(resources, xmlPullParser, attributeSet, theme);
        this.f2960d = m3237a(this.f2960d, gVar.f3016c, gVar.f3017d);
    }

    /* renamed from: a */
    private static PorterDuff.Mode m3231a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }

    /* renamed from: a */
    private void m3234a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        g gVar = this.f2959b;
        f fVar = gVar.f3015b;
        gVar.f3017d = m3231a(C0262g.m1925a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList m1926a = C0262g.m1926a(typedArray, xmlPullParser, theme, "tint", 1);
        if (m1926a != null) {
            gVar.f3016c = m1926a;
        }
        gVar.f3018e = C0262g.m1931a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f3018e);
        fVar.f3003f = C0262g.m1924a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f3003f);
        fVar.f3004g = C0262g.m1924a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f3004g);
        if (fVar.f3003f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fVar.f3004g <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        fVar.f3001d = typedArray.getDimension(3, fVar.f3001d);
        fVar.f3002e = typedArray.getDimension(2, fVar.f3002e);
        if (fVar.f3001d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (fVar.f3002e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        fVar.setAlpha(C0262g.m1924a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            fVar.f3006i = string;
            fVar.f3008k.put(string, fVar);
        }
    }

    /* renamed from: b */
    private void m3236b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        boolean z;
        g gVar = this.f2959b;
        f fVar = gVar.f3015b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f3000c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.m3246a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2981b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.f3008k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f3014a = bVar.f2996o | gVar.f3014a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.m3241a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2981b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.f3008k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f3014a |= aVar.f2996o;
                    z = z2;
                } else {
                    if (WifiConfiguration.GroupCipher.varName.equals(name)) {
                        c cVar2 = new c();
                        cVar2.m3251a(resources, attributeSet, theme, xmlPullParser);
                        cVar.f2981b.add(cVar2);
                        arrayDeque.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            fVar.f3008k.put(cVar2.getGroupName(), cVar2);
                        }
                        gVar.f3014a |= cVar2.f2984e;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && WifiConfiguration.GroupCipher.varName.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* renamed from: a */
    void m3239a(boolean z) {
        this.f2963g = z;
    }

    /* renamed from: a */
    private boolean m3235a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return isAutoMirrored() && C0315a.m2370g(this) == 1;
        }
        return false;
    }

    @Override // androidx.p041g.p042a.p043a.AbstractC0403h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f2957c != null) {
            this.f2957c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f2957c != null ? this.f2957c.getChangingConfigurations() : super.getChangingConfigurations() | this.f2959b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f2957c != null) {
            this.f2957c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f2957c != null) {
            this.f2957c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f2957c != null ? this.f2957c.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f2957c != null) {
            this.f2957c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$h */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f3026a;

        public h(Drawable.ConstantState constantState) {
            this.f3026a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C0404i c0404i = new C0404i();
            c0404i.f2957c = (VectorDrawable) this.f3026a.newDrawable();
            return c0404i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C0404i c0404i = new C0404i();
            c0404i.f2957c = (VectorDrawable) this.f3026a.newDrawable(resources);
            return c0404i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0404i c0404i = new C0404i();
            c0404i.f2957c = (VectorDrawable) this.f3026a.newDrawable(resources, theme);
            return c0404i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3026a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3026a.getChangingConfigurations();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$g */
    private static class g extends Drawable.ConstantState {

        /* renamed from: a */
        int f3014a;

        /* renamed from: b */
        f f3015b;

        /* renamed from: c */
        ColorStateList f3016c;

        /* renamed from: d */
        PorterDuff.Mode f3017d;

        /* renamed from: e */
        boolean f3018e;

        /* renamed from: f */
        Bitmap f3019f;

        /* renamed from: g */
        ColorStateList f3020g;

        /* renamed from: h */
        PorterDuff.Mode f3021h;

        /* renamed from: i */
        int f3022i;

        /* renamed from: j */
        boolean f3023j;

        /* renamed from: k */
        boolean f3024k;

        /* renamed from: l */
        Paint f3025l;

        public g(g gVar) {
            this.f3016c = null;
            this.f3017d = C0404i.f2958a;
            if (gVar != null) {
                this.f3014a = gVar.f3014a;
                this.f3015b = new f(gVar.f3015b);
                if (gVar.f3015b.f2999b != null) {
                    this.f3015b.f2999b = new Paint(gVar.f3015b.f2999b);
                }
                if (gVar.f3015b.f2998a != null) {
                    this.f3015b.f2998a = new Paint(gVar.f3015b.f2998a);
                }
                this.f3016c = gVar.f3016c;
                this.f3017d = gVar.f3017d;
                this.f3018e = gVar.f3018e;
            }
        }

        /* renamed from: a */
        public void m3262a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3019f, (Rect) null, rect, m3260a(colorFilter));
        }

        /* renamed from: a */
        public boolean m3263a() {
            return this.f3015b.getRootAlpha() < 255;
        }

        /* renamed from: a */
        public Paint m3260a(ColorFilter colorFilter) {
            if (!m3263a() && colorFilter == null) {
                return null;
            }
            if (this.f3025l == null) {
                this.f3025l = new Paint();
                this.f3025l.setFilterBitmap(true);
            }
            this.f3025l.setAlpha(this.f3015b.getRootAlpha());
            this.f3025l.setColorFilter(colorFilter);
            return this.f3025l;
        }

        /* renamed from: a */
        public void m3261a(int i, int i2) {
            this.f3019f.eraseColor(0);
            this.f3015b.m3257a(new Canvas(this.f3019f), i, i2, (ColorFilter) null);
        }

        /* renamed from: b */
        public void m3265b(int i, int i2) {
            if (this.f3019f == null || !m3268c(i, i2)) {
                this.f3019f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f3024k = true;
            }
        }

        /* renamed from: c */
        public boolean m3268c(int i, int i2) {
            return i == this.f3019f.getWidth() && i2 == this.f3019f.getHeight();
        }

        /* renamed from: b */
        public boolean m3266b() {
            return !this.f3024k && this.f3020g == this.f3016c && this.f3021h == this.f3017d && this.f3023j == this.f3018e && this.f3022i == this.f3015b.getRootAlpha();
        }

        /* renamed from: c */
        public void m3267c() {
            this.f3020g = this.f3016c;
            this.f3021h = this.f3017d;
            this.f3022i = this.f3015b.getRootAlpha();
            this.f3023j = this.f3018e;
            this.f3024k = false;
        }

        public g() {
            this.f3016c = null;
            this.f3017d = C0404i.f2958a;
            this.f3015b = new f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0404i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0404i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3014a;
        }

        /* renamed from: d */
        public boolean m3269d() {
            return this.f3015b.m3258a();
        }

        /* renamed from: a */
        public boolean m3264a(int[] iArr) {
            boolean m3259a = this.f3015b.m3259a(iArr);
            this.f3024k |= m3259a;
            return m3259a;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$f */
    private static class f {

        /* renamed from: n */
        private static final Matrix f2997n = new Matrix();

        /* renamed from: a */
        Paint f2998a;

        /* renamed from: b */
        Paint f2999b;

        /* renamed from: c */
        final c f3000c;

        /* renamed from: d */
        float f3001d;

        /* renamed from: e */
        float f3002e;

        /* renamed from: f */
        float f3003f;

        /* renamed from: g */
        float f3004g;

        /* renamed from: h */
        int f3005h;

        /* renamed from: i */
        String f3006i;

        /* renamed from: j */
        Boolean f3007j;

        /* renamed from: k */
        final C0036a<String, Object> f3008k;

        /* renamed from: l */
        private final Path f3009l;

        /* renamed from: m */
        private final Path f3010m;

        /* renamed from: o */
        private final Matrix f3011o;

        /* renamed from: p */
        private PathMeasure f3012p;

        /* renamed from: q */
        private int f3013q;

        public f() {
            this.f3011o = new Matrix();
            this.f3001d = 0.0f;
            this.f3002e = 0.0f;
            this.f3003f = 0.0f;
            this.f3004g = 0.0f;
            this.f3005h = 255;
            this.f3006i = null;
            this.f3007j = null;
            this.f3008k = new C0036a<>();
            this.f3000c = new c();
            this.f3009l = new Path();
            this.f3010m = new Path();
        }

        public void setRootAlpha(int i) {
            this.f3005h = i;
        }

        public int getRootAlpha() {
            return this.f3005h;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (255.0f * f2));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public f(f fVar) {
            this.f3011o = new Matrix();
            this.f3001d = 0.0f;
            this.f3002e = 0.0f;
            this.f3003f = 0.0f;
            this.f3004g = 0.0f;
            this.f3005h = 255;
            this.f3006i = null;
            this.f3007j = null;
            this.f3008k = new C0036a<>();
            this.f3000c = new c(fVar.f3000c, this.f3008k);
            this.f3009l = new Path(fVar.f3009l);
            this.f3010m = new Path(fVar.f3010m);
            this.f3001d = fVar.f3001d;
            this.f3002e = fVar.f3002e;
            this.f3003f = fVar.f3003f;
            this.f3004g = fVar.f3004g;
            this.f3013q = fVar.f3013q;
            this.f3005h = fVar.f3005h;
            this.f3006i = fVar.f3006i;
            if (fVar.f3006i != null) {
                this.f3008k.put(fVar.f3006i, this);
            }
            this.f3007j = fVar.f3007j;
        }

        /* renamed from: a */
        private void m3255a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f2980a.set(matrix);
            cVar.f2980a.preConcat(cVar.f2983d);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.f2981b.size()) {
                    d dVar = cVar.f2981b.get(i4);
                    if (dVar instanceof c) {
                        m3255a((c) dVar, cVar.f2980a, canvas, i, i2, colorFilter);
                    } else if (dVar instanceof e) {
                        m3256a(cVar, (e) dVar, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        /* renamed from: a */
        public void m3257a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m3255a(this.f3000c, f2997n, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        private void m3256a(c cVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f2 = i / this.f3003f;
            float f3 = i2 / this.f3004g;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f2980a;
            this.f3011o.set(matrix);
            this.f3011o.postScale(f2, f3);
            float m3254a = m3254a(matrix);
            if (m3254a != 0.0f) {
                eVar.m3252a(this.f3009l);
                Path path = this.f3009l;
                this.f3010m.reset();
                if (eVar.mo3242a()) {
                    this.f3010m.setFillType(eVar.f2995n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f3010m.addPath(path, this.f3011o);
                    canvas.clipPath(this.f3010m);
                    return;
                }
                b bVar = (b) eVar;
                if (bVar.f2973f != 0.0f || bVar.f2974g != 1.0f) {
                    float f4 = (bVar.f2973f + bVar.f2975h) % 1.0f;
                    float f5 = (bVar.f2974g + bVar.f2975h) % 1.0f;
                    if (this.f3012p == null) {
                        this.f3012p = new PathMeasure();
                    }
                    this.f3012p.setPath(this.f3009l, false);
                    float length = this.f3012p.getLength();
                    float f6 = f4 * length;
                    float f7 = f5 * length;
                    path.reset();
                    if (f6 > f7) {
                        this.f3012p.getSegment(f6, length, path, true);
                        this.f3012p.getSegment(0.0f, f7, path, true);
                    } else {
                        this.f3012p.getSegment(f6, f7, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f3010m.addPath(path, this.f3011o);
                if (bVar.f2970c.m1878e()) {
                    C0257b c0257b = bVar.f2970c;
                    if (this.f2999b == null) {
                        this.f2999b = new Paint(1);
                        this.f2999b.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f2999b;
                    if (c0257b.m1876c()) {
                        Shader m1872a = c0257b.m1872a();
                        m1872a.setLocalMatrix(this.f3011o);
                        paint.setShader(m1872a);
                        paint.setAlpha(Math.round(bVar.f2972e * 255.0f));
                    } else {
                        paint.setShader(null);
                        paint.setAlpha(255);
                        paint.setColor(C0404i.m3230a(c0257b.m1874b(), bVar.f2972e));
                    }
                    paint.setColorFilter(colorFilter);
                    this.f3010m.setFillType(bVar.f2995n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f3010m, paint);
                }
                if (bVar.f2968a.m1878e()) {
                    C0257b c0257b2 = bVar.f2968a;
                    if (this.f2998a == null) {
                        this.f2998a = new Paint(1);
                        this.f2998a.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.f2998a;
                    if (bVar.f2977j != null) {
                        paint2.setStrokeJoin(bVar.f2977j);
                    }
                    if (bVar.f2976i != null) {
                        paint2.setStrokeCap(bVar.f2976i);
                    }
                    paint2.setStrokeMiter(bVar.f2978k);
                    if (c0257b2.m1876c()) {
                        Shader m1872a2 = c0257b2.m1872a();
                        m1872a2.setLocalMatrix(this.f3011o);
                        paint2.setShader(m1872a2);
                        paint2.setAlpha(Math.round(bVar.f2971d * 255.0f));
                    } else {
                        paint2.setShader(null);
                        paint2.setAlpha(255);
                        paint2.setColor(C0404i.m3230a(c0257b2.m1874b(), bVar.f2971d));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(min * m3254a * bVar.f2969b);
                    canvas.drawPath(this.f3010m, paint2);
                }
            }
        }

        /* renamed from: a */
        private static float m3253a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        /* renamed from: a */
        private float m3254a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float m3253a = m3253a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(m3253a) / max;
            }
            return 0.0f;
        }

        /* renamed from: a */
        public boolean m3258a() {
            if (this.f3007j == null) {
                this.f3007j = Boolean.valueOf(this.f3000c.mo3248b());
            }
            return this.f3007j.booleanValue();
        }

        /* renamed from: a */
        public boolean m3259a(int[] iArr) {
            return this.f3000c.mo3247a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$d */
    private static abstract class d {
        private d() {
        }

        /* renamed from: b */
        public boolean mo3248b() {
            return false;
        }

        /* renamed from: a */
        public boolean mo3247a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$c */
    private static class c extends d {

        /* renamed from: a */
        final Matrix f2980a;

        /* renamed from: b */
        final ArrayList<d> f2981b;

        /* renamed from: c */
        float f2982c;

        /* renamed from: d */
        final Matrix f2983d;

        /* renamed from: e */
        int f2984e;

        /* renamed from: f */
        private float f2985f;

        /* renamed from: g */
        private float f2986g;

        /* renamed from: h */
        private float f2987h;

        /* renamed from: i */
        private float f2988i;

        /* renamed from: j */
        private float f2989j;

        /* renamed from: k */
        private float f2990k;

        /* renamed from: l */
        private int[] f2991l;

        /* renamed from: m */
        private String f2992m;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v8, types: [androidx.g.a.a.i$b] */
        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.a.a, androidx.a.a<java.lang.String, java.lang.Object>] */
        public c(c cVar, C0036a<String, Object> c0036a) {
            super();
            a aVar;
            this.f2980a = new Matrix();
            this.f2981b = new ArrayList<>();
            this.f2982c = 0.0f;
            this.f2985f = 0.0f;
            this.f2986g = 0.0f;
            this.f2987h = 1.0f;
            this.f2988i = 1.0f;
            this.f2989j = 0.0f;
            this.f2990k = 0.0f;
            this.f2983d = new Matrix();
            this.f2992m = null;
            this.f2982c = cVar.f2982c;
            this.f2985f = cVar.f2985f;
            this.f2986g = cVar.f2986g;
            this.f2987h = cVar.f2987h;
            this.f2988i = cVar.f2988i;
            this.f2989j = cVar.f2989j;
            this.f2990k = cVar.f2990k;
            this.f2991l = cVar.f2991l;
            this.f2992m = cVar.f2992m;
            this.f2984e = cVar.f2984e;
            if (this.f2992m != null) {
                c0036a.put(this.f2992m, this);
            }
            this.f2983d.set(cVar.f2983d);
            ArrayList<d> arrayList = cVar.f2981b;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    d dVar = arrayList.get(i2);
                    if (dVar instanceof c) {
                        this.f2981b.add(new c((c) dVar, c0036a));
                    } else {
                        if (dVar instanceof b) {
                            aVar = new b((b) dVar);
                        } else if (dVar instanceof a) {
                            aVar = new a((a) dVar);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.f2981b.add(aVar);
                        if (aVar.f2994m != null) {
                            c0036a.put(aVar.f2994m, aVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public c() {
            super();
            this.f2980a = new Matrix();
            this.f2981b = new ArrayList<>();
            this.f2982c = 0.0f;
            this.f2985f = 0.0f;
            this.f2986g = 0.0f;
            this.f2987h = 1.0f;
            this.f2988i = 1.0f;
            this.f2989j = 0.0f;
            this.f2990k = 0.0f;
            this.f2983d = new Matrix();
            this.f2992m = null;
        }

        public String getGroupName() {
            return this.f2992m;
        }

        public Matrix getLocalMatrix() {
            return this.f2983d;
        }

        /* renamed from: a */
        public void m3251a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2929b);
            m3250a(m1928a, xmlPullParser);
            m1928a.recycle();
        }

        /* renamed from: a */
        private void m3250a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2991l = null;
            this.f2982c = C0262g.m1924a(typedArray, xmlPullParser, "rotation", 5, this.f2982c);
            this.f2985f = typedArray.getFloat(1, this.f2985f);
            this.f2986g = typedArray.getFloat(2, this.f2986g);
            this.f2987h = C0262g.m1924a(typedArray, xmlPullParser, "scaleX", 3, this.f2987h);
            this.f2988i = C0262g.m1924a(typedArray, xmlPullParser, "scaleY", 4, this.f2988i);
            this.f2989j = C0262g.m1924a(typedArray, xmlPullParser, "translateX", 6, this.f2989j);
            this.f2990k = C0262g.m1924a(typedArray, xmlPullParser, "translateY", 7, this.f2990k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2992m = string;
            }
            m3249a();
        }

        /* renamed from: a */
        private void m3249a() {
            this.f2983d.reset();
            this.f2983d.postTranslate(-this.f2985f, -this.f2986g);
            this.f2983d.postScale(this.f2987h, this.f2988i);
            this.f2983d.postRotate(this.f2982c, 0.0f, 0.0f);
            this.f2983d.postTranslate(this.f2989j + this.f2985f, this.f2990k + this.f2986g);
        }

        public float getRotation() {
            return this.f2982c;
        }

        public void setRotation(float f2) {
            if (f2 != this.f2982c) {
                this.f2982c = f2;
                m3249a();
            }
        }

        public float getPivotX() {
            return this.f2985f;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2985f) {
                this.f2985f = f2;
                m3249a();
            }
        }

        public float getPivotY() {
            return this.f2986g;
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2986g) {
                this.f2986g = f2;
                m3249a();
            }
        }

        public float getScaleX() {
            return this.f2987h;
        }

        public void setScaleX(float f2) {
            if (f2 != this.f2987h) {
                this.f2987h = f2;
                m3249a();
            }
        }

        public float getScaleY() {
            return this.f2988i;
        }

        public void setScaleY(float f2) {
            if (f2 != this.f2988i) {
                this.f2988i = f2;
                m3249a();
            }
        }

        public float getTranslateX() {
            return this.f2989j;
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f2989j) {
                this.f2989j = f2;
                m3249a();
            }
        }

        public float getTranslateY() {
            return this.f2990k;
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f2990k) {
                this.f2990k = f2;
                m3249a();
            }
        }

        @Override // androidx.p041g.p042a.p043a.C0404i.d
        /* renamed from: b */
        public boolean mo3248b() {
            for (int i = 0; i < this.f2981b.size(); i++) {
                if (this.f2981b.get(i).mo3248b()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.p041g.p042a.p043a.C0404i.d
        /* renamed from: a */
        public boolean mo3247a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f2981b.size(); i++) {
                z |= this.f2981b.get(i).mo3247a(iArr);
            }
            return z;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$e */
    private static abstract class e extends d {

        /* renamed from: l */
        protected C0313c.b[] f2993l;

        /* renamed from: m */
        String f2994m;

        /* renamed from: n */
        int f2995n;

        /* renamed from: o */
        int f2996o;

        public e() {
            super();
            this.f2993l = null;
            this.f2995n = 0;
        }

        public e(e eVar) {
            super();
            this.f2993l = null;
            this.f2995n = 0;
            this.f2994m = eVar.f2994m;
            this.f2996o = eVar.f2996o;
            this.f2993l = C0313c.m2322a(eVar.f2993l);
        }

        /* renamed from: a */
        public void m3252a(Path path) {
            path.reset();
            if (this.f2993l != null) {
                C0313c.b.m2329a(this.f2993l, path);
            }
        }

        public String getPathName() {
            return this.f2994m;
        }

        /* renamed from: a */
        public boolean mo3242a() {
            return false;
        }

        public C0313c.b[] getPathData() {
            return this.f2993l;
        }

        public void setPathData(C0313c.b[] bVarArr) {
            if (!C0313c.m2320a(this.f2993l, bVarArr)) {
                this.f2993l = C0313c.m2322a(bVarArr);
            } else {
                C0313c.m2323b(this.f2993l, bVarArr);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$a */
    private static class a extends e {
        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public void m3241a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (C0262g.m1932a(xmlPullParser, "pathData")) {
                TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2931d);
                m3240a(m1928a, xmlPullParser);
                m1928a.recycle();
            }
        }

        /* renamed from: a */
        private void m3240a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2994m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2993l = C0313c.m2324b(string2);
            }
            this.f2995n = C0262g.m1925a(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.p041g.p042a.p043a.C0404i.e
        /* renamed from: a */
        public boolean mo3242a() {
            return true;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.g.a.a.i$b */
    private static class b extends e {

        /* renamed from: a */
        C0257b f2968a;

        /* renamed from: b */
        float f2969b;

        /* renamed from: c */
        C0257b f2970c;

        /* renamed from: d */
        float f2971d;

        /* renamed from: e */
        float f2972e;

        /* renamed from: f */
        float f2973f;

        /* renamed from: g */
        float f2974g;

        /* renamed from: h */
        float f2975h;

        /* renamed from: i */
        Paint.Cap f2976i;

        /* renamed from: j */
        Paint.Join f2977j;

        /* renamed from: k */
        float f2978k;

        /* renamed from: p */
        private int[] f2979p;

        b() {
            this.f2969b = 0.0f;
            this.f2971d = 1.0f;
            this.f2972e = 1.0f;
            this.f2973f = 0.0f;
            this.f2974g = 1.0f;
            this.f2975h = 0.0f;
            this.f2976i = Paint.Cap.BUTT;
            this.f2977j = Paint.Join.MITER;
            this.f2978k = 4.0f;
        }

        b(b bVar) {
            super(bVar);
            this.f2969b = 0.0f;
            this.f2971d = 1.0f;
            this.f2972e = 1.0f;
            this.f2973f = 0.0f;
            this.f2974g = 1.0f;
            this.f2975h = 0.0f;
            this.f2976i = Paint.Cap.BUTT;
            this.f2977j = Paint.Join.MITER;
            this.f2978k = 4.0f;
            this.f2979p = bVar.f2979p;
            this.f2968a = bVar.f2968a;
            this.f2969b = bVar.f2969b;
            this.f2971d = bVar.f2971d;
            this.f2970c = bVar.f2970c;
            this.f2995n = bVar.f2995n;
            this.f2972e = bVar.f2972e;
            this.f2973f = bVar.f2973f;
            this.f2974g = bVar.f2974g;
            this.f2975h = bVar.f2975h;
            this.f2976i = bVar.f2976i;
            this.f2977j = bVar.f2977j;
            this.f2978k = bVar.f2978k;
        }

        /* renamed from: a */
        private Paint.Cap m3243a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* renamed from: a */
        private Paint.Join m3244a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* renamed from: a */
        public void m3246a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2930c);
            m3245a(m1928a, xmlPullParser, theme);
            m1928a.recycle();
        }

        /* renamed from: a */
        private void m3245a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2979p = null;
            if (C0262g.m1932a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2994m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2993l = C0313c.m2324b(string2);
                }
                this.f2970c = C0262g.m1929a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2972e = C0262g.m1924a(typedArray, xmlPullParser, "fillAlpha", 12, this.f2972e);
                this.f2976i = m3243a(C0262g.m1925a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2976i);
                this.f2977j = m3244a(C0262g.m1925a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2977j);
                this.f2978k = C0262g.m1924a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2978k);
                this.f2968a = C0262g.m1929a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2971d = C0262g.m1924a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2971d);
                this.f2969b = C0262g.m1924a(typedArray, xmlPullParser, "strokeWidth", 4, this.f2969b);
                this.f2974g = C0262g.m1924a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2974g);
                this.f2975h = C0262g.m1924a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2975h);
                this.f2973f = C0262g.m1924a(typedArray, xmlPullParser, "trimPathStart", 5, this.f2973f);
                this.f2995n = C0262g.m1925a(typedArray, xmlPullParser, "fillType", 13, this.f2995n);
            }
        }

        @Override // androidx.p041g.p042a.p043a.C0404i.d
        /* renamed from: b */
        public boolean mo3248b() {
            return this.f2970c.m1877d() || this.f2968a.m1877d();
        }

        @Override // androidx.p041g.p042a.p043a.C0404i.d
        /* renamed from: a */
        public boolean mo3247a(int[] iArr) {
            return this.f2970c.m1873a(iArr) | this.f2968a.m1873a(iArr);
        }

        int getStrokeColor() {
            return this.f2968a.m1874b();
        }

        void setStrokeColor(int i) {
            this.f2968a.m1875b(i);
        }

        float getStrokeWidth() {
            return this.f2969b;
        }

        void setStrokeWidth(float f2) {
            this.f2969b = f2;
        }

        float getStrokeAlpha() {
            return this.f2971d;
        }

        void setStrokeAlpha(float f2) {
            this.f2971d = f2;
        }

        int getFillColor() {
            return this.f2970c.m1874b();
        }

        void setFillColor(int i) {
            this.f2970c.m1875b(i);
        }

        float getFillAlpha() {
            return this.f2972e;
        }

        void setFillAlpha(float f2) {
            this.f2972e = f2;
        }

        float getTrimPathStart() {
            return this.f2973f;
        }

        void setTrimPathStart(float f2) {
            this.f2973f = f2;
        }

        float getTrimPathEnd() {
            return this.f2974g;
        }

        void setTrimPathEnd(float f2) {
            this.f2974g = f2;
        }

        float getTrimPathOffset() {
            return this.f2975h;
        }

        void setTrimPathOffset(float f2) {
            this.f2975h = f2;
        }
    }
}
