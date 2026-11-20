package com.p129f.p130a.p131a;

import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Optional.java */
/* renamed from: com.f.a.a.l */
/* loaded from: classes.dex */
public abstract class AbstractC1117l<T> implements Serializable {
    /* renamed from: a */
    public abstract T mo9498a(T t);

    /* renamed from: b */
    public static <T> AbstractC1117l<T> m9539b() {
        return C1106a.m9497a();
    }

    /* renamed from: b */
    public static <T> AbstractC1117l<T> m9540b(@NullableDecl T t) {
        return t == null ? m9539b() : new C1123r(t);
    }

    AbstractC1117l() {
    }
}
