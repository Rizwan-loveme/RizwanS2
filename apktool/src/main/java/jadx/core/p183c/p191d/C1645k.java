package jadx.core.p183c.p191d;

import jadx.core.p183c.p184a.AbstractC1584d;
import java.util.List;

/* compiled from: InsnContainer.java */
/* renamed from: jadx.core.c.d.k */
/* loaded from: classes.dex */
public class C1645k extends AbstractC1584d implements InterfaceC1640f {

    /* renamed from: a */
    private final List<C1646l> f10366a;

    public C1645k(List<C1646l> list) {
        this.f10366a = list;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1640f
    /* renamed from: j */
    public List<C1646l> mo12446j() {
        return this.f10366a;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return Integer.toString(this.f10366a.size());
    }

    public String toString() {
        return "InsnContainer:" + this.f10366a.size();
    }
}
