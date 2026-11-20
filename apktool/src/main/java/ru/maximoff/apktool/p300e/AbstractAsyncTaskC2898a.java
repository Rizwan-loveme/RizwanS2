package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.app.slice.Slice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.DropBoxManager;
import android.p008os.Handler;
import android.p008os.Looper;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import p046b.p059d.C0542g;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.view.C3306h;

/* compiled from: AbstractTask.java */
/* renamed from: ru.maximoff.apktool.e.a */
/* loaded from: classes.dex */
public abstract class AbstractAsyncTaskC2898a extends AsyncTask<File, CharSequence, Boolean> implements InterfaceC0541f {

    /* renamed from: x */
    private static boolean f14942x;

    /* renamed from: y */
    private static boolean f14943y;

    /* renamed from: B */
    private DialogInterfaceC0070b f14945B;

    /* renamed from: d */
    private Context f14949d;

    /* renamed from: e */
    private C3306h f14950e;

    /* renamed from: f */
    private DialogInterfaceC0070b f14951f;

    /* renamed from: g */
    private InterfaceC2995n f14952g;

    /* renamed from: k */
    private List<String> f14956k;

    /* renamed from: m */
    private Process f14958m;

    /* renamed from: r */
    private boolean f14963r;

    /* renamed from: w */
    private RotateAnimation f14968w;

    /* renamed from: z */
    private Handler f14969z;

    /* renamed from: a */
    private long f14946a = 0;

    /* renamed from: b */
    private long f14947b = 0;

    /* renamed from: c */
    private boolean f14948c = true;

    /* renamed from: A */
    private final long f14944A = 5000;

    /* renamed from: h */
    private File f14953h = (File) null;

    /* renamed from: i */
    private File f14954i = (File) null;

    /* renamed from: j */
    private File f14955j = (File) null;

    /* renamed from: s */
    private String f14964s = (String) null;

    /* renamed from: t */
    private Runnable f14965t = (Runnable) null;

    /* renamed from: u */
    private Runnable f14966u = (Runnable) null;

    /* renamed from: n */
    private boolean f14959n = false;

    /* renamed from: o */
    private boolean f14960o = false;

    /* renamed from: p */
    private boolean f14961p = false;

    /* renamed from: q */
    private boolean f14962q = false;

    /* renamed from: l */
    private Thread f14957l = (Thread) null;

    /* renamed from: v */
    private boolean f14967v = false;

    /* renamed from: a */
    protected abstract boolean mo17058a(File file);

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: b */
    public void mo3982b(int i, Object... objArr) {
    }

    /* renamed from: c */
    protected abstract int mo17065c();

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return mo17049a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onCancelled(Boolean bool) {
        m17051a(bool);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        mo17061b(bool);
    }

    @Override // android.p008os.AsyncTask
    protected void onProgressUpdate(CharSequence[] charSequenceArr) {
        m17057a(charSequenceArr);
    }

    public AbstractAsyncTaskC2898a(Context context, InterfaceC2995n interfaceC2995n) {
        this.f14949d = context;
        this.f14952g = interfaceC2995n;
        f14942x = false;
        f14943y = false;
        this.f14963r = false;
        this.f14969z = new Handler(Looper.getMainLooper());
        this.f14956k = new ArrayList();
    }

    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        this.f14957l = Thread.currentThread();
        boolean z = true;
        for (File file : fileArr) {
            if (isCancelled()) {
                return new Boolean(false);
            }
            this.f14954i = file;
            if (!mo17058a(file)) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        int i;
        if (this.f14946a == 0) {
            this.f14946a = System.currentTimeMillis();
        }
        if (C3102bd.f18291a) {
            i = R.drawable.ic_settings_light;
        } else {
            i = R.drawable.ic_settings_dark;
        }
        this.f14950e = new C3306h(this.f14949d);
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14949d).m435b(this.f14950e).m439c(i).m418a(mo17065c()).m429a(false).m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (this.f14961p) {
            m420a.m440c(R.string.background, (DialogInterface.OnClickListener) null);
        }
        this.f14951f = m420a.m438b();
        this.f14951f.setOnShowListener(new AnonymousClass1(this));
        this.f14951f.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.e.a.2

            /* renamed from: a */
            private final AbstractAsyncTaskC2898a f14975a;

