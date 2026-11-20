package org.p285i.p287b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.p285i.InterfaceC2558b;
import org.p285i.p286a.C2554a;
import org.p285i.p286a.C2557d;
import org.p285i.p286a.InterfaceC2556c;

/* compiled from: SubstituteLogger.java */
/* renamed from: org.i.b.g */
/* loaded from: classes.dex */
public class C2565g implements InterfaceC2558b {

    /* renamed from: a */
    private final String f13341a;

    /* renamed from: b */
    private volatile InterfaceC2558b f13342b;

    /* renamed from: c */
    private Boolean f13343c;

    /* renamed from: d */
    private Method f13344d;

    /* renamed from: e */
    private C2554a f13345e;

    /* renamed from: f */
    private Queue<C2557d> f13346f;

    /* renamed from: g */
    private final boolean f13347g;

    public C2565g(String str, Queue<C2557d> queue, boolean z) {
        this.f13341a = str;
        this.f13346f = queue;
        this.f13347g = z;
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public String mo15929a() {
        return this.f13341a;
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public boolean mo15940b() {
        return m15979c().mo15940b();
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15930a(String str) {
        m15979c().mo15930a(str);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15931a(String str, Object obj) {
        m15979c().mo15931a(str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15932a(String str, Object obj, Object obj2) {
        m15979c().mo15932a(str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15934a(String str, Object... objArr) {
        m15979c().mo15934a(str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: a */
    public void mo15933a(String str, Throwable th) {
        m15979c().mo15933a(str, th);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15935b(String str) {
        m15979c().mo15935b(str);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15936b(String str, Object obj) {
        m15979c().mo15936b(str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15941c(String str) {
        m15979c().mo15941c(str);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15942c(String str, Object obj) {
        m15979c().mo15942c(str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15937b(String str, Object obj, Object obj2) {
        m15979c().mo15937b(str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15939b(String str, Object... objArr) {
        m15979c().mo15939b(str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15945d(String str) {
        m15979c().mo15945d(str);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: d */
    public void mo15946d(String str, Object obj) {
        m15979c().mo15946d(str, obj);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15943c(String str, Object obj, Object obj2) {
        m15979c().mo15943c(str, obj, obj2);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: c */
    public void mo15944c(String str, Object... objArr) {
        m15979c().mo15944c(str, objArr);
    }

    @Override // org.p285i.InterfaceC2558b
    /* renamed from: b */
    public void mo15938b(String str, Throwable th) {
        m15979c().mo15938b(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f13341a.equals(((C2565g) obj).f13341a);
    }

    public int hashCode() {
        return this.f13341a.hashCode();
    }

    /* renamed from: c */
    InterfaceC2558b m15979c() {
        if (this.f13342b != null) {
            return this.f13342b;
        }
        if (this.f13347g) {
            return C2562d.f13339a;
        }
        return m15976g();
    }

    /* renamed from: g */
    private InterfaceC2558b m15976g() {
        if (this.f13345e == null) {
            this.f13345e = new C2554a(this, this.f13346f);
        }
        return this.f13345e;
    }

    /* renamed from: a */
    public void m15978a(InterfaceC2558b interfaceC2558b) {
        this.f13342b = interfaceC2558b;
    }

    /* renamed from: d */
    public boolean m15980d() {
        if (this.f13343c != null) {
            return this.f13343c.booleanValue();
        }
        try {
            this.f13344d = this.f13342b.getClass().getMethod("log", InterfaceC2556c.class);
            this.f13343c = Boolean.TRUE;
        } catch (NoSuchMethodException e2) {
            this.f13343c = Boolean.FALSE;
        }
        return this.f13343c.booleanValue();
    }

    /* renamed from: a */
    public void m15977a(InterfaceC2556c interfaceC2556c) {
        if (m15980d()) {
            try {
                this.f13344d.invoke(this.f13342b, interfaceC2556c);
            } catch (IllegalAccessException e2) {
            } catch (IllegalArgumentException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
    }

    /* renamed from: e */
    public boolean m15981e() {
        return this.f13342b == null;
    }

    /* renamed from: f */
    public boolean m15982f() {
        return this.f13342b instanceof C2562d;
    }
}
