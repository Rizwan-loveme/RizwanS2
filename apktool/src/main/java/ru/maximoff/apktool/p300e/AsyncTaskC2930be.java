package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.io.File;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3117bs;

/* compiled from: ZipTask.java */
/* renamed from: ru.maximoff.apktool.e.be */
/* loaded from: classes.dex */
public class AsyncTaskC2930be extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private int f15590a;

    /* renamed from: b */
    private boolean f15591b;

    /* renamed from: c */
    private Context f15592c;

    /* renamed from: d */
    private String f15593d;

    /* renamed from: e */
    private boolean f15594e;

    /* renamed from: f */
    private int f15595f;

    /* renamed from: g */
    private String f15596g;

    public AsyncTaskC2930be(Context context, String str, int i, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15592c = context;
        this.f15593d = str;
        this.f15594e = false;
        this.f15591b = false;
        this.f15596g = (String) null;
        this.f15595f = 0;
        this.f15590a = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        return false;
    }

    /* renamed from: g */
    public void m17457g(boolean z) {
        this.f15594e = z;
    }

    /* renamed from: a */
    public void m17455a(int i) {
        this.f15595f = i;
    }

    /* renamed from: h */
    public void m17458h(boolean z) {
        this.f15591b = z;
    }

    /* renamed from: a */
    public void m17456a(String str) {
        this.f15596g = str;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.mcompression;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        mo3984d(R.string.mplease_wait, (Object) null);
        C3117bs.m19069a(fileArr, this.f15593d, this.f15590a, this.f15594e, this.f15595f, this.f15596g);
        if (this.f15591b) {
            for (File file : fileArr) {
                mo3984d(R.string.deletion, new StringBuffer().append(new StringBuffer().append("\"").append(file.getName()).toString()).append("\"").toString());
                if (file.isDirectory()) {
                    C0542g.m3987a(file);
                } else {
                    file.delete();
                }
            }
        }
        return new Boolean(true);
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
    }
}
