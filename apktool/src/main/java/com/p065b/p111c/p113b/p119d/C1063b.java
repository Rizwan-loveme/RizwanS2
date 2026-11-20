package com.p065b.p111c.p113b.p119d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: EocdRecord.java */
/* renamed from: com.b.c.b.d.b */
/* loaded from: classes.dex */
public class C1063b {
    /* renamed from: a */
    public static ByteBuffer m8875a(ByteBuffer byteBuffer, int i, long j, long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(byteBuffer.slice());
        allocate.flip();
        AbstractC1065d.m8897a(allocate, 8, i);
        AbstractC1065d.m8897a(allocate, 10, i);
        AbstractC1065d.m8898a(allocate, 12, j);
        AbstractC1065d.m8898a(allocate, 16, j2);
        return allocate;
    }
}
