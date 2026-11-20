package org.p271f.p272a;

/* compiled from: TypePath.java */
/* renamed from: org.f.a.v */
/* loaded from: classes.dex */
public class C2530v {

    /* renamed from: a */
    byte[] f13286a;

    /* renamed from: b */
    int f13287b;

    C2530v(byte[] bArr, int i) {
        this.f13286a = bArr;
        this.f13287b = i;
    }

    /* renamed from: a */
    public int m15903a() {
        return this.f13286a[this.f13287b];
    }

    /* renamed from: a */
    public int m15904a(int i) {
        return this.f13286a[this.f13287b + (i * 2) + 1];
    }

    /* renamed from: b */
    public int m15905b(int i) {
        return this.f13286a[this.f13287b + (i * 2) + 2];
    }

    public String toString() {
        int m15903a = m15903a();
        StringBuilder sb = new StringBuilder(m15903a * 2);
        for (int i = 0; i < m15903a; i++) {
            switch (m15904a(i)) {
                case 0:
                    sb.append('[');
                    break;
                case 1:
                    sb.append('.');
                    break;
                case 2:
                    sb.append('*');
                    break;
                case 3:
                    sb.append(m15905b(i));
                    break;
                default:
                    sb.append('_');
                    break;
            }
        }
        return sb.toString();
    }
}
