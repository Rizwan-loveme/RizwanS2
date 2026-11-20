package ru.maximoff.apktool.fragment.p302b;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.p209io.File;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.p296a.C2887g;
import ru.maximoff.apktool.p300e.AsyncTaskC2952w;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2918at;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3068ac;
import ru.maximoff.apktool.util.C3072ad;
import ru.maximoff.apktool.util.C3082an;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3264w;
import ru.maximoff.apktool.util.C3267z;

/* compiled from: FileItem.java */
/* renamed from: ru.maximoff.apktool.fragment.b.i */
/* loaded from: classes.dex */
public class C2990i implements InterfaceC2994m {

    /* renamed from: a */
    private final File f16459a;

    /* renamed from: b */
    private Context f16460b;

    /* renamed from: c */
    private C3066aa f16461c;

    /* renamed from: d */
    private boolean f16462d;

    /* renamed from: e */
    private int f16463e;

    /* renamed from: f */
    private C3264w f16464f;

    /* renamed from: g */
    private InterfaceC2995n f16465g;

    /* renamed from: h */
    private View f16466h;

    /* renamed from: i */
    private ObjectAnimator f16467i;

    /* renamed from: j */
    private Handler f16468j;

    /* renamed from: k */
    private boolean f16469k;

    /* renamed from: l */
    private boolean f16470l;

    /* renamed from: m */
    private boolean f16471m;

    @Override // java.lang.Comparable
    public int compareTo(InterfaceC2994m interfaceC2994m) {
        return m17921a(interfaceC2994m);
    }

