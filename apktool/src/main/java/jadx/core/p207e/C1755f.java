package jadx.core.p207e;

import android.app.slice.Slice;
import android.provider.Telephony;
import jadx.core.p207e.p208a.C1747a;
import jadx.core.p207e.p208a.C1748b;
import jadx.core.p207e.p208a.C1749c;
import jadx.core.p207e.p208a.C1750d;
import java.io.InputStream;
import java.util.ArrayList;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ResTableParser.java */
/* renamed from: jadx.core.e.f */
/* loaded from: classes.dex */
public class C1755f extends C1751b {

    /* renamed from: n */
    private static final InterfaceC2558b f10653n = C2568c.m15995a((Class<?>) C1755f.class);

    /* renamed from: o */
    private String[] f10654o;

    /* renamed from: p */
    private final C1756g f10655p = new C1756g();

    /* compiled from: ResTableParser.java */
    /* renamed from: jadx.core.e.f$a */
    private static final class a {

        /* renamed from: a */
        private final int f10656a;

        /* renamed from: b */
        private final String f10657b;

        /* renamed from: c */
        private final String[] f10658c;

        /* renamed from: d */
        private final String[] f10659d;

        private a(int i, String str, String[] strArr, String[] strArr2) {
            this.f10656a = i;
            this.f10657b = str;
            this.f10658c = strArr;
            this.f10659d = strArr2;
        }

        /* synthetic */ a(int i, String str, String[] strArr, String[] strArr2, a aVar) {
            this(i, str, strArr, strArr2);
        }

        /* renamed from: a */
        public int m13376a() {
            return this.f10656a;
        }

        /* renamed from: b */
        public String m13377b() {
            return this.f10657b;
        }

        /* renamed from: c */
        public String[] m13378c() {
            return this.f10658c;
        }

        /* renamed from: d */
        public String[] m13379d() {
            return this.f10659d;
        }
    }

    /* renamed from: a */
    public void m13373a(InputStream inputStream) {
        this.f10631a = new C1753d(inputStream);
        m13375d();
        this.f10655p.m13383b();
    }

    /* renamed from: c */
    public C1756g m13374c() {
        return this.f10655p;
    }

    /* renamed from: d */
    void m13375d() {
        this.f10631a.m13354b(2, "Not a table chunk");
        this.f10631a.m13354b(12, "Unexpected table header size");
        this.f10631a.m13359d();
        int m13359d = this.f10631a.m13359d();
        this.f10654o = m13344a();
        for (int i = 0; i < m13359d; i++) {
            m13367e();
        }
    }

    /* renamed from: e */
    private a m13367e() {
        long m13348a = this.f10631a.m13348a();
        this.f10631a.m13354b(512, "Not a table chunk");
        int m13357c = this.f10631a.m13357c();
        if (m13357c != 284 && m13357c != 288) {
            m13343a("Unexpected package header size");
        }
        long m13360e = m13348a + this.f10631a.m13360e();
        int m13359d = this.f10631a.m13359d();
        String m13349a = this.f10631a.m13349a(128);
        long m13359d2 = this.f10631a.m13359d() + m13348a;
        this.f10631a.m13359d();
        long m13359d3 = this.f10631a.m13359d() + m13348a;
        this.f10631a.m13359d();
        if (m13357c == 288) {
            this.f10631a.m13359d();
        }
        String[] strArr = null;
        if (m13359d2 != 0) {
            this.f10631a.m13355b(m13359d2, "Expected typeStrings string pool");
            strArr = m13344a();
        }
        String[] strArr2 = null;
        if (m13359d3 != 0) {
            this.f10631a.m13355b(m13359d3, "Expected keyStrings string pool");
            strArr2 = m13344a();
        }
        a aVar = new a(m13359d, m13349a, strArr, strArr2, null);
        this.f10655p.m13382a(m13349a);
        while (this.f10631a.m13348a() < m13360e) {
            long m13348a2 = this.f10631a.m13348a();
            int m13357c2 = this.f10631a.m13357c();
            if (m13357c2 != 0) {
                if (m13357c2 == 514) {
                    m13368f();
                } else if (m13357c2 == 513) {
                    m13363a(m13348a2, aVar);
                }
            }
        }
        return aVar;
    }

    /* renamed from: f */
    private void m13368f() {
        this.f10631a.m13354b(16, "Unexpected type spec header size");
        this.f10631a.m13359d();
        this.f10631a.m13353b();
        this.f10631a.m13351a(3L);
        int m13359d = this.f10631a.m13359d();
        for (int i = 0; i < m13359d; i++) {
            this.f10631a.m13359d();
        }
    }

    /* renamed from: a */
    private void m13363a(long j, a aVar) {
        this.f10631a.m13357c();
        this.f10631a.m13359d();
        int m13353b = this.f10631a.m13353b();
        this.f10631a.m13350a(0, "type chunk, res0");
        this.f10631a.m13354b(0, "type chunk, res1");
        int m13359d = this.f10631a.m13359d();
        long m13359d2 = this.f10631a.m13359d() + j;
        C1747a m13371i = m13371i();
        int[] iArr = new int[m13359d];
        for (int i = 0; i < m13359d; i++) {
            iArr[i] = this.f10631a.m13359d();
        }
        this.f10631a.m13352a(m13359d2, "Expected entry start");
        for (int i2 = 0; i2 < m13359d; i2++) {
            if (iArr[i2] != -1) {
                m13364a(aVar, m13353b, i2, m13371i);
            }
        }
    }

