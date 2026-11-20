package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Collections2.java */
/* renamed from: com.f.a.c.m */
/* loaded from: classes.dex */
public final class C1198m {
    /* renamed from: a */
    static boolean m10057a(Collection<?> collection, @NullableDecl Object obj) {
        C1120o.m9547a(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    /* renamed from: a */
    static StringBuilder m10055a(int i) {
        C1197l.m10052a(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    /* renamed from: a */
    static <T> Collection<T> m10056a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
