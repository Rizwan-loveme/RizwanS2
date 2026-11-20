package com.p065b.p066a.p068b.p075b;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Asn1Field.java */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.b.a.b.b.f */
/* loaded from: classes.dex */
public @interface InterfaceC0622f {
    /* renamed from: a */
    EnumC0624h m6177a() default EnumC0624h.AUTOMATIC;

    /* renamed from: b */
    EnumC0626j m6178b() default EnumC0626j.ANY;

    /* renamed from: c */
    int m6179c() default 0;

    /* renamed from: d */
    boolean m6180d() default false;

    /* renamed from: e */
    int m6181e() default -1;

    /* renamed from: f */
    EnumC0625i m6182f() default EnumC0625i.NORMAL;

    /* renamed from: g */
    EnumC0626j m6183g();
}
