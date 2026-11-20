package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.p044h.p045a.AbstractC0405a;
import java.io.File;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: FilesPagerAdapter.java */
/* renamed from: ru.maximoff.apktool.fragment.b.l */
/* loaded from: classes.dex */
public class C2993l extends AbstractC0405a {

    /* renamed from: a */
    private Context f16815a;

    /* renamed from: b */
    private ViewOnClickListenerC2992k f16816b;

    /* renamed from: c */
    private ViewOnClickListenerC2992k f16817c;

    /* renamed from: d */
    private RunnableC2983b f16818d;

    /* renamed from: e */
    private C2988g f16819e;

    /* renamed from: f */
    private int f16820f;

    public C2993l(Context context) {
        this.f16815a = context;
        this.f16816b = new ViewOnClickListenerC2992k(this.f16815a, this, 0);
        this.f16817c = new ViewOnClickListenerC2992k(this.f16815a, this, 1);
        this.f16818d = new RunnableC2983b(this.f16815a);
        if (C3102bd.f18272H) {
            this.f16819e = new C2988g(this.f16815a);
            this.f16820f = 4;
        } else {
            this.f16819e = (C2988g) null;
            this.f16820f = 3;
        }
    }

    /* renamed from: c */
    public String m18063c(int i) {
        return m18064d(i).m18039j();
    }

    /* renamed from: a */
    public String m18057a(int i, String str) {
        return m18064d(i).m18031d(str);
    }

    /* renamed from: a */
    public void m18062a(String str, String str2, int i) {
        m18064d(i).m18020a(str, str2);
    }

    /* renamed from: a */
    public void m18059a(Bundle bundle) {
        this.f16816b.m18016a(bundle);
        this.f16817c.m18016a(bundle);
    }

    /* renamed from: d */
    public void m18065d() {
        this.f16816b.m18013a();
        this.f16817c.m18013a();
    }

    /* renamed from: a */
    public void m18060a(Bundle bundle, C2981b c2981b) {
        this.f16816b.m18017a(bundle, c2981b);
        this.f16817c.m18017a(bundle, c2981b);
        this.f16818d.m17852a(c2981b);
        if (C3102bd.f18272H) {
            this.f16819e.m17902a(c2981b);
        }
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public int mo3270a() {
        return this.f16820f;
    }

    /* renamed from: d */
    public ViewOnClickListenerC2992k m18064d(int i) {
        switch (i) {
        }
        return this.f16816b;
    }

    /* renamed from: a */
    public void m18061a(String str, int i) {
        File file = new File(str);
        if (i == 1) {
            int m18025b = this.f16817c.m18025b();
            this.f16816b.m18037h().mo17934a(file);
            this.f16816b.m18014a(m18025b);
        } else {
            int m18025b2 = this.f16816b.m18025b();
            this.f16817c.m18037h().mo17934a(file);
            this.f16817c.m18014a(m18025b2);
        }
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public boolean mo3281a(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public Object mo3274a(ViewGroup viewGroup, int i) {
        View view = (View) null;
        switch (i) {
            case 0:
                view = this.f16816b.m18036g();
                break;
            case 1:
                view = this.f16817c.m18036g();
                break;
            case 2:
                view = this.f16818d.m17851a();
                break;
            case 3:
                if (C3102bd.f18272H) {
                    view = this.f16819e.m17903b();
                    break;
                }
                break;
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public void mo3280a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public CharSequence mo3272a(int i) {
        switch (i) {
            case 0:
                return this.f16816b.m18033e();
            case 1:
                return this.f16817c.m18033e();
            case 2:
                return this.f16818d.m17853b();
            case 3:
                if (this.f16819e == null) {
                    return (CharSequence) null;
                }
                return this.f16819e.m17901a();
            default:
                return super.mo3272a(i);
        }
    }

    /* renamed from: e */
    public void m18066e() {
        m18068f();
        if (this.f16818d != null) {
            this.f16818d.m17854c();
            this.f16818d.m17855d();
        }
        if (this.f16819e != null) {
            this.f16819e.m17904c();
        }
    }

    /* renamed from: f */
    public void m18068f() {
        if (this.f16816b != null) {
            this.f16816b.m18035f();
            C2991j m18037h = this.f16816b.m18037h();
            if (m18037h != null) {
                m18037h.mo17929a();
            }
        }
        if (this.f16817c != null) {
            this.f16817c.m18035f();
            C2991j m18037h2 = this.f16817c.m18037h();
            if (m18037h2 != null) {
                m18037h2.mo17929a();
            }
        }
    }

    /* renamed from: e */
    public void m18067e(int i) {
        switch (i) {
            case 0:
                if (this.f16816b != null) {
                    this.f16816b.m18038i();
                    break;
                }
                break;
            case 1:
                if (this.f16817c != null) {
                    this.f16817c.m18038i();
                    break;
                }
                break;
            case 2:
                if (this.f16818d != null) {
                    this.f16818d.m17857f();
                    break;
                }
                break;
            case 3:
                if (this.f16819e != null) {
                    this.f16819e.m17905d();
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m18058a(int i, String[] strArr) {
        switch (i) {
            case 0:
                this.f16816b.m18024a(strArr);
                break;
            case 1:
                this.f16817c.m18024a(strArr);
                break;
        }
    }
}
