package ru.p294a;

import java.net.HttpURLConnection;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ZipEncodingHelper.java */
/* renamed from: ru.a.t */
/* loaded from: classes.dex */
public abstract class AbstractC2601t {

    /* renamed from: a */
    static final String f13470a = "UTF8";

    /* renamed from: b */
    static final InterfaceC2600s f13471b;

    /* renamed from: c */
    private static final Map<String, a> f13472c;

    /* renamed from: d */
    private static final byte[] f13473d;

    /* renamed from: e */
    private static final String f13474e = "utf-8";

    /* compiled from: ZipEncodingHelper.java */
    /* renamed from: ru.a.t$a */
    private static class a {

        /* renamed from: a */
        private final char[] f13475a;

        /* renamed from: b */
        private C2590i f13476b;

        a(char[] cArr) {
            this.f13475a = cArr;
        }

        /* renamed from: a */
        public synchronized C2590i m16118a() {
            if (this.f13476b == null) {
                this.f13476b = new C2590i(this.f13475a);
            }
            return this.f13476b;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a aVar = new a(new char[]{(char) 199, (char) 252, (char) 233, (char) 226, (char) 228, (char) 224, (char) 229, (char) 231, (char) 234, (char) 235, (char) 232, (char) 239, (char) 238, (char) 236, (char) 196, (char) 197, (char) 201, (char) 230, (char) 198, (char) 244, (char) 246, (char) 242, (char) 251, (char) 249, (char) 255, (char) 214, (char) 220, (char) 162, (char) 163, (char) 165, (char) 8359, (char) 402, (char) 225, (char) 237, (char) 243, (char) 250, (char) 241, (char) 209, (char) 170, (char) 186, (char) 191, (char) 8976, (char) 172, (char) 189, (char) 188, (char) 161, (char) 171, (char) 187, (char) 9617, (char) 9618, (char) 9619, (char) 9474, (char) 9508, (char) 9569, (char) 9570, (char) 9558, (char) 9557, (char) 9571, (char) 9553, (char) 9559, (char) 9565, (char) 9564, (char) 9563, (char) 9488, (char) 9492, (char) 9524, (char) 9516, (char) 9500, (char) 9472, (char) 9532, (char) 9566, (char) 9567, (char) 9562, (char) 9556, (char) 9577, (char) 9574, (char) 9568, (char) 9552, (char) 9580, (char) 9575, (char) 9576, (char) 9572, (char) 9573, (char) 9561, (char) 9560, (char) 9554, (char) 9555, (char) 9579, (char) 9578, (char) 9496, (char) 9484, (char) 9608, (char) 9604, (char) 9612, (char) 9616, (char) 9600, (char) 945, (char) 223, (char) 915, (char) 960, (char) 931, (char) 963, (char) 181, (char) 964, (char) 934, (char) 920, (char) 937, (char) 948, (char) 8734, (char) 966, (char) 949, (char) 8745, (char) 8801, (char) 177, (char) 8805, (char) 8804, (char) 8992, (char) 8993, (char) 247, (char) 8776, (char) 176, (char) 8729, (char) 183, (char) 8730, (char) 8319, (char) 178, (char) 9632, (char) 160});
        hashMap.put("CP437", aVar);
        hashMap.put("Cp437", aVar);
        hashMap.put("cp437", aVar);
        hashMap.put("IBM437", aVar);
        hashMap.put("ibm437", aVar);
        a aVar2 = new a(new char[]{(char) 199, (char) 252, (char) 233, (char) 226, (char) 228, (char) 224, (char) 229, (char) 231, (char) 234, (char) 235, (char) 232, (char) 239, (char) 238, (char) 236, (char) 196, (char) 197, (char) 201, (char) 230, (char) 198, (char) 244, (char) 246, (char) 242, (char) 251, (char) 249, (char) 255, (char) 214, (char) 220, (char) 248, (char) 163, (char) 216, (char) 215, (char) 402, (char) 225, (char) 237, (char) 243, (char) 250, (char) 241, (char) 209, (char) 170, (char) 186, (char) 191, (char) 174, (char) 172, (char) 189, (char) 188, (char) 161, (char) 171, (char) 187, (char) 9617, (char) 9618, (char) 9619, (char) 9474, (char) 9508, (char) 193, (char) 194, (char) 192, (char) 169, (char) 9571, (char) 9553, (char) 9559, (char) 9565, (char) 162, (char) 165, (char) 9488, (char) 9492, (char) 9524, (char) 9516, (char) 9500, (char) 9472, (char) 9532, (char) 227, (char) 195, (char) 9562, (char) 9556, (char) 9577, (char) 9574, (char) 9568, (char) 9552, (char) 9580, (char) 164, (char) 240, (char) 208, (char) 202, (char) 203, (char) 200, (char) HttpURLConnection.HTTP_USE_PROXY, (char) 205, (char) 206, (char) 207, (char) 9496, (char) 9484, (char) 9608, (char) 9604, (char) 166, (char) 204, (char) 9600, (char) 211, (char) 223, (char) 212, (char) 210, (char) 245, (char) 213, (char) 181, (char) 254, (char) 222, (char) 218, (char) 219, (char) 217, (char) 253, (char) 221, (char) 175, (char) 180, (char) 173, (char) 177, (char) 8215, (char) 190, (char) 182, (char) 167, (char) 247, (char) 184, (char) 176, (char) 168, (char) 183, (char) 185, (char) 179, (char) 178, (char) 9632, (char) 160});
        hashMap.put("CP850", aVar2);
        hashMap.put("Cp850", aVar2);
        hashMap.put("cp850", aVar2);
        hashMap.put("IBM850", aVar2);
        hashMap.put("ibm850", aVar2);
        f13472c = Collections.unmodifiableMap(hashMap);
        f13473d = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
        f13471b = new C2586e(f13470a);
    }

    /* renamed from: a */
    static ByteBuffer m16113a(ByteBuffer byteBuffer, int i) {
        m16115a(byteBuffer);
        int capacity = byteBuffer.capacity() * 2;
        if (capacity >= i) {
            i = capacity;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.put(byteBuffer);
        return allocate;
    }

    /* renamed from: a */
    static void m16115a(Buffer buffer) {
        buffer.limit(buffer.position());
        buffer.rewind();
    }

    /* renamed from: a */
    static void m16116a(ByteBuffer byteBuffer, char c2) {
        byteBuffer.put((byte) 37);
        byteBuffer.put((byte) 85);
        byteBuffer.put(f13473d[(c2 >> '\f') & 15]);
        byteBuffer.put(f13473d[(c2 >> '\b') & 15]);
        byteBuffer.put(f13473d[(c2 >> 4) & 15]);
        byteBuffer.put(f13473d[c2 & 15]);
    }

    /* renamed from: a */
    public static InterfaceC2600s m16114a(String str) {
        if (m16117b(str)) {
            return f13471b;
        }
        if (str == null) {
            return new C2586e();
        }
        a aVar = f13472c.get(str);
        if (aVar != null) {
            return aVar.m16118a();
        }
        try {
            return new C2589h(Charset.forName(str));
        } catch (UnsupportedCharsetException e2) {
            return new C2586e(str);
        }
    }

    /* renamed from: b */
    static boolean m16117b(String str) {
        if (str == null) {
            str = System.getProperty("file.encoding");
        }
        return f13470a.equalsIgnoreCase(str) || f13474e.equalsIgnoreCase(str);
    }
}
