package p165d.p167b.p168a;

import java.security.PrivilegedAction;

/* compiled from: GetPropertyAction.java */
/* renamed from: d.b.a.b */
/* loaded from: classes.dex */
public class C1422b implements PrivilegedAction<String> {

    /* renamed from: a */
    private String f9188a;

    /* renamed from: b */
    private String f9189b;

    public C1422b(String str) {
        this.f9189b = str;
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String run() {
        String property = System.getProperty(this.f9189b);
        return property == null ? this.f9188a : property;
    }
}
