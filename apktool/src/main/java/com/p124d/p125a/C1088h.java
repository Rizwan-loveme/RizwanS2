package com.p124d.p125a;

import android.app.slice.SliceItem;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.wifi.WifiConfiguration;
import com.p124d.p125a.C1082b;
import java.p209io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: SVG.java */
/* renamed from: com.d.a.h */
/* loaded from: classes.dex */
public class C1088h {

    /* renamed from: a */
    private static C1090j f7017a = null;

    /* renamed from: b */
    private static boolean f7018b = true;

    /* renamed from: c */
    private ae f7019c = null;

    /* renamed from: d */
    private String f7020d = "";

    /* renamed from: e */
    private String f7021e = "";

    /* renamed from: f */
    private float f7022f = 96.0f;

    /* renamed from: g */
    private C1082b.q f7023g = new C1082b.q();

    /* renamed from: h */
    private Map<String, ak> f7024h = new HashMap();

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$af */
    interface af {
        /* renamed from: a */
        void mo9099a(String str);

        /* renamed from: a */
        void mo9100a(Set<String> set);

        /* renamed from: b */
        void mo9101b(Set<String> set);

        /* renamed from: c */
        Set<String> mo9102c();

        /* renamed from: c */
        void mo9103c(Set<String> set);

        /* renamed from: d */
        String mo9104d();

        /* renamed from: d */
        void mo9105d(Set<String> set);

        /* renamed from: e */
        Set<String> mo9106e();

        /* renamed from: f */
        Set<String> mo9107f();

        /* renamed from: g */
        Set<String> mo9108g();
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ai */
    interface ai {
        /* renamed from: a */
        void mo9095a(am amVar);

        /* renamed from: b */
        List<am> mo9096b();
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$aw */
    interface aw {
        /* renamed from: h */
        ba mo9110h();
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ba */
    interface ba {
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$bc */
    enum bc {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$j */
    enum j {
        pad,
        reflect,
        repeat
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$m */
    interface m {
        /* renamed from: a */
        void mo9112a(Matrix matrix);
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$s */
    interface s {
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$w */
    interface w {
        /* renamed from: a */
        void mo9125a(float f2, float f3);

        /* renamed from: a */
        void mo9126a(float f2, float f3, float f4, float f5);

        /* renamed from: a */
        void mo9127a(float f2, float f3, float f4, float f5, float f6, float f7);

        /* renamed from: a */
        void mo9128a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);

        /* renamed from: b */
        void mo9131b();

        /* renamed from: b */
        void mo9132b(float f2, float f3);
    }

    C1088h() {
    }

    /* renamed from: a */
    public static C1088h m9073a(String str) {
        return new C1092l().m9369a(new ByteArrayInputStream(str.getBytes()), f7018b);
    }

    /* renamed from: a */
    public void m9078a(Canvas canvas) {
        m9079a(canvas, (C1087g) null);
    }

