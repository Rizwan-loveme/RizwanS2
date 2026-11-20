package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.content.p028a.C0261f;

/* compiled from: TintTypedArray.java */
/* renamed from: androidx.appcompat.widget.az */
/* loaded from: classes.dex */
public class C0184az {

    /* renamed from: a */
    private final Context f1589a;

    /* renamed from: b */
    private final TypedArray f1590b;

    /* renamed from: c */
    private TypedValue f1591c;

    /* renamed from: a */
    public static C0184az m1431a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0184az(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static C0184az m1432a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0184az(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public static C0184az m1430a(Context context, int i, int[] iArr) {
        return new C0184az(context, context.obtainStyledAttributes(i, iArr));
    }

    private C0184az(Context context, TypedArray typedArray) {
        this.f1589a = context;
        this.f1590b = typedArray;
    }

    /* renamed from: a */
    public TypedArray m1435a() {
        return this.f1590b;
    }

    /* renamed from: a */
    public Drawable m1437a(int i) {
        int resourceId;
        return (!this.f1590b.hasValue(i) || (resourceId = this.f1590b.getResourceId(i, 0)) == 0) ? this.f1590b.getDrawable(i) : C0060a.m348b(this.f1589a, resourceId);
    }

    /* renamed from: b */
    public Drawable m1440b(int i) {
        int resourceId;
        if (!this.f1590b.hasValue(i) || (resourceId = this.f1590b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0201k.m1545b().m1548a(this.f1589a, resourceId, true);
    }

    /* renamed from: a */
    public Typeface m1436a(int i, int i2, C0261f.c cVar) {
        int resourceId = this.f1590b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1591c == null) {
            this.f1591c = new TypedValue();
        }
        return C0261f.m1909a(this.f1589a, resourceId, this.f1591c, i2, cVar);
    }

    /* renamed from: c */
    public CharSequence m1443c(int i) {
        return this.f1590b.getText(i);
    }

    /* renamed from: d */
    public String m1445d(int i) {
        return this.f1590b.getString(i);
    }

    /* renamed from: a */
    public boolean m1438a(int i, boolean z) {
        return this.f1590b.getBoolean(i, z);
    }

    /* renamed from: a */
    public int m1434a(int i, int i2) {
        return this.f1590b.getInt(i, i2);
    }

    /* renamed from: a */
    public float m1433a(int i, float f2) {
        return this.f1590b.getFloat(i, f2);
    }

    /* renamed from: b */
    public int m1439b(int i, int i2) {
        return this.f1590b.getColor(i, i2);
    }

    /* renamed from: e */
    public ColorStateList m1447e(int i) {
        int resourceId;
        ColorStateList m345a;
        return (!this.f1590b.hasValue(i) || (resourceId = this.f1590b.getResourceId(i, 0)) == 0 || (m345a = C0060a.m345a(this.f1589a, resourceId)) == null) ? this.f1590b.getColorStateList(i) : m345a;
    }

    /* renamed from: c */
    public int m1442c(int i, int i2) {
        return this.f1590b.getInteger(i, i2);
    }

    /* renamed from: d */
    public int m1444d(int i, int i2) {
        return this.f1590b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: e */
    public int m1446e(int i, int i2) {
        return this.f1590b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: f */
    public int m1448f(int i, int i2) {
        return this.f1590b.getLayoutDimension(i, i2);
    }

    /* renamed from: g */
    public int m1450g(int i, int i2) {
        return this.f1590b.getResourceId(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] m1449f(int i) {
        return this.f1590b.getTextArray(i);
    }

    /* renamed from: g */
    public boolean m1451g(int i) {
        return this.f1590b.hasValue(i);
    }

    /* renamed from: b */
    public void m1441b() {
        this.f1590b.recycle();
    }
}
