package ru.maximoff.apktool.util.p305c;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: DetectProtect.java */
/* renamed from: ru.maximoff.apktool.util.c.ah */
/* loaded from: classes.dex */
public class AsyncTaskC3127ah extends AsyncTask<File, String, String> {

    /* renamed from: a */
    private final String f18454a;

    /* renamed from: b */
    private boolean f18455b;

    /* renamed from: c */
    private Context f18456c;

    /* renamed from: d */
    private TextView f18457d;

    /* renamed from: e */
    private Handler f18458e;

    /* renamed from: f */
    private List<AbstractC3187d> f18459f;

    @Override // android.os.AsyncTask
    protected String doInBackground(File[] fileArr) {
        return m19093a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled(String str) {
        m19095b(str);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19094a(str);
    }

    public AsyncTaskC3127ah(Context context, TextView textView, String str) {
        this.f18456c = context;
        this.f18457d = textView;
        this.f18455b = str != null && str.equals("com.pairip.application.Application");
        this.f18459f = new ArrayList();
        this.f18454a = this.f18456c.getString(R.string.dot);
        this.f18457d.setText(this.f18454a);
        this.f18458e = new Handler(Looper.getMainLooper());
        this.f18458e.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.util.c.ah.1

            /* renamed from: a */
            private final AsyncTaskC3127ah f18460a;

            {
                this.f18460a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f18460a.f18457d.getText().length() >= 5) {
                        this.f18460a.f18457d.setText(this.f18460a.f18454a);
                    } else {
                        this.f18460a.f18457d.setText(new StringBuffer().append((Object) this.f18460a.f18457d.getText()).append(this.f18460a.f18454a).toString());
                    }
                    this.f18460a.f18458e.postDelayed(this, 1000L);
                } catch (Error e2) {
                    if (this.f18460a.f18458e != null) {
                        this.f18460a.f18458e.removeCallbacksAndMessages((Object) null);
                    }
                } catch (Exception e3) {
                    if (this.f18460a.f18458e != null) {
                        this.f18460a.f18458e.removeCallbacksAndMessages((Object) null);
                    }
                }
            }
        }, 1000L);
    }

    /* renamed from: a */
    protected String m19093a(File[] fileArr) {
        C3162bp c3162bp = new C3162bp(this.f18455b);
        C3163bq c3163bq = new C3163bq();
        this.f18459f.add(new C3188e());
        this.f18459f.add(new C3189f());
        this.f18459f.add(new C3190g());
        this.f18459f.add(new C3191h());
        this.f18459f.add(new C3192i());
        this.f18459f.add(new C3193j());
        this.f18459f.add(new C3194k());
        this.f18459f.add(new C3195l());
        this.f18459f.add(new C3119a());
        this.f18459f.add(new C3146b());
        this.f18459f.add(new C3173c());
        this.f18459f.add(new C3196m());
        this.f18459f.add(new C3197n());
        this.f18459f.add(new C3198o());
        this.f18459f.add(new C3199p());
        this.f18459f.add(new C3200q());
        this.f18459f.add(new C3201r());
        this.f18459f.add(new C3206w());
        this.f18459f.add(new C3202s());
        this.f18459f.add(new C3203t());
        this.f18459f.add(new C3204u());
        this.f18459f.add(new C3205v());
        this.f18459f.add(new C3208y());
        this.f18459f.add(new C3209z());
        this.f18459f.add(new C3120aa());
        this.f18459f.add(new C3207x());
        this.f18459f.add(new C3121ab());
        this.f18459f.add(new C3122ac());
        this.f18459f.add(new C3123ad());
        this.f18459f.add(new C3124ae());
        this.f18459f.add(new C3126ag());
        this.f18459f.add(new C3129aj());
        this.f18459f.add(new C3130ak());
        this.f18459f.add(new C3131al());
        this.f18459f.add(new C3132am());
        this.f18459f.add(new C3133an());
        this.f18459f.add(new C3134ao());
        this.f18459f.add(new C3135ap());
        this.f18459f.add(new C3128ai());
        this.f18459f.add(new C3136aq());
        this.f18459f.add(new C3125af());
        this.f18459f.add(new C3137ar());
        this.f18459f.add(new C3138as());
        this.f18459f.add(new C3139at());
        this.f18459f.add(new C3140au());
        this.f18459f.add(new C3141av());
        this.f18459f.add(new C3143ax());
        this.f18459f.add(new C3142aw());
        this.f18459f.add(new C3144ay());
        this.f18459f.add(new C3145az());
        this.f18459f.add(new C3147ba());
        this.f18459f.add(new C3148bb());
        this.f18459f.add(new C3149bc());
        this.f18459f.add(new C3150bd());
        this.f18459f.add(new C3151be());
        this.f18459f.add(new C3152bf());
        this.f18459f.add(new C3153bg());
        this.f18459f.add(new C3154bh());
        this.f18459f.add(new C3155bi());
        this.f18459f.add(new C3156bj());
        this.f18459f.add(new C3158bl());
        this.f18459f.add(new C3159bm());
        this.f18459f.add(new C3157bk());
        this.f18459f.add(new C3161bo());
        this.f18459f.add(new C3160bn());
        this.f18459f.add(c3163bq);
        this.f18459f.add(c3162bp);
        this.f18459f.add(new C3164br());
        this.f18459f.add(new C3165bs());
        this.f18459f.add(new C3185cl());
        this.f18459f.add(new C3166bt());
        this.f18459f.add(new C3168bv());
        this.f18459f.add(new C3167bu());
        this.f18459f.add(new C3169bw());
        this.f18459f.add(new C3170bx());
        this.f18459f.add(new C3171by());
        this.f18459f.add(new C3172bz());
        this.f18459f.add(new C3174ca());
        this.f18459f.add(new C3175cb());
        this.f18459f.add(new C3176cc());
        this.f18459f.add(new C3177cd());
        this.f18459f.add(new C3178ce());
        this.f18459f.add(new C3180cg());
        this.f18459f.add(new C3181ch());
        this.f18459f.add(new C3179cf());
        this.f18459f.add(new C3182ci());
        this.f18459f.add(new C3183cj());
        this.f18459f.add(new C3186cm());
        this.f18459f.add(new C3184ck());
        Collections.sort(this.f18459f, new Comparator<AbstractC3187d>(this) { // from class: ru.maximoff.apktool.util.c.ah.2

            /* renamed from: a */
            private final AsyncTaskC3127ah f18461a;

            {
                this.f18461a = this;
            }

            @Override // java.util.Comparator
            public int compare(AbstractC3187d abstractC3187d, AbstractC3187d abstractC3187d2) {
                return m19096a(abstractC3187d, abstractC3187d2);
            }

            /* renamed from: a */
            public int m19096a(AbstractC3187d abstractC3187d, AbstractC3187d abstractC3187d2) {
                return abstractC3187d.mo19085a().toLowerCase().compareTo(abstractC3187d2.mo19085a().toLowerCase());
            }
        });
        try {
            C2604w c2604w = new C2604w(fileArr[0]);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                C2602u nextElement = m16163b.nextElement();
                String name = nextElement.getName();
                if (name.equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                    c3163bq.m19103a(c2604w.m16160a(nextElement));
                }
                for (AbstractC3187d abstractC3187d : this.f18459f) {
                    if (!(abstractC3187d instanceof C3163bq)) {
                        abstractC3187d.mo19086a(name);
                    }
                }
            }
            c2604w.close();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (AbstractC3187d abstractC3187d2 : this.f18459f) {
            if (!(abstractC3187d2 instanceof C3163bq)) {
                if (abstractC3187d2 instanceof C3150bd) {
                    z = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3155bi) {
                    z2 = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3146b) {
                    z3 = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3129aj) {
                    z4 = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3130ak) {
                    z5 = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3131al) {
                    z6 = abstractC3187d2.mo19087b();
                } else if (abstractC3187d2 instanceof C3132am) {
                    z7 = abstractC3187d2.mo19087b();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (AbstractC3187d abstractC3187d3 : this.f18459f) {
            if (!(abstractC3187d3 instanceof C3163bq)) {
                boolean mo19087b = abstractC3187d3.mo19087b();
                if (abstractC3187d3 instanceof C3166bt) {
                    mo19087b = mo19087b && !z;
                } else if (abstractC3187d3 instanceof C3156bj) {
                    mo19087b = mo19087b && !z2;
                } else if (abstractC3187d3 instanceof C3173c) {
                    mo19087b = mo19087b && !z3;
                } else if (abstractC3187d3 instanceof C3131al) {
                    mo19087b = (!mo19087b || z4 || z5) ? false : true;
                } else if (abstractC3187d3 instanceof C3132am) {
                    mo19087b = (!mo19087b || z4 || z5 || z6) ? false : true;
                } else if (abstractC3187d3 instanceof C3133an) {
                    mo19087b = (!mo19087b || z4 || z5 || z6 || z7) ? false : true;
                }
                if (mo19087b && !arrayList.contains(abstractC3187d3.mo19085a())) {
                    arrayList.add(abstractC3187d3.mo19085a());
                }
            }
        }
        if (this.f18455b && !arrayList.contains(c3162bp.mo19085a()) && c3163bq.mo19087b()) {
            arrayList.add(c3163bq.mo19085a());
        }
        String str = (String) null;
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new Comparator<String>(this) { // from class: ru.maximoff.apktool.util.c.ah.3

                /* renamed from: a */
                private final AsyncTaskC3127ah f18462a;

                {
                    this.f18462a = this;
                }

                @Override // java.util.Comparator
                public int compare(String str2, String str3) {
                    return m19097a(str2, str3);
                }

                /* renamed from: a */
                public int m19097a(String str2, String str3) {
                    return str2.toLowerCase().compareTo(str3.toLowerCase());
                }
            });
            return C3080al.m18538a(arrayList, ", ");
        }
        return str;
    }

    /* renamed from: a */
    protected void m19094a(String str) {
        try {
            if (this.f18458e != null) {
                this.f18458e.removeCallbacksAndMessages((Object) null);
            }
            if (!isCancelled()) {
                if (str != null) {
                    C3112bn.m19009a(this.f18457d, str);
                    this.f18457d.setOnClickListener(new AnonymousClass4(this, str));
                } else {
                    this.f18457d.setText(this.f18456c.getString(R.string.f21469no).toLowerCase());
                }
                this.f18457d.setOnLongClickListener(new AnonymousClass5(this));
            }
        } catch (Error e2) {
        } catch (Exception e3) {
        }
    }

    /* compiled from: DetectProtect.java */
    /* renamed from: ru.maximoff.apktool.util.c.ah$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a */
        private final AsyncTaskC3127ah f18463a;

        /* renamed from: b */
        private final String f18464b;

        AnonymousClass4(AsyncTaskC3127ah asyncTaskC3127ah, String str) {
            this.f18463a = asyncTaskC3127ah;
            this.f18464b = str;
        }

        /* renamed from: a */
        static AsyncTaskC3127ah m19098a(AnonymousClass4 anonymousClass4) {
            return anonymousClass4.f18463a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String stringBuffer;
            String str2;
            int m18905a = C3102bd.m18905a(this.f18463a.f18456c, "deprotect_server", 0);
            if (C3102bd.f18267C.equals("ru")) {
                str = "ru";
            } else {
                str = "com";
            }
            if (m18905a == 0) {
                stringBuffer = "<a href=\"https://www.google.com/search?q=%s\">%s</a>";
            } else {
                stringBuffer = new StringBuffer().append(new StringBuffer().append("<a href=\"https://yandex.").append(str).toString()).append("/search/?text=%s\">%s</a>").toString();
            }
            String[] split = this.f18464b.split(", ");
            StringBuilder sb = new StringBuilder();
            for (String str3 : split) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                try {
                    str2 = C3112bn.m18994a(str3);
                } catch (Exception e2) {
                    str2 = str3;
                }
                sb.append(String.format(stringBuffer, str2, str3));
            }
            new C3078aj(this.f18463a.f18456c).m18494a(R.string.protection).m18502b(this.f18463a.f18456c.getString(R.string.protection_info, sb.toString()).replace("\n", "<br/>")).m18506d(R.string.f21470ok).m18505c(R.string.cp_name, new Runnable(this, this.f18464b) { // from class: ru.maximoff.apktool.util.c.ah.4.1

                /* renamed from: a */
                private final AnonymousClass4 f18465a;

                /* renamed from: b */
                private final String f18466b;

                {
                    this.f18465a = this;
                    this.f18466b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(AnonymousClass4.m19098a(this.f18465a).f18456c, this.f18466b);
                }
            }).m18497a(true).m18507d();
        }
    }

    /* compiled from: DetectProtect.java */
    /* renamed from: ru.maximoff.apktool.util.c.ah$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnLongClickListener {

        /* renamed from: a */
        private final AsyncTaskC3127ah f18467a;

        AnonymousClass5(AsyncTaskC3127ah asyncTaskC3127ah) {
            this.f18467a = asyncTaskC3127ah;
        }

        /* renamed from: a */
        static AsyncTaskC3127ah m19099a(AnonymousClass5 anonymousClass5) {
            return anonymousClass5.f18467a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            String str;
            String stringBuffer;
            String str2;
            int m18905a = C3102bd.m18905a(this.f18467a.f18456c, "deprotect_server", 0);
            if (C3102bd.f18267C.equals("ru")) {
                str = "ru";
            } else {
                str = "com";
            }
            if (m18905a == 0) {
                stringBuffer = "<a href=\"https://www.google.com/search?q=%s\">%s</a>";
            } else {
                stringBuffer = new StringBuffer().append(new StringBuffer().append("<a href=\"https://yandex.").append(str).toString()).append("/search/?text=%s\">%s</a>").toString();
            }
            String string = this.f18467a.f18456c.getString(R.string.dot);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < this.f18467a.f18459f.size(); i++) {
                AbstractC3187d abstractC3187d = (AbstractC3187d) this.f18467a.f18459f.get(i);
                if (!(abstractC3187d instanceof C3203t) && !(abstractC3187d instanceof C3130ak) && !(abstractC3187d instanceof C3131al) && !(abstractC3187d instanceof C3132am) && !(abstractC3187d instanceof C3133an) && !(abstractC3187d instanceof C3135ap) && !(abstractC3187d instanceof C3172bz)) {
                    if (i > 0) {
                        sb.append("<br/>");
                        sb2.append("\n");
                    }
                    sb.append(string).append(" ");
                    sb2.append(string).append(" ");
                    String mo19085a = abstractC3187d.mo19085a();
                    try {
                        str2 = C3112bn.m18994a(mo19085a);
                    } catch (Exception e2) {
                        str2 = mo19085a;
                    }
                    sb.append(String.format(stringBuffer, str2, mo19085a));
                    sb2.append(mo19085a);
                }
            }
            C3078aj m18497a = new C3078aj(this.f18467a.f18456c).m18494a(R.string.minfo).m18502b(sb.toString()).m18506d(R.string.f21470ok).m18505c(R.string.copy, new Runnable(this, sb2) { // from class: ru.maximoff.apktool.util.c.ah.5.1

                /* renamed from: a */
                private final AnonymousClass5 f18468a;

                /* renamed from: b */
                private final StringBuilder f18469b;

                {
                    this.f18468a = this;
                    this.f18469b = sb2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(AnonymousClass5.m19099a(this.f18468a).f18456c, this.f18469b.toString());
                }
            }).m18497a(true);
            m18497a.m18501b(R.string.server, new AnonymousClass2(this, m18497a));
            m18497a.m18507d();
            return true;
        }

        /* compiled from: DetectProtect.java */
        /* renamed from: ru.maximoff.apktool.util.c.ah$5$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            private final AnonymousClass5 f18470a;

            /* renamed from: b */
            private final C3078aj f18471b;

            AnonymousClass2(AnonymousClass5 anonymousClass5, C3078aj c3078aj) {
                this.f18470a = anonymousClass5;
                this.f18471b = c3078aj;
            }

            /* renamed from: a */
            static AnonymousClass5 m19100a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f18470a;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18471b.m18498a();
                int m18905a = C3102bd.m18905a(AnonymousClass5.m19099a(this.f18470a).f18456c, "deprotect_server", 0);
                new DialogInterfaceC0070b.a(AnonymousClass5.m19099a(this.f18470a).f18456c).m418a(R.string.server).m430a(new String[]{AnonymousClass5.m19099a(this.f18470a).f18456c.getString(R.string.mtr_google), AnonymousClass5.m19099a(this.f18470a).f18456c.getString(R.string.mtr_yandex)}, m18905a != 0 ? 1 : 0, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.c.ah.5.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f18472a;

                    {
                        this.f18472a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18935b(AnonymousClass5.m19099a(AnonymousClass2.m19100a(this.f18472a)).f18456c, "deprotect_server", i);
                        dialogInterface.cancel();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f18458e != null) {
            this.f18458e.removeCallbacksAndMessages((Object) null);
        }
        super.onCancelled();
    }

    /* renamed from: b */
    protected void m19095b(String str) {
        if (this.f18458e != null) {
            this.f18458e.removeCallbacksAndMessages((Object) null);
        }
        super.onCancelled(str);
    }
}
