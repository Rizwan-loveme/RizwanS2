package org.xml.sax.helpers;

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
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/* loaded from: assets/android.dex */
public class XMLFilterImpl implements XMLFilter, EntityResolver, DTDHandler, ContentHandler, ErrorHandler {
    public XMLFilterImpl() {
        throw new RuntimeException("Stub!");
    }

    public XMLFilterImpl(XMLReader xMLReader) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
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

    @Override // org.xml.sax.XMLFilter
    public XMLReader getParent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
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

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) throws IOException, SAXException {
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

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
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

    @Override // org.xml.sax.XMLFilter
    public void setParent(XMLReader xMLReader) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        throw new RuntimeException("Stub!");
    }
}
