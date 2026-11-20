package org.p270e;

/* compiled from: JSONException.java */
/* renamed from: org.e.b */
/* loaded from: classes.dex */
public class C2467b extends RuntimeException {
    public C2467b(String str) {
        super(str);
    }

    public C2467b(String str, Throwable th) {
        super(str, th);
    }

    public C2467b(Throwable th) {
        super(th.getMessage(), th);
    }
}
