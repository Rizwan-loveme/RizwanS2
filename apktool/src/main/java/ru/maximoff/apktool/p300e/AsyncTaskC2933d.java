package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p053b.C0501a;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3256p;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: AppPackages.java */
/* renamed from: ru.maximoff.apktool.e.d */
/* loaded from: classes.dex */
public class AsyncTaskC2933d extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15606a;

    /* renamed from: b */
    private C3060a f15607b;

    public AsyncTaskC2933d(Context context, C3060a c3060a) {
        super(context, (InterfaceC2995n) null);
        this.f15606a = context;
        this.f15607b = c3060a;
        m17070e(false);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.packages;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return true;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        try {
            try {
                if (this.f15607b != null) {
                    try {
                        m17069e(R.string.text, C3112bn.m18992a(this.f15606a, this.f15607b, C3102bd.m18910a(this.f15606a, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})")));
                        m17069e(R.string.text, "");
                    } catch (Exception e2) {
                    }
                }
                C2604w c2604w = new C2604w(file);
                C2602u m16162a = c2604w.m16162a("resources.arsc");
                if (m16162a == null) {
                    throw new Exception("File \"resources.arsc\" is not found in the archive!");
                }
                C0501a.a m3761a = C0501a.m3761a(new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a()), true, true, false, 0, (C0467a) null, new C3256p());
                C0492c m3786c = m3761a.m3786c();
                C0492c[] m3785b = m3761a.m3785b();
                Arrays.sort(m3785b, new Comparator<C0492c>(this) { // from class: ru.maximoff.apktool.e.d.1

                    /* renamed from: a */
                    private final AsyncTaskC2933d f15608a;

                    {
                        this.f15608a = this;
                    }

                    @Override // java.util.Comparator
                    public int compare(C0492c c0492c, C0492c c0492c2) {
                        return m17465a(c0492c, c0492c2);
                    }

                    /* renamed from: a */
                    public int m17465a(C0492c c0492c, C0492c c0492c2) {
                        return c0492c.m3678g() - c0492c2.m3678g();
                    }
                });
                for (C0492c c0492c : m3785b) {
                    if (m3786c.m3678g() == c0492c.m3678g()) {
                        m17069e(R.string.package_info2, c0492c.m3679h(), new Integer(c0492c.m3678g()), new Integer(c0492c.m3673c()));
                    } else {
                        m17069e(R.string.package_info, c0492c.m3679h(), new Integer(c0492c.m3678g()), new Integer(c0492c.m3673c()));
                    }
                }
                m17069e(R.string.text, "");
                m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15606a.getString(R.string.total)).append(": ").toString()).append(String.valueOf(m3785b.length)).toString());
                return true;
            } catch (Exception e3) {
                mo3979a(R.string.errorf, e3.toString());
                return false;
            }
        } catch (Error e4) {
            mo3979a(R.string.errorf, e4.toString());
            return false;
        }
    }
}
