package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.File;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3081am;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: SignTask.java */
/* renamed from: ru.maximoff.apktool.e.ar */
/* loaded from: classes.dex */
public class AsyncTaskC2916ar extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final C2917as f15378a;

    /* renamed from: b */
    private Context f15379b;

    /* renamed from: c */
    private InterfaceC2995n f15380c;

    public AsyncTaskC2916ar(Context context, InterfaceC2995n interfaceC2995n, C2917as c2917as) {
        super(context, interfaceC2995n);
        this.f15379b = context;
        this.f15378a = c2917as;
        this.f15380c = interfaceC2995n;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.sign_run_title;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        int i;
        mo3984d(R.string.sign_run_title, (Object) null);
        try {
            i = new C3081am(file).m18632h();
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 14;
        }
        if (i < 1) {
            i = 14;
        }
        File m17309a = m17309a(file, file.getName(), this);
        m17060b(m17309a);
        return this.f15378a.m17321a(file, m17309a, i, this);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (this.f15380c == null) {
            MainActivity.m16615o().m16622a((File) null);
        }
    }

    /* renamed from: a */
    public File m17309a(File file, String str, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String parent = file.getParent();
        if (str == null) {
            str = file.getName();
        }
        boolean m18925a = C3102bd.m18925a(this.f15379b, "all_to_out_dir", false);
        boolean z = !C3262u.m19664g(this.f15379b, file);
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
        String[] m19641b = C3262u.m19641b(str);
        return new File(str2, C3262u.m19566a(this.f15379b, str2, new StringBuffer().append(m19641b[0]).append("_sign").toString(), new StringBuffer().append(".").append(m19641b[1]).toString(), 0));
    }
}
