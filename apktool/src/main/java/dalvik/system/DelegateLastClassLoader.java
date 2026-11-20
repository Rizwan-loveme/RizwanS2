package dalvik.system;

import android.annotation.NonNull;
import android.annotation.Nullable;
import java.net.URL;
import java.p209io.IOException;
import java.util.Enumeration;

/* loaded from: assets/android.dex */
public final class DelegateLastClassLoader extends PathClassLoader {
    public DelegateLastClassLoader(String str, ClassLoader classLoader) {
        super((String) null, (ClassLoader) null);
        throw new RuntimeException("Stub!");
    }

    public DelegateLastClassLoader(String str, String str2, ClassLoader classLoader) {
        super((String) null, (ClassLoader) null);
        throw new RuntimeException("Stub!");
    }

    public DelegateLastClassLoader(@NonNull String str, @Nullable String str2, @Nullable ClassLoader classLoader, boolean z) {
        super((String) null, (ClassLoader) null);
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }
}
