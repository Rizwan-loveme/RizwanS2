package ru.p294a;

import android.widget.ExpandableListView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* compiled from: ZipFile.java */
/* renamed from: ru.a.w */
/* loaded from: classes.dex */
public class C2604w implements Closeable {

    /* renamed from: n */
    private static final long f13489n = C2605x.m16174a(C2606y.f13524f);

    /* renamed from: a */
    private final List<C2602u> f13490a;

    /* renamed from: b */
    private final Map<String, LinkedList<C2602u>> f13491b;

    /* renamed from: c */
    private final String f13492c;

    /* renamed from: d */
    private final InterfaceC2600s f13493d;

    /* renamed from: e */
    private final String f13494e;

    /* renamed from: f */
    private final RandomAccessFile f13495f;

    /* renamed from: g */
    private final boolean f13496g;

    /* renamed from: h */
    private volatile boolean f13497h;

    /* renamed from: i */
    private final byte[] f13498i;

    /* renamed from: j */
    private final byte[] f13499j;

    /* renamed from: k */
    private final byte[] f13500k;

    /* renamed from: l */
    private final byte[] f13501l;

    /* renamed from: m */
    private String f13502m;

    /* renamed from: o */
    private final Comparator<C2602u> f13503o;

    /* compiled from: ZipFile.java */
    /* renamed from: ru.a.w$d */
    private static final class d {

        /* renamed from: a */
        private long f13514a = -1;

        /* renamed from: b */
        private long f13515b = -1;
    }

    public C2604w(File file) {
        this(file, (String) null);
    }

    public C2604w(String str) {
        this(new File(str), (String) null);
    }

    public C2604w(File file, String str) {
        this(file, str, true);
    }

