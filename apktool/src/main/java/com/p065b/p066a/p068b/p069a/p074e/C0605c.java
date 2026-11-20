package com.p065b.p066a.p068b.p069a.p074e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: V4Signature.java */
/* renamed from: com.b.a.b.a.e.c */
/* loaded from: classes.dex */
public class C0605c {
    public static final int CURRENT_VERSION = 2;
    public static final int HASHING_ALGORITHM_SHA256 = 1;
    public static final byte LOG2_BLOCK_SIZE_4096_BYTES = 12;
    public static final int MAX_SIGNING_INFOS_SIZE = 7168;

    /* renamed from: a */
    public final byte[] f4164a;

    /* renamed from: b */
    public final byte[] f4165b;

    /* renamed from: c */
    public final int f4166c;

    /* compiled from: V4Signature.java */
    /* renamed from: com.b.a.b.a.e.c$a */
    public static class a {

        /* renamed from: a */
        public final int f4167a;

        /* renamed from: b */
        public final byte f4168b;

        /* renamed from: c */
        public final byte[] f4169c;

        /* renamed from: d */
        public final byte[] f4170d;

        a(int i, byte b2, byte[] bArr, byte[] bArr2) {
            this.f4167a = i;
            this.f4168b = b2;
            this.f4170d = bArr;
            this.f4169c = bArr2;
        }

        /* renamed from: a */
        static a m6065a(byte[] bArr) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new a(order.getInt(), order.get(), C0605c.m6061a(order), C0605c.m6061a(order));
        }

