package p046b.p047a.p050c.p051a;

import android.bluetooth.BluetoothHidDevice;
import android.util.DisplayMetrics;
import com.srizwan.apktool.R;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResConfigFlags.java */
/* renamed from: b.a.c.a.a */
/* loaded from: classes.dex */
public class C0468a {

    /* renamed from: B */
    private static int f3343B = 0;

    /* renamed from: A */
    private final int f3344A;

    /* renamed from: C */
    private final InterfaceC0541f f3345C;

    /* renamed from: a */
    public final short f3346a;

    /* renamed from: b */
    public final short f3347b;

    /* renamed from: c */
    public final char[] f3348c;

    /* renamed from: d */
    public final char[] f3349d;

    /* renamed from: e */
    public final byte f3350e;

    /* renamed from: f */
    public final byte f3351f;

    /* renamed from: g */
    public final int f3352g;

    /* renamed from: h */
    public final byte f3353h;

    /* renamed from: i */
    public final byte f3354i;

    /* renamed from: j */
    public final byte f3355j;

    /* renamed from: k */
    public final byte f3356k;

    /* renamed from: l */
    public final short f3357l;

    /* renamed from: m */
    public final short f3358m;

    /* renamed from: n */
    public final short f3359n;

    /* renamed from: o */
    public final byte f3360o;

    /* renamed from: p */
    public final byte f3361p;

    /* renamed from: q */
    public final short f3362q;

    /* renamed from: r */
    public final short f3363r;

    /* renamed from: s */
    public final short f3364s;

    /* renamed from: t */
    public final boolean f3365t;

    /* renamed from: u */
    private final char[] f3366u;

    /* renamed from: v */
    private final char[] f3367v;

    /* renamed from: w */
    private final byte f3368w;

    /* renamed from: x */
    private final byte f3369x;

    /* renamed from: y */
    private final char[] f3370y;

    /* renamed from: z */
    private final String f3371z;

    public C0468a(InterfaceC0541f interfaceC0541f) {
        this.f3345C = interfaceC0541f;
        this.f3346a = (short) 0;
        this.f3347b = (short) 0;
        this.f3348c = new char[]{0, 0};
        this.f3349d = new char[]{0, 0};
        this.f3350e = (byte) 0;
        this.f3351f = (byte) 0;
        this.f3352g = 0;
        this.f3353h = (byte) 0;
        this.f3354i = (byte) 0;
        this.f3355j = (byte) 0;
        this.f3356k = (byte) 0;
        this.f3357l = (short) 0;
        this.f3358m = (short) 0;
        this.f3359n = (short) 0;
        this.f3360o = (byte) 0;
        this.f3361p = (byte) 0;
        this.f3362q = (short) 0;
        this.f3363r = (short) 0;
        this.f3364s = (short) 0;
        this.f3366u = (char[]) null;
        this.f3367v = (char[]) null;
        this.f3368w = (byte) 0;
        this.f3369x = (byte) 0;
        this.f3370y = (char[]) null;
        this.f3365t = false;
        this.f3371z = "";
        this.f3344A = 0;
    }

    public C0468a(short s, short s2, char[] cArr, char[] cArr2, byte b2, byte b3, int i, byte b4, byte b5, byte b6, byte b7, short s3, short s4, short s5, byte b8, byte b9, short s6, short s7, short s8, char[] cArr3, char[] cArr4, byte b10, byte b11, char[] cArr5, boolean z, int i2, InterfaceC0541f interfaceC0541f) {
        boolean z2;
        boolean z3;
        char[] cArr6;
        char[] cArr7;
        this.f3345C = interfaceC0541f;
        if (b2 < 0 || b2 > 3) {
            this.f3345C.mo3983c(R.string.text, new StringBuffer().append("Invalid orientation value: ").append((int) b2).toString());
            b2 = (byte) 0;
            z2 = true;
        } else {
            z2 = z;
        }
        if (b3 < 0 || b3 > 3) {
            this.f3345C.mo3983c(R.string.text, new StringBuffer().append("Invalid touchscreen value: ").append((int) b3).toString());
            b3 = (byte) 0;
            z2 = true;
        }
        if (i < -1) {
            this.f3345C.mo3983c(R.string.text, new StringBuffer().append("Invalid density value: ").append(i).toString());
            i = 0;
            z2 = true;
        }
        if (b4 < 0 || b4 > 3) {
            this.f3345C.mo3983c(R.string.text, new StringBuffer().append("Invalid keyboard value: ").append((int) b4).toString());
            b4 = (byte) 0;
            z2 = true;
        }
        if (b5 < 0 || b5 > 4) {
            this.f3345C.mo3983c(R.string.text, new StringBuffer().append("Invalid navigation value: ").append((int) b5).toString());
            b5 = (byte) 0;
            z3 = true;
        } else {
            z3 = z2;
        }
        if (cArr3 != null && cArr3.length != 0) {
            cArr6 = cArr3[0] == 0 ? (char[]) null : cArr3;
        } else {
            cArr6 = (char[]) null;
        }
        if (cArr4 != null && cArr4.length != 0) {
            cArr7 = cArr4[0] == 0 ? (char[]) null : cArr4;
        } else {
            cArr7 = (char[]) null;
        }
        this.f3346a = s;
        this.f3347b = s2;
        this.f3348c = cArr;
        this.f3349d = cArr2;
        this.f3350e = b2;
        this.f3351f = b3;
        this.f3352g = i;
        this.f3353h = b4;
        this.f3354i = b5;
        this.f3355j = b6;
        this.f3356k = b7;
        this.f3357l = s3;
        this.f3358m = s4;
        this.f3359n = s5;
        this.f3360o = b8;
        this.f3361p = b9;
        this.f3362q = s6;
        this.f3363r = s7;
        this.f3364s = s8;
        this.f3366u = cArr6;
        this.f3367v = cArr7;
        this.f3368w = b10;
        this.f3369x = b11;
        this.f3370y = cArr5;
        this.f3365t = z3;
        this.f3344A = i2;
        this.f3371z = m3621b();
    }

