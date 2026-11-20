package org.xmlpull.p291v1.p292a.p293a;

import java.p209io.InputStream;
import java.p209io.Reader;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: XmlPullParserDelegate.java */
/* renamed from: org.xmlpull.v1.a.a.c */
/* loaded from: classes.dex */
public class C2577c implements XmlPullParser {

    /* renamed from: a */
    protected XmlPullParser f13409a;

    public C2577c(XmlPullParser xmlPullParser) {
        this.f13409a = xmlPullParser;
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getText() {
        return this.f13409a.getText();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        this.f13409a.setFeature(str, z);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        return this.f13409a.getTextCharacters(iArr);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getColumnNumber() {
        return this.f13409a.getColumnNumber();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getNamespaceCount(int i) {
        return this.f13409a.getNamespaceCount(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.f13409a.getNamespacePrefix(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeName(int i) {
        return this.f13409a.getAttributeName(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getName() {
        return this.f13409a.getName();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean getFeature(String str) {
        return this.f13409a.getFeature(str);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getInputEncoding() {
        return this.f13409a.getInputEncoding();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(int i) {
        return this.f13409a.getAttributeValue(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespace(String str) {
        return this.f13409a.getNamespace(str);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setInput(Reader reader) {
        this.f13409a.setInput(reader);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getLineNumber() {
        return this.f13409a.getLineNumber();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public Object getProperty(String str) {
        return this.f13409a.getProperty(str);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return this.f13409a.isEmptyElementTag();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return this.f13409a.isAttributeDefault(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.f13409a.getNamespaceUri(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int next() {
        return this.f13409a.next();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int nextToken() {
        return this.f13409a.nextToken();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        this.f13409a.defineEntityReplacementText(str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public int getAttributeCount() {
        return this.f13409a.getAttributeCount();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public boolean isWhitespace() {
        return this.f13409a.isWhitespace();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getPrefix() {
        return this.f13409a.getPrefix();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void require(int i, String str, String str2) {
        this.f13409a.require(i, str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String nextText() {
        return this.f13409a.nextText();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getAttributeType(int i) {
        return this.f13409a.getAttributeType(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getDepth() {
        return this.f13409a.getDepth();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int nextTag() {
        return this.f13409a.nextTag();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public int getEventType() {
        return this.f13409a.getEventType();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getAttributePrefix(int i) {
        return this.f13409a.getAttributePrefix(i);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        this.f13409a.setInput(inputStream, str);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(String str, String str2) {
        return this.f13409a.getAttributeValue(str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        this.f13409a.setProperty(str, obj);
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getPositionDescription() {
        return this.f13409a.getPositionDescription();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser
    public String getNamespace() {
        return this.f13409a.getNamespace();
    }

    @Override // org.xmlpull.p291v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeNamespace(int i) {
        return this.f13409a.getAttributeNamespace(i);
    }
}
