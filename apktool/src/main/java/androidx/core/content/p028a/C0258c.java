package androidx.core.content.p028a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.C0225a;
import androidx.core.p027c.C0249d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* renamed from: androidx.core.content.a.c */
/* loaded from: classes.dex */
public class C0258c {

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.a.c$a */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.a.c$d */
    public static final class d implements a {

        /* renamed from: a */
        private final C0249d f2028a;

        /* renamed from: b */
        private final int f2029b;

        /* renamed from: c */
        private final int f2030c;

        /* renamed from: d */
        private final String f2031d;

        public d(C0249d c0249d, int i, int i2, String str) {
            this.f2028a = c0249d;
            this.f2030c = i;
            this.f2029b = i2;
            this.f2031d = str;
        }

        /* renamed from: a */
        public C0249d m1896a() {
            return this.f2028a;
        }

        /* renamed from: b */
        public int m1897b() {
            return this.f2030c;
        }

        /* renamed from: c */
        public int m1898c() {
            return this.f2029b;
        }

        /* renamed from: d */
        public String m1899d() {
            return this.f2031d;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.a.c$c */
    public static final class c {

        /* renamed from: a */
        private final String f2022a;

        /* renamed from: b */
        private int f2023b;

        /* renamed from: c */
        private boolean f2024c;

        /* renamed from: d */
        private String f2025d;

        /* renamed from: e */
        private int f2026e;

        /* renamed from: f */
        private int f2027f;

        public c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f2022a = str;
            this.f2023b = i;
            this.f2024c = z;
            this.f2025d = str2;
            this.f2026e = i2;
            this.f2027f = i3;
        }

        /* renamed from: a */
        public String m1890a() {
            return this.f2022a;
        }

        /* renamed from: b */
        public int m1891b() {
            return this.f2023b;
        }

        /* renamed from: c */
        public boolean m1892c() {
            return this.f2024c;
        }

        /* renamed from: d */
        public String m1893d() {
            return this.f2025d;
        }

        /* renamed from: e */
        public int m1894e() {
            return this.f2026e;
        }

        /* renamed from: f */
        public int m1895f() {
            return this.f2027f;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.a.c$b */
    public static final class b implements a {

        /* renamed from: a */
        private final c[] f2021a;

        public b(c[] cVarArr) {
            this.f2021a = cVarArr;
        }

        /* renamed from: a */
        public c[] m1889a() {
            return this.f2021a;
        }
    }

    /* renamed from: a */
    public static a m1882a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return m1886b(xmlPullParser, resources);
    }

    /* renamed from: b */
    private static a m1886b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m1887c(xmlPullParser, resources);
        }
        m1885a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    private static a m1887c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0225a.d.FontFamily);
        String string = obtainAttributes.getString(C0225a.d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0225a.d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0225a.d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0225a.d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0225a.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0225a.d.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(C0225a.d.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m1885a(xmlPullParser);
            }
            return new d(new C0249d(string, string2, string3, m1883a(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m1888d(xmlPullParser, resources));
                } else {
                    m1885a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    /* renamed from: a */
    private static int m1881a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /* renamed from: a */
    public static List<List<byte[]>> m1883a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m1881a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m1884a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m1884a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* renamed from: a */
    private static List<byte[]> m1884a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static c m1888d(XmlPullParser xmlPullParser, Resources resources) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0225a.d.FontFamilyFont);
        if (obtainAttributes.hasValue(C0225a.d.FontFamilyFont_fontWeight)) {
            i = C0225a.d.FontFamilyFont_fontWeight;
        } else {
            i = C0225a.d.FontFamilyFont_android_fontWeight;
        }
        int i6 = obtainAttributes.getInt(i, 400);
        if (obtainAttributes.hasValue(C0225a.d.FontFamilyFont_fontStyle)) {
            i2 = C0225a.d.FontFamilyFont_fontStyle;
        } else {
            i2 = C0225a.d.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i2, 0);
        if (obtainAttributes.hasValue(C0225a.d.FontFamilyFont_ttcIndex)) {
            i3 = C0225a.d.FontFamilyFont_ttcIndex;
        } else {
            i3 = C0225a.d.FontFamilyFont_android_ttcIndex;
        }
        if (obtainAttributes.hasValue(C0225a.d.FontFamilyFont_fontVariationSettings)) {
            i4 = C0225a.d.FontFamilyFont_fontVariationSettings;
        } else {
            i4 = C0225a.d.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i4);
        int i7 = obtainAttributes.getInt(i3, 0);
        if (obtainAttributes.hasValue(C0225a.d.FontFamilyFont_font)) {
            i5 = C0225a.d.FontFamilyFont_font;
        } else {
            i5 = C0225a.d.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m1885a(xmlPullParser);
        }
        return new c(string2, i6, z, string, i7, resourceId);
    }

    /* renamed from: a */
    private static void m1885a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
