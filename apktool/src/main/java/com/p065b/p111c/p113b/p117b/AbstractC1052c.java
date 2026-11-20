package com.p065b.p111c.p113b.p117b;

import java.p209io.OutputStream;
import java.util.SortedMap;
import java.util.jar.Attributes;

/* compiled from: SignatureFileWriter.java */
/* renamed from: com.b.c.b.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC1052c {
    /* renamed from: a */
    public static void m8836a(OutputStream outputStream, Attributes attributes) {
        String value = attributes.getValue(Attributes.Name.SIGNATURE_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.SIGNATURE_VERSION + " attribute missing");
        }
        AbstractC1051b.m8832a(outputStream, Attributes.Name.SIGNATURE_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> m8826a = AbstractC1051b.m8826a(attributes);
            m8826a.remove(Attributes.Name.SIGNATURE_VERSION.toString());
            AbstractC1051b.m8831a(outputStream, m8826a);
        }
        m8834a(outputStream);
    }

    /* renamed from: a */
    public static void m8835a(OutputStream outputStream, String str, Attributes attributes) {
        AbstractC1051b.m8830a(outputStream, str, attributes);
    }

    /* renamed from: a */
    public static void m8834a(OutputStream outputStream) {
        AbstractC1051b.m8827a(outputStream);
    }
}
