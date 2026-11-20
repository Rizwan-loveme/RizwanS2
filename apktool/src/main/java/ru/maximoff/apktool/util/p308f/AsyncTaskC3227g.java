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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: GoogleTranslateWeb.java */
/* renamed from: ru.maximoff.apktool.util.f.g */
/* loaded from: classes.dex */
public class AsyncTaskC3227g extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19338a;

    /* renamed from: b */
    private String f19339b;

    /* renamed from: c */
    private String f19340c;

    /* renamed from: d */
    private String f19341d;

    /* renamed from: e */
    private String f19342e;

    /* renamed from: h */
    private C3237q.a f19345h;

    /* renamed from: f */
    private int f19343f = 0;

    /* renamed from: g */
    private boolean f19344g = false;

    /* renamed from: i */
    private Map<String, String> f19346i = new HashMap();

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19335a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19337a(str);
    }

    public AsyncTaskC3227g(Context context, String str, String str2, String str3, String str4, C3237q.a aVar) {
        this.f19338a = context;
        this.f19339b = str3;
        this.f19340c = str;
        this.f19341d = str2;
        this.f19342e = str4;
        this.f19345h = aVar;
    }

    /* renamed from: a */
    public void m19339a(boolean z) {
        if (this.f19340c.equals("auto")) {
            return;
        }
        this.f19344g = z;
    }

    /* renamed from: a */
    public void m19338a(Map<String, String> map) {
        this.f19346i = map;
    }

    /* renamed from: a */
    public void m19336a(int i) {
        this.f19343f = i;
    }

    /* renamed from: a */
    private String m19334a() {
        try {
            C2466a c2466a = new C2466a();
            c2466a.m15572a(0, this.f19339b);
            c2466a.m15572a(1, this.f19344g ? "auto" : this.f19340c);
            c2466a.m15572a(2, this.f19341d);
            c2466a.m15573a(3, true);
            C2466a c2466a2 = new C2466a();
            c2466a2.m15572a(0, (Object) null);
            C2466a c2466a3 = new C2466a();
            c2466a3.m15572a(0, c2466a);
            c2466a3.m15572a(1, c2466a2);
            C2466a c2466a4 = new C2466a();
            c2466a4.m15572a(0, "MkEWBc");
            c2466a4.m15572a(1, c2466a3.toString());
            c2466a4.m15572a(2, (Object) null);
            c2466a4.m15572a(3, "generic");
            C2466a c2466a5 = new C2466a();
            c2466a5.m15572a(0, c2466a4);
            C2466a c2466a6 = new C2466a();
            c2466a6.m15572a(0, c2466a5);
            return c2466a6.toString();
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String m19335a(String... strArr) {
        BufferedReader bufferedReader;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader2 = (BufferedReader) null;
        try {
            String m19334a = m19334a();
            if (m19334a == null) {
                String str = (String) null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return str;
            }
            this.f19346i.put("_reqid", String.valueOf(C3080al.m18520a(100000, 999999)));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.f19346i.entrySet()) {
                arrayList.add(new StringBuffer().append(new StringBuffer().append(entry.getKey()).append("=").toString()).append(entry.getValue()).toString());
            }
            byte[] bytes = new StringBuffer().append("f.req=").append(C3112bn.m18994a(m19334a)).toString().getBytes("UTF-8");
            httpURLConnection = (HttpURLConnection) new URL(new StringBuffer().append("https://translate.google.com/_/TranslateWebserverUi/data/batchexecute?").append(C3080al.m18538a(arrayList, "&")).toString()).openConnection();
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f19342e);
            httpURLConnection.setRequestProperty("X-Same-Domain", "1");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            if (this.f19346i.get("cookies") != null) {
                httpURLConnection.setRequestProperty("Cookie", this.f19346i.get("cookies"));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bytes);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream == null) {
                String str2 = (String) null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return str2;
            }
            BufferedReader bufferedReader3 = "gzip".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine).append("\n");
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            e.printStackTrace();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return (String) null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (httpURLConnection != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                }
                inputStream.close();
                if (stringBuffer.length() == 0) {
                    String str3 = (String) null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return str3;
                }
                String stringBuffer2 = stringBuffer.toString();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                return stringBuffer2;
            } catch (Exception e9) {
                e = e9;
                bufferedReader = bufferedReader3;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader3;
            }
        } catch (Exception e10) {
            e = e10;
            bufferedReader = bufferedReader2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void m19337a(String str) {
        C2466a c2466a;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19345h.mo16858a();
            return;
        }
        if (str == null) {
            this.f19345h.mo16861b(this.f19338a.getString(R.string.mtr_invalid_res));
            this.f19345h.mo16858a();
            return;
        }
        try {
            if (str.length() > 0) {
                String str2 = "";
                String[] split = str.split("\n", 4);
                try {
                    c2466a = new C2466a(split[3].substring(0, Integer.parseInt(split[2], 10) - 2));
                } catch (Exception e2) {
                    c2466a = new C2466a(C3080al.m18540a((String[]) Arrays.copyOfRange(split, 2, split.length), ""));
                }
                C2466a m15576c = c2466a.m15576c(0);
                if (m15576c.m15580g(1) || m15576c.m15580g(2) || !m15576c.m15579f(1).equals("MkEWBc")) {
                    if (this.f19343f < 3) {
                        this.f19343f++;
                        AsyncTaskC3227g asyncTaskC3227g = new AsyncTaskC3227g(this.f19338a, this.f19340c, this.f19341d, this.f19339b, this.f19342e, this.f19345h);
                        asyncTaskC3227g.m19338a(this.f19346i);
                        asyncTaskC3227g.m19339a(this.f19344g);
                        asyncTaskC3227g.m19336a(this.f19343f);
                        asyncTaskC3227g.execute(new String[0]);
                        return;
                    }
                    this.f19345h.mo16861b("error in response");
                    return;
                }
                C2466a c2466a2 = new C2466a(m15576c.m15579f(2));
                String m15579f = c2466a2.m15579f(2);
                if (this.f19344g && !C3112bn.m19040o(m15579f) && !this.f19340c.equalsIgnoreCase(m15579f)) {
                    this.f19345h.mo16860b();
                    return;
                }
                C2466a m15576c2 = c2466a2.m15576c(1).m15576c(0).m15576c(0);
                if (m15576c2.m15569a() > 5 && !m15576c2.m15580g(5)) {
                    C2466a m15576c3 = m15576c2.m15576c(5);
                    int i = 0;
                    while (i < m15576c3.m15569a()) {
                        C2466a m15576c4 = m15576c3.m15576c(i);
                        if (i > 0 && !str2.endsWith("\n")) {
                            str2 = new StringBuffer().append(str2).append(" ").toString();
                        }
                        i++;
                        str2 = new StringBuffer().append(str2).append(m15576c4.m15579f(0)).toString();
                    }
                    this.f19345h.mo16859a(str2);
                    return;
                }
                this.f19345h.mo16859a(m15576c2.m15579f(0));
                return;
            }
            this.f19345h.mo16861b(this.f19338a.getString(R.string.mtr_invalid_res));
        } catch (Exception e3) {
            this.f19345h.mo16861b(e3.getMessage());
        }
    }
}
