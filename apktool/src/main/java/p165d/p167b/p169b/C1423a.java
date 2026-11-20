package p165d.p167b.p169b;

import java.io.IOException;
import javax.xml.datatype.DatatypeConstants;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: ContentInfo.java */
/* renamed from: d.b.b.a */
/* loaded from: classes.dex */
public class C1423a {

    /* renamed from: l */
    C1450m f9212l;

    /* renamed from: m */
    C1454q f9213m;

    /* renamed from: u */
    private static int[] f9208u = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7};

    /* renamed from: q */
    private static int[] f9204q = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 1};

    /* renamed from: v */
    private static int[] f9209v = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 2};

    /* renamed from: s */
    private static int[] f9206s = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 3};

    /* renamed from: w */
    private static int[] f9210w = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 4};

    /* renamed from: r */
    private static int[] f9205r = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 5};

    /* renamed from: p */
    private static int[] f9203p = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 6};

    /* renamed from: t */
    private static int[] f9207t = {2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 113730, 2, 5};

    /* renamed from: x */
    private static int[] f9211x = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 16, 1, 4};

    /* renamed from: o */
    private static final int[] f9202o = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1113549, 1, 7, 2};

    /* renamed from: n */
    private static final int[] f9201n = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1113549, 1, 7, 1};

    /* renamed from: h */
    public static C1454q f9197h = C1454q.m11454a(f9208u);

    /* renamed from: a */
    public static C1454q f9190a = C1454q.m11454a(f9204q);

    /* renamed from: j */
    public static C1454q f9199j = C1454q.m11454a(f9209v);

    /* renamed from: d */
    public static C1454q f9193d = C1454q.m11454a(f9206s);

    /* renamed from: i */
    public static C1454q f9198i = C1454q.m11454a(f9210w);

    /* renamed from: b */
    public static C1454q f9191b = C1454q.m11454a(f9205r);

    /* renamed from: c */
    public static C1454q f9192c = C1454q.m11454a(f9203p);

    /* renamed from: g */
    public static C1454q f9196g = C1454q.m11454a(f9202o);

    /* renamed from: f */
    public static C1454q f9195f = C1454q.m11454a(f9201n);

    /* renamed from: e */
    public static C1454q f9194e = C1454q.m11454a(f9207t);

    /* renamed from: k */
    public static C1454q f9200k = C1454q.m11454a(f9211x);

    public C1423a(C1454q c1454q, C1450m c1450m) {
        this.f9213m = c1454q;
        this.f9212l = c1450m;
    }

    public C1423a(byte[] bArr) {
        C1450m c1450m = new C1450m((byte) 4, bArr);
        this.f9213m = f9190a;
        this.f9212l = c1450m;
    }

    public C1423a(C1448k c1448k) {
        this(c1448k, false);
    }

    public C1423a(C1448k c1448k, boolean z) {
        C1450m[] m11364a = c1448k.m11364a(2);
        this.f9213m = new C1448k(m11364a[0].m11440u()).m11376h();
        if (z) {
            this.f9212l = m11364a[1];
        } else if (m11364a.length > 1) {
            this.f9212l = new C1448k(m11364a[1].m11440u()).m11365a(1, true)[0];
        }
    }

    /* renamed from: a */
    public C1450m m11241a() {
        return this.f9212l;
    }

    /* renamed from: c */
    public C1454q m11244c() {
        return this.f9213m;
    }

    /* renamed from: d */
    public byte[] m11245d() {
        if (this.f9213m.equals(f9190a) || this.f9213m.equals(f9195f) || this.f9213m.equals(f9200k)) {
            if (this.f9212l == null) {
                return null;
            }
            return this.f9212l.m11432m();
        }
        throw new IOException("content type is not DATA: " + this.f9213m);
    }

    /* renamed from: a */
    public void m11242a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        c1449l2.m11394a(this.f9213m);
        if (this.f9212l != null) {
            C1449l c1449l3 = new C1449l();
            this.f9212l.m11416a(c1449l3);
            c1449l2.m11393a(new C1450m((byte) -96, c1449l3.toByteArray()));
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }

    /* renamed from: b */
    public byte[] m11243b() {
        if (this.f9212l == null) {
            return null;
        }
        return new C1448k(this.f9212l.m11440u()).m11377i();
    }

    public String toString() {
        return String.valueOf(String.valueOf("") + "Content Info Sequence\n\tContent type: " + this.f9213m + "\n") + "\tContent: " + this.f9212l;
    }
}
