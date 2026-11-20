package ru.maximoff.apktool.util.p309g;

import android.content.Context;
import android.os.AsyncTask;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: UpdaterTask.java */
/* renamed from: ru.maximoff.apktool.util.g.c */
/* loaded from: classes.dex */
public class AsyncTaskC3245c extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private final String[] f19493a;

    /* renamed from: b */
    private final String[] f19494b;

    /* renamed from: c */
    private Context f19495c;

    /* renamed from: d */
    private int f19496d;

    /* renamed from: e */
    private boolean f19497e;

    /* renamed from: f */
    private boolean f19498f;

    @Override // android.os.AsyncTask
    protected String doInBackground(Void[] voidArr) {
        return m19466a(voidArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19467a(str);
    }

    public AsyncTaskC3245c(Context context, int i, boolean z) {
        this(context, i, z, false);
    }

    public AsyncTaskC3245c(Context context, int i, boolean z, boolean z2) {
        this.f19493a = new String[]{"ar", "bg", "cs", "de", "el", "es", "en", "fa", "fr", "he", "in", "it", "iw", "ko", "lt", "my", "pt", "ro", "ru", "sq", "tr", "uk", "vi", "zh", "hu", "pl", "uz", "ja"};
        this.f19494b = new String[]{"arm64-v8a", "armeabi-v7a", "x86", "x86_64"};
        this.f19495c = context;
        this.f19496d = i;
        this.f19497e = z;
        this.f19498f = z2;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x017d: MOVE (r6 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:90:0x017c */
    /* renamed from: a */
    protected String m19466a(Void... voidArr) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        if (!C3080al.m18605i(this.f19495c)) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader4 = (BufferedReader) null;
        try {
            try {
                try {
                    String m18600g = C3080al.m18600g(this.f19495c);
                    if (!C3080al.m18585b(this.f19493a, m18600g)) {
                        m18600g = "en";
                    }
                    httpURLConnection = (HttpURLConnection) new URL(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("updates/update_").toString()).append(m18600g).toString()).append(".json?t=").toString()).append(System.currentTimeMillis()).toString()).openConnection();
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                    httpURLConnection.setRequestProperty("User-Agent", new StringBuffer().append(C3102bd.f18289Y).append(" #Updater").toString());
                    httpURLConnection.setConnectTimeout(6000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream == null) {
                        String str = (String) null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader4 != null) {
                            try {
                                bufferedReader4.close();
                            } catch (IOException e2) {
                            }
                        }
                        return str;
                    }
                    bufferedReader3 = "gzip".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine).append("\n");
                        }
                        inputStream.close();
                        if (stringBuffer.length() == 0) {
                            String str2 = (String) null;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (bufferedReader3 == null) {
                                return str2;
                            }
                            try {
                                bufferedReader3.close();
                                return str2;
                            } catch (IOException e3) {
                                return str2;
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader3 == null) {
                            return stringBuffer2;
                        }
                        try {
                            bufferedReader3.close();
                            return stringBuffer2;
                        } catch (IOException e4) {
                            return stringBuffer2;
                        }
                    } catch (IOException e5) {
                        String str3 = (String) null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader3 == null) {
                            return str3;
                        }
                        try {
                            bufferedReader3.close();
                            return str3;
                        } catch (IOException e6) {
                            return str3;
                        }
                    }
                } catch (IOException e7) {
                    bufferedReader3 = bufferedReader4;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader2 == null) {
                    throw th;
                }
                try {
                    bufferedReader2.close();
                    throw th;
                } catch (IOException e8) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
        }
    }

    /* renamed from: a */
    protected void m19467a(String str) {
        String str2;
        try {
            if (str != null) {
                C3102bd.m18936b(this.f19495c, "update_last_time", System.currentTimeMillis());
                C2468c c2468c = new C2468c(str);
                int m15612c = c2468c.m15612c("build");
                if (m15612c <= this.f19496d) {
                    if (!this.f19497e) {
                        C3112bn.m19023b(this.f19495c, this.f19495c.getString(R.string.mupdate_notf));
                        return;
                    }
                    return;
                }
                if (!this.f19497e || C3102bd.m18905a(this.f19495c, "update_skip", 0) != m15612c) {
                    if (C3080al.m18585b(this.f19494b, C3102bd.f18268D)) {
                        str2 = new StringBuffer().append("_").append(C3102bd.f18268D).toString();
                    } else {
                        str2 = "";
                    }
                    String m15617f = c2468c.m15617f("name");
                    String m15617f2 = c2468c.m15617f("date");
                    String m15617f3 = c2468c.m15617f(new StringBuffer().append("size").append(str2).toString());
                    String m15617f4 = c2468c.m15617f("changes");
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/").toString()).append(m15617f).toString()).append(str2).toString()).append(".apk").toString();
                    C3078aj m18508e = new C3078aj(this.f19495c).m18497a(true).m18502b(this.f19495c.getString(R.string.mupdate_message, m15617f, m15617f2, m15617f3, m15617f4.replace("\n", "<br>"))).m18506d(R.string.mupdate_get).m18508e(R.string.cancel);
                    if (this.f19497e) {
                        m18508e.m18505c(R.string.not_remind, new Runnable(this, m15612c) { // from class: ru.maximoff.apktool.util.g.c.1

                            /* renamed from: a */
                            private final AsyncTaskC3245c f19499a;

                            /* renamed from: b */
                            private final int f19500b;

                            {
                                this.f19499a = this;
                                this.f19500b = m15612c;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C3102bd.m18935b(this.f19499a.f19495c, "update_skip", this.f19500b);
                            }
                        });
                    }
                    m18508e.m18507d();
                    m18508e.m18503c().setOnClickListener(new AnonymousClass2(this, stringBuffer, m15617f, str2, m18508e));
                    return;
                }
                return;
            }
            if (!this.f19497e) {
                C3112bn.m19023b(this.f19495c, this.f19495c.getString(R.string.mupdate_error));
            }
        } catch (C2467b e2) {
            if (!this.f19498f) {
                try {
                    new AsyncTaskC3245c(this.f19495c, this.f19496d, this.f19497e, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f19495c, R.string.error_try_again);
                }
            } else if (!this.f19497e) {
                C3112bn.m19023b(this.f19495c, this.f19495c.getString(R.string.mupdate_error));
            }
        } catch (Exception e4) {
        }
    }

    /* compiled from: UpdaterTask.java */
    /* renamed from: ru.maximoff.apktool.util.g.c$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a */
        private final AsyncTaskC3245c f19501a;

        /* renamed from: b */
        private final String f19502b;

        /* renamed from: c */
        private final String f19503c;

        /* renamed from: d */
        private final String f19504d;

        /* renamed from: e */
        private final C3078aj f19505e;

        AnonymousClass2(AsyncTaskC3245c asyncTaskC3245c, String str, String str2, String str3, C3078aj c3078aj) {
            this.f19501a = asyncTaskC3245c;
            this.f19502b = str;
            this.f19503c = str2;
            this.f19504d = str3;
            this.f19505e = c3078aj;
        }

        /* renamed from: a */
        static AsyncTaskC3245c m19468a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f19501a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            C0173ao c0173ao = new C0173ao(this.f19501a.f19495c, view);
            if (C3102bd.m18910a(this.f19501a.f19495c, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            c0173ao.m1339a().add(0, 3100, 0, this.f19501a.f19495c.getString(R.string.mupdate_down)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19502b, this.f19503c, this.f19504d, this.f19505e) { // from class: ru.maximoff.apktool.util.g.c.2.1

                /* renamed from: a */
                private final AnonymousClass2 f19506a;

                /* renamed from: b */
                private final String f19507b;

                /* renamed from: c */
                private final String f19508c;

                /* renamed from: d */
                private final String f19509d;

                /* renamed from: e */
                private final C3078aj f19510e;

                {
                    this.f19506a = this;
                    this.f19507b = r2;
                    this.f19508c = r3;
                    this.f19509d = r4;
                    this.f19510e = r5;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3244b.m19462a(AnonymousClass2.m19468a(this.f19506a).f19495c, this.f19507b, new StringBuffer().append(new StringBuffer().append(this.f19508c).append(this.f19509d).toString()).append(".apk").toString(), C3102bd.f18289Y, AnonymousClass2.m19468a(this.f19506a).f19496d);
                    C3112bn.m18999a(AnonymousClass2.m19468a(this.f19506a).f19495c, R.string.down_started);
                    this.f19510e.m18498a();
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 3101, 0, this.f19501a.f19495c.getString(R.string.mupdate_inbrowser)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19502b, this.f19505e) { // from class: ru.maximoff.apktool.util.g.c.2.2

                /* renamed from: a */
                private final AnonymousClass2 f19511a;

                /* renamed from: b */
                private final String f19512b;

                /* renamed from: c */
                private final C3078aj f19513c;

                {
                    this.f19511a = this;
                    this.f19512b = r2;
                    this.f19513c = r3;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3080al.m18595e(AnonymousClass2.m19468a(this.f19511a).f19495c, this.f19512b);
                    this.f19513c.m18498a();
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 3102, 0, this.f19501a.f19495c.getString(R.string.mgithub)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19505e) { // from class: ru.maximoff.apktool.util.g.c.2.3

                /* renamed from: a */
                private final AnonymousClass2 f19514a;

                /* renamed from: b */
                private final C3078aj f19515b;

                {
                    this.f19514a = this;
                    this.f19515b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3080al.m18595e(AnonymousClass2.m19468a(this.f19514a).f19495c, "https://github.com/Maximoff/Apktool-M-updates");
                    this.f19515b.m18498a();
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 3103, 0, this.f19501a.f19495c.getString(R.string.telegram)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19505e) { // from class: ru.maximoff.apktool.util.g.c.2.4

                /* renamed from: a */
                private final AnonymousClass2 f19516a;

                /* renamed from: b */
                private final C3078aj f19517b;

                {
                    this.f19516a = this;
                    this.f19517b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3080al.m18595e(AnonymousClass2.m19468a(this.f19516a).f19495c, "https://t.me/s/apktool_m");
                    this.f19517b.m18498a();
                    return true;
                }
            });
            c0173ao.m1344c();
        }
    }
}
