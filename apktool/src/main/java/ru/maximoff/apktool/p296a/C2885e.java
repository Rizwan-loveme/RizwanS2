package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0563l;
import com.p063a.p064a.C0564m;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: JavascriptLexTask.java */
/* renamed from: ru.maximoff.apktool.a.e */
/* loaded from: classes.dex */
public class C2885e extends AbstractC2881a<C0563l> {

    /* renamed from: c */
    private C0564m.cc f14841c;

    /* renamed from: d */
    private final C0564m f14842d;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0563l c0563l) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0563l);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0563l c0563l) {
        a2(c0563l);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0563l mo16892g() {
        return m16898j();
    }

    public C2885e() {
        super(C0563l.f3773f, (C3055a) null);
        this.f14842d = new C0564m((InterfaceC1822af) null);
    }

    /* renamed from: j */
    protected C0563l m16898j() {
        return new C0563l((InterfaceC1858f) null);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0563l c0563l) {
        InterfaceC1819ac f2;
        int mo13672a;
        AbstractC1381c.a aVar;
        this.f14841c = (C0564m.cc) null;
        while (!this.f9035a && (mo13672a = (f2 = c0563l.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 1:
                case 2:
                case 108:
                case 109:
                    aVar = AbstractC1381c.a.f9003i;
                    break;
                case 3:
                case 103:
                case 106:
                case 107:
                default:
                    aVar = AbstractC1381c.a.f9005k;
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    aVar = AbstractC1381c.a.f9008n;
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                    aVar = AbstractC1381c.a.f9007m;
                    break;
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 104:
                case 105:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
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
                case 81:
                case 82:
                case 83:
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
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                    aVar = AbstractC1381c.a.f9004j;
                    break;
                case 110:
                    aVar = AbstractC1381c.a.f9013s;
                    break;
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0563l c0563l) {
        this.f14842d.m13881a((InterfaceC1822af) new C1864l(c0563l));
        this.f14841c = this.f14842d.m4810i();
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14841c;
    }
}
