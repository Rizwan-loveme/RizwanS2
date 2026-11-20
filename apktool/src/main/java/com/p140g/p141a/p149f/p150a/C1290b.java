package com.p140g.p141a.p149f.p150a;

import android.widget.ExpandableListView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* compiled from: ZipEntry.java */
/* renamed from: com.g.a.f.a.b */
/* loaded from: classes.dex */
public final class C1290b implements Cloneable {

    /* renamed from: a */
    String f8491a;

    /* renamed from: b */
    String f8492b;

    /* renamed from: c */
    long f8493c;

    /* renamed from: d */
    long f8494d;

    /* renamed from: e */
    long f8495e;

    /* renamed from: f */
    int f8496f;

    /* renamed from: g */
    int f8497g;

    /* renamed from: h */
    int f8498h;

    /* renamed from: i */
    byte[] f8499i;

    /* renamed from: j */
    int f8500j;

    /* renamed from: k */
    long f8501k;

    /* renamed from: a */
    public String m10462a() {
        return this.f8491a;
    }

    /* renamed from: b */
    public long m10463b() {
        return this.f8495e;
    }

    public String toString() {
        return this.f8491a;
    }

    public Object clone() {
        try {
            C1290b c1290b = (C1290b) super.clone();
            c1290b.f8499i = this.f8499i != null ? (byte[]) this.f8499i.clone() : (byte[]) null;
            return c1290b;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    C1290b(ByteBuffer byteBuffer, boolean z) {
        this.f8493c = -1;
        this.f8494d = -1;
        this.f8495e = -1;
        this.f8496f = -1;
        this.f8497g = -1;
        this.f8498h = -1;
        this.f8500j = -1;
        this.f8501k = -1;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN).limit(46);
        C1291c.m10465a(byteBuffer, 46);
        int i = byteBuffer2.getInt();
        if (i != 33639248) {
            C1291c.m10464a("Central Directory Entry", i);
        }
        byteBuffer2.position(8);
        int i2 = byteBuffer2.getShort() & 65535;
        this.f8496f = byteBuffer2.getShort() & 65535;
        this.f8497g = byteBuffer2.getShort() & 65535;
        this.f8498h = byteBuffer2.getShort() & 65535;
        this.f8493c = byteBuffer2.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.f8494d = byteBuffer2.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.f8495e = byteBuffer2.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.f8500j = byteBuffer2.getShort() & 65535;
        int i3 = byteBuffer2.getShort() & 65535;
        int i4 = byteBuffer2.getShort() & 65535;
        byteBuffer2.position(42);
        this.f8501k = byteBuffer2.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        byte[] bArr = new byte[this.f8500j];
        byteBuffer.get(bArr);
        this.f8491a = new String(bArr, 0, bArr.length, StandardCharsets.UTF_8);
        if (i3 > 0) {
            if (z) {
                C1291c.m10465a(byteBuffer, i3);
            } else {
                this.f8499i = new byte[i3];
                byteBuffer2.get(this.f8499i);
            }
        }
        if (i4 > 0) {
            if (z) {
                C1291c.m10465a(byteBuffer, i4);
                return;
            }
            byte[] bArr2 = new byte[i4];
            byteBuffer.get(bArr2);
            this.f8492b = new String(bArr2, 0, bArr2.length, StandardCharsets.UTF_8);
        }
    }
}
