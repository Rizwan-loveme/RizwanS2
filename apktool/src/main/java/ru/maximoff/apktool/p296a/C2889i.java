package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0566o;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1858f;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: ObjcLexTask.java */
/* renamed from: ru.maximoff.apktool.a.i */
/* loaded from: classes.dex */
public class C2889i extends AbstractC2881a<C0566o> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0566o c0566o) {
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0566o c0566o) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0566o);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0566o c0566o) {
        a2(c0566o);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0566o mo16892g() {
        return m16906j();
    }

    public C2889i() {
        super(C0566o.f3791f, (C3055a) null);
    }

    /* renamed from: j */
    protected C0566o m16906j() {
        return new C0566o((InterfaceC1858f) null);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0566o c0566o) {
        InterfaceC1819ac f2;
        int mo13672a;
        AbstractC1381c.a aVar;
        while (!this.f9035a && (mo13672a = (f2 = c0566o.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                case 17:
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 33:
                case 34:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 51:
                case 52:
                case 55:
                case 56:
                case 81:
                case 82:
                case 83:
                case 95:
                    aVar = AbstractC1381c.a.f9004j;
                    break;
                case 4:
                case 9:
                case 13:
                case 18:
                case 19:
                case 23:
                case 32:
                case 35:
                case 36:
                case 37:
                case 40:
                case 41:
                case 53:
                case 54:
                    aVar = AbstractC1381c.a.f9010p;
                    break;
                case 31:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
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
                case 169:
                case 170:
                case 178:
                case 181:
                default:
                    if (mo13672a >= 126 && mo13672a <= 170) {
                        aVar = AbstractC1381c.a.f9007m;
                        break;
                    } else {
                        aVar = AbstractC1381c.a.f9005k;
                        break;
                    }
                    break;
                case 38:
                case 39:
                case 48:
                case 49:
                case 50:
                case 57:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 182:
                case 183:
                case 184:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                    aVar = AbstractC1381c.a.f9009o;
                    break;
                case 179:
                case 180:
                    aVar = AbstractC1381c.a.f9003i;
                    break;
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }
}
