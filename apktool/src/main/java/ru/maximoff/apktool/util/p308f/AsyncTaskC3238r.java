package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import ru.maximoff.apktool.TranslateActivity;

/* compiled from: TranslateOptions.java */
/* renamed from: ru.maximoff.apktool.util.f.r */
/* loaded from: classes.dex */
public class AsyncTaskC3238r extends AsyncTask<String, String, Boolean> {

    /* renamed from: d */
    private Context f19436d;

    /* renamed from: e */
    private String f19437e;

    /* renamed from: g */
    private a f19439g;

    /* renamed from: a */
    private final int f19433a = 3;

    /* renamed from: b */
    private final int f19434b = 1;

    /* renamed from: c */
    private String f19435c = "www.bing.com";

    /* renamed from: f */
    private Map<String, String> f19438f = new LinkedHashMap();

    /* renamed from: h */
    private int f19440h = -1;

    /* renamed from: i */
    private boolean f19441i = false;

    /* compiled from: TranslateOptions.java */
    /* renamed from: ru.maximoff.apktool.util.f.r$a */
    public interface a {
        /* renamed from: a */
        void mo16855a();

        /* renamed from: a */
        void mo16856a(String str);

        /* renamed from: a */
        void mo16857a(Map<String, String> map);
    }

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m19406a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m19408a(bool);
    }

    public AsyncTaskC3238r(Context context, String str) {
        this.f19436d = context;
        this.f19437e = str;
    }

    /* renamed from: a */
    public void m19407a(int i) {
        this.f19440h = i;
    }

    /* renamed from: a */
    public void m19410a(boolean z) {
        this.f19441i = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Boolean m19406a(String... strArr) {
        String stringBuffer;
        if (!this.f19441i && TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return new Boolean(false);
        }
        switch (this.f19440h) {
            case 1:
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer append = new StringBuffer().append("https://");
                String str = this.f19435c;
                stringBuffer = stringBuffer2.append(append.append(str).toString()).append("/translator").toString();
                break;
            case 2:
            default:
                return new Boolean(true);
            case 3:
                stringBuffer = "https://translate.google.com/?hl=en-US";
                break;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader2 = (BufferedReader) null;
        try {
            StringBuilder sb = new StringBuilder();
            httpURLConnection = (HttpURLConnection) new URL(stringBuffer).openConnection();
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f19437e);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    HttpCookie httpCookie = HttpCookie.parse(list.get(i)).get(0);
                    if (i > 0) {
                        sb.append(";");
                    }
                    sb.append(new StringBuffer().append(new StringBuffer().append(httpCookie.getName()).append("=").toString()).append(httpCookie.getValue()).toString());
                }
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream == null) {
                return (Boolean) null;
            }
            bufferedReader2 = "gzip".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer3 = new StringBuffer();
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer3.append(readLine).append("\n");
            }
            inputStream.close();
            if (stringBuffer3.length() == 0) {
                return new Boolean(false);
            }
            String stringBuffer4 = stringBuffer3.toString();
            switch (this.f19440h) {
                case 1:
                    this.f19438f.put("IG", m19405b("IG:\"([^\"]+)\"", stringBuffer4));
                    this.f19438f.put("IID", m19405b("<div id=\"rich_tta\" data-iid=\"([^\"]+)\"", stringBuffer4));
                    try {
                        C2466a c2466a = new C2466a(m19405b("params_AbusePreventionHelper = (\\[[^\\]]+\\]);", stringBuffer4));
                        this.f19438f.put("token", String.valueOf(c2466a.m15579f(1)));
                        this.f19438f.put("key", String.valueOf(c2466a.m15578e(0)));
                        break;
                    } catch (Exception e4) {
                        this.f19438f.put("token", "");
                        this.f19438f.put("key", "");
                        break;
                    }
                case 3:
                    this.f19438f.put("rpcids", "MkEWBc");
                    this.f19438f.put("f.sid", m19404a("FdrFJe", stringBuffer4));
                    this.f19438f.put("bl", m19404a("cfb2h", stringBuffer4));
                    this.f19438f.put("hl", "en");
                    this.f19438f.put("soc-app", "1");
                    this.f19438f.put("soc-platform", "1");
                    this.f19438f.put("soc-device", "2");
                    this.f19438f.put("source-path", "/");
                    this.f19438f.put("rt", "c");
                    break;
            }
            this.f19438f.put("cookies", sb.toString());
            return new Boolean(true);
        } catch (Exception e6) {
            e6.printStackTrace();
            return new Boolean(false);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    protected void m19408a(Boolean bool) {
        if (!this.f19441i && TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19439g.mo16855a();
        } else if (!bool.booleanValue()) {
            this.f19439g.mo16856a(this.f19436d.getString(R.string.mtr_net_err));
        } else {
            this.f19439g.mo16857a(this.f19438f);
        }
    }

    /* renamed from: a */
    private String m19404a(String str, String str2) {
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("\"").append(str).toString()).append("\":\"([^\"]+)\"").toString()).matcher(str2);
        return !matcher.find() ? "" : matcher.group(1);
    }

    /* renamed from: b */
    private String m19405b(String str, String str2) {
        Matcher matcher = Pattern.compile(str).matcher(str2);
        return !matcher.find() ? "" : matcher.group(1);
    }

    /* renamed from: a */
    public void m19409a(a aVar) {
        this.f19439g = aVar;
    }
}
