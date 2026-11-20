package org.p226d.p233b;

import android.os.Build;
import org.p226d.p269d.C2453g;

/* compiled from: AnnotationVisibility.java */
/* renamed from: org.d.b.b */
/* loaded from: classes.dex */
public final class C1985b {

    /* renamed from: a */
    private static String[] f11566a = {"build", "runtime", Build.Partition.PARTITION_NAME_SYSTEM};

    /* renamed from: a */
    public static String m14419a(int i) {
        if (i < 0 || i >= f11566a.length) {
            throw new C2453g("Invalid annotation visibility %d", Integer.valueOf(i));
        }
        return f11566a[i];
    }

    /* renamed from: a */
    public static int m14418a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("build")) {
            return 0;
        }
        if (lowerCase.equals("runtime")) {
            return 1;
        }
        if (lowerCase.equals(Build.Partition.PARTITION_NAME_SYSTEM)) {
            return 2;
        }
        throw new C2453g("Invalid annotation visibility: %s", lowerCase);
    }
}
