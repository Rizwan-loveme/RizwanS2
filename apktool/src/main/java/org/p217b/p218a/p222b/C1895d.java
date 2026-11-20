package org.p217b.p218a.p222b;

import java.p209io.IOException;
import java.p209io.StringWriter;
import java.p209io.Writer;

/* compiled from: StringEscapeUtils.java */
/* renamed from: org.b.a.b.d */
/* loaded from: classes.dex */
public class C1895d {

    /* renamed from: a */
    private static final String f11100a = String.valueOf('\"');

    /* renamed from: b */
    private static final char[] f11101b = {',', '\"', '\r', '\n'};

    /* renamed from: a */
    public static String m14012a(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter((int) (str.length() * 1.5d));
            m14013a(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new C1898g(e2);
        }
    }

    /* renamed from: a */
    public static void m14013a(Writer writer, String str) {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (str != null) {
            C1893b.f11086e.m14005a(writer, str);
        }
    }
}
