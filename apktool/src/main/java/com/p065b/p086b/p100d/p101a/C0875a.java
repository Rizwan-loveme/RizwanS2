package com.p065b.p086b.p100d.p101a;

import java.util.HashMap;

/* compiled from: AddressMap.java */
/* renamed from: com.b.b.d.a.a */
/* loaded from: classes.dex */
public final class C0875a {

    /* renamed from: a */
    private final HashMap<Integer, Integer> f5331a = new HashMap<>();

    /* renamed from: a */
    public int m7447a(int i) {
        Integer num = this.f5331a.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public void m7448a(int i, int i2) {
        this.f5331a.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
