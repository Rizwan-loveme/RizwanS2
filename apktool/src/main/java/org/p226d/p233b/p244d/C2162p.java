package org.p226d.p233b.p244d;

import android.widget.ExpandableListView;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1154ag;
import com.p129f.p130a.p135e.C1213a;
import java.nio.charset.Charset;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectStreamConstants;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p250e.InterfaceC2270k;
import org.p226d.p269d.AbstractC2447a;

/* compiled from: OatFile.java */
/* renamed from: org.d.b.d.p */
/* loaded from: classes.dex */
public class C2162p extends C2077a implements InterfaceC2270k<e> {

    /* renamed from: c */
    private static final byte[] f12067c = {Byte.MAX_VALUE, 69, 76, 70};

    /* renamed from: d */
    private static final byte[] f12068d = {111, 97, ObjectStreamConstants.TC_STRING, 10};

    /* renamed from: e */
    private final boolean f12069e;

    /* renamed from: f */
    private final f f12070f;

    /* renamed from: g */
    private final C2359g f12071g;

    /* renamed from: h */
    private final l f12072h;

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$d */
    public static class d extends RuntimeException {
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$l */
    public interface l {
        /* renamed from: a */
        byte[] mo14506a();
    }

    public C2162p(byte[] bArr, l lVar) {
        super(bArr);
        f fVar;
        if (bArr.length < 52) {
            throw new d();
        }
        m14810a(bArr);
        if (bArr[4] == 1) {
            this.f12069e = false;
        } else if (bArr[4] == 2) {
            this.f12069e = true;
        } else {
            throw new c(String.format("Invalid word-size value: %x", Byte.valueOf(bArr[5])));
        }
        Iterator<k.a> it = m14817h().m14847a().iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            k.a next = it.next();
            if (next.mo14849a().equals("oatdata")) {
                fVar = new f(next.m14852d());
                break;
            }
        }
        if (fVar == null) {
            throw new c("Oat file has no oatdata symbol");
        }
        this.f12070f = fVar;
        if (!fVar.m14830a()) {
            throw new c("Invalid oat magic value");
        }
        this.f12071g = C2359g.m15024b(fVar.m14831b());
        this.f12072h = lVar;
    }

