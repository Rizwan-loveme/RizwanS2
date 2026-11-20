package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.provider.Telephony;
import com.p065b.p066a.p067a.AbstractC0581c;
import java.lang.reflect.InvocationTargetException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.util.p308f.C3239s;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: Manifest.java */
/* renamed from: ru.maximoff.apktool.util.am */
/* loaded from: classes.dex */
public class C3081am {

    /* renamed from: a */
    private final String f17988a = "http://schemas.android.com/apk/res/android";

    /* renamed from: b */
    private File f17989b;

    /* renamed from: c */
    private int f17990c;

    /* renamed from: d */
    private int f17991d;

    /* renamed from: e */
    private int f17992e;

    /* renamed from: f */
    private String f17993f;

    /* renamed from: g */
    private int f17994g;

    /* renamed from: h */
    private String f17995h;

    /* renamed from: i */
    private String f17996i;

    /* renamed from: j */
    private String f17997j;

    /* renamed from: k */
    private String f17998k;

    /* renamed from: l */
    private String f17999l;

    /* renamed from: m */
    private String f18000m;

    /* renamed from: n */
    private int f18001n;

    /* renamed from: o */
    private int f18002o;

    /* renamed from: p */
    private boolean f18003p;

    /* renamed from: q */
    private boolean f18004q;

    /* renamed from: r */
    private boolean f18005r;

    /* renamed from: s */
    private boolean f18006s;

    /* renamed from: t */
    private boolean f18007t;

    /* renamed from: u */
    private Resources f18008u;

    /* renamed from: v */
    private PackageManager f18009v;

    /* renamed from: w */
    private List<String> f18010w;

    public C3081am(File file) {
        this.f17989b = file;
        m18623a();
    }

    /* renamed from: a */
    public void m18623a() {
        this.f17990c = 0;
        this.f17991d = 0;
        this.f17992e = -1;
        this.f17993f = "";
        this.f17994g = 0;
        this.f17995h = "";
        this.f17996i = "";
        this.f18001n = 0;
        this.f18002o = 0;
        this.f18003p = false;
        this.f18004q = false;
        this.f18005r = false;
        this.f18006s = false;
        this.f18007t = true;
        this.f18010w = new ArrayList();
        try {
            m18620w();
        } catch (Exception e2) {
        }
    }

