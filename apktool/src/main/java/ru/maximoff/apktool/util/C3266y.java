package ru.maximoff.apktool.util;

/* compiled from: Heap.java */
/* renamed from: ru.maximoff.apktool.util.y */
/* loaded from: classes.dex */
public class C3266y {

    /* renamed from: a */
    private final long f20745a = 1048576;

    /* renamed from: b */
    private Runtime f20746b = Runtime.getRuntime();

    /* renamed from: c */
    private long f20747c = (this.f20746b.totalMemory() - this.f20746b.freeMemory()) / 1048576;

    /* renamed from: d */
    private long f20748d = this.f20746b.maxMemory() / 1048576;

    /* renamed from: e */
    private long f20749e = this.f20748d - this.f20747c;

    /* renamed from: a */
    public long m19709a() {
        return this.f20747c;
    }

    /* renamed from: b */
    public long m19710b() {
        return this.f20748d;
    }

    /* renamed from: c */
    public long m19711c() {
        return this.f20749e;
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Used memory: ").append(this.f20747c).toString()).append("MB. Available memory: ").toString()).append(this.f20749e).toString()).append("MB. Heap size: ").toString()).append(this.f20748d).toString()).append("MB.").toString();
    }
}
