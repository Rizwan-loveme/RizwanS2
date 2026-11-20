package com.p065b.p111c.p113b.p114a;

import android.widget.ExpandableListView;
import com.p065b.p066a.p068b.p069a.C0586a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AndroidBinXmlParser.java */
/* renamed from: com.b.c.b.a.a */
/* loaded from: classes.dex */
public class C1042a {

    /* renamed from: a */
    private int f6552a;

    /* renamed from: b */
    private int f6553b;

    /* renamed from: c */
    private List<a> f6554c;

    /* renamed from: d */
    private ByteBuffer f6555d;

    /* renamed from: e */
    private String f6556e;

    /* renamed from: f */
    private String f6557f;

    /* renamed from: g */
    private int f6558g = 1;

    /* renamed from: h */
    private int f6559h;

    /* renamed from: i */
    private c f6560i;

    /* renamed from: j */
    private d f6561j;

    /* renamed from: k */
    private final ByteBuffer f6562k;

    public C1042a(ByteBuffer byteBuffer) {
        b m8674a;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        b bVar = null;
        while (true) {
            if (!byteBuffer.hasRemaining() || (m8674a = b.m8674a(byteBuffer)) == null) {
                break;
            } else if (m8674a.m8677c() == 3) {
                bVar = m8674a;
                break;
            }
        }
        if (bVar == null) {
            throw new e("No XML chunk in file");
        }
        this.f6562k = bVar.m8675a();
    }

    /* renamed from: b */
    public int m8659b() {
        return this.f6559h;
    }

    /* renamed from: c */
    public int m8661c() {
        return this.f6558g;
    }

    /* renamed from: d */
    public String m8664d() {
        if (this.f6558g == 3 || this.f6558g == 4) {
            return this.f6556e;
        }
        return null;
    }

    /* renamed from: e */
    public String m8665e() {
        if (this.f6558g == 3 || this.f6558g == 4) {
            return this.f6557f;
        }
        return null;
    }

    /* renamed from: a */
    public int m8657a() {
        if (this.f6558g != 3) {
            return -1;
        }
        return this.f6553b;
    }

    /* renamed from: b */
    public int m8660b(int i) {
        return m8654e(i).m8668b();
    }

