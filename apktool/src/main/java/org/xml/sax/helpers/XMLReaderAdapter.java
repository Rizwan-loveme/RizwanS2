package org.xml.sax.helpers;

import java.p209io.IOException;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: assets/android.dex */
public class XMLReaderAdapter implements Parser, ContentHandler {
    public XMLReaderAdapter() throws SAXException {
        throw new RuntimeException("Stub!");
    }

    public XMLReaderAdapter(XMLReader xMLReader) {
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
    public void endPrefixMapping(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void parse(String str) throws IOException, SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void parse(InputSource inputSource) throws IOException, SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void setDTDHandler(DTDHandler dTDHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void setDocumentHandler(DocumentHandler documentHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void setEntityResolver(EntityResolver entityResolver) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void setErrorHandler(ErrorHandler errorHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.Parser
    public void setLocale(Locale locale) throws SAXException {
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
    public void startPrefixMapping(String str, String str2) {
        throw new RuntimeException("Stub!");
    }
}
