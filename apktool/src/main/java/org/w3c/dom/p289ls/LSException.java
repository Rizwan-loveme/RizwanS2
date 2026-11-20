package org.w3c.dom.p289ls;

/* loaded from: assets/android.dex */
public class LSException extends RuntimeException {
    public static final short PARSE_ERR = 81;
    public static final short SERIALIZE_ERR = 82;
    public short code;

    public LSException(short s, String str) {
        throw new RuntimeException("Stub!");
    }
}
