package ru.maximoff.apktool.fragment.p302b;

import android.p008os.Handler;
import android.p008os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.view.InterfaceC3314p;

/* compiled from: ErrorsAdapter.java */
/* renamed from: ru.maximoff.apktool.fragment.b.f */
/* loaded from: classes.dex */
public class RunnableC2987f extends C2986e implements Runnable, InterfaceC3314p<C2986e> {

    /* renamed from: c */
    private Handler f16437c;

    /* renamed from: d */
    private BaseAdapter f16438d;

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: a */
    public int mo17891a(C2986e c2986e) {
        return m17896c(c2986e);
    }

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: a */
    public /* bridge */ C2986e mo17892a(C2986e c2986e, int i) {
        return a2(c2986e, i);
    }

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: a */
    public /* bridge */ void mo17894a(TextView textView, TextView textView2, ImageView imageView, C2986e c2986e) {
        a2(textView, textView2, imageView, c2986e);
    }

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: a */
    public /* bridge */ void mo17895a(C2986e c2986e, View view) {
        a2(c2986e, view);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: d */
    public CharSequence mo17886d() {
        return m17897i();
    }

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: l */
    public C2986e mo17900l() {
        return m17899k();
    }

    /* renamed from: a */
    public boolean mo17858a() {
        return true;
    }

    public RunnableC2987f() {
        super("", "");
    }

    /* renamed from: i */
    public String m17897i() {
        return "";
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: b */
    public void mo17859b() {
        if (this.f16437c == null) {
            this.f16437c = new Handler(Looper.getMainLooper());
        }
        this.f16437c.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16433b.clear();
        C3102bd.f18338u.m18216a(this);
        this.f16432a.m17663l(m17889g() > 0);
        this.f16438d.notifyDataSetChanged();
    }

    /* renamed from: j */
    public void m17898j() {
        if (this.f16438d != null) {
            this.f16438d.notifyDataSetChanged();
        }
    }

    @Override // ru.maximoff.apktool.view.InterfaceC3314p
    /* renamed from: a */
    public void mo17893a(BaseAdapter baseAdapter) {
        this.f16438d = baseAdapter;
    }

    /* renamed from: k */
    public C2986e m17899k() {
        return this;
    }

    /* renamed from: c */
    public int m17896c(C2986e c2986e) {
        return c2986e.m17889g();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public C2986e a2(C2986e c2986e, int i) {
        return c2986e.m17880a(i);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(TextView textView, TextView textView2, ImageView imageView, C2986e c2986e) {
        textView.setText(c2986e.mo17886d());
        textView2.setText(c2986e.mo17887e());
        c2986e.mo17836a(imageView);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(C2986e c2986e, View view) {
        c2986e.mo17838a(view);
    }
}
