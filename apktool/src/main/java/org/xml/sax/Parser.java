package org.xml.sax;

import java.p209io.IOException;
import java.util.Locale;

@Deprecated
/* loaded from: assets/android.dex */
public interface Parser {
    @Deprecated
    void parse(String str) throws IOException, SAXException;

    @Deprecated
    void parse(InputSource inputSource) throws IOException, SAXException;

    @Deprecated
    void setDTDHandler(DTDHandler dTDHandler);

    @Deprecated
    void setDocumentHandler(DocumentHandler documentHandler);

    @Deprecated
    void setEntityResolver(EntityResolver entityResolver);

    @Deprecated
    void setErrorHandler(ErrorHandler errorHandler);

    @Deprecated
    void setLocale(Locale locale) throws SAXException;
}
