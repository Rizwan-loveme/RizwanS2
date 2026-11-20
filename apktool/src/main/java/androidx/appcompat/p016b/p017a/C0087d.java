package androidx.appcompat.p016b.p017a;

import android.C0012R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p016b.p017a.C0085b;
import androidx.appcompat.p018c.C0088a;
import androidx.appcompat.widget.C0174ap;
import androidx.core.content.p028a.C0262g;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.d */
/* loaded from: classes.dex */
class C0087d extends C0085b {

    /* renamed from: a */
    private a f801a;

    /* renamed from: b */
    private boolean f802b;

    C0087d() {
        this(null, null);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int m737b = this.f801a.m737b(iArr);
        if (m737b < 0) {
            m737b = this.f801a.m737b(StateSet.WILD_CARD);
        }
        return m699a(m737b) || onStateChange;
    }

    /* renamed from: b */
    public void mo677b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0088a.b.StateListDrawable);
        setVisible(m1928a.getBoolean(C0088a.b.StateListDrawable_android_visible, true), true);
        m734a(m1928a);
        m697a(resources);
        m1928a.recycle();
        m733a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    /* renamed from: a */
    private void m734a(TypedArray typedArray) {
        a aVar = this.f801a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f779f |= typedArray.getChangingConfigurations();
        }
        aVar.f784k = typedArray.getBoolean(C0088a.b.StateListDrawable_android_variablePadding, aVar.f784k);
        aVar.f787n = typedArray.getBoolean(C0088a.b.StateListDrawable_android_constantSize, aVar.f787n);
        aVar.f767C = typedArray.getInt(C0088a.b.StateListDrawable_android_enterFadeDuration, aVar.f767C);
        aVar.f768D = typedArray.getInt(C0088a.b.StateListDrawable_android_exitFadeDuration, aVar.f768D);
        aVar.f799z = typedArray.getBoolean(C0088a.b.StateListDrawable_android_dither, aVar.f799z);
    }

    /* renamed from: a */
    private void m733a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        a aVar = this.f801a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next2 != 3) {
                    if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0088a.b.StateListDrawableItem);
                        Drawable drawable = null;
                        int resourceId = m1928a.getResourceId(C0088a.b.StateListDrawableItem_android_drawable, -1);
                        if (resourceId > 0) {
                            drawable = C0174ap.m1352a().m1364a(context, resourceId);
                        }
                        m1928a.recycle();
                        int[] m735a = m735a(attributeSet);
                        if (drawable == null) {
                            do {
                                next = xmlPullParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                            }
                            if (Build.VERSION.SDK_INT >= 21) {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                            }
                        }
                        aVar.m736a(m735a, drawable);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    int[] m735a(AttributeSet attributeSet) {
        int i;
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        int i3 = 0;
        while (i2 < attributeCount) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            switch (attributeNameResource) {
                case 0:
                    i = i3;
                    break;
                case C0012R.attr.f40id /* 16842960 */:
                case C0012R.attr.drawable /* 16843161 */:
                    i = i3;
                    break;
                default:
                    int i4 = i3 + 1;
                    if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                        attributeNameResource = -attributeNameResource;
                    }
                    iArr[i3] = attributeNameResource;
                    i = i4;
                    break;
            }
            i2++;
            i3 = i;
        }
        return StateSet.trimStateSet(iArr, i3);
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f802b && super.mutate() == this) {
            this.f801a.mo687a();
            this.f802b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.p016b.p017a.C0085b
    /* renamed from: b */
    public a mo678c() {
        return new a(this.f801a, this, null);
    }

    /* compiled from: StateListDrawable.java */
    /* renamed from: androidx.appcompat.b.a.d$a */
    static class a extends C0085b.c {

        /* renamed from: L */
        int[][] f803L;

        a(a aVar, C0087d c0087d, Resources resources) {
            super(aVar, c0087d, resources);
            if (aVar != null) {
                this.f803L = aVar.f803L;
            } else {
                this.f803L = new int[m715c()][];
            }
        }

        @Override // androidx.appcompat.p016b.p017a.C0085b.c
        /* renamed from: a */
        void mo687a() {
            int[][] iArr = new int[this.f803L.length][];
            for (int length = this.f803L.length - 1; length >= 0; length--) {
                iArr[length] = this.f803L[length] != null ? (int[]) this.f803L[length].clone() : null;
            }
            this.f803L = iArr;
        }

        /* renamed from: a */
        int m736a(int[] iArr, Drawable drawable) {
            int a2 = m708a(drawable);
            this.f803L[a2] = iArr;
            return a2;
        }

        /* renamed from: b */
        int m737b(int[] iArr) {
            int[][] iArr2 = this.f803L;
            int d2 = m717d();
            for (int i = 0; i < d2; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0087d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0087d(this, resources);
        }

        @Override // androidx.appcompat.p016b.p017a.C0085b.c
        /* renamed from: e */
        public void mo721e(int i, int i2) {
            super.mo721e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f803L, 0, iArr, 0, i);
            this.f803L = iArr;
        }
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.p016b.p017a.C0085b
    /* renamed from: a */
    void mo675a(C0085b.c cVar) {
        super.mo675a(cVar);
        if (cVar instanceof a) {
            this.f801a = (a) cVar;
        }
    }

    C0087d(a aVar, Resources resources) {
        mo675a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    C0087d(a aVar) {
        if (aVar != null) {
            mo675a(aVar);
        }
    }
}
