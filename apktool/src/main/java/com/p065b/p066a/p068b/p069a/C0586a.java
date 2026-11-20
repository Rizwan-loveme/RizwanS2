package com.p065b.p066a.p068b.p069a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AndroidBinXmlParser.java */
/* renamed from: com.b.a.b.a.a */
/* loaded from: classes.dex */
public class C0586a {
    public static final int EVENT_END_DOCUMENT = 2;
    public static final int EVENT_END_ELEMENT = 4;
    public static final int EVENT_START_DOCUMENT = 1;
    public static final int EVENT_START_ELEMENT = 3;
    private static final long NO_NAMESPACE = 4294967295L;
    public static final int VALUE_TYPE_BOOLEAN = 4;
    public static final int VALUE_TYPE_INT = 2;
    public static final int VALUE_TYPE_REFERENCE = 3;
    public static final int VALUE_TYPE_STRING = 1;
    public static final int VALUE_TYPE_UNSUPPORTED = 0;

    /* renamed from: a */
    private int f3976a;

    /* renamed from: b */
    private int f3977b;

    /* renamed from: c */
    private List<a> f3978c;

    /* renamed from: d */
    private ByteBuffer f3979d;

    /* renamed from: e */
    private String f3980e;

    /* renamed from: f */
    private String f3981f;

    /* renamed from: g */
    private int f3982g = 1;

    /* renamed from: h */
    private int f3983h;

    /* renamed from: i */
    private c f3984i;

    /* renamed from: j */
    private d f3985j;

    /* renamed from: k */
    private final ByteBuffer f3986k;

