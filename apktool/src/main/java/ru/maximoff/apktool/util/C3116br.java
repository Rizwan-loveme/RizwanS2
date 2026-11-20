package ru.maximoff.apktool.util;

import java.p209io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: YamlConvert.java */
/* renamed from: ru.maximoff.apktool.util.br */
/* loaded from: classes.dex */
public class C3116br {

    /* renamed from: a */
    private File f18394a;

    /* renamed from: b */
    private List<String> f18395b;

    /* renamed from: c */
    private String f18396c;

    /* renamed from: d */
    private int f18397d;

    /* renamed from: e */
    private List<String> f18398e = m19050a();

    public C3116br(File file) {
        this.f18397d = 0;
        this.f18394a = file;
        this.f18397d = this.f18394a.getParent().length() + 1;
        this.f18395b = C3061a.m18331h(file);
    }

    public String toString() {
        return this.f18396c;
    }

    /* renamed from: a */
    public void m19052a(File file) {
        C2468c c2468c = new C2468c();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f18395b.size()) {
                break;
            }
            String trim = this.f18395b.get(i2).trim();
            if (!trim.startsWith("!") && !trim.equals("")) {
                for (String str : this.f18398e) {
                    if (trim.startsWith(str)) {
                        try {
                            c2468c.m15608a(m19049a(str), m19048a(str, i2));
                        } catch (C2467b e2) {
                        }
                    }
                }
            }
            i = i2 + 1;
        }
        this.f18396c = c2468c.toString();
        if (file != null) {
            try {
                C3061a.m18319b(file, c2468c.m15603a(2));
            } catch (C2467b e3) {
                C3061a.m18319b(file, this.f18396c);
            }
        }
    }

    /* renamed from: a */
    private Object m19048a(String str, int i) {
        String str2 = this.f18395b.get(i);
        if (str.equals("version:") || str.equals("apkFileName:")) {
            return str2.substring(str.length()).trim();
        }
        if (str.equals("compressionType:") || str.equals("isFrameworkApk:") || str.equals("sharedLibrary:") || str.equals("sparseResources:") || str.equals("compactEntries:")) {
            return Boolean.valueOf(str2.substring(str.length()).trim());
        }
        if (str2.equals(str) && i < this.f18395b.size() - 1) {
            return m19051b(str, i);
        }
        if (str2.length() > str.length()) {
            String replace = str2.split(":")[1].trim().replace("'", "");
            if (replace.equals("null") || replace.equals("{}") || replace.equals("[]")) {
                return C2468c.f12954b;
            }
            return String.valueOf(replace);
        }
        return C2468c.f12954b;
    }

    /* renamed from: b */
    private Object m19051b(String str, int i) {
        if (str.equals("doNotCompress:")) {
            C2466a c2466a = new C2466a();
            int i2 = i + 1;
            while (true) {
                int i3 = i2;
                if (i3 >= this.f18395b.size()) {
                    return c2466a;
                }
                String trim = this.f18395b.get(i3).trim();
                if (!trim.startsWith("!") && !trim.equals("")) {
                    Iterator<String> it = this.f18398e.iterator();
                    while (it.hasNext()) {
                        if (trim.startsWith(it.next())) {
                            return c2466a;
                        }
                    }
                    c2466a.m15574a(trim.startsWith("- ") ? trim.substring(2) : trim);
                }
                i2 = i3 + 1;
            }
        } else if (str.equals("unknownFiles:") || str.equals("packageInfo:") || str.equals("versionInfo:") || str.equals("sdkInfo:")) {
            C2468c c2468c = new C2468c();
            int i4 = i + 1;
            while (true) {
                int i5 = i4;
                if (i5 >= this.f18395b.size()) {
                    return c2468c;
                }
                String trim2 = this.f18395b.get(i5).trim();
                if (!trim2.startsWith("!") && !trim2.equals("")) {
                    Iterator<String> it2 = this.f18398e.iterator();
                    while (it2.hasNext()) {
                        if (trim2.startsWith(it2.next())) {
                            return c2468c;
                        }
                    }
                    String[] split = trim2.split(":");
                    Object replace = split[1].trim().replace("'", "");
                    if (((String) replace).equals("null") || ((String) replace).equals("{}") || ((String) replace).equals("[]")) {
                        replace = C2468c.f12954b;
                    }
                    c2468c.m15608a(split[0].trim(), replace);
                }
                i4 = i5 + 1;
            }
        } else if (str.equals("usesFramework:")) {
            C2468c c2468c2 = new C2468c();
            int i6 = i + 1;
            while (true) {
                int i7 = i6;
                if (i7 >= this.f18395b.size()) {
                    return c2468c2;
                }
                String trim3 = this.f18395b.get(i7).trim();
                if (!trim3.startsWith("!") && !trim3.equals("")) {
                    Iterator<String> it3 = this.f18398e.iterator();
                    while (it3.hasNext()) {
                        if (trim3.startsWith(it3.next())) {
                            return c2468c2;
                        }
                    }
                    if (trim3.startsWith("tag:")) {
                        String[] split2 = trim3.split(":");
                        Object replace2 = split2[1].trim().replace("'", "");
                        if (((String) replace2).equals("null") || ((String) replace2).equals("{}") || ((String) replace2).equals("[]")) {
                            replace2 = C2468c.f12954b;
                        }
                        c2468c2.m15608a(split2[0].trim(), replace2);
                    } else if (trim3.startsWith("ids:")) {
                        c2468c2.m15608a("ids", m19051b("ids:", i7));
                    }
                }
                i6 = i7 + 1;
            }
        } else if (str.equals("featureFlags:")) {
            C2468c c2468c3 = new C2468c();
            int i8 = i + 1;
            while (true) {
                int i9 = i8;
                if (i9 >= this.f18395b.size()) {
                    return c2468c3;
                }
                String trim4 = this.f18395b.get(i9).trim();
                if (!trim4.startsWith("!") && !trim4.equals("")) {
                    Iterator<String> it4 = this.f18398e.iterator();
                    while (it4.hasNext()) {
                        if (trim4.startsWith(it4.next())) {
                            return c2468c3;
                        }
                    }
                    String[] split3 = trim4.split(":");
                    c2468c3.m15609a(split3[0].trim(), Boolean.valueOf(split3[1].trim()).booleanValue());
                }
                i8 = i9 + 1;
            }
        } else if (str.equals("ids:")) {
            C2466a c2466a2 = new C2466a();
            int i10 = i + 1;
            while (true) {
                int i11 = i10;
                if (i11 >= this.f18395b.size()) {
                    return c2466a2;
                }
                String trim5 = this.f18395b.get(i11).trim();
                if (!trim5.startsWith("!") && !trim5.equals("")) {
                    if (trim5.startsWith("tag:")) {
                        return c2466a2;
                    }
                    Iterator<String> it5 = this.f18398e.iterator();
                    while (it5.hasNext()) {
                        if (trim5.startsWith(it5.next())) {
                            return c2466a2;
                        }
                    }
                    c2466a2.m15582i(Integer.parseInt(trim5.startsWith("- ") ? trim5.substring(2) : trim5));
                }
                i10 = i11 + 1;
            }
        } else {
            return C2468c.f12954b;
        }
    }

    /* renamed from: a */
    private String m19049a(String str) {
        if (str.equals("usesFramework:")) {
            return "UsesFramework";
        }
        if (str.equals("packageInfo:")) {
            return "PackageInfo";
        }
        if (str.equals("versionInfo:")) {
            return "VersionInfo";
        }
        return str.replace(":", "");
    }

    /* renamed from: a */
    private List<String> m19050a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("apkFileName:");
        arrayList.add("compressionType:");
        arrayList.add("doNotCompress:");
        arrayList.add("isFrameworkApk:");
        arrayList.add("packageInfo:");
        arrayList.add("sdkInfo:");
        arrayList.add("sharedLibrary:");
        arrayList.add("sparseResources:");
        arrayList.add("compactEntries:");
        arrayList.add("unknownFiles:");
        arrayList.add("usesFramework:");
        arrayList.add("version:");
        arrayList.add("versionInfo:");
        arrayList.add("featureFlags:");
        return arrayList;
    }
}
