package p046b.p047a.p050c.p053b;

import android.content.res.XmlResourceParser;
import android.util.C0035a;
import com.srizwan.apktool.R;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import org.p217b.p218a.p219a.p220a.C1880a;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;
import p046b.p047a.p050c.p051a.C0468a;
import p046b.p047a.p050c.p051a.C0491b;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p051a.C0496g;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p047a.p050c.p051a.p052a.C0470b;
import p046b.p047a.p050c.p051a.p052a.C0472d;
import p046b.p047a.p050c.p051a.p052a.C0483o;
import p046b.p047a.p050c.p051a.p052a.C0489u;
import p046b.p047a.p050c.p055d.C0516b;
import p046b.p059d.C0538c;
import p046b.p059d.C0539d;
import p046b.p059d.InterfaceC0541f;

/* compiled from: AXmlResourceParser.java */
/* renamed from: b.a.c.b.b */
/* loaded from: classes.dex */
public class XmlResourceParserC0502b implements XmlResourceParser {

    /* renamed from: a */
    private C0539d f3506a;

    /* renamed from: b */
    private C1880a f3507b;

    /* renamed from: c */
    private C0505e f3508c;

    /* renamed from: d */
    private C0461b f3509d;

    /* renamed from: g */
    private C0510j f3512g;

    /* renamed from: h */
    private int[] f3513h;

    /* renamed from: l */
    private boolean f3517l;

    /* renamed from: m */
    private int f3518m;

    /* renamed from: n */
    private int f3519n;

    /* renamed from: o */
    private int f3520o;

    /* renamed from: p */
    private int f3521p;

    /* renamed from: q */
    private int[] f3522q;

    /* renamed from: r */
    private int f3523r;

    /* renamed from: s */
    private int f3524s;

    /* renamed from: t */
    private int f3525t;

    /* renamed from: u */
    private short f3526u;

    /* renamed from: v */
    private int f3527v;

    /* renamed from: w */
    private final InterfaceC0541f f3528w;

    /* renamed from: f */
    private boolean f3511f = false;

    /* renamed from: i */
    private a f3514i = new a();

    /* renamed from: j */
    private String f3515j = "http://schemas.android.com/apk/res/android";

    /* renamed from: k */
    private String f3516k = "http://schemas.android.com/apk/res-auto";

    /* renamed from: e */
    private Map<String, Integer> f3510e = new LinkedHashMap();

    public XmlResourceParserC0502b(InterfaceC0541f interfaceC0541f) {
        this.f3528w = interfaceC0541f;
        m3794c();
    }

    /* renamed from: a */
    public C0461b m3798a() {
        return this.f3509d;
    }

    /* renamed from: b */
    public C0505e m3801b() {
        return this.f3508c;
    }

    /* renamed from: a */
    public void m3799a(C0505e c0505e) {
        this.f3508c = c0505e;
    }

