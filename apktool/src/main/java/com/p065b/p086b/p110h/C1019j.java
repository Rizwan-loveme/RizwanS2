package com.p065b.p086b.p110h;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: ExceptionWithContext.java */
/* renamed from: com.b.b.h.j */
/* loaded from: classes.dex */
public class C1019j extends RuntimeException {

    /* renamed from: a */
    private StringBuffer f6494a;

    /* renamed from: a */
    public static C1019j m8537a(Throwable th, String str) {
        C1019j c1019j;
        if (th instanceof C1019j) {
            c1019j = (C1019j) th;
        } else {
            c1019j = new C1019j(th);
        }
        c1019j.m8540a(str);
        return c1019j;
    }

    public C1019j(String str) {
        this(str, null);
    }

    public C1019j(Throwable th) {
        this(null, th);
    }

    public C1019j(String str, Throwable th) {
        super(str == null ? th != null ? th.getMessage() : null : str, th);
        if (th instanceof C1019j) {
            String stringBuffer = ((C1019j) th).f6494a.toString();
            this.f6494a = new StringBuffer(stringBuffer.length() + 200);
            this.f6494a.append(stringBuffer);
            return;
        }
        this.f6494a = new StringBuffer(200);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.f6494a);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.f6494a);
    }

    /* renamed from: a */
    public void m8540a(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.f6494a.append(str);
        if (!str.endsWith("\n")) {
            this.f6494a.append('\n');
        }
    }

    /* renamed from: a */
    public String m8538a() {
        return this.f6494a.toString();
    }

    /* renamed from: a */
    public void m8539a(PrintStream printStream) {
        printStream.println(getMessage());
        printStream.print(this.f6494a);
    }
}
