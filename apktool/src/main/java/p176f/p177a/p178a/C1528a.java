package p176f.p177a.p178a;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;
import p176f.p177a.p178a.p179a.C1529a;
import p176f.p177a.p178a.p179a.C1530b;

/* compiled from: Elf.java */
/* renamed from: f.a.a.a */
/* loaded from: classes.dex */
public class C1528a implements Closeable {

    /* renamed from: a */
    static final char[] f9748a = {(char) 127, 'E', 'L', 'F', 0};

    /* renamed from: b */
    public List<m> f9749b;

    /* renamed from: c */
    public List<m> f9750c;

    /* renamed from: d */
    final byte[] f9751d;

    /* renamed from: e */
    j[] f9752e;

    /* renamed from: f */
    l[] f9753f;

    /* renamed from: g */
    byte[] f9754g;

    /* renamed from: h */
    private C1529a f9755h;

    /* renamed from: i */
    private final a f9756i;

    /* renamed from: j */
    private final k[] f9757j;

    /* renamed from: k */
    private byte[] f9758k;

    /* renamed from: l */
    private byte[] f9759l;

    /* renamed from: m */
    private int f9760m;

    /* renamed from: n */
    private int f9761n;

    /* renamed from: o */
    private int[] f9762o;

    /* renamed from: p */
    private int[] f9763p;

    /* renamed from: q */
    private boolean f9764q;

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$a */
    public static abstract class a {

        /* renamed from: a */
        short f9765a;

        /* renamed from: b */
        short f9766b;

        /* renamed from: c */
        int f9767c;

        /* renamed from: d */
        int f9768d;

        /* renamed from: e */
        short f9769e;

        /* renamed from: f */
        short f9770f;

        /* renamed from: g */
        short f9771g;

        /* renamed from: h */
        short f9772h;

        /* renamed from: i */
        short f9773i;

        /* renamed from: j */
        short f9774j;

        /* renamed from: a */
        abstract long mo11731a();

        /* renamed from: b */
        abstract long mo11732b();
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$c */
    static class c extends j {

        /* renamed from: a */
        int f9784a;

        /* renamed from: b */
        int f9785b;

        /* renamed from: c */
        int f9786c;

        /* renamed from: d */
        int f9787d;

        /* renamed from: e */
        int f9788e;

        /* renamed from: f */
        int f9789f;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$e */
    static class e extends l {

        /* renamed from: a */
        int f9796a;

        /* renamed from: b */
        int f9797b;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$g */
    static class g extends j {

        /* renamed from: a */
        long f9801a;

        /* renamed from: b */
        long f9802b;

        /* renamed from: c */
        long f9803c;

        /* renamed from: d */
        long f9804d;

        /* renamed from: e */
        long f9805e;

        /* renamed from: f */
        long f9806f;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$i */
    static class i extends l {

        /* renamed from: a */
        long f9813a;

        /* renamed from: b */
        long f9814b;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$j */
    static abstract class j {

        /* renamed from: g */
        int f9815g;

        /* renamed from: h */
        int f9816h;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$k */
    public static abstract class k {

        /* renamed from: g */
        int f9817g;

        /* renamed from: h */
        int f9818h;

        /* renamed from: i */
        int f9819i;

        /* renamed from: j */
        int f9820j;

        /* renamed from: k */
        int f9821k;

        /* renamed from: a */
        public abstract long mo11750a();

        /* renamed from: b */
        public abstract int mo11751b();
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$l */
    static abstract class l {

        /* renamed from: c */
        int f9822c;

        /* renamed from: d */
        char f9823d;

        /* renamed from: e */
        char f9824e;

        /* renamed from: f */
        short f9825f;
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$b */
    static class b extends a {

        /* renamed from: k */
        int f9780k;

        /* renamed from: l */
        int f9781l;

        /* renamed from: m */
        int f9782m;

        @Override // p176f.p177a.p178a.C1528a.a
        /* renamed from: a */
        long mo11731a() {
            return this.f9781l;
        }

        @Override // p176f.p177a.p178a.C1528a.a
        /* renamed from: b */
        long mo11732b() {
            return this.f9782m;
        }
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$d */
    static class d extends k {

