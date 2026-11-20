package com.p065b.p111c;

import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p111c.C1071d;
import com.p065b.p111c.InterfaceC1041b;
import com.p065b.p111c.p112a.AbstractC1038b;
import com.p065b.p111c.p112a.C1037a;
import com.p065b.p111c.p112a.C1040d;
import com.p065b.p111c.p113b.p114a.p116b.AbstractC1049d;
import com.p065b.p111c.p113b.p118c.C1053a;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p113b.p119d.AbstractC1065d;
import com.p065b.p111c.p113b.p119d.C1062a;
import com.p065b.p111c.p113b.p119d.C1063b;
import com.p065b.p111c.p113b.p119d.C1064c;
import com.p065b.p111c.p120c.AbstractC1068b;
import com.p065b.p111c.p120c.AbstractC1070d;
import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import com.p065b.p111c.p121d.C1072a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApkSigner.java */
/* renamed from: com.b.c.a */
/* loaded from: classes.dex */
public class C1036a {

    /* renamed from: a */
    private static int[] f6511a;

    /* renamed from: b */
    private final String f6512b;

    /* renamed from: c */
    private final InterfaceC1069c f6513c;

    /* renamed from: d */
    private final File f6514d;

    /* renamed from: e */
    private final Integer f6515e;

    /* renamed from: f */
    private final boolean f6516f;

    /* renamed from: g */
    private final InterfaceC1067a f6517g;

    /* renamed from: h */
    private final InterfaceC1069c f6518h;

    /* renamed from: i */
    private final File f6519i;

    /* renamed from: j */
    private final List<b> f6520j;

    /* renamed from: k */
    private final InterfaceC1041b f6521k;

    /* renamed from: l */
    private final boolean f6522l;

    /* renamed from: m */
    private final boolean f6523m;