    public C2604w(File file, String str, boolean z) {
        this.f13490a = new LinkedList();
        this.f13491b = new HashMap(509);
        this.f13498i = new byte[8];
        this.f13499j = new byte[4];
        this.f13500k = new byte[42];
        this.f13501l = new byte[2];
        this.f13503o = new Comparator<C2602u>(this) { // from class: ru.a.w.2

            /* renamed from: a */
            private final C2604w f13506a;

            {
                this.f13506a = this;
            }

            @Override // java.util.Comparator
            public int compare(C2602u c2602u, C2602u c2602u2) {
                return m16165a(c2602u, c2602u2);
            }

            /* renamed from: a */
            public int m16165a(C2602u c2602u, C2602u c2602u2) {
                if (c2602u == c2602u2) {
                    return 0;
                }
                b bVar = c2602u instanceof b ? (b) c2602u : (b) null;
                b bVar2 = c2602u2 instanceof b ? (b) c2602u2 : (b) null;
                if (bVar == null) {
                    return 1;
                }
                if (bVar2 == null) {
                    return -1;
                }
                long j = bVar.m16167h().f13514a - bVar2.m16167h().f13514a;
                return j == ((long) 0) ? 0 : j < ((long) 0) ? -1 : 1;
            }
        };
        this.f13494e = file.getAbsolutePath();
        this.f13492c = str;
        this.f13493d = AbstractC2601t.m16114a(str);
        this.f13496g = z;
        this.f13495f = new RandomAccessFile(file, "r");
        try {
            m16153b(m16154d());
            this.f13497h = false;
        } catch (Throwable th) {
            this.f13497h = true;
            try {
                this.f13495f.close();
            } catch (IOException e2) {
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13497h = true;
        this.f13495f.close();
    }

    /* renamed from: a */
    public Enumeration<C2602u> m16161a() {
        return Collections.enumeration(this.f13490a);
    }

    /* renamed from: b */
    public Enumeration<C2602u> m16163b() {
        return m16161a();
    }

    /* renamed from: c */
    public String m16164c() {
        return this.f13502m;
    }

    /* renamed from: a */
    public C2602u m16162a(String str) {
        LinkedList<C2602u> linkedList = this.f13491b.get(str);
        return linkedList != null ? linkedList.getFirst() : (C2602u) null;
    }

    /* renamed from: a */
    public InputStream m16160a(C2602u c2602u) {
        if (!(c2602u instanceof b)) {
            return (InputStream) null;
        }
        d m16167h = ((b) c2602u).m16167h();
        AbstractC2582aa.m16055a(c2602u);
        a aVar = new a(this, m16167h.f13515b, c2602u.getCompressedSize());
        switch (c2602u.getMethod()) {
            case 0:
                return aVar;
            case 8:
                aVar.m16166a();
                Inflater inflater = new Inflater(true);
                return new InflaterInputStream(this, aVar, inflater, inflater) { // from class: ru.a.w.1

                    /* renamed from: a */
                    private final C2604w f13504a;

                    /* renamed from: b */
                    private final Inflater f13505b;

                    {
                        this.f13504a = this;
                        this.f13505b = inflater;
                    }

                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        super.close();
                        this.f13505b.end();
                    }
                };
            default:
                throw new ZipException(new StringBuffer().append("Found unsupported compression method ").append(c2602u.getMethod()).toString());
        }
    }

    protected void finalize() {
        try {
            if (!this.f13497h) {
                System.err.printf("Cleaning up unclosed %s for archive %s%n", getClass().getSimpleName(), this.f13494e);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: d */
    private Map<C2602u, c> m16154d() {
        HashMap hashMap = new HashMap();
        m16155e();
        this.f13495f.readFully(this.f13499j);
        long m16174a = C2605x.m16174a(this.f13499j);
        if (m16174a != f13489n && m16159i()) {
            throw new IOException("central directory is empty, can't expand corrupt archive.");
        }
        while (m16174a == f13489n) {
            m16150a(hashMap);
            this.f13495f.readFully(this.f13499j);
            m16174a = C2605x.m16174a(this.f13499j);
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m16150a(Map<C2602u, c> map) {
        this.f13495f.readFully(this.f13500k);
        d dVar = new d();
        b bVar = new b(dVar);
        bVar.m16141b((C2607z.m16238a(this.f13500k, 0) >> 8) & 15);
        C2587f m16080b = C2587f.m16080b(this.f13500k, 4);
        boolean m16083a = m16080b.m16083a();
        InterfaceC2600s interfaceC2600s = m16083a ? AbstractC2601t.f13471b : this.f13493d;
        bVar.m16133a(m16080b);
        bVar.setMethod(C2607z.m16238a(this.f13500k, 6));
        bVar.setTime(AbstractC2582aa.m16052a(C2605x.m16177b(this.f13500k, 8)));
        bVar.setCrc(C2605x.m16177b(this.f13500k, 12));
        bVar.setCompressedSize(C2605x.m16177b(this.f13500k, 16));
        bVar.setSize(C2605x.m16177b(this.f13500k, 20));
        int m16238a = C2607z.m16238a(this.f13500k, 24);
        int m16238a2 = C2607z.m16238a(this.f13500k, 26);
        int m16238a3 = C2607z.m16238a(this.f13500k, 28);
        int m16238a4 = C2607z.m16238a(this.f13500k, 30);
        bVar.m16129a(C2607z.m16238a(this.f13500k, 32));
        bVar.m16130a(C2605x.m16177b(this.f13500k, 34));
        if (this.f13495f.length() - this.f13495f.getFilePointer() < m16238a) {
            throw new EOFException();
        }
        byte[] bArr = new byte[m16238a];
        this.f13495f.readFully(bArr);
        bVar.m16132a(interfaceC2600s.mo16077a(bArr), bArr);
        dVar.f13514a = C2605x.m16177b(this.f13500k, 38);
        this.f13490a.add(bVar);
        if (this.f13495f.length() - this.f13495f.getFilePointer() < m16238a2) {
            throw new EOFException();
        }
        byte[] bArr2 = new byte[m16238a2];
        this.f13495f.readFully(bArr2);
        bVar.m16136a(bArr2);
        m16151a(bVar, dVar, m16238a4);
        if (this.f13495f.length() - this.f13495f.getFilePointer() < m16238a3) {
            throw new EOFException();
        }
        byte[] bArr3 = new byte[m16238a3];
        this.f13495f.readFully(bArr3);
        bVar.setComment(interfaceC2600s.mo16077a(bArr3));
        if (m16083a || !this.f13496g) {
            return;
        }
        map.put(bVar, new c(bArr, bArr3));
    }

    /* renamed from: a */
    private void m16151a(C2602u c2602u, d dVar, int i) {
        C2596o c2596o = (C2596o) c2602u.m16140b(C2596o.f13457a);
        if (c2596o != null) {
            boolean z = c2602u.getSize() == ExpandableListView.PACKED_POSITION_VALUE_NULL;
            boolean z2 = c2602u.getCompressedSize() == ExpandableListView.PACKED_POSITION_VALUE_NULL;
            boolean z3 = dVar.f13514a == ExpandableListView.PACKED_POSITION_VALUE_NULL;
            c2596o.m16098a(z, z2, z3, i == 65535);
            if (z) {
                c2602u.setSize(c2596o.m16099b().m16111b());
            } else if (z2) {
                c2596o.m16097a(new C2599r(c2602u.getSize()));
            }
            if (z2) {
                c2602u.setCompressedSize(c2596o.m16102g().m16111b());
            } else if (z) {
                c2596o.m16100b(new C2599r(c2602u.getCompressedSize()));
            }
            if (z3) {
                dVar.f13514a = c2596o.m16103h().m16111b();
            }
        }
    }

    /* renamed from: e */
    private void m16155e() {
        boolean z = false;
        m16158h();
        boolean z2 = this.f13495f.getFilePointer() > ((long) 20);
        if (z2) {
            this.f13495f.seek(this.f13495f.getFilePointer() - 20);
            this.f13495f.readFully(this.f13499j);
            z = Arrays.equals(C2606y.f13527i, this.f13499j);
        }
        if (!z) {
            if (z2) {
                m16149a(16);
            }
            m16157g();
            return;
        }
        m16156f();
    }

    /* renamed from: f */
    private void m16156f() {
        m16149a(4);
        this.f13495f.readFully(this.f13498i);
        this.f13495f.seek(C2599r.m16105a(this.f13498i));
        this.f13495f.readFully(this.f13499j);
        if (!Arrays.equals(this.f13499j, C2606y.f13526h)) {
            throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
        }
        m16149a(44);
        this.f13495f.readFully(this.f13498i);
        this.f13495f.seek(C2599r.m16105a(this.f13498i));
    }

    /* renamed from: g */
    private void m16157g() {
        m16149a(16);
        this.f13495f.readFully(this.f13499j);
        this.f13495f.seek(C2605x.m16174a(this.f13499j));
    }

    /* renamed from: h */
    private void m16158h() {
        if (!m16152a(22, 65557, C2606y.f13525g)) {
            throw new ZipException("archive is not a ZIP archive");
        }
        long filePointer = this.f13495f.getFilePointer();
        this.f13495f.seek((22 + filePointer) - 2);
        this.f13495f.readFully(this.f13501l);
        int m16237a = C2607z.m16237a(this.f13501l);
        if (m16237a > 0) {
            byte[] bArr = new byte[m16237a];
            this.f13495f.readFully(bArr);
            this.f13502m = this.f13493d.mo16077a(bArr);
        } else {
            this.f13502m = (String) null;
        }
        this.f13495f.seek(filePointer);
    }

    /* renamed from: a */
    private boolean m16152a(long j, long j2, byte[] bArr) {
        boolean z = false;
        long length = this.f13495f.length() - j;
        long max = Math.max(0L, this.f13495f.length() - j2);
        if (length >= 0) {
            while (true) {
                if (length >= max) {
                    this.f13495f.seek(length);
                    int read = this.f13495f.read();
                    if (read != -1) {
                        if (read == bArr[0] && this.f13495f.read() == bArr[1] && this.f13495f.read() == bArr[2] && this.f13495f.read() == bArr[3]) {
                            z = true;
                            break;
                        }
                        length--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.f13495f.seek(length);
        }
        return z;
    }

    /* renamed from: a */
    private void m16149a(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = this.f13495f.skipBytes(i - i2);
            if (skipBytes <= 0) {
                throw new EOFException();
            }
            i2 += skipBytes;
        }
    }

    /* renamed from: b */
    private void m16153b(Map<C2602u, c> map) {
        Iterator<C2602u> it = this.f13490a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            d m16167h = bVar.m16167h();
            long j = m16167h.f13514a;
            this.f13495f.seek(26 + j);
            this.f13495f.readFully(this.f13501l);
            int m16237a = C2607z.m16237a(this.f13501l);
            this.f13495f.readFully(this.f13501l);
            int m16237a2 = C2607z.m16237a(this.f13501l);
            int i = m16237a;
            while (i > 0) {
                int skipBytes = this.f13495f.skipBytes(i);
                if (skipBytes <= 0) {
                    throw new IOException("failed to skip file name in local file header");
                }
                i -= skipBytes;
            }
            if (this.f13495f.length() - this.f13495f.getFilePointer() < m16237a2) {
                throw new EOFException();
            }
            byte[] bArr = new byte[m16237a2];
            this.f13495f.readFully(bArr);
            try {
                bVar.setExtra(bArr);
                m16167h.f13515b = j + 26 + 2 + 2 + m16237a + m16237a2;
                if (map.containsKey(bVar)) {
                    c cVar = map.get(bVar);
                    AbstractC2582aa.m16056a(bVar, cVar.f13512a, cVar.f13513b);
                }
                String name = bVar.getName();
                LinkedList<C2602u> linkedList = this.f13491b.get(name);
                if (linkedList == null) {
                    linkedList = new LinkedList<>();
                    this.f13491b.put(name, linkedList);
                }
                linkedList.addLast(bVar);
            } catch (RuntimeException e2) {
                ZipException zipException = new ZipException(new StringBuffer().append("Invalid extra data in entry ").append(bVar.getName()).toString());
                zipException.initCause(e2);
                throw zipException;
            }
        }
    }

    /* renamed from: i */
    private boolean m16159i() {
        this.f13495f.seek(0);
        this.f13495f.readFully(this.f13499j);
        return Arrays.equals(this.f13499j, C2606y.f13522d);
    }

    /* compiled from: ZipFile.java */
    /* renamed from: ru.a.w$a */
    private class a extends InputStream {

        /* renamed from: a */
        private long f13507a;

        /* renamed from: b */
        private long f13508b;

        /* renamed from: c */
        private boolean f13509c = false;

        /* renamed from: d */
        private final C2604w f13510d;

        a(C2604w c2604w, long j, long j2) {
            this.f13510d = c2604w;
            this.f13507a = j2;
            this.f13508b = j;
        }

        @Override // java.io.InputStream
        public int read() {
            int read;
            long j = this.f13507a;
            this.f13507a = (-1) + j;
            if (j <= 0) {
                if (this.f13509c) {
                    this.f13509c = false;
                    return 0;
                }
                return -1;
            }
            synchronized (this.f13510d.f13495f) {
                RandomAccessFile randomAccessFile = this.f13510d.f13495f;
                long j2 = this.f13508b;
                this.f13508b = 1 + j2;
                randomAccessFile.seek(j2);
                read = this.f13510d.f13495f.read();
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.f13507a <= 0) {
                if (this.f13509c) {
                    this.f13509c = false;
                    bArr[i] = (byte) 0;
                    return 1;
                }
                return -1;
            }
            if (i2 <= 0) {
                return 0;
            }
            if (i2 > this.f13507a) {
                i2 = (int) this.f13507a;
            }
            synchronized (this.f13510d.f13495f) {
                this.f13510d.f13495f.seek(this.f13508b);
                read = this.f13510d.f13495f.read(bArr, i, i2);
            }
            if (read > 0) {
                this.f13508b += read;
                this.f13507a -= read;
                return read;
            }
            return read;
        }

        /* renamed from: a */
        void m16166a() {
            this.f13509c = true;
        }
    }

    /* compiled from: ZipFile.java */
    /* renamed from: ru.a.w$c */
    private static final class c {

        /* renamed from: a */
        private final byte[] f13512a;

        /* renamed from: b */
        private final byte[] f13513b;

        c(byte[] bArr, byte[] bArr2) {
            this.f13512a = bArr;
            this.f13513b = bArr2;
        }
    }

    /* compiled from: ZipFile.java */
    /* renamed from: ru.a.w$b */
    private static class b extends C2602u {

        /* renamed from: a */
        private final d f13511a;

        b(d dVar) {
            this.f13511a = dVar;
        }

        /* renamed from: h */
        d m16167h() {
            return this.f13511a;
        }

        @Override // ru.p294a.C2602u, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) (this.f13511a.f13514a % Integer.MAX_VALUE));
        }

        @Override // ru.p294a.C2602u
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f13511a.f13514a == bVar.f13511a.f13514a && this.f13511a.f13515b == bVar.f13511a.f13515b;
        }
    }
}
