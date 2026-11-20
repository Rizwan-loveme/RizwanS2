package com.p065b.p066a.p068b.p078d;

import com.p065b.p066a.C0681h;
import java.p209io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.jar.Attributes;

/* compiled from: ManifestWriter.java */
/* renamed from: com.b.a.b.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC0630b {
    private static final byte[] CRLF = {13, 10};
    private static final int MAX_LINE_LENGTH = 70;

    private AbstractC0630b() {
    }

    /* renamed from: a */
    public static void m6221a(OutputStream outputStream, Attributes attributes) {
        String value = attributes.getValue(Attributes.Name.MANIFEST_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.MANIFEST_VERSION + " attribute missing");
        }
        m6220a(outputStream, Attributes.Name.MANIFEST_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> m6214a = m6214a(attributes);
            m6214a.remove(Attributes.Name.MANIFEST_VERSION.toString());
            m6219a(outputStream, m6214a);
        }
        m6215a(outputStream);
    }

    /* renamed from: a */
    public static void m6218a(OutputStream outputStream, String str, Attributes attributes) {
        m6217a(outputStream, "Name", str);
        if (!attributes.isEmpty()) {
            m6219a(outputStream, m6214a(attributes));
        }
        m6215a(outputStream);
    }

    /* renamed from: a */
    static void m6215a(OutputStream outputStream) {
        outputStream.write(CRLF);
    }

    /* renamed from: a */
    static void m6220a(OutputStream outputStream, Attributes.Name name, String str) {
        m6217a(outputStream, name.toString(), str);
    }

    /* renamed from: a */
    private static void m6217a(OutputStream outputStream, String str, String str2) {
        m6216a(outputStream, str + ": " + str2);
    }

    /* renamed from: a */
    private static void m6216a(OutputStream outputStream, String str) {
        int min;
        byte[] bytes = str.getBytes(C0681h.UTF_8);
        int length = bytes.length;
        boolean z = true;
        int i = 0;
        while (length > 0) {
            if (z) {
                min = Math.min(length, 70);
            } else {
                outputStream.write(CRLF);
                outputStream.write(32);
                min = Math.min(length, 69);
            }
            outputStream.write(bytes, i, min);
            i += min;
            length -= min;
            z = false;
        }
        outputStream.write(CRLF);
    }

    /* renamed from: a */
    static SortedMap<String, String> m6214a(Attributes attributes) {
        Set<Map.Entry<Object, Object>> entrySet = attributes.entrySet();
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<Object, Object> entry : entrySet) {
            treeMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return treeMap;
    }

    /* renamed from: a */
    static void m6219a(OutputStream outputStream, SortedMap<String, String> sortedMap) {
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            m6217a(outputStream, entry.getKey(), entry.getValue());
        }
    }
}
