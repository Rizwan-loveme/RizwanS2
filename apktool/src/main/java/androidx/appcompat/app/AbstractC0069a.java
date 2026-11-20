package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.AbstractC0090b;

/* compiled from: ActionBar.java */
/* renamed from: androidx.appcompat.app.a */
/* loaded from: classes.dex */
public abstract class AbstractC0069a {

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.a$b */
    public interface b {
        /* renamed from: a */
        void m407a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* renamed from: androidx.appcompat.app.a$c */
    public static abstract class c {
        /* renamed from: a */
        public abstract Drawable m408a();

        /* renamed from: b */
        public abstract CharSequence m409b();

        /* renamed from: c */
        public abstract View m410c();

        /* renamed from: d */
        public abstract void m411d();

        /* renamed from: e */
        public abstract CharSequence m412e();
    }

    /* renamed from: a */
    public abstract View mo384a();

    /* renamed from: a */
    public abstract void mo387a(int i);

    /* renamed from: a */
    public abstract void mo389a(View view);

    /* renamed from: a */
    public abstract void mo390a(CharSequence charSequence);

    /* renamed from: b */
    public abstract int mo394b();

    /* renamed from: c */
    public abstract void mo397c();

    /* renamed from: a */
    public void mo391a(boolean z) {
    }

    /* renamed from: d */
    public Context mo399d() {
        return null;
    }

    /* renamed from: b */
    public void mo396b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo386a(float f2) {
        if (f2 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: c */
    public void mo398c(boolean z) {
    }

    /* renamed from: d */
    public void mo400d(boolean z) {
    }

    /* renamed from: a */
    public void mo388a(Configuration configuration) {
    }

    /* renamed from: e */
    public void mo401e(boolean z) {
    }

    /* renamed from: a */
    public AbstractC0090b mo385a(AbstractC0090b.a aVar) {
        return null;
    }

    /* renamed from: e */
    public boolean mo402e() {
        return false;
    }

    /* renamed from: f */
    public boolean mo403f() {
        return false;
    }

    /* renamed from: g */
    public boolean mo404g() {
        return false;
    }

    /* renamed from: a */
    public boolean mo393a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo392a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: h */
    public boolean mo405h() {
        return false;
    }

    /* renamed from: b */
    public void mo395b(CharSequence charSequence) {
    }

    /* renamed from: i */
    void mo406i() {
    }

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.a$a */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f544a;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f544a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ActionBarLayout);
            this.f544a = obtainStyledAttributes.getInt(C0059a.j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f544a = 0;
            this.f544a = 8388627;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f544a = 0;
            this.f544a = aVar.f544a;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f544a = 0;
        }
    }
}
