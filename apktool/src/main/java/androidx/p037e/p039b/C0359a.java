package androidx.p037e.p039b;

import androidx.core.p030e.C0267b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* renamed from: androidx.e.b.a */
/* loaded from: classes.dex */
public class C0359a<D> {

    /* renamed from: a */
    int f2451a;

    /* renamed from: b */
    a<D> f2452b;

    /* renamed from: c */
    boolean f2453c;

    /* renamed from: d */
    boolean f2454d;

    /* renamed from: e */
    boolean f2455e;

    /* renamed from: f */
    boolean f2456f;

    /* renamed from: g */
    boolean f2457g;

    /* compiled from: Loader.java */
    /* renamed from: androidx.e.b.a$a */
    public interface a<D> {
    }

    /* renamed from: a */
    public void m2613a(a<D> aVar) {
        if (this.f2452b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f2452b != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f2452b = null;
    }

    /* renamed from: a */
    public final void m2612a() {
        this.f2453c = true;
        this.f2455e = false;
        this.f2454d = false;
        m2615b();
    }

    /* renamed from: b */
    protected void m2615b() {
    }

    /* renamed from: c */
    public boolean m2616c() {
        return m2617d();
    }

    /* renamed from: d */
    protected boolean m2617d() {
        return false;
    }

    /* renamed from: e */
    public void m2618e() {
        this.f2453c = false;
        m2619f();
    }

    /* renamed from: f */
    protected void m2619f() {
    }

    /* renamed from: g */
    public void m2620g() {
        this.f2454d = true;
        m2621h();
    }

    /* renamed from: h */
    protected void m2621h() {
    }

    /* renamed from: i */
    public void m2622i() {
        m2623j();
        this.f2455e = true;
        this.f2453c = false;
        this.f2454d = false;
        this.f2456f = false;
        this.f2457g = false;
    }

    /* renamed from: j */
    protected void m2623j() {
    }

    /* renamed from: a */
    public String m2611a(D d2) {
        StringBuilder sb = new StringBuilder(64);
        C0267b.m1951a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0267b.m1951a(this, sb);
        sb.append(" id=");
        sb.append(this.f2451a);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    /* renamed from: a */
    public void m2614a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f2451a);
        printWriter.print(" mListener=");
        printWriter.println(this.f2452b);
        if (this.f2453c || this.f2456f || this.f2457g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f2453c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f2456f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f2457g);
        }
        if (this.f2454d || this.f2455e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f2454d);
            printWriter.print(" mReset=");
            printWriter.println(this.f2455e);
        }
    }
}
