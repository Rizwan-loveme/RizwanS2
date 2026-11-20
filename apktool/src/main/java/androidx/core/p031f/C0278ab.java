package androidx.core.p031f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: androidx.core.f.ab */
/* loaded from: classes.dex */
public final class C0278ab {

    /* renamed from: a */
    Runnable f2125a = null;

    /* renamed from: b */
    Runnable f2126b = null;

    /* renamed from: c */
    int f2127c = -1;

    /* renamed from: d */
    private WeakReference<View> f2128d;

    C0278ab(View view) {
        this.f2128d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: androidx.core.f.ab$a */
    static class a implements InterfaceC0279ac {

        /* renamed from: a */
        C0278ab f2135a;

        /* renamed from: b */
        boolean f2136b;

        a(C0278ab c0278ab) {
            this.f2135a = c0278ab;
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        /* renamed from: a */
        public void mo556a(View view) {
            this.f2136b = false;
            if (this.f2135a.f2127c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f2135a.f2125a != null) {
                Runnable runnable = this.f2135a.f2125a;
                this.f2135a.f2125a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            InterfaceC0279ac interfaceC0279ac = tag instanceof InterfaceC0279ac ? (InterfaceC0279ac) tag : null;
            if (interfaceC0279ac != null) {
                interfaceC0279ac.mo556a(view);
            }
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        @SuppressLint({"WrongConstant"})
        /* renamed from: b */
        public void mo557b(View view) {
            if (this.f2135a.f2127c > -1) {
                view.setLayerType(this.f2135a.f2127c, null);
                this.f2135a.f2127c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f2136b) {
                if (this.f2135a.f2126b != null) {
                    Runnable runnable = this.f2135a.f2126b;
                    this.f2135a.f2126b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                InterfaceC0279ac interfaceC0279ac = tag instanceof InterfaceC0279ac ? (InterfaceC0279ac) tag : null;
                if (interfaceC0279ac != null) {
                    interfaceC0279ac.mo557b(view);
                }
                this.f2136b = true;
            }
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        /* renamed from: c */
        public void mo1162c(View view) {
            InterfaceC0279ac interfaceC0279ac;
            Object tag = view.getTag(2113929216);
            if (!(tag instanceof InterfaceC0279ac)) {
                interfaceC0279ac = null;
            } else {
                interfaceC0279ac = (InterfaceC0279ac) tag;
            }
            if (interfaceC0279ac != null) {
                interfaceC0279ac.mo1162c(view);
            }
        }
    }

    /* renamed from: a */
    public C0278ab m2059a(long j) {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: a */
    public C0278ab m2058a(float f2) {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    /* renamed from: b */
    public C0278ab m2063b(float f2) {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    /* renamed from: a */
    public long m2057a() {
        View view = this.f2128d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* renamed from: a */
    public C0278ab m2060a(Interpolator interpolator) {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public C0278ab m2064b(long j) {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: b */
    public void m2065b() {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: c */
    public void m2066c() {
        View view = this.f2128d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public C0278ab m2061a(InterfaceC0279ac interfaceC0279ac) {
        View view = this.f2128d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m2056a(view, interfaceC0279ac);
            } else {
                view.setTag(2113929216, interfaceC0279ac);
                m2056a(view, new a(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m2056a(final View view, final InterfaceC0279ac interfaceC0279ac) {
        if (interfaceC0279ac != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.f.ab.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    interfaceC0279ac.mo1162c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    interfaceC0279ac.mo557b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    interfaceC0279ac.mo556a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public C0278ab m2062a(final InterfaceC0281ae interfaceC0281ae) {
        final View view = this.f2128d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (interfaceC0281ae != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.f.ab.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        interfaceC0281ae.mo651a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
