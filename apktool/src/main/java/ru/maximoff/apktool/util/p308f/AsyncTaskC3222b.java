package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import org.p270e.C2466a;
import org.p270e.C2468c;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3237q;

/* compiled from: DeepL2Translate.java */
/* renamed from: ru.maximoff.apktool.util.f.b */
/* loaded from: classes.dex */
public class AsyncTaskC3222b extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f19308a;

    /* renamed from: b */
    private String f19309b;

    /* renamed from: c */
    private String f19310c;

    /* renamed from: d */
    private String f19311d;

    /* renamed from: e */
    private String f19312e;

    /* renamed from: f */
    private String f19313f;

    /* renamed from: g */
    private boolean f19314g = false;

    /* renamed from: h */
    private boolean f19315h = false;

    /* renamed from: i */
    private boolean f19316i = false;

    /* renamed from: j */
    private C3237q.a f19317j;

    @Override // android.os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19310a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(String str) {
        m19311a(str);
    }

    public AsyncTaskC3222b(Context context, String str, String str2, String str3, String str4, String str5, C3237q.a aVar) {
        this.f19308a = context;
        this.f19309b = str3;
        this.f19310c = str;
        this.f19311d = str2;
        this.f19313f = str4;
        this.f19312e = str5;
        this.f19317j = aVar;
    }

    /* renamed from: a */
    public void m19312a(boolean z) {
        if (this.f19310c.equals("auto")) {
            return;
        }
        this.f19316i = z;
    }

    /* renamed from: a */
    protected String m19310a(String... strArr) {
        Throwable th;
        Exception e2;
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            return (String) null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        BufferedReader bufferedReader = (BufferedReader) null;
        try {
            try {
                C2468c m19309a = m19309a(this.f19309b, this.f19316i ? "auto" : this.f19310c, this.f19311d, (String) null, (String) null);
                URL url = new URL(this.f19313f.endsWith(":fx") ? "https://api-free.deepl.com/v2/translate" : "https://api.deepl.com/v2/translate");
                byte[] bytes = m19309a.toString().getBytes("UTF-8");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    try {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                        httpURLConnection2.setRequestProperty("Authorization", new StringBuffer().append("DeepL-Auth-Key ").append(this.f19313f).toString());
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
                        httpURLConnection2.setRequestProperty("User-Agent", this.f19312e);
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setConnectTimeout(6000);
                        httpURLConnection2.setReadTimeout(10000);
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.getOutputStream().write(bytes);
                        httpURLConnection2.connect();
                        if (httpURLConnection2.getResponseCode() == 429) {
                            this.f19314g = true;
                            String str = (String) null;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader == null) {
                                return str;
                            }
                            try {
                                bufferedReader.close();
                                return str;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return str;
                            }
                        }
                        if (httpURLConnection2.getResponseCode() == 456) {
                            this.f19315h = true;
                            String str2 = (String) null;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader == null) {
                                return str2;
                            }
                            try {
                                bufferedReader.close();
                                return str2;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return str2;
                            }
                        }
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        if (inputStream == null) {
                            String str3 = (String) null;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader == null) {
                                return str3;
                            }
                            try {
                                bufferedReader.close();
                                return str3;
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                return str3;
                            }
                        }
                        BufferedReader bufferedReader2 = "gzip".equals(httpURLConnection2.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : "br".equals(httpURLConnection2.getContentEncoding()) ? new BufferedReader(new InputStreamReader(new C1900b(inputStream))) : new BufferedReader(new InputStreamReader(inputStream));
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
                            String str4 = (String) null;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader2 == null) {
                                return str4;
                            }
                            try {
                                bufferedReader2.close();
                                return str4;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return str4;
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
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
                    } catch (Exception e8) {
                        e2 = e8;
                        httpURLConnection = httpURLConnection2;
                        e2.printStackTrace();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e9) {
                                e9.printStackTrace();
                            }
                        }
                        return (String) null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e2 = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    protected void m19311a(String str) {
        if (TranslateActivity.m16820o() != null && TranslateActivity.m16820o().f14497h) {
            this.f19317j.mo16858a();
            return;
        }
        if (str == null) {
            if (this.f19314g) {
                this.f19317j.mo16861b(this.f19308a.getString(R.string.mtr_deepl_warn));
                this.f19317j.mo16858a();
                return;
            } else if (this.f19315h) {
                this.f19317j.mo16861b(this.f19308a.getString(R.string.mtr_deepl_key_warn));
                this.f19317j.mo16858a();
                return;
            } else {
                this.f19317j.mo16861b(this.f19308a.getString(R.string.mtr_invalid_res));
                this.f19317j.mo16858a();
                return;
            }
        }
        try {
            if (str.length() > 0) {
                C2466a m15615d = new C2468c(str).m15615d("translations");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < m15615d.m15569a(); i++) {
                    sb.append(m15615d.m15577d(i).m15617f("text"));
                    String m15617f = m15615d.m15577d(i).m15617f("detected_source_language");
                    if (this.f19316i && !C3112bn.m19040o(m15617f) && !this.f19310c.equalsIgnoreCase(m15617f)) {
                        this.f19317j.mo16860b();
                        return;
                    }
                }
                this.f19317j.mo16859a(sb.toString());
                return;
            }
            this.f19317j.mo16861b(this.f19308a.getString(R.string.mtr_invalid_res));
        } catch (Exception e2) {
            this.f19317j.mo16861b(e2.getMessage());
        }
    }

    /* renamed from: a */
    private C2468c m19309a(String str, String str2, String str3, String str4, String str5) {
        C2466a c2466a = new C2466a();
        c2466a.m15574a(str);
        C2468c c2468c = new C2468c();
        c2468c.m15608a("text", c2466a);
        c2468c.m15608a("target_lang", (Object) str3.toUpperCase());
        if (!"auto".equalsIgnoreCase(str2)) {
            c2468c.m15608a("source_lang", (Object) str2.toUpperCase());
        }
        if (str4 != null) {
            c2468c.m15608a("context", (Object) str4);
        }
        if (str5 != null) {
            c2468c.m15608a("formality", (Object) str5);
        }
        return c2468c;
    }
}
