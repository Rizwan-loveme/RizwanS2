package org.p226d.p233b.p264i.p265a;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import org.p226d.p269d.C2460n;
import org.p226d.p269d.C2461o;

/* compiled from: FileDataStore.java */
/* renamed from: org.d.b.i.a.d */
/* loaded from: classes.dex */
public class C2398d implements InterfaceC2397c {

    /* renamed from: a */
    private final RandomAccessFile f12760a;

    public C2398d(File file) {
        this.f12760a = new RandomAccessFile(file, "rw");
        this.f12760a.setLength(0L);
    }

    @Override // org.p226d.p233b.p264i.p265a.InterfaceC2397c
    /* renamed from: a */
    public OutputStream mo15161a(int i) {
        return new C2461o(this.f12760a, i);
    }

    @Override // org.p226d.p233b.p264i.p265a.InterfaceC2397c
    /* renamed from: b */
    public InputStream mo15163b(int i) {
        return new C2460n(this.f12760a, i);
    }

    @Override // org.p226d.p233b.p264i.p265a.InterfaceC2397c
    /* renamed from: a */
    public void mo15162a() {
        this.f12760a.close();
    }
}
