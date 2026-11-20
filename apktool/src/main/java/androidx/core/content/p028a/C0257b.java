package androidx.core.content.p028a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: ComplexColorCompat.java */
/* renamed from: androidx.core.content.a.b */
/* loaded from: classes.dex */
public final class C0257b {

    /* renamed from: a */
    private final Shader f2018a;

    /* renamed from: b */
    private final ColorStateList f2019b;

    /* renamed from: c */
    private int f2020c;

    private C0257b(Shader shader, ColorStateList colorStateList, int i) {
        this.f2018a = shader;
        this.f2019b = colorStateList;
        this.f2020c = i;
    }

    /* renamed from: a */
    static C0257b m1870a(Shader shader) {
        return new C0257b(shader, null, 0);
    }

    /* renamed from: a */
    static C0257b m1868a(ColorStateList colorStateList) {
        return new C0257b(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: a */
    static C0257b m1867a(int i) {
        return new C0257b(null, null, i);
    }

    /* renamed from: a */
    public Shader m1872a() {
        return this.f2018a;
    }

    /* renamed from: b */
    public int m1874b() {
        return this.f2020c;
    }

    /* renamed from: b */
    public void m1875b(int i) {
        this.f2020c = i;
    }

    /* renamed from: c */
    public boolean m1876c() {
        return this.f2018a != null;
    }

    /* renamed from: d */
    public boolean m1877d() {
        return this.f2018a == null && this.f2019b != null && this.f2019b.isStateful();
    }

    /* renamed from: a */
    public boolean m1873a(int[] iArr) {
        int colorForState;
        if (!m1877d() || (colorForState = this.f2019b.getColorForState(iArr, this.f2019b.getDefaultColor())) == this.f2020c) {
            return false;
        }
        this.f2020c = colorForState;
        return true;
    }

    /* renamed from: e */
    public boolean m1878e() {
        return m1876c() || this.f2020c != 0;
    }

    /* renamed from: a */
    public static C0257b m1869a(Resources resources, int i, Resources.Theme theme) {
        try {
            return m1871b(resources, i, theme);
        } catch (Exception e2) {
            Log.m185e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    /* renamed from: b */
    private static C0257b m1871b(Resources resources, int i, Resources.Theme theme) {
        int next;
        String name;
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
        name = xml.getName();
        switch (name) {
            case "selector":
                return m1868a(C0256a.m1860a(resources, xml, asAttributeSet, theme));
            case "gradient":
                return m1870a(C0259d.m1902a(resources, xml, asAttributeSet, theme));
            default:
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
    }
}
