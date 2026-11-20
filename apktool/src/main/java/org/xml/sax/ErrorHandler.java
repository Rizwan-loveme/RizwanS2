package org.xml.sax;

/* loaded from: assets/android.dex */
public interface ErrorHandler {
    void error(SAXParseException sAXParseException) throws SAXException;

    void fatalError(SAXParseException sAXParseException) throws SAXException;

    void warning(SAXParseException sAXParseException) throws SAXException;
}
