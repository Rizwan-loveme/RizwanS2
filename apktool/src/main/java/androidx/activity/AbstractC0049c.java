package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.java */
/* renamed from: androidx.activity.c */
/* loaded from: classes.dex */
public abstract class AbstractC0049c {

    /* renamed from: a */
    private boolean f385a;

    /* renamed from: b */
    private CopyOnWriteArrayList<InterfaceC0045a> f386b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public abstract void mo308c();

    public AbstractC0049c(boolean z) {
        this.f385a = z;
    }

    /* renamed from: a */
    public final void m304a(boolean z) {
        this.f385a = z;
    }

    /* renamed from: a */
    public final boolean m305a() {
        return this.f385a;
    }

    /* renamed from: b */
    public final void m306b() {
        Iterator<InterfaceC0045a> it = this.f386b.iterator();
        while (it.hasNext()) {
            it.next().mo288a();
        }
    }

    /* renamed from: a */
    void m303a(InterfaceC0045a interfaceC0045a) {
        this.f386b.add(interfaceC0045a);
    }

    /* renamed from: b */
    void m307b(InterfaceC0045a interfaceC0045a) {
        this.f386b.remove(interfaceC0045a);
    }
}
