package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.view.PointerIcon;
import com.srizwan.apktool.R;
import java.p209io.File;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.sai.C3260a;

/* compiled from: ApkInstall.java */
/* renamed from: ru.maximoff.apktool.e.c */
/* loaded from: classes.dex */
public class AsyncTaskC2932c extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15604a;

    /* renamed from: b */
    private int f15605b;

    public AsyncTaskC2932c(Context context) {
        super(context, (InterfaceC2995n) null);
        this.f15604a = context;
        this.f15605b = C3102bd.m18905a(this.f15604a, "inlocation_idx", 1);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.install_session;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        int i;
        mo3984d(R.string.split_install, (Object) null);
        C3060a c3060a = new C3060a(this.f15604a, file);
        if (!c3060a.m18255D()) {
            return false;
        }
        switch (this.f15605b) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            default:
                i = 1;
                break;
        }
        C3260a c3260a = new C3260a(this.f15604a);
        c3260a.m19530a(c3060a.m18276n());
        c3260a.m19529a(i);
        c3260a.m19527a(file);
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        C3056b c3056b = new C3056b(this.f15604a);
        c3056b.m18194a(PointerIcon.TYPE_ALIAS);
        c3056b.m18197a("split_installer");
        c3056b.m18195a(this.f15604a.getText(R.string.split_install), this.f15604a.getText(R.string.split_install_toast));
        c3056b.m18192a(this.f15604a.getString(R.string.app_name), this.f15604a.getString(R.string.split_install_toast));
        super.mo17061b(bool);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return false;
    }
}
