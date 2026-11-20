package com.p065b.p066a.p068b.p077c;

import java.util.NoSuchElementException;

/* compiled from: OptionalIntCompat.java */
/* renamed from: com.b.a.b.c.b */
/* loaded from: classes.dex */
public final class C0628b {
    private static final C0628b EMPTY = new C0628b();

    /* renamed from: a */
    private final boolean f4222a;

    /* renamed from: b */
    private final int f4223b;

    private C0628b() {
        this.f4222a = false;
        this.f4223b = 0;
    }

    /* renamed from: a */
    public static C0628b m6192a() {
        return EMPTY;
    }

    private C0628b(int i) {
        this.f4222a = true;
        this.f4223b = i;
    }

    /* renamed from: a */
    public static C0628b m6193a(int i) {
        return new C0628b(i);
    }

    /* renamed from: b */
    public int m6194b() {
        if (!this.f4222a) {
            throw new NoSuchElementException("No value present");
        }
        return this.f4223b;
    }

    /* renamed from: c */
    public boolean m6195c() {
        return this.f4222a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0628b)) {
            return false;
        }
        C0628b c0628b = (C0628b) obj;
        boolean z = this.f4222a;
        if (z && c0628b.f4222a) {
            if (this.f4223b == c0628b.f4223b) {
                return true;
            }
        } else if (z == c0628b.f4222a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4222a) {
            return this.f4223b;
        }
        return 0;
    }

    public String toString() {
        return this.f4222a ? String.format("OptionalIntCompat[%s]", Integer.valueOf(this.f4223b)) : "OptionalIntCompat.empty";
    }
}
