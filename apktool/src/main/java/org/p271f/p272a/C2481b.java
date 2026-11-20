package org.p271f.p272a;

/* compiled from: AnnotationWriter.java */
/* renamed from: org.f.a.b */
/* loaded from: classes.dex */
final class C2481b extends AbstractC2473a {

    /* renamed from: c */
    C2481b f12980c;

    /* renamed from: d */
    C2481b f12981d;

    /* renamed from: e */
    private final C2516h f12982e;

    /* renamed from: f */
    private int f12983f;

    /* renamed from: g */
    private final boolean f12984g;

    /* renamed from: h */
    private final C2513e f12985h;

    /* renamed from: i */
    private final C2513e f12986i;

    /* renamed from: j */
    private final int f12987j;

    C2481b(C2516h c2516h, boolean z, C2513e c2513e, C2513e c2513e2, int i) {
        super(327680);
        this.f12982e = c2516h;
        this.f12984g = z;
        this.f12985h = c2513e;
        this.f12986i = c2513e2;
        this.f12987j = i;
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15638a(String str, Object obj) {
        int i = 0;
        this.f12983f++;
        if (this.f12984g) {
            this.f12985h.m15770b(this.f12982e.m15807a(str));
        }
        if (obj instanceof String) {
            this.f12985h.m15771b(115, this.f12982e.m15807a((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.f12985h.m15771b(66, this.f12982e.m15811a((int) ((Byte) obj).byteValue()).f13192a);
            return;
        }
        if (obj instanceof Boolean) {
            this.f12985h.m15771b(90, this.f12982e.m15811a(((Boolean) obj).booleanValue() ? 1 : 0).f13192a);
            return;
        }
        if (obj instanceof Character) {
            this.f12985h.m15771b(67, this.f12982e.m15811a((int) ((Character) obj).charValue()).f13192a);
            return;
        }
        if (obj instanceof Short) {
            this.f12985h.m15771b(83, this.f12982e.m15811a((int) ((Short) obj).shortValue()).f13192a);
            return;
        }
        if (obj instanceof C2529u) {
            this.f12985h.m15771b(99, this.f12982e.m15807a(((C2529u) obj).m15901e()));
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f12985h.m15771b(91, bArr.length);
            while (i < bArr.length) {
                this.f12985h.m15771b(66, this.f12982e.m15811a((int) bArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f12985h.m15771b(91, zArr.length);
            for (boolean z : zArr) {
                this.f12985h.m15771b(90, this.f12982e.m15811a(z ? 1 : 0).f13192a);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f12985h.m15771b(91, sArr.length);
            while (i < sArr.length) {
                this.f12985h.m15771b(83, this.f12982e.m15811a((int) sArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f12985h.m15771b(91, cArr.length);
            while (i < cArr.length) {
                this.f12985h.m15771b(67, this.f12982e.m15811a((int) cArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f12985h.m15771b(91, iArr.length);
            while (i < iArr.length) {
                this.f12985h.m15771b(73, this.f12982e.m15811a(iArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f12985h.m15771b(91, jArr.length);
            while (i < jArr.length) {
                this.f12985h.m15771b(74, this.f12982e.m15813a(jArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f12985h.m15771b(91, fArr.length);
            while (i < fArr.length) {
                this.f12985h.m15771b(70, this.f12982e.m15810a(fArr[i]).f13192a);
                i++;
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            this.f12985h.m15771b(91, dArr.length);
            while (i < dArr.length) {
                this.f12985h.m15771b(68, this.f12982e.m15809a(dArr[i]).f13192a);
                i++;
            }
            return;
        }
        C2524p m15814a = this.f12982e.m15814a(obj);
        this.f12985h.m15771b(".s.IFJDCS".charAt(m15814a.f13193b), m15814a.f13192a);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15639a(String str, String str2, String str3) {
        this.f12983f++;
        if (this.f12984g) {
            this.f12985h.m15770b(this.f12982e.m15807a(str));
        }
        this.f12985h.m15771b(101, this.f12982e.m15807a(str2)).m15770b(this.f12982e.m15807a(str3));
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15636a(String str, String str2) {
        this.f12983f++;
        if (this.f12984g) {
            this.f12985h.m15770b(this.f12982e.m15807a(str));
        }
        this.f12985h.m15771b(64, this.f12982e.m15807a(str2)).m15770b(0);
        return new C2481b(this.f12982e, true, this.f12985h, this.f12985h, this.f12985h.f13089b - 2);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15635a(String str) {
        this.f12983f++;
        if (this.f12984g) {
            this.f12985h.m15770b(this.f12982e.m15807a(str));
        }
        this.f12985h.m15771b(91, 0);
        return new C2481b(this.f12982e, false, this.f12985h, this.f12985h, this.f12985h.f13089b - 2);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15637a() {
        if (this.f12986i != null) {
            byte[] bArr = this.f12986i.f13088a;
            bArr[this.f12987j] = (byte) (this.f12983f >>> 8);
            bArr[this.f12987j + 1] = (byte) this.f12983f;
        }
    }

    /* renamed from: b */
    int m15708b() {
        int i = 0;
        while (this != null) {
            i += this.f12985h.f13089b;
            this = this.f12980c;
        }
        return i;
    }

    /* renamed from: a */
    void m15707a(C2513e c2513e) {
        int i = 2;
        C2481b c2481b = null;
        int i2 = 0;
        for (C2481b c2481b2 = this; c2481b2 != null; c2481b2 = c2481b2.f12980c) {
            i2++;
            i += c2481b2.f12985h.f13089b;
            c2481b2.mo15637a();
            c2481b2.f12981d = c2481b;
            c2481b = c2481b2;
        }
        c2513e.m15772c(i);
        c2513e.m15770b(i2);
        while (c2481b != null) {
            c2513e.m15769a(c2481b.f12985h.f13088a, 0, c2481b.f12985h.f13089b);
            c2481b = c2481b.f12981d;
        }
    }

    /* renamed from: a */
    static void m15706a(C2481b[] c2481bArr, int i, C2513e c2513e) {
        int length = ((c2481bArr.length - i) * 2) + 1;
        for (int i2 = i; i2 < c2481bArr.length; i2++) {
            length += c2481bArr[i2] == null ? 0 : c2481bArr[i2].m15708b();
        }
        c2513e.m15772c(length).m15764a(c2481bArr.length - i);
        while (i < c2481bArr.length) {
            C2481b c2481b = null;
            int i3 = 0;
            for (C2481b c2481b2 = c2481bArr[i]; c2481b2 != null; c2481b2 = c2481b2.f12980c) {
                i3++;
                c2481b2.mo15637a();
                c2481b2.f12981d = c2481b;
                c2481b = c2481b2;
            }
            c2513e.m15770b(i3);
            while (c2481b != null) {
                c2513e.m15769a(c2481b.f12985h.f13088a, 0, c2481b.f12985h.f13089b);
                c2481b = c2481b.f12981d;
            }
            i++;
        }
    }

    /* renamed from: a */
    static void m15705a(int i, C2530v c2530v, C2513e c2513e) {
        switch (i >>> 24) {
            case 0:
            case 1:
            case 22:
                c2513e.m15770b(i >>> 16);
                break;
            case 19:
            case 20:
            case 21:
                c2513e.m15764a(i >>> 24);
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                c2513e.m15772c(i);
                break;
            default:
                c2513e.m15771b(i >>> 24, (16776960 & i) >> 8);
                break;
        }
        if (c2530v == null) {
            c2513e.m15764a(0);
        } else {
            c2513e.m15769a(c2530v.f13286a, c2530v.f13287b, (c2530v.f13286a[c2530v.f13287b] * 2) + 1);
        }
    }
}
