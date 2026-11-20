package com.p065b.p066a.p068b.p083i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: EocdRecord.java */
/* renamed from: com.b.a.b.i.b */
/* loaded from: classes.dex */
public class C0665b {
    private static final int CD_OFFSET_OFFSET = 16;
    private static final int CD_RECORD_COUNT_ON_DISK_OFFSET = 8;
    private static final int CD_RECORD_COUNT_TOTAL_OFFSET = 10;
    private static final int CD_SIZE_OFFSET = 12;

    /* renamed from: a */
    public static ByteBuffer m6293a(ByteBuffer byteBuffer, int i, long j, long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(byteBuffer.slice());
        allocate.flip();
        AbstractC0667d.m6316a(allocate, 8, i);
        AbstractC0667d.m6316a(allocate, 10, i);
        AbstractC0667d.m6317a(allocate, 12, j);
        AbstractC0667d.m6317a(allocate, 16, j2);
        return allocate;
    }

    /* renamed from: a */
    public static ByteBuffer m6292a(ByteBuffer byteBuffer, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(byteBuffer.slice());
        allocate.rewind();
        AbstractC0667d.m6328h(allocate);
        return allocate;
    }
}
