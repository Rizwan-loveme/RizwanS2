package org.p210a.p211a.p212a;

/* compiled from: RuntimeMetaData.java */
/* renamed from: org.a.a.a.aa */
/* loaded from: classes.dex */
public class C1817aa {
    /* renamed from: a */
    public static void m13671a(String str, String str2) {
        boolean z;
        if (str != null) {
            z = ("4.7.2".equals(str) || m13670a("4.7.2").equals(m13670a(str))) ? false : true;
        } else {
            z = false;
        }
        boolean z2 = ("4.7.2".equals(str2) || m13670a("4.7.2").equals(m13670a(str2))) ? false : true;
        if (z) {
            System.err.printf("ANTLR Tool version %s used for code generation does not match the current runtime version %s", str, "4.7.2");
        }
        if (z2) {
            System.err.printf("ANTLR Runtime version %s used for parser compilation does not match the current runtime version %s", str2, "4.7.2");
        }
    }

    /* renamed from: a */
    public static String m13670a(String str) {
        int indexOf = str.indexOf(46);
        int indexOf2 = indexOf >= 0 ? str.indexOf(46, indexOf + 1) : -1;
        int indexOf3 = str.indexOf(45);
        int length = str.length();
        int min = indexOf2 >= 0 ? Math.min(length, indexOf2) : length;
        if (indexOf3 >= 0) {
            min = Math.min(min, indexOf3);
        }
        return str.substring(0, min);
    }
}
