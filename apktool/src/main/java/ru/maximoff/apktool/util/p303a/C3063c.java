package ru.maximoff.apktool.util.p303a;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: EnumOrFlagAttr.java */
/* renamed from: ru.maximoff.apktool.util.a.c */
/* loaded from: classes.dex */
public class C3063c {

    /* renamed from: a */
    private String f17223a;

    /* renamed from: b */
    private Map<Integer, String> f17224b = new LinkedHashMap();

    public C3063c(String str) {
        this.f17223a = str;
    }

    /* renamed from: a */
    public String m18346a() {
        return this.f17223a;
    }

    /* renamed from: a */
    public void m18348a(String str, String str2) {
        int i = 16;
        int i2 = 1;
        try {
            if (str.startsWith("0x")) {
                str = str.substring(2);
            } else if (!str.startsWith("-0x")) {
                i = 10;
            } else {
                str = str.substring(3);
                i2 = -1;
            }
            this.f17224b.put(new Integer(i2 * Integer.parseInt(str, i)), str2);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public String m18347a(String str) {
        int i = 16;
        int i2 = 1;
        try {
            if (str.startsWith("0x")) {
                str = str.substring(2);
            } else if (!str.startsWith("-0x")) {
                i = 10;
            } else {
                str = str.substring(3);
                i2 = -1;
            }
            return this.f17224b.get(new Integer(i2 * Integer.parseInt(str, i)));
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: b */
    public boolean m18349b() {
        return this.f17224b.isEmpty();
    }

    public int hashCode() {
        return (this.f17223a.hashCode() * 31) + this.f17224b.hashCode();
    }
}
