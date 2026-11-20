package org.xml.sax;

@Deprecated
/* loaded from: assets/android.dex */
public class HandlerBase implements EntityResolver, DTDHandler, DocumentHandler, ErrorHandler {
    @Deprecated
    public HandlerBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void endDocument() throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void endElement(String str) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    @Deprecated
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    @Deprecated
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DTDHandler
    @Deprecated
    public void notationDecl(String str, String str2, String str3) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void processingInstruction(String str, String str2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.EntityResolver
    @Deprecated
    public InputSource resolveEntity(String str, String str2) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void setDocumentLocator(Locator locator) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void startDocument() throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DocumentHandler
    @Deprecated
    public void startElement(String str, AttributeList attributeList) throws SAXException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.DTDHandler
    @Deprecated
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.xml.sax.ErrorHandler
    @Deprecated
    public void warning(SAXParseException sAXParseException) throws SAXException {
        throw new RuntimeException("Stub!");
    }
}
