package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.p008os.AsyncTask;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.view.PointerIcon;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.HashSet;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3109bk;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.sai.C3260a;

/* compiled from: SAITask.java */
/* renamed from: ru.maximoff.apktool.e.ao */
/* loaded from: classes.dex */
public class AsyncTaskC2913ao extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15288a;

    /* renamed from: b */
    private int f15289b;

    /* renamed from: c */
    private InterfaceC2995n f15290c;

    /* renamed from: d */
    private C2917as f15291d;

    /* renamed from: e */
    private C3060a f15292e;

    /* renamed from: f */
    private SpannedString f15293f;

    /* renamed from: g */
    private File[] f15294g;

    /* renamed from: h */
    private File f15295h;

    /* renamed from: i */
    private boolean f15296i;

    /* renamed from: j */
    private boolean f15297j;

    /* renamed from: k */
    private boolean f15298k;

    /* renamed from: l */
    private boolean f15299l;

    /* renamed from: m */
    private boolean f15300m;

    public AsyncTaskC2913ao(Context context, InterfaceC2995n interfaceC2995n, C2917as c2917as, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, interfaceC2995n);
        this.f15288a = context;
        this.f15290c = interfaceC2995n;
        this.f15289b = C3102bd.m18905a(this.f15288a, "inlocation_idx", 1);
        this.f15291d = c2917as;
        this.f15296i = false;
        this.f15297j = z;
        this.f15298k = z2;
        this.f15299l = z3;
        this.f15300m = z4;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.split_install;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        String str;
        int i = 0;
        mo3984d(R.string.mplease_wait, (Object) null);
        this.f15295h = fileArr[0].getParentFile();
        this.f15294g = new File[fileArr.length];
        int i2 = 14;
        String str2 = (String) null;
        int i3 = 0;
        while (true) {
            if (i3 >= fileArr.length) {
                str = str2;
                break;
            }
            this.f15292e = new C3060a(this.f15288a, fileArr[i3]);
            if (!this.f15292e.m18255D()) {
                i3++;
            } else {
                i2 = this.f15292e.m18281s();
                str = this.f15292e.m18276n();
                break;
            }
        }
        if (this.f15297j) {
            mo3984d(R.string.sign_run_title, (Object) null);
            for (int i4 = 0; i4 < fileArr.length; i4++) {
                File m17259a = m17259a(fileArr[i4], fileArr[i4].getName());
                if (!this.f15291d.m17321a(fileArr[i4], m17259a, i2, this)) {
                    return new Boolean(false);
                }
                this.f15294g[i4] = m17259a;
                fileArr[i4].delete();
                if (this.f15292e != null && this.f15292e.m18255D() && fileArr[i4].equals(this.f15292e.m18264b())) {
                    this.f15292e = new C3060a(this.f15288a, m17259a);
                }
            }
        } else {
            for (int i5 = 0; i5 < fileArr.length; i5++) {
                this.f15294g[i5] = fileArr[i5];
            }
        }
        if (C3102bd.m18925a(this.f15288a, "check_install", true) && this.f15292e != null && this.f15292e.m18255D()) {
            HashSet<Long> m18965a = C3105bg.m18965a(this.f15288a, this.f15292e.m18264b());
            if (!this.f15299l && m18965a.isEmpty()) {
                this.f15299l = true;
                this.f15293f = new SpannedString(this.f15288a.getString(R.string.mapk_nosign));
                return new Boolean(false);
            }
            if (C3262u.m19616a(this.f15292e.m18276n(), this.f15292e.m18287y())) {
                if (!this.f15298k) {
                    this.f15298k = true;
                    try {
                        PackageInfo packageInfo = this.f15292e.m18287y().getPackageInfo(this.f15292e.m18276n(), 0);
                        if (!(this.f15292e.m18278p() >= packageInfo.versionCode)) {
                            int m19470a = C3246h.m19470a(this.f15288a, R.color.dark_red);
                            int m19470a2 = C3246h.m19470a(this.f15288a, R.color.dark_green);
                            String stringBuffer = new StringBuffer().append(new StringBuffer().append(this.f15292e.m18277o()).append(", ").toString()).append(this.f15292e.m18278p()).toString();
                            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(C3112bn.m19017b((CharSequence) packageInfo.versionName)).append(", ").toString()).append(packageInfo.versionCode).toString();
                            SpannableString spannableString = new SpannableString(stringBuffer);
                            spannableString.setSpan(new ForegroundColorSpan(m19470a), stringBuffer.lastIndexOf(", ") + 1, stringBuffer.length(), 33);
                            SpannableString spannableString2 = new SpannableString(stringBuffer2);
                            spannableString2.setSpan(new ForegroundColorSpan(m19470a2), stringBuffer2.lastIndexOf(", ") + 1, stringBuffer2.length(), 33);
                            this.f15293f = C3109bk.m18982a(this.f15288a.getString(R.string.mapk_version_low), spannableString, spannableString2);
                            return new Boolean(false);
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                    }
                }
                if (!this.f15300m) {
                    this.f15300m = true;
                    if (!C3105bg.m18968a(m18965a, C3105bg.m18972b(this.f15288a, this.f15292e.m18276n()))) {
                        this.f15293f = new SpannedString(this.f15288a.getString(R.string.mapk_sign_fail));
                        return new Boolean(false);
                    }
                }
            }
        }
        mo3984d(R.string.split_install, (Object) null);
        switch (this.f15289b) {
            case 0:
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            default:
                i = 1;
                break;
        }
        C3260a c3260a = new C3260a(this.f15288a);
        c3260a.m19530a(str);
        c3260a.m19529a(i);
        c3260a.m19528a(this.f15294g);
        return new Boolean(true);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        if (bool.booleanValue()) {
            C3056b c3056b = new C3056b(this.f15288a);
            c3056b.m18194a(PointerIcon.TYPE_ALIAS);
            c3056b.m18197a("split_installer");
            c3056b.m18195a(this.f15288a.getText(R.string.split_install), this.f15288a.getText(R.string.split_install_toast));
            c3056b.m18192a(this.f15288a.getString(R.string.app_name), this.f15288a.getString(R.string.split_install_toast));
            C0542g.m3987a(this.f15295h);
        } else if (this.f15293f == null || this.f15292e == null || !this.f15292e.m18255D()) {
            C3112bn.m18999a(this.f15288a, R.string.error);
            C0542g.m3987a(this.f15295h);
        } else {
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f15288a);
            aVar.m418a(R.string.attention);
            aVar.m436b(this.f15293f);
            aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.e.ao.1

                /* renamed from: a */
                private final AsyncTaskC2913ao f15301a;

                {
                    this.f15301a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            aVar.m420a(R.string.install, (DialogInterface.OnClickListener) null);
            aVar.m429a(true);
            aVar.m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null);
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new AnonymousClass2(this, m438b));
            m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.e.ao.3

                /* renamed from: a */
                private final AsyncTaskC2913ao f15313a;

                {
                    this.f15313a = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (!this.f15313a.f15296i) {
                        C0542g.m3987a(this.f15313a.f15295h);
                    }
                    if (this.f15313a.f15290c != null) {
                        this.f15313a.f15290c.mo17929a();
                    }
                }
            });
            m438b.show();
        }
        super.mo17061b(new Boolean(true));
    }

    /* compiled from: SAITask.java */
    /* renamed from: ru.maximoff.apktool.e.ao$2, reason: invalid class name */
    class AnonymousClass2 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AsyncTaskC2913ao f15302a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f15303b;

        AnonymousClass2(AsyncTaskC2913ao asyncTaskC2913ao, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f15302a = asyncTaskC2913ao;
            this.f15303b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static AsyncTaskC2913ao m17260a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f15302a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f15303b.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f15303b) { // from class: ru.maximoff.apktool.e.ao.2.1

                /* renamed from: a */
                private final AnonymousClass2 f15304a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f15305b;

                {
                    this.f15304a = this;
                    this.f15305b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AnonymousClass2.m17260a(this.f15304a).f15296i = true;
                    try {
                        new AsyncTaskC2913ao(AnonymousClass2.m17260a(this.f15304a).f15288a, AnonymousClass2.m17260a(this.f15304a).f15290c, AnonymousClass2.m17260a(this.f15304a).f15291d, false, AnonymousClass2.m17260a(this.f15304a).f15298k, AnonymousClass2.m17260a(this.f15304a).f15299l, AnonymousClass2.m17260a(this.f15304a).f15300m).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, AnonymousClass2.m17260a(this.f15304a).f15294g);
                    } catch (Exception e2) {
                        C3112bn.m18999a(AnonymousClass2.m17260a(this.f15304a).f15288a, R.string.error_try_again);
                    }
                    this.f15305b.cancel();
                }
            });
            Button m414a = this.f15303b.m414a(-3);
            m414a.setEnabled(this.f15302a.f15292e.m18255D());
            m414a.setOnClickListener(new ViewOnClickListenerC33812(this, this.f15303b));
        }

        /* compiled from: SAITask.java */
        /* renamed from: ru.maximoff.apktool.e.ao$2$2, reason: invalid class name and collision with other inner class name */
        class ViewOnClickListenerC33812 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass2 f15306a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f15307b;

            ViewOnClickListenerC33812(AnonymousClass2 anonymousClass2, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f15306a = anonymousClass2;
                this.f15307b = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static AnonymousClass2 m17261a(ViewOnClickListenerC33812 viewOnClickListenerC33812) {
                return viewOnClickListenerC33812.f15306a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(AnonymousClass2.m17260a(this.f15306a).f15288a.getString(R.string.gplay));
                if (C3262u.m19616a(AnonymousClass2.m17260a(this.f15306a).f15292e.m18276n(), AnonymousClass2.m17260a(this.f15306a).f15292e.m18287y())) {
                    arrayList.add(AnonymousClass2.m17260a(this.f15306a).f15288a.getString(R.string.about));
                    arrayList.add(AnonymousClass2.m17260a(this.f15306a).f15288a.getString(R.string.launch_app));
                    arrayList.add(AnonymousClass2.m17260a(this.f15306a).f15288a.getString(R.string.delete));
                }
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(AnonymousClass2.m17260a(this.f15306a).f15288a).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, this.f15307b) { // from class: ru.maximoff.apktool.e.ao.2.2.1

                    /* renamed from: a */
                    private final ViewOnClickListenerC33812 f15308a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f15309b;

                    {
                        this.f15308a = this;
                        this.f15309b = r2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass2.m17260a(ViewOnClickListenerC33812.m17261a(this.f15308a)).m17247a(i, this.f15309b);
                        dialogInterface.dismiss();
                    }
                }).m429a(true).m438b();
                m438b.setOnShowListener(new DialogInterfaceOnShowListenerC33822(this, m438b));
                m438b.show();
            }

            /* compiled from: SAITask.java */
            /* renamed from: ru.maximoff.apktool.e.ao$2$2$2, reason: invalid class name and collision with other inner class name */
            class DialogInterfaceOnShowListenerC33822 implements DialogInterface.OnShowListener {

                /* renamed from: a */
                private final ViewOnClickListenerC33812 f15310a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f15311b;

                DialogInterfaceOnShowListenerC33822(ViewOnClickListenerC33812 viewOnClickListenerC33812, DialogInterfaceC0070b dialogInterfaceC0070b) {
                    this.f15310a = viewOnClickListenerC33812;
                    this.f15311b = dialogInterfaceC0070b;
                }

                /* renamed from: a */
                static ViewOnClickListenerC33812 m17262a(DialogInterfaceOnShowListenerC33822 dialogInterfaceOnShowListenerC33822) {
                    return dialogInterfaceOnShowListenerC33822.f15310a;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f15311b.m415a().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this) { // from class: ru.maximoff.apktool.e.ao.2.2.2.1

                        /* renamed from: a */
                        private final DialogInterfaceOnShowListenerC33822 f15312a;

                        {
                            this.f15312a = this;
                        }

                        @Override // android.widget.AdapterView.OnItemLongClickListener
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                            if (i != 0) {
                                return false;
                            }
                            C3112bn.m19002a(AnonymousClass2.m17260a(ViewOnClickListenerC33812.m17261a(DialogInterfaceOnShowListenerC33822.m17262a(this.f15312a))).f15288a, String.format("https://play.google.com/store/apps/details?id=%s", AnonymousClass2.m17260a(ViewOnClickListenerC33812.m17261a(DialogInterfaceOnShowListenerC33822.m17262a(this.f15312a))).f15292e.m18276n()));
                            return true;
                        }
                    });
                }
            }
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return false;
    }

    /* renamed from: a */
    public File m17259a(File file, String str) {
        String parent = file.getParent();
        if (str == null) {
            str = file.getName();
        }
        return new File(parent, C3262u.m19623b(this.f15288a, parent, str, "_sign", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17247a(int i, DialogInterfaceC0070b dialogInterfaceC0070b) {
        switch (i) {
            case 0:
                C3080al.m18603h(this.f15288a, this.f15292e.m18276n());
                break;
            case 1:
                C3080al.m18588c(this.f15288a, this.f15292e.m18276n());
                break;
            case 2:
                C3080al.m18599f(this.f15288a, this.f15292e.m18276n());
                break;
            case 3:
                C3080al.m18601g(this.f15288a, this.f15292e.m18276n());
                break;
        }
    }
}
