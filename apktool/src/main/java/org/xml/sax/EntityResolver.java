package org.xml.sax;

import java.io.IOException;

/* loaded from: assets/android.dex */
public interface EntityResolver {
    InputSource resolveEntity(String str, String str2) throws IOException, SAXException;
}
