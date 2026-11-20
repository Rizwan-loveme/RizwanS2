package p046b.p047a.p050c.p053b;

import android.graphics.Color;
import com.p129f.p130a.p135e.C1215c;
import com.srizwan.apktool.R;
import java.math.BigInteger;
import java.p209io.EOFException;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.p217b.p218a.p219a.p220a.C1880a;
import p046b.p047a.C0461b;
import p046b.p047a.C0518d;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0468a;
import p046b.p047a.p050c.p051a.C0491b;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.C0495f;
import p046b.p047a.p050c.p051a.C0496g;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p047a.p050c.p051a.p052a.AbstractC0486r;
import p046b.p047a.p050c.p051a.p052a.C0471c;
import p046b.p047a.p050c.p051a.p052a.C0472d;
import p046b.p047a.p050c.p051a.p052a.C0477i;
import p046b.p047a.p050c.p051a.p052a.C0482n;
import p046b.p047a.p050c.p051a.p052a.C0485q;
import p046b.p047a.p050c.p051a.p052a.C0487s;
import p046b.p047a.p050c.p051a.p052a.C0489u;
import p046b.p047a.p050c.p051a.p052a.C0490v;
import p046b.p059d.C0538c;
import p046b.p059d.C0539d;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ARSCDecoder.java */
/* renamed from: b.a.c.b.a */
/* loaded from: classes.dex */
public class C0501a {

    /* renamed from: b */
    private static C0467a f3470b;

    /* renamed from: d */
    private static int f3471d;

    /* renamed from: a */
    private boolean f3472a;

    /* renamed from: c */
    private int f3473c;

    /* renamed from: e */
    private final C0539d f3474e;

    /* renamed from: f */
    private final C0495f f3475f;

    /* renamed from: g */
    private final List<c> f3476g;

    /* renamed from: h */
    private final boolean f3477h;

    /* renamed from: i */
    private d f3478i;

    /* renamed from: j */
    private C0510j f3479j;

    /* renamed from: k */
    private C0510j f3480k;

    /* renamed from: l */
    private C0510j f3481l;

    /* renamed from: m */
    private C0492c f3482m;

    /* renamed from: n */
    private C0497h f3483n;

    /* renamed from: o */
    private C0496g f3484o;

    /* renamed from: p */
    private int f3485p;

    /* renamed from: r */
    private final HashMap<Integer, Integer> f3487r;

    /* renamed from: t */
    private final InterfaceC0541f f3489t;

    /* renamed from: q */
    private int f3486q = 0;

    /* renamed from: s */
    private final HashMap<Integer, C0497h> f3488s = new HashMap<>();

    /* renamed from: a */
    public static a m3761a(InputStream inputStream, boolean z, boolean z2, boolean z3, int i, C0467a c0467a, InterfaceC0541f interfaceC0541f) {
        return m3760a(inputStream, z, z2, z3, i, new C0495f(), c0467a, interfaceC0541f);
    }

    /* renamed from: a */
    public static a m3760a(InputStream inputStream, boolean z, boolean z2, boolean z3, int i, C0495f c0495f, C0467a c0467a, InterfaceC0541f interfaceC0541f) {
        f3470b = c0467a;
        try {
            C0501a c0501a = new C0501a(inputStream, c0495f, z, z2, z3, i, interfaceC0541f);
            return new a(c0501a.m3768b(), c0501a.f3476g == null ? (c[]) null : (c[]) c0501a.f3476g.toArray(new c[0]), c0495f, interfaceC0541f);
        } catch (IOException e2) {
            throw new C0461b("Could not decode arsc file", e2);
        }
    }

    /* renamed from: a */
    public static int m3758a() {
        return f3471d;
    }

    C0501a(InputStream inputStream, C0495f c0495f, boolean z, boolean z2, boolean z3, int i, InterfaceC0541f interfaceC0541f) {
        this.f3473c = 0;
        this.f3489t = interfaceC0541f;
        this.f3472a = z3;
        this.f3473c = i;
        C1880a c1880a = new C1880a(inputStream);
        if (z) {
            this.f3476g = new ArrayList();
        } else {
            this.f3476g = (List) null;
        }
        this.f3474e = new C0539d(new C1215c(c1880a));
        this.f3475f = c0495f;
        this.f3477h = z2;
        this.f3487r = new LinkedHashMap();
    }

