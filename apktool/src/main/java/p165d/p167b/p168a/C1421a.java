package p165d.p167b.p168a;

import java.security.PrivilegedAction;

/* compiled from: GetBooleanAction.java */
/* renamed from: d.b.a.a */
/* loaded from: classes.dex */
public class C1421a implements PrivilegedAction<Boolean> {

    /* renamed from: a */
    private String f9187a;

    public C1421a(String str) {
        this.f9187a = str;
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean(this.f9187a));
    }
}
