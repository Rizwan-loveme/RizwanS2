package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: TranslateAPI.java */
/* renamed from: ru.maximoff.apktool.util.f.q */
/* loaded from: classes.dex */
public class C3237q {

    /* renamed from: a */
    private Context f19422a;

    /* renamed from: b */
    private a f19423b;

    /* renamed from: c */
    private String f19424c;

    /* renamed from: d */
    private String f19425d;

    /* renamed from: e */
    private String f19426e;

    /* renamed from: g */
    private String f19428g;

    /* renamed from: i */
    private int f19430i = 1;

    /* renamed from: f */
    private String f19427f = "Mozilla/5.0 (Linux; Android 10; Apktool M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Mobile Safari/537.36";

    /* renamed from: h */
    private int f19429h = 0;

    /* renamed from: j */
    private boolean f19431j = false;

    /* renamed from: k */
    private Map<String, String> f19432k = new HashMap();

    /* compiled from: TranslateAPI.java */
    /* renamed from: ru.maximoff.apktool.util.f.q$a */
    public interface a {
        /* renamed from: a */
        void mo16858a();

        /* renamed from: a */
        void mo16859a(String str);

        /* renamed from: b */
        void mo16860b();

        /* renamed from: b */
        void mo16861b(String str);
    }

    public C3237q(Context context, String str, String str2, String str3) {
        this.f19422a = context;
        this.f19424c = str;
        this.f19425d = str2;
        this.f19426e = str3;
    }

    /* renamed from: a */
    public void m19398a(String str) {
        if (str != null) {
            this.f19427f = str;
        }
    }

    /* renamed from: a */
    public void m19401a(boolean z) {
        if (this.f19424c.startsWith("auto")) {
            return;
        }
        this.f19431j = z;
    }

    /* renamed from: a */
    public void m19399a(Map<String, String> map) {
        this.f19432k = map;
    }

    /* renamed from: a */
    public void m19397a(int i) {
        this.f19429h = i;
    }

    /* renamed from: b */
    public void m19402b(int i) {
        this.f19430i = i;
    }

    /* renamed from: b */
    public void m19403b(String str) {
        this.f19428g = str;
    }

    /* renamed from: a */
    public void m19396a() {
        switch (this.f19429h) {
            case 0:
                AsyncTaskC3241u asyncTaskC3241u = new AsyncTaskC3241u(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19427f, this.f19423b);
                asyncTaskC3241u.m19449a(this.f19431j);
                asyncTaskC3241u.execute(new String[0]);
                break;
            case 1:
                AsyncTaskC3221a asyncTaskC3221a = new AsyncTaskC3221a(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19427f, this.f19423b);
                asyncTaskC3221a.m19305a(this.f19430i);
                asyncTaskC3221a.m19307a(this.f19432k);
                asyncTaskC3221a.m19308a(this.f19431j);
                asyncTaskC3221a.execute(new String[0]);
                break;
            case 2:
                AsyncTaskC3226f asyncTaskC3226f = new AsyncTaskC3226f(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19427f, this.f19423b);
                asyncTaskC3226f.m19333a(this.f19431j);
                asyncTaskC3226f.execute(new String[0]);
                break;
            case 3:
                AsyncTaskC3227g asyncTaskC3227g = new AsyncTaskC3227g(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19427f, this.f19423b);
                asyncTaskC3227g.m19338a(this.f19432k);
                asyncTaskC3227g.m19339a(this.f19431j);
                asyncTaskC3227g.execute(new String[0]);
                break;
            case 4:
                if (C3112bn.m19040o(this.f19428g)) {
                    AsyncTaskC3223c asyncTaskC3223c = new AsyncTaskC3223c(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19423b);
                    asyncTaskC3223c.m19321a(this.f19431j);
                    asyncTaskC3223c.execute(new String[0]);
                    break;
                } else {
                    AsyncTaskC3222b asyncTaskC3222b = new AsyncTaskC3222b(this.f19422a, this.f19424c, this.f19425d, this.f19426e, this.f19428g, this.f19427f, this.f19423b);
                    asyncTaskC3222b.m19312a(this.f19431j);
                    asyncTaskC3222b.execute(new String[0]);
                    break;
                }
        }
    }

    /* renamed from: a */
    public void m19400a(a aVar) {
        this.f19423b = aVar;
    }
}
