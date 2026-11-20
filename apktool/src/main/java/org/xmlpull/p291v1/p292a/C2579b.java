package org.xmlpull.p291v1.p292a;

import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserFactory;
import org.xmlpull.p291v1.p292a.p293a.C2575a;

/* compiled from: XmlPullWrapperFactory.java */
/* renamed from: org.xmlpull.v1.a.b */
/* loaded from: classes.dex */
public class C2579b {

    /* renamed from: a */
    protected XmlPullParserFactory f13411a;

    /* renamed from: a */
    public static C2579b m16042a() {
        return new C2579b((XmlPullParserFactory) null);
    }

    protected C2579b(XmlPullParserFactory xmlPullParserFactory) {
        if (xmlPullParserFactory != null) {
            this.f13411a = xmlPullParserFactory;
        } else {
            this.f13411a = XmlPullParserFactory.newInstance();
        }
    }

    /* renamed from: a */
    public InterfaceC2574a m16043a(XmlPullParser xmlPullParser) {
        return new C2575a(xmlPullParser);
    }
}
