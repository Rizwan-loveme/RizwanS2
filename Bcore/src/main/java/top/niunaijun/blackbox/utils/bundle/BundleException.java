package top.niunaijun.blackbox.utils.bundle;

/**
 * Thrown when a split bundle (.apks / .xapk / .apkm) cannot be unpacked or understood.
 * The message is written to be shown to the user as it is.
 */
public class BundleException extends Exception {
    public BundleException(String message) {
        super(message);
    }

    public BundleException(String message, Throwable cause) {
        super(message, cause);
    }
}
