package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.p008os.AsyncTask;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.HashSet;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3109bk;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: PreInstallTask.java */
/* renamed from: ru.maximoff.apktool.e.ag */
/* loaded from: classes.dex */
public class AsyncTaskC2905ag extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15071a;

    /* renamed from: b */
    private DialogInterfaceC0070b f15072b;

    /* renamed from: c */
    private boolean f15073c;

    /* renamed from: d */
    private boolean f15074d = false;

    /* renamed from: e */
    private boolean f15075e;

    /* renamed from: f */
    private SpannedString f15076f;

    /* renamed from: g */
    private File f15077g;

    /* renamed from: h */
    private C3060a f15078h;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17130a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17131a(bool);
    }

    public AsyncTaskC2905ag(Context context, boolean z, boolean z2) {
        this.f15071a = context;
        this.f15073c = z;
        this.f15075e = z2;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        View inflate = LayoutInflater.from(this.f15071a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15072b = new DialogInterfaceC0070b.a(this.f15071a).m435b(inflate).m429a(false).m438b();
        this.f15072b.show();
    }

    /* renamed from: a */
    protected Boolean m17130a(File[] fileArr) {
        this.f15077g = fileArr[0];
        this.f15078h = new C3060a(this.f15071a, this.f15077g);
        if (!this.f15078h.m18255D()) {
            this.f15076f = new SpannedString(this.f15071a.getString(R.string.mapk_damage));
            return new Boolean(false);
        }
        HashSet<Long> m18965a = C3105bg.m18965a(this.f15071a, this.f15077g);
        if (m18965a.isEmpty()) {
            this.f15076f = new SpannedString(this.f15071a.getString(R.string.mapk_nosign));
            return new Boolean(false);
        }
        if (!C3262u.m19616a(this.f15078h.m18276n(), this.f15078h.m18287y())) {
            return new Boolean(true);
        }
        if (!this.f15073c) {
            try {
                PackageInfo packageInfo = this.f15078h.m18287y().getPackageInfo(this.f15078h.m18276n(), 0);
                if (!(this.f15078h.m18278p() >= packageInfo.versionCode)) {
                    this.f15074d = true;
                    int m19470a = C3246h.m19470a(this.f15071a, R.color.dark_red);
                    int m19470a2 = C3246h.m19470a(this.f15071a, R.color.dark_green);
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(this.f15078h.m18277o()).append(", ").toString()).append(this.f15078h.m18278p()).toString();
                    String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(C3112bn.m19017b((CharSequence) packageInfo.versionName)).append(", ").toString()).append(packageInfo.versionCode).toString();
                    SpannableString spannableString = new SpannableString(stringBuffer);
                    spannableString.setSpan(new ForegroundColorSpan(m19470a), stringBuffer.lastIndexOf(", ") + 1, stringBuffer.length(), 33);
                    SpannableString spannableString2 = new SpannableString(stringBuffer2);
                    spannableString2.setSpan(new ForegroundColorSpan(m19470a2), stringBuffer2.lastIndexOf(", ") + 1, stringBuffer2.length(), 33);
                    this.f15076f = C3109bk.m18982a(this.f15071a.getString(R.string.mapk_version_low), spannableString, spannableString2);
                    return new Boolean(false);
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        if (!C3105bg.m18968a(m18965a, C3105bg.m18972b(this.f15071a, this.f15078h.m18276n()))) {
            this.f15076f = new SpannedString(this.f15071a.getString(R.string.mapk_sign_fail));
            return new Boolean(false);
        }
        return new Boolean(true);
    }

    /* renamed from: a */
    protected void m17131a(Boolean bool) {
        if (this.f15072b != null && this.f15072b.isShowing()) {
            try {
                this.f15072b.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15077g == null || this.f15078h == null) {
            C3112bn.m19023b(this.f15071a, this.f15071a.getString(R.string.error));
            return;
        }
        if (bool.booleanValue()) {
            if (this.f15075e) {
                C3262u.m19643c(this.f15071a, this.f15077g);
                return;
            } else {
                C3262u.m19626b(this.f15071a, this.f15077g);
                return;
            }
        }
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f15071a);
        aVar.m418a(R.string.attention);
        aVar.m436b(this.f15076f);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.install, (DialogInterface.OnClickListener) null);
        aVar.m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new AnonymousClass1(this, m438b));
        m438b.show();
    }

    /* compiled from: PreInstallTask.java */
    /* renamed from: ru.maximoff.apktool.e.ag$1, reason: invalid class name */
    class AnonymousClass1 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AsyncTaskC2905ag f15079a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f15080b;

        AnonymousClass1(AsyncTaskC2905ag asyncTaskC2905ag, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f15079a = asyncTaskC2905ag;
            this.f15080b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static AsyncTaskC2905ag m17132a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f15079a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f15080b.m414a(-1);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f15080b) { // from class: ru.maximoff.apktool.e.ag.1.1

                /* renamed from: a */
                private final AnonymousClass1 f15081a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f15082b;

                {
                    this.f15081a = this;
                    this.f15082b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AnonymousClass1.m17132a(this.f15081a).f15074d) {
                        C3262u.m19591a(AnonymousClass1.m17132a(this.f15081a).f15071a, AnonymousClass1.m17132a(this.f15081a).f15077g, AnonymousClass1.m17132a(this.f15081a).f15074d, AnonymousClass1.m17132a(this.f15081a).f15075e);
                    } else if (AnonymousClass1.m17132a(this.f15081a).f15075e) {
                        C3262u.m19643c(AnonymousClass1.m17132a(this.f15081a).f15071a, AnonymousClass1.m17132a(this.f15081a).f15077g);
                    } else {
                        C3262u.m19626b(AnonymousClass1.m17132a(this.f15081a).f15071a, AnonymousClass1.m17132a(this.f15081a).f15077g);
                    }
                    this.f15082b.cancel();
                }
            });
            m414a.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.e.ag.1.2

                /* renamed from: a */
                private final AnonymousClass1 f15083a;

                {
                    this.f15083a = this;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    C3262u.m19650d(AnonymousClass1.m17132a(this.f15083a).f15071a, AnonymousClass1.m17132a(this.f15083a).f15077g);
                    return true;
                }
            });
            Button m414a2 = this.f15080b.m414a(-3);
            m414a2.setEnabled(this.f15079a.f15078h.m18255D());
            m414a2.setOnClickListener(new AnonymousClass3(this, this.f15080b));
        }

        /* compiled from: PreInstallTask.java */
        /* renamed from: ru.maximoff.apktool.e.ag$1$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass1 f15084a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f15085b;

            AnonymousClass3(AnonymousClass1 anonymousClass1, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f15084a = anonymousClass1;
                this.f15085b = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static AnonymousClass1 m17133a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f15084a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.sign));
                arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.verify));
                arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.gplay));
                if (C3262u.m19616a(AnonymousClass1.m17132a(this.f15084a).f15078h.m18276n(), AnonymousClass1.m17132a(this.f15084a).f15078h.m18287y())) {
                    arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.about));
                    arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.launch_app));
                    arrayList.add(AnonymousClass1.m17132a(this.f15084a).f15071a.getString(R.string.delete));
                }
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(AnonymousClass1.m17132a(this.f15084a).f15071a).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, this.f15085b) { // from class: ru.maximoff.apktool.e.ag.1.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f15086a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f15087b;

                    {
                        this.f15086a = this;
                        this.f15087b = r2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass1.m17132a(AnonymousClass3.m17133a(this.f15086a)).m17124a(i, this.f15087b);
                        dialogInterface.dismiss();
                    }
                }).m429a(true).m438b();
                m438b.setOnShowListener(new AnonymousClass2(this, m438b));
                m438b.show();
            }

            /* compiled from: PreInstallTask.java */
            /* renamed from: ru.maximoff.apktool.e.ag$1$3$2, reason: invalid class name */
            class AnonymousClass2 implements DialogInterface.OnShowListener {

                /* renamed from: a */
                private final AnonymousClass3 f15088a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f15089b;

                AnonymousClass2(AnonymousClass3 anonymousClass3, DialogInterfaceC0070b dialogInterfaceC0070b) {
                    this.f15088a = anonymousClass3;
                    this.f15089b = dialogInterfaceC0070b;
                }

                /* renamed from: a */
                static AnonymousClass3 m17134a(AnonymousClass2 anonymousClass2) {
                    return anonymousClass2.f15088a;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f15089b.m415a().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this) { // from class: ru.maximoff.apktool.e.ag.1.3.2.1

                        /* renamed from: a */
                        private final AnonymousClass2 f15090a;

                        {
                            this.f15090a = this;
                        }

                        @Override // android.widget.AdapterView.OnItemLongClickListener
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                            if (i != 2) {
                                return false;
                            }
                            C3112bn.m19002a(AnonymousClass1.m17132a(AnonymousClass3.m17133a(AnonymousClass2.m17134a(this.f15090a))).f15071a, String.format("https://play.google.com/store/apps/details?id=%s", AnonymousClass1.m17132a(AnonymousClass3.m17133a(AnonymousClass2.m17134a(this.f15090a))).f15078h.m18276n()));
                            return true;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17124a(int i, DialogInterfaceC0070b dialogInterfaceC0070b) {
        switch (i) {
            case 0:
                int[] iArr = {1, 2};
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, iArr);
                dialogInterfaceC0070b.cancel();
                if (C3102bd.m18925a(this.f15071a, "custom_signature_file", false)) {
                    C3262u.m19599a(this.f15071a, iArr, anonymousClass2, (Runnable) null);
                    break;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(anonymousClass2, 100L);
                    break;
                }
            case 1:
                AsyncTaskC2928bc asyncTaskC2928bc = new AsyncTaskC2928bc(this.f15071a);
                asyncTaskC2928bc.m17060b(this.f15077g);
                try {
                    asyncTaskC2928bc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f15077g);
                    break;
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f15071a, R.string.error_try_again);
                    return;
                }
            case 2:
                C3080al.m18603h(this.f15071a, this.f15078h.m18276n());
                break;
            case 3:
                C3080al.m18588c(this.f15071a, this.f15078h.m18276n());
                break;
            case 4:
                C3080al.m18599f(this.f15071a, this.f15078h.m18276n());
                break;
            case 5:
                C3080al.m18601g(this.f15071a, this.f15078h.m18276n());
                break;
        }
    }

    /* compiled from: PreInstallTask.java */
    /* renamed from: ru.maximoff.apktool.e.ag$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        private final AsyncTaskC2905ag f15091a;

        /* renamed from: b */
        private final int[] f15092b;

        AnonymousClass2(AsyncTaskC2905ag asyncTaskC2905ag, int[] iArr) {
            this.f15091a = asyncTaskC2905ag;
            this.f15092b = iArr;
        }

        /* renamed from: a */
        static AsyncTaskC2905ag m17135a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f15091a;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2917as.m17314a(this.f15091a.f15071a, this.f15092b[0], new C2917as.a(this) { // from class: ru.maximoff.apktool.e.ag.2.1

                /* renamed from: a */
                private final AnonymousClass2 f15093a;

                {
                    this.f15093a = this;
                }

                @Override // ru.maximoff.apktool.p300e.C2917as.a
                /* renamed from: a */
                public void mo16440a(C2917as c2917as, boolean z) {
                    try {
                        new AsyncTaskC2916ar(AnonymousClass2.m17135a(this.f15093a).f15071a, (InterfaceC2995n) null, c2917as).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, AnonymousClass2.m17135a(this.f15093a).f15077g);
                    } catch (Exception e2) {
                        C3112bn.m18999a(AnonymousClass2.m17135a(this.f15093a).f15071a, R.string.error_try_again);
                    }
                }
            });
        }
    }
}
