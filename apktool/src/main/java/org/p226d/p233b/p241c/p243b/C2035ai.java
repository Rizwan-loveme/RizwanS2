package org.p226d.p233b.p241c.p243b;

import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1156ai;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2065e;
import org.p226d.p233b.p241c.C2068h;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;

/* compiled from: BuilderPackedSwitchPayload.java */
/* renamed from: org.d.b.c.b.ai */
/* loaded from: classes.dex */
public class C2035ai extends AbstractC2065e implements InterfaceC2186ai {

    /* renamed from: d */
    public static final EnumC2272f f11633d = EnumC2272f.PACKED_SWITCH_PAYLOAD;

    /* renamed from: e */
    protected final List<C2037ak> f11634e;

    public C2035ai(int i, List<? extends C2068h> list) {
        super(f11633d);
        if (list == null) {
            this.f11634e = AbstractC1208w.m10138g();
            return;
        }
        this.f11634e = C1156ai.m9909a();
        Iterator<? extends C2068h> it = list.iterator();
        while (it.hasNext()) {
            this.f11634e.add(new C2037ak(this, i, it.next()));
            i++;
        }
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2228p
    /* renamed from: f */
    public List<C2037ak> mo14496f() {
        return this.f11634e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (this.f11634e.size() * 2) + 4;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11633d.f12386ei;
    }
}
