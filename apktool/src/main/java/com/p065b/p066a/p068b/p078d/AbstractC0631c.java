package com.p065b.p066a.p068b.p078d;

import java.io.OutputStream;
import java.util.SortedMap;
import java.util.jar.Attributes;

/* compiled from: SignatureFileWriter.java */
/* renamed from: com.b.a.b.d.c */
/* loaded from: classes.dex */
public abstract class AbstractC0631c {
    private AbstractC0631c() {
    }

    /* renamed from: a */
    public static void m6224a(OutputStream outputStream, Attributes attributes) {
        String value = attributes.getValue(Attributes.Name.SIGNATURE_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.SIGNATURE_VERSION + " attribute missing");
        }
        AbstractC0630b.m6220a(outputStream, Attributes.Name.SIGNATURE_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> m6214a = AbstractC0630b.m6214a(attributes);
            m6214a.remove(Attributes.Name.SIGNATURE_VERSION.toString());
            AbstractC0630b.m6219a(outputStream, m6214a);
        }
        m6222a(outputStream);
    }

    /* renamed from: a */
    public static void m6223a(OutputStream outputStream, String str, Attributes attributes) {
        AbstractC0630b.m6218a(outputStream, str, attributes);
    }

    /* renamed from: a */
    public static void m6222a(OutputStream outputStream) {
        AbstractC0630b.m6215a(outputStream);
    }
}
