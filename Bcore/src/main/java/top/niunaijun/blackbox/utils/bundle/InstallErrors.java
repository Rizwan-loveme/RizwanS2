package top.niunaijun.blackbox.utils.bundle;

import java.util.Locale;

/**
 * Sorts the English error texts of the install code into a few kinds, so a screen can show a short
 * readable message of its own. Plain Java (no Android classes).
 */
public final class InstallErrors {

    public enum Kind {
        /** The box cannot run the native code of the app on this phone. */
        WRONG_ABI,
        /** The file is not a zip / bundle / APK that can be read. */
        BAD_FILE,
        /** The zip has no APK in it. */
        NO_APK,
        /** The phone has not enough free space to unpack the bundle. */
        NOT_ENOUGH_SPACE,
        /** The app is the host app itself. */
        SELF,
        /** A split file could not be read. */
        SPLIT_UNREADABLE,
        /** All virtual spaces already hold this app. */
        NO_FREE_SPACE_SLOT,
        /** The base APK cannot be parsed. */
        BROKEN_APK,
        /** The chosen file could not be opened or copied. */
        CANNOT_READ,
        /** The OBB files of an .xapk could not be copied (the app was not installed). */
        OBB_COPY,
        UNKNOWN
    }

    /** Texts that the installer itself creates, so {@link #classify} and the code cannot drift apart. */
    public static final String MSG_NOT_ENOUGH_SPACE = "Not enough free space on the phone to unpack this bundle.";
    public static final String MSG_NOT_ENOUGH_SPACE_FOR_COPY =
            "Not enough free space on the phone to make an independent copy of this app.";
    public static final String MSG_NO_FREE_SLOT = "All spaces already have this app.";
    public static final String MSG_OBB_NO_SPACE = "Not enough free space on the phone to copy the OBB files.";
    public static final String MSG_CANNOT_READ = "Cannot read the chosen file.";

    private InstallErrors() {
    }

    public static Kind classify(String message) {
        if (message == null || message.isEmpty()) {
            return Kind.UNKNOWN;
        }
        String m = message.toLowerCase(Locale.ROOT);
        if (m.contains("does not run on this phone")) {
            return Kind.WRONG_ABI;
        }
        if (m.contains("copy the obb")) {
            return Kind.OBB_COPY;
        }
        if (m.contains("not enough free space")) {
            return Kind.NOT_ENOUGH_SPACE;
        }
        if (m.contains("all spaces already have")) {
            return Kind.NO_FREE_SPACE_SLOT;
        }
        if (m.contains("cannot read the chosen file")) {
            return Kind.CANNOT_READ;
        }
        if (m.contains("cannot read the split file")) {
            return Kind.SPLIT_UNREADABLE;
        }
        if (m.contains("infinite recursion")) {
            return Kind.SELF;
        }
        if (m.contains("not a valid bundle") || m.contains("not a readable zip")
                || m.contains("could not unpack")) {
            return Kind.BAD_FILE;
        }
        if (m.contains("no apk files were found")) {
            return Kind.NO_APK;
        }
        if (m.contains("getpackagearchiveinfo") || m.contains("parser apk error")
                || m.contains("package parser")) {
            return Kind.BROKEN_APK;
        }
        return Kind.UNKNOWN;
    }
}
