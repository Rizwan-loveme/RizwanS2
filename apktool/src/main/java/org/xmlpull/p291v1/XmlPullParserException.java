package org.xmlpull.p291v1;

/* loaded from: assets/android.dex */
public class XmlPullParserException extends Exception {
    protected Throwable detail;
    protected int column = -1;
    protected int row = -1;

    public XmlPullParserException(String str) {
        throw new RuntimeException("Stub!");
    }

    public XmlPullParserException(String str, XmlPullParser xmlPullParser, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    public int getColumnNumber() {
        throw new RuntimeException("Stub!");
    }

    public Throwable getDetail() {
        throw new RuntimeException("Stub!");
    }

    public int getLineNumber() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        throw new RuntimeException("Stub!");
    }
}
