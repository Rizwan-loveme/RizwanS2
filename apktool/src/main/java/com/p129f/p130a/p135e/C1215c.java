package com.p129f.p130a.p135e;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p137g.C1219c;
import com.p129f.p130a.p137g.C1220d;
import java.p209io.DataInput;
import java.p209io.DataInputStream;
import java.p209io.EOFException;
import java.p209io.FilterInputStream;
import java.p209io.InputStream;

/* compiled from: LittleEndianDataInputStream.java */
/* renamed from: com.f.a.e.c */
/* loaded from: classes.dex */
public final class C1215c extends FilterInputStream implements DataInput {
    public C1215c(InputStream inputStream) {
        super((InputStream) C1120o.m9547a(inputStream));
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.p209io.DataInput
    public void readFully(byte[] bArr) {
        C1213a.m10158a(this, bArr);
    }

    @Override // java.p209io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        C1213a.m10159a(this, bArr, i, i2);
    }

    @Override // java.p209io.DataInput
    public int skipBytes(int i) {
        return (int) this.f10665in.skip(i);
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public int readUnsignedByte() {
        int read = this.f10665in.read();
        if (read < 0) {
            throw new EOFException();
        }
        return read;
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public int readUnsignedShort() {
        return C1219c.m10172a((byte) 0, (byte) 0, m10168a(), m10168a());
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public int readInt() {
        byte m10168a = m10168a();
        byte m10168a2 = m10168a();
        return C1219c.m10172a(m10168a(), m10168a(), m10168a2, m10168a);
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public long readLong() {
        byte m10168a = m10168a();
        byte m10168a2 = m10168a();
        byte m10168a3 = m10168a();
        byte m10168a4 = m10168a();
        byte m10168a5 = m10168a();
        byte m10168a6 = m10168a();
        return C1220d.m10176a(m10168a(), m10168a(), m10168a6, m10168a5, m10168a4, m10168a3, m10168a2, m10168a);
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public String readUTF() {
        return new DataInputStream(this.f10665in).readUTF();
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.p209io.DataInput
    @CanIgnoreReturnValue
    public boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    /* renamed from: a */
    private byte m10168a() {
        int read = this.f10665in.read();
        if (-1 == read) {
            throw new EOFException();
        }
        return (byte) read;
    }
}
