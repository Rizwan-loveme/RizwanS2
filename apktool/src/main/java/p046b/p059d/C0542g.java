package p046b.p059d;

import com.rmdir.Rmdir;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.p217b.p218a.p219a.C1887e;
import p046b.p057b.C0522a;
import ru.maximoff.apktool.util.C3111bm;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: OS.java */
/* renamed from: b.d.g */
/* loaded from: classes.dex */
public class C0542g {

    /* renamed from: a */
    private static Process f3636a = (Process) null;

    /* renamed from: b */
    public static void m3992b() {
        Thread thread = new Thread() { // from class: b.d.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (C0542g.f3636a != null) {
                    C0542g.f3636a.destroy();
                    C0542g.f3636a = (Process) null;
                }
            }
        };
        thread.start();
        thread.interrupt();
    }

    /* renamed from: a */
    public static void m3987a(File file) {
        if (file == null) {
            return;
        }
        Rmdir.m11225a(file);
    }

    /* renamed from: a */
    public static void m3989a(String str) {
        Rmdir.nativeRmdir(str);
    }

    /* renamed from: a */
    public static boolean m3991a(File file, File file2) {
        file2.mkdirs();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file3 : listFiles) {
                if (!file3.equals(file2)) {
                    File file4 = new File(new StringBuffer().append(new StringBuffer().append(file2.getPath()).append(File.separatorChar).toString()).append(file3.getName()).toString());
                    if (file3.isDirectory()) {
                        m3991a(file3, file4);
                    } else {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file3);
                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                            C1887e.m13962a(fileInputStream, fileOutputStream);
                            fileInputStream.close();
                            fileOutputStream.close();
                            C3262u.m19610a(file4, file3.lastModified());
                        } catch (IOException e2) {
                            throw new C0522a(new StringBuffer().append("Could not copy file: ").append(file3).toString(), e2);
                        }
                    }
                }
            }
            C3262u.m19610a(file2, file.lastModified());
        }
        return true;
    }

    /* renamed from: a */
    public static String m3986a(String[] strArr) {
        String str;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        try {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                processBuilder.redirectErrorStream(true);
                f3636a = processBuilder.start();
                a aVar = new a(f3636a.getInputStream());
                newCachedThreadPool.execute(aVar);
                f3636a.waitFor();
                newCachedThreadPool.shutdown();
                while (!newCachedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                }
                String m3993a = aVar.m3993a();
                f3636a = (Process) null;
                str = m3993a;
            } catch (Throwable th) {
                f3636a = (Process) null;
                throw th;
            }
        } catch (IOException | InterruptedException e2) {
            str = (String) null;
            f3636a = (Process) null;
        }
        return str;
    }

    /* renamed from: a */
    public static void m3990a(List<String> list, InterfaceC0541f interfaceC0541f) {
        try {
            try {
                f3636a = new ProcessBuilder(list).start();
                new C3111bm(f3636a.getErrorStream(), 2, interfaceC0541f).start();
                new C3111bm(f3636a.getInputStream(), 1, interfaceC0541f).start();
                int waitFor = f3636a.waitFor();
                if (waitFor != 0) {
                    throw new C0522a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("could not exec (exit code = ").append(waitFor).toString()).append("): ").toString()).append(list).toString());
                }
            } catch (IOException e2) {
                throw new C0522a(new StringBuffer().append("could not exec: ").append(list).toString(), e2);
            } catch (InterruptedException e3) {
                throw new C0522a(new StringBuffer().append("could not exec : ").append(list).toString(), e3);
            }
        } finally {
            f3636a = (Process) null;
        }
    }

    /* compiled from: OS.java */
    /* renamed from: b.d.g$a */
    static class a implements Runnable {

        /* renamed from: a */
        private final StringBuffer f3637a = new StringBuffer();

        /* renamed from: b */
        private final InputStream f3638b;

        public a(InputStream inputStream) {
            this.f3638b = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f3638b));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.f3637a.append(readLine).append('\n');
                    } else {
                        bufferedReader.close();
                        return;
                    }
                }
            } catch (IOException e2) {
            }
        }

        /* renamed from: a */
        public String m3993a() {
            return this.f3637a.toString();
        }
    }
}
