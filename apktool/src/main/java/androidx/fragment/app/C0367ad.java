package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* renamed from: androidx.fragment.app.ad */
/* loaded from: classes.dex */
final class C0367ad extends Writer {

    /* renamed from: a */
    private final String f2501a;

    /* renamed from: b */
    private StringBuilder f2502b = new StringBuilder(128);

    C0367ad(String str) {
        this.f2501a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2693a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m2693a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                m2693a();
            } else {
                this.f2502b.append(c2);
            }
        }
    }

    /* renamed from: a */
    private void m2693a() {
        if (this.f2502b.length() > 0) {
            Log.m182d(this.f2501a, this.f2502b.toString());
            this.f2502b.delete(0, this.f2502b.length());
        }
    }
}