    /* renamed from: a */
    private static void m14810a(byte[] bArr) {
        for (int i2 = 0; i2 < f12067c.length; i2++) {
            if (bArr[i2] != f12067c[i2]) {
                throw new d();
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: a */
    public static C2162p m14809a(InputStream inputStream, l lVar) {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(4);
        byte[] bArr = new byte[4];
        try {
            try {
                C1213a.m10158a(inputStream, bArr);
                inputStream.reset();
                m14810a(bArr);
                inputStream.reset();
                return new C2162p(C1213a.m10161a(inputStream), lVar);
            } catch (EOFException e2) {
                throw new d();
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    /* renamed from: b */
    public int m14819b() {
        return this.f12070f.m14831b();
    }

    /* renamed from: c */
    public int m14820c() {
        int m14819b = m14819b();
        if (m14819b < 56) {
            return 0;
        }
        if (m14819b <= 86) {
            return 1;
        }
        return 2;
    }

    /* renamed from: d */
    public List<String> m14821d() {
        if (m14819b() < 75) {
            return AbstractC1208w.m10138g();
        }
        String m14829a = this.f12070f.m14829a("bootclasspath");
        if (m14829a == null) {
            return AbstractC1208w.m10138g();
        }
        return Arrays.asList(m14829a.split(":"));
    }

    /* renamed from: e */
    public List<e> m14822e() {
        return new AbstractC2447a<e>() { // from class: org.d.b.d.p.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2162p.this.f12070f.m14832c();
            }

            @Override // org.p226d.p269d.AbstractC2447a, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<e> iterator() {
                return C1154ag.m9889a((Iterator) new b(), (InterfaceC1112g) new InterfaceC1112g<a, e>() { // from class: org.d.b.d.p.1.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public e mo9517a(a aVar) {
                        return aVar.m14824a();
                    }
                });
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2270k
    /* renamed from: a */
    public List<String> mo14511a() {
        return new AbstractC2447a<String>() { // from class: org.d.b.d.p.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2162p.this.f12070f.m14832c();
            }

            @Override // org.p226d.p269d.AbstractC2447a, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<String> iterator() {
                return C1154ag.m9889a((Iterator) new b(), (InterfaceC1112g) new InterfaceC1112g<a, String>() { // from class: org.d.b.d.p.2.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public String mo9517a(a aVar) {
                        return aVar.f12081a;
                    }
                });
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2270k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e mo14513b(String str) {
        b bVar = new b();
        while (bVar.hasNext()) {
            a next = bVar.next();
            if (next.f12081a.equals(str)) {
                return next.m14824a();
            }
        }
        return null;
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$e */
    public class e extends C2153g implements InterfaceC2270k.a {

        /* renamed from: c */
        public final String f12088c;

        public e(byte[] bArr, int i, String str) {
            super(C2162p.this.f12071g, bArr, i);
            this.f12088c = str;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2270k.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C2162p mo14827f() {
            return C2162p.this;
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$f */
    private class f {

        /* renamed from: b */
        private final int f12091b;

        /* renamed from: c */
        private final int f12092c;

        public f(int i) {
            this.f12091b = i;
            if (m14831b() >= 127) {
                this.f12092c = 76;
            } else {
                this.f12092c = 72;
            }
        }

        /* renamed from: a */
        public boolean m14830a() {
            for (int i = 0; i < C2162p.f12068d.length; i++) {
                if (C2162p.this.f11801a[this.f12091b + i] != C2162p.f12068d[i]) {
                    return false;
                }
            }
            for (int i2 = 4; i2 < 7; i2++) {
                if (C2162p.this.f11801a[this.f12091b + i2] < 48 || C2162p.this.f11801a[this.f12091b + i2] > 57) {
                    return false;
                }
            }
            return C2162p.this.f11801a[this.f12091b + 7] == 0;
        }

        /* renamed from: b */
        public int m14831b() {
            return Integer.valueOf(new String(C2162p.this.f11801a, this.f12091b + 4, 3)).intValue();
        }

        /* renamed from: c */
        public int m14832c() {
            return C2162p.this.m14615a(this.f12091b + 20);
        }

        /* renamed from: d */
        public int m14833d() {
            if (m14831b() < 56) {
                throw new IllegalStateException("Unsupported oat version");
            }
            return C2162p.this.m14615a((this.f12092c - 4) + this.f12091b);
        }

        /* renamed from: e */
        public int m14834e() {
            if (m14831b() < 56) {
                throw new IllegalStateException("Unsupported oat version");
            }
            return this.f12092c + m14833d();
        }

        /* renamed from: a */
        public String m14829a(String str) {
            int m14833d = m14833d();
            int i = this.f12091b + this.f12092c;
            int i2 = i + m14833d;
            while (i < i2) {
                int i3 = i;
                while (i3 < i2 && C2162p.this.f11801a[i3] != 0) {
                    i3++;
                }
                if (i3 >= i2) {
                    throw new c("Oat file contains truncated key value store");
                }
                if (new String(C2162p.this.f11801a, i, i3 - i).equals(str)) {
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (i5 < i2 && C2162p.this.f11801a[i5] != 0) {
                        i5++;
                    }
                    if (i5 >= i2) {
                        throw new c("Oat file contains truncated key value store");
                    }
                    return new String(C2162p.this.f11801a, i4, i5 - i4);
                }
                i = i3 + 1;
            }
            return null;
        }

        /* renamed from: f */
        public int m14835f() {
            return m14831b() >= 127 ? this.f12091b + C2162p.this.m14615a(this.f12091b + 24) : this.f12091b + m14834e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public List<g> m14816g() {
        final int a2;
        final int c2;
        final int c3;
        if (this.f12069e) {
            a2 = m14620f(40);
            c2 = m14617c(58);
            c3 = m14617c(60);
        } else {
            a2 = m14615a(32);
            c2 = m14617c(46);
            c3 = m14617c(48);
        }
        if ((c2 * c3) + a2 > this.f11801a.length) {
            throw new c("The ELF section headers extend past the end of the file");
        }
        return new AbstractList<g>() { // from class: org.d.b.d.p.3
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g get(int i2) {
                if (i2 < 0 || i2 >= c3) {
                    throw new IndexOutOfBoundsException();
                }
                return C2162p.this.f12069e ? C2162p.this.new i(a2 + (c2 * i2)) : C2162p.this.new h(a2 + (c2 * i2));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return c3;
            }
        };
    }

    /* renamed from: h */
    private k m14817h() {
        for (g gVar : m14816g()) {
            if (gVar.m14836a() == 11) {
                return new k(gVar);
            }
        }
        throw new c("Oat file has no symbol table");
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$g */
    private abstract class g {

        /* renamed from: a */
        protected final int f12093a;

        /* renamed from: b */
        public abstract long mo14837b();

        /* renamed from: c */
        public abstract int mo14838c();

        /* renamed from: d */
        public abstract int mo14839d();

        /* renamed from: e */
        public abstract int mo14840e();

        /* renamed from: f */
        public abstract int mo14841f();

        public g(int i) {
            this.f12093a = i;
        }

        /* renamed from: a */
        public int m14836a() {
            return C2162p.this.m14621g(this.f12093a + 4);
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$h */
    private class h extends g {
        public h(int i) {
            super(i);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: b */
        public long mo14837b() {
            return C2162p.this.m14621g(this.f12093a + 12) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: c */
        public int mo14838c() {
            return C2162p.this.m14615a(this.f12093a + 16);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: d */
        public int mo14839d() {
            return C2162p.this.m14615a(this.f12093a + 20);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: e */
        public int mo14840e() {
            return C2162p.this.m14615a(this.f12093a + 24);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: f */
        public int mo14841f() {
            return C2162p.this.m14615a(this.f12093a + 36);
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$i */
    private class i extends g {
        public i(int i) {
            super(i);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: b */
        public long mo14837b() {
            return C2162p.this.m14619e(this.f12093a + 16);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: c */
        public int mo14838c() {
            return C2162p.this.m14620f(this.f12093a + 24);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: d */
        public int mo14839d() {
            return C2162p.this.m14620f(this.f12093a + 32);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: e */
        public int mo14840e() {
            return C2162p.this.m14615a(this.f12093a + 40);
        }

        @Override // org.p226d.p233b.p244d.C2162p.g
        /* renamed from: f */
        public int mo14841f() {
            return C2162p.this.m14620f(this.f12093a + 56);
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$k */
    class k {

        /* renamed from: b */
        private final j f12101b;

        /* renamed from: c */
        private final int f12102c;

        /* renamed from: d */
        private final int f12103d;

        /* renamed from: e */
        private final int f12104e;

        public k(g gVar) {
            try {
                this.f12101b = C2162p.this.new j((g) C2162p.this.m14816g().get(gVar.mo14840e()));
                this.f12102c = gVar.mo14838c();
                this.f12104e = gVar.mo14841f();
                this.f12103d = gVar.mo14839d() / this.f12104e;
                if (this.f12102c + (this.f12103d * this.f12104e) > C2162p.this.f11801a.length) {
                    throw new c("Symbol table extends past end of file");
                }
            } catch (IndexOutOfBoundsException e2) {
                throw new c("String table section index is invalid");
            }
        }

        /* renamed from: a */
        public List<a> m14847a() {
            return new AbstractList<a>() { // from class: org.d.b.d.p.k.1
                @Override // java.util.AbstractList, java.util.List
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a get(int i) {
                    if (i >= 0 && i < k.this.f12103d) {
                        if (!C2162p.this.f12069e) {
                            return k.this.new b(k.this.f12102c + (k.this.f12104e * i));
                        }
                        return k.this.new c(k.this.f12102c + (k.this.f12104e * i));
                    }
                    throw new IndexOutOfBoundsException();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return k.this.f12103d;
                }
            };
        }

        /* compiled from: OatFile.java */
        /* renamed from: org.d.b.d.p$k$a */
        public abstract class a {

            /* renamed from: b */
            static final /* synthetic */ boolean f12106b;

            /* renamed from: a */
            protected final int f12107a;

            /* renamed from: a */
            public abstract String mo14849a();

            /* renamed from: b */
            public abstract long mo14850b();

            /* renamed from: c */
            public abstract int mo14851c();

            static {
                f12106b = !C2162p.class.desiredAssertionStatus();
            }

            public a(int i) {
                this.f12107a = i;
            }

            /* renamed from: d */
            public int m14852d() {
                try {
                    g gVar = (g) C2162p.this.m14816g().get(mo14851c());
                    long mo14837b = gVar.mo14837b();
                    int mo14838c = gVar.mo14838c();
                    int mo14839d = gVar.mo14839d();
                    long mo14850b = mo14850b();
                    if (mo14850b < mo14837b || mo14850b >= mo14839d + mo14837b) {
                        throw new c("symbol address lies outside it's associated section");
                    }
                    long mo14850b2 = mo14838c + (mo14850b() - mo14837b);
                    if (f12106b || mo14850b2 <= 2147483647L) {
                        return (int) mo14850b2;
                    }
                    throw new AssertionError();
                } catch (IndexOutOfBoundsException e2) {
                    throw new c("Section index for symbol is out of bounds");
                }
            }
        }

        /* compiled from: OatFile.java */
        /* renamed from: org.d.b.d.p$k$b */
        public class b extends a {
            public b(int i) {
                super(i);
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: a */
            public String mo14849a() {
                return k.this.f12101b.m14842a(C2162p.this.m14615a(this.f12107a));
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: b */
            public long mo14850b() {
                return C2162p.this.m14615a(this.f12107a + 4);
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: c */
            public int mo14851c() {
                return C2162p.this.m14617c(this.f12107a + 14);
            }
        }

        /* compiled from: OatFile.java */
        /* renamed from: org.d.b.d.p$k$c */
        public class c extends a {
            public c(int i) {
                super(i);
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: a */
            public String mo14849a() {
                return k.this.f12101b.m14842a(C2162p.this.m14615a(this.f12107a));
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: b */
            public long mo14850b() {
                return C2162p.this.m14619e(this.f12107a + 8);
            }

            @Override // org.p226d.p233b.p244d.C2162p.k.a
            /* renamed from: c */
            public int mo14851c() {
                return C2162p.this.m14617c(this.f12107a + 6);
            }
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$j */
    private class j {

        /* renamed from: b */
        private final int f12098b;

        /* renamed from: c */
        private final int f12099c;

        public j(g gVar) {
            this.f12098b = gVar.mo14838c();
            this.f12099c = gVar.mo14839d();
            if (this.f12098b + this.f12099c > C2162p.this.f11801a.length) {
                throw new c("String table extends past end of file");
            }
        }

        /* renamed from: a */
        public String m14842a(int i) {
            if (i >= this.f12099c) {
                throw new c("String index is out of bounds");
            }
            int i2 = this.f12098b + i;
            int i3 = i2;
            while (C2162p.this.f11801a[i3] != 0) {
                i3++;
                if (i3 >= this.f12098b + this.f12099c) {
                    throw new c("String extends past end of string table");
                }
            }
            return new String(C2162p.this.f11801a, i2, i3 - i2, Charset.forName("US-ASCII"));
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$a */
    private class a {

        /* renamed from: a */
        public final String f12081a;

        /* renamed from: b */
        public final byte[] f12082b;

        /* renamed from: c */
        public final int f12083c;

        public a(String str, byte[] bArr, int i) {
            this.f12081a = str;
            this.f12082b = bArr;
            this.f12083c = i;
        }

        /* renamed from: a */
        public e m14824a() {
            return C2162p.this.new e(this.f12082b, this.f12083c, this.f12081a);
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$b */
    private class b implements Iterator<a> {

        /* renamed from: a */
        int f12085a;

        /* renamed from: b */
        int f12086b;

        private b() {
            this.f12085a = 0;
            this.f12086b = C2162p.this.f12070f.m14835f();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12085a < C2162p.this.f12070f.m14832c();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a next() {
            byte[] bArr;
            int a2 = C2162p.this.m14615a(this.f12086b);
            this.f12086b += 4;
            String str = new String(C2162p.this.f11801a, this.f12086b, a2, Charset.forName("US-ASCII"));
            this.f12086b = a2 + this.f12086b;
            this.f12086b += 4;
            int a3 = C2162p.this.m14615a(this.f12086b);
            this.f12086b += 4;
            if (C2162p.this.m14819b() >= 87 && C2162p.this.f12072h != null && C2162p.this.f12072h.mo14506a() != null) {
                bArr = C2162p.this.f12072h.mo14506a();
            } else {
                bArr = C2162p.this.f11801a;
                a3 += C2162p.this.f12070f.f12091b;
            }
            if (C2162p.this.m14819b() >= 75) {
                this.f12086b += 4;
            }
            if (C2162p.this.m14819b() >= 73) {
                this.f12086b += 4;
            }
            if (C2162p.this.m14819b() >= 131) {
                this.f12086b += 4;
            }
            if (C2162p.this.m14819b() >= 127) {
                this.f12086b += 4;
            }
            if (C2162p.this.m14819b() < 75) {
                this.f12086b = (C2162p.this.m14615a(a3 + 96) * 4) + this.f12086b;
            }
            this.f12085a++;
            return C2162p.this.new a(str, bArr, a3);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: OatFile.java */
    /* renamed from: org.d.b.d.p$c */
    public static class c extends RuntimeException {
        public c(String str) {
            super(str);
        }
    }
}
