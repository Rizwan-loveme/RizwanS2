package org.xml.sax;

/* loaded from: assets/android.dex */
public interface XMLFilter extends XMLReader {
    XMLReader getParent();

    void setParent(XMLReader xMLReader);
}
