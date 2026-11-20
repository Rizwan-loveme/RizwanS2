package org.p210a.p211a.p212a;

import java.util.Locale;
import org.p210a.p211a.p212a.p213a.C1793c;
import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p215c.C1844n;

/* compiled from: LexerNoViableAltException.java */
/* renamed from: org.a.a.a.s */
/* loaded from: classes.dex */
public class C1871s extends C1876x {

    /* renamed from: a */
    private final int f10984a;

    /* renamed from: b */
    private final C1793c f10985b;

    public C1871s(AbstractC1870r abstractC1870r, InterfaceC1858f interfaceC1858f, int i, C1793c c1793c) {
        super(abstractC1870r, interfaceC1858f, null);
        this.f10984a = i;
        this.f10985b = c1793c;
    }

    @Override // org.p210a.p211a.p212a.C1876x
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1858f mo13876b() {
        return (InterfaceC1858f) super.mo13876b();
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str = "";
        if (this.f10984a >= 0 && this.f10984a < mo13876b().mo13719d()) {
            str = C1844n.m13776a(mo13876b().mo13712a(C1839i.m13746a(this.f10984a, this.f10984a)), false);
        }
        return String.format(Locale.getDefault(), "%s('%s')", C1871s.class.getSimpleName(), str);
    }
}