        /* renamed from: a */
        byte[] m6066a() {
            ByteBuffer order = ByteBuffer.allocate(C0605c.m6054a(this.f4170d) + 5 + C0605c.m6054a(this.f4169c)).order(ByteOrder.LITTLE_ENDIAN);
            order.putInt(this.f4167a);
            order.put(this.f4168b);
            C0605c.m6058a(order, this.f4170d);
            C0605c.m6058a(order, this.f4169c);
            return order.array();
        }
    }

    /* compiled from: V4Signature.java */
    /* renamed from: com.b.a.b.a.e.c$b */
    public static class b {

        /* renamed from: a */
        public final byte[] f4171a;

        /* renamed from: b */
        public final byte[] f4172b;

        /* renamed from: c */
        public final byte[] f4173c;

        /* renamed from: d */
        public final byte[] f4174d;

        /* renamed from: e */
        public final byte[] f4175e;

        /* renamed from: f */
        public final int f4176f;

        b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
            this.f4172b = bArr;
            this.f4173c = bArr2;
            this.f4171a = bArr3;
            this.f4174d = bArr4;
            this.f4176f = i;
            this.f4175e = bArr5;
        }

        /* renamed from: a */
        static b m6068a(byte[] bArr) {
            return m6067a(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
        }

        /* renamed from: a */
        static b m6067a(ByteBuffer byteBuffer) {
            return new b(C0605c.m6061a(byteBuffer), C0605c.m6061a(byteBuffer), C0605c.m6061a(byteBuffer), C0605c.m6061a(byteBuffer), byteBuffer.getInt(), C0605c.m6061a(byteBuffer));
        }

        /* renamed from: a */
        byte[] m6069a() {
            int m6054a = C0605c.m6054a(this.f4172b);
            int m6054a2 = C0605c.m6054a(this.f4173c);
            int m6054a3 = C0605c.m6054a(this.f4171a);
            ByteBuffer order = ByteBuffer.allocate(m6054a + m6054a2 + m6054a3 + C0605c.m6054a(this.f4174d) + 4 + C0605c.m6054a(this.f4175e)).order(ByteOrder.LITTLE_ENDIAN);
            C0605c.m6058a(order, this.f4172b);
            C0605c.m6058a(order, this.f4173c);
            C0605c.m6058a(order, this.f4171a);
            C0605c.m6058a(order, this.f4174d);
            order.putInt(this.f4176f);
            C0605c.m6058a(order, this.f4175e);
            return order.array();
        }
    }

    /* compiled from: V4Signature.java */
    /* renamed from: com.b.a.b.a.e.c$c */
    public static class c {

        /* renamed from: a */
        public final int f4177a;

        /* renamed from: b */
        public final byte[] f4178b;

        public c(int i, byte[] bArr) {
            this.f4177a = i;
            this.f4178b = bArr;
        }

        /* renamed from: a */
        static c m6070a(ByteBuffer byteBuffer) {
            return new c(byteBuffer.getInt(), C0605c.m6061a(byteBuffer));
        }

        /* renamed from: a */
        byte[] m6071a() {
            ByteBuffer order = ByteBuffer.allocate(C0605c.m6054a(this.f4178b) + 4).order(ByteOrder.LITTLE_ENDIAN);
            order.putInt(this.f4177a);
            C0605c.m6058a(order, this.f4178b);
            return order.array();
        }
    }

    /* compiled from: V4Signature.java */
    /* renamed from: com.b.a.b.a.e.c$d */
    public static class d {

        /* renamed from: a */
        public final b f4179a;

        /* renamed from: b */
        public final c[] f4180b;

        public d(b bVar) {
            this.f4179a = bVar;
            this.f4180b = new c[0];
        }

        public d(b bVar, c... cVarArr) {
            this.f4179a = bVar;
            this.f4180b = cVarArr;
        }

        /* renamed from: a */
        public static d m6072a(byte[] bArr) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            b m6067a = b.m6067a(order);
            if (!order.hasRemaining()) {
                return new d(m6067a);
            }
            ArrayList arrayList = new ArrayList(1);
            while (order.hasRemaining()) {
                arrayList.add(c.m6070a(order));
            }
            return new d(m6067a, (c[]) arrayList.toArray(new c[arrayList.size()]));
        }

        /* renamed from: a */
        byte[] m6073a() {
            byte[][] bArr = new byte[this.f4180b.length + 1][];
            byte[] m6069a = this.f4179a.m6069a();
            bArr[0] = m6069a;
            int length = m6069a.length;
            int length2 = this.f4180b.length;
            int i = 0;
            int i2 = length;
            while (i < length2) {
                int i3 = i + 1;
                byte[] m6071a = this.f4180b[i].m6071a();
                bArr[i3] = m6071a;
                i2 += m6071a.length;
                i = i3;
            }
            if (i2 > 7168) {
                throw new IllegalArgumentException("Combined SigningInfos length exceeded limit of 7K: " + i2);
            }
            byte[] copyOf = Arrays.copyOf(bArr[0], i2);
            int length3 = bArr[0].length;
            int length4 = this.f4180b.length;
            int i4 = 0;
            while (i4 < length4) {
                i4++;
                byte[] bArr2 = bArr[i4];
                System.arraycopy(bArr2, 0, copyOf, length3, bArr2.length);
                length3 += bArr[i4].length;
            }
            return copyOf;
        }
    }

    C0605c(int i, byte[] bArr, byte[] bArr2) {
        this.f4166c = i;
        this.f4164a = bArr;
        this.f4165b = bArr2;
    }

    /* renamed from: b */
    static C0605c m6062b(InputStream inputStream) {
        int m6063c = m6063c(inputStream);
        if (m6063c != 2) {
            throw new IOException("Invalid signature version.");
        }
        return new C0605c(m6063c, m6060a(inputStream), m6060a(inputStream));
    }

    /* renamed from: a */
    public void m6064a(OutputStream outputStream) {
        m6056a(outputStream, this.f4166c);
        m6057a(outputStream, this.f4164a);
        m6057a(outputStream, this.f4165b);
    }

    /* renamed from: a */
    static byte[] m6059a(long j, a aVar, b bVar) {
        int m6054a = m6054a(aVar.f4170d);
        int m6054a2 = m6054a(aVar.f4169c);
        int m6054a3 = m6054a + 17 + m6054a2 + m6054a(bVar.f4172b) + m6054a(bVar.f4173c) + m6054a(bVar.f4171a);
        ByteBuffer order = ByteBuffer.allocate(m6054a3).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(m6054a3);
        order.putLong(j);
        order.putInt(aVar.f4167a);
        order.put(aVar.f4168b);
        m6058a(order, aVar.f4170d);
        m6058a(order, aVar.f4169c);
        m6058a(order, bVar.f4172b);
        m6058a(order, bVar.f4173c);
        m6058a(order, bVar.f4171a);
        return order.array();
    }

    /* renamed from: a */
    static int m6054a(byte[] bArr) {
        return (bArr == null ? 0 : bArr.length) + 4;
    }

    /* renamed from: a */
    static void m6055a(InputStream inputStream, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int read = inputStream.read(bArr, i, length - i);
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
        }
    }

    /* renamed from: c */
    static int m6063c(InputStream inputStream) {
        byte[] bArr = new byte[4];
        m6055a(inputStream, bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /* renamed from: a */
    static void m6056a(OutputStream outputStream, int i) {
        outputStream.write(ByteBuffer.wrap(new byte[4]).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
    }

    /* renamed from: a */
    static byte[] m6060a(InputStream inputStream) {
        try {
            byte[] bArr = new byte[m6063c(inputStream)];
            m6055a(inputStream, bArr);
            return bArr;
        } catch (EOFException e2) {
            return null;
        }
    }

    /* renamed from: a */
    static byte[] m6061a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new EOFException();
        }
        int i = byteBuffer.getInt();
        if (byteBuffer.remaining() < i) {
            throw new EOFException();
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: a */
    static void m6057a(OutputStream outputStream, byte[] bArr) {
        if (bArr == null) {
            m6056a(outputStream, 0);
        } else {
            m6056a(outputStream, bArr.length);
            outputStream.write(bArr);
        }
    }

    /* renamed from: a */
    static void m6058a(ByteBuffer byteBuffer, byte[] bArr) {
        if (bArr == null) {
            byteBuffer.putInt(0);
        } else {
            byteBuffer.putInt(bArr.length);
            byteBuffer.put(bArr);
        }
    }
}
