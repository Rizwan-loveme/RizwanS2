package com.p065b.p111c.p113b.p118c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: InclusiveIntRange.java */
/* renamed from: com.b.c.b.c.d */
/* loaded from: classes.dex */
public class C1056d {

    /* renamed from: a */
    private final int f6696a;

    /* renamed from: b */
    private final int f6697b;

    private C1056d(int i, int i2) {
        this.f6697b = i;
        this.f6696a = i2;
    }

    /* renamed from: a */
    public static C1056d m8849a(int i, int i2) {
        return new C1056d(i, i2);
    }

    /* renamed from: a */
    public static C1056d m8848a(int i) {
        return new C1056d(i, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public List<C1056d> m8850a(List<C1056d> list) {
        ArrayList arrayList;
        if (list.isEmpty()) {
            return Collections.singletonList(this);
        }
        int i = this.f6697b;
        ArrayList arrayList2 = null;
        int i2 = i;
        for (C1056d c1056d : list) {
            int i3 = c1056d.f6696a;
            if (i2 <= i3) {
                int i4 = c1056d.f6697b;
                if (i2 < c1056d.f6697b) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(m8849a(i2, i4 - 1));
                }
                ArrayList arrayList3 = arrayList2;
                if (i3 >= this.f6696a) {
                    return arrayList3 == null ? Collections.emptyList() : arrayList3;
                }
                i2 = i3 + 1;
                arrayList2 = arrayList3;
            }
        }
        if (i2 <= this.f6696a) {
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(1);
            }
            arrayList2.add(m8849a(i2, this.f6696a));
            arrayList = arrayList2;
        } else {
            arrayList = arrayList2;
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public String toString() {
        return "[" + this.f6697b + ", " + (this.f6696a < Integer.MAX_VALUE ? String.valueOf(this.f6696a) + "]" : "∞)");
    }
}
