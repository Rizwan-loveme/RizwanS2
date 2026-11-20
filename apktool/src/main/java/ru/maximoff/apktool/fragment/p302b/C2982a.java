package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.p008os.AsyncTask;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Arrays;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.p300e.AsyncTaskC2901ac;
import ru.maximoff.apktool.p300e.AsyncTaskC2928bc;
import ru.maximoff.apktool.p300e.AsyncTaskC2940k;
import ru.maximoff.apktool.p300e.AsyncTaskC2950u;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.AsyncTaskC2955z;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3089au;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3267z;

/* compiled from: ApplicationItem.java */
/* renamed from: ru.maximoff.apktool.fragment.b.a */
/* loaded from: classes.dex */
public class C2982a extends C2986e {

    /* renamed from: c */
    private final Context f16278c;

    /* renamed from: d */
    private final boolean f16279d;

    /* renamed from: e */
    private final Bitmap f16280e;

    /* renamed from: f */
    private final C3066aa f16281f;

    /* renamed from: g */
    private final String f16282g;

    /* renamed from: h */
    private final CharSequence f16283h;

    public C2982a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        super(charSequence, charSequence2);
        this.f16278c = context;
        this.f16282g = this.f16278c.getString(R.string.split);
        this.f16283h = charSequence;
        this.f16279d = z;
        this.f16281f = new C3066aa(this.f16278c);
        this.f16280e = C3267z.m19713a().m19714a(this.f16281f, C3246h.m19470a(this.f16278c, R.color.grey), R.drawable.ic_apk);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: a */
    public void mo17836a(ImageView imageView) {
        imageView.setTag(this.f16283h);
        imageView.setImageBitmap(C3267z.m19713a().m19714a(this.f16281f, C3246h.m19470a(this.f16278c, this.f16279d ? R.color.colorVideo : R.color.colorApk), R.drawable.ic_apk));
    }