    public C0586a(ByteBuffer byteBuffer) {
        b bVar;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.hasRemaining() && (bVar = b.m5836a(byteBuffer)) != null) {
            if (bVar.m5839c() == 3) {
                break;
            }
        }
        bVar = null;
        if (bVar == null) {
            throw new e("No XML chunk in file");
        }
        this.f3986k = bVar.m5837a();
    }

    /* renamed from: b */
    public int m5818b() {
        return this.f3983h;
    }

    /* renamed from: c */
    public int m5820c() {
        return this.f3982g;
    }

    /* renamed from: d */
    public String m5823d() {
        int i = this.f3982g;
        if (i == 3 || i == 4) {
            return this.f3980e;
        }
        return null;
    }

    /* renamed from: e */
    public String m5824e() {
        int i = this.f3982g;
        if (i == 3 || i == 4) {
            return this.f3981f;
        }
        return null;
    }

    /* renamed from: a */
    public int m5816a() {
        if (this.f3982g != 3) {
            return -1;
        }
        return this.f3977b;
    }

    /* renamed from: b */
    public int m5819b(int i) {
        return m5813e(i).m5828b();
    }

    /* renamed from: d */
    public int m5822d(int i) {
        int m5830d = m5813e(i).m5830d();
        if (m5830d == 1) {
            return 3;
        }
        if (m5830d == 3) {
            return 1;
        }
        switch (m5830d) {
            case 16:
            case 17:
                return 2;
            case 18:
                return 4;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public int m5817a(int i) {
        return m5813e(i).m5827a();
    }

    /* renamed from: c */
    public String m5821c(int i) {
        return m5813e(i).m5829c();
    }

    /* renamed from: e */
    private a m5813e(int i) {
        if (this.f3982g != 3) {
            throw new IndexOutOfBoundsException("Current event not a START_ELEMENT");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("index must be >= 0");
        }
        if (i >= this.f3977b) {
            throw new IndexOutOfBoundsException("index must be <= attr count (" + this.f3977b + ")");
        }
        m5815g();
        return this.f3978c.get(i);
    }

    /* renamed from: f */
    public int m5825f() {
        b m5836a;
        if (this.f3982g == 4) {
            this.f3983h--;
        }
        while (this.f3986k.hasRemaining() && (m5836a = b.m5836a(this.f3986k)) != null) {
            int m5839c = m5836a.m5839c();
            if (m5839c != 1) {
                if (m5839c != 384) {
                    if (m5839c == 258) {
                        if (this.f3985j == null) {
                            throw new e("Named element encountered before string pool");
                        }
                        ByteBuffer m5837a = m5836a.m5837a();
                        if (m5837a.remaining() < 20) {
                            throw new e("Start element chunk too short. Need at least 20 bytes. Available: " + m5837a.remaining() + " bytes");
                        }
                        long m5812e = m5812e(m5837a);
                        long m5812e2 = m5812e(m5837a);
                        int m5811d = m5811d(m5837a);
                        int m5811d2 = m5811d(m5837a);
                        int m5811d3 = m5811d(m5837a);
                        long j = m5811d;
                        long j2 = (m5811d3 * m5811d2) + j;
                        m5837a.position(0);
                        if (m5811d > m5837a.remaining()) {
                            throw new e("Attributes start offset out of bounds: " + m5811d + ", max: " + m5837a.remaining());
                        }
                        if (j2 > m5837a.remaining()) {
                            throw new e("Attributes end offset out of bounds: " + j2 + ", max: " + m5837a.remaining());
                        }
                        this.f3980e = this.f3985j.m5853a(m5812e2);
                        this.f3981f = m5812e != 4294967295L ? this.f3985j.m5853a(m5812e) : "";
                        this.f3977b = m5811d3;
                        this.f3978c = null;
                        this.f3976a = m5811d2;
                        this.f3979d = m5809b(m5837a, j, j2);
                        this.f3983h++;
                        this.f3982g = 3;
                        return 3;
                    }
                    if (m5839c == 259) {
                        if (this.f3985j == null) {
                            throw new e("Named element encountered before string pool");
                        }
                        ByteBuffer m5837a2 = m5836a.m5837a();
                        if (m5837a2.remaining() < 8) {
                            throw new e("End element chunk too short. Need at least 8 bytes. Available: " + m5837a2.remaining() + " bytes");
                        }
                        long m5812e3 = m5812e(m5837a2);
                        this.f3980e = this.f3985j.m5853a(m5812e(m5837a2));
                        this.f3981f = m5812e3 != 4294967295L ? this.f3985j.m5853a(m5812e3) : "";
                        this.f3982g = 4;
                        this.f3978c = null;
                        this.f3979d = null;
                        return 4;
                    }
                } else {
                    if (this.f3984i != null) {
                        throw new e("Multiple resource maps not supported");
                    }
                    this.f3984i = new c(m5836a);
                }
            } else {
                if (this.f3985j != null) {
                    throw new e("Multiple string pools not supported");
                }
                this.f3985j = new d(m5836a);
            }
        }
        this.f3982g = 2;
        return 2;
    }

    /* renamed from: g */
    private void m5815g() {
        if (this.f3978c == null) {
            this.f3978c = new ArrayList(this.f3977b);
            for (int i = 0; i < this.f3977b; i++) {
                int i2 = this.f3976a;
                int i3 = i * i2;
                ByteBuffer m5808b = m5808b(this.f3979d, i3, i2 + i3);
                long m5812e = m5812e(m5808b);
                long m5812e2 = m5812e(m5808b);
                m5808b.position(m5808b.position() + 7);
                this.f3978c.add(new a(m5812e, m5812e2, m5814f(m5808b), (int) m5812e(m5808b), this.f3985j, this.f3984i));
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.a.b.a.a$a */
    private static class a {
        private static final int TYPE_INT_BOOLEAN = 18;
        private static final int TYPE_INT_DEC = 16;
        private static final int TYPE_INT_HEX = 17;
        private static final int TYPE_REFERENCE = 1;
        private static final int TYPE_STRING = 3;

        /* renamed from: a */
        private final long f3987a;

        /* renamed from: b */
        private final long f3988b;

        /* renamed from: c */
        private final c f3989c;

        /* renamed from: d */
        private final d f3990d;

        /* renamed from: e */
        private final int f3991e;

        /* renamed from: f */
        private final int f3992f;

        private a(long j, long j2, int i, int i2, d dVar, c cVar) {
            this.f3988b = j;
            this.f3987a = j2;
            this.f3992f = i;
            this.f3991e = i2;
            this.f3990d = dVar;
            this.f3989c = cVar;
        }

        /* renamed from: b */
        public int m5828b() {
            c cVar = this.f3989c;
            if (cVar != null) {
                return cVar.m5844a(this.f3987a);
            }
            return 0;
        }

        /* renamed from: d */
        public int m5830d() {
            return this.f3992f;
        }

        /* renamed from: a */
        public int m5827a() {
            int i = this.f3992f;
            if (i != 1) {
                switch (i) {
                    case 16:
                    case 17:
                    case 18:
                        break;
                    default:
                        throw new e("Cannot coerce to int: value type " + this.f3992f);
                }
            }
            return this.f3991e;
        }

        /* renamed from: c */
        public String m5829c() {
            int i = this.f3992f;
            if (i == 1) {
                return "@" + Integer.toHexString(this.f3991e);
            }
            if (i == 3) {
                return this.f3990d.m5853a(this.f3991e & 4294967295L);
            }
            switch (i) {
                case 16:
                    return Integer.toString(this.f3991e);
                case 17:
                    return "0x" + Integer.toHexString(this.f3991e);
                case 18:
                    return Boolean.toString(this.f3991e != 0);
                default:
                    throw new e("Cannot coerce to string: value type " + this.f3992f);
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.a.b.a.a$b */
    private static class b {
        static final int HEADER_MIN_SIZE_BYTES = 8;
        public static final int RES_XML_TYPE_END_ELEMENT = 259;
        public static final int RES_XML_TYPE_RESOURCE_MAP = 384;
        public static final int RES_XML_TYPE_START_ELEMENT = 258;
        public static final int TYPE_RES_XML = 3;
        public static final int TYPE_STRING_POOL = 1;

        /* renamed from: a */
        private final ByteBuffer f3998a;

        /* renamed from: b */
        private final ByteBuffer f3999b;

        /* renamed from: c */
        private final int f4000c;

        public b(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            this.f4000c = i;
            this.f3999b = byteBuffer;
            this.f3998a = byteBuffer2;
        }

        /* renamed from: a */
        public ByteBuffer m5837a() {
            ByteBuffer slice = this.f3998a.slice();
            slice.order(this.f3998a.order());
            return slice;
        }

        /* renamed from: b */
        public ByteBuffer m5838b() {
            ByteBuffer slice = this.f3999b.slice();
            slice.order(this.f3999b.order());
            return slice;
        }

        /* renamed from: c */
        public int m5839c() {
            return this.f4000c;
        }

        /* renamed from: a */
        public static b m5836a(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() < 8) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            int position = byteBuffer.position();
            int m5811d = C0586a.m5811d(byteBuffer);
            int m5811d2 = C0586a.m5811d(byteBuffer);
            long m5812e = C0586a.m5812e(byteBuffer);
            if (m5812e - 8 > byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            if (m5811d2 < 8) {
                throw new e("Malformed chunk: header too short: " + m5811d2 + " bytes");
            }
            if (m5811d2 > m5812e) {
                throw new e("Malformed chunk: header too long: " + m5811d2 + " bytes. Chunk size: " + m5812e + " bytes");
            }
            int i = m5811d2 + position;
            long j = m5812e + position;
            b bVar = new b(m5811d, C0586a.m5808b(byteBuffer, position, i), C0586a.m5809b(byteBuffer, i, j));
            byteBuffer.position((int) j);
            return bVar;
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.a.b.a.a$d */
    private static class d {
        private static final int FLAG_UTF8 = 256;

        /* renamed from: a */
        private final Map<Integer, String> f4007a = new HashMap();

        /* renamed from: b */
        private final ByteBuffer f4008b;

        /* renamed from: c */
        private final int f4009c;

        /* renamed from: d */
        private final ByteBuffer f4010d;

        /* renamed from: e */
        private final boolean f4011e;

        public d(b bVar) {
            int remaining;
            ByteBuffer m5838b = bVar.m5838b();
            int remaining2 = m5838b.remaining();
            m5838b.position(8);
            if (m5838b.remaining() >= 20) {
                long m5812e = C0586a.m5812e(m5838b);
                if (m5812e > 2147483647L) {
                    throw new e("Too many strings: " + m5812e);
                }
                int i = (int) m5812e;
                this.f4009c = i;
                long m5812e2 = C0586a.m5812e(m5838b);
                if (m5812e2 <= 2147483647L) {
                    long m5812e3 = C0586a.m5812e(m5838b);
                    long m5812e4 = C0586a.m5812e(m5838b);
                    long m5812e5 = C0586a.m5812e(m5838b);
                    ByteBuffer m5837a = bVar.m5837a();
                    if (i > 0) {
                        long j = remaining2;
                        int i2 = (int) (m5812e4 - j);
                        if (m5812e2 <= 0) {
                            remaining = m5837a.remaining();
                        } else {
                            if (m5812e5 < m5812e4) {
                                throw new e("Styles offset (" + m5812e5 + ") < strings offset (" + m5812e4 + ")");
                            }
                            remaining = (int) (m5812e5 - j);
                        }
                        this.f4010d = C0586a.m5808b(m5837a, i2, remaining);
                    } else {
                        this.f4010d = ByteBuffer.allocate(0);
                    }
                    this.f4011e = (256 & m5812e3) != 0;
                    this.f4008b = m5837a;
                    return;
                }
                throw new e("Too many styles: " + m5812e2);
            }
            throw new e("XML chunk's header too short. Required at least 20 bytes. Available: " + m5838b.remaining() + " bytes");
        }

        /* renamed from: a */
        public String m5853a(long j) {
            if (j < 0) {
                throw new e("Unsuported string index: " + j);
            }
            if (j >= this.f4009c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsuported string index: ");
                sb.append(j);
                sb.append(", max: ");
                sb.append(this.f4009c - 1);
                throw new e(sb.toString());
            }
            int i = (int) j;
            String str = this.f4007a.get(Integer.valueOf(i));
            if (str == null) {
                long m5807b = C0586a.m5807b(this.f4008b, i * 4);
                if (m5807b >= this.f4010d.capacity()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Offset of string idx ");
                    sb2.append(i);
                    sb2.append(" out of bounds: ");
                    sb2.append(m5807b);
                    sb2.append(", max: ");
                    sb2.append(this.f4010d.capacity() - 1);
                    throw new e(sb2.toString());
                }
                this.f4010d.position((int) m5807b);
                if (this.f4011e) {
                    str = m5852b(this.f4010d);
                } else {
                    str = m5851a(this.f4010d);
                }
                this.f4007a.put(Integer.valueOf(i), str);
            }
            return str;
        }

        /* renamed from: a */
        private static String m5851a(ByteBuffer byteBuffer) {
            byte[] bArr;
            int i;
            int m5811d = C0586a.m5811d(byteBuffer);
            if ((32768 & m5811d) != 0) {
                m5811d = ((m5811d & 32767) << 16) | C0586a.m5811d(byteBuffer);
            }
            if (m5811d > 1073741823) {
                throw new e("String too long: " + m5811d + " uint16s");
            }
            int i2 = m5811d * 2;
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + i2);
            } else {
                bArr = new byte[i2];
                i = 0;
                byteBuffer.get(bArr);
            }
            int i3 = i + i2;
            if (bArr[i3] != 0 || bArr[i3 + 1] != 0) {
                throw new e("UTF-16 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArr, i, i2, "UTF-16LE");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF-16LE character encoding not supported", e2);
            }
        }

        /* renamed from: b */
        private static String m5852b(ByteBuffer byteBuffer) {
            byte[] bArr;
            int i;
            if ((C0586a.m5814f(byteBuffer) & 128) != 0) {
                C0586a.m5814f(byteBuffer);
            }
            int m5814f = C0586a.m5814f(byteBuffer);
            if ((m5814f & 128) != 0) {
                m5814f = ((m5814f & 127) << 8) | C0586a.m5814f(byteBuffer);
            }
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + m5814f);
            } else {
                bArr = new byte[m5814f];
                i = 0;
                byteBuffer.get(bArr);
            }
            if (bArr[i + m5814f] != 0) {
                throw new e("UTF-8 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArr, i, m5814f, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF-8 character encoding not supported", e2);
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.a.b.a.a$c */
    private static class c {

        /* renamed from: a */
        private final ByteBuffer f4001a;

        /* renamed from: b */
        private final int f4002b;

        public c(b bVar) {
            ByteBuffer slice = bVar.m5837a().slice();
            this.f4001a = slice;
            slice.order(bVar.m5837a().order());
            this.f4002b = slice.remaining() / 4;
        }

        /* renamed from: a */
        public int m5844a(long j) {
            if (j >= 0 && j < this.f4002b) {
                return this.f4001a.getInt(((int) j) * 4);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static ByteBuffer m5809b(ByteBuffer byteBuffer, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException("start: " + j);
        }
        if (j2 < j) {
            throw new IllegalArgumentException("end < start: " + j2 + " < " + j);
        }
        int capacity = byteBuffer.capacity();
        if (j2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + j2 + " > " + capacity);
        }
        return m5808b(byteBuffer, (int) j, (int) j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static ByteBuffer m5808b(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static int m5814f(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m5811d(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static long m5812e(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m5807b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.a.b.a.a$e */
    public static class e extends Exception {
        private static final long serialVersionUID = 1;

        public e(String str) {
            super(str);
        }

        public e(String str, Throwable th) {
            super(str, th);
        }
    }
}
