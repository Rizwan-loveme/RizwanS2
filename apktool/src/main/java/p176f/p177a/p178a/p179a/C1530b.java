package p176f.p177a.p178a.p179a;

import java.io.DataOutputStream;
import java.io.OutputStream;

/* compiled from: LEDataOutputStream.java */
/* renamed from: f.a.a.a.b */
/* loaded from: classes.dex */
public class C1530b {

    /* renamed from: a */
    private DataOutputStream f9783a;

    public C1530b(OutputStream outputStream) {
        this.f9783a = new DataOutputStream(outputStream);
    }

    /* renamed from: a */
    public void m11744a() {
        this.f9783a.flush();
        this.f9783a.close();
    }

    /* renamed from: a */
    public void m11745a(byte b2) {
        this.f9783a.writeByte(b2);
    }

    /* renamed from: a */
    public void m11747a(byte[] bArr) {
        this.f9783a.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m11748a(byte[] bArr, int i, int i2) {
        this.f9783a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void m11746a(int i) {
        this.f9783a.writeByte(i & 255);
        this.f9783a.writeByte((i >> 8) & 255);
        this.f9783a.writeByte((i >> 16) & 255);
        this.f9783a.writeByte((i >> 24) & 255);
    }

    /* renamed from: a */
    public void m11749a(int[] iArr) {
        m11743a(iArr, 0, iArr.length);
    }

    /* renamed from: a */
    private void m11743a(int[] iArr, int i, int i2) {
        while (i < i2) {
            m11746a(iArr[i]);
            i++;
        }
    }
}
