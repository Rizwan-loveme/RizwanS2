package ru.maximoff.apktool.util.p308f;

import android.p008os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
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
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: SmaliParser.java */
/* renamed from: ru.maximoff.apktool.util.f.o */
/* loaded from: classes.dex */
public class AsyncTaskC3235o extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private TranslateActivity f19393a;

    /* renamed from: b */
    private DialogInterfaceC0070b f19394b;

    /* renamed from: c */
    private List<C3236p> f19395c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private File f19396d;

    /* renamed from: e */
    private String[] f19397e;

    @Override // android.p008os.AsyncTask
    protected String doInBackground(String[] strArr) {
        return m19363a(strArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(String str) {
        m19364a(str);
    }

    public AsyncTaskC3235o(TranslateActivity translateActivity, File file, String[] strArr) {
        this.f19393a = translateActivity;
        this.f19396d = file;
        this.f19397e = strArr;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        View inflate = this.f19393a.getLayoutInflater().inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f19394b = new DialogInterfaceC0070b.a(this.f19393a).m435b(inflate).m429a(false).m438b();
        this.f19394b.show();
    }

    /* renamed from: a */
    protected String m19363a(String[] strArr) {
        File[] listFiles;
        if (this.f19397e != null && this.f19397e.length > 0) {
            File[] fileArr = new File[this.f19397e.length];
            for (int i = 0; i < this.f19397e.length; i++) {
                fileArr[i] = new File(this.f19396d, this.f19397e[i]);
            }
            listFiles = fileArr;
        } else {
            listFiles = this.f19396d.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.util.f.o.1

                /* renamed from: a */
                private final AsyncTaskC3235o f19398a;

                {
                    this.f19398a = this;
                }

                @Override // java.p209io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && file.getName().startsWith("smali");
                }
            });
        }
        if (listFiles == null || listFiles.length == 0) {
            return (String) null;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18297ae);
        for (File file : listFiles) {
            m19360a(file, newFixedThreadPool);
        }
        newFixedThreadPool.shutdown();
        do {
        } while (!newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
        return (String) null;
    }

    /* renamed from: a */
    protected void m19364a(String str) {
        super.onPostExecute(str);
        if (this.f19394b != null && this.f19394b.isShowing()) {
            try {
                this.f19394b.cancel();
            } catch (Exception e2) {
            }
        }
        this.f19393a.m16841a(this.f19395c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19362a(C3236p c3236p) {
        this.f19395c.add(c3236p);
    }

    /* renamed from: a */
    private void m19360a(File file, ExecutorService executorService) {
        File[] listFiles = file.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.f.o.2

            /* renamed from: a */
            private final AsyncTaskC3235o f19399a;

            {
                this.f19399a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(".smali");
            }
        });
        File[] listFiles2 = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.util.f.o.3

            /* renamed from: a */
            private final AsyncTaskC3235o f19400a;

            {
                this.f19400a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                executorService.submit(new a(this, file2, this));
            }
        }
        if (listFiles2 == null || listFiles2.length <= 0) {
            return;
        }
        for (File file3 : listFiles2) {
            m19360a(file3, executorService);
        }
    }

    /* compiled from: SmaliParser.java */
    /* renamed from: ru.maximoff.apktool.util.f.o$a */
    private class a implements Runnable {

        /* renamed from: a */
        private final Pattern f19401a = Pattern.compile("^\\s+?const-string(?:\\/jumbo)? [pv]{1}\\d+, \"(.+?)\"$");

        /* renamed from: b */
        private File f19402b;

        /* renamed from: c */
        private AsyncTaskC3235o f19403c;

        /* renamed from: d */
        private final AsyncTaskC3235o f19404d;

        public a(AsyncTaskC3235o asyncTaskC3235o, File file, AsyncTaskC3235o asyncTaskC3235o2) {
            this.f19404d = asyncTaskC3235o;
            this.f19402b = file;
            this.f19403c = asyncTaskC3235o2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String group;
            String group2;
            List<String> m18331h = C3061a.m18331h(this.f19402b);
            for (int i = 0; i < m18331h.size(); i++) {
                Matcher matcher = this.f19401a.matcher(m18331h.get(i));
                if (matcher.find()) {
                    try {
                        group = C3112bn.m19038m(matcher.group(0));
                        group2 = C3112bn.m19038m(matcher.group(1));
                    } catch (Exception e2) {
                        group = matcher.group(0);
                        group2 = matcher.group(1);
                    }
                    C3236p c3236p = new C3236p(group, group2);
                    c3236p.m19379d(true);
                    c3236p.m19368a(this.f19402b);
                    c3236p.m19367a(i);
                    this.f19403c.m19362a(c3236p);
                }
            }
        }
    }
}
