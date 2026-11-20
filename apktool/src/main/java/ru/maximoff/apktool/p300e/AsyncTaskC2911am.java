package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000a.p002b.p003a.p004a.InterfaceC0008c;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3247a;
import ru.maximoff.apktool.view.ZipViewer;
import ru.maximoff.p311b.C3317a;

/* compiled from: RepackZip.java */
/* renamed from: ru.maximoff.apktool.e.am */
/* loaded from: classes.dex */
public class AsyncTaskC2911am extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15267a;

    /* renamed from: b */
    private InterfaceC2995n f15268b;

    /* renamed from: c */
    private ZipViewer f15269c;

    /* renamed from: d */
    private int f15270d;

    /* renamed from: g */
    private DialogInterfaceC0070b f15273g;

    /* renamed from: e */
    private String f15271e = (String) null;

    /* renamed from: f */
    private boolean f15272f = false;

    /* renamed from: h */
    private List<String> f15274h = new ArrayList();

    /* renamed from: i */
    private List<C3247a> f15275i = new ArrayList();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17236a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17237a(bool);
    }

    public AsyncTaskC2911am(Context context, int i, InterfaceC2995n interfaceC2995n) {
        this.f15267a = context;
        this.f15270d = i;
        this.f15268b = interfaceC2995n;
    }

    /* renamed from: a */
    public void m17238a(List<String> list) {
        this.f15274h.addAll(list);
    }

    /* renamed from: b */
    public void m17241b(List<C3247a> list) {
        this.f15275i.addAll(list);
    }

    /* renamed from: a */
    public void m17240a(boolean z) {
        this.f15272f = z;
    }

    /* renamed from: a */
    public void m17239a(ZipViewer zipViewer) {
        this.f15269c = zipViewer;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15267a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15273g = new DialogInterfaceC0070b.a(this.f15267a).m435b(inflate).m429a(false).m438b();
        this.f15273g.show();
    }

    /* renamed from: a */
    protected Boolean m17236a(File[] fileArr) {
        int i;
        InterfaceC0008c interfaceC0008c;
        int i2 = 0;
        int i3 = 0;
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            try {
                try {
                    int[] iArr = new int[1];
                    boolean endsWith = file.getName().toLowerCase().endsWith(".apk");
                    if (endsWith) {
                        try {
                            iArr[0] = new C3081am(file).m18632h();
                        } catch (Exception e2) {
                            iArr[0] = 14;
                        }
                    } else {
                        iArr[0] = 14;
                    }
                    if (endsWith && this.f15270d == 0 && C3102bd.m18925a(this.f15267a, "save_sign_data", true)) {
                        interfaceC0008c = C3105bg.m18964a(file);
                    } else {
                        interfaceC0008c = (InterfaceC0008c) null;
                    }
                    File createTempFile = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                    File file2 = new File(new StringBuffer().append(file.getAbsolutePath()).append(".bak").toString());
                    file.renameTo(file2);
                    if (endsWith) {
                        File createTempFile2 = File.createTempFile("APKTOOL_M", ".unalign", C3102bd.m18908a());
                        C3117bs.m19066a(file2.getAbsolutePath(), createTempFile2.getAbsolutePath(), this.f15274h, this.f15275i, this.f15272f);
                        C3317a.m20052a(createTempFile2.getAbsolutePath(), createTempFile.getAbsolutePath());
                        createTempFile2.delete();
                    } else {
                        C3117bs.m19066a(file2.getAbsolutePath(), createTempFile.getAbsolutePath(), this.f15274h, this.f15275i, this.f15272f);
                    }
                    C2917as.m17314a(this.f15267a, this.f15270d, new C2917as.a(this, createTempFile, file, interfaceC0008c, iArr) { // from class: ru.maximoff.apktool.e.am.1

                        /* renamed from: a */
                        private final AsyncTaskC2911am f15276a;

                        /* renamed from: b */
                        private final File f15277b;

                        /* renamed from: c */
                        private final File f15278c;

                        /* renamed from: d */
                        private final InterfaceC0008c f15279d;

                        /* renamed from: e */
                        private final int[] f15280e;

                        {
                            this.f15276a = this;
                            this.f15277b = createTempFile;
                            this.f15278c = file;
                            this.f15279d = interfaceC0008c;
                            this.f15280e = iArr;
                        }

                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                        /* renamed from: a */
                        public void mo16440a(C2917as c2917as, boolean z) {
                            if (z) {
                                C3262u.m19612a(this.f15277b, this.f15278c);
                                if (this.f15279d != null) {
                                    try {
                                        C3105bg.m18967a(this.f15278c, this.f15279d);
                                    } catch (IOException e3) {
                                    }
                                }
                            } else {
                                c2917as.m17320a(this.f15277b, this.f15278c, this.f15280e[0]);
                            }
                            if (this.f15277b.exists()) {
                                this.f15277b.delete();
                            }
                        }
                    });
                    i = i3;
                } catch (Exception e3) {
                    i = i3 + 1;
                    this.f15271e = e3.getMessage();
                }
            } catch (Error e4) {
                i = i3 + 1;
                this.f15271e = e4.getMessage();
            }
            i2++;
            i3 = i;
        }
        return new Boolean(i3 == 0);
    }

    /* renamed from: a */
    protected void m17237a(Boolean bool) {
        if (this.f15273g != null && this.f15273g.isShowing()) {
            try {
                this.f15273g.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15268b != null) {
            this.f15268b.mo17929a();
        }
        if (this.f15271e != null) {
            C3112bn.m19023b(this.f15267a, this.f15267a.getString(R.string.errorf, this.f15271e));
        }
        if (this.f15274h.isEmpty() || this.f15269c == null) {
            return;
        }
        this.f15269c.m19795a();
    }
}
