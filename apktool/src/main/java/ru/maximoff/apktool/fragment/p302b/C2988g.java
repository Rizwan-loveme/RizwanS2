package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.view.TreeView;

/* compiled from: ErrorsPager.java */
/* renamed from: ru.maximoff.apktool.fragment.b.g */
/* loaded from: classes.dex */
public class C2988g {

    /* renamed from: a */
    private final View f16439a;

    /* renamed from: b */
    private final Context f16440b;

    /* renamed from: c */
    private final CharSequence f16441c;

    /* renamed from: d */
    private TreeView<C2986e> f16442d;

    /* renamed from: e */
    private RunnableC2987f f16443e;

    /* renamed from: f */
    private SwipeRefreshLayout f16444f;

    /* renamed from: g */
    private C2981b f16445g;

    public C2988g(Context context) {
        this.f16440b = context;
        this.f16439a = LayoutInflater.from(context).inflate(R.layout.errors, (ViewGroup) null);
        this.f16441c = context.getText(R.string.errors);
        this.f16442d = (TreeView) this.f16439a.findViewById(R.id.errors);
        this.f16444f = (SwipeRefreshLayout) this.f16439a.findViewById(R.id.swipe_container);
        ((LinearLayout) this.f16439a.findViewById(R.id.errorsLinearLayout1)).setVisibility(8);
        this.f16444f.setEnabled(false);
    }

    /* renamed from: a */
    public void m17902a(C2981b c2981b) {
        this.f16445g = c2981b;
        this.f16443e = new RunnableC2987f();
        this.f16443e.mo17859b();
        this.f16442d.setAdapter(this.f16443e);
        c2981b.m17825a(this.f16443e);
    }

    /* renamed from: a */
    public CharSequence m17901a() {
        return this.f16441c;
    }

    /* renamed from: b */
    public View m17903b() {
        return this.f16439a;
    }

    /* renamed from: c */
    protected void m17904c() {
        if (this.f16445g != null) {
            m17902a(this.f16445g);
        }
    }

    /* renamed from: d */
    public void m17905d() {
        if (this.f16443e == null) {
            return;
        }
        this.f16443e.m17898j();
    }
}
