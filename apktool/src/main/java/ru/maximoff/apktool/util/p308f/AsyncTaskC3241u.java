package ru.maximoff.apktool.util.p308f;

import android.app.slice.Slice;
import android.content.Context;
import android.os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import org.p270e.C2468c;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: YandexTranslate.java */
/* renamed from: ru.maximoff.apktool.util.f.u */
/* loaded from: classes.dex */
public class AsyncTaskC3241u extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19472a;

    /* renamed from: b */
    private String f19473b;

    /* renamed from: c */
    private String f19474c;

    /* renamed from: d */
    private String f19475d;

    /* renamed from: e */
    private String f19476e;

    /* renamed from: f */
    private boolean f19477f = false;

    /* renamed from: g */
    private C3237q.a f19478g;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19447a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19448a(str);
    }

    public AsyncTaskC3241u(Context context, String str, String str2, String str3, String str4, C3237q.a aVar) {
        this.f19472a = context;
        this.f19473b = str3;
        this.f19474c = str;
        this.f19475d = str2;
        this.f19476e = str4;
        this.f19478g = aVar;
    }

    /* renamed from: a */
    public void m19449a(boolean z) {
        if (this.f19474c.equals("auto")) {
            return;
        }
        this.f19477f = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x019a, code lost:
    
        r2 = (java.lang.String) null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019d, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x019f, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a2, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a4, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01e9, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01ea, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0141, code lost:
    
        r2 = (java.lang.String) null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0144, code lost:
    
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0146, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0149, code lost:
    
        if (r4 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014b, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0151, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0152, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String m19447a(String... strArr) {
        String str;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) null;
        BufferedReader bufferedReader = (BufferedReader) null;
        if (this.f19474c.equals("auto") || this.f19477f) {
            str = this.f19475d;
        } else {
            str = new StringBuffer().append(new StringBuffer().append(this.f19474c).append('-').toString()).append(this.f19475d).toString();
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = C3239s.m19416a(this.f19473b, 10000).iterator();
            while (it.hasNext()) {
                String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("srv=android&ucid=").append(m19445a()).toString()).append("&lang=").toString()).append(str).toString()).append("&text=").toString()).append(C3112bn.m18994a(it.next())).toString();
                URL url = new URL("https://translate.yandex.net/api/v1/tr.json/translate");
                byte[] bytes = stringBuffer.getBytes("UTF-8");
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
                httpURLConnection2.setDefaultUseCaches(false);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("User-Agent", this.f19476e);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setConnectTimeout(6000);
                httpURLConnection2.setReadTimeout(10000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.getOutputStream().write(bytes);
                httpURLConnection2.connect();
                InputStream inputStream = httpURLConnection2.getInputStream();
                if (inputStream == null) {
                    return (String) null;
                }
                bufferedReader = "gzip".equals(httpURLConnection2.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection2.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer2 = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer2.append(readLine).append("\n");
                }
                inputStream.close();
                if (stringBuffer2.length() == 0) {
                    return (String) null;
                }
                sb.append(stringBuffer2);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return (String) null;
        } finally {
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void m19448a(String str) {
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19478g.mo16858a();
            return;
        }
        if (str == null) {
            this.f19478g.mo16861b(this.f19472a.getString(R.string.mtr_invalid_res));
            this.f19478g.mo16858a();
            return;
        }
        try {
            C2468c c2468c = new C2468c(str);
            if (c2468c.m15612c("code") != 200) {
                this.f19478g.mo16861b(c2468c.m15617f(Slice.SUBTYPE_MESSAGE));
                return;
            }
            String m19446b = m19446b(c2468c.m15617f("lang"));
            if (this.f19477f && !C3112bn.m19040o(m19446b) && !this.f19474c.equalsIgnoreCase(m19446b)) {
                this.f19478g.mo16860b();
                return;
            }
            String str2 = "";
            C2466a m15615d = c2468c.m15615d("text");
            for (int i = 0; i < m15615d.m15569a(); i++) {
                str2 = new StringBuffer().append(str2).append(m15615d.m15579f(i)).toString();
            }
            if (str2.length() > 0) {
                this.f19478g.mo16859a(str2);
            } else {
                this.f19478g.mo16861b(this.f19472a.getString(R.string.mtr_invalid_res));
            }
        } catch (Exception e2) {
            this.f19478g.mo16861b(e2.getMessage());
        }
    }

    /* renamed from: a */
    private String m19445a() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /* renamed from: b */
    private String m19446b(String str) {
        try {
            return str.split("-")[0];
        } catch (Exception e2) {
            return (String) null;
        }
    }
}