    /* renamed from: b */
    private C0492c[] m3768b() {
        m3770c(2);
        f3471d = this.f3474e.readInt();
        this.f3478i.m3789a(this.f3474e);
        this.f3479j = C0510j.m3840a(this.f3474e, this.f3489t);
        C0492c[] c0492cArr = new C0492c[f3471d];
        m3783p();
        for (int i = 0; i < f3471d; i++) {
            this.f3486q = 0;
            c0492cArr[i] = m3769c();
        }
        return c0492cArr;
    }

    /* renamed from: c */
    private C0492c m3769c() {
        m3767b(512);
        int readInt = this.f3474e.readInt();
        if (readInt == 0) {
            readInt = 2;
            if (this.f3475f.m3730l() == null && this.f3475f.m3729k() == null) {
                this.f3475f.m3712b(true);
            }
        }
        String a2 = this.f3474e.m3972a(128, true);
        this.f3474e.m3975b();
        this.f3474e.m3975b();
        this.f3474e.m3975b();
        this.f3474e.m3975b();
        if (this.f3478i.f3502b == 288) {
            this.f3486q = this.f3474e.readInt();
        }
        if (this.f3486q > 0) {
            this.f3489t.mo3983c(R.string.report_error, new Object[0]);
        }
        this.f3478i.m3789a(this.f3474e);
        this.f3480k = C0510j.m3840a(this.f3474e, this.f3489t);
        this.f3481l = C0510j.m3840a(this.f3474e, this.f3489t);
        this.f3485p = readInt << 24;
        this.f3482m = new C0492c(this.f3475f, readInt, a2, this.f3472a, this.f3489t);
        m3783p();
        boolean z = true;
        while (z) {
            switch (this.f3478i.f3501a) {
                case 514:
                    m3775h();
                    break;
                case 515:
                    m3771d();
                    break;
                case 516:
                    m3773f();
                    break;
                case 517:
                    m3774g();
                    break;
                case 518:
                    m3772e();
                    break;
                default:
                    z = false;
                    break;
            }
        }
        return this.f3482m;
    }

    /* renamed from: d */
    private void m3771d() {
        m3767b(515);
        int readInt = this.f3474e.readInt();
        this.f3478i.m3789a(this.f3474e);
        for (int i = 0; i < readInt; i++) {
            this.f3489t.mo3984d(R.string.decoding_shared_library, this.f3474e.m3972a(128, true), new Integer(this.f3474e.readInt()));
        }
        while (m3783p().f3501a == 513) {
            m3775h();
        }
    }

