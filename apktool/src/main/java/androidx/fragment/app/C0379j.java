package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p030e.C0270e;
import androidx.lifecycle.ViewModelStoreOwner;

/* compiled from: FragmentController.java */
/* renamed from: androidx.fragment.app.j */
/* loaded from: classes.dex */
public class C0379j {

    /* renamed from: a */
    private final AbstractC0381l<?> f2723a;

    /* renamed from: a */
    public static C0379j m2914a(AbstractC0381l<?> abstractC0381l) {
        return new C0379j((AbstractC0381l) C0270e.m1961a(abstractC0381l, "callbacks == null"));
    }

    private C0379j(AbstractC0381l<?> abstractC0381l) {
        this.f2723a = abstractC0381l;
    }

    /* renamed from: a */
    public AbstractC0384o m2916a() {
        return this.f2723a.f2726b;
    }

    /* renamed from: a */
    public void m2919a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        this.f2723a.f2726b.m3015a(this.f2723a, this.f2723a, componentCallbacksC0374e);
    }

    /* renamed from: a */
    public View m2915a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2723a.f2726b.m3001G().onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: b */
    public void m2924b() {
        this.f2723a.f2726b.m3064o();
    }

    /* renamed from: c */
    public Parcelable m2928c() {
        return this.f2723a.f2726b.m3054j();
    }

    /* renamed from: a */
    public void m2918a(Parcelable parcelable) {
        if (!(this.f2723a instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        this.f2723a.f2726b.m3006a(parcelable);
    }

    /* renamed from: d */
    public void m2929d() {
        this.f2723a.f2726b.m3067q();
    }

    /* renamed from: e */
    public void m2930e() {
        this.f2723a.f2726b.m3069s();
    }

    /* renamed from: f */
    public void m2931f() {
        this.f2723a.f2726b.m3070t();
    }

    /* renamed from: g */
    public void m2932g() {
        this.f2723a.f2726b.m3071u();
    }

    /* renamed from: h */
    public void m2933h() {
        this.f2723a.f2726b.m3072v();
    }

    /* renamed from: i */
    public void m2934i() {
        this.f2723a.f2726b.m3073w();
    }

    /* renamed from: j */
    public void m2935j() {
        this.f2723a.f2726b.m3075y();
    }

    /* renamed from: a */
    public void m2920a(boolean z) {
        this.f2723a.f2726b.m3032b(z);
    }

    /* renamed from: b */
    public void m2926b(boolean z) {
        this.f2723a.f2726b.m3039c(z);
    }

    /* renamed from: a */
    public void m2917a(Configuration configuration) {
        this.f2723a.f2726b.m3005a(configuration);
    }

    /* renamed from: k */
    public void m2936k() {
        this.f2723a.f2726b.m3076z();
    }

    /* renamed from: a */
    public boolean m2922a(Menu menu, MenuInflater menuInflater) {
        return this.f2723a.f2726b.m3022a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean m2921a(Menu menu) {
        return this.f2723a.f2726b.m3021a(menu);
    }

    /* renamed from: a */
    public boolean m2923a(MenuItem menuItem) {
        return this.f2723a.f2726b.m3023a(menuItem);
    }

    /* renamed from: b */
    public boolean m2927b(MenuItem menuItem) {
        return this.f2723a.f2726b.m3034b(menuItem);
    }

    /* renamed from: b */
    public void m2925b(Menu menu) {
        this.f2723a.f2726b.m3029b(menu);
    }

    /* renamed from: l */
    public boolean m2937l() {
        return this.f2723a.f2726b.m3026a(true);
    }
}
