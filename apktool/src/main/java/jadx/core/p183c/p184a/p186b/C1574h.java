package jadx.core.p183c.p184a.p186b;

import jadx.core.p203d.C1745n;

/* compiled from: JadxError.java */
/* renamed from: jadx.core.c.a.b.h */
/* loaded from: classes.dex */
public class C1574h {

    /* renamed from: a */
    private final String f10068a;

    /* renamed from: b */
    private final Throwable f10069b;

    public C1574h(String str, Throwable th) {
        this.f10068a = str;
        this.f10069b = th;
    }

    /* renamed from: a */
    public String m12113a() {
        return this.f10068a;
    }

    /* renamed from: b */
    public Throwable m12114b() {
        return this.f10069b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JadxError: ");
        if (this.f10068a != null) {
            sb.append(this.f10068a);
            sb.append(' ');
        }
        if (this.f10069b != null) {
            sb.append(this.f10069b.getClass());
            sb.append(":");
            sb.append(this.f10069b.getMessage());
            sb.append("\n");
            sb.append(C1745n.m13312a(this.f10069b));
        }
        return sb.toString();
    }
}
