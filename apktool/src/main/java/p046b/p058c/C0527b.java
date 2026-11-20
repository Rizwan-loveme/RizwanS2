package p046b.p058c;

import com.p065b.p066a.p067a.AbstractC0581c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;
import p046b.p057b.C0522a;
import p046b.p059d.C0536a;
import p046b.p059d.C0542g;
import p046b.p059d.C0543h;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: DirUtil.java */
/* renamed from: b.c.b */
/* loaded from: classes.dex */
public class C0527b {
    /* renamed from: a */
    public static void m3938a(InterfaceC0528c interfaceC0528c, InterfaceC0528c interfaceC0528c2) {
        Iterator<String> it = interfaceC0528c.mo3908a(true).iterator();
        while (it.hasNext()) {
            m3939a(interfaceC0528c, interfaceC0528c2, it.next());
        }
    }

    /* renamed from: a */
    public static void m3939a(InterfaceC0528c interfaceC0528c, InterfaceC0528c interfaceC0528c2, String str) {
        try {
            if (interfaceC0528c.mo3919b(str)) {
                interfaceC0528c.mo3925e(str).mo3909a(interfaceC0528c2.mo3927f(str));
            } else {
                C0536a.m3968a(interfaceC0528c.mo3950o(str), interfaceC0528c2.mo3923d(str));
                C3262u.m19610a(interfaceC0528c2.mo3936n(str), interfaceC0528c.mo3952q(str));
            }
        } catch (IOException e2) {
            throw new C0529d(new StringBuffer().append("Error copying file: ").append(str).toString(), e2);
        }
    }

    /* renamed from: a */
    public static void m3940a(InterfaceC0528c interfaceC0528c, File file) {
        Iterator<String> it = interfaceC0528c.mo3908a(true).iterator();
        while (it.hasNext()) {
            m3942a(interfaceC0528c, file, it.next());
        }
    }

    /* renamed from: a */
    public static void m3944a(InterfaceC0528c interfaceC0528c, File file, String[] strArr) {
        for (String str : strArr) {
            m3942a(interfaceC0528c, file, str);
        }
    }

    /* renamed from: a */
    public static void m3942a(InterfaceC0528c interfaceC0528c, File file, String str) {
        try {
            if (interfaceC0528c.mo3919b(str) || interfaceC0528c.mo3916a(str)) {
                if (interfaceC0528c.mo3919b(str) && !str.equalsIgnoreCase(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME) && !str.toLowerCase().matches("^classes(\\d+)?\\.dex$") && !str.equalsIgnoreCase("resources.arsc")) {
                    C0542g.m3987a(new File(file, str));
                    interfaceC0528c.mo3925e(str).mo3910a(new File(file, str));
                    return;
                }
                File file2 = new File(file, C0536a.m3966a(file, str));
                file2.getParentFile().mkdirs();
                C3262u.m19610a(file2.getParentFile(), interfaceC0528c.mo3952q(str));
                C0536a.m3968a(interfaceC0528c.mo3950o(str), new FileOutputStream(file2));
                C3262u.m19610a(file2, interfaceC0528c.mo3952q(str));
            }
        } catch (C0522a e2) {
            throw new C0529d(new StringBuffer().append("Error copying file: ").append(str).toString(), e2);
        } catch (IOException e3) {
            throw new C0529d(new StringBuffer().append("Error copying file: ").append(str).toString(), e3);
        }
    }

    /* renamed from: a */
    public static void m3941a(InterfaceC0528c interfaceC0528c, File file, C0543h c0543h) {
        Iterator<String> it = interfaceC0528c.mo3908a(true).iterator();
        while (it.hasNext()) {
            m3943a(interfaceC0528c, file, it.next(), c0543h);
        }
    }

    /* renamed from: a */
    public static void m3945a(InterfaceC0528c interfaceC0528c, File file, String[] strArr, C0543h c0543h) {
        for (String str : strArr) {
            m3943a(interfaceC0528c, file, str, c0543h);
        }
    }

