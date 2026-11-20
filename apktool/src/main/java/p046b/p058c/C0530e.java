package p046b.p058c;

import java.p209io.File;

/* compiled from: ExtFile.java */
/* renamed from: b.c.e */
/* loaded from: classes.dex */
public class C0530e extends File {

    /* renamed from: a */
    private InterfaceC0528c f3626a;

    public C0530e(File file) {
        super(file.getPath());
    }

    public C0530e(File file, String str) {
        super(file, str);
    }

    public C0530e(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public InterfaceC0528c m3953a() {
        if (this.f3626a == null) {
            if (isDirectory()) {
                this.f3626a = new C0531f(this);
            } else {
                this.f3626a = new C0534i(this);
            }
        }
        return this.f3626a;
    }

    /* renamed from: b */
    public void m3954b() {
        if (this.f3626a != null) {
            this.f3626a.mo3924d();
        }
    }
}
