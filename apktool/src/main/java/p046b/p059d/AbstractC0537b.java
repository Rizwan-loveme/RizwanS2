package p046b.p059d;

import java.p209io.DataInput;

/* compiled from: DataInputDelegate.java */
/* renamed from: b.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC0537b implements DataInput {

    /* renamed from: a */
    protected final DataInput f3631a;

    public AbstractC0537b(DataInput dataInput) {
        this.f3631a = dataInput;
    }

    @Override // java.p209io.DataInput
    public int skipBytes(int i) {
        return this.f3631a.skipBytes(i);
    }

    @Override // java.p209io.DataInput
    public int readUnsignedShort() {
        return this.f3631a.readUnsignedShort();
    }

    @Override // java.p209io.DataInput
    public int readUnsignedByte() {
        return this.f3631a.readUnsignedByte();
    }

    @Override // java.p209io.DataInput
    public String readUTF() {
        return this.f3631a.readUTF();
    }

    @Override // java.p209io.DataInput
    public short readShort() {
        return this.f3631a.readShort();
    }

    @Override // java.p209io.DataInput
    public long readLong() {
        return this.f3631a.readLong();
    }

    @Override // java.p209io.DataInput
    public String readLine() {
        return this.f3631a.readLine();
    }

    @Override // java.p209io.DataInput
    public int readInt() {
        return this.f3631a.readInt();
    }

    @Override // java.p209io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f3631a.readFully(bArr, i, i2);
    }

    @Override // java.p209io.DataInput
    public void readFully(byte[] bArr) {
        this.f3631a.readFully(bArr);
    }

    @Override // java.p209io.DataInput
    public float readFloat() {
        return this.f3631a.readFloat();
    }

    @Override // java.p209io.DataInput
    public double readDouble() {
        return this.f3631a.readDouble();
    }

    @Override // java.p209io.DataInput
    public char readChar() {
        return this.f3631a.readChar();
    }

    @Override // java.p209io.DataInput
    public byte readByte() {
        return this.f3631a.readByte();
    }

    @Override // java.p209io.DataInput
    public boolean readBoolean() {
        return this.f3631a.readBoolean();
    }
}
