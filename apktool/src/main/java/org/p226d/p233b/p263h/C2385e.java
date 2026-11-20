package org.p226d.p233b.p263h;

import java.util.Arrays;
import java.util.List;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p269d.C2453g;

/* compiled from: InstructionOffsetMap.java */
/* renamed from: org.d.b.h.e */
/* loaded from: classes.dex */
public class C2385e {

    /* renamed from: a */
    private final int[] f12738a;

    public C2385e(List<? extends InterfaceC2218f> list) {
        this.f12738a = new int[list.size()];
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f12738a[i2] = i;
            i += list.get(i2).mo14417b();
        }
    }

    /* renamed from: a */
    public int m15082a(int i) {
        return m15083a(i, true);
    }

    /* renamed from: a */
    public int m15083a(int i, boolean z) {
        int binarySearch = Arrays.binarySearch(this.f12738a, i);
        if (binarySearch < 0) {
            if (z) {
                throw new b(i);
            }
            return (binarySearch ^ (-1)) - 1;
        }
        return binarySearch;
    }

    /* renamed from: b */
    public int m15084b(int i) {
        if (i < 0 || i >= this.f12738a.length) {
            throw new a(i);
        }
        return this.f12738a[i];
    }

    /* compiled from: InstructionOffsetMap.java */
    /* renamed from: org.d.b.h.e$b */
    public static class b extends C2453g {

        /* renamed from: a */
        private final int f12740a;

        public b(int i) {
            super("No instruction at offset %d", Integer.valueOf(i));
            this.f12740a = i;
        }
    }

    /* compiled from: InstructionOffsetMap.java */
    /* renamed from: org.d.b.h.e$a */
    public static class a extends C2453g {

        /* renamed from: a */
        private final int f12739a;

        public a(int i) {
            super("Instruction index out of bounds: %d", Integer.valueOf(i));
            this.f12739a = i;
        }
    }
}
