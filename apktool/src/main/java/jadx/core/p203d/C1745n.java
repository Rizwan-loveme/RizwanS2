package jadx.core.p203d;

import jadx.core.p181a.C1548d;
import jadx.p180a.C1536d;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Utils.java */
/* renamed from: jadx.core.d.n */
/* loaded from: classes.dex */
public class C1745n {

    /* renamed from: a */
    public static final String f10606a = C1536d.class.getPackage().getName();

    /* renamed from: a */
    public static String m13311a(String str) {
        int length = str.length() - 1;
        if (str.charAt(0) == 'L' && str.charAt(length) == ';') {
            return str.substring(1, length).replace('/', '.');
        }
        return str;
    }

    /* renamed from: b */
    public static String m13317b(String str) {
        return String.valueOf('L') + str.replace('.', '/') + ';';
    }

    /* renamed from: a */
    public static <T> String m13309a(Iterable<T> iterable) {
        return m13310a(iterable, ", ");
    }

    /* renamed from: a */
    public static <T> String m13310a(Iterable<T> iterable, String str) {
        if (iterable == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        m13316a(sb, iterable, str, new InterfaceC1736e<T, String>() { // from class: jadx.core.d.n.1
            @Override // jadx.core.p203d.InterfaceC1736e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public String mo12561a(T t) {
                return t.toString();
            }
        });
        return sb.toString();
    }

    /* renamed from: a */
    public static <T> void m13316a(StringBuilder sb, Iterable<T> iterable, String str, InterfaceC1736e<T, String> interfaceC1736e) {
        if (iterable != null) {
            Iterator<T> it = iterable.iterator();
            if (it.hasNext()) {
                sb.append(interfaceC1736e.mo12561a(it.next()));
            }
            while (it.hasNext()) {
                sb.append(str).append(interfaceC1736e.mo12561a(it.next()));
            }
        }
    }

    /* renamed from: a */
    public static String m13313a(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m13312a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        m13318b(th);
        th.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }

    /* renamed from: a */
    public static void m13315a(final C1548d c1548d, Throwable th) {
        if (th != null) {
            c1548d.m11882a();
            Throwable th2 = null;
            try {
                PrintWriter printWriter = new PrintWriter(new OutputStream() { // from class: jadx.core.d.n.2
                    @Override // java.io.OutputStream
                    public void write(int i) {
                        char c2 = (char) i;
                        switch (c2) {
                            case '\n':
                                C1548d.this.m11882a();
                                break;
                            case 11:
                            case '\f':
                            default:
                                C1548d.this.m11893b(c2);
                                break;
                            case '\r':
                                break;
                        }
                    }
                }, true);
                try {
                    m13318b(th);
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    if (printWriter != null) {
                        printWriter.close();
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th2.addSuppressed(th3);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m13318b(Throwable th) {
        try {
            m13319c(th);
        } catch (Exception e2) {
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m13318b(cause);
        }
    }

    /* renamed from: c */
    private static void m13319c(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = -1;
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = i;
                break;
            }
            if (stackTrace[i2].getClassName().startsWith(f10606a)) {
                i = i2;
            } else if (i > 0) {
                break;
            }
            i2++;
        }
        if (i2 > 0 && i2 < length) {
            th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 0, i2));
        }
    }

    /* renamed from: a */
    public static <T> List<T> m13314a(List<T> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        if (list.size() == 1) {
            return Collections.singletonList(list.get(0));
        }
        return new C1737f(list);
    }
}
