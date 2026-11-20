package org.xml.sax;

@Deprecated
/* loaded from: assets/android.dex */
public interface DocumentHandler {
    @Deprecated
    void characters(char[] cArr, int i, int i2) throws SAXException;

    @Deprecated
    void endDocument() throws SAXException;

    @Deprecated
    void endElement(String str) throws SAXException;

    @Deprecated
    void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException;

    @Deprecated
    void processingInstruction(String str, String str2) throws SAXException;

    @Deprecated
    void setDocumentLocator(Locator locator);

    @Deprecated
    void startDocument() throws SAXException;

    @Deprecated
    void startElement(String str, AttributeList attributeList) throws SAXException;
}
