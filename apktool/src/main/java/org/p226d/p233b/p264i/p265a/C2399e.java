package org.p226d.p233b.p264i.p265a;

import com.p129f.p130a.p133c.C1156ai;
import java.p209io.OutputStream;
import java.util.Iterator;
import java.util.List;

/* compiled from: MemoryDeferredOutputStream.java */
/* renamed from: org.d.b.i.a.e */
/* loaded from: classes.dex */
public class C2399e extends AbstractC2395a {

    /* renamed from: a */
    private final List<byte[]> f12761a;

    /* renamed from: b */
    private byte[] f12762b;

    /* renamed from: c */
    private int f12763c;

    public C2399e() {
        this(16384);
    }

    public C2399e(int i) {
        this.f12761a = C1156ai.m9909a();
        this.f12762b = new byte[i];
    }

    @Override // org.p226d.p233b.p264i.p265a.AbstractC2395a
    /* renamed from: a */
    public void mo15159a(OutputStream outputStream) {
        Iterator<byte[]> it = this.f12761a.iterator();
        while (it.hasNext()) {
            outputStream.write(it.next());
        }
        if (this.f12763c > 0) {
            outputStream.write(this.f12762b, 0, this.f12763c);
        }
        this.f12761a.clear();
        this.f12763c = 0;
    }

    @Override // java.p209io.OutputStream
    public void write(int i) {
        if (m15166b() == 0) {
            this.f12761a.add(this.f12762b);
            this.f12762b = new byte[this.f12762b.length];
            this.f12763c = 0;
        }
        byte[] bArr = this.f12762b;
        int i2 = this.f12763c;
        this.f12763c = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.p209io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.p209io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int m15166b = m15166b();
        int i3 = 0;
        while (i2 - i3 > 0) {
            int min = Math.min(m15166b, i2 - i3);
            System.arraycopy(bArr, i + i3, this.f12762b, this.f12763c, min);
            i3 += min;
            this.f12763c = min + this.f12763c;
            m15166b = m15166b();
            if (m15166b == 0) {
                this.f12761a.add(this.f12762b);
                this.f12762b = new byte[this.f12762b.length];
                this.f12763c = 0;
                m15166b = this.f12762b.length;
            }
        }
    }

    /* renamed from: b */
    private int m15166b() {
        return this.f12762b.length - this.f12763c;
    }

    /* renamed from: a */
    public static InterfaceC2396b m15164a() {
        return m15165a(16384);
    }

    /* renamed from: a */
    public static InterfaceC2396b m15165a(final int i) {
        return new InterfaceC2396b() { // from class: org.d.b.i.a.e.1
            @Override // org.p226d.p233b.p264i.p265a.InterfaceC2396b
            /* renamed from: a */
            public AbstractC2395a mo15160a() {
                return new C2399e(i);
            }
        };
    }
}
