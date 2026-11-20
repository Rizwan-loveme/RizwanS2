package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0568q;
import com.p063a.p064a.C0569r;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.C1388j;
import com.p159h.p160a.p162b.C1397s;
import java.util.ArrayList;
import java.util.List;
import org.p210a.p211a.p212a.C1830c;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.InterfaceC2244d;
import ru.maximoff.apktool.service.C3055a;
import ru.maximoff.apktool.service.C3057c;
import ru.maximoff.apktool.service.C3059e;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.p295a.C2608a;

/* compiled from: SmaliLexTask.java */
/* renamed from: ru.maximoff.apktool.a.l */
/* loaded from: classes.dex */
public class C2892l extends AbstractC2881a<C0568q> {

    /* renamed from: c */
    private final C0569r f14853c;

    /* renamed from: d */
    private final C1864l f14854d;

    /* renamed from: e */
    private final C0568q f14855e;

    /* renamed from: f */
    private final C3055a f14856f;

    /* renamed from: g */
    private C0569r.gb f14857g;

    /* renamed from: h */
    private boolean f14858h;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    public /* bridge */ int mo16887a(C1388j c1388j, C0568q c0568q, int i, int i2) {
        return a2(c1388j, c0568q, i, i2);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    public /* bridge */ void mo16888a(List list, C0568q c0568q) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0568q);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0568q c0568q) {
        a2(c0568q);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0568q mo16892g() {
        return m16930l();
    }

    public C2892l(C3055a c3055a) {
        super(new a(), c3055a);
        this.f14858h = false;
        this.f14856f = c3055a;
        this.f14853c = new C0569r((InterfaceC1822af) null);
        if (c3055a != null) {
            this.f14853c.m13927cD();
            this.f14853c.m13925a(c3055a);
        }
        this.f14855e = m16930l();
        this.f14854d = new C1864l(this.f14855e);
        this.f14857g = (C0569r.gb) null;
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14857g;
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: h */
    protected void mo16893h() {
        C3059e.m18234c().m18245b();
    }

    /* renamed from: j */
    public InterfaceC2244d m16928j() {
        return this.f14853c.m13898cr() > 0 ? (InterfaceC2244d) null : C2608a.m16250a(this.f14857g, this.f14854d, m16929k());
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: a */
    public boolean mo11089a(int i) {
        C3055a c3055a = this.f14856f;
        if (c3055a == null) {
            return false;
        }
        return c3055a.m18181b(i);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: f */
    protected boolean mo16891f() {
        return true;
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected void mo16889a(C1830c c1830c) {
        this.f14855e.m13860a(c1830c);
        a2(this.f14855e);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0568q c0568q) {
        this.f14854d.m13797a(c0568q);
        this.f14853c.m13881a((InterfaceC1822af) this.f14854d);
        C0569r.gb m5233e = this.f14853c.m5233e();
        this.f14857g = m5233e;
        if (this.f14853c.m13898cr() != 0 || this.f14856f == null) {
            return;
        }
        C3057c.m18203a(m5233e, this.f14854d, true);
        C3059e.m18234c().m18239a(this.f14856f, m5233e, this.f14854d, false, true);
    }

    /* renamed from: k */
    public C2359g m16929k() {
        return C2359g.m15023a(this.f14858h ? 26 : 14);
    }

    /* renamed from: l */
    protected C0568q m16930l() {
        C0568q c0568q = new C0568q((InterfaceC1858f) null);
        if (this.f14856f != null) {
            c0568q.m13927cD();
            c0568q.m13925a(this.f14856f);
        }
        return c0568q;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(List<C1397s<AbstractC1381c.a>> list, C0568q c0568q) {
        InterfaceC1819ac f2;
        int mo13672a;
        boolean z;
        AbstractC1381c.a aVar;
        if (this.f14856f != null) {
            this.f14856f.mo17859b();
        }
        boolean z2 = false;
        boolean z3 = false;
        while (!this.f9035a && (mo13672a = (f2 = c0568q.mo4722f()).mo13672a()) != -1) {
            switch (mo13672a) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
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
                    aVar = AbstractC1381c.a.f9009o;
                    continue;
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
                    aVar = AbstractC1381c.a.f9006l;
                    continue;
                case 45:
                case 114:
                case 115:
                case 116:
                case 118:
                case 124:
                    aVar = AbstractC1381c.a.f9007m;
                    continue;
                case 46:
                case 47:
                    aVar = AbstractC1381c.a.f9004j;
                    continue;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 57:
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
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 113:
                default:
                    z = z3;
                    break;
                case 54:
                    aVar = AbstractC1381c.a.f9003i;
                    continue;
                case 90:
                case 97:
                    aVar = AbstractC1381c.a.f9004j;
                    z2 = true;
                    continue;
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                    aVar = AbstractC1381c.a.f9010p;
                    continue;
                case 112:
                    if (z3) {
                        aVar = AbstractC1381c.a.f9007m;
                    } else {
                        aVar = AbstractC1381c.a.f9005k;
                    }
                    z3 = false;
                    continue;
                case 117:
                    aVar = AbstractC1381c.a.f9007m;
                    z3 = true;
                    continue;
                case 119:
                case 120:
                case 121:
                case 122:
                    aVar = AbstractC1381c.a.f9008n;
                    continue;
                case 123:
                    z = false;
                    break;
                case 125:
                    aVar = AbstractC1381c.a.f9013s;
                    continue;
            }
            if (mo13672a >= 55 && mo13672a <= 105) {
                aVar = AbstractC1381c.a.f9004j;
            } else {
                aVar = AbstractC1381c.a.f9005k;
            }
            z3 = z;
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
        this.f14858h = z2;
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: d */
    public boolean mo11092d() {
        return true;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(C1388j c1388j, C0568q c0568q, int i, int i2) {
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            InterfaceC1819ac f2 = c0568q.mo4722f();
            int mo13672a = f2.mo13672a();
            if (mo13672a != -1) {
                String mo13673b = f2.mo13673b();
                switch (mo13672a) {
                    case 5:
                    case 25:
                    case 27:
                        c1388j.m11070a((CharSequence) mo13673b);
                        i5 = mo13672a;
                        break;
                    case 6:
                    case 8:
                    case 10:
                    case 13:
                    case 17:
                    case 19:
                    case 21:
                    case 26:
                    case 28:
                    case 120:
                        c1388j.m11077b(i);
                        c1388j.m11070a((CharSequence) mo13673b);
                        break;
                    case 7:
                    case 12:
                    case 16:
                    case 18:
                    case 20:
                    case 119:
                        c1388j.m11070a((CharSequence) mo13673b);
                        c1388j.m11073a(i);
                        break;
                    case 9:
                        if (i5 == 5 || i5 == 27 || i5 == 25) {
                            c1388j.m11073a(i);
                        }
                        i5 = 0;
                        c1388j.m11070a((CharSequence) mo13673b);
                        c1388j.m11073a(i);
                        break;
                    case 43:
                        C2891k.m16927a(c1388j, mo13673b, true);
                        break;
                    case 44:
                        C2891k.m16927a(c1388j, mo13673b, false);
                        break;
                    case 123:
                        C2891k.m16926a(c1388j, mo13673b);
                        break;
                    default:
                        c1388j.m11070a((CharSequence) mo13673b);
                        break;
                }
                if (mo13672a != 5 || mo13672a != 27 || mo13672a != 25) {
                    i5 = 0;
                }
                int mo13678g = f2.mo13678g() + 1;
                i3 = AbstractC2881a.m16884a(c1388j.length(), i4, mo13678g, i2, i3);
                i4 = mo13678g;
            } else {
                if (i3 == -1) {
                    return c1388j.length() - 1;
                }
                return i3;
            }
        }
    }

    /* compiled from: SmaliLexTask.java */
    /* renamed from: ru.maximoff.apktool.a.l$a */
    private static class a extends AbstractC1389k {
        a() {
            if (!C3102bd.f18308ap) {
                m11079a(new String[0]);
                return;
            }
            EnumC2272f[] values = EnumC2272f.values();
            int length = values.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = values[i].f12384eg;
            }
            m11079a(strArr);
        }

        @Override // com.p159h.p160a.p162b.AbstractC1389k
        /* renamed from: a */
        public CharSequence mo11078a(ArrayList<String> arrayList, CharSequence charSequence) {
            if (!C3102bd.f18308ap || charSequence.charAt(0) != 'L') {
                return super.mo11078a(arrayList, charSequence);
            }
            String charSequence2 = charSequence.toString();
            int indexOf = charSequence2.indexOf(59);
            if (indexOf == -1) {
                String lowerCase = charSequence2.toLowerCase();
                if (lowerCase.startsWith("[")) {
                    lowerCase.lastIndexOf(91);
                }
                for (String str : C2890j.m16917b()) {
                    if (str.toLowerCase().startsWith(lowerCase)) {
                        arrayList.add(str);
                    }
                }
                return lowerCase;
            }
            String substring = charSequence2.substring(indexOf + 1);
            if (substring.startsWith("->")) {
                String lowerCase2 = substring.substring(2).toLowerCase();
                for (String str2 : C2890j.m16908a(charSequence2.substring(0, indexOf + 1))) {
                    if (str2.toLowerCase().startsWith(lowerCase2)) {
                        arrayList.add(str2);
                    }
                }
                return lowerCase2;
            }
            return substring;
        }
    }
}
