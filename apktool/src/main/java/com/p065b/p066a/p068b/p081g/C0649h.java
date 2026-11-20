package com.p065b.p066a.p068b.p081g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: InclusiveIntRange.java */
/* renamed from: com.b.a.b.g.h */
/* loaded from: classes.dex */
public class C0649h {

    /* renamed from: a */
    private final int f4247a;

    /* renamed from: b */
    private final int f4248b;

    private C0649h(int i, int i2) {
        this.f4248b = i;
        this.f4247a = i2;
    }

    /* renamed from: b */
    public int m6249b() {
        return this.f4248b;
    }

    /* renamed from: a */
    public int m6247a() {
        return this.f4247a;
    }

    /* renamed from: a */
    public static C0649h m6246a(int i, int i2) {
        return new C0649h(i, i2);
    }

    /* renamed from: a */
    public static C0649h m6245a(int i) {
        return new C0649h(i, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public List<C0649h> m6248a(List<C0649h> list) {
        List<C0649h> list2;
        if (list.isEmpty()) {
            return Collections.singletonList(this);
        }
        int i = this.f4248b;
        ArrayList arrayList = null;
        int i2 = i;
        for (C0649h c0649h : list) {
            int i3 = c0649h.f4247a;
            if (i2 <= i3) {
                int i4 = c0649h.f4248b;
                if (i2 < i4) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m6246a(i2, i4 - 1));
                }
                if (i3 >= this.f4247a) {
                    if (arrayList == null) {
                        return Collections.emptyList();
                    }
                    return arrayList;
                }
                i2 = i3 + 1;
            }
        }
        if (i2 <= this.f4247a) {
            if (arrayList == null) {
                arrayList = new ArrayList(1);
            }
            arrayList.add(m6246a(i2, this.f4247a));
            list2 = arrayList;
        } else {
            list2 = arrayList;
        }
        if (list2 == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.f4248b);
        sb.append(", ");
        if (this.f4247a < Integer.MAX_VALUE) {
            str = this.f4247a + "]";
        } else {
            str = "∞)";
        }
        sb.append(str);
        return sb.toString();
    }
}