    public C2990i(File file, Context context, boolean z, C3264w c3264w) {
        this.f16459a = file;
        this.f16469k = z && C3102bd.f18334q > 0;
        this.f16460b = context;
        this.f16471m = C3102bd.m18925a(this.f16460b, "cut_file_mode", false);
        this.f16463e = C3246h.m19470a(this.f16460b, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
        this.f16462d = false;
        this.f16464f = c3264w;
        this.f16461c = new C3066aa(context);
        this.f16468j = new Handler(Looper.getMainLooper());
        this.f16470l = C3262u.m19674l(file);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17863a() {
        if (this.f16466h == null || !this.f16469k) {
            return;
        }
        this.f16469k = false;
        this.f16466h.setBackgroundColor(C3246h.m19470a(this.f16460b, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
        this.f16468j.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.b.i.1

            /* renamed from: a */
            private final C2990i f16472a;

            {
                this.f16472a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16472a.f16467i = ObjectAnimator.ofObject(this.f16472a.f16466h, "backgroundColor", new ArgbEvaluator(), new Integer(((ColorDrawable) this.f16472a.f16466h.getBackground()).getColor()), new Integer(0));
                this.f16472a.f16467i.setDuration(C3102bd.f18334q);
                this.f16472a.f16467i.addListener(new Animator.AnimatorListener(this) { // from class: ru.maximoff.apktool.fragment.b.i.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f16473a;

                    {
                        this.f16473a = this;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.f16472a.f16467i.start();
            }
        }, 300L);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: c */
    public boolean mo17870c() {
        return this.f16469k;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public void mo17868b() {
        if (this.f16467i != null && this.f16467i.isRunning()) {
            this.f16467i.removeAllListeners();
            this.f16467i.end();
            this.f16467i.cancel();
        }
        if (this.f16468j != null) {
            this.f16468j.removeCallbacksAndMessages((Object) null);
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17864a(View view, ImageView imageView, TextView textView, TextView textView2, InterfaceC2995n interfaceC2995n) {
        this.f16465g = interfaceC2995n;
        this.f16466h = view;
        if (interfaceC2995n.mo17957i(this.f16459a.getAbsolutePath())) {
            this.f16466h.setBackgroundColor(C3246h.m19470a(this.f16460b, R.color.tvery_light_blue));
        } else if (C2978b.f16135a.m17697a(this.f16459a)) {
            this.f16466h.setBackgroundColor(C3246h.m19470a(this.f16460b, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
        } else {
            this.f16466h.setBackgroundColor(0);
        }
        View findViewById = view.findViewById(R.id.border);
        if (C3082an.f18011a.m18649b(this.f16459a.getAbsolutePath())) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        boolean mo17939a = this.f16465g.mo17939a(this.f16459a.getAbsolutePath());
        imageView.setTag(this.f16459a.getAbsolutePath());
        textView2.setTag(this.f16459a.getAbsolutePath());
        String name = this.f16459a.getName();
        if (mo17939a) {
            SpannableString spannableString = new SpannableString(name);
            spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f16460b, R.color.dark_green)), 0, name.length(), 33);
            spannableString.setSpan(new StyleSpan(1), 0, name.length(), 33);
            textView.setText(spannableString);
        } else {
            textView.setText(name);
        }
        textView.setContentDescription(name);
        C2918at.m17328a(this.f16459a, new C2918at.a(this, new AsyncTaskC2952w(this.f16460b, textView2, mo17939a)) { // from class: ru.maximoff.apktool.fragment.b.i.2

            /* renamed from: a */
            private final C2990i f16474a;

            /* renamed from: b */
            private final AsyncTaskC2952w f16475b;

            {
                this.f16474a = this;
                this.f16475b = r2;
            }

            @Override // ru.maximoff.apktool.p300e.C2918at.a
            /* renamed from: a */
            public AsyncTaskC2952w mo17337a() {
                return this.f16475b;
            }
        });
        String lowerCase = name.toLowerCase();
        if (this.f16459a.isDirectory() && !this.f16470l && !this.f16459a.getAbsolutePath().startsWith(C3249i.f19550j)) {
            imageView.setImageBitmap(C3267z.m19713a().m19714a(this.f16461c, this.f16463e, R.drawable.ic_folder));
        } else {
            int[] m18400a = C3068ac.m18400a(this.f16460b, lowerCase);
            if (this.f16470l || this.f16459a.getAbsolutePath().startsWith(C3249i.f19550j)) {
                imageView.setImageBitmap(C3267z.m19713a().m19714a(this.f16461c, this.f16463e, R.drawable.ic_folder));
            } else {
                imageView.setImageBitmap(C3267z.m19713a().m19714a(this.f16461c, m18400a[1], m18400a[0]));
            }
            if (this.f16470l || this.f16459a.getAbsolutePath().startsWith(C3249i.f19550j) || C3072ad.m18430a(lowerCase) || m18400a[0] == R.drawable.ic_image) {
                C2919au.m17340a(this.f16459a, new C2919au.a(this, new AsyncTaskC2954y(this.f16460b, imageView, interfaceC2995n)) { // from class: ru.maximoff.apktool.fragment.b.i.3

                    /* renamed from: a */
                    private final C2990i f16476a;

                    /* renamed from: b */
                    private final AsyncTaskC2954y f16477b;

                    {
                        this.f16476a = this;
                        this.f16477b = r2;
                    }

                    @Override // ru.maximoff.apktool.p300e.C2919au.a
                    /* renamed from: a */
                    public AsyncTaskC2954y mo17349a() {
                        return this.f16477b;
                    }
                });
            }
        }
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.i.4

            /* renamed from: a */
            private final C2990i f16478a;

            {
                this.f16478a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16478a.mo17868b();
                this.f16478a.f16465g.mo17949e(this.f16478a.f16459a.getAbsolutePath());
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.i.5

            /* renamed from: a */
            private final C2990i f16479a;

            {
                this.f16479a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                this.f16479a.mo17868b();
                this.f16479a.f16465g.mo17953g(this.f16479a.f16459a.getAbsolutePath());
                this.f16479a.f16462d = true;
                return true;
            }
        });
        if (this.f16471m && interfaceC2995n.mo17943b(this.f16459a.getAbsolutePath())) {
            imageView.setAlpha(0.4f);
        } else {
            imageView.setAlpha(1.0f);
        }
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17867a(C2981b c2981b) {
        File file = this.f16459a;
        if (file.isFile()) {
            String str = C3262u.m19641b(file.getName().toLowerCase())[1];
            if ((C3262u.m19673k(this.f16460b, file) || C2887g.m16904a(str)) && !C3102bd.m18925a(this.f16460b, "ext_editor", false) && !str.equals("amd") && !str.equals("mtd") && !str.equals("sh")) {
                c2981b.m17821a(file);
                if (this.f16464f != null) {
                    this.f16464f.m19685a(file);
                }
                if (this.f16465g == null) {
                    return true;
                }
                this.f16465g.mo17929a();
                return true;
            }
        }
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17866a(View view, InterfaceC2995n interfaceC2995n) {
        if (this.f16459a.isDirectory()) {
            interfaceC2995n.mo17947d(this.f16459a.getParent());
        }
        if (this.f16462d) {
            this.f16462d = false;
            return true;
        }
        if (interfaceC2995n.mo17970v()) {
            interfaceC2995n.mo17949e(this.f16459a.getAbsolutePath());
            return true;
        }
        if (this.f16459a.isDirectory()) {
            return false;
        }
        if (this.f16464f != null) {
            this.f16464f.m19685a(this.f16459a);
        }
        C3262u.m19608a(this.f16459a, view, interfaceC2995n);
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17865a(C2991j c2991j) {
        c2991j.mo17934a(this.f16459a);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public boolean mo17869b(View view, InterfaceC2995n interfaceC2995n) {
        C3262u.m19635b(this.f16459a, view, interfaceC2995n);
        return true;
    }

    /* renamed from: a */
    public int m17921a(InterfaceC2994m interfaceC2994m) {
        if (!(interfaceC2994m instanceof C2990i)) {
            return 1;
        }
        File file = this.f16459a;
        File file2 = ((C2990i) interfaceC2994m).f16459a;
        if (file.isDirectory() && file2.isFile()) {
            return -1;
        }
        if (file2.isDirectory() && file.isFile()) {
            return 1;
        }
        return EnumC2989h.m17909a().mo17914a(file, file2);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: d */
    public String mo17871d() {
        return this.f16459a.getAbsolutePath();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: e */
    public int mo17872e() {
        return 0;
    }

    public int hashCode() {
        return this.f16459a.hashCode();
    }
}
