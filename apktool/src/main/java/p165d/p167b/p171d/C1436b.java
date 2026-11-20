package p165d.p167b.p171d;

import java.security.Provider;
import java.security.Security;
import p165d.p167b.p170c.C1434b;
import p165d.p167b.p171d.AbstractC1435a;

/* compiled from: JavaProvider.java */
/* renamed from: d.b.d.b */
/* loaded from: classes.dex */
public class C1436b extends Provider {
    public C1436b() {
        super("JKS", 1.0d, "Java KeyStore");
        put("KeyStore.JKS", AbstractC1435a.b.class.getName());
        put("KeyStore.CaseExactJKS", AbstractC1435a.a.class.getName());
        put("KeyStore.PKCS12", C1434b.class.getName());
        Security.setProperty("keystore.type", "jks");
    }
}
