package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.List;
import p046b.p047a.C0518d;
import p046b.p047a.p050c.C0467a;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ImportFrameworkTask.java */
/* renamed from: ru.maximoff.apktool.e.z */
/* loaded from: classes.dex */
public class AsyncTaskC2955z extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private final String[] f15834a;

    /* renamed from: b */
    private Context f15835b;

    /* renamed from: c */
    private boolean f15836c;

    /* renamed from: d */
    private boolean f15837d;

    public AsyncTaskC2955z(Context context, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15834a = new String[]{"/system/app/miui.apk", "/system/app/miuisystem.apk", "/system/app/miui/miui.apk", "/system/app/miuisystem/miuisystem.apk", "/system_ext/app/miui/miui.apk", "/system_ext/app/miuisystem/miuisystem.apk"};
        this.f15835b = context;
        this.f15836c = false;
        this.f15837d = false;
    }

    /* renamed from: g */
    public void m17601g(boolean z) {
        this.f15836c = true;
        this.f15837d = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return this.f15836c ? R.string.import_system : R.string.import_framework;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return !this.f15836c;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        if (this.f15836c) {
            File[] m17600l = m17600l();
            if (this.f15837d) {
                return super.mo17049a(C3080al.m18571a(m17600l, m17598a(this.f15834a)));
            }
            return super.mo17049a(m17600l);
        }
        return super.mo17049a(fileArr);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        if (mo3981a()) {
            return false;
        }
        mo3984d(R.string.mplease_wait, (Object) null);
        try {
            mo3984d(R.string.filef, file.getAbsolutePath());
            C0467a c0467a = new C0467a(this);
            c0467a.f3322a = C0518d.f3579w;
            c0467a.m3592a(file);
            return true;
        } catch (Error e2) {
            mo3979a(R.string.errorf, e2.getMessage());
            return false;
        } catch (Exception e3) {
            mo3979a(R.string.errorf, e3.getMessage());
            return false;
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        if (this.f15836c) {
            onCancelled();
            C3112bn.m18999a(this.f15835b, R.string.complete);
        } else {
            super.mo17061b(bool);
        }
    }

    /* renamed from: a */
    private File[] m17598a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            File file = new File(str);
            if (file.isFile()) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: l */
    private File[] m17600l() {
        ArrayList arrayList = new ArrayList();
        File file = new File("/system/framework/");
        if (file.isDirectory()) {
            arrayList.addAll(m17599d(file));
        }
        File file2 = new File("/system_ext/framework/");
        if (file2.isDirectory()) {
            arrayList.addAll(m17599d(file2));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new File("/system/framework/framework-res.apk"));
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: d */
    private List<File> m17599d(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().toLowerCase().endsWith(".apk")) {
                    arrayList.add(file2);
                } else if (file2.isDirectory()) {
                    arrayList.addAll(m17599d(file2));
                }
            }
        }
        return arrayList;
    }
}
