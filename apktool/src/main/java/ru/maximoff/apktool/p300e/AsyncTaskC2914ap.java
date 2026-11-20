package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3111bm;

/* compiled from: ShellExecutor.java */
/* renamed from: ru.maximoff.apktool.e.ap */
/* loaded from: classes.dex */
public class AsyncTaskC2914ap extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15314a;

    /* renamed from: b */
    private boolean f15315b;

    public AsyncTaskC2914ap(Context context, InterfaceC2995n interfaceC2995n, boolean z) {
        super(context, interfaceC2995n);
        this.f15314a = context;
        this.f15315b = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return this.f15315b ? R.string.shell_run_root : R.string.shell_run;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        String m18910a;
        int waitFor;
        mo3984d(R.string.filef, file.getAbsolutePath());
        try {
            if (this.f15315b) {
                m18910a = C3102bd.m18910a(this.f15314a, "shell_cmd_root", "su -c");
            } else {
                m18910a = C3102bd.m18910a(this.f15314a, "shell_cmd", "sh");
            }
            ArrayList arrayList = new ArrayList();
            String[] split = m18910a.split("\\s+(?=(?:[^\"']*[\"'][^\"']*[\"'])*[^\"']*$)");
            for (String str : split) {
                arrayList.add(str);
            }
            arrayList.add(file.getAbsolutePath());
            Process start = new ProcessBuilder(arrayList).start();
            m17052a(start);
            new C3111bm(start.getErrorStream(), 3, this).start();
            new C3111bm(start.getInputStream(), 1, this).start();
            waitFor = start.waitFor();
        } catch (Error | Exception e2) {
            mo3979a(R.string.errorf, e2.getMessage());
        }
        if (waitFor == 0) {
            return true;
        }
        mo3979a(R.string.errorf, new StringBuffer().append("exit code = ").append(waitFor).toString());
        return false;
    }
}
