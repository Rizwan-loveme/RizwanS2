package org.p226d.p233b.p244d.p249e;

import java.util.List;
import org.p226d.p233b.p238b.p240b.AbstractC1996b;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p244d.p248d.AbstractC2137h;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: DexBackedArrayEncodedValue.java */
/* renamed from: org.d.b.d.e.b */
/* loaded from: classes.dex */
public class C2143b extends AbstractC1996b implements InterfaceC2246b {

    /* renamed from: a */
    public final C2153g f11930a;

    /* renamed from: b */
    private final int f11931b;

    /* renamed from: c */
    private final int f11932c;

    public C2143b(C2161o c2161o) {
        this.f11930a = (C2153g) c2161o.f11828a;
        this.f11931b = c2161o.m14639c();
        this.f11932c = c2161o.m14635a();
        m14732a(c2161o, this.f11931b);
    }

    /* renamed from: a */
    public static void m14731a(C2161o c2161o) {
        m14732a(c2161o, c2161o.m14639c());
    }

    /* renamed from: a */
    private static void m14732a(C2161o c2161o, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC2144c.m14736b(c2161o);
        }
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2246b
    /* renamed from: b */
    public List<? extends InterfaceC2251g> mo14733b() {
        return new AbstractC2137h<InterfaceC2251g>(this.f11930a, this.f11932c, this.f11931b) { // from class: org.d.b.d.e.b.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2137h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC2251g mo14725b(C2161o c2161o, int i) {
                return AbstractC2144c.m14735a(c2161o);
            }
        };
    }
}
