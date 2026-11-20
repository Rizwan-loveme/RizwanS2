package org.p285i.p286a;

import java.util.Queue;
import org.p285i.InterfaceC2558b;
import org.p285i.InterfaceC2572d;
import org.p285i.p287b.C2565g;

/* compiled from: EventRecodingLogger.java */
/* renamed from: org.i.a.a */
/* loaded from: classes.dex */
public class C2554a implements InterfaceC2558b {

    /* renamed from: a */
    String f13315a;

    /* renamed from: b */
    C2565g f13316b;

    /* renamed from: c */
    Queue<C2557d> f13317c;

    public C2554a(C2565g c2565g, Queue<C2557d> queue) {
        this.f13316b = c2565g;
        this.f13315a = c2565g.mo15929a();
        this.f13317c = queue;
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public String mo15929a() {
        return this.f13315a;
    }

    /* renamed from: a */
    private void m15927a(EnumC2555b enumC2555b, String str, Object[] objArr, Throwable th) {
        m15928a(enumC2555b, null, str, objArr, th);
    }

    /* renamed from: a */
    private void m15928a(EnumC2555b enumC2555b, InterfaceC2572d interfaceC2572d, String str, Object[] objArr, Throwable th) {
        C2557d c2557d = new C2557d();
        c2557d.m15948a(System.currentTimeMillis());
        c2557d.m15951a(enumC2555b);
        c2557d.m15952a(this.f13316b);
        c2557d.m15949a(this.f13315a);
        c2557d.m15953a(interfaceC2572d);
        c2557d.m15955b(str);
        c2557d.m15954a(objArr);
        c2557d.m15950a(th);
        c2557d.m15956c(Thread.currentThread().getName());
        this.f13317c.add(c2557d);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public boolean mo15940b() {
        return true;
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15930a(String str) {
        m15927a(EnumC2555b.TRACE, str, null, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15931a(String str, Object obj) {
        m15927a(EnumC2555b.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15932a(String str, Object obj, Object obj2) {
        m15927a(EnumC2555b.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15934a(String str, Object... objArr) {
        m15927a(EnumC2555b.DEBUG, str, objArr, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15933a(String str, Throwable th) {
        m15927a(EnumC2555b.DEBUG, str, null, th);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15935b(String str) {
        m15927a(EnumC2555b.INFO, str, null, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15936b(String str, Object obj) {
        m15927a(EnumC2555b.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15941c(String str) {
        m15927a(EnumC2555b.WARN, str, null, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15942c(String str, Object obj) {
        m15927a(EnumC2555b.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15937b(String str, Object obj, Object obj2) {
        m15927a(EnumC2555b.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15939b(String str, Object... objArr) {
        m15927a(EnumC2555b.WARN, str, objArr, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15945d(String str) {
        m15927a(EnumC2555b.ERROR, str, null, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15946d(String str, Object obj) {
        m15927a(EnumC2555b.ERROR, str, new Object[]{obj}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15943c(String str, Object obj, Object obj2) {
        m15927a(EnumC2555b.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15944c(String str, Object... objArr) {
        m15927a(EnumC2555b.ERROR, str, objArr, null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15938b(String str, Throwable th) {
        m15927a(EnumC2555b.ERROR, str, null, th);
    }
}
