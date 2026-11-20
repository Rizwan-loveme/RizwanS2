package com.p124d.p125a;

import android.provider.MediaStore;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.p124d.p125a.C1088h;
import com.p124d.p125a.C1092l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: CSSParser.java */
/* renamed from: com.d.a.b */
/* loaded from: classes.dex */
class C1082b {

    /* renamed from: a */
    private e f6898a;

    /* renamed from: b */
    private t f6899b;

    /* renamed from: c */
    private boolean f6900c;

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$b */
    private enum b {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$d */
    private enum d {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$e */
    enum e {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$f */
    private interface f {
        /* renamed from: a */
        boolean mo9036a(p pVar, C1088h.ak akVar);
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$t */
    enum t {
        Document,
        RenderOptions
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$i */
    private enum i {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;


        /* renamed from: z */
        private static final Map<String, i> f6960z = new HashMap();

        static {
            for (i iVar : values()) {
                if (iVar != UNSUPPORTED) {
                    f6960z.put(iVar.name().replace('_', '-'), iVar);
                }
            }
        }

        /* renamed from: a */
        public static i m9037a(String str) {
            i iVar = f6960z.get(str);
            return iVar != null ? iVar : UNSUPPORTED;
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$a */
    private static class a {

        /* renamed from: a */
        public final String f6903a;

        /* renamed from: b */
        final b f6904b;

        /* renamed from: c */
        public final String f6905c;

        a(String str, b bVar, String str2) {
            this.f6903a = str;
            this.f6904b = bVar;
            this.f6905c = str2;
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$s */
    private static class s {

        /* renamed from: a */
        d f6972a;

        /* renamed from: b */
        String f6973b;

        /* renamed from: c */
        List<a> f6974c = null;

        /* renamed from: d */
        List<f> f6975d = null;

        s(d dVar, String str) {
            this.f6972a = null;
            this.f6973b = null;
            this.f6972a = dVar == null ? d.DESCENDANT : dVar;
            this.f6973b = str;
        }

        /* renamed from: a */
        void m9053a(String str, b bVar, String str2) {
            if (this.f6974c == null) {
                this.f6974c = new ArrayList();
            }
            this.f6974c.add(new a(str, bVar, str2));
        }

        /* renamed from: a */
        void m9052a(f fVar) {
            if (this.f6975d == null) {
                this.f6975d = new ArrayList();
            }
            this.f6975d.add(fVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f6972a == d.CHILD) {
                sb.append("> ");
            } else if (this.f6972a == d.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.f6973b == null ? "*" : this.f6973b);
            if (this.f6974c != null) {
                for (a aVar : this.f6974c) {
                    sb.append('[').append(aVar.f6903a);
                    switch (aVar.f6904b) {
                        case EQUALS:
                            sb.append('=').append(aVar.f6905c);
                            break;
                        case INCLUDES:
                            sb.append("~=").append(aVar.f6905c);
                            break;
                        case DASHMATCH:
                            sb.append("|=").append(aVar.f6905c);
                            break;
                    }
                    sb.append(']');
                }
            }
            if (this.f6975d != null) {
                Iterator<f> it = this.f6975d.iterator();
                while (it.hasNext()) {
                    sb.append(':').append(it.next());
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$q */
    static class q {

        /* renamed from: a */
        private List<o> f6969a = null;

        q() {
        }

        /* renamed from: a */
        void m9040a(o oVar) {
            if (this.f6969a == null) {
                this.f6969a = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f6969a.size()) {
                    if (this.f6969a.get(i2).f6965a.f6971b <= oVar.f6965a.f6971b) {
                        i = i2 + 1;
                    } else {
                        this.f6969a.add(i2, oVar);
                        return;
                    }
                } else {
                    this.f6969a.add(oVar);
                    return;
                }
            }
        }

        /* renamed from: a */
        void m9041a(q qVar) {
            if (qVar.f6969a != null) {
                if (this.f6969a == null) {
                    this.f6969a = new ArrayList(qVar.f6969a.size());
                }
                Iterator<o> it = qVar.f6969a.iterator();
                while (it.hasNext()) {
                    m9040a(it.next());
                }
            }
        }

        /* renamed from: a */
        List<o> m9039a() {
            return this.f6969a;
        }

        /* renamed from: b */
        boolean m9043b() {
            return this.f6969a == null || this.f6969a.isEmpty();
        }

        /* renamed from: c */
        int m9044c() {
            if (this.f6969a != null) {
                return this.f6969a.size();
            }
            return 0;
        }

        /* renamed from: a */
        void m9042a(t tVar) {
            if (this.f6969a != null) {
                Iterator<o> it = this.f6969a.iterator();
                while (it.hasNext()) {
                    if (it.next().f6967c == tVar) {
                        it.remove();
                    }
                }
            }
        }

        public String toString() {
            if (this.f6969a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<o> it = this.f6969a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$o */
    static class o {

        /* renamed from: a */
        r f6965a;

        /* renamed from: b */
        C1088h.ad f6966b;

        /* renamed from: c */
        t f6967c;

        o(r rVar, C1088h.ad adVar, t tVar) {
            this.f6965a = null;
            this.f6966b = null;
            this.f6965a = rVar;
            this.f6966b = adVar;
            this.f6967c = tVar;
        }

        public String toString() {
            return String.valueOf(this.f6965a) + " {...} (src=" + this.f6967c + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$r */
    static class r {

        /* renamed from: a */
        List<s> f6970a;

        /* renamed from: b */
        int f6971b;

        private r() {
            this.f6970a = null;
            this.f6971b = 0;
        }

        /* renamed from: a */
        void m9047a(s sVar) {
            if (this.f6970a == null) {
                this.f6970a = new ArrayList();
            }
            this.f6970a.add(sVar);
        }

        /* renamed from: a */
        int m9045a() {
            if (this.f6970a == null) {
                return 0;
            }
            return this.f6970a.size();
        }

        /* renamed from: a */
        s m9046a(int i) {
            return this.f6970a.get(i);
        }

        /* renamed from: b */
        boolean m9048b() {
            return this.f6970a == null || this.f6970a.isEmpty();
        }

        /* renamed from: c */
        void m9049c() {
            this.f6971b += 1000000;
        }

        /* renamed from: d */
        void m9050d() {
            this.f6971b += 1000;
        }

        /* renamed from: e */
        void m9051e() {
            this.f6971b++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<s> it = this.f6970a.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(' ');
            }
            return sb.append('[').append(this.f6971b).append(']').toString();
        }
    }

    C1082b() {
        this(e.screen, t.Document);
    }

    C1082b(e eVar, t tVar) {
        this.f6898a = null;
        this.f6899b = null;
        this.f6900c = false;
        this.f6898a = eVar;
        this.f6899b = tVar;
    }

    /* renamed from: a */
    q m9020a(String str) {
        c cVar = new c(str);
        cVar.m9387g();
        return m9018c(cVar);
    }

    /* renamed from: a */
    static boolean m9013a(String str, e eVar) {
        c cVar = new c(str);
        cVar.m9387g();
        return m9014a(m9006a(cVar), eVar);
    }

    /* renamed from: a */
    private static void m9008a(String str, Object... objArr) {
        Log.m190w("CSSParser", String.format(str, objArr));
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$c */
    private static class c extends C1092l.h {
        c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        /* renamed from: a */
        String m9030a() {
            int m9026w = m9026w();
            if (m9026w == this.f7443b) {
                return null;
            }
            String substring = this.f7442a.substring(this.f7443b, m9026w);
            this.f7443b = m9026w;
            return substring;
        }

        /* renamed from: w */
        private int m9026w() {
            if (m9386f()) {
                return this.f7443b;
            }
            int i = this.f7443b;
            int i2 = this.f7443b;
            int charAt = this.f7442a.charAt(this.f7443b);
            if (charAt == 45) {
                charAt = m9394n();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int n = m9394n();
                while (true) {
                    if ((n < 65 || n > 90) && ((n < 97 || n > 122) && !((n >= 48 && n <= 57) || n == 45 || n == 95))) {
                        break;
                    }
                    n = m9394n();
                }
                i2 = this.f7443b;
            }
            this.f7443b = i;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: x */
        public List<r> m9027x() {
            if (m9386f()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            r rVar = new r();
            while (!m9386f() && m9031a(rVar)) {
                if (m9388h()) {
                    arrayList.add(rVar);
                    rVar = new r();
                }
            }
            if (!rVar.m9048b()) {
                arrayList.add(rVar);
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x005d  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean m9031a(r rVar) {
            d dVar;
            s sVar;
            b bVar;
            String str;
            if (m9386f()) {
                return false;
            }
            int i = this.f7443b;
            if (!rVar.m9048b()) {
                if (m9380a('>')) {
                    dVar = d.CHILD;
                    m9387g();
                } else if (m9380a('+')) {
                    dVar = d.FOLLOWS;
                    m9387g();
                }
                if (!m9380a('*')) {
                    sVar = new s(dVar, null);
                } else {
                    String m9030a = m9030a();
                    if (m9030a != null) {
                        sVar = new s(dVar, m9030a);
                        rVar.m9051e();
                    } else {
                        sVar = null;
                    }
                }
                while (!m9386f()) {
                    if (m9380a('.')) {
                        if (sVar == null) {
                            sVar = new s(dVar, null);
                        }
                        String m9030a2 = m9030a();
                        if (m9030a2 == null) {
                            throw new C1081a("Invalid \".class\" simpleSelectors");
                        }
                        sVar.m9053a("class", b.EQUALS, m9030a2);
                        rVar.m9050d();
                    } else if (m9380a('#')) {
                        if (sVar == null) {
                            sVar = new s(dVar, null);
                        }
                        String m9030a3 = m9030a();
                        if (m9030a3 == null) {
                            throw new C1081a("Invalid \"#id\" simpleSelectors");
                        }
                        sVar.m9053a("id", b.EQUALS, m9030a3);
                        rVar.m9049c();
                    } else if (m9380a('[')) {
                        if (sVar == null) {
                            sVar = new s(dVar, null);
                        }
                        m9387g();
                        String m9030a4 = m9030a();
                        if (m9030a4 == null) {
                            throw new C1081a("Invalid attribute simpleSelectors");
                        }
                        m9387g();
                        if (m9380a('=')) {
                            bVar = b.EQUALS;
                        } else if (m9382a("~=")) {
                            bVar = b.INCLUDES;
                        } else {
                            bVar = m9382a("|=") ? b.DASHMATCH : null;
                        }
                        if (bVar != null) {
                            m9387g();
                            str = m9022B();
                            if (str == null) {
                                throw new C1081a("Invalid attribute simpleSelectors");
                            }
                            m9387g();
                        } else {
                            str = null;
                        }
                        if (!m9380a(']')) {
                            throw new C1081a("Invalid attribute simpleSelectors");
                        }
                        if (bVar == null) {
                            bVar = b.EXISTS;
                        }
                        sVar.m9053a(m9030a4, bVar, str);
                        rVar.m9050d();
                    } else {
                        if (!m9380a(':')) {
                            break;
                        }
                        if (sVar == null) {
                            sVar = new s(dVar, null);
                        }
                        m9024a(rVar, sVar);
                    }
                }
                if (sVar == null) {
                    rVar.m9047a(sVar);
                    return true;
                }
                this.f7443b = i;
                return false;
            }
            dVar = null;
            if (!m9380a('*')) {
            }
            while (!m9386f()) {
            }
            if (sVar == null) {
            }
        }

        /* compiled from: CSSParser.java */
        /* renamed from: com.d.a.b$c$a */
        private static class a {

            /* renamed from: a */
            public int f6911a;

            /* renamed from: b */
            public int f6912b;

            a(int i, int i2) {
                this.f6911a = i;
                this.f6912b = i2;
            }
        }

        /* renamed from: y */
        private a m9028y() {
            int i;
            int i2;
            C1084d c1084d;
            C1084d c1084d2;
            int i3;
            a aVar;
            if (m9386f()) {
                return null;
            }
            int i4 = this.f7443b;
            if (!m9380a('(')) {
                return null;
            }
            m9387g();
            if (m9382a("odd")) {
                aVar = new a(2, 1);
            } else if (m9382a("even")) {
                aVar = new a(2, 0);
            } else {
                if (m9380a('+')) {
                    i = 1;
                } else {
                    i = m9380a('-') ? -1 : 1;
                }
                C1084d m9058a = C1084d.m9058a(this.f7442a, this.f7443b, this.f7444c, false);
                if (m9058a != null) {
                    this.f7443b = m9058a.m9059a();
                }
                if (m9380a('n') || m9380a(PhoneNumberUtils.WILD)) {
                    if (m9058a == null) {
                        m9058a = new C1084d(1L, this.f7443b);
                    }
                    m9387g();
                    boolean a2 = m9380a('+');
                    i2 = (a2 || !(a2 = m9380a('-'))) ? 1 : -1;
                    if (a2) {
                        m9387g();
                        C1084d m9058a2 = C1084d.m9058a(this.f7442a, this.f7443b, this.f7444c, false);
                        if (m9058a2 != null) {
                            this.f7443b = m9058a2.m9059a();
                            c1084d = m9058a2;
                            c1084d2 = m9058a;
                            i3 = i;
                        } else {
                            this.f7443b = i4;
                            return null;
                        }
                    } else {
                        c1084d = null;
                        c1084d2 = m9058a;
                        i3 = i;
                    }
                } else {
                    c1084d = m9058a;
                    c1084d2 = null;
                    i2 = i;
                    i3 = 1;
                }
                aVar = new a(c1084d2 == null ? 0 : c1084d2.m9060b() * i3, c1084d == null ? 0 : c1084d.m9060b() * i2);
            }
            m9387g();
            if (m9380a(')')) {
                return aVar;
            }
            this.f7443b = i4;
            return null;
        }

        /* renamed from: z */
        private List<String> m9029z() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            if (!m9380a('(')) {
                return null;
            }
            m9387g();
            ArrayList arrayList = null;
            do {
                String m9030a = m9030a();
                if (m9030a == null) {
                    this.f7443b = i;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m9030a);
                m9387g();
            } while (m9388h());
            if (m9380a(')')) {
                return arrayList;
            }
            this.f7443b = i;
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0032, code lost:
        
            continue;
         */
        /* renamed from: A */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<r> m9021A() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            if (!m9380a('(')) {
                return null;
            }
            m9387g();
            List<r> m9027x = m9027x();
            if (m9027x == null) {
                this.f7443b = i;
                return null;
            }
            if (!m9380a(')')) {
                this.f7443b = i;
                return null;
            }
            for (r rVar : m9027x) {
                if (rVar.f6970a == null) {
                    break;
                }
                for (s sVar : rVar.f6970a) {
                    if (sVar.f6975d != null) {
                        Iterator<f> it = sVar.f6975d.iterator();
                        while (it.hasNext()) {
                            if (it.next() instanceof j) {
                                return null;
                            }
                        }
                    }
                }
            }
            return m9027x;
        }

        /* renamed from: a */
        private void m9024a(r rVar, s sVar) {
            f kVar;
            String m9030a = m9030a();
            if (m9030a == null) {
                throw new C1081a("Invalid pseudo class");
            }
            i m9037a = i.m9037a(m9030a);
            switch (m9037a) {
                case first_child:
                    kVar = new g(0, 1, true, false, null);
                    rVar.m9050d();
                    break;
                case last_child:
                    kVar = new g(0, 1, false, false, null);
                    rVar.m9050d();
                    break;
                case only_child:
                    kVar = new l(false, null);
                    rVar.m9050d();
                    break;
                case first_of_type:
                    kVar = new g(0, 1, true, true, sVar.f6973b);
                    rVar.m9050d();
                    break;
                case last_of_type:
                    kVar = new g(0, 1, false, true, sVar.f6973b);
                    rVar.m9050d();
                    break;
                case only_of_type:
                    kVar = new l(true, sVar.f6973b);
                    rVar.m9050d();
                    break;
                case root:
                    kVar = new m();
                    rVar.m9050d();
                    break;
                case empty:
                    kVar = new h();
                    rVar.m9050d();
                    break;
                case nth_child:
                case nth_last_child:
                case nth_of_type:
                case nth_last_of_type:
                    boolean z = m9037a == i.nth_child || m9037a == i.nth_of_type;
                    boolean z2 = m9037a == i.nth_of_type || m9037a == i.nth_last_of_type;
                    a m9028y = m9028y();
                    if (m9028y == null) {
                        throw new C1081a("Invalid or missing parameter section for pseudo class: " + m9030a);
                    }
                    kVar = new g(m9028y.f6911a, m9028y.f6912b, z, z2, sVar.f6973b);
                    rVar.m9050d();
                    break;
                case not:
                    List<r> m9021A = m9021A();
                    if (m9021A == null) {
                        throw new C1081a("Invalid or missing parameter section for pseudo class: " + m9030a);
                    }
                    j jVar = new j(m9021A);
                    rVar.f6971b = jVar.m9038a();
                    kVar = jVar;
                    break;
                case target:
                    kVar = new n();
                    rVar.m9050d();
                    break;
                case lang:
                    m9029z();
                    kVar = new k(m9030a);
                    rVar.m9050d();
                    break;
                case link:
                case visited:
                case hover:
                case active:
                case focus:
                case enabled:
                case disabled:
                case checked:
                case indeterminate:
                    kVar = new k(m9030a);
                    rVar.m9050d();
                    break;
                default:
                    throw new C1081a("Unsupported pseudo class: " + m9030a);
            }
            sVar.m9052a(kVar);
        }

        /* renamed from: B */
        private String m9022B() {
            if (m9386f()) {
                return null;
            }
            String u = m9401u();
            return u == null ? m9030a() : u;
        }

        /* renamed from: b */
        String m9032b() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            int i2 = this.f7443b;
            int charAt = this.f7442a.charAt(this.f7443b);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !m9384b(charAt)) {
                if (!m9381a(charAt)) {
                    i2 = this.f7443b + 1;
                }
                charAt = m9394n();
            }
            if (this.f7443b > i) {
                return this.f7442a.substring(i, i2);
            }
            this.f7443b = i;
            return null;
        }

        /* renamed from: c */
        String m9033c() {
            int m9025c;
            if (m9386f()) {
                return null;
            }
            char charAt = this.f7442a.charAt(this.f7443b);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f7443b++;
            int intValue = m9391k().intValue();
            while (intValue != -1 && intValue != charAt) {
                if (intValue == 92) {
                    intValue = m9391k().intValue();
                    if (intValue != -1) {
                        if (intValue == 10 || intValue == 13 || intValue == 12) {
                            intValue = m9391k().intValue();
                        } else {
                            int m9025c2 = m9025c(intValue);
                            if (m9025c2 != -1) {
                                for (int i = 1; i <= 5 && (m9025c = m9025c((intValue = m9391k().intValue()))) != -1; i++) {
                                    m9025c2 = (m9025c2 * 16) + m9025c;
                                }
                                sb.append((char) m9025c2);
                            }
                        }
                    }
                }
                sb.append((char) intValue);
                intValue = m9391k().intValue();
            }
            return sb.toString();
        }

        /* renamed from: c */
        private int m9025c(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            if (i >= 65 && i <= 70) {
                return (i - 65) + 10;
            }
            if (i >= 97 && i <= 102) {
                return (i - 97) + 10;
            }
            return -1;
        }

        /* renamed from: d */
        String m9034d() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            if (!m9382a("url(")) {
                return null;
            }
            m9387g();
            String m9033c = m9033c();
            if (m9033c == null) {
                m9033c = m9035e();
            }
            if (m9033c == null) {
                this.f7443b = i;
                return null;
            }
            m9387g();
            if (m9386f() || m9382a(")")) {
                return m9033c;
            }
            this.f7443b = i;
            return null;
        }

        /* renamed from: e */
        String m9035e() {
            char charAt;
            int m9025c;
            StringBuilder sb = new StringBuilder();
            while (!m9386f() && (charAt = this.f7442a.charAt(this.f7443b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !m9381a((int) charAt) && !Character.isISOControl((int) charAt)) {
                this.f7443b++;
                if (charAt == '\\') {
                    if (!m9386f()) {
                        String str = this.f7442a;
                        int i = this.f7443b;
                        this.f7443b = i + 1;
                        charAt = str.charAt(i);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int m9025c2 = m9025c((int) charAt);
                            if (m9025c2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !m9386f() && (m9025c = m9025c((int) this.f7442a.charAt(this.f7443b))) != -1; i2++) {
                                    this.f7443b++;
                                    m9025c2 = (m9025c2 * 16) + m9025c;
                                }
                                sb.append((char) m9025c2);
                            }
                        }
                    }
                }
                sb.append(charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    private static boolean m9014a(List<e> list, e eVar) {
        for (e eVar2 : list) {
            if (eVar2 == e.all || eVar2 == eVar) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static List<e> m9006a(c cVar) {
        String p2;
        ArrayList arrayList = new ArrayList();
        while (!cVar.m9386f() && (p2 = cVar.m9396p()) != null) {
            try {
                arrayList.add(e.valueOf(p2));
            } catch (IllegalArgumentException e2) {
            }
            if (!cVar.m9388h()) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m9007a(q qVar, c cVar) {
        String m9030a = cVar.m9030a();
        cVar.m9387g();
        if (m9030a == null) {
            throw new C1081a("Invalid '@' rule");
        }
        if (!this.f6900c && m9030a.equals(MediaStore.AUTHORITY)) {
            List<e> m9006a = m9006a(cVar);
            if (!cVar.m9380a('{')) {
                throw new C1081a("Invalid @media rule: missing rule set");
            }
            cVar.m9387g();
            if (m9014a(m9006a, this.f6898a)) {
                this.f6900c = true;
                qVar.m9041a(m9018c(cVar));
                this.f6900c = false;
            } else {
                m9018c(cVar);
            }
            if (!cVar.m9386f() && !cVar.m9380a('}')) {
                throw new C1081a("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (!this.f6900c && m9030a.equals("import")) {
            String m9034d = cVar.m9034d();
            if (m9034d == null) {
                m9034d = cVar.m9033c();
            }
            if (m9034d == null) {
                throw new C1081a("Invalid @import rule: expected string or url()");
            }
            cVar.m9387g();
            List<e> m9006a2 = m9006a(cVar);
            if (!cVar.m9386f() && !cVar.m9380a(';')) {
                throw new C1081a("Invalid @media rule: expected '}' at end of rule set");
            }
            if (C1088h.m9074e() != null && m9014a(m9006a2, this.f6898a)) {
                String m9253b = C1088h.m9074e().m9253b(m9034d);
                if (m9253b != null) {
                    qVar.m9041a(m9020a(m9253b));
                } else {
                    return;
                }
            }
        } else {
            m9008a("Ignoring @%s rule", m9030a);
            m9016b(cVar);
        }
        cVar.m9387g();
    }

    /* renamed from: b */
    private void m9016b(c cVar) {
        int i2 = 0;
        while (!cVar.m9386f()) {
            int intValue = cVar.m9391k().intValue();
            if (intValue != 59 || i2 != 0) {
                if (intValue == 123) {
                    i2++;
                } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private q m9018c(c cVar) {
        q qVar = new q();
        while (!cVar.m9386f()) {
            try {
                if (!cVar.m9382a("<!--") && !cVar.m9382a("-->")) {
                    if (cVar.m9380a('@')) {
                        m9007a(qVar, cVar);
                    } else if (!m9017b(qVar, cVar)) {
                        break;
                    }
                }
            } catch (C1081a e2) {
                Log.m184e("CSSParser", "CSS parser terminated early due to error: " + e2.getMessage());
            }
        }
        return qVar;
    }

    /* renamed from: b */
    private boolean m9017b(q qVar, c cVar) {
        List m9027x = cVar.m9027x();
        if (m9027x == null || m9027x.isEmpty()) {
            return false;
        }
        if (!cVar.m9380a('{')) {
            throw new C1081a("Malformed rule block: expected '{'");
        }
        cVar.m9387g();
        C1088h.ad m9019d = m9019d(cVar);
        cVar.m9387g();
        Iterator it = m9027x.iterator();
        while (it.hasNext()) {
            qVar.m9040a(new o((r) it.next(), m9019d, this.f6899b));
        }
        return true;
    }

    /* renamed from: d */
    private C1088h.ad m9019d(c cVar) {
        C1088h.ad adVar = new C1088h.ad();
        do {
            String m9030a = cVar.m9030a();
            cVar.m9387g();
            if (!cVar.m9380a(':')) {
                throw new C1081a("Expected ':'");
            }
            cVar.m9387g();
            String m9032b = cVar.m9032b();
            if (m9032b == null) {
                throw new C1081a("Expected property value");
            }
            cVar.m9387g();
            if (cVar.m9380a('!')) {
                cVar.m9387g();
                if (!cVar.m9382a("important")) {
                    throw new C1081a("Malformed rule set: found unexpected '!'");
                }
                cVar.m9387g();
            }
            cVar.m9380a(';');
            C1092l.m9276a(adVar, m9030a, m9032b);
            cVar.m9387g();
            if (cVar.m9386f()) {
                break;
            }
        } while (!cVar.m9380a('}'));
        return adVar;
    }

    /* renamed from: b */
    public static List<String> m9015b(String str) {
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.m9386f()) {
            String o2 = cVar.m9395o();
            if (o2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(o2);
                cVar.m9387g();
            }
        }
        return arrayList;
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$p */
    static class p {

        /* renamed from: a */
        C1088h.ak f6968a;

        p() {
        }

        public String toString() {
            return this.f6968a != null ? String.format("<%s id=\"%s\">", this.f6968a.mo9094a(), this.f6968a.f7128p) : "";
        }
    }

    /* renamed from: a */
    static boolean m9011a(p pVar, r rVar, C1088h.ak akVar) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = akVar.f7138v; obj != null; obj = ((C1088h.am) obj).f7138v) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        return rVar.m9045a() == 1 ? m9012a(pVar, rVar.m9046a(0), arrayList, size, akVar) : m9010a(pVar, rVar, rVar.m9045a() - 1, arrayList, size, akVar);
    }

    /* renamed from: a */
    private static boolean m9010a(p pVar, r rVar, int i2, List<C1088h.ai> list, int i3, C1088h.ak akVar) {
        s m9046a = rVar.m9046a(i2);
        if (!m9012a(pVar, m9046a, list, i3, akVar)) {
            return false;
        }
        if (m9046a.f6972a == d.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 >= 0) {
                if (m9009a(pVar, rVar, i2 - 1, list, i3)) {
                    return true;
                }
                i3--;
            }
            return false;
        }
        if (m9046a.f6972a == d.CHILD) {
            return m9009a(pVar, rVar, i2 - 1, list, i3);
        }
        int m9005a = m9005a(list, i3, akVar);
        if (m9005a <= 0) {
            return false;
        }
        return m9010a(pVar, rVar, i2 - 1, list, i3, (C1088h.ak) akVar.f7138v.mo9096b().get(m9005a - 1));
    }

    /* renamed from: a */
    private static boolean m9009a(p pVar, r rVar, int i2, List<C1088h.ai> list, int i3) {
        s m9046a = rVar.m9046a(i2);
        C1088h.ak akVar = (C1088h.ak) list.get(i3);
        if (!m9012a(pVar, m9046a, list, i3, akVar)) {
            return false;
        }
        if (m9046a.f6972a == d.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 > 0) {
                i3--;
                if (m9009a(pVar, rVar, i2 - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        }
        if (m9046a.f6972a == d.CHILD) {
            return m9009a(pVar, rVar, i2 - 1, list, i3 - 1);
        }
        int m9005a = m9005a(list, i3, akVar);
        if (m9005a <= 0) {
            return false;
        }
        return m9010a(pVar, rVar, i2 - 1, list, i3, (C1088h.ak) akVar.f7138v.mo9096b().get(m9005a - 1));
    }

    /* renamed from: a */
    private static int m9005a(List<C1088h.ai> list, int i2, C1088h.ak akVar) {
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        if (list.get(i2) != akVar.f7138v) {
            return -1;
        }
        Iterator<C1088h.am> it = akVar.f7138v.mo9096b().iterator();
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return -1;
            }
            if (it.next() == akVar) {
                return i4;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean m9012a(p pVar, s sVar, List<C1088h.ai> list, int i2, C1088h.ak akVar) {
        if (sVar.f6973b != null && !sVar.f6973b.equals(akVar.mo9094a().toLowerCase(Locale.f10688US))) {
            return false;
        }
        if (sVar.f6974c != null) {
            for (a aVar : sVar.f6974c) {
                String str = aVar.f6903a;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 3355:
                        if (str.equals("id")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                if (!aVar.f6905c.equals(akVar.f7128p)) {
                                    return false;
                                }
                                break;
                            case 1:
                                if (akVar.f7132t != null && akVar.f7132t.contains(aVar.f6905c)) {
                                    break;
                                }
                                return false;
                            default:
                                return false;
                        }
                        break;
                    case 94742904:
                        if (str.equals("class")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        break;
                    default:
                        switch (c2) {
                        }
                        break;
                }
            }
        }
        if (sVar.f6975d != null) {
            Iterator<f> it = sVar.f6975d.iterator();
            while (it.hasNext()) {
                if (!it.next().mo9036a(pVar, akVar)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$g */
    private static class g implements f {

        /* renamed from: a */
        private int f6929a;

        /* renamed from: b */
        private int f6930b;

        /* renamed from: c */
        private boolean f6931c;

        /* renamed from: d */
        private boolean f6932d;

        /* renamed from: e */
        private String f6933e;

        g(int i, int i2, boolean z, boolean z2, String str) {
            this.f6929a = i;
            this.f6930b = i2;
            this.f6931c = z;
            this.f6932d = z2;
            this.f6933e = str;
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            int i;
            int i2;
            String a2 = (this.f6932d && this.f6933e == null) ? akVar.mo9094a() : this.f6933e;
            if (akVar.f7138v != null) {
                Iterator<C1088h.am> it = akVar.f7138v.mo9096b().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    C1088h.ak akVar2 = (C1088h.ak) it.next();
                    if (akVar2 == akVar) {
                        i2 = i;
                    }
                    i = (a2 == null || akVar2.mo9094a().equals(a2)) ? i + 1 : i;
                }
            } else {
                i = 1;
                i2 = 0;
            }
            int i3 = this.f6931c ? i2 + 1 : i - i2;
            return this.f6929a == 0 ? i3 == this.f6930b : (i3 - this.f6930b) % this.f6929a == 0 && (Integer.signum(i3 - this.f6930b) == 0 || Integer.signum(i3 - this.f6930b) == Integer.signum(this.f6929a));
        }

        public String toString() {
            String str = this.f6931c ? "" : "last-";
            return this.f6932d ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f6929a), Integer.valueOf(this.f6930b), this.f6933e) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f6929a), Integer.valueOf(this.f6930b));
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$l */
    private static class l implements f {

        /* renamed from: a */
        private boolean f6963a;

        /* renamed from: b */
        private String f6964b;

        public l(boolean z, String str) {
            this.f6963a = z;
            this.f6964b = str;
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            int i;
            String a2 = (this.f6963a && this.f6964b == null) ? akVar.mo9094a() : this.f6964b;
            if (akVar.f7138v != null) {
                Iterator<C1088h.am> it = akVar.f7138v.mo9096b().iterator();
                i = 0;
                while (it.hasNext()) {
                    i = (a2 == null || ((C1088h.ak) it.next()).mo9094a().equals(a2)) ? i + 1 : i;
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public String toString() {
            return this.f6963a ? String.format("only-of-type <%s>", this.f6964b) : String.format("only-child", new Object[0]);
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$m */
    private static class m implements f {
        private m() {
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            return akVar.f7138v == null;
        }

        public String toString() {
            return "root";
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$h */
    private static class h implements f {
        private h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            return !(akVar instanceof C1088h.ai) || ((C1088h.ai) akVar).mo9096b().size() == 0;
        }

        public String toString() {
            return "empty";
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$j */
    private static class j implements f {

        /* renamed from: a */
        private List<r> f6961a;

        j(List<r> list) {
            this.f6961a = list;
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            Iterator<r> it = this.f6961a.iterator();
            while (it.hasNext()) {
                if (C1082b.m9011a(pVar, it.next(), akVar)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        int m9038a() {
            int i = Integer.MIN_VALUE;
            Iterator<r> it = this.f6961a.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    r next = it.next();
                    i = next.f6971b > i2 ? next.f6971b : i2;
                } else {
                    return i2;
                }
            }
        }

        public String toString() {
            return "not(" + this.f6961a + ")";
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$n */
    private static class n implements f {
        private n() {
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            return pVar != null && akVar == pVar.f6968a;
        }

        public String toString() {
            return "target";
        }
    }

    /* compiled from: CSSParser.java */
    /* renamed from: com.d.a.b$k */
    private static class k implements f {

        /* renamed from: a */
        private String f6962a;

        k(String str) {
            this.f6962a = str;
        }

        @Override // com.p124d.p125a.C1082b.f
        /* renamed from: a */
        public boolean mo9036a(p pVar, C1088h.ak akVar) {
            return false;
        }

        public String toString() {
            return this.f6962a;
        }
    }
}
