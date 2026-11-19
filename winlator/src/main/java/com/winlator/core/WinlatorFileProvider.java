package com.winlator.core;

import androidx.core.content.FileProvider;

/**
 * Own subclass of the AndroidX FileProvider: Win11 (and libraries it uses) may declare the plain
 * androidx.core.content.FileProvider too, and two providers with the same class name would clash
 * in the manifest merge. Authority: ${applicationId}.winlator.fileprovider
 */
public class WinlatorFileProvider extends FileProvider {
    public static String getAuthority(android.content.Context context) {
        return context.getPackageName() + ".winlator.fileprovider";
    }
}
