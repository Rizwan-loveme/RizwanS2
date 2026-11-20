package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import org.p270e.C2468c;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: BingTranslate.java */
/* renamed from: ru.maximoff.apktool.util.f.a */
/* loaded from: classes.dex */
public class AsyncTaskC3221a extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19298a;

    /* renamed from: d */
    private String f19301d;

    /* renamed from: e */
    private String f19302e;

    /* renamed from: f */
    private String f19303f;

    /* renamed from: g */
    private String f19304g;

    /* renamed from: i */
    private C3237q.a f19306i;

    /* renamed from: b */
    private String f19299b = "www.bing.com";

    /* renamed from: c */
    private int f19300c = 1;

    /* renamed from: h */
    private boolean f19305h = false;

    /* renamed from: j */
    private Map<String, String> f19307j = new HashMap();

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19304a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19306a(str);
    }

    public AsyncTaskC3221a(Context context, String str, String str2, String str3, String str4, C3237q.a aVar) {
        this.f19298a = context;
        this.f19301d = str3;
        this.f19302e = str;
        this.f19303f = str2;
        this.f19304g = str4;
        this.f19306i = aVar;
    }

    /* renamed from: a */
    public void m19308a(boolean z) {
        if (this.f19302e.equals("auto-detect")) {
            return;
        }
        this.f19305h = z;
    }

    /* renamed from: a */
    public void m19307a(Map<String, String> map) {
        this.f19307j = map;
    }

    /* renamed from: a */
    public void m19305a(int i) {
        this.f19300c = i;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x02c8: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:81:0x02c8 */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String m19304a(String... strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader3 = (BufferedReader) null;
        try {
            try {
                byte[] bytes = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("fromLang=").append(this.f19305h ? "auto-detect" : this.f19302e).toString()).append("&text=").toString()).append(C3112bn.m18994a(this.f19301d)).toString()).append("&to=").toString()).append(this.f19303f).toString()).append("&token=").toString()).append(this.f19307j.get("token")).toString()).append("&key=").toString()).append(this.f19307j.get("key")).toString().getBytes("UTF-8");
                httpURLConnection = (HttpURLConnection) new URL(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("https://").append(this.f19299b).toString()).append("/ttranslatev3?isVertical=1&IG=").toString()).append(this.f19307j.get("IG")).toString()).append("&IID=").toString()).append(this.f19307j.get("IID")).toString()).append(".").toString()).append(this.f19300c).toString()).openConnection();
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("User-Agent", this.f19304g);
                httpURLConnection.setRequestProperty("Referer", new StringBuffer().append(new StringBuffer().append("https://").append(this.f19299b).toString()).append("/translator").toString());
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                if (this.f19307j.get("cookies") != null) {
                    httpURLConnection.setRequestProperty("Cookie", this.f19307j.get("cookies"));
                }
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(6000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(bytes);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream == null) {
                    String str = (String) null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return str;
                }
                bufferedReader = "gzip".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
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
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return str2;
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return stringBuffer2;
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return (String) null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = bufferedReader3;
            e.printStackTrace();
            if (httpURLConnection != null) {
            }
            if (bufferedReader != null) {
            }
            return (String) null;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection != null) {
            }
            if (bufferedReader3 != null) {
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void m19306a(String str) {
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19306i.mo16858a();
            return;
        }
        if (str == null) {
            this.f19306i.mo16861b(this.f19298a.getString(R.string.mtr_invalid_res));
            this.f19306i.mo16858a();
            return;
        }
        try {
            if (str.length() > 0) {
                C2468c m15577d = new C2466a(str).m15577d(0);
                String m19303a = m19303a(m15577d);
                if (this.f19305h && !C3112bn.m19040o(m19303a) && !this.f19302e.equalsIgnoreCase(m19303a)) {
                    this.f19306i.mo16860b();
                } else {
                    this.f19306i.mo16859a(m15577d.m15615d("translations").m15577d(0).m15617f("text"));
                }
            } else {
                this.f19306i.mo16861b(this.f19298a.getString(R.string.mtr_invalid_res));
            }
        } catch (Exception e2) {
            this.f19306i.mo16861b(e2.getMessage());
        }
    }

    /* renamed from: a */
    private String m19303a(C2468c c2468c) {
        try {
            return c2468c.m15616e("detectedLanguage").m15617f("language");
        } catch (Exception e2) {
            return (String) null;
        }
    }
}