            {
                this.f14975a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f14975a.f14968w != null) {
                    this.f14975a.f14968w.cancel();
                }
                this.f14975a.m17038g(false);
                MainActivity m16615o = MainActivity.m16615o();
                if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                    m16615o.m16630b((DialogInterfaceC0070b) null);
                    if (this.f14975a.f14961p && this.f14975a.f14962q) {
                        m16615o.m16629a(true);
                    }
                }
                this.f14975a.f14962q = false;
            }
        });
        this.f14951f.show();
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
            m16615o.m16630b(this.f14951f);
            if (this.f14961p) {
                m16615o.m16629a(false);
            }
        }
        m17038g(true);
        this.f14969z.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.e.a.3

            /* renamed from: a */
            private final AbstractAsyncTaskC2898a f14976a;

            {
                this.f14976a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f14976a.f14959n || !C3102bd.m18925a(this.f14976a.f14949d, "ongoing_notification", true)) {
                    return;
                }
                String string = this.f14976a.f14949d.getString(this.f14976a.mo17065c());
                String str = (String) null;
                if (this.f14976a.f14950e != null) {
                    str = this.f14976a.f14950e.getLastString();
                }
                this.f14976a.m17055a(string, str, "abstract_task");
            }
        }, 5000L);
    }

    /* compiled from: AbstractTask.java */
    /* renamed from: ru.maximoff.apktool.e.a$1, reason: invalid class name */
    class AnonymousClass1 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AbstractAsyncTaskC2898a f14970a;

        AnonymousClass1(AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
            this.f14970a = abstractAsyncTaskC2898a;
        }

        /* renamed from: a */
        static AbstractAsyncTaskC2898a m17078a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f14970a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            ImageView imageView = (ImageView) this.f14970a.f14951f.findViewById(C0012R.id.icon);
            if (imageView != null) {
                int m18521a = C3080al.m18521a(this.f14970a.f14949d, 24.0f);
                int m18521a2 = C3080al.m18521a(this.f14970a.f14949d, 5.0f);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.width = m18521a;
                marginLayoutParams.height = m18521a;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, m18521a2, marginLayoutParams.bottomMargin);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
                this.f14970a.f14968w = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                this.f14970a.f14968w.setInterpolator(new LinearInterpolator());
                this.f14970a.f14968w.setRepeatCount(-1);
                this.f14970a.f14968w.setDuration(2500);
                imageView.setAnimation(this.f14970a.f14968w);
                imageView.startAnimation(this.f14970a.f14968w);
            }
            this.f14970a.f14951f.m414a(-1).setOnClickListener(new ViewOnClickListenerC33661(this));
            if (this.f14970a.f14961p) {
                this.f14970a.f14951f.m414a(-3).setOnClickListener(new AnonymousClass2(this));
            }
        }

        /* compiled from: AbstractTask.java */
        /* renamed from: ru.maximoff.apktool.e.a$1$1, reason: invalid class name and collision with other inner class name */
        class ViewOnClickListenerC33661 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass1 f14971a;

            ViewOnClickListenerC33661(AnonymousClass1 anonymousClass1) {
                this.f14971a = anonymousClass1;
            }

            /* renamed from: a */
            static AnonymousClass1 m17079a(ViewOnClickListenerC33661 viewOnClickListenerC33661) {
                return viewOnClickListenerC33661.f14971a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new DialogInterfaceC0070b.a(AnonymousClass1.m17078a(this.f14971a).f14949d).m418a(R.string.cancel).m433b(R.string.task_cancel_sure).m420a(R.string.yes, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.e.a.1.1.1

                    /* renamed from: a */
                    private final ViewOnClickListenerC33661 f14972a;

                    {
                        this.f14972a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14963r = true;
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14969z != null) {
                            AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14969z.removeCallbacksAndMessages((Object) null);
                        }
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14958m != null) {
                            AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).m17059b();
                        }
                        C0542g.m3992b();
                        AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).cancel(true);
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14957l != null) {
                            AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14957l.interrupt();
                        }
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14951f != null && AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14951f.isShowing()) {
                            try {
                                AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14951f.cancel();
                            } catch (Exception e2) {
                            }
                        }
                        C3112bn.m18999a(AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14949d, R.string.cancel);
                        MainActivity m16615o = MainActivity.m16615o();
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14952g != null) {
                            AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14952g.mo17929a();
                        } else if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                            m16615o.m16637s();
                        }
                        if (AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).f14959n) {
                            AnonymousClass1.m17078a(ViewOnClickListenerC33661.m17079a(this.f14972a)).m17073g();
                        }
                    }
                }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
            }
        }

        /* compiled from: AbstractTask.java */
        /* renamed from: ru.maximoff.apktool.e.a$1$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass1 f14973a;

            AnonymousClass2(AnonymousClass1 anonymousClass1) {
                this.f14973a = anonymousClass1;
            }

            /* renamed from: a */
            static AnonymousClass1 m17080a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f14973a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnonymousClass1.m17078a(this.f14973a).f14969z != null) {
                    AnonymousClass1.m17078a(this.f14973a).f14969z.removeCallbacksAndMessages((Object) null);
                }
                if (AnonymousClass1.m17078a(this.f14973a).f14959n) {
                    AnonymousClass1.m17078a(this.f14973a).m17073g();
                }
                AnonymousClass1.m17078a(this.f14973a).f14969z.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.e.a.1.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f14974a;

                    {
                        this.f14974a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).f14960o) {
                            return;
                        }
                        String string = AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).f14949d.getString(AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).mo17065c());
                        String str = (String) null;
                        if (AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).f14950e != null) {
                            str = AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).f14950e.getLastString();
                        }
                        AnonymousClass1.m17078a(AnonymousClass2.m17080a(this.f14974a)).m17063b(string, str, "abstract_task_bg");
                    }
                }, 300L);
                if (AnonymousClass1.m17078a(this.f14973a).f14952g != null) {
                    AnonymousClass1.m17078a(this.f14973a).f14952g.mo17929a();
                }
                AnonymousClass1.m17078a(this.f14973a).f14962q = true;
                AnonymousClass1.m17078a(this.f14973a).f14951f.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m17038g(boolean z) {
        C3102bd.m18938b(this.f14949d, "dont_kill_my_app", z);
    }

    /* renamed from: a */
    public void m17056a(boolean z) {
        this.f14961p = z;
    }

    /* renamed from: a */
    public void m17052a(Process process) {
        this.f14958m = process;
    }

    /* renamed from: b */
    public void m17059b() {
        Thread thread = new Thread(this) { // from class: ru.maximoff.apktool.e.a.4

            /* renamed from: a */
            private final AbstractAsyncTaskC2898a f14977a;

            {
                this.f14977a = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (this.f14977a.f14958m != null) {
                    this.f14977a.f14958m.destroy();
                    this.f14977a.f14958m = (Process) null;
                }
            }
        };
        thread.start();
        thread.interrupt();
    }

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: a */
    public boolean mo3981a() {
        return this.f14963r;
    }

    /* renamed from: a */
    protected void m17051a(Boolean bool) {
        if (this.f14969z != null) {
            this.f14969z.removeCallbacksAndMessages((Object) null);
        }
        if (this.f14959n) {
            m17073g();
        }
        if (this.f14960o) {
            m17074h();
        }
        if (this.f14951f == null || !this.f14951f.isShowing()) {
            return;
        }
        try {
            this.f14951f.cancel();
        } catch (Exception e2) {
        }
    }

    @Override // android.p008os.AsyncTask
    protected void onCancelled() {
        if (this.f14969z != null) {
            this.f14969z.removeCallbacksAndMessages((Object) null);
        }
        if (this.f14959n) {
            m17073g();
        }
        if (this.f14960o) {
            m17074h();
        }
        if (this.f14951f == null || !this.f14951f.isShowing()) {
            return;
        }
        try {
            this.f14951f.cancel();
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        String string;
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o == null || m16615o.isFinishing() || m16615o.isDestroyed() || m16615o.m16634p()) {
            if (this.f14969z != null) {
                this.f14969z.removeCallbacksAndMessages((Object) null);
            }
            if (this.f14959n) {
                m17073g();
            }
            if (this.f14960o) {
                m17074h();
                return;
            }
            return;
        }
        this.f14949d = m16615o;
        m16615o.m16621a((DialogInterfaceC0070b) null);
        m16615o.m16630b((DialogInterfaceC0070b) null);
        if (this.f14961p) {
            m16615o.m16629a(false);
        }
        m17038g(false);
        this.f14947b = System.currentTimeMillis();
        this.f14956k.addAll(this.f14950e.getTextList());
        if (this.f14951f != null && this.f14951f.isShowing()) {
            try {
                this.f14951f.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f14969z != null) {
            this.f14969z.removeCallbacksAndMessages((Object) null);
        }
        if (!m17036f() && this.f14959n) {
            m17073g();
        }
        if (!m17036f() && this.f14960o) {
            m17074h();
        }
        if ((mo17071e() || !bool.booleanValue()) && !isCancelled()) {
            if (this.f14948c) {
                this.f14956k.add(new StringBuffer().append("I: ").append(this.f14949d.getString(R.string.time_spent, C3080al.m18533a(this.f14947b - this.f14946a))).toString());
            }
            if (!bool.booleanValue() && this.f14953h == null && this.f14955j != null) {
                this.f14953h = this.f14955j;
            }
            String m18538a = C3080al.m18538a(this.f14956k, "\n");
            C3306h c3306h = new C3306h(this.f14949d);
            c3306h.m19903a(this.f14967v);
            c3306h.m19902a(this.f14956k);
            c3306h.m19904b(true);
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f14949d);
            aVar.m435b(c3306h).m418a(R.string.complete).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.e.a.5

                /* renamed from: a */
                private final AbstractAsyncTaskC2898a f14978a;

                {
                    this.f14978a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).m429a(true).m434b(R.string.copy, (DialogInterface.OnClickListener) null);
            if (this.f14953h != null || this.f14964s != null) {
                if (this.f14964s != null) {
                    string = this.f14964s;
                } else {
                    string = this.f14949d.getString(this.f14953h.isDirectory() ? R.string.go_to : R.string.install);
                }
                aVar.m437b(string, (DialogInterface.OnClickListener) null);
            }
            this.f14945B = aVar.m438b();
            c3306h.setDialog(this.f14945B);
            this.f14945B.setOnShowListener(new AnonymousClass6(this, m18538a, m16615o));
            this.f14945B.setOnCancelListener(new DialogInterface.OnCancelListener(this, m16615o) { // from class: ru.maximoff.apktool.e.a.7

                /* renamed from: a */
                private final AbstractAsyncTaskC2898a f14993a;

                /* renamed from: b */
                private final MainActivity f14994b;

                {
                    this.f14993a = this;
                    this.f14994b = m16615o;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (this.f14994b == null || this.f14994b.isFinishing() || this.f14994b.isDestroyed() || this.f14994b.m16634p()) {
                        return;
                    }
                    this.f14994b.m16621a((DialogInterfaceC0070b) null);
                    this.f14994b.m16630b((DialogInterfaceC0070b) null);
                    if (this.f14993a.f14961p) {
                        this.f14994b.m16629a(false);
                    }
                }
            });
            if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                this.f14945B.show();
            } else {
                m17038g(true);
            }
        }
        if (this.f14952g != null) {
            this.f14952g.mo17929a();
        } else {
            if (m16615o == null || m16615o.isFinishing() || m16615o.isDestroyed() || m16615o.m16634p()) {
                return;
            }
            m16615o.m16637s();
        }
    }

    /* compiled from: AbstractTask.java */
    /* renamed from: ru.maximoff.apktool.e.a$6, reason: invalid class name */
    class AnonymousClass6 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AbstractAsyncTaskC2898a f14979a;

        /* renamed from: b */
        private final String f14980b;

        /* renamed from: c */
        private final MainActivity f14981c;

        AnonymousClass6(AbstractAsyncTaskC2898a abstractAsyncTaskC2898a, String str, MainActivity mainActivity) {
            this.f14979a = abstractAsyncTaskC2898a;
            this.f14980b = str;
            this.f14981c = mainActivity;
        }

        /* renamed from: a */
        static AbstractAsyncTaskC2898a m17081a(AnonymousClass6 anonymousClass6) {
            return anonymousClass6.f14979a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f14979a.f14945B.m414a(-2);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f14980b) { // from class: ru.maximoff.apktool.e.a.6.1

                /* renamed from: a */
                private final AnonymousClass6 f14982a;

                /* renamed from: b */
                private final String f14983b;

                {
                    this.f14982a = this;
                    this.f14983b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3112bn.m19002a(AnonymousClass6.m17081a(this.f14982a).f14949d, this.f14983b);
                }
            });
            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f14980b, this.f14981c) { // from class: ru.maximoff.apktool.e.a.6.2

                /* renamed from: a */
                private final AnonymousClass6 f14984a;

                /* renamed from: b */
                private final String f14985b;

                /* renamed from: c */
                private final MainActivity f14986c;

                {
                    this.f14984a = this;
                    this.f14985b = r2;
                    this.f14986c = r3;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    File m17020a = AnonymousClass6.m17081a(this.f14984a).m17020a(this.f14985b);
                    if (m17020a != null && this.f14986c.m16617B() != null) {
                        this.f14986c.m16617B().m17636a(m17020a);
                        return true;
                    }
                    return true;
                }
            });
            if (this.f14979a.f14953h == null && this.f14979a.f14964s == null) {
                return;
            }
            Button m414a2 = this.f14979a.f14945B.m414a(-3);
            if ((this.f14979a.f14953h != null && this.f14979a.f14953h.isFile() && !this.f14979a.f14953h.getName().endsWith(".apk")) || (this.f14979a.f14964s != null && this.f14979a.f14965t == null)) {
                m414a2.setEnabled(false);
            }
            m414a2.setOnClickListener(new AnonymousClass3(this, this.f14981c));
            m414a2.setOnLongClickListener(new View.OnLongClickListener(this, this.f14981c) { // from class: ru.maximoff.apktool.e.a.6.4

                /* renamed from: a */
                private final AnonymousClass6 f14991a;

                /* renamed from: b */
                private final MainActivity f14992b;

                {
                    this.f14991a = this;
                    this.f14992b = r2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (AnonymousClass6.m17081a(this.f14991a).f14966u != null) {
                        AnonymousClass6.m17081a(this.f14991a).f14966u.run();
                        return true;
                    }
                    if (AnonymousClass6.m17081a(this.f14991a).f14965t != null || AnonymousClass6.m17081a(this.f14991a).f14953h == null) {
                        return false;
                    }
                    File parentFile = AnonymousClass6.m17081a(this.f14991a).f14953h.isDirectory() ? AnonymousClass6.m17081a(this.f14991a).f14953h : AnonymousClass6.m17081a(this.f14991a).f14953h.getParentFile();
                    if (AnonymousClass6.m17081a(this.f14991a).f14952g == null) {
                        if (this.f14992b != null) {
                            this.f14992b.m16623a(parentFile, AnonymousClass6.m17081a(this.f14991a).f14953h);
                        } else {
                            C3112bn.m19023b(AnonymousClass6.m17081a(this.f14991a).f14949d, AnonymousClass6.m17081a(this.f14991a).f14949d.getString(R.string.failed_open, parentFile.getAbsolutePath()));
                        }
                    } else {
                        AnonymousClass6.m17081a(this.f14991a).f14952g.mo17934a(parentFile);
                        if (!AnonymousClass6.m17081a(this.f14991a).f14953h.isDirectory()) {
                            AnonymousClass6.m17081a(this.f14991a).f14952g.mo17937a(AnonymousClass6.m17081a(this.f14991a).f14953h);
                        }
                    }
                    AnonymousClass6.m17081a(this.f14991a).f14945B.cancel();
                    return true;
                }
            });
        }

        /* compiled from: AbstractTask.java */
        /* renamed from: ru.maximoff.apktool.e.a$6$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass6 f14987a;

            /* renamed from: b */
            private final MainActivity f14988b;

            AnonymousClass3(AnonymousClass6 anonymousClass6, MainActivity mainActivity) {
                this.f14987a = anonymousClass6;
                this.f14988b = mainActivity;
            }

            /* renamed from: a */
            static AnonymousClass6 m17082a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f14987a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                int i2;
                if (AnonymousClass6.m17081a(this.f14987a).f14965t != null) {
                    AnonymousClass6.m17081a(this.f14987a).f14965t.run();
                    return;
                }
                if (AnonymousClass6.m17081a(this.f14987a).f14953h != null) {
                    if (AnonymousClass6.m17081a(this.f14987a).f14953h.isDirectory()) {
                        if (AnonymousClass6.m17081a(this.f14987a).f14952g == null) {
                            if (this.f14988b != null) {
                                this.f14988b.m16622a(AnonymousClass6.m17081a(this.f14987a).f14953h);
                            } else {
                                C3112bn.m19023b(AnonymousClass6.m17081a(this.f14987a).f14949d, AnonymousClass6.m17081a(this.f14987a).f14949d.getString(R.string.failed_open, AnonymousClass6.m17081a(this.f14987a).f14953h.getAbsolutePath()));
                            }
                        } else {
                            AnonymousClass6.m17081a(this.f14987a).f14952g.mo17934a(AnonymousClass6.m17081a(this.f14987a).f14953h);
                        }
                        AnonymousClass6.m17081a(this.f14987a).f14945B.cancel();
                        return;
                    }
                    String m18910a = C3102bd.m18910a(AnonymousClass6.m17081a(this.f14987a).f14949d, "install_opt", "0");
                    if (Build.VERSION.SDK_INT < 21) {
                        C3262u.m19590a(AnonymousClass6.m17081a(this.f14987a).f14949d, AnonymousClass6.m17081a(this.f14987a).f14953h, false);
                        AnonymousClass6.m17081a(this.f14987a).f14945B.cancel();
                        return;
                    }
                    if (!m18910a.equals("0")) {
                        try {
                            i = Integer.parseInt(m18910a);
                        } catch (Exception e2) {
                            i = 1;
                        }
                        switch (i) {
                            case 1:
                                C3262u.m19590a(AnonymousClass6.m17081a(this.f14987a).f14949d, AnonymousClass6.m17081a(this.f14987a).f14953h, false);
                                break;
                            case 2:
                                C3262u.m19590a(AnonymousClass6.m17081a(this.f14987a).f14949d, AnonymousClass6.m17081a(this.f14987a).f14953h, true);
                                break;
                        }
                        AnonymousClass6.m17081a(this.f14987a).f14945B.cancel();
                        return;
                    }
                    C0173ao c0173ao = new C0173ao(AnonymousClass6.m17081a(this.f14987a).f14949d, view);
                    if (C3102bd.m18910a(AnonymousClass6.m17081a(this.f14987a).f14949d, "menu_position", "1").equals("0")) {
                        i2 = 3;
                    } else {
                        i2 = 5;
                    }
                    c0173ao.m1340a(i2);
                    c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.install).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.e.a.6.3.1

                        /* renamed from: a */
                        private final AnonymousClass3 f14989a;

                        {
                            this.f14989a = this;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3262u.m19590a(AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14989a)).f14949d, AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14989a)).f14953h, false);
                            AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14989a)).f14945B.cancel();
                            return true;
                        }
                    });
                    c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, R.string.install_session).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.e.a.6.3.2

                        /* renamed from: a */
                        private final AnonymousClass3 f14990a;

                        {
                            this.f14990a = this;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3262u.m19590a(AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14990a)).f14949d, AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14990a)).f14953h, true);
                            AnonymousClass6.m17081a(AnonymousClass3.m17082a(this.f14990a)).f14945B.cancel();
                            return true;
                        }
                    });
                    c0173ao.m1344c();
                }
            }
        }
    }

    /* renamed from: a */
    public void m17053a(String str, Runnable runnable, Runnable runnable2) {
        this.f14964s = str;
        this.f14965t = runnable;
        this.f14966u = runnable2;
    }

    /* renamed from: d */
    public DialogInterfaceC0070b m17068d() {
        return this.f14945B;
    }

    /* renamed from: b */
    public void m17064b(boolean z) {
        this.f14967v = z;
    }

    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    /* renamed from: f */
    public static boolean m17036f() {
        return f14942x;
    }

    /* renamed from: c */
    public static void m17030c(boolean z) {
        f14942x = z;
    }

    /* renamed from: d */
    public static void m17032d(boolean z) {
        f14943y = z;
    }

    /* renamed from: a */
    public void m17054a(String str, String str2) {
        m17055a(str, (String) null, str2);
    }

    /* renamed from: a */
    public void m17055a(String str, String str2, String str3) {
        try {
            Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingService"));
            intent.setAction("ru.maximoff.apktool.OngoingService.ACTION_START");
            intent.putExtra("title", str.trim());
            if (str2 != null) {
                intent.putExtra(Slice.SUBTYPE_MESSAGE, C3112bn.m19019b(str2, 10000));
            }
            intent.putExtra(DropBoxManager.EXTRA_TAG, str3);
            intent.putExtra("ongoing_id", this.f14961p ? 2017 : PointerIcon.TYPE_ALL_SCROLL);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f14949d.startForegroundService(intent);
            } else {
                this.f14949d.startService(intent);
            }
            this.f14959n = true;
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: b */
    public void m17062b(String str, String str2) {
        if (str2 != null && !str2.trim().isEmpty() && this.f14959n) {
            try {
                Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingService"));
                intent.setAction("ru.maximoff.apktool.OngoingService.ACTION_UPDATE");
                intent.putExtra("title", str.trim());
                intent.putExtra(Slice.SUBTYPE_MESSAGE, C3112bn.m19019b(str2, 10000));
                this.f14949d.startService(intent);
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
    }

    /* renamed from: g */
    public void m17073g() {
        this.f14959n = false;
        if (this.f14969z != null) {
            this.f14969z.removeCallbacksAndMessages((Object) null);
        }
        try {
            Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingService"));
            intent.setAction("ru.maximoff.apktool.OngoingService.STOP_SERVICE");
            this.f14949d.startService(intent);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: b */
    public void m17063b(String str, String str2, String str3) {
        try {
            Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingServiceBg"));
            intent.setAction("ru.maximoff.apktool.OngoingServiceBg.ACTION_START");
            intent.putExtra("title", str.trim());
            if (str2 != null) {
                intent.putExtra(Slice.SUBTYPE_MESSAGE, C3112bn.m19019b(str2, 10000));
            }
            intent.putExtra(DropBoxManager.EXTRA_TAG, str3);
            intent.putExtra("ongoing_id", this.f14961p ? 2017 : PointerIcon.TYPE_ALL_SCROLL);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f14949d.startForegroundService(intent);
            } else {
                this.f14949d.startService(intent);
            }
            this.f14960o = true;
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: c */
    public void m17067c(String str, String str2) {
        if (str2 != null && !str2.trim().isEmpty() && this.f14960o) {
            try {
                Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingServiceBg"));
                intent.setAction("ru.maximoff.apktool.OngoingServiceBg.ACTION_UPDATE");
                intent.putExtra("title", str.trim());
                intent.putExtra(Slice.SUBTYPE_MESSAGE, C3112bn.m19019b(str2, 10000));
                this.f14949d.startService(intent);
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
    }

    /* renamed from: h */
    public void m17074h() {
        this.f14960o = false;
        try {
            Intent intent = new Intent(this.f14949d, Class.forName("ru.maximoff.apktool.service.OngoingServiceBg"));
            intent.setAction("ru.maximoff.apktool.OngoingServiceBg.STOP_SERVICE");
            this.f14949d.startService(intent);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: a */
    protected void m17057a(CharSequence... charSequenceArr) {
        this.f14950e.m19901a(charSequenceArr[0]);
        if (this.f14959n) {
            m17062b(this.f14949d.getString(mo17065c()), charSequenceArr[0].toString());
        }
        if (this.f14960o) {
            m17067c(this.f14949d.getString(mo17065c()), charSequenceArr[0].toString());
        }
    }

    /* renamed from: f */
    private String m17034f(int i, Object[] objArr) {
        return this.f14949d.getString(i, objArr);
    }

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: d */
    public void mo3984d(int i, Object... objArr) {
        publishProgress(String.format("I: %s", m17034f(i, objArr)));
    }

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: c */
    public void mo3983c(int i, Object... objArr) {
        publishProgress(String.format("W: %s", m17034f(i, objArr)));
    }

    /* renamed from: e */
    public void m17069e(int i, Object... objArr) {
        publishProgress(m17034f(i, objArr));
    }

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: a */
    public void mo3979a(int i, Object... objArr) {
        publishProgress(String.format("E: %s", m17034f(i, objArr)));
    }

    @Override // p046b.p059d.InterfaceC0541f
    /* renamed from: a */
    public void mo3980a(Level level, String str, Throwable th) {
        char charAt = level.getName().toUpperCase().charAt(0);
        publishProgress(String.format("%c: %s", new Character(charAt), str));
        m17022a("%c: %s", charAt, th);
    }

    /* renamed from: a */
    private void m17022a(String str, char c2, Throwable th) {
        if (th != null) {
            publishProgress(String.format(str, new Character(c2), th.getMessage()));
            if (f14943y) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    publishProgress(String.format(str, new Character(c2), stackTraceElement));
                }
                m17022a(str, c2, th.getCause());
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: i */
    public Context m17075i() {
        return this.f14949d;
    }

    /* renamed from: j */
    public File m17076j() {
        return this.f14953h;
    }

    /* renamed from: b */
    public void m17060b(File file) {
        this.f14953h = file;
    }

    /* renamed from: c */
    public void m17066c(File file) {
        this.f14955j = file;
    }

    /* renamed from: a */
    public void m17050a(long j) {
        this.f14946a = j;
    }

    /* renamed from: k */
    public long m17077k() {
        return this.f14946a;
    }

    /* renamed from: e */
    public void m17070e(boolean z) {
        this.f14948c = z;
    }

    /* renamed from: f */
    public void m17072f(boolean z) {
        String string;
        String str;
        String string2;
        if (!C3102bd.m18925a(this.f14949d, "dont_notification_isrun", true) || !MainActivity.f14101h) {
            if (z) {
                string = this.f14949d.getString(R.string.completed_success);
                str = "success";
                string2 = this.f14949d.getString(R.string.success);
            } else {
                string = this.f14949d.getString(R.string.completed_error);
                str = "error";
                string2 = this.f14949d.getString(R.string.error);
            }
            C3056b c3056b = new C3056b(this.f14949d);
            c3056b.m18198a(z ? false : true);
            c3056b.m18201b(false);
            c3056b.m18194a(z ? PointerIcon.TYPE_NO_DROP : PointerIcon.TYPE_COPY);
            c3056b.m18197a(new StringBuffer().append("compile_and_decompile_").append(str).toString());
            c3056b.m18195a((CharSequence) new StringBuffer().append(new StringBuffer().append((Object) this.f14949d.getText(R.string.build_and_decode)).append(" - ").toString()).append(string2).toString(), (CharSequence) string);
            c3056b.m18192a(this.f14949d.getString(R.string.app_name), string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public File m17020a(String str) {
        File file;
        boolean m19664g;
        String str2;
        if (this.f14954i == null || !this.f14954i.exists()) {
            file = this.f14953h;
        } else {
            file = this.f14954i;
        }
        if (str == null || file == null) {
            C3112bn.m19023b(this.f14949d, this.f14949d.getString(R.string.errorf, "data or file is null"));
            return (File) null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0 && file.isFile()) {
            name = name.substring(0, lastIndexOf);
        }
        if (file.isDirectory()) {
            m19664g = C3262u.m19664g(this.f14949d, file);
        } else {
            m19664g = C3262u.m19664g(this.f14949d, file.getParentFile());
        }
        if (!m19664g || C3102bd.m18925a(this.f14949d, "all_to_out_dir", false)) {
            String str3 = C3102bd.f18339v;
            if (str3 == null) {
                C3112bn.m19023b(this.f14949d, this.f14949d.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(str3);
            if (!file2.exists() && !file2.mkdirs()) {
                C3112bn.m19023b(this.f14949d, this.f14949d.getString(R.string.output_directory_not_extsts, str3));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                C3112bn.m19023b(this.f14949d, this.f14949d.getString(R.string.not_directory, str3));
                return (File) null;
            }
            str2 = str3;
        } else if (file.isDirectory()) {
            str2 = file.getAbsolutePath();
        } else {
            str2 = file.getParent();
        }
        File file3 = new File(str2, C3262u.m19566a(this.f14949d, str2, name, "_log.txt", 0));
        C3061a.m18319b(file3, str);
        MainActivity.m16615o().m16644z();
        C3112bn.m19023b(this.f14949d, this.f14949d.getString(R.string.extraction, file3.getAbsolutePath()));
        return file3;
    }
}
