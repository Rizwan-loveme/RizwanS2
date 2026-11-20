package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.File;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;

/* compiled from: DeleteFileTask.java */
/* renamed from: ru.maximoff.apktool.e.l */
/* loaded from: classes.dex */
public class AsyncTaskC2941l extends AbstractAsyncTaskC2898a {
    public AsyncTaskC2941l(Context context, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        m17056a(true);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.delete;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        mo3984d(R.string.deletion, new StringBuffer().append(new StringBuffer().append("\"").append(file.getName()).toString()).append("\"").toString());
        if (file.isDirectory()) {
            C0542g.m3987a(file);
        } else {
            file.delete();
        }
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return false;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        C2978b.f16135a.m17711f();
    }
}
