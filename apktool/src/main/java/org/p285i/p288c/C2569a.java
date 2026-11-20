package org.p285i.p288c;

import android.util.Log;
import org.p285i.p287b.AbstractC2560b;
import org.p285i.p287b.C2559a;
import org.p285i.p287b.C2561c;

/* compiled from: AndroidLoggerAdapter.java */
/* renamed from: org.i.c.a */
/* loaded from: classes.dex */
class C2569a extends AbstractC2560b {
    C2569a(String str) {
        this.f13340b = str;
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public boolean mo15940b() {
        return m16016a(3);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15930a(String str) {
        m16014a(3, str, (Throwable) null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15931a(String str, Object obj) {
        m16015a(3, str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15932a(String str, Object obj, Object obj2) {
        m16015a(3, str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15934a(String str, Object... objArr) {
        m16015a(3, str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15933a(String str, Throwable th) {
        m16014a(2, str, th);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15935b(String str) {
        m16014a(4, str, (Throwable) null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15936b(String str, Object obj) {
        m16015a(4, str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15941c(String str) {
        m16014a(5, str, (Throwable) null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15942c(String str, Object obj) {
        m16015a(5, str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15937b(String str, Object obj, Object obj2) {
        m16015a(5, str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15939b(String str, Object... objArr) {
        m16015a(5, str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15945d(String str) {
        m16014a(6, str, (Throwable) null);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15946d(String str, Object obj) {
        m16015a(6, str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15943c(String str, Object obj, Object obj2) {
        m16015a(6, str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15944c(String str, Object... objArr) {
        m16015a(6, str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15938b(String str, Throwable th) {
        m16014a(6, str, th);
    }

    /* renamed from: a */
    private void m16015a(int i, String str, Object... objArr) {
        if (m16016a(i)) {
            C2559a m15960a = C2561c.m15960a(str, objArr);
            m16017b(i, m15960a.m15957a(), m15960a.m15958b());
        }
    }

    /* renamed from: a */
    private void m16014a(int i, String str, Throwable th) {
        if (m16016a(i)) {
            m16017b(i, str, th);
        }
    }

    /* renamed from: a */
    private boolean m16016a(int i) {
        return Log.isLoggable(this.f13340b, i);
    }

    /* renamed from: b */
    private void m16017b(int i, String str, Throwable th) {
        if (th != null) {
            str = String.valueOf(str) + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i, this.f13340b, str);
    }
}
