package ru.maximoff.apktool.util.p306d;

import java.p209io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.maximoff.apktool.util.p306d.C3215e;

/* compiled from: SearchItem.java */
/* renamed from: ru.maximoff.apktool.util.d.c */
/* loaded from: classes.dex */
public class C3213c {

    /* renamed from: c */
    private File f19163c;

    /* renamed from: d */
    private boolean f19164d;

    /* renamed from: b */
    private List<C3215e.a> f19162b = new ArrayList();

    /* renamed from: a */
    public boolean f19161a = true;

    public C3213c(File file, boolean z) {
        this.f19163c = file;
        this.f19164d = z;
    }

    /* renamed from: a */
    public void m19217a(C3215e.a aVar) {
        this.f19162b.add(aVar);
    }

    /* renamed from: a */
    public int m19215a() {
        return this.f19162b.size();
    }

    /* renamed from: a */
    public C3215e.a m19216a(int i) {
        return this.f19162b.get(i);
    }

    /* renamed from: b */
    public List<C3215e.a> m19219b() {
        return this.f19162b;
    }

    /* renamed from: c */
    public String m19220c() {
        return this.f19163c.getAbsolutePath();
    }

    /* renamed from: d */
    public File m19221d() {
        return this.f19163c;
    }

    /* renamed from: e */
    public boolean m19222e() {
        return this.f19164d;
    }

    /* renamed from: a */
    public void m19218a(boolean z) {
        this.f19162b.clear();
        this.f19164d = z;
    }

    public String toString() {
        return this.f19163c.getAbsolutePath();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f19163c, new Boolean(this.f19164d)});
    }
}
