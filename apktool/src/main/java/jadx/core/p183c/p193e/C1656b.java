package jadx.core.p183c.p193e;

import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p203d.C1745n;
import jadx.core.p203d.InterfaceC1736e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Region.java */
/* renamed from: jadx.core.c.e.b */
/* loaded from: classes.dex */
public final class C1656b extends AbstractC1651a {

    /* renamed from: a */
    private final List<InterfaceC1642h> f10439a;

    public C1656b(InterfaceC1644j interfaceC1644j) {
        super(interfaceC1644j);
        this.f10439a = new ArrayList(1);
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        return this.f10439a;
    }

    /* renamed from: a */
    public void m12715a(InterfaceC1642h interfaceC1642h) {
        m12669a(interfaceC1642h, (InterfaceC1644j) this);
        this.f10439a.add(interfaceC1642h);
    }

    @Override // jadx.core.p183c.p193e.AbstractC1651a, jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: a */
    public boolean mo12573a(InterfaceC1642h interfaceC1642h, InterfaceC1642h interfaceC1642h2) {
        int indexOf = this.f10439a.indexOf(interfaceC1642h);
        if (indexOf == -1) {
            return false;
        }
        this.f10439a.set(indexOf, interfaceC1642h2);
        m12669a(interfaceC1642h2, (InterfaceC1644j) this);
        return true;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        StringBuilder sb = new StringBuilder();
        int size = this.f10439a.size();
        sb.append('(');
        sb.append(size);
        if (size > 0) {
            sb.append(':');
            C1745n.m13316a(sb, this.f10439a, "|", new InterfaceC1736e<InterfaceC1642h, String>() { // from class: jadx.core.c.e.b.1
                @Override // jadx.core.p203d.InterfaceC1736e
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public String mo12561a(InterfaceC1642h interfaceC1642h) {
                    return interfaceC1642h.mo12454r();
                }
            });
        }
        sb.append(')');
        return sb.toString();
    }

    public String toString() {
        return "R" + mo12454r();
    }
}
