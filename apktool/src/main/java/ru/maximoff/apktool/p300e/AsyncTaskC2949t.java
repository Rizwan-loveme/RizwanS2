package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.media.p007tv.TvContract;
import com.srizwan.apktool.R;
import java.io.File;
import org.p270e.C2468c;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: ExtractSplit.java */
/* renamed from: ru.maximoff.apktool.e.t */
/* loaded from: classes.dex */
public class AsyncTaskC2949t extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15785a;

    /* renamed from: b */
    private String f15786b;

    /* renamed from: c */
    private File f15787c;

    /* renamed from: d */
    private File f15788d;

    /* renamed from: e */
    private C3060a f15789e;

    /* renamed from: f */
    private long f15790f;

    /* renamed from: g */
    private int f15791g;

    /* renamed from: h */
    private boolean f15792h;

    /* renamed from: i */
    private boolean f15793i;

    public AsyncTaskC2949t(Context context, C3060a c3060a, String str, boolean z, boolean z2, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15785a = context;
        this.f15789e = c3060a;
        this.f15786b = str;
        this.f15790f = System.currentTimeMillis();
        this.f15791g = 5;
        this.f15792h = z;
        this.f15793i = z2;
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
        if (this.f15793i) {
            str = this.f15785a.getExternalCacheDir().getAbsolutePath();
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
            this.f15787c = new File(new StringBuffer().append(new StringBuffer().append(str).append("/.AM_ExtractSplit_").toString()).append(this.f15790f).toString());
            if (!this.f15787c.exists()) {
                this.f15787c.mkdir();
            }
            return C3262u.m19612a(file, new File(this.f15787c, file.getName()));
        } catch (Exception e2) {
            mo3983c(R.string.errorf, e2.getMessage());
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        boolean booleanValue = super.mo17049a(fileArr).booleanValue();
        if (booleanValue) {
            if (this.f15789e != null && this.f15789e.m18255D()) {
                String str = (String) null;
                if (this.f15792h && this.f15789e.m18266d() != null) {
                    File file = new File(this.f15787c, "icon.png");
                    C3067ab.m18383a(this.f15789e.m18266d(), file);
                    str = file.getName();
                }
                try {
                    m17581a(str);
                } catch (Exception e2) {
                }
            }
            this.f15786b = C3262u.m19566a(this.f15785a, this.f15787c.getParent(), this.f15786b, ".apks", 0);
            this.f15788d = new File(new StringBuffer().append(new StringBuffer().append(this.f15787c.getParent()).append("/").toString()).append(this.f15786b).toString());
            mo3984d(R.string.successf, this.f15788d.getAbsolutePath());
            C3117bs.m19067a(this.f15787c.listFiles(), this.f15788d.getAbsolutePath(), this.f15791g);
            m17060b(this.f15787c.getParentFile());
            C0542g.m3987a(this.f15787c);
        }
        return new Boolean(booleanValue);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return !this.f15793i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (this.f15793i) {
            if (bool.booleanValue()) {
                C3262u.m19604a(this.f15785a, new File[]{this.f15788d});
            } else {
                C3112bn.m18999a(this.f15785a, R.string.error);
            }
        }
    }

    /* renamed from: a */
    private void m17581a(String str) {
        C2468c c2468c = new C2468c();
        c2468c.m15608a(TvContract.BaseTvColumns.COLUMN_PACKAGE_NAME, (Object) this.f15789e.m18276n());
        c2468c.m15608a("name", (Object) this.f15789e.m18275m());
        c2468c.m15608a("version_code", (Object) this.f15789e.m18279q());
        c2468c.m15608a("version_name", (Object) this.f15789e.m18277o());
        c2468c.m15608a("min_sdk_version", (Object) this.f15789e.m18282t());
        c2468c.m15608a("target_sdk_version", (Object) this.f15789e.m18284v());
        if (str != null) {
            c2468c.m15608a("icon", (Object) str);
        }
        C3061a.m18319b(new File(this.f15787c, "manifest.json"), c2468c.m15603a(2));
    }
}
