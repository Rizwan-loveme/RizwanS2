package com.p065b.p086b.p100d;

import com.p065b.p086b.p095c.C0825c;
import com.p065b.p086b.p100d.C0894b;
import com.p065b.p086b.p100d.C0896d;
import com.p065b.p086b.p102e.C0913f;
import com.p065b.p086b.p110h.C1018i;
import com.p065b.p086b.p110h.C1020k;
import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.C1033x;
import com.p065b.p086b.p110h.InterfaceC1016g;
import com.p065b.p086b.p110h.InterfaceC1017h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: DexBuffer.java */
/* renamed from: com.b.b.d.f */
/* loaded from: classes.dex */
public final class C0898f {

    /* renamed from: a */
    private byte[] f5445a;

    /* renamed from: b */
    private final C0825c f5446b;

    /* renamed from: c */
    private int f5447c;

    /* renamed from: d */
    private final List<String> f5448d;

    /* renamed from: e */
    private final List<Integer> f5449e;

    /* renamed from: f */
    private final List<String> f5450f;

    /* renamed from: g */
    private final List<C0907o> f5451g;

    /* renamed from: h */
    private final List<C0902j> f5452h;

    /* renamed from: i */
    private final List<C0904l> f5453i;

    public C0898f() {
        this.f5446b = new C0825c();
        this.f5447c = 0;
        this.f5448d = new AbstractList<String>() { // from class: com.b.b.d.f.1
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5117b.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5117b.f5144c + (i * 4)).m7641i();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5117b.f5143b;
            }
        };
        this.f5449e = new AbstractList<Integer>() { // from class: com.b.b.d.f.2
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return Integer.valueOf(C0898f.this.m7595a(C0898f.this.f5446b.f5118c.f5144c + (i * 4)).m7628b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5450f = new AbstractList<String>() { // from class: com.b.b.d.f.3
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return (String) C0898f.this.f5448d.get(((Integer) C0898f.this.f5449e.get(i)).intValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5451g = new AbstractList<C0907o>() { // from class: com.b.b.d.f.4
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0907o get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5119d.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5119d.f5144c + (i * 12)).m7644l();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5119d.f5143b;
            }
        };
        this.f5452h = new AbstractList<C0902j>() { // from class: com.b.b.d.f.5
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0902j get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5120e.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5120e.f5144c + (i * 8)).m7642j();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5120e.f5143b;
            }
        };
        this.f5453i = new AbstractList<C0904l>() { // from class: com.b.b.d.f.6
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0904l get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5121f.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5121f.f5144c + (i * 8)).m7643k();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5121f.f5143b;
            }
        };
        this.f5445a = new byte[0];
    }

    public C0898f(byte[] bArr) {
        this.f5446b = new C0825c();
        this.f5447c = 0;
        this.f5448d = new AbstractList<String>() { // from class: com.b.b.d.f.1
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5117b.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5117b.f5144c + (i * 4)).m7641i();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5117b.f5143b;
            }
        };
        this.f5449e = new AbstractList<Integer>() { // from class: com.b.b.d.f.2
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return Integer.valueOf(C0898f.this.m7595a(C0898f.this.f5446b.f5118c.f5144c + (i * 4)).m7628b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5450f = new AbstractList<String>() { // from class: com.b.b.d.f.3
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return (String) C0898f.this.f5448d.get(((Integer) C0898f.this.f5449e.get(i)).intValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5451g = new AbstractList<C0907o>() { // from class: com.b.b.d.f.4
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0907o get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5119d.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5119d.f5144c + (i * 12)).m7644l();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5119d.f5143b;
            }
        };
        this.f5452h = new AbstractList<C0902j>() { // from class: com.b.b.d.f.5
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0902j get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5120e.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5120e.f5144c + (i * 8)).m7642j();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5120e.f5143b;
            }
        };
        this.f5453i = new AbstractList<C0904l>() { // from class: com.b.b.d.f.6
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0904l get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5121f.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5121f.f5144c + (i * 8)).m7643k();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5121f.f5143b;
            }
        };
        this.f5445a = bArr;
        this.f5447c = bArr.length;
        this.f5446b.m7192a(this);
    }

    public C0898f(File file) {
        this.f5446b = new C0825c();
        this.f5447c = 0;
        this.f5448d = new AbstractList<String>() { // from class: com.b.b.d.f.1
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5117b.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5117b.f5144c + (i * 4)).m7641i();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5117b.f5143b;
            }
        };
        this.f5449e = new AbstractList<Integer>() { // from class: com.b.b.d.f.2
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return Integer.valueOf(C0898f.this.m7595a(C0898f.this.f5446b.f5118c.f5144c + (i * 4)).m7628b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5450f = new AbstractList<String>() { // from class: com.b.b.d.f.3
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5118c.f5143b);
                return (String) C0898f.this.f5448d.get(((Integer) C0898f.this.f5449e.get(i)).intValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5118c.f5143b;
            }
        };
        this.f5451g = new AbstractList<C0907o>() { // from class: com.b.b.d.f.4
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0907o get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5119d.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5119d.f5144c + (i * 12)).m7644l();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5119d.f5143b;
            }
        };
        this.f5452h = new AbstractList<C0902j>() { // from class: com.b.b.d.f.5
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0902j get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5120e.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5120e.f5144c + (i * 8)).m7642j();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5120e.f5143b;
            }
        };
        this.f5453i = new AbstractList<C0904l>() { // from class: com.b.b.d.f.6
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0904l get(int i) {
                C0898f.m7587b(i, C0898f.this.f5446b.f5121f.f5143b);
                return C0898f.this.m7595a(C0898f.this.f5446b.f5121f.f5144c + (i * 8)).m7643k();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C0898f.this.f5446b.f5121f.f5143b;
            }
        };
        if (C1020k.m8541a(file.getName())) {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry != null) {
                m7585a(zipFile.getInputStream(entry));
                zipFile.close();
                return;
            }
            throw new C1018i("Expected classes.dex in " + file);
        }
        if (file.getName().endsWith(".dex")) {
            m7585a(new FileInputStream(file));
            return;
        }
        throw new C1018i("unknown output extension: " + file);
    }

    /* renamed from: a */
    private void m7585a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                this.f5445a = byteArrayOutputStream.toByteArray();
                this.f5447c = this.f5445a.length;
                this.f5446b.m7192a(this);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m7587b(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    /* renamed from: a */
    public void m7597a(OutputStream outputStream) {
        outputStream.write(this.f5445a);
    }

    /* renamed from: a */
    public C0825c m7592a() {
        return this.f5446b;
    }

    /* renamed from: a */
    public a m7595a(int i) {
        if (i < 0 || i > this.f5447c) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.f5447c);
        }
        return new a(i);
    }

    /* renamed from: a */
    public a m7596a(int i, String str) {
        int m7590d = m7590d(this.f5447c + i);
        a aVar = new a(str, this.f5447c, m7590d);
        this.f5447c = m7590d;
        return aVar;
    }

    /* renamed from: b */
    public void m7599b() {
        this.f5445a = new byte[this.f5447c];
    }

    /* renamed from: c */
    public int m7600c() {
        return this.f5447c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m7590d(int i) {
        return (i + 3) & (-4);
    }

    /* renamed from: d */
    public byte[] m7601d() {
        return this.f5445a;
    }

    /* renamed from: e */
    public List<String> m7602e() {
        return this.f5448d;
    }

    /* renamed from: f */
    public List<String> m7603f() {
        return this.f5450f;
    }

    /* renamed from: g */
    public List<C0907o> m7604g() {
        return this.f5451g;
    }

    /* renamed from: h */
    public Iterable<C0895c> m7605h() {
        return new Iterable<C0895c>() { // from class: com.b.b.d.f.7
            @Override // java.lang.Iterable
            public Iterator<C0895c> iterator() {
                return !C0898f.this.f5446b.f5122g.m7195a() ? Collections.emptySet().iterator() : new Iterator<C0895c>() { // from class: com.b.b.d.f.7.1

                    /* renamed from: b */
                    private a f5462b;

                    /* renamed from: c */
                    private int f5463c = 0;

                    {
                        this.f5462b = C0898f.this.m7595a(C0898f.this.f5446b.f5122g.f5144c);
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f5463c < C0898f.this.f5446b.f5122g.f5143b;
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public C0895c next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        this.f5463c++;
                        return this.f5462b.m7645m();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    /* renamed from: b */
    public C0913f m7598b(int i) {
        return i == 0 ? C0913f.f5839a : m7595a(i).m7640h();
    }

    /* renamed from: a */
    public C0894b m7593a(C0895c c0895c) {
        int m7561i = c0895c.m7561i();
        if (m7561i == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return m7595a(m7561i).m7620v();
    }

    /* renamed from: a */
    public C0896d m7594a(C0894b.b bVar) {
        int m7552c = bVar.m7552c();
        if (m7552c == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return m7595a(m7552c).m7618t();
    }

    /* compiled from: DexBuffer.java */
    /* renamed from: com.b.b.d.f$a */
    public final class a implements InterfaceC1016g, InterfaceC1017h {

        /* renamed from: b */
        private final String f5465b;

        /* renamed from: c */
        private int f5466c;

        /* renamed from: d */
        private final int f5467d;

        private a(String str, int i, int i2) {
            this.f5465b = str;
            this.f5466c = i;
            this.f5467d = i2;
        }

        private a(C0898f c0898f, int i) {
            this("section", i, c0898f.f5445a.length);
        }

        /* renamed from: a */
        public int m7621a() {
            return this.f5466c;
        }

        /* renamed from: b */
        public int m7628b() {
            int i = (C0898f.this.f5445a[this.f5466c] & 255) | ((C0898f.this.f5445a[this.f5466c + 1] & 255) << 8) | ((C0898f.this.f5445a[this.f5466c + 2] & 255) << 16) | ((C0898f.this.f5445a[this.f5466c + 3] & 255) << 24);
            this.f5466c += 4;
            return i;
        }

        /* renamed from: c */
        public short m7630c() {
            int i = (C0898f.this.f5445a[this.f5466c] & 255) | ((C0898f.this.f5445a[this.f5466c + 1] & 255) << 8);
            this.f5466c += 2;
            return (short) i;
        }

        /* renamed from: d */
        public int m7632d() {
            return m7630c() & 65535;
        }

        @Override // com.p065b.p086b.p110h.InterfaceC1016g
        /* renamed from: e */
        public byte mo7634e() {
            byte[] bArr = C0898f.this.f5445a;
            int i = this.f5466c;
            this.f5466c = i + 1;
            return (byte) (bArr[i] & 255);
        }

        /* renamed from: a */
        public byte[] m7627a(int i) {
            byte[] copyOfRange = Arrays.copyOfRange(C0898f.this.f5445a, this.f5466c, this.f5466c + i);
            this.f5466c += i;
            return copyOfRange;
        }

        /* renamed from: b */
        public short[] m7629b(int i) {
            short[] sArr = new short[i];
            for (int i2 = 0; i2 < i; i2++) {
                sArr[i2] = m7630c();
            }
            return sArr;
        }

        /* renamed from: f */
        public int m7636f() {
            return C1029t.m8591b(this);
        }

        /* renamed from: g */
        public int m7638g() {
            return C1029t.m8589a(this);
        }

        /* renamed from: h */
        public C0913f m7640h() {
            int m7628b = m7628b();
            short[] sArr = new short[m7628b];
            for (int i = 0; i < m7628b; i++) {
                sArr[i] = m7630c();
            }
            m7649q();
            return new C0913f(C0898f.this, sArr);
        }

        /* renamed from: i */
        public String m7641i() {
            int m7628b = m7628b();
            int i = this.f5466c;
            this.f5466c = m7628b;
            try {
                try {
                    int m7636f = m7636f();
                    String m8598a = C1033x.m8598a(this, new char[m7636f]);
                    if (m8598a.length() != m7636f) {
                        throw new C1018i("Declared length " + m7636f + " doesn't match decoded length of " + m8598a.length());
                    }
                    return m8598a;
                } catch (UTFDataFormatException e2) {
                    throw new C1018i(e2);
                }
            } finally {
                this.f5466c = i;
            }
        }

        /* renamed from: j */
        public C0902j m7642j() {
            return new C0902j(C0898f.this, m7632d(), m7632d(), m7628b());
        }

        /* renamed from: k */
        public C0904l m7643k() {
            return new C0904l(C0898f.this, m7632d(), m7632d(), m7628b());
        }

        /* renamed from: l */
        public C0907o m7644l() {
            return new C0907o(C0898f.this, m7628b(), m7628b(), m7628b());
        }

        /* renamed from: m */
        public C0895c m7645m() {
            return new C0895c(C0898f.this, m7621a(), m7628b(), m7628b(), m7628b(), m7628b(), m7628b(), m7628b(), m7628b(), m7628b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public C0896d m7618t() {
            int m7632d = m7632d();
            int m7632d2 = m7632d();
            int m7632d3 = m7632d();
            int m7632d4 = m7632d();
            int m7628b = m7628b();
            short[] m7629b = m7629b(m7628b());
            C0896d.b[] bVarArr = new C0896d.b[m7632d4];
            C0896d.a[] aVarArr = new C0896d.a[0];
            if (m7632d4 > 0) {
                if (m7629b.length % 2 == 1) {
                    m7630c();
                }
                for (int i = 0; i < m7632d4; i++) {
                    bVarArr[i] = new C0896d.b(m7628b(), m7632d(), m7632d());
                }
                int m7636f = m7636f();
                aVarArr = new C0896d.a[m7636f];
                for (int i2 = 0; i2 < m7636f; i2++) {
                    aVarArr[i2] = m7619u();
                }
            }
            return new C0896d(m7632d, m7632d2, m7632d3, m7628b, m7629b, bVarArr, aVarArr);
        }

        /* renamed from: u */
        private C0896d.a m7619u() {
            int m7638g = m7638g();
            int abs = Math.abs(m7638g);
            int[] iArr = new int[abs];
            int[] iArr2 = new int[abs];
            for (int i = 0; i < abs; i++) {
                iArr[i] = m7636f();
                iArr2[i] = m7636f();
            }
            return new C0896d.a(iArr, iArr2, m7638g <= 0 ? m7636f() : -1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: v */
        public C0894b m7620v() {
            return new C0894b(m7615h(m7636f()), m7615h(m7636f()), m7616i(m7636f()), m7616i(m7636f()));
        }

        /* renamed from: h */
        private C0894b.a[] m7615h(int i) {
            C0894b.a[] aVarArr = new C0894b.a[i];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int m7636f = m7636f() + i3;
                aVarArr[i2] = new C0894b.a(m7636f, m7636f());
                i2++;
                i3 = m7636f;
            }
            return aVarArr;
        }

        /* renamed from: i */
        private C0894b.b[] m7616i(int i) {
            C0894b.b[] bVarArr = new C0894b.b[i];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int m7636f = m7636f() + i3;
                bVarArr[i2] = new C0894b.b(m7636f, m7636f(), m7636f());
                i2++;
                i3 = m7636f;
            }
            return bVarArr;
        }

        /* renamed from: n */
        public C0874a m7646n() {
            byte mo7634e = mo7634e();
            int m7636f = m7636f();
            int m7636f2 = m7636f();
            int[] iArr = new int[m7636f2];
            C0900h[] c0900hArr = new C0900h[m7636f2];
            for (int i = 0; i < m7636f2; i++) {
                iArr[i] = m7636f();
                c0900hArr[i] = m7647o();
            }
            return new C0874a(C0898f.this, mo7634e, m7636f, iArr, c0900hArr);
        }

        /* renamed from: o */
        public C0900h m7647o() {
            int i = this.f5466c;
            new C0901i(this).m7666c();
            return new C0900h(Arrays.copyOfRange(C0898f.this.f5445a, i, this.f5466c));
        }

        /* renamed from: p */
        public C0900h m7648p() {
            int i = this.f5466c;
            new C0901i(this).m7659a();
            return new C0900h(Arrays.copyOfRange(C0898f.this.f5445a, i, this.f5466c));
        }

        /* renamed from: j */
        private void m7617j(int i) {
            if (this.f5466c + i > this.f5467d) {
                throw new C1018i("Section limit " + this.f5467d + " exceeded by " + this.f5465b);
            }
        }

        /* renamed from: q */
        public void m7649q() {
            this.f5466c = C0898f.m7590d(this.f5466c);
            for (int i = this.f5466c; i < this.f5466c; i++) {
                C0898f.this.f5445a[i] = 0;
            }
        }

        /* renamed from: r */
        public void m7650r() {
            if ((this.f5466c & 3) != 0) {
                throw new IllegalStateException("Not four byte aligned!");
            }
        }

        /* renamed from: a */
        public void m7625a(byte[] bArr) {
            m7617j(bArr.length);
            System.arraycopy(bArr, 0, C0898f.this.f5445a, this.f5466c, bArr.length);
            this.f5466c += bArr.length;
        }

        @Override // com.p065b.p086b.p110h.InterfaceC1017h
        /* renamed from: c */
        public void mo7631c(int i) {
            m7617j(1);
            byte[] bArr = C0898f.this.f5445a;
            int i2 = this.f5466c;
            this.f5466c = i2 + 1;
            bArr[i2] = (byte) i;
        }

        /* renamed from: a */
        public void m7624a(short s) {
            m7617j(2);
            C0898f.this.f5445a[this.f5466c] = (byte) s;
            C0898f.this.f5445a[this.f5466c + 1] = (byte) (s >>> 8);
            this.f5466c += 2;
        }

        /* renamed from: d */
        public void m7633d(int i) {
            short s = (short) i;
            if (i != (65535 & s)) {
                throw new IllegalArgumentException("Expected an unsigned short: " + i);
            }
            m7624a(s);
        }

        /* renamed from: a */
        public void m7626a(short[] sArr) {
            for (short s : sArr) {
                m7624a(s);
            }
        }

        /* renamed from: e */
        public void m7635e(int i) {
            m7617j(4);
            C0898f.this.f5445a[this.f5466c] = (byte) i;
            C0898f.this.f5445a[this.f5466c + 1] = (byte) (i >>> 8);
            C0898f.this.f5445a[this.f5466c + 2] = (byte) (i >>> 16);
            C0898f.this.f5445a[this.f5466c + 3] = (byte) (i >>> 24);
            this.f5466c += 4;
        }

        /* renamed from: f */
        public void m7637f(int i) {
            try {
                C1029t.m8590a(this, i);
                m7617j(0);
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new C1018i("Section limit " + this.f5467d + " exceeded by " + this.f5465b);
            }
        }

        /* renamed from: g */
        public void m7639g(int i) {
            try {
                C1029t.m8592b(this, i);
                m7617j(0);
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new C1018i("Section limit " + this.f5467d + " exceeded by " + this.f5465b);
            }
        }

        /* renamed from: a */
        public void m7623a(String str) {
            try {
                m7637f(str.length());
                m7625a(C1033x.m8600a(str));
                mo7631c(0);
            } catch (UTFDataFormatException e2) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public void m7622a(C0913f c0913f) {
            short[] m7815a = c0913f.m7815a();
            m7635e(m7815a.length);
            for (short s : m7815a) {
                m7624a(s);
            }
            m7649q();
        }

        /* renamed from: s */
        public int m7651s() {
            return this.f5467d - this.f5466c;
        }
    }
}
