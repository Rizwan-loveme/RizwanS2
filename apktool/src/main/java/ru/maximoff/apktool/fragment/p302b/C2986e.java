package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.content.p006pm.PackageInfo;
import android.view.View;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import ru.maximoff.apktool.ApktoolApplication;
import ru.maximoff.apktool.fragment.MenuItemOnActionExpandListenerC2976a;

/* compiled from: ErrorTree.java */
/* renamed from: ru.maximoff.apktool.fragment.b.e */
/* loaded from: classes.dex */
public class C2986e implements Comparable<C2986e> {

    /* renamed from: a */
    protected MenuItemOnActionExpandListenerC2976a f16432a;

    /* renamed from: b */
    protected final List<C2986e> f16433b;

    /* renamed from: c */
    private CharSequence f16434c;

    /* renamed from: d */
    private CharSequence f16435d;

    /* renamed from: e */
    private PackageInfo f16436e;

    /* renamed from: a */
    public void mo17838a(View view) {
    }

    /* renamed from: a */
    public void mo17836a(ImageView imageView) {
    }

    @Override // java.lang.Comparable
    public int compareTo(C2986e c2986e) {
        return m17884b(c2986e);
    }

    public C2986e(CharSequence charSequence, CharSequence charSequence2) {
        this(charSequence, charSequence2, (PackageInfo) null);
    }

    public C2986e(CharSequence charSequence, CharSequence charSequence2, PackageInfo packageInfo) {
        this.f16434c = charSequence;
        this.f16435d = charSequence2;
        this.f16432a = (MenuItemOnActionExpandListenerC2976a) null;
        this.f16436e = packageInfo;
        this.f16433b = new LinkedList();
    }

    /* renamed from: a */
    public void m17882a(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a) {
        this.f16432a = menuItemOnActionExpandListenerC2976a;
        if (this.f16433b == null || this.f16433b.isEmpty()) {
            return;
        }
        for (C2986e c2986e : this.f16433b) {
            if (c2986e != null) {
                c2986e.m17882a(menuItemOnActionExpandListenerC2976a);
            }
        }
    }

    /* renamed from: c */
    public Context m17885c() {
        return ApktoolApplication.m16371b();
    }

    /* renamed from: a */
    public void m17881a(CharSequence charSequence) {
        this.f16434c = charSequence;
    }

    /* renamed from: d */
    public CharSequence mo17886d() {
        return this.f16434c;
    }

    /* renamed from: e */
    public CharSequence mo17887e() {
        return this.f16435d;
    }

    /* renamed from: f */
    public List<C2986e> m17888f() {
        return this.f16433b;
    }

    /* renamed from: a */
    public C2986e m17880a(int i) {
        if (this.f16433b == null || this.f16433b.size() <= i) {
            return (C2986e) null;
        }
        try {
            return this.f16433b.get(i);
        } catch (Exception e2) {
            return (C2986e) null;
        }
    }

    /* renamed from: g */
    public int m17889g() {
        if (this.f16433b == null) {
            return 0;
        }
        return this.f16433b.size();
    }

    /* renamed from: a */
    public void mo17883a(C2986e c2986e) {
        this.f16433b.add(c2986e);
        c2986e.m17882a(this.f16432a);
    }

    /* renamed from: b */
    public void mo17859b() {
        this.f16433b.clear();
    }

    /* renamed from: b */
    public int m17884b(C2986e c2986e) {
        return this.f16434c.toString().toLowerCase().compareTo(c2986e.f16434c.toString().toLowerCase());
    }

    /* renamed from: h */
    public PackageInfo m17890h() {
        return this.f16436e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16434c, this.f16435d});
    }
}
