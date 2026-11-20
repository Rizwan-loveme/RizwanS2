package org.p226d.p233b.p241c.p243b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;

/* compiled from: BuilderArrayPayload.java */
/* renamed from: org.d.b.c.b.a */
/* loaded from: classes.dex */
public class C2026a extends AbstractC2063c implements InterfaceC2177a {

    /* renamed from: c */
    public static final EnumC2272f f11585c = EnumC2272f.ARRAY_PAYLOAD;

    /* renamed from: d */
    protected final int f11586d;

    /* renamed from: e */
    protected final List<Number> f11587e;

    public C2026a(int i, List<Number> list) {
        super(f11585c);
        this.f11586d = i;
        this.f11587e = list == null ? AbstractC1208w.m10138g() : list;
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: e */
    public int mo14479e() {
        return this.f11586d;
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: f */
    public List<Number> mo14480f() {
        return this.f11587e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (((this.f11586d * this.f11587e.size()) + 1) / 2) + 4;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11585c.f12386ei;
    }
}
