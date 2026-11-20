package androidx.fragment.app;

import android.C0012R;
import android.content.Context;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: ListFragment.java */
/* renamed from: androidx.fragment.app.ac */
/* loaded from: classes.dex */
public class C0366ac extends ComponentCallbacksC0374e {

    /* renamed from: W */
    ListAdapter f2488W;

    /* renamed from: X */
    ListView f2489X;

    /* renamed from: Y */
    View f2490Y;

    /* renamed from: Z */
    TextView f2491Z;

    /* renamed from: aa */
    View f2492aa;

    /* renamed from: ab */
    View f2493ab;

    /* renamed from: ac */
    CharSequence f2494ac;

    /* renamed from: ad */
    boolean f2495ad;

    /* renamed from: ae */
    private final Handler f2496ae = new Handler();

    /* renamed from: af */
    private final Runnable f2497af = new Runnable() { // from class: androidx.fragment.app.ac.1
        @Override // java.lang.Runnable
        public void run() {
            C0366ac.this.f2489X.focusableViewAvailable(C0366ac.this.f2489X);
        }
    };

    /* renamed from: ag */
    private final AdapterView.OnItemClickListener f2498ag = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ac.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C0366ac.this.m2690a((ListView) adapterView, view, i, j);
        }
    };

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public View mo2691b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context o = m2878o();
        FrameLayout frameLayout = new FrameLayout(o);
        LinearLayout linearLayout = new LinearLayout(o);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(o, null, C0012R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(o);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(o);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(o);
        listView.setId(C0012R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2688a(View view, Bundle bundle) {
        super.mo2688a(view, bundle);
        m2686a();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: h */
    public void mo2692h() {
        this.f2496ae.removeCallbacks(this.f2497af);
        this.f2489X = null;
        this.f2495ad = false;
        this.f2493ab = null;
        this.f2492aa = null;
        this.f2490Y = null;
        this.f2491Z = null;
        super.mo2692h();
    }

    /* renamed from: a */
    public void m2690a(ListView listView, View view, int i, long j) {
    }

    /* renamed from: a */
    public void m2689a(ListAdapter listAdapter) {
        boolean z = this.f2488W != null;
        this.f2488W = listAdapter;
        if (this.f2489X != null) {
            this.f2489X.setAdapter(listAdapter);
            if (!this.f2495ad && !z) {
                m2687a(true, m2777D().getWindowToken() != null);
            }
        }
    }

    /* renamed from: a */
    private void m2687a(boolean z, boolean z2) {
        m2686a();
        if (this.f2492aa == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f2495ad != z) {
            this.f2495ad = z;
            if (z) {
                if (z2) {
                    this.f2492aa.startAnimation(AnimationUtils.loadAnimation(m2876n(), C0012R.anim.fade_out));
                    this.f2493ab.startAnimation(AnimationUtils.loadAnimation(m2876n(), C0012R.anim.fade_in));
                } else {
                    this.f2492aa.clearAnimation();
                    this.f2493ab.clearAnimation();
                }
                this.f2492aa.setVisibility(8);
                this.f2493ab.setVisibility(0);
                return;
            }
            if (z2) {
                this.f2492aa.startAnimation(AnimationUtils.loadAnimation(m2876n(), C0012R.anim.fade_in));
                this.f2493ab.startAnimation(AnimationUtils.loadAnimation(m2876n(), C0012R.anim.fade_out));
            } else {
                this.f2492aa.clearAnimation();
                this.f2493ab.clearAnimation();
            }
            this.f2492aa.setVisibility(0);
            this.f2493ab.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m2686a() {
        if (this.f2489X == null) {
            View C = m2776C();
            if (C == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (C instanceof ListView) {
                this.f2489X = (ListView) C;
            } else {
                this.f2491Z = (TextView) C.findViewById(16711681);
                if (this.f2491Z == null) {
                    this.f2490Y = C.findViewById(C0012R.id.empty);
                } else {
                    this.f2491Z.setVisibility(8);
                }
                this.f2492aa = C.findViewById(16711682);
                this.f2493ab = C.findViewById(16711683);
                View findViewById = C.findViewById(C0012R.id.list);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                this.f2489X = (ListView) findViewById;
                if (this.f2490Y != null) {
                    this.f2489X.setEmptyView(this.f2490Y);
                } else if (this.f2494ac != null) {
                    this.f2491Z.setText(this.f2494ac);
                    this.f2489X.setEmptyView(this.f2491Z);
                }
            }
            this.f2495ad = true;
            this.f2489X.setOnItemClickListener(this.f2498ag);
            if (this.f2488W != null) {
                ListAdapter listAdapter = this.f2488W;
                this.f2488W = null;
                m2689a(listAdapter);
            } else if (this.f2492aa != null) {
                m2687a(false, false);
            }
            this.f2496ae.post(this.f2497af);
        }
    }
}
