package org.w3c.dom.p289ls;

import java.p209io.InputStream;
import java.p209io.Reader;

/* loaded from: assets/android.dex */
public interface LSInput {
    String getBaseURI();

    InputStream getByteStream();

    boolean getCertifiedText();

    Reader getCharacterStream();

    String getEncoding();

    String getPublicId();

    String getStringData();

    String getSystemId();

    void setBaseURI(String str);

    void setByteStream(InputStream inputStream);

    void setCertifiedText(boolean z);

    void setCharacterStream(Reader reader);

    void setEncoding(String str);

    void setPublicId(String str);

    void setStringData(String str);

    void setSystemId(String str);
}
