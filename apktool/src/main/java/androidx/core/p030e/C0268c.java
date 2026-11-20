package androidx.core.p030e;

import android.p008os.Build;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* renamed from: androidx.core.e.c */
/* loaded from: classes.dex */
public class C0268c {
    /* renamed from: a */
    public static boolean m1953a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m1952a(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }
}