        /* renamed from: a */
        int f9790a;

        /* renamed from: b */
        int f9791b;

        /* renamed from: c */
        int f9792c;

        /* renamed from: d */
        int f9793d;

        /* renamed from: e */
        int f9794e;

        /* renamed from: f */
        int f9795f;

        @Override // p176f.p177a.p178a.C1528a.k
        /* renamed from: a */
        public long mo11750a() {
            return this.f9792c;
        }

        @Override // p176f.p177a.p178a.C1528a.k
        /* renamed from: b */
        public int mo11751b() {
            return this.f9793d;
        }
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$f */
    static class f extends a {

        /* renamed from: k */
        long f9798k;

        /* renamed from: l */
        long f9799l;

        /* renamed from: m */
        long f9800m;

        @Override // p176f.p177a.p178a.C1528a.a
        /* renamed from: a */
        long mo11731a() {
            return this.f9799l;
        }

        @Override // p176f.p177a.p178a.C1528a.a
        /* renamed from: b */
        long mo11732b() {
            return this.f9800m;
        }
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$h */
    static class h extends k {

        /* renamed from: a */
        long f9807a;

        /* renamed from: b */
        long f9808b;

        /* renamed from: c */
        long f9809c;

        /* renamed from: d */
        long f9810d;

        /* renamed from: e */
        long f9811e;

        /* renamed from: f */
        long f9812f;

        @Override // p176f.p177a.p178a.C1528a.k
        /* renamed from: a */
        public long mo11750a() {
            return this.f9809c;
        }

        @Override // p176f.p177a.p178a.C1528a.k
        /* renamed from: b */
        public int mo11751b() {
            return (int) this.f9810d;
        }
    }

    /* compiled from: Elf.java */
    /* renamed from: f.a.a.a$m */
    public static class m {

        /* renamed from: a */
        public String f9826a;

        /* renamed from: b */
        public String f9827b;

        /* renamed from: c */
        public byte[] f9828c;

        /* renamed from: d */
        public int f9829d = -1;

        public m() {
        }

        public m(String str) {
            this.f9826a = str;
        }

        public boolean equals(Object obj) {
            return this.f9826a.equals(((m) obj).f9826a);
        }

        public int hashCode() {
            return this.f9826a.hashCode();
        }
    }

