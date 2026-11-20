package com.p140g.p141a.p148e;

import com.p140g.p141a.C1236a;
import com.p140g.p141a.C1238b;
import com.p140g.p141a.C1241c;
import com.p140g.p141a.C1249d;
import com.p140g.p141a.C1280e;
import com.p140g.p141a.C1287f;
import com.p140g.p141a.C1292g;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p145d.C1250a;
import com.p140g.p141a.p149f.C1288a;
import com.p140g.p141a.p151g.C1295c;
import com.p140g.p141a.p151g.C1296d;
import com.p140g.p141a.p151g.C1297e;
import com.p140g.p141a.p151g.C1298f;
import com.p140g.p141a.p151g.C1299g;
import com.p140g.p141a.p151g.C1300h;
import com.p140g.p141a.p151g.InterfaceC1293a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.UTFDataFormatException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: DexFileReader.java */
/* renamed from: com.g.a.e.b */
/* loaded from: classes.dex */
public class C1282b implements InterfaceC1281a {

    /* renamed from: A */
    private final int f8182A;

    /* renamed from: a */
    final ByteBuffer f8183a;

    /* renamed from: b */
    final ByteBuffer f8184b;

    /* renamed from: c */
    final ByteBuffer f8185c;

    /* renamed from: d */
    final ByteBuffer f8186d;

    /* renamed from: e */
    final ByteBuffer f8187e;

    /* renamed from: f */
    final ByteBuffer f8188f;

    /* renamed from: g */
    final ByteBuffer f8189g;

    /* renamed from: h */
    final ByteBuffer f8190h;

    /* renamed from: i */
    final ByteBuffer f8191i;

    /* renamed from: j */
    final ByteBuffer f8192j;

    /* renamed from: k */
    final ByteBuffer f8193k;

    /* renamed from: l */
    final ByteBuffer f8194l;

    /* renamed from: m */
    final ByteBuffer f8195m;

    /* renamed from: n */
    final ByteBuffer f8196n;

    /* renamed from: o */
    final ByteBuffer f8197o;

    /* renamed from: p */
    final ByteBuffer f8198p;

    /* renamed from: q */
    final ByteBuffer f8199q;

    /* renamed from: r */
    final ByteBuffer f8200r;

    /* renamed from: s */
    final int f8201s;

    /* renamed from: t */
    final int f8202t;

    /* renamed from: u */
    final int f8203u;

    /* renamed from: v */
    final int f8204v;

    /* renamed from: w */
    final int f8205w;

    /* renamed from: x */
    final int f8206x;

    /* renamed from: y */
    final int f8207y;

    /* renamed from: z */
    final int f8208z;

    /* renamed from: b */
    private static void m10425b(String str, Object... objArr) {
    }

