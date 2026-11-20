package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0575x;
import com.p063a.p064a.C0576y;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: CssLexTask.java */
/* renamed from: ru.maximoff.apktool.a.c */
/* loaded from: classes.dex */
public class C2883c extends AbstractC2881a<C0575x> {

    /* renamed from: c */
    private C0576y.by f14837c;

    /* renamed from: d */
    private final C0576y f14838d;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0575x c0575x) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0575x);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0575x c0575x) {
        a2(c0575x);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0575x mo16892g() {
        return m16896j();
    }

    public C2883c() {
        super(C0575x.f3895f, (C3055a) null);
        this.f14838d = new C0576y((InterfaceC1822af) null);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0575x c0575x) {
        InterfaceC1819ac f2;
        int mo13672a;
        AbstractC1381c.a aVar;
        this.f14837c = (C0576y.by) null;
        while (!this.f9035a && (mo13672a = (f2 = c0575x.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 1:
                    aVar = AbstractC1381c.a.f9003i;
                    break;
                case 2:
                case 13:
                case 16:
                case 21:
                case 42:
                case 44:
                case 45:
                case 46:
                case 59:
                case 61:
                default:
                    aVar = AbstractC1381c.a.f9005k;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 22:
                case 23:
                case 24:
                case 26:
                case 30:
                case 31:
                case 32:
                case 39:
                case 40:
                    aVar = AbstractC1381c.a.f9007m;
                    break;
                case 7:
                case 14:
                case 15:
                case 20:
                case 28:
                case 29:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 17:
                case 18:
                case 19:
                case 27:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 57:
                    aVar = AbstractC1381c.a.f9004j;
                    break;
                case 25:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 41:
                case 43:
                case 47:
                    aVar = AbstractC1381c.a.f9008n;
                    break;
                case 54:
                case 58:
                case 60:
                case 62:
                    aVar = AbstractC1381c.a.f9009o;
                    break;
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0575x c0575x) {
        this.f14838d.m13881a((InterfaceC1822af) new C1864l(c0575x));
        this.f14837c = this.f14838d.m5622e();
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14837c;
    }

    /* renamed from: j */
    protected C0575x m16896j() {
        return new C0575x((InterfaceC1858f) null);
    }
}
