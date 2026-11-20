package ru.maximoff.apktool.view;

import android.view.View;
import android.widget.ImageView;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TreeNode.java */
/* renamed from: ru.maximoff.apktool.view.r */
/* loaded from: classes.dex */
public class C3316r<T> {

    /* renamed from: a */
    private T f21280a;

    /* renamed from: b */
    private final int f21281b;

    /* renamed from: c */
    private final List<C3316r<T>> f21282c;

    /* renamed from: d */
    private int f21283d;

    /* renamed from: e */
    private boolean f21284e;

    /* renamed from: f */
    private C3315q f21285f;

    public C3316r(int i, C3315q c3315q) {
        this((Object) null, i, c3315q);
    }

    public C3316r(T t, int i, C3315q c3315q) {
        this.f21283d = 0;
        this.f21280a = t;
        this.f21285f = c3315q;
        this.f21281b = i;
        this.f21284e = false;
        this.f21282c = new LinkedList();
    }

    /* renamed from: a */
    public T m20045a() {
        return this.f21280a;
    }

    /* renamed from: b */
    public int m20050b() {
        return this.f21281b;
    }

    /* renamed from: a */
    public void m20049a(InterfaceC3314p<T> interfaceC3314p, View view) {
        if (this.f21283d == 0 || !interfaceC3314p.mo17858a()) {
            interfaceC3314p.mo17895a((InterfaceC3314p<T>) this.f21280a, view);
        } else {
            this.f21284e = !this.f21284e;
            this.f21285f.m20042a();
        }
    }

    /* renamed from: a */
    public void m20046a(ImageView imageView, InterfaceC3314p<T> interfaceC3314p, int i) {
        if (interfaceC3314p.mo17858a()) {
        }
    }

    /* renamed from: a */
    public void m20048a(List<C3316r<T>> list, InterfaceC3314p<T> interfaceC3314p) {
        if (!this.f21284e && interfaceC3314p.mo17858a() && this.f21281b >= 0) {
            return;
        }
        List<C3316r<T>> list2 = this.f21282c;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f21283d) {
                return;
            }
            C3316r<T> c3316r = list2.get(i2);
            list.add(c3316r);
            c3316r.m20048a((List) list, (InterfaceC3314p) interfaceC3314p);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void m20047a(T t, InterfaceC3314p<T> interfaceC3314p) {
        this.f21280a = t;
        int mo17891a = interfaceC3314p.mo17891a((InterfaceC3314p<T>) t);
        for (int i = 0; i < mo17891a; i++) {
            m20044a(i).m20047a((C3316r<T>) interfaceC3314p.mo17892a((InterfaceC3314p<T>) t, i), (InterfaceC3314p<C3316r<T>>) interfaceC3314p);
        }
        this.f21283d = mo17891a;
    }

    /* renamed from: a */
    private C3316r<T> m20044a(int i) {
        if (i >= this.f21282c.size()) {
            C3316r<T> c3316r = new C3316r<>(this.f21281b + 1, this.f21285f);
            this.f21282c.add(c3316r);
            return c3316r;
        }
        return this.f21282c.get(i);
    }
}
