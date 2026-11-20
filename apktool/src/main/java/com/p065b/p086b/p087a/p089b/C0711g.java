package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0961o;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1012c;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import java.util.ArrayList;

/* compiled from: BytecodeArray.java */
/* renamed from: com.b.b.a.b.g */
/* loaded from: classes.dex */
public final class C0711g {

    /* renamed from: a */
    public static final c f4523a = new a();

    /* renamed from: b */
    private final C1013d f4524b;

    /* renamed from: c */
    private final InterfaceC0948b f4525c;

    /* compiled from: BytecodeArray.java */
    /* renamed from: com.b.b.a.b.g$c */
    public interface c {
        /* renamed from: a */
        int mo6559a();

        /* renamed from: a */
        void mo6560a(int i);

        /* renamed from: a */
        void mo6561a(int i, int i2, int i3);

        /* renamed from: a */
        void mo6562a(int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5);

        /* renamed from: a */
        void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4);

        /* renamed from: a */
        void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4);

        /* renamed from: a */
        void mo6566a(int i, int i2, int i3, C0975c c0975c);

        /* renamed from: a */
        void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList);
    }

    public C0711g(C1013d c1013d, InterfaceC0948b interfaceC0948b) {
        if (c1013d == null) {
            throw new NullPointerException("bytes == null");
        }
        if (interfaceC0948b == null) {
            throw new NullPointerException("pool == null");
        }
        this.f4524b = c1013d;
        this.f4525c = interfaceC0948b;
    }

    /* renamed from: a */
    public C1013d m6596a() {
        return this.f4524b;
    }

    /* renamed from: b */
    public int m6599b() {
        return this.f4524b.m8502a();
    }

    /* renamed from: c */
    public int m6600c() {
        return this.f4524b.m8502a() + 4;
    }

    /* renamed from: a */
    public void m6597a(c cVar) {
        int m8502a = this.f4524b.m8502a();
        int i = 0;
        while (i < m8502a) {
            i += m6595a(i, cVar);
        }
    }

    /* renamed from: a */
    public void m6598a(int[] iArr, c cVar) {
        if (cVar == null) {
            throw new NullPointerException("visitor == null");
        }
        while (true) {
            int m8494d = C1012c.m8494d(iArr, 0);
            if (m8494d >= 0) {
                C1012c.m8493c(iArr, m8494d);
                m6595a(m8494d, cVar);
                cVar.mo6560a(m8494d);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public int m6595a(int i, c cVar) {
        c cVar2 = cVar == null ? f4523a : cVar;
        try {
            int m8511e = this.f4524b.m8511e(i);
            int m6590b = C0710f.m6590b(m8511e) & 31;
            switch (m8511e) {
                case 0:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6254i);
                    return 1;
                case 1:
                    cVar2.mo6565a(18, i, 1, C0961o.f6158a, 0);
                    return 1;
                case 2:
                    cVar2.mo6565a(18, i, 1, C0959m.f6149a, -1);
                    return 1;
                case 3:
                    cVar2.mo6565a(18, i, 1, C0959m.f6150b, 0);
                    return 1;
                case 4:
                    cVar2.mo6565a(18, i, 1, C0959m.f6151c, 1);
                    return 1;
                case 5:
                    cVar2.mo6565a(18, i, 1, C0959m.f6152d, 2);
                    return 1;
                case 6:
                    cVar2.mo6565a(18, i, 1, C0959m.f6153e, 3);
                    return 1;
                case 7:
                    cVar2.mo6565a(18, i, 1, C0959m.f6154f, 4);
                    return 1;
                case 8:
                    cVar2.mo6565a(18, i, 1, C0959m.f6155g, 5);
                    return 1;
                case 9:
                    cVar2.mo6565a(18, i, 1, C0965s.f6161a, 0);
                    return 1;
                case 10:
                    cVar2.mo6565a(18, i, 1, C0965s.f6162b, 0);
                    return 1;
                case 11:
                    cVar2.mo6565a(18, i, 1, C0958l.f6146a, 0);
                    return 1;
                case 12:
                    cVar2.mo6565a(18, i, 1, C0958l.f6147b, 0);
                    return 1;
                case 13:
                    cVar2.mo6565a(18, i, 1, C0958l.f6148c, 0);
                    return 1;
                case 14:
                    cVar2.mo6565a(18, i, 1, C0955i.f6143a, 0);
                    return 1;
                case 15:
                    cVar2.mo6565a(18, i, 1, C0955i.f6144b, 0);
                    return 1;
                case 16:
                    int m8503a = this.f4524b.m8503a(i + 1);
                    cVar2.mo6565a(18, i, 2, C0959m.m8060a(m8503a), m8503a);
                    return 2;
                case 17:
                    int m8506b = this.f4524b.m8506b(i + 1);
                    cVar2.mo6565a(18, i, 3, C0959m.m8060a(m8506b), m8506b);
                    return 3;
                case 18:
                    AbstractC0945a mo8038a = this.f4525c.mo8038a(this.f4524b.m8511e(i + 1));
                    cVar2.mo6565a(18, i, 2, mo8038a, mo8038a instanceof C0959m ? ((C0959m) mo8038a).m8061k_() : 0);
                    return 2;
                case 19:
                    AbstractC0945a mo8038a2 = this.f4525c.mo8038a(this.f4524b.m8512f(i + 1));
                    cVar2.mo6565a(18, i, 3, mo8038a2, mo8038a2 instanceof C0959m ? ((C0959m) mo8038a2).m8061k_() : 0);
                    return 3;
                case 20:
                    cVar2.mo6565a(20, i, 3, this.f4525c.mo8038a(this.f4524b.m8512f(i + 1)), 0);
                    return 3;
                case 21:
                    cVar2.mo6563a(21, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6251f, 0);
                    return 2;
                case 22:
                    cVar2.mo6563a(21, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6252g, 0);
                    return 2;
                case 23:
                    cVar2.mo6563a(21, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6250e, 0);
                    return 2;
                case 24:
                    cVar2.mo6563a(21, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6249d, 0);
                    return 2;
                case 25:
                    cVar2.mo6563a(21, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6260o, 0);
                    return 2;
                case 26:
                case 27:
                case 28:
                case 29:
                    cVar2.mo6563a(21, i, 1, m8511e - 26, C0975c.f6251f, 0);
                    return 1;
                case 30:
                case 31:
                case 32:
                case 33:
                    cVar2.mo6563a(21, i, 1, m8511e - 30, C0975c.f6252g, 0);
                    return 1;
                case 34:
                case 35:
                case 36:
                case 37:
                    cVar2.mo6563a(21, i, 1, m8511e - 34, C0975c.f6250e, 0);
                    return 1;
                case 38:
                case 39:
                case 40:
                case 41:
                    cVar2.mo6563a(21, i, 1, m8511e - 38, C0975c.f6249d, 0);
                    return 1;
                case 42:
                case 43:
                case 44:
                case 45:
                    cVar2.mo6563a(21, i, 1, m8511e - 42, C0975c.f6260o, 0);
                    return 1;
                case 46:
                    cVar2.mo6566a(46, i, 1, C0975c.f6251f);
                    return 1;
                case 47:
                    cVar2.mo6566a(46, i, 1, C0975c.f6252g);
                    return 1;
                case 48:
                    cVar2.mo6566a(46, i, 1, C0975c.f6250e);
                    return 1;
                case 49:
                    cVar2.mo6566a(46, i, 1, C0975c.f6249d);
                    return 1;
                case 50:
                    cVar2.mo6566a(46, i, 1, C0975c.f6260o);
                    return 1;
                case 51:
                    cVar2.mo6566a(46, i, 1, C0975c.f6247b);
                    return 1;
                case 52:
                    cVar2.mo6566a(46, i, 1, C0975c.f6248c);
                    return 1;
                case 53:
                    cVar2.mo6566a(46, i, 1, C0975c.f6253h);
                    return 1;
                case 54:
                    cVar2.mo6563a(54, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6251f, 0);
                    return 2;
                case 55:
                    cVar2.mo6563a(54, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6252g, 0);
                    return 2;
                case 56:
                    cVar2.mo6563a(54, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6250e, 0);
                    return 2;
                case 57:
                    cVar2.mo6563a(54, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6249d, 0);
                    return 2;
                case 58:
                    cVar2.mo6563a(54, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6260o, 0);
                    return 2;
                case 59:
                case 60:
                case 61:
                case 62:
                    cVar2.mo6563a(54, i, 1, m8511e - 59, C0975c.f6251f, 0);
                    return 1;
                case 63:
                case 64:
                case 65:
                case 66:
                    cVar2.mo6563a(54, i, 1, m8511e - 63, C0975c.f6252g, 0);
                    return 1;
                case 67:
                case 68:
                case 69:
                case 70:
                    cVar2.mo6563a(54, i, 1, m8511e - 67, C0975c.f6250e, 0);
                    return 1;
                case 71:
                case 72:
                case 73:
                case 74:
                    cVar2.mo6563a(54, i, 1, m8511e - 71, C0975c.f6249d, 0);
                    return 1;
                case 75:
                case 76:
                case 77:
                case 78:
                    cVar2.mo6563a(54, i, 1, m8511e - 75, C0975c.f6260o, 0);
                    return 1;
                case 79:
                    cVar2.mo6566a(79, i, 1, C0975c.f6251f);
                    return 1;
                case 80:
                    cVar2.mo6566a(79, i, 1, C0975c.f6252g);
                    return 1;
                case 81:
                    cVar2.mo6566a(79, i, 1, C0975c.f6250e);
                    return 1;
                case 82:
                    cVar2.mo6566a(79, i, 1, C0975c.f6249d);
                    return 1;
                case 83:
                    cVar2.mo6566a(79, i, 1, C0975c.f6260o);
                    return 1;
                case 84:
                    cVar2.mo6566a(79, i, 1, C0975c.f6247b);
                    return 1;
                case 85:
                    cVar2.mo6566a(79, i, 1, C0975c.f6248c);
                    return 1;
                case 86:
                    cVar2.mo6566a(79, i, 1, C0975c.f6253h);
                    return 1;
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6254i);
                    return 1;
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 116:
                case 120:
                case 122:
                case 124:
                case 126:
                case 128:
                case 130:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6251f);
                    return 1;
                case 97:
                case 101:
                case 105:
                case 109:
                case 113:
                case 117:
                case 121:
                case 123:
                case 125:
                case 127:
                case 129:
                case 131:
                    cVar2.mo6566a(m8511e - 1, i, 1, C0975c.f6252g);
                    return 1;
                case 98:
                case 102:
                case 106:
                case 110:
                case 114:
                case 118:
                    cVar2.mo6566a(m8511e - 2, i, 1, C0975c.f6250e);
                    return 1;
                case 99:
                case 103:
                case 107:
                case 111:
                case 115:
                case 119:
                    cVar2.mo6566a(m8511e - 3, i, 1, C0975c.f6249d);
                    return 1;
                case 132:
                    cVar2.mo6563a(m8511e, i, 3, this.f4524b.m8511e(i + 1), C0975c.f6251f, this.f4524b.m8503a(i + 2));
                    return 3;
                case 133:
                case 140:
                case 143:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6252g);
                    return 1;
                case 134:
                case 137:
                case 144:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6250e);
                    return 1;
                case 135:
                case 138:
                case 141:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6249d);
                    return 1;
                case 136:
                case 139:
                case 142:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 190:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6251f);
                    return 1;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 198:
                case 199:
                    cVar2.mo6562a(m8511e, i, 3, this.f4524b.m8506b(i + 1) + i);
                    return 3;
                case 169:
                    cVar2.mo6563a(m8511e, i, 2, this.f4524b.m8511e(i + 1), C0975c.f6256k, 0);
                    return 2;
                case 170:
                    return m6591b(i, cVar2);
                case 171:
                    return m6592c(i, cVar2);
                case 172:
                    cVar2.mo6566a(172, i, 1, C0975c.f6251f);
                    return 1;
                case 173:
                    cVar2.mo6566a(172, i, 1, C0975c.f6252g);
                    return 1;
                case 174:
                    cVar2.mo6566a(172, i, 1, C0975c.f6250e);
                    return 1;
                case 175:
                    cVar2.mo6566a(172, i, 1, C0975c.f6249d);
                    return 1;
                case 176:
                    cVar2.mo6566a(172, i, 1, C0975c.f6260o);
                    return 1;
                case 177:
                case 191:
                case 194:
                case 195:
                    cVar2.mo6566a(m8511e, i, 1, C0975c.f6254i);
                    return 1;
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    cVar2.mo6565a(m8511e, i, 3, this.f4525c.mo8038a(this.f4524b.m8512f(i + 1)), 0);
                    return 3;
                case 185:
                    cVar2.mo6565a(m8511e, i, 5, this.f4525c.mo8038a(this.f4524b.m8512f(i + 1)), this.f4524b.m8511e(i + 3) | (this.f4524b.m8511e(i + 4) << 8));
                    return 5;
                case 186:
                default:
                    cVar2.mo6561a(m8511e, i, 1);
                    return 1;
                case 188:
                    return m6593d(i, cVar2);
                case 196:
                    return m6594e(i, cVar2);
                case 197:
                    cVar2.mo6565a(m8511e, i, 4, this.f4525c.mo8038a(this.f4524b.m8512f(i + 1)), this.f4524b.m8511e(i + 3));
                    return 4;
                case 200:
                case 201:
                    cVar2.mo6562a(m8511e == 200 ? 167 : 168, i, 5, this.f4524b.m8508c(i + 1) + i);
                    return 5;
            }
        } catch (C0725u e2) {
            e2.m8540a("...at bytecode offset " + C1022m.m8552a(i));
            throw e2;
        } catch (RuntimeException e3) {
            C0725u c0725u = new C0725u(e3);
            c0725u.m8540a("...at bytecode offset " + C1022m.m8552a(i));
            throw c0725u;
        }
    }

    /* renamed from: b */
    private int m6591b(int i, c cVar) {
        int i2 = (i + 4) & (-4);
        int i3 = 0;
        for (int i4 = i + 1; i4 < i2; i4++) {
            i3 = (i3 << 8) | this.f4524b.m8511e(i4);
        }
        int m8508c = i + this.f4524b.m8508c(i2);
        int m8508c2 = this.f4524b.m8508c(i2 + 4);
        int m8508c3 = this.f4524b.m8508c(i2 + 8);
        int i5 = (m8508c3 - m8508c2) + 1;
        int i6 = i2 + 12;
        if (m8508c2 > m8508c3) {
            throw new C0725u("low / high inversion");
        }
        C0727w c0727w = new C0727w(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            int m8508c4 = this.f4524b.m8508c(i6) + i;
            i6 += 4;
            c0727w.m6781a(m8508c2 + i7, m8508c4);
        }
        c0727w.m6784c(m8508c);
        c0727w.m6787f();
        c0727w.mo6683e_();
        int i8 = i6 - i;
        cVar.mo6564a(171, i, i8, c0727w, i3);
        return i8;
    }

    /* renamed from: c */
    private int m6592c(int i, c cVar) {
        int i2 = (i + 4) & (-4);
        int i3 = 0;
        for (int i4 = i + 1; i4 < i2; i4++) {
            i3 = (i3 << 8) | this.f4524b.m8511e(i4);
        }
        int m8508c = i + this.f4524b.m8508c(i2);
        int m8508c2 = this.f4524b.m8508c(i2 + 4);
        int i5 = i2 + 8;
        C0727w c0727w = new C0727w(m8508c2);
        for (int i6 = 0; i6 < m8508c2; i6++) {
            int m8508c3 = this.f4524b.m8508c(i5);
            int m8508c4 = this.f4524b.m8508c(i5 + 4) + i;
            i5 += 8;
            c0727w.m6781a(m8508c3, m8508c4);
        }
        c0727w.m6784c(m8508c);
        c0727w.m6787f();
        c0727w.mo6683e_();
        int i7 = i5 - i;
        cVar.mo6564a(171, i, i7, c0727w, i3);
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r6 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e5, code lost:
    
        r15.mo6567a(r14, r3 - r14, r0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return r3 - r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f0  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m6593d(int i, c cVar) {
        C0971y c0971y;
        int i2;
        int i3;
        int i4;
        boolean z;
        int m8511e = this.f4524b.m8511e(i + 1);
        switch (m8511e) {
            case 4:
                c0971y = C0971y.f6182k;
                break;
            case 5:
                c0971y = C0971y.f6184m;
                break;
            case 6:
                c0971y = C0971y.f6186o;
                break;
            case 7:
                c0971y = C0971y.f6185n;
                break;
            case 8:
                c0971y = C0971y.f6183l;
                break;
            case 9:
                c0971y = C0971y.f6189r;
                break;
            case 10:
                c0971y = C0971y.f6188q;
                break;
            case 11:
                c0971y = C0971y.f6187p;
                break;
            default:
                throw new C0725u("bad newarray code " + C1022m.m8559e(m8511e));
        }
        int mo6559a = cVar.mo6559a();
        b bVar = new b();
        if (mo6559a >= 0) {
            m6595a(mo6559a, bVar);
            if ((bVar.f4527a instanceof C0959m) && mo6559a + bVar.f4528b == i) {
                i2 = bVar.f4529c;
                int i5 = i + 2;
                ArrayList<AbstractC0945a> arrayList = new ArrayList<>();
                if (i2 == 0) {
                    i3 = i5;
                    int i6 = i5;
                    i4 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        if (this.f4524b.m8511e(i6) == 89) {
                            m6595a(i7, bVar);
                            if (bVar.f4528b != 0 && (bVar.f4527a instanceof C0959m) && bVar.f4529c == i4) {
                                int i8 = bVar.f4528b + i7;
                                m6595a(i8, bVar);
                                if (bVar.f4528b != 0 && (bVar.f4527a instanceof AbstractC0964r)) {
                                    int i9 = bVar.f4528b + i8;
                                    arrayList.add(bVar.f4527a);
                                    int i10 = i9 + 1;
                                    int m8511e2 = this.f4524b.m8511e(i9);
                                    switch (m8511e) {
                                        case 4:
                                        case 8:
                                            if (m8511e2 != 84) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 5:
                                            if (m8511e2 != 85) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 6:
                                            if (m8511e2 != 81) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 7:
                                            if (m8511e2 != 82) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 9:
                                            if (m8511e2 != 86) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 10:
                                            if (m8511e2 != 79) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        case 11:
                                            if (m8511e2 != 80) {
                                                z = true;
                                                break;
                                            }
                                            z = false;
                                            break;
                                        default:
                                            z = true;
                                            break;
                                    }
                                    if (!z) {
                                        i4++;
                                        i3 = i10;
                                        i6 = i10;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    i3 = i5;
                    i4 = 0;
                }
                cVar.mo6567a(i, 2, c0971y, (ArrayList<AbstractC0945a>) null);
                return 2;
            }
        }
        i2 = 0;
        int i52 = i + 2;
        ArrayList<AbstractC0945a> arrayList2 = new ArrayList<>();
        if (i2 == 0) {
        }
        cVar.mo6567a(i, 2, c0971y, (ArrayList<AbstractC0945a>) null);
        return 2;
    }

    /* renamed from: e */
    private int m6594e(int i, c cVar) {
        int m8511e = this.f4524b.m8511e(i + 1);
        int m8512f = this.f4524b.m8512f(i + 2);
        switch (m8511e) {
            case 21:
                cVar.mo6563a(21, i, 4, m8512f, C0975c.f6251f, 0);
                return 4;
            case 22:
                cVar.mo6563a(21, i, 4, m8512f, C0975c.f6252g, 0);
                return 4;
            case 23:
                cVar.mo6563a(21, i, 4, m8512f, C0975c.f6250e, 0);
                return 4;
            case 24:
                cVar.mo6563a(21, i, 4, m8512f, C0975c.f6249d, 0);
                return 4;
            case 25:
                cVar.mo6563a(21, i, 4, m8512f, C0975c.f6260o, 0);
                return 4;
            case 54:
                cVar.mo6563a(54, i, 4, m8512f, C0975c.f6251f, 0);
                return 4;
            case 55:
                cVar.mo6563a(54, i, 4, m8512f, C0975c.f6252g, 0);
                return 4;
            case 56:
                cVar.mo6563a(54, i, 4, m8512f, C0975c.f6250e, 0);
                return 4;
            case 57:
                cVar.mo6563a(54, i, 4, m8512f, C0975c.f6249d, 0);
                return 4;
            case 58:
                cVar.mo6563a(54, i, 4, m8512f, C0975c.f6260o, 0);
                return 4;
            case 132:
                cVar.mo6563a(m8511e, i, 6, m8512f, C0975c.f6251f, this.f4524b.m8506b(i + 4));
                return 6;
            case 169:
                cVar.mo6563a(m8511e, i, 4, m8512f, C0975c.f6256k, 0);
                return 4;
            default:
                cVar.mo6561a(196, i, 1);
                return 1;
        }
    }

    /* compiled from: BytecodeArray.java */
    /* renamed from: com.b.b.a.b.g$a */
    public static class a implements c {

        /* renamed from: a */
        private int f4526a = -1;

        a() {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6561a(int i, int i2, int i3) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6566a(int i, int i2, int i3, C0975c c0975c) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6562a(int i, int i2, int i3, int i4) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6560a(int i) {
            this.f4526a = i;
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public int mo6559a() {
            return this.f4526a;
        }
    }

    /* compiled from: BytecodeArray.java */
    /* renamed from: com.b.b.a.b.g$b */
    class b extends a {

        /* renamed from: a */
        AbstractC0945a f4527a;

        /* renamed from: b */
        int f4528b;

        /* renamed from: c */
        int f4529c;

        b() {
        }

        /* renamed from: b */
        private void m6601b() {
            this.f4528b = 0;
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6561a(int i, int i2, int i3) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6566a(int i, int i2, int i3, C0975c c0975c) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6563a(int i, int i2, int i3, int i4, C0975c c0975c, int i5) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6565a(int i, int i2, int i3, AbstractC0945a abstractC0945a, int i4) {
            this.f4527a = abstractC0945a;
            this.f4528b = i3;
            this.f4529c = i4;
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6562a(int i, int i2, int i3, int i4) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6564a(int i, int i2, int i3, C0727w c0727w, int i4) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6567a(int i, int i2, C0971y c0971y, ArrayList<AbstractC0945a> arrayList) {
            m6601b();
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public void mo6560a(int i) {
        }

        @Override // com.p065b.p086b.p087a.p089b.C0711g.a, com.p065b.p086b.p087a.p089b.C0711g.c
        /* renamed from: a */
        public int mo6559a() {
            return -1;
        }
    }
}
