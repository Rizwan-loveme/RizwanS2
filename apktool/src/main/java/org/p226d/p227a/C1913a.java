package org.p226d.p227a;

import com.p129f.p130a.p133c.AbstractC1163ap;
import com.p129f.p130a.p133c.C1156ai;
import java.p209io.BufferedWriter;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.OutputStreamWriter;
import java.p209io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.p226d.p227a.p228a.C1936d;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p226d.p269d.C2451e;
import org.p226d.p269d.C2457k;

/* compiled from: Baksmali.java */
/* renamed from: org.d.a.a */
/* loaded from: classes.dex */
public class C1913a {
    /* renamed from: a */
    public static boolean m14083a(InterfaceC2264e interfaceC2264e, File file, int i, C1950b c1950b) {
        return m14084a(interfaceC2264e, file, i, c1950b, null);
    }

    /* renamed from: a */
    public static boolean m14084a(InterfaceC2264e interfaceC2264e, File file, int i, final C1950b c1950b, List<String> list) {
        HashSet hashSet;
        List<InterfaceC2244d> m9960a = AbstractC1163ap.m9957b().m9960a(interfaceC2264e.mo14769c());
        final C2451e c2451e = new C2451e(file, ".smali");
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
        ArrayList<Future> m9909a = C1156ai.m9909a();
        if (list == null) {
            hashSet = null;
        } else {
            hashSet = new HashSet(list);
        }
        for (final InterfaceC2244d interfaceC2244d : m9960a) {
            if (hashSet == null || hashSet.contains(interfaceC2244d.mo14205l())) {
                m9909a.add(newFixedThreadPool.submit(new Callable<Boolean>() { // from class: org.d.a.a.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() {
                        return Boolean.valueOf(C1913a.m14085b(InterfaceC2244d.this, c2451e, c1950b));
                    }
                }));
            }
        }
        try {
            boolean z = false;
            for (Future future : m9909a) {
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException e2) {
                    } catch (ExecutionException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                z = !((Boolean) future.get()).booleanValue() ? true : z;
            }
            return !z;
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Writer] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m14085b(InterfaceC2244d interfaceC2244d, C2451e c2451e, C1950b c1950b) {
        C2457k c2457k;
        ?? r1;
        String str = null;
        String mo14205l = interfaceC2244d.mo14205l();
        if (mo14205l.charAt(0) == 'L') {
            ?? r2 = 59;
            if (mo14205l.charAt(mo14205l.length() - 1) == ';') {
                File m15504a = c2451e.m15504a(mo14205l);
                C1936d c1936d = new C1936d(c1950b, interfaceC2244d);
                ?? r4 = 0;
                r4 = 0;
                r4 = 0;
                r4 = 0;
                r4 = 0;
                r4 = 0;
                r4 = 0;
                r4 = 0;
                try {
                    try {
                        File parentFile = m15504a.getParentFile();
                        if (!parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                            System.err.println("Unable to create directory " + parentFile.toString() + " - skipping class");
                            if (0 != 0) {
                                try {
                                    r4.close();
                                } catch (Throwable th) {
                                    PrintStream printStream = System.err;
                                    StringBuilder append = new StringBuilder().append("\n\nError occurred while closing file ");
                                    mo14205l = m15504a.toString();
                                    String sb = append.append(mo14205l).toString();
                                    printStream.println(sb);
                                    th.printStackTrace();
                                    r4 = sb;
                                }
                            }
                            r1 = 0;
                        } else if (m15504a.exists() || m15504a.createNewFile()) {
                            c2457k = new C2457k(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(m15504a), "UTF8")));
                            try {
                                c1936d.m14135a(c2457k);
                                if (c2457k != null) {
                                    try {
                                        c2457k.close();
                                    } catch (Throwable th2) {
                                        PrintStream printStream2 = System.err;
                                        StringBuilder append2 = new StringBuilder().append("\n\nError occurred while closing file ");
                                        String file = m15504a.toString();
                                        str = append2.append(file).toString();
                                        printStream2.println(str);
                                        th2.printStackTrace();
                                        r4 = file;
                                    }
                                }
                                r1 = 1;
                            } catch (Exception e2) {
                                e = e2;
                                PrintStream printStream3 = System.err;
                                mo14205l = "\n\nError occurred while disassembling class " + mo14205l.replace('/', '.') + " - skipping class";
                                printStream3.println(mo14205l);
                                e.printStackTrace();
                                m15504a.delete();
                                r2 = c2457k;
                                r4 = printStream3;
                                if (c2457k != null) {
                                    try {
                                        c2457k.close();
                                        r2 = c2457k;
                                        r4 = printStream3;
                                    } catch (Throwable th3) {
                                        PrintStream printStream4 = System.err;
                                        StringBuilder append3 = new StringBuilder().append("\n\nError occurred while closing file ");
                                        mo14205l = m15504a.toString();
                                        String sb2 = append3.append(mo14205l).toString();
                                        printStream4.println(sb2);
                                        th3.printStackTrace();
                                        r2 = printStream4;
                                        r4 = sb2;
                                    }
                                }
                                r1 = str;
                                return r1;
                            }
                        } else {
                            System.err.println("Unable to create file " + m15504a.toString() + " - skipping class");
                            if (0 != 0) {
                                try {
                                    r4.close();
                                } catch (Throwable th4) {
                                    PrintStream printStream5 = System.err;
                                    StringBuilder append4 = new StringBuilder().append("\n\nError occurred while closing file ");
                                    mo14205l = m15504a.toString();
                                    String sb3 = append4.append(mo14205l).toString();
                                    printStream5.println(sb3);
                                    th4.printStackTrace();
                                    r4 = sb3;
                                }
                            }
                            r1 = 0;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r4 = r2;
                        if (r4 != 0) {
                            try {
                                r4.close();
                            } catch (Throwable th6) {
                                System.err.println("\n\nError occurred while closing file " + m15504a.toString());
                                th6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c2457k = r4;
                } catch (Throwable th7) {
                    th = th7;
                    if (r4 != 0) {
                    }
                    throw th;
                }
                return r1;
            }
        }
        System.err.println("Unrecognized class descriptor - " + mo14205l + " - skipping class");
        return false;
    }
}
