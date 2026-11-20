package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.C0436e;

/* compiled from: DialogFragment.java */
/* renamed from: androidx.fragment.app.d */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0373d extends ComponentCallbacksC0374e implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: W */
    private Handler f2588W;

    /* renamed from: af */
    private boolean f2597af;

    /* renamed from: ah */
    private Dialog f2599ah;

    /* renamed from: ai */
    private boolean f2600ai;

    /* renamed from: aj */
    private boolean f2601aj;

    /* renamed from: ak */
    private boolean f2602ak;

    /* renamed from: X */
    private Runnable f2589X = new Runnable() { // from class: androidx.fragment.app.d.1
        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogInterfaceOnCancelListenerC0373d.this.f2591Z.onDismiss(DialogInterfaceOnCancelListenerC0373d.this.f2599ah);
        }
    };

    /* renamed from: Y */
    private DialogInterface.OnCancelListener f2590Y = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.d.2
        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0373d.this.f2599ah != null) {
                DialogInterfaceOnCancelListenerC0373d.this.onCancel(DialogInterfaceOnCancelListenerC0373d.this.f2599ah);
            }
        }
    };

    /* renamed from: Z */
    private DialogInterface.OnDismissListener f2591Z = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.d.3
        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0373d.this.f2599ah != null) {
                DialogInterfaceOnCancelListenerC0373d.this.onDismiss(DialogInterfaceOnCancelListenerC0373d.this.f2599ah);
            }
        }
    };

    /* renamed from: aa */
    private int f2592aa = 0;

    /* renamed from: ab */
    private int f2593ab = 0;

    /* renamed from: ac */
    private boolean f2594ac = true;

    /* renamed from: ad */
    private boolean f2595ad = true;

    /* renamed from: ae */
    private int f2596ae = -1;

    /* renamed from: ag */
    private Observer<LifecycleOwner> f2598ag = new Observer<LifecycleOwner>() { // from class: androidx.fragment.app.d.4
        @Override // androidx.lifecycle.Observer
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null && DialogInterfaceOnCancelListenerC0373d.this.f2595ad) {
                View D = DialogInterfaceOnCancelListenerC0373d.this.m2777D();
                if (D.getParent() == null) {
                    if (DialogInterfaceOnCancelListenerC0373d.this.f2599ah != null) {
                        if (AbstractC0384o.m2976a(3)) {
                            Log.m182d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0373d.this.f2599ah);
                        }
                        DialogInterfaceOnCancelListenerC0373d.this.f2599ah.setContentView(D);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
    };

    /* renamed from: al */
    private boolean f2603al = false;

    /* renamed from: a */
    private void m2749a(boolean z, boolean z2) {
        if (!this.f2601aj) {
            this.f2601aj = true;
            this.f2602ak = false;
            if (this.f2599ah != null) {
                this.f2599ah.setOnDismissListener(null);
                this.f2599ah.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.f2588W.getLooper()) {
                        onDismiss(this.f2599ah);
                    } else {
                        this.f2588W.post(this.f2589X);
                    }
                }
            }
            this.f2600ai = true;
            if (this.f2596ae >= 0) {
                m2883t().m3003a(this.f2596ae, 1);
                this.f2596ae = -1;
                return;
            }
            AbstractC0393x m3002a = m2883t().m3002a();
            m3002a.mo2634a(this);
            if (z) {
                m3002a.mo2647c();
            } else {
                m3002a.mo2643b();
            }
        }
    }

    /* renamed from: a */
    public int m2753a() {
        return this.f2593ab;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2755a(Context context) {
        super.mo2755a(context);
        m2865i().observeForever(this.f2598ag);
        if (!this.f2602ak) {
            this.f2601aj = false;
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public void mo2757b() {
        super.mo2757b();
        if (!this.f2602ak && !this.f2601aj) {
            this.f2601aj = true;
        }
        m2865i().removeObserver(this.f2598ag);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public void mo2758b(Bundle bundle) {
        super.mo2758b(bundle);
        this.f2588W = new Handler();
        this.f2595ad = this.f2660x == 0;
        if (bundle != null) {
            this.f2592aa = bundle.getInt("android:style", 0);
            this.f2593ab = bundle.getInt("android:theme", 0);
            this.f2594ac = bundle.getBoolean("android:cancelable", true);
            this.f2595ad = bundle.getBoolean("android:showsDialog", this.f2595ad);
            this.f2596ae = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    void mo2756a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo2756a(layoutInflater, viewGroup, bundle);
        if (this.f2617G == null && this.f2599ah != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2599ah.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: c */
    AbstractC0377h mo2760c() {
        final AbstractC0377h mo2760c = super.mo2760c();
        return new AbstractC0377h() { // from class: androidx.fragment.app.d.5
            @Override // androidx.fragment.app.AbstractC0377h
            /* renamed from: a */
            public View mo2767a(int i) {
                return mo2760c.mo2768a() ? mo2760c.mo2767a(i) : DialogInterfaceOnCancelListenerC0373d.this.m2754a(i);
            }

            @Override // androidx.fragment.app.AbstractC0377h
            /* renamed from: a */
            public boolean mo2768a() {
                return mo2760c.mo2768a() || DialogInterfaceOnCancelListenerC0373d.this.m2763e();
            }
        };
    }

    /* renamed from: a */
    View m2754a(int i) {
        if (this.f2599ah != null) {
            return this.f2599ah.findViewById(i);
        }
        return null;
    }

    /* renamed from: e */
    boolean m2763e() {
        return this.f2603al;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: c */
    public LayoutInflater mo2759c(Bundle bundle) {
        LayoutInflater mo2759c = super.mo2759c(bundle);
        if (!this.f2595ad || this.f2597af) {
            if (AbstractC0384o.m2976a(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.f2595ad) {
                    Log.m182d("FragmentManager", "mShowsDialog = false: " + str);
                    return mo2759c;
                }
                Log.m182d("FragmentManager", "mCreatingDialog = true: " + str);
                return mo2759c;
            }
            return mo2759c;
        }
        m2752o(bundle);
        if (AbstractC0384o.m2976a(2)) {
            Log.m182d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        if (this.f2599ah != null) {
            return mo2759c.cloneInContext(this.f2599ah.getContext());
        }
        return mo2759c;
    }

    /* renamed from: a */
    public void mo587a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                    break;
                }
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    /* renamed from: a */
    public Dialog mo586a(Bundle bundle) {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(m2878o(), m2753a());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f2600ai) {
            if (AbstractC0384o.m2976a(3)) {
                Log.m182d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            m2749a(true, true);
        }
    }

    /* renamed from: o */
    private void m2752o(Bundle bundle) {
        if (this.f2595ad && !this.f2603al) {
            try {
                this.f2597af = true;
                this.f2599ah = mo586a(bundle);
                if (this.f2595ad) {
                    mo587a(this.f2599ah, this.f2592aa);
                    Context n = m2876n();
                    if (n instanceof Activity) {
                        this.f2599ah.setOwnerActivity((Activity) n);
                    }
                    this.f2599ah.setCancelable(this.f2594ac);
                    this.f2599ah.setOnCancelListener(this.f2590Y);
                    this.f2599ah.setOnDismissListener(this.f2591Z);
                    this.f2603al = true;
                } else {
                    this.f2599ah = null;
                }
            } finally {
                this.f2597af = false;
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: d */
    public void mo2761d(Bundle bundle) {
        Bundle bundle2;
        super.mo2761d(bundle);
        if (this.f2599ah != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2599ah.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: f */
    public void mo2764f() {
        super.mo2764f();
        if (this.f2599ah != null) {
            this.f2600ai = false;
            this.f2599ah.show();
            View decorView = this.f2599ah.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(decorView, this);
            ViewTreeViewModelStoreOwner.set(decorView, this);
            C0436e.m3353a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: e */
    public void mo2762e(Bundle bundle) {
        super.mo2762e(bundle);
        if (this.f2599ah != null) {
            Bundle onSaveInstanceState = this.f2599ah.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        if (this.f2592aa != 0) {
            bundle.putInt("android:style", this.f2592aa);
        }
        if (this.f2593ab != 0) {
            bundle.putInt("android:theme", this.f2593ab);
        }
        if (!this.f2594ac) {
            bundle.putBoolean("android:cancelable", this.f2594ac);
        }
        if (!this.f2595ad) {
            bundle.putBoolean("android:showsDialog", this.f2595ad);
        }
        if (this.f2596ae != -1) {
            bundle.putInt("android:backStackId", this.f2596ae);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: g */
    public void mo2765g() {
        super.mo2765g();
        if (this.f2599ah != null) {
            this.f2599ah.hide();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: h */
    public void mo2692h() {
        super.mo2692h();
        if (this.f2599ah != null) {
            this.f2600ai = true;
            this.f2599ah.setOnDismissListener(null);
            this.f2599ah.dismiss();
            if (!this.f2601aj) {
                onDismiss(this.f2599ah);
            }
            this.f2599ah = null;
            this.f2603al = false;
        }
    }
}
