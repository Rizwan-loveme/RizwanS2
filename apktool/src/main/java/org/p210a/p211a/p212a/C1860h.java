package org.p210a.p211a.p212a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/* compiled from: CodePointBuffer.java */
/* renamed from: org.a.a.a.h */
/* loaded from: classes.dex */
public class C1860h {

    /* renamed from: a */
    static final /* synthetic */ boolean f10921a;

    /* renamed from: f */
    private static /* synthetic */ int[] f10922f;

    /* renamed from: b */
    private final b f10923b;

    /* renamed from: c */
    private final ByteBuffer f10924c;

    /* renamed from: d */
    private final CharBuffer f10925d;

    /* renamed from: e */
    private final IntBuffer f10926e;

    /* compiled from: CodePointBuffer.java */
    /* renamed from: org.a.a.a.h$b */
    public enum b {
        BYTE,
        CHAR,
        INT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            int length = valuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(valuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    static {
        f10921a = !C1860h.class.desiredAssertionStatus();
    }

    /* renamed from: h */
    static /* synthetic */ int[] m13811h() {
        int[] iArr = f10922f;
        if (iArr == null) {
            iArr = new int[b.valuesCustom().length];
            try {
                iArr[b.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[b.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[b.INT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f10922f = iArr;
        }
        return iArr;
    }

    private C1860h(b bVar, ByteBuffer byteBuffer, CharBuffer charBuffer, IntBuffer intBuffer) {
        this.f10923b = bVar;
        this.f10924c = byteBuffer;
        this.f10925d = charBuffer;
        this.f10926e = intBuffer;
    }

    /* synthetic */ C1860h(b bVar, ByteBuffer byteBuffer, CharBuffer charBuffer, IntBuffer intBuffer, C1860h c1860h) {
        this(bVar, byteBuffer, charBuffer, intBuffer);
    }

    /* renamed from: a */
    public int m13812a() {
        switch (m13811h()[this.f10923b.ordinal()]) {
            case 1:
                return this.f10924c.position();
            case 2:
                return this.f10925d.position();
            case 3:
                return this.f10926e.position();
            default:
                throw new UnsupportedOperationException("Not reached");
        }
    }

    /* renamed from: b */
    public int m13813b() {
        switch (m13811h()[this.f10923b.ordinal()]) {
            case 1:
                return this.f10924c.remaining();
            case 2:
                return this.f10925d.remaining();
            case 3:
                return this.f10926e.remaining();
            default:
                throw new UnsupportedOperationException("Not reached");
        }
    }

    /* renamed from: c */
    b m13814c() {
        return this.f10923b;
    }

    /* renamed from: d */
    int m13815d() {
        switch (m13811h()[this.f10923b.ordinal()]) {
            case 1:
                return this.f10924c.arrayOffset();
            case 2:
                return this.f10925d.arrayOffset();
            case 3:
                return this.f10926e.arrayOffset();
            default:
                throw new UnsupportedOperationException("Not reached");
        }
    }

    /* renamed from: e */
    byte[] m13816e() {
        if (f10921a || this.f10923b == b.BYTE) {
            return this.f10924c.array();
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    char[] m13817f() {
        if (f10921a || this.f10923b == b.CHAR) {
            return this.f10925d.array();
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    int[] m13818g() {
        if (f10921a || this.f10923b == b.INT) {
            return this.f10926e.array();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static a m13810a(int i) {
        return new a(i, null);
    }

    /* compiled from: CodePointBuffer.java */
    /* renamed from: org.a.a.a.h$a */
    public static class a {

        /* renamed from: a */
        static final /* synthetic */ boolean f10927a;

        /* renamed from: g */
        private static /* synthetic */ int[] f10928g;

        /* renamed from: b */
        private b f10929b;

        /* renamed from: c */
        private ByteBuffer f10930c;

        /* renamed from: d */
        private CharBuffer f10931d;

        /* renamed from: e */
        private IntBuffer f10932e;

        /* renamed from: f */
        private int f10933f;

        static {
            f10927a = !C1860h.class.desiredAssertionStatus();
        }

        /* renamed from: b */
        static /* synthetic */ int[] m13821b() {
            int[] iArr = f10928g;
            if (iArr == null) {
                iArr = new int[b.valuesCustom().length];
                try {
                    iArr[b.BYTE.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[b.CHAR.ordinal()] = 2;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[b.INT.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                f10928g = iArr;
            }
            return iArr;
        }

        private a(int i) {
            this.f10929b = b.BYTE;
            this.f10930c = ByteBuffer.allocate(i);
            this.f10931d = null;
            this.f10932e = null;
            this.f10933f = -1;
        }

        /* synthetic */ a(int i, a aVar) {
            this(i);
        }

        /* renamed from: a */
        public C1860h m13828a() {
            switch (m13821b()[this.f10929b.ordinal()]) {
                case 1:
                    this.f10930c.flip();
                    break;
                case 2:
                    this.f10931d.flip();
                    break;
                case 3:
                    this.f10932e.flip();
                    break;
            }
            return new C1860h(this.f10929b, this.f10930c, this.f10931d, this.f10932e, null);
        }

        /* renamed from: b */
        private static int m13819b(int i) {
            return (int) Math.pow(2.0d, 32 - Integer.numberOfLeadingZeros(i - 1));
        }

        /* renamed from: a */
        public void m13829a(int i) {
            switch (m13821b()[this.f10929b.ordinal()]) {
                case 1:
                    if (this.f10930c.remaining() < i) {
                        ByteBuffer allocate = ByteBuffer.allocate(m13819b(this.f10930c.capacity() + i));
                        this.f10930c.flip();
                        allocate.put(this.f10930c);
                        this.f10930c = allocate;
                        break;
                    }
                    break;
                case 2:
                    if (this.f10931d.remaining() < i) {
                        CharBuffer allocate2 = CharBuffer.allocate(m13819b(this.f10931d.capacity() + i));
                        this.f10931d.flip();
                        allocate2.put(this.f10931d);
                        this.f10931d = allocate2;
                        break;
                    }
                    break;
                case 3:
                    if (this.f10932e.remaining() < i) {
                        IntBuffer allocate3 = IntBuffer.allocate(m13819b(this.f10932e.capacity() + i));
                        this.f10932e.flip();
                        allocate3.put(this.f10932e);
                        this.f10932e = allocate3;
                        break;
                    }
                    break;
            }
        }

        /* renamed from: a */
        public void m13830a(CharBuffer charBuffer) {
            m13829a(charBuffer.remaining());
            if (charBuffer.hasArray()) {
                m13820b(charBuffer);
                return;
            }
            throw new UnsupportedOperationException("TODO");
        }

        /* renamed from: b */
        private void m13820b(CharBuffer charBuffer) {
            if (!f10927a && !charBuffer.hasArray()) {
                throw new AssertionError();
            }
            switch (m13821b()[this.f10929b.ordinal()]) {
                case 1:
                    m13823c(charBuffer);
                    return;
                case 2:
                    m13825d(charBuffer);
                    return;
                case 3:
                    m13827e(charBuffer);
                    return;
                default:
                    return;
            }
        }

        /* renamed from: c */
        private void m13823c(CharBuffer charBuffer) {
            if (!f10927a && this.f10933f != -1) {
                throw new AssertionError();
            }
            char[] array = charBuffer.array();
            int position = charBuffer.position() + charBuffer.arrayOffset();
            int limit = charBuffer.limit() + charBuffer.arrayOffset();
            byte[] array2 = this.f10930c.array();
            int arrayOffset = this.f10930c.arrayOffset() + this.f10930c.position();
            while (position < limit) {
                char c2 = array[position];
                if (c2 <= 255) {
                    array2[arrayOffset] = (byte) (c2 & 255);
                    position++;
                    arrayOffset++;
                } else {
                    charBuffer.position(position - charBuffer.arrayOffset());
                    this.f10930c.position(arrayOffset - this.f10930c.arrayOffset());
                    if (!Character.isHighSurrogate(c2)) {
                        m13822c(charBuffer.remaining());
                        m13825d(charBuffer);
                        return;
                    } else {
                        m13824d(charBuffer.remaining());
                        m13827e(charBuffer);
                        return;
                    }
                }
            }
            charBuffer.position(position - charBuffer.arrayOffset());
            this.f10930c.position(arrayOffset - this.f10930c.arrayOffset());
        }

        /* renamed from: d */
        private void m13825d(CharBuffer charBuffer) {
            if (!f10927a && this.f10933f != -1) {
                throw new AssertionError();
            }
            char[] array = charBuffer.array();
            int position = charBuffer.position() + charBuffer.arrayOffset();
            int limit = charBuffer.limit() + charBuffer.arrayOffset();
            char[] array2 = this.f10931d.array();
            int arrayOffset = this.f10931d.arrayOffset() + this.f10931d.position();
            while (position < limit) {
                char c2 = array[position];
                if (!Character.isHighSurrogate(c2)) {
                    array2[arrayOffset] = c2;
                    position++;
                    arrayOffset++;
                } else {
                    charBuffer.position(position - charBuffer.arrayOffset());
                    this.f10931d.position(arrayOffset - this.f10931d.arrayOffset());
                    m13826e(charBuffer.remaining());
                    m13827e(charBuffer);
                    return;
                }
            }
            charBuffer.position(position - charBuffer.arrayOffset());
            this.f10931d.position(arrayOffset - this.f10931d.arrayOffset());
        }

        /* renamed from: e */
        private void m13827e(CharBuffer charBuffer) {
            char[] array = charBuffer.array();
            int position = charBuffer.position() + charBuffer.arrayOffset();
            int limit = charBuffer.limit() + charBuffer.arrayOffset();
            int[] array2 = this.f10932e.array();
            int arrayOffset = this.f10932e.arrayOffset() + this.f10932e.position();
            while (position < limit) {
                char c2 = array[position];
                position++;
                if (this.f10933f != -1) {
                    if (Character.isLowSurrogate(c2)) {
                        array2[arrayOffset] = Character.toCodePoint((char) this.f10933f, c2);
                        arrayOffset++;
                        this.f10933f = -1;
                    } else {
                        array2[arrayOffset] = this.f10933f;
                        arrayOffset++;
                        if (Character.isHighSurrogate(c2)) {
                            this.f10933f = c2 & 65535;
                        } else {
                            array2[arrayOffset] = c2 & 65535;
                            arrayOffset++;
                            this.f10933f = -1;
                        }
                    }
                } else if (Character.isHighSurrogate(c2)) {
                    this.f10933f = c2 & 65535;
                } else {
                    array2[arrayOffset] = c2 & 65535;
                    arrayOffset++;
                }
            }
            if (this.f10933f != -1) {
                array2[arrayOffset] = this.f10933f & 65535;
                arrayOffset++;
            }
            charBuffer.position(position - charBuffer.arrayOffset());
            this.f10932e.position(arrayOffset - this.f10932e.arrayOffset());
        }

        /* renamed from: c */
        private void m13822c(int i) {
            this.f10930c.flip();
            CharBuffer allocate = CharBuffer.allocate(Math.max(this.f10930c.remaining() + i, this.f10930c.capacity() / 2));
            while (this.f10930c.hasRemaining()) {
                allocate.put((char) (this.f10930c.get() & 255));
            }
            this.f10929b = b.CHAR;
            this.f10930c = null;
            this.f10931d = allocate;
        }

        /* renamed from: d */
        private void m13824d(int i) {
            this.f10930c.flip();
            IntBuffer allocate = IntBuffer.allocate(Math.max(this.f10930c.remaining() + i, this.f10930c.capacity() / 4));
            while (this.f10930c.hasRemaining()) {
                allocate.put(this.f10930c.get() & 255);
            }
            this.f10929b = b.INT;
            this.f10930c = null;
            this.f10932e = allocate;
        }

        /* renamed from: e */
        private void m13826e(int i) {
            this.f10931d.flip();
            IntBuffer allocate = IntBuffer.allocate(Math.max(this.f10931d.remaining() + i, this.f10931d.capacity() / 2));
            while (this.f10931d.hasRemaining()) {
                allocate.put(this.f10931d.get() & 65535);
            }
            this.f10929b = b.INT;
            this.f10931d = null;
            this.f10932e = allocate;
        }
    }
}
