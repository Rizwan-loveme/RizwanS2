package jadx.core.p203d.p206c;

import org.p226d.p233b.p250e.InterfaceC2264e;

/* compiled from: JadxDexFile.java */
/* renamed from: jadx.core.d.c.c */
/* loaded from: classes.dex */
public class C1733c {

    /* renamed from: a */
    private final C1732b f10586a;

    /* renamed from: b */
    private final String f10587b;

    /* renamed from: c */
    private final InterfaceC2264e f10588c;

    public C1733c(C1732b c1732b, String str, InterfaceC2264e interfaceC2264e) {
        this.f10586a = c1732b;
        this.f10587b = str;
        this.f10588c = interfaceC2264e;
    }

    /* renamed from: a */
    public String m13247a() {
        return this.f10587b;
    }

    /* renamed from: b */
    public InterfaceC2264e m13248b() {
        return this.f10588c;
    }

    /* renamed from: c */
    public C1732b m13249c() {
        return this.f10586a;
    }

    public String toString() {
        return this.f10586a + (this.f10587b.isEmpty() ? "" : ":" + this.f10587b);
    }
}