    /* renamed from: d */
    public int m8663d(int i) {
        switch (m8654e(i).m8670d()) {
            case 1:
            case 16:
            case 17:
                return 2;
            case 3:
                return 1;
            case 18:
                return 4;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public int m8658a(int i) {
        return m8654e(i).m8667a();
    }

    /* renamed from: c */
    public String m8662c(int i) {
        return m8654e(i).m8669c();
    }

    /* renamed from: e */
    private a m8654e(int i) {
        if (this.f6558g != 3) {
            throw new IndexOutOfBoundsException("Current event not a START_ELEMENT");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("index must be >= 0");
        }
        if (i >= this.f6553b) {
            throw new IndexOutOfBoundsException("index must be <= attr count (" + this.f6553b + ")");
        }
        m8656g();
        return this.f6554c.get(i);
    }

    /* renamed from: f */
    public int m8666f() {
        b m8674a;
        if (this.f6558g == 4) {
            this.f6559h--;
        }
        while (this.f6562k.hasRemaining() && (m8674a = b.m8674a(this.f6562k)) != null) {
            switch (m8674a.m8677c()) {
                case 1:
                    if (this.f6561j != null) {
                        throw new e("Multiple string pools not supported");
                    }
                    this.f6561j = new d(m8674a);
                    break;
                case 258:
                    if (this.f6561j == null) {
                        throw new e("Named element encountered before string pool");
                    }
                    ByteBuffer m8675a = m8674a.m8675a();
                    if (m8675a.remaining() < 20) {
                        throw new e("Start element chunk too short. Need at least 20 bytes. Available: " + m8675a.remaining() + " bytes");
                    }
                    long m8653e = m8653e(m8675a);
                    long m8653e2 = m8653e(m8675a);
                    int m8652d = m8652d(m8675a);
                    int m8652d2 = m8652d(m8675a);
                    int m8652d3 = m8652d(m8675a);
                    long j = m8652d + (m8652d3 * m8652d2);
                    m8675a.position(0);
                    if (m8652d > m8675a.remaining()) {
                        throw new e("Attributes start offset out of bounds: " + m8652d + ", max: " + m8675a.remaining());
                    }
                    if (j > m8675a.remaining()) {
                        throw new e("Attributes end offset out of bounds: " + j + ", max: " + m8675a.remaining());
                    }
                    this.f6556e = this.f6561j.m8752a(m8653e2);
                    this.f6557f = m8653e == ExpandableListView.PACKED_POSITION_VALUE_NULL ? "" : this.f6561j.m8752a(m8653e);
                    this.f6553b = m8652d3;
                    this.f6554c = null;
                    this.f6552a = m8652d2;
                    this.f6555d = m8650b(m8675a, m8652d, j);
                    this.f6559h++;
                    this.f6558g = 3;
                    return this.f6558g;
                case 259:
                    if (this.f6561j == null) {
                        throw new e("Named element encountered before string pool");
                    }
                    ByteBuffer m8675a2 = m8674a.m8675a();
                    if (m8675a2.remaining() < 8) {
                        throw new e("End element chunk too short. Need at least 8 bytes. Available: " + m8675a2.remaining() + " bytes");
                    }
                    long m8653e3 = m8653e(m8675a2);
                    this.f6556e = this.f6561j.m8752a(m8653e(m8675a2));
                    this.f6557f = m8653e3 == ExpandableListView.PACKED_POSITION_VALUE_NULL ? "" : this.f6561j.m8752a(m8653e3);
                    this.f6558g = 4;
                    this.f6554c = null;
                    this.f6555d = null;
                    return this.f6558g;
                case C0586a.b.RES_XML_TYPE_RESOURCE_MAP /* 384 */:
                    if (this.f6560i != null) {
                        throw new e("Multiple resource maps not supported");
                    }
                    this.f6560i = new c(m8674a);
                    break;
            }
        }
        this.f6558g = 2;
        return this.f6558g;
    }

    /* renamed from: g */
    private void m8656g() {
        if (this.f6554c == null) {
            this.f6554c = new ArrayList(this.f6553b);
            for (int i = 0; i < this.f6553b; i++) {
                int i2 = this.f6552a * i;
                ByteBuffer m8649b = m8649b(this.f6555d, i2, this.f6552a + i2);
                m8653e(m8649b);
                long m8653e = m8653e(m8649b);
                m8649b.position(m8649b.position() + 7);
                this.f6554c.add(new a(m8653e, m8655f(m8649b), (int) m8653e(m8649b), this.f6561j, this.f6560i, null));
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.c.b.a.a$a */
    private static class a {

        /* renamed from: a */
        private final long f6563a;

        /* renamed from: b */
        private final c f6564b;

        /* renamed from: c */
        private final d f6565c;

        /* renamed from: d */
        private final int f6566d;

        /* renamed from: e */
        private final int f6567e;

        private a(long j, int i, int i2, d dVar, c cVar) {
            this.f6563a = j;
            this.f6567e = i;
            this.f6566d = i2;
            this.f6565c = dVar;
            this.f6564b = cVar;
        }

        /* synthetic */ a(long j, int i, int i2, d dVar, c cVar, a aVar) {
            this(j, i, i2, dVar, cVar);
        }

        /* renamed from: b */
        public int m8668b() {
            if (this.f6564b != null) {
                return this.f6564b.m8696a(this.f6563a);
            }
            return 0;
        }

        /* renamed from: d */
        public int m8670d() {
            return this.f6567e;
        }

        /* renamed from: a */
        public int m8667a() {
            switch (this.f6567e) {
                case 1:
                case 16:
                case 17:
                case 18:
                    return this.f6566d;
                default:
                    throw new e("Cannot coerce to int: value type " + this.f6567e);
            }
        }

        /* renamed from: c */
        public String m8669c() {
            switch (this.f6567e) {
                case 1:
                    return "@" + Integer.toHexString(this.f6566d);
                case 3:
                    return this.f6565c.m8752a(this.f6566d & ExpandableListView.PACKED_POSITION_VALUE_NULL);
                case 16:
                    return Integer.toString(this.f6566d);
                case 17:
                    return "0x" + Integer.toHexString(this.f6566d);
                case 18:
                    return Boolean.toString(this.f6566d != 0);
                default:
                    throw new e("Cannot coerce to string: value type " + this.f6567e);
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.c.b.a.a$b */
    private static class b {

        /* renamed from: a */
        private final ByteBuffer f6574a;

        /* renamed from: b */
        private final ByteBuffer f6575b;

        /* renamed from: c */
        private final int f6576c;

        public b(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            this.f6576c = i;
            this.f6575b = byteBuffer;
            this.f6574a = byteBuffer2;
        }

        /* renamed from: a */
        public ByteBuffer m8675a() {
            ByteBuffer slice = this.f6574a.slice();
            slice.order(this.f6574a.order());
            return slice;
        }

        /* renamed from: b */
        public ByteBuffer m8676b() {
            ByteBuffer slice = this.f6575b.slice();
            slice.order(this.f6575b.order());
            return slice;
        }

        /* renamed from: c */
        public int m8677c() {
            return this.f6576c;
        }

        /* renamed from: a */
        public static b m8674a(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() < 8) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            int position = byteBuffer.position();
            int m8652d = C1042a.m8652d(byteBuffer);
            int m8652d2 = C1042a.m8652d(byteBuffer);
            long m8653e = C1042a.m8653e(byteBuffer);
            if (m8653e - 8 > byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            if (m8652d2 < 8) {
                throw new e("Malformed chunk: header too short: " + m8652d2 + " bytes");
            }
            if (m8652d2 > m8653e) {
                throw new e("Malformed chunk: header too long: " + m8652d2 + " bytes. Chunk size: " + m8653e + " bytes");
            }
            int i = position + m8652d2;
            long j = m8653e + position;
            b bVar = new b(m8652d, C1042a.m8649b(byteBuffer, position, i), C1042a.m8650b(byteBuffer, i, j));
            byteBuffer.position((int) j);
            return bVar;
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.c.b.a.a$d */
    private static class d {

        /* renamed from: a */
        private final Map<Integer, String> f6615a = new HashMap();

        /* renamed from: b */
        private final ByteBuffer f6616b;

        /* renamed from: c */
        private final int f6617c;

        /* renamed from: d */
        private final ByteBuffer f6618d;

        /* renamed from: e */
        private final boolean f6619e;

        public d(b bVar) {
            int remaining;
            ByteBuffer m8676b = bVar.m8676b();
            int remaining2 = m8676b.remaining();
            m8676b.position(8);
            if (m8676b.remaining() < 20) {
                throw new e("XML chunk's header too short. Required at least 20 bytes. Available: " + m8676b.remaining() + " bytes");
            }
            long m8653e = C1042a.m8653e(m8676b);
            if (m8653e > 2147483647L) {
                throw new e("Too many strings: " + m8653e);
            }
            this.f6617c = (int) m8653e;
            long m8653e2 = C1042a.m8653e(m8676b);
            if (m8653e2 > 2147483647L) {
                throw new e("Too many styles: " + m8653e2);
            }
            long m8653e3 = C1042a.m8653e(m8676b);
            long m8653e4 = C1042a.m8653e(m8676b);
            long m8653e5 = C1042a.m8653e(m8676b);
            ByteBuffer m8675a = bVar.m8675a();
            if (this.f6617c > 0) {
                int i = (int) (m8653e4 - remaining2);
                if (m8653e2 <= 0) {
                    remaining = m8675a.remaining();
                } else {
                    if (m8653e5 < m8653e4) {
                        throw new e("Styles offset (" + m8653e5 + ") < strings offset (" + m8653e4 + ")");
                    }
                    remaining = (int) (m8653e5 - remaining2);
                }
                this.f6618d = C1042a.m8649b(m8675a, i, remaining);
            } else {
                this.f6618d = ByteBuffer.allocate(0);
            }
            this.f6619e = (256 & m8653e3) != 0;
            this.f6616b = m8675a;
        }

        /* renamed from: a */
        public String m8752a(long j) {
            if (j < 0) {
                throw new e("Unsuported string index: " + j);
            }
            if (j >= this.f6617c) {
                throw new e("Unsuported string index: " + j + ", max: " + (this.f6617c - 1));
            }
            int i = (int) j;
            String str = this.f6615a.get(Integer.valueOf(i));
            if (str == null) {
                long m8648b = C1042a.m8648b(this.f6616b, i * 4);
                if (m8648b >= this.f6618d.capacity()) {
                    throw new e("Offset of string idx " + i + " out of bounds: " + m8648b + ", max: " + (this.f6618d.capacity() - 1));
                }
                this.f6618d.position((int) m8648b);
                if (this.f6619e) {
                    str = m8751b(this.f6618d);
                } else {
                    str = m8750a(this.f6618d);
                }
                this.f6615a.put(Integer.valueOf(i), str);
            }
            return str;
        }

        /* renamed from: a */
        private static String m8750a(ByteBuffer byteBuffer) {
            byte[] bArr;
            int i;
            int m8652d = C1042a.m8652d(byteBuffer);
            if ((32768 & m8652d) != 0) {
                m8652d = ((m8652d & 32767) << 16) | C1042a.m8652d(byteBuffer);
            }
            if (m8652d > 1073741823) {
                throw new e("String too long: " + m8652d + " uint16s");
            }
            int i2 = m8652d * 2;
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + i2);
            } else {
                bArr = new byte[i2];
                i = 0;
                byteBuffer.get(bArr);
            }
            if (bArr[i + i2] != 0 || bArr[i + i2 + 1] != 0) {
                throw new e("UTF-16 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArr, i, i2, "UTF-16LE");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF-16LE character encoding not supported", e2);
            }
        }

        /* renamed from: b */
        private static String m8751b(ByteBuffer byteBuffer) {
            byte[] bArr;
            int i;
            if ((C1042a.m8655f(byteBuffer) & 128) != 0) {
                C1042a.m8655f(byteBuffer);
            }
            int m8655f = C1042a.m8655f(byteBuffer);
            if ((m8655f & 128) != 0) {
                m8655f = ((m8655f & 127) << 8) | C1042a.m8655f(byteBuffer);
            }
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + m8655f);
            } else {
                bArr = new byte[m8655f];
                i = 0;
                byteBuffer.get(bArr);
            }
            if (bArr[i + m8655f] != 0) {
                throw new e("UTF-8 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArr, i, m8655f, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF-8 character encoding not supported", e2);
            }
        }
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.c.b.a.a$c */
    private static class c {

        /* renamed from: a */
        private final ByteBuffer f6589a;

        /* renamed from: b */
        private final int f6590b;

        public c(b bVar) {
            this.f6589a = bVar.m8675a().slice();
            this.f6589a.order(bVar.m8675a().order());
            this.f6590b = this.f6589a.remaining() / 4;
        }

        /* renamed from: a */
        public int m8696a(long j) {
            if (j < 0 || j >= this.f6590b) {
                return 0;
            }
            return this.f6589a.getInt(((int) j) * 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static ByteBuffer m8650b(ByteBuffer byteBuffer, long j, long j2) {
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
        return m8649b(byteBuffer, (int) j, (int) j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static ByteBuffer m8649b(ByteBuffer byteBuffer, int i, int i2) {
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
    public static int m8655f(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m8652d(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static long m8653e(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m8648b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* compiled from: AndroidBinXmlParser.java */
    /* renamed from: com.b.c.b.a.a$e */
    public static class e extends Exception {
        public e(String str) {
            super(str);
        }
    }
}
