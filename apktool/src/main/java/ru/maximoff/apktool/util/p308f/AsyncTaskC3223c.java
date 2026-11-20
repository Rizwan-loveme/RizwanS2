package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.p008os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.p209io.BufferedReader;
import java.p209io.InputStream;
import java.p209io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import org.p270e.C2468c;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: DeepLTranslate.java */
/* renamed from: ru.maximoff.apktool.util.f.c */
/* loaded from: classes.dex */
public class AsyncTaskC3223c extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19318a;

    /* renamed from: b */
    private String f19319b;

    /* renamed from: c */
    private String f19320c;

    /* renamed from: d */
    private String f19321d;

    /* renamed from: e */
    private boolean f19322e = false;

    /* renamed from: f */
    private boolean f19323f = false;

    /* renamed from: g */
    private C3237q.a f19324g;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19319a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19320a(str);
    }

    public AsyncTaskC3223c(Context context, String str, String str2, String str3, C3237q.a aVar) {
        this.f19318a = context;
        this.f19319b = str3;
        this.f19320c = str;
        this.f19321d = str2;
        this.f19324g = aVar;
    }

    /* renamed from: a */
    public void m19321a(boolean z) {
        if (this.f19320c.equals("auto")) {
            return;
        }
        this.f19323f = z;
    }

    /* renamed from: a */
    protected String m19319a(String... strArr) {
        HttpURLConnection httpURLConnection;
        Exception e2;
        byte[] bytes;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) null;
        BufferedReader bufferedReader = (BufferedReader) null;
        try {
            try {
                long m19313a = m19313a();
                C2468c m19316a = m19316a(this.f19319b, this.f19323f ? "auto" : this.f19320c, this.f19321d, 0, m19313a);
                URL url = new URL("https://www2.deepl.com/jsonrpc");
                bytes = m19315a(m19316a, m19313a).getBytes("UTF-8");
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (Exception e3) {
                e2 = e3;
            }
            try {
                try {
                    m19317a(httpURLConnection);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(6000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.getOutputStream().write(bytes);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 429) {
                        this.f19322e = true;
                        String str = (String) null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader == null) {
                            return str;
                        }
                        try {
                            bufferedReader.close();
                            return str;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return str;
                        }
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream == null) {
                        String str2 = (String) null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader == null) {
                            return str2;
                        }
                        try {
                            bufferedReader.close();
                            return str2;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return str2;
                        }
                    }
                    BufferedReader bufferedReader2 = "gzip".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine).append("\n");
                    }
                    inputStream.close();
                    if (stringBuffer.length() == 0) {
                        String str3 = (String) null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader2 == null) {
                            return str3;
                        }
                        try {
                            bufferedReader2.close();
                            return str3;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return str3;
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader2 == null) {
                        return stringBuffer2;
                    }
                    try {
                        bufferedReader2.close();
                        return stringBuffer2;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        return stringBuffer2;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e2 = e9;
                httpURLConnection2 = httpURLConnection;
                e2.printStackTrace();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                return (String) null;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = httpURLConnection2;
        }
    }

    /* renamed from: a */
    protected void m19320a(String str) {
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19324g.mo16858a();
            return;
        }
        if (str == null) {
            if (this.f19322e) {
                this.f19324g.mo16861b(this.f19318a.getString(R.string.mtr_deepl_warn));
                this.f19324g.mo16858a();
                return;
            } else {
                this.f19324g.mo16861b(this.f19318a.getString(R.string.mtr_invalid_res));
                this.f19324g.mo16858a();
                return;
            }
        }
        try {
            if (str.length() > 0) {
                C2468c m15616e = new C2468c(str).m15616e("result");
                String m15617f = m15616e.m15617f("lang");
                if (this.f19323f && !C3112bn.m19040o(m15617f) && !this.f19320c.equalsIgnoreCase(m15617f)) {
                    this.f19324g.mo16860b();
                } else {
                    this.f19324g.mo16859a(m15616e.m15615d("texts").m15577d(0).m15617f("text"));
                }
            } else {
                this.f19324g.mo16861b(this.f19318a.getString(R.string.mtr_invalid_res));
            }
        } catch (Exception e2) {
            this.f19324g.mo16861b(e2.getMessage());
        }
    }

    /* renamed from: a */
    private String m19315a(C2468c c2468c, long j) {
        String c2468c2 = c2468c.toString();
        if ((5 + j) % 29 == 0 || (3 + j) % 13 == 0) {
            return c2468c2.replace("\"method\":\"", "\"method\" : \"");
        }
        return c2468c2.replace("\"method\":\"", "\"method\": \"");
    }

    /* renamed from: a */
    private C2468c m19316a(String str, String str2, String str3, int i, long j) {
        int m19318b = m19318b(str);
        int max = Math.max(Math.min(3, i), 0);
        C2468c c2468c = new C2468c();
        c2468c.m15608a("jsonrpc", (Object) "2.0");
        c2468c.m15608a("method", (Object) "LMT_handle_texts");
        c2468c.m15607a("id", j);
        C2468c c2468c2 = new C2468c();
        c2468c2.m15608a("text", (Object) str);
        c2468c2.m15606a("requestAlternatives", max);
        C2466a c2466a = new C2466a();
        c2466a.m15574a(c2468c2);
        C2468c c2468c3 = new C2468c();
        c2468c3.m15608a("source_lang_user_selected", (Object) str2.toUpperCase());
        c2468c3.m15608a("target_lang", (Object) str3.toUpperCase());
        C2468c c2468c4 = new C2468c();
        c2468c4.m15608a("texts", c2466a);
        c2468c4.m15608a("splitting", (Object) "newlines");
        c2468c4.m15608a("lang", c2468c3);
        c2468c4.m15607a("timestamp", m19314a(m19318b));
        c2468c.m15608a("params", c2468c4);
        return c2468c;
    }

    /* renamed from: b */
    private int m19318b(String str) {
        if (str == null) {
            str = "";
        }
        return str.split("i", -1).length - 1;
    }

    /* renamed from: a */
    private long m19313a() {
        return (C3080al.m18520a(0, 99999) + 8300000) * 1000;
    }

    /* renamed from: a */
    private long m19314a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i != 0) {
            int i2 = i + 1;
            return (currentTimeMillis - (currentTimeMillis % i2)) + i2;
        }
        return currentTimeMillis;
    }

    /* renamed from: a */
    private void m19317a(HttpURLConnection httpURLConnection) {
        for (String str : new String[]{"Accept: */*", "Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7,zh-HK;q=0.6,zh;q=0.5", "Authorization: None", "Cache-Control: no-cache", "Content-Type: application/json", "DNT: 1", "Origin: chrome-extension://cofdbpoegempjloogbagkncekinflcnj", "Pragma: no-cache", "Priority: u=1, i", "Referer: https://www.deepl.com/", "Sec-Fetch-Dest: empty", "Sec-Fetch-Mode: cors", "Sec-Fetch-Site: none", "Sec-GPC: 1", "User-Agent: DeepLBrowserExtension/1.28.0 Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36"}) {
            String[] split = str.split(": ", 2);
            httpURLConnection.setRequestProperty(split[0], split[1]);
        }
    }
}
