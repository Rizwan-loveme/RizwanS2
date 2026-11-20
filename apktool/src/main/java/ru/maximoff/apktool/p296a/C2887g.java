package ru.maximoff.apktool.p296a;

import android.icu.text.DateFormat;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1396r;
import java.util.ArrayList;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: LexerUtil.java */
/* renamed from: ru.maximoff.apktool.a.g */
/* loaded from: classes.dex */
public class C2887g {
    /* renamed from: a */
    public static boolean m16904a(String str) {
        return str.equals("json") || str.equals("smali") || str.equals(DateFormat.MINUTE) || str.equals("mm") || str.equals("js");
    }

    /* renamed from: a */
    public static String[] m16905a(InterfaceC1823ag interfaceC1823ag) {
        int mo13690a = interfaceC1823ag.mo13690a();
        ArrayList arrayList = new ArrayList(mo13690a);
        for (int i = 0; i < mo13690a; i++) {
            String mo13691a = interfaceC1823ag.mo13691a(i);
            if (mo13691a != null && mo13691a.matches("'[a-z_]+'")) {
                arrayList.add(mo13691a.substring(1, mo13691a.length() - 1));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static AbstractRunnableC1391m m16903a(String str, C3055a c3055a) {
        if (str == null) {
            return C1396r.f9139c;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".java")) {
            return new C2884d();
        }
        if (lowerCase.endsWith(".smali")) {
            return new C2892l(c3055a);
        }
        if (lowerCase.endsWith(".c") || lowerCase.endsWith(".h") || lowerCase.endsWith(".cc") || lowerCase.endsWith(".cpp") || lowerCase.endsWith(".cxx")) {
            return new C2882b();
        }
        if (lowerCase.endsWith(".xml") || lowerCase.endsWith(".html") || lowerCase.endsWith(".xhtml") || lowerCase.endsWith(".htm") || lowerCase.endsWith(".svg")) {
            return new C2893m(c3055a);
        }
        if (lowerCase.endsWith(".json") || lowerCase.endsWith(".mtd") || lowerCase.endsWith(".amd")) {
            return new C2886f();
        }
        if (lowerCase.endsWith(".m") || lowerCase.endsWith(".mm")) {
            return new C2889i();
        }
        if (lowerCase.endsWith(".css")) {
            return new C2883c();
        }
        if (lowerCase.endsWith(".js")) {
            return new C2885e();
        }
        return C1396r.f9139c;
    }

    /* renamed from: a */
    public static AbstractRunnableC1391m m16902a(int i, C3055a c3055a) {
        switch (i) {
            case 1:
                return new C2882b();
            case 2:
                return new C2883c();
            case 3:
                return new C2884d();
            case 4:
                return new C2885e();
            case 5:
                return new C2886f();
            case 6:
                return new C2889i();
            case 7:
                return new C2892l(c3055a);
            case 8:
                return new C2893m(c3055a);
            default:
                return C1396r.f9139c;
        }
    }

    /* renamed from: a */
    public static int m16900a(AbstractRunnableC1391m abstractRunnableC1391m) {
        if (abstractRunnableC1391m instanceof C2882b) {
            return 1;
        }
        if (abstractRunnableC1391m instanceof C2883c) {
            return 2;
        }
        if (abstractRunnableC1391m instanceof C2884d) {
            return 3;
        }
        if (abstractRunnableC1391m instanceof C2885e) {
            return 4;
        }
        if (abstractRunnableC1391m instanceof C2886f) {
            return 5;
        }
        if (abstractRunnableC1391m instanceof C2889i) {
            return 6;
        }
        if (abstractRunnableC1391m instanceof C2892l) {
            return 7;
        }
        if (abstractRunnableC1391m instanceof C2893m) {
            return 8;
        }
        return 0;
    }

    /* renamed from: a */
    public static AbstractRunnableC1391m m16901a() {
        return C1396r.f9139c;
    }
}
