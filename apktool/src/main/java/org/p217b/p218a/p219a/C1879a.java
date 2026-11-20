package org.p217b.p218a.p219a;

import java.nio.charset.Charset;

/* compiled from: Charsets.java */
/* renamed from: org.b.a.a.a */
/* loaded from: classes.dex */
public class C1879a {

    /* renamed from: a */
    public static final Charset f11018a = Charset.forName("ISO-8859-1");

    /* renamed from: b */
    public static final Charset f11019b = Charset.forName("US-ASCII");

    /* renamed from: c */
    public static final Charset f11020c = Charset.forName("UTF-16");

    /* renamed from: d */
    public static final Charset f11021d = Charset.forName("UTF-16BE");

    /* renamed from: e */
    public static final Charset f11022e = Charset.forName("UTF-16LE");

    /* renamed from: f */
    public static final Charset f11023f = Charset.forName("UTF-8");

    /* renamed from: a */
    public static Charset m13936a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    /* renamed from: a */
    public static Charset m13935a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