    /* renamed from: a */
    public void m3800a(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.f3507b = new C1880a(inputStream);
            this.f3506a = new C0539d(this.f3507b);
        }
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public void close() {
        if (this.f3511f) {
            this.f3511f = false;
            this.f3507b = (C1880a) null;
            this.f3506a = (C0539d) null;
            this.f3512g = (C0510j) null;
            this.f3513h = (int[]) null;
            this.f3514i.m3806a();
            m3794c();
        }
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int next() {
        if (this.f3506a == null) {
            throw new XmlPullParserException("Parser is not opened.", this, (Throwable) null);
        }
        try {
            m3796d();
            return this.f3518m;
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int nextToken() {
        return next();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int nextTag() {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next != 2 && next != 3) {
            throw new XmlPullParserException("Expected start or end tag.", this, (Throwable) null);
        }
        return next;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String nextText() {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, (Throwable) null);
        }
        int next = next();
        if (next == 4) {
            String text = getText();
            if (next() != 3) {
                throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, (Throwable) null);
            }
            return text;
        }
        if (next == 3) {
            return "";
        }
        throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, (Throwable) null);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void require(int i, String str, String str2) {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(new StringBuffer().append(XmlPullParser.TYPES[i]).append(" is expected.").toString(), this, (Throwable) null);
        }
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getDepth() {
        return this.f3514i.m3812d() - 1;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getEventType() {
        return this.f3518m;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getLineNumber() {
        return this.f3519n;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getName() {
        return (this.f3520o == -1 || !(this.f3518m == 2 || this.f3518m == 3)) ? (String) null : this.f3512g.m3849a(this.f3520o);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getText() {
        return (this.f3520o == -1 || this.f3518m != 4) ? (String) null : this.f3512g.m3849a(this.f3520o);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return (char[]) null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespace() {
        return this.f3512g.m3849a(this.f3521p);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getPrefix() {
        return this.f3512g.m3849a(this.f3514i.m3813d(this.f3521p));
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getPositionDescription() {
        return new StringBuffer().append("XML line #").append(getLineNumber()).toString();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getNamespaceCount(int i) {
        return this.f3514i.m3805a(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.f3512g.m3849a(this.f3514i.m3809b(i));
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.f3512g.m3849a(this.f3514i.m3810c(i));
    }

    @Override // android.util.AttributeSet
    public String getClassAttribute() {
        if (this.f3524s == -1) {
            return (String) null;
        }
        return this.f3512g.m3849a(this.f3522q[m3795d(this.f3524s) + 2]);
    }

    @Override // android.util.AttributeSet
    public String getIdAttribute() {
        if (this.f3523r == -1) {
            return (String) null;
        }
        return this.f3512g.m3849a(this.f3522q[m3795d(this.f3523r) + 2]);
    }

    @Override // android.util.AttributeSet
    public int getIdAttributeResourceValue(int i) {
        if (this.f3523r != -1) {
            int m3795d = m3795d(this.f3523r);
            return this.f3522q[m3795d + 3] == 1 ? this.f3522q[m3795d + 4] : i;
        }
        return i;
    }

    @Override // android.util.AttributeSet
    public int getStyleAttribute() {
        if (this.f3525t == -1) {
            return 0;
        }
        return this.f3522q[m3795d(this.f3525t) + 4];
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public int getAttributeCount() {
        if (this.f3518m != 2) {
            return -1;
        }
        return this.f3522q.length / this.f3527v;
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeNamespace(int i) {
        int m3795d = m3795d(i);
        int i2 = this.f3522q[m3795d + 0];
        C0491b c0491b = new C0491b(getAttributeNameResource(i));
        if (i2 == -1) {
            if (c0491b.f3413a == 127) {
                return this.f3516k;
            }
            if (c0491b.f3413a == 1) {
                return this.f3515j;
            }
            return "";
        }
        String m3849a = this.f3512g.m3849a(i2);
        if (m3849a == null || m3849a.isEmpty()) {
            if (c0491b.f3413a == 127) {
                return m3792b(m3795d);
            }
            return this.f3515j;
        }
        return m3849a;
    }

    /* renamed from: b */
    private String m3792b(int i) {
        return this.f3512g.m3849a(this.f3514i.m3809b(i)) != null ? this.f3512g.m3849a(this.f3514i.m3810c(i)) : this.f3516k;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getAttributePrefix(int i) {
        int m3813d = this.f3514i.m3813d(this.f3522q[m3795d(i) + 0]);
        return m3813d == -1 ? "" : this.f3512g.m3849a(m3813d);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeName(int i) {
        String stringBuffer;
        String stringBuffer2;
        boolean z;
        int m3795d = m3795d(i);
        int i2 = this.f3522q[m3795d + 1];
        if (i2 == -1) {
            return "";
        }
        String m3849a = this.f3512g.m3849a(i2);
        if (m3849a.length() == 0) {
            try {
                m3849a = this.f3508c.m3826a(getAttributeNameResource(i));
            } catch (C0461b e2) {
                return "";
            }
        }
        try {
            int m3702a = this.f3508c.m3825a().m3702a();
            C0491b c0491b = new C0491b(getAttributeNameResource(i));
            C0492c m3829b = this.f3508c.m3829b();
            C0497h m3670b = m3829b.m3670b(C0497h.f3457a);
            C0496g m3661a = m3829b.m3661a(new C0468a(this.f3528w));
            int i3 = this.f3522q[m3795d + 3];
            int m3793c = m3793c(i3);
            if ((m3702a == 1 || m3702a == 3) && c0491b.f3416d > 0 && c0491b.f3413a > 1 && c0491b.f3413a != 127) {
                C0495f m3825a = this.f3508c.m3825a();
                if (m3829b.m3667a(c0491b)) {
                    stringBuffer = m3829b.m3669b(c0491b).m3693e();
                } else if (m3825a.m3716c(c0491b.f3413a)) {
                    C0492c m3709b = m3825a.m3709b(c0491b.f3413a);
                    if (m3709b.m3667a(c0491b)) {
                        C0493d m3669b = m3709b.m3669b(c0491b);
                        if (!m3669b.m3696h() || m3709b.m3666a()) {
                            stringBuffer2 = m3669b.m3693e();
                        } else {
                            stringBuffer2 = new StringBuffer().append(m3849a).append(new StringBuffer().append("_").append(c0491b.toString().substring(2)).toString()).toString();
                        }
                    } else {
                        stringBuffer2 = new StringBuffer().append(m3849a).append(new StringBuffer().append("_").append(c0491b.toString().substring(2)).toString()).toString();
                    }
                    stringBuffer = stringBuffer2;
                } else {
                    stringBuffer = new StringBuffer().append(m3849a).append(new StringBuffer().append("_").append(c0491b.toString().substring(2)).toString()).toString();
                }
            } else {
                stringBuffer = m3849a;
            }
            try {
                if (m3829b.m3667a(c0491b)) {
                    Integer num = this.f3510e.get(stringBuffer);
                    C0493d m3669b2 = m3829b.m3669b(c0491b);
                    C0489u m3701d = m3661a.m3736a(m3669b2).m3701d();
                    if (!m3669b2.m3696h() || m3829b.m3666a()) {
                        stringBuffer = m3669b2.m3693e();
                    }
                    if (m3829b.m3666a() && (m3701d instanceof C0472d)) {
                        m3829b.m3663a(m3669b2);
                        m3670b.m3741a(m3669b2);
                        z = true;
                        m3849a = stringBuffer;
                    } else if (num == null) {
                        m3669b2.m3688a(stringBuffer);
                        z = false;
                        m3849a = stringBuffer;
                    } else if (num.intValue() == c0491b.f3416d) {
                        int m3630b = m3793c | ((C0470b) m3701d).m3630b();
                        m3829b.m3663a(m3669b2);
                        m3670b.m3741a(m3669b2);
                        z = true;
                        m3793c = m3630b;
                        m3849a = stringBuffer;
                    } else {
                        z = false;
                        m3849a = stringBuffer;
                    }
                } else {
                    z = true;
                    m3849a = stringBuffer;
                }
                if (z && m3829b.m3678g() > 1 && m3829b.m3678g() == c0491b.f3413a) {
                    C0493d c0493d = new C0493d(c0491b, m3849a, 2, m3829b, C0501a.m3758a(), m3670b, m3702a, this.f3528w);
                    m3829b.m3672b(c0493d);
                    m3670b.m3743b(c0493d);
                    C0494e c0494e = new C0494e(m3661a, c0493d, m3829b.m3680i().m3656a(0, new C0538c[]{new C0538c<>(new Integer(16777216), new C0483o(m3793c, (String) null, i3))}, m3670b));
                    m3661a.m3737a(c0494e);
                    c0493d.m3686a(c0494e);
                    this.f3510e.put(m3849a, new Integer(c0491b.f3416d));
                    return m3849a;
                }
                return m3849a;
            } catch (C0460e e3) {
                return stringBuffer;
            } catch (C0461b e4) {
                return stringBuffer;
            } catch (Exception e5) {
                return stringBuffer;
            }
        } catch (C0460e e6) {
            return m3849a;
        } catch (C0461b e7) {
            return m3849a;
        } catch (Exception e8) {
            return m3849a;
        }
    }

    /* renamed from: c */
    private int m3793c(int i) {
        switch (i) {
            case 1:
                return 1;
            case 3:
                return 2;
            case 4:
                return 32;
            case 5:
                return 64;
            case 6:
                return 128;
            case 16:
            case 17:
                return 4;
            case 18:
                return 8;
            case 28:
            case 29:
            case 30:
            case 31:
                return 16;
            default:
                return i;
        }
    }

    @Override // android.util.AttributeSet
    public int getAttributeNameResource(int i) {
        int i2 = this.f3522q[m3795d(i) + 1];
        if (this.f3513h == null || i2 < 0 || i2 >= this.f3513h.length) {
            return 0;
        }
        return this.f3513h[i2];
    }

    /* renamed from: a */
    public int m3797a(int i) {
        return this.f3522q[m3795d(i) + 3];
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(int i) {
        int m3795d = m3795d(i);
        int i2 = this.f3522q[m3795d + 3];
        int i3 = this.f3522q[m3795d + 4];
        int i4 = this.f3522q[m3795d + 2];
        if (this.f3508c != null) {
            try {
                return this.f3508c.m3827a(i2, i3, i4 == -1 ? (String) null : C0516b.m3870a(this.f3512g.m3849a(i4)), getAttributeNameResource(i));
            } catch (C0461b e2) {
                m3791a(e2);
                this.f3528w.mo3980a(Level.WARNING, String.format(new StringBuffer().append("Could not decode attr value, using undecoded value ").append("instead: ns=%s, name=%s, value=0x%08x").toString(), getAttributePrefix(i), getAttributeName(i), new Integer(i3)), e2);
            }
        }
        return C0035a.m199b(i2, i3);
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(int i, float f2) {
        int m3795d = m3795d(i);
        if (this.f3522q[m3795d + 3] == 4) {
            return Float.intBitsToFloat(this.f3522q[m3795d + 4]);
        }
        return f2;
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(int i, int i2) {
        int m3795d = m3795d(i);
        int i3 = this.f3522q[m3795d + 3];
        if (i3 >= 16 && i3 <= 31) {
            return this.f3522q[m3795d + 4];
        }
        return i2;
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(int i, int i2) {
        int m3795d = m3795d(i);
        if (this.f3522q[m3795d + 3] == 1) {
            return this.f3522q[m3795d + 4];
        }
        return i2;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(String str, String str2) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? "" : getAttributeValue(m3790a);
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? z : getAttributeBooleanValue(m3790a, z);
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(String str, String str2, float f2) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? f2 : getAttributeFloatValue(m3790a, f2);
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(String str, String str2, int i) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? i : getAttributeIntValue(m3790a, i);
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? i : getAttributeUnsignedIntValue(m3790a, i);
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(String str, String str2, int i) {
        int m3790a = m3790a(str, str2);
        return m3790a == -1 ? i : getAttributeResourceValue(m3790a, i);
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        m3800a(inputStream);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setInput(Reader reader) {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getInputEncoding() {
        return (String) null;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return false;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isWhitespace() {
        return false;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespace(String str) {
        throw new RuntimeException("Method is not supported.");
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public Object getProperty(String str) {
        return (Object) null;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean getFeature(String str) {
        return false;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        throw new XmlPullParserException("Method is not supported.");
    }

    /* compiled from: AXmlResourceParser.java */
    /* renamed from: b.a.c.b.b$a */
    private static final class a {

        /* renamed from: a */
        private int[] f3529a = new int[32];

        /* renamed from: b */
        private int f3530b;

        /* renamed from: c */
        private int f3531c;

        /* renamed from: d */
        private int f3532d;

        /* renamed from: a */
        public final void m3806a() {
            this.f3530b = 0;
            this.f3531c = 0;
            this.f3532d = 0;
        }

        /* renamed from: b */
        public final int m3808b() {
            if (this.f3530b == 0) {
                return 0;
            }
            return this.f3529a[this.f3530b - 1];
        }

        /* renamed from: a */
        public final int m3805a(int i) {
            if (this.f3530b == 0 || i < 0) {
                return 0;
            }
            if (i > this.f3532d) {
                i = this.f3532d;
            }
            int i2 = 0;
            int i3 = 0;
            while (i != 0) {
                int i4 = this.f3529a[i2];
                i3 += i4;
                i--;
                i2 = (i4 * 2) + 2 + i2;
            }
            return i3;
        }

        /* renamed from: a */
        public final void m3807a(int i, int i2) {
            if (this.f3532d == 0) {
                m3814e();
            }
            m3804e(2);
            int i3 = this.f3530b - 1;
            int i4 = this.f3529a[i3];
            this.f3529a[(i3 - 1) - (i4 * 2)] = i4 + 1;
            this.f3529a[i3] = i;
            this.f3529a[i3 + 1] = i2;
            this.f3529a[i3 + 2] = i4 + 1;
            this.f3530b += 2;
            this.f3531c++;
        }

        /* renamed from: c */
        public final boolean m3811c() {
            int i;
            int i2;
            if (this.f3530b == 0 || (i2 = this.f3529a[this.f3530b - 1]) == 0) {
                return false;
            }
            int i3 = i2 - 1;
            int i4 = i - 2;
            this.f3529a[i4] = i3;
            this.f3529a[i4 - ((i3 * 2) + 1)] = i3;
            this.f3530b -= 2;
            this.f3531c--;
            return true;
        }

        /* renamed from: b */
        public final int m3809b(int i) {
            return m3803b(i, true);
        }

        /* renamed from: c */
        public final int m3810c(int i) {
            return m3803b(i, false);
        }

        /* renamed from: d */
        public final int m3813d(int i) {
            return m3802a(i, false);
        }

        /* renamed from: d */
        public final int m3812d() {
            return this.f3532d;
        }

        /* renamed from: e */
        public final void m3814e() {
            m3804e(2);
            int i = this.f3530b;
            this.f3529a[i] = 0;
            this.f3529a[i + 1] = 0;
            this.f3530b += 2;
            this.f3532d++;
        }

        /* renamed from: f */
        public final void m3815f() {
            if (this.f3530b != 0) {
                int i = this.f3530b - 1;
                int i2 = this.f3529a[i];
                if ((i - 1) - (i2 * 2) != 0) {
                    this.f3530b -= (i2 * 2) + 2;
                    this.f3531c -= i2;
                    this.f3532d--;
                }
            }
        }

        /* renamed from: e */
        private void m3804e(int i) {
            int length = this.f3529a.length - this.f3530b;
            if (length <= i) {
                int[] iArr = new int[(length + this.f3529a.length) * 2];
                System.arraycopy(this.f3529a, 0, iArr, 0, this.f3530b);
                this.f3529a = iArr;
            }
        }

        /* renamed from: a */
        private final int m3802a(int i, boolean z) {
            if (this.f3530b == 0) {
                return -1;
            }
            int i2 = this.f3530b - 1;
            for (int i3 = this.f3532d; i3 != 0; i3--) {
                i2 -= 2;
                for (int i4 = this.f3529a[i2]; i4 != 0; i4--) {
                    if (z) {
                        if (this.f3529a[i2] == i) {
                            return this.f3529a[i2 + 1];
                        }
                    } else if (this.f3529a[i2 + 1] == i) {
                        return this.f3529a[i2];
                    }
                    i2 -= 2;
                }
            }
            return -1;
        }

        /* renamed from: b */
        private final int m3803b(int i, boolean z) {
            if (this.f3530b == 0 || i < 0) {
                return -1;
            }
            int i2 = 0;
            for (int i3 = this.f3532d; i3 != 0; i3--) {
                int i4 = this.f3529a[i2];
                if (i >= i4) {
                    i -= i4;
                    i2 += (i4 * 2) + 2;
                } else {
                    int i5 = (i * 2) + 1 + i2;
                    if (!z) {
                        i5++;
                    }
                    return this.f3529a[i5];
                }
            }
            return -1;
        }
    }

    /* renamed from: d */
    private final int m3795d(int i) {
        if (this.f3518m != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = this.f3527v * i;
        if (i2 >= this.f3522q.length) {
            throw new IndexOutOfBoundsException(new StringBuffer().append(new StringBuffer().append("Invalid attribute index (").append(i).toString()).append(").").toString());
        }
        return i2;
    }

    /* renamed from: a */
    private final int m3790a(String str, String str2) {
        int m3848a;
        if (this.f3512g == null || str2 == null || (m3848a = this.f3512g.m3848a(str2)) == -1) {
            return -1;
        }
        int m3848a2 = str != null ? this.f3512g.m3848a(str) : -1;
        int i = 0;
        while (i != this.f3522q.length) {
            if (m3848a != this.f3522q[i + 1] || (m3848a2 != -1 && m3848a2 != this.f3522q[i + 0])) {
                i += this.f3527v;
            } else {
                return i / this.f3527v;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private final void m3794c() {
        this.f3518m = -1;
        this.f3519n = -1;
        this.f3520o = -1;
        this.f3521p = -1;
        this.f3522q = (int[]) null;
        this.f3523r = -1;
        this.f3524s = -1;
        this.f3525t = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x010a, code lost:
    
        throw new java.io.IOException(new java.lang.StringBuffer().append(new java.lang.StringBuffer().append("Invalid chunk type (").append(r1).toString()).append(").").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c2, code lost:
    
        throw new java.io.IOException(new java.lang.StringBuffer().append(new java.lang.StringBuffer().append("Invalid resource ids size (").append(r1).toString()).append(").").toString());
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m3796d() {
        int i = 3;
        if (this.f3512g == null) {
            this.f3506a.m3977c(524291);
            this.f3506a.m3975b();
            this.f3512g = C0510j.m3841a(this.f3506a, true, this.f3528w);
            this.f3514i.m3814e();
            this.f3511f = true;
        }
        if (this.f3518m != 1) {
            int i2 = this.f3518m;
            m3794c();
            while (true) {
                if (this.f3517l) {
                    this.f3517l = false;
                    this.f3514i.m3815f();
                }
                if (i2 == 3 && this.f3514i.m3812d() == 1 && this.f3514i.m3808b() == 0) {
                    this.f3518m = 1;
                    return;
                }
                if (this.f3507b.available() == 0) {
                    this.f3528w.mo3983c(R.string.text, String.format("AXML hit unexpected end of file at byte: 0x%X", new Integer(this.f3507b.m13937a())));
                    this.f3518m = 1;
                    return;
                }
                int readInt = i2 == 0 ? 1048834 : this.f3506a.readInt();
                if (readInt == 524672) {
                    int readInt2 = this.f3506a.readInt();
                    if (readInt2 < 8 || readInt2 % 4 != 0) {
                        break;
                    } else {
                        this.f3513h = this.f3506a.m3976b((readInt2 / 4) - 2);
                    }
                } else {
                    if (readInt < 1048832 || readInt > 1048836) {
                        break;
                    }
                    if (readInt == 1048834 && i2 == -1) {
                        this.f3518m = 0;
                        return;
                    }
                    this.f3506a.m3975b();
                    int readInt3 = this.f3506a.readInt();
                    this.f3506a.m3975b();
                    if (readInt == 1048832 || readInt == 1048833) {
                        if (readInt == 1048832) {
                            this.f3514i.m3807a(this.f3506a.readInt(), this.f3506a.readInt());
                        } else {
                            this.f3506a.m3975b();
                            this.f3506a.m3975b();
                            this.f3514i.m3811c();
                        }
                    } else {
                        this.f3519n = readInt3;
                        if (readInt == 1048834) {
                            this.f3521p = this.f3506a.readInt();
                            this.f3520o = this.f3506a.readInt();
                            this.f3506a.skipBytes(2);
                            this.f3526u = this.f3506a.readShort();
                            this.f3527v = this.f3526u / 4;
                            int readInt4 = this.f3506a.readInt();
                            this.f3523r = (readInt4 >>> 16) - 1;
                            this.f3524s = this.f3506a.readInt();
                            this.f3525t = (this.f3524s >>> 16) - 1;
                            this.f3524s = (this.f3524s & 65535) - 1;
                            this.f3522q = this.f3506a.m3976b((readInt4 & 65535) * this.f3527v);
                            while (i < this.f3522q.length) {
                                this.f3522q[i] = this.f3522q[i] >>> 24;
                                i += this.f3527v;
                            }
                            this.f3514i.m3814e();
                            this.f3518m = 2;
                            return;
                        }
                        if (readInt == 1048835) {
                            this.f3521p = this.f3506a.readInt();
                            this.f3520o = this.f3506a.readInt();
                            this.f3518m = 3;
                            this.f3517l = true;
                            return;
                        }
                        if (readInt == 1048836) {
                            this.f3520o = this.f3506a.readInt();
                            this.f3506a.m3975b();
                            this.f3506a.m3975b();
                            this.f3518m = 4;
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m3791a(C0461b c0461b) {
        if (this.f3509d == null) {
            this.f3509d = c0461b;
        }
    }
}
