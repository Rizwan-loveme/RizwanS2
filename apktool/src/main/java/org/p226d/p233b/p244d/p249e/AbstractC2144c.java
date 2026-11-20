package org.p226d.p233b.p244d.p249e;

import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2336c;
import org.p226d.p233b.p256f.p261e.C2337d;
import org.p226d.p233b.p256f.p261e.C2338e;
import org.p226d.p233b.p256f.p261e.C2339f;
import org.p226d.p233b.p256f.p261e.C2344k;
import org.p226d.p233b.p256f.p261e.C2345l;
import org.p226d.p233b.p256f.p261e.C2346m;
import org.p226d.p233b.p256f.p261e.C2350q;
import org.p226d.p233b.p256f.p261e.C2351r;
import org.p226d.p233b.p263h.C2388h;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedEncodedValue.java */
/* renamed from: org.d.b.d.e.c */
/* loaded from: classes.dex */
public abstract class AbstractC2144c {
    /* renamed from: a */
    public static InterfaceC2251g m14735a(C2161o c2161o) {
        int a2 = c2161o.m14635a();
        try {
            int i = c2161o.m14651i();
            int i2 = i & 31;
            int i3 = i >>> 5;
            switch (i2) {
                case 0:
                    C2388h.m15099a(i3, 0);
                    return new C2337d((byte) c2161o.m14653k());
                case 1:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 18:
                case 19:
                case 20:
                default:
                    throw new C2453g("Invalid encoded_value type: 0x%x", Integer.valueOf(i2));
                case 2:
                    C2388h.m15099a(i3, 1);
                    return new C2351r((short) c2161o.m14640c(i3 + 1));
                case 3:
                    C2388h.m15099a(i3, 1);
                    return new C2338e((char) c2161o.m14642d(i3 + 1));
                case 4:
                    C2388h.m15099a(i3, 3);
                    return new C2345l(c2161o.m14640c(i3 + 1));
                case 6:
                    C2388h.m15099a(i3, 7);
                    return new C2346m(c2161o.m14648g(i3 + 1));
                case 16:
                    C2388h.m15099a(i3, 3);
                    return new C2344k(Float.intBitsToFloat(c2161o.m14644e(i3 + 1)));
                case 17:
                    C2388h.m15099a(i3, 7);
                    return new C2339f(Double.longBitsToDouble(c2161o.m14645f(i3 + 1)));
                case 21:
                    C2388h.m15099a(i3, 3);
                    return new C2149h(c2161o, i3);
                case 22:
                    C2388h.m15099a(i3, 3);
                    return new C2148g(c2161o, i3);
                case 23:
                    C2388h.m15099a(i3, 3);
                    return new C2150i(c2161o, i3);
                case 24:
                    C2388h.m15099a(i3, 3);
                    return new C2151j(c2161o, i3);
                case 25:
                    C2388h.m15099a(i3, 3);
                    return new C2146e(c2161o, i3);
                case 26:
                    C2388h.m15099a(i3, 3);
                    return new C2147f(c2161o, i3);
                case 27:
                    C2388h.m15099a(i3, 3);
                    return new C2145d(c2161o, i3);
                case 28:
                    C2388h.m15099a(i3, 0);
                    return new C2143b(c2161o);
                case 29:
                    C2388h.m15099a(i3, 0);
                    return new C2142a(c2161o);
                case 30:
                    C2388h.m15099a(i3, 0);
                    return C2350q.f12604a;
                case 31:
                    C2388h.m15099a(i3, 1);
                    return C2336c.m14980a(i3 == 1);
            }
        } catch (Exception e2) {
            throw C2453g.m15520a(e2, "Error while reading encoded value at offset 0x%x", Integer.valueOf(a2));
        }
    }

    /* renamed from: b */
    public static void m14736b(C2161o c2161o) {
        int a2 = c2161o.m14635a();
        try {
            int i = c2161o.m14651i();
            int i2 = i & 31;
            switch (i2) {
                case 0:
                    c2161o.m14654l();
                    return;
                case 1:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 18:
                case 19:
                case 20:
                default:
                    throw new C2453g("Invalid encoded_value type: 0x%x", Integer.valueOf(i2));
                case 2:
                case 3:
                case 4:
                case 6:
                case 16:
                case 17:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    c2161o.m14638b((i >>> 5) + 1);
                    return;
                case 28:
                    C2143b.m14731a(c2161o);
                    return;
                case 29:
                    C2142a.m14728a(c2161o);
                    return;
                case 30:
                case 31:
                    return;
            }
        } catch (Exception e2) {
            throw C2453g.m15520a(e2, "Error while skipping encoded value at offset 0x%x", Integer.valueOf(a2));
        }
    }
}
