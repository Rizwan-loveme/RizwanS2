package com.p065b.p066a.p084c;

import com.p065b.p066a.p068b.p081g.C0650i;
import com.p065b.p066a.p068b.p081g.C0651j;
import com.p065b.p066a.p068b.p081g.C0653l;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

/* compiled from: DataSinks.java */
/* renamed from: com.b.a.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC0670b {
    private AbstractC0670b() {
    }

    /* renamed from: a */
    public static InterfaceC0669a m6332a(OutputStream outputStream) {
        return new C0651j(outputStream);
    }

    /* renamed from: a */
    public static InterfaceC0669a m6333a(RandomAccessFile randomAccessFile) {
        return new C0653l(randomAccessFile);
    }

    /* renamed from: a */
    public static InterfaceC0669a m6334a(MessageDigest... messageDigestArr) {
        return new C0650i(messageDigestArr);
    }
}
