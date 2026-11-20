package org.p226d.p269d;

import java.p209io.PrintStream;
import java.p209io.PrintWriter;

/* compiled from: ExceptionWithContext.java */
/* renamed from: org.d.d.g */
/* loaded from: classes.dex */
public class C2453g extends RuntimeException {

    /* renamed from: a */
    private StringBuffer f12918a;

    /* renamed from: a */
    public static C2453g m15520a(Throwable th, String str, Object... objArr) {
        C2453g c2453g;
        if (th instanceof C2453g) {
            c2453g = (C2453g) th;
        } else {
            c2453g = new C2453g(th);
        }
        c2453g.m15521a(String.format(str, objArr));
        return c2453g;
    }

    public C2453g(String str, Object... objArr) {
        this(null, str, objArr);
    }

    public C2453g(Throwable th) {
        this(th, null, new Object[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2453g(Throwable th, String str, Object... objArr) {
        super(r0, th);
        String message;
        if (str != null) {
            message = m15519a(str, objArr);
        } else {
            message = th != null ? th.getMessage() : null;
        }
        if (th instanceof C2453g) {
            String stringBuffer = ((C2453g) th).f12918a.toString();
            this.f12918a = new StringBuffer(stringBuffer.length() + 200);
            this.f12918a.append(stringBuffer);
            return;
        }
        this.f12918a = new StringBuffer(200);
    }

    /* renamed from: a */
    private static String m15519a(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return String.format(str, objArr);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.f12918a);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.f12918a);
    }

    /* renamed from: a */
    public void m15521a(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.f12918a.append(str);
        if (!str.endsWith("\n")) {
            this.f12918a.append('\n');
        }
    }
}