    /* renamed from: a */
    static /* synthetic */ int[] m8609a() {
        int[] iArr = f6511a;
        if (iArr == null) {
            iArr = new int[InterfaceC1041b.b.valuesCustom().length];
            try {
                iArr[InterfaceC1041b.b.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InterfaceC1041b.b.OUTPUT_BY_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[InterfaceC1041b.b.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            f6511a = iArr;
        }
        return iArr;
    }

    private C1036a(List<b> list, Integer num, boolean z, boolean z2, boolean z3, String str, InterfaceC1041b interfaceC1041b, File file, InterfaceC1069c interfaceC1069c, File file2, InterfaceC1067a interfaceC1067a, InterfaceC1069c interfaceC1069c2) {
        this.f6520j = list;
        this.f6515e = num;
        this.f6522l = z;
        this.f6523m = z2;
        this.f6516f = z3;
        this.f6512b = str;
        this.f6521k = interfaceC1041b;
        this.f6514d = file;
        this.f6513c = interfaceC1069c;
        this.f6519i = file2;
        this.f6517g = interfaceC1067a;
        this.f6518h = interfaceC1069c2;
    }

    /* synthetic */ C1036a(List list, Integer num, boolean z, boolean z2, boolean z3, String str, InterfaceC1041b interfaceC1041b, File file, InterfaceC1069c interfaceC1069c, File file2, InterfaceC1067a interfaceC1067a, InterfaceC1069c interfaceC1069c2, C1036a c1036a) {
        this(list, num, z, z2, z3, str, interfaceC1041b, file, interfaceC1069c, file2, interfaceC1067a, interfaceC1069c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #0 {all -> 0x0072, blocks: (B:15:0x0017, B:25:0x006e, B:26:0x0071), top: B:7:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[Catch: all -> 0x0072, SYNTHETIC, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:15:0x0017, B:25:0x006e, B:26:0x0071), top: B:7:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m8611b() {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        InterfaceC1069c m8925a;
        Throwable th2;
        RandomAccessFile randomAccessFile4;
        InterfaceC1067a m8922a;
        InterfaceC1069c m8925a2;
        RandomAccessFile randomAccessFile5 = null;
        try {
            if (this.f6513c != null) {
                randomAccessFile3 = null;
                m8925a = this.f6513c;
            } else if (this.f6514d != null) {
                randomAccessFile2 = new RandomAccessFile(this.f6514d, "r");
                try {
                    randomAccessFile3 = randomAccessFile2;
                    m8925a = AbstractC1070d.m8925a(randomAccessFile2);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile == null) {
                    }
                }
            } else {
                throw new IllegalStateException("Input APK not specified");
            }
            try {
                try {
                    if (this.f6517g != null) {
                        InterfaceC1067a interfaceC1067a = this.f6517g;
                        m8925a2 = this.f6518h;
                        m8922a = interfaceC1067a;
                    } else if (this.f6519i != null) {
                        RandomAccessFile randomAccessFile6 = new RandomAccessFile(this.f6519i, "rw");
                        try {
                            randomAccessFile6.setLength(0L);
                            m8922a = AbstractC1068b.m8922a(randomAccessFile6);
                            m8925a2 = AbstractC1070d.m8925a(randomAccessFile6);
                            randomAccessFile5 = randomAccessFile6;
                        } catch (Throwable th4) {
                            th2 = th4;
                            randomAccessFile4 = randomAccessFile6;
                            if (randomAccessFile4 == null) {
                                randomAccessFile4.close();
                                throw th2;
                            }
                            throw th2;
                        }
                    } else {
                        throw new IllegalStateException("Output APK not specified");
                    }
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile2 = randomAccessFile3;
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile == null) {
                        randomAccessFile.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th2 = th6;
                randomAccessFile4 = null;
            }
            try {
                m8608a(m8925a, m8922a, m8925a2);
                if (randomAccessFile5 != null) {
                    randomAccessFile5.close();
                }
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
            } catch (Throwable th7) {
                th2 = th7;
                randomAccessFile4 = randomAccessFile5;
                if (randomAccessFile4 == null) {
                }
            }
        } catch (Throwable th8) {
            th = th8;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ab A[LOOP:3: B:95:0x00c6->B:97:0x02ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v73, types: [com.b.c.b] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m8608a(InterfaceC1069c interfaceC1069c, InterfaceC1067a interfaceC1067a, InterfaceC1069c interfaceC1069c2) {
        InterfaceC1069c interfaceC1069c3;
        InterfaceC1069c interfaceC1069c4;
        int m8610b;
        C1071d m8962a;
        long j;
        long mo8840a;
        long j2;
        ArrayList arrayList;
        Iterator<C1062a> it;
        InterfaceC1041b.e mo8640b;
        long j3;
        long j4;
        int i;
        int i2;
        boolean z;
        C1059g<InterfaceC1069c, Long> m8777a;
        try {
            AbstractC1038b.c m8625a = AbstractC1038b.m8625a(interfaceC1069c);
            long j5 = -1;
            try {
                m8777a = AbstractC1049d.m8777a(interfaceC1069c, m8625a);
                interfaceC1069c3 = m8777a.m8852a();
            } catch (AbstractC1049d.h e2) {
                interfaceC1069c3 = null;
            }
            try {
                j5 = m8777a.m8853b().longValue();
                interfaceC1069c4 = interfaceC1069c3;
            } catch (AbstractC1049d.h e3) {
                interfaceC1069c4 = interfaceC1069c3;
                InterfaceC1069c mo8845b = interfaceC1069c.mo8845b(0L, j5 == -1 ? j5 : m8625a.m8629a());
                List<C1062a> m8606a = m8606a(m8603a(interfaceC1069c, m8625a), m8625a);
                if (this.f6521k == null) {
                }
                if (interfaceC1069c4 != null) {
                }
                ArrayList<C1062a> arrayList2 = new ArrayList(m8606a);
                Collections.sort(arrayList2, C1062a.f6708a);
                j = 0;
                HashMap hashMap = new HashMap(m8606a.size());
                int i3 = -1;
                int i4 = -1;
                long j6 = 0;
                while (r18.hasNext()) {
                }
                mo8840a = mo8845b.mo8840a();
                if (j >= mo8840a) {
                }
                arrayList = new ArrayList(m8606a.size() + 10);
                it = m8606a.iterator();
                while (it.hasNext()) {
                }
                mo8640b = m8962a.mo8640b();
                if (mo8640b != null) {
                }
                j3 = 0;
                while (true) {
                    j4 = j3;
                    if (arrayList.iterator().hasNext()) {
                    }
                    j3 = ((C1062a) r8.next()).m8872j() + j4;
                }
            }
            InterfaceC1069c mo8845b2 = interfaceC1069c.mo8845b(0L, j5 == -1 ? j5 : m8625a.m8629a());
            List<C1062a> m8606a2 = m8606a(m8603a(interfaceC1069c, m8625a), m8625a);
            if (this.f6521k == null) {
                m8962a = this.f6521k;
            } else {
                if (this.f6515e != null) {
                    m8610b = this.f6515e.intValue();
                } else {
                    m8610b = m8610b(m8606a2, mo8845b2);
                }
                ArrayList arrayList3 = new ArrayList(this.f6520j.size());
                for (b bVar : this.f6520j) {
                    arrayList3.add(new C1071d.g(bVar.m8621b(), bVar.m8622c(), bVar.m8620a()).m8985a());
                }
                C1071d.a m8961a = new C1071d.a(arrayList3, m8610b).m8963b(this.f6522l).m8964c(this.f6523m).m8961a(this.f6516f);
                if (this.f6512b != null) {
                    m8961a.m8960a(this.f6512b);
                }
                m8962a = m8961a.m8962a();
            }
            if (interfaceC1069c4 != null) {
                m8962a.mo8638a(interfaceC1069c4);
            }
            ArrayList<C1062a> arrayList22 = new ArrayList(m8606a2);
            Collections.sort(arrayList22, C1062a.f6708a);
            j = 0;
            HashMap hashMap2 = new HashMap(m8606a2.size());
            int i32 = -1;
            int i42 = -1;
            long j62 = 0;
            for (C1062a c1062a : arrayList22) {
                String m8870h = c1062a.m8870h();
                InterfaceC1041b.a mo8635a = m8962a.mo8635a(m8870h);
                switch (m8609a()[mo8635a.m8642b().ordinal()]) {
                    case 1:
                    case 3:
                        z = false;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        throw new RuntimeException("Unknown output policy: " + mo8635a.m8642b());
                }
                long m8869g = c1062a.m8869g();
                if (m8869g > j) {
                    long j7 = m8869g - j;
                    mo8845b2.mo8844a(j, j7, interfaceC1067a);
                    j62 += j7;
                    j = m8869g;
                }
                try {
                    C1064c m8877a = C1064c.m8877a(mo8845b2, c1062a, mo8845b2.mo8840a());
                    long m8888e = m8877a.m8888e() + j;
                    InterfaceC1041b.c m8641a = mo8635a.m8641a();
                    if (m8641a != null) {
                        m8607a(mo8845b2, m8877a, m8641a);
                    }
                    if (z) {
                        int m8867e = c1062a.m8867e();
                        int m8868f = c1062a.m8868f();
                        if (i42 == -1 || m8867e > i42) {
                            i42 = m8867e;
                            i32 = m8868f;
                        } else if (m8867e == i42 && m8868f > i32) {
                            i42 = m8867e;
                            i32 = m8868f;
                        }
                        InterfaceC1041b.c mo8639b = m8962a.mo8639b(m8870h);
                        if (mo8639b != null) {
                            m8607a(mo8845b2, m8877a, mo8639b);
                        }
                        long m8602a = m8602a(mo8845b2, m8877a, interfaceC1067a, j62);
                        if (j62 != m8877a.m8889f()) {
                            c1062a = c1062a.m8862a(j62);
                        }
                        hashMap2.put(m8870h, c1062a);
                        j62 += m8602a;
                        j = m8888e;
                    } else {
                        j = m8888e;
                    }
                } catch (C1072a e4) {
                    throw new C1037a("Malformed ZIP entry: " + c1062a.m8870h(), e4);
                }
            }
            mo8840a = mo8845b2.mo8840a();
            if (j >= mo8840a) {
                long j8 = mo8840a - j;
                mo8845b2.mo8844a(j, j8, interfaceC1067a);
                j2 = j62 + j8;
            } else {
                j2 = j62;
            }
            arrayList = new ArrayList(m8606a2.size() + 10);
            it = m8606a2.iterator();
            while (it.hasNext()) {
                C1062a c1062a2 = (C1062a) hashMap2.get(it.next().m8870h());
                if (c1062a2 != null) {
                    arrayList.add(c1062a2);
                }
            }
            mo8640b = m8962a.mo8640b();
            if (mo8640b != null) {
                if (i42 == -1) {
                    i = 14881;
                    i2 = 0;
                } else {
                    i = i42;
                    i2 = i32;
                }
                long j9 = j2;
                for (InterfaceC1041b.f fVar : mo8640b.mo8911b()) {
                    String m8913b = fVar.m8913b();
                    byte[] m8912a = fVar.m8912a();
                    AbstractC1065d.a m8901b = AbstractC1065d.m8901b(ByteBuffer.wrap(m8912a));
                    byte[] bArr = m8901b.f6738c;
                    long j10 = m8901b.f6736a;
                    InterfaceC1041b.c mo8639b2 = m8962a.mo8639b(m8913b);
                    if (mo8639b2 != null) {
                        mo8639b2.mo8838b().mo8847a(m8912a, 0, m8912a.length);
                        mo8639b2.mo8837a();
                    }
                    long m8876a = C1064c.m8876a(m8913b, i2, i, bArr, j10, m8912a.length, interfaceC1067a);
                    arrayList.add(C1062a.m8858a(m8913b, i2, i, j10, bArr.length, m8912a.length, j9));
                    j9 += m8876a;
                }
                mo8640b.mo8910a();
                j2 = j9;
            }
            j3 = 0;
            while (true) {
                j4 = j3;
                if (arrayList.iterator().hasNext()) {
                    if (j4 > 2147483647L) {
                        throw new IOException("Output ZIP Central Directory too large: " + j4 + " bytes");
                    }
                    ByteBuffer allocate = ByteBuffer.allocate((int) j4);
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((C1062a) it2.next()).m8864b(allocate);
                    }
                    allocate.flip();
                    C1053a c1053a = new C1053a(allocate);
                    ByteBuffer m8875a = C1063b.m8875a(m8625a.m8632d(), arrayList.size(), c1053a.mo8840a(), j2);
                    InterfaceC1041b.d mo8636a = m8962a.mo8636a(interfaceC1069c2, c1053a, AbstractC1070d.m8927a(m8875a));
                    if (mo8636a != null) {
                        byte[] mo8857b = mo8636a.mo8857b();
                        interfaceC1067a.mo8847a(mo8857b, 0, mo8857b.length);
                        AbstractC1065d.m8902b(m8875a, mo8857b.length + j2);
                        mo8636a.mo8856a();
                    }
                    c1053a.mo8844a(0L, c1053a.mo8840a(), interfaceC1067a);
                    interfaceC1067a.mo8846a(m8875a);
                    m8962a.mo8637a();
                    return;
                }
                j3 = ((C1062a) r8.next()).m8872j() + j4;
            }
        } catch (C1072a e5) {
            throw new C1037a("Malformed APK: not a ZIP archive", e5);
        }
    }

    /* renamed from: a */
    private static void m8607a(InterfaceC1069c interfaceC1069c, C1064c c1064c, InterfaceC1041b.c cVar) {
        try {
            c1064c.m8885b(interfaceC1069c, cVar.mo8838b());
            cVar.mo8837a();
        } catch (C1072a e2) {
            throw new C1037a("Malformed ZIP entry: " + c1064c.m8887d(), e2);
        }
    }

    /* renamed from: a */
    private static long m8602a(InterfaceC1069c interfaceC1069c, C1064c c1064c, InterfaceC1067a interfaceC1067a, long j) {
        long m8889f = c1064c.m8889f();
        if (m8889f == j) {
            return c1064c.m8882a(interfaceC1069c, interfaceC1067a);
        }
        int m8601a = m8601a(c1064c);
        if (m8601a <= 1 || m8889f % m8601a == j % m8601a) {
            return c1064c.m8882a(interfaceC1069c, interfaceC1067a);
        }
        if ((m8889f + c1064c.m8881a()) % m8601a != 0) {
            return c1064c.m8882a(interfaceC1069c, interfaceC1067a);
        }
        return c1064c.m8883a(interfaceC1069c, m8604a(c1064c.m8884b(), c1064c.m8886c() + j, m8601a), interfaceC1067a);
    }

    /* renamed from: a */
    private static int m8601a(C1064c c1064c) {
        if (c1064c.m8890g()) {
            return 1;
        }
        ByteBuffer m8884b = c1064c.m8884b();
        if (m8884b.hasRemaining()) {
            m8884b.order(ByteOrder.LITTLE_ENDIAN);
            while (true) {
                if (m8884b.remaining() < 4) {
                    break;
                }
                short s = m8884b.getShort();
                int m8903c = AbstractC1065d.m8903c(m8884b);
                if (m8903c > m8884b.remaining()) {
                    break;
                }
                if (s != -9931) {
                    m8884b.position(m8884b.position() + m8903c);
                } else if (m8903c >= 2) {
                    return AbstractC1065d.m8903c(m8884b);
                }
            }
        }
        return c1064c.m8887d().endsWith(".so") ? 4096 : 4;
    }

    /* renamed from: a */
    private static ByteBuffer m8604a(ByteBuffer byteBuffer, long j, int i) {
        if (i > 1) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + 5 + i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                short s = byteBuffer.getShort();
                int m8903c = AbstractC1065d.m8903c(byteBuffer);
                if (m8903c > byteBuffer.remaining()) {
                    break;
                }
                if ((s == 0 && m8903c == 0) || s == -9931) {
                    byteBuffer.position(byteBuffer.position() + m8903c);
                } else {
                    byteBuffer.position(byteBuffer.position() - 4);
                    int limit = byteBuffer.limit();
                    byteBuffer.limit(m8903c + byteBuffer.position() + 4);
                    allocate.put(byteBuffer);
                    byteBuffer.limit(limit);
                }
            }
            int position = (i - ((int) (((allocate.position() + j) + 6) % i))) % i;
            allocate.putShort((short) -9931);
            AbstractC1065d.m8904c(allocate, position + 2);
            AbstractC1065d.m8904c(allocate, i);
            allocate.position(position + allocate.position());
            allocate.flip();
            return allocate;
        }
        return byteBuffer;
    }

    /* renamed from: a */
    private static ByteBuffer m8603a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar) {
        long m8631c = cVar.m8631c();
        if (m8631c > 2147483647L) {
            throw new C1037a("ZIP Central Directory too large: " + m8631c);
        }
        ByteBuffer mo8842a = interfaceC1069c.mo8842a(cVar.m8629a(), (int) m8631c);
        mo8842a.order(ByteOrder.LITTLE_ENDIAN);
        return mo8842a;
    }

    /* renamed from: a */
    private static List<C1062a> m8606a(ByteBuffer byteBuffer, AbstractC1038b.c cVar) {
        long m8629a = cVar.m8629a();
        int m8630b = cVar.m8630b();
        ArrayList arrayList = new ArrayList(m8630b);
        HashSet hashSet = new HashSet(m8630b);
        for (int i = 0; i < m8630b; i++) {
            int position = byteBuffer.position();
            try {
                C1062a m8859a = C1062a.m8859a(byteBuffer);
                String m8870h = m8859a.m8870h();
                if (!hashSet.add(m8870h)) {
                    throw new C1037a("Multiple ZIP entries with the same name: " + m8870h);
                }
                arrayList.add(m8859a);
            } catch (C1072a e2) {
                throw new C1037a("Malformed ZIP Central Directory record #" + (i + 1) + " at file offset " + (m8629a + position), e2);
            }
        }
        if (byteBuffer.hasRemaining()) {
            throw new C1037a("Unused space at the end of ZIP Central Directory: " + byteBuffer.remaining() + " bytes starting at file offset " + (m8629a + byteBuffer.position()));
        }
        return arrayList;
    }

    /* renamed from: a */
    static ByteBuffer m8605a(List<C1062a> list, InterfaceC1069c interfaceC1069c) {
        C1062a c1062a;
        Iterator<C1062a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1062a = null;
                break;
            }
            c1062a = it.next();
            if (AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(c1062a.m8870h())) {
                break;
            }
        }
        if (c1062a == null) {
            return null;
        }
        return ByteBuffer.wrap(C1064c.m8880b(interfaceC1069c, c1062a, interfaceC1069c.mo8840a()));
    }

    /* renamed from: b */
    private static int m8610b(List<C1062a> list, InterfaceC1069c interfaceC1069c) {
        try {
            return AbstractC1038b.m8624a(m8605a(list, interfaceC1069c));
        } catch (C1037a | C1072a e2) {
            throw new C1040d("Failed to determine APK's minimum supported Android platform version", e2);
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.c.a$b */
    public static class b {

        /* renamed from: a */
        private final List<X509Certificate> f6536a;

        /* renamed from: b */
        private final String f6537b;

        /* renamed from: c */
        private final PrivateKey f6538c;

        private b(String str, PrivateKey privateKey, List<X509Certificate> list) {
            this.f6537b = str;
            this.f6538c = privateKey;
            this.f6536a = Collections.unmodifiableList(new ArrayList(list));
        }

        /* synthetic */ b(String str, PrivateKey privateKey, List list, b bVar) {
            this(str, privateKey, list);
        }

        /* renamed from: b */
        public String m8621b() {
            return this.f6537b;
        }

        /* renamed from: c */
        public PrivateKey m8622c() {
            return this.f6538c;
        }

        /* renamed from: a */
        public List<X509Certificate> m8620a() {
            return this.f6536a;
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.c.a$c */
    public static class c {

        /* renamed from: a */
        private final List<X509Certificate> f6546a;

        /* renamed from: b */
        private final String f6547b;

        /* renamed from: c */
        private final PrivateKey f6548c;

        public c(String str, PrivateKey privateKey, List<X509Certificate> list) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Empty name");
            }
            this.f6547b = str;
            this.f6548c = privateKey;
            this.f6546a = new ArrayList(list);
        }

        /* renamed from: a */
        public b m8634a() {
            return new b(this.f6547b, this.f6548c, this.f6546a, null);
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.c.a$a */
    public static class a {

        /* renamed from: a */
        private String f6524a;

        /* renamed from: b */
        private InterfaceC1069c f6525b;

        /* renamed from: c */
        private File f6526c;

        /* renamed from: d */
        private Integer f6527d;

        /* renamed from: e */
        private boolean f6528e;

        /* renamed from: f */
        private InterfaceC1067a f6529f;

        /* renamed from: g */
        private InterfaceC1069c f6530g;

        /* renamed from: h */
        private File f6531h;

        /* renamed from: i */
        private final List<b> f6532i;

        /* renamed from: j */
        private final InterfaceC1041b f6533j;

        /* renamed from: k */
        private boolean f6534k = true;

        /* renamed from: l */
        private boolean f6535l = true;

        public a(List<b> list) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            this.f6532i = new ArrayList(list);
            this.f6533j = null;
        }

        /* renamed from: a */
        public a m8614a(File file) {
            if (file == null) {
                throw new NullPointerException("inputApk == null");
            }
            this.f6526c = file;
            this.f6525b = null;
            return this;
        }

        /* renamed from: b */
        public a m8618b(File file) {
            if (file == null) {
                throw new NullPointerException("outputApk == null");
            }
            this.f6531h = file;
            this.f6529f = null;
            this.f6530g = null;
            return this;
        }

        /* renamed from: a */
        public a m8613a(int i) {
            m8612b();
            this.f6527d = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public a m8616a(boolean z) {
            m8612b();
            this.f6534k = z;
            return this;
        }

        /* renamed from: b */
        public a m8619b(boolean z) {
            m8612b();
            this.f6535l = z;
            return this;
        }

        /* renamed from: a */
        public a m8615a(String str) {
            m8612b();
            if (str == null) {
                throw new NullPointerException();
            }
            this.f6524a = str;
            return this;
        }

        /* renamed from: b */
        private void m8612b() {
            if (this.f6533j != null) {
                throw new IllegalStateException("Operation is not available when builder initialized with an engine");
            }
        }

        /* renamed from: a */
        public C1036a m8617a() {
            return new C1036a(this.f6532i, this.f6527d, this.f6534k, this.f6535l, this.f6528e, this.f6524a, this.f6533j, this.f6526c, this.f6525b, this.f6531h, this.f6529f, this.f6530g, null);
        }
    }
}
