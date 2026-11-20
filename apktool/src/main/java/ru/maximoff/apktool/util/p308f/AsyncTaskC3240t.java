package ru.maximoff.apktool.util.p308f;

import android.p008os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.TranslateActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: XmlParser.java */
/* renamed from: ru.maximoff.apktool.util.f.t */
/* loaded from: classes.dex */
public class AsyncTaskC3240t extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19462a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19463b;

    /* renamed from: c */
    private List<C3236p> f19464c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private File f19465d;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19443a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19444a(str);
    }

    public AsyncTaskC3240t(TranslateActivity translateActivity, File file) {
        this.f19462a = translateActivity;
        this.f19465d = file;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        View inflate = this.f19462a.getLayoutInflater().inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19463b = new DialogInterfaceC0070b.a(this.f19462a).m435b(inflate).m429a(false).m438b();
        this.f19463b.show();
    }

    /* renamed from: a */
    protected String m19443a(String[] strArr) {
        File file = new File(this.f19465d, "res");
        File file2 = new File(this.f19465d, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        if (!file.isDirectory() && !file2.isFile()) {
            return (String) null;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18297ae);
        m19440a(file, file2, newFixedThreadPool);
        newFixedThreadPool.shutdown();
        do {
        } while (!newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
        return (String) null;
    }

    /* renamed from: a */
    protected void m19444a(String str) {
        super.onPostExecute(str);
        if (this.f19463b != null && this.f19463b.isShowing()) {
            try {
                this.f19463b.cancel();
            } catch (Exception e2) {
            }
        }
        this.f19462a.m16841a(this.f19464c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19441a(C3236p c3236p) {
        this.f19464c.add(c3236p);
    }

    /* renamed from: a */
    private void m19440a(File file, File file2, ExecutorService executorService) {
        File[] fileArr;
        File[] listFiles = file.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.f.t.1

            /* renamed from: a */
            private final AsyncTaskC3240t f19466a;

            {
                this.f19466a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file3, String str) {
                return str.endsWith(".xml");
            }
        });
        File[] listFiles2 = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.util.f.t.2

            /* renamed from: a */
            private final AsyncTaskC3240t f19467a;

            {
                this.f19467a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file3) {
                return file3.isDirectory();
            }
        });
        if (file2 == null) {
            fileArr = listFiles;
        } else if (listFiles == null) {
            fileArr = new File[]{file2};
        } else {
            fileArr = C3080al.m18571a(listFiles, new File[]{file2});
        }
        if (fileArr != null && fileArr.length > 0) {
            for (File file3 : fileArr) {
                executorService.submit(new a(this, file3, this));
            }
        }
        if (listFiles2 == null || listFiles2.length <= 0) {
            return;
        }
        for (File file4 : listFiles2) {
            m19440a(file4, (File) null, executorService);
        }
    }

    /* compiled from: XmlParser.java */
    /* renamed from: ru.maximoff.apktool.util.f.t$a */
    private class a implements Runnable {

        /* renamed from: a */
        private final Pattern f19468a = Pattern.compile("^\\s+?([A-Za-z0-9_]+)\\:(text|title|label|contentDescription|hint|summary)=\"(?!(\\?|@))(.+?)\"\\s?(\\/>|>)?$");

        /* renamed from: b */
        private File f19469b;

        /* renamed from: c */
        private AsyncTaskC3240t f19470c;

        /* renamed from: d */
        private final AsyncTaskC3240t f19471d;

        public a(AsyncTaskC3240t asyncTaskC3240t, File file, AsyncTaskC3240t asyncTaskC3240t2) {
            this.f19471d = asyncTaskC3240t;
            this.f19469b = file;
            this.f19470c = asyncTaskC3240t2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> m18331h = C3061a.m18331h(this.f19469b);
            for (int i = 0; i < m18331h.size(); i++) {
                Matcher matcher = this.f19468a.matcher(m18331h.get(i));
                if (matcher.find()) {
                    C3236p c3236p = new C3236p(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(matcher.group(1)).append(":").toString()).append(matcher.group(2)).toString()).append("=\"").toString()).append(matcher.group(4)).toString()).append("\"").toString(), matcher.group(4), true);
                    c3236p.m19382e(matcher.group(0));
                    c3236p.m19368a(this.f19469b);
                    c3236p.m19367a(i);
                    this.f19470c.m19441a(c3236p);
                }
            }
        }
    }
}
