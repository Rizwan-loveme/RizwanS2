package p046b.p047a.p050c.p053b;

import android.provider.Telephony;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;
import org.xmlpull.p291v1.p292a.C2579b;
import org.xmlpull.p291v1.p292a.InterfaceC2574a;
import org.xmlpull.p291v1.p292a.p293a.C2576b;
import p046b.p047a.C0461b;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p054c.InterfaceC0514b;
import p046b.p059d.InterfaceC0541f;

/* compiled from: XmlPullStreamDecoder.java */
/* renamed from: b.a.c.b.l */
/* loaded from: classes.dex */
public class C0512l implements InterfaceC0508h {

    /* renamed from: a */
    private final XmlPullParser f3569a;

    /* renamed from: b */
    private final InterfaceC0514b f3570b;

    /* renamed from: c */
    private final InterfaceC0541f f3571c;

    public C0512l(XmlPullParser xmlPullParser, InterfaceC0514b interfaceC0514b, InterfaceC0541f interfaceC0541f) {
        this.f3569a = xmlPullParser;
        this.f3570b = interfaceC0514b;
        this.f3571c = interfaceC0541f;
        interfaceC0514b.setProperty("http://xmlpull.org/v1/doc/properties.html#serializer-indentation", "    ");
    }

    @Override // p046b.p047a.p050c.p053b.InterfaceC0508h
    /* renamed from: a */
    public void mo3822a(InputStream inputStream, OutputStream outputStream) {
        this.f3570b.mo3868b(true);
        try {
            try {
                C2579b m16042a = C2579b.m16042a();
                InterfaceC2574a m16043a = m16042a.m16043a(this.f3569a);
                C2576b c2576b = new C2576b(this, this.f3570b, m16042a, ((XmlResourceParserC0502b) this.f3569a).m3801b().m3825a()) { // from class: b.a.c.b.l.1

                    /* renamed from: a */
                    boolean f3572a = false;

                    /* renamed from: b */
                    boolean f3573b = false;

                    /* renamed from: i */
                    private final C0512l f3574i;

                    /* renamed from: j */
                    private final C0495f f3575j;

                    {
                        this.f3574i = this;
                        this.f3575j = r5;
                    }

                    @Override // org.xmlpull.p291v1.p292a.p293a.C2576b, org.xmlpull.p291v1.p292a.InterfaceC2580c
                    /* renamed from: a */
                    public void mo3864a(XmlPullParser xmlPullParser) {
                        int eventType = xmlPullParser.getEventType();
                        if (eventType == 2) {
                            if ("manifest".equalsIgnoreCase(xmlPullParser.getName())) {
                                try {
                                    this.f3573b = m3862b(xmlPullParser);
                                } catch (C0461b e2) {
                                }
                            } else if ("uses-sdk".equalsIgnoreCase(xmlPullParser.getName())) {
                                try {
                                    this.f3572a = m3863c(xmlPullParser);
                                    if (this.f3572a) {
                                        return;
                                    }
                                } catch (C0461b e3) {
                                }
                            }
                        } else {
                            if (this.f3572a && eventType == 3 && "uses-sdk".equalsIgnoreCase(xmlPullParser.getName())) {
                                return;
                            }
                            if (this.f3573b && eventType == 3 && "manifest".equalsIgnoreCase(xmlPullParser.getName())) {
                                super.mo3864a(xmlPullParser);
                                return;
                            }
                        }
                        super.mo3864a(xmlPullParser);
                    }

                    /* renamed from: b */
                    private boolean m3862b(XmlPullParser xmlPullParser) {
                        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                            String attributeName = xmlPullParser.getAttributeName(i);
                            if (attributeName.equalsIgnoreCase(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME)) {
                                this.f3575j.m3711b(xmlPullParser.getAttributeValue(i));
                            } else if (attributeName.equalsIgnoreCase("versionCode")) {
                                this.f3575j.m3723e(xmlPullParser.getAttributeValue(i));
                            } else if (attributeName.equalsIgnoreCase("versionName")) {
                                this.f3575j.m3718d(xmlPullParser.getAttributeValue(i));
                            }
                        }
                        return true;
                    }

                    /* renamed from: c */
                    private boolean m3863c(XmlPullParser xmlPullParser) {
                        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                            if ("http://schemas.android.com/apk/res/android".equalsIgnoreCase(xmlPullParser.getAttributeNamespace(i))) {
                                String attributeName = xmlPullParser.getAttributeName(i);
                                String attributeValue = xmlPullParser.getAttributeValue(i);
                                if (attributeName.equalsIgnoreCase("minSdkVersion") || attributeName.equalsIgnoreCase("targetSdkVersion") || attributeName.equalsIgnoreCase("maxSdkVersion") || attributeName.equalsIgnoreCase("compileSdkVersion")) {
                                    this.f3575j.m3707a(attributeName, attributeValue);
                                } else if (!attributeName.equalsIgnoreCase("versionCode") && !attributeName.equalsIgnoreCase("versionName")) {
                                    this.f3575j.m3725g();
                                    return false;
                                }
                            } else {
                                this.f3575j.m3725g();
                                if (i >= xmlPullParser.getAttributeCount()) {
                                    return false;
                                }
                            }
                        }
                        return !this.f3575j.m3728j();
                    }
                };
                m16043a.setInput(inputStream, (String) null);
                c2576b.setOutput(outputStream, (String) null);
                while (m16043a.nextToken() != 1) {
                    c2576b.mo3864a(m16043a);
                }
                c2576b.flush();
            } catch (IOException e2) {
                throw new C0461b("Could not decode XML", e2);
            } catch (XmlPullParserException e3) {
                throw new C0461b("Could not decode XML", e3);
            }
        } finally {
            this.f3570b.mo3868b(false);
        }
    }

    /* renamed from: b */
    public void m3861b(InputStream inputStream, OutputStream outputStream) {
        mo3822a(inputStream, outputStream);
    }
}
