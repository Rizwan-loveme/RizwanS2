package dalvik.system;

import java.p209io.File;
import java.p209io.FileNotFoundException;
import java.p209io.IOException;
import java.util.Enumeration;

@Deprecated
/* loaded from: assets/android.dex */
public final class DexFile {
    @Deprecated
    public DexFile(File file) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public DexFile(String str) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static native boolean isDexOptNeeded(String str) throws FileNotFoundException, IOException;

    @Deprecated
    public static DexFile loadDex(String str, String str2, int i) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public Enumeration<String> entries() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public Class loadClass(String str, ClassLoader classLoader) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
