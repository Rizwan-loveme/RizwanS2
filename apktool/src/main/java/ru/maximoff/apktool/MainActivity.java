package ru.maximoff.apktool;

import android.C0012R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.p008os.Process;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.AbstractC0384o;
import androidx.fragment.app.AbstractC0393x;
import androidx.fragment.app.ComponentCallbacksC0374e;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.InputStream;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.fragment.MenuItemOnActionExpandListenerC2976a;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.C2991j;
import ru.maximoff.apktool.fragment.p302b.C2993l;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AsyncTaskC2923ay;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.service.LocalFileServerService;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3082an;
import ru.maximoff.apktool.util.C3085aq;
import ru.maximoff.apktool.util.C3091aw;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3103be;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p309g.AsyncTaskC3245c;
import ru.maximoff.apktool.view.C3303e;

/* loaded from: classes.dex */
public class MainActivity extends AbstractActivityC2894b implements DrawerLayout.InterfaceC0353c {

    /* renamed from: h */
    public static boolean f14101h = false;

    /* renamed from: i */
    public static boolean f14102i = false;

    /* renamed from: j */
    private static MainActivity f14103j;

    /* renamed from: l */
    private C3303e f14105l;

    /* renamed from: m */
    private DrawerLayout f14106m;

    /* renamed from: n */
    private MenuItemOnActionExpandListenerC2976a f14107n;

    /* renamed from: o */
    private C2981b f14108o;

    /* renamed from: p */
    private ImageView f14109p;

    /* renamed from: r */
    private String[] f14111r;

    /* renamed from: s */
    private DialogInterfaceC0070b f14112s;

    /* renamed from: t */
    private DialogInterfaceC0070b f14113t;

    /* renamed from: k */
    private boolean f14104k = false;

    /* renamed from: q */
    private long f14110q = 0;

    /* renamed from: u */
    private final BroadcastReceiver f14114u = new C275731(this);

    /* renamed from: v */
    private final BroadcastReceiver f14115v = new C275832(this);

    @Override // androidx.drawerlayout.widget.DrawerLayout.InterfaceC0353c
    /* renamed from: a */
    public void mo2587a(int i) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.InterfaceC0353c
    /* renamed from: a */
    public void mo2588a(View view, float f2) {
    }

    /* renamed from: o */
    public static MainActivity m16615o() {
        return f14103j;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        if (Build.VERSION.SDK_INT < 17) {
            return !f14101h;
        }
        return super.isDestroyed();
    }

    /* renamed from: p */
    public boolean m16634p() {
        return !f14102i;
    }

