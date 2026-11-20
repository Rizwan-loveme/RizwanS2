package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.File;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: ExtractTask.java */
/* renamed from: ru.maximoff.apktool.e.u */
/* loaded from: classes.dex */
public class AsyncTaskC2950u extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15794a;

    /* renamed from: b */
    private String f15795b;

    /* renamed from: c */
    private File f15796c;

    /* renamed from: d */
    private boolean f15797d;

    public AsyncTaskC2950u(Context context, String str, boolean z, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15794a = context;
        this.f15795b = str;
        this.f15797d = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.extract;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        String str;
        mo3984d(R.string.extraction, file.getAbsolutePath());
        if (this.f15797d) {
            str = this.f15794a.getExternalCacheDir().getAbsolutePath();
        } else {
            str = C3102bd.f18339v;
        }
        if (str == null) {
            mo3983c(R.string.output_directory_not_set, new Object[0]);
            return false;
        }
        try {
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdirs()) {
                mo3983c(R.string.output_directory_not_extsts, str);
                return false;
            }
            if (!file2.isDirectory()) {
                mo3983c(R.string.not_directory, str);
                return false;
            }
            this.f15795b = C3262u.m19623b(this.f15794a, str, this.f15795b, "", 0);
            this.f15796c = new File(file2, this.f15795b);
            boolean m19612a = C3262u.m19612a(file, this.f15796c);
            if (m19612a) {
                mo3984d(R.string.successf, this.f15796c.getAbsolutePath());
                m17060b(new File(str));
            }
            return m19612a;
        } catch (Exception e2) {
            mo3983c(R.string.errorf, e2.getMessage());
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return !this.f15797d;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (this.f15797d) {
            if (bool.booleanValue()) {
                C3262u.m19604a(this.f15794a, new File[]{this.f15796c});
            } else {
                C3112bn.m18999a(this.f15794a, R.string.error);
            }
        }
    }
}
