package org.p217b.p218a.p222b.p223a;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: NestableDelegate.java */
/* renamed from: org.b.a.b.a.c */
/* loaded from: classes.dex */
public class C1891c implements Serializable {

    /* renamed from: a */
    public static boolean f11076a = true;

    /* renamed from: b */
    public static boolean f11077b = true;

    /* renamed from: c */
    public static boolean f11078c = true;

    /* renamed from: d */
    private Throwable f11079d;

    /* JADX WARN: Multi-variable type inference failed */
    public C1891c(InterfaceC1890b interfaceC1890b) {
        this.f11079d = null;
        if (interfaceC1890b instanceof Throwable) {
            this.f11079d = (Throwable) interfaceC1890b;
            return;
        }
        throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
    }

    /* renamed from: a */
    public void m13997a() {
        m13998a(System.err);
    }

    /* renamed from: a */
    public void m13998a(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            m13999a(printWriter);
            printWriter.flush();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m13999a(PrintWriter printWriter) {
        Throwable th = this.f11079d;
        if (C1889a.m13990a()) {
            if (th instanceof InterfaceC1890b) {
                ((InterfaceC1890b) th).mo13996a(printWriter);
                return;
            } else {
                th.printStackTrace(printWriter);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Throwable th2 = th; th2 != null; th2 = C1889a.m13986a(th2)) {
            arrayList.add(m14001a(th2));
        }
        String str = "Caused by: ";
        if (!f11076a) {
            str = "Rethrown as: ";
            Collections.reverse(arrayList);
        }
        String str2 = str;
        if (f11077b) {
            m14000a(arrayList);
        }
        synchronized (printWriter) {
            Iterator<E> it = arrayList.iterator();
            while (it.hasNext()) {
                for (String str3 : (String[]) it.next()) {
                    printWriter.println(str3);
                }
                if (it.hasNext()) {
                    printWriter.print(str2);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    protected String[] m14001a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        if (th instanceof InterfaceC1890b) {
            ((InterfaceC1890b) th).mo13996a(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
        return C1889a.m13991a(stringWriter.getBuffer().toString());
    }

    /* renamed from: a */
    protected void m14000a(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            C1889a.m13989a(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer().append("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }
}
