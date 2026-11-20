package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.p209io.IOException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: assets/android.dex */
public interface SocketFactory {
    @Deprecated
    Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws ConnectTimeoutException, IOException, UnknownHostException;

    @Deprecated
    Socket createSocket() throws IOException;

    @Deprecated
    boolean isSecure(Socket socket) throws IllegalArgumentException;
}
