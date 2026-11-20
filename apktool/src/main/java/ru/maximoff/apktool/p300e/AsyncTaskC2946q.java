package ru.maximoff.apktool.p300e;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.p008os.AsyncTask;
import com.srizwan.apktool.R;
import java.net.HttpURLConnection;
import java.net.URL;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.p224c.p225a.C1900b;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.SettingActivity;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;

/* compiled from: DownloadAapts.java */
/* renamed from: ru.maximoff.apktool.e.q */
/* loaded from: classes.dex */
public class AsyncTaskC2946q extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: b */
    private ProgressDialog f15714b;

    /* renamed from: c */
    private Context f15715c;

    /* renamed from: d */
    private int f15716d;

    /* renamed from: e */
    private File f15717e;

    /* renamed from: f */
    private String f15718f;

    /* renamed from: g */
    private String f15719g;

    /* renamed from: h */
    private List<String> f15720h;

    /* renamed from: j */
    private StringBuilder f15722j;

    /* renamed from: a */
    private final String[] f15713a = {"https://raw.githubusercontent.com/Maximoff/binaries/master", "https://maximoff.su", "http://t3760571.beget.tech"};

    /* renamed from: i */
    private boolean f15721i = false;

    /* renamed from: k */
    private boolean f15723k = true;

    /* renamed from: l */
    private boolean f15724l = false;

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m17546a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17547a(bool);
    }

    @Override // android.p008os.AsyncTask
    protected void onProgressUpdate(Integer[] numArr) {
        m17549a(numArr);
    }

    public AsyncTaskC2946q(Context context, File file, String str) {
        this.f15715c = context;
        this.f15717e = file;
        this.f15719g = str;
        this.f15716d = C3102bd.m18905a(this.f15715c, "aapts_server", 0);
        if (this.f15716d > this.f15713a.length - 1) {
            this.f15716d = 0;
            C3102bd.m18935b(this.f15715c, "aapts_server", this.f15716d);
        }
        this.f15722j = new StringBuilder();
        this.f15720h = new ArrayList();
        this.f15714b = new ProgressDialog(context);
        this.f15714b.setMessage(context.getString(R.string.mplease_wait));
        this.f15714b.setIndeterminate(true);
        this.f15714b.setProgressStyle(1);
        this.f15714b.setCancelable(false);
        this.f15714b.setButton(this.f15715c.getString(R.string.cancel), new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.e.q.1

            /* renamed from: a */
            private final AsyncTaskC2946q f15725a;

            {
                this.f15725a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f15725a.cancel(true);
                dialogInterface.dismiss();
            }
        });
        this.f15714b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.e.q.2

            /* renamed from: a */
            private final AsyncTaskC2946q f15726a;

            {
                this.f15726a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f15726a.cancel(true);
            }
        });
        this.f15717e.mkdir();
    }

    /* renamed from: a */
    public void m17548a(boolean z) {
        this.f15721i = z;
    }

    /* renamed from: b */
    public void m17550b(boolean z) {
        this.f15723k = z;
    }

    /* renamed from: c */
    public void m17551c(boolean z) {
        this.f15724l = z;
    }

    /* renamed from: a */
    protected Boolean m17546a(String... strArr) {
        boolean z = true;
        for (String str : strArr) {
            this.f15718f = str;
            if (!m17540a(new StringBuffer().append(new StringBuffer().append(this.f15713a[this.f15716d]).append(this.f15719g).toString()).append(str).toString())) {
                this.f15720h.add(str);
                z = false;
            }
        }
        return new Boolean(z);
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f15714b.show();
    }

    /* renamed from: a */
    protected void m17549a(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f15718f != null) {
            this.f15714b.setMessage(this.f15715c.getString(R.string.file_download, this.f15718f));
        }
        this.f15714b.setIndeterminate(false);
        this.f15714b.setMax(numArr[1].intValue() / 1024);
        this.f15714b.setProgress(numArr[0].intValue() / 1024);
    }

    /* renamed from: a */
    protected void m17547a(Boolean bool) {
        if (this.f15715c instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) this.f15715c;
            if (mainActivity.isFinishing() || mainActivity.isDestroyed() || mainActivity.m16634p()) {
                m17542b(this.f15722j.toString());
                return;
            }
        } else if (this.f15715c instanceof SettingActivity) {
            SettingActivity settingActivity = (SettingActivity) this.f15715c;
            if (settingActivity.isFinishing() || settingActivity.isDestroyed() || settingActivity.m16699a()) {
                m17542b(this.f15722j.toString());
                return;
            }
        }
        if (this.f15714b != null && this.f15714b.isShowing()) {
            try {
                this.f15714b.cancel();
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            C3102bd.m18938b(this.f15715c, "load_aapts_dialog", false);
            new C3078aj(this.f15715c).m18494a(R.string.success).m18496a(this.f15722j.toString()).m18506d(R.string.f21470ok).m18507d();
            if (this.f15721i) {
                C3102bd.m18914a(this.f15715c);
            }
        } else {
            new C3078aj(this.f15715c).m18494a(R.string.error).m18496a(this.f15722j.toString()).m18506d(R.string.f21470ok).m18505c(R.string.repeat, new Runnable(this) { // from class: ru.maximoff.apktool.e.q.3

                /* renamed from: a */
                private final AsyncTaskC2946q f15727a;

                {
                    this.f15727a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AsyncTaskC2946q asyncTaskC2946q = new AsyncTaskC2946q(this.f15727a.f15715c, this.f15727a.f15717e, this.f15727a.f15719g);
                    asyncTaskC2946q.m17548a(this.f15727a.f15721i);
                    try {
                        asyncTaskC2946q.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) this.f15727a.f15720h.toArray(new String[this.f15727a.f15720h.size()]));
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f15727a.f15715c, R.string.error_try_again);
                    }
                }
            }).m18507d();
        }
        super.onPostExecute(bool);
    }

    @Override // android.p008os.AsyncTask
    protected void onCancelled() {
        C3112bn.m18999a(this.f15715c, R.string.cancel);
        super.onCancelled();
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02da, code lost:
    
        if (r14.f15718f.equals("aapt2") == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02dc, code lost:
    
        ru.maximoff.apktool.util.C3102bd.f18278N = r2.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02cd, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02ce, code lost:
    
        r4 = r1;
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x019c, code lost:
    
        r14.f15722j.append(new java.lang.StringBuffer().append(new java.lang.StringBuffer().append(r14.f15718f).append(": ").toString()).append(r4.toString()).toString()).append("\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01d5, code lost:
    
        if (r5.exists() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01d7, code lost:
    
        r5.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01db, code lost:
    
        if (r6 != null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01e0, code lost:
    
        if (r7 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e2, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01e5, code lost:
    
        if (r3 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01e7, code lost:
    
        r3.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01dd, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02fa, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0166, code lost:
    
        if (isCancelled() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016c, code lost:
    
        if (r5.exists() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016e, code lost:
    
        r5.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0171, code lost:
    
        if (r6 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0176, code lost:
    
        if (r7 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0178, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017b, code lost:
    
        if (r3 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017d, code lost:
    
        r3.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0180, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0173, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0241, code lost:
    
        if (r14.f15724l == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0247, code lost:
    
        if (r8.exists() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0249, code lost:
    
        r8.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x024c, code lost:
    
        r5.renameTo(r8);
        r14.f15722j.append(r14.f15715c.getString(com.srizwan.apktool.R.string.download_success, r14.f15718f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x027d, code lost:
    
        if (r8.exists() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x027f, code lost:
    
        r8.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0286, code lost:
    
        if (r9.exists() == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0288, code lost:
    
        r9.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028d, code lost:
    
        if (r14.f15723k != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x028f, code lost:
    
        r5.renameTo(r8);
        r2 = new java.p209io.File(r14.f15717e, r14.f15718f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x029c, code lost:
    
        r2.setExecutable(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02a7, code lost:
    
        if (r14.f15718f.equals("aapt") == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02a9, code lost:
    
        ru.maximoff.apktool.util.C3102bd.f18321d = r2.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02af, code lost:
    
        r14.f15722j.append(r14.f15715c.getString(com.srizwan.apktool.R.string.download_success, r14.f15718f)).append("\n");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m17540a(String str) {
        File file;
        File file2;
        OutputStream outputStream;
        InputStream inputStream;
        if (!C3080al.m18605i(this.f15715c)) {
            this.f15722j.append(new StringBuffer().append(new StringBuffer().append(this.f15718f).append(": ").toString()).append(this.f15715c.getString(R.string.mtr_net_err)).toString()).append("\n");
            return false;
        }
        InputStream inputStream2 = (InputStream) null;
        OutputStream outputStream2 = (OutputStream) null;
        HttpURLConnection httpURLConnection = (HttpURLConnection) null;
        File file3 = new File(this.f15717e, new StringBuffer().append(this.f15718f).append("_usr").toString());
        if (this.f15724l) {
            file = new File(this.f15717e, "1.tmp");
            file2 = new File(this.f15717e, "1.apk");
        } else {
            file = new File(this.f15717e, new StringBuffer().append(this.f15718f).append("_64").toString());
            file2 = new File(this.f15717e, this.f15718f);
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", C3102bd.f18289Y);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,br");
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                if (file.exists()) {
                    file.delete();
                }
                this.f15722j.append(new StringBuffer().append(new StringBuffer().append(this.f15718f).append(": response code ").toString()).append(httpURLConnection.getResponseCode()).toString()).append("\n");
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e2) {
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            }
            int contentLength = httpURLConnection.getContentLength();
            inputStream = "gzip".equals(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(httpURLConnection.getInputStream()) : "br".equals(httpURLConnection.getContentEncoding()) ? new C1900b(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
            try {
                outputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[C3249i.m19500a()];
                        int i = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            if (isCancelled()) {
                                inputStream.close();
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e3) {
                                        return false;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection == null) {
                                    return false;
                                }
                                httpURLConnection.disconnect();
                                return false;
                            }
                            i += read;
                            if (contentLength > 0) {
                                publishProgress(new Integer(i), new Integer(contentLength));
                            }
                            outputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                outputStream = outputStream2;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
            }
        } catch (Exception e7) {
            e = e7;
            outputStream = outputStream2;
            inputStream = inputStream2;
        } catch (Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            inputStream = inputStream2;
        }
    }

    /* renamed from: b */
    private void m17542b(String str) {
        if (this.f15721i) {
            C3102bd.m18914a(this.f15715c);
        }
        C3056b c3056b = new C3056b(this.f15715c);
        if (this.f15724l) {
            c3056b.m18194a(456);
            c3056b.m18197a("down_framework");
            c3056b.m18195a(this.f15715c.getText(R.string.man_frame), this.f15715c.getString(R.string.down_for, "SDK"));
            c3056b.m18192a(this.f15715c.getString(R.string.man_frame), str);
            return;
        }
        c3056b.m18194a(457);
        c3056b.m18197a("down_aapts");
        c3056b.m18195a(this.f15715c.getText(R.string.mtool_repl), this.f15715c.getText(R.string.mtool_repl_summary));
        c3056b.m18192a(this.f15715c.getString(R.string.mtool_repl), str);
    }
}
