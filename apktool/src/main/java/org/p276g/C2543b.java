package org.p276g;

import java.util.concurrent.ConcurrentHashMap;
import org.p276g.p277a.InterfaceC2532a;
import org.p276g.p283b.InterfaceC2545b;

/* compiled from: ObjenesisBase.java */
/* renamed from: org.g.b */
/* loaded from: classes.dex */
public class C2543b implements InterfaceC2531a {

    /* renamed from: a */
    protected final InterfaceC2545b f13306a;

    /* renamed from: b */
    protected ConcurrentHashMap<String, InterfaceC2532a<?>> f13307b;

    public C2543b(InterfaceC2545b interfaceC2545b) {
        this(interfaceC2545b, true);
    }

    public C2543b(InterfaceC2545b interfaceC2545b, boolean z) {
        if (interfaceC2545b == null) {
            throw new IllegalArgumentException("A strategy can't be null");
        }
        this.f13306a = interfaceC2545b;
        this.f13307b = z ? new ConcurrentHashMap<>() : null;
    }

    public String toString() {
        return getClass().getName() + " using " + this.f13306a.getClass().getName() + (this.f13307b == null ? " without" : " with") + " caching";
    }

    @Override // org.p276g.InterfaceC2531a
    /* renamed from: a */
    public <T> T mo15906a(Class<T> cls) {
        return m15920b(cls).mo15907a();
    }

    /* renamed from: b */
    public <T> InterfaceC2532a<T> m15920b(Class<T> cls) {
        if (this.f13307b == null) {
            return this.f13306a.mo15921a(cls);
        }
        InterfaceC2532a<T> interfaceC2532a = (InterfaceC2532a) this.f13307b.get(cls.getName());
        if (interfaceC2532a == null) {
            InterfaceC2532a<T> mo15921a = this.f13306a.mo15921a(cls);
            InterfaceC2532a<T> interfaceC2532a2 = (InterfaceC2532a) this.f13307b.putIfAbsent(cls.getName(), mo15921a);
            return interfaceC2532a2 == null ? mo15921a : interfaceC2532a2;
        }
        return interfaceC2532a;
    }
}
