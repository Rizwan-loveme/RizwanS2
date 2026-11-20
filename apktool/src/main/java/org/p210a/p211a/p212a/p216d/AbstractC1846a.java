package org.p210a.p211a.p212a.p216d;

/* compiled from: AbstractParseTreeVisitor.java */
/* renamed from: org.a.a.a.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC1846a<T> implements InterfaceC1851f<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1851f
    /* renamed from: a */
    public T mo13782a(InterfaceC1852g interfaceC1852g) {
        T t = (T) m13779a();
        int k = interfaceC1852g.mo13793k();
        for (int i = 0; i < k && m13784a(interfaceC1852g, (InterfaceC1852g) t); i++) {
            t = (T) m13780a(t, interfaceC1852g.mo13785b(i).mo4289a(this));
        }
        return t;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1851f
    /* renamed from: a */
    public T mo13783a(InterfaceC1854i interfaceC1854i) {
        return m13779a();
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1851f
    /* renamed from: a */
    public T mo13781a(InterfaceC1847b interfaceC1847b) {
        return m13779a();
    }

    /* renamed from: a */
    protected T m13779a() {
        return null;
    }

    /* renamed from: a */
    protected T m13780a(T t, T t2) {
        return t2;
    }

    /* renamed from: a */
    protected boolean m13784a(InterfaceC1852g interfaceC1852g, T t) {
        return true;
    }
}
