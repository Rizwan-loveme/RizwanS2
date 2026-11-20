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
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: GoogleTranslate.java */
/* renamed from: ru.maximoff.apktool.util.f.f */
/* loaded from: classes.dex */
public class AsyncTaskC3226f extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19331a;

    /* renamed from: b */
    private String f19332b;

    /* renamed from: c */
    private String f19333c;

    /* renamed from: d */
    private String f19334d;

    /* renamed from: e */
    private String f19335e;

    /* renamed from: f */
    private boolean f19336f = false;

    /* renamed from: g */
    private C3237q.a f19337g;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19331a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19332a(str);
    }

    public AsyncTaskC3226f(Context context, String str, String str2, String str3, String str4, C3237q.a aVar) {
        this.f19331a = context;
        this.f19332b = str3;
        this.f19333c = str;
        this.f19334d = str2;
        this.f19335e = str4;
        this.f19337g = aVar;
    }

    /* renamed from: a */
    public void m19333a(boolean z) {
        if (this.f19333c.equals("auto")) {
            return;
        }
        this.f19336f = z;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0181: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:78:0x0181 */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String m19331a(String... strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader3 = (BufferedReader) null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("http://translate.googleapis.com/translate_a/single?client=gtx&dt=t").append("&sl=").toString()).append(this.f19336f ? "auto" : this.f19333c).toString()).append("&tl=").toString()).append(this.f19334d).toString()).append("&q=").toString()).append(C3112bn.m18994a(this.f19332b)).toString()).openConnection();
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("User-Agent", this.f19335e);
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(6000);
                httpURLConnection.setReadTimeout(10000);
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
    protected void m19332a(String str) {
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19337g.mo16858a();
            return;
        }
        if (str == null) {
            this.f19337g.mo16861b(this.f19331a.getString(R.string.mtr_invalid_res));
            this.f19337g.mo16858a();
            return;
        }
        try {
            if (str.length() > 0) {
                C2466a c2466a = new C2466a(str);
                String m15579f = c2466a.m15579f(2);
                if (this.f19336f && !C3112bn.m19040o(m15579f) && !this.f19333c.equalsIgnoreCase(m15579f)) {
                    this.f19337g.mo16860b();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                C2466a m15576c = c2466a.m15576c(0);
                for (int i = 0; i < m15576c.m15569a(); i++) {
                    sb.append(m15576c.m15576c(i).m15579f(0));
                }
                this.f19337g.mo16859a(sb.toString());
                return;
            }
            this.f19337g.mo16861b(this.f19331a.getString(R.string.mtr_invalid_res));
        } catch (Exception e2) {
            this.f19337g.mo16861b(e2.getMessage());
        }
    }
}
