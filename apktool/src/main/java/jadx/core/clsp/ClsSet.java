package jadx.core.clsp;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p203d.p205b.C1725b;
import jadx.core.p203d.p205b.C1729f;
import java.p209io.DataInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* loaded from: classes.dex */
public class ClsSet {

    /* renamed from: a */
    private static final InterfaceC2558b f10567a = C2568c.m15995a((Class<?>) ClsSet.class);

    /* renamed from: b */
    private static final String f10568b = ClsSet.class.getPackage().getName().replace('.', '/');

    /* renamed from: c */
    private C1720b[] f10569c;

    /* renamed from: a */
    public static C1720b[] m13169a(C1636b c1636b, Map<String, C1720b> map) {
        C1720b m13167a;
        ArrayList arrayList = new ArrayList(c1636b.m12528h().size() + 1);
        AbstractC1596a m12527g = c1636b.m12527g();
        if (m12527g != null && (m13167a = m13167a(m12527g.mo12279e(), map)) != null) {
            arrayList.add(m13167a);
        }
        Iterator<AbstractC1596a> it = c1636b.m12528h().iterator();
        while (it.hasNext()) {
            C1720b m13167a2 = m13167a(it.next().mo12279e(), map);
            if (m13167a2 != null) {
                arrayList.add(m13167a2);
            }
        }
        return (C1720b[]) arrayList.toArray(new C1720b[arrayList.size()]);
    }

    /* renamed from: a */
    private static C1720b m13167a(String str, Map<String, C1720b> map) {
        C1720b c1720b = map.get(str);
        if (c1720b == null && !map.containsKey(str)) {
            f10567a.mo15931a("Class not found: {}", str);
        }
        return c1720b;
    }

    /* renamed from: a */
    public void m13170a() {
        InputStream resourceAsStream = getClass().getResourceAsStream("core.jcst");
        if (resourceAsStream == null) {
            throw new C1729f("Can't load classpath file: core.jcst");
        }
        m13171a(resourceAsStream);
        resourceAsStream.close();
    }

    /* renamed from: a */
    public void m13171a(InputStream inputStream) {
        Throwable th = null;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            try {
                byte[] bArr = new byte["jadx-cst".length()];
                int read = dataInputStream.read(bArr);
                byte readByte = dataInputStream.readByte();
                if (read != "jadx-cst".length() || !"jadx-cst".equals(new String(bArr, "US-ASCII")) || readByte != 1) {
                    throw new C1725b("Wrong jadx class set header");
                }
                int readInt = dataInputStream.readInt();
                this.f10569c = new C1720b[readInt];
                for (int i = 0; i < readInt; i++) {
                    this.f10569c[i] = new C1720b(m13168a(dataInputStream), i);
                }
                for (int i2 = 0; i2 < readInt; i2++) {
                    int readByte2 = dataInputStream.readByte();
                    C1720b[] c1720bArr = new C1720b[readByte2];
                    for (int i3 = 0; i3 < readByte2; i3++) {
                        c1720bArr[i3] = this.f10569c[dataInputStream.readInt()];
                    }
                    this.f10569c[i2].m13184a(c1720bArr);
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } finally {
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
        }
    }

    /* renamed from: a */
    private static String m13168a(DataInputStream dataInputStream) {
        int readByte = dataInputStream.readByte();
        byte[] bArr = new byte[readByte];
        int read = dataInputStream.read(bArr);
        while (read != readByte) {
            int read2 = dataInputStream.read(bArr, read, readByte - read);
            if (read2 == -1) {
                throw new IOException("String read error");
            }
            read += read2;
        }
        return new String(bArr, "US-ASCII");
    }

    /* renamed from: b */
    public int m13173b() {
        return this.f10569c.length;
    }

    /* renamed from: a */
    public void m13172a(Map<String, C1720b> map) {
        for (C1720b c1720b : this.f10569c) {
            map.put(c1720b.m13183a(), c1720b);
        }
    }
}
