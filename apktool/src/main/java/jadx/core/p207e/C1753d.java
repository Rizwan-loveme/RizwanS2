package jadx.core.p207e;

import android.widget.ExpandableListView;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ParserStream.java */
/* renamed from: jadx.core.e.d */
/* loaded from: classes.dex */
public class C1753d {

    /* renamed from: a */
    protected static final Charset f10644a = Charset.forName("UTF-16LE");

    /* renamed from: b */
    protected static final Charset f10645b = Charset.forName("UTF-8");

    /* renamed from: c */
    private static final int[] f10646c = new int[0];

    /* renamed from: d */
    private static final byte[] f10647d = new byte[0];

    /* renamed from: e */
    private final InputStream f10648e;

    /* renamed from: f */
    private long f10649f = 0;

    public C1753d(InputStream inputStream) {
        this.f10648e = inputStream;
    }

    /* renamed from: a */
    public long m13348a() {
        return this.f10649f;
    }

    /* renamed from: b */
    public int m13353b() {
        this.f10649f++;
        return this.f10648e.read();
    }

    /* renamed from: c */
    public int m13357c() {
        this.f10649f += 2;
        return (this.f10648e.read() & 255) | ((this.f10648e.read() & 255) << 8);
    }

    /* renamed from: d */
    public int m13359d() {
        this.f10649f += 4;
        InputStream inputStream = this.f10648e;
        int read = inputStream.read();
        return (inputStream.read() << 24) | ((inputStream.read() & 255) << 16) | ((inputStream.read() & 255) << 8) | (read & 255);
    }

    /* renamed from: e */
    public long m13360e() {
        return m13359d() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: a */
    public String m13349a(int i) {
        return new String(m13358c(i * 2), f10644a).trim();
    }

    /* renamed from: b */
    public int[] m13356b(int i) {
        if (i == 0) {
            return f10646c;
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = m13359d();
        }
        return iArr;
    }

    /* renamed from: c */
    public byte[] m13358c(int i) {
        if (i == 0) {
            return f10647d;
        }
        this.f10649f += i;
        byte[] bArr = new byte[i];
        int read = this.f10648e.read(bArr, 0, i);
        while (read < i) {
            int read2 = this.f10648e.read(bArr, read, i - read);
            if (read2 == -1) {
                throw new IOException("No data, can't read " + i + " bytes");
            }
            read += read2;
        }
        return bArr;
    }

    /* renamed from: a */
    public void m13351a(long j) {
        this.f10649f += j;
        long skip = this.f10648e.skip(j);
        while (skip < j) {
            long skip2 = this.f10648e.skip(j - skip);
            if (skip2 == -1) {
                throw new IOException("No data, can't skip " + j + " bytes");
            }
            skip += skip2;
        }
    }

    /* renamed from: a */
    public void m13350a(int i, String str) {
        int m13353b = m13353b();
        if (m13353b != i) {
            m13347a(str, i, m13353b);
        }
    }

    /* renamed from: b */
    public void m13354b(int i, String str) {
        int m13357c = m13357c();
        if (m13357c != i) {
            m13347a(str, i, m13357c);
        }
    }

    /* renamed from: a */
    private void m13347a(String str, int i, int i2) {
        throw new IOException(String.valueOf(str) + ", expected: 0x" + Integer.toHexString(i) + ", actual: 0x" + Integer.toHexString(i2) + ", offset: 0x" + Long.toHexString(m13348a()));
    }

    /* renamed from: a */
    public void m13352a(long j, String str) {
        if (m13348a() != j) {
            throw new IOException(String.valueOf(str) + ", expected offset: 0x" + Long.toHexString(j) + ", actual: 0x" + Long.toHexString(m13348a()));
        }
    }

    /* renamed from: b */
    public void m13355b(long j, String str) {
        long m13348a = m13348a();
        if (m13348a < j) {
            m13351a(j - m13348a);
        }
        m13352a(j, str);
    }

    public String toString() {
        return "pos: 0x" + Long.toHexString(this.f10649f);
    }
}