    /* renamed from: a */
    public String m3624a() {
        return this.f3371z;
    }

    /* renamed from: b */
    private String m3621b() {
        StringBuilder sb = new StringBuilder();
        if (this.f3346a != 0) {
            sb.append("-mcc").append(String.format("%03d", new Short(this.f3346a)));
            if (this.f3347b != -1) {
                if (this.f3347b != 0) {
                    sb.append("-mnc");
                    if (this.f3344A <= 32) {
                        if (this.f3347b > 0 && this.f3347b < 10) {
                            sb.append(String.format("%02d", new Short(this.f3347b)));
                        } else {
                            sb.append(String.format("%03d", new Short(this.f3347b)));
                        }
                    } else {
                        sb.append((int) this.f3347b);
                    }
                }
            } else {
                sb.append("-mnc00");
            }
        } else if (this.f3347b != 0) {
            sb.append("-mnc").append((int) this.f3347b);
        }
        sb.append(m3623d());
        switch (this.f3356k) {
            case 1:
                sb.append("-neuter");
                break;
            case 2:
                sb.append("-feminine");
                break;
            case 3:
                sb.append("-masculine");
                break;
        }
        switch (this.f3360o & BluetoothHidDevice.SUBCLASS1_COMBO) {
            case 64:
                sb.append("-ldltr");
                break;
            case 128:
                sb.append("-ldrtl");
                break;
        }
        if (this.f3362q != 0) {
            sb.append("-sw").append((int) this.f3362q).append("dp");
        }
        if (this.f3363r != 0) {
            sb.append("-w").append((int) this.f3363r).append("dp");
        }
        if (this.f3364s != 0) {
            sb.append("-h").append((int) this.f3364s).append("dp");
        }
        switch (this.f3360o & 15) {
            case 1:
                sb.append("-small");
                break;
            case 2:
                sb.append("-normal");
                break;
            case 3:
                sb.append("-large");
                break;
            case 4:
                sb.append("-xlarge");
                break;
        }
        switch (this.f3360o & 48) {
            case 16:
                sb.append("-notlong");
                break;
            case 32:
                sb.append("-long");
                break;
        }
        switch (this.f3368w & 3) {
            case 1:
                sb.append("-notround");
                break;
            case 2:
                sb.append("-round");
                break;
        }
        switch (this.f3369x & 12) {
            case 4:
                sb.append("-lowdr");
                break;
            case 8:
                sb.append("-highdr");
                break;
        }
        switch (this.f3369x & 3) {
            case 1:
                sb.append("-nowidecg");
                break;
            case 2:
                sb.append("-widecg");
                break;
        }
        switch (this.f3350e) {
            case 1:
                sb.append("-port");
                break;
            case 2:
                sb.append("-land");
                break;
            case 3:
                sb.append("-square");
                break;
        }
        switch (this.f3361p & 15) {
            case 2:
                sb.append("-desk");
                break;
            case 3:
                sb.append("-car");
                break;
            case 4:
                sb.append("-television");
                break;
            case 5:
                sb.append("-appliance");
                break;
            case 6:
                sb.append("-watch");
                break;
            case 7:
                sb.append("-vrheadset");
                break;
            case 11:
                sb.append("-godzillaui");
                break;
            case 12:
                sb.append("-smallui");
                break;
            case 13:
                sb.append("-mediumui");
                break;
            case 14:
                sb.append("-largeui");
                break;
            case 15:
                sb.append("-hugeui");
                break;
        }
        switch (this.f3361p & 48) {
            case 16:
                sb.append("-notnight");
                break;
            case 32:
                sb.append("-night");
                break;
        }
        switch (this.f3352g) {
            case 0:
                break;
            case 120:
                sb.append("-ldpi");
                break;
            case 160:
                sb.append("-mdpi");
                break;
            case 213:
                sb.append("-tvdpi");
                break;
            case 240:
                sb.append("-hdpi");
                break;
            case 320:
                sb.append("-xhdpi");
                break;
            case DisplayMetrics.DENSITY_XXHIGH /* 480 */:
                sb.append("-xxhdpi");
                break;
            case DisplayMetrics.DENSITY_XXXHIGH /* 640 */:
                sb.append("-xxxhdpi");
                break;
            case 65534:
                sb.append("-anydpi");
                break;
            case 65535:
                sb.append("-nodpi");
                break;
            default:
                sb.append('-').append(this.f3352g).append("dpi");
                break;
        }
        switch (this.f3351f) {
            case 1:
                sb.append("-notouch");
                break;
            case 2:
                sb.append("-stylus");
                break;
            case 3:
                sb.append("-finger");
                break;
        }
        switch (this.f3355j & 3) {
            case 1:
                sb.append("-keysexposed");
                break;
            case 2:
                sb.append("-keyshidden");
                break;
            case 3:
                sb.append("-keyssoft");
                break;
        }
        switch (this.f3353h) {
            case 1:
                sb.append("-nokeys");
                break;
            case 2:
                sb.append("-qwerty");
                break;
            case 3:
                sb.append("-12key");
                break;
        }
        switch (this.f3355j & 12) {
            case 4:
                sb.append("-navexposed");
                break;
            case 8:
                sb.append("-navhidden");
                break;
        }
        switch (this.f3354i) {
            case 1:
                sb.append("-nonav");
                break;
            case 2:
                sb.append("-dpad");
                break;
            case 3:
                sb.append("-trackball");
                break;
            case 4:
                sb.append("-wheel");
                break;
        }
        if (this.f3357l != 0 && this.f3358m != 0) {
            if (this.f3357l > this.f3358m) {
                sb.append(String.format("-%dx%d", new Short(this.f3357l), new Short(this.f3358m)));
            } else {
                sb.append(String.format("-%dx%d", new Short(this.f3358m), new Short(this.f3357l)));
            }
        }
        if (this.f3359n > 0 && this.f3359n >= m3622c()) {
            sb.append("-v").append((int) this.f3359n);
        }
        if (this.f3365t) {
            StringBuilder append = sb.append("-ERR");
            int i = f3343B;
            f3343B = i + 1;
            append.append(i);
        }
        return sb.toString();
    }