    /* renamed from: w */
    private void m18620w() {
        String str = (String) null;
        XmlResourceParser m18617a = m18617a(this.f17989b);
        String str2 = (String) null;
        boolean z = false;
        while (m18617a.next() != 1) {
            if (m18617a.getEventType() == 2 && m18617a.getName().equals("manifest")) {
                for (int i = 0; i < m18617a.getAttributeCount(); i++) {
                    if (m18617a.getAttributeName(i).equals(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME)) {
                        this.f17995h = String.valueOf(m18617a.getAttributeValue(i));
                    }
                    if (m18617a.getAttributeName(i).equals("installLocation") && m18617a.getAttributeValue(i).matches("^-?\\d+$")) {
                        this.f17992e = Integer.parseInt(m18617a.getAttributeValue(i));
                        if (this.f17992e > 2 || this.f17992e < 0) {
                            this.f17992e = -1;
                        }
                    }
                    if (m18617a.getAttributeName(i).equals("versionName")) {
                        this.f17993f = String.valueOf(m18617a.getAttributeValue(i));
                    }
                    if (m18617a.getAttributeName(i).equals("versionCode") && m18617a.getAttributeValue(i).matches("^\\d+$")) {
                        this.f17994g = Integer.parseInt(m18617a.getAttributeValue(i));
                    }
                    if (m18617a.getAttributeName(i).equals("sharedUserId")) {
                        this.f18000m = String.valueOf(m18617a.getAttributeValue(i));
                    }
                }
            }
            if (m18617a.getEventType() == 2 && m18617a.getName().equals("uses-sdk")) {
                for (int i2 = 0; i2 < m18617a.getAttributeCount(); i2++) {
                    if (m18617a.getAttributeName(i2).equals("minSdkVersion") && m18617a.getAttributeValue(i2).matches("^\\d+$")) {
                        this.f17990c = Integer.parseInt(m18617a.getAttributeValue(i2));
                    }
                    if (m18617a.getAttributeName(i2).equals("targetSdkVersion") && m18617a.getAttributeValue(i2).matches("^\\d+$")) {
                        this.f17991d = Integer.parseInt(m18617a.getAttributeValue(i2));
                    }
                }
            }
            if (m18617a.getEventType() == 2 && m18617a.getName().startsWith("uses-permission")) {
                for (int i3 = 0; i3 < m18617a.getAttributeCount(); i3++) {
                    if (m18617a.getAttributeName(i3).equals("name")) {
                        String valueOf = String.valueOf(m18617a.getAttributeValue(i3));
                        if (!this.f18010w.contains(valueOf)) {
                            this.f18010w.add(valueOf);
                        }
                    }
                }
            }
            if (m18617a.getEventType() == 2 && m18617a.getName().equals("application")) {
                for (int i4 = 0; i4 < m18617a.getAttributeCount(); i4++) {
                    if (m18617a.getAttributeName(i4).equals("label")) {
                        this.f17996i = String.valueOf(m18617a.getAttributeValue(i4));
                    }
                    if (m18617a.getAttributeName(i4).equals("icon") && m18617a.getAttributeValue(i4).matches("^@-?\\d+$")) {
                        this.f18001n = Integer.parseInt(m18617a.getAttributeValue(i4).substring(1));
                    }
                    if (m18617a.getAttributeName(i4).equals("roundIcon") && m18617a.getAttributeValue(i4).matches("^@-?\\d+$")) {
                        this.f18002o = Integer.parseInt(m18617a.getAttributeValue(i4).substring(1));
                    }
                    if (m18617a.getAttributeName(i4).equals("isSplitRequired") && m18617a.getAttributeValue(i4).matches("^(true|false)$")) {
                        this.f18003p = Boolean.valueOf(m18617a.getAttributeValue(i4)).booleanValue();
                    }
                    if (m18617a.getAttributeName(i4).equals("debuggable") && m18617a.getAttributeValue(i4).matches("^(true|false)$")) {
                        this.f18005r = Boolean.valueOf(m18617a.getAttributeValue(i4)).booleanValue();
                    }
                    if (m18617a.getAttributeName(i4).equals("testOnly") && m18617a.getAttributeValue(i4).matches("^(true|false)$")) {
                        this.f18006s = Boolean.valueOf(m18617a.getAttributeValue(i4)).booleanValue();
                    }
                    if (m18617a.getAttributeName(i4).equals("extractNativeLibs") && m18617a.getAttributeValue(i4).matches("^(true|false)$")) {
                        this.f18007t = Boolean.valueOf(m18617a.getAttributeValue(i4)).booleanValue();
                    }
                    if (m18617a.getAttributeName(i4).equals("name")) {
                        this.f17997j = String.valueOf(m18617a.getAttributeValue(i4));
                    }
                }
            }
            if (m18617a.getEventType() == 3 && (m18617a.getName().equals(Context.ACTIVITY_SERVICE) || m18617a.getName().equals("activity-alias"))) {
                str2 = (String) null;
                z = false;
            }
            if (this.f17998k == null && m18617a.getEventType() == 2) {
                if (m18617a.getName().equals(Context.ACTIVITY_SERVICE) || m18617a.getName().equals("activity-alias")) {
                    boolean z2 = true;
                    for (int i5 = 0; i5 < m18617a.getAttributeCount(); i5++) {
                        if (m18617a.getAttributeName(i5).equals("name") || m18617a.getAttributeName(i5).equals("targetActivity")) {
                            str2 = String.valueOf(m18617a.getAttributeValue(i5));
                        } else if (m18617a.getAttributeName(i5).equals("enabled") && m18617a.getAttributeValue(i5).equals("false")) {
                            str2 = (String) null;
                            z2 = false;
                        } else if (m18617a.getAttributeName(i5).equals("label")) {
                            str = String.valueOf(m18617a.getAttributeValue(i5));
                        }
                    }
                    z = z2;
                }
                if (z && str2 != null && m18617a.getName().equals("category")) {
                    for (int i6 = 0; i6 < m18617a.getAttributeCount(); i6++) {
                        if (m18617a.getAttributeName(i6).equals("name") && m18617a.getAttributeValue(i6).equals(Intent.CATEGORY_LAUNCHER)) {
                            this.f17998k = str2;
                            this.f17999l = str;
                        }
                    }
                }
            }
            if (!this.f18003p && !this.f18004q && m18617a.getEventType() == 2 && m18617a.getName().startsWith("meta-data")) {
                boolean z3 = false;
                boolean z4 = false;
                for (int i7 = 0; i7 < m18617a.getAttributeCount(); i7++) {
                    if (m18617a.getAttributeName(i7).equals("name")) {
                        if ("com.android.vending.splits.required".equals(String.valueOf(m18617a.getAttributeValue(i7)))) {
                            z4 = true;
                        }
                    } else if (m18617a.getAttributeName(i7).equals("value") && m18617a.getAttributeValue(i7).matches("^(true|false)$")) {
                        z3 = Boolean.valueOf(m18617a.getAttributeValue(i7)).booleanValue();
                    }
                }
                if (z4 && z3) {
                    this.f18004q = true;
                }
            }
        }
    }