    /* renamed from: a */
    private void m13364a(a aVar, int i, int i2, C1747a c1747a) {
        this.f10631a.m13357c();
        int m13357c = this.f10631a.m13357c();
        C1750d c1750d = new C1750d((aVar.m13376a() << 24) | (i << 16) | i2, aVar.m13377b(), aVar.m13378c()[i - 1], aVar.m13379d()[this.f10631a.m13359d()]);
        c1750d.m13334a(c1747a);
        if ((m13357c & 1) == 0) {
            c1750d.m13335a(m13370h());
        } else {
            c1750d.m13333a(this.f10631a.m13359d());
            int m13359d = this.f10631a.m13359d();
            ArrayList arrayList = new ArrayList(m13359d);
            for (int i3 = 0; i3 < m13359d; i3++) {
                arrayList.add(m13369g());
            }
            c1750d.m13336a(arrayList);
        }
        this.f10655p.m13381a(c1750d);
    }

    /* renamed from: g */
    private C1748b m13369g() {
        return new C1748b(this.f10631a.m13359d(), m13370h());
    }

    /* renamed from: h */
    private C1749c m13370h() {
        this.f10631a.m13354b(8, "value size");
        this.f10631a.m13350a(0, "value res0 not 0");
        return new C1749c(this.f10631a.m13353b(), this.f10631a.m13359d());
    }

    /* renamed from: i */
    private C1747a m13371i() {
        long m13348a = this.f10631a.m13348a();
        int m13359d = this.f10631a.m13359d();
        C1747a c1747a = new C1747a();
        this.f10631a.m13357c();
        this.f10631a.m13357c();
        c1747a.m13322a(m13372j());
        c1747a.m13323b(m13372j());
        int m13353b = this.f10631a.m13353b();
        this.f10631a.m13353b();
        int m13357c = this.f10631a.m13357c();
        if (m13357c != 0) {
            c1747a.m13324c(m13366c(m13357c));
        }
        this.f10631a.m13353b();
        this.f10631a.m13353b();
        this.f10631a.m13353b();
        this.f10631a.m13353b();
        int m13357c2 = this.f10631a.m13357c();
        int m13357c3 = this.f10631a.m13357c();
        if (m13357c2 != 0 && m13357c3 != 0) {
            c1747a.m13325d(String.valueOf(m13357c2) + "x" + m13357c3);
        }
        int m13357c4 = this.f10631a.m13357c();
        if (m13357c4 != 0) {
            c1747a.m13326e("v" + m13357c4);
        }
        this.f10631a.m13357c();
        int m13353b2 = this.f10631a.m13353b();
        this.f10631a.m13353b();
        int m13357c5 = this.f10631a.m13357c();
        int m13357c6 = this.f10631a.m13357c();
        int m13357c7 = this.f10631a.m13357c();
        if (m13353b2 != 0) {
            c1747a.m13327f(m13365b(m13353b2));
        }
        if (m13357c5 != 0) {
            c1747a.m13328g("sw" + m13357c5 + "dp");
        }
        if (m13353b != 0) {
            c1747a.m13329h(m13362a(m13353b));
        }
        if (m13357c6 != 0) {
            c1747a.m13330i("w" + m13357c6 + "dp");
        }
        if (m13357c7 != 0) {
            c1747a.m13331j("h" + m13357c7 + "dp");
        }
        this.f10631a.m13355b(m13348a + m13359d, "Skip config parsing");
        return c1747a;
    }

    /* renamed from: a */
    private String m13362a(int i) {
        if (i == 1) {
            return Telephony.Carriers.PORT;
        }
        if (i == 2) {
            return "land";
        }
        return "o" + i;
    }

    /* renamed from: b */
    private String m13365b(int i) {
        switch (i) {
            case 1:
                return "small";
            case 2:
                return "normal";
            case 3:
                return Slice.HINT_LARGE;
            case 4:
                return "xlarge";
            case 64:
                return "ldltr";
            case 128:
                return "ldrtl";
            default:
                return "sl" + i;
        }
    }

    /* renamed from: c */
    private String m13366c(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i == 480) {
            return "xxhdpi";
        }
        if (i == 640) {
            return "xxxhdpi";
        }
        return String.valueOf(i) + "dpi";
    }

    /* renamed from: j */
    private String m13372j() {
        int m13353b = this.f10631a.m13353b();
        int m13353b2 = this.f10631a.m13353b();
        if (m13353b == 0 || m13353b2 == 0) {
            return null;
        }
        if ((m13353b & 128) == 0) {
            return new String(new char[]{(char) m13353b, (char) m13353b2});
        }
        f10653n.mo15937b("TODO: parse locale: 0x{}{}", Integer.toHexString(m13353b), Integer.toHexString(m13353b2));
        return null;
    }
}
