package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p203d.p205b.C1725b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;
import org.p226d.p233b.p250e.p255d.InterfaceC2249e;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;
import org.p226d.p233b.p250e.p255d.InterfaceC2254j;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;
import org.p226d.p233b.p250e.p255d.InterfaceC2256l;
import org.p226d.p233b.p250e.p255d.InterfaceC2257m;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;
import org.p226d.p233b.p250e.p255d.InterfaceC2263s;

/* compiled from: EncValueParser.java */
/* renamed from: jadx.core.c.d.a.c */
/* loaded from: classes.dex */
public class C1631c {

    /* renamed from: a */
    private final C1637c f10318a;

    public C1631c(C1637c c1637c) {
        this.f10318a = c1637c;
    }

    /* renamed from: a */
    public Object m12467a(InterfaceC2251g interfaceC2251g) {
        int mo14430a = interfaceC2251g.mo14430a();
        switch (mo14430a) {
            case 0:
                return Byte.valueOf(((InterfaceC2248d) interfaceC2251g).mo14861b());
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
            case 21:
            case 22:
            default:
                throw new C1725b("Unknown encoded value type: 0x" + Integer.toHexString(mo14430a));
            case 2:
                return Short.valueOf(((InterfaceC2261q) interfaceC2251g).mo14867b());
            case 3:
                return Character.valueOf(((InterfaceC2249e) interfaceC2251g).mo14862b());
            case 4:
                return Integer.valueOf(((InterfaceC2255k) interfaceC2251g).mo14865b());
            case 6:
                return Long.valueOf(((InterfaceC2256l) interfaceC2251g).mo14866b());
            case 16:
                return Float.valueOf(((InterfaceC2254j) interfaceC2251g).mo14864b());
            case 17:
                return Double.valueOf(((InterfaceC2250f) interfaceC2251g).mo14863b());
            case 23:
                return ((InterfaceC2262r) interfaceC2251g).mo14742b();
            case 24:
                return this.f10318a.m12547a(((InterfaceC2263s) interfaceC2251g).mo14743b());
            case 25:
            case 27:
                return C1592d.m12224a(this.f10318a, ((InterfaceC2253i) interfaceC2251g).mo14738b());
            case 26:
                return C1594f.m12238a(this.f10318a, ((InterfaceC2257m) interfaceC2251g).mo14739b());
            case 28:
                List<? extends InterfaceC2251g> mo14733b = ((InterfaceC2246b) interfaceC2251g).mo14733b();
                ArrayList arrayList = new ArrayList(mo14733b.size());
                Iterator<? extends InterfaceC2251g> it = mo14733b.iterator();
                while (it.hasNext()) {
                    arrayList.add(m12467a(it.next()));
                }
                return arrayList;
            case 29:
                return C1629a.m12455a(this.f10318a, (InterfaceC2245a) interfaceC2251g, false);
            case 30:
                return null;
            case 31:
                return Boolean.valueOf(((InterfaceC2247c) interfaceC2251g).mo14860b());
        }
    }
}
