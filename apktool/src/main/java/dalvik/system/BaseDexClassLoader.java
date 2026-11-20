package dalvik.system;

import java.net.URL;
import java.p209io.File;
import java.util.Enumeration;

/* loaded from: assets/android.dex */
public class BaseDexClassLoader extends ClassLoader {
    public BaseDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    public String findLibrary(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    protected URL findResource(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.ClassLoader
    protected synchronized Package getPackage(String str) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
