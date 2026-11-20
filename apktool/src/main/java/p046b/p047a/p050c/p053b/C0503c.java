package p046b.p047a.p050c.p053b;

import p046b.p059d.InterfaceC0541f;

/* compiled from: ManifestResourceParser.java */
/* renamed from: b.a.c.b.c */
/* loaded from: classes.dex */
public class C0503c extends XmlResourceParserC0502b {

    /* renamed from: a */
    private final String f3533a;

    /* renamed from: b */
    private final String f3534b;

    public C0503c(InterfaceC0541f interfaceC0541f) {
        super(interfaceC0541f);
        this.f3533a = "^\\s?\\d+$";
        this.f3534b = "^\\d+\\s?$";
    }

    @Override // p046b.p047a.p050c.p053b.XmlResourceParserC0502b, org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(int i) {
        String attributeValue = super.getAttributeValue(i);
        if (attributeValue == null) {
            return "";
        }
        if (m3816a(i, attributeValue)) {
            if (attributeValue.matches("^\\s?\\d+$")) {
                return new StringBuffer().append("\\ ").append(attributeValue.trim()).toString();
            }
            return new StringBuffer().append(attributeValue.trim()).append("\\ ").toString();
        }
        return attributeValue;
    }

    /* renamed from: a */
    private boolean m3816a(int i, String str) {
        return "meta-data".equalsIgnoreCase(getName()) && "value".equalsIgnoreCase(getAttributeName(i)) && m3797a(i) == 3 && (str.matches("^\\s?\\d+$") || str.matches("^\\d+\\s?$"));
    }
}
