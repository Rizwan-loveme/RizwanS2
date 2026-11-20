package p165d.p167b.p172e;

import java.security.Key;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHKey;

/* compiled from: KeyUtil.java */
/* renamed from: d.b.e.o */
/* loaded from: classes.dex */
public final class C1452o {
    /* renamed from: a */
    public static final int m11451a(Key key) {
        int i;
        if (key instanceof InterfaceC1453p) {
            try {
                i = ((InterfaceC1453p) key).m11452a();
            } catch (UnsupportedOperationException e2) {
                i = -1;
            }
            if (i >= 0) {
                return i;
            }
        } else {
            i = -1;
        }
        if (key instanceof SecretKey) {
            SecretKey secretKey = (SecretKey) key;
            if ("RAW".equals(secretKey.getFormat()) && secretKey.getEncoded() != null) {
                return secretKey.getEncoded().length * 8;
            }
            return i;
        }
        if (key instanceof RSAKey) {
            return ((RSAKey) key).getModulus().bitLength();
        }
        if (key instanceof ECKey) {
            return ((ECKey) key).getParams().getOrder().bitLength();
        }
        if (key instanceof DSAKey) {
            DSAParams params = ((DSAKey) key).getParams();
            if (params != null) {
                return params.getP().bitLength();
            }
            return -1;
        }
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        return i;
    }
}