    /* renamed from: a */
    public void m17835a(PackageInfo packageInfo, PackageManager packageManager) {
        String stringBuffer;
        SpannableString spannableString;
        int applicationEnabledSetting = packageManager.getApplicationEnabledSetting(packageInfo.packageName);
        if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3) {
            stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f16278c.getString(R.string.block_icon)).append(" ").toString()).append(packageInfo.packageName).toString()).append(", v").toString()).append(C3112bn.m19017b((CharSequence) packageInfo.versionName)).toString()).append("(").toString()).append(packageInfo.versionCode).toString()).append(")").toString();
        } else {
            stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(packageInfo.packageName).append(", v").toString()).append(C3112bn.m19017b((CharSequence) packageInfo.versionName)).toString()).append("(").toString()).append(packageInfo.versionCode).toString()).append(")").toString();
        }
        File[] m18570a = C3080al.m18570a(packageInfo);
        if (m18570a.length > 1) {
            spannableString = new SpannableString(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(" ").append(this.f16282g).toString()).append("  ").toString()).append(stringBuffer).toString());
            spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.f16282g.length() + 2, 33);
            spannableString.setSpan(new BackgroundColorSpan(C3246h.m19470a(this.f16278c, R.color.dark_red)), 0, this.f16282g.length() + 2, 33);
        } else {
            spannableString = new SpannableString(stringBuffer);
        }
        mo17883a(new AnonymousClass1(this, packageInfo.applicationInfo.loadLabel(packageManager), spannableString, packageInfo, packageInfo, packageManager, m18570a));
    }

    /* compiled from: ApplicationItem.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.a$1, reason: invalid class name */
    class AnonymousClass1 extends C2986e {

        /* renamed from: c */
        private final C2982a f16284c;

        /* renamed from: d */
        private final PackageInfo f16285d;

        /* renamed from: e */
        private final PackageManager f16286e;

        /* renamed from: f */
        private final File[] f16287f;

        AnonymousClass1(C2982a c2982a, CharSequence charSequence, CharSequence charSequence2, PackageInfo packageInfo, PackageInfo packageInfo2, PackageManager packageManager, File[] fileArr) {
            super(charSequence, charSequence2, packageInfo);
            this.f16284c = c2982a;
            this.f16285d = packageInfo2;
            this.f16286e = packageManager;
            this.f16287f = fileArr;
        }

        /* renamed from: a */
        static C2982a m17837a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f16284c;
        }

        @Override // ru.maximoff.apktool.fragment.p302b.C2986e
        /* renamed from: a */
        public void mo17836a(ImageView imageView) {
            Drawable loadIcon = this.f16285d.applicationInfo.loadIcon(this.f16286e);
            imageView.setImageBitmap(this.f16284c.f16280e);
            try {
                imageView.setTag(this.f16287f[0].getAbsolutePath());
                AsyncTaskC2954y asyncTaskC2954y = new AsyncTaskC2954y(this.f16284c.f16278c, imageView, (InterfaceC2995n) null);
                asyncTaskC2954y.m17594a(loadIcon);
                C2919au.m17340a(this.f16287f[0], new C2919au.a(this, asyncTaskC2954y) { // from class: ru.maximoff.apktool.fragment.b.a.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f16288a;

                    /* renamed from: b */
                    private final AsyncTaskC2954y f16289b;

                    {
                        this.f16288a = this;
                        this.f16289b = asyncTaskC2954y;
                    }

                    @Override // ru.maximoff.apktool.p300e.C2919au.a
                    /* renamed from: a */
                    public AsyncTaskC2954y mo17349a() {
                        return this.f16289b;
                    }
                });
            } catch (Exception e2) {
                imageView.setImageDrawable(loadIcon);
            }
        }

        @Override // ru.maximoff.apktool.fragment.p302b.C2986e
        /* renamed from: a */
        public void mo17838a(View view) {
            DialogInterfaceC0070b dialogInterfaceC0070b;
            String m18910a = C3102bd.m18910a(this.f16284c.f16278c, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})");
            C3060a c3060a = new C3060a(this.f16284c.f16278c, this.f16286e, this.f16285d, this.f16287f[0]);
            if (m18910a.indexOf("{ARCH") >= 0) {
                View inflate = LayoutInflater.from(this.f16284c.f16278c).inflate(R.layout.search_progress, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
                dialogInterfaceC0070b = new DialogInterfaceC0070b.a(this.f16284c.f16278c).m435b(inflate).m429a(false).m438b();
                dialogInterfaceC0070b.show();
            } else {
                dialogInterfaceC0070b = (DialogInterfaceC0070b) null;
            }
            c3060a.m18263a(new AnonymousClass2(this, dialogInterfaceC0070b, this.f16287f, c3060a, view, m18910a, this.f16285d, this.f16286e));
        }

        /* compiled from: ApplicationItem.java */
        /* renamed from: ru.maximoff.apktool.fragment.b.a$1$2, reason: invalid class name */
        class AnonymousClass2 implements C3060a.a {

            /* renamed from: a */
            private final AnonymousClass1 f16290a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16291b;

            /* renamed from: c */
            private final File[] f16292c;

            /* renamed from: d */
            private final C3060a f16293d;

            /* renamed from: e */
            private final View f16294e;

            /* renamed from: f */
            private final String f16295f;

            /* renamed from: g */
            private final PackageInfo f16296g;

            /* renamed from: h */
            private final PackageManager f16297h;

            AnonymousClass2(AnonymousClass1 anonymousClass1, DialogInterfaceC0070b dialogInterfaceC0070b, File[] fileArr, C3060a c3060a, View view, String str, PackageInfo packageInfo, PackageManager packageManager) {
                this.f16290a = anonymousClass1;
                this.f16291b = dialogInterfaceC0070b;
                this.f16292c = fileArr;
                this.f16293d = c3060a;
                this.f16294e = view;
                this.f16295f = str;
                this.f16296g = packageInfo;
                this.f16297h = packageManager;
            }

            /* renamed from: a */
            static AnonymousClass1 m17839a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f16290a;
            }

            @Override // ru.maximoff.apktool.util.C3060a.a
            /* renamed from: a */
            public void mo17840a() {
                if (this.f16291b != null && this.f16291b.isShowing()) {
                    try {
                        this.f16291b.cancel();
                    } catch (Exception e2) {
                    }
                }
                if (this.f16292c.length > 1 && this.f16293d.m18259H().isEmpty()) {
                    this.f16293d.m18262a(C3080al.m18543a(this.f16292c));
                }
                Menu m18715a = C3089au.m18715a(this.f16294e, R.menu.app, new C3089au.a(this, this.f16292c, this.f16293d, this.f16295f, this.f16296g, this.f16297h) { // from class: ru.maximoff.apktool.fragment.b.a.1.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f16298a;

                    /* renamed from: b */
                    private final File[] f16299b;

                    /* renamed from: c */
                    private final C3060a f16300c;

                    /* renamed from: d */
                    private final String f16301d;

                    /* renamed from: e */
                    private final PackageInfo f16302e;

                    /* renamed from: f */
                    private final PackageManager f16303f;

                    {
                        this.f16298a = this;
                        this.f16299b = r2;
                        this.f16300c = r3;
                        this.f16301d = r4;
                        this.f16302e = r5;
                        this.f16303f = r6;
                    }

                    @Override // ru.maximoff.apktool.util.C3089au.a
                    /* renamed from: a */
                    public void mo17670a(Context context, int i) {
                        String stringBuffer;
                        File file = this.f16299b[0];
                        try {
                            stringBuffer = C3112bn.m18992a(AnonymousClass1.m17837a(AnonymousClass2.m17839a(this.f16298a)).f16278c, this.f16300c, this.f16301d);
                        } catch (Exception e3) {
                            stringBuffer = new StringBuffer().append("ApkFile_").append(C3112bn.m19032g("yyyyMMddHHmmss")).toString();
                        }
                        String m19033h = C3112bn.m19033h(stringBuffer);
                        switch (i) {
                            case R.id.app_details /* 2131690153 */:
                                C3080al.m18551a(context, (File) null, this.f16302e, this.f16303f);
                                break;
                            case R.id.quick_edit /* 2131690154 */:
                                C3262u.m19589a(context, file, (InterfaceC2995n) null, true);
                                break;
                            case R.id.decompile /* 2131690155 */:
                                C3080al.m18556a(context, (InterfaceC2995n) null, this.f16299b, m19033h, m19033h);
                                break;
                            case R.id.verify /* 2131690157 */:
                                try {
                                    new AsyncTaskC2928bc(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                                    break;
                                } catch (Exception e4) {
                                    C3112bn.m18999a(context, R.string.error_try_again);
                                    return;
                                }
                            case R.id.import_framework /* 2131690169 */:
                                try {
                                    new AsyncTaskC2955z(context, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                                    break;
                                } catch (Exception e5) {
                                    C3112bn.m18999a(context, R.string.error_try_again);
                                    return;
                                }
                            case R.id.sharing_file /* 2131690171 */:
                                try {
                                    if (this.f16299b.length > 1) {
                                        C3080al.m18557a(context, this.f16299b, this.f16300c, m19033h, stringBuffer, true);
                                    } else {
                                        new AsyncTaskC2950u(context, new StringBuffer().append(m19033h).append(".apk").toString(), true, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16299b);
                                    }
                                    break;
                                } catch (Exception e6) {
                                    C3112bn.m19023b(context, context.getString(R.string.errorf, e6.getMessage()));
                                    return;
                                }
                            case R.id.antisplit /* 2131690175 */:
                            case R.id.decompile_full /* 2131690176 */:
                            case R.id.decompile_res /* 2131690182 */:
                                AnonymousClass1.m17837a(AnonymousClass2.m17839a(this.f16298a)).m17831a(context, this.f16299b, i, m19033h);
                                break;
                            case R.id.open_zip /* 2131690180 */:
                                if (this.f16299b.length > 1) {
                                    String[] strArr = new String[this.f16299b.length];
                                    for (int i2 = 0; i2 < this.f16299b.length; i2++) {
                                        strArr[i2] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f16299b[i2].getName()).append(" (").toString()).append(C3106bh.m18975a(this.f16299b[i2].length(), C3102bd.f18305am)).toString()).append(")").toString();
                                    }
                                    new DialogInterfaceC0070b.a(context).m418a(R.string.view_content).m431a(strArr, new DialogInterface.OnClickListener(this, context, this.f16299b) { // from class: ru.maximoff.apktool.fragment.b.a.1.2.1.1

                                        /* renamed from: a */
                                        private final C34031 f16304a;

                                        /* renamed from: b */
                                        private final Context f16305b;

                                        /* renamed from: c */
                                        private final File[] f16306c;

                                        {
                                            this.f16304a = this;
                                            this.f16305b = context;
                                            this.f16306c = r3;
                                        }

                                        @Override // android.content.DialogInterface.OnClickListener
                                        public void onClick(DialogInterface dialogInterface, int i3) {
                                            try {
                                                new AsyncTaskC2901ac(this.f16305b, this.f16306c[i3], (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                            } catch (Exception e7) {
                                                C3112bn.m18999a(this.f16305b, R.string.error_try_again);
                                            }
                                            dialogInterface.dismiss();
                                        }
                                    }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                                    break;
                                } else {
                                    try {
                                        new AsyncTaskC2901ac(context, file, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                        break;
                                    } catch (Exception e7) {
                                        C3112bn.m18999a(context, R.string.error_try_again);
                                        return;
                                    }
                                }
                            case R.id.launchApp /* 2131690183 */:
                                C3080al.m18599f(context, this.f16302e.packageName);
                                break;
                            case R.id.deleteApp /* 2131690184 */:
                                C3080al.m18601g(context, this.f16302e.packageName);
                                break;
                            case R.id.open_settings /* 2131690185 */:
                                C3080al.m18588c(context, this.f16302e.packageName);
                                break;
                            case R.id.open_market /* 2131690186 */:
                                C3080al.m18603h(context, this.f16302e.packageName);
                                break;
                            case R.id.extract_app /* 2131690187 */:
                                try {
                                    if (this.f16299b.length > 1) {
                                        C3080al.m18557a(context, this.f16299b, this.f16300c, m19033h, stringBuffer, false);
                                    } else {
                                        new AsyncTaskC2950u(context, new StringBuffer().append(m19033h).append(".apk").toString(), false, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16299b);
                                    }
                                    break;
                                } catch (Exception e8) {
                                    C3112bn.m19023b(context, context.getString(R.string.errorf, e8.getMessage()));
                                    return;
                                }
                        }
                    }
                });
                m18715a.findItem(R.id.antisplit).setVisible(this.f16292c.length > 1);
                m18715a.findItem(R.id.decompile_full).setVisible(this.f16292c.length > 1);
                m18715a.findItem(R.id.decompile_res).setVisible(this.f16292c.length > 1);
                m18715a.findItem(R.id.decompile).setVisible(this.f16292c.length == 1);
                m18715a.findItem(R.id.quick_edit).setVisible(this.f16292c.length == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17830a(Context context, File[] fileArr, int i) {
        int[] iArr = {1, 3};
        File[] fileArr2 = new File[fileArr.length];
        File[] fileArr3 = new File[1];
        Runnable runnable = new Runnable(this, fileArr3) { // from class: ru.maximoff.apktool.fragment.b.a.2

            /* renamed from: a */
            private final C2982a f16307a;

            /* renamed from: b */
            private final File[] f16308b;

            {
                this.f16307a = this;
                this.f16308b = fileArr3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f16308b[0] == null || !this.f16308b[0].exists()) {
                    return;
                }
                C0542g.m3987a(this.f16308b[0]);
            }
        };
        Runnable runnable2 = new Runnable(this, i, context, iArr, fileArr2) { // from class: ru.maximoff.apktool.fragment.b.a.3

            /* renamed from: a */
            private final C2982a f16309a;

            /* renamed from: b */
            private final int f16310b;

            /* renamed from: c */
            private final Context f16311c;

            /* renamed from: d */
            private final int[] f16312d;

            /* renamed from: e */
            private final File[] f16313e;

            {
                this.f16309a = this;
                this.f16310b = i;
                this.f16311c = context;
                this.f16312d = iArr;
                this.f16313e = fileArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                boolean z2 = this.f16310b == R.id.decompile_full;
                AsyncTaskC2940k asyncTaskC2940k = new AsyncTaskC2940k(this.f16311c, (InterfaceC2995n) null, (String) null);
                AbstractAsyncTaskC2898a.m17030c(true);
                if (!z2 && this.f16310b != R.id.decompile_res) {
                    z = false;
                }
                asyncTaskC2940k.m17512k(z);
                asyncTaskC2940k.m17513l(z2);
                asyncTaskC2940k.m17507b(this.f16312d[0]);
                try {
                    asyncTaskC2940k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16313e);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f16309a.f16278c, R.string.error_try_again);
                }
            }
        };
        View inflate = LayoutInflater.from(this.f16278c).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m435b(inflate).m429a(false).m438b();
        m438b.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, context, m438b, fileArr3, fileArr, fileArr2, i, runnable2, iArr, runnable) { // from class: ru.maximoff.apktool.fragment.b.a.4

            /* renamed from: a */
            private final C2982a f16314a;

            /* renamed from: b */
            private final Context f16315b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f16316c;

            /* renamed from: d */
            private final File[] f16317d;

            /* renamed from: e */
            private final File[] f16318e;

            /* renamed from: f */
            private final File[] f16319f;

            /* renamed from: g */
            private final int f16320g;

            /* renamed from: h */
            private final Runnable f16321h;

            /* renamed from: i */
            private final int[] f16322i;

            /* renamed from: j */
            private final Runnable f16323j;

            {
                this.f16314a = this;
                this.f16315b = context;
                this.f16316c = m438b;
                this.f16317d = fileArr3;
                this.f16318e = fileArr;
                this.f16319f = fileArr2;
                this.f16320g = i;
                this.f16321h = runnable2;
                this.f16322i = iArr;
                this.f16323j = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = C3102bd.f18339v;
                if (str == null) {
                    C3112bn.m19023b(this.f16315b, this.f16315b.getString(R.string.output_directory_not_set));
                    this.f16316c.cancel();
                    return;
                }
                this.f16317d[0] = new File(new StringBuffer().append(new StringBuffer().append(str).append("/AM_AntiSplit_").toString()).append(System.currentTimeMillis()).toString());
                if (!this.f16317d[0].exists()) {
                    this.f16317d[0].mkdirs();
                }
                for (int i2 = 0; i2 < this.f16318e.length; i2++) {
                    File file = new File(this.f16317d[0], this.f16318e[i2].getName());
                    C3262u.m19612a(this.f16318e[i2], file);
                    this.f16319f[i2] = file;
                }
                this.f16316c.cancel();
                if (this.f16320g == R.id.decompile_full || this.f16320g == R.id.decompile_res) {
                    this.f16321h.run();
                } else {
                    C3262u.m19601a(this.f16315b, this.f16322i, this.f16321h, this.f16323j, true, R.string.mantisplit);
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17831a(Context context, File[] fileArr, int i, String str) {
        int i2;
        int i3 = 1;
        switch (i) {
            case R.id.decompile_full /* 2131690176 */:
                i2 = R.string.decompile;
                break;
            case R.id.decompile_res /* 2131690182 */:
                i2 = R.string.decompile_res;
                break;
            default:
                i3 = 2;
                i2 = R.string.mantisplit;
                break;
        }
        Arrays.sort(fileArr);
        String[] strArr = new String[fileArr.length];
        for (int i4 = 0; i4 < fileArr.length; i4++) {
            strArr[i4] = fileArr[i4].getName();
        }
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m432a(strArr, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
        aVar.m418a(i2);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, fileArr, i3, i, context, str) { // from class: ru.maximoff.apktool.fragment.b.a.5

            /* renamed from: a */
            private final C2982a f16324a;

            /* renamed from: b */
            private final File[] f16325b;

            /* renamed from: c */
            private final int f16326c;

            /* renamed from: d */
            private final int f16327d;

            /* renamed from: e */
            private final Context f16328e;

            /* renamed from: f */
            private final String f16329f;

            {
                this.f16324a = this;
                this.f16325b = fileArr;
                this.f16326c = i3;
                this.f16327d = i;
                this.f16328e = context;
                this.f16329f = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                ArrayList arrayList = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                for (int i6 = 0; i6 < m415a.getCount(); i6++) {
                    if (m415a.isItemChecked(i6)) {
                        for (int i7 = 0; i7 < this.f16325b.length; i7++) {
                            if (this.f16325b[i7].getName().equals((String) m415a.getItemAtPosition(i6))) {
                                arrayList.add(this.f16325b[i7]);
                            }
                        }
                    }
                }
                if (arrayList.size() >= this.f16326c) {
                    if (this.f16327d != R.id.antisplit && arrayList.size() == this.f16326c) {
                        C3080al.m18556a(this.f16328e, (InterfaceC2995n) null, (File[]) arrayList.toArray(new File[arrayList.size()]), this.f16329f, this.f16329f);
                    } else {
                        this.f16324a.m17830a(this.f16328e, (File[]) arrayList.toArray(new File[arrayList.size()]), this.f16327d);
                    }
                }
                dialogInterface.cancel();
            }
        });
        aVar.m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, i3) { // from class: ru.maximoff.apktool.fragment.b.a.6

            /* renamed from: a */
            private final C2982a f16330a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16331b;

            /* renamed from: c */
            private final int f16332c;

            {
                this.f16330a = this;
                this.f16331b = m438b;
                this.f16332c = i3;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16331b.m414a(-1);
                m414a.setEnabled(true);
                ListView m415a = this.f16331b.m415a();
                for (int i5 = 0; i5 < m415a.getCount(); i5++) {
                    m415a.setItemChecked(i5, true);
                }
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a, this.f16332c) { // from class: ru.maximoff.apktool.fragment.b.a.6.1

                    /* renamed from: a */
                    private final AnonymousClass6 f16333a;

                    /* renamed from: b */
                    private final ListView f16334b;

                    /* renamed from: c */
                    private final Button f16335c;

                    /* renamed from: d */
                    private final int f16336d;

                    {
                        this.f16333a = this;
                        this.f16334b = m415a;
                        this.f16335c = m414a;
                        this.f16336d = r4;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                        int i7 = 0;
                        for (int i8 = 0; i8 < this.f16334b.getCount(); i8++) {
                            if (this.f16334b.isItemChecked(i8)) {
                                i7++;
                            }
                        }
                        this.f16335c.setEnabled(i7 >= this.f16336d);
                    }
                });
                Button m414a2 = this.f16331b.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a, this.f16332c) { // from class: ru.maximoff.apktool.fragment.b.a.6.2

                    /* renamed from: a */
                    private final AnonymousClass6 f16337a;

                    /* renamed from: b */
                    private final ListView f16338b;

                    /* renamed from: c */
                    private final Button f16339c;

                    /* renamed from: d */
                    private final int f16340d;

                    {
                        this.f16337a = this;
                        this.f16338b = m415a;
                        this.f16339c = m414a;
                        this.f16340d = r4;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i6 = 0;
                        for (int i7 = 0; i7 < this.f16338b.getCount(); i7++) {
                            boolean isItemChecked = this.f16338b.isItemChecked(i7);
                            this.f16338b.setItemChecked(i7, !isItemChecked);
                            if (!isItemChecked) {
                                i6++;
                            }
                        }
                        this.f16339c.setEnabled(i6 >= this.f16340d);
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.fragment.b.a.6.3

                    /* renamed from: a */
                    private final AnonymousClass6 f16341a;

                    /* renamed from: b */
                    private final ListView f16342b;

                    /* renamed from: c */
                    private final Button f16343c;

                    {
                        this.f16341a = this;
                        this.f16342b = m415a;
                        this.f16343c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i6 = 0; i6 < this.f16342b.getCount(); i6++) {
                            this.f16342b.setItemChecked(i6, true);
                        }
                        this.f16343c.setEnabled(true);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }
}
