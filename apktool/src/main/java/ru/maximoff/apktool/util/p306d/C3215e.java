package ru.maximoff.apktool.util.p306d;

import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FilenameFilter;
import java.p209io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: SearchUtils.java */
/* renamed from: ru.maximoff.apktool.util.d.e */
/* loaded from: classes.dex */
public class C3215e {
    /* renamed from: a */
    public static int m19247a(File file, String str, String str2, boolean z, String str3) {
        if (z) {
            return m19246a(file, str, str2, str3);
        }
        try {
            StringBuilder sb = new StringBuilder(C3061a.m18295a(file, str3));
            int i = 0;
            int i2 = 0;
            while (true) {
                int indexOf = sb.indexOf(str, i2);
                if (indexOf != -1) {
                    sb.replace(indexOf, str.length() + indexOf, str2);
                    i2 = indexOf + str2.length();
                    i++;
                } else {
                    C3061a.m18320b(file, sb.toString(), str3);
                    return i;
                }
            }
        } catch (Error | Exception e2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static int m19246a(File file, String str, String str2, String str3) {
        try {
            String m18295a = C3061a.m18295a(file, str3);
            StringBuilder sb = new StringBuilder(m18295a);
            StringBuilder sb2 = new StringBuilder(m18295a.toLowerCase());
            String lowerCase = str.toLowerCase();
            int i = 0;
            int i2 = 0;
            while (true) {
                int indexOf = sb2.indexOf(lowerCase, i2);
                if (indexOf != -1) {
                    sb.replace(indexOf, lowerCase.length() + indexOf, str2);
                    sb2.replace(indexOf, lowerCase.length() + indexOf, str2);
                    i2 = indexOf + str2.length();
                    i++;
                } else {
                    sb2.setLength(0);
                    sb2.trimToSize();
                    C3061a.m18320b(file, sb.toString(), str3);
                    return i;
                }
            }
        } catch (Error | Exception e2) {
            return 0;
        }
    }

    /* renamed from: b */
    public static int m19257b(File file, String str, String str2, boolean z, String str3) {
        try {
            String m18295a = C3061a.m18295a(file, str3);
            int i = 8;
            if (z) {
                i = 10;
            }
            Matcher matcher = Pattern.compile(str, i).matcher(m18295a);
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, str2);
                i2++;
            }
            if (i2 > 0) {
                matcher.appendTail(stringBuffer);
                C3061a.m18320b(file, stringBuffer.toString(), str3);
                return i2;
            }
            return i2;
        } catch (Error | Exception e2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static a m19254a(File file, String str, boolean z, String str2, int i) {
        a aVar = new a();
        try {
            String m18295a = C3061a.m18295a(file, str2);
            String m19253a = m19253a(m18295a);
            int i2 = 8;
            if (z) {
                i2 = 10;
            }
            Matcher matcher = Pattern.compile(str, i2).matcher(m18295a);
            if (matcher.find(i)) {
                aVar.f19216a = matcher.start();
                aVar.f19217b = matcher.end();
                aVar.f19218c = matcher.start() - Math.max(0, matcher.start() - 30);
                aVar.f19219d = matcher.group(0).length();
                m19255a(aVar, m18295a, 0, m19253a);
                return aVar;
            }
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        aVar.f19216a = -1;
        aVar.f19217b = -1;
        aVar.f19218c = -1;
        aVar.f19219d = -1;
        aVar.f19221f = (String) null;
        return aVar;
    }

    /* renamed from: a */
    private static int m19249a(String str, String str2, int i) {
        int i2 = 1;
        int i3 = 0;
        while (i3 != -1) {
            i3 = str.indexOf(str2, i3);
            if (i3 != -1) {
                i3 += str2.length();
                if (i3 > i) {
                    break;
                }
                i2++;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x012c, code lost:
    
        r6.f19216a = r2 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0135, code lost:
    
        r6.f19217b = (r2 + r5) + r17.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x013b, code lost:
    
        r6.f19219d = r17.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0150, code lost:
    
        m19255a(r6, new java.lang.StringBuffer().append(r6.f19221f).append(r11).toString(), r2, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0153, code lost:
    
        if (r7 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0158, code lost:
    
        if (r8 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x015a, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x02bb, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0155, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02b6, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02b1, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x02ac, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02a7, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x02a2, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x029d, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0298, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0293, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x028e, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0289, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0284, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x027f, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x027a, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0085, code lost:
    
        r6.f19220e = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0089, code lost:
    
        r6.f19216a = r3 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0092, code lost:
    
        r6.f19217b = (r3 + r5) + r17.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0098, code lost:
    
        r6.f19219d = r17.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x009a, code lost:
    
        m19255a(r6, r11, r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x009d, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x00a2, code lost:
    
        if (r8 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x00a4, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x01e9, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x009f, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x01e4, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x01e0, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x01dc, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x01d8, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x01d4, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x01d0, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x01cc, code lost:
    
        r3 = r7;
        r4 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0041 A[Catch: Exception -> 0x0178, TRY_LEAVE, TryCatch #4 {Exception -> 0x0178, blocks: (B:54:0x003c, B:47:0x0041), top: B:53:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a m19258b(File file, String str, boolean z, String str2, int i) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        a aVar = new a();
        BufferedReader bufferedReader3 = (BufferedReader) null;
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            try {
                String m19252a = m19252a(file);
                try {
                    try {
                        String[] split = str.split(m19253a(str), -1);
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        try {
                            try {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, str2));
                                                    int i5 = 0;
                                                    int i6 = 0;
                                                    while (true) {
                                                        try {
                                                            try {
                                                                try {
                                                                    String readLine = bufferedReader.readLine();
                                                                    if (readLine == null) {
                                                                        break;
                                                                    }
                                                                    i4++;
                                                                    try {
                                                                        try {
                                                                            if (readLine.length() + i6 + m19252a.length() < i) {
                                                                                try {
                                                                                    try {
                                                                                        i6 += readLine.length() + m19252a.length();
                                                                                    } catch (Error e2) {
                                                                                        fileInputStream2 = fileInputStream;
                                                                                        bufferedReader2 = bufferedReader;
                                                                                        fileInputStream = fileInputStream2;
                                                                                        bufferedReader = bufferedReader2;
                                                                                        if (fileInputStream != null) {
                                                                                        }
                                                                                        if (bufferedReader != null) {
                                                                                        }
                                                                                        aVar.f19216a = -1;
                                                                                        aVar.f19217b = -1;
                                                                                        aVar.f19218c = -1;
                                                                                        aVar.f19219d = -1;
                                                                                        aVar.f19221f = (String) null;
                                                                                        return aVar;
                                                                                    }
                                                                                } catch (Error e3) {
                                                                                    fileInputStream2 = fileInputStream;
                                                                                    bufferedReader2 = bufferedReader;
                                                                                }
                                                                            } else {
                                                                                int i7 = i6 >= i ? 0 : i - i6;
                                                                                try {
                                                                                    if (split.length == 1) {
                                                                                        try {
                                                                                            i2 = m19250a(readLine, str, z, i7);
                                                                                            if (i2 >= 0) {
                                                                                                try {
                                                                                                    break;
                                                                                                } catch (Error e4) {
                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                }
                                                                                            }
                                                                                        } catch (Error e5) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                        }
                                                                                    } else if (i3 == 0) {
                                                                                        try {
                                                                                            try {
                                                                                                if (m19260c(readLine, split[i3], z)) {
                                                                                                    try {
                                                                                                        try {
                                                                                                            i2 = m19250a(readLine, split[i3], z, i7);
                                                                                                            try {
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    aVar.f19221f = new StringBuffer().append(readLine).append(m19252a).toString();
                                                                                                                                    try {
                                                                                                                                        aVar.f19220e = i4;
                                                                                                                                        i3++;
                                                                                                                                        i5 = i6;
                                                                                                                                    } catch (Error e6) {
                                                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                                                        fileInputStream = fileInputStream2;
                                                                                                                                        bufferedReader = bufferedReader2;
                                                                                                                                        if (fileInputStream != null) {
                                                                                                                                        }
                                                                                                                                        if (bufferedReader != null) {
                                                                                                                                        }
                                                                                                                                        aVar.f19216a = -1;
                                                                                                                                        aVar.f19217b = -1;
                                                                                                                                        aVar.f19218c = -1;
                                                                                                                                        aVar.f19219d = -1;
                                                                                                                                        aVar.f19221f = (String) null;
                                                                                                                                        return aVar;
                                                                                                                                    }
                                                                                                                                } catch (Error e7) {
                                                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                                                }
                                                                                                                            } catch (Error e8) {
                                                                                                                                fileInputStream2 = fileInputStream;
                                                                                                                                bufferedReader2 = bufferedReader;
                                                                                                                            }
                                                                                                                        } catch (Error e9) {
                                                                                                                            fileInputStream2 = fileInputStream;
                                                                                                                            bufferedReader2 = bufferedReader;
                                                                                                                        }
                                                                                                                    } catch (Error e10) {
                                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                                    }
                                                                                                                } catch (Error e11) {
                                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                                }
                                                                                                            } catch (Error e12) {
                                                                                                                fileInputStream2 = fileInputStream;
                                                                                                                bufferedReader2 = bufferedReader;
                                                                                                            }
                                                                                                        } catch (Error e13) {
                                                                                                            fileInputStream2 = fileInputStream;
                                                                                                            bufferedReader2 = bufferedReader;
                                                                                                        }
                                                                                                    } catch (Error e14) {
                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Error e15) {
                                                                                                fileInputStream2 = fileInputStream;
                                                                                                bufferedReader2 = bufferedReader;
                                                                                            }
                                                                                        } catch (Error e16) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                        }
                                                                                    } else {
                                                                                        try {
                                                                                            if (i3 < split.length - 1) {
                                                                                                try {
                                                                                                    try {
                                                                                                        if (m19256a(readLine, split[i3], z)) {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                try {
                                                                                                                                                    try {
                                                                                                                                                        try {
                                                                                                                                                            aVar.f19221f = new StringBuffer().append(aVar.f19221f).append(new StringBuffer().append(readLine).append(m19252a).toString()).toString();
                                                                                                                                                            i3++;
                                                                                                                                                        } catch (Error e17) {
                                                                                                                                                            fileInputStream2 = fileInputStream;
                                                                                                                                                            bufferedReader2 = bufferedReader;
                                                                                                                                                            fileInputStream = fileInputStream2;
                                                                                                                                                            bufferedReader = bufferedReader2;
                                                                                                                                                            if (fileInputStream != null) {
                                                                                                                                                                try {
                                                                                                                                                                    fileInputStream.close();
                                                                                                                                                                } catch (Exception e18) {
                                                                                                                                                                    aVar.f19216a = -1;
                                                                                                                                                                    aVar.f19217b = -1;
                                                                                                                                                                    aVar.f19218c = -1;
                                                                                                                                                                    aVar.f19219d = -1;
                                                                                                                                                                    aVar.f19221f = (String) null;
                                                                                                                                                                    return aVar;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            if (bufferedReader != null) {
                                                                                                                                                                bufferedReader.close();
                                                                                                                                                            }
                                                                                                                                                            aVar.f19216a = -1;
                                                                                                                                                            aVar.f19217b = -1;
                                                                                                                                                            aVar.f19218c = -1;
                                                                                                                                                            aVar.f19219d = -1;
                                                                                                                                                            aVar.f19221f = (String) null;
                                                                                                                                                            return aVar;
                                                                                                                                                        }
                                                                                                                                                    } catch (Error e19) {
                                                                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                                                                    }
                                                                                                                                                } catch (Error e20) {
                                                                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                                                                }
                                                                                                                                            } catch (Error e21) {
                                                                                                                                                fileInputStream2 = fileInputStream;
                                                                                                                                                bufferedReader2 = bufferedReader;
                                                                                                                                            }
                                                                                                                                        } catch (Error e22) {
                                                                                                                                            fileInputStream2 = fileInputStream;
                                                                                                                                            bufferedReader2 = bufferedReader;
                                                                                                                                        }
                                                                                                                                    } catch (Error e23) {
                                                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                                                    }
                                                                                                                                } catch (Error e24) {
                                                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                                                }
                                                                                                                            } catch (Error e25) {
                                                                                                                                fileInputStream2 = fileInputStream;
                                                                                                                                bufferedReader2 = bufferedReader;
                                                                                                                            }
                                                                                                                        } catch (Error e26) {
                                                                                                                            fileInputStream2 = fileInputStream;
                                                                                                                            bufferedReader2 = bufferedReader;
                                                                                                                        }
                                                                                                                    } catch (Error e27) {
                                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                                    }
                                                                                                                } catch (Error e28) {
                                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                                }
                                                                                                            } catch (Error e29) {
                                                                                                                fileInputStream2 = fileInputStream;
                                                                                                                bufferedReader2 = bufferedReader;
                                                                                                            }
                                                                                                        } else {
                                                                                                            i3 = 0;
                                                                                                        }
                                                                                                    } catch (Error e30) {
                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                    }
                                                                                                } catch (Error e31) {
                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                }
                                                                                            } else {
                                                                                                try {
                                                                                                    try {
                                                                                                        if (m19259b(readLine, split[i3], z)) {
                                                                                                            break;
                                                                                                        }
                                                                                                        i3 = 0;
                                                                                                    } catch (Error e32) {
                                                                                                        fileInputStream2 = fileInputStream;
                                                                                                        bufferedReader2 = bufferedReader;
                                                                                                    }
                                                                                                } catch (Error e33) {
                                                                                                    fileInputStream2 = fileInputStream;
                                                                                                    bufferedReader2 = bufferedReader;
                                                                                                }
                                                                                            }
                                                                                        } catch (Error e34) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                        }
                                                                                    }
                                                                                    try {
                                                                                        try {
                                                                                            i6 += readLine.length() + m19252a.length();
                                                                                            i = i7;
                                                                                        } catch (Error e35) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                            fileInputStream = fileInputStream2;
                                                                                            bufferedReader = bufferedReader2;
                                                                                            if (fileInputStream != null) {
                                                                                            }
                                                                                            if (bufferedReader != null) {
                                                                                            }
                                                                                            aVar.f19216a = -1;
                                                                                            aVar.f19217b = -1;
                                                                                            aVar.f19218c = -1;
                                                                                            aVar.f19219d = -1;
                                                                                            aVar.f19221f = (String) null;
                                                                                            return aVar;
                                                                                        }
                                                                                    } catch (Error e36) {
                                                                                        fileInputStream2 = fileInputStream;
                                                                                        bufferedReader2 = bufferedReader;
                                                                                    }
                                                                                } catch (Error e37) {
                                                                                    fileInputStream2 = fileInputStream;
                                                                                    bufferedReader2 = bufferedReader;
                                                                                }
                                                                            }
                                                                        } catch (Error e38) {
                                                                            fileInputStream2 = fileInputStream;
                                                                            bufferedReader2 = bufferedReader;
                                                                        }
                                                                    } catch (Error e39) {
                                                                        fileInputStream2 = fileInputStream;
                                                                        bufferedReader2 = bufferedReader;
                                                                    }
                                                                } catch (Exception e40) {
                                                                    fileInputStream2 = fileInputStream;
                                                                    bufferedReader2 = bufferedReader;
                                                                }
                                                            } catch (Error e41) {
                                                                fileInputStream2 = fileInputStream;
                                                                bufferedReader2 = bufferedReader;
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            if (fileInputStream != null) {
                                                                try {
                                                                    fileInputStream.close();
                                                                } catch (Exception e42) {
                                                                    throw th;
                                                                }
                                                            }
                                                            if (bufferedReader != null) {
                                                                bufferedReader.close();
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Error e43) {
                                                    fileInputStream2 = fileInputStream;
                                                    bufferedReader2 = bufferedReader3;
                                                }
                                            } catch (Error e44) {
                                                fileInputStream2 = fileInputStream;
                                                bufferedReader2 = bufferedReader3;
                                            }
                                        } catch (Error e45) {
                                            fileInputStream2 = fileInputStream;
                                            bufferedReader2 = bufferedReader3;
                                        }
                                    } catch (Error e46) {
                                        fileInputStream2 = fileInputStream;
                                        bufferedReader2 = bufferedReader3;
                                    }
                                } catch (Exception e47) {
                                    fileInputStream2 = fileInputStream;
                                    bufferedReader2 = bufferedReader3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader3;
                                }
                            } catch (Error e48) {
                                bufferedReader2 = bufferedReader3;
                            }
                        } catch (Error e49) {
                            bufferedReader2 = bufferedReader3;
                        }
                    } catch (Error e50) {
                        bufferedReader2 = bufferedReader3;
                    }
                } catch (Error e51) {
                    bufferedReader2 = bufferedReader3;
                }
            } catch (Error e52) {
                bufferedReader2 = bufferedReader3;
            }
        } catch (Exception e53) {
            bufferedReader2 = bufferedReader3;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            bufferedReader = bufferedReader3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0090, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x011c, code lost:
    
        r1 = r4;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0045, code lost:
    
        r0 = r1 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0047, code lost:
    
        if (r4 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x004c, code lost:
    
        if (r5 == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004e, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f4, code lost:
    
        r1 = r4;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0049, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f0, code lost:
    
        r1 = r4;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x008d, code lost:
    
        r0 = r0 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x008e, code lost:
    
        if (r4 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0093, code lost:
    
        if (r5 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0095, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0120, code lost:
    
        r1 = r4;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0035 A[Catch: Exception -> 0x00b1, TRY_LEAVE, TryCatch #7 {Exception -> 0x00b1, blocks: (B:51:0x0030, B:45:0x0035), top: B:50:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m19248a(File file, String str, boolean z, String str2) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = (BufferedReader) null;
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            try {
                String m19252a = m19252a(file);
                try {
                    try {
                        String[] split = str.split(m19253a(str), -1);
                        int i = 0;
                        int i2 = 0;
                        try {
                            try {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, str2));
                                                    int i3 = 0;
                                                    int i4 = 0;
                                                    while (true) {
                                                        try {
                                                            try {
                                                                try {
                                                                    String readLine = bufferedReader.readLine();
                                                                    if (readLine == null) {
                                                                        break;
                                                                    }
                                                                    try {
                                                                        if (split.length == 1) {
                                                                            try {
                                                                                i = m19250a(readLine, str, z, 0);
                                                                                if (i >= 0) {
                                                                                    break;
                                                                                }
                                                                            } catch (Error e2) {
                                                                                fileInputStream2 = fileInputStream;
                                                                                bufferedReader2 = bufferedReader;
                                                                            }
                                                                        } else if (i2 == 0) {
                                                                            try {
                                                                                try {
                                                                                    if (m19260c(readLine, split[i2], z)) {
                                                                                        try {
                                                                                            try {
                                                                                                i = m19250a(readLine, split[i2], z, 0);
                                                                                                i2++;
                                                                                                i3 = i4;
                                                                                            } catch (Error e3) {
                                                                                                fileInputStream2 = fileInputStream;
                                                                                                bufferedReader2 = bufferedReader;
                                                                                                fileInputStream = fileInputStream2;
                                                                                                bufferedReader = bufferedReader2;
                                                                                                if (fileInputStream != null) {
                                                                                                }
                                                                                                if (bufferedReader != null) {
                                                                                                }
                                                                                                return -1;
                                                                                            }
                                                                                        } catch (Error e4) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                        }
                                                                                    }
                                                                                } catch (Error e5) {
                                                                                    fileInputStream2 = fileInputStream;
                                                                                    bufferedReader2 = bufferedReader;
                                                                                }
                                                                            } catch (Error e6) {
                                                                                fileInputStream2 = fileInputStream;
                                                                                bufferedReader2 = bufferedReader;
                                                                            }
                                                                        } else {
                                                                            try {
                                                                                if (i2 < split.length - 1) {
                                                                                    try {
                                                                                        try {
                                                                                            i2 = m19256a(readLine, split[i2], z) ? i2 + 1 : 0;
                                                                                        } catch (Error e7) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                            fileInputStream = fileInputStream2;
                                                                                            bufferedReader = bufferedReader2;
                                                                                            if (fileInputStream != null) {
                                                                                            }
                                                                                            if (bufferedReader != null) {
                                                                                            }
                                                                                            return -1;
                                                                                        }
                                                                                    } catch (Error e8) {
                                                                                        fileInputStream2 = fileInputStream;
                                                                                        bufferedReader2 = bufferedReader;
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        try {
                                                                                            if (m19259b(readLine, split[i2], z)) {
                                                                                                break;
                                                                                            }
                                                                                            i2 = 0;
                                                                                        } catch (Error e9) {
                                                                                            fileInputStream2 = fileInputStream;
                                                                                            bufferedReader2 = bufferedReader;
                                                                                        }
                                                                                    } catch (Error e10) {
                                                                                        fileInputStream2 = fileInputStream;
                                                                                        bufferedReader2 = bufferedReader;
                                                                                    }
                                                                                }
                                                                            } catch (Error e11) {
                                                                                fileInputStream2 = fileInputStream;
                                                                                bufferedReader2 = bufferedReader;
                                                                            }
                                                                        }
                                                                        try {
                                                                            try {
                                                                                i4 += readLine.length() + m19252a.length();
                                                                            } catch (Error e12) {
                                                                                fileInputStream2 = fileInputStream;
                                                                                bufferedReader2 = bufferedReader;
                                                                                fileInputStream = fileInputStream2;
                                                                                bufferedReader = bufferedReader2;
                                                                                if (fileInputStream != null) {
                                                                                }
                                                                                if (bufferedReader != null) {
                                                                                }
                                                                                return -1;
                                                                            }
                                                                        } catch (Error e13) {
                                                                            fileInputStream2 = fileInputStream;
                                                                            bufferedReader2 = bufferedReader;
                                                                        }
                                                                    } catch (Error e14) {
                                                                        fileInputStream2 = fileInputStream;
                                                                        bufferedReader2 = bufferedReader;
                                                                    }
                                                                } catch (Error e15) {
                                                                    fileInputStream2 = fileInputStream;
                                                                    bufferedReader2 = bufferedReader;
                                                                }
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                if (fileInputStream != null) {
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (Exception e16) {
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (bufferedReader != null) {
                                                                    bufferedReader.close();
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (Exception e17) {
                                                            fileInputStream2 = fileInputStream;
                                                            bufferedReader2 = bufferedReader;
                                                        }
                                                    }
                                                } catch (Error e18) {
                                                    fileInputStream2 = fileInputStream;
                                                    bufferedReader2 = bufferedReader3;
                                                }
                                            } catch (Error e19) {
                                                fileInputStream2 = fileInputStream;
                                                bufferedReader2 = bufferedReader3;
                                            }
                                        } catch (Error e20) {
                                            fileInputStream2 = fileInputStream;
                                            bufferedReader2 = bufferedReader3;
                                        }
                                    } catch (Error e21) {
                                        fileInputStream2 = fileInputStream;
                                        bufferedReader2 = bufferedReader3;
                                    }
                                } catch (Exception e22) {
                                    fileInputStream2 = fileInputStream;
                                    bufferedReader2 = bufferedReader3;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader3;
                                }
                            } catch (Error e23) {
                                bufferedReader2 = bufferedReader3;
                            }
                        } catch (Error e24) {
                            bufferedReader2 = bufferedReader3;
                        }
                    } catch (Error e25) {
                        bufferedReader2 = bufferedReader3;
                    }
                } catch (Error e26) {
                    bufferedReader2 = bufferedReader3;
                }
            } catch (Error e27) {
                bufferedReader2 = bufferedReader3;
            }
        } catch (Exception e28) {
            bufferedReader2 = bufferedReader3;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            bufferedReader = bufferedReader3;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e29) {
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return -1;
    }

    /* renamed from: a */
    public static int m19250a(String str, String str2, boolean z, int i) {
        return z ? str.toLowerCase().indexOf(str2.toLowerCase(), i) : str.indexOf(str2, i);
    }

    /* renamed from: a */
    public static boolean m19256a(String str, String str2, boolean z) {
        return z ? str.equalsIgnoreCase(str2) : str.equals(str2);
    }

    /* renamed from: b */
    public static boolean m19259b(String str, String str2, boolean z) {
        return z ? str.toLowerCase().startsWith(str2.toLowerCase()) : str.startsWith(str2);
    }

    /* renamed from: c */
    public static boolean m19260c(String str, String str2, boolean z) {
        return z ? str.toLowerCase().endsWith(str2.toLowerCase()) : str.endsWith(str2);
    }

    /* renamed from: a */
    public static String m19252a(File file) {
        FileInputStream fileInputStream;
        char read;
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (fileInputStream.available() > 0) {
                char read2 = (char) fileInputStream.read();
                if (read2 == '\n' || read2 == '\r') {
                    sb.append(read2);
                    if (fileInputStream.available() > 0 && (read = (char) fileInputStream.read()) != read2 && (read == '\r' || read == '\n')) {
                        sb.append(read);
                    }
                    String sb2 = sb.toString();
                    if (fileInputStream == null) {
                        return sb2;
                    }
                    fileInputStream.close();
                    return sb2;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "\n";
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream == null) {
                throw th;
            }
            fileInputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static String m19253a(String str) {
        char c2;
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c3 = charArray[i];
            if (c3 == '\n' || c3 == '\r') {
                sb.append(c3);
                if (i < charArray.length - 1 && (c2 = charArray[i + 1]) != c3 && (c2 == '\r' || c2 == '\n')) {
                    sb.append(c2);
                }
                return sb.toString();
            }
        }
        return "\n";
    }

    /* renamed from: a */
    private static void m19255a(a aVar, String str, int i, String str2) {
        int i2;
        String stringBuffer;
        int indexOf;
        if (aVar.f19220e == -1) {
            aVar.f19220e = m19249a(str, str2, aVar.f19216a);
        }
        String str3 = "";
        int i3 = aVar.f19216a - i;
        if (i3 > 30) {
            i2 = i3 - 30;
            String str4 = "...";
            int indexOf2 = str.indexOf(str2, i3 - 30);
            while (indexOf2 != -1 && indexOf2 <= i3) {
                i2 = indexOf2 + 1;
                str4 = "";
                indexOf2 = str.indexOf(str2, i2);
            }
            str3 = new StringBuffer().append("").append(str4).toString();
        } else {
            int indexOf3 = str.indexOf(str2);
            i2 = 0;
            while (indexOf3 != -1 && indexOf3 <= i3) {
                i2 = indexOf3 + 1;
                indexOf3 = str.indexOf(str2, i2);
            }
        }
        aVar.f19218c = (i3 - i2) + str3.length();
        if (str.length() - i2 > 130) {
            stringBuffer = new StringBuffer().append(str3).append(new StringBuffer().append(str.substring(i2, i2 + 130)).append("...").toString()).toString();
        } else {
            stringBuffer = new StringBuffer().append(str3).append(str.substring(i2, str.length())).toString();
        }
        if (aVar.f19219d + aVar.f19218c < stringBuffer.length() && (indexOf = stringBuffer.indexOf(str2, aVar.f19219d + aVar.f19218c)) != -1) {
            stringBuffer = stringBuffer.substring(0, indexOf);
        }
        if (aVar.f19219d + aVar.f19218c > stringBuffer.length()) {
            aVar.f19219d = stringBuffer.length() - aVar.f19218c;
        }
        aVar.f19221f = stringBuffer;
    }

    /* renamed from: a */
    public static File m19251a(File file, String str, String str2) {
        File[] listFiles;
        int i = 0;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            File[] listFiles2 = file.listFiles(new FilenameFilter(str.substring(0, indexOf)) { // from class: ru.maximoff.apktool.util.d.e.1

                /* renamed from: a */
                private final String f19214a;

                {
                    this.f19214a = r1;
                }

                @Override // java.p209io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.equals(this.f19214a) || str3.matches(new StringBuffer().append(new StringBuffer().append("^").append(C3112bn.m19024c((CharSequence) this.f19214a)).toString()).append("\\.\\d+$").toString());
                }
            });
            if (listFiles2 == null || listFiles2.length == 0) {
                return (File) null;
            }
            while (i < listFiles2.length) {
                File m19251a = m19251a(listFiles2[i], str.substring(indexOf + 1), str2);
                if (m19251a != null) {
                    return m19251a;
                }
                i++;
            }
        } else {
            File file2 = new File(file, new StringBuffer().append(str).append(".smali").toString());
            if (file2.isFile() && C3262u.m19615a(file2, new StringBuffer().append(str).append(".smali").toString())) {
                listFiles = new File[]{file2};
            } else {
                listFiles = file.listFiles(new FilenameFilter(str) { // from class: ru.maximoff.apktool.util.d.e.2

                    /* renamed from: a */
                    private final String f19215a;

                    {
                        this.f19215a = str;
                    }

                    @Override // java.p209io.FilenameFilter
                    public boolean accept(File file3, String str3) {
                        return str3.equals(new StringBuffer().append(this.f19215a).append(".smali").toString()) || str3.matches(new StringBuffer().append(new StringBuffer().append("^").append(C3112bn.m19024c((CharSequence) this.f19215a)).toString()).append("\\.\\d+\\.smali$").toString());
                    }
                });
            }
            if (listFiles != null) {
                while (i < listFiles.length) {
                    File file3 = listFiles[i];
                    if (file3.isFile() && C3061a.m18294a(file3, 1).trim().endsWith(new StringBuffer().append(new StringBuffer().append("L").append(str2).toString()).append(";").toString())) {
                        return file3;
                    }
                    i++;
                }
            }
        }
        return (File) null;
    }

    /* compiled from: SearchUtils.java */
    /* renamed from: ru.maximoff.apktool.util.d.e$a */
    public static class a {

        /* renamed from: a */
        public int f19216a;

        /* renamed from: b */
        public int f19217b;

        /* renamed from: c */
        public int f19218c;

        /* renamed from: d */
        public int f19219d;

        /* renamed from: f */
        public String f19221f;

        /* renamed from: e */
        public int f19220e = -1;

        /* renamed from: g */
        public boolean f19222g = false;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{new Integer(this.f19216a), new Integer(this.f19217b), new Integer(this.f19218c), new Integer(this.f19219d), new Integer(this.f19220e), this.f19221f, new Boolean(this.f19222g)});
        }
    }
}