    /* renamed from: e */
    private void m3772e() {
        C0518d c0518d = C0518d.f3579w;
        int readInt = this.f3474e.readInt();
        this.f3478i.m3789a(this.f3474e);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = this.f3474e.readInt();
            int readInt3 = this.f3474e.readInt();
            if (c0518d.f3584e) {
                this.f3489t.mo3984d(R.string.text, String.format("Skipping staged alias stagedId (%h) finalId: %h", new Integer(readInt2), new Integer(readInt3)));
            }
        }
        m3783p();
    }

    /* renamed from: f */
    private void m3773f() {
        m3767b(516);
        String a2 = this.f3474e.m3972a(256, true);
        String a3 = this.f3474e.m3972a(256, true);
        this.f3478i.m3789a(this.f3474e);
        this.f3489t.mo3982b(R.string.text, String.format("Overlay name: \"%s\", actor: \"%s\")", a2, a3));
        m3783p();
    }

    /* renamed from: g */
    private void m3774g() {
        m3767b(517);
        this.f3474e.m3975b();
        int readInt = this.f3474e.readInt();
        this.f3489t.mo3984d(R.string.text, String.format("Skipping overlays (%d)", new Integer(readInt)));
        this.f3478i.m3789a(this.f3474e);
        for (int i = 0; i < readInt; i++) {
            this.f3474e.readInt();
        }
        m3783p();
    }

    /* renamed from: h */
    private void m3775h() {
        this.f3483n = m3776i();
        m3764a(this.f3483n);
        short s = m3783p().f3501a;
        while (s == 514) {
            m3764a(m3776i());
            s = m3783p().f3501a;
            if (!this.f3475f.m3733o()) {
                this.f3475f.m3715c(true);
            }
        }
        while (s == 513) {
            m3777j();
            if (this.f3474e.m3969a() < this.f3478i.f3505e) {
                this.f3489t.mo3983c(R.string.unknown_skip_bytes, new Integer(this.f3478i.f3505e - this.f3474e.m3969a()));
                this.f3474e.m3970a(this.f3478i.f3505e - this.f3474e.m3969a());
            }
            s = m3783p().f3501a;
            if (this.f3472a) {
                m3782o();
            }
        }
    }

    /* renamed from: i */
    private C0497h m3776i() {
        m3767b(514);
        int readUnsignedByte = this.f3474e.readUnsignedByte();
        this.f3474e.skipBytes(3);
        int readInt = this.f3474e.readInt();
        if (this.f3476g != null) {
            this.f3476g.add(new c(this.f3474e.m3969a(), readInt));
        }
        this.f3478i.m3789a(this.f3474e);
        this.f3474e.skipBytes(readInt * 4);
        this.f3483n = new C0497h(this.f3480k.m3849a(readUnsignedByte - 1), this.f3475f, this.f3482m, readUnsignedByte, readInt);
        this.f3482m.m3665a(this.f3483n);
        return this.f3483n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    private C0496g m3777j() {
        m3767b(513);
        int readUnsignedByte = this.f3474e.readUnsignedByte() - this.f3486q;
        if (this.f3488s.containsKey(new Integer(readUnsignedByte))) {
            this.f3485p = (this.f3488s.get(new Integer(readUnsignedByte)).m3742b() << 16) | (this.f3485p & (-16777216));
            this.f3483n = this.f3488s.get(new Integer(readUnsignedByte));
        }
        byte readByte = this.f3474e.readByte();
        this.f3474e.skipBytes(2);
        int readInt = this.f3474e.readInt();
        int readInt2 = this.f3474e.readInt();
        C0468a m3781n = m3781n();
        this.f3478i.m3789a(this.f3474e);
        boolean z = (readByte & 2) != 0;
        boolean z2 = (readByte & 1) != 0;
        if (z2 && !this.f3475f.m3720d()) {
            this.f3475f.m3715c(true);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < readInt; i++) {
            if (z2) {
                linkedHashMap.put(new Integer(this.f3474e.readUnsignedShort()), new Integer(this.f3474e.readUnsignedShort()));
            } else if (z) {
                linkedHashMap.put(new Integer(i), new Integer(this.f3474e.readUnsignedShort()));
            } else {
                linkedHashMap.put(new Integer(i), new Integer(this.f3474e.readInt()));
            }
        }
        if (m3781n.f3365t) {
            String stringBuffer = new StringBuffer().append(this.f3483n.m3740a()).append(m3781n.m3624a()).toString();
            if (this.f3477h) {
                this.f3489t.mo3983c(R.string.text, new StringBuffer().append("Invalid config flags detected: ").append(stringBuffer).toString());
            } else {
                this.f3489t.mo3983c(R.string.text, new StringBuffer().append("Invalid config flags detected. Dropping resources: ").append(stringBuffer).toString());
            }
        }
        this.f3484o = (!m3781n.f3365t || this.f3477h) ? this.f3482m.m3661a(m3781n) : (C0496g) null;
        int i2 = z ? 65535 : -1;
        int i3 = this.f3478i.f3504d + readInt2;
        if (this.f3474e.m3969a() < i3) {
            this.f3489t.mo3982b(R.string.text, new StringBuffer().append(new StringBuffer().append("Skipping: ").append(this.f3474e.m3970a(i3 - this.f3474e.m3969a())).toString()).append(" byte(s) to align with ResTable_entry start.").toString());
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Integer) it.next()).intValue();
            this.f3485p = (this.f3485p & Color.RED) | intValue;
            if (((Integer) linkedHashMap.get(new Integer(intValue))).intValue() == i2) {
                this.f3487r.put(new Integer(this.f3485p), new Integer(readUnsignedByte));
            } else {
                if (this.f3474e.m3969a() == this.f3478i.f3505e) {
                    this.f3489t.mo3983c(R.string.text, String.format("End of chunk hit. Skipping remaining entries (%d) in type: %s", new Integer(readInt - intValue), this.f3483n.m3740a()));
                    break;
                }
                b m3778k = m3778k();
                if (m3778k != null) {
                    m3765a(m3778k);
                } else {
                    this.f3487r.put(new Integer(this.f3485p), new Integer(readUnsignedByte));
                }
            }
        }
        if (this.f3474e.m3969a() < this.f3478i.f3505e) {
            this.f3489t.mo3983c(R.string.text, new StringBuffer().append(new StringBuffer().append("Unknown data detected. Skipping: ").append(this.f3474e.m3970a(this.f3478i.f3505e - this.f3474e.m3969a())).toString()).append(" byte(s)").toString());
        }
        return this.f3484o;
    }

    /* renamed from: k */
    private b m3778k() {
        C0489u m3780m;
        int i;
        int readUnsignedShort = this.f3474e.readUnsignedShort();
        short readShort = this.f3474e.readShort();
        boolean z = (readShort & 1) != 0;
        boolean z2 = (readShort & 8) != 0;
        int readInt = this.f3474e.readInt();
        if (readInt == -1 && !z2) {
            return (b) null;
        }
        if (z2 && !this.f3475f.m3720d()) {
            this.f3475f.m3719d(true);
        }
        if (z2) {
            m3780m = m3759a((byte) ((readShort >> 8) & 255), readInt);
            i = readUnsignedShort;
        } else if (z) {
            if (this.f3482m.m3678g() == 23 && "bin.mt.plus.TranslationData".equals(this.f3482m.m3679h())) {
                this.f3474e.readInt();
                int readInt2 = this.f3474e.readInt();
                for (int i2 = 0; i2 < readInt2; i2++) {
                    this.f3474e.readInt();
                    m3780m();
                }
                return (b) null;
            }
            m3780m = m3779l();
            i = readInt;
        } else {
            m3780m = m3780m();
            i = readInt;
        }
        if (m3780m == null) {
            return (b) null;
        }
        b bVar = new b(this);
        bVar.f3494a = readShort;
        bVar.f3495b = i;
        bVar.f3496c = m3780m;
        return bVar;
    }

    /* renamed from: a */
    private void m3765a(b bVar) {
        C0493d c0493d;
        int i = bVar.f3495b;
        C0489u c0489u = bVar.f3496c;
        C0489u c0487s = (this.f3483n.m3745c() && (c0489u instanceof C0477i)) ? new C0487s(c0489u.toString(), ((C0477i) c0489u).m3642d()) : c0489u;
        if (this.f3484o != null) {
            C0491b c0491b = new C0491b(this.f3485p);
            if (this.f3482m.m3667a(c0491b)) {
                c0493d = this.f3482m.m3669b(c0491b);
                if (c0493d.m3696h()) {
                    m3763a(c0493d);
                    c0493d = new C0493d(c0491b, this.f3481l.m3849a(i), bVar.f3494a, this.f3482m, f3471d, this.f3483n, this.f3473c, this.f3489t);
                    this.f3482m.m3672b(c0493d);
                    this.f3483n.m3743b(c0493d);
                }
            } else {
                c0493d = new C0493d(c0491b, this.f3481l.m3849a(i), bVar.f3494a, this.f3482m, f3471d, this.f3483n, this.f3473c, this.f3489t);
                this.f3482m.m3672b(c0493d);
                this.f3483n.m3743b(c0493d);
            }
            C0494e c0494e = new C0494e(this.f3484o, c0493d, c0487s);
            try {
                this.f3484o.m3737a(c0494e);
                c0493d.m3686a(c0494e);
            } catch (C0461b e2) {
                if (this.f3477h) {
                    this.f3484o.m3738a(c0494e, true);
                    c0493d.m3687a(c0494e, true);
                    this.f3489t.mo3983c(R.string.text, String.format("Duplicate Resource Detected. Ignoring duplicate: %s", c0494e.toString()));
                } else {
                    throw e2;
                }
            }
            this.f3482m.m3664a(c0494e);
        }
    }

    /* renamed from: l */
    private C0471c m3779l() {
        int readInt = this.f3474e.readInt();
        int readInt2 = this.f3474e.readInt();
        C0490v m3680i = this.f3482m.m3680i();
        C0538c<Integer, AbstractC0486r>[] c0538cArr = new C0538c[readInt2];
        for (int i = 0; i < readInt2; i++) {
            int readInt3 = this.f3474e.readInt();
            C0482n m3780m = m3780m();
            if (m3780m != null) {
                c0538cArr[i] = new C0538c<>(new Integer(readInt3), (AbstractC0486r) (!(m3780m instanceof AbstractC0486r) ? new C0487s(m3780m.toString(), m3780m.m3642d()) : m3780m));
            }
        }
        return m3680i.m3656a(readInt, c0538cArr, this.f3483n);
    }

    /* renamed from: a */
    private C0482n m3759a(byte b2, int i) {
        return b2 == 3 ? this.f3482m.m3680i().m3657a(this.f3479j.m3850a(i, this.f3489t), i, f3470b) : this.f3482m.m3680i().m3660a(b2, i, (String) null);
    }

    /* renamed from: m */
    private C0482n m3780m() {
        if (this.f3474e.readShort() < 8) {
            return (C0482n) null;
        }
        this.f3474e.m3973a((byte) 0);
        byte readByte = this.f3474e.readByte();
        int readInt = this.f3474e.readInt();
        return readByte == 3 ? this.f3482m.m3680i().m3657a(this.f3479j.m3850a(readInt, this.f3489t), readInt, f3470b) : this.f3482m.m3680i().m3660a(readByte, readInt, (String) null);
    }

    /* renamed from: n */
    private C0468a m3781n() {
        int i;
        char[] cArr;
        int i2;
        int i3;
        int readInt = this.f3474e.readInt();
        int i4 = 8;
        if (readInt < 8) {
            throw new C0461b("Config size < 8");
        }
        boolean z = false;
        short readShort = this.f3474e.readShort();
        short readShort2 = this.f3474e.readShort();
        char[] cArr2 = new char[0];
        char[] cArr3 = new char[0];
        if (readInt >= 12) {
            cArr2 = m3766a(this.f3474e.readByte(), this.f3474e.readByte(), 'a');
            cArr3 = m3766a(this.f3474e.readByte(), this.f3474e.readByte(), '0');
            i4 = 12;
        }
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        if (readInt >= 14) {
            b2 = this.f3474e.readByte();
            b3 = this.f3474e.readByte();
            i4 = 14;
        }
        int i5 = 0;
        if (readInt >= 16) {
            i5 = this.f3474e.readUnsignedShort();
            i4 = 16;
        }
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        if (readInt >= 20) {
            b4 = this.f3474e.readByte();
            b5 = this.f3474e.readByte();
            b6 = this.f3474e.readByte();
            b7 = this.f3474e.readByte();
            i4 = 20;
        }
        short s = (short) 0;
        short s2 = (short) 0;
        short s3 = (short) 0;
        if (readInt >= 28) {
            s = this.f3474e.readShort();
            s2 = this.f3474e.readShort();
            s3 = this.f3474e.readShort();
            this.f3474e.skipBytes(2);
            i4 = 28;
        }
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        short s4 = (short) 0;
        if (readInt >= 32) {
            b8 = this.f3474e.readByte();
            b9 = this.f3474e.readByte();
            s4 = this.f3474e.readShort();
            i4 = 32;
        }
        short s5 = (short) 0;
        short s6 = (short) 0;
        if (readInt >= 36) {
            s5 = this.f3474e.readShort();
            s6 = this.f3474e.readShort();
            i = 36;
        } else {
            i = i4;
        }
        char[] cArr4 = (char[]) null;
        char[] cArr5 = (char[]) null;
        if (readInt >= 48) {
            cArr = m3762a(4).toCharArray();
            cArr5 = m3762a(8).toCharArray();
            i2 = 48;
        } else {
            cArr = cArr4;
            i2 = i;
        }
        byte b10 = (byte) 0;
        byte b11 = (byte) 0;
        if (readInt >= 52) {
            b10 = this.f3474e.readByte();
            b11 = this.f3474e.readByte();
            this.f3474e.skipBytes(2);
            i3 = 52;
        } else {
            i3 = i2;
        }
        if (readInt >= 56) {
            this.f3474e.skipBytes(4);
            i3 = 56;
        }
        char[] cArr6 = (char[]) null;
        int i6 = readInt - 56;
        if (i6 > 0 && i3 < readInt) {
            byte[] bArr = new byte[i6];
            i3 += i6;
            this.f3474e.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                this.f3489t.mo3982b(R.string.text, String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", new Integer(56)));
            } else {
                this.f3489t.mo3983c(R.string.text, String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", new Integer(56), new Integer(readInt), bigInteger));
                z = true;
            }
        }
        int i7 = readInt - i3;
        if (i7 > 0) {
            this.f3474e.skipBytes(i7);
        }
        return new C0468a(readShort, readShort2, cArr2, cArr3, b2, b3, i5, b4, b5, b6, b7, s, s2, s3, b8, b9, s4, s5, s6, cArr, cArr5, b10, b11, cArr6, z, readInt, this.f3489t);
    }

    /* renamed from: a */
    private char[] m3766a(byte b2, byte b3, char c2) {
        return ((b2 >> 7) & 1) == 1 ? new char[]{(char) ((b3 & 31) + c2), (char) (((b2 & 3) << 3) + ((b3 & 224) >> 5) + c2), (char) (((b2 & ObjectStreamConstants.TC_LONGSTRING) >> 2) + c2)} : new char[]{(char) b2, (char) b3};
    }

    /* renamed from: a */
    private String m3762a(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i != 0 && this.f3474e.readByte() != 0) {
                sb.append((char) s);
                i = i2;
            }
        }
        this.f3474e.skipBytes(i2);
        return sb.toString();
    }

    /* renamed from: a */
    private void m3764a(C0497h c0497h) {
        this.f3488s.put(new Integer(c0497h.m3742b()), c0497h);
    }

    /* renamed from: o */
    private void m3782o() {
        C0489u c0485q;
        Iterator<Integer> it = this.f3487r.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            C0491b c0491b = new C0491b(intValue);
            if (this.f3482m.m3678g() == c0491b.f3413a && !this.f3482m.m3667a(c0491b)) {
                C0493d c0493d = new C0493d(c0491b, new StringBuffer().append("APKTOOL_DUMMY_").append(Integer.toHexString(intValue)).toString(), 2, this.f3482m, f3471d, this.f3488s.get(this.f3487r.get(new Integer(intValue))), this.f3473c, this.f3489t);
                this.f3482m.m3672b(c0493d);
                c0493d.m3695g().m3743b(c0493d);
                C0496g m3661a = this.f3482m.m3661a(new C0468a(this.f3489t));
                if (f3470b.m3610c()) {
                    c0485q = new C0472d(false, 0, (String) null);
                } else {
                    c0485q = new C0485q(this.f3482m, 0, "");
                }
                C0494e c0494e = new C0494e(m3661a, c0493d, c0485q);
                m3661a.m3737a(c0494e);
                c0493d.m3686a(c0494e);
            }
        }
    }

    /* renamed from: a */
    private void m3763a(C0493d c0493d) {
        if (this.f3482m.m3667a(c0493d.m3692d())) {
            this.f3482m.m3663a(c0493d);
            this.f3483n.m3741a(c0493d);
        }
    }

    /* renamed from: p */
    private d m3783p() {
        d m3788a = d.m3788a(this.f3474e, this.f3489t);
        this.f3478i = m3788a;
        return m3788a;
    }

    /* renamed from: b */
    private void m3767b(int i) {
        if (this.f3478i.f3501a != i) {
            throw new C0461b(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", new Integer(i), new Short(this.f3478i.f3501a)));
        }
    }

    /* renamed from: c */
    private void m3770c(int i) {
        m3783p();
        m3767b(i);
    }

    /* compiled from: ARSCDecoder.java */
    /* renamed from: b.a.c.b.a$d */
    public static class d {

        /* renamed from: f */
        private static InterfaceC0541f f3500f;

        /* renamed from: a */
        public final short f3501a;

        /* renamed from: b */
        public final int f3502b;

        /* renamed from: c */
        public final int f3503c;

        /* renamed from: d */
        public final int f3504d;

        /* renamed from: e */
        public final int f3505e;

        public d(short s, int i, int i2, int i3, InterfaceC0541f interfaceC0541f) {
            this.f3501a = s;
            this.f3502b = i;
            this.f3503c = i2;
            this.f3504d = i3;
            this.f3505e = i3 + i2;
            f3500f = interfaceC0541f;
        }

        /* renamed from: a */
        public static d m3788a(C0539d c0539d, InterfaceC0541f interfaceC0541f) {
            int m3969a = c0539d.m3969a();
            try {
                return new d(c0539d.readShort(), c0539d.readShort(), c0539d.readInt(), m3969a, interfaceC0541f);
            } catch (EOFException e2) {
                return new d((short) -1, 0, 0, c0539d.m3969a(), interfaceC0541f);
            }
        }

        /* renamed from: a */
        public void m3789a(C0539d c0539d) {
            int m3969a = c0539d.m3969a() - this.f3504d;
            int i = this.f3502b - m3969a;
            if (i > 0) {
                byte[] bArr = new byte[i];
                c0539d.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f3500f.mo3982b(R.string.text, String.format("Chunk header size (%d), read (%d), but exceeding bytes are all zero.", new Integer(this.f3502b), new Integer(m3969a)));
                } else {
                    f3500f.mo3983c(R.string.text, String.format("Chunk header size (%d), read (%d). Exceeding bytes: 0x%X.", new Integer(this.f3502b), new Integer(m3969a), bigInteger));
                }
            }
        }
    }

    /* compiled from: ARSCDecoder.java */
    /* renamed from: b.a.c.b.a$c */
    public static class c {

        /* renamed from: a */
        public final int f3498a;

        /* renamed from: b */
        public final int f3499b;

        public c(int i, int i2) {
            this.f3498a = i;
            this.f3499b = i2;
        }
    }

    /* compiled from: ARSCDecoder.java */
    /* renamed from: b.a.c.b.a$b */
    private class b {

        /* renamed from: a */
        public short f3494a;

        /* renamed from: b */
        public int f3495b;

        /* renamed from: c */
        public C0489u f3496c;

        /* renamed from: d */
        private final C0501a f3497d;

        public b(C0501a c0501a) {
            this.f3497d = c0501a;
        }
    }

    /* compiled from: ARSCDecoder.java */
    /* renamed from: b.a.c.b.a$a */
    public static class a {

        /* renamed from: a */
        private final InterfaceC0541f f3490a;

        /* renamed from: b */
        private final C0492c[] f3491b;

        /* renamed from: c */
        private final c[] f3492c;

        /* renamed from: d */
        private final C0495f f3493d;

        public a(C0492c[] c0492cArr, c[] cVarArr, C0495f c0495f, InterfaceC0541f interfaceC0541f) {
            this.f3491b = c0492cArr;
            this.f3492c = cVarArr;
            this.f3493d = c0495f;
            this.f3490a = interfaceC0541f;
        }

        /* renamed from: a */
        public c[] m3784a() {
            return this.f3492c;
        }

        /* renamed from: b */
        public C0492c[] m3785b() {
            return this.f3491b;
        }

        /* renamed from: c */
        public C0492c m3786c() {
            if (this.f3491b.length <= 0) {
                throw new C0461b("Arsc file contains zero packages");
            }
            if (this.f3491b.length == 1) {
                return this.f3491b[0];
            }
            int m3787d = m3787d();
            this.f3490a.mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Arsc file contains multiple packages. Using package ").append(this.f3491b[m3787d].m3679h()).toString()).append(" as default.").toString());
            return this.f3491b[m3787d];
        }

        /* renamed from: d */
        public int m3787d() {
            int i = 0;
            int m3673c = this.f3491b[0].m3673c();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.f3491b.length) {
                    if (this.f3491b[i2].m3673c() >= m3673c) {
                        m3673c = this.f3491b[i2].m3673c();
                        i = i2;
                    } else {
                        i = i3;
                    }
                    i2++;
                } else {
                    return i3;
                }
            }
        }
    }
}
