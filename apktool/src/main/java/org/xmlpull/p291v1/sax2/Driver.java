package org.xmlpull.p291v1.sax2;

import java.p209io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* loaded from: assets/android.dex */
public class Driver implements Locator, XMLReader, Attributes {
    protected static final String APACHE_DYNAMIC_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/dynamic";
    protected static final String APACHE_SCHEMA_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/schema";
    protected static final String DECLARATION_HANDLER_PROPERTY = "http://xml.org/sax/properties/declaration-handler";
    protected static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
    protected static final String NAMESPACES_FEATURE = "http://xml.org/sax/features/namespaces";
    protected static final String NAMESPACE_PREFIXES_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    protected static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    protected ContentHandler contentHandler;
    protected ErrorHandler errorHandler;

    /* renamed from: pp */
    protected XmlPullParser f13412pp;
    protected String systemId;

    public Driver() throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    public Driver(XmlPullParser xmlPullParser) throws XmlPullParserException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        throw new RuntimeException("Stub!");
    }

    public void parseSubTree(XmlPullParser xmlPullParser) throws IOException, SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    protected void startElement(String str, String str2, String str3) throws SAXException {
        throw new RuntimeException("Stub!");
    }
}