    /* renamed from: x */
    private String m18621x() {
        String str;
        String valueOf;
        String attributeValue;
        String m18535a;
        StringBuilder sb = new StringBuilder();
        try {
            HashMap hashMap = new HashMap();
            sb.append(new StringBuffer().append(new StringBuffer().append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- Decoded from \"").append(this.f17989b.getAbsolutePath()).toString()).append("\" -->").toString());
            int i = 0;
            String str2 = (String) null;
            XmlResourceParser m18617a = m18617a(this.f17989b);
            while (m18617a.next() != 1) {
                if (m18617a.getEventType() == 2) {
                    if (str2 != null) {
                        if (str2.equals("manifest")) {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18619b(i)).append("xmlns:").toString()).append(entry.getValue()).toString()).append("=\"").toString()).append(entry.getKey()).toString()).append("\"").toString());
                            }
                        }
                        sb.append(">");
                    }
                    String name = m18617a.getName();
                    if (this.f18009v != null && name != null && name.equals("uses-permission") && (attributeValue = m18617a.getAttributeValue("http://schemas.android.com/apk/res/android", "name")) != null && (m18535a = C3080al.m18535a(this.f18009v, attributeValue)) != null) {
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18619b(i)).append("<!-- ").toString()).append(m18535a).toString()).append(" -->").toString());
                    }
                    sb.append(new StringBuffer().append(new StringBuffer().append(m18619b(i)).append("<").toString()).append(name).toString());
                    if (m18617a.getAttributeCount() > 0) {
                        i++;
                        for (int i2 = 0; i2 < m18617a.getAttributeCount(); i2++) {
                            String attributeNamespace = m18617a.getAttributeNamespace(i2);
                            if (attributeNamespace == null || attributeNamespace.equals("")) {
                                str = "";
                            } else {
                                int lastIndexOf = attributeNamespace.lastIndexOf(47);
                                if (lastIndexOf == -1 || lastIndexOf >= attributeNamespace.length() - 1) {
                                    str = attributeNamespace;
                                } else {
                                    String substring = attributeNamespace.substring(lastIndexOf + 1);
                                    hashMap.put(attributeNamespace, substring);
                                    str = new StringBuffer().append(substring).append(":").toString();
                                }
                            }
                            String valueOf2 = String.valueOf(m18617a.getAttributeName(i2));
                            if (str.equals("android:")) {
                                if (valueOf2.equals("installLocation")) {
                                    valueOf = C3095b.m18797f(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("windowSoftInputMode")) {
                                    valueOf = C3095b.m18795d(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("launchMode")) {
                                    valueOf = C3095b.m18793b(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("screenOrientation")) {
                                    valueOf = C3095b.m18792a(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("configChanges")) {
                                    valueOf = C3095b.m18794c(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("protectionLevel")) {
                                    valueOf = C3095b.m18796e(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("appCategory")) {
                                    valueOf = C3095b.m18798g(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("foregroundServiceType")) {
                                    valueOf = C3095b.m18799h(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("gwpAsanMode")) {
                                    valueOf = C3095b.m18800i(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("uiOptions")) {
                                    valueOf = C3095b.m18801j(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("autoRevokePermissions")) {
                                    valueOf = C3095b.m18802k(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("pageSizeCompat")) {
                                    valueOf = C3095b.m18803l(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("intentMatchingFlags")) {
                                    valueOf = C3095b.m18804m(m18617a.getAttributeIntValue(i2, 0));
                                } else if (valueOf2.equals("memtagMode")) {
                                    valueOf = C3095b.m18805n(m18617a.getAttributeIntValue(i2, 0));
                                } else {
                                    valueOf = String.valueOf(m18617a.getAttributeValue(i2));
                                }
                            } else {
                                valueOf = String.valueOf(m18617a.getAttributeValue(i2));
                            }
                            if (valueOf.matches("^@-?\\d+$")) {
                                int parseInt = Integer.parseInt(valueOf.substring(1));
                                if (this.f18008u != null) {
                                    valueOf = new StringBuffer().append("@").append(m18618a(parseInt)).toString();
                                } else {
                                    valueOf = String.format("@0x%08x", new Integer(parseInt));
                                }
                            }
                            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18619b(i)).append(str).toString()).append(valueOf2).toString()).append("=\"").toString()).append(C3239s.m19436h(valueOf)).toString()).append("\"").toString());
                        }
                        str2 = name;
                    } else {
                        i++;
                        str2 = name;
                    }
                }
                if (m18617a.getEventType() == 3) {
                    i--;
                    if (str2 != null && str2.equals(m18617a.getName())) {
                        sb.append(" />");
                    } else {
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18619b(i)).append("</").toString()).append(m18617a.getName()).toString()).append(">").toString());
                    }
                    str2 = (String) null;
                }
            }
        } catch (Exception e2) {
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m18625a(Resources resources) {
        this.f18008u = resources;
    }

    /* renamed from: a */
    public void m18624a(PackageManager packageManager, PackageInfo packageInfo) {
        this.f18009v = packageManager;
        try {
            this.f18008u = packageManager.getResourcesForApplication(packageInfo.applicationInfo);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    private String m18618a(int i) {
        try {
            String resourceName = this.f18008u.getResourceName(i);
            if (!this.f17995h.isEmpty() && resourceName.startsWith(this.f17995h)) {
                return resourceName.split(":", 2)[1];
            }
            return resourceName;
        } catch (Exception e2) {
            return String.format("0x%08x", new Integer(i));
        }
    }

    /* renamed from: b */
    public Resources m18626b() {
        return this.f18008u;
    }

    /* renamed from: c */
    public List<String> m18627c() {
        return this.f18010w;
    }

    /* renamed from: d */
    public boolean m18628d() {
        return this.f18003p || this.f18004q;
    }

    /* renamed from: e */
    public boolean m18629e() {
        return this.f18005r;
    }

    /* renamed from: f */
    public boolean m18630f() {
        return this.f18006s;
    }

    /* renamed from: g */
    public boolean m18631g() {
        return this.f18007t;
    }

    /* renamed from: h */
    public int m18632h() {
        return this.f17990c;
    }

    /* renamed from: i */
    public int m18633i() {
        return this.f17991d;
    }

    /* renamed from: j */
    public String m18634j() {
        return this.f17995h;
    }

    /* renamed from: k */
    public String m18635k() {
        return this.f17997j;
    }

    /* renamed from: l */
    public String m18636l() {
        return this.f17998k;
    }

    /* renamed from: m */
    public int m18637m() {
        return this.f17992e;
    }

    /* renamed from: n */
    public String m18638n() {
        return this.f17993f;
    }

    /* renamed from: o */
    public String m18639o() {
        return this.f18000m;
    }

    /* renamed from: p */
    public int m18640p() {
        return this.f17994g;
    }

    /* renamed from: q */
    public String m18641q() {
        return this.f17996i;
    }

    /* renamed from: r */
    public String m18642r() {
        return this.f17996i;
    }

    /* renamed from: s */
    public String m18643s() {
        return this.f17999l;
    }

    /* renamed from: t */
    public int m18644t() {
        return this.f18001n;
    }

    /* renamed from: u */
    public int m18645u() {
        return this.f18002o;
    }

    public String toString() {
        return m18621x();
    }

    public int hashCode() {
        return this.f17989b.hashCode();
    }

    /* renamed from: a */
    private XmlResourceParser m18617a(File file) {
        Object m18622y = m18622y();
        return ((AssetManager) m18622y).openXmlResourceParser(m18616a(file, m18622y), AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
    }

    /* renamed from: a */
    private int m18616a(File file, Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Class<?>[] clsArr = new Class[1];
            try {
                clsArr[0] = Class.forName("java.lang.String");
                return ((Integer) cls.getMethod("addAssetPath", clsArr).invoke(obj, file.getAbsolutePath())).intValue();
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            return -1;
        }
    }

    /* renamed from: y */
    private Object m18622y() {
        try {
            return Class.forName("android.content.res.AssetManager").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            return (Object) null;
        }
    }

    /* renamed from: b */
    private String m18619b(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        while (i > 0) {
            sb.append("\t");
            i--;
        }
        return sb.toString();
    }

    /* renamed from: v */
    public List<String> m18646v() {
        String substring;
        int indexOf;
        ArrayList arrayList = new ArrayList();
        try {
            C2604w c2604w = new C2604w(this.f17989b);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                C2602u nextElement = m16163b.nextElement();
                String name = nextElement.getName();
                if (!nextElement.isDirectory() && name.startsWith("lib/") && (indexOf = (substring = name.substring(4)).indexOf(47)) != -1) {
                    String substring2 = substring.substring(0, indexOf);
                    if (!arrayList.contains(substring2)) {
                        arrayList.add(substring2);
                    }
                }
            }
            c2604w.close();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
