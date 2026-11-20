package org.p210a.p211a.p212a;

import org.p210a.p211a.p212a.C1860h;
import org.p210a.p211a.p212a.p215c.C1839i;

/* compiled from: CodePointCharStream.java */
/* renamed from: org.a.a.a.i */
/* loaded from: classes.dex */
public abstract class AbstractC1861i implements InterfaceC1858f {

    /* renamed from: d */
    static final /* synthetic */ boolean f10938d;

    /* renamed from: e */
    private static /* synthetic */ int[] f10939e;

    /* renamed from: a */
    protected final int f10940a;

    /* renamed from: b */
    protected final String f10941b;

    /* renamed from: c */
    protected int f10942c;

    static {
        f10938d = !AbstractC1861i.class.desiredAssertionStatus();
    }

    /* renamed from: a */
    static /* synthetic */ int[] m13832a() {
        int[] iArr = f10939e;
        if (iArr == null) {
            iArr = new int[C1860h.b.valuesCustom().length];
            try {
                iArr[C1860h.b.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1860h.b.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1860h.b.INT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f10939e = iArr;
        }
        return iArr;
    }

    private AbstractC1861i(int i, int i2, String str) {
        if (!f10938d && i != 0) {
            throw new AssertionError();
        }
        this.f10940a = i2;
        this.f10941b = str;
        this.f10942c = 0;
    }

    /* synthetic */ AbstractC1861i(int i, int i2, String str, AbstractC1861i abstractC1861i) {
        this(i, i2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static AbstractC1861i m13831a(C1860h c1860h, String str) {
        c cVar = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        switch (m13832a()[c1860h.m13814c().ordinal()]) {
            case 1:
                return new c(c1860h.m13812a(), c1860h.m13813b(), str, c1860h.m13816e(), c1860h.m13815d(), cVar);
            case 2:
                return new a(c1860h.m13812a(), c1860h.m13813b(), str, c1860h.m13817f(), c1860h.m13815d(), objArr2 == true ? 1 : 0);
            case 3:
                return new b(c1860h.m13812a(), c1860h.m13813b(), str, c1860h.m13818g(), c1860h.m13815d(), objArr == true ? 1 : 0);
            default:
                throw new UnsupportedOperationException("Not reached");
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public final void mo13715b() {
        if (this.f10940a - this.f10942c == 0) {
            if (!f10938d && mo13711a(1) != -1) {
                throw new AssertionError();
            }
            throw new IllegalStateException("cannot consume EOF");
        }
        this.f10942c++;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public final int mo13717c() {
        return this.f10942c;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: d */
    public final int mo13719d() {
        return this.f10940a;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: e */
    public final int mo13720e() {
        return -1;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public final void mo13716b(int i) {
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public final void mo13718c(int i) {
        this.f10942c = i;
    }

    public final String toString() {
        return mo13712a(C1839i.m13746a(0, this.f10940a - 1));
    }

    /* compiled from: CodePointCharStream.java */
    /* renamed from: org.a.a.a.i$c */
    private static final class c extends AbstractC1861i {

        /* renamed from: e */
        static final /* synthetic */ boolean f10947e;

        /* renamed from: f */
        private final byte[] f10948f;

        static {
            f10947e = !AbstractC1861i.class.desiredAssertionStatus();
        }

        /* synthetic */ c(int i, int i2, String str, byte[] bArr, int i3, c cVar) {
            this(i, i2, str, bArr, i3);
        }

        private c(int i, int i2, String str, byte[] bArr, int i3) {
            super(i, i2, str, null);
            if (!f10947e && i3 != 0) {
                throw new AssertionError();
            }
            this.f10948f = bArr;
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1858f
        /* renamed from: a */
        public String mo13712a(C1839i c1839i) {
            int min = Math.min(c1839i.f10905c, this.f10940a);
            return new String(this.f10948f, min, Math.min((c1839i.f10906d - c1839i.f10905c) + 1, this.f10940a - min), C1818ab.f10846a);
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1869q
        /* renamed from: a */
        public int mo13711a(int i) {
            switch (Integer.signum(i)) {
                case -1:
                    int i2 = this.f10942c + i;
                    if (i2 < 0) {
                        return -1;
                    }
                    return this.f10948f[i2] & 255;
                case 0:
                    return 0;
                case 1:
                    int i3 = (this.f10942c + i) - 1;
                    if (i3 < this.f10940a) {
                        return this.f10948f[i3] & 255;
                    }
                    return -1;
                default:
                    throw new UnsupportedOperationException("Not reached");
            }
        }
    }

    /* compiled from: CodePointCharStream.java */
    /* renamed from: org.a.a.a.i$a */
    private static final class a extends AbstractC1861i {

        /* renamed from: e */
        static final /* synthetic */ boolean f10943e;

        /* renamed from: f */
        private final char[] f10944f;

        static {
            f10943e = !AbstractC1861i.class.desiredAssertionStatus();
        }

        /* synthetic */ a(int i, int i2, String str, char[] cArr, int i3, a aVar) {
            this(i, i2, str, cArr, i3);
        }

        private a(int i, int i2, String str, char[] cArr, int i3) {
            super(i, i2, str, null);
            this.f10944f = cArr;
            if (!f10943e && i3 != 0) {
                throw new AssertionError();
            }
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1858f
        /* renamed from: a */
        public String mo13712a(C1839i c1839i) {
            int min = Math.min(c1839i.f10905c, this.f10940a);
            return new String(this.f10944f, min, Math.min((c1839i.f10906d - c1839i.f10905c) + 1, this.f10940a - min));
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1869q
        /* renamed from: a */
        public int mo13711a(int i) {
            switch (Integer.signum(i)) {
                case -1:
                    int i2 = this.f10942c + i;
                    if (i2 < 0) {
                        return -1;
                    }
                    return this.f10944f[i2] & 65535;
                case 0:
                    return 0;
                case 1:
                    int i3 = (this.f10942c + i) - 1;
                    if (i3 < this.f10940a) {
                        return this.f10944f[i3] & 65535;
                    }
                    return -1;
                default:
                    throw new UnsupportedOperationException("Not reached");
            }
        }
    }

    /* compiled from: CodePointCharStream.java */
    /* renamed from: org.a.a.a.i$b */
    private static final class b extends AbstractC1861i {

        /* renamed from: e */
        static final /* synthetic */ boolean f10945e;

        /* renamed from: f */
        private final int[] f10946f;

        static {
            f10945e = !AbstractC1861i.class.desiredAssertionStatus();
        }

        /* synthetic */ b(int i, int i2, String str, int[] iArr, int i3, b bVar) {
            this(i, i2, str, iArr, i3);
        }

        private b(int i, int i2, String str, int[] iArr, int i3) {
            super(i, i2, str, null);
            this.f10946f = iArr;
            if (!f10945e && i3 != 0) {
                throw new AssertionError();
            }
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1858f
        /* renamed from: a */
        public String mo13712a(C1839i c1839i) {
            int min = Math.min(c1839i.f10905c, this.f10940a);
            return new String(this.f10946f, min, Math.min((c1839i.f10906d - c1839i.f10905c) + 1, this.f10940a - min));
        }

        @Override // org.p210a.p211a.p212a.InterfaceC1869q
        /* renamed from: a */
        public int mo13711a(int i) {
            switch (Integer.signum(i)) {
                case -1:
                    int i2 = this.f10942c + i;
                    if (i2 < 0) {
                        return -1;
                    }
                    return this.f10946f[i2];
                case 0:
                    return 0;
                case 1:
                    int i3 = (this.f10942c + i) - 1;
                    if (i3 < this.f10940a) {
                        return this.f10946f[i3];
                    }
                    return -1;
                default:
                    throw new UnsupportedOperationException("Not reached");
            }
        }
    }
}
