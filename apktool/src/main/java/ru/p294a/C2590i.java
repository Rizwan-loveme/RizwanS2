package ru.p294a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Simple8BitZipEncoding.java */
/* renamed from: ru.a.i */
/* loaded from: classes.dex */
class C2590i implements InterfaceC2600s {

    /* renamed from: a */
    private final char[] f13439a;

    /* renamed from: b */
    private final List<a> f13440b;

    /* compiled from: Simple8BitZipEncoding.java */
    /* renamed from: ru.a.i$a */
    private static final class a implements Comparable<a> {

        /* renamed from: a */
        public final char f13441a;

        /* renamed from: b */
        public final byte f13442b;

        @Override // java.lang.Comparable
        public int compareTo(a aVar) {
            return m16092a(aVar);
        }

        a(byte b2, char c2) {
            this.f13442b = b2;
            this.f13441a = c2;
        }

        /* renamed from: a */
        public int m16092a(a aVar) {
            return this.f13441a - aVar.f13441a;
        }

        public String toString() {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("0x").append(Integer.toHexString(65535 & this.f13441a)).toString()).append("->0x").toString()).append(Integer.toHexString(this.f13442b & 255)).toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13441a == aVar.f13441a && this.f13442b == aVar.f13442b;
        }

        public int hashCode() {
            return this.f13441a;
        }
    }

    public C2590i(char[] cArr) {
        this.f13439a = (char[]) cArr.clone();
        ArrayList arrayList = new ArrayList(this.f13439a.length);
        byte b2 = (byte) 127;
        for (char c2 : this.f13439a) {
            b2 = (byte) (b2 + 1);
            arrayList.add(new a(b2, c2));
        }
        Collections.sort(arrayList);
        this.f13440b = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public char m16089a(byte b2) {
        return b2 >= 0 ? (char) b2 : this.f13439a[b2 + 128];
    }

    /* renamed from: a */
    public boolean m16090a(char c2) {
        return (c2 >= 0 && c2 < 128) || m16088b(c2) != null;
    }

    /* renamed from: a */
    public boolean m16091a(ByteBuffer byteBuffer, char c2) {
        if (c2 >= 0 && c2 < 128) {
            byteBuffer.put((byte) c2);
            return true;
        }
        a m16088b = m16088b(c2);
        if (m16088b == null) {
            return false;
        }
        byteBuffer.put(m16088b.f13442b);
        return true;
    }

    /* renamed from: b */
    private a m16088b(char c2) {
        int size = this.f13440b.size();
        int i = 0;
        while (size > i) {
            int i2 = i + ((size - i) / 2);
            a aVar = this.f13440b.get(i2);
            if (aVar.f13441a != c2) {
                if (aVar.f13441a < c2) {
                    i = i2 + 1;
                } else {
                    size = i2;
                }
            } else {
                return aVar;
            }
        }
        if (i >= this.f13440b.size()) {
            return (a) null;
        }
        a aVar2 = this.f13440b.get(i);
        if (aVar2.f13441a != c2) {
            return (a) null;
        }
        return aVar2;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public boolean mo16078a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!m16090a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: b */
    public ByteBuffer mo16079b(String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (allocate.remaining() < 6) {
                allocate = AbstractC2601t.m16113a(allocate, allocate.position() + 6);
            }
            if (!m16091a(allocate, charAt)) {
                AbstractC2601t.m16116a(allocate, charAt);
            }
        }
        AbstractC2601t.m16115a(allocate);
        return allocate;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public String mo16077a(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = m16089a(bArr[i]);
        }
        return new String(cArr);
    }
}
