package org.p226d.p269d;

import android.widget.ExpandableListView;
import java.io.Writer;

/* compiled from: IndentingWriter.java */
/* renamed from: org.d.d.k */
/* loaded from: classes.dex */
public class C2457k extends Writer {

    /* renamed from: e */
    private static final String f12925e = System.getProperty("line.separator");

    /* renamed from: a */
    protected final Writer f12926a;

    /* renamed from: b */
    protected final char[] f12927b = new char[24];

    /* renamed from: c */
    protected int f12928c = 0;

    /* renamed from: d */
    private boolean f12929d = true;

    public C2457k(Writer writer) {
        this.f12926a = writer;
    }

    /* renamed from: a */
    protected void mo14136a() {
        for (int i = 0; i < this.f12928c; i++) {
            this.f12926a.write(32);
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        if (i == 10) {
            this.f12926a.write(f12925e);
            this.f12929d = true;
        } else {
            if (this.f12929d) {
                mo14136a();
            }
            this.f12929d = false;
            this.f12926a.write(i);
        }
    }

    /* renamed from: a */
    private void m15531a(char[] cArr, int i, int i2) {
        if (this.f12929d && i2 > 0) {
            mo14136a();
            this.f12929d = false;
        }
        this.f12926a.write(cArr, i, i2);
    }

    /* renamed from: a */
    private void m15530a(String str, int i, int i2) {
        if (this.f12929d && i2 > 0) {
            mo14136a();
            this.f12929d = false;
        }
        this.f12926a.write(str, i, i2);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        int i4 = i;
        int i5 = i;
        while (i4 < i3) {
            if (cArr[i4] == '\n') {
                m15531a(cArr, i5, i4 - i5);
                this.f12926a.write(f12925e);
                this.f12929d = true;
                int i6 = i4 + 1;
                i4 = i6;
                i5 = i6;
            } else {
                i4++;
            }
        }
        m15531a(cArr, i5, i4 - i5);
    }

    @Override // java.io.Writer
    public void write(String str) {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3 = i + i2;
        int i4 = i;
        int i5 = i;
        while (i4 < i3) {
            int indexOf = str.indexOf(10, i5);
            if (indexOf == -1 || indexOf >= i3) {
                m15530a(str, i5, i3 - i5);
                return;
            }
            m15530a(str, i5, indexOf - i5);
            this.f12926a.write(f12925e);
            this.f12929d = true;
            i5 = indexOf + 1;
            i4 = indexOf;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        write(charSequence.toString());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        write(charSequence.subSequence(i, i2).toString());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c2) {
        write(c2);
        return this;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        this.f12926a.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12926a.close();
    }

    /* renamed from: a */
    public void m15532a(int i) {
        this.f12928c += i;
        if (this.f12928c < 0) {
            this.f12928c = 0;
        }
    }

    /* renamed from: b */
    public void m15534b(int i) {
        this.f12928c -= i;
        if (this.f12928c < 0) {
            this.f12928c = 0;
        }
    }

    /* renamed from: a */
    public void m15533a(long j) {
        int i = 23;
        do {
            int i2 = i;
            int i3 = (int) (15 & j);
            if (i3 < 10) {
                i = i2 - 1;
                this.f12927b[i2] = (char) (i3 + 48);
            } else {
                i = i2 - 1;
                this.f12927b[i2] = (char) ((i3 - 10) + 97);
            }
            j >>>= 4;
        } while (j != 0);
        int i4 = i + 1;
        m15531a(this.f12927b, i4, 24 - i4);
    }

    /* renamed from: b */
    public void m15535b(long j) {
        int i = 23;
        if (j < 0) {
            j *= -1;
            write(45);
        }
        while (true) {
            int i2 = i - 1;
            this.f12927b[i] = (char) ((j % 10) + 48);
            j /= 10;
            if (j == 0) {
                int i3 = i2 + 1;
                m15531a(this.f12927b, i3, 24 - i3);
                return;
            }
            i = i2;
        }
    }

    /* renamed from: c */
    public void m15536c(int i) {
        int i2 = 15;
        if (i < 0) {
            i *= -1;
            write(45);
        }
        while (true) {
            int i3 = i2 - 1;
            this.f12927b[i2] = (char) ((i % 10) + 48);
            i /= 10;
            if (i == 0) {
                int i4 = i3 + 1;
                m15531a(this.f12927b, i4, 16 - i4);
                return;
            }
            i2 = i3;
        }
    }

    /* renamed from: d */
    public void m15537d(int i) {
        if (i < 0) {
            m15535b(i & ExpandableListView.PACKED_POSITION_VALUE_NULL);
        } else {
            m15536c(i);
        }
    }
}
