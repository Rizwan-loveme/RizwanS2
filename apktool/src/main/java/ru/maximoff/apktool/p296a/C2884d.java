package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0558g;
import com.p063a.p064a.C0559h;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: JavaLexTask.java */
/* renamed from: ru.maximoff.apktool.a.d */
/* loaded from: classes.dex */
public class C2884d extends AbstractC2881a<C0558g> {

    /* renamed from: c */
    private C0559h.w f14839c;

    /* renamed from: d */
    private final C0559h f14840d;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0558g c0558g) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0558g);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0558g c0558g) {
        a2(c0558g);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0558g mo16892g() {
        return m16897j();
    }

    /* renamed from: j */
    protected C0558g m16897j() {
        return new C0558g((InterfaceC1858f) null);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0558g c0558g) {
        InterfaceC1819ac f2;
        int mo13672a;
        AbstractC1381c.a aVar;
        this.f14839c = (C0559h.w) null;
        boolean z = false;
        while (!this.f9035a && (mo13672a = (f2 = c0558g.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 0:
                    aVar = AbstractC1381c.a.f9013s;
                    break;
                case 1:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 22:
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 33:
                case 34:
                case 35:
                case 36:
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
                case 49:
                case 50:
                    aVar = AbstractC1381c.a.f9004j;
                    break;
                case 3:
                case 5:
                case 8:
                case 14:
                case 20:
                case 27:
                case 29:
                case 37:
                case 48:
                    aVar = AbstractC1381c.a.f9010p;
                    break;
                case 25:
                case 32:
                    aVar = AbstractC1381c.a.f9004j;
                    z = true;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 68:
                case 69:
                    aVar = AbstractC1381c.a.f9008n;
                    break;
                case 67:
                    aVar = AbstractC1381c.a.f9008n;
                    z = false;
                    break;
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
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                    aVar = AbstractC1381c.a.f9007m;
                    break;
                case 87:
                    if (z) {
                        aVar = AbstractC1381c.a.f9009o;
                        break;
                    } else {
                        aVar = AbstractC1381c.a.f9007m;
                        break;
                    }
                case 108:
                default:
                    aVar = AbstractC1381c.a.f9005k;
                    break;
                case 109:
                case 110:
                    aVar = AbstractC1381c.a.f9003i;
                    break;
                case 111:
                    if (z) {
                        aVar = AbstractC1381c.a.f9009o;
                        break;
                    } else {
                        aVar = AbstractC1381c.a.f9005k;
                        break;
                    }
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0558g c0558g) {
        this.f14840d.m13881a((InterfaceC1822af) new C1864l(c0558g));
        this.f14839c = this.f14840d.m4595e();
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14839c;
    }

    public C2884d() {
        super(C0558g.f3741f, (C3055a) null);
        this.f14839c = (C0559h.w) null;
        this.f14840d = new C0559h((InterfaceC1822af) null);
    }
}
