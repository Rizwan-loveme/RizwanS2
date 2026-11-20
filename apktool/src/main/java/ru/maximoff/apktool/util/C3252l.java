package ru.maximoff.apktool.util;

import android.content.Context;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.p270e.C2466a;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: DataApp.java */
/* renamed from: ru.maximoff.apktool.util.l */
/* loaded from: classes.dex */
public class C3252l {

    /* renamed from: b */
    private Context f19652b;

    /* renamed from: d */
    private File f19654d;

    /* renamed from: a */
    private final String f19651a = "data_apps";

    /* renamed from: c */
    private List<String> f19653c = new ArrayList();

    public C3252l(Context context) {
        this.f19652b = context;
        m19509c();
    }

    /* renamed from: a */
    public void m19506a() {
        this.f19653c.clear();
        m19509c();
    }

    /* renamed from: b */
    public File m19508b() {
        return this.f19654d;
    }

    /* renamed from: c */
    public void m19509c() {
        this.f19654d = new File(C3102bd.m18908a(), "data_apps");
    }

    /* renamed from: a */
    public void m19507a(String str, String str2) {
        if (str.startsWith(C3249i.f19549i)) {
            try {
                String stringBuffer = new StringBuffer().append(new StringBuffer().append(str.substring(C3249i.f19549i.length())).append(":").toString()).append(str2).toString();
                if (this.f19653c.contains(stringBuffer)) {
                    return;
                }
                this.f19653c.add(stringBuffer);
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public String m19505a(String str) {
        for (String str2 : this.f19653c) {
            if (str2.startsWith(str)) {
                return str2.substring(str2.lastIndexOf(58) + 1);
            }
        }
        return (String) null;
    }

    /* renamed from: d */
    public void m19510d() {
        C3061a.m18319b(this.f19654d, C3257q.m19518a(new C2466a((Collection<?>) this.f19653c).toString(), "data_apps"));
    }

    /* renamed from: e */
    public List<String> m19511e() {
        if (!this.f19654d.isFile()) {
            return new ArrayList();
        }
        m19506a();
        C2466a c2466a = new C2466a(C3257q.m19520b(C3061a.m18332i(this.f19654d), "data_apps"));
        for (int i = 0; i < c2466a.m15569a(); i++) {
            this.f19653c.add(c2466a.m15579f(i));
        }
        return this.f19653c;
    }
}
