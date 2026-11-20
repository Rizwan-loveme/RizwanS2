package com.p065b.p086b.p095c.p096a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/* compiled from: OptimizerOptions.java */
/* renamed from: com.b.b.c.a.e */
/* loaded from: classes.dex */
public class C0764e {

    /* renamed from: a */
    private static HashSet<String> f4728a;

    /* renamed from: b */
    private static HashSet<String> f4729b;

    /* renamed from: c */
    private static boolean f4730c;

    /* renamed from: a */
    public static void m6959a(String str, String str2) {
        if (!f4730c) {
            if (str != null && str2 != null) {
                throw new RuntimeException("optimize and don't optimize lists  are mutually exclusive.");
            }
            if (str != null) {
                f4728a = m6961b(str);
            }
            if (str2 != null) {
                f4729b = m6961b(str2);
            }
            f4730c = true;
        }
    }

    /* renamed from: b */
    private static HashSet<String> m6961b(String str) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    hashSet.add(readLine);
                } else {
                    fileReader.close();
                    return hashSet;
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException("Error with optimize list: " + str, e2);
        }
    }

    /* renamed from: a */
    public static boolean m6960a(String str) {
        if (f4728a != null) {
            return f4728a.contains(str);
        }
        return f4729b == null || !f4729b.contains(str);
    }
}