    public C1528a(ByteArrayInputStream byteArrayInputStream) {
        this.f9751d = new byte[16];
        this.f9749b = new ArrayList();
        C1529a c1529a = new C1529a(byteArrayInputStream);
        this.f9755h = c1529a;
        c1529a.m11736a(this.f9751d);
        if (!m11722a()) {
            throw new UnknownFormatConversionException("Invalid elf magic");
        }
        c1529a.m11735a(m11729e());
        boolean m11728d = m11728d();
        if (m11728d) {
            f fVar = new f();
            fVar.f9765a = c1529a.m11742e();
            fVar.f9766b = c1529a.m11742e();
            fVar.f9767c = c1529a.m11740c();
            fVar.f9798k = c1529a.m11741d();
            fVar.f9799l = c1529a.m11741d();
            fVar.f9800m = c1529a.m11741d();
            this.f9756i = fVar;
        } else {
            b bVar = new b();
            bVar.f9765a = c1529a.m11742e();
            bVar.f9766b = c1529a.m11742e();
            bVar.f9767c = c1529a.m11740c();
            bVar.f9780k = c1529a.m11740c();
            bVar.f9781l = c1529a.m11740c();
            bVar.f9782m = c1529a.m11740c();
            this.f9756i = bVar;
        }
        a aVar = this.f9756i;
        aVar.f9768d = c1529a.m11740c();
        aVar.f9769e = c1529a.m11742e();
        aVar.f9770f = c1529a.m11742e();
        aVar.f9771g = c1529a.m11742e();
        aVar.f9772h = c1529a.m11742e();
        aVar.f9773i = c1529a.m11742e();
        aVar.f9774j = c1529a.m11742e();
        this.f9757j = new k[aVar.f9773i];
        for (int i2 = 0; i2 < aVar.f9773i; i2++) {
            c1529a.m11734a(aVar.mo11732b() + (aVar.f9772h * i2));
            if (m11728d) {
                h hVar = new h();
                hVar.f9817g = c1529a.m11740c();
                hVar.f9818h = c1529a.m11740c();
                hVar.f9807a = c1529a.m11741d();
                hVar.f9808b = c1529a.m11741d();
                hVar.f9809c = c1529a.m11741d();
                hVar.f9810d = c1529a.m11741d();
                hVar.f9819i = c1529a.m11740c();
                hVar.f9820j = c1529a.m11740c();
                hVar.f9811e = c1529a.m11741d();
                hVar.f9812f = c1529a.m11741d();
                hVar.f9821k = i2;
                this.f9757j[i2] = hVar;
            } else {
                d dVar = new d();
                dVar.f9817g = c1529a.m11740c();
                dVar.f9818h = c1529a.m11740c();
                dVar.f9790a = c1529a.m11740c();
                dVar.f9791b = c1529a.m11740c();
                dVar.f9792c = c1529a.m11740c();
                dVar.f9793d = c1529a.m11740c();
                dVar.f9819i = c1529a.m11740c();
                dVar.f9820j = c1529a.m11740c();
                dVar.f9794e = c1529a.m11740c();
                dVar.f9795f = c1529a.m11740c();
                dVar.f9821k = i2;
                this.f9757j[i2] = dVar;
            }
        }
        if (aVar.f9774j > -1 && aVar.f9774j < this.f9757j.length) {
            k kVar = this.f9757j[aVar.f9774j];
            if (kVar.f9818h == 3) {
                this.f9758k = new byte[kVar.mo11751b()];
                c1529a.m11734a(kVar.mo11750a());
                c1529a.m11736a(this.f9758k);
                for (k kVar2 : this.f9757j) {
                    System.out.println(m11725b(kVar2.f9817g));
                }
                try {
                    if (!m11716a(this.f9749b)) {
                        this.f9764q = true;
                        return;
                    }
                    return;
                } catch (Error e2) {
                    this.f9764q = true;
                    return;
                }
            }
            throw new UnknownFormatConversionException(new StringBuffer().append("Wrong string section e_shstrndx=").append((int) aVar.f9774j).toString());
        }
        throw new UnknownFormatConversionException(new StringBuffer().append("Invalid e_shstrndx=").append((int) aVar.f9774j).toString());
    }

    public C1528a(ByteArrayInputStream byteArrayInputStream, InterfaceC1531b interfaceC1531b) {
        this(byteArrayInputStream);
        for (m mVar : this.f9749b) {
            C1532c c1532c = new C1532c();
            c1532c.f9832c = mVar.f9826a;
            c1532c.f9831b = "dynstr";
            interfaceC1531b.mo11752a(c1532c);
        }
        if (this.f9759l != null) {
            for (m mVar2 : this.f9750c) {
                C1532c c1532c2 = new C1532c();
                c1532c2.f9832c = mVar2.f9826a;
                c1532c2.f9831b = "rodata";
                interfaceC1531b.mo11752a(c1532c2);
            }
        }
    }

    /* renamed from: a */
    final boolean m11722a() {
        return this.f9751d[0] == f9748a[0];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9755h.m11733a();
    }

