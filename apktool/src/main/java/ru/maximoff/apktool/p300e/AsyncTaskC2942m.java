package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.p065b.p086b.p093b.p094a.C0757a;
import com.p140g.p141a.p144c.C1244c;
import com.p140g.p141a.p148e.C1285e;
import com.srizwan.apktool.R;
import java.p209io.File;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: Dex2JarTask.java */
/* renamed from: ru.maximoff.apktool.e.m */
/* loaded from: classes.dex */
public class AsyncTaskC2942m extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private boolean f15679a;

    /* renamed from: b */
    private boolean f15680b;

    /* renamed from: c */
    private boolean f15681c;

    /* renamed from: d */
    private boolean f15682d;

    /* renamed from: e */
    private boolean f15683e;

    /* renamed from: f */
    private boolean f15684f;

    /* renamed from: g */
    private Context f15685g;

    /* renamed from: h */
    private boolean f15686h;

    public AsyncTaskC2942m(Context context, InterfaceC2995n interfaceC2995n, boolean z) {
        super(context, interfaceC2995n);
        this.f15679a = false;
        this.f15680b = false;
        this.f15681c = false;
        this.f15682d = false;
        this.f15683e = false;
        this.f15684f = false;
        this.f15685g = context;
        this.f15686h = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return this.f15686h ? R.string.jar2dex : R.string.dex2jar;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        mo3984d(R.string.mplease_wait, (Object) null);
        if (C3102bd.m18925a(this.f15685g, "ongoing_notification", true)) {
            m17054a(this.f15685g.getString(mo17065c()), "decompile_task");
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        try {
            mo3984d(R.string.mprocessing_file, file.getName());
            if (this.f15686h) {
                File m17514a = m17514a(file, (String) null, ".dex", this);
                String[] strArr = {"--no-strict", new StringBuffer().append("--output=").append(m17514a.getAbsolutePath()).toString(), file.getAbsolutePath()};
                C0757a.a aVar = new C0757a.a();
                aVar.m6929a(strArr);
                int m6907a = C0757a.m6907a(aVar);
                if (m6907a == 0) {
                    m17060b(m17514a.getParentFile());
                } else {
                    mo3979a(R.string.mprocessing_error, file.getName(), new Integer(m6907a));
                }
                return m6907a == 0;
            }
            File m17514a2 = m17514a(file, (String) null, ".jar", this);
            C1244c.m10312a(C1285e.m10448a(file.getAbsolutePath())).m10319a(this.f15679a).m10318a().m10324e(!this.f15680b).m10322c(this.f15682d).m10323d(this.f15681c).m10321b(this.f15684f).m10325f(this.f15683e).m10320a(m17514a2);
            m17060b(m17514a2.getParentFile());
            return true;
        } catch (Error e2) {
            mo3979a(R.string.errorf, e2.toString());
            return false;
        } catch (Exception e3) {
            mo3979a(R.string.errorf, e3.toString());
            return false;
        }
    }

    /* renamed from: a */
    private File m17514a(File file, String str, String str2, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String parent = file.getParent();
        if (str == null) {
            str = file.getName();
        }
        boolean m18925a = C3102bd.m18925a(this.f15685g, "all_to_out_dir", false);
        boolean z = !C3262u.m19664g(this.f15685g, file);
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
        String str3 = parent;
        return new File(str3, C3262u.m19566a(this.f15685g, str3, str, str2, 0));
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (C3102bd.m18925a(this.f15685g, "build_notification", true)) {
            m17072f(bool.booleanValue());
        }
    }
}