    public C1282b(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        ByteBuffer order = byteBuffer.asReadOnlyBuffer().order(ByteOrder.BIG_ENDIAN);
        int i = order.getInt() & (-256);
        if (i != 1684371456) {
            if (i == 1684371712) {
                throw new C1236a("Not support odex");
            }
            throw new C1236a("not support magic.");
        }
        int i2 = order.getInt() >> 8;
        if (i2 < 0 || i2 < 3158837) {
            throw new C1236a("not support version.");
        }
        this.f8208z = i2;
        order.order(ByteOrder.LITTLE_ENDIAN);
        m10415a(order, 32);
        if (order.getInt() != 305419896) {
            throw new C1236a("not support endian_tag");
        }
        m10415a(order, 8);
        int i3 = order.getInt();
        this.f8201s = order.getInt();
        int i4 = order.getInt();
        this.f8202t = order.getInt();
        int i5 = order.getInt();
        this.f8203u = order.getInt();
        int i6 = order.getInt();
        this.f8204v = order.getInt();
        int i7 = order.getInt();
        this.f8205w = order.getInt();
        int i8 = order.getInt();
        this.f8182A = order.getInt();
        int i9 = order.getInt();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        if (this.f8208z > 3158839) {
            order.position(i3);
            int i14 = order.getInt();
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = order.getShort() & 65535;
                order.getShort();
                int i17 = order.getInt();
                int i18 = order.getInt();
                switch (i16) {
                    case 7:
                        i11 = i17;
                        i10 = i18;
                        break;
                    case 8:
                        i13 = i17;
                        i12 = i18;
                        break;
                }
            }
        }
        this.f8206x = i11;
        this.f8207y = i13;
        this.f8190h = m10408a(order, i4, this.f8201s * 4);
        this.f8191i = m10408a(order, i5, this.f8202t * 4);
        this.f8192j = m10408a(order, i6, this.f8203u * 12);
        this.f8193k = m10408a(order, i7, this.f8204v * 8);
        this.f8194l = m10408a(order, i8, this.f8205w * 8);
        this.f8195m = m10408a(order, i9, this.f8182A * 32);
        this.f8199q = m10408a(order, i10, i11 * 4);
        this.f8200r = m10408a(order, i12, i13 * 8);
        order.position(0);
        this.f8184b = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8185c = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8186d = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8183a = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8187e = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8188f = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8197o = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8189g = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8196n = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        this.f8198p = order.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    }

    public C1282b(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    /* renamed from: c */
    private static int m10427c(ByteBuffer byteBuffer) {
        return m10403a(byteBuffer) - 1;
    }

    /* renamed from: a */
    private static ByteBuffer m10408a(ByteBuffer byteBuffer, int i, int i2) {
        byteBuffer.position(i);
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(i2);
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return slice;
    }

    /* renamed from: a */
    private static void m10415a(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: a */
    public static void m10414a(Throwable th, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i + 1; i2++) {
            sb.append(".");
        }
        sb.append(' ');
        if (th instanceof C1236a) {
            sb.append(th.getMessage());
            System.err.println(sb.toString());
            if (th.getCause() != null) {
                m10414a(th.getCause(), i + 1);
                return;
            }
            return;
        }
        if (th != null) {
            System.err.println(sb.append("ROOT cause:").toString());
            th.printStackTrace(System.err);
        }
    }

    /* renamed from: b */
    private static long m10423b(ByteBuffer byteBuffer, int i) {
        int i2 = ((i >> 5) & 7) + 1;
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (byteBuffer.get() & 255) << (i3 * 8);
        }
        int i4 = (8 - i2) * 8;
        return (j << i4) >> i4;
    }

    /* renamed from: c */
    private static long m10429c(ByteBuffer byteBuffer, int i) {
        long j = 0;
        for (int i2 = 0; i2 < ((i >> 5) & 7) + 1; i2++) {
            j |= (byteBuffer.get() & 255) << (i2 * 8);
        }
        return j;
    }

    /* renamed from: d */
    private static long m10432d(ByteBuffer byteBuffer, int i) {
        int i2 = ((i >> 5) & 7) + 1;
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (byteBuffer.get() & 255) << (i3 * 8);
        }
        return j << ((8 - i2) * 8);
    }

    /* renamed from: a */
    static int m10406a(byte[] bArr, int i) {
        return (bArr[i + 1] << 8) | (bArr[i] & 255);
    }

    /* renamed from: b */
    static int m10422b(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: c */
    static int m10428c(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: d */
    static int m10431d(byte[] bArr, int i) {
        return m10428c(bArr, i);
    }

    /* renamed from: a */
    static void m10413a(String str, Object... objArr) {
        System.err.println(String.format(str, objArr));
    }

    /* renamed from: e */
    static int m10435e(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    /* renamed from: f */
    static int m10438f(byte[] bArr, int i) {
        return bArr[i];
    }

    /* renamed from: a */
    private static void m10417a(Map<Integer, C1238b> map, int i) {
        if (map.containsKey(new Integer(i))) {
            return;
        }
        map.put(new Integer(i), new C1238b(i));
    }

    /* renamed from: a */
    public static int m10403a(ByteBuffer byteBuffer) {
        int i = 0;
        byte b2 = byteBuffer.get();
        int i2 = 0;
        while (true) {
            int i3 = i;
            if ((b2 & 128) != 0) {
                i = i3 | ((b2 & Byte.MAX_VALUE) << i2);
                i2 += 7;
                b2 = byteBuffer.get();
            } else {
                return ((b2 & Byte.MAX_VALUE) << i2) | i3;
            }
        }
    }

    /* renamed from: b */
    public static int m10421b(ByteBuffer byteBuffer) {
        byte b2;
        int i = 0;
        int i2 = 0;
        do {
            b2 = byteBuffer.get();
            i |= (b2 & Byte.MAX_VALUE) << i2;
            i2 += 7;
        } while ((b2 & 128) != 0);
        if (((1 << (i2 - 1)) & i) != 0) {
            return (int) (i - (1 << i2));
        }
        return i;
    }

    /* renamed from: a */
    private void m10409a(int i, int i2, boolean z, C1280e c1280e, Map<Integer, C1238b> map, C1297e c1297e) {
        ByteBuffer byteBuffer = this.f8198p;
        byteBuffer.position(i);
        int m10403a = m10403a(byteBuffer);
        int m10403a2 = m10403a(byteBuffer);
        b[] bVarArr = new b[i2];
        int i3 = 0;
        for (String str : c1280e.m10400e()) {
            i3 = (str.equals("J") || str.equals("D")) ? i3 + 2 : i3 + 1;
        }
        int i4 = i2 - i3;
        if (!z) {
            bVarArr[i4 - 1] = new b("this", c1280e.m10399d(), (String) null);
            m10425b("v%d :%s, %s", new Integer(i4 - 1), "this", c1280e.m10399d());
        }
        String[] m10400e = c1280e.m10400e();
        int i5 = 0;
        while (i5 < m10403a2) {
            String str2 = m10400e[i5];
            String m10441g = m10441g(m10427c(byteBuffer));
            bVarArr[i4] = new b(m10441g, str2);
            if (m10441g != null) {
                c1297e.mo10382a(i5, m10441g);
            }
            m10425b("v%d :%s, %s", new Integer(i4), m10441g, str2);
            int i6 = i4 + 1;
            if (str2.equals("J") || str2.equals("D")) {
                i6++;
            }
            i5++;
            i4 = i6;
        }
        int i7 = m10403a;
        int i8 = 0;
        while (true) {
            int i9 = byteBuffer.get() & 255;
            switch (i9) {
                case 0:
                    return;
                case 1:
                    i8 = m10403a(byteBuffer) + i8;
                    break;
                case 2:
                    i7 = m10421b(byteBuffer) + i7;
                    break;
                case 3:
                    int m10403a3 = m10403a(byteBuffer);
                    int m10427c = m10427c(byteBuffer);
                    int m10427c2 = m10427c(byteBuffer);
                    String m10441g2 = m10441g(m10427c);
                    String m10442h = m10442h(m10427c2);
                    m10425b("Start: v%d :%s, %s", new Integer(m10403a3), m10441g2, m10442h);
                    bVarArr[m10403a3] = new b(m10441g2, m10442h);
                    m10417a(map, i8);
                    c1297e.mo10381a(m10403a3, map.get(new Integer(i8)), m10441g2, m10442h, (String) null);
                    break;
                case 4:
                    int m10403a4 = m10403a(byteBuffer);
                    int m10427c3 = m10427c(byteBuffer);
                    int m10427c4 = m10427c(byteBuffer);
                    int m10427c5 = m10427c(byteBuffer);
                    String m10441g3 = m10441g(m10427c3);
                    String m10442h2 = m10442h(m10427c4);
                    String m10441g4 = m10441g(m10427c5);
                    m10425b("Start: v%d :%s, %s // %s", new Integer(m10403a4), m10441g3, m10442h2, m10441g4);
                    b bVar = new b(m10441g3, m10442h2, m10441g4);
                    m10417a(map, i8);
                    c1297e.mo10381a(m10403a4, map.get(new Integer(i8)), m10441g3, m10442h2, m10441g4);
                    bVarArr[m10403a4] = bVar;
                    break;
                case 5:
                    int m10403a5 = m10403a(byteBuffer);
                    b bVar2 = bVarArr[m10403a5];
                    if (bVar2 == null) {
                        throw new RuntimeException(new StringBuffer().append("Encountered RESTART_LOCAL on new v").append(m10403a5).toString());
                    }
                    if (bVar2.f8211c == null) {
                        m10425b("End: v%d :%s, %s", new Integer(m10403a5), bVar2.f8209a, bVar2.f8210b);
                    } else {
                        m10425b("End: v%d :%s, %s // %s", new Integer(m10403a5), bVar2.f8209a, bVar2.f8210b, bVar2.f8211c);
                    }
                    m10417a(map, i8);
                    c1297e.mo10389c(m10403a5, map.get(new Integer(i8)));
                    break;
                case 6:
                    int m10403a6 = m10403a(byteBuffer);
                    b bVar3 = bVarArr[m10403a6];
                    if (bVar3 == null) {
                        throw new RuntimeException(new StringBuffer().append("Encountered RESTART_LOCAL on new v").append(m10403a6).toString());
                    }
                    if (bVar3.f8211c == null) {
                        m10425b("Start: v%d :%s, %s", new Integer(m10403a6), bVar3.f8209a, bVar3.f8210b);
                    } else {
                        m10425b("Start: v%d :%s, %s // %s", new Integer(m10403a6), bVar3.f8209a, bVar3.f8210b, bVar3.f8211c);
                    }
                    m10417a(map, i8);
                    c1297e.mo10380a(m10403a6, map.get(new Integer(i8)));
                    break;
                case 7:
                    m10417a(map, i8);
                    c1297e.mo10383a(map.get(new Integer(i8)));
                    break;
                case 8:
                    m10417a(map, i8);
                    c1297e.mo10388b(map.get(new Integer(i8)));
                    break;
                case 9:
                    break;
                default:
                    if (i9 < 10) {
                        throw new RuntimeException(new StringBuffer().append("Invalid extended opcode encountered ").append(i9).toString());
                    }
                    int i10 = i8 + ((i9 - 10) / 15);
                    int i11 = i7 + ((r1 % 15) - 4);
                    m10417a(map, i10);
                    c1297e.mo10387b(i11, map.get(new Integer(i10)));
                    i7 = i11;
                    i8 = i10;
                    break;
            }
        }
    }

    /* renamed from: a */
    public List<String> m10445a() {
        ArrayList arrayList = new ArrayList(this.f8182A);
        ByteBuffer byteBuffer = this.f8195m;
        for (int i = 0; i < this.f8182A; i++) {
            byteBuffer.position(i * 32);
            arrayList.add(m10442h(byteBuffer.getInt()));
        }
        return arrayList;
    }

    @Override // com.p140g.p141a.p148e.InterfaceC1281a
    /* renamed from: a */
    public void mo10402a(C1299g c1299g, int i) {
        c1299g.mo10392a(this.f8208z);
        for (int i2 = 0; i2 < this.f8182A; i2++) {
            m10447a(c1299g, i2, i);
        }
        c1299g.m10477a();
    }

    /* renamed from: a */
    public void m10447a(C1299g c1299g, int i, int i2) {
        this.f8195m.position(i * 32);
        int i3 = this.f8195m.getInt();
        int i4 = this.f8195m.getInt();
        int i5 = this.f8195m.getInt();
        int i6 = this.f8195m.getInt();
        int i7 = this.f8195m.getInt();
        int i8 = this.f8195m.getInt();
        int i9 = this.f8195m.getInt();
        int i10 = this.f8195m.getInt();
        String m10442h = m10442h(i3);
        if (!m10444a(m10442h).booleanValue()) {
            try {
                C1295c mo10391a = c1299g.mo10391a(i4, m10442h, m10442h(i5), m10434d(i6));
                if (mo10391a != null) {
                    m10412a(mo10391a, i7, i8, i9, i10, i2);
                    mo10391a.m10473a();
                }
            } catch (Exception e2) {
                C1236a c1236a = new C1236a(e2, "Error process class: [%d]%s", new Integer(i3), m10442h);
                if ((i2 & 32) != 0) {
                    m10414a(c1236a, 0);
                    return;
                }
                throw c1236a;
            }
        }
    }

    /* renamed from: a */
    public Boolean m10444a(String str) {
        return new Boolean(false);
    }

    /* renamed from: d */
    private Object m10433d(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & 255;
        switch (i & 31) {
            case 0:
                return new Byte((byte) m10423b(byteBuffer, i));
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            default:
                throw new C1236a("Not support yet.");
            case 2:
                return new Short((short) m10423b(byteBuffer, i));
            case 3:
                return new Character((char) m10429c(byteBuffer, i));
            case 4:
                return new Integer((int) m10423b(byteBuffer, i));
            case 6:
                return new Long(m10423b(byteBuffer, i));
            case 16:
                return new Float(Float.intBitsToFloat((int) (m10432d(byteBuffer, i) >> 32)));
            case 17:
                return new Double(Double.longBitsToDouble(m10432d(byteBuffer, i)));
            case 21:
                return m10436e((int) m10429c(byteBuffer, i));
            case 22:
                return m10407a((int) m10429c(byteBuffer, i));
            case 23:
                return m10441g((int) m10429c(byteBuffer, i));
            case 24:
                return new C1241c(m10442h((int) m10429c(byteBuffer, i)));
            case 25:
                return m10430c((int) m10429c(byteBuffer, i));
            case 26:
                return m10440f((int) m10429c(byteBuffer, i));
            case 27:
                return m10430c((int) m10429c(byteBuffer, i));
            case 28:
                return m10437e(byteBuffer);
            case 29:
                return m10439f(byteBuffer);
            case 30:
                return (Object) null;
            case 31:
                return new Boolean(((i >> 5) & 3) != 0);
        }
    }

    /* renamed from: a */
    private C1287f m10407a(int i) {
        this.f8200r.position(i * 8);
        int i2 = this.f8200r.getShort() & 65535;
        this.f8200r.getShort();
        int i3 = 65535 & this.f8200r.getShort();
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return new C1287f(i2, m10430c(i3));
            case 4:
            case 5:
                return new C1287f(i2, m10440f(i3));
            default:
                throw new RuntimeException();
        }
    }

    /* renamed from: a */
    private void m10412a(C1295c c1295c, int i, int i2, int i3, int i4, int i5) {
        Map<Integer, Integer> map;
        Map<Integer, Integer> map2;
        Map<Integer, Integer> map3;
        if ((i5 & 1) == 0 && i != -1) {
            c1295c.mo10356a(m10441g(i));
        }
        if ((i5 & 8) == 0) {
            map3 = new HashMap<>();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (i2 != 0) {
                this.f8184b.position(i2);
                int i6 = this.f8184b.getInt();
                int i7 = this.f8184b.getInt();
                int i8 = this.f8184b.getInt();
                int i9 = this.f8184b.getInt();
                for (int i10 = 0; i10 < i7; i10++) {
                    map3.put(new Integer(this.f8184b.getInt()), new Integer(this.f8184b.getInt()));
                }
                for (int i11 = 0; i11 < i8; i11++) {
                    hashMap.put(new Integer(this.f8184b.getInt()), new Integer(this.f8184b.getInt()));
                }
                for (int i12 = 0; i12 < i9; i12++) {
                    hashMap2.put(new Integer(this.f8184b.getInt()), new Integer(this.f8184b.getInt()));
                }
                if (i6 != 0) {
                    try {
                        m10410a(i6, c1295c);
                    } catch (Exception e2) {
                        throw new C1236a("error on reading Annotation of class ", e2);
                    }
                }
            }
            map = hashMap2;
            map2 = hashMap;
        } else {
            map = (Map) null;
            map2 = (Map) null;
            map3 = (Map) null;
        }
        if (i3 == 0) {
            return;
        }
        ByteBuffer byteBuffer = this.f8187e;
        byteBuffer.position(i3);
        int m10403a = m10403a(byteBuffer);
        int m10403a2 = m10403a(byteBuffer);
        int m10403a3 = m10403a(byteBuffer);
        int m10403a4 = m10403a(byteBuffer);
        int i13 = 0;
        Object[] m10426b = ((i5 & 16) != 0 || i4 == 0) ? (Object[]) null : m10426b(i4);
        for (int i14 = 0; i14 < m10403a; i14++) {
            Object obj = (Object) null;
            if (m10426b != null && i14 < m10426b.length) {
                obj = m10426b[i14];
            }
            i13 = m10404a(byteBuffer, i13, c1295c, map3, obj, i5);
        }
        int i15 = 0;
        for (int i16 = 0; i16 < m10403a2; i16++) {
            i15 = m10404a(byteBuffer, i15, c1295c, map3, (Object) null, i5);
        }
        int i17 = 0;
        boolean z = true;
        for (int i18 = 0; i18 < m10403a3; i18++) {
            i17 = m10405a(byteBuffer, i17, c1295c, map2, map, i5, z);
            z = false;
        }
        int i19 = 0;
        boolean z2 = true;
        int i20 = 0;
        while (true) {
            int i21 = i20;
            if (i21 >= m10403a4) {
                return;
            }
            i19 = m10405a(byteBuffer, i19, c1295c, map2, map, i5, z2);
            z2 = false;
            i20 = i21 + 1;
        }
    }

    /* renamed from: b */
    private Object[] m10426b(int i) {
        this.f8189g.position(i);
        return m10437e(this.f8189g);
    }

    /* renamed from: e */
    private Object[] m10437e(ByteBuffer byteBuffer) {
        int m10403a = m10403a(byteBuffer);
        Object[] objArr = new Object[m10403a];
        for (int i = 0; i < m10403a; i++) {
            objArr[i] = m10433d(byteBuffer);
        }
        return objArr;
    }

    /* renamed from: a */
    private void m10410a(int i, InterfaceC1293a interfaceC1293a) {
        ByteBuffer byteBuffer = this.f8185c;
        byteBuffer.position(i);
        int i2 = byteBuffer.getInt();
        for (int i3 = 0; i3 < i2; i3++) {
            m10424b(byteBuffer.getInt(), interfaceC1293a);
        }
    }

    /* renamed from: b */
    private void m10424b(int i, InterfaceC1293a interfaceC1293a) {
        ByteBuffer byteBuffer = this.f8186d;
        byteBuffer.position(i);
        int i2 = byteBuffer.get() & 255;
        C1250a m10439f = m10439f(byteBuffer);
        m10439f.f8091c = EnumC1301h.values()[i2];
        m10439f.m10342a(interfaceC1293a);
    }

    /* renamed from: f */
    private C1250a m10439f(ByteBuffer byteBuffer) {
        int m10403a = m10403a(byteBuffer);
        int m10403a2 = m10403a(byteBuffer);
        C1250a c1250a = new C1250a(m10442h(m10403a), EnumC1301h.RUNTIME);
        for (int i = 0; i < m10403a2; i++) {
            c1250a.f8089a.add(new C1250a.b(m10441g(m10403a(byteBuffer)), m10433d(byteBuffer)));
        }
        return c1250a;
    }

    /* renamed from: c */
    private C1249d m10430c(int i) {
        this.f8193k.position(i * 8);
        int i2 = this.f8193k.getShort() & 65535;
        int i3 = this.f8193k.getShort() & 65535;
        return new C1249d(m10442h(i2), m10441g(this.f8193k.getInt()), m10442h(i3));
    }

    /* renamed from: d */
    private String[] m10434d(int i) {
        if (i == 0) {
            return new String[0];
        }
        this.f8196n.position(i);
        int i2 = this.f8196n.getInt();
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = m10442h(65535 & this.f8196n.getShort());
        }
        return strArr;
    }

    /* renamed from: e */
    private C1292g m10436e(int i) {
        this.f8192j.position((i * 12) + 4);
        int i2 = this.f8192j.getInt();
        int i3 = this.f8192j.getInt();
        return new C1292g(m10434d(i3), m10442h(i2));
    }

    /* renamed from: f */
    private C1280e m10440f(int i) {
        this.f8194l.position(i * 8);
        int i2 = this.f8194l.getShort() & 65535;
        int i3 = this.f8194l.getShort() & 65535;
        return new C1280e(m10442h(i2), m10441g(this.f8194l.getInt()), m10436e(i3));
    }

    /* renamed from: g */
    private String m10441g(int i) {
        if (i == -1) {
            return (String) null;
        }
        int i2 = this.f8190h.getInt(i * 4);
        this.f8197o.position(i2);
        try {
            return C1288a.m10460a(this.f8197o, new StringBuilder((int) (m10403a(this.f8197o) * 1.5d)));
        } catch (UTFDataFormatException e2) {
            throw new C1236a(e2, "fail to load string %d@%08x", new Integer(i), new Integer(i2));
        }
    }

    /* renamed from: h */
    private String m10442h(int i) {
        return i == -1 ? (String) null : m10441g(this.f8191i.getInt(i * 4));
    }

    /* renamed from: a */
    private int m10404a(ByteBuffer byteBuffer, int i, C1295c c1295c, Map<Integer, Integer> map, Object obj, int i2) {
        Integer num;
        int m10403a = m10403a(byteBuffer);
        int m10403a2 = m10403a(byteBuffer);
        int i3 = i + m10403a;
        C1249d m10430c = m10430c(i3);
        C1298f mo10354a = c1295c.mo10354a(m10403a2, m10430c, obj);
        if (mo10354a != null) {
            if ((i2 & 8) == 0 && (num = map.get(new Integer(i3))) != null) {
                try {
                    m10410a(num.intValue(), mo10354a);
                } catch (Exception e2) {
                    throw new C1236a(e2, "while accept annotation in field:%s.", m10430c.toString());
                }
            }
            mo10354a.m10476a();
        }
        return i3;
    }

    /* renamed from: a */
    private int m10405a(ByteBuffer byteBuffer, int i, C1295c c1295c, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i2, boolean z) {
        C1296d mo10394a;
        int position = byteBuffer.position();
        int m10403a = m10403a(byteBuffer);
        int m10403a2 = m10403a(byteBuffer);
        int m10403a3 = m10403a(byteBuffer);
        int i3 = i + m10403a;
        C1280e m10440f = m10440f(i3);
        if (!z && m10403a == 0) {
            m10413a("GLITCH: duplicated method %s @%08x", m10440f.toString(), new Integer(position));
            if ((i2 & 64) == 0) {
                m10413a("WARN: skip method %s @%08x", m10440f.toString(), new Integer(position));
                return i3;
            }
        }
        if ((65536 & m10403a2) == 0 && (m10440f.m10398c().equals("<init>") || m10440f.m10398c().equals("<clinit>"))) {
            m10413a("GLITCH: method %s @%08x not marked as ACC_CONSTRUCTOR", m10440f.toString(), new Integer(position));
        }
        try {
            C1300h mo10355a = c1295c.mo10355a(m10403a2, m10440f);
            if (mo10355a != null) {
                if ((i2 & 8) == 0) {
                    Integer num = map.get(new Integer(i3));
                    if (num != null) {
                        try {
                            m10410a(num.intValue(), (InterfaceC1293a) mo10355a);
                        } catch (Exception e2) {
                            throw new C1236a(e2, "while accept annotation in method:%s.", m10440f.toString());
                        }
                    }
                    Integer num2 = map2.get(new Integer(i3));
                    if (num2 != null) {
                        try {
                            m10411a(num2.intValue(), mo10355a);
                        } catch (Exception e3) {
                            throw new C1236a(e3, "while accept parameter annotation in method:%s.", m10440f.toString());
                        }
                    }
                }
                if (m10403a3 != 0) {
                    boolean z2 = true;
                    if ((i2 & 4) != 0) {
                        z2 = (i2 & 128) != 0 && m10440f.m10398c().equals("<clinit>");
                    }
                    if (z2 && (mo10394a = mo10355a.mo10394a()) != null) {
                        try {
                            m10446a(m10403a3, mo10394a, i2, (m10403a2 & 8) != 0, m10440f);
                        } catch (Exception e4) {
                            throw new C1236a(e4, "while accept code in method:[%s] @%08x", m10440f.toString(), new Integer(m10403a3));
                        }
                    }
                }
                mo10355a.m10478b();
            }
            return i3;
        } catch (Exception e5) {
            throw new C1236a(e5, "while accept method:[%s]", m10440f.toString());
        }
    }

    /* renamed from: a */
    private void m10411a(int i, C1300h c1300h) {
        InterfaceC1293a mo10393a;
        ByteBuffer byteBuffer = this.f8183a;
        byteBuffer.position(i);
        int i2 = byteBuffer.getInt();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = byteBuffer.getInt();
            if (i4 != 0 && (mo10393a = c1300h.mo10393a(i3)) != null) {
                try {
                    m10410a(i4, mo10393a);
                } catch (Exception e2) {
                    throw new C1236a(e2, "while accept parameter annotation in parameter:[%d]", new Integer(i3));
                }
            }
        }
    }

    /* compiled from: DexFileReader.java */
    /* renamed from: com.g.a.e.b$a */
    static class a extends RuntimeException {
        public a(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    /* renamed from: a */
    private void m10420a(byte[] bArr, BitSet bitSet, BitSet bitSet2, Map<Integer, C1238b> map, Set<Integer> set, C1280e c1280e) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Integer(0));
        linkedList.addAll(set);
        set.clear();
        while (!linkedList.isEmpty()) {
            int intValue = linkedList.poll().intValue();
            if (!bitSet.get(intValue)) {
                bitSet.set(intValue);
                try {
                    m10418a(map, linkedList, bArr, intValue);
                } catch (a e2) {
                    bitSet2.set(intValue);
                    m10413a("GLITCH: %04x %s | %s", new Integer(intValue), c1280e.toString(), e2.getMessage());
                } catch (IndexOutOfBoundsException e3) {
                    bitSet2.set(intValue);
                    m10413a("GLITCH: %04x %s | not enough space for reading instruction", new Integer(intValue), c1280e.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m10418a(Map<Integer, C1238b> map, Queue<Integer> queue, byte[] bArr, int i) {
        int i2 = i * 2;
        if (i2 >= bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = bArr[i2] & 255;
        EnumC1286f enumC1286f = i3 < EnumC1286f.f8459du.length ? EnumC1286f.f8459du[i3] : (EnumC1286f) null;
        if (enumC1286f == null || enumC1286f.f8484dq == null) {
            throw new a("zero-width instruction op=0x%02x", new Integer(i3));
        }
        boolean z = true;
        if (enumC1286f.m10453a()) {
            EnumC1283c enumC1283c = enumC1286f.f8484dq;
            if (enumC1283c == EnumC1283c.kFmt10t) {
                int i4 = bArr[i2 + 1] + i;
                if (i4 < 0 || i4 * 2 > bArr.length) {
                    throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(i4));
                }
                queue.add(new Integer(i4));
                m10417a(map, i4);
            } else if (enumC1283c == EnumC1283c.kFmt20t || enumC1283c == EnumC1283c.kFmt21t) {
                int m10406a = m10406a(bArr, i2 + 2) + i;
                if (m10406a < 0 || m10406a * 2 > bArr.length) {
                    throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(m10406a));
                }
                queue.add(new Integer(m10406a));
                m10417a(map, m10406a);
            } else if (enumC1283c == EnumC1283c.kFmt22t) {
                int m10406a2 = i + m10406a(bArr, i2 + 2);
                int m10435e = m10435e(bArr, i2 + 1);
                boolean z2 = (m10435e & 15) == ((m10435e >> 4) & 15);
                boolean z3 = false;
                if (z2) {
                    if (enumC1286f == EnumC1286f.f8282Y || enumC1286f == EnumC1286f.f8312ab || enumC1286f == EnumC1286f.f8314ad) {
                        z = false;
                    } else if (enumC1286f == EnumC1286f.f8283Z || enumC1286f == EnumC1286f.f8313ac || enumC1286f == EnumC1286f.f8311aa) {
                        z3 = true;
                    }
                }
                if (!z3) {
                    if (m10406a2 < 0 || m10406a2 * 2 > bArr.length) {
                        throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(m10406a2));
                    }
                    queue.add(new Integer(m10406a2));
                    m10417a(map, m10406a2);
                }
            } else if (enumC1283c == EnumC1283c.kFmt30t || enumC1283c == EnumC1283c.kFmt31t) {
                int m10428c = m10428c(bArr, i2 + 2) + i;
                if (m10428c < 0 || m10428c * 2 > bArr.length) {
                    throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(m10428c));
                }
                queue.add(new Integer(m10428c));
                m10417a(map, m10428c);
            }
        }
        if (enumC1286f.m10455c()) {
            m10417a(map, enumC1286f.f8484dq.f8239A + i);
            int m10428c2 = (m10428c(bArr, i2 + 2) + i) * 2;
            if (m10428c2 + 2 < bArr.length) {
                switch (bArr[m10428c2 + 1]) {
                    case 1:
                        int m10422b = m10422b(bArr, m10428c2 + 2);
                        int i5 = m10428c2 + 8;
                        for (int i6 = 0; i6 < m10422b; i6++) {
                            int m10428c3 = m10428c(bArr, (i6 * 4) + i5) + i;
                            if (m10428c3 < 0 || m10428c3 * 2 > bArr.length) {
                                throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(m10428c3));
                            }
                            queue.add(new Integer(m10428c3));
                            m10417a(map, m10428c3);
                        }
                        break;
                    case 2:
                        int m10422b2 = m10422b(bArr, m10428c2 + 2);
                        int i7 = (m10422b2 * 4) + m10428c2 + 4;
                        for (int i8 = 0; i8 < m10422b2; i8++) {
                            int m10428c4 = m10428c(bArr, (i8 * 4) + i7) + i;
                            if (m10428c4 < 0 || m10428c4 * 2 > bArr.length) {
                                throw new a("jump out of insns %s -> %04x", enumC1286f, new Integer(m10428c4));
                            }
                            queue.add(new Integer(m10428c4));
                            m10417a(map, m10428c4);
                        }
                        break;
                    default:
                        throw new a("bad payload for %s", enumC1286f);
                }
            } else {
                throw new a("bad payload offset for %s", enumC1286f);
            }
        }
        if (z) {
            int i9 = Integer.MAX_VALUE;
            EnumC1284d enumC1284d = enumC1286f.f8485dr;
            if (enumC1284d == EnumC1284d.kIndexStringRef) {
                if (enumC1286f.f8484dq == EnumC1283c.kFmt31c) {
                    i9 = m10431d(bArr, i2 + 2);
                } else {
                    i9 = m10422b(bArr, i2 + 2);
                }
                z = i9 >= 0 && i9 < this.f8201s;
            } else if (enumC1284d == EnumC1284d.kIndexTypeRef) {
                i9 = m10422b(bArr, i2 + 2);
                z = i9 < this.f8202t;
            } else if (enumC1284d == EnumC1284d.kIndexMethodRef) {
                i9 = m10422b(bArr, i2 + 2);
                z = i9 < this.f8205w;
            } else if (enumC1284d == EnumC1284d.kIndexFieldRef) {
                i9 = m10422b(bArr, i2 + 2);
                z = i9 < this.f8204v;
            } else if (enumC1284d == EnumC1284d.kIndexCallSiteRef) {
                i9 = m10422b(bArr, i2 + 2);
                z = i9 < this.f8206x;
            } else if (enumC1284d == EnumC1284d.kIndexMethodAndProtoRef) {
                i9 = m10422b(bArr, i2 + 2);
                z = i9 < this.f8205w && m10422b(bArr, i2 + 6) < this.f8203u;
            }
            if (!z) {
                throw new a("index-out-of-range for %s index: %d", enumC1286f, new Integer(i9));
            }
        }
        if (z && enumC1286f.m10454b()) {
            if (enumC1286f == EnumC1286f.f8284a) {
                switch (bArr[i2 + 1]) {
                    case 0:
                        queue.add(new Integer(enumC1286f.f8484dq.f8239A + i));
                        return;
                    case 1:
                        queue.add(new Integer((m10422b(bArr, i2 + 2) * 2) + i + 4));
                        return;
                    case 2:
                        queue.add(new Integer((m10422b(bArr, i2 + 2) * 4) + i + 2));
                        return;
                    case 3:
                        queue.add(new Integer((((m10422b(bArr, i2 + 2) * m10431d(bArr, i2 + 4)) + 1) / 2) + i + 4));
                        return;
                    default:
                        return;
                }
            }
            queue.add(new Integer(enumC1286f.f8484dq.f8239A + i));
        }
    }

    /* renamed from: a */
    private void m10416a(ByteBuffer byteBuffer, C1296d c1296d, int i, int i2, Map<Integer, C1238b> map, Set<Integer> set) {
        int i3;
        int i4;
        int position = byteBuffer.position() + (i * 8);
        ByteBuffer order = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i) {
                return;
            }
            int i7 = byteBuffer.getInt();
            int i8 = 65535 & byteBuffer.getShort();
            int i9 = 65535 & byteBuffer.getShort();
            if (i7 <= i2) {
                m10417a(map, i7);
                int i10 = i7 + i8;
                m10417a(map, i10);
                order.position(position + i9);
                boolean z = false;
                int m10421b = m10421b(order);
                if (m10421b <= 0) {
                    int i11 = -m10421b;
                    i3 = i11 + 1;
                    z = true;
                    i4 = i11;
                } else {
                    i3 = m10421b;
                    i4 = m10421b;
                }
                C1238b[] c1238bArr = new C1238b[i3];
                String[] strArr = new String[i3];
                for (int i12 = 0; i12 < i4; i12++) {
                    int m10403a = m10403a(order);
                    int m10403a2 = m10403a(order);
                    m10417a(map, m10403a2);
                    set.add(new Integer(m10403a2));
                    strArr[i12] = m10442h(m10403a);
                    c1238bArr[i12] = map.get(new Integer(m10403a2));
                }
                if (z) {
                    int m10403a3 = m10403a(order);
                    m10417a(map, m10403a3);
                    set.add(new Integer(m10403a3));
                    c1238bArr[i4] = map.get(new Integer(m10403a3));
                }
                c1296d.mo10362a(map.get(new Integer(i7)), map.get(new Integer(i10)), c1238bArr, strArr);
            }
            i5 = i6 + 1;
        }
    }

    /* renamed from: a */
    void m10446a(int i, C1296d c1296d, int i2, boolean z, C1280e c1280e) {
        C1297e mo10359a;
        ByteBuffer byteBuffer = this.f8188f;
        byteBuffer.position(i);
        int i3 = 65535 & byteBuffer.getShort();
        byteBuffer.getShort();
        byteBuffer.getShort();
        int i4 = 65535 & byteBuffer.getShort();
        int i5 = byteBuffer.getInt();
        int i6 = byteBuffer.getInt();
        byte[] bArr = new byte[i6 * 2];
        byteBuffer.get(bArr);
        c1296d.mo10360a(i3);
        BitSet bitSet = new BitSet();
        TreeMap treeMap = new TreeMap();
        HashSet hashSet = new HashSet();
        if (i4 > 0) {
            if ((i6 & 1) != 0) {
                byteBuffer.getShort();
            }
            if ((i2 & 256) == 0) {
                m10416a(byteBuffer, c1296d, i4, i6, treeMap, hashSet);
            }
        }
        if (i5 != 0 && (i2 & 1) == 0 && (mo10359a = c1296d.mo10359a()) != null) {
            m10409a(i5, i3, z, c1280e, treeMap, mo10359a);
            mo10359a.m10475a();
        }
        BitSet bitSet2 = new BitSet();
        m10420a(bArr, bitSet, bitSet2, treeMap, hashSet, c1280e);
        m10419a(bArr, c1296d, bitSet, bitSet2, treeMap);
        c1296d.m10474b();
    }

    /* renamed from: a */
    private void m10419a(byte[] bArr, C1296d c1296d, BitSet bitSet, BitSet bitSet2, Map<Integer, C1238b> map) {
        Iterator<Integer> it = map.keySet().iterator();
        Integer next = it.hasNext() ? it.next() : (Integer) null;
        EnumC1286f[] enumC1286fArr = EnumC1286f.f8459du;
        int nextSetBit = bitSet.nextSetBit(0);
        while (nextSetBit >= 0) {
            Integer num = next;
            while (num != null && num.intValue() <= nextSetBit) {
                c1296d.mo10361a(map.get(num));
                num = it.hasNext() ? it.next() : null;
            }
            if (bitSet2.get(nextSetBit)) {
                c1296d.mo10364a(EnumC1286f.f8458do);
            } else {
                int i = nextSetBit * 2;
                EnumC1286f enumC1286f = enumC1286fArr[bArr[i] & 255];
                EnumC1283c enumC1283c = enumC1286f.f8484dq;
                if (enumC1283c == EnumC1283c.kFmt10x) {
                    c1296d.mo10364a(enumC1286f);
                } else if (enumC1283c == EnumC1283c.kFmt11x) {
                    c1296d.mo10365a(enumC1286f, bArr[i + 1] & 255);
                } else if (enumC1283c == EnumC1283c.kFmt12x) {
                    int m10435e = m10435e(bArr, i + 1);
                    c1296d.mo10366a(enumC1286f, m10435e & 15, m10435e >> 4);
                } else if (enumC1283c == EnumC1283c.kFmt10t) {
                    c1296d.mo10368a(enumC1286f, -1, -1, map.get(new Integer(bArr[i + 1] + nextSetBit)));
                } else if (enumC1283c == EnumC1283c.kFmt20t) {
                    c1296d.mo10368a(enumC1286f, -1, -1, map.get(new Integer(m10406a(bArr, i + 2) + nextSetBit)));
                } else if (enumC1283c == EnumC1283c.kFmt21t) {
                    c1296d.mo10368a(enumC1286f, m10435e(bArr, i + 1), -1, map.get(new Integer(m10406a(bArr, i + 2) + nextSetBit)));
                } else if (enumC1283c == EnumC1283c.kFmt22t) {
                    int m10406a = m10406a(bArr, i + 2) + nextSetBit;
                    int m10435e2 = m10435e(bArr, i + 1);
                    int i2 = m10435e2 & 15;
                    int i3 = m10435e2 >> 4;
                    boolean z = false;
                    if (i2 == i3) {
                        if (enumC1286f == EnumC1286f.f8282Y || enumC1286f == EnumC1286f.f8312ab || enumC1286f == EnumC1286f.f8314ad) {
                            c1296d.mo10368a(EnumC1286f.f8272O, 0, 0, map.get(new Integer(m10406a)));
                            z = true;
                        } else if (enumC1286f == EnumC1286f.f8283Z || enumC1286f == EnumC1286f.f8313ac || enumC1286f == EnumC1286f.f8311aa) {
                            z = true;
                        }
                    }
                    if (!z) {
                        c1296d.mo10368a(enumC1286f, i2, i3, map.get(new Integer(m10406a)));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt30t) {
                    c1296d.mo10368a(enumC1286f, -1, -1, map.get(new Integer(m10428c(bArr, i + 2) + nextSetBit)));
                } else if (enumC1283c == EnumC1283c.kFmt31t) {
                    int m10428c = m10428c(bArr, i + 2) + nextSetBit;
                    int m10435e3 = m10435e(bArr, i + 1);
                    int i4 = m10428c * 2;
                    if (enumC1286f == EnumC1286f.f8270M) {
                        int m10422b = m10422b(bArr, i4 + 2);
                        int m10431d = m10431d(bArr, i4 + 4);
                        switch (m10422b) {
                            case 1:
                                Object obj = new byte[m10431d];
                                System.arraycopy(bArr, i4 + 8, obj, 0, m10431d);
                                c1296d.mo10379b(enumC1286f, m10435e3, obj);
                                break;
                            case 2:
                                short[] sArr = new short[m10431d];
                                for (int i5 = 0; i5 < m10431d; i5++) {
                                    sArr[i5] = (short) m10406a(bArr, i4 + 8 + (i5 * 2));
                                }
                                c1296d.mo10379b(enumC1286f, m10435e3, sArr);
                                break;
                            case 4:
                                int[] iArr = new int[m10431d];
                                for (int i6 = 0; i6 < m10431d; i6++) {
                                    iArr[i6] = m10428c(bArr, i4 + 8 + (i6 * 4));
                                }
                                c1296d.mo10379b(enumC1286f, m10435e3, iArr);
                                break;
                            case 8:
                                long[] jArr = new long[m10431d];
                                for (int i7 = 0; i7 < m10431d; i7++) {
                                    int i8 = i4 + 8 + (i7 * 8);
                                    jArr[i7] = 0 | (m10422b(bArr, i8 + 0) << 0) | (m10422b(bArr, i8 + 2) << 16) | (m10422b(bArr, i8 + 4) << 32) | (m10422b(bArr, i8 + 6) << 48);
                                }
                                c1296d.mo10379b(enumC1286f, m10435e3, jArr);
                                break;
                        }
                    } else if (enumC1286f == EnumC1286f.f8276S) {
                        int m10406a2 = m10406a(bArr, i4 + 2);
                        int[] iArr2 = new int[m10406a2];
                        C1238b[] c1238bArr = new C1238b[m10406a2];
                        int i9 = i4 + 4;
                        for (int i10 = 0; i10 < m10406a2; i10++) {
                            iArr2[i10] = m10428c(bArr, (i10 * 4) + i9);
                        }
                        int i11 = i9 + (m10406a2 * 4);
                        for (int i12 = 0; i12 < m10406a2; i12++) {
                            c1238bArr[i12] = map.get(new Integer(m10428c(bArr, (i12 * 4) + i11) + nextSetBit));
                        }
                        c1296d.mo10372a(enumC1286f, m10435e3, iArr2, c1238bArr);
                    } else {
                        int m10406a3 = m10406a(bArr, i4 + 2);
                        int m10428c2 = m10428c(bArr, i4 + 4);
                        C1238b[] c1238bArr2 = new C1238b[m10406a3];
                        int i13 = i4 + 8;
                        for (int i14 = 0; i14 < m10406a3; i14++) {
                            c1238bArr2[i14] = map.get(new Integer(m10428c(bArr, i13) + nextSetBit));
                            i13 += 4;
                        }
                        c1296d.mo10370a(enumC1286f, m10435e3, m10428c2, c1238bArr2);
                    }
                } else if (enumC1283c == EnumC1283c.kFmt21c) {
                    int m10435e4 = m10435e(bArr, i + 1);
                    int m10422b2 = m10422b(bArr, i + 2);
                    EnumC1284d enumC1284d = enumC1286f.f8485dr;
                    if (enumC1284d == EnumC1284d.kIndexStringRef) {
                        c1296d.mo10371a(enumC1286f, m10435e4, m10441g(m10422b2));
                    } else if (enumC1284d == EnumC1284d.kIndexFieldRef) {
                        c1296d.mo10333a(enumC1286f, m10435e4, -1, m10430c(m10422b2));
                    } else if (enumC1284d == EnumC1284d.kIndexTypeRef) {
                        if (enumC1286f == EnumC1286f.f8260C) {
                            c1296d.mo10371a(enumC1286f, m10435e4, new C1241c(m10442h(m10422b2)));
                        } else {
                            c1296d.mo10369a(enumC1286f, m10435e4, -1, m10442h(m10422b2));
                        }
                    }
                } else if (enumC1283c == EnumC1283c.kFmt22c) {
                    int m10435e5 = m10435e(bArr, i + 1);
                    int m10422b3 = m10422b(bArr, i + 2);
                    EnumC1284d enumC1284d2 = enumC1286f.f8485dr;
                    if (enumC1284d2 == EnumC1284d.kIndexFieldRef) {
                        c1296d.mo10333a(enumC1286f, m10435e5 & 15, m10435e5 >> 4, m10430c(m10422b3));
                    } else if (enumC1284d2 == EnumC1284d.kIndexTypeRef) {
                        c1296d.mo10369a(enumC1286f, m10435e5 & 15, m10435e5 >> 4, m10442h(m10422b3));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt31c) {
                    if (enumC1286f.f8485dr == EnumC1284d.kIndexStringRef) {
                        c1296d.mo10371a(enumC1286f, m10435e(bArr, i + 1), m10441g(m10431d(bArr, i + 2)));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt35c) {
                    int m10435e6 = m10435e(bArr, i + 1);
                    int m10422b4 = m10422b(bArr, i + 2);
                    int m10435e7 = m10435e(bArr, i + 4);
                    int m10435e8 = m10435e(bArr, i + 5);
                    int[] iArr3 = new int[m10435e6 >> 4];
                    switch (m10435e6 >> 4) {
                        case 5:
                            iArr3[4] = m10435e6 & 15;
                        case 4:
                            iArr3[3] = (m10435e8 >> 4) & 15;
                        case 3:
                            iArr3[2] = (m10435e8 >> 0) & 15;
                        case 2:
                            iArr3[1] = (m10435e7 >> 4) & 15;
                        case 1:
                            iArr3[0] = (m10435e7 >> 0) & 15;
                            break;
                    }
                    if (enumC1286f.f8485dr == EnumC1284d.kIndexTypeRef) {
                        c1296d.mo10375a(enumC1286f, iArr3, m10442h(m10422b4));
                    } else if (enumC1286f.f8485dr == EnumC1284d.kIndexCallSiteRef) {
                        Object[] m10443i = m10443i(m10422b4);
                        c1296d.mo10376a(enumC1286f, iArr3, (String) m10443i[1], (C1292g) m10443i[2], (C1287f) m10443i[0], Arrays.copyOfRange(m10443i, 3, m10443i.length));
                    } else {
                        c1296d.mo10373a(enumC1286f, iArr3, m10440f(m10422b4));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt3rc) {
                    int m10435e9 = m10435e(bArr, i + 1);
                    int m10422b5 = m10422b(bArr, i + 2);
                    int m10422b6 = m10422b(bArr, i + 4);
                    int[] iArr4 = new int[m10435e9];
                    for (int i15 = 0; i15 < m10435e9; i15++) {
                        iArr4[i15] = m10422b6 + i15;
                    }
                    if (enumC1286f.f8485dr == EnumC1284d.kIndexTypeRef) {
                        c1296d.mo10375a(enumC1286f, iArr4, m10442h(m10422b5));
                    } else if (enumC1286f.f8485dr == EnumC1284d.kIndexCallSiteRef) {
                        Object[] m10443i2 = m10443i(m10422b5);
                        c1296d.mo10376a(enumC1286f, iArr4, (String) m10443i2[1], (C1292g) m10443i2[2], (C1287f) m10443i2[0], Arrays.copyOfRange(m10443i2, 3, m10443i2.length - 3));
                    } else {
                        c1296d.mo10373a(enumC1286f, iArr4, m10440f(m10422b5));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt45cc) {
                    int m10435e10 = m10435e(bArr, i + 1);
                    int m10422b7 = m10422b(bArr, i + 2);
                    int m10435e11 = m10435e(bArr, i + 4);
                    int m10435e12 = m10435e(bArr, i + 5);
                    int m10422b8 = m10422b(bArr, i + 6);
                    int[] iArr5 = new int[m10435e10 >> 4];
                    switch (m10435e10 >> 4) {
                        case 5:
                            iArr5[4] = m10435e10 & 15;
                        case 4:
                            iArr5[3] = (m10435e12 >> 4) & 15;
                        case 3:
                            iArr5[2] = (m10435e12 >> 0) & 15;
                        case 2:
                            iArr5[1] = (m10435e11 >> 4) & 15;
                        case 1:
                            iArr5[0] = (m10435e11 >> 0) & 15;
                            break;
                    }
                    c1296d.mo10374a(enumC1286f, iArr5, m10440f(m10422b7), m10436e(m10422b8));
                } else if (enumC1283c == EnumC1283c.kFmt4rcc) {
                    int m10435e13 = m10435e(bArr, i + 1);
                    int m10422b9 = m10422b(bArr, i + 2);
                    int m10422b10 = m10422b(bArr, i + 4);
                    int m10422b11 = m10422b(bArr, i + 6);
                    int[] iArr6 = new int[m10435e13];
                    for (int i16 = 0; i16 < m10435e13; i16++) {
                        iArr6[i16] = m10422b10 + i16;
                    }
                    c1296d.mo10374a(enumC1286f, iArr6, m10440f(m10422b9), m10436e(m10422b11));
                } else if (enumC1283c == EnumC1283c.kFmt22x) {
                    c1296d.mo10366a(enumC1286f, m10435e(bArr, i + 1), m10422b(bArr, i + 2));
                } else if (enumC1283c == EnumC1283c.kFmt23x) {
                    c1296d.mo10378b(enumC1286f, m10435e(bArr, i + 1), m10435e(bArr, i + 2), m10435e(bArr, i + 3));
                } else if (enumC1283c == EnumC1283c.kFmt32x) {
                    c1296d.mo10366a(enumC1286f, m10422b(bArr, i + 2), m10422b(bArr, i + 4));
                } else if (enumC1283c == EnumC1283c.kFmt11n) {
                    int i17 = bArr[i + 1];
                    c1296d.mo10371a(enumC1286f, i17 & 15, new Integer(i17 >> 4));
                } else if (enumC1283c == EnumC1283c.kFmt21h) {
                    int m10435e14 = m10435e(bArr, i + 1);
                    int m10406a4 = m10406a(bArr, i + 2);
                    if (enumC1286f == EnumC1286f.f8478v) {
                        c1296d.mo10371a(enumC1286f, m10435e14, new Integer(m10406a4 << 16));
                    } else {
                        c1296d.mo10371a(enumC1286f, m10435e14, new Long(m10406a4 << 48));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt21s) {
                    int m10435e15 = m10435e(bArr, i + 1);
                    int m10406a5 = m10406a(bArr, i + 2);
                    if (enumC1286f == EnumC1286f.f8476t) {
                        c1296d.mo10371a(enumC1286f, m10435e15, new Integer(m10406a5));
                    } else {
                        c1296d.mo10371a(enumC1286f, m10435e15, new Long(m10406a5));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt22b) {
                    c1296d.mo10367a(enumC1286f, m10435e(bArr, i + 1), m10435e(bArr, i + 2), m10438f(bArr, i + 3));
                } else if (enumC1283c == EnumC1283c.kFmt22s) {
                    int m10435e16 = m10435e(bArr, i + 1);
                    c1296d.mo10367a(enumC1286f, m10435e16 & 15, m10435e16 >> 4, m10406a(bArr, i + 2));
                } else if (enumC1283c == EnumC1283c.kFmt31i) {
                    int m10435e17 = m10435e(bArr, i + 1);
                    int m10428c3 = m10428c(bArr, i + 2);
                    if (enumC1286f == EnumC1286f.f8477u) {
                        c1296d.mo10371a(enumC1286f, m10435e17, new Integer(m10428c3));
                    } else {
                        c1296d.mo10371a(enumC1286f, m10435e17, new Long(m10428c3));
                    }
                } else if (enumC1283c == EnumC1283c.kFmt51l) {
                    c1296d.mo10371a(enumC1286f, m10435e(bArr, i + 1), new Long(0 | (m10422b(bArr, i + 2) << 0) | (m10422b(bArr, i + 4) << 16) | (m10422b(bArr, i + 6) << 32) | (m10422b(bArr, i + 8) << 48)));
                }
            }
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            next = num;
        }
        while (next != null) {
            c1296d.mo10361a(map.get(next));
            if (!it.hasNext()) {
                return;
            } else {
                next = it.next();
            }
        }
    }

    /* renamed from: i */
    private Object[] m10443i(int i) {
        this.f8199q.position(i * 4);
        return m10426b(this.f8199q.getInt());
    }

    /* compiled from: DexFileReader.java */
    /* renamed from: com.g.a.e.b$b */
    private static class b {

        /* renamed from: a */
        public String f8209a;

        /* renamed from: b */
        public String f8210b;

        /* renamed from: c */
        public String f8211c;

        b(String str, String str2) {
            this.f8209a = str;
            this.f8210b = str2;
        }

        b(String str, String str2, String str3) {
            this.f8209a = str;
            this.f8210b = str2;
            this.f8211c = str3;
        }
    }
}
