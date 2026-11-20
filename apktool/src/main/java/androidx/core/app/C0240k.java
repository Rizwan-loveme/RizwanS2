package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Person.java */
/* renamed from: androidx.core.app.k */
/* loaded from: classes.dex */
public class C0240k {

    /* renamed from: a */
    CharSequence f1942a;

    /* renamed from: b */
    IconCompat f1943b;

    /* renamed from: c */
    String f1944c;

    /* renamed from: d */
    String f1945d;

    /* renamed from: e */
    boolean f1946e;

    /* renamed from: f */
    boolean f1947f;

    /* renamed from: a */
    public Person m1763a() {
        return new Person.Builder().setName(m1764b()).setIcon(m1765c() != null ? m1765c().m2353e() : null).setUri(m1766d()).setKey(m1767e()).setBot(m1768f()).setImportant(m1769g()).build();
    }

    /* renamed from: b */
    public CharSequence m1764b() {
        return this.f1942a;
    }

    /* renamed from: c */
    public IconCompat m1765c() {
        return this.f1943b;
    }

    /* renamed from: d */
    public String m1766d() {
        return this.f1944c;
    }

    /* renamed from: e */
    public String m1767e() {
        return this.f1945d;
    }

    /* renamed from: f */
    public boolean m1768f() {
        return this.f1946e;
    }

    /* renamed from: g */
    public boolean m1769g() {
        return this.f1947f;
    }

    /* renamed from: h */
    public String m1770h() {
        if (this.f1944c != null) {
            return this.f1944c;
        }
        if (this.f1942a != null) {
            return "name:" + ((Object) this.f1942a);
        }
        return "";
    }
}
