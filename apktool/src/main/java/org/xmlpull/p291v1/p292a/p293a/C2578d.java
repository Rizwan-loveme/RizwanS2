package org.xmlpull.p291v1.p292a.p293a;

import java.p209io.OutputStream;
import java.p209io.Writer;
import org.xmlpull.p291v1.XmlSerializer;

/* compiled from: XmlSerializerDelegate.java */
/* renamed from: org.xmlpull.v1.a.a.d */
/* loaded from: classes.dex */
public class C2578d implements XmlSerializer {

    /* renamed from: h */
    protected XmlSerializer f13410h;

    public C2578d(XmlSerializer xmlSerializer) {
        this.f13410h = xmlSerializer;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getName() {
        return this.f13410h.getName();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        this.f13410h.setPrefix(str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        this.f13410h.setOutput(outputStream, str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void endDocument() {
        this.f13410h.endDocument();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void comment(String str) {
        this.f13410h.comment(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public int getDepth() {
        return this.f13410h.getDepth();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        this.f13410h.setProperty(str, obj);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void cdsect(String str) {
        this.f13410h.cdsect(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        this.f13410h.setFeature(str, z);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void entityRef(String str) {
        this.f13410h.entityRef(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void processingInstruction(String str) {
        this.f13410h.processingInstruction(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.f13410h.setOutput(writer);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void docdecl(String str) {
        this.f13410h.docdecl(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void flush() {
        this.f13410h.flush();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public Object getProperty(String str) {
        return this.f13410h.getProperty(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) {
        return this.f13410h.startTag(str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        this.f13410h.ignorableWhitespace(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer text(String str) {
        return this.f13410h.text(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public boolean getFeature(String str) {
        return this.f13410h.getFeature(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) {
        return this.f13410h.attribute(str, str2, str3);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        this.f13410h.startDocument(str, bool);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        return this.f13410h.getPrefix(str, z);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getNamespace() {
        return this.f13410h.getNamespace();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) {
        return this.f13410h.endTag(str, str2);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) {
        return this.f13410h.text(cArr, i, i2);
    }
}