    /* renamed from: a */
    public static void m3943a(InterfaceC0528c interfaceC0528c, File file, String str, C0543h c0543h) {
        String m3937a;
        String m3966a;
        try {
            if (interfaceC0528c.mo3919b(str) || interfaceC0528c.mo3916a(str)) {
                if (interfaceC0528c.mo3919b(str) && !str.equalsIgnoreCase(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME) && !str.toLowerCase().matches("^classes(\\d+)?\\.dex$") && !str.equalsIgnoreCase("resources.arsc")) {
                    C0542g.m3987a(new File(file, str));
                    interfaceC0528c.mo3925e(str).mo3911a(new File(file, str), c0543h);
                    return;
                }
                boolean m3946a = m3946a(str, 250);
                if ((m3946a || str.length() > 1024 || str.contains("//")) && c0543h != null) {
                    if (m3946a) {
                        m3937a = m3947b(str, 250);
                    } else if (str.length() > 1024) {
                        m3937a = m3948c(str, 1024);
                    } else {
                        m3937a = m3937a(str);
                    }
                    String replaceAll = m3937a.replaceAll("[:*?\"<>|]", "_");
                    c0543h.m3998a(c0543h.m3999b(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(str).toString()), c0543h.m3999b(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(replaceAll).toString()));
                    m3966a = C0536a.m3966a(file, replaceAll);
                } else {
                    m3966a = C0536a.m3966a(file, str);
                }
                File file2 = new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(m3966a).toString());
                if (file2.exists() && c0543h != null) {
                    String m3995a = c0543h.m3995a(file2.getAbsolutePath());
                    if (m3995a != null) {
                        file2 = new File(m3995a);
                    }
                } else if (Pattern.compile("[:*?\"<>|]").matcher(m3966a).find() && c0543h != null) {
                    String replaceAll2 = m3966a.replaceAll("[:*?\"<>|]", "_");
                    String m3999b = c0543h.m3999b(file2.getAbsolutePath());
                    file2 = new File(new StringBuffer().append(new StringBuffer().append(file.getAbsolutePath()).append(File.separator).toString()).append(replaceAll2).toString());
                    String m3999b2 = c0543h.m3999b(file2.getAbsolutePath());
                    if (file2.exists()) {
                        m3999b2 = c0543h.m3996a(m3999b2, 1);
                        file2 = c0543h.m4003e(m3999b2);
                    }
                    c0543h.m3998a(m3999b, m3999b2);
                }
                file2.getParentFile().mkdirs();
                C3262u.m19610a(file2.getParentFile(), interfaceC0528c.mo3952q(str));
                C0536a.m3968a(interfaceC0528c.mo3950o(str), new FileOutputStream(file2));
                C3262u.m19610a(file2, interfaceC0528c.mo3952q(str));
            }
        } catch (C0522a e2) {
            throw new C0529d(new StringBuffer().append("Error copying file: ").append(str).toString(), e2);
        } catch (IOException e3) {
            throw new C0529d(new StringBuffer().append("Error copying file: ").append(str).toString(), e3);
        }
    }

    /* renamed from: a */
    private static boolean m3946a(String str, int i) {
        if (str.length() <= i) {
            return false;
        }
        for (String str2 : str.split(File.separator)) {
            if (str2.length() > i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m3937a(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(File.separator);
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (!str2.isEmpty()) {
                if (i > 0) {
                    sb.append(File.separator);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m3947b(String str, int i) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(File.separator);
        for (int i2 = 0; i2 < split.length; i2++) {
            String str2 = split[i2];
            if (!str2.isEmpty()) {
                if (i2 > 0) {
                    sb.append(File.separator);
                }
                if (str2.length() > i) {
                    String stringBuffer = new StringBuffer().append("FILE_NAME_TOO_LONG_").append(C3112bn.m18988a(17)).toString();
                    if (i2 == split.length - 1) {
                        String[] m19641b = C3262u.m19641b(str2);
                        if (!m19641b[1].isEmpty()) {
                            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(stringBuffer).append(".").toString()).append(m19641b[1].replaceAll("[:*?\"<>|]", "_").replaceAll("\\s", " ")).toString();
                            if (stringBuffer2.length() > i) {
                                sb.append(stringBuffer);
                            } else {
                                sb.append(stringBuffer2);
                            }
                        } else {
                            sb.append(stringBuffer);
                        }
                    } else {
                        sb.append(stringBuffer);
                    }
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    private static String m3948c(String str, int i) {
        String stringBuffer;
        int indexOf = str.indexOf(File.separator);
        if (indexOf > 0) {
            stringBuffer = new StringBuffer().append(new StringBuffer().append(str.substring(0, indexOf + 1)).append("FILE_NAME_TOO_LONG_").toString()).append(C3112bn.m18988a(17)).toString();
        } else {
            stringBuffer = new StringBuffer().append("FILE_NAME_TOO_LONG_").append(C3112bn.m18988a(17)).toString();
        }
        String[] m19641b = C3262u.m19641b(str);
        if (!m19641b[1].isEmpty()) {
            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(stringBuffer).append(".").toString()).append(m19641b[1].replaceAll("[:*?\"<>|]", "_").replaceAll("\\s", " ")).toString();
            return stringBuffer2.length() > i ? stringBuffer : stringBuffer2;
        }
        return stringBuffer;
    }
}
