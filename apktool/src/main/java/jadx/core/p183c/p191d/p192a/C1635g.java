package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: StaticValuesParser.java */
/* renamed from: jadx.core.c.d.a.g */
/* loaded from: classes.dex */
public class C1635g extends C1631c {
    public C1635g(C1637c c1637c) {
        super(c1637c);
    }

    /* renamed from: a */
    public int m12502a(List<C1639e> list, Iterable<? extends InterfaceC2266g> iterable) {
        Iterator<? extends InterfaceC2266g> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            InterfaceC2251g mo14223b = it.next().mo14223b();
            if (mo14223b != null) {
                list.get(i).mo12144a(C1632d.m12469a(m12467a(mo14223b)));
                i++;
            }
        }
        return i;
    }
}
