package org.apache.http.conn.scheme;

import java.net.Socket;
import java.net.UnknownHostException;
import java.p209io.IOException;

@Deprecated
/* loaded from: assets/android.dex */
public interface LayeredSocketFactory extends SocketFactory {
    @Deprecated
    Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException;
}