    /* renamed from: q */
    public boolean m16635q() {
        boolean z = true;
        if (!this.f14106m.m2579g(3)) {
            this.f14106m.m2576e(3);
            return true;
        }
        try {
            int m17828e = this.f14108o.m17828e();
            if (this.f14108o.m17826au() > 1) {
                m16631c(m17828e);
            } else {
                z = this.f14108o.m17827av().m18064d(m17828e).m18037h().m17958j();
            }
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public void m16621a(DialogInterfaceC0070b dialogInterfaceC0070b) {
        if (this.f14112s != null && !this.f14112s.equals(dialogInterfaceC0070b)) {
            this.f14112s.dismiss();
            this.f14112s = (DialogInterfaceC0070b) null;
        }
        this.f14112s = dialogInterfaceC0070b;
    }

    /* renamed from: b */
    public void m16630b(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f14113t = dialogInterfaceC0070b;
    }

    /* renamed from: a */
    public void m16629a(boolean z) {
        this.f14104k = z;
    }

    /* renamed from: r */
    public boolean m16636r() {
        if (!this.f14106m.m2579g(3)) {
            return false;
        }
        this.f14106m.m2577f(3);
        return true;
    }

    /* renamed from: s */
    public void m16637s() {
        try {
            this.f14108o.m17827av().m18068f();
        } catch (Exception e2) {
        }
    }

    /* renamed from: t */
    public File[] m16638t() {
        try {
            return C3080al.m18571a(this.f14108o.m17827av().m18064d(0).m18037h().mo17960l(), this.f14108o.m17827av().m18064d(1).m18037h().mo17960l());
        } catch (Exception e2) {
            return (File[]) null;
        }
    }

    /* renamed from: a */
    public void m16622a(File file) {
        m16623a(file, (File) null);
    }

    /* renamed from: a */
    public void m16623a(File file, File file2) {
        try {
            int m17828e = this.f14108o.m17828e();
            if (m17828e > 1) {
                m17828e = 0;
            }
            m16631c(m17828e);
            C2991j m18037h = this.f14108o.m17827av().m18064d(m17828e).m18037h();
            m18037h.mo17934a(file);
            if (file2 != null && !file2.isDirectory()) {
                m18037h.mo17937a(file2);
            }
        } catch (Exception e2) {
            C3112bn.m19023b(this, getString(R.string.failed_open, file.getAbsolutePath()));
        }
    }

    /* renamed from: u */
    public File m16639u() {
        int i;
        try {
            if (this.f14108o.m17828e() > 0) {
                i = 0;
            } else {
                i = 1;
            }
            return new File(this.f14108o.m17827av().m18064d(i).m18040k());
        } catch (Exception e2) {
            return (File) null;
        }
    }

    /* renamed from: a */
    public void m16627a(String str, File[] fileArr, String str2, boolean z, boolean z2, int i, boolean z3) {
        try {
            int m17828e = this.f14108o.m17828e();
            if (m17828e > 1) {
                m17828e = 0;
            }
            this.f14108o.m17827av().m18064d(m17828e).m18022a(str, fileArr, str2, z, z2, i, z3);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public void m16624a(File file, boolean z) {
        m16625a(file, z, 0);
    }

    /* renamed from: a */
    public void m16625a(File file, boolean z, int i) {
        try {
            this.f14108o.m17823a(file, z, i);
        } catch (Exception e2) {
            C3112bn.m19023b(this, getString(R.string.failed_open, file.getAbsolutePath()));
        }
    }

    /* renamed from: c */
    public void m16631c(int i) {
        this.f14108o.m17820a(i);
        if (this.f14106m.m2579g(3)) {
            return;
        }
        this.f14106m.m2576e(3);
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        int m19470a;
        super.onCreate(bundle);
        setContentView(R.layout.main);
        f14103j = this;
        f14102i = true;
        IntentFilter intentFilter = new IntentFilter("ru.maximoff.apktool.ACTION_FILTER");
        intentFilter.setPriority(1000);
        registerReceiver(this.f14114u, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("ru.maximoff.apktool.WEBDAV_STARTED");
        intentFilter2.setPriority(1000);
        registerReceiver(this.f14115v, intentFilter2);
        this.f14106m = (DrawerLayout) findViewById(R.id.drawer);
        this.f14106m.m2558a(this);
        View inflate = getLayoutInflater().inflate(R.layout.title, (ViewGroup) null);
        m454f().mo387a(16);
        m454f().mo389a(inflate);
        Toolbar toolbar = (Toolbar) inflate.getParent();
        toolbar.setPadding(0, 0, 0, 0);
        toolbar.m1136b(0, 0);
        this.f14109p = (ImageView) findViewById(R.id.titleOpenDrawer);
        if (C3102bd.f18291a) {
            this.f14109p.setImageResource(R.drawable.ic_menu_light);
        } else {
            this.f14109p.setImageResource(R.drawable.ic_menu_dark);
        }
        this.f14109p.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.1

            /* renamed from: a */
            private final MainActivity f14116a;

            {
                this.f14116a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f14116a.f14106m.m2579g(3)) {
                    this.f14116a.f14106m.m2577f(3);
                } else {
                    this.f14116a.f14106m.m2576e(3);
                }
            }
        });
        this.f14109p.setOnLongClickListener(new ViewOnLongClickListenerC27442(this));
        switch (C3102bd.f18319b) {
            case 1:
                m19470a = C3246h.m19470a(this, R.color.drawerScrimDark);
                break;
            case 2:
                m19470a = C3246h.m19470a(this, R.color.drawerScrimBlack);
                break;
            default:
                m19470a = C3246h.m19470a(this, R.color.drawerScrim);
                break;
        }
        this.f14106m.setScrimColor(m19470a);
        m16608a(m2899m());
        m16606H();
        m16603E();
    }

    /* renamed from: ru.maximoff.apktool.MainActivity$2 */
    class ViewOnLongClickListenerC27442 implements View.OnLongClickListener {

        /* renamed from: a */
        private final MainActivity f14134a;

        ViewOnLongClickListenerC27442(MainActivity mainActivity) {
            this.f14134a = mainActivity;
        }

        /* renamed from: a */
        static MainActivity m16645a(ViewOnLongClickListenerC27442 viewOnLongClickListenerC27442) {
            return viewOnLongClickListenerC27442.f14134a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            new C3078aj(this.f14134a).m18494a(R.string.reset_files).m18500b(R.string.mreset_app_files).m18495a(R.string.search_reset, new Runnable(this) { // from class: ru.maximoff.apktool.MainActivity.2.1

                /* renamed from: a */
                private final ViewOnLongClickListenerC27442 f14135a;

                {
                    this.f14135a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3102bd.m18913a((Activity) ViewOnLongClickListenerC27442.m16645a(this.f14135a));
                    ViewOnLongClickListenerC27442.m16645a(this.f14135a).m16644z();
                }
            }).m18508e(R.string.cancel).m18507d();
            return true;
        }
    }

    /* renamed from: E */
    private void m16603E() {
        int m19470a;
        Drawable drawable;
        if (C3102bd.f18310ar && this.f14105l == null) {
            switch (C3102bd.f18319b) {
                case 1:
                    m19470a = C3246h.m19470a(this, R.color.primary_material);
                    drawable = getResources().getDrawable(R.drawable.ic_left_dark);
                    break;
                case 2:
                    m19470a = C3246h.m19470a(this, R.color.primary_material_black);
                    drawable = getResources().getDrawable(R.drawable.ic_left_dark);
                    break;
                default:
                    m19470a = C3246h.m19470a(this, R.color.primary_material_light);
                    drawable = getResources().getDrawable(R.drawable.ic_left);
                    break;
            }
            String m18910a = C3102bd.m18910a(this, "floating_button_position", (String) null);
            float f2 = getResources().getDisplayMetrics().density;
            int dimension = (int) (getResources().getDimension(R.dimen.bottom_bar_size) / f2);
            C3303e.a m19859a = new C3303e.a(this).m19863c((int) (getResources().getDimension(R.dimen.fab_size) / f2)).m19861b(m19470a).m19859a(drawable);
            if (m18910a != null && m18910a.matches("^\\d+;\\d+$")) {
                String[] split = m18910a.split(";");
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                m19859a.m19857a(51);
                m19859a.m19862b(parseInt, parseInt2, 0, 0);
            } else {
                m19859a.m19857a(85);
                m19859a.m19858a(0, 0, 10, dimension + 10);
            }
            this.f14105l = m19859a.m19860a();
            this.f14105l.setMovingInterface(new C3303e.b(this) { // from class: ru.maximoff.apktool.MainActivity.3

                /* renamed from: a */
                private final MainActivity f14154a;

                {
                    this.f14154a = this;
                }

                @Override // ru.maximoff.apktool.view.C3303e.b
                /* renamed from: a */
                public void mo16646a(int i, int i2) {
                    C3102bd.m18937b(this.f14154a, "floating_button_position", new StringBuffer().append(new StringBuffer().append(i).append(";").toString()).append(i2).toString());
                }
            });
            this.f14105l.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.4

                /* renamed from: a */
                private final MainActivity f14176a;

                {
                    this.f14176a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f14176a.f14106m.m2579g(3)) {
                        this.f14176a.f14106m.m2577f(3);
                    } else {
                        this.f14176a.f14106m.m2576e(3);
                    }
                }
            });
            this.f14105l.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.5

                /* renamed from: a */
                private final MainActivity f14177a;

                {
                    this.f14177a = this;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    ((C3303e) view).setMovingMode(true);
                    return true;
                }
            });
        }
    }

    /* renamed from: v */
    public void m16640v() {
        if (C3102bd.m18925a((Context) this, "auto_update", true)) {
            try {
                if (System.currentTimeMillis() - C3102bd.m18906a((Context) this, "update_last_time", 0L) >= C3102bd.m18905a((Context) this, "update_freq", 1) * 86400000) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, getPackageManager().getPackageInfo(getPackageName(), 0).versionCode) { // from class: ru.maximoff.apktool.MainActivity.6

                        /* renamed from: a */
                        private final MainActivity f14178a;

                        /* renamed from: b */
                        private final int f14179b;

                        {
                            this.f14178a = this;
                            this.f14179b = r2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                new AsyncTaskC3245c(this.f14178a, this.f14179b, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            } catch (Exception e2) {
                            }
                        }
                    }, 100L);
                }
            } catch (Exception e2) {
            }
        }
        try {
            C3102bd.m18917a((Context) this, false);
        } catch (Exception e3) {
        }
        if ((C3102bd.f18268D.equals("arm64-v8a") || C3102bd.f18268D.equals("x86-64")) && C3102bd.m18925a((Context) this, "load_aapts_dialog", true) && (!C3102bd.f18321d.endsWith("_usr") || !C3102bd.f18278N.endsWith("_usr") || !C3102bd.f18321d.endsWith("_64") || !C3102bd.f18278N.endsWith("_64"))) {
            C3102bd.m18918a(this, true, C3102bd.f18268D, R.string.load_binaries, new boolean[]{true, true});
        }
        if (Build.VERSION.SDK_INT >= 30 && !C3080al.m18593d()) {
            C3080al.m18544a((Activity) this);
        }
        if (C3102bd.m18925a((Context) this, "dont_kill_my_app", false) && C3102bd.m18925a((Context) this, "app_killed_dialog", true)) {
            m16641w();
        }
        if (C3085aq.m18667a() && !C3085aq.m18669c()) {
            m16642x();
        }
        if (!C3080al.m18594d(this)) {
            C3102bd.m18918a(this, false, C3102bd.f18268D, R.string.load_binaries2, new boolean[]{true, true});
        }
        Intent intent = getIntent();
        if (intent.hasExtra("start_tab")) {
            m16631c(intent.getIntExtra("start_tab", 0));
        }
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                new C3103be(this).m18955a();
            } catch (Exception e4) {
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.MainActivity.7

            /* renamed from: a */
            private final MainActivity f14180a;

            {
                this.f14180a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3212b c3212b = new C3212b(this.f14180a, "editor_tabs", "");
                List<String> m19205b = c3212b.m19205b();
                c3212b.m19208d();
                this.f14180a.m16628a(m19205b, 0);
            }
        }, 300L);
    }

    /* renamed from: a */
    public void m16628a(List<String> list, int i) {
        if (i >= list.size() || !C3102bd.m18925a((Context) this, "editor_rem_tabs", false)) {
            return;
        }
        String str = list.get(i);
        try {
            if (Character.isDigit(str.charAt(0))) {
                String[] split = str.split("\\|", 3);
                m16625a(new File(split[2]), Boolean.valueOf(split[1]).booleanValue(), Integer.parseInt(split[0]));
            } else {
                String[] split2 = str.split("\\|", 2);
                m16624a(new File(split2[1]), Boolean.valueOf(split2[0]).booleanValue());
            }
        } catch (Exception e2) {
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, list, i) { // from class: ru.maximoff.apktool.MainActivity.8

            /* renamed from: a */
            private final MainActivity f14181a;

            /* renamed from: b */
            private final List f14182b;

            /* renamed from: c */
            private final int f14183c;

            {
                this.f14181a = this;
                this.f14182b = list;
                this.f14183c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14181a.m16628a(this.f14182b, this.f14183c + 1);
            }
        }, 100L);
    }

    /* renamed from: w */
    public void m16641w() {
        View inflate = getLayoutInflater().inflate(R.layout.alert, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.alertTextView1);
        SpannableString spannableString = new SpannableString(getText(R.string.app_is_killed));
        Linkify.addLinks(spannableString, 1);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        new DialogInterfaceC0070b.a(this).m418a(R.string.attention).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m434b(R.string.not_remind, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.9

            /* renamed from: a */
            private final MainActivity f14184a;

            {
                this.f14184a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18938b((Context) this.f14184a, "app_killed_dialog", false);
                dialogInterface.cancel();
            }
        }).m438b().show();
        C3102bd.m18938b((Context) this, "dont_kill_my_app", false);
    }

    /* renamed from: x */
    public void m16642x() {
        if (!C3102bd.m18925a((Context) this, "show_miui_dialog", true)) {
            return;
        }
        new DialogInterfaceC0070b.a(this).m418a(R.string.miui_warn_title).m433b(R.string.miui_warn_message).m420a(R.string.settings, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.10

            /* renamed from: a */
            private final MainActivity f14117a;

            {
                this.f14117a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3085aq.m18666a(this.f14117a);
                dialogInterface.cancel();
            }
        }).m434b(R.string.close_cur, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.11

            /* renamed from: a */
            private final MainActivity f14118a;

            {
                this.f14118a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).m440c(R.string.not_remind, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.12

            /* renamed from: a */
            private final MainActivity f14119a;

            {
                this.f14119a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18938b((Context) this.f14119a, "show_miui_dialog", false);
                dialogInterface.cancel();
            }
        }).m429a(false).m438b().show();
    }

    /* renamed from: F */
    private void m16604F() {
        C3056b c3056b = new C3056b(this);
        c3056b.m18200b(PointerIcon.TYPE_NO_DROP);
        c3056b.m18200b(PointerIcon.TYPE_COPY);
        c3056b.m18200b(PointerIcon.TYPE_ALIAS);
        c3056b.m18200b(5017);
    }

    @Override // androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onDestroy() {
        f14102i = false;
        this.f14104k = false;
        unregisterReceiver(this.f14114u);
        unregisterReceiver(this.f14115v);
        C3082an.f18011a.m18647a();
        C3080al.m18610l(this);
        C3080al.m18611m(this);
        C3080al.m18612n(this);
        if (this.f14113t != null) {
            this.f14113t.dismiss();
            this.f14113t = (DialogInterfaceC0070b) null;
        }
        if (this.f14112s != null) {
            this.f14112s.dismiss();
            this.f14112s = (DialogInterfaceC0070b) null;
        }
        m16604F();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onStart() {
        f14101h = true;
        super.onStart();
    }

    @Override // androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onStop() {
        f14101h = false;
        super.onStop();
    }

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i2 == -1) {
            switch (i) {
                case PointerIcon.TYPE_NO_DROP /* 1012 */:
                    Uri data = intent.getData();
                    grantUriPermission(getPackageName(), data, 3);
                    getContentResolver().takePersistableUriPermission(data, 3);
                    new C3078aj(this).m18496a(data.getLastPathSegment()).m18507d();
                    C3112bn.m18999a(this, R.string.complete);
                    break;
                case PointerIcon.TYPE_ALL_SCROLL /* 1013 */:
                    this.f14111r = intent.getStringArrayExtra("preview_selection");
                    break;
            }
        }
    }

    /* renamed from: c */
    public void m16632c(Intent intent) {
        String stringExtra = intent.getStringExtra("apk_name");
        String stringExtra2 = intent.getStringExtra("apk_path");
        if (stringExtra != null && stringExtra2 != null) {
            File file = new File(stringExtra2);
            if (!file.isFile()) {
                C3112bn.m18999a(this, R.string.error);
                return;
            }
            intent.removeExtra("apk_name");
            intent.removeExtra("apk_path");
            C3080al.m18551a(this, file, (PackageInfo) null, (PackageManager) null);
        }
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onNewIntent(Intent intent) {
        boolean z;
        InputStream fileInputStream;
        InputStream fileInputStream2;
        boolean z2;
        if (intent.hasExtra("start_tab")) {
            m16631c(intent.getIntExtra("start_tab", 0));
            intent.removeExtra("start_tab");
        }
        String action = intent.getAction();
        if (action != null && action.equals("ru.maximoff.apktool.OPEN_APK")) {
            m16632c(intent);
            intent.setData((Uri) null);
            return;
        }
        Uri data = intent.getData();
        if (action == null || data == null || (!action.equals("android.intent.action.VIEW") && !action.equals(Intent.ACTION_EDIT))) {
            intent.setData((Uri) null);
            return;
        }
        String m19565a = C3262u.m19565a(this, data);
        if (m19565a == null) {
            intent.setData((Uri) null);
            return;
        }
        if (m19565a.toLowerCase().endsWith(".apkm")) {
            try {
                z = C3262u.m19648c(getContentResolver().openInputStream(data));
            } catch (Exception e2) {
                z = false;
            }
        } else {
            z = false;
        }
        if (m19565a.toLowerCase().endsWith(".apks") || m19565a.toLowerCase().endsWith(".xapk") || z) {
            try {
                File createTempFile = File.createTempFile("AM_TempSplit", ".tmp", C3102bd.m18908a());
                if (data.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
                    fileInputStream = getContentResolver().openInputStream(data);
                } else {
                    fileInputStream = new FileInputStream(new File(data.getPath()));
                }
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                C1887e.m13962a(fileInputStream, fileOutputStream);
                fileInputStream.close();
                fileOutputStream.close();
                int m18905a = C3102bd.m18905a((Context) this, "open_apks_option", 0);
                if (m18905a < 0 || m18905a > 2) {
                    m18905a = 0;
                }
                int[] iArr = {m18905a};
                String[] strArr = {getString(R.string.mantisplit)};
                if (Build.VERSION.SDK_INT >= 21) {
                    strArr = new String[]{getString(R.string.mantisplit), getString(R.string.install), getString(R.string.install_sign)};
                }
                DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this);
                aVar.m427a(m19565a);
                aVar.m430a(strArr, iArr[0], new DialogInterface.OnClickListener(this, iArr) { // from class: ru.maximoff.apktool.MainActivity.13

                    /* renamed from: a */
                    private final MainActivity f14120a;

                    /* renamed from: b */
                    private final int[] f14121b;

                    {
                        this.f14120a = this;
                        this.f14121b = iArr;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f14121b[0] = i;
                    }
                });
                aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, iArr, createTempFile, data) { // from class: ru.maximoff.apktool.MainActivity.14

                    /* renamed from: a */
                    private final MainActivity f14122a;

                    /* renamed from: b */
                    private final int[] f14123b;

                    /* renamed from: c */
                    private final File f14124c;

                    /* renamed from: d */
                    private final Uri f14125d;

                    {
                        this.f14122a = this;
                        this.f14123b = iArr;
                        this.f14124c = createTempFile;
                        this.f14125d = data;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        C3102bd.m18935b((Context) this.f14122a, "open_apks_option", this.f14123b[0]);
                        C3262u.m19584a((Context) this.f14122a, this.f14124c, this.f14125d.getLastPathSegment(), (InterfaceC2995n) this.f14122a.f14108o.m17827av().m18064d(0).m18037h(), this.f14123b[0], false, false, true);
                    }
                });
                aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(this, createTempFile) { // from class: ru.maximoff.apktool.MainActivity.15

                    /* renamed from: a */
                    private final MainActivity f14126a;

                    /* renamed from: b */
                    private final File f14127b;

                    {
                        this.f14126a = this;
                        this.f14127b = createTempFile;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        this.f14127b.delete();
                    }
                });
                aVar.m422a(new DialogInterface.OnKeyListener(this, createTempFile) { // from class: ru.maximoff.apktool.MainActivity.16

                    /* renamed from: a */
                    private final MainActivity f14128a;

                    /* renamed from: b */
                    private final File f14129b;

                    {
                        this.f14128a = this;
                        this.f14129b = createTempFile;
                    }

                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                            return false;
                        }
                        this.f14129b.delete();
                        dialogInterface.cancel();
                        return true;
                    }
                });
                aVar.m429a(false);
                aVar.m438b().show();
            } catch (Exception e3) {
                C3112bn.m19023b(this, getString(R.string.failed_open, data.toString()));
            }
        } else if (m19565a.toLowerCase().endsWith(".apkm")) {
            try {
                if (!C3262u.m19616a(new StringBuffer().append(getPackageName()).append(".unapkm").toString(), getPackageManager())) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        DialogInterfaceC0070b.a aVar2 = new DialogInterfaceC0070b.a(this);
                        aVar2.m433b(R.string.mapp_down_plugin);
                        aVar2.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                        aVar2.m420a(R.string.mplugin_down, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.17

                            /* renamed from: a */
                            private final MainActivity f14130a;

                            {
                                this.f14130a = this;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C3080al.m18595e(this.f14130a, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/UnApkm.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                            }
                        });
                        aVar2.m422a(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.MainActivity.18

                            /* renamed from: a */
                            private final MainActivity f14131a;

                            {
                                this.f14131a = this;
                            }

                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                    return false;
                                }
                                dialogInterface.cancel();
                                return true;
                            }
                        });
                        aVar2.m429a(false);
                        aVar2.m438b().show();
                        intent.setData((Uri) null);
                        return;
                    }
                    C3112bn.m18999a(this, R.string.unsupported_android);
                    return;
                }
                File createTempFile2 = File.createTempFile("AM_TempApkm", ".tmp", C3102bd.m18908a());
                if (data.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
                    fileInputStream2 = getContentResolver().openInputStream(data);
                } else {
                    fileInputStream2 = new FileInputStream(new File(data.getPath()));
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile2);
                C1887e.m13962a(fileInputStream2, fileOutputStream2);
                fileInputStream2.close();
                fileOutputStream2.close();
                AsyncTaskC2923ay asyncTaskC2923ay = new AsyncTaskC2923ay(this, data.getLastPathSegment(), true);
                if (!C3102bd.m18925a((Context) this, "plugin_mod_nrm", false) && !C3080al.m18590c((Context) this, true)) {
                    DialogInterfaceC0070b.a aVar3 = new DialogInterfaceC0070b.a(this);
                    aVar3.m418a(R.string.attention);
                    aVar3.m433b(R.string.plugin_modif);
                    aVar3.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                    aVar3.m420a(R.string.delete, new DialogInterface.OnClickListener(this, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.19

                        /* renamed from: a */
                        private final MainActivity f14132a;

                        /* renamed from: b */
                        private final File f14133b;

                        {
                            this.f14132a = this;
                            this.f14133b = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            this.f14133b.delete();
                            C3080al.m18601g(this.f14132a, new StringBuffer().append(this.f14132a.getPackageName()).append(".unapkm").toString());
                        }
                    });
                    aVar3.m440c(R.string.not_remind, new DialogInterface.OnClickListener(this, asyncTaskC2923ay, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.20

                        /* renamed from: a */
                        private final MainActivity f14136a;

                        /* renamed from: b */
                        private final AsyncTaskC2923ay f14137b;

                        /* renamed from: c */
                        private final File f14138c;

                        {
                            this.f14136a = this;
                            this.f14137b = asyncTaskC2923ay;
                            this.f14138c = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            C3102bd.m18938b((Context) this.f14136a, "plugin_mod_nrm", true);
                            try {
                                this.f14137b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14138c);
                            } catch (Exception e4) {
                                C3112bn.m18999a(this.f14136a, R.string.error_try_again);
                            }
                        }
                    });
                    aVar3.m422a(new DialogInterface.OnKeyListener(this, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.21

                        /* renamed from: a */
                        private final MainActivity f14139a;

                        /* renamed from: b */
                        private final File f14140b;

                        {
                            this.f14139a = this;
                            this.f14140b = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            this.f14140b.delete();
                            dialogInterface.cancel();
                            return true;
                        }
                    });
                    aVar3.m429a(false);
                    aVar3.m438b().show();
                } else {
                    DialogInterfaceC0070b.a aVar4 = new DialogInterfaceC0070b.a(this);
                    aVar4.m427a(m19565a);
                    aVar4.m436b(new StringBuffer().append(getString(R.string.to_apks)).append("?").toString());
                    aVar4.m434b(R.string.cancel, new DialogInterface.OnClickListener(this, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.22

                        /* renamed from: a */
                        private final MainActivity f14141a;

                        /* renamed from: b */
                        private final File f14142b;

                        {
                            this.f14141a = this;
                            this.f14142b = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            this.f14142b.delete();
                        }
                    });
                    aVar4.m420a(R.string.yes, new DialogInterface.OnClickListener(this, asyncTaskC2923ay, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.23

                        /* renamed from: a */
                        private final MainActivity f14143a;

                        /* renamed from: b */
                        private final AsyncTaskC2923ay f14144b;

                        /* renamed from: c */
                        private final File f14145c;

                        {
                            this.f14143a = this;
                            this.f14144b = asyncTaskC2923ay;
                            this.f14145c = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            try {
                                this.f14144b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14145c);
                            } catch (Exception e4) {
                                C3112bn.m18999a(this.f14143a, R.string.error_try_again);
                            }
                        }
                    });
                    aVar4.m422a(new DialogInterface.OnKeyListener(this, createTempFile2) { // from class: ru.maximoff.apktool.MainActivity.24

                        /* renamed from: a */
                        private final MainActivity f14146a;

                        /* renamed from: b */
                        private final File f14147b;

                        {
                            this.f14146a = this;
                            this.f14147b = createTempFile2;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            this.f14147b.delete();
                            dialogInterface.cancel();
                            return true;
                        }
                    });
                    aVar4.m429a(false);
                    aVar4.m438b().show();
                }
            } catch (Exception e4) {
                C3112bn.m19023b(this, getString(R.string.failed_open, data.toString()));
            }
        } else {
            String[] m19501b = C3249i.m19501b();
            int i = 0;
            while (true) {
                if (i >= m19501b.length) {
                    z2 = false;
                    break;
                } else {
                    if (m19565a.toLowerCase().endsWith(new StringBuffer().append(".").append(m19501b[i]).toString())) {
                        z2 = true;
                        break;
                    }
                    i++;
                }
            }
            if (!z2) {
                String m19571a = C3262u.m19571a(data.toString());
                z2 = m19571a != null && m19571a.startsWith("text/");
            }
            if (z2) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, data) { // from class: ru.maximoff.apktool.MainActivity.25

                    /* renamed from: a */
                    private final MainActivity f14148a;

                    /* renamed from: b */
                    private final Uri f14149b;

                    {
                        this.f14148a = this;
                        this.f14149b = data;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f14148a.f14107n.m17633a(this.f14149b, (File) null);
                        this.f14148a.m16636r();
                    }
                }, 100L);
            } else {
                C3112bn.m19023b(this, getString(R.string.failed_open, data.toString()));
            }
        }
        intent.setData((Uri) null);
    }

    /* renamed from: a */
    private void m16608a(AbstractC0384o abstractC0384o) {
        ComponentCallbacksC0374e m3036c = abstractC0384o.m3036c(R.id.editor);
        ComponentCallbacksC0374e m3036c2 = abstractC0384o.m3036c(R.id.leftView);
        if (m3036c == null || m3036c2 == null) {
            this.f14107n = new MenuItemOnActionExpandListenerC2976a();
            this.f14108o = new C2981b();
            AbstractC0393x m3002a = abstractC0384o.m3002a();
            m3002a.m3166c(4097);
            m3002a.m3162a(R.id.editor, this.f14107n);
            m3002a.m3162a(R.id.leftView, this.f14108o);
            m3002a.mo2648d();
        } else {
            this.f14107n = (MenuItemOnActionExpandListenerC2976a) m3036c;
            this.f14108o = (C2981b) m3036c2;
        }
        this.f14108o.m17824a(this.f14107n);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (!this.f14107n.m17646aC() && !this.f14107n.m17645aB() && !m16635q() && !this.f14107n.m17651ay()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (C3102bd.m18925a((Context) this, "double_exit", true) && currentTimeMillis - this.f14110q > 2000) {
                C3112bn.m18999a(this, R.string.click_once_more);
                this.f14110q = currentTimeMillis;
            } else {
                m16643y();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        File file = new File(getExternalFilesDir((String) null), "Apktool_M.crashlog.txt");
        menu.findItem(R.id.stack).setVisible(file.exists() && file.isFile());
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.exit /* 2131690197 */:
                m16643y();
                return true;
            case R.id.settings /* 2131690290 */:
                try {
                    startActivityForResult(new Intent(this, Class.forName("ru.maximoff.apktool.SettingActivity")), 0);
                    return true;
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            case R.id.converter /* 2131690291 */:
                try {
                    startActivityForResult(new Intent(this, Class.forName("ru.maximoff.apktool.Converter")), 0);
                    return true;
                } catch (ClassNotFoundException e3) {
                    throw new NoClassDefFoundError(e3.getMessage());
                }
            case R.id.stack /* 2131690292 */:
                try {
                    startActivityForResult(new Intent(this, Class.forName("ru.maximoff.apktool.CrashActivity")), 0);
                    return true;
                } catch (ClassNotFoundException e4) {
                    throw new NoClassDefFoundError(e4.getMessage());
                }
            default:
                return false;
        }
    }

    /* renamed from: y */
    public void m16643y() {
        if (this.f14104k) {
            new DialogInterfaceC0070b.a(this).m418a(R.string.attention).m433b(R.string.bg_proccess_notice).m420a(R.string.yes, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.26

                /* renamed from: a */
                private final MainActivity f14150a;

                {
                    this.f14150a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f14150a.m16629a(false);
                    this.f14150a.m16643y();
                }
            }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
        } else if (this.f14107n.m17650ax()) {
            m16605G();
        } else {
            finish();
        }
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onResume() {
        super.onResume();
        m16603E();
        m16644z();
        if (C3102bd.m18925a((Context) this, "drawer_fixed", false)) {
            if (C3102bd.f18311as) {
                this.f14106m.m2553a(2, 3);
            } else {
                this.f14106m.m2553a(1, 3);
            }
        } else {
            this.f14106m.m2553a(0, 3);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.MainActivity.27

                /* renamed from: a */
                private final MainActivity f14151a;

                {
                    this.f14151a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f14151a.m16619D();
                }
            }, 100L);
        }
        if (C3102bd.f18310ar && this.f14105l != null) {
            if (this.f14106m.m2579g(3)) {
                this.f14105l.m19855d();
            } else {
                this.f14105l.m19854c();
            }
        }
        onNewIntent(getIntent());
        if (this.f14107n != null) {
            C2978b.f16135a.m17721k();
            this.f14107n.m17653b(this);
        }
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void finish() {
        C2978b.f16135a.m17723l();
        if (C3102bd.m18925a((Context) this, "force_exit", false)) {
            if (Build.VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            Process.killProcess(Process.myPid());
            System.runFinalizersOnExit(true);
            System.exit(0);
            return;
        }
        super.finish();
    }

    /* renamed from: z */
    public void m16644z() {
        m16633d(3);
    }

    /* renamed from: d */
    public void m16633d(int i) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.MainActivity.28

            /* renamed from: a */
            private final MainActivity f14152a;

            {
                this.f14152a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                C2993l m17827av;
                if (this.f14152a.f14108o == null || (m17827av = this.f14152a.f14108o.m17827av()) == null) {
                    return;
                }
                m17827av.m18066e();
                m17827av.m18058a(this.f14152a.f14108o.m17828e(), this.f14152a.f14111r);
                this.f14152a.f14111r = (String[]) null;
            }
        }, 100 * i);
    }

    /* renamed from: A */
    public C2981b m16616A() {
        return this.f14108o;
    }

    /* renamed from: B */
    public MenuItemOnActionExpandListenerC2976a m16617B() {
        return this.f14107n;
    }

    /* renamed from: C */
    public String m16618C() {
        C2993l m17827av;
        return (this.f14108o == null || (m17827av = this.f14108o.m17827av()) == null) ? (String) null : m17827av.m18063c(this.f14108o.m17828e());
    }

    /* renamed from: a */
    public String m16620a(String str) {
        C2993l m17827av;
        if (str == null) {
            return m16618C();
        }
        if (this.f14108o != null && (m17827av = this.f14108o.m17827av()) != null) {
            return m17827av.m18057a(this.f14108o.m17828e(), str);
        }
        return (String) null;
    }

    /* renamed from: a */
    public void m16626a(String str, String str2) {
        C2993l m17827av;
        if (this.f14108o != null && (m17827av = this.f14108o.m17827av()) != null) {
            m17827av.m18062a(str, str2, this.f14108o.m17828e());
        } else {
            C3112bn.m18999a(this, R.string.error);
        }
    }

    /* renamed from: G */
    private void m16605G() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.29

            /* renamed from: a */
            private final MainActivity f14153a;

            {
                this.f14153a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i != -3) {
                    if (i == -1) {
                        this.f14153a.f14107n.m17643a(true, false);
                    }
                    if (i == -2) {
                        this.f14153a.f14107n.m17664m(false);
                    }
                    this.f14153a.finish();
                }
            }
        };
        new DialogInterfaceC0070b.a(this).m418a(R.string.save_file).m433b(R.string.save_file_msg).m420a(R.string.yes, onClickListener).m434b(R.string.f21469no, onClickListener).m440c(R.string.cancel, onClickListener).m438b().show();
    }

    /* renamed from: D */
    public void m16619D() {
        if (C3102bd.f18311as) {
            if (!this.f14106m.m2579g(3)) {
                this.f14106m.m2576e(3);
            }
        } else if (this.f14106m.m2579g(3)) {
            this.f14106m.m2577f(3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m16606H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m16606H() {
        int i;
        View findViewById = this.f14106m.findViewById(R.id.leftView);
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (C3102bd.m18925a((Context) this, "drawer_full", false)) {
            i = i2;
        } else {
            int m18905a = C3102bd.m18905a((Context) this, "drawer_width", 80);
            if (m18905a < 50 || m18905a > 100) {
                m18905a = 80;
            }
            i = Math.round(m18905a * (i2 / 100.0f));
        }
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = i;
        findViewById.setLayoutParams(layoutParams);
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.MainActivity.30

            /* renamed from: a */
            private final MainActivity f14155a;

            {
                this.f14155a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14155a.m16606H();
                if (this.f14155a.f14105l != null) {
                    this.f14155a.f14105l.m19853b();
                }
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.InterfaceC0353c
    public void onDrawerOpened(View view) {
        this.f14108o.m17819a();
        C3102bd.f18311as = true;
        this.f14109p.setContentDescription(getString(R.string.close_files));
        this.f14106m.requestDisallowInterceptTouchEvent(false);
        if (C3102bd.f18310ar && this.f14105l != null) {
            this.f14105l.m19855d();
        }
        if (this.f14112s != null) {
            this.f14112s.show();
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.InterfaceC0353c
    public void onDrawerClosed(View view) {
        this.f14107n.m17647au();
        C3102bd.f18311as = false;
        this.f14109p.setContentDescription(getString(R.string.open_files));
        this.f14106m.requestDisallowInterceptTouchEvent(true);
        if (!C3102bd.f18310ar || this.f14105l == null) {
            return;
        }
        this.f14105l.m19854c();
    }

    /* renamed from: ru.maximoff.apktool.MainActivity$31 */
    class C275731 extends BroadcastReceiver {

        /* renamed from: a */
        private final MainActivity f14156a;

        C275731(MainActivity mainActivity) {
            this.f14156a = mainActivity;
        }

        /* renamed from: a */
        static MainActivity m16647a(C275731 c275731) {
            return c275731.f14156a;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringBuffer;
            int i;
            int i2;
            if (!this.f14156a.isFinishing() && !this.f14156a.isDestroyed() && !this.f14156a.m16634p()) {
                new C3056b(this.f14156a).m18200b(PointerIcon.TYPE_ALIAS);
                String stringExtra = intent.getStringExtra("saiPackageName");
                boolean booleanExtra = intent.getBooleanExtra("saiSuccess", false);
                int intExtra = intent.getIntExtra("saiStatus", -12345);
                String stringExtra2 = intent.getStringExtra("saiMessage");
                if (booleanExtra) {
                    stringBuffer = this.f14156a.getString(R.string.install_success);
                    i = R.string.launch_app;
                    i2 = R.string.success;
                } else {
                    stringBuffer = new StringBuffer().append(new StringBuffer().append(this.f14156a.getString(R.string.install_fail, new Integer(intExtra))).append("\n").toString()).append(stringExtra2).toString();
                    i = R.string.close_cur;
                    i2 = R.string.error;
                }
                abortBroadcast();
                if (MainActivity.f14101h) {
                    DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f14156a).m418a(i2).m436b(stringBuffer).m420a(i, new DialogInterface.OnClickListener(this, booleanExtra, stringExtra) { // from class: ru.maximoff.apktool.MainActivity.31.1

                        /* renamed from: a */
                        private final C275731 f14157a;

                        /* renamed from: b */
                        private final boolean f14158b;

                        /* renamed from: c */
                        private final String f14159c;

                        {
                            this.f14157a = this;
                            this.f14158b = booleanExtra;
                            this.f14159c = stringExtra;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (this.f14158b) {
                                if (this.f14159c != null) {
                                    C3080al.m18599f(C275731.m16647a(this.f14157a), this.f14159c);
                                } else {
                                    C3112bn.m18999a(C275731.m16647a(this.f14157a), R.string.error);
                                }
                            }
                            dialogInterface.cancel();
                        }
                    });
                    if (booleanExtra) {
                        m420a.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                    } else {
                        m420a.m440c(R.string.copy, (DialogInterface.OnClickListener) null);
                    }
                    DialogInterfaceC0070b m438b = m420a.m438b();
                    m438b.setOnShowListener(new AnonymousClass2(this, booleanExtra, m438b, stringBuffer));
                    m438b.show();
                    this.f14156a.m16644z();
                }
            }
        }

        /* renamed from: ru.maximoff.apktool.MainActivity$31$2, reason: invalid class name */
        class AnonymousClass2 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final C275731 f14160a;

            /* renamed from: b */
            private final boolean f14161b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f14162c;

            /* renamed from: d */
            private final String f14163d;

            AnonymousClass2(C275731 c275731, boolean z, DialogInterfaceC0070b dialogInterfaceC0070b, String str) {
                this.f14160a = c275731;
                this.f14161b = z;
                this.f14162c = dialogInterfaceC0070b;
                this.f14163d = str;
            }

            /* renamed from: a */
            static C275731 m16648a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f14160a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (this.f14161b) {
                    return;
                }
                this.f14162c.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f14163d) { // from class: ru.maximoff.apktool.MainActivity.31.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f14164a;

                    /* renamed from: b */
                    private final String f14165b;

                    {
                        this.f14164a = this;
                        this.f14165b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3112bn.m19002a(C275731.m16647a(AnonymousClass2.m16648a(this.f14164a)), this.f14165b);
                    }
                });
                TextView textView = (TextView) this.f14162c.findViewById(C0012R.id.message);
                if (textView != null) {
                    textView.setTextIsSelectable(true);
                }
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.MainActivity$32 */
    class C275832 extends BroadcastReceiver {

        /* renamed from: a */
        private final MainActivity f14166a;

        C275832(MainActivity mainActivity) {
            this.f14166a = mainActivity;
        }

        /* renamed from: a */
        static MainActivity m16649a(C275832 c275832) {
            return c275832.f14166a;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int m19470a;
            String stringExtra = intent.getStringExtra(TextClassifier.TYPE_URL);
            String stringExtra2 = intent.getStringExtra("path");
            if (stringExtra != null && stringExtra2 != null && MainActivity.f14101h) {
                if (C3102bd.f18291a) {
                    m19470a = C3246h.m19470a(this.f14166a, R.color.accent_material_light);
                } else {
                    m19470a = C3246h.m19470a(this.f14166a, R.color.accent_material);
                }
                String string = this.f14166a.getString(R.string.server_running_f, stringExtra);
                SpannableString spannableString = new SpannableString(string);
                int indexOf = string.indexOf(stringExtra);
                spannableString.setSpan(new ClickableSpan(this, stringExtra, m19470a) { // from class: ru.maximoff.apktool.MainActivity.32.1

                    /* renamed from: a */
                    private final C275832 f14167a;

                    /* renamed from: b */
                    private final String f14168b;

                    /* renamed from: c */
                    private final int f14169c;

                    {
                        this.f14167a = this;
                        this.f14168b = stringExtra;
                        this.f14169c = m19470a;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        C3080al.m18595e(C275832.m16649a(this.f14167a), this.f14168b);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(this.f14169c);
                        textPaint.setUnderlineText(true);
                    }
                }, indexOf, stringExtra.length() + indexOf, 33);
                Bitmap m18735a = C3091aw.m18735a(stringExtra, 600);
                View inflate = this.f14166a.getLayoutInflater().inflate(R.layout.server_dialog, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.serverdialogImageView1)).setImageBitmap(m18735a);
                TextView textView = (TextView) inflate.findViewById(R.id.serverdialogTextView1);
                textView.setText(spannableString);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                ((TextView) inflate.findViewById(R.id.serverdialogTextView2)).setText(context.getString(R.string.pathf, stringExtra2));
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f14166a).m418a(R.string.server_label).m435b(inflate).m429a(false).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m434b(R.string.stop, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.MainActivity.32.2

                    /* renamed from: a */
                    private final C275832 f14170a;

                    {
                        this.f14170a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        try {
                            Intent intent2 = new Intent(C275832.m16649a(this.f14170a), Class.forName("ru.maximoff.apktool.service.LocalFileServerService"));
                            intent2.setAction(LocalFileServerService.f17112b);
                            if (Build.VERSION.SDK_INT >= 26) {
                                C275832.m16649a(this.f14170a).startForegroundService(intent2);
                            } else {
                                C275832.m16649a(this.f14170a).startService(intent2);
                            }
                        } catch (ClassNotFoundException e2) {
                            throw new NoClassDefFoundError(e2.getMessage());
                        }
                    }
                }).m440c(R.string.copy, (DialogInterface.OnClickListener) null).m438b();
                m438b.setOnShowListener(new AnonymousClass3(this, m438b, stringExtra));
                m438b.show();
            }
        }

        /* renamed from: ru.maximoff.apktool.MainActivity$32$3, reason: invalid class name */
        class AnonymousClass3 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final C275832 f14171a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14172b;

            /* renamed from: c */
            private final String f14173c;

            AnonymousClass3(C275832 c275832, DialogInterfaceC0070b dialogInterfaceC0070b, String str) {
                this.f14171a = c275832;
                this.f14172b = dialogInterfaceC0070b;
                this.f14173c = str;
            }

            /* renamed from: a */
            static C275832 m16650a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f14171a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14172b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f14173c) { // from class: ru.maximoff.apktool.MainActivity.32.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f14174a;

                    /* renamed from: b */
                    private final String f14175b;

                    {
                        this.f14174a = this;
                        this.f14175b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3112bn.m19002a(C275832.m16649a(AnonymousClass3.m16650a(this.f14174a)), this.f14175b);
                    }
                });
                TextView textView = (TextView) this.f14172b.findViewById(C0012R.id.message);
                if (textView != null) {
                    textView.setTextIsSelectable(true);
                }
            }
        }
    }
}
