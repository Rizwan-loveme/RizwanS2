package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.icu.text.DateFormat;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: RefreshRes.java */
/* renamed from: ru.maximoff.apktool.e.ak */
/* loaded from: classes.dex */
public class AsyncTaskC2909ak extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15244a;

    /* renamed from: b */
    private boolean f15245b;

    /* renamed from: c */
    private boolean f15246c;

    /* renamed from: d */
    private List<C3090av> f15247d;

    /* renamed from: e */
    private List<C3090av> f15248e;

    /* renamed from: f */
    private List<String> f15249f;

    /* renamed from: g */
    private String[] f15250g;

    public AsyncTaskC2909ak(Context context, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15244a = context;
        this.f15245b = false;
        this.f15246c = false;
        this.f15250g = context.getResources().getStringArray(R.array.refresh_res);
        this.f15249f = new ArrayList();
    }

    /* renamed from: g */
    public void m17232g(boolean z) {
        this.f15245b = z;
    }

    /* renamed from: h */
    public void m17233h(boolean z) {
        this.f15246c = z;
    }

    /* renamed from: a */
    public void m17229a(List<String> list) {
        this.f15249f.addAll(list);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (C3102bd.m18925a(this.f15244a, "ongoing_notification", true)) {
            m17054a(this.f15244a.getString(mo17065c()), "refresh_task");
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        int i;
        try {
            mo3984d(R.string.mplease_wait, (Object) null);
            int i2 = 0;
            File file = new File(fileArr[0], "res");
            if (!file.isDirectory()) {
                mo3979a(R.string.file_not_found, file.getAbsolutePath());
                return new Boolean(false);
            }
            if (this.f15245b) {
                mo3984d(R.string.text, this.f15250g[0]);
                i2 = C3061a.m18289a(file, this);
            }
            if (this.f15246c) {
                File file2 = new File(file, "/values/public.xml");
                if (!file2.isFile()) {
                    mo3979a(R.string.file_not_found, file2.getAbsolutePath());
                    return new Boolean(false);
                }
                mo3984d(R.string.text, this.f15250g[1]);
                if (!this.f15249f.isEmpty()) {
                    mo3984d(R.string.type, C3080al.m18538a(this.f15249f, ", "));
                }
                List<C3090av> m18326d = C3061a.m18326d(file2);
                ArrayList arrayList = new ArrayList();
                int i3 = i2;
                for (String str : m17228b(m18326d)) {
                    List<C3090av> m17224a = m17224a(m18326d, str);
                    if (str.equals("id")) {
                        arrayList.addAll(m17224a);
                    } else if (!this.f15249f.isEmpty() && !this.f15249f.contains(str)) {
                        arrayList.addAll(m17224a);
                    } else {
                        List<C3090av> m17222a = m17222a(file, m17224a, str);
                        for (C3090av c3090av : m17224a) {
                            if (!m17222a.contains(c3090av)) {
                                mo3984d(R.string.res_removed, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(c3090av.m18724a()).toString()).append("/").toString()).append(c3090av.m18727b()).toString());
                                i3++;
                            } else {
                                arrayList.add(c3090av);
                            }
                        }
                    }
                }
                if (m18326d.size() > arrayList.size()) {
                    C3061a.m18310a(file2, arrayList, true, (String) null, (String) null);
                }
                i = i3;
            } else {
                i = i2;
            }
            if (i == 0) {
                mo3984d(R.string.not_found, (Object) null);
            }
            return new Boolean(true);
        } catch (Error e2) {
            mo3979a(R.string.errorf, e2.toString());
            return new Boolean(false);
        } catch (Exception e3) {
            mo3979a(R.string.errorf, e3.toString());
            return new Boolean(false);
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        C2978b.f16135a.m17721k();
        if (C3102bd.m18925a(this.f15244a, "build_notification", true)) {
            m17072f(bool.booleanValue());
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.refresh_res;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        return false;
    }

    /* renamed from: a */
    private File[] m17226a(File file, String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.e.ak.1

            /* renamed from: a */
            private final AsyncTaskC2909ak f15251a;

            {
                this.f15251a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && file2.getName().startsWith("values");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                File file3 = new File(file2, new StringBuffer().append(new StringBuffer().append(str).append(str.endsWith(DateFormat.SECOND) ? "" : DateFormat.SECOND).toString()).append(".xml").toString());
                if (file3.isFile()) {
                    arrayList.add(file3);
                }
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    private List<C3090av> m17222a(File file, List<C3090av> list, String str) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(C3102bd.f18297ae);
        List<C3090av> m17223a = m17223a(file, list, str, newFixedThreadPool);
        List<C3090av> m17227b = m17227b(file, list, str, newFixedThreadPool);
        newFixedThreadPool.shutdown();
        do {
        } while (!newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
        return (m17223a.size() == list.size() || m17227b.size() == list.size()) ? list : m17225a(m17223a, m17227b);
    }

    /* renamed from: a */
    private List<C3090av> m17225a(List<C3090av> list, List<C3090av> list2) {
        for (C3090av c3090av : list2) {
            if (!list.contains(c3090av)) {
                list.add(c3090av);
            }
        }
        return list;
    }

    /* renamed from: b */
    private List<String> m17228b(List<C3090av> list) {
        ArrayList arrayList = new ArrayList();
        for (C3090av c3090av : list) {
            if (!arrayList.contains(c3090av.m18724a())) {
                arrayList.add(c3090av.m18724a());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C3090av> m17224a(List<C3090av> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (C3090av c3090av : list) {
            if (c3090av.m18724a().equals(str)) {
                arrayList.add(c3090av);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C3090av> m17223a(File file, List<C3090av> list, String str, ExecutorService executorService) {
        this.f15247d = Collections.synchronizedList(new ArrayList());
        File[] m17226a = m17226a(file, str);
        if (m17226a.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= m17226a.length) {
                    break;
                }
                executorService.submit(new a(this, m17226a[i2], list, this, true));
                i = i2 + 1;
            }
        }
        return this.f15247d;
    }

    /* renamed from: b */
    private List<C3090av> m17227b(File file, List<C3090av> list, String str, ExecutorService executorService) {
        this.f15248e = Collections.synchronizedList(new ArrayList());
        File[] listFiles = file.listFiles(new FileFilter(this, str) { // from class: ru.maximoff.apktool.e.ak.2

            /* renamed from: a */
            private final AsyncTaskC2909ak f15252a;

            /* renamed from: b */
            private final String f15253b;

            {
                this.f15252a = this;
                this.f15253b = str;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && file2.getName().startsWith(this.f15253b);
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                executorService.submit(new a(this, file2, list, this, false));
            }
        }
        return this.f15248e;
    }

    /* renamed from: a */
    public void m17230a(C3090av c3090av) {
        this.f15247d.add(c3090av);
    }

    /* renamed from: b */
    public void m17231b(C3090av c3090av) {
        this.f15248e.add(c3090av);
    }

    /* compiled from: RefreshRes.java */
    /* renamed from: ru.maximoff.apktool.e.ak$a */
    private class a implements Runnable {

        /* renamed from: a */
        private File f15254a;

        /* renamed from: b */
        private List<C3090av> f15255b;

        /* renamed from: c */
        private AsyncTaskC2909ak f15256c;

        /* renamed from: d */
        private boolean f15257d;

        /* renamed from: e */
        private final AsyncTaskC2909ak f15258e;

        public a(AsyncTaskC2909ak asyncTaskC2909ak, File file, List<C3090av> list, AsyncTaskC2909ak asyncTaskC2909ak2, boolean z) {
            this.f15258e = asyncTaskC2909ak;
            this.f15254a = file;
            this.f15255b = list;
            this.f15256c = asyncTaskC2909ak2;
            this.f15257d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15257d) {
                for (String str : C3061a.m18331h(this.f15254a)) {
                    for (C3090av c3090av : this.f15255b) {
                        if (str.contains(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(c3090av.m18724a()).toString()).append(" name=\"").toString()).append(c3090av.m18727b()).toString()).append("\"").toString()) || str.contains(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("-").append(c3090av.m18724a()).toString()).append(" name=\"").toString()).append(c3090av.m18727b()).toString()).append("\"").toString()) || str.contains(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<item type=\"").append(c3090av.m18724a()).toString()).append("\" name=\"").toString()).append(c3090av.m18727b()).toString()).append("\"").toString())) {
                            this.f15256c.m17230a(c3090av);
                        }
                    }
                }
                return;
            }
            for (C3090av c3090av2 : this.f15255b) {
                File[] listFiles = this.f15254a.listFiles(new FileFilter(this, c3090av2.m18727b()) { // from class: ru.maximoff.apktool.e.ak.a.1

                    /* renamed from: a */
                    private final a f15259a;

                    /* renamed from: b */
                    private final String f15260b;

                    {
                        this.f15259a = this;
                        this.f15260b = r2;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file) {
                        return file.isFile() && (file.getName().startsWith(new StringBuffer().append(this.f15260b).append(".").toString()) || file.getName().equals(this.f15260b));
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    this.f15256c.m17231b(c3090av2);
                }
            }
        }
    }
}
