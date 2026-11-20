package com.p065b.p066a.p068b.p077c;

import java.lang.annotation.Annotation;
import java.util.Objects;

/* compiled from: ClassCompat.java */
/* renamed from: com.b.a.b.c.a */
/* loaded from: classes.dex */
public class C0627a {
    /* renamed from: a */
    public static <A extends Annotation> A m6191a(Class<?> cls, Class<A> cls2) {
        Objects.requireNonNull(cls2);
        Objects.requireNonNull(cls);
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            if (cls2.equals(annotation.annotationType())) {
                return cls2.cast(annotation);
            }
        }
        return null;
    }
}
