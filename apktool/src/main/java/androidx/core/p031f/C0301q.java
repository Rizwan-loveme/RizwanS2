package androidx.core.p031f;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: androidx.core.f.q */
/* loaded from: classes.dex */
public class C0301q {

    /* renamed from: a */
    private int f2204a;

    /* renamed from: b */
    private int f2205b;

    public C0301q(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public void m2206a(View view, View view2, int i) {
        m2207a(view, view2, i, 0);
    }

    /* renamed from: a */
    public void m2207a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f2205b = i;
        } else {
            this.f2204a = i;
        }
    }

    /* renamed from: a */
    public int m2203a() {
        return this.f2204a | this.f2205b;
    }

    /* renamed from: a */
    public void m2204a(View view) {
        m2205a(view, 0);
    }

    /* renamed from: a */
    public void m2205a(View view, int i) {
        if (i == 1) {
            this.f2205b = 0;
        } else {
            this.f2204a = 0;
        }
    }
}
