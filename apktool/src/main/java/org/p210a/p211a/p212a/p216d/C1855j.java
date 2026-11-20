package org.p210a.p211a.p212a.p216d;

import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.InterfaceC1819ac;

/* compiled from: TerminalNodeImpl.java */
/* renamed from: org.a.a.a.d.j */
/* loaded from: classes.dex */
public class C1855j implements InterfaceC1854i {

    /* renamed from: a */
    public InterfaceC1819ac f10914a;

    /* renamed from: b */
    public InterfaceC1849d f10915b;

    public C1855j(InterfaceC1819ac interfaceC1819ac) {
        this.f10914a = interfaceC1819ac;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: b */
    public InterfaceC1849d mo13785b(int i) {
        return null;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1854i
    /* renamed from: a */
    public InterfaceC1819ac mo13792a() {
        return this.f10914a;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: b */
    public void mo13786b(C1878z c1878z) {
        this.f10915b = c1878z;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1856k
    /* renamed from: k */
    public int mo13793k() {
        return 0;
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: a */
    public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
        return interfaceC1851f.mo13783a(this);
    }

    @Override // org.p210a.p211a.p212a.p216d.InterfaceC1849d
    /* renamed from: n */
    public String mo13787n() {
        return this.f10914a.mo13673b();
    }

    public String toString() {
        return this.f10914a.mo13672a() == -1 ? "<EOF>" : this.f10914a.mo13673b();
    }
}
