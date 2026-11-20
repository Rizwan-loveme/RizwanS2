package com.p065b.p086b.p103f.p106c;

import android.app.slice.SliceItem;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;
import dalvik.bytecode.Opcodes;

/* compiled from: CstInteger.java */
/* renamed from: com.b.b.f.c.m */
/* loaded from: classes.dex */
public final class C0959m extends AbstractC0962p {

    /* renamed from: h */
    private static final C0959m[] f6156h = new C0959m[Opcodes.OP_CHECK_CAST_JUMBO];

    /* renamed from: a */
    public static final C0959m f6149a = m8060a(-1);

    /* renamed from: b */
    public static final C0959m f6150b = m8060a(0);

    /* renamed from: c */
    public static final C0959m f6151c = m8060a(1);

    /* renamed from: d */
    public static final C0959m f6152d = m8060a(2);

    /* renamed from: e */
    public static final C0959m f6153e = m8060a(3);

    /* renamed from: f */
    public static final C0959m f6154f = m8060a(4);

    /* renamed from: g */
    public static final C0959m f6155g = m8060a(5);

    /* renamed from: a */
    public static C0959m m8060a(int i) {
        int length = (Integer.MAX_VALUE & i) % f6156h.length;
        C0959m c0959m = f6156h[length];
        if (c0959m == null || c0959m.m8061k_() != i) {
            C0959m c0959m2 = new C0959m(i);
            f6156h[length] = c0959m2;
            return c0959m2;
        }
        return c0959m;
    }

    private C0959m(int i) {
        super(i);
    }

    public String toString() {
        int j = mo8064j();
        return "int{0x" + C1022m.m8552a(j) + " / " + j + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6251f;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return SliceItem.FORMAT_INT;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Integer.toString(mo8064j());
    }

    /* renamed from: k_ */
    public int m8061k_() {
        return mo8064j();
    }
}
