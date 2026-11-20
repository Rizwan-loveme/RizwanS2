package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.io.IOException;

@Deprecated
/* loaded from: assets/android.dex */
public interface HostNameResolver {
    @Deprecated
    InetAddress resolve(String str) throws IOException;
}
