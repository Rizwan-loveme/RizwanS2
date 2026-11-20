package com.p159h.p160a.p162b;

import java.util.ArrayList;

/* compiled from: Language.java */
/* renamed from: com.h.a.b.k */
/* loaded from: classes.dex */
public abstract class AbstractC1389k {

    /* renamed from: a */
    public static final String f9028a = "↵";

    /* renamed from: b */
    public static final String f9029b = "·";

    /* renamed from: c */
    private static final char[] f9030c = {'(', ')', '{', '}', '.', ',', ';', '=', '+', '-', '/', '*', '&', '!', '|', ':', '[', ']', '<', '>', '?', '~', '%', '^'};

    /* renamed from: d */
    private String[] f9031d;

    /* renamed from: a */
    public CharSequence mo11078a(ArrayList<String> arrayList, CharSequence charSequence) {
        String lowerCase = charSequence.toString().toLowerCase();
        for (String str : this.f9031d) {
            if (str.toLowerCase().startsWith(lowerCase)) {
                arrayList.add(str);
            }
        }
        return charSequence;
    }

    /* renamed from: a */
    public void m11079a(String[] strArr) {
        this.f9031d = strArr;
    }

    /* renamed from: a */
    public boolean m11081a(char c2) {
        return c2 == ' ' || c2 == '\n' || c2 == '\t' || c2 == '\r' || c2 == '\f' || c2 == 65535;
    }

    /* renamed from: b */
    public boolean m11082b(char c2) {
        return c2 == '.';
    }

    /* renamed from: a */
    public boolean mo11080a() {
        return true;
    }
}
