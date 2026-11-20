package org.p226d.p269d;

import com.p129f.p130a.p133c.C1193h;
import com.p129f.p130a.p133c.InterfaceC1158ak;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.p209io.File;
import java.p209io.FileNotFoundException;
import java.p209io.FileReader;
import java.p209io.FileWriter;
import java.p209io.IOException;
import java.p209io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: ClassFileNameHandler.java */
/* renamed from: org.d.d.e */
/* loaded from: classes.dex */
public class C2451e {

    /* renamed from: a */
    static final /* synthetic */ boolean f12899a;

    /* renamed from: i */
    private static Pattern f12900i;

    /* renamed from: f */
    private a f12905f;

    /* renamed from: g */
    private String f12906g;

    /* renamed from: b */
    private final int f12901b = -1;

    /* renamed from: c */
    private final int f12902c = 0;

    /* renamed from: d */
    private final int f12903d = 1;

    /* renamed from: e */
    private int f12904e = -1;

    /* renamed from: h */
    private boolean f12907h = m15498b();

    static {
        f12899a = !C2451e.class.desiredAssertionStatus();
        f12900i = Pattern.compile("^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])(\\..*)?$", 2);
    }

    public C2451e(File file, String str) {
        this.f12905f = new a(file);
        this.f12906g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m15490a() {
        return 249;
    }

    /* renamed from: a */
    public File m15504a(String str) {
        if (str.charAt(0) != 'L' || str.charAt(str.length() - 1) != ';') {
            throw new RuntimeException("Not a valid dalvik class name");
        }
        int i = 1;
        for (int i2 = 1; i2 < str.length() - 1; i2++) {
            if (str.charAt(i2) == '/') {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i3 < str.length() - 1) {
            if (str.charAt(i3) == '/') {
                if (i3 - i4 == 0) {
                    throw new RuntimeException("Not a valid dalvik class name");
                }
                strArr[i5] = str.substring(i4, i3);
                int i6 = i3 + 1;
                i3 = i6;
                i4 = i6;
                i5++;
            }
            i3++;
        }
        if (i4 >= str.length() - 1) {
            throw new RuntimeException("Not a valid dalvik class name");
        }
        strArr[i5] = str.substring(i4, str.length() - 1);
        return m15492a(this.f12905f, strArr, 0);
    }

    /* renamed from: a */
    private File m15492a(a aVar, String[] strArr, int i) {
        if (i == strArr.length - 1) {
            b bVar = new b(aVar, strArr[i] + this.f12906g);
            aVar.m15508a(bVar);
            String b2 = bVar.m15512b();
            if (f12899a || b2 != null) {
                return new File(aVar.f12910g, b2);
            }
            throw new AssertionError();
        }
        return m15492a((a) aVar.m15508a((c) new a(aVar, strArr[i])), strArr, i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m15502d(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                int codePointAt = str.codePointAt(i2);
                i = m15491a(codePointAt) + i3;
                i2 += Character.charCount(codePointAt);
            } else {
                return i3;
            }
        }
    }

    /* renamed from: a */
    private static int m15491a(int i) {
        if (i < 128) {
            return 1;
        }
        if (i < 2048) {
            return 2;
        }
        if (i < 65536) {
            return 3;
        }
        return 4;
    }

    /* renamed from: a */
    static String m15493a(String str, int i) {
        int i2 = i + 1;
        try {
            IntBuffer asIntBuffer = ByteBuffer.wrap(str.getBytes("UTF-32BE")).asIntBuffer();
            int[] iArr = new int[asIntBuffer.limit()];
            asIntBuffer.get(iArr);
            int length = iArr.length / 2;
            int i3 = length + 1;
            int m15491a = m15491a(iArr[length]);
            if (iArr.length % 2 == 0 && m15491a < i2) {
                m15491a += m15491a(iArr[i3]);
                i3++;
            }
            while (m15491a < i2 && (length > 0 || i3 < iArr.length)) {
                if (length > 0) {
                    length--;
                    m15491a += m15491a(iArr[length]);
                }
                if (m15491a < i2 && i3 < iArr.length) {
                    m15491a += m15491a(iArr[i3]);
                    i3++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < length; i4++) {
                sb.appendCodePoint(iArr[i4]);
            }
            sb.append('#');
            while (i3 < iArr.length) {
                sb.appendCodePoint(iArr[i3]);
                i3++;
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: b */
    private static boolean m15498b() {
        return System.getProperty("os.name").startsWith("Windows");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m15503e(String str) {
        return f12900i.matcher(str).matches();
    }

    /* compiled from: ClassFileNameHandler.java */
    /* renamed from: org.d.d.e$c */
    private abstract class c {

        /* renamed from: c */
        public final a f12914c;

        /* renamed from: d */
        public final String f12915d;

        /* renamed from: e */
        protected String f12916e;

        /* renamed from: a */
        protected abstract String mo15507a(int i);

        private c(a aVar, String str) {
            this.f12916e = null;
            this.f12914c = aVar;
            this.f12915d = str;
        }

        /* renamed from: a */
        public String m15511a(boolean z) {
            String str = this.f12915d;
            if (!z && this.f12914c != null && !this.f12914c.m15509a()) {
                str = str.toLowerCase();
            }
            if (C2451e.this.f12907h && C2451e.m15503e(str)) {
                str = C2451e.m15497b(str, "#");
            }
            int m15502d = C2451e.m15502d(str);
            if (m15502d > C2451e.this.m15490a()) {
                return C2451e.m15493a(str, m15502d - C2451e.this.m15490a());
            }
            return str;
        }

        /* renamed from: b */
        public String m15512b() {
            return this.f12916e;
        }

        /* renamed from: b */
        public void mo15510b(int i) {
            if (i < 0 || i > 99999) {
                throw new IllegalArgumentException("suffix must be in [0, 100000)");
            }
            if (this.f12916e != null) {
                throw new IllegalStateException("The suffix can only be set once");
            }
            this.f12916e = mo15507a(i);
        }
    }

    /* compiled from: ClassFileNameHandler.java */
    /* renamed from: org.d.d.e$a */
    private class a extends c {

        /* renamed from: a */
        static final /* synthetic */ boolean f12908a;

        /* renamed from: g */
        private File f12910g;

        /* renamed from: h */
        private int f12911h;

        /* renamed from: i */
        private final InterfaceC1158ak<String, c> f12912i;

        static {
            f12908a = !C2451e.class.desiredAssertionStatus();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(File file) {
            super(null, file.getName());
            this.f12910g = null;
            this.f12911h = C2451e.this.f12904e;
            this.f12912i = C1193h.m10051h();
            this.f12910g = file;
            this.f12916e = this.f12910g.getName();
        }

        public a(a aVar, String str) {
            super(aVar, str);
            this.f12910g = null;
            this.f12911h = C2451e.this.f12904e;
            this.f12912i = C1193h.m10051h();
        }

        /* renamed from: a */
        public synchronized c m15508a(c cVar) {
            c cVar2;
            Collection<c> mo9946b = this.f12912i.mo9946b(cVar.m15511a(false));
            if (cVar instanceof a) {
                Iterator<c> it = mo9946b.iterator();
                while (it.hasNext()) {
                    cVar2 = it.next();
                    if (cVar2.f12915d.equals(cVar.f12915d)) {
                        break;
                    }
                }
            }
            cVar.mo15510b(mo9946b.size());
            mo9946b.add(cVar);
            cVar2 = cVar;
            return cVar2;
        }

        @Override // org.p226d.p269d.C2451e.c
        /* renamed from: a */
        protected String mo15507a(int i) {
            return i > 0 ? m15511a(true) + "." + Integer.toString(i) : m15511a(true);
        }

        @Override // org.p226d.p269d.C2451e.c
        /* renamed from: b */
        public void mo15510b(int i) {
            super.mo15510b(i);
            String b2 = m15512b();
            if (this.f12914c != null && b2 != null) {
                this.f12910g = new File(this.f12914c.f12910g, b2);
            }
        }

        /* renamed from: a */
        protected boolean m15509a() {
            if (m15512b() == null || this.f12910g == null) {
                throw new IllegalStateException("Must call setSuffix() first");
            }
            if (this.f12911h != -1) {
                return this.f12911h == 1;
            }
            File file = this.f12910g;
            if (file.exists() && file.isFile() && !file.delete()) {
                throw new C2453g("Can't delete %s to make it into a directory", file.getAbsolutePath());
            }
            if (!file.exists() && !file.mkdirs()) {
                throw new C2453g("Couldn't create directory %s", file.getAbsolutePath());
            }
            try {
                boolean m15506a = m15506a(file);
                this.f12911h = m15506a ? 1 : 0;
                return m15506a;
            } catch (IOException e2) {
                return false;
            }
        }

        /* renamed from: a */
        private boolean m15506a(File file) {
            File file2;
            File file3;
            int i = 1;
            while (true) {
                file2 = new File(file, "test." + i);
                int i2 = i + 1;
                file3 = new File(file, "TEST." + i);
                if (!file2.exists()) {
                    try {
                        if (!file3.exists()) {
                            try {
                                break;
                            } catch (IOException e2) {
                                try {
                                    file2.delete();
                                } catch (Exception e3) {
                                }
                                throw e2;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            file2.delete();
                        } catch (Exception e4) {
                        }
                        try {
                            file3.delete();
                            throw th;
                        } catch (Exception e5) {
                            throw th;
                        }
                    }
                }
                i = i2;
            }
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write("test");
            fileWriter.flush();
            fileWriter.close();
            if (file3.exists()) {
                try {
                    file2.delete();
                } catch (Exception e6) {
                }
                try {
                    file3.delete();
                } catch (Exception e7) {
                }
                return false;
            }
            if (file3.createNewFile()) {
                try {
                    file2.delete();
                } catch (Exception e8) {
                }
                try {
                    file3.delete();
                    return true;
                } catch (Exception e9) {
                    return true;
                }
            }
            try {
                CharBuffer allocate = CharBuffer.allocate(32);
                FileReader fileReader = new FileReader(file3);
                while (fileReader.read(allocate) != -1 && allocate.length() < 4) {
                }
                if (allocate.length() == 4 && allocate.toString().equals("test")) {
                    try {
                        file2.delete();
                    } catch (Exception e10) {
                    }
                    try {
                        file3.delete();
                    } catch (Exception e11) {
                    }
                    return false;
                }
                if (!f12908a) {
                    throw new AssertionError();
                }
                try {
                    file2.delete();
                } catch (Exception e12) {
                }
                try {
                    file3.delete();
                } catch (Exception e13) {
                }
                return false;
            } catch (FileNotFoundException e14) {
                try {
                    file2.delete();
                } catch (Exception e15) {
                }
                try {
                    file3.delete();
                    return true;
                } catch (Exception e16) {
                    return true;
                }
            }
        }
    }

    /* compiled from: ClassFileNameHandler.java */
    /* renamed from: org.d.d.e$b */
    private class b extends c {
        private b(a aVar, String str) {
            super(aVar, str);
        }

        @Override // org.p226d.p269d.C2451e.c
        /* renamed from: a */
        protected String mo15507a(int i) {
            return i > 0 ? C2451e.m15497b(m15511a(true), '.' + Integer.toString(i)) : m15511a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m15497b(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(46);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 1);
        if (lastIndexOf < 0) {
            sb.append(str);
            sb.append(str2);
        } else {
            sb.append(str.subSequence(0, lastIndexOf));
            sb.append(str2);
            sb.append(str.subSequence(lastIndexOf, str.length()));
        }
        return sb.toString();
    }
}
