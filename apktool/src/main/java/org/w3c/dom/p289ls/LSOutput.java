package org.w3c.dom.p289ls;

import java.io.OutputStream;
import java.io.Writer;

/* loaded from: assets/android.dex */
public interface LSOutput {
    OutputStream getByteStream();

    Writer getCharacterStream();

    String getEncoding();

    String getSystemId();

    void setByteStream(OutputStream outputStream);

    void setCharacterStream(Writer writer);

    void setEncoding(String str);

    void setSystemId(String str);
}
