package com.p140g.p141a;

/* compiled from: DexLabel.java */
/* renamed from: com.g.a.b */
/* loaded from: classes.dex */
public class C1238b {

    /* renamed from: a */
    public String f8030a;

    /* renamed from: b */
    private int f8031b;

    public C1238b(int i) {
        this.f8031b = -1;
        this.f8031b = i;
    }

    public C1238b() {
        this.f8031b = -1;
    }

    public String toString() {
        if (this.f8030a != null) {
            return this.f8030a;
        }
        if (this.f8031b >= 0) {
            return String.format("L%04x", new Integer(this.f8031b));
        }
        return String.format("L%08x", new Integer(hashCode()));
    }
}
