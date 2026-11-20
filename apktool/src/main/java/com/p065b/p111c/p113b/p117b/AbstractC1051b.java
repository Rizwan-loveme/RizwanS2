package com.p065b.p111c.p113b.p117b;

import java.nio.charset.StandardCharsets;
import java.p209io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.jar.Attributes;

/* compiled from: ManifestWriter.java */
/* renamed from: com.b.c.b.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC1051b {

    /* renamed from: a */
    private static final byte[] f6691a = {13, 10};

    /* renamed from: a */
    public static void m8833a(OutputStream outputStream, Attributes attributes) {
        String value = attributes.getValue(Attributes.Name.MANIFEST_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.MANIFEST_VERSION + " attribute missing");
        }
        m8832a(outputStream, Attributes.Name.MANIFEST_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> m8826a = m8826a(attributes);
            m8826a.remove(Attributes.Name.MANIFEST_VERSION.toString());
            m8831a(outputStream, m8826a);
        }
        m8827a(outputStream);
    }

    /* renamed from: a */
    public static void m8830a(OutputStream outputStream, String str, Attributes attributes) {
        m8829a(outputStream, "Name", str);
        if (!attributes.isEmpty()) {
            m8831a(outputStream, m8826a(attributes));
        }
        m8827a(outputStream);
    }

    /* renamed from: a */
    static void m8827a(OutputStream outputStream) {
        outputStream.write(f6691a);
    }

    /* renamed from: a */
    static void m8832a(OutputStream outputStream, Attributes.Name name, String str) {
        m8829a(outputStream, name.toString(), str);
    }

    /* renamed from: a */
    private static void m8829a(OutputStream outputStream, String str, String str2) {
        m8828a(outputStream, String.valueOf(str) + ": " + str2);
    }

    /* renamed from: a */
    private static void m8828a(OutputStream outputStream, String str) {
        int min;
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        boolean z = true;
        int i = 0;
        while (length > 0) {
            if (z) {
                min = Math.min(length, 70);
            } else {
                outputStream.write(f6691a);
                outputStream.write(32);
                min = Math.min(length, 69);
            }
            outputStream.write(bytes, i, min);
            i += min;
            length -= min;
            z = false;
        }
        outputStream.write(f6691a);
    }

    /* renamed from: a */
    static SortedMap<String, String> m8826a(Attributes attributes) {
        Set<Map.Entry<Object, Object>> entrySet = attributes.entrySet();
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<Object, Object> entry : entrySet) {
            treeMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return treeMap;
    }

    /* renamed from: a */
    static void m8831a(OutputStream outputStream, SortedMap<String, String> sortedMap) {
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            m8829a(outputStream, entry.getKey(), entry.getValue());
        }
    }
}
