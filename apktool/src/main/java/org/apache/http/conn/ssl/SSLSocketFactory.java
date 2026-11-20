package org.apache.http.conn.ssl;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import org.apache.http.conn.scheme.HostNameResolver;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: assets/android.dex */
public class SSLSocketFactory implements LayeredSocketFactory {

    @Deprecated
    public static final String SSL = "SSL";

    @Deprecated
    public static final String SSLV2 = "SSLv2";

    @Deprecated
    public static final String TLS = "TLS";

    @Deprecated
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = null;

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;

    @Deprecated
    public SSLSocketFactory(String str, KeyStore keyStore, String str2, KeyStore keyStore2, SecureRandom secureRandom, HostNameResolver hostNameResolver) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public SSLSocketFactory(KeyStore keyStore) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public SSLSocketFactory(KeyStore keyStore, String str) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public SSLSocketFactory(KeyStore keyStore, String str, KeyStore keyStore2) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static SSLSocketFactory getSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    @Deprecated
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    @Deprecated
    public Socket createSocket() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    @Deprecated
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public X509HostnameVerifier getHostnameVerifier() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    @Deprecated
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        throw new RuntimeException("Stub!");
    }
}
