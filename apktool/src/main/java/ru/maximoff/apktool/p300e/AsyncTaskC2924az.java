package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: UnzipTask.java */
/* renamed from: ru.maximoff.apktool.e.az */
/* loaded from: classes.dex */
public class AsyncTaskC2924az extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Runnable f15467a;

    /* renamed from: b */
    private Context f15468b;

    /* renamed from: c */
    private File f15469c;

    /* renamed from: d */
    private List<String> f15470d;

    /* renamed from: e */
    private boolean f15471e;

    /* renamed from: f */
    private boolean f15472f;

    /* renamed from: g */
    private boolean f15473g;

    /* renamed from: h */
    private int f15474h;

    public AsyncTaskC2924az(Context context, File file) {
        this(context, file, new ArrayList(), (Runnable) null);
    }

    public AsyncTaskC2924az(Context context, File file, List<String> list, Runnable runnable) {
        super(context, (InterfaceC2995n) null);
        this.f15474h = -1;
        this.f15468b = context;
        this.f15470d = new ArrayList();
        this.f15470d.addAll(list);
        this.f15469c = file;
        this.f15467a = runnable;
        this.f15471e = false;
        this.f15472f = false;
        this.f15473g = false;
    }

    /* renamed from: a */
    public void m17379a(int i) {
        this.f15474h = i;
    }

    /* renamed from: g */
    public void m17380g(boolean z) {
        this.f15471e = z;
    }

    /* renamed from: h */
    public void m17381h(boolean z) {
        this.f15473g = z;
    }

    /* renamed from: i */
    public void m17382i(boolean z) {
        this.f15472f = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        mo3984d(R.string.extraction, file.getAbsolutePath());
        try {
            if (this.f15473g) {
                this.f15469c = m17378a(this.f15469c, (String) null, this);
            }
            C3117bs.m19064a(this.f15468b, file, this.f15469c, this.f15470d, this.f15471e, this.f15472f, (Map) null, this.f15474h);
            return true;
        } catch (Exception e2) {
            mo3980a(Level.WARNING, e2.getMessage(), e2);
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return false;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.extract;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (!bool.booleanValue() || this.f15467a == null) {
            return;
        }
        this.f15467a.run();
    }

    /* renamed from: a */
    private File m17378a(File file, String str, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String parent = file.getParent();
        if (str == null) {
            str = file.getName();
        }
        boolean m18925a = C3102bd.m18925a(this.f15468b, "all_to_out_dir", false);
        boolean z = !C3262u.m19664g(this.f15468b, file);
        if (m18925a || z) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_set, new Object[0]);
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_extsts, parent);
                return (File) null;
            }
            if (!file2.isDirectory()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.not_directory, parent);
                return (File) null;
            }
        }
        String str2 = parent;
        return new File(str2, C3262u.m19566a(this.f15468b, str2, str, "", 0));
    }
}