    /* renamed from: a */
    private String m11713a(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.length() < i2) {
            int length = i2 - str.length();
            while (true) {
                int i3 = length - 1;
                if (length <= 0) {
                    break;
                }
                sb.append(" ");
                length = i3;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public int m11718a(String str) {
        if (this.f9760m == 0) {
            return -1;
        }
        int i2 = this.f9762o[(int) (m11727c(str) % this.f9760m)];
        while (i2 != 0) {
            String m11719a = m11719a(this.f9753f[i2].f9822c);
            System.out.println(m11719a);
            if (m11719a.equals(str)) {
                return i2;
            }
            i2 = this.f9763p[i2];
        }
        return -1;
    }

    /* renamed from: b */
    final byte m11723b() {
        return this.f9751d[5];
    }

    /* renamed from: a */
    public final String m11719a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (this.f9754g[i3] != 0) {
            i3++;
        }
        return new String(this.f9754g, i2, i3 - i2);
    }

    /* renamed from: c */
    final byte m11726c() {
        return this.f9751d[4];
    }

    /* renamed from: b */
    public final k m11724b(String str) {
        for (k kVar : this.f9757j) {
            if (str.equals(m11725b(kVar.f9817g))) {
                return kVar;
            }
        }
        return (k) null;
    }

    /* renamed from: b */
    public final String m11725b(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (this.f9758k[i3] != 0) {
            i3++;
        }
        return new String(this.f9758k, i2, i3 - i2);
    }

    /* renamed from: d */
    public final boolean m11728d() {
        return m11726c() == 2;
    }

    /* renamed from: e */
    public final boolean m11729e() {
        return m11723b() == 1;
    }

    /* renamed from: a */
    private boolean m11716a(List<m> list) {
        int i2;
        a aVar = this.f9756i;
        C1529a c1529a = this.f9755h;
        boolean m11728d = m11728d();
        k m11724b = m11724b(".hash");
        if (m11724b != null) {
            c1529a.m11734a(m11724b.mo11750a());
            this.f9760m = c1529a.m11740c();
            this.f9761n = c1529a.m11740c();
            this.f9762o = c1529a.m11738a(this.f9760m);
            this.f9763p = c1529a.m11738a(this.f9761n);
            int i3 = (this.f9760m * 4) + (this.f9761n * 4) + 8;
            if (m11724b.mo11751b() != i3) {
                throw new IOException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Error reading string table (read ").append(i3).toString()).append("bytes, expected to ").toString()).append("read ").toString()).append(m11724b.mo11751b()).toString()).append("bytes).").toString());
            }
        }
        k m11724b2 = m11724b(".dynsym");
        if (m11724b2 != null) {
            c1529a.m11734a(m11724b2.mo11750a());
            int mo11751b = m11724b2.mo11751b() / (m11728d ? 24 : 16);
            this.f9753f = new l[mo11751b];
            for (int i4 = 0; i4 < mo11751b; i4++) {
                if (m11728d) {
                    i iVar = new i();
                    iVar.f9822c = c1529a.m11740c();
                    iVar.f9823d = (char) c1529a.m11739b();
                    iVar.f9824e = (char) c1529a.m11739b();
                    iVar.f9813a = c1529a.m11741d();
                    iVar.f9814b = c1529a.m11741d();
                    iVar.f9825f = c1529a.m11742e();
                    this.f9753f[i4] = iVar;
                } else {
                    e eVar = new e();
                    eVar.f9822c = c1529a.m11740c();
                    eVar.f9796a = c1529a.m11740c();
                    eVar.f9797b = c1529a.m11740c();
                    eVar.f9823d = (char) c1529a.m11739b();
                    eVar.f9824e = (char) c1529a.m11739b();
                    eVar.f9825f = c1529a.m11742e();
                    this.f9753f[i4] = eVar;
                }
            }
            k kVar = this.f9757j[m11724b2.f9819i];
            c1529a.m11734a(kVar.mo11750a());
            this.f9754g = new byte[kVar.mo11751b()];
            c1529a.m11736a(this.f9754g);
            for (String str : new String(this.f9754g).split("\u0000")) {
                if (str.length() != 0) {
                    m mVar = new m();
                    mVar.f9826a = str;
                    list.add(mVar);
                    mVar.f9829d = m11718a(str);
                }
            }
        }
        this.f9752e = new j[aVar.f9771g];
        for (int i5 = 0; i5 < aVar.f9771g; i5++) {
            c1529a.m11734a(aVar.mo11731a() + (aVar.f9770f * i5));
            if (m11728d) {
                g gVar = new g();
                gVar.f9815g = c1529a.m11740c();
                gVar.f9816h = c1529a.m11740c();
                gVar.f9801a = c1529a.m11741d();
                gVar.f9802b = c1529a.m11741d();
                gVar.f9803c = c1529a.m11741d();
                gVar.f9804d = c1529a.m11741d();
                gVar.f9805e = c1529a.m11741d();
                gVar.f9806f = c1529a.m11741d();
                this.f9752e[i5] = gVar;
            } else {
                c cVar = new c();
                cVar.f9815g = c1529a.m11740c();
                cVar.f9816h = c1529a.m11740c();
                cVar.f9784a = c1529a.m11740c();
                cVar.f9785b = c1529a.m11740c();
                cVar.f9786c = c1529a.m11740c();
                cVar.f9787d = c1529a.m11740c();
                cVar.f9788e = c1529a.m11740c();
                cVar.f9789f = c1529a.m11740c();
                this.f9752e[i5] = cVar;
            }
        }
        k m11724b3 = m11724b(".rodata");
        if (m11724b3 != null) {
            c1529a.m11734a(m11724b3.mo11750a());
            this.f9759l = new byte[m11724b3.mo11751b()];
            c1529a.m11736a(this.f9759l);
            this.f9750c = new ArrayList();
            int i6 = 0;
            while (i6 != this.f9759l.length) {
                while (true) {
                    if (i6 == this.f9759l.length) {
                        i2 = i6;
                        break;
                    }
                    i2 = i6 + 1;
                    if (this.f9759l[i6] != 0) {
                        break;
                    }
                    i6 = i2;
                }
                i6 = i2;
                while (true) {
                    if (i6 != this.f9759l.length) {
                        int i7 = i6 + 1;
                        if (this.f9759l[i6] == 0) {
                            i6 = i7;
                            break;
                        }
                        i6 = i7;
                    }
                }
                m mVar2 = new m();
                mVar2.f9826a = new String(this.f9759l, i2 - 1, i6 - i2);
                mVar2.f9828c = new byte[i6 - i2];
                System.arraycopy(this.f9759l, i2 - 1, mVar2.f9828c, 0, mVar2.f9828c.length);
                this.f9750c.add(mVar2);
            }
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public long m11727c(String str) {
        long j2 = 0;
        long j3 = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            j2 = (j2 << 4) + str.charAt(i2);
            long j4 = 4026531840L & j2;
            if (j4 != 0) {
                j2 = (j2 ^ (j4 >> 24)) & (j4 ^ (-1));
            }
        }
        return Integer.MAX_VALUE & j2;
    }

    /* renamed from: a */
    private final void m11715a(List<m> list, C1530b c1530b) {
        c1530b.m11746a(this.f9760m);
        c1530b.m11746a(this.f9761n);
        int[] iArr = new int[this.f9760m];
        int[] iArr2 = new int[this.f9761n];
        for (m mVar : list) {
            if (mVar.f9829d != -1) {
                int m11727c = (int) (m11727c(mVar.f9827b == null ? mVar.f9826a : mVar.f9827b) % this.f9760m);
                if (iArr[m11727c] == 0) {
                    iArr[m11727c] = mVar.f9829d;
                } else {
                    int i2 = iArr[m11727c];
                    while (true) {
                        if (i2 == 0) {
                            break;
                        }
                        if (iArr2[i2] != 0) {
                            i2 = iArr2[i2];
                        } else {
                            iArr2[i2] = mVar.f9829d;
                            break;
                        }
                    }
                }
            }
        }
        c1530b.m11749a(iArr);
        c1530b.m11749a(iArr2);
    }

    /* renamed from: b */
    private final long m11717b(List<m> list, C1530b c1530b) {
        byte[] bArr;
        long j2 = 0;
        long j3 = 0;
        for (m mVar : list) {
            String str = mVar.f9826a;
            if (!str.equals("SHN_UNDEF")) {
                c1530b.m11745a((byte) 0);
                byte[] bytes = str.getBytes();
                long length = j2 + bytes.length;
                if (mVar.f9827b != null) {
                    mVar.f9827b = m11713a(mVar.f9827b, mVar.f9826a.length());
                    bArr = mVar.f9827b.getBytes();
                } else {
                    bArr = bytes;
                }
                c1530b.m11747a(bArr);
                j2 = length + 1;
                j3 = 1 + j3 + bArr.length;
            }
        }
        if (this.f9754g.length - ((int) j2) > 0) {
            c1530b.m11748a(this.f9754g, (int) j2, this.f9754g.length - ((int) j2));
            return j3 + (this.f9754g.length - ((int) j2));
        }
        return j3;
    }

    /* renamed from: a */
    public final void m11720a(OutputStream outputStream) {
        long j2;
        C1530b c1530b = new C1530b(outputStream);
        long mo11750a = this.f9757j[m11724b(".dynsym").f9819i].mo11750a();
        k m11724b = m11724b(".hash");
        if (m11724b == null) {
            m11714a(0, mo11750a, c1530b);
            m11717b(this.f9749b, c1530b);
            j2 = mo11750a + this.f9754g.length;
        } else {
            long mo11750a2 = m11724b.mo11750a();
            if (mo11750a > mo11750a2) {
                m11714a(0, mo11750a2, c1530b);
                m11715a(this.f9749b, c1530b);
                m11714a(mo11750a2 + (this.f9760m * 4) + (this.f9761n * 4) + 8, mo11750a, c1530b);
                m11717b(this.f9749b, c1530b);
                j2 = mo11750a + this.f9754g.length;
            } else {
                m11714a(0, mo11750a, c1530b);
                m11717b(this.f9749b, c1530b);
                m11714a(mo11750a + this.f9754g.length, mo11750a2, c1530b);
                m11715a(this.f9749b, c1530b);
                j2 = mo11750a2 + (this.f9760m * 4) + (this.f9761n * 4) + 8;
            }
        }
        k m11724b2 = m11724b(".rodata");
        if (m11724b2 != null) {
            m11714a(j2, m11724b2.mo11750a(), c1530b);
            long mo11750a3 = m11724b2.mo11750a();
            m11730f();
            c1530b.m11747a(this.f9759l);
            j2 = this.f9759l.length + mo11750a3;
        }
        m11714a(j2, this.f9755h.f9776b, c1530b);
        c1530b.m11744a();
        close();
    }

    /* renamed from: a */
    private void m11714a(long j2, long j3, C1530b c1530b) {
        long j4 = j3 - j2;
        if (j4 > 0) {
            this.f9755h.m11734a(j2);
            byte[] bArr = new byte[2048];
            while (j4 != 0) {
                if (2048 <= j4) {
                    this.f9755h.m11736a(bArr);
                    c1530b.m11747a(bArr);
                    j4 -= 2048;
                } else {
                    this.f9755h.m11737a(bArr, 0, (int) j4);
                    c1530b.m11748a(bArr, 0, (int) j4);
                    j4 = 0;
                }
            }
        }
    }

    @SuppressLint("DefaultLocale")
    /* renamed from: a */
    public void m11721a(List<String> list, List<String> list2, List<m> list3) {
        int i2 = 0;
        for (String str : list2) {
            if (!str.equals("")) {
                int indexOf = list3.indexOf(new m(list.get(i2)));
                if (indexOf != -1) {
                    list3.get(indexOf).f9827b = str;
                }
            }
            i2++;
        }
    }

    /* renamed from: f */
    public void m11730f() {
        byte[] bArr;
        int m11712a;
        for (m mVar : this.f9750c) {
            if (mVar.f9827b != null && !mVar.f9827b.equals("") && (m11712a = m11712a(this.f9759l, (bArr = mVar.f9828c))) != -1) {
                byte[] bytes = mVar.f9827b.getBytes();
                int i2 = 0;
                while (i2 < bytes.length) {
                    this.f9759l[m11712a] = bytes[i2];
                    i2++;
                    m11712a++;
                }
                int length = bArr.length - bytes.length;
                int i3 = m11712a;
                while (true) {
                    int i4 = length - 1;
                    if (length > 0) {
                        this.f9759l[i3] = (byte) 20;
                        length = i4;
                        i3++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static int m11712a(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            boolean z = true;
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                z = z && bArr[i2 + i3] == bArr2[i3];
            }
            if (z) {
                return i2;
            }
        }
        return -1;
    }
}
