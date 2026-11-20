package org.p217b.p218a.p222b.p223a;

import java.p209io.PrintStream;
import java.p209io.PrintWriter;

/* compiled from: NestableRuntimeException.java */
/* renamed from: org.b.a.b.a.d */
/* loaded from: classes.dex */
public class C1892d extends RuntimeException implements InterfaceC1890b {

    /* renamed from: a */
    protected C1891c f11080a = new C1891c(this);

    /* renamed from: b */
    private Throwable f11081b;

    public C1892d(Throwable th) {
        this.f11081b = null;
        this.f11081b = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f11081b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        if (this.f11081b != null) {
            return this.f11081b.toString();
        }
        return null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        this.f11080a.m13997a();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        this.f11080a.m13998a(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        this.f11080a.m13999a(printWriter);
    }

    @Override // org.p217b.p218a.p222b.p223a.InterfaceC1890b
    /* renamed from: a */
    public final void mo13996a(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }
}
