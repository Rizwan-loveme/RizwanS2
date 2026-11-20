package org.xmlpull.p291v1;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: assets/android.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    protected String classNamesLocation;
    protected HashMap<String, Boolean> features;
    protected ArrayList parserClasses;
    protected ArrayList serializerClasses;

    protected XmlPullParserFactory() {
        throw new RuntimeException("Stub!");
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public static XmlPullParserFactory newInstance(String str, Class cls) throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public boolean getFeature(String str) {
        throw new RuntimeException("Stub!");
    }

    public boolean isNamespaceAware() {
        throw new RuntimeException("Stub!");
    }

    public boolean isValidating() {
        throw new RuntimeException("Stub!");
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public void setNamespaceAware(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setValidating(boolean z) {
        throw new RuntimeException("Stub!");
    }
}