    /* renamed from: c */
    private short m3622c() {
        if ((this.f3361p & 15) == 7 || (this.f3369x & 3) != 0 || (this.f3369x & 12) != 0) {
            return (short) 26;
        }
        if ((this.f3368w & 3) != 0) {
            return (short) 23;
        }
        if (this.f3352g == 65534) {
            return (short) 21;
        }
        if (this.f3362q != 0 || this.f3363r != 0 || this.f3364s != 0) {
            return (short) 13;
        }
        if ((this.f3361p & 63) != 0) {
            return (short) 8;
        }
        if ((this.f3360o & 63) != 0 || this.f3352g != 0) {
            return (short) 4;
        }
        return (short) 0;
    }

    /* renamed from: d */
    private String m3623d() {
        StringBuilder sb = new StringBuilder();
        if (this.f3367v == null && this.f3366u == null && ((this.f3349d[0] != 0 || this.f3348c[0] != 0) && this.f3349d.length != 3)) {
            sb.append("-").append(this.f3348c);
            if (this.f3349d[0] != 0) {
                sb.append("-r").append(this.f3349d);
            }
        } else {
            if (this.f3348c[0] == 0 && this.f3349d[0] == 0) {
                return sb.toString();
            }
            sb.append("-b+");
            if (this.f3348c[0] != 0) {
                sb.append(this.f3348c);
            }
            if (this.f3366u != null && this.f3366u.length == 4) {
                sb.append("+").append(this.f3366u);
            }
            if ((this.f3349d.length == 2 || this.f3349d.length == 3) && this.f3349d[0] != 0) {
                sb.append("+").append(this.f3349d);
            }
            if (this.f3367v != null && this.f3367v.length >= 5) {
                sb.append("+").append(m3620a(this.f3367v));
            }
            if (this.f3370y != null && this.f3370y.length > 0) {
                sb.append("+u+nu+").append(this.f3370y);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m3620a(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : cArr) {
            sb.append(Character.toUpperCase(c2));
        }
        return sb.toString();
    }

    public String toString() {
        return !m3624a().equals("") ? m3624a() : "[DEFAULT]";
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return this.f3371z.equals(((C0468a) obj).f3371z);
        }
        return false;
    }

    public int hashCode() {
        return this.f3371z.hashCode() + 527;
    }
}
