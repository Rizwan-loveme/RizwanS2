package org.apache.http.conn.ssl;

import java.p209io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
/* loaded from: assets/android.dex */
public abstract class AbstractVerifier implements X509HostnameVerifier {
    @Deprecated
    public AbstractVerifier() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String str) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static int countDots(String str) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static String[] getCNs(X509Certificate x509Certificate) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    @Deprecated
    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    @Deprecated
    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public final void verify(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
    @Deprecated
    public final boolean verify(String str, SSLSession sSLSession) {
        throw new RuntimeException("Stub!");
    }
}
