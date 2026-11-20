package org.p210a.p211a.p212a;

import android.provider.MediaStore;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import org.p210a.p211a.p212a.C1860h;

/* compiled from: CharStreams.java */
/* renamed from: org.a.a.a.g */
/* loaded from: classes.dex */
public final class C1859g {
    /* renamed from: a */
    public static InterfaceC1858f m13806a(File file, Charset charset) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return m13808a(fileInputStream, charset, file.length());
        } finally {
            fileInputStream.close();
        }
    }

    /* renamed from: a */
    public static InterfaceC1858f m13807a(InputStream inputStream, Charset charset) {
        return m13808a(inputStream, charset, -1L);
    }

    /* renamed from: a */
    public static InterfaceC1858f m13808a(InputStream inputStream, Charset charset, long j) {
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        try {
            return m13809a(newChannel, charset, 4096, CodingErrorAction.REPLACE, MediaStore.UNKNOWN_STRING, j);
        } finally {
            newChannel.close();
        }
    }

    /* renamed from: a */
    public static AbstractC1861i m13809a(ReadableByteChannel readableByteChannel, Charset charset, int i, CodingErrorAction codingErrorAction, String str, long j) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            CharBuffer allocate2 = CharBuffer.allocate(i);
            if (j == -1) {
                j = i;
            } else if (j > 2147483647L) {
                throw new IOException(String.format("inputSize %d larger than max %d", Long.valueOf(j), Integer.MAX_VALUE));
            }
            C1860h.a m13810a = C1860h.m13810a((int) j);
            CharsetDecoder onUnmappableCharacter = charset.newDecoder().onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
            boolean z = false;
            while (!z) {
                z = readableByteChannel.read(allocate) == -1;
                allocate.flip();
                CoderResult decode = onUnmappableCharacter.decode(allocate, allocate2, z);
                if (decode.isError() && codingErrorAction.equals(CodingErrorAction.REPORT)) {
                    decode.throwException();
                }
                allocate2.flip();
                m13810a.m13830a(allocate2);
                allocate.compact();
                allocate2.compact();
            }
            CoderResult flush = onUnmappableCharacter.flush(allocate2);
            if (flush.isError() && codingErrorAction.equals(CodingErrorAction.REPORT)) {
                flush.throwException();
            }
            allocate2.flip();
            m13810a.m13830a(allocate2);
            return AbstractC1861i.m13831a(m13810a.m13828a(), str);
        } finally {
            readableByteChannel.close();
        }
    }
}
