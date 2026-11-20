package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0555d;
import com.p063a.p064a.C0556e;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1388j;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import org.p210a.p211a.p212a.C1862j;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: JsonLexTask.java */
/* renamed from: ru.maximoff.apktool.a.f */
/* loaded from: classes.dex */
public class C2886f extends AbstractC2881a<C0555d> {

    /* renamed from: c */
    private final C0556e f14843c;

    /* renamed from: d */
    private C0556e.b f14844d;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ int mo16887a(C1388j c1388j, C0555d c0555d, int i, int i2) {
        return a2(c1388j, c0555d, i, i2);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0555d c0555d) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0555d);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0555d c0555d) {
        a2(c0555d);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0555d mo16892g() {
        return m16899j();
    }

    public C2886f() {
        super(new C2888h(), (C3055a) null);
        this.f14843c = new C0556e((InterfaceC1822af) null);
        this.f14844d = (C0556e.b) null;
    }

    /* renamed from: j */
    protected C0555d m16899j() {
        return new C0555d((InterfaceC1858f) null);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0555d c0555d) {
        InterfaceC1819ac f2;
        int mo13672a;
        AbstractC1381c.a aVar;
        this.f14844d = (C0556e.b) null;
        boolean z = false;
        boolean z2 = false;
        while (!this.f9035a && (mo13672a = (f2 = c0555d.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 1:
                case 2:
                case 3:
                case 11:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
                case 4:
                    if (z2 && !z) {
                        aVar = AbstractC1381c.a.f9004j;
                        break;
                    } else {
                        aVar = AbstractC1381c.a.f9006l;
                        break;
                    }
                case 5:
                case 9:
                    aVar = AbstractC1381c.a.f9008n;
                    z2 = true;
                    break;
                case 6:
                case 8:
                case 10:
                    aVar = AbstractC1381c.a.f9008n;
                    z = false;
                    z2 = false;
                    break;
                case 7:
                    aVar = AbstractC1381c.a.f9008n;
                    z = true;
                    break;
                default:
                    aVar = AbstractC1381c.a.f9005k;
                    break;
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0555d c0555d) {
        this.f14843c.m13881a((InterfaceC1822af) new C1864l(c0555d));
        this.f14844d = this.f14843c.m4496e();
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: d */
    public boolean mo11092d() {
        return true;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected int a2(C1388j c1388j, C0555d c0555d, int i, int i2) {
        int i3 = -1;
        int i4 = -1;
        while (true) {
            C1862j c1862j = (C1862j) c0555d.mo4722f();
            int mo13672a = c1862j.mo13672a();
            if (mo13672a != -1) {
                switch (mo13672a) {
                    case 5:
                        c1388j.m11073a(i);
                        c1388j.m11070a("{\n");
                        break;
                    case 6:
                        c1388j.m11077b(i);
                        c1388j.m11070a("\n}");
                        break;
                    case 7:
                        c1388j.m11073a(i);
                        c1388j.m11070a("[\n");
                        break;
                    case 8:
                        c1388j.m11077b(i);
                        c1388j.m11070a("]");
                        break;
                    case 9:
                        c1388j.m11070a(",\n");
                        break;
                    case 10:
                        c1388j.m11070a(" : ");
                        break;
                    case 11:
                    default:
                        c1388j.m11070a((CharSequence) c1862j.mo13673b());
                        break;
                    case 12:
                        break;
                }
                int mo13678g = c1862j.mo13678g();
                i4 = AbstractC2881a.m16884a(c1388j.length(), i3, mo13678g, i2, i4);
                i3 = mo13678g;
            } else {
                return i4;
            }
        }
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14844d;
    }
}
