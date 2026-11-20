package p046b.p059d;

import com.srizwan.apktool.R;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExtDataInput.java */
/* renamed from: b.d.e */
/* loaded from: classes.dex */
public class C0540e extends AbstractC0537b {
    public C0540e(InputStream inputStream) {
        this((DataInput) new DataInputStream(inputStream));
    }

    public C0540e(DataInput dataInput) {
        super(dataInput);
    }

    /* renamed from: b */
    public int[] m3976b(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    /* renamed from: b */
    public void m3975b() {
        skipBytes(4);
    }

    /* renamed from: c */
    public void m3977c(int i) {
        int readInt = readInt();
        if (readInt != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Integer(i), new Integer(readInt)));
        }
    }

    /* renamed from: a */
    public void m3973a(byte b2) {
        byte readByte = readByte();
        if (readByte != b2) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Byte(b2), new Byte(readByte)));
        }
    }

    /* renamed from: a */
    public void m3974a(int i, int i2, InterfaceC0541f interfaceC0541f) {
        int i3;
        int readInt = readInt();
        if (readInt <= i || interfaceC0541f == null) {
            i3 = readInt;
        } else {
            StringBuilder sb = new StringBuilder();
            byte[] m3978d = m3978d(readInt);
            i3 = readInt;
            while (i3 > 0) {
                sb.append((char) m3978d[3]).append((char) m3978d[1]);
                i3 = readInt();
                m3978d = m3978d(i3);
            }
            interfaceC0541f.mo3984d(R.string.text, String.format("Skip title \"%s\"", sb.toString()));
            interfaceC0541f = (InterfaceC0541f) null;
        }
        if (i3 == i2 || i3 < i) {
            m3974a(i, -1, interfaceC0541f);
        } else if (i3 != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Integer(i), new Integer(i3)));
        }
    }

    @Override // p046b.p059d.AbstractC0537b, java.io.DataInput
    public final int skipBytes(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = super.skipBytes(i - i2);
            if (skipBytes <= 0) {
                break;
            }
            i2 += skipBytes;
        }
        return i2;
    }

    /* renamed from: a */
    public String m3972a(int i, boolean z) {
        int i2;
        short readShort;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i != 0 && (readShort = readShort()) != 0) {
                sb.append((char) readShort);
                i = i2;
            }
        }
        if (z) {
            skipBytes(i2 * 2);
        }
        return sb.toString();
    }

    /* renamed from: d */
    public byte[] m3978d(int i) {
        return new byte[]{(byte) (((-16777216) & i) >> 24), (byte) ((16711680 & i) >> 16), (byte) ((65280 & i) >> 8), (byte) ((i & 255) >> 0)};
    }
}