    /* renamed from: a */
    public void m9079a(Canvas canvas, C1087g c1087g) {
        if (c1087g == null) {
            c1087g = new C1087g();
        }
        if (!c1087g.m9070e()) {
            c1087g.m9065a(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new C1089i(canvas, this.f7022f).m9241a(this, c1087g);
    }

    /* renamed from: a */
    public void m9077a(float f2) {
        if (this.f7019c == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.f7019c.f7113c = new o(f2);
    }

    /* renamed from: b */
    public void m9084b(float f2) {
        if (this.f7019c == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.f7019c.f7114d = new o(f2);
    }

    /* renamed from: a */
    ae m9076a() {
        return this.f7019c;
    }

    /* renamed from: a */
    void m9081a(ae aeVar) {
        this.f7019c = aeVar;
    }

    /* renamed from: b */
    am m9082b(String str) {
        if (str == null) {
            return null;
        }
        String m9075f = m9075f(str);
        if (m9075f.length() <= 1 || !m9075f.startsWith("#")) {
            return null;
        }
        return m9089e(m9075f.substring(1));
    }

    /* renamed from: f */
    private String m9075f(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    /* renamed from: a */
    void m9080a(C1082b.q qVar) {
        this.f7023g.m9041a(qVar);
    }

    /* renamed from: b */
    List<C1082b.o> m9083b() {
        return this.f7023g.m9039a();
    }

    /* renamed from: c */
    boolean m9086c() {
        return !this.f7023g.m9043b();
    }

    /* renamed from: d */
    void m9087d() {
        this.f7023g.m9042a(C1082b.t.RenderOptions);
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$a */
    static class a {

        /* renamed from: a */
        float f7026a;

        /* renamed from: b */
        float f7027b;

        /* renamed from: c */
        float f7028c;

        /* renamed from: d */
        float f7029d;

        a(float f2, float f3, float f4, float f5) {
            this.f7026a = f2;
            this.f7027b = f3;
            this.f7028c = f4;
            this.f7029d = f5;
        }

        a(a aVar) {
            this.f7026a = aVar.f7026a;
            this.f7027b = aVar.f7027b;
            this.f7028c = aVar.f7028c;
            this.f7029d = aVar.f7029d;
        }

        /* renamed from: a */
        static a m9090a(float f2, float f3, float f4, float f5) {
            return new a(f2, f3, f4 - f2, f5 - f3);
        }

        /* renamed from: a */
        float m9091a() {
            return this.f7026a + this.f7028c;
        }

        /* renamed from: b */
        float m9093b() {
            return this.f7027b + this.f7029d;
        }

        /* renamed from: a */
        void m9092a(a aVar) {
            if (aVar.f7026a < this.f7026a) {
                this.f7026a = aVar.f7026a;
            }
            if (aVar.f7027b < this.f7027b) {
                this.f7027b = aVar.f7027b;
            }
            if (aVar.m9091a() > m9091a()) {
                this.f7028c = aVar.m9091a() - this.f7026a;
            }
            if (aVar.m9093b() > m9093b()) {
                this.f7029d = aVar.m9093b() - this.f7027b;
            }
        }

        public String toString() {
            return "[" + this.f7026a + " " + this.f7027b + " " + this.f7028c + " " + this.f7029d + "]";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ad */
    static class ad implements Cloneable {

        /* renamed from: A */
        Boolean f7037A;

        /* renamed from: B */
        Boolean f7038B;

        /* renamed from: C */
        an f7039C;

        /* renamed from: D */
        Float f7040D;

        /* renamed from: E */
        String f7041E;

        /* renamed from: F */
        a f7042F;

        /* renamed from: G */
        String f7043G;

        /* renamed from: H */
        an f7044H;

        /* renamed from: I */
        Float f7045I;

        /* renamed from: J */
        an f7046J;

        /* renamed from: K */
        Float f7047K;

        /* renamed from: L */
        i f7048L;

        /* renamed from: M */
        e f7049M;

        /* renamed from: a */
        long f7050a = 0;

        /* renamed from: b */
        an f7051b;

        /* renamed from: c */
        a f7052c;

        /* renamed from: d */
        Float f7053d;

        /* renamed from: e */
        an f7054e;

        /* renamed from: f */
        Float f7055f;

        /* renamed from: g */
        o f7056g;

        /* renamed from: h */
        c f7057h;

        /* renamed from: i */
        d f7058i;

        /* renamed from: j */
        Float f7059j;

        /* renamed from: k */
        o[] f7060k;

        /* renamed from: l */
        o f7061l;

        /* renamed from: m */
        Float f7062m;

        /* renamed from: n */
        e f7063n;

        /* renamed from: o */
        List<String> f7064o;

        /* renamed from: p */
        o f7065p;

        /* renamed from: q */
        Integer f7066q;

        /* renamed from: r */
        b f7067r;

        /* renamed from: s */
        g f7068s;

        /* renamed from: t */
        h f7069t;

        /* renamed from: u */
        f f7070u;

        /* renamed from: v */
        Boolean f7071v;

        /* renamed from: w */
        b f7072w;

        /* renamed from: x */
        String f7073x;

        /* renamed from: y */
        String f7074y;

        /* renamed from: z */
        String f7075z;

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$a */
        public enum a {
            NonZero,
            EvenOdd
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$b */
        public enum b {
            Normal,
            Italic,
            Oblique
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$c */
        public enum c {
            Butt,
            Round,
            Square
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$d */
        public enum d {
            Miter,
            Round,
            Bevel
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$e */
        public enum e {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$f */
        public enum f {
            Start,
            Middle,
            End
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$g */
        public enum g {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$h */
        public enum h {
            LTR,
            RTL
        }

        /* compiled from: SVG.java */
        /* renamed from: com.d.a.h$ad$i */
        public enum i {
            None,
            NonScalingStroke
        }

        ad() {
        }

        /* renamed from: a */
        static ad m9097a() {
            ad adVar = new ad();
            adVar.f7050a = -1L;
            adVar.f7051b = e.f7182b;
            adVar.f7052c = a.NonZero;
            adVar.f7053d = Float.valueOf(1.0f);
            adVar.f7054e = null;
            adVar.f7055f = Float.valueOf(1.0f);
            adVar.f7056g = new o(1.0f);
            adVar.f7057h = c.Butt;
            adVar.f7058i = d.Miter;
            adVar.f7059j = Float.valueOf(4.0f);
            adVar.f7060k = null;
            adVar.f7061l = new o(0.0f);
            adVar.f7062m = Float.valueOf(1.0f);
            adVar.f7063n = e.f7182b;
            adVar.f7064o = null;
            adVar.f7065p = new o(12.0f, bc.pt);
            adVar.f7066q = 400;
            adVar.f7067r = b.Normal;
            adVar.f7068s = g.None;
            adVar.f7069t = h.LTR;
            adVar.f7070u = f.Start;
            adVar.f7071v = true;
            adVar.f7072w = null;
            adVar.f7073x = null;
            adVar.f7074y = null;
            adVar.f7075z = null;
            adVar.f7037A = Boolean.TRUE;
            adVar.f7038B = Boolean.TRUE;
            adVar.f7039C = e.f7182b;
            adVar.f7040D = Float.valueOf(1.0f);
            adVar.f7041E = null;
            adVar.f7042F = a.NonZero;
            adVar.f7043G = null;
            adVar.f7044H = null;
            adVar.f7045I = Float.valueOf(1.0f);
            adVar.f7046J = null;
            adVar.f7047K = Float.valueOf(1.0f);
            adVar.f7048L = i.None;
            adVar.f7049M = e.auto;
            return adVar;
        }

        /* renamed from: a */
        void m9098a(boolean z) {
            this.f7037A = Boolean.TRUE;
            this.f7071v = z ? Boolean.TRUE : Boolean.FALSE;
            this.f7072w = null;
            this.f7041E = null;
            this.f7062m = Float.valueOf(1.0f);
            this.f7039C = e.f7182b;
            this.f7040D = Float.valueOf(1.0f);
            this.f7043G = null;
            this.f7044H = null;
            this.f7045I = Float.valueOf(1.0f);
            this.f7046J = null;
            this.f7047K = Float.valueOf(1.0f);
            this.f7048L = i.None;
        }

        protected Object clone() {
            ad adVar = (ad) super.clone();
            if (this.f7060k != null) {
                adVar.f7060k = (o[]) this.f7060k.clone();
            }
            return adVar;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$an */
    static abstract class an implements Cloneable {
        an() {
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$e */
    static class e extends an {

        /* renamed from: b */
        static final e f7182b = new e(-16777216);

        /* renamed from: c */
        static final e f7183c = new e(0);

        /* renamed from: a */
        int f7184a;

        e(int i) {
            this.f7184a = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.f7184a));
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$f */
    static class f extends an {

        /* renamed from: a */
        private static f f7185a = new f();

        private f() {
        }

        /* renamed from: a */
        static f m9114a() {
            return f7185a;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$t */
    static class t extends an {

        /* renamed from: a */
        String f7225a;

        /* renamed from: b */
        an f7226b;

        t(String str, an anVar) {
            this.f7225a = str;
            this.f7226b = anVar;
        }

        public String toString() {
            return this.f7225a + " " + this.f7226b;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$o */
    static class o implements Cloneable {

        /* renamed from: a */
        float f7207a;

        /* renamed from: b */
        bc f7208b;

        o(float f2, bc bcVar) {
            this.f7207a = f2;
            this.f7208b = bcVar;
        }

        o(float f2) {
            this.f7207a = f2;
            this.f7208b = bc.px;
        }

        /* renamed from: a */
        float m9115a() {
            return this.f7207a;
        }

        /* renamed from: a */
        float m9117a(C1089i c1089i) {
            switch (this.f7208b) {
                case percent:
                    a m9244d = c1089i.m9244d();
                    if (m9244d != null) {
                        break;
                    } else {
                        break;
                    }
            }
            return this.f7207a;
        }

        /* renamed from: b */
        float m9119b(C1089i c1089i) {
            if (this.f7208b == bc.percent) {
                a m9244d = c1089i.m9244d();
                if (m9244d == null) {
                    return this.f7207a;
                }
                return (m9244d.f7029d * this.f7207a) / 100.0f;
            }
            return m9117a(c1089i);
        }

        /* renamed from: c */
        float m9121c(C1089i c1089i) {
            if (this.f7208b == bc.percent) {
                a m9244d = c1089i.m9244d();
                if (m9244d == null) {
                    return this.f7207a;
                }
                float f2 = m9244d.f7028c;
                if (f2 == m9244d.f7029d) {
                    return (this.f7207a * f2) / 100.0f;
                }
                return (((float) (Math.sqrt((r0 * r0) + (f2 * f2)) / 1.414213562373095d)) * this.f7207a) / 100.0f;
            }
            return m9117a(c1089i);
        }

        /* renamed from: a */
        float m9118a(C1089i c1089i, float f2) {
            return this.f7208b == bc.percent ? (this.f7207a * f2) / 100.0f : m9117a(c1089i);
        }

        /* renamed from: a */
        float m9116a(float f2) {
            switch (this.f7208b) {
            }
            return this.f7207a;
        }

        /* renamed from: b */
        boolean m9120b() {
            return this.f7207a == 0.0f;
        }

        /* renamed from: c */
        boolean m9122c() {
            return this.f7207a < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.f7207a) + this.f7208b;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$b */
    static class b {

        /* renamed from: a */
        o f7157a;

        /* renamed from: b */
        o f7158b;

        /* renamed from: c */
        o f7159c;

        /* renamed from: d */
        o f7160d;

        b(o oVar, o oVar2, o oVar3, o oVar4) {
            this.f7157a = oVar;
            this.f7158b = oVar2;
            this.f7159c = oVar3;
            this.f7160d = oVar4;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$am */
    static class am {

        /* renamed from: u */
        C1088h f7137u;

        /* renamed from: v */
        ai f7138v;

        am() {
        }

        /* renamed from: a */
        String mo9094a() {
            return "";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ak */
    static abstract class ak extends am {

        /* renamed from: p */
        String f7128p = null;

        /* renamed from: q */
        Boolean f7129q = null;

        /* renamed from: r */
        ad f7130r = null;

        /* renamed from: s */
        ad f7131s = null;

        /* renamed from: t */
        List<String> f7132t = null;

        ak() {
        }

        public String toString() {
            return mo9094a();
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$aj */
    static abstract class aj extends ak {

        /* renamed from: o */
        a f7127o = null;

        aj() {
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ah */
    static abstract class ah extends aj implements af {

        /* renamed from: h */
        Set<String> f7122h = null;

        /* renamed from: i */
        String f7123i = null;

        /* renamed from: j */
        Set<String> f7124j = null;

        /* renamed from: k */
        Set<String> f7125k = null;

        /* renamed from: l */
        Set<String> f7126l = null;

        ah() {
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: a */
        public void mo9100a(Set<String> set) {
            this.f7122h = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: c */
        public Set<String> mo9102c() {
            return this.f7122h;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: a */
        public void mo9099a(String str) {
            this.f7123i = str;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: d */
        public String mo9104d() {
            return this.f7123i;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: b */
        public void mo9101b(Set<String> set) {
            this.f7124j = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: e */
        public Set<String> mo9106e() {
            return this.f7124j;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: c */
        public void mo9103c(Set<String> set) {
            this.f7125k = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: f */
        public Set<String> mo9107f() {
            return this.f7125k;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: d */
        public void mo9105d(Set<String> set) {
            this.f7126l = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: g */
        public Set<String> mo9108g() {
            return this.f7126l;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ag */
    static abstract class ag extends aj implements af, ai {

        /* renamed from: i */
        List<am> f7116i = new ArrayList();

        /* renamed from: j */
        Set<String> f7117j = null;

        /* renamed from: k */
        String f7118k = null;

        /* renamed from: l */
        Set<String> f7119l = null;

        /* renamed from: m */
        Set<String> f7120m = null;

        /* renamed from: n */
        Set<String> f7121n = null;

        ag() {
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: b */
        public List<am> mo9096b() {
            return this.f7116i;
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: a */
        public void mo9095a(am amVar) {
            this.f7116i.add(amVar);
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: a */
        public void mo9100a(Set<String> set) {
            this.f7117j = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: c */
        public Set<String> mo9102c() {
            return this.f7117j;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: a */
        public void mo9099a(String str) {
            this.f7118k = str;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: d */
        public String mo9104d() {
            return this.f7118k;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: b */
        public void mo9101b(Set<String> set) {
            this.f7119l = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: e */
        public Set<String> mo9106e() {
            return null;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: c */
        public void mo9103c(Set<String> set) {
            this.f7120m = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: f */
        public Set<String> mo9107f() {
            return this.f7120m;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: d */
        public void mo9105d(Set<String> set) {
            this.f7121n = set;
        }

        @Override // com.p124d.p125a.C1088h.af
        /* renamed from: g */
        public Set<String> mo9108g() {
            return this.f7121n;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ao */
    static abstract class ao extends ag {

        /* renamed from: w */
        C1086f f7139w = null;

        ao() {
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$aq */
    static abstract class aq extends ao {

        /* renamed from: x */
        a f7145x;

        aq() {
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ae */
    static class ae extends aq {

        /* renamed from: a */
        o f7111a;

        /* renamed from: b */
        o f7112b;

        /* renamed from: c */
        o f7113c;

        /* renamed from: d */
        o f7114d;

        /* renamed from: e */
        public String f7115e;

        ae() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "svg";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$l */
    static class l extends ag implements m {

        /* renamed from: b */
        Matrix f7200b;

        l() {
        }

        @Override // com.p124d.p125a.C1088h.m
        /* renamed from: a */
        public void mo9112a(Matrix matrix) {
            this.f7200b = matrix;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return WifiConfiguration.GroupCipher.varName;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$g */
    static class g extends l implements s {
        g() {
        }

        @Override // com.p124d.p125a.C1088h.l, com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "defs";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$k */
    static abstract class k extends ah implements m {

        /* renamed from: e */
        Matrix f7199e;

        k() {
        }

        @Override // com.p124d.p125a.C1088h.m
        /* renamed from: a */
        public void mo9112a(Matrix matrix) {
            this.f7199e = matrix;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$bd */
    static class bd extends l {

        /* renamed from: a */
        String f7173a;

        /* renamed from: c */
        o f7174c;

        /* renamed from: d */
        o f7175d;

        /* renamed from: e */
        o f7176e;

        /* renamed from: f */
        o f7177f;

        bd() {
        }

        @Override // com.p124d.p125a.C1088h.l, com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "use";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$u */
    static class u extends k {

        /* renamed from: a */
        v f7227a;

        /* renamed from: b */
        Float f7228b;

        u() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "path";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$aa */
    static class aa extends k {

        /* renamed from: a */
        o f7030a;

        /* renamed from: b */
        o f7031b;

        /* renamed from: c */
        o f7032c;

        /* renamed from: d */
        o f7033d;

        /* renamed from: f */
        o f7034f;

        /* renamed from: g */
        o f7035g;

        aa() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "rect";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$c */
    static class c extends k {

        /* renamed from: a */
        o f7178a;

        /* renamed from: b */
        o f7179b;

        /* renamed from: c */
        o f7180c;

        c() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "circle";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$h */
    static class h extends k {

        /* renamed from: a */
        o f7186a;

        /* renamed from: b */
        o f7187b;

        /* renamed from: c */
        o f7188c;

        /* renamed from: d */
        o f7189d;

        h() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "ellipse";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$p */
    static class p extends k {

        /* renamed from: a */
        o f7209a;

        /* renamed from: b */
        o f7210b;

        /* renamed from: c */
        o f7211c;

        /* renamed from: d */
        o f7212d;

        p() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "line";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$y */
    static class y extends k {

        /* renamed from: a */
        float[] f7241a;

        y() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "polyline";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$z */
    static class z extends y {
        z() {
        }

        @Override // com.p124d.p125a.C1088h.y, com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "polygon";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ax */
    static abstract class ax extends ag {
        ax() {
        }

        @Override // com.p124d.p125a.C1088h.ag, com.p124d.p125a.C1088h.ai
        /* renamed from: a */
        public void mo9095a(am amVar) {
            if (amVar instanceof aw) {
                this.f7116i.add(amVar);
                return;
            }
            throw new C1091k("Text content elements cannot contain " + amVar + " elements.");
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$az */
    static abstract class az extends ax {

        /* renamed from: b */
        List<o> f7153b;

        /* renamed from: c */
        List<o> f7154c;

        /* renamed from: d */
        List<o> f7155d;

        /* renamed from: e */
        List<o> f7156e;

        az() {
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$av */
    static class av extends az implements ba, m {

        /* renamed from: a */
        Matrix f7149a;

        av() {
        }

        @Override // com.p124d.p125a.C1088h.m
        /* renamed from: a */
        public void mo9112a(Matrix matrix) {
            this.f7149a = matrix;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "text";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$au */
    static class au extends az implements aw {

        /* renamed from: a */
        private ba f7148a;

        au() {
        }

        /* renamed from: a */
        public void m9111a(ba baVar) {
            this.f7148a = baVar;
        }

        @Override // com.p124d.p125a.C1088h.aw
        /* renamed from: h */
        public ba mo9110h() {
            return this.f7148a;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "tspan";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$bb */
    static class bb extends am implements aw {

        /* renamed from: a */
        String f7161a;

        /* renamed from: b */
        private ba f7162b;

        bb(String str) {
            this.f7161a = str;
        }

        public String toString() {
            return "TextChild: '" + this.f7161a + "'";
        }

        @Override // com.p124d.p125a.C1088h.aw
        /* renamed from: h */
        public ba mo9110h() {
            return this.f7162b;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$at */
    static class at extends ax implements aw {

        /* renamed from: a */
        String f7146a;

        /* renamed from: b */
        private ba f7147b;

        at() {
        }

        /* renamed from: a */
        public void m9109a(ba baVar) {
            this.f7147b = baVar;
        }

        @Override // com.p124d.p125a.C1088h.aw
        /* renamed from: h */
        public ba mo9110h() {
            return this.f7147b;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "tref";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ay */
    static class ay extends ax implements aw {

        /* renamed from: a */
        String f7150a;

        /* renamed from: b */
        o f7151b;

        /* renamed from: c */
        private ba f7152c;

        ay() {
        }

        /* renamed from: a */
        public void m9113a(ba baVar) {
            this.f7152c = baVar;
        }

        @Override // com.p124d.p125a.C1088h.aw
        /* renamed from: h */
        public ba mo9110h() {
            return this.f7152c;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "textPath";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ar */
    static class ar extends l {
        ar() {
        }

        @Override // com.p124d.p125a.C1088h.l, com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "switch";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$as */
    static class as extends aq implements s {
        as() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "symbol";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$q */
    static class q extends aq implements s {

        /* renamed from: a */
        boolean f7213a;

        /* renamed from: b */
        o f7214b;

        /* renamed from: c */
        o f7215c;

        /* renamed from: d */
        o f7216d;

        /* renamed from: e */
        o f7217e;

        /* renamed from: f */
        Float f7218f;

        q() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "marker";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$i */
    static abstract class i extends ak implements ai {

        /* renamed from: a */
        List<am> f7190a = new ArrayList();

        /* renamed from: b */
        Boolean f7191b;

        /* renamed from: c */
        Matrix f7192c;

        /* renamed from: d */
        j f7193d;

        /* renamed from: e */
        String f7194e;

        i() {
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: b */
        public List<am> mo9096b() {
            return this.f7190a;
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: a */
        public void mo9095a(am amVar) {
            if (amVar instanceof ac) {
                this.f7190a.add(amVar);
                return;
            }
            throw new C1091k("Gradient elements cannot contain " + amVar + " elements.");
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ac */
    static class ac extends ak implements ai {

        /* renamed from: a */
        Float f7036a;

        ac() {
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: b */
        public List<am> mo9096b() {
            return Collections.emptyList();
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: a */
        public void mo9095a(am amVar) {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "stop";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$al */
    static class al extends i {

        /* renamed from: f */
        o f7133f;

        /* renamed from: g */
        o f7134g;

        /* renamed from: h */
        o f7135h;

        /* renamed from: i */
        o f7136i;

        al() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "linearGradient";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ap */
    static class ap extends i {

        /* renamed from: f */
        o f7140f;

        /* renamed from: g */
        o f7141g;

        /* renamed from: h */
        o f7142h;

        /* renamed from: i */
        o f7143i;

        /* renamed from: j */
        o f7144j;

        ap() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "radialGradient";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$d */
    static class d extends l implements s {

        /* renamed from: a */
        Boolean f7181a;

        d() {
        }

        @Override // com.p124d.p125a.C1088h.l, com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "clipPath";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$x */
    static class x extends aq implements s {

        /* renamed from: a */
        Boolean f7233a;

        /* renamed from: b */
        Boolean f7234b;

        /* renamed from: c */
        Matrix f7235c;

        /* renamed from: d */
        o f7236d;

        /* renamed from: e */
        o f7237e;

        /* renamed from: f */
        o f7238f;

        /* renamed from: g */
        o f7239g;

        /* renamed from: h */
        String f7240h;

        x() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "pattern";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$n */
    static class n extends ao implements m {

        /* renamed from: a */
        String f7201a;

        /* renamed from: b */
        o f7202b;

        /* renamed from: c */
        o f7203c;

        /* renamed from: d */
        o f7204d;

        /* renamed from: e */
        o f7205e;

        /* renamed from: f */
        Matrix f7206f;

        n() {
        }

        @Override // com.p124d.p125a.C1088h.m
        /* renamed from: a */
        public void mo9112a(Matrix matrix) {
            this.f7206f = matrix;
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return SliceItem.FORMAT_IMAGE;
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$be */
    static class be extends aq implements s {
        be() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "view";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$r */
    static class r extends ag implements s {

        /* renamed from: a */
        Boolean f7219a;

        /* renamed from: b */
        Boolean f7220b;

        /* renamed from: c */
        o f7221c;

        /* renamed from: d */
        o f7222d;

        /* renamed from: e */
        o f7223e;

        /* renamed from: f */
        o f7224f;

        r() {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "mask";
        }
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$ab */
    static class ab extends ak implements ai {
        ab() {
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: b */
        public List<am> mo9096b() {
            return Collections.emptyList();
        }

        @Override // com.p124d.p125a.C1088h.ai
        /* renamed from: a */
        public void mo9095a(am amVar) {
        }

        @Override // com.p124d.p125a.C1088h.am
        /* renamed from: a */
        String mo9094a() {
            return "solidColor";
        }
    }

    /* renamed from: c */
    void m9085c(String str) {
        this.f7020d = str;
    }

    /* renamed from: d */
    void m9088d(String str) {
        this.f7021e = str;
    }

    /* renamed from: e */
    static C1090j m9074e() {
        return f7017a;
    }

    /* compiled from: SVG.java */
    /* renamed from: com.d.a.h$v */
    static class v implements w {

        /* renamed from: b */
        private int f7230b = 0;

        /* renamed from: d */
        private int f7232d = 0;

        /* renamed from: a */
        private byte[] f7229a = new byte[8];

        /* renamed from: c */
        private float[] f7231c = new float[16];

        v() {
        }

        /* renamed from: a */
        boolean m9130a() {
            return this.f7230b == 0;
        }

        /* renamed from: a */
        private void m9123a(byte b2) {
            if (this.f7230b == this.f7229a.length) {
                byte[] bArr = new byte[this.f7229a.length * 2];
                System.arraycopy(this.f7229a, 0, bArr, 0, this.f7229a.length);
                this.f7229a = bArr;
            }
            byte[] bArr2 = this.f7229a;
            int i = this.f7230b;
            this.f7230b = i + 1;
            bArr2[i] = b2;
        }

        /* renamed from: a */
        private void m9124a(int i) {
            if (this.f7231c.length < this.f7232d + i) {
                float[] fArr = new float[this.f7231c.length * 2];
                System.arraycopy(this.f7231c, 0, fArr, 0, this.f7231c.length);
                this.f7231c = fArr;
            }
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9125a(float f2, float f3) {
            m9123a((byte) 0);
            m9124a(2);
            float[] fArr = this.f7231c;
            int i = this.f7232d;
            this.f7232d = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f7231c;
            int i2 = this.f7232d;
            this.f7232d = i2 + 1;
            fArr2[i2] = f3;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9132b(float f2, float f3) {
            m9123a((byte) 1);
            m9124a(2);
            float[] fArr = this.f7231c;
            int i = this.f7232d;
            this.f7232d = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f7231c;
            int i2 = this.f7232d;
            this.f7232d = i2 + 1;
            fArr2[i2] = f3;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9127a(float f2, float f3, float f4, float f5, float f6, float f7) {
            m9123a((byte) 2);
            m9124a(6);
            float[] fArr = this.f7231c;
            int i = this.f7232d;
            this.f7232d = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f7231c;
            int i2 = this.f7232d;
            this.f7232d = i2 + 1;
            fArr2[i2] = f3;
            float[] fArr3 = this.f7231c;
            int i3 = this.f7232d;
            this.f7232d = i3 + 1;
            fArr3[i3] = f4;
            float[] fArr4 = this.f7231c;
            int i4 = this.f7232d;
            this.f7232d = i4 + 1;
            fArr4[i4] = f5;
            float[] fArr5 = this.f7231c;
            int i5 = this.f7232d;
            this.f7232d = i5 + 1;
            fArr5[i5] = f6;
            float[] fArr6 = this.f7231c;
            int i6 = this.f7232d;
            this.f7232d = i6 + 1;
            fArr6[i6] = f7;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9126a(float f2, float f3, float f4, float f5) {
            m9123a((byte) 3);
            m9124a(4);
            float[] fArr = this.f7231c;
            int i = this.f7232d;
            this.f7232d = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f7231c;
            int i2 = this.f7232d;
            this.f7232d = i2 + 1;
            fArr2[i2] = f3;
            float[] fArr3 = this.f7231c;
            int i3 = this.f7232d;
            this.f7232d = i3 + 1;
            fArr3[i3] = f4;
            float[] fArr4 = this.f7231c;
            int i4 = this.f7232d;
            this.f7232d = i4 + 1;
            fArr4[i4] = f5;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9128a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            m9123a((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            m9124a(5);
            float[] fArr = this.f7231c;
            int i = this.f7232d;
            this.f7232d = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f7231c;
            int i2 = this.f7232d;
            this.f7232d = i2 + 1;
            fArr2[i2] = f3;
            float[] fArr3 = this.f7231c;
            int i3 = this.f7232d;
            this.f7232d = i3 + 1;
            fArr3[i3] = f4;
            float[] fArr4 = this.f7231c;
            int i4 = this.f7232d;
            this.f7232d = i4 + 1;
            fArr4[i4] = f5;
            float[] fArr5 = this.f7231c;
            int i5 = this.f7232d;
            this.f7232d = i5 + 1;
            fArr5[i5] = f6;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9131b() {
            m9123a((byte) 8);
        }

        /* renamed from: a */
        void m9129a(w wVar) {
            int i = 0;
            for (int i2 = 0; i2 < this.f7230b; i2++) {
                byte b2 = this.f7229a[i2];
                switch (b2) {
                    case 0:
                        int i3 = i + 1;
                        float f2 = this.f7231c[i];
                        i = i3 + 1;
                        wVar.mo9125a(f2, this.f7231c[i3]);
                        break;
                    case 1:
                        int i4 = i + 1;
                        float f3 = this.f7231c[i];
                        i = i4 + 1;
                        wVar.mo9132b(f3, this.f7231c[i4]);
                        break;
                    case 2:
                        int i5 = i + 1;
                        int i6 = i5 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        wVar.mo9127a(this.f7231c[i], this.f7231c[i5], this.f7231c[i6], this.f7231c[i7], this.f7231c[i8], this.f7231c[i9]);
                        i = i9 + 1;
                        break;
                    case 3:
                        int i10 = i + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        i = i12 + 1;
                        wVar.mo9126a(this.f7231c[i], this.f7231c[i10], this.f7231c[i11], this.f7231c[i12]);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        int i13 = i + 1;
                        int i14 = i13 + 1;
                        int i15 = i14 + 1;
                        int i16 = i15 + 1;
                        wVar.mo9128a(this.f7231c[i], this.f7231c[i13], this.f7231c[i14], (b2 & 2) != 0, (b2 & 1) != 0, this.f7231c[i15], this.f7231c[i16]);
                        i = i16 + 1;
                        break;
                    case 8:
                        wVar.mo9131b();
                        break;
                }
            }
        }
    }

    /* renamed from: e */
    ak m9089e(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f7019c.f7128p)) {
            return this.f7019c;
        }
        if (this.f7024h.containsKey(str)) {
            return this.f7024h.get(str);
        }
        ak m9072a = m9072a(this.f7019c, str);
        this.f7024h.put(str, m9072a);
        return m9072a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private ak m9072a(ai aiVar, String str) {
        ak m9072a;
        ak akVar = (ak) aiVar;
        if (!str.equals(akVar.f7128p)) {
            for (Object obj : aiVar.mo9096b()) {
                if (obj instanceof ak) {
                    ak akVar2 = (ak) obj;
                    if (str.equals(akVar2.f7128p)) {
                        return akVar2;
                    }
                    if ((obj instanceof ai) && (m9072a = m9072a((ai) obj, str)) != null) {
                        return m9072a;
                    }
                }
            }
            return null;
        }
        return akVar;
    }
}
