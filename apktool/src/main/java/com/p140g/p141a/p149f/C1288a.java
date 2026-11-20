package com.p140g.p141a.p149f;

import java.nio.ByteBuffer;
import java.p209io.UTFDataFormatException;

/* compiled from: Mutf8.java */
/* renamed from: com.g.a.f.a */
/* loaded from: classes.dex */
public final class C1288a {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        throw new java.p209io.UTFDataFormatException("bad second or third byte");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m10460a(ByteBuffer byteBuffer, StringBuilder sb) {
        while (true) {
            char c2 = (char) (byteBuffer.get() & 255);
            if (c2 == 0) {
                return sb.toString();
            }
            if (c2 < 128) {
                sb.append(c2);
            } else if ((c2 & 224) == 192) {
                int i = byteBuffer.get() & 255;
                if ((i & 192) != 128) {
                    throw new UTFDataFormatException("bad second byte");
                }
                sb.append((char) (((c2 & 31) << 6) | (i & 63)));
            } else if ((c2 & 240) == 224) {
                int i2 = byteBuffer.get() & 255;
                int i3 = byteBuffer.get() & 255;
                if ((i2 & 192) != 128 || (i3 & 192) != 128) {
                    break;
                }
                sb.append((char) (((c2 & 15) << 12) | ((i2 & 63) << 6) | (i3 & 63)));
            } else {
                throw new UTFDataFormatException("bad byte");
            }
        }
    }
}
