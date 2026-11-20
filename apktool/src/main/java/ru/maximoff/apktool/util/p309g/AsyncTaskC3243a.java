package ru.maximoff.apktool.util.p309g;

import android.content.Context;
import android.p008os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.p209io.BufferedReader;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ChangelogTask.java */
/* renamed from: ru.maximoff.apktool.util.g.a */
/* loaded from: classes.dex */
public class AsyncTaskC3243a extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private final String[] f19486a;

    /* renamed from: b */
    private Context f19487b;

    /* renamed from: c */
    private int f19488c;

    /* renamed from: d */
    private boolean f19489d;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(Void[] voidArr) {
        return m19459a(voidArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19460a(str);
    }

    public AsyncTaskC3243a(Context context, int i) {
        this(context, i, false);
    }

    public AsyncTaskC3243a(Context context, int i, boolean z) {
        this.f19486a = new String[]{"ar", "bg", "cs", "de", "el", "es", "en", "fa", "fr", "he", "in", "it", "iw", "ko", "lt", "my", "pt", "ro", "ru", "sq", "tr", "uk", "vi", "zh", "hu", "pl", "uz", "ja"};
        this.f19487b = context;
        this.f19488c = i;
        this.f19489d = z;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x017d: MOVE (r6 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:90:0x017c */
    /* renamed from: a */
    protected String m19459a(Void... voidArr) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        if (!C3080al.m18605i(this.f19487b)) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader4 = (BufferedReader) null;
        try {
            try {
                try {
                    String m18600g = C3080al.m18600g(this.f19487b);
                    if (!C3080al.m18585b(this.f19486a, m18600g)) {
                        m18600g = "en";
                    }
                    httpURLConnection = (HttpURLConnection) new URL(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("updates/update_").toString()).append(m18600g).toString()).append(".json?t=").toString()).append(System.currentTimeMillis()).toString()).openConnection();
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                    httpURLConnection.setRequestProperty("User-Agent", new StringBuffer().append(C3102bd.f18289Y).append(" #Changelog").toString());
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
    protected void m19460a(String str) {
        try {
            if (str != null) {
                String m15617f = new C2468c(str).m15617f("changes");
                new C3078aj(this.f19487b).m18497a(true).m18494a(R.string.mchanges).m18502b(m15617f.replace("\n", "<br>")).m18505c(R.string.copy, new Runnable(this, m15617f) { // from class: ru.maximoff.apktool.util.g.a.1

                    /* renamed from: a */
                    private final AsyncTaskC3243a f19490a;

                    /* renamed from: b */
                    private final String f19491b;

                    {
                        this.f19490a = this;
                        this.f19491b = m15617f;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C3112bn.m19002a(this.f19490a.f19487b, this.f19491b);
                    }
                }).m18506d(R.string.close_cur).m18507d();
            } else {
                C3112bn.m19023b(this.f19487b, this.f19487b.getString(R.string.error));
            }
        } catch (C2467b e2) {
            if (!this.f19489d) {
                try {
                    new AsyncTaskC3243a(this.f19487b, this.f19488c, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f19487b, R.string.error_try_again);
                    return;
                }
            }
            C3112bn.m19023b(this.f19487b, this.f19487b.getString(R.string.error));
        } catch (Exception e4) {
        }
    }
}
