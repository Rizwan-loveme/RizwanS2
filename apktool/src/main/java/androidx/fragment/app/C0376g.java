package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.p026b.C0245b;
import androidx.core.p031f.ViewOnAttachStateChangeListenerC0305u;
import androidx.fragment.C0362a;
import androidx.fragment.app.C0394y;

/* compiled from: FragmentAnim.java */
/* renamed from: androidx.fragment.app.g */
/* loaded from: classes.dex */
class C0376g {
    /* renamed from: a */
    static a m2910a(Context context, ComponentCallbacksC0374e componentCallbacksC0374e, boolean z, boolean z2) {
        boolean z3;
        int m2831aj = componentCallbacksC0374e.m2831aj();
        int m2909a = m2909a(componentCallbacksC0374e, z, z2);
        componentCallbacksC0374e.m2803a(0, 0, 0, 0);
        if (componentCallbacksC0374e.f2616F != null && componentCallbacksC0374e.f2616F.getTag(C0362a.b.visible_removing_fragment_view_tag) != null) {
            componentCallbacksC0374e.f2616F.setTag(C0362a.b.visible_removing_fragment_view_tag, null);
        }
        if (componentCallbacksC0374e.f2616F != null && componentCallbacksC0374e.f2616F.getLayoutTransition() != null) {
            return null;
        }
        Animation m2800a = componentCallbacksC0374e.m2800a(m2831aj, z, m2909a);
        if (m2800a != null) {
            return new a(m2800a);
        }
        Animator m2842b = componentCallbacksC0374e.m2842b(m2831aj, z, m2909a);
        if (m2842b != null) {
            return new a(m2842b);
        }
        int m2908a = (m2909a != 0 || m2831aj == 0) ? m2909a : m2908a(m2831aj, z);
        if (m2908a == 0) {
            return null;
        }
        boolean equals = "anim".equals(context.getResources().getResourceTypeName(m2908a));
        if (equals) {
            try {
                Animation loadAnimation = AnimationUtils.loadAnimation(context, m2908a);
                if (loadAnimation != null) {
                    return new a(loadAnimation);
                }
                z3 = true;
            } catch (Resources.NotFoundException e2) {
                throw e2;
            } catch (RuntimeException e3) {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        if (z3) {
            return null;
        }
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, m2908a);
            if (loadAnimator != null) {
                return new a(loadAnimator);
            }
            return null;
        } catch (RuntimeException e4) {
            if (equals) {
                throw e4;
            }
            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, m2908a);
            if (loadAnimation2 != null) {
                return new a(loadAnimation2);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static int m2909a(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                return componentCallbacksC0374e.m2828ag();
            }
            return componentCallbacksC0374e.m2829ah();
        }
        if (z) {
            return componentCallbacksC0374e.m2826ae();
        }
        return componentCallbacksC0374e.m2827af();
    }

    /* renamed from: a */
    static void m2911a(final ComponentCallbacksC0374e componentCallbacksC0374e, a aVar, final C0394y.a aVar2) {
        final View view = componentCallbacksC0374e.f2617G;
        final ViewGroup viewGroup = componentCallbacksC0374e.f2616F;
        viewGroup.startViewTransition(view);
        final C0245b c0245b = new C0245b();
        c0245b.m1791a(new C0245b.a() { // from class: androidx.fragment.app.g.1
            @Override // androidx.core.p026b.C0245b.a
            /* renamed from: a */
            public void mo1794a() {
                if (ComponentCallbacksC0374e.this.m2836ao() != null) {
                    View m2836ao = ComponentCallbacksC0374e.this.m2836ao();
                    ComponentCallbacksC0374e.this.m2813a((View) null);
                    m2836ao.clearAnimation();
                }
                ComponentCallbacksC0374e.this.m2806a((Animator) null);
            }
        });
        aVar2.mo3077a(componentCallbacksC0374e, c0245b);
        if (aVar.f2712a != null) {
            b bVar = new b(aVar.f2712a, viewGroup, view);
            componentCallbacksC0374e.m2813a(componentCallbacksC0374e.f2617G);
            bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.g.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ViewGroup.this.post(new Runnable() { // from class: androidx.fragment.app.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (componentCallbacksC0374e.m2836ao() != null) {
                                componentCallbacksC0374e.m2813a((View) null);
                                aVar2.mo3078b(componentCallbacksC0374e, c0245b);
                            }
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            componentCallbacksC0374e.f2617G.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f2713b;
        componentCallbacksC0374e.m2806a(aVar.f2713b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.g.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ViewGroup.this.endViewTransition(view);
                Animator m2837ap = componentCallbacksC0374e.m2837ap();
                componentCallbacksC0374e.m2806a((Animator) null);
                if (m2837ap != null && ViewGroup.this.indexOfChild(view) < 0) {
                    aVar2.mo3078b(componentCallbacksC0374e, c0245b);
                }
            }
        });
        animator.setTarget(componentCallbacksC0374e.f2617G);
        animator.start();
    }

    /* renamed from: a */
    private static int m2908a(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? C0362a.a.fragment_open_enter : C0362a.a.fragment_open_exit;
            case 4099:
                return z ? C0362a.a.fragment_fade_enter : C0362a.a.fragment_fade_exit;
            case 8194:
                return z ? C0362a.a.fragment_close_enter : C0362a.a.fragment_close_exit;
            default:
                return -1;
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.g$a */
    static class a {

        /* renamed from: a */
        public final Animation f2712a;

        /* renamed from: b */
        public final Animator f2713b;

        a(Animation animation) {
            this.f2712a = animation;
            this.f2713b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f2712a = null;
            this.f2713b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.g$b */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f2714a;

        /* renamed from: b */
        private final View f2715b;

        /* renamed from: c */
        private boolean f2716c;

        /* renamed from: d */
        private boolean f2717d;

        /* renamed from: e */
        private boolean f2718e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2718e = true;
            this.f2714a = viewGroup;
            this.f2715b = view;
            addAnimation(animation);
            this.f2714a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f2718e = true;
            if (this.f2716c) {
                return !this.f2717d;
            }
            if (super.getTransformation(j, transformation)) {
                return true;
            }
            this.f2716c = true;
            ViewOnAttachStateChangeListenerC0305u.m2209a(this.f2714a, this);
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f2718e = true;
            if (this.f2716c) {
                return !this.f2717d;
            }
            if (super.getTransformation(j, transformation, f2)) {
                return true;
            }
            this.f2716c = true;
            ViewOnAttachStateChangeListenerC0305u.m2209a(this.f2714a, this);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f2716c && this.f2718e) {
                this.f2718e = false;
                this.f2714a.post(this);
            } else {
                this.f2714a.endViewTransition(this.f2715b);
                this.f2717d = true;
            }
        }
    }
}
