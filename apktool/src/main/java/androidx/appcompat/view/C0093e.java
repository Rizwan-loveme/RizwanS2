package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* renamed from: androidx.appcompat.view.e */
/* loaded from: classes.dex */
public class C0093e extends AbstractC0090b implements C0106g.a {

    /* renamed from: a */
    private Context f813a;

    /* renamed from: b */
    private ActionBarContextView f814b;

    /* renamed from: c */
    private AbstractC0090b.a f815c;

    /* renamed from: d */
    private WeakReference<View> f816d;

    /* renamed from: e */
    private boolean f817e;

    /* renamed from: f */
    private boolean f818f;

    /* renamed from: g */
    private C0106g f819g;

    public C0093e(Context context, ActionBarContextView actionBarContextView, AbstractC0090b.a aVar, boolean z) {
        this.f813a = context;
        this.f814b = actionBarContextView;
        this.f815c = aVar;
        this.f819g = new C0106g(actionBarContextView.getContext()).m869a(1);
        this.f819g.mo877a(this);
        this.f818f = z;
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: b */
    public void mo659b(CharSequence charSequence) {
        this.f814b.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: a */
    public void mo655a(CharSequence charSequence) {
        this.f814b.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: a */
    public void mo653a(int i) {
        mo659b(this.f813a.getString(i));
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: b */
    public void mo658b(int i) {
        mo655a((CharSequence) this.f813a.getString(i));
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: a */
    public void mo656a(boolean z) {
        super.mo656a(z);
        this.f814b.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: h */
    public boolean mo665h() {
        return this.f814b.m984d();
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: a */
    public void mo654a(View view) {
        this.f814b.setCustomView(view);
        this.f816d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: d */
    public void mo661d() {
        this.f815c.mo563b(this, this.f819g);
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: c */
    public void mo660c() {
        if (!this.f817e) {
            this.f817e = true;
            this.f814b.sendAccessibilityEvent(32);
            this.f815c.mo560a(this);
        }
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: b */
    public Menu mo657b() {
        return this.f819g;
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: f */
    public CharSequence mo663f() {
        return this.f814b.getTitle();
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: g */
    public CharSequence mo664g() {
        return this.f814b.getSubtitle();
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: i */
    public View mo666i() {
        if (this.f816d != null) {
            return this.f816d.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.AbstractC0090b
    /* renamed from: a */
    public MenuInflater mo652a() {
        return new C0095g(this.f814b.getContext());
    }

    @Override // androidx.appcompat.view.menu.C0106g.a
    /* renamed from: a */
    public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
        return this.f815c.mo562a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.C0106g.a
    /* renamed from: a */
    public void mo529a(C0106g c0106g) {
        mo661d();
        this.f814b.mo981a();
    }
}
