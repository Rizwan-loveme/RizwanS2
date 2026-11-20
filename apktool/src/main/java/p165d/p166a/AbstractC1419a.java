package p165d.p166a;

import java.p209io.ByteArrayInputStream;
import java.p209io.ByteArrayOutputStream;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.p209io.PrintStream;

/* compiled from: CharacterEncoder.java */
/* renamed from: d.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1419a {

    /* renamed from: a */
    protected PrintStream f9182a;

    /* renamed from: a */
    protected abstract int mo11226a();

    /* renamed from: a */
    protected abstract void mo11232a(OutputStream outputStream, byte[] bArr, int i, int i2);

    /* renamed from: b */
    protected abstract int mo11233b();

    /* renamed from: a */
    protected void mo11230a(OutputStream outputStream) {
        this.f9182a = new PrintStream(outputStream);
    }

    /* renamed from: b */
    protected void m11236b(OutputStream outputStream) {
    }

    /* renamed from: a */
    protected void mo11231a(OutputStream outputStream, int i) {
    }

    /* renamed from: c */
    protected void mo11237c(OutputStream outputStream) {
        this.f9182a.println();
    }

    /* renamed from: a */
    protected int m11227a(InputStream inputStream, byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            int read = inputStream.read();
            if (read == -1) {
                return i;
            }
            bArr[i] = (byte) read;
        }
        return bArr.length;
    }

    /* renamed from: a */
    public void m11229a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[mo11233b()];
        mo11230a(outputStream);
        while (true) {
            int m11227a = m11227a(inputStream, bArr);
            if (m11227a != 0) {
                mo11231a(outputStream, m11227a);
                int i = 0;
                while (i < m11227a) {
                    if (mo11226a() + i <= m11227a) {
                        mo11232a(outputStream, bArr, i, mo11226a());
                    } else {
                        mo11232a(outputStream, bArr, i, m11227a - i);
                    }
                    i += mo11226a();
                }
                if (m11227a < mo11233b()) {
                    break;
                } else {
                    mo11237c(outputStream);
                }
            } else {
                break;
            }
        }
        m11236b(outputStream);
    }

    /* renamed from: a */
    public String m11228a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m11229a(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception e2) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    /* renamed from: b */
    public void m11235b(InputStream inputStream, OutputStream outputStream) {
        int m11227a;
        byte[] bArr = new byte[mo11233b()];
        mo11230a(outputStream);
        do {
            m11227a = m11227a(inputStream, bArr);
            if (m11227a == 0) {
                break;
            }
            mo11231a(outputStream, m11227a);
            int i = 0;
            while (i < m11227a) {
                if (mo11226a() + i <= m11227a) {
                    mo11232a(outputStream, bArr, i, mo11226a());
                } else {
                    mo11232a(outputStream, bArr, i, m11227a - i);
                }
                i += mo11226a();
            }
            mo11237c(outputStream);
        } while (m11227a >= mo11233b());
        m11236b(outputStream);
    }

    /* renamed from: b */
    public String m11234b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m11235b(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception e2) {
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
    }
}
