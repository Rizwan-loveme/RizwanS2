package p060c.p061a.p062a;

import com.p065b.p066a.p068b.p069a.C0586a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import p060c.p061a.C0551b;

/* compiled from: AxmlParser.java */
/* renamed from: c.a.a.a */
/* loaded from: classes.dex */
public class C0545a {

    /* renamed from: a */
    private int f3646a;

    /* renamed from: b */
    private IntBuffer f3647b;

    /* renamed from: c */
    private int f3648c;

    /* renamed from: d */
    private int f3649d;

    /* renamed from: e */
    private int f3650e;

    /* renamed from: f */
    private ByteBuffer f3651f;

    /* renamed from: g */
    private int f3652g;

    /* renamed from: h */
    private int f3653h;

    /* renamed from: i */
    private int f3654i;

    /* renamed from: j */
    private int f3655j;

    /* renamed from: k */
    private int[] f3656k;

    /* renamed from: l */
    private String[] f3657l;

    /* renamed from: m */
    private int f3658m;

    /* renamed from: n */
    private int f3659n;

    /* renamed from: o */
    private int f3660o;

    public C0545a(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    public C0545a(ByteBuffer byteBuffer) {
        this.f3649d = -1;
        this.f3660o = 5;
        this.f3651f = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    public int m4005a() {
        return this.f3646a;
    }

    /* renamed from: a */
    public String m4006a(int i) {
        return this.f3657l[this.f3647b.get((this.f3660o * i) + 1)];
    }

    /* renamed from: b */
    public String m4008b(int i) {
        int i2 = this.f3647b.get((this.f3660o * i) + 0);
        return i2 >= 0 ? this.f3657l[i2] : (String) null;
    }

    /* renamed from: c */
    String m4010c(int i) {
        int i2 = this.f3647b.get((this.f3660o * i) + 2);
        return i2 >= 0 ? this.f3657l[i2] : (String) null;
    }

    /* renamed from: d */
    public int m4011d(int i) {
        int i2;
        if (this.f3656k == null || (i2 = this.f3647b.get((this.f3660o * i) + 1)) < 0 || i2 >= this.f3656k.length) {
            return -1;
        }
        return this.f3656k[i2];
    }

    /* renamed from: e */
    public int m4013e(int i) {
        return this.f3647b.get((this.f3660o * i) + 3) >> 24;
    }

    /* renamed from: f */
    public Object m4015f(int i) {
        int i2 = this.f3647b.get((this.f3660o * i) + 4);
        if (i == this.f3650e) {
            return C0550f.m4034a(i2, m4010c(i));
        }
        if (i == this.f3658m) {
            return C0550f.m4035b(i2, m4010c(i));
        }
        if (i == this.f3648c) {
            return C0550f.m4036c(i2, m4010c(i));
        }
        switch (m4013e(i)) {
            case 3:
                return this.f3657l[i2];
            case 18:
                return new Boolean(i2 != 0);
            default:
                return new Integer(i2);
        }
    }

    /* renamed from: b */
    public int m4007b() {
        return this.f3652g;
    }

    /* renamed from: c */
    public String m4009c() {
        return this.f3657l[this.f3653h];
    }

    /* renamed from: d */
    public String m4012d() {
        return this.f3657l[this.f3655j];
    }

    /* renamed from: e */
    public String m4014e() {
        return this.f3654i >= 0 ? this.f3657l[this.f3654i] : (String) null;
    }

    /* renamed from: f */
    public String m4016f() {
        return this.f3657l[this.f3659n];
    }

    /* renamed from: g */
    public int m4017g() {
        int i = 2;
        if (this.f3649d < 0) {
            if ((this.f3651f.getInt() & 65535) != 3) {
                throw new RuntimeException();
            }
            this.f3649d = this.f3651f.getInt();
            return 1;
        }
        int position = this.f3651f.position();
        while (position < this.f3649d) {
            int i2 = this.f3651f.getInt() & 65535;
            int i3 = this.f3651f.getInt();
            switch (i2) {
                case 1:
                    this.f3657l = C0551b.m4037a(this.f3651f);
                    this.f3651f.position(position + i3);
                    continue;
                    position = this.f3651f.position();
                case 256:
                    this.f3652g = this.f3651f.getInt();
                    this.f3651f.getInt();
                    this.f3655j = this.f3651f.getInt();
                    this.f3654i = this.f3651f.getInt();
                    i = 4;
                    break;
                case 257:
                    this.f3651f.position(position + i3);
                    i = 5;
                    break;
                case 258:
                    this.f3652g = this.f3651f.getInt();
                    this.f3651f.getInt();
                    this.f3654i = this.f3651f.getInt();
                    this.f3653h = this.f3651f.getInt();
                    m4004g(2);
                    this.f3660o = this.f3651f.getShort() / 4;
                    this.f3646a = this.f3651f.getShort() & 65535;
                    this.f3650e = (this.f3651f.getShort() & 65535) - 1;
                    this.f3648c = (this.f3651f.getShort() & 65535) - 1;
                    this.f3658m = (this.f3651f.getShort() & 65535) - 1;
                    this.f3647b = this.f3651f.asIntBuffer();
                    break;
                case 259:
                    this.f3651f.position(position + i3);
                    i = 3;
                    break;
                case 260:
                    this.f3652g = this.f3651f.getInt();
                    this.f3651f.getInt();
                    this.f3659n = this.f3651f.getInt();
                    this.f3651f.getInt();
                    this.f3651f.getInt();
                    i = 6;
                    break;
                case C0586a.b.RES_XML_TYPE_RESOURCE_MAP /* 384 */:
                    int i4 = (i3 / 4) - 2;
                    this.f3656k = new int[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        this.f3656k[i5] = this.f3651f.getInt();
                    }
                    this.f3651f.position(position + i3);
                    continue;
                    position = this.f3651f.position();
                default:
                    throw new RuntimeException(new StringBuffer().append("Unsupported type: ").append(i2).toString());
            }
            this.f3651f.position(position + i3);
            return i;
        }
        return 7;
    }

    /* renamed from: g */
    private void m4004g(int i) {
        this.f3651f.position(this.f3651f.position() + i);
    }
}
