package ru.maximoff.apktool.util.p310h;

import java.io.OutputStream;
import ru.p294a.C2602u;
import ru.p294a.C2606y;

/* compiled from: MZipOutputStream.java */
/* renamed from: ru.maximoff.apktool.util.h.b */
/* loaded from: classes.dex */
public class C3248b extends C2606y {

    /* renamed from: j */
    private a f19531j;

    /* renamed from: k */
    private int f19532k;

    /* renamed from: a */
    public static C3248b m19496a(OutputStream outputStream) {
        return m19497a(outputStream, 4);
    }

    /* renamed from: a */
    public static C3248b m19497a(OutputStream outputStream, int i) {
        a aVar = new a(outputStream);
        C3248b c3248b = new C3248b(aVar, i);
        c3248b.f19531j = aVar;
        return c3248b;
    }

    C3248b(a aVar, int i) {
        super(aVar);
        this.f19532k = i;
    }

    @Override // ru.p294a.C2606y
    /* renamed from: a */
    public void mo16214a(C2602u c2602u) {
        if (c2602u.getMethod() == 0) {
            c2602u.setExtra(new byte[(int) (this.f19532k - (((30 + c2602u.getName().getBytes().length) + this.f19531j.m19498a()) % this.f19532k))]);
        }
        super.mo16214a(c2602u);
    }

    /* compiled from: MZipOutputStream.java */
    /* renamed from: ru.maximoff.apktool.util.h.b$a */
    private static class a extends OutputStream {

        /* renamed from: a */
        private final OutputStream f19533a;

        /* renamed from: b */
        private long f19534b = 0;

        a(OutputStream outputStream) {
            this.f19533a = outputStream;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f19533a.write(bArr);
            this.f19534b += bArr.length;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f19533a.write(i);
            this.f19534b++;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f19533a.write(bArr, i, i2);
            this.f19534b += i2;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f19533a.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                flush();
            } finally {
                this.f19533a.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public long m19498a() {
            return this.f19534b;
        }
    }
}
