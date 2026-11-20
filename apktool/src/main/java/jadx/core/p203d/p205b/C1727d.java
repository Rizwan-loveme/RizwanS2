package jadx.core.p203d.p205b;

import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1643i;
import jadx.core.p203d.C1735d;

/* compiled from: JadxException.java */
/* renamed from: jadx.core.d.b.d */
/* loaded from: classes.dex */
public class C1727d extends Exception {
    public C1727d(String str) {
        super(str);
    }

    public C1727d(String str, Throwable th) {
        super(str, th);
    }

    public C1727d(C1648n c1648n, String str, Throwable th) {
        super(C1735d.m13256a((InterfaceC1643i) c1648n, str), th);
    }
}
